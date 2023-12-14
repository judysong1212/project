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
import org.msf.exterms.xls.service.Insr3150ExcelService;
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

import com.app.exterms.insurance.server.vo.Insr3150SrhVO;
import com.app.exterms.insurance.server.vo.Insr4200ExcelVO;
import com.app.exterms.insurance.server.vo.Insr4200SrhVO;
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
public class Insr3150ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Insr3150ExcelController.class);  
    private static final String calledClass = Insr3150ExcelController.class.getName();
 
    @Resource(name = "Insr3150ExcelService")
    private Insr3150ExcelService insr3150ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 양식 다운 _엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsInsr3150TempExport.do")   
    public ModelAndView xlsInsr3300TempExport(@ModelAttribute("Insr4200SrhVO") Insr4200SrhVO insr4200SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String strUpDivCd = MSFSharedUtils.allowNulls(insr4200SrhVo.getUploadDivCd());
    	
    	String rtnViewName = "";
        
        Map<String, Object> map = new HashMap<String, Object>(); 

        System.out.println("strUpDivCd================"+strUpDivCd);
        
        if("I0300002".equals(strUpDivCd)){  //세부업로드
        	
        	rtnViewName = "insr3150TempExcelView";
        }else{  // 간단업로드 
        	
        	rtnViewName = "insr3150_1TempExcelView";
        }
         
        return new ModelAndView(rtnViewName, map);
    }
    
    
    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsInsr3150Export.do")   
    public ModelAndView xlsInsr3150Export(@ModelAttribute("Insr4200SrhVO") Insr4200SrhVO insr4200SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsInsr3150Export";
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        
        List<String> listDeptCd = new ArrayList<String>(); 
        Map<String, Object> map = new HashMap<String, Object>(); 
        
    	String windowNm = "국민연금월별대사";
		String windowId = "INSR3150";
        
        try{
        
	        insr4200SrhVo.setUsrId(sessionUser.getUsrId());  
	        insr4200SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        insr4200SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        insr4200SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(insr4200SrhVo.getMangeDeptCd()));  //관리부서 
	        insr4200SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(insr4200SrhVo.getRepbtyBusinDivCd()));
	         
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4200SrhVo.getTypOccuCd())); 
	        insr4200SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	       
	        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4200SrhVo.getPyspGrdeCd())); 
	        insr4200SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4200SrhVo.getDtilOccuInttnCd())); 
	        insr4200SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	         
	        List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4200SrhVo.getHdofcCodtnCd())); 
	        insr4200SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);  
	         
	        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4200SrhVo.getSystemkey())); 
	        insr4200SrhVo.setSystemKeyArr(systemKeyArr);
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	insr4200SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           insr4200SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           insr4200SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        		insr4200SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr4200SrhVo.getPayrMangDeptCd()));    
	                 if (insr4200SrhVo.getPayrMangDeptCd().equals(insr4200SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	insr4200SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	insr4200SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 insr4200SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr4200SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr4200SrhVo.getDeptCd()));  
	                      insr4200SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	        }
	        
	        insr4200SrhVo.setDeptCdAuth(insr4200SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        insr4200SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr4200SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	      
	       /******************************** 권한 ************************************************************************/
	         
	        List listInsr4200 = insr3150ExcelService.selectXlsInsr4200List(insr4200SrhVo);
	        
	        
	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listInsr4200.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listInsr4200.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}

	        
