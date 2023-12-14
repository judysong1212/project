package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.resm.client.dto.Bass0350DTO;
import com.app.exterms.resm.server.vo.Bass0350SrhVO;
import com.app.exterms.resm.server.vo.Bass0350VO;

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

@Repository("ResmIfBass0350DAO")
public class ResmIfBass0350DAO extends EgovAbstractDAO {

    @Transactional
	public int saveBass0350(Bass0350DTO dto) throws Exception {
		return update("resmIfBass0350DAO.saveBass0350", dto);
	}
	@Transactional
    public String insertBass0350(Bass0350DTO dto) throws Exception {
        return (String) insert("resmIfBass0350DAO.insertBass0350", dto);
    }   
	
    @Transactional
	public int updateBass0350(Bass0350DTO dto) throws Exception {
		return update("resmIfBass0350DAO.updateBass0350", dto);
	}
    
    public void updateChrBass0350(Bass0350DTO dto)throws Exception {
		
		update("resmIfBass0350DAO.updateChrBass0350",dto);
	}
    

    @Transactional
	public int deleteBass0350(Bass0350DTO dto) throws Exception {
		return delete("resmIfBass0350DAO.deleteBass0350", dto);
	}

	@SuppressWarnings("rawtypes")
	public List selectBass0350List(Bass0350DTO dto) throws Exception {
		return list("resmIfBass0350DAO.selectBass0350List", dto);
	}

	public int selectBass0350ListTotCnt(Bass0350DTO dto) {
		return (Integer) getSqlMapClientTemplate().queryForObject("resmIfBass0350DAO.selectBass0350ListTotCnt", dto);
	} 
	
//	@SuppressWarnings("rawtypes")
//	public List selectBass0450ToBass0350List(Bass0360SrhVO srhVo) throws Exception {
//		return list("resmIfBass0350DAO.selectBass0450ToBass0350List_D", srhVo);
//	}
//	
//	public int selectBass0450ToBass0350ListTotCnt(Bass0360SrhVO srhVo) {
//		return (Integer) getSqlMapClientTemplate().queryForObject("resmIfBass0350DAO.selectBass0450ToBass0350ListTotCnt_S", srhVo);
//	}	
	
	/** 개편전 직종세 개수 가져옴 **/
	public int selectBassP035001ListTotCnt(Bass0350VO vo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("resmIfBass0350DAO.selectBassP035001ListTotCnt", vo);
	} 
	
	/** 개편전 직종세 가져옴 **/
    public List selectBassP035001List(Bass0350VO vo) throws Exception {
        return  list("resmIfBass0350DAO.selectBassP035001List", vo);
    }
    
    @Transactional
	public int updateBassP035001(Bass0350VO vo) throws Exception {
		return update("resmIfBass0350DAO.updateBassP035001", vo);
	}
    
    /**
	 * BASS0320 Excel 데이터를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0320 Excel
	 * @exception
	 */
	public List selectXlsBass0350List(Bass0350SrhVO bass0350SrhVo) {
		
		return list("resmIfBass0350DAO.selectXlsBass0350List_D", bass0350SrhVo);
	}
	
	public int selectXlsBass0350ListTotCnt(Bass0350VO bass0350Vo) {
			
		return (Integer) getSqlMapClientTemplate().queryForObject("resmIfBass0350DAO.selectXlsBass0350ListTotCnt", bass0350Vo);
	}
	 
	public String insertXlsBass0350(Bass0350VO bass0350vo)throws Exception {
		
		return (String)insert("resmIfBass0350DAO.insertXlsBass0350_S",bass0350vo);
	}
	
	public void updateXlsBass0350(Bass0350VO bass0350vo)throws Exception {
		
		update("resmIfBass0350DAO.updateXlsBass0350_S",bass0350vo);
	}
	

    /**
	 * PSNL2100 Excel 데이터를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0320 Excel
	 * @exception
	 */	
	
	public List selectXlsPsnl2100ToBass0350List(Bass0350SrhVO bass0350SrhVo) {
		
		return list("resmIfBass0350DAO.selectXlsPsnl2100ToBass0350List_D", bass0350SrhVo);
	}
	
}
