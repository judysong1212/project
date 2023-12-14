package org.msf.exterms.yeta2023.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.yeta2023.xls.service.Yeta8400ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2023_VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Yeta8400ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Yeta8400ExcelController.class);  
    private static final String calledClass = Yeta8400ExcelController.class.getName();
 
    
    @Resource(name = "Yeta8400ExcelService")
    private Yeta8400ExcelService yeta8400ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    

    /**
     * 엑셀파일로 출력한다. (양식)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsYeta8400Export.do")
    public ModelAndView xlsYeta8400Export(@ModelAttribute("Ye161010Srh_2023_VO") Ye161010Srh_2023_VO ye161010SrhVo, HttpServletRequest request ,ModelMap model) 
                    throws Exception {  
    	
    	String method = calledClass + ".xlsYeta8400Export";
    	
    	String windowNm = "연말정산신고파일생성";
		String windowId = "YETA8400";
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	List<String> listDeptCd = new ArrayList<String>();  
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	
		try{
        	
	    	 ye161010SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161010SrhVo.getYrtxBlggYr())); //연말정산년
	         ye161010SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getClutSeptCd()));  //연말정산구분코드  
	         
	
	         
	         ye161010SrhVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));  //사업장코드
	         ye161010SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));  //단위기관담당자여부 
	         ye161010SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getEmymtDivCd()));      //고용구분코드
	         
	         /******************************** 권한 ************************************************************************/
	         String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	         
	         if ("FALSE".equals(chkDeptCd)) {
	         	ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(sessionUser.getDeptCd())); 
	         	listDeptCd.add(MSFSharedUtils.allowNulls(sessionUser.getDeptCd()));
	         	ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	         	ye161010SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd())); 
	         } else {
	         	    
	         	ye161010SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getPayrMangDeptCd()));  
	       	  
	       	  	if (ye161010SrhVo.getPayrMangDeptCd().equals(ye161010SrhVo.getDeptCd())) { 
	       	  		listDeptCd = null; 
	       	  		ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	       	  		ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));  //부서코드
	       	  	} else {
	       	  		ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getDeptCd()));
	       	  		listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010SrhVo.getDeptCd()));  
	       	  		ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	       	  	} 
	         }
	          
	         ye161010SrhVo.setDeptCdAuth(ye161010SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	         ye161010SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(ye161010SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	        /******************************** 권한 ************************************************************************/
	         
	         List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010SrhVo.getTypOccuCd())); 
	         ye161010SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	          
	         List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010SrhVo.getDtilOccuInttnCd())); 
	         ye161010SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	         
	         ye161010SrhVo.setBusinCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getBusinCd()));   //사업코드 
	         
	         ye161010SrhVo.setUsrId(sessionUser.getUsrId());    
	         
	         
	         ye161010SrhVo.setUtDpobCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getUtDpobCd()));				//원천신고부서
	         ye161010SrhVo.setBusoprRgstnum(MSFSharedUtils.allowNulls(ye161010SrhVo.getBusoprRgstnum()));	//사업자등록번호


	    	
	        List listYeta8400 = yeta8400ExcelService.selectYeta8400ToYeta8400List(ye161010SrhVo);
	        
	        
			List<EgovMap> excelList = new ArrayList<EgovMap>();

	    	for(int i=0; i<listYeta8400.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listYeta8400.get(i);
	    		// TODO 주민번호
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
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
	        
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listYeta0400", excelList);
        
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        }
        
        return new ModelAndView("yeta8400ExcelView", map);
         
    }
}