package com.web.exterms.mypage.iucert.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.app.smrmf.core.msfmainapp.server.utils.AnyLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.AnyWebServerUtils;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;
import com.ext.constants.PropConfs;
import com.web.exterms.mypage.iucert.service.PsnlProofAcceptDefaultVO;
import com.web.exterms.mypage.iucert.service.PsnlProofAcceptService;
import com.web.exterms.mypage.iucert.service.PsnlProofAcceptVO;
import com.web.exterms.mypage.login.service.MyPageSessionVO;
import com.web.exterms.mypage.psnl.service.PsnlPageService;
import com.web.exterms.utils.WebSessionUtils;

import egovframework.com.utl.cas.service.EgovSessionCookieUtil;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : Psnl0550Controller.java
 * @Description : Psnl0550 Controller class
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
@SessionAttributes(types=PsnlProofAcceptVO.class)
public class PsnlProofAcceptController {

	private static final String calledClass = PsnlProofAcceptController.class.getName();
	private ServletContext svltContext;
	private ServletConfig svltConfig;

	@Resource(name = "psnl0550Service")
	private PsnlProofAcceptService psnl0550Service;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	@Resource(name = "psnlPageService")
	private PsnlPageService psnlPageService;


	/** @ResponseBody : 리턴값이 view를 통해서 출력되지 않고 HTTP Response Body에 직접 쓰여짐 */
	@ResponseBody
	@RequestMapping(value="/ajax/afterPrintDown.do")
	public String afterPrintDown(PsnlProofAcceptVO psnlProofAcceptVO, HttpServletRequest request, Model model, HttpSession session) throws Exception{
		int returnVal = 0;
		try{
			String clientIP = request.getHeader("Proxy-Client-IP");
			if(clientIP == null){
				clientIP = request.getHeader("WL-Proxy-Client-IP");
				if(clientIP == null){
					clientIP = request.getHeader("X-Forwared-For");
					if(clientIP == null){
						clientIP = request.getRemoteAddr();
					}
				} 
			}
			MSFUserInfoVO sessionUser = (MSFUserInfoVO) AnyWebServerUtils.getLoggedUser(request);	

			psnlProofAcceptVO.setIsmt(sessionUser.getUsrId());
			psnlProofAcceptVO.setRevnAddr(clientIP);

			returnVal = psnlPageService.afterPrintDown(psnlProofAcceptVO);

		}catch(Exception e){
			e.printStackTrace();
		}
		return returnVal+"";
	}

	/* 원천징수 인쇄 처리후 변경을 위해서 추가 */
	/** @ResponseBody : 리턴값이 view를 통해서 출력되지 않고 HTTP Response Body에 직접 쓰여짐 */
	@ResponseBody
	@RequestMapping(value="/ajax/afterPrintDown2.do")
	public String afterPrintDown2(PsnlProofAcceptVO psnlProofAcceptVO, HttpServletRequest request, Model model, HttpSession session) throws Exception{
		int returnVal = 0;
		try{
			String clientIP = request.getHeader("Proxy-Client-IP");
			if(clientIP == null){
				clientIP = request.getHeader("WL-Proxy-Client-IP");
				if(clientIP == null){
					clientIP = request.getHeader("X-Forwared-For");
					if(clientIP == null){
						clientIP = request.getRemoteAddr();
					}
				} 
			}
			MSFUserInfoVO sessionUser = (MSFUserInfoVO) AnyWebServerUtils.getLoggedUser(request);	

			psnlProofAcceptVO.setIsmt(sessionUser.getUsrId());
			psnlProofAcceptVO.setRevnAddr(clientIP);

			returnVal = psnlPageService.afterPrintDown2(psnlProofAcceptVO);


		}catch(Exception e){
			e.printStackTrace();
		}
		return returnVal+"";
	}

