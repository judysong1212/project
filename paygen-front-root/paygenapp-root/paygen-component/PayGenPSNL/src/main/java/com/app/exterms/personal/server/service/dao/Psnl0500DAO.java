package com.app.exterms.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.client.dto.Psnl0500DTO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("psnl0500DAO")
public class Psnl0500DAO extends EgovAbstractDAO implements IsSerializable{
	
	
	@SuppressWarnings("rawtypes")
	public List selectPsnl0500(Psnl0500DTO psnl0500dto) {
		return list("psnl0500DAO.selectPsnl0500", psnl0500dto);
	}
	
	@Transactional
	public String insertPsnl0560(Psnl0500DTO psnl0500dto) throws Exception{
		return (String) insert("psnl0500DAO.insertPsnl0560",psnl0500dto);
	}
	
	public String getPsptIssNum() throws Exception{
		return (String)getSqlMapClientTemplate().queryForObject("psnl0500DAO.getPsptIssNum");
	}
	
	
}
