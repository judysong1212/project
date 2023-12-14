/*
 * Copyright yysvip.tistory.com.,LTD.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of yysvip.tistory.com.,LTD. ("Confidential Information").
 */
package com.link.xecuredb.xdsp; 
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 
 * 연계 정책 서버에 설정되어 있는 필드 암호화 값을 선언 관리하는 클래스 
 * com.link.xecuredb.xdsp 
 *    |_ XdspCommConf.java
 * 
 * </pre>
 * @date : Nov 11, 2015 2:18:04 PM
 * @version : 
 * @author : leeheuisung
 */
public class XdspCommConf {

	private Logger logger = LoggerFactory.getLogger(XdspCommConf.class);
	
	
	public static String SEC_RRNUMC		   = "SEC_RRNUMC";   // 주민번호 7자리 이후 자릿수에 맞추어 암호화 /복호화 
    public static String SEC_RRNUM  	   = "SEC_RRNUM";                //주민번호 7자리 이후 암호화 / 복호화 
    public static String SEC_BNKANUM       = "SEC_BNKANUM";       //계좌번호 
    
    public static String SEC_GECRYPT       = "SEC_GECRYPT";       // 통합기본암호화 
    public static String SEC_PSSWD         = "SEC_PSSWD";        //패스워드 암호화 

}
