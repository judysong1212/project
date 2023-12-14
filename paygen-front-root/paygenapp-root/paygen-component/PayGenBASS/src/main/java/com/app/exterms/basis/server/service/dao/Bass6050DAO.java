package com.app.exterms.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.basis.server.vo.Bass6050SrhVO;
import com.app.exterms.basis.server.vo.Bass6050VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("Bass6050DAO")
public class Bass6050DAO extends EgovAbstractDAO {

	/**
	 * REMT1000을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass6050VO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Transactional
	public String insertBass6050(Bass6050VO vo) {
		return (String)insert("bass6050DAO.insertBass6050_S", vo);
	}

	/**
	 * REMT1000을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass6050VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
	public void updateBass6050(Bass6050VO vo) throws Exception {
		update("bass6050DAO.updateBass6050_S", vo);
	}

	/**
	 * REMT1000을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass6050VO
	 * @return void형
	 * @exception Exception
	 */
	@Transactional
	public void deleteBass6050(Bass6050VO vo) throws Exception {
		delete("bass6050DAO.deleteBass6050_S", vo);
	}

	/**
	 * REMT1000을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass6050VO
	 * @return 조회한 REMT1000
	 * @exception Exception
	 */
	public Bass6050VO selectBass6050(Bass6050VO vo) throws Exception {
		return (Bass6050VO) selectByPk("bass6050DAO.selectBass6050_S", vo);
	}

	/**
	 * REMT1000 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 Map
	 * @return REMT1000 목록
	 * @exception Exception
	 */
	public List selectBass6050List(Bass6050SrhVO searchVO) {
		return list("bass6050DAO.selectBass6050List_D", searchVO);
	}

	/**
	 * REMT1000 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 Map
	 * @return REMT1000 총 갯수
	 * @exception
	 */
	public int selectBass6050ListTotCnt(Bass6050SrhVO searchVO) {
		return (Integer)getSqlMapClientTemplate().queryForObject("bass6050DAO.selectBass6050ListTotCnt_S", searchVO);
	}


		/**
	 * REMT1000 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 Map
	 * @return REMT1000 목록
	 * @exception Exception
	 */
	public List selectBass6050(Bass6050SrhVO searchVO) {
		return list("bass6050DAO.selectBass6050List", searchVO);
	}

	/**
	 * 직종세통합코드 조회
	 * @return
	 */
	public List<Bass6050VO> selectDtilOccuInttnCdList() {
		return (List<Bass6050VO>)list("bass6050DAO.selectDtilOccuInttnCdList", null);
	}

	/**
	 * REMT1000 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 Map
	 * @return REMT1000 목록
	 * @exception Exception
	 */
	public List<Bass6050VO> selectXlsBass6050List() {
		return (List<Bass6050VO>)list("bass6050DAO.selectXlsBass6050List", null);
	}

	@Transactional
	public String insertXlsBass6050(Bass6050VO bass6050VO)throws Exception {
		return (String)insert("bass6050DAO.insertXlsBass6050",bass6050VO);
	}

	@Transactional
	public void updateXlsBass6050(Bass6050VO bass6050VO)throws Exception {
		update("bass6050DAO.updateXlsBass6050",bass6050VO);
	}
}
