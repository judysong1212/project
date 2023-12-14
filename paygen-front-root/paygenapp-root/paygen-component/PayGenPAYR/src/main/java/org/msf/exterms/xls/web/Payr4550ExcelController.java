package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Payr4550ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.payroll.server.vo.Payr0301SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Payr4550ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Payr4550ExcelController.class);
    private static final String calledClass = Payr4550ExcelController.class.getName();

 
    
    @Resource(name = "payr4550ExcelService")
    private Payr4550ExcelService payr4550ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.(소득세납부내역)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPayr4550Export.do")
    public ModelAndView xlsPayr4550Export(@RequestParam HashMap<String, String> param, HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsPayr4550Export";
    	
    	String windowNm = "근로소득원천징수부";
		String windowId = "PAYR4500";
      
		Payr0301SrhVO   payr0301SrhVO = new Payr0301SrhVO();

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		List<String> listDeptCd = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
         
     	// 1. 암호화 객체 생성
     	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
         
		try{
        	
			/** 조건절 */
			payr0301SrhVO.setPayYr(MSFSharedUtils.allowNulls(param.get("payYr")) );
			payr0301SrhVO.setDpobCd(sessionUser.getDpobCd());  									// 사업장코드
	        payr0301SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  					// 단위기관담당자여부 
	        payr0301SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(param.get("pymtYrMnth"))); 	//지급년  
	        payr0301SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("emymtDivCd")));      //고용구분코드
	        payr0301SrhVO.setUsrId(sessionUser.getUsrId()); 
	        payr0301SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(param.get("mangeDeptCd")));    //관리부서 
	        payr0301SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(param.get("repbtyBusinDivCd")));    //호봉제구분 
	        
			/******************************** 권한 ************************************************************************/
			String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
			if ("FALSE".equals(chkDeptCd)) {
				
				  if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(param.get("deptCd"),sessionUser.getDeptCd()))) {

						payr0301SrhVO.setDeptCd(sessionUser.getDeptCd());
						listDeptCd.add(sessionUser.getDeptCd());
						payr0301SrhVO.setDeptCdArr(listDeptCd); // 부서코드
		                
		       	   } else {
		       		payr0301SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
					listDeptCd = SmrmfUtils.getStrToArrayList(param.get("deptCd"));
					payr0301SrhVO.setDeptCdArr(listDeptCd); // 부서코드
		       		 
		       	  }  
				  
				payr0301SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
				
			} else {
	            	    
				payr0301SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd"))); // 단위기관코드
				
				if (payr0301SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
					listDeptCd = null;
					payr0301SrhVO.setDeptCdArr(listDeptCd); // 부서코드
					payr0301SrhVO.setDeptCd(""); // 부서코드
				} else {
					payr0301SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
					listDeptCd = SmrmfUtils.getStrToArrayList(param.get("deptCd"));
					payr0301SrhVO.setDeptCdArr(listDeptCd); // 부서코드
				}

			}
	            
	        payr0301SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가  
	        payr0301SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get( "dtilOccuInttnCd")).replace(",", ""));   
	            
	        /******************************** 권한 ************************************************************************/
	            
	            
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
	        payr0301SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	        payr0301SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("typOccuCd")));  				//직종
	           
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
	        payr0301SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        payr0301SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(param.get( "dtilOccuInttnCd"))); 	//직종세
	              
	            
	        payr0301SrhVO.setBusinCd(MSFSharedUtils.allowNulls(param.get( "businCd")));   					//사업코드 
	        payr0301SrhVO.setSystemkey(MSFSharedUtils.allowNulls(param.get("systemkey"))); 					//시스템키
	        payr0301SrhVO.setHanNm(MSFSharedUtils.allowNulls(param.get("hanNm")));    						//한글성명 
	        
	       
	        List listPayr4550 = payr4550ExcelService.selectXlsPayr4550List(payr0301SrhVO);
	        
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listPayr4550.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    			eMap = (EgovMap) listPayr4550.get(i);
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
		    		
	    			
	    		excelList.add(eMap);
	    	}
	        
	        map = new HashMap<String, Object>();
	        map.put("listPayr4550", excelList);
	        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");

		} catch (Exception e) {
			e.printStackTrace();

			/** 에러 로그 **/
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, "S", e, windowNm, windowId);

		}

		return new ModelAndView("payr4550ExcelView", map);

	}
    
    
}
