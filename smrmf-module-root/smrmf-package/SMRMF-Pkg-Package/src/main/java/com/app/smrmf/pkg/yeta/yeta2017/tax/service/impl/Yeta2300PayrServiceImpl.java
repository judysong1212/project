package com.app.smrmf.pkg.yeta.yeta2017.tax.service.impl;

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
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe162010DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe162020DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe162030DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe162040DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe162510DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe162520DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYe162530DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.dao.InfcPkgYeta17TaxDAO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
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
import com.app.smrmf.pkg.yeta.yeta2017.tax.service.Yeta2300PayrService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Yeta3900ServiceImpl.java
 * @Description : Yeta3900 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2016.01.18
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("Yeta2300PayrService")
public class Yeta2300PayrServiceImpl extends AbstractServiceImpl  implements
        Yeta2300PayrService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(Yeta2300PayrServiceImpl.class);

    
    @Autowired
    @Resource(name="InfcPkgYeta17TaxDAO")
    private InfcPkgYeta17TaxDAO infcPkgYeta17TaxDAO;  
   
    
    /** ID Generation */
    //@Resource(name="{egovYeta3900IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
    @Autowired
	@Resource(name = "InfcPkgYe162010DAO")
	private InfcPkgYe162010DAO  infcPkgYe162010DAO;//F_연금저축계좌
	@Autowired
	@Resource(name = "InfcPkgYe162020DAO")
	private InfcPkgYe162020DAO  infcPkgYe162020DAO;//F_퇴직연금계좌명세
	@Autowired
	@Resource(name = "InfcPkgYe162030DAO")
	private InfcPkgYe162030DAO  infcPkgYe162030DAO;//F_주택마련저축
	@Autowired
	@Resource(name = "InfcPkgYe162040DAO")
	private InfcPkgYe162040DAO  infcPkgYe162040DAO;//F_장기집합투자증권저축_B1013
	@Autowired
	@Resource(name = "InfcPkgYe162510DAO")
	private InfcPkgYe162510DAO  infcPkgYe162510DAO;//G_월세액소득공제명세
	@Autowired
	@Resource(name = "InfcPkgYe162520DAO")
	private InfcPkgYe162520DAO  infcPkgYe162520DAO;//G_거주자간_금전소비대차
	@Autowired
	@Resource(name = "InfcPkgYe162530DAO")
	private InfcPkgYe162530DAO  infcPkgYe162530DAO;//G_임대차계약
 
	/********************************************************************************************************
	 * 연말정산 처리 하는부분 시작  
	 ********************************************************************************************************/ 
	 public int fnYeta2300_B101Y_YE161080_2017_Update(InfcPkgYe161010VO infcPkgYe161010Vo) throws Exception {
		   return infcPkgYeta17TaxDAO.fnYeta2300_B101Y_YE161080_2017_Update(infcPkgYe161010Vo);
	   }   
	   
	 
	 public int fnYeta2300_All_YE161080_2017_Update(InfcPkgYe161010VO infcPkgYe161010Vo) throws Exception {
		   return infcPkgYeta17TaxDAO.fnYeta2300_All_YE161080_2017_Update(infcPkgYe161010Vo);
	   }   
	   
   
   public int fnYeta2300_TaxPkg01_2017_Update(InfcPkgYe161010VO infcPkgYe161010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_TaxPkg01_2017_Update(infcPkgYe161010Vo);
   }   
   
    
   
   public int fnYeta2300_YE161020_Tax_2017_01_Update(InfcPkgYe161020VO infcPkgYe161020Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE161020_Tax_2017_01_Update(infcPkgYe161020Vo);
   }   
   
   
   public int fnYeta2300_YE161055_Tax_2017_02_Update(InfcPkgYe161055VO infcPkgYe161055Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE161055_Tax_2017_02_Update(infcPkgYe161055Vo);
   }   
    
   public int fnYeta2300_YE161050_Tax_2017_03_Update(InfcPkgYe161050VO infcPkgYe161050Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE161050_Tax_2017_03_Update(infcPkgYe161050Vo);
   }   
   
   public int fnYeta2300_YE169010_Tax_2017_04_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_04_Update(infcPkgYe169010Vo);
   } 
   
   public int fnYeta2300_YE169010_Tax_2017_05_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_05_Update(infcPkgYe169010Vo);
   }
   
   public int fnYeta2300_YE169010_Tax_2017_06_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_06_Update(infcPkgYe169010Vo);
   }  
   

   public int fnYeta2300_YE169010_Tax_2017_07_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_07_Update(infcPkgYe169010Vo);
   }
   
 
   
   public int fnYeta2300_YE169010_Tax_2017_08_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_08_Update(infcPkgYe169010Vo);
   }
   
   
   
   public int fnYeta2300_YE169010_Tax_2017_09_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_09_Update(infcPkgYe169010Vo);
   } 
   
 public int fnYeta2300_YE169010_Tax_2017_10_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_10_Update(infcPkgYe169010Vo);
 }  
   
   public int fnYeta2300_YE169010_Tax_2017_11_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_11_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta2300_YE169010_Tax_2017_12_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_12_Update(infcPkgYe169010Vo);
   } 
   
   public int fnYeta2300_YE169010_Tax_2017_13_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_13_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta2300_YE169010_Tax_2017_14_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_14_Update(infcPkgYe169010Vo);
   } 
   
  
   
   public int fnYeta2300_YE169010_Tax_2017_15_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_15_Update(infcPkgYe169010Vo);
   }   
   
   public int fnYeta2300_YE169010_Tax_2017_16_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_16_Update(infcPkgYe161070Vo);
   }   
   
   public int fnYeta2300_YE169010_Tax_2017_17_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_17_Update(infcPkgYe161070Vo);
   }  
   
   public int fnYeta2300_YE169010_Tax_2017_18_Update(InfcPkgYe161070VO infcPkgYe161070Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_18_Update(infcPkgYe161070Vo);
   }  
   
   public int fnYeta2300_YE169010_Tax_2017_19_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_19_Update(infcPkgYe169010Vo);
   } 
   
   public int fnYeta2300_YE169010_Tax_2017_20_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_20_Update(infcPkgYe169010Vo);
   }
   
   public int fnYeta2300_YE169010_Tax_2017_21_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_21_Update(infcPkgYe169010Vo);
   }  
   

   public int fnYeta2300_YE169010_Tax_2017_22_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_22_Update(infcPkgYe169010Vo);
   }  

   public int fnYeta2300_YE169010_Tax_2017_23_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_23_Update(infcPkgYe169010Vo);
   }  

   
   public int fnYeta2300_YE169010_Tax_2017_24_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_24_Update(infcPkgYe169010Vo);
   }   
   

   public int fnYeta2300_YE169010_Tax_2017_25_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_25_Update(infcPkgYe161080Vo);
   } 
   
   public int fnYeta2300_YE169010_Tax_2017_25_01_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_25_01_Update(infcPkgYe161080Vo);
   } 
    
   
   public int fnYeta2300_YE169010_Tax_2017_26_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_26_Update(infcPkgYe161080Vo);
   }   
   

   public int fnYeta2300_YE169010_Tax_2017_27_Update(InfcPkgYe161080VO infcPkgYe161080Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_27_Update(infcPkgYe161080Vo);
   }   
   

