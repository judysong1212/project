package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Dlgn0300ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.dlgn.server.service.dao.Dlgn0300DAO;
import com.app.exterms.dlgn.server.vo.Dlgn0300SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("Dlgn0300ExcelService")
public class Dlgn0300ExcelServiceImpl extends AbstractServiceImpl implements Dlgn0300ExcelService {
    
    @Autowired 
    @Resource(name="Dlgn0300DAO")
    private Dlgn0300DAO dlgn0300DAO;
   
 
  public List  selectXlsFileDlgn0300List(Dlgn0300SrhVO dlgn0300SrhVo) throws Exception {
      return dlgn0300DAO.selectXlsFileDlgn0300List(dlgn0300SrhVo);
  }   
 
}
