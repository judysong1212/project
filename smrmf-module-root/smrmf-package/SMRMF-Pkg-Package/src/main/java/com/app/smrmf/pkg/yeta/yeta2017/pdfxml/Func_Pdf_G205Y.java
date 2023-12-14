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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG104yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG205mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG205yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfYE162015VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.pkg.yeta.yeta2017.pdfxml.service.Yeta2200XmlService;

public class Func_Pdf_G205Y {

	@Resource(name = "Yeta2200XmlService")
	private static Yeta2200XmlService yetaPayr2200Service;

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
	private static BigDecimal strAmt= null;
	private static String strFormCd = "";
	private static String strName = "";

	public static void func_2017_G205Y_G205M(InfcPkgYe161010VO ye161010VO, Element  subXmlElForm, String nResult , HttpServletRequest request ) throws Exception{

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
		

		InfcPkgPdfG205yVO yetaPdfG205yVo = new InfcPkgPdfG205yVO();
		InfcPkgPdfG205mVO yetaPdfG205mVo = new InfcPkgPdfG205mVO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		yetaPdfG205yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG205yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG205yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG205yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 

		yetaPayr2200Service.yeta2200_PDF_G205Y_2017_Delete(yetaPdfG205yVo);
		
		yetaPdfG205mVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG205mVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG205mVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG205mVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr2200Service.yeta2200_PDF_G205M_2017_Delete(yetaPdfG205mVo);
		
		strDatCd = "";
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		
		InfcPkgPdfYE162015VO yetaPdfYE162015Vo = new InfcPkgPdfYE162015VO();
		
		yetaPdfYE162015Vo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfYE162015Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfYE162015Vo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfYE162015Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfYE162015Vo.setFileAppPaprDivCd(strFormCd);
		
		yetaPayr2200Service.yeta2200_PDF_YE162015_2017_Delete(yetaPdfYE162015Vo);
		
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

				yetaPdfG205yVo.setFormCd(strFormCd);
				yetaPdfG205yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfG205yVo.setName(strName);

				yetaPdfG205yVo.setFtyrTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tot_amt"),"0")));
				yetaPdfG205yVo.setFtyrMarketTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_market_tot_amt"),"0")));
				yetaPdfG205yVo.setFtyrTmoneyTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("ftyr_tmoney_tot_amt"),"0")));
				yetaPdfG205yVo.setPreTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tot_amt"),"0")));
				yetaPdfG205yVo.setPreMarketTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_market_tot_amt"),"0")));
				yetaPdfG205yVo.setPreTmoneyTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElMan.getAttribute("pre_tmoney_tot_amt"),"0")));

				yetaPdfG205yVo.setPdfDatAppYn("N");

				yetaPdfG205yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfG205yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfG205yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfG205yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0013")) { //if strDatCd  = 'G02' then

					yetaPdfG205yVo.setDatCd(strDatCd);

					if ((subXmlElData.getAttribute("use_place_cd")).equals("1") )  {
						setPdfG205yVo(yetaPdfG205yVo, request, subXmlElData);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("2") )  {
						setPdfG205yVo(yetaPdfG205yVo, request, subXmlElData);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("3") )  {
						setPdfG205yVo(yetaPdfG205yVo, request, subXmlElData);
					}
					
					if (strFormCd.equals("G205M")) {

						subXmlElChildAmt = subXmlElData.getElementsByTagName("amt");
						
						for(int i = 0; i < subXmlElChildAmt.getLength(); i++) {  
							subXmlItemAmt =  subXmlElChildAmt.item(i);
							subXmlElAmt = (Element) subXmlItemAmt;
							strMn = subXmlElAmt.getAttribute("mm");
							strAmt = new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElAmt.getFirstChild().getNodeValue(),"0"));

							yetaPdfG205mVo.setResid(strResid);
							yetaPdfG205mVo.setUsePlaceCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("use_place_cd")));
							
							yetaPdfG205mVo.setKybdr(sessionUser.getUsrId());
							yetaPdfG205mVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							yetaPdfG205mVo.setIsmt(sessionUser.getUsrId());
							yetaPdfG205mVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							
							yetaPdfG205mVo.setChahUseAmtMn(strMn);

							if (strMn.equals("01")) {
								setPdfG205mVo(yetaPdfG205mVo, request, subXmlElData);
							}
							else if (strMn.equals("02")) {
								setPdfG205mVo(yetaPdfG205mVo, request, subXmlElData);
							}
							else if (strMn.equals("03")) {
								setPdfG205mVo(yetaPdfG205mVo, request, subXmlElData);
							}
							else if (strMn.equals("04")) {
								setPdfG205mVo(yetaPdfG205mVo, request, subXmlElData);
							}
							else if (strMn.equals("05")) {
								setPdfG205mVo(yetaPdfG205mVo, request, subXmlElData);
							}
							else if (strMn.equals("06")) {
								setPdfG205mVo(yetaPdfG205mVo, request, subXmlElData);
							}
							else if (strMn.equals("07")) {
								setPdfG205mVo(yetaPdfG205mVo, request, subXmlElData);
							}
							else if (strMn.equals("08")) {
								setPdfG205mVo(yetaPdfG205mVo, request, subXmlElData);
							}
							else if (strMn.equals("09")) {
								setPdfG205mVo(yetaPdfG205mVo, request, subXmlElData);
							}
							else if (strMn.equals("10")) {
								setPdfG205mVo(yetaPdfG205mVo, request, subXmlElData);
							}
							else if (strMn.equals("11")) {
								setPdfG205mVo(yetaPdfG205mVo, request, subXmlElData);
							}
							else if (strMn.equals("12")) {
								setPdfG205mVo(yetaPdfG205mVo, request, subXmlElData);
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
		
		yetaPayr2200Service.yeta2200_PDF_YE162015_2017_Insert(yetaPdfYE162015Vo);
		//현금 영수증 종료
	}

	public static void setPdfG205yVo(InfcPkgPdfG205yVO yetaPdfG205yVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 
		}
		yetaPdfG205yVo.setUsePlaceCd(subXmlElData.getAttribute("use_place_cd"));
		yetaPdfG205yVo.setFirstTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("first_tot_amt"),"0")));
		yetaPdfG205yVo.setSecondTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("second_tot_amt"),"0")));
		yetaPdfG205yVo.setFirstYearTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("first_year_tot_amt"),"0")));
		yetaPdfG205yVo.setSecondYearTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("second_year_tot_amt"),"0")));
		yetaPdfG205yVo.setInqrStrtMm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("inqr_strt_mm")));
		yetaPdfG205yVo.setInqrEndMm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("inqr_end_mm")));
		yetaPdfG205yVo.setCashCardSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));
		
		yetaPayr2200Service.yeta2200_PDF_G205Y_2017_Insert(yetaPdfG205yVo);

	}
	
	public static void setPdfG205mVo(InfcPkgPdfG205mVO yetaPdfG205mVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 
		}

		yetaPdfG205mVo.setCashMmAmt(strAmt);
		
		yetaPayr2200Service.yeta2200_PDF_G205M_2017_Insert(yetaPdfG205mVo);

	}
}
