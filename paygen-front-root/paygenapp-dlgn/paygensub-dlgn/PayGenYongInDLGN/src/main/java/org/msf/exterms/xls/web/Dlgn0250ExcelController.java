package org.msf.exterms.xls.web;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.jxls.reader.XlsToMapReader;
import org.msf.exterms.xls.service.Dlgn0250ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.app.exterms.diligence.server.vo.Dlgn0250SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0250VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

@Controller
public class Dlgn0250ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Dlgn0250ExcelController.class);  
    private static final String calledClass = Dlgn0250ExcelController.class.getName();
 
    
    @Resource(name = "dlgn0250ExcelService")
    private Dlgn0250ExcelService dlgn0250ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

     
    
    /**
     * 엑셀파일로 출력한다.(양식)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsDlgn0250Export.do")
    public ModelAndView xlsDlgn0250Export(@ModelAttribute("Dlgn0250SrhVO") Dlgn0250SrhVO dlgn0250SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
       
    	String method = calledClass + ".xlsDlgn0250Export";
//        dlgn0250SrhVo.setTypOccucdIn("");
//        dlgn0250SrhVo.setPyspGrdeCdIn("");
    	 
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();
        Map<String, Object> map = new HashMap<String, Object>();
        
		String windowNm = "근무실적관리";
		String windowId = "DLGN0250";
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        try{
        	
        	// 2. 파라미터 보낼 때(암호화)
        	dlgn0250SrhVo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0250SrhVo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호

        
	        dlgn0250SrhVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
	        dlgn0250SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        dlgn0250SrhVo.setUsrId(sessionUser.getUsrId());  		//유저아이디
	        
	        dlgn0250SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getEmymtDivCd()));	//고용구분코드
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getTypOccuCd())); 
	        dlgn0250SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	       
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDtilOccuInttnCd())); 
	        dlgn0250SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        
	        dlgn0250SrhVo.setBusinCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getBusinCd()));   //사업코드 
	        
	
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	dlgn0250SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           dlgn0250SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           dlgn0250SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	dlgn0250SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getPayrMangDeptCd()));    
	                 if (dlgn0250SrhVo.getPayrMangDeptCd().equals(dlgn0250SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	dlgn0250SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	dlgn0250SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 dlgn0250SrhVo.setDeptCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDeptCd()));  
	                      dlgn0250SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        
	        dlgn0250SrhVo.setDeptCdAuth(dlgn0250SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        dlgn0250SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	         
	       /******************************** 권한 ************************************************************************/
	        HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); ;
			
	
	        /**
	      	         * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
	      	         */
	                  if (dlgn0250SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDeptCdAuth())) 
	              			|| MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDeptCdAuth()).contains(dlgn0250SrhVo.getPayrMangDeptCd())
	              			) {
	           				//용인로직 
	                	  dlgn0250SrhVo.setRepbtyBusinDivCd("");
	              	}  
	         
	        List<Dlgn0250VO> listDlgn0250Vo = dlgn0250ExcelService.selectXlsDlgn0250List(dlgn0250SrhVo);
	        
	//        Map<String, Object> map = new HashMap<String, Object>();
	        
	        
	        List listDlgn0250 = new ArrayList<String>();
	        
	        
