package test.zhangdy.interview;

import java.util.Comparator;
import java.util.TreeSet;


class Parent implements Comparable {
    private int age = 0;
    public Parent(int age){
       this.age = age;
    }
    public int compareTo(Object o){
       // TODO Auto-generated method stub
       System.out.println("method of parent");
       Parent o1 = (Parent)o;
       return age>o1.age?1:age<o1.age?-1:0;
    }
 
}
 
class Child extends Parent {
 
    public Child(){
       super(1);
    }
    public int compareTo(Object o){
 
           // TODO Auto-generated methodstub
           System.out.println("method of child");
//         Child o1 = (Child)o;
           return -1;
 
    }
}
 
class OtherObject{
	int age;
	public OtherObject(int _age){
		age = _age;
	}
}
/**
 * TreeSet 中的元素以红黑树（排序的二叉树）的数据结构存储，因为 TreeSet 底层是由 TreeMap 实现的。
 * TreeSet 中的元素是按照值的大小升序排列的。
 * TreeSet 中不允许存在重复的元素，如何判断元素重复？ 
 * 若元素实现了 Comparable，
 * 	第一个元素放入 TreeSet，此时不调用该元素的  compareTo()，该元素被作为 root 元素。
 * 	第二个元素放入 TreeSet，首先与 TreeSet 中的 root 元素作比较，调用第二个元素的 compareTo(root 元素)，
 * 		若返回 -1，则该元素作为 root 元素的左子节点，TreeSet.toString()为 {第二个元素,第一个元素}; 
 * 		若返回 1，则该元素作为 root 元素的右子节点，TreeSet.toString()为 {第一个元素，第二个元素}
 * 	第三个元素放入 TreeSet，首先与 TreeSet 中的 root 元素作比较，调用第三个元素的 compareTo( root 元素)，
 * 		若返回 -1，则该元素再与 root 的左子节点作比较，调用第三个元素的 compareTo( root 元素的左子节点)
 * 		若返回 1，则该元素再与 root 的右子节点作比较，调用第三个元素的 compareTo( root 元素的右子节点)
 * 		依次类推，直至叶子节点。
 * 
 * 若元素未实现 Comparable，
 * 	则需要在创建 TreeSet 时定义比较器，即调用包含了 Comparator 参数的构造器，并实现了方法 compare()
 * 		new TreeSet(new Comparator(){
 * 			public int compare(Object o1, Object o2){
 * 				return oo1.age < oo2.age ? -1:oo1.age > oo2.age ?1:0;
 * 			}
 * 		});
 * 当新插入元素时，会调用 compare(新插入的元素，红黑树的节点)来比较，首先从 root 元素开始比较。
 * 
 * 以上比较过程可参见 TreeSet.add() 或者 TreeMap.put(K key, V value) 的源代码。
 * 
 * TreeSet.toString() 得到的是二叉树中序遍历的升序的结果。
 * 
 * 
 * @author esw
 *
 */
public class TreeSetTest {
 
    /**
     * @paramargs
     */
    public static void main(String[] args) {
       // TODO Auto-generated method stub
       TreeSet set = new TreeSet();
//    	HashSet set = new HashSet();
       set.add(new Parent(4));
       set.add(new Child());
       set.add(new Parent(3));
       System.out.println(set.size());
       System.out.println(set.toString());
       /**
        * results:
        * 	method of child
			method of parent
			method of parent
			2
			[test.zhangdy.interview.Child@d483bc8d, test.zhangdy.interview.Parent@edadf727]
        */
       
       TreeSet set2 = new TreeSet(new Comparator(){
    	   public int compare(Object o1, Object o2){
    		   OtherObject oo1 = (OtherObject) o1;
    		   OtherObject oo2 = (OtherObject) o2;
    		   
    		   return oo1.age < oo2.age ? -1:oo1.age > oo2.age ?1:0;
    	   }
       });
       
       set2.add(new OtherObject(5));
       set2.add(new OtherObject(2));
       set2.add(new OtherObject(1));
       
    }
 
}
