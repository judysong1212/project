package com.app.smrmf.pkg.yeta.yeta2021.tax.service;

import java.util.List;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161020_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161050_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161055_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161060_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161070_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161080_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162010Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162020Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162020_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162030Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162030_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162040Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162040_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162510Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162510_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162520Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe162520_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe165030Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe165030_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe169010Srh_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe169010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe169010a_2021_VO;

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
public interface Yeta6300PayrService {
	 
	/********************************************************************************************************
	 * 연말정산 처리 하는부분 시작  
	 ********************************************************************************************************/ 
	 int fnYeta6300_B101Y_YE161080_2021_Update(InfcPkgYe161010_2021_VO infcPkgYe161010Vo) throws Exception;
	 int fnYeta6300_All_YE161080_2021_Update(InfcPkgYe161010_2021_VO infcPkgYe161010Vo) throws Exception;
	 
	   int fnYeta6300_TaxPkg01_2021_Update(InfcPkgYe161010_2021_VO infcPkgYe161010Vo) throws Exception; 
	   
	   
	   //기본공제 인원수 산정 
	   int fnYeta6300_YE161020_Tax_2021_01_Update(InfcPkgYe161020_2021_VO infcPkgYe161020Vo) throws Exception; 
	   
	   //국민연금등
	   int fnYeta6300_YE161055_Tax_2021_02_Update(InfcPkgYe161055_2021_VO infcPkgYe161055Vo) throws Exception; 
	   //국민연금등 
	   int fnYeta6300_YE161050_Tax_2021_03_Update(InfcPkgYe161050_2021_VO infcPkgYe161050Vo) throws Exception; 
	    
	   int fnYeta6300_YE169010_Tax_2021_04_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;
	   
	   int fnYeta6300_YE169010_Tax_2021_05_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;
	   

	   int fnYeta6300_YE169010_Tax_2021_06_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
	   

	   int fnYeta6300_YE169010_Tax_2021_07_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
	    
	   int fnYeta6300_YE169010_Tax_2021_08_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;
	   
	   int fnYeta6300_YE169010_Tax_2021_09_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;   
	   
 	   int fnYeta6300_YE169010_Tax_2021_10_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 

	   int fnYeta6300_YE169010_Tax_2021_11_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int fnYeta6300_YE169010_Tax_2021_12_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;   
	   
	   int fnYeta6300_YE169010_Tax_2021_13_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int fnYeta6300_YE169010_Tax_2021_14_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
	   //
	 
	   
	   int fnYeta6300_YE169010_Tax_2021_15_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int fnYeta6300_YE169010_Tax_2021_16_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception;
	  
	   int fnYeta6300_YE169010_Tax_2021_17_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception;
	   
	   int fnYeta6300_YE169010_Tax_2021_18_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception;
	   
	   int fnYeta6300_YE169010_Tax_2021_19_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;
	   
	   int fnYeta6300_YE169010_Tax_2021_20_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int fnYeta6300_YE169010_Tax_2021_21_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;     
 
	   
	   int fnYeta6300_YE169010_Tax_2021_22_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int fnYeta6300_YE169010_Tax_2021_23_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;    
	    
	   int fnYeta6300_YE169010_Tax_2021_24_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;   

	   int fnYeta6300_YE169010_Tax_2021_25_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception; 
	   
	   int fnYeta6300_YE169010_Tax_2021_25_01_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo)  throws Exception; 
	  
	   int fnYeta6300_YE169010_Tax_2021_26_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception;   
	   
	   int  fnYeta6300_YE169010_Tax_2021_27_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception; 
	   
	  // int  fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int fnYeta6300_YE169010_Tax_2021_29_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int fnYeta6300_YE169010_Tax_2021_30_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;   
	   

	   int fnYeta6300_YE169010_Tax_2021_31_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  


	   int fnYeta6300_YE169010_Tax_2021_31_01_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;   
	   

