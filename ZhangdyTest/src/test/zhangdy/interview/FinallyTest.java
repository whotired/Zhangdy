package test.zhangdy.interview;

/**
 * try-catch-finally:
	If "throw" an exception or "return" from catch clause, 
	the code after catch clause will never been excuted. 
	If no "throw" or no "return", the code after catch clause will be excuted. 
	finally clause will always been excuted whatever there is exception or not.
	
	If there is return in the try, then the finally will be excuted after return clause.
	Return 并不是让函数马上返回，而是 return 语句执行后，将把返回结果放置进函数栈中，此时函数并不是
	马上返回，它要执行 finally 语句后才真正开始返回。

 * @author esw
 *
 */
public class FinallyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new FinallyTest().test());
		/*
		 * result:
		 	func1
			func2
			2
		 */
	}
	int test()
    {
		try
	   {
	       return func1();
	   }
	   finally
	   {
	       return func2();
	   }
       
    }
	int func1()
	{
	    System.out.println("func1");
	   return 1;
	}
	int func2()
	{
	   System.out.println("func2");
	   return 2;
	} 

}
