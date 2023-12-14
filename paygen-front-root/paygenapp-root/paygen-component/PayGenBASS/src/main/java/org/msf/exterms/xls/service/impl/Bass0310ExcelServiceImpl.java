package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Bass0310ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.basis.server.service.dao.Bass0350DAO;
import com.app.exterms.basis.server.service.dao.Psnl2100DAO;
import com.app.exterms.basis.server.vo.Bass0350SrhVO;
import com.app.exterms.basis.server.vo.Psnl2100VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("bass0310ExcelService")
public class Bass0310ExcelServiceImpl extends AbstractServiceImpl implements Bass0310ExcelService  {

	private static final Logger logger = LoggerFactory.getLogger(Bass0310ExcelServiceImpl.class);
	private static final String calledClass = Bass0310ExcelService.class.getName();
    
    @Autowired 
    @Resource(name="Psnl2100DAO")
    private Psnl2100DAO psnl2100DAO;
	
    @Autowired 
    @Resource(name="Bass0350DAO")
    private Bass0350DAO bass0350DAO;
	
	@Override
	public List selectXlsFileBass0310List(Bass0350SrhVO bass0350SrhVo)throws Exception {
		
		return bass0350DAO.selectXlsPsnl2100ToBass0350List(bass0350SrhVo);
	}

	@Override
	public Long updateXlsBass0310(List<Psnl2100VO> psnl2100List, HttpServletRequest request) throws MSFException {
		
		Long result = new Long(0);
		Long iCnt = new Long(0);
		Psnl2100VO psnl2100vo = new Psnl2100VO();  
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		 				
		
		try {  		
			
			for(int iPsnlCnt=0;iPsnlCnt < psnl2100List.size();iPsnlCnt++) {
				
				System.out.println("listsize======================"+psnl2100List.size());
								
				psnl2100vo = new Psnl2100VO();
				
				psnl2100vo = psnl2100List.get(iPsnlCnt);
				
				psnl2100vo.setDpobCd(sessionUser.getDpobCd());
				psnl2100vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
				psnl2100vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				psnl2100vo.setIsmt(sessionUser.getUsrId());
				psnl2100vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				psnl2100DAO.insertXlsPsnl2100(psnl2100vo);
				
				iCnt = iCnt + 1;
					                    
			} 
			result = new Long(1);
	          
	        } catch (Exception ex) {
	        	
	            logger.error("EXCEPTION calling updateXlsBass0310(): "+ex); 
	            
	            result = new Long(0);
	            throw MSFServerUtils.getOperationException("updateXlsBass0310", ex, logger);
	        }
	        finally {
	          
	        }
		
		return iCnt;
	}
	

}
