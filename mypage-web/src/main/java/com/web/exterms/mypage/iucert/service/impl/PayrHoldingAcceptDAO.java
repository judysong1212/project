package com.web.exterms.mypage.iucert.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import com.web.exterms.mypage.iucert.service.PayrHoldingAcceptVO;
import com.web.exterms.mypage.iucert.service.PayrHoldingAcceptDefaultVO;

/**
 * @Class Name : Payr0900DAO.java
 * @Description : Payr0900 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("payr0900DAO")
public class PayrHoldingAcceptDAO extends EgovAbstractDAO {

	/**
	 * PAYR0900을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0900VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPayr0900(PayrHoldingAcceptVO vo) throws Exception {
        return (String)insert("payr0900DAO.insertPayr0900_S", vo);
    }

    /**
	 * PAYR0900을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0900VO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePayr0900(PayrHoldingAcceptVO vo) throws Exception {
        update("payr0900DAO.updatePayr0900_S", vo);
    }

    /**
	 * PAYR0900을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0900VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePayr0900(PayrHoldingAcceptVO vo) throws Exception {
        delete("payr0900DAO.deletePayr0900_S", vo);
    }

    /**
	 * PAYR0900을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0900VO
	 * @return 조회한 PAYR0900
	 * @exception Exception
	 */
    public PayrHoldingAcceptVO selectPayr0900(PayrHoldingAcceptVO vo) throws Exception {
        return (PayrHoldingAcceptVO) selectByPk("payr0900DAO.selectPayr0900_S", vo);
    }

    /**
	 * PAYR0900 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0900 목록
	 * @exception Exception
	 */
    public List selectPayr0900List(PayrHoldingAcceptDefaultVO searchVO) throws Exception {
        return list("payr0900DAO.selectPayr0900List_D", searchVO);
    }

    /**
	 * PAYR0900 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0900 총 갯수
	 * @exception
	 */
    public int selectPayr0900ListTotCnt(PayrHoldingAcceptDefaultVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0900DAO.selectPayr0900ListTotCnt_S", searchVO);
    }

}