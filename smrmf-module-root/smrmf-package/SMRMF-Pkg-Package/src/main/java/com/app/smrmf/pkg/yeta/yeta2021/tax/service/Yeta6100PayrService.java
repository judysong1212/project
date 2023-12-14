package com.app.smrmf.pkg.yeta.yeta2021.tax.service;

import java.util.HashMap;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160402VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160403VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161010Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161020_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161030_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161040_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161070_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161080_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe165010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe165030Temp_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe165030_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe166010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe166020_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe169010a_2021_VO;

/**
 * @Class Name : Yeta6900Service.java
 * @Description : Yeta6900 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2021.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Yeta6100PayrService {
	
	
	/***********************************************************************************
	 * 2021년귀속 연말정산 처리를 위한 함수 처리 부 시작 
	***********************************************************************************/
			
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 2021년귀속 급여자료 이관
	 * 2. 처리내용 : 급여자료 이관
	 * </pre>
	 * @Method Name : fnYeta6100_YE160401_PAYR_2021_CREATE_Insert
	 * @date : 2021. 1. 9.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2021. 1. 9.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yePrc160401Vo
	 * @return
	 * @throws Exception
	 */
	String fnYeta6100_YE160401_PAYR_2021_CREATE_Insert(InfcPkgYe160401VO yePrc160401Vo) throws Exception; 
		
		 
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 연말정산기본 과세 감면 인서트 
	 * 2. 처리내용 : 연말정산기본 과세 감면 인서트 
	 * </pre>
	 * @Method Name : fnYeta6100_YE160402_PAYR_2021_CREATE_Insert
	 * @date : 2021. 1. 9.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2021. 1. 9.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yePrc160402Vo
	 * @throws Exception
	 */
	String fnYeta6100_YE160402_PAYR_2021_CREATE_Insert(InfcPkgYe160402VO yePrc160402Vo) throws Exception;   
   
	 
	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 연말정산 4대보험 인서트 Ye161050 국민연금 관련 인서트 
	  * 2. 처리내용 : 연말정산 4대보험 인서트 Ye161050국민연금 관련 인서트 
	  *             C_연금보험료공제
	  * </pre>
	  * @Method Name : fnYeta6100_Ye161050_PAYR_2021_CREATE_Update
	  * @date : 2021. 1. 9.
	  * @author : atres
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2021. 1. 9.		atres				최초 작성 
	  *	-----------------------------------------------------------------------
	  *
	  */
	String fnYeta6100_Ye161050_PAYR_2021_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception;     //Ye161050VO();	//
   
	/**
	 * 
	 * <pre>
	 * 1. 개요 : C_연금보험료_공적연금상세
	 * 2. 처리내용 : 연말정산 4대보험 인서트 Ye161050 /Ye161055
	 * </pre>
	 * @Method Name : fnYeta6100_Ye161055_PAYR_2021_CREATE_Insert
	 * @date : 2021. 1. 9.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2021. 1. 9.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param infcPkgYe160401Vo
	 */
	String fnYeta6100_Ye161055_PAYR_2021_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception;   
  		  
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 연말정산 4대보험 인서트 Ye161060 
	 * 2. 처리내용 : 연말정산 4대보험 인서트 Ye161050 /Ye161055 /Ye161060 
	 * 				--- C_특별소득공제  국민연금/고용보험 
	 * </pre>
	 * @Method Name : fnYeta6100_Ye161060_PAYR_2021_CREATE_Insert
	 * @date : 2021. 1. 9.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2021. 1. 9.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param infcPkgYe160401Vo
	 */
	String  fnYeta6100_Ye161060_PAYR_2021_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception;    
	
     

	  
	//{비과세 감면 인서트 } 
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 연말정산기본 과세 감면 업데이트
	 * 2. 처리내용 : 연말정산기본 과세 감면 업데이트
	 * </pre>
	 * @Method Name : fnYeta6100_YE160403_PAYR_2021_CREATE_Insert
	 * @date : 2021. 1. 9.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2021. 1. 9.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yePrc160403Vo
	 * @return
	 * @throws Exception
	 */
	String fnYeta6100_YE160403_PAYR_2021_CREATE_Insert(InfcPkgYe160403VO yePrc160403Vo) throws Exception;   
  
	
	 
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 급여자료 이관 - 연말정산 YE169010 업데이트  
	 * 2. 처리내용 : 급여자료 이관 - 연말정산 YE169010 업데이트   공제내역이관 
	 * </pre>
	 * @Method Name : fnYeta6100_YE169010_PAYR_2021_CREATE_Insert
	 * @date : 2021. 1. 9.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2021. 1. 9.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param yePrc160401Vo
	 * @throws Exception
	 */
	String fnYeta6100_YE169010_PAYR_2021_CREATE_Insert(InfcPkgYe160401VO yePrc160401Vo) throws Exception;   
   	
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 연말정산 대상자 생성 -  기본테이블 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : fnYeta6100_YE161010_2021_CREATE_Insert
	 * @date : 2021. 1. 12.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2021. 1. 12.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param infcPkgYe161010Vo
	 * @return
	 * @throws Exception
	 */
	 String fnYeta6100_YE161010_2021_CREATE_Insert(InfcPkgYe161010_2021_VO infcPkgYe161010Vo) throws Exception;
	 
	 
	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 인적소득공제기본
	  * 2. 처리내용 : 인적소득공제기본
	  * </pre>
	  * @Method Name : fnYeta6100_YE161020_2021_CREATE_Insert
	  * @date : 2021. 1. 15.
	  * @author : atres
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	2021. 1. 15.		atres				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param infcPkgYe161010Vo
	  * @return
	  * @throws Exception
	  */
	 String fnYeta6100_YE161020_2021_CREATE_Insert(InfcPkgYe161020_2021_VO infcPkgYe161020Vo) throws Exception;
	 
	 String fnYeta6100_YE166020_2021_CREATE_Insert01(InfcPkgYe166020_2021_VO infcPkgYe166020Vo) throws Exception;
	 String fnYeta6100_YE166020_2021_CREATE_Insert02(InfcPkgYe166020_2021_VO infcPkgYe166020Vo) throws Exception;
	 String fnYeta6100_YE166010_2021_CREATE_Insert(InfcPkgYe166010_2021_VO infcPkgYe166010Vo) throws Exception; 
	 
	 String fnYeta6100_YE161030_2021_CREATE_Insert(InfcPkgYe161030_2021_VO infcPkgYe161030Vo) throws Exception;
	 
	 
	 String fnYeta6100_YE161040_2021_CREATE_Insert01(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception;
	 
	 
	 String fnYeta6100_YE161040_2021_CREATE_Insert02(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception;
	 
	 int fnYeta6100_YE161040_2021_INSU_FETC_Update(InfcPkgYe161040_2021_VO infcPkgYe161040Vo) throws Exception;
	 
	 int fnYeta6100_YE161030_2021_CREATE_Update(InfcPkgYe161030_2021_VO infcPkgYe161030Vo) throws Exception;
	 
	 
	 String fnYeta6100_YE165030_TEMP_2021_CREATE_Insert(InfcPkgYe165030Temp_2021_VO infcPkgYe165030TempVo) throws Exception;
	 
	 String fnYeta6100_YE165030TempYE165030_2021_CREATE_Insert(InfcPkgYe165030_2021_VO infcPkgYe165030Vo) throws Exception;
	 
	  
	 String fnYeta6100_YE161070_2021_CREATE_Insert(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception;
	 
	 String fnYeta6100_YE161080_2021_CREATE_Insert(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception;
	 
	 String fnYeta6100_YE161080_2021_CREATE_Update_AS(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception;
	 
	  
	// String fnYeta6100_YE169010_2021_CREATE_Insert(InfcPkgYe161010VO infcPkgYe161010Vo) throws Exception; 
	 
	 String fnYeta6100_YE169010a_2021_CREATE_Insert(InfcPkgYe169010a_2021_VO infcPkgYe169010AVo) throws Exception; 
	 
	 
	 // 급여 내역에 있는 노조회비 항목 삭제,인서트 처리
	 String fnYeta6100_YE165010_2021_PAYR_CREATE(InfcPkgYe165010_2021_VO infcPkgYe165010Vo) throws Exception; 
	 
	 
	 /**!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	  * 단위사업장 맵핑정보 가져오기 
	  !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!*/
	  
	 HashMap selectBass0360SearchList(InfcPkgYe161010Srh_2021_VO infcPkgYe161010SrhVo) throws Exception; 
	 HashMap selectBass0500SearchList(InfcPkgYe161010Srh_2021_VO infcPkgYe161010SrhVo) throws Exception; 
	  
	 void fnYeta6100_YE161010_UtDpobCd_2021_Update(InfcPkgYe161010_2021_VO infcPkgYe161010Vo) throws Exception; 
	  
   /***********************************************************************************
    * 2021년귀속 연말정산 처리를 위한 함수 처리 부 끝
	***********************************************************************************/
	
	 
    
}
