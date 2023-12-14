package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0302VO;
import com.app.exterms.payroll.server.vo.Payr0304SrhVO;
import com.app.exterms.payroll.server.vo.Payr0304VO;
import com.app.exterms.payroll.server.vo.Payr0307VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0304DAO.java
 * @Description : Payr0304 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr0304DAO")
public class Payr0304DAO extends EgovAbstractDAO {

	/**
	 * PAYR0304을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0304VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0304(Payr0304VO vo) throws Exception {
        return (String)insert("payr0304DAO.insertPayr0304_S", vo);
    }

    /**
	 * PAYR0304을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0304VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0304(Payr0304VO vo) throws Exception {
        update("payr0304DAO.updatePayr0304_S", vo);
    }

    /**
	 * PAYR0304을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0304VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0304(Payr0304VO vo) throws Exception {
        delete("payr0304DAO.deletePayr0304_S", vo);
    }
    
    
    //삭제처리 위해 추가 6.19 -"101"
    /*@Transactional
    public void deletePayrAll0304(Payr0304SrhVO vo) throws Exception {
        delete("payr0304DAO.deletePayrAll0304_S", vo);
    }*/

    /**
     * PAYR0304을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Payr0304VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePayCalculationPayr0304(Payr0304VO vo) throws Exception {
        delete("payr0304DAO.deletePayCalculationPayr0304_S", vo);
    }
   

    /**
	 * PAYR0304을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0304VO
	 * @return 조회한 PAYR0304
	 * @exception Exception
	 */
    public Payr0304VO selectPayr0304(Payr0304VO vo) throws Exception {
        return (Payr0304VO) selectByPk("payr0304DAO.selectPayr0304_S", vo);
    }

    /**
	 * PAYR0304 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0304 목록
	 * @exception Exception
	 */
    public List selectPayr0304List(Payr0304SrhVO searchVO) throws Exception {
        return list("payr0304DAO.selectPayr0304List_D", searchVO);
    }

    /**
	 * PAYR0304 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0304 총 갯수
	 * @exception
	 */
    public int selectPayr0304ListTotCnt(Payr0304SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0304DAO.selectPayr0304ListTotCnt_S", searchVO);
    } 

    /**
	 * PAYR0304 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0304 목록
	 * @exception Exception
	 */
    public List selectPayr0304ToPayr4200List(Payr0304SrhVO searchVO) throws Exception {
        return list("payr0304DAO.selectPayr0304ToPayr4200List_D", searchVO);
    }

    /**
	 * PAYR0304 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0304 총 갯수
	 * @exception
	 */
    public int selectPayr0304ToPayr4200ListTotCnt(Payr0304SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0304DAO.selectPayr0304ToPayr4200ListTotCnt_S", searchVO);
    }
    
    
    
    //급여내역조회 새로만듬, 전체 개수 조회 6.18 -"66"
    public int selectPayr0304ToPayr4201ListTotCnt(Payr0304SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0304DAO.selectPayr0304ToPayr4201ListTotCnt_S", searchVO);
    }
    
    //급여내역조회 새로만듬 전체 목록 조회 6.18 -"67"
    public List selectPayr0304ToPayr4201List(Payr0304SrhVO searchVO) throws Exception {
        return list("payr0304DAO.selectPayr0304ToPayr4201List_D", searchVO);
    }
    
  //일괄정리 추가9 6.19 -"128"
    //일괄정리 주석처리 6.22 -"136"
    /*public List deletePayr0304ToPayr4201List(Payr0304SrhVO searchVO) throws Exception {
        return list("payr0304DAO.deletePayr0304ToPayr4201List_D", searchVO);
    }*/
    
    
    /**
   	 * PAYR0304 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0304 목록
   	 * @exception Exception
   	 */
       public List selectPayr0304ToPayrP410001List(Payr0304SrhVO searchVO) throws Exception {
           return list("payr0304DAO.selectPayr0304ToPayrP410001List_D", searchVO);
       }

    /**
   	 * PAYR0304 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0304 총 갯수
   	 * @exception
   	 */
       public int selectPayr0304ToPayrP410001ListTotCnt(Payr0304SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("payr0304DAO.selectPayr0304ToPayrP410001ListTotCnt_S", searchVO);
       }
       
       
	/**
     * PAYR0304 목록을 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0304 목록
     * @exception Exception
     */
	public List selectPayr0304ToPayrP410002List(Payr0304SrhVO searchVO) throws Exception {
		return list("payr0304DAO.selectPayr0304ToPayrP410002List_D", searchVO);
	}

	/**
     * PAYR0304 총 갯수를 조회한다.
     * @param searchMap - 조회할 정보가 담긴 Map
     * @return PAYR0304 총 갯수
     * @exception
     */
	public int selectPayr0304ToPayrP410002ListTotCnt(Payr0304SrhVO searchVO) {
		return (Integer)getSqlMapClientTemplate().queryForObject("payr0304DAO.selectPayr0304ToPayrP410002ListTotCnt_S", searchVO);
 	}
	
	
	/**
     * 급여대상자정보 엑셀 생성(양식)
     * @param Payr0304SrhVO
     * @return
     * @throws Exception
     */
	
	/**
 		public List<Payr0304VO> selectXlsFilePayr0304ToPayr4200LList(Payr0304SrhVO searchVO) throws MSFException {
        return (List<Payr0304VO>)list("payr0304DAO.selectXlsPayr0304ToPayr4200List_F", searchVO); 
    	}
	 **/
    public List selectXlsFilePayr0304ToPayr4200LList(Payr0304SrhVO searchVO) throws MSFException {
        return list("payr0304DAO.selectXlsPayr0304ToPayr4200List_F", searchVO); 
    }
    
    
	/**
	 * Payr0304 엑실파일 업로드(삭제)
	 * @param searchMap - 삭제할 정보가 담긴 Map
	 * @exception Exception
	 */
    @Transactional
    public int deleteXlsPayr0304(Payr0307VO payr0307Vo) throws Exception{
		return delete("payr0304DAO.deleteXlsPayr0307_S",payr0307Vo);
		
	}
    
    @Transactional
    public void deletePayr0304All(Payr0304SrhVO searchVO) throws Exception {
        delete("payr0304DAO.deletePayr0304All_S", searchVO);
    }
          

}
