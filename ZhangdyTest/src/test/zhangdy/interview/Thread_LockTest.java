package test.zhangdy.interview;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Thread_LockTest {

	private int j;
    private Lock lock =new ReentrantLock();
    
	/**
	 * 54、简述synchronized和java.util.concurrent.locks.Lock的异同
	 * 主要相同点：Lock 能完成 synchronized 所实现的所有功能
	 * 主要不同点：Lock 有比 synchronized 更精确的线程语义和更好的性能。synchronized 会自动释放锁，
	 * 而 Lock一定要求程序员手工释放，并且必须在 finally 从句中释放。Lock 还有更强大的功能，例如，
	 * 它的 tryLock方法可以非阻塞方式去拿锁。举例说明（对下面的题用lock进行了改写）：
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread_LockTest tt = new Thread_LockTest();
	       for(int i=0;i<2;i++)
	       {
	           new Thread(tt.new Adder()).start();
	           new Thread(tt.new Subtractor()).start();
	       }
	}
	private class Subtractor implements Runnable
    {
 
       @Override
       public void run() {
           // TODO Auto-generated method stub
           while(true)
           {
              /*synchronized (Thread_LockTest.this) {       
                  System.out.println("j--="+ j--);
                  //这里抛异常了，锁能释放吗？
              }*/
              lock.lock();
              try
              {
                  System.out.println("j--="+ j--);
              }finally
              {
                  lock.unlock();
              }
           }
       }
      
    }
   
    private class Adder implements Runnable
    {
 
       @Override
       public void run() {
           // TODO Auto-generated method stub
           while(true)
           {
              /*synchronized (Thread_LockTest.this) {
              System.out.println("j++="+ j++); 
              }*/
              lock.lock();
               try
              {
                  System.out.println("j++="+ j++);
              }finally
              {
                  lock.unlock();
              }            
           }         
       }
      
    }

}
