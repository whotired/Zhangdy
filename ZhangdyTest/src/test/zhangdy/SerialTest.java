//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************
package test.zhangdy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
//        SerializableA a = new SerializableA(100);
//        String file = "C:/b.out" ;
//        FileOutputStream out = new FileOutputStream(file) ;
//        ObjectOutputStream objOut = new ObjectOutputStream(out);
//        System.out.println("Serialize start") ;
//        a.setB(1000);
//        System.out.println(a.b) ;
//        System.out.println(a.a) ;
//        a.setId("02");
//        System.out.println(a.getId()) ;
//        //a.name = "name2";
//        System.out.println(a.name) ;
//        //inner class
//        a.type = new SerializableA.Type(400);
//        System.out.println(a.type.getId()) ;
//        objOut.writeObject(a);
//        objOut.flush();
//        objOut.close();
        
      
        FileInputStream in = new FileInputStream("C:/b.out");
        ObjectInputStream objIn = new ObjectInputStream(in);
        System.out.println("DeSerialize start") ;
        SerializableA b =  (SerializableA)objIn.readObject();
        System.out.println(b.b) ;
        System.out.println(b.a) ;
        System.out.println(b.getId()) ;
        System.out.println(b.name) ;
        System.out.println(b.type.getId()) ;
       
    }

}
