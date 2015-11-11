package test.zhangdy.interview.algorithm.recursion;

/**
 * 一列数的规则如下: 1、1、2、3、5、8、13、21、34...... 求第30位数是多少。
 * me: 这是 Fibonacci （斐波纳契）整数数列
 * 
 * @author esw
 *
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(f(30));
		System.out.println(f2(30));
	}

	// use recursion algorithm
	public static int f(int n){
		if (n==1 || n==2){
			return 1;
		}else{
			return f(n-1) + f(n-2);
		}
	}
	// use loop statement
	public static int f2(int n){
		if (n <=2) return 1;
		
		int s1=1,s2=1; 
		int s=0;
		for(int i=3; i<=n;i++){
			s = s1 + s2;
			s1 = s2;
			s2 = s;
		}
		return s;
	}
}
