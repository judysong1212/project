package org.msf.exterms.xls.web;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
import org.msf.exterms.xls.service.Insr3100ExcelService;
import org.msf.exterms.xls.service.Insr4100ExcelService;
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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.app.exterms.insurance.server.vo.Insr4100SrhVO;
import com.app.exterms.insurance.server.vo.Insr4100VO;
import com.app.exterms.insurance.server.vo.Insr4300VO;
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
public class Insr3100ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Insr3100ExcelController.class);  
    private static final String calledClass = Insr3100ExcelController.class.getName();
 
    
    @Resource(name = "Insr3100ExcelService")
    private Insr3100ExcelService insr3100ExcelService;

    @Resource(name = "Insr4100ExcelService")
    private Insr4100ExcelService insr4100ExcelService;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 양식 다운 _엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsInsr3100TempExport.do")   
    public ModelAndView xlsInsr3100TempExport(HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        
        Map<String, Object> map = new HashMap<String, Object>(); 
        
        return new ModelAndView("insr3100TempExcelView", map);
         
    }
    
    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsInsr3100Export.do")   
    public ModelAndView xlsInsr3100Export(@ModelAttribute("Insr4100SrhVO") Insr4100SrhVO insr4100SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsInsr3100Export";
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
        Map<String, Object> map = new HashMap<String, Object>();
        
    	String windowNm = "국민연금기본관리";
		String windowId = "INSRP3100";
        
        try{
        	
	        insr4100SrhVo.setUsrId(sessionUser.getUsrId());  
	        insr4100SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        insr4100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        insr4100SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(insr4100SrhVo.getMangeDeptCd()));
	        insr4100SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(insr4100SrhVo.getRepbtyBusinDivCd())); 
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4100SrhVo.getTypOccuCd())); 
	        insr4100SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	       // insr4100SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	       
	        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4100SrhVo.getPyspGrdeCd())); 
	        insr4100SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
	       // insr4100SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4100SrhVo.getDtilOccuInttnCd())); 
	        insr4100SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	       // insr4100SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	         
	        List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4100SrhVo.getHdofcCodtnCd())); 
	        insr4100SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);  
	       // insr4100SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	         
	        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4100SrhVo.getSystemkey())); 
	        insr4100SrhVo.setSystemKeyArr(systemKeyArr);
	        
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
	//			//   List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd()));  
	//		     //   insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드  
	//		    //    insr4100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	//			   
	//			   if ("Y".equals(sessionUser.getPayrMangDeptYn())) {
	//				    
	//					if (" ".equals(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd()))) {
	//						insr4100SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
	//	 		            insr4100SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd())) ;   //단위기관코드
	//	 		            List<String> listDeptCd = null;  
	//	 		            insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드
	//	 		            insr4100SrhVo.setDeptCd("");  
	//	 		             
	//				     } else if ("405030200".equals(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd()))) {
	//				    	 
	//				    	insr4100SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
	//	 		            insr4100SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd())) ;   //단위기관코드
	//	 		            List<String> listDeptCd = null;  
	//	 		            insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드
	//	 		            insr4100SrhVo.setDeptCd("");  
	//	 		            
	//				     } else {
	//				    	 
	//				     } 
	//			   } else {
	//				    
	//					if (" ".equals(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd()))) {
	//						insr4100SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
	//	 		            insr4100SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd())) ;   //단위기관코드
	//	 		            List<String> listDeptCd = null;  
	//	 		            insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드
	//	 		            insr4100SrhVo.setDeptCd("");  
	//				     } else if ("405030200".equals(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd()))) {
	//				    	insr4100SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
	//	 		            insr4100SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd())) ;   //단위기관코드
	//	 		            List<String> listDeptCd = null;  
	//	 		            insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드
	//	 		            insr4100SrhVo.setDeptCd("");  
	//				     } else {
	//				    	 
	//				     } 
	//			   }
	//				
	//		   }
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	insr4100SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           insr4100SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        		insr4100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr4100SrhVo.getPayrMangDeptCd()));    
	                 if (insr4100SrhVo.getPayrMangDeptCd().equals(insr4100SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	insr4100SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 insr4100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd()));  
	                      insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	         
	        
	        insr4100SrhVo.setDeptCdAuth(insr4100SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        insr4100SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr4100SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	      
	       /******************************** 권한 ************************************************************************/
	         
	        
	//        if (insr4100SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd()))) {
	//        	insr4100SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
	//        	List<String> listDeptCd = null; 
	//        	insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	//        	insr4100SrhVo.setDeptCd("");     //부서코드
	//        } else {
	//
	//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd()));  
	//            insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드  
	//            insr4100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr4100SrhVo.getDeptCd()));     //부서코드 
	//        }
	        
	         
	        List listInsr4100 = insr3100ExcelService.selectXlsInsr4100List(insr4100SrhVo);
	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listInsr4100.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listInsr4100.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}

