package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr3300SrhVO;
import com.app.exterms.insurance.server.vo.Insr3300VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr3300DAO.java
 * @Description : Insr3300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr3300DAO")
public class Insr3300DAO extends EgovAbstractDAO {

	/**
	 * INSR3300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr3300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr3300(Insr3300VO vo) throws Exception {
        return (String)insert("insr3300DAO.insertInsr3300_S", vo);
    }

    /**
	 * INSR3300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr3300VO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePayRflctnInsr3300(Insr3300VO vo) throws Exception {
        update("insr3300DAO.updatePayRflctnInsr3300", vo);
    }
    
    /**
	 * INSR3300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr3300VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr3300(Insr3300VO vo) throws Exception {
        delete("insr3300DAO.deleteInsr3300_S", vo);
    }

    /**
	 * INSR3300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr3300VO
	 * @return 조회한 INSR3300
	 * @exception Exception
	 */
    public Insr3300VO selectInsr3300(Insr3300VO vo) throws Exception {
        return (Insr3300VO) selectByPk("insr3300DAO.selectInsr3300_S", vo);
    }

    /**
	 * INSR3300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3300 목록
	 * @exception Exception
	 */
    public List<?> selectInsr3300List(Insr3300SrhVO searchVO) throws Exception {
        return list("insr3300DAO.selectInsr3300List_D", searchVO);
    }

    /**
	 * INSR3300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3300 총 갯수
	 * @exception
	 */
	public int selectInsr3300ListTotCnt(Insr3300SrhVO searchVO) {
		return (Integer)getSqlMapClientTemplate().queryForObject("insr3300DAO.selectInsr3300ListTotCnt_S", searchVO);
	}
	
  	/**
  	 * 당월 급여마감여부 체크한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return INSR3200 총 갯수
  	 * @exception
  	 */
  	public int selectPayCloseChkCnt(Insr3300VO vo) {
  		return (Integer)getSqlMapClientTemplate().queryForObject("insr3300DAO.selectPayCloseChkCnt", vo);
  	}
	

/**************************** 엑셀 업로드 ****************************/
/**
 * INSR3200을 삭제한다.(엑셀)
 * @param vo - 삭제할 정보가 담긴 Insr3200VO
 * @return void형
 * @exception Exception
 */
	public void deleteXlsInsr3300(Insr3300VO vo) throws Exception {
		delete("insr3300DAO.deleteXlsInsr3300", vo);
	}

/**
 * INSR3300을 등록한다.(엑셀)
 * @param vo - 등록할 정보가 담긴 Insr3200VO
 * @return 등록 결과
 * @exception Exception
 */
	public String insertXlsInsr3300(Insr3300VO vo) throws Exception {
		return (String)insert("insr3300DAO.insertXlsInsr3300", vo);
	}
	
	

	    
/**************************** 엑셀 업로드 ****************************/    
}