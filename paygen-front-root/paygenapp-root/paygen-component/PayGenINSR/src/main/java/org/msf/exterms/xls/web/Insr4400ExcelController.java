package org.msf.exterms.xls.web;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Insr4400ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.app.exterms.insurance.server.service.dao.Insr3150DAO;
import com.app.exterms.insurance.server.vo.Insr3150SrhVO;
import com.app.exterms.insurance.server.vo.Insr3150VO;
import com.app.exterms.prgm.server.utils.PrgmComUtils;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

@Controller
public class Insr4400ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Insr4400ExcelController.class);  
    private static final String calledClass = Insr4400ExcelController.class.getName();
    
    @Autowired
    @Resource(name = "Insr3150DAO")
    private Insr3150DAO insr3150DAO;
    
    @Resource(name = "Insr4400ExcelService")
    private Insr4400ExcelService insr4400ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsFileInsr4400Export.do")   
    public ModelAndView xlsInsr4400Export(@ModelAttribute("Insr3150SrhVO") Insr3150SrhVO Insr3150SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception {  
       
    	String method = calledClass + ".xlsInsr4400Export";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
        
        Map<String, Object> map = new HashMap<String, Object>();
        
    	String windowNm = "건강보험연말정산";
		String windowId = "INSR4400";
        
		try{
        	
	        Insr3150SrhVo.setUsrId(sessionUser.getUsrId());  
	        Insr3150SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        Insr3150SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        Insr3150SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getMangeDeptCd()));  
	        Insr3150SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getRepbtyBusinDivCd())); 
	         
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getTypOccuCd())); 
	        Insr3150SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	       // Insr3150SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	       
	       // List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getPyspGrdeCd())); 
	       // Insr3150SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
	       // Insr3150SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDtilOccuInttnCd())); 
	        Insr3150SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	       // Insr3150SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	         
	        List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getHdofcCodtnCd())); 
	        Insr3150SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);  
	       // Insr3150SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	         
	        
	//        if (ExtermsProps.AUTH_USR_DIV_10.equals(sessionUser.getUsrDivCd()) && ExtermsProps.AUTH_USR_DIV_40.equals(sessionUser.getUsrDivCd())){
	//		    
	//			
	//		   } else if (ExtermsProps.AUTH_USR_DIV_20.equals(sessionUser.getUsrDivCd())){
	//			   
	//			   
	//		   } else if (ExtermsProps.AUTH_USR_DIV_25.equals(sessionUser.getUsrDivCd())){
	//			   
	//			   
	//		   } else {
	//			   
	//			//   List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()));  
	//		     //   Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드  
	//		    //    Insr3150SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	//			   
	//			   if ("Y".equals(sessionUser.getPayrMangDeptYn())) {
	//				    
	//					if (" ".equals(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()))) {
	//						Insr3150SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
	//	 		            Insr3150SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd())) ;   //단위기관코드
	//	 		            List<String> listDeptCd = null;  
	//	 		            Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드
	//	 		            Insr3150SrhVo.setDeptCd("");  
	//	 		             
	//				     } else if ("405030200".equals(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()))) {
	//				    	 
	//				    	Insr3150SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
	//	 		            Insr3150SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd())) ;   //단위기관코드
	//	 		            List<String> listDeptCd = null;  
	//	 		            Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드
	//	 		            Insr3150SrhVo.setDeptCd("");  
	//	 		            
	//				     } else {
	//				    	 
	//				     } 
	//			   } else {
	//				    
	//					if (" ".equals(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()))) {
	//						Insr3150SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
	//	 		            Insr3150SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd())) ;   //단위기관코드
	//	 		            List<String> listDeptCd = null;  
	//	 		            Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드
	//	 		            Insr3150SrhVo.setDeptCd("");  
	//				     } else if ("405030200".equals(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()))) {
	//				    	Insr3150SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
	//	 		            Insr3150SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd())) ;   //단위기관코드
	//	 		            List<String> listDeptCd = null;  
	//	 		            Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드
	//	 		            Insr3150SrhVo.setDeptCd("");  
	//				     } else {
	//				    	 
	//				     } 
	//			   }
	//				
	//		   }
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	Insr3150SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           Insr3150SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	Insr3150SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getPayrMangDeptCd()));    
	                 if (Insr3150SrhVo.getPayrMangDeptCd().equals(Insr3150SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	Insr3150SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 Insr3150SrhVo.setDeptCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()));  
	                      Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	         
	        
	        Insr3150SrhVo.setDeptCdAuth(Insr3150SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        Insr3150SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	        
	       /******************************** 권한 ************************************************************************/
	        
	//        if (Insr3150SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()))) {
	//        	Insr3150SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
	//        	List<String> listDeptCd = null; 
	//        	Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	//        	Insr3150SrhVo.setDeptCd("");     //부서코드
	//        } else {
	//
	//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()));  
	//            Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드  
	//            Insr3150SrhVo.setDeptCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()));     //부서코드 
	//        }
	        
	         
	        List listInsr4400 = insr4400ExcelService.selectXlsInsr4400List(Insr3150SrhVo);
	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listInsr4400.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listInsr4400.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}

