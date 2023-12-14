package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr1100SrhVO;
import com.app.exterms.insurance.server.vo.Insr1100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr1100DAO.java
 * @Description : Insr1100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.12
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr1100DAO")
public class Insr1100DAO extends EgovAbstractDAO {
 
	/**
	 * INSR1100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr1100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr1100(Insr1100VO vo) throws Exception {
        return (String)insert("insr1100DAO.insertInsr1100_S", vo);
    }

    /**
	 * INSR1100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr1100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr1100(Insr1100VO vo) throws Exception {
        update("insr1100DAO.updateInsr1100_S", vo);
    }
    
    /**
	 * INSR1100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr1100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateXlsInsr1100(Insr1100VO vo) throws Exception {
        update("insr1100DAO.updateXlsInsr1100_S", vo);
    }
    
    /**
	 * INSR1100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr1100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateXlsInsr1100Each(Insr1100VO vo) throws Exception {
        update("insr1100DAO.updateXlsInsr1100Each_S", vo);
    }
    
    /**
	 * insr2100 화면에서 일부 사항만 업데이트 한다. INSR1100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr1100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr2100ToInsr1100(Insr1100VO vo) throws Exception {
        update("insr1100DAO.updateInsr2100ToInsr1100_S", vo);
    }
    

    /**
	 * INSR1100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr1100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr1100(Insr1100VO vo) throws Exception {
        delete("insr1100DAO.deleteInsr1100_S", vo);
    }

    /**
	 * INSR1100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr1100VO
	 * @return 조회한 INSR1100
	 * @exception Exception
	 */
    public Insr1100VO selectInsr1100(Insr1100VO vo) throws Exception {
        return (Insr1100VO) selectByPk("insr1100DAO.selectInsr1100_S", vo);
    }

    /**
	 * INSR1100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR1100 목록
	 * @exception Exception
	 */
    public List<?> selectInsr1100List(Insr1100SrhVO searchVO) throws Exception {
        return list("insr1100DAO.selectInsr1100List_D", searchVO);
    }

    /**
	 * INSR1100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR1100 총 갯수
	 * @exception
	 */
    public int selectInsr1100ListTotCnt(Insr1100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr1100DAO.selectInsr1100ListTotCnt_S", searchVO);
    }


    /**
	 * 4대보험 취득신고 INSR1100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR1100 목록
	 * @exception Exception
	 */
	public List<?> selectInsr2100ToInsr1100List(Insr1100SrhVO searchVO) throws Exception {
        return list("insr1100DAO.selectInsr2100ToInsr1100List_D", searchVO);
    }

	 /**
		 * 4대보험 취득신고 INSR1100 목록을 조회한다.
		 * @param searchMap - 조회할 정보가 담긴 Map
		 * @return INSR1100 목록
		 * @exception Exception
		 */
		public List<?> selectInsr2150ToInsr1100List(Insr1100SrhVO searchVO) throws Exception {
	        return list("insr1100DAO.selectInsr2150ToInsr1100List_D", searchVO);
	    }
	
    /**
	 * 4대보험 취득신고 INSR1100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR1100 총 갯수
	 * @exception
	 */
    public int selectInsr2100ToInsr1100ListTotCnt(Insr1100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr1100DAO.selectInsr2100ToInsr1100ListTotCnt_S", searchVO);
    }
     
    
    /**
	 * 4대보험 취득신고 INSR1100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR1100 총 갯수
	 * @exception
	 */
    public int selectInsr2150ToInsr1100ListTotCnt(Insr1100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr1100DAO.selectInsr2150ToInsr1100ListTotCnt_S", searchVO);
    }
     
    
}
