package org.msf.exterms.xls.web;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.msf.exterms.xls.service.Insr5100ExcelService;
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

import com.app.exterms.insurance.server.vo.Insr5100SrhVO;
import com.app.exterms.insurance.server.vo.Insr5100VO;
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
public class Insr5100ExcelController {


	private static final Logger logger = LoggerFactory.getLogger(Insr5100ExcelController.class);
    private static final String calledClass = Insr5100ExcelController.class.getName();


	@Resource(name = "Insr5100ExcelService")
	private Insr5100ExcelService insr5100ExcelService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/**
	 * 엑셀파일로 출력한다.
	 * @param searchVO 검색조건
	 * @return 엑셀파일
	 * @throws Exception
	 */
	@RequestMapping(value="/exp/XlsInsr5100TempExport.do")   
	public ModelAndView xlsInsr5100TempExport(HttpServletRequest request ,ModelMap model) 
			throws Exception { 
		Map<String, Object> map = new HashMap<String, Object>(); 
		return new ModelAndView("insr5100TempExcelView", map);
	}

	/**
	 * 엑셀파일로 출력한다.
	 * @param searchVO 검색조건
	 * @return 엑셀파일
	 * @throws Exception
	 */
	@RequestMapping(value="/exp/XlsInsr5100Export.do")   
	public ModelAndView xlsInsr5100Export(@ModelAttribute("Insr5100SrhVO") Insr5100SrhVO insr5100SrhVo,HttpServletRequest request ,ModelMap model) 
			throws Exception { 
		
		String method = calledClass + ".xlsInsr5100Export";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		List<String> listDeptCd = new ArrayList<String>(); 
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		String windowNm = "고용보험기본관리";
		String windowId = "INSR5100";
		
		try{
        	
			insr5100SrhVo.setUsrId(sessionUser.getUsrId());  
			insr5100SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
			insr5100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			insr5100SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getMangeDeptCd()));  
			insr5100SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getRepbtyBusinDivCd())); 
			 
			List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5100SrhVo.getHdofcCodtnCd())); 
			insr5100SrhVo.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태
			insr5100SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getEmymtDivCd()));	         //고용구분
			List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5100SrhVo.getTypOccuCd())); 
			insr5100SrhVo.setTypOccuCdArr(lstTypeOccuCd); //직종       
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5100SrhVo.getDtilOccuInttnCd())); 
			insr5100SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세
			insr5100SrhVo.setBusinCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getBusinCd()));   //사업
			insr5100SrhVo.setHanNm(MSFSharedUtils.allowNulls(insr5100SrhVo.getHanNm()));			//성명
			insr5100SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(insr5100SrhVo.getResnRegnNum()));//주민번호
			insr5100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(insr5100SrhVo.getSystemkey()));	//시스템키
			List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5100SrhVo.getSystemkey())); 
			insr5100SrhVo.setSystemKeyArr(systemKeyArr);
			/******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	insr5100SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           insr5100SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           insr5100SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	insr5100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getPayrMangDeptCd()));  
	        	insr5100SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getPayrMangDeptCd()));
	                 if (insr5100SrhVo.getPayrMangDeptCd().equals(insr5100SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	insr5100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	insr5100SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 insr5100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr5100SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5100SrhVo.getDeptCd()));  
	                      insr5100SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        insr5100SrhVo.setDeptCdAuth(insr5100SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        insr5100SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr5100SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	        
	       /******************************** 권한 ************************************************************************/
			List listInsr5100 = insr5100ExcelService.selectXlsInsr5100List(insr5100SrhVo);
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listInsr5100.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listInsr5100.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}

//			Map<String, Object> map = new HashMap<String, Object>(); 
			map = new HashMap<String, Object>(); 
			map.put("listInsr5100", excelList);
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
		//	//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        }

		return new ModelAndView("insr5100ExcelView", map);

	}

	/**
	 * 엑셀파일을 업로드한다.
	 * @param MultipartFile, Model, HttpServletRequest
	 * @return sResult
	 * @throws InvalidFormatException, IOException, SAXException
	 */
	@RequestMapping(value = "/imp/XlsInsr5100Import.do", method = RequestMethod.POST)
	public String handleFormUpload(  @RequestParam("insr5100flUp") MultipartFile file
			, Model model
			, final HttpServletRequest request, final HttpServletResponse response
			) throws InvalidFormatException, IOException, SAXException {
		String realPath = request.getSession().getServletContext().getRealPath("");
		String xmlConfig = "/upXmlConfig/INSR/Insr5100Mapping.xml";
		
		String method = calledClass + ".handleFormUpload";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		String windowNm = "고용보험기본관리";
		String windowId = "INSR5100";
		
		if  (insr5100ExcelService == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			insr5100ExcelService = (Insr5100ExcelService) wac.getBean("Insr5100ExcelService" ); 
		}

		String sResult = "";			//결과 상태값
		InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
		//	FileInputStream inputfis = null;

		List<Insr5100VO> insr5100List = new ArrayList<Insr5100VO>();
		Map<String, List> beans = new HashMap<String, List>();

		beans.put("insr5100List", insr5100List);

		try {
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());

			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);

			if(xlsReadStatus.isStatusOK()) {
				
				long result ;
				
				if( insr5100List == null || insr5100List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					long excelCount = insr5100List.size();
					
					//엑셀 업로드 서비스 호출(delete 후에 insert함)
					result = insr5100ExcelService.updateXlsInsr5100(insr5100List, request);		
					
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
}
