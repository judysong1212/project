package com.web.exterms.mypage.iucert.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

import com.web.exterms.mypage.iucert.service.PayrHoldingAcceptService;
import com.web.exterms.mypage.iucert.service.PayrHoldingAcceptDefaultVO;
import com.web.exterms.mypage.iucert.service.PayrHoldingAcceptVO;

/**
 * @Class Name : Payr0900Controller.java
 * @Description : Payr0900 Controller class
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
@SessionAttributes(types=PayrHoldingAcceptVO.class)
public class PayrHoldingAcceptController {

    @Resource(name = "payr0900Service")
    private PayrHoldingAcceptService payr0900Service;
    
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
	
    /**
	 * PAYR0900 목록을 조회한다. (pageing)
	 * @param searchVO - 조회할 정보가 담긴 Payr0900DefaultVO
	 * @return "/payr0900/Payr0900List"
	 * @exception Exception
	 */
    @RequestMapping(value="/payr0900/Payr0900List.do")
    public String selectPayr0900List(@ModelAttribute("searchVO") PayrHoldingAcceptDefaultVO searchVO, 
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
		
        List payr0900List = payr0900Service.selectPayr0900List(searchVO);
        model.addAttribute("resultList", payr0900List);
        
        int totCnt = payr0900Service.selectPayr0900ListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
        model.addAttribute("paginationInfo", paginationInfo);
        
        return "/payr0900/Payr0900List";
    } 
    
    @RequestMapping("/payr0900/addPayr0900View.do")
    public String addPayr0900View(
            @ModelAttribute("searchVO") PayrHoldingAcceptDefaultVO searchVO, Model model)
            throws Exception {
        model.addAttribute("payr0900VO", new PayrHoldingAcceptVO());
        return "/payr0900/Payr0900Register";
    }
    
    @RequestMapping("/payr0900/addPayr0900.do")
    public String addPayr0900(
            PayrHoldingAcceptVO payr0900VO,
            @ModelAttribute("searchVO") PayrHoldingAcceptDefaultVO searchVO, SessionStatus status)
            throws Exception {
        payr0900Service.insertPayr0900(payr0900VO);
        status.setComplete();
        return "forward:/payr0900/Payr0900List.do";
    }
    
    @RequestMapping("/payr0900/updatePayr0900View.do")
    public String updatePayr0900View(
            @RequestParam("dpobCd") java.lang.String dpobCd ,
            @RequestParam("whdgTxIssNum") java.lang.String whdgTxIssNum ,
            @ModelAttribute("searchVO") PayrHoldingAcceptDefaultVO searchVO, Model model)
            throws Exception {
        PayrHoldingAcceptVO payr0900VO = new PayrHoldingAcceptVO();
        payr0900VO.setDpobCd(dpobCd);
        payr0900VO.setWhdgTxIssNum(whdgTxIssNum);
        // 변수명은 CoC 에 따라 payr0900VO
        model.addAttribute(selectPayr0900(payr0900VO, searchVO));
        return "/payr0900/Payr0900Register";
    }

    @RequestMapping("/payr0900/selectPayr0900.do")
    public @ModelAttribute("payr0900VO")
    PayrHoldingAcceptVO selectPayr0900(
            PayrHoldingAcceptVO payr0900VO,
            @ModelAttribute("searchVO") PayrHoldingAcceptDefaultVO searchVO) throws Exception {
        return payr0900Service.selectPayr0900(payr0900VO);
    }

    @RequestMapping("/payr0900/updatePayr0900.do")
    public String updatePayr0900(
            PayrHoldingAcceptVO payr0900VO,
            @ModelAttribute("searchVO") PayrHoldingAcceptDefaultVO searchVO, SessionStatus status)
            throws Exception {
        payr0900Service.updatePayr0900(payr0900VO);
        status.setComplete();
        return "forward:/payr0900/Payr0900List.do";
    }
    
    @RequestMapping("/payr0900/deletePayr0900.do")
    public String deletePayr0900(
            PayrHoldingAcceptVO payr0900VO,
            @ModelAttribute("searchVO") PayrHoldingAcceptDefaultVO searchVO, SessionStatus status)
            throws Exception {
        payr0900Service.deletePayr0900(payr0900VO);
        status.setComplete();
        return "forward:/payr0900/Payr0900List.do";
    }

}
