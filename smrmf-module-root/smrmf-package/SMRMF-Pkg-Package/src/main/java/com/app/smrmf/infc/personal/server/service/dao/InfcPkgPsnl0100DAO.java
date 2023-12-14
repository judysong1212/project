package com.app.smrmf.infc.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.basis.client.dto.InfcComBass0500DTO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0100VO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : Psnl0100DAO.java
 * @Description : Psnl0100 DAO Class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Repository("InfcPkgPsnl0100DAO")
public class InfcPkgPsnl0100DAO extends EgovAbstractDAO implements IsSerializable{
	

	public List getBusinList(InfcComBass0500DTO sysComBass0500Dto)  throws Exception{
		return list("infcPkgPsnl0100DAO.getBusinList", sysComBass0500Dto);
	}
	
	@Transactional
    public void updatePsnl0100ToPayr4100(InfcPkgPsnl0100VO psnl0100Vo) throws Exception{
         update("infcPkgPsnl0100DAO.updatePsnl0100ToPayr4100", psnl0100Vo);
    }
	@Transactional
    public void updatePsnl0100ToPayr4100_2(InfcPkgPsnl0100VO psnl0100Vo) throws Exception{
         update("infcPkgPsnl0100DAO.updatePsnl0100ToPayr4100_2", psnl0100Vo);
    }
     
}
