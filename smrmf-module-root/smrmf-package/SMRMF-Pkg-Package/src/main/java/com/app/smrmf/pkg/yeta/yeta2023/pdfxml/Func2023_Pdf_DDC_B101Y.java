package com.app.smrmf.pkg.yeta.yeta2023.pdfxml;

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
import com.app.smrmf.egov.comutils.payr.PkgFuncUtils;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167110_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167120_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167130_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167140_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe167150_2023_VO;
import com.app.smrmf.pkg.yeta.yeta2023.pdfxml.service.Yeta8200XmlService;

public class Func2023_Pdf_DDC_B101Y {

	@Resource(name = "Yeta8200XmlService")
	private static Yeta8200XmlService yetaPayr3200Service;

	private static NodeList subXmlElChildForm = null;
	private static Node subXmlItemMan = null;
	private static NodeList subXmlElChildMan = null;
	private static Element subXmlElMan = null;
	private static Node subXmlItemData = null;
	private static Element subXmlElData = null;

	private static String strRtpnAccRtpnCl = "";
	private static String strPnsnSvngAccPnsnSvngCl = "";
	private static String strHsngPrptSvngSvngCl = "";
	private static String strLtrmCniSsfnnOrgnCd = "";
	
	private static String strFnm = "";
	private static String strResnoEncCntn = "";
	private static String strTnm = "";				
	private static String strBsnoEncCntn = "";	
	
	private static String strAdr= "";	
	private static String strPfbAdr = "";		 
	private static String strFormCd  = "";

