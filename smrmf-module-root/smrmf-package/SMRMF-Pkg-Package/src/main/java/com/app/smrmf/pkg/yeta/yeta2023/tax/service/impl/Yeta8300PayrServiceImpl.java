package com.app.smrmf.pkg.yeta.yeta2023.tax.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta1000DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta2000DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3000DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3100DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3110DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3120DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3130DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3140DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3150DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3160DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3170DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3180DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3190DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3200DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3210DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3220DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3300DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYeta3900DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe162010_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe162020_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe162030_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe162040_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe162510_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe162520_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYe162530_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.dao.InfcPkgYeta17Tax_2023_DAO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161020_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161050_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161055_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161060_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161070_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161080_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162010Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162020Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162020_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162030Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162030_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162040Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162040_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162510Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162510_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162520Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe162520_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe165030Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe165030_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe169010Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe169010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe169010a_2023_VO;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe166020Srh_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe166020_2023_VO;

import com.app.smrmf.pkg.yeta.yeta2023.tax.service.Yeta8300PayrService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Yeta8900ServiceImpl.java
 * @Description : Yeta8900 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("Yeta8300PayrService")
public class Yeta8300PayrServiceImpl extends AbstractServiceImpl  implements
        Yeta8300PayrService {
    private static final Logger LOGGER = LoggerFactory.getLogger(Yeta8300PayrServiceImpl.class);

    @Autowired
    @Resource(name="InfcPkgYeta17Tax_2023_DAO")
    private InfcPkgYeta17Tax_2023_DAO infcPkgYeta17TaxDAO;  
    /** ID Generation */
    //@Resource(name="{egovYeta3900IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
    @Autowired
	@Resource(name = "InfcPkgYe162010_2023_DAO")
	private InfcPkgYe162010_2023_DAO  infcPkgYe162010DAO;//F_연금저축계좌
	@Autowired
	@Resource(name = "InfcPkgYe162020_2023_DAO")
	private InfcPkgYe162020_2023_DAO  infcPkgYe162020DAO;//F_퇴직연금계좌명세
	@Autowired
	@Resource(name = "InfcPkgYe162030_2023_DAO")
	private InfcPkgYe162030_2023_DAO  infcPkgYe162030DAO;//F_주택마련저축
	@Autowired
	@Resource(name = "InfcPkgYe162040_2023_DAO")
	private InfcPkgYe162040_2023_DAO  infcPkgYe162040DAO;//F_장기집합투자증권저축_B1013
	@Autowired
	@Resource(name = "InfcPkgYe162510_2023_DAO")
	private InfcPkgYe162510_2023_DAO  infcPkgYe162510DAO;//G_월세액소득공제명세
	@Autowired
	@Resource(name = "InfcPkgYe162520_2023_DAO")
	private InfcPkgYe162520_2023_DAO  infcPkgYe162520DAO;//G_거주자간_금전소비대차
	@Autowired
	@Resource(name = "InfcPkgYe162530_2023_DAO")
	private InfcPkgYe162530_2023_DAO  infcPkgYe162530DAO;//G_임대차계약
	
 
	/********************************************************************************************************
	 * 연말정산 처리 하는부분 시작  
	 ********************************************************************************************************/ 
	 public int fnYeta8300_B101Y_YE161080_2023_Update(InfcPkgYe161010_2023_VO infcPkgYe161010Vo) throws Exception {
		   return infcPkgYeta17TaxDAO.fnYeta8300_B101Y_YE161080_2023_Update(infcPkgYe161010Vo);
	   }   
	   
	 
	 public int fnYeta8300_All_YE161080_2023_Update(InfcPkgYe161010_2023_VO infcPkgYe161010Vo) throws Exception {
		   return infcPkgYeta17TaxDAO.fnYeta8300_All_YE161080_2023_Update(infcPkgYe161010Vo);
	   }   
	   
   
   public int fnYeta8300_TaxPkg01_2023_Update(InfcPkgYe161010_2023_VO infcPkgYe161010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_TaxPkg01_2023_Update(infcPkgYe161010Vo);
   }   
   
    
   
   public int fnYeta8300_YE161020_Tax_2023_01_Update(InfcPkgYe161020_2023_VO infcPkgYe161020Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE161020_Tax_2023_01_Update(infcPkgYe161020Vo);
   }   
   
   
   public int fnYeta8300_YE161055_Tax_2023_02_Update(InfcPkgYe161055_2023_VO infcPkgYe161055Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE161055_Tax_2023_02_Update(infcPkgYe161055Vo);
   }   
    
   public int fnYeta8300_YE161050_Tax_2023_03_Update(InfcPkgYe161050_2023_VO infcPkgYe161050Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE161050_Tax_2023_03_Update(infcPkgYe161050Vo);
   }   
   
   public int fnYeta8300_YE169010_Tax_2023_04_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_04_Update(infcPkgYe169010Vo);
   } 
   
   public int fnYeta8300_YE169010_Tax_2023_05_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_05_Update(infcPkgYe169010Vo);
   }
   
   public int fnYeta8300_YE169010_Tax_2023_06_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_06_Update(infcPkgYe169010Vo);
   }  
   

   public int fnYeta8300_YE169010_Tax_2023_07_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_07_Update(infcPkgYe169010Vo);
   }
   
 
   
   public int fnYeta8300_YE169010_Tax_2023_08_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_08_Update(infcPkgYe169010Vo);
   }
   
   
   
   public int fnYeta8300_YE169010_Tax_2023_09_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_09_Update(infcPkgYe169010Vo);
   } 
   
 public int fnYeta8300_YE169010_Tax_2023_10_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_10_Update(infcPkgYe169010Vo);
 }  
   
   public int fnYeta8300_YE169010_Tax_2023_11_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_11_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta8300_YE169010_Tax_2023_12_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_12_Update(infcPkgYe169010Vo);
   } 
   
   public int fnYeta8300_YE169010_Tax_2023_13_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_13_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta8300_YE169010_Tax_2023_14_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_14_Update(infcPkgYe169010Vo);
   } 
   
  
   
   public int fnYeta8300_YE169010_Tax_2023_15_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_15_Update(infcPkgYe169010Vo);
   }   
   
   public int fnYeta8300_YE169010_Tax_2023_16_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_16_Update(infcPkgYe161070Vo);
   }   
   
   public int fnYeta8300_YE169010_Tax_2023_17_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_17_Update(infcPkgYe161070Vo);
   }  
   
   public int fnYeta8300_YE169010_Tax_2023_18_Update(InfcPkgYe161070_2023_VO infcPkgYe161070Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_18_Update(infcPkgYe161070Vo);
   }  
   
   //2023연말정산_추가
   public int fnYeta8300_YE169010_Tax_2023_18_1_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_18_1_Update(infcPkgYe169010Vo);
   } 
   
   //2023연말정산_추가
   public int fnYeta8300_YE169010_Tax_2023_18_2_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_18_2_Update(infcPkgYe169010Vo);
   } 
   
   //2023연말정산_추가
   public int fnYeta8300_YE169010_Tax_2023_18_3_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_18_3_Update(infcPkgYe169010Vo);
   } 
   
   //2023연말정산_추가
   public int fnYeta8300_YE169010_Tax_2023_18_4_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_18_4_Update(infcPkgYe169010Vo);
   } 
   
 //2023연말정산_추가
   public int fnYeta8300_YE169010_Tax_2023_18_5_Update(InfcPkgYe166020_2023_VO infcPkgYe166020Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_18_5_Update(infcPkgYe166020Vo);
   } 
   
 //2023연말정산_추가
   public int fnYeta8300_YE169010_Tax_2023_18_6_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_18_6_Update(infcPkgYe169010Vo);
   } 
   
   
   public int fnYeta8300_YE169010_Tax_2023_19_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_19_Update(infcPkgYe169010Vo);
   } 
   
   //2023연말정산_추가
   public int fnYeta8300_YE169010_Tax_2023_19_S_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_19_S_Update(infcPkgYe169010Vo);
   }
   
   //2023연말정산_추가
   public int fnYeta8300_YE169010_Tax_2023_19_S_1_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_19_S_1_Update(infcPkgYe169010Vo);
   }
   
   
   
   //2023연말정산_추가
   public int fnYeta8300_YE169010_Tax_2023_19_1_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_19_1_Update(infcPkgYe169010Vo);
   } 
   
   
   public int fnYeta8300_YE169010_Tax_2023_20_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_20_Update(infcPkgYe169010Vo);
   }
   
   public int fnYeta8300_YE169010_Tax_2023_21_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_21_Update(infcPkgYe169010Vo);
   }  
   

   public int fnYeta8300_YE169010_Tax_2023_22_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_22_Update(infcPkgYe169010Vo);
   }  

   public int fnYeta8300_YE169010_Tax_2023_23_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_23_Update(infcPkgYe169010Vo);
   }  

   
   public int fnYeta8300_YE169010_Tax_2023_24_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_24_Update(infcPkgYe169010Vo);
   }   
   

   public int fnYeta8300_YE169010_Tax_2023_25_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_25_Update(infcPkgYe161080Vo);
   } 
   
   public int fnYeta8300_YE169010_Tax_2023_25_01_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_25_01_Update(infcPkgYe161080Vo);
   } 
    
   
   public int fnYeta8300_YE169010_Tax_2023_26_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_26_Update(infcPkgYe161080Vo);
   }   
   

   public int fnYeta8300_YE169010_Tax_2023_27_Update(InfcPkgYe161080_2023_VO infcPkgYe161080Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_27_Update(infcPkgYe161080Vo);
   }   
   

