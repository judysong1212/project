package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Payr4210ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.server.service.dao.Payr0350DAO;
import com.app.exterms.payroll.server.vo.Payr0350SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("payr4210ExcelService")
public class Payr4210ExcelServiceImpl extends AbstractServiceImpl implements Payr4210ExcelService {
    
    
  @Autowired
  @Resource(name="Payr0350DAO")
  private Payr0350DAO payr0350DAO;
     
  public List  selectXlsPayr4210List(Payr0350SrhVO   payr0350SrhVO) throws Exception {
    return payr0350DAO.selectXlsPayr4210List(payr0350SrhVO);
	 
  } 
  
   
 
}
