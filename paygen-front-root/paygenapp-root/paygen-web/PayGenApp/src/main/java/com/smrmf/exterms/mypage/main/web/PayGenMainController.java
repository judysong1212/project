package com.smrmf.exterms.mypage.main.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import egovframework.com.cmm.ComDefaultVO;
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
@SessionAttributes(types = ComDefaultVO.class)
public class PayGenMainController {

	private static final Logger logger = LoggerFactory.getLogger(PayGenMainController.class);
	 
	 
	 /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	 
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
	public String getMainPage(HttpServletRequest request, ModelMap model)
	  throws Exception{ 
		
		//MainMapLocationVO mapLocationVo = new MainMapLocationVO();
		//ComDefaultCodeVO vo = new ComDefaultCodeVO();
	   	//List<CmmnDtlCode> restdeCodeList;
	 	 
		// 공지사항 메인 컨텐츠 조회 시작 ---------------------------------
//		BoardVO boardVO = new BoardVO();
//		boardVO.setPageUnit(5);
//		boardVO.setPageSize(10);//
//		boardVO.setBbsId("BBSMSTR_AAAAAAAAAAAA");
//
//		PaginationInfo paginationInfo = new PaginationInfo();
//		
//		paginationInfo.setCurrentPageNo(boardVO.getPageIndex());
//		paginationInfo.setRecordCountPerPage(boardVO.getPageUnit());
//		paginationInfo.setPageSize(boardVO.getPageSize());
//
//		boardVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
//		boardVO.setLastIndex(paginationInfo.getLastRecordIndex());
//		boardVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
//
//		Map<String, Object> map = bbsMngService.selectBoardArticles(boardVO, "BBSA02");
//		model.addAttribute("notiList", map.get("resultList"));
//		
//		boardVO.setBbsId("BBSMSTR_BBBBBBBBBBBB");
//		map = bbsMngService.selectBoardArticles(boardVO, "BBSA02");
//		model.addAttribute("galList", map.get("resultList"));
		
		// 공지사항 메인컨텐츠 조회 끝 ----------------------------------- 
		//model.put("curLinkUrl", "/main/MainPage.do");  //현재 페이지에 따른 값을 처리하기위해 추가
		
		return "/mypage/main/main";
	}
        

}