//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************
package test.zhangdy;

/**
 * ��̬�����������ø���ľ�̬�����;�̬������
 * Ҳ�������þ�̬�����ڲ��ľֲ������������ķǾ�̬��������Ϊ��ʱ�ֲ������ѳ�ʼ����
 * ������������ķǾ�̬�����ͷ���
 */

public class StaticA {
	public static String x = "A";	//static field
	public String x2 = "A2";		//non-static field
	public static void printa()		//static method
	{
		System.out.println(x);		//right: can reference to static field
//		System.out.println(x2);		//wrong: Cannot make a static reference to the non-static field x2
//		printa3();					//right: can reference to static method
//		printa2();					//wrong: Cannot make a static reference to the non-static method printa2() from the type StaticA
//		Integer it = new Integer(1);//local variable
//		System.out.println(it);		//right: can reference to local variable
//		it.intValue();				//right: can call non-static of local variable
	}
	public void printa2()			//non-static method
	{
		System.out.println(x);
	}
//	public static void printa3()	//static method
//	{
//		System.out.println(x);
//	}
}
