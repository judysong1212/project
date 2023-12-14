package com.web.exterms.mypage.login.web;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tapestry.json.JSONObject;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.AnyLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.AnyWebServerUtils;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;
import com.crypto.service.AnyCryptService;
import com.ext.constants.PropConfs;
import com.web.exterms.mypage.login.service.MyLoginService;
import com.web.exterms.mypage.login.service.MyPageSessionVO;
import com.web.exterms.utils.WebSessionUtils;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.utl.fcc.service.EgovStringUtil;

/**
 * @Class Name : Sysm0100Controller.java
 * @Description : Sysm0100 Controller class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.26
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Controller
//@SessionAttributes(types=MyPageSessionVO.class)
public class MyLoginController {
	
	protected static final Log LOG = LogFactory.getLog(MyLoginController.class);
	private static final String calledClass = MyLoginController.class.getName();
 
	// 비밀번호 유효성 검사식1 : 숫자, 특수문자가 포함되어야 한다.
	private String regExp_symbol = "([0-9].*[!,@,#,^,&,*,(,)])|([!,@,#,^,&,*,(,)].*[0-9])";
	// 비밀번호 유효성 검사식2 : 영문자 대소문자가 적어도 하나씩은 포함되어야 한다.
	private String regExp_alpha = "([a-z].*[A-Z])|([A-Z].*[a-z])";
	// 정규표현식 컴파일
	Pattern pattern_symbol = Pattern.compile(regExp_symbol);
	Pattern pattern_alpha = Pattern.compile(regExp_alpha);
	
	HttpSession session = null;
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public HttpSession getSession() {
		return session;
	}

	/** LoginService */
	@Resource(name = "MyLoginService")
	private MyLoginService myLoginService;

	/** EgovCmmUseService */
	@Resource(name="EgovCmmUseService")
	private EgovCmmUseService cmmUseService;

	/** EgovMessageSource */
	@Resource(name="egovMessageSource")
	EgovMessageSource egovMessageSource;
 
	/** 암호화 모듈 호출  */
	@Autowired 
	@Resource(name = "AnyCryptService")
	protected AnyCryptService anyCryptService;

	//########################################## 로그인 처리 시작 ############################################

	/** 회원가입 팝업  */
	@RequestMapping(value="/mypage/signMemberPop.do")
	public String popupDoro(@RequestParam HashMap<String, String> hMap, Model model) throws Exception {
		return "/mypage/login/signMemberPop";
	}

	/** 3개월 지난 패스워드 변경하는 팝업  */
	@RequestMapping(value="/mypage/newPasswordPop.do")
	public String newPasswordPop(@RequestParam HashMap<String, String> hMap, Model model) throws Exception {
		return "/mypage/login/newPasswordPop";
	}

	/** 계정 존재 유무 체크  */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/ajax/getIdChk.do")
	public String getIdChk(MyPageSessionVO myPageSessionVO, Model model) throws Exception {
		String chkId = "";
		MyPageSessionVO vo = new MyPageSessionVO();    	
		vo = myLoginService.selectSysm0100(myPageSessionVO); 
		if( vo != null){
			chkId = vo.getUsrId();
		}
		return chkId;
	}

	/** 패스워드 검증  */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/ajax/getPwdChk.do")
	public String getPwdChk(MyPageSessionVO myPageSessionVO, Model model) throws Exception {
		String chkPwd = "";

		// 패스워드 검증
		Matcher matcher_symbol = pattern_symbol.matcher(myPageSessionVO.getPwd());
		Matcher matcher_alpha = pattern_alpha.matcher(myPageSessionVO.getPwd());

		if(matcher_symbol.find() && matcher_alpha.find()) {
			chkPwd = "success";
		}else{
			chkPwd = "fail";
		}    	
		return chkPwd;
	}

	/** 패스워드 변경 팝업에서 기존 패스워드 확인 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/ajax/getBasicPwdChk.do")
	public String getNewPwdChk(MyPageSessionVO myPageSessionVO, Model model) throws Exception {
		String chkPwd = "";
		String pwdCryptSHA512 = "";

		MyPageSessionVO dataGetVo = new MyPageSessionVO();
		dataGetVo = myLoginService.selectPasswordInfo(myPageSessionVO);

		//암호화
		pwdCryptSHA512 = encryptPwd(myPageSessionVO, dataGetVo);

		//디비에 데이터와 입력한 입력한 비밀번호가 맞는지 확인
		if ( pwdCryptSHA512.equals(dataGetVo.getUsrChgPwd())) {  
			chkPwd = "success";		
		}else{
			chkPwd = "fail";
		}

		return chkPwd;
	}

	/** 신규 패스워드 검증 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/ajax/getNewPwdChk.do")
	public String getNewPwdChk2(MyPageSessionVO myPageSessionVO, Model model) throws Exception {
		String chkPwd = "";

		// 패스워드 검증
		Matcher matcher_symbol = pattern_symbol.matcher(myPageSessionVO.getNewPwd());
		Matcher matcher_alpha = pattern_alpha.matcher(myPageSessionVO.getNewPwd());

		if(matcher_symbol.find() && matcher_alpha.find()){		
			chkPwd = "success";
			if(myPageSessionVO.getPwd().equals(myPageSessionVO.getNewPwd())){
				chkPwd = "samePwd";
			}
		}else{
			chkPwd = "fail";
		}

		return chkPwd;
	}

	/** 신규 패스워드 저장*/
	@ResponseBody
	@RequestMapping(value="/ajax/saveNewPasswodInfo.do")
	public String saveNewPasswodInfo(MyPageSessionVO myPageSessionVO, HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) throws Exception {
		String method = calledClass + ".saveNewPasswodInfo";
		String windowNm = "신규 패스워드 저장";
		String windowId = "newPasswordPop";

		String chkPwd = "";
		String pwdCryptSHA512 = "";
		String basicPwdCryptSHA512 = "";
		String clientIP = request.getRemoteAddr();	

		// vo에 패스워드 테이블 정보 저장
		MyPageSessionVO dataGetVo = new MyPageSessionVO();		
		dataGetVo = myLoginService.selectPasswordInfo(myPageSessionVO);

		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser = (MSFUserInfoVO)AnyWebServerUtils.getLoggedUser(request);		

		try{
			//암호화
			pwdCryptSHA512 = encryptPwd(myPageSessionVO, dataGetVo);

			//디비에 데이터와 입력한 기존 비밀번호가 같은 경우 새로운 비밀번호로 변경
			if ( pwdCryptSHA512.equals(dataGetVo.getUsrChgPwd())) {  

				String newPw = myPageSessionVO.getNewPwd()  == null ? "" : myPageSessionVO.getNewPwd();		
				String basicPw = myPageSessionVO.getPwd()  == null ? "" : myPageSessionVO.getPwd();	

				//암호화 모듈적용으로 추가 
				pwdCryptSHA512 = anyCryptService.payGenEncryptSHA256(EgovStringUtil.isNullToString(newPw));
				basicPwdCryptSHA512 = anyCryptService.payGenEncryptSHA256(EgovStringUtil.isNullToString(basicPw));

				myPageSessionVO.setNewPwd(pwdCryptSHA512);		
				myPageSessionVO.setPwd(basicPwdCryptSHA512);
				myPageSessionVO.setInptAddr(clientIP);

				//SYSM0130 Update
				myLoginService.updatePasswordInfo(myPageSessionVO);	
				//SYSM0100 Password Update
				myLoginService.updateSysm0100PasswordInfo(myPageSessionVO);	

				chkPwd = "success";
			}else{
				chkPwd = "fail";
			}

		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();			
			chkPwd = "fail";
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

		return chkPwd;
	}

	/** 신규 계정 저장*/
	@ResponseBody
	@RequestMapping(value="/ajax/saveMemberInfo.do")
	public String saveMemberInfo(MyPageSessionVO myPageSessionVO, HttpServletRequest request, HttpServletResponse response ,Model model, HttpSession session) throws Exception {
		String result = "";
		String clientIP = request.getRemoteAddr();
		String method = calledClass + ".saveMemberInfo";
		String windowNm = "신규 계정 저장";
		String windowId = "signMemberPop";

		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser = (MSFUserInfoVO)AnyWebServerUtils.getLoggedUser(request);	

		myPageSessionVO.setRevnAddr(clientIP);
		myPageSessionVO.setInptAddr(clientIP);

		try{
			String userPw = myPageSessionVO.getPwd()  == null ? "" : myPageSessionVO.getPwd();		
			String pwdCryptSHA512 = anyCryptService.payGenEncryptSHA256(EgovStringUtil.isNullToString(userPw));
			myPageSessionVO.setPwd(pwdCryptSHA512);		
			myLoginService.insertSyms0100ToSysm0130Info(myPageSessionVO);
			result = "success";
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();			
			//이렇게 해주면 글로벌 프로퍼티에서 읽어옴 true 쌓고 false이면 안쌓고 지정안화면 업무단에서 가져오니까 반드시 선언한다. 로그 관련하여 짝이다
			//			SysmConf.set(PropConfs.Globals_Config_Info);
			result = "fail";
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

		return result;
	}

	/** 기존 사용자 정보 조회 */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/ajax/getMemerInfo.do")
	public void getMemerInfo(MyPageSessionVO myPageSessionVO, HttpServletResponse response,  HttpServletRequest request, Model model, HttpSession session) throws Exception {
		String method = calledClass + ".getMemerInfo";
		String windowNm = "사용자 정보 조회";
		String windowId = "signMemberPop";
		response.setContentType("text/html;charset=UTF-8");

		MyPageSessionVO getMemberVo = new MyPageSessionVO();  
		
		//암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),request);

		/**
		 * 암호화 모듈  호출 암호화 작업 수행 
		 */
		if (SmrmfUtils.dataNotNull(myPageSessionVO.getResnRegnNum())) {	
			myPageSessionVO.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,SmrmfUtils.allowNulls(myPageSessionVO.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC));
		}

		getMemberVo= myLoginService.getMemberInfo(myPageSessionVO);
		getMemberVo.setUsrId(myPageSessionVO.getUsrId());

		//로그 체크를 위한 세션 담는 작업
		WebSessionUtils.sessionLogCheck(getMemberVo,session);
		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser = (MSFUserInfoVO)AnyWebServerUtils.getLoggedUser(request);	

		try{
			JSONObject jo = new JSONObject();
			if(getMemberVo != null){
				jo.put("hanNm", getMemberVo.getHanNm()== null ? "" : getMemberVo.getHanNm()); 
				jo.put("currAffnDeptCd", getMemberVo.getCurrAffnDeptCd()== null ? "" : getMemberVo.getCurrAffnDeptCd());
				jo.put("currDeptNm", getMemberVo.getCurrDeptNm()== null ? "" : getMemberVo.getCurrDeptNm());
				jo.put("usrTel", getMemberVo.getUsrTel()== null ? "" : getMemberVo.getUsrTel());
				jo.put("emailAddr", getMemberVo.getEmailAddr()== null ? "" : getMemberVo.getEmailAddr());
				jo.put("dpobCd", getMemberVo.getDpobCd() == null ? "" : getMemberVo.getDpobCd());
				jo.put("systemkey", getMemberVo.getSystemkey()== null ? "" : getMemberVo.getSystemkey());
				jo.put("chkUserId", getMemberVo.getChkUserId()== null ? "" : getMemberVo.getChkUserId());
				jo.put("usrId", getMemberVo.getUsrId()== null ? "" : getMemberVo.getUsrId());
				response.getWriter().print(jo);
			}else{
				response.getWriter().print(jo);
			}
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();			
			//이렇게 해주면 글로벌 프로퍼티에서 읽어옴 true 쌓고 false이면 안쌓고 지정안화면 업무단에서 가져오니까 반드시 선언한다. 로그 관련하여 짝이다
			//			SysmConf.set(PropConfs.Globals_Config_Info);

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
	}

	/** 로그인 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value= {"/mypage/SSOLogin.do", "/mypage/Login.do" })
	public String login(MyPageSessionVO myPageSessionVO, HttpServletRequest request,HttpServletResponse response, Model model, HttpSession session) throws Exception {
		String returnPage = ""; 
		MyPageSessionVO loginChk = new MyPageSessionVO();

		if(request.getRequestURI().substring(request.getContextPath().length()).equals("/mypage/SSOLogin.do")) {
			if(!"".equals(myPageSessionVO.getUsrId())){
				myPageSessionVO.getUsrId();
				loginChk = myLoginService.selectSysm0100(myPageSessionVO);    			
			}
			if(loginChk != null){
				String USR_DIV_CD = loginChk.getUsrDivCd() == null ? "" : loginChk.getUsrDivCd().toString();
				if(USR_DIV_CD.indexOf("70") > -1 || USR_DIV_CD.indexOf("80") > -1){ //무기계약직 또는 기간제 계약직
					WebSessionUtils.sessionLogCheck(loginChk,session);
					returnPage = "redirect:/main/MainPage.do";
				}
			}    		
		}    	
		if("".equals(returnPage)){
			session.invalidate();
			returnPage = "/mypage/login/Login";
		}    	
		return returnPage;
	}

	/** 로그인  */
	@SuppressWarnings("rawtypes")
	@ResponseBody
	@RequestMapping(value="/mypage/LoginProcess.do")
	public Object loginProcess(MyPageSessionVO myPageSessionVO, HttpServletRequest request, HttpServletResponse response, 
			Model model, HttpSession session) throws Exception {
		String clientIP = request.getRemoteAddr();
		String method = calledClass + ".loginProcess";
		String windowNm = "로그인";
		String windowId = "Login";

		String returnStr = "";
		String pwdCryptSHA512 = "";
		HashMap returnData = new HashMap();
		
		Calendar yDay = Calendar.getInstance();
		Calendar toDay = Calendar.getInstance();

		//String를 Date로 형변환
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyyMMdd");

		// 사용자 정보 조회
		MyPageSessionVO dataGetVo = new MyPageSessionVO();
		dataGetVo = myLoginService.selectSysm0100(myPageSessionVO);
		
		// 패스워드 정보 조회
		MyPageSessionVO pwdChkVo= new MyPageSessionVO();
		pwdChkVo = myLoginService.selectPasswordInfo(myPageSessionVO);

		if(dataGetVo != null){
			dataGetVo.setRevnAddr(clientIP);	
			//로그 체크를 위한 세션 담는 작업
			WebSessionUtils.sessionLogCheck(dataGetVo,session);
			//로그 기록을 위한 세션 유저 정보 vo에 담음
			MSFUserInfoVO sessionUser = (MSFUserInfoVO)AnyWebServerUtils.getLoggedUser(request);				
			try{		
				//암호화
				pwdCryptSHA512 = encryptPwd(myPageSessionVO, dataGetVo);				
				
				/**=================== 정규표현식 패스워드 검증 시작 =============================*/
				// 문자 매칭
				Matcher matcher_symbol = pattern_symbol.matcher(myPageSessionVO.getPwd());
				Matcher matcher_alpha = pattern_alpha.matcher(myPageSessionVO.getPwd());
				/**=================== 정규표현식 패스워드 검증 종료 =============================*/

				/**=================== 날짜 비교 계산 시작 =============================*/
				//주석처리 20210705
				/*yDay.setTime(transFormat.parse(pwdChkVo.getUsrPwdChgDttm()));	//  패스워드 변경된 마지막 일자 입력
				//toDay.set(2018, 1,30);
				long diffSec = (toDay.getTimeInMillis() - yDay.getTimeInMillis()) / 1000;       // 초
				long diffDay = diffSec/(60 * 60 * 24);                                                     // 일수*/
				/**=================== 날짜 비교 계산 종료 =============================*/

				// 세션체크 테이블이 null이면 신규 등록
				if(myLoginService.selectErrLoginSysm0120(myPageSessionVO) == null){
					
					myPageSessionVO = WebSessionUtils.SessionFlagSetVo(dataGetVo, myPageSessionVO, session, clientIP);	//세션 플래그 체크하는 vo담는 작업
					myLoginService.insertSessionLoginSysm0120(myPageSessionVO);	//해당 세션의 테이블 값이 null이기 때문에 현재 세션으로 업데이트 처리				
					session.setAttribute("flagChk", myPageSessionVO);	//동시 접속 플래그 값을 담기 위해 세션 생성
					setSession(session);
					
					// 로그인 조건 체크 메소드 호출
					returnStr = loginCheck(dataGetVo, pwdCryptSHA512, myPageSessionVO, matcher_symbol, matcher_alpha,clientIP); //, diffDay주석처리

				}else{					
					
					MyPageSessionVO tableChkVo = new MyPageSessionVO();
					tableChkVo = myLoginService.selectErrLoginSysm0120(myPageSessionVO);

					//만약 중복로그인 체크 플래그가 F인데 아이디는 동일하고 세션 값이 다르면 로그인페이지 이동
					if(EgovStringUtil.nullConvert(myPageSessionVO.getChkNum()).equals("F")){
						WebSessionUtils.sessionFlagCheck(tableChkVo,myPageSessionVO,response);		//동시 로그인 체크 메소드 호출
					}else{
						//세션이 다를 경우
						if(tableChkVo.getUsrId().equals(myPageSessionVO.getUsrId()) && !tableChkVo.getUsrLgnSesn().equals(myPageSessionVO.getUsrLgnSesn())){
							
							myPageSessionVO = WebSessionUtils.SessionFlagSetVo(dataGetVo, myPageSessionVO, session, clientIP);		//세션 플래그 체크하는 vo담는 작업
							myLoginService.updateSessionChkSysm0120(myPageSessionVO);	//세션이 다르기 때문에 현재 세션으로 업데이트 처리	
							session.setAttribute("flagChk", myPageSessionVO); 		//동시 접속 플래그 값을 담기 위해 세션 생성
							setSession(session);
							
							// 로그인 조건 체크 메소드 호출
							returnStr = loginCheck(dataGetVo, pwdCryptSHA512, myPageSessionVO, matcher_symbol, matcher_alpha, clientIP); //, diffDay주석처리
							
						}else{
							returnStr = "dfrnId";
						}
					}
				}		
				
				//로그인 실패 횟수 체크를 위해 조회
				MyPageSessionVO cntChkVo = new MyPageSessionVO();
				cntChkVo = myLoginService.selectErrLoginSysm0120(myPageSessionVO);
				if(cntChkVo != null){
					returnData.put("result", cntChkVo.getUsrErrLgnCnt());
				}
				returnData.put("message", returnStr);
				
			}catch(Exception e){
				// TODO Auto-generated catch block
				e.printStackTrace();			
				/** 에러 로그 **/			
				AnyLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, "", e, windowNm, windowId);
			}
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
			 * D:delete		S:select	B:배치 
			 * L:로그인			O:로그아웃
			 */
			AnyLogHistoryUtils.tracerLoginUserActivity(sessionUser, method, calledClass, "LOGIN");

		}else{
			returnStr = "dfrnId";
			returnData.put("message", returnStr);
		}

		return returnData; 	
	}    

	/** 로그아웃 */
	@RequestMapping(value="/mypage/Logout.do")
	public String logout(MyPageSessionVO myPageSessionVO, HttpServletRequest request,HttpServletResponse response, Model model, HttpSession session) throws Exception {		
		String method = calledClass + ".logout";
		String windowNm = " 로그아웃";
		String windowId = "Logout";

		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser = (MSFUserInfoVO)AnyWebServerUtils.getLoggedUser(request);			
		myPageSessionVO.setUsrId(sessionUser.getUsrId());
		try{
			myLoginService.deleteErrLoginSysm0120(myPageSessionVO);			
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();			

			/** 에러 로그 **/			
			AnyLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, "", e, windowNm, windowId);
		}

		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인			O:로그아웃
		 */
		AnyLogHistoryUtils.tracerLoginUserActivity(sessionUser, method, calledClass, "LOGOUT");

		session.invalidate();

		return "redirect:/mypage/Login.do";
	}

	// 로그인 조건 체크 메소드
	public String loginCheck( MyPageSessionVO dataGetVo, String pwdCryptSHA512, MyPageSessionVO myPageSessionVO, Matcher matcher_symbol,  Matcher matcher_alpha , String clientIP ){
		//, long diffDay 삭제처리
		String returnStr = "";
		try{
			//사용유무 파악
			if("Y".equals(dataGetVo.getUseYn())){
				//계정 잠김 상태 파악
				if("N".equals(dataGetVo.getUsrLgnAccLckYn())){
					// 입력 패스워드와 테이블에 계정 패스워가 동일한지 체크
					if ( pwdCryptSHA512.equals(dataGetVo.getPwd())) {  							
						returnStr = pwdUseYnCheck(myPageSessionVO, matcher_symbol, matcher_alpha);	//패스워드 체크	, , diffDay삭제처리				
					}else {		
						//로그인 세션 및 실패 테이블 조회
						MyPageSessionVO tableChkVo = new MyPageSessionVO();
						tableChkVo = myLoginService.selectErrLoginSysm0120(myPageSessionVO);		
						returnStr = loginFailCntCheck(tableChkVo, myPageSessionVO, clientIP);		//로그인 실패횟수 체크				
						RemoteServiceUtil.getThreadLocalSession().invalidate();
					}
				}else{
					returnStr = "lockChk";
				}
			}else{
				returnStr = "useChk";
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return returnStr;
	}

	// 패스워드 유효성 체크
	public String pwdUseYnCheck(MyPageSessionVO myPageSessionVO, Matcher matcher_symbol,  Matcher matcher_alpha){
		//, long diffDay 삭제처리
		String returnStr = null;
		try{
			//패스워드 검증 'Y'이고 패스워드 길이 9자 이상이며 비밀번호 생성 90이 안된 경우 넘김
			if(matcher_symbol.find() && matcher_alpha.find() && myPageSessionVO.getPwd().length() >= 9 ){
				//&& diffDay < 90 삭제처리
				BigDecimal b = new BigDecimal("0");
				myPageSessionVO.setUsrErrLgnCnt(b);
				myPageSessionVO.setUsrErrLgnDttm("0");
				myLoginService.updateSessionChkSysm0120(myPageSessionVO);
				returnStr = "success";
			}
			//주석처리20210705
			/*else if(diffDay > 90){
				returnStr = "pwdChk";
			}*/
		}catch(Exception e){
			e.printStackTrace();
		}		
		return returnStr;
	}

	//로그인 실패 횟수 체크
	public String loginFailCntCheck(MyPageSessionVO tableChkVo, MyPageSessionVO myPageSessionVO, String clientIP){
		String returnStr = null;
		try{
			//로그인 실패 횟수가 5회 미만인지 이상인지 확인
			if(tableChkVo.getUsrErrLgnCnt().intValue() < 5  ){
				//테이블에 해당 계정 데이터가 존재한다면 업데이트 처리 아니면 새로 insert 처리
				if(tableChkVo != null){
					myLoginService.updateErrLoginSysm0120(myPageSessionVO);
				}else{
					myLoginService.insertErrLoginSysm0120(myPageSessionVO);				
				}				
				returnStr = "loginFail";
			}else{
				// 로그인 5회 이상 실패시 계정잠금여부 Y로 변경
				myPageSessionVO.setRevnAddr(clientIP);
				myLoginService.updateSysm0100UseInfo(myPageSessionVO);
				myLoginService.deleteErrLoginSysm0120(myPageSessionVO);	
				returnStr = "loginLock";
			}				
		}catch(Exception e){
			e.printStackTrace();
		}	
		return returnStr;
	}
	
	//암호화
	public String encryptPwd(MyPageSessionVO myPageSessionVO, MyPageSessionVO dataGetVo){
		String pwdCryptSHA512 = null ;
		//암호화 시작
		if (EgovStringUtil.isNullToString(myPageSessionVO.getPwd()).equals(dataGetVo.getPwd())) {
			pwdCryptSHA512 = EgovStringUtil.isNullToString(myPageSessionVO.getPwd());
		}else {	
			//암호화 모듈적용으로 추가 
			pwdCryptSHA512 = anyCryptService.payGenEncryptSHA256(EgovStringUtil.isNullToString(myPageSessionVO.getPwd()));
		} 
		return pwdCryptSHA512;
	}
	
	
	//세션 체크
	@SuppressWarnings("rawtypes")
	@Scheduled(fixedRate=1800000)	
	public void sessionScheduleChk() {
		try {
			if(getSession() != null){
				HttpSession session =  getSession();		
				MyPageSessionVO myPageSessionVO =(MyPageSessionVO)session.getAttribute("flagChk");
				MyPageSessionVO sessionChk = new MyPageSessionVO();
				sessionChk = myLoginService.selectErrLoginSysm0120(myPageSessionVO);		
				if(myPageSessionVO.getUsrId().equals( sessionChk.getUsrId()) && session.getId().equals(sessionChk.getUsrLgnSesn())  && myPageSessionVO.getRevnAddr().equals(sessionChk.getRevnAddr())){
					sessionChk = new MyPageSessionVO();
					sessionChk.setUsrId(myPageSessionVO.getUsrId());
					myLoginService.updateSessionChkSysm0120(sessionChk);
				}
			}else{
				LOG.debug("Please Login...");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	//########################################## 로그인 처리 끝 ############################################

	/*
	 *//**
	 * 로그인 화면으로 들어간다
	 * @param vo - 로그인후 이동할 URL이 담긴 LoginVO
	 * @return 로그인 페이지
	 * @exception Exception
	 *//*
	@IncludedInfo(name="로그인", listUrl="/login/Login.do", order = 10, gid = 10)
	@RequestMapping(value="/login/Login.do")
	public String loginUsrView(@ModelAttribute("loginVO") LoginVO loginVO,
			HttpServletRequest request,
			HttpServletResponse response,
			ModelMap model) 
					throws Exception {
		if(EgovComponentChecker.hasComponent("mberManageService")){
			model.addAttribute("useMemberManage", "true");
		}

		GPKIHttpServletResponse gpkiresponse = null;
	    GPKIHttpServletRequest gpkirequest = null;

	    try{

	    	gpkiresponse=new GPKIHttpServletResponse(response); 
		    gpkirequest= new GPKIHttpServletRequest(request);
	        gpkiresponse.setRequest(gpkirequest);
	        model.addAttribute("challenge", gpkiresponse.getChallenge());
	        return "egovframework/com/uat/uia/EgovLoginUsr";

	    }catch(Exception e){
	        return "egovframework/com/cmm/egovError";
	    }

		return "/mypage/login/Login";
	}

	  *//**
	  * 일반(세션) 로그인을 처리한다
	  * @param vo - 아이디, 비밀번호가 담긴 LoginVO
	  * @param request - 세션처리를 위한 HttpServletRequest
	  * @return result - 로그인결과(세션정보)
	  * @exception Exception
	  *//*
	@RequestMapping(value="/login/actionLogin.do")
	public String actionLogin(@ModelAttribute("loginVO") LoginVO loginVO, 
			HttpServletRequest request,
			ModelMap model)
					throws Exception { 

		// 1. 일반 로그인 처리
		LoginVO resultVO = myLoginService.actionLogin(loginVO); 

		if (resultVO != null && resultVO.getUsrId() != null && !resultVO.getUsrId().equals("")) {

			// 2-1. 로그인 정보를 세션에 저장
			request.getSession().setAttribute("loginVO", resultVO);

			return "redirect:/main/Main.do";

		} else {

			model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
			return "/mypage/login/Login";
		}
	}   


	   *//**
	   * 로그인 후 메인화면으로 들어간다
	   * @param 
	   * @return 로그인 페이지
	   * @exception Exception
	   *//*
	@RequestMapping(value="/main/Main.do")
	public String actionMain(ModelMap model) 
			throws Exception {

		// 1. Spring Security 사용자권한 처리
		Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
		if(!isAuthenticated) {
			model.addAttribute("message", egovMessageSource.getMessage("fail.common.login"));
			return "/mypage/login/Login";
		}
		//LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();


    	// 2. 메뉴조회
		MenuManageVO menuManageVO = new MenuManageVO();
    	menuManageVO.setTmp_Id(user.getId());
    	menuManageVO.setTmp_UserSe(user.getUserSe());
    	menuManageVO.setTmp_Name(user.getName());
    	menuManageVO.setTmp_Email(user.getEmail());
    	menuManageVO.setTmp_OrgnztId(user.getOrgnztId());
    	menuManageVO.setTmp_UniqId(user.getUniqId());
    	List list_headmenu = menuManageService.selectMainMenuHead(menuManageVO);
		model.addAttribute("list_headmenu", list_headmenu);


		// 3. 메인 페이지 이동
		String main_page = Globals.MAIN_PAGE;

		//model.put("curLinkUrl", main_page);  //현재 페이지에 따른 값을 처리하기위해 추가

		LOG.debug("Globals.MAIN_PAGE > " +  Globals.MAIN_PAGE);
		LOG.debug("main_page > " +  main_page);


		if (main_page.startsWith("/")) {
			return "forward:" + main_page;
		} else {
			return main_page;
		} 

	}

	    *//**
	    * 로그아웃한다.
	    * @return String
	    * @exception Exception
	    *//*
	@RequestMapping(value="/login/actionLogout.do")
	public String actionLogout(HttpServletRequest request, ModelMap model) 
			throws Exception {

		String userIp = EgovClntInfo.getClntIP(request);

    	// 1. Security 연동
    	return "redirect:/j_spring_security_logout";

		request.getSession().setAttribute("loginVO", null);


		return "redirect:/main/MainPage.do";
	}
	//TODO --
	     *//**
	     * 아이디/비밀번호 찾기 화면으로 들어간다
	     * @param 
	     * @return 아이디/비밀번호 찾기 페이지
	     * @exception Exception
	     *//*
	@RequestMapping(value="/uat/uia/egovIdPasswordSearch.do")
	public String idPasswordSearchView(ModelMap model) 
			throws Exception {

		// 1. 비밀번호 힌트 공통코드 조회
		ComDefaultCodeVO vo = new ComDefaultCodeVO();
		vo.setCommCd("COM022");
		List code = cmmUseService.selectCmmCodeDetail(vo);
		model.addAttribute("pwhtCdList", code);

		return "/egovframework/com/uat/uia/EgovIdPasswordSearch";
	}

	      *//**
	      * 아이디를 찾는다.
	      * @param vo - 이름, 이메일주소, 사용자구분이 담긴 LoginVO
	      * @return result - 아이디
	      * @exception Exception
	      *//*
	@RequestMapping(value="/uat/uia/searchId.do")
	public String searchId(@ModelAttribute("loginVO") LoginVO loginVO, 
			ModelMap model)
					throws Exception {

		//    	if (loginVO == null || loginVO.getUserNm() == null || loginVO.getUserNm().equals("")
		//    		&& loginVO.getUsrEmail() == null || loginVO.getUsrEmail().equals("")
		//    		&& loginVO.getOrgYn() == null || loginVO.getOrgYn().equals("")
		//    	) {
		//    		return "/egovframework/com/cmm/egovError";
		//    	}
		//    	
		//    	// 1. 아이디 찾기
		//    	loginVO.setUserNm(loginVO.getUserNm().replaceAll(" ", ""));
		//        LoginVO resultVO = loginService.searchId(loginVO);
		//        
		//        if (resultVO != null && resultVO.getUserId() != null && !resultVO.getUserId().equals("")) {
		//        	
		//        	model.addAttribute("resultInfo", "아이디는 " + resultVO.getUserId() + " 입니다.");
		//        	return "/egovframework/com/uat/uia/EgovIdPasswordResult";
		//        } else {
		//        	model.addAttribute("resultInfo", egovMessageSource.getMessage("fail.common.idsearch"));
		//        	return "/egovframework/com/uat/uia/EgovIdPasswordResult";
		//        }
		return "";
	}

	       *//**
	       * 비밀번호를 찾는다.
	       * @param vo - 아이디, 이름, 이메일주소, 비밀번호 힌트, 비밀번호 정답, 사용자구분이 담긴 LoginVO
	       * @return result - 임시비밀번호전송결과
	       * @exception Exception
	       *//*
	@RequestMapping(value="/uat/uia/searchPassword.do")
	public String searchPassword(@ModelAttribute("loginVO") LoginVO loginVO, 
			ModelMap model)
					throws Exception {

		//    	if (loginVO == null || loginVO.getUserId() == null || loginVO.getUserId().equals("")
		//    		&& loginVO.getUserNm() == null || loginVO.getUserNm().equals("")
		//    		&& loginVO.getUsrEmail() == null || loginVO.getUsrEmail().equals("")
		//    		//&& loginVO.getPasswordHint() == null || loginVO.getPasswordHint().equals("")
		//    		//&& loginVO.getPasswordCnsr() == null || loginVO.getPasswordCnsr().equals("")
		//    		&& loginVO.getOrgYn() == null || loginVO.getOrgYn().equals("")
		//    	) {
		//    		return "/egovframework/com/cmm/egovError";
		//    	}
		//    	
		//    	// 1. 비밀번호 찾기
		//        boolean result = loginService.searchPassword(loginVO);
		//        
		//        // 2. 결과 리턴
		//        if (result) {
		//        	model.addAttribute("resultInfo", "임시 비밀번호를 발송하였습니다.");
		//        	return "/egovframework/com/uat/uia/EgovIdPasswordResult";
		//        } else {
		//        	model.addAttribute("resultInfo", egovMessageSource.getMessage("fail.common.pwsearch"));
		//        	return "/egovframework/com/uat/uia/EgovIdPasswordResult";
		//        }
		return "";
	}



	        */

}
