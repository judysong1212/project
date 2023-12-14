package com.web.exterms.mypage.iucert.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import com.web.exterms.mypage.iucert.service.PsnlProofAcceptVO;
import com.web.exterms.mypage.iucert.service.PsnlProofAcceptDefaultVO;

/**
 * @Class Name : Psnl0550DAO.java
 * @Description : Psnl0550 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("psnl0550DAO")
public class PsnlProofAcceptDAO extends EgovAbstractDAO {

	/**
	 * PSNL0550을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0550VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPsnl0550(PsnlProofAcceptVO vo) throws Exception {
        return (String)insert("psnl0550DAO.insertPsnl0550_S", vo);
    }

    /**
	 * PSNL0550을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0550VO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePsnl0550(PsnlProofAcceptVO vo) throws Exception {
        update("psnl0550DAO.updatePsnl0550_S", vo);
    }

    /**
	 * PSNL0550을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0550VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePsnl0550(PsnlProofAcceptVO vo) throws Exception {
        delete("psnl0550DAO.deletePsnl0550_S", vo);
    }

    /**
	 * PSNL0550을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0550VO
	 * @return 조회한 PSNL0550
	 * @exception Exception
	 */
    public PsnlProofAcceptVO selectPsnl0550(PsnlProofAcceptVO vo) throws Exception {
        return (PsnlProofAcceptVO) selectByPk("psnl0550DAO.selectPsnl0550_S", vo);
    }

    /**
	 * PSNL0550 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0550 목록
	 * @exception Exception
	 */
    public List selectPsnl0550List(PsnlProofAcceptDefaultVO searchVO) throws Exception {
        return list("psnl0550DAO.selectPsnl0550List_D", searchVO);
    }

    /**
	 * PSNL0550 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0550 총 갯수
	 * @exception
	 */
    public int selectPsnl0550ListTotCnt(PsnlProofAcceptDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("psnl0550DAO.selectPsnl0550ListTotCnt_S", searchVO);
    }

}
