package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.msf.exterms.xls.service.SysmUsr0100ExcelService;
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
import com.app.smrmf.sysm.server.vo.SysIfSysm0100SrhVO;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class SysmUsr0100ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(SysmUsr0100ExcelController.class);  
 
    
    @Resource(name = "sysmUsr0100ExcelService")
    private SysmUsr0100ExcelService sysmUsr0100ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    

    /**
     * 엑셀파일로 출력한다. (상단버튼)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
	@RequestMapping(value="/exp/XlsFileSysmUsr0100Export.do")
	public ModelAndView xlsFileHist0100Export(@ModelAttribute("SysIfSysm0100SrhVO") SysIfSysm0100SrhVO sysIfSysm0100SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
        
        
		MSFUserInfoVO sessionUser = AnyWebServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();  
      
        if  (SmrmfUtils.paramNull(sysmUsr0100ExcelService)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            sysmUsr0100ExcelService = (SysmUsr0100ExcelService) wac.getBean("sysmUsr0100ExcelService" ); 
        }
        
        /** 조건절 */
        sysIfSysm0100SrhVo.setDpobCd(sessionUser.getDpobCd());													/** column 사업장코드 : dpobCd */
        sysIfSysm0100SrhVo.setDeptCd(SmrmfUtils.allowNulls(sysIfSysm0100SrhVo.getDeptCd()));    			/** column 사용자접속구분코드 : usrConnectDivCd */
        sysIfSysm0100SrhVo.setUsrDivCd(SmrmfUtils.allowNulls(sysIfSysm0100SrhVo.getUsrDivCd()));    		/** column 사용자접속시작일시 : usrConnectBgnnDtntm */
        sysIfSysm0100SrhVo.setUsrNm(SmrmfUtils.allowNulls(sysIfSysm0100SrhVo.getUsrNm()));    				/** column 사용자접속종료일시 : usrConnectEndDtntm */
          
        sysIfSysm0100SrhVo.setSearchKeyword(SmrmfUtils.allowNulls(sysIfSysm0100SrhVo.getSearchKeyword()));
         
     	List  listFileSysmUsr0100 = sysmUsr0100ExcelService.selectXlsFileSysmUsr0100List(sysIfSysm0100SrhVo);
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("listFileSysmUsr0100", listFileSysmUsr0100);
        
        return new ModelAndView("sysmUsr0100ExcelView", map);
	}
    
}
