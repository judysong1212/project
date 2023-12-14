package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Dlgn0300ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.dlgn.server.vo.Dlgn0300SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Dlgn0300ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Dlgn0300ExcelController.class);
    private static final String calledClass = Dlgn0300ExcelController.class.getName();
 
    
    @Resource(name = "Dlgn0300ExcelService")
    private Dlgn0300ExcelService dlgn0300ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

//    /**
//     * 엑셀파일로 출력한다.
//     * @param searchVO 검색조건
//     * @return 엑셀파일
//     * @throws Exception
//     */
//    @RequestMapping(value="/exp/XlsDlgn0250Export.do")
//    public ModelAndView xlsDlgn0250Export(@ModelAttribute("Dlgn0300SrhVO") Dlgn0300SrhVO dlgn0300SrhVo,HttpServletRequest request ,ModelMap model) 
//                    throws Exception { 
//       
//       
////        dlgn0300SrhVo.setTypOccucdIn("");
////        dlgn0300SrhVo.setPyspGrdeCdIn("");
//        
//        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//        
//        dlgn0300SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//        dlgn0300SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//        
//        
//     //   List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDeptCd()));  
//     //   dlgn0300SrhVo.setDeptCdArr(listDeptCd);     //부서코드  
//    //    dlgn0300SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//        
//        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getTypOccuCd())); 
//        dlgn0300SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
//       // dlgn0300SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//       
//        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getPyspGrdeCd())); 
//        dlgn0300SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//       // dlgn0300SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//         
//        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDtilOccuInttnCd())); 
//        dlgn0300SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//       // dlgn0300SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
//         
//        
////        if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
////                && (ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
////           
////            dlgn0300SrhVo.setTypOccucdIn((sessionUser.getTypOccuCd().concat(sessionUser.getPyspGrdeCd()))); 
////            dlgn0300SrhVo.setPyspGrdeCdIn("1");
////            
////        } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
////                && (!ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
////           
////            dlgn0300SrhVo.setTypOccucdIn((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))));  
////            dlgn0300SrhVo.setPyspGrdeCdIn("1"); 
////            
////        } else { 
////            dlgn0300SrhVo.setTypOccucdIn(""); 
////            dlgn0300SrhVo.setPyspGrdeCdIn("0");
////        }
//        
//        if (dlgn0300SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDeptCd()))) {
//        	dlgn0300SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//        	List<String> listDeptCd = null; 
//        	dlgn0300SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//        	dlgn0300SrhVo.setDeptCd("");     //부서코드
//        } else {
// 
//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDeptCd()));  
//            dlgn0300SrhVo.setDeptCdArr(listDeptCd);     //부서코드  
//            dlgn0300SrhVo.setDeptCd(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDeptCd()));     //부서코드 
//        }
//        
//         
//        List<Dlgn0250VO> listDlgn0250 = dlgn0250ExcelService.selectXlsDlgn0250List(dlgn0300SrhVo);
//        
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("listDlgn0250", listDlgn0250);
//        
//        return new ModelAndView("dlgn0250ExcelView", map);
//         
//    }
    
    
    
    /**
     * 엑셀파일로 출력한다.(상단버튼)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsFileDlgn0300Export.do")
    public ModelAndView xlsFileDlgn0300Export(@ModelAttribute("Dlgn0300SrhVO") Dlgn0300SrhVO dlgn0300SrhVo, HttpServletRequest request,ModelMap model) 
                    throws Exception { 
       
    	
    	String method = calledClass + ".xlsFileDlgn0300Export";
    	
    	String windowNm = "근무월별집계";
		String windowId = "DLGN0030";
       
//        dlgn0300SrhVo.setTypOccucdIn("");
//        dlgn0300SrhVo.setPyspGrdeCdIn("");
        
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();
        Map<String, Object> map = new HashMap<String, Object>();
        
        // 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

        
        try{
        	
	        dlgn0300SrhVo.setDpobCd(sessionUser.getDpobCd());  			//사업장코드
	        dlgn0300SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());	//단위기관담당자여부 
	        
	        dlgn0300SrhVo.setSystemkey(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getSystemkey()));	//시스템키
	        dlgn0300SrhVo.setHanNm(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getHanNm()));			//성명
//	        dlgn0300SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getResnRegnNum()));//주민번호
	        
	        // 2. 파라미터 보낼 때(암호화)
	        dlgn0300SrhVo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0300SrhVo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호

	        dlgn0300SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getEmymtDivCd()));	//고용구분코드
	        
	        dlgn0300SrhVo.setUsrId(sessionUser.getUsrId()); 			//유저 아이디 
	        
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getTypOccuCd())); 
	        dlgn0300SrhVo.setTypOccuCdArr(lstTypeOccuCd);				//직종 
	
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDtilOccuInttnCd())); 
	        dlgn0300SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  	//직종세
	        
	        dlgn0300SrhVo.setBusinCd(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getBusinCd()));   //사업코드 
	
	
	        
	        dlgn0300SrhVo.setDeptCdAuth(dlgn0300SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        dlgn0300SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	        
	        dlgn0300SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getPayrMangDeptCd()));    
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	dlgn0300SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	        	listDeptCd.add(sessionUser.getDeptCd());
	        	dlgn0300SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	        	dlgn0300SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	
	        	
	        	if (dlgn0300SrhVo.getPayrMangDeptCd().equals(dlgn0300SrhVo.getDeptCd())) { 
	        		listDeptCd = null; 
	        		dlgn0300SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                dlgn0300SrhVo.setDeptCd("");  //부서코드
	        	} else {
	        		dlgn0300SrhVo.setDeptCd(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDeptCd()));
	        		listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDeptCd()));  
	        		dlgn0300SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	        	} 
	        }
	         
	        
	           HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); ;
			
	
	           		/**
	      	         * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
	      	         */
	                  if (dlgn0300SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDeptCdAuth())) 
	              			|| MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDeptCdAuth()).contains(dlgn0300SrhVo.getPayrMangDeptCd())
	              			) {
	                     if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//용인로직 
	                    	 dlgn0300SrhVo.setRepbtyBusinDivCd("");
	                  	   
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//김해로직 
	           				//호봉제구분코드 포함해서 가져 오기 REPBTY_BUSIN_DIV_CD
	           				dlgn0300SrhVo.setRepbtyBusinDivCd("A0480010");
	           				
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//거제로직 
	           				dlgn0300SrhVo.setRepbtyBusinDivCd("");
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//안양로직 
	           				dlgn0300SrhVo.setRepbtyBusinDivCd("");
	           			
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//광명로직 
	           				dlgn0300SrhVo.setRepbtyBusinDivCd("");
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//삼척로직 
	           				dlgn0300SrhVo.setRepbtyBusinDivCd("");
	           			
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//수원로직 
	           				dlgn0300SrhVo.setRepbtyBusinDivCd("");
	           			
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//울주로직 
	           				dlgn0300SrhVo.setRepbtyBusinDivCd("");
	           			}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
	           				
	           				dlgn0300SrhVo.setRepbtyBusinDivCd("");
	           				 
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
	           				
	           				dlgn0300SrhVo.setRepbtyBusinDivCd("");
	           				 
	           				
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
	           				
	           				dlgn0300SrhVo.setRepbtyBusinDivCd("");
	           				
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//public static final String PAYGEN_MUNICIPALITIES_12 = "GWGS";    //강원도고성군청
	           				
	           				dlgn0300SrhVo.setRepbtyBusinDivCd("");
	           				
	           					
	           			}else {
	           				 
	           			}
	              	}  
	    	/******************************** 권한 ************************************************************************/
	       
	        List  listFileDlgn0300 = dlgn0300ExcelService.selectXlsFileDlgn0300List(dlgn0300SrhVo);
	      
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        
	        
	        List<EgovMap> excelList = new ArrayList<EgovMap>();

	    	for(int i=0; i<listFileDlgn0300.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listFileDlgn0300.get(i);
	    		// TODO 주민번호
	    		nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
	    		excelList.add(eMap);
	    	}
	        
	        map.put("listFileDlgn0300", excelList);
	        
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
      
        return new ModelAndView("dlgn0300FileExcelView", map);
	}
    
