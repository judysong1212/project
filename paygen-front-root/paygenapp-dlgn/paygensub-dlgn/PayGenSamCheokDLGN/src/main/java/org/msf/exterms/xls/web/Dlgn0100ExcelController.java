package org.msf.exterms.xls.web;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.jxls.reader.XlsToMapReader;
import org.msf.exterms.xls.service.Dlgn0100ExcelService;
import org.msf.exterms.xls.service.Dlgn0250ExcelService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import com.app.exterms.diligence.server.vo.Dlgn0100SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0100VO;
import com.app.exterms.diligence.server.vo.Dlgn0110ExlVO;
import com.app.exterms.diligence.server.vo.Dlgn0250SrhVO;
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
public class Dlgn0100ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Dlgn0100ExcelController.class);  
    private static final String calledClass = Dlgn0100ExcelController.class.getName();
 
    @Resource(name = "dlgn0250ExcelService")
    private Dlgn0250ExcelService dlgn0250ExcelService;
    
    @Resource(name = "dlgn0100ExcelService")
    private Dlgn0100ExcelService dlgn0100ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

     
    
    /**
     * 엑셀파일로 출력한다.(양식)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsDlgn0100Export.do")
	public ModelAndView xlsDlgn0100Export(@ModelAttribute("Dlgn0250SrhVO") Dlgn0250SrhVO dlgn0250SrhVo,HttpServletRequest request,HttpServletResponse response  ,ModelMap model)
                    throws Exception { 
       
    	String method = calledClass + ".xlsDlgn0100Export";
//        dlgn0100SrhVo.setTypOccucdIn("");
//        dlgn0100SrhVo.setPyspGrdeCdIn("");
		PrintWriter out ;
    	 
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();
        Map<String, Object> map = new HashMap<String, Object>();
        
		String windowNm = "기본근무관리";
		String windowId = "DLGN0100";
		
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        try{
//        	// 2. 파라미터 보낼 때(암호화)
//        	dlgn0250SrhVo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0250SrhVo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
//
//        
//	        dlgn0250SrhVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
//	        dlgn0250SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	        dlgn0250SrhVo.setUsrId(sessionUser.getUsrId());  		//유저아이디
//	        
//	        dlgn0250SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getEmymtDivCd()));	//고용구분코드
//	        
//	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getTypOccuCd())); 
//	        dlgn0250SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
//	       
//	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDtilOccuInttnCd())); 
//	        dlgn0250SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//	        
//	        dlgn0250SrhVo.setBusinCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getBusinCd()));   //사업코드
//	        
//	
//	        /******************************** 권한 ************************************************************************/
//	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//	        if ("FALSE".equals(chkDeptCd)) {
//	        	dlgn0250SrhVo.setDeptCd(sessionUser.getDeptCd()); 
//	           listDeptCd.add(sessionUser.getDeptCd());
//	           dlgn0250SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
//	           dlgn0250SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//	        } else {
//	        	    
//	        	dlgn0250SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getPayrMangDeptCd()));    
//	                 if (dlgn0250SrhVo.getPayrMangDeptCd().equals(dlgn0250SrhVo.getDeptCd())) { 
//	                 	 listDeptCd = null; 
//	                 	dlgn0250SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	                 	dlgn0250SrhVo.setDeptCd("");  //부서코드
//	                 } else {
//	                	 dlgn0250SrhVo.setDeptCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDeptCd()));
//	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDeptCd()));  
//	                      dlgn0250SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
//	                 } 
//	              
//	        }
//	        
//	        dlgn0250SrhVo.setDeptCdAuth(dlgn0250SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
//	        dlgn0250SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDtilOccuInttnCd()).replace(",", ""));
//	         
//	       /******************************** 권한 ************************************************************************/
////	        HashMap<String, String> extGlobals = ExtConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); ;
//	        HashMap<String, String> extGlobals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
//	
//	        /**
//	      	         * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
//	      	         */
//	                  if (dlgn0250SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDeptCdAuth())) 
//	              			|| MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDeptCdAuth()).contains(dlgn0250SrhVo.getPayrMangDeptCd())
//	              			) {
//	           				
//	           				dlgn0250SrhVo.setRepbtyBusinDivCd("");
//	           				 
//	              	}  
////	        List<Dlgn0250VO> listDlgn0100Vo = dlgn0100ExcelService.selectXlsDlgn0100List(dlgn0250SrhVo);
//	        List<Dlgn0250VO> listDlgn0100Vo = dlgn0100ExcelService.selectXlsDlgn0100ListD(dlgn0250SrhVo);
//	//        Map<String, Object> map = new HashMap<String, Object>();
//	        
//	        int cntRegYn = 0 ;
//	        
//	        
//	        List listDlgn0100 = new ArrayList<String>();
//	        
////	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//	    	
//
//	        
//	        Dlgn0250SrhVO cntChkVo = null;
//	        
//	        for(int i=0; i<listDlgn0100Vo.size(); i++){
//	    		
//	    		Dlgn0250VO dlgn0250Vo = new Dlgn0250VO();
//	    		dlgn0250Vo = listDlgn0100Vo.get(i);
//	    		
//		        
//	    		// 기등록된 근태내역이 있는지 체크 로직 추가 
//		        int chkDlgnCnt = 0;
//	    		
//	    		cntChkVo = new Dlgn0250SrhVO();
//		        cntChkVo.setJobYrMnth(dlgn0250SrhVo.getJobYrMnth());
//	    		cntChkVo.setSystemkey(listDlgn0100Vo.get(i).getSystemkey());
//	    		
//	    		
//	    		chkDlgnCnt = dlgn0100ExcelService.selectDlgn0100Cnt(cntChkVo);
//	    		
//	    		//System.out.println("chkDlgnCnt==============="+chkDlgnCnt);
//	    		
//	    		if(chkDlgnCnt <= 0){
//	    			
//	    			
//	    			//throw new Exception("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbb");
//	    			
//	                response.setContentType("text/html; charset=UTF-8");
//
//		            out = response.getWriter();
//
//		            out.println("<script>alert('해당단위기관 /부서의  인원의 근태 생성후 실적업로드 해주시기 바랍니다.'); </script>"); 
//
//		            out.flush(); 	
//                    
//		            break;
//	    			
//	    			
//	    		}
//	    		
//
//	    		// TODO 주민번호
//	    		nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//	    		dlgn0250Vo.setResnRegnNum(AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0250Vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC));
//	    		
//	    		listDlgn0100.add(dlgn0250Vo);
//	    		
//	    	}
//	    	
//	        map = new HashMap<String, Object>();
//	        map.put("listDlgn0100", listDlgn0100);
        	
			Dlgn0100SrhVO dlgn0100SrhVo = new Dlgn0100SrhVO();
			
			// 2. 파라미터 보낼 때(암호화)
        	dlgn0100SrhVo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0250SrhVo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호

        	dlgn0100SrhVo.setDilnlazYrMnth(dlgn0250SrhVo.getJobYrMnth());
        	dlgn0100SrhVo.setDpobCd(sessionUser.getDpobCd());		//사업장코드
        	dlgn0100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
        	dlgn0100SrhVo.setUsrId(sessionUser.getUsrId());  		//유저아이디
	        
        	dlgn0100SrhVo.setPayCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getPayCd()));
        	dlgn0100SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getEmymtDivCd()));	//고용구분코드
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getTypOccuCd())); 
	        dlgn0100SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	       
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDtilOccuInttnCd())); 
	        dlgn0100SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        
	        dlgn0100SrhVo.setBusinCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getBusinCd()));   //사업코드
	        
	
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	dlgn0100SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	        	listDeptCd.add(sessionUser.getDeptCd());
	        	dlgn0100SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	        	dlgn0100SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	dlgn0100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getPayrMangDeptCd()));    
	                 if (dlgn0100SrhVo.getPayrMangDeptCd().equals(dlgn0250SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	dlgn0100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	dlgn0100SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 dlgn0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDeptCd()));  
	                      dlgn0100SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        
	        dlgn0100SrhVo.setDeptCdAuth(dlgn0250SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        dlgn0100SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	         
	       /******************************** 권한 ************************************************************************/
//	        HashMap<String, String> extGlobals = ExtConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); ;
	        HashMap<String, String> extGlobals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
	

			/**
			 * TODO 김해 시청 호봉제만 불러 오는 로직 추가 함. 임시로 김해시만 적용
			 */
			if (dlgn0100SrhVo.getPayrMangDeptCd().equals(
					MSFSharedUtils.allowNulls(dlgn0100SrhVo.getDeptCdAuth()))|| MSFSharedUtils.allowNulls(dlgn0100SrhVo.getDeptCdAuth()).contains(dlgn0100SrhVo.getPayrMangDeptCd())) {
				// 호봉제구분코드 포함해서 가져 오기 REPBTY_BUSIN_DIV_CD
				dlgn0100SrhVo.setRepbtyBusinDivCd("");
			}
	                
	         Dlgn0250SrhVO cntChkVo = new Dlgn0250SrhVO();
	         List listDlgn0100 = dlgn0100ExcelService.selectXlsUseDlgn0100List(dlgn0100SrhVo);

	         List<EgovMap> excelList = new ArrayList<EgovMap>();
	         
	         
	         if(listDlgn0100.size() <= 0) {

				response.setContentType("text/html; charset=UTF-8");

				out = response.getWriter();

				out.println("<script>alert('해당 단위기관/부서에 해당하는 근로자의 근태 생성후 양식다운로드 해주시기 바랍니다.'); </script>");

				out.flush();

	        	 
	         }else {
	        	 
	 			for (int i = 0; i < listDlgn0100.size(); i++) {

					cntChkVo = new Dlgn0250SrhVO();
					EgovMap eMap = new EgovMap();
					eMap = (EgovMap) listDlgn0100.get(i);
		    				
					// 기등록된 근태내역이 있는지 체크 로직 추가
					int chkDlgnCnt = 0;

					cntChkVo = new Dlgn0250SrhVO();
					cntChkVo.setJobYrMnth(MSFSharedUtils.allowNulls(eMap.get("dilnlazYrMnth")));
					cntChkVo.setSystemkey(MSFSharedUtils.allowNulls(eMap.get("systemkey")));
					
		    	    		
					chkDlgnCnt = dlgn0100ExcelService.selectDlgn0100Cnt(cntChkVo);
					
					if (chkDlgnCnt <= 0) {

						response.setContentType("text/html; charset=UTF-8");

						out = response.getWriter();

						out.println("<script>alert('해당 단위기관/부서에 해당하는 근로자의 근태 생성후 양식다운로드 해주시기 바랍니다.'); </script>");

						out.flush();

						break;

					}
		    	    		
		    
					// TODO 주민번호
					String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					eMap.put("resnRegnNum", strValue);
					excelList.add(eMap);		
		    				
				}   
	        	 
	         }

	        map = new HashMap<String, Object>();
	        map.put("listDlgn0100", excelList);
        	
        	
	        
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
        return new ModelAndView("dlgn0100ExcelView", map);
    }
    
    /**
     * 엑셀파일로 출력한다.(상단버튼)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsFileDlgn0100Export.do")
    public ModelAndView xlsFileDlgn0100Export(@ModelAttribute("Dlgn0100SrhVO") Dlgn0100SrhVO dlgn0100SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
       
    	String method = calledClass + ".xlsFileDlgn0100Export";
//        dlgn0100SrhVo.setTypOccucdIn("");
//        dlgn0100SrhVo.setPyspGrdeCdIn("");
    	
		String windowNm = "기본근무관리";
		String windowId = "DLGN0100";
		
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();
        Map<String, Object> map = new HashMap<String, Object>();
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        try{
        	
	        dlgn0100SrhVo.setDpobCd(sessionUser.getDpobCd());  			//사업장코드
	        dlgn0100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());	//단위기관담당자여부 
	        
	        dlgn0100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(dlgn0100SrhVo.getSystemkey()));	//시스템키
	        dlgn0100SrhVo.setHanNm(MSFSharedUtils.allowNulls(dlgn0100SrhVo.getHanNm()));			//성명
//	        dlgn0100SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(dlgn0100SrhVo.getResnRegnNum()));//주민번호
	        
	        
	        // 2. 파라미터 보낼 때(암호화)
	        dlgn0100SrhVo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0100SrhVo.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
	        
	        dlgn0100SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(dlgn0100SrhVo.getEmymtDivCd()));	//고용구분코드
	        
	        dlgn0100SrhVo.setUsrId(sessionUser.getUsrId()); 			//유저 아이디 
	        
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0100SrhVo.getTypOccuCd())); 
	        dlgn0100SrhVo.setTypOccuCdArr(lstTypeOccuCd);				//직종 
	
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0100SrhVo.getDtilOccuInttnCd())); 
	        dlgn0100SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  	//직종세
	        
	        dlgn0100SrhVo.setBusinCd(MSFSharedUtils.allowNulls(dlgn0100SrhVo.getBusinCd()));   //사업코드 
	
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	dlgn0100SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	        	listDeptCd.add(sessionUser.getDeptCd());
	        	dlgn0100SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	        	dlgn0100SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	dlgn0100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dlgn0100SrhVo.getPayrMangDeptCd()));    
	        	
	        	if (dlgn0100SrhVo.getPayrMangDeptCd().equals(dlgn0100SrhVo.getDeptCd())) { 
	        		listDeptCd = null; 
	        		dlgn0100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                dlgn0100SrhVo.setDeptCd("");  //부서코드
	        	} else {
	        		dlgn0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(dlgn0100SrhVo.getDeptCd()));
	        		listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0100SrhVo.getDeptCd()));  
	        		dlgn0100SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	        	} 
	        }
	         
	        
	        dlgn0100SrhVo.setDeptCdAuth(dlgn0100SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        dlgn0100SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dlgn0100SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	    	/******************************** 권한 ************************************************************************/
	        
