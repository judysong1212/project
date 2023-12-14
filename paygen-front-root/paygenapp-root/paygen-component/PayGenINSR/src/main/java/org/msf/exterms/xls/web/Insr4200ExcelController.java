package org.msf.exterms.xls.web;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
import org.msf.exterms.xls.service.Insr4200ExcelService;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.app.exterms.insurance.server.vo.Insr3200ExcelVO;
import com.app.exterms.insurance.server.vo.Insr3200SrhVO;
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
public class Insr4200ExcelController {
	private static final Logger logger = LoggerFactory.getLogger(Insr4200ExcelController.class);
    private static final String calledClass = Insr4200ExcelController.class.getName();
	
	@Resource(name = "Insr4200ExcelService")
	private Insr4200ExcelService insr4200ExcelService;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/**
	 * 엑셀파일로 출력한다.
	 * @param searchVO 검색조건
	 * @return 엑셀파일
	 * @throws Exception
	 */
	@RequestMapping(value="/exp/XlsFileInsr4200Export.do")
	public ModelAndView xlsInsr3200Export(  @ModelAttribute("Insr3200SrhVO") Insr3200SrhVO insr3200SrhVo
										  , HttpServletRequest request
										  , ModelMap model
										 ) throws Exception {
		
		String method = calledClass + ".xlsInsr3200Export";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		List<String> listDeptCd = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		String windowNm = "건강보험월정산대사";
		String windowId = "INSR4200";
		
		try{
        	
			insr3200SrhVo.setUsrId(sessionUser.getUsrId());
			insr3200SrhVo.setDpobCd(sessionUser.getDpobCd());	/* 사업장코드 */
			insr3200SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());	/* 단위기관담당자여부 */
			insr3200SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(insr3200SrhVo.getMangeDeptCd()));	/* 관리부서 */
			insr3200SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(insr3200SrhVo.getRepbtyBusinDivCd()));
			List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVo.getTypOccuCd()));
			insr3200SrhVo.setTypOccuCdArr(lstTypeOccuCd);
			
			List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVo.getPyspGrdeCd()));
			insr3200SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVo.getDtilOccuInttnCd()));
			insr3200SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);
			
			List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVo.getHdofcCodtnCd()));
			insr3200SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);
	        
			/******************************** 권한 ************************************************************************/
			String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
			if("FALSE".equals(chkDeptCd)) {
				insr3200SrhVo.setDeptCd(sessionUser.getDeptCd());
				listDeptCd.add(sessionUser.getDeptCd());
				insr3200SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
				insr3200SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
				insr3200SrhVo.setPayrMangeDeptCd(sessionUser.getPayrMangDeptCd());
			} else {
				insr3200SrhVo.setPayrMangeDeptCd(insr3200SrhVo.getPayrMangDeptCd());
				insr3200SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr3200SrhVo.getPayrMangDeptCd()));
				if(insr3200SrhVo.getPayrMangDeptCd().equals(insr3200SrhVo.getDeptCd())) {
					listDeptCd = null;
					insr3200SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
					insr3200SrhVo.setDeptCd("");	/* 부서코드 */
				} else {
					insr3200SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr3200SrhVo.getDeptCd()));
					listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVo.getDeptCd()));
					insr3200SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
				}
			}
			
			insr3200SrhVo.setDeptCdAuth(insr3200SrhVo.getDeptCd().replace(",", ""));	/* 권한처리를위해 추가 */
			insr3200SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr3200SrhVo.getDtilOccuInttnCd()).replace(",", ""));
			
			/******************************** 권한 ************************************************************************/
			
			List listInsr3200 = insr4200ExcelService.selectXlsInsr4200ToInsr3200List(insr3200SrhVo);
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listInsr3200.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listInsr3200.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}
//			Map<String, Object> map = new HashMap<String, Object>();
			map = new HashMap<String, Object>();
			//map.put("listInsr3200", listInsr3200);
			map.put("listInsr3200", excelList);
			
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
		
		return new ModelAndView("insr4200ExcelView", map);
	}

	/**
	 * 엑셀파일을 업로드한다.
	 * @param MultipartFile, Model, HttpServletRequest
	 * @return sResult
	 * @throws InvalidFormatException, IOException, SAXException
	 */
	@RequestMapping(value = "/imp/XlsInsr4200Import.do", method = RequestMethod.POST)
	public String handleFormUpload(   @ModelAttribute("Insr3200SrhVO") Insr3200SrhVO insr3200SrhVo
			  , @RequestParam("insr4200flUp") MultipartFile file
								   , Model model
								   , final HttpServletRequest request,  final HttpServletResponse response
								  ) throws InvalidFormatException, IOException, SAXException {
		String realPath = request.getSession().getServletContext().getRealPath("");
		String xmlConfig = "/upXmlConfig/INSR/Insr4200Mapping.xml";
		
		String windowNm = "건강보험월정산대사";
		String windowId = "INSR4200";

		String method = calledClass + ".handleFormUpload";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

		String sResult = "";			/* 결과 상태값	*/
		InputStream inputXML = null;	/* XML			*/
		InputStream inputXLS = null;	/* 엑셀파일		*/
		PrintWriter out ;
	//	FileInputStream inputfis = null;
		
		String srhDeductYr = insr3200SrhVo.getSrhNofctYr();
		String srhDeductMnth = insr3200SrhVo.getSrhNofctMnth();
//		
//		System.out.println("srhDeductYr================"+ srhDeductYr);
//		System.out.println("srhDeductMnth==============="+ srhDeductMnth );
		
		List<Insr3200ExcelVO> insr3200List = new ArrayList<Insr3200ExcelVO>();
		Map<String, List> beans = new HashMap<String, List>();
		
		beans.put("insr3200List", insr3200List);
		
		try {
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
			
//			System.out.println("inputXLS  ========================================"+inputXLS.toString());
			
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {

				// 엑셀의 고지년월 값이 없으면 검색조건에서 값을 넣어주게 처리 .
				for(int i = 0 ; i<  insr3200List.size()  ; i++){
					if("".equals(MSFSharedUtils.defaultNulls(insr3200List.get(i).getNofctYrMnth(),""))){
						insr3200List.get(i).setNofctYrMnth(srhDeductYr+srhDeductMnth);
					}
				}
				
				
				if( insr3200List == null || insr3200List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					long excelCount = insr3200List.size();
					long result ;
				
					result = insr4200ExcelService.updateXlsInsr4200(insr3200List, request);
	
					if(result==0L){
	
						//엑셀 업로드 서비스 호출(delete 후에 insert함)
						sResult = "error";
						
						PrgmComUtils.responseAlert(response, "올바른 엑셀양식인지 또는 엑셀 업로드 대상자가 시스템 등록된 인원인지 확인해주세요." );
								
					}else if(result > 0L){
						sResult = "success";
						//sResult = "error";
			            
			            if(result == excelCount){
			            	PrgmComUtils.responseAlert(response, "업로드가 완료되었습니다." );
			            }else{
			            	PrgmComUtils.responseAlert(response, "엑셀업로드 "+ excelCount+"중에  총"+ result +"건 입력되었습니다. 엑셀데이타를 확인해주세요." );
			            }
					}
				}
				
			} else  {
				sResult = "error";
				
				 PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:U:D");
			
		} catch(Exception e) {
			
			 PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
			e.printStackTrace();
			
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:U:D",e, windowNm , windowId);
	    	
	    } finally {
			IOUtils.closeQuietly(inputXML);
			IOUtils.closeQuietly(inputXLS);
		}
		

		//Window.alert("cccccccccccccccccccc");
		
		return sResult;
	}
	
	
	/**
	 * 엑셀파일을 업로드한다.
	 * @param MultipartFile, Model, HttpServletRequest
	 * @return sResult
	 * @throws InvalidFormatException, IOException, SAXException
	 */
	@RequestMapping(value = "/imp/XlsInsr4200_1Import.do", method = RequestMethod.POST)
	public String handleFormUploadSimple(   @ModelAttribute("Insr3200SrhVO") Insr3200SrhVO insr3200SrhVo
			  , @RequestParam("insr4200flUp") MultipartFile file
								   , Model model
								   , final HttpServletRequest request,  final HttpServletResponse response
								  ) throws InvalidFormatException, IOException, SAXException {
		String realPath = request.getSession().getServletContext().getRealPath("");
		String xmlConfig = "/upXmlConfig/INSR/Insr4200_1Mapping.xml";
		
		String windowNm = "건강보험월정산대사";
		String windowId = "INSR4200";

		String method = calledClass + ".handleFormUploadSimple";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

		String sResult = "";			/* 결과 상태값	*/
		InputStream inputXML = null;	/* XML			*/
		InputStream inputXLS = null;	/* 엑셀파일		*/
		PrintWriter out ;
	//	FileInputStream inputfis = null;
		
		String srhDeductYr = insr3200SrhVo.getSrhNofctYr();
		String srhDeductMnth = insr3200SrhVo.getSrhNofctMnth();
//		
//		System.out.println("srhDeductYr================"+ srhDeductYr);
//		System.out.println("srhDeductMnth==============="+ srhDeductMnth );
		
		List<Insr3200ExcelVO> insr3200List = new ArrayList<Insr3200ExcelVO>();
		Map<String, List> beans = new HashMap<String, List>();
		
		beans.put("insr3200List", insr3200List);
		
		try {
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
			
//			System.out.println("inputXLS  ========================================"+inputXLS.toString());
			
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {
				if(insr3200List != null){
					// System.out.println("insr3200List  ========================================"+insr3200List.get(0).toString());	
				}
				
				// 엑셀의 고지년월 값이 없으면 검색조건에서 값을 넣어주게 처리 .
				for(int i = 0 ; i<  insr3200List.size()  ; i++){
					if("".equals(MSFSharedUtils.defaultNulls(insr3200List.get(i).getNofctYrMnth(),""))){
						insr3200List.get(i).setNofctYrMnth(srhDeductYr+srhDeductMnth);
					}
				}
				
				if( insr3200List == null || insr3200List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					long excelCount = insr3200List.size();
					long result ;
				
					result = insr4200ExcelService.updateXlsInsr4200(insr3200List, request);
	
					if(result==0L){
	
						//엑셀 업로드 서비스 호출(delete 후에 insert함)
						sResult = "error";
						
						PrgmComUtils.responseAlert(response, "올바른 엑셀양식인지 또는 엑셀 업로드 대상자가 시스템 등록된 인원인지 확인해주세요." );
								
					}else if(result > 0L){
						sResult = "success";
						//sResult = "error";
			            
			            if(result == excelCount){
			            	PrgmComUtils.responseAlert(response, "업로드가 완료되었습니다." );
			            }else{
			            	PrgmComUtils.responseAlert(response, "엑셀업로드 "+ excelCount+"중에  총"+ result +"건 입력되었습니다. 엑셀데이타를 확인해주세요." );
			            }
					}
				}
				
			} else  {
				sResult = "error";
				
				 PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:U:D");
			
		} catch(Exception e) {
			 PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
			e.printStackTrace();
			
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:U:D",e, windowNm , windowId);
	    	

			
	    } finally {
			IOUtils.closeQuietly(inputXML);
			IOUtils.closeQuietly(inputXLS);
		}
		

		//Window.alert("cccccccccccccccccccc");
		
		return sResult;
	}
	
	
//	@RequestMapping(value = "/imp/XlsInsr4200Import.do")
//	public String xlsInsr4200Import(@ModelAttribute("Insr3200VO") Insr3200VO insr3200Vo,final HttpServletRequest request
//            , Map commandMap , Model model) throws Exception {
//         
////        String sCmd = commandMap.get("dlgn0250flUp") == null ? "" : (String)commandMap.get("dlgn0250flUp");
////        if (sCmd.equals("")) {
////          return;
////        }
//
//        if  (insr4200ExcelService == null) { 
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( request.getSession().getServletContext());
//
//            insr4200ExcelService = (Insr4200ExcelService) wac.getBean("Insr4200ExcelService" ); 
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
//        int iCnt = 0;		
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
//                        fis = file.getInputStream();  //3200인서트 
//                        fis2 = file.getInputStream(); //3300 업데이트  
//                      
//                        iCnt = insr4200ExcelService.insertXlsInsr3200(fis); 
//                        if (iCnt > 0) { 
//                        	insr4200ExcelService.insertXlsInsr3300(fis2);  
//                        } 
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
//                    	 fis = file.getInputStream();  //3200인서트 
//                         fis2 = file.getInputStream(); //3300 업데이트  
//                      
//                        iCnt = insr4200ExcelService.insertXSSFInsr3200(fis);  
//                        if (iCnt > 0) {
//                        	insr4200ExcelService.insertXSSFInsr3300(fis2);  
//                        }
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
//    }
	
	/**
	 * 엑셀파일로 출력한다.
	 * @param searchVO 검색조건
	 * @return 엑셀파일
	 * @throws Exception
	 */
	@RequestMapping(value="/exp/XlsInsr4200Export.do")
	public ModelAndView xlsInsr4200Export(  @ModelAttribute("Insr3200SrhVO") Insr3200SrhVO insr3200SrhVo
										  , HttpServletRequest request
										  , ModelMap model
										 ) throws Exception {
		
		String method = calledClass + ".xlsInsr4200Export";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		List<String> listDeptCd = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		String windowNm = "건강보험월정산대사";
		String windowId = "INSR4200";
		
		try{
		
			insr3200SrhVo.setUsrId(sessionUser.getUsrId());
			insr3200SrhVo.setDpobCd(sessionUser.getDpobCd());	/* 사업장코드 */
			insr3200SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());	/* 단위기관담당자여부 */
			
			List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVo.getTypOccuCd()));
			insr3200SrhVo.setTypOccuCdArr(lstTypeOccuCd);
			
			List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVo.getPyspGrdeCd()));
			insr3200SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVo.getDtilOccuInttnCd()));
			insr3200SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);
			
			List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVo.getHdofcCodtnCd()));
			insr3200SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);
	        
			/******************************** 권한 ************************************************************************/
			String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
			if("FALSE".equals(chkDeptCd)) {
				insr3200SrhVo.setDeptCd(sessionUser.getDeptCd());
				listDeptCd.add(sessionUser.getDeptCd());
				insr3200SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
				insr3200SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
				insr3200SrhVo.setPayrMangeDeptCd(sessionUser.getPayrMangDeptCd());
			} else {
				insr3200SrhVo.setPayrMangeDeptCd(insr3200SrhVo.getPayrMangDeptCd());
				insr3200SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr3200SrhVo.getPayrMangDeptCd()));
				if(insr3200SrhVo.getPayrMangDeptCd().equals(insr3200SrhVo.getDeptCd())) {
					listDeptCd = null;
					insr3200SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
					insr3200SrhVo.setDeptCd("");	/* 부서코드 */
				} else {
					insr3200SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr3200SrhVo.getDeptCd()));
					listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVo.getDeptCd()));
					insr3200SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
				}
			}
			
			insr3200SrhVo.setDeptCdAuth(insr3200SrhVo.getDeptCd().replace(",", ""));	/* 권한처리를위해 추가 */
			insr3200SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr3200SrhVo.getDtilOccuInttnCd()).replace(",", ""));
			
			/******************************** 권한 ************************************************************************/
			
			List<Insr3200SrhVO> listInsr4200 = new ArrayList<Insr3200SrhVO>();
			
