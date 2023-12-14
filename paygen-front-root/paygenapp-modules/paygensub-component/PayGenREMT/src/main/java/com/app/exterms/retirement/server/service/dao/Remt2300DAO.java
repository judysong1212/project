package com.app.exterms.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.retirement.server.vo.Remt2300SrhVO;
import com.app.exterms.retirement.server.vo.Remt2300VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt2300DAO.java
 * @Description : Remt2300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Remt2300DAO")
public class Remt2300DAO extends EgovAbstractDAO {

	/**
	 * REMT2300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt2300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt2300(Remt2300VO vo) throws Exception {
        return (String)insert("remt2300DAO.insertRemt2300_S", vo);
    }

    /**
	 * REMT2300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt2300VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt2300(Remt2300VO vo) throws Exception {
        update("remt2300DAO.updateRemt2300_S", vo);
    }

    /**
	 * REMT2300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt2300VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt2300(Remt2300VO vo) throws Exception {
        delete("remt2300DAO.deleteRemt2300_S", vo);
    }

    public void deleteItemToRemt2300(Remt2300VO vo) throws Exception {
        delete("remt2300DAO.deleteItemToRemt2300_S", vo);
    } 
    
    
    /**
	 * REMT2300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt2300VO
	 * @return 조회한 REMT2300
	 * @exception Exception
	 */
    public Remt2300VO selectRemt2300(Remt2300VO vo) throws Exception {
        return (Remt2300VO) selectByPk("remt2300DAO.selectRemt2300_S", vo);
    }

    /**
	 * REMT2300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2300 목록
	 * @exception Exception
	 */
    public List<?> selectRemt2300List(Remt2300SrhVO searchVO) throws Exception {
        return list("remt2300DAO.selectRemt2300List_D", searchVO);
    }

    /**
	 * REMT2300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2300 총 갯수
	 * @exception
	 */
    public int selectRemt2300ListTotCnt(Remt2300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("remt2300DAO.selectRemt2300ListTotCnt_S", searchVO);
    }
    
    /**
	 * 퇴직금공제내역을조회 REMT2300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2300 목록
	 * @exception Exception
	 */
    public List<?> selectRemt0100ToRemt2300List(Remt2300SrhVO searchVO) throws Exception {
        return list("remt2300DAO.selectRemt0100ToRemt2300List_D", searchVO);
    }

    /**
	 * 퇴직금공제내역을조회 REMT2300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2300 총 갯수
	 * @exception
	 */
    public int selectRemt0100ToRemt2300ListTotCnt(Remt2300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("remt2300DAO.selectRemt0100ToRemt2300ListTotCnt_S", searchVO);
    }
    
    
    

}
