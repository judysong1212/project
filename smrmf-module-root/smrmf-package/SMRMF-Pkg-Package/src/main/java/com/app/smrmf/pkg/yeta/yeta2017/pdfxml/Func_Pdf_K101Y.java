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
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3100VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ203mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfK101mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfK101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfYE162015VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161070VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162030VO;
import com.app.smrmf.pkg.yeta.yeta2016.pdfxml.service.YetaPayr1200Service;
import com.app.smrmf.pkg.yeta.yeta2017.pdfxml.service.Yeta2200XmlService;

public class Func_Pdf_K101Y {

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
	private static String strMm = "";
	private static String strDate = "";
	private static BigDecimal strAmt= null;
	private static String strDdct = "";
	private static String strFormCd = "";
	private static String strName = "";

	public static void func_2017_K101M(InfcPkgYe161010VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request ) throws Exception{

		/**+++++++++++   소상공인공제 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		//  소상공인공제 시작
		//소기업소상공인 공제부금 - - K101M 월별 K01 소기업소상공인공제부금 본인
		// 월별상세만존제   edEtchPrep
		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 
		}
		strDatCd = "";
		
		InfcPkgPdfK101yVO yetaPdfK101yVo = new InfcPkgPdfK101yVO();
		InfcPkgPdfK101mVO yetaPdfK101mVo = new InfcPkgPdfK101mVO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
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
						
						yetaPayr2200Service.yeta2200_PDF_K101Y_2017_Delete(yetaPdfK101yVo);
						yetaPayr2200Service.yeta2200_PDF_K101Y_2017_Insert(yetaPdfK101yVo);
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
		
		yetaPayr2200Service.yeta2200_PDF_YE162015_2017_Insert(yetaPdfYE162015Vo);
	}
	
	public static void setPdfK101mVo(InfcPkgPdfK101mVO yetaPdfK101mVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 
		}

		yetaPdfK101mVo.setBusnAmtNm(strMm);
		yetaPdfK101mVo.setBusnMmAmt(strAmt);
		yetaPdfK101mVo.setBusnDate(strDate);
		
		yetaPayr2200Service.yeta2200_PDF_K101M_2017_Delete(yetaPdfK101mVo);
		yetaPayr2200Service.yeta2200_PDF_K101M_2017_Insert(yetaPdfK101mVo);

	}
	
	public static void func_2017_K101M_YetaCalc(InfcPkgYe161010VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr2200Service = (Yeta2200XmlService)BeanFinder.getBean("Yeta2200XmlService");
		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
	
		/**+++++++++++   소상공인공제 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
    	//  소상공인공제 시작
       //소기업소상공인 공제부금 - - K101M 월별 K01 소기업소상공인공제부금 본인
		
	 
		 
		//소상공인공제
		InfcPkgYe161070VO infcPkgYe161070Vo = new InfcPkgYe161070VO();
		
		
		infcPkgYe161070Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161070Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161070Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161070Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161070Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161070Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161070Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
		// 주택마련 합계  
         yetaPayr2200Service.fnYeta2200_K101M_YE161070_2017_Update(infcPkgYe161070Vo); 
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr2200Service.yeta2200_PDF_YE162015_2017_Insert(ye161010VO);

		 
	}	
}
