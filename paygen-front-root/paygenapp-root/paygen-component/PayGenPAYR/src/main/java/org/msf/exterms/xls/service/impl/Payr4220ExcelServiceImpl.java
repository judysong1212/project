package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Payr4220ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.server.service.dao.Payr0303DAO;
import com.app.exterms.payroll.server.vo.Payr0303SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("payr4220ExcelService")
public class Payr4220ExcelServiceImpl extends AbstractServiceImpl implements Payr4220ExcelService {
    
    
  @Autowired
  @Resource(name="Payr0303DAO")
  private Payr0303DAO payr0303DAO;
     
  public List  selectXlsPayr4220List(Payr0303SrhVO   payr0303SrhVO) throws Exception {
      return payr0303DAO.selectXlsPayr4220List(payr0303SrhVO);
  } 
  
   
}
