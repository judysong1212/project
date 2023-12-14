package com.app.smrmf.pkg.yeta.yeta2021.tax.service.impl;

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
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgYe162010_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgYe162020_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgYe162030_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgYe162040_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgYe162510_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgYe162520_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgYe162530_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2021.dao.InfcPkgYeta17Tax_2021_DAO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
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
import com.app.smrmf.pkg.yeta.yeta2021.tax.service.Yeta6300PayrService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Yeta6900ServiceImpl.java
 * @Description : Yeta6900 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("Yeta6300PayrService")
public class Yeta6300PayrServiceImpl extends AbstractServiceImpl  implements
        Yeta6300PayrService {
    private static final Logger LOGGER = LoggerFactory.getLogger(Yeta6300PayrServiceImpl.class);

    @Autowired
    @Resource(name="InfcPkgYeta17Tax_2021_DAO")
    private InfcPkgYeta17Tax_2021_DAO infcPkgYeta17TaxDAO;  
    /** ID Generation */
    //@Resource(name="{egovYeta3900IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
    @Autowired
	@Resource(name = "InfcPkgYe162010_2021_DAO")
	private InfcPkgYe162010_2021_DAO  infcPkgYe162010DAO;//F_연금저축계좌
	@Autowired
	@Resource(name = "InfcPkgYe162020_2021_DAO")
	private InfcPkgYe162020_2021_DAO  infcPkgYe162020DAO;//F_퇴직연금계좌명세
	@Autowired
	@Resource(name = "InfcPkgYe162030_2021_DAO")
	private InfcPkgYe162030_2021_DAO  infcPkgYe162030DAO;//F_주택마련저축
	@Autowired
	@Resource(name = "InfcPkgYe162040_2021_DAO")
	private InfcPkgYe162040_2021_DAO  infcPkgYe162040DAO;//F_장기집합투자증권저축_B1013
	@Autowired
	@Resource(name = "InfcPkgYe162510_2021_DAO")
	private InfcPkgYe162510_2021_DAO  infcPkgYe162510DAO;//G_월세액소득공제명세
	@Autowired
	@Resource(name = "InfcPkgYe162520_2021_DAO")
	private InfcPkgYe162520_2021_DAO  infcPkgYe162520DAO;//G_거주자간_금전소비대차
	@Autowired
	@Resource(name = "InfcPkgYe162530_2021_DAO")
	private InfcPkgYe162530_2021_DAO  infcPkgYe162530DAO;//G_임대차계약
 
	/********************************************************************************************************
	 * 연말정산 처리 하는부분 시작  
	 ********************************************************************************************************/ 
	 public int fnYeta6300_B101Y_YE161080_2021_Update(InfcPkgYe161010_2021_VO infcPkgYe161010Vo) throws Exception {
		   return infcPkgYeta17TaxDAO.fnYeta6300_B101Y_YE161080_2021_Update(infcPkgYe161010Vo);
	   }   
	   
	 
	 public int fnYeta6300_All_YE161080_2021_Update(InfcPkgYe161010_2021_VO infcPkgYe161010Vo) throws Exception {
		   return infcPkgYeta17TaxDAO.fnYeta6300_All_YE161080_2021_Update(infcPkgYe161010Vo);
	   }   
	   
   
   public int fnYeta6300_TaxPkg01_2021_Update(InfcPkgYe161010_2021_VO infcPkgYe161010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_TaxPkg01_2021_Update(infcPkgYe161010Vo);
   }   
   
    
   
   public int fnYeta6300_YE161020_Tax_2021_01_Update(InfcPkgYe161020_2021_VO infcPkgYe161020Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE161020_Tax_2021_01_Update(infcPkgYe161020Vo);
   }   
   
   
   public int fnYeta6300_YE161055_Tax_2021_02_Update(InfcPkgYe161055_2021_VO infcPkgYe161055Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE161055_Tax_2021_02_Update(infcPkgYe161055Vo);
   }   
    
   public int fnYeta6300_YE161050_Tax_2021_03_Update(InfcPkgYe161050_2021_VO infcPkgYe161050Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE161050_Tax_2021_03_Update(infcPkgYe161050Vo);
   }   
   
   public int fnYeta6300_YE169010_Tax_2021_04_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_04_Update(infcPkgYe169010Vo);
   } 
   
   public int fnYeta6300_YE169010_Tax_2021_05_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_05_Update(infcPkgYe169010Vo);
   }
   
   public int fnYeta6300_YE169010_Tax_2021_06_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_06_Update(infcPkgYe169010Vo);
   }  
   

   public int fnYeta6300_YE169010_Tax_2021_07_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_07_Update(infcPkgYe169010Vo);
   }
   
 
   
   public int fnYeta6300_YE169010_Tax_2021_08_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_08_Update(infcPkgYe169010Vo);
   }
   
   
   
   public int fnYeta6300_YE169010_Tax_2021_09_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_09_Update(infcPkgYe169010Vo);
   } 
   
 public int fnYeta6300_YE169010_Tax_2021_10_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_10_Update(infcPkgYe169010Vo);
 }  
   
   public int fnYeta6300_YE169010_Tax_2021_11_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_11_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta6300_YE169010_Tax_2021_12_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_12_Update(infcPkgYe169010Vo);
   } 
   
   public int fnYeta6300_YE169010_Tax_2021_13_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_13_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta6300_YE169010_Tax_2021_14_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_14_Update(infcPkgYe169010Vo);
   } 
   
  
   
   public int fnYeta6300_YE169010_Tax_2021_15_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_15_Update(infcPkgYe169010Vo);
   }   
   
   public int fnYeta6300_YE169010_Tax_2021_16_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_16_Update(infcPkgYe161070Vo);
   }   
   
   public int fnYeta6300_YE169010_Tax_2021_17_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_17_Update(infcPkgYe161070Vo);
   }  
   
   public int fnYeta6300_YE169010_Tax_2021_18_Update(InfcPkgYe161070_2021_VO infcPkgYe161070Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_18_Update(infcPkgYe161070Vo);
   }  
   
   public int fnYeta6300_YE169010_Tax_2021_19_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_19_Update(infcPkgYe169010Vo);
   } 
   
   public int fnYeta6300_YE169010_Tax_2021_20_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_20_Update(infcPkgYe169010Vo);
   }
   
   public int fnYeta6300_YE169010_Tax_2021_21_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_21_Update(infcPkgYe169010Vo);
   }  
   

   public int fnYeta6300_YE169010_Tax_2021_22_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_22_Update(infcPkgYe169010Vo);
   }  

   public int fnYeta6300_YE169010_Tax_2021_23_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_23_Update(infcPkgYe169010Vo);
   }  

   
   public int fnYeta6300_YE169010_Tax_2021_24_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_24_Update(infcPkgYe169010Vo);
   }   
   

   public int fnYeta6300_YE169010_Tax_2021_25_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_25_Update(infcPkgYe161080Vo);
   } 
   
   public int fnYeta6300_YE169010_Tax_2021_25_01_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_25_01_Update(infcPkgYe161080Vo);
   } 
    
   
   public int fnYeta6300_YE169010_Tax_2021_26_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_26_Update(infcPkgYe161080Vo);
   }   
   

   public int fnYeta6300_YE169010_Tax_2021_27_Update(InfcPkgYe161080_2021_VO infcPkgYe161080Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_27_Update(infcPkgYe161080Vo);
   }   
   