//    /**
//     * 엑셀파일로 출력한다.
//     * @param searchVO 검색조건
//     * @return 엑셀파일
//     * @throws Exception
//     */
//    @RequestMapping(value="/exp/XlsFileDlgn0300Export.do")
//    public ModelAndView xlsFileDlgn0300Export(@ModelAttribute("Dlgn0300SrhVO") Dlgn0300SrhVO dlgn0300SrhVo,HttpServletRequest request ,ModelMap model) 
//                    throws Exception { 
//       
//       
////        dlgn0300SrhVo.setTypOccucdIn("");
////        dlgn0300SrhVo.setPyspGrdeCdIn("");
//        
//        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//        List<String> listDeptCd = new ArrayList<String>();
//        
//        
//        dlgn0300SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//        dlgn0300SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//        dlgn0300SrhVo.setUsrId(sessionUser.getUsrId());  
//           
//     //   List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDeptCd()));  
//     //   dlgn0300SrhVo.setDeptCdArr(listDeptCd);     //부서코드  
//    //    dlgn0300SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//        
//        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getTypOccuCd())); 
//        dlgn0300SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
//       // dlgn0300SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//       
//        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getPyspGrdeCd())); 
//        dlgn0300SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//       // dlgn0300SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//         
//        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDtilOccuInttnCd())); 
//        dlgn0300SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//       // dlgn0300SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
//         
//        
////        if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
////                && (ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
////           
////            dlgn0300SrhVo.setTypOccucdIn((sessionUser.getTypOccuCd().concat(sessionUser.getPyspGrdeCd()))); 
////            dlgn0300SrhVo.setPyspGrdeCdIn("1");
////            
////        } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
////                && (!ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
////           
////            dlgn0300SrhVo.setTypOccucdIn((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))));  
////            dlgn0300SrhVo.setPyspGrdeCdIn("1"); 
////            
////        } else { 
////            dlgn0300SrhVo.setTypOccucdIn(""); 
////            dlgn0300SrhVo.setPyspGrdeCdIn("0");
////        }
//        
//        
//        /******************************** 권한 ************************************************************************/
//        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//        if ("FALSE".equals(chkDeptCd)) {
//        	dlgn0300SrhVo.setDeptCd(sessionUser.getDeptCd()); 
//           listDeptCd.add(sessionUser.getDeptCd());
//           dlgn0300SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
//           dlgn0300SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//        } else {
//        	    
//        	    dlgn0300SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getPayrMangDeptCd()));    
//                 if (dlgn0300SrhVo.getPayrMangDeptCd().equals(dlgn0300SrhVo.getDeptCd())) { 
//                 	 listDeptCd = null; 
//                 	dlgn0300SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//                 	dlgn0300SrhVo.setDeptCd("");  //부서코드
//                 } else {
//                	 dlgn0300SrhVo.setDeptCd(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDeptCd()));
//                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDeptCd()));  
//                      dlgn0300SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
//                 } 
//              
//        }
//        
//        
//        dlgn0300SrhVo.setDeptCdAuth(dlgn0300SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
//        dlgn0300SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dlgn0300SrhVo.getDtilOccuInttnCd()).replace(",", ""));
//   
//         
//       /******************************** 권한 ************************************************************************/
//       
//         
//        List  listFileDlgn0300 = dlgn0300ExcelService.selectXlsFileDlgn0300List(dlgn0300SrhVo);
//        
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("listFileDlgn0300", listFileDlgn0300);
//        
//        return new ModelAndView("dlgn0300FileExcelView", map);
//         
//    }
//     

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
