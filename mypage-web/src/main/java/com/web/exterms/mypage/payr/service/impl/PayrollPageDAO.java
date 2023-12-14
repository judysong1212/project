package com.web.exterms.mypage.payr.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import com.web.exterms.mypage.payr.service.PayrollPageVO;
import com.web.exterms.mypage.payr.service.PayrollPageDefaultVO;

/**
 * @Class Name : Payr0100DAO.java
 * @Description : Payr0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("payr0100DAO")
public class PayrollPageDAO extends EgovAbstractDAO {
	
	@SuppressWarnings("rawtypes")
	public List getPayList(PayrollPageVO payrollPageVO) throws Exception{
		return list("payrDAO.getPayList", payrollPageVO);
	}
	
	@SuppressWarnings("rawtypes")
	public PayrollPageVO getPayDetailMemberInfo(PayrollPageVO payrollPageVO) throws Exception{
		return  (PayrollPageVO) selectByPk("payrDAO.getPayDetailMemberInfo", payrollPageVO);
	}
	
	@SuppressWarnings("rawtypes")
	public PayrollPageVO getPayDetailPay(PayrollPageVO payrollPageVO) throws Exception{
		return  (PayrollPageVO) selectByPk("payrDAO.getPayDetailPay", payrollPageVO);
	}
	
	
	@SuppressWarnings("rawtypes")
	public List getPayDetailExtpyList(PayrollPageVO payrollPageVO) throws Exception{
		return list("payrDAO.getPayDetailExtpyList", payrollPageVO);
	}
	
	@SuppressWarnings("rawtypes")
	public List getPayDetailExtpyList2(PayrollPageVO payrollPageVO) throws Exception{
		return list("payrDAO.getPayDetailExtpyList2", payrollPageVO);
	}
	
	@SuppressWarnings("rawtypes")
	public List getPayDetailDducList(PayrollPageVO payrollPageVO) throws Exception{
		return list("payrDAO.getPayDetailDducList", payrollPageVO);
	}
	
	@SuppressWarnings("rawtypes")
	public List getPayDetailDivisionList(PayrollPageVO payrollPageVO) throws Exception{
		return list("payrDAO.getPayDetailDivisionList", payrollPageVO);
	}
	
	
	
	public String getChildHday(PayrollPageVO payrollPageVO) throws Exception{
		return (String)getSqlMapClientTemplate().queryForObject("payrDAO.getChildHday", payrollPageVO);
	}
	
	
	/**
	 * PAYR0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPayr0100(PayrollPageVO vo) throws Exception {
        return (String)insert("payr0100DAO.insertPayr0100_S", vo);
    }

    /**
	 * PAYR0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePayr0100(PayrollPageVO vo) throws Exception {
        update("payr0100DAO.updatePayr0100_S", vo);
    }

    /**
	 * PAYR0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePayr0100(PayrollPageVO vo) throws Exception {
        delete("payr0100DAO.deletePayr0100_S", vo);
    }

    /**
	 * PAYR0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0100VO
	 * @return 조회한 PAYR0100
	 * @exception Exception
	 */
    public PayrollPageVO selectPayr0100(PayrollPageVO vo) throws Exception {
        return (PayrollPageVO) selectByPk("payr0100DAO.selectPayr0100_S", vo);
    }

    /**
	 * PAYR0100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0100 목록
	 * @exception Exception
	 */
    public List selectPayr0100List(PayrollPageDefaultVO searchVO) throws Exception {
        return list("payr0100DAO.selectPayr0100List_D", searchVO);
    }

    /**
	 * PAYR0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0100 총 갯수
	 * @exception
	 */
    public int selectPayr0100ListTotCnt(PayrollPageDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0100DAO.selectPayr0100ListTotCnt_S", searchVO);
    }
    
    /**
   	 * 단가표조회
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0100 총 갯수
   	 * @exception
   	 */
    @SuppressWarnings("rawtypes")
	public List getMyCost(PayrollPageVO payrollPageVO) throws Exception{
		return list("payrDAO.getCost", payrollPageVO);
	}
    
//    @SuppressWarnings("rawtypes")
//	public List getMyCostInfo(HashMap<String, String> hMap) throws Exception{
//		return list("payrDAO.getCostInfo", hMap);
//	}
}
