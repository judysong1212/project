package com.app.smrmf.infc.basis.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0400SrhVO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0400VO;
import com.ext.dao.OtherAbstractDAO;

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

@Repository("InfcPkgOther0400DAO")
public class InfcPkgOther0400DAO  extends OtherAbstractDAO {
 
	@SuppressWarnings("rawtypes")
	public List selectBass0400PiOrgCode(InfcPkgBass0400SrhVO vo) throws Exception {
		return list("infcPkgOther0400DAO.selectBass0400PiOrgCode", vo);
	} 
	 
	@Transactional
	public int deleteBass0400(InfcPkgBass0400VO vo) throws Exception {
		return delete("infcPkgOther0400DAO.deleteBass0400", vo);
	}
	
	
	@Transactional
	public int insertBass0400(InfcPkgBass0400VO vo) throws Exception {
		return (Integer) insert("infcPkgOther0400DAO.insertBass0400", vo);
	}
	

}