//	        HashMap<String, String> extGlobals = ExtConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); ;
	        HashMap<String, String> extGlobals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
	        		/**
	      	         * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
	      	         */
	                  if (dlgn0100SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0100SrhVo.getDeptCdAuth())) 
	              			|| MSFSharedUtils.allowNulls(dlgn0100SrhVo.getDeptCdAuth()).contains(dlgn0100SrhVo.getPayrMangDeptCd())
	              			) {
	                	  
	    					dlgn0100SrhVo.setRepbtyBusinDivCd("");
	              	}  
	        
	        List  listFileDlgn0100 = dlgn0100ExcelService.selectXlsFileDlgn0100List(dlgn0100SrhVo);
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        
	        
	        List<EgovMap> excelList = new ArrayList<EgovMap>();
	        
	    	for(int i=0; i<listFileDlgn0100.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listFileDlgn0100.get(i);
	    		
	    		// 복호화
	    		String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
	    		excelList.add(eMap);
	    	}
	        
	        map.put("listFileDlgn0100", excelList);
	        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
        }
        
        return new ModelAndView("dlgn0100FileExcelView", map);
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
//    @RequestMapping(value = "/imp/XlsDlgn0100Import.do")
//    public String xlsDlgn0100Import(@ModelAttribute("Dlgn0100VO") Dlgn0100VO dlgn0100Vo,final HttpServletRequest request
//            , Map commandMap , Model model) throws Exception {
//    	
//    	String method = calledClass + ".xlsDlgn0100Import";
//    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//    	
//		String windowNm = "기본근무관리";
//		String windowId = "DLGN0100";
//         
////        String sCmd = commandMap.get("dlgn0100flUp") == null ? "" : (String)commandMap.get("dlgn0100flUp");
////        if (sCmd.equals("")) {
////          return;
////        }
//
//        if  (dlgn0100ExcelService == null) { 
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( request.getSession().getServletContext());
//
//            dlgn0100ExcelService = (Dlgn0100ExcelService) wac.getBean("Dlgn0100ExcelService" ); 
//           
//       }
//        
//        final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//        final Map<String, MultipartFile> files = multiRequest.getFileMap();
//        InputStream fis = null; // 2011.11.1 보안점검 후속조치
//        InputStream fis2 = null; // 2011.11.1 보안점검 후속조치
//
//        String sResult = "";
//        
//        Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
//        MultipartFile file;
//
//        while (itr.hasNext()) {
//            Entry<String, MultipartFile> entry = itr.next();
//
//            file = entry.getValue();
//            if (!"".equals(file.getOriginalFilename())) {
//                // 2011.10.07 업로드 파일에 대한 확장자를 체크
//                if (file.getOriginalFilename().endsWith(".xls")
//                        || file.getOriginalFilename().endsWith(".XLS") ) {
//                    
//                  
//                    //2011.10.21 보안점검 후속조치
//                    try {
//                        fis = file.getInputStream();
//                        fis2 = file.getInputStream();
//                      
//                        dlgn0100ExcelService.insertXlsDlgn0100(fis);
//                        dlgn0100ExcelService.insertXlsDlgn0200(fis2);
//                        
//                        sResult =  "success";
//                    } catch(Exception e) {
//                          e.printStackTrace();
//                          
//              	    	/** 에러 로그 **/			
//              	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C",e, windowNm , windowId);
//                        sResult = "error";
//                       
//                    } finally {
//                        if (fis != null)    // 2011.11.1 보안점검 후속조치
//                            fis.close();
//                    }
//                  
//                    
//                    
//                } else  if (  file.getOriginalFilename().endsWith(".xlsx")
//                        || file.getOriginalFilename().endsWith(".XLSX")) {
//                    
//                    //2011.10.21 보안점검 후속조치
//                    try {
//                        fis = file.getInputStream();
//                        fis2 = file.getInputStream();
//                      
//                        dlgn0100ExcelService.insertXSSFDlgn0100(fis);
//                        dlgn0100ExcelService.insertXSSFDlgn0200(fis2);
//                        
//                        sResult =  "success";
//                        
//                    } catch(Exception e) {
//                    	e.printStackTrace();
//                          
//                    	/** 에러 로그 **/			
//                    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C",e, windowNm , windowId);
//                    	sResult = "error";
//                       
//                    } finally {
//                        if (fis != null)    // 2011.11.1 보안점검 후속조치
//                            fis.close();
//                    }
//                    
//                }else{
//                    logger.info("xls, xlsx 파일 타입만 등록이 가능합니다."); 
//                    sResult =  "success";
//                }
//                // *********** 끝 ***********
//            }
//        }
//        
//		/** 로그반영
//		 * CRUDSBLO
//		 * C:create		R:read		U:update
//    	 * D:delete		S:select	B:배치 
//    	 * L:로그인		O:로그아웃
//    	 */
//		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:D:B");
//		
//        return sResult;
// 
//    }   
    
    
    
     

    /**
     * 엑셀파일을 업로드하여  등록한다.
     * @param  MultipartFile, Model, HttpServletRequest
     * @return sResult
     */
    @RequestMapping(value = "/imp/XlsDlgn0100Import.do", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("dlgn0100flUp") MultipartFile file, Model model, final HttpServletRequest request) throws InvalidFormatException, IOException, SAXException {
    	HashMap<String, String> extGlobals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest());	    	
    	String realPath = request.getSession().getServletContext().getRealPath(""); 
    	String xmlConfig = "/upXmlConfig/DLGN/"+extGlobals.get("PayGen.MunicipalitiesName").toLowerCase()+"/Dlgn0100Mapping.xml";
