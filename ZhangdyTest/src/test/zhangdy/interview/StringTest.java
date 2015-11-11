package test.zhangdy.interview;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		 == ：基本类型比较值是否相等；对象类型比较变量中存储的对象的内存地址是否相同；
		 equals：不用于比较基本类型；对象类型比较变量指向的对象的内容是否相同。
		 */
		String ss1 = new String("foo");
		String ss2 = new String("foo");
		String ss3 = "foo";
		System.out.println("ss1==ss2: " + (ss1==ss2));
		System.out.println("ss1==ss3: " + (ss1==ss3));
		System.out.println("ss1.equals(ss2): " + ss1.equals(ss2));
		System.out.println("ss1.equals(ss3): " + ss1.equals(ss3));
		/* result:
		 	ss1==ss2: false
			ss1==ss3: false
			ss1.equals(ss2): true
			ss1.equals(ss3): true
		 */
		/*
		 关于 String 的总结：
		(1) 程序运行时会创建字符串常量缓冲池 String s="xyz" 创建字符串时，Java 首先从缓冲池寻找相同值的对象，若找到，则 s 指向该对象；
			若使用 new String("xyz")，则不会从缓冲池寻找，而是创建一个新的对象。
		(2) String 是不可变的类，s = "a"; s = s + "b"; s 先指向字符串 “a”，然后指向字符串“ab”，但字符串 “a”仍然存在，占用内存，所以，
			对于要改变内容的字符串，可以使用 StringBuffer 来改变数据，而不会多占用内存。
		(3) Javac 在编译时对字符串常量直接相加的情况 s ="a"+"b" 进行优化，即去掉加号，直接编译为相加的结果,即创建一个字符串对象“ab”
		 */
		String s = "ab";
		String s1 = "a";
		String s2 = s1 + "b";
		String s3 = "a" + "b";
		String s4 = new String("ab");
		String s5 = new String("ab");
		System.out.println("s2 == ab : " + (s2 == s));
		System.out.println("s3 == ab : " + (s3 == s));
		System.out.println("s4 == ab : " + (s4 == s));
		System.out.println("s5 == ab : " + (s5 == s));
		System.out.println("s4 == s5 : " + (s4 == s5));
		/* result:
		  	s2 == ab : false
			s3 == ab : true
			s4 == ab : false
			s5 == ab : false
			s4 == s5 : false
		 */
		String sss = "Hello world, I am Yan, I love my country";
		String array[] = sss.split(",");
		
		//hashcode
		String h1 = new String("hashcode");
		String h2 = new String("hashcode");
		System.out.println("h1.equals(h2) : " + (h1.equals(h2)));
		System.out.println("h1.hashcode() : " + (h1.hashCode()));
		System.out.println("h2.hashcode() : " + (h2.hashCode()));
		/*
		 * result:
		 *  h1.equals(h2) : true
			h1.hashcode() : 148649979
			h2.hashcode() : 148649979
		 */
		
		
	}

}
