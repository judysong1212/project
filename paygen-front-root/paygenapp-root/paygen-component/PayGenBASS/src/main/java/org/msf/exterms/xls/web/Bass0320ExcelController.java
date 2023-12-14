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
import org.msf.exterms.xls.service.Bass0320ExcelService;
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

import com.app.exterms.basis.server.vo.Bass0320SrhVO;
import com.app.exterms.basis.server.vo.Bass0320VO;
import com.app.exterms.prgm.server.utils.PrgmComUtils;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;

import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

@Controller
public class Bass0320ExcelController {
	private static final Logger logger = LoggerFactory.getLogger(Bass0320ExcelController.class);  
    private static final String calledClass = Bass0320ExcelController.class.getName();
    
    @Resource(name = "bass0320ExcelService")
    private Bass0320ExcelService bass0320ExcelService;
    
    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsFileBass0320Export.do")
    public ModelAndView xlsFileBass0320Export(@ModelAttribute("Bass0320SrhVO") Bass0320SrhVO bass0320SrhVo, HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsFileBass0320Export";
    	
    	String windowNm = "직종관리";
		String windowId = "BASS0320";
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        Map<String, Object> map = new HashMap<String, Object>();
        
        try{
//        	bass0320SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//        	bass0320SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//        	bass0320SrhVo.setUsrId(sessionUser.getUsrId());
//        	bass0320SrhVo.setTypOccuCd(bass0320SrhVo.getTypOccuCd()); //직종코드
//        	bass0320SrhVo.setTypOccuNm(bass0320SrhVo.getTypOccuNm()); //직종명  
//        	bass0320SrhVo.setTypOccuUseYn(bass0320SrhVo.getTypOccuUseYn());	//사용여부
//        	bass0320SrhVo.setTypOccuCtnt(bass0320SrhVo.getTypOccuCtnt());		//내용
//        	bass0320SrhVo.setTypOccuOrd(bass0320SrhVo.getTypOccuOrd());	//순서
//        	bass0320SrhVo.setChngTypOccuCd(bass0320SrhVo.getChngTypOccuCd());	//이전직종코드
//        	bass0320SrhVo.setTypOccuStdt(bass0320SrhVo.getTypOccuStdt());	//시작일자
//        	bass0320SrhVo.setTypOccuEddt(bass0320SrhVo.getTypOccuEddt());	//종료일자
//	         
//        	List listBass0320 = bass0320ExcelService.selectXlsFileBass0320List(bass0320SrhVo);
//	         
//        	String strValue = "";
//        	List<EgovMap> excelList = new ArrayList<EgovMap>();
//        	
//        	for(int i=0; i<listBass0320.size(); i++){
//        		EgovMap eMap  = new EgovMap();
//        		Iterator<String> keys = eMap.keySet().iterator();
//        		eMap = (EgovMap) listBass0320.get(i);	    	
//			    		
//        		excelList.add(eMap);
//        	}
//        	
//        	map = new HashMap<String, Object>();
//        	map.put("listBass0320", excelList);
	             
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
    	
    	return new ModelAndView("bass0320ExcelView", map);
    }
    
    /**
     * 엑셀파일을 업로드한다.
     * @param MultipartFile, Model, HttpServletRequest
     * @return sResult
     * @throws InvalidFormatException, IOException, SAXException
     */
    @RequestMapping(value = "/imp/XlsReadBass0320Import.do", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("bass0320flUp") MultipartFile file,
			Model model, HttpServletRequest request, HttpServletResponse response) throws InvalidFormatException, IOException, SAXException {
    	
    	String windowNm = "직종관리";
		String windowId = "BASS0320";
    	String realPath = request.getSession().getServletContext().getRealPath(""); 
    	String xmlConfig = "/upXmlConfig/BASS/Bass0320Mapping.xml";
    	
    	String method = calledClass + ".handleFormUpload";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	
//    	Long lResult = new Long(0);		//리턴 결과 
    	String sResult = "";			//결과 상태값
    	InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
//		FileInputStream inputfis = null;
		
		List<Bass0320VO> bass0320List = new ArrayList<Bass0320VO>();
		Map<String, List> beans = new HashMap<String, List>();
		
	    beans.put("bass0320List", bass0320List);
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
				
				if( bass0320List == null || bass0320List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					//엑셀 업로드 서비스 호출(delete 후에 insert함)
					long excelCount = bass0320List.size();	
					
					result = bass0320ExcelService.updateXlsBass0320(bass0320List, request);
					
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