	/**
	 * PSNL0550 목록을 조회한다. (pageing)
	 * @exception Exception
	 */
	@RequestMapping(value={"/cert/MyIuCertPage.do","/cert/MyIuCertPage2.do"})
	public String selectMyIuCertPage(PsnlProofAcceptVO psnlProofAcceptVO, HttpSession session , HttpServletRequest request, HttpServletResponse response,
			@RequestParam HashMap<String, String> hMap, Model model) throws Exception {
		String method = calledClass + ".selectMyIuCertPage";
		String windowNm = " 재증명발급";
		String windowId = "ProofAccept";
		String returnPage = null;

		MSFUserInfoVO sessionUser = (MSFUserInfoVO) AnyWebServerUtils.getLoggedUser(request);

		try{
			returnPage = "/mypage/iucert/ProofAccept";
			String title = "증명발급신청";
			String certType = "1"; //증명발급타입

			// 임시 로그인 처리 
			psnlProofAcceptVO.setDpobCd(sessionUser.getDpobCd());
			psnlProofAcceptVO.setSystemkey(sessionUser.getSystemkey());

			// 페이징 관련 시작
			psnlProofAcceptVO.setRowcount(psnlProofAcceptVO.getRowcount()== null ? "5" : psnlProofAcceptVO.getRowcount());
			psnlProofAcceptVO.setCurrentpage(psnlProofAcceptVO.getCurrentpage()== null ? "1" :psnlProofAcceptVO.getCurrentpage());
			// 페이장 관련 끝

			if(request.getRequestURI().substring(request.getContextPath().length()).equals("/cert/MyIuCertPage2.do")){
				//returnPage = "/mypage/iucert/WithHoldingAccept";
				title = "원천징수신청";
				certType = "2";
				psnlProofAcceptVO.setCertType(certType);
				//hMap.put("certType", certType);
				model.addAttribute("certList", psnlPageService.getPayrCertList(psnlProofAcceptVO));
				model.addAttribute("certListTotCnt", psnlPageService.getPayrCertListTotCnt(psnlProofAcceptVO));

			}else{
				psnlProofAcceptVO.setCertType(certType);
				//hMap.put("certType", certType);
				model.addAttribute("certList", psnlPageService.getCertList(psnlProofAcceptVO));
				model.addAttribute("certListTotCnt", psnlPageService.getCertListTotCnt(psnlProofAcceptVO));
			}

			model.addAttribute("getCertType", psnlPageService.getCertType(psnlProofAcceptVO));

			model.addAttribute("reqparams", psnlProofAcceptVO); 
			model.addAttribute("title", title);
			model.addAttribute("certType", certType);
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
	 * 증명서 발급 신청
	 * @exception Exception
	 */
	@RequestMapping(value="/cert/regCert.do")
	public String regCert(PsnlProofAcceptVO psnlProofAcceptVO, HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception{
		String method = calledClass + ".regCert";
		String windowNm = " 증명발급 신청";
		String windowId = "ProofAccept";

		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser = (MSFUserInfoVO) AnyWebServerUtils.getLoggedUser(request);

		try{
			psnlProofAcceptVO.setDpobCd(sessionUser.getDpobCd());
			psnlProofAcceptVO.setSystemkey(sessionUser.getSystemkey());

			String clientIP = request.getHeader("Proxy-Client-IP");	//클라이언트 ip주소 가져오기
			if(clientIP == null){
				clientIP = request.getHeader("WL-Proxy-Client-IP");	//클라이언트 ip주소 가져오기
				if(clientIP == null){
					clientIP = request.getHeader("X-Forwared-For");	//클라이언트 ip주소 가져오기
					if(clientIP == null){
						clientIP = request.getRemoteAddr();
					}
				} 
			}
			psnlProofAcceptVO.setIsmt("");
			psnlProofAcceptVO.setRevnAddr(clientIP);

			psnlProofAcceptVO.setIssYn("N");
			psnlProofAcceptVO.setCertcIssDelYn("N");
			psnlProofAcceptVO.setIssCodtnDivCd("A0390001");
			psnlProofAcceptVO.getWhdgTxIssYr();			

			psnlProofAcceptVO.setRowcount("5");
			psnlProofAcceptVO.setCurrentpage("1");

			psnlProofAcceptVO.setCertType(psnlProofAcceptVO.getCertType());

			if("2".equals(psnlProofAcceptVO.getCertType())){
				psnlPageService.insertPayrCertInfo(psnlProofAcceptVO);
				model.addAttribute("certList", psnlPageService.getPayrCertList(psnlProofAcceptVO));
				model.addAttribute("certListTotCnt", psnlPageService.getPayrCertListTotCnt(psnlProofAcceptVO));

			}else{
				try{psnlPageService.insertCertInfo(psnlProofAcceptVO);
				model.addAttribute("certList", psnlPageService.getCertList(psnlProofAcceptVO));
				model.addAttribute("certListTotCnt", psnlPageService.getCertListTotCnt(psnlProofAcceptVO));
				}catch(Exception e){
					e.printStackTrace();
				}

			}
			model.addAttribute("reqparams", psnlProofAcceptVO);

		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();		
			/** 에러 로그 **/			
			AnyLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.INSERT.toString(), e, windowNm, windowId);
		}

		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인			O:로그아웃
		 */
		AnyLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.INSERT.toString());

		return "/mypage/iucert/ProofAccept";
	}
	/**
	 * 증명서 발급 삭제
	 * @exception Exception
	 */
	@ResponseBody
	@RequestMapping(value="/cert/delCert.do")
	public String delCert(PsnlProofAcceptVO psnlProofAcceptVO, HttpServletRequest request, Model model, HttpSession session) throws Exception{
		String returnVal = null;
		String method = calledClass + ".delCert";
		String windowNm = " 증명발급 삭제";
		String windowId = "ProofAccept";

		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser = (MSFUserInfoVO) AnyWebServerUtils.getLoggedUser(request);

		try{
			psnlProofAcceptVO.setDpobCd(sessionUser.getDpobCd());
			psnlProofAcceptVO.setSystemkey(sessionUser.getSystemkey());      	

			String clientIP = request.getHeader("Proxy-Client-IP");
			if(clientIP == null){
				clientIP = request.getHeader("WL-Proxy-Client-IP");
				if(clientIP == null){
					clientIP = request.getHeader("X-Forwared-For");
					if(clientIP == null){
						clientIP = request.getRemoteAddr();
					}
				} 
			}
			psnlProofAcceptVO.setIsmt(sessionUser.getUsrId());
			psnlProofAcceptVO.setRevnAddr(clientIP);	
			String delCheckedValue = String.valueOf(psnlProofAcceptVO.getDelCheckedValue());

			System.out.println(" 삭제값 -> " + delCheckedValue);

			String[] arryChkV = delCheckedValue.split(",");

			ArrayList<PsnlProofAcceptVO> delList = new ArrayList<PsnlProofAcceptVO>();

			if(arryChkV != null ){
				for(int i = 0; i < arryChkV.length; i++){
					if(arryChkV[i] != null && !"".equals(arryChkV[i])){
						psnlProofAcceptVO.setPrfIssNum(arryChkV[i]);
						//						delList.add(psnlProofAcceptVO);
						if("2".equals(psnlProofAcceptVO.getCertType())){
							psnlPageService.deletePayrCertInfo(psnlProofAcceptVO);
							returnVal = "success";
						}else{
							psnlPageService.deleteCertInfo(psnlProofAcceptVO);
							returnVal = "success";
						}
					}
				}
			}

		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();		
			/** 에러 로그 **/			
			AnyLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.DELETE.toString(), e, windowNm, windowId);
		}

		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인			O:로그아웃
		 */
		AnyLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.DELETE.toString());

