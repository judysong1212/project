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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161005VO;
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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162510VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162520VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162530VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe164010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030TempVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe165030VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe166010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe166020VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe169010aVO;
import com.app.smrmf.pkg.yeta.yeta2017.tax.service.Yeta2300PayrService;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta2300SubtTaxStdDdcPkgProc  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta2300SubtTaxStdDdcPkgProc.class);
	   
    @Resource(name = "Yeta2300PayrService")
    protected Yeta2300PayrService  infcPkgYeta2300;
    
 
    public Yeta2300SubtTaxStdDdcPkgProc() {
    	
    } 
    
    public List<ShowMessageBM> execSubtTaxStdDdcPkgProc(HttpServletRequest request,InfcPkgYe161010VO  infcPkgYe161010Vo)  throws Exception  {
  	    
	  	  return  YetaTaxCreateUpdate(request,  infcPkgYe161010Vo);
	}
     
    
   
   /**
    *  
    * <pre>
    * 1. 개요 : 기본 
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : YetaTaxCreateUpdate
    * @date : 2018. 1. 31.
    * @author : atres
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	2018. 1. 31.		atres				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param infcPkgYe161010Vo
    * @return
    * @throws Exception
    */
    private  List<ShowMessageBM> YetaTaxCreateUpdate(HttpServletRequest request,InfcPkgYe161010VO  infcPkgYe161010Vo) throws Exception {
	  
    	
      
  	   List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
  	   
       if ("TRUE".equals(infcPkgYe161010Vo.getSpciDdctCheck())) {
     	  
     	  bmResult = YetaTaxStdUpdate(request,infcPkgYe161010Vo);
       } else {
     	  
     	  bmResult = YetaTaxBaseUpdate(request,infcPkgYe161010Vo);
       }
       
  	 
	 
        return bmResult;
		 
  }
   
    private  List<ShowMessageBM> YetaTaxStdUpdate(HttpServletRequest request,InfcPkgYe161010VO  infcPkgYe161010Vo) throws Exception {
  	  
    	
       PagingLoadResult<ShowMessageBM> retval = null; 
   	   List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
   	   MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
   	  
   	   infcPkgYeta2300 = (Yeta2300PayrService)BeanFinder.getBean("Yeta2300PayrService"); 
   	   
 	  int statCnt = 0;
 	  String dataCheck = "";
 	  
  
       BigDecimal exPRDD_TAXN   = BigDecimal.ZERO;
       BigDecimal exTAXD_ICAX   = BigDecimal.ZERO;
       BigDecimal exTAXD_SPCT   = BigDecimal.ZERO;
       BigDecimal exTXLG_CL30   = BigDecimal.ZERO;
       BigDecimal exTXLG_HXTT   = BigDecimal.ZERO;
       BigDecimal exTAXD_TSUM   = BigDecimal.ZERO;
       BigDecimal exTAXD_WKEN   = BigDecimal.ZERO;
       BigDecimal exADDR_MCCR   = BigDecimal.ZERO;
       BigDecimal exJRTR_HICT   = BigDecimal.ZERO;
       BigDecimal exJRTR_PSRN   = BigDecimal.ZERO;
       BigDecimal exJRTR_HNSV    = BigDecimal.ZERO;
       BigDecimal exSPCI_RTDE   = BigDecimal.ZERO;
       BigDecimal exSPCI_TXCR   = BigDecimal.ZERO;
       BigDecimal exSPED_TXCR   = BigDecimal.ZERO;
       BigDecimal exTAXD_PLTC   = BigDecimal.ZERO;
       BigDecimal exSPCI_PLTC   = BigDecimal.ZERO;
       BigDecimal exSPCI_FBAM   = BigDecimal.ZERO;
       BigDecimal exSPCI_RFAM  = BigDecimal.ZERO;
       BigDecimal exSPCI_NAMT   = BigDecimal.ZERO;
       BigDecimal exSPCI_DCTO   = BigDecimal.ZERO;
       BigDecimal exSPCI_DDCT   = BigDecimal.ZERO;
       BigDecimal exTAXD_UNIN   = BigDecimal.ZERO;
       BigDecimal exTAXD_LOAN   = BigDecimal.ZERO;
       BigDecimal exTAXD_PAID   = BigDecimal.ZERO;
       BigDecimal exSPCI_RTAM   = BigDecimal.ZERO;                  
       BigDecimal exTAXD_CSUM   = BigDecimal.ZERO;
       BigDecimal exTpPRDD_TAXN   = BigDecimal.ZERO;
       BigDecimal exSPCI_YAMT   = BigDecimal.ZERO;
       BigDecimal exADDR_CHLD   = BigDecimal.ZERO; 
       BigDecimal exADDR_BRTH   = BigDecimal.ZERO;
       BigDecimal exSPCI_GURT   = BigDecimal.ZERO;
       BigDecimal exSPCI_HDRC   = BigDecimal.ZERO;
 	  
       InfcPkgYe160401VO    infcPkgYe160401Vo	 = new InfcPkgYe160401VO();	//현근무지급여지급명세
 		InfcPkgYe160402VO    infcPkgYe160402Vo	 = new InfcPkgYe160402VO();	//현근무지비과세_감면소득_과세
 		InfcPkgYe160403VO    infcPkgYe160403Vo	 = new InfcPkgYe160403VO();	//현근무지비과세_감면소득_비과세
 		
 		InfcPkgYe160404VO    infcPkgYe160404Vo	 = new InfcPkgYe160404VO();	//D_종전근무처
 		InfcPkgYe160405VO    infcPkgYe160405Vo	 = new InfcPkgYe160405VO();	//D_종전근무처비과세_감면소득_비과세
 		InfcPkgYe160406VO    infcPkgYe160406Vo	 = new InfcPkgYe160406VO();	//종전근무지연금보험료_공적연금
 		InfcPkgYe160510VO    infcPkgYe160510Vo	 = new InfcPkgYe160510VO();	//근무지별비과세_감면소득
 		
 		InfcPkgYe161005VO    infcPkgYe161005Vo	 = new InfcPkgYe161005VO();	//A_원천세신고기본
 		
 		//InfcPkgYe161010VO    infcPkgYe161010Vo	 = new InfcPkgYe161010VO();	// 연말정산대상자기본
 		InfcPkgYe161020VO    infcPkgYe161020Vo	 = new InfcPkgYe161020VO();	//A_인적소득공제기본
 		InfcPkgYe161030VO    infcPkgYe161030Vo	 = new InfcPkgYe161030VO();	//E_인적공제명세
 		InfcPkgYe161040VO    infcPkgYe161040Vo	 = new InfcPkgYe161040VO();	//E_소득세액공제명세
 		InfcPkgYe161050VO    infcPkgYe161050Vo	 = new InfcPkgYe161050VO();	//C_연금보험료공제
 		InfcPkgYe161055VO    infcPkgYe161055Vo	 = new InfcPkgYe161055VO();	//C_연금보험료_공적연금상세
 		InfcPkgYe161060VO    infcPkgYe161060Vo	 = new InfcPkgYe161060VO();	//C_특별소득공제
 		InfcPkgYe161070VO    infcPkgYe161070Vo	 = new InfcPkgYe161070VO();	//C_그밖의소득공제
 		InfcPkgYe161080VO    infcPkgYe161080Vo	 = new InfcPkgYe161080VO();	//C_세액감면및공제
 		InfcPkgYe161090VO    infcPkgYe161090Vo	 = new InfcPkgYe161090VO();	//C_교육비내역
 		InfcPkgYe162010VO    infcPkgYe162010Vo	 = new InfcPkgYe162010VO();	//F_연금저축계좌
 		InfcPkgYe162020VO    infcPkgYe162020Vo	 = new InfcPkgYe162020VO();	//F_퇴직연금계좌명세
 		InfcPkgYe162030VO    infcPkgYe162030Vo	 = new InfcPkgYe162030VO();	//F_주택마련저축
 		InfcPkgYe162040VO    infcPkgYe162040Vo	 = new InfcPkgYe162040VO();	//F_장기집합투자증권저축_B1013
 		InfcPkgYe162510VO    infcPkgYe162510Vo	 = new InfcPkgYe162510VO();	//G_월세액소득공제명세
 		InfcPkgYe162520VO    infcPkgYe162520Vo	 = new InfcPkgYe162520VO();	//G_거주자간_금전소비대차
 		InfcPkgYe162530VO    infcPkgYe162530Vo	 = new InfcPkgYe162530VO();	//G_임대차계약
 		InfcPkgYe164010VO    infcPkgYe164010Vo	 = new InfcPkgYe164010VO();	//A_의료비지급명세
 		InfcPkgYe165010VO    infcPkgYe165010Vo	 = new InfcPkgYe165010VO();	//I_해당연도기부금명세
 		InfcPkgYe165020VO    infcPkgYe165020Vo	 = new InfcPkgYe165020VO();	//I_기부자관계코드별기부금합계
 		InfcPkgYe165030VO    infcPkgYe165030Vo	 = new InfcPkgYe165030VO();	//H_기부금조정명세
 		InfcPkgYe165030TempVO infcPkgYe165030TempVo = new InfcPkgYe165030TempVO();  	    //H_기부금조정명세_TEMP	 
 		InfcPkgYe166010VO    infcPkgYe166010Vo	 = new InfcPkgYe166010VO();	//신용카드등소득공제명세
 		InfcPkgYe166020VO    infcPkgYe166020Vo	 = new InfcPkgYe166020VO();	//신용카드등소득공제상세
 			 								//
 		//InfcPkgYe169010VO    infcPkgYe169010Vo	 = new InfcPkgYe169010VO();	//C_주현근무처
 		InfcPkgYe169010aVO   infcPkgYe169010AVo = new InfcPkgYe169010aVO();	//C_주현근무처_표준공제 
 	
 	  	 
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
 	BeanUtils.copyProperties(infcPkgYe162010Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe162020Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe162030Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe162040Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe162510Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe162520Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe162530Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe164010Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe165010Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe165020Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe165030Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe165030TempVo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe166010Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe166020Vo, infcPkgYe161010Vo);
 	//BeanUtils.copyProperties(infcPkgYe169010Vo, infcPkgYe161010Vo); 
 	BeanUtils.copyProperties(infcPkgYe169010AVo, infcPkgYe161010Vo); 
      
       /**#######################  특별공제 종합한도초과액 - 기타공제계 ############################################*/
       //   ---------------------특별공제 종합한도초과액 - 기타공제계-----------------
 		 
 			statCnt = 0;
 			statCnt = infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_3001_Update(infcPkgYe169010AVo);
 			if (statCnt >= 0) {
 			/**
 			 * ####################### 종합소득과세표준 기타공제계 ############################################			 */
 			
 				statCnt = 0;
 				statCnt = infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_3002_Update(infcPkgYe169010AVo);
 				if (statCnt >= 0) {
 				
 					/** ####################### 산출세액- 기타공제계-  * ############################################  */
 			
 					statCnt = 0;
 					statCnt = infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_3003_Update(infcPkgYe169010AVo);
 					if (statCnt >= 0) {
 					/**
 					 * ####################### 산출세액-세액감면  ############################################ */
 				
 						statCnt = 0;
 						statCnt = infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_3004_Update(infcPkgYe169010AVo);
 						if (statCnt >= 0) {
 						/**
 						 * ####################### 세액공제 -근로소득공제 감면세액계  ############################################
 						 */
 					
 							statCnt = 0;
 							statCnt = infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_3005_Update(infcPkgYe169010AVo);

 							if (statCnt >= 0) {
 							      /**#######################  세액공제 주택차입금 ----- 외국납부    ############################################*/
 							
 								infcPkgYe169010AVo.setYetaStdC152(new BigDecimal("130000"));
 								statCnt = 0;
 								statCnt =  infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_3006_Update(infcPkgYe169010AVo);
 								if (statCnt >= 0) {
 									
 							          /**#######################  교육비합계 사용안함 나중에 확인     ############################################*/
 						 
// 									statCnt = 0;
// 									statCnt =  infcPkgYeta2300.fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(infcPkgYe169010AVo); 
// 									
// 									if (statCnt >= 0) {
 								      /**#######################      ############################################*/
 									if (statCnt >= 0) {
 								     //YETA_C152
 								 
 											
 								     infcPkgYe169010AVo.setC152StdTxDdcYn("Y");
 										 
 									statCnt = 0;
 									statCnt =  infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_3007_Update(infcPkgYe169010AVo); 

 									if (statCnt >= 0) {	 

 										/******************************************************************************************
 										 * 산출세액에 따른 세액공제 0처리 및 단계별 빼기 작업을 위한 구현 부
 										 * 
 										 *******************************************************************************************/
 									
 										   /**#######################      ############################################*/
 									     // InfcPkgYe169010VO infcPkgYe169010Vo = new InfcPkgYe169010VO();  //연말정산결과  
 									      InfcPkgYe169010aVO tpInfcPkgYe169010AVo = new InfcPkgYe169010aVO();  //연말정산결과  
 									      
 									      
 									      infcPkgYe169010AVo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
 									      infcPkgYe169010AVo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
 									      infcPkgYe169010AVo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
 									      infcPkgYe169010AVo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
 									      
 									      tpInfcPkgYe169010AVo = infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_2001_Select(infcPkgYe169010AVo); 
 									  
 									       
 									      if (MSFSharedUtils.paramNotNull(tpInfcPkgYe169010AVo) && MSFSharedUtils.paramNotNull(tpInfcPkgYe169010AVo.getSystemkey())) {
 									      
 									    	   
 									          exTpPRDD_TAXN  = BigDecimal.ZERO;
 									          
 									          exPRDD_TAXN  = tpInfcPkgYe169010AVo.getYetaStdC113() ;    //산출세액

 									          exTpPRDD_TAXN  = exPRDD_TAXN;

 									          exTAXD_ICAX  = tpInfcPkgYe169010AVo.getYetaStdC114(); //oraQrySelect05.FieldByName('TAXD_ICAX').AsFloat;     //소득세법
 									          if (exTpPRDD_TAXN.compareTo(exTAXD_ICAX) > 0) {
 									             exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_ICAX); 
 									          }
 									          else
 									          {
 									             exTAXD_ICAX = BigDecimal.ZERO;
 									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									                 exTAXD_ICAX = exTpPRDD_TAXN;
 									                 exTpPRDD_TAXN = BigDecimal.ZERO;
 									             }

 									          }
 									          exTAXD_SPCT  = tpInfcPkgYe169010AVo.getYetaStdC115(); //oraQrySelect05.FieldByName('TAXD_SPCT').AsFloat;      //조세특례법54제회
 									           if (exTpPRDD_TAXN.compareTo(exTAXD_SPCT) > 0) {
 									             exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_SPCT);
 									           }
 									           else
 									           {
 									             exTAXD_SPCT = BigDecimal.ZERO;
 									              if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									                 exTAXD_SPCT = exTpPRDD_TAXN;
 									                 exTpPRDD_TAXN = BigDecimal.ZERO;
 									              }
 									          }
 									          exTXLG_CL30   = tpInfcPkgYe169010AVo.getYetaStdC116(); //oraQrySelect05.FieldByName('TXLG_CL30').AsFloat;      //조특법 제30조
 									           if (exTpPRDD_TAXN.compareTo(exTXLG_CL30) > 0)   {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTXLG_CL30);
 									           }
 									           else
 									           {
 									              exTXLG_CL30 = BigDecimal.ZERO;
 									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									                 exTXLG_CL30 = exTpPRDD_TAXN;
 									                 exTpPRDD_TAXN = BigDecimal.ZERO;
 									             }
 									           }
 									           
 									          exTXLG_HXTT  = tpInfcPkgYe169010AVo.getYetaStdC117(); //oraQrySelect05.FieldByName('TXLG_HXTT').AsFloat;      //조세조약
 									        if (exTpPRDD_TAXN.compareTo(exTXLG_HXTT) > 0)  {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTXLG_HXTT);
 									        }
 									        else
 									        {
 									           exTXLG_HXTT = BigDecimal.ZERO;
 									              if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									                exTXLG_HXTT   = exTpPRDD_TAXN;
 									                exTpPRDD_TAXN = BigDecimal.ZERO;
 									              }
 									        }
 									       //   exTAXD_TSUM  := oraQrySelect05.FieldByName('TAXD_TSUM').AsFloat;      //세액감면계
 									          exTAXD_WKEN  = tpInfcPkgYe169010AVo.getYetaStdC120();   // oraQrySelect05.FieldByName('TAXD_WKEN').AsFloat;       //근로소득세액공제
 									          if (exTpPRDD_TAXN.compareTo(exTAXD_WKEN) > 0)  {   
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_WKEN);
 									          }
 									          else
 									          {
 									            exTAXD_WKEN = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									                 exTAXD_WKEN  = exTpPRDD_TAXN;
 									                 exTpPRDD_TAXN = BigDecimal.ZERO;
 									            }
 									          }
 									          exADDR_MCCR  = tpInfcPkgYe169010AVo.getYetaStdC122(); //oraQrySelect05.FieldByName('ADDR_MCCR').AsFloat;       //자녀세액공제
 									        if (exTpPRDD_TAXN.compareTo(exADDR_MCCR) > 0)   {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exADDR_MCCR);
 									        }
 									        else
 									        {
 									           exADDR_MCCR = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									                exADDR_MCCR   = exTpPRDD_TAXN;
 									                exTpPRDD_TAXN = BigDecimal.ZERO;
 									            }
 									        }

 									        exADDR_CHLD  = tpInfcPkgYe169010AVo.getYetaStdC124() ; //oraQrySelect05.FieldByName('ADDR_CHLD').AsFloat;       //추가공제_자녀양육비
 									        if (exTpPRDD_TAXN.compareTo(exADDR_CHLD) > 0)      {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exADDR_CHLD);
 									        }
 									        else
 									        {
 									           exADDR_CHLD = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									                exADDR_CHLD   = exTpPRDD_TAXN;
 									                exTpPRDD_TAXN = BigDecimal.ZERO;
 									            }
 									        }

 									            exADDR_BRTH  = tpInfcPkgYe169010AVo.getYetaStdC126() ; //oraQrySelect05.FieldByName('ADDR_BRTH').AsFloat;      //추가공제_출산자녀양육비
 									        if (exTpPRDD_TAXN.compareTo(exADDR_BRTH) > 0) {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exADDR_BRTH);
 									        }
 									        else
 									        {
 									           exADDR_BRTH = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									                exADDR_BRTH   = exTpPRDD_TAXN;
 									                exTpPRDD_TAXN = BigDecimal.ZERO;
 									            }
 									        }


 									        
 									          exSPCI_GURT  = tpInfcPkgYe169010AVo.getYetaStdC134(); // oraQrySelect05.FieldByName('SPCI_GURT').AsFloat;        //특별공제 보장성보험료공제
 									           if (exTpPRDD_TAXN.compareTo(exSPCI_GURT ) > 0) {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_GURT);
 									           }
 									        else
 									        {
 									           exSPCI_GURT  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									               exSPCI_GURT    = exTpPRDD_TAXN;
 									               exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									        }

 									        exSPCI_HDRC  = tpInfcPkgYe169010AVo.getYetaStdC136(); //oraQrySelect05.FieldByName('SPCI_HDRC').AsFloat;        //특별공제 보장성보험료공제장애인
 									           if (exTpPRDD_TAXN.compareTo(exSPCI_HDRC ) > 0) {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_HDRC);
 									           }
 									        else
 									        {
 									           exSPCI_HDRC  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									               exSPCI_HDRC    = exTpPRDD_TAXN;
 									               exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									        }
 									        //보장성보험료 합계 수정 처리 루틴 추가 
 									        exSPCI_RTDE =   exSPCI_GURT.add(exSPCI_HDRC) ;

 									          exSPCI_TXCR  = tpInfcPkgYe169010AVo.getYetaStdC138(); //oraQrySelect05.FieldByName('SPCI_TXCR').AsFloat;          //의료비세액공제
 									        if (exTpPRDD_TAXN.compareTo(exSPCI_TXCR ) > 0) {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_TXCR);
 									          }
 									        else
 									        {
 									           exSPCI_TXCR  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
 									              exSPCI_TXCR     = exTpPRDD_TAXN;
 									              exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									        }
 									        
 									          exSPED_TXCR  = tpInfcPkgYe169010AVo.getYetaStdC140(); //oraQrySelect05.FieldByName('SPED_TXCR').AsFloat;         //교육비 세액공제
 									          if (exTpPRDD_TAXN.compareTo(exSPED_TXCR) > 0)  {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPED_TXCR);
 									          }
 									        else
 									        {
 									           exSPED_TXCR  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									                exSPED_TXCR   = exTpPRDD_TAXN;
 									                exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									        }
 									          
 									         
 									          /*************************************************************************
 									           * 기부금 이월분 처리 추가 
 									           ************************************************************************/
 									        exTAXD_PLTC  = tpInfcPkgYe169010AVo.getYetaStdC142(); //oraQrySelect05.FieldByName('TAXD_PLTC').AsFloat;         //정치기부금 10만원이하 공제
 									        if (exTpPRDD_TAXN.compareTo(exTAXD_PLTC ) > 0) {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_PLTC);
 									        }
 									        else
 									        {
 									            exTAXD_PLTC  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
 									            
 									            	
 									            	
 									            	exTAXD_PLTC = fnRtnSubTaxConTrbution(  request,   infcPkgYe161010Vo,  exTpPRDD_TAXN,"20","Y");
 									                
 									            	 if (exTAXD_PLTC.compareTo(BigDecimal.ZERO)  <= 0)  {
 									            		 exTAXD_PLTC    = exTpPRDD_TAXN;
 									            	 }
 									                 exTpPRDD_TAXN  = BigDecimal.ZERO;
 									               
 									               
 									            }
 									        }
 									        
 									          exSPCI_PLTC  = tpInfcPkgYe169010AVo.getYetaStdC144(); //oraQrySelect05.FieldByName('SPCI_PLTC').AsFloat;         //정치기부금 10만원 초과 공제
 									           if (exTpPRDD_TAXN.compareTo(exSPCI_PLTC ) > 0)  {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_PLTC);
 									           }
 									        else
 									        {
 									           exSPCI_PLTC  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									              
 									            	exSPCI_PLTC = fnRtnSubTaxConTrbution(  request,   infcPkgYe161010Vo,  exTpPRDD_TAXN,"20","Y");
 									             if (exSPCI_PLTC.compareTo(BigDecimal.ZERO)  <= 0)  {
 									            	exSPCI_PLTC    = exTpPRDD_TAXN;
									             }
 									              
 									              
 									               exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									        }
 									      
 									        //  exSPCI_DCTO  := oraQrySelect05.FieldByName('SPCI_DCTO').AsFloat;          //특별세액공제계
 									          exSPCI_DDCT  = tpInfcPkgYe169010AVo.getYetaStdC152(); //oraQrySelect05.FieldByName('SPCI_DDCT').AsFloat;           //표준세액공제
 									         if (exTpPRDD_TAXN.compareTo(exSPCI_DDCT ) > 0)  {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_DDCT);
 									         }
 									        else
 									        {
 									           exSPCI_DDCT  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									               exSPCI_DDCT    = exTpPRDD_TAXN;
 									               exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									        }
 									          exTAXD_UNIN  = tpInfcPkgYe169010AVo.getYetaStdC153(); //oraQrySelect05.FieldByName('TAXD_UNIN').AsFloat;           //납세조합공제
 									           if (exTpPRDD_TAXN.compareTo(exTAXD_UNIN ) > 0) {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_UNIN);
 									           }
 									        else
 									        {
 									           exTAXD_UNIN  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									               exTAXD_UNIN    = exTpPRDD_TAXN;
 									               exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									        }
 									          exTAXD_LOAN  = tpInfcPkgYe169010AVo.getYetaStdC154(); //oraQrySelect05.FieldByName('TAXD_LOAN').AsFloat;            //주책차입금
 									          if (exTpPRDD_TAXN.compareTo(exTAXD_LOAN) > 0)  {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_LOAN);
 									          }
 									        else
 									        {
 									           exTAXD_LOAN = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									                exTAXD_LOAN   = exTpPRDD_TAXN;
 									                exTpPRDD_TAXN = BigDecimal.ZERO;
 									            }
 									        }
 									      
 									      
 									          exSPCI_RTAM  = tpInfcPkgYe169010AVo.getYetaStdC157(); //oraQrySelect05.FieldByName('SPCI_RTAM').AsFloat;            //월세액공제
 									        //  exTAXD_CSUM  := oraQrySelect05.FieldByName('TAXD_CSUM').AsFloat;
 									         if (exTpPRDD_TAXN.compareTo(exSPCI_RTAM) > 0)   {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_RTAM);
 									      }
 									        else
 									        {
 									           exSPCI_RTAM  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									              exSPCI_RTAM    = exTpPRDD_TAXN;
 									              exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									      }
 									         

 									        exSPCI_FBAM = BigDecimal.ZERO;   // = tpInfcPkgYe169010AVo.getYetaStdC146(); //oraQrySelect05.FieldByName('SPCI_FBAM').AsFloat;          //기부금_법정기부금_세액공제
