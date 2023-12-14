package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.msf.exterms.xls.service.Resm1100ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.resm.server.service.dao.ResmIfBass0320DAO;
import com.app.exterms.resm.server.vo.Bass0320SrhVO;
import com.app.exterms.resm.server.vo.Bass0320VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("Resm1100ExcelService")
public class Resm1100ExcelServiceImpl extends AbstractServiceImpl implements Resm1100ExcelService  {

	private static final Logger logger = LoggerFactory.getLogger(Resm1100ExcelServiceImpl.class);
	private static final String calledClass = Resm1100ExcelService.class.getName();
    
    @Autowired 
    @Resource(name="ResmIfBass0320DAO")
    private ResmIfBass0320DAO bass0320DAO;
	
	
	@Override
	public List selectXlsFileBass0320List(Bass0320SrhVO bass0320SrhVo)throws Exception {
		
		return bass0320DAO.selectXlsBass0320List(bass0320SrhVo);
	}

	@Override
	public Long updateXlsBass0320(List<Bass0320VO> bass0320List, HttpServletRequest request) throws MSFException {
		
		Long result = new Long(0);
		Long iCnt = new Long(0);
		Bass0320VO bass0320vo = new Bass0320VO();  
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		 				
		
		try {  		
			
			for(int iPsnlCnt=0;iPsnlCnt < bass0320List.size();iPsnlCnt++) {
				
				System.out.println("listsize======================"+bass0320List.size());
								
				bass0320vo = new Bass0320VO();  
				bass0320vo = bass0320List.get(iPsnlCnt);
										
				bass0320vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd())); /** set 사업장코드 : dpobCd *///	
				bass0320vo.setInptAddr(bass0320vo.getInptAddr());
				bass0320vo.setIsmt(bass0320vo.getIsmt());
				bass0320vo.setRevnAddr(bass0320vo.getRevnAddr());				
				
				if(bass0320vo.getTypOccuStdt() == bass0320vo.getTypOccuEddt()){
					return 0L;
					
				}else{
					bass0320DAO.insertXlsBass0320(bass0320vo);
					bass0320DAO.updateXlsBass0320(bass0320vo);
				}				
			
				iCnt = iCnt + 1;		                    
			} 
			result = new Long(1);
	          
	        } catch (Exception ex) {
	        	
	            logger.error("EXCEPTION calling updateXlsBass0320(): "+ex); 
	            
	            result = new Long(0);
	            throw MSFServerUtils.getOperationException("updateXlsBass0320", ex, logger);
	        }
	        finally {
	          
	        }
		
		return iCnt;
	}
	

}
