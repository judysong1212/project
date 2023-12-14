package com.app.smrmf.syscom.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.sysm.server.service.vo.Cmmn0320SrhVO;
import com.app.smrmf.sysm.server.service.vo.Cmmn0320VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Cmmn0320DAO.java
 * @Description : Cmmn0320 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("SysComCmmn0320DAO")
public class SysComCmmn0320DAO extends EgovAbstractDAO {

	/**
	 * CMMN0320을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Cmmn0320VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertCmmn0320(Cmmn0320VO vo) throws Exception {
        return (String)insert("msfCmmn0320DAO.insertCmmn0320_S", vo);
    }

    /**
	 * CMMN0320을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Cmmn0320VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updateCmmn0320(Cmmn0320VO vo) throws Exception {
        update("msfCmmn0320DAO.updateCmmn0320_S", vo);
    }

    /**
	 * CMMN0320을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Cmmn0320VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deleteCmmn0320(Cmmn0320VO vo) throws Exception {
        delete("msfCmmn0320DAO.deleteCmmn0320_S", vo);
    }

    /**
	 * CMMN0320을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Cmmn0320VO
	 * @return 조회한 CMMN0320
	 * @exception Exception
	 */
    public Cmmn0320VO selectCmmn0320(Cmmn0320VO vo) throws Exception {
        return (Cmmn0320VO) selectByPk("msfCmmn0320DAO.selectCmmn0320_S", vo);
    }

    /**
	 * CMMN0320 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return CMMN0320 목록
	 * @exception Exception
	 */
    public List selectCmmn0320List(Cmmn0320SrhVO searchVO) throws Exception {
        return list("msfCmmn0320DAO.selectCmmn0320List_D", searchVO);
    }

    /**
	 * CMMN0320 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return CMMN0320 총 갯수
	 * @exception
	 */
    public int selectCmmn0320ListTotCnt(Cmmn0320SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("msfCmmn0320DAO.selectCmmn0320ListTotCnt_S", searchVO);
    }
    
    /**
     * CMMN0320 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return CMMN0320 목록
     * @exception Exception
     */
    public List selectCmmn0320RoadNmCtapvList(Cmmn0320SrhVO searchVO) throws Exception {
        return list("msfCmmn0320DAO.selectCmmn0320RoadNmCtapvList_D", searchVO);
    }
    
    /**
     * CMMN0320 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return CMMN0320 목록
     * @exception Exception
     */
    public List selectCmmn0320RoadNmCtatguList(Cmmn0320SrhVO searchVO) throws Exception {
        return list("msfCmmn0320DAO.selectCmmn0320RoadNmCtatguList_D", searchVO);
    }
    
    
}