// 									      if (exTpPRDD_TAXN.compareTo(exSPCI_FBAM ) > 0)  {
// 									        exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_FBAM);
// 									       }
// 									     else
// 									     {
// 									        exSPCI_FBAM  = BigDecimal.ZERO;
// 									         if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									        	  
 									         exSPCI_FBAM =   fnRtnSubTaxConTrbution(  request,   infcPkgYe161010Vo,  exTpPRDD_TAXN,"10","Y");
 									         exSPCI_FBAM = BigDecimal.ZERO;   
// 									          	if (exSPCI_FBAM.compareTo(BigDecimal.ZERO)  <= 0)  {
// 									          		exSPCI_FBAM  = exTpPRDD_TAXN;
//									            } 
// 									        
// 									             exTpPRDD_TAXN  = BigDecimal.ZERO;
// 									         }
// 									     }
 									      
 									       exSPCI_RFAM  =tpInfcPkgYe169010AVo.getYetaStdC148(); // oraQrySelect05.FieldByName('SPCI_RFAM').AsFloat;          //우리사주조합부금_세액공제
 									      if (exTpPRDD_TAXN.compareTo(exSPCI_RFAM ) > 0)  {
 									        exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_RFAM);
 									      }
 									     else
 									     {
 									  	     exSPCI_RFAM  = BigDecimal.ZERO;
 									         if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									        	 
 									        	exSPCI_RFAM = fnRtnSubTaxConTrbution(  request,   infcPkgYe161010Vo,  exTpPRDD_TAXN,"42","Y");
 									         if (exSPCI_RFAM.compareTo(BigDecimal.ZERO)  <= 0)  {
 									        	  exSPCI_RFAM     = exTpPRDD_TAXN;
							                 } 
 									          
 									        
 									           exTpPRDD_TAXN  = BigDecimal.ZERO;
 									         }
 									     }
 									      
 									       
 									       exSPCI_NAMT = BigDecimal.ZERO;   //  = tpInfcPkgYe169010AVo.getYetaStdC150(); // oraQrySelect05.FieldByName('SPCI_NAMT').AsFloat;          //지정기부금_세액공제종교외
// 									      if (exTpPRDD_TAXN.compareTo(exSPCI_NAMT ) > 0)  {
// 									        exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_NAMT);
// 									      }
// 									     else
// 									     {
// 									        exSPCI_NAMT  = BigDecimal.ZERO;
// 									         if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									        	exSPCI_NAMT =  	  fnRtnSubTaxConTrbution(  request,   infcPkgYe161010Vo,  exTpPRDD_TAXN,"40","Y");
 									            exSPCI_NAMT = BigDecimal.ZERO; 
// 									        	if (exSPCI_NAMT.compareTo(BigDecimal.ZERO)  <= 0)  {
// 									        	   exSPCI_NAMT     = exTpPRDD_TAXN;
//							                    }  
// 									       
// 									            exTpPRDD_TAXN  = BigDecimal.ZERO;
// 									         }
// 									     }
 									      
 									     exSPCI_YAMT  = BigDecimal.ZERO; //= tpInfcPkgYe169010AVo.getYetaStdC150b(); //oraQrySelect05.FieldByName('SPCI_YAMT').AsFloat;          //지정기부금_세액공제
// 									      if (exTpPRDD_TAXN.compareTo(exSPCI_YAMT ) > 0)  {
// 									        exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_YAMT);
// 									      }
// 									     else
// 									     {
// 									          exSPCI_YAMT  = BigDecimal.ZERO;
 									    //     if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									          exSPCI_YAMT =  fnRtnSubTaxConTrbution(  request,   infcPkgYe161010Vo,  exTpPRDD_TAXN,"41","Y");
 									           exSPCI_YAMT  = BigDecimal.ZERO; 
 									          // 									            exSPCI_YAMT    = exTpPRDD_TAXN;
// 									            exTpPRDD_TAXN  = BigDecimal.ZERO;
// 									         }
// 									     }
 									        
 									      /**********************************************************************
 									       * 이월기부금. 정리  
 									       ***********************************************************************/
 									      
 									         exTAXD_PAID  = tpInfcPkgYe169010AVo.getYetaStdC155(); //oraQrySelect05.FieldByName('TAXD_PAID').AsFloat;            //외국납부
 									         if (exTpPRDD_TAXN.compareTo(exTAXD_PAID) > 0)  {
 									          exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_PAID);
 									       }
 									       else
 									       {
 									          exTAXD_PAID  = BigDecimal.ZERO;
 									           if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
 									              exTAXD_PAID    = exTpPRDD_TAXN;
 									              exTpPRDD_TAXN  = BigDecimal.ZERO;
 									           }
 									     }
 									         

 									         exJRTR_HICT  = tpInfcPkgYe169010AVo.getYetaStdC128(); //oraQrySelect05.FieldByName('JRTR_HICT').AsFloat;        //연금계좌_과학기술인공제
 									         if (exTpPRDD_TAXN.compareTo(exJRTR_HICT ) > 0) {
 									          exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exJRTR_HICT);
 									         }
 									       else
 									       {
 									          exJRTR_HICT  = BigDecimal.ZERO;
 									           if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
 									               exJRTR_HICT   = exTpPRDD_TAXN;
 									               exTpPRDD_TAXN  = BigDecimal.ZERO;
 									           }
 									       }
 									       
 									         exJRTR_PSRN  = tpInfcPkgYe169010AVo.getYetaStdC130(); //oraQrySelect05.FieldByName('JRTR_PSRN').AsFloat;        //연금계좌_근로자퇴직급여보장법 세액공제
 									         if (exTpPRDD_TAXN.compareTo(exJRTR_PSRN) > 0) {
 									          exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exJRTR_PSRN);
 									         }
 									       else
 									       {
 									          exJRTR_PSRN  = BigDecimal.ZERO;
 									           if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									             exJRTR_PSRN     = exTpPRDD_TAXN;
 									             exTpPRDD_TAXN  = BigDecimal.ZERO;
 									           }
 									       }
 									       
 									         exJRTR_HNSV  = tpInfcPkgYe169010AVo.getYetaStdC132(); //oraQrySelect05.FieldByName('JRTR_HNSV').AsFloat;        //연금계좌_연금저축_공제
 									         if (exTpPRDD_TAXN.compareTo(exJRTR_HNSV ) > 0) {
 									          exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exJRTR_HNSV);
 									         }
 									       else
 									       {
 									          exJRTR_HNSV  = BigDecimal.ZERO;
 									           if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									             exJRTR_HNSV     = exTpPRDD_TAXN;
 									             exTpPRDD_TAXN  = BigDecimal.ZERO;
 									           }
 									       }
 									       
 									       
 									        if (exTAXD_PLTC.compareTo(BigDecimal.ZERO) == 0 &&
  									        		exSPCI_PLTC.compareTo(BigDecimal.ZERO) == 0 &&
  									        				exSPCI_FBAM.compareTo(BigDecimal.ZERO) == 0 &&
  									        						exSPCI_RFAM.compareTo(BigDecimal.ZERO) == 0 &&
  									        								exSPCI_NAMT.compareTo(BigDecimal.ZERO) == 0 &&
  									        										exSPCI_YAMT.compareTo(BigDecimal.ZERO) == 0 ) {
  									        	exSPCI_YAMT =  fnRtnSubTaxConTrbution(  request,   infcPkgYe161010Vo,  exTpPRDD_TAXN,"00","Y");
  									        	  
  									        	// if (exSPCI_YAMT.compareTo(BigDecimal.ZERO)  < 0)  {
  									        		//exSPCI_YAMT    = exTpPRDD_TAXN;
								                // }  
  									        	exSPCI_YAMT  = BigDecimal.ZERO;
  									        } 

 									          //   {retax-57}
 												/**#######################      ############################################*/
 									        
 									        infcPkgYe169010AVo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
 									        infcPkgYe169010AVo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
 									        infcPkgYe169010AVo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
 									        infcPkgYe169010AVo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
 									     
// 									        infcPkgYe169010AVo.setBefoScnt(yeta3000Dto.getBefoScnt());    /** column 종전근무지수 : befoScnt */
// 									        infcPkgYe169010AVo.setPayrTamt(yeta3000Dto.getPayrTamt());    /** column 주근무지_급여총액 : payrTamt */
// 									        infcPkgYe169010AVo.setBonsToam(yeta3000Dto.getBonsToam());    /** column 주근무지_상여총액 : bonsToam */
// 									        infcPkgYe169010AVo.setDtmnBsam(yeta3000Dto.getDtmnBsam());    /** column 주근무지_인정상여총액 : dtmnBsam */
// 									        infcPkgYe169010AVo.setStckPrft(yeta3000Dto.getStckPrft());    /** column 주근무지_주식행사이익 : stckPrft */
// 									        infcPkgYe169010AVo.setCurrTots(yeta3000Dto.getCurrTots());    /** column 주근무지총급여액 : currTots */
// 									        infcPkgYe169010AVo.setTaxmSfam(yeta3000Dto.getTaxmSfam());    /** column 비과세_자가운전보조금액_del : taxmSfam */
// 									        infcPkgYe169010AVo.setTaxmEtam(yeta3000Dto.getTaxmEtam());    /** column 비과세_급양비금액_del : taxmEtam */
// 									        infcPkgYe169010AVo.setTaxmBoin(yeta3000Dto.getTaxmBoin());    /** column 비과세_보육수당_del : taxmBoin */
// 									        infcPkgYe169010AVo.setTxecAmnt(yeta3000Dto.getTxecAmnt());    /** column 비과세_외국인소득금액_del : txecAmnt */
// 									        infcPkgYe169010AVo.setTotlSala(yeta3000Dto.getTotlSala());    /** column 총급여_현_전 : totlSala */
// 									        infcPkgYe169010AVo.setWkerDdct(yeta3000Dto.getWkerDdct());    /** column 근로소득공제 : wkerDdct */
// 									        infcPkgYe169010AVo.setWkerAmnt(yeta3000Dto.getWkerAmnt());    /** column 근로소득금액 : wkerAmnt */
// 									        infcPkgYe169010AVo.setBaseSelf(yeta3000Dto.getBaseSelf());    /** column 기본공제_본인 : baseSelf */
// 									        infcPkgYe169010AVo.setBaseWife(yeta3000Dto.getBaseWife());    /** column 기본공제_배우자 : baseWife */
// 									        infcPkgYe169010AVo.setBaseFyam(yeta3000Dto.getBaseFyam());    /** column 기본공제_부양가족 : baseFyam */
// 									        infcPkgYe169010AVo.setAddrHdam(yeta3000Dto.getAddrHdam());    /** column 추가공제_장애인 : addrHdam */
// 									        infcPkgYe169010AVo.setAddrRpt70(yeta3000Dto.getAddrRpt70());    /** column 추가공제_경로우대70 : addrRpt70 */
// 									        infcPkgYe169010AVo.setAddrFame(yeta3000Dto.getAddrFame());    /** column 추가공제_부녀자 : addrFame */
 									      
 									        infcPkgYe169010AVo.setYetaStdC122(exADDR_MCCR);    /** column C122_세액공제_자녀세액공제금액 : yetaC122 */
 									        infcPkgYe169010AVo.setYetaStdC124(exADDR_CHLD);    /** column C124_세액공제_6세이하자녀세액공제금액 : yetaC124 */
 									        infcPkgYe169010AVo.setYetaStdC126(exADDR_BRTH);    /** column C126_세액공제_출산입양세액공제금액 : yetaC126 */
 									        
// 									         infcPkgYe169010AVo.setAddrChld(exADDR_CHLD);    /** column 추가공제_자녀양육비 : addrChld */
// 									         infcPkgYe169010AVo.setAddrBrth(exADDR_BRTH);    /** column 추가공제_출산자녀양육비 : addrBrth */
// 									        infcPkgYe169010AVo.setPantOnam(yeta3000Dto.getPantOnam());    /** column 추가공제_한부모공제금액 : pantOnam */
// 									        infcPkgYe169010AVo.setAddrMcam(yeta3000Dto.getAddrMcam());    /** column 추가공제_다자녀 : addrMcam */
// 									        infcPkgYe169010AVo.setBnatDdct(yeta3000Dto.getBnatDdct());    /** column 종근무지_국민연금보험료공제 : bnatDdct */
// 									        infcPkgYe169010AVo.setJnatDdct(yeta3000Dto.getJnatDdct());    /** column 주근무지_국민연금보험료공제 : jnatDdct */
// 									        infcPkgYe169010AVo.setBpssDdct(yeta3000Dto.getBpssDdct());    /** column 종근무지_별정우체국연금보험료공제 : bpssDdct */
// 									        infcPkgYe169010AVo.setBpssHsol(yeta3000Dto.getBpssHsol());    /** column 종근무지_국민연금외군인연금공제 : bpssHsol */
// 									        infcPkgYe169010AVo.setBpssHtec(yeta3000Dto.getBpssHtec());    /** column 종근무지_국민연금외교직원연금공제 : bpssHtec */
// 									        infcPkgYe169010AVo.setBpssHpul(yeta3000Dto.getBpssHpul());    /** column 종근무지_국민연금외공무원연금공제 : bpssHpul */
// 									        infcPkgYe169010AVo.setJpssDdct(yeta3000Dto.getJpssDdct());    /** column 주근무지_별정우체국연금보험료공제 : jpssDdct */
// 									        infcPkgYe169010AVo.setJpssHsol(yeta3000Dto.getJpssHsol());    /** column 주근무지_국민연금외군인연금공제 : jpssHsol */
// 									        infcPkgYe169010AVo.setJpssHtec(yeta3000Dto.getJpssHtec());    /** column 주근무지_국민연금외교직원연금공제 : jpssHtec */
// 									        infcPkgYe169010AVo.setJpssHpul(yeta3000Dto.getJpssHpul());    /** column 주근무지_공무원연금보험료공제 : jpssHpul */
// 									        infcPkgYe169010AVo.setBrtrHict(yeta3000Dto.getBrtrHict());    /** column 종근무지_퇴직연금과학기술인공제 : brtrHict */
// 									        infcPkgYe169010AVo.setBrtrPsrn(yeta3000Dto.getBrtrPsrn());    /** column 종근무지_퇴직연금근로자퇴직급여보장법공제 : brtrPsrn */
// 									        infcPkgYe169010AVo.setBrtrHnsv(yeta3000Dto.getBrtrHnsv());    /** column 종근무지_퇴직연금연금계좌저축공제 : brtrHnsv */
 									        infcPkgYe169010AVo.setYetaStdC128(exJRTR_HICT);    /** column C128_세액공제_연금계좌_과학기술인공제세액공제금액 : yetaC128 */
 									        infcPkgYe169010AVo.setYetaStdC130(exJRTR_PSRN);    /** column C130_세액공제_연금계좌_퇴직급여세액공제금액 : yetaC130 */
 									        infcPkgYe169010AVo.setYetaStdC132(exJRTR_HNSV);    /** column C132_세액공제_연금계좌_연금저축세액공제금액 : yetaC132 */
// 									          infcPkgYe169010AVo.setJrtrHict(exJRTR_HICT);    /** column 주근무지_퇴직연금과학기술인공제 : jrtrHict */
// 									          infcPkgYe169010AVo.setJrtrPsrn(exJRTR_PSRN);    /** column 주근무지_퇴직연금근로자퇴직급여보장법공제 : jrtrPsrn */
// 									          infcPkgYe169010AVo.setJrtrHnsv(exJRTR_HNSV);    /** column 주근무지_퇴직연금연금계좌저축공제 : jrtrHnsv */
// 									        infcPkgYe169010AVo.setRrptYnam(yeta3000Dto.getRrptYnam());    /** column 연금보험료공제계 : rrptYnam */
// 									        infcPkgYe169010AVo.setSpciBhth(yeta3000Dto.getSpciBhth());    /** column 특별공제_종건강보험료 : spciBhth */
// 									        infcPkgYe169010AVo.setSpciJhth(yeta3000Dto.getSpciJhth());    /** column 특별공제_주건강보험료 : spciJhth */
// 									        infcPkgYe169010AVo.setSpciBepf(yeta3000Dto.getSpciBepf());    /** column 특별공제_종고용보험료 : spciBepf */
// 									        infcPkgYe169010AVo.setSpciJepf(yeta3000Dto.getSpciJepf());    /** column 특별공제_주고용보험료 : spciJepf */
 									        
 									        infcPkgYe169010AVo.setYetaStdC134(exSPCI_GURT);    /** column C134_세액공제_특별세액공제_보장성보럼세액공제금액 : yetaC134 */
 									        infcPkgYe169010AVo.setYetaStdC136(exSPCI_HDRC);    /** column C136_세액공제_특별세액공제_장애인전용세액공제금액 : yetaC136 */
 									        
