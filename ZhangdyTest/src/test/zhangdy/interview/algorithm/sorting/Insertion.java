package test.zhangdy.interview.algorithm.sorting;

import java.util.Arrays;

/**
 * 插入排序（Insertion Sort）

	一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：

    (1) 从第一个元素开始，该元素可以认为已经被排序
    (2) 取出下一个元素，在已经排序的元素序列中从后向前扫描
    (3) 如果该元素（已排序）大于新元素，将该元素移到下一位置
    (4) 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
    (5) 将新元素插入到该位置后
    (6) 重复步骤2~5
    
 * @author Administrator
 *
 */
public class Insertion {  
    public static void insertionSort(Comparable []data){  
    	//从已有的无序数组中的第二个元素开始取
        for(int index=1;index<data.length;index++){  
            Comparable key = data[index];  
            int position = index;  
            //将新元素与它前面的元素依次从后向前的比较
            //shift larger values to the right  
            while(position>0&&data[position-1].compareTo(key)>0){
            	//若新元素大于当前已排序的元素，将该已排序的元素向后移动一个位置
                data[position] = data[position-1];  
                position--;  
            }  
            //最后找到的位置上新元素比该已排序元素小或等于
            data[position]=key;  
        }     
    }  
    public static void main(String []args){ 
    	Comparable[] c = new Comparable[90];
    	for(int i= 0; i< c.length; i++){
    		c[i] = String.valueOf((int)(Math.random()*(c.length)));
		}
    	long start = System.nanoTime();
        insertionSort(c); 
        long end = System.nanoTime();
		System.out.println("Insertion sort time: " + (end - start));
//		System.out.println("插入排序："+ Arrays.toString(c));
    }  
}
