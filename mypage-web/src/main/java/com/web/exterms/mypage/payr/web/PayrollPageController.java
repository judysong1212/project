package com.web.exterms.mypage.payr.web;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
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
import com.ibm.icu.text.SimpleDateFormat;
import com.web.exterms.mypage.board.web.BoardPageController;
import com.web.exterms.mypage.login.service.MyPageSessionVO;
import com.web.exterms.mypage.payr.service.PayrollPageDefaultVO;
import com.web.exterms.mypage.payr.service.PayrollPageService;
import com.web.exterms.mypage.payr.service.PayrollPageVO;
import com.web.exterms.utils.WebSessionUtils;

import egovframework.com.utl.cas.service.EgovSessionCookieUtil;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : Payr0100Controller.java
 * @Description : Payr0100 Controller class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
@SessionAttributes(types=PayrollPageVO.class)
public class PayrollPageController implements ServletContextAware, ServletConfigAware {

	private static final String calledClass = PayrollPageController.class.getName();
	private ServletContext svltContext;
	private ServletConfig svltConfig;

	@Resource(name = "payr0100Service")
	private PayrollPageService payr0100Service;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	@Override
	public void setServletConfig(final ServletConfig servletConfig) {
		this.svltConfig = servletConfig;

	}

	@Override
	public void setServletContext(final ServletContext servletContext) {
		this.svltContext = servletContext;

	}

	@ResponseBody
	@RequestMapping(value="/payr/addMonthCookies.do")
	public String addMonthCookies(HttpSession session, HttpServletRequest request, HttpServletResponse response, @RequestParam HashMap<String, String> hMap, Model model) throws Exception {

		String returnVal = "";

		MSFUserInfoVO sessionUser = (MSFUserInfoVO)AnyWebServerUtils.getLoggedUser(request);	

		if (sessionUser.getSystemkey() == null) {
			throw new Exception("세션정보 에러 프로그램오류"); 
		}
		String SYSTEMKEY = sessionUser.getSystemkey();  

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 30);

