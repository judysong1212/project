package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.client.dto.Bass0300DTO;
import com.app.exterms.payroll.server.vo.Bass0300SrhVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0350DAO.java
 * @Description : Bass0350 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("Payr5010DAO")
public class Payr5010DAO extends EgovAbstractDAO {

	
	@Transactional
    public String insertBass0300(Bass0300DTO dto) throws Exception {
        return (String) insert("payr5010DAO.insertBass0300_S", dto);
    }   
	
    @Transactional
	public int updateBass0300(Bass0300DTO dto) throws Exception {
		return update("payr5010DAO.updateBass0300_S", dto);
	}    

    @Transactional
	public int deleteBass0300(Bass0300DTO dto) throws Exception {
		return delete("payr5010DAO.deleteBass0300_S", dto);
	}

	@SuppressWarnings("rawtypes")
	public List selectBass0300List(Bass0300SrhVO searchVO) throws Exception {
		return list("payr5010DAO.selectBass0300List_D", searchVO);
	}

	public int selectBass0300ListTotCnt(Bass0300SrhVO searchVO) {
		return (Integer) getSqlMapClientTemplate().queryForObject("payr5010DAO.selectBass0300ListTotCnt_S", searchVO);
	} 
}
