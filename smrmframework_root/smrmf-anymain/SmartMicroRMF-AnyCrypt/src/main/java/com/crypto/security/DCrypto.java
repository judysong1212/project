package com.crypto.security;
 
import java.security.MessageDigest;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import sun.misc.BASE64Encoder;
  
@SuppressWarnings("restriction")
public class DCrypto {
 
private static byte[] keyBytes = new byte[] { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f }; 
private static byte[] IV = new byte[] { 0x07, 0x06, 0x05, 0x04, 0x03, 0x02, 0x01, 0x00, 0x07, 0x06, 0x05, 0x04, 0x03, 0x02, 0x01, 0x00 };
private static SecretKeySpec key = null;
private static String secKey = "SEED" ;  
private static String seedMethod = "SEED/CBC/PKCS5Padding";


	/* 데이터 암호와 복호화를 위해 SEED 알고리즘을 사용한다. */
	/* srcStr 을 암호화 한다. */
	public static String encrypt(String srcStr) throws Exception {
		byte[] input = srcStr.getBytes();
		Security.addProvider(new BouncyCastleProvider());

		key = new SecretKeySpec(keyBytes, secKey);
		IvParameterSpec ivSpec = new IvParameterSpec(IV);
		Cipher cipher = Cipher.getInstance(seedMethod, "BC");
		cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec);
		byte[] cipherText = cipher.doFinal(input);

		return String.valueOf(Hex.encodeHex(cipherText));
	}

	/* 암호화된 문자열을 복호화 한다. */
	public static String decrypt(String encStr) throws Exception {

		byte[] input = (Hex.decodeHex(encStr.toCharArray()));
		Security.addProvider(new BouncyCastleProvider());
		key = new SecretKeySpec(keyBytes, secKey);
		IvParameterSpec ivSpec = new IvParameterSpec(IV);
		Cipher cipher = Cipher.getInstance(seedMethod, "BC");
		cipher.init(Cipher.DECRYPT_MODE, key, ivSpec);
		byte[] decryptedText = cipher.doFinal(input);
		return new String(decryptedText);
	}

	/* 비밀번호 암호화를 위해 SHA-256, SHA-512 알고리즘을 이용한다. */
	@SuppressWarnings("restriction")
	public static String encryptSHA256(String sourceStr) {
		String result = "";
		try {
			Security.addProvider(new BouncyCastleProvider());
			MessageDigest mda = MessageDigest.getInstance("SHA-256", "BC");
			byte[] digesta = mda.digest(sourceStr.getBytes());

			BASE64Encoder encoder = new BASE64Encoder();
			result = encoder.encode(digesta);
		} catch (Exception e) {
			result = ""; // e.getMessage();
		}
		return result;
	}

	 
	@SuppressWarnings("restriction")
	public static String encryptSHA512(String sourceStr) {
		String result = "";
		try {
			Security.addProvider(new BouncyCastleProvider());
			MessageDigest mda = MessageDigest.getInstance("SHA-512", "BC");
			byte[] digesta = mda.digest(sourceStr.getBytes());

			BASE64Encoder encoder = new BASE64Encoder();
			result = encoder.encode(digesta);
		} catch (Exception e) {
			result = ""; // e.getMessage();
		}
		return result;
	}
    
}
