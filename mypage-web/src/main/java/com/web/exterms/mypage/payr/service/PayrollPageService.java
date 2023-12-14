package com.web.exterms.mypage.payr.service;

import java.util.HashMap;
import java.util.List;
import com.web.exterms.mypage.payr.service.PayrollPageDefaultVO;
import com.web.exterms.mypage.payr.service.PayrollPageVO;

/**
 * @Class Name : Payr0100Service.java
 * @Description : Payr0100 Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface PayrollPageService {
	
	@SuppressWarnings("rawtypes")
	public List getPayList(PayrollPageVO payrollPageVO) throws Exception;
	
	@SuppressWarnings("rawtypes")
	public PayrollPageVO getPayDetailMemberInfo(PayrollPageVO payrollPageVO) throws Exception;
	
	@SuppressWarnings("rawtypes")
	public PayrollPageVO getPayDetailPay(PayrollPageVO payrollPageVO) throws Exception;
	
	@SuppressWarnings("rawtypes")
	public List getPayDetailExtpyList(PayrollPageVO payrollPageVO) throws Exception;
	
	@SuppressWarnings("rawtypes")
	public List getPayDetailExtpyList2(PayrollPageVO payrollPageVO) throws Exception;
	
	@SuppressWarnings("rawtypes")
	public List getPayDetailDducList(PayrollPageVO payrollPageVO) throws Exception;
	
	public String getChildHday(PayrollPageVO payrollPageVO) throws Exception;
	/***
	 * 단가표 조회
	 * @param hMap
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List getMyCost(PayrollPageVO payrollPageVO) throws Exception;
	
	//@SuppressWarnings("rawtypes")
	//public List getMyCostInfo(HashMap<String, String> hMap) throws Exception;
	
	/***
	 * 급여구분 조회
	 * @param hMap
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public List getPayDetailDivisionList(PayrollPageVO payrollPageVO) throws Exception;
	
	/**
	 * PAYR0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertPayr0100(PayrollPageVO vo) throws Exception;
    
    /**
	 * PAYR0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0100VO
	 * @return void형
	 * @exception Exception
	 */
    void updatePayr0100(PayrollPageVO vo) throws Exception;
    
    /**
	 * PAYR0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0100VO
	 * @return void형 
	 * @exception Exception
	 */
    void deletePayr0100(PayrollPageVO vo) throws Exception;
    
    /**
	 * PAYR0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0100VO
	 * @return 조회한 PAYR0100
	 * @exception Exception
	 */
    PayrollPageVO selectPayr0100(PayrollPageVO vo) throws Exception;
    
    /**
	 * PAYR0100 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PAYR0100 목록
	 * @exception Exception
	 */
    List selectPayr0100List(PayrollPageDefaultVO searchVO) throws Exception;
    
    /**
	 * PAYR0100 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PAYR0100 총 갯수
	 * @exception
	 */
    int selectPayr0100ListTotCnt(PayrollPageDefaultVO searchVO);
    
}
