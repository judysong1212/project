package com.app.smrmf.infc.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt1000SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt1000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt1000DAO.java
 * @Description : Remt1000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgRemt1000DAO")
public class InfcPkgRemt1000DAO extends EgovAbstractDAO {

	/**
	 * REMT1000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt1000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertRemt1000(InfcPkgRemt1000VO vo) throws Exception {
        return (String)insert("infcPkgRemt1000DAO.insertRemt1000_S", vo);
    }

    /**
	 * REMT1000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt1000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateRemt1000(InfcPkgRemt1000VO vo) throws Exception {
        update("infcPkgRemt1000DAO.updateRemt1000_S", vo);
    }

    /**
	 * REMT1000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt1000VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteRemt1000(InfcPkgRemt1000VO vo) throws Exception {
        delete("infcPkgRemt1000DAO.deleteRemt1000_S", vo);
    }

    /**
	 * REMT1000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt1000VO
	 * @return 조회한 REMT1000
	 * @exception Exception
	 */
    public InfcPkgRemt1000VO selectRemt1000(InfcPkgRemt1000VO vo) throws Exception {
        return (InfcPkgRemt1000VO) selectByPk("infcPkgRemt1000DAO.selectRemt1000_S", vo);
    }

    /**
	 * REMT1000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT1000 목록
	 * @exception Exception
	 */
    public List selectRemt1000List(InfcPkgRemt1000SrhVO searchVO) throws Exception {
        return list("infcPkgRemt1000DAO.selectRemt1000List_D", searchVO);
    }

    /**
	 * REMT1000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT1000 총 갯수
	 * @exception
	 */
    public int selectRemt1000ListTotCnt(InfcPkgRemt1000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgRemt1000DAO.selectRemt1000ListTotCnt_S", searchVO);
    }

}
