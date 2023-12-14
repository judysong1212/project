package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0301SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0301VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0301DAO.java
 * @Description : Payr0301 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPayr0301DAO")
public class InfcPkgPayr0301DAO extends EgovAbstractDAO implements IsSerializable  {

     
    
	/**
	 * PAYR0301을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0301VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0301(InfcPkgPayr0301VO vo) throws Exception {
        return (String)insert("infcPkgPayr0301DAO.insertPayr0301_S", vo);
    }

    /**
	 * PAYR0301을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0301VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0301(InfcPkgPayr0301VO vo) throws Exception {
        update("infcPkgPayr0301DAO.updatePayr0301_S", vo);
    }
    @Transactional
    public void updatePayr0301ToPayr0307(InfcPkgPayr0301VO vo) throws Exception {
        update("infcPkgPayr0301DAO.updatePayr0301ToPayr0307_S", vo);
    }

    
    /**
     * PAYR0301을 수정한다.
     * @param vo - 수정할 정보가 담긴 Payr0301VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updatePayr0301PayDdlene(InfcPkgPayr0301VO vo) throws Exception {
        update("infcPkgPayr0301DAO.updatePayr0301PayDdlene_S", vo);
    }
 
    
    
    /**
     * PAYR0301을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Payr0301VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePayr0301(InfcPkgPayr0301VO vo) throws Exception {
        delete("infcPkgPayr0301DAO.deletePayCalculationPayr0301_S", vo);
    }
    
    /**
	 * PAYR0301을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0301VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayCalculationPayr0301(InfcPkgPayr0301VO vo) throws Exception {
        delete("infcPkgPayr0301DAO.deletePayCalculationPayr0301_S", vo);
    }

   
    /**
	 * PAYR0301을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0301VO
	 * @return 조회한 PAYR0301
	 * @exception Exception
	 */
    public InfcPkgPayr0301VO selectPayr0301(InfcPkgPayr0301VO vo) throws Exception {
        return (InfcPkgPayr0301VO) selectByPk("infcPkgPayr0301DAO.selectPayr0301_S", vo);
    }

    /**
	 * PAYR0301 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0301 목록
	 * @exception Exception
	 */
    public List selectPayr0301List(InfcPkgPayr0301SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0301DAO.selectPayr0301List_D", searchVO);
    }

    /**
	 * PAYR0301 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0301 총 갯수
	 * @exception
	 */
    public int selectPayr0301ListTotCnt(InfcPkgPayr0301SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0301DAO.selectPayr0301ListTotCnt_S", searchVO);
    }
    
    /**
   	 * PAYR0301 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0301 목록
   	 * @exception Exception
   	 */
       public List selectPayr03014550List(InfcPkgPayr0301SrhVO searchVO) throws Exception {
           return list("infcPkgPayr0301DAO.selectPayr03014550List_D", searchVO);
       }

       /**
   	 * PAYR0301 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0301 총 갯수
   	 * @exception
   	 */
       public int selectPayr03014550ListTotCnt(InfcPkgPayr0301SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0301DAO.selectPayr03014550ListTotCnt_S", searchVO);
       }
       
       
       /**
      	 * PAYR0301 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0301 목록
      	 * @exception Exception
      	 */
          public List selectPayr03014400List(InfcPkgPayr0301SrhVO searchVO) throws Exception {
              return list("infcPkgPayr0301DAO.selectPayr03014400List_D", searchVO);
          }

          /**
      	 * PAYR0301 총 갯수를 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0301 총 갯수
      	 * @exception
      	 */
          public int selectPayr03014400ListTotCnt(InfcPkgPayr0301SrhVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0301DAO.selectPayr03014400ListTotCnt_S", searchVO);
          }
   
          
          
          
      /**
     	 * PAYR0301 목록을 조회한다.
     	 * @param searchMap - 조회할 정보가 담긴 Map
     	 * @return PAYR0301 목록
     	 * @exception Exception
     	 */
         public List selectPayr0301ToPayr4150List(InfcPkgPayr0301SrhVO searchVO) throws Exception {
             return list("infcPkgPayr0301DAO.selectPayr0301ToPayr4150List_D", searchVO);
         }

         /**
     	 * PAYR0301 총 갯수를 조회한다.
     	 * @param searchMap - 조회할 정보가 담긴 Map
     	 * @return PAYR0301 총 갯수
     	 * @exception
     	 */
         public int selectPayr0301ToPayr4150ListTotCnt(InfcPkgPayr0301SrhVO searchVO) {
             return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0301DAO.selectPayr0301ToPayr4150ListTotCnt_S", searchVO);
         }
         
         
         /**
      	 * PAYR0301 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0301 목록
      	 * @exception Exception
      	 */
          public List selectPayr0301ToPayr4250List(InfcPkgPayr0301SrhVO searchVO) throws Exception {
              return list("infcPkgPayr0301DAO.selectPayr0301ToPayr4250List_D", searchVO);
          }

          /**
      	 * PAYR0301 총 갯수를 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0301 총 갯수
      	 * @exception
      	 */
          public int selectPayr0301ToPayr4250ListTotCnt(InfcPkgPayr0301SrhVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0301DAO.selectPayr0301ToPayr4250ListTotCnt_S", searchVO);
          }
            
         
}
