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
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Psnl0290ExcelService;
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

import com.app.exterms.personal.server.vo.Psnl0126SrhVO;
import com.app.exterms.personal.server.vo.Psnl0126VO;
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
public class Psnl0290ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Psnl0290ExcelController.class);  
    private static final String calledClass = Psnl0290ExcelController.class.getName();
 
    
    @Resource(name = "psnl0290ExcelService")
    private Psnl0290ExcelService psnl0290ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    

    /**
     * 엑셀파일로 출력한다. (상단버튼)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
	@RequestMapping(value="/exp/XlsFilePsnl0290Export.do")
	public ModelAndView xlsFilePsnl0126Export(@ModelAttribute("Psnl0126SrhVO") Psnl0126SrhVO psnl0126SrhVO,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
		
		String method = calledClass + ".xlsFilePsnl0126Export"; 
		
		String windowNm = "휴가일수산정";
		String windowId = "PSNL0290";
       
       
//        dlgn0250SrhVo.setTypOccucdIn("");
//        dlgn0250SrhVo.setPyspGrdeCdIn("");
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();  
        Map<String, Object> map = new HashMap<String, Object>();
        
		try{
        
	        psnl0126SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        psnl0126SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        
	        psnl0126SrhVO.setSystemkey(MSFSharedUtils.allowNulls(psnl0126SrhVO.getSystemkey()));	//시스템키
	        psnl0126SrhVO.setHanNm(MSFSharedUtils.allowNulls(psnl0126SrhVO.getHanNm()));			//성명
	        
	    	// 2. 파라미터 보낼 때(암호화)
	    	psnl0126SrhVO.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(psnl0126SrhVO.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
	        
	    	psnl0126SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(psnl0126SrhVO.getMangeDeptCd()));//관리부서
	    	psnl0126SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(psnl0126SrhVO.getRepbtyBusinDivCd())); 
	        psnl0126SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(psnl0126SrhVO.getEmymtDivCd()));	//고용구분코드
	        
	      	List<String> lsHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0126SrhVO.getHdofcCodtnCd())); 
	      	psnl0126SrhVO.setHdofcCodtnCdArr(lsHdofcCodtnCd);  
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0126SrhVO.getTypOccuCd())); 
	     	psnl0126SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	     
	//      List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0126SrhVO.getPyspGrdeCd())); 
	//      psnl0126SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	       
	     	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0126SrhVO.getDtilOccuInttnCd())); 
	     	psnl0126SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	      
	     	psnl0126SrhVO.setBusinCd(MSFSharedUtils.allowNulls(psnl0126SrhVO.getBusinCd()));   //사업코드 
	        psnl0126SrhVO.setHodyFixYn(psnl0126SrhVO.getHodyFixYn()); 							//확정여부
	        
	        psnl0126SrhVO.setUsrId(sessionUser.getUsrId());   
	        
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        
	     	if ("FALSE".equals(chkDeptCd)) {
	     		psnl0126SrhVO.setDeptCd(sessionUser.getDeptCd()); 
	     		listDeptCd.add(MSFSharedUtils.allowNulls(sessionUser.getDeptCd()));
	     		psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
	     		psnl0126SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	     	} else {
	     		psnl0126SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(psnl0126SrhVO.getPayrMangDeptCd()));    
	     		
	     		if (psnl0126SrhVO.getPayrMangDeptCd().equals(psnl0126SrhVO.getDeptCd())) { 
	     			listDeptCd = null; 
	               	psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	               	psnl0126SrhVO.setDeptCd("");  //부서코드
	     		} else {
	     			psnl0126SrhVO.setDeptCd(MSFSharedUtils.allowNulls(psnl0126SrhVO.getDeptCd()));
	     			listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0126SrhVO.getDeptCd()));  
	     			psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	     		} 
	     	}
	      
	      
	     	psnl0126SrhVO.setDeptCdAuth(psnl0126SrhVO.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	     	psnl0126SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(psnl0126SrhVO.getDtilOccuInttnCd()).replace(",", ""));
	       
	     	/******************************** 권한 ************************************************************************/
	        
	         
	     	List  listFilePsnl0126 = psnl0290ExcelService.selectXlsExportPsnl0126List(psnl0126SrhVO);
	     	
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listFilePsnl0126.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		Iterator<String> keys = eMap.keySet().iterator();
	    		eMap = (EgovMap) listFilePsnl0126.get(i);
	    		
	    		// 복호화	
	    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
		    		
	    		excelList.add(eMap);
	    	}
	     	
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listFilePsnl0126", excelList);
        
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        }
        
        
        return new ModelAndView("psnl0290FileExcelView", map);
         
	}
    
    /**
     * 엑셀파일로 출력한다. (양식)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPsnl0290Export.do")
    public ModelAndView xlsPsnl0126Export(@ModelAttribute("Psnl0126SrhVO") Psnl0126SrhVO psnl0126SrhVO, HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
       
       
//        dlgn0250SrhVo.setTypOccucdIn("");
//        dlgn0250SrhVo.setPyspGrdeCdIn("");
    	
    	String method = calledClass + ".xlsPsnl0126Export";
    	
    	String windowNm = "휴가일수산정";
		String windowId = "PSNL0290";
    	
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();  
        Map<String, Object> map = new HashMap<String, Object>();
        
        
		try{
        	
	        /*psnl0126SrhVO.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));  //사업장코드
	        psnl0126SrhVO.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));  //단위기관담당자여부 
	        psnl0126SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(psnl0126SrhVO.getEmymtDivCd()));      //고용구분코드
	        
	        *//******************************** 권한 ************************************************************************//*
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        
	        if ("FALSE".equals(chkDeptCd)) {
	        	psnl0126SrhVO.setDeptCd(MSFSharedUtils.allowNulls(sessionUser.getDeptCd())); 
	        	listDeptCd.add(MSFSharedUtils.allowNulls(sessionUser.getDeptCd()));
	        	psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
	        	psnl0126SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd())); 
	        } else {
	        	    
	        	psnl0126SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(psnl0126SrhVO.getPayrMangDeptCd()));  
	      	  
	      	  	if (psnl0126SrhVO.getPayrMangDeptCd().equals(psnl0126SrhVO.getDeptCd())) { 
	      	  		listDeptCd = null; 
	      	  		psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	      	  		psnl0126SrhVO.setDeptCd(MSFSharedUtils.allowNulls(""));  //부서코드
	      	  	} else {
	      	  		psnl0126SrhVO.setDeptCd(MSFSharedUtils.allowNulls(psnl0126SrhVO.getDeptCd()));
	      	  		listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0126SrhVO.getDeptCd()));  
	      	  		psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	      	  	} 
	        }
	         
	        psnl0126SrhVO.setDeptCdAuth(psnl0126SrhVO.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        psnl0126SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(psnl0126SrhVO.getDtilOccuInttnCd()).replace(",", ""));
	       *//******************************** 권한 ************************************************************************//*
	        
	        List<String> lsHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0126SrhVO.getHdofcCodtnCd())); 
	        psnl0126SrhVO.setHdofcCodtnCdArr(lsHdofcCodtnCd); 
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0126SrhVO.getTypOccuCd())); 
	        psnl0126SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0126SrhVO.getDtilOccuInttnCd())); 
	        psnl0126SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        
	        psnl0126SrhVO.setBusinCd(MSFSharedUtils.allowNulls(psnl0126SrhVO.getBusinCd()));   //사업코드 
	        
	        psnl0126SrhVO.setUsrId(sessionUser.getUsrId());    
	
	        psnl0126SrhVO.setHodyApptnYr(psnl0126SrhVO.getHodyApptnYr());						//휴가년도
	        psnl0126SrhVO.setHodyFixYn(psnl0126SrhVO.getHodyFixYn()); 							//확정여부
	        
	        List  listFilePsnl0126 = psnl0290ExcelService.selectXlsFilePsnl0126List(psnl0126SrhVO);
	        
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listFilePsnl0126.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listFilePsnl0126.get(i);
	    		
//	    		System.out.println("암호화 주민 " + MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")));
//	    		System.out.println("복호화 주민 " + AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC));
	    		

		    	eMap.put("resnRegnNum", AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC));
//		    	System.out.println("복호화 주민 " + eMap.get("resnRegnNum"));
		    	
//	    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//		    	System.out.println("복호화 주민 " + strValue);
		    		
//	    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//		    	eMap.put("payFamyResnRegnNum", strValue);
	    			
	    		excelList.add(eMap);
	    	}
		    
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listFilePsnl0126", excelList);*/
	        
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
        
        return new ModelAndView("psnl0290ExcelView", map);
         
    }
    
    
    
    /**
     * 엑셀파일을 업로드한다.
     * @param MultipartFile, Model, HttpServletRequest
     * @return sResult
     * @throws InvalidFormatException, IOException, SAXException
     */
    @RequestMapping(value = "/imp/XlsReadPsnl0290Import.do", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("psnl0290flUp") MultipartFile file,
			Model model, final HttpServletRequest request, final HttpServletResponse response) throws InvalidFormatException, IOException, SAXException {
    	
    	String windowNm = "휴가일수산정";
		String windowId = "PSNL0290";
		
    	String realPath = request.getSession().getServletContext().getRealPath(""); 
    	String xmlConfig = "/upXmlConfig/PSNL/Psnl0290Mapping.xml";
    	
    	String method = calledClass + ".handleFormUpload";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	
    	Long lResult = new Long(0);		//리턴 결과 
    	String sResult = "";			//결과 상태값
    	InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
//		FileInputStream inputfis = null;
		
		List<Psnl0126VO> psnl0126List = new ArrayList<Psnl0126VO>();
		Map<String, List> beans = new HashMap<String, List>();
		
	    beans.put("psnl0126List", psnl0126List);
//	    System.out.println("xml 어디 " + upXmlConfig);
		
		try {
			
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
//			System.out.println("xml경로 " + realPath.concat("/WEB-INF" + xmlConfig));
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {
				
				long result ;
				
				
				if( psnl0126List == null || psnl0126List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					
					long excelCount = psnl0126List.size();
					
					result = psnl0290ExcelService.updateXlsPsnl0290(psnl0126List, request);
					
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
//				//엑셀 업로드 서비스 호출
//				lResult = psnl0290ExcelService.updateXlsPsnl0290(psnl0126List, request);
//				
//				if(lResult == 1) {
//					sResult =  "success";
//				}else {
//					sResult =  "error";
//				}
				
				
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
    
    
    
  

    /**
     * 엑셀파일을 업로드하여  등록한다.
     * @param loginVO
     * @param request
     * @param commandMap
     * @param model
     * @return  
     * @throws Exception
     */
//    @RequestMapping(value = "/imp/XlsPsnl0290Import.do")
//    public String xlsPsnl0290Import(@ModelAttribute("Psnl0126VO") Psnl0126VO psnl0126Vo,final HttpServletRequest request
//            , Map commandMap , Model model) throws Exception {
//         
//        if  (psnl0290ExcelService == null) { 
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( request.getSession().getServletContext());
//
//            psnl0290ExcelService = (Psnl0290ExcelService) wac.getBean("Psnl0290ExcelService"); 
//       }
//        
//        final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//
//        final Map<String, MultipartFile> files = multiRequest.getFileMap();
//     
//        
//        InputStream fis = null; // 2011.11.1 보안점검 후속조치
//
//        String sResult = "";
//        
//        Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
//        MultipartFile file;
//        while (itr.hasNext()) {
//        	
//            Entry<String, MultipartFile> entry = itr.next();
//
//            file = entry.getValue();
//            if (!"".equals(file.getOriginalFilename())) {
//                // 2011.10.07 업로드 파일에 대한 확장자를 체크
//                if (file.getOriginalFilename().endsWith(".xls")|| file.getOriginalFilename().endsWith(".XLS") ) {
//                    
//                    //2011.10.21 보안점검 후속조치
//                    try {
//                        fis = file.getInputStream();
//                        psnl0290ExcelService.updateXlsPsnl0126(fis);
//
//                        sResult =  "success";
//                    } catch(Exception e) {
//                          e.printStackTrace();
//                        sResult = "error";
//                       
//                    } finally {
//                        if (fis != null)    // 2011.11.1 보안점검 후속조치
//                            fis.close();
//                    }
//                } else  if (file.getOriginalFilename().endsWith(".xlsx")
//                        || file.getOriginalFilename().endsWith(".XLSX")) {
//                    
//                    //2011.10.21 보안점검 후속조치
//                    try {
//                        fis = file.getInputStream();
//
//                        psnl0290ExcelService.updateXlssPsnl0126(fis);
//                       
//                        sResult =  "success";
//                    } catch(Exception e) {
//                          e.printStackTrace();
//                        sResult = "error";
//                       
//                    } finally {
//                        if (fis != null)    // 2011.11.1 보안점검 후속조치
//                            fis.close();
//                    }
//                }else{
//                    logger.info("xls, xlsx 파일 타입만 등록이 가능합니다."); 
//                    sResult =  "success";
//                }
//                // *********** 끝 ***********
//            }
//        }
//        return sResult;
//    }
    
}
