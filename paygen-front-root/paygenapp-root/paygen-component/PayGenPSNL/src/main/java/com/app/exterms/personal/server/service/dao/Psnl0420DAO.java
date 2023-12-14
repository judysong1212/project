package com.app.exterms.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.client.dto.Psnl0420DTO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("psnl0420DAO")
public class Psnl0420DAO extends EgovAbstractDAO implements IsSerializable{
	
	
	@SuppressWarnings("rawtypes")
	public List selectPsnl0420(Psnl0420DTO psnl0420dto) {
		return list("psnl0420DAO.selectPsnl0420", psnl0420dto);
	}
	
	@Transactional
	public int updateIssueOk(Psnl0420DTO pnsl0420dto){
		return update("psnl0420DAO.updateIssueOk", pnsl0420dto);
	}
	
}