		return returnVal;
	}

	/**
	 * PSNL0550 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 Psnl0550DefaultVO
	 * @return "/psnl0550/Psnl0550List"
	 * @exception Exception
	 */
	@RequestMapping(value="/psnl0550/Psnl0550List.do")
	public String selectPsnl0550List(@ModelAttribute("searchVO") PsnlProofAcceptDefaultVO searchVO, 
			ModelMap model)
					throws Exception {

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

		List psnl0550List = psnl0550Service.selectPsnl0550List(searchVO);
		model.addAttribute("resultList", psnl0550List);

		int totCnt = psnl0550Service.selectPsnl0550ListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/psnl0550/Psnl0550List";
	} 

	@RequestMapping("/psnl0550/addPsnl0550View.do")
	public String addPsnl0550View(
			@ModelAttribute("searchVO") PsnlProofAcceptDefaultVO searchVO, Model model)
					throws Exception {
		model.addAttribute("psnl0550VO", new PsnlProofAcceptVO());
		return "/psnl0550/Psnl0550Register";
	}

	@RequestMapping("/psnl0550/addPsnl0550.do")
	public String addPsnl0550(
			PsnlProofAcceptVO psnl0550VO,
			@ModelAttribute("searchVO") PsnlProofAcceptDefaultVO searchVO, SessionStatus status)
					throws Exception {
		psnl0550Service.insertPsnl0550(psnl0550VO);
		status.setComplete();
		return "forward:/psnl0550/Psnl0550List.do";
	}

	@RequestMapping("/psnl0550/updatePsnl0550View.do")
	public String updatePsnl0550View(
			@RequestParam("dpobCd") java.lang.String dpobCd ,
			@RequestParam("prfIssNum") java.lang.String prfIssNum ,
			@ModelAttribute("searchVO") PsnlProofAcceptDefaultVO searchVO, Model model)
					throws Exception {
		PsnlProofAcceptVO psnl0550VO = new PsnlProofAcceptVO();
		psnl0550VO.setDpobCd(dpobCd);
		psnl0550VO.setPrfIssNum(prfIssNum);
		// 변수명은 CoC 에 따라 psnl0550VO
		model.addAttribute(selectPsnl0550(psnl0550VO, searchVO));
		return "/psnl0550/Psnl0550Register";
	}

	@RequestMapping("/psnl0550/selectPsnl0550.do")
	public @ModelAttribute("psnl0550VO")
	PsnlProofAcceptVO selectPsnl0550(
			PsnlProofAcceptVO psnl0550VO,
			@ModelAttribute("searchVO") PsnlProofAcceptDefaultVO searchVO) throws Exception {
		return psnl0550Service.selectPsnl0550(psnl0550VO);
	}

	@RequestMapping("/psnl0550/updatePsnl0550.do")
	public String updatePsnl0550(
			PsnlProofAcceptVO psnl0550VO,
			@ModelAttribute("searchVO") PsnlProofAcceptDefaultVO searchVO, SessionStatus status)
					throws Exception {
		psnl0550Service.updatePsnl0550(psnl0550VO);
		status.setComplete();
		return "forward:/psnl0550/Psnl0550List.do";
	}

	@RequestMapping("/psnl0550/deletePsnl0550.do")
	public String deletePsnl0550(
			PsnlProofAcceptVO psnl0550VO,
			@ModelAttribute("searchVO") PsnlProofAcceptDefaultVO searchVO, SessionStatus status)
					throws Exception {
		psnl0550Service.deletePsnl0550(psnl0550VO);
		status.setComplete();
		return "forward:/psnl0550/Psnl0550List.do";
	}

}
