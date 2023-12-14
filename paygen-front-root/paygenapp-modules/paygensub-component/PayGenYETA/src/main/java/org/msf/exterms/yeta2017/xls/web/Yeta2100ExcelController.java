package org.msf.exterms.yeta2017.xls.web;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.yeta2017.xls.service.Yeta2100ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.yearendtax.server.vo.Ye161010SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Yeta2100ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Yeta2100ExcelController.class);  
    private static final String calledClass = Yeta2100ExcelController.class.getName();
 
    
    @Resource(name = "yeta2100ExcelService")
    private Yeta2100ExcelService yeta2100ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    

    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsYeta2100Export.do")
    public ModelAndView XlsYeta2100Export(@ModelAttribute("Ye161010SrhVO") Ye161010SrhVO ye161010SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".XlsYeta2100Export";
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//    	Pyyt0304SrhVO   pyyt0304SrhVO = new Pyyt0304SrhVO();
    	List<String> listDeptCd = new ArrayList<String>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	
    	String windowNm = "급여내역(정산용)관리";
		String windowId = "YETA2100";
    	
    	
    	// 1. 암호화 객체 생성
    	
		try{
			
			 String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			 
	        /** 조건절 */
			 ye161010SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
			 ye161010SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        
			 ye161010SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getEmymtDivCd()));       //고용구분코드
	        
	
			 ye161010SrhVo.setUsrId(sessionUser.getUsrId());  
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	
	    	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(ye161010SrhVo.getDeptCd(),sessionUser.getDeptCd()))) {

		        	ye161010SrhVo.setDeptCd(sessionUser.getDeptCd()); 
		           listDeptCd.add(sessionUser.getDeptCd());
		           ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	                
	        	   } else {
	        		   ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010SrhVo.getDeptCd()));  
	                      ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	        		 
	        	  }  
	    	    
	           ye161010SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	ye161010SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getPayrMangDeptCd())) ;   //단위기관코드 
	                 if (ye161010SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(ye161010SrhVo.getDeptCd()))) { 
	                 	 listDeptCd = null; 
	                 	ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	ye161010SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010SrhVo.getDeptCd()));  
	                      ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        
	
	        ye161010SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(ye161010SrhVo.getDeptCd().replace(",", "")));  //권한처리를위해 추가  
	        ye161010SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(ye161010SrhVo.getDtilOccuInttnCd()).replace(",", "")); 
	        
       /******************************** 권한 ************************************************************************/
        
//        if (pyyt0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
//        	pyyt0304SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//        	List<String> listDeptCd = null; 
//        	pyyt0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//        	pyyt0304SrhVO.setDeptCd("");     //부서코드
//        } else {
//
//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
//            pyyt0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//            pyyt0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));     //부서코드 
 //       }
        
        
        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010SrhVo.getTypOccuCd())); 
	        ye161010SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	        ye161010SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getTypOccuCd()));  //직종
	       
	//        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
	//        pyyt0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	//        pyyt0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010SrhVo.getDtilOccuInttnCd())); 
	        ye161010SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        ye161010SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getDtilOccuInttnCd())); //직종세
	        
	        ye161010SrhVo.setBusinCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getBusinCd()));   		//사업코드 
	        
	        ye161010SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161010SrhVo.getYrtxBlggYr())); 	//정산년월
	        ye161010SrhVo.setSystemkey(MSFSharedUtils.allowNulls(ye161010SrhVo.getSystemkey()));  	//시스템키
	        ye161010SrhVo.setFnm(MSFSharedUtils.allowNulls(ye161010SrhVo.getFnm()));    			//한글성명 
	        ye161010SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getClutSeptCd()));	//정산구분
	       
//	        EgovMap listPayr42001 = yeta1900ExcelService.selectXlsPyyt0304List1(pyyt0304SrhVO);
	        List<EgovMap> listPayr2100 = yeta2100ExcelService.selectXlsYeta2100List(ye161010SrhVo);
	        
	        
	        
	    	List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listPayr2100.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listPayr2100.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}
			
			map.put("listYeta2100", excelList);
	             
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
       
        return new ModelAndView("yeta2100ExcelView", map);
         
    }
    
    
    
    
}