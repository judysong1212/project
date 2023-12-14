package com.app.smrmf.pkg.yeta.yeta2017.tax;

import java.math.BigDecimal;
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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe160404VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe160405VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe160406VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe160510VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161050VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161055VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161060VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161070VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161080VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161090VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162010SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162020SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162030SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162040SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162510SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162510VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162520SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162520VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe164010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030TempVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe166010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe166020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010SrhVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010aVO;
import com.app.smrmf.pkg.yeta.yeta2017.tax.service.Yeta2300PayrService;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta2300TaxPkgProc  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta2300TaxPkgProc.class);
	   
    @Resource(name = "Yeta2300PayrService")
    protected Yeta2300PayrService  infcPkgYeta2300;
    
 
    public Yeta2300TaxPkgProc() {
    	
    } 
    
    public PagingLoadResult<ShowMessageBM> execfnYeta2300TaxPkgProc(HttpServletRequest request,List<InfcPkgYe161010VO> listYe161010VO)  throws Exception  {
  	    
	  	  return  funcYeta2300TaxPkgProc(request,  listYe161010VO);
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
    private PagingLoadResult<ShowMessageBM> funcYeta2300TaxPkgProc(HttpServletRequest request,List<InfcPkgYe161010VO> listYe161010VO)  throws Exception  {
    	
  	    PagingLoadResult<ShowMessageBM> retval = null; 
	    List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        
        // 변수선언 
	  	int statCnt = 0;
	  	String dataCheck = "";
	  	String spciDdctCheck = "FALSE";
	  	
		InfcPkgYe160401VO    infcPkgYe160401Vo	 = new InfcPkgYe160401VO();	//현근무지급여지급명세
		InfcPkgYe160402VO    infcPkgYe160402Vo	 = new InfcPkgYe160402VO();	//현근무지비과세_감면소득_과세
		InfcPkgYe160403VO    infcPkgYe160403Vo	 = new InfcPkgYe160403VO();	//현근무지비과세_감면소득_비과세
		
		InfcPkgYe160404VO    infcPkgYe160404Vo	 = new InfcPkgYe160404VO();	//D_종전근무처
		InfcPkgYe160405VO    infcPkgYe160405Vo	 = new InfcPkgYe160405VO();	//D_종전근무처비과세_감면소득_비과세
		InfcPkgYe160406VO    infcPkgYe160406Vo	 = new InfcPkgYe160406VO();	//종전근무지연금보험료_공적연금
		InfcPkgYe160510VO    infcPkgYe160510Vo	 = new InfcPkgYe160510VO();	//근무지별비과세_감면소득
		
//		InfcPkgYe161005VO    infcPkgYe161005Vo	 = new InfcPkgYe161005VO();	//A_원천세신고기본
		
		InfcPkgYe161010VO    infcPkgYe161010Vo	 = new InfcPkgYe161010VO();	// 연말정산대상자기본
		InfcPkgYe161020VO    infcPkgYe161020Vo	 = new InfcPkgYe161020VO();	//A_인적소득공제기본
		InfcPkgYe161030VO    infcPkgYe161030Vo	 = new InfcPkgYe161030VO();	//E_인적공제명세
		InfcPkgYe161040VO    infcPkgYe161040Vo	 = new InfcPkgYe161040VO();	//E_소득세액공제명세
		InfcPkgYe161050VO    infcPkgYe161050Vo	 = new InfcPkgYe161050VO();	//C_연금보험료공제
		InfcPkgYe161055VO    infcPkgYe161055Vo	 = new InfcPkgYe161055VO();	//C_연금보험료_공적연금상세
		InfcPkgYe161060VO    infcPkgYe161060Vo	 = new InfcPkgYe161060VO();	//C_특별소득공제
		InfcPkgYe161070VO    infcPkgYe161070Vo	 = new InfcPkgYe161070VO();	//C_그밖의소득공제
		InfcPkgYe161080VO    infcPkgYe161080Vo	 = new InfcPkgYe161080VO();	//C_세액감면및공제
		InfcPkgYe161090VO    infcPkgYe161090Vo	 = new InfcPkgYe161090VO();	//C_교육비내역
		
		InfcPkgYe164010VO    infcPkgYe164010Vo	 = new InfcPkgYe164010VO();	//A_의료비지급명세
		InfcPkgYe165010VO    infcPkgYe165010Vo	 = new InfcPkgYe165010VO();	//I_해당연도기부금명세
		InfcPkgYe165020VO    infcPkgYe165020Vo	 = new InfcPkgYe165020VO();	//I_기부자관계코드별기부금합계
		InfcPkgYe165030VO    infcPkgYe165030Vo	 = new InfcPkgYe165030VO();	//H_기부금조정명세
		InfcPkgYe165030TempVO infcPkgYe165030TempVo = new InfcPkgYe165030TempVO();  	    //H_기부금조정명세_TEMP	 
		InfcPkgYe166010VO    infcPkgYe166010Vo	 = new InfcPkgYe166010VO();	//신용카드등소득공제명세
		InfcPkgYe166020VO    infcPkgYe166020Vo	 = new InfcPkgYe166020VO();	//신용카드등소득공제상세
			 								 
		InfcPkgYe169010VO    infcPkgYe169010Vo	 = new InfcPkgYe169010VO();	//C_주현근무처
		
		
//	  	BigDecimal  mTemp14Data10 = BigDecimal.ZERO;
// 
//        BigDecimal mTemp14Data40 = BigDecimal.ZERO;
//        BigDecimal mTemp14Data41 = BigDecimal.ZERO;
//        BigDecimal mTempData10  = BigDecimal.ZERO;
//        BigDecimal mTempData30  = BigDecimal.ZERO; 
//        BigDecimal mTempData  = BigDecimal.ZERO;
//        BigDecimal mTempData31  = BigDecimal.ZERO; 
//        BigDecimal mTempData40  = BigDecimal.ZERO; 
//        BigDecimal mTempData41  = BigDecimal.ZERO;
//        BigDecimal mTempData42  = BigDecimal.ZERO;
//        BigDecimal mTempOData10   = BigDecimal.ZERO;
//        BigDecimal mTempOData40  = BigDecimal.ZERO; 
//        BigDecimal mTempOData41  = BigDecimal.ZERO;
//        BigDecimal mTempOData42  = BigDecimal.ZERO;
//        BigDecimal mTemp10Data20 =  BigDecimal.ZERO;  //특별세액공제_기부금_정치자금_10만원이하 공제 대상금액
//        BigDecimal mTempData20   =  BigDecimal.ZERO;   //특별세액공제_기부금_정치자금_10만원이하 공제
//        BigDecimal mTemp10OData20 =  BigDecimal.ZERO;  //특별세액공제_기부금_정치자금_10만원초과  공제 대상금액
//        BigDecimal mTempOData20 =  BigDecimal.ZERO;
//        		
//        BigDecimal exPRDD_TAXN   = BigDecimal.ZERO;
//        BigDecimal exTAXD_ICAX   = BigDecimal.ZERO;
//        BigDecimal exTAXD_SPCT   = BigDecimal.ZERO;
//        BigDecimal exTXLG_CL30   = BigDecimal.ZERO;
//        BigDecimal exTXLG_HXTT   = BigDecimal.ZERO;
//        BigDecimal exTAXD_TSUM   = BigDecimal.ZERO;
//        BigDecimal exTAXD_WKEN   = BigDecimal.ZERO;
//        BigDecimal exADDR_MCCR   = BigDecimal.ZERO;
//        BigDecimal exJRTR_HICT   = BigDecimal.ZERO;
//        BigDecimal exJRTR_PSRN   = BigDecimal.ZERO;
//        BigDecimal exJRTR_HNSV    = BigDecimal.ZERO;
//        BigDecimal exSPCI_RTDE   = BigDecimal.ZERO;
//        BigDecimal exSPCI_TXCR   = BigDecimal.ZERO;
//        BigDecimal exSPED_TXCR   = BigDecimal.ZERO;
//        BigDecimal exTAXD_PLTC   = BigDecimal.ZERO;
//        BigDecimal exSPCI_PLTC   = BigDecimal.ZERO;
//        BigDecimal exSPCI_FBAM   = BigDecimal.ZERO;
//        BigDecimal  exSPCI_RFAM  = BigDecimal.ZERO;
//        BigDecimal exSPCI_NAMT   = BigDecimal.ZERO;
//        BigDecimal exSPCI_DCTO   = BigDecimal.ZERO;
//        BigDecimal exSPCI_DDCT   = BigDecimal.ZERO;
//        BigDecimal exTAXD_UNIN   = BigDecimal.ZERO;
//        BigDecimal exTAXD_LOAN   = BigDecimal.ZERO;
//        BigDecimal exTAXD_PAID   = BigDecimal.ZERO;
//        BigDecimal exSPCI_RTAM   = BigDecimal.ZERO;                  
//        BigDecimal exTAXD_CSUM   = BigDecimal.ZERO;
//        BigDecimal exTpPRDD_TAXN   = BigDecimal.ZERO;
//        BigDecimal exSPCI_YAMT   = BigDecimal.ZERO;
//        BigDecimal exADDR_CHLD   = BigDecimal.ZERO; 
//        BigDecimal exADDR_BRTH   = BigDecimal.ZERO;
//        BigDecimal exSPCI_GURT   = BigDecimal.ZERO;
//        BigDecimal exSPCI_HDRC   = BigDecimal.ZERO;
        
      
	  	  try { 
	  		   
	  		  infcPkgYeta2300 = (Yeta2300PayrService)BeanFinder.getBean("Yeta2300PayrService"); 
		  	 
	  
	     	
             /************************* 대상자별로 루프 시작 ***************************************************/ 

	  		  for (int iCnt01 = 0;iCnt01 < listYe161010VO.size();iCnt01++) {
		  		    
				  		infcPkgYe161010Vo = new InfcPkgYe161010VO();
				  		
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
				  		   infcPkgYeta2300.fnYeta2300_B101Y_YE161080_2017_Update(infcPkgYe161010Vo);
				  		  //주택마련저축정리 
				  		  infcPkgYeta2300.fnYeta2300_TaxPkg01_2017_Update(infcPkgYe161010Vo);  
				  		  //합계처리 
				  		   infcPkgYeta2300.fnYeta2300_All_YE161080_2017_Update(infcPkgYe161010Vo);
				  		
				  	      if (statCnt >= 0) {
						  		// ############## YE161020 부양가족인원수 ##############   
						 		statCnt = 0;
						  		statCnt = infcPkgYeta2300.fnYeta2300_YE161020_Tax_2017_01_Update(infcPkgYe161020Vo);  
						  		if (statCnt >= 0) { 
							  		statCnt = 0;
							  		// ############## YE161055 국민연금등정리 ############## 
							  		statCnt = infcPkgYeta2300.fnYeta2300_YE161055_Tax_2017_02_Update(infcPkgYe161055Vo); 
							  		if (statCnt >= 0) { 
								  		statCnt = 0;
								  		// ############## YE161050 국민연금등합계 ############## 
								  		statCnt = infcPkgYeta2300.fnYeta2300_YE161050_Tax_2017_03_Update(infcPkgYe161050Vo); 
								  		if (statCnt >= 0) { 
//									  		statCnt = 0;
//									  		//국민연금등합계 XXXX
//									  		statCnt = infcPkgYeta2300.fnYeta2300_YE161050_Tax_2017_03_Update(infcPkgYe161050Vo);  
//									  		if (statCnt >= 0) { 
										  		statCnt = 0;
										  		/* ############## YE169010 비과세 정리  ##############  */
										  		statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_04_Update(infcPkgYe169010Vo); 
										  		if (statCnt >= 0) { 
										  		    /**####################### 공제단계 시작 01 총급여등기본공제,추가공제등 공제금액인서트  ############################################*/  
											  		statCnt = 0; 
											  		statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_05_Update(infcPkgYe169010Vo);  
											  		if (statCnt >= 0) {   
										                 /**#######################  {공제단계 시작 -소득공제 02} ############################################*/ 
												  		if (statCnt >= 0) { 
												  		statCnt = 0;
												  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_06_Update(infcPkgYe169010Vo); 	
												  		if (statCnt >= 0) {  
											                 /**#######################  {공제단계 시작 -연금보험료공제 03} ############################################*/ 
											                 //      ---------------------------연금보험료공제-------------------------------------- 
													  		statCnt = 0;
													  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_07_Update(infcPkgYe169010Vo); 
													  		if (statCnt >= 0) {
												                  /**#######################  {공제단계 시작 -특별공제 - 주택임차차임금 상환액  09 } ############################################*/ 
												                  //   ------------------특별공제 - 주택임차차임금 상환액--------------------------- 
														  		statCnt = 0;  //TODO YE161060 작업함
														  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_08_Update(infcPkgYe169010Vo); 
														  		if (statCnt >= 0) { 
												                  /**#######################  {공제단계 시작 -특별공제 - 주택마련저축  10 } ############################################*/ 
															  		statCnt = 0;
															  		statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_09_Update(infcPkgYe169010Vo); 
														  			if (statCnt >= 0) {
													                  /**#######################  {공제단계 시작 -특별공제 - 주택마련저축 합계  10-1 } ############################################*/ 
																  	
																  		statCnt = 0;
																  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_10_Update(infcPkgYe169010Vo); 
																  		if (statCnt >= 0) {
																  			/**#######################  {공제단계 시작 -특별공제 - 장기주택이자상환액  10-2 } ############################################*/
																	  		statCnt = 0;
																	  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_11_Update(infcPkgYe169010Vo); 
																	  		if (statCnt >= 0) { 
																                 /**#######################  {공제단계 시작 -특별공제 - 장기주택이자상환액 고정금리 비거치  10-3 } ############################################*/
																		  		statCnt = 0;
																		  		statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_12_Update(infcPkgYe169010Vo); 
																		  		if (statCnt >= 0) { 
																                  /**#######################  {공제단계 시작 -특별공제 - 장기주택이자상환액 기타 대출  10-4 } ############################################*/
																			  		
																			  		statCnt = 0;
																			  		  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_13_Update(infcPkgYe169010Vo); 
																			  		//if (statCnt >= 0) { 
																			  			 /**#######################  {장기주택이자상환액 2015년이후 고정금리이면서 비거치상환 대출 } ############################################*/ 
																				  		statCnt = 0;
																				  		statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_14_Update(infcPkgYe169010Vo);  
																				  		if (statCnt >= 0) { 
																				  		   /**#######################  기타로직  등 계산 로직 ############################################*/ 
																					  		statCnt = 0;
																					  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_15_Update(infcPkgYe169010Vo); 
																					  		if (statCnt >= 0) {
																				                /**#######################  투자조합출자등소득공제 2015년  ############################################*/ 
																						  		 statCnt = 0;
																						  		 statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_16_Update(infcPkgYe161070Vo);
																						  		 if (statCnt >= 0) {
																					                /**#######################  투자조합출자등소득공제 2016년  ############################################*/ 
																							  		 statCnt = 0;
																							  		 statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_17_Update(infcPkgYe161070Vo); 
																							  		 if (statCnt >= 0) {
																							  			statCnt = 0;
																								  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_18_Update(infcPkgYe161070Vo); 
																								  		if (statCnt >= 0) {	
																							                 /**#######################  신용카드  등 계산 로직  ############################################*/ 
																									  		statCnt = 0;
																									  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_19_Update(infcPkgYe169010Vo); 
																									  		if (statCnt >= 0) {
																								                 /**#######################  {공제단계 시작 -연금보험료공제 연금보험료공제  대상금액 04}  ############################################*/																										  		
																										  		statCnt = 0;
																										  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_20_Update(infcPkgYe169010Vo); 
																										  		if (statCnt >= 0) {
																								                   /**#######################  {공제단계 시작 -연금보험료공제 03_1 대상금액 구하는 로직 추가  05}############################################*/
																									                 // ---------------------------연금보험료공제-------------------------------------- 
																											  		statCnt = 0;
																											  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_21_Update(infcPkgYe169010Vo); 
																											  		if (statCnt >= 0) { 
																										                 /**#######################  {공제단계 시작 -특별공제 - 보장성/장애인  보험료  06} ############################################*/
																												  	
																												  		statCnt = 0;
																												  		statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_22_Update(infcPkgYe169010Vo); 
																												  		if (statCnt >= 0) {
																											                 /**#######################  특별공제 - 보험료 ############################################*/

																													  		statCnt = 0;
																													  		statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_23_Update(infcPkgYe169010Vo); 
																													  		if (statCnt >= 0) {
																												                 /**#######################  {공제단계 시작 -특별공제 - 의료비 대상금액  07 - 1} ############################################*/
																														  	
																														  		statCnt = 0;
																														  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_24_Update(infcPkgYe169010Vo); 
																														  		if (statCnt >= 0) { 
																												                  /**#######################  {공제단계 시작 -특별공제 - 의료비   07 -2 } ############################################*/
//																													               -----------------------특별공제 - 의료비 ------------------
																															  		
																															  		statCnt = 0;
																															  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_25_Update(infcPkgYe161080Vo); 
																															  		if (statCnt >= 0) {
																															  			statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_25_01_Update(infcPkgYe161080Vo); 
																														                 /**####################### {공제단계 시작 -특별공제 - 교육비   08 -1 }  ############################################*/   
																													                  //    ----------------------특별공제 - 교육비 ---------------------
																															  		          //TODO YE161080 에작업함 
																																	  		statCnt = 0;
																																	  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_26_Update(infcPkgYe161080Vo); 
																																	  		if (statCnt >= 0) { 
																																                 /**#######################  {공제단계 시작 -특별공제 - 교육비 공제  08 -2 }  ############################################*/
																																		  		statCnt = 0;
																																		  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_27_Update(infcPkgYe161080Vo);
																																		  		if (statCnt >= 0) { 
																																			        /**####################### {공제단계 시작 -특별공제 - 기부금관계코드 오류 정정  11 }  ############################################*/
																																	                 //   -------------------------기부금관계코드 오류 정정  ------------------------------
//																																			  		statCnt = 0;
//																																			  		statCnt =  infcPkgYeta2300.fnPayr06430_PAYR425_ReTax_2016_CREATE_06_1_Update(infcPkgYe161010Vo); 
//																																			  		if (statCnt >= 0) { 
//																																			  			
//																																			  			
//																																			  		}
																																		  			
																																                  /**#######################  {공제단계 시작 -특별공제 - 기부금공제   12   }  ############################################*/
																																	                 //   -------------------------기부금공제 1 -이전월 포함.------------------------------
																																			  		
																																			  		statCnt = 0;
																																			  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_29_Update(infcPkgYe169010Vo); 
																																			  		if (statCnt >= 0) {  
																																		                 /**#######################  기부금공제 1 -귀속년도 법정기부금 ############################################*/
																																				  		statCnt = 0;
																																				  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_30_Update(infcPkgYe169010Vo); 
																																				  		if (statCnt >= 0) { 
																																		                   /**#######################  기부금공제 1 -귀속년도 법정기부금. ############################################*/
																																					  		//여기부터 
																																					  		statCnt = 0;
																																					  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_31_Update(infcPkgYe169010Vo);
																																					  		if (statCnt >= 0) {
																																					  			statCnt = 0;
																																						  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_31_01_Update(infcPkgYe169010Vo);
																																						  		if (statCnt >= 0) {
																																						  			
																																					  			
																																				                 /**#######################  이전월 기부금공제 특례기부금공제, 현재년도 우리사주조합2 ############################################*/
																																						  		
//																																						  		statCnt = 0;
//																																						  		statCnt =  infcPkgYeta2300.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_01_Update(infcPkgYe161010Vo);
//																																						  		if (statCnt >= 0) { 
//																																						  		}

     /**#######################   현재년도 우리사주조합 대상금액 구하기  ############################################*/
	
	statCnt = 0;
	statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_32_Update(infcPkgYe169010Vo); 
	if (statCnt >= 0) {
      /**#######################  기부금공제 2013년도 이전 종교단체/외 이월 기부금  ############################################*/
		statCnt = 0;   //TODO YE161060 작업함 
		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_33_Update(infcPkgYe161060Vo); 		
		if (statCnt >= 0) {
			statCnt = 0;   //TODO YE161060 작업함 
			statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_33_02_Update(infcPkgYe161060Vo); 		
			if (statCnt >= 0) {	
				statCnt = 0;   //TODO YE161060 작업함 
				statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_33_03_Update(infcPkgYe169010Vo); 		
				if (statCnt >= 0) {	
					statCnt = 0;   //TODO YE161060 작업함 
					statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_33_04_Update(infcPkgYe169010Vo); 		
					if (statCnt >= 0) {		
          /**#######################  기부금공제 특례기부금공제,당해년도 종교단체기부금 대상금액 ############################################*/
 		
 		statCnt = 0;
 		statCnt =  infcPkgYeta2300.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_021_Update(infcPkgYe169010Vo); 
 		statCnt =  infcPkgYeta2300.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_022_Update(infcPkgYe169010Vo); 
 		if (statCnt >= 0) {
          /**#######################  기부금공제  2014 년도 종교단체기부금 대상금액 ############################################*/
	  	
	  		statCnt = 0;
	  		statCnt =  infcPkgYeta2300.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_031_Update(infcPkgYe169010Vo); 
	  		statCnt =  infcPkgYeta2300.fnPayr06430_PAYR425_ReTax_2016_CREATE_09_032_Update(infcPkgYe169010Vo); 
	  		if (statCnt >= 0) {
              /**#######################  기부금공제 3 불러와서 년도별 수정하는걸로 변경함 ############################################*/ 
	  			
	  	         List listYetaGibu = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_TgYear_Select(infcPkgYe169010Vo); 
	             
	             if  (listYetaGibu.size() > 0) {
	            	   
	            	    Iterator<Map<String, Object>> iter = listYetaGibu.iterator(); 
		        	   
			            while ( iter.hasNext() ) { 
			            	
			               Map<String, Object> mapYetaGibu = (Map<String, Object>) iter.next(); 
			               
			               BigDecimal bgSPCI_FB14_10    = BigDecimal.ZERO;
			               BigDecimal bgSPCI_FB15_10    = BigDecimal.ZERO;
			               BigDecimal bgSPCI_FB16_10    = BigDecimal.ZERO;
			               BigDecimal bgSPCI_FB17_10    = BigDecimal.ZERO;
			               BigDecimal bgSPCI_FBTG14_10  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_FBTG15_10  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_FBTG16_10  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_FBTG17_10  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_FBSE14_10  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_FBSE15_10  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_FBSE16_10  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_FBSE17_10  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_NA14_40    = BigDecimal.ZERO;
			               BigDecimal bgSPCI_NA15_40    = BigDecimal.ZERO;
			               BigDecimal bgSPCI_NA16_40    = BigDecimal.ZERO;
			               BigDecimal bgSPCI_NA17_40    = BigDecimal.ZERO;
			               BigDecimal bgSPCI_NATG14_40  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_NATG15_40  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_NATG16_40  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_NATG17_40  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_NASE14_40  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_NASE15_40  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_NASE16_40  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_NASE17_40  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_YA14_41    = BigDecimal.ZERO;
			               BigDecimal bgSPCI_YA15_41    = BigDecimal.ZERO;
			               BigDecimal bgSPCI_YA16_41    = BigDecimal.ZERO;
			               BigDecimal bgSPCI_YA17_41    = BigDecimal.ZERO;
			               BigDecimal bgSPCI_YATG14_41  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_YATG15_41  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_YATG16_41  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_YATG17_41  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_YASE14_41  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_YASE15_41  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_YASE16_41  = BigDecimal.ZERO;
			               BigDecimal bgSPCI_YASE17_41  = BigDecimal.ZERO;
			               
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
			               
			               bgSPCI_FB14_10= new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb1410"),"0"));
			               bgSPCI_FB15_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb1510"),"0"));
			               bgSPCI_FB16_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb1610"),"0"));
			               bgSPCI_FB17_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb1710"),"0"));
			               bgSPCI_FBTG14_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg1410"),"0"));
			               bgSPCI_FBTG15_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg1510"),"0"));
			               bgSPCI_FBTG16_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg1610"),"0"));
			               bgSPCI_FBTG17_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg1710"),"0"));
			               bgSPCI_FBSE14_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse1410"),"0"));
			               bgSPCI_FBSE15_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse1510"),"0"));
			               bgSPCI_FBSE16_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse1610"),"0"));
			               bgSPCI_FBSE17_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse1710"),"0"));
			               bgSPCI_NA14_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1440"),"0"));
			               bgSPCI_NA15_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1540"),"0"));
			               bgSPCI_NA16_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1640"),"0"));
			               bgSPCI_NA17_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1740"),"0"));
			               bgSPCI_NATG14_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg1440"),"0"));
			               bgSPCI_NATG15_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg1540"),"0"));
			               bgSPCI_NATG16_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg1640"),"0"));
			               bgSPCI_NATG17_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg1740"),"0"));
			               bgSPCI_NASE14_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase1440"),"0"));
			               bgSPCI_NASE15_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase1540"),"0"));
			               bgSPCI_NASE16_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase1640"),"0"));
			               bgSPCI_NASE17_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase1740"),"0"));
			               bgSPCI_YA14_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1441"),"0"));
			               bgSPCI_YA15_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1541"),"0"));
			               bgSPCI_YA16_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1641"),"0"));
			               bgSPCI_YA17_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1741"),"0"));
			               bgSPCI_YATG14_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg1441"),"0"));
			               bgSPCI_YATG15_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg1541"),"0"));
			               bgSPCI_YATG16_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg1641"),"0"));
			               bgSPCI_YATG17_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg1741"),"0"));
			               bgSPCI_YASE14_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase1441"),"0"));
			               bgSPCI_YASE15_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase1541"),"0"));
			               bgSPCI_YASE16_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase1641"),"0"));
			               bgSPCI_YASE17_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase1741"),"0"));
			               
			               
			               bgYETA_C141=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC141"),"0"));
			               bgYETA_C143=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC143"),"0"));
			               bgYETA_C147=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC147"),"0"));
			               
			              
			               BigDecimal bgYETA_C142=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC142"),"0"));
			               BigDecimal bgYETA_C144=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC144"),"0"));
			           	 
				               
				               
 		 			        InfcPkgYe169010VO     inputYe169010Vo = new InfcPkgYe169010VO();	//C_주현근무처 
 	 		 			//  	InfcPkgYe161060VO    inputYe161060Vo	 = new InfcPkgYe161060VO();	//C_특별소득공제
 						//	InfcPkgYe161070VO    inputYe161070Vo	 = new InfcPkgYe161070VO();	//C_그밖의소득공제
 							InfcPkgYe161080VO    inputYe161080Vo	 = new InfcPkgYe161080VO();	//C_세액감면및공제
 						//	BeanUtils.copyProperties(inputYe161060Vo, infcPkgYe161010Vo);
 						//	BeanUtils.copyProperties(inputYe161070Vo, infcPkgYe161010Vo);
 							BeanUtils.copyProperties(inputYe161080Vo, infcPkgYe161010Vo);
 							BeanUtils.copyProperties(inputYe169010Vo, infcPkgYe161010Vo); 	
	 	 							
	 	 							
			               //누적 데이타 시작 점  
			               		               
			               bgYetaSumAll = bgYETA_C141.add(bgYETA_C143); //정치자금 기부금  합산
			               bgYetaAllSumSe = bgYETA_C142.add(bgYETA_C144); //정치자금 기부금  합산
			               
			               
			               //당해년도 법정기부금
			               if (bgSPCI_FBTG17_10.compareTo(BigDecimal.ZERO) > 0) {
			            	
			            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10);
					             
				                if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
				                	
				                	bgSPCI_FBSE17_10 = bgSPCI_FBTG17_10.multiply(new BigDecimal("0.15"));
				                	
				                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
				                	
				                	bgSPCI_FBSE17_10 = bgSPCI_FBTG17_10.multiply(new BigDecimal("0.30"));
				                }
				                
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE17_10);
				                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG17_10);
				                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE17_10);
			               } 
			             
			               //법정기부금 2014			               
			               if (bgSPCI_FBTG14_10.compareTo(BigDecimal.ZERO) > 0) {
				            	
			            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG14_10);
					             
				                if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) <= 0 ) {
				                	
				                	bgSPCI_FBSE14_10 = bgSPCI_FBTG14_10.multiply(new BigDecimal("0.15"));
				                	
				                } else if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) > 0 )  {
				                	
				                	bgSPCI_FBSE14_10 = bgSPCI_FBTG14_10.multiply(new BigDecimal("0.25"));
				                }
				                
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE14_10);
				                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG14_10);
				                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE14_10);
			               }  
			               
			               //법정기부금 2015
			               if (bgSPCI_FBTG15_10.compareTo(BigDecimal.ZERO) > 0) {
				            	
			            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG15_10);
					             
				                if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) <= 0 ) {
				                	
				                	bgSPCI_FBSE15_10 = bgSPCI_FBTG15_10.multiply(new BigDecimal("0.15"));
				                	
				                } else if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) > 0 )  {
				                	
				                	bgSPCI_FBSE15_10 = bgSPCI_FBTG15_10.multiply(new BigDecimal("0.25"));
				                }
				                
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE15_10);
				                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG15_10);
				                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE15_10);
			               } 
			            
			               //법정기부금 2016
			               if (bgSPCI_FBTG16_10.compareTo(BigDecimal.ZERO) > 0) {
				            	
			            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10);
					             
				                if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
				                	
				                	bgSPCI_FBSE16_10 = bgSPCI_FBTG16_10.multiply(new BigDecimal("0.15"));
				                	
				                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
				                	
				                	bgSPCI_FBSE16_10 = bgSPCI_FBTG16_10.multiply(new BigDecimal("0.30"));
				                }
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE16_10);
				                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG16_10);
				                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE16_10);
			               }
			             
			               //우리사주조합기부금
			               if (bgYETA_C147.compareTo(BigDecimal.ZERO) > 0) {
				            	
			            	   bgYetaSumAll = bgYetaSumAll.add(bgYETA_C147);
					             
				                if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
				                	
				                	bgYETA_C148 = bgYETA_C147.multiply(new BigDecimal("0.15"));
				                	
				                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
				                	
				                	bgYETA_C148 = bgYETA_C147.multiply(new BigDecimal("0.30"));
				                }
				                
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgYETA_C148);
				                
			               }  
			               
			               
			                
			               //당해연도 종교단체외 지정기부금
			               if (bgSPCI_NATG17_40.compareTo(BigDecimal.ZERO) > 0) {
				            	
			            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
					             
				                if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
				                	
				                	bgSPCI_NASE17_40 = bgSPCI_NATG17_40.multiply(new BigDecimal("0.15"));
				                	
				                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
				                	
				                	bgSPCI_NASE17_40 = bgSPCI_NATG17_40.multiply(new BigDecimal("0.30"));
				                }
				                
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE17_40);
				                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG17_40);
				                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE17_40);
				                
			               } 
			             
			              
		         
			               //종교단체외 2014
			            	               
			               if (bgSPCI_NATG14_40.compareTo(BigDecimal.ZERO) > 0) {
				            	
			            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG14_40);
					             
				                if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) <= 0 ) {
				                	
				                	bgSPCI_NASE14_40 = bgSPCI_NATG14_40.multiply(new BigDecimal("0.15"));
				                	
				                } else if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) > 0 )  {
				                	
				                	bgSPCI_NASE14_40 = bgSPCI_NATG14_40.multiply(new BigDecimal("0.25"));
				                }
				                
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE14_40);
				                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG14_40);
				                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE14_40);
			               }  
			               
			               
			               //종교단체외 2015
			               if (bgSPCI_NATG15_40.compareTo(BigDecimal.ZERO) > 0) {
				            	
			            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG15_40);
					             
				                if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) <= 0 ) {
				                	
				                	bgSPCI_NASE15_40 = bgSPCI_NATG15_40.multiply(new BigDecimal("0.15"));
				                	
				                } else if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) > 0 )  {
				                	
				                	bgSPCI_NASE15_40 = bgSPCI_NATG15_40.multiply(new BigDecimal("0.25"));
				                }
				                
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE15_40);
				                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG15_40);
				                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE15_40);
			               } 
			               
			               //종교단체외 2016
			               if (bgSPCI_NATG16_40.compareTo(BigDecimal.ZERO) > 0) {
				            	
			            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
					             
				                if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
				                	
				                	bgSPCI_NASE16_40 = bgSPCI_NATG16_40.multiply(new BigDecimal("0.15"));
				                	
				                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
				                	
				                	bgSPCI_NASE16_40 = bgSPCI_NATG16_40.multiply(new BigDecimal("0.30"));
				                }
				                
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE16_40);
				                
				                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG16_40);
				                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE16_40);
			               } 
			               
 
			               
			               	//당해연도 종교단체 지정기부금 
			               if (bgSPCI_YATG17_41.compareTo(BigDecimal.ZERO) > 0) {
				            	
			            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41);
					             
				                if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
				                	
				                	bgSPCI_YASE17_41 = bgSPCI_YATG17_41.multiply(new BigDecimal("0.15"));
				                	
				                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
				                	
				                	bgSPCI_YASE17_41 = bgSPCI_YATG17_41.multiply(new BigDecimal("0.30"));
				                }
				                
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE17_41);
				                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG17_41);
				                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE17_41);
			               } 
			             
				               
			               //종교단체 2014 
			               if (bgSPCI_YATG14_41.compareTo(BigDecimal.ZERO) > 0) {
				            	
			            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG14_41);
					             
				                if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) <= 0 ) {
				                	
				                	bgSPCI_YASE14_41 = bgSPCI_YATG14_41.multiply(new BigDecimal("0.15"));
				                	
				                } else if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) > 0 )  {
				                	
				                	bgSPCI_YASE14_41 = bgSPCI_YATG14_41.multiply(new BigDecimal("0.25"));
				                }
				                
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE14_41);
				                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG14_41);
				                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE14_41);
			               }  
			               
			               
			               //종교단체 2015
			               if (bgSPCI_YATG15_41.compareTo(BigDecimal.ZERO) > 0) {
				            	
			            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG15_41);
					             
				                if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) <= 0 ) {
				                	
				                	bgSPCI_YASE15_41 = bgSPCI_YATG15_41.multiply(new BigDecimal("0.15"));
				                	
				                } else if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) > 0 )  {
				                	
				                	bgSPCI_YASE15_41 = bgSPCI_YATG15_41.multiply(new BigDecimal("0.25"));
				                }
				                
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG15_41);
				                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG15_41);
				                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE15_41);
			               } 
			               
			               //종교단체 2016
			               if (bgSPCI_YATG16_41.compareTo(BigDecimal.ZERO) > 0) {
				            	
			            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG16_41);
					             
				                if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
				                	
				                	bgSPCI_YASE16_41 = bgSPCI_YATG16_41.multiply(new BigDecimal("0.15"));
				                	
				                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
				                	
				                	bgSPCI_YASE16_41 = bgSPCI_YATG16_41.multiply(new BigDecimal("0.30"));
				                }
				                
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE16_41);
				                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG16_41);
				                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE16_41);
			               }  
			               
							//inputYe161080Vo.setConb10ttswLtUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conb10ttswLtUseAmt"),"0")));    /** column 기부금_정치자금기부금10이하기부금 : conb10ttswLtUseAmt */
							//inputYe161080Vo.setConb10ttswLtDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conb10ttswLtDdcTrgtAmt"),"0")));    /** column 기부금_정치자금기부금10이하공제대상금액 : conb10ttswLtDdcTrgtAmt */
							//inputYe161080Vo.setConb10ttswLtDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conb10ttswLtDdcAmt"),"0")));    /** column 기부금_정치자금기부금10이하공제세액 : conb10ttswLtDdcAmt */
							//inputYe161080Vo.setConb10excsLtUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conb10excsLtUseAmt"),"0")));    /** column 기부금_정치자금기부금10초과기부금액 : conb10excsLtUseAmt */
							//inputYe161080Vo.setConb10excsLtDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conb10excsLtDdcTrgtAmt"),"0")));    /** column 기부금_정치자금기부금10초과공제대상금액 : conb10excsLtDdcTrgtAmt */
							//inputYe161080Vo.setConb10excsLtDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conb10excsLtDdcAmt"),"0")));    /** column 기부금_정치자금기부금10초과공제세액 : conb10excsLtDdcAmt */
							//inputYe161080Vo.setConbLglUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbLglUseAmt"),"0")));    /** column 기부금_법정기부금납입금액 : conbLglUseAmt */
							inputYe161080Vo.setConbLglDdcTrgtAmt(bgYETA_C145);    /** column 기부금_법정기부금공제대상금액 : conbLglDdcTrgtAmt */
							inputYe161080Vo.setConbLglDdcAmt(bgYETA_C146);    /** column 기부금_법정기부금공제세액 : conbLglDdcAmt */
							//inputYe161080Vo.setConbEmstAsctUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbEmstAsctUseAmt"),"0")));    /** column 기부금_우리사주조합기부금납입금액 : conbEmstAsctUseAmt */
							inputYe161080Vo.setConbEmstAsctDdcTrgtAmt(bgYETA_C147);    /** column 기부금_우리사주조합기부금공제대상금액 : conbEmstAsctDdcTrgtAmt */
							inputYe161080Vo.setConbEmstAsctDdcAmt(bgYETA_C148);    /** column 기부금_우리사주조합기부금공제세액 : conbEmstAsctDdcAmt */
							//inputYe161080Vo.setConbReliOrgOthUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgOthUseAmt"),"0")));    /** column 기부금_지정기부금종교단체외기부금액 : conbReliOrgOthUseAmt */
							inputYe161080Vo.setConbReliOrgOthDdcTrgtAmt(bgYETA_C149);    /** column 기부금_지정기부금종교단체외공제대상금액 : conbReliOrgOthDdcTrgtAmt */
							inputYe161080Vo.setConbReliOrgOthDdcAmt(bgYETA_C150);    /** column 기부금_지정기부금종교단체외공제세액 : conbReliOrgOthDdcAmt */
							//inputYe161080Vo.setConbReliOrgUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgUseAmt"),"0")));    /** column 기부금_지정기부금종교단체기부금액 : conbReliOrgUseAmt */
							inputYe161080Vo.setConbReliOrgDdcTrgtAmt(bgYETA_C150A);    /** column 기부금_지정기부금종교단체공제대상금액 : conbReliOrgDdcTrgtAmt */
							inputYe161080Vo.setConbReliOrgDdcAmt(bgYETA_C150B);    /** column 기부금_지정기부금종교단체공제세액 : conbReliOrgDdcAmt */
							//inputYe161080Vo.setConbUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbUseAmtSum"),"0")));    /** column 기부금납입금액합계 : conbUseAmtSum */
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
			               
						 
						//	inputYe169010Vo.setSpciFb14(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciFb14"),"0")));    /** column null : spciFb14 */
						//	inputYe169010Vo.setSpciFb15(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciFb15"),"0")));    /** column null : spciFb15 */
						//	inputYe169010Vo.setSpciFb16(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciFb16"),"0")));    /** column null : spciFb16 */
						//	inputYe169010Vo.setSpciFb17(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciFb17"),"0")));    /** column null : spciFb17 */
						//	inputYe169010Vo.setSpciFbtg17(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciFbtg17"),"0")));    /** column null : spciFbtg17 */ 
						
						//	inputYe169010Vo.setSpciFbtg14(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciFbtg14"),"0")));    /** column null : spciFbtg14 */
						//	inputYe169010Vo.setSpciFbtg15(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciFbtg15"),"0")));    /** column null : spciFbtg15 */
							inputYe169010Vo.setSpciFbse17(bgSPCI_FBSE17_10);    /** column null : spciFbse17 */
							//inputYe169010Vo.setSpciFbtg16(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciFbtg16"),"0")));    /** column null : spciFbtg16 */
							inputYe169010Vo.setSpciFbse14(bgSPCI_FBSE14_10);    /** column null : spciFbse14 */
							inputYe169010Vo.setSpciFbse15(bgSPCI_FBSE15_10);    /** column null : spciFbse15 */
							inputYe169010Vo.setSpciFbse16(bgSPCI_FBSE16_10);    /** column null : spciFbse16 */
							
							 
				               
							//inputYe169010Vo.setSpciNa14(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciNa14"),"0")));    /** column null : spciNa14 */
							//inputYe169010Vo.setSpciNa15(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciNa15"),"0")));    /** column null : spciNa15 */
							//inputYe169010Vo.setSpciNa16(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciNa16"),"0")));    /** column null : spciNa16 */
							//inputYe169010Vo.setSpciNa17(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciNa17"),"0")));    /** column null : spciNa17 */
							//inputYe169010Vo.setSpciNatg17(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciNatg17"),"0")));    /** column null : spciNatg17 */
						//	
							
							//inputYe169010Vo.setSpciNatg14(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciNatg14"),"0")));    /** column null : spciNatg14 */
							//inputYe169010Vo.setSpciNatg15(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciNatg15"),"0")));    /** column null : spciNatg15 */
							//inputYe169010Vo.setSpciNatg16(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciNatg16"),"0")));    /** column null : spciNatg16 */
							inputYe169010Vo.setSpciNase17(bgSPCI_NASE17_40);    /** column null : spciNase17 */
							inputYe169010Vo.setSpciNase14(bgSPCI_NASE14_40);    /** column null : spciNase14 */
							inputYe169010Vo.setSpciNase15(bgSPCI_NASE15_40);    /** column null : spciNase15 */
							inputYe169010Vo.setSpciNase16(bgSPCI_NASE16_40);    /** column null : spciNase16 */
							 
							//inputYe169010Vo.setSpciYa14(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciYa14"),"0")));    /** column null : spciYa14 */
							//inputYe169010Vo.setSpciYa15(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciYa15"),"0")));    /** column null : spciYa15 */
							//inputYe169010Vo.setSpciYa16(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciYa16"),"0")));    /** column null : spciYa16 */
							//inputYe169010Vo.setSpciYa17(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciYa17"),"0")));    /** column null : spciYa17 */
							//inputYe169010Vo.setSpciYatg17(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciYatg17"),"0")));    /** column null : spciYatg17 */
							//
					 
							//inputYe169010Vo.setSpciYatg14(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciYatg14"),"0")));    /** column null : spciYatg14 */
							//inputYe169010Vo.setSpciYatg15(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciYatg15"),"0")));    /** column null : spciYatg15 */
							//inputYe169010Vo.setSpciYatg16(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciYatg16"),"0")));    /** column null : spciYatg16 */
							inputYe169010Vo.setSpciYase17(bgSPCI_YASE17_41);    /** column null : spciYase17 */
							inputYe169010Vo.setSpciYase14(bgSPCI_YASE14_41);    /** column null : spciYase14 */
							inputYe169010Vo.setSpciYase15(bgSPCI_YASE15_41);    /** column null : spciYase15 */
							inputYe169010Vo.setSpciYase16(bgSPCI_YASE16_41);    /** column null : spciYase16 */
							   
							
							statCnt = 0;
					  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_TgIn01_Update( inputYe161080Vo) ;
					  		if (statCnt >= 0) {
					  			
					  			statCnt = 0;
						  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_TgIn02_Update( inputYe169010Vo) ;
					  		}
							 
  
			            }
	             }   
	  			
		  		//statCnt = 0;
		  	//	statCnt =  infcPkgYeta2300.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_Update(infcPkgYe169010Vo); 
		  		//if (statCnt >= 0) {
	                 /**$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ 기부금 처리 단계 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */
	                // {*********공제단계 시작   ******************* }
	                //  {2011년도 기부금 내역 정보 삭제  443 테이블에 필요없는데이터 삭제 - 삭제하면 다른 데이타 삭제로 제거  }
	                //    TODO 확인 차후 추가하던지 하기 
	                // infcPkgYeta2300.fnPayr06430_PAYR443_ReTax_2014_CREATE_10_1_Delete(infcPkgYe161010Vo); 	
	               // {공제단계 시작 -  기부금 내역 정보 삭제  442  -- 13 } 
	                 /**#######################  기부금공제 3 ############################################*/ 
