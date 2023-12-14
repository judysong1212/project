package com.app.smrmf.infc.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0150SrhVO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0150VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("InfcPkgBass0150DAO")
public class InfcPkgBass0150DAO extends EgovAbstractDAO {

	@SuppressWarnings("rawtypes")
	public List selectYeta2070ToBass0150List(InfcPkgBass0150SrhVO vo) throws Exception {
		return list("InfcPkgBass0150DAO.selectYeta2070ToBass0150List", vo);
	}

	public int selectYeta2070ToBass0150ListTotCnt(InfcPkgBass0150SrhVO vo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("InfcPkgBass0150DAO.selectYeta2070ToBass0150ListTotCnt", vo);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectYeta2070ToBass0120List(InfcPkgBass0150SrhVO vo) throws Exception {
		return list("InfcPkgBass0150DAO.selectYeta2070ToBass0120List", vo);
	}
	
	public int selectYeta2070ToBass0120ListTotCnt(InfcPkgBass0150SrhVO vo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("InfcPkgBass0150DAO.selectYeta2070ToBass0120ListTotCnt", vo);
	}
	
	@Transactional
    public int updateYeta2070ToBass0150(InfcPkgBass0150VO vo) throws Exception {
    	return update("InfcPkgBass0150DAO.updateYeta2070ToBass0150", vo);
    }

}