//   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(infcPkgYe169010Vo);
//   }   
   

   
   public int fnYeta2300_YE169010_Tax_2017_29_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_29_Update(infcPkgYe169010Vo);
   }   
   

   public int fnYeta2300_YE169010_Tax_2017_30_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_30_Update(infcPkgYe169010Vo);
   }   
   

   
   
   public int fnYeta2300_YE169010_Tax_2017_31_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_31_Update(infcPkgYe169010Vo);
   }   
   
   public int fnYeta2300_YE169010_Tax_2017_31_01_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_31_01_Update(infcPkgYe169010Vo);
   }
   
   
   

   
//   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//	   return  infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(infcPkgYe169010Vo);
//   } 
   

   
   public int fnYeta2300_YE169010_Tax_2017_32_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_32_Update(infcPkgYe169010Vo);
   } 
   
   //
   public int fnYeta2300_YE169010_Tax_2017_33_Update(InfcPkgYe161060VO infcPkgYe161060Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_33_Update(infcPkgYe161060Vo);
   } 

   public int fnYeta2300_YE169010_Tax_2017_33_02_Update(InfcPkgYe161060VO infcPkgYe161060Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_33_02_Update(infcPkgYe161060Vo);
   } 

   
   public int fnYeta2300_YE169010_Tax_2017_33_03_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_33_03_Update(infcPkgYe169010Vo);
   } 
   
   
   public List<?> fnYeta2300_YE169010_Tax_2017_TgYear_Select(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_TgYear_Select(infcPkgYe169010Vo);
   } 
   
   public List<?> fnYeta2300_YE169010_Tax_2017_1001_Select(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_1001_Select(infcPkgYe169010Vo);
   } 
   
    
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update(infcPkgYe169010Vo);
   }
   

   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update(infcPkgYe169010Vo);
   }
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(infcPkgYe169010Vo);
   }   
  

   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(infcPkgYe169010Vo);
   }
   

   public String fnYeta2300_YE169010_Tax_2017_40_Update(InfcPkgYe165030VO  infcPkgYe165030Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_40_Update(infcPkgYe165030Vo);
   }
   

   
   public String fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(infcPkgYe169010Vo);
   }
   

   
