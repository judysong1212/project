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
import org.msf.exterms.xls.service.Payr1100ExcelService;
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

import com.app.exterms.payroll.client.dto.Payr0100DTO_XLS;
import com.app.exterms.payroll.server.vo.Payr0100SrhVO;
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
public class Payr1100ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Payr1100ExcelController.class);  
    private static final String calledClass = Payr1100ExcelController.class.getName();
 
    
    @Resource(name = "payr1100ExcelService")
    private Payr1100ExcelService payr1100ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    
    /**
     * 엑셀파일로 출력한다. (양식)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPayr0100Export.do")
    public ModelAndView xlsPayr0100Export(@ModelAttribute("Payr0100SrhVO") Payr0100SrhVO payr0100SrhVO, HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsPayr0100Export";
    	
    	String windowNm = "간이소득세액관리";
		String windowId = "PAYR1100";
       
//        dlgn0250SrhVo.setTypOccucdIn("");
//        dlgn0250SrhVo.setPyspGrdeCdIn("");
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        Map<String, Object> map = new HashMap<String, Object>();
        

    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
		try{
        
	        payr0100SrhVO.setDpobCd(sessionUser.getDpobCd());
	        
	        List  listFilePayr1100 = payr1100ExcelService.selectXlsFilePayr0100List(payr0100SrhVO);
	        
	        String strValue = "";
	        
	        List<EgovMap> excelList = new ArrayList<EgovMap>();

	    	for(int i=0; i<listFilePayr1100.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listFilePayr1100.get(i);
	    		
	    			
	    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
		    		
	    			
	    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("payFamyResnRegnNum", strValue);
	    			
	    		excelList.add(eMap);
	    	}
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listFilePayr1100", excelList);
	        
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
        
        return new ModelAndView("payr1100ExcelView", map);
         
    }
    
    
    
    /**
     * 엑셀파일을 업로드한다.
     * @param MultipartFile, Model, HttpServletRequest
     * @return sResult
     * @throws InvalidFormatException, IOException, SAXException
     */
    @RequestMapping(value = "/imp/XlsReadPayr0100Import.do", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("payr0100flUp") MultipartFile file,
			Model model, final HttpServletRequest request, final HttpServletResponse response, @RequestParam HashMap<String, String> param) throws InvalidFormatException, IOException, SAXException {
    	
    	String realPath = request.getSession().getServletContext().getRealPath(""); 
    	String xmlConfig = "/upXmlConfig/PAYR/Payr1100Mapping.xml";
    	
    	
    	String windowNm = "간이소득세액관리";
		String windowId = "PAYR1100";
		
    	String method = calledClass + ".handleFormUpload";
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	
    	Long lResult = new Long(0);		//리턴 결과 
    	String sResult = "";			//결과 상태값
    	InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
//		FileInputStream inputfis = null;
		
		List<Payr0100DTO_XLS> payr0100List = new ArrayList<Payr0100DTO_XLS>();
		Map<String, List> beans = new HashMap<String, List>();
		
	    beans.put("payr0100List", payr0100List);
//	    System.out.println("xml 어디 " + upXmlConfig);
	    
//	    HttpSession session = null;
//	    session.setAttribute("apptnYr", param.get("createApptnYr"));
//	    session.setAttribute("apptnStdBgnnDt", param.get("createApptnStdBgnnDt"));
		
		try {
			
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
//			System.out.println("xml경로 " + realPath.concat("/WEB-INF" + xmlConfig));
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {
				
				long result ;
				
				
				if( payr0100List == null || payr0100List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					
					long excelCount = payr0100List.size();
					
					//엑셀 업로드 서비스 호출(delete 후에 insert함)
					result = payr1100ExcelService.insertXlsPayr0100(payr0100List, request, param);
					
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
				
				
				
//				//엑셀 업로드 서비스 호출
//				lResult = payr1100ExcelService.insertXlsPayr0100(payr0100List, request, param);
//				
//				if(lResult == 1) {
//					sResult =  "success";
//				}else {
//					sResult =  "error";
//				}
			}else {
				sResult =  "error";
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C:D:B");
			
		}catch(Exception e) {
			
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:C:D:B",e, windowNm , windowId);
			
		}finally {
			IOUtils.closeQuietly(inputXML);
			IOUtils.closeQuietly(inputXLS);
 		}
		
		return sResult;
	}
}
