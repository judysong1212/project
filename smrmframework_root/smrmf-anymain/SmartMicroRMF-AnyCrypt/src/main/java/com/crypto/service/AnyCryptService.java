package com.crypto.service;


/**
 * 자체 암호화 처리를 위한 서비스 
 * @author leeheuisung
 *
 */
public interface AnyCryptService {

	/* 데이터 암호와 복호화를 위해 SEED 알고리즘을 사용한다. */
	/* srcStr 을 암호화 한다. */
	public   String payGenEncrypt(String srcStr) throws Exception  ;

	/* 암호화된 문자열을 복호화 한다. */
	public   String payGenDecrypt(String encStr) throws Exception ;

	/* 비밀번호 암호화를 위해 SHA-256, SHA-512 알고리즘을 이용한다. */
	public   String payGenEncryptSHA256(String sourceStr) ;

	public   String payGenEncryptSHA512(String sourceStr) ;
}