//   public List<?>  fnYeta2300_YE169010_Tax_2017_1001_Select(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//       return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_1001_Select(infcPkgYe169010Vo);
//   }
   

   public List  fnPayr06430_PAYR442_ReTax_2017_SelectFind(InfcPkgYe165030SrhVO searchVO) throws Exception {
       return infcPkgYeta17TaxDAO.fnPayr06430_PAYR442_ReTax_2017_SelectFind(searchVO);
   }
   

   
   public int fnPayr06430_PAYR442_ReTax_2017_Update(InfcPkgYe165030VO infcPkgYe165030Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnPayr06430_PAYR442_ReTax_2017_Update(infcPkgYe165030Vo);
   }



   
   public int fnYeta2300_YE169010_Tax_2017_50_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_50_Update(infcPkgYe169010Vo);
   } 
   
   public int fnYeta2300_YE169010a_Tax_2017_50_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_50_Update(infcPkgYe169010aVo);
   } 

   public int fnYeta2300_YE169010_Tax_2017_50_01_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_50_01_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta2300_YE169010a_Tax_2017_50_01_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_50_01_Update(infcPkgYe169010aVo);
   }  
   
   public InfcPkgYe169010VO fnYeta2300_YE169010_Tax_2017_51_Select(InfcPkgYe169010SrhVO   infcPkgYe169010SrhVo) throws Exception {
	   InfcPkgYe169010VO resultVO = (InfcPkgYe169010VO) infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_51_Select(infcPkgYe169010SrhVo);
     
       return resultVO;
   }
   
   public InfcPkgYe169010VO fnYeta2300_YE169010_Tax_2017_2001_Select(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   InfcPkgYe169010VO resultVO = infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_2001_Select(infcPkgYe169010Vo);
      //  if (resultVO == null)
      //  throw processException("info.nodata.msg");
       return resultVO;
   }
   
   public InfcPkgYe169010aVO fnYeta2300_YE169010a_Tax_2017_2001_Select(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   InfcPkgYe169010aVO resultVO = infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_2001_Select(infcPkgYe169010aVo);
      //  if (resultVO == null)
      //  throw processException("info.nodata.msg");
       return resultVO;
   }
   
   public int fnYeta2300_YE169010_Tax_2017_2002_Update(InfcPkgYe169010VO subInfcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_2002_Update(subInfcPkgYe169010Vo);
   } 
   
   public int fnYeta2300_YE169010a_Tax_2017_2002_Update(InfcPkgYe169010aVO subInfcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_2002_Update(subInfcPkgYe169010aVo);
   }  
   
   
   public int fnYeta2300_YE161020_Tax_2017_C152_STD_TX_DDC_YN_Update(InfcPkgYe161020VO infcPkgYe161020Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE161020_Tax_2017_C152_STD_TX_DDC_YN_Update(infcPkgYe161020Vo);
   }  
   public int fnYeta2300_YE169010a_Tax_2017_52_Update(InfcPkgYe169010aVO dscnPrc3000Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_52_Update(dscnPrc3000Vo);
   } 
   
   public String fnYeta2300_YE169010a_Tax_2017_52_Insert(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_52_Insert(infcPkgYe169010Vo);
   }
   
   public int fnYeta2300_YE169010a_Tax_2017_52_Delete(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_52_Delete(infcPkgYe169010Vo);
   }
   
    
   public int fnYeta2300_YE169010_Tax_2017_2003_Select(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_2003_Select(infcPkgYe169010Vo);
   } 
   