// 									          infcPkgYe169010AVo.setSpciGurt(exSPCI_GURT);    /** column 특별공제_일반보장성보험료 : spciGurt */
// 									          infcPkgYe169010AVo.setSpciHdrc(exSPCI_HDRC);    /** column 특별공제_장애인보장성보험료 : spciHdrc */
 									      //    infcPkgYe169010AVo.setSpciRtde(exSPCI_RTDE);    /** column 특별공제_보장성보혐료세액공제금액 : spciRtde */
// 									        infcPkgYe169010AVo.setSpciHrto(yeta3000Dto.getSpciHrto());    /** column 특별공제_보험료계 : spciHrto */
// 									        infcPkgYe169010AVo.setSpciSelf(yeta3000Dto.getSpciSelf());    /** column 특별공제_의료비_본인 : spciSelf */
// 									        infcPkgYe169010AVo.setSpciHe65(yeta3000Dto.getSpciHe65());    /** column 특별공제_의료비_경로65세이상 : spciHe65 */
// 									        infcPkgYe169010AVo.setSpciHbps(yeta3000Dto.getSpciHbps());    /** column 특별공제_의료비_장애인 : spciHbps */
// 									        infcPkgYe169010AVo.setSpciDetc(yeta3000Dto.getSpciDetc());    /** column 특별공제_의료비_기타공제대상자 : spciDetc */
 									        
 									        infcPkgYe169010AVo.setYetaStdC138(exSPCI_TXCR);    /** column C138_세액공제_특별세액공제_의료비세액공제금액 : yetaC138 */
 									        
 									       //  infcPkgYe169010AVo.setSpciTxcr(exSPCI_TXCR);    /** column 특별공제_의료비세액공제액 : spciTxcr */
// 									        infcPkgYe169010AVo.setSpciMeto(yeta3000Dto.getSpciMeto());    /** column 특별공제_의료비계 : spciMeto */
// 									        infcPkgYe169010AVo.setSpedSelf(yeta3000Dto.getSpedSelf());    /** column 특별공제_교육비_본인 : spedSelf */
// 									        infcPkgYe169010AVo.setSpedGrde(yeta3000Dto.getSpedGrde());    /** column 특별공제_교육비_취학전아동 : spedGrde */
// 									        infcPkgYe169010AVo.setSpedGdto(yeta3000Dto.getSpedGdto());    /** column 특별공제_교육비_초중고 : spedGdto */
// 									        infcPkgYe169010AVo.setSpedCldv(yeta3000Dto.getSpedCldv());    /** column 특별공제_교육비_대학교 : spedCldv */
// 									        infcPkgYe169010AVo.setSpciSpec(yeta3000Dto.getSpciSpec());    /** column 특별공제_장애인특수교육비 : spciSpec */

 									        infcPkgYe169010AVo.setYetaStdC140(exSPED_TXCR);    /** column C140_세액공제_특별세액공제_교육비세액공제금액 : yetaC140 */
 									    //     infcPkgYe169010AVo.setSpedTxcr(exSPED_TXCR);    /** column 특별공제_교육비세액공제금액 : spedTxcr */
// 									        infcPkgYe169010AVo.setSpedToam(yeta3000Dto.getSpedToam());    /** column 특별공제_교육비계 : spedToam */
// 									        infcPkgYe169010AVo.setSpciRefn(yeta3000Dto.getSpciRefn());    /** column 특별공제_차입금원리금상환액_대출기관 : spciRefn */
// 									        infcPkgYe169010AVo.setSpciResf(yeta3000Dto.getSpciResf());    /** column 특별공제_차입금원리금상환액_거주자 : spciResf */
// 									        infcPkgYe169010AVo.setSpciTgrt(yeta3000Dto.getSpciTgrt());    /** column 특별공제_월세세액공제대상금액 : spciTgrt */
 									        infcPkgYe169010AVo.setYetaStdC157(exSPCI_RTAM);    /** column C157_세액공제_월세세액공제금액 : yetaC157 */
// 									         infcPkgYe169010AVo.setSpciRtam(exSPCI_RTAM);    /** column 특별공제_주택자금월세공제액 : spciRtam */
// 									        infcPkgYe169010AVo.setSpchRefn(yeta3000Dto.getSpchRefn());    /** column 특별공제_장기주택이자상환액 : spchRefn */
// 									        infcPkgYe169010AVo.setSpchRe15(yeta3000Dto.getSpchRe15());    /** column 특별공제_11장기주택저당차입금15 : spchRe15 */
// 									        infcPkgYe169010AVo.setSpchRe29(yeta3000Dto.getSpchRe29());    /** column 특별공제_11장기주택저당차입금29 : spchRe29 */
// 									        infcPkgYe169010AVo.setSpchRe30(yeta3000Dto.getSpchRe30());    /** column 특별공제_11장기주택저당차입금30 : spchRe30 */
// 									        infcPkgYe169010AVo.setSpciRefx(yeta3000Dto.getSpciRefx());    /** column 특별공제_12장기주택저당차입금_고정 : spciRefx */
// 									        infcPkgYe169010AVo.setSpciReec(yeta3000Dto.getSpciReec());    /** column 특별공제_12장기주택저당차입금_기타 : spciReec */
// 									        infcPkgYe169010AVo.setSpci15fx(yeta3000Dto.getSpci15fx());    /** column 특별공제_15장기주택저당_15고정AND비거치상환 : spci15fx */
// 									        infcPkgYe169010AVo.setSpci15fb(yeta3000Dto.getSpci15fb());    /** column 특별공제_15장기주택저당_15고정OR비거치상환 : spci15fb */
// 									        infcPkgYe169010AVo.setSpci15ec(yeta3000Dto.getSpci15ec());    /** column 특별공제_15장기주택저당_15기타대출 : spci15ec */
// 									        infcPkgYe169010AVo.setSpci10fb(yeta3000Dto.getSpci10fb());    /** column 특별공제_15장기주택저당_10고정OR비거치상환 : spci10fb */
// 									        infcPkgYe169010AVo.setSpci10ec(yeta3000Dto.getSpci10ec());    /** column 특별공제_15장기주택저당_10기타대출 : spci10ec */
// 									        infcPkgYe169010AVo.setSpchReto(yeta3000Dto.getSpchReto());    /** column 특별공제_주택자금공제액계 : spchReto */
 									        
 									        infcPkgYe169010AVo.setYetaStdC142(exTAXD_PLTC);    /** column C142_세액공제_특별세액공제_기부금정치자금10만이하세액공제금액 : yetaC142 */
 									        infcPkgYe169010AVo.setYetaStdC144(exSPCI_PLTC);    /** column C144_세액공제_특별세액공제_기부금정치자금10만초과세액공제금액 : yetaC144 */
 									        
// 									         infcPkgYe169010AVo.setTaxdPltc(exTAXD_PLTC);    /** column 세액공제_기부정치자금 : taxdPltc */
// 									         infcPkgYe169010AVo.setSpciPltc(exSPCI_PLTC);    /** column 특별공제_기부금_정치 : spciPltc */
 									        
 									        infcPkgYe169010AVo.setYetaStdC146(exSPCI_FBAM);    /** column C146_세액공제_특별세액공제_법정기부금세액공제금액 : yetaC146 */
 									        infcPkgYe169010AVo.setYetaStdC148(exSPCI_RFAM);    /** column C148_세액공제_특별세액공제_우리사주조합기부금세액공제금액 : yetaC148 */
 									        infcPkgYe169010AVo.setYetaStdC150(exSPCI_NAMT);    /** column C150_세액공제_특별세액공제_지정기부금_종교단체외세액공제금액 : yetaC150 */
 									        infcPkgYe169010AVo.setYetaStdC150b(exSPCI_YAMT);    /** column C150B_세액공제_특별세액공제_지정기부금_종교단체세액공제금액 : yetaC150b */
 									        
 									       //  infcPkgYe169010AVo.setSpciFbam(exSPCI_FBAM);    /** column 특별공제_기부금_법정 : spciFbam */
// 									        infcPkgYe169010AVo.setSpciExam(yeta3000Dto.getSpciExam());    /** column 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
// 									        infcPkgYe169010AVo.setSpciUnon(yeta3000Dto.getSpciUnon());    /** column 특별공제_기부금_공익법인신탁특례 : spciUnon */
// 									         infcPkgYe169010AVo.setSpciRfam(exSPCI_RFAM);    /** column 특별공제_기부금_우리사주조합2015이후 : spciRfam */
// 									         infcPkgYe169010AVo.setSpciYamt(exSPCI_YAMT);    /** column 특별공제_기부금_종교단체 : spciYamt */
// 									         infcPkgYe169010AVo.setSpciNamt(exSPCI_NAMT);    /** column 특별공제_기부금_종교단체외 : spciNamt */
// 									        infcPkgYe169010AVo.setSpciDgcr(yeta3000Dto.getSpciDgcr());    /** column 특별공제_지정기부금세액공제금액 : spciDgcr */
// 									        infcPkgYe169010AVo.setSpciSsum(yeta3000Dto.getSpciSsum());    /** column 특별공제_기부금공제액계 : spciSsum */
 									        infcPkgYe169010AVo.setYetaStdC152(exSPCI_DDCT);    /** column C152_세액공제_표준세액공제금액 : yetaC152 */
 									        
// 									         infcPkgYe169010AVo.setSpciDdct(exSPCI_DDCT);    /** column 특별공제_표준공제 : spciDdct */
  
 									        
 									        infcPkgYe169010AVo.setYetaStdC114(exTAXD_ICAX);    /** column C114_세액감면_소득세법감면금액 : yetaC114 */
 									        infcPkgYe169010AVo.setYetaStdC115(exTAXD_SPCT);    /** column C115_세액감면_조특법_조세조약제외_감면금액 : yetaC115 */
 									        infcPkgYe169010AVo.setYetaStdC116(exTXLG_CL30);    /** column C116_세액감면_조특범30조_감면금액 : yetaC116 */
 									        infcPkgYe169010AVo.setYetaStdC117(exTXLG_HXTT);    /** column C117_세액감면_조세조약감면금액 : yetaC117 */
 									        infcPkgYe169010AVo.setYetaStdC119(exTAXD_TSUM);    /** column C119_세액감면합계금액 : yetaC119 */
// 									         infcPkgYe169010AVo.setTaxdIcax(exTAXD_ICAX);    /** column 세액감면_소득세법 : taxdIcax */
// 									         infcPkgYe169010AVo.setTaxdSpct(exTAXD_SPCT);    /** column 세액감면_조세특례법 : taxdSpct */
// 									         infcPkgYe169010AVo.setTxlgCl30(exTXLG_CL30);    /** column 세액감면_조세특례법제30조 : txlgCl30 */
// 									         infcPkgYe169010AVo.setTxlgHxtt(exTXLG_HXTT);    /** column 세액감면_조세조약 : txlgHxtt */ 
// 									         infcPkgYe169010AVo.setTaxdTsum(exTAXD_TSUM);    /** column 세액감면_감면세액계 : taxdTsum */
 									         
 									        infcPkgYe169010AVo.setYetaStdC120(exTAXD_WKEN);    /** column C120_세액공제_근로소득세액공제금액 : yetaC120 */
 									         //infcPkgYe169010AVo.setTaxdWken(exTAXD_WKEN);    /** column 세액공제_근로소득세액공제 : taxdWken */
 									         
 									         
 									        infcPkgYe169010AVo.setYetaStdC153(exTAXD_UNIN);    /** column C153_세액공제_납세조합공제금액 : yetaC153 */
 									        infcPkgYe169010AVo.setYetaStdC154(exTAXD_LOAN);    /** column C154_세액공제_주택차입금금액 : yetaC154 */
 									        infcPkgYe169010AVo.setYetaStdC155(exTAXD_PAID);    /** column C155_세액공제_외국납부금액 : yetaC155 */ 
 									        
// 									         infcPkgYe169010AVo.setTaxdUnin(exTAXD_UNIN);    /** column 세액공제_납세조합공제 : taxdUnin */
// 									         infcPkgYe169010AVo.setTaxdLoan(exTAXD_LOAN);    /** column 세액공제_주택차입금 : taxdLoan */
// 									         infcPkgYe169010AVo.setTaxdPaid(exTAXD_PAID);    /** column 세액공제_외국납부 : taxdPaid */
// 									        infcPkgYe169010AVo.setTaxdRedu(yeta3000Dto.getTaxdRedu());    /** column 세액공제_외국인감면세액 : taxdRedu */
 									        
 									       //  infcPkgYe169010AVo.setAddrMccr(exADDR_MCCR);    /** column 세액공제_자녀세액공제금액 : addrMccr */
 									        infcPkgYe169010AVo.setYetaStdC151(exSPCI_DCTO);    /** column C151_세액공제_특별세액공제합계금액 : yetaC151 */
 									        infcPkgYe169010AVo.setYetaStdC158(exTAXD_CSUM);    /** column C158_세액공제합계금액 : yetaC158 */
 									     //    infcPkgYe169010AVo.setSpciDcto(exSPCI_DCTO);    /** column 특별세액공제계 : spciDcto */
 									      //   infcPkgYe169010AVo.setTaxdCsum(exTAXD_CSUM);    /** column 세액공제_공제계 : taxdCsum */
