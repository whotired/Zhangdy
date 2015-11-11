//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************
package test.zhangdy.interview;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableA a = new SerializableA(100);
        String file = "/home/esw/b.out" ;
        FileOutputStream out = new FileOutputStream(file) ;
        ObjectOutputStream objOut = new ObjectOutputStream(out);
        System.out.println("Serialize start") ;
        System.out.println(a.b) ;
        System.out.println(a.a) ;
        //inner class
        a.type = new SerializableA.Type(400);
        System.out.println(a.type.getId()) ;
        
        objOut.writeObject(a);
        objOut.flush();
        objOut.close();
        
      
        FileInputStream in = new FileInputStream("/home/esw/b.out");
        ObjectInputStream objIn = new ObjectInputStream(in);
        System.out.println("DeSerialize start") ;
        SerializableA b =  (SerializableA)objIn.readObject();
        System.out.println(b.b) ;
        System.out.println(b.a) ;
        System.out.println(b.type.getId()) ;
        objIn.close();
        
        /*
         * 1. SerializableB 没有无参构造器：
         * result：
         *  Serialize start
			100
			1
			400
			DeSerialize start
			Exception in thread "main" java.io.InvalidClassException: test.zhangdy.SerializableA; test.zhangdy.SerializableA; no valid constructor
				at java.io.ObjectStreamClass.checkDeserialize(ObjectStreamClass.java:781)
				at java.io.ObjectInputStream.readOrdinaryObject(ObjectInputStream.java:1748)
				at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1344)
				at java.io.ObjectInputStream.readObject(ObjectInputStream.java:363)
				at test.zhangdy.SerialTest.main(SerialTest.java:38)
            2. SerializableB 有无参构造器
            result：
	            Serialize start
				100
				1
				400
				DeSerialize start
				10
				1
				400				

         */
       
    }

}
