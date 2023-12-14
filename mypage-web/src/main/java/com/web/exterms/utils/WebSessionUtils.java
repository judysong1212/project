package com.web.exterms.utils;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gwtrpcspring.RemoteServiceUtil;

import com.app.smrmf.core.msfmainapp.server.utils.AnyUserInfoManager;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;
import com.ext.constants.PropConfs;
import com.web.exterms.mypage.login.service.MyPageSessionVO;

public class WebSessionUtils {
	    
    public static void sessionLogCheck(MyPageSessionVO myPageSessionVO,HttpSession session){
    	
    	MSFUserInfoVO userData  = new MSFUserInfoVO();		
		userData.setUsrId(myPageSessionVO.getUsrId());
		userData.setDpobCd(myPageSessionVO.getDpobCd());
		userData.setUsrDivCd(myPageSessionVO.getUsrDivCd());
		userData.setDeptCd(myPageSessionVO.getCurrAffnDeptCd());
		userData.setUsrNm(myPageSessionVO.getUsrNm());
		userData.setDeptNm(myPageSessionVO.getCurrAffnDeptNm());
		userData.setEmymtDivCd(myPageSessionVO.getEmymtDivCd());
		userData.setEmymtDivNm(myPageSessionVO.getEmymtDivNm());
		userData.setSystemkey(myPageSessionVO.getSystemkey());
		
		//마이페이지인지 업무단인지 구별해주는 구분자 입력
		userData.setAppWebConn(PropConfs.SYSM_CONN_WEB);
		
		RemoteServiceUtil.getThreadLocalSession().setAttribute(PropConfs.WEB_SESSION_USER , userData);
		//세션에 로그기록을 위한 유저 정보를 넣는다.
		//session.setAttribute(PropConfs.WEB_SESSION_USER , userData);  
 
		//유저정보 초기에 세팅해줌
		AnyUserInfoManager.setUserInfo(RemoteServiceUtil.getThreadLocalRequest(), RemoteServiceUtil.getThreadLocalResponse()
				                       , RemoteServiceUtil.getThreadLocalContext()
				                       , RemoteServiceUtil.getThreadLocalConfig(), userData);
    }
    
    public static void sessionFlagCheck(MyPageSessionVO tableChkVo, MyPageSessionVO myPageSessionVO, HttpServletResponse response){
    	if(tableChkVo.getUsrId().equals(myPageSessionVO.getUsrId()) && !tableChkVo.getUsrLgnSesn().equals(myPageSessionVO.getUsrLgnSesn())){
			try {
				RemoteServiceUtil.getThreadLocalSession().setAttribute(PropConfs.WEB_SESSION_USER , null);
				RemoteServiceUtil.getThreadLocalSession().invalidate();
				response.sendRedirect("/mypage/Login.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
    }
    
    public static MyPageSessionVO SessionFlagSetVo(MyPageSessionVO dataGetVo,MyPageSessionVO myPageSessionVO, HttpSession session, String clientIP){
		myPageSessionVO.setSysDivCd("EXTERM00");
		myPageSessionVO.setUsrLgnSesn(session.getId());
		myPageSessionVO.setInptAddr(clientIP);
		myPageSessionVO.setRevnAddr(clientIP);
		myPageSessionVO.setChkNum("F");		//중복 로그인 검증 플래그 입력	
		return myPageSessionVO;
	}

	public static String toString(Calendar cal) { 
		//요일은 1부터 시작
		final String[] arrWeek = {"", "일", "월", "화", "수", "목", "금", "토"}; 
		int year = cal.get(Calendar.YEAR);
		int mon = cal.get(Calendar.MONTH)+1;
		int date = cal.get(Calendar.DATE);
		String weekDay = arrWeek[cal.get(Calendar.DAY_OF_WEEK)];

		return ( year + " 년 " + mon + "월" + date + "일 (" + weekDay + "요일)");
	}

}
