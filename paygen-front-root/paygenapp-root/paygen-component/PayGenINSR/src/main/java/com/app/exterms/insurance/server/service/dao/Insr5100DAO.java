package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr5100SrhVO;
import com.app.exterms.insurance.server.vo.Insr5100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr5100DAO.java
 * @Description : Insr5100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr5100DAO")
public class Insr5100DAO extends EgovAbstractDAO {

	/**
	 * INSR5100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr5100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr5100(Insr5100VO vo) throws Exception {
        return (String)insert("insr5100DAO.insertInsr5100_S", vo);
    }

    /**
	 * INSR5100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr5100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr5100(Insr5100VO vo) throws Exception {
        update("insr5100DAO.updateInsr5100_S", vo);
    }
    
    /**
	 * INSR5100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr5100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateXlsInsr5100(Insr5100VO vo) throws Exception {
        update("insr5100DAO.updateXlsInsr5100_S", vo);
    }

    /**
	 * INSR5100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr5100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr5100(Insr5100VO vo) throws Exception {
        delete("insr5100DAO.deleteInsr5100_S", vo);
    }

    /**
	 * 고용보험 insr5100 화면 엑셀리스트 조회 
	 * 
	 * @param vo - 조회할 정보가 담긴 Insr5100VO
	 * @return 조회한 INSR5100
	 * @exception Exception
	 */
    public List selectXlsInsr5100List(Insr5100SrhVO searchVO) throws Exception {
        return list("insr5100DAO.selectXlsInsr5100List_D", searchVO);
    }
    
    
    /**
	 * INSR5100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr5100VO
	 * @return 조회한 INSR5100
	 * @exception Exception
	 */
    public Insr5100VO selectInsr5100(Insr5100VO vo) throws Exception {
        return (Insr5100VO) selectByPk("insr5100DAO.selectInsr5100_S", vo);
    }

    /**
	 * INSR5100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr5100VO
	 * @return 조회한 INSR5100
	 * @exception Exception
	 */
    public Insr5100VO selectXlsInsr5100(Insr5100VO vo) throws Exception {
        return (Insr5100VO) selectByPk("insr5100DAO.selectXlsInsr5100_S", vo);
    }
    
    /**
	 * INSR5100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR5100 목록
	 * @exception Exception
	 */
    public List<?> selectInsr5100List(Insr5100SrhVO searchVO) throws Exception {
        return list("insr5100DAO.selectInsr5100List_D", searchVO);
    }

    /**
	 * INSR5100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR5100 총 갯수
	 * @exception
	 */
    public int selectInsr5100ListTotCnt(Insr5100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr5100DAO.selectInsr5100ListTotCnt_S", searchVO);
    }
    
    /**
 	 * 고용보험기본관리 INSR5100 목록을 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return INSR5100 목록
 	 * @exception Exception
 	 */
     public List<?> selectInsr5100ToInsr5100List(Insr5100SrhVO searchVO) throws Exception {
         return list("insr5100DAO.selectInsr5100ToInsr5100List_D", searchVO);
     }

     /**
 	 * 고용보험기본관 INSR5100 총 갯수를 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return INSR5100 총 갯수
 	 * @exception
 	 */
     public int selectInsr5100ToInsr5100ListTotCnt(Insr5100SrhVO searchVO) {
         return (Integer)getSqlMapClientTemplate().queryForObject("insr5100DAO.selectInsr5100ToInsr5100ListTotCnt_S", searchVO);
     }
     
     
     /**
  	 * 고용보험월별납부내역 INSR5100 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return INSR5100 목록
  	 * @exception Exception
  	 */
      public List<?> selectInsrP510001ToInsr5100List(Insr5100SrhVO searchVO) throws Exception {
          return list("insr5100DAO.selectInsrP510001ToInsr5100List_D", searchVO);
      }

      /**
       * 고용보험월별납부내역 INSR5100 총 갯수를 조회한다.
       * @param searchMap - 조회할 정보가 담긴 Map
       * @return INSR5100 총 갯수
       * @exception
       */
      public int selectInsrP510001ToInsr5100ListTotCnt(Insr5100SrhVO searchVO) {
    	  return (Integer)getSqlMapClientTemplate().queryForObject("insr5100DAO.selectInsrP510001ToInsr5100ListTotCnt_S", searchVO);
      }

      /**
       * insrP510001- 월납부내역 리스트 개인별 엑셀저장 
       *  
       * INSR5100 목록을 조회한다.
       * @param searchMap - 조회할 정보가 담긴 Map
       * @return INSR5100 목록
       * @exception Exception
       */
      public List<?> selectXlsInsrP51000102ToInsr5100List(Insr5100SrhVO searchVO) throws Exception {
    	  return list("insr5100DAO.selectXlsInsrP51000102ToInsr5100List_D", searchVO);
      }

      /**
       * insrP510001- 월납부내역 리스트  - 부서별 엑셀저장 
       * INSR5100 목록을 조회한다.
       * @param searchMap - 조회할 정보가 담긴 Map
       * @return INSR5100 목록
       * @exception Exception
       */
      public List<?> selectXlsInsrP51000101ToInsr5100List(Insr5100SrhVO searchVO) throws Exception {
    	  return list("insr5100DAO.selectXlsInsrP51000101ToInsr5100List_D", searchVO);
      }

}
