//**********************************************************************
//IBM Confidential OCO Source Materials
//Program Number xxxx-xxx
//Copyright (c) 2008 IBM Corp. All Rights Reserved.
//The source code for this program is not published or otherwise
//divested of its trade secrets, irrespective of what has been
//deposited with the U.S. Copyright Office.
//*********************************************************************
package test.zhangdy;



public class SerializableA extends SerializableB  {

    public SerializableA(int b) {
        super(b);
    }
    /**
     *
     */
   // private static final long serialVersionUID = 1L;
    private String id = "01";
    final String name = "name1";
    public int a = 1 ;
    public void setId(String id){
    	this.id = id;
    }
    public String getId(){
    	return this.id;
    }
    //
    Type type = new Type(300);
    
    public static class Type implements java.io.Serializable{
    	public static final Type TYPE1 = new Type(100);
    	public static final Type TYPE2 = new Type(200);
	      private static int id;
	      
	      public  Type(int _id) {
	         id = _id;
	      }
	      public static int getId() {
	         return id;
	      } 
	      public static void setId(int _id) {
		     id = _id;
		  } 
	   } 
} 