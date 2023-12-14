package com.app.exterms.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.basis.client.dto.Bass0150DTO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("Bass0150DAO")
public class Bass0150DAO extends EgovAbstractDAO {

	@SuppressWarnings("rawtypes")
	public List getDpobCd() throws Exception {
		return list("bass0150DAO.getDpobCd", null);
	}
	@Transactional
	public int saveBass0150(Bass0150DTO dto) throws Exception {
		return update("bass0150DAO.saveBass0150", dto);
	}
	@Transactional
	public int deleteBass0150(Bass0150DTO dto) throws Exception {
		return delete("bass0150DAO.deleteBass0150", dto);
	}

	@SuppressWarnings("rawtypes")
	public List selectBass0150List(Bass0150DTO dto) throws Exception {
		return list("bass0150DAO.selectBass0150List", dto);
	}

	public int selectBass0150ListTotCnt(Bass0150DTO dto) {
		return (Integer) getSqlMapClientTemplate().queryForObject(
				"bass0150DAO.selectBass0150ListTotCnt", dto);
	}

}
