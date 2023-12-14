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
import com.app.smrmf.egov.comutils.payr.PkgFuncUtils;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG104mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG104yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.pkg.yeta.yeta2017.pdfxml.service.Yeta2200XmlService;

public class Func_Pdf_G104Y {

	@Resource(name = "Yeta2200XmlService")
	private static Yeta2200XmlService yetaPayr2200Service;

	private static NodeList subXmlElChildForm = null;
	private static Node subXmlItemMan = null;
	private static NodeList subXmlElChildMan = null;
	private static Element subXmlElMan = null;
	private static Node subXmlItemData = null;
	private static Element subXmlElData = null;

	private static String strResid = "";
	private static String strDatCd = "";
	private static String strFormCd = "";
	private static String strName = "";

	public static void func_2017_G104Y_G104M(InfcPkgYe161010VO ye161010VO, Element  subXmlElForm, String nResult , HttpServletRequest request ) throws Exception{

		/**+++++++++++2012년도 : 연금저축 E101Y 연간합계 E101M+++++++++++++++++++++++++++++++++++++++++++++++++*/

		// 2012년도 : 연금저축 E101Y 연간합계 E101M
		// 연금 저축 시작
		//월별 E01 연금저축 본인
		//근로자 본인 명의로 2001.1.1 이후에 가입하여 해당 과세기간에 불입한 금액
		//Y0040040  	B011	0040	연금저축					22
		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 
		}

		InfcPkgPdfG104yVO yetaPdfG104yVo = new InfcPkgPdfG104yVO();
		InfcPkgPdfG104mVO yetaPdfG104mVo = new InfcPkgPdfG104mVO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		yetaPdfG104yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG104yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG104yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG104yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr2200Service.yeta2200_PDF_G104Y_2017_Delete(yetaPdfG104yVo);

		strDatCd = "";
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");

		//인원별 반복구간
		for (int j = 0; j < subXmlElChildForm.getLength();j++) { 


			subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			subXmlElMan  = (Element) subXmlItemMan;

			strResid = subXmlElMan.getAttribute("resid");   //주민번호
			strName = subXmlElMan.getAttribute("name");	//이름
			strFormCd  = subXmlElForm.getAttribute("form_cd"); 
			// 상품별 반복구간
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			//상품별 반복구간
			for(int k = 0; k < subXmlElChildMan.getLength();k++) {  

				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				strDatCd = subXmlElData.getAttribute("dat_cd"); 

				String strDecValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
				
				yetaPdfG104yVo.setFormCd(strFormCd);
				yetaPdfG104yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfG104yVo.setName(strName);
				
				yetaPdfG104yVo.setFtyrTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tot_amt"),"0")));
				yetaPdfG104yVo.setFtyrMarketTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_market_tot_amt"),"0")));
				yetaPdfG104yVo.setFtyrTmoneyTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tmoney_tot_amt"),"0")));
				yetaPdfG104yVo.setPreTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tot_amt"),"0")));
				yetaPdfG104yVo.setPreMarketTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_market_tot_amt"),"0")));
				yetaPdfG104yVo.setPreTmoneyTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tmoney_tot_amt"),"0")));

				yetaPdfG104yVo.setPdfDatAppYn("N");

				yetaPdfG104yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfG104yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfG104yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfG104yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0012")) { // if strDatCd  = 'G01' then

					yetaPdfG104yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfG104yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfG104yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					if ((subXmlElData.getAttribute("use_place_cd") ).equals("1") )  {
						setPdfG104yVo(yetaPdfG104yVo, request);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("2") )  {
						setPdfG104yVo(yetaPdfG104yVo, request);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("3") )  {
						setPdfG104yVo(yetaPdfG104yVo, request);
					}
				} 

			}
		}
		//신용카드 종료

	}

	public static void setPdfG104yVo(InfcPkgPdfG104yVO yetaPdfG104yVo , HttpServletRequest request) throws Exception{

		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 
		}
		yetaPdfG104yVo.setUsePlaceCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("use_place_cd")));
		yetaPdfG104yVo.setFirstTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("first_tot_amt"),"0")));
		yetaPdfG104yVo.setSecondTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("second_tot_amt"),"0")));
		yetaPdfG104yVo.setFirstYearTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("first_year_tot_amt"),"0")));
		yetaPdfG104yVo.setSecondYearTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("second_year_tot_amt"),"0")));
		yetaPdfG104yVo.setInqrStrtMm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("inqr_strt_mm")));
		yetaPdfG104yVo.setInqrEndMm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("inqr_end_mm")));
		yetaPdfG104yVo.setCardAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));

		yetaPayr2200Service.yeta2200_PDF_G104Y_2017_Insert(yetaPdfG104yVo);

	}
}
