package com.app.smrmf.infc.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2400SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2400VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt2400DAO.java
 * @Description : Remt2400 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgRemt2400DAO")
public class InfcPkgRemt2400DAO extends EgovAbstractDAO {

	/**
	 * REMT2400을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt2400VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt2400(InfcPkgRemt2400VO vo) throws Exception {
        return (String)insert("infcPkgRemt2400DAO.insertRemt2400_S", vo);
    }

    /**
	 * REMT2400을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt2400VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt2400(InfcPkgRemt2400VO vo) throws Exception {
        update("infcPkgRemt2400DAO.updateRemt2400_S", vo);
    }

    /**
	 * REMT2400을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt2400VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt2400(InfcPkgRemt2400VO vo) throws Exception {
        delete("infcPkgRemt2400DAO.deleteRemt2400_S", vo);
    }

    /**
	 * REMT2400을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt2400VO
	 * @return 조회한 REMT2400
	 * @exception Exception
	 */
    public InfcPkgRemt2400VO selectRemt2400(InfcPkgRemt2400VO vo) throws Exception {
        return (InfcPkgRemt2400VO) selectByPk("infcPkgRemt2400DAO.selectRemt2400_S", vo);
    }

    /**
	 * REMT2400 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2400 목록
	 * @exception Exception
	 */
    public List<?> selectRemt2400List(InfcPkgRemt2400SrhVO searchVO) throws Exception {
        return list("infcPkgRemt2400DAO.selectRemt2400List_D", searchVO);
    }

    /**
	 * REMT2400 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2400 총 갯수
	 * @exception
	 */
    public int selectRemt2400ListTotCnt(InfcPkgRemt2400SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgRemt2400DAO.selectRemt2400ListTotCnt_S", searchVO);
    }

}
