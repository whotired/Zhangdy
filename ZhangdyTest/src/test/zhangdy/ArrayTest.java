package test.zhangdy;

import java.util.Arrays;

public class ArrayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayTest array = new ArrayTest();
		array.testArraySort();
	}

	void testArraySort(){
		String[] ss = {"a","b","e","d","f","z","f","g","y"};
		System.out.println("unsorted array: "+ Arrays.asList(ss));
		Arrays.sort(ss);
		System.out.println("sorted array: "+ Arrays.asList(ss));
	}
}
