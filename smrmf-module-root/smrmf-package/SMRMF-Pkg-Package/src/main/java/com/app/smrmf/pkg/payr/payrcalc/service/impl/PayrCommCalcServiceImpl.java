package com.app.smrmf.pkg.payr.payrcalc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0200DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0300DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0301DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0302DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0304DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0305DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0306DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0307DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0309DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0410DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0450DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0460DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0500DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0520DAO;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0540DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0200SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0300VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0301VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0302VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0304SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0304VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0305VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0306SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0306VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0307VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0309VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0410VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0450VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0460SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0460VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0500VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0520SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0540SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0540VO;
import com.app.smrmf.pkg.payr.payrcalc.service.PayrCommCalcService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Payr0305ServiceImpl.java
 * @Description : Payr0305 Business Implement class
 *                 급여계산 결과 저장 
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("PayrCommCalcService")
public class PayrCommCalcServiceImpl extends AbstractServiceImpl implements  PayrCommCalcService {
 
 

	@Autowired
    @Resource(name="InfcPkgPayr0300DAO")
    private InfcPkgPayr0300DAO payr0300DAO;
	
	
   //우측급여상세정보 단건 가져오기 
	@Autowired
    @Resource(name="InfcPkgPayr0301DAO")
    private InfcPkgPayr0301DAO payr0301DAO;
    
	
    //급여대상자 가져오기 
	@Autowired
    @Resource(name="InfcPkgPayr0304DAO")
    private InfcPkgPayr0304DAO payr0304DAO;
     
	@Autowired
    @Resource(name="InfcPkgPayr0410DAO")
    private InfcPkgPayr0410DAO payr0410DAO;
    
	
	
   //가족사항 정보 
	@Autowired
    @Resource(name="InfcPkgPayr0306DAO")
    private InfcPkgPayr0306DAO payr0306DAO; 
	
	  //급여조정내역 
    @Autowired
    @Resource(name="InfcPkgPayr0307DAO")
    private InfcPkgPayr0307DAO payr0307DAO; 
    
    //4대보험이력 
    @Autowired
    @Resource(name="InfcPkgPayr0309DAO")
    private InfcPkgPayr0309DAO payr0309DAO; 
	
    /** ID Generation */
    //@Resource(name="{egovPayr0304IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
	 
	//공제항목에 대한값을 가지고 온다. 
	@Autowired
	@Resource(name="InfcPkgPayr0200DAO")
    private InfcPkgPayr0200DAO payr0200DAO; 
	
    //지급공제항목에 대한값을 가지고 온다. 
    @Autowired
    @Resource(name="InfcPkgPayr0520DAO")
    private InfcPkgPayr0520DAO payr0520DAO;
    
    @Autowired
    @Resource(name="InfcPkgPayr0460DAO")
    private InfcPkgPayr0460DAO payr0460DAO; 
     
    
    @Autowired
    @Resource(name="InfcPkgPayr0450DAO")
    private InfcPkgPayr0450DAO payr0450DAO; 
    
    @Autowired
    @Resource(name="InfcPkgPayr0500DAO")
    private InfcPkgPayr0500DAO payr0500DAO;
    
    
   //급여 수당공제이력정보 
	@Autowired
    @Resource(name="InfcPkgPayr0302DAO")
    private InfcPkgPayr0302DAO payr0302DAO;
	 
	
	@Autowired
    @Resource(name="InfcPkgPayr0540DAO")
    private InfcPkgPayr0540DAO infcPkgPayr0540DAO;
	
