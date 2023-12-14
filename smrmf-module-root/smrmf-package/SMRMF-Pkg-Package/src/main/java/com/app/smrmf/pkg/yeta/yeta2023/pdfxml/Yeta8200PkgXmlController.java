package com.app.smrmf.pkg.yeta.yeta2023.pdfxml;

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
import com.app.smrmf.infc.yearendtax.server.service.yeta2023.service.InfcPkgYeta8200Service;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161010_2023_VO;
import com.app.smrmf.pkg.yeta.yeta2023.pdfxml.Func2023_Pdf_B201Y;
import com.app.smrmf.pkg.yeta.yeta2023.pdfxml.Func2023_Pdf_J501Y;
import com.app.smrmf.pkg.yeta.yeta2023.pdfxml.Func2023_Pdf_Q101Y;
import com.app.smrmf.pkg.yeta.yeta2023.pdfxml.Func2023_Pdf_Q201Y;
import com.app.smrmf.pkg.yeta.yeta2023.pdfxml.service.Yeta8200XmlService;
import com.link.xecuredb.service.XecureNative;

import egovframework.rte.fdl.property.EgovPropertyService;
//import com.app.smrmf.props.ExtermsProps;

@Controller
public class Yeta8200PkgXmlController {


	private static final Logger logger = LoggerFactory.getLogger(Yeta8200PkgXmlController.class);
	
	@Resource(name = "InfcPkgYeta8200Service")
	private InfcPkgYeta8200Service yeta8200Service;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	@Resource(name = "Yeta8200XmlService")
	private Yeta8200XmlService yetaPayr3200Service;

