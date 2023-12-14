package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.msf.exterms.xls.service.SysmUsr3200ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.app.smrmf.core.msfmainapp.server.utils.AnyWebServerUtils;
import com.app.smrmf.sysm.server.vo.SysIfHist0200SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfHist0200VO;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class SysmUsr3200ExcelController {

	
    private static final String calledClass = SysmUsr3200ExcelController.class.getName();
    private static final Logger logger = LoggerFactory.getLogger(SysmUsr3200ExcelController.class);  
 
    
    @Resource(name = "SysmUsr3200ExcelService")
    private SysmUsr3200ExcelService hist0200ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    /** hieju 07.31
     * 엑셀파일로 출력한다.(양식)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    
    @RequestMapping(value="/exp/XlsSysm3200Export.do")
    public ModelAndView XlsHist0200Export(@ModelAttribute("SysIfHist0200SrhVO") SysIfHist0200SrhVO oracleDb0100, HttpServletRequest request, ModelMap model) 
            throws Exception { 
    	
        String method = calledClass + ".xlsHist0200Export";
        MSFUserInfoVO sessionUser = AnyWebServerUtils.getLoggedUser(request);

        // 서비스를 통해 데이터를 가져온다.
        List<SysIfHist0200SrhVO> listFileHist0200 = hist0200ExcelService.selectXlsSysm3200List(oracleDb0100);
        
        // ModelAndView 객체를 생성하고 데이터를 담아서 반환한다.
        ModelAndView modelAndView = new ModelAndView("hist0200ExcelView");
        modelAndView.addObject("listFileHist0200", listFileHist0200);

        return modelAndView;
    }
    // ** 수정 끝
    
    
    /**
     * 엑셀파일로 출력한다. (상단버튼)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
	@RequestMapping(value="/exp/XlsFileSysm3200Export.do")
	public ModelAndView XlsFileHist0200Export(@ModelAttribute("SysIfHist0200SrhVO") SysIfHist0200SrhVO oracleDb0100,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
       
        
		MSFUserInfoVO sessionUser = AnyWebServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();  
        
        if  (SmrmfUtils.paramNull(hist0200ExcelService)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            hist0200ExcelService = (SysmUsr3200ExcelService) wac.getBean("SysmUsr3200ExcelService" ); 
        }  
         
     	List  listFileHist0200 = hist0200ExcelService.selectXlsFileSysm3200List(oracleDb0100);
        
        
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("listFileHist0200", listFileHist0200);
        
        return new ModelAndView("hist0200ExcelView", map);
         
	}
    
}
