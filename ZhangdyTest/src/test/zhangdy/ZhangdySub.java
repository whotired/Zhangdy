package test.zhangdy;
//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************

public class ZhangdySub extends Zhangdy{
private String s = "";
	public ZhangdySub() {
		// TODO Auto-generated constructor stub
	}
//	void finalMethod(){}
//	void finalMethod(int i){}
//	
//	void accessMethod(){}
//	protected void accessMethod(){}
	
//	protected void privateMethod(){
//		System.out.println("Here is the ZhangdySub.finalMethod.");
//	}

	/**
	 * @param args
	 */
	public static String isStatic = "Y";
	public String isNotStatic = "N";
	static {
		System.out.println("Here is ZhangdySub static clause.");
		System.out.println("isStatic="+isStatic);
	}
	{
		System.out.println("Here is ZhangdySub not static clause.");
		System.out.println("isNotStatic="+isNotStatic);
	}
	public void baseMethod(Zhangdy zdy){
		System.out.println("Here is ZhangdySub" + zdy.toString());
	}
}