//   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(infcPkgYe169010Vo);
//   }   
   

   
   public int fnYeta6300_YE169010_Tax_2021_29_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_29_Update(infcPkgYe169010Vo);
   }   
   

   public int fnYeta6300_YE169010_Tax_2021_30_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_30_Update(infcPkgYe169010Vo);
   }   
   

   
   
   public int fnYeta6300_YE169010_Tax_2021_31_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_31_Update(infcPkgYe169010Vo);
   }   
   
   public int fnYeta6300_YE169010_Tax_2021_31_01_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_31_01_Update(infcPkgYe169010Vo);
   }
   
   
   

   
//   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//	   return  infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(infcPkgYe169010Vo);
//   } 
   

   
   public int fnYeta6300_YE169010_Tax_2021_32_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_32_Update(infcPkgYe169010Vo);
   } 
   
   //
   public int fnYeta6300_YE169010_Tax_2021_33_Update(InfcPkgYe161060_2021_VO infcPkgYe161060Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_33_Update(infcPkgYe161060Vo);
   } 

   public int fnYeta6300_YE169010_Tax_2021_33_02_Update(InfcPkgYe161060_2021_VO infcPkgYe161060Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_33_02_Update(infcPkgYe161060Vo);
   } 

   
   public int fnYeta6300_YE169010_Tax_2021_33_03_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_33_03_Update(infcPkgYe169010Vo);
   } 
   
   
   public List<?> fnYeta6300_YE169010_Tax_2021_TgYear_Select(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_TgYear_Select(infcPkgYe169010Vo);
   } 
   
   public List<?> fnYeta6300_YE169010_Tax_2021_1001_Select(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_1001_Select(infcPkgYe169010Vo);
   } 
   
    
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update(infcPkgYe169010Vo);
   }
   

   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update(infcPkgYe169010Vo);
   }
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(infcPkgYe169010Vo);
   }   
  

   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(infcPkgYe169010Vo);
   }
   

   public String fnYeta6300_YE169010_Tax_2021_40_Update(InfcPkgYe165030_2021_VO  infcPkgYe165030Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_40_Update(infcPkgYe165030Vo);
   }
   

   
   public String fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(infcPkgYe169010Vo);
   }
   

   
