package com.app.smrmf.pkg.yeta.yeta2020.pdfxml;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.yearendtax.server.service.yeta2020.service.InfcPkgYeta5200Service;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161020_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161030_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161040_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161050_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161055_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161060_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161070_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161080_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161090_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162020_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162030_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162040_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162510_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162520_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162530_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe164010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe165010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe165020_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe165030Temp_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe165030_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe166010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe166020_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe169010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe169010a_2020_VO;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class Func_PdfInDdc_Yeta2020_Insert {


    private static final Logger logger = LoggerFactory.getLogger(Func_PdfInDdc_Yeta2020_Insert.class);  
 
	@Resource(name = "InfcPkgYeta5200Service")
	private InfcPkgYeta5200Service yeta5200Service;
	
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
     

	public Func_PdfInDdc_Yeta2020_Insert() {
    	
    }

	  
   public String pdfInDdc_Yeta2020_Insert(InfcPkgYe161010_2020_VO ye161010_2020_VO, HttpServletRequest request)  throws Exception { 
	  
	   return pdfInDdc_Yeta2020_Calc_Insert(ye161010_2020_VO,  request);
   }   
	   
	 
  private String pdfInDdc_Yeta2020_Calc_Insert(InfcPkgYe161010_2020_VO ye161010_2020_VO, HttpServletRequest request) throws Exception  {   
			     
	  yeta5200Service = (InfcPkgYeta5200Service)BeanFinder.getBean("InfcPkgYeta5200Service"); 
	    String dataChk = null;
		int icChk = 0;
		
		//InfcPkgYe160401VO    infcPkgYe160401Vo	 = new InfcPkgYe160401VO();	//현근무지급여지급명세
		//InfcPkgYe160402VO    infcPkgYe160402Vo	 = new InfcPkgYe160402VO();	//현근무지비과세_감면소득_과세
		//InfcPkgYe160403VO    infcPkgYe160403Vo	 = new InfcPkgYe160403VO();	//현근무지비과세_감면소득_비과세
		
		//InfcPkgYe160404VO    infcPkgYe160404Vo	 = new InfcPkgYe160404VO();	//D_종전근무처
		//InfcPkgYe160405_2020_VO    infcPkgYe160405Vo	 = new InfcPkgYe160405_2020_VO();	//D_종전근무처비과세_감면소득_비과세
		//InfcPkgYe160406VO    infcPkgYe160406Vo	 = new InfcPkgYe160406VO();	//종전근무지연금보험료_공적연금
		//InfcPkgYe160510_2020_VO    infcPkgYe160510Vo	 = new InfcPkgYe160510_2020_VO();	//근무지별비과세_감면소득
		
	//	InfcPkgYe161005_2020_VO    infcPkgYe161005Vo	 = new InfcPkgYe161005_2020_VO();	//A_원천세신고기본
		
	//	InfcPkgYe161010_2020_VO    infcPkgYe161010Vo	 = new InfcPkgYe161010_2020_VO();	// 연말정산대상자기본
		InfcPkgYe161020_2020_VO     infcPkgYe161020Vo	 = new InfcPkgYe161020_2020_VO();	//A_인적소득공제기본
		InfcPkgYe161030_2020_VO     infcPkgYe161030Vo	 = new InfcPkgYe161030_2020_VO();	//E_인적공제명세
		InfcPkgYe161040_2020_VO     infcPkgYe161040Vo	 = new InfcPkgYe161040_2020_VO();	//E_소득세액공제명세
		InfcPkgYe161050_2020_VO     infcPkgYe161050Vo	 = new InfcPkgYe161050_2020_VO();	//C_연금보험료공제
		InfcPkgYe161055_2020_VO     infcPkgYe161055Vo	 = new InfcPkgYe161055_2020_VO();	//C_연금보험료_공적연금상세
		InfcPkgYe161060_2020_VO     infcPkgYe161060Vo	 = new InfcPkgYe161060_2020_VO();	//C_특별소득공제
		InfcPkgYe161070_2020_VO     infcPkgYe161070Vo	 = new InfcPkgYe161070_2020_VO();	//C_그밖의소득공제
		InfcPkgYe161080_2020_VO     infcPkgYe161080Vo	 = new InfcPkgYe161080_2020_VO();	//C_세액감면및공제
		InfcPkgYe161090_2020_VO     infcPkgYe161090Vo	 = new InfcPkgYe161090_2020_VO();	//C_교육비내역
		InfcPkgYe162010_2020_VO     infcPkgYe162010Vo	 = new InfcPkgYe162010_2020_VO();	//F_연금저축계좌
		InfcPkgYe162020_2020_VO     infcPkgYe162020Vo	 = new InfcPkgYe162020_2020_VO();	//F_퇴직연금계좌명세
		InfcPkgYe162030_2020_VO     infcPkgYe162030Vo	 = new InfcPkgYe162030_2020_VO();	//F_주택마련저축
		InfcPkgYe162040_2020_VO     infcPkgYe162040Vo	 = new InfcPkgYe162040_2020_VO();	//F_장기집합투자증권저축_B1013
		InfcPkgYe162510_2020_VO     infcPkgYe162510Vo	 = new InfcPkgYe162510_2020_VO();	//G_월세액소득공제명세
		InfcPkgYe162520_2020_VO     infcPkgYe162520Vo	 = new InfcPkgYe162520_2020_VO();	//G_거주자간_금전소비대차
		InfcPkgYe162530_2020_VO     infcPkgYe162530Vo	 = new InfcPkgYe162530_2020_VO();	//G_임대차계약
		InfcPkgYe164010_2020_VO     infcPkgYe164010Vo	 = new InfcPkgYe164010_2020_VO();	//A_의료비지급명세
		InfcPkgYe165010_2020_VO     infcPkgYe165010Vo	 = new InfcPkgYe165010_2020_VO();	//I_해당연도기부금명세
		InfcPkgYe165020_2020_VO     infcPkgYe165020Vo	 = new InfcPkgYe165020_2020_VO();	//I_기부자관계코드별기부금합계
		InfcPkgYe165030_2020_VO     infcPkgYe165030Vo	 = new InfcPkgYe165030_2020_VO();	//H_기부금조정명세
		InfcPkgYe165030Temp_2020_VO infcPkgYe165030TempVo = new InfcPkgYe165030Temp_2020_VO();  	    //H_기부금조정명세_TEMP	 
		InfcPkgYe166010_2020_VO     infcPkgYe166010Vo	 = new InfcPkgYe166010_2020_VO();	//신용카드등소득공제명세
		InfcPkgYe166020_2020_VO     infcPkgYe166020Vo	 = new InfcPkgYe166020_2020_VO();	//신용카드등소득공제상세
			 								//
		InfcPkgYe169010_2020_VO     infcPkgYe169010Vo	 = new InfcPkgYe169010_2020_VO();	//C_주현근무처
		InfcPkgYe169010a_2020_VO    infcPkgYe169010AVo = new InfcPkgYe169010a_2020_VO();	//C_주현근무처_표준공제 
		
		try {
			 
			BeanUtils.copyProperties(infcPkgYe161030Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe161040Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe161050Vo, ye161010_2020_VO); 
			BeanUtils.copyProperties(infcPkgYe161055Vo, ye161010_2020_VO);
			
			BeanUtils.copyProperties(infcPkgYe161060Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe161070Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe161080Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe161090Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe162010Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe162020Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe162030Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe162040Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe162510Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe162520Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe162530Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe164010Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe165010Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe165020Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe165030Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe165030TempVo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe166010Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe166020Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe169010Vo, ye161010_2020_VO);
			BeanUtils.copyProperties(infcPkgYe169010AVo, ye161010_2020_VO);
		 
			infcPkgYe161020Vo.setDpobCd(ye161010_2020_VO.getDpobCd());    						/** column 사업장코드 : dpobCd */
			infcPkgYe161020Vo.setYrtxBlggYr(ye161010_2020_VO.getYrtxBlggYr());    				/** column 귀속연도 : yrtxBlggYr */
			infcPkgYe161020Vo.setClutSeptCd(ye161010_2020_VO.getClutSeptCd());    				/** column 연말정산구분코드 : clutSeptCd */
			infcPkgYe161020Vo.setSystemkey(ye161010_2020_VO.getSystemkey());    			    	/** column SYSTEMKEY : systemkey */
		 
			
		    //data delete 
			yeta5200Service.incTaxDeducDec_nts_Yeta2020_YetaAll_Delete(ye161010_2020_VO);
			if (icChk >= 0) {
				    //ye161020
					icChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye161020_update(infcPkgYe161020Vo);
					
	                if  (icChk >= 0) {
	                	
	                	//InfcPkgYe161030_2020_VO     infcPkgYe161030Vo	 = new InfcPkgYe161030_2020_VO();	//E_인적공제명세
	                	dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye161030_Insert( infcPkgYe161030Vo) ;
						
	                 if (MSFSharedUtils.paramNull(dataChk)) {   
	                	 
	                	//InfcPkgYe161040_2020_VO     infcPkgYe161040Vo	 = new InfcPkgYe161040_2020_VO();	//E_소득세액공제명세
	                	 dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye161040_Insert(infcPkgYe161040Vo) ;
						
						if (MSFSharedUtils.paramNull(dataChk)) {  
							
							//InfcPkgYe161050_2020_VO     infcPkgYe161050Vo	 = new InfcPkgYe161050_2020_VO();	//C_연금보험료공제
							dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye161050_Insert(infcPkgYe161050Vo);
							
							if (MSFSharedUtils.paramNull(dataChk)) { 
								
								//InfcPkgYe161055_2020_VO     infcPkgYe161055Vo	 = new InfcPkgYe161055_2020_VO();	//C_연금보험료_공적연금상세
								dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye161055_Insert(infcPkgYe161055Vo);
								dataChk =  yeta5200Service.fnYeta5100_Ye161055_PAYR_2020_Y0130002_Insert(infcPkgYe161055Vo);
								
								if (MSFSharedUtils.paramNull(dataChk)) { 
	
									//InfcPkgYe161060_2020_VO     infcPkgYe161060Vo	 = new InfcPkgYe161060_2020_VO();	//C_특별소득공제
									dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye161060_Insert( infcPkgYe161060Vo);
									if (MSFSharedUtils.paramNull(dataChk)) { 
										//InfcPkgYe161070_2020_VO     infcPkgYe161070Vo	 = new InfcPkgYe161070_2020_VO();	//C_그밖의소득공제 
										dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye161070_Insert(infcPkgYe161070Vo);
										
										if (MSFSharedUtils.paramNull(dataChk)) { 
											
											//InfcPkgYe161080_2020_VO     infcPkgYe161080Vo	 = new InfcPkgYe161080_2020_VO();	//C_세액감면및공제
											dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye161080_Insert(infcPkgYe161080Vo);
											           yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye161080_Insert_01(infcPkgYe161080Vo);
											if (MSFSharedUtils.paramNull(dataChk)) { 
												//InfcPkgYe161090_2020_VO     infcPkgYe161090Vo	 = new InfcPkgYe161090_2020_VO();	//C_교육비내역
												//public String incTaxDeducDec_nts_Yeta2020_Ye161090_Insert(InfcPkgYe161090_2020_VO     infcPkgYe161090Vo) throws Exception;
												//InfcPkgYe162010_2020_VO     infcPkgYe162010Vo	 = new InfcPkgYe162010_2020_VO();	//F_연금저축계좌
												dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye162010_Insert(infcPkgYe162010Vo);
												if (MSFSharedUtils.paramNull(dataChk)) { 
													//InfcPkgYe162020_2020_VO     infcPkgYe162020Vo	 = new InfcPkgYe162020_2020_VO();	//F_퇴직연금계좌명세
													dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye162020_Insert(infcPkgYe162020Vo);
													
													if (MSFSharedUtils.paramNull(dataChk)) { 
														
														//InfcPkgYe162030_2020_VO     infcPkgYe162030Vo	 = new InfcPkgYe162030_2020_VO();	//F_주택마련저축
														dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye162030_Insert(infcPkgYe162030Vo);
														
														if (MSFSharedUtils.paramNull(dataChk)) { 
															
															//InfcPkgYe162040_2020_VO     infcPkgYe162040Vo	 = new InfcPkgYe162040_2020_VO();	//F_장기집합투자증권저축_B1013
															dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye162040_Insert(infcPkgYe162040Vo);
															if (MSFSharedUtils.paramNull(dataChk)) { 
																//InfcPkgYe162510_2020_VO     infcPkgYe162510Vo	 = new InfcPkgYe162510_2020_VO();	//G_월세액소득공제명세
																dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye162510_Insert( infcPkgYe162510Vo);
																
																if (MSFSharedUtils.paramNull(dataChk)) { 
																	
																	//InfcPkgYe162520_2020_VO     infcPkgYe162520Vo	 = new InfcPkgYe162520_2020_VO();	//G_거주자간_금전소비대차
																	dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye162520_Insert( infcPkgYe162520Vo); 
																	 
																	if (MSFSharedUtils.paramNull(dataChk)) { 
																		//InfcPkgYe162530_2020_VO     infcPkgYe162530Vo	 = new InfcPkgYe162530_2020_VO();	//G_임대차계약 
																		dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye162530_Insert( infcPkgYe162530Vo); 
																		
																		if (MSFSharedUtils.paramNull(dataChk)) { 
																			
																			//InfcPkgYe164010_2020_VO     infcPkgYe164010Vo	 = new InfcPkgYe164010_2020_VO();	//A_의료비지급명세
																			dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye164010_Insert(infcPkgYe164010Vo);
																			
																			if (MSFSharedUtils.paramNull(dataChk)) { 
																				//InfcPkgYe165010_2020_VO     infcPkgYe165010Vo	 = new InfcPkgYe165010_2020_VO();	//I_해당연도기부금명세
																				dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye165010_Insert(infcPkgYe165010Vo);
																				
																				if (MSFSharedUtils.paramNull(dataChk)) { 
																					//InfcPkgYe165020_2020_VO     infcPkgYe165020Vo	 = new InfcPkgYe165020_2020_VO();	//I_기부자관계코드별기부금합계
																					dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye165020_Insert(infcPkgYe165020Vo);
																					
																					if (MSFSharedUtils.paramNull(dataChk)) { 
																						
																						//InfcPkgYe165030_2020_VO     infcPkgYe165030Vo	 = new InfcPkgYe165030_2020_VO();	//H_기부금조정명세
																						dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye165030_Insert(infcPkgYe165030Vo) ;
																						//InfcPkgYe165030TempVO infcPkgYe165030TempVo = new InfcPkgYe165030TempVO();  	    //H_기부금조정명세_TEMP	 
																						//public int incTaxDeducDec_nts_Yeta2020_Ye165030Temp_update(InfcPkgYe165030TempVO infcPkgYe165030TempVo) throws Exception;
																						
																						if (MSFSharedUtils.paramNull(dataChk)) { 
																							
																							//InfcPkgYe166010_2020_VO     infcPkgYe166010Vo	 = new InfcPkgYe166010_2020_VO();	//신용카드등소득공제명세
																							dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye166010_Insert( infcPkgYe166010Vo);
																							
																							if (MSFSharedUtils.paramNull(dataChk)) { 
																								
																								//InfcPkgYe166020_2020_VO     infcPkgYe166020Vo	 = new InfcPkgYe166020_2020_VO();	//신용카드등소득공제상세
																								dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye166020_Insert(infcPkgYe166020Vo); 
																								
	//     																									if (MSFSharedUtils.paramNull(dataChk)) { 
	//     																										
	//     																										//InfcPkgYe169010_2020_VO     infcPkgYe169010Vo	 = new InfcPkgYe169010_2020_VO();	//C_주현근무처
	//     																										dataChk =  yeta5200Service.incTaxDeducDec_nts_Yeta2020_Ye169010_Insert(infcPkgYe169010Vo);
	//     																									}
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
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "error";
				
			}
		
		   return "ok"; 
 
  }
   
}
