package com.app.smrmf.infc.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2000SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt2000DAO.java
 * @Description : Remt2000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.23
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgRemt2000DAO")
public class InfcPkgRemt2000DAO extends EgovAbstractDAO {

	/**
	 * REMT2000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt2000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertRemt2000(InfcPkgRemt2000VO vo) throws Exception {
        return (String)insert("infcPkgRemt2000DAO.insertRemt2000_S", vo);
    }

    /**
	 * REMT2000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt2000VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateRemt2000(InfcPkgRemt2000VO vo) throws Exception {
        update("infcPkgRemt2000DAO.updateRemt2000_S", vo);
    }

    /**
	 * REMT2000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt2000VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteRemt2000(InfcPkgRemt2000VO vo) throws Exception {
        delete("infcPkgRemt2000DAO.deleteRemt2000_S", vo);
    }

    /**
	 * REMT2000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt2000VO
	 * @return 조회한 REMT2000
	 * @exception Exception
	 */
    public InfcPkgRemt2000VO selectRemt2000(InfcPkgRemt2000VO vo) throws Exception {
        return (InfcPkgRemt2000VO) selectByPk("infcPkgRemt2000DAO.selectRemt2000_S", vo);
    }
   
    /**
	 * REMT2000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2000 목록
	 * @exception Exception
	 */
    public List<?> selectRemt2000List(InfcPkgRemt2000SrhVO searchVO) throws Exception {
        return list("infcPkgRemt2000DAO.selectRemt2000List_D", searchVO);
    }

    /**
	 * REMT2000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return REMT2000 총 갯수
	 * @exception
	 */
    public int selectRemt2000ListTotCnt(InfcPkgRemt2000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgRemt2000DAO.selectRemt2000ListTotCnt_S", searchVO);
    }
   
    /**
 	 * REMT2000 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return REMT2000 목록
 	 * @exception Exception
 	 */
     public List<?> selectDateTermList(InfcPkgRemt2000VO infcPkgRemt2000Vo)  throws Exception {
         return list("infcPkgRemt2000DAO.selectDateTermList_D", infcPkgRemt2000Vo);
     }
     
     
	/**
 	 * REMT2000 총 갯수를 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return REMT2000 총 갯수
 	 */
     public int selectPsnl0100ToRemt0100ListTotCnt(InfcPkgRemt2000SrhVO searchVO) {
		return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgRemt2000DAO.selectPsnl0100ToRemt0100ListTotCnt_S", searchVO);
     }
     
     /**
      * REMT2000 목록을 조회한다.
      * @param searchMap - 조회할 정보가 담긴 Map
      * @return REMT2000 목록
      * @exception Exception
      */
     public List<?> selectPsnl0100ToRemt0100List(InfcPkgRemt2000SrhVO searchVO) throws Exception {
    	 return list("infcPkgRemt2000DAO.selectPsnl0100ToRemt0100List_D", searchVO);
     }
     
     
     /**
 	 * 퇴직금지급내역조회
 	 * REMT2000 총 갯수를 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return REMT2000 총 갯수
 	 * @exception
 	 */
     public int selectRemtPymt0100ToRemt2000ListTotCnt(InfcPkgRemt2000SrhVO searchVO) {
         return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgRemt2000DAO.selectRemtPymt0100ToRemt2000ListTotCnt_S", searchVO);
     }
     
     
     /**
 	 * 퇴직금 지급내역조회
 	 * REMT2000 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return REMT2000 목록
 	 * @exception Exception
 	 */
     public List<?> selectRemtPymt0100ToRemt2000List(InfcPkgRemt2000SrhVO searchVO) throws Exception {
         return list("infcPkgRemt2000DAO.selectRemtPymt0100ToRemt2000List_D", searchVO);
     }
     
     
     /**
 	 * 퇴직금산정 결과 조회 
 	 * REMT2000 총 갯수를 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return REMT2000 총 갯수
 	 * @exception
 	 */
     public int selectRemt0150ToRemt2000ListTotCnt(InfcPkgRemt2000SrhVO searchVO) {
         return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgRemt2000DAO.selectRemt0150ToRemt2000ListTotCnt_S", searchVO);
     }
     
     
     /**
   	 * 퇴직금산정 결과 조회 
   	 * REMT2000 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return REMT2000 목록
   	 * @exception Exception
   	 */
       public List<?> selectRemt0150ToRemt2000List(InfcPkgRemt2000SrhVO searchVO) throws Exception {
           return list("infcPkgRemt2000DAO.selectRemt0150ToRemt2000List_D", searchVO);
       }
     
}
