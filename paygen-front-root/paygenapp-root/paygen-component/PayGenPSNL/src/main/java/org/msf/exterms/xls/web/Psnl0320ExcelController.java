package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Psnl0320ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.personal.server.vo.Psnl0320SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Psnl0320ExcelController {


    private static final Logger logger = LoggerFactory.getLogger(Psnl0320ExcelController.class);  
    private static final String calledClass = Psnl0320ExcelController.class.getName();

 
    
    @Resource(name = "psnl0320ExcelService")
    private Psnl0320ExcelService psnl0320ExcelService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

    /**
     * 엑셀파일로 출력한다.(기본)
     * @param searchVO 검색조건
     * @return 엑셀파일
     * @throws Exception
     */
    @RequestMapping(value="/exp/XlsFilePsnl0320Export.do")
    public ModelAndView XlsFilePsnl0320Export(@ModelAttribute("Insr2200SrhVO") Psnl0320SrhVO psnl0320SrhVo,HttpServletRequest request ,ModelMap model) 
                    throws Exception { 
    	
    	String method = calledClass + ".XlsFilePsnl0320Export";
    	
      
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        List<String> listDeptCd = new ArrayList<String>(); 
    			
		
			
			psnl0320SrhVo.setUsrId(sessionUser.getUsrId());  
			psnl0320SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
			psnl0320SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			psnl0320SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(psnl0320SrhVo.getMangeDeptCd()));  //관리부서 
			psnl0320SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(psnl0320SrhVo.getRepbtyBusinDivCd())); 
			psnl0320SrhVo.setSrhLogStdDt(MSFSharedUtils.allowNulls(psnl0320SrhVo.getSrhLogStdDt())); //기준일자		
			List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0320SrhVo.getHdofcCodtnCd())); 
			psnl0320SrhVo.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태			
			psnl0320SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(psnl0320SrhVo.getEmymtDivCd()));	         //고용구분			
	        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0320SrhVo.getTypOccuCd())); 
	        psnl0320SrhVo.setTypOccuCdArr(lstTypeOccuCd); //직종       	        
	     	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0320SrhVo.getDtilOccuInttnCd())); 
	     	psnl0320SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세     	
	     	psnl0320SrhVo.setBusinCd(MSFSharedUtils.allowNulls(psnl0320SrhVo.getBusinCd()));   //사업
	     	psnl0320SrhVo.setHanNm(MSFSharedUtils.allowNulls(psnl0320SrhVo.getHanNm()));			//성명
	     	psnl0320SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(psnl0320SrhVo.getResnRegnNum()));//주민번호
	     	psnl0320SrhVo.setSystemkey(MSFSharedUtils.allowNulls(psnl0320SrhVo.getSystemkey()));	//시스템키
	        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0320SrhVo.getSystemkey())); 
	        psnl0320SrhVo.setSystemKeyArr(systemKeyArr);
	        String deptCd = MSFSharedUtils.allowNulls(psnl0320SrhVo.getDeptCd());
	         
	        /******************************** 권한 ************************************************************************/
	        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	        if ("FALSE".equals(chkDeptCd)) {
	        	psnl0320SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	           listDeptCd.add(sessionUser.getDeptCd());
	           psnl0320SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	           psnl0320SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	        } else {
	        	    
	        	psnl0320SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(psnl0320SrhVo.getPayrMangDeptCd()));    
	                 if (psnl0320SrhVo.getPayrMangDeptCd().equals(psnl0320SrhVo.getDeptCd())) { 
	                 	 listDeptCd = null; 
	                 	psnl0320SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                 	psnl0320SrhVo.setDeptCd("");  //부서코드
	                 } else {
	                	 psnl0320SrhVo.setDeptCd(MSFSharedUtils.allowNulls(psnl0320SrhVo.getDeptCd()));
	                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(psnl0320SrhVo.getDeptCd()));  
	                      psnl0320SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                 } 
	              
	        }
	        psnl0320SrhVo.setDeptCdAuth(deptCd.replace(",", ""));  //권한처리를위해 추가  
	        psnl0320SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(psnl0320SrhVo.getDtilOccuInttnCd()).replace(",", ""));
	  
	       /******************************** 권한 ************************************************************************/
	 
	        List listPsnl0320 = psnl0320ExcelService.selectXlsPsnl0320List(psnl0320SrhVo);
	        
	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    	List<EgovMap> excelList = new ArrayList<EgovMap>();

	    	for(int i=0; i<listPsnl0320.size(); i++){
	    		EgovMap eMap  = new EgovMap();
	    		eMap = (EgovMap) listPsnl0320.get(i);
	    		// TODO 주민번호
	    		//nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
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
				//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
	        
	        	Map<String, Object> map = new HashMap<String, Object>(); 
	        	map.put("listPsnl0320", excelList);
	            map.put("srhLogStdDt", psnl0320SrhVo.getSrhLogStdDt());
	        	return new ModelAndView("psnl0320ExcelView", map);

		
    }

}
