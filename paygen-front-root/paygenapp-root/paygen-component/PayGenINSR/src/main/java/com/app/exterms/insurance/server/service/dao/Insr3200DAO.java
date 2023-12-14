package com.app.exterms.insurance.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.insurance.server.vo.Insr3200SrhVO;
import com.app.exterms.insurance.server.vo.Insr3200VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Insr3200DAO.java
 * @Description : Insr3200 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2015.06.10
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Insr3200DAO")
public class Insr3200DAO extends EgovAbstractDAO {
	/**
	 * INSR3200을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Insr3200VO
	 * @return 등록 결과
	 * @exception Exceptiong
	 */
	public String insertInsr3200(Insr3200VO vo) throws Exception {
		return (String)insert("insr3200DAO.insertInsr3200_S", vo);
	}
	
	/**
	 * INSR3200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr3200VO
	 * @return void형
	 * @exception Exception
	 */
	public void updateInsr3200(Insr3200VO vo) throws Exception {
		update("insr3200DAO.updateInsr3200_S", vo);
	}
	
	/**
	 * INSR3200을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Insr3200VO
	 * @return void형
	 * @exception Exception
	 */
	public void updatePayCalcInsr3200(Insr3200VO vo) throws Exception {
		update("insr3200DAO.updatePayCalcInsr3200_S", vo);
	}
	
	
	/**
	 * INSR3200을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Insr3200VO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteInsr3200(Insr3200VO vo) throws Exception {
		delete("insr3200DAO.deleteInsr3200_S", vo);
	}
	
	/**
	 * INSR3200을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Insr3200VO
	 * @return 조회한 INSR3200
	 * @exception Exception
	 */
	public Insr3200VO selectInsr3200(Insr3200VO vo) throws Exception {
		return (Insr3200VO) selectByPk("insr3200DAO.selectInsr3200_S", vo);
	}
	
	/**
	 * INSR3200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3200 목록
	 * @exception Exception
	 */
	public List<?> selectInsr3200List(Insr3200SrhVO searchVO) throws Exception {
		return list("insr3200DAO.selectInsr3200List_D", searchVO);
	}
	
	
	/**
	 * INSR3200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3200 목록
	 * @exception Exception
	 */
	public List<?> selectInsrP420001ToInsr3200List(Insr3200SrhVO searchVO) throws Exception {
		return list("insr3200DAO.selectInsrP420001ToInsr3200List_D", searchVO);
	}

	/**
	 * INSR3200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3200 목록
	 * @exception Exception
	 */
	public List<?> selectXlsInsrP420001ToInsr3200List(Insr3200SrhVO searchVO) throws Exception {
		return list("insr3200DAO.selectXlsInsrP420001ToInsr3200List_D", searchVO);
	}
	
	/**
	 * INSR3200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3200 총 갯수
	 * @exception
	 */
	public int selectInsr3200ListTotCnt(Insr3200SrhVO searchVO) {
		return (Integer)getSqlMapClientTemplate().queryForObject("insr3200DAO.selectInsr3200ListTotCnt_S", searchVO);
	}
	

	
	
	/**
	 * INSR3200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3200 총 갯수
	 * @exception
	 */
	public int selectInsrP420001ToInsr3200ListTotCnt(Insr3200SrhVO searchVO) {
		return (Integer)getSqlMapClientTemplate().queryForObject("insr3200DAO.selectInsrP420001ToInsr3200ListTotCnt_S", searchVO);
	}
	
	/**
	 * insr4200 화면 엑셀저장 기능 INSR3200 목록을 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3200 목록
	 * @exception Exception
	 */
	public List<?> selectXlsInsr4200ToInsr3200List(Insr3200SrhVO searchVO) throws Exception {
		return list("insr3200DAO.selectXlsInsr4200ToInsr3200List_D", searchVO);
	}
	
	/**************************** 엑셀 업로드 ****************************/
	/**
	 * INSR3200을 삭제한다.(엑셀)
	 * @param vo - 삭제할 정보가 담긴 Insr3200VO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteXlsInsr3200(Insr3200VO vo) throws Exception {
		delete("insr3200DAO.deleteXlsInsr3200_S", vo);
	}
	
	/**
	 * INSR3200을 등록한다.(엑셀)
	 * @param vo - 등록할 정보가 담긴 Insr3200VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	public String insertXlsInsr3200(Insr3200VO vo) throws Exception {
		return (String)insert("insr3200DAO.insertXlsInsr3200_S", vo);
	}
	
	/**
	 * INSR3200 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return INSR3200 총 갯수
	 * @exception
	 */
	public int selectInsr3000RegChkCnt(Insr3200VO vo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("insr3200DAO.selectInsr3000RegChkCnt", vo);
	}
	
	/**************************** 엑셀 업로드 ****************************/
}