package test.zhangdy.interview;

public class InheritanceSubTest extends InheritanceSuperTest {

	private int i = 1;
	public String s = "I am sub s";
	
	//getClass() 是final，不能被 override，super.getClass() 相当于 getClass()，
	//super.getClass().getName()返回的结果就是该类的类名,而不是父类的类名。
	public void testGetClassMethod(){
		System.out.println(super.getClass().getName());
	}
	public void test(){
		super.testSuper();
	}
	
	protected void testSuper(){
		System.out.println("Here is super class");
		System.out.println(this.getClassName());
	}
	public String getClassName(){
		System.out.println("i= "+i);
		System.out.println("s: "+s);
		return "InheritanceSubTest";
	}
	
	//若 super 类没有无参的构造器，则子类的构造器必须用 super 关键字明确调用父类其他构造器
	public InheritanceSubTest(boolean is){
		super(is);
	}
	public InheritanceSubTest(){
		
	}	
	public static void hideThisMethod(){
		System.out.println("Sub class: hideThisMethod.");
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InheritanceSubTest sub = new InheritanceSubTest();
		sub.testGetClassMethod();
		
		//Test hide for static method:
		//所调用的被隐藏的静态方法依赖于是被父类调用还是被子类调用。
		//即使使用实例对象，则依赖于该变量的声明的是父类还是子类
		InheritanceSuperTest.hideThisMethod();
		InheritanceSuperTest sub2 = new InheritanceSubTest();
		sub2.hideThisMethod();
		/*
		 * result:
		 * Super class: hideThisMethod.
		   Super class: hideThisMethod.
		 * */
		
		InheritanceSubTest.hideThisMethod();
		InheritanceSubTest sub3 = new InheritanceSubTest();
		sub3.hideThisMethod();
		/*
		 * result:
		 * Sub class: hideThisMethod.
		 * Sub class: hideThisMethod.
		 * */
		
		

	}
	

}
