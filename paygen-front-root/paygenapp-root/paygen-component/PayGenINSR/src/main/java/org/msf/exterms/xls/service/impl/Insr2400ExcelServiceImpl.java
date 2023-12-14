package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Insr2400ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.dao.Insr2500DAO;
import com.app.exterms.insurance.server.vo.Insr2200SrhVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("insr2400ExcelService")
public class Insr2400ExcelServiceImpl extends AbstractServiceImpl implements Insr2400ExcelService {
    
    @Autowired 
    @Resource(name="Insr2500DAO")
    private Insr2500DAO insr2500DAO;
    
    private static final Logger logger = LoggerFactory.getLogger(Insr2400ExcelServiceImpl.class);
    
   public  List selectXlsInsr2400List(Insr2200SrhVO insr2200SrhVo) throws Exception {
      return insr2500DAO.selectXlsInsr2500List(insr2200SrhVo);
    }
   public  List selectXlsInsrP230006(Insr2200SrhVO insr2200SrhVo) throws Exception {
	      return insr2500DAO.selectXlsInsrP230006(insr2200SrhVo);
	    }
	
   
}
