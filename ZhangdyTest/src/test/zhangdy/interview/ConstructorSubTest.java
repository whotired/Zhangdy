package test.zhangdy.interview;

public class ConstructorSubTest extends ConstructorSuperTest{

	//子类的构造器（不论无参还是有参）都会默认去调用 super 类的无参构造器
	//若 super 类没有无参的构造器，则子类的构造器必须用 super 关键字明确调用父类其他构造器
	public ConstructorSubTest(boolean is){
		super(is);
	}
	public ConstructorSubTest(){
		super(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
