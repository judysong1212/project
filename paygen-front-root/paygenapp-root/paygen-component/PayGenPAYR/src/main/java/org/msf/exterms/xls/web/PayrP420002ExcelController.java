package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.PayrP420002ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.payroll.server.vo.Payr0304SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class PayrP420002ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(PayrP420002ExcelController.class);  
    private static final String calledClass = PayrP420002ExcelController.class.getName();

 
    @Resource(name = "payrP420002ExcelService")
    private PayrP420002ExcelService payrP420002ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.(급여대장)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPayrP420002Export.do")
    public ModelAndView xlsPayrP420002Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsPayrP420002Export";
    	

    	String windowNm = "급여(조정)내역관리";
    	String windowId = "PAYRP420002";
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	
    	Payr0304SrhVO   payr0304rhVo = new Payr0304SrhVO();
    	
    	List<String> listDeptCd = new ArrayList<String>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	
    	
		try{
	        
	        /** 조건절 */
	        payr0304rhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        payr0304rhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        payr0304rhVo.setUsrId(sessionUser.getUsrId());  
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	  if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(param.get("deptCd"),sessionUser.getDeptCd()))) { 

	  	        	payr0304rhVo.setDeptCd(sessionUser.getDeptCd()); 
	  	            listDeptCd.add(sessionUser.getDeptCd());
	  	            payr0304rhVo.setDeptCdArr(listDeptCd);     //부서코드    
	  	           
	          	   } else {
	          		 
	          		 payr0304rhVo.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
                     listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
                     payr0304rhVo.setDeptCdArr(listDeptCd);     //부서코드   
	          	  }  
	        	  
	           payr0304rhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	payr0304rhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd"))) ;   //단위기관코드
	                 if (payr0304rhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) { 
	                 	 listDeptCd = null; 
	                 	payr0304rhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	payr0304rhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 payr0304rhVo.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
	                      payr0304rhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	        }
	        
	
	        payr0304rhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가  
	        payr0304rhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")).replace(",", ""));      
	         
	       /******************************** 권한 ************************************************************************/
	        payr0304rhVo.setPayCd(MSFSharedUtils.allowNulls(param.get("payCd")));  			//급여구분코드 
	        
	        payr0304rhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("emymtDivCd")));	//고용구분코드
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
	        payr0304rhVo.setTypOccuCdArr(lstTypeOccuCd); 
	        payr0304rhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("typOccuCd")));  	//직종
	       
	//        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
	//        payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	//        payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
	        payr0304rhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        payr0304rhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); //직종세
	        
	        payr0304rhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("businCd")));   			//사업코드 
	        payr0304rhVo.setPymtYrMnth(MSFSharedUtils.allowNulls(param.get("pymtYrMnth"))); 		//지급년월
	        payr0304rhVo.setSystemkey(MSFSharedUtils.allowNulls(param.get("systemkey")));  			//시스템키
	        payr0304rhVo.setHanNm(MSFSharedUtils.allowNulls(param.get("hanNm")));   		 		//한글성명 
	        payr0304rhVo.setPymtDducDivCd(MSFSharedUtils.allowNulls(param.get("pymtDducDivCd")));	//지급공제구분
	        payr0304rhVo.setPayDducExtpyCd(MSFSharedUtils.allowNulls(param.get("payDducExtpyCd")));	//지급공제항목
	       
	        List listPayr0307 = payrP420002ExcelService.selectXlsFilePayr304_307ToPayr4200List(payr0304rhVo);
	        
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listPayr0307.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPayr0307.get(i);
	    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
		    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("payFamyResnRegnNum", strValue);
	    			
	    		excelList.add(eMap);
	    	}
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPayr0307", excelList);
	        
	             
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
       
        return new ModelAndView("payrP420002ExcelView", map);
         
    }
      
    
}
