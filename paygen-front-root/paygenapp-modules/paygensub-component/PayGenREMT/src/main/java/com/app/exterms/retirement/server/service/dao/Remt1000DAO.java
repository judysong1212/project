package com.app.exterms.retirement.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.retirement.server.vo.Remt1000SrhVO;
import com.app.exterms.retirement.server.vo.Remt1000VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Remt1000DAO.java
 * @Description : Remt1000 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.10.17
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Remt1000DAO")
public class Remt1000DAO extends EgovAbstractDAO {

	/**
	 * REMT1000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Remt1000VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
	public String insertRemt1000(Remt1000VO vo) {
		return (String)insert("remt1000DAO.insertRemt1000_S", vo);
	}

	/**
	 * REMT1000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Remt1000VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
	public void updateRemt1000(Remt1000VO vo) throws Exception {
		update("remt1000DAO.updateRemt1000_S", vo);
	}

	/**
	 * REMT1000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Remt1000VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
	public void deleteRemt1000(Remt1000VO vo) throws Exception {
		delete("remt1000DAO.deleteRemt1000_S", vo);
	}

	/**
	 * REMT1000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Remt1000VO
	 * @return 조회한 REMT1000
	 * @exception Exception
	 */
	public Remt1000VO selectRemt1000(Remt1000VO vo) throws Exception {
		return (Remt1000VO) selectByPk("remt1000DAO.selectRemt1000_S", vo);
	}

	/**
	 * REMT1000 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 Map
	 * @return REMT1000 목록
	 * @exception Exception
	 */
	public List selectRemt1000List(Remt1000SrhVO searchVO) {
		return list("remt1000DAO.selectRemt1000List_D", searchVO);
	}

	/**
	 * REMT1000 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 Map
	 * @return REMT1000 총 갯수
	 * @exception
	 */
	public int selectRemt1000ListTotCnt(Remt1000SrhVO searchVO) {
		return (Integer)getSqlMapClientTemplate().queryForObject("remt1000DAO.selectRemt1000ListTotCnt_S", searchVO);
	}


		/**
	 * REMT1000 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 Map
	 * @return REMT1000 목록
	 * @exception Exception
	 */
	public List selectRemt1000(Remt1000SrhVO searchVO) {
		return list("remt1000DAO.selectRemt1000List", searchVO);
	}

	/**
	 * 직종세통합코드 조회
	 * @return
	 */
	public List<Remt1000VO> selectDtilOccuInttnCdList() {
		return (List<Remt1000VO>)list("remt1000DAO.selectDtilOccuInttnCdList", null);
	}

	/**
	 * REMT1000 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 Map
	 * @return REMT1000 목록
	 * @exception Exception
	 */
	public List<Remt1000VO> selectXlsRemt1000List() {
		return (List<Remt1000VO>)list("remt1000DAO.selectXlsRemt1000List", null);
	}

	@Transactional
	public String insertXlsRemt1000(Remt1000VO remt1000VO)throws Exception {
		return (String)insert("remt1000DAO.insertXlsRemt1000",remt1000VO);
	}

	@Transactional
	public void updateXlsRemt1000(Remt1000VO remt1000VO)throws Exception {
		update("remt1000DAO.updateXlsRemt1000",remt1000VO);
	}
}