	public static void func_2023_B101Y(InfcPkgYe161010_2023_VO ye161010Vo, Element  xmlelDoc, Element  subXmlElForm, String nResult, HttpServletRequest request) throws Exception{ 

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta8200XmlService) wac.getBean("Yeta8200XmlService" ); 

		}
		InfcPkgYe167110_2023_VO ye167110Vo = new InfcPkgYe167110_2023_VO();
		InfcPkgYe167120_2023_VO ye167120Vo = new InfcPkgYe167120_2023_VO();
		InfcPkgYe167130_2023_VO ye167130Vo = new InfcPkgYe167130_2023_VO();
		InfcPkgYe167140_2023_VO ye167140Vo = new InfcPkgYe167140_2023_VO();
		InfcPkgYe167150_2023_VO ye167150Vo = new InfcPkgYe167150_2023_VO();
		
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
			strResnoEncCntn = subXmlElMan.getAttribute("resnoEncCntn");   //주민번호
			strAdr	= subXmlElMan.getAttribute("adr");   //주소
			strPfbAdr = subXmlElMan.getAttribute("pfbAdr");   //사업장소재지
			
			String strValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResnoEncCntn).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			
			/** -------------------------------- 초기화 작업 시작 ------------------------------------*/
			ye167110Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167110Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167110Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167110Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta8200_PDF_YE167110_2023_Delete(ye167110Vo);	//기본정보 삭제
			
			ye167120Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167120Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167120Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167120Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta8200_PDF_YE167120_2023_Delete(ye167120Vo);	//퇴직 연금 계좌 삭제	
			
			ye167130Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167130Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167130Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167130Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta8200_PDF_YE167130_2023_Delete(ye167130Vo);	//연금 저축 계좌 삭제	
			
			ye167140Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167140Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167140Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167140Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta8200_PDF_YE167140_2023_Delete(ye167140Vo);	//주택마련 저축 소득 공제 삭제
			
			ye167150Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167150Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167150Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167150Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta8200_PDF_YE167150_2023_Delete(ye167150Vo);	//장기 집합 투자 증권 저축 소득 공제 삭제
			
			/** -------------------------------- 초기화 작업 종료 ------------------------------------*/
			
			ye167110Vo.setFormCd(strFormCd);
			ye167110Vo.setTnm(strTnm);
			ye167110Vo.setBsnoEncCntn(strBsnoEncCntn);
			ye167110Vo.setFnm(strFnm);
			ye167110Vo.setResnoEncCntn(strValue);  
			 	
			ye167110Vo.setAdr(strAdr);
			ye167110Vo.setPdfAdr(strPfbAdr);
			
			ye167110Vo.setKybdr(sessionUser.getUsrId());
			ye167110Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			ye167110Vo.setIsmt(sessionUser.getUsrId());
			ye167110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			yetaPayr3200Service.yeta8200_PDF_YE167110_2023_Insert(ye167110Vo);	//기본정보 입력
			
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");

			//상품별 반복구간
			for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
				System.out.println("길이 :" + subXmlElChildMan.getLength());
				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				
				strRtpnAccRtpnCl = subXmlElData.getAttribute("rtpnAccRtpnCl"); 
				strPnsnSvngAccPnsnSvngCl = subXmlElData.getAttribute("pnsnSvngAccPnsnSvngCl");
				strHsngPrptSvngSvngCl = subXmlElData.getAttribute("hsngPrptSvngSvngCl");
				strLtrmCniSsfnnOrgnCd = subXmlElData.getAttribute("ltrmCniSsfnnOrgnCd");
				
				if (!strRtpnAccRtpnCl.equals("")) { // 퇴직 연금 계좌별 반복 구간
					setYe167120Vo(ye167120Vo, request);
				}
				else if (!strPnsnSvngAccPnsnSvngCl.equals("")) { //연금 저축 계좌별 반복 구간
					setYe167130Vo(ye167130Vo, request);
				}
				else if (!strHsngPrptSvngSvngCl.equals("")) { //주택마련 저축 소득 공제별 반복 구간
					setYe167140Vo(ye167140Vo, request);
				}
				else if (!strLtrmCniSsfnnOrgnCd.equals("")) { //장기 집합 투자 증권 저축 소득 공제별 반복 구간
					setYe167150Vo(ye167150Vo, request);
				}
			}

		}

	}
	
	public static void setYe167120Vo(InfcPkgYe167120_2023_VO ye167120Vo , HttpServletRequest request) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta8200XmlService) wac.getBean("Yeta8200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167120Vo.setRtpnAccRtpnCl(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("rtpnAccRtpnCl")));
		ye167120Vo.setRtpnFnnOrgnCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("rtpnFnnOrgnCd")));
		ye167120Vo.setRtpnAccFnnCmp(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("rtpnAccFnnCmp")));
		ye167120Vo.setRtpnAccAccno(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("rtpnAccAccno")));
		ye167120Vo.setRtpnAccPymAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("rtpnAccPymAmt"),"0")));
		ye167120Vo.setRtpnAccTxamtDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("rtpnAccTxamtDdcAmt"),"0")));
		
		ye167120Vo.setKybdr(sessionUser.getUsrId());
		ye167120Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167120Vo.setIsmt(sessionUser.getUsrId());
		ye167120Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta8200_PDF_YE167120_2023_Insert(ye167120Vo);	//기본정보 입력
	}
	
	public static void setYe167130Vo(InfcPkgYe167130_2023_VO ye167130Vo , HttpServletRequest request) throws Exception{
		
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			
			yetaPayr3200Service = (Yeta8200XmlService) wac.getBean("Yeta8200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167130Vo.setPnsnSvngAccPnsnSvngCl(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("pnsnSvngAccPnsnSvngCl")));
		ye167130Vo.setPnsnSvngFnnOrgnCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("pnsnSvngFnnOrgnCd")));
		ye167130Vo.setPnsnSvngAccFnnCmp(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("pnsnSvngAccFnnCmp")));
		ye167130Vo.setPnsnSvngAccAccno(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("pnsnSvngAccAccno")));
		ye167130Vo.setPnsnSvngAccPymAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pnsnSvngAccPymAmt"),"0")));
		
		ye167130Vo.setIpnsnSvngAccddcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ipnsnSvngAccNcTxamtDdcAmt"),"0")));		
		ye167130Vo.setKybdr(sessionUser.getUsrId());
		ye167130Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167130Vo.setIsmt(sessionUser.getUsrId());
		ye167130Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta8200_PDF_YE167130_2023_Insert(ye167130Vo);	//기본정보 입력
	}
	
	public static void setYe167140Vo(InfcPkgYe167140_2023_VO ye167140Vo , HttpServletRequest request) throws Exception{
		
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			
			yetaPayr3200Service = (Yeta8200XmlService) wac.getBean("Yeta8200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167140Vo.setHsngPrptSvngSvngCl(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("hsngPrptSvngSvngCl")));
		ye167140Vo.setJnngDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("jnngDt")));
		ye167140Vo.setHsngPrptSvngFnnOrgnCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("hsngPrptSvngFnnOrgnCd")));
		ye167140Vo.setHsngPrptSvngFnnCmp(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("hsngPrptSvngFnnCmp")));
		ye167140Vo.setHsngPrptSvngAccNo(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("hsngPrptSvngAccno")));
		
		ye167140Vo.setHsngPrptSvngPymAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hsngPrptSvngPymAmt"),"0")));
		ye167140Vo.setHsngPrptSvngIncDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hsngPrptSvngIncDdcAmt"),"0")));
		
		ye167140Vo.setKybdr(sessionUser.getUsrId());
		ye167140Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167140Vo.setIsmt(sessionUser.getUsrId());
		ye167140Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta8200_PDF_YE167140_2023_Insert(ye167140Vo);	//기본정보 입력
	}
	
	public static void setYe167150Vo(InfcPkgYe167150_2023_VO ye167150Vo , HttpServletRequest request) throws Exception{
		
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			
			yetaPayr3200Service = (Yeta8200XmlService) wac.getBean("Yeta8200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167150Vo.setLtrmCniSsfnnOrgnCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("ltrmCniSsfnnOrgnCd")));
		ye167150Vo.setLtrmCniSsFnnCmp(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("ltrmCniSsFnnCmp")));
		ye167150Vo.setLtrmCniSsAccno(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("ltrmCniSsAccno")));
		ye167150Vo.setLtrmCniSsPymAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ltrmCniSsPymAmt"),"0")));
		ye167150Vo.setLtrmCniSsIncDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ltrmCniSsIncDdcAmt"),"0")));
		
		ye167150Vo.setKybdr(sessionUser.getUsrId());
		ye167150Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167150Vo.setIsmt(sessionUser.getUsrId());
		ye167150Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta8200_PDF_YE167150_2023_Insert(ye167150Vo);	//기본정보 입력
	}
}
