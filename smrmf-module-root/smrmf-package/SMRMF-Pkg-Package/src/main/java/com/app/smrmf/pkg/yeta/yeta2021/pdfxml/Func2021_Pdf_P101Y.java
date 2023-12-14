package com.app.smrmf.pkg.yeta.yeta2021.pdfxml;

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
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3100VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfO101m_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfP101m_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfP101y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfYE162015_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161010_2021_VO;
import com.app.smrmf.pkg.yeta.yeta2016.pdfxml.service.YetaPayr1200Service;
import com.app.smrmf.pkg.yeta.yeta2021.pdfxml.service.Yeta6200XmlService;

public class Func2021_Pdf_P101Y {

	@Resource(name = "Yeta6200XmlService")
	private static Yeta6200XmlService yetaPayr4200Service;

	private static NodeList subXmlElChildForm = null;
	private static Node subXmlItemMan = null;
	private static NodeList subXmlElChildMan = null;
	private static Element subXmlElMan = null;
	private static Node subXmlItemData = null;
	private static Element subXmlElData = null;
	
	private static NodeList subXmlElChildSum = null;
	private static Element subXmlElSum = null;
	private static Node subXmlItemSum = null;
	
	private static NodeList subXmlElChildAmt = null;
	private static Element subXmlElAmt = null;
	private static Node subXmlItemAmt = null;

	private static String strResid = "";
	private static String strDatCd = "";
	private static String strFormCd = "";
	private static String strName = "";
	private static String strMm= "";
	
	private static String strSpym= "";
	private static String strJlc = "";
	private static String strNtf = "";
	private static String strPmt = "";
	private static String strWrkpNtf = "";
	private static String strRgnPmt = "";
	
