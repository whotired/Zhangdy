package test.zhangdy.interview.jvm;

public class JVMMemory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("最大可用内存，对应-Xmx: "+Runtime.getRuntime().maxMemory() / 1024 /1024 + " M"); 
		 
		System.out.println("当前JVM空闲内存: "+Runtime.getRuntime().freeMemory() / 1024 /1024 + " M");

		System.out.println("当前JVM占用的内存总数，其值相当于当前JVM已使用的内存及freeMemory()的总和: "+
								Runtime.getRuntime().totalMemory() / 1024 /1024 + " M");
	}

}
