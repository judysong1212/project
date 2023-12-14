package com.app.smrmf.pkg.yeta.yeta2018.pdfxml;

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
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.egov.comutils.payr.PkgFuncUtils;
import com.app.smrmf.infc.yearendtax.server.service.yeta2018.service.InfcPkgYeta3200Service;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161010_2018_VO;
import com.app.smrmf.pkg.yeta.yeta2018.pdfxml.service.Yeta3200XmlService;
import com.link.xecuredb.service.XecureNative;

import egovframework.rte.fdl.property.EgovPropertyService;
//import com.app.smrmf.props.ExtermsProps;

@Controller
public class Yeta3200PkgXmlController {


	private static final Logger logger = LoggerFactory.getLogger(Yeta3200PkgXmlController.class);
	
	@Resource(name = "InfcPkgYeta3200Service")
	private InfcPkgYeta3200Service yeta3200Service;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	@Resource(name = "Yeta3200XmlService")
	private Yeta3200XmlService yetaPayr3200Service;

	public Yeta3200PkgXmlController() {
    	
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
	 * @param ye161010_2018_VO
	 * @param xmlDoc
	 * @param request
	 * @return
	 */
	public String PayrXmlDataInsert(InfcPkgYe161010_2018_VO ye161010_2018_VO, Document xmlDoc, HttpServletRequest request) {
		
		yetaPayr3200Service = (Yeta3200XmlService)BeanFinder.getBean("Yeta3200XmlService");

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
				
				if (!dataYear.equals("2018")) {
System.out.println("===============================================");
System.out.println("해당년도 아님");
System.out.println("===============================================");
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
//				String nResult11 = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				if (!dataResid.equals(ye161010_2018_VO.getResnRegnNum())) {
System.out.println("===============================================");
System.out.println("주민번호 pdf ["+dataResid);
System.out.println("주민번호 db  ["+ye161010_2018_VO.getResnRegnNum());
System.out.println("===============================================");
					//에러처리 
					return "3"; 
				}
				
				yetaPayr3200Service.PdfYeta3200_AllDelete(ye161010_2018_VO);

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
						Func2018_Pdf_A102Y.func_2018_A102Y_A102M(ye161010_2018_VO, subXmlElForm, nResult, request);
					
					 } else if ((strFormCd.equals("B101Y")) || (strFormCd.equals("B101D"))) {
							//의료비
							Func2018_Pdf_B101Y.func_2018_B101Y_B101D(ye161010_2018_VO, subXmlElForm, nResult, request);
							
					 } else if ((strFormCd.equals("C101Y")) || (strFormCd.equals("C101M")) || (strFormCd.equals("C102Y")) || (strFormCd.equals("C102M"))) {
							//교육비
							Func2018_Pdf_C101Y.func_2018_C101Y_C101M(ye161010_2018_VO, subXmlElForm, nResult, request);

					} else if ((strFormCd.equals("C202Y")) || (strFormCd.equals("C202M"))) {
					      //직업훈련비	
							Func2018_Pdf_C202Y.func_2018_C202Y_C202M(ye161010_2018_VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("C301Y")) || (strFormCd.equals("C301M"))) {
						  //교복구입비
							Func2018_Pdf_C301Y.func_2018_C301Y_C301M(ye161010_2018_VO, subXmlElForm, nResult, request);
					
					} else if ((strFormCd.equals("D101Y")) || (strFormCd.equals("D101M"))) {
						//개인연금저축
						Func2018_Pdf_D101Y.func_2018_D101Y_D101M(ye161010_2018_VO, subXmlElForm, nResult, request);

					} else if ((strFormCd.equals("E102Y")) || (strFormCd.equals("E102M"))) {
						//연금저축
						Func2018_Pdf_E102Y.func_2018_E102Y_E102M(ye161010_2018_VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("F102Y")) || (strFormCd.equals("F102M"))) {
						//퇴직연금 
						Func2018_Pdf_F102Y.func_2018_F102Y_F102M(ye161010_2018_VO, subXmlElForm, nResult, request);
					
					} else if ((strFormCd.equals("G107Y")) || (strFormCd.equals("G107M"))) {
						//신용카드
						
						Func2018_Pdf_G107Y.func_2018_G107Y_G107M(ye161010_2018_VO, subXmlElForm, nResult, request);
					} else if ((strFormCd.equals("G207Y")) || (strFormCd.equals("G207M"))) {
					  //현금영수증	
						Func2018_Pdf_G207Y.func_2018_G207Y_G207M(ye161010_2018_VO, subXmlElForm, nResult, request);

					} else if ((strFormCd.equals("G307Y")) || (strFormCd.equals("G307M"))) {
						//직불카드 
						Func2018_Pdf_G307Y.func_2018_G307Y_G307M(ye161010_2018_VO, subXmlElForm, nResult, request);

					} else if ((strFormCd.equals("J101Y")) || (strFormCd.equals("J101M"))) {
						//주택임차차입금원리금상환액
						Func2018_Pdf_J101Y.func_2018_J101Y_J101M(ye161010_2018_VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("J203Y")) || (strFormCd.equals("J203M"))) {
						//장기주택저당차입금이자상환액
						Func2018_Pdf_J203Y.func_2018_J203Y_J203M(ye161010_2018_VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("J301Y")) || (strFormCd.equals("J301M"))) {
						//주책마련저축 
						Func2018_Pdf_J301Y.func_2018_J301Y_J301M(ye161010_2018_VO, subXmlElForm, nResult, request);
						 
					
                    } else if ((strFormCd.equals("K101Y")) || (strFormCd.equals("K101M"))) {
						//소기업소상공인 공제부금 
						Func2018_Pdf_K101Y.func_2018_K101M(ye161010_2018_VO, subXmlElForm, nResult, request);  

					} else if ((strFormCd.equals("L102Y")) || (strFormCd.equals("L102D"))) {
						//기부금
						Func2018_Pdf_L102Y.func_2018_L102Y_L102D(ye161010_2018_VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("N101Y")) || (strFormCd.equals("N101M"))) {
						//장기집합투자증권저축
						Func2018_Pdf_N101Y.func_2018_N101Y_N101M(ye161010_2018_VO, subXmlElForm, nResult, request); 
						
					 } else if ((strFormCd.equals("O101Y")) || (strFormCd.equals("O101M"))) {
					    //건강보험료
						 Func2018_Pdf_O101Y.func_2018_O101Y_O101M(ye161010_2018_VO, subXmlElForm, nResult, request);
						  
					} else if ((strFormCd.equals("P102Y")) || (strFormCd.equals("P102M"))) {
						//국민연금보험료 2017년도귀속
						Func2018_Pdf_P102Y.func_2018_P102Y_P102M(ye161010_2018_VO, subXmlElForm, nResult, request);
						 
					} else if ((strFormCd.equals("C401Y")) || (strFormCd.equals("C401M"))) {
					//학자금대출상환액 
						Func2018_Pdf_C401Y.func_2018_C401Y_C401M(ye161010_2018_VO, subXmlElForm, nResult, request);
					
					} else if ((strFormCd.equals("G104Y")) || (strFormCd.equals("G104M"))) {
						/**+++++++++++신용카드 2016년귀속 삭제 ++++++++++++++++++++++++++++++++++++++++++++*/
						Func2018_Pdf_G104Y.func_2018_G104Y_G104M(ye161010_2018_VO, subXmlElForm, nResult, request);
					
					
					} else if ((strFormCd.equals("G304Y")) || (strFormCd.equals("G304M"))) {
						/**+++++++++++직불카드 2016년귀속 삭제 ++++++++++++++++++++++++++++++++++++++++++++*/
						Func2018_Pdf_G304Y.func_2018_G304Y_G304M(ye161010_2018_VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("G205Y")) || (strFormCd.equals("G205M"))) {
						/**+++++++++++현금영수증 2016년귀속 삭제 ++++++++++++++++++++++++++++++++++++++++++++*/
						Func2018_Pdf_G205Y.func_2018_G205Y_G205M(ye161010_2018_VO, subXmlElForm, nResult, request);
					
					} else if  ((strFormCd.equals("J401Y")) || (strFormCd.equals("J401M")))  {
				          /**+++++++++++ 2017년 귀속분 삭제 2016귀속까지만   목돈 안드는 전세 이자상환액 +++++++++++++++++++++*/
				            // 2014년 신규 추가 테이블필드 완료
				            // 목돈 안드는 전세 이자상환액  - -J401Y 기본  J401M 월별 J04 목돈 안드는 전세이자상환액 본인
					
					} else if ((strFormCd.equals("P101Y")) || (strFormCd.equals("P101M"))) {
						//국민연금보험료 2016년도귀속
						Func2018_Pdf_P101Y.func_2018_P101Y_P101M(ye161010_2018_VO, subXmlElForm, nResult, request);
							
						
					} else if ((strFormCd.equals("G106Y")) || (strFormCd.equals("G106M"))) {
						//2017 삭제 - 신용카드
						Func2018_Pdf_G106Y.func_2018_G106Y_G106M(ye161010_2018_VO, subXmlElForm, nResult, request);
					} else if ((strFormCd.equals("G206Y")) || (strFormCd.equals("G206M"))) {
					  //2017 삭제 - 현금영수증	
						Func2018_Pdf_G206Y.func_2018_G206Y_G206M(ye161010_2018_VO, subXmlElForm, nResult, request);

					} else if ((strFormCd.equals("G306Y")) || (strFormCd.equals("G306M"))) {
						//2017 - 삭제 직불카드 
						Func2018_Pdf_G306Y.func_2018_G306Y_G306M(ye161010_2018_VO, subXmlElForm, nResult, request);
					}
					

				}
				