//   public List<?>  fnYeta6300_YE169010_Tax_2021_1001_Select(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//       return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2021_1001_Select(infcPkgYe169010Vo);
//   }
   

   public List  fnPayr06430_PAYR442_ReTax_2021_SelectFind(InfcPkgYe165030Srh_2021_VO searchVO) throws Exception {
       return infcPkgYeta17TaxDAO.fnPayr06430_PAYR442_ReTax_2021_SelectFind(searchVO);
   }
   

   
   public int fnPayr06430_PAYR442_ReTax_2021_Update(InfcPkgYe165030_2021_VO infcPkgYe165030Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnPayr06430_PAYR442_ReTax_2021_Update(infcPkgYe165030Vo);
   }



   
   public int fnYeta6300_YE169010_Tax_2021_50_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_50_Update(infcPkgYe169010Vo);
   } 
   
   public int fnYeta6300_YE169010a_Tax_2021_50_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_50_Update(infcPkgYe169010aVo);
   } 

   public int fnYeta6300_YE169010_Tax_2021_50_01_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_50_01_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta6300_YE169010a_Tax_2021_50_01_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_50_01_Update(infcPkgYe169010aVo);
   }  
   
   public InfcPkgYe169010_2021_VO fnYeta6300_YE169010_Tax_2021_51_Select(InfcPkgYe169010Srh_2021_VO   infcPkgYe169010SrhVo) throws Exception {
	   InfcPkgYe169010_2021_VO resultVO = (InfcPkgYe169010_2021_VO) infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_51_Select(infcPkgYe169010SrhVo);
     
       return resultVO;
   }
   
   public InfcPkgYe169010_2021_VO fnYeta6300_YE169010_Tax_2021_2001_Select(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   InfcPkgYe169010_2021_VO resultVO = infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_2001_Select(infcPkgYe169010Vo);
      //  if (resultVO == null)
      //  throw processException("info.nodata.msg");
       return resultVO;
   }
   
   public InfcPkgYe169010a_2021_VO fnYeta6300_YE169010a_Tax_2021_2001_Select(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   InfcPkgYe169010a_2021_VO resultVO = infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_2001_Select(infcPkgYe169010aVo);
      //  if (resultVO == null)
      //  throw processException("info.nodata.msg");
       return resultVO;
   }
   
   public int fnYeta6300_YE169010_Tax_2021_2002_Update(InfcPkgYe169010_2021_VO subInfcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_2002_Update(subInfcPkgYe169010Vo);
   } 
   
   public int fnYeta6300_YE169010a_Tax_2021_2002_Update(InfcPkgYe169010a_2021_VO subInfcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_2002_Update(subInfcPkgYe169010aVo);
   }  
   
   
   public int fnYeta6300_YE161020_Tax_2021_C152_STD_TX_DDC_YN_Update(InfcPkgYe161020_2021_VO infcPkgYe161020Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE161020_Tax_2021_C152_STD_TX_DDC_YN_Update(infcPkgYe161020Vo);
   }  
   public int fnYeta6300_YE169010a_Tax_2021_52_Update(InfcPkgYe169010a_2021_VO dscnPrc3000Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_52_Update(dscnPrc3000Vo);
   } 
   
   public String fnYeta6300_YE169010a_Tax_2021_52_Insert(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_52_Insert(infcPkgYe169010Vo);
   }
   
   public int fnYeta6300_YE169010a_Tax_2021_52_Delete(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_52_Delete(infcPkgYe169010Vo);
   }
   
    
   public int fnYeta6300_YE169010_Tax_2021_2003_Select(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_2003_Select(infcPkgYe169010Vo);
   } 
   

