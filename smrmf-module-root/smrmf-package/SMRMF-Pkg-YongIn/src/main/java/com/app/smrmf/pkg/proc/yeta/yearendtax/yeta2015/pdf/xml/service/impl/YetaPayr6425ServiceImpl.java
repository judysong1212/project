package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.pdf.xml.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3100VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3140VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3150VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3180VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220VO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.pdf.xml.service.YetaPayr6425Service;
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
@Service("YetaPayr6425Service")
public class YetaPayr6425ServiceImpl extends AbstractServiceImpl  implements  YetaPayr6425Service {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(YetaPayr6425ServiceImpl.class);

    
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
 
    /**
	 * YETA3900을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3900VO
	 * @return void형
	 * @exception Exception
	 */
    public void fnPayr06430_PAYR410_2014_INSU_FETC_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
    	yetaPrc3220DAO.fnPayr06430_PAYR410_2014_INSU_FETC_Update(yetaPrc2000Vo);
    }   
    
    public void fnPayr06425_PAYR415_0_2014_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_0_2014_Update(yetaPrc2000Vo);
    }   
   
    public void fnPayr06425_PAYR415_2014_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_2014_Update(yetaPrc2000Vo);
    } 
    
    public void fnPayr06430_PAYR430_2014_Delete(InfcPkgYeta3140VO vo) throws Exception {
    	yetaPrc3140DAO.fnPayr06430_PAYR430_2014_Delete(vo);
    } 
    
    public void fnPayr06430_Payr418_2014_Delete(InfcPkgYeta3100VO vo) throws Exception {
    	yetaPrc3100DAO.fnPayr06430_Payr418_2014_Delete(vo);
    } 
    
    public void fnPayr06430_PAYR440_2014_Delete(InfcPkgYeta3180VO vo) throws Exception {
    	yetaPrc3180DAO.fnPayr06430_PAYR440_2014_Delete(vo);
    } 
    
    public void fnPayr06430_PAYR445_2014_Delete(InfcPkgYeta3150VO vo) throws Exception {
    	yetaPrc3150DAO.fnPayr06430_PAYR445_2014_Delete(vo);
    } 
    
    
    public void fnPayr06425_Payr415_2015_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_Payr415_2015_Update(vo);
    }   
     
    public void fnPayr06425_JrtrAnsv_2015_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_JrtrAnsv_2015_Update(vo);
    }   
      
    public void fnPayr06425_JrtrCict_2015_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_JrtrCict_2015_Update(vo);
    }   
         
    public void fnPayr06425_PAYR415_spciRefn_2015_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_spciRefn_2015_Update(vo);
    }    
   
    public void fnPayr06425_PAYR415_2015_01_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_2015_01_Update(vo);
    }
    
    public void fnPayr06425_PAYR415_2015_02_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_2015_02_Update(vo);
    }
    
    public void fnPayr06425_PAYR415_2015_03_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_2015_03_Update(vo);
    }
    
    public void fnPayr06425_PAYR415_2015_04_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_2015_04_Update(vo);
    }
   
    public void fnPayr06425_PAYR415_2015_05_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_2015_05_Update(vo);
    }
   
    public void fnPayr06425_PAYR415_2015_06_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_2015_06_Update(vo);
    } 
    
    public void fnPayr06425_PAYR415_2015_07_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_2015_07_Update(vo);
    } 
    
    public void fnPayr06425_PAYR415_2015_08_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_2015_08_Update(vo);
    }  
    
    public void fnPayr06425_PAYR415_2015_10_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_2015_10_Update(vo);
    }  
    
    public void fnPayr06425_PAYR415_2015_11_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_2015_11_Update(vo);
    }  
    public void fnPayr06425_PAYR415_2015_12_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_2015_12_Update(vo);
    }    
    
    public void fnPayr06425_PAYR415_2015_13_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_2015_13_Update(vo);
    } 
    
    public void fnPayr06425_PAYR415_2015_14_Update(InfcPkgYeta2000VO vo) throws Exception {
    	yetaPrc2000DAO.fnPayr06425_PAYR415_2015_14_Update(vo);
    } 
    
    public void fnPayr06430_PAYR410_2015_01_Update(InfcPkgYeta3220VO vo) throws Exception {
    	yetaPrc3220DAO.fnPayr06430_PAYR410_2015_01_Update(vo);
    }   
    
    
    public String fnPayr06430_PAYR430_2014_Insert(InfcPkgYeta3140VO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	 
    	
    	yetaPrc3140DAO.fnPayr06430_PAYR430_2014_Insert(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }
    
    public String fnPayr06430_PAYR440_2014_1_Insert(InfcPkgYeta3180VO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	 
    	
    	yetaPrc3180DAO.fnPayr06430_PAYR440_2014_1_Insert(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    } 
    
    
    public String fnPayr06430_Payr418_2014_Insert(InfcPkgYeta3100VO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	 
    	
    	yetaPrc3100DAO.fnPayr06430_Payr418_2014_Insert(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }
    
    public String fnPayr06430_PAYR445_1_2014_Insert(InfcPkgYeta3150VO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	 
    	
    	yetaPrc3150DAO.fnPayr06430_PAYR445_1_2014_Insert(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }
    
    public List<?> fnPayr06430_PAYR410_2014_SelectAll(InfcPkgYeta3220SrhVO searchVO) throws Exception {
        return yetaPrc3220DAO.fnPayr06430_PAYR410_2014_SelectAll(searchVO);
    }
     
    
   
}
