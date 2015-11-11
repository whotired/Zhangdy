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
		String str = "���� UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : \" < > ? - = [ ] ; ' , . / \\";
		System.out.println("��escapeXml����ת��֮����ַ���Ϊ:"+StringEscapeUtils.escapeXml(str));  
        System.out.println("��unescapeXml������ת��֮����ַ���Ϊ:"+StringEscapeUtils.unescapeXml(StringEscapeUtils.escapeHtml(str)));   

        //escape html
		String str1 = "���� UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : \" < > ? - = [ ] ; ' , . / \\";
		System.out.println("��escapeHtml����ת��֮����ַ���Ϊ:"+StringEscapeUtils.escapeHtml(str1));  
        System.out.println("��unescapeHtml������ת��֮����ַ���Ϊ:"+StringEscapeUtils.unescapeHtml(StringEscapeUtils.escapeHtml(str1)));   

        //escape javascript
		String str2 = "���� javascript UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : \" < > ? - = [ ] ; ' , . / \\";
		System.out.println("��escapeJavaScript����ת��֮����ַ���Ϊ:"+StringEscapeUtils.escapeJavaScript(str2));  
        System.out.println("��unescapeJavaScript������ת��֮����ַ���Ϊ:"+StringEscapeUtils.unescapeJavaScript(StringEscapeUtils.escapeJavaScript(str2)));   
        
        //escape javascript
      	String str3 = "���� javascript UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : \" < > ? - = [ ] ; ' , . / \\";
      	System.out.println("��escapeJava����ת��֮����ַ���Ϊ:"+StringEscapeUtils.escapeJava(str3));  
        System.out.println("��unescapeJava������ת��֮����ַ���Ϊ:"+StringEscapeUtils.unescapeJava(StringEscapeUtils.escapeJavaScript(str3)));   
        
        //escape sql
        String str4 = "select * from tuser where name=''zhangdy''";
        System.out.println("��escapeSql����ת��֮����ַ���Ϊ:"+StringEscapeUtils.escapeSql(str4));
/*
1'' or ''1''=''1
123456
SELECT COUNT(userId) FROM SHOP390.Tuser WHERE universalid='1'' or ''1''=''1' AND authenticateid ='123456'
��escapeXml����ת��֮����ַ���Ϊ:&#27721;&#23383; UAT 06 PTR 9247 BP &amp; AO to approve ! @ # $ % ^ &amp; * ( ) _ + { } | : &quot; &lt; &gt; ? - = [ ] ; &apos; , . / \
��unescapeXml������ת��֮����ַ���Ϊ:���� UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : " < > ? - = [ ] ; ' , . / \
��escapeHtml����ת��֮����ַ���Ϊ:&#27721;&#23383; UAT 06 PTR 9247 BP &amp; AO to approve ! @ # $ % ^ &amp; * ( ) _ + { } | : &quot; &lt; &gt; ? - = [ ] ; ' , . / \
��unescapeHtml������ת��֮����ַ���Ϊ:���� UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : " < > ? - = [ ] ; ' , . / \
��escapeJavaScript����ת��֮����ַ���Ϊ:\u6C49\u5B57 javascript UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : \" < > ? - = [ ] ; \' , . \/ \\
��unescapeJavaScript������ת��֮����ַ���Ϊ:���� javascript UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : " < > ? - = [ ] ; ' , . / \
��escapeJava����ת��֮����ַ���Ϊ:\u6C49\u5B57 javascript UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : \" < > ? - = [ ] ; ' , . / \\
��unescapeJava������ת��֮����ַ���Ϊ:���� javascript UAT 06 PTR 9247 BP & AO to approve ! @ # $ % ^ & * ( ) _ + { } | : " < > ? - = [ ] ; ' , . / \
*/
	}

}
