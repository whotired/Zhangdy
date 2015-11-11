package test.zhangdy.javabase.codingpractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KeyboadReader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KeyboadReader reader = new KeyboadReader();
		reader.readOneChar();
		reader.readString();
//		reader.readUseScanner();
	}

	/**
	 * 方法一：从控制台接收一个字符，然后将其打印出来
	 */
	public void readOneChar(){
		System.out.print("Enter a Char:"); 
        char i;
		try {
			i = (char) System.in.read();
			System.out.println("your char is :"+i); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
	}
	
	/**
	 * 方法二：从控制台接收一个字符串，然后将其打印出来。 在这个题目中，我们需要用到BufferedReader类和InputStreamReader类
	 */
	public void readString(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String str = null; 
        System.out.println("Enter your value:"); 
        try {
			str = br.readLine();
			System.out.println("your value is :"+str); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
	}
	
	/**
	 * 方法三：这种方法我认为是最简单，最强大的，就是用Scanner类
	 */
	public void readUseScanner(){
		Scanner sc = new Scanner(System.in); 
        System.out.println("请输入你的姓名："); 
        String name = sc.next(); 
        System.out.println("请输入你的年龄："); 
        int age = sc.nextInt(); 
        System.out.println("请输入你的工资："); 
        float salary = sc.nextFloat(); 
        System.out.println("你的信息如下："); 
        System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"工资："+salary); 
	}
}
