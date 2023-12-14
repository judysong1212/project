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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.egov.comutils.payr.PkgFuncUtils;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfQ301m_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfQ301y_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgPdfYE162015_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161040_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161070_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161080_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe164010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe166040_2021_VO;
import com.app.smrmf.pkg.yeta.yeta2021.pdfxml.service.Yeta6200XmlService;

public class Func2021_Pdf_Q301Y {

	@Resource(name = "Yeta6200XmlService")
	private static Yeta6200XmlService yetaPayr3200Service;

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
	
	private static final Logger logger = LoggerFactory.getLogger(Func2021_Pdf_Q301Y.class);


	public static void func_2021_Q301Y_Q301M(InfcPkgYe161010_2021_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request) throws Exception{

		/**+++++++++++밴쳐기업투자신탁시작+++++++++++++++++++++++++++++++++++++++++++++++++++*/
		//밴쳐기업투자신탁시작
		//밴쳐기업투자신탁
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 

		}
		
		InfcPkgPdfQ301y_2021_VO yetaPdfQ301yVo = new InfcPkgPdfQ301y_2021_VO();
		InfcPkgPdfQ301m_2021_VO yetaPdfQ301mVo = new InfcPkgPdfQ301m_2021_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		
		InfcPkgPdfYE162015_2021_VO yetaPdfYE162015Vo = new InfcPkgPdfYE162015_2021_VO();
		
		yetaPdfYE162015Vo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfYE162015Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfYE162015Vo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfYE162015Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfYE162015Vo.setFileAppPaprDivCd(strFormCd);
		
		//추가 20211215
		yetaPdfQ301yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfQ301yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfQ301yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfQ301yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		
		yetaPayr3200Service.yeta6200_PDF_Q301Y_2021_Delete(yetaPdfQ301yVo);
		
		yetaPayr3200Service.yeta6200_PDF_YE162015_2021_Delete(yetaPdfYE162015Vo);
		
		
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
				
				yetaPdfQ301yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
				yetaPdfQ301yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
				yetaPdfQ301yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
				yetaPdfQ301yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
				yetaPdfQ301yVo.setFormCd(strFormCd);
				yetaPdfQ301yVo.setResid(strValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfQ301yVo.setName(strName);

				yetaPdfQ301yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfQ301yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfQ301yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfQ301yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				if (strDatCd.equals("G0035")) { //밴처기업투자신탁

					
					yetaPdfQ301yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfQ301yVo.setBusnid(MSFSharedUtils.allowNulls(strBusnid));
					yetaPdfQ301yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));
					yetaPdfQ301yVo.setSecuNo(subXmlElData.getAttribute("secu_no"));
					yetaPdfQ301yVo.setFundNm(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("fund_nm", subXmlElData)));
					yetaPdfQ301yVo.setRegDt(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("reg_dt", subXmlElData)));
					yetaPdfQ301yVo.setComCd(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData)));
					yetaPdfQ301yVo.setVntAsctClCd(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("vnt_asct_cl_cd", subXmlElData)));
					//LOGGER
					/*logger.debug(yetaPdfQ301yVo.getRentalCd());
					logger.debug(yetaPdfQ301yVo.getRentalSt());
					logger.debug(yetaPdfQ301yVo.getRentalDt());
					logger.debug(yetaPdfQ301yVo.getRentalAdr());
					logger.debug(yetaPdfQ301yVo.getRentalArea());*/
					
					if (yetaPdfQ301yVo.getVntAsctClCd().equals("1")){
						
						setPdfQ301yVo(yetaPdfQ301yVo, request, subXmlElData);
						
					} else if(yetaPdfQ301yVo.getVntAsctClCd().equals("2")){
						
						setPdfQ301yVo(yetaPdfQ301yVo, request, subXmlElData);
						
						//2021연말정산_추가
					}  else if(yetaPdfQ301yVo.getVntAsctClCd().equals("3")){
						
						setPdfQ301yVo(yetaPdfQ301yVo, request, subXmlElData);
						
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
		
		yetaPayr3200Service.yeta6200_PDF_YE162015_2021_Insert(yetaPdfYE162015Vo);
	}
	
	
	
	public static void setPdfQ301yVo (InfcPkgPdfQ301y_2021_VO yetaPdfQ301yVo, HttpServletRequest request, Element subXmlElData) throws Exception{
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 
		}
		yetaPdfQ301yVo.setVntSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));

		yetaPdfQ301yVo.setPdfDatAppYn("N");
		
		yetaPayr3200Service.yeta6200_PDF_Q301Y_2021_Insert(yetaPdfQ301yVo);
	}
	
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 밴쳐기업투자신탁 내역 밴쳐기업투자신탁 테이블에 인서트 
	 * 2. 처리내용 : 밴쳐기업투자신탁 내역 밴쳐기업투자신탁 테이블에 인서트 
	 * </pre>
	 * @Method Name : func_2021_Q301Y_YetaCalc
	 * @date : 2021. 1. 23.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2021. 1. 23.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param ye161010VO
	 * @param request
	 * @throws Exception
	 */
	public static void func_2021_Q301Y_YetaCalc(InfcPkgYe161010_2021_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta6200XmlService)BeanFinder.getBean("Yeta6200XmlService");
		 
		int statCnt = 0;
	  	String dataCheck = "";
	  	
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
		
		
		//**+++++++++++밴쳐기업투자신탁시작+++++++++++++++++++++++++++++++++++++++++++++++++++*//*
        //밴쳐기업투자신탁시작 166040, 161070
        //밴쳐기업투자신탁
		InfcPkgYe166040_2021_VO infcPkgYe166040Vo = new InfcPkgYe166040_2021_VO();
		
		infcPkgYe166040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe166040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe166040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe166040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe166040Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe166040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe166040Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe166040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		//밴쳐기업투자신탁 국세청 데이타 업데이트 
		yetaPayr3200Service.PdfYeta6200_Q301Y_YE166040_Delete(infcPkgYe166040Vo); 
		yetaPayr3200Service.PdfYeta6200_Q301Y_YE166040_Insert(infcPkgYe166040Vo); 
		
	
		InfcPkgYe161070_2021_VO infcPkgYe161070Vo = new InfcPkgYe161070_2021_VO();
		
        infcPkgYe161070Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161070Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161070Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161070Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161070Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161070Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161070Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		// 벤처기업투자신탁 합계  
        yetaPayr3200Service.fnYeta6200_Q301Y_YE161070_2021_Update(infcPkgYe161070Vo); 
				 
		}
}		
	
