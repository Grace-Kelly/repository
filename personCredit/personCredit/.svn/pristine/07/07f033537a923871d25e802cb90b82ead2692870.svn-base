package com.csmf.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
	
	//MD5加密
	public static String MD5Encrypt(String value) throws Exception {
		   MessageDigest md;
		   try {
		      md = MessageDigest.getInstance("MD5");

		      md.update(value.getBytes());
		      String s_value = new BigInteger(1, md.digest()).toString(16);
		      return s_value;
		   } catch (NoSuchAlgorithmException e) {
		      throw new Exception("加密失败");
		   }
		}
}
