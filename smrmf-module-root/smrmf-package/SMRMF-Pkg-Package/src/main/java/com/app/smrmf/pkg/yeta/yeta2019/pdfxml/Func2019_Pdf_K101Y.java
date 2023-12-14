package com.app.smrmf.pkg.yeta.yeta2019.pdfxml;

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
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3100VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfJ203m_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfK101m_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfK101y_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfYE162015_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161010_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161070_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe162030_2019_VO;
import com.app.smrmf.pkg.yeta.yeta2016.pdfxml.service.YetaPayr1200Service;
import com.app.smrmf.pkg.yeta.yeta2019.pdfxml.service.Yeta4200XmlService;

public class Func2019_Pdf_K101Y {

	@Resource(name = "Yeta4200XmlService")
	private static Yeta4200XmlService yetaPayr3200Service;

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
	private static String strMm = "";
	private static String strDate = "";
	private static BigDecimal strAmt= null;
	private static String strDdct = "";
	private static String strFormCd = "";
	private static String strName = "";

	public static void func_2019_K101M(InfcPkgYe161010_2019_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request ) throws Exception{

		/**+++++++++++   소상공인공제 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		//  소상공인공제 시작
		//소기업소상공인 공제부금 - - K101M 월별 K01 소기업소상공인공제부금 본인
		// 월별상세만존제   edEtchPrep
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta4200XmlService) wac.getBean("Yeta4200XmlService" ); 
		}
		strDatCd = "";
		
		InfcPkgPdfK101y_2019_VO yetaPdfK101yVo = new InfcPkgPdfK101y_2019_VO();
		InfcPkgPdfK101m_2019_VO yetaPdfK101mVo = new InfcPkgPdfK101m_2019_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		
		InfcPkgPdfYE162015_2019_VO yetaPdfYE162015Vo = new InfcPkgPdfYE162015_2019_VO();
		
		yetaPdfYE162015Vo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfYE162015Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfYE162015Vo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfYE162015Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfYE162015Vo.setFileAppPaprDivCd(strFormCd);
		
		yetaPayr3200Service.yeta4200_PDF_YE162015_2019_Delete(yetaPdfYE162015Vo);
		
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
				
				yetaPdfK101yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
				yetaPdfK101yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
				yetaPdfK101yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
				yetaPdfK101yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
				yetaPdfK101yVo.setFormCd(strFormCd);
				yetaPdfK101yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfK101yVo.setName(strName);
				yetaPdfK101yVo.setPdfDatAppYn("N");
				
				yetaPdfK101yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfK101yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfK101yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfK101yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0019")) {
					yetaPdfK101yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfK101yVo.setAccNo(subXmlElData.getAttribute("acc_no"));
					yetaPdfK101yVo.setStartDt(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)));
					yetaPdfK101yVo.setEndDt(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("end_dt", subXmlElData)));
					yetaPdfK101yVo.setPayMethod(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("pay_method", subXmlElData)));
					
					subXmlElChildSum= subXmlElData.getElementsByTagName("sum");

					for(int i = 0; i < subXmlElChildSum.getLength(); i++) {  
						subXmlItemSum =  subXmlElChildSum.item(i);
						subXmlElSum = (Element) subXmlItemSum;
						strDdct = subXmlElSum.getAttribute("ddct");
						
						yetaPdfK101yVo.setBusnAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));
						yetaPdfK101yVo.setBusnSumDdct(new BigDecimal(MSFSharedUtils.defaultNulls(strDdct,"0")));
						
						yetaPayr3200Service.yeta4200_PDF_K101Y_2019_Delete(yetaPdfK101yVo);
						yetaPayr3200Service.yeta4200_PDF_K101Y_2019_Insert(yetaPdfK101yVo);
					}
					
					if (strFormCd.equals("K101M")) {
						yetaPdfK101mVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
						yetaPdfK101mVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
						yetaPdfK101mVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
						yetaPdfK101mVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
						yetaPdfK101mVo.setAccNo(subXmlElData.getAttribute("acc_no"));
						
						yetaPdfK101mVo.setKybdr(sessionUser.getUsrId());
						yetaPdfK101mVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						yetaPdfK101mVo.setIsmt(sessionUser.getUsrId());
						yetaPdfK101mVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						
						subXmlElChildAmt= subXmlElData.getElementsByTagName("amt");

						for(int i = 0; i < subXmlElChildAmt.getLength(); i++) {  
							subXmlItemAmt =  subXmlElChildAmt.item(i);
							subXmlElAmt = (Element) subXmlItemAmt;
							strMm = subXmlElAmt.getAttribute("mm");
							strDate = subXmlElAmt.getAttribute("date");
							strAmt = new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElAmt.getFirstChild().getNodeValue(),"0"));
							
							if (strMm.equals("01")) {
								setPdfK101mVo(yetaPdfK101mVo, request, subXmlElData);
							}
							else if (strMm.equals("02")) {
								setPdfK101mVo(yetaPdfK101mVo, request, subXmlElData);
							}
							else if (strMm.equals("03")) {
								setPdfK101mVo(yetaPdfK101mVo, request, subXmlElData);
							}
							else if (strMm.equals("04")) {
								setPdfK101mVo(yetaPdfK101mVo, request, subXmlElData);
							}
							else if (strMm.equals("05")) {
								setPdfK101mVo(yetaPdfK101mVo, request, subXmlElData);
							}
							else if (strMm.equals("06")) {
								setPdfK101mVo(yetaPdfK101mVo, request, subXmlElData);
							}
							else if (strMm.equals("07")) {
								setPdfK101mVo(yetaPdfK101mVo, request, subXmlElData);
							}
							else if (strMm.equals("08")) {
								setPdfK101mVo(yetaPdfK101mVo, request, subXmlElData);
							}
							else if (strMm.equals("09")) {
								setPdfK101mVo(yetaPdfK101mVo, request, subXmlElData);
							}
							else if (strMm.equals("10")) {
								setPdfK101mVo(yetaPdfK101mVo, request, subXmlElData);
							}
							else if (strMm.equals("11")) {
								setPdfK101mVo(yetaPdfK101mVo, request, subXmlElData);
							}
							else if (strMm.equals("12")) {
								setPdfK101mVo(yetaPdfK101mVo, request, subXmlElData);
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
		
		yetaPayr3200Service.yeta4200_PDF_YE162015_2019_Insert(yetaPdfYE162015Vo);
	}
	
	public static void setPdfK101mVo(InfcPkgPdfK101m_2019_VO yetaPdfK101mVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta4200XmlService) wac.getBean("Yeta4200XmlService" ); 
		}

		yetaPdfK101mVo.setBusnAmtNm(strMm);
		yetaPdfK101mVo.setBusnMmAmt(strAmt);
		yetaPdfK101mVo.setBusnDate(strDate);
		
		yetaPayr3200Service.yeta4200_PDF_K101M_2019_Delete(yetaPdfK101mVo);
		yetaPayr3200Service.yeta4200_PDF_K101M_2019_Insert(yetaPdfK101mVo);

	}
	
	public static void func_2019_K101M_YetaCalc(InfcPkgYe161010_2019_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta4200XmlService)BeanFinder.getBean("Yeta4200XmlService");
		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
	
		/**+++++++++++   소상공인공제 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
    	//  소상공인공제 시작
       //소기업소상공인 공제부금 - - K101M 월별 K01 소기업소상공인공제부금 본인
		
	 
		 
		//소상공인공제
		InfcPkgYe161070_2019_VO infcPkgYe161070Vo = new InfcPkgYe161070_2019_VO();
		
		
		infcPkgYe161070Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161070Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161070Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161070Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161070Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161070Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161070Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
		// 주택마련 합계  
         yetaPayr3200Service.fnYeta4200_K101M_YE161070_2019_Update(infcPkgYe161070Vo); 
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr3200Service.yeta3200_PDF_YE162015_2019_Insert(ye161010VO);

		 
	}	
}
