package com.app.exterms.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.basis.client.dto.Bass0400DTO;
import com.app.exterms.basis.server.vo.Bass0400SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0400DAO.java
 * @Description : Bass0400 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Bass0400DAO")
public class Bass0400DAO extends EgovAbstractDAO {

    @Transactional
	public int saveBass0400(Bass0400DTO dto) throws Exception {
		return update("bass0400DAO.saveBass0400", dto);
	}
    @Transactional
	public int deleteBass0400(Bass0400DTO dto) throws Exception {
		return delete("bass0400DAO.deleteBass0400", dto);
	}

	@SuppressWarnings("rawtypes")
	public List selectBass0400List(Bass0400DTO dto) throws Exception {
		return list("bass0400DAO.selectBass0400List", dto);
	}
	
	@SuppressWarnings("rawtypes")
	public List getBass0150List(Bass0400DTO dto) throws Exception {
		return list("bass0400DAO.getBass0150List", dto);
	}
	
	public int selectBass0400ListTotCnt(Bass0400DTO dto) {
		return (Integer) getSqlMapClientTemplate().queryForObject("bass0400DAO.selectBass0400ListTotCnt", dto);
	}
	
	
	@SuppressWarnings("rawtypes")
	public List selectBass0450ToBass0400List(Bass0400SrhVO Srhvo) throws Exception {
		return list("bass0400DAO.selectBass0450ToBass0400List", Srhvo);
	}	
	public int selectBass0450ToBass0400ListTotCnt(Bass0400SrhVO Srhvo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("bass0400DAO.selectBass0450ToBass0400ListTotCnt", Srhvo);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectBass0450List_Right_Up(Bass0400SrhVO Srhvo) throws Exception {
		return list("bass0400DAO.selectBass0450List", Srhvo);
	}
}
