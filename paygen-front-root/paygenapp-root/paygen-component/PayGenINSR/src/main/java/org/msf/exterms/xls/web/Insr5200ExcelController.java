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
import org.msf.exterms.xls.service.Insr5200ExcelService;
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
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.app.exterms.insurance.server.vo.Insr5200ExcelVO;
import com.app.exterms.insurance.server.vo.Insr5200SrhVO;
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
public class Insr5200ExcelController {


	private static final Logger logger = LoggerFactory.getLogger(Insr5200ExcelController.class);
    private static final String calledClass = Insr5200ExcelController.class.getName();


	@Resource(name = "Insr5200ExcelService")
	private Insr5200ExcelService insr5200ExcelService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/**
	 * 엑셀 양식파일로 출력한다.
	 * @param searchVO 검색조건
	 * @return 엑셀파일
	 * @throws Exception
	 */
	@RequestMapping(value="/exp/XlsInsr5200TempExport.do")   
	public ModelAndView xlsInsr5200TempExport(@ModelAttribute("Insr5200SrhVO") Insr5200SrhVO insr5200SrhVo, HttpServletRequest request ,ModelMap model) 
			throws Exception { 
		
	   	String strUpDivCd = MSFSharedUtils.allowNulls(insr5200SrhVo.getUploadDivCd());
	   	
    	String rtnViewName = "";
		
		Map<String, Object> map = new HashMap<String, Object>(); 
		
        if("I0300002".equals(strUpDivCd)){  //세부업로드
        	
        	rtnViewName = "insr5200TempExcelView";
        }else{  // 간단업로드 
        	
        	rtnViewName = "insr5200_1TempExcelView";
        }
		
		return new ModelAndView(rtnViewName , map);
	}
	
	/**
	 * 엑셀파일을 업로드한다.
	 * @param MultipartFile, Model, HttpServletRequest
	 * @return sResult
	 * @throws InvalidFormatException, IOException, SAXException
	 */
	@RequestMapping(value = "/imp/XlsInsr5200Import.do", method = RequestMethod.POST)
	public String handleFormUpload(@ModelAttribute("Insr5200SrhVO") Insr5200SrhVO insr5200SrhVo,  @RequestParam("insr5200flUp") MultipartFile file
			, Model model
			, final HttpServletRequest request ,  final HttpServletResponse response
			) throws InvalidFormatException, IOException, SAXException {
		
		String realPath = request.getSession().getServletContext().getRealPath("");
		String xmlConfig = "/upXmlConfig/INSR/Insr5200Mapping.xml";
		
		String windowNm = "고용보험월별대사";
		String windowId = "INSR5200";		
		
		String method = calledClass + ".handleFormUpload";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		String srhDeductYr = insr5200SrhVo.getSrhPayYr();
		String srhDeductMnth = insr5200SrhVo.getSrhPayMonth();
	
//		System.out.println("srhDeductYr================"+ srhDeductYr);
//		System.out.println("srhDeductMnth==============="+ srhDeductMnth );
		
		if  (insr5200ExcelService == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			insr5200ExcelService = (Insr5200ExcelService) wac.getBean("Insr5200ExcelService" ); 
		}

		String sResult = "";			//결과 상태값
		InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
		//	FileInputStream inputfis = null;
		PrintWriter out ;

		List<Insr5200ExcelVO> insr5200List = new ArrayList<Insr5200ExcelVO>();
		Map<String, List> beans = new HashMap<String, List>();
		beans.put("insr5200List", insr5200List);

		try {
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());

			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);

