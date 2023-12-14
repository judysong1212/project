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
import org.msf.exterms.xls.service.Payr4200ExcelService;
import org.msf.exterms.xls.service.Payr4200TotVO;
import org.msf.exterms.xls.service.Payr4200VO;
import org.msf.utils.SmrmfUtils;
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

import com.app.exterms.payroll.server.vo.Payr0304SrhVO;
import com.app.exterms.payroll.server.vo.Payr0307VO;
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
public class Payr4200ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Payr4200ExcelController.class);  
    private static final String calledClass = Payr4200ExcelController.class.getName();

 
    
    @Resource(name = "payr4200ExcelService")
    private Payr4200ExcelService payr4200ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.(급여대장)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPayr4200Export.do")
    public ModelAndView xlsPayr4200Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsPayr4200Export";
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	Payr0304SrhVO   payr0304SrhVO = new Payr0304SrhVO();
    	List<String> listDeptCd = new ArrayList<String>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	String windowNm = "급여(조정)내역관리";
		String windowId = "PAYR4200";
    	
    	
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());
    	
//        dlgn0250SrhVo.setTypOccucdIn("");
//        dlgn0250SrhVo.setPyspGrdeCdIn("");
//        
//        
//        if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
//                && (ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
//           
//            dlgn0250SrhVo.setTypOccucdIn((sessionUser.getTypOccuCd().concat(sessionUser.getPyspGrdeCd()))); 
//            dlgn0250SrhVo.setPyspGrdeCdIn("1");
//            
//        } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
//                && (!ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
//           
//            dlgn0250SrhVo.setTypOccucdIn((sessionUser.getTypOccuCd().concat(sessionUser.getPyspGrdeCd())));  
//            dlgn0250SrhVo.setPyspGrdeCdIn("1"); 
//            
//        } else { 
//            dlgn0250SrhVo.setTypOccucdIn(""); 
//            dlgn0250SrhVo.setPyspGrdeCdIn("0");
//        }
    	
//         param.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//    	 
//         if (MSFSharedUtils.allowNulls(param.get("payrMangDeptCd")).equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
//    		 param.put("payrMangDeptYn","Y");  //단위기관담당자여부  
//        	 param.put("deptCdArr","");  
//        	 param.put("deptCd","");  
//	     } else { 
//	
//	       	    // List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
//	       	     param.put("deptCdArr",MSFSharedUtils.allowNulls(param.get("deptCd")));    
//	     }
//          
//         // List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
//          param.put("typOccuCdArr",MSFSharedUtils.allowNulls(param.get("typOccuCd")));   
//         
//         // List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
//          param.put("pyspGrdeCdArr",MSFSharedUtils.allowNulls(param.get("pyspGrdeCd")));  
//         
//           
//         // List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
//          param.put("dtilOccuInttnCdArr",MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")));  
    	
		try{
	        /** 조건절 */
	        payr0304SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        payr0304SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        
	        payr0304SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("emymtDivCd")));       //고용구분코드
	        
	
	        payr0304SrhVO.setUsrId(sessionUser.getUsrId());  
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	

	    	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(param.get("deptCd"),sessionUser.getDeptCd()))) {
	    			 

		        	payr0304SrhVO.setDeptCd(sessionUser.getDeptCd()); 
		           listDeptCd.add(sessionUser.getDeptCd());
		           payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
	           	   } else {
	           		 
	           		 payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
                     listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
                     payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	           	  }  
	    	    
	           payr0304SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	     payr0304SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd"))) ;   //단위기관코드 
	                 if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) { 
	                 	 listDeptCd = null; 
	                 	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	                 	payr0304SrhVO.setDeptCd("");  //부서코드
	                 } else {
	                	 payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
	                      payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        
	
	        payr0304SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가  
	        payr0304SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")).replace(",", ""));      
        
//        String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//        if ("FALSE".equals(chkTypOccuCd)) {
//        	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//        	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//        } else {
//        	
//        }
        
       /******************************** 권한 ************************************************************************/
        
//        if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
//        	payr0304SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//        	List<String> listDeptCd = null; 
//        	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//        	payr0304SrhVO.setDeptCd("");     //부서코드
//        } else {
//
//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
//            payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//            payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));     //부서코드 
 //       }
        
        
        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
	        payr0304SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	        payr0304SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("typOccuCd")));  //직종
	       
	//        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
	//        payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	//        payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
	        payr0304SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        payr0304SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); //직종세
	        
	        payr0304SrhVO.setBusinCd(MSFSharedUtils.allowNulls(param.get("businCd")));   //사업코드 
	        
	        payr0304SrhVO.setPayCd(MSFSharedUtils.allowNulls(param.get("payCd")));  //급여구분코드 
	        payr0304SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(param.get("pymtYrMnth"))); //지급년월
	        payr0304SrhVO.setSystemkey(MSFSharedUtils.allowNulls(param.get("systemkey")));  //시스템키
	        payr0304SrhVO.setHanNm(MSFSharedUtils.allowNulls(param.get("hanNm")));    //한글성명 
	       
	        List<Payr4200VO> listPayr4200Vo = payr4200ExcelService.selectXlsPayr4200List(payr0304SrhVO);
	        
	        List listPayr4200 = new ArrayList<String>();
	        
