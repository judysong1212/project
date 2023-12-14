package com.app.smrmf.infc.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt9000SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt9000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt9000DAO.java
 * @Description : Remt9000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgRemt9000DAO")
public class InfcPkgRemt9000DAO extends EgovAbstractDAO {

	/**
	 * REMT9000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt9000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertRemt9000(InfcPkgRemt9000VO vo) throws Exception {
        return (String)insert("infcPkgRemt9000DAO.insertRemt9000_S", vo);
    }

    /**
	 * REMT9000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt9000VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateRemt9000(InfcPkgRemt9000VO vo) throws Exception {
        update("infcPkgRemt9000DAO.updateRemt9000_S", vo);
    }

    /**
	 * REMT9000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt9000VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteRemt9000(InfcPkgRemt9000VO vo) throws Exception {
        delete("infcPkgRemt9000DAO.deleteRemt9000_S", vo);
    }

    /**
	 * REMT9000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt9000VO
	 * @return 조회한 REMT9000
	 * @exception Exception
	 */
    public InfcPkgRemt9000VO selectRemt9000(InfcPkgRemt9000VO vo) throws Exception {
        return (InfcPkgRemt9000VO) selectByPk("infcPkgRemt9000DAO.selectRemt9000_S", vo);
    }

    /**
	 * REMT9000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT9000 목록
	 * @exception Exception
	 */
    public List selectRemt9000List(InfcPkgRemt9000SrhVO searchVO) throws Exception {
        return list("infcPkgRemt9000DAO.selectRemt9000List_D", searchVO);
    }

    /**
	 * REMT9000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT9000 총 갯수
	 * @exception
	 */
    public int selectRemt9000ListTotCnt(InfcPkgRemt9000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgRemt9000DAO.selectRemt9000ListTotCnt_S", searchVO);
    }

}
