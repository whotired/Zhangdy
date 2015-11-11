package test.zhangdy;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************

import com.ibm.swot.controldata.Month;

public class Zhangdy {
	
	final String name = "zhangdy";
	final static String isStatic = "Y";
	static{System.out.println("initial test: here is static clause");}
	{System.out.println("initial test: here is not static clause");}
	
	public Zhangdy() {
		// TODO Auto-generated constructor stub
	}
	final void finalMethod(){
		//"final" means can not be changed: 
		//the field value can not be changed; 
		//the method can not be overrided, but can be overloaded;
		//the class can not be inherited
		System.out.println("Here is the Zhangdy.finalMethod.");
	}
	protected void accessMethod(){
		//the subclass can not reduce the visibility of the inherited method.
		System.out.println("Here is the Zhangdy.accessMethod.");
	}
	private void privateMethod(){
		//the "private" method can not be overrided. 
		//the "private" method can not be inherited.
		//The same method written in the subclass is really an another method. 
		System.out.println("Here is the Zhangdy.privateMethod.");
	}
	public void testPrivateMethod(){
		System.out.println("Here is the Zhangdy.testPrivateMethod.");
		privateMethod();
	}
	public void testSwitch()
	   {  for (int i = 0; i < 4; i++)
	      {  switch(i)
	         {  case 0: 
	        	 	System.out.println("address1");
	        	 	continue;
	            case 1: 
	            	System.out.println("address2");
	            	continue;
	            case 2: 
	            	System.out.println("address3");
	            	continue;
	            case 3: 
	            	System.out.println("address4");
	            	continue;
	            case 4: 
	            	System.out.println("address5");
	            	continue;
	            case 5: 
	            	System.out.println("address6");
	            	continue;
	            case 6: 
	            	System.out.println("address7");
	            	continue;
	         }
	      }
	   }
	public void callBaseMethod(){
		baseMethod(this);
	}
	public void baseMethod(Zhangdy zdy){
		System.out.println("Here is Zhangdy" + zdy.toString());
	}
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) {
		//try-catch:
		//If "throw" an exception or "return" from catch clause, 
		//the code after catch clause will never been excuted. 
		//If no "throw" or no "return", the code that is after catch clause will be excuted. 
		//finally clause will always been excuted whatever there is exception or not.
//		try{
//			System.out.println("Here is inner try clause");
//			throw new Exception ("Here is an exception from Zhangdy.");
//		}catch(Exception e){
//			System.out.println("Here is inner catch clause");
//			e.printStackTrace();
////			throw new Exception("Here is an exception from Zhangdy...");
//		}finally{
//			System.out.println("Here is inner finally clause");
//		}
//		System.out.println("Here is after finally clause");
		
		//switch-case
//		Zhangdy zdy = new Zhangdy();
//		zdy.testSwitch();
//		zdy.testException();
//		Zhangdy sub = new ZhangdySub();
//		sub.callBaseMethod();
		//sub.finalMethod();
		
		String s = "205910088NN";
		System.out.println(s.substring(0,4));
		
	}
	public static void anotherStaticMethod(){
		System.out.println("Here is the Zhangdy.anotherStaticMethod.");
	}
	public void finalize(){
		System.out.println("Here is the Zhangdy.finalize.");
	}
	public void testException() throws NullPointerException{
		
	}

}
