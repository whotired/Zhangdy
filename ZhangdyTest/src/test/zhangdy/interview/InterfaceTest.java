package test.zhangdy.interview;

public interface InterfaceTest {
	String s = "";
	void method();
//	static void method2(){}		//compile error, Java 8
//	default void method3(){} 	//compile error, Java 8
}
class Test{
	public static void main(String... args){
		String s = InterfaceTest.s; //InterfaceTest.s is final, can not be changed.
	}
}
