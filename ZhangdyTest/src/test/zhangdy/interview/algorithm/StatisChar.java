package test.zhangdy.interview.algorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 4、有一个字符串，其中包含中文字符、英文字符和数字字符，请统计和打印出各个字符的个数。
 * 
 * me: 汉字的 unicode 编码范围 [\u4e00-\u9fa5],所以可用以下代码判断字符串中的汉字：
 * 		String str1 = "中国chin受到腐蚀的 sfsｓｆｓｓｄｆ ese";
		for(int i=0;i<str1.length();i++){
		    if(str1.substring(i, i+1).matches("[\u4e00-\u9fa5]")){
		        System.out.println(str1.subSequence(i, i+1)+"为汉字。");
		    }else{
		        System.out.println(str1.substring(i, i+1)+"不为汉字");
		    }
		}
		或者：
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher("中文fd我是中国人as ");

		while (m.find()) {

			for (int i = 0; i <= m.groupCount(); i++) {
	
				count = count + 1;
			}

		}
		总之，(int)String.charAt(i) 汉字字符的 int 值大于 255
 * 
 * @author esw
 *
 */
public class StatisChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "中国aadf的111萨bbb菲的zz萨菲_+";
		int engishCount=0;
		int chineseCount=0;
		int digitCount=0;
		int othersCount=0;
		for(int i=0;i<str.length();i++)
		{
		    char ch = str.charAt(i);
		    System.out.println(ch + ":" + (int)ch);
		    if(ch>='0'&& ch<='9')
		    {
		        digitCount++;
		    }
		    else if((ch>='a'&& ch<='z') || (ch>='A' && ch<='Z'))
		    {
		        engishCount++;
		    }
		    else if ((int)ch > 255)
		    {
		        chineseCount++;
		    }
		    else{
		    	othersCount++;
		    }
		}
		System.out.println("digitCount=" + digitCount);
		System.out.println("engishCount=" + engishCount);
		System.out.println("chineseCount=" + chineseCount);
		System.out.println("othersCount=" + othersCount);
		
		String str1 = "中国chin受到腐蚀的 sfsｓｆｓｓｄｆ ese";
		for(int i=0;i<str1.length();i++){
		    if(str1.substring(i, i+1).matches("[\u4e00-\u9fa5]")){
		        System.out.println(str1.subSequence(i, i+1)+"为汉字。");
		    }else{
		        System.out.println(str1.substring(i, i+1)+"不为汉字");
		    }
		}
		
		int count=0;
		String regEx = "[\\u4e00-\\u9fa5]";
		String str2 = "中文fd我是中国人as ";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str2);

		while (m.find()) {

			for (int i = 0; i <= m.groupCount(); i++) {
	
				count = count + 1;
			}

		}
	}

}
