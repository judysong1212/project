package com.app.exterms.yearendtax.server.service.yeta2016.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.yearendtax.server.vo.Pyyt0302SrhVO;
import com.app.exterms.yearendtax.server.vo.Pyyt0302VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : ye17TaPyyt0302DAO.java
 * @Description : Pyyt0302 DAO Class
 * @Modification Information
 *
 * @author BaeDaEun
 * @since 2016.12.20
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Pyyt0302DAO")
public class Pyyt0302DAO extends EgovAbstractDAO {
	
	
	
    /**
	 * PYYT0302 목록을 조회한다.
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return PYYT0302 목록
	 * @exception Exception
	 */
    public List selectPyyt0302List(Pyyt0302SrhVO searchVO) throws Exception {
        return list("pyyt0302DAO.selectPyyt0302List_D", searchVO);
    }
    
    
    /**
	 * PSNL0100 목록을 조회한다. 인사정보를 가져온다.
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return PYYT0302 목록
	 * @exception Exception
	 */
    public List selectPyyt0302ToPsnl0100List(Pyyt0302VO vo) throws Exception {
        return list("pyyt0302DAO.selectPsnl0100", vo);
    }

    /**
	 * PYYT0302 총 갯수를 조회한다.
	 * @param searcVO - 조회할 정보가 담긴 searcVO
	 * @return PYYT0302  총 갯수
	 * @exception
	 */
    public int selectPyyt0302ListTotCnt(Pyyt0302SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("pyyt0302DAO.selectPyyt0302ListTotCnt_S", searchVO);
    }	
	
	
	
	

	/**
	 * PYYT0302을 등록한다.
	 * @param vo - 등록 정보가 담긴 Pyyt0302VO
	 * @return ?�록 결과
	 * @exception Exception
	 */
    public String insertPyyt0302(Pyyt0302VO vo) throws Exception {
        return (String)insert("pyyt0302DAO.insertPyyt0302_S", vo);
    }

    /**
	 * PYYT0302 수정한다.
	 * @param vo - 수정할 정보가 담긴 Pyyt0302VO
	 * @return void??
	 * @exception Exception
	 */
    public void updatePyyt0302(Pyyt0302VO vo) throws Exception {
        update("pyyt0302DAO.updatePyyt0302_S", vo);
    }
//
    /**
	 * PYYT0302을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Pyyt0302VO
	 * @return void??
	 * @exception Exception
	 */
    public void deletePyyt0302(Pyyt0302VO vo) throws Exception {
        delete("pyyt0302DAO.deletePyyt0302_S", vo);
    }
    
    
    /**
	 * PYYT0302을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Pyyt0302VO
	 * @return void??
	 * @exception Exception
	 */
    public void deletePyyt0302_D(Pyyt0302VO vo) throws Exception {
        delete("pyyt0302DAO.deletePyyt0302", vo);
    }
//
//    /**
//	 * PYYT0302??조회?�다.
//	 * @param vo - 조회???�보�??�긴 Pyyt0302VO
//	 * @return 조회??PYYT0302
//	 * @exception Exception
//	 */
//    public Pyyt0302VO selectPyyt0302(Pyyt0302VO vo) throws Exception {
//        return (Pyyt0302VO) select("ye17TaPyyt0302DAO.selectPyyt0302_S", vo);
//    }
//
//    /**
//	 * PYYT0302 목록??조회?�다.
//	 * @param searchMap - 조회???�보�??�긴 Map
//	 * @return PYYT0302 목록
//	 * @exception Exception
//	 */
//    public List<?> selectPyyt0302List(Pyyt0302SrhVO searchVO) throws Exception {
//        return list("ye17TaPyyt0302DAO.selectPyyt0302List_D", searchVO);
//    }
//
//    /**
//	 * PYYT0302 �?�?���?조회?�다.
//	 * @param searchMap - 조회???�보�??�긴 Map
//	 * @return PYYT0302 �?�?��
//	 * @exception
//	 */
//    public int selectPyyt0302ListTotCnt(Pyyt0302SrhVO searchVO) {
//        return (Integer)select("ye17TaPyyt0302DAO.selectPyyt0302ListTotCnt_S", searchVO);
//    }

}