//    	String xmlConfig = File.separator+"upXmlConfig"+File.separator+"DLGN"+File.separator+"Dlgn0100Mapping.xml";
    	Long lResult = new Long(0);		//리턴 결과
    	String sResult = "";			//결과 상태값
    	InputStream inputXML = null;	//XML
    	InputStream inputXLS = null;	//엑셀파일
    				
    	List<Dlgn0110ExlVO> dlgn0110List = new ArrayList<Dlgn0110ExlVO>();
    	Map<String, List> beans = new HashMap<String, List>();
    	
    	beans.put("dlgn0110List", dlgn0110List);
    	
    	try {
    					
    		inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
    		XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
    		inputXLS = new BufferedInputStream(file.getInputStream());

    		XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
    		
    		if(xlsReadStatus.isStatusOK()) {
    			
    			lResult = dlgn0100ExcelService.updateXlsDlgn0100(dlgn0110List, request);
						// TODO Auto-generated tch block
    			
    			if(lResult == 1) {
					sResult =  "success";
				} else {
					sResult =  "error";
				}
    			
    		}else {
    			
    			sResult =  "error";
    		}
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
    		IOUtils.closeQuietly(inputXML);
    		IOUtils.closeQuietly(inputXLS);
    	}
    	
    	return sResult;
	}
