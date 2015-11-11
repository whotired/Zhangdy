package test.zhangdy.interview.algorithm.sorting;

public class SelectSort {
	public static void main(String[] args) {
		int[] a = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 8 };
		System.out.println("排序之前：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		//Simple select sort
		System.out.println();
		long start = System.nanoTime();
		SelectSort sort = new SelectSort();
		sort.simpleSelectSort(a);
		long end = System.nanoTime();
		System.out.println("Simple Select Sort time: " + (end - start) + " nano");
		
		//Recusive Simple select sort
		start = System.nanoTime();
		sort.recursiveSelectSort(a, 0, a.length -1);
		end = System.nanoTime();
		System.out.println("Recusive Simple Select Sort time: " + (end - start) + " nano");
		
		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
	public void simpleSelectSort(int[] a){
		// 简单的选择排序
		for (int i = 0; i < a.length; i++) {
			int min = i;// 最小数的索引
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) { // 找出最小的数
					min = j;
				}
			}
			swap(a,i,min);

		}
		
	}
	private static void swap(int[] array, int i, int j) {
		int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
	
	public void recursiveSelectSort(int[] array, int p, int q){
		if (p < q){
			int min = findMin(array, p ,q);
			swap(array, p, min);
			recursiveSelectSort(array, p+1, q);
		}
	}
	private int findMin(int[] array, int p, int q){
		int min = p;
		for(int i = p+1; i<=q; i++){
			if (array[min] > array[i]){
				min = i;
			}
		}
		return min;
	}
}
