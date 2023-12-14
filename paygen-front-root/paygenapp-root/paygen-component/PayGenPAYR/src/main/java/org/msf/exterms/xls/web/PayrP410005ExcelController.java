package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.PayrP410005ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.payroll.server.vo.Payr0530SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class PayrP410005ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(PayrP410005ExcelController.class);  
    private static final String calledClass = PayrP410005ExcelController.class.getName();

 
    @Resource(name = "payrP410005ExcelService")
    private PayrP410005ExcelService payrP410005ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.(가족수당대상자)
     * @payr0530SrhVO searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPayrP410005Export.do")
    public ModelAndView xlsPayrP410005Export(@ModelAttribute("Psnl0126SrhVO") Payr0530SrhVO payr0530SrhVO,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsPayrP410005Export";
    	

    	String windowNm = "가족수당대상자";
    	String windowId = "PAYRP410005";
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	
//    	Payr0530SrhVO   payr0530SrhVO = new Payr0530SrhVO();
    	
    	List<String> listDeptCd = new ArrayList<String>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	
		try{
	        
	        /** 조건절 */
	        payr0530SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        payr0530SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        payr0530SrhVO.setUsrId(sessionUser.getUsrId());  
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	
	        	  if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(payr0530SrhVO.getDeptCd(),sessionUser.getDeptCd()))) {

	  	        	payr0530SrhVO.setDeptCd(sessionUser.getDeptCd()); 
	  	           listDeptCd.add(sessionUser.getDeptCd());
	  	           payr0530SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
	                  
	          	   } else {
	          		 
	          		 payr0530SrhVO.setDeptCd(MSFSharedUtils.allowNulls(payr0530SrhVO.getDeptCd()));
                     listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr0530SrhVO.getDeptCd()));  
                     payr0530SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	          	  }  
	        	  
	           payr0530SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	payr0530SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(payr0530SrhVO.getPayrMangDeptCd())) ;   //단위기관코드
	                 if (payr0530SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(payr0530SrhVO.getDeptCd()))) { 
	                 	 listDeptCd = null; 
	                 	payr0530SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	                 	payr0530SrhVO.setDeptCd("");  //부서코드
	                 } else {
	                	 payr0530SrhVO.setDeptCd(MSFSharedUtils.allowNulls(payr0530SrhVO.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr0530SrhVO.getDeptCd()));  
	                      payr0530SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	        }
	        
	
	        payr0530SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(payr0530SrhVO.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
	        payr0530SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(payr0530SrhVO.getDtilOccuInttnCd()).replace(",", ""));      
	         
	       /******************************** 권한 ************************************************************************/
	        
	        payr0530SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(payr0530SrhVO.getEmymtDivCd()));	//고용구분코드
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr0530SrhVO.getTypOccuCd())); 
	        payr0530SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	        payr0530SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(payr0530SrhVO.getTypOccuCd()));  	//직종
	       
	//        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr0530SrhVO.get("pyspGrdeCd"))); 
	//        payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	//        payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(payr0530SrhVO.get("pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr0530SrhVO.getDtilOccuInttnCd())); 
	        payr0530SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        payr0530SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(payr0530SrhVO.getDtilOccuInttnCd())); //직종세
	        
	        payr0530SrhVO.setBusinCd(MSFSharedUtils.allowNulls(payr0530SrhVO.getBusinCd()));   			//사업코드 
	        payr0530SrhVO.setSystemkey(MSFSharedUtils.allowNulls(payr0530SrhVO.getSystemkey()));  			//시스템키
	        
	        // 그리드 쿼리랑 같이 사용.
	        // 그냥 사용시 pageIndex로 인해 데이터가 1건만 나오는 현상을 방지하기 위해 플래그 추가.
//	        payr0530SrhVO.setExcelYn("Y");
	       
	        List listPayr0503 = payrP410005ExcelService.selectXlsPayrP410005List(payr0530SrhVO);
	        
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listPayr0503.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPayr0503.get(i);
	    		
	    			
	    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
		    		
	    			
	    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("payFamyResnRegnNum", strValue);
	    			
	    		excelList.add(eMap);
	    	}
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPayr0503", excelList);
	        
	             
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        }
       
        return new ModelAndView("payrP410005ExcelView", map);
         
    }
      
    
}
