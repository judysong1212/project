/*
 * Copyright yysvip.tistory.com.,LTD.
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information
 * of yysvip.tistory.com.,LTD. ("Confidential Information").
 */
package com.app.exterms.dlgn.server.utils; 

import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;

/**
 * <pre>
 * com.app.exterms.diligence.server.utils 
 *    |_ DlgnServerUtils.java
 * 
 * </pre>
 * @date : 2016. 7. 13. 오후 3:41:43
 * @version : 
 * @author : Administrator
 */
public class DlgnServerUtils {

	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	 
	
     /**
      * 
      * <pre>
      * 1. 개요 : 김해시청 호봉제 비호봉제 데이터 처리를 위해 추가된 부분 처리 
      * 2. 처리내용 : 
      * </pre>
      * @Method Name : getRepbtyBusinData
      * @date : 2016. 7. 13.
      * @author : Administrator
      * @history : 
      *	-----------------------------------------------------------------------
      *	변경일				작성자						변경내용  
      *	----------- ------------------- ---------------------------------------
      *	2016. 7. 13.		Administrator				최초 작성 
      *	-----------------------------------------------------------------------
      * 
      * @param servletConfig
      * @param request
      * @return
      */
	 public static String getRepbtyBusinData(ServletConfig servletConfig, HttpServletRequest request) {
		 
	            HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(servletConfig,request); 
		       
	            String repbtyBusinData = "";
	            
	            if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//용인로직 
	            	repbtyBusinData =  "";
	      	   
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//김해로직 
					//호봉제구분코드 포함해서 가져 오기 REPBTY_BUSIN_DIV_CD
					repbtyBusinData = "A0480010";
					
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//거제로직 
					repbtyBusinData =  "";
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//안양로직 
					repbtyBusinData =  "";
				
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//광명로직 
					repbtyBusinData =  "";
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//삼척로직 
					repbtyBusinData =  "";
				
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//수원로직 
					repbtyBusinData =  "";
				
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//울주로직 
					repbtyBusinData =  "";
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
					
					repbtyBusinData =  "";
					 
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
					
					repbtyBusinData =  "";
					 
					
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
					
					repbtyBusinData =  "";
					
				} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					//public static final String PAYGEN_MUNICIPALITIES_12 = "GWGS";    //강원도고성군청
					
					repbtyBusinData =  "";
					
						
				} else {
					repbtyBusinData =  ""; 
				}
	            
	            return repbtyBusinData;
	    
	} 

}
