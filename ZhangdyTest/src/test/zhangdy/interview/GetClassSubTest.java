package test.zhangdy.interview;

public class GetClassSubTest extends GetClassSuperTest{

	public static void main(String[] args) {
		GetClassSubTest sub = new GetClassSubTest();
		sub.testGetClassMethod();
		/* results:
		 	test.zhangdy.interview.GetClassSubTest
		*/
		sub.test();
		/* results:
		 	Here is super class
			test.zhangdy.interview.GetClassSubTest
		*/
	}
	//getClass() 是final，不能被 override，super.getClass() 相当于 getClass()，
	//super.getClass().getName()返回的结果就是该类的类名,而不是父类的类名。
	public void testGetClassMethod(){
		System.out.println(super.getClass().getName());
	}
	public void test(){
		super.testSuper();
	}
}
