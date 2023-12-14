package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr4100SrhVO;
import com.app.exterms.insurance.server.vo.Insr4100VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr4100DAO.java
 * @Description : Insr4100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr4100DAO")
public class Insr4100DAO extends EgovAbstractDAO {

	/**
	 * INSR4100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr4100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr4100(Insr4100VO vo) throws MSFException {
        return (String)insert("insr4100DAO.insertInsr4100", vo);
    }

    /**
	 * INSR4100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr4100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr4100(Insr4100VO vo) throws MSFException {
        update("insr4100DAO.updateInsr4100", vo);
    }

    /**
	 * INSR4100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr4100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr4100(Insr4100VO vo) throws MSFException {
        delete("insr4100DAO.deleteInsr4100", vo);
    }

    /**
	 * INSR4100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr4100VO
	 * @return 조회한 INSR4100
	 * @exception Exception
	 */
    public Insr4100VO selectInsr4100(Insr4100VO vo) throws MSFException {
        return (Insr4100VO) selectByPk("insr4100DAO.selectInsr4100_S", vo);
    }

    /**
	 * INSR4100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR4100 목록
	 * @exception Exception
	 */
    public List<?> selectInsr4100List(Insr4100SrhVO searchVO) throws MSFException {
        return list("insr4100DAO.selectInsr4100List_D", searchVO);
    }

    /**
	 * INSR4100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR4100 총 갯수
	 * @exception
	 */
    public int selectInsr4100ListTotCnt(Insr4100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr4100DAO.selectInsr4100ListTotCnt_S", searchVO);
    }
    

    /**
	 * 엑셀저장 insr3100  화면 엑셀저장 INSR3000 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3000 목록
	 * @exception Exception
	 */
    public List selectXlsInsr4100List(Insr4100SrhVO searchVO) throws Exception {
        return list("insr4100DAO.selectXlsInsr4100List_D", searchVO);
    }
    
    /**
  	 * 엑셀저장 insr3100 팝업화면에서 테이터를 가져온다. 화면 엑셀저장 INSR3000 목록을 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return INSR3000 목록
  	 * @exception Exception
  	 */
      public List selectXlsPInsr4100List(Insr4100SrhVO searchVO) throws Exception {
          return list("insr4100DAO.selectXlsPInsr4100List_D", searchVO);
      }
    
    /**
   	 * INSR4100 목록을 조회한다. - 국민연금 기본관리조회 
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR4100 목록
   	 * @exception Exception
   	 */
       public List<?> selectInsr3100ToInsr4100List(Insr4100SrhVO searchVO) throws MSFException {
           return list("insr4100DAO.selectInsr3100ToInsr4100List_D", searchVO);
       }

       /**
   	 * INSR4100 총 갯수를 조회한다. - 국민연금기본관리조회 
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR4100 총 갯수
   	 * @exception
   	 */
       public int selectInsr3100ToInsr4100ListTotCnt(Insr4100SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("insr4100DAO.selectInsr3100ToInsr4100ListTotCnt_S", searchVO);
       }
       
       
       /**
      	 * INSR4100 목록을 조회한다. - 국민연금 기본관리조회 
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return INSR4100 목록
      	 * @exception Exception
      	 */
          public List<?> selectInsrP310001ToInsr4100List(Insr4100SrhVO searchVO) throws MSFException {
              return list("insr4100DAO.selectInsrP310001ToInsr4100List_D", searchVO);
          }

          /**
      	 * INSR4100 총 갯수를 조회한다. - 국민연금기본관리조회 
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return INSR4100 총 갯수
      	 * @exception
      	 */
          public int selectInsrP310001ToInsr4100ListTotCnt(Insr4100SrhVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("insr4100DAO.selectInsrP310001ToInsr4100ListTotCnt_S", searchVO);
          } 
          
          
          /**************************** 엑셀 업로드 ****************************/
          /**
      	 * INSR4100을 삭제한다.(엑셀)
      	 * @param vo - 삭제할 정보가 담긴 Insr4100VO
      	 * @return void형 
      	 * @exception Exception
      	 */
          public void deleteXlsInsr3100ToInsr4100(Insr4100VO vo) throws Exception {
              delete("insr4100DAO.deleteXlsInsr3100ToInsr4100_S", vo);
          }
          
      	/**
      	 * INSR4100을 등록한다.(엑셀)
      	 * @param vo - 등록할 정보가 담긴 Insr4100VO
      	 * @return 등록 결과
      	 * @exception Exception
      	 */
          public String insertXlsInsr3100ToInsr4100(Insr4100VO vo) throws Exception {
              return (String)insert("insr4100DAO.insertXlsInsr3100ToInsr4100_S", vo);
          }
          
          /**
        	 * INSR4100을 업데이트 한다.(엑셀)
        	 * @param vo - 등록할 정보가 담긴 Insr4100VO
        	 * @return 등록 결과
        	 * @exception Exception
        	 */
          public void updateXlsInsr3100ToInsr4100(Insr4100VO vo) throws Exception {
              update("insr4100DAO.updateXlsInsr3100ToInsr4100_S", vo);
          }
      	/**************************** 엑셀 업로드 ****************************/
          
          /**
      	 * INSR4100을 수정한다.
      	 * @param vo - 수정할 정보가 담긴 Insr4100VO
      	 * @return void형
      	 * @exception Exception
      	 */
          public void updateInsr3100ToInsr4100(Insr4100VO vo) throws MSFException {
              update("insr4100DAO.updateInsr3100ToInsr4100_S", vo);
          }
}
