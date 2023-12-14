package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.InsrP210002ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.insurance.server.service.dao.Insr1200DAO;
import com.app.exterms.insurance.server.vo.Insr1100SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class InsrP210002ExcelController {

    private static final Logger logger = LoggerFactory.getLogger(InsrP210002ExcelController.class);  
    private static final String calledClass = InsrP210002ExcelController.class.getName();

    
 
    @Resource(name = "insrP210002ExcelService")
    private InsrP210002ExcelService insrP210002ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    @Autowired
    @Resource(name="Insr1200DAO")
    private Insr1200DAO insr1200DAO;
    /**
     * 엑셀파일로 출력한다.
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsFileInsrP210002Export.do")   
    public ModelAndView xlsInsrP210002Export(@ModelAttribute("Insr1100SrhVO") Insr1100SrhVO insr1100SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception {
    	
    	String method = calledClass + ".xlsInsrP210002Export";
    	
    	String windowNm = "사회보험자격취득신고";
		String windowId = "INSRP210002";
    	
    	/** 조건절 */
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
    	List<String> listDeptCd = new ArrayList<String>(); 
    	Map<String, Object> map = new HashMap<String, Object>(); 
    	
		try{
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    	/*insr1100SrhVo.setUsrId(sessionUser.getUsrId());  
	    	insr1100SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	    	insr1100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	    	
	    	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1100SrhVo.getTypOccuCd())); 
	    	insr1100SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	    	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1100SrhVo.getDtilOccuInttnCd())); 
	    	insr1100SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	    	List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1100SrhVo.getHdofcCodtnCd())); 
	    	insr1100SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);  */
	    	
	    	
	    	
	    	insr1100SrhVo.setUsrId(sessionUser.getUsrId());  
	    	insr1100SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	    	insr1100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	    	insr1100SrhVo.setSoctyInsurCmptnDt01(MSFSharedUtils.allowNulls(insr1100SrhVo.getSoctyInsurCmptnDt01()));
	    	insr1100SrhVo.setSoctyInsurCmptnDt02(MSFSharedUtils.allowNulls(insr1100SrhVo.getSoctyInsurCmptnDt02()));
			List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1100SrhVo.getHdofcCodtnCd())); 
			insr1100SrhVo.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태
			insr1100SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(insr1100SrhVo.getEmymtDivCd()));	         //고용구분
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1100SrhVo.getTypOccuCd())); 
	        insr1100SrhVo.setTypOccuCdArr(lstTypeOccuCd); //직종       
	     	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1100SrhVo.getDtilOccuInttnCd())); 
	     	insr1100SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세
	     	insr1100SrhVo.setBusinCd(MSFSharedUtils.allowNulls(insr1100SrhVo.getBusinCd()));   //사업
	        
	     	insr1100SrhVo.setHanNm(MSFSharedUtils.allowNulls(insr1100SrhVo.getHanNm()));			//성명
	     	insr1100SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(insr1100SrhVo.getResnRegnNum()));//주민번호
	        
	     	insr1100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(insr1100SrhVo.getSystemkey()));	//시스템키
	        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1100SrhVo.getSystemkey())); 
	        insr1100SrhVo.setSystemKeyArr(systemKeyArr);
	    	
	
	    	/******************************** 권한 ************************************************************************/
	    	String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	    	if ("FALSE".equals(chkDeptCd)) {
	    		insr1100SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	    		listDeptCd.add(sessionUser.getDeptCd());
	    		insr1100SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	    		insr1100SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	    		insr1100SrhVo.setPayrMangeDeptCd(sessionUser.getPayrMangDeptCd()); 
	    	} else {
	    		insr1100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr1100SrhVo.getPayrMangDeptCd()));
	    		insr1100SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr1100SrhVo.getPayrMangDeptCd())) ;   //단위기관코드
	    		
	    		if (insr1100SrhVo.getPayrMangDeptCd().equals(insr1100SrhVo.getDeptCd())) { 
	    			listDeptCd = null; 
	    			insr1100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	    			insr1100SrhVo.setDeptCd("");  //부서코드
	    		} else {
	    			insr1100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr1100SrhVo.getDeptCd()));
	    			listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1100SrhVo.getDeptCd()));  
	    			insr1100SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	    		} 
	    	}
	    	insr1100SrhVo.setDeptCdAuth(insr1100SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
	    	insr1100SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr1100SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	    	/******************************** 권한 ************************************************************************/
	    	
	    	/**페이지 카운트 처리를 위한 부분 */
	 /*   	int iResultCnt = 0;
	        iResultCnt = insr1200DAO.selectInsrP210002ToInsr12000240ListTotCnt(insr1100SrhVo);
	        insr1100SrhVo.setPageSize(iResultCnt);  
	        insr1100SrhVo.setFirstIndex(1);
	        insr1100SrhVo.setLastIndex(iResultCnt); */
	       
	    	List insrP210002Excel = insrP210002ExcelService.selectXlsInsrP210002ToInsr12000240List(insr1100SrhVo);

	    	List<EgovMap> excelList = new ArrayList<EgovMap>();

	    	for(int i=0; i<insrP210002Excel.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) insrP210002Excel.get(i);
	    		// TODO 주민번호
	    		//nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	    		eMap.put("resnRegnNum", strValue);
	    		excelList.add(eMap);
	    	}

//	    	Map<String, Object> map = new HashMap<String, Object>(); 
	    	map = new HashMap<String, Object>(); 
	    	map.put("insrP210002Excel", excelList);
	    	
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

    	return new ModelAndView("insrP210002ExcelView", map);
    }
}
