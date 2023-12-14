package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Insr2400ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.insurance.server.vo.Insr2200SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Insr2400ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Insr2400ExcelController.class);  
    private static final String calledClass = Insr2400ExcelController.class.getName();

 
    
    @Resource(name = "insr2400ExcelService")
    private Insr2400ExcelService insr2400ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */                         
    @RequestMapping(value="/exp/XlsFileInsr2400Export.do")   
    public ModelAndView xlsInsr2300Export(@ModelAttribute("Insr2200SrhVO") Insr2200SrhVO insr2200SrhVo, HttpServletRequest request ,ModelMap model) 
                    throws Exception {  
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
        
        String gubun = insr2200SrhVo.getGubun();
    	String method = calledClass + ".xlsInsr2300Export";
    	
        insr2200SrhVo.setUsrId(sessionUser.getUsrId());  
        insr2200SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
        insr2200SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
		insr2200SrhVo.setSoctyInsurCmptnDt01(MSFSharedUtils.allowNulls(insr2200SrhVo.getSoctyInsurCmptnDt01()));
		insr2200SrhVo.setSoctyInsurCmptnDt02(MSFSharedUtils.allowNulls(insr2200SrhVo.getSoctyInsurCmptnDt02()));
		List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr2200SrhVo.getHdofcCodtnCd())); 
		insr2200SrhVo.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태
		insr2200SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(insr2200SrhVo.getEmymtDivCd()));	         //고용구분
        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr2200SrhVo.getTypOccuCd())); 
        insr2200SrhVo.setTypOccuCdArr(lstTypeOccuCd); //직종       
     	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr2200SrhVo.getDtilOccuInttnCd())); 
     	insr2200SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세
     	insr2200SrhVo.setBusinCd(MSFSharedUtils.allowNulls(insr2200SrhVo.getBusinCd()));   //사업

     	
        insr2200SrhVo.setHanNm(MSFSharedUtils.allowNulls(insr2200SrhVo.getHanNm()));			//성명
        insr2200SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(insr2200SrhVo.getResnRegnNum()));//주민번호
        
        
        
        insr2200SrhVo.setSystemkey(MSFSharedUtils.allowNulls(insr2200SrhVo.getSystemkey()));	//시스템키
        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr2200SrhVo.getSystemkey())); 
        insr2200SrhVo.setSystemKeyArr(systemKeyArr);
        
        
        String deptCd = MSFSharedUtils.allowNulls(insr2200SrhVo.getDeptCd());
        
        /******************************** 권한 ************************************************************************/
        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
        if ("FALSE".equals(chkDeptCd)) {
        	insr2200SrhVo.setDeptCd(sessionUser.getDeptCd()); 
           listDeptCd.add(sessionUser.getDeptCd());
           insr2200SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
           insr2200SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
        } else {
        	    
        	insr2200SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr2200SrhVo.getPayrMangDeptCd()));    
                 if (insr2200SrhVo.getPayrMangDeptCd().equals(insr2200SrhVo.getDeptCd())) { 
                 	 listDeptCd = null; 
                 	insr2200SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                 	insr2200SrhVo.setDeptCd("");  //부서코드
                 } else {
                	 insr2200SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr2200SrhVo.getDeptCd()));
                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr2200SrhVo.getDeptCd()));  
                      insr2200SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                 } 
              
        }
        insr2200SrhVo.setDeptCdAuth(deptCd.replace(",", ""));  //권한처리를위해 추가  
        insr2200SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr2200SrhVo.getDtilOccuInttnCd()).replace(",", ""));
  
       /******************************** 권한 ************************************************************************/
        
        List listInsr2400 = insr2400ExcelService.selectXlsInsr2400List(insr2200SrhVo);
        
        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	List<EgovMap> excelList = new ArrayList<EgovMap>();

    	for(int i=0; i<listInsr2400.size(); i++){
    		EgovMap eMap  = new EgovMap();
    		eMap = (EgovMap) listInsr2400.get(i);
    		// TODO 주민번호
    		//nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    		String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
    		eMap.put("resnRegnNum", strValue);
    		excelList.add(eMap);
    	}
        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
        
        	Map<String, Object> map = new HashMap<String, Object>(); 
        	map.put("listInsr2400", excelList);
        	return new ModelAndView("insr2400ExcelView", map);

    }
     
    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */                         
    @RequestMapping(value="/exp/XlsFileInsrP230006Export.do")   
    public ModelAndView xlsInsrP230006Export(@ModelAttribute("Insr2200SrhVO") Insr2200SrhVO insr2200SrhVo, HttpServletRequest request ,ModelMap model) 
                    throws Exception {  
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	String method = calledClass + ".xlsInsrP230006Export";
  
        insr2200SrhVo.setUsrId(sessionUser.getUsrId());  
        insr2200SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드


        List listInsr2400 = insr2400ExcelService.selectXlsInsrP230006(insr2200SrhVo);
        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	List<EgovMap> excelList = new ArrayList<EgovMap>();

    	for(int i=0; i<listInsr2400.size(); i++){
    		EgovMap eMap  = new EgovMap();
    		eMap = (EgovMap) listInsr2400.get(i);
    		// TODO 주민번호
    		//nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    		String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
    		eMap.put("resnRegnNum", strValue);
    		excelList.add(eMap);
    	}
        
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
        

    	Map<String, Object> map = new HashMap<String, Object>(); 
    	map.put("listInsr2400", excelList);
    	return new ModelAndView("insr2400ExcelView", map);
    }
    
}
