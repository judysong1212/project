package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Payr4500ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.server.service.dao.Payr0305DAO;
import com.app.exterms.payroll.server.vo.Payr0305SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("payr4500ExcelService")
public class Payr4500ExcelServiceImpl extends AbstractServiceImpl implements Payr4500ExcelService {
    
    
    @Autowired
    @Resource(name="Payr0305DAO")
    private Payr0305DAO payr0305DAO;
     
  public List selectXlsPayr4400List(Payr0305SrhVO payr0305SrhVO) throws Exception {
      return payr0305DAO.selectPayr0305XlsList(payr0305SrhVO);
  } 


   
 
}