//	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    	for(int i=0; i<listPayr4200Vo.size(); i++){
	    		
	    		Payr4200VO payr4200Vo = new Payr4200VO();
	    		
	    		payr4200Vo = (Payr4200VO) listPayr4200Vo.get(i);
	    		
	    		// TODO 주민번호
	    		nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		payr4200Vo.setResnRegnNum(AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(payr4200Vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC));
	    		
	    		listPayr4200.add(payr4200Vo);
	    		
	    	}
	    	
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPayr4200", listPayr4200);
	             
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
       
        return new ModelAndView("payr4200ExcelView", map);
         
    }
    
    
    /**
     * 엑셀파일로 출력한다.(급여대장) 기간제
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPayr4200Export2.do")
    public ModelAndView xlsPayr4200Export2(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsPayr42001Export";
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	Payr0304SrhVO   payr0304SrhVO = new Payr0304SrhVO();
    	List<String> listDeptCd = new ArrayList<String>();
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	String windowNm = "급여(조정)내역관리";
		String windowId = "PAYR4200";
    	
    	
    	// 1. 암호화 객체 생성
    	
    	
//        dlgn0250SrhVo.setTypOccucdIn("");
//        dlgn0250SrhVo.setPyspGrdeCdIn("");
//        
//        
//        if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
//                && (ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
//           
//            dlgn0250SrhVo.setTypOccucdIn((sessionUser.getTypOccuCd().concat(sessionUser.getPyspGrdeCd()))); 
//            dlgn0250SrhVo.setPyspGrdeCdIn("1");
//            
//        } else if (MSFSharedUtils.paramNotNull((MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd()).concat(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd()))))
//                && (!ExtermsProps.PAY_TYPOCCUCD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getTypOccuCd())) && ExtermsProps.PAY_PYSPGRDECD_01.equals(MSFSharedUtils.allowNulls(sessionUser.getPyspGrdeCd())))) {
//           
//            dlgn0250SrhVo.setTypOccucdIn((sessionUser.getTypOccuCd().concat(sessionUser.getPyspGrdeCd())));  
//            dlgn0250SrhVo.setPyspGrdeCdIn("1"); 
//            
//        } else { 
//            dlgn0250SrhVo.setTypOccucdIn(""); 
//            dlgn0250SrhVo.setPyspGrdeCdIn("0");
//        }
    	
//         param.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//    	 
//         if (MSFSharedUtils.allowNulls(param.get("payrMangDeptCd")).equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
//    		 param.put("payrMangDeptYn","Y");  //단위기관담당자여부  
//        	 param.put("deptCdArr","");  
//        	 param.put("deptCd","");  
//	     } else { 
//	
//	       	    // List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
//	       	     param.put("deptCdArr",MSFSharedUtils.allowNulls(param.get("deptCd")));    
//	     }
//          
//         // List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
//          param.put("typOccuCdArr",MSFSharedUtils.allowNulls(param.get("typOccuCd")));   
//         
//         // List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
//          param.put("pyspGrdeCdArr",MSFSharedUtils.allowNulls(param.get("pyspGrdeCd")));  
//         
//           
//         // List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
//          param.put("dtilOccuInttnCdArr",MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")));  
    	
		try{
	        /** 조건절 */
	        payr0304SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        payr0304SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        
	        payr0304SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("emymtDivCd")));       //고용구분코드
	        
	
	        payr0304SrhVO.setUsrId(sessionUser.getUsrId());  
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	

	    	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(param.get("deptCd"),sessionUser.getDeptCd()))) {

		        	payr0304SrhVO.setDeptCd(sessionUser.getDeptCd()); 
		           listDeptCd.add(sessionUser.getDeptCd());
		           payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
	                    
	           	   } else {
	           		 
	           		 payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
                     listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
                     payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	           	  }  
	    	    
	           payr0304SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	     payr0304SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd"))) ;   //단위기관코드 
	                 if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) { 
	                 	 listDeptCd = null; 
	                 	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	                 	payr0304SrhVO.setDeptCd("");  //부서코드
	                 } else {
	                	 payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
	                      payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        
	
	        payr0304SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가  
	        payr0304SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")).replace(",", ""));      
        
//        String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//        if ("FALSE".equals(chkTypOccuCd)) {
//        	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//        	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//        } else {
//        	
//        }
        
       /******************************** 권한 ************************************************************************/
        
//        if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
//        	payr0304SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//        	List<String> listDeptCd = null; 
//        	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//        	payr0304SrhVO.setDeptCd("");     //부서코드
//        } else {
//
//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
//            payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//            payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));     //부서코드 
 //       }
        
        
        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
	        payr0304SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	        payr0304SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("typOccuCd")));  //직종
	       
	//        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
	//        payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	//        payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
	        payr0304SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        payr0304SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); //직종세
	        
	        payr0304SrhVO.setBusinCd(MSFSharedUtils.allowNulls(param.get("businCd")));   //사업코드 
	        
	        payr0304SrhVO.setPayCd(MSFSharedUtils.allowNulls(param.get("payCd")));  //급여구분코드 
	        payr0304SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(param.get("pymtYrMnth"))); //지급년월
	        payr0304SrhVO.setSystemkey(MSFSharedUtils.allowNulls(param.get("systemkey")));  //시스템키
	        payr0304SrhVO.setHanNm(MSFSharedUtils.allowNulls(param.get("hanNm")));    //한글성명 
	        payr0304SrhVO.setPayYr(MSFSharedUtils.allowNulls(param.get("payYr")));
	        payr0304SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(param.get("mangeDeptCd")));    //관리부서 
	        payr0304SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(param.get("repbtyBusinDivCd")) ); //호봉제구분
	        
	        EgovMap listPayr42001 = payr4200ExcelService.selectXlsPayr4200List1(payr0304SrhVO);
	        
	        List<EgovMap> listPayr4200 = payr4200ExcelService.selectXlsPayr4200List2(payr0304SrhVO);
	        
	    
	        
	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
	    	List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listPayr4200.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listPayr4200.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}
	    	
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPayr4200", excelList);
	        map.put("year", payr0304SrhVO.getPayYr());
	        map.put("month",  param.get("payMonth"));
	        map.put("deptNm", param.get("deptNm"));
	        map.put("rflctnEndDt", listPayr42001.get("rflctnEndDt"));
	        map.put("rflctnBgnnDt", listPayr42001.get("rflctnBgnnDt"));
	        
	        
	             
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
       
        return new ModelAndView("payr42002ExcelView", map);
         
    }
      
    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPayr4200TotExport.do")
    public ModelAndView xlsPayr4200TotExport(@RequestParam HashMap<String, String> param, HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsPayr4200TotExport";
    	
    	String windowNm = "급여(조정)내역관리";
		String windowId = "PAYR4200";
    	
    	Payr0304SrhVO   payr0304SrhVO = new Payr0304SrhVO();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        Map<String, Object> map = new HashMap<String, Object>();
        
        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	

//    	param.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//    	
//        
//        if (MSFSharedUtils.allowNulls(param.get("payrMangDeptCd")).equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
//    		 param.put("payrMangDeptYn","Y");  //단위기관담당자여부  
//        	 param.put("deptCdArr","");  
//        	 param.put("deptCd","");  
//        } else { 
//
//       	    // List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
//       	     param.put("deptCdArr",MSFSharedUtils.allowNulls(param.get("deptCd")));    
//        }
//    	  
//    	
//         
//        // List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
//         param.put("typOccuCdArr",MSFSharedUtils.allowNulls(param.get("typOccuCd")));   
//        
//        // List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
//         param.put("pyspGrdeCdArr",MSFSharedUtils.allowNulls(param.get("pyspGrdeCd")));  
//        
//          
//        // List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
//         param.put("dtilOccuInttnCdArr",MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")));  
        List<String> listDeptCd = new ArrayList<String>();
        
		try{
			
	        /** 조건절 */
	        payr0304SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        payr0304SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	       
	        payr0304SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("emymtDivCd")));       //고용구분코드
	        

	        payr0304SrhVO.setUsrId(sessionUser.getUsrId());  
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	

	    	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(param.get("deptCd"),sessionUser.getDeptCd()))) {
	    			 

		        	payr0304SrhVO.setDeptCd(sessionUser.getDeptCd()); 
		           listDeptCd.add(sessionUser.getDeptCd());
		           payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
	           	   } else {
	           		 
	           		 payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
                     listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
                     payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	           	  }  
	    	      
	           payr0304SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	 payr0304SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd"))) ;   //단위기관코드
	                 if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) { 
	                 	 listDeptCd = null; 
	                 	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	                 	payr0304SrhVO.setDeptCd("");  //부서코드
	                 } else {
	                	 payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
	                      payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        

	        payr0304SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가  
	        payr0304SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")).replace(",", ""));      
	         
	       /******************************** 권한 ************************************************************************/
	        
//	        if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
//	        	payr0304SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//	        	List<String> listDeptCd = null; 
//	        	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//	        	payr0304SrhVO.setDeptCd("");     //부서코드
//	        } else {
	//
//	            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
//	            payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//	            payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));     //부서코드 
//	        }
	        
	        
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
	        payr0304SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	        payr0304SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("typOccuCd")));  //직종
	       
	        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
	        payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	        payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
	        payr0304SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        payr0304SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); //직종세
	        
	        payr0304SrhVO.setBusinCd(MSFSharedUtils.allowNulls(param.get("businCd")));   //사업코드 
	        
	        payr0304SrhVO.setPayCd(MSFSharedUtils.allowNulls(param.get("payCd")));  //급여구분코드 
	        payr0304SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(param.get("pymtYrMnth"))); //지급년월
	        payr0304SrhVO.setSystemkey(MSFSharedUtils.allowNulls(param.get("systemkey")));  //시스템키
	        payr0304SrhVO.setHanNm(MSFSharedUtils.allowNulls(param.get("hanNm")));    //한글성명 
	        payr0304SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(param.get("mangeDeptCd")));    //관리부서 
	        payr0304SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(param.get("repbtyBusinDivCd")) ); //호봉제구분

	        
	        List<Payr4200TotVO> listTotPayr4200Vo = payr4200ExcelService.selectXlsTotPayr4200List(payr0304SrhVO);
	        
	        List listTotPayr4200 = new ArrayList<String>();
	        
	    	for(int i=0; i<listTotPayr4200Vo.size(); i++){
	    		
	    		Payr4200TotVO payr4200TotVo = new Payr4200TotVO();
	    		
	    		payr4200TotVo = (Payr4200TotVO) listTotPayr4200Vo.get(i);
	    		
	    		
	    		// TODO 주민번호
	    		nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		payr4200TotVo.setResnRegnNum(AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(payr4200TotVo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC));
	    		
	    		listTotPayr4200.add(payr4200TotVo);
	    		
	    	}
	    	
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listTotPayr4200", listTotPayr4200);  
	        
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
       
        return new ModelAndView("payr4200TotExcelView", map);
         
    }
    
    
