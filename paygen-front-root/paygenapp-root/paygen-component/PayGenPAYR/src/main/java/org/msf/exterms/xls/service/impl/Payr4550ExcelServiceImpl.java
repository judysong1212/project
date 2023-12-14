package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Payr4500ExcelService;
import org.msf.exterms.xls.service.Payr4550ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.payroll.server.service.dao.Payr0301DAO;
import com.app.exterms.payroll.server.vo.Payr0301SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("payr4550ExcelService")
public class Payr4550ExcelServiceImpl extends AbstractServiceImpl implements Payr4550ExcelService {
    
    
    @Autowired
    @Resource(name="Payr0301DAO")
    private Payr0301DAO payr0301DAO;
     
  public List selectXlsPayr4550List(Payr0301SrhVO payr0301srhVo) throws Exception {
      return payr0301DAO.selectPayr0301To4550XlsList(payr0301srhVo);
  } 


   
 
}
