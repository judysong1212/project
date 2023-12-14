package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr1400SrhVO;
import com.app.exterms.insurance.server.vo.Insr1400VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr1400DAO.java
 * @Description : Insr1400 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr1400DAO")
public class Insr1400DAO extends EgovAbstractDAO {

	/**
	 * INSR1400을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr1400VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr1400(Insr1400VO vo) throws Exception {
        return (String)insert("insr1400DAO.insertInsr1400_S", vo);
    }

    /**
	 * INSR1400을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr1400VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr1400(Insr1400VO vo) throws Exception {
        update("insr1400DAO.updateInsr1400_S", vo);
    }

    /**
	 * INSR1400을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr1400VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr1400(Insr1400VO vo) throws Exception {
        delete("insr1400DAO.deleteInsr1400_S", vo);
    }

    /**
	 * INSR1400을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr1400VO
	 * @return 조회한 INSR1400
	 * @exception Exception
	 */
    public Insr1400VO selectInsr1400(Insr1400VO vo) throws Exception {
        return (Insr1400VO) selectByPk("insr1400DAO.selectInsr1400_S", vo);
    }

    /**
	 * INSR1400 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR1400 목록
	 * @exception Exception
	 */
    public List<?> selectInsr1400List(Insr1400SrhVO searchVO) throws Exception {
        return list("insr1400DAO.selectInsr1400List_D", searchVO);
    }

    /**
	 * INSR1400 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR1400 총 갯수
	 * @exception
	 */
    public int selectInsr1400ListTotCnt(Insr1400SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr1400DAO.selectInsr1400ListTotCnt_S", searchVO);
    }
    
    
    /**
   	 * INSR1400 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR1400 목록
   	 * @exception Exception
   	 */
       public List<?> selectInsrP210001ToInsr1400List(Insr1400SrhVO searchVO) throws Exception {
           return list("insr1400DAO.selectInsrP210001ToInsr1400List_D", searchVO);
       }

       /**
   	 * INSR1400 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR1400 총 갯수
   	 * @exception
   	 */
       public int selectInsrP210001ToInsr1400ListTotCnt(Insr1400SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("insr1400DAO.selectInsrP210001ToInsr1400ListTotCnt_S", searchVO);
       }


    
    
    
}
