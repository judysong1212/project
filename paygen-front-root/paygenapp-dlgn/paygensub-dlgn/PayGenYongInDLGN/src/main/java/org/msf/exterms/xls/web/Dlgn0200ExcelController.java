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
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.jxls.reader.XlsToMapReader;
import org.msf.exterms.xls.service.Dlgn0200ExcelService;
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

import com.app.exterms.diligence.server.vo.Dlgn0200SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0200VO;
import com.app.exterms.diligence.server.vo.Dlgn0210ExlVO;
import com.app.exterms.diligence.server.vo.Dlgn0250SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0250VO;
import com.app.exterms.prgm.server.utils.PrgmComUtils;
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
public class Dlgn0200ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Dlgn0200ExcelController.class);  
    private static final String calledClass = Dlgn0200ExcelController.class.getName();
 
    @Resource(name = "dlgn0250ExcelService")
    private Dlgn0250ExcelService dlgn0250ExcelService;
    
//    @Resource(name = "dlgn0200ExcelService")
//    private Dlgn0200ExcelService dlgn0200ExcelService;
    
    @Resource(name = "dlgn0200ExcelService")
    private Dlgn0200ExcelService dlgn0200ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

     
    
    /**
     * 엑셀파일로 출력한다.(양식)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsDlgn0200Export.do")
	public ModelAndView xlsDlgn0200Export(
			@ModelAttribute("Dlgn0250SrhVO") Dlgn0250SrhVO dlgn0250SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
       
    	String method = calledClass + ".xlsDlgn0200Export";
//        dlgn0200SrhVo.setTypOccucdIn("");
//        dlgn0200SrhVo.setPyspGrdeCdIn("");
    	
    	 
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();
        Map<String, Object> map = new HashMap<String, Object>();
        
		String windowNm = "시간외근무관리";
		String windowId = "DLGN0200";
		
        
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
	         
	        List<Dlgn0250VO> listDlgn0200Vo = dlgn0200ExcelService.selectXlsDlgn0200List(dlgn0250SrhVo);
//	        List<Dlgn0250VO> listDlgn0250Vo = dlgn0250ExcelService.selectXlsDlgn0250List(dlgn0250SrhVo);
	        
	//        Map<String, Object> map = new HashMap<String, Object>();
	        
	        
	        List listDlgn0200 = new ArrayList<String>();
	        
	        
//	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    	for(int i=0; i<listDlgn0200Vo.size(); i++){
	    		
	    		Dlgn0250VO dlgn0250Vo = new Dlgn0250VO();
	    		
	    		dlgn0250Vo = listDlgn0200Vo.get(i);
	    		
	    		
	    		// TODO 주민번호
	    		nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		dlgn0250Vo.setResnRegnNum(AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0250Vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC));
	    		
	    		listDlgn0200.add(dlgn0250Vo);
	    		
	    	}
	    	
	        map = new HashMap<String, Object>();
	        map.put("listDlgn0200", listDlgn0200);
	        
	        
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
        return new ModelAndView("dlgn0200ExcelView", map);

    }
    
    /**
     * 엑셀파일로 출력한다.(상단버튼)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsFileDlgn0200Export.do")
    public ModelAndView xlsFileDlgn0200Export(@ModelAttribute("Dlgn0200SrhVO") Dlgn0200SrhVO dlgn0200SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
       
    	String method = calledClass + ".xlsFileDlgn0200Export";
//        dlgn0200SrhVo.setTypOccucdIn("");
//        dlgn0200SrhVo.setPyspGrdeCdIn("");
    	
		String windowNm = "시간외근무관리";
		String windowId = "DLGN0200";
		
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();
        Map<String, Object> map = new HashMap<String, Object>();
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        try{
        	
	        dlgn0200SrhVo.setDpobCd(sessionUser.getDpobCd());  			//사업장코드
	        dlgn0200SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());	//단위기관담당자여부 
	        
	        dlgn0200SrhVo.setSystemkey(MSFSharedUtils.allowNulls(dlgn0200SrhVo.getSystemkey()));	//시스템키
	        dlgn0200SrhVo.setHanNm(MSFSharedUtils.allowNulls(dlgn0200SrhVo.getHanNm()));			//성명
//	        dlgn0200SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(dlgn0200SrhVo.getResnRegnNum()));//주민번호
	        
	        
	        // 2. 파라미터 보낼 때(암호화)
	        dlgn0200SrhVo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0200SrhVo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
	        
	        dlgn0200SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(dlgn0200SrhVo.getEmymtDivCd()));	//고용구분코드
	        
	        dlgn0200SrhVo.setUsrId(sessionUser.getUsrId()); 			//유저 아이디 
	        
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0200SrhVo.getTypOccuCd())); 
	        dlgn0200SrhVo.setTypOccuCdArr(lstTypeOccuCd);				//직종 
	
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0200SrhVo.getDtilOccuInttnCd())); 
	        dlgn0200SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  	//직종세
	        
	        dlgn0200SrhVo.setBusinCd(MSFSharedUtils.allowNulls(dlgn0200SrhVo.getBusinCd()));   //사업코드 
	
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	dlgn0200SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	        	listDeptCd.add(sessionUser.getDeptCd());
	        	dlgn0200SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	        	dlgn0200SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	dlgn0200SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dlgn0200SrhVo.getPayrMangDeptCd()));    
	        	
	        	if (dlgn0200SrhVo.getPayrMangDeptCd().equals(dlgn0200SrhVo.getDeptCd())) { 
	        		listDeptCd = null; 
	        		dlgn0200SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                dlgn0200SrhVo.setDeptCd("");  //부서코드
	        	} else {
	        		dlgn0200SrhVo.setDeptCd(MSFSharedUtils.allowNulls(dlgn0200SrhVo.getDeptCd()));
	        		listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0200SrhVo.getDeptCd()));  
	        		dlgn0200SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	        	} 
	        }
	         
	        
	        dlgn0200SrhVo.setDeptCdAuth(dlgn0200SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        dlgn0200SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dlgn0200SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	    	/******************************** 권한 ************************************************************************/
	        
	        HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); ;
	
	        		/**
	      	         * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
	      	         */
	                  if (dlgn0200SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0200SrhVo.getDeptCdAuth())) 
	              			|| MSFSharedUtils.allowNulls(dlgn0200SrhVo.getDeptCdAuth()).contains(dlgn0200SrhVo.getPayrMangDeptCd())
	              			) {
	                     if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//용인로직 
	                    	 dlgn0200SrhVo.setRepbtyBusinDivCd("");
	                  	   
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_02.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//김해로직 
	           				//호봉제구분코드 포함해서 가져 오기 REPBTY_BUSIN_DIV_CD
	           				dlgn0200SrhVo.setRepbtyBusinDivCd("A0480010");
	           				
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_03.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//거제로직 
	           				dlgn0200SrhVo.setRepbtyBusinDivCd("");
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_04.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//안양로직 
	           				dlgn0200SrhVo.setRepbtyBusinDivCd("");
	           			
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_05.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//광명로직 
	           				dlgn0200SrhVo.setRepbtyBusinDivCd("");
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_06.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//삼척로직 
	           				dlgn0200SrhVo.setRepbtyBusinDivCd("");
	           			
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_07.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//수원로직 
	           				dlgn0200SrhVo.setRepbtyBusinDivCd("");
	           			
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_08.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//울주로직 
	           				dlgn0200SrhVo.setRepbtyBusinDivCd("");
	           			}  else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_09.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//public static final String PAYGEN_MUNICIPALITIES_09 = "USC";    //의성군청  
	           				
	           				dlgn0200SrhVo.setRepbtyBusinDivCd("");
	           				 
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_10.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//public static final String PAYGEN_MUNICIPALITIES_10 = "ULSANNAMGU";    //울산남구청
	           				
	           				dlgn0200SrhVo.setRepbtyBusinDivCd("");
	           				 
	           				
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_11.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//public static final String PAYGEN_MUNICIPALITIES_11 = "GIMCHEON";    //김천시청
	           				
	           				dlgn0200SrhVo.setRepbtyBusinDivCd("");
	           				
	           			} else if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_12.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
	           				//public static final String PAYGEN_MUNICIPALITIES_12 = "GWGS";    //강원도고성군청
	           				
	           				dlgn0200SrhVo.setRepbtyBusinDivCd("");
	           				
	           					
	           			}else {
	           				 
	           			}
	              	}  
	        
	        List  listFileDlgn0200 = dlgn0200ExcelService.selectXlsFileDlgn0200List(dlgn0200SrhVo);
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        
	        
	        List<EgovMap> excelList = new ArrayList<EgovMap>();
	        
	    	for(int i=0; i<listFileDlgn0200.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listFileDlgn0200.get(i);
	    		
	    		// 복호화
	    		String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
	    		excelList.add(eMap);
	    	}
	        
	        map.put("listFileDlgn0200", excelList);
	        
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
        
        return new ModelAndView("dlgn0200FileExcelView", map);
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
//    @RequestMapping(value = "/imp/XlsDlgn0200Import.do")
//    public String xlsDlgn0200Import(@ModelAttribute("Dlgn0200VO") Dlgn0200VO dlgn0200Vo,final HttpServletRequest request
//            , Map commandMap , Model model) throws Exception {
//    	
//    	String method = calledClass + ".xlsDlgn0200Import";
//    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//    	
//		String windowNm = "기본근무관리";
//		String windowId = "DLGN0200";
//         
////        String sCmd = commandMap.get("dlgn0200flUp") == null ? "" : (String)commandMap.get("dlgn0200flUp");
////        if (sCmd.equals("")) {
////          return;
////        }
//
//        if  (dlgn0200ExcelService == null) { 
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( request.getSession().getServletContext());
//
//            dlgn0200ExcelService = (Dlgn0200ExcelService) wac.getBean("Dlgn0200ExcelService" ); 
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
//                        dlgn0200ExcelService.insertXlsDlgn0200(fis);
//                        dlgn0200ExcelService.insertXlsDlgn0200(fis2);
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
//                        dlgn0200ExcelService.insertXSSFDlgn0200(fis);
//                        dlgn0200ExcelService.insertXSSFDlgn0200(fis2);
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
    @RequestMapping(value = "/imp/XlsDlgn0200Import.do", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("dlgn0200flUp") MultipartFile file,
    					Model model, final HttpServletRequest request, final HttpServletResponse response) throws InvalidFormatException, IOException, SAXException {
    		    	
    	String realPath = request.getSession().getServletContext().getRealPath(""); 
    	String xmlConfig = "/upXmlConfig/DLGN/YongIn/Dlgn0200Mapping.xml";
    
    	Long lResult = new Long(0);		//리턴 결과
    	String sResult = "";			//결과 상태값
    	InputStream inputXML = null;	//XML
    	InputStream inputXLS = null;	//엑셀파일
    				
    	List<Dlgn0210ExlVO> dlgn0210List = new ArrayList<Dlgn0210ExlVO>();
    	Map<String, List> beans = new HashMap<String, List>();
    				
    	beans.put("dlgn0210List", dlgn0210List);
    	try {
    					
    		inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
    		XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
    		inputXLS = new BufferedInputStream(file.getInputStream());
    					
    		XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
    		if(xlsReadStatus.isStatusOK()) {
    			int chkFormCnt = 0 ;
    			String chkTime1 = ""; 
				String chkTime2 = "";
				String chkTime3 = "";
				String chkTime4 = "";
				String chkTime5 = "";
				String chkTime6 = "";
				
				for(int i = 0 ; i<  dlgn0210List.size()  ; i++){
					
					chkTime5 = MSFSharedUtils.defaultNulls(dlgn0210List.get(i).getDilnlazDutyStTm(),"");  //출근시간
					chkTime6 = MSFSharedUtils.defaultNulls(dlgn0210List.get(i).getDilnlazDutyEdTm(),"");  //퇴근시간
					chkTime1 = MSFSharedUtils.defaultNulls(dlgn0210List.get(i).getDilnlazDutyTm(),"");  //연장(평일)
					chkTime2 = MSFSharedUtils.defaultNulls(dlgn0210List.get(i).getDilnlazNtotTm(),"");  //야근(평일)
					chkTime3 = MSFSharedUtils.defaultNulls(dlgn0210List.get(i).getDilnlazHodyDutyTm(),""); //근무(휴일)
					chkTime4 = MSFSharedUtils.defaultNulls(dlgn0210List.get(i).getDilnlazHodyNtotTm(),""); //연장(휴일)
					
					if(!"".equals(chkTime5) ){
						if(chkTime5.length() ==1 &&(  Integer.parseInt(chkTime5)>0&& Integer.parseInt(chkTime5)<10 )){
							dlgn0210List.get(i).setDilnlazDutyStTm("0"+chkTime5+":00");
						}else if(chkTime5.length() ==2 &&(  Integer.parseInt(chkTime5)>0&& Integer.parseInt(chkTime5)<25 )){
							dlgn0210List.get(i).setDilnlazDutyStTm(chkTime5+":00");
						}else{
							
							if(Integer.parseInt(chkTime5.replace(":", ""))<0 || Integer.parseInt(chkTime5.replace(":", ""))>2400){
								chkFormCnt++;
							}
						}
					}
					
					if(!"".equals(chkTime6) ){
						if(chkTime6.length() ==1 &&(  Integer.parseInt(chkTime6)>0&& Integer.parseInt(chkTime6)<10 )){
							dlgn0210List.get(i).setDilnlazDutyEdTm("0"+chkTime6+":00");
						}else if(chkTime6.length() ==2 &&(  Integer.parseInt(chkTime6)>0&& Integer.parseInt(chkTime6)<25 )){
							dlgn0210List.get(i).setDilnlazDutyEdTm(chkTime6+":00");
						}else{
							if(Integer.parseInt(chkTime6.replace(":", ""))<0 || Integer.parseInt(chkTime6.replace(":", ""))>2400){
								chkFormCnt++;
							}
						}
					}
					
					
					if(!"".equals(chkTime1) ){
						if(chkTime1.length() ==1 &&(  Integer.parseInt(chkTime1)>0&& Integer.parseInt(chkTime1)<10 )){
							dlgn0210List.get(i).setDilnlazDutyTm("0"+chkTime1+":00");
						}else if(chkTime1.length() ==2 &&(  Integer.parseInt(chkTime1)>0&& Integer.parseInt(chkTime1)<10 )){
							dlgn0210List.get(i).setDilnlazDutyTm(chkTime1+":00");
						}else{
							if(Integer.parseInt(chkTime1.replace(":", ""))<0 || Integer.parseInt(chkTime1.replace(":", ""))>2400){
								chkFormCnt++;
							}
						}
					}
					
					if(!"".equals(chkTime2) ){
						if(chkTime2.length() ==1 &&(  Integer.parseInt(chkTime2)>0&& Integer.parseInt(chkTime2)<10 )){
							dlgn0210List.get(i).setDilnlazNtotTm("0"+chkTime2+":00");
						}else if(chkTime2.length() ==2 &&(  Integer.parseInt(chkTime2)>0&& Integer.parseInt(chkTime2)<10 )){
							dlgn0210List.get(i).setDilnlazNtotTm(chkTime2+":00");
						}else{
							if(Integer.parseInt(chkTime2.replace(":", ""))<0 || Integer.parseInt(chkTime2.replace(":", ""))>2400){
								chkFormCnt++;
							}
						}
					}
					
					if(!"".equals(chkTime3) ){
						if(chkTime3.length() ==1 &&(  Integer.parseInt(chkTime3)>0&& Integer.parseInt(chkTime3)<10 )){
							dlgn0210List.get(i).setDilnlazHodyDutyTm("0"+chkTime3+":00");
						}else if(chkTime3.length() ==2 &&(  Integer.parseInt(chkTime3)>0&& Integer.parseInt(chkTime3)<10 )){
							dlgn0210List.get(i).setDilnlazHodyDutyTm(chkTime3+":00");
						}else{
							if(Integer.parseInt(chkTime3.replace(":", ""))<0 || Integer.parseInt(chkTime3.replace(":", ""))>2400){
								chkFormCnt++;
							}
						}
					}
					
					if(!"".equals(chkTime4) ){
						if(chkTime4.length() ==1 &&(  Integer.parseInt(chkTime4)>0&& Integer.parseInt(chkTime4)<10 )){
							dlgn0210List.get(i).setDilnlazHodyNtotTm("0"+chkTime4+":00");
						}else if(chkTime4.length() ==2 &&(  Integer.parseInt(chkTime4)>0&& Integer.parseInt(chkTime4)<10 )){
							dlgn0210List.get(i).setDilnlazHodyNtotTm(chkTime4+":00");
						}else{
							if(Integer.parseInt(chkTime4.replace(":", ""))<0 || Integer.parseInt(chkTime4.replace(":", ""))>2400){
								chkFormCnt++;
							}
						}
					}
					//System.out.println("chkTime5:"+chkTime5+",chkTime6:"+chkTime6+",chkTime1:"+chkTime1+",chkTime2:"+chkTime2+",chkTime3:"+chkTime3+",chkTime4:"+chkTime4+",chkForm:"+chkFormCnt);
				} // for end
				
				
				
				if(chkFormCnt > 0){
					PrgmComUtils.responseAlert(response, "엑셀시간이 폼양식에 맞지않습니다. 확인후 다시 업로드해주세요." );
				}else{
    			//엑셀 서비스 호출
					lResult = dlgn0200ExcelService.updateXlsDlgn0200(dlgn0210List, request);
				}
    			if(lResult == 1) {
					sResult =  "success";
				} else {
					sResult =  "error";
				}
    			
    		}else {
    			PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
    			sResult =  "error";
    		}
    	} catch (Exception e) {
    		PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
			// TODO Auto-generated catch block
			e.printStackTrace();
    	}finally {
    		IOUtils.closeQuietly(inputXML);
    		IOUtils.closeQuietly(inputXLS);
    	}

    	return sResult;
	}
