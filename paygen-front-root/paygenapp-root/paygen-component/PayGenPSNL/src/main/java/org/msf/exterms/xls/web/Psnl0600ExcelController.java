package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Psnl0600ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.personal.server.vo.Psnl0600SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Psnl0600ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Psnl0600ExcelController.class);  
    private static final String calledClass = Psnl0600ExcelController.class.getName();

 
    
    @Resource(name = "psnl0600ExcelService")
    private Psnl0600ExcelService psnl0600ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
    
    
    /**
     * 엑셀파일로 출력한다.(통합출력)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPsnl0600SelExport.do")
    public ModelAndView xlsPsnl0600SelExport(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) throws Exception { 
    	
    	String method = calledClass + ".xlsPsnl0600SelExport";
    	
    	String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
      
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
     
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		
		try{
        	
			
			psnl0600SrhVo.setPsnl0100Chk(param.get("psnl0100Chk"));
			psnl0600SrhVo.setPsnl0112Chk(param.get("psnl0112Chk"));
			psnl0600SrhVo.setPsnl0114Chk(param.get("psnl0114Chk"));
			psnl0600SrhVo.setPsnl0116Chk(param.get("psnl0116Chk"));
			psnl0600SrhVo.setPsnl0119Chk(param.get("psnl0119Chk"));
			psnl0600SrhVo.setPsnl0118Chk(param.get("psnl0118Chk"));
			psnl0600SrhVo.setPsnl0120Chk(param.get("psnl0120Chk"));
			psnl0600SrhVo.setPsnl0121Chk(param.get("psnl0121Chk"));
			psnl0600SrhVo.setPsnl0122Chk(param.get("psnl0122Chk"));
			psnl0600SrhVo.setPsnl0123Chk(param.get("psnl0123Chk"));
			
			
			/******************************** 기본 시작  ************************************************************************/
	//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));		//부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(param.get("srhCurrDeptCd") == null || "".equals(param.get("srhCurrDeptCd"))) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(param.get("srhPayrMangDeptCd"));
			}
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("srhEmymtDivCd")));			//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("srhBusinCd")));				//사업
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(param.get("srhHdofcCodtnCd"));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //재직
			
			
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직코드
			
	//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직상태
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateE")));	//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(param.get("srhWorkYearS")));		//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(param.get("srhWorkYearE")));		//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(param.get("srhBirthDateS")));		//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(param.get("srhBirthDateE")));		//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(param.get("srhSexType")));				//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("srhTypOccuCd")));			//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));					
			psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));	
	//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));	
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));						
	
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")).replace(",", ""))); 
			
	    	psnl0600SrhVo.setEmymtBgnnDt(MSFSharedUtils.allowNulls(param.get("emymtBgnnDt")));
	      	psnl0600SrhVo.setEmymtEndDt(MSFSharedUtils.allowNulls(param.get("emymtEndDt")));
			
			psnl0600SrhVo.setSrhFlag("N");	
	      	if(psnl0600SrhVo.getEmymtDivCd() != "" || !"".equals(psnl0600SrhVo.getEmymtDivCd())) {
	      		
	          	// 퇴사한 공무직이 기간제 근로자로 재입사 한 경우 공무직 화면에서 조회하기 위해 srhVo 추가
		      	// 재직 구분이 없거나, 퇴직 포함 시 조회되도록 처리.
	      		if( ( psnl0600SrhVo.getHdofcCodtnCd() == null || "".equals(psnl0600SrhVo.getHdofcCodtnCd()) ) ||  ( ( psnl0600SrhVo.getHdofcCodtnCd().contains("A0030020")) ||  psnl0600SrhVo.getHdofcCodtnCd() == "A0030020"  ) ) {
	      			psnl0600SrhVo.setSrhFlag("Y");	
		      	}
					
	      	}
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
			/******************************** 권한 ************************************************************************/
			/******************************** 기본 종료  ************************************************************************/
	 
			
			/******************************** 병역 시작  ************************************************************************/
			psnl0600SrhVo.setDsageDivCd(MSFSharedUtils.allowNulls(param.get("srhDsageDivCd")));						// 제대구분
			psnl0600SrhVo.setDsageDtS(MSFSharedUtils.allowNulls(param.get("srhDsageDtS")));							// 제대 시작 일자  
			psnl0600SrhVo.setDsageDtE(MSFSharedUtils.allowNulls(param.get("srhDsageDtE")));							// 제대 종료 일자 
			psnl0600SrhVo.setBaggrpCd(MSFSharedUtils.allowNulls(param.get("srhBaggrpCd")));							// 군별
			psnl0600SrhVo.setAbotsCd(MSFSharedUtils.allowNulls(param.get("srhAbotsCd")));							// 병과
			psnl0600SrhVo.setClsCd(MSFSharedUtils.allowNulls(param.get("srhClsCd")));								// 계급
			/******************************** 병역 종료  ************************************************************************/
			
			
			/******************************** 단체 시작  ************************************************************************/
			psnl0600SrhVo.setJnOpztnNm(MSFSharedUtils.allowNulls(param.get("srhJnOpztnNm")));						// 단체명
			psnl0600SrhVo.setJnDtS(MSFSharedUtils.allowNulls(param.get("srhJnDtS")));								// 가입 시작 일자
			psnl0600SrhVo.setJnDtE(MSFSharedUtils.allowNulls(param.get("srhJnDtE")));								// 가입 종료 일자
			/******************************** 단체 종료  ************************************************************************/
			
			
			/******************************** 학력 시작  ************************************************************************/
			psnl0600SrhVo.setAcadAbtyDivCd(MSFSharedUtils.allowNulls(param.get("srhAcadAbtyDivCd")));				// 학력구분
			psnl0600SrhVo.setSchlCd(MSFSharedUtils.allowNulls(param.get("srhSchlCd")));								// 학교
			psnl0600SrhVo.setDeprMajrCd(MSFSharedUtils.allowNulls(param.get("srhDeprMajrCd")));						// 학과
			psnl0600SrhVo.setDegrDivCd(MSFSharedUtils.allowNulls(param.get("srhDegrDivCd")));						// 학위
			/******************************** 학력 종료  ************************************************************************/
			
			
			/******************************** 경력 시작  ************************************************************************/
			psnl0600SrhVo.setPaeWorkNm(MSFSharedUtils.allowNulls(param.get("srhPaeWorkNm")));						// 근무처명
			psnl0600SrhVo.setCarrBgnnDtS(MSFSharedUtils.allowNulls(param.get("srhCarrBgnnDtS")));					// 근무시작일(시작)
			psnl0600SrhVo.setCarrBgnnDtE(MSFSharedUtils.allowNulls(param.get("srhCarrBgnnDtE")));					// 근무시작일(종료)
			/******************************** 경력 종료  ************************************************************************/
			
			
			
			/******************************** 자격 시작  ************************************************************************/
			psnl0600SrhVo.setQftntLicnsPovncCtnt(MSFSharedUtils.allowNulls(param.get("srhQftntLicnsPovncCtnt")));	// 자격면허
			psnl0600SrhVo.setAqtnDtS(MSFSharedUtils.allowNulls(param.get("srhAqtnDtS")));							// 취득일자(시작)
			psnl0600SrhVo.setAqtnDtE(MSFSharedUtils.allowNulls(param.get("srhAqtnDtE")));							// 취득일자(종료)
			/******************************** 자격 종료  ************************************************************************/
			
			
			
			/******************************** 교육 시작  ************************************************************************/
			psnl0600SrhVo.setEduKndNm(MSFSharedUtils.allowNulls(param.get("srhEduKndNm")));							// 교육종류
			psnl0600SrhVo.setEduBgnnDtS(MSFSharedUtils.allowNulls(param.get("srhEduBgnnDtS")));						// 교육기간(시작)
			psnl0600SrhVo.setEduBgnnDtE(MSFSharedUtils.allowNulls(param.get("srhEduBgnnDtE")));						// 교육기간(종료)
			/******************************** 교육 종료  ************************************************************************/
			
			
			/******************************** 징계 시작  ************************************************************************/
			psnl0600SrhVo.setDsnyActDivCd(MSFSharedUtils.allowNulls(param.get("srhDsnyActDivCd")));					// 징계구분
			psnl0600SrhVo.setDsnyActDsplDtS(MSFSharedUtils.allowNulls(param.get("srhDsnyActDsplDtS")));				// 징계처분일(시작)
			psnl0600SrhVo.setDsnyActDsplDtE(MSFSharedUtils.allowNulls(param.get("srhDsnyActDsplDtE")));				// 징계처분일(종료)
			/******************************** 징계 종료  ************************************************************************/
			
			
			/******************************** 휴직 시작  ************************************************************************/
			psnl0600SrhVo.setLevfAbncDivCd(MSFSharedUtils.allowNulls(param.get("srhLevfAbncDivCd")));				// 휴직구분
			psnl0600SrhVo.setLevfAbncBgnnDtS(MSFSharedUtils.allowNulls(param.get("srhLevfAbncBgnnDtS")));			// 휴직기간(시작)
			psnl0600SrhVo.setLevfAbncBgnnDtE(MSFSharedUtils.allowNulls(param.get("srhLevfAbncBgnnDtE")));			// 휴직기간(종료)
			/******************************** 휴직 종료  ************************************************************************/	
			
	       
	        List listPsnl0600 = psnl0600ExcelService.selectXlsPsnl0600SelList(psnl0600SrhVo);
	        
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listPsnl0600.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPsnl0600.get(i);
	    		
	    			
	    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
		    		
	    		excelList.add(eMap);
	    	}
	        
	        map = new HashMap<String, Object>();
	        map.put("listPsnl0600", excelList);
	        
	        
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
       
        return new ModelAndView("psnl0600SelExcelView", map);
    }
    
    
       
    
    

    /**
     * 엑셀파일로 출력한다.(기본)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPsnl0600Export01.do")
    public ModelAndView xlsPsnl0600Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsPsnl0600Export";
    	
    	String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
      
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	Map<String, Object> map = new HashMap<String, Object>();
    	
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
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
     
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		
		
		
		try{
        	
	//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));		//부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(param.get("srhCurrDeptCd") == null || "".equals(param.get("srhCurrDeptCd"))) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(param.get("srhPayrMangDeptCd"));
			}
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("srhEmymtDivCd")));			//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("srhBusinCd")));				//사업
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(param.get("srhHdofcCodtnCd"));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //재직
			
			
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직코드
			
	//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직상태
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateE")));	//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(param.get("srhWorkYearS")));		//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(param.get("srhWorkYearE")));		//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(param.get("srhBirthDateS")));		//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(param.get("srhBirthDateE")));		//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(param.get("srhSexType")));				//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("srhTypOccuCd")));			//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));					
			psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));	
	//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));	
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));						
	
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")).replace(",", ""))); 
			
	    	psnl0600SrhVo.setEmymtBgnnDt(MSFSharedUtils.allowNulls(param.get("emymtBgnnDt")));
	      	psnl0600SrhVo.setEmymtEndDt(MSFSharedUtils.allowNulls(param.get("emymtEndDt")));
			
			psnl0600SrhVo.setSrhFlag("N");	
	      	if(psnl0600SrhVo.getEmymtDivCd() != "" || !"".equals(psnl0600SrhVo.getEmymtDivCd())) {
	      		
	          	// 퇴사한 공무직이 기간제 근로자로 재입사 한 경우 공무직 화면에서 조회하기 위해 srhVo 추가
		      	// 재직 구분이 없거나, 퇴직 포함 시 조회되도록 처리.
	      		if( ( psnl0600SrhVo.getHdofcCodtnCd() == null || "".equals(psnl0600SrhVo.getHdofcCodtnCd()) ) ||  ( ( psnl0600SrhVo.getHdofcCodtnCd().contains("A0030020")) ||  psnl0600SrhVo.getHdofcCodtnCd() == "A0030020"  ) ) {
	      			psnl0600SrhVo.setSrhFlag("Y");	
		      	}
					
	      	}
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
	//			if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")))) { 
	//				
	//				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
	//				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
	//				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
	//				psnl0600SrhVo.setDeptCdArr(lsdeptCd);  
	//				
	//			}  else { 
	//
	//				psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
	//				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));
	//				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd"))); 
	//				psnl0600SrhVo.setDeptCdArr(lsdeptCd);  
	//				
	//			}  
	//      
	//
	//		/******************************** 권한 ************************************************************************/
	//		
	//        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	//		if ("FALSE".equals(chkDeptCd)) {
	//			insr3000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	//		   listDeptCd.add(sessionUser.getDeptCd());
	//		   insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	//		   insr3000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	//		} else {
	//			    
	//			insr3000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getPayrMangDeptCd()));    
	//		         if (insr3000SrhVo.getPayrMangDeptCd().equals(insr3000SrhVo.getDeptCd())) { 
	//		         	 listDeptCd = null; 
	//		         	insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	//		         	insr3000SrhVo.setDeptCd("");  //부서코드
	//		         } else {
	//		        	 insr3000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr3000SrhVo.getDeptCd()));
	//		              listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3000SrhVo.getDeptCd()));  
	//		              insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	//		         } 
	//		      
	//		}
	//        
	//        dlgn0250SrhVo.setDeptCdAuth(dlgn0250SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	//        dlgn0250SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dlgn0250SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	//		 
			/******************************** 권한 ************************************************************************/
	
	         //TODO 위에걸로 수정 
	//        if (ExtermsProps.AUTH_USR_DIV_10.equals(sessionUser.getUsrDivCd()) && ExtermsProps.AUTH_USR_DIV_40.equals(sessionUser.getUsrDivCd())){
	//		    
	//			
	//		   } else if (ExtermsProps.AUTH_USR_DIV_20.equals(sessionUser.getUsrDivCd())){
	//			   
	//			   
	//		   } else if (ExtermsProps.AUTH_USR_DIV_25.equals(sessionUser.getUsrDivCd())){
	//			   
	//			   
	//		   } else {
	//			   
	//			   if ("Y".equals(sessionUser.getPayrMangDeptYn())) {
	//				    param.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	//				    param.put("payrMangDeptCd",sessionUser.getPayrMangDeptCd()); 
	//					
	//					 //if (MSFSharedUtils.allowNulls(param.get("searchDeptCd")).equals(MSFSharedUtils.allowNulls(param.get("searchCurrDeptCd")))) {
	//					if (" ".equals(MSFSharedUtils.allowNulls(param.get("searchCurrDeptCd")))) {
	//			    		 param.put("payrMangDeptYn","Y");  //단위기관담당자여부   
	//			    		 param.put("payrMangDeptCd",MSFSharedUtils.allowNulls(param.get("searchCurrDeptCd")));
	//			        	 param.put("searchCurrDeptCd","");  
	//			        	 param.put("searchDeptCd",""); 
	//				     } else if ("405030200".equals(MSFSharedUtils.allowNulls(param.get("searchCurrDeptCd")))) {
	//				    	 param.put("payrMangDeptYn","Y");  //단위기관담당자여부   
	//				    	 param.put("payrMangDeptCd",MSFSharedUtils.allowNulls(param.get("searchCurrDeptCd")));
	//			        	 param.put("searchCurrDeptCd","");  
	//			        	 param.put("searchDeptCd",""); 
	//				     } else {
	//				    	 
	//				     } 
	//			   } else {
	//				   
	//				   // param.put("payrMangDeptYn",sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	//				   // param.put("payrMangDeptCd",sessionUser.getPayrMangDeptCd()); 
	//					
	//					 //if (MSFSharedUtils.allowNulls(param.get("searchDeptCd")).equals(MSFSharedUtils.allowNulls(param.get("searchCurrDeptCd")))) {
	//					if (" ".equals(MSFSharedUtils.allowNulls(param.get("searchCurrDeptCd")))) {
	//			    		 param.put("payrMangDeptYn","Y");  //단위기관담당자여부   
	//			    		 param.put("payrMangDeptCd",MSFSharedUtils.allowNulls(param.get("searchCurrDeptCd")));
	//			        	 param.put("searchCurrDeptCd","");  
	//			        	 param.put("searchDeptCd",""); 
	//				     } else if ("405030200".equals(MSFSharedUtils.allowNulls(param.get("searchCurrDeptCd")))) {
	//				    	 param.put("payrMangDeptYn","Y");  //단위기관담당자여부   
	//				    	 param.put("payrMangDeptCd",MSFSharedUtils.allowNulls(param.get("searchCurrDeptCd")));
	//			        	 param.put("searchCurrDeptCd","");  
	//			        	 param.put("searchDeptCd",""); 
	//				     } else {
	//				    	 
	//				     } 
	//			   }
	//				
	//		   }
	 
	       
	//        List listPsnl0600 = psnl0600ExcelService.selectXlsPsnl0600List(param);
	        List listPsnl0600 = psnl0600ExcelService.selectXlsPsnl0600List(psnl0600SrhVo);
	        
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listPsnl0600.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPsnl0600.get(i);
	    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
		    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("payFamyResnRegnNum", strValue);
	    			
	    		excelList.add(eMap);
	    	}
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPsnl0600", excelList);
	        
	        
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
       
        return new ModelAndView("psnl0600ExcelView01", map);
    }
    
    
    /**
     * 엑셀파일로 출력한다.(병역)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPsnl0600Export02.do")
    public ModelAndView xlsPsnl0600ToPsnl0112Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 

    	
    	String method = calledClass + ".xlsPsnl0600ToPsnl0112Export";
    	
    	String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
     
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		try{
		
	//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));		//부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(param.get("srhCurrDeptCd") == null || "".equals(param.get("srhCurrDeptCd"))) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(param.get("srhPayrMangDeptCd"));
			}
			
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("srhEmymtDivCd")));			//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("srhBusinCd")));				//사업
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(param.get("srhHdofcCodtnCd"));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직코드
			
	//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직상태
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateE")));	//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(param.get("srhWorkYearS")));		//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(param.get("srhWorkYearE")));		//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(param.get("srhBirthDateS")));		//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(param.get("srhBirthDateE")));		//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(param.get("srhSexType")));				//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("srhTypOccuCd")));			//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));
	//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
			
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")).replace(",", "")));   
			         
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
			/******************************** 권한 ************************************************************************/
			
			psnl0600SrhVo.setDsageDivCd(MSFSharedUtils.allowNulls(param.get("srhDsageDivCd")));	//제대구분
			psnl0600SrhVo.setDsageDtS(MSFSharedUtils.allowNulls(param.get("srhDsageDtS")));		//제대 시작 일자  
			psnl0600SrhVo.setDsageDtE(MSFSharedUtils.allowNulls(param.get("srhDsageDtE")));		//제대 종료 일자 
			psnl0600SrhVo.setBaggrpCd(MSFSharedUtils.allowNulls(param.get("srhBaggrpCd")));		//군별
			psnl0600SrhVo.setAbotsCd(MSFSharedUtils.allowNulls(param.get("srhAbotsCd")));		//병과
			psnl0600SrhVo.setClsCd(MSFSharedUtils.allowNulls(param.get("srhClsCd")));			//계급
				
				
			List listPsnl0600 = psnl0600ExcelService.selectXlsPsnl0600ToPsnl0112List(psnl0600SrhVo);
			
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listPsnl0600.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPsnl0600.get(i);
	    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
		    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("payFamyResnRegnNum", strValue);
	    			
	    		excelList.add(eMap);
	    	}
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPsnl0600", excelList);
	             
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
		
       
        return new ModelAndView("psnl0600ExcelView02", map);
    }
    
    
    /**
     * 엑셀파일로 출력한다.(단체)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPsnl0600Export03.do")
    public ModelAndView xlsPsnl0600ToPsnl0114Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
      
    	String method = calledClass + ".xlsPsnl0600ToPsnl0114Export";
    	
    	String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		try{
	//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));		//부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(param.get("srhCurrDeptCd") == null || "".equals(param.get("srhCurrDeptCd"))) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(param.get("srhPayrMangDeptCd"));
			}
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("srhEmymtDivCd")));			//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("srhBusinCd")));				//사업
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(param.get("srhHdofcCodtnCd"));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직코드
			
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateE")));	//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(param.get("srhWorkYearS")));		//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(param.get("srhWorkYearE")));		//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(param.get("srhBirthDateS")));		//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(param.get("srhBirthDateE")));		//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(param.get("srhSexType")));				//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("srhTypOccuCd")));			//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
			psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));
	//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
			
			
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")).replace(",", ""))); 
			         
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
			/******************************** 권한 ************************************************************************/
			
			psnl0600SrhVo.setJnOpztnNm(MSFSharedUtils.allowNulls(param.get("srhJnOpztnNm")));//단체명
			psnl0600SrhVo.setJnDtS(MSFSharedUtils.allowNulls(param.get("srhJnDtS")));	//가입 시작 일자
			psnl0600SrhVo.setJnDtE(MSFSharedUtils.allowNulls(param.get("srhJnDtE")));	//가입 종료 일자
				
			List listPsnl0600 = psnl0600ExcelService.selectXlsPsnl0600ToPsnl0114List(psnl0600SrhVo);
			
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listPsnl0600.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPsnl0600.get(i);
	    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
		    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("payFamyResnRegnNum", strValue);
	    			
	    		excelList.add(eMap);
	    	}
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPsnl0600", excelList);
	        
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
       
        return new ModelAndView("psnl0600ExcelView03", map);
    }
    
    
    /**
     * 엑셀파일로 출력한다.(학력)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPsnl0600Export04.do")
    public ModelAndView xlsPsnl0600ToPsnl0116Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".xlsPsnl0600ToPsnl0116Export";
    	
    	String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		try{
        	
//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));		//부서
		//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
		if(param.get("srhCurrDeptCd") == null || "".equals(param.get("srhCurrDeptCd"))) {
			psnl0600SrhVo.setPayrMangDeptCd("");
			psnl0600SrhVo.setCurrAffnDeptCd("");	
		}else {
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));	//부서
			psnl0600SrhVo.setPayrMangDeptCd(param.get("srhPayrMangDeptCd"));
		}
		
		psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("srhEmymtDivCd")));			//고용구분
		psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("srhBusinCd")));				//사업
//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직상태
		
		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(param.get("srhHdofcCodtnCd"));  
		psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직코드
		
		psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateS")));	//현부서 시작일자(시작)
		psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateE")));	//현부서 종료일자(종료)
		psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
		psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateE")));	//최초고용일자(종료)
		psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(param.get("srhWorkYearS")));		//근속년수(시작)
		psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(param.get("srhWorkYearE")));		//근속년수(종료)
		psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(param.get("srhBirthDateS")));		//생년월일(시작)
		psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(param.get("srhBirthDateE")));		//생년월일(종료)
		psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(param.get("srhSexType")));				//성별
		psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("srhTypOccuCd")));			//직종
		
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd"))); 
		psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")))); //직종세
		
		psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
		psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));
//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
		psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
		
		psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
		psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")).replace(",", ""))); 
		         
		/******************************** 권한 ************************************************************************/
		if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")))) {         
			psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
			List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
			psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
		}else {
			psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
			List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd"))); 
			psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
		}
		/******************************** 권한 ************************************************************************/
		
		psnl0600SrhVo.setAcadAbtyDivCd(MSFSharedUtils.allowNulls(param.get("srhAcadAbtyDivCd")));//학력구분
		psnl0600SrhVo.setSchlCd(MSFSharedUtils.allowNulls(param.get("srhSchlCd")));	//학교
		psnl0600SrhVo.setDeprMajrCd(MSFSharedUtils.allowNulls(param.get("srhDeprMajrCd")));	//학과
		psnl0600SrhVo.setDegrDivCd(MSFSharedUtils.allowNulls(param.get("srhDegrDivCd")));	//학위
			
			
		List listPsnl0600 = psnl0600ExcelService.selectXlsPsnl0600ToPsnl0116List(psnl0600SrhVo);
		

		String strValue = "";
		List<EgovMap> excelList = new ArrayList<EgovMap>();

	    for(int i=0; i<listPsnl0600.size(); i++){
    		EgovMap eMap  = new EgovMap();
    		eMap = (EgovMap) listPsnl0600.get(i);
    		
    			
    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
	    		
    			
    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("payFamyResnRegnNum", strValue);
    			
    		excelList.add(eMap);
    	}
        