// 									        infcPkgYe169010AVo.setDcsnIncm(yeta3000Dto.getDcsnIncm());    /** column 결정세액_소득세 : dcsnIncm */
// 									        infcPkgYe169010AVo.setDcsnInhb(yeta3000Dto.getDcsnInhb());    /** column 결정세액_주민세_지방소득세 : dcsnInhb */
// 									        infcPkgYe169010AVo.setDcsnFafv(yeta3000Dto.getDcsnFafv());    /** column 결정세액_농특세 : dcsnFafv */
// 									        infcPkgYe169010AVo.setAlryPinx(yeta3000Dto.getAlryPinx());    /** column 기납부세액_소득세 : alryPinx */
// 									        infcPkgYe169010AVo.setAlryPhbx(yeta3000Dto.getAlryPhbx());    /** column 기납부세액_주민세_지방소득세 : alryPhbx */
// 									        infcPkgYe169010AVo.setAlryYvtx(yeta3000Dto.getAlryYvtx());    /** column 기납부세액_농특세 : alryYvtx */
// 									        infcPkgYe169010AVo.setDcsnTots(yeta3000Dto.getDcsnTots());    /** column 이전근무지_총급여 : dcsnTots */
// 									        infcPkgYe169010AVo.setDcsnItax(yeta3000Dto.getDcsnItax());    /** column 이전근무지_소득세 : dcsnItax */
// 									        infcPkgYe169010AVo.setDcsnBtax(yeta3000Dto.getDcsnBtax());    /** column 이전근무지_주민세_지방소득세 : dcsnBtax */
// 									        infcPkgYe169010AVo.setFafvTaxi(yeta3000Dto.getFafvTaxi());    /** column 이전근무지_농특세 : fafvTaxi */
// 									        infcPkgYe169010AVo.setSubtEtax(yeta3000Dto.getSubtEtax());    /** column 차감징수_소득세 : subtEtax */
// 									        infcPkgYe169010AVo.setSubtInhb(yeta3000Dto.getSubtInhb());    /** column 차감징수_주민세_지방소득세 : subtInhb */
// 									        infcPkgYe169010AVo.setSubtFafv(yeta3000Dto.getSubtFafv());    /** column 차감징수_농특세 : subtFafv */
// 									        infcPkgYe169010AVo.setSubtAmsu(yeta3000Dto.getSubtAmsu());    /** column 차감징수_세액계 : subtAmsu */
// 									        infcPkgYe169010AVo.setJrtrHnto(yeta3000Dto.getJrtrHnto());    /** column 연금계좌세액공제계 : jrtrHnto */
// 									        infcPkgYe169010AVo.setSpciOnon(yeta3000Dto.getSpciOnon());    /** column 이월특례기부금_공익신탁금액 : spciOnon */
// 									        infcPkgYe169010AVo.setSpciObam(yeta3000Dto.getSpciObam());    /** column 이월법정기부금액 : spciObam */
// 									        infcPkgYe169010AVo.setSpciOyam(yeta3000Dto.getSpciOyam());    /** column 이월종교단체기부금 : spciOyam */
// 									        infcPkgYe169010AVo.setSpciOnam(yeta3000Dto.getSpciOnam());    /** column 이월종교단체외기부금 : spciOnam */
// 									        infcPkgYe169010AVo.setKybdr(yeta3000Dto.getKybdr());    /** column 입력자 : kybdr */
// 									        infcPkgYe169010AVo.setInptDt(yeta3000Dto.getInptDt());    /** column 입력일자 : inptDt */
// 									        infcPkgYe169010AVo.setInptAddr(yeta3000Dto.getInptAddr());    /** column 입력주소 : inptAddr */
// 									        infcPkgYe169010AVo.setIsmt(yeta3000Dto.getIsmt());    /** column 수정자 : ismt */
// 									        infcPkgYe169010AVo.setRevnDt(yeta3000Dto.getRevnDt());    /** column 수정일자 : revnDt */
// 									        infcPkgYe169010AVo.setRevnAddr(yeta3000Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
// 									        infcPkgYe169010AVo.setTempPrddTaxn(yeta3000Dto.getTempPrddTaxn());    /** column null : tempPrddTaxn */
 									        
 									         statCnt = 0;
 										  	 statCnt =  infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_3008_Update(infcPkgYe169010AVo); 

 											}

 									      /**#######################  특별공제)특별 세액공제계 -표준세액 공제 ############################################*/
 									       
 									           statCnt = 0;
 									  		   statCnt =  infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_3009_Update(infcPkgYe169010AVo); 
 									  			if (statCnt >= 0) {
 									  		   /**#######################  세액감면 세액공제- ############################################*/
 									  	      
 									  		
 									  			statCnt = 0;
 									  			statCnt = infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_3010_Update(infcPkgYe169010AVo); 
 									  			if (statCnt >= 0) { 
 									  	    
 									  	    /**#######################  농어촌특별세 계산 ############################################*/ 
 									  		
 									  			statCnt = 0;
 									  			statCnt =  infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_3011_Update(infcPkgYe169010AVo); 
 									  			if (statCnt >= 0) { 
 									  	    
 									  	      /**#######################  결정세액 ############################################*/ 
 									  			
 									  				statCnt = 0;
 									  				statCnt = infcPkgYeta2300.fnYeta2300_YE169010a_Tax_2017_3012_Update(infcPkgYe169010AVo); 

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
 	 
         return bmResult;
 		 
   }
    
    private  List<ShowMessageBM> YetaTaxBaseUpdate(HttpServletRequest request,InfcPkgYe161010VO  infcPkgYe161010Vo) throws Exception {
  	  
    	
        PagingLoadResult<ShowMessageBM> retval = null; 
   	   List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
   	   MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
   	  
   	   infcPkgYeta2300 = (Yeta2300PayrService)BeanFinder.getBean("Yeta2300PayrService"); 
   	   
 	  int statCnt = 0;
 	  String dataCheck = "";
 	 
 	 
       BigDecimal exPRDD_TAXN   = BigDecimal.ZERO;
       BigDecimal exTAXD_ICAX   = BigDecimal.ZERO;
       BigDecimal exTAXD_SPCT   = BigDecimal.ZERO;
       BigDecimal exTXLG_CL30   = BigDecimal.ZERO;
       BigDecimal exTXLG_HXTT   = BigDecimal.ZERO;
       BigDecimal exTAXD_TSUM   = BigDecimal.ZERO;
       BigDecimal exTAXD_WKEN   = BigDecimal.ZERO;
       BigDecimal exADDR_MCCR   = BigDecimal.ZERO;
       BigDecimal exJRTR_HICT   = BigDecimal.ZERO;
       BigDecimal exJRTR_PSRN   = BigDecimal.ZERO;
       BigDecimal exJRTR_HNSV    = BigDecimal.ZERO;
       BigDecimal exSPCI_RTDE   = BigDecimal.ZERO;
       BigDecimal exSPCI_TXCR   = BigDecimal.ZERO;
       BigDecimal exSPED_TXCR   = BigDecimal.ZERO;
       BigDecimal exTAXD_PLTC   = BigDecimal.ZERO;
       BigDecimal exSPCI_PLTC   = BigDecimal.ZERO;
       BigDecimal exSPCI_FBAM   = BigDecimal.ZERO;
       BigDecimal exSPCI_RFAM  = BigDecimal.ZERO;
       BigDecimal exSPCI_NAMT   = BigDecimal.ZERO;
       BigDecimal exSPCI_DCTO   = BigDecimal.ZERO;
       BigDecimal exSPCI_DDCT   = BigDecimal.ZERO;
       BigDecimal exTAXD_UNIN   = BigDecimal.ZERO;
       BigDecimal exTAXD_LOAN   = BigDecimal.ZERO;
       BigDecimal exTAXD_PAID   = BigDecimal.ZERO;
       BigDecimal exSPCI_RTAM   = BigDecimal.ZERO;                  
       BigDecimal exTAXD_CSUM   = BigDecimal.ZERO;
       BigDecimal exTpPRDD_TAXN   = BigDecimal.ZERO;
       BigDecimal exSPCI_YAMT   = BigDecimal.ZERO;
       BigDecimal exADDR_CHLD   = BigDecimal.ZERO; 
       BigDecimal exADDR_BRTH   = BigDecimal.ZERO;
       BigDecimal exSPCI_GURT   = BigDecimal.ZERO;
       BigDecimal exSPCI_HDRC   = BigDecimal.ZERO;
 	  
       InfcPkgYe160401VO    infcPkgYe160401Vo	 = new InfcPkgYe160401VO();	//현근무지급여지급명세
 		InfcPkgYe160402VO    infcPkgYe160402Vo	 = new InfcPkgYe160402VO();	//현근무지비과세_감면소득_과세
 		InfcPkgYe160403VO    infcPkgYe160403Vo	 = new InfcPkgYe160403VO();	//현근무지비과세_감면소득_비과세
 		
 		InfcPkgYe160404VO    infcPkgYe160404Vo	 = new InfcPkgYe160404VO();	//D_종전근무처
 		InfcPkgYe160405VO    infcPkgYe160405Vo	 = new InfcPkgYe160405VO();	//D_종전근무처비과세_감면소득_비과세
 		InfcPkgYe160406VO    infcPkgYe160406Vo	 = new InfcPkgYe160406VO();	//종전근무지연금보험료_공적연금
 		InfcPkgYe160510VO    infcPkgYe160510Vo	 = new InfcPkgYe160510VO();	//근무지별비과세_감면소득
 		
 		InfcPkgYe161005VO    infcPkgYe161005Vo	 = new InfcPkgYe161005VO();	//A_원천세신고기본
 		
 		//InfcPkgYe161010VO    infcPkgYe161010Vo	 = new InfcPkgYe161010VO();	// 연말정산대상자기본
 		InfcPkgYe161020VO    infcPkgYe161020Vo	 = new InfcPkgYe161020VO();	//A_인적소득공제기본
 		InfcPkgYe161030VO    infcPkgYe161030Vo	 = new InfcPkgYe161030VO();	//E_인적공제명세
 		InfcPkgYe161040VO    infcPkgYe161040Vo	 = new InfcPkgYe161040VO();	//E_소득세액공제명세
 		InfcPkgYe161050VO    infcPkgYe161050Vo	 = new InfcPkgYe161050VO();	//C_연금보험료공제
 		InfcPkgYe161055VO    infcPkgYe161055Vo	 = new InfcPkgYe161055VO();	//C_연금보험료_공적연금상세
 		InfcPkgYe161060VO    infcPkgYe161060Vo	 = new InfcPkgYe161060VO();	//C_특별소득공제
 		InfcPkgYe161070VO    infcPkgYe161070Vo	 = new InfcPkgYe161070VO();	//C_그밖의소득공제
 		InfcPkgYe161080VO    infcPkgYe161080Vo	 = new InfcPkgYe161080VO();	//C_세액감면및공제
 		InfcPkgYe161090VO    infcPkgYe161090Vo	 = new InfcPkgYe161090VO();	//C_교육비내역
 		InfcPkgYe162010VO    infcPkgYe162010Vo	 = new InfcPkgYe162010VO();	//F_연금저축계좌
 		InfcPkgYe162020VO    infcPkgYe162020Vo	 = new InfcPkgYe162020VO();	//F_퇴직연금계좌명세
 		InfcPkgYe162030VO    infcPkgYe162030Vo	 = new InfcPkgYe162030VO();	//F_주택마련저축
 		InfcPkgYe162040VO    infcPkgYe162040Vo	 = new InfcPkgYe162040VO();	//F_장기집합투자증권저축_B1013
 		InfcPkgYe162510VO    infcPkgYe162510Vo	 = new InfcPkgYe162510VO();	//G_월세액소득공제명세
 		InfcPkgYe162520VO    infcPkgYe162520Vo	 = new InfcPkgYe162520VO();	//G_거주자간_금전소비대차
 		InfcPkgYe162530VO    infcPkgYe162530Vo	 = new InfcPkgYe162530VO();	//G_임대차계약
 		InfcPkgYe164010VO    infcPkgYe164010Vo	 = new InfcPkgYe164010VO();	//A_의료비지급명세
 		InfcPkgYe165010VO    infcPkgYe165010Vo	 = new InfcPkgYe165010VO();	//I_해당연도기부금명세
 		InfcPkgYe165020VO    infcPkgYe165020Vo	 = new InfcPkgYe165020VO();	//I_기부자관계코드별기부금합계
 		InfcPkgYe165030VO    infcPkgYe165030Vo	 = new InfcPkgYe165030VO();	//H_기부금조정명세
 		InfcPkgYe165030TempVO infcPkgYe165030TempVo = new InfcPkgYe165030TempVO();  	    //H_기부금조정명세_TEMP	 
 		InfcPkgYe166010VO    infcPkgYe166010Vo	 = new InfcPkgYe166010VO();	//신용카드등소득공제명세
 		InfcPkgYe166020VO    infcPkgYe166020Vo	 = new InfcPkgYe166020VO();	//신용카드등소득공제상세
 			 								//
 		InfcPkgYe169010VO    infcPkgYe169010Vo	 = new InfcPkgYe169010VO();	//C_주현근무처
 		InfcPkgYe169010aVO   infcPkgYe169010AVo = new InfcPkgYe169010aVO();	//C_주현근무처_표준공제 
 	
 	  	 
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
 	BeanUtils.copyProperties(infcPkgYe162010Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe162020Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe162030Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe162040Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe162510Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe162520Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe162530Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe164010Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe165010Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe165020Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe165030Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe165030TempVo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe166010Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe166020Vo, infcPkgYe161010Vo);
 	BeanUtils.copyProperties(infcPkgYe169010Vo, infcPkgYe161010Vo); 
      
       /**#######################  특별공제 종합한도초과액 - 기타공제계 ############################################*/
       //   ---------------------특별공제 종합한도초과액 - 기타공제계-----------------
 		 
 			statCnt = 0;
 			statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_3001_Update(infcPkgYe169010Vo);
 			if (statCnt >= 0) {
 			/**
 			 * ####################### 종합소득과세표준 기타공제계 ############################################			 */
 			
 				statCnt = 0;
 				statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_3002_Update(infcPkgYe169010Vo);
 				if (statCnt >= 0) {
 				
 					/** ####################### 산출세액- 기타공제계-  * ############################################  */
 			
 					statCnt = 0;
 					statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_3003_Update(infcPkgYe169010Vo);
 					if (statCnt >= 0) {
 					/**
 					 * ####################### 산출세액-세액감면  ############################################ */
 				
 						statCnt = 0;
 						statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_3004_Update(infcPkgYe169010Vo);
 						if (statCnt >= 0) {
 						/**
 						 * ####################### 세액공제 -근로소득공제 감면세액계  ############################################
 						 */
 					
 							statCnt = 0;
 							statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_3005_Update(infcPkgYe169010Vo);

 							if (statCnt >= 0) {
 							      /**#######################  세액공제 주택차입금 ----- 외국납부    ############################################*/
 							
 								statCnt = 0;
 								statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_3006_Update(infcPkgYe169010Vo);
 								if (statCnt >= 0) {
 									
 							          /**#######################  교육비합계 사용안함 나중에 확인     ############################################*/
 						 
// 									statCnt = 0;
// 									statCnt =  infcPkgYeta2300.fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(infcPkgYe161010Vo); 
// 									
// 									if (statCnt >= 0) {
 								      /**#######################      ############################################*/
 									if (statCnt >= 0) {
 								 //YETA_C152
 										if ("TRUE".equals(infcPkgYe161010Vo.getSpciDdctCheck())) {
 											infcPkgYe169010Vo.setYetaC152(new BigDecimal("130000"));
 											infcPkgYe169010Vo.setC152StdTxDdcYn("Y");
 											
 										} else {
 											infcPkgYe169010Vo.setYetaC152(BigDecimal.ZERO);
 											infcPkgYe169010Vo.setC152StdTxDdcYn("N");
 										}
 									statCnt = 0;
 									statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_3007_Update(infcPkgYe169010Vo); 

 									if (statCnt >= 0) {	 

 										/******************************************************************************************
 										 * 산출세액에 따른 세액공제 0처리 및 단계별 빼기 작업을 위한 구현 부
 										 * 
 										 *******************************************************************************************/
 									
 										   /**#######################      ############################################*/
 									     // InfcPkgYe169010VO infcPkgYe169010Vo = new InfcPkgYe169010VO();  //연말정산결과  
 									      InfcPkgYe169010VO tpInfcPkgYe169010Vo = new InfcPkgYe169010VO();  //연말정산결과  
 									      
 									      
 									      infcPkgYe169010Vo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
 									      infcPkgYe169010Vo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
 									      infcPkgYe169010Vo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
 									      infcPkgYe169010Vo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
 									      
 									      tpInfcPkgYe169010Vo = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_2001_Select(infcPkgYe169010Vo); 
 									  
 									       
 									      if (MSFSharedUtils.paramNotNull(tpInfcPkgYe169010Vo) && MSFSharedUtils.paramNotNull(tpInfcPkgYe169010Vo.getSystemkey())) {
 									      
 									    	   
 									          exTpPRDD_TAXN  = BigDecimal.ZERO;
 									          
 									          exPRDD_TAXN  = tpInfcPkgYe169010Vo.getYetaC113() ;    //산출세액

 									          exTpPRDD_TAXN  = exPRDD_TAXN;

 									          exTAXD_ICAX  = tpInfcPkgYe169010Vo.getYetaC114(); //oraQrySelect05.FieldByName('TAXD_ICAX').AsFloat;     //소득세법
 									          if (exTpPRDD_TAXN.compareTo(exTAXD_ICAX) > 0) {
 									             exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_ICAX); 
 									          }
 									          else
 									          {
 									             exTAXD_ICAX = BigDecimal.ZERO;
 									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									                 exTAXD_ICAX = exTpPRDD_TAXN;
 									                 exTpPRDD_TAXN = BigDecimal.ZERO;
 									             }

 									          }
 									          exTAXD_SPCT  = tpInfcPkgYe169010Vo.getYetaC115(); //oraQrySelect05.FieldByName('TAXD_SPCT').AsFloat;      //조세특례법54제회
 									           if (exTpPRDD_TAXN.compareTo(exTAXD_SPCT) > 0) {
 									             exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_SPCT);
 									           }
 									           else
 									           {
 									             exTAXD_SPCT = BigDecimal.ZERO;
 									              if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									                 exTAXD_SPCT = exTpPRDD_TAXN;
 									                 exTpPRDD_TAXN = BigDecimal.ZERO;
 									              }
 									          }
 									          exTXLG_CL30   = tpInfcPkgYe169010Vo.getYetaC116(); //oraQrySelect05.FieldByName('TXLG_CL30').AsFloat;      //조특법 제30조
 									           if (exTpPRDD_TAXN.compareTo(exTXLG_CL30) > 0)   {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTXLG_CL30);
 									           }
 									           else
 									           {
 									              exTXLG_CL30 = BigDecimal.ZERO;
 									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									                 exTXLG_CL30 = exTpPRDD_TAXN;
 									                 exTpPRDD_TAXN = BigDecimal.ZERO;
 									             }
 									           }
 									           
 									          exTXLG_HXTT  = tpInfcPkgYe169010Vo.getYetaC117(); //oraQrySelect05.FieldByName('TXLG_HXTT').AsFloat;      //조세조약
 									        if (exTpPRDD_TAXN.compareTo(exTXLG_HXTT) > 0)  {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTXLG_HXTT);
 									        }
 									        else
 									        {
 									           exTXLG_HXTT = BigDecimal.ZERO;
 									              if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									                exTXLG_HXTT   = exTpPRDD_TAXN;
 									                exTpPRDD_TAXN = BigDecimal.ZERO;
 									              }
 									        }
 									       //   exTAXD_TSUM  := oraQrySelect05.FieldByName('TAXD_TSUM').AsFloat;      //세액감면계
 									          exTAXD_WKEN  = tpInfcPkgYe169010Vo.getYetaC120();   // oraQrySelect05.FieldByName('TAXD_WKEN').AsFloat;       //근로소득세액공제
 									          if (exTpPRDD_TAXN.compareTo(exTAXD_WKEN) > 0)  {   
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_WKEN);
 									          }
 									          else
 									          {
 									            exTAXD_WKEN = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									                 exTAXD_WKEN  = exTpPRDD_TAXN;
 									                 exTpPRDD_TAXN = BigDecimal.ZERO;
 									            }
 									          }
 									          exADDR_MCCR  = tpInfcPkgYe169010Vo.getYetaC122(); //oraQrySelect05.FieldByName('ADDR_MCCR').AsFloat;       //자녀세액공제
 									        if (exTpPRDD_TAXN.compareTo(exADDR_MCCR) > 0)   {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exADDR_MCCR);
 									        }
 									        else
 									        {
 									           exADDR_MCCR = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									                exADDR_MCCR   = exTpPRDD_TAXN;
 									                exTpPRDD_TAXN = BigDecimal.ZERO;
 									            }
 									        }

 									        exADDR_CHLD  = tpInfcPkgYe169010Vo.getYetaC124() ; //oraQrySelect05.FieldByName('ADDR_CHLD').AsFloat;       //추가공제_자녀양육비
 									        if (exTpPRDD_TAXN.compareTo(exADDR_CHLD) > 0)      {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exADDR_CHLD);
 									        }
 									        else
 									        {
 									           exADDR_CHLD = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									                exADDR_CHLD   = exTpPRDD_TAXN;
 									                exTpPRDD_TAXN = BigDecimal.ZERO;
 									            }
 									        }

 									            exADDR_BRTH  = tpInfcPkgYe169010Vo.getYetaC126() ; //oraQrySelect05.FieldByName('ADDR_BRTH').AsFloat;      //추가공제_출산자녀양육비
 									        if (exTpPRDD_TAXN.compareTo(exADDR_BRTH) > 0) {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exADDR_BRTH);
 									        }
 									        else
 									        {
 									           exADDR_BRTH = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									                exADDR_BRTH   = exTpPRDD_TAXN;
 									                exTpPRDD_TAXN = BigDecimal.ZERO;
 									            }
 									        }


 									        
 									          exSPCI_GURT  = tpInfcPkgYe169010Vo.getYetaC134(); // oraQrySelect05.FieldByName('SPCI_GURT').AsFloat;        //특별공제 보장성보험료공제
 									           if (exTpPRDD_TAXN.compareTo(exSPCI_GURT ) > 0) {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_GURT);
 									           }
 									        else
 									        {
 									           exSPCI_GURT  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									               exSPCI_GURT    = exTpPRDD_TAXN;
 									               exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									        }

 									        exSPCI_HDRC  = tpInfcPkgYe169010Vo.getYetaC136(); //oraQrySelect05.FieldByName('SPCI_HDRC').AsFloat;        //특별공제 보장성보험료공제장애인
 									           if (exTpPRDD_TAXN.compareTo(exSPCI_HDRC ) > 0) {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_HDRC);
 									           }
 									        else
 									        {
 									           exSPCI_HDRC  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									               exSPCI_HDRC    = exTpPRDD_TAXN;
 									               exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									        }
 									        //보장성보험료 합계 수정 처리 루틴 추가 
 									        exSPCI_RTDE =   exSPCI_GURT.add(exSPCI_HDRC) ;

 									          exSPCI_TXCR  = tpInfcPkgYe169010Vo.getYetaC138(); //oraQrySelect05.FieldByName('SPCI_TXCR').AsFloat;          //의료비세액공제
 									        if (exTpPRDD_TAXN.compareTo(exSPCI_TXCR ) > 0) {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_TXCR);
 									          }
 									        else
 									        {
 									           exSPCI_TXCR  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
 									              exSPCI_TXCR     = exTpPRDD_TAXN;
 									              exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									        }
 									        
 									          exSPED_TXCR  = tpInfcPkgYe169010Vo.getYetaC140(); //oraQrySelect05.FieldByName('SPED_TXCR').AsFloat;         //교육비 세액공제
 									          if (exTpPRDD_TAXN.compareTo(exSPED_TXCR) > 0)  {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPED_TXCR);
 									          }
 									        else
 									        {
 									           exSPED_TXCR  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									                exSPED_TXCR   = exTpPRDD_TAXN;
 									                exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									        }
 									        
 									          exTAXD_PLTC  = tpInfcPkgYe169010Vo.getYetaC142(); //oraQrySelect05.FieldByName('TAXD_PLTC').AsFloat;         //정치기부금 10만원이하 공제
 									          if (exTpPRDD_TAXN.compareTo(exTAXD_PLTC ) > 0) {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_PLTC);
 									          }
 									        else
 									        {
 									           exTAXD_PLTC  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
 									            	exTAXD_PLTC =   fnRtnSubTaxConTrbution(  request,   infcPkgYe161010Vo,  exTpPRDD_TAXN,"20","N");
 									            	
 									            	if (exTAXD_PLTC.compareTo(BigDecimal.ZERO)  <= 0)  {
 									            		exTAXD_PLTC    = exTpPRDD_TAXN;
 										            }
  									            	
 									               exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									        }
 									        
 									          exSPCI_PLTC  = tpInfcPkgYe169010Vo.getYetaC144(); //oraQrySelect05.FieldByName('SPCI_PLTC').AsFloat;         //정치기부금 10만원 초과 공제
 									           if (exTpPRDD_TAXN.compareTo(exSPCI_PLTC ) > 0)  {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_PLTC);
 									           }
 									        else
 									        {
 									           exSPCI_PLTC  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									            	exSPCI_PLTC =   fnRtnSubTaxConTrbution(  request,   infcPkgYe161010Vo,  exTpPRDD_TAXN,"20","N");
 									            
 									            	if (exSPCI_PLTC.compareTo(BigDecimal.ZERO)  <= 0)  {
 									            		exSPCI_PLTC    = exTpPRDD_TAXN;
 										            }
 									            	 
 									            	
 									               exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									        }
 									      
 									        //  exSPCI_DCTO  := oraQrySelect05.FieldByName('SPCI_DCTO').AsFloat;          //특별세액공제계
 									          exSPCI_DDCT  = tpInfcPkgYe169010Vo.getYetaC152(); //oraQrySelect05.FieldByName('SPCI_DDCT').AsFloat;           //표준세액공제
 									         if (exTpPRDD_TAXN.compareTo(exSPCI_DDCT ) > 0)  {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_DDCT);
 									         }
 									        else
 									        {
 									           exSPCI_DDCT  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									               exSPCI_DDCT    = exTpPRDD_TAXN;
 									               exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									        }
 									          exTAXD_UNIN  = tpInfcPkgYe169010Vo.getYetaC153(); //oraQrySelect05.FieldByName('TAXD_UNIN').AsFloat;           //납세조합공제
 									           if (exTpPRDD_TAXN.compareTo(exTAXD_UNIN ) > 0) {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_UNIN);
 									           }
 									        else
 									        {
 									           exTAXD_UNIN  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									               exTAXD_UNIN    = exTpPRDD_TAXN;
 									               exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									        }
 									          exTAXD_LOAN  = tpInfcPkgYe169010Vo.getYetaC154(); //oraQrySelect05.FieldByName('TAXD_LOAN').AsFloat;            //주책차입금
 									          if (exTpPRDD_TAXN.compareTo(exTAXD_LOAN) > 0)  {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_LOAN);
 									          }
 									        else
 									        {
 									           exTAXD_LOAN = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									                exTAXD_LOAN   = exTpPRDD_TAXN;
 									                exTpPRDD_TAXN = BigDecimal.ZERO;
 									            }
 									        }
 									      
 									      
 									          exSPCI_RTAM  = tpInfcPkgYe169010Vo.getYetaC157(); //oraQrySelect05.FieldByName('SPCI_RTAM').AsFloat;            //월세액공제
 									        //  exTAXD_CSUM  := oraQrySelect05.FieldByName('TAXD_CSUM').AsFloat;
 									         if (exTpPRDD_TAXN.compareTo(exSPCI_RTAM) > 0)   {
 									           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_RTAM);
 									      }
 									        else
 									        {
 									           exSPCI_RTAM  = BigDecimal.ZERO;
 									            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									              exSPCI_RTAM    = exTpPRDD_TAXN;
 									              exTpPRDD_TAXN  = BigDecimal.ZERO;
 									            }
 									      }
 									         

 									       exSPCI_FBAM  = tpInfcPkgYe169010Vo.getYetaC146(); //oraQrySelect05.FieldByName('SPCI_FBAM').AsFloat;          //기부금_법정기부금_세액공제
 									    if (exTpPRDD_TAXN.compareTo(exSPCI_FBAM ) > 0)  {
 									        exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_FBAM);
 									    }
 									     else
 									     {
 									        exSPCI_FBAM  = BigDecimal.ZERO;
 									         if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									        	 
 									        	exSPCI_FBAM = fnRtnSubTaxConTrbution(  request,   infcPkgYe161010Vo,  exTpPRDD_TAXN,"10","N");
 									        	if (exSPCI_FBAM.compareTo(BigDecimal.ZERO)  <= 0)  {
 									        		 exSPCI_FBAM  = exTpPRDD_TAXN;
									            } 
 									        	
 									              exTpPRDD_TAXN  = BigDecimal.ZERO;
 									         }
 									     }
 									      
 									       exSPCI_RFAM  =tpInfcPkgYe169010Vo.getYetaC148(); // oraQrySelect05.FieldByName('SPCI_RFAM').AsFloat;          //우리사주조합부금_세액공제
 									      if (exTpPRDD_TAXN.compareTo(exSPCI_RFAM ) > 0)  {
 									        exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_RFAM);
 									      }
 									     else
 									     {
 									  	   exSPCI_RFAM  = BigDecimal.ZERO;
 									         if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									        	exSPCI_RFAM =   fnRtnSubTaxConTrbution(  request,   infcPkgYe161010Vo,  exTpPRDD_TAXN,"42","N");
 									        	
 									        	if (exSPCI_RFAM.compareTo(BigDecimal.ZERO)  <= 0)  {
 									        		exSPCI_RFAM     = exTpPRDD_TAXN;
									            }  
 									        	
 									           exTpPRDD_TAXN  = BigDecimal.ZERO;
 									         }
 									     }
 									      
 									       
 									       exSPCI_NAMT  =tpInfcPkgYe169010Vo.getYetaC150(); // oraQrySelect05.FieldByName('SPCI_NAMT').AsFloat;          //지정기부금_세액공제종교외
 									      if (exTpPRDD_TAXN.compareTo(exSPCI_NAMT ) > 0)  {
 									        exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_NAMT);
 									      }
 									     else
 									     {
 									        exSPCI_NAMT  = BigDecimal.ZERO;
 									         if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									        	
 									        	 exSPCI_NAMT =   fnRtnSubTaxConTrbution(  request,   infcPkgYe161010Vo,  exTpPRDD_TAXN,"40","N");
 									       	
 									        	if (exSPCI_NAMT.compareTo(BigDecimal.ZERO)  <= 0)  {
 									        		exSPCI_NAMT     = exTpPRDD_TAXN;
								                }  
 									        	
 									        	
 									           exTpPRDD_TAXN  = BigDecimal.ZERO;
 									         }
 									     }
 									      
 									        exSPCI_YAMT  = tpInfcPkgYe169010Vo.getYetaC150b(); //oraQrySelect05.FieldByName('SPCI_YAMT').AsFloat;          //지정기부금_세액공제
 									      if (exTpPRDD_TAXN.compareTo(exSPCI_YAMT ) > 0)  {
 									        exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exSPCI_YAMT);
 									      }
 									     else
 									     {
 									        exSPCI_YAMT  = BigDecimal.ZERO;
 									         if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									        	exSPCI_YAMT =   fnRtnSubTaxConTrbution(  request,   infcPkgYe161010Vo,  exTpPRDD_TAXN,"41","N");
 									        	
 									        	if (exSPCI_YAMT.compareTo(BigDecimal.ZERO)  <= 0)  {
 									        		exSPCI_YAMT    = exTpPRDD_TAXN;
								                }  
 									        	 
 									            exTpPRDD_TAXN  = BigDecimal.ZERO;
 									         }
 									     }
 									         
 									         exTAXD_PAID  = tpInfcPkgYe169010Vo.getYetaC155(); //oraQrySelect05.FieldByName('TAXD_PAID').AsFloat;            //외국납부
 									         if (exTpPRDD_TAXN.compareTo(exTAXD_PAID) > 0)  {
 									          exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exTAXD_PAID);
 									       }
 									       else
 									       {
 									          exTAXD_PAID  = BigDecimal.ZERO;
 									           if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
 									              exTAXD_PAID    = exTpPRDD_TAXN;
 									              exTpPRDD_TAXN  = BigDecimal.ZERO;
 									           }
 									     }
 									         

 									         exJRTR_HICT  = tpInfcPkgYe169010Vo.getYetaC128(); //oraQrySelect05.FieldByName('JRTR_HICT').AsFloat;        //연금계좌_과학기술인공제
 									         if (exTpPRDD_TAXN.compareTo(exJRTR_HICT ) > 0) {
 									          exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exJRTR_HICT);
 									         }
 									       else
 									       {
 									          exJRTR_HICT  = BigDecimal.ZERO;
 									           if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
 									               exJRTR_HICT   = exTpPRDD_TAXN;
 									               exTpPRDD_TAXN  = BigDecimal.ZERO;
 									           }
 									       }
 									       
 									         exJRTR_PSRN  = tpInfcPkgYe169010Vo.getYetaC130(); //oraQrySelect05.FieldByName('JRTR_PSRN').AsFloat;        //연금계좌_근로자퇴직급여보장법 세액공제
 									         if (exTpPRDD_TAXN.compareTo(exJRTR_PSRN) > 0) {
 									          exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exJRTR_PSRN);
 									         }
 									       else
 									       {
 									          exJRTR_PSRN  = BigDecimal.ZERO;
 									           if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0) {
 									             exJRTR_PSRN     = exTpPRDD_TAXN;
 									             exTpPRDD_TAXN  = BigDecimal.ZERO;
 									           }
 									       }
 									       
 									         exJRTR_HNSV  = tpInfcPkgYe169010Vo.getYetaC132(); //oraQrySelect05.FieldByName('JRTR_HNSV').AsFloat;        //연금계좌_연금저축_공제
 									         if (exTpPRDD_TAXN.compareTo(exJRTR_HNSV ) > 0) {
 									          exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exJRTR_HNSV);
 									         }
 									       else
 									       {
 									          exJRTR_HNSV  = BigDecimal.ZERO;
 									           if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 									             exJRTR_HNSV     = exTpPRDD_TAXN;
 									             exTpPRDD_TAXN  = BigDecimal.ZERO;
 									           }
 									       }
 									       
 									        
  									        if (exTAXD_PLTC.compareTo(BigDecimal.ZERO) == 0 &&
  									        		exSPCI_PLTC.compareTo(BigDecimal.ZERO) == 0 &&
  									        				exSPCI_FBAM.compareTo(BigDecimal.ZERO) == 0 &&
  									        						exSPCI_RFAM.compareTo(BigDecimal.ZERO) == 0 &&
  									        								exSPCI_NAMT.compareTo(BigDecimal.ZERO) == 0 &&
  									        										exSPCI_YAMT.compareTo(BigDecimal.ZERO) == 0 ) {
  									        	exSPCI_YAMT =  fnRtnSubTaxConTrbution(  request,   infcPkgYe161010Vo,  exTpPRDD_TAXN,"00","N");
  									        	  
  									        	// if (exSPCI_YAMT.compareTo(BigDecimal.ZERO)  < 0)  {
  									        		//exSPCI_YAMT    = exTpPRDD_TAXN;
								                // }  
  									        	exSPCI_YAMT  = BigDecimal.ZERO;
  									        } 
  									       

 									          //   {retax-57}
 												/**#######################      ############################################*/
 									        
 									        infcPkgYe169010Vo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
 									        infcPkgYe169010Vo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
 									        infcPkgYe169010Vo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
 									        infcPkgYe169010Vo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
 									     