//    public String xlsDlgn0200Import(@ModelAttribute("Dlgn0200VO") Dlgn0200VO dlgn0200Vo,final HttpServletRequest request
//            , Map commandMap , Model model) throws Exception {
//         
////        String sCmd = commandMap.get("dlgn0200flUp") == null ? "" : (String)commandMap.get("dlgn0200flUp");
////        if (sCmd.equals("")) {
////          return;
////        }
//
//        if  (dlgn0200ExcelService == null) { 
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( request.getSession().getServletContext());
//
//            dlgn0200ExcelService = (Dlgn0200ExcelService) wac.getBean("Dlgn0200ExcelService" ); 
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
//                        dlgn0200ExcelService.insertXlsDlgn0200(fis);
//                        dlgn0200ExcelService.insertXlsDlgn0200(fis2);
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
//                        dlgn0200ExcelService.insertXSSFDlgn0200(fis);
//                        dlgn0200ExcelService.insertXSSFDlgn0200(fis2);
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
    @RequestMapping(value = "/imp/XlsReadDlgn0200Import.do")
    public @ResponseBody String xlsReadDlgn0200Import(@ModelAttribute("Dlgn0200VO") Dlgn0200VO dlgn0200Vo,final HttpServletRequest request
            , Map commandMap , Model model) throws Exception {
    	
    	String method = calledClass + ".xlsReadDlgn0200Import";
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
         
//        String sCmd = commandMap.get("dlgn0200flUp") == null ? "" : (String)commandMap.get("dlgn0200flUp");
//        if (sCmd.equals("")) {
//          return;
//        }
    	
    	
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	
    	
    	HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());

        if  (dlgn0200ExcelService == null) { 
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            dlgn0200ExcelService = (Dlgn0200ExcelService) wac.getBean("Dlgn0200ExcelService" ); 
           
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
        List<Dlgn0200VO>   dlgnRtn0200List = new ArrayList<Dlgn0200VO>();
        Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
        
		String windowNm = "기본근무관리";
		String windowId = "DLGN0200";
        MultipartFile file;

        while (itr.hasNext()) {
            Entry<String, MultipartFile> entry = itr.next();

            file = entry.getValue();
            if (!"".equals(file.getOriginalFilename())) {
                // 2011.10.07 업로드 파일에 대한 확장자를 체크
            	Map<String, Object> mapListData = new HashMap<String, Object>();
                Dlgn0200VO dlgnRtn0200Vo = new Dlgn0200VO();
                
                
                List<Dlgn0200VO> dlgnIn0200List = new ArrayList<Dlgn0200VO>();
                
                
                List listDlgn0200 = new ArrayList<String>();
                
                
                if (file.getOriginalFilename().endsWith(".xls")
                        || file.getOriginalFilename().endsWith(".XLS") ) {
                    
                	
                    //2011.10.21 보안점검 후속조치
                    try {
                        fis = file.getInputStream(); 
                      
                        
                        
                        mapRtnData = xlsMapReader.readXlsExcel(request, xmlConfigRelatviePath,fis ,mapListData);
                        
                        Boolean isStatusOK = (Boolean)mapRtnData.get("isStatusOK");
                        if(isStatusOK){
                        	
                        	
                        	dlgnRtn0200List =  (List<Dlgn0200VO>)mapRtnData.get("dlgn0200List");
                        	
                        	
                        	// 주민등록번호
                	    	for(int i=0; i<dlgnRtn0200List.size(); i++){
                	    		
                	    		dlgn0200Vo = new Dlgn0200VO();
                	    		
                	    		dlgn0200Vo = dlgnRtn0200List.get(i);
                	    		
                	    		
                	    		nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
                	    		dlgn0200Vo.setResnRegnNum(AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0200Vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC));
                	    		
                	    		listDlgn0200.add(dlgn0200Vo);
                	    		
                	    	}
                	    	
                	    	
                	        mapListData.put("dlgn0200List", listDlgn0200);
                        	
							 
//                         	Collection<List<Dlgn0200VO>> cc = beans.values();
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
