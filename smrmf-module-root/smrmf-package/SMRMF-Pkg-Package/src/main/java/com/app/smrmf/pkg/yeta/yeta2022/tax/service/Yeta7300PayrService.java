package com.app.smrmf.pkg.yeta.yeta2022.tax.service;

import java.util.List;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161050_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161055_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161060_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161070_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161080_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162010Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162020Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162030Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162040Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162040_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162510Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162510_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162520Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162520_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165030Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe169010Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe169010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe169010a_2022_VO;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166020Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166020_2022_VO;

/**
 * @Class Name : Yeta3900Service.java
 * @Description : Yeta3900 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface Yeta7300PayrService {
	 
	/********************************************************************************************************
	 * 연말정산 처리 하는부분 시작  
	 ********************************************************************************************************/ 
	 int fnYeta7300_B101Y_YE161080_2022_Update(InfcPkgYe161010_2022_VO infcPkgYe161010Vo) throws Exception;
	 int fnYeta7300_All_YE161080_2022_Update(InfcPkgYe161010_2022_VO infcPkgYe161010Vo) throws Exception;
	 
	   int fnYeta7300_TaxPkg01_2022_Update(InfcPkgYe161010_2022_VO infcPkgYe161010Vo) throws Exception; 
	   
	   
	   //기본공제 인원수 산정 
	   int fnYeta7300_YE161020_Tax_2022_01_Update(InfcPkgYe161020_2022_VO infcPkgYe161020Vo) throws Exception; 
	   
	   //국민연금등
	   int fnYeta7300_YE161055_Tax_2022_02_Update(InfcPkgYe161055_2022_VO infcPkgYe161055Vo) throws Exception; 
	   //국민연금등 
	   int fnYeta7300_YE161050_Tax_2022_03_Update(InfcPkgYe161050_2022_VO infcPkgYe161050Vo) throws Exception; 
	    
	   int fnYeta7300_YE169010_Tax_2022_04_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	   
	   int fnYeta7300_YE169010_Tax_2022_05_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	   

	   int fnYeta7300_YE169010_Tax_2022_06_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
	   

	   int fnYeta7300_YE169010_Tax_2022_07_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
	    
	   int fnYeta7300_YE169010_Tax_2022_08_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	   
	   int fnYeta7300_YE169010_Tax_2022_09_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;   
	   
 	   int fnYeta7300_YE169010_Tax_2022_10_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 

	   int fnYeta7300_YE169010_Tax_2022_11_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int fnYeta7300_YE169010_Tax_2022_12_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;   
	   
	   int fnYeta7300_YE169010_Tax_2022_13_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int fnYeta7300_YE169010_Tax_2022_14_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
	   //
	 
	   
	   int fnYeta7300_YE169010_Tax_2022_15_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int fnYeta7300_YE169010_Tax_2022_16_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception;
	  
	   int fnYeta7300_YE169010_Tax_2022_17_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception;
	   
	   int fnYeta7300_YE169010_Tax_2022_18_Update(InfcPkgYe161070_2022_VO infcPkgYe161070Vo) throws Exception;
	   
	   //2022연말정산_추가
	   int fnYeta7300_YE169010_Tax_2022_18_1_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	   
	   //2022연말정산_추가
	   int fnYeta7300_YE169010_Tax_2022_18_2_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	   
	   //2022연말정산_추가
	   int fnYeta7300_YE169010_Tax_2022_18_3_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	   
	   //2022연말정산_추가
	   int fnYeta7300_YE169010_Tax_2022_18_4_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	   
	   //2022연말정산_추가
	   int fnYeta7300_YE169010_Tax_2022_18_5_Update(InfcPkgYe166020_2022_VO infcPkgYe166020Vo) throws Exception;
	   
	   //2022연말정산_추가
	   int fnYeta7300_YE169010_Tax_2022_18_6_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	   
	   
	   int fnYeta7300_YE169010_Tax_2022_19_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	   
	   //2022연말정산_추가
	   int fnYeta7300_YE169010_Tax_2022_19_S_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	   
	   //2022연말정산_추가
	   int fnYeta7300_YE169010_Tax_2022_19_S_1_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	   
	   
	   //2022연말정산_추가
	   int fnYeta7300_YE169010_Tax_2022_19_1_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	   
	   int fnYeta7300_YE169010_Tax_2022_20_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int fnYeta7300_YE169010_Tax_2022_21_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;     
 
	   
	   int fnYeta7300_YE169010_Tax_2022_22_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int fnYeta7300_YE169010_Tax_2022_23_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;    
	    
	   int fnYeta7300_YE169010_Tax_2022_24_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;   

	   int fnYeta7300_YE169010_Tax_2022_25_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception; 
	   
	   int fnYeta7300_YE169010_Tax_2022_25_01_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo)  throws Exception; 
	  
	   int fnYeta7300_YE169010_Tax_2022_26_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception;   
	   
	   int  fnYeta7300_YE169010_Tax_2022_27_Update(InfcPkgYe161080_2022_VO infcPkgYe161080Vo) throws Exception; 
	   
	  // int  fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int fnYeta7300_YE169010_Tax_2022_29_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int fnYeta7300_YE169010_Tax_2022_30_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;   
	   

	   int fnYeta7300_YE169010_Tax_2022_31_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  


	   int fnYeta7300_YE169010_Tax_2022_31_01_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;   
	   
	   //2022연말정산_추가
	   int fnYeta7300_YE169010_Tax_2022_31_02_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;   