// 									        infcPkgYe169010Vo.setBefoScnt(yeta3000Dto.getBefoScnt());    /** column 종전근무지수 : befoScnt */
// 									        infcPkgYe169010Vo.setPayrTamt(yeta3000Dto.getPayrTamt());    /** column 주근무지_급여총액 : payrTamt */
// 									        infcPkgYe169010Vo.setBonsToam(yeta3000Dto.getBonsToam());    /** column 주근무지_상여총액 : bonsToam */
// 									        infcPkgYe169010Vo.setDtmnBsam(yeta3000Dto.getDtmnBsam());    /** column 주근무지_인정상여총액 : dtmnBsam */
// 									        infcPkgYe169010Vo.setStckPrft(yeta3000Dto.getStckPrft());    /** column 주근무지_주식행사이익 : stckPrft */
// 									        infcPkgYe169010Vo.setCurrTots(yeta3000Dto.getCurrTots());    /** column 주근무지총급여액 : currTots */
// 									        infcPkgYe169010Vo.setTaxmSfam(yeta3000Dto.getTaxmSfam());    /** column 비과세_자가운전보조금액_del : taxmSfam */
// 									        infcPkgYe169010Vo.setTaxmEtam(yeta3000Dto.getTaxmEtam());    /** column 비과세_급양비금액_del : taxmEtam */
// 									        infcPkgYe169010Vo.setTaxmBoin(yeta3000Dto.getTaxmBoin());    /** column 비과세_보육수당_del : taxmBoin */
// 									        infcPkgYe169010Vo.setTxecAmnt(yeta3000Dto.getTxecAmnt());    /** column 비과세_외국인소득금액_del : txecAmnt */
// 									        infcPkgYe169010Vo.setTotlSala(yeta3000Dto.getTotlSala());    /** column 총급여_현_전 : totlSala */
// 									        infcPkgYe169010Vo.setWkerDdct(yeta3000Dto.getWkerDdct());    /** column 근로소득공제 : wkerDdct */
// 									        infcPkgYe169010Vo.setWkerAmnt(yeta3000Dto.getWkerAmnt());    /** column 근로소득금액 : wkerAmnt */
// 									        infcPkgYe169010Vo.setBaseSelf(yeta3000Dto.getBaseSelf());    /** column 기본공제_본인 : baseSelf */
// 									        infcPkgYe169010Vo.setBaseWife(yeta3000Dto.getBaseWife());    /** column 기본공제_배우자 : baseWife */
// 									        infcPkgYe169010Vo.setBaseFyam(yeta3000Dto.getBaseFyam());    /** column 기본공제_부양가족 : baseFyam */
// 									        infcPkgYe169010Vo.setAddrHdam(yeta3000Dto.getAddrHdam());    /** column 추가공제_장애인 : addrHdam */
// 									        infcPkgYe169010Vo.setAddrRpt70(yeta3000Dto.getAddrRpt70());    /** column 추가공제_경로우대70 : addrRpt70 */
// 									        infcPkgYe169010Vo.setAddrFame(yeta3000Dto.getAddrFame());    /** column 추가공제_부녀자 : addrFame */
 									      
 									        infcPkgYe169010Vo.setYetaC122(exADDR_MCCR);    /** column C122_세액공제_자녀세액공제금액 : yetaC122 */
 									        infcPkgYe169010Vo.setYetaC124(exADDR_CHLD);    /** column C124_세액공제_6세이하자녀세액공제금액 : yetaC124 */
 									        infcPkgYe169010Vo.setYetaC126(exADDR_BRTH);    /** column C126_세액공제_출산입양세액공제금액 : yetaC126 */
 									        
// 									         infcPkgYe169010Vo.setAddrChld(exADDR_CHLD);    /** column 추가공제_자녀양육비 : addrChld */
// 									         infcPkgYe169010Vo.setAddrBrth(exADDR_BRTH);    /** column 추가공제_출산자녀양육비 : addrBrth */
// 									        infcPkgYe169010Vo.setPantOnam(yeta3000Dto.getPantOnam());    /** column 추가공제_한부모공제금액 : pantOnam */
// 									        infcPkgYe169010Vo.setAddrMcam(yeta3000Dto.getAddrMcam());    /** column 추가공제_다자녀 : addrMcam */
// 									        infcPkgYe169010Vo.setBnatDdct(yeta3000Dto.getBnatDdct());    /** column 종근무지_국민연금보험료공제 : bnatDdct */
// 									        infcPkgYe169010Vo.setJnatDdct(yeta3000Dto.getJnatDdct());    /** column 주근무지_국민연금보험료공제 : jnatDdct */
// 									        infcPkgYe169010Vo.setBpssDdct(yeta3000Dto.getBpssDdct());    /** column 종근무지_별정우체국연금보험료공제 : bpssDdct */
// 									        infcPkgYe169010Vo.setBpssHsol(yeta3000Dto.getBpssHsol());    /** column 종근무지_국민연금외군인연금공제 : bpssHsol */
// 									        infcPkgYe169010Vo.setBpssHtec(yeta3000Dto.getBpssHtec());    /** column 종근무지_국민연금외교직원연금공제 : bpssHtec */
// 									        infcPkgYe169010Vo.setBpssHpul(yeta3000Dto.getBpssHpul());    /** column 종근무지_국민연금외공무원연금공제 : bpssHpul */
// 									        infcPkgYe169010Vo.setJpssDdct(yeta3000Dto.getJpssDdct());    /** column 주근무지_별정우체국연금보험료공제 : jpssDdct */
// 									        infcPkgYe169010Vo.setJpssHsol(yeta3000Dto.getJpssHsol());    /** column 주근무지_국민연금외군인연금공제 : jpssHsol */
// 									        infcPkgYe169010Vo.setJpssHtec(yeta3000Dto.getJpssHtec());    /** column 주근무지_국민연금외교직원연금공제 : jpssHtec */
// 									        infcPkgYe169010Vo.setJpssHpul(yeta3000Dto.getJpssHpul());    /** column 주근무지_공무원연금보험료공제 : jpssHpul */
// 									        infcPkgYe169010Vo.setBrtrHict(yeta3000Dto.getBrtrHict());    /** column 종근무지_퇴직연금과학기술인공제 : brtrHict */
// 									        infcPkgYe169010Vo.setBrtrPsrn(yeta3000Dto.getBrtrPsrn());    /** column 종근무지_퇴직연금근로자퇴직급여보장법공제 : brtrPsrn */
// 									        infcPkgYe169010Vo.setBrtrHnsv(yeta3000Dto.getBrtrHnsv());    /** column 종근무지_퇴직연금연금계좌저축공제 : brtrHnsv */
 									        infcPkgYe169010Vo.setYetaC128(exJRTR_HICT);    /** column C128_세액공제_연금계좌_과학기술인공제세액공제금액 : yetaC128 */
 									        infcPkgYe169010Vo.setYetaC130(exJRTR_PSRN);    /** column C130_세액공제_연금계좌_퇴직급여세액공제금액 : yetaC130 */
 									        infcPkgYe169010Vo.setYetaC132(exJRTR_HNSV);    /** column C132_세액공제_연금계좌_연금저축세액공제금액 : yetaC132 */
// 									          infcPkgYe169010Vo.setJrtrHict(exJRTR_HICT);    /** column 주근무지_퇴직연금과학기술인공제 : jrtrHict */
// 									          infcPkgYe169010Vo.setJrtrPsrn(exJRTR_PSRN);    /** column 주근무지_퇴직연금근로자퇴직급여보장법공제 : jrtrPsrn */
// 									          infcPkgYe169010Vo.setJrtrHnsv(exJRTR_HNSV);    /** column 주근무지_퇴직연금연금계좌저축공제 : jrtrHnsv */
// 									        infcPkgYe169010Vo.setRrptYnam(yeta3000Dto.getRrptYnam());    /** column 연금보험료공제계 : rrptYnam */
// 									        infcPkgYe169010Vo.setSpciBhth(yeta3000Dto.getSpciBhth());    /** column 특별공제_종건강보험료 : spciBhth */
// 									        infcPkgYe169010Vo.setSpciJhth(yeta3000Dto.getSpciJhth());    /** column 특별공제_주건강보험료 : spciJhth */
// 									        infcPkgYe169010Vo.setSpciBepf(yeta3000Dto.getSpciBepf());    /** column 특별공제_종고용보험료 : spciBepf */
// 									        infcPkgYe169010Vo.setSpciJepf(yeta3000Dto.getSpciJepf());    /** column 특별공제_주고용보험료 : spciJepf */
 									        
 									        infcPkgYe169010Vo.setYetaC134(exSPCI_GURT);    /** column C134_세액공제_특별세액공제_보장성보럼세액공제금액 : yetaC134 */
 									        infcPkgYe169010Vo.setYetaC136(exSPCI_HDRC);    /** column C136_세액공제_특별세액공제_장애인전용세액공제금액 : yetaC136 */
 									        
// 									          infcPkgYe169010Vo.setSpciGurt(exSPCI_GURT);    /** column 특별공제_일반보장성보험료 : spciGurt */
// 									          infcPkgYe169010Vo.setSpciHdrc(exSPCI_HDRC);    /** column 특별공제_장애인보장성보험료 : spciHdrc */
 									      //    infcPkgYe169010Vo.setSpciRtde(exSPCI_RTDE);    /** column 특별공제_보장성보혐료세액공제금액 : spciRtde */
// 									        infcPkgYe169010Vo.setSpciHrto(yeta3000Dto.getSpciHrto());    /** column 특별공제_보험료계 : spciHrto */
// 									        infcPkgYe169010Vo.setSpciSelf(yeta3000Dto.getSpciSelf());    /** column 특별공제_의료비_본인 : spciSelf */
// 									        infcPkgYe169010Vo.setSpciHe65(yeta3000Dto.getSpciHe65());    /** column 특별공제_의료비_경로65세이상 : spciHe65 */
// 									        infcPkgYe169010Vo.setSpciHbps(yeta3000Dto.getSpciHbps());    /** column 특별공제_의료비_장애인 : spciHbps */
// 									        infcPkgYe169010Vo.setSpciDetc(yeta3000Dto.getSpciDetc());    /** column 특별공제_의료비_기타공제대상자 : spciDetc */
 									        
 									        infcPkgYe169010Vo.setYetaC138(exSPCI_TXCR);    /** column C138_세액공제_특별세액공제_의료비세액공제금액 : yetaC138 */
 									        
 									       //  infcPkgYe169010Vo.setSpciTxcr(exSPCI_TXCR);    /** column 특별공제_의료비세액공제액 : spciTxcr */
// 									        infcPkgYe169010Vo.setSpciMeto(yeta3000Dto.getSpciMeto());    /** column 특별공제_의료비계 : spciMeto */
// 									        infcPkgYe169010Vo.setSpedSelf(yeta3000Dto.getSpedSelf());    /** column 특별공제_교육비_본인 : spedSelf */
// 									        infcPkgYe169010Vo.setSpedGrde(yeta3000Dto.getSpedGrde());    /** column 특별공제_교육비_취학전아동 : spedGrde */
// 									        infcPkgYe169010Vo.setSpedGdto(yeta3000Dto.getSpedGdto());    /** column 특별공제_교육비_초중고 : spedGdto */
// 									        infcPkgYe169010Vo.setSpedCldv(yeta3000Dto.getSpedCldv());    /** column 특별공제_교육비_대학교 : spedCldv */
// 									        infcPkgYe169010Vo.setSpciSpec(yeta3000Dto.getSpciSpec());    /** column 특별공제_장애인특수교육비 : spciSpec */

 									        infcPkgYe169010Vo.setYetaC140(exSPED_TXCR);    /** column C140_세액공제_특별세액공제_교육비세액공제금액 : yetaC140 */
 									    //     infcPkgYe169010Vo.setSpedTxcr(exSPED_TXCR);    /** column 특별공제_교육비세액공제금액 : spedTxcr */
// 									        infcPkgYe169010Vo.setSpedToam(yeta3000Dto.getSpedToam());    /** column 특별공제_교육비계 : spedToam */
// 									        infcPkgYe169010Vo.setSpciRefn(yeta3000Dto.getSpciRefn());    /** column 특별공제_차입금원리금상환액_대출기관 : spciRefn */
// 									        infcPkgYe169010Vo.setSpciResf(yeta3000Dto.getSpciResf());    /** column 특별공제_차입금원리금상환액_거주자 : spciResf */
// 									        infcPkgYe169010Vo.setSpciTgrt(yeta3000Dto.getSpciTgrt());    /** column 특별공제_월세세액공제대상금액 : spciTgrt */
 									        infcPkgYe169010Vo.setYetaC157(exSPCI_RTAM);    /** column C157_세액공제_월세세액공제금액 : yetaC157 */
