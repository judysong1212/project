package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.resm.client.dto.Bass0500DTO;
import com.app.exterms.resm.server.vo.Bass0500VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0500DAO.java
 * @Description : Bass0500 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.14
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("ResmIfBass0500DAO")
public class ResmIfBass0500DAO extends EgovAbstractDAO {

    @Transactional
	public int saveBass0500(Bass0500DTO dto) throws Exception {
		return update("resmIfBass0500DAO.saveBass0500", dto);
	}
    @Transactional
	public int deleteBass0500(Bass0500DTO dto) throws Exception {
		return delete("resmIfBass0500DAO.deleteBass0500", dto);
	}

	@SuppressWarnings("rawtypes")
	public List selectBass0500List(Bass0500DTO dto) throws Exception {
		return list("resmIfBass0500DAO.selectBass0500List", dto);
	}
	
	/** 이전 년도 사업 가져옴 **/
    public List selectBass0500BfrBusinYrList(Bass0500VO bass0500Vo) throws Exception {
        // TODO Auto-generated method stub
        return  list("resmIfBass0500DAO.getBass0500BfrBusinYrList", bass0500Vo);
    }
	public int selectBass0500BfrBusinYrListCnt(Bass0500VO bass0500Vo)  throws Exception {
		return (Integer) getSqlMapClientTemplate().queryForObject("resmIfBass0500DAO.getBass0500BfrBusinYrListCnt", bass0500Vo);
	}
	
	@Transactional
	public String insertBass0500(Bass0500VO bass0500Vo) throws Exception{
		return (String) insert("resmIfBass0500DAO.insertBass0500",bass0500Vo);
	}
	
    
	@SuppressWarnings("rawtypes")
	public List getBass0400List(Bass0500DTO dto) throws Exception {
		return list("resmIfBass0500DAO.getBass0400List", dto);
	}
	
	
	/** 현재 생성된 사업의 년도들을 가져옴 **/
	@SuppressWarnings("rawtypes")
	public List getCreBass0500BusinYrList(Bass0500DTO dto) throws Exception {
		return list("resmIfBass0500DAO.getBass0500BusinYrList", dto);
	}
	
	public int selectBass0500ListTotCnt(Bass0500DTO dto) {
		return (Integer) getSqlMapClientTemplate().queryForObject("resmIfBass0500DAO.selectBass0500ListTotCnt", dto);
	}

}