	   //급여 수당공제이력정보 
		@Autowired
	    @Resource(name="InfcPkgPayr0305DAO")
	    private InfcPkgPayr0305DAO payr0305DAO;
		 
	  
    /** ID Generation */
    //@Resource(name="{egovPayCalculationIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

    
    /**
     * 
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : insertPayr0302
     * @date : 2016. 12. 13.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 12. 13.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @return
     * @throws Exception
     */
    public String insertPayr0302(InfcPkgPayr0302VO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	String rtnInsert = payr0302DAO.insertPayr0302(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return rtnInsert;
    }
    
    /**
     * 
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : deletePayr0302ToPayr0307T
     * @date : 2016. 12. 13.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 12. 13.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param vo
     * @throws Exception
     */
    public void deletePayr0302ToPayr0307T(InfcPkgPayr0302VO vo) throws Exception {
        payr0302DAO.deletePayr0302ToPayr0307T(vo);
    }
    
    /**
     * 
     * <pre>
     * 1. 개요 :  예외처리 데이타 가져오기  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getSelectPkgPayr0540List
     * @date : 2016. 12. 24.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2016. 12. 24.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see com.app.smrmf.pkg.payr.payrcalc.service.PayrCommCalcService#getSelectPkgPayr0540List
     *  (com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0540SrhVO)
     * @param payr0540SrhVo
     * @return
     * @throws Exception
     */
    public List selectPkgPayr0540List(InfcPkgPayr0540SrhVO payr0540SrhVo ) throws Exception {
    	
    	return infcPkgPayr0540DAO.selectPayr0540List(payr0540SrhVo);
   
    } 
    
    
    /**
   * PAYR0540을 조회한다.
   * @param vo - 조회할 정보가 담긴 Payr0540VO
   * @return 조회한 PAYR0540
   * @exception Exception
   */
    public InfcPkgPayr0540VO selectPayr0540(InfcPkgPayr0540VO vo) throws Exception {
        InfcPkgPayr0540VO resultVO = infcPkgPayr0540DAO.selectPayr0540(vo);
       // if (resultVO == null)
       //     throw processException("info.nodata.msg");
        return resultVO;
    }

     

    /**
   * PAYR0540 총 갯수를 조회한다.
   * @param searchVO - 조회할 정보가 담긴 VO
   * @return PAYR0540 총 갯수
   * @exception
   */
    public int selectPayr0540ListTotCnt(InfcPkgPayr0540SrhVO searchVO) {
      return infcPkgPayr0540DAO.selectPayr0540ListTotCnt(searchVO);
  }

    
    public void deletePayr0302Payr0307(InfcPkgPayr0302VO vo) throws Exception {
    	 payr0302DAO.deletePayr0302Payr0307(vo);
    }	 
    
    
 
	/**
	 * PAYR0300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
   public String insertPayr0300(InfcPkgPayr0300VO vo) throws Exception {
   	log.debug(vo.toString());
   	
   	/** ID Generation Service */
   	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
   	//String id = egovIdGnrService.getNextStringId();
   	//vo.setId(id);
   	log.debug(vo.toString()); 
   	//TODO 해당 테이블 정보에 맞게 수정    
   	String rtnInsert = payr0300DAO.insertPayr0300(vo);
   	
    return rtnInsert;
   }
   
   
   
	 public List<InfcPkgPayr0307VO> selectPayr0307All(InfcPkgPayr0307VO vo)  throws Exception {
       
       return payr0307DAO.selectPayr0307All(vo);
       
   } 
	 
	 
	 
	  /**
		 * selectPayr0309을 조회한다.
		 * @param vo - 조회할 정보가 담긴 selectPayr0309
		 * @return 조회한 selectPayr0309
		 * @exception Exception
		 */
	    public InfcPkgPayr0309VO selectPayr0309(InfcPkgPayr0309VO vo) throws Exception {
	    	InfcPkgPayr0309VO resultVO = payr0309DAO.selectPayr0309(vo);
	       // if (resultVO == null)
	       //     throw processException("info.nodata.msg");
	        return resultVO;
	    }
	    
	 
	     /**
		     * Payr0309VO을 등록한다.
		     * @param vo - 등록할 정보가 담긴 Payr0309VO
		     * @return 등록 결과
		     * @exception Exception
		     */
		    public String insertPayr0309(InfcPkgPayr0309VO vo) throws Exception {
		    	log.debug(vo.toString());
		    	
		    	/** ID Generation Service */
		    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
		    	//String id = egovIdGnrService.getNextStringId();
		    	//vo.setId(id);
		    	log.debug(vo.toString());
		    	
		    	payr0309DAO.insertPayr0309(vo);
		    	//TODO 해당 테이블 정보에 맞게 수정    	
		        return null;
		    }
		
		    /**
		     * Payr0309VO을 수정한다.
		     * @param vo - 수정할 정보가 담긴 Payr0309VO
		     * @return void형
		     * @exception Exception
		     */
		    public void updatePayr0309(InfcPkgPayr0309VO vo) throws Exception {
		        payr0309DAO.updatePayr0309(vo);
		    }
		  
	     
	  public void deletePayCalculationPayr0307(InfcPkgPayr0307VO vo) throws Exception {
	      payr0307DAO.deletePayCalculationPayr0307(vo);
    }
	  
  /**
	 * PAYR0300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0300VO
	 * @return void형
	 * @exception Exception
	 */
  public void updatePayr0300(InfcPkgPayr0300VO vo) throws Exception {
      payr0300DAO.updatePayr0300(vo);
  }
  

  /**
	 * PAYR0300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0300VO
	 * @return void형 
	 * @exception Exception
	 */
  public void deletePayr0300(InfcPkgPayr0300VO vo) throws Exception {
      payr0300DAO.deletePayr0300(vo);
  }
   
  
   
