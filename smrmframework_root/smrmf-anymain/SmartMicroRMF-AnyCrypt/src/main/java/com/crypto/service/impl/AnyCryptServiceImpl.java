package com.crypto.service.impl;

import org.springframework.stereotype.Service;

import com.crypto.security.DCrypto;
import com.crypto.service.AnyCryptService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("AnyCryptService") 
public class AnyCryptServiceImpl extends AbstractServiceImpl  implements AnyCryptService {
 
	 
	/* 데이터 암호와 복호화를 위해 SEED 알고리즘을 사용한다. */
	/* srcStr 을 암호화 한다. */
	public String payGenEncrypt(String srcStr) throws Exception {
		return DCrypto.encrypt(srcStr);
	}
	
	/* 암호화된 문자열을 복호화 한다. */
	public String payGenDecrypt(String encStr) throws Exception {
		return DCrypto.decrypt( encStr) ;
	}

	/* 비밀번호 암호화를 위해 SHA-256, SHA-512 알고리즘을 이용한다. */
	public String payGenEncryptSHA256(String sourceStr) {
		return DCrypto.encryptSHA256(sourceStr);
	}

	public String payGenEncryptSHA512(String sourceStr) {
		return DCrypto.encryptSHA512(sourceStr);
	}
	
}
