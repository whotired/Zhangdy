package test.zhangdy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String GROUP_NAME_REG_PATTERN = "^(\\n)(\\w|@|\\^|\\+|\\*|\\s|\042)*";
//		String groupName = "\n+  *\042";
//		boolean validate = Pattern.compile(GROUP_NAME_REG_PATTERN).
//						matcher(groupName).matches();
//		System.out.println("GROUP_NAME_REG_PATTERN =" + GROUP_NAME_REG_PATTERN);
//		System.out.println("groupName =" + groupName);
//		System.out.println(validate);
		
		
		String regex1 = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";
		String input = "zhangdy@yahoo.cn";		
		Pattern pattern =Pattern.compile(regex1, Pattern.CASE_INSENSITIVE);
		Matcher macher = pattern.matcher(input);
		boolean isMatch = macher.matches();
		System.out.println("regex1 =" + regex1);
		System.out.println("input =" + input);
		System.out.println(isMatch);
		System.out.println(macher.groupCount());
		System.out.println(macher.group());
		System.out.println(macher.replaceAll("this"));
		
		int d = 0177;//String s = "\176";
		System.out.print(d);
		System.out.print("end");
	}

}