//	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    	for(int i=0; i<listDlgn0250Vo.size(); i++){
	    		
	    		Dlgn0250VO dlgn0250Vo = new Dlgn0250VO();
	    		
	    		dlgn0250Vo = listDlgn0250Vo.get(i);
	    		
	    		
	    		// TODO 주민번호
	    		nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		dlgn0250Vo.setResnRegnNum(AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0250Vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC));
	    		
	    		listDlgn0250.add(dlgn0250Vo);
	    		
	    	}
	    	
	        map = new HashMap<String, Object>();
	        map.put("listDlgn0250", listDlgn0250);
	        
	        
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
        
        return new ModelAndView("dlgn0250ExcelView", map);
         
    }
    
    /**
     * 엑셀파일로 출력한다.(상단버튼)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsFileDlgn0250Export.do")
    public ModelAndView xlsFileDlgn0250Export(@ModelAttribute("Dlgn0250SrhVO") Dlgn0250SrhVO dlgn0250SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
       
    	String method = calledClass + ".xlsFileDlgn0250Export";
//        dlgn0250SrhVo.setTypOccucdIn("");
//        dlgn0250SrhVo.setPyspGrdeCdIn("");
    	
		String windowNm = "근무실적관리";
		String windowId = "DLGN0250";
		
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();
        Map<String, Object> map = new HashMap<String, Object>();
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        try{
        	
	        dlgn0250SrhVo.setDpobCd(sessionUser.getDpobCd());  			//사업장코드
	        dlgn0250SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());	//단위기관담당자여부 
	        
	        dlgn0250SrhVo.setSystemkey(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getSystemkey()));	//시스템키
	        dlgn0250SrhVo.setHanNm(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getHanNm()));			//성명
//	        dlgn0250SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getResnRegnNum()));//주민번호
	        
	        
	        // 2. 파라미터 보낼 때(암호화)
	        dlgn0250SrhVo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0250SrhVo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
	        
	        dlgn0250SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getEmymtDivCd()));	//고용구분코드
	        
	        dlgn0250SrhVo.setUsrId(sessionUser.getUsrId()); 			//유저 아이디 
	        
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getTypOccuCd())); 
	        dlgn0250SrhVo.setTypOccuCdArr(lstTypeOccuCd);				//직종 
	
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDtilOccuInttnCd())); 
	        dlgn0250SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  	//직종세
	        
	        dlgn0250SrhVo.setBusinCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getBusinCd()));   //사업코드 
	
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	dlgn0250SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	        	listDeptCd.add(sessionUser.getDeptCd());
	        	dlgn0250SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	        	dlgn0250SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	dlgn0250SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getPayrMangDeptCd()));    
	        	
	        	if (dlgn0250SrhVo.getPayrMangDeptCd().equals(dlgn0250SrhVo.getDeptCd())) { 
	        		listDeptCd = null; 
	        		dlgn0250SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                dlgn0250SrhVo.setDeptCd("");  //부서코드
	        	} else {
	        		dlgn0250SrhVo.setDeptCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDeptCd()));
	        		listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDeptCd()));  
	        		dlgn0250SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	        	} 
	        }
	         
	        
	        dlgn0250SrhVo.setDeptCdAuth(dlgn0250SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        dlgn0250SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	    	/******************************** 권한 ************************************************************************/
	        
	        HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); ;
	
	        		/**
	      	         * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
	      	         */
	                  if (dlgn0250SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDeptCdAuth())) 
	              			|| MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDeptCdAuth()).contains(dlgn0250SrhVo.getPayrMangDeptCd())
	              			) {
	                     if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//용인로직 
	                    	 dlgn0250SrhVo.setRepbtyBusinDivCd("");
	                  	   
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//김해로직 
	           				//호봉제구분코드 포함해서 가져 오기 REPBTY_BUSIN_DIV_CD
	           				dlgn0250SrhVo.setRepbtyBusinDivCd("A0480010");
	           				
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//거제로직 
	           				dlgn0250SrhVo.setRepbtyBusinDivCd("");
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//안양로직 
	           				dlgn0250SrhVo.setRepbtyBusinDivCd("");
	           			
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//광명로직 
	           				dlgn0250SrhVo.setRepbtyBusinDivCd("");
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//삼척로직 
	           				dlgn0250SrhVo.setRepbtyBusinDivCd("");
	           			
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//수원로직 
	           				dlgn0250SrhVo.setRepbtyBusinDivCd("");
	           			
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//울주로직 
	           				dlgn0250SrhVo.setRepbtyBusinDivCd("");
	           			}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
	           				
	           				dlgn0250SrhVo.setRepbtyBusinDivCd("");
	           				 
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
	           				
	           				dlgn0250SrhVo.setRepbtyBusinDivCd("");
	           				 
	           				
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
	           				
	           				dlgn0250SrhVo.setRepbtyBusinDivCd("");
	           				
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//public static final String PAYGEN_MUNICIPALITIES_12 = "GWGS";    //강원도고성군청
	           				
	           				dlgn0250SrhVo.setRepbtyBusinDivCd("");
	           				
	           					
	           			}else {
	           				 
	           			}
	              	}  
	        
	        List  listFileDlgn0250 = dlgn0250ExcelService.selectXlsFileDlgn0250List(dlgn0250SrhVo);
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        
	        
	        List<EgovMap> excelList = new ArrayList<EgovMap>();
	        
	    	for(int i=0; i<listFileDlgn0250.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listFileDlgn0250.get(i);
	    		
	    		// 복호화
	    		String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
	    		excelList.add(eMap);
	    	}
	        
	        map.put("listFileDlgn0250", excelList);
	        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
        }
        
        return new ModelAndView("dlgn0250FileExcelView", map);
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
//    	String method = calledClass + ".xlsDlgn0250Import";
//    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//    	
//		String windowNm = "근무실적관리";
//		String windowId = "DLGN0250";
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
//                        sResult =  "success";
//                    } catch(Exception e) {
//                          e.printStackTrace();
//                          
//              	    	/** 에러 로그 **/			
//              	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C",e, windowNm , windowId);
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
//                        sResult =  "success";
//                        
//                    } catch(Exception e) {
//                    	e.printStackTrace();
//                          
//                    	/** 에러 로그 **/			
//                    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C",e, windowNm , windowId);
//                    	sResult = "error";
//                       
//                    } finally {
//                        if (fis != null)    // 2011.11.1 보안점검 후속조치
//                            fis.close();
//                    }
//                    
//                }else{
//                    logger.info("xls, xlsx 파일 타입만 등록이 가능합니다."); 
//                    sResult =  "success";
//                }
//                // *********** 끝 ***********
//            }
//        }
//        
//		/** 로그반영
//		 * CRUDSBLO
//		 * C:create		R:read		U:update
//    	 * D:delete		S:select	B:배치 
//    	 * L:로그인		O:로그아웃
//    	 */
//		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:D:B");
//		
//        return sResult;
// 
//    }   
    
    
    
     

    /**
     * 엑셀파일을 업로드하여  등록한다.
     * @param  MultipartFile, Model, HttpServletRequest
     * @return sResult
     * @throws InvalidFormatException, IOException, SAXException
     */
    @RequestMapping(value = "/imp/XlsDlgn0250Import.do", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("dlgn0250flUp") MultipartFile file,
    					Model model, final HttpServletRequest request) throws InvalidFormatException, IOException, SAXException {
    		    	
    	String realPath = request.getSession().getServletContext().getRealPath(""); 
    	String xmlConfig = "/upXmlConfig/DLGN/Dlgn0250Mapping.xml";
    		    	
    	String sResult = "";			//결과 상태값
    	InputStream inputXML = null;	//XML
    	InputStream inputXLS = null;	//엑셀파일
    				
    	List<Dlgn0250VO> dlgn0250List = new ArrayList<Dlgn0250VO>();
    	Map<String, List> beans = new HashMap<String, List>();
    				
    	beans.put("dlgn0250List", dlgn0250List);
    				
    	try {
    					
    		inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
    		XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
    		inputXLS = new BufferedInputStream(file.getInputStream());
    					
    		XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
    					
    		if(xlsReadStatus.isStatusOK()) {
    			//엑셀 서비스 호출
    			try {
    				//delete 후 insert 한다.
					dlgn0250ExcelService.updateXlsDlgn0250(dlgn0250List, request);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    			sResult =  "success";
    		}else {
    			sResult =  "error";
    		}
    	}finally {
    		IOUtils.closeQuietly(inputXML);
    		IOUtils.closeQuietly(inputXLS);
    	}

    	return sResult;
	}
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
    
    /**
     * 엑셀파일을 업로드하여  등록한다.
     * @param loginVO
     * @param request
     * @param commandMap
     * @param model
     * @return  
     * @throws Exception
     */
    @RequestMapping(value = "/imp/XlsReadDlgn0250Import.do")
    public @ResponseBody String xlsReadDlgn0250Import(@ModelAttribute("Dlgn0250VO") Dlgn0250VO dlgn0250Vo,final HttpServletRequest request
            , Map commandMap , Model model) throws Exception {
    	
    	String method = calledClass + ".xlsReadDlgn0250Import";
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
         
//        String sCmd = commandMap.get("dlgn0250flUp") == null ? "" : (String)commandMap.get("dlgn0250flUp");
//        if (sCmd.equals("")) {
//          return;
//        }
    	
    	
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	
    	
    	HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());

        if  (dlgn0250ExcelService == null) { 
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            dlgn0250ExcelService = (Dlgn0250ExcelService) wac.getBean("Dlgn0250ExcelService" ); 
           
       }
        
        String sResult = "";
        String xmlConfig = "/xmlConfig/departments.xml";
        
        String realPath = request.getSession().getServletContext().getRealPath(""); 
        String xmlConfigRelatviePath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat(xmlConfig));
        
        
        final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        final Map<String, MultipartFile> files = multiRequest.getFileMap();
        
        
        InputStream fis = null; // 2011.11.1 보안점검 후속조치 
        XlsToMapReader xlsMapReader  = XlsToMapReader.getInstance();
        
        Map<String, Object> mapRtnData = new HashMap<String, Object>();
        List<Dlgn0250VO>   dlgnRtn0250List = new ArrayList<Dlgn0250VO>();
        Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
        
		String windowNm = "근무실적관리";
		String windowId = "DLGN0250";
        MultipartFile file;

        while (itr.hasNext()) {
            Entry<String, MultipartFile> entry = itr.next();

            file = entry.getValue();
            if (!"".equals(file.getOriginalFilename())) {
                // 2011.10.07 업로드 파일에 대한 확장자를 체크
            	Map<String, Object> mapListData = new HashMap<String, Object>();
                Dlgn0250VO dlgnRtn0250Vo = new Dlgn0250VO();
                
                
                List<Dlgn0250VO> dlgnIn0250List = new ArrayList<Dlgn0250VO>();
                
                
                List listDlgn0250 = new ArrayList<String>();
                
                
                if (file.getOriginalFilename().endsWith(".xls")
                        || file.getOriginalFilename().endsWith(".XLS") ) {
                    
                	
                    //2011.10.21 보안점검 후속조치
                    try {
                        fis = file.getInputStream(); 
                      
                        
                        
                        mapRtnData = xlsMapReader.readXlsExcel(request, xmlConfigRelatviePath,fis ,mapListData);
                        
                        Boolean isStatusOK = (Boolean)mapRtnData.get("isStatusOK");
                        if(isStatusOK){
                        	
                        	
                        	dlgnRtn0250List =  (List<Dlgn0250VO>)mapRtnData.get("dlgn0250List");
                        	
                        	
                        	// 주민등록번호
                	    	for(int i=0; i<dlgnRtn0250List.size(); i++){
                	    		
                	    		dlgn0250Vo = new Dlgn0250VO();
                	    		
                	    		dlgn0250Vo = dlgnRtn0250List.get(i);
                	    		
                	    		
                	    		nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
                	    		dlgn0250Vo.setResnRegnNum(AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0250Vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC));
                	    		
                	    		listDlgn0250.add(dlgn0250Vo);
                	    		
                	    	}
                	    	
                	    	
                	        mapListData.put("dlgn0250List", listDlgn0250);
                        	
							 
//                         	Collection<List<Dlgn0250VO>> cc = beans.values();
//                        	
//                        	for (MtgBankVo userList : beans.get("bankVoList")) {
//                        		mdmUserList.add(userList);
//            				}
                        	//결과값을 받아서 인서트 업데이트 처리한다. 
                            sResult =  "success";
                        } else {
                            sResult = "error";
                        }
                      
                        
                    } catch(Exception e) {
                        e.printStackTrace();
                        sResult = "error";
                        
            	    	/** 에러 로그 **/			
            	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"R",e, windowNm , windowId);
                       
                    } finally {
                        if (fis != null)    // 2011.11.1 보안점검 후속조치
                            fis.close();
                    }
                  
                    
                    
                } else  if (  file.getOriginalFilename().endsWith(".xlsx")
                        || file.getOriginalFilename().endsWith(".XLSX")) {
                    
                    //2011.10.21 보안점검 후속조치
                    try {
                        fis = file.getInputStream();
                        
                        mapRtnData = xlsMapReader.readXlsExcel(request, xmlConfigRelatviePath,fis ,mapListData);
                       
                        Boolean isStatusOK = (Boolean)mapRtnData.get("isStatusOK");
                        if(isStatusOK){
//                        	Collection<List<MtgBankVo>> cc = beans.values();
//                        	
//                        	for (MtgBankVo userList : beans.get("bankVoList")) {
//                        		mdmUserList.add(userList);
//            				}
                        	//결과값을 받아서 인서트 업데이트 처리한다. 
                            sResult =  "success";
                        } else {
                            sResult = "error";
                        }
                        
                    } catch(Exception e) {
                    	e.printStackTrace();
                        sResult = "error";
                        
            	    	/** 에러 로그 **/			
            	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"R",e, windowNm , windowId);

                       
                    } finally {
                        if (fis != null)    // 2011.11.1 보안점검 후속조치
                            fis.close();
                    } 
                       
                    
                }else{
                    logger.info("xls, xlsx 파일 타입만 등록이 가능합니다."); 
                    sResult =  "success";
                }
                // *********** 끝 ***********
               
            }
        }
        
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:D:B");
       
        return sResult;
 
    }
     

    
    
}
