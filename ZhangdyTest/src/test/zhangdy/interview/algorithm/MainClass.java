package test.zhangdy.interview.algorithm;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 1、编写一个程序，将a.txt文件中的单词与b.txt文件中的单词交替合并到c.txt文件中，a.txt文件中的单词用
 * 回车符分隔，b.txt文件中用回车或空格进行分隔。
 * 
 * get class path, see "http://blog.csdn.net/inaoen/article/details/6893792" or
 * 					   "/java-interview/获取java类中的路径.html"
 * MainClass.class.getResource("").getPath(): 该 class 文件所在路径
 * 		= .../ZhangdyTest/bin/test/zhangdy/interview/algorithm/
 * MainClass.class.getResource("/").getPath()：应用的 classpath
 * 		= .../ZhangdyTest/bin/
 * FileWriter("c.txt"): 文件 c.txt 会被创建在 .../ZhangdyTest/ 下
 * 
 * important code:
 * 		while ((aWord = a.nextWord()) != null) {
			c.write(aWord + "\n");
		}
		String.split(regex)
 * 
 * @author esw
 * 
 */
public class MainClass {
			
	public static void main(String[] args) throws Exception {
		FileManager a = new FileManager("a.txt", new char[] { '\n' });
		FileManager b = new FileManager("b.txt", new char[] { '\n', ' ' });
		FileWriter c = new FileWriter("c.txt");
		String aWord = null;
		String bWord = null;
		while ((aWord = a.nextWord()) != null) {
			c.write(aWord + "\n");System.out.println(aWord + "\n");
			bWord = b.nextWord();
			if (bWord != null)
				c.write(bWord + "\n");System.out.println(bWord + "\n");
		}

		while ((bWord = b.nextWord()) != null) {
			c.write(bWord + "\n");System.out.println(bWord + "\n");
		}
		c.close();
	}

}

class FileManager {

	String[] words = null;
	int pos = 0;

	public FileManager(String filename, char[] seperators) throws Exception {
		//Get this class path:/home/esw/workspace/zhangdy/ZhangdyTest/bin/test/zhangdy/interview/algorithm/
		String path = MainClass.class.getResource("").getPath();
		File f = new File(path+filename);
		FileReader reader = new FileReader(f);
		char[] buf = new char[(int) f.length()];
		int len = reader.read(buf);
		String results = new String(buf, 0, len);
		String regex = null;
		if (seperators.length > 1) {
			regex = "\n | ";//"" + seperators[0] + "|" + seperators[1];
		} else {
			regex = "\n";//"" + seperators[0];
		}
		words = results.split(regex);
	}

	public String nextWord() {
		if (pos == words.length)
			return null;
		return words[pos++];
	}

}
