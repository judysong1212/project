package com.app.smrmf.pkg.yeta.yeta2021.tax;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161020_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe169010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe169010a_2021_VO;
import com.app.smrmf.pkg.yeta.yeta2021.tax.service.Yeta6300PayrService;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta6300SubtTaxEtcIncDdcPkgProc  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta6300SubtTaxEtcIncDdcPkgProc.class);
	   
    @Resource(name = "Yeta6300PayrService")
    protected Yeta6300PayrService  infcPkgYeta6300;
    
 
    public Yeta6300SubtTaxEtcIncDdcPkgProc() {
    	
    } 
    
    public  List<ShowMessageBM> execSubtTaxEtcIncDdcPkgProc(HttpServletRequest request,InfcPkgYe161010_2021_VO  ye161010VO)  throws Exception  {
  	    
	  	  return  YetaSubtCreateUpdate(request,  ye161010VO);
	}
     
     
    
   /**
    * 
    * <pre>
    * 1. 개요 :  그 밖의 소득공제 처리  
    * 2. 처리내용 : 
    * </pre>
    * @Method Name : YetaSubtCreateUpdate
    * @date : Feb 25, 2016
    * @author : leeheuisung
    * @history : 
    *	-----------------------------------------------------------------------
    *	변경일				작성자						변경내용  
    *	----------- ------------------- ---------------------------------------
    *	Feb 25, 2016		leeheuisung				최초 작성 
    *	-----------------------------------------------------------------------
    * 
    * @param infcPkgYe161010Vo
    * @return
    * @throws Exception
    */
    private   List<ShowMessageBM> YetaSubtCreateUpdate(HttpServletRequest request,InfcPkgYe161010_2021_VO  infcPkgYe161010Vo) throws Exception {
		 
    	 
  	    List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();

          if ("TRUE".equals(infcPkgYe161010Vo.getSpciDdctCheck())) {
        	  
        	  bmResult = YetaSubtStdTaxUpdate(request,infcPkgYe161010Vo);
          } else {
        	  
        	  bmResult = YetaSubtBaseTaxUpdate(request,infcPkgYe161010Vo);
          }
  	    
  	    
   	    return bmResult;
    }

    /**
     * 
     * <pre>
     * 1. 개요 : 표준세액공제 금액으로 처리 하는 루틴  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : YetaSubtStdUpdate
     * @date : 2021. 2. 4.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2021. 2. 4.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param infcPkgYe161010Vo
     * @return
     * @throws Exception
     */
    private   List<ShowMessageBM> YetaSubtStdTaxUpdate(HttpServletRequest request,InfcPkgYe161010_2021_VO  infcPkgYe161010Vo) throws Exception {
		 
    	
        PagingLoadResult<ShowMessageBM> retval = null; 
    	  List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();

        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        
        int statCnt = 0;
     	  String dataCheck = "";
     	     
     	  BigDecimal exSUBT_ERAM = BigDecimal.ZERO;
        BigDecimal exTpSUBT_ERAM = BigDecimal.ZERO;
        BigDecimal exETCP_PSNV = BigDecimal.ZERO; 
        BigDecimal exETCH_PREP = BigDecimal.ZERO;
        BigDecimal exETCS_COMP = BigDecimal.ZERO;
        BigDecimal exETWK_SBAM = BigDecimal.ZERO;
        BigDecimal exETWK_SVAM = BigDecimal.ZERO;
            
        BigDecimal exETGD_DDAM = BigDecimal.ZERO;
        BigDecimal exETCC_CARD = BigDecimal.ZERO;
        BigDecimal exETCK_UNON = BigDecimal.ZERO;
        BigDecimal exETCK_UNCR = BigDecimal.ZERO;
        BigDecimal exETEP_MSAM = BigDecimal.ZERO;
        BigDecimal exETGD_HTRA = BigDecimal.ZERO;
        BigDecimal exETEP_SECR = BigDecimal.ZERO;
        
  	  infcPkgYeta6300 = (Yeta6300PayrService)BeanFinder.getBean("Yeta6300PayrService"); 
  	  	 
  		infcPkgYe161010Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
     	infcPkgYe161010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
     	infcPkgYe161010Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
     	infcPkgYe161010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
      	
     	  /******************************************************************************************
  	        차감소득금액에 따른 공제 금액 처리 루틴 추가  따른 세액공제 0처리 및 단계별 빼기 작업을 위한 구현 부
  	      
  	      *******************************************************************************************/  
  		      InfcPkgYe169010a_2021_VO subInfcPkgYe169010aVo = new InfcPkgYe169010a_2021_VO();  //연말정산결과  
  		      InfcPkgYe169010a_2021_VO tpSubInfcPkgYe169010aVo = new InfcPkgYe169010a_2021_VO();  //연말정산결과  
  		      
  		      
  		    subInfcPkgYe169010aVo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
  		      subInfcPkgYe169010aVo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
  		      subInfcPkgYe169010aVo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
  		      subInfcPkgYe169010aVo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
  		      
  		      tpSubInfcPkgYe169010aVo = infcPkgYeta6300.fnYeta6300_YE169010a_Tax_2021_2001_Select(subInfcPkgYe169010aVo); 
  		  
  		       
  		      
  		      if (MSFSharedUtils.paramNotNull(tpSubInfcPkgYe169010aVo) && MSFSharedUtils.paramNotNull(tpSubInfcPkgYe169010aVo.getSystemkey())) {
  		     
  		    	  // 차감소득금액 처리 루틴 추가  
  		    	  exSUBT_ERAM  = tpSubInfcPkgYe169010aVo.getYetaStd0c97() ;    //차감소득금액 

  		          exTpSUBT_ERAM  = exSUBT_ERAM;
  		    	  
  		          exETCP_PSNV  = tpSubInfcPkgYe169010aVo.getYetaStd0c98();        /* (38)column 개인연금저축불입액_2000년이전 : ETCP_PSNV */
  		          if (exTpSUBT_ERAM.compareTo(exETCP_PSNV) > 0) {
  		             exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCP_PSNV);
  		          }
  		          else
  		          {
  		             exETCP_PSNV = BigDecimal.ZERO;
  		             if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
  		                 exETCP_PSNV = exTpSUBT_ERAM;
  		                 exTpSUBT_ERAM = BigDecimal.ZERO;
  		             }

  		          }
  		          exETCH_PREP  = tpSubInfcPkgYe169010aVo.getYetaStd0c99();       /* (39) column 기타공제_소기업공제불입금 : ETCH_PREP */
  		           if (exTpSUBT_ERAM.compareTo(exETCH_PREP) > 0) {
  		             exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCH_PREP);
  		           }
  		           else
  		           {
  		             exETCH_PREP = BigDecimal.ZERO;
  		              if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
  		                 exETCH_PREP = exTpSUBT_ERAM;
  		                 exTpSUBT_ERAM = BigDecimal.ZERO;
  		              }
  		          }
  		          exETCS_COMP   = tpSubInfcPkgYe169010aVo.getYetaStdC100(); /*(40)-가 column 기타공제_주택마련저축_청약저축 : ETCS_COMP */
  		           if (exTpSUBT_ERAM.compareTo(exETCS_COMP) > 0)   {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCS_COMP);
  		           }
  		           else
  		           {
  		              exETCS_COMP = BigDecimal.ZERO;
  		             if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
  		                 exETCS_COMP = exTpSUBT_ERAM;
  		                 exTpSUBT_ERAM = BigDecimal.ZERO;
  		             }
  		           }
  		           
  		          exETWK_SBAM  = tpSubInfcPkgYe169010aVo.getYetaStdC101(); /* (40)-나column 기타공제_주택마련저축_주택청약종합저축 : ETWK_SBAM */
  		        if (exTpSUBT_ERAM.compareTo(exETWK_SBAM) > 0)  {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETWK_SBAM);
  		        }
  		        else
  		        {
  		           exETWK_SBAM = BigDecimal.ZERO;
  		              if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
  		                exETWK_SBAM   = exTpSUBT_ERAM;
  		                exTpSUBT_ERAM = BigDecimal.ZERO;
  		              }
  		        }
  		      
  		          exETWK_SVAM  = tpSubInfcPkgYe169010aVo.getYetaStdC102();    /*(40)-다 column 기타공제_주택마련저축_근로자주택마련저축 : ETWK_SVAM */
  		          if (exTpSUBT_ERAM.compareTo(exETWK_SVAM) > 0)  {   
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETWK_SVAM);
  		          }
  		          else
  		          {
  		            exETWK_SVAM = BigDecimal.ZERO;
  		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
  		                 exETWK_SVAM  = exTpSUBT_ERAM;
  		                 exTpSUBT_ERAM = BigDecimal.ZERO;
  		            }
  		          }
  		          exETGD_DDAM  = tpSubInfcPkgYe169010aVo.getYetaStdC103(); /* (41) column 기타공제_투자조합출자공제액계 : ETGD_DDAM */
  		        if (exTpSUBT_ERAM.compareTo(exETGD_DDAM) > 0)   {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETGD_DDAM);
  		        }
  		        else
  		        {
  		           exETGD_DDAM = BigDecimal.ZERO;
  		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
  		                exETGD_DDAM   = exTpSUBT_ERAM;
  		                exTpSUBT_ERAM = BigDecimal.ZERO;
  		            }
  		        }

  		        exETCC_CARD  = tpSubInfcPkgYe169010aVo.getYetaStdC104() ; /*(42) column 기타공제_신용카드등사용액소득공제 : ETCC_CARD */
  		        if (exTpSUBT_ERAM.compareTo(exETCC_CARD) > 0)      {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCC_CARD);
  		        }
  		        else
  		        {
  		           exETCC_CARD = BigDecimal.ZERO;
  		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
  		                exETCC_CARD   = exTpSUBT_ERAM;
  		                exTpSUBT_ERAM = BigDecimal.ZERO;
  		            }
  		        }

  		            exETCK_UNON  = tpSubInfcPkgYe169010aVo.getYetaStdC105(); /*(43) column 기타공제_우리사주출연금공제 : ETCK_UNON */
  		        if (exTpSUBT_ERAM.compareTo(exETCK_UNON) > 0) {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCK_UNON);
  		        }
  		        else
  		        {
  		           exETCK_UNON = BigDecimal.ZERO;
  		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO)  > 0) {
  		                exETCK_UNON   = exTpSUBT_ERAM;
  		                exTpSUBT_ERAM = BigDecimal.ZERO;
  		            }
  		        } 

  		        exETEP_MSAM  = tpSubInfcPkgYe169010aVo.getYetaStdC107(); /*(45) column 기타공제_고용유지중소기업근로자임금삭감공제액 : ETEP_MSAM */
  		           if (exTpSUBT_ERAM.compareTo(exETEP_MSAM ) > 0) {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETEP_MSAM);
  		           }
  		        else
  		        {
  		           exETEP_MSAM  = BigDecimal.ZERO;
  		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO)  > 0) {
  		               exETEP_MSAM    = exTpSUBT_ERAM;
  		               exTpSUBT_ERAM  = BigDecimal.ZERO;
  		            }
  		        }
  		       
  		          exETGD_HTRA  = tpSubInfcPkgYe169010aVo.getYetaStdC108(); /*(46) column 기타공제_목돈안드는전세이자상환소득공제액 : ETGD_HTRA */
  		        if (exTpSUBT_ERAM.compareTo(exETGD_HTRA ) > 0) {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETGD_HTRA);
  		          }
  		        else
  		        {
  		           exETGD_HTRA  = BigDecimal.ZERO;
  		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO)  > 0)  {
  		              exETGD_HTRA     = exTpSUBT_ERAM;
  		              exTpSUBT_ERAM  = BigDecimal.ZERO;
  		            }
  		        }
  		        
  		          exETEP_SECR  = tpSubInfcPkgYe169010aVo.getYetaStdC109(); /*(47) column 기타공제_장기집합투자증권저축공제액 : ETEP_SECR */
  		          if (exTpSUBT_ERAM.compareTo(exETEP_SECR) > 0)  {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETEP_SECR);
  		          }
  		        else
  		        {
  		           exETEP_SECR  = BigDecimal.ZERO;
  		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO)  > 0) {
  		                exETEP_SECR   = exTpSUBT_ERAM;
  		                exTpSUBT_ERAM  = BigDecimal.ZERO;
  		            }
  		        }
  		       
  		         
  		          //   {retax-57}
  					/**#######################      ############################################*/
  		          subInfcPkgYe169010aVo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
  		          subInfcPkgYe169010aVo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
  		          subInfcPkgYe169010aVo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
  		          subInfcPkgYe169010aVo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
  		     
  		          subInfcPkgYe169010aVo.setYetaStd0c98(exETCP_PSNV);    /** column C98_기타소득공제_개인연금저축소득공제금액 : yeta0c98 */
  		          subInfcPkgYe169010aVo.setYetaStd0c99(exETCH_PREP);    /** column C99_기타소득공제_소기업소상공인공제부금금액 : yeta0c99 */
  		          subInfcPkgYe169010aVo.setYetaStdC100(exETCS_COMP);    /** column C100_기타소득공제_주택마련저축소득공제_청약저축금액 : yetaC100 */
  		          subInfcPkgYe169010aVo.setYetaStdC101(exETWK_SBAM);    /** column C101_기타소득공제_주택마련저축소득공제_주택청약종합저축금액 : yetaC101 */
  		          subInfcPkgYe169010aVo.setYetaStdC102(exETWK_SVAM);    /** column C102_기타소득공제_주택마련저축소득공제_근로자주택마련저축금액 : yetaC102 */
  		          subInfcPkgYe169010aVo.setYetaStdC103(exETGD_DDAM);    /** column C103_기타소득공제_투자조합출자등소득공제금액 : yetaC103 */
  		          subInfcPkgYe169010aVo.setYetaStdC104(exETCC_CARD);    /** column C104_기타소득공제_신용카드등소득공제금액 : yetaC104 */
  		          subInfcPkgYe169010aVo.setYetaStdC105(exETCK_UNON);    /** column C105_기타소득공제_우리사주조합출연금액 : yetaC105 */
  		          subInfcPkgYe169010aVo.setYetaStdC107(exETEP_MSAM);    /** column C107_기타소득공제_고용유지중소기업근로자소득공제금액 : yetaC107 */
  		          subInfcPkgYe169010aVo.setYetaStdC108(exETGD_HTRA);    /** column C108_기타소득공제_목돈안이자상환공제금액 : yetaC108 */
  		          subInfcPkgYe169010aVo.setYetaStdC109(exETEP_SECR);    /** column C109_기타소득공제_장기집합투자증권저축금액 : yetaC109 */
  		        
  		        statCnt = 0;
  			  	statCnt =  infcPkgYeta6300.fnYeta6300_YE169010a_Tax_2021_2002_Update(subInfcPkgYe169010aVo); 
  			  
  			  	InfcPkgYe161020_2021_VO    infcPkgYe161020Vo	 = new InfcPkgYe161020_2021_VO();	//A_인적소득공제기본
  			    BeanUtils.copyProperties(infcPkgYe161020Vo, infcPkgYe161010Vo);
  			    infcPkgYe161020Vo.setC152StdTxDdcYn("Y");
  			    statCnt =  infcPkgYeta6300.fnYeta6300_YE161020_Tax_2021_C152_STD_TX_DDC_YN_Update(infcPkgYe161020Vo); 
  			  	 
  		      }
  		      
     	    return bmResult;
      }
   
    /**
     * 
     * <pre>
     * 1. 개요 : 기본공제 루틴 처리시 여기호출  
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : YetaSubtBaseTaxUpdate
     * @date : 2021. 2. 4.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2021. 2. 4.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param request
     * @param infcPkgYe161010Vo
     * @return
     * @throws Exception
     */
    private   List<ShowMessageBM> YetaSubtBaseTaxUpdate(HttpServletRequest request,InfcPkgYe161010_2021_VO  infcPkgYe161010Vo) throws Exception {
		 
    	
        PagingLoadResult<ShowMessageBM> retval = null; 
    	  List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();

        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
        
        int statCnt = 0;
     	  String dataCheck = "";
     	     
     	  BigDecimal exSUBT_ERAM = BigDecimal.ZERO;
        BigDecimal exTpSUBT_ERAM = BigDecimal.ZERO;
        BigDecimal exETCP_PSNV = BigDecimal.ZERO; 
        BigDecimal exETCH_PREP = BigDecimal.ZERO;
        BigDecimal exETCS_COMP = BigDecimal.ZERO;
        BigDecimal exETWK_SBAM = BigDecimal.ZERO;
        BigDecimal exETWK_SVAM = BigDecimal.ZERO;
            
        BigDecimal exETGD_DDAM = BigDecimal.ZERO;
        BigDecimal exETCC_CARD = BigDecimal.ZERO;
        BigDecimal exETCK_UNON = BigDecimal.ZERO;
        BigDecimal exETCK_UNCR = BigDecimal.ZERO;
        BigDecimal exETEP_MSAM = BigDecimal.ZERO;
        BigDecimal exETGD_HTRA = BigDecimal.ZERO;
        BigDecimal exETEP_SECR = BigDecimal.ZERO;
        
  	  infcPkgYeta6300 = (Yeta6300PayrService)BeanFinder.getBean("Yeta6300PayrService"); 
  	  	 
  		infcPkgYe161010Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
     	infcPkgYe161010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
     	infcPkgYe161010Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
     	infcPkgYe161010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
      	
     	  /******************************************************************************************
  	        차감소득금액에 따른 공제 금액 처리 루틴 추가  따른 세액공제 0처리 및 단계별 빼기 작업을 위한 구현 부
  	      
  	      *******************************************************************************************/  
  		      InfcPkgYe169010_2021_VO subInfcPkgYe169010Vo = new InfcPkgYe169010_2021_VO();  //연말정산결과  
  		      InfcPkgYe169010_2021_VO tpSubInfcPkgYe169010Vo = new InfcPkgYe169010_2021_VO();  //연말정산결과  
  		      
  		      
  		      subInfcPkgYe169010Vo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
  		      subInfcPkgYe169010Vo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
  		      subInfcPkgYe169010Vo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
  		      subInfcPkgYe169010Vo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
  		      
  		      tpSubInfcPkgYe169010Vo = infcPkgYeta6300.fnYeta6300_YE169010_Tax_2021_2001_Select(subInfcPkgYe169010Vo); 
  		  
  		       
  		      
  		      if (MSFSharedUtils.paramNotNull(tpSubInfcPkgYe169010Vo) && MSFSharedUtils.paramNotNull(tpSubInfcPkgYe169010Vo.getSystemkey())) {
  		     
  		    	  // 차감소득금액 처리 루틴 추가  
  		    	  exSUBT_ERAM  = tpSubInfcPkgYe169010Vo.getYeta0c97() ;    //차감소득금액 

  		          exTpSUBT_ERAM  = exSUBT_ERAM;
  		    	  
  		          exETCP_PSNV  = tpSubInfcPkgYe169010Vo.getYeta0c98();        /* (38)column 개인연금저축불입액_2000년이전 : ETCP_PSNV */
  		          if (exTpSUBT_ERAM.compareTo(exETCP_PSNV) > 0) {
  		             exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCP_PSNV);
  		          }
  		          else
  		          {
  		             exETCP_PSNV = BigDecimal.ZERO;
  		             if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
  		                 exETCP_PSNV = exTpSUBT_ERAM;
  		                 exTpSUBT_ERAM = BigDecimal.ZERO;
  		             }

  		          }
  		          exETCH_PREP  = tpSubInfcPkgYe169010Vo.getYeta0c99();       /* (39) column 기타공제_소기업공제불입금 : ETCH_PREP */
  		           if (exTpSUBT_ERAM.compareTo(exETCH_PREP) > 0) {
  		             exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCH_PREP);
  		           }
  		           else
  		           {
  		             exETCH_PREP = BigDecimal.ZERO;
  		              if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
  		                 exETCH_PREP = exTpSUBT_ERAM;
  		                 exTpSUBT_ERAM = BigDecimal.ZERO;
  		              }
  		          }
  		          exETCS_COMP   = tpSubInfcPkgYe169010Vo.getYetaC100(); /*(40)-가 column 기타공제_주택마련저축_청약저축 : ETCS_COMP */
  		           if (exTpSUBT_ERAM.compareTo(exETCS_COMP) > 0)   {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCS_COMP);
  		           }
  		           else
  		           {
  		              exETCS_COMP = BigDecimal.ZERO;
  		             if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
  		                 exETCS_COMP = exTpSUBT_ERAM;
  		                 exTpSUBT_ERAM = BigDecimal.ZERO;
  		             }
  		           }
  		           
  		          exETWK_SBAM  = tpSubInfcPkgYe169010Vo.getYetaC101(); /* (40)-나column 기타공제_주택마련저축_주택청약종합저축 : ETWK_SBAM */
  		        if (exTpSUBT_ERAM.compareTo(exETWK_SBAM) > 0)  {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETWK_SBAM);
  		        }
  		        else
  		        {
  		           exETWK_SBAM = BigDecimal.ZERO;
  		              if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
  		                exETWK_SBAM   = exTpSUBT_ERAM;
  		                exTpSUBT_ERAM = BigDecimal.ZERO;
  		              }
  		        }
  		      
  		          exETWK_SVAM  = tpSubInfcPkgYe169010Vo.getYetaC102();    /*(40)-다 column 기타공제_주택마련저축_근로자주택마련저축 : ETWK_SVAM */
  		          if (exTpSUBT_ERAM.compareTo(exETWK_SVAM) > 0)  {   
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETWK_SVAM);
  		          }
  		          else
  		          {
  		            exETWK_SVAM = BigDecimal.ZERO;
  		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
  		                 exETWK_SVAM  = exTpSUBT_ERAM;
  		                 exTpSUBT_ERAM = BigDecimal.ZERO;
  		            }
  		          }
  		          exETGD_DDAM  = tpSubInfcPkgYe169010Vo.getYetaC103(); /* (41) column 기타공제_투자조합출자공제액계 : ETGD_DDAM */
  		        if (exTpSUBT_ERAM.compareTo(exETGD_DDAM) > 0)   {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETGD_DDAM);
  		        }
  		        else
  		        {
  		           exETGD_DDAM = BigDecimal.ZERO;
  		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
  		                exETGD_DDAM   = exTpSUBT_ERAM;
  		                exTpSUBT_ERAM = BigDecimal.ZERO;
  		            }
  		        }

  		        exETCC_CARD  = tpSubInfcPkgYe169010Vo.getYetaC104() ; /*(42) column 기타공제_신용카드등사용액소득공제 : ETCC_CARD */
  		        if (exTpSUBT_ERAM.compareTo(exETCC_CARD) > 0)      {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCC_CARD);
  		        }
  		        else
  		        {
  		           exETCC_CARD = BigDecimal.ZERO;
  		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO) > 0) {
  		                exETCC_CARD   = exTpSUBT_ERAM;
  		                exTpSUBT_ERAM = BigDecimal.ZERO;
  		            }
  		        }

  		            exETCK_UNON  = tpSubInfcPkgYe169010Vo.getYetaC105(); /*(43) column 기타공제_우리사주출연금공제 : ETCK_UNON */
  		        if (exTpSUBT_ERAM.compareTo(exETCK_UNON) > 0) {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETCK_UNON);
  		        }
  		        else
  		        {
  		           exETCK_UNON = BigDecimal.ZERO;
  		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO)  > 0) {
  		                exETCK_UNON   = exTpSUBT_ERAM;
  		                exTpSUBT_ERAM = BigDecimal.ZERO;
  		            }
  		        } 
  		        exETEP_MSAM  = tpSubInfcPkgYe169010Vo.getYetaC107(); /*(45) column 기타공제_고용유지중소기업근로자임금삭감공제액 : ETEP_MSAM */
  		           if (exTpSUBT_ERAM.compareTo(exETEP_MSAM ) > 0) {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETEP_MSAM);
  		           }
  		        else
  		        {
  		           exETEP_MSAM  = BigDecimal.ZERO;
  		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO)  > 0) {
  		               exETEP_MSAM    = exTpSUBT_ERAM;
  		               exTpSUBT_ERAM  = BigDecimal.ZERO;
  		            }
  		        }
  		       
  		          exETGD_HTRA  = tpSubInfcPkgYe169010Vo.getYetaC108(); /*(46) column 기타공제_목돈안드는전세이자상환소득공제액 : ETGD_HTRA */
  		        if (exTpSUBT_ERAM.compareTo(exETGD_HTRA ) > 0) {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETGD_HTRA);
  		          }
  		        else
  		        {
  		           exETGD_HTRA  = BigDecimal.ZERO;
  		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO)  > 0)  {
  		              exETGD_HTRA     = exTpSUBT_ERAM;
  		              exTpSUBT_ERAM  = BigDecimal.ZERO;
  		            }
  		        }
  		        
  		          exETEP_SECR  = tpSubInfcPkgYe169010Vo.getYetaC109(); /*(47) column 기타공제_장기집합투자증권저축공제액 : ETEP_SECR */
  		          if (exTpSUBT_ERAM.compareTo(exETEP_SECR) > 0)  {
  		           exTpSUBT_ERAM = exTpSUBT_ERAM.subtract(exETEP_SECR);
  		          }
  		        else
  		        {
  		           exETEP_SECR  = BigDecimal.ZERO;
  		            if (exTpSUBT_ERAM.compareTo(BigDecimal.ZERO)  > 0) {
  		                exETEP_SECR   = exTpSUBT_ERAM;
  		                exTpSUBT_ERAM  = BigDecimal.ZERO;
  		            }
  		        }
  		       
  		         
  		          //   {retax-57}
  					/**#######################      ############################################*/
  		          subInfcPkgYe169010Vo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
  		          subInfcPkgYe169010Vo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
  		          subInfcPkgYe169010Vo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
  		          subInfcPkgYe169010Vo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
  		     
  		          subInfcPkgYe169010Vo.setYeta0c98(exETCP_PSNV);    /** column C98_기타소득공제_개인연금저축소득공제금액 : yeta0c98 */
  		          subInfcPkgYe169010Vo.setYeta0c99(exETCH_PREP);    /** column C99_기타소득공제_소기업소상공인공제부금금액 : yeta0c99 */
  		          subInfcPkgYe169010Vo.setYetaC100(exETCS_COMP);    /** column C100_기타소득공제_주택마련저축소득공제_청약저축금액 : yetaC100 */
  		          subInfcPkgYe169010Vo.setYetaC101(exETWK_SBAM);    /** column C101_기타소득공제_주택마련저축소득공제_주택청약종합저축금액 : yetaC101 */
  		          subInfcPkgYe169010Vo.setYetaC102(exETWK_SVAM);    /** column C102_기타소득공제_주택마련저축소득공제_근로자주택마련저축금액 : yetaC102 */
  		          subInfcPkgYe169010Vo.setYetaC103(exETGD_DDAM);    /** column C103_기타소득공제_투자조합출자등소득공제금액 : yetaC103 */
  		          subInfcPkgYe169010Vo.setYetaC104(exETCC_CARD);    /** column C104_기타소득공제_신용카드등소득공제금액 : yetaC104 */
  		          subInfcPkgYe169010Vo.setYetaC105(exETCK_UNON);    /** column C105_기타소득공제_우리사주조합출연금액 : yetaC105 */
  		          subInfcPkgYe169010Vo.setYetaC107(exETEP_MSAM);    /** column C107_기타소득공제_고용유지중소기업근로자소득공제금액 : yetaC107 */
  		          subInfcPkgYe169010Vo.setYetaC108(exETGD_HTRA);    /** column C108_기타소득공제_목돈안이자상환공제금액 : yetaC108 */
  		          subInfcPkgYe169010Vo.setYetaC109(exETEP_SECR);    /** column C109_기타소득공제_장기집합투자증권저축금액 : yetaC109 */
  		          
  		        statCnt = 0;
  			  	statCnt =  infcPkgYeta6300.fnYeta6300_YE169010_Tax_2021_2002_Update(subInfcPkgYe169010Vo); 
  			  	
  			  	
  			  	 
  		      }
     	    return bmResult;
      }
     
 
}