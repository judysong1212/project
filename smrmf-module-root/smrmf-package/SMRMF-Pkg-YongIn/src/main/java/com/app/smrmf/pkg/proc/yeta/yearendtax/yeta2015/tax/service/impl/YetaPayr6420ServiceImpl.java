package com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3210VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3900SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3900VO;
import com.app.smrmf.pkg.proc.yeta.yearendtax.yeta2015.tax.service.YetaPayr6420Service;
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

@Service("YetaPayr6420CreateService")
public class YetaPayr6420ServiceImpl extends AbstractServiceImpl  implements
        YetaPayr6420Service {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(YetaPayr6420ServiceImpl.class);

    
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
	 * 연말정산마감 신규등록 
	 * @param vo - 등록할 정보가 담긴 Yeta3900VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String fnPayr06420_PAYR420_2014_CREATE_Insert(InfcPkgYeta1000VO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	String dataCheck = "";
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	 
    	
    	dataCheck = yetaPrc1000DAO.fnPayr06420_PAYR420_2014_CREATE_Insert(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return dataCheck;
    }
    
    /**
 	 * 연말정산마감 급여내역생성 
 	 * @param vo - 등록할 정보가 담긴 Yeta3900VO
 	 * @return 등록 결과
 	 * @exception Exception
 	 */
     public String fnPayr06420_PAYR417_2014_CREATE_Insert(InfcPkgYeta3210VO yetaPrc3210Vo) throws Exception {
     	//LOGGER.debug(vo.toString());
    	 String dataCheck = "";
     	/** ID Generation Service */
     	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
     	//String id = egovIdGnrService.getNextStringId();
     	//vo.setId(id);
     //	LOGGER.debug(vo.toString());
     	
    	 dataCheck = yetaPrc3210DAO.fnPayr06420_PAYR417_2014_CREATE_Insert(yetaPrc3210Vo);
     	//TODO 해당 테이블 정보에 맞게 수정    	
         return dataCheck;
     }
     
     
     /**
  	 * 연말정산마감 급여내역생성 
  	 * @param vo - 등록할 정보가 담긴 Yeta3900VO
  	 * @return 등록 결과
  	 * @exception Exception
  	 */
      public String fnPayr06420_PAYR415_2014_CREATE_Insert(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
      	
    	  dataCheck = yetaPrc2000DAO.fnPayr06420_PAYR415_2014_CREATE_Insert(yetaPrc2000Vo);
      	//TODO 해당 테이블 정보에 맞게 수정    	
          return dataCheck;
      }
   
      /**
    	 * 연말정산 비과세 감면 생성 
    	 * @param vo - 등록할 정보가 담긴  
    	 * @return 등록 결과
    	 * @exception Exception
    	 */
        public String fnPayr06420_YETA3200_2015_CREATE_Insert(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
        	//LOGGER.debug(vo.toString());
        	 String dataCheck = "";
        	/** ID Generation Service */
        	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
        	//String id = egovIdGnrService.getNextStringId();
        	//vo.setId(id);
        //	LOGGER.debug(vo.toString());
        	
        	yetaPrc3200DAO.fnPayr06420_YETA3200_2015_CREATE_Insert(yetaPrc2000Vo);
        	//TODO 해당 테이블 정보에 맞게 수정    	
            return null;
        }
      
        /**
      	 * 연말정산 대상자 생성 가족생성 
      	 * @param vo - 등록할 정보가 담긴  
      	 * @return 등록 결과
      	 * @exception Exception
      	 */
          public String fnPayr06430_PAYR410_2014_CREATE_Insert(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
          	//LOGGER.debug(vo.toString());
        	  String dataCheck = "";
          	/** ID Generation Service */
          	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
          	//String id = egovIdGnrService.getNextStringId();
          	//vo.setId(id);
          //	LOGGER.debug(vo.toString());
          	
        	  dataCheck = yetaPrc3220DAO.fnPayr06430_PAYR410_2014_CREATE_Insert(yetaPrc2000Vo);
          	//TODO 해당 테이블 정보에 맞게 수정    	
              return dataCheck;
          }  
        
          public String fnPayr06430_PAYR443_2014_CREATE_Insert(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
            	//LOGGER.debug(vo.toString());
        	  String dataCheck = "";
            	/** ID Generation Service */
            	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
            	//String id = egovIdGnrService.getNextStringId();
            	//vo.setId(id);
            //	LOGGER.debug(vo.toString());
            	
        	  dataCheck = yetaPrc3190DAO.fnPayr06430_PAYR443_2014_CREATE_Insert(yetaPrc2000Vo);
            	//TODO 해당 테이블 정보에 맞게 수정    	
                return dataCheck;
            }     
      
          public String fnPayr06430_PAYR425_2014_CREATE_Insert(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
          	//LOGGER.debug(vo.toString());
          	String StrRtn = "";
          	/** ID Generation Service */
          	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
          	//String id = egovIdGnrService.getNextStringId();
          	//vo.setId(id);
          //	LOGGER.debug(vo.toString());
          	
          	StrRtn = yetaPrc3000DAO.fnPayr06430_PAYR425_2014_CREATE_Insert(yetaPrc2000Vo);
          	//TODO 해당 테이블 정보에 맞게 수정    	
              return StrRtn;
          }     
    
          
          
     /**
 	 * YETA3900을 조회한다.
 	 * @param vo - 조회할 정보가 담긴 Yeta3900VO
 	 * @return 조회한 YETA3900
 	 * @exception Exception
 	 */
     public InfcPkgYeta1000VO selectYeta0100ToCreateYetaPrc1000(InfcPkgYeta1000VO vo) throws Exception {
    	 InfcPkgYeta1000VO resultVO = yetaPrc1000DAO.selectYeta0100ToCreateYetaPrc1000(vo);
       //  if (resultVO == null)
        //     throw processException("info.nodata.msg");
         return resultVO;
     }
     
     public InfcPkgYeta1000VO selectYeta0100ToChkYetaPrc1000(InfcPkgYeta1000VO vo) throws Exception {
    	 InfcPkgYeta1000VO resultVO = yetaPrc1000DAO.selectYeta0100ToChkYetaPrc1000(vo);
       //  if (resultVO == null)
        //     throw processException("info.nodata.msg");
         return resultVO;
     }
     
     
     
	/**
	 * YETA3900을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Yeta3900VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertYeta3900(InfcPkgYeta3900VO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	 String dataCheck = "";
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	dataCheck = yetaPrc3900DAO.insertYeta3900(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return dataCheck;
    }

    /**
	 * YETA3900을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3900VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateYeta3900(InfcPkgYeta3900VO vo) throws Exception {
        yetaPrc3900DAO.updateYeta3900(vo);
    }

    /**
	 * YETA3900을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Yeta3900VO
	 * @return void형
	 * @exception Exception
	 */
    public void fnPayr06430_PAYR410_2014_INSU_FETC_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
    	yetaPrc3220DAO.fnPayr06430_PAYR410_2014_INSU_FETC_Update(yetaPrc2000Vo);
    }   
    
    /**
   	 * 부녀자공제란 여성근로소득자 본인인경우 업데이트 처리
   	 * @param vo - 수정할 정보가 담긴 Yeta3900VO
   	 * @return void형
   	 * @exception Exception
   	 */
       public void fnPayr06430_PAYR410_2014_CREATE_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
       	yetaPrc3220DAO.fnPayr06430_PAYR410_2014_CREATE_Update(yetaPrc2000Vo);
       }   
        
       // 415 업데이트
       // {******************************급여자료 이관 - 연말정산 업데이트   [3]*******************************************}
       public void fnPayr06520_PAYR415_2015_CREATE1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
          	yetaPrc2000DAO.fnPayr06520_PAYR415_2015_CREATE1_Update(yetaPrc2000Vo);
          }   
        
     	  //{비과세 감면 인서트 }
         //{**************************연말정산기본 비과세 감면 업데이트   [4]********************************} 
    	  	     
       public void fnPayr06420_YETA3200_2015_CREATE1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
    	   yetaPrc3200DAO.fnPayr06420_YETA3200_2015_CREATE1_Update(yetaPrc2000Vo);
          }   
     	  
        
      // {******************************급여자료 이관 - 연말정산 425 업데이트   [4]*******************************************}
        //425 업데이트
     	   public void fnPayr06530_PAYR425_2015_CREATE1_Update(InfcPkgYeta2000VO yetaPrc2000Vo) throws Exception {
     	       	yetaPrc3000DAO.fnPayr06530_PAYR425_2015_CREATE1_Update(yetaPrc2000Vo);
     	       }   
    	  
    
    
    /**
	 * YETA3900을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Yeta3900VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteYeta3900(InfcPkgYeta3900VO vo) throws Exception {
        yetaPrc3900DAO.deleteYeta3900(vo);
    }

    /**
	 * YETA3900을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Yeta3900VO
	 * @return 조회한 YETA3900
	 * @exception Exception
	 */
    public InfcPkgYeta3900VO selectYeta3900(InfcPkgYeta3900VO vo) throws Exception {
        InfcPkgYeta3900VO resultVO = yetaPrc3900DAO.selectYeta3900(vo);
      //  if (resultVO == null)
       //     throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * YETA3900 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return YETA3900 목록
	 * @exception Exception
	 */
    public List<?> selectYeta3900List(InfcPkgYeta3900SrhVO searchVO) throws Exception {
        return yetaPrc3900DAO.selectYeta3900List(searchVO);
    }

    /**
	 * YETA3900 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return YETA3900 총 갯수
	 * @exception
	 */
    public int selectYeta3900ListTotCnt(InfcPkgYeta3900SrhVO searchVO) {
		return yetaPrc3900DAO.selectYeta3900ListTotCnt(searchVO);
	}
    
}
