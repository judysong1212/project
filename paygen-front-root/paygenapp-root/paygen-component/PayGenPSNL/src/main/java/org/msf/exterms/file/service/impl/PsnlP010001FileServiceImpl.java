package org.msf.exterms.file.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.msf.exterms.file.service.PsnlP010001FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.server.service.dao.Psnl0132DAO;
import com.app.exterms.personal.server.vo.Psnl0132SrhVO;
import com.app.exterms.personal.server.vo.Psnl0132VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("psnlP010001FileService")
public class PsnlP010001FileServiceImpl extends AbstractServiceImpl implements PsnlP010001FileService {
	
	private static final Logger logger = LoggerFactory.getLogger(PsnlP010001FileServiceImpl.class);
	private static final String calledClass = PsnlP010001FileService.class.getName();
    
    
    @Autowired 
    @Resource(name="Psnl0132DAO")
    private Psnl0132DAO psnl0132DAO;
    
    
    /** 관련 근거 파일정보의 파일크기를 update 처리**/
	@Override
	public int updatePsnl0132_REFE_FLSZ(Psnl0132VO psnl0132Vo, HttpServletRequest request)throws MSFException {
		
		// TODO Auto-generated method stub
		int result = 0;
		 MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		 
		
		try {  
			
			result = psnl0132DAO.updatePsnl0132_REFE_FLSZ(psnl0132Vo);
			
	          
	        } catch (Exception ex) {
	        	
	        	result = 0;
	            logger.error("EXCEPTION calling updatePsnl0132_REFE_FLSZ(): "+ex); 
	            throw MSFServerUtils.getOperationException("updatePsnl0132_REFE_FLSZ", ex, logger);
	            
	        }
		
	        finally {
	          
	        }
		return result;
	}
	
	/** 관련 근거 파일정보를 vo로 가져옴**/
	@Override
	public Psnl0132VO selectPsnl0132Data(Psnl0132SrhVO psnl0132SrhVo)throws MSFException {
		
		Psnl0132VO resultVo = new Psnl0132VO();
		
		// TODO Auto-generated method stub
		int result = 0;
//		 MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		 
		
		try {  
			
			resultVo = psnl0132DAO.selectPsnl0132Data(psnl0132SrhVo);
			
	          
	        } catch (Exception ex) {
	        	
	        	result = 0;
	            logger.error("EXCEPTION calling selectPsnl0132Data(): "+ex); 
	            throw MSFServerUtils.getOperationException("selectPsnl0132Data", ex, logger);
	            
	        }
		
	        finally {
	          
	        }
		return resultVo;
	}


  
}