// 통합으로 인해 사용안함 	
//   public int yeta2000_ReTax_2016_DCSN_INCM_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//	   return infcPkgYeta17TaxDAO.yeta2000_ReTax_2016_DCSN_INCM_Update(infcPkgYe169010Vo);
//   } 
  

   
   public int fnYeta2300_YE169010_Tax_2017_3001_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3001_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta2300_YE169010a_Tax_2017_3001_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3001_Update(infcPkgYe169010aVo);
   }  
   

   public int fnYeta2300_YE169010_Tax_2017_3002_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3002_Update(infcPkgYe169010Vo);
   }  
   

   public int fnYeta2300_YE169010a_Tax_2017_3002_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3002_Update(infcPkgYe169010aVo);
   }  
   

   public int fnYeta2300_YE169010_Tax_2017_3003_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3003_Update(infcPkgYe169010Vo);
   }  
   

   public int fnYeta2300_YE169010a_Tax_2017_3003_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3003_Update(infcPkgYe169010aVo);
   } 
   public int fnYeta2300_YE169010_Tax_2017_3004_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3004_Update(infcPkgYe169010Vo);
   }
   
   public int fnYeta2300_YE169010a_Tax_2017_3004_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3004_Update(infcPkgYe169010aVo);
   }
   
   
   public int fnYeta2300_YE169010_Tax_2017_3005_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3005_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta2300_YE169010a_Tax_2017_3005_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3005_Update(infcPkgYe169010aVo);
   }  
   

   public int fnYeta2300_YE169010_Tax_2017_3006_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3006_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta2300_YE169010a_Tax_2017_3006_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3006_Update(infcPkgYe169010aVo);
   }
   
