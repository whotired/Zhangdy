//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************
package test.zhangdy;

/**��̬�����ܱ�����̳У����ܱ����า��,���Ա��������أ�����Ҳ����д�Լ���ͬ���ľ�̬����
 * ���µ�printa()Ϊ��̬����ʱ��b1.printa();ʵ���൱��StaticA.printa();
 * ����StaticB��������printa()�����������Ϊstatic������ͳ��˸��ǣ���static�������ܱ�����
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
