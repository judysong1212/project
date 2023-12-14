package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Payr4220ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.payroll.server.vo.Payr0303SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Payr4220ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Payr4220ExcelController.class);  
    private static final String calledClass = Payr4220ExcelController.class.getName();

 
    
    @Resource(name = "payr4220ExcelService")
    private Payr4220ExcelService payr4220ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPayr4220Export.do")
    public ModelAndView xlsPayr4220Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsPayr4220Export";
    	
    	String windowNm = "급여소급내역관리";
		String windowId = "PAYR4220";
    	
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
      
    	Payr0303SrhVO   payr0303SrhVO = new Payr0303SrhVO();
//        dlgn0250SrhVo.setTypOccucdIn("");
//        dlgn0250SrhVo.setPyspGrdeCdIn("");
//        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        Map<String, Object> map = new HashMap<String, Object>();
    	
        
//        
//        if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
//                && (ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
//           
//            dlgn0250SrhVo.setTypOccucdIn((sessionUser.getTypOccuCd().concat(sessionUser.getPyspGrdeCd()))); 
//            dlgn0250SrhVo.setPyspGrdeCdIn("1");
//            
//        } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
//                && (!ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
//           
//            dlgn0250SrhVo.setTypOccucdIn((sessionUser.getTypOccuCd().concat(sessionUser.getPyspGrdeCd())));  
//            dlgn0250SrhVo.setPyspGrdeCdIn("1"); 
//            
//        } else { 
//            dlgn0250SrhVo.setTypOccucdIn(""); 
//            dlgn0250SrhVo.setPyspGrdeCdIn("0");
//        }
    	
//         param.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//    	 
//         if (MSFSharedUtils.allowNulls(param.get("payrMangDeptCd")).equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
//    		 param.put("payrMangDeptYn","Y");  //단위기관담당자여부  
//        	 param.put("deptCdArr","");  
//        	 param.put("deptCd","");  
//	     } else { 
//	
//	       	    // List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
//	       	     param.put("deptCdArr",MSFSharedUtils.allowNulls(param.get("deptCd")));    
//	     }
//          
//         // List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
//          param.put("typOccuCdArr",MSFSharedUtils.allowNulls(param.get("typOccuCd")));   
//         
//         // List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
//          param.put("pyspGrdeCdArr",MSFSharedUtils.allowNulls(param.get("pyspGrdeCd")));  
//         
//           
//         // List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
//          param.put("dtilOccuInttnCdArr",MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")));  
          
        List<String> listDeptCd = new ArrayList<String>();
        
		try{
        
	        /** 조건절 */
	        payr0303SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        payr0303SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        
	        payr0303SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("emymtDivCd")));       //고용구분코드
	        
	
	        payr0303SrhVO.setUsrId(sessionUser.getUsrId());  
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	  if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(param.get("deptCd"),sessionUser.getDeptCd()))) {

	  	        	payr0303SrhVO.setDeptCd(sessionUser.getDeptCd()); 
	  	           listDeptCd.add(sessionUser.getDeptCd());
	  	           payr0303SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	                  
	          	   } else {
	          		 
	          		 payr0303SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
                     listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
                     payr0303SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
	          	  }  
	        	     
	           payr0303SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	payr0303SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd"))) ;   //단위기관코드
	                 if (payr0303SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) { 
	                 	 listDeptCd = null; 
	                 	payr0303SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	                 	payr0303SrhVO.setDeptCd("");  //부서코드
	                 } else {
	                	 payr0303SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
	                      payr0303SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        
	
	        payr0303SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가  
	        payr0303SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")).replace(",", ""));      
	         
	       /******************************** 권한 ************************************************************************/
	        
	//        if (payr0303SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
	//        	payr0303SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
	//        	List<String> listDeptCd = null; 
	//        	payr0303SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	//        	payr0303SrhVO.setDeptCd("");     //부서코드
	//        } else {
	//
	//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
	//            payr0303SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
	//            payr0303SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));     //부서코드 
	//        }
	        
	        
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
	        payr0303SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	        payr0303SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("typOccuCd")));  //직종
	       
	//        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
	//        payr0303SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	//        payr0303SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
	        payr0303SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        payr0303SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); //직종세
	        
	        payr0303SrhVO.setBusinCd(MSFSharedUtils.allowNulls(param.get("businCd")));   //사업코드 
	        
	        payr0303SrhVO.setPayCd(MSFSharedUtils.allowNulls(param.get("payCd")));  //급여구분코드 
	        payr0303SrhVO.setReattyApptnYrMnth(MSFSharedUtils.allowNulls(param.get("reattyApptnYrMnth"))); //지급년월
	        payr0303SrhVO.setSystemkey(MSFSharedUtils.allowNulls(param.get("systemkey")));  //시스템키
	        payr0303SrhVO.setHanNm(MSFSharedUtils.allowNulls(param.get("hanNm")));    //한글성명 
	      
	        payr0303SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(param.get("mangeDeptCd")));    //관리부서
	        payr0303SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(param.get( "repbtyBusinDivCd")) ); //호봉제구분

	        
	        
	        List listPayr4220 = payr4220ExcelService.selectXlsPayr4220List(payr0303SrhVO);
	        
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listPayr4220.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPayr4220.get(i);
	    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
		    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("payFamyResnRegnNum", strValue);
	    			
	    		listPayr4220.add(eMap);
	    	}
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPayr4220", excelList);
	             
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
		
        return new ModelAndView("payr4220ExcelView", map);
         
    }
   
 