//   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(infcPkgYe169010Vo);
//   }   
   

   
   public int fnYeta8300_YE169010_Tax_2023_29_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_29_Update(infcPkgYe169010Vo);
   }   
   

   public int fnYeta8300_YE169010_Tax_2023_30_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_30_Update(infcPkgYe169010Vo);
   }   
   

   
   
   public int fnYeta8300_YE169010_Tax_2023_31_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_31_Update(infcPkgYe169010Vo);
   }   
   
   public int fnYeta8300_YE169010_Tax_2023_31_01_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_31_01_Update(infcPkgYe169010Vo);
   }
   
   //2023연말정산_추가
   public int fnYeta8300_YE169010_Tax_2023_31_02_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_31_02_Update(infcPkgYe169010Vo);
   }
   
   
   

   
//   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//	   return  infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(infcPkgYe169010Vo);
//   } 
   

   
   public int fnYeta8300_YE169010_Tax_2023_32_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_32_Update(infcPkgYe169010Vo);
   } 
   
   //
   public int fnYeta8300_YE169010_Tax_2023_33_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_33_Update(infcPkgYe161060Vo);
   } 

   public int fnYeta8300_YE169010_Tax_2023_33_02_Update(InfcPkgYe161060_2023_VO infcPkgYe161060Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_33_02_Update(infcPkgYe161060Vo);
   } 

   
   public int fnYeta8300_YE169010_Tax_2023_33_03_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_33_03_Update(infcPkgYe169010Vo);
   } 
   
   
   public List<?> fnYeta8300_YE169010_Tax_2023_TgYear_Select(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_TgYear_Select(infcPkgYe169010Vo);
   } 
   
   public List<?> fnYeta8300_YE169010_Tax_2023_1001_Select(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_1001_Select(infcPkgYe169010Vo);
   } 
   
    
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update(infcPkgYe169010Vo);
   }
   

   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update(infcPkgYe169010Vo);
   }
   
   //2023연말정산_추가
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_023_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_023_Update(infcPkgYe169010Vo);
   }
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(infcPkgYe169010Vo);
   }   
  

   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(infcPkgYe169010Vo);
   }
   

   public String fnYeta8300_YE169010_Tax_2023_40_Update(InfcPkgYe165030_2023_VO  infcPkgYe165030Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_40_Update(infcPkgYe165030Vo);
   }
   

   
   public String fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(infcPkgYe169010Vo);
   }
   

   
