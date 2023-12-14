package org.msf.exterms.yeta2015.xls.web;

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

import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.yeta2015.xls.service.Yeta0900ExcelService;
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

import com.app.exterms.yearendtax.server.vo.Yeta3900SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3900VO;
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
public class Yeta0900ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Yeta0900ExcelController.class);  
    private static final String calledClass = Yeta0900ExcelController.class.getName();
 
    
    @Resource(name = "yeta0900ExcelService")
    private Yeta0900ExcelService yeta0900ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    

    /**
     * 엑셀파일로 출력한다. (양식)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsYeta0900Export.do")
    public ModelAndView xlsYeta3900Export(@ModelAttribute("Yeta3900SrhVO") Yeta3900SrhVO yeta3900SrhVO, HttpServletRequest request ,ModelMap model) 
                    throws Exception {        
    	
    	
    	String windowNm = "연말정산급여파일업로드";
		String windowId = "YETA0900";
		
    	String method = calledClass + ".xlsYeta3900Export";
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	
		try{
        	
	    	List  listFileYeta3900 = yeta0900ExcelService.selectXlsFileYeta3900List(yeta3900SrhVO);
	    	
			List<EgovMap> excelList = new ArrayList<EgovMap>();

	    	for(int i=0; i<listFileYeta3900.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listFileYeta3900.get(i);
	    		// TODO 주민번호
	    		String strValue = AnyCryptUtils.getDecSyncCrypt(nResult, MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
	    		excelList.add(eMap);
	    	}
	        
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listFileYeta3900", excelList);
	        
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
        
        return new ModelAndView("yeta0900ExcelView", map);
         
    }
    
    
    
    /**
     * 엑셀파일을 업로드한다.
     * @param MultipartFile, Model, HttpServletRequest
     * @return sResult
     * @throws InvalidFormatException, IOException, SAXException
     */
    @RequestMapping(value = "/imp/XlsReadYeta0900Import.do", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("yeta0900flUp") MultipartFile file,
			Model model, final HttpServletRequest request) throws InvalidFormatException, IOException, SAXException {
    	
    	String method = calledClass + ".handleFormUpload";
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    	
    	String windowNm = "연말정산급여파일업로드";
		String windowId = "YETA0900";

    	
    	String realPath = request.getSession().getServletContext().getRealPath(""); 
    	String xmlConfig = "/upXmlConfig/YETA/Yeta0900Mapping.xml";
    	
    	String sResult = "";			//결과 상태값
    	InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
		
		List<Yeta3900VO> yeta3900List = new ArrayList<Yeta3900VO>();
		Map<String, List> beans = new HashMap<String, List>();
		
	    beans.put("yeta3900List", yeta3900List);
		
		try {
			
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
//			System.out.println("xml경로 " + realPath.concat("/WEB-INF" + xmlConfig));
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {
				//엑셀 업로드 서비스 호출
				yeta0900ExcelService.updateXlsYeta3900(yeta3900List, request);
				sResult =  "success";
			}else {
				sResult =  "error";
			}
		}catch(Exception e) {
			
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:D:B",e, windowNm , windowId);
		
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
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:D:B");
		
		return sResult;
		
	}    
}