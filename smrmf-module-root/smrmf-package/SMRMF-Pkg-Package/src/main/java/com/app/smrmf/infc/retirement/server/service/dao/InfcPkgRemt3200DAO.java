package com.app.smrmf.infc.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3200SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt3200DAO.java
 * @Description : Remt3200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgRemt3200DAO")
public class InfcPkgRemt3200DAO extends EgovAbstractDAO {

	/**
	 * REMT3200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt3200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt3200(InfcPkgRemt3200VO vo) throws Exception {
        return (String)insert("infcPkgRemt3200DAO.insertRemt3200_S", vo);
    }

    /**
	 * REMT3200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt3200VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt3200(InfcPkgRemt3200VO vo) throws Exception {
        update("infcPkgRemt3200DAO.updateRemt3200_S", vo);
    }

    /**
	 * REMT3200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt3200VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt3200(InfcPkgRemt3200VO vo) throws Exception {
        delete("infcPkgRemt3200DAO.deleteRemt3200_S", vo);
    }

    /**
	 * REMT3200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt3200VO
	 * @return 조회한 REMT3200
	 * @exception Exception
	 */
    public InfcPkgRemt3200VO selectRemt3200(InfcPkgRemt3200VO vo) throws Exception {
        return (InfcPkgRemt3200VO) selectByPk("infcPkgRemt3200DAO.selectRemt3200_S", vo);
    }

    /**
	 * REMT3200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT3200 목록
	 * @exception Exception
	 */
    public List<?> selectRemt3200List(InfcPkgRemt3200SrhVO searchVO) throws Exception {
        return list("infcPkgRemt3200DAO.selectRemt3200List_D", searchVO);
    }

    /**
	 * REMT3200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT3200 총 갯수
	 * @exception
	 */
    public int selectRemt3200ListTotCnt(InfcPkgRemt3200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgRemt3200DAO.selectRemt3200ListTotCnt_S", searchVO);
    }
    
    public int selectMarTotAmntDays(InfcPkgRemt3200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgRemt3200DAO.selectRemt3200ListTotCnt_S", searchVO);
    }
    
    

}
