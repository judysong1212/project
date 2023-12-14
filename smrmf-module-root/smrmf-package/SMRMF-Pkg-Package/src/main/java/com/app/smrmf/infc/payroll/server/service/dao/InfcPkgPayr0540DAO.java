package com.app.smrmf.infc.payroll.server.service.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0540SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0540VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Payr0540DAO.java
 * @Description : Payr0540 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPayr0540DAO")
public class InfcPkgPayr0540DAO extends EgovAbstractDAO {
	
	public String getMaxSeilNum(HashMap<String, String> hMap){
		return (String)selectByPk("infcPkgPayr0540DAO.getMaxSeilNum", hMap);
	}
		
	
	/**
	 * PAYR0540을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0540VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
    public String insertPayr0540(InfcPkgPayr0540VO vo) throws Exception {
        return (String)insert("infcPkgPayr0540DAO.insertPayr0540_S", vo);
    }

    /**
	 * PAYR0540을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Payr0540VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
    public void updatePayr0540(InfcPkgPayr0540VO vo) throws Exception {
        update("infcPkgPayr0540DAO.updatePayr0540_S", vo);
    }

    /**
	 * PAYR0540을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0540VO
	 * @return void형 
	 * @exception Exception
	 */
	@Transactional
    public void deletePayr0540(InfcPkgPayr0540VO vo) throws Exception {
        delete("infcPkgPayr0540DAO.deletePayr0540_S", vo);
    }
	
	   /**
		 * PAYR0540을 삭제한다.
		 * @param vo - 삭제할 정보가 담긴 Payr0540VO
		 * @return void형 
		 * @exception Exception
		 */
		@Transactional
	    public void deleteInsr410001ToPayr0540(InfcPkgPayr0540VO vo) throws Exception {
	        delete("infcPkgPayr0540DAO.deleteInsr410001ToPayr0540_S", vo);
	    }

    /**
	 * PAYR0540을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Payr0540VO
	 * @return 조회한 PAYR0540
	 * @exception Exception
	 */
    public InfcPkgPayr0540VO selectPayr0540(InfcPkgPayr0540VO vo) throws Exception {
        return (InfcPkgPayr0540VO) selectByPk("infcPkgPayr0540DAO.selectPayr0540_S", vo);
    }

    /**
     * Insr410001 화면 신규등록 대상자인여부 판단하여 등록 
     * @param searchVO
     * @return
     * @throws Exception
     */
    public List selectInsr410001ToPayr0540(InfcPkgPayr0540SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0540DAO.selectInsr410001ToPayr0540_S", searchVO);
    }
    
    
    /**
	 * PAYR0540 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0540 목록
	 * @exception Exception
	 */
    public List selectPayr0540List(InfcPkgPayr0540SrhVO searchVO) throws Exception {
        return list("infcPkgPayr0540DAO.selectPayr0540List_D", searchVO);
    }

    /**
	 * PAYR0540 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return PAYR0540 총 갯수
	 * @exception
	 */
    public int selectPayr0540ListTotCnt(InfcPkgPayr0540SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0540DAO.selectPayr0540ListTotCnt_S", searchVO);
    }
    
    /**
   	 * 예외처리대상자조회 
   	 * PAYR0540 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0540 목록
   	 * @exception Exception
   	 */
       public List selectInsrLP410001Payr0540List(InfcPkgPayr0540SrhVO searchVO) throws Exception {
           return list("infcPkgPayr0540DAO.selectInsrLP410001Payr0540List_D", searchVO);
       }

   /**
   	 * 예외처리대상자조회
   	 * PAYR0540 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return PAYR0540 총 갯수
   	 * @exception
   	 */
       public int selectInsrLP410001Payr0540ListTotCnt(InfcPkgPayr0540SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0540DAO.selectInsrLP410001Payr0540ListTotCnt_S", searchVO);
       }
       
    /**
  	 * 예외처리내역
  	 * PAYR0540 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return PAYR0540 목록
  	 * @exception Exception
  	 */
      public List selectInsrRP410001Payr0540List(InfcPkgPayr0540SrhVO searchVO) throws Exception {
          return list("infcPkgPayr0540DAO.selectInsrRP410001Payr0540List_D", searchVO);
      }

    /**
  	 * 예외처리내역 
  	 * PAYR0540 총 갯수를 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return PAYR0540 총 갯수
  	 * @exception
  	 */
      public int selectInsrRP410001Payr0540ListTotCnt(InfcPkgPayr0540SrhVO searchVO) {
          return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgPayr0540DAO.selectInsrRP410001Payr0540ListTotCnt_S", searchVO);
      }

      /**
       * 
       * <pre>
       * 1. 개요 :  4대보험 제외처리 조회  
       * 2. 처리내용 : 
       * </pre>
       * @Method Name : selectPkgPayr0540List
       * @date : 2016. 12. 24.
       * @author : atres-pc
       * @history : 
       *	-----------------------------------------------------------------------
       *	변경일				작성자						변경내용  
       *	----------- ------------------- ---------------------------------------
       *	2016. 12. 24.		atres-pc				최초 작성 
       *	-----------------------------------------------------------------------
       * 
       * @param payr0540SrhVo
       * @return
       * @throws Exception
       */
      public List selectPkgPayr0540List(InfcPkgPayr0540SrhVO payr0540SrhVo) throws Exception {
    	  
    	  return list("infcPkgPayr0540DAO.selectPkgPayr0540List", payr0540SrhVo);
      	 
      } 
}