	public Yeta8200PkgXmlController() {
    	
    }

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 연말정산간소화 전자파일 
	 * 2. 처리내용 : 연말정산간소화 전자파일 
	 * </pre>
	 * @Method Name : PayrXmlDataInsert
	 * @date : 2023. 1. 17.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2023. 1. 17.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param ye161010_2023_VO
	 * @param xmlDoc
	 * @param request
	 * @return
	 */
	public String PayrXmlDataInsert(InfcPkgYe161010_2023_VO ye161010_2023_VO, Document xmlDoc, HttpServletRequest request) {
		
		yetaPayr3200Service = (Yeta8200XmlService)BeanFinder.getBean("Yeta8200XmlService");

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
				
				
				if (!dataYear.equals("2022")) {
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
				
				
				if (!dataResid.equals(ye161010_2023_VO.getResnRegnNum())) {
					System.out.println("===============================================");
					System.out.println("주민번호 pdf ["+dataResid);
					System.out.println("주민번호 db  ["+ye161010_2023_VO.getResnRegnNum());
					System.out.println("===============================================");
					//에러처리 
					
					
					return "3"; 
				}
				
				
				yetaPayr3200Service.PdfYeta8200_AllDelete(ye161010_2023_VO);
				
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
						Func2023_Pdf_A102Y.func_2023_A102Y_A102M(ye161010_2023_VO, subXmlElForm, nResult, request);
					
					 } else if ((strFormCd.equals("B101Y")) || (strFormCd.equals("B101D"))) {
							//의료비
							Func2023_Pdf_B101Y.func_2023_B101Y_B101D(ye161010_2023_VO, subXmlElForm, nResult, request);
							
					 } else if ((strFormCd.equals("B201Y")) || (strFormCd.equals("B201M"))){
						 	//실손보험금 추가_20201210
						 	Func2023_Pdf_B201Y.func_2023_B201Y_B201M(ye161010_2023_VO, subXmlElForm, nResult, request);
						 
						 	//2023연말정산_기존 C101Y,C101M에서 변경
					 } else if ((strFormCd.equals("C102Y")) || (strFormCd.equals("C102M"))) {
							//교육비
							Func2023_Pdf_C101Y.func_2023_C101Y_C101M(ye161010_2023_VO, subXmlElForm, nResult, request);

					} else if ((strFormCd.equals("C202Y")) || (strFormCd.equals("C202M"))) {
					      //직업훈련비	
							Func2023_Pdf_C202Y.func_2023_C202Y_C202M(ye161010_2023_VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("C301Y")) || (strFormCd.equals("C301M"))) {
						  //교복구입비
							Func2023_Pdf_C301Y.func_2023_C301Y_C301M(ye161010_2023_VO, subXmlElForm, nResult, request);
					
					} else if ((strFormCd.equals("D101Y")) || (strFormCd.equals("D101M"))) {
						//개인연금저축
						Func2023_Pdf_D101Y.func_2023_D101Y_D101M(ye161010_2023_VO, subXmlElForm, nResult, request);

					} else if ((strFormCd.equals("E103Y")) || (strFormCd.equals("E103M"))) {
						//연금저축
						Func2023_Pdf_E102Y.func_2023_E102Y_E102M(ye161010_2023_VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("F103Y")) || (strFormCd.equals("F103M"))) {
						//퇴직연금 
						Func2023_Pdf_F102Y.func_2023_F102Y_F102M(ye161010_2023_VO, subXmlElForm, nResult, request);
					
					} else if ((strFormCd.equals("G110Y")) || (strFormCd.equals("G110M"))) {
						//신용카드
						Func2023_Pdf_G107Y.func_2023_G107Y_G107M(ye161010_2023_VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("G210Y")) || (strFormCd.equals("G210M"))) {
					  //현금영수증	
						Func2023_Pdf_G207Y.func_2023_G207Y_G207M(ye161010_2023_VO, subXmlElForm, nResult, request);

					} else if ((strFormCd.equals("G310Y")) || (strFormCd.equals("G310M"))) {
						//직불카드 
						Func2023_Pdf_G307Y.func_2023_G307Y_G307M(ye161010_2023_VO, subXmlElForm, nResult, request);

					} else if ((strFormCd.equals("G410Y")) || (strFormCd.equals("G410M"))) {
						//제로페이 
						Func2023_Pdf_G407Y.func_2023_G407Y_G407M(ye161010_2023_VO, subXmlElForm, nResult, request);

					}else if ((strFormCd.equals("J101Y")) || (strFormCd.equals("J101M"))) {
						//주택임차차입금원리금상환액
						Func2023_Pdf_J101Y.func_2023_J101Y_J101M(ye161010_2023_VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("J203Y")) || (strFormCd.equals("J203M"))) {
						//장기주택저당차입금이자상환액
						Func2023_Pdf_J203Y.func_2023_J203Y_J203M(ye161010_2023_VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("J301Y")) || (strFormCd.equals("J301M"))) {
						//주책마련저축 
						Func2023_Pdf_J301Y.func_2023_J301Y_J301M(ye161010_2023_VO, subXmlElForm, nResult, request);
					
					} else if ((strFormCd.equals("J501Y")) || (strFormCd.equals("J501M"))){
                    	//월세액 추가20201215
                    	Func2023_Pdf_J501Y.func_2023_J501Y_J501M(ye161010_2023_VO, subXmlElForm, nResult, request);
                    		 
                    
					} else if ((strFormCd.equals("Q101Y")) || (strFormCd.equals("Q101M"))){
                    	//2021연말정산_밴처기업투자신탁 추가20201216
                    	Func2023_Pdf_Q101Y.func_2023_Q101Y_Q101M(ye161010_2023_VO, subXmlElForm, nResult, request);
                    	
                    } else if ((strFormCd.equals("Q201Y")) || (strFormCd.equals("Q201M"))){
                    	//2021연말정산_밴처기업투자신탁(전년도납입분) 추가20201216
                    	Func2023_Pdf_Q201Y.func_2023_Q201Y_Q201M(ye161010_2023_VO, subXmlElForm, nResult, request);
                    	
                    } else if ((strFormCd.equals("Q301Y")) || (strFormCd.equals("Q301M"))){
                    	//2021연말정산_밴처기업투자신탁(전전년도납입분) 추가20201216
                    	Func2023_Pdf_Q301Y.func_2023_Q301Y_Q301M(ye161010_2023_VO, subXmlElForm, nResult, request);
					
					} else if ((strFormCd.equals("K101Y")) || (strFormCd.equals("K101M"))) {
						//소기업소상공인 공제부금 
						Func2023_Pdf_K101Y.func_2023_K101M(ye161010_2023_VO, subXmlElForm, nResult, request);  

					} else if ((strFormCd.equals("L102Y")) || (strFormCd.equals("L102D"))) {
						//기부금
						Func2023_Pdf_L102Y.func_2023_L102Y_L102D(ye161010_2023_VO, subXmlElForm, nResult, request);
						
					} else if ((strFormCd.equals("N102Y")) || (strFormCd.equals("N102M"))) {
						//장기집합투자증권저축
						Func2023_Pdf_N101Y.func_2023_N101Y_N101M(ye161010_2023_VO, subXmlElForm, nResult, request); 
						
					 } else if ((strFormCd.equals("O101Y")) || (strFormCd.equals("O101M"))) {
					    //건강보험료
						 Func2023_Pdf_O101Y.func_2023_O101Y_O101M(ye161010_2023_VO, subXmlElForm, nResult, request);
						  
					} else if ((strFormCd.equals("P102Y")) || (strFormCd.equals("P102M"))) {
						//국민연금보험료
						Func2023_Pdf_P102Y.func_2023_P102Y_P102M(ye161010_2023_VO, subXmlElForm, nResult, request);
						 
					} else if ((strFormCd.equals("C401Y")) || (strFormCd.equals("C401M"))) {
					//학자금대출상환액 
						Func2023_Pdf_C401Y.func_2023_C401Y_C401M(ye161010_2023_VO, subXmlElForm, nResult, request);
					
						//2023 연말정산_추가 장애인증명자료
					} /*else if((strFormCd.equals("R101Y")) || (strFormCd.equals("R101M"))){
						//장애인증명자료
						Func2023_Pdf_R101M.func_2023_R101Y_R101M(ye161010_2023_VO, subXmlElForm, nResult, request);
					}*/

				}
				
