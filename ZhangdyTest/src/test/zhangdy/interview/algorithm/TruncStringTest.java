package test.zhangdy.interview.algorithm;

/**
 * 3、编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串，但要保证汉字不被截取
 * 半个，如“我ABC”，4，应该截取“我AB”，输入“我ABC汉DEF”，6，应该输出“我ABC”，而不是“我ABC+汉的半个”。
 * 
 * 答：
       首先要了解中文字符有多种编码及各种编码的特征。
       假设n为要截取的字节数。
 * @author esw
 * 
 */
public class TruncStringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
        String str ="我a爱中华abc我爱传智def";
//        String str ="我ABC汉";
        int num =trimGBK(str.getBytes("UTF-16"),6);
        System.out.println(str.substring(0,num));
	}

	public static int trimGBK(byte[] buf, int n) {
		int num = 0;
		boolean bChineseFirstHalf = false;
		for (int i = 0; i < n; i++) {
			if (buf[i] < 0 && !bChineseFirstHalf) {
				bChineseFirstHalf = true;
			} else {
				num++;
				bChineseFirstHalf = false;
			}
		}
		return num;
	}

}
