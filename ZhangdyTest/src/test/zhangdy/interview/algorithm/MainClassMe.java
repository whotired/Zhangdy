package test.zhangdy.interview.algorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1、编写一个程序，将a.txt文件中的单词与b.txt文件中的单词交替合并到c.txt文件中，a.txt文件中的单词用
 * 回车符分隔，b.txt文件中用回车或空格进行分隔。
 * 
 * important code:
 * 			FileReader reader = new FileReader(fileName);
			BufferedReader br = new BufferedReader(reader);
			
			for(String record = br.readLine(); record != null; record = br.readLine()){
				StringTokenizer token = new StringTokenizer(record, delimeter);
				while(token.hasMoreTokens()){
					words.add(token.nextToken());
				}
			}
 * @author esw
 *
 */
public class MainClassMe {
	int pos = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			MainClassMe class1 = new MainClassMe();
			MainClassMe class2 = new MainClassMe();
			List words1 = class1.readFile("a.txt", "\n");
			List words2 = class1.readFile("b.txt", " \n");
			FileWriter writer = new FileWriter("c.txt");
		
			Iterator it1 = words1.iterator();
			while(it1.hasNext()){
				String aWord = (String)it1.next();
				writer.write(aWord+"\n");System.out.println(aWord + "\n");
				String bWord = class2.nextWord(words2);
				writer.write(bWord+"\n");System.out.println(bWord + "\n");
			}
			for(; class2.pos < words2.size(); ){
				String bWord = class2.nextWord(words2);
				writer.write(bWord+"\n");System.out.println(bWord + "\n");
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List readFile(String fileName, String delimeter){
		List words = new ArrayList();
		try {
			FileReader reader = new FileReader(fileName);
			BufferedReader br = new BufferedReader(reader);
			
			for(String record = br.readLine(); record != null; record = br.readLine()){
				StringTokenizer token = new StringTokenizer(record, delimeter);
				while(token.hasMoreTokens()){
					words.add(token.nextToken());
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return words;
	}
	public String nextWord(List words){
		String word = (String)words.get(pos);
		pos++;
		return word;
	}
}
