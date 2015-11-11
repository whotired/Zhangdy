//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************
package test.zhangdy;

public class StaticB extends StaticA{
	public static String x="B";
	public void printb()
	{
		System.out.println(x);
	}
	
	public void printa(String a) 	//wrong: This instance method cannot override the static method from StaticA
	{
		System.out.println(x2);
	}
}
