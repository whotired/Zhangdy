package test.zhangdy.interview;


public class OverloadOverrideTest {
	
	String getString(){
		return "Parent.getString method";
	}
	//private not inherited/override, subclass can not overloaded
	private String isMom(String sex,boolean is){
		return "Y";
	}
	private String isMom(String sex){
		return "Y";
	}
	//static inherited/overload, not override
	static String getAll(boolean is,String sex) throws Exception{
		return "";
	}
	//final inherited/overload, not override
	final boolean isDab(){
		return false;
	}
	
	class SubClass extends OverloadOverrideTest {
		@Override
		public String getString() {
			return "Child.getString method";
		}
		//a new method,not override/overload the isMom method of super class
//		String isMom(String sex,boolean is){
//			return "Y";
//		}
		
		String getAll(boolean is){
			return "SubClass.getAll";
		}
		
		boolean isDab(boolean is){
			return false;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		OverloadOverrideTest ot = new OverloadOverrideTest();
		OverloadOverrideTest.SubClass sc = ot.new SubClass();
		sc.getAll(true);

	}
	
	
	

}
