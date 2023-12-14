package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.InsrP420001ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.insurance.server.vo.Insr3200SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class InsrP420001ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(InsrP420001ExcelController.class); 
    private static final String calledClass = InsrP420001ExcelController.class.getName();
 
    
    @Resource(name = "InsrP420001ExcelService")
    private InsrP420001ExcelService insrP420001ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    
    /**
     * 개인별 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsInsrP420001Export.do")   
    public ModelAndView xlsInsrP420001Export(@ModelAttribute("Insr3200SrhVO") Insr3200SrhVO insr3200SrhVO,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
       
    	String method = calledClass + ".xlsInsrP51000102Export";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();
        Map<String, Object> map = new HashMap<String, Object>(); 
        
    	String windowNm = "건강보험월정산대사";
		String windowId = "INSRP420001";
        
		try{
        	
			insr3200SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
			insr3200SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			insr3200SrhVO.setUsrId(sessionUser.getUsrId());  
	         
	        List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVO.getHdofcCodtnCd())); 
	        insr3200SrhVO.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태
	        insr3200SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(insr3200SrhVO.getEmymtDivCd()));	         //고용구분
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVO.getTypOccuCd())); 
	        insr3200SrhVO.setTypOccuCdArr(lstTypeOccuCd); //직종       
	     	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVO.getDtilOccuInttnCd())); 
	     	insr3200SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세
	     	insr3200SrhVO.setBusinCd(MSFSharedUtils.allowNulls(insr3200SrhVO.getBusinCd()));   //사업
	        
	     	insr3200SrhVO.setHanNm(MSFSharedUtils.allowNulls(insr3200SrhVO.getHanNm()));			//성명
	     	insr3200SrhVO.setResnRegnNum(MSFSharedUtils.allowNulls(insr3200SrhVO.getResnRegnNum()));//주민번호
	        
	       
	        
	     	insr3200SrhVO.setSystemkey(MSFSharedUtils.allowNulls(insr3200SrhVO.getSystemkey()));	//시스템키
	        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVO.getSystemkey())); 
	        insr3200SrhVO.setSystemKeyArr(systemKeyArr);
	          
	        
	        String deptCd = MSFSharedUtils.allowNulls(insr3200SrhVO.getDeptCd());
	        
			insr3200SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(insr3200SrhVO.getPymtYrMnth()));	/* 지급년월			*/
	        
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	insr3200SrhVO.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           insr3200SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
	           insr3200SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	insr3200SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr3200SrhVO.getPayrMangDeptCd()));  
	        	insr3200SrhVO.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr3200SrhVO.getPayrMangDeptCd()));
	                 if (insr3200SrhVO.getPayrMangDeptCd().equals(insr3200SrhVO.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	insr3200SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	                 	insr3200SrhVO.setDeptCd("");  //부서코드
	                 } else {
	                	 insr3200SrhVO.setDeptCd(MSFSharedUtils.allowNulls(insr3200SrhVO.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVO.getDeptCd()));  
	                      insr3200SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        
	            
	        insr3200SrhVO.setDeptCdAuth(deptCd.replace(",", ""));  //권한처리를위해 추가  
	        insr3200SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr3200SrhVO.getDtilOccuInttnCd()).replace(",", ""));
	
	       /******************************** 권한 ************************************************************************/
	         
	        List listInsrP420001 = insrP420001ExcelService.selectXlsInsrP420001ToInsr3200List(insr3200SrhVO);
	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listInsrP420001.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listInsrP420001.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}

//	        Map<String, Object> map = new HashMap<String, Object>(); 
	        map = new HashMap<String, Object>();         
	        map.put("listInsrP420001", excelList);
	        
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
		
        return new ModelAndView("insrP420001ExcelView", map);
         
    }
    
    
}
