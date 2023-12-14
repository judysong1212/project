package org.msf.exterms.remt.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.msf.exterms.remt.xls.service.Remt0300ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.retirement.server.vo.Remt3100SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class Remt0300ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Remt0300ExcelController.class);  
    private static final String calledClass = Remt0300ExcelController.class.getName();

 
    
    @Resource(name = "remt0300ExcelService")
    private Remt0300ExcelService remt0300ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsFileRemt0300Export.do")
    public ModelAndView xlsFileRemt0300Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
      
    	String method = calledClass + ".xlsFileRemt0300Export";
    	
    	String windowNm = "퇴직소득지급현황";
		String windowId = "REMT0300";
    	
    	
    	
    	Remt3100SrhVO   remt3100SrhVo = new Remt3100SrhVO();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
        Map<String, Object> map = new HashMap<String, Object>();
    	
//        dlgn0250SrhVo.setTypOccucdIn("");
//        dlgn0250SrhVo.setPyspGrdeCdIn("");
//        
 
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
        
        
		try{
        	
	         remt3100SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	         remt3100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	         remt3100SrhVo.setUsrId(sessionUser.getUsrId()); 
	         remt3100SrhVo.setClutYrMnth01(MSFSharedUtils.allowNulls(param.get("clutYrMnth01"))); //지급년월  
	         remt3100SrhVo.setClutYrMnth02(MSFSharedUtils.allowNulls(param.get("clutYrMnth02"))); //지급년월 
	         remt3100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd"))) ;   //단위기관코드
	         remt3100SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("emymtDivCd")));       //고용구분코드
	         
	 
	         
	         /******************************** 권한 ************************************************************************/
	         String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	         if ("FALSE".equals(chkDeptCd)) {
	        	 remt3100SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	            listDeptCd.add(sessionUser.getDeptCd());
	            remt3100SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	            remt3100SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	         } else {
	         	    
	        	 remt3100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd"))) ;   //단위기관코드 
	                  if (remt3100SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) { 
	                  	 listDeptCd = null; 
	                  	remt3100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                  	remt3100SrhVo.setDeptCd("");  //부서코드
	                  } else {
	                	  remt3100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
	                       listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
	                       remt3100SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                  } 
	               
	         }
	         
	
	         
	         remt3100SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가  
	         remt3100SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")).replace(",", ""));   
	          
	        /******************************** 권한 ************************************************************************/
	           
	         
	//         if (remt3100SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
	//         	remt3100SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
	//         	List<String> listDeptCd = null; 
	//             remt3100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	//             remt3100SrhVo.setDeptCd("");     //부서코드
	//         } else {
	//         	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
	//             remt3100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	//             remt3100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));     //부서코드
	//         } 
	         
	         List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
	         remt3100SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	         remt3100SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("typOccuCd")));  //직종
	        
	//         List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
	//         remt3100SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
	//         remt3100SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
	          
	         List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
	         remt3100SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	         remt3100SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); //직종세 
	         
	         remt3100SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(param.get("calcSevePayPsnDivCd")));  //퇴직정산구분코드   
	         remt3100SrhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("businCd")));   //사업코드 
	         remt3100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(param.get("systemkey")));  //시스템키
	         remt3100SrhVo.setHanNm(MSFSharedUtils.allowNulls(param.get("hanNm")));    //한글성명
	         
	//    	param.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	//    	// List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
	//  	     
	//  	    
	//  	  if (MSFSharedUtils.allowNulls(param.get("payrMangDeptCd")).equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
	//  		 param.put("payrMangDeptYn","Y");  //단위기관담당자여부  
	//      	 param.put("deptCdArr","");  
	//      	 param.put("deptCd","");  
	//      } else { 
	//    	  param.put("deptCdArr",MSFSharedUtils.allowNulls(param.get("deptCd")));  
	//      }
	//  	  
	//        
	//       // List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	//        param.put("typOccuCdArr",MSFSharedUtils.allowNulls(param.get("typOccuCd")));   
	//       
	//       // List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
	//        param.put("pyspGrdeCdArr",MSFSharedUtils.allowNulls(param.get("pyspGrdeCd")));  
	//       
	//         
	//       // List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	//        param.put("dtilOccuInttnCdArr",MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")));  
	        
	       
	        List listRemt0300 = remt0300ExcelService.selectXlsRemt0300List(remt3100SrhVo);
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listRemt0300", listRemt0300);
	             
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
		
        return new ModelAndView("remt0300ExcelView", map);
         
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
