package org.msf.exterms.remt.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.remt.xls.service.Remt0150ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.retirement.server.service.dao.Remt2000DAO;
import com.app.exterms.retirement.server.vo.Remt2000SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("remt0150ExcelService")
public class Remt0150ExcelServiceImpl extends AbstractServiceImpl implements Remt0150ExcelService {
    
    
    @Autowired
    @Resource(name="Remt2000DAO")
    private Remt2000DAO remt2000DAO;
     
  public List selectXlsRemt0150List(Remt2000SrhVO   remt2000SrhVo) throws Exception {
      return remt2000DAO.selectXlsRemt0150List(remt2000SrhVo);
  } 

 
}
