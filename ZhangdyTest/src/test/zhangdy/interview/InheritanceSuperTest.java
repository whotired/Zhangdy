package test.zhangdy.interview;

import java.util.List;

public class InheritanceSuperTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int i = 10;
	public String s = "I am super s";
	
	protected void testSuper(){
		System.out.println("Here is super class");
		System.out.println(this.getClassName());
		System.out.println("i= "+i);
		System.out.println("s: "+s);
	}
	public String getClassName(){
		return "InheritanceSuperTest";
	}
	
	//若 super 类没有无参的构造器，则子类的构造器必须用 super 关键字明确调用父类其他构造器
	public InheritanceSuperTest(boolean is){
		
	}
	public InheritanceSuperTest(){
		
	}
	public static void hideThisMethod(){
		System.out.println("Super class: hideThisMethod.");
	}
}
