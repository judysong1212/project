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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.egov.comutils.payr.PkgFuncUtils;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfQ201m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfQ201y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfYE162015_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161040_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161080_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe164010_2020_VO;
import com.app.smrmf.pkg.yeta.yeta2020.pdfxml.service.Yeta5200XmlService;

public class Func2020_Pdf_Q201Y {

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
	private static String strFormCd  = "";
	private static String strName = "";
	private static String strBusnid = "";
	
	private static final Logger logger = LoggerFactory.getLogger(Func2020_Pdf_Q201Y.class);


	public static void func_2020_Q201Y_Q201M(InfcPkgYe161010_2020_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request) throws Exception{

		/**+++++++++++밴쳐기업투자신탁시작+++++++++++++++++++++++++++++++++++++++++++++++++++*/
		//밴쳐기업투자신탁시작
		//밴쳐기업투자신탁
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta5200XmlService) wac.getBean("Yeta5200XmlService" ); 

		}
		
		InfcPkgPdfQ201y_2020_VO yetaPdfQ201yVo = new InfcPkgPdfQ201y_2020_VO();
		InfcPkgPdfQ201m_2020_VO yetaPdfQ201mVo = new InfcPkgPdfQ201m_2020_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		
		InfcPkgPdfYE162015_2020_VO yetaPdfYE162015Vo = new InfcPkgPdfYE162015_2020_VO();
		
		yetaPdfYE162015Vo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfYE162015Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfYE162015Vo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfYE162015Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfYE162015Vo.setFileAppPaprDivCd(strFormCd);
		
		//추가 20201215
		yetaPdfQ201yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfQ201yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfQ201yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfQ201yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		
		yetaPayr3200Service.yeta5200_PDF_Q201Y_2020_Delete(yetaPdfQ201yVo);
		
		yetaPayr3200Service.yeta5200_PDF_YE162015_2020_Delete(yetaPdfYE162015Vo);
		
		
		//인원별 반복구간
		for (int j= 0;j < subXmlElChildForm.getLength();j++)  {
			
			subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			subXmlElMan  = (Element) subXmlItemMan;
			
			strResid = subXmlElMan.getAttribute("resid");   //주민번호
			strName = subXmlElMan.getAttribute("name");	//이름
			
			//기관별반복구간 
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			
			
			//상품별 반복구간
			for(int k = 0; k < subXmlElChildMan.getLength();k++) {  

				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				strDatCd = subXmlElData.getAttribute("dat_cd");
				strBusnid = subXmlElData.getAttribute("busnid");
				
				String strValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
				
				yetaPdfQ201yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
				yetaPdfQ201yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
				yetaPdfQ201yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
				yetaPdfQ201yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
				yetaPdfQ201yVo.setFormCd(strFormCd);
				yetaPdfQ201yVo.setResid(strValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfQ201yVo.setName(strName);

				yetaPdfQ201yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfQ201yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfQ201yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfQ201yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				if (strDatCd.equals("G0035")) { //밴처기업투자신탁

					
					yetaPdfQ201yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfQ201yVo.setBusnid(MSFSharedUtils.allowNulls(strBusnid));
					yetaPdfQ201yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));
					yetaPdfQ201yVo.setSecuNo(subXmlElData.getAttribute("secu_no"));
					yetaPdfQ201yVo.setFundNm(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("fund_nm", subXmlElData)));
					yetaPdfQ201yVo.setRegDt(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("reg_dt", subXmlElData)));
					yetaPdfQ201yVo.setComCd(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData)));
					yetaPdfQ201yVo.setVntAsctClCd(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("vnt_asct_cl_cd", subXmlElData)));
					//LOGGER
					/*logger.debug(yetaPdfQ201yVo.getRentalCd());
					logger.debug(yetaPdfQ201yVo.getRentalSt());
					logger.debug(yetaPdfQ201yVo.getRentalDt());
					logger.debug(yetaPdfQ201yVo.getRentalAdr());
					logger.debug(yetaPdfQ201yVo.getRentalArea());*/
					
					if (yetaPdfQ201yVo.getVntAsctClCd().equals("1")){
						
						setPdfQ201yVo(yetaPdfQ201yVo, request, subXmlElData);
						
					} else if(yetaPdfQ201yVo.getVntAsctClCd().equals("2")){
						
						setPdfQ201yVo(yetaPdfQ201yVo, request, subXmlElData);
						
					} 
						
					/*yetaPdfQ201yVo.setRentalAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));*/
					
					/*yetaPdfQ201yVo.setPdfDatAppYn("N");
					
					yetaPayr3200Service.yeta5200_PDF_Q201Y_2020_Insert(yetaPdfQ201yVo);*/
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
	
	
	
	public static void setPdfQ201yVo (InfcPkgPdfQ201y_2020_VO yetaPdfQ201yVo, HttpServletRequest request, Element subXmlElData) throws Exception{
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta5200XmlService) wac.getBean("Yeta5200XmlService" ); 
		}
		yetaPdfQ201yVo.setVntSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));

		yetaPdfQ201yVo.setPdfDatAppYn("N");
		
		yetaPayr3200Service.yeta5200_PDF_Q201Y_2020_Insert(yetaPdfQ201yVo);
	}
	
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 밴쳐기업투자신탁 내역 밴쳐기업투자신탁 테이블에 인서트 
	 * 2. 처리내용 : 밴쳐기업투자신탁 내역 밴쳐기업투자신탁 테이블에 인서트 
	 * </pre>
	 * @Method Name : func_2020_Q201Y_YetaCalc
	 * @date : 2020. 1. 23.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2020. 1. 23.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param ye161010VO
	 * @param request
	 * @throws Exception
	 */
	/*public static void func_2020_Q201Y_YetaCalc(InfcPkgYe161010_2020_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta5200XmlService)BeanFinder.getBean("Yeta5200XmlService");
		 
		int statCnt = 0;
	  	String dataCheck = "";
	  	
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
		
		
		*//**+++++++++++밴쳐기업투자신탁시작+++++++++++++++++++++++++++++++++++++++++++++++++++*//*
        //밴쳐기업투자신탁시작
        //밴쳐기업투자신탁
		InfcPkgYe164010_2020_VO infcPkgYe164010Vo = new InfcPkgYe164010_2020_VO();
		
		infcPkgYe164010Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe164010Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe164010Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe164010Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe164010Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe164010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe164010Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe164010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		//밴쳐기업투자신탁 국세청 데이타 업데이트 
		yetaPayr3200Service.PdfYeta5200_Q201Y_YE164010_Delete(infcPkgYe164010Vo); 
		yetaPayr3200Service.PdfYeta5200_Q201Y_YE164010_Insert(infcPkgYe164010Vo); 
		
	
        InfcPkgYe161040_2020_VO infcPkgYe161040Vo = new InfcPkgYe161040_2020_VO();
		
		infcPkgYe161040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161040Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161040Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		statCnt = 0;
		//YE161040 소득공제명세에 밴쳐기업투자신탁 개별 
		statCnt = yetaPayr3200Service.PdfYeta2020_Q201Y_YE161040_Update(infcPkgYe161040Vo); 
	 
		if (statCnt >= 0) { 

			//밴쳐기업투자신탁정리 
		    InfcPkgYe161080_2020_VO infcPkgYe161080Vo = new InfcPkgYe161080_2020_VO();
			
			
			infcPkgYe161080Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe161080Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe161080Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe161080Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
			infcPkgYe161080Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe161080Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe161080Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
			// 밴쳐기업투자신탁정리 합계  
	         yetaPayr3200Service.fnYeta5200_Q201Y_YE161080_2020_Update(infcPkgYe161080Vo); 
				 
		}
	}	*/	
	
}