//			Map<String, Object> map = new HashMap<String, Object>();
			map = new HashMap<String, Object>();
			map.put("listInsr4200", listInsr4200);
			
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
		
		return new ModelAndView("insr4200ExcelView", map);
	}
	
	
	/**
	 * 엑셀파일로 출력한다.
	 * @param searchVO 검색조건
	 * @return 엑셀파일
	 * @throws Exception
	 */
	@RequestMapping(value="/exp/XlsInsr4200TempExport.do")
	public ModelAndView XlsInsr4200TempExport(  @ModelAttribute("Insr3200SrhVO") Insr3200SrhVO insr3200SrhVo
										  , HttpServletRequest request
										  , ModelMap model
										 ) throws Exception {
		
		
	   	String strUpDivCd = MSFSharedUtils.allowNulls(insr3200SrhVo.getUploadDivCd());
	   	
    	String rtnViewName = "";
		
		String method = calledClass + ".XlsInsr4200TempExport";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//		List<String> listDeptCd = new ArrayList<String>();
//		insr3200SrhVo.setUsrId(sessionUser.getUsrId());
//		insr3200SrhVo.setDpobCd(sessionUser.getDpobCd());	/* 사업장코드 */
//		insr3200SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());	/* 단위기관담당자여부 */
//		
//		List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVo.getTypOccuCd()));
//		insr3200SrhVo.setTypOccuCdArr(lstTypeOccuCd);
//		
//		List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVo.getPyspGrdeCd()));
//		insr3200SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);
//		
//		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVo.getDtilOccuInttnCd()));
//		insr3200SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);
//		
//		List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVo.getHdofcCodtnCd()));
//		insr3200SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);
//        
//		/******************************** 권한 ************************************************************************/
//		String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//		if("FALSE".equals(chkDeptCd)) {
//			insr3200SrhVo.setDeptCd(sessionUser.getDeptCd());
//			listDeptCd.add(sessionUser.getDeptCd());
//			insr3200SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
//			insr3200SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//			insr3200SrhVo.setPayrMangeDeptCd(sessionUser.getPayrMangDeptCd());
//		} else {
//			insr3200SrhVo.setPayrMangeDeptCd(insr3200SrhVo.getPayrMangDeptCd());
//			insr3200SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr3200SrhVo.getPayrMangDeptCd()));
//			if(insr3200SrhVo.getPayrMangDeptCd().equals(insr3200SrhVo.getDeptCd())) {
//				listDeptCd = null;
//				insr3200SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
//				insr3200SrhVo.setDeptCd("");	/* 부서코드 */
//			} else {
//				insr3200SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr3200SrhVo.getDeptCd()));
//				listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3200SrhVo.getDeptCd()));
//				insr3200SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
//			}
//		}
//		
//		insr3200SrhVo.setDeptCdAuth(insr3200SrhVo.getDeptCd().replace(",", ""));	/* 권한처리를위해 추가 */
//		insr3200SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr3200SrhVo.getDtilOccuInttnCd()).replace(",", ""));
//		
//		/******************************** 권한 ************************************************************************/
//		
//		List<Insr3200SrhVO> listInsr4200 = new ArrayList<Insr3200SrhVO>();
		
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("listInsr4200", listInsr4200);
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
        if("I0300002".equals(strUpDivCd)){  //세부업로드
        	
        	rtnViewName = "insr4200TempExcelView";
        }else{  // 간단업로드 
        	
        	rtnViewName = "insr4200_1TempExcelView";
        }
		
		return new ModelAndView(rtnViewName, map);
	}
}
