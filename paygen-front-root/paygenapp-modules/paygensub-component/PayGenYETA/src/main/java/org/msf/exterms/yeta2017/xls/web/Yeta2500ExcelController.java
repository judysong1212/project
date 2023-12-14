package org.msf.exterms.yeta2017.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.yeta2017.xls.service.Yeta2500ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.yearendtax.server.vo.Ye161010SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta2000SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Yeta2500ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Yeta2500ExcelController.class);  
    private static final String calledClass = Yeta2500ExcelController.class.getName();
 
    
    @Resource(name = "yeta2500ExcelService")
    private Yeta2500ExcelService yeta2500ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    

    /**
     * 엑셀파일로 출력한다. (양식)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsYeta2500Export.do")
    public ModelAndView xlsYeta2500Export(@ModelAttribute("Ye161010SrhVO") Ye161010SrhVO ye161010SrhVo, HttpServletRequest request ,ModelMap model) 
                    throws Exception {  
    	
    	String method = calledClass + "xlsYeta2000Export";
    	
    	String windowNm = "연말정산급여반영";
		String windowId = "YETA2500";
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();  
        Map<String, Object> map = new HashMap<String, Object>();
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
		try{
        	
	    	 ye161010SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161010SrhVo.getYrtxBlggYr())); //연말정산년
	         ye161010SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getClutSeptCd()));  //연말정산구분코드  
	         
	    
	         
	         ye161010SrhVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));  //사업장코드
	         ye161010SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));  //단위기관담당자여부 
	         ye161010SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getEmymtDivCd()));      //고용구분코드
	         
	         /******************************** 권한 ************************************************************************/
	         String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	         
	         if ("FALSE".equals(chkDeptCd)) {
	        	 
	     	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(ye161010SrhVo.getDeptCd(),sessionUser.getDeptCd()))) {
	   			 

		         	ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(sessionUser.getDeptCd())); 
		         	listDeptCd.add(MSFSharedUtils.allowNulls(sessionUser.getDeptCd()));
		         	ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	        	   } else {
	        		   ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getDeptCd()));
		       	  		listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010SrhVo.getDeptCd()));  
		       	  		ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	        		 
	        	  }  
	     	    
	         	ye161010SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd())); 
	         } else {
	         	    
	         	ye161010SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getPayrMangDeptCd()));  
	       	  
	       	  	if (ye161010SrhVo.getPayrMangDeptCd().equals(ye161010SrhVo.getDeptCd())) { 
	       	  		listDeptCd = null; 
	       	  		ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	       	  		ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));  //부서코드
	       	  	} else {
	       	  		ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getDeptCd()));
	       	  		listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010SrhVo.getDeptCd()));  
	       	  		ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	       	  	} 
	         }
	          
	         ye161010SrhVo.setDeptCdAuth(ye161010SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	         ye161010SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(ye161010SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	        /******************************** 권한 ************************************************************************/
	         
	         List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010SrhVo.getTypOccuCd())); 
	         ye161010SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	          
	         List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(ye161010SrhVo.getDtilOccuInttnCd())); 
	         ye161010SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	         
	         ye161010SrhVo.setBusinCd(MSFSharedUtils.allowNulls(ye161010SrhVo.getBusinCd()));   //사업코드 
	         
	         ye161010SrhVo.setUsrId(sessionUser.getUsrId());    
	    	
	    	
	        List  listYeta2000 = yeta2500ExcelService.selectYeta2500ToYeta2000List(ye161010SrhVo);
	        

			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    	for(int i=0; i<listYeta2000.size(); i++){
		    		EgovMap eMap  = new EgovMap();
		    		eMap = (EgovMap) listYeta2000.get(i);
		    		// TODO 주민번호
		    		String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
		    		excelList.add(eMap);
		    	}
	        
	        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
	        
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listYeta2500", excelList);
        
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        } 
        
        return new ModelAndView("yeta2500ExcelView", map);
         
    }
    
    
    
//    /**
//     * 엑셀파일을 업로드한다.
//     * @param MultipartFile, Model, HttpServletRequest
//     * @return sResult
//     * @throws InvalidFormatException, IOException, SAXException
//     */
//    @RequestMapping(value = "/imp/XlsReadYeta0100Import.do", method = RequestMethod.POST)
//    public String handleFormUpload(@RequestParam("yeta0100flUp") MultipartFile file,
//			Model model, final HttpServletRequest request) throws InvalidFormatException, IOException, SAXException {
//    	
//    	String realPath = request.getSession().getServletContext().getRealPath(""); 
//    	String xmlConfig = "/upXmlConfig/YETA/Yeta0100Mapping.xml";
//    	
//    	String sResult = "";			//결과 상태값
//    	InputStream inputXML = null;	//XML
//		InputStream inputXLS = null;	//엑셀파일
//		
//		List<Yeta3900VO> yeta3900List = new ArrayList<Yeta3900VO>();
//		Map<String, List> beans = new HashMap<String, List>();
//		
//	    beans.put("yeta3900List", yeta3900List);
//		
//		try {
//			
//			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
//			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
//			inputXLS = new BufferedInputStream(file.getInputStream());
////			System.out.println("xml경로 " + realPath.concat("/WEB-INF" + xmlConfig));
//			
//			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
//			
//			if(xlsReadStatus.isStatusOK()) {
//				//엑셀 업로드 서비스 호출
//				yeta0100ExcelService.updateXlsYeta3900(yeta3900List);
//				sResult =  "success";
//			}else {
//				sResult =  "error";
//			}
//		}finally {
//			IOUtils.closeQuietly(inputXML);
//			IOUtils.closeQuietly(inputXLS);
// 		}
//
//		return sResult;
//	}    
}