//			  		statCnt = 0;  수시로 업데이트 하므로 삭제하면 안됨 
//			  		statCnt =   infcPkgYeta2300.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Delete(infcPkgYe161010Vo); 
//			  		if (statCnt >= 0) { 
//			  			
//			  		}
                  // {2011년도 이전 이월정산정리 작업 443 -> 442로이관}
              /**#######################  공제단계 시작 - 이전 이월정산정리 작업 443 -> 442로이관    -- 14 ############################################*/
		  		   
		  			dataCheck = "";
		  		 	dataCheck =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_40_Update(infcPkgYe165030Vo);   
		  			if (statCnt >= 0) {   
	                   //  {공제단계 시작 - 기부금 내역 정보 정산.     15 - 1 } 전단계에서 자동으로 처리함 제외 
	                     /**#######################  공제단계 시작 - 기부금 내역 정보 정산.     15 - 1 ############################################*/ 
//			  		dataCheck = "";
//		  			dataCheck =   infcPkgYeta2300.fnPayr06430_PAYR425_ReTax_2016_CREATE_10_1_Update(infcPkgYe161010Vo); 
//		  			if (MSFSharedUtils.paramNull(dataCheck)) {  
//		  				
//		  			}
		  				 /**#######################  기부금 정리 이월분 정리 작업 시작   ############################################*/ 	
		  				statCnt = 0;  
		  				Yeta2300Tax2017ContributionCalcPkgProc tax2017ContributionCalcPkgProc = new Yeta2300Tax2017ContributionCalcPkgProc();
		  				bmResult.addAll(tax2017ContributionCalcPkgProc.execTax_2017_Contribution_Calc(request,infcPkgYe161010Vo)); 
		  		  		if (bmResult.size() >= 0) {
		  				//if (0 >= 0) {
		  		  		//여기까지 	
/******************************************************** 기부금 종료 전체 다시 작업  *****************************************************************************/
		  		  			
		                   /**#######################  공제 대상금액  구하는 부분 ############################################*/
		              // if (MSFSharedUtils.paramNull(dataCheck)) {         
//		                 statCnt = 0;
//		 		  		  statCnt =  infcPkgYeta2300.fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(infcPkgYe169010Vo); 	
//		 		  		  if (statCnt >= 0) { 
//		 		  			TODO 확인후 상황에 맞게 수정 아니면 사용안함 
//		 		  		  }
		 		  			// 위 금액을 빼는 부분 처리를 위해 추가 된 부분 2017.03.02추가 
		 		  			statCnt = 0;
		 		  			// 
		 		  			Yeta2300SubtTaxWkerAmntPkgProc yeta2300SubtTaxWkerAmnt  =  new Yeta2300SubtTaxWkerAmntPkgProc();
		 		  			bmResult.addAll(yeta2300SubtTaxWkerAmnt.execSubtTaxWkerAmntPkgProc( request, infcPkgYe161010Vo));
		 	 		  
		 	 		        if (bmResult.size() >= 0) {     
		 	 	 		       /**#######################  공제계  합산 부분 구하는 부분 ############################################*/
//		 	 	 		  			statCnt = 0;
//		 	 	 	 		 		statCnt = infcPkgYeta2300.fnPayr06430_PAYR425_ReTax_2016_CREATE_12_Update(infcPkgYe169010Vo);
//		 	 	 		 		   if (statCnt >= 0) {
//		 	 	 		 			  //TODO 합산부분 확인후 차후 다시 필요시 사용안함  
//		 	 	 		 		   }
		 	 	 		     
		 	 	 		       /**#######################  차감소득금액 ############################################*/ 
		 	 	 		 		statCnt = 0;
		 	 	 		 		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_50_Update(infcPkgYe169010Vo); 
		 	 	 		       		if (statCnt >= 0) {
		 	 	 		 		       /**#######################  그밖의 소득공제 계 ############################################*/ 
		 	 	 		 		 		statCnt = 0;  
		 	 	 		 		 		statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_50_01_Update(infcPkgYe169010Vo);		 	 	 		 	 		 		
//		 	 	 		 		 		if (statCnt >= 0) { 
//		 	 	 		 		 			 합계통합 삭제 
//		 	 	 		 		 		}
		 	 	 		 		  	 //   statCnt = 0;
		 	 	 		       	    	Yeta2300SubtTaxStdDdcPkgProc yeta2300SubtTaxStdDdc  = new Yeta2300SubtTaxStdDdcPkgProc();
		 	 	 		       	    	bmResult.addAll(yeta2300SubtTaxStdDdc.execSubtTaxStdDdcPkgProc(request, infcPkgYe161010Vo));		 	 	 		 		  	    
		 	 	 		 		  		/****   여기 부터 표준세액공제 때문에 공통으로 처리 해야 함 0으로 처리 해야 할부분 에 대해 업데이트 처리도 해야함 검증을 위한쿼리 추가 ****/
		 	 	 		 		   
		 	 	 				  		 /**####################### 표준세액공제에 대한 값 처리 ############################################*/
		 	 	 		 		  	  if (bmResult.size() >= 0) {		 	 	 		 		  		  
		 	 	 		 		    	InfcPkgYe169010SrhVO   infcPkgYe169010SrhVo = new InfcPkgYe169010SrhVO();	
		 	 	 		 		  		InfcPkgYe169010VO   tpInfcPkgYe169010Vo = new InfcPkgYe169010VO();	//C_주현근무처 
		 	 							InfcPkgYe169010aVO   infcPkgYe169010AVo = new InfcPkgYe169010aVO();	//C_주현근무처_표준공제 
		 	 							BeanUtils.copyProperties(infcPkgYe169010Vo, infcPkgYe161010Vo);
		 	 							BeanUtils.copyProperties(infcPkgYe169010SrhVo, infcPkgYe161010Vo);
		 	 							BeanUtils.copyProperties(infcPkgYe169010AVo, infcPkgYe161010Vo); 
		 	 			  			    BeanUtils.copyProperties(infcPkgYe161020Vo, infcPkgYe161010Vo);
		 	 			  			    infcPkgYe161020Vo.setC152StdTxDdcYn("N");
		 	 			  			    statCnt =  infcPkgYeta2300.fnYeta2300_YE161020_Tax_2017_C152_STD_TX_DDC_YN_Update(infcPkgYe161020Vo); 
		 	 	 		 	            
	 	 	 		 	                 tpInfcPkgYe169010Vo = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_51_Select(infcPkgYe169010SrhVo);
	 	 	 		 			  		
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
	 	 	 		 						                	     infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_52_Delete(infcPkgYe169010Vo);
	 	 	 		 						                	     dataCheck =  infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_52_Insert(infcPkgYe169010Vo); 
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
	 	 	 		 						                	
	 	 	 		 						                		    //infcPkgYe169010AVo.setSpciBhth(BigDecimal.ZERO);    /** column 특별공제_종건강보험료 : spciBhth */
	 	 	 		 						                		    //infcPkgYe169010AVo.setSpciJhth(BigDecimal.ZERO);    /** column 특별공제_주건강보험료 : spciJhth */ 
	 	 	 		 						                		   // infcPkgYe169010AVo.setSpciBepf(BigDecimal.ZERO);    /** column 특별공제_종고용보험료 : spciBepf */
	 	 	 		 						                		    //infcPkgYe169010AVo.setSpciJepf(BigDecimal.ZERO);    /** column 특별공제_주고용보험료 : spciJepf */
	 	 	 		 						                		    
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC133(BigDecimal.ZERO);    /** column C133_STD_세액공제_특별세액공제_보장성보험공제대상금액 : yetaStdC133 */
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC134(BigDecimal.ZERO);    /** column C134_STD_세액공제_특별세액공제_보장성보럼세액공제금액 : yetaStdC134 */
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC135(BigDecimal.ZERO);    /** column C135_STD_세액공제_특별세액공제_장애인전용공제대상금액 : yetaStdC135 */
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC136(BigDecimal.ZERO);    /** column C136_STD_세액공제_특별세액공제_장애인전용세액공제금액 : yetaStdC136 */
	 	 	 		 						                	
//	 	 	 		 						                		    infcPkgYe169010AVo.setSpciGurt(BigDecimal.ZERO);    /** column 특별공제_일반보장성보험료 : spciGurt */
//	 	 	 		 						                		    infcPkgYe169010AVo.setSpciHdrc(BigDecimal.ZERO);    /** column 특별공제_장애인보장성보험료 : spciHdrc */
//	 	 	 		 						                		    infcPkgYe169010AVo.setSpciRtde(BigDecimal.ZERO);    /** column 특별공제_보장성보혐료세액공제금액 : spciRtde */
	 	 	 		 						                	         
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC137(BigDecimal.ZERO);    /** column C137_STD_세액공제_특별세액공제_의료비공제대상금액 : yetaStdC137 */
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC138(BigDecimal.ZERO);    /** column C138_STD_세액공제_특별세액공제_의료비세액공제금액 : yetaStdC138 */
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC139(BigDecimal.ZERO);    /** column C139_STD_세액공제_특별세액공제_교육비공제대상금액 : yetaStdC139 */
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC140(BigDecimal.ZERO);    /** column C140_STD_세액공제_특별세액공제_교육비세액공제금액 : yetaStdC140 */
	 	 	 		 						                	
	 	 	 		 						                		   // infcPkgYe169010AVo.setSpciTxcr(BigDecimal.ZERO);    /** column 특별공제_의료비세액공제액 : spciTxcr */
	 	 	 		 						                		   // infcPkgYe169010AVo.setSpedTxcr(BigDecimal.ZERO);    /** column 특별공제_교육비세액공제금액 : spedTxcr */
	 	 	 		 						                		    
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c83(BigDecimal.ZERO);    /** column C83_STD_특별소득공제_주택자금_추택임차차입금_대출기관 : yetaStd0c83 */
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStd0c84(BigDecimal.ZERO);    /** column C84_STD_특별소득공제_주택자금_주택임차차입금_거주자 : yetaStd0c84 */
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC156(BigDecimal.ZERO);    /** column C156_STD_세액공제_월세세액공제대상금액 : yetaStdC156 */
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC157(BigDecimal.ZERO);    /** column C157_STD_세액공제_월세세액공제금액 : yetaStdC157 */
	 	 	 		 						                	
	 	 	 		 						                		   // infcPkgYe169010AVo.setSpciRefn(BigDecimal.ZERO);    /** column 특별공제_차입금원리금상환액_대출기관 : spciRefn */
	 	 	 		 						                		   // infcPkgYe169010AVo.setSpciResf(BigDecimal.ZERO);    /** column 특별공제_차입금원리금상환액_거주자 : spciResf */
	 	 	 		 						                		   // infcPkgYe169010AVo.setSpciRtam(BigDecimal.ZERO);    /** column 특별공제_주택자금월세공제액 : spciRtam */ 
	 	 	 		 						                		   // infcPkgYe169010AVo.setSpciTgrt(BigDecimal.ZERO);    /** column 특별공제_주택자금월세공제액 : SPCI_TGRT */ 
	 	 	 		 						                		    
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
	 	 	 		 						                	
//	 	 	 		 						                		    infcPkgYe169010AVo.setSpchRe15(BigDecimal.ZERO);    /** column 특별공제_11장기주택저당차입금15 : spchRe15 */
//	 	 	 		 						                		    infcPkgYe169010AVo.setSpchRe29(BigDecimal.ZERO);    /** column 특별공제_11장기주택저당차입금29 : spchRe29 */
//	 	 	 		 						                		    infcPkgYe169010AVo.setSpchRe30(BigDecimal.ZERO);    /** column 특별공제_11장기주택저당차입금30 : spchRe30 */
//	 	 	 		 						                	        infcPkgYe169010AVo.setSpciRefx(BigDecimal.ZERO);    /** column 특별공제_12장기주택저당차입금_고정 : spciRefx */
//	 	 	 		 						                	        infcPkgYe169010AVo.setSpciReec(BigDecimal.ZERO);    /** column 특별공제_12장기주택저당차입금_기타 : spciReec */
//	 	 	 		 						                	        infcPkgYe169010AVo.setSpci15fx(BigDecimal.ZERO);    /** column 특별공제_15장기주택저당_15고정AND비거치상환 : spci15fx */
//	 	 	 		 						                	        infcPkgYe169010AVo.setSpci15fb(BigDecimal.ZERO);    /** column 특별공제_15장기주택저당_15고정OR비거치상환 : spci15fb */
//	 	 	 		 						                	        infcPkgYe169010AVo.setSpci15ec(BigDecimal.ZERO);    /** column 특별공제_15장기주택저당_15기타대출 : spci15ec */
//	 	 	 		 						                	        infcPkgYe169010AVo.setSpci10fb(BigDecimal.ZERO);    /** column 특별공제_15장기주택저당_10고정OR비거치상환 : spci10fb */
//	 	 	 		 						                	        infcPkgYe169010AVo.setSpci10ec(BigDecimal.ZERO);    /** column 특별공제_15장기주택저당_10기타대출 : spci10ec */ 
	 	 	 		 						                	        
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC145(BigDecimal.ZERO);    /** column C145_STD_세액공제_특별세액공제_법정기부금공제대상금액 : yetaStdC145 */
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC146(BigDecimal.ZERO);    /** column C146_STD_세액공제_특별세액공제_법정기부금세액공제금액 : yetaStdC146 */
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC149(BigDecimal.ZERO);    /** column C149_STD_세액공제_특별세액공제_지정기부금_종교단체외공제대상금액 : yetaStdC149 */
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC150(BigDecimal.ZERO);    /** column C150_STD_세액공제_특별세액공제_지정기부금_종교단체외세액공제금액 : yetaStdC150 */
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC150a(BigDecimal.ZERO);    /** column C150A_STD_세액공제_특별세액공제_지정기부금_종교단체공제대상금액 : yetaStdC150a */
	 	 	 		 						                		    infcPkgYe169010AVo.setYetaStdC150b(BigDecimal.ZERO);    /** column C150B_STD_세액공제_특별세액공제_지정기부금_종교단체세액공제금액 : yetaStdC150b */
	 	 	 		 						            
	 	 	 		 						                		    //infcPkgYe169010AVo.setSpciFbam(BigDecimal.ZERO);    /** column 특별공제_기부금_법정 : spciFbam */
	 	 	 		 						                	       // infcPkgYe169010AVo.setSpciYamt(BigDecimal.ZERO);    /** column 특별공제_기부금_종교단체 : spciYamt */
	 	 	 		 						                	       // infcPkgYe169010AVo.setSpciNamt(BigDecimal.ZERO);    /** column 특별공제_기부금_종교단체외 : spciNamt */ 
//	 	 	 		 						                	        infcPkgYe169010AVo.setSpciSsum(BigDecimal.ZERO);    /** column 특별공제_이월기부금공제액계 : spciSsum */
	 	 	 		 						                	        
	 	 	 		 						                	       // infcPkgYe169010AVo.setSpciDgcr(BigDecimal.ZERO); 
	 	 	 		 						                	       // infcPkgYe169010AVo.setSpciObam(BigDecimal.ZERO); /*이월법정기부금액*/
	 	 	 		 						                	       // infcPkgYe169010AVo.setSpciOnam(BigDecimal.ZERO); 
	 	 	 		 						                	      //  infcPkgYe169010AVo.setSpciOyam(BigDecimal.ZERO); 
	 	 	 		 						                	      //  infcPkgYe169010AVo.setSpedSelf(BigDecimal.ZERO); /* 특별공제_교육비_본인 */
	 	 	 		 						                	      //  infcPkgYe169010AVo.setSpedGrde(BigDecimal.ZERO); 
	 	 	 		 						                	     //   infcPkgYe169010AVo.setSpedGdto(BigDecimal.ZERO); 
	 	 	 		 						                	      //  infcPkgYe169010AVo.setSpedCldv(BigDecimal.ZERO); 
	 	 	 		 						                	     //   infcPkgYe169010AVo.setSpciSpec(BigDecimal.ZERO); 
	 	 	 		 						                	        
	 	 	 		 						                	        
	 	 	 		 						                	         statCnt = 0;
	 	 	 		 						                		  	 statCnt =  infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_52_Update(infcPkgYe169010AVo); 
	 	 	 		 						                		 
//	 	 	 		 						                		  	if (statCnt >= 0) {  // 통합으로 인해 사용안함 	 
//	 	 	 		 						                		  	 
//		 	 	 		 						                		  	InfcPkgYeta2000VO dscnPrc2000Vo = new InfcPkgYeta2000VO(); 
//		 	 	 		 						                		  	dscnPrc2000Vo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//		 	 	 		 						                		  	dscnPrc2000Vo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
//		 	 	 		 						                		  	dscnPrc2000Vo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
//		 	 	 		 						                		  	dscnPrc2000Vo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
//		 	 	 		 							                		  
//		 	 	 		 						                			dscnPrc2000Vo.setSpciRttg(BigDecimal.ZERO);    /** column 특별공제_보장성보험료공제대상금액 : spciRttg */
//		 	 	 		 						                			dscnPrc2000Vo.setSpciHdtg(BigDecimal.ZERO);    /** column 특별공제_장애인보장성대상금액 : spciHdtg */
//		 	 	 		 													dscnPrc2000Vo.setSpciDetg(BigDecimal.ZERO);    /** column 특별공제_보장성보험료대상금액 : spciDetg */
//		 	 	 		 													dscnPrc2000Vo.setSpciDtar(BigDecimal.ZERO);    /** column 특별공제_의료비세액공제대상금액 : spciDtar */
//		 	 	 		 													dscnPrc2000Vo.setSpedEtar(BigDecimal.ZERO);    /** column 특별공제_교육비공제대상금액 : spedEtar  */
//		 	 	 		 													dscnPrc2000Vo.setSpciFbtg(BigDecimal.ZERO);    /** column 특별공제_기부금_법정대상금액 : spciFbtg */
//		 	 	 		 													dscnPrc2000Vo.setSpciFb14(BigDecimal.ZERO);    /** column 법정기부금2014대상금액 : spciFb14   */
//		 	 	 		 													dscnPrc2000Vo.setSpciYa14(BigDecimal.ZERO);    /** column 종교단체2014대상금액 : spciYa14    */
//		 	 	 		 													dscnPrc2000Vo.setSpciNa14(BigDecimal.ZERO);    /** column 총교단체외2014대상금액 : spciNa14   */
//		 	 	 		 													dscnPrc2000Vo.setSpciNatg(BigDecimal.ZERO);    /** column 종교단체외지정대상금액 : spciNatg */
//		 	 	 		 													dscnPrc2000Vo.setSpciYatg(BigDecimal.ZERO);    /** column 종교단체지정대상금액 : spciYatg */
//		 	 	 		 													  
//		 	 	 		 													dscnPrc2000Vo.setSpciDgtg(BigDecimal.ZERO); 
//		 	 	 		 													dscnPrc2000Vo.setSpedSftr(BigDecimal.ZERO); 
//		 	 	 		 													dscnPrc2000Vo.setSpedEdtr(BigDecimal.ZERO); 
//		 	 	 		 													dscnPrc2000Vo.setSpedGdtr(BigDecimal.ZERO); 
//		 	 	 		 													dscnPrc2000Vo.setSpedCvtr(BigDecimal.ZERO);  
//		 	 	 		 													
//		 	 	 		 						                		  	 statCnt = 0;
//	 	 	 		 						                		  	     statCnt =  infcPkgYeta2300.yeta2000_ReTax_2016_DCSN_INCM_Update(dscnPrc2000Vo); 
//	 	 	 		 						                		  	 
//	 	 	 		 						                	       }
	 	 	 		 						                		     if (statCnt >= 0) {
	 	 	 		 						                			    
//	 	 	 		 						                	                 statCnt = 0;
//	 	 	 		 						                	 		  		 statCnt =  infcPkgYeta2300.fnPayr06430_PAYR415_ReTax_2016_CREATE_12_1_Update(infcPkgYe161010Vo); 
//	 	 	 		 						                	                  //합계구하는 부분인데 사용안함 
//	 	 	 		 						                	 		  		if (statCnt >= 0) {      
	 	 	 		 									                			  // {retax-45} 
	 	 	 		 									                		       /**#######################  공제계  합산 부분 구하는 부분 ############################################*/
//	 	 	 		 									                		  			statCnt = 0;
//	 	 	 		 									                	 		 		statCnt = infcPkgYeta2300.fnPayr06430_PAYR425_ReTax_2016_CREATE_12_Update(infcPkgYe161010Vo);
//	 	 	 		 									                	 		   //로직변경으로 다르게 구성함 차후 삭제 
//		 	 	 		 									                		 		if (statCnt >= 0) {
	 	 	 		 									                		      // {retax-46}
	 	 	 		 									                		       /**#######################  차감소득금액 ############################################*/
	 	 	 		 									                		      //  -----------------'차감소득금액     ----------------------------------
	 	 	 		 									                		      
	 	 	 		 									                		 		statCnt = 0;
	 	 	 		 									                		 		 statCnt =  infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_50_Update(infcPkgYe169010AVo); 
	 	 	 		 									                		        
	 	 	 		 									                		 		/*****************************************************************************************
	 	 	 		 									                		 		 * 표준세액공제 적용부로 ye169010a 테이블에저장함 
	 	 	 		 									                		 		 *****************************************************************************************/
	 	 	 		 													           	 		 	  if (statCnt >= 0) {
	 	 	 		 													           	 		 		  //InfcPkgYe169010aVO
	 	 	 		 													           	 		 		  infcPkgYe161010Vo.setSpciDdctCheck("TRUE");
	 	 	 		 													           	 		          Yeta2300SubtTaxEtcIncDdcPkgProc subtTaxEtcIncDdc  = new Yeta2300SubtTaxEtcIncDdcPkgProc();
	 	 	 		 	 	 		 						                			              bmResult.addAll(subtTaxEtcIncDdc.execSubtTaxEtcIncDdcPkgProc(request, infcPkgYe161010Vo)); 
	 	 	 		 	 	 		 						                			    
	 	 	 		 	 	 		 						                			          if (bmResult.size() >= 0) { 
	 	 	 		 														               		  	    
	 	 	 		 													           	 		 	 //  {retax-47}
	 	 	 		 													                		       /**#######################  그밖의 소득공제 계 ############################################*/
	 	 	 		 	 	 		 						                		                
	 	 	 		 													                		 		statCnt = 0;
	 	 	 		 													                		 		statCnt = infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_50_01_Update(infcPkgYe169010AVo);
	 	 	 		 													                		 		 
	 	 	 		 															               		       if (statCnt >= 0) {
	 	 	 		 															               		  	  
	 	 	 		 															               		  	       //YetaTaxCreateUpdate InfcPkgYe169010aVO
				 	 	 		 															               		 Yeta2300SubtTaxStdDdcPkgProc subtTaxStdDdc  = new Yeta2300SubtTaxStdDdcPkgProc();
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
	 	 	 		 						                		    Yeta2300SubtTaxEtcIncDdcPkgProc subtTaxEtcIncDdc  = new Yeta2300SubtTaxEtcIncDdcPkgProc();
	 	 		 						                			    bmResult.addAll(subtTaxEtcIncDdc.execSubtTaxEtcIncDdcPkgProc(request, infcPkgYe161010Vo)); 
	 	 		 						                			    
	 	 		 						                 		       if (bmResult.size() >= 0) {    
	 	 	 		 						                 		  	  //  {retax-47}
	 	 	 		 						                 		       /**#######################  그밖의 소득공제 계 ############################################*/ 
	 	 	 		 						                 		 		statCnt = 0;
	 	 	 		 						                 		 		statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_50_01_Update(infcPkgYe169010Vo);
	 	 	 		 						                 		 	  
	 	 	 		 						               		  	       } 
	 	 	 		 						                		  }	  
	 	 	 		 						                	}	  
	 	 	 		 				                	 } else {
	 	 	 		 				                		 infcPkgYe161010Vo.setSpciDdctCheck("FALSE");
	 	 	 		 				                		 if (statCnt >= 0) {
	 	 	 		 				                		 //InfcPkgYe169010VO
	 	 	 		 				                		    Yeta2300SubtTaxEtcIncDdcPkgProc subtTaxEtcIncDdc  = new Yeta2300SubtTaxEtcIncDdcPkgProc();
 		 						                			    bmResult.addAll(subtTaxEtcIncDdc.execSubtTaxEtcIncDdcPkgProc(request, infcPkgYe161010Vo)); 
 		 						                			    
 		 						                 		       if (bmResult.size() >= 0) {	    
	 	 	 		 				                 		  	  //  {retax-47}
	 	 	 		 				                 		       /**#######################  그밖의 소득공제 계 ############################################*/ 
	 	 	 		 				                 		 		statCnt = 0;
	 	 	 		 				                 		 		statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_50_01_Update(infcPkgYe169010Vo);
	 	 	 		 				                 		 	  
	 	 	 		 				               		  	  } 
	 	 	 		 				                		 }	  	  
	 	 	 		 				                  }  
	 	 	 		 	                  
				 	 	 		 	                  /**#######################  //납부또는 환급세액 ############################################*/ 
				 	 	 		 			  		if (statCnt >= 0) {
				 	 	 		 			  		statCnt = 0;
				 	 	 		 			  		if ("TRUE".equals(spciDdctCheck) ) {

					 	 	 		 			  		statCnt =   infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_51_Update(infcPkgYe169010AVo); 
					 	 	 		 			  		spciDdctCheck = "FALSE";
				 	 	 		 			  		} else {

					 	 	 		 			  		statCnt =   infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_51_Update(infcPkgYe169010Vo); 
					 	 	 		 			  		spciDdctCheck = "FALSE";  
				 	 	 		 			  		}
				 	 	 		 	                
				 	 	 		 	                // {retax-63}
				 	 	 		 	                 /**####################### 차감징수세액 총계  ############################################*/ 
				 	 	 		 			  		if (statCnt >= 0) {
//				 	 	 		 			  			statCnt = 0;  사용안해도될거 같음 
//				 	 	 		 			  		  statCnt =  infcPkgYeta2300.fnPayr06430_PAYR425_ReTax_2016_CREATE_19_Update(infcPkgYe169010Vo);
				 	 	 		 			  		
				 	 	 		 			  	 /**#######################   YE169010 YE169010A 복제 루틴 ############################################*/ 
				 	 	 		 			  		 
					 	 							
					 	 					 		InfcPkgYe169010SrhVO   ye169010SrhVo = new InfcPkgYe169010SrhVO();	 
					 	 							BeanUtils.copyProperties(ye169010SrhVo, infcPkgYe161010Vo); 
					 	 							
				 	 	 		 			  		 List lstPkgYe169010Vo =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_A01_Select(ye169010SrhVo);
				 	 	 		 			  		 
						 	 	 		 			     for (int iCnt02 = 0;iCnt02 < lstPkgYe169010Vo.size();iCnt02++) {
						 	 	                           
						 	 	 		 			    	 Map tempMap = (Map)lstPkgYe169010Vo.get(iCnt02); 
						 	 	                            
						 	 	 		 			    	 
						 	 	 		 			      //	InfcPkgYe169010VO   tpInfcPkgYe169010Vo = new InfcPkgYe169010VO();	//C_주현근무처 
								 	 	 		 			  	InfcPkgYe161060VO    inputYe161060Vo	 = new InfcPkgYe161060VO();	//C_특별소득공제
								 	 							InfcPkgYe161070VO    inputYe161070Vo	 = new InfcPkgYe161070VO();	//C_그밖의소득공제
								 	 							InfcPkgYe161080VO    inputYe161080Vo	 = new InfcPkgYe161080VO();	//C_세액감면및공제
								 	 							BeanUtils.copyProperties(inputYe161060Vo, infcPkgYe161010Vo);
								 	 							BeanUtils.copyProperties(inputYe161070Vo, infcPkgYe161010Vo);
								 	 							BeanUtils.copyProperties(inputYe161080Vo, infcPkgYe161010Vo); 
								 	 							

//																inputYe161060Vo.setDpobCd(tempMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
//																inputYe161060Vo.setYrtxBlggYr(tempMap.get("yrtxBlggYr"));    /** column 귀속연도 : yrtxBlggYr */
//																inputYe161060Vo.setClutSeptCd(tempMap.get("clutSeptCd"));    /** column 연말정산구분코드 : clutSeptCd */
//																inputYe161060Vo.setSystemkey(tempMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */
//																inputYe161060Vo.setHthrHifeAmt(tempMap.get("hthrHifeAmt"));    /** column 국민건강보험_종근무지보험료금액 : hthrHifeAmt */
//																inputYe161060Vo.setHthrHifeDdcAmt(tempMap.get("hthrHifeDdcAmt"));    /** column 국민건강보험_종근무지보험료공제액 : hthrHifeDdcAmt */
//																inputYe161060Vo.setMcurHifeAmt(tempMap.get("mcurHifeAmt"));    /** column 국민건강보험_주근무지보험료금액 : mcurHifeAmt */
//																inputYe161060Vo.setMcurHifeDdcAmt(tempMap.get("mcurHifeDdcAmt"));    /** column 국민건강보험_주근무지보험료공제액 : mcurHifeDdcAmt */
//																inputYe161060Vo.setMcurHifeAreaAmt(tempMap.get("mcurHifeAreaAmt"));    /** column 국민건강보험_지역보험료금액 : mcurHifeAreaAmt */
//																inputYe161060Vo.setMcurHifeAreaDdcAmt(tempMap.get("mcurHifeAreaDdcAmt"));    /** column 국민건강보험_지역보험료공제금액 : mcurHifeAreaDdcAmt */
//																inputYe161060Vo.setHthrUiAmt(tempMap.get("hthrUiAmt"));    /** column 고용보험_종근무지보험료금액 : hthrUiAmt */
//																inputYe161060Vo.setHthrUiDdcAmt(tempMap.get("hthrUiDdcAmt"));    /** column 고용보험_종근무지보험료공제액 : hthrUiDdcAmt */
//																inputYe161060Vo.setMcurUiAmt(tempMap.get("mcurUiAmt"));    /** column 고용보험_주근무지보험료금액 : mcurUiAmt */
//																inputYe161060Vo.setMcurUiDdcAmt(tempMap.get("mcurUiDdcAmt"));    /** column 고용보험_주근무지보험료공제액 : mcurUiDdcAmt */
//																inputYe161060Vo.setInfeeUseAmtSum(tempMap.get("infeeUseAmtSum"));    /** column 건강고용_보험료보험료합계 : infeeUseAmtSum */
//																inputYe161060Vo.setInfeeDdcAmtSum(tempMap.get("infeeDdcAmtSum"));    /** column 건강고용_보험료공제액합계 : infeeDdcAmtSum */
																
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
															//	inputYe161060Vo.setConbLglUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbLglUseAmt"),"0")));    /** column 기부금이월분_법정기부금기부금납입액 : conbLglUseAmt */
															//	inputYe161060Vo.setConbLglDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbLglDdcAmt"),"0")));    /** column 기부금이월분_법정기부금기부금공제액 : conbLglDdcAmt */
															//	inputYe161060Vo.setConbReliOrgOthUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgOthUseAmt"),"0")));    /** column 기부금이월분_지정기부금_종교단체외납입액 : conbReliOrgOthUseAmt */
															//	inputYe161060Vo.setConbReliOrgOthDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgOthDdcAmt"),"0")));    /** column 기부금이월분_지정기부금_종교단체외공제액 : conbReliOrgOthDdcAmt */
															//	inputYe161060Vo.setConbReliOrgUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgUseAmt"),"0")));    /** column 기부금이월분_지정기부금_종교단체납입액 : conbReliOrgUseAmt */
															//	inputYe161060Vo.setConbReliOrgDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgDdcAmt"),"0")));    /** column 기부금이월분_지정기부금_종교단체공제액 : conbReliOrgDdcAmt */
															//	inputYe161060Vo.setConbUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbUseAmtSum"),"0")));    /** column 기부금이월분_지정기부금납입분합계 : conbUseAmtSum */
																inputYe161060Vo.setConbDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c94"),"0")));    /** column 기부금이월분_지정기부금공제합계 : conbDdcAmtSum */
													 
																 infcPkgYeta2300.fnYeta2300_Ye161060_Tax_2017_I1_Update(inputYe161060Vo); 
						 	 							
 
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
																
																 infcPkgYeta2300.fnYeta2300_Ye161070_Tax_2017_I2_Update(inputYe161070Vo); 
																  
																inputYe161080Vo.setSctcHpDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC127"),"0")));    /** column 연금계좌_과학기술인공제_공제대상금액 : sctcHpDdcTrgtAmt */
																inputYe161080Vo.setSctcHpDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC128"),"0")));    /** column 연금계좌_과학기술인공제_공제세액 : sctcHpDdcAmt */ 
																inputYe161080Vo.setRtpnDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC129"),"0")));    /** column 연금계좌_근로자퇴직급여보장법_퇴직연금공제대상금액 : rtpnDdcTrgtAmt */
																inputYe161080Vo.setRtpnDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC130"),"0")));    /** column 연금계좌_근로자퇴직급여보장법_퇴직연금공제세액 : rtpnDdcAmt */ 
																inputYe161080Vo.setPnsnSvngDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC131"),"0")));    /** column 연금계좌_연금저축공제대상금액 : pnsnSvngDdcTrgtAmt */
																inputYe161080Vo.setPnsnSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC132"),"0")));    /** column 연금계좌_연금저축공제세액 : pnsnSvngDdcAmt */ 
																
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
																 
																//inputYe161080Vo.setTxlgItctAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("txlgItctAmnt"),"0")));    /** column 세액감면_소득세법감면세액 : txlgItctAmnt */
																//inputYe161080Vo.setTxlgBstaAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("txlgBstaAmnt"),"0")));    /** column 세액감면_취업청년감면대상총급여액 : txlgBstaAmnt */
																//inputYe161080Vo.setTxlgWktaAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("txlgWktaAmnt"),"0")));    /** column 세액감면_취업청년감면근로자총급여액 : txlgWktaAmnt */
																//inputYe161080Vo.setTxlgCltaAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("txlgCltaAmnt"),"0")));    /** column 세액감면_계산감면세액금액 : txlgCltaAmnt */
																//inputYe161080Vo.setTxlgFrtaAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("txlgFrtaAmnt"),"0")));    /** column 세액감면_외국인기술자감면세액 : txlgFrtaAmnt */
																//inputYe161080Vo.setTxlgTxtyAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("txlgTxtyAmnt"),"0")));    /** column 세액감면_조세조약감면세액 : txlgTxtyAmnt */
															
																   infcPkgYeta2300.fnYeta2300_Ye161080_Tax_2017_I3_Update(inputYe161080Vo);
																 
																 //연금저축등소득세액공제 정리 
																 
																InfcPkgYe162010SrhVO   ye162010SrhVo = new InfcPkgYe162010SrhVO();	 
									 	 						BeanUtils.copyProperties(ye162010SrhVo, infcPkgYe161010Vo); 
									 	 							
								 	 	 		 			  		 List lstPkgYe162010Vo =  infcPkgYeta2300.fnYeta2300_YE162010_Tax_2017_A01_Select(ye162010SrhVo);
								 	 	 		 			  	   //  BigDecimal bgTotPNSN_SVNG_ACC_PYM_AMT = BigDecimal.ZERO;
								 	 	 		 			  	     BigDecimal bgYeta0c98 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c98"),"0"));
								 	 	 		 			         BigDecimal bgYetaC131 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC131"),"0"));
								 	 	 		 			     
								 	 	 		 			  	   //  bgTotPNSN_SVNG_ACC_PYM_AMT =bgYeta0c98;
								 	 	 		 			  	
										 	 	 		 			     for (int iCnt03 = 0;iCnt03 < lstPkgYe162010Vo.size();iCnt03++) {
										 	 	 		 			         InfcPkgYe162010VO    infcPkgYe162010Vo	 = new InfcPkgYe162010VO();	//F_연금저축계좌
										 	 	 		 			    	 Map tempMap01 = (Map)lstPkgYe162010Vo.get(iCnt03); 
										 	 	 		 			    
																			
										 	 	 		 			    	 BeanUtils.copyProperties(infcPkgYe162010Vo, infcPkgYe161010Vo);
										 	 	 		 			    	 
										 	 	 		 			    	 infcPkgYe162010Vo.setPnsnSvngAccAccno(MSFSharedUtils.allowNulls(tempMap01.get("pnsnSvngAccAccno")) );
										 	 	 		 			         infcPkgYe162010Vo.setPnsnSvngAccPnsnSvngCl(MSFSharedUtils.allowNulls(tempMap01.get("pnsnSvngAccPnsnSvngCl")) );
										 	 	 		 			                     
										 	 	 		 			    	 if ("Y0040030".equals(MSFSharedUtils.allowNulls(tempMap01.get("pnsnSvngAccPnsnSvngCl")))) {
										 	 	 		 			    		//개인연금 
										 	 	 		 			    		
										 	 	 		 			    		BigDecimal bgPNSN_SVNG_ACC_PYM_AMT = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap01.get("pnsnSvngAccPymAmt"),"0"));
										 	 	 		 			    	    BigDecimal ddcPymAmt = bgPNSN_SVNG_ACC_PYM_AMT.multiply(new BigDecimal("0.40")).setScale(0, BigDecimal.ROUND_DOWN);
										 	 	 		 			    	  
										 	 	 		 			    	    if (bgYeta0c98.compareTo(ddcPymAmt) > 0) {
										 	 	 		 			    	    	infcPkgYe162010Vo.setPnsnSvngAccTgtAmt(ddcPymAmt); 
										 	 	 		 			    	        bgYeta0c98 = bgYeta0c98.subtract(ddcPymAmt);
										 	 	 		 			    	    } else {
										 	 	 		 			    	    	
										 	 	 		 			    	    	infcPkgYe162010Vo.setPnsnSvngAccTgtAmt(bgYeta0c98); 
										 	 	 		 			    	        bgYeta0c98 = BigDecimal.ZERO;
										 	 	 		 			    	    }
										 	 	 		 			    		
										 	 	 		 			    	    infcPkgYeta2300.updateYeta2300_Tax_Ye162010_01(infcPkgYe162010Vo);     
										 	 	 		 			           //	infcPkgYe162010Vo.setPnsnSvngAccPymAmt();
										 	 	 		 			    	 } else if("Y0040040".equals(MSFSharedUtils.allowNulls(tempMap01.get("pnsnSvngAccPnsnSvngCl")))) {
										 	 	 		 			    		//연금저축  
										 	 	 		 			    		BigDecimal bgPNSN_SVNG_ACC_PYM_AMT = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap01.get("pnsnSvngAccPymAmt"),"0"));
										 	 	 		 			             
										 	 	 		 			    	    if (bgYetaC131.compareTo(bgPNSN_SVNG_ACC_PYM_AMT) > 0) {
										 	 	 		 			    	    	infcPkgYe162010Vo.setPnsnSvngAccTgtAmt(bgPNSN_SVNG_ACC_PYM_AMT); 
										 	 	 		 			    	    	bgYetaC131 = bgYetaC131.subtract(bgPNSN_SVNG_ACC_PYM_AMT);
										 	 	 		 			    	    } else {
										 	 	 		 			    	    	
										 	 	 		 			    	    	infcPkgYe162010Vo.setPnsnSvngAccTgtAmt(bgYetaC131); 
										 	 	 		 			    	    	bgYetaC131 = BigDecimal.ZERO;
										 	 	 		 			    	    }
										 	 	 		 			    		
										 	 	 		 			    		infcPkgYeta2300.updateYeta2300_Tax_Ye162010_01(infcPkgYe162010Vo) ;     
										 	 	 		 			    	 } 
										 	 	 		 			    	 
										 	 	 		 			    	 	 
										 	 	 		 			     }	
										 	 	 		 			     
										 	 	 		 			      InfcPkgYe162010VO    infcPkgYe162010Vo	 = new InfcPkgYe162010VO();	//F_연금저축계좌
								 	 	 		 			    	      BeanUtils.copyProperties(infcPkgYe162010Vo, infcPkgYe161010Vo);
										 	 	 		 			      infcPkgYeta2300.updateYeta2300_Tax_Ye162010_02(infcPkgYe162010Vo); 	   
										 	 	 		 			   
										 	 	 		 			
									 	 	 		 			      InfcPkgYe162020SrhVO   ye162020SrhVo = new InfcPkgYe162020SrhVO();	 
									 	 							  BeanUtils.copyProperties(ye162020SrhVo, infcPkgYe161010Vo); 
									 	 							
								 	 	 		 			  		   List lstPkgYe162020Vo =  infcPkgYeta2300.fnYeta2300_YE162020_Tax_2017_A01_Select(ye162020SrhVo);
								 	 	 		 			  	   BigDecimal bgYetaC127 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC127"),"0"));
								 	 	 		 			       BigDecimal bgYetaC129 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC129"),"0"));
										 	 	 		 			     for (int iCnt03 = 0;iCnt03 < lstPkgYe162020Vo.size();iCnt03++) {
										 	 	 		 			    	 
										 	 	 		 			    	InfcPkgYe162020VO    infcPkgYe162020Vo	 = new InfcPkgYe162020VO();	//F_퇴직연금계좌명세
																		
										 	 	 		 			    	 Map tempMap01 = (Map)lstPkgYe162020Vo.get(iCnt03); 
										 	 	 		 			    	 
										 	 	 		 			    	 BeanUtils.copyProperties(infcPkgYe162020Vo, infcPkgYe161010Vo);
																			
										 	 	 		 				 infcPkgYe162020Vo.setRtpnAccAccno(MSFSharedUtils.allowNulls(tempMap01.get("rtpnAccAccno")) );
									 	 	 		 			         infcPkgYe162020Vo.setRtpnAccRtpnCl(MSFSharedUtils.allowNulls(tempMap01.get("rtpnAccRtpnCl")) );
									 	 	 		 			                     
									 	 	 		 			    	 if ("Y0040010".equals(MSFSharedUtils.allowNulls(tempMap01.get("rtpnAccRtpnCl")))) {
									 	 	 		 			    		// 
									 	 	 		 		                                     
									 	 	 		 			    		BigDecimal bgRtpnAccPymAmt = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap01.get("rtpnAccPymAmt"),"0"));
									 	 	 		 			    	    
									 	 	 		 			    		if (bgYetaC129.compareTo(bgRtpnAccPymAmt) > 0) {
									 	 	 		 			    	    	infcPkgYe162020Vo.setRtpnAccTgtAmt(bgRtpnAccPymAmt); 
									 	 	 		 			    	    bgYetaC129 = bgYetaC129.subtract(bgRtpnAccPymAmt);
									 	 	 		 			    	    } else {
									 	 	 		 			    	    	
									 	 	 		 			    	    	infcPkgYe162020Vo.setRtpnAccTgtAmt(bgYetaC129); 
									 	 	 		 			    	    bgYetaC129 = BigDecimal.ZERO;
									 	 	 		 			    	    }
									 	 	 		 			    	  
									 	 	 		 			    		
									 	 	 		 			    	    infcPkgYeta2300.updateYeta2300_Tax_Ye162020_01(infcPkgYe162020Vo);     
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
									 	 	 		 			    	   
									 	 	 		 			    		
									 	 	 		 			    	 	 infcPkgYeta2300.updateYeta2300_Tax_Ye162020_01(infcPkgYe162020Vo);     
									 	 	 		 			    	   }  
										 	 	 		 			    	 
										 	 	 		 			     }	 
										 	 	 		 			 
										 	 	 		 			     InfcPkgYe162020VO    infcPkgYe162020Vo	 = new InfcPkgYe162020VO();	//F_퇴직연금계좌명세
								 	 	 		 			    	     BeanUtils.copyProperties(infcPkgYe162020Vo, infcPkgYe161010Vo);

								 	 	 		 			    	     infcPkgYeta2300.updateYeta2300_Tax_Ye162020_02(infcPkgYe162020Vo);      
											 	 	 		 			     
								 	 	 		 			     InfcPkgYe162030SrhVO   ye162030SrhVo = new InfcPkgYe162030SrhVO();	 
								 	 							 BeanUtils.copyProperties(ye162030SrhVo, infcPkgYe161010Vo); 
								 	 						 
								 	 					                
							 	 	 		 			  		 List lstPkgYe162030Vo =  infcPkgYeta2300.fnYeta2300_YE162030_Tax_2017_A01_Select(ye162030SrhVo);
							 	 	 		 			  		 BigDecimal bgYetaC100 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC100"),"0"));
							 	 	 		 			  		 BigDecimal bgYetaC101 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC101"),"0"));
							 	 	 		 			  		 BigDecimal bgYetaC102 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC102"),"0"));
									 	 	 		 			 for (int iCnt03 = 0;iCnt03 < lstPkgYe162030Vo.size();iCnt03++) {
									 	 	 		 			 	    InfcPkgYe162030VO    infcPkgYe162030Vo	 = new InfcPkgYe162030VO();	//F_주택마련저축
																
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
								 	 	 		 			    	 
								 	 	 		 			    	    infcPkgYeta2300.updateYeta2300_Tax_YE162030_01(infcPkgYe162030Vo) ;  
									 	 	 		 			    	
									 	 	 		 			     }	 
									 	 	 		 			     
									 	 	 		 			    InfcPkgYe162040SrhVO   ye162040SrhVo = new InfcPkgYe162040SrhVO();	 
									 	 							BeanUtils.copyProperties(ye162040SrhVo, infcPkgYe161010Vo); 
									 	 							
								 	 	 		 			  		 List lstPkgYe162040Vo =  infcPkgYeta2300.fnYeta2300_YE162040_Tax_2017_A01_Select(ye162040SrhVo);
								 	 	 		 			     	 BigDecimal bgYetaC109 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC109"),"0"));
										 	 	 		 			     for (int iCnt03 = 0;iCnt03 < lstPkgYe162040Vo.size();iCnt03++) {
										 	 	 		 			    	InfcPkgYe162040VO    infcPkgYe162040Vo	 = new InfcPkgYe162040VO();	//F_장기집합투자증권저축_B1013
																		
										 	 	 		 			    	 Map tempMap01 = (Map)lstPkgYe162040Vo.get(iCnt03); 
										 	 	 		 			    	 
										 	 	 		 			    	BeanUtils.copyProperties(infcPkgYe162040Vo, infcPkgYe161010Vo);
																			
										 	 	 		 			      infcPkgYe162040Vo.setLtrmCniSsAccno(MSFSharedUtils.allowNulls(tempMap01.get("ltrmCniSsAccno")) );
										 	 	 		 		    	  infcPkgYe162040Vo.setLtrmCniSsfnnCl(MSFSharedUtils.allowNulls(tempMap01.get("ltrmCniSsfnnCl")) );
									 	 	 		 			          BigDecimal bgLtrmCniSsPymAmt = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap01.get("ltrmCniSsPymAmt"),"0"));
									 	 	 		 			     
									 	 	 		 			    	 if ("Y0040110".equals(MSFSharedUtils.allowNulls(tempMap01.get("ltrmCniSsfnnCl")))) {
									 	 	 		 			    		// 장기집합투자증권저축_B1013
									 	 	 		 		               
									 	 	 		 			    	    if (bgYetaC109.compareTo(bgLtrmCniSsPymAmt) > 0) {
									 	 	 		 			    	    infcPkgYe162040Vo.setLtrmCniSsIncDdcAmt(bgLtrmCniSsPymAmt); 
									 	 	 		 			    	    bgYetaC109 = bgYetaC109.subtract(bgLtrmCniSsPymAmt);
									 	 	 		 			    	    } else {
									 	 	 		 			    	    	
									 	 	 		 			    	    infcPkgYe162040Vo.setLtrmCniSsIncDdcAmt(bgYetaC109); 
									 	 	 		 			    	    bgYetaC109 = BigDecimal.ZERO;
									 	 	 		 			    	    }
									 	 	 		 			    	    
									 	 	 		 			    	   } 
									 	 	 		 			      	infcPkgYeta2300.updateYeta2300_Tax_YE162040_01(infcPkgYe162040Vo) ;      
												 	 	 		 			  
										 	 	 		 			     }	 
																      //월세액거주자간 주책임차차임금 원리금상환 
																	
																	
																	   InfcPkgYe162510SrhVO   ye162510SrhVo = new InfcPkgYe162510SrhVO();	 
										 	 							BeanUtils.copyProperties(ye162510SrhVo, infcPkgYe161010Vo); 
										 	 							
																	  List lstPkgYe162510Vo =  infcPkgYeta2300.fnYeta2300_YE162510_Tax_2017_A01_Select(ye162510SrhVo);
								 	 	 		 			     	 BigDecimal bgYetaC156 = new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("yetaC156"),"0"));
										 	 	 		 			     for (int iCnt03 = 0;iCnt03 < lstPkgYe162510Vo.size();iCnt03++) {
										 	 	 		 			    	
										 	 	 		 			    	 InfcPkgYe162510VO    infcPkgYe162510Vo	 = new InfcPkgYe162510VO();	//G_월세액소득공제명세
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
									 	 	 		 			    	    
									 	 	 		 			    	    infcPkgYeta2300.updateYeta2300_Tax_Ye162510_01(infcPkgYe162510Vo) ; 
									 	 	 		 			    	 
												 	 	 		 			  
										 	 	 		 			     }	 
										 	 	 		 			 
										 	 	 		 			    InfcPkgYe162510VO    infcPkgYe162510Vo	 = new InfcPkgYe162510VO();	//G_월세액소득공제명세
																	 	BeanUtils.copyProperties(infcPkgYe162510Vo, infcPkgYe161010Vo);  
									 	 	 		 			         infcPkgYeta2300.updateYeta2300_Tax_Ye162510_02(infcPkgYe162510Vo) ;      
																	   
										 	 	 		 			    
										 	 	 		 			     InfcPkgYe162520SrhVO   ye162520SrhVo = new InfcPkgYe162520SrhVO();	 
										 	 							 BeanUtils.copyProperties(ye162520SrhVo, infcPkgYe161010Vo); 
																		 
																		 List lstPkgYe162520Vo =  infcPkgYeta2300.fnYeta2300_YE162520_Tax_2017_A01_Select(ye162520SrhVo);
									 	 	 		 			     	 Long bgYeta0c84 = Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("yeta0c84"),"0"));
											 	 	 		 			     for (int iCnt03 = 0;iCnt03 < lstPkgYe162520Vo.size();iCnt03++) {
											 	 	 		 		
											 	 	 		 			    	 InfcPkgYe162520VO    infcPkgYe162520Vo	 = new InfcPkgYe162520VO();	//G_거주자간_금전소비대차
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
										 	 	 		 			    	 
																				 
										 	 	 		 			    	infcPkgYeta2300.updateYeta2300_Tax_Ye162520_01(infcPkgYe162520Vo);    
										 	 	 		 			       
													 	 	 		 			  
											 	 	 		 			     }
						 	 	 		 			     } 
				 	 	 		 			
				 	 	 		 			  		}
				 	 	 		 			  		
				 	 	 		 			  	
				 	 	 		 			  		}
	 	 	 		 	                     }  
	 	 	 		 	              
	 	 	 		 			  	 /************************* 대상자별로 루프 종료 ***************************************************/ 

		 	 	 		 	     }
		 	 	 		    		     
		 	 	 		      }
		 	 		        }
		  		  			
		  		  		} 
	                 		  				
		  			}
		  			
		  	//	} 
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
																						 
																				  			
																			              
																						  			
																						  	  }   ////////////
																					  //		}
																				  			
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
									 	 //  }
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