//   public List<?>  fnYeta8300_YE169010_Tax_2023_1001_Select(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//       return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2023_1001_Select(infcPkgYe169010Vo);
//   }
   

   public List  fnPayr06430_PAYR442_ReTax_2023_SelectFind(InfcPkgYe165030Srh_2023_VO searchVO) throws Exception {
       return infcPkgYeta17TaxDAO.fnPayr06430_PAYR442_ReTax_2023_SelectFind(searchVO);
   }
   

   
   public int fnPayr06430_PAYR442_ReTax_2023_Update(InfcPkgYe165030_2023_VO infcPkgYe165030Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnPayr06430_PAYR442_ReTax_2023_Update(infcPkgYe165030Vo);
   }



   
   public int fnYeta8300_YE169010_Tax_2023_50_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_50_Update(infcPkgYe169010Vo);
   } 
   
   public int fnYeta8300_YE169010a_Tax_2023_50_Update(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_50_Update(infcPkgYe169010aVo);
   } 

   public int fnYeta8300_YE169010_Tax_2023_50_01_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_50_01_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta8300_YE169010a_Tax_2023_50_01_Update(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_50_01_Update(infcPkgYe169010aVo);
   }  
   
   public InfcPkgYe169010_2023_VO fnYeta8300_YE169010_Tax_2023_51_Select(InfcPkgYe169010Srh_2023_VO   infcPkgYe169010SrhVo) throws Exception {
	   InfcPkgYe169010_2023_VO resultVO = (InfcPkgYe169010_2023_VO) infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_51_Select(infcPkgYe169010SrhVo);
     
       return resultVO;
   }
   
   public InfcPkgYe169010_2023_VO fnYeta8300_YE169010_Tax_2023_2001_Select(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   InfcPkgYe169010_2023_VO resultVO = infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_2001_Select(infcPkgYe169010Vo);
      //  if (resultVO == null)
      //  throw processException("info.nodata.msg");
       return resultVO;
   }
   
   public InfcPkgYe169010a_2023_VO fnYeta8300_YE169010a_Tax_2023_2001_Select(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   InfcPkgYe169010a_2023_VO resultVO = infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_2001_Select(infcPkgYe169010aVo);
      //  if (resultVO == null)
      //  throw processException("info.nodata.msg");
       return resultVO;
   }
   
   public int fnYeta8300_YE169010_Tax_2023_2002_Update(InfcPkgYe169010_2023_VO subInfcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_2002_Update(subInfcPkgYe169010Vo);
   } 
   
   public int fnYeta8300_YE169010a_Tax_2023_2002_Update(InfcPkgYe169010a_2023_VO subInfcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_2002_Update(subInfcPkgYe169010aVo);
   }  
   
   
   public int fnYeta8300_YE161020_Tax_2023_C152_STD_TX_DDC_YN_Update(InfcPkgYe161020_2023_VO infcPkgYe161020Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE161020_Tax_2023_C152_STD_TX_DDC_YN_Update(infcPkgYe161020Vo);
   }  
   public int fnYeta8300_YE169010a_Tax_2023_52_Update(InfcPkgYe169010a_2023_VO dscnPrc3000Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_52_Update(dscnPrc3000Vo);
   } 
   
   public String fnYeta8300_YE169010a_Tax_2023_52_Insert(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_52_Insert(infcPkgYe169010Vo);
   }
   
   public int fnYeta8300_YE169010a_Tax_2023_52_Delete(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_52_Delete(infcPkgYe169010Vo);
   }
   
    
   public int fnYeta8300_YE169010_Tax_2023_2003_Select(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_2003_Select(infcPkgYe169010Vo);
   } 
   