//	   int  fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	   

	   int  fnYeta7300_YE169010_Tax_2022_32_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	    
	   int fnYeta7300_YE169010_Tax_2022_33_Update(InfcPkgYe161060_2022_VO infcPkgYe161060Vo) throws Exception;    

	   int fnYeta7300_YE169010_Tax_2022_33_02_Update(InfcPkgYe161060_2022_VO infcPkgYe161060Vo) throws Exception;   
	   
	   int fnYeta7300_YE169010_Tax_2022_33_03_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;    
	   
	   int fnYeta7300_YE169010_Tax_2022_33_04_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;    
	    
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;   
	    
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	   
	   //2022연말정산_추가
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_023_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	   
	   
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	   
	   //2022연말정산_추가
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_033_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int  fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  

	   //-----
	//   int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(InfcPkgYeta2000VO  infcPkgYeta2000Vo) throws Exception; 
	   
	   String fnYeta7300_YE169010_Tax_2022_40_Update(InfcPkgYe165030_2022_VO  infcPkgYe165030Vo) throws Exception; 
	   

	   //String fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(InfcPkgYeta2000VO  infcPkgYeta2000Vo) throws Exception; 
	   
	   
	   
	   List fnYeta7300_YE169010_Tax_2022_TgYear_Select(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 

	   List fnYeta7300_YE169010_Tax_2022_1001_Select(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	   
	   List  fnPayr06430_PAYR442_ReTax_2022_SelectFind(InfcPkgYe165030Srh_2022_VO  searchVO) throws Exception; 
	   

	   int  fnPayr06430_PAYR442_ReTax_2022_Update(InfcPkgYe165030_2022_VO infcPkgYe165030Vo) throws Exception;  
 
	   int  fnYeta7300_YE169010_Tax_2022_50_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int  fnYeta7300_YE169010a_Tax_2022_50_Update(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception; 
	   
	   
	   int  fnYeta7300_YE169010_Tax_2022_50_01_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int  fnYeta7300_YE169010a_Tax_2022_50_01_Update(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception; 
	   

	   InfcPkgYe169010_2022_VO fnYeta7300_YE169010_Tax_2022_51_Select(InfcPkgYe169010Srh_2022_VO   infcPkgYe169010SrhVo) throws Exception;
	   
	   

	   InfcPkgYe169010_2022_VO fnYeta7300_YE169010_Tax_2022_2001_Select(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	   
 
	   InfcPkgYe169010a_2022_VO fnYeta7300_YE169010a_Tax_2022_2001_Select(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception;
	    
	   int  fnYeta7300_YE169010_Tax_2022_2002_Update(InfcPkgYe169010_2022_VO subInfcPkgYe169010Vo) throws Exception;   
	   
	   int  fnYeta7300_YE169010a_Tax_2022_2002_Update(InfcPkgYe169010a_2022_VO subInfcPkgYe169010aVo) throws Exception; 
	   
	   int  fnYeta7300_YE161020_Tax_2022_C152_STD_TX_DDC_YN_Update(InfcPkgYe161020_2022_VO infcPkgYe161020Vo) throws Exception; 
	   
	   int  fnYeta7300_YE169010a_Tax_2022_52_Update(InfcPkgYe169010a_2022_VO dscnPrc3000Vo) throws Exception;    
	   
	   String fnYeta7300_YE169010a_Tax_2022_52_Insert(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	 
	   int  fnYeta7300_YE169010a_Tax_2022_52_Delete(InfcPkgYe169010_2022_VO dscnPrc3000Vo) throws Exception;    
	   
	   int  fnYeta7300_YE169010_Tax_2022_2003_Select(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
		 
	// 통합으로 인해 사용안함 	
	  // int  yeta2000_ReTax_2016_DCSN_INCM_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
	   
	   //------------------------------
	   int  fnYeta7300_YE169010_Tax_2022_3001_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int  fnYeta7300_YE169010a_Tax_2022_3001_Update(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception; 
	   

	   int  fnYeta7300_YE169010_Tax_2022_3002_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int  fnYeta7300_YE169010a_Tax_2022_3002_Update(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception;  
	   

	   int  fnYeta7300_YE169010_Tax_2022_3003_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int  fnYeta7300_YE169010a_Tax_2022_3003_Update(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception;  
	   
	   
	   int  fnYeta7300_YE169010_Tax_2022_3004_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int  fnYeta7300_YE169010a_Tax_2022_3004_Update(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception;  
	   
	   int  fnYeta7300_YE169010_Tax_2022_3005_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	   
	   int  fnYeta7300_YE169010a_Tax_2022_3005_Update(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception;

	   int  fnYeta7300_YE169010_Tax_2022_3006_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;     
	   
	   int  fnYeta7300_YE169010a_Tax_2022_3006_Update(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception;   
	   
	   
//사용안함 
	 //  int  fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
	    
	   int  fnYeta7300_YE169010_Tax_2022_3007_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int  fnYeta7300_YE169010a_Tax_2022_3007_Update(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception; 
	   
	   
	   int  fnYeta7300_YE169010_Tax_2022_3008_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;   
	   

	   int  fnYeta7300_YE169010a_Tax_2022_3008_Update(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception;   
	   
	   
	   int  fnYeta7300_YE169010_Tax_2022_3009_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
	   

	   int  fnYeta7300_YE169010a_Tax_2022_3009_Update(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception;  
	   

	   int  fnYeta7300_YE169010_Tax_2022_3010_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;         
	    

	   int  fnYeta7300_YE169010a_Tax_2022_3010_Update(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception;         
	    
		  
	   int  fnYeta7300_YE169010_Tax_2022_3011_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;   
	
	   int  fnYeta7300_YE169010a_Tax_2022_3011_Update(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception;   
	    

	   int  fnYeta7300_YE169010_Tax_2022_3012_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int  fnYeta7300_YE169010a_Tax_2022_3012_Update(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception;  
	   
	   int  fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;
	   
	   int  fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception; 
	   

	   
	   int  fnYeta7300_YE169010_Tax_2022_51_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;     
	   

	   int  fnYeta7300_YE169010a_Tax_2022_51_Update(InfcPkgYe169010a_2022_VO infcPkgYe169010aVo) throws Exception;     
	   
	   
	   int  fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;      
 

	   List fnYeta7300_YE169010_Tax_2022_A01_Select(InfcPkgYe169010Srh_2022_VO infcPkgYe169010Vo) throws Exception; 
 
	   int  fnYeta7300_Ye161060_Tax_2022_I1_Update(InfcPkgYe161060_2022_VO    inputYe161060Vo) throws Exception;
	   
	   int  fnYeta7300_Ye161070_Tax_2022_I2_Update(InfcPkgYe161070_2022_VO    inputYe161070Vo) throws Exception;
	   
	   int  fnYeta7300_Ye161080_Tax_2022_I3_Update(InfcPkgYe161080_2022_VO    inputYe161080Vo) throws Exception;
	   
	   int  fnYeta7300_YE169010_Tax_2022_TgIn01_Update(InfcPkgYe161080_2022_VO    inputYe161080Vo) throws Exception;
	   
	   int  fnYeta7300_YE169010_Tax_2022_TgIn02_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;      
	  
	   int  fnYeta7300_YE169010_Tax_2022_TgIn03_Update(InfcPkgYe161080_2022_VO    inputYe161080Vo) throws Exception;
	   
	   int  fnYeta7300_YE169010_Tax_2022_TgIn04_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;      
	   
	 
	   List fnYeta7300_YE162010_Tax_2022_A01_Select(InfcPkgYe162010Srh_2022_VO   ye162010SrhVo) throws Exception; 
	   List fnYeta7300_YE162020_Tax_2022_A01_Select(InfcPkgYe162020Srh_2022_VO infcPkgYe162020Vo) throws Exception; 
	   List fnYeta7300_YE162030_Tax_2022_A01_Select(InfcPkgYe162030Srh_2022_VO infcPkgYe162030Vo) throws Exception; 
	   List fnYeta7300_YE162040_Tax_2022_A01_Select(InfcPkgYe162040Srh_2022_VO infcPkgYe162040Vo) throws Exception; 
	   
	 
	  		 
	   int  updateYeta7300_Tax_Ye162010_01(InfcPkgYe162010_2022_VO vo) throws Exception;   
	   
	   int  updateYeta7300_Tax_Ye162010_01_S(InfcPkgYe162010_2022_VO vo) throws Exception; 
	   
	   
	   int  updateYeta7300_Tax_Ye162010_02(InfcPkgYe162010_2022_VO vo) throws Exception;      
	   
	   int  updateYeta7300_Tax_Ye162020_01(InfcPkgYe162020_2022_VO infcPkgYe162020Vo) throws Exception;    
	   
	   int  updateYeta7300_Tax_Ye162020_01_S(InfcPkgYe162020_2022_VO infcPkgYe162020Vo) throws Exception; 
	   
	   int  updateYeta7300_Tax_Ye162020_02(InfcPkgYe162020_2022_VO infcPkgYe162020Vo) throws Exception;      
	   
	   int  updateYeta7300_Tax_YE162030_01(InfcPkgYe162030_2022_VO infcPkgYe162030Vo) throws Exception;      
	   
	   int  updateYeta7300_Tax_YE162040_01(InfcPkgYe162040_2022_VO infcPkgYe162040Vo) throws Exception;  
	   
	   

	   List fnYeta7300_YE162510_Tax_2022_A01_Select(InfcPkgYe162510Srh_2022_VO   ye162510SrhVo) throws Exception; 
		 
		 
	   int  updateYeta7300_Tax_Ye162510_01(InfcPkgYe162510_2022_VO vo) throws Exception;      
	   
	   int  updateYeta7300_Tax_Ye162510_02(InfcPkgYe162510_2022_VO vo) throws Exception;      
	   
	   
	   List fnYeta7300_YE162520_Tax_2022_A01_Select(InfcPkgYe162520Srh_2022_VO   ye162520SrhVo) throws Exception; 
		 
		 
	   int  updateYeta7300_Tax_Ye162520_01(InfcPkgYe162520_2022_VO vo) throws Exception;      
	  
    /********************************************************************************************************
	 * 연말정산 처리 하는부분 종료  
	 ********************************************************************************************************/ 
	  
	   
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;     
	    
	   
	   //사용안함 
	   int  fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(InfcPkgYe169010_2022_VO infcPkgYe169010Vo) throws Exception;  
	  
	 
          
	
	  
	    
    
}
