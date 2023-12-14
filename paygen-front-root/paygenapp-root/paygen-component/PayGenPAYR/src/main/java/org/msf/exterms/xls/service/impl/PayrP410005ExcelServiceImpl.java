package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.PayrP410005ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.server.service.dao.Payr0530DAO;
import com.app.exterms.payroll.server.vo.Payr0530SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("payrP410005ExcelService")
public class PayrP410005ExcelServiceImpl extends AbstractServiceImpl implements PayrP410005ExcelService {
	
	private static final Logger logger = LoggerFactory.getLogger(PayrP410005ExcelServiceImpl.class);
	private static final String calledClass = PayrP410005ExcelServiceImpl.class.getName();
    
	
	@Autowired
	@Resource(name="Payr0530DAO")
	private Payr0530DAO payr0503DAO;
     

    /**
     * 가족수당대상자 리스트
     * @param payr0530SrhVO
     * @return
     * @throws Exception
     */
	@Override
	public List selectXlsPayrP410005List(Payr0530SrhVO payr0530SrhVO) throws Exception {
		// TODO Auto-generated method stub
		return payr0503DAO.selectXlsPayrP410005ToPayr0530List(payr0530SrhVO);
	}

	
}
