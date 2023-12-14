package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.PayrP420001ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.payroll.server.vo.Payr0307SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class PayrP420001ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(PayrP420001ExcelController.class);  
    private static final String calledClass = PayrP420001ExcelController.class.getName();

 
    
    @Resource(name = "payrP420001ExcelService")
    private PayrP420001ExcelService payrP420001ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.(급여대장)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPayrP420001Export.do")
    public ModelAndView xlsPayrP420001Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsPayrP420001Export";
    	
    	String windowNm = "급여(조정)내역관리";
		String windowId = "PAYRP420001";
    	
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	Payr0307SrhVO   payr0307SrhVo = new Payr0307SrhVO();
    	List<String> listDeptCd = new ArrayList<String>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	
		try{
	        /** 조건절 */
			payr0307SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
			payr0307SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        
			payr0307SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("emymtDivCd")));       //고용구분코드
	        
	
			payr0307SrhVo.setUsrId(sessionUser.getUsrId());  
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	
	        	  if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(param.get("deptCd"),sessionUser.getDeptCd()))) {

	  	        	payr0307SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	  	           listDeptCd.add(sessionUser.getDeptCd());
	  	           payr0307SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                  
	          	   } else {
	          		 payr0307SrhVo.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
                     listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
                     payr0307SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	          		 
	          	  }  
	        	   
	           payr0307SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	payr0307SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd"))) ;   //단위기관코드 
	                 if (payr0307SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) { 
	                 	 listDeptCd = null; 
	                 	payr0307SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	payr0307SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 payr0307SrhVo.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
	                      payr0307SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        
	
	        payr0307SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가  
	        payr0307SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")).replace(",", ""));      
        
//        String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//        if ("FALSE".equals(chkTypOccuCd)) {
//        	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//        	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//        } else {
//        	
//        }
        
       /******************************** 권한 ************************************************************************/
        
//        if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
//        	payr0304SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//        	List<String> listDeptCd = null; 
//        	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//        	payr0304SrhVO.setDeptCd("");     //부서코드
//        } else {
//
//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
//            payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//            payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));     //부서코드 
 //       }
        
        
        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
	        payr0307SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	        payr0307SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("typOccuCd")));  //직종
	       
	//        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
	//        payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	//        payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
	        payr0307SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        payr0307SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); //직종세
	        
	        payr0307SrhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("businCd")));   //사업코드 
	        
	        payr0307SrhVo.setPayCd(MSFSharedUtils.allowNulls(param.get("payCd")));  //급여구분코드 
	        payr0307SrhVo.setPymtYrMnth(MSFSharedUtils.allowNulls(param.get("pymtYrMnth"))); //지급년월
	        payr0307SrhVo.setSystemkey(MSFSharedUtils.allowNulls(param.get("systemkey")));  //시스템키
	        payr0307SrhVo.setHanNm(MSFSharedUtils.allowNulls(param.get("hanNm")));    //한글성명
	        
	        payr0307SrhVo.setPymtDducDivCd(MSFSharedUtils.allowNulls(param.get("pymtDducDivCd")));   //지급공제구분 	   
	        payr0307SrhVo.setPayItemCd(MSFSharedUtils.allowNulls(param.get("payItemCd")));   //지급공제항목 	
	        
	        
	        
	       
	        List listPayr4200 = payrP420001ExcelService.selectXlsPayrP420001List(payr0307SrhVo);
	        
	        
	        List<EgovMap> excelList = new ArrayList<EgovMap>();

	    	for(int i=0; i<listPayr4200.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPayr4200.get(i);
	    		// TODO 주민번호
	    		nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
	    		excelList.add(eMap);
	    	}
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPayr4200", excelList);
	             
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
       
        return new ModelAndView("payrP420001ExcelView", map);
         
    }
      
    
}