//    /**
//     * 엑셀파일로 출력한다. (양식)
//     * @param searchVO 검색조건
//     * @return 엑셀파일
//     * @throws Exception
//     */
//    @RequestMapping(value="/exp/XlsFormPayr4200Export.do")
//    public ModelAndView xlsPsnl0126Export(@ModelAttribute("Payr0304SrhVO") Payr0304SrhVO payr0304SrhVO, HttpServletRequest request, ModelMap model) 
//                    throws Exception { 
//       
//        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//        
//        /** 조건절 */
//        payr0304SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//        payr0304SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//        payr0304SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(payr0304SrhVO.getPayrMangDeptCd())) ;   //단위기관코드
//        payr0304SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(payr0304SrhVO.getEmymtDivCd()));       //고용구분코드
//        
//        
//        if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(payr0304SrhVO.getDeptCd()))) {
//        	payr0304SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//        	List<String> listDeptCd = null; 
//        	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//        	payr0304SrhVO.setDeptCd("");     //부서코드
//        } else {
//
//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr0304SrhVO.getDeptCd()));  
//            payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//            payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(payr0304SrhVO.getDeptCd()));     //부서코드 
//        }
//        
//        
//        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr0304SrhVO.getTypOccuCd())); 
//        payr0304SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
//        payr0304SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(payr0304SrhVO.getTypOccuCd()));  //직종
//       
//        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr0304SrhVO.getPyspGrdeCd())); 
//        payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//        payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(payr0304SrhVO.getPyspGrdeCd())); //호봉등급코드
//         
//        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr0304SrhVO.getDtilOccuInttnCd())); 
//        payr0304SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//        payr0304SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(payr0304SrhVO.getDtilOccuInttnCd())); //직종세
//        
//        payr0304SrhVO.setBusinCd(MSFSharedUtils.allowNulls(payr0304SrhVO.getBusinCd()));   //사업코드 
//        
//        payr0304SrhVO.setPayCd(MSFSharedUtils.allowNulls(payr0304SrhVO.getPayCd()));  //급여구분코드 
//        payr0304SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(payr0304SrhVO.getPymtYrMnth())); //지급년월
//        payr0304SrhVO.setSystemkey(MSFSharedUtils.allowNulls(payr0304SrhVO.getSystemkey()));  //시스템키
//        payr0304SrhVO.setHanNm(MSFSharedUtils.allowNulls(payr0304SrhVO.getHanNm()));    //한글성명 
//        
//        //List  listFilePayr4200 = payr4200ExcelService.selectXlsFilePayr304ToPayr4200List(payr0304SrhVO);
//        
////        Map<String, Object> map = new HashMap<String, Object>();
////        map.put("listFilePayr4200", listFilePayr4200);
//        
//        
//        return new ModelAndView("Payr0307ToPayr4200ExcelView", map);
//         
//    }
    
    
    /**
     * 엑셀파일로 출력한다.(양식)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsJxlsPayr4200Export.do")
    public ModelAndView xlsPayr4200FormExport(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
      
    	
    	String method = calledClass + ".xlsPayr4200FormExport";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>();
        Payr0304SrhVO   payr0304rhVo = new Payr0304SrhVO();
        Map<String, Object> map = new HashMap<String, Object>();
        

    	String windowNm = "급여(조정)내역관리";
    	String windowId = "PAYR4200";
        
        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
		try{
        
	        /** 조건절 */
	        payr0304rhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        payr0304rhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        payr0304rhVo.setUsrId(sessionUser.getUsrId());  
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	

	    	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(param.get("deptCd"),sessionUser.getDeptCd()))) {

		        	payr0304rhVo.setDeptCd(sessionUser.getDeptCd()); 
		           listDeptCd.add(sessionUser.getDeptCd());
		           payr0304rhVo.setDeptCdArr(listDeptCd);     //부서코드    
	                    
	           	   } else {
	           		 
	           		payr0304rhVo.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
                    listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
                    payr0304rhVo.setDeptCdArr(listDeptCd);     //부서코드   
	           	  }  
	    	    
	           payr0304rhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	payr0304rhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd"))) ;   //단위기관코드
	                 if (payr0304rhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) { 
	                 	 listDeptCd = null; 
	                 	payr0304rhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	payr0304rhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 payr0304rhVo.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
	                      payr0304rhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	        }
	        
	
	        payr0304rhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가  
	        payr0304rhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")).replace(",", ""));      
	         
	       /******************************** 권한 ************************************************************************/
	        payr0304rhVo.setPayCd(MSFSharedUtils.allowNulls(param.get("payCd")));  			//급여구분코드 
	        
	        payr0304rhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("emymtDivCd")));	//고용구분코드
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
	        payr0304rhVo.setTypOccuCdArr(lstTypeOccuCd); 
	        payr0304rhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("typOccuCd")));  	//직종
	       
	//        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
	//        payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	//        payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
	         
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
	        payr0304rhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        payr0304rhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); //직종세
	        
	        payr0304rhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("businCd")));   			//사업코드 
	        payr0304rhVo.setPymtYrMnth(MSFSharedUtils.allowNulls(param.get("pymtYrMnth"))); 		//지급년월
	        payr0304rhVo.setSystemkey(MSFSharedUtils.allowNulls(param.get("systemkey")));  			//시스템키
	        payr0304rhVo.setHanNm(MSFSharedUtils.allowNulls(param.get("hanNm")));   		 		//한글성명 
	        payr0304rhVo.setPymtDducDivCd(MSFSharedUtils.allowNulls(param.get("pymtDducDivCd")));	//지급공제구분
	        payr0304rhVo.setPayDducExtpyCd(MSFSharedUtils.allowNulls(param.get("payDducExtpyCd")));	//지급공제항목
	       
	        List listPayr0307 = payr4200ExcelService.selectXlsFilePayr304_307ToPayr4200List(payr0304rhVo);
	        
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listPayr0307.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPayr0307.get(i);
	    		
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
		    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("payFamyResnRegnNum", strValue);
	    			
	    		excelList.add(eMap);
	    	}
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPayr0307", excelList);
	        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
	//		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
        
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        }
       
        return new ModelAndView("payr307ToPayr4200ExcelView", map);
    }
      
 
