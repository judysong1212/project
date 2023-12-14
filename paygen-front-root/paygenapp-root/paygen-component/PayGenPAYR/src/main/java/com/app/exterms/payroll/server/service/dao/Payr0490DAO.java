package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0490SrhVO;
import com.app.exterms.payroll.server.vo.Payr0490VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0490DAO.java
 * @Description : Payr0490 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0490DAO")
public class Payr0490DAO extends EgovAbstractDAO {

	/**
	 * PAYR0490을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0490VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0490(Payr0490VO vo) throws Exception {
        return (String)insert("payr0490DAO.insertPayr0490_S", vo);
    }
    
	/**
	 * PAYR0490을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0490VO
	 * @return 등록 결과
	 * @exception Exception
	 * 이전 년도 사업의 지급공제 항목을 생성해준다.
	 */
    @Transactional
    public String trurInsertPayr0490(Payr0490VO vo) throws Exception {
        return (String)insert("payr0490DAO.trurInsertPayr0490_S", vo);
    }

    /**
	 * PAYR0490을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0490VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0490(Payr0490VO vo) throws Exception {
        update("payr0490DAO.updatePayr0490_S", vo);
    }

    /**
	 * PAYR0490을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0490VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0490(Payr0490VO vo) throws Exception {
        delete("payr0490DAO.deletePayr0490_S", vo);
    }
    
    @Transactional
    public void deletePayr0490List(Payr0490SrhVO payr0490SrhVo) throws Exception {
        delete("payr0490DAO.deletePayr0490", payr0490SrhVo);
    }

    /**
	 * PAYR0490을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0490VO
	 * @return 조회한 PAYR0490
	 * @exception Exception
	 */
    public Payr0490VO selectPayr0490(Payr0490VO vo) throws Exception {
        return (Payr0490VO) selectByPk("payr0490DAO.selectPayr0490_S", vo);
    }
    
    /**
	 * PAYR0490을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0490VO
	 * @return 조회한 PAYR0490
	 * @exception Exception
	 * 이전 지급공제항목들을 가져옴.
	 */   
    public List selectBfrPayr0490List(Payr0490SrhVO payr0490SrhVO) throws Exception {
        return list("payr0490DAO.selectBfrPayr0490List", payr0490SrhVO);
    }

    /**
	 * PAYR0490 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0490 목록
	 * @exception Exception
	 */
    public List selectPayr0490List(Payr0490SrhVO searchVO) throws Exception {
        return list("payr0490DAO.selectPayr0490List_D", searchVO);
    }

    /**
	 * PAYR0490 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0490 총 갯수
	 * @exception
	 */
    public int selectPayr0490ListTotCnt(Payr0490SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0490DAO.selectPayr0490ListTotCnt_S", searchVO);
    }

    /**
     * PAYR0490을 등록한다.
     * @param vo - 등록할 정보가 담긴 Payr0490VO
     * @return 등록 결과
     * @exception Exception
     */
    @Transactional
    public String insertCopyPayr0490(Payr0490VO vo) throws Exception {
    	return (String)insert("payr0490DAO.trurCopyInsertPayr0490_S", vo);
    }

}
