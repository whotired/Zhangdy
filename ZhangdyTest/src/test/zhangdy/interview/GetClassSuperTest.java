package test.zhangdy.interview;

public class GetClassSuperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//该方法若被子类的对象调用，getClass()方法仍然是调用的子类的 getClass() 方法。
	protected void testSuper(){
		System.out.println("Here is super class");
		System.out.println(this.getClass().getName());
	}
}