//    /**
//     * 엑셀파일을 업로드하여  등록한다.
//     * @param loginVO
//     * @param request
//     * @param commandMap
//     * @param model
//     * @return  
//     * @throws Exception
//     */
//    @RequestMapping(value = "/imp/XlsDlgn0250Import.do")
//    public String xlsDlgn0250Import(@ModelAttribute("Dlgn0250VO") Dlgn0250VO dlgn0250Vo,final HttpServletRequest request
//            , Map commandMap , Model model) throws Exception {
//         
////        String sCmd = commandMap.get("dlgn0250flUp") == null ? "" : (String)commandMap.get("dlgn0250flUp");
////        if (sCmd.equals("")) {
////          return;
////        }
//
//        if  (dlgn0250ExcelService == null) { 
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( request.getSession().getServletContext());
//
//            dlgn0250ExcelService = (Dlgn0250ExcelService) wac.getBean("Dlgn0250ExcelService" ); 
//           
//       }
//        
//        final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//        final Map<String, MultipartFile> files = multiRequest.getFileMap();
//        InputStream fis = null; // 2011.11.1 보안점검 후속조치
//        InputStream fis2 = null; // 2011.11.1 보안점검 후속조치
//
//        String sResult = "";
//        
//        Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
//        MultipartFile file;
//
//        while (itr.hasNext()) {
//            Entry<String, MultipartFile> entry = itr.next();
//
//            file = entry.getValue();
//            if (!"".equals(file.getOriginalFilename())) {
//                // 2011.10.07 업로드 파일에 대한 확장자를 체크
//                if (file.getOriginalFilename().endsWith(".xls")
//                        || file.getOriginalFilename().endsWith(".xlsx")
//                        || file.getOriginalFilename().endsWith(".XLS")
//                        || file.getOriginalFilename().endsWith(".XLSX")) {
//                    
//                  
//                    //2011.10.21 보안점검 후속조치
//                    try {
//                        fis = file.getInputStream();
//                        fis2 = file.getInputStream();
//                      
//                        dlgn0250ExcelService.insertXlsDlgn0100(fis);
//                        dlgn0250ExcelService.insertXlsDlgn0200(fis2);
//                      
//                    } catch(Exception e) {
//                      //  throw e;
//                        sResult = "error";
//                       
//                    } finally {
//                        if (fis != null)    // 2011.11.1 보안점검 후속조치
//                            fis.close();
//                    }
//                    
//                    sResult =  "success";
//                    
//                }else{
//                    logger.info("xls, xlsx 파일 타입만 등록이 가능합니다."); 
//                    sResult =  "success";
//                }
//                // *********** 끝 ***********
//               
//            }
//        }
//        return sResult;
// 
//    }
    
}