// 									         infcPkgYe169010Vo.setSpciRtam(exSPCI_RTAM);    /** column 특별공제_주택자금월세공제액 : spciRtam */
// 									        infcPkgYe169010Vo.setSpchRefn(yeta3000Dto.getSpchRefn());    /** column 특별공제_장기주택이자상환액 : spchRefn */
// 									        infcPkgYe169010Vo.setSpchRe15(yeta3000Dto.getSpchRe15());    /** column 특별공제_11장기주택저당차입금15 : spchRe15 */
// 									        infcPkgYe169010Vo.setSpchRe29(yeta3000Dto.getSpchRe29());    /** column 특별공제_11장기주택저당차입금29 : spchRe29 */
// 									        infcPkgYe169010Vo.setSpchRe30(yeta3000Dto.getSpchRe30());    /** column 특별공제_11장기주택저당차입금30 : spchRe30 */
// 									        infcPkgYe169010Vo.setSpciRefx(yeta3000Dto.getSpciRefx());    /** column 특별공제_12장기주택저당차입금_고정 : spciRefx */
// 									        infcPkgYe169010Vo.setSpciReec(yeta3000Dto.getSpciReec());    /** column 특별공제_12장기주택저당차입금_기타 : spciReec */
// 									        infcPkgYe169010Vo.setSpci15fx(yeta3000Dto.getSpci15fx());    /** column 특별공제_15장기주택저당_15고정AND비거치상환 : spci15fx */
// 									        infcPkgYe169010Vo.setSpci15fb(yeta3000Dto.getSpci15fb());    /** column 특별공제_15장기주택저당_15고정OR비거치상환 : spci15fb */
// 									        infcPkgYe169010Vo.setSpci15ec(yeta3000Dto.getSpci15ec());    /** column 특별공제_15장기주택저당_15기타대출 : spci15ec */
// 									        infcPkgYe169010Vo.setSpci10fb(yeta3000Dto.getSpci10fb());    /** column 특별공제_15장기주택저당_10고정OR비거치상환 : spci10fb */
// 									        infcPkgYe169010Vo.setSpci10ec(yeta3000Dto.getSpci10ec());    /** column 특별공제_15장기주택저당_10기타대출 : spci10ec */
// 									        infcPkgYe169010Vo.setSpchReto(yeta3000Dto.getSpchReto());    /** column 특별공제_주택자금공제액계 : spchReto */
 									        
 									        infcPkgYe169010Vo.setYetaC142(exTAXD_PLTC);    /** column C142_세액공제_특별세액공제_기부금정치자금10만이하세액공제금액 : yetaC142 */
 									        infcPkgYe169010Vo.setYetaC144(exSPCI_PLTC);    /** column C144_세액공제_특별세액공제_기부금정치자금10만초과세액공제금액 : yetaC144 */
 									        
// 									         infcPkgYe169010Vo.setTaxdPltc(exTAXD_PLTC);    /** column 세액공제_기부정치자금 : taxdPltc */
// 									         infcPkgYe169010Vo.setSpciPltc(exSPCI_PLTC);    /** column 특별공제_기부금_정치 : spciPltc */
 									        
 									        infcPkgYe169010Vo.setYetaC146(exSPCI_FBAM);    /** column C146_세액공제_특별세액공제_법정기부금세액공제금액 : yetaC146 */
 									        infcPkgYe169010Vo.setYetaC148(exSPCI_RFAM);    /** column C148_세액공제_특별세액공제_우리사주조합기부금세액공제금액 : yetaC148 */
 									        infcPkgYe169010Vo.setYetaC150(exSPCI_NAMT);    /** column C150_세액공제_특별세액공제_지정기부금_종교단체외세액공제금액 : yetaC150 */
 									        infcPkgYe169010Vo.setYetaC150b(exSPCI_YAMT);    /** column C150B_세액공제_특별세액공제_지정기부금_종교단체세액공제금액 : yetaC150b */
 									      
 									       //  infcPkgYe169010Vo.setSpciFbam(exSPCI_FBAM);    /** column 특별공제_기부금_법정 : spciFbam */
// 									        infcPkgYe169010Vo.setSpciExam(yeta3000Dto.getSpciExam());    /** column 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
// 									        infcPkgYe169010Vo.setSpciUnon(yeta3000Dto.getSpciUnon());    /** column 특별공제_기부금_공익법인신탁특례 : spciUnon */
// 									         infcPkgYe169010Vo.setSpciRfam(exSPCI_RFAM);    /** column 특별공제_기부금_우리사주조합2015이후 : spciRfam */
// 									         infcPkgYe169010Vo.setSpciYamt(exSPCI_YAMT);    /** column 특별공제_기부금_종교단체 : spciYamt */
// 									         infcPkgYe169010Vo.setSpciNamt(exSPCI_NAMT);    /** column 특별공제_기부금_종교단체외 : spciNamt */
// 									        infcPkgYe169010Vo.setSpciDgcr(yeta3000Dto.getSpciDgcr());    /** column 특별공제_지정기부금세액공제금액 : spciDgcr */
// 									        infcPkgYe169010Vo.setSpciSsum(yeta3000Dto.getSpciSsum());    /** column 특별공제_기부금공제액계 : spciSsum */
 									        infcPkgYe169010Vo.setYetaC152(exSPCI_DDCT);    /** column C152_세액공제_표준세액공제금액 : yetaC152 */
 									        
// 									         infcPkgYe169010Vo.setSpciDdct(exSPCI_DDCT);    /** column 특별공제_표준공제 : spciDdct */
  
 									        
 									        infcPkgYe169010Vo.setYetaC114(exTAXD_ICAX);    /** column C114_세액감면_소득세법감면금액 : yetaC114 */
 									        infcPkgYe169010Vo.setYetaC115(exTAXD_SPCT);    /** column C115_세액감면_조특법_조세조약제외_감면금액 : yetaC115 */
 									        infcPkgYe169010Vo.setYetaC116(exTXLG_CL30);    /** column C116_세액감면_조특범30조_감면금액 : yetaC116 */
 									        infcPkgYe169010Vo.setYetaC117(exTXLG_HXTT);    /** column C117_세액감면_조세조약감면금액 : yetaC117 */
 									        infcPkgYe169010Vo.setYetaC119(exTAXD_TSUM);    /** column C119_세액감면합계금액 : yetaC119 */
// 									         infcPkgYe169010Vo.setTaxdIcax(exTAXD_ICAX);    /** column 세액감면_소득세법 : taxdIcax */
// 									         infcPkgYe169010Vo.setTaxdSpct(exTAXD_SPCT);    /** column 세액감면_조세특례법 : taxdSpct */
// 									         infcPkgYe169010Vo.setTxlgCl30(exTXLG_CL30);    /** column 세액감면_조세특례법제30조 : txlgCl30 */
// 									         infcPkgYe169010Vo.setTxlgHxtt(exTXLG_HXTT);    /** column 세액감면_조세조약 : txlgHxtt */ 
// 									         infcPkgYe169010Vo.setTaxdTsum(exTAXD_TSUM);    /** column 세액감면_감면세액계 : taxdTsum */
 									         
 									        infcPkgYe169010Vo.setYetaC120(exTAXD_WKEN);    /** column C120_세액공제_근로소득세액공제금액 : yetaC120 */
 									         //infcPkgYe169010Vo.setTaxdWken(exTAXD_WKEN);    /** column 세액공제_근로소득세액공제 : taxdWken */
 									         
 									         
 									        infcPkgYe169010Vo.setYetaC153(exTAXD_UNIN);    /** column C153_세액공제_납세조합공제금액 : yetaC153 */
 									        infcPkgYe169010Vo.setYetaC154(exTAXD_LOAN);    /** column C154_세액공제_주택차입금금액 : yetaC154 */
 									        infcPkgYe169010Vo.setYetaC155(exTAXD_PAID);    /** column C155_세액공제_외국납부금액 : yetaC155 */ 
 									        
// 									         infcPkgYe169010Vo.setTaxdUnin(exTAXD_UNIN);    /** column 세액공제_납세조합공제 : taxdUnin */
// 									         infcPkgYe169010Vo.setTaxdLoan(exTAXD_LOAN);    /** column 세액공제_주택차입금 : taxdLoan */
// 									         infcPkgYe169010Vo.setTaxdPaid(exTAXD_PAID);    /** column 세액공제_외국납부 : taxdPaid */
// 									        infcPkgYe169010Vo.setTaxdRedu(yeta3000Dto.getTaxdRedu());    /** column 세액공제_외국인감면세액 : taxdRedu */
 									        
 									       //  infcPkgYe169010Vo.setAddrMccr(exADDR_MCCR);    /** column 세액공제_자녀세액공제금액 : addrMccr */
 									        infcPkgYe169010Vo.setYetaC151(exSPCI_DCTO);    /** column C151_세액공제_특별세액공제합계금액 : yetaC151 */
 									        infcPkgYe169010Vo.setYetaC158(exTAXD_CSUM);    /** column C158_세액공제합계금액 : yetaC158 */
 									     //    infcPkgYe169010Vo.setSpciDcto(exSPCI_DCTO);    /** column 특별세액공제계 : spciDcto */
 									      //   infcPkgYe169010Vo.setTaxdCsum(exTAXD_CSUM);    /** column 세액공제_공제계 : taxdCsum */
