package org.msf.exterms.xls.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Insr2300ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.insurance.server.vo.Insr1600VO;
import com.app.exterms.insurance.server.vo.Insr2100VO;
import com.app.exterms.insurance.server.vo.Insr2200SrhVO;
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
public class Insr2300ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Insr2300ExcelController.class);  
    private static final String calledClass = Insr2300ExcelController.class.getName();
 
    
    @Resource(name = "insr2300ExcelService")
    private Insr2300ExcelService insr2300ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */                         
    @RequestMapping(value="/exp/XlsFileInsr2300Export.do")   
    public ModelAndView xlsInsr2300Export(@ModelAttribute("Insr2200SrhVO") Insr2200SrhVO insr2200SrhVo, HttpServletRequest request ,ModelMap model) 
                    throws Exception {  
    	
    	String method = calledClass + ".xlsInsr2300Export";
    	
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
        
    	String windowNm = "사회보험자격상실신고";
		String windowId = "INSRP2300";
        
        String gubun = insr2200SrhVo.getGubun();
        Long result = 0L;
        List listInsr2200 = new ArrayList();
        List<EgovMap> excelList = new ArrayList<EgovMap>();
        
        try{

	        insr2200SrhVo.setUsrId(sessionUser.getUsrId());  
	        insr2200SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        insr2200SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			insr2200SrhVo.setSoctyInsurCmptnDt01(MSFSharedUtils.allowNulls(insr2200SrhVo.getSoctyInsurCmptnDt01()));
			insr2200SrhVo.setSoctyInsurCmptnDt02(MSFSharedUtils.allowNulls(insr2200SrhVo.getSoctyInsurCmptnDt02()));
			List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr2200SrhVo.getHdofcCodtnCd())); 
			insr2200SrhVo.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태
			insr2200SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(insr2200SrhVo.getEmymtDivCd()));	         //고용구분
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr2200SrhVo.getTypOccuCd())); 
	        insr2200SrhVo.setTypOccuCdArr(lstTypeOccuCd); //직종       
	     	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr2200SrhVo.getDtilOccuInttnCd())); 
	     	insr2200SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세
	     	insr2200SrhVo.setBusinCd(MSFSharedUtils.allowNulls(insr2200SrhVo.getBusinCd()));   //사업
	        
	        insr2200SrhVo.setHanNm(MSFSharedUtils.allowNulls(insr2200SrhVo.getHanNm()));			//성명
	        insr2200SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(insr2200SrhVo.getResnRegnNum()));//주민번호
	        
	        
	        
	        insr2200SrhVo.setSystemkey(MSFSharedUtils.allowNulls(insr2200SrhVo.getSystemkey()));	//시스템키
	        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr2200SrhVo.getSystemkey())); 
	        insr2200SrhVo.setSystemKeyArr(systemKeyArr);
	        
	        String deptCd = MSFSharedUtils.allowNulls(insr2200SrhVo.getDeptCd());
	        
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	insr2200SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           insr2200SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           insr2200SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	insr2200SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr2200SrhVo.getPayrMangDeptCd()));  
	        	insr2200SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr2200SrhVo.getPayrMangDeptCd()));
	                 if (insr2200SrhVo.getPayrMangDeptCd().equals(insr2200SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	insr2200SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	insr2200SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 insr2200SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr2200SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr2200SrhVo.getDeptCd()));  
	                      insr2200SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        insr2200SrhVo.setDeptCdAuth(deptCd.replace(",", ""));  //권한처리를위해 추가  
	        insr2200SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr2200SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	        
	       /******************************** 권한 ************************************************************************/
	        Insr1600VO insr1600Vo = new Insr1600VO();
