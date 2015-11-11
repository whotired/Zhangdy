package test.zhangdy.interview.algorithm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 希尔排序（Shell Sort）
 * 
 * 一个更好理解的希尔排序实现：将数组列在一个表中并对列排序（用插入排序）。重复这过程，不过每次用更长的列来进行。
 * 最后整个表就只有一列了。
 * 
 * @author Administrator
 *
 */
public class Shell {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List l = new ArrayList();
		for(int i= 0;i<20;i++){
			l.add((int)(Math.random()*100));
		}
		System.out.println("original array: "+l.toString());
		shellSort(l);
	}

	static <E extends Comparable<? super E>> void shellSort(List<E> a) {
	    int h = 1;
	    while (h < a.size()/3) {
	          h = h*3 + 1;    // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
	    }
	 
	    for (; h >= 1; h /= 3) {
	        for (int k = 0; k < h; k++) {
	        	for (int i = h + k; i < a.size(); i+=h) {
	            	System.out.println(a.toString());
	                for (int j = i; j >= h && a.get(j).compareTo(a.get(j-h)) < 0; j-=h) {
	                	Collections.swap(a, j, j-h);
	                	System.out.println(a.toString());
	                }
	            }
	        }
	    }
	    System.out.println(a.toString());
	}
}
