package com.app.smrmf.pkg.yeta.yeta2016.tax.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYe160401DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYe160402DAO;
import com.app.smrmf.infc.yearendtax.server.service.yeta2016.dao.InfcPkgYe160403DAO;
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
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160402VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160403VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta1000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.pkg.yeta.yeta2016.tax.service.Yeta1100PayrService;

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

@Service("Yeta1100PayrService")
public class Yeta1100PayrServiceImpl extends AbstractServiceImpl  implements
        Yeta1100PayrService {
        
    private static final Logger LOGGER = LoggerFactory.getLogger(Yeta1100PayrServiceImpl.class);

    // 연말정산 마감
	@Autowired
	@Resource(name = "InfcPkgYeta1000DAO")
	private InfcPkgYeta1000DAO infcPkgYeta1000DAO;
	
	// 연말정산기본
	@Autowired
	@Resource(name = "InfcPkgYeta2000DAO")
	private InfcPkgYeta2000DAO infcPkgYeta2000DAO;
	
	// 연말정산상세
	@Autowired
	@Resource(name = "InfcPkgYeta3000DAO")
	private InfcPkgYeta3000DAO infcPkgYeta3000DAO;

	@Autowired
	@Resource(name = "InfcPkgYeta3100DAO")
	private InfcPkgYeta3100DAO infcPkgYeta3100DAO;

	@Autowired
	@Resource(name = "InfcPkgYeta3110DAO")
	private InfcPkgYeta3110DAO infcPkgYeta3110DAO;

	@Resource(name = "InfcPkgYeta3120DAO")
	private InfcPkgYeta3120DAO infcPkgYeta3120DAO;

	@Autowired
	@Resource(name = "InfcPkgYeta3130DAO")
	private InfcPkgYeta3130DAO infcPkgYeta3130DAO;

	@Resource(name = "InfcPkgYeta3140DAO")
	private InfcPkgYeta3140DAO infcPkgYeta3140DAO;

	@Autowired
	@Resource(name = "InfcPkgYeta3150DAO")
	private InfcPkgYeta3150DAO infcPkgYeta3150DAO;

	@Autowired
	@Resource(name = "InfcPkgYeta3160DAO")
	private InfcPkgYeta3160DAO infcPkgYeta3160DAO;

	@Autowired
	@Resource(name = "InfcPkgYeta3170DAO")
	private InfcPkgYeta3170DAO infcPkgYeta3170DAO;

	@Autowired
	@Resource(name = "InfcPkgYeta3180DAO")
	private InfcPkgYeta3180DAO infcPkgYeta3180DAO;
	
	// 이월기부금
	@Autowired
	@Resource(name = "InfcPkgYeta3190DAO")
	private InfcPkgYeta3190DAO infcPkgYeta3190DAO;
	
	// 가족사항
	@Autowired
	@Resource(name = "InfcPkgYeta3200DAO")
	private InfcPkgYeta3200DAO infcPkgYeta3200DAO;

	@Autowired
	@Resource(name = "InfcPkgYeta3210DAO")
	private InfcPkgYeta3210DAO infcPkgYeta3210DAO;

	@Autowired
	@Resource(name = "InfcPkgYeta3220DAO")
	private InfcPkgYeta3220DAO infcPkgYeta3220DAO;

	@Autowired
	@Resource(name = "InfcPkgYeta3300DAO")
	private InfcPkgYeta3300DAO infcPkgYeta3300DAO;

	@Autowired
	@Resource(name = "InfcPkgYeta3900DAO")
	private InfcPkgYeta3900DAO infcPkgYeta3900DAO;
   
    // 현근무지급여명세
    @Autowired
    @Resource(name="InfcPkgYe160401DAO")
    private InfcPkgYe160401DAO infcPkgYe160401DAO; 
    
    // 과세
    @Autowired
    @Resource(name="InfcPkgYe160402DAO")
    private InfcPkgYe160402DAO infcPkgYe160402DAO;  
    
    // 비과세
    @Autowired
    @Resource(name="InfcPkgYe160403DAO")
    private InfcPkgYe160403DAO infcPkgYe160403DAO; 
   
   
	   
    /**
	 * 연말정산마감 신규등록 
	 * @param vo - 등록할 정보가 담긴 Yeta3900VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String fnYeta1100_YETA1000_2016_CREATE_Insert(InfcPkgYeta1000VO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	String dataCheck = "";
    	
    	LOGGER.debug(vo.toString());
    	 
    	dataCheck = infcPkgYeta1000DAO.fnYeta1100_YETA1000_2016_CREATE_Insert(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return dataCheck;
    }   
    
    
    /** 연말정산 마감 조회 **/
    public InfcPkgYeta1000VO selectYeta1100ToCreateYetaPrc1000(InfcPkgYeta1000VO infcPkgYeta1000Vo) throws Exception {
    	InfcPkgYeta1000VO resultVO = infcPkgYeta1000DAO.selectYeta1100ToChkYetaPrc1000(infcPkgYeta1000Vo);
      //  if (resultVO == null)
       //     throw processException("info.nodata.msg");
        return resultVO;
    } 
    
    
    
    /**
 	 * 연말정산마감 급여내역생성 
 	 * @param vo - 등록할 정보가 담긴 Yeta3900VO
 	 * @return 등록 결과
 	 * @exception Exception
 	 */
//	public String fnYeta1100_YE160401_2016_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
//		// LOGGER.debug(vo.toString());
//		String dataCheck = "";
//		/** ID Generation Service */
//     	
//		dataCheck = infcPkgYe160401DAO.fnYeta1100_YE160401_2016_CREATE_Insert(infcPkgYe160401Vo);
//		// TODO 해당 테이블 정보에 맞게 수정
//		return dataCheck;
//	}  
     
     
     
     /**
  	 * 연말정산마감 급여내역생성 
  	 * @param vo - 등록할 정보가 담긴 Yeta3900VO
  	 * @return 등록 결과
  	 * @exception Exception
  	 */
	public String fnYeta1100_YETA2000_2016_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
      	//LOGGER.debug(vo.toString());
    	  String dataCheck = "";
      	/** ID Generation Service */
      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
      	//String id = egovIdGnrService.getNextStringId();
      	//vo.setId(id);
      //	LOGGER.debug(vo.toString());
      	
    	  dataCheck = infcPkgYeta2000DAO.fnYeta1100_YETA2000_2016_CREATE_Insert(infcPkgYeta2000Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	} 
	
	
	
    /**
  	 * 연말정산 과세 감면 생성 
  	 * @param vo - 등록할 정보가 담긴  
  	 * @return 등록 결과
  	 * @exception Exception
  	 */
	public String fnYeta1100_YE160402_2016_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
		// LOGGER.debug(vo.toString());
		String dataCheck = "";
		/** ID Generation Service */
		// TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
		// String id = egovIdGnrService.getNextStringId();
		// vo.setId(id);
		// LOGGER.debug(vo.toString());

		infcPkgYe160402DAO.fnYeta1100_YE160402_2016_CREATE_Insert(infcPkgYeta2000Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return null;
	}
	
	
    /**
  	 * 연말정산 비과세 감면 생성 
  	 * @param vo - 등록할 정보가 담긴  
  	 * @return 등록 결과
  	 * @exception Exception
  	 */
	public String fnYeta1100_YE160403_2016_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
		// LOGGER.debug(vo.toString());
		String dataCheck = "";
		/** ID Generation Service */
		// TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
		// String id = egovIdGnrService.getNextStringId();
		// vo.setId(id);
		// LOGGER.debug(vo.toString());

		infcPkgYe160403DAO.fnYeta1100_YE160403_2016_CREATE_Insert(infcPkgYeta2000Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return null;
	}
	
	
	/**
 	 * 연말정산 대상자 생성 가족생성 
 	 * @param vo - 등록할 정보가 담긴  
 	 * @return 등록 결과
 	 * @exception Exception
 	 */
     public String fnYeta1100_YETA3220_2016_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
     	//LOGGER.debug(vo.toString());
   	  	String dataCheck = "";
     	/** ID Generation Service */
     	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
     	//String id = egovIdGnrService.getNextStringId();
     	//vo.setId(id);
   	  	//	LOGGER.debug(vo.toString());
     	
   	  	dataCheck = infcPkgYeta3220DAO.fnYeta1100_YETA3220_2016_CREATE_Insert(infcPkgYeta2000Vo);
     	//TODO 해당 테이블 정보에 맞게 수정    	
   	  	return dataCheck;
     } 
     
     
	/**
 	 * YETA3900을 수정한다.
 	 * @param vo - 수정할 정보가 담긴 Yeta3900VO
 	 * @return void형
 	 * @exception Exception
 	 */
     public void fnYeta1100_YETA3220_2016_INSU_FETC_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
    	 infcPkgYeta3220DAO.fnYeta1100_YETA3220_2016_INSU_FETC_CREATE_Update(infcPkgYeta2000Vo);
     }   
     
     
     /**
      * 부녀자공제란 여성근로소득자 본인인경우 업데이트 처리
      * @param vo - 수정할 정보가 담긴 Yeta3900VO
      * @return void형
      * @exception Exception
      */
     public void fnYeta1100_YETA3220_2016_CREATE_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
    	 infcPkgYeta3220DAO.fnYeta1100_YETA3220_2016_CREATE_Update(infcPkgYeta2000Vo);
     }  
     
     /** 이월기부금 **/
     public String fnYeta1100_YETA3190_2016_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
    	 //LOGGER.debug(vo.toString());
    	 String dataCheck = "";
    	 /** ID Generation Service */
    	 //TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	 //String id = egovIdGnrService.getNextStringId();
    	 //vo.setId(id);
    	 //	LOGGER.debug(vo.toString());
    	 dataCheck = infcPkgYeta3190DAO.fnYeta1100_YETA3190_2016_CREATE_Insert(infcPkgYeta2000Vo);
    	 //TODO 해당 테이블 정보에 맞게 수정    	
    	 return dataCheck;
     }       
     
     
	/** 연말정산 상세 **/
	public String fnYeta1100_YETA3000_2016_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
       	//LOGGER.debug(vo.toString());
       	String StrRtn = "";
       	/** ID Generation Service */
       	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
       	//String id = egovIdGnrService.getNextStringId();
       	//vo.setId(id);
       //	LOGGER.debug(vo.toString());
       	
       	StrRtn = infcPkgYeta3000DAO.fnYeta1100_YETA3000_2016_CREATE_Insert(infcPkgYeta2000Vo);
       	//TODO 해당 테이블 정보에 맞게 수정    	
           return StrRtn;
	}  
	
	
	
    /**
 	 * 연말정산마감 급여내역 이관
 	 * @param vo - 등록할 정보가 담긴 Yeta3900VO
 	 * @return 등록 결과
 	 * @exception Exception
 	 */
	public String fnYeta1100_YE160401_PAYR_2016_CREATE_Insert(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
		// LOGGER.debug(vo.toString());
		String dataCheck = "";
		/** ID Generation Service */
     	
		dataCheck = infcPkgYe160401DAO.fnYeta1100_YE160401_PAYR_2016_CREATE_Insert(infcPkgYe160401Vo);
		// TODO 해당 테이블 정보에 맞게 수정
		return dataCheck;
	}  
	
	
	
    // YETA2000 업데이트
    // {******************************급여자료 이관 - 연말정산 업데이트   [3]*******************************************}
    public void fnYeta1100_YETA2000_PAYR_2016_CREATE_Update(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
    	infcPkgYeta2000DAO.fnYeta1100_YETA2000_PAYR_2016_CREATE_Update(infcPkgYe160401Vo);
	}   	
     
     
	//{과세 감면 인서트 }
    //{**************************연말정산기본 과세 감면 업데이트   [4 - 1]********************************} 
    public void fnYeta1100_YE160402_PAYR_2016_CREATE_Insert(InfcPkgYe160402VO infcPkgYe160402Vo) throws Exception {
    	infcPkgYe160402DAO.fnYeta1100_YE160402_PAYR_2016_CREATE_Insert(infcPkgYe160402Vo);
	}
    
	//{비과세 감면 인서트 }
    //{**************************연말정산기본 비과세 감면 업데이트   [4 - 1]********************************} 
    public void fnYeta1100_YE160403_PAYR_2016_CREATE_Insert(InfcPkgYe160403VO infcPkgYe160403Vo) throws Exception {
    	infcPkgYe160403DAO.fnYeta1100_YE160403_PAYR_2016_CREATE_Insert(infcPkgYe160403Vo);
	}  
    
    // {******************************급여자료 이관 - 연말정산 425 업데이트   [5]*******************************************}
    //425 업데이트
	public void fnYeta1100_YETA3000_PAYR_2016_CREATE_Update(InfcPkgYe160401VO infcPkgYe160401Vo) throws Exception {
		infcPkgYeta3000DAO.fnYeta1100_YETA3000_PAYR_2016_CREATE_Update(infcPkgYe160401Vo);
	}      
    
   
   
    