			if(xlsReadStatus.isStatusOK()) {
//				System.out.println("insr5200List 444444============================="+insr5200List.get(0).toString());
				
				for(int i = 0 ; i<  insr5200List.size()  ; i++){
					if("".equals(MSFSharedUtils.defaultNulls(insr5200List.get(i).getDducYrMnth(),"")) ){
						insr5200List.get(i).setDducYrMnth(srhDeductYr+srhDeductMnth);
					}
				}
				
				if( insr5200List == null || insr5200List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
				
				//엑셀 업로드 서비스 호출(delete 후에 insert함)
					long excelCount = insr5200List.size();
					long result ;
				
					result = insr5200ExcelService.updateXlsInsr5200(insr5200List, request);
				
				
					if(result==0L){
						//Window.alert("aaaaaaaaaaaaaaaaaaa");
	
						//엑셀 업로드 서비스 호출(delete 후에 insert함)
						sResult = "error";
						
						PrgmComUtils.responseAlert(response, "올바른 엑셀양식인지 또는 엑셀 업로드 대상자가 시스템 등록된 인원인지 확인해주세요." );	

					}else if(result > 0L){
						sResult = "success";
			            
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
			////MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:U");
			
		} catch(Exception e) {
			
			PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:U",e, windowNm , windowId);
			
		} finally {
			IOUtils.closeQuietly(inputXML);
			IOUtils.closeQuietly(inputXLS);
		}
		
		return sResult;
	}
	
	/**
	 * 엑셀파일을 업로드한다.
	 * @param MultipartFile, Model, HttpServletRequest
	 * @return sResult
	 * @throws InvalidFormatException, IOException, SAXException
	 */
	@RequestMapping(value = "/imp/XlsInsr5200_1Import.do", method = RequestMethod.POST)
	public String handleFormUploadSimple(@ModelAttribute("Insr5200SrhVO") Insr5200SrhVO insr5200SrhVo,  @RequestParam("insr5200flUp") MultipartFile file
			, Model model
			, final HttpServletRequest request ,  final HttpServletResponse response
			) throws InvalidFormatException, IOException, SAXException {
		
		String realPath = request.getSession().getServletContext().getRealPath("");
		String xmlConfig = "/upXmlConfig/INSR/Insr5200_1Mapping.xml";
		
		String windowNm = "고용보험월별대사";
		String windowId = "INSR5200";		
		
		String method = calledClass + ".handleFormUploadSimple";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		String srhDeductYr = insr5200SrhVo.getSrhPayYr();
		String srhDeductMnth = insr5200SrhVo.getSrhPayMonth();
	
//		System.out.println("srhDeductYr================"+ srhDeductYr);
//		System.out.println("srhDeductMnth==============="+ srhDeductMnth );
		
		if  (insr5200ExcelService == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			insr5200ExcelService = (Insr5200ExcelService) wac.getBean("Insr5200ExcelService" ); 
		}

		String sResult = "";			//결과 상태값
		InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
		//	FileInputStream inputfis = null;
		PrintWriter out ;

		List<Insr5200ExcelVO> insr5200List = new ArrayList<Insr5200ExcelVO>();
		Map<String, List> beans = new HashMap<String, List>();
		beans.put("insr5200List", insr5200List);

		try {
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());

			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);

			if(xlsReadStatus.isStatusOK()) {
//				System.out.println("insr5200List 444444============================="+insr5200List.get(0).toString());
				
				for(int i = 0 ; i<  insr5200List.size()  ; i++){
					if("".equals(MSFSharedUtils.defaultNulls(insr5200List.get(i).getDducYrMnth(),"")) ){
						insr5200List.get(i).setDducYrMnth(srhDeductYr+srhDeductMnth);
					}
				}
				
				//엑셀 업로드 서비스 호출(delete 후에 insert함)
				
				if( insr5200List == null || insr5200List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
				
				//엑셀 업로드 서비스 호출(delete 후에 insert함)
					long excelCount = insr5200List.size();
					long result ;
				
					result = insr5200ExcelService.updateXlsInsr5200(insr5200List, request);
				
				
					if(result==0L){
						//Window.alert("aaaaaaaaaaaaaaaaaaa");
	
						//엑셀 업로드 서비스 호출(delete 후에 insert함)
						sResult = "error";
						
						PrgmComUtils.responseAlert(response, "올바른 엑셀양식인지 또는 엑셀 업로드 대상자가 시스템 등록된 인원인지 확인해주세요." );	

					}else if(result > 0L){
						sResult = "success";
			            
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
			////MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:U");
			
		} catch(Exception e) {
			PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );	
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:U",e, windowNm , windowId);
			
		} finally {
			IOUtils.closeQuietly(inputXML);
			IOUtils.closeQuietly(inputXLS);
		}
		
		return sResult;
	}
	
	/**
	 * 엑셀파일로 출력한다.
	 * @param searchVO 검색조건
	 * @return 엑셀파일
	 * @throws Exception
	 */
	@RequestMapping(value="/exp/XlsInsr5200Export.do")   
	public ModelAndView xlsInsr5200Export(@ModelAttribute("Insr5200SrhVO") Insr5200SrhVO insr5200SrhVo,HttpServletRequest request ,ModelMap model) 
			throws Exception { 
		
		String method = calledClass + ".xlsInsr5200Export";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		List<String> listDeptCd = new ArrayList<String>(); 
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		String windowNm = "고용보험월별대사";
		String windowId = "INSR5200";
		
		try{
        	
			insr5200SrhVo.setUsrId(sessionUser.getUsrId());  
			insr5200SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
			insr5200SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			insr5200SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(insr5200SrhVo.getMangeDeptCd()));  
			insr5200SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(insr5200SrhVo.getRepbtyBusinDivCd())); 
			
			List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5200SrhVo.getHdofcCodtnCd())); 
			insr5200SrhVo.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태
			insr5200SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(insr5200SrhVo.getEmymtDivCd()));	         //고용구분
			List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5200SrhVo.getTypOccuCd())); 
			insr5200SrhVo.setTypOccuCdArr(lstTypeOccuCd); //직종       
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5200SrhVo.getDtilOccuInttnCd())); 
			insr5200SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세
			insr5200SrhVo.setBusinCd(MSFSharedUtils.allowNulls(insr5200SrhVo.getBusinCd()));   //사업
			insr5200SrhVo.setHanNm(MSFSharedUtils.allowNulls(insr5200SrhVo.getHanNm()));			//성명
			insr5200SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(insr5200SrhVo.getResnRegnNum()));//주민번호
			insr5200SrhVo.setSystemkey(MSFSharedUtils.allowNulls(insr5200SrhVo.getSystemkey()));	//시스템키
			List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5200SrhVo.getSystemkey())); 
			insr5200SrhVo.setSystemKeyArr(systemKeyArr);
			/******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	insr5200SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           insr5200SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           insr5200SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	insr5200SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr5200SrhVo.getPayrMangDeptCd()));  
	        	insr5200SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr5200SrhVo.getPayrMangDeptCd()));
	                 if (insr5200SrhVo.getPayrMangDeptCd().equals(insr5200SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	insr5200SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	insr5200SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 insr5200SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr5200SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5200SrhVo.getDeptCd()));  
	                      insr5200SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        insr5200SrhVo.setDeptCdAuth(insr5200SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        insr5200SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr5200SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	        
	       /******************************** 권한 ************************************************************************/
			List listInsr5200 = insr5200ExcelService.selectXlsInsr5200List(insr5200SrhVo);
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listInsr5200.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listInsr5200.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}


			map = new HashMap<String, Object>(); 
			map.put("listInsr5200", excelList);
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */

		
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        }

		return new ModelAndView("insr5200ExcelView", map);

	}


	

	
	
	
}
