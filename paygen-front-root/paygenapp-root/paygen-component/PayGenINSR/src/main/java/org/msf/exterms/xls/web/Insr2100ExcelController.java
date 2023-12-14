package org.msf.exterms.xls.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Insr2100ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.insurance.server.vo.Insr1100VO;
import com.app.exterms.insurance.server.vo.Insr1200SrhVO;
import com.app.exterms.insurance.server.vo.Insr1550SrhVO;
import com.app.exterms.insurance.server.vo.Insr1550VO;
import com.app.exterms.insurance.server.vo.Insr1600VO;
import com.app.smrmf.core.msfmainapp.client.MSFMainApp;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.widget.MessageBox;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Insr2100ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Insr2100ExcelController.class);  
    private static final String calledClass = Insr2100ExcelController.class.getName();
 
    
    @Resource(name = "insr2100ExcelService")
    private Insr2100ExcelService insr2100ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsFileInsr2100Export.do")   
    public ModelAndView xlsInsr2100Export(@ModelAttribute("Insr1200SrhVO") Insr1200SrhVO insr1200SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception {  
       
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
    	String method = calledClass + ".xlsInsr2100Export";
    	
    	Long result = 0L;
    	Map<String, Object> map = new HashMap<String, Object>(); 
    	String valDiv = "";
    	List listInsr1200 = new ArrayList();
    	List<EgovMap> excelList = new ArrayList<EgovMap>();
    	
    	String windowNm = "사회보험자격취득신고";
		String windowId = "INSRP2100";
    	
    	try{
    		
	        insr1200SrhVo.setUsrId(sessionUser.getUsrId());  
	        insr1200SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        insr1200SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			insr1200SrhVo.setSoctyInsurCmptnDt01(MSFSharedUtils.allowNulls(insr1200SrhVo.getSoctyInsurCmptnDt01()));
			insr1200SrhVo.setSoctyInsurCmptnDt02(MSFSharedUtils.allowNulls(insr1200SrhVo.getSoctyInsurCmptnDt02()));
			
			
			
			List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1200SrhVo.getHdofcCodtnCd())); 
			insr1200SrhVo.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태
			insr1200SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(insr1200SrhVo.getEmymtDivCd()));	         //고용구분
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1200SrhVo.getTypOccuCd())); 
	        insr1200SrhVo.setTypOccuCdArr(lstTypeOccuCd); //직종       
	     	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1200SrhVo.getDtilOccuInttnCd())); 
	     	insr1200SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세
	     	insr1200SrhVo.setBusinCd(MSFSharedUtils.allowNulls(insr1200SrhVo.getBusinCd()));   //사업
	        
	        insr1200SrhVo.setHanNm(MSFSharedUtils.allowNulls(insr1200SrhVo.getHanNm()));			//성명
	        insr1200SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(insr1200SrhVo.getResnRegnNum()));//주민번호
	        
	        insr1200SrhVo.setSystemkey(MSFSharedUtils.allowNulls(insr1200SrhVo.getSystemkey()));	//시스템키
	        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1200SrhVo.getSystemkey())); 
	        insr1200SrhVo.setSystemKeyArr(systemKeyArr); 
	        
	        insr1200SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr1200SrhVo.getPayrMangDeptCd()));  
	    	insr1200SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr1200SrhVo.getPayrMangDeptCd()));
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	insr1200SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           insr1200SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           insr1200SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	
	                 if (insr1200SrhVo.getPayrMangDeptCd().equals(insr1200SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	insr1200SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	insr1200SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 insr1200SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr1200SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1200SrhVo.getDeptCd()));  
	                      insr1200SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        insr1200SrhVo.setDeptCdAuth(insr1200SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        insr1200SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr1200SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	        
	       /******************************** 권한 ************************************************************************/
	        Insr1550VO insr1550Vo = new Insr1550VO();
//	        List listInsr1200 = insr2100ExcelService.selectXlsInsr1200List(insr1200SrhVo);
	        listInsr1200 = insr2100ExcelService.selectXlsInsr1200List(insr1200SrhVo);
	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	       

	    	for(int i=0; i<listInsr1200.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listInsr1200.get(i);
	    		// TODO 주민번호
	    		//nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("socnsrAqtnRegVal03")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("socnsrAqtnRegVal03", strValue);
	    		excelList.add(eMap);
	    	}
	        
	        
	        
	        
//	        Long result = 0L;
//	        result = 0L;
//	        String valDiv = insr1200SrhVo.getValDiv();
	        valDiv = insr1200SrhVo.getValDiv();
	        
	       // System.out.println(">>>>>>>>>>>>>>>>>>>>valDiv "+valDiv);
//	        Map<String, Object> map = new HashMap<String, Object>(); 
	        map = new HashMap<String, Object>(); 
	        
	        //마스터 업데이트
	        for(int i=0; i<listInsr1200.size(); i++){
	        	result = 0L;
	        	EgovMap eMap = (EgovMap)listInsr1200.get(i);
	        	
	          	 //피부양자 업데이트
	        	BigDecimal bigDecimal =  (BigDecimal) eMap.get("socInsrAqtnEmymtNum");
	        	
	   	        insr1550Vo.setDpobCd((String)eMap.get("dpobCd"));
	   	        insr1550Vo.setSystemkey(MSFSharedUtils.allowNulls(eMap.get("systemkey")));
	   	        insr1550Vo.setFamyAqtnLssNum(bigDecimal.longValue());    /** column 피부양자취득상실_고용일련번호 : famyAqtnLssNum */
	   	        insr1550Vo.setSocrAqtnFamyYn("Y");
	   	        insr1550Vo.setFamyQuftDivCd("I0100001");
	   	        insr1550Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
	   	        insr1550Vo.setRevnAddr(request.getRemoteAddr());    /** column 수정주소 : revnAddr */
	   	        if(0 < insr2100ExcelService.selectInsr1550Check(insr1550Vo)){
	   	        	insr2100ExcelService.updateXlsInsr1550(insr1550Vo);
	   	        }
	   	        
	   	        Insr1100VO insr1100Vo = new  Insr1100VO();
	   	        insr1100Vo.setDpobCd((String)eMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
	   	        insr1100Vo.setSystemkey(MSFSharedUtils.allowNulls(eMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
	   	        insr1100Vo.setSocInsrAqtnEmymtNum(bigDecimal.longValue());    /** column 사회보험상실_고용_일련번호 : socInsrAqtnEmymtNum */
	   	        insr1100Vo.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls(eMap.get("soctyInsurCmptnDt")));	/*사회보험작성일자*/       
	   	        insr1100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
	   	        insr1100Vo.setRevnAddr(request.getRemoteAddr());
	     	
	   	     if( "all".equals(valDiv) ){
	        		insr1100Vo.setNatPennRegrstYn((String) eMap.get("natPennRegrstYn"));    /** column 국민연금신고여부 : natPennRegrstYn */
	        		insr1100Vo.setHlthInsrRegrstYn((String) eMap.get("hlthInsrRegrstYn"));    /** column 건강보험신고여부 : hlthInsrRegrstYn */
	        		insr1100Vo.setUmytInsrRegrstYn((String) eMap.get("umytInsrRegrstYn"));    /** column 고용보험신고여부 : umytInsrRegrstYn */
	        		insr1100Vo.setIdtlAccdtRegrstYn((String) eMap.get("idtlAccdtRegrstYn"));    /** column 산재보험신고여부 : idtlAccdtRegrstYn */
	
	        		result = insr2100ExcelService.updateXlsInsr1100(insr1100Vo);
	        		
	        	}else{
	        		if("1".equals(valDiv)){
	        			insr1100Vo.setNatPennRegrstYn((String) eMap.get("natPennRegrstYn"));    /** column 국민연금신고여부 : natPennRegrstYn */
	        		}else if("2".equals(valDiv)){
	        			insr1100Vo.setHlthInsrRegrstYn((String) eMap.get("hlthInsrRegrstYn"));    /** column 건강보험신고여부 : hlthInsrRegrstYn */
	        		}else if("3".equals(valDiv)){
	        			insr1100Vo.setUmytInsrRegrstYn((String) eMap.get("umytInsrRegrstYn"));    /** column 고용보험신고여부 : umytInsrRegrstYn */
	        		}else if("4".equals(valDiv)){
	        			insr1100Vo.setIdtlAccdtRegrstYn((String) eMap.get("idtlAccdtRegrstYn"));    /** column 산재보험신고여부 : idtlAccdtRegrstYn */
	        		}
	        		result = insr2100ExcelService.updateXlsInsr1100Each(insr1100Vo);
	        	}
	        	
	        	if (result == 0) {
	        		MessageBox.alert(MSFMainApp.MSFCONSTANTS.Errore(), 
	        				"처리가 완료되지 않았습니다. 데이타를 확인하십시요.", null);
	        		break;
	        	} 
	        }
	        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			////MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:U");
        
    	}catch(Exception e) {
    		e.printStackTrace();
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:U",e, windowNm , windowId);
    		
    	}
        
        
        if (result == 0) {
        	map.put("gubun",valDiv);
        	return new ModelAndView("insr2100ExcelView", map);
        }else{
        	map.put("listInsr1200", excelList);
        	map.put("valDiv",valDiv);
        	return new ModelAndView("insr2100ExcelView", map);
        }
        
    }
    
    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsFileInsr2100_1550Export.do")   
    public ModelAndView xlsInsr1550Export(@ModelAttribute("Insr1550SrhVO") Insr1550SrhVO insr1550SrhVo,HttpServletRequest request ,ModelMap model) 
    		throws Exception {  

    	String method = calledClass + ".xlsInsr1550Export";
    	
    	String windowNm = "사회보험자격취득신고";
		String windowId = "INSRP2100";
		

    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	List<String> listDeptCd = new ArrayList<String>(); 
    	Map<String, Object> map = new HashMap<String, Object>(); 
    	List<EgovMap> excelList = new ArrayList<EgovMap>();
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	
    	
    	insr1550SrhVo.setUsrId(sessionUser.getUsrId());  
    	insr1550SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
    	insr1550SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
    	insr1550SrhVo.setSoctyInsurCmptnDt01(MSFSharedUtils.allowNulls(insr1550SrhVo.getSoctyInsurCmptnDt01()));
    	insr1550SrhVo.setSoctyInsurCmptnDt02(MSFSharedUtils.allowNulls(insr1550SrhVo.getSoctyInsurCmptnDt02()));
    	insr1550SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(insr1550SrhVo.getEmymtDivCd()));	         //고용구분

    	

    	List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1550SrhVo.getHdofcCodtnCd())); 
    	insr1550SrhVo.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태

    	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1550SrhVo.getTypOccuCd())); 
    	insr1550SrhVo.setTypOccuCdArr(lstTypeOccuCd); //직종       
    	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1550SrhVo.getDtilOccuInttnCd())); 
    	insr1550SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세
    	insr1550SrhVo.setBusinCd(MSFSharedUtils.allowNulls(insr1550SrhVo.getBusinCd()));   //사업        
    	insr1550SrhVo.setHanNm(MSFSharedUtils.allowNulls(insr1550SrhVo.getHanNm()));			//성명
    	//insr1550SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(insr1550SrhVo.getResnRegnNum()));//주민번호
    	insr1550SrhVo.setSystemkey(MSFSharedUtils.allowNulls(insr1550SrhVo.getSystemkey()));	//시스템키
    	List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1550SrhVo.getSystemkey())); 
    	insr1550SrhVo.setSystemKeyArr(systemKeyArr); 

    	insr1550SrhVo.setApplyAqtnLssYn(MSFSharedUtils.allowNulls(insr1550SrhVo.getApplyAqtnLssYn())) ;   //취득상실 미선택시 신고여부
    	insr1550SrhVo.setApplyAqtnYn(MSFSharedUtils.allowNulls(insr1550SrhVo.getApplyAqtnYn())) ;         //취득 선택시 신고여부
    	insr1550SrhVo.setApplyLssYn(MSFSharedUtils.allowNulls(insr1550SrhVo.getApplyLssYn())) ;           //상실 선택시 신고여부
    	String famyQuftDivCd = MSFSharedUtils.allowNulls(insr1550SrhVo.getFamyQuftDivCd());
    	insr1550SrhVo.setFamyQuftDivCd(MSFSharedUtils.allowNulls(insr1550SrhVo.getFamyQuftDivCd())); //취득상실

    	//System.out.println("famyQuftDivCd : "+famyQuftDivCd);

    	if(famyQuftDivCd != null && !famyQuftDivCd.equals("")){
    		if(famyQuftDivCd.equals("I0100001")) insr1550SrhVo.setFamyQuftDivCdAqtn(famyQuftDivCd);
    		else if(famyQuftDivCd.equals("I0100002")) insr1550SrhVo.setFamyQuftDivCdLss(famyQuftDivCd);
    	}

    	insr1550SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr1550SrhVo.getPayrMangDeptCd()));  
    	insr1550SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr1550SrhVo.getPayrMangDeptCd()));
    	/******************************** 권한 ************************************************************************/
    	String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
    	if ("FALSE".equals(chkDeptCd)) {
    		insr1550SrhVo.setDeptCd(sessionUser.getDeptCd()); 
    		listDeptCd.add(sessionUser.getDeptCd());
    		insr1550SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
    		insr1550SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
    	} else {    
    		if (insr1550SrhVo.getPayrMangDeptCd().equals(insr1550SrhVo.getDeptCd())) { 
    			listDeptCd = null; 
    			insr1550SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
    			insr1550SrhVo.setDeptCd("");  //부서코드
    		} else {
    			insr1550SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr1550SrhVo.getDeptCd()));
    			listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1550SrhVo.getDeptCd()));  
    			insr1550SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
    		} 

    	}  
    	insr1550SrhVo.setDeptCdAuth(insr1550SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
    	insr1550SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr1550SrhVo.getDtilOccuInttnCd()).replace(",", ""));

    	/******************************** 권한 ************************************************************************/

    	if(famyQuftDivCd.equals("I0100001")){
    		
        	try{
        		
        		List<EgovMap> InsrList = insr2100ExcelService.selectXlsInsr1550List(insr1550SrhVo);

        		for(int i=0; i<InsrList.size(); i++){
        			Insr1550VO insr1550Vo = new  Insr1550VO();
        			EgovMap eMap = (EgovMap) InsrList.get(i);
        			BigDecimal famySeilNum =  (BigDecimal) eMap.get("famySeilNum");	
        			insr1550Vo.setFamySeilNum(famySeilNum.longValue());
        			insr1550Vo.setDpobCd((String) eMap.get("dpobCd"));
        			insr1550Vo.setSystemkey((String) eMap.get("systemkey"));
        			BigDecimal famyAqtnLssNum =  (BigDecimal) eMap.get("famyAqtnLssNum");	
        			insr1550Vo.setFamyAqtnLssNum(famyAqtnLssNum.longValue());
        			insr1550Vo.setFamyQuftDivCd((String) eMap.get("famyQuftDivCd"));
        			insr1550Vo.setSocrAqtnFamyYn("Y");
        			insr1550Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
        			insr1550Vo.setRevnAddr(request.getRemoteAddr());    /** column 수정주소 : revnAddr */
        			insr2100ExcelService.updateXlsInsr2150ToInsr1550(insr1550Vo);
        		}
        		
        		for(int i=0; i<InsrList.size(); i++){
    	    		EgovMap eMap  = new EgovMap();
    	    		eMap = (EgovMap) InsrList.get(i);
    	    		// TODO 주민번호
    	    		//nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	    		String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
    	    		String strValue2 = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("famyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
    	    		eMap.put("resnRegnNum", strValue);
    	    		eMap.put("famyResnRegnNum", strValue2);
    	    		excelList.add(eMap);
    	    	}
        		
        		
//        		Map<String, Object> map = new HashMap<String, Object>(); 
        		map = new HashMap<String, Object>(); 
        		map.put("listInsr1550", excelList);
        		
        	}catch(Exception e){
        		e.printStackTrace();
    	    	/** 에러 로그 **/			
    	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:U",e, windowNm , windowId);
        	}
    		
    		return new ModelAndView("insr2100_1550ExcelView", map);

    	}else{
    		
    		try{

	    		List<EgovMap> InsrList = insr2100ExcelService.selectXlsInsr1600List(insr1550SrhVo);
	
	    		for(int i=0; i<InsrList.size(); i++){
	    			Insr1600VO insr1600Vo = new  Insr1600VO();
	    			EgovMap eMap = (EgovMap) InsrList.get(i);
	    			BigDecimal famySeilNum =  (BigDecimal) eMap.get("famySeilNum");	
	    			insr1600Vo.setFamySeilNum(famySeilNum.longValue());
	    			insr1600Vo.setDpobCd((String) eMap.get("dpobCd"));
	    			insr1600Vo.setSystemkey((String) eMap.get("systemkey"));
	    			BigDecimal famyAqtnLssNum =  (BigDecimal) eMap.get("famyAqtnLssNum");	
	    			insr1600Vo.setFamyAqtnLssNum(famyAqtnLssNum.longValue());
	    			insr1600Vo.setFamyQuftDivCd((String) eMap.get("famyQuftDivCd"));
	    			insr1600Vo.setSocrLssFamyYn("Y");
	    			insr1600Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
	       	        insr1600Vo.setRevnAddr(request.getRemoteAddr());    /** column 수정주소 : revnAddr */
	    			insr2100ExcelService.updateXlsInsr2150ToInsr1600(insr1600Vo);
	    		}
	    		for(int i=0; i<InsrList.size(); i++){
    	    		EgovMap eMap  = new EgovMap();
    	    		eMap = (EgovMap) InsrList.get(i);
    	    		// TODO 주민번호
    	    		//nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	    		String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
    	    		String strValue2 = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("famyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
    	    		eMap.put("resnRegnNum", strValue);
    	    		eMap.put("famyResnRegnNum", strValue2);
    	    		excelList.add(eMap);
    	    	}
	    		
				/** 로그반영
				 * CRUDSBLO
				 * C:create		R:read		U:update
		    	 * D:delete		S:select	B:배치 
		    	 * L:로그인		O:로그아웃
		    	 */
				//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:U");
	
	    		
	//    		Map<String, Object> map = new HashMap<String, Object>(); 
	    		map = new HashMap<String, Object>(); 
	    		map.put("listInsr1550", excelList);
    		
    		}catch(Exception e) {
    			e.printStackTrace();
    	    	/** 에러 로그 **/			
    	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:U",e, windowNm , windowId);
    		}
    		return new ModelAndView("insr2100_1550ExcelView", map);
    	}
    }
    
    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsFileInsr2150Export.do")   
    public ModelAndView xlsInsr2150Export(@ModelAttribute("Insr1200SrhVO") Insr1200SrhVO insr1200SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception {  
    	
    	String method = calledClass + ".xlsInsr2150Export";
       
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
        Map<String, Object> map = new HashMap<String, Object>(); 
        
    	String windowNm = "사회보험자격취득신고";
		String windowId = "INSRP2100";
        
        try{
        
	        insr1200SrhVo.setUsrId(sessionUser.getUsrId());  
	        insr1200SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        insr1200SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1200SrhVo.getTypOccuCd())); 
	        insr1200SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	        List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1200SrhVo.getDtilOccuInttnCd())); 
	        insr1200SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	        List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1200SrhVo.getHdofcCodtnCd())); 
	        insr1200SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);  
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	insr1200SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           insr1200SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           insr1200SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	insr1200SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr1200SrhVo.getPayrMangDeptCd()));    
	                 if (insr1200SrhVo.getPayrMangDeptCd().equals(insr1200SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	insr1200SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	insr1200SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 insr1200SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr1200SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1200SrhVo.getDeptCd()));  
	                      insr1200SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        
	        insr1200SrhVo.setDeptCdAuth(insr1200SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	        insr1200SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr1200SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	       /******************************** 권한 ************************************************************************/
	         
	        List listInsr1200 = insr2100ExcelService.selectXlsInsr1200List(insr1200SrhVo);
	        //마스터 업데이트
	        
	        String valDiv = insr1200SrhVo.getValDiv();
//	        Map<String, Object> map = new HashMap<String, Object>(); 
	        map = new HashMap<String, Object>(); 
	        
	        map.put("listInsr1200", listInsr1200);
	        map.put("valDiv", valDiv);
	        
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
        
        return new ModelAndView("insr2100ExcelView", map);
         
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
//    @RequestMapping(value = "/imp/XlsDlgn0250Import.do")
//    public String xlsDlgn0250Import(@ModelAttribute("Dlgn0250VO") Dlgn0250VO dlgn0250Vo,final HttpServletRequest request
//            , Map commandMap , Model model) throws Exception {
//         
////        String sCmd = commandMap.get("dlgn0250flUp") == null ? "" : (String)commandMap.get("dlgn0250flUp");
////        if (sCmd.equals("")) {
////          return;
////        }
//
//        if  (dlgn0250ExcelService == null) { 
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( request.getSession().getServletContext());
//
//            dlgn0250ExcelService = (Dlgn0250ExcelService) wac.getBean("Dlgn0250ExcelService" ); 
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
//                        dlgn0250ExcelService.insertXlsDlgn0100(fis);
//                        dlgn0250ExcelService.insertXlsDlgn0200(fis2);
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
//                        dlgn0250ExcelService.insertXSSFDlgn0100(fis);
//                        dlgn0250ExcelService.insertXSSFDlgn0200(fis2);
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
    
}