  /**
	 * PAYR0200 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PAYR0200 목록
	 * @exception Exception
	 */
  public List selectPayr0200ToPayrCalcList(InfcPkgPayr0200SrhVO searchVO) throws Exception {
      return payr0200DAO.selectPayr0200ToPayrCalcList(searchVO);
  }
  
  public List selectPayr0520ToPayrCalcList(InfcPkgPayr0520SrhVO searchVO) throws Exception {
      return payr0520DAO.selectPayr0520ToPayrCalcList(searchVO);
  }
  
   
	/**
	 * PAYR0304을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0304VO
	 * @return 등록 결과
	 * @exception Exception
	 */
  public String insertPayr0304(InfcPkgPayr0304VO vo) throws Exception {
  	log.debug(vo.toString());
  	
  	/** ID Generation Service */
  	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
  	//String id = egovIdGnrService.getNextStringId();
  	//vo.setId(id);
  	log.debug(vo.toString());
  	
  	payr0304DAO.insertPayr0304(vo);
  	//TODO 해당 테이블 정보에 맞게 수정    	
      return null;
  }

  /**
	 * PAYR0304을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0304VO
	 * @return void형
	 * @exception Exception
	 */
  public void updatePayr0304(InfcPkgPayr0304VO vo) throws Exception {
      payr0304DAO.updatePayr0304(vo);
  }

  /**
	 * PAYR0304을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0304VO
	 * @return void형 
	 * @exception Exception
	 */
  public void deletePayr0304(InfcPkgPayr0304VO vo) throws Exception {
      payr0304DAO.deletePayr0304(vo);
  }
  
  /**
 * PAYR0304을 조회한다.
 * @param vo - 조회할 정보가 담긴 Payr0304VO
 * @return 조회한 PAYR0304
 * @exception Exception
 */
  public InfcPkgPayr0304VO selectPayr0304(InfcPkgPayr0304VO vo) throws Exception {
      InfcPkgPayr0304VO resultVO = payr0304DAO.selectPayr0304(vo);
     // if (resultVO == null)
     //     throw processException("info.nodata.msg");
      return resultVO;
  }

  /**
 * PAYR0304 목록을 조회한다.
 * @param searchVO - 조회할 정보가 담긴 VO
 * @return PAYR0304 목록
 * @exception Exception
 */
  public List selectPayr0304List(InfcPkgPayr0304SrhVO searchVO) throws Exception {
      return payr0304DAO.selectPayr0304List(searchVO);
  }

  /**
 * PAYR0304 총 갯수를 조회한다.
 * @param searchVO - 조회할 정보가 담긴 VO
 * @return PAYR0304 총 갯수
 * @exception
 */
  public int selectPayr0304ListTotCnt(InfcPkgPayr0304SrhVO searchVO) {
    return payr0304DAO.selectPayr0304ListTotCnt(searchVO);
}

	/**
	 * PAYR0301을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0301VO
	 * @return 등록 결과
	 * @exception Exception
	 */
  public String insertPayr0301(InfcPkgPayr0301VO vo) throws Exception {
  	log.debug(vo.toString());
  	
  	/** ID Generation Service */
  	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
  	//String id = egovIdGnrService.getNextStringId();
  	//vo.setId(id);
  	log.debug(vo.toString());
  	
  	payr0301DAO.insertPayr0301(vo);
  	//TODO 해당 테이블 정보에 맞게 수정    	
      return null;
  }

  /**
	 * PAYR0301을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0301VO
	 * @return void형
	 * @exception Exception
	 */
  public void updatePayr0301(InfcPkgPayr0301VO vo) throws Exception {
      payr0301DAO.updatePayr0301(vo);
  }
  
  public void updatePayr0301ToPayr0307(InfcPkgPayr0301VO vo) throws Exception {
      payr0301DAO.updatePayr0301ToPayr0307(vo);
  }
  
  
  /**
	 * PAYR0301을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0301VO
	 * @return void형 
	 * @exception Exception
	 */
  public void deletePayr0301(InfcPkgPayr0301VO vo) throws Exception {
      payr0301DAO.deletePayr0301(vo);
  }

 

  /**
	 * PAYR0302을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0302VO
	 * @return void형
	 * @exception Exception
	 */
  public void updatePayr0302(InfcPkgPayr0302VO vo) throws Exception {
      payr0302DAO.updatePayr0302(vo);
  }

  /**
	 * PAYR0302을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0302VO
	 * @return void형 
	 * @exception Exception
	 */
  public void deletePayr0302(InfcPkgPayr0302VO vo) throws Exception {
      payr0302DAO.deletePayr0302(vo);
  }
   

