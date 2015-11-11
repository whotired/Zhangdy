package test.zhangdy.interview.algorithm.sorting;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args){  
//        int H[] = {3,1,5,7,2,4,9,6,10,8};
//        int H[] = {31,12,50,17,22,44,39,56,10,68};
//        System.out.print("初始值：");  
//        print(H,10);  
//        HeapSort(H,10);  
//        //selectSort(a, 8);  
//        System.out.print("结果：");  
//        print(H,10);  
		topK();
    }  
	
	static void print(int a[], int n){  
        for(int j= 0; j<n; j++){  
            System.out.print(a[j] +"  ");  
        }
        System.out.println();
    }  
      
      
      
    /** 
     * 已知H[s…m]除了H[s] 外均满足堆的定义 
     * 调整H[s],使其成为大顶堆.即将对第s个结点为根的子树筛选,  
     * 
     * @param H是待调整的堆数组 
     * @param s是待调整的数组元素的位置 
     * @param length是数组的长度 
     * 
     */  
	static void HeapAdjust(int H[],int s, int length)  
    {  
        int tmp  = H[s];  
        int child = 2*s+1; //左孩子结点的位置。(i+1 为当前调整结点的右孩子结点的位置)  
        while (child < length) {  
            if(child+1 <length && H[child]<H[child+1]) { // 如果右孩子大于左孩子(找到比当前待调整结点大的孩子结点)  
                ++child ;  
            }  
            if(H[s]<H[child]) {  // 如果较大的子结点大于父结点  
                H[s] = H[child]; // 那么把较大的子结点往上移动，替换它的父结点  
                s = child;       // 重新设置s ,即待调整的下一个结点的位置  
                child = 2*s+1;  
            }  else {            // 如果当前待调整结点大于它的左右孩子，则不需要调整，直接退出  
                 break;  
            }  
            H[s] = tmp;         // 当前待调整的结点放到比其大的孩子结点位置上  
        }  
        print(H,length);  
    }  
      
      
    /** 
     * 初始堆进行调整 
     * 将H[0..length-1]建成堆 
     * 调整完之后第一个元素是序列的最小的元素 
     */  
    static void BuildingHeap(int H[], int length)  
    {   
        //最后一个有孩子的节点的位置 i=  (length -1) / 2  
        for (int i = (length -1) / 2 ; i >= 0; --i)  
            HeapAdjust(H,i,length);  
    }  
    /** 
     * 堆排序算法 
     */  
    static void HeapSort(int H[],int length)  
    {  
        //初始堆  
        BuildingHeap(H, length);  
        //从最后一个元素开始对序列进行调整  
        for (int i = length - 1; i > 0; --i)  
        {  
            //交换堆顶元素H[0]和堆中最后一个元素  
            int temp = H[i]; H[i] = H[0]; H[0] = temp;  
            //每次交换堆顶元素和堆中最后一个元素之后，都要对堆进行调整  
            HeapAdjust(H,0,i);  
      }  
    }  
    
	static void topK(){
		//Build a big Array
		int length = (int)Math.pow(10, 3);
		int[] a = new int[length];
		for(int i=0; i< a.length; i++){
			a[i] = (int)(Math.random()*length);
		}
		//Create a new Array, and put 10000 number into it from above big Array.
		int rLength = (int)Math.pow(10, 2);
		int[] result = new int[rLength];
		for(int i=0; i< result.length; i++){
			result[i] = a[i];
		}
		
		//Build and initial the smallest heap
		BuildingHeapForSmallest(result, result.length);
		System.out.println(Arrays.toString(result));
		
		//Compare between the smallest in the heap with the big Array, 
		//if the value of big Array is bigger than the first element of the heap
		//put the value into the first of heap, then adjust the heap again.
		for(int i=0; i< a.length; i++){
			if (a[i] > result[0]){
				result[0] = a[i];
				HeapAdjustForSmallest(result,0,result.length);
			}
		}
		System.out.println(Arrays.toString(result));
	}
	static void BuildingHeapForSmallest(int H[], int length)  
	{   
	    //最后一个有孩子的节点的位置 i=  (length -1) / 2  
	    for (int i = (length -1) / 2 ; i >= 0; --i)  
	        HeapAdjustForSmallest(H,i,length);  
	}  
	static void HeapAdjustForSmallest(int H[],int s, int length)  
	{  
	    int tmp  = H[s];  
	    int child = 2*s+1; //左孩子结点的位置。(i+1 为当前调整结点的右孩子结点的位置)  
	    while (child < length) {  
	        if(child+1 <length && H[child]>H[child+1]) { // 如果右孩子大于左孩子(找到比当前待调整结点大的孩子结点)  
	            ++child ;  
	        }  
	        if(H[s]>H[child]) {  // 如果较大的子结点大于父结点  
	            H[s] = H[child]; // 那么把较大的子结点往上移动，替换它的父结点  
	            s = child;       // 重新设置s ,即待调整的下一个结点的位置  
	            child = 2*s+1;  
	        }  else {            // 如果当前待调整结点大于它的左右孩子，则不需要调整，直接退出  
	             break;  
	        }  
	        H[s] = tmp;         // 当前待调整的结点放到比其大的孩子结点位置上  
	    }   
	}
	
}
