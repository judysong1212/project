package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0307SrhVO;
import com.app.exterms.payroll.server.vo.Payr0307VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0307DAO.java
 * @Description : Payr0307 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0307DAO")
public class Payr0307DAO extends EgovAbstractDAO {

	/**
	 * PAYR0307을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0307VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0307(Payr0307VO vo) throws Exception {
        return (String)insert("payr0307DAO.insertPayr0307_S", vo);
    }

    /**
	 * PAYR0307을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0307VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0307(Payr0307VO vo) throws Exception {
        update("payr0307DAO.updatePayr0307_S", vo);
    }

    /**
	 * PAYR0307을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0307VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0307(Payr0307VO vo) throws Exception {
        delete("payr0307DAO.deletePayr0307_S", vo);
    }

    /**
     * PAYR0307을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Payr0307VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePayCalculationPayr0307(Payr0307VO vo) throws Exception {
        delete("payr0307DAO.deletePayCalculationPayr0307_S", vo);
    }
  
    /**
	 * PAYR0307을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0307VO
	 * @return 조회한 PAYR0307
	 * @exception Exception
	 */
    public Payr0307VO selectPayr0307(Payr0307VO vo) throws Exception {
        return (Payr0307VO) selectByPk("payr0307DAO.selectPayr0307_S", vo);
    }
    
    
    public Payr0307VO selectPayr0307Max(Payr0307VO vo) throws Exception {
        return (Payr0307VO) selectByPk("payr0307DAO.selectPayr0307Max_S", vo);
    }
    
    public Payr0307VO selectPayr0307Max_2(Payr0307VO vo) throws Exception {
        return (Payr0307VO) selectByPk("payr0307DAO.selectPayr0307Max_2S", vo);
    }
    
    public List<Payr0307VO> selectPayr0307All(Payr0307VO vo) throws Exception {
        return (List<Payr0307VO>)list("payr0307DAO.selectPayr0307All_S", vo); 
    }
    
    public List selectPayr0307ToFreeCalcList(Payr0307SrhVO searchVO) throws Exception {
        return list("payr0307DAO.selectPayr0307ToFreeCalcList_D", searchVO);
    } 
    
    
    /**
	 * PSNL0100 엑셀 업로드 대상자 정보를 가져온다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0307 목록
	 * @exception Exception
	 */
    public List selectPayrP420002ToPsnl0100(Payr0307SrhVO searchVO) throws Exception {
        return list("payr0307DAO.selectPsnl0100Check", searchVO);
    } 

    /**
	 * PAYR0307 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0307 목록
	 * @exception Exception
	 */
    public List selectPayr0307List(Payr0307SrhVO searchVO) throws Exception {
        return list("payr0307DAO.selectPayr0307List_D", searchVO);
    }

    /**
	 * PAYR0307 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0307 총 갯수
	 * @exception
	 */
    public int selectPayr0307ListTotCnt(Payr0307SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0307DAO.selectPayr0307ListTotCnt_S", searchVO);
    }
	

    /**
	 * PAYR0307 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0307 목록
	 * @exception Exception
	 */
    public List selectPayr0307ToPayr4200List(Payr0307SrhVO searchVO) throws Exception {
        return list("payr0307DAO.selectPayr0307ToPayr4200List_D", searchVO);
    }

    /**
	 * PAYR0307 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0307 총 갯수
	 * @exception
	 */
    public int selectPayr0307ToPayr4200ListTotCnt(Payr0307SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0307DAO.selectPayr0307ToPayr4200ListTotCnt_S", searchVO);
    }
    

    /**
	 * PAYR0307 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0307 목록
	 * @exception Exception
	 */
    public List selectPayr0307ToPayr420001List(Payr0307SrhVO searchVO) throws Exception {
        return list("payr0307DAO.selectPayr0307ToPayr420001List_D", searchVO);
    }

    /**
	 * PAYR0307 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0307 총 갯수
	 * @exception
	 */
    public int selectPayr0307ToPayr420001ListTotCnt(Payr0307SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0307DAO.selectPayr0307ToPayr420001ListTotCnt_S", searchVO);
    }
    
	/**
	 * PAYR0307 엑셀파일 업로드(삭제)
	 * @param searchMap - 삭제할 정보가 담긴 Map
	 * @exception Exception
	 */
    @Transactional
    public int deleteXlsPayr0307(Payr0307VO payr0307Vo) throws Exception{
		return delete("payr0307DAO.deleteXlsPayr0307_S", payr0307Vo);
		
	}
    
	/**
	 * PAYR0307 엑셀파일 업로드(입력)
	 * @param searchMap - 입력할 정보가 담긴 Map
	 * @exception Exception
	 */
    @Transactional
    public String insertXlsPayr0307(Payr0307VO payr0307Vo) throws Exception{
		return (String)insert("payr0307DAO.insertXlsPayr0307_S", payr0307Vo);
		
	}
    
    

}
