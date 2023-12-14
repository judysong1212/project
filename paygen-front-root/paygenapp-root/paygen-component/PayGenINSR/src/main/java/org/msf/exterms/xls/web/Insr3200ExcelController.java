package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Insr3200ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.insurance.server.vo.Insr4300SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Insr3200ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Insr3200ExcelController.class);  
    private static final String calledClass = Insr3200ExcelController.class.getName();
 
    
    @Resource(name = "insr3200ExcelService")
    private Insr3200ExcelService insr3200ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsInsr3200Export.do")  
    public ModelAndView xlsInsr1100AqtnExport(@ModelAttribute("Insr4300SrhVO") Insr4300SrhVO insr4300SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception {  
    	
    	String method = calledClass + ".xlsInsr1100AqtnExport";
    	
    	String windowNm = "국민연금소득총액신고";
		String windowId = "INSR3200";
    	
    	String chkAntyDeinYr = "";   //구분자에 따라 쿼리를 다르게 가져옴.
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	    List<String> listDeptCd = new ArrayList<String>(); 
	    
	    
	    insr4300SrhVo.setUsrId(sessionUser.getUsrId());  
	    insr4300SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	    insr4300SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	    insr4300SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(insr4300SrhVo.getMangeDeptCd())); //단위기관담당자여부 
	    insr4300SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(insr4300SrhVo.getRepbtyBusinDivCd()));
     
	    List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4300SrhVo.getTypOccuCd())); 
	    insr4300SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	   // insr4300SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	   
	    List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4300SrhVo.getPyspGrdeCd())); 
	    insr4300SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
	   // insr4300SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	     
	    List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4300SrhVo.getDtilOccuInttnCd())); 
	    insr4300SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	   // insr4300SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	     
	    List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4300SrhVo.getHdofcCodtnCd())); 
	    insr4300SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);  
	   // insr4300SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
     
    
//    if (ExtermsProps.AUTH_USR_DIV_10.equals(sessionUser.getUsrDivCd()) && ExtermsProps.AUTH_USR_DIV_40.equals(sessionUser.getUsrDivCd())){
//	    
//		
//	   } else if (ExtermsProps.AUTH_USR_DIV_20.equals(sessionUser.getUsrDivCd())){
//		   
//		   
//	   } else if (ExtermsProps.AUTH_USR_DIV_25.equals(sessionUser.getUsrDivCd())){
//		   
//		   
//	   } else {
//		   
//		//   List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd()));  
//	     //   insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드  
//	    //    insr4300SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//		   
//		   if ("Y".equals(sessionUser.getPayrMangDeptYn())) {
//			    
//				if (" ".equals(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd()))) {
//					insr4300SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
// 		            insr4300SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd())) ;   //단위기관코드
// 		            List<String> listDeptCd = null;  
// 		            insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드
// 		            insr4300SrhVo.setDeptCd("");  
// 		             
//			     } else if ("405030200".equals(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd()))) {
//			    	 
//			    	insr4300SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
// 		            insr4300SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd())) ;   //단위기관코드
// 		            List<String> listDeptCd = null;  
// 		            insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드
// 		            insr4300SrhVo.setDeptCd("");  
// 		            
//			     } else {
//			    	 
//			     } 
//		   } else {
//			    
//				if (" ".equals(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd()))) {
//					insr4300SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
// 		            insr4300SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd())) ;   //단위기관코드
// 		            List<String> listDeptCd = null;  
// 		            insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드
// 		            insr4300SrhVo.setDeptCd("");  
//			     } else if ("405030200".equals(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd()))) {
//			    	insr4300SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
// 		            insr4300SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd())) ;   //단위기관코드
// 		            List<String> listDeptCd = null;  
// 		            insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드
// 		            insr4300SrhVo.setDeptCd("");  
//			     } else {
//			    	 
//			     } 
//		   }
//			
//	   }
    
    /******************************** 권한 ************************************************************************/
    String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
    if ("FALSE".equals(chkDeptCd)) {
    	insr4300SrhVo.setDeptCd(sessionUser.getDeptCd()); 
       listDeptCd.add(sessionUser.getDeptCd());
       insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
       insr4300SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
    } else {
    	    
    	    insr4300SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr4300SrhVo.getPayrMangDeptCd()));    
             if (insr4300SrhVo.getPayrMangDeptCd().equals(insr4300SrhVo.getDeptCd())) { 
             	 listDeptCd = null; 
             	insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
             	insr4300SrhVo.setDeptCd("");  //부서코드
             } else {
            	 insr4300SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd()));
                  listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd()));  
                  insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
             } 
          
    }
     
    
    insr4300SrhVo.setDeptCdAuth(insr4300SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
    insr4300SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr4300SrhVo.getDtilOccuInttnCd()).replace(",", ""));
  
   /******************************** 권한 ************************************************************************/
     
    
//    if (insr4300SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd()))) {
//    	insr4300SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//    	List<String> listDeptCd = null; 
//    	insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//    	insr4300SrhVo.setDeptCd("");     //부서코드
//    } else {
//
//        List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd()));  
//        insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드  
//        insr4300SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd()));     //부서코드 
//    }
      
      chkAntyDeinYr = MSFSharedUtils.allowNulls(insr4300SrhVo.getChkAntyDeinYr()); 
      
      
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인		O:로그아웃
		 */
		//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
      String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
      List<EgovMap> excelList = new ArrayList<EgovMap>();
      if ("01".equals(chkAntyDeinYr)) {
    	  
    	  Map<String, Object> map = new HashMap<String, Object>();
    	  
    	  
          try{
        	  
        	  List  listInsr4300 = insr3200ExcelService.selectInsr320001ToInsr4300List(insr4300SrhVo);
        	 
      		

      		for(int i=0; i<listInsr4300.size(); i++){
      			EgovMap eMap  = new EgovMap();
      			eMap = (EgovMap) listInsr4300.get(i);
      			// TODO 주민번호
      			String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
      			eMap.put("resnRegnNum", strValue);
      			excelList.add(eMap);
      		}


//              Map<String, Object> map = new HashMap<String, Object>();
              map = new HashMap<String, Object>();
              map.put("listInsr4300", excelList);
          	
          }catch(Exception e) {
          	e.printStackTrace();
          	
  	    	/** 에러 로그 **/			
  	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
          	
          }
          
          return new ModelAndView("insr320001ExcelView", map);
          
      } else {
    	  
    	  Map<String, Object> map = new HashMap<String, Object>();
    	  
          try{
        	  
        	  List  listInsr4300 = insr3200ExcelService.selectInsr320002ToInsr4300List(insr4300SrhVo);
        	  
      		

      		for(int i=0; i<listInsr4300.size(); i++){
      			EgovMap eMap  = new EgovMap();
      			eMap = (EgovMap) listInsr4300.get(i);
      			// TODO 주민번호
      			String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
      			eMap.put("resnRegnNum", strValue);
      			excelList.add(eMap);
      		}


//              Map<String, Object> map = new HashMap<String, Object>();
        	  map = new HashMap<String, Object>();
              map.put("listInsr4300", excelList);
          	
          }catch(Exception e) {
          	e.printStackTrace();
          	
  	    	/** 에러 로그 **/			
  	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
          	
          }
          
          return new ModelAndView("insr320002ExcelView", map);
      } 
         
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
//                        || file.getOriginalFilename().endsWith(".XLS") ) {
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
//                        fis = file.getInputStream();
//                        fis2 = file.getInputStream();
//                      
//                        dlgn0250ExcelService.insertXSSFDlgn0100(fis);
//                        dlgn0250ExcelService.insertXSSFDlgn0200(fis2);
//                        
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