	/**
	 * PAYR0306을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0306VO
	 * @return 등록 결과
	 * @exception Exception
	 */
  public String insertPayr0306(InfcPkgPayr0306VO vo) throws Exception {
  	log.debug(vo.toString());
  	
  	/** ID Generation Service */
  	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
  	//String id = egovIdGnrService.getNextStringId();
  	//vo.setId(id);
  	log.debug(vo.toString());
  	
  	payr0306DAO.insertPayr0306(vo);
  	//TODO 해당 테이블 정보에 맞게 수정    	
      return null;
  }

  /**
	 * PAYR0306을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0306VO
	 * @return void형
	 * @exception Exception
	 */
  public void updatePayr0306(InfcPkgPayr0306VO vo) throws Exception {
      payr0306DAO.updatePayr0306(vo);
  }

  /**
	 * PAYR0306을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0306VO
	 * @return void형 
	 * @exception Exception
	 */
  public void deletePayr0306(InfcPkgPayr0306VO vo) throws Exception {
      payr0306DAO.deletePayr0306(vo);
  }
  
  /**
   * PAYR0460을 등록한다.
   * @param vo - 등록할 정보가 담긴 Payr0460VO
   * @return 등록 결과
   * @exception Exception
   */
  public String insertPayr0460(InfcPkgPayr0460VO vo) throws Exception {
    log.debug(vo.toString());
    
    /** ID Generation Service */
    //TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    //String id = egovIdGnrService.getNextStringId();
    //vo.setId(id);
    log.debug(vo.toString());
    
    payr0460DAO.insertPayr0460(vo);
    //TODO 해당 테이블 정보에 맞게 수정     
      return null;
  }

  /**
 * PAYR0460을 수정한다.
 * @param vo - 수정할 정보가 담긴 Payr0460VO
 * @return void형
 * @exception Exception
 */
  public void updatePayr0460(InfcPkgPayr0460VO vo) throws Exception {
      payr0460DAO.updatePayr0460(vo);
  }

  /**
 * PAYR0460을 삭제한다.
 * @param vo - 삭제할 정보가 담긴 Payr0460VO
 * @return void형 
 * @exception Exception
 */
  public void deletePayr0460(InfcPkgPayr0460VO vo) throws Exception {
      payr0460DAO.deletePayr0460(vo);
  }

  /**
 * PAYR0460을 조회한다.
 * @param vo - 조회할 정보가 담긴 Payr0460VO
 * @return 조회한 PAYR0460
 * @exception Exception
 */
  public InfcPkgPayr0460VO selectPayr0460(InfcPkgPayr0460VO vo) throws Exception {
      InfcPkgPayr0460VO resultVO = payr0460DAO.selectPayr0460(vo);
      if (resultVO == null)
          throw processException("info.nodata.msg");
      return resultVO;
  }

  /**
 * PAYR0460 목록을 조회한다.
 * @param searchVO - 조회할 정보가 담긴 VO
 * @return PAYR0460 목록
 * @exception Exception
 */
  public List selectPayr0460List(InfcPkgPayr0460SrhVO searchVO) throws Exception {
      return payr0460DAO.selectPayr0460List(searchVO);
  }

  /**
 * PAYR0460 총 갯수를 조회한다.
 * @param searchVO - 조회할 정보가 담긴 VO
 * @return PAYR0460 총 갯수
 * @exception
 */
  public int selectPayr0460ListTotCnt(InfcPkgPayr0460SrhVO searchVO) {
    return payr0460DAO.selectPayr0460ListTotCnt(searchVO);
}
  
 
  

/**
* PAYR0306을 조회한다.
* @param vo - 조회할 정보가 담긴 Payr0306VO
* @return 조회한 PAYR0306
* @exception Exception
*/
      
      public InfcPkgPayr0306VO selectPayr0306(InfcPkgPayr0306VO vo) throws Exception {
          InfcPkgPayr0306VO resultVO = payr0306DAO.selectPayr0306(vo);
         // if (resultVO == null)
         //     throw processException("info.nodata.msg");
          return resultVO;
      }
      


/**
* PAYR0306 목록을 조회한다.
* @param searchVO - 조회할 정보가 담긴 VO
* @return PAYR0306 목록
* @exception Exception
*/
      
