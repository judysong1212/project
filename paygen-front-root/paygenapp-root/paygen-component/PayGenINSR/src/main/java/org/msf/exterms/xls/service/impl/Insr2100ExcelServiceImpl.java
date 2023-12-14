package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.msf.exterms.xls.service.Insr2100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.server.service.dao.Insr1100DAO;
import com.app.exterms.insurance.server.service.dao.Insr1200DAO;
import com.app.exterms.insurance.server.service.dao.Insr1500DAO;
import com.app.exterms.insurance.server.service.dao.Insr1600DAO;
import com.app.exterms.insurance.server.vo.Insr1100VO;
import com.app.exterms.insurance.server.vo.Insr1200SrhVO;
import com.app.exterms.insurance.server.vo.Insr1550SrhVO;
import com.app.exterms.insurance.server.vo.Insr1550VO;
import com.app.exterms.insurance.server.vo.Insr1600VO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("insr2100ExcelService")
public class Insr2100ExcelServiceImpl extends AbstractServiceImpl implements Insr2100ExcelService {
    
	@Autowired 
    @Resource(name="Insr1100DAO")
    private Insr1100DAO insr1100DAO;
	
    @Autowired 
    @Resource(name="Insr1200DAO")
    private Insr1200DAO insr1200DAO;
    
    @Autowired 
    @Resource(name="Insr1500DAO")
    private Insr1500DAO insr1500DAO;
    
    @Autowired 
    @Resource(name="Insr1600DAO")
    private Insr1600DAO insr1600DAO;
    
    private static final Logger logger = LoggerFactory.getLogger(Insr2300ExcelServiceImpl.class);
     
  public  List selectXlsInsr1200List(Insr1200SrhVO insr1200SrhVo) throws Exception {
      return insr1200DAO.selectXlsInsr1200List(insr1200SrhVo);
  } 
  

 
  public int selectInsr1550Check(Insr1550VO vo) throws MSFException {
		int result = 0;
		try {
			result = insr1500DAO.selectInsr1550Check(vo);
			} catch (Exception e) {
			logger.error("EXCEPTION calling selectInsr1550Check(): "+e); 
			result = 0;
			throw MSFServerUtils.getOperationException("selectInsr1550Check", e, logger);
		}
		return result;
  }
	
  public void updateXlsInsr1550(Insr1550VO vo) throws MSFException {
  	try {
  		insr1500DAO.updateXlsInsr1550(vo);
		} catch (Exception e) {
			logger.error("EXCEPTION calling updateXlsInsr1550(): "+e); 
			throw MSFServerUtils.getOperationException("updateXlsInsr1550", e, logger);
		}
   }
  
  public Long updateXlsInsr1100(Insr1100VO insr1100Vo) throws MSFException {
	   Long  result = new Long(0);
	  
	   try 
	   {  
		   insr1100DAO.updateXlsInsr1100(insr1100Vo);
		   result = 1L; 
	   }
	   catch (Exception ex) {
		   logger.error("EXCEPTION calling updateXlsInsr1100(): "+ex); 
		   result = new Long(0);
		   throw MSFServerUtils.getOperationException("updateXlsInsr1100", ex, logger);
	   }
	   finally {
	   }
	   return result;
  }
  
  public Long updateXlsInsr1100Each(Insr1100VO insr1100Vo) throws MSFException {
	   Long  result = new Long(0);
	  
	   try 
	   {  
		   insr1100DAO.updateXlsInsr1100Each(insr1100Vo);
		   result = 1L; 
	   }
	   catch (Exception ex) {
		   logger.error("EXCEPTION calling updateXlsInsr1100Each(): "+ex); 
		   result = new Long(0);
		   throw MSFServerUtils.getOperationException("updateXlsInsr1100Each", ex, logger);
	   }
	   finally {
	   }
	   return result;
  }
  
  
  public  List selectXlsInsr1550List(Insr1550SrhVO insr1550SrhVo) throws Exception {
      return insr1500DAO.selectXlsInsr1550List(insr1550SrhVo);
  } 
  
  public  List selectXlsInsr1600List(Insr1550SrhVO insr1550SrhVo) throws Exception {
      return insr1600DAO.selectXlsInsr1600List(insr1550SrhVo);
  } 
  
  public void updateXlsInsr2150ToInsr1550(Insr1550VO vo) throws MSFException {
	  	try {
	  		insr1500DAO.updateXlsInsr2150ToInsr1550(vo);
			} catch (Exception e) {
				logger.error("EXCEPTION calling updateXlsInsr2150ToInsr1550(): "+e); 
				throw MSFServerUtils.getOperationException("updateXlsInsr2150ToInsr1550", e, logger);
			}
	   }
  
  public void updateXlsInsr2150ToInsr1600(Insr1600VO vo) throws MSFException {
	  	try {
	  		insr1600DAO.updateXlsInsr2150ToInsr1600(vo);
			} catch (Exception e) {
				logger.error("EXCEPTION calling updateXlsInsr2150ToInsr1600(): "+e); 
				throw MSFServerUtils.getOperationException("updateXlsInsr2150ToInsr1600", e, logger);
			}
	   }
}
