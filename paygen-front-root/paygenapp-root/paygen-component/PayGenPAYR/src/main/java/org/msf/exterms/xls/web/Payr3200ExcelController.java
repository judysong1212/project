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
import org.msf.exterms.xls.service.Payr3200ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.app.exterms.payroll.server.vo.Payr0520VO;
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
public class Payr3200ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Payr3200ExcelController.class);  
    private static final String calledClass = Payr3200ExcelController.class.getName();

 
    
    @Resource(name = "payr3200ExcelService")
    private Payr3200ExcelService payr3200ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

      
    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPayr3200TempExport.do")
    public ModelAndView xlsPayr3200TotExport(@RequestParam HashMap<String, String> param, HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsPayr3200TotExport";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        Map<String, Object> map = new HashMap<String, Object>();
        Payr0520VO payr0520Vo = new Payr0520VO();
        
    	String windowNm = "개별공제관리";
		String windowId = "PAYR3200";
		
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(), request);

        
		try{
			
	        /** 조건절 */
			payr0520Vo = new Payr0520VO();
	        payr0520Vo.setDpobCd(sessionUser.getDpobCd());  									// 사업장코드
	        payr0520Vo.setPayYr(MSFSharedUtils.allowNulls(param.get("payYr")));					// 수당공제년도
	        payr0520Vo.setPymtDducDivCd(MSFSharedUtils.allowNulls(param.get("pymtDducDivCd")));	// 지급공제구분코드
	        payr0520Vo.setPayDducCd(MSFSharedUtils.allowNulls(param.get("payItemCd")));			// 수당공제항목코드
	        
	        
	        List listPayr3200 = payr3200ExcelService.selectXlsPayr0520List(payr0520Vo);
	        
			String strValue = "";
			
	        List<EgovMap> excelList = new ArrayList<EgovMap>();

	    	for(int i=0; i<listPayr3200.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPayr3200.get(i);
	    		
	    		// TODO 주민번호
	    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
	    		excelList.add(eMap);
	    	}
	        
	        map = new HashMap<String, Object>();
	        map.put("listPayr3200", excelList);  
	        
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
       
        return new ModelAndView("payr3200ExcelView", map);
         
    }
    
    /**
     * 엑셀파일을 업로드한다.(Jxls)
     * @param MultipartFile, Model, HttpServletRequest
     * @return sResult
     * @throws InvalidFormatException, IOException, SAXException
     */
    @RequestMapping(value = "/imp/XlsReadPayr3200Import.do", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("payr3200flUp") MultipartFile file,
			Model model, final HttpServletRequest request, final HttpServletResponse response) throws InvalidFormatException, IOException, SAXException {
    	
    	String realPath = request.getSession().getServletContext().getRealPath(""); 
    	String xmlConfig = "/upXmlConfig/PAYR/Payr3200Mapping.xml";
    	
    	String windowNm = "개별공제관리";
		String windowId = "PAYR3200";
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	String method = calledClass + ".handleFormUpload";
    	
    	
    	String sResult = "";			//결과 상태값
    	InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
//		FileInputStream inputfis = null;
		
		List<Payr0520VO> payr0520List = new ArrayList<Payr0520VO>();
		Map<String, List> beans = new HashMap<String, List>();
		
	    beans.put("payr0520List", payr0520List);
//	    System.out.println("xml 어디 " + upXmlConfig);
		
		try {
			
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {
				

				long result ;
				
				
				if( payr0520List == null || payr0520List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					
					long excelCount = payr0520List.size();
					
					//엑셀 업로드 서비스 호출(delete 후에 insert함)
					result = payr3200ExcelService.insertXlsPayr3200ToPayr0520(payr0520List, request);	
					
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
				
//				// 엑셀 업로드 서비스 호출
//				// 배치 처리
//				payr3200ExcelService.insertXlsPayr3200ToPayr0520(payr0520List, request);
//				sResult =  "success";
				
				
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
