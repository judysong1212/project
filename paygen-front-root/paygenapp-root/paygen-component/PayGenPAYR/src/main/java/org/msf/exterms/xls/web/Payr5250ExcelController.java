package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Payr5250ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.payroll.server.vo.Payr0416SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Payr5250ExcelController {
	
    private static final Logger logger = LoggerFactory.getLogger(Payr5250ExcelController.class);  
    private static final String calledClass = Payr5250ExcelController.class.getName();
    
    @Resource(name = "payr5250ExcelService")
    private Payr5250ExcelService payr5250ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */                         
    @RequestMapping(value="/exp/XlsFilePayr5250Export.do")   
    public ModelAndView xlsPayr5250Export(@ModelAttribute("Payr0416SrhVO") Payr0416SrhVO payr04160SrhVo, HttpServletRequest request ,ModelMap model) 
                    throws Exception {  

    	String method = calledClass + ".xlsPayr1500Export";
    	
    	String windowNm = "지급(공제)항목단가관리(공무직)";
		String windowId = "PAYR1500";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
        Map<String, Object> map = new HashMap<String, Object>(); 
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
		try{
        	
			payr04160SrhVo.setDpobCd(sessionUser.getDpobCd());
			payr04160SrhVo.setPayYr(MSFSharedUtils.allowNulls(payr04160SrhVo.getPayYr()));
			payr04160SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(payr04160SrhVo.getTypOccuCd()));
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr04160SrhVo.getDtilOccuInttnCd())); 
	        payr04160SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        payr04160SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(payr04160SrhVo.getDtilOccuInttnCd())); //직종세
	        payr04160SrhVo.setPymtDducDivCd(MSFSharedUtils.allowNulls(payr04160SrhVo.getPymtDducDivCd()));
	        payr04160SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(payr04160SrhVo.getPayrMangDeptCd())) ;   //단위기관코드
	        payr04160SrhVo.setDeptCd(payr04160SrhVo.getDeptCd());
	
	        
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	  if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(payr04160SrhVo.getDeptCd(),sessionUser.getDeptCd()))) {
         			 

                  	payr04160SrhVo.setDeptCd(sessionUser.getDeptCd()); 
                     listDeptCd.add(sessionUser.getDeptCd());
              	   } else {
              		 
              		 payr04160SrhVo.setDeptCd(MSFSharedUtils.allowNulls(payr04160SrhVo.getDeptCd()));
              	  }  
            	  
               payr04160SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	payr04160SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(payr04160SrhVo.getPayrMangDeptCd())) ;   //단위기관코드
                     if (payr04160SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(payr04160SrhVo.getDeptCd()))) { 
                    	 payr04160SrhVo.setDeptCd("");  //부서코드
                     } else {
                    	 payr04160SrhVo.setDeptCd(MSFSharedUtils.allowNulls(payr04160SrhVo.getDeptCd()));
                     } 
                  
            }
	        
	        List listPayr5250 = payr5250ExcelService.selectXlsPayr0416List(payr04160SrhVo);
	        
	        String strValue = "";
	        List<EgovMap> excelList = new ArrayList<EgovMap>();
			 for(int i=0; i<listPayr5250.size(); i++){
				 
		    		EgovMap eMap  = new EgovMap();
		    		eMap = (EgovMap) listPayr5250.get(i);
		    		
		    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
			    		
		    			
		    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("payFamyResnRegnNum", strValue);
		    			
		    		excelList.add(eMap);
		    	}
	        
	        
//	        Map<String, Object> map = new HashMap<String, Object>(); 
	        map = new HashMap<String, Object>(); 
	    	map.put("listPayr5250", excelList);
	    	
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        }
    	
    	return new ModelAndView("payr5250ExcelView", map);
       
    }
}
