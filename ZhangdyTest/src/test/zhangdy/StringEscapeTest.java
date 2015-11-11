package test.zhangdy;

import org.apache.commons.lang.StringEscapeUtils;

public class StringEscapeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//escape sql
		String userName = "1' or '1'='1";
		String password ="123456";
		userName = StringEscapeUtils.escapeSql(userName);
		password = StringEscapeUtils.escapeSql(password);
		String sql = "SELECT COUNT(userId) FROM SHOP390.Tuser WHERE universalid='"
				+ userName + "' AND authenticateid ='" + password + "'";
    	System.out.println(userName);
    	System.out.println(password);
    	System.out.println(sql);
    	
    	//escape xml
		String str = "汉字 UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : \" < > ? - = [ ] ; ' , . / \\";
		System.out.println("用escapeXml方法转义之后的字符串为:"+StringEscapeUtils.escapeXml(str));  
        System.out.println("用unescapeXml方法反转义之后的字符串为:"+StringEscapeUtils.unescapeXml(StringEscapeUtils.escapeHtml(str)));   

        //escape html
		String str1 = "汉字 UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : \" < > ? - = [ ] ; ' , . / \\";
		System.out.println("用escapeHtml方法转义之后的字符串为:"+StringEscapeUtils.escapeHtml(str1));  
        System.out.println("用unescapeHtml方法反转义之后的字符串为:"+StringEscapeUtils.unescapeHtml(StringEscapeUtils.escapeHtml(str1)));   

        //escape javascript
		String str2 = "汉字 javascript UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : \" < > ? - = [ ] ; ' , . / \\";
		System.out.println("用escapeJavaScript方法转义之后的字符串为:"+StringEscapeUtils.escapeJavaScript(str2));  
        System.out.println("用unescapeJavaScript方法反转义之后的字符串为:"+StringEscapeUtils.unescapeJavaScript(StringEscapeUtils.escapeJavaScript(str2)));   
        
        //escape javascript
      	String str3 = "汉字 javascript UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : \" < > ? - = [ ] ; ' , . / \\";
      	System.out.println("用escapeJava方法转义之后的字符串为:"+StringEscapeUtils.escapeJava(str3));  
        System.out.println("用unescapeJava方法反转义之后的字符串为:"+StringEscapeUtils.unescapeJava(StringEscapeUtils.escapeJavaScript(str3)));   
        
        //escape sql
        String str4 = "select * from tuser where name=''zhangdy''";
        System.out.println("用escapeSql方法转义之后的字符串为:"+StringEscapeUtils.escapeSql(str4));
/*
1'' or ''1''=''1
123456
SELECT COUNT(userId) FROM SHOP390.Tuser WHERE universalid='1'' or ''1''=''1' AND authenticateid ='123456'
用escapeXml方法转义之后的字符串为:&#27721;&#23383; UAT 06 PTR 9247 BP &amp; AO to approve ! @ # $ % ^ &amp; * ( ) _ + { } | : &quot; &lt; &gt; ? - = [ ] ; &apos; , . / \
用unescapeXml方法反转义之后的字符串为:汉字 UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : " < > ? - = [ ] ; ' , . / \
用escapeHtml方法转义之后的字符串为:&#27721;&#23383; UAT 06 PTR 9247 BP &amp; AO to approve ! @ # $ % ^ &amp; * ( ) _ + { } | : &quot; &lt; &gt; ? - = [ ] ; ' , . / \
用unescapeHtml方法反转义之后的字符串为:汉字 UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : " < > ? - = [ ] ; ' , . / \
用escapeJavaScript方法转义之后的字符串为:\u6C49\u5B57 javascript UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : \" < > ? - = [ ] ; \' , . \/ \\
用unescapeJavaScript方法反转义之后的字符串为:汉字 javascript UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : " < > ? - = [ ] ; ' , . / \
用escapeJava方法转义之后的字符串为:\u6C49\u5B57 javascript UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : \" < > ? - = [ ] ; ' , . / \\
用unescapeJava方法反转义之后的字符串为:汉字 javascript UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : " < > ? - = [ ] ; ' , . / \
*/
	}

}
