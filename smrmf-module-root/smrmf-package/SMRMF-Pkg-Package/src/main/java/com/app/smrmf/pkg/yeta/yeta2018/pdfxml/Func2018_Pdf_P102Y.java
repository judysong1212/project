package com.app.smrmf.pkg.yeta.yeta2018.pdfxml;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfP102m_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfP102y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfYE162015_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161050_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161055_2018_VO;
import com.app.smrmf.pkg.yeta.yeta2018.pdfxml.service.Yeta3200XmlService;

public class Func2018_Pdf_P102Y {

	@Resource(name = "Yeta3200XmlService")
	private static Yeta3200XmlService yetaPayr3200Service;

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
	
	private static String strSpNtf= "";
	private static String strSpym= "";
	private static String strJlc = "";
	private static String strNtf = "";
	private static String strPmt = "";
	private static String strWrkpNtf = "";
	private static String strRgnPmt = "";
	
	public static void func_2018_P102Y_P102M(InfcPkgYe161010_2018_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request ) throws Exception{
		
		/**+++++++++++   국민연금보험료 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		//  국민연금보험료 시작
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta3200XmlService) wac.getBean("Yeta3200XmlService" ); 
		}

		InfcPkgPdfP102y_2018_VO yetaPdfP102yVo = new InfcPkgPdfP102y_2018_VO();
		InfcPkgPdfP102m_2018_VO yetaPdfP102mVo = new InfcPkgPdfP102m_2018_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

		strDatCd = "";
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 

		InfcPkgPdfYE162015_2018_VO yetaPdfYE162015Vo = new InfcPkgPdfYE162015_2018_VO();
		
		yetaPdfYE162015Vo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfYE162015Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfYE162015Vo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfYE162015Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfYE162015Vo.setFileAppPaprDivCd(strFormCd);
		
		yetaPayr3200Service.yeta3200_PDF_YE162015_2018_Delete(yetaPdfYE162015Vo);

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

				yetaPdfP102yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
				yetaPdfP102yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
				yetaPdfP102yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
				yetaPdfP102yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
				yetaPdfP102yVo.setFormCd(strFormCd);
				yetaPdfP102yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfP102yVo.setName(strName);
				yetaPdfP102yVo.setPdfDatAppYn("N");

				yetaPdfP102yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfP102yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfP102yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfP102yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0031")) {
					yetaPdfP102yVo.setDatCd(strDatCd);
					
					subXmlElChildSum= subXmlElData.getElementsByTagName("sum");

					for(int i = 0; i < subXmlElChildSum.getLength(); i++) {  
						subXmlItemSum =  subXmlElChildSum.item(i);
						subXmlElSum = (Element) subXmlItemSum;
						strSpNtf = subXmlElSum.getAttribute("sp_ntf");
						strSpym = subXmlElSum.getAttribute("spym");
						strJlc = subXmlElSum.getAttribute("jlc");
						strNtf = subXmlElSum.getAttribute("ntf");
						strPmt = subXmlElSum.getAttribute("pmt");
						
						yetaPdfP102yVo.setNatAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));
						yetaPdfP102yVo.setSpNtt(new BigDecimal(MSFSharedUtils.defaultNulls(strSpNtf,"0")));
						yetaPdfP102yVo.setSpym(new BigDecimal(MSFSharedUtils.defaultNulls(strSpym,"0")));
						yetaPdfP102yVo.setJlc(new BigDecimal(MSFSharedUtils.defaultNulls(strJlc,"0")));
						yetaPdfP102yVo.setNtf(new BigDecimal(MSFSharedUtils.defaultNulls(strNtf,"0")));
						yetaPdfP102yVo.setPmt(new BigDecimal(MSFSharedUtils.defaultNulls(strPmt,"0")));
						
						yetaPayr3200Service.yeta3200_PDF_P102Y_2018_Delete(yetaPdfP102yVo);
						yetaPayr3200Service.yeta3200_PDF_P102Y_2018_Insert(yetaPdfP102yVo);
					}
					
					if (strFormCd.equals("P102M")) {
						yetaPdfP102mVo.setDatCd(strDatCd);
						yetaPdfP102mVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
						yetaPdfP102mVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
						yetaPdfP102mVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
						yetaPdfP102mVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
						
						yetaPdfP102mVo.setKybdr(sessionUser.getUsrId());
						yetaPdfP102mVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						yetaPdfP102mVo.setIsmt(sessionUser.getUsrId());
						yetaPdfP102mVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						subXmlElChildAmt= subXmlElData.getElementsByTagName("amt");

						for(int i = 0; i < subXmlElChildAmt.getLength(); i++) {  
							subXmlItemAmt =  subXmlElChildAmt.item(i);
							subXmlElAmt = (Element) subXmlItemAmt;
							strMm = subXmlElAmt.getAttribute("mm");
							strWrkpNtf = subXmlElAmt.getAttribute("wrkp_ntf");
							strRgnPmt= subXmlElAmt.getAttribute("rgn_pmt");
							
							if (strMm.equals("01")) {
								setPdfP102mVo(yetaPdfP102mVo, request, subXmlElData);
							}
							else if (strMm.equals("02")) {
								setPdfP102mVo(yetaPdfP102mVo, request, subXmlElData);
							}
							else if (strMm.equals("03")) {
								setPdfP102mVo(yetaPdfP102mVo, request, subXmlElData);
							}
							else if (strMm.equals("04")) {
								setPdfP102mVo(yetaPdfP102mVo, request, subXmlElData);
							}
							else if (strMm.equals("05")) {
								setPdfP102mVo(yetaPdfP102mVo, request, subXmlElData);
							}
							else if (strMm.equals("06")) {
								setPdfP102mVo(yetaPdfP102mVo, request, subXmlElData);
							}
							else if (strMm.equals("07")) {
								setPdfP102mVo(yetaPdfP102mVo, request, subXmlElData);
							}
							else if (strMm.equals("08")) {
								setPdfP102mVo(yetaPdfP102mVo, request, subXmlElData);
							}
							else if (strMm.equals("09")) {
								setPdfP102mVo(yetaPdfP102mVo, request, subXmlElData);
							}
							else if (strMm.equals("10")) {
								setPdfP102mVo(yetaPdfP102mVo, request, subXmlElData);
							}
							else if (strMm.equals("11")) {
								setPdfP102mVo(yetaPdfP102mVo, request, subXmlElData);
							}
							else if (strMm.equals("12")) {
								setPdfP102mVo(yetaPdfP102mVo, request, subXmlElData);
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
		
		yetaPayr3200Service.yeta3200_PDF_YE162015_2018_Insert(yetaPdfYE162015Vo);
	}
	
	public static void setPdfP102mVo(InfcPkgPdfP102m_2018_VO yetaPdfP102mVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta3200XmlService) wac.getBean("Yeta3200XmlService" ); 
		}
		
		yetaPdfP102mVo.setNatAmtMn(strMm);
		yetaPdfP102mVo.setWrkpNtf(new BigDecimal(MSFSharedUtils.defaultNulls(strWrkpNtf,"0")));
		yetaPdfP102mVo.setRgnPmt(new BigDecimal(MSFSharedUtils.defaultNulls(strRgnPmt,"0")));
		
		yetaPayr3200Service.yeta3200_PDF_P102M_2018_Delete(yetaPdfP102mVo);
		yetaPayr3200Service.yeta3200_PDF_P102M_2018_Insert(yetaPdfP102mVo);
		

	}
	

	public static void func_2018_P102M_YetaCalc(InfcPkgYe161010_2018_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta3200XmlService)BeanFinder.getBean("Yeta3200XmlService");
		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
		
		/**+++++++++++   국민연금보험료 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
	 
        InfcPkgYe161055_2018_VO infcPkgYe161055Vo = new InfcPkgYe161055_2018_VO();
		
        infcPkgYe161055Vo.setDpobCd(sessionUser.getDpobCd());
        infcPkgYe161055Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
        infcPkgYe161055Vo.setSystemkey(ye161010VO.getSystemkey());
        infcPkgYe161055Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161055Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161055Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161055Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161055Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//YE161055 국민연금 주사업장 
		yetaPayr3200Service.PdfYeta2018_P102M_YE161055_Update(infcPkgYe161055Vo); 
		 
		
		//국민연금보험료
		InfcPkgYe161050_2018_VO infcPkgYe161050Vo = new InfcPkgYe161050_2018_VO();
		
		
		infcPkgYe161050Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161050Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161050Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161050Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161050Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161050Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161050Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161050Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
		// 국민연금보험료 합계  
         yetaPayr3200Service.fnYeta3200_P102M_YE161050_2018_Update(infcPkgYe161050Vo); 
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr3200Service.yeta3200_PDF_YE162015_2018_Insert(ye161010VO);

		 
	}			
}
