package com.web.exterms.mypage.main.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.smrmf.core.msfmainapp.server.utils.AnyWebServerUtils;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;
import com.ext.constants.PropConfs;
import com.web.exterms.mypage.login.service.MyLoginService;
import com.web.exterms.mypage.login.service.MyPageSessionVO;
import com.web.exterms.utils.WebSessionUtils;

import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.utl.cas.service.EgovSessionCookieUtil;
import egovframework.com.utl.fcc.service.EgovStringUtil;
import egovframework.rte.fdl.property.EgovPropertyService;
/**
 * 메인 페이지 컨트롤러 클래스
 * @author atres
 * @since 2013.07.06
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2013.07.06  atres     최초 생성
 *
 * </pre>
 */
@Controller
//@SessionAttributes(types=MyPageSessionVO.class)
//@SessionAttributes(types = ComDefaultVO.class)
public class MyMainController {

	private static final Logger logger = LoggerFactory.getLogger(MyMainController.class);
	 
	/** LoginService */
	@Resource(name = "MyLoginService")
    private MyLoginService myLoginService;
	
	 /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
	@Resource(name = "EgovCmmUseService")
	private EgovCmmUseService cmmUseService; 
	/**
	 * 메인 페이지에서 각 업무 화면으로 연계하는 기능을 제공한다.
	 * 
	 * @param request
	 * @param commandMap
	 * @exception Exception Exception
	 */
	@RequestMapping(value = "/cmm/forwardPage.do")
	public String forwardPageWithMenuNo(HttpServletRequest request, Map<String, Object> commandMap)
	  throws Exception{
		return "";
	}

	/**
	 * 템플릿 메인 페이지 조회
	 * @return 메인페이지 정보 Map [key : 항목명]
	 * 
	 * @param request
	 * @param model
	 * @exception Exception Exception
	 */
	@RequestMapping(value = "/main/MainPage.do")
	public String getMainPage(HttpServletRequest request, HttpServletResponse response, ModelMap model, HttpSession session)
	  throws Exception{ 		
		//테이블에 있는 세션 값과 현재 로그인된 세션 값 비교
		MyPageSessionVO myPageSessionVO = (MyPageSessionVO)session.getAttribute("flagChk");
		
		MyPageSessionVO tableChkVo = new MyPageSessionVO();
		tableChkVo = myLoginService.selectErrLoginSysm0120(myPageSessionVO);
		
		if(EgovStringUtil.nullConvert(myPageSessionVO.getChkNum()).equals("F")){
			WebSessionUtils.sessionFlagCheck(tableChkVo,myPageSessionVO,response);
		}
		
		return "mypage/main/Main";
	}
	
	
	/**
	 * 템플릿 메인 페이지 조회
	 * @return 메인페이지 정보 Map [key : 항목명]
	 * 
	 * @param request
	 * @param model
	 * @exception Exception Exception
	 */
	@RequestMapping(value = "/comm/PageTopInfo.do")
	public String getPageTopInfo(HttpServletRequest request, ModelMap model, HttpSession session)
	  throws Exception{ 
		
		MSFUserInfoVO sessionUser = (MSFUserInfoVO)AnyWebServerUtils.getLoggedUser(request);	
		
		model.addAttribute("mysession", sessionUser);
		
		return "mypage/common/PageTopInfo";		
	}
	
	
        

}