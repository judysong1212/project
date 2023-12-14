package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.msf.exterms.xls.service.Payr4200TotVO;
import org.msf.exterms.xls.service.Payr4200VO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Payr0301SrhVO;
import com.app.exterms.payroll.server.vo.Payr0301VO;
import com.app.exterms.payroll.server.vo.Payr0304SrhVO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

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

@Repository("Payr0301DAO")
public class Payr0301DAO extends EgovAbstractDAO implements IsSerializable  {

    
    @SuppressWarnings("rawtypes")
    public List selectPayr4400XlsList(Payr0301SrhVO payr0301SrhVO) {
        return list("payr0301DAO.selectPayr4400XlsList", payr0301SrhVO);
    }
    
    @SuppressWarnings("rawtypes")
    public List selectXlsHoJoPayr4400List(Payr0301SrhVO payr0301SrhVO) {
        return list("payr0301DAO.selectXlsHoJoPayr4400List", payr0301SrhVO);
    }
       
    
    @SuppressWarnings("rawtypes")
    public List<Payr4200VO> selectPayr4200XlsList(Payr0304SrhVO   payr0304SrhVO ) {
        return (List<Payr4200VO>)list("payr0301DAO.selectPayr4200XlsList", payr0304SrhVO);
    }
    
    @SuppressWarnings("rawtypes")
    public List<EgovMap> selectPayr4200XlsList2(Payr0304SrhVO   payr0304SrhVO ) {
        return (List<EgovMap>)list("payr0301DAO.selectPayr4200XlsList2", payr0304SrhVO);
    }
    
    @SuppressWarnings("rawtypes")
    public EgovMap selectPayr4200XlsList1(Payr0304SrhVO   payr0304SrhVO ) {
        return (EgovMap) selectByPk("payr0301DAO.selectPayr4200XlsList1", payr0304SrhVO);
    }
    
    
    
    @SuppressWarnings("rawtypes")
    public List<Payr4200TotVO> selectPayr4200XlsTotList(Payr0304SrhVO   payr0304SrhVO ) {
        return (List<Payr4200TotVO>)list("payr0301DAO.selectPayr4200XlsTotList", payr0304SrhVO);
    }
     
    
	/**
	 * PAYR0301을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0301VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    @Transactional
    public String insertPayr0301(Payr0301VO vo) throws Exception {
        return (String)insert("payr0301DAO.insertPayr0301_S", vo);
    }

    /**
	 * PAYR0301을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0301VO
	 * @return void형
	 * @exception Exception
	 */
    @Transactional
    public void updatePayr0301(Payr0301VO vo) throws Exception {
        update("payr0301DAO.updatePayr0301_S", vo);
    }
    @Transactional
    public void updatePayr0301ToPayr0307(Payr0301VO vo) throws Exception {
        update("payr0301DAO.updatePayr0301ToPayr0307_S", vo);
    }

    
    /**
     * PAYR0301을 수정한다.
     * @param vo - 수정할 정보가 담긴 Payr0301VO
     * @return void형
     * @exception Exception
     */
    @Transactional
    public void updatePayr0301PayDdlene(Payr0301VO vo) throws Exception {
        update("payr0301DAO.updatePayr0301PayDdlene_S", vo);
    }
 
    
    
    /**
     * PAYR0301을 삭제한다.
     * @param vo - 삭제할 정보가 담긴 Payr0301VO
     * @return void형 
     * @exception Exception
     */
    @Transactional
    public void deletePayr0301(Payr0301VO vo) throws Exception {
        delete("payr0301DAO.deletePayCalculationPayr0301_S", vo);
    }
    
    /**
	 * PAYR0301을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0301VO
	 * @return void형 
	 * @exception Exception
	 */
    @Transactional
    public void deletePayCalculationPayr0301(Payr0301VO vo) throws Exception {
        delete("payr0301DAO.deletePayCalculationPayr0301_S", vo);
    }

   
    /**
	 * PAYR0301을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0301VO
	 * @return 조회한 PAYR0301
	 * @exception Exception
	 */
    public Payr0301VO selectPayr0301(Payr0301VO vo) throws Exception {
        return (Payr0301VO) selectByPk("payr0301DAO.selectPayr0301_S", vo);
    }