//	        List listInsr2200 = insr2300ExcelService.selectXlsInsr2200List(insr2200SrhVo);
	        
	        
	        
	        listInsr2200 = insr2300ExcelService.selectXlsInsr2200List(insr2200SrhVo);
	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	       

	    	for(int i=0; i<listInsr2200.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listInsr2200.get(i);
	    		// TODO 주민번호
	    		//nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("socnsrIssRegVal03")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("socnsrIssRegVal03", strValue);
	    		excelList.add(eMap);
	    	}
	        
	        
	        
	        result = 0L;
	
	        for(int i=0; i<listInsr2200.size(); i++){
	        	result = 0L;
	        	EgovMap eMap = (EgovMap)listInsr2200.get(i);
	        	Insr2100VO insr2100Vo = new  Insr2100VO();
	        	insr2100Vo.setDpobCd((String)eMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
	        	insr2100Vo.setSystemkey(MSFSharedUtils.allowNulls(eMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
	        	insr2100Vo.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls( eMap.get("soctyInsurCmptnDt")));
	        	BigDecimal bigDecimal =  (BigDecimal) eMap.get("socInsrLssEmymtNum");	
	        	insr2100Vo.setSocInsrLssEmymtNum(bigDecimal.longValue());    /** column 사회보험상실_고용_일련번호 : socInsrAqtnEmymtNum */
	        	insr2100Vo.setSocInsrMbrPhnNum((String) eMap.get("socnsrIssRegVal04")); /*사회보험가입자전화번호*/     	
	        	insr2100Vo.setSoctyInsurLssDt(MSFSharedUtils.allowNulls(eMap.get("socnsrIssRegVal08")));	/*사회보험상실일자*/       
	        	insr2100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
	        	insr2100Vo.setRevnAddr(request.getRemoteAddr());
	
	        	if(gubun == null || gubun.equals("")){
	        		insr2100Vo.setNatPennRegrstYn((String) eMap.get("natPennRegrstYn"));    /** column 국민연금신고여부 : natPennRegrstYn */
	            	insr2100Vo.setHlthInsrRegrstYn((String) eMap.get("hlthInsrRegrstYn"));    /** column 건강보험신고여부 : hlthInsrRegrstYn */
	            	insr2100Vo.setUmytInsrRegrstYn((String) eMap.get("umytInsrRegrstYn"));    /** column 고용보험신고여부 : umytInsrRegrstYn */
	            	insr2100Vo.setIdtlAccdtRegrstYn((String) eMap.get("idtlAccdtRegrstYn"));    /** column 산재보험신고여부 : idtlAccdtRegrstYn */
	
	        		result = insr2300ExcelService.updateXlsInsr2100(insr2100Vo);
	             	 //피부양자 업데이트
	    	        
	       	        insr1600Vo.setDpobCd((String)eMap.get("dpobCd"));
	       	        insr1600Vo.setSystemkey(MSFSharedUtils.allowNulls(eMap.get("systemkey")));
	       	        insr1600Vo.setFamyAqtnLssNum(bigDecimal.longValue());    /** column 피부양자취득상실_고용일련번호 : famyAqtnLssNum */
	       	        insr1600Vo.setFamyQuftDivCd("I0100002");
	       	        insr1600Vo.setSocrLssFamyYn("Y");
	       	        insr1600Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
	       	        insr1600Vo.setRevnAddr(request.getRemoteAddr());    /** column 수정주소 : revnAddr */
	       	        if(0 < insr2300ExcelService.selectInsr1600Check(insr1600Vo)){
	       	        	insr2300ExcelService.updateInsr1600(insr1600Vo);
	       	        }
	        	}else{
	        		if("natPennRegrst".equals(gubun)){
	        			insr2100Vo.setNatPennRegrstYn((String) eMap.get("natPennRegrstYn"));    /** column 국민연금신고여부 : natPennRegrstYn */
	        		}else if("hlthInsrRegrst".equals(gubun)){
	                 	 //피부양자 업데이트
	        	        
	           	        insr1600Vo.setDpobCd((String)eMap.get("dpobCd"));
	           	        insr1600Vo.setSystemkey(MSFSharedUtils.allowNulls(eMap.get("systemkey")));
	           	        insr1600Vo.setFamyAqtnLssNum(bigDecimal.longValue());    /** column 피부양자취득상실_고용일련번호 : famyAqtnLssNum */
	           	        insr1600Vo.setFamyQuftDivCd("I0100002");
	           	        insr1600Vo.setSocrLssFamyYn("Y");
	           	        insr1600Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
	           	        insr1600Vo.setRevnAddr(request.getRemoteAddr());    /** column 수정주소 : revnAddr */
	           	        if(0 < insr2300ExcelService.selectInsr1600Check(insr1600Vo)){
	           	        	insr2300ExcelService.updateInsr1600(insr1600Vo);
	           	        }
	        			insr2100Vo.setHlthInsrRegrstYn((String) eMap.get("hlthInsrRegrstYn"));    /** column 건강보험신고여부 : hlthInsrRegrstYn */
	        		}else if("umytInsrRegrst".equals(gubun)){
	        			insr2100Vo.setUmytInsrRegrstYn((String) eMap.get("umytInsrRegrstYn"));    /** column 고용보험신고여부 : umytInsrRegrstYn */
	        		}else if("idtlAccdtRegrst".equals(gubun)){
	        			insr2100Vo.setIdtlAccdtRegrstYn((String) eMap.get("idtlAccdtRegrstYn"));    /** column 산재보험신고여부 : idtlAccdtRegrstYn */
	        		}
	        		result = insr2300ExcelService.updateXlsInsr2100Each(insr2100Vo);
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
			//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:U");
        
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:U",e, windowNm , windowId);
        	
        }
        
        if (result == 0) {
        	Map<String, Object> map = new HashMap<String, Object>(); 
        	map.put("gubun",gubun);
        	return new ModelAndView("insr2300ExcelView", map);
        }else{
        	Map<String, Object> map = new HashMap<String, Object>(); 
        	map.put("listInsr2300", excelList);
        	map.put("gubun",gubun);
        	return new ModelAndView("insr2300ExcelView", map);
        }
    }
     

    
}
