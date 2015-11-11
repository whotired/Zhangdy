package test.zhangdy.interview;

/**
 * 此类只为验证外部类和嵌套类的调用情况，不能正确运行，会造成死循环
 * @author esw
 *
 */
public class NestedClassesTest {
	private static String outer_static_field_1 = "";
	private String outer_instance_field_1 = "";
	private static StaticNestedClass outer_static_staticNestedClass = new StaticNestedClass();
	private StaticNestedClass outer_instance_staticNestedClass = new StaticNestedClass();
	private static InnerClass outer_static_innerClass = new NestedClassesTest().new InnerClass();
	private InnerClass outer_instance_innerClass = new InnerClass();
	
	public static void outerStaticMethod(){
		StaticNestedClass staticClass = new StaticNestedClass();
//		InnerClass inner = new InnerClass();		
		return;
	}
	private void outerInstanceMethod(){
		new InnerClass().innerClass_instance_field_1 = "";
		new InnerClass().innerClassInstanceMethod();
		StaticNestedClass.staticClass_static_field_1 = "";
		StaticNestedClass.staticClassStaticMethod();
		new StaticNestedClass().staticClass_instance_field_1 = "";
		new StaticNestedClass().staticClassInstanceMethod();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*不论外部类的静态还是非静态方法，访问静态嵌套类或内部类成员时，
		 * 只要调用的是静态成员，可以直接用 外部类名.静态嵌套类名.成员名 来访问
		 * 只要调用的是实例成员，就需要创建嵌套对象实例再访问*/
		NestedClassesTest.StaticNestedClass testStaticNested = new NestedClassesTest.StaticNestedClass();
		testStaticNested.staticClass_instance_field_1 = "";
		testStaticNested.staticClassInstanceMethod();
		StaticNestedClass.staticClass_static_field_1 = "";
		NestedClassesTest.StaticNestedClass.staticClassStaticMethod();
		
		NestedClassesTest.InnerClass testInner = new NestedClassesTest().new InnerClass();
		testInner.innerClass_instance_field_1 = "";
		testInner.innerClassInstanceMethod();
	}
	
	public class InnerClass{
		
		String innerClass_instance_field_1 = "";
		/* Inner Class can not include static field or method */
//		static inner_sta_field_1 = ""; // compile error
//		static void staticMethod(){}   // compile error
		void innerClassInstanceMethod(){
			/*inner class can refer to the static field or method in outer class directly.*/
			outer_static_staticNestedClass = new StaticNestedClass();
			outerStaticMethod();
			/*inner class can refer to the instance field or method in outer class directly*/
			outer_instance_staticNestedClass = new StaticNestedClass(); 
			outerInstanceMethod();   									

		}
	}
	
	public static class StaticNestedClass{
		static String staticClass_static_field_1 = "";
		String staticClass_instance_field_1 = "";
		
		static void staticClassStaticMethod(){
			/*static nested class can refer to the static field or method in outer class directly.*/
			outer_static_staticNestedClass = new StaticNestedClass();
			outerStaticMethod();
			/*static nested class(static or instance method,static or instance block etc) 
			 * can not refer to the instance field or method in outer class directly
			 * static nested class need to create an object of outer class to reference  */
			new NestedClassesTest().outer_instance_staticNestedClass = new StaticNestedClass(); //compile error
			new NestedClassesTest().outerInstanceMethod();   
//			outer_instance_staticNestedClass = new StaticNestedClass(); //compile error
//			outerInstanceMethod();   									//compile error
		}
		void staticClassInstanceMethod(){
			/*static nested class can refer to the static field or method in outer class directly.*/
			outer_static_staticNestedClass = new StaticNestedClass();
			outerStaticMethod();
			/*static nested class(static or instance method,static or instance block etc) 
			 * can not refer to the instance field or method in outer class directly
			 * static nested class need to create an object of outer class to reference  */
			new NestedClassesTest().outer_instance_staticNestedClass = new StaticNestedClass(); //compile error
			new NestedClassesTest().outerInstanceMethod();   
//			outer_instance_staticNestedClass = new StaticNestedClass(); //compile error
//			outerInstanceMethod();   									//compile error
		}
	}
}