//    /** ID Generation */
//    //@Resource(name="{egovYeta3900IdGnrService}")    
//    //private EgovIdGnrService egovIdGnrService;
//
//    /**
//	 * 연말정산마감 신규등록 
//	 * @param vo - 등록할 정보가 담긴 Yeta3900VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String fnPayr06420_PAYR420_2014_CREATE_Insert(InfcPkgYeta1000VO vo) throws Exception {
//    	LOGGER.debug(vo.toString());
//    	String dataCheck = "";
//    	/** ID Generation Service */
//    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//    	//String id = egovIdGnrService.getNextStringId();
//    	//vo.setId(id);
//    	LOGGER.debug(vo.toString());
//    	 
//    	
//    	dataCheck = infcPkgYeta1000DAO.fnPayr06420_PAYR420_2014_CREATE_Insert(vo);
//    	//TODO 해당 테이블 정보에 맞게 수정    	
//        return dataCheck;
//    }
//    
//    /**
// 	 * 연말정산마감 급여내역생성 
// 	 * @param vo - 등록할 정보가 담긴 Yeta3900VO
// 	 * @return 등록 결과
// 	 * @exception Exception
// 	 */
//     public String fnPayr06420_PAYR417_2014_CREATE_Insert(InfcPkgYeta3210VO infcPkgYeta3210Vo) throws Exception {
//     	//LOGGER.debug(vo.toString());
//    	 String dataCheck = "";
//     	/** ID Generation Service */
//     	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//     	//String id = egovIdGnrService.getNextStringId();
//     	//vo.setId(id);
//     //	LOGGER.debug(vo.toString());
//     	
//    	 dataCheck = infcPkgYeta3210DAO.fnPayr06420_PAYR417_2014_CREATE_Insert(infcPkgYeta3210Vo);
//     	//TODO 해당 테이블 정보에 맞게 수정    	
//         return dataCheck;
//     }
//     
//     
//     /**
//  	 * 연말정산마감 급여내역생성 
//  	 * @param vo - 등록할 정보가 담긴 Yeta3900VO
//  	 * @return 등록 결과
//  	 * @exception Exception
//  	 */
//      public String fnPayr06420_PAYR415_2014_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
//      	//LOGGER.debug(vo.toString());
//    	  String dataCheck = "";
//      	/** ID Generation Service */
//      	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//      	//String id = egovIdGnrService.getNextStringId();
//      	//vo.setId(id);
//      //	LOGGER.debug(vo.toString());
//      	
//    	  dataCheck = infcPkgYeta2000DAO.fnPayr06420_PAYR415_2014_CREATE_Insert(infcPkgYeta2000Vo);
//      	//TODO 해당 테이블 정보에 맞게 수정    	
//          return dataCheck;
//      }
//   
//      /**
//    	 * 연말정산 비과세 감면 생성 
//    	 * @param vo - 등록할 정보가 담긴  
//    	 * @return 등록 결과
//    	 * @exception Exception
//    	 */
//        public String fnPayr06420_YETA3200_2015_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
//        	//LOGGER.debug(vo.toString());
//        	 String dataCheck = "";
//        	/** ID Generation Service */
//        	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//        	//String id = egovIdGnrService.getNextStringId();
//        	//vo.setId(id);
//        //	LOGGER.debug(vo.toString());
//        	
//        	infcPkgYeta3200DAO.fnPayr06420_YETA3200_2015_CREATE_Insert(infcPkgYeta2000Vo);
//        	//TODO 해당 테이블 정보에 맞게 수정    	
//            return null;
//        }
//      
//        /**
//      	 * 연말정산 대상자 생성 가족생성 
//      	 * @param vo - 등록할 정보가 담긴  
//      	 * @return 등록 결과
//      	 * @exception Exception
//      	 */
//          public String fnPayr06430_PAYR410_2014_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
//          	//LOGGER.debug(vo.toString());
//        	  String dataCheck = "";
//          	/** ID Generation Service */
//          	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//          	//String id = egovIdGnrService.getNextStringId();
//          	//vo.setId(id);
//          //	LOGGER.debug(vo.toString());
//          	
//        	  dataCheck = infcPkgYeta3220DAO.fnPayr06430_PAYR410_2014_CREATE_Insert(infcPkgYeta2000Vo);
//          	//TODO 해당 테이블 정보에 맞게 수정    	
//              return dataCheck;
//          }  
//        
//          public String fnPayr06430_PAYR443_2014_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
//            	//LOGGER.debug(vo.toString());
//        	  String dataCheck = "";
//            	/** ID Generation Service */
//            	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//            	//String id = egovIdGnrService.getNextStringId();
//            	//vo.setId(id);
//            //	LOGGER.debug(vo.toString());
//            	
//        	  dataCheck = infcPkgYeta3190DAO.fnPayr06430_PAYR443_2014_CREATE_Insert(infcPkgYeta2000Vo);
//            	//TODO 해당 테이블 정보에 맞게 수정    	
//                return dataCheck;
//            }     
//      
//          public String fnPayr06430_PAYR425_2014_CREATE_Insert(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
//          	//LOGGER.debug(vo.toString());
//          	String StrRtn = "";
//          	/** ID Generation Service */
//          	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//          	//String id = egovIdGnrService.getNextStringId();
//          	//vo.setId(id);
//          //	LOGGER.debug(vo.toString());
//          	
//          	StrRtn = infcPkgYeta3000DAO.fnPayr06430_PAYR425_2014_CREATE_Insert(infcPkgYeta2000Vo);
//          	//TODO 해당 테이블 정보에 맞게 수정    	
//              return StrRtn;
//          }     
//    
//          
//          
//     /**
// 	 * YETA3900을 조회한다.
// 	 * @param vo - 조회할 정보가 담긴 Yeta3900VO
// 	 * @return 조회한 YETA3900
// 	 * @exception Exception
// 	 */
//     public InfcPkgYeta1000VO selectYeta0100ToCreateYetaPrc1000(InfcPkgYeta1000VO vo) throws Exception {
//    	 InfcPkgYeta1000VO resultVO = infcPkgYeta1000DAO.selectYeta0100ToCreateYetaPrc1000(vo);
//       //  if (resultVO == null)
//        //     throw processException("info.nodata.msg");
//         return resultVO;
//     }
//     
//     public InfcPkgYeta1000VO selectYeta0100ToChkYetaPrc1000(InfcPkgYeta1000VO vo) throws Exception {
//    	 InfcPkgYeta1000VO resultVO = infcPkgYeta1000DAO.selectYeta0100ToChkYetaPrc1000(vo);
//       //  if (resultVO == null)
//        //     throw processException("info.nodata.msg");
//         return resultVO;
//     }
//     
//     
//     
//	/**
//	 * YETA3900을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Yeta3900VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertYeta3900(InfcPkgYeta3900VO vo) throws Exception {
//    	LOGGER.debug(vo.toString());
//    	 String dataCheck = "";
//    	/** ID Generation Service */
//    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//    	//String id = egovIdGnrService.getNextStringId();
//    	//vo.setId(id);
//    	LOGGER.debug(vo.toString());
//    	
//    	dataCheck = infcPkgYeta3900DAO.insertYeta3900(vo);
//    	//TODO 해당 테이블 정보에 맞게 수정    	
//        return dataCheck;
//    }
//
//    /**
//	 * YETA3900을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Yeta3900VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    public void updateYeta3900(InfcPkgYeta3900VO vo) throws Exception {
//        infcPkgYeta3900DAO.updateYeta3900(vo);
//    }
//
//    /**
//	 * YETA3900을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Yeta3900VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    public void fnPayr06430_PAYR410_2014_INSU_FETC_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
//    	infcPkgYeta3220DAO.fnPayr06430_PAYR410_2014_INSU_FETC_Update(infcPkgYeta2000Vo);
//    }   
//    
//    /**
//   	 * 부녀자공제란 여성근로소득자 본인인경우 업데이트 처리
//   	 * @param vo - 수정할 정보가 담긴 Yeta3900VO
//   	 * @return void형
//   	 * @exception Exception
//   	 */
//       public void fnPayr06430_PAYR410_2014_CREATE_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
//       	infcPkgYeta3220DAO.fnPayr06430_PAYR410_2014_CREATE_Update(infcPkgYeta2000Vo);
//       }   
//        
//       // 415 업데이트
//       // {******************************급여자료 이관 - 연말정산 업데이트   [3]*******************************************}
//       public void fnPayr06520_PAYR415_2015_CREATE1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
//          	infcPkgYeta2000DAO.fnPayr06520_PAYR415_2015_CREATE1_Update(infcPkgYeta2000Vo);
//          }   
//        
//     	  //{비과세 감면 인서트 }
//         //{**************************연말정산기본 비과세 감면 업데이트   [4]********************************} 
//    	  	     
//       public void fnPayr06420_YETA3200_2015_CREATE1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
//    	   infcPkgYeta3200DAO.fnPayr06420_YETA3200_2015_CREATE1_Update(infcPkgYeta2000Vo);
//          }   
//     	  
//        
//      // {******************************급여자료 이관 - 연말정산 425 업데이트   [4]*******************************************}
//        //425 업데이트
//     	   public void fnPayr06530_PAYR425_2015_CREATE1_Update(InfcPkgYeta2000VO infcPkgYeta2000Vo) throws Exception {
//     	       	infcPkgYeta3000DAO.fnPayr06530_PAYR425_2015_CREATE1_Update(infcPkgYeta2000Vo);
//     	       }   
//    	  
//    
//    
//    /**
//	 * YETA3900을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Yeta3900VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    public void deleteYeta3900(InfcPkgYeta3900VO vo) throws Exception {
//        infcPkgYeta3900DAO.deleteYeta3900(vo);
//    }
//
//    /**
//	 * YETA3900을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Yeta3900VO
//	 * @return 조회한 YETA3900
//	 * @exception Exception
//	 */
//    public InfcPkgYeta3900VO selectYeta3900(InfcPkgYeta3900VO vo) throws Exception {
//        InfcPkgYeta3900VO resultVO = infcPkgYeta3900DAO.selectYeta3900(vo);
//      //  if (resultVO == null)
//       //     throw processException("info.nodata.msg");
//        return resultVO;
//    }
//
//    /**
//	 * YETA3900 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return YETA3900 목록
//	 * @exception Exception
//	 */
//    public List<?> selectYeta3900List(InfcPkgYeta3900SrhVO searchVO) throws Exception {
//        return infcPkgYeta3900DAO.selectYeta3900List(searchVO);
//    }
//
//    /**
//	 * YETA3900 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return YETA3900 총 갯수
//	 * @exception
//	 */
//    public int selectYeta3900ListTotCnt(InfcPkgYeta3900SrhVO searchVO) {
//		return infcPkgYeta3900DAO.selectYeta3900ListTotCnt(searchVO);
//	}
    
}