				// 간소화 파일 정산 반영부 체크에 따른 루틴 실행하기 
			    if (Boolean.TRUE.equals(Boolean.parseBoolean(ye161010_2018_VO.getStlRflSttChkYn()))) {
			    	
			    	Func_PdfXml_Yeta2018_Insert funcPdfXmlYeta3017Insert = new Func_PdfXml_Yeta2018_Insert();
			    	ye161010_2018_VO.setXmlFormCd("ALL");
			    	funcPdfXmlYeta3017Insert.pdfXml_Yeta2018_Insert(ye161010_2018_VO,request);
			    	
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
	 * @param ye161010_2018_VO
	 * @param xmlDoc
	 * @param request
	 * @return
	 */
	public String PayrDdcXmlDataInsert(InfcPkgYe161010_2018_VO ye161010_2018_VO, Document xmlDoc, HttpServletRequest request) {
		
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
				
				if (!dataYear.equals("2018")) {
					//에러처리 
					return "2"; 
				}
				
				if (!dataResid.equals(ye161010_2018_VO.getResnRegnNum())) {
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
						Func2018_Pdf_DDC_A101Y.func_2018_A101Y(ye161010_2018_VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					else if (strFormCd.equals("B101Y")) {
						Func2018_Pdf_DDC_B101Y.func_2018_B101Y(ye161010_2018_VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					else if (strFormCd.equals("C101Y")) {
						Func2018_Pdf_DDC_C101Y.func_2018_C101Y(ye161010_2018_VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					else if (strFormCd.equals("D101Y")) {
						Func2018_Pdf_DDC_D101Y.func_2018_D101Y(ye161010_2018_VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					else if (strFormCd.equals("E101Y")) {
						Func2018_Pdf_DDC_E101Y.func_2018_E101Y(ye161010_2018_VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					else if (strFormCd.equals("F101Y")) {
						Func2018_Pdf_DDC_F101Y.func_2018_F101Y(ye161010_2018_VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					
					
				}
				
				/**********************************************************************************************************************
				 * 처리 완료 후 자동으로 업데이트 하는 메서드 
				 * 메시지로 기존에 등록된 자료 삭제됨을 알려주는 메서드 작성 
				 ***********************************************************************************************************************/
				Func_PdfInDdc_Yeta2018_Insert funcPdfInDdc = new Func_PdfInDdc_Yeta2018_Insert();
				strReturnPdfCheck = funcPdfInDdc.pdfInDdc_Yeta2018_Insert(ye161010_2018_VO, request);
				
				
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