// 통합으로 인해 사용안함 	
//   public int yeta2000_ReTax_2016_DCSN_INCM_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//	   return infcPkgYeta17TaxDAO.yeta2000_ReTax_2016_DCSN_INCM_Update(infcPkgYe169010Vo);
//   } 
  

   
   public int fnYeta8300_YE169010_Tax_2023_3001_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_3001_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta8300_YE169010a_Tax_2023_3001_Update(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_3001_Update(infcPkgYe169010aVo);
   }  
   

   public int fnYeta8300_YE169010_Tax_2023_3002_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_3002_Update(infcPkgYe169010Vo);
   }  
   

   public int fnYeta8300_YE169010a_Tax_2023_3002_Update(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_3002_Update(infcPkgYe169010aVo);
   }  
   

   public int fnYeta8300_YE169010_Tax_2023_3003_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_3003_Update(infcPkgYe169010Vo);
   }  
   

   public int fnYeta8300_YE169010a_Tax_2023_3003_Update(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_3003_Update(infcPkgYe169010aVo);
   } 
   public int fnYeta8300_YE169010_Tax_2023_3004_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_3004_Update(infcPkgYe169010Vo);
   }
   
   public int fnYeta8300_YE169010a_Tax_2023_3004_Update(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_3004_Update(infcPkgYe169010aVo);
   }
   
   
   public int fnYeta8300_YE169010_Tax_2023_3005_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_3005_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta8300_YE169010a_Tax_2023_3005_Update(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_3005_Update(infcPkgYe169010aVo);
   }  
   

   public int fnYeta8300_YE169010_Tax_2023_3006_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_3006_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta8300_YE169010a_Tax_2023_3006_Update(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_3006_Update(infcPkgYe169010aVo);
   }
   
