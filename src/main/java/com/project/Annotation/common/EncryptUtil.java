package com.project.Annotation.common;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {
	
	public static String encryptSHA265(String plainText) 
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		String sha256 = "";
		
		try {
			MessageDigest mdSHA256 = MessageDigest.getInstance("SHA-256");
			mdSHA256.update(plainText.getBytes("UTF-8"));
			
			byte[] sha256Hash= mdSHA256.digest();
			StringBuilder hexSHA256Hash = new StringBuilder();

			for(byte b:sha256Hash) {
				String hexString = String.format("%02x", b);
				hexSHA256Hash.append(hexString);
			}
			sha256=hexSHA256Hash.toString();
			
			
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return sha256;
	}
}
