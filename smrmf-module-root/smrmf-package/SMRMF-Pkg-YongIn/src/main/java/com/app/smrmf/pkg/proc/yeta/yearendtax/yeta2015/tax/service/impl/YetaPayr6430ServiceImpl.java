package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3170SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3170VO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.YetaPayr6430Service;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc1000DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc2000DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3000DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3100DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3110DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3120DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3130DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3140DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3150DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3160DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3170DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3180DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3190DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3200DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3210DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3220DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3300DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrc3900DAO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl.dao.YetaPrcTaxDAO;

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

@Service("YetaPayr6430Service")
public class YetaPayr6430ServiceImpl extends AbstractServiceImpl  implements
        YetaPayr6430Service {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(YetaPayr6430ServiceImpl.class);

    
    @Autowired
    @Resource(name="YetaPrcTaxDAO")
    private YetaPrcTaxDAO yetaPrcTaxDAO;  
   
    
    @Autowired
    @Resource(name="YetaPrc1000DAO")
    private YetaPrc1000DAO yetaPrc1000DAO;  
  
    @Autowired
    @Resource(name="YetaPrc2000DAO")
    private YetaPrc2000DAO yetaPrc2000DAO;  
  
    @Autowired
    @Resource(name="YetaPrc3000DAO")
    private YetaPrc3000DAO yetaPrc3000DAO;  
  
    @Autowired
    @Resource(name="YetaPrc3100DAO")
    private YetaPrc3100DAO yetaPrc3100DAO;  
  
   @Autowired
    @Resource(name="YetaPrc3110DAO")
    private YetaPrc3110DAO yetaPrc3110DAO;  
  
   
    @Resource(name="YetaPrc3120DAO")
    private YetaPrc3120DAO yetaPrc3120DAO;  
  
   @Autowired
    @Resource(name="YetaPrc3130DAO")
    private YetaPrc3130DAO yetaPrc3130DAO;  
  
   
    @Resource(name="YetaPrc3140DAO")
    private YetaPrc3140DAO yetaPrc3140DAO;  
  
   @Autowired
    @Resource(name="YetaPrc3150DAO")
    private YetaPrc3150DAO yetaPrc3150DAO;   
  
   @Autowired
    @Resource(name="YetaPrc3160DAO")
    private YetaPrc3160DAO yetaPrc3160DAO;  
    
   @Autowired
    @Resource(name="YetaPrc3170DAO")
    private YetaPrc3170DAO yetaPrc3170DAO;  
    
   @Autowired
    @Resource(name="YetaPrc3180DAO")
    private YetaPrc3180DAO yetaPrc3180DAO;  
    
   @Autowired
    @Resource(name="YetaPrc3190DAO")
    private YetaPrc3190DAO yetaPrc3190DAO;  
    
   @Autowired
    @Resource(name="YetaPrc3200DAO")
    private YetaPrc3200DAO yetaPrc3200DAO;  
    
   @Autowired
    @Resource(name="YetaPrc3210DAO")
    private YetaPrc3210DAO yetaPrc3210DAO;  
    
   @Autowired
    @Resource(name="YetaPrc3220DAO")
    private YetaPrc3220DAO yetaPrc3220DAO;  
    
   @Autowired
    @Resource(name="YetaPrc3300DAO")
    private YetaPrc3300DAO yetaPrc3300DAO;  
   
   @Autowired
    @Resource(name="YetaPrc3900DAO")
    private YetaPrc3900DAO yetaPrc3900DAO;
    /** ID Generation */
    //@Resource(name="{egovYeta3900IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

   
   
   public int fnPayr06420_Yeta3140_ReTax_2015_CREATE_01_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06420_Yeta3140_ReTax_2015_CREATE_01_Update(yetaPrc2000Vo);
   }   
   
   
   public int fnPayr06420_PAYR415_ReTax_2014_CREATE_01_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06420_PAYR415_ReTax_2014_CREATE_01_Update(yetaPrc2000Vo);
   }   
   
   
   public String fnPayr06420_Yeta3300_ReTax_2015_CREATE_01_1_Insert(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
    	//LOGGER.debug(vo.toString());
   	 String dataCheck = "";
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    //	LOGGER.debug(vo.toString());
    	
   	 dataCheck = yetaPrcTaxDAO.fnPayr06420_Yeta3300_ReTax_2015_CREATE_01_1_Insert(yetaPrc2000Vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return dataCheck;
    }
   
   
   
   
   
   public int fnPayr06420_PAYR415_ReTax_2014_CREATE_02_1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	  return yetaPrcTaxDAO.fnPayr06420_PAYR415_ReTax_2014_CREATE_02_1_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06420_PAYR415_ReTax_2014_CREATE_02_2_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06420_PAYR415_ReTax_2014_CREATE_02_2_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06420_PAYR415_ReTax_2014_CREATE_02_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06420_PAYR415_ReTax_2014_CREATE_02_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_01_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_01_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_02_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_02_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_03_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_03_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_04_02_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_04_02_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_07_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_07_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_07_1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_07_1_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_07_3_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_07_3_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_07_2_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_07_2_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_07_4_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_07_4_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_07_5_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_07_5_Update(yetaPrc2000Vo);
   }   
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_07_5_1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return  yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_07_5_1_Update(yetaPrc2000Vo);
   }   
   
   
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_11_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_11_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_11_1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return  yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_11_1_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_03_1_TG_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_03_1_TG_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_03_1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_03_1_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_04_1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_04_1_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_04_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return  yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_04_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_05_01_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_05_01_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_05_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_05_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_06_01_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_06_01_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_06_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return  yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_06_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_06_1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_06_1_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_08_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_08_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_08_01_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return  yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_08_01_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_08_02_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return  yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_08_02_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_09_01_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return  yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_09_01_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_08_03_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_08_03_Update(yetaPrc2000Vo);
   } 
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_09_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_09_Update(yetaPrc2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_09_02_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_09_02_Update(yetaPrc2000Vo);
   }   
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_09_03_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_09_03_Update(yetaPrc2000Vo);
   }   
   
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_10_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_10_Update(yetaPrc2000Vo);
   }   
  
   //----
   
   public int fnPayr06430_PAYR415_ReTax_2014_CREATE_12_1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR415_ReTax_2014_CREATE_12_1_Update(yetaPrc2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_12_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_12_Update(yetaPrc2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_10_3_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return  yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_10_3_Update(yetaPrc2000Vo);
   }  
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_13_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return  yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_13_Update(yetaPrc2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_13_4_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return  yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_13_4_Update(yetaPrc2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_13_1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_13_1_Update(yetaPrc2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_13_2_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_13_2_Update(yetaPrc2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_14_TX_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_14_TX_Update(yetaPrc2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_14_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return  yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_14_Update(yetaPrc2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_14_1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_14_1_Update(yetaPrc2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_BEF_12_1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return  yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_BEF_12_1_Update(yetaPrc2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_BEF01_12_1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_BEF01_12_1_Update(yetaPrc2000Vo);
   }  
   
   public InfcPkgYeta3000VO fnPayr06430_PAYR425_ReTax_2014_SPCI_Select_Update(InfcPkgYeta3000VO vo) throws Exception {
	   InfcPkgYeta3000VO resultVO = yetaPrc3000DAO.fnPayr06430_PAYR425_ReTax_2014_SPCI_Select_Update(vo);
      //  if (resultVO == null)
      //  throw processException("info.nodata.msg");
       return resultVO;
   }
   
   public InfcPkgYeta3000VO fnPayr06430_PAYR425_ReTax_2015_DCSN_INCM_Select(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   InfcPkgYeta3000VO resultVO = yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2015_DCSN_INCM_Select(yetaPrc2000Vo);
      //  if (resultVO == null)
      //  throw processException("info.nodata.msg");
       return resultVO;
   }
    
   
   public int fnPayr06430_PAYR425_ReTax_2014_SPCI_Update(InfcPkgYeta3000VO yetaPrc3000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_SPCI_Update(yetaPrc3000Vo);
   } 
   
   public int fnPayr06430_PAYR425_ReTax_2015_SUBT_Update(InfcPkgYeta3000VO yetaPrc3000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2015_SUBT_Update(yetaPrc3000Vo);
   } 
    
   
   public int fnPayr06430_PAYR425_ReTax_2014_DCSN_INCM_Update(InfcPkgYeta3000VO yetaPrc3000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_DCSN_INCM_Update(yetaPrc3000Vo);
   } 
   
   public int yeta2000_ReTax_2015_DCSN_INCM_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.yeta2000_ReTax_2015_DCSN_INCM_Update(yetaPrc2000Vo);
   } 
  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_12_1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_12_1_Update(yetaPrc2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_15_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return  yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_15_Update(yetaPrc2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_16_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_16_Update(yetaPrc2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_17_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_17_Update(yetaPrc2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_18_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return  yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_18_Update(yetaPrc2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_19_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_19_Update(yetaPrc2000Vo);
   }
 
   
   public int fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(yetaPrc2000Vo);
   }
   
   public int fnPayr06420_Yeta3300_ReTax_2015_CREATE_01_1_Delete(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06420_Yeta3300_ReTax_2015_CREATE_01_1_Delete(yetaPrc2000Vo);
   }
   
 
   public int fnPayr06430_PAYR425_ReTax_2014_CREATE_10_1_Delete(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return  yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_10_1_Delete(yetaPrc2000Vo);
   }
 
   public String fnPayr06430_PAYR425_ReTax_2014_CREATE_10_2_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_10_2_Update(yetaPrc2000Vo);
   }
 
   public String fnPayr06430_PAYR425_ReTax_2014_CREATE_10_1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
	   return yetaPrcTaxDAO.fnPayr06430_PAYR425_ReTax_2014_CREATE_10_1_Update(yetaPrc2000Vo);
   }
    
   public List  fnPayr06430_PAYR442_PAYR425_ReTax_2014_SelectFind(InfcPkgYeta2000VO searchVO) throws Exception {
       return yetaPrcTaxDAO.fnPayr06430_PAYR442_PAYR425_ReTax_2014_SelectFind(searchVO);
   }
 
   public List  fnPayr06430_PAYR442_ReTax_2014_SelectFind(InfcPkgYeta3170SrhVO searchVO) throws Exception {
       return yetaPrc3170DAO.fnPayr06430_PAYR442_ReTax_2014_SelectFind(searchVO);
   }
    
   public int fnPayr06430_PAYR442_ReTax_2014_Update(InfcPkgYeta3170VO upInfcPkgYeta3170Vo) throws Exception {
	   return  yetaPrc3170DAO.fnPayr06430_PAYR442_ReTax_2014_Update(upInfcPkgYeta3170Vo);
   } 
  
}
