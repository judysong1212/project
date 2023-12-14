package com.web.exterms.mypage.board.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.app.smrmf.core.msfmainapp.server.utils.AnyLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.AnyWebServerUtils;
import com.app.smrmf.sysm.server.vo.system.MSFUserInfoVO;
import com.web.exterms.mypage.board.service.BoardPageDefaultVO;
import com.web.exterms.mypage.board.service.BoardPageService;
import com.web.exterms.mypage.board.service.BoardPageVO;
import com.web.exterms.mypage.board.service.Bord0400Service;
import com.web.exterms.mypage.board.service.Bord0400VO;
import com.web.exterms.mypage.login.service.MyPageSessionVO;

import egovframework.com.cmm.service.Globals;
import egovframework.com.utl.cas.service.EgovSessionCookieUtil;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : Bord0300Controller.java
 * @Description : Bord0300 Controller class
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
//@SessionAttributes(types=BoardPageVO.class)
//@SessionAttributes("boardPageVO")
public class BoardPageController {

	private static final String calledClass = BoardPageController.class.getName();
	 

	@Resource(name = "boardPageService")
	private BoardPageService boardPageService;

	@Resource(name = "bord0400Service")
	private Bord0400Service bord0400Service;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * BORD0300 목록을 조회한다. (paging)
	 * @param searchVO - 조회할 정보가 담긴 Bord0300DefaultVO
	 * @return "/bord0300/Bord0300List"
	 * @exception Exception
	 */