//	        Map<String, Object> map = new HashMap<String, Object>(); 
	        map = new HashMap<String, Object>(); 
	        map.put("listInsr4400", excelList);
	        
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
		
        return new ModelAndView("insr4400ExcelView", map);
         
    }
    
    
    /**
     * 엑셀을 전자파일 형태 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
	@RequestMapping(value="/exp/TxtFileInsr4400Export.do")   
	public ModelAndView TxtFileInsr4400Export(	@ModelAttribute("Insr3150SrhVO") Insr3150SrhVO Insr3150SrhVo
											  ,	HttpServletRequest request
											  ,	ModelMap model
											 ) throws Exception {
		
		String method = calledClass + ".TxtFileInsr4400Export"; 
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		List<String> listDeptCd = new ArrayList<String>();
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		String windowNm = "건강보험연말정산";
		String windowId = "INSR4400";
		
		try{
        	
	        Insr3150SrhVo.setUsrId(sessionUser.getUsrId());  
	        Insr3150SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        Insr3150SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        Insr3150SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getMangeDeptCd()));  
	        Insr3150SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getRepbtyBusinDivCd())); 
	         
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getTypOccuCd())); 
	        Insr3150SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDtilOccuInttnCd())); 
	        Insr3150SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	         
	        List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getHdofcCodtnCd())); 
	        Insr3150SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);  
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	Insr3150SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           Insr3150SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	Insr3150SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getPayrMangDeptCd()));    
	                 if (Insr3150SrhVo.getPayrMangDeptCd().equals(Insr3150SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	Insr3150SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 Insr3150SrhVo.setDeptCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()));  
	                      Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	        }
	         
	        Insr3150SrhVo.setDeptCdAuth(Insr3150SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        Insr3150SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	        
	       /******************************** 권한 ************************************************************************/
	        
	        Insr3150VO insr3150Vo = new Insr3150VO();
	        List listTxtInsr4400 = insr4400ExcelService.selectTxtInsr4400ToInsr3150List(Insr3150SrhVo);
	        
	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listTxtInsr4400.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listTxtInsr4400.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}
	        
	        Long result = 0L;
	        
