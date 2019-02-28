package com.zhangdy.cipher;

import java.nio.charset.Charset;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {

	private static final String ALGORITHM = "AES";
    private static final byte[] keyValue = "ADBSJHJS12547896".getBytes();

    public static String encodeBase64(String s) {  
        if (s == null)  
            return null;  
        
        String encodedAuth = new String(Base64.encodeBase64(s.getBytes(Charset.forName("UTF-8"))));
		return encodedAuth;
    }
    
    public static String decodeBase64(String s) {  
        if (s == null)  
            return null;  
        
        String decodedAuth = new String(Base64.decodeBase64(s.getBytes(Charset.forName("UTF-8"))));
		return decodedAuth;
    }
    
    public static String encrypt(String valueToEnc) throws Exception {

    	Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);

        byte[] encValue = c.doFinal(valueToEnc.getBytes(Charset.forName("UTF-8")));
        String encryptedValue = new String(Base64.encodeBase64(encValue));

        return encryptedValue;
    }

    public static String decrypt(String encryptedValue) throws Exception {
    	Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);

        byte[] decodedValue = Base64.decodeBase64(encryptedValue.getBytes(Charset.forName("UTF-8")));
        byte[] decryptedVal = c.doFinal(decodedValue);
        return new String(decryptedVal);
    }

    private static Key generateKey() throws Exception {
    	Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }
}
