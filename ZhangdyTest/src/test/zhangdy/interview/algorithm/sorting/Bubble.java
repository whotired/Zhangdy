package test.zhangdy.interview.algorithm.sorting;

/**
 * 冒泡排序（Bubble Sort）
 * 
 * 冒泡排序演算法的运作如下：
	. 比较相邻的元素。如果第一个比第二个大，就交换他们。
	. 对每一对相邻的元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
	. 针对所有的元素重复以上的步骤，除了最后一个。
	. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
	
   me: 有一个数组，长度 len，i，j 从 0 开始计数
   	   第0轮比较相邻元素，依次为：(第0个,第1个)，(第j个,第 j+1 个)，直到第 (len-2,len-1)
   	   	   该轮结束，最后的元素就是最大数，所以下次比较，该元素不参与比较。
   	   第1轮比较相邻元素，依次为：(第0个,第1个)，(第j个,第 j+1 个)，直到第 (len-3,len-2)
   	   	   该轮结束，倒数第二个元素就是倒数第二大数，所以下次比较，该元素不参与比较。
   	   第i轮比较相邻元素，依次为：(第0个,第1个)，(第j个,第 j+1 个)，直到第 (len-2-i,len-1-i)
   	   重复以上步骤后，最后一个元素不再需要比较，所以，共进行 len-1-1 轮
   	   所以，0<= i <=(len-1-1) , 0<= j <= (len-2-i)
   	   
 * @author esw
 *
 */
public class Bubble {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] number={95,45,15,78,84,51,24,12};
		int temp=0;
		for(int i=0;i<number.length-1;i++){
			for(int j=0;j<number.length-1-i;j++)
				if(number[j]>number[j+1]) {
					temp=number[j];
					number[j]=number[j+1];
					number[j+1]=temp;
				} //if end
			for(int k=0;k<number.length;k++) System.out.print(number[k]+" ");
			System.out.println();
		}
		for(int i=0;i<number.length;i++) System.out.print(number[i]+" ");
		System.out.println();
	} //main end
	
	/*
	 * result:
	 *  45 15 78 84 51 24 12 95 
		15 45 78 51 24 12 84 95 
		15 45 51 24 12 78 84 95 
		15 45 24 12 51 78 84 95 
		15 24 12 45 51 78 84 95 
		15 12 24 45 51 78 84 95 
		12 15 24 45 51 78 84 95 
		12 15 24 45 51 78 84 95
	 */

}
