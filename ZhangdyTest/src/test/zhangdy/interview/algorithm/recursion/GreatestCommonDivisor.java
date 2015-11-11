package test.zhangdy.interview.algorithm.recursion;

/**
 * 求最大公约数
 * 最大公约数算法：给两个数，如果两个数相等，最大公约数是其本身；如果不等，取两个数相减的绝对值和两个数
 * 中最小的数比较，相等则为最大公约，不等则继续上面的算法，直到相等。

 * @author esw
 *
 */
public class GreatestCommonDivisor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		greatestCommonDivisor(13,39);
	}

	public static void greatestCommonDivisor(int num1, int num2){
		if (num1 == num2)
			System.out.println(num1);
		else{
			greatestCommonDivisor(Math.abs(num1 - num2),Math.min(num1, num2));
		}
	}
}
