package com.app.smrmf.pkg.yeta.yeta2022.tax;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe160404_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe160405_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe160406_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe160510_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161005_2022_VO;
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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162040_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162510_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162520_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162530_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe164010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165030Temp_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe165030_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166020_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe169010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe169010a_2022_VO;
import com.app.smrmf.pkg.yeta.yeta2022.tax.service.Yeta7300PayrService;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta7300SubtTaxStdDdcPkgProc  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta7300SubtTaxStdDdcPkgProc.class);
	   
    @Resource(name = "Yeta7300PayrService")
    protected Yeta7300PayrService  infcPkgYeta7300;
    
 
    public Yeta7300SubtTaxStdDdcPkgProc() {
    	
    } 
    
    public List<ShowMessageBM> execSubtTaxStdDdcPkgProc(HttpServletRequest request,InfcPkgYe161010_2022_VO  infcPkgYe161010Vo)  throws Exception  {
  	    
	  	  return  YetaTaxCreateUpdate(request,  infcPkgYe161010Vo);
	}
     
    
   
   /**
    *  
    * <pre>
    * 1. 개요 : 기본 
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : YetaTaxCreateUpdate
    * @date : 2022. 1. 31.
    * @author : atres
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	2022. 1. 31.		atres				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param infcPkgYe161010Vo
    * @return
    * @throws Exception
    */
    private  List<ShowMessageBM> YetaTaxCreateUpdate(HttpServletRequest request,InfcPkgYe161010_2022_VO  infcPkgYe161010Vo) throws Exception {
	  
    	
      
  	   List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
  	   
       if ("TRUE".equals(infcPkgYe161010Vo.getSpciDdctCheck())) {
     	  
     	  bmResult = YetaTaxStdUpdate(request,infcPkgYe161010Vo);
       } else {
     	  
     	  bmResult = YetaTaxBaseUpdate(request,infcPkgYe161010Vo);
       }
       
  	 
	 
        return bmResult;
		 
  }
   
    private  List<ShowMessageBM> YetaTaxStdUpdate(HttpServletRequest request,InfcPkgYe161010_2022_VO  infcPkgYe161010Vo) throws Exception {
  	  
    	
       PagingLoadResult<ShowMessageBM> retval = null; 
   	   List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
   	   MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
   	  
   	   infcPkgYeta7300 = (Yeta7300PayrService)BeanFinder.getBean("Yeta7300PayrService"); 
   	   
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
       BigDecimal exJRTR_HISA    = BigDecimal.ZERO;
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
 		
 		InfcPkgYe160404_2022_VO    infcPkgYe160404Vo	 = new InfcPkgYe160404_2022_VO();	//D_종전근무처
 		InfcPkgYe160405_2022_VO    infcPkgYe160405Vo	 = new InfcPkgYe160405_2022_VO();	//D_종전근무처비과세_감면소득_비과세
 		InfcPkgYe160406_2022_VO    infcPkgYe160406Vo	 = new InfcPkgYe160406_2022_VO();	//종전근무지연금보험료_공적연금
 		InfcPkgYe160510_2022_VO    infcPkgYe160510Vo	 = new InfcPkgYe160510_2022_VO();	//근무지별비과세_감면소득
 		
 		InfcPkgYe161005_2022_VO    infcPkgYe161005Vo	 = new InfcPkgYe161005_2022_VO();	//A_원천세신고기본
 		
 		//InfcPkgYe161010VO    infcPkgYe161010Vo	 = new InfcPkgYe161010VO();	// 연말정산대상자기본
 		InfcPkgYe161020_2022_VO    infcPkgYe161020Vo	 = new InfcPkgYe161020_2022_VO();	//A_인적소득공제기본
 		InfcPkgYe161030_2022_VO    infcPkgYe161030Vo	 = new InfcPkgYe161030_2022_VO();	//E_인적공제명세
 		InfcPkgYe161040_2022_VO    infcPkgYe161040Vo	 = new InfcPkgYe161040_2022_VO();	//E_소득세액공제명세
 		InfcPkgYe161050_2022_VO    infcPkgYe161050Vo	 = new InfcPkgYe161050_2022_VO();	//C_연금보험료공제
 		InfcPkgYe161055_2022_VO    infcPkgYe161055Vo	 = new InfcPkgYe161055_2022_VO();	//C_연금보험료_공적연금상세
 		InfcPkgYe161060_2022_VO    infcPkgYe161060Vo	 = new InfcPkgYe161060_2022_VO();	//C_특별소득공제
 		InfcPkgYe161070_2022_VO    infcPkgYe161070Vo	 = new InfcPkgYe161070_2022_VO();	//C_그밖의소득공제
 		InfcPkgYe161080_2022_VO    infcPkgYe161080Vo	 = new InfcPkgYe161080_2022_VO();	//C_세액감면및공제
 		InfcPkgYe161090_2022_VO    infcPkgYe161090Vo	 = new InfcPkgYe161090_2022_VO();	//C_교육비내역
 		InfcPkgYe162010_2022_VO    infcPkgYe162010Vo	 = new InfcPkgYe162010_2022_VO();	//F_연금저축계좌
 		InfcPkgYe162020_2022_VO    infcPkgYe162020Vo	 = new InfcPkgYe162020_2022_VO();	//F_퇴직연금계좌명세
 		InfcPkgYe162030_2022_VO    infcPkgYe162030Vo	 = new InfcPkgYe162030_2022_VO();	//F_주택마련저축
 		InfcPkgYe162040_2022_VO    infcPkgYe162040Vo	 = new InfcPkgYe162040_2022_VO();	//F_장기집합투자증권저축_B1013
 		InfcPkgYe162510_2022_VO    infcPkgYe162510Vo	 = new InfcPkgYe162510_2022_VO();	//G_월세액소득공제명세
 		InfcPkgYe162520_2022_VO    infcPkgYe162520Vo	 = new InfcPkgYe162520_2022_VO();	//G_거주자간_금전소비대차
 		InfcPkgYe162530_2022_VO    infcPkgYe162530Vo	 = new InfcPkgYe162530_2022_VO();	//G_임대차계약
 		InfcPkgYe164010_2022_VO    infcPkgYe164010Vo	 = new InfcPkgYe164010_2022_VO();	//A_의료비지급명세
 		InfcPkgYe165010_2022_VO    infcPkgYe165010Vo	 = new InfcPkgYe165010_2022_VO();	//I_해당연도기부금명세
 		InfcPkgYe165020_2022_VO    infcPkgYe165020Vo	 = new InfcPkgYe165020_2022_VO();	//I_기부자관계코드별기부금합계
 		InfcPkgYe165030_2022_VO    infcPkgYe165030Vo	 = new InfcPkgYe165030_2022_VO();	//H_기부금조정명세
 		InfcPkgYe165030Temp_2022_VO infcPkgYe165030TempVo = new InfcPkgYe165030Temp_2022_VO();  	    //H_기부금조정명세_TEMP	 
 		InfcPkgYe166010_2022_VO    infcPkgYe166010Vo	 = new InfcPkgYe166010_2022_VO();	//신용카드등소득공제명세
 		InfcPkgYe166020_2022_VO    infcPkgYe166020Vo	 = new InfcPkgYe166020_2022_VO();	//신용카드등소득공제상세
 			 								//
 		//InfcPkgYe169010VO    infcPkgYe169010Vo	 = new InfcPkgYe169010VO();	//C_주현근무처
 		InfcPkgYe169010a_2022_VO   infcPkgYe169010AVo = new InfcPkgYe169010a_2022_VO();	//C_주현근무처_표준공제 
 	
 	  	 
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
 			statCnt = infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_3001_Update(infcPkgYe169010AVo);
 			if (statCnt >= 0) {
 			/**
 			 * ####################### 종합소득과세표준 기타공제계 ############################################			 */
 			
 				statCnt = 0;
 				statCnt = infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_3002_Update(infcPkgYe169010AVo);
 				if (statCnt >= 0) {
 				
 					/** ####################### 산출세액- 기타공제계-  * ############################################  */
 			
 					statCnt = 0;
 					statCnt = infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_3003_Update(infcPkgYe169010AVo);
 					if (statCnt >= 0) {
 					/**
 					 * ####################### 산출세액-세액감면  ############################################ */
 				
 						statCnt = 0;
 						statCnt = infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_3004_Update(infcPkgYe169010AVo);
 						if (statCnt >= 0) {
 						/**
 						 * ####################### 세액공제 -근로소득공제 감면세액계  ############################################
 						 */
 					
 							statCnt = 0;
 							statCnt = infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_3005_Update(infcPkgYe169010AVo);

 							if (statCnt >= 0) {
 							      /**#######################  세액공제 주택차입금 ----- 외국납부    ############################################*/
 							
 								infcPkgYe169010AVo.setYetaStdC152(new BigDecimal("130000"));
 								statCnt = 0;
 								statCnt =  infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_3006_Update(infcPkgYe169010AVo);
 								if (statCnt >= 0) {
 									
 							          /**#######################  교육비합계 사용안함 나중에 확인     ############################################*/
 						 
// 									statCnt = 0;
// 									statCnt =  infcPkgYeta7300.fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(infcPkgYe169010AVo); 
// 									
// 									if (statCnt >= 0) {
 								      /**#######################      ############################################*/
 									if (statCnt >= 0) {
 								     //YETA_C152
 								 
 											
 								     infcPkgYe169010AVo.setC152StdTxDdcYn("Y");
 										 
 									statCnt = 0;
 									statCnt =  infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_3007_Update(infcPkgYe169010AVo); 

 									if (statCnt >= 0) {	 

 										/******************************************************************************************
 										 * 산출세액에 따른 세액공제 0처리 및 단계별 빼기 작업을 위한 구현 부
 										 * 
 										 *******************************************************************************************/
 									
 										   /**#######################      ############################################*/
 									     // InfcPkgYe169010VO infcPkgYe169010Vo = new InfcPkgYe169010VO();  //연말정산결과  
 									      InfcPkgYe169010a_2022_VO tpInfcPkgYe169010AVo = new InfcPkgYe169010a_2022_VO();  //연말정산결과  
 									      
 									      
 									      infcPkgYe169010AVo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
 									      infcPkgYe169010AVo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
 									      infcPkgYe169010AVo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
 									      infcPkgYe169010AVo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
 									      
 									      tpInfcPkgYe169010AVo = infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_2001_Select(infcPkgYe169010AVo); 
 									  
 									       
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
 									         
 									      //2022연말정산_추가
 									         //ISA
 									         exJRTR_HISA = tpInfcPkgYe169010AVo.getYetaStdC13b();
 									        if (exTpPRDD_TAXN.compareTo(exJRTR_HISA ) > 0) {
 	 									          exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exJRTR_HISA);
 	 									         }
 	 									       else
 	 									       {
 	 									    	 exJRTR_HISA  = BigDecimal.ZERO;
 	 									           if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
 	 									        	 exJRTR_HISA     = exTpPRDD_TAXN;
 	 									             exTpPRDD_TAXN  = BigDecimal.ZERO;
 	 									           }
 	 									       }
 									       ////
 									       
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
 									     
 									        infcPkgYe169010AVo.setYetaStdC122(exADDR_MCCR);    /** column C122_세액공제_자녀세액공제금액 : yetaC122 */
 									        infcPkgYe169010AVo.setYetaStdC124(exADDR_CHLD);    /** column C124_세액공제_6세이하자녀세액공제금액 : yetaC124 */
 									        infcPkgYe169010AVo.setYetaStdC126(exADDR_BRTH);    /** column C126_세액공제_출산입양세액공제금액 : yetaC126 */
 									        
 									        infcPkgYe169010AVo.setYetaStdC128(exJRTR_HICT);    /** column C128_세액공제_연금계좌_과학기술인공제세액공제금액 : yetaC128 */
 									        infcPkgYe169010AVo.setYetaStdC130(exJRTR_PSRN);    /** column C130_세액공제_연금계좌_퇴직급여세액공제금액 : yetaC130 */
 									        infcPkgYe169010AVo.setYetaStdC132(exJRTR_HNSV);    /** column C132_세액공제_연금계좌_연금저축세액공제금액 : yetaC132 */
 									        
 									        infcPkgYe169010AVo.setYetaStdC13b(exJRTR_HISA);    /** column C132_세액공제_연금계좌_연금퇴직ISA저축세액공제금액 : yetaC13B */

 									        infcPkgYe169010AVo.setYetaStdC134(exSPCI_GURT);    /** column C134_세액공제_특별세액공제_보장성보럼세액공제금액 : yetaC134 */
 									        infcPkgYe169010AVo.setYetaStdC136(exSPCI_HDRC);    /** column C136_세액공제_특별세액공제_장애인전용세액공제금액 : yetaC136 */
 									      
 									        infcPkgYe169010AVo.setYetaStdC138(exSPCI_TXCR);    /** column C138_세액공제_특별세액공제_의료비세액공제금액 : yetaC138 */
 									        
 									        infcPkgYe169010AVo.setYetaStdC140(exSPED_TXCR);    /** column C140_세액공제_특별세액공제_교육비세액공제금액 : yetaC140 */
 
 									        infcPkgYe169010AVo.setYetaStdC157(exSPCI_RTAM);    /** column C157_세액공제_월세세액공제금액 : yetaC157 */

 									        infcPkgYe169010AVo.setYetaStdC142(exTAXD_PLTC);    /** column C142_세액공제_특별세액공제_기부금정치자금10만이하세액공제금액 : yetaC142 */
 									        infcPkgYe169010AVo.setYetaStdC144(exSPCI_PLTC);    /** column C144_세액공제_특별세액공제_기부금정치자금10만초과세액공제금액 : yetaC144 */
 									        
 									        infcPkgYe169010AVo.setYetaStdC146(exSPCI_FBAM);    /** column C146_세액공제_특별세액공제_법정기부금세액공제금액 : yetaC146 */
 									        infcPkgYe169010AVo.setYetaStdC148(exSPCI_RFAM);    /** column C148_세액공제_특별세액공제_우리사주조합기부금세액공제금액 : yetaC148 */
 									        infcPkgYe169010AVo.setYetaStdC150(exSPCI_NAMT);    /** column C150_세액공제_특별세액공제_지정기부금_종교단체외세액공제금액 : yetaC150 */
 									        infcPkgYe169010AVo.setYetaStdC150b(exSPCI_YAMT);    /** column C150B_세액공제_특별세액공제_지정기부금_종교단체세액공제금액 : yetaC150b */
 									        
 									        infcPkgYe169010AVo.setYetaStdC152(exSPCI_DDCT);    /** column C152_세액공제_표준세액공제금액 : yetaC152 */
 									        
// 									         infcPkgYe169010AVo.setSpciDdct(exSPCI_DDCT);    /** column 특별공제_표준공제 : spciDdct */
  
 									        
 									        infcPkgYe169010AVo.setYetaStdC114(exTAXD_ICAX);    /** column C114_세액감면_소득세법감면금액 : yetaC114 */
 									        infcPkgYe169010AVo.setYetaStdC115(exTAXD_SPCT);    /** column C115_세액감면_조특법_조세조약제외_감면금액 : yetaC115 */
 									        infcPkgYe169010AVo.setYetaStdC116(exTXLG_CL30);    /** column C116_세액감면_조특범30조_감면금액 : yetaC116 */
 									        infcPkgYe169010AVo.setYetaStdC117(exTXLG_HXTT);    /** column C117_세액감면_조세조약감면금액 : yetaC117 */
 									        infcPkgYe169010AVo.setYetaStdC119(exTAXD_TSUM);    /** column C119_세액감면합계금액 : yetaC119 */
 									         
 									        infcPkgYe169010AVo.setYetaStdC120(exTAXD_WKEN);    /** column C120_세액공제_근로소득세액공제금액 : yetaC120 */
 									         //infcPkgYe169010AVo.setTaxdWken(exTAXD_WKEN);    /** column 세액공제_근로소득세액공제 : taxdWken */
 									         
 									         
 									        infcPkgYe169010AVo.setYetaStdC153(exTAXD_UNIN);    /** column C153_세액공제_납세조합공제금액 : yetaC153 */
 									        infcPkgYe169010AVo.setYetaStdC154(exTAXD_LOAN);    /** column C154_세액공제_주택차입금금액 : yetaC154 */
 									        infcPkgYe169010AVo.setYetaStdC155(exTAXD_PAID);    /** column C155_세액공제_외국납부금액 : yetaC155 */ 
 									        
 									       //  infcPkgYe169010AVo.setAddrMccr(exADDR_MCCR);    /** column 세액공제_자녀세액공제금액 : addrMccr */
 									        infcPkgYe169010AVo.setYetaStdC151(exSPCI_DCTO);    /** column C151_세액공제_특별세액공제합계금액 : yetaC151 */
 									        infcPkgYe169010AVo.setYetaStdC158(exTAXD_CSUM);    /** column C158_세액공제합계금액 : yetaC158 */
 									   
 									         statCnt = 0;
 										  	 statCnt =  infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_3008_Update(infcPkgYe169010AVo); 

 											}

 									      /**#######################  특별공제)특별 세액공제계 -표준세액 공제 ############################################*/
 									       
 									           statCnt = 0;
 									  		   statCnt =  infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_3009_Update(infcPkgYe169010AVo); 
 									  			if (statCnt >= 0) {
 									  		   /**#######################  세액감면 세액공제- ############################################*/
 									  	      
 									  		
 									  			statCnt = 0;
 									  			statCnt = infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_3010_Update(infcPkgYe169010AVo); 
 									  			if (statCnt >= 0) { 
 									  	    
 									  	    /**#######################  농어촌특별세 계산 ############################################*/ 
 									  		
 									  			statCnt = 0;
 									  			statCnt =  infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_3011_Update(infcPkgYe169010AVo); 
 									  			if (statCnt >= 0) { 
 									  	    
 									  	      /**#######################  결정세액 ############################################*/ 
 									  			
 									  				statCnt = 0;
 									  				statCnt = infcPkgYeta7300.fnYeta7300_YE169010a_Tax_2022_3012_Update(infcPkgYe169010AVo); 

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
    
    private  List<ShowMessageBM> YetaTaxBaseUpdate(HttpServletRequest request,InfcPkgYe161010_2022_VO  infcPkgYe161010Vo) throws Exception {
  	  
    	
        PagingLoadResult<ShowMessageBM> retval = null; 
   	   List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
   	   MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
   	  
   	   infcPkgYeta7300 = (Yeta7300PayrService)BeanFinder.getBean("Yeta7300PayrService"); 
   	   
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
       BigDecimal exJRTR_HISA    = BigDecimal.ZERO;
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
 		
 		InfcPkgYe160404_2022_VO    infcPkgYe160404Vo	 = new InfcPkgYe160404_2022_VO();	//D_종전근무처
 		InfcPkgYe160405_2022_VO    infcPkgYe160405Vo	 = new InfcPkgYe160405_2022_VO();	//D_종전근무처비과세_감면소득_비과세
 		InfcPkgYe160406_2022_VO    infcPkgYe160406Vo	 = new InfcPkgYe160406_2022_VO();	//종전근무지연금보험료_공적연금
 		InfcPkgYe160510_2022_VO    infcPkgYe160510Vo	 = new InfcPkgYe160510_2022_VO();	//근무지별비과세_감면소득
 		
 		InfcPkgYe161005_2022_VO    infcPkgYe161005Vo	 = new InfcPkgYe161005_2022_VO();	//A_원천세신고기본
 		
 		//InfcPkgYe161010VO    infcPkgYe161010Vo	 = new InfcPkgYe161010VO();	// 연말정산대상자기본
 		InfcPkgYe161020_2022_VO    infcPkgYe161020Vo	 = new InfcPkgYe161020_2022_VO();	//A_인적소득공제기본
 		InfcPkgYe161030_2022_VO    infcPkgYe161030Vo	 = new InfcPkgYe161030_2022_VO();	//E_인적공제명세
 		InfcPkgYe161040_2022_VO    infcPkgYe161040Vo	 = new InfcPkgYe161040_2022_VO();	//E_소득세액공제명세
 		InfcPkgYe161050_2022_VO    infcPkgYe161050Vo	 = new InfcPkgYe161050_2022_VO();	//C_연금보험료공제
 		InfcPkgYe161055_2022_VO    infcPkgYe161055Vo	 = new InfcPkgYe161055_2022_VO();	//C_연금보험료_공적연금상세
 		InfcPkgYe161060_2022_VO    infcPkgYe161060Vo	 = new InfcPkgYe161060_2022_VO();	//C_특별소득공제
 		InfcPkgYe161070_2022_VO    infcPkgYe161070Vo	 = new InfcPkgYe161070_2022_VO();	//C_그밖의소득공제
 		InfcPkgYe161080_2022_VO    infcPkgYe161080Vo	 = new InfcPkgYe161080_2022_VO();	//C_세액감면및공제
 		InfcPkgYe161090_2022_VO    infcPkgYe161090Vo	 = new InfcPkgYe161090_2022_VO();	//C_교육비내역
 		InfcPkgYe162010_2022_VO    infcPkgYe162010Vo	 = new InfcPkgYe162010_2022_VO();	//F_연금저축계좌
 		InfcPkgYe162020_2022_VO    infcPkgYe162020Vo	 = new InfcPkgYe162020_2022_VO();	//F_퇴직연금계좌명세
 		InfcPkgYe162030_2022_VO    infcPkgYe162030Vo	 = new InfcPkgYe162030_2022_VO();	//F_주택마련저축
 		InfcPkgYe162040_2022_VO    infcPkgYe162040Vo	 = new InfcPkgYe162040_2022_VO();	//F_장기집합투자증권저축_B1013
 		InfcPkgYe162510_2022_VO    infcPkgYe162510Vo	 = new InfcPkgYe162510_2022_VO();	//G_월세액소득공제명세
 		InfcPkgYe162520_2022_VO    infcPkgYe162520Vo	 = new InfcPkgYe162520_2022_VO();	//G_거주자간_금전소비대차
 		InfcPkgYe162530_2022_VO    infcPkgYe162530Vo	 = new InfcPkgYe162530_2022_VO();	//G_임대차계약
 		InfcPkgYe164010_2022_VO    infcPkgYe164010Vo	 = new InfcPkgYe164010_2022_VO();	//A_의료비지급명세
 		InfcPkgYe165010_2022_VO    infcPkgYe165010Vo	 = new InfcPkgYe165010_2022_VO();	//I_해당연도기부금명세
 		InfcPkgYe165020_2022_VO    infcPkgYe165020Vo	 = new InfcPkgYe165020_2022_VO();	//I_기부자관계코드별기부금합계
 		InfcPkgYe165030_2022_VO    infcPkgYe165030Vo	 = new InfcPkgYe165030_2022_VO();	//H_기부금조정명세
 		InfcPkgYe165030Temp_2022_VO infcPkgYe165030TempVo = new InfcPkgYe165030Temp_2022_VO();  	    //H_기부금조정명세_TEMP	 
 		InfcPkgYe166010_2022_VO    infcPkgYe166010Vo	 = new InfcPkgYe166010_2022_VO();	//신용카드등소득공제명세
 		InfcPkgYe166020_2022_VO    infcPkgYe166020Vo	 = new InfcPkgYe166020_2022_VO();	//신용카드등소득공제상세
 			 								//
 		InfcPkgYe169010_2022_VO    infcPkgYe169010Vo	 = new InfcPkgYe169010_2022_VO();	//C_주현근무처
 		InfcPkgYe169010a_2022_VO   infcPkgYe169010AVo = new InfcPkgYe169010a_2022_VO();	//C_주현근무처_표준공제 
 	
 	  	 
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
 			statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_3001_Update(infcPkgYe169010Vo);
 			if (statCnt >= 0) {
 			/**
 			 * ####################### 종합소득과세표준 기타공제계 ############################################			 */
 			
 				statCnt = 0;
 				statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_3002_Update(infcPkgYe169010Vo);
 				if (statCnt >= 0) {
 				
 					/** ####################### 산출세액- 기타공제계-  * ############################################  */
 			
 					statCnt = 0;
 					statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_3003_Update(infcPkgYe169010Vo);
 					if (statCnt >= 0) {
 					/**
 					 * ####################### 산출세액-세액감면  ############################################ */
 				
 						statCnt = 0;
 						statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_3004_Update(infcPkgYe169010Vo);
 						if (statCnt >= 0) {
 						/**
 						 * ####################### 세액공제 -근로소득공제 감면세액계  ############################################
 						 */
 					
 							statCnt = 0;
 							statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_3005_Update(infcPkgYe169010Vo);

 							if (statCnt >= 0) {
 							      /**#######################  세액공제 주택차입금 ----- 외국납부    ############################################*/
 							
 								statCnt = 0;
 								statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_3006_Update(infcPkgYe169010Vo);
 								if (statCnt >= 0) {
 									
 							          /**#######################  교육비합계 사용안함 나중에 확인     ############################################*/
 						 
// 									statCnt = 0;
// 									statCnt =  infcPkgYeta7300.fnPayr06430_PAYR425_ReTax_2016_CREATE_BEF_12_1_Update(infcPkgYe161010Vo); 
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
 									statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_3007_Update(infcPkgYe169010Vo); 

 									if (statCnt >= 0) {	 

 										/******************************************************************************************
 										 * 산출세액에 따른 세액공제 0처리 및 단계별 빼기 작업을 위한 구현 부
 										 * 
 										 *******************************************************************************************/
 									
 										   /**#######################      ############################################*/
 									     // InfcPkgYe169010VO infcPkgYe169010Vo = new InfcPkgYe169010VO();  //연말정산결과  
 									      InfcPkgYe169010_2022_VO tpInfcPkgYe169010Vo = new InfcPkgYe169010_2022_VO();  //연말정산결과  
 									      
 									      
 									      infcPkgYe169010Vo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
 									      infcPkgYe169010Vo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
 									      infcPkgYe169010Vo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
 									      infcPkgYe169010Vo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
 									      
 									      tpInfcPkgYe169010Vo = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_2001_Select(infcPkgYe169010Vo); 
 									  
 									       
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
 									         
 									        exJRTR_HISA  = tpInfcPkgYe169010Vo.getYetaC13b(); 
 									       if (exTpPRDD_TAXN.compareTo(exJRTR_HISA ) > 0) {
  									          exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(exJRTR_HISA);
  									         }
  									       else
  									       {
  									    	 exJRTR_HISA  = BigDecimal.ZERO;
  									           if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO) > 0) {
  									        	 exJRTR_HISA     = exTpPRDD_TAXN;
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
 									     
 									        infcPkgYe169010Vo.setYetaC122(exADDR_MCCR);    /** column C122_세액공제_자녀세액공제금액 : yetaC122 */
 									        infcPkgYe169010Vo.setYetaC124(exADDR_CHLD);    /** column C124_세액공제_6세이하자녀세액공제금액 : yetaC124 */
 									        infcPkgYe169010Vo.setYetaC126(exADDR_BRTH);    /** column C126_세액공제_출산입양세액공제금액 : yetaC126 */
 									        
 									        infcPkgYe169010Vo.setYetaC128(exJRTR_HICT);    /** column C128_세액공제_연금계좌_과학기술인공제세액공제금액 : yetaC128 */
 									        infcPkgYe169010Vo.setYetaC130(exJRTR_PSRN);    /** column C130_세액공제_연금계좌_퇴직급여세액공제금액 : yetaC130 */
 									        infcPkgYe169010Vo.setYetaC132(exJRTR_HNSV);    /** column C132_세액공제_연금계좌_연금저축세액공제금액 : yetaC132 */
 									        
 									        infcPkgYe169010Vo.setYetaC13b(exJRTR_HISA);    /** column C132_세액공제_연금계좌_연금저축ISA세액공제금액 : yetaC13B */

 									        infcPkgYe169010Vo.setYetaC134(exSPCI_GURT);    /** column C134_세액공제_특별세액공제_보장성보럼세액공제금액 : yetaC134 */
 									        infcPkgYe169010Vo.setYetaC136(exSPCI_HDRC);    /** column C136_세액공제_특별세액공제_장애인전용세액공제금액 : yetaC136 */
        
 									        infcPkgYe169010Vo.setYetaC138(exSPCI_TXCR);    /** column C138_세액공제_특별세액공제_의료비세액공제금액 : yetaC138 */
 		
 									        infcPkgYe169010Vo.setYetaC140(exSPED_TXCR);    /** column C140_세액공제_특별세액공제_교육비세액공제금액 : yetaC140 */
 									   
 									        infcPkgYe169010Vo.setYetaC157(exSPCI_RTAM);    /** column C157_세액공제_월세세액공제금액 : yetaC157 */

 									        infcPkgYe169010Vo.setYetaC142(exTAXD_PLTC);    /** column C142_세액공제_특별세액공제_기부금정치자금10만이하세액공제금액 : yetaC142 */
 									        infcPkgYe169010Vo.setYetaC144(exSPCI_PLTC);    /** column C144_세액공제_특별세액공제_기부금정치자금10만초과세액공제금액 : yetaC144 */
 									        
 									        infcPkgYe169010Vo.setYetaC146(exSPCI_FBAM);    /** column C146_세액공제_특별세액공제_법정기부금세액공제금액 : yetaC146 */
 									        infcPkgYe169010Vo.setYetaC148(exSPCI_RFAM);    /** column C148_세액공제_특별세액공제_우리사주조합기부금세액공제금액 : yetaC148 */
 									        infcPkgYe169010Vo.setYetaC150(exSPCI_NAMT);    /** column C150_세액공제_특별세액공제_지정기부금_종교단체외세액공제금액 : yetaC150 */
 									        infcPkgYe169010Vo.setYetaC150b(exSPCI_YAMT);    /** column C150B_세액공제_특별세액공제_지정기부금_종교단체세액공제금액 : yetaC150b */
 			
 									        infcPkgYe169010Vo.setYetaC152(exSPCI_DDCT);    /** column C152_세액공제_표준세액공제금액 : yetaC152 */
 									        
 									        infcPkgYe169010Vo.setYetaC114(exTAXD_ICAX);    /** column C114_세액감면_소득세법감면금액 : yetaC114 */
 									        infcPkgYe169010Vo.setYetaC115(exTAXD_SPCT);    /** column C115_세액감면_조특법_조세조약제외_감면금액 : yetaC115 */
 									        infcPkgYe169010Vo.setYetaC116(exTXLG_CL30);    /** column C116_세액감면_조특범30조_감면금액 : yetaC116 */
 									        infcPkgYe169010Vo.setYetaC117(exTXLG_HXTT);    /** column C117_세액감면_조세조약감면금액 : yetaC117 */
 									        infcPkgYe169010Vo.setYetaC119(exTAXD_TSUM);    /** column C119_세액감면합계금액 : yetaC119 */

 									        infcPkgYe169010Vo.setYetaC120(exTAXD_WKEN);    /** column C120_세액공제_근로소득세액공제금액 : yetaC120 */
 									         //infcPkgYe169010Vo.setTaxdWken(exTAXD_WKEN);    /** column 세액공제_근로소득세액공제 : taxdWken */
 									         
 									         
 									        infcPkgYe169010Vo.setYetaC153(exTAXD_UNIN);    /** column C153_세액공제_납세조합공제금액 : yetaC153 */
 									        infcPkgYe169010Vo.setYetaC154(exTAXD_LOAN);    /** column C154_세액공제_주택차입금금액 : yetaC154 */
 									        infcPkgYe169010Vo.setYetaC155(exTAXD_PAID);    /** column C155_세액공제_외국납부금액 : yetaC155 */ 
 									        
 									       //  infcPkgYe169010Vo.setAddrMccr(exADDR_MCCR);    /** column 세액공제_자녀세액공제금액 : addrMccr */
 									        infcPkgYe169010Vo.setYetaC151(exSPCI_DCTO);    /** column C151_세액공제_특별세액공제합계금액 : yetaC151 */
 									        infcPkgYe169010Vo.setYetaC158(exTAXD_CSUM);    /** column C158_세액공제합계금액 : yetaC158 */
 				
 									         statCnt = 0;
 										  	 statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_3008_Update(infcPkgYe169010Vo); 

 											}

 									      /**#######################  특별공제)특별 세액공제계 -표준세액 공제 ############################################*/
 									       
 									           statCnt = 0;
 									  		   statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_3009_Update(infcPkgYe169010Vo); 
 									  			if (statCnt >= 0) {
 									  		   /**#######################  세액감면 세액공제- ############################################*/
 									  	      
 									  		
 									  			statCnt = 0;
 									  			statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_3010_Update(infcPkgYe169010Vo); 
 									  			if (statCnt >= 0) { 
 									  	    
 									  	    /**#######################  농어촌특별세 계산 ############################################*/ 
 									  		
 									  			statCnt = 0;
 									  			statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_3011_Update(infcPkgYe169010Vo); 
 									  			if (statCnt >= 0) { 
 									  	    
 									  	      /**#######################  결정세액 ############################################*/ 
 									  			
 									  				statCnt = 0;
 									  				statCnt = infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_3012_Update(infcPkgYe169010Vo); 

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
     
    
	private BigDecimal fnRtnSubTaxConTrbution(HttpServletRequest request,InfcPkgYe161010_2022_VO  infcPkgYe161010Vo,BigDecimal exTpPRDD_TAXN,String exGubun,String std_ddc_tax) throws Exception {
		/**#######################  기부금공제 3 불러와서 년도별 수정하는걸로 변경함 ############################################*/ 

		PagingLoadResult<ShowMessageBM> retval = null; 
		List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

		infcPkgYeta7300 = (Yeta7300PayrService)BeanFinder.getBean("Yeta7300PayrService"); 

		int statCnt = 0;
		String dataCheck = "";
		BigDecimal rtnBgVal = BigDecimal.ZERO;

		InfcPkgYe169010_2022_VO    infcPkgYe169010Vo	 = new InfcPkgYe169010_2022_VO();	//C_주현근무처
		InfcPkgYe169010a_2022_VO   infcPkgYe169010AVo = new InfcPkgYe169010a_2022_VO();	//C_주현근무처_표준공제 
	  	 
		infcPkgYe161010Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
		infcPkgYe161010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
		infcPkgYe161010Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
		infcPkgYe161010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
   
		BeanUtils.copyProperties(infcPkgYe169010Vo, infcPkgYe161010Vo); 
		BeanUtils.copyProperties(infcPkgYe169010AVo, infcPkgYe161010Vo); 
 	   
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
				BigDecimal bgSPCI_FBTG16_10  = BigDecimal.ZERO;
				BigDecimal bgSPCI_FBTG17_10  = BigDecimal.ZERO;
				BigDecimal bgSPCI_FBTG18_10  = BigDecimal.ZERO;
				BigDecimal bgSPCI_FBTG19_10  = BigDecimal.ZERO;
				BigDecimal bgSPCI_FBTG20_10  = BigDecimal.ZERO;
				BigDecimal bgSPCI_FBTG21_10  = BigDecimal.ZERO;
				BigDecimal bgSPCI_FBSE16_10  = BigDecimal.ZERO;
				BigDecimal bgSPCI_FBSE17_10  = BigDecimal.ZERO;
				BigDecimal bgSPCI_FBSE18_10  = BigDecimal.ZERO;
				BigDecimal bgSPCI_FBSE19_10  = BigDecimal.ZERO;
				BigDecimal bgSPCI_FBSE20_10  = BigDecimal.ZERO;
				BigDecimal bgSPCI_FBSE21_10  = BigDecimal.ZERO;
				BigDecimal bgSPCI_NA16_40    = BigDecimal.ZERO;
				BigDecimal bgSPCI_NA17_40    = BigDecimal.ZERO;
				BigDecimal bgSPCI_NA18_40    = BigDecimal.ZERO;
				BigDecimal bgSPCI_NA19_40    = BigDecimal.ZERO;
				BigDecimal bgSPCI_NA20_40    = BigDecimal.ZERO;
				BigDecimal bgSPCI_NA21_40    = BigDecimal.ZERO;
				BigDecimal bgSPCI_NATG16_40  = BigDecimal.ZERO;
				BigDecimal bgSPCI_NATG17_40  = BigDecimal.ZERO;
				BigDecimal bgSPCI_NATG18_40  = BigDecimal.ZERO;
				BigDecimal bgSPCI_NATG19_40  = BigDecimal.ZERO;
				BigDecimal bgSPCI_NATG20_40  = BigDecimal.ZERO;
				BigDecimal bgSPCI_NATG21_40  = BigDecimal.ZERO;
				BigDecimal bgSPCI_NASE16_40  = BigDecimal.ZERO;
				BigDecimal bgSPCI_NASE17_40  = BigDecimal.ZERO;
				BigDecimal bgSPCI_NASE18_40  = BigDecimal.ZERO;
				BigDecimal bgSPCI_NASE19_40  = BigDecimal.ZERO;
				BigDecimal bgSPCI_NASE20_40  = BigDecimal.ZERO;
				BigDecimal bgSPCI_NASE21_40  = BigDecimal.ZERO;
				BigDecimal bgSPCI_YA16_41    = BigDecimal.ZERO;
				BigDecimal bgSPCI_YA17_41    = BigDecimal.ZERO;
				BigDecimal bgSPCI_YA18_41    = BigDecimal.ZERO;
				BigDecimal bgSPCI_YA19_41    = BigDecimal.ZERO;
				BigDecimal bgSPCI_YA20_41    = BigDecimal.ZERO;
				BigDecimal bgSPCI_YA21_41    = BigDecimal.ZERO;
				BigDecimal bgSPCI_YATG16_41  = BigDecimal.ZERO;
				BigDecimal bgSPCI_YATG17_41  = BigDecimal.ZERO;
				BigDecimal bgSPCI_YATG18_41  = BigDecimal.ZERO;
				BigDecimal bgSPCI_YATG19_41  = BigDecimal.ZERO;
				BigDecimal bgSPCI_YATG20_41  = BigDecimal.ZERO;
				BigDecimal bgSPCI_YATG21_41  = BigDecimal.ZERO;
				BigDecimal bgSPCI_YASE16_41  = BigDecimal.ZERO;
				BigDecimal bgSPCI_YASE17_41  = BigDecimal.ZERO;
				BigDecimal bgSPCI_YASE18_41  = BigDecimal.ZERO;
				BigDecimal bgSPCI_YASE19_41  = BigDecimal.ZERO;
				BigDecimal bgSPCI_YASE20_41  = BigDecimal.ZERO;
				BigDecimal bgSPCI_YASE21_41  = BigDecimal.ZERO;

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
				bgSPCI_FBTG16_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg1610"),"0"));
				bgSPCI_FBTG17_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg1710"),"0"));
				bgSPCI_FBTG18_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg1810"),"0"));
				bgSPCI_FBTG19_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg1910"),"0"));
				bgSPCI_FBTG20_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg2010"),"0"));
				bgSPCI_FBTG21_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg2110"),"0"));
				bgSPCI_FBSE16_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse1610"),"0"));
				bgSPCI_FBSE17_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse1710"),"0"));
				bgSPCI_FBSE18_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse1810"),"0"));
				bgSPCI_FBSE19_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse1910"),"0"));
				bgSPCI_FBSE20_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse2010"),"0"));
				bgSPCI_FBSE21_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse2110"),"0"));
				bgSPCI_NA16_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1640"),"0"));
				bgSPCI_NA17_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1740"),"0"));
				bgSPCI_NA18_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1840"),"0"));
				bgSPCI_NA19_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1940"),"0"));
				bgSPCI_NA20_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa2040"),"0"));
				bgSPCI_NA21_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa2140"),"0"));
				bgSPCI_NATG16_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg1640"),"0"));
				bgSPCI_NATG17_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg1740"),"0"));
				bgSPCI_NATG18_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg1840"),"0"));
				bgSPCI_NATG19_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg1940"),"0"));
				bgSPCI_NATG20_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg2040"),"0"));
				bgSPCI_NATG21_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg2140"),"0"));
				bgSPCI_NASE16_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase1640"),"0"));
				bgSPCI_NASE17_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase1740"),"0"));
				bgSPCI_NASE18_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase1840"),"0"));
				bgSPCI_NASE19_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase1940"),"0"));
				bgSPCI_NASE20_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase2040"),"0"));
				bgSPCI_NASE21_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase2140"),"0"));
				bgSPCI_YA16_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1641"),"0"));
				bgSPCI_YA17_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1741"),"0"));
				bgSPCI_YA18_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1841"),"0"));
				bgSPCI_YA19_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1941"),"0"));
				bgSPCI_YA20_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa2041"),"0"));
				bgSPCI_YA21_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa2141"),"0"));
				bgSPCI_YATG16_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg1641"),"0"));
				bgSPCI_YATG17_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg1741"),"0"));
				bgSPCI_YATG18_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg1841"),"0"));
				bgSPCI_YATG19_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg1941"),"0"));
				bgSPCI_YATG20_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg2041"),"0"));
				bgSPCI_YATG21_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg2141"),"0"));
				bgSPCI_YASE16_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase1641"),"0"));
				bgSPCI_YASE17_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase1741"),"0"));
				bgSPCI_YASE18_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase1841"),"0"));
				bgSPCI_YASE19_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase1941"),"0"));
				bgSPCI_YASE20_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase2041"),"0"));
				bgSPCI_YASE21_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase2141"),"0"));
				
				bgYETA_C141=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC141"),"0"));
				bgYETA_C143=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC143"),"0"));
				BigDecimal bgYETA_C142=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC142"),"0"));
				BigDecimal bgYETA_C144=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC144"),"0"));
	           	 
		               
				bgYETA_C147=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC147"),"0"));
	               
		               
				InfcPkgYe169010_2022_VO     inputYe169010Vo = new InfcPkgYe169010_2022_VO();	//C_주현근무처 
				//  	InfcPkgYe161060VO    inputYe161060Vo	 = new InfcPkgYe161060VO();	//C_특별소득공제
				//	InfcPkgYe161070VO    inputYe161070Vo	 = new InfcPkgYe161070VO();	//C_그밖의소득공제
				InfcPkgYe161080_2022_VO    inputYe161080Vo	 = new InfcPkgYe161080_2022_VO();	//C_세액감면및공제
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
		                 
					//법정기부금 2016
					bgSPCI_FBTG16_10 = BigDecimal.ZERO;
					bgSPCI_FBSE16_10 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10);
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE16_10);
					bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG16_10);
					bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE16_10);

					//법정기부금 2017
					bgSPCI_FBTG17_10 = BigDecimal.ZERO;
					bgSPCI_FBSE17_10 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10);
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE17_10);
					bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG17_10);
					bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE17_10);

					//법정기부금 2018
					bgSPCI_FBTG18_10 = BigDecimal.ZERO;
					bgSPCI_FBSE18_10 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG18_10); 
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE18_10);
					bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG18_10);
					bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE18_10);
					
					//법정기부금 2019
					bgSPCI_FBTG19_10 = BigDecimal.ZERO;
					bgSPCI_FBSE19_10 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG19_10); 
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE19_10);
					bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG19_10);
					bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE19_10);
					
					//법정기부금 2020
					bgSPCI_FBTG20_10 = BigDecimal.ZERO;
					bgSPCI_FBSE20_10 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG20_10); 
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE20_10);
					bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG20_10);
					bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE20_10);
					
					//법정기부금 2021
					bgSPCI_FBTG21_10 = BigDecimal.ZERO;
					bgSPCI_FBSE21_10 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG21_10); 
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE21_10);
					bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG21_10);
					bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE21_10);
					
					
					//법정기부금 2022
					//bgSPCI_FBTG22_10 = BigDecimal.ZERO;
					//bgSPCI_FBSE22_10 = BigDecimal.ZERO;
					//bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG22_10); 
					//bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE22_10);
					//bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG22_10);
					//bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE22_10);


					//우리사주조합기부금
					bgYETA_C147 = BigDecimal.ZERO;
					bgYETA_C148 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgYETA_C147);
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgYETA_C148);
			
					//종교단체외 2016
					bgSPCI_NATG16_40 = BigDecimal.ZERO;
					bgSPCI_NASE16_40 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE16_40);
					bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG16_40);
					bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE16_40);


					//종교단체외 2017
					bgSPCI_NATG17_40 = BigDecimal.ZERO;
					bgSPCI_NASE17_40 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE17_40); 
					bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG17_40);
					bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE17_40);
					
					//종교단체외 2018
					bgSPCI_NATG18_40 = BigDecimal.ZERO;
					bgSPCI_NASE18_40 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG18_40);
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE18_40);
					bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG18_40);
					bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE18_40);
		            
					//종교단체외 2019
					bgSPCI_NATG19_40 = BigDecimal.ZERO;
					bgSPCI_NASE19_40 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG19_40);
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE19_40);
					bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG19_40);
					bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE19_40);
					
					//종교단체외 2020
					bgSPCI_NATG20_40 = BigDecimal.ZERO;
					bgSPCI_NASE20_40 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG20_40);
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE20_40);
					bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG20_40);
					bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE20_40);
					
					//종교단체외 2021
					bgSPCI_NATG21_40 = BigDecimal.ZERO;
					bgSPCI_NASE21_40 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG21_40);
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE21_40);
					bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG21_40);
					bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE21_40);
					
					//종교단체외 2022
					//bgSPCI_NATG22_40 = BigDecimal.ZERO;
					//bgSPCI_NASE22_40 = BigDecimal.ZERO;
					//bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG22_40);
					//bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE22_40);
					//bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG22_40);
					//bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE22_40);
					
		            
					//종교단체 2016
					bgSPCI_YATG16_41 = BigDecimal.ZERO;
					bgSPCI_YASE16_41 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG16_41);
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG16_41);
					bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG16_41);
					bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE16_41);

					//종교단체 2017
					bgSPCI_YATG17_41 = BigDecimal.ZERO;
					bgSPCI_YASE17_41 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41);
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE17_41);
					bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG17_41);
					bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE17_41);

					//종교단체 2018 
					bgSPCI_YATG18_41 = BigDecimal.ZERO;
					bgSPCI_YASE18_41 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG18_41);
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE18_41);
					bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG18_41);
					bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE18_41);

					//종교단체 2019 
					bgSPCI_YATG19_41 = BigDecimal.ZERO;
					bgSPCI_YASE19_41 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG19_41);
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE19_41);
					bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG19_41);
					bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE19_41);
					
					//종교단체 2020 
					bgSPCI_YATG20_41 = BigDecimal.ZERO;
					bgSPCI_YASE20_41 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG20_41);
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE20_41);
					bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG20_41);
					bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE20_41);
					
					//종교단체 2021 
					bgSPCI_YATG21_41 = BigDecimal.ZERO;
					bgSPCI_YASE21_41 = BigDecimal.ZERO;
					bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG21_41);
					bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE21_41);
					bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG21_41);
					bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE21_41);
					
					
					//종교단체 2022 
					//bgSPCI_YATG22_41 = BigDecimal.ZERO;
					//bgSPCI_YASE22_41 = BigDecimal.ZERO;
					//bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG22_41);
					//bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE22_41);
					//bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG22_41);
					//bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE22_41);

				} else if ("10".equals(exGubun)  ) {
					//누적 데이타 시작 점   
					bgYetaSumAll = bgYETA_C141.add(bgYETA_C143); //정치자금 기부금  합산
					bgYetaAllSumSe = bgYETA_C142.add(bgYETA_C144); //정치자금 기부금  합산

					if ("N".equals(std_ddc_tax)) { 

						//법정기부금 2016
						if (bgSPCI_FBTG16_10.compareTo(BigDecimal.ZERO) > 0) {
						
							bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10);

							if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {

								bgSPCI_FBSE16_10 = bgSPCI_FBTG16_10.multiply(new BigDecimal("0.15"));

							} else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {

								bgSPCI_FBSE16_10 = bgSPCI_FBTG16_10.multiply(new BigDecimal("0.30"));
							}
			                
			                if (exTpPRDD_TAXN.compareTo(bgSPCI_FBSE16_10 ) > 0) {

								exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_FBSE16_10);
							}
							else
							{ 
								if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {

									bgSPCI_FBSE16_10    = exTpPRDD_TAXN;

									if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {

										bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG16_10);
										bgSPCI_FBTG16_10 = bgSPCI_FBSE16_10.divide(new BigDecimal("0.15"),0,5);

									} else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {

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
		               //법정기부금 2017
		               if (bgSPCI_FBTG17_10.compareTo(BigDecimal.ZERO) > 0) {
			            	
		            	    bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10);
				             
			                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
			                	
			                	bgSPCI_FBSE17_10 = bgSPCI_FBTG17_10.multiply(new BigDecimal("0.15"));
			                	
			                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
			                	
			                	bgSPCI_FBSE17_10 = bgSPCI_FBTG17_10.multiply(new BigDecimal("0.30"));
			                }
			                
			                if (exTpPRDD_TAXN.compareTo(bgSPCI_FBSE17_10 ) > 0) {
			                	 
						           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_FBSE17_10);
							     }
							     else
							     { 
							             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
							           
							            	 bgSPCI_FBSE17_10    = exTpPRDD_TAXN;
							            	
						            	  if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
						            		  
						            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG17_10);
						            			bgSPCI_FBTG17_10 = bgSPCI_FBSE17_10.divide(new BigDecimal("0.15"),0,5);
							                	
							                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
							                	
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
		               
		               	//2018 법정기부금
						if (bgSPCI_FBTG18_10.compareTo(BigDecimal.ZERO) > 0) {
							bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG18_10);

							if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
								bgSPCI_FBSE18_10 = bgSPCI_FBTG18_10.multiply(new BigDecimal("0.15"));
							} else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
								bgSPCI_FBSE18_10 = bgSPCI_FBTG18_10.multiply(new BigDecimal("0.30"));
							}
		                
			                if (exTpPRDD_TAXN.compareTo(bgSPCI_FBSE18_10 ) > 0) {
								exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_FBSE18_10);
							}
							else
							{ 
								if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {

									bgSPCI_FBSE18_10    = exTpPRDD_TAXN;

									if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {

										bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG18_10);
										bgSPCI_FBTG18_10 = bgSPCI_FBSE18_10.divide(new BigDecimal("0.15"),0,5);

									} else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {

										bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG18_10);
										bgSPCI_FBTG18_10 = bgSPCI_FBSE18_10.divide(new BigDecimal("0.30"),0,5);
									} 
									exTpPRDD_TAXN  = BigDecimal.ZERO;
								} else {

									bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG18_10);
									bgSPCI_FBTG18_10 = BigDecimal.ZERO;
									bgSPCI_FBSE18_10 = BigDecimal.ZERO;
									exTpPRDD_TAXN  = BigDecimal.ZERO;

								}

								bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG18_10);
							} 
						   
							bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE18_10);
							bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG18_10);
							bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE18_10);
									 
						}
						//2019 법정기부금
						if (bgSPCI_FBTG19_10.compareTo(BigDecimal.ZERO) > 0) {
							bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG19_10);

							if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
								bgSPCI_FBSE19_10 = bgSPCI_FBTG19_10.multiply(new BigDecimal("0.15"));
							} else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
								bgSPCI_FBSE19_10 = bgSPCI_FBTG19_10.multiply(new BigDecimal("0.30"));
							}
		                
			                if (exTpPRDD_TAXN.compareTo(bgSPCI_FBSE19_10 ) > 0) {
								exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_FBSE19_10);
							}
							else
							{ 
								if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {

									bgSPCI_FBSE19_10    = exTpPRDD_TAXN;

									if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {

										bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG19_10);
										bgSPCI_FBTG19_10 = bgSPCI_FBSE19_10.divide(new BigDecimal("0.15"),0,5);

									} else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {

										bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG19_10);
										bgSPCI_FBTG19_10 = bgSPCI_FBSE19_10.divide(new BigDecimal("0.30"),0,5);
									} 
									exTpPRDD_TAXN  = BigDecimal.ZERO;
								} else {

									bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG19_10);
									bgSPCI_FBTG19_10 = BigDecimal.ZERO;
									bgSPCI_FBSE19_10 = BigDecimal.ZERO;
									exTpPRDD_TAXN  = BigDecimal.ZERO;

								}

								bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG19_10);
							} 
						   
							bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE19_10);
							bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG19_10);
							bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE19_10);
									 
						}
						
						
						//2020 법정기부금
						if (bgSPCI_FBTG20_10.compareTo(BigDecimal.ZERO) > 0) {
							bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG20_10);

							if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
								bgSPCI_FBSE20_10 = bgSPCI_FBTG20_10.multiply(new BigDecimal("0.15"));
							} else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
								bgSPCI_FBSE20_10 = bgSPCI_FBTG20_10.multiply(new BigDecimal("0.30"));
							}
		                
			                if (exTpPRDD_TAXN.compareTo(bgSPCI_FBSE20_10 ) > 0) {
								exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_FBSE20_10);
							}
							else
							{ 
								if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {

									bgSPCI_FBSE20_10    = exTpPRDD_TAXN;

									if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {

										bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG20_10);
										bgSPCI_FBTG20_10 = bgSPCI_FBSE20_10.divide(new BigDecimal("0.15"),0,5);

									} else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {

										bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG20_10);
										bgSPCI_FBTG20_10 = bgSPCI_FBSE20_10.divide(new BigDecimal("0.30"),0,5);
									} 
									exTpPRDD_TAXN  = BigDecimal.ZERO;
								} else {

									bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG20_10);
									bgSPCI_FBTG20_10 = BigDecimal.ZERO;
									bgSPCI_FBSE20_10 = BigDecimal.ZERO;
									exTpPRDD_TAXN  = BigDecimal.ZERO;

								}

								bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG20_10);
							} 
						   
							bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE20_10);
							bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG20_10);
							bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE20_10);
									 
						}
						
						
						//2021 법정기부금
						if (bgSPCI_FBTG21_10.compareTo(BigDecimal.ZERO) > 0) {
							bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG21_10);

							if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
								bgSPCI_FBSE21_10 = bgSPCI_FBTG21_10.multiply(new BigDecimal("0.15"));
							} else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
								bgSPCI_FBSE21_10 = bgSPCI_FBTG21_10.multiply(new BigDecimal("0.30"));
							}
		                
			                if (exTpPRDD_TAXN.compareTo(bgSPCI_FBSE21_10 ) > 0) {
								exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_FBSE21_10);
							}
							else
							{ 
								if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {

									bgSPCI_FBSE21_10    = exTpPRDD_TAXN;

									if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {

										bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG21_10);
										bgSPCI_FBTG21_10 = bgSPCI_FBSE21_10.divide(new BigDecimal("0.15"),0,5);

									} else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {

										bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG21_10);
										bgSPCI_FBTG21_10 = bgSPCI_FBSE21_10.divide(new BigDecimal("0.30"),0,5);
									} 
									exTpPRDD_TAXN  = BigDecimal.ZERO;
								} else {

									bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_FBTG21_10);
									bgSPCI_FBTG21_10 = BigDecimal.ZERO;
									bgSPCI_FBSE21_10 = BigDecimal.ZERO;
									exTpPRDD_TAXN  = BigDecimal.ZERO;

								}

								bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG21_10);
							} 
						   
							bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE21_10);
							bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG21_10);
							bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE21_10);
									 
						}
		               		               
		              } else {
		            	  
			               //법정기부금 2016
				             bgSPCI_FBTG16_10 = BigDecimal.ZERO;
				             bgSPCI_FBSE16_10 = BigDecimal.ZERO;
				             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10);
				             bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE16_10);
				             bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG16_10);
				             bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE16_10);
			            
			               //법정기부금 2017
				             bgSPCI_FBTG17_10 = BigDecimal.ZERO;
				             bgSPCI_FBSE17_10 = BigDecimal.ZERO;
				             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10);
				             bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE17_10);
				             bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG17_10);
				             bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE17_10);
			                
				           // 법정기부금 2018
			                 bgSPCI_FBTG18_10 = BigDecimal.ZERO;
			                 bgSPCI_FBSE18_10 = BigDecimal.ZERO;
			                 bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG18_10); 
			                 bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE18_10);
			                 bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG18_10);
			                 bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE18_10);
			                  
			              // 법정기부금 2019
			                 bgSPCI_FBTG19_10 = BigDecimal.ZERO;
			                 bgSPCI_FBSE19_10 = BigDecimal.ZERO;
			                 bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG19_10); 
			                 bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE19_10);
			                 bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG19_10);
			                 bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE19_10);
			                 
			              // 법정기부금 2020
			                 bgSPCI_FBTG20_10 = BigDecimal.ZERO;
			                 bgSPCI_FBSE20_10 = BigDecimal.ZERO;
			                 bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG20_10); 
			                 bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE20_10);
			                 bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG20_10);
			                 bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE20_10);
			              
			              // 법정기부금 2021
			                 bgSPCI_FBTG21_10 = BigDecimal.ZERO;
			                 bgSPCI_FBSE21_10 = BigDecimal.ZERO;
			                 bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG21_10); 
			                 bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE21_10);
			                 bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG21_10);
			                 bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE21_10);
			           
		              }  
		              //우리사주조합기부금
		                bgYETA_C147 = BigDecimal.ZERO;
		                bgYETA_C148 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgYETA_C147);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgYETA_C148);
			           
		               //종교단체외 2016
		                bgSPCI_NATG16_40 = BigDecimal.ZERO;
		                bgSPCI_NASE16_40 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE16_40); 
		                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG16_40);
		                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE16_40);
		                 
		              //종교단체외 2017
		                bgSPCI_NATG17_40 = BigDecimal.ZERO;
		                bgSPCI_NASE17_40 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE17_40);
		                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG17_40);
		                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE17_40);
		              
		                //2018 종교단체외 지정기부금
		                bgSPCI_NATG18_40 = BigDecimal.ZERO;
		                bgSPCI_NASE18_40 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG18_40);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE18_40);
		                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG18_40);
		                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE18_40);
		               
		                //2019 종교단체외 지정기부금
		                bgSPCI_NATG19_40 = BigDecimal.ZERO;
		                bgSPCI_NASE19_40 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG19_40);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE19_40);
		                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG19_40);
		                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE19_40);
		                
		              //2020 종교단체외 지정기부금
		                bgSPCI_NATG20_40 = BigDecimal.ZERO;
		                bgSPCI_NASE20_40 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG20_40);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE20_40);
		                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG20_40);
		                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE20_40);
		                
		              //2021 종교단체외 지정기부금
		                bgSPCI_NATG21_40 = BigDecimal.ZERO;
		                bgSPCI_NASE21_40 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG21_40);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE21_40);
		                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG21_40);
		                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE21_40);
		               
		               //종교단체 2016
		                bgSPCI_YATG16_41 = BigDecimal.ZERO;
		                bgSPCI_YASE16_41 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG16_41);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE16_41);
		                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG16_41);
		                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE16_41);
		                   
		                //종교단체 2017
		                bgSPCI_YATG17_41 = BigDecimal.ZERO;
		                bgSPCI_YASE17_41 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE17_41);
		                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG17_41);
		                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE17_41);
		                
		                //2018 종교단체 지정기부금 
		                bgSPCI_YATG18_41 = BigDecimal.ZERO;
		                bgSPCI_YASE18_41 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG18_41);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG18_41);
		                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG18_41);
		                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE18_41);
		                 
		                //2019 종교단체 지정기부금 
		                bgSPCI_YATG19_41 = BigDecimal.ZERO;
		                bgSPCI_YASE19_41 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG19_41);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG19_41);
		                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG19_41);
		                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE19_41);
		                 
		              //2020 종교단체 지정기부금 
		                bgSPCI_YATG20_41 = BigDecimal.ZERO;
		                bgSPCI_YASE20_41 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG20_41);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG20_41);
		                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG20_41);
		                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE20_41);
		                
		              //2021 종교단체 지정기부금 
		                bgSPCI_YATG21_41 = BigDecimal.ZERO;
		                bgSPCI_YASE21_41 = BigDecimal.ZERO;
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG21_41);
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG21_41);
		                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG21_41);
		                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE21_41);
		               
	               } else if ("42".equals(exGubun) ) {
	            	/*********************************************************************
	            	 * 우리사주조합기부금     
	            	 *********************************************************************/
	            	   //누적 데이타 시작 점   
		               bgYetaSumAll = bgYETA_C141.add(bgYETA_C143); //정치자금 기부금  합산
		               bgYetaAllSumSe = bgYETA_C142.add(bgYETA_C144); //정치자금 기부금  합산
		              
		               //법정기부금 2016 
					    bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10); 
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE16_10);
		                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG16_10);
		                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE16_10);
				        
		                //법정기부금 2017
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10); 
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE17_10);
		                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG17_10);
		                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE17_10);
		               
		                //2018 법정기부금
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG18_10); 
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE18_10);
		                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG18_10);
		                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE18_10); 
		              
		                //2019 법정기부금
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG19_10); 
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE19_10);
		                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG19_10);
		                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE19_10); 
		                
		              //2020 법정기부금
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG20_10); 
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE20_10);
		                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG20_10);
		                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE20_10); 
		                
		              //2021 법정기부금
		                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG21_10); 
		                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE21_10);
		                bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG21_10);
		                bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE21_10); 
	              
		                //우리사주조합기부금
			               if (bgYETA_C147.compareTo(BigDecimal.ZERO) > 0) {
				            	
			            	   bgYetaSumAll = bgYetaSumAll.add(bgYETA_C147);
					             
				                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
				                	
				                	bgYETA_C148 = bgYETA_C147.multiply(new BigDecimal("0.15"));
				                	
				                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
				                	
				                	bgYETA_C148 = bgYETA_C147.multiply(new BigDecimal("0.30"));
				                }
				                
				                if (exTpPRDD_TAXN.compareTo(bgYETA_C148 ) > 0) {
				                	 
							           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgYETA_C148);
								     }
								     else
								     { 
								             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
								           
								            	 bgYETA_C148    = exTpPRDD_TAXN;
								            	
							            	  if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
							            		  
							            			bgYetaSumAll = bgYetaSumAll.subtract(bgYETA_C147);
							            			bgYETA_C147 = bgYETA_C148.divide(new BigDecimal("0.15"),0,5);
								                	
								                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
								                	
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
			               
			               //종교단체외 2016
			                bgSPCI_NATG16_40 = BigDecimal.ZERO;
			                bgSPCI_NASE16_40 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE16_40); 
			                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG16_40);
			                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE16_40);
			                 
			              //종교단체외 2017
			                bgSPCI_NATG17_40 = BigDecimal.ZERO;
			                bgSPCI_NASE17_40 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE17_40);
			                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG17_40);
			                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE17_40);
			                
			                //2018  종교단체외 지정기부금
			                bgSPCI_NATG18_40 = BigDecimal.ZERO;
			                bgSPCI_NASE18_40 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG18_40);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE18_40);
			                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG18_40);
			                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE18_40);
			                
			                //2019 종교단체외 지정기부금
			                bgSPCI_NATG19_40 = BigDecimal.ZERO;
			                bgSPCI_NASE19_40 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG19_40);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE19_40);
			                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG19_40);
			                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE19_40);
			                
			                
			              //2020 종교단체외 지정기부금
			                bgSPCI_NATG20_40 = BigDecimal.ZERO;
			                bgSPCI_NASE20_40 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG20_40);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE20_40);
			                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG20_40);
			                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE20_40);
			                
			                
			              //2021 종교단체외 지정기부금
			                bgSPCI_NATG21_40 = BigDecimal.ZERO;
			                bgSPCI_NASE21_40 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG21_40);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE21_40);
			                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG21_40);
			                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE21_40);
			                 
			               //종교단체 2016
			                bgSPCI_YATG16_41 = BigDecimal.ZERO;
			                bgSPCI_YASE16_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG16_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE16_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG16_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE16_41);
			                   
			              //종교단체 2017
			                bgSPCI_YATG17_41 = BigDecimal.ZERO;
			                bgSPCI_YASE17_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE17_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG17_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE17_41);
			                
			                //2018  종교단체 지정기부금 
			                bgSPCI_YATG18_41 = BigDecimal.ZERO;
			                bgSPCI_YASE18_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG18_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG18_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG18_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE18_41);
			                
			                //2019 종교단체 지정기부금 
			                bgSPCI_YATG19_41 = BigDecimal.ZERO;
			                bgSPCI_YASE19_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG19_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG19_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG19_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE19_41);
			                
			                
			              //2020 종교단체 지정기부금 
			                bgSPCI_YATG20_41 = BigDecimal.ZERO;
			                bgSPCI_YASE20_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG20_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG20_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG20_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE20_41);
			                
			                
			              //2021 종교단체 지정기부금 
			                bgSPCI_YATG21_41 = BigDecimal.ZERO;
			                bgSPCI_YASE21_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG21_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG21_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG21_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE21_41);
			                
	            	   
	               } else if ("40".equals(exGubun) ) {
	            	   /*********************************************************************
		            	 * 종교단체외 기부금 
		            	 *********************************************************************/
		            	   //누적 데이타 시작 점   
			               bgYetaSumAll = bgYETA_C141.add(bgYETA_C143); //정치자금 기부금  합산
			               bgYetaAllSumSe = bgYETA_C142.add(bgYETA_C144); //정치자금 기부금  합산
			               
			               //법정기부금 2016
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10); 
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE16_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG16_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE16_10);
			               
			               //법정기부금 2017
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10); 
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE17_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG17_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE17_10); 
			               
			               //2018 법정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG18_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE18_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG18_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE18_10); 
			              
			               //2019 법정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG19_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE19_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG19_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE19_10); 
			               
			             //2020 법정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG20_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE20_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG20_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE20_10); 
			               
			             //2021 법정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG21_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE21_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG21_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE21_10); 

			               //우리사주조합기부금
				           bgYetaSumAll = bgYetaSumAll.add(bgYETA_C147); 
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgYETA_C148); 
				               
						   if ("N".equals(std_ddc_tax)) {         
				               //종교단체외 2016
				               if (bgSPCI_NATG16_40.compareTo(BigDecimal.ZERO) > 0) {
					            	
				            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
						             
					                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
					                	
					                	bgSPCI_NASE16_40 = bgSPCI_NATG16_40.multiply(new BigDecimal("0.15"));
					                	
					                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
					                	
					                	bgSPCI_NASE16_40 = bgSPCI_NATG16_40.multiply(new BigDecimal("0.30"));
					                }
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_NASE16_40 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_NASE16_40);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_NASE16_40    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG16_40);
								            			bgSPCI_NATG16_40 = bgSPCI_NASE16_40.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
									                	
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
				               //종교단체외 2017
				               if (bgSPCI_NATG17_40.compareTo(BigDecimal.ZERO) > 0) {
					            	
				            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
						             
					                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
					                	
					                	bgSPCI_NASE17_40 = bgSPCI_NATG17_40.multiply(new BigDecimal("0.15"));
					                	
					                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
					                	
					                	bgSPCI_NASE17_40 = bgSPCI_NATG17_40.multiply(new BigDecimal("0.3"));
					                }
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_NASE17_40 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_NASE17_40);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_NASE17_40    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG17_40);
								            			bgSPCI_NATG17_40 = bgSPCI_NASE17_40.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG17_40);
									                	bgSPCI_NATG17_40 = bgSPCI_NASE17_40.divide(new BigDecimal("0.3"),0,5);
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
				               
				             //2018 종교단체외 지정기부금
				               if (bgSPCI_NATG18_40.compareTo(BigDecimal.ZERO) > 0) {
					            	
				            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG18_40);
						             
					                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
					                	
					                	bgSPCI_NASE18_40 = bgSPCI_NATG18_40.multiply(new BigDecimal("0.15"));
					                	
					                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
					                	
					                	bgSPCI_NASE18_40 = bgSPCI_NATG18_40.multiply(new BigDecimal("0.30"));
					                }
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_NASE18_40 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_NASE18_40);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_NASE18_40    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG18_40);
								            			bgSPCI_NATG18_40 = bgSPCI_NASE18_40.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG18_40);
									                	bgSPCI_NATG18_40 = bgSPCI_NASE18_40.divide(new BigDecimal("0.30"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG18_40);
									            	 bgSPCI_NATG18_40 = BigDecimal.ZERO;
									            	 bgSPCI_NASE18_40 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG18_40);
									     } 
						              
						               
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE18_40);
						                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG18_40);
						                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE18_40);
						                 
					                
				               }
				               
				             //2019 종교단체외 지정기부금
				               if (bgSPCI_NATG19_40.compareTo(BigDecimal.ZERO) > 0) {
					            	
				            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG19_40);
						             
					                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
					                	
					                	bgSPCI_NASE19_40 = bgSPCI_NATG19_40.multiply(new BigDecimal("0.15"));
					                	
					                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
					                	
					                	bgSPCI_NASE19_40 = bgSPCI_NATG19_40.multiply(new BigDecimal("0.30"));
					                }
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_NASE19_40 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_NASE19_40);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_NASE19_40    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG19_40);
								            			bgSPCI_NATG19_40 = bgSPCI_NASE19_40.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG19_40);
									                	bgSPCI_NATG19_40 = bgSPCI_NASE19_40.divide(new BigDecimal("0.30"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG19_40);
									            	 bgSPCI_NATG19_40 = BigDecimal.ZERO;
									            	 bgSPCI_NASE19_40 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG19_40);
									     } 
						              
						               
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE19_40);
						                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG19_40);
						                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE19_40);
				               }
				               
				               
				             //2020 종교단체외 지정기부금
				               if (bgSPCI_NATG20_40.compareTo(BigDecimal.ZERO) > 0) {
					            	
				            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG20_40);
						             
					                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
					                	
					                	bgSPCI_NASE20_40 = bgSPCI_NATG20_40.multiply(new BigDecimal("0.15"));
					                	
					                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
					                	
					                	bgSPCI_NASE20_40 = bgSPCI_NATG20_40.multiply(new BigDecimal("0.30"));
					                }
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_NASE20_40 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_NASE20_40);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_NASE20_40    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG20_40);
								            			bgSPCI_NATG20_40 = bgSPCI_NASE19_40.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG20_40);
									                	bgSPCI_NATG20_40 = bgSPCI_NASE20_40.divide(new BigDecimal("0.30"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG20_40);
									            	 bgSPCI_NATG20_40 = BigDecimal.ZERO;
									            	 bgSPCI_NASE20_40 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG20_40);
									     } 
						              
						               
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE20_40);
						                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG20_40);
						                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE20_40);
				               }
				               
				               
				               
				             //2021 종교단체외 지정기부금
				               if (bgSPCI_NATG21_40.compareTo(BigDecimal.ZERO) > 0) {
					            	
				            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG21_40);
						             
					                if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
					                	
					                	bgSPCI_NASE21_40 = bgSPCI_NATG21_40.multiply(new BigDecimal("0.15"));
					                	
					                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
					                	
					                	bgSPCI_NASE21_40 = bgSPCI_NATG21_40.multiply(new BigDecimal("0.30"));
					                }
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_NASE21_40 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_NASE21_40);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_NASE21_40    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG21_40);
								            			bgSPCI_NATG21_40 = bgSPCI_NASE21_40.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("10000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG21_40);
									                	bgSPCI_NATG21_40 = bgSPCI_NASE21_40.divide(new BigDecimal("0.30"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_NATG21_40);
									            	 bgSPCI_NATG21_40 = BigDecimal.ZERO;
									            	 bgSPCI_NASE21_40 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG21_40);
									     } 
						              
						               
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE21_40);
						                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG21_40);
						                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE21_40);
				               }
				               
				               
						   } else {
							 
							   	//종교단체외 2016
				                bgSPCI_NATG16_40 = BigDecimal.ZERO;
				                bgSPCI_NASE16_40 = BigDecimal.ZERO;
				                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE16_40); 
				                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG16_40);
				                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE16_40);
				                 
				                //종교단체외 2017
				                bgSPCI_NATG17_40 = BigDecimal.ZERO;
				                bgSPCI_NASE17_40 = BigDecimal.ZERO;
				                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE17_40);
				                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG17_40);
				                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE17_40);
				                
				                //2018 종교단체외 지정기부금
				                bgSPCI_NATG18_40 = BigDecimal.ZERO;
				                bgSPCI_NASE18_40 = BigDecimal.ZERO;
				                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG18_40);
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE18_40);
				                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG18_40);
				                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE18_40);
				                 
				                //2019 종교단체외 지정기부금
				                bgSPCI_NATG19_40 = BigDecimal.ZERO;
				                bgSPCI_NASE19_40 = BigDecimal.ZERO;
				                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG19_40);
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE19_40);
				                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG19_40);
				                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE19_40);
				                
				              //2020종교단체외 지정기부금
				                bgSPCI_NATG20_40 = BigDecimal.ZERO;
				                bgSPCI_NASE20_40 = BigDecimal.ZERO;
				                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG20_40);
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE20_40);
				                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG20_40);
				                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE20_40);
				                
				              //2021 종교단체외 지정기부금
				                bgSPCI_NATG21_40 = BigDecimal.ZERO;
				                bgSPCI_NASE21_40 = BigDecimal.ZERO;
				                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG21_40);
				                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE21_40);
				                bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG21_40);
				                bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE21_40);
						   }  
				            
			               //종교단체 2016
			                bgSPCI_YATG16_41 = BigDecimal.ZERO;
			                bgSPCI_YASE16_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG16_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE16_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG16_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE16_41);
			                   
			                //종교단체 2017
			                bgSPCI_YATG17_41 = BigDecimal.ZERO;
			                bgSPCI_YASE17_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE17_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG17_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE17_41);
			              
			                //2018 종교단체 지정기부금 
			                bgSPCI_YATG18_41 = BigDecimal.ZERO;
			                bgSPCI_YASE18_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG18_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG18_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG18_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE18_41);
			                
			              //2019 종교단체 지정기부금 
			                bgSPCI_YATG19_41 = BigDecimal.ZERO;
			                bgSPCI_YASE19_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG19_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG19_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG19_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE19_41);
			                
			              //2020 종교단체 지정기부금 
			                bgSPCI_YATG20_41 = BigDecimal.ZERO;
			                bgSPCI_YASE20_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG20_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG20_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG20_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE20_41);
			                
			              //2021 종교단체 지정기부금 
			                bgSPCI_YATG21_41 = BigDecimal.ZERO;
			                bgSPCI_YASE21_41 = BigDecimal.ZERO;
			                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG21_41);
			                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG21_41);
			                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG21_41);
			                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE21_41);
			                
			                
			                 
	               } else if ("41".equals(exGubun) ) {
	            	   /*********************************************************************
		            	 * 종교단체 기부금 
		            	 *********************************************************************/
		            	   //누적 데이타 시작 점   
			               bgYetaSumAll = bgYETA_C141.add(bgYETA_C143); //정치자금 기부금  합산
			               bgYetaAllSumSe = bgYETA_C142.add(bgYETA_C144); //정치자금 기부금  합산
			               
			               //법정기부금 2016
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE16_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG16_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE16_10);
			               
			               //법정기부금 2017
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE17_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG17_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE17_10);
			               
			               //2018 법정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG18_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE18_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG18_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE18_10);
						             
			               //2019 법정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG19_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE19_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG19_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE19_10);
			               
			             //2020 법정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG20_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE20_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG20_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE20_10);
			               
			             //2021 법정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG21_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE21_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG21_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE21_10);
						         
						    //우리사주조합기부금
				               
			               bgYetaSumAll = bgYetaSumAll.add(bgYETA_C147);
						   bgYetaAllSumSe =bgYetaAllSumSe.add(bgYETA_C148);
					                
						   //종교단체외 2016
				           bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
						   bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE16_40); 
						   bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG16_40);
						   bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE16_40);
						                
						   //종교단체외 2017						                
						   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
						   bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE17_40);
						   bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG17_40);
						   bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE17_40);
						   
						   //2018 종교단체외 지정기부금
						   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG18_40);
						   bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE18_40);
						   bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG18_40);
						   bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE18_40);
						   
						   //2019 종교단체외 지정기부금
						   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG19_40);
						   bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE19_40);
						   bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG19_40);
						   bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE19_40);
						   
						 //2020 종교단체외 지정기부금
						   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG20_40);
						   bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE20_40);
						   bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG20_40);
						   bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE20_40);
						   
						 //2021 종교단체외 지정기부금
						   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG21_40);
						   bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE21_40);
						   bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG21_40);
						   bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE21_40);
						   
						               
						     if ("N".equals(std_ddc_tax)) {                     
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
				               
				             //종교단체 2017
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
				             //2018 종교단체 지정기부금 
				               if (bgSPCI_YATG18_41.compareTo(BigDecimal.ZERO) > 0) {
					            	
				            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG18_41);
						             
					                if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
					                	
					                	bgSPCI_YASE18_41 = bgSPCI_YATG18_41.multiply(new BigDecimal("0.15"));
					                	
					                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
					                	
					                	bgSPCI_YASE18_41 = bgSPCI_YATG18_41.multiply(new BigDecimal("0.30"));
					                }
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_YASE18_41 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_YASE18_41);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_YASE18_41    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG18_41);
								            			bgSPCI_YATG18_41 = bgSPCI_YASE18_41.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG18_41);
									                	bgSPCI_YATG18_41 = bgSPCI_YASE18_41.divide(new BigDecimal("0.30"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG18_41);
									            	 bgSPCI_YATG18_41 = BigDecimal.ZERO;
									            	 bgSPCI_YASE18_41 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG18_41);
									     }
						               
						               
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG18_41);
						                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG18_41);
						                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE18_41);
						                
				               }
				             //2019 종교단체 지정기부금 
				               if (bgSPCI_YATG19_41.compareTo(BigDecimal.ZERO) > 0) {
					            	
				            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG19_41);
						             
					                if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
					                	
					                	bgSPCI_YASE19_41 = bgSPCI_YATG19_41.multiply(new BigDecimal("0.15"));
					                	
					                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
					                	
					                	bgSPCI_YASE19_41 = bgSPCI_YATG19_41.multiply(new BigDecimal("0.30"));
					                }
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_YASE19_41 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_YASE19_41);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_YASE19_41    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG19_41);
								            			bgSPCI_YATG19_41 = bgSPCI_YASE19_41.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG19_41);
									                	bgSPCI_YATG19_41 = bgSPCI_YASE19_41.divide(new BigDecimal("0.30"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG19_41);
									            	 bgSPCI_YATG19_41 = BigDecimal.ZERO;
									            	 bgSPCI_YASE19_41 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG19_41);
									     }
						               
						               
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG19_41);
						                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG19_41);
						                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE19_41);
						                
				               }
				               
				               
				             //2020 종교단체 지정기부금 
				               if (bgSPCI_YATG20_41.compareTo(BigDecimal.ZERO) > 0) {
					            	
				            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG19_41);
						             
					                if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
					                	
					                	bgSPCI_YASE20_41 = bgSPCI_YATG20_41.multiply(new BigDecimal("0.15"));
					                	
					                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
					                	
					                	bgSPCI_YASE20_41 = bgSPCI_YATG20_41.multiply(new BigDecimal("0.30"));
					                }
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_YASE20_41 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_YASE20_41);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_YASE20_41    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG20_41);
								            			bgSPCI_YATG20_41 = bgSPCI_YASE20_41.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG20_41);
									                	bgSPCI_YATG20_41 = bgSPCI_YASE20_41.divide(new BigDecimal("0.30"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG20_41);
									            	 bgSPCI_YATG20_41 = BigDecimal.ZERO;
									            	 bgSPCI_YASE20_41 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG20_41);
									     }
						               
						               
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG20_41);
						                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG20_41);
						                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE20_41);
						                
				               }
				               
				               
				               
				             //2021 종교단체 지정기부금 
				               if (bgSPCI_YATG21_41.compareTo(BigDecimal.ZERO) > 0) {
					            	
				            	   bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG21_41);
						             
					                if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
					                	
					                	bgSPCI_YASE21_41 = bgSPCI_YATG21_41.multiply(new BigDecimal("0.15"));
					                	
					                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
					                	
					                	bgSPCI_YASE21_41 = bgSPCI_YATG21_41.multiply(new BigDecimal("0.30"));
					                }
					                
					                if (exTpPRDD_TAXN.compareTo(bgSPCI_YASE21_41 ) > 0) {
					                	 
								           exTpPRDD_TAXN = exTpPRDD_TAXN.subtract(bgSPCI_YASE21_41);
									     }
									     else
									     { 
									             if (exTpPRDD_TAXN.compareTo(BigDecimal.ZERO)  > 0)  {
									           
									            	 bgSPCI_YASE21_41    = exTpPRDD_TAXN;
									            	
								            	  if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) <= 0 ) {
								            		  
								            			bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG21_41);
								            			bgSPCI_YATG21_41 = bgSPCI_YASE21_41.divide(new BigDecimal("0.15"),0,5);
									                	
									                } else if (bgYetaSumAll.compareTo(new BigDecimal("20000000")) > 0 )  {
									                	
									                	bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG21_41);
									                	bgSPCI_YATG21_41 = bgSPCI_YASE21_41.divide(new BigDecimal("0.30"),0,5);
									                } 
									                exTpPRDD_TAXN  = BigDecimal.ZERO;
									             }  else {
									            	 
									            	 bgYetaSumAll = bgYetaSumAll.subtract(bgSPCI_YATG21_41);
									            	 bgSPCI_YATG21_41 = BigDecimal.ZERO;
									            	 bgSPCI_YASE21_41 = BigDecimal.ZERO;
									            	 exTpPRDD_TAXN  = BigDecimal.ZERO;
									            	 
									             }
									             
									             bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG21_41);
									     }
						               
						               
						                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG21_41);
						                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG21_41);
						                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE21_41);
						                
				               }
				              				               
						     } else {
						    	  
					               	//종교단체 2016
					                bgSPCI_YATG16_41 = BigDecimal.ZERO;
					                bgSPCI_YASE16_41 = BigDecimal.ZERO;
					                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG16_41);
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE16_41);
					                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG16_41);
					                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE16_41);
					                 
					                //종교단체 2017
					                bgSPCI_YATG17_41 = BigDecimal.ZERO;
					                bgSPCI_YASE17_41 = BigDecimal.ZERO;
					                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41);
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE17_41);
					                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG17_41);
					                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE17_41);
					                
					                //2018 종교단체 지정기부금 
					                bgSPCI_YATG18_41 = BigDecimal.ZERO;
					                bgSPCI_YASE18_41 = BigDecimal.ZERO;
					                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG18_41);
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG18_41);
					                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG18_41);
					                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE18_41);
					                
					                //2019 종교단체 지정기부금 
					                bgSPCI_YATG19_41 = BigDecimal.ZERO;
					                bgSPCI_YASE19_41 = BigDecimal.ZERO;
					                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG19_41);
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG19_41);
					                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG19_41);
					                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE19_41);
					                
					              //2020 종교단체 지정기부금 
					                bgSPCI_YATG20_41 = BigDecimal.ZERO;
					                bgSPCI_YASE20_41 = BigDecimal.ZERO;
					                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG20_41);
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG20_41);
					                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG20_41);
					                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE20_41);
					                
					              //2021 종교단체 지정기부금 
					                bgSPCI_YATG21_41 = BigDecimal.ZERO;
					                bgSPCI_YASE21_41 = BigDecimal.ZERO;
					                bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG21_41);
					                bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG21_41);
					                bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG21_41);
					                bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE21_41);
					                
						     }
				                
	               } else if ("00".equals(exGubun) ) {
	            	   /*********************************************************************
		            	 * 종교단체 기부금 
		            	 *********************************************************************/
		            	   //누적 데이타 시작 점   
			               bgYetaSumAll = bgYETA_C141.add(bgYETA_C143); //정치자금 기부금  합산
			               bgYetaAllSumSe = bgYETA_C142.add(bgYETA_C144); //정치자금 기부금  합산
			                 
			               //법정기부금 2016
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG16_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE16_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG16_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE16_10);
					                
			               //법정기부금 2017
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG17_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE17_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG17_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE17_10);
			              
			               //2018 법정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG18_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE18_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG18_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE18_10);
					       
			               //2019 법정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG19_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE19_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG19_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE19_10);
			               
			             //2020 법정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG20_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE20_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG20_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE20_10);
			               
			             //2021 법정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_FBTG21_10);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_FBSE21_10);
			               bgYETA_C145 = bgYETA_C145.add(bgSPCI_FBTG21_10);
			               bgYETA_C146 = bgYETA_C146.add(bgSPCI_FBSE21_10);
					       
			               //우리사주조합기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgYETA_C147);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgYETA_C148);
					                
				           //종교단체외 2016
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG16_40);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE16_40); 
			               bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG16_40);
			               bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE16_40);
						               
			               //종교단체외 2017
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG17_40);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE17_40);
			               bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG17_40);
			               bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE17_40);
			               
			               //2018 종교단체외 지정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG18_40);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE18_40);
			               bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG18_40);
			               bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE18_40);
						   
			               //2019 종교단체외 지정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG19_40);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE19_40);
			               bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG19_40);
			               bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE19_40);
			               
			             //2020 종교단체외 지정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG20_40);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE20_40);
			               bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG20_40);
			               bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE20_40);
			               
			             //2021 종교단체외 지정기부금
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_NATG21_40);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_NASE21_40);
			               bgYETA_C149 = bgYETA_C149.add(bgSPCI_NATG21_40);
			               bgYETA_C150 = bgYETA_C150.add(bgSPCI_NASE21_40);
						  
			               //종교단체 2016
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG16_41);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE16_41);
			               bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG16_41);
			               bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE16_41);

			               //종교단체 2017
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG17_41); 
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YASE17_41);
			               bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG17_41);
			               bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE17_41);
						   
			               //2018 종교단체 지정기부금 
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG18_41);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG18_41);
			               bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG18_41);
			               bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE18_41);
						   
			               //2019 종교단체 지정기부금 
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG19_41);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG19_41);
			               bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG19_41);
			               bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE19_41);
			               
			             //2020 종교단체 지정기부금 
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG20_41);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG20_41);
			               bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG20_41);
			               bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE20_41);
			               
			             //2021 종교단체 지정기부금 
			               bgYetaSumAll = bgYetaSumAll.add(bgSPCI_YATG21_41);
			               bgYetaAllSumSe =bgYetaAllSumSe.add(bgSPCI_YATG21_41);
			               bgYETA_C150A = bgYETA_C150A.add(bgSPCI_YATG21_41);
			               bgYETA_C150B = bgYETA_C150B.add(bgSPCI_YASE21_41);
						   
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
				
					inputYe169010Vo.setSpciFbtg16(bgSPCI_FBTG16_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbtg16 */
					inputYe169010Vo.setSpciFbtg17(bgSPCI_FBTG17_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbtg17 */ 
					inputYe169010Vo.setSpciFbtg18(bgSPCI_FBTG18_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbtg18 */
					inputYe169010Vo.setSpciFbtg19(bgSPCI_FBTG19_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbtg19 */
					inputYe169010Vo.setSpciFbtg20(bgSPCI_FBTG20_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbtg20 */
					inputYe169010Vo.setSpciFbtg21(bgSPCI_FBTG21_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbtg21 */
					
					inputYe169010Vo.setSpciFbse16(bgSPCI_FBSE16_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbse16 */
					inputYe169010Vo.setSpciFbse17(bgSPCI_FBSE17_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbse17 */
					inputYe169010Vo.setSpciFbse18(bgSPCI_FBSE18_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbse18 */
					inputYe169010Vo.setSpciFbse19(bgSPCI_FBSE19_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbse19 */
					inputYe169010Vo.setSpciFbse20(bgSPCI_FBSE20_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbse20 */
					inputYe169010Vo.setSpciFbse21(bgSPCI_FBSE21_10.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciFbse21 */
					
					inputYe169010Vo.setSpciNatg16(bgSPCI_NATG16_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNatg16 */
					inputYe169010Vo.setSpciNatg17(bgSPCI_NATG17_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNatg17 */ 
					inputYe169010Vo.setSpciNatg18(bgSPCI_NATG18_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNatg18 */
					inputYe169010Vo.setSpciNatg19(bgSPCI_NATG19_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNatg19 */
					inputYe169010Vo.setSpciNatg20(bgSPCI_NATG20_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNatg20 */
					inputYe169010Vo.setSpciNatg21(bgSPCI_NATG21_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNatg21 */
					
					inputYe169010Vo.setSpciNase16(bgSPCI_NASE16_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNase16 */
					inputYe169010Vo.setSpciNase17(bgSPCI_NASE17_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNase17 */
					inputYe169010Vo.setSpciNase18(bgSPCI_NASE18_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNase18 */
					inputYe169010Vo.setSpciNase19(bgSPCI_NASE19_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNase19 */
					inputYe169010Vo.setSpciNase20(bgSPCI_NASE20_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNase20 */
					inputYe169010Vo.setSpciNase21(bgSPCI_NASE21_40.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciNase21 */
					 
					inputYe169010Vo.setSpciYatg16(bgSPCI_YATG16_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYatg16 */
					inputYe169010Vo.setSpciYatg17(bgSPCI_YATG17_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYatg17 */ 
					inputYe169010Vo.setSpciYatg18(bgSPCI_YATG18_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYatg18 */
					inputYe169010Vo.setSpciYatg19(bgSPCI_YATG19_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYatg19 */
					inputYe169010Vo.setSpciYatg20(bgSPCI_YATG20_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYatg20 */
					inputYe169010Vo.setSpciYatg21(bgSPCI_YATG21_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYatg21 */
				
					inputYe169010Vo.setSpciYase16(bgSPCI_YASE16_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYase16 */
					inputYe169010Vo.setSpciYase17(bgSPCI_YASE17_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYase17 */
					inputYe169010Vo.setSpciYase18(bgSPCI_YASE18_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYase18 */
					inputYe169010Vo.setSpciYase19(bgSPCI_YASE18_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYase19 */
					inputYe169010Vo.setSpciYase20(bgSPCI_YASE18_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYase20 */
					inputYe169010Vo.setSpciYase21(bgSPCI_YASE18_41.setScale(0, BigDecimal.ROUND_DOWN));    /** column null : spciYase21 */
					   
					
					statCnt = 0;
			  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_TgIn03_Update( inputYe161080Vo) ;
			  		if (statCnt >= 0) {
			  			
			  			statCnt = 0;
				  		statCnt =  infcPkgYeta7300.fnYeta7300_YE169010_Tax_2022_TgIn04_Update( inputYe169010Vo) ;
			  		}
			  		
			  		//년도별처리로직 다시 호출  
			  		 /**#######################  기부금 정리 이월분 정리 작업 시작   ############################################*/ 	
	  				statCnt = 0;  
	  				Yeta7300Tax2022ContributionCalcPkgProc tax2022ContributionCalcPkgProc = new Yeta7300Tax2022ContributionCalcPkgProc();
	  				bmResult.addAll(tax2022ContributionCalcPkgProc.execTax_2022_Contribution_Calc(request,infcPkgYe161010Vo)); 

	            }
       }   
       
       return rtnBgVal;
       //return bmResult;
   }     
 
}