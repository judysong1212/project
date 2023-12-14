package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.InsrP410003ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.insurance.server.vo.Insr3000SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class InsrP410003ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(InsrP410003ExcelController.class);  
    private static final String calledClass = InsrP410003ExcelController.class.getName();

 
    
    @Resource(name = "InsrP410003ExcelService")
    private InsrP410003ExcelService insrP410003ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

//    /**
//     * 엑셀파일로 출력한다.
//     * @param searchVO 검색조건
//     * @return 엑셀파일
//     * @throws Exception
//     */
//    @RequestMapping(value="/exp/XlsInsrP410003TempExport.do")   
//    public ModelAndView xlsInsr3100TempExport(HttpServletRequest request ,ModelMap model) 
//                    throws Exception { 
//       
//        
//        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//        
////        insr3000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
////        insr3000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
////        
////        
////        List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getDeptCd()));  
////        insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드  
////    //    insr3000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
////        
////        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getTypOccuCd())); 
////        insr3000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
////       // insr3000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
////       
////        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getPyspGrdeCd())); 
////        insr3000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
////       // insr3000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
////         
////        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getDtilOccuInttnCd())); 
////        insr3000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//       // insr3000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
//         
//        
////        if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
////                && (ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
////           
////            insr3000SrhVo.setTypOccucdIn((sessionUser.getTypOccuCd().concat(sessionUser.getPyspGrdeCd()))); 
////            insr3000SrhVo.setPyspGrdeCdIn("1");
////            
////        } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
////                && (!ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
////           
////            insr3000SrhVo.setTypOccucdIn((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))));  
////            insr3000SrhVo.setPyspGrdeCdIn("1"); 
////            
////        } else { 
////            insr3000SrhVo.setTypOccucdIn(""); 
////            insr3000SrhVo.setPyspGrdeCdIn("0");
////        }
//        
//         
//      //  List<Dlgn0250VO> listDlgn0250 = dlgn0250ExcelService.selectXlsDlgn0250List(insr3000SrhVo);
//        
//        Map<String, Object> map = new HashMap<String, Object>(); 
//        
//        return new ModelAndView("insr3100TempExcelView", map);
//         
//    }
    
    /**
     *  엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsInsrP410003Export.do")   
    public ModelAndView xlsInsrP410003Export(@ModelAttribute("Insr3000SrhVO") Insr3000SrhVO insr3000SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
       
    	String method = calledClass + ".xlsInsrP410003Export";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
        Map<String, Object> map = new HashMap<String, Object>(); 
        
    	String windowNm = "건강보험기본관리";
		String windowId = "INSRP410003";
        
		try{
        	
	        insr3000SrhVo.setUsrId(sessionUser.getUsrId());  
	        insr3000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        insr3000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        
	        List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getHdofcCodtnCd())); 
	        insr3000SrhVo.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태
	        insr3000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getEmymtDivCd()));	         //고용구분
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getTypOccuCd())); 
	        insr3000SrhVo.setTypOccuCdArr(lstTypeOccuCd); //직종       
	     	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getDtilOccuInttnCd())); 
	     	insr3000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세
	     	insr3000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getBusinCd()));   //사업
	        
	     	insr3000SrhVo.setHanNm(MSFSharedUtils.allowNulls(insr3000SrhVo.getHanNm()));			//성명
	     	insr3000SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(insr3000SrhVo.getResnRegnNum()));//주민번호
	        
	     	insr3000SrhVo.setPayYr(MSFSharedUtils.allowNulls(insr3000SrhVo.getPayYr()));
	        
	     	insr3000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(insr3000SrhVo.getSystemkey()));	//시스템키
	        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getSystemkey())); 
	        insr3000SrhVo.setSystemKeyArr(systemKeyArr);
	        
	        String deptCd = MSFSharedUtils.allowNulls(insr3000SrhVo.getDeptCd());
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	insr3000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           insr3000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	insr3000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getPayrMangDeptCd()));  
	        	insr3000SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getPayrMangDeptCd()));
	                 if (insr3000SrhVo.getPayrMangDeptCd().equals(insr3000SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	insr3000SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 insr3000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getDeptCd()));  
	                      insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        insr3000SrhVo.setDeptCdAuth(deptCd.replace(",", ""));  //권한처리를위해 추가  
	        insr3000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr3000SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	        
	       /******************************** 권한 ************************************************************************/
	         
	        List listInsrP3000 = insrP410003ExcelService.selectXlsInsrP410003ToInsr3000List(insr3000SrhVo);
	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listInsrP3000.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listInsrP3000.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}
