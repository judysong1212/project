package com.app.smrmf.pkg.yeta.yeta2019.tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161010_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe169010_2019_VO;
import com.app.smrmf.pkg.yeta.yeta2019.tax.service.Yeta4300PayrService;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta4300SubtTaxWkerAmntPkgProc  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta4300SubtTaxWkerAmntPkgProc.class);
	   
    @Resource(name = "Yeta4300PayrService")
    protected Yeta4300PayrService  infcPkgYeta4300;
    
 
    public Yeta4300SubtTaxWkerAmntPkgProc() {
    	
    } 
    
    public List<ShowMessageBM> execSubtTaxWkerAmntPkgProc(HttpServletRequest request,InfcPkgYe161010_2019_VO  infcPkgYe161010Vo)  throws Exception  {
  	    
	  	  return  YetaTaxWkerAmntUpdate(request,  infcPkgYe161010Vo);
	}
     
    
    /**
     * 
     * <pre>
     * 1. 개요  :  근로소득공제 빼기를 통해 차감소득공제까지 구하는 루틴  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : YetaTaxWkerAmntUpdate
     * @date : 2019. 3. 3.
     * @author : atres-pc
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2019. 3. 3.		atres-pc				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param infcPkgYe161010Vo
     * @return
     * @throws Exception
     */
    private  List<ShowMessageBM>  YetaTaxWkerAmntUpdate(HttpServletRequest request,InfcPkgYe161010_2019_VO  infcPkgYe161010Vo) throws Exception {
		 
    	
    	//PagingLoadResult<ShowMessageBM> retval = null; 
     	List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
          
        int statCnt = 0;
      
             
        BigDecimal exWKER_AMNT = BigDecimal.ZERO;   //근로소득금액 
        BigDecimal exTpWKER_AMNT = BigDecimal.ZERO; 
        
        BigDecimal exBASE_SELF = BigDecimal.ZERO;  /*(24) column 기본공제_본인 : BASE_SELF */   
        BigDecimal exBASE_WIFE = BigDecimal.ZERO; /*(25) column 기본공제_배우자 : BASE_WIFE */         
        //BigDecimal exBASE_FMLY = BigDecimal.ZERO; /*(26) column 기본공제_부양가족수 : BASE_FMLY */  
        BigDecimal exBASE_FYAM = BigDecimal.ZERO; /*(26) column 기본공제_부양가족 : BASE_FYAM */     
       // BigDecimal exADDR_CT70 = BigDecimal.ZERO; /*(70) column 추가공제_경로우대_70세이상수 : ADDR_CT70 경로우대공제인원 */       
        BigDecimal exADDR_RPT70 = BigDecimal.ZERO; /*(27) column 추가공제_경로우대70 : ADDR_RPT70 1946.12.31 */   
        //BigDecimal exADDR_HDRC = BigDecimal.ZERO; /*(28) column 추가공제_장애인수 : ADDR_HDRC */    
        BigDecimal exADDR_HDAM = BigDecimal.ZERO; /*(28) column 추가공제_장애인 금액 : ADDR_HDAM */     
        BigDecimal exADDR_FAME = BigDecimal.ZERO; /*(29) column 추가공제_부녀자  금액 : ADDR_FAME */      
        BigDecimal exPANT_ONAM = BigDecimal.ZERO; /*(30) column 추가공제_한부모공제금액 : PANT_ONAM */         
       
        BigDecimal exBNAT_DDCT = BigDecimal.ZERO; // BNAT_DDCT	종근무지_국민연금보험료공제	28		 
        BigDecimal exJNAT_DDCT = BigDecimal.ZERO; // JNAT_DDCT	주근무지_국민연금보험료공제	29		 
        
        BigDecimal exBPSS_HPUL = BigDecimal.ZERO; //BPSS_HPUL	종근무지_국민연금외공무원연금공제	33	
        BigDecimal exJPSS_HPUL = BigDecimal.ZERO; //JPSS_HPUL	주근무지_공무원연금보험료공제	37	
        
        BigDecimal exBPSS_HSOL = BigDecimal.ZERO; // BPSS_HSOL	종근무지_국민연금외군인연금공제	31	 
        BigDecimal exJPSS_HSOL = BigDecimal.ZERO; //JPSS_HSOL	주근무지_국민연금외군인연금공제	35	 
        
        BigDecimal exBPSS_HTEC = BigDecimal.ZERO; // BPSS_HTEC	종근무지_국민연금외교직원연금공제	32	 
        BigDecimal exJPSS_HTEC = BigDecimal.ZERO; //JPSS_HTEC	주근무지_국민연금외교직원연금공제	36	
        
        BigDecimal exBPSS_DDCT = BigDecimal.ZERO; //BPSS_DDCT	종근무지_별정우체국연금보험료공제	30	  
        BigDecimal exJPSS_DDCT = BigDecimal.ZERO; //JPSS_DDCT	주근무지_별정우체국연금보험료공제	34	 
        
        BigDecimal exSPCI_BHTH = BigDecimal.ZERO; //SPCI_BHTH	특별공제_종건강보험료	45	 
        BigDecimal exSPCI_JHTH = BigDecimal.ZERO; // SPCI_JHTH	특별공제_주건강보험료	46		 
        BigDecimal exSPCI_BEPF = BigDecimal.ZERO; //SPCI_BEPF	특별공제_종고용보험료	47	 
        BigDecimal exSPCI_JEPF = BigDecimal.ZERO; // SPCI_JEPF	특별공제_주고용보험료	48	 

        
          // 주택자금(주택임차차입금,장기주택저당차입금,주택마련저축) 관련공통사항 
        BigDecimal exSPCI_REFN = BigDecimal.ZERO;  /*(34)-가 column 특별공제_차입금원리금상환액_대출기관 : SPCI_REFN */   
        BigDecimal exSPCI_RESF = BigDecimal.ZERO;  /*(34)-가 column 특별공제_차입금원리금상환액_거주자 : SPCI_RESF */ 
        BigDecimal exSPCH_RE15 = BigDecimal.ZERO;   /*(34)-나 column 특별공제_11장기주택저당차입금15 : SPCH_RE15 */  
        BigDecimal exSPCH_RE29 = BigDecimal.ZERO;  /*(34)-나 column 특별공제_11장기주택저당차입금29 : SPCH_RE29 */   
        BigDecimal exSPCH_RE30 = BigDecimal.ZERO;  /* (34)-나column 특별공제_11장기주택저당차입금30 : SPCH_RE30 */   
        BigDecimal exSPCI_REFX = BigDecimal.ZERO;  /*(34)-나 column 특별공제_12장기주택저당차입금_고정 : SPCI_REFX */     
        BigDecimal exSPCI_REEC = BigDecimal.ZERO;  /*(34)나 column 특별공제_12장기주택저당차입금_기타 : SPCI_REEC */
        BigDecimal exSPCI_15FX = BigDecimal.ZERO;   /*(34)-나 column 특별공제_15장기주택저당_15고정AND비거치상환 : SPCI_15FX */
        BigDecimal exSPCI_15FB = BigDecimal.ZERO;  /*(34)-나 column 특별공제_15장기주택저당_15고정OR비거치상환 : SPCI_15FB */
        BigDecimal exSPCI_15EC = BigDecimal.ZERO;  /*(34)-나 column 특별공제_15장기주택저당_15기타대출 : SPCI_15EC */
        BigDecimal exSPCI_10FB = BigDecimal.ZERO;  /*(34)-나 column 특별공제_15장기주택저당_10고정OR비거치상환 : SPCI_10FB */
        
        BigDecimal exSPCI_OBAM = BigDecimal.ZERO; // SPCI_OBAM 이월기부금	152		 
        BigDecimal exSPCI_ONON = BigDecimal.ZERO; //SPCI_ONON	이월특례기부금_공익신탁금액	151	 
        BigDecimal exSPCI_ONAM = BigDecimal.ZERO; // SPCI_ONAM	이월종교단체외기부금	154		
        BigDecimal exSPCI_OYAM = BigDecimal.ZERO; // SPCI_OYAM	이월종교단체기부금	153		 
        
  	  infcPkgYeta4300 = (Yeta4300PayrService)BeanFinder.getBean("Yeta4300PayrService"); 
	  	 
		infcPkgYe161010Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
   	infcPkgYe161010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
   	infcPkgYe161010Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
   	infcPkgYe161010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */

       // /*(35) column 이월분  특별공제_기부금공제액계 : SPCI_SSUM */  
       //   /*96  (36)    //특별소득공제 계  */ 
      //    /* (97) column 차감소득금액 : SUBT_ERAM */  
        
          
      	
     	  /****************************************************************************************** 
     	   * 근로소득금액에 따른 단계별 값을 빼는 단계로 처리 로직처리 
  	      *******************************************************************************************/  
  		      InfcPkgYe169010_2019_VO wkInfcPkgYe169010Vo = new InfcPkgYe169010_2019_VO();  //연말정산결과  
  		      InfcPkgYe169010_2019_VO tpWkInfcPkgYe169010Vo = new InfcPkgYe169010_2019_VO();  //연말정산결과  
  		      
  		      
  		    wkInfcPkgYe169010Vo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
  		    wkInfcPkgYe169010Vo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
  		    wkInfcPkgYe169010Vo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
  		    wkInfcPkgYe169010Vo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
  		      
  		    tpWkInfcPkgYe169010Vo = infcPkgYeta4300.fnYeta4300_YE169010_Tax_2019_2001_Select(wkInfcPkgYe169010Vo); 
  		  
  		       
  		      
  		      if (MSFSharedUtils.paramNotNull(tpWkInfcPkgYe169010Vo) && MSFSharedUtils.paramNotNull(tpWkInfcPkgYe169010Vo.getSystemkey())) {
  		     
  		    	  // 차감소득금액 처리 루틴 추가  
  		    	  exWKER_AMNT  = tpWkInfcPkgYe169010Vo.getYeta0c65() ;    //근로소득금액  

  		    	  exTpWKER_AMNT  = exWKER_AMNT;
  		    	 
  		    	   /*(24) column 기본공제_본인 : BASE_SELF */   
  		    	  exBASE_SELF  = tpWkInfcPkgYe169010Vo.getYeta0c66();   
   		          if (exTpWKER_AMNT.compareTo(exBASE_SELF) > 0) {
   		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exBASE_SELF);
   		          }
   		          else
   		          {
   		        	 exBASE_SELF = BigDecimal.ZERO;
   		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
   		            	exBASE_SELF = exTpWKER_AMNT;
   		                exTpWKER_AMNT = BigDecimal.ZERO;
   		             }

   		          } 
   		          
  		         /*(25) column 기본공제_배우자 : BASE_WIFE */   
  		       exBASE_WIFE  = tpWkInfcPkgYe169010Vo.getYeta0c67();       
 		          if (exTpWKER_AMNT.compareTo(exBASE_WIFE) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exBASE_WIFE);
 		          }
 		          else
 		          {
 		        	 exBASE_WIFE = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exBASE_WIFE = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
 		          
  		         //BigDecimal exBASE_FMLY = BigDecimal.ZERO; /*(26) column 기본공제_부양가족수 : BASE_FMLY */  
  		         /*(26) column 기본공제_부양가족 : BASE_FYAM */     
  		          exBASE_FYAM  = tpWkInfcPkgYe169010Vo.getYeta0c69(); 
 		          if (exTpWKER_AMNT.compareTo(exBASE_FYAM) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exBASE_FYAM);
 		          }
 		          else
 		          {
 		        	 exBASE_FYAM = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exBASE_FYAM = exTpWKER_AMNT;
 		                exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
 		          
  		        // BigDecimal exADDR_CT70 = BigDecimal.ZERO; /*(70) column 추가공제_경로우대_70세이상수 : ADDR_CT70 경로우대공제인원 */       
  		         /*(27) column 추가공제_경로우대70 : ADDR_RPT70 1946.12.31 */  
 		         exADDR_RPT70  = tpWkInfcPkgYe169010Vo.getYeta0c71();       
 		          if (exTpWKER_AMNT.compareTo(exADDR_RPT70) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exADDR_RPT70);
 		          }
 		          else
 		          {
 		        	 exADDR_RPT70 = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exADDR_RPT70 = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
 		          
  		         //BigDecimal exADDR_HDRC = BigDecimal.ZERO; /*(28) column 추가공제_장애인수 : ADDR_HDRC */    
  		          /*(28) column 추가공제_장애인 금액 : ADDR_HDAM */  
 		         exADDR_HDAM  = tpWkInfcPkgYe169010Vo.getYeta0c73();       
 		          if (exTpWKER_AMNT.compareTo(exADDR_HDAM) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exADDR_HDAM);
 		          }
 		          else
 		          {
 		        	 exADDR_HDAM = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exADDR_HDAM = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
  		        
 		          /*(29) column 추가공제_부녀자  금액 : ADDR_FAME */   
 		         exADDR_FAME  = tpWkInfcPkgYe169010Vo.getYeta0c74();       
 		          if (exTpWKER_AMNT.compareTo(exADDR_FAME) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exADDR_FAME);
 		          }
 		          else
 		          {
 		        	 exADDR_FAME = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exADDR_FAME = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
 		          
  		          /*(30) column 추가공제_한부모공제금액 : PANT_ONAM */  
 		         exPANT_ONAM  = tpWkInfcPkgYe169010Vo.getYeta0c75();    
 		          if (exTpWKER_AMNT.compareTo(exPANT_ONAM) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exPANT_ONAM);
 		          }
 		          else
 		          {
 		        	 exPANT_ONAM = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exPANT_ONAM = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
  		        
 		          
  		           // JNAT_DDCT	주근무지_국민연금보험료공제	29	 
 		         exJNAT_DDCT  = tpWkInfcPkgYe169010Vo.getYeta0c76();  
 		          if (exTpWKER_AMNT.compareTo(exJNAT_DDCT) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exJNAT_DDCT);
 		          }
 		          else
 		          {
 		        	 exJNAT_DDCT = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exJNAT_DDCT = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
 		          
  		          //JPSS_HPUL	주근무지_공무원연금보험료공제	37	 
 		         exJPSS_HPUL  = tpWkInfcPkgYe169010Vo.getYeta0c77();      
 		          if (exTpWKER_AMNT.compareTo(exJPSS_HPUL) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exJPSS_HPUL);
 		          }
 		          else
 		          {
 		        	 exJPSS_HPUL = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exJPSS_HPUL = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
  		         
 		          
  		          //JPSS_HSOL	주근무지_국민연금외군인연금공제	35	 
 		         exJPSS_HSOL  = tpWkInfcPkgYe169010Vo.getYeta0c78();    
 		          if (exTpWKER_AMNT.compareTo(exJPSS_HSOL) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exJPSS_HSOL);
 		          }
 		          else
 		          {
 		        	 exJPSS_HSOL = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exJPSS_HSOL = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
  		         
 		          //JPSS_HTEC	주근무지_국민연금외교직원연금공제	36 
 		         exJPSS_HTEC  = tpWkInfcPkgYe169010Vo.getYeta0c79();       
 		          if (exTpWKER_AMNT.compareTo(exJPSS_HTEC) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exJPSS_HTEC);
 		          }
 		          else
 		          {
 		        	 exJPSS_HTEC = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exJPSS_HTEC = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
  		         
 		          //JPSS_DDCT	주근무지_별정우체국연금보험료공제	34	 
 		         exJPSS_DDCT  = tpWkInfcPkgYe169010Vo.getYeta0c80();        
 		          if (exTpWKER_AMNT.compareTo(exJPSS_DDCT) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exJPSS_DDCT);
 		          }
 		          else
 		          {
 		        	 exJPSS_DDCT = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exJPSS_DDCT = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
 		          
  		          // SPCI_JHTH	특별공제_주건강보험료	46	
 		         exSPCI_JHTH  = tpWkInfcPkgYe169010Vo.getYeta0c81();         
 		          if (exTpWKER_AMNT.compareTo(exSPCI_JHTH) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exSPCI_JHTH);
 		          }
 		          else
 		          {
 		        	 exSPCI_JHTH = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exSPCI_JHTH = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
 		          
 		          
 		          // SPCI_JEPF	특별공제_주고용보험료	48	
 		         exSPCI_JEPF  = tpWkInfcPkgYe169010Vo.getYeta0c82();        
 		          if (exTpWKER_AMNT.compareTo(exSPCI_JEPF) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exSPCI_JEPF);
 		          }
 		          else
 		          {
 		        	 exSPCI_JEPF = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exSPCI_JEPF = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
 		         exSPCI_REFN  = tpWkInfcPkgYe169010Vo.getYeta0c83();  
 		          if (exTpWKER_AMNT.compareTo(exSPCI_REFN) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exSPCI_REFN);
 		          }
 		          else
 		          {
 		        	 exSPCI_REFN = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exSPCI_REFN = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
 		          
  		          /*(34)-가 column 특별공제_차입금원리금상환액_거주자 : SPCI_RESF */ 
 		         exSPCI_RESF  = tpWkInfcPkgYe169010Vo.getYeta0c84();        
 		          if (exTpWKER_AMNT.compareTo(exSPCI_RESF) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exSPCI_RESF);
 		          }
 		          else
 		          {
 		        	 exSPCI_RESF = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exSPCI_RESF = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
 		          
 		          
  		          /*(34)-나 column 특별공제_11장기주택저당차입금15 : SPCH_RE15 */  
 		         exSPCH_RE15  = tpWkInfcPkgYe169010Vo.getYeta0c85();       
 		          if (exTpWKER_AMNT.compareTo(exSPCH_RE15) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exSPCH_RE15);
 		          }
 		          else
 		          {
 		        	 exSPCH_RE15 = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exSPCH_RE15 = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
  		          /*(34)-나 column 특별공제_11장기주택저당차입금29 : SPCH_RE29 */   

 		         exSPCH_RE29  = tpWkInfcPkgYe169010Vo.getYeta0c86();       
 		          if (exTpWKER_AMNT.compareTo(exSPCH_RE29) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exSPCH_RE29);
 		          }
 		          else
 		          {
 		        	 exSPCH_RE29 = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exSPCH_RE29 = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
 		          
  		           /* (34)-나column 특별공제_11장기주택저당차입금30 : SPCH_RE30 */    
 		         exSPCH_RE30  = tpWkInfcPkgYe169010Vo.getYeta0c87();      
 		          if (exTpWKER_AMNT.compareTo(exSPCH_RE30) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exSPCH_RE30);
 		          }
 		          else
 		          {
 		        	 exSPCH_RE30 = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exSPCH_RE30 = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
  		          
 		          
 		          /*(34)-나 column 특별공제_12장기주택저당차입금_고정 : SPCI_REFX */  
 		         exSPCI_REFX  = tpWkInfcPkgYe169010Vo.getYeta0c88();        
 		          if (exTpWKER_AMNT.compareTo(exSPCI_REFX) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exSPCI_REFX);
 		          }
 		          else
 		          {
 		        	 exSPCI_REFX = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exSPCI_REFX = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
  		         
 		          /*(34)나 column 특별공제_12장기주택저당차입금_기타 : SPCI_REEC */

 		         exSPCI_REEC  = tpWkInfcPkgYe169010Vo.getYeta0c89();      
 		          if (exTpWKER_AMNT.compareTo(exSPCI_REEC) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exSPCI_REEC);
 		          }
 		          else
 		          {
 		        	 exSPCI_REEC = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exSPCI_REEC = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
  		          
 		          
 		          /*(34)-나 column 특별공제_15장기주택저당_15고정AND비거치상환 : SPCI_15FX */
 		         exSPCI_15FX  = tpWkInfcPkgYe169010Vo.getYeta0c90();         
 		          if (exTpWKER_AMNT.compareTo(exSPCI_15FX) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exSPCI_15FX);
 		          }
 		          else
 		          {
 		        	 exSPCI_15FX = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exSPCI_15FX = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
  		          
 		          /*(34)-나 column 특별공제_15장기주택저당_15고정OR비거치상환 : SPCI_15FB */
 		         exSPCI_15FB  = tpWkInfcPkgYe169010Vo.getYeta0c91();       
 		          if (exTpWKER_AMNT.compareTo(exSPCI_15FB) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exSPCI_15FB);
 		          }
 		          else
 		          {
 		        	 exSPCI_15FB = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exSPCI_15FB = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
  		         
 		          /*(34)-나 column 특별공제_15장기주택저당_15기타대출 : SPCI_15EC */
 		         exSPCI_15EC  = tpWkInfcPkgYe169010Vo.getYeta0c92();        
 		          if (exTpWKER_AMNT.compareTo(exSPCI_15EC) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exSPCI_15EC);
 		          }
 		          else
 		          {
 		        	 exSPCI_15EC = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exSPCI_15EC = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
 		          
  		          /*(34)-나 column 특별공제_15장기주택저당_10고정OR비거치상환 : SPCI_10FB */
 		          exSPCI_10FB  = tpWkInfcPkgYe169010Vo.getYeta0c93();      
 		          if (exTpWKER_AMNT.compareTo(exSPCI_10FB) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exSPCI_10FB);
 		          }
 		          else
 		          {
 		        	 exSPCI_10FB = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exSPCI_10FB = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
  		         
  		         // SPCI_OBAM	yeta0c94	152	 
 		         exSPCI_OBAM  = tpWkInfcPkgYe169010Vo.getYeta0c94();    
 		          if (exTpWKER_AMNT.compareTo(exSPCI_OBAM) > 0) {
 		        	exTpWKER_AMNT = exTpWKER_AMNT.subtract(exSPCI_OBAM);
 		          }
 		          else
 		          {
 		        	 exSPCI_OBAM = BigDecimal.ZERO;
 		             if (exTpWKER_AMNT.compareTo(BigDecimal.ZERO) > 0) {
 		            	exSPCI_OBAM = exTpWKER_AMNT;
 		               exTpWKER_AMNT = BigDecimal.ZERO;
 		             }

 		          } 
  		          
      
  		          //   {retax-57}
  					/**#######################      ############################################*/
  		        wkInfcPkgYe169010Vo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
  		     	wkInfcPkgYe169010Vo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
  		      	wkInfcPkgYe169010Vo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
  		    	wkInfcPkgYe169010Vo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
  		     
   

				wkInfcPkgYe169010Vo.setYeta0c66(exBASE_SELF);    /** column C66_기본공제_본인공제금액 : yeta0c66 */
				wkInfcPkgYe169010Vo.setYeta0c67(exBASE_WIFE);    /** column C67_기본공제_배우자공제금액 : yeta0c67 */
				wkInfcPkgYe169010Vo.setYeta0c69(exBASE_FYAM);    /** column C69_기본공제_부양공제금액 : yeta0c69 */
				wkInfcPkgYe169010Vo.setYeta0c71(exADDR_RPT70);    /** column C71_추가공제_경로우대공제금액 : yeta0c71 */
				wkInfcPkgYe169010Vo.setYeta0c73(exADDR_HDAM);    /** column C73_추가공제_장애인공제금액 : yeta0c73 */
				wkInfcPkgYe169010Vo.setYeta0c74(exADDR_FAME);    /** column C74_추가공제_부녀자공제금액 : yeta0c74 */
				wkInfcPkgYe169010Vo.setYeta0c75(exPANT_ONAM);    /** column C75_추가공제_한부모가족공제금액 : yeta0c75 */
				
				wkInfcPkgYe169010Vo.setYeta0c76(exJNAT_DDCT);    /** column C76_연금보험료_국민연금보험료공제금액 : yeta0c76 */
				wkInfcPkgYe169010Vo.setYeta0c77(exJPSS_HPUL);    /** column C77_연금보험료_공적연금보험료공제_공무원연금 : yeta0c77 */
				wkInfcPkgYe169010Vo.setYeta0c78(exJPSS_HSOL);    /** column C78_연금보험료_공적연금보험료공제_군인연금 : yeta0c78 */
				wkInfcPkgYe169010Vo.setYeta0c79(exJPSS_HTEC);    /** column C79_연금보험료_공적연금보험료공제_사립학교교직원연금 : yeta0c79 */
				wkInfcPkgYe169010Vo.setYeta0c80(exJPSS_DDCT);    /** column C80_연금보험료_공적연금보험료공제_별정우체국연금 : yeta0c80 */
				
				
				wkInfcPkgYe169010Vo.setYeta0c81(exSPCI_JHTH);    /** column C81_특별소득공제_보험료_건강보험료 : yeta0c81 */
				wkInfcPkgYe169010Vo.setYeta0c82(exSPCI_JEPF);    /** column C82_특별소득공제_보험료_고용보험료 : yeta0c82 */

				wkInfcPkgYe169010Vo.setYeta0c83(exSPCI_REFN);    /** column C83_특별소득공제_주택자금_추택임차차입금_대출기관 : yeta0c83 */
				wkInfcPkgYe169010Vo.setYeta0c84(exSPCI_RESF);    /** column C84_특별소득공제_주택자금_주택임차차입금_거주자 : yeta0c84 */
				
				wkInfcPkgYe169010Vo.setYeta0c85(exSPCH_RE15);    /** column C85_특별소득공제_주택자금_장기주택저당차입금2011전_15미만 : yeta0c85 */
				wkInfcPkgYe169010Vo.setYeta0c86(exSPCH_RE29);    /** column C86_특별소득공제_주택자금_장기주택저당차입금2011전_15_29 : yeta0c86 */
				wkInfcPkgYe169010Vo.setYeta0c87(exSPCH_RE30);    /** column C87_특별소득공제_주택자금_장기주택저당차입금2011전_30이상 : yeta0c87 */
				
				wkInfcPkgYe169010Vo.setYeta0c88(exSPCI_REFX);    /** column C88_특별소득공제_차입분2012후_15이상_고정금리비거치식상환대출금액 : yeta0c88 */
				wkInfcPkgYe169010Vo.setYeta0c89(exSPCI_REEC);    /** column C89_특별소득공제_차입분2012후_15이상_기타대출금액 : yeta0c89 */
				wkInfcPkgYe169010Vo.setYeta0c90(exSPCI_15FX);    /** column C90_특별소득공제_차입분2015후_상환15이상_고정금리이고비거치상환대출금액 : yeta0c90 */
				wkInfcPkgYe169010Vo.setYeta0c91(exSPCI_15FB);    /** column C91_특별소득공제_차입분2015후_상환15이상_고정금리이거나비거치상환대출금액 : yeta0c91 */
				wkInfcPkgYe169010Vo.setYeta0c92(exSPCI_15EC);    /** column C92_특별소득공제_차입분2015후_상환15이상_그밖의대출금액 : yeta0c92 */
				wkInfcPkgYe169010Vo.setYeta0c93(exSPCI_10FB);    /** column C93_특별소득공제_차입분2015후_상환10이상_고정금리이거나비거치상환대출금액 : yeta0c93 */
				
				wkInfcPkgYe169010Vo.setYeta0c94(exSPCI_OBAM);    /** column C94_특별소득공제_기부금_이월분금액 : yeta0c94 */
	                        
  		        
  		        statCnt = 0;
  			  	statCnt =  infcPkgYeta4300.fnYeta4300_YE169010_Tax_2019_2003_Select(wkInfcPkgYe169010Vo); 
  			  	
  			  	 
 		      }
     	    return bmResult;
      }
    
     
 
}