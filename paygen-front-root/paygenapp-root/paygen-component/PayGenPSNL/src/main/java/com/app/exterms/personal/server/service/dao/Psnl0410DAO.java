package com.app.exterms.personal.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.exterms.personal.client.dto.Psnl0410DTO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("psnl0410DAO")
public class Psnl0410DAO extends EgovAbstractDAO implements IsSerializable{
	
	
	@SuppressWarnings("rawtypes")
	public List selectPsnl0410(Psnl0410DTO psnl0410dto) {
		return list("psnl0410DAO.selectPsnl0410", psnl0410dto);
	}

}
