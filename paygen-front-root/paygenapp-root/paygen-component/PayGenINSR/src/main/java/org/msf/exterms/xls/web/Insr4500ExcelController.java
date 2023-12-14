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
import org.msf.exterms.xls.service.Insr4500ExcelService;
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

import com.app.exterms.insurance.server.vo.Insr3100SrhVO;
import com.app.exterms.insurance.server.vo.Insr3100VO;
import com.app.exterms.prgm.server.utils.PrgmComUtils;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

@Controller
public class Insr4500ExcelController {
	private static final Logger logger = LoggerFactory.getLogger(Insr4500ExcelController.class);
    private static final String calledClass = Insr4500ExcelController.class.getName();
	@Resource(name = "insr4500ExcelService")
	private Insr4500ExcelService insr4500ExcelService;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/**
	 * 엑셀파일로 출력한다.
	 * @param searchVO 검색조건
	 * @return 엑셀파일
	 * @throws Exception
	 */
	@RequestMapping(value = "/exp/XlsFileInsr4500Export.do")
	public ModelAndView xlsInsr3100Export(	@ModelAttribute("Insr3100SrhVO") Insr3100SrhVO insr3100SrhVo
										  , HttpServletRequest request
										  , ModelMap model
										 ) throws Exception {
		

		String method = calledClass + ".xlsInsr3100Export";
		
		String windowNm = "연말정산산출내역반영";
		String windowId = "INSR4500";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		List<String> listDeptCd = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
		
			insr3100SrhVo.setUsrId(sessionUser.getUsrId());
			insr3100SrhVo.setDpobCd(sessionUser.getDpobCd());	/* 사업장코드 */
			insr3100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());	/* 단위기관담당자여부 */
			insr3100SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(insr3100SrhVo.getMangeDeptCd()));  
			insr3100SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(insr3100SrhVo.getRepbtyBusinDivCd())); 
			 
			List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3100SrhVo.getTypOccuCd()));
			insr3100SrhVo.setTypOccuCdArr(lstTypeOccuCd);
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3100SrhVo.getDtilOccuInttnCd()));
			insr3100SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);
			
			List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3100SrhVo.getHdofcCodtnCd()));
			insr3100SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);
			
			/******************************** 권한 ************************************************************************/
			String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
			if("FALSE".equals(chkDeptCd)) {
				insr3100SrhVo.setDeptCd(sessionUser.getDeptCd());
				listDeptCd.add(sessionUser.getDeptCd());
				insr3100SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
				insr3100SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
			} else {
				insr3100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr3100SrhVo.getPayrMangDeptCd()));
				if(insr3100SrhVo.getPayrMangDeptCd().equals(insr3100SrhVo.getDeptCd())) {
					listDeptCd = null;
					insr3100SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
					insr3100SrhVo.setDeptCd("");	/* 부서코드 */
				} else {
					insr3100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr3100SrhVo.getDeptCd()));
					listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3100SrhVo.getDeptCd()));
					insr3100SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
				}
			}
			
			insr3100SrhVo.setDeptCdAuth(insr3100SrhVo.getDeptCd().replace(",", ""));	/* 권한처리를위해 추가 */
			insr3100SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr3100SrhVo.getDtilOccuInttnCd()).replace(",", ""));
			
			/******************************** 권한 ************************************************************************/
			
			List listInsr3100 = insr4500ExcelService.selectXlsInsr3100List(insr3100SrhVo);
			
