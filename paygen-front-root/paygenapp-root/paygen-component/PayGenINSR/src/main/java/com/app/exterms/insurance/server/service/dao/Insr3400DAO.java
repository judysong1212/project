package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr3400SrhVO;
import com.app.exterms.insurance.server.vo.Insr3400VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : Insr3400DAO.java
 * @Description : Insr3400 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr3400DAO")
public class Insr3400DAO extends EgovAbstractDAO {
	
	/**
	 * PSNL0100을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0100 목록
	 * @exception Exception
	 */
	public List<?> selectPsnl0100List(Insr3400SrhVO searchVO) throws Exception {
		return list("insr3400DAO.selectPsnl0100List", searchVO);
	}
	
	
	/**
	 * PSNL0100을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PSNL0100 목록
	 * @exception Exception
	 */
	public EgovMap selectPsnl0110List(Insr3400VO insr3400Vo) throws Exception {
		return (EgovMap) selectByPk("insr3400DAO.selectPsnl0110List", insr3400Vo);
	}
    
	/**
	 * INSR3400을 등록한다. - (재)정산
	 * @param vo - 등록할 정보가 담긴 Insr3400VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public void insertInsr3400(Insr3400VO vo) throws Exception {
        insert("insr3400DAO.insertInsr3400", vo);
    }
    
    /**
	 * INSR3400을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr3400VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr3400(Insr3400VO vo) throws Exception {
        update("insr3400DAO.updateInsr3400_S", vo);
    }

    /**
	 * INSR3400을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr3400VO
	 * @return 조회한 INSR3400
	 * @exception Exception
	 */
    public Insr3400VO selectInsr3400(Insr3400VO vo) throws Exception {
        return (Insr3400VO) selectByPk("insr3400DAO.selectInsr3400_S", vo);
    }

    /**
	 * INSR3400 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3400 목록
	 * @exception Exception
	 */
    public List<?> selectInsr3400List(Insr3400SrhVO searchVO) throws Exception {
        return list("insr3400DAO.selectInsr3400List_D", searchVO);
    }

    /**
	 * INSR3400 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3400 총 갯수
	 * @exception
	 */
    public int selectInsr3400ListTotCnt(Insr3400SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr3400DAO.selectInsr3400ListTotCnt_S", searchVO);
    }
    
    /**
     * INSR3400을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Insr3400SrhVO
     * @return void형
     * @exception Exception
     */
    public void deleteInsr3400(Insr3400SrhVO searchVO) throws Exception {
    	delete("insr3400DAO.deleteInsr3400", searchVO);
    }
    
    /**
     * INSR3400을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Insr3400SrhVO
     * @return void형
     * @exception Exception
     */
    public void deleteInsr3400_S(Insr3400VO searchVO) throws Exception {
    	delete("insr3400DAO.deleteInsr3400_S", searchVO);
    }
    
    /**
	 * 엑셀저장 insr4300  화면 엑셀저장 INSR3400 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3400 목록
	 * @exception Exception
	 */
	public List selectXlsInsr3400List(Insr3400SrhVO searchVO) throws Exception {
		return list("insr3400DAO.selectXlsInsr3400List", searchVO);
	}
	
	/**
	 * 정산산출내역 INSR3400 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3400 총 갯수
	 * @exception
	 */
	public int selectInsrP430001ToInsr3400ListTotCnt(Insr3400SrhVO insr3400SrhVo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("insr3400DAO.selectInsrP430001ToInsr3400ListTotCnt", insr3400SrhVo);
	}
	
	/**
	 * INSR3400 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3400 목록
	 * @exception Exception
	 */
	public List<?> selectInsrP430001ToInsr3400List(Insr3400SrhVO insr3400SrhVo) {
		return list("insr3400DAO.selectInsrP430001ToInsr3400List", insr3400SrhVo);
	}
}