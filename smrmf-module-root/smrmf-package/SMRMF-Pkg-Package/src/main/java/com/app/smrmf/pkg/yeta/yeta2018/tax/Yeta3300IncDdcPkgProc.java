package com.app.smrmf.pkg.yeta.yeta2018.tax;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160402VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160403VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe160404_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe160405_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe160406_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe160510_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161005_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161020_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161030_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161040_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161050_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161055_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161060_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161070_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161080_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161090_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162020_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162030_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162040_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162510_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162520_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe162530_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe164010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165020_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165030Temp_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165030_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe166010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe166020_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe169010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe169010a_2018_VO;
import com.app.smrmf.pkg.yeta.yeta2018.tax.service.Yeta3300IncDdcService;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta3300IncDdcPkgProc  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta3300PkgProcContainer.class);
	   
    
    @Resource(name = "Yeta3300IncDdcService")
    protected Yeta3300IncDdcService  incDdcService;
    
    public Yeta3300IncDdcPkgProc() {
    	
    } 
   
    
    /**
     * 
     * <pre>
     * 1. 개요 :  데이타 변경에 따른 처리  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : execfnYeta3300YetaTableCalcUpdate
     * @date : 2018. 1. 31.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2018. 1. 31.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param listYe161010VO
     * @param serviceDiv
     * @return
     * @throws Exception
     */
    public PagingLoadResult<ShowMessageBM> funcYeta3300IncDdcPkgProc(HttpServletRequest request,InfcPkgYe161010_2018_VO  ye161010VO,String serviceDiv)  throws Exception  {
  	    
	  	  return  funcYeta3300YetaTableCalcUpdate(request,  ye161010VO,serviceDiv);
	}
    
   
    /**
     * 
     * <pre>
     * 1. 개요 : 데이타 변경에 따른 처리 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : funcYeta3300YetaTableCalcUpdate
     * @date : 2018. 1. 31.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2018. 1. 31.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param listYe161010VO
     * @param serviceDiv
     * @return
     * @throws Exception
     */
    private PagingLoadResult<ShowMessageBM> funcYeta3300YetaTableCalcUpdate(HttpServletRequest request, InfcPkgYe161010_2018_VO ye161010VO,String serviceDiv)  throws Exception  {
    	
  	    PagingLoadResult<ShowMessageBM> retval = null; 
	    List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
	   
	    incDdcService = (Yeta3300IncDdcService)BeanFinder.getBean("Yeta3300IncDdcService");
	   
	    // 변수선언 
	  	int statCnt = 0;
	  	String dataCheck = "";
	  
	  	  
		
		InfcPkgYe160401VO infcPkgYe160401Vo = new InfcPkgYe160401VO(); 		// 현근무지 급여지급 명세 
		InfcPkgYe160402VO infcPkgYe160402Vo = new InfcPkgYe160402VO(); 		// 과세감면소득정산  
		InfcPkgYe160403VO infcPkgYe160403Vo = new InfcPkgYe160403VO(); 		// 비과세감면소득정산 
	 
		
		InfcPkgYe160404_2018_VO    infcPkgYe160404Vo	 = new InfcPkgYe160404_2018_VO();	//D_종전근무처
		InfcPkgYe160405_2018_VO    infcPkgYe160405Vo	 = new InfcPkgYe160405_2018_VO();	//D_종전근무처비과세_감면소득_비과세
		InfcPkgYe160406_2018_VO    infcPkgYe160406Vo	 = new InfcPkgYe160406_2018_VO();	//종전근무지연금보험료_공적연금
		InfcPkgYe160510_2018_VO    infcPkgYe160510Vo	 = new InfcPkgYe160510_2018_VO();	//근무지별비과세_감면소득
		
		InfcPkgYe161005_2018_VO    infcPkgYe161005Vo	 = new InfcPkgYe161005_2018_VO();	//A_원천세신고기본
		 
		InfcPkgYe161020_2018_VO    infcPkgYe161020Vo	 = new InfcPkgYe161020_2018_VO();	//A_인적소득공제기본
		InfcPkgYe161030_2018_VO    infcPkgYe161030Vo	 = new InfcPkgYe161030_2018_VO();	//E_인적공제명세
		InfcPkgYe161040_2018_VO    infcPkgYe161040Vo	 = new InfcPkgYe161040_2018_VO();	//E_소득세액공제명세
		InfcPkgYe161050_2018_VO    infcPkgYe161050Vo	 = new InfcPkgYe161050_2018_VO();	//C_연금보험료공제
		InfcPkgYe161055_2018_VO    infcPkgYe161055Vo	 = new InfcPkgYe161055_2018_VO();	//C_연금보험료_공적연금상세
		InfcPkgYe161060_2018_VO    infcPkgYe161060Vo	 = new InfcPkgYe161060_2018_VO();	//C_특별소득공제
		InfcPkgYe161070_2018_VO    infcPkgYe161070Vo	 = new InfcPkgYe161070_2018_VO();	//C_그밖의소득공제
		InfcPkgYe161080_2018_VO    infcPkgYe161080Vo	 = new InfcPkgYe161080_2018_VO();	//C_세액감면및공제
		
		InfcPkgYe161090_2018_VO    infcPkgYe161090Vo	 = new InfcPkgYe161090_2018_VO();	//C_교육비내역
		
		InfcPkgYe162010_2018_VO    infcPkgYe162010Vo	 = new InfcPkgYe162010_2018_VO();	//F_연금저축계좌
		InfcPkgYe162020_2018_VO    infcPkgYe162020Vo	 = new InfcPkgYe162020_2018_VO();	//F_퇴직연금계좌명세
		InfcPkgYe162030_2018_VO    infcPkgYe162030Vo	 = new InfcPkgYe162030_2018_VO();	//F_주택마련저축
		InfcPkgYe162040_2018_VO    infcPkgYe162040Vo	 = new InfcPkgYe162040_2018_VO();	//F_장기집합투자증권저축_B1013
		
		InfcPkgYe162510_2018_VO    infcPkgYe162510Vo	 = new InfcPkgYe162510_2018_VO();	//G_월세액소득공제명세
		InfcPkgYe162520_2018_VO    infcPkgYe162520Vo	 = new InfcPkgYe162520_2018_VO();	//G_거주자간_금전소비대차
		InfcPkgYe162530_2018_VO    infcPkgYe162530Vo	 = new InfcPkgYe162530_2018_VO();	//G_임대차계약
		
		InfcPkgYe164010_2018_VO    infcPkgYe164010Vo	 = new InfcPkgYe164010_2018_VO();	//A_의료비지급명세
		
		InfcPkgYe165010_2018_VO    infcPkgYe165010Vo	 = new InfcPkgYe165010_2018_VO();	//I_해당연도기부금명세
		InfcPkgYe165020_2018_VO    infcPkgYe165020Vo	 = new InfcPkgYe165020_2018_VO();	//I_기부자관계코드별기부금합계
		InfcPkgYe165030_2018_VO    infcPkgYe165030Vo	 = new InfcPkgYe165030_2018_VO();	//H_기부금조정명세
		InfcPkgYe165030Temp_2018_VO infcPkgYe165030TempVo = new InfcPkgYe165030Temp_2018_VO();  	    //H_기부금조정명세_TEMP	 
		
		InfcPkgYe166010_2018_VO    infcPkgYe166010Vo	 = new InfcPkgYe166010_2018_VO();	//신용카드등소득공제명세
		InfcPkgYe166020_2018_VO    infcPkgYe166020Vo	 = new InfcPkgYe166020_2018_VO();	//신용카드등소득공제상세
			 								//
		InfcPkgYe169010_2018_VO    infcPkgYe169010Vo	 = new InfcPkgYe169010_2018_VO();	//C_주현근무처
		InfcPkgYe169010a_2018_VO   infcPkgYe169010AVo = new InfcPkgYe169010a_2018_VO();	//C_주현근무처_표준공제 
		
		
    try { 
		  	  
     
		
		infcPkgYe161080Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161080Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161080Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161080Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161080Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161080Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161080Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//의료비 교육비 
		infcPkgYe161040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161040Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161040Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		
 		infcPkgYe161050Vo.setDpobCd(sessionUser.getDpobCd());
 		infcPkgYe161050Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
 		infcPkgYe161050Vo.setSystemkey(ye161010VO.getSystemkey());
 		infcPkgYe161050Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
 		infcPkgYe161050Vo.setKybdr(sessionUser.getUsrId());
 		infcPkgYe161050Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
 		infcPkgYe161050Vo.setIsmt(sessionUser.getUsrId());
 		infcPkgYe161050Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
 		
 		infcPkgYe161055Vo.setDpobCd(sessionUser.getDpobCd());
 		infcPkgYe161055Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
 		infcPkgYe161055Vo.setSystemkey(ye161010VO.getSystemkey());
 		infcPkgYe161055Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
 		infcPkgYe161055Vo.setKybdr(sessionUser.getUsrId());
 		infcPkgYe161055Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
 		infcPkgYe161055Vo.setIsmt(sessionUser.getUsrId());
 		infcPkgYe161055Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
 		
		

 		infcPkgYe161060Vo.setDpobCd(sessionUser.getDpobCd());
 		infcPkgYe161060Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
 		infcPkgYe161060Vo.setSystemkey(ye161010VO.getSystemkey());
 		infcPkgYe161060Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
 		infcPkgYe161060Vo.setKybdr(sessionUser.getUsrId());
 		infcPkgYe161060Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
 		infcPkgYe161060Vo.setIsmt(sessionUser.getUsrId());
 		infcPkgYe161060Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
 		

		infcPkgYe161070Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161070Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161070Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161070Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161070Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161070Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161070Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());		
		
		
		
		infcPkgYe166020Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe166020Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe166020Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe166020Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe166020Vo.setFamResnoEncCntn(ye161010VO.getTxprDscmNoCntn());
		infcPkgYe166020Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe166020Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe166020Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe166020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		
		infcPkgYe166010Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe166010Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe166010Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe166010Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe166010Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe166010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe166010Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe166010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		infcPkgYe160404Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe160404Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe160404Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe160404Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe160404Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe160404Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe160404Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe160404Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		
		if ("YE161030".equals(serviceDiv)) {
  		  //근로소득재계산 미처리 루틴 추가 부녀장 체크 풀ㄹ기
			infcPkgYe161030Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe161030Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe161030Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe161030Vo.setClutSeptCd(ye161010VO.getClutSeptCd()); 
			infcPkgYe161030Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe161030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe161030Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe161030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			infcPkgYe169010Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe169010Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe169010Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe169010Vo.setClutSeptCd(ye161010VO.getClutSeptCd()); 
			infcPkgYe169010Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe169010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe169010Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe169010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
  			statCnt = 0;
  			statCnt = incDdcService.incDdcYeta3300_YE169010_Tax_2018_06_Update(infcPkgYe169010Vo);  
  				
  			if (statCnt >= 0) {  
  				 
  				incDdcService.incDdcYeta3100_YE161030_2018_CREATE_Update(infcPkgYe161030Vo); 
     	         
  			}
  			
  	      } else if ("YE164010".equals(serviceDiv)) {
    		  //의료비 
    		  //40업데이트   
    			//YE161040 소득공제명세에 의료비 개별 
    			statCnt = 0;
    			statCnt = incDdcService.incDdcYeta2018_B101Y_YE161040_Update(infcPkgYe161040Vo);  
    				
    			if (statCnt >= 0) { 
    				// 의료비정리 합계  
    				incDdcService.incDdcYeta2018_YE161080_2018_Update(infcPkgYe161080Vo); 
       	         
    			}
    			
    		  
    	  } else if ("YE161090".equals(serviceDiv)) {
    		  //교육비
    		   
    		    statCnt = 0;
    			//YE161040 소득공제명세에 교육비개별 
    		    statCnt =  incDdcService.incDdcYeta2018_C101Y_YE161040_Update(infcPkgYe161040Vo); 
    			 
    			if (statCnt >= 0) { 
    				// 교육비 합계  
    				incDdcService.incDdcYeta2018_C101Y_YE161080_2018_Update(infcPkgYe161080Vo); 
       	         
    			}	  
     
    	  } else if ("YE165010".equals(serviceDiv)) {	  
    		  //기부금 
    			infcPkgYe165020Vo.setDpobCd(sessionUser.getDpobCd());
    			infcPkgYe165020Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
    			infcPkgYe165020Vo.setSystemkey(ye161010VO.getSystemkey());
    			infcPkgYe165020Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
    			infcPkgYe165020Vo.setKybdr(sessionUser.getUsrId());
    			infcPkgYe165020Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
    			infcPkgYe165020Vo.setIsmt(sessionUser.getUsrId());
    			infcPkgYe165020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
    			
    			dataCheck = "";
    			//기부금
    			incDdcService.incDdcYeta2018_L102Y_YE165020_Delete(infcPkgYe165020Vo); 
    			dataCheck = incDdcService.incDdcYeta2018_L102Y_YE165020_Insert(infcPkgYe165020Vo);
    			
    			if (MSFSharedUtils.paramNull(dataCheck)) {
    				
		    	        infcPkgYe165030Vo.setDpobCd(sessionUser.getDpobCd());
		    	        infcPkgYe165030Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		    	        infcPkgYe165030Vo.setSystemkey(ye161010VO.getSystemkey());
		    	        infcPkgYe165030Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		    	        infcPkgYe165030Vo.setKybdr(sessionUser.getUsrId());
		    			infcPkgYe165030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		    			infcPkgYe165030Vo.setIsmt(sessionUser.getUsrId());
		    			infcPkgYe165030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		    			//기부금
		    			dataCheck = "";
		    			incDdcService.incDdcYeta2018_L102Y_YE165030_Delete(infcPkgYe165030Vo); 
		    			dataCheck =  incDdcService.incDdcYeta2018_L102Y_YE165030_Insert(infcPkgYe165030Vo);
		    			
		    			if (MSFSharedUtils.paramNull(dataCheck)) {		  
		    			// 기부금 합계  
		    			 statCnt = 0;
		    			 incDdcService.incDdcYeta2018_L102Y_YE161040_2018_Update(infcPkgYe161040Vo); 
		    			 statCnt = incDdcService.incDdcYeta2018_L102Y_YE161080_2018_Update(infcPkgYe161080Vo);  
		    			 
		    				if (statCnt >= 0) { 	  
				    	 		 				 
				    	 		// 기부금 합계  
		    					incDdcService.incDdcYeta2018_L102Y_YE161060_2018_Update(infcPkgYe161060Vo); 
		    	          
		    				}
		    			}	
    			}
    		
    	  } else if ("YE162010".equals(serviceDiv)) {	  
    		  //연금저축계좌  
    		  incDdcService.incDdcYeta2018_D101Y_YE161070_2018_Update(infcPkgYe161070Vo);  
    			// 교육비 합계  
    		  incDdcService.incDdcYeta2018_E102Y_YE161080_2018_Update(infcPkgYe161080Vo); 
    	           //퇴직연금
    		  incDdcService.incDdcYeta2018_F102Y_YE161080_2018_Update(infcPkgYe161080Vo); 
    	        //주택마련저축 
    		  incDdcService.incDdcYeta2018_J301Y_YE161070_2018_Update(infcPkgYe161070Vo); 
    	        
    		  incDdcService.incDdcYeta2018_N101Y_YE161070_2018_Update(infcPkgYe161070Vo); 
    	        
    	  } else if ("YE162510".equals(serviceDiv)) {	  
    		  //월세액소득공제명세 
//    		  incDdcService.incDdcYeta2018_YE162510_YE161070_2018_Update(infcPkgYe161070Vo ); 
    	  
    	  } else if ("YE161050".equals(serviceDiv)) {	  
    		  
    		  // 4대보험 처리 루틴 
    		  
    		  // 55데이타을 50으로 공적보험료공제 
    		  incDdcService.incDdcYeta2018_YE161055_2018_Update(infcPkgYe161050Vo); 
    		  
    		  
    		  incDdcService.delete_YETA3300_2018_Ye161055(infcPkgYe161055Vo); 
    		  incDdcService.insert_YETA3300_2018_Ye161055(infcPkgYe161055Vo); 
    		
    			
    		  // 소득공제 수정 시 연금보험료공제 합계 반영
    		  incDdcService.incDdcYeta2018_YE161050_2018_Update(infcPkgYe161050Vo); 
    		  
    		  
    	  } else if ("YE166020_INSERT".equals(serviceDiv)) {
    		  //현금영수증.신용카드.직불카드 
    		  
    		//신용카드
    		incDdcService.incDdcYeta2018_G107Y_YE166020_Update(infcPkgYe166020Vo);    
    				
    		// 신용카드  
    		incDdcService.incDdcYeta2018_G107Y_YE161070_2018_Update(infcPkgYe161070Vo);  
    		    	
    			   				 
    		// 현금영수증  
    		incDdcService.incDdcYeta2018_G207Y_YE161070_2018_Update(infcPkgYe161070Vo); 
    		   	 
    		// 직불카드  
    		incDdcService.incDdcYeta2018_G307Y_YE161070_2018_Update(infcPkgYe161070Vo); 
	    
  	    } else if ("YE166020_DELETE".equals(serviceDiv)) {	
    		  
  	    	//신용카드
			incDdcService.incDdcYeta2018_G107Y_YE166020_Delete(infcPkgYe166020Vo);    
			
  	    	// 신용카드  
			incDdcService.incDdcYeta2018_G107Y_YE161070_2018_Update(infcPkgYe161070Vo);  
	    	
		   				 
			// 현금영수증  
			incDdcService.incDdcYeta2018_G207Y_YE161070_2018_Update(infcPkgYe161070Vo); 
	   	 
		 // 직불카드  
			incDdcService.incDdcYeta2018_G307Y_YE161070_2018_Update(infcPkgYe161070Vo); 

			
        } else if ("YE166020_NEW".equals(serviceDiv)) {			  
    		  	//신용카드 인적공제 신규추가시 생성하는 부분 
        		//신용카드  			  	    
//				infcPkgYe166020Vo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
//				infcPkgYe166020Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161010VO.getYrtxBlggYr()));    							/** column 귀속연도 : yrtxBlggYr */
//				infcPkgYe166020Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161010VO.getClutSeptCd()));    							/** column 연말정산구분코드 : clutSeptCd */
//				infcPkgYe166020Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161010VO.getSystemkey()));    								/** column SYSTEMKEY : systemkey */
//				infcPkgYe166020Vo.setFamResnoEncCntn(ye161010VO.getTxprDscmNoCntn());
//				
//				infcPkgYe166020Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
//				infcPkgYe166020Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
//				infcPkgYe166020Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
//				infcPkgYe166020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */
				
				
				// 삭제루틴 추가 
				incDdcService.incDdcYeta2018_YE166020_2018_CREATE_Delete(infcPkgYe166020Vo); 
				
				dataCheck = "";
				dataCheck = incDdcService.incDdcYeta2018_YE166020_2018_CREATE_Insert(infcPkgYe166020Vo);   
				
				if (MSFSharedUtils.paramNull(dataCheck)) { 
 	
					bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "신용카드인적 생성.","데이타확인","")); 
					logger.debug("5. 신용카드 INSERT 종료 "); 
						//신용카드 
						infcPkgYe166010Vo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
						infcPkgYe166010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161010VO.getYrtxBlggYr()));    							/** column 귀속연도 : yrtxBlggYr */
						infcPkgYe166010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161010VO.getClutSeptCd()));    							/** column 연말정산구분코드 : clutSeptCd */
						infcPkgYe166010Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161010VO.getSystemkey()));    								/** column SYSTEMKEY : systemkey */

						infcPkgYe166010Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
						infcPkgYe166010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
						infcPkgYe166010Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
						infcPkgYe166010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */
						
						
						// 삭제루틴 추가 
						incDdcService.incDdcYeta2018_YE166010_2018_CREATE_Delete(infcPkgYe166010Vo); 
						dataCheck = "";
						dataCheck = incDdcService.incDdcYeta2018_YE166010_2018_CREATE_Insert(infcPkgYe166010Vo);   //infcPkgYeta3220Vo   
						bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + "신용카드계산 생성.","데이타확인","")); 
						logger.debug("5.신용카드 INSERT 종료 ");
					}
				 	
    	  } 
    	   
    	  
    	  statCnt = 0; 
    	//공통 60/70/80 업데이트 
  		   //보험료 합산금액 넣기   보장성보험 
    	    statCnt =  incDdcService.incDdcYeta2018_A102Y_YE161080_2018_Update(infcPkgYe161080Vo); 
			if (statCnt >= 0) { 
				 statCnt = 0;
				 //가족사항 업데이트 410 고용/건강보험료외 업데이트 종근무지데이타
				statCnt =  incDdcService.incDdcYeta2018_YE161040_2018_INSU_FETC01_Update(infcPkgYe161060Vo); 
				
				if (statCnt >= 0) { 
					
				statCnt = 0;
				 //보험료 종료4대보험 업데이트 
				  statCnt =  incDdcService.incDdcYeta2018_YE161040_2018_INSU_FETC_Update(infcPkgYe161040Vo); 
				  
//		    	  if (statCnt >= 0) { 
		    		  statCnt = 0;
		    		  //합계로직추가 
						  statCnt =  incDdcService.incDdcYeta2018_All_YE161060_2018_Update(infcPkgYe161060Vo); 
						 // if (statCnt >= 0) {
							  statCnt = 0; 
							  statCnt = incDdcService.incDdcYeta2018_All_YE161070_2018_Update(infcPkgYe161070Vo); 
					    	//  if (statCnt >= 0) {
							  
					    		  statCnt = 0; 
								  statCnt =  incDdcService.incDdcYeta2018_All_YE161080_2018_Update(infcPkgYe161080Vo); 
									
					    	 // }
					    	  
						//  }
				      
//		    	  	}
				}  
			}	 
			 
		} catch (Exception ex) {
			ex.printStackTrace();
			ShowMessageBM smBm = new ShowMessageBM();
			smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
			smBm.setMenu("Yeta");
			smBm.setPhase("[연말정산 급여이관]대상자급여이관에러");
			smBm.setMessage(ex.getLocalizedMessage());
			smBm.setContent(ex.getMessage());
			bmResult.add(smBm); 
		}
   
	  	
	  	
        return retval;
		 
  }
    
        
 
}