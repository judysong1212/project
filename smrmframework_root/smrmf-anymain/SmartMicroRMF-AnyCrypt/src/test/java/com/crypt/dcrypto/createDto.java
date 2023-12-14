package com.crypt.dcrypto;

import com.crypto.security.DCrypto;

public class createDto {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		try {
		    System.out.println("암호화 : " + DCrypto.encrypt("20150303030304"));
		    System.out.println("복호화 : " + DCrypto.decrypt("b964720f6d85ac3b4e321ad142a4706d"));
		}catch(Exception e){
			e.printStackTrace();
		} 
	}
}
 