				// 간소화 파일 정산 반영부 체크에 따른 루틴 실행하기 
			    if (Boolean.TRUE.equals(Boolean.parseBoolean(ye161010_2023_VO.getStlRflSttChkYn()))) {
			    	
			    	Func_PdfXml_Yeta2023_Insert funcPdfXmlYeta3017Insert = new Func_PdfXml_Yeta2023_Insert();
			    	ye161010_2023_VO.setXmlFormCd("ALL");
			    	funcPdfXmlYeta3017Insert.pdfXml_Yeta2023_Insert(ye161010_2023_VO,request);
			    	
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
	 * @date : 2023. 1. 17.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2023. 1. 17.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param ye161010_2023_VO
	 * @param xmlDoc
	 * @param request
	 * @return
	 */
	public String PayrDdcXmlDataInsert(InfcPkgYe161010_2023_VO ye161010_2023_VO, Document xmlDoc, HttpServletRequest request) {
		
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
				
				if (!dataYear.equals("2023")) {
					//에러처리 
					return "2"; 
				}
				
				if (!dataResid.equals(ye161010_2023_VO.getResnRegnNum())) {
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
						Func2023_Pdf_DDC_A101Y.func_2023_A101Y(ye161010_2023_VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					else if (strFormCd.equals("B101Y")) {
						Func2023_Pdf_DDC_B101Y.func_2023_B101Y(ye161010_2023_VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					else if (strFormCd.equals("C101Y")) {
						Func2023_Pdf_DDC_C101Y.func_2023_C101Y(ye161010_2023_VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					else if (strFormCd.equals("D101Y")) {
						Func2023_Pdf_DDC_D101Y.func_2023_D101Y(ye161010_2023_VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					else if (strFormCd.equals("E101Y")) {
						Func2023_Pdf_DDC_E101Y.func_2023_E101Y(ye161010_2023_VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					else if (strFormCd.equals("F101Y")) {
						Func2023_Pdf_DDC_F101Y.func_2023_F101Y(ye161010_2023_VO, xmlelDoc, subXmlElForm, nResult, request);
					}
					
					
				}
				
				/**********************************************************************************************************************
				 * 처리 완료 후 자동으로 업데이트 하는 메서드 
				 * 메시지로 기존에 등록된 자료 삭제됨을 알려주는 메서드 작성 
				 ***********************************************************************************************************************/
				Func_PdfInDdc_Yeta2023_Insert funcPdfInDdc = new Func_PdfInDdc_Yeta2023_Insert();
				strReturnPdfCheck = funcPdfInDdc.pdfInDdc_Yeta2023_Insert(ye161010_2023_VO, request);
				
				
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
