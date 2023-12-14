package com.web.exterms.mypage.psnl.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;

import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.AnyLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.AnyWebServerUtils;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;
import com.ext.constants.PropConfs;
import com.web.exterms.mypage.board.web.BoardPageController;
import com.web.exterms.mypage.login.service.MyPageSessionVO;
import com.web.exterms.mypage.psnl.service.PsnlPageDefaultVO;
import com.web.exterms.mypage.psnl.service.PsnlPageService;
import com.web.exterms.mypage.psnl.service.PsnlPageVO;
import com.web.exterms.utils.WebSessionUtils;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.cas.service.EgovSessionCookieUtil;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : PsnlPageController.java
 * @Description : PsnlPage Controller class
 * @Modification Information
 * 
 * @author atres
 * @since 2014.07.06
 * @version 1.0
 * @see Copyright (C) All right reserved.
 */

@Controller
@SessionAttributes(types = PsnlPageVO.class)
public class PsnlPageController implements ServletContextAware, ServletConfigAware {

	private static final String calledClass = PsnlPageController.class.getName();	
	private ServletContext svltContext;
	private ServletConfig svltConfig;

	@Resource(name = "psnlPageService")
	private PsnlPageService psnlPageService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/** log */
	protected static final Log LOG = LogFactory.getLog(PsnlPageController.class);

	@Resource(name="messageSource")
	MessageSource messageSource ;

	@Override
	public void setServletConfig(final ServletConfig servletConfig) {
		this.svltConfig = servletConfig;

	}

	@Override
	public void setServletContext(final ServletContext servletContext) {
		this.svltContext = servletContext;

	}

	/**
	 * 개인정보 기본 정보 화면을 가져온다.
	 * @param hMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = {"/psnl/MyPsnlPage.do","/psnl/MyPsnlPageDetail.do"})
	public String selectMyPsnlPage(PsnlPageVO psnlPageVO, HttpSession session,HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {		
		String method = calledClass + ".selectMyPsnlPage";
		String windowNm = "기본정보";
		String windowId = "PsnlBasic";
		String returnPage = null;

		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser =AnyWebServerUtils.getLoggedUser(request);
		try{
			//암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(svltConfig,request);

			PsnlPageVO rtnFamilyVo = new PsnlPageVO();
			List rtnFamilyVoList = new ArrayList();  

			PsnlPageVO rtnPsnlvo = new PsnlPageVO();

			returnPage = "/mypage/psnl/PsnlBasic";

			if (sessionUser.getSystemkey() == null) {
				throw new Exception("세션정보 에러 프로그램오류"); 
			}
			String dpobCd = String.valueOf(sessionUser.getDpobCd()) ;
			String systemkey = String.valueOf(sessionUser.getSystemkey()) ;

			psnlPageVO.setDpobCd(dpobCd);
			psnlPageVO.setSystemkey(systemkey);

			model.addAttribute("ExTermPhoto", Globals.EXTERM_PHOTO);
			model.addAttribute("NonExTermPhoto", Globals.NON_EXTERM_PHOTO);
			model.addAttribute("ExTermMyPhotoUrl", Globals.EXTERM_MYPHOTO_URL);

			//우편번호 승인키 추가 	 
			String strConfKey = Globals.POSTSYSTEMKEY; 
			model.addAttribute("confmKey", strConfKey );  //승인키  

			try{

				String rrnPsnlDecCrypt = "";

				rtnPsnlvo = psnlPageService.selectPsnl0100(psnlPageVO);

				//암호화 모듈  호출 복호호 작업 수행 

				if (SmrmfUtils.dataNotNull(rtnPsnlvo)) {	
					rrnPsnlDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,SmrmfUtils.allowNulls(rtnPsnlvo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					rtnPsnlvo.setResnRegnNum(rrnPsnlDecCrypt);
				}
				model.addAttribute("memberInfo",rtnPsnlvo);

			}catch(Exception e){
				e.printStackTrace();
			}

			//가족사항 정보를 가져온다.
			if(request.getRequestURI().substring(request.getContextPath().length()).equals("/psnl/MyPsnlPageDetail.do")){
				returnPage = "/mypage/psnl/PsnlDetail";

				String rrnDecCrypt = "";			
				PsnlPageVO psnlFamVO = new PsnlPageVO();

				List egovDataList = psnlPageService.getFamilyList(psnlPageVO);

				for (int i = 0; i < egovDataList.size(); i++) {
					psnlFamVO = new PsnlPageVO();
					EgovMap egovMap = (EgovMap) egovDataList.get(i);
					psnlFamVO.setFamyRelaDivNm((String)egovMap.get("famyRelaDivNm"));     
					psnlFamVO.setFamyNm((String)egovMap.get("famyNm"));
					psnlFamVO.setAcadAbtyDivNm((String)egovMap.get("acadAbtyDivNm")); 
					psnlFamVO.setCrrNm((String)egovMap.get("crrNm"));
					psnlFamVO.setWkOfcNm((String)egovMap.get("wkOfcNm"));
					psnlFamVO.setInbyNm((String)egovMap.get("inbyNm"));
					psnlFamVO.setFamyResnRegnNum((String)egovMap.get("famyResnRegnNum"));
					psnlFamVO.setFrgnrYn((String)egovMap.get("frgnrYn"));
					psnlFamVO.setDabtyDivNm((String)egovMap.get("dabtyDivNm")); 
					psnlFamVO.setDabtyGrdeNm((String)egovMap.get("dabtyGrdeNm"));
					psnlFamVO.setFamyAllwPymtYn((String)egovMap.get("famyAllwPymtYn"));	

					if (SmrmfUtils.dataNotNull(psnlFamVO.getFamyResnRegnNum())) {
						// TODO 주민번호 
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,SmrmfUtils.allowNulls(psnlFamVO.getFamyResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						psnlFamVO.setFamyResnRegnNum(rrnDecCrypt);
					}
					rtnFamilyVoList.add(psnlFamVO);
				}
				model.addAttribute("familyList",rtnFamilyVoList);
			}		
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();		
			/** 에러 로그 **/			
			      
			AnyLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.LIST.toString(), e, windowNm, windowId);
		}

		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인			O:로그아웃
		 */
		AnyLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.LIST.toString());

		return returnPage;
	}
	/**
	 * 개인정보 신상정보 정보 화면을 가져온다.
	 * @param hMap
	 * @return
	 * @throws Exception
	 */	
	@RequestMapping(value="/psnl/getSubData.do")
	public String getSubData(PsnlPageVO psnlPageVO, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		String method = calledClass + ".getSubData";
		String windowNm = "신상정보";
		String windowId = "PsnlDetail";
		String returnPage = null;

		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser =AnyWebServerUtils.getLoggedUser(request);
		try{
			returnPage = "/mypage/psnl/ajaxFamyList";

			List rtnFamilyVoList = new ArrayList();
			ServletConfig sevltConfig = svltConfig;

			//암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(sevltConfig,request);

			String dpobCd = sessionUser.getDpobCd() == null ? "" : sessionUser.getDpobCd();
			String systemkey = sessionUser.getSystemkey() == null ? "" : sessionUser.getSystemkey();

			psnlPageVO.setDpobCd(dpobCd);
			psnlPageVO.setSystemkey(systemkey);

			if("famyLi".equals(psnlPageVO.getGetSubDataType())){

				String rrnDecCrypt = "";			
				PsnlPageVO psnlFamVO = new PsnlPageVO();

				List egovDataList = psnlPageService.getFamilyList(psnlPageVO);

				for (int i = 0; i < egovDataList.size(); i++) {
					psnlFamVO = new PsnlPageVO();
					EgovMap egovMap = (EgovMap) egovDataList.get(i);
					psnlFamVO.setFamyRelaDivNm((String)egovMap.get("famyRelaDivNm"));     
					psnlFamVO.setFamyNm((String)egovMap.get("famyNm"));
					psnlFamVO.setAcadAbtyDivNm((String)egovMap.get("acadAbtyDivNm")); 
					psnlFamVO.setCrrNm((String)egovMap.get("crrNm"));
					psnlFamVO.setWkOfcNm((String)egovMap.get("wkOfcNm"));
					psnlFamVO.setInbyNm((String)egovMap.get("inbyNm"));
					psnlFamVO.setFamyResnRegnNum((String)egovMap.get("famyResnRegnNum"));
					psnlFamVO.setFrgnrYn((String)egovMap.get("frgnrYn"));
					psnlFamVO.setDabtyDivNm((String)egovMap.get("dabtyDivNm")); 
					psnlFamVO.setDabtyGrdeNm((String)egovMap.get("dabtyGrdeNm"));
					psnlFamVO.setFamyAllwPymtYn((String)egovMap.get("famyAllwPymtYn"));	

					if (SmrmfUtils.dataNotNull(psnlFamVO.getFamyResnRegnNum())) {
						// TODO 주민번호 
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,SmrmfUtils.allowNulls(psnlFamVO.getFamyResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						psnlFamVO.setFamyResnRegnNum(rrnDecCrypt);
					}
					rtnFamilyVoList.add(psnlFamVO);
				}	

				model.addAttribute("familyList", rtnFamilyVoList);

			}else if("carrLi".equals(psnlPageVO.getGetSubDataType())){
				model.addAttribute("carrList", psnlPageService.getCarrList(psnlPageVO));
				returnPage = "/mypage/psnl/ajaxCarrList";
			}else if("rewardLi".equals(psnlPageVO.getGetSubDataType())){
				model.addAttribute("rewardList", psnlPageService.getRewardList(psnlPageVO));
				returnPage = "/mypage/psnl/ajaxRewardList";
			}
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();		
			/** 에러 로그 **/			
			AnyLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.LIST.toString(), e, windowNm, windowId);
		}

		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인			O:로그아웃
		 */
		AnyLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.LIST.toString());

		return returnPage;
	}
	/**
	 * 도로명 주소 팝업창 실행
	 * @param hMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/psnl/popupDoro.do")
	public String popupDoro(@RequestParam HashMap<String, String> hMap, Model model) throws Exception {
		return "/mypage/psnl/popupDoro";
	}
	/**
	 * 검색한 조건으로 도로명 주소 목록을 가져온다.
	 * @param hMap
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/psnl/getDoroList.do")
	public String getDoroList(@RequestParam HashMap<String, String> hMap, Model model) throws Exception {
		model.addAttribute("zipList", psnlPageService.getZipCodeList(hMap));
		return "/mypage/psnl/getDoroList";
	}


	/**
	 * 개인정보 저장
	 * */
	@ResponseBody
	@RequestMapping(value="/psnl/saveDoroInfo.do")
	public String saveDoroInfo(PsnlPageVO psnlPageVO, HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{
		String method = calledClass + ".saveDoroInfo";
		String windowNm = "도로명주소 수정";
		String windowId = "PsnlBasic";
		String value = "N";
		
		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser =AnyWebServerUtils.getLoggedUser(request);
		
		try{
			
			String dpobCd = sessionUser.getDpobCd() == null ? "" : sessionUser.getDpobCd();
			String systemkey = sessionUser.getSystemkey() == null ? "" : sessionUser.getSystemkey();

			psnlPageVO.setDpobCd(dpobCd);
			psnlPageVO.setSystemkey(systemkey);

			String clientIP = request.getRemoteAddr();

			psnlPageVO.setIsmt(sessionUser.getUsrId());
			psnlPageVO.setRevnAddr(clientIP);		

			int updCnt = psnlPageService.updateDoroAddr(psnlPageVO);
			if(updCnt == 1){
				value = "S";
			}
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();		
			/** 에러 로그 **/			
			AnyLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.UPDATE.toString(), e, windowNm, windowId);
		}

		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인			O:로그아웃
		 */
		AnyLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.UPDATE.toString());

		return value;
	}

	/**
	 * PSNL0100 목록을 조회한다. (pageing)
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 PsnlPageDefaultVO
	 * @return "/psnlPage/PsnlPageList"
	 * @exception Exception
	 */
	@RequestMapping(value = "/psnlPage/PsnlPageList.do")
	public String selectPsnlPageList(
			@ModelAttribute("searchVO") PsnlPageDefaultVO searchVO,
			ModelMap model) throws Exception {

		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List psnlPageList = psnlPageService.selectPsnlPageList(searchVO);
		model.addAttribute("resultList", psnlPageList);

		int totCnt = psnlPageService.selectPsnlPageListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/psnlPage/PsnlPageList";
	}

	@RequestMapping("/psnlPage/addPsnlPageView.do")
	public String addPsnlPageView(
			@ModelAttribute("searchVO") PsnlPageDefaultVO searchVO, Model model)
					throws Exception {
		model.addAttribute("psnlPageVO", new PsnlPageVO());
		return "/psnlPage/PsnlPageRegister";
	}

	@RequestMapping("/psnlPage/addPsnlPage.do")
	public String addPsnlPage(PsnlPageVO psnlPageVO,
			@ModelAttribute("searchVO") PsnlPageDefaultVO searchVO,
			SessionStatus status) throws Exception {
		psnlPageService.insertPsnlPage(psnlPageVO);
		status.setComplete();
		return "forward:/psnlPage/PsnlPageList.do";
	}

	@RequestMapping("/psnlPage/updatePsnlPageView.do")
	public String updatePsnlPageView(
			@RequestParam("dpobCd") java.lang.String dpobCd,
			@RequestParam("systemkey") java.lang.String systemkey,
			@ModelAttribute("searchVO") PsnlPageDefaultVO searchVO, Model model)
					throws Exception {
		PsnlPageVO psnlPageVO = new PsnlPageVO();
		psnlPageVO.setDpobCd(dpobCd);
		psnlPageVO.setSystemkey(systemkey);
		// 변수명은 CoC 에 따라 psnlPageVO
		model.addAttribute(selectPsnlPage(psnlPageVO, searchVO));
		return "/psnlPage/PsnlPageRegister";
	}

	@RequestMapping("/psnlPage/selectPsnlPage.do")
	public @ModelAttribute("psnlPageVO")
	PsnlPageVO selectPsnlPage(PsnlPageVO psnlPageVO,
			@ModelAttribute("searchVO") PsnlPageDefaultVO searchVO)
					throws Exception {
		return psnlPageService.selectPsnlPage(psnlPageVO);
	}

	@RequestMapping("/psnlPage/updatePsnlPage.do")
	public String updatePsnlPage(PsnlPageVO psnlPageVO,
			@ModelAttribute("searchVO") PsnlPageDefaultVO searchVO,
			SessionStatus status) throws Exception {
		psnlPageService.updatePsnlPage(psnlPageVO);
		status.setComplete();
		return "forward:/psnlPage/PsnlPageList.do";
	}

	@RequestMapping("/psnlPage/deletePsnlPage.do")
	public String deletePsnlPage(PsnlPageVO psnlPageVO,
			@ModelAttribute("searchVO") PsnlPageDefaultVO searchVO,
			SessionStatus status) throws Exception {
		psnlPageService.deletePsnlPage(psnlPageVO);
		status.setComplete();
		return "forward:/psnlPage/PsnlPageList.do";
	}

}
