package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0304SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0304VO;

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

@Repository("InfcPkgPayr0304DAO")
public class InfcPkgPayr0304DAO extends EgovAbstractDAO {

	/**
	 * PAYR0304을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0304VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0304(InfcPkgPayr0304VO vo) throws Exception {
        return (String)insert("infcPkgPayr0304DAO.insertPayr0304_S", vo);
    }

    /**
	 * PAYR0304을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0304VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0304(InfcPkgPayr0304VO vo) throws Exception {
        update("infcPkgPayr0304DAO.updatePayr0304_S", vo);
    }

    /**
	 * PAYR0304을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0304VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayr0304(InfcPkgPayr0304VO vo) throws Exception {
        delete("infcPkgPayr0304DAO.deletePayr0304_S", vo);
    }

    /**
     * PAYR0304을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Payr0304VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePayCalculationPayr0304(InfcPkgPayr0304VO vo) throws Exception {
        delete("infcPkgPayr0304DAO.deletePayCalculationPayr0304_S", vo);
    }
   

    /**
	 * PAYR0304을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0304VO
	 * @return 조회한 PAYR0304
	 * @exception Exception
	 */
    public InfcPkgPayr0304VO selectPayr0304(InfcPkgPayr0304VO vo) throws Exception {
        return (InfcPkgPayr0304VO) selectByPk("infcPkgPayr0304DAO.selectPayr0304_S", vo);
    }

    /**
	 * PAYR0304 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0304 목록
	 * @exception Exception
	 */
    public List selectPayr0304List(InfcPkgPayr0304SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0304DAO.selectPayr0304List_D", searchVO);
    }

    /**
	 * PAYR0304 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0304 총 갯수
	 * @exception
	 */
    public int selectPayr0304ListTotCnt(InfcPkgPayr0304SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0304DAO.selectPayr0304ListTotCnt_S", searchVO);
    } 

    /**
	 * PAYR0304 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0304 목록
	 * @exception Exception
	 */
    public List selectPayr0304ToPayr4200List(InfcPkgPayr0304SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0304DAO.selectPayr0304ToPayr4200List_D", searchVO);
    }

    /**
	 * PAYR0304 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0304 총 갯수
	 * @exception
	 */
    public int selectPayr0304ToPayr4200ListTotCnt(InfcPkgPayr0304SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0304DAO.selectPayr0304ToPayr4200ListTotCnt_S", searchVO);
    }
    
    /**
   	 * PAYR0304 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0304 목록
   	 * @exception Exception
   	 */
       public List selectPayr0304ToPayrP410001List(InfcPkgPayr0304SrhVO searchVO) throws Exception {
           return list("infcPkgPayr0304DAO.selectPayr0304ToPayrP410001List_D", searchVO);
       }

       /**
   	 * PAYR0304 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0304 총 갯수
   	 * @exception
   	 */
       public int selectPayr0304ToPayrP410001ListTotCnt(InfcPkgPayr0304SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0304DAO.selectPayr0304ToPayrP410001ListTotCnt_S", searchVO);
       }
       
       
       /**
      	 * PAYR0304 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0304 목록
      	 * @exception Exception
      	 */
          public List selectPayr0304ToPayrP410002List(InfcPkgPayr0304SrhVO searchVO) throws Exception {
              return list("infcPkgPayr0304DAO.selectPayr0304ToPayrP410002List_D", searchVO);
          }

          /**
      	 * PAYR0304 총 갯수를 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0304 총 갯수
      	 * @exception
      	 */
          public int selectPayr0304ToPayrP410002ListTotCnt(InfcPkgPayr0304SrhVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0304DAO.selectPayr0304ToPayrP410002ListTotCnt_S", searchVO);
          }
          
          
          /**
         	 * 건강보험개별납부내역리스트 PAYR0304 목록을 조회한다.
         	 * @param searchMap - 조회할 정보가 담긴 Map
         	 * @return PAYR0304 목록
         	 * @exception Exception
         	 */
             public List selectInsrRP410003Payr0304List(InfcPkgPayr0304SrhVO searchVO) throws Exception {
                 return list("infcPkgPayr0304DAO.selectInsrRP410003Payr0304List_D", searchVO);
             }

             /**
         	 * 건강보험개별납부내역리스트 PAYR0304 총 갯수를 조회한다.
         	 * @param searchMap - 조회할 정보가 담긴 Map
         	 * @return PAYR0304 총 갯수
         	 * @exception
         	 */
             public int selectInsrRP410003Payr0304ListTotCnt(InfcPkgPayr0304SrhVO searchVO) {
                 return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0304DAO.selectInsrRP410003Payr0304ListTotCnt_S", searchVO);
             }
             
             /**
         	* 이전달 추가 소득세 세율코드 데이터를 조회한다. PAYR0304을 조회한다.
         	* @param vo - 조회할 정보가 담긴 Payr0304VO
         	* @return 조회한 PAYR0304
         	* @exception Exception
         	*/              
             public InfcPkgPayr0304VO selectPayr0304ToAddIncmTx(InfcPkgPayr0304VO vo) throws Exception {
                 return (InfcPkgPayr0304VO) selectByPk("infcPkgPayr0304DAO.selectPayr0304ToAddIncmTx_S", vo);
             }
             
             
             /**
           	 * PAYR0304 목록을 조회한다.
           	 * @param searchMap - 조회할 정보가 담긴 Map
           	 * @return PAYR0304 목록
           	 * @exception Exception
           	 */
               public List selectPsnl0100ToPayr0304List(InfcPkgPayr0304SrhVO searchVO) throws Exception {
                   return list("infcPkgPayr0304DAO.selectPsnl0100ToPayr0304List_D", searchVO);
               }
               

}