//			Map<String, Object> map = new HashMap<String, Object>();
			map = new HashMap<String, Object>();
			map.put("listInsr3100", listInsr3100);
			
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
		
		return new ModelAndView("insr4500ExcelView", map);
	}
	
	/**
	 * 엑셀파일을 업로드한다.
	 * @param MultipartFile, Model, HttpServletRequest
	 * @return sResult
	 * @throws InvalidFormatException, IOException, SAXException
	 */
	@RequestMapping(value = "/imp/XlsReadInsr4500Import.do", method = RequestMethod.POST)
	public String handleFormUpload(  @RequestParam("insr4500flUp") MultipartFile file
								   , Model model
								   , final HttpServletRequest request, final HttpServletResponse response
								  ) throws InvalidFormatException, IOException, SAXException {
		String realPath = request.getSession().getServletContext().getRealPath("");
		String xmlConfig = "/upXmlConfig/INSR/Insr4500Mapping.xml";
		
		String windowNm = "연말정산산출내역반영";
		String windowId = "INSR4500";
		
		String method = calledClass + ".handleFormUpload";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		String sResult = "";			//결과 상태값
		InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
	//	FileInputStream inputfis = null;
		
		List<Insr3100VO> insr3100List = new ArrayList<Insr3100VO>();
		Map<String, List> beans = new HashMap<String, List>();
		
		beans.put("insr3100List", insr3100List);
		
		try {
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {
				
				long result ;
				
				if( insr3100List == null || insr3100List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					
					long excelCount = insr3100List.size();
					
					//엑셀 업로드 서비스 호출(delete 후에 insert함)
					result = insr4500ExcelService.updateXlsInsr4500(insr3100List, request);
					
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

				sResult = "success";					
					
//					//엑셀 업로드 서비스 호출(delete 후에 insert함)
//					insr4500ExcelService.updateXlsInsr4500(insr3100List, request);
//					sResult = "success";
				}
			} else {
				PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
				sResult = "error";
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
		

		
		return sResult;
	}
	
	/**
	 * 엑셀파일로 출력한다.
	 * @param searchVO 검색조건
	 * @return 엑셀파일
	 * @throws Exception
	 */
	@RequestMapping(value = "/exp/XlsInsr4500Export.do")
	public ModelAndView xlsInsr4500Export(  @ModelAttribute("Insr3100SrhVO") Insr3100SrhVO insr3100SrhVo
										  , HttpServletRequest request
										  , ModelMap model
										 ) throws Exception {
		
		String method = calledClass + ".xlsInsr4500Export";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		Map<String, Object> map = new HashMap<String, Object>(); 
		
		String windowNm = "연말정산산출내역반영";
		String windowId = "INSR4500";
		
		try{
		
			List<String> listDeptCd = new ArrayList<String>();
			insr3100SrhVo.setUsrId(sessionUser.getUsrId());
			insr3100SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
			insr3100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부
			List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3100SrhVo.getTypOccuCd()));
			insr3100SrhVo.setTypOccuCdArr(lstTypeOccuCd);
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3100SrhVo.getDtilOccuInttnCd()));
			insr3100SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);
			List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3100SrhVo.getHdofcCodtnCd()));
			insr3100SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);
			
			/******************************** 권한 ************************************************************************/
			String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
			if("FALSE".equals(chkDeptCd)) {
				insr3100SrhVo.setDeptCd(sessionUser.getDeptCd());
				listDeptCd.add(sessionUser.getDeptCd());
				insr3100SrhVo.setDeptCdArr(listDeptCd);     //부서코드
				insr3100SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
			} else {
				insr3100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr3100SrhVo.getPayrMangDeptCd()));
				if(insr3100SrhVo.getPayrMangDeptCd().equals(insr3100SrhVo.getDeptCd())) {
					listDeptCd = null;
					insr3100SrhVo.setDeptCdArr(listDeptCd);     //부서코드
					insr3100SrhVo.setDeptCd("");  //부서코드
				} else {
					insr3100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr3100SrhVo.getDeptCd()));
					listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3100SrhVo.getDeptCd()));
					insr3100SrhVo.setDeptCdArr(listDeptCd);     //부서코드
				}
			}
		    
			insr3100SrhVo.setDeptCdAuth(insr3100SrhVo.getDeptCd().replace("," ,""));  //권한처리를위해 추가
			insr3100SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr3100SrhVo.getDtilOccuInttnCd()).replace("," ,""));
			
			/******************************** 권한 ************************************************************************/
		    
			List<Insr3100SrhVO> listInsr4500 = new ArrayList<Insr3100SrhVO>();
			
//			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//			List<EgovMap> excelList = new ArrayList<EgovMap>();
//
//			for(int i=0; i<insrP210002Excel.size(); i++){
//				EgovMap eMap  = new EgovMap();
//				eMap = (EgovMap) insrP210002Excel.get(i);
//				// TODO 주민번호
//				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//				eMap.put("resnRegnNum", strValue);
//				excelList.add(eMap);
//			}

			
			
//			Map<String, Object> map = new HashMap<String, Object>(); 
			map = new HashMap<String, Object>(); 
			map.put("listInsr4500", listInsr4500);
			
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
	    
	    return new ModelAndView("insr4500ExcelView", map);
	}
}