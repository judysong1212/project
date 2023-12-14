package com.app.smrmf.pkg.yeta.yeta2020.pdfxml;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfN101m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfN101y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfYE162015_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161070_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162040_2020_VO;
import com.app.smrmf.pkg.yeta.yeta2020.pdfxml.service.Yeta5200XmlService;

public class Func2020_Pdf_N101Y {

	@Resource(name = "Yeta5200XmlService")
	private static Yeta5200XmlService yetaPayr3200Service;

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
	
	public static void func_2020_N101Y_N101M(InfcPkgYe161010_2020_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request) throws Exception{
		
		/**+++++++++++   장기집합 투자 증권 저축++++++++++++++++++++++++++++++++++++++++++++++++*/
		//  2014 년도 귀속
		//장기집합 투자 증권 저축
		//Y0040110	B011	0110	장기집합투자증권저축					51
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta5200XmlService) wac.getBean("Yeta5200XmlService" ); 
		}

		InfcPkgPdfN101y_2020_VO yetaPdfN101yVo = new InfcPkgPdfN101y_2020_VO();
		InfcPkgPdfN101m_2020_VO yetaPdfN101dVo = new InfcPkgPdfN101m_2020_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

		strDatCd = "";
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 

		InfcPkgPdfYE162015_2020_VO yetaPdfYE162015Vo = new InfcPkgPdfYE162015_2020_VO();
		
		yetaPdfYE162015Vo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfYE162015Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfYE162015Vo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfYE162015Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfYE162015Vo.setFileAppPaprDivCd(strFormCd);
		
		yetaPayr3200Service.yeta5200_PDF_YE162015_2020_Delete(yetaPdfYE162015Vo);
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

				yetaPdfN101yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
				yetaPdfN101yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
				yetaPdfN101yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
				yetaPdfN101yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
				yetaPdfN101yVo.setFormCd(strFormCd);
				yetaPdfN101yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfN101yVo.setName(strName);
				yetaPdfN101yVo.setPdfDatAppYn("N");

				yetaPdfN101yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfN101yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfN101yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfN101yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0029")) {
					yetaPdfN101yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfN101yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfN101yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명		
					yetaPdfN101yVo.setSecuNo(subXmlElData.getAttribute("secu_no"));
					
					yetaPdfN101yVo.setFundNm(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("fund_nm", subXmlElData)));
					yetaPdfN101yVo.setRegDt(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("reg_dt", subXmlElData)));
					yetaPdfN101yVo.setComCd(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData)));
					yetaPdfN101yVo.setLongAssSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));
					yetaPdfN101yVo.setDdctBsAssAmt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("ddct_bs_ass_amt", subXmlElData),"0")));
					
					yetaPayr3200Service.yeta5200_PDF_N101Y_2020_Delete(yetaPdfN101yVo);
					yetaPayr3200Service.yeta5200_PDF_N101Y_2020_Insert(yetaPdfN101yVo);
					
				}
			} 

		}
		yetaPdfYE162015Vo.setFileAppPaprSbtYn("Y");
		yetaPdfYE162015Vo.setFileAppPaprYetaYn("N");
		
		yetaPdfYE162015Vo.setKybdr(sessionUser.getUsrId());
		yetaPdfYE162015Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		yetaPdfYE162015Vo.setIsmt(sessionUser.getUsrId());
		yetaPdfYE162015Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta5200_PDF_YE162015_2020_Insert(yetaPdfYE162015Vo);

	}
	
	public static void func_2020_N101Y_YetaCalc(InfcPkgYe161010_2020_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta5200XmlService)BeanFinder.getBean("Yeta5200XmlService");
		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
	
		/**+++++++++++   장기집합 투자 증권 저축++++++++++++++++++++++++++++++++++++++++++++++++*/
    	//  2014 년도 귀속
       //장기집합 투자 증권 저축
       //Y0040110	B011	0110	장기집합투자증권저축					51
		
		InfcPkgYe162040_2020_VO infcPkgYe162040Vo = new InfcPkgYe162040_2020_VO();
		
		infcPkgYe162040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe162040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe162040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe162040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe162040Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe162040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe162040Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe162040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//장기집합 투자 증권
		yetaPayr3200Service.PdfYeta5200_N101Y_YE162040_Delete(infcPkgYe162040Vo); 
		yetaPayr3200Service.PdfYeta5200_N101Y_YE162040_Insert(infcPkgYe162040Vo); 
		 
		//장기집합 투자 증권
		InfcPkgYe161070_2020_VO infcPkgYe161070Vo = new InfcPkgYe161070_2020_VO();
		
		
		infcPkgYe161070Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161070Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161070Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161070Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161070Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161070Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161070Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
		// 장기집합 투자 증권 합계  
         yetaPayr3200Service.fnYeta5200_N101Y_YE161070_2020_Update(infcPkgYe161070Vo); 
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr3200Service.yeta5200_PDF_YE162015_2020_Insert(ye161010VO);

		 
	}	
}
