package test.zhangdy.interview;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
 
public class IOTest implements Serializable{
	public String s = "I am IOTest 中国人";
	
	public static void main(String[]args) throws Exception {
        String str = "中国人";
        /*FileOutputStream fos  = new FileOutputStream("1.txt");
        
        fos.write(str.getBytes("UTF-8"));
        fos.close();*/
       
        /*FileWriter fw =new FileWriter("1.txt");
        fw.write(str);
        fw.close();*/
        PrintWriter pw =new PrintWriter("1.txt","utf-8");
        pw.write(str);
        pw.close();
 
       
        /*FileReader fr =new FileReader("1.txt");
        char[] buf = new char[1024];
        int len =fr.read(buf);
        String myStr = new String(buf,0,len);
        System.out.println(myStr);*/
        /*FileInputStreamfr = new FileInputStream("1.txt");
        byte[] buf = newbyte[1024];
        int len =fr.read(buf);
        String myStr = newString(buf,0,len,"UTF-8");
        System.out.println(myStr);*/
        BufferedReader br =new BufferedReader(
                      new InputStreamReader(
                             new FileInputStream("1.txt"),"UTF-8"
                             )
                      );
        String myStr =br.readLine();
        br.close();
        System.out.println(myStr);
        

        //将一个对象写入一个输出字节流时，该对象必须是可序列化的，否则报错
        //java object --> byte stream
        IOTest io = new IOTest();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(io);
        byte[] b = baos.toByteArray();
        oos.close();
        
        ByteArrayInputStream bais = new ByteArrayInputStream(b);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object obj = ois.readObject();
        IOTest ioNew = (IOTest)obj;
        System.out.println(ioNew.s);
        /*
         * 1. IOTest 未实现序列化时：
         * result：
         * Exception in thread "main" java.io.NotSerializableException: test.zhangdy.interview.IOTest
         
    	at java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1184)
    	at java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:347)
    	at test.zhangdy.interview.IOTest.main(IOTest.java:62)
    		2. IOTest 实现了序列化：
    		result： I am IOTest
    	*/
        new IOTest().readFileToByteArray();
        
   }
	/*
	 * 读取文件内容写入字节数组
	 */
	private void readFileToByteArray(){
		
		String fileName = "C:/_zhangdy/workspace/zhangdy/ZhangdyTest/bookstore.xml";
		FileInputStream fin = null;
		ByteArrayOutputStream bos = null;
		try {
			fin = new FileInputStream(fileName);
			bos = new ByteArrayOutputStream();
			
			// 读写方式 1：每次循环读取一个字节的数据
			int b = 0;
			while((b = fin.read()) != -1){
				bos.write(b);
			}
			// 读写方式 2：每次循环可以读取 bufferSize 数量的字节数据
			int bufferSize = 256; 
		    byte[] buffer = new byte[bufferSize]; 
		    int bytesNumRead = 0; 
		    while ((bytesNumRead = fin.read(buffer)) != -1) { 
		        bos.write(buffer, 0, bytesNumRead); 
		    } 
			byte[] bytes = bos.toByteArray();
			System.out.println("result bytes: ");
			System.out.println("    size: " + bytes.length);
			System.out.println("    array: " + bytes.toString());
			System.out.println("    String: " + bos.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				fin.close();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
 
}
