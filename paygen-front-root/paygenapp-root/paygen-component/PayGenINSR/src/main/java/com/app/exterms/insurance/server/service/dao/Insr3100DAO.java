package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr3100SrhVO;
import com.app.exterms.insurance.server.vo.Insr3100VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr3100DAO.java
 * @Description : Insr3100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr3100DAO")
public class Insr3100DAO extends EgovAbstractDAO {

	/**
	 * INSR3100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr3100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertInsr3100(Insr3100VO vo) throws Exception {
        return (String)insert("insr3100DAO.insertInsr3100_S", vo);
    }

    /**
	 * INSR3100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr3100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updateInsr3100(Insr3100VO vo) throws Exception {
        update("insr3100DAO.updateInsr3100_S", vo);
    }
    
    public void updateInsr4500ToPsnl0127(Insr3100VO vo) throws Exception {
        update("insr3100DAO.updateInsr4500ToPsnl0127_S", vo);
    }
    
    public void updateInsr4500ToPayr0500(Insr3100VO vo) throws Exception {
        update("insr3100DAO.updateInsr4500ToPayr0500_S", vo);
    }

    /**
	 * INSR3100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr3100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteInsr3100(Insr3100VO vo) throws Exception {
        delete("insr3100DAO.deleteInsr3100_S", vo);
    }

    /**
	 * INSR3100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr3100VO
	 * @return 조회한 INSR3100
	 * @exception Exception
	 */
    public Insr3100VO selectInsr3100(Insr3100VO vo) throws Exception {
        return (Insr3100VO) selectByPk("insr3100DAO.selectInsr3100_S", vo);
    }
    public Insr3100VO selectInsr4500ToInsr3100(Insr3100VO vo) throws Exception {
        return (Insr3100VO) selectByPk("insr3100DAO.selectInsr4500ToInsr3100_S", vo);
    }

    /**
	 * INSR3100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3100 목록
	 * @exception Exception
	 */
    public List<?> selectInsr3100List(Insr3100SrhVO searchVO) throws Exception {
        return list("insr3100DAO.selectInsr3100List_D", searchVO);
    }

    /**
	 * INSR3100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3100 총 갯수
	 * @exception
	 */
    public int selectInsr3100ListTotCnt(Insr3100SrhVO searchVO) {
        return (Integer)getSqlMapClientTemplate().queryForObject("insr3100DAO.selectInsr3100ListTotCnt_S", searchVO);
    }
    
    /**
	 * 엑셀저장 insr4500  화면 엑셀저장 INSR3100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3100 목록
	 * @exception Exception
	 */
    public List selectXlsInsr3100List(Insr3100SrhVO searchVO) throws Exception {
        return list("insr3100DAO.selectXlsInsr3100List_D", searchVO);
    }
    
    /**
	 * INSR3100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
     * @return INSR3100 목록
     * @exception Exception
     */
	public List<?> selectXlsInsr4500ToInsr3100List(Insr3100SrhVO searchVO) throws Exception {
		return list("insr3100DAO.selectXlsInsr4500ToInsr3100List_D", searchVO);
	}
	
	/**
	 * INSR3100 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
     * @return INSR3100 목록
     * @exception Exception
     */
	public List<?> selectTxtInsr4500ToInsr3100List(Insr3100SrhVO searchVO) throws Exception {
		return list("insr3100DAO.selectTxtInsr4500ToInsr3100List_D", searchVO);
	}
    
    /**************************** 엑셀 업로드 ****************************/
    /**
	 * INSR3100을 삭제한다.(엑셀)
	 * @param vo - 삭제할 정보가 담긴 Insr3100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deleteXlsInsr3100(Insr3100VO vo) throws Exception {
        delete("insr3100DAO.deleteXlsInsr3100", vo);
    }
    
    /**
  	 *  insr3200 - 신고를 선택한 경우 데이터  INSR3000 총 갯수를 조회한다.
  	 * @param searchMap - 조회할 정보가 담긴 Map
  	 * @return INSR3000 총 갯수
  	 * @exception
  	 */
      public int selectPsnl0100TotCnt(Insr3100VO vo) {
          return (Integer)getSqlMapClientTemplate().queryForObject("insr3100DAO.selectPsnl0100TotCnt_S", vo);
      }
    
	/**
	 * INSR3100을 등록한다.(엑셀)
	 * @param vo - 등록할 정보가 담긴 Insr3100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertXlsInsr3100(Insr3100VO vo) throws Exception {
        return (String)insert("insr3100DAO.insertXlsInsr3100", vo);
    }
	/**************************** 엑셀 업로드 ****************************/
}
