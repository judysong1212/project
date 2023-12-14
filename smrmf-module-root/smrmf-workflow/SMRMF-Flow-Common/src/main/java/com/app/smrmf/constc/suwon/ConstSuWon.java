/*
 * Copyright yysvip.tistory.com.,LTD.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of yysvip.tistory.com.,LTD. ("Confidential Information").
 */
package com.app.smrmf.constc.suwon; 

import org.apache.log4j.Logger;

/**
 * <pre>
 * com.app.smrmf.constc.samcheok 
 *    |_ constSamCheok.java
 * 
 * </pre>
 * @date : Dec 13, 2015 2:02:12 PM
 * @version : 
 * @author : leeheuisung
 */
public class ConstSuWon {

	private Logger log = Logger.getLogger(this.getClass());

	  //공통 근태일근무시간 8시간 
    public static  final String PAYR_BASS_WKTM_GM_01 = "8.0";     //기본근무시간  
    //무기계약직 - 월통상일급 계산시간 226시간 
    public static  final String PAYR_BASS_WKTM_GM_02 = "226";     //시간  
    //무기계약직 - 월통상시급 계산시간 226시간 
    public static  final String PAYR_BASS_WKTM_GM_03 = "226";     //시간  
    //시간외근무 기본근무시간 
    public static  final String PAYR_OVER_WKTM_GMTM  = "10.0";   //시간외 기본근무시간.기본근무시간  
    //주소정근로시간 
    public static final String USR_WEEK_WORK_GMTIME = "40";
    //월통상임금 - 기본급,정액수당,복리후생비
    //월통상임금(상여금포함)  
    public static final String  PAYR_UNIT_SALARY = "UNIT";    //단가관리 
    

    //공제 관련 안양시만 적용 함.  
    public static final String  PAYR_D9600200 = "D9600200";    //천원미만공제(법정)
 
}
