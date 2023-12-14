package com.app.smrmf.infc.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.basis.client.dto.InfcPkgBass0500DTO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0500SrhVO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0500VO;

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

@Repository("InfcPkgBass0500DAO")
public class InfcPkgBass0500DAO extends EgovAbstractDAO {
 
	@SuppressWarnings("rawtypes")
	public List getYearList(InfcPkgBass0500DTO dto) throws Exception {
		return list("infcPkgBass0500DAO.getYearList", dto);
	} 
	
	/** 현재 생성된 사업의 년도들을 가져옴 **/
	@SuppressWarnings("rawtypes")
	public List getCreBass0500BusinYrList(InfcPkgBass0500DTO dto) throws Exception {
		return list("infcPkgBass0500DAO.getBass0500BusinYrList", dto);
	}

	 /**
		 * PAYR0415 목록을 조회한다.
		 * @param searchMap - 조회할 정보가 담긴 Map
		 * @return PAYR0415 목록
		 * @exception Exception
		 */
	    public List selectBass0500PayYrList(InfcPkgBass0500SrhVO   searchVO) throws Exception {
	        return list("infcPkgBass0500DAO.selectBass0500PayYrList_D", searchVO);
	    }

	    /**
		 * PAYR0415 총 갯수를 조회한다.
		 * @param searchMap - 조회할 정보가 담긴 Map
		 * @return PAYR0415 총 갯수
		 * @exception
		 */
	    public int selectBass0500PayYrListTotCnt(InfcPkgBass0500SrhVO searchVO) {
	        return (Integer)getSqlMapClientTemplate().queryForObject("infcPkgBass0500DAO.selectBass0500PayYrListTotCnt_S", searchVO);
	    }
	    
	    @SuppressWarnings("rawtypes")
	    public List selectYeta2017ToBass0500OnList(InfcPkgBass0500SrhVO searchVO) throws Exception {
	    	return list("infcPkgBass0500DAO.selectYeta2017ToBass0500OnList_D", searchVO);
	    }
	    
	    public int selectYeta2017ToBass0500OnListTotCnt(InfcPkgBass0500SrhVO searchVO) {
	    	return (Integer) getSqlMapClientTemplate().queryForObject("infcPkgBass0500DAO.selectYeta2017ToBass0500OnListTotCnt_S", searchVO);
	    }
	    
	    @SuppressWarnings("rawtypes")
		public List selectYeta2017ToBass0500OffList(InfcPkgBass0500SrhVO searchVO) throws Exception {
			return list("infcPkgBass0500DAO.selectYeta2017ToBass0500OffList_D", searchVO);
		}
	    
	    public int selectYeta2017ToBass0500OffListTotCnt(InfcPkgBass0500SrhVO searchVO) {
			return (Integer) getSqlMapClientTemplate().queryForObject("infcPkgBass0500DAO.selectYeta2017ToBass0500OffListTotCnt_S", searchVO);
		}
	    
	    @Transactional
	    public int updateOnYeta2070ToBass0500(InfcPkgBass0500VO vo) throws Exception {
	    	return update("infcPkgBass0500DAO.updateOnYeta2070_S", vo);
	    }
	    
	    @Transactional
	    public int updateOffYeta2070ToBass0500(InfcPkgBass0500VO vo) throws Exception {
	    	return update("infcPkgBass0500DAO.updateOffYeta2070_S", vo);
	    }
	    

}
