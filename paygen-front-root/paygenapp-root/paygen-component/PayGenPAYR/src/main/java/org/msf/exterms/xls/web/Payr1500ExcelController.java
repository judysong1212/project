package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Payr1500ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.payroll.server.vo.Payr0410SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Payr1500ExcelController {
	
    private static final Logger logger = LoggerFactory.getLogger(Payr1500ExcelController.class);  
    private static final String calledClass = Payr1500ExcelController.class.getName();
    
    @Resource(name = "payr1500ExcelService")
    private Payr1500ExcelService payr1500ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */                         
    @RequestMapping(value="/exp/XlsFilePayr1500Export.do")   
    public ModelAndView xlsPayr1500Export(@ModelAttribute("Payr0410SrhVO") Payr0410SrhVO payr0410SrhVo, HttpServletRequest request ,ModelMap model) 
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
        	
	        payr0410SrhVo.setDpobCd(sessionUser.getDpobCd());
	        //payr0410SrhVo.setPayYr(MSFSharedUtils.allowNulls(payr0410SrhVo.getPayYr()));
	        //payr0410SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(payr0410SrhVo.getTypOccuCd()));
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr0410SrhVo.getDtilOccuInttnCd())); 
	        payr0410SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        //payr0410SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(payr0410SrhVo.getDtilOccuInttnCd())); //직종세
	        //payr0410SrhVo.setPymtDducDivCd(MSFSharedUtils.allowNulls(payr0410SrhVo.getPymtDducDivCd()));
	        //payr0410SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(payr0410SrhVo.getPayrMangDeptCd())) ;   //단위기관코드
	
	        List listPayr1500 = payr1500ExcelService.selectXlsInsr1500List(payr0410SrhVo);
	        
	        String strValue = "";
	        List<EgovMap> excelList = new ArrayList<EgovMap>();
			 for(int i=0; i<listPayr1500.size(); i++){
				 
		    		EgovMap eMap  = new EgovMap();
		    		eMap = (EgovMap) listPayr1500.get(i);
		    		
		    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
			    		
		    			
		    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("payFamyResnRegnNum", strValue);
		    			
		    		excelList.add(eMap);
		    	}
	        
	        
//	        Map<String, Object> map = new HashMap<String, Object>(); 
	        map = new HashMap<String, Object>(); 
	    	map.put("listPayr1500", listPayr1500);
	    	
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
    	
    	return new ModelAndView("payr1500ExcelView", map);
       
    }
}
