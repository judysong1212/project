package com.web.exterms.mypage.psnl.service;

import java.util.HashMap;
import java.util.List;

import com.web.exterms.mypage.iucert.service.PsnlProofAcceptVO;

/**
 * @Class Name : PsnlPageService.java
 * @Description : PsnlPage Business class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public interface PsnlPageService {
	
	@SuppressWarnings("rawtypes")
	public PsnlPageVO selectPsnl0100(PsnlPageVO psnlPageVO) throws Exception;
	
	@SuppressWarnings("rawtypes")
	public List getZipCodeList(HashMap<String, String> hMap) throws Exception;
	
	public int updateDoroAddr(PsnlPageVO psnlPageVO) throws Exception;
	
	@SuppressWarnings("rawtypes")
	public List getFamilyList(PsnlPageVO psnlPageVO) throws Exception;
	
	@SuppressWarnings("rawtypes")
	public List getCarrList(PsnlPageVO psnlPageVO) throws Exception;
	
	@SuppressWarnings("rawtypes")
	public List getRewardList(PsnlPageVO psnlPageVO) throws Exception;

/**증명발급신청*/	
	/**증명발급타입*/
	@SuppressWarnings("rawtypes")
	public List getCertType(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception;
	
	/** 발급 증명서 리스트*/
	@SuppressWarnings("rawtypes")
	public List getCertList(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception;
	
	public String getCertListTotCnt(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception;
	
	public String insertCertInfo(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception;
	
	public int deleteCertInfo(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception;
	
	/**증명 출력 후*/
	public int afterPrintDown(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception;
	
	/**증명 출력 후*/ /* 원천징수 인쇄 처리후 변경을 위해서 추가 */
	public int afterPrintDown2(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception;
	
	@SuppressWarnings("rawtypes")
	public List getPayrCertList(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception;
	
	public String getPayrCertListTotCnt(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception;
	/**발급신청*/
	public String insertPayrCertInfo(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception;
	/**발급삭제*/
	public int deletePayrCertInfo(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception;
	
	/**
	 * PSNL0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 PsnlPageVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertPsnlPage(PsnlPageVO vo) throws Exception;
    
    /**
	 * PSNL0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 PsnlPageVO
	 * @return void형
	 * @exception Exception
	 */
    void updatePsnlPage(PsnlPageVO vo) throws Exception;
    
    /**
	 * PSNL0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 PsnlPageVO
	 * @return void형 
	 * @exception Exception
	 */
    void deletePsnlPage(PsnlPageVO vo) throws Exception;
    
    /**
	 * PSNL0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 PsnlPageVO
	 * @return 조회한 PSNL0100
	 * @exception Exception
	 */
    PsnlPageVO selectPsnlPage(PsnlPageVO vo) throws Exception;
    
    /**
	 * PSNL0100 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PSNL0100 목록
	 * @exception Exception
	 */
    List selectPsnlPageList(PsnlPageDefaultVO searchVO) throws Exception;
    
    /**
	 * PSNL0100 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PSNL0100 총 갯수
	 * @exception
	 */
    int selectPsnlPageListTotCnt(PsnlPageDefaultVO searchVO);
    
}
