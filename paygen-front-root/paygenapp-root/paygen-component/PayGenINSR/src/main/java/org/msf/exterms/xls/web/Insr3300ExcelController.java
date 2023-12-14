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
import org.msf.exterms.xls.service.Insr3300ExcelService;
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

import com.app.exterms.insurance.server.vo.Insr4300SrhVO;
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
public class Insr3300ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Insr3300ExcelController.class);  
    private static final String calledClass = Insr3300ExcelController.class.getName();	
 
    @Resource(name = "Insr3300ExcelService")
    private Insr3300ExcelService insr3300ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 양식 다운 _엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsInsr3300TempExport.do")   
    public ModelAndView xlsInsr3300TempExport(HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
        
        Map<String, Object> map = new HashMap<String, Object>(); 

        return new ModelAndView("insr3300TempExcelView", map);
         
    }
    
    
    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsInsr3300Export.do")   
    public ModelAndView xlsInsr3300Export(@ModelAttribute("Insr4300SrhVO") Insr4300SrhVO insr4300SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsInsr3300Export"; 
       
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
       
        Map<String, Object> map = new HashMap<String, Object>(); 
        
    	String windowNm = "국민연금결정내역반영";
		String windowId = "INSR3300";
        
        try{
        
	        insr4300SrhVo.setUsrId(sessionUser.getUsrId());  
	        insr4300SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        insr4300SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        insr4300SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(insr4300SrhVo.getMangeDeptCd())); //단위기관담당자여부
	        insr4300SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(insr4300SrhVo.getRepbtyBusinDivCd()));
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4300SrhVo.getTypOccuCd())); 
	        insr4300SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	       
	        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4300SrhVo.getPyspGrdeCd())); 
	        insr4300SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4300SrhVo.getDtilOccuInttnCd())); 
	        insr4300SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	         
	        List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4300SrhVo.getHdofcCodtnCd())); 
	        insr4300SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);  
	         
	        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4300SrhVo.getSystemkey())); 
	        insr4300SrhVo.setSystemKeyArr(systemKeyArr);
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	insr4300SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           insr4300SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        		insr4300SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr4300SrhVo.getPayrMangDeptCd()));    
	                 if (insr4300SrhVo.getPayrMangDeptCd().equals(insr4300SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	insr4300SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 insr4300SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4300SrhVo.getDeptCd()));  
	                      insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	        }
	        
	        insr4300SrhVo.setDeptCdAuth(insr4300SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        insr4300SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr4300SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	      
	       /******************************** 권한 ************************************************************************/
	         
	        List listInsr4100 = insr3300ExcelService.selectXlsInsr4100List(insr4300SrhVo);
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
        
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        }
        
        return new ModelAndView("insr3100ExcelView", map);
         
    }
    
    
    
    /**
	 * 엑셀파일을 업로드한다.
	 * @param MultipartFile, Model, HttpServletRequest
	 * @return sResult
	 * @throws InvalidFormatException, IOException, SAXException
	 */
	@RequestMapping(value = "/imp/XlsReadInsr3300Import.do", method = RequestMethod.POST)
	public String handleFormUpload(  @RequestParam("insr3300flUp") MultipartFile file
								   , Model model
								   , final HttpServletRequest request, final HttpServletResponse response
								  ) throws InvalidFormatException, IOException, SAXException {
		String realPath = request.getSession().getServletContext().getRealPath("");
		String xmlConfig = "/upXmlConfig/INSR/Insr3300Mapping.xml";
		
		
		String windowNm = "국민연금결정내역반영";
		String windowId = "INSR3300";
		
    	String method = calledClass + ".handleFormUpload";
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		String sResult = "";			//결과 상태값
		InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
	//	FileInputStream inputfis = null;
		
		List<Insr4300VO> insr4300List = new ArrayList<Insr4300VO>();
		Map<String, List> beans = new HashMap<String, List>();
		
		beans.put("insr4300List", insr4300List);
		
		try {
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {
				if( insr4300List == null || insr4300List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
				
					//엑셀 업로드 서비스 호출(delete 후에 insert함)
					insr3300ExcelService.updateXlsInsr3300(insr4300List, request);
					sResult = "success";
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
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:D:C:U");
			
		} catch(Exception e){
			PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:D:C:U",e, windowNm , windowId);
			
		}finally {
			IOUtils.closeQuietly(inputXML);
			IOUtils.closeQuietly(inputXLS);
		}
		return sResult;
	}
    
}