//   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//	   return  infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(infcPkgYe169010Vo);
//   }  
   

   public int fnYeta8300_YE169010_Tax_2023_3007_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_3007_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta8300_YE169010a_Tax_2023_3007_Update(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_3007_Update(infcPkgYe169010aVo);
   }  
   
   public int fnYeta8300_YE169010_Tax_2023_3008_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_3008_Update(infcPkgYe169010Vo);
   } 
   

   public int fnYeta8300_YE169010a_Tax_2023_3008_Update(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_3008_Update(infcPkgYe169010aVo);
   } 
   
   public int fnYeta8300_YE169010_Tax_2023_3009_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_3009_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta8300_YE169010a_Tax_2023_3009_Update(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_3009_Update(infcPkgYe169010aVo);
   } 
   
   public int fnYeta8300_YE169010_Tax_2023_3010_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_3010_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta8300_YE169010a_Tax_2023_3010_Update(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_3010_Update(infcPkgYe169010aVo);
   }  
   
   
   public int fnYeta8300_YE169010_Tax_2023_3011_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_3011_Update(infcPkgYe169010Vo);
   } 
   
   public int fnYeta8300_YE169010a_Tax_2023_3011_Update(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_3011_Update(infcPkgYe169010aVo);
   } 
   
   
   public int fnYeta8300_YE169010_Tax_2023_3012_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_3012_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta8300_YE169010a_Tax_2023_3012_Update(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_3012_Update(infcPkgYe169010aVo);
   }  
   
   
   public int fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(infcPkgYe169010Vo);
   }  
   

   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update(infcPkgYe169010Vo);
   }  

   
   public int fnYeta8300_YE169010_Tax_2023_51_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_51_Update(infcPkgYe169010Vo);
   }  
   

   public int fnYeta8300_YE169010a_Tax_2023_51_Update(InfcPkgYe169010a_2023_VO infcPkgYe169010aVo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta8300_YE169010a_Tax_2023_51_Update(infcPkgYe169010aVo);
   } 
    
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(infcPkgYe169010Vo);
   }
 
  
   public List  fnYeta8300_YE169010_Tax_2023_A01_Select(InfcPkgYe169010Srh_2023_VO infcPkgYe169010Vo) throws Exception {
       return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_A01_Select(infcPkgYe169010Vo);
   }
   
   
   
   public List  fnYeta8300_YE162010_Tax_2023_A01_Select(InfcPkgYe162010Srh_2023_VO   ye162010SrhVo) throws Exception {
       return infcPkgYe162010DAO.fnYeta8300_YE162010_Tax_2023_A01_Select(ye162010SrhVo);
   }
   
   
   public List  fnYeta8300_YE162020_Tax_2023_A01_Select(InfcPkgYe162020Srh_2023_VO infcPkgYe162020Vo) throws Exception {
       return infcPkgYe162020DAO.fnYeta8300_YE162020_Tax_2023_A01_Select(infcPkgYe162020Vo);
   }
   
   
   public List  fnYeta8300_YE162030_Tax_2023_A01_Select(InfcPkgYe162030Srh_2023_VO infcPkgYe162030Vo) throws Exception {
       return infcPkgYe162030DAO.fnYeta8300_YE162030_Tax_2023_A01_Select(infcPkgYe162030Vo);
   }
   
   
   public List  fnYeta8300_YE162040_Tax_2023_A01_Select(InfcPkgYe162040Srh_2023_VO infcPkgYe162040Vo) throws Exception {
       return infcPkgYe162040DAO.fnYeta8300_YE162040_Tax_2023_A01_Select(infcPkgYe162040Vo);
   }
    
 
   
   public int updateYeta8300_Tax_Ye162010_01(InfcPkgYe162010_2023_VO vo) throws Exception {
	   return infcPkgYe162010DAO.updateYeta8300_Tax_Ye162010_01(vo);
   }
   
   
   public int updateYeta8300_Tax_Ye162010_01_S(InfcPkgYe162010_2023_VO vo) throws Exception {
	   return infcPkgYe162010DAO.updateYeta8300_Tax_Ye162010_01_S(vo);
   }
   
   
   
   public int updateYeta8300_Tax_Ye162010_02(InfcPkgYe162010_2023_VO vo) throws Exception {
	   return infcPkgYe162010DAO.updateYeta8300_Tax_Ye162010_02(vo);
   }
   
   
   public int updateYeta8300_Tax_Ye162020_01(InfcPkgYe162020_2023_VO infcPkgYe162020Vo) throws Exception {
	   return infcPkgYe162020DAO.updateYeta8300_Tax_Ye162020_01(infcPkgYe162020Vo);
   }
   
   public int updateYeta8300_Tax_Ye162020_01_S(InfcPkgYe162020_2023_VO infcPkgYe162020Vo) throws Exception {
	   return infcPkgYe162020DAO.updateYeta8300_Tax_Ye162020_01_S(infcPkgYe162020Vo);
   }
   
   
   public int updateYeta8300_Tax_Ye162020_02(InfcPkgYe162020_2023_VO infcPkgYe162020Vo) throws Exception {
	   return infcPkgYe162020DAO.updateYeta8300_Tax_Ye162020_02(infcPkgYe162020Vo);
   }
   
   
   public int updateYeta8300_Tax_YE162030_01(InfcPkgYe162030_2023_VO infcPkgYe162030Vo) throws Exception {
	   return infcPkgYe162030DAO.updateYeta8300_Tax_YE162030_01(infcPkgYe162030Vo);
   }
   
   
   public int updateYeta8300_Tax_YE162040_01(InfcPkgYe162040_2023_VO infcPkgYe162040Vo) throws Exception {
	   return infcPkgYe162040DAO.updateYeta8300_Tax_YE162040_01(infcPkgYe162040Vo);
   }
   
     
   public List  fnYeta8300_YE162510_Tax_2023_A01_Select(InfcPkgYe162510Srh_2023_VO   ye162510SrhVo) throws Exception {
       return infcPkgYe162510DAO.fnYeta8300_YE162510_Tax_2023_A01_Select(ye162510SrhVo);
   } 
   
   public int updateYeta8300_Tax_Ye162510_01(InfcPkgYe162510_2023_VO vo) throws Exception {
	   return infcPkgYe162510DAO.updateYeta8300_Tax_Ye162510_01(vo);
   }
   
   
   public int updateYeta8300_Tax_Ye162510_02(InfcPkgYe162510_2023_VO vo) throws Exception {
	   return infcPkgYe162510DAO.updateYeta8300_Tax_Ye162510_02(vo);
   }
   
   
   
   
    public List  fnYeta8300_YE162520_Tax_2023_A01_Select(InfcPkgYe162520Srh_2023_VO   ye162520SrhVo) throws Exception {
       return infcPkgYe162520DAO.fnYeta8300_YE162520_Tax_2023_A01_Select(ye162520SrhVo);
   }  
   public int updateYeta8300_Tax_Ye162520_01(InfcPkgYe162520_2023_VO vo) throws Exception {
	   return infcPkgYe162520DAO.updateYeta8300_Tax_Ye162520_01(vo);
   }
   
   
   
   public int fnYeta8300_Ye161060_Tax_2023_I1_Update(InfcPkgYe161060_2023_VO    inputYe161060Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_Ye161060_Tax_2023_I1_Update(inputYe161060Vo);
   }
   
   public int fnYeta8300_Ye161070_Tax_2023_I2_Update(InfcPkgYe161070_2023_VO    inputYe161070Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_Ye161070_Tax_2023_I2_Update(inputYe161070Vo);
   }
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update(infcPkgYe169010Vo);
   } 
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update(infcPkgYe169010Vo);
   } 
   
   //2023연말정산_추가
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_033_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_033_Update(infcPkgYe169010Vo);
   }
   
   
   public int fnYeta8300_Ye161080_Tax_2023_I3_Update(InfcPkgYe161080_2023_VO    inputYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_Ye161080_Tax_2023_I3_Update(inputYe161080Vo);
   }
   
   public int fnYeta8300_YE169010_Tax_2023_TgIn01_Update(InfcPkgYe161080_2023_VO    inputYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_TgIn01_Update(inputYe161080Vo);
   }
   
   public int fnYeta8300_YE169010_Tax_2023_TgIn02_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_TgIn02_Update(infcPkgYe169010Vo);
   }
   
   
   public int fnYeta8300_YE169010_Tax_2023_TgIn03_Update(InfcPkgYe161080_2023_VO    inputYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_TgIn03_Update(inputYe161080Vo);
   }
   
   public int fnYeta8300_YE169010_Tax_2023_TgIn04_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_TgIn04_Update(infcPkgYe169010Vo);
   }
   
   public int fnYeta8300_YE169010_Tax_2023_33_04_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta8300_YE169010_Tax_2023_33_04_Update(infcPkgYe169010Vo);
   } 
   
	/********************************************************************************************************
	 * 연말정산 처리 하는부분 종료  
	 ********************************************************************************************************/ 
	      
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update(infcPkgYe169010Vo);
   }   
     
   
   public int fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(InfcPkgYe169010_2023_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(infcPkgYe169010Vo);
   }

 
 

 
  
}