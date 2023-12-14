package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.InsrP310001ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.dao.Insr4100DAO;
import com.app.exterms.insurance.server.vo.Insr4100SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("InsrP310001ExcelService")
public class InsrP310001ExcelServiceImpl extends AbstractServiceImpl implements InsrP310001ExcelService {
     
    @Autowired 
    @Resource(name="Insr4100DAO")
    private Insr4100DAO insr4100DAO;
    
     
  public List selectXlsPInsr4100List(Insr4100SrhVO insr4100SrhVO) throws Exception {
      return insr4100DAO.selectXlsPInsr4100List(insr4100SrhVO);
  } 

    
  
}