//	        Map<String, Object> map = new HashMap<String, Object>(); 
	        map = new HashMap<String, Object>(); 
	        map.put("listInsrP3000", excelList);
	        
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
        
        return new ModelAndView("insrP410003ExcelView", map);
         
    }
     

    /**
     * 엑셀파일을 업로드하여  등록한다.
     * @param loginVO
     * @param request
     * @param commandMap
     * @param model
     * @return  
     * @throws Exception
     */
//    @RequestMapping(value = "/imp/XlsInsr3100Import.do")
//    public String xlsInsr3100Import(@ModelAttribute("Insr4300VO") Insr4300VO insr4300Vo,final HttpServletRequest request
//            , Map commandMap , Model model) throws Exception {
//         
////        String sCmd = commandMap.get("dlgn0250flUp") == null ? "" : (String)commandMap.get("dlgn0250flUp");
////        if (sCmd.equals("")) {
////          return;
////        }
//
//        if  (insr3100ExcelService == null) { 
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( request.getSession().getServletContext());
//
//            insr3100ExcelService = (Insr3100ExcelService) wac.getBean("Insr3100ExcelService" ); 
//           
//       }
//        
//        final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//        final Map<String, MultipartFile> files = multiRequest.getFileMap();
//        InputStream fis = null; // 2011.11.1 보안점검 후속조치
//        InputStream fis2 = null; // 2011.11.1 보안점검 후속조치
//        InputStream fis3 = null; // 2011.11.1 보안점검 후속조치
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
//                        || file.getOriginalFilename().endsWith(".XLS") ) {
//                    
//                         
//                    //2011.10.21 보안점검 후속조치
//                    try {
//                        fis = file.getInputStream();  //4300인서트 
//                        fis2 = file.getInputStream(); //4100 업데이트 
//                        fis3 = file.getInputStream(); //127 업데이트 
//                      
//                        insr3100ExcelService.insertXlsInsr4300(fis); 
//                        insr3100ExcelService.insertXlsInsr4100(fis2); 
//                        insr3100ExcelService.insertXlsPsnl0127(fis3); 
//                         
//                        sResult =  "success";
//                    } catch(Exception e) {
//                          e.printStackTrace();
//                        sResult = "error";
//                       
//                    } finally {
//                        if (fis != null)    // 2011.11.1 보안점검 후속조치
//                            fis.close();
//                    }
//                  
//                    
//                    
//                } else  if (  file.getOriginalFilename().endsWith(".xlsx")
//                        || file.getOriginalFilename().endsWith(".XLSX")) {
//                    
//                    //2011.10.21 보안점검 후속조치
//                    try {
//                    	 fis = file.getInputStream();  //4300인서트 
//                         fis2 = file.getInputStream(); //4100 업데이트 
//                         fis3 = file.getInputStream(); //127 업데이트 
//                      
//                        insr3100ExcelService.insertXSSFInsr4300(fis);   
//                        insr3100ExcelService.insertXSSFInsr4100(fis2); 
//                        insr3100ExcelService.insertXSSFPsnl0127(fis3); 
//                        
//                        sResult =  "success";
//                        
//                    } catch(Exception e) {
//                          e.printStackTrace();
//                        sResult = "error";
//                       
//                    } finally {
//                        if (fis != null)    // 2011.11.1 보안점검 후속조치
//                            fis.close();
//                    } 
//                       
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