//        Map<String, Object> map = new HashMap<String, Object>();
        map = new HashMap<String, Object>();
        map.put("listPsnl0600", excelList);
        
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
             
       
        return new ModelAndView("psnl0600ExcelView04", map);
    }
    
    
    /**
     * 엑셀파일로 출력한다.(경력)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPsnl0600Export05.do")
    public ModelAndView xlsPsnl0600ToPsnl0119Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
      
    	String method = calledClass + ".xlsPsnl0600ToPsnl0119Export";
    	
    	String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
        Map<String, Object> map = new HashMap<String, Object>();
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
        
		try{
        
//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));		//부서
		//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
		if(param.get("srhCurrDeptCd") == null || "".equals(param.get("srhCurrDeptCd"))) {
			psnl0600SrhVo.setPayrMangDeptCd("");
			psnl0600SrhVo.setCurrAffnDeptCd("");	
		}else {
			psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));	//부서
			psnl0600SrhVo.setPayrMangDeptCd(param.get("srhPayrMangDeptCd"));
		}
		
		psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("srhEmymtDivCd")));			//고용구분
		psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("srhBusinCd")));				//사업
//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직상태
		
		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(param.get("srhHdofcCodtnCd"));  
		psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직코드
		
		psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateS")));	//현부서 시작일자(시작)
		psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateE")));	//현부서 종료일자(종료)
		psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
		psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateE")));	//최초고용일자(종료)
		psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(param.get("srhWorkYearS")));		//근속년수(시작)
		psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(param.get("srhWorkYearE")));		//근속년수(종료)
		psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(param.get("srhBirthDateS")));		//생년월일(시작)
		psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(param.get("srhBirthDateE")));		//생년월일(종료)
		psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(param.get("srhSexType")));				//성별
		psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("srhTypOccuCd")));			//직종
		
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd"))); 
		psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")))); //직종세
		
		psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
		psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));
//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
		psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
		
		psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
		psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")).replace(",", ""))); 
		         
		/******************************** 권한 ************************************************************************/
		if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")))) {         
			psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
			List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
			psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
		}else {
			psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
			List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd"))); 
			psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
		}
		/******************************** 권한 ************************************************************************/
		
		psnl0600SrhVo.setPaeWorkNm(MSFSharedUtils.allowNulls(param.get("srhPaeWorkNm")));//근무처명
		psnl0600SrhVo.setCarrBgnnDtS(MSFSharedUtils.allowNulls(param.get("srhCarrBgnnDtS")));	//근무시작일(시작)
		psnl0600SrhVo.setCarrBgnnDtE(MSFSharedUtils.allowNulls(param.get("srhCarrBgnnDtE")));	//근무시작일(종료)
			
			
		List listPsnl0600 = psnl0600ExcelService.selectXlsPsnl0600ToPsnl0119List(psnl0600SrhVo);
		
		String strValue = "";
		List<EgovMap> excelList = new ArrayList<EgovMap>();

	    for(int i=0; i<listPsnl0600.size(); i++){
    		EgovMap eMap  = new EgovMap();
    		eMap = (EgovMap) listPsnl0600.get(i);
    		
    			
    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
	    		
    			
    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("payFamyResnRegnNum", strValue);
    			
    		excelList.add(eMap);
    	}
        
