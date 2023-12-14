package com.app.smrmf.pkg.yeta.yeta2017.tax.service;

import java.util.List;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161050VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161055VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161060VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161070VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161080VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162010SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162020SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162030SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162040SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162510SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162510VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162520SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162520VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010aVO;

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
public interface Yeta2300PayrService {
	 
	/********************************************************************************************************
	 * 연말정산 처리 하는부분 시작  
	 ********************************************************************************************************/ 
	 int fnYeta2300_B101Y_YE161080_2017_Update(InfcPkgYe161010VO infcPkgYe161010Vo) throws Exception;
	 int fnYeta2300_All_YE161080_2017_Update(InfcPkgYe161010VO infcPkgYe161010Vo) throws Exception;
	 
	   int fnYeta2300_TaxPkg01_2017_Update(InfcPkgYe161010VO infcPkgYe161010Vo) throws Exception; 
	   
	   
	   //기본공제 인원수 산정 
	   int fnYeta2300_YE161020_Tax_2017_01_Update(InfcPkgYe161020VO infcPkgYe161020Vo) throws Exception; 
	   
	   //국민연금등
	   int fnYeta2300_YE161055_Tax_2017_02_Update(InfcPkgYe161055VO infcPkgYe161055Vo) throws Exception; 
	   //국민연금등 
	   int fnYeta2300_YE161050_Tax_2017_03_Update(InfcPkgYe161050VO infcPkgYe161050Vo) throws Exception; 
	    
	   int fnYeta2300_YE169010_Tax_2017_04_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;
	   
	   int fnYeta2300_YE169010_Tax_2017_05_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;
	   

	   int fnYeta2300_YE169010_Tax_2017_06_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
	   

	   int fnYeta2300_YE169010_Tax_2017_07_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
	    
	   int fnYeta2300_YE169010_Tax_2017_08_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;
	   
	   int fnYeta2300_YE169010_Tax_2017_09_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;   
	   
 	   int fnYeta2300_YE169010_Tax_2017_10_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 

	   int fnYeta2300_YE169010_Tax_2017_11_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
	   
	   int fnYeta2300_YE169010_Tax_2017_12_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;   
	   
	   int fnYeta2300_YE169010_Tax_2017_13_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 
	   
	   int fnYeta2300_YE169010_Tax_2017_14_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
	   //
	 
	   
	   int fnYeta2300_YE169010_Tax_2017_15_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 
	   
	   int fnYeta2300_YE169010_Tax_2017_16_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception;
	  
	   int fnYeta2300_YE169010_Tax_2017_17_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception;
	   
	   int fnYeta2300_YE169010_Tax_2017_18_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception;
	   
	   int fnYeta2300_YE169010_Tax_2017_19_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;
	   
	   int fnYeta2300_YE169010_Tax_2017_20_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
	   
	   int fnYeta2300_YE169010_Tax_2017_21_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;     
 
	   
	   int fnYeta2300_YE169010_Tax_2017_22_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 
	   
	   int fnYeta2300_YE169010_Tax_2017_23_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;    
	    
	   int fnYeta2300_YE169010_Tax_2017_24_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;   

	   int fnYeta2300_YE169010_Tax_2017_25_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
	   
	   int fnYeta2300_YE169010_Tax_2017_25_01_Update(InfcPkgYe161080VO infcPkgYe161080Vo)  throws Exception; 
	  
	   int fnYeta2300_YE169010_Tax_2017_26_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception;   
	   
	   int  fnYeta2300_YE169010_Tax_2017_27_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception; 
	   
	  // int  fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
	   
	   int fnYeta2300_YE169010_Tax_2017_29_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
	   
	   int fnYeta2300_YE169010_Tax_2017_30_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;   
	   

	   int fnYeta2300_YE169010_Tax_2017_31_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  


	   int fnYeta2300_YE169010_Tax_2017_31_01_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;   
	   

//	   int  fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 
	   

	   int  fnYeta2300_YE169010_Tax_2017_32_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 
	    
	   int fnYeta2300_YE169010_Tax_2017_33_Update(InfcPkgYe161060VO infcPkgYe161060Vo) throws Exception;    

	   int fnYeta2300_YE169010_Tax_2017_33_02_Update(InfcPkgYe161060VO infcPkgYe161060Vo) throws Exception;   
	   
	   int fnYeta2300_YE169010_Tax_2017_33_03_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;    
	   
	   int fnYeta2300_YE169010_Tax_2017_33_04_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;    
	    
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;   
	    
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;   
	   
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 
	   
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 
	   
	   int  fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  

