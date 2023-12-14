package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.msf.exterms.xls.service.SysmUsrP330002ExcelService;
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
import com.app.smrmf.sysm.server.vo.SysIfHist0300SrhVO;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class SysmUsrP330002ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(SysmUsrP330002ExcelController.class);  
 
    
    @Resource(name = "SysmUsrP330002ExcelService")
    private SysmUsrP330002ExcelService hist0300ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    

    /**
     * 엑셀파일로 출력한다. (상단버튼)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
	@RequestMapping(value="/exp/XlsFileSysmP330002Export.do")
	public ModelAndView xlsFileHist0300Export(@ModelAttribute("SysIfHist0300SrhVO") SysIfHist0300SrhVO hist0300SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
       
       
        
		MSFUserInfoVO sessionUser = AnyWebServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();  
        
        if  (SmrmfUtils.paramNull(hist0300ExcelService)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            hist0300ExcelService = (SysmUsrP330002ExcelService) wac.getBean("SysmUsrP330002ExcelService" ); 
        }    
 
        hist0300SrhVo.setDpobCd(sessionUser.getDpobCd());    													/** column 사업장코드 : dpobCd */
        hist0300SrhVo.setUsrConnectDivCd(SmrmfUtils.allowNulls(hist0300SrhVo.getUsrConnectDivCd()));    	/** column 사용자접속구분코드 : usrConnectDivCd */
      

        hist0300SrhVo.setErrOccrrncDtntmS(SmrmfUtils.allowNulls(hist0300SrhVo.getErrOccrrncDtntmS()));    	/** column 에러발생일시 : errOccrrncDtntm */
        hist0300SrhVo.setErrOccrrncDtntmE(SmrmfUtils.allowNulls(hist0300SrhVo.getErrOccrrncDtntmE()));    	/** column 에러발생일시 : errOccrrncDtntm */
          
        hist0300SrhVo.setDeptCd(SmrmfUtils.allowNulls(hist0300SrhVo.getDeptCd()));
        listDeptCd = SmrmfUtils.getStrToArrayList(hist0300SrhVo.getDeptCd());  
        hist0300SrhVo.setDeptCdArr(listDeptCd);    																/** column 부서코드 : deptCd */
         
        hist0300SrhVo.setUsrId(SmrmfUtils.allowNulls(hist0300SrhVo.getUsrId()));			// 유저아이디
        hist0300SrhVo.setWindowNm(SmrmfUtils.allowNulls(hist0300SrhVo.getWindowNm())); 		// 화면아이디
        hist0300SrhVo.setWindowId(SmrmfUtils.allowNulls(hist0300SrhVo.getWindowId()));		// 화면명
;		        
        hist0300SrhVo.setSystemkey(SmrmfUtils.allowNulls(hist0300SrhVo.getSystemkey()));    				/** column systemkey : systemkey */
        
         
     	List  listFileHist0300 = hist0300ExcelService.selectXlsFileHist0300List(hist0300SrhVo);
        
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("listFileHist0300", listFileHist0300);
        
        return new ModelAndView("histP30002ExcelView", map);
         
	}
    
}
