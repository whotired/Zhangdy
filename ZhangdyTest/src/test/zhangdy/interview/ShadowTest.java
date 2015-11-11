package test.zhangdy.interview;

public class ShadowTest {

	private int x = 0;
	
	class FirstLevel{
		private int x = 1;
		
		void methodInFirstLevel(int x){
			 System.out.println("x = " + x);
	         System.out.println("this.x = " + this.x);
	         System.out.println("ShadowTest.this.x = " + ShadowTest.this.x);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShadowTest st = new ShadowTest();
		ShadowTest.FirstLevel first = st.new FirstLevel();
		first.methodInFirstLevel(25);
		
		/* results:
		 	x = 25
			this.x = 1
			ShadowTest.this.x = 0
		 */
	}

}
