package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Insr4300ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.insurance.server.vo.Insr3400SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Insr4300ExcelController {
	
	private static final Logger logger = LoggerFactory.getLogger(Insr4300ExcelController.class);
    private static final String calledClass = Insr4300ExcelController.class.getName();
    
	
	@Resource(name = "insr4300ExcelService")
	private Insr4300ExcelService insr4300ExcelService;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/**
	 * 엑셀파일로 출력한다.
	 * @param searchVO 검색조건
	 * @return 엑셀파일
	 * @throws Exception
	 */
	@RequestMapping(value = "/exp/XlsInsr4300Export.do")
	public ModelAndView xlsInsr3400Export(	@ModelAttribute("Insr3400SrhVO") Insr3400SrhVO insr3400SrhVo
										  , HttpServletRequest request
										  , ModelMap model
										 ) throws Exception {
		
		String method = calledClass + ".xlsInsr3400Export";
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		String windowNm = "휴퇴직자정산관리";
		String windowId = "INSR4300";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		List<String> listDeptCd = new ArrayList<String>();
		
		try{
		
			insr3400SrhVo.setUsrId(sessionUser.getUsrId());
			insr3400SrhVo.setDpobCd(sessionUser.getDpobCd());	/* 사업장코드 */
			insr3400SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());	/* 단위기관담당자여부 */
			insr3400SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(insr3400SrhVo.getMangeDeptCd()));/* 단위기관담당자여부 */
			insr3400SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(insr3400SrhVo.getRepbtyBusinDivCd())); 
			List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3400SrhVo.getTypOccuCd()));
			insr3400SrhVo.setTypOccuCdArr(lstTypeOccuCd);
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3400SrhVo.getDtilOccuInttnCd()));
			insr3400SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);
			
			List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3400SrhVo.getHdofcCodtnCd()));
			insr3400SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);
			
			/******************************** 권한 ************************************************************************/
			String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
			if("FALSE".equals(chkDeptCd)) {
				insr3400SrhVo.setDeptCd(sessionUser.getDeptCd());
				listDeptCd.add(sessionUser.getDeptCd());
				insr3400SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
				insr3400SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
			} else {
				insr3400SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr3400SrhVo.getPayrMangDeptCd()));
				if(insr3400SrhVo.getPayrMangDeptCd().equals(insr3400SrhVo.getDeptCd())) {
					listDeptCd = null;
					insr3400SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
					insr3400SrhVo.setDeptCd("");	/* 부서코드 */
				} else {
					insr3400SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr3400SrhVo.getDeptCd()));
					listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr3400SrhVo.getDeptCd()));
					insr3400SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
				}
			}
			
			insr3400SrhVo.setDeptCdAuth(insr3400SrhVo.getDeptCd().replace(",", ""));	/* 권한처리를위해 추가 */
			insr3400SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr3400SrhVo.getDtilOccuInttnCd()).replace(",", ""));
			
			/******************************** 권한 ************************************************************************/
			
			List listInsr3400 = insr4300ExcelService.selectXlsInsr3400List(insr3400SrhVo);
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listInsr3400.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listInsr3400.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}

//			Map<String, Object> map = new HashMap<String, Object>();
			map = new HashMap<String, Object>();
			map.put("listInsr3400", excelList);
			
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
		
		return new ModelAndView("insr4300ExcelView", map);
	}
}