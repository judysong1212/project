package com.app.smrmf.syscom.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.service.vo.SysMstr060100SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysMstr060100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : SysMstr060100DAO.java
 * @Description : SysMstr060100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysMstr060100DAO")
public class SysMstr060100DAO extends EgovAbstractDAO {

	/**
	 * MSTR_06_0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SysMstr060100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertSysMstr060100(SysMstr060100VO vo) throws Exception {
        return (String)insert("mstr060100DAO.insertSysMstr060100_S", vo);
    }

    /**
	 * MSTR_06_0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SysMstr060100VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateSysMstr060100(SysMstr060100VO vo) throws Exception {
        update("mstr060100DAO.updateSysMstr060100_S", vo);
    }

    /**
	 * MSTR_06_0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SysMstr060100VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteSysMstr060100(SysMstr060100VO vo) throws Exception {
        delete("mstr060100DAO.deleteSysMstr060100_S", vo);
    }

    /**
	 * MSTR_06_0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SysMstr060100VO
	 * @return 조회한 MSTR_06_0100
	 * @exception Exception
	 */
    public SysMstr060100VO selectSysMstr060100(SysMstr060100VO vo) throws Exception {
        return (SysMstr060100VO) selectByPk("mstr060100DAO.selectSysMstr060100_S", vo);
    }

    /**
	 * MSTR_06_0100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return MSTR_06_0100 목록
	 * @exception Exception
	 */
    public List selectSysMstr060100List(SysMstr060100SrhVO searchVO) throws Exception {
        return list("mstr060100DAO.selectSysMstr060100List_D", searchVO);
    }

    /**
	 * MSTR_06_0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return MSTR_06_0100 총 갯수
	 * @exception
	 */
    public int selectSysMstr060100ListTotCnt(SysMstr060100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("mstr060100DAO.selectSysMstr060100ListTotCnt_S", searchVO);
    }

}
