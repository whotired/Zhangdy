package test.zhangdy.interview.algorithm.recursion;

/**
 * 用递归的算法把数组中的N个数按颠倒的次序重新存放。
 * 
 * @author esw
 *
 */
public class Recursion {
	private int b[] = null;
	private int len = 0;

	public Recursion(int b[]) {
		this.b = b;
		this.len = b.length;
	}

	public void resevert(int i, int j) {
		if (i >= j)
			return;
		// ====================
		b[i] = b[i] + b[j];
		b[j] = b[i] - b[j];// 注意：这里没有通过第三方(另开内存)来实现两个变量的值交换
		b[i] = b[i] - b[j];
		// =========================

		resevert(i + 1, j - 1);
	}

	//数组顺序颠倒的实现，也可参见“algorithm/SwapDemo.java” -- 未使用递归而是使用循环。
	public static void swap(int a[]){
	   int len = a.length;
	   for(int i=0,j=a.length-1;i<j;i++,j--){ // 或使用 for(int i=0;i<a.length/2;i++) 效果同
	       int tmp = a[i];
	       a[i] = a[len-1-i];
	       a[len-1-i] = tmp;
	   }
	}
	public void printThis() {

		for (int i = 0; i < len; i++) {
			System.out.print(b[i] + " ");

		}
		System.out.println();
	}

	public static void main(String[] args) {
		int b[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int len = b.length;
		Recursion rec = new Recursion(b);
		System.out.println("数组起始的数为：");
		rec.printThis();
		rec.resevert(0, len - 1);
		System.out.println("数组经过倒转之后的数为：");
		rec.printThis();
	}
}