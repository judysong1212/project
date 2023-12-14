package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.InsrP510001ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.insurance.server.vo.Insr5100SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class InsrP510001ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(InsrP510001ExcelController.class); 
    private static final String calledClass = InsrP510001ExcelController.class.getName();
 
    
    @Resource(name = "InsrP510001ExcelService")
    private InsrP510001ExcelService insrP510001ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    
    /**
     * 개인별 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsInsrP51000102Export.do")   
    public ModelAndView xlsInsrP51000102Export(@ModelAttribute("Insr5100SrhVO") Insr5100SrhVO insr5100SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
       
    	String method = calledClass + ".xlsInsrP51000102Export";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();
        Map<String, Object> map = new HashMap<String, Object>(); 
        
    	String windowNm = "고용보험기본관리";
		String windowId = "INSRP510001";
        
		try{
        	
	        insr5100SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        insr5100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        insr5100SrhVo.setUsrId(sessionUser.getUsrId());  
	         
	        List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5100SrhVo.getHdofcCodtnCd())); 
	        insr5100SrhVo.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태
	        
	          
	        
	        
	        insr5100SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getEmymtDivCd()));	         //고용구분
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5100SrhVo.getTypOccuCd())); 
	        insr5100SrhVo.setTypOccuCdArr(lstTypeOccuCd); //직종       
	     	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5100SrhVo.getDtilOccuInttnCd())); 
	     	insr5100SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세
	     	insr5100SrhVo.setBusinCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getBusinCd()));   //사업
	        
	     	insr5100SrhVo.setHanNm(MSFSharedUtils.allowNulls(insr5100SrhVo.getHanNm()));			//성명
	     	insr5100SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(insr5100SrhVo.getResnRegnNum()));//주민번호
	        
	       
	        
	     	insr5100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(insr5100SrhVo.getSystemkey()));	//시스템키
	        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5100SrhVo.getSystemkey())); 
	        insr5100SrhVo.setSystemKeyArr(systemKeyArr);
	          
	        
	        String deptCd = MSFSharedUtils.allowNulls(insr5100SrhVo.getDeptCd());
	        
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	insr5100SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           insr5100SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           insr5100SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	insr5100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getPayrMangDeptCd()));  
	        	insr5100SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getPayrMangDeptCd()));
	                 if (insr5100SrhVo.getPayrMangDeptCd().equals(insr5100SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	insr5100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	insr5100SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 insr5100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5100SrhVo.getDeptCd()));  
	                      insr5100SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        
	            
	        insr5100SrhVo.setDeptCdAuth(deptCd.replace(",", ""));  //권한처리를위해 추가  
	        insr5100SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr5100SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	
	       /******************************** 권한 ************************************************************************/
	         
	        List listInsrP5100 = insrP510001ExcelService.selectXlsInsrP51000102ToInsr5100List(insr5100SrhVo);
	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listInsrP5100.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listInsrP5100.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}

//	        Map<String, Object> map = new HashMap<String, Object>(); 
	        map = new HashMap<String, Object>(); 
	        
	        map.put("listInsrP5100", excelList);
	        map.put("gubun", "INSRP51000102");
	        
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
		
        return new ModelAndView("insrP510001ExcelView", map);
         
    }
    
    /**
     * 부서별 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */                         
    @RequestMapping(value="/exp/XlsInsrP51000101Export.do")   
    public ModelAndView xlsInsrP51000101Export(@ModelAttribute("Insr5100SrhVO") Insr5100SrhVO insr5100SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
       
    	String method = calledClass + ".xlsInsrP51000101Export";
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
        Map<String, Object> map = new HashMap<String, Object>(); 
        
    	String windowNm = "고용보험기본관리";
		String windowId = "INSRP510001";
        
		try{
        	
	        insr5100SrhVo.setUsrId(sessionUser.getUsrId()); 
	        insr5100SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        insr5100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        
	         
	        List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5100SrhVo.getHdofcCodtnCd())); 
	        insr5100SrhVo.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태
	        insr5100SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getEmymtDivCd()));	         //고용구분
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5100SrhVo.getTypOccuCd())); 
	        insr5100SrhVo.setTypOccuCdArr(lstTypeOccuCd); //직종       
	     	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5100SrhVo.getDtilOccuInttnCd())); 
	     	insr5100SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세
	     	insr5100SrhVo.setBusinCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getBusinCd()));   //사업
	        
	     	insr5100SrhVo.setHanNm(MSFSharedUtils.allowNulls(insr5100SrhVo.getHanNm()));			//성명
	     	insr5100SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(insr5100SrhVo.getResnRegnNum()));//주민번호
	        
	        
	        
	     	insr5100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(insr5100SrhVo.getSystemkey()));	//시스템키
	        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5100SrhVo.getSystemkey())); 
	        insr5100SrhVo.setSystemKeyArr(systemKeyArr);
	        
	        String deptCd = MSFSharedUtils.allowNulls(insr5100SrhVo.getDeptCd());
	
	       /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	insr5100SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           insr5100SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           insr5100SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	insr5100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getPayrMangDeptCd()));  
	        	insr5100SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getPayrMangDeptCd()));
	                 if (insr5100SrhVo.getPayrMangDeptCd().equals(insr5100SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	insr5100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	insr5100SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 insr5100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5100SrhVo.getDeptCd()));  
	                      insr5100SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        insr5100SrhVo.setDeptCdAuth(deptCd.replace(",", ""));  //권한처리를위해 추가    
	        insr5100SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr5100SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	        
	//        if (insr3000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(insr3000SrhVo.getDeptCd()))) {
	//        	insr3000SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
	//        	List<String> listDeptCd = null; 
	//        	insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	//        	insr3000SrhVo.setDeptCd("");     //부서코드
	//        } else {
	//
	//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getDeptCd()));  
	//            insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드  
	//            insr3000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getDeptCd()));     //부서코드 
	//        }
	        
	         
	        List listInsrP5100 = insrP510001ExcelService.selectXlsInsrP51000101ToInsr5100List(insr5100SrhVo);
	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listInsrP5100.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listInsrP5100.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}

//	        Map<String, Object> map = new HashMap<String, Object>(); 
	        map = new HashMap<String, Object>(); 
	        map.put("listInsrP5100", excelList);
	        map.put("gubun", "INSRP51000101");
	        
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
		
        return new ModelAndView("insrP510001ExcelView", map);
         
    }  
}
