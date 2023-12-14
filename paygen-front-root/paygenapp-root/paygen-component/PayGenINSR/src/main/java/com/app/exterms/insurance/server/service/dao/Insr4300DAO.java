package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr4300SrhVO;
import com.app.exterms.insurance.server.vo.Insr4300VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr4300DAO.java
 * @Description : Insr4300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.07.01
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr4300DAO")
public class Insr4300DAO extends EgovAbstractDAO {

	/**
	 * INSR4300을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr4300VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr4300(Insr4300VO vo) throws Exception {
        return (String)insert("insr4300DAO.insertInsr4300_S", vo);
    }

    /**
	 * INSR4300을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr4300VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr4300(Insr4300VO vo) throws Exception {
        update("insr4300DAO.updateInsr4300_S", vo);
    }

    /**
	 * INSR4300을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr4300VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr4300(Insr4300VO vo) throws Exception {
        delete("insr4300DAO.deleteInsr4300_S", vo);
    }

    /**
	 * INSR4300을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr4300VO
	 * @return 조회한 INSR4300
	 * @exception Exception
	 */
    public Insr4300VO selectInsr4300(Insr4300VO vo) throws Exception {
        return (Insr4300VO) selectByPk("insr4300DAO.selectInsr4300_S", vo);
    }

    /**
	 * INSR4300 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR4300 목록
	 * @exception Exception
	 */
    public List<?> selectInsr4300List(Insr4300SrhVO searchVO) throws Exception {
        return list("insr4300DAO.selectInsr4300List_D", searchVO);
    }

    /**
	 * INSR4300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR4300 총 갯수
	 * @exception
	 */
    public int selectInsr4300ListTotCnt(Insr4300SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr4300DAO.selectInsr4300ListTotCnt_S", searchVO);
    }
    
    
    /**
   	 * insr3200 - 결정을 선택한 경우 데이터 INSR4300 목록을 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR4300 목록
   	 * @exception Exception
   	 */
       public List<?> selectInsr320001ToInsr4300List(Insr4300SrhVO searchVO) throws Exception {
           return list("insr4300DAO.selectInsr320001ToInsr4300List_D", searchVO);
       }

       /**
   	 *  insr3200 - 결정을 선택한 경우 데이터  INSR4300 총 갯수를 조회한다.
   	 * @param searchMap - 조회할 정보가 담긴 Map
   	 * @return INSR4300 총 갯수
   	 * @exception
   	 */
       public int selectInsr320001ToInsr4300ListTotCnt(Insr4300SrhVO searchVO) {
           return (Integer)getSqlMapClientTemplate().queryForObject("insr4300DAO.selectInsr320001ToInsr4300ListTotCnt_S", searchVO);
       }
       
       /**
      	 * insr3200 - 신고를 선택한 경우 데이터 INSR4300 목록을 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return INSR4300 목록
      	 * @exception Exception
      	 */
          public List<?> selectInsr320002ToInsr4300List(Insr4300SrhVO searchVO) throws Exception {
              return list("insr4300DAO.selectInsr320002ToInsr4300List_D", searchVO);
          }

          /**
      	 *  insr3200 - 신고를 선택한 경우 데이터  INSR4300 총 갯수를 조회한다.
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return INSR4300 총 갯수
      	 * @exception
      	 */
          public int selectInsr320002ToInsr4300ListTotCnt(Insr4300SrhVO searchVO) {
              return (Integer)getSqlMapClientTemplate().queryForObject("insr4300DAO.selectInsr320002ToInsr4300ListTotCnt_S", searchVO);
          }

          
          
          
          
          
          /**
      	 * 엑셀저장 insr3300  
      	 * @param searchMap - 조회할 정보가 담긴 Map
      	 * @return INSR3300 목록
      	 * @exception Exception
      	 */
          public List selectXlsInsr4300List(Insr4300SrhVO searchVO) throws Exception {
              return list("insr4300DAO.selectXlsInsr4100List_D", searchVO);
          }
          
          /**************************** 엑셀 업로드 ****************************/
          /**
      	 * INSR4300을 삭제한다.(엑셀)
      	 * @param vo - 삭제할 정보가 담긴 Insr4300VO
      	 * @return void형 
      	 * @exception Exception
      	 */
          public void deleteXlsInsr3300ToInsr4300(Insr4300VO vo) throws Exception {
              delete("insr4300DAO.deleteXlsInsr4300_S", vo);
          }
          
      	/**
      	 * INSR4300을 등록한다.(엑셀)
      	 * @param vo - 등록할 정보가 담긴 Insr4300VO
      	 * @return 등록 결과
      	 * @exception Exception
      	 */
          public String insertXlsInsr3300ToInsr4300(Insr4300VO vo) throws Exception {
              return (String)insert("insr4300DAO.insertXlsInsr4300_S", vo);
          }
      	/**************************** 엑셀 업로드 ****************************/
          
           
           
            public void insr3300MnthUpdate(Insr4300VO vo) throws MSFException {
                update("insr4300DAO.insr3300MnthUpdate_S", vo);
            }
            
            
            /**
          	 *  insr3200 - 신고를 선택한 경우 데이터  INSR4300 총 갯수를 조회한다.
          	 * @param searchMap - 조회할 정보가 담긴 Map
          	 * @return INSR4300 총 갯수
          	 * @exception
          	 */
              public int selectPsnl0100TotCnt(Insr4300VO vo) {
                  return (Integer)getSqlMapClientTemplate().queryForObject("insr4300DAO.selectPsnl0100TotCnt_S", vo);
              }
          
}