	@RequestMapping(value="/bord/NoticeList.do")
	public String selectBoardPageList(@ModelAttribute("searchVO") BoardPageDefaultVO searchVO,
			HttpServletResponse response,
			ModelMap model)
					throws Exception {

		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));


		/** paging */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getRecordCountPerPage());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		searchVO.setSysDivCd("EXTERM00");
		searchVO.setBullBordUid("extermspage02");
		searchVO.setBullBordGrpId(new BigDecimal(2));    	

		List boardPageList = boardPageService.selectBoardPageList(searchVO);
		model.addAttribute("resultList", boardPageList);

		int totCnt = boardPageService.selectBoardPageListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/mypage/board/NoticeList";
	} 
	/**
	 * 글을 조회한다.(BORD0300)
	 * @param sampleVO - 조회할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return @ModelAttribute("sampleVO") - 조회한 정보
	 * @exception Exception
	 */
	@RequestMapping("/bord/selectBoardPage.do")
	public @ModelAttribute("boardPageVO")
	BoardPageVO selectBoardPage(
			BoardPageVO boardPageVO,
			@ModelAttribute("searchVO") BoardPageDefaultVO searchVO) throws Exception {

		return boardPageService.selectBoardPage(boardPageVO);
	}

	/**
	 * 글을 조회한다.(BORD0400)
	 * @param sampleVO - 조회할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return @ModelAttribute("sampleVO") - 조회한 정보
	 * @exception Exception
	 */
	@RequestMapping("/bord/selectBoardPage1.do")
	public @ModelAttribute("bord0400VO")
	Bord0400VO selectBord0400(
			Bord0400VO bord0400VO,
			BoardPageVO boardPageVO,
			@ModelAttribute("searchVO") BoardPageDefaultVO searchVO) throws Exception {
		return bord0400Service.selectBord0400(bord0400VO);
	}



	/**
	 * 글 등록 화면을 조회한다.
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 */
	@RequestMapping(value="/bord/addBoardPageView.do")
	public String addBoardPageView(
			@ModelAttribute("searchVO") BoardPageDefaultVO searchVO, 
			Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String method = calledClass + ".addBoardPageView";
		String windowNm = "공지사항 등록화면";
		String windowId = "NoticeWrite";

		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser = (MSFUserInfoVO) AnyWebServerUtils.getLoggedUser(request);	

		BoardPageVO boardPageVO = new BoardPageVO();

		try{
			boardPageVO.setSysDivCd("EXTERM00");				//시스템구분코드
			boardPageVO.setBullBordUid("extermspage02");		//게시판_UID
			boardPageVO.setBullBordGrpId(new BigDecimal (2));	//게시판 그룹ID	
			boardPageVO.setTplvlWrtnInfo(BigDecimal.ONE);		//최상위 글정보
			boardPageVO.setWrtnAswrStge(BigDecimal.ZERO);		//글의 답변단계
			boardPageVO.setWrtnRgstnOrd(new BigDecimal(1));		//글의 등록된 순서
			boardPageVO.setAswrWrtnNum(new BigDecimal (0));		//답변하는 글의 번호
			boardPageVO.setPpgPernNm((String) sessionUser.getUsrNm());
			boardPageVO.setUsrId((String) sessionUser.getUsrId());
			boardPageVO.setWrtnSecrNum("0000");					//글 비밀번호

			model.addAttribute("boardPageVO", boardPageVO);
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();	    
			/** 에러 로그 **/			
			AnyLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.READ.toString(), e, windowNm, windowId);
		}

		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인			O:로그아웃
		 */
		AnyLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.READ.toString());

		return  "/mypage/board/NoticeWrite";
	}
	/**
	 * 글을 등록한다.
	 * @param sampleVO - 등록할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/sample/egovSampleList.do"
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/bord/addBoardPage.do")
	public String addBoardPage(
			BoardPageVO boardPageVO,	Bord0400VO bord0400VO, @ModelAttribute("searchVO") BoardPageDefaultVO searchVO, SessionStatus status, 
			HttpSession session,	ModelMap model,	MultipartHttpServletRequest multiRequest,	HttpServletRequest request, HttpServletResponse response) throws Exception {

		String method = calledClass + ".addBoardPage";
		String windowNm = "공지사항 등록";
		String windowId = "NoticeWrite";

		MSFUserInfoVO sessionUser = (MSFUserInfoVO) AnyWebServerUtils.getLoggedUser(request);	

		try{
			//extract files
			final Map<String, MultipartFile> files = multiRequest.getFileMap();
			Assert.notNull(files, "files is null");
			Assert.state(files.size() > 0, "0 files exist");

			//process files
			String uploadPath =  Globals.FILE_STORE_PATH;
			File saveFolder = new File(uploadPath); 

			//서비스호출
			boardPageService.insertBoardPage(boardPageVO);

			// 디렉토리생성
			if (!saveFolder.exists() || saveFolder.isFile()) {
				saveFolder.mkdirs();
			}
			Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
			MultipartFile file;
			String filePath;
			while (itr.hasNext()) {
				Entry<String, MultipartFile> entry = itr.next();
				System.out.println("[" + entry.getKey() + "]");
				file = entry.getValue();
				if (!"".equals(file.getOriginalFilename())) {
					filePath = uploadPath + "\\" + file.getOriginalFilename();
					file.transferTo(new File(filePath));
					String urlfilePath = Globals.EXTERM_UPLOAD;
					bord0400VO.setFlRfta(filePath);
					bord0400VO.setFlNm(file.getOriginalFilename());
					bord0400VO.setFlSz(file.getSize());
					model.addAttribute("bord0400VO", bord0400VO);
					bord0400Service.insertBoardPage1(bord0400VO); //저장
				}

			}
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

		//세션종료
		status.setComplete();
		return "forward:/main/MainPage.do";
	}
	/**
	 * 글 보기화면을 조회한다.
	 * @param id - 수정할 글 id
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "/sample/egovSampleRegister"
	 * @exception Exception
	 */
	@RequestMapping(value="/bord/viewBoardPageView.do")
	public String viewBoardPageView(    
			@RequestParam("sysDivCd") java.lang.String sysDivCd ,
			@RequestParam("bullBordMsgeSeilNum") java.math.BigDecimal bullBordMsgeSeilNum ,
			@RequestParam("bullBordUid") java.lang.String bullBordUid ,
			@RequestParam("bullBordGrpId") java.math.BigDecimal bullBordGrpId ,
			@ModelAttribute("searchVO") BoardPageDefaultVO searchVO, Model model, SessionStatus status,
			HttpSession session, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		String method = calledClass + ".updateBoardPage";
		String windowNm = "공지사항 보기";
		String windowId = "NoticeView";

		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser = (MSFUserInfoVO) AnyWebServerUtils.getLoggedUser(request);	

		BoardPageVO boardPageVO = new BoardPageVO();
		Bord0400VO bord0400VO = new Bord0400VO();

		try{
			boardPageVO.setSysDivCd(sysDivCd);
			boardPageVO.setBullBordMsgeSeilNum(bullBordMsgeSeilNum);
			boardPageVO.setBullBordUid(bullBordUid);
			boardPageVO.setBullBordGrpId(bullBordGrpId);

			bord0400VO.setSysDivCd(sysDivCd);
			bord0400VO.setBullBordMsgeSeilNum(bullBordMsgeSeilNum);
			bord0400VO.setBullBordUid(bullBordUid);
			bord0400VO.setBullBordGrpId(bullBordGrpId);

			// 변수명은 CoC 에 따라 bord0300VO
			model.addAttribute(selectBoardPage(boardPageVO, searchVO));
			model.addAttribute(selectBord0400(bord0400VO, boardPageVO, searchVO));
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();		
			/** 에러 로그 **/			
			AnyLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.READ.toString(), e, windowNm, windowId);
		}

		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인			O:로그아웃
		 */
		AnyLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.READ.toString());

		//세션종료
		status.setComplete();

		return "/mypage/board/NoticeView";
	}

	/**
	 * 글 수정화면을 조회한다.
	 * @param id - 수정할 글 id
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param model
	 * @return "/sample/egovSampleRegister"
	 * @exception Exception
	 */
	@RequestMapping(value="/bord/updateBoardPageView.do")
	//@RequestMapping(value="/bord/updateBoardPageView.do", method=RequestMethod.GET)
	public String updateBoardPageView(    
			@RequestParam("sysDivCd") java.lang.String sysDivCd ,
			@RequestParam("bullBordMsgeSeilNum") java.math.BigDecimal bullBordMsgeSeilNum ,
			@RequestParam("bullBordUid") java.lang.String bullBordUid ,
			@RequestParam("bullBordGrpId") java.math.BigDecimal bullBordGrpId ,
			@ModelAttribute("searchVO") BoardPageDefaultVO searchVO, Model model, SessionStatus status,
			HttpSession session, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		String method = calledClass + ".updateBoardPageView";
		String windowNm = "공지사항 수정화면";
		String windowId = "NoticeModify";

		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser = (MSFUserInfoVO) AnyWebServerUtils.getLoggedUser(request);	

		BoardPageVO boardPageVO = new BoardPageVO();
		Bord0400VO bord0400VO = new Bord0400VO();

		try{
			boardPageVO.setSysDivCd(sysDivCd);
			boardPageVO.setBullBordMsgeSeilNum(bullBordMsgeSeilNum);
			boardPageVO.setBullBordUid(bullBordUid);
			boardPageVO.setBullBordGrpId(bullBordGrpId);
			boardPageVO.setTplvlWrtnInfo(BigDecimal.ONE);		//최상위 글정보
			// 변수명은 CoC 에 따라 bord0300VO
			model.addAttribute(selectBoardPage(boardPageVO, searchVO));
			//boardPageVO = boardPageService.selectBoardPage(boardPageVO);
			//model.addAttribute("boardPageVO", boardPageVO);
			model.addAttribute("bord0400VO", bord0400VO);
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();		
			/** 에러 로그 **/			
			AnyLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.READ.toString(), e, windowNm, windowId);
		}

		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인			O:로그아웃
		 */
		AnyLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.READ.toString());

		//세션종료
		status.setComplete();

		return "/mypage/board/NoticeModify";
	}


	/**
	 * 글을 수정한다.
	 * @param sampleVO - 수정할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/sample/egovSampleList.do"
	 * @exception Exception
	 */

	@RequestMapping("/bord/updateBoardPage.do")
	//@RequestMapping(value="/bord/updateBoardPage.do", method=RequestMethod.POST)
	public String updateBoardPage(
			BoardPageVO boardPageVO,
			Bord0400VO bord0400VO,
			@ModelAttribute("searchVO") BoardPageDefaultVO searchVO, SessionStatus status, 
			HttpSession session, HttpServletRequest request, HttpServletResponse response, MultipartHttpServletRequest multiRequest)
					throws Exception {
		String method = calledClass + ".updateBoardPage";
		String windowNm = "공지사항 수정";
		String windowId = "NoticeModify";

		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser = (MSFUserInfoVO) AnyWebServerUtils.getLoggedUser(request);	

		try{
			boardPageVO.setUsrId(sessionUser.getUsrId());
			
			//extract files
			final Map<String, MultipartFile> files = multiRequest.getFileMap();
			Assert.notNull(files, "files is null");
			Assert.state(files.size() > 0, "0 files exist");

			//process files
			String uploadPath =  Globals.FILE_STORE_PATH;
			File saveFolder = new File(uploadPath); 
			
			//서비스호출
			boardPageService.updateBoardPage(boardPageVO);

			// 디렉토리생성
			if (!saveFolder.exists() || saveFolder.isFile()) {
				saveFolder.mkdirs();
			}
			Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
			MultipartFile file;
			String filePath;
			while (itr.hasNext()) {
				Entry<String, MultipartFile> entry = itr.next();
				System.out.println("[" + entry.getKey() + "]");
				file = entry.getValue();
				if (!"".equals(file.getOriginalFilename())) {
					filePath = uploadPath + "\\" + file.getOriginalFilename();
					file.transferTo(new File(filePath));
					String urlfilePath = Globals.EXTERM_UPLOAD;
					bord0400VO.setFlRfta(filePath);
					bord0400VO.setFlNm(file.getOriginalFilename());
					bord0400VO.setFlSz(file.getSize());
					bord0400VO.setBullBordMsgeSeilNum(boardPageVO.getBullBordMsgeSeilNum());
					List check = bord0400Service.selectCheckBord0400(bord0400VO);
					
					if(check.size() <= 0){
						bord0400Service.insertBoardPage1(bord0400VO);
					}else{
						bord0400Service.updateBord0400(bord0400VO);
					}
					
				}

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

		//세션종료
		status.setComplete();

		return "/mypage/board/NoticeView";
	}


	/**
	 * 글을 삭제한다.
	 * @param sampleVO - 삭제할 정보가 담긴 VO
	 * @param searchVO - 목록 조회조건 정보가 담긴 VO
	 * @param status
	 * @return "forward:/sample/egovSampleList.do"
	 * @exception Exception
	 */
	@RequestMapping("/bord/deleteBoardPage.do")
	public String deleteBoardPage(
			BoardPageVO boardPageVO,
			Bord0400VO bord0400VO,
			@ModelAttribute("searchVO") BoardPageDefaultVO searchVO, Model model, SessionStatus status,
			HttpSession session, HttpServletRequest request, HttpServletResponse response)
					throws Exception {
		String method = calledClass + ".deleteBoardPage";
		String windowNm = "공지사항 삭제";
		String windowId = "NoticeView";

		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser = (MSFUserInfoVO) AnyWebServerUtils.getLoggedUser(request);	
		
		try{
			boardPageVO.setUsrId(sessionUser.getUsrId());
			//서비스
			boardPageService.deleteBoardPage(boardPageVO);
			bord0400Service.deleteBord0400(bord0400VO);
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();		
			/** 에러 로그 **/			
			AnyLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.DELETE.toString(), e, windowNm, windowId);
		}

		//세션종료
		status.setComplete();

		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인			O:로그아웃
		 */
		AnyLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.DELETE.toString());

		return "forward:/main/MainPage.do";
	}

	/**
	 * 브라우저 구분 얻기.
	 * 
	 * @param request
	 * @return
	 */
	private String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		if (header.indexOf("MSIE") > -1) {
			return "MSIE";
		} else if (header.indexOf("Trident") > -1) {
			return "Trident";
		} else if (header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			return "Opera";
		}
		return "Firefox";
	}

	/**
	 * Disposition 지정하기.
	 * 
	 * @param filename
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void setDisposition(String flNm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String browser = getBrowser(request);
		String dispositionPrefix = "attachment; filename=";
		String encodedFilename = null;

		if (browser.equals("MSIE")) {
			encodedFilename = URLEncoder.encode(flNm, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Trident")) {
			encodedFilename = URLEncoder.encode(flNm, "UTF-8").replaceAll("\\+", "%20");
		} else if (browser.equals("Firefox")) {
			encodedFilename = "\"" + new String(flNm.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Opera")) {
			encodedFilename = "\"" + new String(flNm.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Chrome")) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < flNm.length(); i++) {
				char c = flNm.charAt(i);
				if (c > '~') {
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					sb.append(c);
				}
			}
			encodedFilename = sb.toString();
		} else {
			//throw new RuntimeException("Not supported browser");
			throw new IOException("Not supported browser");
		}

		//파일 링크 클릭 시 다운로드 저장 화면이 출력되게 처리하는 부분
		response.setHeader("Content-Disposition", dispositionPrefix + encodedFilename);

		if ("Opera".equals(browser)){
			response.setContentType("application/octet-stream;charset=UTF-8");
		}
	}

	/** file download */
	@RequestMapping(value = "/download/downloadFile.do")
	public void downloadFile(Map<String, Object> commandMap, HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception {
		String method = calledClass + ".downloadFile";
		String windowNm = "파일 다운로드";
		String windowId = "NoticeView";

		String flNm = URLDecoder.decode(request.getParameter("flNm"),"UTF-8");
		String uploadPath = Globals.FILE_STORE_PATH;
		File uFile = new File(uploadPath, flNm);
		int flSz = (int) uFile.length();

		//로그 기록을 위한 세션 유저 정보 vo에 담음
		MSFUserInfoVO sessionUser = (MSFUserInfoVO) AnyWebServerUtils.getLoggedUser(request);	

		try{
			if (flSz > 0) {
				String mimetype = "application/x-msdownload";

				response.setContentType(mimetype);
				setDisposition(flNm, request, response);
				response.setHeader("Pragma","no-cache");
				response.setHeader("Expires","Thu, 01 Jan 1970 16:00:00 GMT");
				response.setHeader("Cache-Control","max-age = 0");  
				response.setContentLength(flSz);

				/*
				 * FileCopyUtils.copy(in, response.getOutputStream());
				 * in.close(); 
				 * response.getOutputStream().flush();
				 * response.getOutputStream().close();
				 */
				BufferedInputStream in = null;
				BufferedOutputStream out = null;

				try {
					in = new BufferedInputStream(new FileInputStream(uFile));
					out = new BufferedOutputStream(response.getOutputStream());

					FileCopyUtils.copy(in, out);
					out.flush();
				} catch (Exception ex) {
					//ex.printStackTrace();
					// 다음 Exception 무시 처리
					// Connection reset by peer: socket write error
					logger.debug("IGNORED: " + ex.getMessage());
				} finally {
					if (in != null) {
						try {
							in.close();
						} catch (Exception ignore) {
							// no-op
							logger.debug("IGNORED: " + ignore.getMessage());
						}
					}
					if (out != null) {
						try {
							out.close();
						} catch (Exception ignore) {
							// no-op
							logger.debug("IGNORED: " + ignore.getMessage());
						}
					}
				}

			} else {
				//setContentType을 프로젝트 환경에 맞추어 변경
				response.setContentType("application/x-msdownload; charset=UTF-8");
				PrintWriter printwriter = response.getWriter();
				printwriter.println("<html>");
				printwriter.println("<br><br><br><h2>Could not get file name:<br>"
						+ flNm + "</h2>");
				printwriter.println("<br><br><br><center><h3><a href='javascript: window.close();'>Close</a></h3></center>");
				printwriter.println("<br><br><br>&copy; webAccess");
				printwriter.println("</html>");
				printwriter.flush();
				printwriter.close();
			}
		}catch(Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();		
			/** 에러 로그 **/			
			AnyLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.READ.toString(), e, windowNm, windowId);
		}

		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
		 * D:delete		S:select	B:배치 
		 * L:로그인			O:로그아웃
		 */
		AnyLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, AnyLogHistoryUtils.AnyAtDatabase.READ.toString());
	}


}


