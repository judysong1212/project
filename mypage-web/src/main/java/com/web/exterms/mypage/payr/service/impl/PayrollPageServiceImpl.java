package com.web.exterms.mypage.payr.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.exterms.mypage.payr.service.PayrollPageDefaultVO;
import com.web.exterms.mypage.payr.service.PayrollPageService;
import com.web.exterms.mypage.payr.service.PayrollPageVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

/**
 * @Class Name : Payr0100ServiceImpl.java
 * @Description : Payr0100 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("payr0100Service")
public class PayrollPageServiceImpl extends AbstractServiceImpl implements
        PayrollPageService {

    @Resource(name="payr0100DAO")
    private PayrollPageDAO payr0100DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPayr0100IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	/**
	 * PAYR0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPayr0100(PayrollPageVO vo) throws Exception {
    	log.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	log.debug(vo.toString());
    	
    	payr0100DAO.insertPayr0100(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * PAYR0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePayr0100(PayrollPageVO vo) throws Exception {
        payr0100DAO.updatePayr0100(vo);
    }

    /**
	 * PAYR0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePayr0100(PayrollPageVO vo) throws Exception {
        payr0100DAO.deletePayr0100(vo);
    }

    /**
	 * PAYR0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0100VO
	 * @return 조회한 PAYR0100
	 * @exception Exception
	 */
    public PayrollPageVO selectPayr0100(PayrollPageVO vo) throws Exception {
        PayrollPageVO resultVO = payr0100DAO.selectPayr0100(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * PAYR0100 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PAYR0100 목록
	 * @exception Exception
	 */
    public List selectPayr0100List(PayrollPageDefaultVO searchVO) throws Exception {
        return payr0100DAO.selectPayr0100List(searchVO);
    }
    

    /**
	 * PAYR0100 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PAYR0100 총 갯수
	 * @exception
	 */
    public int selectPayr0100ListTotCnt(PayrollPageDefaultVO searchVO) {
		return payr0100DAO.selectPayr0100ListTotCnt(searchVO);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getPayList(PayrollPageVO payrollPageVO) throws Exception {
		return payr0100DAO.getPayList(payrollPageVO);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public PayrollPageVO getPayDetailMemberInfo(PayrollPageVO payrollPageVO)throws Exception {
		return payr0100DAO.getPayDetailMemberInfo(payrollPageVO);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public PayrollPageVO getPayDetailPay(PayrollPageVO payrollPageVO)
			throws Exception {
		return payr0100DAO.getPayDetailPay(payrollPageVO);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getPayDetailExtpyList(PayrollPageVO payrollPageVO) throws Exception {
		return payr0100DAO.getPayDetailExtpyList(payrollPageVO);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public List getPayDetailExtpyList2(PayrollPageVO payrollPageVO) throws Exception {
		return payr0100DAO.getPayDetailExtpyList2(payrollPageVO);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getPayDetailDducList(PayrollPageVO payrollPageVO)
			throws Exception {
		return payr0100DAO.getPayDetailDducList(payrollPageVO);
	}

	@Override
	public String getChildHday(PayrollPageVO payrollPageVO) throws Exception {
		return payr0100DAO.getChildHday(payrollPageVO);
	}
	/** 단가표 조회 */
	@Override
	public List getMyCost(PayrollPageVO payrollPageVO) throws Exception {
		// TODO Auto-generated method stub
		return payr0100DAO.getMyCost(payrollPageVO);
	}

//	@Override
//	public List getMyCostInfo(HashMap<String, String> hMap) throws Exception {
//		// TODO Auto-generated method stub
//		return payr0100DAO.getMyCostInfo(hMap);
//	}
	
    /**
	 * PAYR0100 급여구분 콤보박스 조회
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PAYR0100 목록
	 * @exception Exception
	 */
    public List getPayDetailDivisionList(PayrollPageVO payrollPageVO) throws Exception {
        return payr0100DAO.getPayDetailDivisionList(payrollPageVO);
    }
    
}
