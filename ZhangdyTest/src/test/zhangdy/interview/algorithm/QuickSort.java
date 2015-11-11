package test.zhangdy.interview.algorithm;

/**
 * 10、排序都有哪几种方法？请列举。用JAVA实现一个快速排序。
 本人只研究过冒泡排序、选择排序和快速排序，下面是快速排序的代码：
 
 * @author esw
 *
 */
public class QuickSort {
	/**
	 * 快速排序
	 * 
	 * @param strDate
	 * @param left
	 * @param right
	 */
	public void quickSort(String[] strDate, int left, int right) {
		String middle, tempDate;
		int i, j;
		i = left;
		j = right;
		middle = strDate[(i + j) / 2];
		do {
			while (strDate[i].compareTo(middle) < 0 && i < right)
				i++; // 找出左边比中间值大的数
			while (strDate[j].compareTo(middle) > 0 && j > left)
				j--; // 找出右边比中间值小的数
			if (i <= j) { // 将左边大的数和右边小的数进行替换
				tempDate = strDate[i];
				strDate[i] = strDate[j];
				strDate[j] = tempDate;
				i++;
				j--;
			}
		} while (i <= j); // 当两者交错时停止
		
		System.out.print("left="+left+" right="+right + ": ");
		for (int k = 0; k < strDate.length; k++) {
			System.out.print(strDate[k] + " ");
		}
		System.out.println();
		
		if (i < right) {
			quickSort(strDate, i, right);// 从
		}
		if (j > left) {
			quickSort(strDate, left, j);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String[] strVoid = new String[] { "11", "66", "22", "0", "55", "22",
//				"0", "32" };
		String[] strVoid = new String[] { "3", "7", "8", "0", "2", "1",
				"9", "5","4" };
		System.out.print("Original array: ");
		for (int i = 0; i < strVoid.length; i++) {
			System.out.print(strVoid[i] + " ");
		}
		System.out.println();
		QuickSort sort = new QuickSort();
		sort.quickSort(strVoid, 0, strVoid.length - 1);
		System.out.print("Changed array:  ");
		for (int i = 0; i < strVoid.length; i++) {
			System.out.print(strVoid[i] + " ");
		}
		/*
		 * result:
		 * 	Original array: 3 7 8 5 2 1 9 5 4 
			left=0 right=8: 1 2 8 5 7 3 9 5 4 
			left=2 right=8: 1 2 3 5 7 8 9 5 4 
			left=3 right=8: 1 2 3 5 7 4 5 9 8 
			left=7 right=8: 1 2 3 5 7 4 5 8 9 
			left=3 right=6: 1 2 3 5 5 4 7 8 9 
			left=3 right=5: 1 2 3 4 5 5 7 8 9 
			left=0 right=1: 1 2 3 4 5 5 7 8 9 
			Changed array:  1 2 3 4 5 5 7 8 9
		 */
	}

}
