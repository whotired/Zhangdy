package test.zhangdy.interview.algorithm;


import java.util.Arrays;
import java.util.Iterator;
 
/**
 * 5、说明生活中遇到的二叉树，用java实现二叉树
这是组合设计模式。
我有很多个(假设10万个)数据要保存起来，以后还需要从保存的这些数据中检索是否存在某个数据，
（我想说出二叉树的好处，该怎么说呢？那就是说别人的缺点），假如存在数组中，那么，碰巧要找的
数字位于99999那个地方，那查找的速度将很慢，因为要从第1个依次往后取，取出来后进行比较。平衡
二叉树（构建平衡二叉树需要先排序，我们这里就不作考虑了）可以很好地解决这个问题，但二叉树的
遍历（前序，中序，后序）效率要比数组低很多，原理如下图：
-----------------又一次临场写的代码---------------------------
*/

public class Node2{
    private Node2 left;
    private Node2 right;
    private int value;
    //private int num;
   
    public Node2(int value){
       this.value = value;
    }
    public void add(int value){
      
       if(value > this.value)
       {
           if(right != null)
              right.add(value);
           else
           {
              Node2 node = new Node2(value);             
              right = node;
           }
       }
       else{
           if(left != null)
              left.add(value);
           else
           {
              Node2 node = new Node2(value);             
              left = node;
           }         
       }
    }
   
    public boolean find(int value){
       if(value == this.value) return true;
       else if(value > this.value){
           if(right == null) return false;
           else return right.find(value);
       }else{
           if(left == null) return false;
           else return left.find(value);         
       }
 
    }
   
    public void display(){
       System.out.println(value);
       if(left != null) left.display();
       if(right != null) right.display();
      
    }
   
    /*public Iterator iterator(){
      
    }*/
   
    public static void main(String[] args){
       int[] values = new int[8];
       for(int i=0;i<8;i++){
           int num = (int)(Math.random() * 15);
           //System.out.println(num);
           //if(Arrays.binarySearch(values,num)<0)
           if(!contains(values,num))
              values[i] = num;
           else
              i--;
       }
      
       System.out.println(Arrays.toString(values));
      
       Node2 root = new Node2(values[0]);
       for(int i=1;i<values.length;i++){
           root.add(values[i]);
       }
      
       System.out.println(root.find(13));
      
       root.display();
      
    }
   
    public static boolean contains(int [] arr,int value){
       int i = 0;
       for(;i<arr.length;i++){
           if(arr[i] == value) return true;
          
       }
       return false;
    }
   
}