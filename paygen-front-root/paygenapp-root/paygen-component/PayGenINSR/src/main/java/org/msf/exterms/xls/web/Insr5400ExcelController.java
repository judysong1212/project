package org.msf.exterms.xls.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.exterms.xls.service.Insr5400ExcelService;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.exterms.insurance.server.vo.Insr5400SrhVO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class Insr5400ExcelController {
	private static final Logger logger = LoggerFactory.getLogger(Insr5400ExcelController.class);
    private static final String calledClass = Insr5400ExcelController.class.getName();
	
	//@Resource(name = "insr5400ExcelService")
	@Resource(name = "Insr5400ExcelService")
	private Insr5400ExcelService insr5400ExcelService;
	
	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/**
	 * 엑셀파일로 출력한다.
	 * @param searchVO 검색조건
	 * @return 엑셀파일
	 * @throws Exception
	 */
	@RequestMapping(value = "/exp/XlsFileInsr5400Export.do")
	public ModelAndView xlsInsr5400Export(	@ModelAttribute("Insr5400SrhVO") Insr5400SrhVO insr5400SrhVo, HttpServletRequest request, ModelMap model ) throws Exception {

//		logger.debug("000001");
		
		String method = calledClass + ".xlsInsr5400Export";
		
		String windowNm = "고용보험보수총액신고";
		String windowId = "INSR5400";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		List<String> listDeptCd = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		try{
        	
			insr5400SrhVo.setUsrId(sessionUser.getUsrId());
			insr5400SrhVo.setDpobCd(sessionUser.getDpobCd());	/* 사업장코드 */
			insr5400SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());	/* 단위기관담당자여부 */
			insr5400SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(insr5400SrhVo.getMangeDeptCd()));  
			insr5400SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(insr5400SrhVo.getRepbtyBusinDivCd())); 
			 
			List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5400SrhVo.getTypOccuCd()));
			insr5400SrhVo.setTypOccuCdArr(lstTypeOccuCd);
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5400SrhVo.getDtilOccuInttnCd()));
			insr5400SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);
			
			List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5400SrhVo.getHdofcCodtnCd()));
			insr5400SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd);
			
			/******************************** 권한 ************************************************************************/
			String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
			if("FALSE".equals(chkDeptCd)) {
				insr5400SrhVo.setDeptCd(sessionUser.getDeptCd());
				listDeptCd.add(sessionUser.getDeptCd());
				insr5400SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
				insr5400SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
			} else {
				insr5400SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr5400SrhVo.getPayrMangDeptCd()));
				if(insr5400SrhVo.getPayrMangDeptCd().equals(insr5400SrhVo.getDeptCd())) {
					listDeptCd = null;
					insr5400SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
					insr5400SrhVo.setDeptCd("");	/* 부서코드 */
				} else {
					insr5400SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr5400SrhVo.getDeptCd()));
					listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr5400SrhVo.getDeptCd()));
					insr5400SrhVo.setDeptCdArr(listDeptCd);	/* 부서코드 */
				}
			}
			
			insr5400SrhVo.setDeptCdAuth(insr5400SrhVo.getDeptCd().replace(",", ""));	/* 권한처리를위해 추가 */
	
	
			logger.debug("getSrhHlthInsrYr[" + insr5400SrhVo.getSrhHlthInsrYr() + "]");
			logger.debug("getPayCd[" + insr5400SrhVo.getPayCd() + "]");
			logger.debug("getPayrMangDeptCd[" + insr5400SrhVo.getPayrMangDeptCd() + "]");//단위기관
			//성명
			
			logger.debug("getEmymtDivCd[" + insr5400SrhVo.getEmymtDivCd() + "]");//고용구분
			logger.debug("getDeptCd[" + insr5400SrhVo.getDeptCd() + "]");//부서
			logger.debug("getDeptCdArr[" + insr5400SrhVo.getDeptCdArr() + "]");//부서
			logger.debug("getTypOccuCd[" + insr5400SrhVo.getTypOccuCd() + "]");//직종
			
			/******************************** 권한 ************************************************************************/
			
			List listFileInsr5400 = insr5400ExcelService.selectXlsInsr5400List(insr5400SrhVo);
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			List<EgovMap> excelList = new ArrayList<EgovMap>();

			for(int i=0; i<listFileInsr5400.size(); i++){
				EgovMap eMap  = new EgovMap();
				eMap = (EgovMap) listFileInsr5400.get(i);
				// TODO 주민번호
				String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(eMap.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				eMap.put("resnRegnNum", strValue);
				excelList.add(eMap);
			}

			
			
			logger.debug("000002");
			
//			Map<String, Object> map = new HashMap<String, Object>();
			map = new HashMap<String, Object>();
			//map.put("listInsr3100", listInsr3100);
			map.put("listInsr5400", excelList);
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			//MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
			//return new ModelAndView("insr4500ExcelView", map);
			//return new ModelAndView("insr5400ExcelView", map);
			
        }catch(Exception e) {
        	e.printStackTrace();
        	
	    	/** 에러 로그 **/			
	    	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
        	
        }
		return new ModelAndView("insr5400ExcelView", map);
	}
}