package org.msf.exterms.remt.xls.web;

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
import org.msf.exterms.remt.xls.service.Remt0400ExcelService;
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
import com.app.exterms.retirement.server.vo.Remt9000SrhVO;
import com.app.exterms.retirement.server.vo.Remt9000VO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import net.sf.jxls.reader.ReaderBuilder;
import net.sf.jxls.reader.XLSReadStatus;
import net.sf.jxls.reader.XLSReader;

@Controller
public class Remt0400ExcelController {
	
	private static final Logger logger = LoggerFactory.getLogger(Remt0400ExcelController.class);  
    private static final String calledClass = Remt0400ExcelController.class.getName();
    
    @Resource(name = "remt0400ExcelService")
    private Remt0400ExcelService remt0400ExcelService;
    
    private List<Remt9000VO> errRemt0400List = new ArrayList<Remt9000VO>();

//    /** EgovPropertyService */
//    @Resource(name = "propertiesService")
//    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsFileRemt0400Export.do")
    public ModelAndView xlsFileRemt0400Export(@ModelAttribute("Remt9000SrhVO") Remt9000SrhVO remt9000SrhVo, HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsFileRemt0400Export";
    	
    	String windowNm = "퇴직금중간정산등록";
		String windowId = "REMT0400";
    	
    	
    	
//    	Remt9000SrhVO   remt9000SrhVo = new Remt9000SrhVO();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
        Map<String, Object> map = new HashMap<String, Object>();
        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        try{
        	
	         remt9000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	         remt9000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	         remt9000SrhVo.setUsrId(sessionUser.getUsrId());
	         remt9000SrhVo.setCalcSevePayPsnBlggYr(remt9000SrhVo.getCalcSevePayPsnBlggYr()); //귀속년도
	         remt9000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(remt9000SrhVo.getPayrMangDeptCd())) ;   //단위기관코드
	         remt9000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(remt9000SrhVo.getEmymtDivCd()));       //고용구분코드
	         
	 
	         
	         /******************************** 권한 ************************************************************************/
	         String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	         if ("FALSE".equals(chkDeptCd)) {
	        	 remt9000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	            listDeptCd.add(sessionUser.getDeptCd());
	            remt9000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	            remt9000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	         } else {
	         	    
	        	 remt9000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(remt9000SrhVo.getPayrMangDeptCd())) ;   //단위기관코드 
	                  if (remt9000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(remt9000SrhVo.getDeptCd()))) { 
	                  	 listDeptCd = null; 
	                  	remt9000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                  	remt9000SrhVo.setDeptCd("");  //부서코드
	                  } else {
	                	  remt9000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(remt9000SrhVo.getDeptCd()));
	                       listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(remt9000SrhVo.getDeptCd()));  
	                       remt9000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                  } 
	               
	         }
	         
	
	         
	         remt9000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(remt9000SrhVo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
	         remt9000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(remt9000SrhVo.getDtilOccuInttnCd()).replace(",", ""));   
	          
	        /******************************** 권한 ************************************************************************/
	         remt9000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(remt9000SrhVo.getDeptCd()));		//부서
	         	         
	         List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(remt9000SrhVo.getTypOccuCd())); 
	         remt9000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	         remt9000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(remt9000SrhVo.getTypOccuCd()));  //직종
	        	          
	         List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(remt9000SrhVo.getDtilOccuInttnCd())); 
	         remt9000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	         remt9000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(remt9000SrhVo.getDtilOccuInttnCd())); //직종세 
	         
	         remt9000SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(remt9000SrhVo.getCalcSevePayPsnDivCd()));  //퇴직정산구분코드   
	         remt9000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(remt9000SrhVo.getBusinCd()));   //사업코드 
	         remt9000SrhVo.setHanNm(MSFSharedUtils.allowNulls(remt9000SrhVo.getHanNm()));    //한글성명
	         remt9000SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(remt9000SrhVo.getResnRegnNum()));	//주민등록번호
	         remt9000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(remt9000SrhVo.getSystemkey()));  //시스템키
	         
	         List listRemt0400 = remt0400ExcelService.selectXlsFileRemt0400List(remt9000SrhVo);
	         
	         String strValue = "";
				List<EgovMap> excelList = new ArrayList<EgovMap>();

			    for(int i=0; i<listRemt0400.size(); i++){
		    		EgovMap eMap  = new EgovMap();
		    		Iterator<String> keys = eMap.keySet().iterator();
		    		eMap = (EgovMap) listRemt0400.get(i);
		    		
		    		// 복호화	
		    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
			    		
		    		excelList.add(eMap);
		    	}
	        
	         map = new HashMap<String, Object>();
	         map.put("listRemt0400", excelList);
	             
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
    	
    	return new ModelAndView("remt0400ExcelView", map);
    }
    
    /**
     * 엑셀파일을 업로드한다.
     * @param MultipartFile, Model, HttpServletRequest
     * @return sResult
     * @throws InvalidFormatException, IOException, SAXException
     */
    @RequestMapping(value = "/imp/XlsReadRemt0400Import.do", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("remt0400flUp") MultipartFile file,
			Model model, final HttpServletRequest request, final HttpServletResponse response) throws InvalidFormatException, IOException, SAXException {
    	
    	String windowNm = "퇴직금중간정산등록";
		String windowId = "REMT0400";
		
    	String realPath = request.getSession().getServletContext().getRealPath(""); 
    	String xmlConfig = "/upXmlConfig/REMT/Remt0400Mapping.xml";
    	
    	String method = calledClass + ".handleFormUpload";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	
//    	Long lResult = new Long(0);		//리턴 결과 
    	String sResult = "";			//결과 상태값
    	InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
//		FileInputStream inputfis = null;
		
		List<Remt9000VO> remt9000List = new ArrayList<Remt9000VO>();
		Map<String, List> beans = new HashMap<String, List>();
		
	    beans.put("remt9000List", remt9000List);
//	    System.out.println("xml 어디 " + upXmlConfig);
		
		try {
			
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
//			System.out.println("xml경로 " + realPath.concat("/WEB-INF" + xmlConfig));
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {
				//엑셀 업로드 서비스 호출
				errRemt0400List = new ArrayList<Remt9000VO>();
				
				if( remt9000List == null || remt9000List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					//엑셀 업로드 서비스 호출(delete 후에 insert함)
					errRemt0400List = remt0400ExcelService.updateXlsRemt0400(remt9000List, request);		
				}
				
				//errRemt0400List = remt0400ExcelService.updateXlsRemt0400(remt9000List, request);
				sResult = "/excelPopup/excelList2";				
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
	 * 팝업창 실행
	 * @param 
	 * @param ModelAndView
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value="/remt/excelList.do")
    public ModelAndView openSampleBoardList() throws Exception{
    	
        ModelAndView mv = new ModelAndView("/excelPopup/excelPopup2");
        
		List excelList = new ArrayList();
		Remt9000VO remt9000VO = new Remt9000VO();
        
		for(int i=0; i < errRemt0400List.size(); i++) {

			remt9000VO = new Remt9000VO();
			remt9000VO = errRemt0400List.get(i);

			System.out.println(remt9000VO.getHanNm());

			excelList.add(remt9000VO);

		}
		
//		System.out.println(excelList.size());

		mv.addObject("remt9000List", errRemt0400List);

		return mv;
	}
    

}