//    public String xlsDlgn0100Import(@ModelAttribute("Dlgn0100VO") Dlgn0100VO dlgn0 100Vo,final HttpServletRequest request
//            , Map commandMap , Model model) throws Exception {
//         
////        String sCmd = commandMap.get("dlgn0100flUp") == null ? "" : (String)commandMap.get("dlgn0100flUp");
////        if (sCmd.equals("")) {
////          return;
////        }
//
//        if  (dlgn0100ExcelService == null) { 
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( request.getSession().getServletContext());
//
//            dlgn0100ExcelService = (Dlgn0100ExcelService) wac.getBean("Dlgn0100ExcelService" ); 
//           
//       }
//        
//        final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
//        final Map<String, MultipartFile> files = multiRequest.getFileMap();
//        InputStream fis = null; // 2011.11.1 보안점검 후속조치
//        InputStream fis2 = null; // 2011.11.1 보안점검 후속조치
//
//        String sResult = "";
//        
//        Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
//        MultipartFile file;
//
//        while (itr.hasNext()) {
//            Entry<String, MultipartFile> entry = itr.next();
//
//            file = entry.getValue();
//            if (!"".equals(file.getOriginalFilename())) {
//                // 2011.10.07 업로드 파일에 대한 확장자를 체크
//                if (file.getOriginalFilename().endsWith(".xls")
//                        || file.getOriginalFilename().endsWith(".XLS") ) {
//                    
//                  
//                    //2011.10.21 보안점검 후속조치
//                    try {
//                        fis = file.getInputStream();
//                        fis2 = file.getInputStream();
//                      
//                        dlgn0100ExcelService.insertXlsDlgn0100(fis);
//                        dlgn0100ExcelService.insertXlsDlgn0200(fis2);
//                        
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
//                  
//                    
//                    
//                } else  if (  file.getOriginalFilename().endsWith(".xlsx")
//                        || file.getOriginalFilename().endsWith(".XLSX")) {
//                    
//                    //2011.10.21 보안점검 후속조치
//                    try {
//                        fis = file.getInputStream();
//                        fis2 = file.getInputStream();
//                      
//                        dlgn0100ExcelService.insertXSSFDlgn0100(fis);
//                        dlgn0100ExcelService.insertXSSFDlgn0200(fis2);
//                        
//                       
//                        sResult =  "success";
//                        
//                    } catch(Exception e) {
//                          e.printStackTrace();
//                        sResult = "error";
//                       
//                    } finally {
//                        if (fis != null)    // 2011.11.1 보안점검 후속조치
//                            fis.close();
//                    }
//                    
//                   
//                       
//                    
//                }else{
//                    logger.info("xls, xlsx 파일 타입만 등록이 가능합니다."); 
//                    sResult =  "success";
//                }
//                // *********** 끝 ***********
//               
//            }
//        }
//        return sResult;
// 
//    }
    
    /**
     * 엑셀파일을 업로드하여  등록한다.
     * @param loginVO
     * @param request
     * @param commandMap
     * @param model
     * @return  
     * @throws Exception
     */
    @RequestMapping(value = "/imp/XlsReadDlgn0100Import.do")
    public @ResponseBody String xlsReadDlgn0100Import(@ModelAttribute("Dlgn0100VO") Dlgn0100VO dlgn0100Vo,final HttpServletRequest request
            , Map commandMap , Model model) throws Exception {
    	
    	String method = calledClass + ".xlsReadDlgn0100Import";
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
         
//        String sCmd = commandMap.get("dlgn0100flUp") == null ? "" : (String)commandMap.get("dlgn0100flUp");
//        if (sCmd.equals("")) {
//          return;
//        }
    	
    	
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	
    	
    	HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());

        if  (dlgn0100ExcelService == null) { 
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( request.getSession().getServletContext());

            dlgn0100ExcelService = (Dlgn0100ExcelService) wac.getBean("Dlgn0100ExcelService" ); 
           
       }
        
        String sResult = "";
        String xmlConfig = "/xmlConfig/departments.xml";
        
        String realPath = request.getSession().getServletContext().getRealPath(""); 
        String xmlConfigRelatviePath =   realPath.concat("/".concat(globals.get("PayGen.XLSTemplateLink")).concat(xmlConfig));
        
        
        final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
        final Map<String, MultipartFile> files = multiRequest.getFileMap();
        
        
        InputStream fis = null; // 2011.11.1 보안점검 후속조치 
        XlsToMapReader xlsMapReader  = XlsToMapReader.getInstance();
        
        Map<String, Object> mapRtnData = new HashMap<String, Object>();
        List<Dlgn0100VO>   dlgnRtn0100List = new ArrayList<Dlgn0100VO>();
        Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
        
		String windowNm = "기본근무관리";
		String windowId = "DLGN0100";
        MultipartFile file;

        while (itr.hasNext()) {
            Entry<String, MultipartFile> entry = itr.next();

            file = entry.getValue();
            if (!"".equals(file.getOriginalFilename())) {
                // 2011.10.07 업로드 파일에 대한 확장자를 체크
            	Map<String, Object> mapListData = new HashMap<String, Object>();
                Dlgn0100VO dlgnRtn0100Vo = new Dlgn0100VO();
                
                
                List<Dlgn0100VO> dlgnIn0100List = new ArrayList<Dlgn0100VO>();
                
                
                List listDlgn0100 = new ArrayList<String>();
                
                
                if (file.getOriginalFilename().endsWith(".xls")
                        || file.getOriginalFilename().endsWith(".XLS") ) {
                    
                	
                    //2011.10.21 보안점검 후속조치
                    try {
                        fis = file.getInputStream(); 
                      
                        
                        
                        mapRtnData = xlsMapReader.readXlsExcel(request, xmlConfigRelatviePath,fis ,mapListData);
                        
                        Boolean isStatusOK = (Boolean)mapRtnData.get("isStatusOK");
                        if(isStatusOK){
                        	
                        	
                        	dlgnRtn0100List =  (List<Dlgn0100VO>)mapRtnData.get("dlgn0100List");
                        	
                        	
                        	// 주민등록번호
                	    	for(int i=0; i<dlgnRtn0100List.size(); i++){
                	    		
                	    		dlgn0100Vo = new Dlgn0100VO();
                	    		
                	    		dlgn0100Vo = dlgnRtn0100List.get(i);
                	    		
                	    		
                	    		nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
                	    		dlgn0100Vo.setResnRegnNum(AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0100Vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC));
                	    		
                	    		listDlgn0100.add(dlgn0100Vo);
                	    		
                	    	}
                	    	
                	    	
                	        mapListData.put("dlgn0100List", listDlgn0100);
                        	
							 
//                         	Collection<List<Dlgn0100VO>> cc = beans.values();
//                        	
//                        	for (MtgBankVo userList : beans.get("bankVoList")) {
//                        		mdmUserList.add(userList);
//            				}
                        	//결과값을 받아서 인서트 업데이트 처리한다. 
                            sResult =  "success";
                        } else {
                            sResult = "error";
                        }
                      
                        
                    } catch(Exception e) {
                        e.printStackTrace();
                        sResult = "error";
                        
            	    	/** 에러 로그 **/			
            	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"R",e, windowNm , windowId);
                       
                    } finally {
                        if (fis != null)    // 2011.11.1 보안점검 후속조치
                            fis.close();
                    }
                  
                    
                    
                } else  if (  file.getOriginalFilename().endsWith(".xlsx")
                        || file.getOriginalFilename().endsWith(".XLSX")) {
                    
                    //2011.10.21 보안점검 후속조치
                    try {
                        fis = file.getInputStream();
                        
                        mapRtnData = xlsMapReader.readXlsExcel(request, xmlConfigRelatviePath,fis ,mapListData);
                       
                        Boolean isStatusOK = (Boolean)mapRtnData.get("isStatusOK");
                        if(isStatusOK){
//                        	Collection<List<MtgBankVo>> cc = beans.values();
//                        	
//                        	for (MtgBankVo userList : beans.get("bankVoList")) {
//                        		mdmUserList.add(userList);
//            				}
                        	//결과값을 받아서 인서트 업데이트 처리한다. 
                            sResult =  "success";
                        } else {
                            sResult = "error";
                        }
                        
                    } catch(Exception e) {
                    	e.printStackTrace();
                        sResult = "error";
                        
            	    	/** 에러 로그 **/			
            	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"R",e, windowNm , windowId);

                       
                    } finally {
                        if (fis != null)    // 2011.11.1 보안점검 후속조치
                            fis.close();
                    } 
                       
                    
                }else{
                    logger.info("xls, xlsx 파일 타입만 등록이 가능합니다."); 
                    sResult =  "success";
                }
                // *********** 끝 ***********
               
            }
        }
        
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:D:B");
       
        return sResult;
 
    }
     
}
