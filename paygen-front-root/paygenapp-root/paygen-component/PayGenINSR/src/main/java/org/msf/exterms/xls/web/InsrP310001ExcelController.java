package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.InsrP310001ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.insurance.server.vo.Insr4100SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class InsrP310001ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(InsrP310001ExcelController.class);  
    private static final String calledClass = InsrP310001ExcelController.class.getName();

 
    
    @Resource(name = "InsrP310001ExcelService")
    private InsrP310001ExcelService insrP310001ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    
    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsInsrP310001Export.do")   
    public ModelAndView xlsInsrP310001Export(@ModelAttribute("Insr4100SrhVO") Insr4100SrhVO insr4100SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
       
    	String method = calledClass + ".xlsInsrP310001Export";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
        Map<String, Object> map = new HashMap<String, Object>(); 
        
    	String windowNm = "국민연금기본관리";
		String windowId = "INSRP310001";
        
		try{
        	
	        insr4100SrhVo.setUsrId(sessionUser.getUsrId());  
	               
	        insr4100SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        insr4100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        
	         
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4100SrhVo.getTypOccuCd())); 
	        insr4100SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	       // insr4100SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	       
	        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4100SrhVo.getPyspGrdeCd())); 
	        insr4100SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
	       // insr4100SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4100SrhVo.getDtilOccuInttnCd())); 
	        insr4100SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	       // insr4100SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	         
	        List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4100SrhVo.getHdofcCodtnCd())); 
	        insr4100SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);  
	       // insr4100SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	        
	        insr4100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(insr4100SrhVo.getSystemkey()));	//시스템키
	        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4100SrhVo.getSystemkey())); 
	        insr4100SrhVo.setSystemKeyArr(systemKeyArr);
	          
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	insr4100SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           insr4100SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	insr4100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr4100SrhVo.getPayrMangDeptCd()));    
	                 if (insr4100SrhVo.getPayrMangDeptCd().equals(insr4100SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	insr4100SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 insr4100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd()));  
	                      insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	         
	        
	        insr4100SrhVo.setDeptCdAuth(insr4100SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        insr4100SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr4100SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	      
	        
	       /******************************** 권한 ************************************************************************/
	//        if (insr4100SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd()))) {
	//        	insr4100SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
	//        	List<String> listDeptCd = null; 
	//        	insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	//        	insr4100SrhVo.setDeptCd("");     //부서코드
	//        } else {
	//
	//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd()));  
	//            insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드  
	//            insr4100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd()));     //부서코드 
	//        }
	        
	         
	        List listPInsr4100 = insrP310001ExcelService.selectXlsPInsr4100List(insr4100SrhVo);
	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listPInsr4100.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listPInsr4100.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}

//	        Map<String, Object> map = new HashMap<String, Object>(); 
	        map = new HashMap<String, Object>(); 
	        
	        map.put("listPInsr4100", excelList);
	        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
        
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        }
		
        return new ModelAndView("insrP31000101ExcelView", map);
         
    }
    
}
