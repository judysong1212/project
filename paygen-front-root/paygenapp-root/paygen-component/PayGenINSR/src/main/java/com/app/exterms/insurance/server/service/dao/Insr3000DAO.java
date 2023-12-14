package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr3000SrhVO;
import com.app.exterms.insurance.server.vo.Insr3000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr3000DAO.java
 * @Description : Insr3000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr3000DAO")
public class Insr3000DAO extends EgovAbstractDAO {

	/**
	 * INSR3000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr3000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr3000(Insr3000VO vo) throws Exception {
        return (String)insert("insr3000DAO.insertInsr3000_S", vo);
    }

    /**
	 * INSR3000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr3000VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr3000(Insr3000VO vo) throws Exception {
        update("insr3000DAO.updateInsr3000_S", vo);
    }

    /**
   	 * INSR3000을 수정한다.
   	 * @param vo - 수정할 정보가 담긴 Insr3000VO
   	 * @return void형
   	 * @exception Exception
   	 */
       public void updateXlsInsr4100ToInsr3000(Insr3000VO vo) throws Exception {
           update("insr3000DAO.updateXlsInsr4100ToInsr3000_S", vo);
       }
    
    /**
	 * INSR3000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr3000VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr3000(Insr3000VO vo) throws Exception {
        delete("insr3000DAO.deleteInsr3000_S", vo);
    }

    /**
	 * INSR3000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr3000VO
	 * @return 조회한 INSR3000
	 * @exception Exception
	 */
    public Insr3000VO selectInsr3000(Insr3000VO vo) throws Exception {
        return (Insr3000VO) selectByPk("insr3000DAO.selectInsr3000_S", vo);
    }
    
    /**
   	 * INSR3000을 조회한다.
   	 * @param vo - 조회할 정보가 담긴 Insr3000VO
   	 * @return 조회한 INSR3000
   	 * @exception Exception
   	 */
       public Insr3000VO selectXlsInsr3000(Insr3000VO vo) throws Exception {
           return (Insr3000VO) selectByPk("insr3000DAO.selectXlsInsr3000_S", vo);
       }
    

    /**
	 * 엑셀저장 insr4100  화면 엑셀저장 INSR3000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3000 목록
	 * @exception Exception
	 */
    public List selectXlsInsr3000List(Insr3000SrhVO searchVO) throws Exception {
        return list("insr3000DAO.selectXlsInsr3000List_D", searchVO);
    }

    /**
	 * INSR3000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3000 목록
	 * @exception Exception
	 */
    public List<?> selectInsr3000List(Insr3000SrhVO searchVO) throws Exception {
        return list("insr3000DAO.selectInsr3000List_D", searchVO);
    }

    /**
	 * INSR3000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3000 총 갯수
	 * @exception
	 */
    public int selectInsr3000ListTotCnt(Insr3000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr3000DAO.selectInsr3000ListTotCnt_S", searchVO);
    }
    
    
    /**
	 * INSR3000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3000 목록
	 * @exception Exception
	 */
    public List<?> selectInsr4100ToInsr3000List(Insr3000SrhVO searchVO) throws Exception {
        return list("insr3000DAO.selectInsr4100ToInsr3000List_D", searchVO);
    }

    /**
	 * INSR3000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3000 총 갯수
	 * @exception
	 */
    public int selectInsr4100ToInsr3000ListTotCnt(Insr3000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr3000DAO.selectInsr4100ToInsr3000ListTotCnt_S", searchVO);
    }
     
    
    /**
	 * 월납부내역 리스트 
	 * INSR3000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3000 목록
	 * @exception Exception
	 */
    public List<?> selectInsrP410002ToInsr3000List(Insr3000SrhVO searchVO) throws Exception {
        return list("insr3000DAO.selectInsrP410002ToInsr3000List_D", searchVO);
    }

    /**
     * 국민연금 월납부내역 리스트 
	 * INSR3000 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3000 총 갯수
	 * @exception
	 */
    public int selectInsrP410002ToInsr3000ListTotCnt(Insr3000SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr3000DAO.selectInsrP410002ToInsr3000ListTotCnt_S", searchVO);
    }
    
    
    /**
   	 * 건강보험 
   	 * 개별납부내역 리스트 
   	 * INSR3000 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR3000 목록
   	 * @exception Exception
   	 */
       public List<?> selectInsrP410003ToInsr3000List(Insr3000SrhVO searchVO) throws Exception {
           return list("insr3000DAO.selectInsrP410003ToInsr3000List_D", searchVO);
       }

       /**
        * 건강보험개별납부내역 리스트 
   	 * INSR3000 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR3000 총 갯수
   	 * @exception
   	 */
       public int selectInsrP410003ToInsr3000ListTotCnt(Insr3000SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("insr3000DAO.selectInsrP410003ToInsr3000ListTotCnt_S", searchVO);
       }
       
       /**
   	 * insrP420002- 월납부내역 리스트 개인별 엑셀저장 
   	 *  
   	 * INSR3000 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR3000 목록
   	 * @exception Exception
   	 */
       public List<?> selectXlsInsrP41000202ToInsr3000List(Insr3000SrhVO searchVO) throws Exception {
           return list("insr3000DAO.selectXlsInsrP41000202ToInsr3000List_D", searchVO);
       }
       
       /**
      	 * insrP420002- 월납부내역 리스트  - 부서별 엑셀저장 
      	 * INSR3000 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return INSR3000 목록
      	 * @exception Exception
      	 */
          public List<?> selectXlsInsrP41000201ToInsr3000List(Insr3000SrhVO searchVO) throws Exception {
              return list("insr3000DAO.selectXlsInsrP41000201ToInsr3000List_D", searchVO);
          }
          
      /**
     	 * insrP420003- 개별납부내역 리스트  엑셀저장 
     	 *  
     	 * INSR3000 목록을 조회한다.
     	 * @param searchMap - 조회할 정보가 담긴 Map
     	 * @return INSR3000 목록
     	 * @exception Exception
     	 */
         public List<?> selectXlsInsrP410003ToInsr3000List(Insr3000SrhVO searchVO) throws Exception {
             return list("insr3000DAO.selectXlsInsrP410003ToInsr3000List_D", searchVO);
         }
          
}
