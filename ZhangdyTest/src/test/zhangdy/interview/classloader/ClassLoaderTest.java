package test.zhangdy.interview.classloader;

import java.util.ArrayList;
import java.util.List;

class TestClassA{

	public void method(){
	
	        System.out.println("Loading ClassA");
	
	}

}

public class ClassLoaderTest extends ArrayList{

	public static void main(String args[]){
	
	        TestClassA testClassA = new TestClassA();
	        Virus v = new Virus();
	        testClassA.method();
	        
//	        ArrayList list = new ArrayList();
	        ClassLoaderTest test = new ClassLoaderTest();
	        test.removeRange(0, 0);
	        System.out.println("ArrayList classloader: "+ArrayList.class.getClassLoader());
	        System.out.println("testClassA classloader: "+testClassA.getClass().getClassLoader());
	        System.out.println("ClassLoaderTest classloader: "+ClassLoaderTest.class.getClassLoader());
	        
	}

}
