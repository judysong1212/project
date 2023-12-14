package com.app.smrmf.infc.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0360SrhVO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0360VO;

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

@Repository("InfcPkgBass0360DAO")
public class InfcPkgBass0360DAO extends EgovAbstractDAO {
 
    
    /**
	 * BASS0360 갯수를 조회한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0360 총 갯수
	 */
    public int selectBass0360ListTotCnt(InfcPkgBass0360SrhVO infcBass0360SrhVo) {
        return (Integer)getSqlMapClientTemplate().queryForObject("InfcPkgBass0360DAO.selectBass0360ListTotCnt", infcBass0360SrhVo);
    }
    
    /**
	 * BASS0360 에 데이터를 insert 한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0360 총 갯수
	 */
	public String insertBass0360(InfcPkgBass0360VO infcBass0360Vo) throws Exception{
		return (String) insert("InfcPkgBass0360DAO.insertBass0360_S",infcBass0360Vo);
	}
	
    /**
	 * BASS0360 에 단위기관코드를 update 한다.
	 * @param searchMap - 조회할 정보가 담긴 Map
	 * @return BASS0360 총 갯수
	 */
	public int updateBass0360PayrMangDeptCd(InfcPkgBass0360VO infcBass0360Vo) throws Exception{
		return update("InfcPkgBass0360DAO.updateBass0360PayrMangDeptCd", infcBass0360Vo);
	}
	
	
	@SuppressWarnings("unchecked")
	public List getPayrMangDeptCd(InfcPkgBass0360SrhVO infcBass0360SrhVo) throws Exception {
        return list("InfcPkgBass0360DAO.getPayrMangDeptCd", infcBass0360SrhVo);
	} 
	

	


}
