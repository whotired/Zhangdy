package test.zhangdy.interview;

public class Thread55_2Test {

	/**
	 * 55、设计4个线程，其中两个线程每次对j增加1，另外两个线程对j每次减少1。写出程序。
	 * @param args
	 */
	JManager j =new JManager();
	public static void main(String args[]){
		new Thread55_2Test().call();
	}

	void call()
	{
	   for(int i=0;i<2;i++)
	   {
	        new Thread(
	               new Runnable(){ public void run(){while(true){j.accumulate();}}}
	        ).start();
	        new Thread(new Runnable(){ public void run(){while(true){j.subtract();}}}).start();
	   }
	}

}
class JManager
{
   private int j = 0;
  
   public synchronized void subtract()
   {
        j--;
   }
  
   public synchronized void accumulate()
   {
        j++;
   }
  
}
