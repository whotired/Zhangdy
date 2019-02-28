package com.zhangdy.artifact;

import com.zhangdy.cipher.Base64Util;

public class Sample {

	public static void main(String[] args) {
		try {
			String source = "password"; //"pWqs4y12";
	        String encriptValue = Base64Util.encrypt(source);
	        System.out.println("Encrypt ** source: " + source + " encriptValue: " + encriptValue );
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
