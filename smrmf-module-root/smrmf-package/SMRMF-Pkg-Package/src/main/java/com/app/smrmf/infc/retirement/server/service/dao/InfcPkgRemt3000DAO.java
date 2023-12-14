package com.app.smrmf.infc.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3000SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt3000DAO.java
 * @Description : Remt3000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgRemt3000DAO")
public class InfcPkgRemt3000DAO extends EgovAbstractDAO {

	/**
	 * REMT3000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt3000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt3000(InfcPkgRemt3000VO vo) throws Exception {
        return (String)insert("infcPkgRemt3000DAO.insertRemt3000_S", vo);
    }

    /**
	 * REMT3000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt3000VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt3000(InfcPkgRemt3000VO vo) throws Exception {
        update("infcPkgRemt3000DAO.updateRemt3000_S", vo);
    }

    /**
	 * REMT3000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt3000VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt3000(InfcPkgRemt3000VO vo) throws Exception {
        delete("infcPkgRemt3000DAO.deleteRemt3000_S", vo);
    }

    /**
	 * REMT3000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt3000VO
	 * @return 조회한 REMT3000
	 * @exception Exception
	 */
    public InfcPkgRemt3000VO selectRemt3000(InfcPkgRemt3000VO vo) throws Exception {
        return (InfcPkgRemt3000VO) selectByPk("infcPkgRemt3000DAO.selectRemt3000_S", vo);
    }

    /**
	 * REMT3000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT3000 목록
	 * @exception Exception
	 */
    public List<?> selectRemt3000List(InfcPkgRemt3000SrhVO searchVO) throws Exception {
        return list("infcPkgRemt3000DAO.selectRemt3000List_D", searchVO);
    }

    /**
	 * REMT3000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT3000 총 갯수
	 * @exception
	 */
    public int selectRemt3000ListTotCnt(InfcPkgRemt3000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgRemt3000DAO.selectRemt3000ListTotCnt_S", searchVO);
    }

}
