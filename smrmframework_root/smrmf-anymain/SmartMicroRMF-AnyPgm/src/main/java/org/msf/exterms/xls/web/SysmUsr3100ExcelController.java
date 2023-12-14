package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.msf.exterms.xls.service.SysmUsr3100ExcelService;
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

import com.app.smrmf.core.msfmainapp.server.utils.AnyWebServerUtils;
import com.app.smrmf.sysm.server.vo.SysIfHist0100SrhVO;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class SysmUsr3100ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(SysmUsr3100ExcelController.class);  
 
    
    @Resource(name = "SysmUsr3100ExcelService")
    private SysmUsr3100ExcelService hist0100ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    

    /**
     * 엑셀파일로 출력한다. (상단버튼)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
	@RequestMapping(value="/exp/XlsFileSysm3100Export.do")
	public ModelAndView xlsFileHist0100Export(@ModelAttribute("SysIfHist0100SrhVO") SysIfHist0100SrhVO hist0100SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
        
		MSFUserInfoVO sessionUser = AnyWebServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();  
        
       if  (SmrmfUtils.paramNull(hist0100ExcelService)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            hist0100ExcelService = (SysmUsr3100ExcelService) wac.getBean("SysmUsr3100ExcelService" ); 
        }
        /** 조건절 */
        hist0100SrhVo.setDpobCd(sessionUser.getDpobCd());    																			/** column 사업장코드 : dpobCd */
        hist0100SrhVo.setUsrConnectDivCd(SmrmfUtils.allowNulls(hist0100SrhVo.getUsrConnectDivCd()));    				/** column 사용자접속구분코드 : usrConnectDivCd */
      
        hist0100SrhVo.setUsrConnectBgnnDtntm(SmrmfUtils.allowNulls(hist0100SrhVo.getUsrConnectBgnnDtntm()));    	/** column 사용자접속시작일시 : usrConnectBgnnDtntm */
        hist0100SrhVo.setUsrConnectEndDtntm(SmrmfUtils.allowNulls(hist0100SrhVo.getUsrConnectEndDtntm()));    		/** column 사용자접속종료일시 : usrConnectEndDtntm */
          
        hist0100SrhVo.setDeptCd(SmrmfUtils.allowNulls(hist0100SrhVo.getDeptCd()));
        listDeptCd = SmrmfUtils.getStrToArrayList(SmrmfUtils.allowNulls(hist0100SrhVo.getDeptCd()));  
        hist0100SrhVo.setDeptCdArr(listDeptCd);    																							/** column 부서코드 : deptCd */
        hist0100SrhVo.setSystemkey(SmrmfUtils.allowNulls(hist0100SrhVo.getSystemkey()));   				 					/** column systemkey : systemkey */
         
        
     	List  listFileHist0100 = hist0100ExcelService.selectXlsFileHist0100List(hist0100SrhVo);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("listFileHist0100", listFileHist0100);
        
        return new ModelAndView("hist0100ExcelView", map);
	}
    
}
