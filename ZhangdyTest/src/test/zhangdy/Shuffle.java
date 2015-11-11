//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************
package test.zhangdy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

import junit.framework.TestCase;

import org.junit.Before;



public class Shuffle<T> extends TestCase{

	@Before
	public void setUp() throws Exception {
	}
	public void testSwap(){
		String[] args = {"I","like","you","too"};
//		List<String> list = new ArrayList<String>();
//        for (String a : args)
//            list.add(a);
		List<String> list = Arrays.asList(args);
        Collections.shuffle(list, new Random());
        System.out.println(list);
	}
	/**为得到list的元素且得到该元素的index，可通过ListIterator的下列方法结合使用
	 * next() and previousIndex()一起使用
	 * previous() and nextIndex()一起使用
	 * 
	 * List.remove(); List.set(); ListIterator.remove();ListIterator.set();
	 */
	public void testListIterator(){
		
		String[] args = {"I","like","you","too"};
		List<String> list = new ArrayList<String>();
		for (String a : args)
			list.add(a);
//		list.remove(1);  //output: like be removed
//		list.set(1,"hate");//output: like be overwritten
		for (ListIterator<String> it = list.listIterator(); it.hasNext();){
			String s = it.next();
//			if (s.equals("like")) it.set("hate");
			int index = it.previousIndex();
			System.out.println(index + " : " + s);
		}
//		output:
//			0 : I
//			1 : like
//			2 : you
//			3 : too
		for (ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious();){
			String s = it.previous();
//			it.remove();//执行该行后，下一个for循环不再执行，因为List的元素都被删除了
			int index = it.nextIndex();
			System.out.println(index + " : " + s);
			
		}
//		output:
//			3 : too
//			2 : you
//			1 : like
//			0 : I
		
		//subList(),调用该方法得到的子list，和原来的list是互相映射的，一个改变则都改变
		List<String> sublist = list.subList(1,3);
		System.out.println("sublist: "+sublist);
		sublist.remove(0);
		System.out.println("after modifing the sublist");
		System.out.println("sublist: "+sublist);
		System.out.println("list: " +list);
//		output:
//			sublist: [like, you]
//			after modifing the sublist
//			sublist: [you]
//			list: [I, you, too]
	}
	 
}
