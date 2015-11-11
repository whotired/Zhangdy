package test.zhangdy.interview;

public class MultiClass {
	public void test(){
		System.out.println("Here is MultiClass.test()");
		callOtherTest();
	}
	private void callOtherTest(){
		OtherClass oc = new OtherClass();
		oc.test();
	}
}

class OtherClass{
	public void test(){
		System.out.println("Here is OtherClass.test()");
	}
}
