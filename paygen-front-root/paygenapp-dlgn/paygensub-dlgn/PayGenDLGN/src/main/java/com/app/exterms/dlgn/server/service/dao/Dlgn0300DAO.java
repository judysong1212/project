package com.app.exterms.dlgn.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.dlgn.client.dto.Dlgn0300DTO;
import com.app.exterms.dlgn.server.vo.Dlgn0300SrhVO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("Dlgn0300DAO")
public class Dlgn0300DAO extends EgovAbstractDAO implements IsSerializable {
	
	@SuppressWarnings("rawtypes")
	public List selectDlgn0300(Dlgn0300DTO dto) throws Exception {
		return list("dlgn0300DAO.selectDlgn0300", dto);
	}
	
	/**
	 * 근무실적 조회
	 * 관리 데이터
	 * @param dlgn0300SrhVo
	 * @return
	 * @throws Exception
	 */
	public List selectXlsFileDlgn0300List(Dlgn0300SrhVO dlgn0300SrhVo) throws Exception {
		return (List)list("dlgn0300DAO.selectXlsFileDlgn0300List_D", dlgn0300SrhVo);
	}
	
	/**
	 * 근무실적 관리 데이터
	 * @param dlgn0300SrhVo
	 * @return
	 * @throws Exception
	 */
	public List selectDlgn0300List(Dlgn0300SrhVO dlgn0300SrhVo) throws Exception {
		return list("dlgn0300DAO.selectDlgn0300List_D", dlgn0300SrhVo);
	}
	
	/**
	 * DLGN0100 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DLGN0100 총 갯수
	 * @exception
	 */
	public int selectDlgn0300ListTotCnt(Dlgn0300SrhVO searchVO) {
		return (Integer)getSqlMapClientTemplate().queryForObject("dlgn0300DAO.selectDlgn0300ListTotCnt_S", searchVO);
	}
	
	/**
	 * 근무실적 인쇄 관리 데이터
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DLGN0300 목록
	 * @throws Exception
	 */
	public List selectDlgnP030001ToDlgn0300List(Dlgn0300SrhVO dlgn0300SrhVo) {
		return list("dlgn0300DAO.selectDlgnP030001ToDlgn0300List", dlgn0300SrhVo);
	}
	
	/**
	 * DLGN0300 총 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return DLGN0300 총 갯수
	 * @throws
	 */
	public int selectDlgnP030001ToDlgn0300ListTotCnt(Dlgn0300SrhVO dlgn0300SrhVo) {
		return (Integer)getSqlMapClientTemplate().queryForObject("dlgn0300DAO.selectDlgnP030001ToDlgn0300ListTotCnt", dlgn0300SrhVo);
	}
}