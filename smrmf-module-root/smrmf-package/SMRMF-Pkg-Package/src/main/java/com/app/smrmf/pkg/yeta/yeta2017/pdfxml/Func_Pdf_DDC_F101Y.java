package com.app.smrmf.pkg.yeta.yeta2017.pdfxml;

import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167510VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167520VO;
import com.app.smrmf.pkg.yeta.yeta2017.pdfxml.service.Yeta2200XmlService;

public class Func_Pdf_DDC_F101Y {

	@Resource(name = "Yeta2200XmlService")
	private static Yeta2200XmlService yetaPayr2200Service;

	private static NodeList subXmlElChildForm = null;
	private static Node subXmlItemMan = null;
	private static NodeList subXmlElChildMan = null;
	private static Element subXmlElMan = null;
	private static Node subXmlItemData = null;
	private static Element subXmlElData = null;

	private static String strNnfCl= "";
	
	private static String strFnm = "";
	private static String strResno = "";
	private static String strTnm = "";				
	private static String strBsnoEncCntn = "";	
	
	private static String strFormCd  = "";

	public static void func_2017_F101Y(InfcPkgYe161010VO ye161010Vo, Element  xmlelDoc, Element  subXmlElForm, String nResult, HttpServletRequest request) throws Exception{ 

		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 

		}
		InfcPkgYe167510VO ye167510Vo = new InfcPkgYe167510VO();
		InfcPkgYe167520VO ye167520Vo = new InfcPkgYe167520VO();
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		
		//인원별 반복구간
		for (int j = 0; j < subXmlElChildForm.getLength();j++) { 

			subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			subXmlElMan  = (Element) subXmlItemMan;

			strTnm = subXmlElMan.getAttribute("tnm");   //근무처명칭				
			strBsnoEncCntn = subXmlElMan.getAttribute("bsnoEncCntn");   //사업자등록번호
			strFnm = subXmlElMan.getAttribute("fnm");	//이름
			strResno = subXmlElMan.getAttribute("resno");   //주민번호
			
//			String strValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResno).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			
			/** -------------------------------- 초기화 작업 시작 ------------------------------------*/
			ye167510Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167510Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167510Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167510Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr2200Service.yeta2200_PDF_YE167510_2017_Delete(ye167510Vo);	//기본정보 삭제
			
			ye167520Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167520Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167520Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167520Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr2200Service.yeta2200_PDF_YE167520_2017_Delete(ye167520Vo);	//인적공제 삭제	
			
			/** -------------------------------- 초기화 작업 종료 ------------------------------------*/
			
			ye167510Vo.setFormCd(strFormCd);
			ye167510Vo.setTnm(strTnm);
			ye167510Vo.setBsnoEncCntn(strBsnoEncCntn);
			ye167510Vo.setFnm(strFnm);
			ye167510Vo.setResno(strResno);    /** column 생년월일 : resno */ 
			
			ye167510Vo.setTdmrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("tdmrDdcAmt"),"0")));    /** column 전통시장사용분공제금액 : tdmrDdcAmt */
			ye167510Vo.setPbtDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pbtDdcAmt"),"0")));    /** column 대중교통이용분공제금액 : pbtDdcAmt */
			ye167510Vo.setDrtpCardDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("drtpCardDdcAmt"),"0")));    /** column 직불카드등사용분공제금액 : drtpCardDdcAmt */
			ye167510Vo.setTotaSnwAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("totaSnwAmt"),"0")));    /** column 공제제외금액계산총급여액 : totaSnwAmt */
			ye167510Vo.setMinmUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("minmUseAmt"),"0")));    /** column 공제제외금액계산최저사용금액 : minmUseAmt */
			
			ye167510Vo.setDdcExclAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ddcExclAmt"),"0")));    /** column 공제제외금액계산공제제외금액 : ddcExclAmt */
			ye167510Vo.setDdcPsbAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ddcPsbAmt"),"0")));    /** column 공제가능금액 : ddcPsbAmt */
			ye167510Vo.setDdcLmtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ddcLmtAmt"),"0")));    /** column 공제한도액 : ddcLmtAmt */
			ye167510Vo.setGnrlDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("gnrlDdcAmt"),"0")));    /** column 일반공제금액 : gnrlDdcAmt */
			
			ye167510Vo.setTdmrAddDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("tdmrAddDdcAmt"),"0")));    /** column 전통시장추가공제금액 : tdmrAddDdcAmt */
			ye167510Vo.setPbtAddDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pbtAddDdcAmt"),"0")));    /** column 대중교통추가공제금액 : pbtAddDdcAmt */
			ye167510Vo.setLstDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("lstDdcAmt"),"0")));    /** column 최종공제금액 : lstDdcAmt */
			
			ye167510Vo.setKybdr(sessionUser.getUsrId());
			ye167510Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			ye167510Vo.setIsmt(sessionUser.getUsrId());
			ye167510Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			yetaPayr2200Service.yeta2200_PDF_YE167510_2017_Insert(ye167510Vo);	//기본정보 입력
			
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");

			//상품별 반복구간
			for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
				System.out.println("길이 :" + subXmlElChildMan.getLength());
				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				
				strNnfCl = subXmlElData.getAttribute("nnfCl"); 
				
				if (!strNnfCl.equals("")) { // 공제 대상자 및 신용 카드등 사용 금액 명세 반복 구간
					setYe167520Vo(ye167520Vo, request);
				}
			}

		}

	}
	
	public static void setYe167520Vo(InfcPkgYe167520VO ye167520Vo , HttpServletRequest request) throws Exception{

		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167520Vo.setNnfCl(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("nnfCl")));    /** column 공제대상자내외국인 : nnfCl */
		ye167520Vo.setSuptFmlyRltCl(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("suptFmlyRltCl")));    /** column 공제대상자관계 : suptFmlyRltCl */
		ye167520Vo.setSuptFmlyFnm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("suptFmlyFnm")));    /** column 공제대상자성명 : suptFmlyFnm */
		ye167520Vo.setSuptFmlyBhdt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("suptFmlyBhdt")));    /** column 공제대상자생년월일 : suptFmlyBhdt */
		ye167520Vo.setFamResnoEncCntn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("famResnoEncCntn")));    /** column 공제대상자가족주민등록번호 : famResnoEncCntn */
		
		ye167520Vo.setDataCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("yrsMateClCd")));    /** column 자료구분 : dataCd */
		ye167520Vo.setCrdcUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("crdcUseAmtSum"),"0")));    /** column 신용카드등사용금액소계 : crdcUseAmtSum */
		ye167520Vo.setCrdcUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("crdcUseAmt"),"0")));    /** column 신용카드등사용금액_신용카드 : crdcUseAmt */
		ye167520Vo.setCshptUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("cshptUseAmt"),"0")));    /** column 신용카드등사용금액_현금영수증 : cshptUseAmt */
		ye167520Vo.setDrtpCardUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("drtpCardUseAmt"),"0")));    /** column 신용카드등사용금액_직불선불카등등 : drtpCardUseAmt */
		
		ye167520Vo.setTdmrUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("tdmrUseAmt"),"0")));    /** column 신용카드등사용금액_전통시장사용분 : tdmrUseAmt */
		ye167520Vo.setEtcUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("etcUseAmt"),"0")));    /** column 신용카드등사용금액_대중교통이용분 : etcUseAmt */

		ye167520Vo.setKybdr(sessionUser.getUsrId());
		ye167520Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167520Vo.setIsmt(sessionUser.getUsrId());
		ye167520Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr2200Service.yeta2200_PDF_YE167520_2017_Insert(ye167520Vo);	//기본정보 입력
	}
	
}