	public static void func_2021_P101Y_P101M(InfcPkgYe161010_2021_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request ) throws Exception{
		
		/**+++++++++++   국민연금보험료 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		//  국민연금보험료 시작
		if  (yetaPayr4200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr4200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 
		}
		strDatCd = "";

		InfcPkgPdfP101y_2021_VO yetaPdfP101yVo = new InfcPkgPdfP101y_2021_VO();
		InfcPkgPdfP101m_2021_VO yetaPdfP101mVo = new InfcPkgPdfP101m_2021_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd");
		
		InfcPkgPdfYE162015_2021_VO yetaPdfYE162015Vo = new InfcPkgPdfYE162015_2021_VO();
		
		yetaPdfYE162015Vo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfYE162015Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfYE162015Vo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfYE162015Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfYE162015Vo.setFileAppPaprDivCd(strFormCd);
		
		yetaPayr4200Service.yeta6200_PDF_YE162015_2021_Delete(yetaPdfYE162015Vo);
		
		//인원별 반복구간
		for (int j = 0; j < subXmlElChildForm.getLength();j++) { 


			subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			subXmlElMan  = (Element) subXmlItemMan;

			strResid = subXmlElMan.getAttribute("resid");   //주민번호
			strName = subXmlElMan.getAttribute("name");	//이름
			// 상품별 반복구간
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			//상품별 반복구간
			for(int k = 0; k < subXmlElChildMan.getLength();k++) {  

				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				strDatCd = subXmlElData.getAttribute("dat_cd"); 

				String strDecValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호

				yetaPdfP101yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
				yetaPdfP101yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
				yetaPdfP101yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
				yetaPdfP101yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
				yetaPdfP101yVo.setFormCd(strFormCd);
				yetaPdfP101yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfP101yVo.setName(strName);
				yetaPdfP101yVo.setPdfDatAppYn("N");

				yetaPdfP101yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfP101yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfP101yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfP101yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0041")) {
					yetaPdfP101yVo.setDatCd(strDatCd);
					
					subXmlElChildSum= subXmlElData.getElementsByTagName("sum");

					for(int i = 0; i < subXmlElChildSum.getLength(); i++) {  
						subXmlItemSum =  subXmlElChildSum.item(i);
						subXmlElSum = (Element) subXmlItemSum;
						strSpym = subXmlElSum.getAttribute("spym");
						strJlc = subXmlElSum.getAttribute("jlc");
						strNtf = subXmlElSum.getAttribute("ntf");
						strPmt = subXmlElSum.getAttribute("pmt");
						
						yetaPdfP101yVo.setNatAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));
						yetaPdfP101yVo.setSpym(new BigDecimal(MSFSharedUtils.defaultNulls(strSpym,"0")));
						yetaPdfP101yVo.setJlc(new BigDecimal(MSFSharedUtils.defaultNulls(strJlc,"0")));
						yetaPdfP101yVo.setNtf(new BigDecimal(MSFSharedUtils.defaultNulls(strNtf,"0")));
						yetaPdfP101yVo.setPmt(new BigDecimal(MSFSharedUtils.defaultNulls(strPmt,"0")));
						
						yetaPayr4200Service.yeta6200_PDF_P101Y_2021_Delete(yetaPdfP101yVo);
						yetaPayr4200Service.yeta6200_PDF_P101Y_2021_Insert(yetaPdfP101yVo);
					}
					
					if (strFormCd.equals("P101M")) {
						yetaPdfP101mVo.setDatCd(strDatCd);
						yetaPdfP101mVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
						yetaPdfP101mVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
						yetaPdfP101mVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
						yetaPdfP101mVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
						
						yetaPdfP101mVo.setKybdr(sessionUser.getUsrId());
						yetaPdfP101mVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						yetaPdfP101mVo.setIsmt(sessionUser.getUsrId());
						yetaPdfP101mVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						subXmlElChildAmt= subXmlElData.getElementsByTagName("amt");

						for(int i = 0; i < subXmlElChildAmt.getLength(); i++) {  
							subXmlItemAmt =  subXmlElChildAmt.item(i);
							subXmlElAmt = (Element) subXmlItemAmt;
							strMm = subXmlElAmt.getAttribute("mm");
							strWrkpNtf = subXmlElAmt.getAttribute("wrkp_ntf");
							strRgnPmt= subXmlElAmt.getAttribute("rgn_pmt");
							
							if (strMm.equals("01")) {
								setPdfP101mVo(yetaPdfP101mVo, request, subXmlElData);
							}
							else if (strMm.equals("02")) {
								setPdfP101mVo(yetaPdfP101mVo, request, subXmlElData);
							}
							else if (strMm.equals("03")) {
								setPdfP101mVo(yetaPdfP101mVo, request, subXmlElData);
							}
							else if (strMm.equals("04")) {
								setPdfP101mVo(yetaPdfP101mVo, request, subXmlElData);
							}
							else if (strMm.equals("05")) {
								setPdfP101mVo(yetaPdfP101mVo, request, subXmlElData);
							}
							else if (strMm.equals("06")) {
								setPdfP101mVo(yetaPdfP101mVo, request, subXmlElData);
							}
							else if (strMm.equals("07")) {
								setPdfP101mVo(yetaPdfP101mVo, request, subXmlElData);
							}
							else if (strMm.equals("08")) {
								setPdfP101mVo(yetaPdfP101mVo, request, subXmlElData);
							}
							else if (strMm.equals("09")) {
								setPdfP101mVo(yetaPdfP101mVo, request, subXmlElData);
							}
							else if (strMm.equals("10")) {
								setPdfP101mVo(yetaPdfP101mVo, request, subXmlElData);
							}
							else if (strMm.equals("11")) {
								setPdfP101mVo(yetaPdfP101mVo, request, subXmlElData);
							}
							else if (strMm.equals("12")) {
								setPdfP101mVo(yetaPdfP101mVo, request, subXmlElData);
							}
						}
					}
				}
			}

		}
		yetaPdfYE162015Vo.setFileAppPaprSbtYn("Y");
		yetaPdfYE162015Vo.setFileAppPaprYetaYn("N");
		
		yetaPdfYE162015Vo.setKybdr(sessionUser.getUsrId());
		yetaPdfYE162015Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		yetaPdfYE162015Vo.setIsmt(sessionUser.getUsrId());
		yetaPdfYE162015Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr4200Service.yeta6200_PDF_YE162015_2021_Insert(yetaPdfYE162015Vo);
	}
	
	public static void setPdfP101mVo(InfcPkgPdfP101m_2021_VO yetaPdfP101mVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr4200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr4200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 
		}
		
		yetaPdfP101mVo.setNatAmtMn(strMm);
		yetaPdfP101mVo.setWrkpNtf(new BigDecimal(MSFSharedUtils.defaultNulls(strWrkpNtf,"0")));
		yetaPdfP101mVo.setRgnPmt(new BigDecimal(MSFSharedUtils.defaultNulls(strRgnPmt,"0")));
		
		yetaPayr4200Service.yeta6200_PDF_P101M_2021_Delete(yetaPdfP101mVo);
		yetaPayr4200Service.yeta6200_PDF_P101M_2021_Insert(yetaPdfP101mVo);
		

	}
}
