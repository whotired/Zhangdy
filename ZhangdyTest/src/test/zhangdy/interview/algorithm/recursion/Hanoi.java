package test.zhangdy.interview.algorithm.recursion;

/**
 * 汉诺塔问题
   这是递归的超经典的例子，几乎每本程序设计书上谈到递归都会介绍。具体情景不再赘述。以我上述的方法观之：
   （1）递归的出口在于盘子数为1的时候 。
   （2）向出口逼近：如果不是1，是n ，则我们先挪动上面n-1块盘子，等上面挪完，即递归返回的时候，我们挪动
   最底下的盘子。
   
   me:	汉诺塔（港台：河內塔）是根据一个传说形成的數學问题：
	有三根杆子A，B，C。A杆上有N个(N>1)穿孔圆盘，盘的尺寸由下到上依次变小。要求按下列规则将所有圆盘移至C杆：
		. 每次只能移动一个圆盘；
		. 大盘不能叠在小盘上面。
 * @author esw
 *
 */
public class Hanoi {  
    private final static String from = "盘子B";  
    private final static String to = "盘子C";  
    private final static String mid = "盘子A";  
    static int  count=0;
    public static void main(String[] args) {  
        String input = "3";  
        int num = Integer.parseInt(input);  
        Hanoi.move(num, from, mid, to);
        System.out.println(count);
        /*
         * result:
         *  移动盘子1 从盘子B到盘子C
			移动盘子2 从盘子B到盘子A
			移动盘子1 从盘子C到盘子A
			移动盘子3 从盘子B到盘子C
			移动盘子1 从盘子A到盘子B
			移动盘子2 从盘子A到盘子C
			移动盘子1 从盘子B到盘子C
			7
         */
    }  
    private static void move(int num, String from2, String mid2, String to2) {  
        if (num == 1) {  
            System.out.println("移动盘子1 从" + from2 + "到" + to2);count++;
        } else {  
            move(num - 1, from2, to2, mid2);
            System.out.println("移动盘子" + num + " 从" + from2 + "到" + to2);count++;  
            move(num - 1, mid2, from2, to2);
  
        }  
  
    }  
  
} 