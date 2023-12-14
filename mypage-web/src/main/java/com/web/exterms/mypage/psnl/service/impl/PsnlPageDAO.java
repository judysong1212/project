package com.web.exterms.mypage.psnl.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.web.exterms.mypage.iucert.service.PsnlProofAcceptVO;
import com.web.exterms.mypage.psnl.service.PsnlPageDefaultVO;
import com.web.exterms.mypage.psnl.service.PsnlPageVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PsnlPageDAO.java
 * @Description : PsnlPage DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.06
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnlPageDAO")
public class PsnlPageDAO extends EgovAbstractDAO {
	
	@SuppressWarnings("rawtypes")
	public PsnlPageVO selectPsnl0100(PsnlPageVO psnlPageVO) throws Exception{
		return  (PsnlPageVO) selectByPk("psnlPageDAO.selectPsnl0100", psnlPageVO);
	}
	
	@SuppressWarnings("rawtypes")
	public List getZipCodeList(HashMap<String, String> hMap) throws Exception{
		return list("psnlPageDAO.getZipCodeList", hMap);
	}
	
	public int updateDoroAddr(PsnlPageVO psnlPageVO) throws Exception{
		return update("psnlPageDAO.updateDoroAddr", psnlPageVO);
	}
	
	@SuppressWarnings("rawtypes")
	public List getFamilyList(PsnlPageVO psnlPageVO) throws Exception{
		return list("psnlPageDAO.getFamilyList", psnlPageVO);
	}
	
	@SuppressWarnings("rawtypes")
	public List getCertType(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception{
		return list("psnlPageDAO.getCertType", psnlProofAcceptVO);
	}
	
	
	public String getCertListTotCnt(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception{
		return (String)getSqlMapClientTemplate().queryForObject("psnlPageDAO.getCertListTotCnt", psnlProofAcceptVO);
	}
	
	@SuppressWarnings("rawtypes")
	public List getCertList(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception{
		return list("psnlPageDAO.getCertList", psnlProofAcceptVO);
	}
	
	public String insertCertInfo(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception{
		return (String)insert("psnlPageDAO.insertCertInfo",psnlProofAcceptVO);
	}
	
	public int deleteCertInfo(PsnlProofAcceptVO vo) throws Exception{
		return update("psnlPageDAO.deleteCertInfo", vo);
	}
	
	public int afterPrintDown(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception{
		return update("psnlPageDAO.afterPrintDown", psnlProofAcceptVO);
	}
	
	/* 원천징수 인쇄 처리후 변경을 위해서 추가 */
	public int afterPrintDown2(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception {		
		return update("psnlPageDAO.afterPrintDown2", psnlProofAcceptVO);
	}
	
	public String getPayrCertListTotCnt(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception{
		return (String)getSqlMapClientTemplate().queryForObject("psnlPageDAO.getPayrCertListTotCnt", psnlProofAcceptVO);
	}
	
	@SuppressWarnings("rawtypes")
	public List getPayrCertList(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception{
		return list("psnlPageDAO.getPayrCertList", psnlProofAcceptVO);
	}
	
	public String insertPayrCertInfo(PsnlProofAcceptVO psnlProofAcceptVO) throws Exception{
		return (String)insert("psnlPageDAO.insertPayrCertInfo",psnlProofAcceptVO);
	}
	
	public int deletePayrCertInfo(PsnlProofAcceptVO vo) throws Exception{
		return update("psnlPageDAO.deletePayrCertInfo", vo);
	}
	
	@SuppressWarnings("rawtypes")
	public List getCarrList(PsnlPageVO psnlPageVO) throws Exception{
		return list("psnlPageDAO.getCarrList", psnlPageVO);
	}
	
	@SuppressWarnings("rawtypes")
	public List getRewardList(PsnlPageVO psnlPageVO) throws Exception{
		return list("psnlPageDAO.getRewardList", psnlPageVO);
	}
	
	/**
	 * PSNL0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 PsnlPageVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPsnlPage(PsnlPageVO vo) throws Exception {
        return (String)insert("psnlPageDAO.insertPsnlPage_S", vo);
    }

    /**
	 * PSNL0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 PsnlPageVO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePsnlPage(PsnlPageVO vo) throws Exception {
        update("psnlPageDAO.updatePsnlPage_S", vo);
    }

    /**
	 * PSNL0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 PsnlPageVO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePsnlPage(PsnlPageVO vo) throws Exception {
        delete("psnlPageDAO.deletePsnlPage_S", vo);
    }

    /**
	 * PSNL0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 PsnlPageVO
	 * @return 조회한 PSNL0100
	 * @exception Exception
	 */
    public PsnlPageVO selectPsnlPage(PsnlPageVO vo) throws Exception {
        return (PsnlPageVO) selectByPk("psnlPageDAO.selectPsnlPage_S", vo);
    }

    /**
	 * PSNL0100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0100 목록
	 * @exception Exception
	 */
    public List selectPsnlPageList(PsnlPageDefaultVO searchVO) throws Exception {
        return list("psnlPageDAO.selectPsnlPageList_D", searchVO);
    }

    /**
	 * PSNL0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0100 총 갯수
	 * @exception
	 */
    public int selectPsnlPageListTotCnt(PsnlPageDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnlPageDAO.selectPsnlPageListTotCnt_S", searchVO);
    }

	

}