//        Map<String, Object> map = new HashMap<String, Object>();
        map = new HashMap<String, Object>();
        map.put("listPsnl0600", excelList);
        
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
       
        return new ModelAndView("psnl0600ExcelView05", map);
    }
    
    
    /**
     * 엑셀파일로 출력한다.(자격)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPsnl0600Export06.do")
    public ModelAndView xlsPsnl0600ToPsnl0118Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
      
    	
    	String method = calledClass + ".xlsPsnl0600ToPsnl0118Export";
    	
    	String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		try{
	//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));		//부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(param.get("srhCurrDeptCd") == null || "".equals(param.get("srhCurrDeptCd"))) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(param.get("srhPayrMangDeptCd"));
			}
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("srhEmymtDivCd")));			//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("srhBusinCd")));				//사업
	//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직상태
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(param.get("srhHdofcCodtnCd"));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직코드
			
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateE")));	//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(param.get("srhWorkYearS")));		//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(param.get("srhWorkYearE")));		//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(param.get("srhBirthDateS")));		//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(param.get("srhBirthDateE")));		//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(param.get("srhSexType")));				//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("srhTypOccuCd")));			//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
			psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));
	//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
			         
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")).replace(",", ""))); 
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
			/******************************** 권한 ************************************************************************/
			
			psnl0600SrhVo.setQftntLicnsPovncCtnt(MSFSharedUtils.allowNulls(param.get("srhQftntLicnsPovncCtnt")));//자격면허
			psnl0600SrhVo.setAqtnDtS(MSFSharedUtils.allowNulls(param.get("srhAqtnDtS")));	//취득일자(시작)
			psnl0600SrhVo.setAqtnDtE(MSFSharedUtils.allowNulls(param.get("srhAqtnDtE")));	//취득일자(종료)
				
				
			List listPsnl0600 = psnl0600ExcelService.selectXlsPsnl0600ToPsnl0118List(psnl0600SrhVo);
			
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listPsnl0600.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPsnl0600.get(i);
	    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
		    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("payFamyResnRegnNum", strValue);
	    			
	    		excelList.add(eMap);
	    	}
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPsnl0600", excelList);
	        
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
             
        return new ModelAndView("psnl0600ExcelView06", map);
        
    }
    
    
    /**
     * 엑셀파일로 출력한다.(교육)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPsnl0600Export07.do")
    public ModelAndView xlsPsnl0600ToPsnl0120Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
      
    	String method = calledClass + ".xlsPsnl0600ToPsnl0120Export";
    	
    	String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		try{
        	
	//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));		//부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(param.get("srhCurrDeptCd") == null || "".equals(param.get("srhCurrDeptCd"))) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(param.get("srhPayrMangDeptCd"));
			}
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("srhEmymtDivCd")));			//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("srhBusinCd")));				//사업
	//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직상태
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(param.get("srhHdofcCodtnCd"));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직코드
			
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateE")));	//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(param.get("srhWorkYearS")));		//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(param.get("srhWorkYearE")));		//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(param.get("srhBirthDateS")));		//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(param.get("srhBirthDateE")));		//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(param.get("srhSexType")));				//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("srhTypOccuCd")));			//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
			psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));
	//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
			
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")).replace(",", ""))); 
			         
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
			/******************************** 권한 ************************************************************************/
			
			psnl0600SrhVo.setEduKndNm(MSFSharedUtils.allowNulls(param.get("srhEduKndNm")));//교육종류
			psnl0600SrhVo.setEduBgnnDtS(MSFSharedUtils.allowNulls(param.get("srhEduBgnnDtS")));	//교육기간(시작)
			psnl0600SrhVo.setEduBgnnDtE(MSFSharedUtils.allowNulls(param.get("srhEduBgnnDtE")));	//교육기간(종료)
				
				
			List listPsnl0600 = psnl0600ExcelService.selectXlsPsnl0600ToPsnl0120List(psnl0600SrhVo);
			
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listPsnl0600.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPsnl0600.get(i);
	    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
		    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("payFamyResnRegnNum", strValue);
	    			
	    		excelList.add(eMap);
	    	}
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPsnl0600", excelList);
	             
	        
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
		
       
        return new ModelAndView("psnl0600ExcelView07", map);
    }
    
    
    /**
     * 엑셀파일로 출력한다.(포상)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPsnl0600Export08.do")
    public ModelAndView xlsPsnl0600ToPsnl0121Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
      
    	String method = calledClass + ". xlsPsnl0600ToPsnl0121Export";
    	
    	String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		Map<String, Object> map = new HashMap<String, Object>();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		try{
        	
	//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));		//부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(param.get("srhCurrDeptCd") == null || "".equals(param.get("srhCurrDeptCd"))) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(param.get("srhPayrMangDeptCd"));
			}
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("srhEmymtDivCd")));			//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("srhBusinCd")));				//사업
	//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직상태
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(param.get("srhHdofcCodtnCd"));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직코드
			
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateE")));	//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(param.get("srhWorkYearS")));		//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(param.get("srhWorkYearE")));		//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(param.get("srhBirthDateS")));		//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(param.get("srhBirthDateE")));		//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(param.get("srhSexType")));				//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("srhTypOccuCd")));			//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
			psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));
	//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
			
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")).replace(",", ""))); 
			         
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
			/******************************** 권한 ************************************************************************/
			
				
			List listPsnl0600 = psnl0600ExcelService.selectXlsPsnl0600ToPsnl0121List(psnl0600SrhVo);
			
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listPsnl0600.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPsnl0600.get(i);
	    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
		    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("payFamyResnRegnNum", strValue);
	    			
	    		excelList.add(eMap);
	    	}
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPsnl0600", excelList);
	       
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
		
        return new ModelAndView("psnl0600ExcelView08", map);
    }
    
    
    /**
     * 엑셀파일로 출력한다.(징계)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPsnl0600Export09.do")
    public ModelAndView xlsPsnl0600ToPsnl0122Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
      
    	String method = calledClass + ".xlsPsnl0600ToPsnl0122Export";
    	
    	String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		 Map<String, Object> map = new HashMap<String, Object>();
		 
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		try{
        	
	//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));		//부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(param.get("srhCurrDeptCd") == null || "".equals(param.get("srhCurrDeptCd"))) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(param.get("srhPayrMangDeptCd"));
			}
			
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("srhEmymtDivCd")));			//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("srhBusinCd")));				//사업
	//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직상태
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(param.get("srhHdofcCodtnCd"));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직코드
			
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateE")));	//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(param.get("srhWorkYearS")));		//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(param.get("srhWorkYearE")));		//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(param.get("srhBirthDateS")));		//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(param.get("srhBirthDateE")));		//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(param.get("srhSexType")));				//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("srhTypOccuCd")));			//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")))); //직종세
			
			psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
			psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));
	//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
	
			
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")).replace(",", ""))); 
			         
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}  
			/******************************** 권한 ************************************************************************/
			
			psnl0600SrhVo.setDsnyActDivCd(MSFSharedUtils.allowNulls(param.get("srhDsnyActDivCd")));//징계구분
			psnl0600SrhVo.setDsnyActDsplDtS(MSFSharedUtils.allowNulls(param.get("srhDsnyActDsplDtS")));	//징계처분일(시작)
			psnl0600SrhVo.setDsnyActDsplDtE(MSFSharedUtils.allowNulls(param.get("srhDsnyActDsplDtE")));	//징계처분일(종료)
				
				
			List listPsnl0600 = psnl0600ExcelService.selectXlsPsnl0600ToPsnl0122List(psnl0600SrhVo);
			
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listPsnl0600.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPsnl0600.get(i);
	    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
		    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("payFamyResnRegnNum", strValue);
	    			
	    		excelList.add(eMap);
	    	}
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPsnl0600", excelList);
	        
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
             
        return new ModelAndView("psnl0600ExcelView09", map);
    }
    
    
    /**
     * 엑셀파일로 출력한다.(휴직)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsPsnl0600Export10.do")
    public ModelAndView xlsPsnl0600ToPsnl0123Export(@RequestParam HashMap<String, String> param,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
      
    	String method = calledClass + ".xlsPsnl0600ToPsnl0123Export";
    	String windowNm = "인사통합검색";
		String windowId = "PSNL0600";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		Psnl0600SrhVO psnl0600SrhVo = new Psnl0600SrhVO();
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		try{
	//		psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));		//부서
			//부서코드 선택안할 경우 전체 가져옴(단위기간코드 null)
			if(param.get("srhCurrDeptCd") == null || "".equals(param.get("srhCurrDeptCd"))) {
				psnl0600SrhVo.setPayrMangDeptCd("");
				psnl0600SrhVo.setCurrAffnDeptCd("");	
			}else {
				psnl0600SrhVo.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")));	//부서
				psnl0600SrhVo.setPayrMangDeptCd(param.get("srhPayrMangDeptCd"));
			}
			psnl0600SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("srhEmymtDivCd")));			//고용구분
			psnl0600SrhVo.setBusinCd(MSFSharedUtils.allowNulls(param.get("srhBusinCd")));				//사업
	//		psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직상태
			
			List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(param.get("srhHdofcCodtnCd"));  
			psnl0600SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
			psnl0600SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(param.get("srhHdofcCodtnCd")));		//재직코드
			
			psnl0600SrhVo.setCurrDeptAppmtDtS(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateS")));	//현부서 시작일자(시작)
			psnl0600SrhVo.setCurrDeptAppmtDtE(MSFSharedUtils.allowNulls(param.get("srhNowDeptDateE")));	//현부서 종료일자(종료)
			psnl0600SrhVo.setFrstEmymtDtS(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateS")));	//최초고용일자 (시작)
			psnl0600SrhVo.setFrstEmymtDtE(MSFSharedUtils.allowNulls(param.get("srhFrstWorkDateE")));	//최초고용일자(종료)
			psnl0600SrhVo.setLogSvcYrNumCdS(MSFSharedUtils.allowNulls(param.get("srhWorkYearS")));		//근속년수(시작)
			psnl0600SrhVo.setLogSvcYrNumCdE(MSFSharedUtils.allowNulls(param.get("srhWorkYearE")));		//근속년수(종료)
			psnl0600SrhVo.setYoobhMnthDayS(MSFSharedUtils.allowNulls(param.get("srhBirthDateS")));		//생년월일(시작)
			psnl0600SrhVo.setYoobhMnthDayE(MSFSharedUtils.allowNulls(param.get("srhBirthDateE")));		//생년월일(종료)
			psnl0600SrhVo.setSxDivCd(MSFSharedUtils.allowNulls(param.get("srhSexType")));				//성별
			psnl0600SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("srhTypOccuCd")));			//직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd"))); 
			psnl0600SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0600SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")))); //직종세
			
			
			psnl0600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));
			psnl0600SrhVo.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));
	//		psnl0600SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));
			psnl0600SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));
			
			psnl0600SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")).replace(",", "")));  //권한처리를위해 추가  
			psnl0600SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("srhDtilOccuInttnCd")).replace(",", ""))); 
			         
			/******************************** 권한 ************************************************************************/
			if (psnl0600SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd")))) {         
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(""));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls("")); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}else {
				psnl0600SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0600SrhVo.getCurrAffnDeptCd()));
				List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("srhCurrDeptCd"))); 
				psnl0600SrhVo.setDeptCdArr(lsdeptCd);   
			}
			/******************************** 권한 ************************************************************************/
			
			psnl0600SrhVo.setLevfAbncDivCd(MSFSharedUtils.allowNulls(param.get("srhLevfAbncDivCd")));//휴직구분
			psnl0600SrhVo.setLevfAbncBgnnDtS(MSFSharedUtils.allowNulls(param.get("srhLevfAbncBgnnDtS")));	//휴직기간(시작)
			psnl0600SrhVo.setLevfAbncBgnnDtE(MSFSharedUtils.allowNulls(param.get("srhLevfAbncBgnnDtE")));	//휴직기간(종료)
				
				
			List listPsnl0600 = psnl0600ExcelService.selectXlsPsnl0600ToPsnl0123List(psnl0600SrhVo);
			
			String strValue = "";
			List<EgovMap> excelList = new ArrayList<EgovMap>();

		    for(int i=0; i<listPsnl0600.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPsnl0600.get(i);
	    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("resnRegnNum", strValue);
		    		
	    			
	    			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("payFamyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		    		eMap.put("payFamyResnRegnNum", strValue);
	    			
	    		excelList.add(eMap);
	    	}
	        
//	        Map<String, Object> map = new HashMap<String, Object>();
	        map = new HashMap<String, Object>();
	        map.put("listPsnl0600", excelList);
	        
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
       
        return new ModelAndView("psnl0600ExcelView10", map);
    }

    
}
