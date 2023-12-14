package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.server.vo.Bass0350SrhVO;
import com.app.exterms.payroll.server.vo.Bass0350VO;

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

@Repository("Payr5020DAO")
public class Payr5020DAO extends EgovAbstractDAO {


	
    @Transactional
	public int updateBass0350(Bass0350VO vo) throws Exception {
		return update("payr5020DAO.updateBass0350", vo);
	}    
    
	
	@SuppressWarnings("rawtypes")
	public List selectBass0350TopList(Bass0350SrhVO srhVo) throws Exception {
		return list("payr5020DAO.selectBass0350TopList", srhVo);
	}
	
	public int selectBass0350TopListTotCnt(Bass0350SrhVO srhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("payr5020DAO.selectBass0350TopListTotCnt", srhVo);
	}	
	
	@SuppressWarnings("rawtypes")
	public List selectBass0350BottomList(Bass0350SrhVO srhVo) throws Exception {
		return list("payr5020DAO.selectBass0350BottomList", srhVo);
	}
	
	public int selectBass0350BottomListTotCnt(Bass0350SrhVO srhVo) {
		return (Integer) getSqlMapClientTemplate().queryForObject("payr5020DAO.selectBass0350BottomListTotCnt", srhVo);
	}	
	 
	
}