    /**
	 * PAYR0301 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0301 목록
	 * @exception Exception
	 */
    public List selectPayr0301List(Payr0301SrhVO searchVO) throws Exception {
        return list("payr0301DAO.selectPayr0301List_D", searchVO);
    }

    /**
	 * PAYR0301 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0301 총 갯수
	 * @exception
	 */
    public int selectPayr0301ListTotCnt(Payr0301SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("payr0301DAO.selectPayr0301ListTotCnt_S", searchVO);
    }
    
    /**
   	 * PAYR0301 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0301 목록
   	 * @exception Exception
   	 */
       public List selectPayr03014550List(Payr0301SrhVO searchVO) throws Exception {
           return list("payr0301DAO.selectPayr03014550List_D", searchVO);
       }
       
       
    
       
	/**
	 * PAYR0301 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0301 목록
	 * @exception Exception
	 */
		public List selectPayr0301To4550XlsList(Payr0301SrhVO searchVO) throws Exception {
			return list("payr0301DAO.selectPayr03014550XlsList_D", searchVO);
		}      

       /**
   	 * PAYR0301 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0301 총 갯수
   	 * @exception
   	 */
       public int selectPayr03014550ListTotCnt(Payr0301SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("payr0301DAO.selectPayr03014550ListTotCnt_S", searchVO);
       }
       
       
       
       /**
      	 * PAYR0301 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0301 목록
      	 * @exception Exception
      	 */
          public List selectPayr03014400List(Payr0301SrhVO searchVO) throws Exception {
              return list("payr0301DAO.selectPayr03014400List_D", searchVO);
          }

          /**
      	 * PAYR0301 총 갯수를 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0301 총 갯수
      	 * @exception
      	 */
          public int selectPayr03014400ListTotCnt(Payr0301SrhVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("payr0301DAO.selectPayr03014400ListTotCnt_S", searchVO);
          }
   
          
          
          
      /**
     	 * PAYR0301 목록을 조회한다.
     	 * @param searchMap - 조회할 정보가 담긴 Map
     	 * @return PAYR0301 목록
     	 * @exception Exception
     	 */
         public List selectPayr0301ToPayr4150List(Payr0301SrhVO searchVO) throws Exception {
             return list("payr0301DAO.selectPayr0301ToPayr4150List_D", searchVO);
         }

         /**
     	 * PAYR0301 총 갯수를 조회한다.
     	 * @param searchMap - 조회할 정보가 담긴 Map
     	 * @return PAYR0301 총 갯수
     	 * @exception
     	 */
         public int selectPayr0301ToPayr4150ListTotCnt(Payr0301SrhVO searchVO) {
             return (Integer)getSqlMapClientTemplate().queryForObject("payr0301DAO.selectPayr0301ToPayr4150ListTotCnt_S", searchVO);
         }
         
         
         /**
      	 * PAYR0301 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0301 목록
      	 * @exception Exception
      	 */
          public List selectPayr0301ToPayr4250List(Payr0301SrhVO searchVO) throws Exception {
              return list("payr0301DAO.selectPayr0301ToPayr4250List_D", searchVO);
          }

          /**
      	 * PAYR0301 총 갯수를 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return PAYR0301 총 갯수
      	 * @exception
      	 */
          public int selectPayr0301ToPayr4250ListTotCnt(Payr0301SrhVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("payr0301DAO.selectPayr0301ToPayr4250ListTotCnt_S", searchVO);
          }
            
          public int selectPayr4150DelToPayr0301ListTotCnt(Payr0301SrhVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("payr0301DAO.selectPayr4150DelToPayr0301ListTotCnt_S", searchVO);
          }  
           
          public int selectPayr4200DelToPayr0301ListTotCnt(Payr0301SrhVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("payr0301DAO.selectPayr4200DelToPayr0301ListTotCnt_S", searchVO);
          }  
}
