package com.app.smrmf.pkg.proc.remt.retirement.payr.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0410VO;
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt2000DAO;
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt2100DAO;
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt2200DAO;
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt2300DAO;
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt3000DAO;
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt3100DAO;
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt3200DAO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2000SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2000VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2100SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2100VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2200SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2200VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2300SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2300VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3000SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3000VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3100SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3100VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3200SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3200VO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.Remt0100DlgnVO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RemtLogSvcDysVO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RemtPayr0302SrhVO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RemtPsnl0100SrhVO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RemtPsnl0100VO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RemtWfep0100VO;
import com.app.smrmf.pkg.proc.remt.retirement.payr.RetirementPayrService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Payr0305ServiceImpl.java
 * @Description : Payr0305 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("RetirementPayrService")
public class RetirementPayrServiceImpl extends AbstractServiceImpl implements  RetirementPayrService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RetirementPayrServiceImpl.class);
	
	 @Autowired  
	 @Resource(name="InfcPkgRemt2000DAO")
     private InfcPkgRemt2000DAO infcRemt2000DAO;
	
	 @Autowired  
	 @Resource(name="InfcPkgRemt2100DAO")
	 private InfcPkgRemt2100DAO infcRemt2100DAO;
	 
	 @Autowired  
	 @Resource(name="InfcPkgRemt2200DAO")
	 private InfcPkgRemt2200DAO infcRemt2200DAO;
	 
	 @Autowired  
	 @Resource(name="InfcPkgRemt2300DAO")
	 private InfcPkgRemt2300DAO infcRemt2300DAO;
	 
	 @Resource(name="InfcPkgRemt3000DAO")
	 private InfcPkgRemt3000DAO infcRemt3000DAO;
	 

	    @Resource(name="InfcPkgRemt3100DAO")
	    private InfcPkgRemt3100DAO infcRemt3100DAO;
	    
	    @Resource(name="InfcPkgRemt3200DAO")
	    private InfcPkgRemt3200DAO infcRemt3200DAO;
	    
	 @Autowired  
	 @Resource(name="RetirementPayrDAO")
	 private RetirementPayrDAO retirementPayrDAO;
	     

    /** ID Generation */
    //@Resource(name="{egovRemt2000IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * REMT2000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt2000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt2000(InfcPkgRemt2000VO vo) throws Exception {
    	//LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	//LOGGER.debug(vo.toString());
    	
    	infcRemt2000DAO.insertRemt2000(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * REMT2000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt2000VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt2000(InfcPkgRemt2000VO vo) throws Exception {
    	infcRemt2000DAO.updateRemt2000(vo);
    }

    /**
	 * REMT2000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt2000VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt2000(InfcPkgRemt2000VO vo) throws Exception {
    	infcRemt2000DAO.deleteRemt2000(vo);
    }
    
    
    /**
  	 * 퇴직정산대상자의 기본정보를 불러온다. 
  	 * @param vo - 조회할 정보가 담긴 Remt2000VO
  	 * @return 조회한 REMT2000
  	 * @exception Exception
  	 */
      public RemtPsnl0100VO selectRemt0100ToPsnl0100(RemtPsnl0100SrhVO vo) throws Exception {
    	  RemtPsnl0100VO resultVO = retirementPayrDAO.selectRemt0100ToPsnl0100(vo);
          //if (resultVO == null)
            //  throw processException("info.nodata.msg");
          return resultVO;
      }

      /**
       * 퇴직일자에 따른 근속년/월/일   실근무년수,월수,일수 계산 
       */
      public RemtLogSvcDysVO selectLogSvcDys(RemtLogSvcDysVO vo) throws Exception {
    	  RemtLogSvcDysVO resultVO = retirementPayrDAO.selectLogSvcDys(vo);
          //if (resultVO == null)
            //  throw processException("info.nodata.msg");
          return resultVO;
      }
      
      public Remt0100DlgnVO selectRemt0100Dlgn(Remt0100DlgnVO remt0100DlgnVo) throws Exception {
    	  Remt0100DlgnVO resultVO = retirementPayrDAO.selectRemt0100Dlgn(remt0100DlgnVo);
          //if (resultVO == null)
            //  throw processException("info.nodata.msg");
          return resultVO;
      }    
 
  	
      /**
       * 퇴직일자 기준 3개월간 일자 구간 값 계산하여 가져오기 
       * 이전/현 근속년수코드 가져오기 
       */
       public List<?> selectDateTermList(InfcPkgRemt2000VO infcRemt2000Vo)  throws Exception {
          return infcRemt2000DAO.selectDateTermList(infcRemt2000Vo);
      }
       
       public List<InfcPkgPayr0410VO> selectRemt0100ToPayr4100List( InfcPkgRemt2000SrhVO infcRemt2000SrhVo)   throws Exception {
           return retirementPayrDAO.selectRemt0100ToPayr4100List( infcRemt2000SrhVo);
       }
       
       public List<RemtWfep0100VO> selectRemtWfep0100List( RemtPayr0302SrhVO  remtPayr0302SrhVo)   throws Exception {
           return retirementPayrDAO.selectRemtWfep0100List( remtPayr0302SrhVo);
       }
 
  
       
       public List selectRemt0100ToPayr0302List(RemtPayr0302SrhVO  remtPayr0302SrhVo)  throws Exception {
           return retirementPayrDAO.selectRemt0100ToPayr0302List(remtPayr0302SrhVo);
       } 
       
       
       
    /**
	 * REMT2000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt2000VO
	 * @return 조회한 REMT2000
	 * @exception Exception
	 */
    public InfcPkgRemt2000VO selectRemt2000(InfcPkgRemt2000VO vo) throws Exception {
        InfcPkgRemt2000VO resultVO = infcRemt2000DAO.selectRemt2000(vo);
        //if (resultVO == null)
          //  throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * REMT2000 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2000 목록
	 * @exception Exception
	 */
    public List<?> selectRemt2000List(InfcPkgRemt2000SrhVO searchVO) throws Exception {
        return infcRemt2000DAO.selectRemt2000List(searchVO);
    }

    /**
	 * REMT2000 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2000 총 갯수
	 * @exception
	 */
    public int selectRemt2000ListTotCnt(InfcPkgRemt2000SrhVO searchVO) {
		return infcRemt2000DAO.selectRemt2000ListTotCnt(searchVO);
	}
    
    /**
	 * REMT2100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt2100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt2100(InfcPkgRemt2100VO vo) throws Exception {
    	//LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	//LOGGER.debug(vo.toString());
    	
    	infcRemt2100DAO.insertRemt2100(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * REMT2100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt2100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt2100(InfcPkgRemt2100VO vo) throws Exception {
    	infcRemt2100DAO.updateRemt2100(vo);
    }

    /**
	 * REMT2100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt2100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt2100(InfcPkgRemt2100VO vo) throws Exception {
    	infcRemt2100DAO.deleteRemt2100(vo);
    }
    
    /**
  	 * REMT2100을 삭제한다.
  	 * @param vo - 삭제할 정보가 담긴 Remt2100VO
  	 * @return void형 
  	 * @exception Exception
  	 */
      public void deleteRemt0100CalcRemt2100(InfcPkgRemt2100VO vo) throws Exception {
      	infcRemt2100DAO.deleteRemt0100CalcRemt2100(vo);
      }
     

    /**
	 * REMT2100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt2100VO
	 * @return 조회한 REMT2100
	 * @exception Exception
	 */
    public InfcPkgRemt2100VO selectRemt2100(InfcPkgRemt2100VO vo) throws Exception {
        InfcPkgRemt2100VO resultVO = infcRemt2100DAO.selectRemt2100(vo);
       // if (resultVO == null)
         //   throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * REMT2100 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2100 목록
	 * @exception Exception
	 */
    public List<?> selectRemt2100List(InfcPkgRemt2100SrhVO searchVO) throws Exception {
        return infcRemt2100DAO.selectRemt2100List(searchVO);
    }

    /**
	 * REMT2100 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2100 총 갯수
	 * @exception
	 */
    public int selectRemt2100ListTotCnt(InfcPkgRemt2100SrhVO searchVO) {
		return infcRemt2100DAO.selectRemt2100ListTotCnt(searchVO);
	}
    
	/**
	 * REMT2200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt2200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt2200(InfcPkgRemt2200VO vo) throws Exception {
    	//LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	//LOGGER.debug(vo.toString());
    	
    	infcRemt2200DAO.insertRemt2200(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * REMT2200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt2200VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt2200(InfcPkgRemt2200VO vo) throws Exception {
    	infcRemt2200DAO.updateRemt2200(vo);
    }

    /**
	 * REMT2200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt2200VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt2200(InfcPkgRemt2200VO vo) throws Exception {
    	infcRemt2200DAO.deleteRemt2200(vo);
    }

    public void deleteRemt0100CalcRemt2200(InfcPkgRemt2200VO vo) throws Exception {
    	infcRemt2200DAO.deleteRemt0100CalcRemt2200(vo);
    }
  
    
    /**
	 * REMT2200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt2200VO
	 * @return 조회한 REMT2200
	 * @exception Exception
	 */
    public InfcPkgRemt2200VO selectRemt2200(InfcPkgRemt2200VO vo) throws Exception {
        InfcPkgRemt2200VO resultVO = infcRemt2200DAO.selectRemt2200(vo);
        //if (resultVO == null)
          //  throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * REMT2200 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2200 목록
	 * @exception Exception
	 */
    public List<?> selectRemt2200List(InfcPkgRemt2200SrhVO searchVO) throws Exception {
        return infcRemt2200DAO.selectRemt2200List(searchVO);
    }

    /**
	 * REMT2200 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2200 총 갯수
	 * @exception
	 */
    public int selectRemt2200ListTotCnt(InfcPkgRemt2200SrhVO searchVO) {
		return infcRemt2200DAO.selectRemt2200ListTotCnt(searchVO);
	}
    
    /**
	 * REMT2300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt2300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt2300(InfcPkgRemt2300VO vo) throws Exception {
    	//LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	//LOGGER.debug(vo.toString());
    	
    	infcRemt2300DAO.insertRemt2300(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }
    
    

    /**
	 * REMT2300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt2300VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt2300(InfcPkgRemt2300VO vo) throws Exception {
    	infcRemt2300DAO.updateRemt2300(vo);
    }
    
    public void updateRemt3100ToRemt2300Data(InfcPkgRemt2300VO vo) throws Exception {
    	infcRemt2300DAO.updateRemt3100ToRemt2300Data(vo);
    }
     
    
    /**
	 * REMT2300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt2300VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt2300(InfcPkgRemt2300VO vo) throws Exception {
    	infcRemt2300DAO.deleteRemt2300(vo);
    }

    /**
	 * REMT2300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt2300VO
	 * @return 조회한 REMT2300
	 * @exception Exception
	 */
    public InfcPkgRemt2300VO selectRemt2300(InfcPkgRemt2300VO vo) throws Exception {
        InfcPkgRemt2300VO resultVO = infcRemt2300DAO.selectRemt2300(vo);
        //if (resultVO == null)
          //  throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * REMT2300 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2300 목록
	 * @exception Exception
	 */
    public List<?> selectRemt2300List(InfcPkgRemt2300SrhVO searchVO) throws Exception {
        return infcRemt2300DAO.selectRemt2300List(searchVO);
    }

    /**
	 * REMT2300 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT2300 총 갯수
	 * @exception
	 */
    public int selectRemt2300ListTotCnt(InfcPkgRemt2300SrhVO searchVO) {
		return infcRemt2300DAO.selectRemt2300ListTotCnt(searchVO);
	}
    
    /**
	 * REMT3000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt3000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt3000(InfcPkgRemt3000VO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	infcRemt3000DAO.insertRemt3000(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * REMT3000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt3000VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt3000(InfcPkgRemt3000VO vo) throws Exception {
    	infcRemt3000DAO.updateRemt3000(vo);
    }

    /**
	 * REMT3000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt3000VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt3000(InfcPkgRemt3000VO vo) throws Exception {
    	infcRemt3000DAO.deleteRemt3000(vo);
    }

    /**
	 * REMT3000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt3000VO
	 * @return 조회한 REMT3000
	 * @exception Exception
	 */
    public InfcPkgRemt3000VO selectRemt3000(InfcPkgRemt3000VO vo) throws Exception {
    	InfcPkgRemt3000VO resultVO = infcRemt3000DAO.selectRemt3000(vo);
        //if (resultVO == null)
        //    throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * REMT3000 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT3000 목록
	 * @exception Exception
	 */
    public List<?> selectRemt3000List(InfcPkgRemt3000SrhVO searchVO) throws Exception {
        return infcRemt3000DAO.selectRemt3000List(searchVO);
    }

    /**
	 * REMT3000 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT3000 총 갯수
	 * @exception
	 */
    public int selectRemt3000ListTotCnt(InfcPkgRemt3000SrhVO searchVO) {
		return infcRemt3000DAO.selectRemt3000ListTotCnt(searchVO);
	}
    
    
    /**
	 * REMT3100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt3100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt3100(InfcPkgRemt3100VO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	infcRemt3100DAO.insertRemt3100(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }
    
    

    /**
	 * REMT3100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt3100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt3100(InfcPkgRemt3100VO vo) throws Exception {
    	infcRemt3100DAO.updateRemt3100(vo);
    }
    
    public void updateRemt3100Remt2000Data(InfcPkgRemt3100VO vo) throws Exception {
    	infcRemt3100DAO.updateRemt3100Remt2000Data(vo);
    }
    
    
    

    /**
	 * REMT3100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt3100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt3100(InfcPkgRemt3100VO vo) throws Exception {
    	infcRemt3100DAO.deleteRemt3100(vo);
    }

    /**
	 * REMT3100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt3100VO
	 * @return 조회한 REMT3100
	 * @exception Exception
	 */
    public InfcPkgRemt3100VO selectRemt3100(InfcPkgRemt3100VO vo) throws Exception {
    	InfcPkgRemt3100VO resultVO = infcRemt3100DAO.selectRemt3100(vo);
       // if (resultVO == null)
        //    throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * REMT3100 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT3100 목록
	 * @exception Exception
	 */
    public List<?> selectRemt3100List(InfcPkgRemt3100SrhVO searchVO) throws Exception {
        return infcRemt3100DAO.selectRemt3100List(searchVO);
    }

    /**
	 * REMT3100 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT3100 총 갯수
	 * @exception
	 */
    public int selectRemt3100ListTotCnt(InfcPkgRemt3100SrhVO searchVO) {
		return infcRemt3100DAO.selectRemt3100ListTotCnt(searchVO);
	}
 
	
	/**
	 * REMT3200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt3200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt3200(InfcPkgRemt3200VO vo) throws Exception {
    	LOGGER.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	LOGGER.debug(vo.toString());
    	
    	infcRemt3200DAO.insertRemt3200(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * REMT3200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt3200VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt3200(InfcPkgRemt3200VO vo) throws Exception {
    	infcRemt3200DAO.updateRemt3200(vo);
    }

    /**
	 * REMT3200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt3200VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt3200(InfcPkgRemt3200VO vo) throws Exception {
    	infcRemt3200DAO.deleteRemt3200(vo);
    }

    /**
	 * REMT3200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt3200VO
	 * @return 조회한 REMT3200
	 * @exception Exception
	 */
    public InfcPkgRemt3200VO selectRemt3200(InfcPkgRemt3200VO vo) throws Exception {
    	InfcPkgRemt3200VO resultVO = infcRemt3200DAO.selectRemt3200(vo);
       // if (resultVO == null)
         //   throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * REMT3200 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT3200 목록
	 * @exception Exception
	 */
    public List<?> selectRemt3200List(InfcPkgRemt3200SrhVO searchVO) throws Exception {
        return infcRemt3200DAO.selectRemt3200List(searchVO);
    }

    /**
	 * REMT3200 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return REMT3200 총 갯수
	 * @exception
	 */
    public int selectRemt3200ListTotCnt(InfcPkgRemt3200SrhVO searchVO) {
		return infcRemt3200DAO.selectRemt3200ListTotCnt(searchVO);
	}
    
    public int selectMarTotAmntDays(InfcPkgRemt2100SrhVO infcRemt2100SrhVo) {
		return infcRemt2100DAO.selectMarTotAmntDays(infcRemt2100SrhVo);
	}
     
}