//	   int  fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 
	   

	   int  fnYeta6300_YE169010_Tax_2021_32_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 
	    
	   int fnYeta6300_YE169010_Tax_2021_33_Update(InfcPkgYe161060_2021_VO infcPkgYe161060Vo) throws Exception;    

	   int fnYeta6300_YE169010_Tax_2021_33_02_Update(InfcPkgYe161060_2021_VO infcPkgYe161060Vo) throws Exception;   
	   
	   int fnYeta6300_YE169010_Tax_2021_33_03_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;    
	   
	   int fnYeta6300_YE169010_Tax_2021_33_04_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;    
	    
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;   
	    
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;   
	   
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int  fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  

	   //-----
	//   int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(InfcPkgYeta2000VO  infcPkgYeta2000Vo) throws Exception; 
	   
	   String fnYeta6300_YE169010_Tax_2021_40_Update(InfcPkgYe165030_2021_VO  infcPkgYe165030Vo) throws Exception; 
	   

	   //String fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(InfcPkgYeta2000VO  infcPkgYeta2000Vo) throws Exception; 
	   
	   
	   
	   List fnYeta6300_YE169010_Tax_2021_TgYear_Select(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 

	   List fnYeta6300_YE169010_Tax_2021_1001_Select(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 
	   
	   List  fnPayr06430_PAYR442_ReTax_2021_SelectFind(InfcPkgYe165030Srh_2021_VO  searchVO) throws Exception; 
	   

	   int  fnPayr06430_PAYR442_ReTax_2021_Update(InfcPkgYe165030_2021_VO infcPkgYe165030Vo) throws Exception;  
 
	   int  fnYeta6300_YE169010_Tax_2021_50_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int  fnYeta6300_YE169010a_Tax_2021_50_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception; 
	   
	   
	   int  fnYeta6300_YE169010_Tax_2021_50_01_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int  fnYeta6300_YE169010a_Tax_2021_50_01_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception; 
	   

	   InfcPkgYe169010_2021_VO fnYeta6300_YE169010_Tax_2021_51_Select(InfcPkgYe169010Srh_2021_VO   infcPkgYe169010SrhVo) throws Exception;
	   
	   

	   InfcPkgYe169010_2021_VO fnYeta6300_YE169010_Tax_2021_2001_Select(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;
	   
 
	   InfcPkgYe169010a_2021_VO fnYeta6300_YE169010a_Tax_2021_2001_Select(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception;
	    
	   int  fnYeta6300_YE169010_Tax_2021_2002_Update(InfcPkgYe169010_2021_VO subInfcPkgYe169010Vo) throws Exception;   
	   
	   int  fnYeta6300_YE169010a_Tax_2021_2002_Update(InfcPkgYe169010a_2021_VO subInfcPkgYe169010aVo) throws Exception; 
	   
	   int  fnYeta6300_YE161020_Tax_2021_C152_STD_TX_DDC_YN_Update(InfcPkgYe161020_2021_VO infcPkgYe161020Vo) throws Exception; 
	   
	   int  fnYeta6300_YE169010a_Tax_2021_52_Update(InfcPkgYe169010a_2021_VO dscnPrc3000Vo) throws Exception;    
	   
	   String fnYeta6300_YE169010a_Tax_2021_52_Insert(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 
	 
	   int  fnYeta6300_YE169010a_Tax_2021_52_Delete(InfcPkgYe169010_2021_VO dscnPrc3000Vo) throws Exception;    
	   
	   int  fnYeta6300_YE169010_Tax_2021_2003_Select(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
		 
	// 통합으로 인해 사용안함 	
	  // int  yeta2000_ReTax_2016_DCSN_INCM_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
	   
	   //------------------------------
	   int  fnYeta6300_YE169010_Tax_2021_3001_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int  fnYeta6300_YE169010a_Tax_2021_3001_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception; 
	   

	   int  fnYeta6300_YE169010_Tax_2021_3002_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int  fnYeta6300_YE169010a_Tax_2021_3002_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception;  
	   

	   int  fnYeta6300_YE169010_Tax_2021_3003_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int  fnYeta6300_YE169010a_Tax_2021_3003_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception;  
	   
	   
	   int  fnYeta6300_YE169010_Tax_2021_3004_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int  fnYeta6300_YE169010a_Tax_2021_3004_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception;  
	   
	   int  fnYeta6300_YE169010_Tax_2021_3005_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;
	   
	   int  fnYeta6300_YE169010a_Tax_2021_3005_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception;

	   int  fnYeta6300_YE169010_Tax_2021_3006_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;     
	   
	   int  fnYeta6300_YE169010a_Tax_2021_3006_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception;   
	   
	   
//사용안함 
	 //  int  fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
	    
	   int  fnYeta6300_YE169010_Tax_2021_3007_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 
	   
	   int  fnYeta6300_YE169010a_Tax_2021_3007_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception; 
	   
	   
	   int  fnYeta6300_YE169010_Tax_2021_3008_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;   
	   

	   int  fnYeta6300_YE169010a_Tax_2021_3008_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception;   
	   
	   
	   int  fnYeta6300_YE169010_Tax_2021_3009_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
	   

	   int  fnYeta6300_YE169010a_Tax_2021_3009_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception;  
	   

	   int  fnYeta6300_YE169010_Tax_2021_3010_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;         
	    

	   int  fnYeta6300_YE169010a_Tax_2021_3010_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception;         
	    
		  
	   int  fnYeta6300_YE169010_Tax_2021_3011_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;   
	
	   int  fnYeta6300_YE169010a_Tax_2021_3011_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception;   
	    

	   int  fnYeta6300_YE169010_Tax_2021_3012_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
	   
	   int  fnYeta6300_YE169010a_Tax_2021_3012_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception;  
	   
	   int  fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;
	   
	   int  fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception; 
	   

	   
	   int  fnYeta6300_YE169010_Tax_2021_51_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;     
	   

	   int  fnYeta6300_YE169010a_Tax_2021_51_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception;     
	   
	   
	   int  fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;      
 

	   List fnYeta6300_YE169010_Tax_2021_A01_Select(InfcPkgYe169010Srh_2021_VO infcPkgYe169010Vo) throws Exception; 
 
	   int  fnYeta6300_Ye161060_Tax_2021_I1_Update(InfcPkgYe161060_2021_VO    inputYe161060Vo) throws Exception;
	   
	   int  fnYeta6300_Ye161070_Tax_2021_I2_Update(InfcPkgYe161070_2021_VO    inputYe161070Vo) throws Exception;
	   
	   int  fnYeta6300_Ye161080_Tax_2021_I3_Update(InfcPkgYe161080_2021_VO    inputYe161080Vo) throws Exception;
	   
	   int  fnYeta6300_YE169010_Tax_2021_TgIn01_Update(InfcPkgYe161080_2021_VO    inputYe161080Vo) throws Exception;
	   
	   int  fnYeta6300_YE169010_Tax_2021_TgIn02_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;      
	  
	   int  fnYeta6300_YE169010_Tax_2021_TgIn03_Update(InfcPkgYe161080_2021_VO    inputYe161080Vo) throws Exception;
	   
	   int  fnYeta6300_YE169010_Tax_2021_TgIn04_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;      
	   
	 
	   List fnYeta6300_YE162010_Tax_2021_A01_Select(InfcPkgYe162010Srh_2021_VO   ye162010SrhVo) throws Exception; 
	   List fnYeta6300_YE162020_Tax_2021_A01_Select(InfcPkgYe162020Srh_2021_VO infcPkgYe162020Vo) throws Exception; 
	   List fnYeta6300_YE162030_Tax_2021_A01_Select(InfcPkgYe162030Srh_2021_VO infcPkgYe162030Vo) throws Exception; 
	   List fnYeta6300_YE162040_Tax_2021_A01_Select(InfcPkgYe162040Srh_2021_VO infcPkgYe162040Vo) throws Exception; 
	   
	 
	  		 
	   int  updateYeta6300_Tax_Ye162010_01(InfcPkgYe162010_2021_VO vo) throws Exception;      
	   
	   int  updateYeta6300_Tax_Ye162010_02(InfcPkgYe162010_2021_VO vo) throws Exception;      
	   
	   int  updateYeta6300_Tax_Ye162020_01(InfcPkgYe162020_2021_VO infcPkgYe162020Vo) throws Exception;      
	   
	   int  updateYeta6300_Tax_Ye162020_02(InfcPkgYe162020_2021_VO infcPkgYe162020Vo) throws Exception;      
	   
	   int  updateYeta6300_Tax_YE162030_01(InfcPkgYe162030_2021_VO infcPkgYe162030Vo) throws Exception;      
	   
	   int  updateYeta6300_Tax_YE162040_01(InfcPkgYe162040_2021_VO infcPkgYe162040Vo) throws Exception;  
	   
	   

	   List fnYeta6300_YE162510_Tax_2021_A01_Select(InfcPkgYe162510Srh_2021_VO   ye162510SrhVo) throws Exception; 
		 
		 
	   int  updateYeta6300_Tax_Ye162510_01(InfcPkgYe162510_2021_VO vo) throws Exception;      
	   
	   int  updateYeta6300_Tax_Ye162510_02(InfcPkgYe162510_2021_VO vo) throws Exception;      
	   
	   
	   List fnYeta6300_YE162520_Tax_2021_A01_Select(InfcPkgYe162520Srh_2021_VO   ye162520SrhVo) throws Exception; 
		 
		 
	   int  updateYeta6300_Tax_Ye162520_01(InfcPkgYe162520_2021_VO vo) throws Exception;      
	  
    /********************************************************************************************************
	 * 연말정산 처리 하는부분 종료  
	 ********************************************************************************************************/ 
	  
	   
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;     
	    
	   
	   //사용안함 
	   int  fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception;  
	  
	 
          
	
	  
	    
    
}
