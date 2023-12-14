package com.app.exterms.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.personal.client.dto.Psnl0290DTO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("psnl0290DAO")
public class Psnl0290DAO extends EgovAbstractDAO implements IsSerializable{
	
	
    @Transactional
	public String insertPsnl0290(Psnl0290DTO psnl0290Dto) throws Exception{
		return (String) insert("psnl01290DAO.insertPsnl0290",psnl0290Dto);
	}
	
    @Transactional
	public int updatePsnl0290(Psnl0290DTO psnl0290Dto) throws Exception{
		return update("psnl0290DAO.updatePsnl0290", psnl0290Dto);
		
	}
    
    
    @Transactional
	public int updatePsnl0290Fix(Psnl0290DTO psnl0290Dto) throws Exception{
		return update("psnl0290DAO.updatePsnl0290Fix", psnl0290Dto);
		
	}
	
    @Transactional
	public int deletePsnl0290(Psnl0290DTO psnl0290Dto) throws Exception{
		return delete("psnl0290DAO.deletePsnl0290",psnl0290Dto);
		
	}

	@SuppressWarnings("rawtypes")
	public List selectPsnl0290(Psnl0290DTO psnl0290Dto) {
		return list("psnl0290DAO.selectPsnl0290", psnl0290Dto);
	}

}
