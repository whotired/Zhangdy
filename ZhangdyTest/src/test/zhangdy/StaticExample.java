//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************
package test.zhangdy;

/**静态方法能被子类继承，不能被子类覆盖,可以被子类重载，子类也可以写自己的同名的静态方法
 * 以下的printa()为静态方法时，b1.printa();实际相当于StaticA.printa();
 * 子类StaticB中若声明printa()，则必须声明为static，否则就成了覆盖，但static方法不能被覆盖
 * 
 */
public class StaticExample {	
	public static void main(String[] args) {
		StaticA a1 = new StaticA();
		a1.printa();

		StaticB b1 = new StaticB();
		b1.printa();
		b1.printb();
		//result:
		//A
		//A
		//B
	}
}
