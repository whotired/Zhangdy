package test.zhangdy.interview;

import java.io.IOException;


public class ExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new ExceptionTest().getInt();
		} catch (IOException e) {
			Throwable t = e.getCause();
			System.out.println("Chained exception: the cause of current exception is: "+t.getClass().getName());
		} catch (Exception cause){
			StackTraceElement elements[] = cause.getStackTrace();
		    for (int i = 0, n = elements.length; i < n; i++) {       
		        System.err.println(elements[i].getFileName()
		            + ":" + elements[i].getLineNumber() 
		            + ">> "
		            + elements[i].getMethodName() + "()");
		    }
		    cause.printStackTrace();
		}
	}
	/**
	 * Test chained exception:
	 * 
	 * @return
	 * @throws IOException
	 */
	public int getInt() throws IOException {
		try{
			String str = null;
			return str.length();
		}catch(NullPointerException e){
			throw new IOException(e);
		}
			
		
	}
	
}
