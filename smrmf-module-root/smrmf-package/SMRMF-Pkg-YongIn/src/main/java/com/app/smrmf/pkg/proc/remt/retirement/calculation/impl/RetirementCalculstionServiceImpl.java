package com.app.smrmf.pkg.proc.remt.retirement.calculation.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.basis.server.service.dao.InfcPkgBass0100DAO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0100VO;
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt3000DAO;
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt3100DAO;
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt3200DAO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3000SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3000VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3100SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3100VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3200SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3200VO;
import com.app.smrmf.pkg.proc.remt.retirement.calculation.RetirementCalculstionService;

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

@Service("RetirementCalculstionService")
public class RetirementCalculstionServiceImpl extends AbstractServiceImpl implements  RetirementCalculstionService {
 
	private static final Logger LOGGER = LoggerFactory.getLogger(RetirementCalculstionServiceImpl.class);
	
	@Autowired  
    @Resource(name="InfcPkgRemt3000DAO")
    private InfcPkgRemt3000DAO infcRemt3000DAO;
	
	@Autowired
	@Resource(name="InfcPkgRemt3100DAO")
	private InfcPkgRemt3100DAO infcRemt3100DAO;
	
	@Autowired
	@Resource(name="InfcPkgRemt3200DAO")
	private InfcPkgRemt3200DAO infcRemt3200DAO;
	
	@Autowired
	@Resource(name="InfcPkgBass0100DAO")
	private InfcPkgBass0100DAO infcBass0100DAO;
    
    /** ID Generation */
    //@Resource(name="{egovRemt3000IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

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
       // if (resultVO == null)
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
        //if (resultVO == null)
        //    throw processException("info.nodata.msg");
        return resultVO;
    }
    
    public InfcPkgRemt3100VO selectRemt3100EepnYrIcm(InfcPkgRemt3100VO vo) throws Exception {
        InfcPkgRemt3100VO resultVO = infcRemt3100DAO.selectRemt3100EepnYrIcm(vo);
        //if (resultVO == null)
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
        //if (resultVO == null)
          //  throw processException("info.nodata.msg");
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
    
    
    public InfcPkgBass0100VO selectBass0100(InfcPkgBass0100VO vo) throws Exception {
    	InfcPkgBass0100VO resultVO = infcBass0100DAO.selectBass0100(vo);
        //if (resultVO == null)
          //  throw processException("info.nodata.msg");
        return resultVO;
    }
    
	 
}