      public List selectPayr0306List(InfcPkgPayr0306SrhVO searchVO)throws Exception {
          return payr0306DAO.selectPayr0306List(searchVO);
      }


/**
* PAYR0306 총 갯수를 조회한다.
* @param searchVO - 조회할 정보가 담긴 VO
* @return PAYR0306 총 갯수
* @exception
*/

public   int selectPayr0306ListTotCnt(InfcPkgPayr0306SrhVO searchVO) {
return payr0306DAO.selectPayr0306ListTotCnt(searchVO);
}


/**
* 이전달 추가 소득세 세율코드 데이터를 조회한다. PAYR0304을 조회한다.
* @param vo - 조회할 정보가 담긴 Payr0304VO
* @return 조회한 PAYR0304
* @exception Exception
*/ 
public InfcPkgPayr0304VO selectPayr0304ToAddIncmTx(InfcPkgPayr0304VO vo) throws Exception {
  InfcPkgPayr0304VO resultVO = payr0304DAO.selectPayr0304ToAddIncmTx(vo);
 // if (resultVO == null)
 //     throw processException("info.nodata.msg");
  return resultVO;
}


/**
* Payr0500VO을 수정한다.
* @param vo - 수정할 정보가 담긴 Payr0309VO
* @return void형
* @exception Exception
*/

  public void updatePayr0500TotAddIncmTx(InfcPkgPayr0500VO vo) throws Exception {
      payr0500DAO.updatePayr0500TotAddIncmTx(vo);
  }
   
  public void updatePayr0302ToPayr0305(InfcPkgPayr0305VO  inPayr0305Vo) throws Exception {
	  payr0305DAO.updatePayr0302ToPayr0305(inPayr0305Vo);
  } 
  
  public InfcPkgPayr0450VO selectPayr0450(InfcPkgPayr0450VO vo) throws Exception {
  	InfcPkgPayr0450VO resultVO = payr0450DAO.selectPayr0450(vo);
     // if (resultVO == null)
     //     throw processException("info.nodata.msg");
      return resultVO;
  } 
  
  /**
   * 
   * <pre>
   * 1. 개요 : 정근수당  
   * 2. 처리내용 : 
   * </pre>
   * @Method Name : selectPayr0450ToC9030100
   * @date : 2017. 5. 18.
   * @author : atres
   * @history : 
   *	-----------------------------------------------------------------------
   *	변경일				작성자						변경내용  
   *	----------- ------------------- ---------------------------------------
   *	2017. 5. 18.		atres				최초 작성 
   *	-----------------------------------------------------------------------
   * 
   * @see com.app.smrmf.pkg.payr.payrcalc.service.PayrCommCalcService#selectPayr0450ToC9030100(com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0450VO)
   * @param vo
   * @return
   * @throws Exception
   */
  public InfcPkgPayr0450VO selectPayr0450ToC9030100(InfcPkgPayr0450VO vo) throws Exception {
	  	InfcPkgPayr0450VO resultVO = payr0450DAO.selectPayr0450ToC9030100(vo);
	     // if (resultVO == null)
	     //     throw processException("info.nodata.msg");
	      return resultVO;
	  }  
  
 /**
  * 
  * <pre>
  * 1. 개요 : 근속가산금  
  * 2. 처리내용 : 
  * </pre>
  * @Method Name : selectPayr0450ToC9010100
  * @date : 2017. 5. 18.
  * @author : atres
  * @history : 
  *	-----------------------------------------------------------------------
  *	변경일				작성자						변경내용  
  *	----------- ------------------- ---------------------------------------
  *	2017. 5. 18.		atres				최초 작성 
  *	-----------------------------------------------------------------------
  * 
  * @param vo
  * @return
  * @throws Exception
  */
  public InfcPkgPayr0450VO selectPayr0450ToC9010100(InfcPkgPayr0450VO vo) throws Exception {
	  	InfcPkgPayr0450VO resultVO = payr0450DAO.selectPayr0450ToC9010100(vo);
	     // if (resultVO == null)
	     //     throw processException("info.nodata.msg");
	      return resultVO;
	  }  
  
  public InfcPkgPayr0450VO selectPayr0450ToC9010400(InfcPkgPayr0450VO vo) throws Exception {
	  	InfcPkgPayr0450VO resultVO = payr0450DAO.selectPayr0450ToC9010400(vo);
	     // if (resultVO == null)
	     //     throw processException("info.nodata.msg");
	      return resultVO;
	  }  
  
  

public InfcPkgPayr0410VO selectPayr0410ToPayrCalcList(InfcPkgPayr0410VO vo) throws Exception {
	InfcPkgPayr0410VO resultVO = payr0410DAO.selectPayr0410ToPayrCalcList(vo);
	 // if (resultVO == null)
	 //     throw processException("info.nodata.msg");
	  return resultVO;
 }    

}
