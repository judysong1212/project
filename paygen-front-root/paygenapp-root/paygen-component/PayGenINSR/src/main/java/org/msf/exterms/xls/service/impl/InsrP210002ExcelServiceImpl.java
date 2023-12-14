package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.InsrP210002ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.dao.Insr1200DAO;
import com.app.exterms.insurance.server.vo.Insr1100SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("insrP210002ExcelService")
public class InsrP210002ExcelServiceImpl extends AbstractServiceImpl implements InsrP210002ExcelService {
    
    @Autowired 
    @Resource(name="Insr1200DAO")
    private Insr1200DAO insr1200DAO;
     
  public  List selectXlsInsrP210002ToInsr12000240List(Insr1100SrhVO insr1100SrhVo) throws Exception {
      return insr1200DAO.selectXlsInsrP210002ToInsr12000240List(insr1100SrhVo);
  } 
 
}
