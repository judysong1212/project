package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Payr1450ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.payroll.server.vo.Payr0485SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Payr1450ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Payr1450ExcelController.class);
    private static final String calledClass = Payr1450ExcelController.class.getName();

 
    
    @Resource(name = "payr1450ExcelService")
    private Payr1450ExcelService payr1450ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.(급여이체내역)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsFilePayr1450Export.do")
    public ModelAndView xlsPayr1450Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".savePayr1450";
    	
    	String windowNm = "수당공제항목출력";
		String windowId = "PAYR1450";
      
    	 Payr0485SrhVO   payr0485SrhVO = new Payr0485SrhVO();
//        
         MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
         List<String> listDeptCd = new ArrayList<String>();
         Map<String, Object> map = new HashMap<String, Object>();
         
     	// 1. 암호화 객체 생성
     	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
         
		try{
	    
			payr0485SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
			payr0485SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("emymtDivCd")));       //고용구분코드
			payr0485SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(param.get("pymtDducDivCd")));		//지급공제구분그룹선택
			List<String> lstPayExtpyGrpCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilPayExtpyGrpCdArr"))); //수당 그룹 코드
			payr0485SrhVO.setDtilPayExtpyGrpCdArr(lstPayExtpyGrpCd);
			//payr0485SrhVO.setUsrId(sessionUser.getUsrId());  
	         /******************************** 권한 ************************************************************************/
//	         String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//	         if ("FALSE".equals(chkDeptCd)) {
//	        	 payr0485SrhVO.setDeptCd(sessionUser.getDeptCd()); 
//	            listDeptCd.add(sessionUser.getDeptCd());
//	            payr0485SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
//	            payr0485SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//	         } else {
//	         	    
//	        	 payr0485SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd"))) ;   //단위기관코드
//	                  if (payr0485SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) { 
//	                  	 listDeptCd = null; 
//	                  	payr0485SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//	                  	payr0485SrhVO.setDeptCd("");  //부서코드
//	                  } else {
//	                	  payr0485SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
//	                       listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
//	                       payr0485SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
//	                  } 
//	               
//	         }
//	         
//	
//	         payr0485SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가  
//	         payr0485SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")).replace(",", ""));      
	          
	        /******************************** 권한 ************************************************************************/
//	         
//	         List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
//	         payr0485SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
//	         payr0485SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("typOccuCd")));  //직종
//	        
//	         List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
//	         payr0485SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//	         payr0485SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); //직종세 
//	         
//	         payr0485SrhVO.setPayCd(MSFSharedUtils.allowNulls(param.get("payCd")));  //급여구분코드   
//	         payr0485SrhVO.setBusinCd(MSFSharedUtils.allowNulls(param.get("businCd")));   //사업코드 
//	         payr0485SrhVO.setSystemkey(MSFSharedUtils.allowNulls(param.get("systemkey")));  //시스템키
//	         payr0485SrhVO.setHanNm(MSFSharedUtils.allowNulls(param.get("hanNm")));    //한글성명
			
			payr0485SrhVO.setPayDducGrpCd(MSFSharedUtils.allowNulls(param.get("payDducGrpCd")));	//지급공제
//			payr0485SrhVO.setPayDducGrpCd(MSFSharedUtils.allowNulls(param.get("payDducGrpCd")));	//지급공제
			payr0485SrhVO.setPayExtpyGrpCd(MSFSharedUtils.allowNulls(param.get("payExtpyGrpCd")));	//그룹
			payr0485SrhVO.setPayItemCd(MSFSharedUtils.allowNulls(param.get("payItemCd")));			//급여공제항목코드
			payr0485SrhVO.setYrtxFreeDtyReduCd(MSFSharedUtils.allowNulls(param.get("yrtxFreeDtyReduCd")));	//비과세감면코드
			payr0485SrhVO.setYrtxDotnCd(MSFSharedUtils.allowNulls(param.get("yrtxDotnCd")));	//기부금유형코드
			payr0485SrhVO.setExtptDducDspyYn(MSFSharedUtils.allowNulls(param.get("extptDducDspyYn")));	//화면출력
			payr0485SrhVO.setExtptDducUseYn(MSFSharedUtils.allowNulls(param.get("extptDducUseYn")));	//사용여부
			payr0485SrhVO.setAccAccCd(MSFSharedUtils.allowNulls(param.get("accAccCd")));				//회계계정
			payr0485SrhVO.setSevePayYn(MSFSharedUtils.allowNulls(param.get("sevePayYn")));				//퇴직정산포함여부
			payr0485SrhVO.setPayrTermUseYn(MSFSharedUtils.allowNulls(param.get("payrTermUseYn")));		//기간제출력여부
			
	        List listPayr1450 = payr1450ExcelService.selectXlsPayr1450List(payr0485SrhVO);
	        
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listPayr1450.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPayr1450.get(i);
	    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
		    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("payFamyResnRegnNum", strValue);
	    			
	    		excelList.add(eMap);
	    	}
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPayr1450", excelList);
	        
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
             
        
        return new ModelAndView("payr1450ExcelView", map);
         
    }
    
