package test.zhangdy.interview;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 主要代码
 * 		URL url = new URL(uriString);	
 * 		HttpURLConnection httpUrl = (HttpURLConnection)url.openConnection();
 * 		httpUrl.connect();
 * 		httpUrl.getInputStream()
 * 		httpUrl.setRequestProperty("RANGE", "bytes="+startl+"-");
 * java多线程下载和断点续传:
 * http://zouhuajian01.blog.163.com/blog/static/1176987720113291103129/
 * @author esw
 *
 */
public class DownloadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(Calendar.getInstance().getTime());
            
            
			String uriString = "http://download.microsoft.com/download/9/5/A/95A9616B-7A37-4AF6-BC36-D6EA96C8DAAE/dotNetFx40_Full_x86_x64.exe";//http://sound2.tingroom.com/english96ad/lesson/zhichangshejiao/sound/7816aefddbcaecfb.mp3";
			int pos = uriString.lastIndexOf("/");
			int pos2 = uriString.indexOf("?");
			String downloadFileName = uriString.substring(pos + 1, uriString.length());
			URL url = new URL(uriString);	
			HttpURLConnection httpUrl = (HttpURLConnection)url.openConnection();
			httpUrl.connect();
			
			BufferedInputStream bis = new BufferedInputStream(httpUrl.getInputStream()); 
			FileOutputStream fos = new FileOutputStream(downloadFileName); 
            int bufferSize = 4096; 
            byte[] buffer = new byte[bufferSize]; 
            int bytesNumRead = 0; 
            while ((bytesNumRead = bis.read(buffer)) != -1) { 
            	fos.write(buffer, 0, bytesNumRead); 
            }
            System.out.println(Calendar.getInstance().getTime());
			
            
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