//	        Map<String, Object> map = new HashMap<String, Object>(); 
	        map = new HashMap<String, Object>(); 
	        map.put("listInsr4100", excelList);
	        
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
        
        return new ModelAndView("insr3100ExcelView", map);
         
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
    @RequestMapping(value = "/imp/XlsInsr3100Import.do")
    public String xlsInsr3100Import(@ModelAttribute("Insr4300VO") Insr4300VO insr4300Vo,final HttpServletRequest request
            , Map commandMap , Model model) throws Exception {
    	
    	String method = calledClass + ".xlsInsr3100Import";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		String windowNm = "국민연금기본관리";
		String windowId = "INSRP3100";

         
        if  (insr3100ExcelService == null) { 
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            insr3100ExcelService = (Insr3100ExcelService) wac.getBean("Insr3100ExcelService" ); 
           
       }
        
        final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        final Map<String, MultipartFile> files = multiRequest.getFileMap();
        InputStream fis = null; // 2011.11.1 보안점검 후속조치
        InputStream fis2 = null; // 2011.11.1 보안점검 후속조치
        InputStream fis3 = null; // 2011.11.1 보안점검 후속조치
        
        String sResult = "";
        
        Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
        MultipartFile file;

        while (itr.hasNext()) {
            Entry<String, MultipartFile> entry = itr.next();

            file = entry.getValue();
            if (!"".equals(file.getOriginalFilename())) {
                // 2011.10.07 업로드 파일에 대한 확장자를 체크
                if (file.getOriginalFilename().endsWith(".xls")
                        || file.getOriginalFilename().endsWith(".XLS") ) {
                    
                         
                    //2011.10.21 보안점검 후속조치
                    try {
                        fis = file.getInputStream();  //4300인서트 
                        fis2 = file.getInputStream(); //4100 업데이트 
                        fis3 = file.getInputStream(); //127 업데이트 
                      
                        insr3100ExcelService.insertXlsInsr4300(fis); 
                        insr3100ExcelService.insertXlsInsr4100(fis2); 
                        insr3100ExcelService.insertXlsPsnl0127(fis3); 
                         
                        sResult =  "success";
                    } catch(Exception e) {
                          e.printStackTrace();
                          
              	    	/** 에러 로그 **/			
              	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C",e, windowNm , windowId);
                        sResult = "error";
                       
                    } finally {
                        if (fis != null)    // 2011.11.1 보안점검 후속조치
                            fis.close();
                    }
                  
                    
                    
                } else  if (  file.getOriginalFilename().endsWith(".xlsx")
                        || file.getOriginalFilename().endsWith(".XLSX")) {
                    
                    //2011.10.21 보안점검 후속조치
                    try {
                    	 fis = file.getInputStream();  //4300인서트 
                         fis2 = file.getInputStream(); //4100 업데이트 
                         fis3 = file.getInputStream(); //127 업데이트 
                      
                        insr3100ExcelService.insertXSSFInsr4300(fis);   
                        insr3100ExcelService.insertXSSFInsr4100(fis2); 
                        insr3100ExcelService.insertXSSFPsnl0127(fis3); 
                        
                        sResult =  "success";
                        
                    } catch(Exception e) {
                          e.printStackTrace();
                          
                          /** 에러 로그 **/			
                          MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C",e, windowNm , windowId);
                        sResult = "error";
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
		//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C");
		
        return sResult;
 
    }
    
    
    
    
    /**
	 * 엑셀파일을 업로드한다.
	 * @param MultipartFile, Model, HttpServletRequest
	 * @return sResult
	 * @throws InvalidFormatException, IOException, SAXException
	 */
	@RequestMapping(value = "/imp/XlsReadInsr3100Import.do", method = RequestMethod.POST)
	public String handleFormUpload(  @RequestParam("insr3100flUp") MultipartFile file
								   , Model model
								   , final HttpServletRequest request, final HttpServletResponse response
								  ) throws InvalidFormatException, IOException, SAXException {
		String realPath = request.getSession().getServletContext().getRealPath("");
		String xmlConfig = "/upXmlConfig/INSR/Insr3100Mapping.xml";
		
		String method = calledClass + ".handleFormUpload";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

		
		String sResult = "";			//결과 상태값
		InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
	//	FileInputStream inputfis = null;
		PrintWriter out ;
		
		List<Insr4100VO> insr4100List = new ArrayList<Insr4100VO>();
		Map<String, List> beans = new HashMap<String, List>();
		
		beans.put("insr4100List", insr4100List);
		
		try {
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {
				
				long result ;
				int  chkInput = 0 ;
				
				for(int i = 0 ; i<  insr4100List.size()  ; i++){
					
					if("".equals(MSFSharedUtils.defaultNulls(insr4100List.get(i).getNatPennStdIncmMnthAmnt(),"")) ){
						chkInput = chkInput + 1 ;
					}
				}
				
				
				if( insr4100List == null || insr4100List.size() <= 0 || chkInput > 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					long excelCount = insr4100List.size();
					
					//엑셀 업로드 서비스 호출(delete 후에 insert함)
					result = insr3100ExcelService.updateXlsInsr3100(insr4100List, request);		
					
					if(result==0L){
						//엑셀 업로드 서비스 호출(delete 후에 insert함)
						sResult = "error";
						
						PrgmComUtils.responseAlert(response, "올바른 엑셀 양식인지 또는 엑셀 업로드 대상자가 시스템 등록된 인원인지 확인해주세요." );
			
					}else if(result > 0L){
						sResult = "success";
						
			            if(result == excelCount){
			            	PrgmComUtils.responseAlert(response, "업로드가 완료되었습니다." );
			            }else{
			            	PrgmComUtils.responseAlert(response, "엑셀업로드 "+ excelCount+"중에  총"+ result +"건 입력되었습니다. 엑셀데이타를 확인해주세요." );
			            }
			            
			            
					}
					
				}

				sResult = "success";
			} else {
				sResult = "error";
			}
		} catch(Exception e){
			
			PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
			e.printStackTrace();
		    /** 에러 로그 **/
		//	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e);
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
		//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		
		return sResult;
	}
    
}
