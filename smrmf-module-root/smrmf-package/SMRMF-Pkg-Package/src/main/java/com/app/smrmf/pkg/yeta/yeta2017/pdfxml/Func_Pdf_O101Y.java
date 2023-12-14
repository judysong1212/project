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

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.egov.comutils.payr.PkgFuncUtils;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfO101mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfO101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfYE162015VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161060VO;
import com.app.smrmf.pkg.yeta.yeta2017.pdfxml.service.Yeta2200XmlService;

public class Func_Pdf_O101Y {

	@Resource(name = "Yeta2200XmlService")
	private static Yeta2200XmlService yetaPayr2200Service;

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
	
	private static String strHiYrs= "";
	private static String strLtrmYrs = "";
	private static String strHiNtf = "";
	private static String strLtrmNtf = "";
	private static String strHiPmt = "";
	private static String strLtrmPmt = "";
	
	public static void func_2017_O101Y_O101M(InfcPkgYe161010VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request ) throws Exception{
		
		/**+++++++++++   건강보험료 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		//  건강보험료 시작
		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 
		}

		InfcPkgPdfO101yVO yetaPdfO101yVo = new InfcPkgPdfO101yVO();
		InfcPkgPdfO101mVO yetaPdfO101mVo = new InfcPkgPdfO101mVO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

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

				yetaPdfO101yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
				yetaPdfO101yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
				yetaPdfO101yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
				yetaPdfO101yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
				yetaPdfO101yVo.setFormCd(strFormCd);
				yetaPdfO101yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfO101yVo.setName(strName);
				yetaPdfO101yVo.setPdfDatAppYn("N");

				yetaPdfO101yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfO101yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfO101yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfO101yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0030")) {
					yetaPdfO101yVo.setDatCd(strDatCd);
					
					subXmlElChildSum= subXmlElData.getElementsByTagName("sum");

					for(int i = 0; i < subXmlElChildSum.getLength(); i++) {  
						subXmlItemSum =  subXmlElChildSum.item(i);
						subXmlElSum = (Element) subXmlItemSum;
						strHiYrs = subXmlElSum.getAttribute("hi_yrs");
						strLtrmYrs = subXmlElSum.getAttribute("ltrm_yrs");
						strHiNtf = subXmlElSum.getAttribute("hi_ntf");
						strLtrmNtf = subXmlElSum.getAttribute("ltrm_ntf");
						strHiPmt = subXmlElSum.getAttribute("hi_pmt");
						strLtrmPmt = subXmlElSum.getAttribute("ltrm_pmt");
						
						yetaPdfO101yVo.setHlthAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));
						yetaPdfO101yVo.setHiYrs(new BigDecimal(MSFSharedUtils.defaultNulls(strHiYrs,"0")));
						yetaPdfO101yVo.setLtrmYrs(new BigDecimal(MSFSharedUtils.defaultNulls(strLtrmYrs,"0")));
						yetaPdfO101yVo.setHiNtf(new BigDecimal(MSFSharedUtils.defaultNulls(strHiNtf,"0")));
						yetaPdfO101yVo.setLtrmNtf(new BigDecimal(MSFSharedUtils.defaultNulls(strLtrmNtf,"0")));
						yetaPdfO101yVo.setHiPmt(new BigDecimal(MSFSharedUtils.defaultNulls(strHiPmt,"0")));
						yetaPdfO101yVo.setLtrmPmt(new BigDecimal(MSFSharedUtils.defaultNulls(strLtrmPmt,"0")));
						
						yetaPayr2200Service.yeta2200_PDF_O101Y_2017_Delete(yetaPdfO101yVo);
						yetaPayr2200Service.yeta2200_PDF_O101Y_2017_Insert(yetaPdfO101yVo);
					}
					
					if (strFormCd.equals("O101M")) {
						yetaPdfO101mVo.setDatCd(strDatCd);
						yetaPdfO101mVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
						yetaPdfO101mVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
						yetaPdfO101mVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
						yetaPdfO101mVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
						
						yetaPdfO101mVo.setKybdr(sessionUser.getUsrId());
						yetaPdfO101mVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						yetaPdfO101mVo.setIsmt(sessionUser.getUsrId());
						yetaPdfO101mVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						subXmlElChildAmt= subXmlElData.getElementsByTagName("amt");

						for(int i = 0; i < subXmlElChildAmt.getLength(); i++) {  
							subXmlItemAmt =  subXmlElChildAmt.item(i);
							subXmlElAmt = (Element) subXmlItemAmt;
							strMm = subXmlElAmt.getAttribute("mm");
							strHiNtf = subXmlElAmt.getAttribute("hi_ntf");
							strLtrmNtf = subXmlElAmt.getAttribute("ltrm_ntf");
							strHiPmt = subXmlElAmt.getAttribute("hi_pmt");
							strLtrmPmt = subXmlElAmt.getAttribute("ltrm_pmt");
							
							if (strMm.equals("01")) {
								setPdfO101mVo(yetaPdfO101mVo, request, subXmlElData);
							}
							else if (strMm.equals("02")) {
								setPdfO101mVo(yetaPdfO101mVo, request, subXmlElData);
							}
							else if (strMm.equals("03")) {
								setPdfO101mVo(yetaPdfO101mVo, request, subXmlElData);
							}
							else if (strMm.equals("04")) {
								setPdfO101mVo(yetaPdfO101mVo, request, subXmlElData);
							}
							else if (strMm.equals("05")) {
								setPdfO101mVo(yetaPdfO101mVo, request, subXmlElData);
							}
							else if (strMm.equals("06")) {
								setPdfO101mVo(yetaPdfO101mVo, request, subXmlElData);
							}
							else if (strMm.equals("07")) {
								setPdfO101mVo(yetaPdfO101mVo, request, subXmlElData);
							}
							else if (strMm.equals("08")) {
								setPdfO101mVo(yetaPdfO101mVo, request, subXmlElData);
							}
							else if (strMm.equals("09")) {
								setPdfO101mVo(yetaPdfO101mVo, request, subXmlElData);
							}
							else if (strMm.equals("10")) {
								setPdfO101mVo(yetaPdfO101mVo, request, subXmlElData);
							}
							else if (strMm.equals("11")) {
								setPdfO101mVo(yetaPdfO101mVo, request, subXmlElData);
							}
							else if (strMm.equals("12")) {
								setPdfO101mVo(yetaPdfO101mVo, request, subXmlElData);
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
	}
	
	public static void setPdfO101mVo(InfcPkgPdfO101mVO yetaPdfO101mVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 
		}
		
		yetaPdfO101mVo.setHlthAmtMn(strMm);
		yetaPdfO101mVo.setHiNtf(new BigDecimal(MSFSharedUtils.defaultNulls(strHiNtf,"0")));
		yetaPdfO101mVo.setLtrmNtf(new BigDecimal(MSFSharedUtils.defaultNulls(strLtrmNtf,"0")));
		yetaPdfO101mVo.setHiPmt(new BigDecimal(MSFSharedUtils.defaultNulls(strHiPmt,"0")));
		yetaPdfO101mVo.setLtrmPmt(new BigDecimal(MSFSharedUtils.defaultNulls(strLtrmPmt,"0")));
		
		yetaPayr2200Service.yeta2200_PDF_O101M_2017_Delete(yetaPdfO101mVo);
		yetaPayr2200Service.yeta2200_PDF_O101M_2017_Insert(yetaPdfO101mVo);

	}
	
	public static void func_2017_O101M_YetaCalc(InfcPkgYe161010VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr2200Service = (Yeta2200XmlService)BeanFinder.getBean("Yeta2200XmlService");
		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
		
		/**+++++++++++   건강보험료 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
	 
        InfcPkgYe161040VO infcPkgYe161040Vo = new InfcPkgYe161040VO();
		
		infcPkgYe161040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161040Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161040Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//YE161040 소득공제명세에건강보험료
		yetaPayr2200Service.PdfYeta2017_O101M_YE161040_Update(infcPkgYe161040Vo); 
		 
		
		//건강보험료 금액 
		InfcPkgYe161060VO infcPkgYe161060Vo = new InfcPkgYe161060VO();
		
		
		infcPkgYe161060Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161060Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161060Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161060Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161060Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161060Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161060Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161060Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
		// 건강보험료 합계  
         yetaPayr2200Service.fnYeta2200_O101M_YE161060_2017_Update(infcPkgYe161060Vo); 
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr2200Service.yeta2200_PDF_YE162015_2017_Insert(ye161010VO);

		 
	}		
}
