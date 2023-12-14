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
import org.msf.exterms.xls.service.Payr1700ExcelService;
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

import com.app.exterms.prgm.server.utils.PrgmComUtils;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0130SrhVO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0130VO;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

@Controller
public class Payr1700ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Payr1700ExcelController.class);  
    private static final String calledClass = Payr1700ExcelController.class.getName();
 
    
    @Resource(name = "payr1700ExcelService")
    private Payr1700ExcelService payr1700ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    
    /**
     * 엑셀파일로 출력한다. (양식)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPayr1700Export.do")
    public ModelAndView xlsPayr1700Export(@ModelAttribute("InfcPsnl0130SrhVO") InfcPkgPsnl0130SrhVO psnl0130SrhVO, HttpServletRequest request, ModelMap model) 
                    throws Exception {
       

    	String method = calledClass + ".xlsPayr1700Export";
    	
    	String windowNm = "급여계좌관리";
		String windowId = "PAYR1700";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<InfcPkgPsnl0130SrhVO> listFilePayr1700 = new ArrayList<InfcPkgPsnl0130SrhVO>();
        InfcPkgPsnl0130SrhVO infcPsnl0130SrhVo = new InfcPkgPsnl0130SrhVO();
        Map<String, Object> map = new HashMap<String, Object>();
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
		try{
        	
        psnl0130SrhVO.setDpobCd(sessionUser.getDpobCd());
        infcPsnl0130SrhVo.setDpobCd(sessionUser.getDpobCd());
        
        listFilePayr1700.add(infcPsnl0130SrhVo);
        
//        Map<String, Object> map = new HashMap<String, Object>();
        map = new HashMap<String, Object>();
        map.put("listFilePayr1700", listFilePayr1700);
        
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
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm, windowId);
        	
        }
		
        return new ModelAndView("payr1700ExcelView", map);
    }
    
    
    
    
    /**
     * 엑셀파일로 출력한다. 
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPayr170002Export.do")
    public ModelAndView xlsPayr170002Export(@ModelAttribute("InfcPsnl0130SrhVO") InfcPkgPsnl0130SrhVO psnl0130SrhVO, HttpServletRequest request, ModelMap model) 
                    throws Exception {
       

    	String method = calledClass + ".xlsPayr170002Export";
    	
    	String windowNm = "급여계좌관리";
		String windowId = "PAYR1700";
		
		
        List<String> listDeptCd = new ArrayList<String>();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<InfcPkgPsnl0130SrhVO> listFilePayr1700 = new ArrayList<InfcPkgPsnl0130SrhVO>();
        InfcPkgPsnl0130SrhVO infcPsnl0130SrhVo = new InfcPkgPsnl0130SrhVO();
        Map<String, Object> map = new HashMap<String, Object>();
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
		try{
        	
		    /** 조건절 */
			infcPsnl0130SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
			infcPsnl0130SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	       
			infcPsnl0130SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(psnl0130SrhVO.getEmymtDivCd()));       //고용구분코드
	        
	
			infcPsnl0130SrhVo.setUsrId(sessionUser.getUsrId());  
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	

	    	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(psnl0130SrhVO.getDeptCd(),sessionUser.getDeptCd()))) {

		        	infcPsnl0130SrhVo.setDeptCd(sessionUser.getDeptCd()); 
		           listDeptCd.add(sessionUser.getDeptCd());
		           infcPsnl0130SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	                    
	           	   } else {
	           		 infcPsnl0130SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0130SrhVO.getDeptCd()));
                     listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0130SrhVO.getDeptCd()));  
                     infcPsnl0130SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	           		 
	           	  }  
	    	    
	           infcPsnl0130SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	infcPsnl0130SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(psnl0130SrhVO.getPayrMangDeptCd())) ;   //단위기관코드
	                 if (infcPsnl0130SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(psnl0130SrhVO.getDeptCd()))) { 
	                 	 listDeptCd = null; 
	                 	infcPsnl0130SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	infcPsnl0130SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 infcPsnl0130SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0130SrhVO.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0130SrhVO.getDeptCd()));  
	                      infcPsnl0130SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        
	
	        infcPsnl0130SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(psnl0130SrhVO.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
	        infcPsnl0130SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(psnl0130SrhVO.getDtilOccuInttnCd()).replace(",", ""));      
	         
	       /******************************** 권한 ************************************************************************/
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0130SrhVO.getTypOccuCd())); 
	        infcPsnl0130SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	        infcPsnl0130SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(psnl0130SrhVO.getTypOccuCd()));  //직종
	       
	//        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
	//        payr0350SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	//        payr0350SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0130SrhVO.getDtilOccuInttnCd())); 
	        infcPsnl0130SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        infcPsnl0130SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(psnl0130SrhVO.getDtilOccuInttnCd())); //직종세
	        infcPsnl0130SrhVo.setBusinCd(MSFSharedUtils.allowNulls(psnl0130SrhVO.getBusinCd()));   				//사업코드 
	        infcPsnl0130SrhVo.setSystemkey(MSFSharedUtils.allowNulls(psnl0130SrhVO.getSystemkey()));  			//시스템키
			
	        infcPsnl0130SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(psnl0130SrhVO.getMangeDeptCd()));    //관리부서 
	        infcPsnl0130SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(psnl0130SrhVO.getRepbtyBusinDivCd())); //호봉제구분
	        
	        List listYeta1700 = payr1700ExcelService.selectXlsFilePayr170002List(infcPsnl0130SrhVo);
	        
			String strValue = "";
			
	        List<EgovMap> excelList = new ArrayList<EgovMap>();
	
	    	for(int i=0; i<listYeta1700.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listYeta1700.get(i);
	    		
	    		// TODO 주민번호
	    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
	    		excelList.add(eMap);
	    	}
	        
	        
	//        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listFilePayr1700", excelList);
	        
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
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm, windowId);
        	
		}

		return new ModelAndView("payr170002ExcelView", map);
	} 
    
    
    
    
    
    
    
    /**
     * 엑셀파일을 업로드한다.
     * @param MultipartFile, Model, HttpServletRequest
     * @return sResult
     * @throws InvalidFormatException, IOException, SAXException
     */
    @RequestMapping(value = "/imp/XlsReadPayr1700Import.do", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("payr1700flUp") MultipartFile file,
			Model model, final HttpServletRequest request, final HttpServletResponse response, @RequestParam HashMap<String, String> param) throws InvalidFormatException, IOException, SAXException {
    	
    	String realPath = request.getSession().getServletContext().getRealPath("");
    	String xmlConfig = "/upXmlConfig/PAYR/Payr1700Mapping.xml";
    	
    	String windowNm = "급여계좌관리";
		String windowId = "PAYR1700";
    	
    	String method = calledClass + ".handleFormUpload";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	
    	Long lResult = new Long(0);		//리턴 결과
    	String sResult = "";			//결과 상태값
    	InputStream inputXML = null;	//XML
    	InputStream inputXLS = null;	//엑셀파일
//		FileInputStream inputfis = null;
		
		List<InfcPkgPsnl0130VO> psnl0130List = new ArrayList<InfcPkgPsnl0130VO>();
		Map<String, List> beans = new HashMap<String, List>();
		
		beans.put("psnl0130List", psnl0130List);
		
		try {
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
//			System.out.println("xml경로 " + realPath.concat("/WEB-INF" + xmlConfig));
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {
				
				
				long result ;
				
				
				if( psnl0130List == null || psnl0130List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					
					long excelCount = psnl0130List.size();
					
					//엑셀 업로드 서비스 호출(delete 후에 insert함)
					result = payr1700ExcelService.insertXlsPayr1700(psnl0130List, request);
					
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
//				lResult = payr1700ExcelService.insertXlsPayr1700(psnl0130List, request);
//				
//				if(lResult == 1) {
//					sResult =  "success";
//				} else {
//					sResult =  "error";
//				}
				
				
			} else {
				sResult =  "error";
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:U:D");
			
		} catch(Exception e) {
			
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