package com.app.smrmf.pkg.yeta.yeta2017.pdfxml;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.egov.comutils.payr.PkgFuncUtils;
import com.app.smrmf.infc.yearendtax.server.service.yeta2017.service.InfcPkgYeta2200Service;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.pkg.yeta.yeta2017.pdfxml.service.Yeta2200XmlService;

import egovframework.rte.fdl.property.EgovPropertyService;
//import com.app.smrmf.props.ExtermsProps;

@Controller
public class Yeta2200PkgXmlController {


	private static final Logger logger = LoggerFactory.getLogger(Yeta2200PkgXmlController.class);  


	@Resource(name = "InfcPkgYeta2200Service")
	private InfcPkgYeta2200Service yeta2200Service;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	@Resource(name = "Yeta2200XmlService")
	private Yeta2200XmlService yetaPayr2200Service;

	public Yeta2200PkgXmlController() {
    	
    }

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 연말정산간소화 전자파일 
	 * 2. 처리내용 : 연말정산간소화 전자파일 
	 * </pre>
	 * @Method Name : PayrXmlDataInsert
	 * @date : 2018. 1. 17.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 17.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param ye161010VO
	 * @param xmlDoc
	 * @param request
	 * @return
	 */
	public String PayrXmlDataInsert(InfcPkgYe161010VO ye161010VO, Document xmlDoc, HttpServletRequest request) {
		
		yetaPayr2200Service = (Yeta2200XmlService)BeanFinder.getBean("Yeta2200XmlService");

		Node xmlItemDoc = null;
		Element  xmlItemMain  = null;
		Element  xmlelDoc  = null;

		NodeList xmlItemForm = null;

		Node subXmlItemForm = null;
		Element  subXmlElForm = null; 
		
		Node subXmlItemForm2 = null;
		Element  subXmlElForm2 = null; 
		
		NodeList subXmlElChildForm = null;
		Node subXmlItemMan = null;
		Element subXmlElMan = null;

		String dataType = "";
		String dataPrDate  = "";
		String dataYear = "";
		String dataFrmMm = "";
		String dataToMm = "";
		String dataInqrMm = "";
		String dataResid = "";
		String  strFormCd  = "";
		String strDatCd = "";
		String strSum = "";
		
		try {
			try {

				// FileName := 'C:\EOSDATA\2015\' + trim(lblFILE_SAVE.Caption) + '_' + trim(edKORN_NAME.Text); // + '.xml';
				// Memo_XML_EUC_KR.Lines.Clear;
				//  Memo_XML_EUC_KR.Lines.LoadFromFile(ChangeFileExt(FileName, '.xml'));
				//  CONNXML.LoadFromFile(ChangeFileExt(FileName, '.xml'));
				// CONNXML.Root.AsString := Memo_XML_EUC_KR.Lines.Text;
				// ecxmlPdf.LoadFromFile(FileName);
				
				xmlItemMain = xmlDoc.getDocumentElement();

				xmlItemDoc = xmlItemMain.getElementsByTagName("doc").item(0); 
				xmlelDoc = (Element)xmlItemDoc;	 

				dataType = PkgFuncUtils.getXmlTagValue("doc_type", xmlelDoc);    //문서종류   
				dataPrDate =  PkgFuncUtils.getXmlTagValue("seq", xmlelDoc); //일련번호 
				dataYear = PkgFuncUtils.getXmlTagValue("att_year", xmlelDoc);   //귀속년도 
				dataInqrMm = PkgFuncUtils.getXmlTagValue("att_inqrMm", xmlelDoc);   //월 기간

				xmlItemForm =  xmlItemMain.getElementsByTagName("form");    
				
				if (!dataYear.equals("2017")) {
					//에러처리 
					return "2"; 
				}
				
				subXmlItemForm2 = xmlItemForm.item(0); 
				subXmlElForm2  = (Element) subXmlItemForm2;
				
				/** 주민등록번호 일치 여부 확인 시작 */
				
				subXmlElChildForm =  subXmlElForm2.getElementsByTagName("man");
				subXmlItemMan =  subXmlElChildForm.item(0);  //인원별 데이터
				subXmlElMan  = (Element) subXmlItemMan; 
				
				dataResid = subXmlElMan.getAttribute("resid");   //주민번호
				
				if (!dataResid.equals(ye161010VO.getResnRegnNum())) {
					//에러처리 
					return "3"; 
				}
				
				yetaPayr2200Service.PdfYeta2200_AllDelete(ye161010VO);

				//FORM
				for(int i=0;i < xmlItemForm.getLength();i++) { 

					/********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

					/********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   

					subXmlItemForm = xmlItemForm.item(i); 
					subXmlElForm  = (Element) subXmlItemForm;
					
					/** 주민등록번호 일치 여부 확인 종료 */
					
					strFormCd  = subXmlElForm.getAttribute("form_cd"); 
					
					if ((strFormCd.equals("A102Y")) || (strFormCd.equals("A102M"))) {
						 //보장성 보험, 장애인전용보장성보험
						Func_Pdf_A102Y.func_2017_A102Y_A102M(ye161010VO, subXmlElForm, nResult, request);
					
					 } else if ((strFormCd.equals("B101Y")) || (strFormCd.equals("B101D"))) {
							//의료비
							Func_Pdf_B101Y.func_2017_B101Y_B101D(ye161010VO, subXmlElForm, nResult, request);
							
					 } else if ((strFormCd.equals("C101Y")) || (strFormCd.equals("C101M")) || (strFormCd.equals("C102Y")) || (strFormCd.equals("C102M"))) {
							//교육비
							Func_Pdf_C101Y.func_2017_C101Y_C101M(ye161010VO, subXmlElForm, nResult, request);

					} else if ((strFormCd.equals("C202Y")) || (strFormCd.equals("C202M"))) {
					      //직업훈련비	
							Func_Pdf_C202Y.func_2017_C202Y_C202M(ye161010VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("C301Y")) || (strFormCd.equals("C301M"))) {
						  //교복구입비
							Func_Pdf_C301Y.func_2017_C301Y_C301M(ye161010VO, subXmlElForm, nResult, request);
					
					} else if ((strFormCd.equals("D101Y")) || (strFormCd.equals("D101M"))) {
						//개인연금저축
						Func_Pdf_D101Y.func_2017_D101Y_D101M(ye161010VO, subXmlElForm, nResult, request);

					} else if ((strFormCd.equals("E102Y")) || (strFormCd.equals("E102M"))) {
						//연금저축
						Func_Pdf_E102Y.func_2017_E102Y_E102M(ye161010VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("F102Y")) || (strFormCd.equals("F102M"))) {
						//퇴직연금 
						Func_Pdf_F102Y.func_2017_F102Y_F102M(ye161010VO, subXmlElForm, nResult, request);
					
					} else if ((strFormCd.equals("G106Y")) || (strFormCd.equals("G106M"))) {
						//신용카드
						Func_Pdf_G106Y.func_2017_G106Y_G106M(ye161010VO, subXmlElForm, nResult, request);
					} else if ((strFormCd.equals("G206Y")) || (strFormCd.equals("G206M"))) {
					  //현금영수증	
						Func_Pdf_G206Y.func_2017_G206Y_G206M(ye161010VO, subXmlElForm, nResult, request);

					} else if ((strFormCd.equals("G306Y")) || (strFormCd.equals("G306M"))) {
						//직불카드 
						Func_Pdf_G306Y.func_2017_G306Y_G306M(ye161010VO, subXmlElForm, nResult, request);

					} else if ((strFormCd.equals("J101Y")) || (strFormCd.equals("J101M"))) {
						//주택임차차입금원리금상환액
						Func_Pdf_J101Y.func_2017_J101Y_J101M(ye161010VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("J203Y")) || (strFormCd.equals("J203M"))) {
						//장기주택저당차입금이자상환액
						Func_Pdf_J203Y.func_2017_J203Y_J203M(ye161010VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("J301Y")) || (strFormCd.equals("J301M"))) {
						//주책마련저축 
						Func_Pdf_J301Y.func_2017_J301Y_J301M(ye161010VO, subXmlElForm, nResult, request);
						 
					
                    } else if ((strFormCd.equals("K101Y")) || (strFormCd.equals("K101M"))) {
						//소기업소상공인 공제부금 
						Func_Pdf_K101Y.func_2017_K101M(ye161010VO, subXmlElForm, nResult, request);  

					} else if ((strFormCd.equals("L102Y")) || (strFormCd.equals("L102D"))) {
						//기부금
						Func_Pdf_L102Y.func_2017_L102Y_L102D(ye161010VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("N101Y")) || (strFormCd.equals("N101M"))) {
						//장기집합투자증권저축
						Func_Pdf_N101Y.func_2017_N101Y_N101M(ye161010VO, subXmlElForm, nResult, request); 
						
					 } else if ((strFormCd.equals("O101Y")) || (strFormCd.equals("O101M"))) {
					    //건강보험료
						 Func_Pdf_O101Y.func_2017_O101Y_O101M(ye161010VO, subXmlElForm, nResult, request);
						  
					} else if ((strFormCd.equals("P102Y")) || (strFormCd.equals("P102M"))) {
						//국민연금보험료 2017년도귀속
						Func_Pdf_P102Y.func_2017_P102Y_P102M(ye161010VO, subXmlElForm, nResult, request);
						 
					} else if ((strFormCd.equals("C401Y")) || (strFormCd.equals("C401M"))) {
					//학자금대출상환액 
						Func_Pdf_C401Y.func_2017_C401Y_C401M(ye161010VO, subXmlElForm, nResult, request);
					
					} else if ((strFormCd.equals("G104Y")) || (strFormCd.equals("G104M"))) {
						/**+++++++++++신용카드 2016년귀속 삭제 ++++++++++++++++++++++++++++++++++++++++++++*/
						Func_Pdf_G104Y.func_2017_G104Y_G104M(ye161010VO, subXmlElForm, nResult, request);
					
					
					} else if ((strFormCd.equals("G304Y")) || (strFormCd.equals("G304M"))) {
						/**+++++++++++직불카드 2016년귀속 삭제 ++++++++++++++++++++++++++++++++++++++++++++*/
						Func_Pdf_G304Y.func_2017_G304Y_G304M(ye161010VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("G205Y")) || (strFormCd.equals("G205M"))) {
						/**+++++++++++현금영수증 2016년귀속 삭제 ++++++++++++++++++++++++++++++++++++++++++++*/
						Func_Pdf_G205Y.func_2017_G205Y_G205M(ye161010VO, subXmlElForm, nResult, request);
					
					} else if  ((strFormCd.equals("J401Y")) || (strFormCd.equals("J401M")))  {
				          /**+++++++++++ 2017년 귀속분 삭제 2016귀속까지만   목돈 안드는 전세 이자상환액 +++++++++++++++++++++*/
				            // 2014년 신규 추가 테이블필드 완료
				            // 목돈 안드는 전세 이자상환액  - -J401Y 기본  J401M 월별 J04 목돈 안드는 전세이자상환액 본인
					
					} else if ((strFormCd.equals("P101Y")) || (strFormCd.equals("P101M"))) {
						//국민연금보험료 2016년도귀속
						Func_Pdf_P101Y.func_2017_P101Y_P101M(ye161010VO, subXmlElForm, nResult, request);
							
					}
					

				}
				
				// 간소화 파일 정산 반영부 체크에 따른 루틴 실행하기 
			    if (Boolean.TRUE.equals(Boolean.parseBoolean(ye161010VO.getStlRflSttChkYn()))) {
			    	
			    	Func_PdfXml_Yeta2017_Insert funcPdfXmlYeta2017Insert = new Func_PdfXml_Yeta2017_Insert();
			    	ye161010VO.setXmlFormCd("ALL");
			    	funcPdfXmlYeta2017Insert.pdfXml_Yeta2017_Insert(ye161010VO,request);
			    	
			    } 
				
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.toString());
			}

		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		
		return "1";

		// showMessage('PDF 전자문서 저장이 완료 되었습니다.');
	}
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 소득공제신고서 
	 * 2. 처리내용 : 소득공제신고서
	 * </pre>
	 * @Method Name : PayrDdcXmlDataInsert
	 * @date : 2018. 1. 17.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 17.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param ye161010VO
	 * @param xmlDoc
	 * @param request
	 * @return
	 */
	public String PayrDdcXmlDataInsert(InfcPkgYe161010VO ye161010VO, Document xmlDoc, HttpServletRequest request) {
		
		Node xmlItemDoc = null;
		Element  xmlItemMain  = null;
		Element  xmlelDoc  = null;
		
		NodeList xmlItemForm = null;
		
		Node subXmlItemForm = null;
		Element  subXmlElForm = null; 
		
		String dataType = "";
		String dataPrDate  = "";
		String dataYear = "";
		String dataResid = "";
		
		String  strFormCd  = "";
		String strDatCd = "";
		String strSum = "";
		
		//pdf 디비에 업데이트 후 에러여부판별
		String strReturnPdfCheck = "ok";
		
		try {
			try {
				
				// FileName := 'C:\EOSDATA\2015\' + trim(lblFILE_SAVE.Caption) + '_' + trim(edKORN_NAME.Text); // + '.xml';
				// Memo_XML_EUC_KR.Lines.Clear;
				//  Memo_XML_EUC_KR.Lines.LoadFromFile(ChangeFileExt(FileName, '.xml'));
				//  CONNXML.LoadFromFile(ChangeFileExt(FileName, '.xml'));
				// CONNXML.Root.AsString := Memo_XML_EUC_KR.Lines.Text;
				// ecxmlPdf.LoadFromFile(FileName);
				xmlItemMain = xmlDoc.getDocumentElement();
				
				xmlItemDoc = xmlItemMain.getElementsByTagName("doc").item(0); 
				xmlelDoc = (Element)xmlItemDoc;	 
				
				dataType = PkgFuncUtils.getXmlTagValue("doc_type", xmlelDoc);    //문서종류   
				dataPrDate =  PkgFuncUtils.getXmlTagValue("seq", xmlelDoc); //일련번호 
				dataYear = PkgFuncUtils.getXmlTagValue("att_year", xmlelDoc);   //귀속년도 
				dataResid = PkgFuncUtils.getXmlTagValue("att_Resid", xmlelDoc);   //주민등록번호
				
				if (!dataYear.equals("2017")) {
					//에러처리 
					return "2"; 
				}
				
				if (!dataResid.equals(ye161010VO.getResnRegnNum())) {
					//에러처리 
					return "3"; 
				}
				
				xmlItemForm =  xmlItemMain.getElementsByTagName("form");    
				//FORM
				for(int i=0;i < xmlItemForm.getLength();i++) { 
					
					/********************************************************암호화 처리 를 위해 반드시 해야 함................................*/
					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
					
					/********************************************************암호화 처리 를 위해 반드시 해야 함................................*/   
					
					subXmlItemForm = xmlItemForm.item(i); 
					subXmlElForm  = (Element) subXmlItemForm;
					
					strFormCd  = subXmlElForm.getAttribute("form_cd"); 
				 
					 
					if (strFormCd.equals("A101Y")) {
						Func_Pdf_DDC_A101Y.func_2017_A101Y(ye161010VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					else if (strFormCd.equals("B101Y")) {
						Func_Pdf_DDC_B101Y.func_2017_B101Y(ye161010VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					else if (strFormCd.equals("C101Y")) {
						Func_Pdf_DDC_C101Y.func_2017_C101Y(ye161010VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					else if (strFormCd.equals("D101Y")) {
						Func_Pdf_DDC_D101Y.func_2017_D101Y(ye161010VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					else if (strFormCd.equals("E101Y")) {
						Func_Pdf_DDC_E101Y.func_2017_E101Y(ye161010VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					else if (strFormCd.equals("F101Y")) {
						Func_Pdf_DDC_F101Y.func_2017_F101Y(ye161010VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					
					
				}
				
				/**********************************************************************************************************************
				 * 처리 완료 후 자동으로 업데이트 하는 메서드 
				 * 메시지로 기존에 등록된 자료 삭제됨을 알려주는 메서드 작성 
				 ***********************************************************************************************************************/
				Func_PdfInDdc_Yeta2017_Insert funcPdfInDdc = new Func_PdfInDdc_Yeta2017_Insert();
				strReturnPdfCheck = funcPdfInDdc.pdfInDdc_Yeta2017_Insert(ye161010VO, request);
				
				
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println(e.toString());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		
		return "1";
		
		// showMessage('PDF 전자문서 저장이 완료 되었습니다.');
	}



}
