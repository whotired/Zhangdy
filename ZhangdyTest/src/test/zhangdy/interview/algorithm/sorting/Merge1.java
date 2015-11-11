package test.zhangdy.interview.algorithm.sorting;

/**
 * one good implements. <br />
 *
 * 
 */
public class Merge1 {
 
        public static final int CUTOFF = 11;
 
        /**
	 * merge sort algorithm.
	 * 
	 * @param arr an array of Comparable item.
         * 1.here only use one temp array (think about it). <br />
         * 2.copy the element back after the sub merge operation. @see merge(T, T, int, int);
         * the above two points make it more efficient. <br />
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> void mergeSort( T[] arr ) {
                //you may use insertionSort instead when the arr.length is not that large.
		/*if ( arr.length < CUTOFF ) {
			insertionSort( arr );
			return;
		}*/
 
		T[] tmpArr = (T[]) new Comparable[arr.length];
 
		mergeSort(arr, tmpArr, 0, arr.length - 1);
	}
 
	/**
	 * internal method to make a recursive call to merge. <br />
	 * 
	 * @param arr an array of Comparable items. <br />
	 * @param tmpArr temp array to placed the merged result. <br />
	 * @param left left-most index of the subarray. <br />
	 * @param right right-most index of the subarray. <br />
	 */
	private static <T extends Comparable<? super T>> 
	void mergeSort( T[] arr, T[] tmpArr,
			int left, int right ) {
		//recursive way
		if ( left < right ) {
			int center = ( left + right ) / 2;
			mergeSort(arr, tmpArr, left, center);
			mergeSort(arr, tmpArr, center + 1, right);
			merge(arr, tmpArr, left, center + 1, right);
		}
 
		//loop instead， not working, do it youself.
                /*
                int n = 0, j;
		while ( true ) {
			int step = ( int ) Math.pow(2, ++n);
			int len = step / 2;
			int count = arr.length / step;
			int rpos;
 
			//previous pow(2, k) elements
			for ( j = 0; j < count; j++ ) {
				rpos = j + len;
				System.out.println(j+", "+rpos);
				merge( arr, tmpArr, j, rpos, rpos + len - 1);
			}
 
			//the rest elements
			//for () ;
 
			if ( step * 2 >= arr.length ) break; 
		}
                 */
	} 
 
	/**
	 * internal method to merge the sorted halves of a subarray. <br />
	 * 
	 * @param arr an array of Comparable items. <br />
	 * @param tmpArr temp array to placed the merged result. <br />
	 * @param leftPos left-most index of the subarray. <br />
	 * @param rightPos right start index of the subarray. <br />
	 * @param endPos right-most index of the subarray. <br />
	 */
	private static <T extends Comparable<? super T>> void merge( T[] arr, T[] tmpArr,
			int lPos, int rPos, int rEnd ) {
		int lEnd = rPos - 1;
		int tPos = lPos;
		int leftTmp = lPos;
 
		while ( lPos <= lEnd && rPos <= rEnd  ) {
			if ( arr[lPos].compareTo( arr[rPos] ) <= 0 )
				tmpArr[ tPos++ ] = arr[ lPos++ ];
			else 
				tmpArr[ tPos++ ] = arr[ rPos++ ];
		}
 
		//copy the rest element of the left half subarray.
		while ( lPos <= lEnd ) 
			tmpArr[ tPos++ ] = arr[ lPos++ ];
		//copy the rest elements of the right half subarray. (only one loop will be execute)
		while ( rPos <= rEnd ) 
			tmpArr[ tPos++ ] = arr[ rPos++ ];
 
		//copy the tmpArr back cause we need to change the arr array items.
		for ( ; rEnd >= leftTmp; rEnd-- )
			arr[rEnd] = tmpArr[rEnd];
	}
}
