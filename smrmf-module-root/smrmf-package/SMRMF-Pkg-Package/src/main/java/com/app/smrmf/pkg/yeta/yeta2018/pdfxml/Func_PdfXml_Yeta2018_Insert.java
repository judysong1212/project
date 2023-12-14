package com.app.smrmf.pkg.yeta.yeta2018.pdfxml;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161010_2018_VO;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class Func_PdfXml_Yeta2018_Insert {


    private static final Logger logger = LoggerFactory.getLogger(Func_PdfXml_Yeta2018_Insert.class);  
  
    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;
    
   

	public Func_PdfXml_Yeta2018_Insert() {
    	
    }

	  
   public String pdfXml_Yeta2018_Insert(InfcPkgYe161010_2018_VO ye161010VO, HttpServletRequest request)  throws Exception { 
	  
	   return pdfXml_Yeta2018_Calc_Insert( ye161010VO,  request);
   }   
	   
	 
  private String pdfXml_Yeta2018_Calc_Insert(InfcPkgYe161010_2018_VO ye161010VO, HttpServletRequest request)  throws Exception {  
	            
					try {
						
						 if (ye161010VO.getXmlFormCd().equals("A102Y")) {
						 //보장성 보험, 장애인전용보장성보험
								Func2018_Pdf_A102Y.func_2018_A102Y_YetaCalc(ye161010VO,request); 
						 } else if (ye161010VO.getXmlFormCd().equals("B101Y")) {
								//의료비
								Func2018_Pdf_B101Y.func_2018_B101Y_YetaCalc(ye161010VO, request);
								
						 } else if ((ye161010VO.getXmlFormCd().equals("C101Y")) ||  (ye161010VO.getXmlFormCd().equals("C102Y"))) {
								//교육비
								Func2018_Pdf_C101Y.func_2018_C101Y_YetaCalc(ye161010VO,   request);
				
						} else if (ye161010VO.getXmlFormCd().equals("C202Y")) {
						      //직업훈련비	
								Func2018_Pdf_C202Y.func_2018_C202Y_YetaCalc(ye161010VO,  request);
							
						} else if (ye161010VO.getXmlFormCd().equals("C301Y")) {
							  //교복구입비
								Func2018_Pdf_C301Y.func_2018_C301Y_YetaCalc(ye161010VO,  request);
								 
				      	} else if (ye161010VO.getXmlFormCd().equals("C401Y")) {
						//학자금대출상환액 
							Func2018_Pdf_C401Y.func_2018_C401Y_YetaCalc(ye161010VO,request);
						
						} else if (ye161010VO.getXmlFormCd().equals("D101Y")) {
							//개인연금저축
							Func2018_Pdf_D101Y.func_2018_D101Y_YetaCalc(ye161010VO,  request);
				
						} else if (ye161010VO.getXmlFormCd().equals("E102Y")) {
							//연금저축
							Func2018_Pdf_E102Y.func_2018_E102Y_YetaCalc(ye161010VO,  request);
							
						} else if (ye161010VO.getXmlFormCd().equals("F102Y")) {
							//퇴직연금 
							Func2018_Pdf_F102Y.func_2018_F102Y_YetaCalc(ye161010VO,  request);
						
						} else if (ye161010VO.getXmlFormCd().equals("G107Y")) {
							//신용카드
							Func2018_Pdf_G107Y.func_2018_G107Y_YetaCalc(ye161010VO, request);
							
						} else if (ye161010VO.getXmlFormCd().equals("G207M")) {
						  //현금영수증	
							Func2018_Pdf_G207Y.func_2018_G207Y_YetaCalc(ye161010VO, request);
				
						} else if (ye161010VO.getXmlFormCd().equals("G307Y")) {
							//직불카드 
							Func2018_Pdf_G307Y.func_2018_G307Y_YetaCalc(ye161010VO,  request);
				
						} else if (ye161010VO.getXmlFormCd().equals("J101Y")) {
							//주택임차차입금원리금상환액
							Func2018_Pdf_J101Y.func_2018_J101Y_YetaCalc(ye161010VO, request);
							
						} else if (ye161010VO.getXmlFormCd().equals("J203Y")) {
							//장기주택저당차입금이자상환액
							Func2018_Pdf_J203Y.func_2018_J203Y_YetaCalc(ye161010VO, request);
							
						} else if (ye161010VO.getXmlFormCd().equals("J301Y")) {
							//주책마련저축 
							Func2018_Pdf_J301Y.func_2018_J301Y_YetaCalc(ye161010VO, request); 
						
				        } else if (ye161010VO.getXmlFormCd().equals("K101M")) {
					 		//소기업소상공인 공제부금 
							Func2018_Pdf_K101Y.func_2018_K101M_YetaCalc(ye161010VO, request);  
				
						} else if (ye161010VO.getXmlFormCd().equals("L102Y")) {
							//기부금
							Func2018_Pdf_L102Y.func_2018_L102Y_YetaCalc(ye161010VO, request);
							
						} else if (ye161010VO.getXmlFormCd().equals("N101Y")) {
							//장기집합투자증권저축
							Func2018_Pdf_N101Y.func_2018_N101Y_YetaCalc(ye161010VO,  request); 
							
						 } else if (ye161010VO.getXmlFormCd().equals("O101M")) {
						    //건강보험료
							 Func2018_Pdf_O101Y.func_2018_O101M_YetaCalc(ye161010VO, request);
							  
						} else if (ye161010VO.getXmlFormCd().equals("P102M")) {
							//국민연금보험료 2018년도귀속
							Func2018_Pdf_P102Y.func_2018_P102M_YetaCalc(ye161010VO,request);
						
						} else if ((ye161010VO.getXmlFormCd().equals("G104Y")) || (ye161010VO.getXmlFormCd().equals("G104M"))) {
							/**+++++++++++신용카드 2016년귀속 삭제 ++++++++++++++++++++++++++++++++++++++++++++*/
							//Func2018_Pdf_G104Y.func_2018_G104Y_G104M(ye161010VO,request); 
						
						} else if ((ye161010VO.getXmlFormCd().equals("G304Y")) || (ye161010VO.getXmlFormCd().equals("G304M"))) {
							/**+++++++++++직불카드 2016년귀속 삭제 ++++++++++++++++++++++++++++++++++++++++++++*/
							//Func2018_Pdf_G304Y.func_2018_G304Y_G304M(ye161010VO,request);
							
						} else if ((ye161010VO.getXmlFormCd().equals("G205Y")) || (ye161010VO.getXmlFormCd().equals("G205M"))) {
							/**+++++++++++현금영수증 2016년귀속 삭제 ++++++++++++++++++++++++++++++++++++++++++++*/
							//Func2018_Pdf_G205Y.func_2018_G205Y_G205M(ye161010VO,request);
						
						} else if  ((ye161010VO.getXmlFormCd().equals("J401Y")) || (ye161010VO.getXmlFormCd().equals("J401M")))  {
					          /**+++++++++++ 2018년 귀속분 삭제 2016귀속까지만   목돈 안드는 전세 이자상환액 +++++++++++++++++++++*/
					            // 2014년 신규 추가 테이블필드 완료
					            // 목돈 안드는 전세 이자상환액  - -J401Y 기본  J401M 월별 J04 목돈 안드는 전세이자상환액 본인
						
						} else if ((ye161010VO.getXmlFormCd().equals("P101Y")) || (ye161010VO.getXmlFormCd().equals("P101M"))) {
							//국민연금보험료 2016년도귀속
							//Func2018_Pdf_P101Y.func_2018_P101Y_P101M(ye161010VO, request);
								
						} else if (ye161010VO.getXmlFormCd().equals("ALL")) {
							
							Func2018_Pdf_A102Y.func_2018_A102Y_YetaCalc(ye161010VO,request);
							 
							//의료비
							Func2018_Pdf_B101Y.func_2018_B101Y_YetaCalc(ye161010VO, request);
							
							//교육비
							Func2018_Pdf_C101Y.func_2018_C101Y_YetaCalc(ye161010VO,   request);
			
					      //직업훈련비	
							Func2018_Pdf_C202Y.func_2018_C202Y_YetaCalc(ye161010VO,  request);
						
						  //교복구입비
							Func2018_Pdf_C301Y.func_2018_C301Y_YetaCalc(ye161010VO,  request);
						
							//개인연금저축
							Func2018_Pdf_D101Y.func_2018_D101Y_YetaCalc(ye161010VO,  request);
				
							//연금저축
							Func2018_Pdf_E102Y.func_2018_E102Y_YetaCalc(ye161010VO,  request);
							
							//퇴직연금 
							Func2018_Pdf_F102Y.func_2018_F102Y_YetaCalc(ye161010VO,  request);
						
							//신용카드
							Func2018_Pdf_G106Y.func_2018_G106Y_YetaCalc(ye161010VO, request);
							
						  //현금영수증	
							Func2018_Pdf_G206Y.func_2018_G206Y_YetaCalc(ye161010VO, request);
				
							//직불카드 
							Func2018_Pdf_G306Y.func_2018_G306Y_YetaCalc(ye161010VO,  request);
				
							//주택임차차입금원리금상환액
							Func2018_Pdf_J101Y.func_2018_J101Y_YetaCalc(ye161010VO, request);
							
							//장기주택저당차입금이자상환액
							Func2018_Pdf_J203Y.func_2018_J203Y_YetaCalc(ye161010VO, request);
							
							//주책마련저축 
							Func2018_Pdf_J301Y.func_2018_J301Y_YetaCalc(ye161010VO, request); 
						
					 		//소기업소상공인 공제부금 
							Func2018_Pdf_K101Y.func_2018_K101M_YetaCalc(ye161010VO, request);  
				
							//기부금
							Func2018_Pdf_L102Y.func_2018_L102Y_YetaCalc(ye161010VO, request);
							
							//장기집합투자증권저축
							Func2018_Pdf_N101Y.func_2018_N101Y_YetaCalc(ye161010VO,  request); 
							
						    //건강보험료
							 Func2018_Pdf_O101Y.func_2018_O101M_YetaCalc(ye161010VO, request);
							//국민연금보험료 2018년도귀속
							Func2018_Pdf_P102Y.func_2018_P102M_YetaCalc(ye161010VO,request);
						//학자금대출상환액 
							Func2018_Pdf_C401Y.func_2018_C401Y_YetaCalc(ye161010VO,request);
						
						}
						 
						 
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				return "ok";
	  
  }
   
}
