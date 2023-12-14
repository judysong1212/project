package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.PayrP420002ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.server.service.dao.Payr0304DAO;
import com.app.exterms.payroll.server.vo.Payr0304SrhVO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("payrP420002ExcelService")
public class PayrP420002ExcelServiceImpl extends AbstractServiceImpl implements PayrP420002ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(PayrP420002ExcelServiceImpl.class);
	private static final String calledClass = PayrP420002ExcelService.class.getName();
    
	@Autowired
	@Resource(name="Payr0304DAO")
	private Payr0304DAO payr0304DAO;
     

	//급여지급대상자 양식저장
	@Override
	public List selectXlsFilePayr304_307ToPayr4200List(Payr0304SrhVO payr0304SrhVO) throws MSFException {
		// TODO Auto-generated method stub
		return payr0304DAO.selectXlsFilePayr0304ToPayr4200LList(payr0304SrhVO);
	}

	
}
