package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Sysm0900ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.AnyWebServerUtils;
import com.app.smrmf.sysm.server.vo.SysIfSysm0900SrhVO;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Sysm0900ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Sysm0900ExcelController.class);  
 
    
    @Resource(name = "sysm0900ExcelService")
    private Sysm0900ExcelService sysm0900ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    

    /**
     * 엑셀파일로 출력한다. (상단버튼)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
	@RequestMapping(value="/exp/XlsSysm0900Export.do")
	public ModelAndView xlsFileHist0100Export(@ModelAttribute("Sysm0900SrhVO") SysIfSysm0900SrhVO sysm0900SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
        
        
		MSFUserInfoVO sessionUser = AnyWebServerUtils.getLoggedUser(request);
        String viewStr = "";
        
        
        String strValue = "";
        String strFamValue = "";
        
        if  (SmrmfUtils.paramNull(sysm0900ExcelService)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            sysm0900ExcelService = (Sysm0900ExcelService) wac.getBean("Sysm0900ExcelService" ); 
        }
        
        /** 조건절 */
        sysm0900SrhVo.setDpobCd(sessionUser.getDpobCd());													/** column 사업장코드 : dpobCd */
        sysm0900SrhVo.setEmymtDivCd(SmrmfUtils.allowNulls(sysm0900SrhVo.getEmymtDivCd()));    			/** column 사용자접속구분코드 : usrConnectDivCd */
        sysm0900SrhVo.setDataType(sysm0900SrhVo.getDataType()); 											// 조회구분
         
     	List  listSysm0900 = sysm0900ExcelService.selectXlsSysm0900List(sysm0900SrhVo);
     	
	    String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		List<EgovMap> excelList = new ArrayList<EgovMap>();

		for(int i=0; i<listSysm0900.size(); i++){
			EgovMap eMap  = new EgovMap();
			eMap = (EgovMap) listSysm0900.get(i);
			
			
			// 주민번호
			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,SmrmfUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
			eMap.put("resnRegnNum", strValue);
			excelList.add(eMap);
			
			// 가족 주민번호
			strFamValue = AnyCryptUtils.getDecSyncCrypt(nResult,SmrmfUtils.allowNulls(eMap.get("famyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
			eMap.put("famyResnRegnNum", strValue);
			excelList.add(eMap);
		
		}     	
     	
     	
     	
     	
     	if("PSNL0100".equals(sysm0900SrhVo.getDataType())) {
     		viewStr = "sysm090001ExcelView";
     	}else {
     		viewStr = "sysm090002ExcelView";
     	}
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("listSysm0900", listSysm0900);
        
        return new ModelAndView(viewStr, map);
	}
    
}