// 									        infcPkgYe169010Vo.setDcsnIncm(yeta3000Dto.getDcsnIncm());    /** column 결정세액_소득세 : dcsnIncm */
// 									        infcPkgYe169010Vo.setDcsnInhb(yeta3000Dto.getDcsnInhb());    /** column 결정세액_주민세_지방소득세 : dcsnInhb */
// 									        infcPkgYe169010Vo.setDcsnFafv(yeta3000Dto.getDcsnFafv());    /** column 결정세액_농특세 : dcsnFafv */
// 									        infcPkgYe169010Vo.setAlryPinx(yeta3000Dto.getAlryPinx());    /** column 기납부세액_소득세 : alryPinx */
// 									        infcPkgYe169010Vo.setAlryPhbx(yeta3000Dto.getAlryPhbx());    /** column 기납부세액_주민세_지방소득세 : alryPhbx */
// 									        infcPkgYe169010Vo.setAlryYvtx(yeta3000Dto.getAlryYvtx());    /** column 기납부세액_농특세 : alryYvtx */
// 									        infcPkgYe169010Vo.setDcsnTots(yeta3000Dto.getDcsnTots());    /** column 이전근무지_총급여 : dcsnTots */
// 									        infcPkgYe169010Vo.setDcsnItax(yeta3000Dto.getDcsnItax());    /** column 이전근무지_소득세 : dcsnItax */
// 									        infcPkgYe169010Vo.setDcsnBtax(yeta3000Dto.getDcsnBtax());    /** column 이전근무지_주민세_지방소득세 : dcsnBtax */
// 									        infcPkgYe169010Vo.setFafvTaxi(yeta3000Dto.getFafvTaxi());    /** column 이전근무지_농특세 : fafvTaxi */
// 									        infcPkgYe169010Vo.setSubtEtax(yeta3000Dto.getSubtEtax());    /** column 차감징수_소득세 : subtEtax */
// 									        infcPkgYe169010Vo.setSubtInhb(yeta3000Dto.getSubtInhb());    /** column 차감징수_주민세_지방소득세 : subtInhb */
// 									        infcPkgYe169010Vo.setSubtFafv(yeta3000Dto.getSubtFafv());    /** column 차감징수_농특세 : subtFafv */
// 									        infcPkgYe169010Vo.setSubtAmsu(yeta3000Dto.getSubtAmsu());    /** column 차감징수_세액계 : subtAmsu */
// 									        infcPkgYe169010Vo.setJrtrHnto(yeta3000Dto.getJrtrHnto());    /** column 연금계좌세액공제계 : jrtrHnto */
// 									        infcPkgYe169010Vo.setSpciOnon(yeta3000Dto.getSpciOnon());    /** column 이월특례기부금_공익신탁금액 : spciOnon */
// 									        infcPkgYe169010Vo.setSpciObam(yeta3000Dto.getSpciObam());    /** column 이월법정기부금액 : spciObam */
// 									        infcPkgYe169010Vo.setSpciOyam(yeta3000Dto.getSpciOyam());    /** column 이월종교단체기부금 : spciOyam */
// 									        infcPkgYe169010Vo.setSpciOnam(yeta3000Dto.getSpciOnam());    /** column 이월종교단체외기부금 : spciOnam */
// 									        infcPkgYe169010Vo.setKybdr(yeta3000Dto.getKybdr());    /** column 입력자 : kybdr */
// 									        infcPkgYe169010Vo.setInptDt(yeta3000Dto.getInptDt());    /** column 입력일자 : inptDt */
// 									        infcPkgYe169010Vo.setInptAddr(yeta3000Dto.getInptAddr());    /** column 입력주소 : inptAddr */
// 									        infcPkgYe169010Vo.setIsmt(yeta3000Dto.getIsmt());    /** column 수정자 : ismt */
// 									        infcPkgYe169010Vo.setRevnDt(yeta3000Dto.getRevnDt());    /** column 수정일자 : revnDt */
// 									        infcPkgYe169010Vo.setRevnAddr(yeta3000Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
// 									        infcPkgYe169010Vo.setTempPrddTaxn(yeta3000Dto.getTempPrddTaxn());    /** column null : tempPrddTaxn */
 									        
 									         statCnt = 0;
 										  	 statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_3008_Update(infcPkgYe169010Vo); 

 											}

 									      /**#######################  특별공제)특별 세액공제계 -표준세액 공제 ############################################*/
 									       
 									           statCnt = 0;
 									  		   statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_3009_Update(infcPkgYe169010Vo); 
 									  			if (statCnt >= 0) {
 									  		   /**#######################  세액감면 세액공제- ############################################*/
 									  	      
 									  		
 									  			statCnt = 0;
 									  			statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_3010_Update(infcPkgYe169010Vo); 
 									  			if (statCnt >= 0) { 
 									  	    
 									  	    /**#######################  농어촌특별세 계산 ############################################*/ 
 									  		
 									  			statCnt = 0;
 									  			statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_3011_Update(infcPkgYe169010Vo); 
 									  			if (statCnt >= 0) { 
 									  	    
 									  	      /**#######################  결정세액 ############################################*/ 
 									  			
 									  				statCnt = 0;
 									  				statCnt = infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_3012_Update(infcPkgYe169010Vo); 

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
 	 
         return bmResult;
 		 
   }
     
    
   private BigDecimal fnRtnSubTaxConTrbution(HttpServletRequest request,InfcPkgYe161010VO  infcPkgYe161010Vo,BigDecimal exTpPRDD_TAXN,String exGubun,String std_ddc_tax) throws Exception {
	   /**#######################  기부금공제 3 불러와서 년도별 수정하는걸로 변경함 ############################################*/ 
			
	   PagingLoadResult<ShowMessageBM> retval = null; 
   	   List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
   	   MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
   	  
   	   infcPkgYeta2300 = (Yeta2300PayrService)BeanFinder.getBean("Yeta2300PayrService"); 
   	   
 	   int statCnt = 0;
 	   String dataCheck = "";
 	   BigDecimal rtnBgVal = BigDecimal.ZERO;
 	   
 	   InfcPkgYe169010VO    infcPkgYe169010Vo	 = new InfcPkgYe169010VO();	//C_주현근무처
	   InfcPkgYe169010aVO   infcPkgYe169010AVo = new InfcPkgYe169010aVO();	//C_주현근무처_표준공제 
	
	  	 
	 infcPkgYe161010Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
   	 infcPkgYe161010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
   	 infcPkgYe161010Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
   	 infcPkgYe161010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
       
   
   	 	BeanUtils.copyProperties(infcPkgYe169010Vo, infcPkgYe161010Vo); 
   	 	BeanUtils.copyProperties(infcPkgYe169010AVo, infcPkgYe161010Vo); 
 	   
 	   
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
	               BigDecimal bgYETA_C142=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC142"),"0"));
	               BigDecimal bgYETA_C144=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC144"),"0"));
	           	 
		               
	               bgYETA_C147=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC147"),"0"));
	               
	               
		               
			        InfcPkgYe169010VO     inputYe169010Vo = new InfcPkgYe169010VO();	//C_주현근무처 
	 			//  	InfcPkgYe161060VO    inputYe161060Vo	 = new InfcPkgYe161060VO();	//C_특별소득공제
				//	InfcPkgYe161070VO    inputYe161070Vo	 = new InfcPkgYe161070VO();	//C_그밖의소득공제
					InfcPkgYe161080VO    inputYe161080Vo	 = new InfcPkgYe161080VO();	//C_세액감면및공제
				//	BeanUtils.copyProperties(inputYe161060Vo, infcPkgYe161010Vo);
				//	BeanUtils.copyProperties(inputYe161070Vo, infcPkgYe161010Vo);
					BeanUtils.copyProperties(inputYe161080Vo, infcPkgYe161010Vo);
					BeanUtils.copyProperties(inputYe169010Vo, infcPkgYe161010Vo);  
	             
	              
	               if ("20".equals(exGubun)) {
	            	   //정치자금기부금
	            	   //누적 데이타 시작 점    
		               
	            	   if (bgYETA_C141.compareTo(BigDecimal.ZERO) > 0) {
		                 if (exTpPRDD_TAXN.compareTo(bgYETA_C142 ) > 0) {
		                	 
					           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgYETA_C142);
					     }
					     else
					     { 
					            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
					            
					            	bgYETA_C142    = exTpPRDD_TAXN;
					            	bgYETA_C141    = bgYETA_C142.divide(new BigDecimal("0.909090"), 0, 5);
					            	exTpPRDD_TAXN  = BigDecimal.ZERO;
					              
					             } else {
					            	 bgYETA_C141 = BigDecimal.ZERO;
					            	 bgYETA_C142 = BigDecimal.ZERO;
					                 exTpPRDD_TAXN  = BigDecimal.ZERO;
					             }
					     }
	            	   } 
	            	   
	            	   if (bgYETA_C143.compareTo(BigDecimal.ZERO) > 0) {
			                 if (exTpPRDD_TAXN.compareTo(bgYETA_C144 ) > 0) {
			                	 
						           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgYETA_C144);
						     }
						     else
						     { 
						            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
						             
						             bgYETA_C144    = exTpPRDD_TAXN;
	                                 
						             if (bgYETA_C143.compareTo(new BigDecimal("30000000")) <= 0 ) {
						                	
	                                	 bgYETA_C143 = bgYETA_C144.divide(new BigDecimal("0.15"),0,5);
						                	
						             } else if (bgYETA_C143.compareTo(new BigDecimal("30000000")) > 0 )  {
						                	
						            	 bgYETA_C143 = bgYETA_C144.divide(new BigDecimal("0.25"),0,5);
						             }
						            	 
						                exTpPRDD_TAXN  = BigDecimal.ZERO;
						             } else {
						            	 
						            	 bgYETA_C143 = BigDecimal.ZERO;
						            	 bgYETA_C144 = BigDecimal.ZERO;
						                 exTpPRDD_TAXN  = BigDecimal.ZERO;
						             }
						     } 
	            	    }
	            	   
		                 bgYetaSumAll = bgYETA_C141.add(bgYETA_C143); //정치자금 기부금  합산
		                 bgYetaAllSumSe = bgYETA_C142.add(bgYETA_C144); //정치자금 기부금  합산
		                 //리턴 
		                 rtnBgVal = bgYetaAllSumSe;
		                 
		                 //당해년도 법정기부금
		                 bgSPCI_FBTG17_10 = BigDecimal.ZERO;
		                 bgSPCI_FBSE17_10 = BigDecimal.ZERO;
		                 bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10); 
		                 bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE17_10);
		                 bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG17_10);
		                 bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE17_10);
		                   
		               //법정기부금 2014	
		                 bgSPCI_FBTG14_10 = BigDecimal.ZERO;
		                 bgSPCI_FBSE14_10 = BigDecimal.ZERO;
		                 bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG14_10);
		                 bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE14_10);
			             bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG14_10);
			             bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE14_10);
			           
		               
		               //법정기부금 2015
			             bgSPCI_FBTG15_10 = BigDecimal.ZERO;
			             bgSPCI_FBSE15_10 = BigDecimal.ZERO;
			             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG15_10);
			             bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE15_10);
			             bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG15_10);
			             bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE15_10);
		                
		               //법정기부금 2016
			             bgSPCI_FBTG16_10 = BigDecimal.ZERO;
			             bgSPCI_FBSE16_10 = BigDecimal.ZERO;
			             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10);
			             bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE16_10);
			             bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG16_10);
			             bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE16_10);
		            
		             
			               
		               //우리사주조합기부금
		                bgYETA_C147 = BigDecimal.ZERO;
		                bgYETA_C148 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgYETA_C147);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgYETA_C148);
			                 
		                
		               //당해연도 종교단체외 지정기부금
		                bgSPCI_NATG17_40 = BigDecimal.ZERO;
		                bgSPCI_NASE17_40 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE17_40);
		                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG17_40);
		                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE17_40);
		                 
	       
		               //종교단체외 2014
		                bgSPCI_NATG14_40 = BigDecimal.ZERO;
		                bgSPCI_NASE14_40 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG14_40);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE14_40);
		                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG14_40);
		                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE14_40);
		                 
		               
		               //종교단체외 2015
		                bgSPCI_NATG15_40 = BigDecimal.ZERO;
		                bgSPCI_NASE15_40 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG15_40);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE15_40);
		                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG15_40);
		                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE15_40);
		                 
		               
		               //종교단체외 2016
		                bgSPCI_NATG16_40 = BigDecimal.ZERO;
		                bgSPCI_NASE16_40 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE16_40); 
		                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG16_40);
		                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE16_40);
		                 
		               
		               	//당해연도 종교단체 지정기부금 
		                bgSPCI_YATG17_41 = BigDecimal.ZERO;
		                bgSPCI_YASE17_41 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE17_41);
		                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG17_41);
		                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE17_41);
		                 
			               
		               //종교단체 2014 
		                bgSPCI_YATG14_41 = BigDecimal.ZERO;
		                bgSPCI_YASE14_41 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG14_41);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE14_41);
		                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG14_41);
		                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE14_41);
		                 
		               //종교단체 2015
		                bgSPCI_YATG15_41 = BigDecimal.ZERO;
		                bgSPCI_YASE15_41 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG15_41);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG15_41);
		                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG15_41);
		                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE15_41);
		                 
		               //종교단체 2016
		                bgSPCI_YATG16_41 = BigDecimal.ZERO;
		                bgSPCI_YASE16_41 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG16_41);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE16_41);
		                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG16_41);
		                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE16_41);
		                
		               
		               
	               } else if ("10".equals(exGubun)  ) {
	            	   
	            	   //누적 데이타 시작 점   
		               bgYetaSumAll = bgYETA_C141.add(bgYETA_C143); //정치자금 기부금  합산
		               bgYetaAllSumSe = bgYETA_C142.add(bgYETA_C144); //정치자금 기부금  합산
		                
		              if ("N".equals(std_ddc_tax)) { 
		               //당해년도 법정기부금
		               if (bgSPCI_FBTG17_10.compareTo(BigDecimal.ZERO) > 0) {
			            	
		            	    bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10);
				             
			                if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
			                	
			                	bgSPCI_FBSE17_10 = bgSPCI_FBTG17_10.multiply(new BigDecimal("0.15"));
			                	
			                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
			                	
			                	bgSPCI_FBSE17_10 = bgSPCI_FBTG17_10.multiply(new BigDecimal("0.30"));
			                }
			               
			                
			                if (exTpPRDD_TAXN.compareTo(bgSPCI_FBSE17_10 ) > 0) {
			                	 
						           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_FBSE17_10);
							     }
							     else
							     { 
							            if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
							           
							            	bgSPCI_FBSE17_10    = exTpPRDD_TAXN;
							            	
						            	  if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
						            		  
						            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG17_10);
						            			bgSPCI_FBTG17_10 = bgSPCI_FBSE17_10.divide(new BigDecimal("0.15"),0,5);
							                	
							                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
							                	
							                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG17_10);
							                	bgSPCI_FBTG17_10 = bgSPCI_FBSE17_10.divide(new BigDecimal("0.30"),0,5);
							                } 
							                exTpPRDD_TAXN  = BigDecimal.ZERO;
							             } else {
							            	 
							            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG17_10);
							            	 bgSPCI_FBTG17_10 = BigDecimal.ZERO;
							            	 bgSPCI_FBSE17_10 = BigDecimal.ZERO;
							            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
							            	 
							             }
							            
							            bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10);
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
			                
			                if (exTpPRDD_TAXN.compareTo(bgSPCI_FBSE14_10 ) > 0) {
			                	 
						           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_FBSE14_10);
							     }
							     else
							     { 
							             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
							           
							            	bgSPCI_FBSE14_10    = exTpPRDD_TAXN;
							            	
						            	  if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) <= 0 ) {
						            		  
						            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG14_10);
						            			bgSPCI_FBTG14_10 = bgSPCI_FBSE14_10.divide(new BigDecimal("0.15"),0,5);
							                	
							                } else if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) > 0 )  {
							                	
							                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG14_10);
							                	bgSPCI_FBTG14_10 = bgSPCI_FBSE14_10.divide(new BigDecimal("0.25"),0,5);
							                } 
							                exTpPRDD_TAXN  = BigDecimal.ZERO;
							             } else {
							            	 
							            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG14_10);
							            	 bgSPCI_FBTG14_10 = BigDecimal.ZERO;
							            	 bgSPCI_FBSE14_10 = BigDecimal.ZERO;
							            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
							            	 
							             }
							             
							             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG14_10);
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
			                
			                if (exTpPRDD_TAXN.compareTo(bgSPCI_FBSE15_10 ) > 0) {
			                	 
						           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_FBSE15_10);
							     }
							     else
							     { 
							             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
							           
							            	 bgSPCI_FBSE15_10    = exTpPRDD_TAXN;
							            	
						            	  if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) <= 0 ) {
						            		  
						            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG15_10);
						            			bgSPCI_FBTG15_10 = bgSPCI_FBSE15_10.divide(new BigDecimal("0.15"),0,5);
							                	
							                } else if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) > 0 )  {
							                	
							                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG15_10);
							                	bgSPCI_FBTG15_10 = bgSPCI_FBSE15_10.divide(new BigDecimal("0.25"),0,5);
							                } 
							                exTpPRDD_TAXN  = BigDecimal.ZERO;
							             } else {
							            	 
							            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG15_10);
							            	 bgSPCI_FBTG15_10 = BigDecimal.ZERO;
							            	 bgSPCI_FBSE15_10 = BigDecimal.ZERO;
							            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
							            	 
							             }
							             
							             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG15_10);
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
			                
			                if (exTpPRDD_TAXN.compareTo(bgSPCI_FBSE16_10 ) > 0) {
			                	 
						           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_FBSE16_10);
							     }
							     else
							     { 
							             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
							           
							            	 bgSPCI_FBSE16_10    = exTpPRDD_TAXN;
							            	
						            	  if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
						            		  
						            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG16_10);
						            			bgSPCI_FBTG16_10 = bgSPCI_FBSE16_10.divide(new BigDecimal("0.15"),0,5);
							                	
							                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
							                	
							                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG16_10);
							                	bgSPCI_FBTG16_10 = bgSPCI_FBSE16_10.divide(new BigDecimal("0.30"),0,5);
							                } 
							                exTpPRDD_TAXN  = BigDecimal.ZERO;
							             } else {
							            	 
							            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG16_10);
							            	 bgSPCI_FBTG16_10 = BigDecimal.ZERO;
							            	 bgSPCI_FBSE16_10 = BigDecimal.ZERO;
							            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
							            	 
							             }
							             
							             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10);
							     } 
				               
				               
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE16_10);
				                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG16_10);
				                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE16_10);
				                
				                
				                rtnBgVal = bgYETA_C146;
				                
		               }
		               
		              } else {
		            	  
		            	  
		            	  //당해년도 법정기부금
			                 bgSPCI_FBTG17_10 = BigDecimal.ZERO;
			                 bgSPCI_FBSE17_10 = BigDecimal.ZERO;
			                 bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10); 
			                 bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE17_10);
			                 bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG17_10);
			                 bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE17_10);
			                   
			               //법정기부금 2014	
			                 bgSPCI_FBTG14_10 = BigDecimal.ZERO;
			                 bgSPCI_FBSE14_10 = BigDecimal.ZERO;
			                 bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG14_10);
			                 bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE14_10);
				             bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG14_10);
				             bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE14_10);
				           
			               
			               //법정기부금 2015
				             bgSPCI_FBTG15_10 = BigDecimal.ZERO;
				             bgSPCI_FBSE15_10 = BigDecimal.ZERO;
				             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG15_10);
				             bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE15_10);
				             bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG15_10);
				             bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE15_10);
			                
			               //법정기부금 2016
				             bgSPCI_FBTG16_10 = BigDecimal.ZERO;
				             bgSPCI_FBSE16_10 = BigDecimal.ZERO;
				             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10);
				             bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE16_10);
				             bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG16_10);
				             bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE16_10);
			            
			             
		              }  
		              //우리사주조합기부금
		                bgYETA_C147 = BigDecimal.ZERO;
		                bgYETA_C148 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgYETA_C147);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgYETA_C148);
			                 
		                
		               //당해연도 종교단체외 지정기부금
		                bgSPCI_NATG17_40 = BigDecimal.ZERO;
		                bgSPCI_NASE17_40 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE17_40);
		                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG17_40);
		                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE17_40);
		                 
	       
		               //종교단체외 2014
		                bgSPCI_NATG14_40 = BigDecimal.ZERO;
		                bgSPCI_NASE14_40 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG14_40);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE14_40);
		                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG14_40);
		                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE14_40);
		                 
		               
		               //종교단체외 2015
		                bgSPCI_NATG15_40 = BigDecimal.ZERO;
		                bgSPCI_NASE15_40 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG15_40);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE15_40);
		                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG15_40);
		                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE15_40);
		                 
		               
		               //종교단체외 2016
		                bgSPCI_NATG16_40 = BigDecimal.ZERO;
		                bgSPCI_NASE16_40 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE16_40); 
		                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG16_40);
		                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE16_40);
		                 
		               
		               	//당해연도 종교단체 지정기부금 
		                bgSPCI_YATG17_41 = BigDecimal.ZERO;
		                bgSPCI_YASE17_41 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE17_41);
		                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG17_41);
		                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE17_41);
		                 
			               
		               //종교단체 2014 
		                bgSPCI_YATG14_41 = BigDecimal.ZERO;
		                bgSPCI_YASE14_41 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG14_41);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE14_41);
		                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG14_41);
		                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE14_41);
		                 
		               //종교단체 2015
		                bgSPCI_YATG15_41 = BigDecimal.ZERO;
		                bgSPCI_YASE15_41 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG15_41);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG15_41);
		                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG15_41);
		                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE15_41);
		                 
		               //종교단체 2016
		                bgSPCI_YATG16_41 = BigDecimal.ZERO;
		                bgSPCI_YASE16_41 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG16_41);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE16_41);
		                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG16_41);
		                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE16_41);
		                   
		               
	               } else if ("42".equals(exGubun) ) {
	            	/*********************************************************************
	            	 * 우리사주조합기부금     
	            	 *********************************************************************/
	            	   //누적 데이타 시작 점   
		               bgYetaSumAll = bgYETA_C141.add(bgYETA_C143); //정치자금 기부금  합산
		               bgYetaAllSumSe = bgYETA_C142.add(bgYETA_C144); //정치자금 기부금  합산
		                
		               //당해년도 법정기부금
		               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10); 
		               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE17_10);
		               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG17_10);
		               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE17_10);
				      
		             
		               
							             
				      bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG14_10); 
	                  bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE14_10);
	                  bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG14_10);
	                  bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE14_10); 
		              
		                
		               //법정기부금 2015
		              
						  bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG15_10); 
				          bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE15_10);
				           bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG15_10);
				          bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE15_10); 
		              
		               //법정기부금 2016 
							             
					    bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10); 
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE16_10);
		                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG16_10);
		                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE16_10);
				        
	              
		                //우리사주조합기부금
			               if (bgYETA_C147.compareTo(BigDecimal.ZERO) > 0) {
				            	
			            	   bgYetaSumAll = bgYetaSumAll.add(bgYETA_C147);
					             
				                if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
				                	
				                	bgYETA_C148 = bgYETA_C147.multiply(new BigDecimal("0.15"));
				                	
				                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
				                	
				                	bgYETA_C148 = bgYETA_C147.multiply(new BigDecimal("0.30"));
				                }
				                
				                if (exTpPRDD_TAXN.compareTo(bgYETA_C148 ) > 0) {
				                	 
							           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgYETA_C148);
								     }
								     else
								     { 
								             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
								           
								            	 bgYETA_C148    = exTpPRDD_TAXN;
								            	
							            	  if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
							            		  
							            			bgYetaSumAll = bgYetaSumAll.subtract(bgYETA_C147);
							            			bgYETA_C147 = bgYETA_C148.divide(new BigDecimal("0.15"),0,5);
								                	
								                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
								                	
								                	bgYetaSumAll = bgYetaSumAll.subtract(bgYETA_C147);
								                	bgYETA_C147 = bgYETA_C148.divide(new BigDecimal("0.30"),0,5);
								                } 
								                exTpPRDD_TAXN  = BigDecimal.ZERO;
								             } else {
								            	 
								            	 bgYetaSumAll = bgYetaSumAll.subtract(bgYETA_C147);
								            	 bgYETA_C147 = BigDecimal.ZERO;
								            	 bgYETA_C148 = BigDecimal.ZERO;
								            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
								            	 
								             }
								             bgYetaSumAll = bgYetaSumAll.add(bgYETA_C147);
								     } 
					             
					              
					               bgYetaAllSumSe =bgYetaAllSumSe.add(bgYETA_C148);
					             
					               rtnBgVal = bgYETA_C148;     
				                
			               } 
			               
			                
			                
			               //당해연도 종교단체외 지정기부금
			                bgSPCI_NATG17_40 = BigDecimal.ZERO;
			                bgSPCI_NASE17_40 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE17_40);
			                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG17_40);
			                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE17_40);
			                 
		       
			               //종교단체외 2014
			                bgSPCI_NATG14_40 = BigDecimal.ZERO;
			                bgSPCI_NASE14_40 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG14_40);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE14_40);
			                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG14_40);
			                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE14_40);
			                 
			               
			               //종교단체외 2015
			                bgSPCI_NATG15_40 = BigDecimal.ZERO;
			                bgSPCI_NASE15_40 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG15_40);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE15_40);
			                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG15_40);
			                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE15_40);
			                 
			               
			               //종교단체외 2016
			                bgSPCI_NATG16_40 = BigDecimal.ZERO;
			                bgSPCI_NASE16_40 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE16_40); 
			                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG16_40);
			                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE16_40);
			                 
			               
			               	//당해연도 종교단체 지정기부금 
			                bgSPCI_YATG17_41 = BigDecimal.ZERO;
			                bgSPCI_YASE17_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE17_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG17_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE17_41);
			                 
				               
			               //종교단체 2014 
			                bgSPCI_YATG14_41 = BigDecimal.ZERO;
			                bgSPCI_YASE14_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG14_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE14_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG14_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE14_41);
			                 
			               //종교단체 2015
			                bgSPCI_YATG15_41 = BigDecimal.ZERO;
			                bgSPCI_YASE15_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG15_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG15_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG15_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE15_41);
			                 
			               //종교단체 2016
			                bgSPCI_YATG16_41 = BigDecimal.ZERO;
			                bgSPCI_YASE16_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG16_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE16_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG16_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE16_41);
			                   
	            	   
	               } else if ("40".equals(exGubun) ) {
	            	   /*********************************************************************
		            	 * 종교단체외 기부금 
		            	 *********************************************************************/
		            	   //누적 데이타 시작 점   
			               bgYetaSumAll = bgYETA_C141.add(bgYETA_C143); //정치자금 기부금  합산
			               bgYetaAllSumSe = bgYETA_C142.add(bgYETA_C144); //정치자금 기부금  합산
			                
			               //당해년도 법정기부금
			               
								    bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10); 
					               
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE17_10);
					                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG17_10);
					                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE17_10); 
			             
			               //법정기부금 2014			               
			              
								    bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG14_10); 
					              
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE14_10);
					                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG14_10);
					                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE14_10);
					                  
			            
			                
			               //법정기부금 2015  
							         bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG15_10);
								    
					                 bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE15_10);
					                 bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG15_10);
					                 bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE15_10); 
			              
			               //법정기부금 2016
			                         bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10); 
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE16_10);
					                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG16_10);
					                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE16_10); 
		              
			                //우리사주조합기부금
				              
								     bgYetaSumAll = bgYetaSumAll.add(bgYETA_C147); 
						             
						             bgYetaAllSumSe =bgYetaAllSumSe.add(bgYETA_C148); 
				               
						   if ("N".equals(std_ddc_tax)) {         
				               //당해연도 종교단체외 지정기부금
				               if (bgSPCI_NATG17_40.compareTo(BigDecimal.ZERO) > 0) {
					            	
				            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
						             
					                if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
					                	
					                	bgSPCI_NASE17_40 = bgSPCI_NATG17_40.multiply(new BigDecimal("0.15"));
					                	
					                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
					                	
					                	bgSPCI_NASE17_40 = bgSPCI_NATG17_40.multiply(new BigDecimal("0.30"));
					                }
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_NASE17_40 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_NASE17_40);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_NASE17_40    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG17_40);
								            			bgSPCI_NATG17_40 = bgSPCI_NASE17_40.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG17_40);
									                	bgSPCI_NATG17_40 = bgSPCI_NASE17_40.divide(new BigDecimal("0.30"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG17_40);
									            	 bgSPCI_NATG17_40 = BigDecimal.ZERO;
									            	 bgSPCI_NASE17_40 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
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
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_NASE14_40 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_NASE14_40);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_NASE14_40    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG14_40);
								            			bgSPCI_NATG14_40 = bgSPCI_NASE14_40.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG14_40);
									                	bgSPCI_NATG14_40 = bgSPCI_NASE14_40.divide(new BigDecimal("0.25"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG14_40);
									            	 bgSPCI_NATG14_40 = BigDecimal.ZERO;
									            	 bgSPCI_NASE14_40 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG14_40);
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
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_NASE15_40 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_NASE15_40);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_NASE15_40    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG15_40);
								            			bgSPCI_NATG15_40 = bgSPCI_NASE15_40.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG15_40);
									                	bgSPCI_NATG15_40 = bgSPCI_NASE15_40.divide(new BigDecimal("0.25"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG15_40);
									            	 bgSPCI_NATG15_40 = BigDecimal.ZERO;
									            	 bgSPCI_NASE15_40 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG15_40);
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
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_NASE16_40 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_NASE16_40);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_NASE16_40    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG16_40);
								            			bgSPCI_NATG16_40 = bgSPCI_NASE16_40.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG16_40);
									                	bgSPCI_NATG16_40 = bgSPCI_NASE16_40.divide(new BigDecimal("0.30"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG16_40);
									            	 bgSPCI_NATG16_40 = BigDecimal.ZERO;
									            	 bgSPCI_NASE16_40 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
									     } 
						               
						                
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE16_40); 
						                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG16_40);
						                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE16_40);
						                
						                
						                rtnBgVal = bgYETA_C150; 
						                  
				               } 
				               
						   } else {
							   
							     
				               //당해연도 종교단체외 지정기부금
				                bgSPCI_NATG17_40 = BigDecimal.ZERO;
				                bgSPCI_NASE17_40 = BigDecimal.ZERO;
				                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE17_40);
				                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG17_40);
				                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE17_40);
				                 
			       
				               //종교단체외 2014
				                bgSPCI_NATG14_40 = BigDecimal.ZERO;
				                bgSPCI_NASE14_40 = BigDecimal.ZERO;
				                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG14_40);
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE14_40);
				                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG14_40);
				                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE14_40);
				                 
				               
				               //종교단체외 2015
				                bgSPCI_NATG15_40 = BigDecimal.ZERO;
				                bgSPCI_NASE15_40 = BigDecimal.ZERO;
				                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG15_40);
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE15_40);
				                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG15_40);
				                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE15_40);
				                 
				               
				               //종교단체외 2016
				                bgSPCI_NATG16_40 = BigDecimal.ZERO;
				                bgSPCI_NASE16_40 = BigDecimal.ZERO;
				                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE16_40); 
				                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG16_40);
				                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE16_40);
				                 
						   }  
				                
				               	//당해연도 종교단체 지정기부금 
				                bgSPCI_YATG17_41 = BigDecimal.ZERO;
				                bgSPCI_YASE17_41 = BigDecimal.ZERO;
				                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41);
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE17_41);
				                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG17_41);
				                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE17_41);
				                 
					               
				               //종교단체 2014 
				                bgSPCI_YATG14_41 = BigDecimal.ZERO;
				                bgSPCI_YASE14_41 = BigDecimal.ZERO;
				                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG14_41);
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE14_41);
				                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG14_41);
				                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE14_41);
				                 
				               //종교단체 2015
				                bgSPCI_YATG15_41 = BigDecimal.ZERO;
				                bgSPCI_YASE15_41 = BigDecimal.ZERO;
				                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG15_41);
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG15_41);
				                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG15_41);
				                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE15_41);
				                 
				               //종교단체 2016
				                bgSPCI_YATG16_41 = BigDecimal.ZERO;
				                bgSPCI_YASE16_41 = BigDecimal.ZERO;
				                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG16_41);
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE16_41);
				                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG16_41);
				                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE16_41);
				                   
	               } else if ("41".equals(exGubun) ) {
	            	   /*********************************************************************
		            	 * 종교단체 기부금 
		            	 *********************************************************************/
		            	   //누적 데이타 시작 점   
			               bgYetaSumAll = bgYETA_C141.add(bgYETA_C143); //정치자금 기부금  합산
			               bgYetaAllSumSe = bgYETA_C142.add(bgYETA_C144); //정치자금 기부금  합산
			                
			               //당해년도 법정기부금
			               
								   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10);
								     
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE17_10);
					                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG17_10);
					                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE17_10);
					           
			             
			               //법정기부금 2014			               
			               
								             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG14_10);
								    
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE14_10);
					                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG14_10);
					                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE14_10);
					             
			                
			               //법정기부금 2015
			               
								     bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG15_10);
								     
					                 bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE15_10);
					                 bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG15_10);
					                 bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE15_10);
					             
				             
			               //법정기부금 2016
			                
								             
								    bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10);
								    
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE16_10);
					                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG16_10);
					                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE16_10);
					                
			              
			                //우리사주조합기부금
				               
									   bgYetaSumAll = bgYetaSumAll.add(bgYETA_C147);
									    
						               bgYetaAllSumSe =bgYetaAllSumSe.add(bgYETA_C148);
					                 
				                
				               //당해연도 종교단체외 지정기부금
				                
									             
									    bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
									     
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE17_40);
						                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG17_40);
						                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE17_40);
						              
				               
				               //종교단체외 2014
				            	               
				              
									    bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG14_40);
									     
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE14_40);
						                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG14_40);
						                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE14_40);
						             
				               
				               //종교단체외 2015
				               
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG15_40);
									    
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE15_40);
						                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG15_40);
						                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE15_40);
						            
				               //종교단체외 2016
				              
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
									     
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE16_40); 
						                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG16_40);
						                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE16_40);
						               
						     if ("N".equals(std_ddc_tax)) {                     
				               	//당해연도 종교단체 지정기부금 
				               if (bgSPCI_YATG17_41.compareTo(BigDecimal.ZERO) > 0) {
					            	
				            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41);
						             
					                if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
					                	
					                	bgSPCI_YASE17_41 = bgSPCI_YATG17_41.multiply(new BigDecimal("0.15"));
					                	
					                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
					                	
					                	bgSPCI_YASE17_41 = bgSPCI_YATG17_41.multiply(new BigDecimal("0.30"));
					                }
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_YASE17_41 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_YASE17_41);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_YASE17_41    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG17_41);
								            			bgSPCI_YATG17_41 = bgSPCI_YASE17_41.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG17_41);
									                	bgSPCI_YATG17_41 = bgSPCI_YASE17_41.divide(new BigDecimal("0.30"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG17_41);
									            	 bgSPCI_YATG17_41 = BigDecimal.ZERO;
									            	 bgSPCI_YASE17_41 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41); 
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
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_YASE14_41 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_YASE14_41);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_YASE14_41    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG14_41);
								            			bgSPCI_YATG14_41 = bgSPCI_YASE14_41.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG14_41);
									                	bgSPCI_YATG14_41 = bgSPCI_YASE14_41.divide(new BigDecimal("0.25"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YASE14_41);
									            	 bgSPCI_YATG14_41 = BigDecimal.ZERO;
									            	 bgSPCI_YASE14_41 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG14_41);
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
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_YASE15_41 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_YASE15_41);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_YASE15_41    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG15_41);
								            			bgSPCI_YATG15_41 = bgSPCI_YASE15_41.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("30000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG15_41);
									                	bgSPCI_YATG15_41 = bgSPCI_YASE15_41.divide(new BigDecimal("0.25"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG15_41);
									            	 bgSPCI_YATG15_41 = BigDecimal.ZERO;
									            	 bgSPCI_YASE15_41 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG15_41);
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
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_YASE16_41 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_YASE16_41);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_YASE16_41    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG16_41);
								            			bgSPCI_YATG16_41 = bgSPCI_YASE16_41.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG16_41);
									                	bgSPCI_YATG16_41 = bgSPCI_YASE16_41.divide(new BigDecimal("0.30"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG16_41);
									            	 bgSPCI_YATG16_41 = BigDecimal.ZERO;
									            	 bgSPCI_YASE16_41 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG16_41);
									     }
						             
						              
						               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE16_41);
						                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG16_41);
						                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE16_41);
						                
						                rtnBgVal = bgYETA_C150B; 
				               }  
				               
						     } else {
						    	 
						    	  
					               	//당해연도 종교단체 지정기부금 
					                bgSPCI_YATG17_41 = BigDecimal.ZERO;
					                bgSPCI_YASE17_41 = BigDecimal.ZERO;
					                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41);
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE17_41);
					                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG17_41);
					                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE17_41);
					                 
						               
					               //종교단체 2014 
					                bgSPCI_YATG14_41 = BigDecimal.ZERO;
					                bgSPCI_YASE14_41 = BigDecimal.ZERO;
					                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG14_41);
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE14_41);
					                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG14_41);
					                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE14_41);
					                 
					               //종교단체 2015
					                bgSPCI_YATG15_41 = BigDecimal.ZERO;
					                bgSPCI_YASE15_41 = BigDecimal.ZERO;
					                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG15_41);
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG15_41);
					                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG15_41);
					                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE15_41);
					                 
					               //종교단체 2016
					                bgSPCI_YATG16_41 = BigDecimal.ZERO;
					                bgSPCI_YASE16_41 = BigDecimal.ZERO;
					                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG16_41);
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE16_41);
					                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG16_41);
					                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE16_41);
					                 
						     }
				                
	               } else if ("00".equals(exGubun) ) {
	            	   /*********************************************************************
		            	 * 종교단체 기부금 
		            	 *********************************************************************/
		            	   //누적 데이타 시작 점   
			               bgYetaSumAll = bgYETA_C141.add(bgYETA_C143); //정치자금 기부금  합산
			               bgYetaAllSumSe = bgYETA_C142.add(bgYETA_C144); //정치자금 기부금  합산
			                
			               //당해년도 법정기부금
			               
							     bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10);
								     
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE17_10);
					                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG17_10);
					                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE17_10);
					           
			             
			               //법정기부금 2014			               
			               
								             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG14_10);
								    
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE14_10);
					                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG14_10);
					                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE14_10);
					             
			                
			               //법정기부금 2015
			               
								             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG15_10);
								     
					                 bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE15_10);
					                 bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG15_10);
					                 bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE15_10);
					             
				             
			               //법정기부금 2016
			                
								             
								             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10);
								    
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE16_10);
					                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG16_10);
					                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE16_10);
					                
			              
			                //우리사주조합기부금
				               
									             bgYetaSumAll = bgYetaSumAll.add(bgYETA_C147);
									    
						               bgYetaAllSumSe =bgYetaAllSumSe.add(bgYETA_C148);
					                 
				                
				               //당해연도 종교단체외 지정기부금
				                
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
									     
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE17_40);
						                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG17_40);
						                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE17_40);
						              
				               
				               //종교단체외 2014
				            	               
				              
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG14_40);
									     
						               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE14_40);
						                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG14_40);
						                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE14_40);
						             
				               
				               //종교단체외 2015
				               
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG15_40);
									    
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE15_40);
						                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG15_40);
						                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE15_40);
						            
				               //종교단체외 2016
				              
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
									     
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE16_40); 
						                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG16_40);
						                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE16_40);
						               
						                
				               	//당해연도 종교단체 지정기부금 
				               
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41); 
									     
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE17_41);
						                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG17_41);
						                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE17_41);
						         
				                
				               //종교단체 2014 
				                
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG14_41);
									    
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE14_41);
						                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG14_41);
						                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE14_41);
						            
				               //종교단체 2015
				               
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG15_41);
									     
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG15_41);
						                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG15_41);
						                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE15_41);
						            
				               
				               //종교단체 2016
				               
									    bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG16_41);
									     
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE16_41);
						                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG16_41);
						                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE16_41);
						                
						                rtnBgVal = bgYETA_C150B;  
				                
	               }
	               
	               
					//inputYe161080Vo.setConb10ttswLtUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conb10ttswLtUseAmt"),"0")));    /** column 기부금_정치자금기부금10이하기부금 : conb10ttswLtUseAmt */
					inputYe161080Vo.setConb10ttswLtDdcTrgtAmt(bgYETA_C141.setScale(0, BigDecimal.ROUND_DOWN));    /** column 기부금_정치자금기부금10이하공제대상금액 : conb10ttswLtDdcTrgtAmt */
					inputYe161080Vo.setConb10ttswLtDdcAmt(bgYETA_C142.setScale(0, BigDecimal.ROUND_DOWN));    /** column 기부금_정치자금기부금10이하공제세액 : conb10ttswLtDdcAmt */
					//inputYe161080Vo.setConb10excsLtUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conb10excsLtUseAmt"),"0")));    /** column 기부금_정치자금기부금10초과기부금액 : conb10excsLtUseAmt */
					inputYe161080Vo.setConb10excsLtDdcTrgtAmt(bgYETA_C143.setScale(0, BigDecimal.ROUND_DOWN));    /** column 기부금_정치자금기부금10초과공제대상금액 : conb10excsLtDdcTrgtAmt */
					inputYe161080Vo.setConb10excsLtDdcAmt(bgYETA_C144.setScale(0, BigDecimal.ROUND_DOWN));    /** column 기부금_정치자금기부금10초과공제세액 : conb10excsLtDdcAmt */
					//inputYe161080Vo.setConbLglUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbLglUseAmt"),"0")));    /** column 기부금_법정기부금납입금액 : conbLglUseAmt */
					inputYe161080Vo.setConbLglDdcTrgtAmt(bgYETA_C145.setScale(0, BigDecimal.ROUND_DOWN));    /** column 기부금_법정기부금공제대상금액 : conbLglDdcTrgtAmt */
					inputYe161080Vo.setConbLglDdcAmt(bgYETA_C146.setScale(0, BigDecimal.ROUND_DOWN));    /** column 기부금_법정기부금공제세액 : conbLglDdcAmt */
					//inputYe161080Vo.setConbEmstAsctUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbEmstAsctUseAmt"),"0")));    /** column 기부금_우리사주조합기부금납입금액 : conbEmstAsctUseAmt */
					inputYe161080Vo.setConbEmstAsctDdcTrgtAmt(bgYETA_C147.setScale(0, BigDecimal.ROUND_DOWN));    /** column 기부금_우리사주조합기부금공제대상금액 : conbEmstAsctDdcTrgtAmt */
					inputYe161080Vo.setConbEmstAsctDdcAmt(bgYETA_C148.setScale(0, BigDecimal.ROUND_DOWN));    /** column 기부금_우리사주조합기부금공제세액 : conbEmstAsctDdcAmt */
					//inputYe161080Vo.setConbReliOrgOthUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgOthUseAmt"),"0")));    /** column 기부금_지정기부금종교단체외기부금액 : conbReliOrgOthUseAmt */
					inputYe161080Vo.setConbReliOrgOthDdcTrgtAmt(bgYETA_C149.setScale(0, BigDecimal.ROUND_DOWN));    /** column 기부금_지정기부금종교단체외공제대상금액 : conbReliOrgOthDdcTrgtAmt */
					inputYe161080Vo.setConbReliOrgOthDdcAmt(bgYETA_C150.setScale(0, BigDecimal.ROUND_DOWN));    /** column 기부금_지정기부금종교단체외공제세액 : conbReliOrgOthDdcAmt */
					//inputYe161080Vo.setConbReliOrgUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbReliOrgUseAmt"),"0")));    /** column 기부금_지정기부금종교단체기부금액 : conbReliOrgUseAmt */
					inputYe161080Vo.setConbReliOrgDdcTrgtAmt(bgYETA_C150A.setScale(0, BigDecimal.ROUND_DOWN));    /** column 기부금_지정기부금종교단체공제대상금액 : conbReliOrgDdcTrgtAmt */
					inputYe161080Vo.setConbReliOrgDdcAmt(bgYETA_C150B.setScale(0, BigDecimal.ROUND_DOWN));    /** column 기부금_지정기부금종교단체공제세액 : conbReliOrgDdcAmt */
					//inputYe161080Vo.setConbUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbUseAmtSum"),"0")));    /** column 기부금납입금액합계 : conbUseAmtSum */
					inputYe161080Vo.setConbDdcTrgtAmtSum(bgYetaSumAll.setScale(0, BigDecimal.ROUND_DOWN));    /** column 기부금공제대상금액합계 : conbDdcTrgtAmtSum */ 
					inputYe161080Vo.setConbDdcAmtSum(bgYetaAllSumSe.setScale(0, BigDecimal.ROUND_DOWN));    /** column 기부금공제세액합계 : conbDdcAmtSum */
	               

					inputYe169010Vo.setYetaC141(bgYETA_C141.setScale(0, BigDecimal.ROUND_DOWN));     
					inputYe169010Vo.setYetaC142(bgYETA_C142.setScale(0, BigDecimal.ROUND_DOWN));    
					inputYe169010Vo.setYetaC143(bgYETA_C143.setScale(0, BigDecimal.ROUND_DOWN));     
					inputYe169010Vo.setYetaC144(bgYETA_C144.setScale(0, BigDecimal.ROUND_DOWN));     
					
					inputYe169010Vo.setYetaC145(bgYETA_C145.setScale(0, BigDecimal.ROUND_DOWN));    /** column C145_세액공제_특별세액공제_법정기부금공제대상금액 : yetaC145 */
					inputYe169010Vo.setYetaC146(bgYETA_C146.setScale(0, BigDecimal.ROUND_DOWN));    /** column C146_세액공제_특별세액공제_법정기부금세액공제금액 : yetaC146 */
					inputYe169010Vo.setYetaC147(bgYETA_C147.setScale(0, BigDecimal.ROUND_DOWN));    /** column C147_세액공제_특별세액공제_우리사주조합기부금공제대상금액 : yetaC147 */
					inputYe169010Vo.setYetaC148(bgYETA_C148.setScale(0, BigDecimal.ROUND_DOWN));    /** column C148_세액공제_특별세액공제_우리사주조합기부금세액공제금액 : yetaC148 */
					inputYe169010Vo.setYetaC149(bgYETA_C149.setScale(0, BigDecimal.ROUND_DOWN));    /** column C149_세액공제_특별세액공제_지정기부금_종교단체외공제대상금액 : yetaC149 */
					inputYe169010Vo.setYetaC150(bgYETA_C150.setScale(0, BigDecimal.ROUND_DOWN));    /** column C150_세액공제_특별세액공제_지정기부금_종교단체외세액공제금액 : yetaC150 */
					inputYe169010Vo.setYetaC150a(bgYETA_C150A.setScale(0, BigDecimal.ROUND_DOWN));    /** column C150A_세액공제_특별세액공제_지정기부금_종교단체공제대상금액 : yetaC150a */
					inputYe169010Vo.setYetaC150b(bgYETA_C150B.setScale(0, BigDecimal.ROUND_DOWN));    /** column C150B_세액공제_특별세액공제_지정기부금_종교단체세액공제금액 : yetaC150b */ 
	               
				 
				//	inputYe169010Vo.setSpciFb14(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciFb14"),"0")));    /** column null : spciFb14 */
				//	inputYe169010Vo.setSpciFb15(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciFb15"),"0")));    /** column null : spciFb15 */
				//	inputYe169010Vo.setSpciFb16(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciFb16"),"0")));    /** column null : spciFb16 */
				//	inputYe169010Vo.setSpciFb17(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciFb17"),"0")));    /** column null : spciFb17 */
				
					inputYe169010Vo.setSpciFbtg17(bgSPCI_FBTG17_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbtg17 */ 
					inputYe169010Vo.setSpciFbtg14(bgSPCI_FBTG14_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbtg14 */
					inputYe169010Vo.setSpciFbtg15(bgSPCI_FBTG15_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbtg15 */
					inputYe169010Vo.setSpciFbtg16(bgSPCI_FBTG16_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbtg16 */
					
					inputYe169010Vo.setSpciFbse17(bgSPCI_FBSE17_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbse17 */
					inputYe169010Vo.setSpciFbse14(bgSPCI_FBSE14_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbse14 */
					inputYe169010Vo.setSpciFbse15(bgSPCI_FBSE15_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbse15 */
					inputYe169010Vo.setSpciFbse16(bgSPCI_FBSE16_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbse16 */
					
					 
		               
					//inputYe169010Vo.setSpciNa14(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciNa14"),"0")));    /** column null : spciNa14 */
					//inputYe169010Vo.setSpciNa15(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciNa15"),"0")));    /** column null : spciNa15 */
					//inputYe169010Vo.setSpciNa16(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciNa16"),"0")));    /** column null : spciNa16 */
					//inputYe169010Vo.setSpciNa17(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciNa17"),"0")));    /** column null : spciNa17 */
					
					inputYe169010Vo.setSpciNatg17(bgSPCI_NATG17_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNatg17 */ 
					inputYe169010Vo.setSpciNatg14(bgSPCI_NATG14_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNatg14 */
					inputYe169010Vo.setSpciNatg15(bgSPCI_NATG15_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNatg15 */
					inputYe169010Vo.setSpciNatg16(bgSPCI_NATG16_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNatg16 */
					
					inputYe169010Vo.setSpciNase17(bgSPCI_NASE17_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNase17 */
					inputYe169010Vo.setSpciNase14(bgSPCI_NASE14_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNase14 */
					inputYe169010Vo.setSpciNase15(bgSPCI_NASE15_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNase15 */
					inputYe169010Vo.setSpciNase16(bgSPCI_NASE16_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNase16 */
					 
					//inputYe169010Vo.setSpciYa14(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciYa14"),"0")));    /** column null : spciYa14 */
					//inputYe169010Vo.setSpciYa15(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciYa15"),"0")));    /** column null : spciYa15 */
					//inputYe169010Vo.setSpciYa16(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciYa16"),"0")));    /** column null : spciYa16 */
					//inputYe169010Vo.setSpciYa17(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("spciYa17"),"0")));    /** column null : spciYa17 */
					
					
					inputYe169010Vo.setSpciYatg17(bgSPCI_YATG17_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYatg17 */ 
					inputYe169010Vo.setSpciYatg14(bgSPCI_YATG14_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYatg14 */
					inputYe169010Vo.setSpciYatg15(bgSPCI_YATG15_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYatg15 */
					inputYe169010Vo.setSpciYatg16(bgSPCI_YATG16_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYatg16 */
				
					inputYe169010Vo.setSpciYase17(bgSPCI_YASE17_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYase17 */
					inputYe169010Vo.setSpciYase14(bgSPCI_YASE14_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYase14 */
					inputYe169010Vo.setSpciYase15(bgSPCI_YASE15_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYase15 */
					inputYe169010Vo.setSpciYase16(bgSPCI_YASE16_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYase16 */
					   
					
					statCnt = 0;
			  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_TgIn03_Update( inputYe161080Vo) ;
			  		if (statCnt >= 0) {
			  			
			  			statCnt = 0;
				  		statCnt =  infcPkgYeta2300.fnYeta2300_YE169010_Tax_2017_TgIn04_Update( inputYe169010Vo) ;
			  		}
			  		
			  		//년도별처리로직 다시 호출  
			  		 /**#######################  기부금 정리 이월분 정리 작업 시작   ############################################*/ 	
	  				statCnt = 0;  
	  				Yeta2300Tax2017ContributionCalcPkgProc tax2017ContributionCalcPkgProc = new Yeta2300Tax2017ContributionCalcPkgProc();
	  				bmResult.addAll(tax2017ContributionCalcPkgProc.execTax_2017_Contribution_Calc(request,infcPkgYe161010Vo)); 

	            }
       }   
       
       return rtnBgVal;
       //return bmResult;
   }     
 
}