		try {
			EgovSessionCookieUtil.setCookie(response, "COOKIE_CHILDHDAY_"+SYSTEMKEY, SYSTEMKEY+"_"+new SimpleDateFormat("yyyyMMdd").format(c.getTime()), 60 * 24 * 30,"/");
			returnVal ="Y";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			returnVal ="N";
		} 
		return returnVal;
	}

	@RequestMapping(value="/payr/popupChildHday.do")
	public String popupChildHday(HttpServletRequest request, @RequestParam HashMap<String, String> hMap, Model model) throws Exception{

		model.addAttribute("nowMonth", new SimpleDateFormat("MM").format(new Date()));

		return "/mypage/payr/popupChildHday";
	}

	/**
	 * 급여지급내역 
	 * PSNL0550 목록을 조회한다. (pageing)
	 * @exception Exception
	 */
	@RequestMapping(value="/payr/MyPayrPage.do")
	public String selectMyPayrPage(PayrollPageVO payrollPageVO ,HttpSession session, HttpServletRequest request, Model model, HttpServletResponse response)
			throws Exception {
		String method = calledClass + ".selectMyPayrPage";
		String windowNm = "급여지급내역 조회";
		String windowId = "Payroll";
		
		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser =AnyWebServerUtils.getLoggedUser(request);
		
		// 임시 로그인 처리 
		payrollPageVO.setDpobCd(sessionUser.getDpobCd());
		payrollPageVO.setSystemkey(sessionUser.getSystemkey());

		try{
			String SYSTEMKEY = payrollPageVO.getSystemkey() == null ? sessionUser.getSystemkey() : payrollPageVO.getSystemkey(); // 쿠키처리 (로그인 SSO 세션으로 대체 해야함)

			payrollPageVO.setPayCd(payrollPageVO.getPayCd() == null ? "B0150000" : payrollPageVO.getPayCd()); // 급여구분 
			payrollPageVO.setPymtYr(payrollPageVO.getPymtYr() == null ? new SimpleDateFormat("yyyy").format(new Date()) : payrollPageVO.getPymtYr() );

			model.addAttribute("payList", payr0100Service.getPayList(payrollPageVO));
			model.addAttribute("getChildHday", payr0100Service.getChildHday(payrollPageVO) == null ? "0" : payr0100Service.getChildHday(payrollPageVO) );

			String cookieValue = EgovSessionCookieUtil.getCookie(request, "COOKIE_CHILDHDAY_"+SYSTEMKEY) == null ? "" : EgovSessionCookieUtil.getCookie(request, "COOKIE_CHILDHDAY_"+SYSTEMKEY) ;

			if(!"".equals(cookieValue) && Integer.parseInt(cookieValue.split("_")[1]) >= Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date())) ){
				//쿠키값이 저장되어 있으면서 뒷날짜가 현재날짜보다 크거나 같으면 팝업 금지
				model.addAttribute("openPopChildHdayYN", "N");
			}else{
				model.addAttribute("openPopChildHdayYN", "Y");
			}
			model.addAttribute("reqparams", payrollPageVO);
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

		return "/mypage/payr/Payroll";
	}

	/**
	 * 급여상세내역 검색
	 * */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/payr/MyPayrPageDetail.do")
	public String selectMyPayrPageDetail(PayrollPageVO payrollPageVO, HttpSession session, HttpServletRequest request, HttpServletResponse response,@RequestParam HashMap<String, String> hMap, Model model)
			throws Exception { 
		String method = calledClass + ".selectMyPayrPageDetail";
		String windowNm = "급여상세내역 조회";
		String windowId = "PayrDetail";

		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser =AnyWebServerUtils.getLoggedUser(request);
		try{
			//암호화 객체 생성	
			String nResult = AnyCryptUtils.XecureCryptInitialize(svltConfig,request);
			String rrnDecCrypt = "";

			PayrollPageVO vo =  new PayrollPageVO();

			payrollPageVO.setDpobCd(sessionUser.getDpobCd());
			payrollPageVO.setSystemkey(sessionUser.getSystemkey());

			payrollPageVO.setPymtYr(payrollPageVO.getPymtYr() == null ? new SimpleDateFormat("yyyy").format(new Date()) : payrollPageVO.getPymtYr() );

			payrollPageVO.setSearchYear(payrollPageVO.getSearchYear() == null ? new SimpleDateFormat("yyyy").format(new Date()) : payrollPageVO.getSearchYear());
			payrollPageVO.setSearchMonth(payrollPageVO.getSearchMonth() == null ? new SimpleDateFormat("MM").format(new Date()) : payrollPageVO.getSearchMonth());
			payrollPageVO.setSearchDivision(SmrmfUtils.dataNull(payrollPageVO.getSearchDivision()) ? "B0150000" : payrollPageVO.getSearchDivision());

			vo = payr0100Service.getPayDetailMemberInfo(payrollPageVO);

			/**
			 * 암호화 모듈  호출 복호호 작업 수행 
			 */
			if (SmrmfUtils.dataNotNull(vo)) {
				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,SmrmfUtils.allowNulls(vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				vo.setResnRegnNum(rrnDecCrypt);
			}
			model.addAttribute("getPayDetailMemberInfo",vo);                                                //인적사항
			model.addAttribute("getPayDetailPay", payr0100Service.getPayDetailPay(payrollPageVO));						//실수령액(차인지급액)
			model.addAttribute("getPayDetailExtpyList", payr0100Service.getPayDetailExtpyList(payrollPageVO));			//보수계
			model.addAttribute("getPayDetailDducList", payr0100Service.getPayDetailDducList(payrollPageVO));				//공세계
			model.addAttribute("getPayDetailDivisionList", payr0100Service.getPayDetailExtpyList2(payrollPageVO));		//급여구분
			model.addAttribute("reqparams", payrollPageVO);
			
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

		return "/mypage/payr/PayrDetail";
	}

	/**
	 * 단가표 조회
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/payr/popupCost.do")
	public String popupDoro(PayrollPageVO payrollPageVO, HttpSession session, HttpServletRequest request, Model model) throws Exception {
		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser =AnyWebServerUtils.getLoggedUser(request);

		payrollPageVO.setDpobCd(sessionUser.getDpobCd());
		payrollPageVO.setSystemkey(sessionUser.getSystemkey());

		payrollPageVO.setPymtYr(payrollPageVO.getPymtYr() == null ? new SimpleDateFormat("yyyy").format(new Date()) : payrollPageVO.getPymtYr() );

		model.addAttribute("reqparams", payrollPageVO);
		model.addAttribute("getMyCost", payr0100Service.getMyCost(payrollPageVO));
		//model.addAttribute("getMyCostInfo", payr0100Service.getMyCostInfo(hMap));

		return "/mypage/payr/popupCost";
	}


	//연말정산조회 부 처리 루틴 추가 


	/**
	 * PAYR0100 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 Payr0100DefaultVO
	 * @return "/payr0100/Payr0100List"
	 * @exception Exception
	 */
	@RequestMapping(value="/payr0100/Payr0100List.do")
	public String selectPayr0100List(@ModelAttribute("searchVO") PayrollPageDefaultVO searchVO, ModelMap model) throws Exception {

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

		List payr0100List = payr0100Service.selectPayr0100List(searchVO);
		model.addAttribute("resultList", payr0100List);

		int totCnt = payr0100Service.selectPayr0100ListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/payr0100/Payr0100List";
	} 

	@RequestMapping("/payr0100/addPayr0100View.do")
	public String addPayr0100View(@ModelAttribute("searchVO") PayrollPageDefaultVO searchVO, Model model)throws Exception {
		model.addAttribute("payr0100VO", new PayrollPageVO());
		return "/payr0100/Payr0100Register";
	}

	@RequestMapping("/payr0100/addPayr0100.do")
	public String addPayr0100(
			PayrollPageVO payr0100VO,
			@ModelAttribute("searchVO") PayrollPageDefaultVO searchVO, SessionStatus status)throws Exception {
		payr0100Service.insertPayr0100(payr0100VO);
		status.setComplete();
		return "forward:/payr0100/Payr0100List.do";
	}

	@RequestMapping("/payr0100/updatePayr0100View.do")
	public String updatePayr0100View(
			@RequestParam("dpobCd") java.lang.String dpobCd ,
			@RequestParam("apptnYr") java.lang.String apptnYr ,
			@RequestParam("eandIncmTxtbSimfTxsNum") java.math.BigDecimal eandIncmTxtbSimfTxsNum ,
			@ModelAttribute("searchVO") PayrollPageDefaultVO searchVO, Model model)throws Exception {
		PayrollPageVO payr0100VO = new PayrollPageVO();
		payr0100VO.setDpobCd(dpobCd);
		payr0100VO.setApptnYr(apptnYr);
		payr0100VO.setEandIncmTxtbSimfTxsNum(eandIncmTxtbSimfTxsNum);
		// 변수명은 CoC 에 따라 payr0100VO
		model.addAttribute(selectPayr0100(payr0100VO, searchVO));
		return "/payr0100/Payr0100Register";
	}

	@RequestMapping("/payr0100/selectPayr0100.do")
	public @ModelAttribute("payr0100VO")
	PayrollPageVO selectPayr0100(
			PayrollPageVO payr0100VO,
			@ModelAttribute("searchVO") PayrollPageDefaultVO searchVO) throws Exception {
		return payr0100Service.selectPayr0100(payr0100VO);
	}

	@RequestMapping("/payr0100/updatePayr0100.do")
	public String updatePayr0100(
			PayrollPageVO payr0100VO,
			@ModelAttribute("searchVO") PayrollPageDefaultVO searchVO, SessionStatus status)throws Exception {
		payr0100Service.updatePayr0100(payr0100VO);
		status.setComplete();
		return "forward:/payr0100/Payr0100List.do";
	}

	@RequestMapping("/payr0100/deletePayr0100.do")
	public String deletePayr0100(
			PayrollPageVO payr0100VO,
			@ModelAttribute("searchVO") PayrollPageDefaultVO searchVO, SessionStatus status)throws Exception {
		payr0100Service.deletePayr0100(payr0100VO);
		status.setComplete();
		return "forward:/payr0100/Payr0100List.do";
	}

}
