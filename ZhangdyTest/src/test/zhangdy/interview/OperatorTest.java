package test.zhangdy.interview;

public class OperatorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// & bitwise AND, | bitwise inclusive OR, ^ bitwise exclusive OR 
		int i1 = 0x31 ;
		int i2 = 0x0f;
		int i3 = i1 & i2;
		int i4 = i1 | i2;
		int i5 = i1 ^ i2;
		System.out.println("binary i1: " +Integer.toBinaryString(i1));
		System.out.println("binary i2: " +Integer.toBinaryString(i2));
		System.out.println("i1 & i2: " +i3);
		System.out.println("binary i1 & i2: " +Integer.toBinaryString(i3));
		System.out.println("i1 | i2: " +i4);
		System.out.println("binary i1 | i2: " +Integer.toBinaryString(i4));
		System.out.println("i1 ^ i2: " +i5);
		System.out.println("binary i1 ^ i2: " +Integer.toBinaryString(i5));
		/*result:
			binary i1: 110001
			binary i2: 1111
			i1 & i2: 1
			binary i1 & i2: 1
			i1 | i2: 63
			binary i1 | i2: 111111
			i1 ^ i2: 62
			binary i1 ^ i2: 111110
		*/
		
		// ~ bitwise complement 按位取反
		byte i6 = ~(-1);
		System.out.println("~: " +i6);
		System.out.println("binary : " +Integer.toBinaryString(i6));
		/*result:
			~: -2
			
			How to get ~1：
			~ means bitwise Not 即按位取反，对于带符号的数据的第一位表示的是符号（0是正，1是负），～将符号位
			也取反，取反后的值是补码，要得到原码，可以采用补码的补码即原码。如：
			byte 1 的二进制是 0000 0001，则 ~1 即取反后是 1111 1110，该值是某个负数的补码形式，其原码即将
			该补码取补码，而取一个数的补码的就是将该数据取反后（符号位不取反）+1，所以此处的原码是 
			1000 0001 +1 = 1000 0010 = -2 
		*/
		
		// && condition-AND 有短路功能
		// & condition-AND 无短路功能
		String str = null;
		if(str != null && !str.equals("")){
			System.out.println("&& str is not null");
		}else{
			System.out.println("&& str is null");
		}
		try{
		if(str != null & !str.equals("")){
			System.out.println("& str is not null");
		}else{
			System.out.println("& str is null");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		//result: 
		// && str is null
		// Exception in thread "main" java.lang.NullPointerException
		// at test.zhangdy.interview.OperatorTest.main(OperatorTest.java:21)

		//primitive data type convert
		short s1 = 1;
//		s1 = s1 + 1;//compile error.the return type is "int" for "s1 + 1",can not be converted to short
		s1 += 1; // compile succeed.
		
		//shift operator: 位移
		// signed left shift <<, signed right shift >>, unsigned right shift >>>
		int k = -11;
		System.out.println("k= "+ k);
		System.out.println("k << 30 "+ (k << 30));
		System.out.println("binary k= "+ Integer.toBinaryString(k));
		System.out.println("binary k << 3= "+ Integer.toBinaryString(k << 30));
		System.out.println("binary k >> 3= "+ Integer.toBinaryString(k >> 5));
		System.out.println("binary k >>> 3= "+ Integer.toBinaryString(k >>> 5));
		/*result:
		 	binary k= 1100100
			binary k << 3= 1100100000
			binary k >> 3= 1100
			binary k >>> 3= 1100
			
			binary k= 11
			binary k << 3= 11000
			binary k >> 3= 0
			binary k >>> 3= 0
		 */
		byte ii = Byte.MAX_VALUE;
		byte ii2 = Byte.MIN_VALUE;
		Double db = new Double(Math.pow(2, 7));
		String d = db.toString();
		System.out.println("Integer.MAX_VALUE= "+ ii);
		System.out.println("Integer.MIN_VALUE= "+ ii2);
		System.out.println("d= "+ d);
	}

}
