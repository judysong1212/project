package com.app.exterms.payroll.server.service.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.exterms.payroll.client.dto.Payr4700DTO;
import com.google.gwt.user.client.rpc.IsSerializable;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;


@Repository("payr4700DAO")
public class Payr4700DAO extends EgovAbstractDAO implements IsSerializable{
	
	
	@SuppressWarnings("rawtypes")
	public List selectPayr4700(Payr4700DTO payr4700dto) {
		return list("payr4700DAO.selectPayr4700", payr4700dto);
	}
	@Transactional
	public int updateIssueOk(Payr4700DTO pnsl0420dto){
		return update("payr4700DAO.updateIssueOk", pnsl0420dto);
	}
	
}
