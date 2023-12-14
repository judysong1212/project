package com.web.exterms.mypage.yeta.web;

import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gwtrpcspring.RemoteServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.smrmf.core.msfmainapp.server.utils.AnyLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.AnyWebServerUtils;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;
import com.ext.constants.PropConfs;
import com.web.exterms.mypage.login.service.MyPageSessionVO;
import com.web.exterms.mypage.psnl.web.PsnlPageController;
import com.web.exterms.utils.WebSessionUtils;

import egovframework.com.utl.cas.service.EgovSessionCookieUtil;

@Controller
public class YetaController {
	private static final String calledClass = YetaController.class.getName();	
	private ServletContext svltContext;
	private ServletConfig svltConfig;


	@RequestMapping(value = "/yeta/MyYetaPage.do")
	public String myYetaPage(HttpServletRequest request, HttpServletResponse response, HttpSession session, @RequestParam HashMap<String, String> hMap, Model model) throws Exception {
		String method = calledClass + ".myYetaPage";
		String windowNm = " 연말정산";
		String windowId = "YearTax";

		MyPageSessionVO mysession = (MyPageSessionVO)EgovSessionCookieUtil.getSessionAttribute(request, "mysession");
 
		//로그 기록을 위한 세션 유저 정보 vo에 담음
	//	MSFUserInfoVO sessionUser = (MSFUserInfoVO) session.getAttribute(PropConfs.WEB_SESSION_USER );
		MSFUserInfoVO sessionUser =AnyWebServerUtils.getLoggedUser(request);
		try{

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

		return "/mypage/yeta/YearTax";
	}

	@RequestMapping(value = "/yeta/YearFileSend.do")
	public String yearFileSend(HttpServletRequest request, HttpServletResponse response, HttpSession session,@RequestParam HashMap<String, String> hMap, Model model) throws Exception {
		String method = calledClass + ".yearFileSend";
		String windowNm = " 연말정산 전자파일";
		String windowId = "YearFileSend";

		MyPageSessionVO mysession = (MyPageSessionVO)EgovSessionCookieUtil.getSessionAttribute(request, "mysession");
 
		//로그 기록을 위한 세션 유저 정보 vo에 담음
		//MSFUserInfoVO sessionUser = (MSFUserInfoVO) session.getAttribute(PropConfs.WEB_SESSION_USER );
		MSFUserInfoVO sessionUser =AnyWebServerUtils.getLoggedUser(request);
		try{

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

		return "/mypage/yeta/YearFileSend";
	}
}