// 통합으로 인해 사용안함 	
//   public int yeta2000_ReTax_2016_DCSN_INCM_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//	   return infcPkgYeta17TaxDAO.yeta2000_ReTax_2016_DCSN_INCM_Update(infcPkgYe169010Vo);
//   } 
  

   
   public int fnYeta6300_YE169010_Tax_2021_3001_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_3001_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta6300_YE169010a_Tax_2021_3001_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_3001_Update(infcPkgYe169010aVo);
   }  
   

   public int fnYeta6300_YE169010_Tax_2021_3002_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_3002_Update(infcPkgYe169010Vo);
   }  
   

   public int fnYeta6300_YE169010a_Tax_2021_3002_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_3002_Update(infcPkgYe169010aVo);
   }  
   

   public int fnYeta6300_YE169010_Tax_2021_3003_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_3003_Update(infcPkgYe169010Vo);
   }  
   

   public int fnYeta6300_YE169010a_Tax_2021_3003_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_3003_Update(infcPkgYe169010aVo);
   } 
   public int fnYeta6300_YE169010_Tax_2021_3004_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_3004_Update(infcPkgYe169010Vo);
   }
   
   public int fnYeta6300_YE169010a_Tax_2021_3004_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_3004_Update(infcPkgYe169010aVo);
   }
   
   
   public int fnYeta6300_YE169010_Tax_2021_3005_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_3005_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta6300_YE169010a_Tax_2021_3005_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_3005_Update(infcPkgYe169010aVo);
   }  
   

   public int fnYeta6300_YE169010_Tax_2021_3006_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_3006_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta6300_YE169010a_Tax_2021_3006_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_3006_Update(infcPkgYe169010aVo);
   }
   
