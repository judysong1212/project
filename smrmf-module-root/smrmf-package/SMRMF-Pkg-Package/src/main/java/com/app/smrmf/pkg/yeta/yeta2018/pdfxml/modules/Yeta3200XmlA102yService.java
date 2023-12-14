package com.app.smrmf.pkg.yeta.yeta2018.pdfxml.modules;

import java.util.List;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3100VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3140VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3150VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3180VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220VO;

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
public interface Yeta3200XmlA102yService {
	
	 
   /**
    * 
    * <pre>
    * 1. 개요 : 부녀자공제란 여성근로소득자 본인인경우 업데이트 처리
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : fnPayr06430_PAYR410_2014_CREATE_Update
    * @date : Jan 25, 2016
    * @author : leeheuisung
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	Jan 25, 2016		leeheuisung				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param infcPkgYeta2000VO
    * @return
    * @throws Exception
    */
   void fnPayr06430_PAYR410_2014_INSU_FETC_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception; 
   
   void fnPayr06425_PAYR415_0_2014_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception; 
   
   void fnPayr06425_PAYR415_2014_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception; 
   
   
   void fnPayr06430_PAYR430_2014_Delete(InfcPkgYeta3140VO vo) throws Exception;
   
   String fnPayr06430_PAYR430_2014_Insert(InfcPkgYeta3140VO  infcPkgYeta3140VO) throws Exception;
   
   
   String fnPayr06430_PAYR440_2014_1_Insert(InfcPkgYeta3180VO  infcPkgYeta3180VO) throws Exception;
   
   
   
   void fnPayr06430_Payr418_2014_Delete(InfcPkgYeta3100VO vo) throws Exception;
   
   void fnPayr06430_PAYR440_2014_Delete(InfcPkgYeta3180VO vo) throws Exception;
  
   
   String fnPayr06430_Payr418_2014_Insert(InfcPkgYeta3100VO  infcPkgYeta3100VO) throws Exception;
   
   void fnPayr06425_Payr415_2015_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception; 
   
   void fnPayr06425_JrtrAnsv_2015_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception;
   
   void fnPayr06425_JrtrCict_2015_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception;
   
   void fnPayr06425_PAYR415_spciRefn_2015_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception;
   
   void fnPayr06425_PAYR415_2015_01_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception;
   
   void fnPayr06425_PAYR415_2015_02_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception; 
   
   void fnPayr06425_PAYR415_2015_03_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception;  
   
   void fnPayr06425_PAYR415_2015_04_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception;  
   
   void fnPayr06425_PAYR415_2015_05_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception;  
   
   void fnPayr06425_PAYR415_2015_06_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception;  
   
   void fnPayr06425_PAYR415_2015_07_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception;  
     
   void fnPayr06425_PAYR415_2015_08_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception;
   
   void fnPayr06425_PAYR415_2015_10_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception;
   
   void fnPayr06430_PAYR445_2014_Delete(InfcPkgYeta3150VO vo) throws Exception;
   
   
   String fnPayr06430_PAYR445_1_2014_Insert(InfcPkgYeta3150VO  yetaPrc315001Vo) throws Exception;
   
   void fnPayr06425_PAYR415_2015_11_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception;
   
   void fnPayr06425_PAYR415_2015_12_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception; 
   
   void fnPayr06425_PAYR415_2015_13_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception; 
   
   void fnPayr06425_PAYR415_2015_14_Update(InfcPkgYeta2000VO infcPkgYeta2000VO) throws Exception; 
   
   List fnPayr06430_PAYR410_2014_SelectAll(InfcPkgYeta3220SrhVO infcPkgYeta3220VO) throws Exception;
   
   void fnPayr06430_PAYR410_2015_01_Update(InfcPkgYeta3220VO infcPkgYeta3220VO) throws Exception; 
   
   
}
