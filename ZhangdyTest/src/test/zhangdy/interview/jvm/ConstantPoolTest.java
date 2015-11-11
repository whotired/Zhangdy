package test.zhangdy.interview.jvm;

public class ConstantPoolTest {

	Byte be = 127;
	Short st = 127;
	Integer ir = 127;
	Long lg = 127l;
	Character cr = 0x7f;
	Boolean bn = false;
	String sg = "abcd";
	Float ft = 127f;
	
	/**
	 * Java的8种基本类型(Byte, Short, Integer, Long, Character, Boolean, Float, Double), 
	 * 除Float和Double以外, 其它六种都实现了常量池, 但是它们只在大于等于-128并且小于等于127时才使用
	 * 常量池。
	 * 
	 * 当我们给Integer赋值时，实际上调用了Integer.valueOf(int)方法
	 * Short valueOf(short s)
	 * Byte valueOf(byte b)
	 * Character.valueOf(char c)
	 * Long.valueOf(long l)
	 * 
	 * [-128,127]
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConstantPoolTest test = new ConstantPoolTest();
		test.testInteger();
		test.testChar();
		test.testLong();
		test.testInstanceAndLocalVar();
	}
	
	public void testInteger(){
		Integer a = 127;  
	    Integer b = 127;  
	    System.out.println("等于127:");  
	    System.out.println(a == b);  
	    System.out.println("*****************"); 
	  
	    a = 128;  
	    b = 128;  
	    System.out.println("等于128:");  
	    System.out.println(a == b);  
	    System.out.println("*****************");  
	  
	    a = -128;  
	    b = -128;  
	    System.out.println("等于-128:");  
	    System.out.println(a == b);  
	    System.out.println("*****************");  
	  
	    a = -129;  
	    b = -129;  
	    System.out.println("等于-129:");  
	    System.out.println(a == b);  
	    System.out.println("*****************");  
	  
	    // 测试Boolean  
	    System.out.println("测试Boolean");  
	    Boolean c = true;  
	    Boolean d = true;  
	    System.out.println(c == d);  
	    d = new Boolean(true);  
	    System.out.println(c == d);  
	    System.out.println("*****************");  
	    
	    /*
	     * result:
	     * 	等于127:
			true
			*****************
			等于128:
			false
			*****************
			等于-128:
			true
			*****************
			等于-129:
			false
			*****************
			测试Boolean
			true
			false

	     */
	}
	
	public void testChar(){
		System.out.println("测试Character");
		Character c1 = 0x80;
		Character c2 = 0x80;		
		System.out.println("等于0x80( 128 ):");  
		System.out.println(c1 == c2); 
		System.out.println("********");  
		
		c1 = 0x7f;
		c2 = 0x7f;
		System.out.println("等于0x7f( 127 ):");  
		System.out.println(c1 == c2); 
		System.out.println("*****************");  
		/*
		 * result:
		 *  测试Character
			等于0x80( 128 ):
			false
			********
			等于0x7f( 127 ):
			true
			*****************
		 */
	}
	
	public void testLong(){
		System.out.println("测试Long");
		Long c1 = 128l;
		Long c2 = 128l;		
		System.out.println("等于128:");  
		System.out.println(c1 == c2); 
		System.out.println("********");  
		
		c1 = 127l;
		c2 = 127l;
		System.out.println("等于127:");  
		System.out.println(c1 == c2); 
		System.out.println("********");  
		
		c1 = -128l;
		c2 = -128l;
		System.out.println("等于-128:");  
		System.out.println(c1 == c2); 
		System.out.println("*********"); 
		
		c1 = -129l;
		c2 = -129l;
		System.out.println("等于-129:");  
		System.out.println(c1 == c2); 
		System.out.println("*****************"); 
		
		/*
		 * result:
		 *  测试Long
			等于128:
			false
			********
			等于127:
			true
			********
			等于-128:
			true
			*********
			等于-129:
			false
			*****************
		 */
	}
	/**
	 * Byte/Short/Integer/Long/Character/Boolean/String
	 * 实例变量和局部变量都在该类型的常量池中
	 */
	public void testInstanceAndLocalVar(){
		
		System.out.println("测试实例变量和局部变量");
		
		System.out.println("测试Byte");
		Byte b = 127;
	    System.out.println(b == be); 
	    
	    System.out.println("测试Short");
		Short s = 127;
	    System.out.println(s == st);
	    
	    System.out.println("测试Integer");
		Integer a = 127;
	    System.out.println(a == ir);
	    
	    System.out.println("测试Long");
		Long l = 127l;
	    System.out.println(l == lg);
	    
	    System.out.println("测试Character");
		Character c = 0x7f;
	    System.out.println(c == cr);
	    
	    System.out.println("测试Boolean");
		Boolean bl = false;
	    System.out.println(bl == bn);
	    
	    System.out.println("测试String");
		String str = "abcd";
	    System.out.println(str == sg);
	    
	    System.out.println("测试Float");
		Float f = 127f;
	    System.out.println(f == ft);
	    
	    /*
	     * result：
	     *  测试实例变量和局部变量
			测试Byte
			true
			测试Short
			true
			测试Integer
			true
			测试Long
			true
			测试Character
			true
			测试Boolean
			true
			测试String
			true
			测试Float
			false
	     */
	    
	    
	}
}
