package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr1100SrhVO;
import com.app.exterms.insurance.server.vo.Insr1200SrhVO;
import com.app.exterms.insurance.server.vo.Insr1200VO;
import com.app.exterms.insurance.server.vo.Insr1550SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : Insr1200DAO.java
 * @Description : Insr1200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr1200DAO")
public class Insr1200DAO extends EgovAbstractDAO {
	
	/**
	 * INSR1200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr1200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public Long getInsr1200EmymtSeilNum(Insr1200VO vo) throws Exception {
        return (Long)getSqlMapClientTemplate().queryForObject("insr1200DAO.getInsr1200EmymtSeilNum", vo);
    }

	/**
	 * INSR1200 등록여부 조회
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR1200 총 갯수
	 * @exception
	 */
    public int selectInsr1200Chk(Insr1200VO vo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr1200DAO.selectInsr1200Chk_S", vo);
    }
    
	/**
	 * INSR1200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr1200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr1200(Insr1200VO vo) throws Exception {
        return (String)insert("insr1200DAO.insertInsr1200_S", vo);
    }

    /**
	 * INSR1200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr1200VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr1200(Insr1200VO vo) throws Exception {
        update("insr1200DAO.updateInsr1200_S", vo);
    }
    
    /**
	 * INSR1200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr1200VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsrP210002ToInsr1200(Insr1200VO vo) throws Exception {
        update("insr1200DAO.updateInsrP210002ToInsr1200", vo);
    }

    /**
	 * INSR1200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr1200VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr1200(Insr1200VO vo) throws Exception {
        delete("insr1200DAO.deleteInsr1200_S", vo);
    }

    /**
	 * INSR1200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr1200VO
	 * @return 조회한 INSR1200
	 * @exception Exception
	 */
    public Insr1200VO selectInsr1200(Insr1200VO vo) throws Exception {
        return (Insr1200VO) selectByPk("insr1200DAO.selectInsr1200_S", vo);
    }

    /**
	 * INSR1200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR1200 목록
	 * @exception Exception
	 */
    public List<?> selectInsr1200List(Insr1200SrhVO searchVO) throws Exception {
        return list("insr1200DAO.selectInsr1200List_D", searchVO);
    }

    /**
	 * INSR1200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR1200 총 갯수
	 * @exception
	 */
    public int selectInsr1200ListTotCnt(Insr1200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr1200DAO.selectInsr1200ListTotCnt_S", searchVO);
    }
    
    
    /**
	 * 자격취득내역보기 INSR1200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR1200 목록
	 * @exception Exception
	 */
    public List<?> selectInsrP210005ToInsr1200List(Insr1200SrhVO searchVO) throws Exception {
        return list("insr1200DAO.selectInsrP210005ToInsr1200List_D", searchVO);
    }

    /**
	 * 자격취득내역보기 INSR1200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR1200 총 갯수
	 * @exception
	 */
    public int selectInsrP210005ToInsr1200ListTotCnt(Insr1200SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr1200DAO.selectInsrP210005ToInsr1200ListTotCnt_S", searchVO);
    }
    
    /**
   	 * 개별 자격취득상세정보 INSR1200 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR1200 목록
   	 * @exception Exception
   	 */
       public List<?> selectInsr2100ToInsr1200List(Insr1200SrhVO searchVO) throws Exception {
           return list("insr1200DAO.selectInsr2100ToInsr1200List_D", searchVO);
       }

       /**
   	 * 개별 자격취득상세정보  INSR1200 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR1200 총 갯수
   	 * @exception
   	 */
       public int selectInsr2100ToInsr1200ListTotCnt(Insr1200SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("insr1200DAO.selectInsr2100ToInsr1200ListTotCnt_S", searchVO);
       }
    
       /**
      	 *  자격취득내역 엑셀저장 처리 루틴 호출 
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return INSR1200 목록
      	 * @exception Exception
      	 */
          public List  selectXlsInsr1200List(Insr1200SrhVO searchVO) throws Exception {
              return list("insr1200DAO.selectXlsInsr1200List_D", searchVO);
          }
 
          /**
      	 * INSR1200을 수정한다. (checkbox 일괄 적용)
      	 * @param vo - 수정할 정보가 담긴 Insr1100VO
      	 * @return void형
      	 * @exception Exception
      	 */
          public void updateInsr2100AllGridBatch(Insr1200VO vo) throws Exception {
              update("insr1200DAO.updateInsr2100AllGridBatch_S", vo);
          }
          
     /**
 	 * 4대보험 취득신고 보수월액 INSR1200 INSR0240 총 갯수를 조회한다.
 	 * @param searchMap - 조회할 정보가 담긴 Map
 	 * @return INSR1200 총 갯수
 	 * @exception
 	 */
      public int selectInsrP210002ToInsr12000240ListTotCnt(Insr1100SrhVO searchVO) {
          return (Integer)getSqlMapClientTemplate().queryForObject("insr1200DAO.selectInsrP210002ToInsr12000240ListTotCnt_S", searchVO);
      }
      
      /**
  	 * 4대보험 취득신고 보수월액 INSR1200 INSR0240 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return INSR1200 목록
  	 * @exception Exception
  	 */
      public List<?> selectInsrP210002ToInsr12000240List(Insr1100SrhVO searchVO) throws Exception {
          return list("insr1200DAO.selectInsrP210002ToInsr12000240List_D", searchVO);
      }
      
      /**
    	 * 4대보험 취득신고 보수월액 INSR1200 INSR0240 목록을 조회한다.(엑셀)
    	 * @param searchMap - 조회할 정보가 담긴 Map
    	 * @return INSR1200 목록
    	 * @exception Exception
    	 */
        public List<?> selectXlsInsrP210002ToInsr12000240List(Insr1100SrhVO searchVO) throws Exception {
            return list("insr1200DAO.selectXlsInsrP210002ToInsr12000240List_D", searchVO);
        }
        
      
      /**
       * 사업장정보를 조회한다.
       * @param vo - 조회할 정보가 담긴 Insr1200VO
       * @return 조회한 INSR1200
       * @exception Exception
       */
      public EgovMap selectInsr230001ToBass0150(Insr1200SrhVO vo) throws Exception {
   	   return (EgovMap) selectByPk("insr1200DAO.selectInsr230001ToBass0150_S", vo);
      }
      
      /**
       * 사업장정보를 조회한다.
       * @param vo - 조회할 정보가 담긴 Insr1200VO
       * @return 조회한 INSR1200
       * @exception Exception
       */
      public EgovMap selectInsr230001ToBass0500(Insr1200SrhVO vo) throws Exception {
   	   return (EgovMap) selectByPk("insr1200DAO.selectInsr230001ToBass0500_S", vo);
      }
      
      /**
  	 * INSR1550 총 갯수를 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return INSR1550 총 갯수
  	 * @exception
  	 */
      public int countInsr1550(Insr1550SrhVO searchVO) {
          return (Integer)getSqlMapClientTemplate().queryForObject("insr1500DAO.selectInsrP210001ToInsr1500ListTotCnt_S", searchVO);
      }
}
