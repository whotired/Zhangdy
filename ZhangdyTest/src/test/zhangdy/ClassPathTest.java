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
		//��ȡ��ǰ���ļ����ڵ�Ŀ¼
		//�õ���·���������ո�����ʾΪ%20����Ӧȥ��
		String dr = this.getClass().getResource("").getPath().replace("%20", " ");
		String dr2 = ClassPathTest.class.getResource("").getPath().replace("%20", " ");
		System.out.println("��ȡ��ǰ���ļ����ڵ�Ŀ¼: " + dr);// /E:/esw/workspace/rtc/shopz37/ShopzAPI/bin/test/zhangdy/
		System.out.println("��ȡ��ǰ���ļ����ڵ�Ŀ¼: " + dr2);// /E:/esw/workspace/rtc/shopz37/ShopzAPI/bin/test/zhangdy/
		String file =dr +"ClassPathTest.txt";
		File theFile = new File(file);
	}
	public void testClassPackagePath(){
		//��ȡ��ǰ���ļ����ڰ��ĸ�Ŀ¼
		//�õ��İ�·�����������ո���������ʾ���������%20
		String dr = System.getProperty("user.dir").replace("\\", "/");
		System.out.println("��ȡ��ǰ���ļ����ڰ��ĸ�Ŀ¼: " + dr);// E:/esw/workspace/rtc/shopz37/ShopzAPI
		
	}
	public void testClassesDir(){
		//��ȡ��ǰ���ļ����ڵ�classesĿ¼
		String dr = this.getClass().getResource("/").getPath();
		System.out.println("��ȡ��ǰ���ļ����ڵ�classesĿ¼: " + dr);// /E:/esw/workspace/rtc/shopz37/ShopzAPI/bin/
	}
	public void testFileMethod(){
		//��ȡ�ļ�·��
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
		System.out.println("��ȡ����������Ŀ¼: " + path1);// E:\
		System.out.println("��ȡ����������Ŀ¼: " + path2);// E:\
		System.out.println("��ȡ���·��: " + path3); // \
		
		//��ȡ�ļ�·��
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
		System.out.println("��ȡ���ڹ��̸�Ŀ¼�������ڰ��ĸ�Ŀ¼: " + path21);// E:\esw\workspace\rtc\shopz37\ShopzAPI
		System.out.println("��ȡ���ڹ��̸�Ŀ¼�������ڰ��ĸ�Ŀ¼: " + path22);// E:\esw\workspace\rtc\shopz37\ShopzAPI
		System.out.println("��ȡ���·��: " + path23);//
	}
}
