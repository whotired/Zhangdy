package test.zhangdy.interview;

public class FinalTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Make a field final means that
		//1. If the field is primitive data type, final means the value can not be changed
		//2. If the field is pointed to an object,
		//   the reference can not be changed, but the referenced object can be changed the context
		final StringBuffer a=new StringBuffer("immutable");
//		a = new StringBuffer("");//compile error.
		a.append(" field.");//compile succeed.
		
		
	}

}
