package com.app.smrmf.pkg.yeta.yeta2016.pdfxml.service.impl;

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
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3100VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3140VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3150VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3180VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220VO;
import com.app.smrmf.pkg.yeta.yeta2016.pdfxml.service.YetaPayr1200Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

 
/**
 * 
* <pre>
* 1. 패키지명 : com.msf.exterms.pdf.xml.service.impl
* 2. 타입명 : YetaPayr6425ServiceImpl.java
* 3. 작성일 : Jan 26, 2016 1:37:47 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Service("YetaPayr1200Service")
public class YetaPayr1200ServiceImpl extends AbstractServiceImpl  implements  YetaPayr1200Service {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(YetaPayr1200ServiceImpl.class);

    
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

   
   @Autowired
   @Resource(name="InfcPkgYeta1000DAO")
   private InfcPkgYeta1000DAO infcPkgYeta1000DAO;  
 
  
    /**
	 * YETA3900을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3900VO
	 * @return void형
	 * @exception Exception
	 */
    public void fnPayr06430_PAYR410_2015_INSU_FETC_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
    	infcPkgYeta3220DAO.fnPayr06430_PAYR410_2015_INSU_FETC_Update(infcPkgYeta2000Vo);
    }   
    
    public void fnPayr06425_PAYR415_0_2015_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_0_2015_Update(infcPkgYeta2000Vo);
    }   
   
    public void fnPayr06425_PAYR415_2016_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_Update(infcPkgYeta2000Vo);
    } 
    
    public void fnPayr06425_YE3220_2016_Update(InfcPkgYeta3220VO infcPkgYeta3220Vo) throws Exception {
    	infcPkgYeta3220DAO.fnPayr06425_YE3220_2016_Update(infcPkgYeta3220Vo);
    }
    
    public void fnPayr06430_PAYR430_2015_Delete(InfcPkgYeta3140VO vo) throws Exception {
    	infcPkgYeta3140DAO.fnPayr06430_PAYR430_2015_Delete(vo);
    } 
    
    public void fnPayr06430_Payr418_2015_Delete(InfcPkgYeta3100VO vo) throws Exception {
    	infcPkgYeta3100DAO.fnPayr06430_Payr418_2015_Delete(vo);
    } 
    
    public void fnPayr06430_PAYR440_2015_Delete(InfcPkgYeta3180VO vo) throws Exception {
    	infcPkgYeta3180DAO.fnPayr06430_PAYR440_2015_Delete(vo);
    } 
    
    public void fnPayr06430_PAYR445_2015_Delete(InfcPkgYeta3150VO vo) throws Exception {
    	infcPkgYeta3150DAO.fnPayr06430_PAYR445_2015_Delete(vo);
    } 
    
    
    public void fnPayr06425_Payr415_2016_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_Payr415_2016_Update(vo);
    }   
     
    public void fnPayr06425_JrtrAnsv_2016_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_JrtrAnsv_2016_Update(vo);
    }   
      
    public void fnPayr06425_JrtrCict_2016_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_JrtrCict_2016_Update(vo);
    }   
         
    public void fnPayr06425_PAYR415_spciRefn_2016_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_spciRefn_2016_Update(vo);
    }    
   
    public void fnPayr06425_PAYR415_2016_01_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_01_Update(vo);
    }
    
    public void fnPayr06425_PAYR415_2016_02_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_02_Update(vo);
    }
    
    public void fnPayr06425_PAYR415_2016_03_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_03_Update(vo);
    }
    
    public void fnPayr06425_PAYR415_2016_04_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_04_Update(vo);
    }
   
    public void fnPayr06425_PAYR415_2016_05_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_05_Update(vo);
    }
   
    public void fnPayr06425_PAYR415_2016_06_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_06_Update(vo);
    } 
    
    public void fnPayr06425_PAYR415_2016_07_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_07_Update(vo);
    } 
    
    public void fnPayr06425_PAYR415_2016_08_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_08_Update(vo);
    }  
    
    public void fnPayr06425_PAYR415_2016_10_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_10_Update(vo);
    }  
    
    public void fnPayr06425_PAYR415_2016_11_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_11_Update(vo);
    }  
    public void fnPayr06425_PAYR415_2016_12_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_12_Update(vo);
    }    
    
    public void fnPayr06425_PAYR415_2016_13_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_13_Update(vo);
    } 
    
    public void fnPayr06425_PAYR415_2016_14_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_14_Update(vo);
    } 
    
    public void fnPayr06425_PAYR415_2016_15_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_15_Update(vo);
    }
    
    public void fnPayr06425_PAYR415_2016_16_Update(InfcPkgYeta2000VO vo) throws Exception {
    	infcPkgYeta2000DAO.fnPayr06425_PAYR415_2016_16_Update(vo);
    }
    
    public void fnPayr06425_PAYR415_2016_18_Update(InfcPkgYeta3220VO vo) throws Exception {
    	infcPkgYeta3220DAO.fnPayr06425_PAYR415_2016_18_Update(vo);
    }
    
    public void fnPayr06430_PAYR410_2016_01_Update(InfcPkgYeta3220VO vo) throws Exception {
    	infcPkgYeta3220DAO.fnPayr06430_PAYR410_2016_01_Update(vo);
    }   
    
    
    public String fnPayr06430_PAYR430_2015_Insert(InfcPkgYeta3140VO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	 
    	
    	infcPkgYeta3140DAO.fnPayr06430_PAYR430_2015_Insert(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }
    
    public String fnPayr06430_PAYR440_2015_1_Insert(InfcPkgYeta3180VO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	 
    	
    	infcPkgYeta3180DAO.fnPayr06430_PAYR440_2015_1_Insert(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    } 
    
    
    public String fnPayr06430_Payr418_2016_Insert(InfcPkgYeta3100VO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	 
    	
    	infcPkgYeta3100DAO.fnPayr06430_Payr418_2016_Insert(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }
    
    public String fnPayr06430_PAYR445_1_2015_Insert(InfcPkgYeta3150VO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	 
    	
    	infcPkgYeta3150DAO.fnPayr06430_PAYR445_1_2015_Insert(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }
    
    public List<?> fnPayr06430_PAYR410_2015_SelectAll(InfcPkgYeta3220SrhVO searchVO) throws Exception {
        return infcPkgYeta3220DAO.fnPayr06430_PAYR410_2015_SelectAll(searchVO);
    }
     
    
   
}
