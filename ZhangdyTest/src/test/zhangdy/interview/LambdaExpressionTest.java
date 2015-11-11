package test.zhangdy.interview;

public class LambdaExpressionTest {

	interface IntegerMath {
        int operation(int a, int b);   
    }
  
    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }
 
    public static void main(String... args) {
    
    	LambdaExpressionTest myApp = new LambdaExpressionTest();
//        IntegerMath addition = (a, b) -> a + b;		//compile error, lambda expression is available in java 8?
//        IntegerMath subtraction = (a, b) -> a - b;
//        System.out.println("40 + 2 = " +
//            myApp.operateBinary(40, 2, addition));
//        System.out.println("20 - 10 = " +
//            myApp.operateBinary(20, 10, subtraction));    
    }

}
