package test.zhangdy.interview.classloader;

import java.lang.reflect.Method;

public class ClassIdentity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassIdentity t = new ClassIdentity();
		t.testClassIdentity();
	}

	public void testClassIdentity() {
		String classDataRootPath = "/home/esw/workspace/zhangdy/ZhangdyTest/bin";
		FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
		System.out.println("Classloader 1: " + fscl1.toString());
		FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
		System.out.println("Classloader 2: " + fscl2.toString());
		
		String className = "test.zhangdy.interview.classloader.Sample";
		try {
			Class<?> class1 = fscl1.findClass(className);
			System.out.println("Class 1' Classloader: " + class1.getClassLoader());
			
			Object obj1 = class1.newInstance();
			System.out.println("obj1' Classloader: " + obj1.getClass().getClassLoader()+"<--"+obj1.getClass().getClassLoader().getParent());
			
			Class<?> class2 = fscl2.findClass(className);
			System.out.println("Class 2' Classloader: " + class2.getClassLoader());
			
			Object obj2 = class2.newInstance();
			System.out.println("obj2' Classloader: " + obj2.getClass().getClassLoader()+"<--"+obj2.getClass().getClassLoader().getParent());
			
//			Method setSampleMethod = class1.getMethod("setSample",
//					java.lang.Object.class);
//			setSampleMethod.invoke(obj1, obj2);
			
//			Sample sample = (Sample)obj1;
//			sample.packageMethod();
			Method packageMethod = class1.getMethod("packageMethod", null);
			packageMethod.invoke(obj1, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
