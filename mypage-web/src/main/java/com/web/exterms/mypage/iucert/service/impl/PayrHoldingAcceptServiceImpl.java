package com.web.exterms.mypage.iucert.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import com.web.exterms.mypage.iucert.service.PayrHoldingAcceptService;
import com.web.exterms.mypage.iucert.service.PayrHoldingAcceptDefaultVO;
import com.web.exterms.mypage.iucert.service.PayrHoldingAcceptVO;
import com.web.exterms.mypage.iucert.service.impl.PayrHoldingAcceptDAO;

/**
 * @Class Name : Payr0900ServiceImpl.java
 * @Description : Payr0900 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("payr0900Service")
public class PayrHoldingAcceptServiceImpl extends AbstractServiceImpl implements
        PayrHoldingAcceptService {

    @Resource(name="payr0900DAO")
    private PayrHoldingAcceptDAO payr0900DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPayr0900IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * PAYR0900을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0900VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPayr0900(PayrHoldingAcceptVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	payr0900DAO.insertPayr0900(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * PAYR0900을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0900VO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePayr0900(PayrHoldingAcceptVO vo) throws Exception {
        payr0900DAO.updatePayr0900(vo);
    }

    /**
	 * PAYR0900을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0900VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePayr0900(PayrHoldingAcceptVO vo) throws Exception {
        payr0900DAO.deletePayr0900(vo);
    }

    /**
	 * PAYR0900을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0900VO
	 * @return 조회한 PAYR0900
	 * @exception Exception
	 */
    public PayrHoldingAcceptVO selectPayr0900(PayrHoldingAcceptVO vo) throws Exception {
        PayrHoldingAcceptVO resultVO = payr0900DAO.selectPayr0900(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * PAYR0900 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PAYR0900 목록
	 * @exception Exception
	 */
    public List selectPayr0900List(PayrHoldingAcceptDefaultVO searchVO) throws Exception {
        return payr0900DAO.selectPayr0900List(searchVO);
    }

    /**
	 * PAYR0900 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PAYR0900 총 갯수
	 * @exception
	 */
    public int selectPayr0900ListTotCnt(PayrHoldingAcceptDefaultVO searchVO) {
		return payr0900DAO.selectPayr0900ListTotCnt(searchVO);
	}
    
}
