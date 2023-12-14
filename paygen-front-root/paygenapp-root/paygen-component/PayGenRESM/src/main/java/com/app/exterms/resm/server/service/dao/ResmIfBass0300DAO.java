package com.app.exterms.resm.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.resm.server.vo.Bass0300SrhVO;
import com.app.exterms.resm.server.vo.Bass0300VO;
import com.app.exterms.resm.server.vo.Bass0350SrhVO;
import com.app.exterms.resm.server.vo.Bass0350VO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Bass0300DAO.java
 * @Description : Bass0300 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("ResmIfBass0300DAO")
public class ResmIfBass0300DAO extends EgovAbstractDAO {
	
	
	@Transactional
    public String insertBass0300(Bass0300VO bass0300Vo) throws Exception {
        return (String) insert("resmIfBass0300DAO.insertResm0100ToBass0300_S", bass0300Vo);
    }   
	
    @Transactional
	public int updateBass0300(Bass0300VO bass0300Vo) throws Exception {
		return update("resmIfBass0300DAO.updateResm0100ToBass0300_S", bass0300Vo);
	}    

    @Transactional
	public int deleteBass0300(Bass0300VO bass0300Vo) throws Exception {
		return delete("resmIfBass0300DAO.deleteResm0100ToBass0300_S", bass0300Vo);
	}

	@SuppressWarnings("rawtypes")
	public List selectBass0300List(Bass0300SrhVO searchVO) throws Exception {
		return list("resmIfBass0300DAO.selectResm0100ToBass0300List_D", searchVO);
	}


	
	public int selectBass0300ListTotCnt(Bass0300SrhVO searchVO) {
		return (Integer) getSqlMapClientTemplate().queryForObject("resmIfBass0300DAO.selectResm0100ToBass0300ListTotCnt_S", searchVO);
	} 
	
	/******************************************************************************************************/
//	   @Transactional
//		public int updateBass0350(Bass0350VO vo) throws Exception {
//			return update("resmIfBass0300DAO.updateResm0100ToBass0350", vo);
//		}    
//	    
//		
//		@SuppressWarnings("rawtypes")
//		public List selectBass0350TopList(Bass0350SrhVO srhVo) throws Exception {
//			return list("resmIfBass0300DAO.selectResm0100ToBass0350TopList", srhVo);
//		}
		
		public int selectBass0350TopListTotCnt(Bass0350SrhVO srhVo) {
			return (Integer) getSqlMapClientTemplate().queryForObject("resmIfBass0300DAO.selectResm0100ToBass0350TopListTotCnt", srhVo);
		}	
		
//		@SuppressWarnings("rawtypes")
//		public List selectBass0350BottomList(Bass0350SrhVO srhVo) throws Exception {
//			return list("resmIfBass0300DAO.selectResm0100ToBass0350BottomList", srhVo);
//		}
//		
//		public int selectBass0350BottomListTotCnt(Bass0350SrhVO srhVo) {
//			return (Integer) getSqlMapClientTemplate().queryForObject("resmIfBass0300DAO.selectResm0100ToBass0350BottomListTotCnt", srhVo);
//		}	

}
