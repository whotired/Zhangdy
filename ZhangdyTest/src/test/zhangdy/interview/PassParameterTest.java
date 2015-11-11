package test.zhangdy.interview;

public class PassParameterTest {
	public int x = 0;
	public int y = 0;
	static int k = 0;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public PassParameterTest(int x, int y){
		this.x=x;
		this.y=y;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PassParameterTest sub1 = new PassParameterTest(10,10);
		System.out.println("before move circle: x = "+sub1.getX() + ", y= "+sub1.getY());
		moveCircle(sub1,23,56);
		System.out.println("after move circle: x = "+sub1.getX() + ", y= "+sub1.getY());
		
		PassParameterTest sub21 = new PassParameterTest(100,100);
		PassParameterTest sub22 = new PassParameterTest(200,200);
		System.out.println("before move circle: x = "+sub21.getX() + ", y= "+sub21.getY());
		System.out.println("before move circle: x = "+sub22.getX() + ", y= "+sub22.getY());
		moveCircle(10,10,sub21,sub22);
		System.out.println("after move circle: x = "+sub21.getX() + ", y= "+sub21.getY());
		System.out.println("after move circle: x = "+sub22.getX() + ", y= "+sub22.getY());
		String s = "8888";
		move(s);
		System.out.println("after move s = "+s);
		//change Array
		int[] array = new int[]{1,2,3};
		System.out.println("before move array[0] = "+ array[0]);
		move(array);
		System.out.println("after move array[0] = "+ array[0]);
		
		/* 
		  results:
		  	before move circle: x = 10, y= 10
			after move circle: x = 33, y= 66
			before move circle: x = 100, y= 100
			before move circle: x = 200, y= 200
			after move circle: x = 110, y= 110
			after move circle: x = 210, y= 210
			after move s = 8888
			before move array[0] = 1
			after move array[0] = 4
		 */
		
	}
	//circle 该形参是一个对象的引用，该引用是值传递，即对其的改变在方法外即丢失，但引用指向的对象的改变在方法外被保留
	public static void moveCircle(PassParameterTest circle, int deltaX, int deltaY) {
	    // code to move origin of circle to x+deltaX, y+deltaY
	    circle.setX(circle.getX() + deltaX);
	    circle.setY(circle.getY() + deltaY);
	        
	    // code to assign a new reference to circle
	    circle = new PassParameterTest(0, 0);
	}
	public static void moveCircle(int k, int deltaY,PassParameterTest ... circles) {
		for(PassParameterTest circle : circles){
			// code to move origin of circle to x+deltaX, y+deltaY
		    circle.setX(circle.getX() + k);
		    circle.setY(circle.getY() + deltaY);
		        
		    // code to assign a new reference to circle
		    circle = new PassParameterTest(0, 0);
		}
	    
	}
	public static void move(String s){
		s = s.substring(2);//s = "sssssssssssss";
	}
	public static void move(int[] array){
		array[0] = 4;
	}
}