	   //-----
	//   int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(InfcPkgYeta2000VO  infcPkgYeta2000Vo) throws Exception; 
	   
	   String fnYeta2300_YE169010_Tax_2017_40_Update(InfcPkgYe165030VO  infcPkgYe165030Vo) throws Exception; 
	   

	   //String fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(InfcPkgYeta2000VO  infcPkgYeta2000Vo) throws Exception; 
	   
	   
	   
	   List fnYeta2300_YE169010_Tax_2017_TgYear_Select(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 

	   List fnYeta2300_YE169010_Tax_2017_1001_Select(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 
	   
	   List  fnPayr06430_PAYR442_ReTax_2017_SelectFind(InfcPkgYe165030SrhVO  searchVO) throws Exception; 
	   

	   int  fnPayr06430_PAYR442_ReTax_2017_Update(InfcPkgYe165030VO infcPkgYe165030Vo) throws Exception;  
 
	   int  fnYeta2300_YE169010_Tax_2017_50_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 
	   
	   int  fnYeta2300_YE169010a_Tax_2017_50_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception; 
	   
	   
	   int  fnYeta2300_YE169010_Tax_2017_50_01_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 
	   
	   int  fnYeta2300_YE169010a_Tax_2017_50_01_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception; 
	   

	   InfcPkgYe169010VO fnYeta2300_YE169010_Tax_2017_51_Select(InfcPkgYe169010SrhVO   infcPkgYe169010SrhVo) throws Exception;
	   
	   

	   InfcPkgYe169010VO fnYeta2300_YE169010_Tax_2017_2001_Select(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;
	   
 
	   InfcPkgYe169010aVO fnYeta2300_YE169010a_Tax_2017_2001_Select(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception;
	    
	   int  fnYeta2300_YE169010_Tax_2017_2002_Update(InfcPkgYe169010VO subInfcPkgYe169010Vo) throws Exception;   
	   
	   int  fnYeta2300_YE169010a_Tax_2017_2002_Update(InfcPkgYe169010aVO subInfcPkgYe169010aVo) throws Exception; 
	   
	   int  fnYeta2300_YE161020_Tax_2017_C152_STD_TX_DDC_YN_Update(InfcPkgYe161020VO infcPkgYe161020Vo) throws Exception; 
	   
	   int  fnYeta2300_YE169010a_Tax_2017_52_Update(InfcPkgYe169010aVO dscnPrc3000Vo) throws Exception;    
	   
	   String fnYeta2300_YE169010a_Tax_2017_52_Insert(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 
	 
	   int  fnYeta2300_YE169010a_Tax_2017_52_Delete(InfcPkgYe169010VO dscnPrc3000Vo) throws Exception;    
	   
	   int  fnYeta2300_YE169010_Tax_2017_2003_Select(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
		 
	// 통합으로 인해 사용안함 	
	  // int  yeta2000_ReTax_2016_DCSN_INCM_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
	   
	   //------------------------------
	   int  fnYeta2300_YE169010_Tax_2017_3001_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 
	   
	   int  fnYeta2300_YE169010a_Tax_2017_3001_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception; 
	   

	   int  fnYeta2300_YE169010_Tax_2017_3002_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
	   
	   int  fnYeta2300_YE169010a_Tax_2017_3002_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception;  
	   

	   int  fnYeta2300_YE169010_Tax_2017_3003_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
	   
	   int  fnYeta2300_YE169010a_Tax_2017_3003_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception;  
	   
	   
	   int  fnYeta2300_YE169010_Tax_2017_3004_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
	   
	   int  fnYeta2300_YE169010a_Tax_2017_3004_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception;  
	   
	   int  fnYeta2300_YE169010_Tax_2017_3005_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;
	   
	   int  fnYeta2300_YE169010a_Tax_2017_3005_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception;

	   int  fnYeta2300_YE169010_Tax_2017_3006_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;     
	   
	   int  fnYeta2300_YE169010a_Tax_2017_3006_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception;   
	   
	   
//사용안함 
	 //  int  fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
	    
	   int  fnYeta2300_YE169010_Tax_2017_3007_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 
	   
	   int  fnYeta2300_YE169010a_Tax_2017_3007_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception; 
	   
	   
	   int  fnYeta2300_YE169010_Tax_2017_3008_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;   
	   

	   int  fnYeta2300_YE169010a_Tax_2017_3008_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception;   
	   
	   
	   int  fnYeta2300_YE169010_Tax_2017_3009_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
	   

	   int  fnYeta2300_YE169010a_Tax_2017_3009_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception;  
	   

	   int  fnYeta2300_YE169010_Tax_2017_3010_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;         
	    

	   int  fnYeta2300_YE169010a_Tax_2017_3010_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception;         
	    
		  
	   int  fnYeta2300_YE169010_Tax_2017_3011_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;   
	
	   int  fnYeta2300_YE169010a_Tax_2017_3011_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception;   
	    

	   int  fnYeta2300_YE169010_Tax_2017_3012_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
	   
	   int  fnYeta2300_YE169010a_Tax_2017_3012_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception;  
	   
	   int  fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;
	   
	   int  fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception; 
	   

	   
	   int  fnYeta2300_YE169010_Tax_2017_51_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;     
	   

	   int  fnYeta2300_YE169010a_Tax_2017_51_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception;     
	   
	   
	   int  fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;      
 

	   List fnYeta2300_YE169010_Tax_2017_A01_Select(InfcPkgYe169010SrhVO infcPkgYe169010Vo) throws Exception; 
 
	   int  fnYeta2300_Ye161060_Tax_2017_I1_Update(InfcPkgYe161060VO    inputYe161060Vo) throws Exception;
	   
	   int  fnYeta2300_Ye161070_Tax_2017_I2_Update(InfcPkgYe161070VO    inputYe161070Vo) throws Exception;
	   
	   int  fnYeta2300_Ye161080_Tax_2017_I3_Update(InfcPkgYe161080VO    inputYe161080Vo) throws Exception;
	   
	   int  fnYeta2300_YE169010_Tax_2017_TgIn01_Update(InfcPkgYe161080VO    inputYe161080Vo) throws Exception;
	   
	   int  fnYeta2300_YE169010_Tax_2017_TgIn02_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;      
	  
	   int  fnYeta2300_YE169010_Tax_2017_TgIn03_Update(InfcPkgYe161080VO    inputYe161080Vo) throws Exception;
	   
	   int  fnYeta2300_YE169010_Tax_2017_TgIn04_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;      
	   
	 
	   List fnYeta2300_YE162010_Tax_2017_A01_Select(InfcPkgYe162010SrhVO   ye162010SrhVo) throws Exception; 
	   List fnYeta2300_YE162020_Tax_2017_A01_Select(InfcPkgYe162020SrhVO infcPkgYe162020Vo) throws Exception; 
	   List fnYeta2300_YE162030_Tax_2017_A01_Select(InfcPkgYe162030SrhVO infcPkgYe162030Vo) throws Exception; 
	   List fnYeta2300_YE162040_Tax_2017_A01_Select(InfcPkgYe162040SrhVO infcPkgYe162040Vo) throws Exception; 
	   
	 
	  		 
	   int  updateYeta2300_Tax_Ye162010_01(InfcPkgYe162010VO vo) throws Exception;      
	   
	   int  updateYeta2300_Tax_Ye162010_02(InfcPkgYe162010VO vo) throws Exception;      
	   
	   int  updateYeta2300_Tax_Ye162020_01(InfcPkgYe162020VO infcPkgYe162020Vo) throws Exception;      
	   
	   int  updateYeta2300_Tax_Ye162020_02(InfcPkgYe162020VO infcPkgYe162020Vo) throws Exception;      
	   
	   int  updateYeta2300_Tax_YE162030_01(InfcPkgYe162030VO infcPkgYe162030Vo) throws Exception;      
	   
	   int  updateYeta2300_Tax_YE162040_01(InfcPkgYe162040VO infcPkgYe162040Vo) throws Exception;  
	   
	   

	   List fnYeta2300_YE162510_Tax_2017_A01_Select(InfcPkgYe162510SrhVO   ye162510SrhVo) throws Exception; 
		 
		 
	   int  updateYeta2300_Tax_Ye162510_01(InfcPkgYe162510VO vo) throws Exception;      
	   
	   int  updateYeta2300_Tax_Ye162510_02(InfcPkgYe162510VO vo) throws Exception;      
	   
	   
	   List fnYeta2300_YE162520_Tax_2017_A01_Select(InfcPkgYe162520SrhVO   ye162520SrhVo) throws Exception; 
		 
		 
	   int  updateYeta2300_Tax_Ye162520_01(InfcPkgYe162520VO vo) throws Exception;      
	  
    /********************************************************************************************************
	 * 연말정산 처리 하는부분 종료  
	 ********************************************************************************************************/ 
	  
	   
	   int fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;     
	    
	   
	   //사용안함 
	   int  fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception;  
	  
	 
          
	
	  
	    
    
}
