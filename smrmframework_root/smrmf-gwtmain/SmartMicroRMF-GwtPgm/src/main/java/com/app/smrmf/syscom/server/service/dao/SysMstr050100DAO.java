package com.app.smrmf.syscom.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.service.vo.SysMstr050100SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysMstr050100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : SysMstr050100DAO.java
 * @Description : SysMstr050100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysMstr050100DAO")
public class SysMstr050100DAO extends EgovAbstractDAO {

	/**
	 * MSTR_05_0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SysMstr050100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertSysMstr050100(SysMstr050100VO vo) throws Exception {
        return (String)insert("mstr050100DAO.insertSysMstr050100_S", vo);
    }

    /**
	 * MSTR_05_0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SysMstr050100VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateSysMstr050100(SysMstr050100VO vo) throws Exception {
        update("mstr050100DAO.updateSysMstr050100_S", vo);
    }

    /**
	 * MSTR_05_0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SysMstr050100VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteSysMstr050100(SysMstr050100VO vo) throws Exception {
        delete("mstr050100DAO.deleteSysMstr050100_S", vo);
    }

    /**
	 * MSTR_05_0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SysMstr050100VO
	 * @return 조회한 MSTR_05_0100
	 * @exception Exception
	 */
    public SysMstr050100VO selectSysMstr050100(SysMstr050100VO vo) throws Exception {
        return (SysMstr050100VO) selectByPk("mstr050100DAO.selectSysMstr050100_S", vo);
    }

    /**
	 * MSTR_05_0100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return MSTR_05_0100 목록
	 * @exception Exception
	 */
    public List selectSysMstr050100List(SysMstr050100SrhVO searchVO) throws Exception {
        return list("mstr050100DAO.selectSysMstr050100List_D", searchVO);
    }

    /**
	 * MSTR_05_0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return MSTR_05_0100 총 갯수
	 * @exception
	 */
    public int selectSysMstr050100ListTotCnt(SysMstr050100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("mstr050100DAO.selectSysMstr050100ListTotCnt_S", searchVO);
    }

}
