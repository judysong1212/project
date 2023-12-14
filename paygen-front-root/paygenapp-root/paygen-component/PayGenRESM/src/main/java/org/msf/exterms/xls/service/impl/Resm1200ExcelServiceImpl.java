package org.msf.exterms.xls.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.msf.exterms.xls.service.Resm1200ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.prgm.server.utils.PrgmComUtils;
import com.app.exterms.resm.server.service.dao.ResmIfBass0350DAO;
import com.app.exterms.resm.server.vo.Bass0350SrhVO;
import com.app.exterms.resm.server.vo.Bass0350VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service("Resm1200ExcelService")
public class Resm1200ExcelServiceImpl extends AbstractServiceImpl implements Resm1200ExcelService  {

	private static final Logger logger = LoggerFactory.getLogger(Resm1200ExcelServiceImpl.class);
	private static final String calledClass = Resm1200ExcelService.class.getName();
    
    @Autowired 
    @Resource(name="ResmIfBass0350DAO")
    private ResmIfBass0350DAO bass0350DAO;
	
	
	@Override
	public List selectXlsFileBass0350List(Bass0350SrhVO bass0350SrhVo)throws Exception {
		
		return bass0350DAO.selectXlsBass0350List(bass0350SrhVo);
	}

	@Override
	public Long updateXlsBass0350(List<Bass0350VO> bass0350List, HttpServletRequest request, HttpServletResponse response) throws MSFException {
		
		Long result = new Long(0);
		Long iCnt = new Long(0);
		Bass0350VO bass0350vo = new Bass0350VO();  
		
//		List<Bass0350VO> errBass0350List = new ArrayList<Bass0350VO>();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		 				
		
		try {  
//			errBass0350List = new ArrayList<Bass0350VO>();			
			
			for(int iPsnlCnt=0;iPsnlCnt < bass0350List.size();iPsnlCnt++) {
				
				System.out.println("listsize======================"+bass0350List.size());
								
				bass0350vo = new Bass0350VO();  
				bass0350vo = bass0350List.get(iPsnlCnt);
										
				bass0350vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd())); /** set 사업장코드 : dpobCd *///	
				bass0350vo.setInptAddr(bass0350vo.getInptAddr());
				bass0350vo.setIsmt(bass0350vo.getIsmt());
				bass0350vo.setRevnAddr(bass0350vo.getRevnAddr());				
				
				//직종 유무 파악
				int iCount = bass0350DAO.selectXlsBass0350ListTotCnt(bass0350vo);
				
				//직종세 유무 파악
				int iCount2 = bass0350DAO.selectBassP035001ListTotCnt(bass0350vo);
				
				//직종의 유무를 조회한다.
				if(iCount > 0){	
					if(iCount2 > 0){
						iCnt = iCnt + 0;
						PrgmComUtils.responseAlert(response, "직종세가 이미 존재합니다. 확인 해주세요." );
					}else{
						bass0350DAO.insertXlsBass0350(bass0350vo);					
						bass0350DAO.updateXlsBass0350(bass0350vo);	
						iCnt = iCnt + 1;
					}
						
				}else{	
					//어떻게 해야 오류를 보내는지 모르겠음	
					iCnt = iCnt + 0;					
					PrgmComUtils.responseAlert(response, "입력 정보가 잘못됬습니다. 확인 해주세요." );
				}								
				
//				iCnt = iCnt + 1;		                    
			} 			
			result = new Long(1);
			
	        }catch (Exception ex) {
	        	
	            logger.error("EXCEPTION calling updateXlsBass0350(): "+ex); 
	            
	            result = new Long(0);
	            throw MSFServerUtils.getOperationException("updateXlsBass0350", ex, logger);
	        }
		
		return iCnt;
	}	

}
