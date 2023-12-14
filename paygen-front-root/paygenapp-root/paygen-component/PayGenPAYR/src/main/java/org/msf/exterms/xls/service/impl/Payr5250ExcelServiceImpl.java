package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Payr5250ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.server.service.dao.Payr0416DAO;
import com.app.exterms.payroll.server.vo.Payr0416SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("payr5250ExcelService")
public class Payr5250ExcelServiceImpl extends AbstractServiceImpl implements Payr5250ExcelService {

	@Autowired
	@Resource(name = "Payr0416DAO")
	private Payr0416DAO payr0416DAO;

	public  List selectXlsPayr0416List(Payr0416SrhVO payr0416SrhVo) throws Exception {
		
		 int iCheck= payr0416DAO.selectPayr0416ListTotCnt(payr0416SrhVo);  
         
         if(iCheck > 0 ) {
        	 payr0416SrhVo.setChkPayrMangDeptCd("Y");
         }else {
        	 payr0416SrhVo.setChkPayrMangDeptCd("N");
         }
         
		return payr0416DAO.selectXlsPayr0416List(payr0416SrhVo);
	}
}
