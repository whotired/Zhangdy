package test.zhangdy.interview.classloader;

public class ClassLoaderTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
        
		//类加载器的树状组织结构
		ClassLoader loader = ClassLoaderTree.class.getClassLoader(); 
        while (loader != null) { 
            System.out.println(loader.toString()); 
            loader = loader.getParent(); 
        } 
        /*
         * result:
         * 	 sun.misc.Launcher$AppClassLoader@f4b7419c
			 sun.misc.Launcher$ExtClassLoader@9e8b96ac
			 
		 * ps: 这里并没有输出引导类加载器，这是由于有些 JDK 的实现对于父类加载器是引导类加载器的情况，
		 * getParent()方法返回 null。
         */

        //系统类加载器（system class loader）：它根据 Java 应用的类路径（CLASSPATH）来加载 Java 类。
        //一般来说，Java 应用的类都是由它来完成加载的。可以通过 ClassLoader.getSystemClassLoader()来
        //获取它。
        System.out.println(ClassLoader.getSystemClassLoader().toString()); 
        /*
         * result:
         * 		sun.misc.Launcher$AppClassLoader@256d446b
         */
    } 

}
