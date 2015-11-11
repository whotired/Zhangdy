package test.zhangdy;

import java.text.DecimalFormat;

public class MathTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		getDecimal();
		testPow();
	}

	// 取小数点后几位
	private static void getDecimal(){
		long value = Long.MAX_VALUE;
		float decimal = (float)value/1024/1024;	// 等号右侧加 float，结果才包含小数位，否则会被取整	
		System.out.println("decimal_0 = " + decimal);
		
		//保留 3 位小数方法1
//		DecimalFormat df = new DecimalFormat("###.0000000000");
//		System.out.println(df.format(decimal));  
		
		//保留 3 位小数方法2
//		int n = (int)Math.pow(10, 3); 
//		decimal = (float)(Math.round(decimal*n))/n;
//		System.out.println(decimal);
//		System.out.println(n);
		
		StringBuffer format = new StringBuffer("##0.000");
		if (decimal < 1){
			DecimalFormat df0 = new DecimalFormat("##0.0000000");
			
			String sDecimal = df0.format(decimal);
			System.out.println("sDecimal = " + sDecimal);
			
			int pos = sDecimal.indexOf(".");
			sDecimal = sDecimal.substring(pos+1, sDecimal.length() -1);
			for (int i=0; i< sDecimal.length() - 1;i++){
				char cr = sDecimal.charAt(i);
				if (cr != '0'){
					break;
				}else{
					if (i >= 2) format.append("0");
					continue;
				}
			}
		}
		System.out.println("format = " +format);
		
		DecimalFormat df = new DecimalFormat(format.toString());
		System.out.println("DecimalFormat: " + df.format(decimal)); 
		
	}
	
	static void testPow(){
		double d = Math.pow(10, 3);
		System.out.println("d = " +d);
	}
}