//	        Map<String, Object> map = new HashMap<String, Object>(); 
	        map = new HashMap<String, Object>(); 
	        map.put("listInsr4200", excelList);
	        
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
        
        return new ModelAndView("insr3150ExcelView", map);
         
    }
    
    
    
    /**
	 * 엑셀파일을 업로드한다.
	 * @param MultipartFile, Model, HttpServletRequest
	 * @return sResult
	 * @throws InvalidFormatException, IOException, SAXException
	 */
	@RequestMapping(value = "/imp/XlsReadInsr3150Import.do", method = RequestMethod.POST)
	public String handleFormUpload( @ModelAttribute("Insr3150SrhVO") Insr3150SrhVO insr3150SrhVo, @RequestParam("insr3150flUp") MultipartFile file
								   , Model model
								   , final HttpServletRequest request, final HttpServletResponse response
								  ) throws InvalidFormatException, IOException, SAXException {
		String realPath = request.getSession().getServletContext().getRealPath("");
		String xmlConfig = "/upXmlConfig/INSR/Insr3150Mapping.xml";
		
		String method = calledClass + ".handleFormUpload";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		String windowNm = "국민연금월별대사";
		String windowId = "INSR3150";
		
		String sResult = "";			//결과 상태값
		InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
	//	FileInputStream inputfis = null;
		PrintWriter out ;
		
		List<Insr4200ExcelVO> insr4200List = new ArrayList<Insr4200ExcelVO>();
		Map<String, List> beans = new HashMap<String, List>();
		
		String srhDeductYr = insr3150SrhVo.getSrhDeductYr();
		
		String srhDeductMnth = insr3150SrhVo.getSrhDeductMnth();
		System.out.println("srhDeductYr================"+ srhDeductYr);
		System.out.println("srhDeductMnth==============="+ srhDeductMnth );
		
		beans.put("insr4200List", insr4200List);
		
		try {
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {
				
				for(int i = 0 ; i<  insr4200List.size()  ; i++){
					
					if("".equals(MSFSharedUtils.defaultNulls(insr4200List.get(i).getDducYrMnth(),"")) ){
						insr4200List.get(i).setDducYrMnth(srhDeductYr+srhDeductMnth);	
					}
				}
				
//				System.out.println("insr4200List.toString()================"+ insr4200List.toString());
				//엑셀 업로드 서비스 호출(delete 후에 insert함)
				
				if( insr4200List == null || insr4200List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					long excelCount = insr4200List.size();
					long result ;
					
					result = insr3150ExcelService.updateXlsInsr3150(insr4200List, request);
					sResult = "success";
					
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
				
			} else {
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
			
		} catch(Exception e){
			
			PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
			e.printStackTrace();
			
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:U:D",e, windowNm , windowId);
			
	    }finally {
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
	@RequestMapping(value = "/imp/XlsReadInsr3150_1Import.do", method = RequestMethod.POST)
	public String handleFormUploadSimple( @ModelAttribute("Insr3150SrhVO") Insr3150SrhVO insr3150SrhVo, @RequestParam("insr3150flUp") MultipartFile file
								   , Model model
								   , final HttpServletRequest request, final HttpServletResponse response
								  ) throws InvalidFormatException, IOException, SAXException {
		String realPath = request.getSession().getServletContext().getRealPath("");
		String xmlConfig = "/upXmlConfig/INSR/Insr3150_1Mapping.xml";
		
		String method = calledClass + ".handleFormUploadSimple";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		String windowNm = "국민연금월별대사";
		String windowId = "INSR3150";
		
		String sResult = "";			//결과 상태값
		InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
	//	FileInputStream inputfis = null;
		PrintWriter out ;
		
		List<Insr4200ExcelVO> insr4200List = new ArrayList<Insr4200ExcelVO>();
		Map<String, List> beans = new HashMap<String, List>();
		
		String srhDeductYr = insr3150SrhVo.getSrhDeductYr();
		
		String srhDeductMnth = insr3150SrhVo.getSrhDeductMnth();
		System.out.println("srhDeductYr================"+ srhDeductYr);
		System.out.println("srhDeductMnth==============="+ srhDeductMnth );
		
		beans.put("insr4200List", insr4200List);
		
		try {
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {
				
				for(int i = 0 ; i<  insr4200List.size()  ; i++){
					
					if("".equals(MSFSharedUtils.defaultNulls(insr4200List.get(i).getDducYrMnth(),"")) ){
						insr4200List.get(i).setDducYrMnth(srhDeductYr+srhDeductMnth);	
					}
					
				}
				
				if( insr4200List == null || insr4200List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					long excelCount = insr4200List.size();
					long result ;
					
					result = insr3150ExcelService.updateXlsInsr3150(insr4200List, request);
					sResult = "success";
					
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
				
			} else {
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
			
		} catch(Exception e){
			
			PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
			e.printStackTrace();
			
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:U:D",e, windowNm , windowId);
			
	    }finally {
			IOUtils.closeQuietly(inputXML);
			IOUtils.closeQuietly(inputXLS);
		}
		
		return sResult;
	}
	
	
}
