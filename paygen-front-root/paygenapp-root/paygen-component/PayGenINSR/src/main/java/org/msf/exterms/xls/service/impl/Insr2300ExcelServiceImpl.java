package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Insr2300ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.dao.Insr1600DAO;
import com.app.exterms.insurance.server.service.dao.Insr2100DAO;
import com.app.exterms.insurance.server.service.dao.Insr2200DAO;
import com.app.exterms.insurance.server.vo.Insr1600VO;
import com.app.exterms.insurance.server.vo.Insr2100VO;
import com.app.exterms.insurance.server.vo.Insr2200SrhVO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("insr2300ExcelService")
public class Insr2300ExcelServiceImpl extends AbstractServiceImpl implements Insr2300ExcelService {
    
    @Autowired 
    @Resource(name="Insr2200DAO")
    private Insr2200DAO insr2200DAO;
    
    @Resource(name="Insr2100DAO")
    private Insr2100DAO insr2100DAO;
    
    @Resource(name="Insr1600DAO")
    private Insr1600DAO insr1600DAO;
    
    private static final Logger logger = LoggerFactory.getLogger(Insr2300ExcelServiceImpl.class);
    
   public  List selectXlsInsr2200List(Insr2200SrhVO insr2200SrhVo) throws Exception {
      return insr2200DAO.selectXlsInsr2200List(insr2200SrhVo);
    }
  
	
   public Long updateXlsInsr2100(Insr2100VO insr2100Vo) throws MSFException {
	   Long  result = new Long(0);
	  
	   try 
	   {  
		   insr2100DAO.updateInsr2100(insr2100Vo);
		   result = 1L; 
	   }
	   catch (Exception ex) {
		   logger.error("EXCEPTION calling updateXlsInsr2100(): "+ex); 
		   result = new Long(0);
		   throw MSFServerUtils.getOperationException("updateXlsInsr2100", ex, logger);
	   }
	   finally {
	   }
	   return result;
   }
   
   public Long updateXlsInsr2100Each(Insr2100VO insr2100Vo) throws MSFException {
	   Long  result = new Long(0);
	  
	   try 
	   {  
		   insr2100DAO.updateInsr2100Each(insr2100Vo);
		   result = 1L; 
	   }
	   catch (Exception ex) {
		   logger.error("EXCEPTION calling updateXlsInsr2100(): "+ex); 
		   result = new Long(0);
		   throw MSFServerUtils.getOperationException("updateXlsInsr2100", ex, logger);
	   }
	   finally {
	   }
	   return result;
   }
   
	public int selectInsr1600Check(Insr1600VO vo) throws MSFException {
		int result = 0;
		try {
			result = insr1600DAO.selectInsr1600Check(vo);
			} catch (Exception e) {
			logger.error("EXCEPTION calling selectInsr1600Check(): "+e); 
			result = 0;
			throw MSFServerUtils.getOperationException("selectInsr1600Check", e, logger);
		}
		return result;
    }
	
    public void updateInsr1600(Insr1600VO vo) throws MSFException {
    	try {
			insr1600DAO.updateInsr1600(vo);
		} catch (Exception e) {
			logger.error("EXCEPTION calling updateInsr1600(): "+e); 
			throw MSFServerUtils.getOperationException("updateInsr1600", e, logger);
		}
     }
}