//    /**
//     * 엑셀파일로 출력한다.
//     * @param searchVO 검색조건
//     * @return 엑셀파일
//     * @throws Exception
//     */
//    @RequestMapping(value="/exp/XlsJxlsPayr4200Export.do")
//    public ModelAndView xlsPayr4200FormExport(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
//                    throws Exception { 
//      
//    	Payr0304SrhVO   payr0304SrhVO = new Payr0304SrhVO();
//    	
//        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
//        List<String> listDeptCd = new ArrayList<String>();
//        /** 조건절 */
//        payr0304SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//        payr0304SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//       
//        payr0304SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("emymtDivCd")));       //고용구분코드
//        
//        payr0304SrhVO.setUsrId(sessionUser.getUsrId());  
//        /******************************** 권한 ************************************************************************/
//        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//        if ("FALSE".equals(chkDeptCd)) {
//        	payr0304SrhVO.setDeptCd(sessionUser.getDeptCd()); 
//           listDeptCd.add(sessionUser.getDeptCd());
//           payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
//           payr0304SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//        } else {
//        	    
//        	 payr0304SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd"))) ;   //단위기관코드
//                 if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) { 
//                 	 listDeptCd = null; 
//                 	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//                 	payr0304SrhVO.setDeptCd("");  //부서코드
//                 } else {
//                	 payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));
//                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
//                      payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
//                 } 
//              
//        }
//        
//
//        payr0304SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가  
//        payr0304SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")).replace(",", ""));      
//         
//       /******************************** 권한 ************************************************************************/
//        
////        if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) {
////        	payr0304SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
////        	List<String> listDeptCd = null; 
////        	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
////        	payr0304SrhVO.setDeptCd("");     //부서코드
////        } else {
////
////            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
////            payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
////            payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));     //부서코드 
////        }
//        
//        
//        
//        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
//        payr0304SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
//        payr0304SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("typOccuCd")));  //직종
//       
////        List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
////        payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
////        payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
//         
//        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
//        payr0304SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//        payr0304SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); //직종세
//        
//        payr0304SrhVO.setBusinCd(MSFSharedUtils.allowNulls(param.get("businCd")));   //사업코드 
//        
//        payr0304SrhVO.setPayCd(MSFSharedUtils.allowNulls(param.get("payCd")));  //급여구분코드 
//        payr0304SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(param.get("pymtYrMnth"))); //지급년월
//        payr0304SrhVO.setSystemkey(MSFSharedUtils.allowNulls(param.get("systemkey")));  //시스템키
//        payr0304SrhVO.setHanNm(MSFSharedUtils.allowNulls(param.get("hanNm")));    //한글성명 
//       
//        List listPayr4200 = payr4200ExcelService.selectXlsFilePayr304_307ToPayr4200List(payr0304SrhVO);
//        
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("listPayr4200", listPayr4200);
//       
//        return new ModelAndView("payr307ToPayr4200ExcelView", map);
//    }
    
    
    /**
     * 엑셀파일을 업로드한다.(Jxls)
     * @param MultipartFile, Model, HttpServletRequest
     * @return sResult
     * @throws InvalidFormatException, IOException, SAXException
     */
    @RequestMapping(value = "/imp/XlsReadPayr4200Import.do", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("payr4200flUp") MultipartFile file,
			Model model, final HttpServletRequest request, final HttpServletResponse response) throws InvalidFormatException, IOException, SAXException {
    	
    	String realPath = request.getSession().getServletContext().getRealPath(""); 
    	String xmlConfig = "/upXmlConfig/PAYR/Payr4200Mapping.xml";
    	
    	String windowNm = "급여(조정)내역관리";
		String windowId = "PAYR4200";
		
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	String method = calledClass + ".handleFormUpload";
    	
    	
    	String sResult = "";			//결과 상태값
    	InputStream inputXML = null;	//XML
		InputStream inputXLS = null;	//엑셀파일
//		FileInputStream inputfis = null;
		
		List<Payr0307VO> payr0307List = new ArrayList<Payr0307VO>();
		Map<String, List> beans = new HashMap<String, List>();
		
	    beans.put("payr0307List", payr0307List);
//	    System.out.println("xml 어디 " + upXmlConfig);
		
		try {
			
			inputXML = new BufferedInputStream(new FileInputStream(realPath.concat("/WEB-INF" + xmlConfig)));
			XLSReader mainReader = ReaderBuilder.buildFromXML(inputXML);
			inputXLS = new BufferedInputStream(file.getInputStream());
			
			XLSReadStatus xlsReadStatus = mainReader.read(inputXLS, beans);
			
			if(xlsReadStatus.isStatusOK()) {
				
				
				long result ;
				
				
				if( payr0307List == null || payr0307List.size() <= 0 ){
					PrgmComUtils.responseAlert(response, "엑셀 필수값을 확인해주세요." );
				}else{
					
					long excelCount = payr0307List.size();
					
					//엑셀 업로드 서비스 호출(delete 후에 insert함)
					result = payr4200ExcelService.updateXlsPayr0307To4200(payr0307List, request);
					
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
//				//해당 데이터 DELETE 후 INSERT 
//				payr4200ExcelService.updateXlsPayr0307To4200(payr0307List, request);
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
//			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C:U:D:B");
			
		}catch(Exception e) {
			
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:C:U:D:B",e, windowNm , windowId);
			
		}finally {
			IOUtils.closeQuietly(inputXML);
			IOUtils.closeQuietly(inputXLS);
 		}
		return sResult;
	}
    
}