//	        Map<String, Object> map = new HashMap<String, Object>(); 
	        map = new HashMap<String, Object>(); 
	        map.put("listTxtInsr4400", excelList);
	        
	        
	        for(int i = 0; i < listTxtInsr4400.size(); i++) {
	        	result = 0L;
	        	EgovMap eMap = (EgovMap)listTxtInsr4400.get(i);
	        	insr3150Vo.setDpobCd((String)eMap.get("dpobCd"));															/** column 사업장코드		: dpobCd			*/
	        	insr3150Vo.setSystemkey(MSFSharedUtils.allowNulls(eMap.get("systemkey")));									/** column SYSTEMKEY	: systemkey			*/
	        	insr3150Vo.setHlthInsrYr(MSFSharedUtils.allowNulls(eMap.get("hlthInsrYr")));								/** column 귀속년도		: hlthInsrYr		*/
	        	insr3150Vo.setYrlyPayTotAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(eMap.get("yrlyPayTotAmnt"), "0")));	/** column 연간보수총액	: yrlyPayTotAmnt	*/
	        	insr3150Vo.setDutyMnthIcm(new BigDecimal(MSFSharedUtils.defaultNulls(eMap.get("dutyMnthIcm"), "0")));		/** column 근무월수		: dutyMnthIcm		*/
	        	insr3150Vo.setIsmt(sessionUser.getUsrId());																	/** column 수정자		: ismt				*/
	//			insr3150Vo.setRevnDt(insr3150Vo.getRevnDt());																/** column 수정일자		: revnDt			*/
	//			insr3150Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());							/** column 수정주소		: revnAddr			*/
				
				insr4400ExcelService.updateTxtFileInsr3150(insr3150Vo);
			}
	        

			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
			 * D:delete		S:select	B:배치 
			 * L:로그인		O:로그아웃
			 */
			//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
        
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
        	
        }
		
        return new ModelAndView("insr4400TxtExcelView", map);
    }
    
    /**
     * 엑셀파일로 출력한다.(양식)
     * @param Insr3150SrhVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsInsr4400Export.do")   
    public ModelAndView xlsInsr3150Export(@ModelAttribute("Insr3150SrhVO") Insr3150SrhVO Insr3150SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception {  
    	
    	String method = calledClass + ".xlsInsr3150Export"; 

        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
      
        Map<String, Object> map = new HashMap<String, Object>(); 
        
    	String windowNm = "건강보험연말정산";
		String windowId = "INSR4400";
        
		try{
        
	        Insr3150SrhVo.setUsrId(sessionUser.getUsrId());  
	        Insr3150SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        Insr3150SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        
	         
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getTypOccuCd())); 
	        Insr3150SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	       // Insr3150SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	       
	       // List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getPyspGrdeCd())); 
	       // Insr3150SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
	       // Insr3150SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDtilOccuInttnCd())); 
	        Insr3150SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	       // Insr3150SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	         
	        List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getHdofcCodtnCd())); 
	        Insr3150SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);  
	       // Insr3150SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	         
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	Insr3150SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           Insr3150SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	Insr3150SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getPayrMangDeptCd()));    
	                 if (Insr3150SrhVo.getPayrMangDeptCd().equals(Insr3150SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	Insr3150SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 Insr3150SrhVo.setDeptCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()));  
	                      Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	         
	        
	        Insr3150SrhVo.setDeptCdAuth(Insr3150SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        Insr3150SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	        
	       /******************************** 권한 ************************************************************************/
	        
	//        if (Insr3150SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()))) {
	//        	Insr3150SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
	//        	List<String> listDeptCd = null; 
	//        	Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	//        	Insr3150SrhVo.setDeptCd("");     //부서코드
	//        } else {
	//
	//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()));  
	//            Insr3150SrhVo.setDeptCdArr(listDeptCd);     //부서코드  
	//            Insr3150SrhVo.setDeptCd(MSFSharedUtils.allowNulls(Insr3150SrhVo.getDeptCd()));     //부서코드 
	//        }
	        
	         
	//        List listInsr4400 = insr4400ExcelService.selectXlsInsr4400List(Insr3150SrhVo);
	        
	        //빈 양식만을 저장하므로 select 쿼리 필요 없음.
	        List<Insr3150SrhVO> listInsr4400 = new ArrayList<Insr3150SrhVO>();
	        
//	        Map<String, Object> map = new HashMap<String, Object>(); 
	        map = new HashMap<String, Object>(); 
	        map.put("listInsr4400", listInsr4400);
        
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        }
        
        return new ModelAndView("insr4400FileExcelView", map);
    }
    
    
    /**
     * 엑셀파일을 업로드한다.
     * @param MultipartFile, Model, HttpServletRequest
     * @return sResult
     * @throws InvalidFormatException, IOException, SAXException
     */
    @RequestMapping(value = "/imp/XlsReadInsr4400Import.do", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("insr4400flUp") MultipartFile file,
			Model model, final HttpServletRequest request, final HttpServletResponse response) throws InvalidFormatException, IOException, SAXException {
    	
    	String realPath = request.getSession().getServletContext().getRealPath(""); 
    	String xmlConfig = "/upXmlConfig/INSR/Insr4400Mapping.xml";
    	
    	String windowNm = "건강보험연말정산";
		String windowId = "INSR4400";
    	
    	String method = calledClass + ".handleFormUpload";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);	
    	
    	String sResult = "";			//결과 상태값
    	InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
//		FileInputStream inputfis = null;
		
		List<Insr3150VO> insr3150List = new ArrayList<Insr3150VO>();
		Map<String, List> beans = new HashMap<String, List>();
		
	    beans.put("insr3150List", insr3150List);
	    
	    
		
		try {
			
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {
				if( insr3150List == null || insr3150List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					//엑셀 업로드 서비스 호출(delete 후에 insert함)
					insr4400ExcelService.updateXlsInsr4400(insr3150List, request);
					sResult =  "success";
				}
			}else {
				PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
				sResult =  "error";
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
			 * D:delete		S:select	B:배치 
			 * L:로그인		O:로그아웃
			 */
			//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D:C");
		}catch(Exception e) {
			PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D:C",e, windowNm , windowId);
			
		}finally {
			IOUtils.closeQuietly(inputXML);
			IOUtils.closeQuietly(inputXLS);
 		}
		
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:U:D");


		return sResult;
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
