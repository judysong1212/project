package com.app.smrmf.pkg.yeta.yeta2022.pdfxml;

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
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
//import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2100VO;
//import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2220VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG304m_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG304y_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG304m_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG304y_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfYE162015_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161010_2022_VO;
import com.app.smrmf.pkg.yeta.yeta2016.pdfxml.service.YetaPayr1200Service;
import com.app.smrmf.pkg.yeta.yeta2022.pdfxml.service.Yeta7200XmlService;

public class Func2022_Pdf_G304Y {

	@Resource(name = "Yeta7200XmlService")
	private static Yeta7200XmlService yetaPayr3200Service;

	private static NodeList subXmlElChildForm = null;
	private static Node subXmlItemMan = null;
	private static NodeList subXmlElChildMan = null;
	private static Element subXmlElMan = null;
	private static Node subXmlItemData = null;
	private static Element subXmlElData = null;

	private static NodeList subXmlElChildAmt = null;
	private static Element subXmlElAmt = null;
	private static Node subXmlItemAmt = null;

	private static String strResid = "";
	private static String strDatCd = "";
	private static String strMn= "";
	private static String strFormCd = "";
	private static String strName = "";

	public static void func_2022_G304Y_G304M(InfcPkgYe161010_2022_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request ) throws Exception{

		/**+++++++++++  직불카드 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		//    직불카드 시작
		//직불카드등  연간합계 G302M 월별 G03 직불카드 등 본인+가족
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta7200XmlService) wac.getBean("Yeta7200XmlService" ); 
		}

		InfcPkgPdfG304y_2022_VO yetaPdfG304yVo = new InfcPkgPdfG304y_2022_VO();
		InfcPkgPdfG304m_2022_VO yetaPdfG304mVo = new InfcPkgPdfG304m_2022_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

		yetaPdfG304yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG304yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG304yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG304yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr3200Service.yeta7200_PDF_G304Y_2022_Delete(yetaPdfG304yVo);
		
		yetaPdfG304mVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG304mVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG304mVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG304mVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr3200Service.yeta7200_PDF_G304M_2022_Delete(yetaPdfG304mVo);
		
		strDatCd = "";
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		
		InfcPkgPdfYE162015_2022_VO yetaPdfYE162015Vo = new InfcPkgPdfYE162015_2022_VO();
		
		yetaPdfYE162015Vo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfYE162015Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfYE162015Vo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfYE162015Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfYE162015Vo.setFileAppPaprDivCd(strFormCd);
		
		yetaPayr3200Service.yeta7200_PDF_YE162015_2022_Delete(yetaPdfYE162015Vo);
		
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
				
				yetaPdfG304yVo.setFormCd(strFormCd);
				yetaPdfG304yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfG304yVo.setName(strName);
				yetaPdfG304yVo.setPdfDatAppYn("N");
				
				yetaPdfG304yVo.setFtyrTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tot_amt"),"0")));
				yetaPdfG304yVo.setFtyrMarketTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_market_tot_amt"),"0")));
				yetaPdfG304yVo.setFtyrTmoneyTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tmoney_tot_amt"),"0")));
				yetaPdfG304yVo.setPreTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tot_amt"),"0")));
				yetaPdfG304yVo.setPreMarketTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_market_tot_amt"),"0")));
				yetaPdfG304yVo.setPreTmoneyTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tmoney_tot_amt"),"0")));

				yetaPdfG304yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfG304yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfG304yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfG304yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0014")) { //  if strDatCd  = 'G03' then

					yetaPdfG304yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfG304yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfG304yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					
					if ((subXmlElData.getAttribute("use_place_cd")).equals("1") )  {
						setPdfG304yVo(yetaPdfG304yVo, request, subXmlElData);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("2") )  {
						setPdfG304yVo(yetaPdfG304yVo, request, subXmlElData);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("3") )  {
						setPdfG304yVo(yetaPdfG304yVo, request, subXmlElData);
					}
				}

				if (strFormCd.equals("G304M")) {

					subXmlElChildAmt = subXmlElData.getElementsByTagName("amt");

					for(int i = 0; i < subXmlElChildAmt.getLength(); i++) {  
						subXmlItemAmt =  subXmlElChildAmt.item(i);
						subXmlElAmt = (Element) subXmlItemAmt;
						strMn = subXmlElAmt.getAttribute("mm");

						yetaPdfG304mVo.setKybdr(sessionUser.getUsrId());
						yetaPdfG304mVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						yetaPdfG304mVo.setIsmt(sessionUser.getUsrId());
						yetaPdfG304mVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

						if (strMn.equals("01")) {
							setPdfG304mVo(yetaPdfG304mVo, request, subXmlElData);
						}
						else if (strMn.equals("02")) {
							setPdfG304mVo(yetaPdfG304mVo, request, subXmlElData);
						}
						else if (strMn.equals("03")) {
							setPdfG304mVo(yetaPdfG304mVo, request, subXmlElData);
						}
						else if (strMn.equals("04")) {
							setPdfG304mVo(yetaPdfG304mVo, request, subXmlElData);
						}
						else if (strMn.equals("05")) {
							setPdfG304mVo(yetaPdfG304mVo, request, subXmlElData);
						}
						else if (strMn.equals("06")) {
							setPdfG304mVo(yetaPdfG304mVo, request, subXmlElData);
						}
						else if (strMn.equals("07")) {
							setPdfG304mVo(yetaPdfG304mVo, request, subXmlElData);
						}
						else if (strMn.equals("08")) {
							setPdfG304mVo(yetaPdfG304mVo, request, subXmlElData);
						}
						else if (strMn.equals("09")) {
							setPdfG304mVo(yetaPdfG304mVo, request, subXmlElData);
						}
						else if (strMn.equals("10")) {
							setPdfG304mVo(yetaPdfG304mVo, request, subXmlElData);
						}
						else if (strMn.equals("11")) {
							setPdfG304mVo(yetaPdfG304mVo, request, subXmlElData);
						}
						else if (strMn.equals("12")) {
							setPdfG304mVo(yetaPdfG304mVo, request, subXmlElData);
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
		
		yetaPayr3200Service.yeta7200_PDF_YE162015_2022_Insert(yetaPdfYE162015Vo);
		//현금 영수증 종료
	}

	public static void setPdfG304yVo(InfcPkgPdfG304y_2022_VO yetaPdfG304yVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta7200XmlService) wac.getBean("Yeta7200XmlService" ); 
		}
		yetaPdfG304yVo.setUsePlaceCd(subXmlElData.getAttribute("use_place_cd"));
		yetaPdfG304yVo.setFirstTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("first_tot_amt"),"0")));
		yetaPdfG304yVo.setSecondTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("second_tot_amt"),"0")));
		yetaPdfG304yVo.setFirstYearTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("first_year_tot_amt"),"0")));
		yetaPdfG304yVo.setSecondYearTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("second_year_tot_amt"),"0")));
		yetaPdfG304yVo.setInqrStrtMm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("inqr_strt_mm")));
		yetaPdfG304yVo.setInqrEndMm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("inqr_end_mm")));
		yetaPdfG304yVo.setDirCardAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));

		yetaPayr3200Service.yeta7200_PDF_G304Y_2022_Insert(yetaPdfG304yVo);

	}
	
	public static void setPdfG304mVo(InfcPkgPdfG304m_2022_VO yetaPdfG304mVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta7200XmlService) wac.getBean("Yeta7200XmlService" ); 
		}

		yetaPdfG304mVo.setDirCardAmtMn(strMn);
		yetaPdfG304mVo.setDirCardMmAmt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("amt", subXmlElData),"0")));
		
		yetaPayr3200Service.yeta7200_PDF_G304M_2022_Insert(yetaPdfG304mVo);

	}

}
