package test.zhangdy.interview.algorithm.recursion;

/**
 * 求 n 的阶乘
 * 
 * @author esw
 *
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(f(6));
		System.out.println(f2(6));
	}
	// use recursion algorithm
	public static int f(int n){
		if(n == 0 || n == 1)
		{
			return 1;
		}
		else
		{
			return n*f(n-1); //自己调用自己，求n-1的阶乘
		}
	}
	// use loop statement
	public static int f2(int n){
		if (n <=1)
			return 1;
		
		int s = 1;
		for (int i=2; i<=n; i++){
			s = s * i;
		}
		return s;
	}

}
