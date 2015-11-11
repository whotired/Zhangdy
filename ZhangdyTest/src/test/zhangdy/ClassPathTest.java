//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************
package test.zhangdy;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

public class ClassPathTest extends TestCase {
	/** E:/esw/workspace/rtc/shopz37/ShopzAPI/UnitTest/test/zhangdy/ClassPathTest.java*/
	/** E:/esw/workspace/rtc/shopz37/ShopzAPI/bin/test/zhangdy/ClassPathTest.class*/
	protected void setUp() throws Exception {
	}
	public void testClassPath(){
		//获取当前类文件所在的目录
		//得到的路径若包含空格则显示为%20，故应去掉
		String dr = this.getClass().getResource("").getPath().replace("%20", " ");
		String dr2 = ClassPathTest.class.getResource("").getPath().replace("%20", " ");
		System.out.println("获取当前类文件所在的目录: " + dr);// /E:/esw/workspace/rtc/shopz37/ShopzAPI/bin/test/zhangdy/
		System.out.println("获取当前类文件所在的目录: " + dr2);// /E:/esw/workspace/rtc/shopz37/ShopzAPI/bin/test/zhangdy/
		String file =dr +"ClassPathTest.txt";
		File theFile = new File(file);
	}
	public void testClassPackagePath(){
		//获取当前类文件所在包的根目录
		//得到的包路径中若包含空格则正常显示，不会包含%20
		String dr = System.getProperty("user.dir").replace("\\", "/");
		System.out.println("获取当前类文件所在包的根目录: " + dr);// E:/esw/workspace/rtc/shopz37/ShopzAPI
		
	}
	public void testClassesDir(){
		//获取当前类文件所在的classes目录
		String dr = this.getClass().getResource("/").getPath();
		System.out.println("获取当前类文件所在的classes目录: " + dr);// /E:/esw/workspace/rtc/shopz37/ShopzAPI/bin/
	}
	public void testFileMethod(){
		//获取文件路径
		File file = new File("/");
		String path1 = "";
		try {
			path1 = file.getCanonicalPath();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path2 = file.getAbsolutePath();
		String path3 = file.getPath();
		System.out.println("获取所在驱动盘目录: " + path1);// E:\
		System.out.println("获取所在驱动盘目录: " + path2);// E:\
		System.out.println("获取相对路径: " + path3); // \
		
		//获取文件路径
		File file2 = new File("");
		String path21 = "";
		try {
			path21 = file2.getCanonicalPath();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path22 = file2.getAbsolutePath();
		String path23 = file2.getPath();
		System.out.println("获取所在工程根目录即类所在包的根目录: " + path21);// E:\esw\workspace\rtc\shopz37\ShopzAPI
		System.out.println("获取所在工程根目录即类所在包的根目录: " + path22);// E:\esw\workspace\rtc\shopz37\ShopzAPI
		System.out.println("获取相对路径: " + path23);//
	}
}
