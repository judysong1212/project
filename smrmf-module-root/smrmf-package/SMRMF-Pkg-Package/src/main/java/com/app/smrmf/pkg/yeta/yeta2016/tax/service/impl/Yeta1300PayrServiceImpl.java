package com.app.smrmf.pkg.yeta.yeta2016.tax.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYetaTaxDAO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3170SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3170VO;
import com.app.smrmf.pkg.yeta.yeta2016.tax.service.Yeta1300PayrService;

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

@Service("Yeta1300PayrService")
public class Yeta1300PayrServiceImpl extends AbstractServiceImpl  implements
        Yeta1300PayrService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(Yeta1300PayrServiceImpl.class);

    
    @Autowired
    @Resource(name="InfcPkgYetaTaxDAO")
    private InfcPkgYetaTaxDAO infcPkgYetaTaxDAO;  
   
    
    @Autowired
    @Resource(name="InfcPkgYeta1000DAO")
    private InfcPkgYeta1000DAO infcPkgYeta1000DAO;  
  
    @Autowired
    @Resource(name="InfcPkgYeta2000DAO")
    private InfcPkgYeta2000DAO infcPkgYeta2000DAO;  
  
    @Autowired
    @Resource(name="InfcPkgYeta3000DAO")
    private InfcPkgYeta3000DAO infcPkgYeta3000DAO;  
  
    @Autowired
    @Resource(name="InfcPkgYeta3100DAO")
    private InfcPkgYeta3100DAO infcPkgYeta3100DAO;  
  
   @Autowired
    @Resource(name="InfcPkgYeta3110DAO")
    private InfcPkgYeta3110DAO infcPkgYeta3110DAO;  
  
   
    @Resource(name="InfcPkgYeta3120DAO")
    private InfcPkgYeta3120DAO infcPkgYeta3120DAO;  
  
   @Autowired
    @Resource(name="InfcPkgYeta3130DAO")
    private InfcPkgYeta3130DAO infcPkgYeta3130DAO;  
  
   
    @Resource(name="InfcPkgYeta3140DAO")
    private InfcPkgYeta3140DAO infcPkgYeta3140DAO;  
  
   @Autowired
    @Resource(name="InfcPkgYeta3150DAO")
    private InfcPkgYeta3150DAO infcPkgYeta3150DAO;   
  
   @Autowired
    @Resource(name="InfcPkgYeta3160DAO")
    private InfcPkgYeta3160DAO infcPkgYeta3160DAO;  
    
   @Autowired
    @Resource(name="InfcPkgYeta3170DAO")
    private InfcPkgYeta3170DAO infcPkgYeta3170DAO;  
    
   @Autowired
    @Resource(name="InfcPkgYeta3180DAO")
    private InfcPkgYeta3180DAO infcPkgYeta3180DAO;  
    
   @Autowired
    @Resource(name="InfcPkgYeta3190DAO")
    private InfcPkgYeta3190DAO infcPkgYeta3190DAO;  
    
   @Autowired
    @Resource(name="InfcPkgYeta3200DAO")
    private InfcPkgYeta3200DAO infcPkgYeta3200DAO;  
    
   @Autowired
    @Resource(name="InfcPkgYeta3210DAO")
    private InfcPkgYeta3210DAO infcPkgYeta3210DAO;  
    
   @Autowired
    @Resource(name="InfcPkgYeta3220DAO")
    private InfcPkgYeta3220DAO infcPkgYeta3220DAO;  
    
   @Autowired
    @Resource(name="InfcPkgYeta3300DAO")
    private InfcPkgYeta3300DAO infcPkgYeta3300DAO;  
   
   @Autowired
    @Resource(name="InfcPkgYeta3900DAO")
    private InfcPkgYeta3900DAO infcPkgYeta3900DAO;
    /** ID Generation */
    //@Resource(name="{egovYeta3900IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

   
   
   public int fnPayr06420_Yeta3140_ReTax_2016_CREATE_01_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06420_Yeta3140_ReTax_2016_CREATE_01_Update(infcPkgYeta2000Vo);
   }   
   
   
   public int fnPayr06420_PAYR415_ReTax_2016_CREATE_01_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06420_PAYR415_ReTax_2016_CREATE_01_Update(infcPkgYeta2000Vo);
   }   
   
   /**
    * 
    * <pre>
    * 1. 개요 : 
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : fnPayr06420_Yeta3300_ReTax_2015_CREATE_01_1_Insert
    * @date : 2017. 1. 25.
    * @author : atres-pc
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	2017. 1. 25.		atres-pc				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param infcPkgYeta2000Vo
    * @return
    * @throws Exception
    */
   public String fnPayr06420_Yeta3300_ReTax_2016_CREATE_01_1_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
    	//LOGGER.debug(vo.toString());
   	 String dataCheck = "";
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    //	LOGGER.debug(vo.toString());
    	
   	 dataCheck = infcPkgYetaTaxDAO.fnPayr06420_Yeta3300_ReTax_2016_CREATE_01_1_Insert(infcPkgYeta2000Vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return dataCheck;
    }
   
   
   
   
   
   public int fnPayr06420_PAYR415_ReTax_2016_CREATE_02_1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   
	  return infcPkgYetaTaxDAO.fnPayr06420_PAYR415_ReTax_2016_CREATE_02_1_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06420_PAYR415_ReTax_2016_CREATE_02_2_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   
	   return infcPkgYetaTaxDAO.fnPayr06420_PAYR415_ReTax_2016_CREATE_02_2_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06420_PAYR415_ReTax_2016_CREATE_02_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06420_PAYR415_ReTax_2016_CREATE_02_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_01_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_02_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_02_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_03_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_03_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_04_02_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_04_02_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_07_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_07_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_07_1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_07_1_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_07_3_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_07_3_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_07_2_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_07_2_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_07_4_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_07_4_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_07_5_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_07_5_Update(infcPkgYeta2000Vo);
   }   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_07_5_1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_07_5_1_Update(infcPkgYeta2000Vo);
   }   
   
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_11_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_11_Update(infcPkgYeta2000Vo);
   }   
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_11_1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_11_1_Update(infcPkgYeta2000Vo);
   } 

   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_11_2_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_11_2_Update(infcPkgYeta2000Vo);
   } 
   

   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_11_3_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_11_3_Update(infcPkgYeta2000Vo);
   } 
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_03_1_TG_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_03_1_TG_Update(infcPkgYeta2000Vo);
   }   
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_03_1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_03_1_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_04_1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_04_1_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_04_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_04_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_05_01_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_05_01_Update(infcPkgYeta2000Vo);
   }   
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_05_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_05_Update(infcPkgYeta2000Vo);
   }   
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_06_01_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_06_01_Update(infcPkgYeta2000Vo);
   }   
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_06_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_06_Update(infcPkgYeta2000Vo);
   }   
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(infcPkgYeta2000Vo);
   }   
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_08_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_08_Update(infcPkgYeta2000Vo);
   }   
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_08_01_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_08_01_Update(infcPkgYeta2000Vo);
   }   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_08_02_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_08_02_Update(infcPkgYeta2000Vo);
   }   
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(infcPkgYeta2000Vo);
   }   
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_08_03_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_08_03_Update(infcPkgYeta2000Vo);
   } 
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_Update(infcPkgYeta2000Vo);
   }   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_02_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_02_Update(infcPkgYeta2000Vo);
   }   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_09_03_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_03_Update(infcPkgYeta2000Vo);
   }   
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(infcPkgYeta2000Vo);
   }   
  
   //----
  

   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(infcPkgYeta2000Vo);
   }
 
   public String fnPayr06430_PAYR425_ReTax_2016_CREATE_10_2_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_2_Update(infcPkgYeta2000Vo);
   }
   

   
   public String fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(infcPkgYeta2000Vo);
   }
   

   
   public List  fnPayr06430_PAYR442_PAYR425_ReTax_2016_SelectFind(InfcPkgYeta2000VO searchVO) throws Exception {
       return infcPkgYetaTaxDAO.fnPayr06430_PAYR442_PAYR425_ReTax_2016_SelectFind(searchVO);
   }
   //------
   
   
   public int fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(infcPkgYeta2000Vo);
   }  
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_12_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_12_Update(infcPkgYeta2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_3_Update(infcPkgYeta2000Vo);
   }  
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_13_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_13_Update(infcPkgYeta2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_13_4_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_13_4_Update(infcPkgYeta2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_13_1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_13_1_Update(infcPkgYeta2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_13_2_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_13_2_Update(infcPkgYeta2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_14_TX_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_14_TX_Update(infcPkgYeta2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_14_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_14_Update(infcPkgYeta2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_14_1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_14_1_Update(infcPkgYeta2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(infcPkgYeta2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF01_12_1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF01_12_1_Update(infcPkgYeta2000Vo);
   }  
   
   public InfcPkgYeta3000VO fnPayr06430_PAYR425_ReTax_2016_SPCI_Select_Update(InfcPkgYeta3000VO vo) throws Exception {
	   InfcPkgYeta3000VO resultVO = infcPkgYeta3000DAO.fnPayr06430_PAYR425_ReTax_2016_SPCI_Select_Update(vo);
      //  if (resultVO == null)
      //  throw processException("info.nodata.msg");
       return resultVO;
   }
   
   public InfcPkgYeta3000VO fnPayr06430_PAYR425_ReTax_2016_DCSN_INCM_Select(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   InfcPkgYeta3000VO resultVO = infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_DCSN_INCM_Select(infcPkgYeta2000Vo);
      //  if (resultVO == null)
      //  throw processException("info.nodata.msg");
       return resultVO;
   }
    
   
   public int fnPayr06430_PAYR425_ReTax_2016_SPCI_Update(InfcPkgYeta3000VO infcPkgYeta3000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_SPCI_Update(infcPkgYeta3000Vo);
   } 
   
   public int fnPayr06430_PAYR425_ReTax_2016_SUBT_Update(InfcPkgYeta3000VO infcPkgYeta3000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_SUBT_Update(infcPkgYeta3000Vo);
   } 
   
   public int fnPayr06430_PAYR425_ReTax_2016_WKER_AMNT_Update(InfcPkgYeta3000VO infcPkgYeta3000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_WKER_AMNT_Update(infcPkgYeta3000Vo);
   } 
    
   
   
   public int fnPayr06430_PAYR425_ReTax_2016_DCSN_INCM_Update(InfcPkgYeta3000VO infcPkgYeta3000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_DCSN_INCM_Update(infcPkgYeta3000Vo);
   } 
   
   public int yeta2000_ReTax_2016_DCSN_INCM_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.yeta2000_ReTax_2016_DCSN_INCM_Update(infcPkgYeta2000Vo);
   } 
  
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_12_1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_12_1_Update(infcPkgYeta2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_15_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_15_Update(infcPkgYeta2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_16_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_16_Update(infcPkgYeta2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_17_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_17_Update(infcPkgYeta2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_18_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return  infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_18_Update(infcPkgYeta2000Vo);
   }  
   
   public int fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(infcPkgYeta2000Vo);
   }
 
   
   public int fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(infcPkgYeta2000Vo);
   }
   
   public int fnPayr06420_Yeta3300_ReTax_2016_CREATE_01_1_Delete(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
	   return infcPkgYetaTaxDAO.fnPayr06420_Yeta3300_ReTax_2016_CREATE_01_1_Delete(infcPkgYeta2000Vo);
   }
   
 
 
   public List  fnPayr06430_PAYR442_ReTax_2016_SelectFind(InfcPkgYeta3170SrhVO searchVO) throws Exception {
       return infcPkgYeta3170DAO.fnPayr06430_PAYR442_ReTax_2016_SelectFind(searchVO);
   }
    
   public int fnPayr06430_PAYR442_ReTax_2016_Update(InfcPkgYeta3170VO upInfcPkgYeta3170Vo) throws Exception {
	   return  infcPkgYeta3170DAO.fnPayr06430_PAYR442_ReTax_2016_Update(upInfcPkgYeta3170Vo);
   } 
  
}
