package com.app.smrmf.pkg.proc.payr.retroactivity.calculation.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0305DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0305SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0305VO;
import com.app.smrmf.pkg.proc.payr.retroactivity.calculation.RetroactivityCalculationService;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Payr0305ServiceImpl.java
 * @Description : Payr0305 Business Implement class
 *               소급계산 
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.30
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("RetroactivityCalculationService")
public class RetroactivityCalculationServiceImpl extends AbstractServiceImpl implements  RetroactivityCalculationService {

	@Autowired  
    @Resource(name="InfcPkgPayr0305DAO")
    private InfcPkgPayr0305DAO payr0305DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPayr0305IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * PAYR0305을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0305VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPayr0305(InfcPkgPayr0305VO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	payr0305DAO.insertPayr0305(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * PAYR0305을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0305VO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePayr0305(InfcPkgPayr0305VO vo) throws Exception {
        payr0305DAO.updatePayr0305(vo);
    }

    /**
	 * PAYR0305을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0305VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePayr0305(InfcPkgPayr0305VO vo) throws Exception {
        payr0305DAO.deletePayr0305(vo);
    }

    /**
	 * PAYR0305을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0305VO
	 * @return 조회한 PAYR0305
	 * @exception Exception
	 */
    public InfcPkgPayr0305VO selectPayr0305(InfcPkgPayr0305VO vo) throws Exception {
        InfcPkgPayr0305VO resultVO = payr0305DAO.selectPayr0305(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * PAYR0305 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PAYR0305 목록
	 * @exception Exception
	 */
    public List selectPayr0305List(InfcPkgPayr0305SrhVO searchVO) throws Exception {
        return payr0305DAO.selectPayr0305List(searchVO);
    }

    /**
	 * PAYR0305 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PAYR0305 총 갯수
	 * @exception
	 */
    public int selectPayr0305ListTotCnt(InfcPkgPayr0305SrhVO searchVO) {
     
		return payr0305DAO.selectPayr0305ListTotCnt(searchVO);
	}
    
}