//    /**
//     * 이호조 연계 엑셀파일로 출력한다.
//     * @param searchVO 검색조건
//     * @return 엑셀파일
//     * @throws Exception
//     */
//    @RequestMapping(value="/exp/XlsHoJoPayr4400Export.do")
//    public ModelAndView xlsHoJoPayr4400Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
//                    throws Exception { 
//    	
//    	String method = calledClass + ".xlsHoJoPayr4400Export";
//    	
//    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//      
//    	Payr0485SrhVO   payr0485SrhVO = new Payr0485SrhVO();
////        dlgn0250SrhVo.setTypOccucdIn("");
////        dlgn0250SrhVo.setPyspGrdeCdIn("");
////
//    	 List<String> listDeptCd = new ArrayList<String>();
//         MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
////        
////        if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
////                && (ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
////           
////            dlgn0250SrhVo.setTypOccucdIn((sessionUser.getTypOccuCd().concat(sessionUser.getPyspGrdeCd()))); 
////            dlgn0250SrhVo.setPyspGrdeCdIn("1");
////            
////        } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
////                && (!ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
////           
////            dlgn0250SrhVo.setTypOccucdIn((sessionUser.getTypOccuCd().concat(sessionUser.getPyspGrdeCd())));  
////            dlgn0250SrhVo.setPyspGrdeCdIn("1"); 
////            
////        } else { 
////            dlgn0250SrhVo.setTypOccucdIn(""); 
////            dlgn0250SrhVo.setPyspGrdeCdIn("0");
////        }
//    
//         payr0301SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//         payr0301SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//         payr0301SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(param.get("pymtYrMnth"))); //지급년  
//         
//         payr0301SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("emymtDivCd")));       //고용구분코드
//         
//
//         payr0301SrhVO.setUsrId(sessionUser.getUsrId());  
//         /******************************** 권한 ************************************************************************/
//         String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//         if ("FALSE".equals(chkDeptCd)) {
//        	 payr0301SrhVO.setDeptCd(sessionUser.getDeptCd()); 
//            listDeptCd.add(sessionUser.getDeptCd());
//            payr0301SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
//            payr0301SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//         } else {
//         	    
//        	   payr0301SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd"))) ;   //단위기관코드
//                  if (payr0301SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) { 
//                  	 listDeptCd = null; 
//                  	payr0301SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//                  	payr0301SrhVO.setDeptCd("");  //부서코드
//                  } else {
//                	  payr0301SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
//                       listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
//                       payr0301SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
//                  } 
//               
//         }
//         
//
//         payr0301SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가  
//         payr0301SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")).replace(",", ""));      
//          
//        /******************************** 권한 ************************************************************************/
//         
//         
////         if (payr0301SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
////         	payr0301SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
////         	List<String> listDeptCd = null; 
////             payr0301SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
////             payr0301SrhVO.setDeptCd("");     //부서코드
////         } else {
////         	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
////             payr0301SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
////             payr0301SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));     //부서코드
////         } 
//         
//         List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
//         payr0301SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
//         payr0301SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("typOccuCd")));  //직종
//        
//         List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
//         payr0301SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//         payr0301SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
//          
//         List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
//         payr0301SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//         payr0301SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); //직종세 
//         
//         payr0301SrhVO.setPayCd(MSFSharedUtils.allowNulls(param.get("payCd")));  //급여구분코드   
//         payr0301SrhVO.setBusinCd(MSFSharedUtils.allowNulls(param.get("businCd")));   //사업코드 
//         payr0301SrhVO.setSystemkey(MSFSharedUtils.allowNulls(param.get("systemkey")));  //시스템키
//         payr0301SrhVO.setHanNm(MSFSharedUtils.allowNulls(param.get("hanNm")));    //한글성명
//         
////    	param.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
////    	// List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
////  	     
////  	    
////  	  if (MSFSharedUtils.allowNulls(param.get("payrMangDeptCd")).equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
////  		 param.put("payrMangDeptYn","Y");  //단위기관담당자여부  
////      	 param.put("deptCdArr","");  
////      	 param.put("deptCd","");  
////      } else { 
////    	  param.put("deptCdArr",MSFSharedUtils.allowNulls(param.get("deptCd")));  
////      }
////  	  
////        
////       // List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
////        param.put("typOccuCdArr",MSFSharedUtils.allowNulls(param.get("typOccuCd")));   
////       
////       // List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
////        param.put("pyspGrdeCdArr",MSFSharedUtils.allowNulls(param.get("pyspGrdeCd")));  
////       
////         
////       // List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
////        param.put("dtilOccuInttnCdArr",MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")));  
//        
//       
//        List listHoJoPayr4400 = payr1450ExcelService.selectXlsHoJoPayr4400List(payr0301SrhVO);
//        
//		String strValue = "";
//		List<EgovMap> excelList = new ArrayList<EgovMap>();
//
//	    for(int i=0; i<listHoJoPayr4400.size(); i++){
//    		EgovMap eMap  = new EgovMap();
//    		eMap = (EgovMap) listHoJoPayr4400.get(i);
//    		
//    			
//    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//	    		eMap.put("resnRegnNum", strValue);
//	    		
//    			
//    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//	    		eMap.put("payFamyResnRegnNum", strValue);
//    			
//    		excelList.add(eMap);
//    	}
//        
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("listHoJoPayr4400", excelList);
//        
//		/** 로그반영
//		 * CRUDSBLO
//		 * C:create		R:read		U:update
//    	 * D:delete		S:select	B:배치 
//    	 * L:로그인		O:로그아웃
//    	 */
//		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
//             
//       
//        return new ModelAndView("payrHoJo4400ExcelView", map);
//         
//    }
      
 
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