//   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//	   return  infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(infcPkgYe169010Vo);
//   }  
   

   public int fnYeta6300_YE169010_Tax_2021_3007_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_3007_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta6300_YE169010a_Tax_2021_3007_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_3007_Update(infcPkgYe169010aVo);
   }  
   
   public int fnYeta6300_YE169010_Tax_2021_3008_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_3008_Update(infcPkgYe169010Vo);
   } 
   

   public int fnYeta6300_YE169010a_Tax_2021_3008_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_3008_Update(infcPkgYe169010aVo);
   } 
   
   public int fnYeta6300_YE169010_Tax_2021_3009_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_3009_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta6300_YE169010a_Tax_2021_3009_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_3009_Update(infcPkgYe169010aVo);
   } 
   
   public int fnYeta6300_YE169010_Tax_2021_3010_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_3010_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta6300_YE169010a_Tax_2021_3010_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_3010_Update(infcPkgYe169010aVo);
   }  
   
   
   public int fnYeta6300_YE169010_Tax_2021_3011_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_3011_Update(infcPkgYe169010Vo);
   } 
   
   public int fnYeta6300_YE169010a_Tax_2021_3011_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_3011_Update(infcPkgYe169010aVo);
   } 
   
   
   public int fnYeta6300_YE169010_Tax_2021_3012_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_3012_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta6300_YE169010a_Tax_2021_3012_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_3012_Update(infcPkgYe169010aVo);
   }  
   
   
   public int fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(infcPkgYe169010Vo);
   }  
   

   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update(infcPkgYe169010Vo);
   }  

   
   public int fnYeta6300_YE169010_Tax_2021_51_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_51_Update(infcPkgYe169010Vo);
   }  
   

   public int fnYeta6300_YE169010a_Tax_2021_51_Update(InfcPkgYe169010a_2021_VO infcPkgYe169010aVo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta6300_YE169010a_Tax_2021_51_Update(infcPkgYe169010aVo);
   } 
    
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(infcPkgYe169010Vo);
   }
 
  
   public List  fnYeta6300_YE169010_Tax_2021_A01_Select(InfcPkgYe169010Srh_2021_VO infcPkgYe169010Vo) throws Exception {
       return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_A01_Select(infcPkgYe169010Vo);
   }
   
   
   
   public List  fnYeta6300_YE162010_Tax_2021_A01_Select(InfcPkgYe162010Srh_2021_VO   ye162010SrhVo) throws Exception {
       return infcPkgYe162010DAO.fnYeta6300_YE162010_Tax_2021_A01_Select(ye162010SrhVo);
   }
   
   
   public List  fnYeta6300_YE162020_Tax_2021_A01_Select(InfcPkgYe162020Srh_2021_VO infcPkgYe162020Vo) throws Exception {
       return infcPkgYe162020DAO.fnYeta6300_YE162020_Tax_2021_A01_Select(infcPkgYe162020Vo);
   }
   
   
   public List  fnYeta6300_YE162030_Tax_2021_A01_Select(InfcPkgYe162030Srh_2021_VO infcPkgYe162030Vo) throws Exception {
       return infcPkgYe162030DAO.fnYeta6300_YE162030_Tax_2021_A01_Select(infcPkgYe162030Vo);
   }
   
   
   public List  fnYeta6300_YE162040_Tax_2021_A01_Select(InfcPkgYe162040Srh_2021_VO infcPkgYe162040Vo) throws Exception {
       return infcPkgYe162040DAO.fnYeta6300_YE162040_Tax_2021_A01_Select(infcPkgYe162040Vo);
   }
    
 
   
   public int updateYeta6300_Tax_Ye162010_01(InfcPkgYe162010_2021_VO vo) throws Exception {
	   return infcPkgYe162010DAO.updateYeta6300_Tax_Ye162010_01(vo);
   }
   
   
   public int updateYeta6300_Tax_Ye162010_02(InfcPkgYe162010_2021_VO vo) throws Exception {
	   return infcPkgYe162010DAO.updateYeta6300_Tax_Ye162010_02(vo);
   }
   
   
   public int updateYeta6300_Tax_Ye162020_01(InfcPkgYe162020_2021_VO infcPkgYe162020Vo) throws Exception {
	   return infcPkgYe162020DAO.updateYeta6300_Tax_Ye162020_01(infcPkgYe162020Vo);
   }
   
   
   public int updateYeta6300_Tax_Ye162020_02(InfcPkgYe162020_2021_VO infcPkgYe162020Vo) throws Exception {
	   return infcPkgYe162020DAO.updateYeta6300_Tax_Ye162020_02(infcPkgYe162020Vo);
   }
   
   
   public int updateYeta6300_Tax_YE162030_01(InfcPkgYe162030_2021_VO infcPkgYe162030Vo) throws Exception {
	   return infcPkgYe162030DAO.updateYeta6300_Tax_YE162030_01(infcPkgYe162030Vo);
   }
   
   
   public int updateYeta6300_Tax_YE162040_01(InfcPkgYe162040_2021_VO infcPkgYe162040Vo) throws Exception {
	   return infcPkgYe162040DAO.updateYeta6300_Tax_YE162040_01(infcPkgYe162040Vo);
   }
   
     
   public List  fnYeta6300_YE162510_Tax_2021_A01_Select(InfcPkgYe162510Srh_2021_VO   ye162510SrhVo) throws Exception {
       return infcPkgYe162510DAO.fnYeta6300_YE162510_Tax_2021_A01_Select(ye162510SrhVo);
   } 
   
   public int updateYeta6300_Tax_Ye162510_01(InfcPkgYe162510_2021_VO vo) throws Exception {
	   return infcPkgYe162510DAO.updateYeta6300_Tax_Ye162510_01(vo);
   }
   
   
   public int updateYeta6300_Tax_Ye162510_02(InfcPkgYe162510_2021_VO vo) throws Exception {
	   return infcPkgYe162510DAO.updateYeta6300_Tax_Ye162510_02(vo);
   }
   
   
   
   
    public List  fnYeta6300_YE162520_Tax_2021_A01_Select(InfcPkgYe162520Srh_2021_VO   ye162520SrhVo) throws Exception {
       return infcPkgYe162520DAO.fnYeta6300_YE162520_Tax_2021_A01_Select(ye162520SrhVo);
   }  
   public int updateYeta6300_Tax_Ye162520_01(InfcPkgYe162520_2021_VO vo) throws Exception {
	   return infcPkgYe162520DAO.updateYeta6300_Tax_Ye162520_01(vo);
   }
   
   
   
   public int fnYeta6300_Ye161060_Tax_2021_I1_Update(InfcPkgYe161060_2021_VO    inputYe161060Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_Ye161060_Tax_2021_I1_Update(inputYe161060Vo);
   }
   
   public int fnYeta6300_Ye161070_Tax_2021_I2_Update(InfcPkgYe161070_2021_VO    inputYe161070Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_Ye161070_Tax_2021_I2_Update(inputYe161070Vo);
   }
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update(infcPkgYe169010Vo);
   } 
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update(infcPkgYe169010Vo);
   } 
   public int fnYeta6300_Ye161080_Tax_2021_I3_Update(InfcPkgYe161080_2021_VO    inputYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_Ye161080_Tax_2021_I3_Update(inputYe161080Vo);
   }
   
   public int fnYeta6300_YE169010_Tax_2021_TgIn01_Update(InfcPkgYe161080_2021_VO    inputYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_TgIn01_Update(inputYe161080Vo);
   }
   
   public int fnYeta6300_YE169010_Tax_2021_TgIn02_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_TgIn02_Update(infcPkgYe169010Vo);
   }
   
   
   public int fnYeta6300_YE169010_Tax_2021_TgIn03_Update(InfcPkgYe161080_2021_VO    inputYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_TgIn03_Update(inputYe161080Vo);
   }
   
   public int fnYeta6300_YE169010_Tax_2021_TgIn04_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_TgIn04_Update(infcPkgYe169010Vo);
   }
   
   public int fnYeta6300_YE169010_Tax_2021_33_04_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta6300_YE169010_Tax_2021_33_04_Update(infcPkgYe169010Vo);
   } 
   
	/********************************************************************************************************
	 * 연말정산 처리 하는부분 종료  
	 ********************************************************************************************************/ 
	      
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update(infcPkgYe169010Vo);
   }   
     
   
   public int fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(InfcPkgYe169010_2021_VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(infcPkgYe169010Vo);
   }

 
 

 
  
}