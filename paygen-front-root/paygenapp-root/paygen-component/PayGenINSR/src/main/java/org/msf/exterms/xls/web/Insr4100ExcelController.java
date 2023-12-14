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
import org.msf.exterms.xls.service.Insr4100ExcelService;
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

import com.app.exterms.insurance.server.vo.Insr3000SrhVO;
import com.app.exterms.insurance.server.vo.Insr3000VO;
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
public class Insr4100ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Insr4100ExcelController.class);  
    private static final String calledClass = Insr4100ExcelController.class.getName();

    
    @Resource(name = "Insr4100ExcelService")
    private Insr4100ExcelService insr4100ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsInsr4100TempExport.do")   
    public ModelAndView xlsInsr4100TempExport(HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
       
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        
//        insr3000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//        insr3000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//        
//        
//        List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getDeptCd()));  
//        insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드  
//    //    insr3000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//        
//        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getTypOccuCd())); 
//        insr3000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
//       // insr3000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//       
//        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getPyspGrdeCd())); 
//        insr3000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//       // insr3000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//         
//        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getDtilOccuInttnCd())); 
//        insr3000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
       // insr3000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
         
        
//        if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
//                && (ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
//           
//            insr3000SrhVo.setTypOccucdIn((sessionUser.getTypOccuCd().concat(sessionUser.getPyspGrdeCd()))); 
//            insr3000SrhVo.setPyspGrdeCdIn("1");
//            
//        } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
//                && (!ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
//           
//            insr3000SrhVo.setTypOccucdIn((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))));  
//            insr3000SrhVo.setPyspGrdeCdIn("1"); 
//            
//        } else { 
//            insr3000SrhVo.setTypOccucdIn(""); 
//            insr3000SrhVo.setPyspGrdeCdIn("0");
//        }
        
         
      //  List<Dlgn0250VO> listDlgn0250 = dlgn0250ExcelService.selectXlsDlgn0250List(insr3000SrhVo);
        
        Map<String, Object> map = new HashMap<String, Object>(); 
        
        return new ModelAndView("insr4100TempExcelView", map);
         
    }
    
    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsInsr4100Export.do")   
    public ModelAndView xlsInsr4100Export(@ModelAttribute("Insr3000SrhVO") Insr3000SrhVO insr3000SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
       
    	String method = calledClass + ".xlsInsr4100Export";
    	Map<String, Object> map = new HashMap<String, Object>(); 
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
        
    	String windowNm = "건강보험기본관리";
		String windowId = "INSR4100";
        
		try{
			
	        insr3000SrhVo.setUsrId(sessionUser.getUsrId());  
	        insr3000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        insr3000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        insr3000SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getMangeDeptCd()));
	        insr3000SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getRepbtyBusinDivCd()));
	        List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getHdofcCodtnCd())); 
	        insr3000SrhVo.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태
	        insr3000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getEmymtDivCd()));	         //고용구분
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getTypOccuCd())); 
	        insr3000SrhVo.setTypOccuCdArr(lstTypeOccuCd); //직종       
	     	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getDtilOccuInttnCd())); 
	     	insr3000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세
	     	insr3000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getBusinCd()));   //사업
	        
	     	insr3000SrhVo.setHanNm(MSFSharedUtils.allowNulls(insr3000SrhVo.getHanNm()));			//성명
	     	insr3000SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(insr3000SrhVo.getResnRegnNum()));//주민번호
	        
	        
	        
	     	insr3000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(insr3000SrhVo.getSystemkey()));	//시스템키
	        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getSystemkey())); 
	        insr3000SrhVo.setSystemKeyArr(systemKeyArr);
	        
	        
	         
	       
	       
	        /******************************** 권한 ************************************************************************/
	       /* String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	insr3000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           insr3000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	           insr3000SrhVo.setPayrMangeDeptCd(sessionUser.getPayrMangDeptCd());    
	        } else {
	        	insr3000SrhVo.setPayrMangeDeptCd(insr3000SrhVo.getPayrMangDeptCd());    
	        	insr3000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getPayrMangDeptCd()));    
	                 if (insr3000SrhVo.getPayrMangDeptCd().equals(insr3000SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	insr3000SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 insr3000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getDeptCd()));  
	                      insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        
	        
	        insr3000SrhVo.setDeptCdAuth(insr3000SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        insr3000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr3000SrhVo.getDtilOccuInttnCd()).replace(",", ""));*/
	      
	         
	       /******************************** 권한 ************************************************************************/
	           
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	insr3000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           insr3000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	insr3000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getPayrMangDeptCd()));  
	        	insr3000SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getPayrMangDeptCd()));
	                 if (insr3000SrhVo.getPayrMangDeptCd().equals(insr3000SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	insr3000SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 insr3000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getDeptCd()));  
	                      insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        insr3000SrhVo.setDeptCdAuth(insr3000SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        insr3000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr3000SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	        
	       /******************************** 권한 ************************************************************************/

	         
	        List listInsr3000 = insr4100ExcelService.selectXlsInsr3000List(insr3000SrhVo);
	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listInsr3000.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listInsr3000.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}
//	        Map<String, Object> map = new HashMap<String, Object>(); 
	        map = new HashMap<String, Object>(); 
	        map.put("listInsr3000", excelList);
	        
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
        
        return new ModelAndView("insr4100ExcelView", map);
         
    }
     
    
    
    /**
	 * 엑셀파일을 업로드한다.
	 * @param MultipartFile, Model, HttpServletRequest
	 * @return sResult
	 * @throws InvalidFormatException, IOException, SAXException
	 */
	@RequestMapping(value = "/imp/XlsInsr4100Import.do", method = RequestMethod.POST)
	public String handleFormUpload(  @RequestParam("insr4100flUp") MultipartFile file
								   , Model model
								   , final HttpServletRequest request, final HttpServletResponse response
								  ) throws InvalidFormatException, IOException, SAXException {
		String realPath = request.getSession().getServletContext().getRealPath("");
		String xmlConfig = "/upXmlConfig/INSR/Insr4100Mapping.xml";
		
		String method = calledClass + ".handleFormUpload";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		

		String windowNm = "건강보험기본관리";
		String windowId = "INSR4100";
		
		String sResult = "";			//결과 상태값
		InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
	//	FileInputStream inputfis = null;
		
		List<Insr3000VO> insr3000List = new ArrayList<Insr3000VO>();
		Map<String, List> beans = new HashMap<String, List>();
		
		beans.put("insr3000List", insr3000List);
		
		try {
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);

			if(xlsReadStatus.isStatusOK()) {
				
				long result ;
				
				
				if( insr3000List == null || insr3000List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					
					long excelCount = insr3000List.size();
					
					//엑셀 업로드 서비스 호출(delete 후에 insert함)
					result = insr4100ExcelService.updateXlsInsr4100(insr3000List, request);	
					
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
			} else {
				sResult = "error";
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
			 * D:delete		S:select	B:배치 
			 * L:로그인		O:로그아웃
			 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D:U");
			
		} catch(Exception e){
			PrgmComUtils.responseAlert(response, "엑셀 업로드중 오류가 발생하였습니다. 확인후 다시 업로드해주세요." );
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D:U",e, windowNm , windowId);
			
	     }finally {
			IOUtils.closeQuietly(inputXML);
			IOUtils.closeQuietly(inputXLS);
		}
		
		return sResult;
	}
    
    

    
}
