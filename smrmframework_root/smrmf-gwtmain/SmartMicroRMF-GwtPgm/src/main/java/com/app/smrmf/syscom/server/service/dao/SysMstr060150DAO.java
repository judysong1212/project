package com.app.smrmf.syscom.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.service.vo.SysMstr060150SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysMstr060150VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : SysMstr060150DAO.java
 * @Description : SysMstr060150 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysMstr060150DAO")
public class SysMstr060150DAO extends EgovAbstractDAO {

	/**
	 * MSTR_06_0150을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SysMstr060150VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertSysMstr060150(SysMstr060150VO vo) throws Exception {
        return (String)insert("mstr060150DAO.insertSysMstr060150_S", vo);
    }

    /**
	 * MSTR_06_0150을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SysMstr060150VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateSysMstr060150(SysMstr060150VO vo) throws Exception {
        update("mstr060150DAO.updateSysMstr060150_S", vo);
    }

    /**
	 * MSTR_06_0150을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SysMstr060150VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteSysMstr060150(SysMstr060150VO vo) throws Exception {
        delete("mstr060150DAO.deleteSysMstr060150_S", vo);
    }

    /**
	 * MSTR_06_0150을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SysMstr060150VO
	 * @return 조회한 MSTR_06_0150
	 * @exception Exception
	 */
    public SysMstr060150VO selectSysMstr060150(SysMstr060150VO vo) throws Exception {
        return (SysMstr060150VO) selectByPk("mstr060150DAO.selectSysMstr060150_S", vo);
    }

    /**
	 * MSTR_06_0150 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return MSTR_06_0150 목록
	 * @exception Exception
	 */
    public List selectSysMstr060150List(SysMstr060150SrhVO searchVO) throws Exception {
        return list("mstr060150DAO.selectSysMstr060150List_D", searchVO);
    }

    /**
	 * MSTR_06_0150 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return MSTR_06_0150 총 갯수
	 * @exception
	 */
    public int selectSysMstr060150ListTotCnt(SysMstr060150SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("mstr060150DAO.selectSysMstr060150ListTotCnt_S", searchVO);
    }

}
