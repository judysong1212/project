package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0430SrhVO;
import com.app.exterms.payroll.server.vo.Payr0430VO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0300SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0430DAO.java
 * @Description : Payr0430 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0430DAO")
public class Payr0430DAO extends EgovAbstractDAO {

	/**
	 * PAYR0430을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0430VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0430(Payr0430VO vo) throws Exception {
        return (String)insert("payr0430DAO.insertPayr0430_S", vo);
    }

    /**
	 * PAYR0430을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0430VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0430(Payr0430VO vo) throws Exception {
        update("payr0430DAO.updatePayr0430_S", vo);
    }

    /**
	 * PAYR0430을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0430VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0430(Payr0430VO vo) throws Exception {
        delete("payr0430DAO.deletePayr0430_S", vo);
    }

    /**
	 * PAYR0430을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0430VO
	 * @return 조회한 PAYR0430
	 * @exception Exception
	 */
    public Payr0430VO selectPayr0430(Payr0430VO vo) throws Exception {
        return (Payr0430VO) selectByPk("payr0430DAO.selectPayr0430_S", vo);
    }

    /**
	 * PAYR0430 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0430 목록
	 * @exception Exception
	 */
    public List selectPayr0430List(Payr0430SrhVO searchVO) throws Exception {
        return list("payr0430DAO.selectPayr0430List_D", searchVO);
    }

    /**
	 * PAYR0430 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0430 총 갯수
	 * @exception
	 */
    public int selectPayr0430ListTotCnt(Payr0430SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0430DAO.selectPayr0430ListTotCnt_S", searchVO);
    }

    
    /**
     * 근속년수 리스트 정보를 가지고 온다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return Bass0300 목록
     * @exception Exception
     */
    public List selectBass0300List(InfcPkgBass0300SrhVO searchVO) throws Exception {
        return list("payr0430DAO.selectBass0300List_D", searchVO);
    }

    
}
