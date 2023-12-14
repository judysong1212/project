package com.app.smrmf.pkg.yeta.yeta2017.pdfxml;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.service.InfcPkgYeta2200Service;
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

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class Func_PdfInDdc_Yeta2017_Insert {


    private static final Logger logger = LoggerFactory.getLogger(Func_PdfInDdc_Yeta2017_Insert.class);  
 
	@Resource(name = "InfcPkgYeta2200Service")
	private InfcPkgYeta2200Service yeta2200Service;
	
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
     

	public Func_PdfInDdc_Yeta2017_Insert() {
    	
    }

	  
   public String pdfInDdc_Yeta2017_Insert(InfcPkgYe161010VO ye161010VO, HttpServletRequest request)  throws Exception { 
	  
	   return pdfInDdc_Yeta2017_Calc_Insert(ye161010VO,  request);
   }   
	   
	 
  private String pdfInDdc_Yeta2017_Calc_Insert(InfcPkgYe161010VO ye161010VO, HttpServletRequest request) throws Exception  {   
			     
	          yeta2200Service = (InfcPkgYeta2200Service)BeanFinder.getBean("InfcPkgYeta2200Service"); 
	  		    String dataChk = null;
	  			int icChk = 0;
	  			
	  			//InfcPkgYe160401VO    infcPkgYe160401Vo	 = new InfcPkgYe160401VO();	//현근무지급여지급명세
				//InfcPkgYe160402VO    infcPkgYe160402Vo	 = new InfcPkgYe160402VO();	//현근무지비과세_감면소득_과세
				//InfcPkgYe160403VO    infcPkgYe160403Vo	 = new InfcPkgYe160403VO();	//현근무지비과세_감면소득_비과세
				
				//InfcPkgYe160404VO    infcPkgYe160404Vo	 = new InfcPkgYe160404VO();	//D_종전근무처
				//InfcPkgYe160405VO    infcPkgYe160405Vo	 = new InfcPkgYe160405VO();	//D_종전근무처비과세_감면소득_비과세
				//InfcPkgYe160406VO    infcPkgYe160406Vo	 = new InfcPkgYe160406VO();	//종전근무지연금보험료_공적연금
				//InfcPkgYe160510VO    infcPkgYe160510Vo	 = new InfcPkgYe160510VO();	//근무지별비과세_감면소득
				
			//	InfcPkgYe161005VO    infcPkgYe161005Vo	 = new InfcPkgYe161005VO();	//A_원천세신고기본
				
			//	InfcPkgYe161010VO    infcPkgYe161010Vo	 = new InfcPkgYe161010VO();	// 연말정산대상자기본
				InfcPkgYe161020VO     infcPkgYe161020Vo	 = new InfcPkgYe161020VO();	//A_인적소득공제기본
				InfcPkgYe161030VO     infcPkgYe161030Vo	 = new InfcPkgYe161030VO();	//E_인적공제명세
				InfcPkgYe161040VO     infcPkgYe161040Vo	 = new InfcPkgYe161040VO();	//E_소득세액공제명세
				InfcPkgYe161050VO     infcPkgYe161050Vo	 = new InfcPkgYe161050VO();	//C_연금보험료공제
				InfcPkgYe161055VO     infcPkgYe161055Vo	 = new InfcPkgYe161055VO();	//C_연금보험료_공적연금상세
				InfcPkgYe161060VO     infcPkgYe161060Vo	 = new InfcPkgYe161060VO();	//C_특별소득공제
				InfcPkgYe161070VO     infcPkgYe161070Vo	 = new InfcPkgYe161070VO();	//C_그밖의소득공제
				InfcPkgYe161080VO     infcPkgYe161080Vo	 = new InfcPkgYe161080VO();	//C_세액감면및공제
				InfcPkgYe161090VO     infcPkgYe161090Vo	 = new InfcPkgYe161090VO();	//C_교육비내역
				InfcPkgYe162010VO     infcPkgYe162010Vo	 = new InfcPkgYe162010VO();	//F_연금저축계좌
				InfcPkgYe162020VO     infcPkgYe162020Vo	 = new InfcPkgYe162020VO();	//F_퇴직연금계좌명세
				InfcPkgYe162030VO     infcPkgYe162030Vo	 = new InfcPkgYe162030VO();	//F_주택마련저축
				InfcPkgYe162040VO     infcPkgYe162040Vo	 = new InfcPkgYe162040VO();	//F_장기집합투자증권저축_B1013
				InfcPkgYe162510VO     infcPkgYe162510Vo	 = new InfcPkgYe162510VO();	//G_월세액소득공제명세
				InfcPkgYe162520VO     infcPkgYe162520Vo	 = new InfcPkgYe162520VO();	//G_거주자간_금전소비대차
				InfcPkgYe162530VO     infcPkgYe162530Vo	 = new InfcPkgYe162530VO();	//G_임대차계약
				InfcPkgYe164010VO     infcPkgYe164010Vo	 = new InfcPkgYe164010VO();	//A_의료비지급명세
				InfcPkgYe165010VO     infcPkgYe165010Vo	 = new InfcPkgYe165010VO();	//I_해당연도기부금명세
				InfcPkgYe165020VO     infcPkgYe165020Vo	 = new InfcPkgYe165020VO();	//I_기부자관계코드별기부금합계
				InfcPkgYe165030VO     infcPkgYe165030Vo	 = new InfcPkgYe165030VO();	//H_기부금조정명세
				InfcPkgYe165030TempVO infcPkgYe165030TempVo = new InfcPkgYe165030TempVO();  	    //H_기부금조정명세_TEMP	 
				InfcPkgYe166010VO     infcPkgYe166010Vo	 = new InfcPkgYe166010VO();	//신용카드등소득공제명세
				InfcPkgYe166020VO     infcPkgYe166020Vo	 = new InfcPkgYe166020VO();	//신용카드등소득공제상세
					 								//
				InfcPkgYe169010VO     infcPkgYe169010Vo	 = new InfcPkgYe169010VO();	//C_주현근무처
				InfcPkgYe169010aVO    infcPkgYe169010AVo = new InfcPkgYe169010aVO();	//C_주현근무처_표준공제 
				
				try {
					 
					BeanUtils.copyProperties(infcPkgYe161030Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe161040Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe161050Vo, ye161010VO); 
					BeanUtils.copyProperties(infcPkgYe161055Vo, ye161010VO);
					
					BeanUtils.copyProperties(infcPkgYe161060Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe161070Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe161080Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe161090Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe162010Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe162020Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe162030Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe162040Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe162510Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe162520Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe162530Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe164010Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe165010Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe165020Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe165030Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe165030TempVo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe166010Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe166020Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe169010Vo, ye161010VO);
					BeanUtils.copyProperties(infcPkgYe169010AVo, ye161010VO);
				 
					infcPkgYe161020Vo.setDpobCd(ye161010VO.getDpobCd());    						/** column 사업장코드 : dpobCd */
					infcPkgYe161020Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());    				/** column 귀속연도 : yrtxBlggYr */
					infcPkgYe161020Vo.setClutSeptCd(ye161010VO.getClutSeptCd());    				/** column 연말정산구분코드 : clutSeptCd */
					infcPkgYe161020Vo.setSystemkey(ye161010VO.getSystemkey());    			    	/** column SYSTEMKEY : systemkey */
				 
					
				    //data delete 
					yeta2200Service.incTaxDeducDec_nts_Yeta2017_YetaAll_Delete(ye161010VO);
					if (icChk >= 0) {
						    //ye161020
							icChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye161020_update(infcPkgYe161020Vo);
							
                            if  (icChk >= 0) {
                            	
                            	//InfcPkgYe161030VO     infcPkgYe161030Vo	 = new InfcPkgYe161030VO();	//E_인적공제명세
                            	dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye161030_Insert( infcPkgYe161030Vo) ;
    							
                             if (MSFSharedUtils.paramNull(dataChk)) {   
                            	 
                            	//InfcPkgYe161040VO     infcPkgYe161040Vo	 = new InfcPkgYe161040VO();	//E_소득세액공제명세
                            	 dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye161040_Insert(infcPkgYe161040Vo) ;
     							
     							if (MSFSharedUtils.paramNull(dataChk)) {  
     								
     								//InfcPkgYe161050VO     infcPkgYe161050Vo	 = new InfcPkgYe161050VO();	//C_연금보험료공제
     								dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye161050_Insert(infcPkgYe161050Vo);
         							
     								if (MSFSharedUtils.paramNull(dataChk)) { 
     									
     									//InfcPkgYe161055VO     infcPkgYe161055Vo	 = new InfcPkgYe161055VO();	//C_연금보험료_공적연금상세
     									dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye161055_Insert(infcPkgYe161055Vo);
     									dataChk =  yeta2200Service.fnYeta2100_Ye161055_PAYR_2017_Y0130002_Insert(infcPkgYe161055Vo);
     									
     									if (MSFSharedUtils.paramNull(dataChk)) { 

     										//InfcPkgYe161060VO     infcPkgYe161060Vo	 = new InfcPkgYe161060VO();	//C_특별소득공제
     										dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye161060_Insert( infcPkgYe161060Vo);
     										if (MSFSharedUtils.paramNull(dataChk)) { 
     											//InfcPkgYe161070VO     infcPkgYe161070Vo	 = new InfcPkgYe161070VO();	//C_그밖의소득공제 
     											dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye161070_Insert(infcPkgYe161070Vo);
     											
     											if (MSFSharedUtils.paramNull(dataChk)) { 
     												
     												//InfcPkgYe161080VO     infcPkgYe161080Vo	 = new InfcPkgYe161080VO();	//C_세액감면및공제
     												dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye161080_Insert(infcPkgYe161080Vo);
     												           yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye161080_Insert_01(infcPkgYe161080Vo);
     												if (MSFSharedUtils.paramNull(dataChk)) { 
     													//InfcPkgYe161090VO     infcPkgYe161090Vo	 = new InfcPkgYe161090VO();	//C_교육비내역
     													//public String incTaxDeducDec_nts_Yeta2017_Ye161090_Insert(InfcPkgYe161090VO     infcPkgYe161090Vo) throws Exception;
     													//InfcPkgYe162010VO     infcPkgYe162010Vo	 = new InfcPkgYe162010VO();	//F_연금저축계좌
     													dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye162010_Insert(infcPkgYe162010Vo);
     													if (MSFSharedUtils.paramNull(dataChk)) { 
     														//InfcPkgYe162020VO     infcPkgYe162020Vo	 = new InfcPkgYe162020VO();	//F_퇴직연금계좌명세
     														dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye162020_Insert(infcPkgYe162020Vo);
     														
     														if (MSFSharedUtils.paramNull(dataChk)) { 
     															
     															//InfcPkgYe162030VO     infcPkgYe162030Vo	 = new InfcPkgYe162030VO();	//F_주택마련저축
     															dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye162030_Insert(infcPkgYe162030Vo);
     															
     															if (MSFSharedUtils.paramNull(dataChk)) { 
     																
     																//InfcPkgYe162040VO     infcPkgYe162040Vo	 = new InfcPkgYe162040VO();	//F_장기집합투자증권저축_B1013
     																dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye162040_Insert(infcPkgYe162040Vo);
     																if (MSFSharedUtils.paramNull(dataChk)) { 
     																	//InfcPkgYe162510VO     infcPkgYe162510Vo	 = new InfcPkgYe162510VO();	//G_월세액소득공제명세
     																	dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye162510_Insert( infcPkgYe162510Vo);
         																
     																	if (MSFSharedUtils.paramNull(dataChk)) { 
     																		
     																		//InfcPkgYe162520VO     infcPkgYe162520Vo	 = new InfcPkgYe162520VO();	//G_거주자간_금전소비대차
     																		dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye162520_Insert( infcPkgYe162520Vo); 
     																		 
     																		if (MSFSharedUtils.paramNull(dataChk)) { 
     																			//InfcPkgYe162530VO     infcPkgYe162530Vo	 = new InfcPkgYe162530VO();	//G_임대차계약 
     																			dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye162530_Insert( infcPkgYe162530Vo); 
     																			
     																			if (MSFSharedUtils.paramNull(dataChk)) { 
     																				
     																				//InfcPkgYe164010VO     infcPkgYe164010Vo	 = new InfcPkgYe164010VO();	//A_의료비지급명세
     																				dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye164010_Insert(infcPkgYe164010Vo);
     																				
     																				if (MSFSharedUtils.paramNull(dataChk)) { 
     																					//InfcPkgYe165010VO     infcPkgYe165010Vo	 = new InfcPkgYe165010VO();	//I_해당연도기부금명세
     																					dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye165010_Insert(infcPkgYe165010Vo);
     																					
     																					if (MSFSharedUtils.paramNull(dataChk)) { 
     																						//InfcPkgYe165020VO     infcPkgYe165020Vo	 = new InfcPkgYe165020VO();	//I_기부자관계코드별기부금합계
     																						dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye165020_Insert(infcPkgYe165020Vo);
     																						
     																						if (MSFSharedUtils.paramNull(dataChk)) { 
     																							
     																							//InfcPkgYe165030VO     infcPkgYe165030Vo	 = new InfcPkgYe165030VO();	//H_기부금조정명세
     																							dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye165030_Insert(infcPkgYe165030Vo) ;
     																							//InfcPkgYe165030TempVO infcPkgYe165030TempVo = new InfcPkgYe165030TempVO();  	    //H_기부금조정명세_TEMP	 
     																							//public int incTaxDeducDec_nts_Yeta2017_Ye165030Temp_update(InfcPkgYe165030TempVO infcPkgYe165030TempVo) throws Exception;
     																							
     																							if (MSFSharedUtils.paramNull(dataChk)) { 
     																								
     																								//InfcPkgYe166010VO     infcPkgYe166010Vo	 = new InfcPkgYe166010VO();	//신용카드등소득공제명세
     																								dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye166010_Insert( infcPkgYe166010Vo);
     																								
     																								if (MSFSharedUtils.paramNull(dataChk)) { 
     																									
     																									//InfcPkgYe166020VO     infcPkgYe166020Vo	 = new InfcPkgYe166020VO();	//신용카드등소득공제상세
     																									dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye166020_Insert(infcPkgYe166020Vo); 
     																									
//     																									if (MSFSharedUtils.paramNull(dataChk)) { 
//     																										
//     																										//InfcPkgYe169010VO     infcPkgYe169010Vo	 = new InfcPkgYe169010VO();	//C_주현근무처
//     																										dataChk =  yeta2200Service.incTaxDeducDec_nts_Yeta2017_Ye169010_Insert(infcPkgYe169010Vo);
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