//   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
//	   return  infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(infcPkgYe169010Vo);
//   }  
   

   public int fnYeta2300_YE169010_Tax_2017_3007_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3007_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta2300_YE169010a_Tax_2017_3007_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3007_Update(infcPkgYe169010aVo);
   }  
   
   public int fnYeta2300_YE169010_Tax_2017_3008_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3008_Update(infcPkgYe169010Vo);
   } 
   

   public int fnYeta2300_YE169010a_Tax_2017_3008_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3008_Update(infcPkgYe169010aVo);
   } 
   
   public int fnYeta2300_YE169010_Tax_2017_3009_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3009_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta2300_YE169010a_Tax_2017_3009_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3009_Update(infcPkgYe169010aVo);
   } 
   
   public int fnYeta2300_YE169010_Tax_2017_3010_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3010_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta2300_YE169010a_Tax_2017_3010_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3010_Update(infcPkgYe169010aVo);
   }  
   
   
   public int fnYeta2300_YE169010_Tax_2017_3011_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3011_Update(infcPkgYe169010Vo);
   } 
   
   public int fnYeta2300_YE169010a_Tax_2017_3011_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3011_Update(infcPkgYe169010aVo);
   } 
   
   
   public int fnYeta2300_YE169010_Tax_2017_3012_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_3012_Update(infcPkgYe169010Vo);
   }  
   
   public int fnYeta2300_YE169010a_Tax_2017_3012_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_3012_Update(infcPkgYe169010aVo);
   }  
   
   
   public int fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(infcPkgYe169010Vo);
   }  
   

   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update(infcPkgYe169010Vo);
   }  

   
   public int fnYeta2300_YE169010_Tax_2017_51_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_51_Update(infcPkgYe169010Vo);
   }  
   

   public int fnYeta2300_YE169010a_Tax_2017_51_Update(InfcPkgYe169010aVO infcPkgYe169010aVo) throws Exception {
	   return  infcPkgYeta17TaxDAO.fnYeta2300_YE169010a_Tax_2017_51_Update(infcPkgYe169010aVo);
   } 
    
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(infcPkgYe169010Vo);
   }
 
  
   public List  fnYeta2300_YE169010_Tax_2017_A01_Select(InfcPkgYe169010SrhVO infcPkgYe169010Vo) throws Exception {
       return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_A01_Select(infcPkgYe169010Vo);
   }
   
   
   
   public List  fnYeta2300_YE162010_Tax_2017_A01_Select(InfcPkgYe162010SrhVO   ye162010SrhVo) throws Exception {
       return infcPkgYe162010DAO.fnYeta2300_YE162010_Tax_2017_A01_Select(ye162010SrhVo);
   }
   
   
   public List  fnYeta2300_YE162020_Tax_2017_A01_Select(InfcPkgYe162020SrhVO infcPkgYe162020Vo) throws Exception {
       return infcPkgYe162020DAO.fnYeta2300_YE162020_Tax_2017_A01_Select(infcPkgYe162020Vo);
   }
   
   
   public List  fnYeta2300_YE162030_Tax_2017_A01_Select(InfcPkgYe162030SrhVO infcPkgYe162030Vo) throws Exception {
       return infcPkgYe162030DAO.fnYeta2300_YE162030_Tax_2017_A01_Select(infcPkgYe162030Vo);
   }
   
   
   public List  fnYeta2300_YE162040_Tax_2017_A01_Select(InfcPkgYe162040SrhVO infcPkgYe162040Vo) throws Exception {
       return infcPkgYe162040DAO.fnYeta2300_YE162040_Tax_2017_A01_Select(infcPkgYe162040Vo);
   }
    
 
   
   public int updateYeta2300_Tax_Ye162010_01(InfcPkgYe162010VO vo) throws Exception {
	   return infcPkgYe162010DAO.updateYeta2300_Tax_Ye162010_01(vo);
   }
   
   
   public int updateYeta2300_Tax_Ye162010_02(InfcPkgYe162010VO vo) throws Exception {
	   return infcPkgYe162010DAO.updateYeta2300_Tax_Ye162010_02(vo);
   }
   
   
   public int updateYeta2300_Tax_Ye162020_01(InfcPkgYe162020VO infcPkgYe162020Vo) throws Exception {
	   return infcPkgYe162020DAO.updateYeta2300_Tax_Ye162020_01(infcPkgYe162020Vo);
   }
   
   
   public int updateYeta2300_Tax_Ye162020_02(InfcPkgYe162020VO infcPkgYe162020Vo) throws Exception {
	   return infcPkgYe162020DAO.updateYeta2300_Tax_Ye162020_02(infcPkgYe162020Vo);
   }
   
   
   public int updateYeta2300_Tax_YE162030_01(InfcPkgYe162030VO infcPkgYe162030Vo) throws Exception {
	   return infcPkgYe162030DAO.updateYeta2300_Tax_YE162030_01(infcPkgYe162030Vo);
   }
   
   
   public int updateYeta2300_Tax_YE162040_01(InfcPkgYe162040VO infcPkgYe162040Vo) throws Exception {
	   return infcPkgYe162040DAO.updateYeta2300_Tax_YE162040_01(infcPkgYe162040Vo);
   }
   
     
   public List  fnYeta2300_YE162510_Tax_2017_A01_Select(InfcPkgYe162510SrhVO   ye162510SrhVo) throws Exception {
       return infcPkgYe162510DAO.fnYeta2300_YE162510_Tax_2017_A01_Select(ye162510SrhVo);
   } 
   
   public int updateYeta2300_Tax_Ye162510_01(InfcPkgYe162510VO vo) throws Exception {
	   return infcPkgYe162510DAO.updateYeta2300_Tax_Ye162510_01(vo);
   }
   
   
   public int updateYeta2300_Tax_Ye162510_02(InfcPkgYe162510VO vo) throws Exception {
	   return infcPkgYe162510DAO.updateYeta2300_Tax_Ye162510_02(vo);
   }
   
   
   
   
    public List  fnYeta2300_YE162520_Tax_2017_A01_Select(InfcPkgYe162520SrhVO   ye162520SrhVo) throws Exception {
       return infcPkgYe162520DAO.fnYeta2300_YE162520_Tax_2017_A01_Select(ye162520SrhVo);
   }  
   public int updateYeta2300_Tax_Ye162520_01(InfcPkgYe162520VO vo) throws Exception {
	   return infcPkgYe162520DAO.updateYeta2300_Tax_Ye162520_01(vo);
   }
   
   
   
   public int fnYeta2300_Ye161060_Tax_2017_I1_Update(InfcPkgYe161060VO    inputYe161060Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_Ye161060_Tax_2017_I1_Update(inputYe161060Vo);
   }
   
   public int fnYeta2300_Ye161070_Tax_2017_I2_Update(InfcPkgYe161070VO    inputYe161070Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_Ye161070_Tax_2017_I2_Update(inputYe161070Vo);
   }
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update(infcPkgYe169010Vo);
   } 
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update(infcPkgYe169010Vo);
   } 
   public int fnYeta2300_Ye161080_Tax_2017_I3_Update(InfcPkgYe161080VO    inputYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_Ye161080_Tax_2017_I3_Update(inputYe161080Vo);
   }
   
   public int fnYeta2300_YE169010_Tax_2017_TgIn01_Update(InfcPkgYe161080VO    inputYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_TgIn01_Update(inputYe161080Vo);
   }
   
   public int fnYeta2300_YE169010_Tax_2017_TgIn02_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_TgIn02_Update(infcPkgYe169010Vo);
   }
   
   
   public int fnYeta2300_YE169010_Tax_2017_TgIn03_Update(InfcPkgYe161080VO    inputYe161080Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_TgIn03_Update(inputYe161080Vo);
   }
   
   public int fnYeta2300_YE169010_Tax_2017_TgIn04_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_TgIn04_Update(infcPkgYe169010Vo);
   }
   
   public int fnYeta2300_YE169010_Tax_2017_33_04_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnYeta2300_YE169010_Tax_2017_33_04_Update(infcPkgYe169010Vo);
   } 
   
	/********************************************************************************************************
	 * 연말정산 처리 하는부분 종료  
	 ********************************************************************************************************/ 
	      
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update(infcPkgYe169010Vo);
   }   
     
   
   public int fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(InfcPkgYe169010VO infcPkgYe169010Vo) throws Exception {
	   return infcPkgYeta17TaxDAO.fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(infcPkgYe169010Vo);
   }

 
 

 
  
}
