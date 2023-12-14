package com.app.smrmf.pkg.yeta.yeta2022.tax;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160401VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160402VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYe160403VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe160404_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe160405_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe160406_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe160510_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161040_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161050_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161055_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161060_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161070_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161080_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161090_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162010Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162020Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162030Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162040Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162040_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162510Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162510_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162520Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162520_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe164010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165030Temp_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe169010Srh_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe169010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe169010a_2022_VO;
import com.app.smrmf.pkg.yeta.yeta2022.tax.service.Yeta7300PayrService;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller
public class Yeta7300TaxPkgProc extends AbstractCustomServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(Yeta7300TaxPkgProc.class);

	@Resource(name = "Yeta7300PayrService")
	protected Yeta7300PayrService infcPkgYeta7300;

	public Yeta7300TaxPkgProc() {

	}

	//액계산 클릭 시
	public PagingLoadResult<ShowMessageBM> execfnYeta7300TaxPkgProc(
			HttpServletRequest request,
			List<InfcPkgYe161010_2022_VO> listYe161010VO) throws Exception {

		return funcYeta7300TaxPkgProc(request, listYe161010VO);
	}
    
    /**
     * 
     * <pre>
     * 1. 개요 : 대상자 별 세액 계산   
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : funcYeta0300Payr06430CalcTax
     * @date : Jan 26, 2016
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Jan 26, 2016		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param lstInfcPkgYeta2000Vo
     * @return
     * @throws Exception
     */
    /**
     * @param request
     * @param listYe161010VO
     * @return
     * @throws Exception
     */
    private PagingLoadResult<ShowMessageBM> funcYeta7300TaxPkgProc(HttpServletRequest request,List<InfcPkgYe161010_2022_VO> listYe161010VO)  throws Exception  {
    	
  	    PagingLoadResult<ShowMessageBM> retval = null; 
	    List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        
        // 변수선언 
	  	int statCnt = 0;
	  	String dataCheck = "";
	  	String spciDdctCheck = "FALSE";
	  	
		InfcPkgYe160401VO    		infcPkgYe160401Vo	 = new InfcPkgYe160401VO();	//현근무지급여지급명세
		InfcPkgYe160402VO   		infcPkgYe160402Vo	 = new InfcPkgYe160402VO();	//현근무지비과세_감면소득_과세
		InfcPkgYe160403VO   		infcPkgYe160403Vo	 = new InfcPkgYe160403VO();	//현근무지비과세_감면소득_비과세
		
		InfcPkgYe160404_2022_VO   	infcPkgYe160404Vo	 = new InfcPkgYe160404_2022_VO();	//D_종전근무처
		InfcPkgYe160405_2022_VO    	infcPkgYe160405Vo	 = new InfcPkgYe160405_2022_VO();	//D_종전근무처비과세_감면소득_비과세
		InfcPkgYe160406_2022_VO    	infcPkgYe160406Vo	 = new InfcPkgYe160406_2022_VO();	//종전근무지연금보험료_공적연금
		InfcPkgYe160510_2022_VO    	infcPkgYe160510Vo	 = new InfcPkgYe160510_2022_VO();	//근무지별비과세_감면소득
		
//		InfcPkgYe161005VO    infcPkgYe161005Vo	 = new InfcPkgYe161005VO();	//A_원천세신고기본
		
		InfcPkgYe161010_2022_VO    	infcPkgYe161010Vo	 = new InfcPkgYe161010_2022_VO();	// 연말정산대상자기본
		InfcPkgYe161020_2022_VO   	infcPkgYe161020Vo	 = new InfcPkgYe161020_2022_VO();	//A_인적소득공제기본
		InfcPkgYe161030_2022_VO    	infcPkgYe161030Vo	 = new InfcPkgYe161030_2022_VO();	//E_인적공제명세
		InfcPkgYe161040_2022_VO  	infcPkgYe161040Vo	 = new InfcPkgYe161040_2022_VO();	//E_소득세액공제명세
		InfcPkgYe161050_2022_VO    	infcPkgYe161050Vo	 = new InfcPkgYe161050_2022_VO();	//C_연금보험료공제
		InfcPkgYe161055_2022_VO    	infcPkgYe161055Vo	 = new InfcPkgYe161055_2022_VO();	//C_연금보험료_공적연금상세
		InfcPkgYe161060_2022_VO    	infcPkgYe161060Vo	 = new InfcPkgYe161060_2022_VO();	//C_특별소득공제
		InfcPkgYe161070_2022_VO    	infcPkgYe161070Vo	 = new InfcPkgYe161070_2022_VO();	//C_그밖의소득공제
		InfcPkgYe161080_2022_VO    	infcPkgYe161080Vo	 = new InfcPkgYe161080_2022_VO();	//C_세액감면및공제
		InfcPkgYe161090_2022_VO    	infcPkgYe161090Vo	 = new InfcPkgYe161090_2022_VO();	//C_교육비내역
		
		InfcPkgYe164010_2022_VO    	infcPkgYe164010Vo	 = new InfcPkgYe164010_2022_VO();	//A_의료비지급명세
		InfcPkgYe165010_2022_VO    	infcPkgYe165010Vo	 = new InfcPkgYe165010_2022_VO();	//I_해당연도기부금명세
		InfcPkgYe165020_2022_VO    	infcPkgYe165020Vo	 = new InfcPkgYe165020_2022_VO();	//I_기부자관계코드별기부금합계
		InfcPkgYe165030_2022_VO    	infcPkgYe165030Vo	 = new InfcPkgYe165030_2022_VO();	//H_기부금조정명세
		InfcPkgYe165030Temp_2022_VO infcPkgYe165030TempVo = new InfcPkgYe165030Temp_2022_VO();  	    //H_기부금조정명세_TEMP	 
		InfcPkgYe166010_2022_VO    	infcPkgYe166010Vo	 = new InfcPkgYe166010_2022_VO();	//신용카드등소득공제명세
		InfcPkgYe166020_2022_VO    	infcPkgYe166020Vo	 = new InfcPkgYe166020_2022_VO();	//신용카드등소득공제상세
			 								 
		InfcPkgYe169010_2022_VO    infcPkgYe169010Vo	 = new InfcPkgYe169010_2022_VO();	//C_주현근무처
		
		try { 
	  		   
	  		  infcPkgYeta7300 = (Yeta7300PayrService)BeanFinder.getBean("Yeta7300PayrService"); 
		  	 
	  
	     	
             /************************* 대상자별로 루프 시작 ***************************************************/ 

	  		  for (int iCnt01 = 0;iCnt01 < listYe161010VO.size();iCnt01++) {
		  		    
				  		infcPkgYe161010Vo = new InfcPkgYe161010_2022_VO();
				  		
				  		infcPkgYe161010Vo = listYe161010VO.get(iCnt01);   
				  		
				  		infcPkgYe161010Vo.setDivdPymtAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(infcPkgYe161010Vo.getDivdPymtAmnt(), "0")));
						infcPkgYe161010Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
				     	infcPkgYe161010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
				     	infcPkgYe161010Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
				     	infcPkgYe161010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
				     	
				  		BeanUtils.copyProperties(infcPkgYe160401Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe160402Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe160403Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe160404Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe160405Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe160406Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe160510Vo, infcPkgYe161010Vo);
						
						BeanUtils.copyProperties(infcPkgYe161020Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe161030Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe161040Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe161050Vo, infcPkgYe161010Vo); 
						BeanUtils.copyProperties(infcPkgYe161055Vo, infcPkgYe161010Vo);
						
						BeanUtils.copyProperties(infcPkgYe161060Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe161070Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe161080Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe161090Vo, infcPkgYe161010Vo);
					 
						BeanUtils.copyProperties(infcPkgYe164010Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe165010Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe165020Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe165030Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe165030TempVo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe166010Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe166020Vo, infcPkgYe161010Vo);
						BeanUtils.copyProperties(infcPkgYe169010Vo, infcPkgYe161010Vo); 
				  		
				  		infcPkgYe161010Vo.setSpciDdctCheck("FALSE");
				        
		             /**********************************************************************************************
		              * {의료비/기부금/교육비데이타 자료정리 루틴 추가 }  TODO 삭제  
		              **********************************************************************************************/
				  		 
				  		  statCnt = 0;
				  		    //의료비정리
				  		   infcPkgYeta7300.fnYeta7300_B101Y_YE161080_2022_Update(infcPkgYe161010Vo);
				  		  //주택마련저축정리 
				  		  infcPkgYeta7300.fnYeta7300_TaxPkg01_2022_Update(infcPkgYe161010Vo);  
				  		  //합계처리 
				  		   infcPkgYeta7300.fnYeta7300_All_YE161080_2022_Update(infcPkgYe161010Vo);
				  		
				  	      if (statCnt >= 0) {
						  		// ############## YE161020 부양가족인원수 ##############   
						 		statCnt = 0;
						  		statCnt = infcPkgYeta7300.fnYeta7300_YE161020_Tax_2022_01_Update(infcPkgYe161020Vo);  
						  		if (statCnt >= 0) { 
							  		statCnt = 0;
							  		// ############## YE161055 국민연금등정리 ############## 
							  		statCnt = infcPkgYeta7300.fnYeta7300_YE161055_Tax_2022_02_Update(infcPkgYe161055Vo); 
							  		if (statCnt >= 0) { 
								  		statCnt = 0;
								  		// ############## YE161050 국민연금등합계 ############## 
								  		statCnt = infcPkgYeta7300.fnYeta7300_YE161050_Tax_2022_03_Update(infcPkgYe161050Vo); 
								  		if (statCnt >= 0) { 
										  		statCnt = 0;
										  		/* ############## YE169010 비과세 정리  ##############  */
										  		statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_04_Update(infcPkgYe169010Vo); 
										  		if (statCnt >= 0) { 
										  		    /** 공제단계 시작 01 총급여등기본공제,추가공제등 공제금액인서트 */
											  		statCnt = 0; 
											  		statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_05_Update(infcPkgYe169010Vo);  
											  		if (statCnt >= 0) {   
										                 /**  {공제단계 시작 -소득공제 02} */ 
												  		if (statCnt >= 0) { 
												  		statCnt = 0;
												  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_06_Update(infcPkgYe169010Vo); 	
												  		if (statCnt >= 0) {  
											                 /**  {공제단계 시작 -연금보험료공제 03} */ 
											                 //      ---------------------------연금보험료공제-------------------------------------- 
													  		statCnt = 0;
													  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_07_Update(infcPkgYe169010Vo); 
													  		if (statCnt >= 0) {
												                  /**  {공제단계 시작 -특별공제 - 주택임차차임금 상환액  09 } */ 
												                  //   ------------------특별공제 - 주택임차차임금 상환액--------------------------- 
														  		statCnt = 0;  //TODO YE161060 작업함
														  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_08_Update(infcPkgYe169010Vo); 
														  		if (statCnt >= 0) { 
												                  /**  {공제단계 시작 -특별공제 - 주택마련저축  10 } */ 
															  		statCnt = 0;
															  		statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_09_Update(infcPkgYe169010Vo); 
														  			if (statCnt >= 0) {
													                  /**  {공제단계 시작 -특별공제 - 주택마련저축 합계  10-1 } */ 
																  	
																  		statCnt = 0;
																  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_10_Update(infcPkgYe169010Vo); 
																  		if (statCnt >= 0) {
																  			/**  {공제단계 시작 -특별공제 - 장기주택이자상환액  10-2 } */
																	  		statCnt = 0;
																	  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_11_Update(infcPkgYe169010Vo); 
																	  		if (statCnt >= 0) { 
																                 /**  {공제단계 시작 -특별공제 - 장기주택이자상환액 고정금리 비거치  10-3 } */
																		  		statCnt = 0;
																		  		statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_12_Update(infcPkgYe169010Vo); 
																		  		if (statCnt >= 0) { 
																                  /**  {공제단계 시작 -특별공제 - 장기주택이자상환액 기타 대출  10-4 } */
																			  		statCnt = 0;
																			  		  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_13_Update(infcPkgYe169010Vo); 
																			  		//if (statCnt >= 0) { 
																			  			 /**  {장기주택이자상환액 2015년이후 고정금리이면서 비거치상환 대출 } */ 
																				  		statCnt = 0;
																				  		statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_14_Update(infcPkgYe169010Vo);  
																				  		if (statCnt >= 0) { 
																				  		   /**  기타로직  등 계산 로직 */ 
																					  		statCnt = 0;
																					  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_15_Update(infcPkgYe169010Vo); 
																					  		if (statCnt >= 0) {
																				                /**  투자조합출자등소득공제 2020년  */ 
																						  		 statCnt = 0;
																						  		 statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_16_Update(infcPkgYe161070Vo);
																						  		 if (statCnt >= 0) {
																					                /**  투자조합출자등소득공제 2021년  */ 
																							  		 statCnt = 0;
																							  		 statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_17_Update(infcPkgYe161070Vo); 
																							  		 if (statCnt >= 0) {
																							  			/**  투자조합출자등소득공제 2022년  */ 
																							  			statCnt = 0;
																								  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_18_Update(infcPkgYe161070Vo); 
																								  		if (statCnt >= 0) {	
																							                 /**  신용카드  등 계산 로직  */ 
																								  			//logger.debug("statCnt1 = " + statCnt);
																									  		statCnt = 0;
																									  		
																									  		//2022연말정산_추가
																									  		//총급여7천초과자 도서공연비 유형을 일반유형으로 변경하는 작업
																									  		statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_18_1_Update(infcPkgYe169010Vo);
																									  		//logger.debug("statCnt2 = " + statCnt);
																									  		//if (statCnt >= 0){
																									  			//logger.debug("statCnt3 = " + statCnt);
																									  		statCnt = 0;
																									  		//2022연말정산_추가
																									  		//총급여7천초과자 도서공연비 금액을 일반금액에 더하는 작업
																									  		statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_18_2_Update(infcPkgYe169010Vo);
																									  		//if (statCnt >= 0){
																								  				
																										  		statCnt = 0;
																										  		
																										  	//2022연말정산_추가
																										  	//총급여7천초과자 도서공연비 금액을 0값으로 만드는 작업
																										  	statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_18_3_Update(infcPkgYe169010Vo);
																										  	//if (statCnt >= 0){
																									  				
																											  	statCnt = 0;
																											  	
																											  	
																											//2022연말정산_추가
																											//총급여7천초과자 PDF테이블 변경값 YE161040내 다시 적용작업
																											statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_18_4_Update(infcPkgYe169010Vo);
																											if (statCnt >= 0){
																										  				
																												statCnt = 0;
																												
																												
																											//2022연말정산_추가
																											//총급여7천초과자 PDF테이블 변경값 YE166020내 다시 적용작업
																											statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_18_5_Update(infcPkgYe166020Vo);
																											if (statCnt >= 0){
																											  				
																												statCnt = 0;
																											
																											//2022연말정산_추가
																											//총급여7천초과자 PDF테이블 변경값 YE161040내 다시 적용작업
																											statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_18_6_Update(infcPkgYe169010Vo);
																											if (statCnt >= 0){
																												  				
																												statCnt = 0;
																												
																									  		
																									  		//20200110 신용카드 컬럼 추가 후 재수정작업 필요
																									  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_19_Update(infcPkgYe169010Vo); 
																									  		if (statCnt >= 0) {
																								                 /**  {공제단계 시작 -연금보험료공제 연금보험료공제  대상금액 04}  */																										  		
																										  		statCnt = 0;
																										  		
																										  		//2022연말정산_추가_국민연금 공제액 차감순서 마지막으로 빼기
																										  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_19_S_Update(infcPkgYe169010Vo); 
																										  		if (statCnt >= 0) {
																										  		
																										  			statCnt = 0;
																										  			
																										  			//2022연말정산_추가_국민연금 공제액 구한 뒤 각 국민연금테이블에 공제액update
																										  			statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_19_S_1_Update(infcPkgYe169010Vo);
																												  	if (statCnt >= 0){
																											  				
																													  	statCnt = 0;
																										  		
																										  		
																										  		//2022연말정산_추가
																										  		//연금저축공제대상금액계산쿼리 분리(ISA계산쿼리 간소화때문)
																										  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_19_1_Update(infcPkgYe169010Vo); 
																										  		if (statCnt >= 0) {
																										  		
																										  			statCnt = 0;
																										  			
																										  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_20_Update(infcPkgYe169010Vo); 
																										  		if (statCnt >= 0) {
																								                   /**  {공제단계 시작 -연금보험료공제 03_1 대상금액 구하는 로직 추가  05}*/
																									                 // ---------------------------연금보험료공제-------------------------------------- 
																											  		statCnt = 0;
																											  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_21_Update(infcPkgYe169010Vo); 
																											  		if (statCnt >= 0) { 
																										                 /**  {공제단계 시작 -특별공제 - 보장성/장애인  보험료  06} */
																												  		statCnt = 0;
																												  		statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_22_Update(infcPkgYe169010Vo); 
																												  		if (statCnt >= 0) {
																											                 /**  특별공제 - 보험료 */
																													  		statCnt = 0;
																													  		statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_23_Update(infcPkgYe169010Vo); 
																													  		if (statCnt >= 0) {
																												                 /**  {공제단계 시작 -특별공제 - 의료비 대상금액  07 - 1} */
																													  			//20200110 의료비 수정
																														  		statCnt = 0;
																														  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_24_Update(infcPkgYe169010Vo); 
																														  		if (statCnt >= 0) { 
																												                  /**  {공제단계 시작 -특별공제 - 의료비   07 -2 } */
//																													               -----------------------특별공제 - 의료비 ------------------
																															  		statCnt = 0;
																															  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_25_Update(infcPkgYe161080Vo); 
																															  		if (statCnt >= 0) {
																															  			statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_25_01_Update(infcPkgYe161080Vo); 
																														                 /** {공제단계 시작 -특별공제 - 교육비   08 -1 }  */   
																													                  //    ----------------------특별공제 - 교육비 ---------------------
																															  		          //TODO YE161080 에작업함 
																																	  		statCnt = 0;
																																	  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_26_Update(infcPkgYe161080Vo); 
																																	  		if (statCnt >= 0) { 
																																                 /**  {공제단계 시작 -특별공제 - 교육비 공제  08 -2 }  */
																																		  		statCnt = 0;
																																		  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_27_Update(infcPkgYe161080Vo);
																																		  		if (statCnt >= 0) { 
																																			        /** {공제단계 시작 -특별공제 - 기부금관계코드 오류 정정  11 }  */
																																	                 //   -------------------------기부금관계코드 오류 정정  ------------------------------
//																																			  		statCnt = 0;
//																																			  		statCnt =  infcPkgYeta7300.fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(infcPkgYe161010Vo); 
//																																			  		if (statCnt >= 0) {}
																																                  /**  {공제단계 시작 -특별공제 - 기부금공제   12   }  */
																																	                 //   -------------------------기부금공제 1 -이전월 포함.------------------------------
																																			  		// 귀속년도 정치기부금 공제대상
																																			  		statCnt = 0;
																																			  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_29_Update(infcPkgYe169010Vo); 
																																			  		if (statCnt >= 0) {  
																																		                 /**  기부금공제 1 -귀속년도 법정기부금 */
																																			  			// 귀속년도 정치기부금 (실질적인 공제금액), 년도별 법정기부금, 종교외, 종교 공제대상금액만
																																				  		statCnt = 0;
																																				  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_30_Update(infcPkgYe169010Vo); 
																																				  		if (statCnt >= 0) { 
																																		                   /**  기부금공제 1 -귀속년도 법정기부금. */
																																					  		//여기부터 년도별 법정기부금 공제금액계산
																																				  			//31은 15,16
																																				  			//31_01은 17,18,19 공제금액 확정
																																					  		statCnt = 0;
																																					  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_31_Update(infcPkgYe169010Vo);
																																					  		if (statCnt >= 0) {
																																					  			statCnt = 0;
																																						  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_31_01_Update(infcPkgYe169010Vo);
																																						  		if (statCnt >= 0) {

																																							     /**   현재년도 우리사주조합 대상금액 구하기  */
																																								statCnt = 0;
																																								
																																								//2022년연말정산_추가
																																								statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_31_02_Update(infcPkgYe169010Vo);
																																						  		if (statCnt >= 0) {

																																							     /**   현재년도 우리사주조합 대상금액 구하기  */
																																								statCnt = 0;
																																								
																																								statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_32_Update(infcPkgYe169010Vo); 
																																								if (statCnt >= 0) {
																																							      /**  기부금공제 2013년도 이전 종교단체/외 이월 기부금  */
																																									statCnt = 0;   //이월분 종교외공제금액작업(13년도)
																																									statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_33_Update(infcPkgYe161060Vo); 		
																																									if (statCnt > 0) {
																																										statCnt = 0;   //이월분 종교단체공제금액작업(13년도)
																																										statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_33_02_Update(infcPkgYe161060Vo); 		
																																										if (statCnt > 0) {	
																																											statCnt = 0;   //TODO YE161060 작업함 
																																											statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_33_03_Update(infcPkgYe169010Vo); 		
																																											if (statCnt > 0) {	
																																												statCnt = 0;   //TODO 종교외/종교기부금 공제한도금액 구하기(13년도)
																																												statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_33_04_Update(infcPkgYe169010Vo); 		
																																												if (statCnt >= 0) {		
																																													/**  기부금공제 특례기부금공제,당해년도 종교단체기부금 대상금액 */
																																													/* 20200109 시작 */
																																													statCnt = 0;
																																													// 종교외기부금 15,16,17
																																													statCnt =  infcPkgYeta7300.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update(infcPkgYe169010Vo);
																																											 		if (statCnt > 0) {
																																											 			statCnt = 0;
																																											 			// 종교외기부금 18,19,20,21
																																											 			statCnt =  infcPkgYeta7300.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update(infcPkgYe169010Vo); 
																																												 		if (statCnt >= 0) {
																																												          /**  기부금공제  2014 년도 종교단체기부금 대상금액 */
																																												 			//종교기부금 15,16,17
																																													  		statCnt = 0;
																																													  		
																																													  		//2022연말정산_추가
																																													  		statCnt =  infcPkgYeta7300.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_023_Update(infcPkgYe169010Vo); 
																																													 		if (statCnt >= 0) {
																																													 			
																																														  		statCnt = 0;
																																													  		
																																													  		statCnt =  infcPkgYeta7300.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update(infcPkgYe169010Vo);
																																													  		if (statCnt >= 0) {
																																													  			//종교기부금 18,19,20,21
																																													  			statCnt = 0;
																																													  			statCnt =  infcPkgYeta7300.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update(infcPkgYe169010Vo); 
																																													  			
																																													  			//2022연말정산_추가
																																													  			if (statCnt >= 0) {
																																													  				
																																														  			statCnt = 0;
																																														  			statCnt =  infcPkgYeta7300.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_033_Update(infcPkgYe169010Vo);
																																													  		if (statCnt >= 0) {
																																												              /**  기부금공제 3 불러와서 년도별 수정하는걸로 변경함 */ 
																																													  			// 20200109 오후 시작
																																													  	         List listYetaGibu = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_TgYear_Select(infcPkgYe169010Vo); 
																																													             
																																													             if  (listYetaGibu.size() > 0) {
																																													            	   
																																													            	    Iterator<Map<String, Object>> iter = listYetaGibu.iterator(); 
																																														        	   
																																															            while ( iter.hasNext() ) { 
																																															            	
																																															               Map<String, Object> mapYetaGibu = (Map<String, Object>) iter.next(); 
																																															               
																																															               BigDecimal bgSPCI_FB16_10    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FB17_10    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FB18_10    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FB19_10    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FB20_10    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FB21_10    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FB22_10    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FBTG16_10  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FBTG17_10  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FBTG18_10  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FBTG19_10  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FBTG20_10  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FBTG21_10  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FBTG22_10  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FBSE16_10  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FBSE17_10  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FBSE18_10  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FBSE19_10  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FBSE20_10  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FBSE21_10  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_FBSE22_10  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NA16_40    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NA17_40    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NA18_40    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NA19_40    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NA20_40    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NA21_40    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NA22_40    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NATG16_40  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NATG17_40  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NATG18_40  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NATG19_40  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NATG20_40  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NATG21_40  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NATG22_40  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NASE16_40  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NASE17_40  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NASE18_40  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NASE19_40  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NASE20_40  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NASE21_40  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_NASE22_40  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YA16_41    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YA17_41    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YA18_41    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YA19_41    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YA20_41    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YA21_41    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YA22_41    = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YATG16_41  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YATG17_41  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YATG18_41  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YATG19_41  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YATG20_41  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YATG21_41  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YATG22_41  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YASE16_41  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YASE17_41  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YASE18_41  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YASE19_41  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YASE20_41  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YASE21_41  = BigDecimal.ZERO;
																																															               BigDecimal bgSPCI_YASE22_41  = BigDecimal.ZERO;
																																															               
																																															               BigDecimal bgYETA_C141  = BigDecimal.ZERO;
																																															               BigDecimal bgYETA_C143  = BigDecimal.ZERO;
																																															               BigDecimal bgYETA_C147  = BigDecimal.ZERO;
																																															               
																																															               BigDecimal bgYETA_C148  = BigDecimal.ZERO;
																																															               
																																															               BigDecimal bgYETA_C146  = BigDecimal.ZERO;
																																															               BigDecimal bgYETA_C150  = BigDecimal.ZERO;
																																															               BigDecimal bgYETA_C150B = BigDecimal.ZERO;
																																															               
																																															               BigDecimal bgYETA_C145  = BigDecimal.ZERO;
																																															               BigDecimal bgYETA_C149  = BigDecimal.ZERO;
																																															               BigDecimal bgYETA_C150A = BigDecimal.ZERO;
																																															                
																																															                
																																															               // 기부금 누적   
																																															               BigDecimal bgYetaSumAll = BigDecimal.ZERO;
																																															               BigDecimal bgYetaAllSumSe = BigDecimal.ZERO;  //세액합계금액 
																																															               
																																															               bgSPCI_FB16_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb1610"),"0"));
																																															               bgSPCI_FB17_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb1710"),"0"));
																																															               bgSPCI_FB18_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb1810"),"0"));
																																															               bgSPCI_FB19_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb1910"),"0"));
																																															               bgSPCI_FB20_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb2010"),"0"));
																																															               bgSPCI_FB21_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb2110"),"0"));
																																															               bgSPCI_FB22_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb2210"),"0"));
																																															               bgSPCI_FBTG16_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg1610"),"0"));
																																															               bgSPCI_FBTG17_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg1710"),"0"));
																																															               bgSPCI_FBTG18_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg1810"),"0"));
																																															               bgSPCI_FBTG19_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg1910"),"0"));
																																															               bgSPCI_FBTG20_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg2010"),"0"));
																																															               bgSPCI_FBTG21_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg2110"),"0"));
																																															               bgSPCI_FBTG22_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg2210"),"0"));
																																															               bgSPCI_FBSE16_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse1610"),"0"));
																																															               bgSPCI_FBSE17_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse1710"),"0"));
																																															               bgSPCI_FBSE18_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse1810"),"0"));
																																															               bgSPCI_FBSE19_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse1910"),"0"));
																																															               bgSPCI_FBSE20_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse2010"),"0"));
																																															               bgSPCI_FBSE21_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse2110"),"0"));
																																															               bgSPCI_FBSE22_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse2210"),"0"));
																																															               bgSPCI_NA16_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1640"),"0"));
																																															               bgSPCI_NA17_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1740"),"0"));
																																															               bgSPCI_NA18_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1840"),"0"));
																																															               bgSPCI_NA19_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1940"),"0"));
																																															               bgSPCI_NA20_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa2040"),"0"));
																																															               bgSPCI_NA21_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa2140"),"0"));
																																															               bgSPCI_NA22_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa2240"),"0"));
																																															               bgSPCI_NATG16_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg1640"),"0"));
																																															               bgSPCI_NATG17_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg1740"),"0"));
																																															               bgSPCI_NATG18_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg1840"),"0"));
																																															               bgSPCI_NATG19_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg1940"),"0"));
																																															               bgSPCI_NATG20_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg2040"),"0"));
																																															               bgSPCI_NATG21_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg2140"),"0"));
																																															               bgSPCI_NATG22_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg2240"),"0"));
																																															               bgSPCI_NASE16_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase1640"),"0"));
																																															               bgSPCI_NASE17_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase1740"),"0"));
																																															               bgSPCI_NASE18_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase1840"),"0"));
																																															               bgSPCI_NASE19_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase1940"),"0"));
																																															               bgSPCI_NASE20_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase2040"),"0"));
																																															               bgSPCI_NASE21_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase2140"),"0"));
																																															               bgSPCI_NASE22_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase2240"),"0"));
																																															               bgSPCI_YA16_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1641"),"0"));
																																															               bgSPCI_YA17_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1741"),"0"));
																																															               bgSPCI_YA18_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1841"),"0"));
																																															               bgSPCI_YA19_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1941"),"0"));
																																															               bgSPCI_YA20_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa2041"),"0"));
																																															               bgSPCI_YA21_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa2141"),"0"));
																																															               bgSPCI_YA22_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa2241"),"0"));
																																															               bgSPCI_YATG16_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg1641"),"0"));
																																															               bgSPCI_YATG17_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg1741"),"0"));
																																															               bgSPCI_YATG18_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg1841"),"0"));
																																															               bgSPCI_YATG19_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg1941"),"0"));
																																															               bgSPCI_YATG20_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg2041"),"0"));
																																															               bgSPCI_YATG21_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg2141"),"0"));
																																															               bgSPCI_YATG22_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg2241"),"0"));
																																															               bgSPCI_YASE16_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase1641"),"0"));
																																															               bgSPCI_YASE17_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase1741"),"0"));
																																															               bgSPCI_YASE18_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase1841"),"0"));
																																															               bgSPCI_YASE19_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase1941"),"0"));
																																															               bgSPCI_YASE20_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase2041"),"0"));
																																															               bgSPCI_YASE21_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase2141"),"0"));
																																															               bgSPCI_YASE22_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase2241"),"0"));
																																															               
																																															               bgYETA_C141=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC141"),"0"));
																																															               bgYETA_C143=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC143"),"0"));
																																															               bgYETA_C147=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC147"),"0"));
																																															               
																																															               BigDecimal bgYETA_C142=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC142"),"0"));
																																															               BigDecimal bgYETA_C144=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC144"),"0"));
																																															           	       
																																															               InfcPkgYe169010_2022_VO     inputYe169010Vo = new InfcPkgYe169010_2022_VO();	//C_주현근무처 
																																												 	 		 			//  	InfcPkgYe161060VO    inputYe161060Vo	 = new InfcPkgYe161060VO();	//C_특별소득공제
																																												 						//	InfcPkgYe161070VO    inputYe161070Vo	 = new InfcPkgYe161070VO();	//C_그밖의소득공제
																																															               InfcPkgYe161080_2022_VO    inputYe161080Vo	 = new InfcPkgYe161080_2022_VO();	//C_세액감면및공제
																																												 						//	BeanUtils.copyProperties(inputYe161060Vo, infcPkgYe161010Vo);
																																												 						//	BeanUtils.copyProperties(inputYe161070Vo, infcPkgYe161010Vo);
																																															               BeanUtils.copyProperties(inputYe161080Vo, infcPkgYe161010Vo);
																																															               BeanUtils.copyProperties(inputYe169010Vo, infcPkgYe161010Vo); 	
																																													 	 							
																																													 	 					
																																															               
																																															               		               
																																															               	bgYetaSumAll = bgYETA_C141.add(bgYETA_C143); //정치자금 기부금  합산
																																															               	bgYetaAllSumSe = bgYETA_C142.add(bgYETA_C144); //정치자금 기부금  합산
																																															               	
																																															               
																																															               /*기부금공제순서변경에 따른 수정 시작*/
																																															               //법정기부금 2016
																																															               if (bgSPCI_FBTG16_10.compareTo(BigDecimal.ZERO) > 0) {
																																																            	 bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10);
																																																	            if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																                	bgSPCI_FBSE16_10 = bgSPCI_FBTG16_10.multiply(new BigDecimal("0.20"));
																																																                	
																																																                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																                	
																																																                	bgSPCI_FBSE16_10 = bgSPCI_FBTG16_10.multiply(new BigDecimal("0.35"));
																																																                }
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE16_10);
																																																                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG16_10);
																																																                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE16_10);
																																															               }
																																															               //법정기부금 2017
																																															               if (bgSPCI_FBTG17_10.compareTo(BigDecimal.ZERO) > 0) {
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10);
																																																	           if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																	        	   bgSPCI_FBSE17_10 = bgSPCI_FBTG17_10.multiply(new BigDecimal("0.20"));
																																																               } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																            	   bgSPCI_FBSE17_10 = bgSPCI_FBTG17_10.multiply(new BigDecimal("0.35"));
																																																               } 
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE17_10);
																																																                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG17_10);
																																																                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE17_10);
																																															               } 
																																															               //법정기부금 2018
																																															               if (bgSPCI_FBTG18_10.compareTo(BigDecimal.ZERO) > 0) {
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG18_10);
																																																	           if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																	        	   bgSPCI_FBSE18_10 = bgSPCI_FBTG18_10.multiply(new BigDecimal("0.20"));
																																																               } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																            	   bgSPCI_FBSE18_10 = bgSPCI_FBTG18_10.multiply(new BigDecimal("0.35"));
																																																               }
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE18_10);
																																																                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG18_10);
																																																                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE18_10);
																																															               	} 
																																															               //법정기부금 2019 추가
																																															               if (bgSPCI_FBTG19_10.compareTo(BigDecimal.ZERO) > 0) {
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG19_10);
																																																	           if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																	        	   bgSPCI_FBSE19_10 = bgSPCI_FBTG19_10.multiply(new BigDecimal("0.20"));
																																																               } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																            	   bgSPCI_FBSE19_10 = bgSPCI_FBTG19_10.multiply(new BigDecimal("0.35"));
																																																               }
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE19_10);
																																																                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG19_10);
																																																                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE19_10);
																																															               	}
																																															               
																																															             //법정기부금 2020 추가
																																															               if (bgSPCI_FBTG20_10.compareTo(BigDecimal.ZERO) > 0) {
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG20_10);
																																																	           if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																	        	   bgSPCI_FBSE20_10 = bgSPCI_FBTG20_10.multiply(new BigDecimal("0.20"));
																																																               } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																            	   bgSPCI_FBSE20_10 = bgSPCI_FBTG20_10.multiply(new BigDecimal("0.35"));
																																																               }
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE20_10);
																																																                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG20_10);
																																																                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE20_10);
																																															               	}
																																															               
																																															             //법정기부금 2021 추가
																																															               if (bgSPCI_FBTG21_10.compareTo(BigDecimal.ZERO) > 0) {
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG21_10);
																																																	           if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																	        	   bgSPCI_FBSE21_10 = bgSPCI_FBTG21_10.multiply(new BigDecimal("0.20"));
																																																	        	   
																																																	        	   /*bgSPCI_FBSE21_10 = bgSPCI_FBTG21_10.multiply(new BigDecimal("0.15"));
																																																	        	   BigDecimal bgSPCI_FBSE21_10_f = bgSPCI_FBSE21_10;
																																																	        	   bgSPCI_FBSE21_10 = bgSPCI_FBSE21_10_f.setScale(0, RoundingMode.FLOOR);
																																																	        	   logger.debug("bgSPCI_FBSE21_10 결과4= " + bgSPCI_FBSE21_10_f.setScale(0, RoundingMode.FLOOR));*/
																																																	        	   
																																																               } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																            	   bgSPCI_FBSE21_10 = bgSPCI_FBTG21_10.multiply(new BigDecimal("0.35"));
																																																               }
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE21_10);
																																																                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG21_10);
																																																                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE21_10);
																																															               	}
																																															               
																																															               //2022연말정산_추가
																																															             //법정기부금 2022 추가
																																															               if (bgSPCI_FBTG22_10.compareTo(BigDecimal.ZERO) > 0) {
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG22_10);
																																																	           if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																	        	   bgSPCI_FBSE22_10 = bgSPCI_FBTG22_10.multiply(new BigDecimal("0.20"));
																																																	        	   
																																																               } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																            	   bgSPCI_FBSE22_10 = bgSPCI_FBTG22_10.multiply(new BigDecimal("0.35"));
																																																               }
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE22_10);
																																																                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG22_10);
																																																                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE22_10);
																																															               	}
																																															               
																																															               //우리사주조합기부금
																																															               if (bgYETA_C147.compareTo(BigDecimal.ZERO) > 0) {
																																																            	
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgYETA_C147);
																																																	             
																																																                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																                	
																																																                	bgYETA_C148 = bgYETA_C147.multiply(new BigDecimal("0.20"));
																																																                	
																																																                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																                	
																																																                	bgYETA_C148 = bgYETA_C147.multiply(new BigDecimal("0.35"));
																																																                }
																																																                
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgYETA_C148);
																																															               }
																																															               //종교외기부금 시작
																																																           //종교단체외 2016
																																															               if (bgSPCI_NATG16_40.compareTo(BigDecimal.ZERO) > 0) {
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
																																																	           if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																	        	   bgSPCI_NASE16_40 = bgSPCI_NATG16_40.multiply(new BigDecimal("0.20"));
																																																               } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																            	   bgSPCI_NASE16_40 = bgSPCI_NATG16_40.multiply(new BigDecimal("0.35"));
																																																               }
																																																	           bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE16_40);
																																																               bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG16_40);
																																																               bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE16_40);
																																															               }
																																															               
																																																           //종교단체외 2017
																																															               if (bgSPCI_NATG17_40.compareTo(BigDecimal.ZERO) > 0) {
																																																            	
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
																																																	           if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																	        	   bgSPCI_NASE17_40 = bgSPCI_NATG17_40.multiply(new BigDecimal("0.20"));
																																																               } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																            	   bgSPCI_NASE17_40 = bgSPCI_NATG17_40.multiply(new BigDecimal("0.35"));
																																																               } 
																																																               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE17_40);
																																																               bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG17_40);
																																																               bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE17_40);
																																																           } 
																																															               //종교단체외 2018
																																															               if (bgSPCI_NATG18_40.compareTo(BigDecimal.ZERO) > 0) {
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG18_40);
																																																	           if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																	        	   bgSPCI_NASE18_40 = bgSPCI_NATG18_40.multiply(new BigDecimal("0.20"));
																																																                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																                	bgSPCI_NASE18_40 = bgSPCI_NATG18_40.multiply(new BigDecimal("0.35"));
																																																                }
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE18_40);
																																																                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG18_40);
																																																                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE18_40);
																																															               }
																																															               //종교단체외 2019
																																															               if (bgSPCI_NATG19_40.compareTo(BigDecimal.ZERO) > 0) {
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG19_40);
																																																	           if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																	        	   bgSPCI_NASE19_40 = bgSPCI_NATG19_40.multiply(new BigDecimal("0.20"));
																																																                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																                	bgSPCI_NASE19_40 = bgSPCI_NATG19_40.multiply(new BigDecimal("0.35"));
																																																                }
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE19_40);
																																																                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG19_40);
																																																                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE19_40);
																																															               }
																																															               
																																															             //종교단체외 2020
																																															               if (bgSPCI_NATG20_40.compareTo(BigDecimal.ZERO) > 0) {
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG20_40);
																																																	           if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																	        	   bgSPCI_NASE20_40 = bgSPCI_NATG20_40.multiply(new BigDecimal("0.20"));
																																																                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																                	bgSPCI_NASE20_40 = bgSPCI_NATG20_40.multiply(new BigDecimal("0.35"));
																																																                }
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE20_40);
																																																                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG20_40);
																																																                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE20_40);
																																															               }
																																															               
																																															             //종교단체외 2021
																																															               if (bgSPCI_NATG21_40.compareTo(BigDecimal.ZERO) > 0) {
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG21_40);
																																																	           if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																	        	   bgSPCI_NASE21_40 = bgSPCI_NATG21_40.multiply(new BigDecimal("0.20"));
																																																                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																                	bgSPCI_NASE21_40 = bgSPCI_NATG21_40.multiply(new BigDecimal("0.35"));
																																																                }
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE21_40);
																																																                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG21_40);
																																																                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE21_40);
																																															               }
																																															               
																																															               
																																															               //2022연말정산_추가
																																															             //종교단체외 2022
																																															               if (bgSPCI_NATG22_40.compareTo(BigDecimal.ZERO) > 0) {
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG22_40);
																																																	           if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																	        	   bgSPCI_NASE22_40 = bgSPCI_NATG22_40.multiply(new BigDecimal("0.20"));
																																																                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																                	bgSPCI_NASE22_40 = bgSPCI_NATG22_40.multiply(new BigDecimal("0.35"));
																																																                }
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE22_40);
																																																                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG22_40);
																																																                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE22_40);
																																															               }
																																															               
																																															               // 종교단체 시작
																																															               //종교단체 2016
																																															               if (bgSPCI_YATG16_41.compareTo(BigDecimal.ZERO) > 0) {
																																																            	
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG16_41);
																																																	             
																																																                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																                	
																																																                	bgSPCI_YASE16_41 = bgSPCI_YATG16_41.multiply(new BigDecimal("0.20"));
																																																                	
																																																                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																                	
																																																                	bgSPCI_YASE16_41 = bgSPCI_YATG16_41.multiply(new BigDecimal("0.35"));
																																																                }
																																																                
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE16_41);
																																																                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG16_41);
																																																                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE16_41);
																																															               }  
																																															               //종교단체 2017
																																															               if (bgSPCI_YATG17_41.compareTo(BigDecimal.ZERO) > 0) {
																																																            	
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41);
																																																	             
																																																                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																                	
																																																                	bgSPCI_YASE17_41 = bgSPCI_YATG17_41.multiply(new BigDecimal("0.20"));
																																																                	
																																																                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																                	
																																																                	bgSPCI_YASE17_41 = bgSPCI_YATG17_41.multiply(new BigDecimal("0.35"));
																																																                }
																																																                
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE17_41);
																																																                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG17_41);
																																																                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE17_41);
																																															               }
																																															               //종교단체 2018
																																															               if (bgSPCI_YATG18_41.compareTo(BigDecimal.ZERO) > 0) {
																																																            	
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG18_41);
																																																	             
																																																                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																                	
																																																                	bgSPCI_YASE18_41 = bgSPCI_YATG18_41.multiply(new BigDecimal("0.20"));
																																																                	
																																																                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																                	
																																																                	bgSPCI_YASE18_41 = bgSPCI_YATG18_41.multiply(new BigDecimal("0.35"));
																																																                }
																																																                
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG18_41);
																																																                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG18_41);
																																																                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE18_41);
																																															               } 
																																															               //종교단체 2019
																																															               if (bgSPCI_YATG19_41.compareTo(BigDecimal.ZERO) > 0) {
																																																            	
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG19_41);
																																																	             
																																																                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																                	
																																																                	bgSPCI_YASE19_41 = bgSPCI_YATG19_41.multiply(new BigDecimal("0.20"));
																																																                	
																																																                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																                	
																																																                	bgSPCI_YASE19_41 = bgSPCI_YATG19_41.multiply(new BigDecimal("0.35"));
																																																                }
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG19_41);
																																																                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG19_41);
																																																                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE19_41);
																																															               }
																																															               
																																															             //종교단체 2020
																																															               if (bgSPCI_YATG20_41.compareTo(BigDecimal.ZERO) > 0) {
																																																            	
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG20_41);
																																																	             
																																																                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																                	
																																																                	bgSPCI_YASE20_41 = bgSPCI_YATG20_41.multiply(new BigDecimal("0.20"));
																																																                	
																																																                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																                	
																																																                	bgSPCI_YASE20_41 = bgSPCI_YATG20_41.multiply(new BigDecimal("0.35"));
																																																                }
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG20_41);
																																																                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG20_41);
																																																                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE20_41);
																																															               }
																																															               
																																															             //종교단체 2021
																																															               if (bgSPCI_YATG21_41.compareTo(BigDecimal.ZERO) > 0) {
																																																            	
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG21_41);
																																																	             
																																																                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																                	
																																																                	bgSPCI_YASE21_41 = bgSPCI_YATG21_41.multiply(new BigDecimal("0.20"));
																																																                	
																																																                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																                	
																																																                	bgSPCI_YASE21_41 = bgSPCI_YATG21_41.multiply(new BigDecimal("0.35"));
																																																                }
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG21_41);
																																																                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG21_41);
																																																                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE21_41);
																																															               }
																																															               
																																															               //2022연말정산_추가
																																															             //종교단체 2022
																																															               if (bgSPCI_YATG22_41.compareTo(BigDecimal.ZERO) > 0) {
																																																            	
																																															            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG22_41);
																																																	             
																																																                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
																																																                	
																																																                	bgSPCI_YASE22_41 = bgSPCI_YATG22_41.multiply(new BigDecimal("0.20"));
																																																                	
																																																                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
																																																                	
																																																                	bgSPCI_YASE22_41 = bgSPCI_YATG22_41.multiply(new BigDecimal("0.35"));
																																																                }
																																																                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG22_41);
																																																                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG22_41);
																																																                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE22_41);
																																															               }
																																															               
																																															               inputYe161080Vo.setConbLglDdcTrgtAmt(bgYETA_C145);    /** column 기부금_법정기부금공제대상금액 : conbLglDdcTrgtAmt */
																																															               inputYe161080Vo.setConbLglDdcAmt(bgYETA_C146);    /** column 기부금_법정기부금공제세액 : conbLglDdcAmt */
																																															               inputYe161080Vo.setConbEmstAsctDdcTrgtAmt(bgYETA_C147);    /** column 기부금_우리사주조합기부금공제대상금액 : conbEmstAsctDdcTrgtAmt */
																																															               inputYe161080Vo.setConbEmstAsctDdcAmt(bgYETA_C148);    /** column 기부금_우리사주조합기부금공제세액 : conbEmstAsctDdcAmt */
																																															               inputYe161080Vo.setConbReliOrgOthDdcTrgtAmt(bgYETA_C149);    /** column 기부금_지정기부금종교단체외공제대상금액 : conbReliOrgOthDdcTrgtAmt */
																																															               inputYe161080Vo.setConbReliOrgOthDdcAmt(bgYETA_C150);    /** column 기부금_지정기부금종교단체외공제세액 : conbReliOrgOthDdcAmt */
																																															               inputYe161080Vo.setConbReliOrgDdcTrgtAmt(bgYETA_C150A);    /** column 기부금_지정기부금종교단체공제대상금액 : conbReliOrgDdcTrgtAmt */
																																															               inputYe161080Vo.setConbReliOrgDdcAmt(bgYETA_C150B);    /** column 기부금_지정기부금종교단체공제세액 : conbReliOrgDdcAmt */
																																															               inputYe161080Vo.setConbDdcTrgtAmtSum(bgYetaSumAll);    /** column 기부금공제대상금액합계 : conbDdcTrgtAmtSum */ 
																																															               inputYe161080Vo.setConbDdcAmtSum(bgYetaAllSumSe);    /** column 기부금공제세액합계 : conbDdcAmtSum */
																																															               
																																															               inputYe169010Vo.setYetaC145(bgYETA_C145);    /** column C145_세액공제_특별세액공제_법정기부금공제대상금액 : yetaC145 */
																																															               inputYe169010Vo.setYetaC146(bgYETA_C146);    /** column C146_세액공제_특별세액공제_법정기부금세액공제금액 : yetaC146 */
																																															               inputYe169010Vo.setYetaC147(bgYETA_C147);    /** column C147_세액공제_특별세액공제_우리사주조합기부금공제대상금액 : yetaC147 */
																																															               inputYe169010Vo.setYetaC148(bgYETA_C148);    /** column C148_세액공제_특별세액공제_우리사주조합기부금세액공제금액 : yetaC148 */
																																															               inputYe169010Vo.setYetaC149(bgYETA_C149);    /** column C149_세액공제_특별세액공제_지정기부금_종교단체외공제대상금액 : yetaC149 */
																																															               inputYe169010Vo.setYetaC150(bgYETA_C150);    /** column C150_세액공제_특별세액공제_지정기부금_종교단체외세액공제금액 : yetaC150 */
																																															               inputYe169010Vo.setYetaC150a(bgYETA_C150A);    /** column C150A_세액공제_특별세액공제_지정기부금_종교단체공제대상금액 : yetaC150a */
																																															               inputYe169010Vo.setYetaC150b(bgYETA_C150B);    /** column C150B_세액공제_특별세액공제_지정기부금_종교단체세액공제금액 : yetaC150b */ 
																																															               
																																															               inputYe169010Vo.setSpciFbse16(bgSPCI_FBSE16_10);    /** column null : spciFbse16 */
																																															               inputYe169010Vo.setSpciFbse17(bgSPCI_FBSE17_10);    /** column null : spciFbse17 */
																																															               inputYe169010Vo.setSpciFbse18(bgSPCI_FBSE18_10);    /** column null : spciFbse18 */
																																															               inputYe169010Vo.setSpciFbse19(bgSPCI_FBSE19_10);    /** column null : spciFbse19 */
																																															               inputYe169010Vo.setSpciFbse20(bgSPCI_FBSE20_10);    /** column null : spciFbse20 */
																																															               inputYe169010Vo.setSpciFbse21(bgSPCI_FBSE21_10);    /** column null : spciFbse21 */
																																															               inputYe169010Vo.setSpciFbse22(bgSPCI_FBSE22_10);    /** column null : spciFbse22 */
																																																			
																																															               inputYe169010Vo.setSpciNase16(bgSPCI_NASE16_40);    /** column null : spciNase16 */
																																															               inputYe169010Vo.setSpciNase17(bgSPCI_NASE17_40);    /** column null : spciNase17 */
																																															               inputYe169010Vo.setSpciNase18(bgSPCI_NASE18_40);    /** column null : spciNase18 */
																																															               inputYe169010Vo.setSpciNase19(bgSPCI_NASE19_40);    /** column null : spciNase19 */
																																															               inputYe169010Vo.setSpciNase20(bgSPCI_NASE20_40);    /** column null : spciNase20 */
																																															               inputYe169010Vo.setSpciNase21(bgSPCI_NASE21_40);    /** column null : spciNase21 */
																																															               inputYe169010Vo.setSpciNase22(bgSPCI_NASE22_40);    /** column null : spciNase22 */
																																																		
																																															               inputYe169010Vo.setSpciYase16(bgSPCI_YASE16_41);    /** column null : spciYase16 */
																																															               inputYe169010Vo.setSpciYase17(bgSPCI_YASE17_41);    /** column null : spciYase17 */
																																															               inputYe169010Vo.setSpciYase18(bgSPCI_YASE18_41);    /** column null : spciYase18 */
																																															               inputYe169010Vo.setSpciYase19(bgSPCI_YASE19_41);    /** column null : spciYase19 */
																																															               inputYe169010Vo.setSpciYase20(bgSPCI_YASE20_41);    /** column null : spciYase20 */
																																															               inputYe169010Vo.setSpciYase21(bgSPCI_YASE21_41);    /** column null : spciYase21 */
																																															               inputYe169010Vo.setSpciYase22(bgSPCI_YASE22_41);    /** column null : spciYase22 */
																																																			   
																																															               statCnt = 0;
																																															               statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_TgIn01_Update(inputYe161080Vo) ;
																																															               if (statCnt >= 0) {
																																															            	   statCnt = 0;
																																															            	   statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_TgIn02_Update(inputYe169010Vo) ;
																																															            	   }
																																															               }
																																															            }
																																													             /**  공제단계 시작 - 이전 이월정산정리 작업 443 -> 442로이관    -- 14 */
																																														  		   
																																														  			dataCheck = "";
																																														  		 	dataCheck =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_40_Update(infcPkgYe165030Vo);   
																																														  			if (statCnt >= 0) {   
																																													                   //  {공제단계 시작 - 기부금 내역 정보 정산.     15 - 1 } 전단계에서 자동으로 처리함 제외 
																																													                     /**  공제단계 시작 - 기부금 내역 정보 정산.     15 - 1 */ 
																																												//			  		dataCheck = "";
																																												//		  			dataCheck =   infcPkgYeta7300.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(infcPkgYe161010Vo); 
																																												//		  			if (MSFSharedUtils.paramNull(dataCheck)) {  
																																												//		  				
																																												//		  			}
																																														  				 /**  기부금 정리 이월분 정리 작업 시작   */ 	
																																														  				statCnt = 0;  
																																														  				Yeta7300Tax2022ContributionCalcPkgProc tax2022ContributionCalcPkgProc = new Yeta7300Tax2022ContributionCalcPkgProc();
																																														  				bmResult.addAll(tax2022ContributionCalcPkgProc.execTax_2022_Contribution_Calc(request,infcPkgYe161010Vo)); 
																																														  		  		if (bmResult.size() >= 0) {
																																														  				//if (0 >= 0) {
																																														  		  		//여기까지 	
																																												/******************************************************** 기부금 종료 전체 다시 작업  *****************************************************************************/
																																														  		  			
																																														                   /**  공제 대상금액  구하는 부분 */
																																														              // if (MSFSharedUtils.paramNull(dataCheck)) {         
																																												//		                 statCnt = 0;
																																												//		 		  		  statCnt =  infcPkgYeta7300.fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(infcPkgYe169010Vo); 	
																																												//		 		  		  if (statCnt >= 0) { 
																																												//		 		  			TODO 확인후 상황에 맞게 수정 아니면 사용안함 
																																												//		 		  		  }
																																														 		  			// 위 금액을 빼는 부분 처리를 위해 추가 된 부분 2022.03.02추가 
																																														 		  			statCnt = 0;
																																														 		  			// 
																																														 		  			Yeta7300SubtTaxWkerAmntPkgProc yeta7300SubtTaxWkerAmnt  =  new Yeta7300SubtTaxWkerAmntPkgProc();
																																														 		  			bmResult.addAll(yeta7300SubtTaxWkerAmnt.execSubtTaxWkerAmntPkgProc( request, infcPkgYe161010Vo));
																																														 	 		  
																																														 	 		        if (bmResult.size() >= 0) {     
																																														 	 	 		       /**  공제계  합산 부분 구하는 부분 */
																																												//		 	 	 		  			statCnt = 0;
																																												//		 	 	 	 		 		statCnt = infcPkgYeta7300.fnPayr06430_PAYR425_ReTax_2016_CREATE_12_Update(infcPkgYe169010Vo);
																																												//		 	 	 		 		   if (statCnt >= 0) {
																																												//		 	 	 		 			  //TODO 합산부분 확인후 차후 다시 필요시 사용안함  
																																												//		 	 	 		 		   }
																																														 	 	 		     
																																														 	 	 		       /**  차감소득금액 */ 
																																														 	 	 		 		statCnt = 0;
																																														 	 	 		 		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_50_Update(infcPkgYe169010Vo); 
																																														 	 	 		       		if (statCnt >= 0) {
																																														 	 	 		 		       /**  그밖의 소득공제 계 */ 
																																														 	 	 		 		 		statCnt = 0;  
																																														 	 	 		 		 		statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_50_01_Update(infcPkgYe169010Vo);		 	 	 		 	 		 		
																																												//		 	 	 		 		 		if (statCnt >= 0) { 
																																												//		 	 	 		 		 			 합계통합 삭제 
																																												//		 	 	 		 		 		}
																																														 	 	 		 		  	 //   statCnt = 0;
																																														 	 	 		       	    	Yeta7300SubtTaxStdDdcPkgProc yeta7300SubtTaxStdDdc  = new Yeta7300SubtTaxStdDdcPkgProc();
																																														 	 	 		       	    	bmResult.addAll(yeta7300SubtTaxStdDdc.execSubtTaxStdDdcPkgProc(request, infcPkgYe161010Vo));		 	 	 		 		  	    
																																														 	 	 		 		  		/****   여기 부터 표준세액공제 때문에 공통으로 처리 해야 함 0으로 처리 해야 할부분 에 대해 업데이트 처리도 해야함 검증을 위한쿼리 추가 ****/
																																														 	 	 		 		   
																																														 	 	 				  		 /** 표준세액공제에 대한 값 처리 */
																																														 	 	 		 		  	  if (bmResult.size() >= 0) {		 	 	 		 		  		  
																																														 	 	 		 		    	InfcPkgYe169010Srh_2022_VO   infcPkgYe169010SrhVo = new InfcPkgYe169010Srh_2022_VO();	
																																														 	 	 		 		  		InfcPkgYe169010_2022_VO   tpInfcPkgYe169010Vo = new InfcPkgYe169010_2022_VO();	//C_주현근무처 
																																														 	 							InfcPkgYe169010a_2022_VO   infcPkgYe169010AVo = new InfcPkgYe169010a_2022_VO();	//C_주현근무처_표준공제 
																																														 	 							BeanUtils.copyProperties(infcPkgYe169010Vo, infcPkgYe161010Vo);
																																														 	 							BeanUtils.copyProperties(infcPkgYe169010SrhVo, infcPkgYe161010Vo);
																																														 	 							BeanUtils.copyProperties(infcPkgYe169010AVo, infcPkgYe161010Vo); 
																																														 	 			  			    BeanUtils.copyProperties(infcPkgYe161020Vo, infcPkgYe161010Vo);
																																														 	 			  			    infcPkgYe161020Vo.setC152StdTxDdcYn("N");
																																														 	 			  			    statCnt =  infcPkgYeta7300.fnYeta7300_YE161020_Tax_2022_C152_STD_TX_DDC_YN_Update(infcPkgYe161020Vo); 
																																														 	 	 		 	            
																																													 	 	 		 	                 tpInfcPkgYe169010Vo = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_51_Select(infcPkgYe169010SrhVo);
																																													 	 	 		 			  		
																																													 	 	 		 	                 if (MSFSharedUtils.paramNotNull(tpInfcPkgYe169010Vo) || MSFSharedUtils.paramNotNull(tpInfcPkgYe169010Vo.getYetaC159())) { 
																																													 	 	 		 	                	 
																																													 	 	 		 	                      if ((!"2".equals(tpInfcPkgYe169010Vo.getRsdtClCd())) && "Y".equals(tpInfcPkgYe169010Vo.getYetaC152Check())) { 
																																													 	 	 		 	                    	  
																																									 	 	 		 						                	 BigDecimal rtnAlryPinx01 = BigDecimal.ZERO; //표준공제로 뺀값 
																																									 	 	 		 						                	 BigDecimal rtnAlryPinx02 = BigDecimal.ZERO; //정상계산으로처히한값 
																																									 	 	 		 						                	 
																																									 	 	 		 						                	 if (tpInfcPkgYe169010Vo.getTyetaC159().compareTo(BigDecimal.ZERO) < 0) {
																																									 	 	 		 						                		 rtnAlryPinx01 =  BigDecimal.ZERO.subtract(tpInfcPkgYe169010Vo.getYetaC162());
																																									 	 	 		 						                	 } else {
																																									 	 	 		 						                		 rtnAlryPinx01 =  tpInfcPkgYe169010Vo.getTyetaC159().subtract(tpInfcPkgYe169010Vo.getYetaC162());
																																									 	 	 		 						                	 } 
																																									 	 	 		 						                	 //정상처리 
																																									 	 	 		 						                	 rtnAlryPinx02 = tpInfcPkgYe169010Vo.getYetaC159().subtract(tpInfcPkgYe169010Vo.getYetaC162());
																																									 	 	 		 						                	 
																																									 	 	 		 						                	 if (rtnAlryPinx01.compareTo(rtnAlryPinx02) <  0) {
																																									 	 	 		 						                		 /**
																																									 	 	 		 						                		  * 1. 0으로 처리해야 하는 부분 업데이트 하기  플래그값을 업데이트 함
																																									 	 	 		 						                		  * 테이블 필드 변경하여 처리 됨 주의          
																																									 	 	 		 						                		  * C152_STD_TX_DDC_YN  표준세액공제적용여부  변경 
																																									 	 	 		 						                		  */
																																									 	 	 		 						                		   //avo 테이블에 복제 작업 함.  
																																									 	 	 		 						                		 dataCheck = "";
																																									 	 	 		 						                	     infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_52_Delete(infcPkgYe169010Vo);
																																									 	 	 		 						                	     dataCheck =  infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_52_Insert(infcPkgYe169010Vo); 
																																									 	 		 						                		     if (MSFSharedUtils.paramNotNull(tpInfcPkgYe169010Vo)) {
																																									 	 		 						                		  	 
																																									 	 	 		 						                		  //  InfcPkgYe169010aVO infcPkgYe169010AVo = new InfcPkgYe169010aVO(); 
																																									 	 	 		 						                		 	infcPkgYe169010AVo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
																																									 	 	 		 						                			infcPkgYe169010AVo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
																																									 	 	 		 						                			infcPkgYe169010AVo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
																																									 	 	 		 						  
																																									 	 	 		 						                		    /************
																																									 	 	 		 						                		     * 교육비/이월기부금/기부금 원천징수부아닌 기본테이블에 적용여부 확인 
																																									 	 	 		 						                		     ************/
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c81(BigDecimal.ZERO);    /** column C81_특별소득공제_보험료_건강보험료 : yeta0c81 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c82(BigDecimal.ZERO);    /** column C82_특별소득공제_보험료_고용보험료 : yeta0c82 */
																																									 	 	 		 						                	
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC133(BigDecimal.ZERO);    /** column C133_STD_세액공제_특별세액공제_보장성보험공제대상금액 : yetaStdC133 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC134(BigDecimal.ZERO);    /** column C134_STD_세액공제_특별세액공제_보장성보럼세액공제금액 : yetaStdC134 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC135(BigDecimal.ZERO);    /** column C135_STD_세액공제_특별세액공제_장애인전용공제대상금액 : yetaStdC135 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC136(BigDecimal.ZERO);    /** column C136_STD_세액공제_특별세액공제_장애인전용세액공제금액 : yetaStdC136 */
																																									 	 	 		 						                	
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC137(BigDecimal.ZERO);    /** column C137_STD_세액공제_특별세액공제_의료비공제대상금액 : yetaStdC137 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC138(BigDecimal.ZERO);    /** column C138_STD_세액공제_특별세액공제_의료비세액공제금액 : yetaStdC138 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC139(BigDecimal.ZERO);    /** column C139_STD_세액공제_특별세액공제_교육비공제대상금액 : yetaStdC139 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC140(BigDecimal.ZERO);    /** column C140_STD_세액공제_특별세액공제_교육비세액공제금액 : yetaStdC140 */
																																									 	 	 		 						                	
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c83(BigDecimal.ZERO);    /** column C83_STD_특별소득공제_주택자금_추택임차차입금_대출기관 : yetaStd0c83 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c84(BigDecimal.ZERO);    /** column C84_STD_특별소득공제_주택자금_주택임차차입금_거주자 : yetaStd0c84 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC156(BigDecimal.ZERO);    /** column C156_STD_세액공제_월세세액공제대상금액 : yetaStdC156 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC157(BigDecimal.ZERO);    /** column C157_STD_세액공제_월세세액공제금액 : yetaStdC157 */
																																									 	 	 		 						                	
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c85(BigDecimal.ZERO);    /** column C85_STD_특별소득공제_주택자금_장기주택저당차입금2011전_15미만 : yetaStd0c85 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c86(BigDecimal.ZERO);    /** column C86_STD_특별소득공제_주택자금_장기주택저당차입금2011전_15_29 : yetaStd0c86 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c87(BigDecimal.ZERO);    /** column C87_STD_특별소득공제_주택자금_장기주택저당차입금2011전_30이상 : yetaStd0c87 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c88(BigDecimal.ZERO);    /** column C88_STD_특별소득공제_차입분2012후_15이상_고정금리비거치식상환대출금액 : yetaStd0c88 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c89(BigDecimal.ZERO);    /** column C89_STD_특별소득공제_차입분2012후_15이상_기타대출금액 : yetaStd0c89 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c90(BigDecimal.ZERO);    /** column C90_STD_특별소득공제_차입분2015후_상환15이상_고정금리이고비거치상환대출금액 : yetaStd0c90 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c91(BigDecimal.ZERO);    /** column C91_STD_특별소득공제_차입분2015후_상환15이상_고정금리이거나비거치상환대출금액 : yetaStd0c91 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c92(BigDecimal.ZERO);    /** column C92_STD_특별소득공제_차입분2015후_상환15이상_그밖의대출금액 : yetaStd0c92 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c93(BigDecimal.ZERO);    /** column C93_STD_특별소득공제_차입분2015후_상환10이상_고정금리이거나비거치상환대출금액 : yetaStd0c93 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c94(BigDecimal.ZERO);    /** column C94_STD_특별소득공제_기부금_이월분금액 : yetaStd0c94 */
																																								
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c96(BigDecimal.ZERO);    /** column C96_STD_특별소득공제_특별소득공제합계 : yetaStd0c96 */
																																									 	 	 		 						              
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC145(BigDecimal.ZERO);    /** column C145_STD_세액공제_특별세액공제_법정기부금공제대상금액 : yetaStdC145 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC146(BigDecimal.ZERO);    /** column C146_STD_세액공제_특별세액공제_법정기부금세액공제금액 : yetaStdC146 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC149(BigDecimal.ZERO);    /** column C149_STD_세액공제_특별세액공제_지정기부금_종교단체외공제대상금액 : yetaStdC149 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC150(BigDecimal.ZERO);    /** column C150_STD_세액공제_특별세액공제_지정기부금_종교단체외세액공제금액 : yetaStdC150 */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC150a(BigDecimal.ZERO);    /** column C150A_STD_세액공제_특별세액공제_지정기부금_종교단체공제대상금액 : yetaStdC150a */
																																									 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC150b(BigDecimal.ZERO);    /** column C150B_STD_세액공제_특별세액공제_지정기부금_종교단체세액공제금액 : yetaStdC150b */
																																									 	 	 		 						            
																																									 	 	 		 						                	         statCnt = 0;
																																									 	 	 		 						                		  	 statCnt =  infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_52_Update(infcPkgYe169010AVo); 
																																									 	 	 		 						                	
																																								//	 	 	 		 						                	       }
																																									 	 	 		 						                		     if (statCnt >= 0) {
																																									 	 	 		 						                			    
																																								//	 	 	 		 						                	                 statCnt = 0;
																																								//	 	 	 		 						                	 		  		 statCnt =  infcPkgYeta7300.fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(infcPkgYe161010Vo); 
																																								//	 	 	 		 						                	                  //합계구하는 부분인데 사용안함 
																																								//	 	 	 		 						                	 		  		if (statCnt >= 0) {      
																																									 	 	 		 									                			  // {retax-45} 
																																									 	 	 		 									                		       /**  공제계  합산 부분 구하는 부분 */
																																								//	 	 	 		 									                		  			statCnt = 0;
																																								//	 	 	 		 									                	 		 		statCnt = infcPkgYeta7300.fnPayr06430_PAYR425_ReTax_2016_CREATE_12_Update(infcPkgYe161010Vo);
																																								//	 	 	 		 									                	 		   //로직변경으로 다르게 구성함 차후 삭제 
																																								//		 	 	 		 									                		 		if (statCnt >= 0) {
																																									 	 	 		 									                		      // {retax-46}
																																									 	 	 		 									                		       /**  차감소득금액 */
																																									 	 	 		 									                		      //  -----------------'차감소득금액     ----------------------------------
																																									 	 	 		 									                		      
																																									 	 	 		 									                		 		statCnt = 0;
																																									 	 	 		 									                		 		 statCnt =  infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_50_Update(infcPkgYe169010AVo); 
																																									 	 	 		 									                		        
																																									 	 	 		 									                		 		/*****************************************************************************************
																																									 	 	 		 									                		 		 * 표준세액공제 적용부로 ye169010a 테이블에저장함 
																																									 	 	 		 									                		 		 *****************************************************************************************/
																																									 	 	 		 													           	 		 	  if (statCnt >= 0) {
																																									 	 	 		 													           	 		 		  //InfcPkgYe169010aVO
																																									 	 	 		 													           	 		 		  infcPkgYe161010Vo.setSpciDdctCheck("TRUE");
																																									 	 	 		 													           	 		          Yeta7300SubtTaxEtcIncDdcPkgProc subtTaxEtcIncDdc  = new Yeta7300SubtTaxEtcIncDdcPkgProc();
																																									 	 	 		 	 	 		 						                			              bmResult.addAll(subtTaxEtcIncDdc.execSubtTaxEtcIncDdcPkgProc(request, infcPkgYe161010Vo)); 
																																									 	 	 		 	 	 		 						                			    
																																									 	 	 		 	 	 		 						                			          if (bmResult.size() >= 0) { 
																																									 	 	 		 														               		  	    
																																									 	 	 		 													           	 		 	 //  {retax-47}
																																									 	 	 		 													                		       /**  그밖의 소득공제 계 */
																																									 	 	 		 	 	 		 						                		                
																																									 	 	 		 													                		 		statCnt = 0;
																																									 	 	 		 													                		 		statCnt = infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_50_01_Update(infcPkgYe169010AVo);
																																									 	 	 		 													                		 		 
																																									 	 	 		 															               		       if (statCnt >= 0) {
																																									 	 	 		 															               		  	  
																																									 	 	 		 															               		  	       //YetaTaxCreateUpdate InfcPkgYe169010aVO
																																												 	 	 		 															               		 Yeta7300SubtTaxStdDdcPkgProc subtTaxStdDdc  = new Yeta7300SubtTaxStdDdcPkgProc();
																																												 	 	 		 															               	     bmResult.addAll(subtTaxStdDdc.execSubtTaxStdDdcPkgProc(request, infcPkgYe161010Vo) ); 
																																												 	 	 		 															               	     
																																												 	 	 		 															               	     //  정리후 C152_STD_TX_DDC_YN  표준세액공제적용여부  변경  테이블 변경 "Y"
																																												 	 	 		 															               	     
																																												 	 	 		 															                   	spciDdctCheck = "TRUE";
																																									 	 	 		 															               		  	     
																																									 	 	 		 															               		  	    }
																																									 	 	 		 													                		 		}
																																									 	 	 		 													           	 		 	    }  
																																									 	 	 		 									                		   //   }
																																									 	 	 		 						                	 		  		//}
																																									 	 	 		 						                		   }
																																									 	 	 		 						                	    }     
																																									 	 	 		 						                	 } else  {
																																									 	 	 		 						                		 infcPkgYe161010Vo.setSpciDdctCheck("FALSE");
																																									 	 	 		 						                		  if (statCnt >= 0) {
																																									 	 	 		 						                			 //InfcPkgYe169010VO
																																									 	 	 		 						                		    Yeta7300SubtTaxEtcIncDdcPkgProc subtTaxEtcIncDdc  = new Yeta7300SubtTaxEtcIncDdcPkgProc();
																																									 	 		 						                			    bmResult.addAll(subtTaxEtcIncDdc.execSubtTaxEtcIncDdcPkgProc(request, infcPkgYe161010Vo)); 
																																									 	 		 						                			    
																																									 	 		 						                 		       if (bmResult.size() >= 0) {    
																																									 	 	 		 						                 		  	  //  {retax-47}
																																									 	 	 		 						                 		       /**  그밖의 소득공제 계 */ 
																																									 	 	 		 						                 		 		statCnt = 0;
																																									 	 	 		 						                 		 		statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_50_01_Update(infcPkgYe169010Vo);
																																									 	 	 		 						                 		 	  
																																									 	 	 		 						               		  	       } 
																																									 	 	 		 						                		  }	  
																																									 	 	 		 						                	}	  
																																									 	 	 		 				                	 } else {
																																									 	 	 		 				                		 infcPkgYe161010Vo.setSpciDdctCheck("FALSE");
																																									 	 	 		 				                		 if (statCnt >= 0) {
																																									 	 	 		 				                		 //InfcPkgYe169010VO
																																									 	 	 		 				                		    Yeta7300SubtTaxEtcIncDdcPkgProc subtTaxEtcIncDdc  = new Yeta7300SubtTaxEtcIncDdcPkgProc();
																																								 		 						                			    bmResult.addAll(subtTaxEtcIncDdc.execSubtTaxEtcIncDdcPkgProc(request, infcPkgYe161010Vo)); 
																																								 		 						                			    
																																								 		 						                 		       if (bmResult.size() >= 0) {	    
																																									 	 	 		 				                 		  	  //  {retax-47}
																																									 	 	 		 				                 		       /**  그밖의 소득공제 계 */ 
																																									 	 	 		 				                 		 		statCnt = 0;
																																									 	 	 		 				                 		 		statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_50_01_Update(infcPkgYe169010Vo);
																																									 	 	 		 				                 		 	  
																																									 	 	 		 				               		  	  } 
																																									 	 	 		 				                		 }	  	  
																																									 	 	 		 				                  }  
																																									 	 	 		 	                  
																																												 	 	 		 	                  /**  //납부또는 환급세액 */ 
																																												 	 	 		 			  		if (statCnt >= 0) {
																																												 	 	 		 			  		statCnt = 0;
																																												 	 	 		 			  		if ("TRUE".equals(spciDdctCheck) ) {
																																								
																																													 	 	 		 			  		statCnt =   infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_51_Update(infcPkgYe169010AVo); 
																																													 	 	 		 			  		spciDdctCheck = "FALSE";
																																												 	 	 		 			  		} else {
																																								
																																													 	 	 		 			  		statCnt =   infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_51_Update(infcPkgYe169010Vo); 
																																													 	 	 		 			  		spciDdctCheck = "FALSE";  
																																												 	 	 		 			  		}
																																												 	 	 		 	                
																																												 	 	 		 	                // {retax-63}
																																												 	 	 		 	                 /** 차감징수세액 총계  */ 
																																												 	 	 		 			  		if (statCnt >= 0) {
																																								//				 	 	 		 			  			statCnt = 0;  사용안해도될거 같음 
																																								//				 	 	 		 			  		  statCnt =  infcPkgYeta7300.fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(infcPkgYe169010Vo);
																																												 	 	 		 			  		
																																												 	 	 		 			  	 /** YE169010 YE169010A 복제 루틴 */ 
																																												 	 	 		 			  		 
																																													 	 							
																																													 	 					 		InfcPkgYe169010Srh_2022_VO   ye169010SrhVo = new InfcPkgYe169010Srh_2022_VO();	 
																																													 	 							BeanUtils.copyProperties(ye169010SrhVo, infcPkgYe161010Vo); 
																																													 	 							
																																												 	 	 		 			  		 List lstPkgYe169010Vo =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_A01_Select(ye169010SrhVo);
																																												 	 	 		 			  		 
																																														 	 	 		 			     for (int iCnt02 = 0;iCnt02 < lstPkgYe169010Vo.size();iCnt02++) {
																																														 	 	                           
																																														 	 	 		 			    	 Map tempMap = (Map)lstPkgYe169010Vo.get(iCnt02); 
																																														 	 	                            
																																														 	 	 		 			    	 
																																														 	 	 		 			      //	InfcPkgYe169010VO   tpInfcPkgYe169010Vo = new InfcPkgYe169010VO();	//C_주현근무처 
																																																 	 	 		 			  	InfcPkgYe161060_2022_VO    inputYe161060Vo	 = new InfcPkgYe161060_2022_VO();	//C_특별소득공제
																																																 	 							InfcPkgYe161070_2022_VO    inputYe161070Vo	 = new InfcPkgYe161070_2022_VO();	//C_그밖의소득공제
																																																 	 							InfcPkgYe161080_2022_VO    inputYe161080Vo	 = new InfcPkgYe161080_2022_VO();	//C_세액감면및공제
																																																 	 							BeanUtils.copyProperties(inputYe161060Vo, infcPkgYe161010Vo);
																																																 	 							BeanUtils.copyProperties(inputYe161070Vo, infcPkgYe161010Vo);
																																																 	 							BeanUtils.copyProperties(inputYe161080Vo, infcPkgYe161010Vo); 
																																																 	 							
																																																								//inputYe161060Vo.setBrwLnpbSrmAmt(tempMap.get("brwLnpbSrmAmt"));    /** column 주택임차차입금대출기관차입원리금상환액 : brwLnpbSrmAmt */
																																																								inputYe161060Vo.setBrwLnpbSrmDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c83"),"0")));    /** column 주택임차차입금대출기관차입공제액 : brwLnpbSrmDdcAmt */
																																																								
																																																								//inputYe161060Vo.setRsdtLnpbSrmAmt(tempMap.get("rsdtLnpbSrmAmt"));    /** column 주택임차차입금거주자차입원리금상환액 : rsdtLnpbSrmAmt */
																																																								inputYe161060Vo.setRsdtLnpbSrmDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c84"),"0")));    /** column 주택임차차입금거주자차입공제액 : rsdtLnpbSrmDdcAmt */
																																																								
																																																								//inputYe161060Vo.setLthYr15BlwItrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("lthYr15BlwItrAmt"),"0")));    /** column 장기주택저장차입금2011년이전차입분중15년미만이자상환액 : lthYr15BlwItrAmt */
																																																								inputYe161060Vo.setLthYr15BlwDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c85"),"0")));    /** column 장기주택저당차입금2011년이전차입분15년미만공제액 : lthYr15BlwDdcAmt */
																																																								//inputYe161060Vo.setLthYr29ItrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("lthYr29ItrAmt"),"0")));    /** column 장기주택저당차입금2011년이전차입분중15_29년이자상환액 : lthYr29ItrAmt */
																																																								inputYe161060Vo.setLthYr29DdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c86"),"0")));    /** column 장기주택저당차입금2011년이전차입분15_29년공제액 : lthYr29DdcAmt */
																																																								//inputYe161060Vo.setLthY30OverItrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("lthY30OverItrAmt"),"0")));    /** column 장기주택저당차입금2011이전차입분중30년이상이자상환액 : lthY30OverItrAmt */
																																																								inputYe161060Vo.setLthY30OverDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c87"),"0")));    /** column 장기주택저당차입금2011이전차입분20년이상공제액 : lthY30OverDdcAmt */
																																																								//inputYe161060Vo.setLthYr2012AfthY15Amt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2012AfthY15Amt"),"0")));    /** column 장기주택저당차입금2012이후고정금리이거나비거치상환대출이자상환액 : lthYr2012AfthY15Amt */
																																																								inputYe161060Vo.setLthYr2012AfthY15DdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c88"),"0")));    /** column 장기주택저당차입금2012이후고정금리이거나비거치산환대출공제액 : lthYr2012AfthY15DdcAmt */
																																																								//inputYe161060Vo.setLthYr2012EtcBrwItrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2012EtcBrwItrAmt"),"0")));    /** column 장기주택저당차입금2012이후기타대출이자상환액 : lthYr2012EtcBrwItrAmt */
																																																								inputYe161060Vo.setLthYr2012EtcBrwDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c89"),"0")));    /** column 장기주택저당차입금2012이후기타대출공제액 : lthYr2012EtcBrwDdcAmt */
																																																								//inputYe161060Vo.setLthYr2015AfthFxnIrItrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2015AfthFxnIrItrAmt"),"0")));    /** column 장기주택저당차입금2015이후_15이상_고정금리이면서비거치상환대출이자상환액 : lthYr2015AfthFxnIrItrAmt */
																																																								inputYe161060Vo.setLthYr2015AfthFxnIrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c90"),"0")));    /** column 장기주택저당차입금2015이후_15이상_고정금리이면서비거치상환대출공제액 : lthYr2015AfthFxnIrDdcAmt */
																																																								//inputYe161060Vo.setLthYr2015AfthY15Amt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2015AfthY15Amt"),"0")));    /** column 장기주택저당차입금2015이후_15이상_고정금리이거나비거치상환대출이자상환액 : lthYr2015AfthY15Amt */
																																																								inputYe161060Vo.setLthYr2015AfthY15DdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c91"),"0")));    /** column 장기주택저당차입금2015이후_15이상_고정금리이거나비거치상환대출공제액 : lthYr2015AfthY15DdcAmt */
																																																								//inputYe161060Vo.setLthYr2015AfthEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2015AfthEtcAmt"),"0")));    /** column 장기주택저당차입금2015이후_15이상_기타대출이자상환액 : lthYr2015AfthEtcAmt */
																																																								inputYe161060Vo.setLthYr2015AfthEtcDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c92"),"0")));    /** column 장기주택저당차입금2015이후_15이상_기타대출공제액 : lthYr2015AfthEtcDdcAmt */
																																																								//inputYe161060Vo.setLthYr2015AfthYr15Amt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("lthYr2015AfthYr15Amt"),"0")));    /** column 장기주택저당차입금_2015이후_10_15고정금리이거나비거치상환대출이자상환액 : lthYr2015AfthYr15Amt */
																																																								inputYe161060Vo.setLthYr2015AfthYr15DdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c93"),"0")));    /** column 장기주택저당차입금_2015이후_10_15고정금리이거나비거치상환대출공제액 : lthYr2015AfthYr15DdcAmt */
																																																								
																																																								inputYe161060Vo.setHsngFndsDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("hsngFndsDdcAmtSum"),"0")));    /** column 주택자금공제액_합계 : hsngFndsDdcAmtSum */
																																																								inputYe161060Vo.setConbDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c94"),"0")));    /** column 기부금이월분_지정기부금공제합계 : conbDdcAmtSum */
																																																					 
																																																								infcPkgYeta7300.fnYeta7300_Ye161060_Tax_2022_I1_Update(inputYe161060Vo); 
																																														 	 							
																																																								inputYe161070Vo.setYr2000PnsnSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c98"),"0")));    /** column 개인연금저축_2000이전_공제액 : yr2000PnsnSvngDdcAmt */
																																																								inputYe161070Vo.setSmceSbizDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c99"),"0")));    /** column 소기업소상인공제부금공제액 : smceSbizDdcAmt */
																																																								inputYe161070Vo.setSbcSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC100"),"0")));    /** column 주택마련저축_청약저축공제액 : sbcSvngDdcAmt */ 
																																																								inputYe161070Vo.setHsngSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC101"),"0")));    /** column 주택마련저축_주택청약종합저축공제액 : hsngSvngDdcAmt */
																																																								inputYe161070Vo.setLbrrPrptSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC102"),"0")));    /** column 주택마련저축_근로자주택마련저축공제액 : lbrrPrptSvngDdcAmt */
																																																								inputYe161070Vo.setHsngIncDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("hsngIncDdcAmtSum"),"0")));    /** column 주택마련저축소득공제액합계 : hsngIncDdcAmtSum */
																																																								                    
																																																								inputYe161070Vo.setIvcpInvmDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC103"),"0")));    /** column 투자조합출자등소득공제공제액계 : ivcpInvmDdcAmtSum */
																																																								//inputYe161070Vo.setHsngIncUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("hsngIncUseAmtSum"),"0")));
																																																								
																																																								inputYe161070Vo.setRdcSumDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC104"),"0")));    /** column 신용카드등사용공제액합계 : rdcSumDdcAmt */ 
																																																								inputYe161070Vo.setEmstAsctCntrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC105"),"0")));    /** column 우리사주조합출연금공제금액 : emstAsctCntrDdcAmt */ 
																																																								inputYe161070Vo.setEmpMntnSnmcDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC107"),"0")));    /** column 고용유지중소기업근로자공제금액 : empMntnSnmcDdcAmt */ 
																																																								inputYe161070Vo.setLtrmCniSsDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC109"),"0")));    /** column 장기집합투자증권저축공제금액 : ltrmCniSsDdcAmt */ 
																																																								inputYe161070Vo.setLtrmCniYyDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC109y"),"0")));    /** column 청년형장기집합투자증권저축공제금액 : ltrmCniYyDdcAmt */ 
																																																								
																																																								 infcPkgYeta7300.fnYeta7300_Ye161070_Tax_2022_I2_Update(inputYe161070Vo); 
																																																								  
																																																								inputYe161080Vo.setSctcHpDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC127"),"0")));    /** column 연금계좌_과학기술인공제_공제대상금액 : sctcHpDdcTrgtAmt */
																																																								inputYe161080Vo.setSctcHpDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC128"),"0")));    /** column 연금계좌_과학기술인공제_공제세액 : sctcHpDdcAmt */ 
																																																								inputYe161080Vo.setRtpnDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC129"),"0")));    /** column 연금계좌_근로자퇴직급여보장법_퇴직연금공제대상금액 : rtpnDdcTrgtAmt */
																																																								inputYe161080Vo.setRtpnDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC130"),"0")));    /** column 연금계좌_근로자퇴직급여보장법_퇴직연금공제세액 : rtpnDdcAmt */ 
																																																								inputYe161080Vo.setPnsnSvngDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC131"),"0")));    /** column 연금계좌_연금저축공제대상금액 : pnsnSvngDdcTrgtAmt */
																																																								inputYe161080Vo.setPnsnSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC132"),"0")));    /** column 연금계좌_연금저축공제세액 : pnsnSvngDdcAmt */ 
																																																								
																																																								inputYe161080Vo.setIsaDdcTrgtAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC13a"),"0")));
																																																								inputYe161080Vo.setIsaDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC13b"),"0")));
																																																								
																																																								inputYe161080Vo.setPnsnAccDdcTrgtAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("pnsnAccDdcTrgtAmtSum"),"0")));    /** column 연금계좌_연금저축공제대상금액 : pnsnAccDdcTrgtAmtSum */
																																																								inputYe161080Vo.setPnsnAccDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("pnsnAccDdcAmtSum"),"0")));    /** column 연금계좌_연금저축공제세액 : pnsnAccDdcAmtSum */ 
																																																								
																																																								 
																																																								inputYe161080Vo.setCvrgInscDdcTrgtAmt2(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC133"),"0")));    /** column 보장성보험공제대상금액 : cvrgInscDdcTrgtAmt2 */
																																																								inputYe161080Vo.setCvrgInscDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC134"),"0")));    /** column 보장성보험공제세액 : cvrgInscDdcAmt */ 
																																																								inputYe161080Vo.setDsbrEuCvrgDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC135"),"0")));    /** column 장애인전용보장성보험공제대상금액 : dsbrEuCvrgDdcTrgtAmt */
																																																								inputYe161080Vo.setDsbrEuCvrgDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC136"),"0")));    /** column 장애인전용보장성보험공제세액 : dsbrEuCvrgDdcAmt */
																																																							 
																																																								
																																																								
																																																								inputYe161080Vo.setInfeePymDdcTrgtAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("infeePymDdcTrgtAmtSum"),"0")));   
																																																								inputYe161080Vo.setInfeePymDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("infeePymDdcAmtSum"),"0")));    
																																																								 
																																																								         
																																																								inputYe161080Vo.setMdxpsDdcTrgtAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC137"),"0")));    /** column 의료비공제대상금액합계 : mdxpsDdcTrgtAmtSum */
																																																								inputYe161080Vo.setMdxpsDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC138"),"0")));    /** column 의료비공제세액합계 : mdxpsDdcAmtSum */
																																																								 
																																																								inputYe161080Vo.setScxpsDdcTrgtAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC139"),"0")));    /** column 교육비공제대상금액합계 : scxpsDdcTrgtAmtSum */
																																																								inputYe161080Vo.setScxpsDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC140"),"0")));    /** column 교육비공제세액금액합계 : scxpsDdcAmtSum */
																																																							 
																																																							    
																																																								inputYe161080Vo.setConb10ttswLtDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC141"),"0")));    /** column 기부금_정치자금기부금10이하공제대상금액 : conb10ttswLtDdcTrgtAmt */
																																																								inputYe161080Vo.setConb10ttswLtDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC142"),"0")));    /** column 기부금_정치자금기부금10이하공제세액 : conb10ttswLtDdcAmt */ 
																																																								inputYe161080Vo.setConb10excsLtDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC143"),"0")));    /** column 기부금_정치자금기부금10초과공제대상금액 : conb10excsLtDdcTrgtAmt */
																																																								inputYe161080Vo.setConb10excsLtDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC144"),"0")));    /** column 기부금_정치자금기부금10초과공제세액 : conb10excsLtDdcAmt */
																																																								
																																																								//inputYe161080Vo.setConbLglDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC145"),"0")));    /** column 기부금_법정기부금공제대상금액 : conbLglDdcTrgtAmt */
																																																								//inputYe161080Vo.setConbLglDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC146"),"0")));    /** column 기부금_법정기부금공제세액 : conbLglDdcAmt */
																																																								inputYe161080Vo.setConbEmstAsctDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC147"),"0")));    /** column 기부금_우리사주조합기부금공제대상금액 : conbEmstAsctDdcTrgtAmt */
																																																								inputYe161080Vo.setConbEmstAsctDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC148"),"0")));    /** column 기부금_우리사주조합기부금공제세액 : conbEmstAsctDdcAmt */
																																																								//inputYe161080Vo.setConbReliOrgOthDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC149"),"0")));    /** column 기부금_지정기부금종교단체외공제대상금액 : conbReliOrgOthDdcTrgtAmt */
																																																								//inputYe161080Vo.setConbReliOrgOthDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC150"),"0")));    /** column 기부금_지정기부금종교단체외공제세액 : conbReliOrgOthDdcAmt */
																																																								//inputYe161080Vo.setConbReliOrgDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC150a"),"0")));    /** column 기부금_지정기부금종교단체공제대상금액 : conbReliOrgDdcTrgtAmt */
																																																								inputYe161080Vo.setConbReliOrgDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC150b"),"0")));    /** column 기부금_지정기부금종교단체공제세액 : conbReliOrgDdcAmt */
																																																								inputYe161080Vo.setConbDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbDdcAmtSum"),"0"))); //세액합계 
																																																								 
																																																								inputYe161080Vo.setHsngTennLnpbDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC154"),"0")));    /** column 주택자금차입금이자세액공제세액금액 : hsngTennLnpbDdcAmt */
																																																								inputYe161080Vo.setMmrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC157"),"0")));    /** column 월세액세액공제공제세액 : mmrDdcAmt */
																																																								 
																																																								infcPkgYeta7300.fnYeta7300_Ye161080_Tax_2022_I3_Update(inputYe161080Vo);
																																																								
																																																								
																																																								 /////퇴직연금/////////
																																																 	 	 		 			      InfcPkgYe162020Srh_2022_VO   ye162020SrhVo = new InfcPkgYe162020Srh_2022_VO();	 
																																																 	 							  BeanUtils.copyProperties(ye162020SrhVo, infcPkgYe161010Vo); 
																																																 	 							
																																															 	 	 		 			  		   List lstPkgYe162020Vo =  infcPkgYeta7300.fnYeta7300_YE162020_Tax_2022_A01_Select(ye162020SrhVo);
																																															 	 	 		 			  	   BigDecimal bgYetaC127 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC127"),"0"));
																																															 	 	 		 			       BigDecimal bgYetaC129 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC129"),"0"));
																																															 	 	 		 			       BigDecimal bgYetaC13a = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC13a"),"0"));
																																																	 	 	 		 			     for (int iCnt03 = 0;iCnt03 < lstPkgYe162020Vo.size();iCnt03++) {
																																																	 	 	 		 			    	 
																																																	 	 	 		 			    	InfcPkgYe162020_2022_VO    infcPkgYe162020Vo	 = new InfcPkgYe162020_2022_VO();	//F_퇴직연금계좌명세
																																																									
																																																	 	 	 		 			    	 Map tempMap01 = (Map)lstPkgYe162020Vo.get(iCnt03); 
																																																	 	 	 		 			    	 
																																																	 	 	 		 			    	 BeanUtils.copyProperties(infcPkgYe162020Vo, infcPkgYe161010Vo);
																																																										
																																																	 	 	 		 				 infcPkgYe162020Vo.setRtpnAccAccno(MSFSharedUtils.allowNulls(tempMap01.get("rtpnAccAccno")) );
																																																 	 	 		 			         infcPkgYe162020Vo.setRtpnAccRtpnCl(MSFSharedUtils.allowNulls(tempMap01.get("rtpnAccRtpnCl")) );
																																																 	 	 		 			                     
																																																 	 	 		 			    	 if ("Y0040010".equals(MSFSharedUtils.allowNulls(tempMap01.get("rtpnAccRtpnCl")))) {
																																																 	 	 		 			    		
																																																 	 	 		 		                                     
																																																 	 	 		 			    		BigDecimal bgRtpnAccPymAmt = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap01.get("rtpnAccPymAmt"),"0"));
																																																 	 	 		 			    	    
																																																 	 	 		 			    		if (bgYetaC129.compareTo(bgRtpnAccPymAmt) > 0) {
																																																 	 	 		 			    	    	infcPkgYe162020Vo.setRtpnAccTgtAmt(bgRtpnAccPymAmt); 
																																																 	 	 		 			    	    bgYetaC129 = bgYetaC129.subtract(bgRtpnAccPymAmt);
																																																 	 	 		 			    	    } else {
																																																 	 	 		 			    	    	
																																																 	 	 		 			    	    	infcPkgYe162020Vo.setRtpnAccTgtAmt(bgYetaC129); 
																																																 	 	 		 			    	    bgYetaC129 = BigDecimal.ZERO;
																																																 	 	 		 			    	    }
																																																 	 	 		 			    	  
																																																 	 	 		 			    		
																																																 	 	 		 			    	    infcPkgYeta7300.updateYeta7300_Tax_Ye162020_01(infcPkgYe162020Vo);     
																																																 	 	 		 			    	    
																																																 	 	 		 			    	    
																																																 	 	 		 			    	    //2022연말정산_추가 퇴직연금ISA
																																																 	 	 		 			    	    BigDecimal bgRTPN_ACC_ISA_AMT = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap01.get("rtpnAccIsaAmt"),"0"));
																																																 	 	 		 			    	    
																																																 	 	 		 			    	    if(bgYetaC13a.compareTo(bgRTPN_ACC_ISA_AMT) > 0){
																																																 	 	 		 			    	    	infcPkgYe162020Vo.setRtpnAccIsaTgtAmt(bgRTPN_ACC_ISA_AMT); 
																																																 	 	 		 			    	    	bgYetaC13a = bgYetaC13a.subtract(bgRTPN_ACC_ISA_AMT);
																																																 	 	 		 			    	    	
																																																 	 	 		 			    	    }else {
																																															 	 	 		 			    	    	
																																																 	 	 		 			    	    	infcPkgYe162020Vo.setRtpnAccIsaTgtAmt(bgYetaC13a); 
																																																 	 	 		 			    	    	bgYetaC13a = BigDecimal.ZERO;
																																																 	 	 		 			    	    }
																																																 	 	 		 			    	    
																																																 	 	 		 			    	    //ISA퇴직연금공제대상금액 구하는 UDPATE
																																																 	 	 		 			    		infcPkgYeta7300.updateYeta7300_Tax_Ye162020_01_S(infcPkgYe162020Vo) ; 
																																																 	 	 		 			    	    
																																																 	 	 		 			    	    
																																																 	 	 		 			    	    
																																																 	 	 		 			           //	infcPkgYe162020Vo.setPnsnSvngAccPymAmt();
																																																 	 	 		 			    	 } else if("Y0040020".equals(MSFSharedUtils.allowNulls(tempMap01.get("rtpnAccRtpnCl")))) {
																																																 	 	 		 			    		// 
																																																 	 	 		 			    		BigDecimal bgRtpnAccPymAmt = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap01.get("rtpnAccPymAmt"),"0"));
																																																 	 	 		 			             
																																																 	 	 		 			    	  if (bgYetaC127.compareTo(bgRtpnAccPymAmt) > 0) {
																																																 	 	 		 			    	    	infcPkgYe162020Vo.setRtpnAccTgtAmt(bgRtpnAccPymAmt); 
																																																 	 	 		 			    	    bgYetaC127 = bgYetaC127.subtract(bgRtpnAccPymAmt);
																																																 	 	 		 			    	    } else {
																																																 	 	 		 			    	    	
																																																 	 	 		 			    	    	infcPkgYe162020Vo.setRtpnAccTgtAmt(bgYetaC127); 
																																																 	 	 		 			    	    bgYetaC127 = BigDecimal.ZERO;
																																																 	 	 		 			    	    }
																																																 	 	 		 			    		
																																																 	 	 		 			    	 	 infcPkgYeta7300.updateYeta7300_Tax_Ye162020_01(infcPkgYe162020Vo);     
																																																 	 	 		 			    	   }  
																																																	 	 	 		 			    	 
																																																	 	 	 		 			     }	 
																																																	 	 	 		 			 
																																																	 	 	 		 			     InfcPkgYe162020_2022_VO    infcPkgYe162020Vo	 = new InfcPkgYe162020_2022_VO();	//F_퇴직연금계좌명세
																																															 	 	 		 			    	     BeanUtils.copyProperties(infcPkgYe162020Vo, infcPkgYe161010Vo);
																																							
																																															 	 	 		 			    	     infcPkgYeta7300.updateYeta7300_Tax_Ye162020_02(infcPkgYe162020Vo);      
																																																		 	 	 		 			     
																																															 	 	 		 			    	/////////////////////////////////////////////////////////////////////     
																																																								
																																																								
																																																								 
																																																								 //연금저축등소득세액공제 정리 
																																																								 ///////////////////////////////////////////////////
																																																								InfcPkgYe162010Srh_2022_VO   ye162010SrhVo = new InfcPkgYe162010Srh_2022_VO();	 
																																																	 	 						BeanUtils.copyProperties(ye162010SrhVo, infcPkgYe161010Vo); 
																																																	 	 							
																																																 	 	 		 			  		 List lstPkgYe162010Vo =  infcPkgYeta7300.fnYeta7300_YE162010_Tax_2022_A01_Select(ye162010SrhVo);
																																																 	 	 		 			  	   //  BigDecimal bgTotPNSN_SVNG_ACC_PYM_AMT = BigDecimal.ZERO;
																																																 	 	 		 			  	     BigDecimal bgYeta0c98 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c98"),"0"));
																																																 	 	 		 			         BigDecimal bgYetaC131 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC131"),"0"));
																																																 	 	 		 			         
																																																 	 	 		 			     	
																																																 	 	 		 			  	   //  bgTotPNSN_SVNG_ACC_PYM_AMT =bgYeta0c98;
																																																 	 	 		 			  	
																																																		 	 	 		 			     for (int iCnt03 = 0;iCnt03 < lstPkgYe162010Vo.size();iCnt03++) {
																																																		 	 	 		 			         InfcPkgYe162010_2022_VO    infcPkgYe162010Vo	 = new InfcPkgYe162010_2022_VO();	//F_연금저축계좌
																																																		 	 	 		 			    	 Map tempMap01 = (Map)lstPkgYe162010Vo.get(iCnt03); 
																																																		 	 	 		 			    
																																																											
																																																		 	 	 		 			    	 BeanUtils.copyProperties(infcPkgYe162010Vo, infcPkgYe161010Vo);
																																																		 	 	 		 			    	 
																																																		 	 	 		 			    	 //n번째 계좌의 계좌번호, 연금저축구분코드를 넣어준다
																																																		 	 	 		 			    	 infcPkgYe162010Vo.setPnsnSvngAccAccno(MSFSharedUtils.allowNulls(tempMap01.get("pnsnSvngAccAccno")) );
																																																		 	 	 		 			         infcPkgYe162010Vo.setPnsnSvngAccPnsnSvngCl(MSFSharedUtils.allowNulls(tempMap01.get("pnsnSvngAccPnsnSvngCl")) );
																																																		 	 	 		 			                     
																																																		 	 	 		 			    	 if ("Y0040030".equals(MSFSharedUtils.allowNulls(tempMap01.get("pnsnSvngAccPnsnSvngCl")))) {
																																																		 	 	 		 			    		//개인연금 
																																																		 	 	 		 			    		
																																																		 	 	 		 			    		//항목별개인연금저축납입액
																																																		 	 	 		 			    		BigDecimal bgPNSN_SVNG_ACC_PYM_AMT = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap01.get("pnsnSvngAccPymAmt"),"0"));
																																																		 	 	 		 			    		//항목별개인연금저축소득공제금액 = 납입액 * 40%
																																																		 	 	 		 			    	    BigDecimal ddcPymAmt = bgPNSN_SVNG_ACC_PYM_AMT.multiply(new BigDecimal("0.40")).setScale(0, BigDecimal.ROUND_DOWN);
																																																		 	 	 		 			    	  
																																																		 	 	 		 			    	    //전체개인연금저축소득공제금액에서 항목별 개인연금저축소득공제금액을 차감하는 방식으로 계좌별 소득공제금액 구해준다
																																																		 	 	 		 			    	    if (bgYeta0c98.compareTo(ddcPymAmt) > 0) {
																																																		 	 	 		 			    	    	infcPkgYe162010Vo.setPnsnSvngAccTgtAmt(ddcPymAmt); 
																																																		 	 	 		 			    	        bgYeta0c98 = bgYeta0c98.subtract(ddcPymAmt);
																																																		 	 	 		 			    	    } else {
																																																		 	 	 		 			    	    	
																																																		 	 	 		 			    	    	infcPkgYe162010Vo.setPnsnSvngAccTgtAmt(bgYeta0c98); 
																																																		 	 	 		 			    	        bgYeta0c98 = BigDecimal.ZERO;
																																																		 	 	 		 			    	    }
																																																		 	 	 		 			    	    //이후 구한 식을 계좌별로 반복적으로 UPDATE
																																																		 	 	 		 			    	    infcPkgYeta7300.updateYeta7300_Tax_Ye162010_01(infcPkgYe162010Vo); 
																																																		 	 	 		 			    	    
																																																		 	 	 		 			           //	infcPkgYe162010Vo.setPnsnSvngAccPymAmt();
																																																		 	 	 		 			    	 } else if("Y0040040".equals(MSFSharedUtils.allowNulls(tempMap01.get("pnsnSvngAccPnsnSvngCl")))) {
																																																		 	 	 		 			    		//연금저축  
																																																		 	 	 		 			    		 
																																																		 	 	 		 			    		 //항목별연금저축납입액
																																																		 	 	 		 			    		BigDecimal bgPNSN_SVNG_ACC_PYM_AMT = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap01.get("pnsnSvngAccPymAmt"),"0"));
																																																		 	 	 		 			    	    if (bgYetaC131.compareTo(bgPNSN_SVNG_ACC_PYM_AMT) > 0) {
																																																		 	 	 		 			    	    	infcPkgYe162010Vo.setPnsnSvngAccTgtAmt(bgPNSN_SVNG_ACC_PYM_AMT); 
																																																		 	 	 		 			    	    	bgYetaC131 = bgYetaC131.subtract(bgPNSN_SVNG_ACC_PYM_AMT);
																																																		 	 	 		 			    	    } else {
																																																		 	 	 		 			    	    	infcPkgYe162010Vo.setPnsnSvngAccTgtAmt(bgYetaC131); 
																																																		 	 	 		 			    	    	bgYetaC131 = BigDecimal.ZERO;
																																																		 	 	 		 			    	    }
																																																		 	 	 		 			    	    
																																																		 	 	 		 			    	    infcPkgYeta7300.updateYeta7300_Tax_Ye162010_01(infcPkgYe162010Vo) ; 
																																																		 	 	 		 			    	    
																																																		 	 	 		 			    	    
																																																		 	 	 		 			    	    //2022연말정산_추가 연금저축ISA
																																																		 	 	 		 			    	    BigDecimal bgPNSN_SVNG_ACC_ISA_AMT = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap01.get("pnsnSvngAccIsaAmt"),"0"));
																																																		 	 	 		 			    	    
																																																		 	 	 		 			    	    if(bgYetaC13a.compareTo(bgPNSN_SVNG_ACC_ISA_AMT) > 0){
																																																		 	 	 		 			    	    	infcPkgYe162010Vo.setPnsnSvngAccIsaTgtAmt(bgPNSN_SVNG_ACC_ISA_AMT); 
																																																		 	 	 		 			    	    	bgYetaC13a = bgYetaC13a.subtract(bgPNSN_SVNG_ACC_ISA_AMT);
																																																		 	 	 		 			    	    	
																																																		 	 	 		 			    	    }else {
																																																	 	 	 		 			    	    	
																																																		 	 	 		 			    	    	infcPkgYe162010Vo.setPnsnSvngAccIsaTgtAmt(bgYetaC13a); 
																																																		 	 	 		 			    	    	bgYetaC13a = BigDecimal.ZERO;
																																																		 	 	 		 			    	    }
																																																		 	 	 		 			    	    
																																																		 	 	 		 			    	    //ISA연금저축공제대상금액 구하는 UDPATE
																																																		 	 	 		 			    		infcPkgYeta7300.updateYeta7300_Tax_Ye162010_01_S(infcPkgYe162010Vo) ; 
																																																		 	 	 		 			    		
																																																		 	 	 		 			    	 } 
																																																		 	 	 		 			    	 
																																																		 	 	 		 			    	 
																																																		 	 	 		 			    	 	 
																																																		 	 	 		 			     }	
																																																		 	 	 		 			     
																																																		 	 	 		 			      InfcPkgYe162010_2022_VO    infcPkgYe162010Vo	 = new InfcPkgYe162010_2022_VO();	//F_연금저축계좌
																																																 	 	 		 			    	      BeanUtils.copyProperties(infcPkgYe162010Vo, infcPkgYe161010Vo);
																																																 	 	 		 			    	      
																																																 	 	 		 			    	      //테이블에 등록된 금액의 세액공제액을 한번에 구한다
																																																		 	 	 		 			      infcPkgYeta7300.updateYeta7300_Tax_Ye162010_02(infcPkgYe162010Vo); 	   
																																																		 	 	 		 			      
																																																		 	 	 		 			   
																																																		 	 	 		 			  ///////////////////////////////////////////////////
																																																		 	 	 		 			      
																																																 	 	 		 			    	     
																																																 	 	 		 			    	     
																																																 	 	 		 			     InfcPkgYe162030Srh_2022_VO   ye162030SrhVo = new InfcPkgYe162030Srh_2022_VO();	 
																																																 	 							 BeanUtils.copyProperties(ye162030SrhVo, infcPkgYe161010Vo); 
																																																 	 						 
																																																 	 					                
																																															 	 	 		 			  		 List lstPkgYe162030Vo =  infcPkgYeta7300.fnYeta7300_YE162030_Tax_2022_A01_Select(ye162030SrhVo);
																																															 	 	 		 			  		 BigDecimal bgYetaC100 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC100"),"0"));
																																															 	 	 		 			  		 BigDecimal bgYetaC101 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC101"),"0"));
																																															 	 	 		 			  		 BigDecimal bgYetaC102 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC102"),"0"));
																																																	 	 	 		 			 for (int iCnt03 = 0;iCnt03 < lstPkgYe162030Vo.size();iCnt03++) {
																																																	 	 	 		 			 	    InfcPkgYe162030_2022_VO    infcPkgYe162030Vo	 = new InfcPkgYe162030_2022_VO();	//F_주택마련저축
																																																								
																																																	 	 	 		 			    	 Map tempMap01 = (Map)lstPkgYe162030Vo.get(iCnt03); 
																																																	 	 	 		 			    
																																																	 	 	 		 			    	BeanUtils.copyProperties(infcPkgYe162030Vo, infcPkgYe161010Vo);
																																																										
																																																		 	 	 		 			     infcPkgYe162030Vo.setHsngPrptSvngAccNo(MSFSharedUtils.allowNulls(tempMap01.get("hsngPrptSvngAccNo")) );
																																																	 	 	 		 			         infcPkgYe162030Vo.setHsngPrptSvngSvngCl(MSFSharedUtils.allowNulls(tempMap01.get("hsngPrptSvngSvngCl")) );
																																																	 	 	 		 			         BigDecimal bgHsngPrptSvngPymAmt = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap01.get("hsngPrptSvngPymAmt"),"0"));
																																																	 	 	 		 			         
																																																	 	 	 		 			         BigDecimal hsngDdcPymAmt =  bgHsngPrptSvngPymAmt.multiply(new BigDecimal("0.40")).setScale(0, BigDecimal.ROUND_DOWN);
																																																 	 	 		 			         
																																																 	 	 		 			    	 if ("Y0040050".equals(MSFSharedUtils.allowNulls(tempMap01.get("hsngPrptSvngSvngCl")))) {
																																																 	 	 		 			    		// '주택마련저축-청약저축' THEN 'Y0040050'
																																																 	 	 		 		               
																																																 	 	 		 			    	    if (bgYetaC100.compareTo(hsngDdcPymAmt) > 0) {
																																																 	 	 		 			    	    	infcPkgYe162030Vo.setHsngPrptSvngIncDdcAmt(hsngDdcPymAmt); 
																																																 	 	 		 			    	        bgYetaC100 = bgYetaC100.subtract(hsngDdcPymAmt);
																																																 	 	 		 			    	    } else {
																																																 	 	 		 			    	    	
																																																 	 	 		 			    	    	infcPkgYe162030Vo.setHsngPrptSvngIncDdcAmt(bgYetaC100); 
																																																 	 	 		 			    	        bgYetaC100 = BigDecimal.ZERO;
																																																 	 	 		 			    	    } 
																																																 	 	 		 			    	   } else if("Y0040060".equals(MSFSharedUtils.allowNulls(tempMap01.get("hsngPrptSvngSvngCl")))) {
																																																 	 	 		 			    		// '주택마련저축-주택청약종합저축' THEN 'Y0040060' 
																																																 	 	 		 			             
																																																 	 	 		 			    	    if (bgYetaC101.compareTo(hsngDdcPymAmt) > 0) {
																																																 	 	 		 			    	    	infcPkgYe162030Vo.setHsngPrptSvngIncDdcAmt(hsngDdcPymAmt); 
																																																 	 	 		 			    	        bgYetaC101 = bgYetaC101.subtract(hsngDdcPymAmt);
																																																 	 	 		 			    	    } else {
																																																 	 	 		 			    	    	
																																																 	 	 		 			    	    	infcPkgYe162030Vo.setHsngPrptSvngIncDdcAmt(bgYetaC101); 
																																																 	 	 		 			    	        bgYetaC101 = BigDecimal.ZERO;
																																																 	 	 		 			    	    }
																																																 	 	 		 			    		
																																																 	 	 		 			    	 } else if("Y0040080".equals(MSFSharedUtils.allowNulls(tempMap01.get("hsngPrptSvngSvngCl")))) {
																																																	 	 	 		 			    		//  '주택마련저축-근로자주택마련저축' THEN 'Y0040080'
																																																	 	 	 		 			    	    
																																																	 	 	 		 			    	    if (bgYetaC102.compareTo(hsngDdcPymAmt) > 0) {
																																																	 	 	 		 			    	    	infcPkgYe162030Vo.setHsngPrptSvngIncDdcAmt(hsngDdcPymAmt); 
																																																	 	 	 		 			    	        bgYetaC102 = bgYetaC102.subtract(hsngDdcPymAmt);
																																																	 	 	 		 			    	    } else {
																																																	 	 	 		 			    	    	
																																																	 	 	 		 			    	    	infcPkgYe162030Vo.setHsngPrptSvngIncDdcAmt(bgYetaC102); 
																																																	 	 	 		 			    	        bgYetaC102 = BigDecimal.ZERO;
																																																	 	 	 		 			    	    }
																																																	 	 	 		 			    			   
																																																 	 	 		 			    	   }  
																																																 	 	 		 			    	 
																																																 	 	 		 			    	    infcPkgYeta7300.updateYeta7300_Tax_YE162030_01(infcPkgYe162030Vo) ;  
																																																	 	 	 		 			    	
																																																	 	 	 		 			     }	 
																																																	 	 	 		 			     
																																																	 	 	 		 			    InfcPkgYe162040Srh_2022_VO   ye162040SrhVo = new InfcPkgYe162040Srh_2022_VO();	 
																																																	 	 							BeanUtils.copyProperties(ye162040SrhVo, infcPkgYe161010Vo); 
																																																	 	 							
																																																 	 	 		 			  		 List lstPkgYe162040Vo =  infcPkgYeta7300.fnYeta7300_YE162040_Tax_2022_A01_Select(ye162040SrhVo);
																																																 	 	 		 			  		 
																																																 	 	 		 			  		 //2022년연말정산_추가
																																																 	 	 		 			  		 //청년형 추가
																																																 	 	 		 			     	 BigDecimal bgYetaC109 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC109"),"0"));
																																																 	 	 		 			     	 BigDecimal bgYetaC109y = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC109y"),"0"));
																																																 	 	 		 			     	 
																																																		 	 	 		 			     for (int iCnt03 = 0;iCnt03 < lstPkgYe162040Vo.size();iCnt03++) {
																																																		 	 	 		 			    	InfcPkgYe162040_2022_VO    infcPkgYe162040Vo	 = new InfcPkgYe162040_2022_VO();	//F_장기집합투자증권저축_B1013
																																																										
																																																		 	 	 		 			    	 Map tempMap01 = (Map)lstPkgYe162040Vo.get(iCnt03); 
																																																		 	 	 		 			    	 
																																																		 	 	 		 			    	BeanUtils.copyProperties(infcPkgYe162040Vo, infcPkgYe161010Vo);
																																																											
																																																		 	 	 		 			      infcPkgYe162040Vo.setLtrmCniSsAccno(MSFSharedUtils.allowNulls(tempMap01.get("ltrmCniSsAccno")) );
																																																		 	 	 		 		    	  infcPkgYe162040Vo.setLtrmCniSsfnnCl(MSFSharedUtils.allowNulls(tempMap01.get("ltrmCniSsfnnCl")) );
																																																		 	 	 		 		    	  infcPkgYe162040Vo.setDatCd(MSFSharedUtils.allowNulls(tempMap01.get("datCd")) );
																																																	 	 	 		 			          BigDecimal bgLtrmCniSsPymAmt = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap01.get("ltrmCniSsPymAmt"),"0"));
																																																	 	 	 		 			     
																																																	 	 	 		 			    	 if ("Y0040110".equals(MSFSharedUtils.allowNulls(tempMap01.get("ltrmCniSsfnnCl")))) {
																																																	 	 	 		 			    		// 장기집합투자증권저축_B1013
																																																	 	 	 		 			    		 
																																																	 	 	 		 			    		 //장기집합투자증권저축 G0029
																																																	 	 	 		 			    		 if("G0029".equals(MSFSharedUtils.allowNulls(tempMap01.get("datCd")))){
																																																	 	 	 		 			    			 
																																																	 	 	 		 			    			if (bgYetaC109.compareTo(bgLtrmCniSsPymAmt) > 0) {
																																																			 	 	 		 			    	    infcPkgYe162040Vo.setLtrmCniSsIncDdcAmt(bgLtrmCniSsPymAmt); 
																																																			 	 	 		 			    	    bgYetaC109 = bgYetaC109.subtract(bgLtrmCniSsPymAmt);
																																																			 	 	 		 			    	    } else {
																																																			 	 	 		 			    	    	
																																																			 	 	 		 			    	    infcPkgYe162040Vo.setLtrmCniSsIncDdcAmt(bgYetaC109); 
																																																			 	 	 		 			    	    bgYetaC109 = BigDecimal.ZERO;
																																																			 	 	 		 			    	    }
																																																	 	 	 		 			    		 } else if ("G0043".equals(MSFSharedUtils.allowNulls(tempMap01.get("datCd")))){
																																																	 	 	 		 			    			if (bgYetaC109y.compareTo(bgLtrmCniSsPymAmt) > 0) {
																																																			 	 	 		 			    	    infcPkgYe162040Vo.setLtrmCniSsIncDdcAmt(bgLtrmCniSsPymAmt); 
																																																			 	 	 		 			    	    bgYetaC109y = bgYetaC109y.subtract(bgLtrmCniSsPymAmt);
																																																			 	 	 		 			    	    } else {
																																																			 	 	 		 			    	    	
																																																			 	 	 		 			    	    infcPkgYe162040Vo.setLtrmCniSsIncDdcAmt(bgYetaC109y); 
																																																			 	 	 		 			    	    bgYetaC109y = BigDecimal.ZERO;
																																																			 	 	 		 			    	    }
																																																	 	 	 		 			    		 }
																																																	 	 	 		 			    	 
																																																	 	 	 		 			    	    
																																																	 	 	 		 			    	   } 
																																																	 	 	 		 			      	infcPkgYeta7300.updateYeta7300_Tax_YE162040_01(infcPkgYe162040Vo) ;      
																																																				 	 	 		 			  
																																																		 	 	 		 			     }	 
																																																								      //월세액거주자간 주책임차차임금 원리금상환 
																																																									
																																																									
																																																									   InfcPkgYe162510Srh_2022_VO   ye162510SrhVo = new InfcPkgYe162510Srh_2022_VO();	 
																																																		 	 							BeanUtils.copyProperties(ye162510SrhVo, infcPkgYe161010Vo); 
																																																		 	 							
																																																									  List lstPkgYe162510Vo =  infcPkgYeta7300.fnYeta7300_YE162510_Tax_2022_A01_Select(ye162510SrhVo);
																																																 	 	 		 			     	 BigDecimal bgYetaC156 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC156"),"0"));
																																																		 	 	 		 			     for (int iCnt03 = 0;iCnt03 < lstPkgYe162510Vo.size();iCnt03++) {
																																																		 	 	 		 			    	
																																																		 	 	 		 			    	 InfcPkgYe162510_2022_VO    infcPkgYe162510Vo	 = new InfcPkgYe162510_2022_VO();	//G_월세액소득공제명세
																																																										 	BeanUtils.copyProperties(infcPkgYe162510Vo, infcPkgYe161010Vo);
																																										  
																																																		 	 	 		 			    	 Map tempMap01 = (Map)lstPkgYe162510Vo.get(iCnt03); 
																																																		 	 	 		 			    	  
																																																		 	 	 		 			    	infcPkgYe162510Vo.setMnthRntQntySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap01.get("mnthRntQntySeilNum"),"0")) ); 
																																																	 	 	 		 			          
																																																		 	 	 		 			    	BigDecimal bgMnthRnttyYrlyMnthSum = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap01.get("mnthRnttyYrlyMnthSum"),"0"));
																																																	 	 	 		 			      
																																																	 	 	 		 			    	    if (bgYetaC156.compareTo(bgMnthRnttyYrlyMnthSum) > 0) {
																																																	 	 	 		 			    	      infcPkgYe162510Vo.setMnthRnttyYrlyTgtSum(bgMnthRnttyYrlyMnthSum); 
																																																	 	 	 		 			    	      bgYetaC156 = bgYetaC156.subtract(bgMnthRnttyYrlyMnthSum);
																																																	 	 	 		 			    	      
																																																	 	 	 		 			    	    } else {
																																																	 	 	 		 			    	    	
																																																	 	 	 		 			    	     infcPkgYe162510Vo.setMnthRnttyYrlyTgtSum(bgYetaC156); 
																																																	 	 	 		 			    	     bgYetaC156 = BigDecimal.ZERO;
																																																	 	 	 		 			    	    }
																																																	 	 	 		 			    	    
																																																	 	 	 		 			    	    infcPkgYeta7300.updateYeta7300_Tax_Ye162510_01(infcPkgYe162510Vo) ; 
																																																	 	 	 		 			    	 
																																																				 	 	 		 			  
																																																		 	 	 		 			     }	 
																																																		 	 	 		 			 
																																																		 	 	 		 			    InfcPkgYe162510_2022_VO    infcPkgYe162510Vo	 = new InfcPkgYe162510_2022_VO();	//G_월세액소득공제명세
																																																									 	BeanUtils.copyProperties(infcPkgYe162510Vo, infcPkgYe161010Vo);  
																																																	 	 	 		 			         infcPkgYeta7300.updateYeta7300_Tax_Ye162510_02(infcPkgYe162510Vo) ;      
																																																									   
																																																		 	 	 		 			    
																																																		 	 	 		 			     InfcPkgYe162520Srh_2022_VO   ye162520SrhVo = new InfcPkgYe162520Srh_2022_VO();	 
																																																		 	 							 BeanUtils.copyProperties(ye162520SrhVo, infcPkgYe161010Vo); 
																																																										 
																																																										 List lstPkgYe162520Vo =  infcPkgYeta7300.fnYeta7300_YE162520_Tax_2022_A01_Select(ye162520SrhVo);
																																																	 	 	 		 			     	 Long bgYeta0c84 = Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c84"),"0"));
																																																			 	 	 		 			     for (int iCnt03 = 0;iCnt03 < lstPkgYe162520Vo.size();iCnt03++) {
																																																			 	 	 		 		
																																																			 	 	 		 			    	 InfcPkgYe162520_2022_VO    infcPkgYe162520Vo	 = new InfcPkgYe162520_2022_VO();	//G_거주자간_금전소비대차
																																																			 	 	 		 			    	 //	InfcPkgYe162530VO    infcPkgYe162530Vo	 = new InfcPkgYe162530VO();	//G_임대차계약
																																																			 	 	 		 			    	 BeanUtils.copyProperties(infcPkgYe162520Vo, infcPkgYe161010Vo);
																																																			 	 	 		 			    	 //	BeanUtils.copyProperties(infcPkgYe162530Vo, infcPkgYe161010Vo);
																																																											
																																																			 	 	 		 			    	 Map tempMap01 = (Map)lstPkgYe162520Vo.get(iCnt03); 
																																																			 	 	 		 			     
																																																			 	 	 		 			    	infcPkgYe162520Vo.setComrCalnSeilNum(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap01.get("comrCalnSeilNum"),"0"))); 
																																																		 	 	 		 			        
																																																			 	 	 		 			        Long bgComrItrtSum = Long.parseLong(MSFSharedUtils.defaultNulls(tempMap01.get("comrItrtSum"),"0"));
																																																		 	 	 		 			         
																																																		 	 	 		 			    	    if (bgYeta0c84.compareTo(bgComrItrtSum) > 0) {
																																																		 	 	 		 			    	    infcPkgYe162520Vo.setComrDducSum(bgComrItrtSum); 
																																																		 	 	 		 			    	    bgYeta0c84 = bgYeta0c84 - bgComrItrtSum;
																																																		 	 	 		 			    	    } else {
																																																		 	 	 		 			    	    	
																																																		 	 	 		 			    	    infcPkgYe162520Vo.setComrDducSum(bgYeta0c84); 
																																																		 	 	 		 			    	     bgYeta0c84 = 0L;
																																																		 	 	 		 			    	    }
																																																		 	 	 		 			    	 
																																																												 
																																																		 	 	 		 			    	infcPkgYeta7300.updateYeta7300_Tax_Ye162520_01(infcPkgYe162520Vo);    

																																																					}
																																																				}

																																																			}

																																																		}
																																																	}

																																																	/*************************
																																																	 * 대상자별로
																																																	 * 루프
																																																	 * 종료
																																																	 ***************************************************/

																																																}

																																															}
																																														}

																																													}

																																												}

																																												// }
																																											}
																																										}
																																									}
																																								}
																																							}
																																					}
																																												}

																																				}
																																			}
																																		}
																																	}

																																}

																															}
																																					  		}
																														}

																													}

																												}

																											}

																										}
																												  		}
																											  		}
																										  		}
																									  		}
																										}
																											}

																									}
																								}

																							}
																						  }
																						}
																					}

																				}
																			}

																		}
																			// }

																	}

																}

															}

														}
													}
														  			}
														  		}
												}

											}

										}
									}
								}
								// }
							}
						}
					}
				}
			}

		  	 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산]" + String.valueOf(listYe161010VO.size()) + "명처리완료","데이타확인",""));  
		  	 retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());  
		  	   
	  	} catch (Exception ex) {
	  		
           ex.printStackTrace();
	   	   ShowMessageBM smBm = new ShowMessageBM();
	   	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
	   	   smBm.setMenu("Yeta");
	   	   smBm.setPhase("[연말정산세액계산]세액계산 에러");
	   	   smBm.setMessage(ex.getLocalizedMessage());
	   	   smBm.setContent(ex.getMessage());
	   	   bmResult.add(smBm);  
	   	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());   
 	 
    } 
	  	   
	  	  return  retval;
  }
    
  
    
}