package test.zhangdy.interview;

public class AssertTest {
	 
    /**
     * @paramargs
     */
    public static void main(String[] args) {
       // TODO Auto-generated method stub
       int i = 0;
       for(i=0;i<5;i++)
       {
           System.out.println(i);
       }
       //假设程序不小心多了一句--i;
       --i;
       
       /**
        * assertion:
        * 	syntax:
        * 		assert expression1;
        * 		assert expression1:expression2;
        * 			(expression1 --> boolean expression; 
        * 		 	expression2 --> as the param of AssertionError's constructor)
        *   enable assertion: -ea / -esa
        *   	java -ea AssertTest
        *   disable assertion: -da / -dsa
        *   	java -da AssertTest
        */
       try{
    	   assert i==5 : "This is an error.";
       }catch(Error e){
    	   System.out.println("Here is catch.");
       }
       /*
        * result:
        * 	0
			1
			2
			3
			4
			Here is catch.
        */
       
       assert i==5 : "This is an error.";
       /*
        * result:
        * 	0
			1
			2
			3
			4
			Exception in thread "main" java.lang.AssertionError: This is an error.
				at test.zhangdy.interview.AssertTest.main(AssertTest.java:18)

        */
       
    }
 
}
