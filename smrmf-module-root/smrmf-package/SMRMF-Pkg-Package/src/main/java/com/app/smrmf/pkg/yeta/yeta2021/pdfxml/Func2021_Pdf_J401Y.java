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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ401m_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfJ401y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfYE162015_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161010_2021_VO;
import com.app.smrmf.pkg.yeta.yeta2016.pdfxml.service.YetaPayr1200Service;
import com.app.smrmf.pkg.yeta.yeta2021.pdfxml.service.Yeta6200XmlService;

public class Func2021_Pdf_J401Y {

	@Resource(name = "Yeta6200XmlService")
	private static Yeta6200XmlService yetaPayr3200Service;

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
	private static String strDdct = "";
	private static String strMm = "";
	private static String strFixCd = "";
	private static String strFormCd = "";
	private static String strName = "";
	
	public static void func_2021_J401Y_J401M(InfcPkgYe161010_2021_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request ) throws Exception{
		
		/**+++++++++++   목돈 안드는 전세 이자상환액++++++++++++++++++++++++++++++++++++++++++++++++*/
		// 2014년 신규 추가 테이블필드 완료
		// 목돈 안드는 전세 이자상환액  - -J401Y 기본  J401M 월별 J04 목돈 안드는 전세이자상환액 본인
		// edMonyItre
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 
		}
		strDatCd = "";
		
		InfcPkgPdfJ401y_2021_VO yetaPdfJ401yVo = new InfcPkgPdfJ401y_2021_VO();
		InfcPkgPdfJ401m_2021_VO yetaPdfJ401mVo = new InfcPkgPdfJ401m_2021_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		
		InfcPkgPdfYE162015_2021_VO yetaPdfYE162015Vo = new InfcPkgPdfYE162015_2021_VO();
		
		yetaPdfYE162015Vo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfYE162015Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfYE162015Vo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfYE162015Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfYE162015Vo.setFileAppPaprDivCd(strFormCd);
		
		yetaPayr3200Service.yeta6200_PDF_YE162015_2021_Delete(yetaPdfYE162015Vo);
		
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
				
				yetaPdfJ401yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
				yetaPdfJ401yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
				yetaPdfJ401yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
				yetaPdfJ401yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
				yetaPdfJ401yVo.setFormCd(strFormCd);
				yetaPdfJ401yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfJ401yVo.setName(strName);
				yetaPdfJ401yVo.setPdfDatAppYn("N");
				
				yetaPdfJ401yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfJ401yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfJ401yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfJ401yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0023")) {
					yetaPdfJ401yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfJ401yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfJ401yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					yetaPdfJ401yVo.setAccNo(subXmlElData.getAttribute("acc_no"));
					yetaPdfJ401yVo.setLendLoanAmt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("lend_loan_amt", subXmlElData),"0")));
					yetaPdfJ401yVo.setLendDt(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("lend_dt", subXmlElData)));
					yetaPdfJ401yVo.setSizSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));
					
					yetaPayr3200Service.yeta6200_PDF_J401Y_2021_Delete(yetaPdfJ401yVo);
					yetaPayr3200Service.yeta6200_PDF_J401Y_2021_Insert(yetaPdfJ401yVo);
				}
			}

		}
		yetaPdfYE162015Vo.setFileAppPaprSbtYn("Y");
		yetaPdfYE162015Vo.setFileAppPaprYetaYn("N");
		
		yetaPdfYE162015Vo.setKybdr(sessionUser.getUsrId());
		yetaPdfYE162015Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		yetaPdfYE162015Vo.setIsmt(sessionUser.getUsrId());
		yetaPdfYE162015Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta6200_PDF_YE162015_2021_Insert(yetaPdfYE162015Vo);
	}
}
