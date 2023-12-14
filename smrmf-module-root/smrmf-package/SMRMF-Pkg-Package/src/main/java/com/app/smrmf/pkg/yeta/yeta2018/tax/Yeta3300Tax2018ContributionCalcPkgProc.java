package com.app.smrmf.pkg.yeta.yeta2018.tax;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165030Srh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165030Temp_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165030_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe166010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe166020_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe169010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe169010a_2018_VO;
import com.app.smrmf.pkg.yeta.yeta2018.tax.service.Yeta3300PayrService;
import com.ext.constants.PropPayGenConfs;
/**
 * 퇴직정산 관련 실제 로직을 처리 하는 부분
 */
@Controller 
public class Yeta3300Tax2018ContributionCalcPkgProc  extends AbstractCustomServiceImpl {
	

	private static final Logger logger = LoggerFactory.getLogger(Yeta3300Tax2018ContributionCalcPkgProc.class);
	   
    @Resource(name = "Yeta3300PayrService")
    protected Yeta3300PayrService  infcPkgYeta3300;
    
 
    public Yeta3300Tax2018ContributionCalcPkgProc() {
    	
    } 
    
    public List<ShowMessageBM> execTax_2018_Contribution_Calc(HttpServletRequest request, InfcPkgYe161010_2018_VO  infcPkgYe161010Vo)  throws Exception  {
  	    
	  	  return  fnTax_2018_Contribution_Calc(request,  infcPkgYe161010Vo);
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
    * @param infcPkgOrgYe165030Vo
    * @return
    * @throws Exception
    */
    private  List<ShowMessageBM> fnTax_2018_Contribution_Calc(HttpServletRequest request, InfcPkgYe161010_2018_VO  infcPkgYe161010Vo) throws Exception {
		  
      //PagingLoadResult<ShowMessageBM> retval = null; 
  	  List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>(); 
  	  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
      
      // 변수선언 
	  	int statCnt = 0;
	  	String dataCheck = "";
	  	
	  	
		InfcPkgYe160401VO    infcPkgYe160401Vo	 = new InfcPkgYe160401VO();	//현근무지급여지급명세
		InfcPkgYe160402VO    infcPkgYe160402Vo	 = new InfcPkgYe160402VO();	//현근무지비과세_감면소득_과세
		InfcPkgYe160403VO    infcPkgYe160403Vo	 = new InfcPkgYe160403VO();	//현근무지비과세_감면소득_비과세
		
		InfcPkgYe160404_2018_VO    infcPkgYe160404Vo	 = new InfcPkgYe160404_2018_VO();	//D_종전근무처
		InfcPkgYe160405_2018_VO    infcPkgYe160405Vo	 = new InfcPkgYe160405_2018_VO();	//D_종전근무처비과세_감면소득_비과세
		InfcPkgYe160406_2018_VO    infcPkgYe160406Vo	 = new InfcPkgYe160406_2018_VO();	//종전근무지연금보험료_공적연금
		InfcPkgYe160510_2018_VO    infcPkgYe160510Vo	 = new InfcPkgYe160510_2018_VO();	//근무지별비과세_감면소득
		
		InfcPkgYe161005_2018_VO    infcPkgYe161005Vo	 = new InfcPkgYe161005_2018_VO();	//A_원천세신고기본
		
		//InfcPkgYe161010VO    infcPkgOrgYe165030Vo	 = new InfcPkgYe161010VO();	// 연말정산대상자기본
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
	//	InfcPkgYe165030VO    infcPkgOrgYe165030Vo	 = new InfcPkgYe165030VO();	//H_기부금조정명세
		InfcPkgYe165030Temp_2018_VO infcPkgYe165030TempVo = new InfcPkgYe165030Temp_2018_VO();  	    //H_기부금조정명세_TEMP	 
		InfcPkgYe166010_2018_VO    infcPkgYe166010Vo	 = new InfcPkgYe166010_2018_VO();	//신용카드등소득공제명세
		InfcPkgYe166020_2018_VO    infcPkgYe166020Vo	 = new InfcPkgYe166020_2018_VO();	//신용카드등소득공제상세
			 								//
		InfcPkgYe169010_2018_VO    infcPkgYe169010Vo	 = new InfcPkgYe169010_2018_VO();	//C_주현근무처
		InfcPkgYe169010a_2018_VO   infcPkgYe169010AVo = new InfcPkgYe169010a_2018_VO();	//C_주현근무처_표준공제 
		
	  BigDecimal  mTemp14Data10 = BigDecimal.ZERO;

      BigDecimal mTemp14Data40 = BigDecimal.ZERO;
      BigDecimal mTemp14Data41 = BigDecimal.ZERO;
      BigDecimal mTempData10  = BigDecimal.ZERO;
      BigDecimal mTempData30  = BigDecimal.ZERO;  
      BigDecimal mTempData31  = BigDecimal.ZERO; 
      BigDecimal mTempData40  = BigDecimal.ZERO; 
      BigDecimal mTempData41  = BigDecimal.ZERO;
      BigDecimal mTempData42  = BigDecimal.ZERO;
      BigDecimal mTempOData10   = BigDecimal.ZERO;
      BigDecimal mTempOData40  = BigDecimal.ZERO; 
      BigDecimal mTempOData41  = BigDecimal.ZERO;
      BigDecimal mTempOData42  = BigDecimal.ZERO;
      BigDecimal mTemp10Data20 =  BigDecimal.ZERO;  //특별세액공제_기부금_정치자금_10만원이하 공제 대상금액
      BigDecimal mTempData20   =  BigDecimal.ZERO;   //특별세액공제_기부금_정치자금_10만원이하 공제
      BigDecimal mTemp10OData20 =  BigDecimal.ZERO;  //특별세액공제_기부금_정치자금_10만원초과  공제 대상금액
      BigDecimal mTempOData20 =  BigDecimal.ZERO;
      		
//      BigDecimal exPRDD_TAXN   = BigDecimal.ZERO;
//      BigDecimal exTAXD_ICAX   = BigDecimal.ZERO;
//      BigDecimal exTAXD_SPCT   = BigDecimal.ZERO;
//      BigDecimal exTXLG_CL30   = BigDecimal.ZERO;
//      BigDecimal exTXLG_HXTT   = BigDecimal.ZERO;
//      BigDecimal exTAXD_TSUM   = BigDecimal.ZERO;
//      BigDecimal exTAXD_WKEN   = BigDecimal.ZERO;
//      BigDecimal exADDR_MCCR   = BigDecimal.ZERO;
//      BigDecimal exJRTR_HICT   = BigDecimal.ZERO;
//      BigDecimal exJRTR_PSRN   = BigDecimal.ZERO;
//      BigDecimal exJRTR_HNSV    = BigDecimal.ZERO;
//      BigDecimal exSPCI_RTDE   = BigDecimal.ZERO;
//      BigDecimal exSPCI_TXCR   = BigDecimal.ZERO;
//      BigDecimal exSPED_TXCR   = BigDecimal.ZERO;
//      BigDecimal exTAXD_PLTC   = BigDecimal.ZERO;
//      BigDecimal exSPCI_PLTC   = BigDecimal.ZERO;
//      BigDecimal exSPCI_FBAM   = BigDecimal.ZERO;
//      BigDecimal  exSPCI_RFAM  = BigDecimal.ZERO;
//      BigDecimal exSPCI_NAMT   = BigDecimal.ZERO;
//      BigDecimal exSPCI_DCTO   = BigDecimal.ZERO;
//      BigDecimal exSPCI_DDCT   = BigDecimal.ZERO;
//      BigDecimal exTAXD_UNIN   = BigDecimal.ZERO;
//      BigDecimal exTAXD_LOAN   = BigDecimal.ZERO;
//      BigDecimal exTAXD_PAID   = BigDecimal.ZERO;
//      BigDecimal exSPCI_RTAM   = BigDecimal.ZERO;                  
//      BigDecimal exTAXD_CSUM   = BigDecimal.ZERO;
//      BigDecimal exTpPRDD_TAXN   = BigDecimal.ZERO;
//      BigDecimal exSPCI_YAMT   = BigDecimal.ZERO;
//      BigDecimal exADDR_CHLD   = BigDecimal.ZERO; 
//      BigDecimal exADDR_BRTH   = BigDecimal.ZERO;
//      BigDecimal exSPCI_GURT   = BigDecimal.ZERO;
//      BigDecimal exSPCI_HDRC   = BigDecimal.ZERO;
      
      BigDecimal bgSPCI_FB16_10    = BigDecimal.ZERO;
      BigDecimal bgSPCI_FB17_10    = BigDecimal.ZERO;
      BigDecimal bgSPCI_FB18_10    = BigDecimal.ZERO;
      BigDecimal bgSPCI_FBTG16_10  = BigDecimal.ZERO;
      BigDecimal bgSPCI_FBTG17_10  = BigDecimal.ZERO;
      BigDecimal bgSPCI_FBTG18_10  = BigDecimal.ZERO;
      BigDecimal bgSPCI_FBSE16_10  = BigDecimal.ZERO;
      BigDecimal bgSPCI_FBSE17_10  = BigDecimal.ZERO;
      BigDecimal bgSPCI_FBSE18_10  = BigDecimal.ZERO;
      BigDecimal bgSPCI_NA16_40    = BigDecimal.ZERO;
      BigDecimal bgSPCI_NA17_40    = BigDecimal.ZERO;
      BigDecimal bgSPCI_NA18_40    = BigDecimal.ZERO;
      BigDecimal bgSPCI_NATG16_40  = BigDecimal.ZERO;
      BigDecimal bgSPCI_NATG17_40  = BigDecimal.ZERO;
      BigDecimal bgSPCI_NATG18_40  = BigDecimal.ZERO;
      BigDecimal bgSPCI_NASE16_40  = BigDecimal.ZERO;
      BigDecimal bgSPCI_NASE17_40  = BigDecimal.ZERO;
      BigDecimal bgSPCI_NASE18_40  = BigDecimal.ZERO;
      BigDecimal bgSPCI_YA16_41    = BigDecimal.ZERO;
      BigDecimal bgSPCI_YA17_41    = BigDecimal.ZERO;
      BigDecimal bgSPCI_YA18_41    = BigDecimal.ZERO;
      BigDecimal bgSPCI_YATG16_41  = BigDecimal.ZERO;
      BigDecimal bgSPCI_YATG17_41  = BigDecimal.ZERO;
      BigDecimal bgSPCI_YATG18_41  = BigDecimal.ZERO;
      BigDecimal bgSPCI_YASE16_41  = BigDecimal.ZERO;
      BigDecimal bgSPCI_YASE17_41  = BigDecimal.ZERO;
      BigDecimal bgSPCI_YASE18_41  = BigDecimal.ZERO;
      
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
      BigDecimal bgYETA_C142 = BigDecimal.ZERO;
      BigDecimal bgYETA_C144 = BigDecimal.ZERO; 
      // 기부금 누적   
      BigDecimal bgYetaSumAll = BigDecimal.ZERO;
      BigDecimal bgYetaAllSumSe = BigDecimal.ZERO;  //세액합계금액 
   
    
	  	  try { 
	  		   
	  		  infcPkgYeta3300 = (Yeta3300PayrService)BeanFinder.getBean("Yeta3300PayrService"); 
	  		  
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
		//	BeanUtils.copyProperties(infcPkgYe165030Vo, infcPkgYe161010Vo);
			BeanUtils.copyProperties(infcPkgYe165030TempVo, infcPkgYe161010Vo);
			BeanUtils.copyProperties(infcPkgYe166010Vo, infcPkgYe161010Vo);
			BeanUtils.copyProperties(infcPkgYe166020Vo, infcPkgYe161010Vo);
			BeanUtils.copyProperties(infcPkgYe169010Vo, infcPkgYe161010Vo);
			BeanUtils.copyProperties(infcPkgYe169010AVo, infcPkgYe161010Vo);
	  		
	  		infcPkgYe161010Vo.setSpciDdctCheck("FALSE");
				        
           
            // {  기부금 이월정산정리 작업 }
            // {2011-추가기능 시작 } 
             /**#######################   기부금 이월정산정리 작업 ############################################*/
             
             List listYetaGibu = infcPkgYeta3300.fnYeta3300_YE169010_Tax_2018_1001_Select(infcPkgYe169010Vo); 
             
             if  (listYetaGibu.size() > 0) {

            	   Iterator<Map<String, Object>> iter = listYetaGibu.iterator(); 
	        	   
		            while ( iter.hasNext() ) { 
		            	
		               Map<String, Object> mapYetaGibu = (Map<String, Object>) iter.next(); 
                      // for(int iCnt = 0; iCnt < listYetaGibu.size();iCnt++) {
		               
		               bgSPCI_FB16_10    = BigDecimal.ZERO;            
		               bgSPCI_FB17_10    = BigDecimal.ZERO;            
		               bgSPCI_FB18_10    = BigDecimal.ZERO;            
		               bgSPCI_FBTG16_10  = BigDecimal.ZERO;            
		               bgSPCI_FBTG17_10  = BigDecimal.ZERO;            
		               bgSPCI_FBTG18_10  = BigDecimal.ZERO;            
		               bgSPCI_FBSE16_10  = BigDecimal.ZERO;            
		               bgSPCI_FBSE17_10  = BigDecimal.ZERO;            
		               bgSPCI_FBSE18_10  = BigDecimal.ZERO;            
		               bgSPCI_NA16_40    = BigDecimal.ZERO;            
		               bgSPCI_NA17_40    = BigDecimal.ZERO;            
		               bgSPCI_NA18_40    = BigDecimal.ZERO;            
		               bgSPCI_NATG16_40  = BigDecimal.ZERO;            
		               bgSPCI_NATG17_40  = BigDecimal.ZERO;            
		               bgSPCI_NATG18_40  = BigDecimal.ZERO;            
		               bgSPCI_NASE16_40  = BigDecimal.ZERO;            
		               bgSPCI_NASE17_40  = BigDecimal.ZERO;            
		               bgSPCI_NASE18_40  = BigDecimal.ZERO;            
		               bgSPCI_YA16_41    = BigDecimal.ZERO;            
		               bgSPCI_YA17_41    = BigDecimal.ZERO;            
		               bgSPCI_YA18_41    = BigDecimal.ZERO;            
		               bgSPCI_YATG16_41  = BigDecimal.ZERO;            
		               bgSPCI_YATG17_41  = BigDecimal.ZERO;            
		               bgSPCI_YATG18_41  = BigDecimal.ZERO;            
		               bgSPCI_YASE16_41  = BigDecimal.ZERO;            
		               bgSPCI_YASE17_41  = BigDecimal.ZERO;              
		               bgSPCI_YASE18_41  = BigDecimal.ZERO;            
		               bgYETA_C141  = BigDecimal.ZERO;                 
		               bgYETA_C143  = BigDecimal.ZERO;                 
		               bgYETA_C147  = BigDecimal.ZERO;                  
		               bgYETA_C148  = BigDecimal.ZERO;                  
		               bgYETA_C146  = BigDecimal.ZERO;                 
		               bgYETA_C150  = BigDecimal.ZERO;                 
		               bgYETA_C150B = BigDecimal.ZERO;                 
		               bgYETA_C145  = BigDecimal.ZERO;                 
		               bgYETA_C149  = BigDecimal.ZERO;                 
		               bgYETA_C150A = BigDecimal.ZERO;   
		               
		               bgYetaSumAll = BigDecimal.ZERO;                 
		               bgYetaAllSumSe = BigDecimal.ZERO;               

		               
		               bgSPCI_FB16_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb1610"),"0"));
		               bgSPCI_FB17_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb1710"),"0"));
		               bgSPCI_FB18_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb1810"),"0"));
		               bgSPCI_FBTG16_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg1610"),"0"));
		               bgSPCI_FBTG17_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg1710"),"0"));
		               bgSPCI_FBTG18_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg1810"),"0"));
		               bgSPCI_FBSE16_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse1610"),"0"));
		               bgSPCI_FBSE17_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse1710"),"0"));
		               bgSPCI_FBSE18_10=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbse1810"),"0"));
		               bgSPCI_NA16_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1640"),"0"));
		               bgSPCI_NA17_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1740"),"0"));
		               bgSPCI_NA18_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1840"),"0"));
		               bgSPCI_NATG16_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg1640"),"0"));
		               bgSPCI_NATG17_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg1740"),"0"));
		               bgSPCI_NATG18_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg1840"),"0"));
		               bgSPCI_NASE16_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase1640"),"0"));
		               bgSPCI_NASE17_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase1740"),"0"));
		               bgSPCI_NASE18_40=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNase1840"),"0"));
		               bgSPCI_YA16_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1641"),"0"));
		               bgSPCI_YA17_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1741"),"0"));
		               bgSPCI_YA18_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1841"),"0"));
		               bgSPCI_YATG16_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg1641"),"0"));
		               bgSPCI_YATG17_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg1741"),"0"));
		               bgSPCI_YATG18_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg1841"),"0"));
		               bgSPCI_YASE16_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase1641"),"0"));
		               bgSPCI_YASE17_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase1741"),"0"));
		               bgSPCI_YASE18_41=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYase1841"),"0"));
		               
		               
		               bgYETA_C141=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC141"),"0"));
		               bgYETA_C143=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC143"),"0"));
		               bgYETA_C147=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC147"),"0"));
		               
		              
		               bgYETA_C142=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC142"),"0"));
		               bgYETA_C144=new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("yetaC144"),"0"));

//                     mTempData10  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFbtg10"),"0"));//oraQrySelect04.FieldByName('SPCI_FBTG_10').AsFloat;
//                     mTemp14Data10  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciFb1410"),"0")); //2014
//                     mTempData30  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciExam30"),"0"));//oraQrySelect04.FieldByName('SPCI_EXAM_30').AsFloat;
//                     mTempData31  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciUnon31"),"0"));//oraQrySelect04.FieldByName('SPCI_UNON_31').AsFloat;
//                     mTempData40  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNatg40"),"0"));//oraQrySelect04.FieldByName('SPCI_NATG_40').AsFloat;
//                     mTempData41  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYatg41"),"0"));//oraQrySelect04.FieldByName('SPCI_YATG_41').AsFloat;
//                     mTemp14Data40  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciNa1440"),"0"));//oraQrySelect04.FieldByName('SPCI_NATG_40').AsFloat;
//                     mTemp14Data41  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciYa1441"),"0"));//oraQrySelect04.FieldByName('SPCI_YATG_41').AsFloat;
//                     mTempData42  = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciHftg42"),"0"));   //우리사주조합기부금 
//                     mTempData42 = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciRfam42"),"0"));//oraQrySelect04.FieldByName('SPCI_YATG_41').AsFloat;
//                     mTempOData10 = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciObam10"),"0"));//oraQrySelect04.FieldByName('SPCI_OBAM_10').AsFloat;
//                     mTempOData40 = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciOnam40"),"0"));//oraQrySelect04.FieldByName('SPCI_ONAM_40').AsFloat;
//                     mTempOData41 = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciOyam41"),"0"));//oraQrySelect04.FieldByName('SPCI_OYAM_41').AsFloat;
//                     //TODO 수정 
//                    // mTempOData42 = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciExam30"),"0"));//oraQrySelect04.FieldByName('SPCI_OYAM_41').AsFloat;
//                    
//                     mTemp10Data20 = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("taxd10tg20"),"0"));  //특별세액공제_기부금_정치자금_10만원이하 공제 대상금액
//                     mTempData20 = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("taxdPltc20"),"0"));  //특별세액공제_기부금_정치자금_10만원이하 공제
//                     mTemp10OData20 = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciPltg20"),"0"));  //특별세액공제_기부금_정치자금_10만원초과  공제 대상금액
//                     mTempOData20 = new BigDecimal(MSFSharedUtils.defaultNulls(mapYetaGibu.get("spciPltc20"),"0"));  //특별세액공제_기부금_정치자금_10만원초과  공제
          
                     
                     /*****************************************************************************************************
                      * 년도별조건으로 가져오는 걸로 변경 해야함 
                      *****************************************************************************************************/
                   
                     InfcPkgYe165030Srh_2018_VO infcPkgYe165030SrhVo =  new InfcPkgYe165030Srh_2018_VO(); 
                     
                     infcPkgYe165030SrhVo.setDpobCd(infcPkgYe161010Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                     infcPkgYe165030SrhVo.setYrtxBlggYr(infcPkgYe161010Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
                     infcPkgYe165030SrhVo.setClutSeptCd(infcPkgYe161010Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
                     infcPkgYe165030SrhVo.setSystemkey(infcPkgYe161010Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                     
                     List listYe165030 = infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_SelectFind(infcPkgYe165030SrhVo);
                     
                     if  (listYe165030.size() > 0) {
                      
                    	/**********************************************************************************************************
                     	 * 정치자금기부금  루틴  시작 
                     	 ***********************************************************************************************************/
                     	 for(int iCnt = 0; iCnt < listYe165030.size();iCnt++) {
                           
                     		 InfcPkgYe165030_2018_VO infcPkgOrgYe165030Vo =  new InfcPkgYe165030_2018_VO();
                     		 InfcPkgYe165030_2018_VO upInfcPkgYe165030Vo =  new InfcPkgYe165030_2018_VO(); 
                     	 
                     		 Map tempMap = (Map)listYe165030.get(iCnt);  

                     		 infcPkgOrgYe165030Vo.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	                 		 infcPkgOrgYe165030Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(tempMap.get("yrtxBlggYr")));    /** column 귀속연도 : yrtxBlggYr */
	                 		 infcPkgOrgYe165030Vo.setClutSeptCd(MSFSharedUtils.allowNulls(tempMap.get("clutSeptCd")));    /** column 연말정산구분코드 : clutSeptCd */
	                 		 infcPkgOrgYe165030Vo.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
	                 		 infcPkgOrgYe165030Vo.setConbSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbSeilNum"),"0")));    /** column 기부금조정일련번호 : conbSeilNum */
	                 		 infcPkgOrgYe165030Vo.setConbCddl(MSFSharedUtils.allowNulls(tempMap.get("conbCddl")));    /** column 기부금유형구분코드 : conbCddl */
	                 		 infcPkgOrgYe165030Vo.setCtrbTycd(MSFSharedUtils.allowNulls(tempMap.get("ctrbTycd")));    /** column 기부금유형신고코드 : ctrbTycd */
	                 		 infcPkgOrgYe165030Vo.setAttrYr(MSFSharedUtils.allowNulls(tempMap.get("attrYr")));    /** column 기부년도 : attrYr */
	                 		 infcPkgOrgYe165030Vo.setUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("useAmt"),"0")));    /** column 기부금액 : useAmt */
	                 		 infcPkgOrgYe165030Vo.setPyrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("pyrDdcAmt"),"0")));    /** column 전년도공제된금액 : pyrDdcAmt */
	                 		 infcPkgOrgYe165030Vo.setDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ddcTrgtAmt"),"0")));    /** column 기부금공제대상금액 : ddcTrgtAmt */
	                 		 infcPkgOrgYe165030Vo.setThcYrDdcAmtNdXps(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrDdcAmtNdXps"),"0")));    /** column 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
	                 		 infcPkgOrgYe165030Vo.setThcYrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrDdcAmt"),"0")));    /** column 해당연도공제금액세액공제금액 : thcYrDdcAmt */
	                 		 infcPkgOrgYe165030Vo.setThcYrNducExtnAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrNducExtnAmt"),"0")));    /** column 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
	                 		 infcPkgOrgYe165030Vo.setThcYrNducCrfwAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrNducCrfwAmt"),"0")));    /** column 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
	                 		 infcPkgOrgYe165030Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
	                 		 infcPkgOrgYe165030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
	                 		 infcPkgOrgYe165030Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
	                 		 infcPkgOrgYe165030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
	                 		 infcPkgOrgYe165030Vo.setSpciDdctCheck(infcPkgYe161010Vo.getSpciDdctCheck());    	 
	                 		

                     		 //infcPkgOrgYe165030Vo = (InfcPkgYe165030VO)listYe165030.get(iCnt); 
                     		 BeanUtils.copyProperties(upInfcPkgYe165030Vo, infcPkgOrgYe165030Vo); 
 	
                           	 if (infcPkgOrgYe165030Vo.getCtrbTycd().equals("20"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '20' then
                                 
                           		 //10만원 이하 여부 판단하여 처리 해야 함 
                           		 
                           		 mTemp10Data20  = infcPkgOrgYe165030Vo.getDdcTrgtAmt().subtract(bgYETA_C141) ;
                              	 
                           		 if (mTemp10Data20.compareTo(BigDecimal.ZERO) <= 0)  { 
                           		 
		                                    // if  (mTemp10Data20.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempData10 >= 0 then
		
                                  	       upInfcPkgYe165030Vo.setThcYrDdcAmt(bgYETA_C141);    /** column 해당연도공제금액 : dyyrDeam */
										   upInfcPkgYe165030Vo.setThcYrNducExtnAmt(BigDecimal.ZERO);    /** column 해당년도_미공제소멸금액 : dyyrOtam */
										   upInfcPkgYe165030Vo.setThcYrNducCrfwAmt(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
										 
		                                    // }
		                                    // else
		                                    // {
		
		                                  	    //   upInfcPkgYe165030Vo.setThcYrDdcAmt(infcPkgYe165030Vo.getDdcTrgtAmt());    /** column 해당연도공제금액 : dyyrDeam */  
												//   upInfcPkgYe165030Vo.setThcYrNducExtnAmt(BigDecimal.ZERO);    /** column 해당년도_미공제소멸금액 : dyyrOtam */
												//   upInfcPkgYe165030Vo.setThcYrNducCrfwAmt(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
												 
		
		                                     //}
		                                    
		                                     upInfcPkgYe165030Vo.setDpobCd(infcPkgOrgYe165030Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
		                                     upInfcPkgYe165030Vo.setYrtxBlggYr(infcPkgOrgYe165030Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
		                                     upInfcPkgYe165030Vo.setClutSeptCd(infcPkgOrgYe165030Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
		                                     upInfcPkgYe165030Vo.setSystemkey(infcPkgOrgYe165030Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
		                                     upInfcPkgYe165030Vo.setConbSeilNum(infcPkgOrgYe165030Vo.getConbSeilNum());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;
		
		
		                                     //upInfcPkgYe165030Vo.setCtrbDdcd(yeta3170Dto.getCtrbDdcd());    /** column 기부조정명세유형구분코드 : ctrbDdcd */
		                                     //upInfcPkgYe165030Vo.setCtrbTycd(yeta3170Dto.getCtrbTycd());    /** column 기부조정명세유형코드 : ctrbTycd */
		                                     //upInfcPkgYe165030Vo.setCtrbYrmn(yeta3170Dto.getAttrYr());    /** column 기부조정명세기부연도 : ctrbYrmn */
		                                     //upInfcPkgYe165030Vo.setCtrbAmnt(yeta3170Dto.getCtrbAmnt());    /** column 기부조정명세기부금액 : ctrbAmnt */
		                                     //upInfcPkgYe165030Vo.setBfyrDeam(yeta3170Dto.getBfyrDeam());    /** column 전년도_공제금액 : bfyrDeam */
		                                     //upInfcPkgYe165030Vo.setDetrAmnt(yeta3170Dto.getDdcTrgtAmt());    /** column 공제대상금액 : detrAmnt */
		                                      
		                                      
		                                     upInfcPkgYe165030Vo.setIsmt(infcPkgYe161010Vo.getIsmt());    /** column 수정자 : ismt */
		                                     upInfcPkgYe165030Vo.setRevnDt(infcPkgYe161010Vo.getRevnDt());    /** column 수정일자 : revnDt */
		                                     upInfcPkgYe165030Vo.setRevnAddr(infcPkgYe161010Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
		                                     
		                                     statCnt = 0;
		                     		  		 statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);  
		                     		  		   
                           		} else {
                           			//10만원 이상 나머지 가지고 구함 
                           			
                           			
                           			
                           			// mTempData = mTemp10OData20;
                           			 mTemp10OData20 = mTemp10Data20.subtract(bgYETA_C143);
                           		   
                           	       if (mTemp10OData20.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempData10 >= 0 then
                          			
                             	       upInfcPkgYe165030Vo.setThcYrDdcAmt(bgYETA_C141.add(bgYETA_C143));    /** column 해당연도공제금액 : dyyrDeam */
									   upInfcPkgYe165030Vo.setThcYrNducExtnAmt(mTemp10OData20);    /** column 해당년도_미공제소멸금액 : dyyrOtam */
									   upInfcPkgYe165030Vo.setThcYrNducCrfwAmt(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
										 
                                  }
                                  else
                                  {

                             	       upInfcPkgYe165030Vo.setThcYrDdcAmt(bgYETA_C141.add(bgYETA_C143));    /** column 해당연도공제금액 : dyyrDeam */  
									   upInfcPkgYe165030Vo.setThcYrNducExtnAmt(BigDecimal.ZERO);    /** column 해당년도_미공제소멸금액 : dyyrOtam */
									   upInfcPkgYe165030Vo.setThcYrNducCrfwAmt(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
									 

                                 }
                               
                                upInfcPkgYe165030Vo.setDpobCd(infcPkgOrgYe165030Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                upInfcPkgYe165030Vo.setYrtxBlggYr(infcPkgOrgYe165030Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
                                upInfcPkgYe165030Vo.setClutSeptCd(infcPkgOrgYe165030Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
                                upInfcPkgYe165030Vo.setSystemkey(infcPkgOrgYe165030Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                upInfcPkgYe165030Vo.setConbSeilNum(infcPkgOrgYe165030Vo.getConbSeilNum());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;
 
                                 upInfcPkgYe165030Vo.setIsmt(infcPkgYe161010Vo.getIsmt());    /** column 수정자 : ismt */
                                 upInfcPkgYe165030Vo.setRevnDt(infcPkgYe161010Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                 upInfcPkgYe165030Vo.setRevnAddr(infcPkgYe161010Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                
                                   statCnt = 0;
                		  		   statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo); 
                           		}
                          	 }
                           	  

                     	 } //  
                     	/**********************************************************************************************************
                      	 * 정치자금기부금 처리 루틴  종료 
                          ***********************************************************************************************************/
                       	/**********************************************************************************************************
                       	 * 법정기부금 처리 루틴  시작 
                       	 ***********************************************************************************************************/
                       	 for(int iCnt = 0; iCnt < listYe165030.size();iCnt++) {
                               //2018
                             //    {retax-43}
                       		 InfcPkgYe165030_2018_VO infcPkgOrgYe165030Vo =  new InfcPkgYe165030_2018_VO();
                       		 InfcPkgYe165030_2018_VO upInfcPkgYe165030Vo =  new InfcPkgYe165030_2018_VO(); 
                       	 
                       		 Map tempMap = (Map)listYe165030.get(iCnt);  

                       		infcPkgOrgYe165030Vo.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                			infcPkgOrgYe165030Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(tempMap.get("yrtxBlggYr")));    /** column 귀속연도 : yrtxBlggYr */
                			infcPkgOrgYe165030Vo.setClutSeptCd(MSFSharedUtils.allowNulls(tempMap.get("clutSeptCd")));    /** column 연말정산구분코드 : clutSeptCd */
                			infcPkgOrgYe165030Vo.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
                			infcPkgOrgYe165030Vo.setConbSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbSeilNum"),"0")));    /** column 기부금조정일련번호 : conbSeilNum */
                			infcPkgOrgYe165030Vo.setConbCddl(MSFSharedUtils.allowNulls(tempMap.get("conbCddl")));    /** column 기부금유형구분코드 : conbCddl */
                			infcPkgOrgYe165030Vo.setCtrbTycd(MSFSharedUtils.allowNulls(tempMap.get("ctrbTycd")));    /** column 기부금유형신고코드 : ctrbTycd */
                			infcPkgOrgYe165030Vo.setAttrYr(MSFSharedUtils.allowNulls(tempMap.get("attrYr")));    /** column 기부년도 : attrYr */
                			infcPkgOrgYe165030Vo.setUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("useAmt"),"0")));    /** column 기부금액 : useAmt */
                			infcPkgOrgYe165030Vo.setPyrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("pyrDdcAmt"),"0")));    /** column 전년도공제된금액 : pyrDdcAmt */
                			infcPkgOrgYe165030Vo.setDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ddcTrgtAmt"),"0")));    /** column 기부금공제대상금액 : ddcTrgtAmt */
                			infcPkgOrgYe165030Vo.setThcYrDdcAmtNdXps(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrDdcAmtNdXps"),"0")));    /** column 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
                			infcPkgOrgYe165030Vo.setThcYrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrDdcAmt"),"0")));    /** column 해당연도공제금액세액공제금액 : thcYrDdcAmt */
                			infcPkgOrgYe165030Vo.setThcYrNducExtnAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrNducExtnAmt"),"0")));    /** column 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
                			infcPkgOrgYe165030Vo.setThcYrNducCrfwAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrNducCrfwAmt"),"0")));    /** column 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
                			infcPkgOrgYe165030Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
                			infcPkgOrgYe165030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
                			infcPkgOrgYe165030Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
                			infcPkgOrgYe165030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
                			 infcPkgOrgYe165030Vo.setSpciDdctCheck(infcPkgYe161010Vo.getSpciDdctCheck());   
 
                       		 //infcPkgOrgYe165030Vo = (InfcPkgYe165030VO)listYe165030.get(iCnt); 
                       		 BeanUtils.copyProperties(upInfcPkgYe165030Vo, infcPkgOrgYe165030Vo); 

                       		  if (infcPkgOrgYe165030Vo.getCtrbTycd().equals("10"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '10' then
                       			 
                       			 	if (infcPkgOrgYe165030Vo.getAttrYr().equals("2018"))  {  // if  oraQrySelect05.FieldByName('CTRB_YRMN').AsString = '2016' then
                            
                       			 			 upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_FBTG18_10 ,bgSPCI_FBSE18_10,BigDecimal.ZERO);
		                                      
		                                      statCnt = 0;
		                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
		                      		  		  if (statCnt >= 0) {  
				                               	        if (infcPkgOrgYe165030Vo.getAttrYr().equals("2016"))  {
				                               	        	
							                               	         upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_FBTG16_10 ,bgSPCI_FBSE16_10,BigDecimal.ZERO);
								                                      
								                                      statCnt = 0;
								                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
								                      		  	      if (statCnt >= 0) { 
								                      		  	    	
								                      		  	    	if (infcPkgOrgYe165030Vo.getAttrYr().equals("2017"))  {
								                      		  	    		 
								                      		  	    	  upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_FBTG17_10 ,bgSPCI_FBTG17_10,BigDecimal.ZERO);
								                      		  	    	 
								                      		  	          statCnt = 0;
									                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
									                      		  	      if (statCnt >= 0) { 
									                      		  	    	  
									                      		  	      }
								                                 	   	}
								                      		  	    	  
								                      		  	      }
				                                  		   
				                                 	   	}  else if (infcPkgOrgYe165030Vo.getAttrYr().equals("2017"))  {
				                                 	   	  upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_FBTG17_10 ,bgSPCI_FBTG17_10,BigDecimal.ZERO);
							                      		  	    	 
						                      		  	          statCnt = 0;
							                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
							                      		  	      if (statCnt >= 0) { 
							                      		  	    	  
							                      		  	      }
				                                 	   	}
		                      		  			  
		                      		  	  	  }

                               	    }  else if (infcPkgOrgYe165030Vo.getAttrYr().equals("2016"))  { 
                      		  				
	                      		  			  upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_FBTG16_10 ,bgSPCI_FBSE16_10,BigDecimal.ZERO);
		                                      
		                                      statCnt = 0;
		                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
		                      		  	    
		                      		  		  if (statCnt >= 0) { 
		                      		  	    	
		                      		  	    	if (infcPkgOrgYe165030Vo.getAttrYr().equals("2017"))  {
		                      		  	    		 
		                      		  	    	  upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_FBTG17_10 ,bgSPCI_FBTG17_10,BigDecimal.ZERO);
		                      		  	    	 
		                      		  	          statCnt = 0;
			                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
			                      		  	      if (statCnt >= 0) { 
			                      		  	    	  
			                      		  	      }
		                                 	   	}
		                      		  	    	  
		                      		  	      }
                    		  		  
                           	   
                               	   	}  else if (infcPkgOrgYe165030Vo.getAttrYr().equals("2017"))  {
                               	   		
			                               	     upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_FBTG17_10 ,bgSPCI_FBTG17_10,BigDecimal.ZERO);
			                		  	    	 
			               		  	              statCnt = 0;
			                     		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
			                     		  	      if (statCnt >= 0) { 
			                     		  	    	  
			                     		  	      }
                               	   	}  //년도   
                               }      //if (infcPkgOrgYe165030Vo.getCtrbTycd().equals("10"))  {

                       	 } // 법정기부금 처리 루틴 
                       	/**********************************************************************************************************
                        	 * 법정기부금 처리 루틴  종료 
                        ***********************************************************************************************************/
                       	/**********************************************************************************************************
                        	 * 우리사주조합기부금  루틴  시작 
                        	 ***********************************************************************************************************/
                        	 for(int iCnt = 0; iCnt < listYe165030.size();iCnt++) {
                              
                        		 InfcPkgYe165030_2018_VO infcPkgOrgYe165030Vo =  new InfcPkgYe165030_2018_VO();
                        		 InfcPkgYe165030_2018_VO upInfcPkgYe165030Vo =  new InfcPkgYe165030_2018_VO(); 
                        	 
                        		 Map tempMap = (Map)listYe165030.get(iCnt);  

                        		infcPkgOrgYe165030Vo.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	                 			infcPkgOrgYe165030Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(tempMap.get("yrtxBlggYr")));    /** column 귀속연도 : yrtxBlggYr */
	                 			infcPkgOrgYe165030Vo.setClutSeptCd(MSFSharedUtils.allowNulls(tempMap.get("clutSeptCd")));    /** column 연말정산구분코드 : clutSeptCd */
	                 			infcPkgOrgYe165030Vo.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
	                 			infcPkgOrgYe165030Vo.setConbSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbSeilNum"),"0")));    /** column 기부금조정일련번호 : conbSeilNum */
	                 			infcPkgOrgYe165030Vo.setConbCddl(MSFSharedUtils.allowNulls(tempMap.get("conbCddl")));    /** column 기부금유형구분코드 : conbCddl */
	                 			infcPkgOrgYe165030Vo.setCtrbTycd(MSFSharedUtils.allowNulls(tempMap.get("ctrbTycd")));    /** column 기부금유형신고코드 : ctrbTycd */
	                 			infcPkgOrgYe165030Vo.setAttrYr(MSFSharedUtils.allowNulls(tempMap.get("attrYr")));    /** column 기부년도 : attrYr */
	                 			infcPkgOrgYe165030Vo.setUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("useAmt"),"0")));    /** column 기부금액 : useAmt */
	                 			infcPkgOrgYe165030Vo.setPyrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("pyrDdcAmt"),"0")));    /** column 전년도공제된금액 : pyrDdcAmt */
	                 			infcPkgOrgYe165030Vo.setDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ddcTrgtAmt"),"0")));    /** column 기부금공제대상금액 : ddcTrgtAmt */
	                 			infcPkgOrgYe165030Vo.setThcYrDdcAmtNdXps(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrDdcAmtNdXps"),"0")));    /** column 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
	                 			infcPkgOrgYe165030Vo.setThcYrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrDdcAmt"),"0")));    /** column 해당연도공제금액세액공제금액 : thcYrDdcAmt */
	                 			infcPkgOrgYe165030Vo.setThcYrNducExtnAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrNducExtnAmt"),"0")));    /** column 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
	                 			infcPkgOrgYe165030Vo.setThcYrNducCrfwAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrNducCrfwAmt"),"0")));    /** column 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
	                 			infcPkgOrgYe165030Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
	                 			infcPkgOrgYe165030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
	                 			infcPkgOrgYe165030Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
	                 			infcPkgOrgYe165030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
	                 			 infcPkgOrgYe165030Vo.setSpciDdctCheck(infcPkgYe161010Vo.getSpciDdctCheck());   
  
                        		 //infcPkgOrgYe165030Vo = (InfcPkgYe165030VO)listYe165030.get(iCnt); 
                        		 BeanUtils.copyProperties(upInfcPkgYe165030Vo, infcPkgOrgYe165030Vo); 

                              	if (infcPkgOrgYe165030Vo.getCtrbTycd().equals("42"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '10' then
                              		 
                                    mTempData42  = infcPkgOrgYe165030Vo.getDdcTrgtAmt().subtract(bgYETA_C147) ;
                                 		   
                                 	 
                                    if  (mTempData42.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempData10 >= 0 then

                                 	      upInfcPkgYe165030Vo.setThcYrDdcAmt(bgYETA_C147);    /** column 해당연도공제금액 : dyyrDeam */
        								  upInfcPkgYe165030Vo.setThcYrNducExtnAmt(mTempData42);    /** column 해당년도_미공제소멸금액 : dyyrOtam */
        								  upInfcPkgYe165030Vo.setThcYrNducCrfwAmt(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
        										  

                                    }
                                    else
                                    {

                                 	      upInfcPkgYe165030Vo.setThcYrDdcAmt(bgYETA_C147);    /** column 해당연도공제금액 : dyyrDeam */  
        								  upInfcPkgYe165030Vo.setThcYrNducExtnAmt(BigDecimal.ZERO);    /** column 해당년도_미공제소멸금액 : dyyrOtam */
        								  upInfcPkgYe165030Vo.setThcYrNducCrfwAmt(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
        									 

                                    }
                                   
                                    upInfcPkgYe165030Vo.setDpobCd(infcPkgOrgYe165030Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                    upInfcPkgYe165030Vo.setYrtxBlggYr(infcPkgOrgYe165030Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
                                    upInfcPkgYe165030Vo.setClutSeptCd(infcPkgOrgYe165030Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
                                    upInfcPkgYe165030Vo.setSystemkey(infcPkgOrgYe165030Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
                                    upInfcPkgYe165030Vo.setConbSeilNum(infcPkgOrgYe165030Vo.getConbSeilNum());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;

 
                                     
                                    upInfcPkgYe165030Vo.setIsmt(infcPkgYe161010Vo.getIsmt());    /** column 수정자 : ismt */
                                    upInfcPkgYe165030Vo.setRevnDt(infcPkgYe161010Vo.getRevnDt());    /** column 수정일자 : revnDt */
                                    upInfcPkgYe165030Vo.setRevnAddr(infcPkgYe161010Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
                                    
                                     statCnt = 0;
                    		  		 statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);  

                             	 }

                        	 } //  
                        	/**********************************************************************************************************
                         	 * 우리사주조합기부금 처리 루틴  종료 
                             ***********************************************************************************************************/
                           	  
                        	 	/**********************************************************************************************************
                            	 * 종교단체외 처리 루틴  시작 
                            	 ***********************************************************************************************************/
                            	 for(int iCnt = 0; iCnt < listYe165030.size();iCnt++) {
                                  
                            		 InfcPkgYe165030_2018_VO infcPkgOrgYe165030Vo =  new InfcPkgYe165030_2018_VO();
                            		 InfcPkgYe165030_2018_VO upInfcPkgYe165030Vo =  new InfcPkgYe165030_2018_VO(); 
                            	 
                            		 Map tempMap = (Map)listYe165030.get(iCnt);  

                            		infcPkgOrgYe165030Vo.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                     			infcPkgOrgYe165030Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(tempMap.get("yrtxBlggYr")));    /** column 귀속연도 : yrtxBlggYr */
                     			infcPkgOrgYe165030Vo.setClutSeptCd(MSFSharedUtils.allowNulls(tempMap.get("clutSeptCd")));    /** column 연말정산구분코드 : clutSeptCd */
                     			infcPkgOrgYe165030Vo.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
                     			infcPkgOrgYe165030Vo.setConbSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbSeilNum"),"0")));    /** column 기부금조정일련번호 : conbSeilNum */
                     			infcPkgOrgYe165030Vo.setConbCddl(MSFSharedUtils.allowNulls(tempMap.get("conbCddl")));    /** column 기부금유형구분코드 : conbCddl */
                     			infcPkgOrgYe165030Vo.setCtrbTycd(MSFSharedUtils.allowNulls(tempMap.get("ctrbTycd")));    /** column 기부금유형신고코드 : ctrbTycd */
                     			infcPkgOrgYe165030Vo.setAttrYr(MSFSharedUtils.allowNulls(tempMap.get("attrYr")));    /** column 기부년도 : attrYr */
                     			infcPkgOrgYe165030Vo.setUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("useAmt"),"0")));    /** column 기부금액 : useAmt */
                     			infcPkgOrgYe165030Vo.setPyrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("pyrDdcAmt"),"0")));    /** column 전년도공제된금액 : pyrDdcAmt */
                     			infcPkgOrgYe165030Vo.setDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ddcTrgtAmt"),"0")));    /** column 기부금공제대상금액 : ddcTrgtAmt */
                     			infcPkgOrgYe165030Vo.setThcYrDdcAmtNdXps(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrDdcAmtNdXps"),"0")));    /** column 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
                     			infcPkgOrgYe165030Vo.setThcYrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrDdcAmt"),"0")));    /** column 해당연도공제금액세액공제금액 : thcYrDdcAmt */
                     			infcPkgOrgYe165030Vo.setThcYrNducExtnAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrNducExtnAmt"),"0")));    /** column 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
                     			infcPkgOrgYe165030Vo.setThcYrNducCrfwAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrNducCrfwAmt"),"0")));    /** column 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
                     			infcPkgOrgYe165030Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
                     			infcPkgOrgYe165030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
                     			infcPkgOrgYe165030Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
                     			infcPkgOrgYe165030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
                     			 infcPkgOrgYe165030Vo.setSpciDdctCheck(infcPkgYe161010Vo.getSpciDdctCheck());   
      
                            		 //infcPkgOrgYe165030Vo = (InfcPkgYe165030VO)listYe165030.get(iCnt); 
                            		 BeanUtils.copyProperties(upInfcPkgYe165030Vo, infcPkgOrgYe165030Vo); 

                            		  if (infcPkgOrgYe165030Vo.getCtrbTycd().equals("40"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '10' then
                            			 
                            			 	if (infcPkgOrgYe165030Vo.getAttrYr().equals("2018"))  {  // if  oraQrySelect05.FieldByName('CTRB_YRMN').AsString = '2016' then
                                 
                            			 			 upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_NATG18_40 ,bgSPCI_NASE18_40,BigDecimal.ZERO);
     		                                      
     		                                      statCnt = 0;
     		                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
     		                      		  		  if (statCnt >= 0) {  
     				                               	        if (infcPkgOrgYe165030Vo.getAttrYr().equals("2016"))  {
     				                               	        	
     							                               	         upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_NATG16_40 ,bgSPCI_NASE16_40,BigDecimal.ZERO);
     								                                      
     								                                      statCnt = 0;
     								                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
     								                      		  	      if (statCnt >= 0) { 
     								                      		  	    	
     								                      		  	    	if (infcPkgOrgYe165030Vo.getAttrYr().equals("2017"))  {
     								                      		  	    		 
     								                      		  	    	  upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_NATG17_40 ,bgSPCI_NASE17_40,BigDecimal.ZERO);
     								                      		  	    	 
     								                      		  	          statCnt = 0;
     									                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
     									                      		  	      if (statCnt >= 0) { 
     									                      		  	    	  
     									                      		  	      }
     								                                 	   	}
     								                      		  	    	  
     								                      		  	      }
     				                                  		   
     				                                 	   	}  else if (infcPkgOrgYe165030Vo.getAttrYr().equals("2017"))  {
     				                                 	   	  upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_NATG17_40 ,bgSPCI_NASE17_40,BigDecimal.ZERO);
     							                      		  	    	 
     						                      		  	          statCnt = 0;
     							                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
     							                      		  	      if (statCnt >= 0) { 
     							                      		  	    	  
     							                      		  	      }
     				                                 	   	}
     		                      		  			  
     		                      		  	  	  }
                            			 		
                                    	    }  else if (infcPkgOrgYe165030Vo.getAttrYr().equals("2016"))  { 
                           		  				
     	                      		  			  upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_NATG16_40 ,bgSPCI_NASE16_40,BigDecimal.ZERO);
     		                                      
     		                                      statCnt = 0;
     		                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
     		                      		  	    
     		                      		  		  if (statCnt >= 0) { 
     		                      		  	    	
     		                      		  	    	if (infcPkgOrgYe165030Vo.getAttrYr().equals("2017"))  {
     		                      		  	    		 
     		                      		  	    	  upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_NATG17_40 ,bgSPCI_NASE17_40,BigDecimal.ZERO);
     		                      		  	    	 
     		                      		  	          statCnt = 0;
     			                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
     			                      		  	      if (statCnt >= 0) { 
     			                      		  	    	  
     			                      		  	      }
     		                                 	   	}
     		                      		  	    	  
     		                      		  	      }
                         		  		  
                                	   
                                    	   	}  else if (infcPkgOrgYe165030Vo.getAttrYr().equals("2017"))  {
                                    	   		
     			                               	     upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_NATG17_40 ,bgSPCI_NASE17_40,BigDecimal.ZERO);
     			                		  	    	 
     			               		  	              statCnt = 0;
     			                     		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
     			                     		  	      if (statCnt >= 0) { 
     			                     		  	    	  
     			                     		  	      }
                                    	   	}  //년도   
                                    }      //if (infcPkgOrgYe165030Vo.getCtrbTycd().equals("10"))  {

                            	 } 
                            	/**********************************************************************************************************
                             	 * 종교단체외 처리 루틴  종료 
                             ***********************************************************************************************************/
                            	 
                            		/**********************************************************************************************************
                             	 * 종교단체 처리 루틴  시작 
                             	 ***********************************************************************************************************/
                             	 for(int iCnt = 0; iCnt < listYe165030.size();iCnt++) {
                                   
                             		 InfcPkgYe165030_2018_VO infcPkgOrgYe165030Vo =  new InfcPkgYe165030_2018_VO();
                             		 InfcPkgYe165030_2018_VO upInfcPkgYe165030Vo =  new InfcPkgYe165030_2018_VO(); 
                             	 
                             		 Map tempMap = (Map)listYe165030.get(iCnt);  

                             	infcPkgOrgYe165030Vo.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                      			infcPkgOrgYe165030Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(tempMap.get("yrtxBlggYr")));    /** column 귀속연도 : yrtxBlggYr */
                      			infcPkgOrgYe165030Vo.setClutSeptCd(MSFSharedUtils.allowNulls(tempMap.get("clutSeptCd")));    /** column 연말정산구분코드 : clutSeptCd */
                      			infcPkgOrgYe165030Vo.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
                      			infcPkgOrgYe165030Vo.setConbSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("conbSeilNum"),"0")));    /** column 기부금조정일련번호 : conbSeilNum */
                      			infcPkgOrgYe165030Vo.setConbCddl(MSFSharedUtils.allowNulls(tempMap.get("conbCddl")));    /** column 기부금유형구분코드 : conbCddl */
                      			infcPkgOrgYe165030Vo.setCtrbTycd(MSFSharedUtils.allowNulls(tempMap.get("ctrbTycd")));    /** column 기부금유형신고코드 : ctrbTycd */
                      			infcPkgOrgYe165030Vo.setAttrYr(MSFSharedUtils.allowNulls(tempMap.get("attrYr")));    /** column 기부년도 : attrYr */
                      			infcPkgOrgYe165030Vo.setUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("useAmt"),"0")));    /** column 기부금액 : useAmt */
                      			infcPkgOrgYe165030Vo.setPyrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("pyrDdcAmt"),"0")));    /** column 전년도공제된금액 : pyrDdcAmt */
                      			infcPkgOrgYe165030Vo.setDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("ddcTrgtAmt"),"0")));    /** column 기부금공제대상금액 : ddcTrgtAmt */
                      			infcPkgOrgYe165030Vo.setThcYrDdcAmtNdXps(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrDdcAmtNdXps"),"0")));    /** column 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
                      			infcPkgOrgYe165030Vo.setThcYrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrDdcAmt"),"0")));    /** column 해당연도공제금액세액공제금액 : thcYrDdcAmt */
                      			infcPkgOrgYe165030Vo.setThcYrNducExtnAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrNducExtnAmt"),"0")));    /** column 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
                      			infcPkgOrgYe165030Vo.setThcYrNducCrfwAmt(new BigDecimal(MSFSharedUtils.defaultNulls(tempMap.get("thcYrNducCrfwAmt"),"0")));    /** column 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
                      			infcPkgOrgYe165030Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
                      			infcPkgOrgYe165030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
                      			infcPkgOrgYe165030Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
                      			infcPkgOrgYe165030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
                      			 infcPkgOrgYe165030Vo.setSpciDdctCheck(infcPkgYe161010Vo.getSpciDdctCheck());   
       
                             		 //infcPkgOrgYe165030Vo = (InfcPkgYe165030VO)listYe165030.get(iCnt); 
                             		 BeanUtils.copyProperties(upInfcPkgYe165030Vo, infcPkgOrgYe165030Vo); 

                             		  if (infcPkgOrgYe165030Vo.getCtrbTycd().equals("41"))  {  //if  oraQrySelect05.FieldByName('CTRB_TYCD').AsString = '10' then
                             			 
                             			 	if (infcPkgOrgYe165030Vo.getAttrYr().equals("2018"))  {  // if  oraQrySelect05.FieldByName('CTRB_YRMN').AsString = '2016' then
                                  
                             			 			 upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_YATG18_41 ,bgSPCI_YASE18_41,BigDecimal.ZERO);
      		                                      
      		                                      statCnt = 0;
      		                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
      		                      		  		  if (statCnt >= 0) {  
      		
      				                               	        if (infcPkgOrgYe165030Vo.getAttrYr().equals("2016"))  {
      				                               	        	
      							                               	         upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_YATG16_41 ,bgSPCI_YASE16_41,BigDecimal.ZERO);
      								                                      
      								                                      statCnt = 0;
      								                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
      								                      		  	      if (statCnt >= 0) { 
      								                      		  	    	
      								                      		  	    	if (infcPkgOrgYe165030Vo.getAttrYr().equals("2017"))  {
      								                      		  	    		 
      								                      		  	    	  upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_YATG17_41 ,bgSPCI_YASE17_41,BigDecimal.ZERO);
      								                      		  	    	 
      								                      		  	          statCnt = 0;
      									                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
      									                      		  	      if (statCnt >= 0) { 
      									                      		  	    	  
      									                      		  	      }
      								                                 	   	}
      								                      		  	    	  
      								                      		  	      }
      				                                  		   
      				                                 	   	}  else if (infcPkgOrgYe165030Vo.getAttrYr().equals("2017"))  {
      				                                 	   	  upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_YATG17_41 ,bgSPCI_YASE17_41,BigDecimal.ZERO);
      							                      		  	    	 
      						                      		  	          statCnt = 0;
      							                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
      							                      		  	      if (statCnt >= 0) { 
      							                      		  	    	  
      							                      		  	      }
      				                                 	   	}
      		                      		  			  
      		                      		  	  	  }
                             			 		
                                     	    }  else if (infcPkgOrgYe165030Vo.getAttrYr().equals("2016"))  { 
                            		  				
      	                      		  			  upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_YATG16_41 ,bgSPCI_YASE16_41,BigDecimal.ZERO);
      		                                      
      		                                      statCnt = 0;
      		                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
      		                      		  	    
      		                      		  		  if (statCnt >= 0) { 
      		                      		  	    	
      		                      		  	    	if (infcPkgOrgYe165030Vo.getAttrYr().equals("2017"))  {
      		                      		  	    		 
      		                      		  	    	  upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_YATG17_41 ,bgSPCI_YASE17_41,BigDecimal.ZERO);
      		                      		  	    	 
      		                      		  	          statCnt = 0;
      			                      		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
      			                      		  	      if (statCnt >= 0) { 
      			                      		  	    	  
      			                      		  	      }
      		                                 	   	}
      		                      		  	    	  
      		                      		  	      }
                          		  		  
                                 	   
                                     	   	}  else if (infcPkgOrgYe165030Vo.getAttrYr().equals("2017"))  {
                                     	   		
      			                               	     upInfcPkgYe165030Vo  = insertYeYe165030(infcPkgOrgYe165030Vo,upInfcPkgYe165030Vo,bgSPCI_YATG17_41 ,bgSPCI_YASE17_41,BigDecimal.ZERO);
      			                		  	    	 
      			               		  	              statCnt = 0;
      			                     		  		  statCnt =  infcPkgYeta3300.fnPayr06430_PAYR442_ReTax_2018_Update(upInfcPkgYe165030Vo);
      			                     		  	      if (statCnt >= 0) { 
      			                     		  	    	  
      			                     		  	      }
                                     	   	}  //년도   
                                     }      //if (infcPkgOrgYe165030Vo.getCtrbTycd().equals("10"))  {

                             	 } 
                             	/**********************************************************************************************************
                              	 * 종교단체 처리 루틴  종료 
                              ***********************************************************************************************************/    	 
                     }
                    
               }


             }

             //{2011-추가기능 끝   }
             /**$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ 기부금 처리 단계 종료 $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ */
	  		  
	  	      if (statCnt >= 0) {
	  	    	  
	  	      }
	  		  
		  	 bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Yeta","[연말정산-기부금정리]" +  "처리완료","데이타확인",""));  
		   
		  	   
	  	} catch (Exception ex) {
         ex.printStackTrace();
	   	   ShowMessageBM smBm = new ShowMessageBM();
	   	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
	   	   smBm.setMenu("Yeta");
	   	   smBm.setPhase("[연말정산세액계산]세액계산 기부금정리  에러");
	   	   smBm.setMessage(ex.getLocalizedMessage());
	   	   smBm.setContent(ex.getMessage());
	   	   bmResult.add(smBm);  
	   	   
       } 
	  	   
   	    return bmResult;
    }

    /**
     * 
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : insertYeYe165030
     * @date : 2018. 2. 5.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2018. 2. 5.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param infcPkgOrgYe165030Vo  지급명세 조정하기 위한 원천데이타 
     * @param upInfcPkgYe165030Vo   조정한 데이타 를 담은 그릇 
     * @param bgSPCI_FBTG17_10      년도별 대상금액
     * @param bgSPCI_FBSE17_10      년도별 공제금액 
     * @return
     */
    private InfcPkgYe165030_2018_VO insertYeYe165030(InfcPkgYe165030_2018_VO infcPkgOrgYe165030Vo, InfcPkgYe165030_2018_VO upInfcPkgYe165030Vo,BigDecimal bgSPCI_FBTG17_10 ,BigDecimal bgSPCI_FBSE17_10,BigDecimal orgSanChul) {
    	 
    	
        	BigDecimal mTempData  = BigDecimal.ZERO; 
        
        	
        	if (infcPkgOrgYe165030Vo.getDdcTrgtAmt().compareTo(BigDecimal.ZERO) <= 0) {
        		 
        			infcPkgOrgYe165030Vo.setDdcTrgtAmt(infcPkgOrgYe165030Vo.getUseAmt());
        			upInfcPkgYe165030Vo.setDdcTrgtAmt(infcPkgOrgYe165030Vo.getUseAmt());
	        		upInfcPkgYe165030Vo.setTgtCheck("UP"); 
        	} else {
        		upInfcPkgYe165030Vo.setDdcTrgtAmt(infcPkgOrgYe165030Vo.getDdcTrgtAmt());
        		upInfcPkgYe165030Vo.setTgtCheck("");
        	}
        	
	 	    mTempData  = infcPkgOrgYe165030Vo.getDdcTrgtAmt().subtract(bgSPCI_FBTG17_10) ; 

	         if  (mTempData.compareTo(BigDecimal.ZERO) >= 0)  { //if  mTempData10 >= 0 then
	
	        	 if ("TRUE".equals(infcPkgOrgYe165030Vo.getSpciDdctCheck())) {
	        		 
	        		   upInfcPkgYe165030Vo.setThcYrDdcAmt(BigDecimal.ZERO);    /** column 해당연도공제금액 : dyyrDeam */
		      	     
	      	           if ("20".equals(infcPkgOrgYe165030Vo.getCtrbTycd()) || "42".equals(infcPkgOrgYe165030Vo.getCtrbTycd())) {
	      	        	    upInfcPkgYe165030Vo.setThcYrNducExtnAmt(bgSPCI_FBTG17_10);    /** column 해당년도_미공제소멸금액 : dyyrOtam */
	      	        	 	upInfcPkgYe165030Vo.setThcYrNducCrfwAmt(mTempData);    /** column 해당년도_미공제이월금액 : ayyrNtam */ 
	      	           } else {
	      	        	   	upInfcPkgYe165030Vo.setThcYrNducExtnAmt(bgSPCI_FBTG17_10);    /** column 해당년도_미공제소멸금액 : dyyrOtam */
	      	        	 	upInfcPkgYe165030Vo.setThcYrNducCrfwAmt(mTempData);    /** column 해당년도_미공제이월금액 : ayyrNtam */ 
	      	           }
	        	 } else {
	      	           upInfcPkgYe165030Vo.setThcYrDdcAmt(bgSPCI_FBTG17_10);    /** column 해당연도공제금액 : dyyrDeam */
	      	     
	      	           if ("20".equals(infcPkgOrgYe165030Vo.getCtrbTycd()) || "42".equals(infcPkgOrgYe165030Vo.getCtrbTycd())) {
	      	        	    upInfcPkgYe165030Vo.setThcYrNducExtnAmt(mTempData);    /** column 해당년도_미공제소멸금액 : dyyrOtam */
	      	        	 	upInfcPkgYe165030Vo.setThcYrNducCrfwAmt(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */ 
	      	           } else {
	      	        	   	upInfcPkgYe165030Vo.setThcYrNducExtnAmt(BigDecimal.ZERO);    /** column 해당년도_미공제소멸금액 : dyyrOtam */
	      	        	 	upInfcPkgYe165030Vo.setThcYrNducCrfwAmt(mTempData);    /** column 해당년도_미공제이월금액 : ayyrNtam */ 
	      	           }
	        	 }	  
	
	         }
	         else
	         {
	        	 if ("TRUE".equals(infcPkgOrgYe165030Vo.getSpciDdctCheck())) {
	        		   upInfcPkgYe165030Vo.setThcYrDdcAmt(BigDecimal.ZERO);    /** column 해당연도공제금액 : dyyrDeam */  
					   upInfcPkgYe165030Vo.setThcYrNducExtnAmt(bgSPCI_FBTG17_10);    /** column 해당년도_미공제소멸금액 : dyyrOtam */
					   upInfcPkgYe165030Vo.setThcYrNducCrfwAmt(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
	        	 } else {
	      	       upInfcPkgYe165030Vo.setThcYrDdcAmt(bgSPCI_FBTG17_10);    /** column 해당연도공제금액 : dyyrDeam */  
				   upInfcPkgYe165030Vo.setThcYrNducExtnAmt(BigDecimal.ZERO);    /** column 해당년도_미공제소멸금액 : dyyrOtam */
				   upInfcPkgYe165030Vo.setThcYrNducCrfwAmt(BigDecimal.ZERO);    /** column 해당년도_미공제이월금액 : ayyrNtam */
	        	 } 
	
	         }
        
         upInfcPkgYe165030Vo.setDpobCd(infcPkgOrgYe165030Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
         upInfcPkgYe165030Vo.setYrtxBlggYr(infcPkgOrgYe165030Vo.getYrtxBlggYr());    /** column 연말정산귀속년도 : yrtxBlggYr */
         upInfcPkgYe165030Vo.setClutSeptCd(infcPkgOrgYe165030Vo.getClutSeptCd());    /** column 정산구분코드 : clutSeptCd */
         upInfcPkgYe165030Vo.setSystemkey(infcPkgOrgYe165030Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
         upInfcPkgYe165030Vo.setConbSeilNum(infcPkgOrgYe165030Vo.getConbSeilNum());    /** column 기부조정명세일련번호 : ctrbSeqn */  //oraQrySelect05.FieldByName('CTRB_SEQN').AsString ;
 
         upInfcPkgYe165030Vo.setIsmt(infcPkgOrgYe165030Vo.getIsmt());    /** column 수정자 : ismt */
         upInfcPkgYe165030Vo.setRevnDt(infcPkgOrgYe165030Vo.getRevnDt());    /** column 수정일자 : revnDt */
         upInfcPkgYe165030Vo.setRevnAddr(infcPkgOrgYe165030Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
         
         
         return upInfcPkgYe165030Vo;
    }
     
 
}