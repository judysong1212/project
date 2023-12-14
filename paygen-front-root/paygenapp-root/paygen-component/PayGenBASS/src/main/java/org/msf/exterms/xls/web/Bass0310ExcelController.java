package org.msf.exterms.xls.web;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.msf.exterms.xls.service.Bass0310ExcelService;
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

import com.app.exterms.basis.server.vo.Bass0350SrhVO;
import com.app.exterms.basis.server.vo.Psnl2100SrhVO;
import com.app.exterms.basis.server.vo.Psnl2100VO;
import com.app.exterms.prgm.server.utils.PrgmComUtils;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

@Controller
public class Bass0310ExcelController {
	private static final Logger logger = LoggerFactory.getLogger(Bass0310ExcelController.class);  
    private static final String calledClass = Bass0310ExcelController.class.getName();
    
    @Resource(name = "bass0310ExcelService")
    private Bass0310ExcelService bass0310ExcelService;
    
    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsFileBass0310Export.do")
    public ModelAndView xlsFileBass0310Export(@ModelAttribute("Psnl2100SrhVO") Psnl2100SrhVO psnl2100SrhVo, HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsFileBass0310Export";
    	
    	String windowNm = "휴가일수관리";
		String windowId = "BASS0310";
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        Map<String, Object> map = new HashMap<String, Object>();
        
        //직종세 코드 엑셀에 출력
        Bass0350SrhVO bass0350SrhVo = new Bass0350SrhVO();
        
        try{
        	bass0350SrhVo.setDpobCd(sessionUser.getDpobCd());
        	
        	List listBass0310 = bass0310ExcelService.selectXlsFileBass0310List(bass0350SrhVo);
	         
        	String strValue = "";
        	List<EgovMap> excelList = new ArrayList<EgovMap>();
        	
        	for(int i=0; i<listBass0310.size(); i++){
        		EgovMap eMap  = new EgovMap();
        		Iterator<String> keys = eMap.keySet().iterator();
        		eMap = (EgovMap) listBass0310.get(i);	    	
			    		
        		excelList.add(eMap);
        	}
        	
        	map = new HashMap<String, Object>();
        	map.put("listBass0310", excelList);
	             
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
    	
    	return new ModelAndView("bass0310ExcelView", map);
    }
    
    /**
     * 엑셀파일을 업로드한다.
     * @param MultipartFile, Model, HttpServletRequest
     * @return sResult
     * @throws InvalidFormatException, IOException, SAXException
     */
    @RequestMapping(value = "/imp/XlsReadBass0310Import.do", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("bass0310flUp") MultipartFile file,
			Model model, HttpServletRequest request, HttpServletResponse response) throws InvalidFormatException, IOException, SAXException {
    	
    	String windowNm = "직종관리";
		String windowId = "BASS0310";
    	String realPath = request.getSession().getServletContext().getRealPath(""); 
    	String xmlConfig = "/upXmlConfig/BASS/Bass0310Mapping.xml";
    	
    	String method = calledClass + ".handleFormUpload";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	
//    	Long lResult = new Long(0);		//리턴 결과 
    	String sResult = "";			//결과 상태값
    	InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
//		FileInputStream inputfis = null;
		
		List<Psnl2100VO> psnl2100List = new ArrayList<Psnl2100VO>();
		Map<String, List> beans = new HashMap<String, List>();
		
	    beans.put("psnl2100List", psnl2100List);
//	    System.out.println("xml 어디 " + upXmlConfig);
		
		try {
			
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
//			System.out.println("xml경로 " + realPath.concat("/WEB-INF" + xmlConfig));
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {
				//엑셀 업로드 서비스 호출
				long result ;
				
				if( psnl2100List == null || psnl2100List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					//엑셀 업로드 서비스 호출(delete 후에 insert함)
					long excelCount = psnl2100List.size();	
					
					result = bass0310ExcelService.updateXlsBass0310(psnl2100List, request);
					
					if(result==0L){
						//엑셀 업로드 서비스 호출(delete 후에 insert함)
						sResult = "error";
						
						PrgmComUtils.responseAlert(response, "올바른 엑셀 양식인지 또는 엑셀 업로드 정보가 올바른지 확인해주세요.\n(ex: 같은 날짜 입력)" );
			
					}else if(result > 0L){
						sResult = "success";
						
			            if(result == excelCount){
			            	PrgmComUtils.responseAlert(response, "업로드가 완료되었습니다." );
			            }else{
			            	PrgmComUtils.responseAlert(response, "엑셀업로드 "+ excelCount+"중에  총"+ result +"건 입력되었습니다. 엑셀데이타를 확인해주세요." );
			            }
					}
				}	
				
			}else {
				sResult =  "error";
			}
			
			
		}catch(Exception e) {
			PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:U:D",e, windowNm , windowId);
			
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
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:U:D");

		return sResult;
		
	}
    
}
