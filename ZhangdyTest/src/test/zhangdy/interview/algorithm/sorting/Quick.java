package test.zhangdy.interview.algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
 
public class Quick {
	
	public static void main(String[] args){
    	List<String> l = new ArrayList<String>(90);
		for(int i= 0;i<l.size();i++){
			l.add(String.valueOf((int)(Math.random()*(l.size()))));
		}
		String[] s = new String[l.size()];
		s = l.toArray(s);
		long start = System.nanoTime();
		sort(s, new Comparator<String>(){
			public int compare(String o1, String o2){
				return o1.compareTo(o2);
			}
		});
		long end = System.nanoTime();
		System.out.println("Quick sort time: " + (end - start));
		
//		//test Sort.java
//		Sort sort = new Sort();
//		start = System.nanoTime();
//		sort.quicksort(s);
//		end = System.nanoTime();
//		System.out.println("Efficient Quick sort time: " + (end - start));
		
    }
	
    public static final Random RND = new Random();
 
    private static void swap(Object[] array, int i, int j) {
        Object tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
 
    private static <E> int partition(E[] array, int begin, int end, Comparator<? super E> cmp) {
        int index = begin + RND.nextInt(end - begin + 1);
//        System.out.println("original array = " + Arrays.toString(array));
//        System.out.println("pivot index = " + index);
        E pivot = array[index];
        swap(array, index, end);	
        for (int i = index = begin; i < end; ++ i) {
            if (cmp.compare(array[i], pivot) <= 0) {
                swap(array, index++, i);
            }
//            System.out.println("sorted array = " + Arrays.toString(array));
        }
        swap(array, index, end);
//        System.out.println("sorted array = " + Arrays.toString(array));
//        System.out.println("partition index = " + index);
        return (index);
    }
 
    private static <E> void qsort(E[] array, int begin, int end, Comparator<? super E> cmp) {
        if (end > begin) {
            int index = partition(array, begin, end, cmp);
            qsort(array, begin, index - 1, cmp);
            qsort(array, index + 1,  end,  cmp);
        }
    }
 
    public static <E> void sort(E[] array, Comparator<? super E> cmp) {
        qsort(array, 0, array.length - 1, cmp);
    }
 
}
 
/*
 * more efficient implements for quicksort. <br />
 * use left, center and right median value (@see #median()) for the pivot, and
 * the more efficient inner loop for the core of the algorithm.
 */
class Sort {
 
     public static final int CUTOFF = 11;
 
    /**
     * quick sort algorithm. <br />
     * 
     * @param arr an array of Comparable items. <br />
     */
     public static <T extends Comparable<? super T>> void quicksort( T[] arr ) {
	 quickSort( arr, 0, arr.length - 1 );
     }
 
 
     /**
      * get the median of the left, center and right. <br />
      * order these and hide the pivot by put it the end of
      * of the array. <br />
      * 
      * @param arr an array of Comparable items. <br />
      * @param left the most-left index of the subarray. <br />
      * @param right the most-right index of the subarray.<br />
      * @return T
      */
      public static <T extends Comparable<? super T>> T median( T[] arr, int left, int right ) {
 
		int center = ( left + right ) / 2;
 
		if ( arr[left].compareTo( arr[center] ) > 0 )
			swapRef( arr, left, center );
		if ( arr[left].compareTo( arr[right] ) > 0 )
			swapRef( arr, left, right );
		if ( arr[center].compareTo( arr[right] ) > 0 )
			swapRef( arr, center, right );
 
		swapRef( arr, center, right - 1 );
		return arr[ right - 1 ];
      }
 
     /**
      * internal method to sort the array with quick sort algorithm. <br />
      * 
      * @param arr an array of Comparable Items. <br />
      * @param left the left-most index of the subarray. <br />
      * @param right the right-most index of the subarray. <br />
      */
      private static <T extends Comparable<? super T>> void quickSort( T[] arr, int left, int right ) {
		if ( left + CUTOFF <= right  ) {
			//find the pivot
			T pivot = median( arr, left, right );
 
			//start partitioning
			int i = left, j = right - 1;
			for ( ; ; ) {
				while ( arr[++i].compareTo( pivot ) < 0 ) ;
				while ( arr[--j].compareTo( pivot ) > 0 ) ;
				if ( i < j )
					swapRef( arr, i, j );
				else
					break;
			}
 
			//swap the pivot reference back to the small collection.
			swapRef( arr, i, right - 1 );
 
			quickSort( arr, left, i - 1 );		//sort the small collection.
			quickSort( arr, i + 1, right );		//sort the large collection.
 
		} else {
			//if the total number is less than CUTOFF we use insertion sort instead (cause it much more efficient).
			insertionSort( arr, left, right );
		}
      }
 
 
      /**
       * method to swap references in an array.<br />
       * 
       * @param arr an array of Objects. <br />
       * @param idx1 the index of the first element. <br />
       * @param idx2 the index of the second element. <br />
       */
      public static <T> void swapRef( T[] arr, int idx1, int idx2 ) {
		T tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
      }
 
 
      /**
       * method to sort an subarray from start to end
       * 		with insertion sort algorithm. <br />
       * 
       * @param arr an array of Comparable items. <br />
       * @param start the begining position. <br />
       * @param end the end position. <br />
       */
      public static <T extends Comparable<? super T>> void insertionSort( T[] arr, int start, int end ) {
		int i;
		for ( int j = start + 1; j <= end; j++ ) {
			T tmp = arr[j];
			for ( i = j; i > start && tmp.compareTo( arr[i - 1] ) < 0; i-- ) {
				arr[ i ] = arr[ i - 1 ];
			}
			arr[ i ] = tmp;
		}
      }
}
