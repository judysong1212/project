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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfJ501m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfJ501y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfYE162015_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161040_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161080_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162510_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe164010_2020_VO;
import com.app.smrmf.pkg.yeta.yeta2020.pdfxml.service.Yeta5200XmlService;

public class Func2020_Pdf_J501Y {

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
	
	private static final Logger logger = LoggerFactory.getLogger(Func2020_Pdf_J501Y.class);


	public static void func_2020_J501Y_J501M(InfcPkgYe161010_2020_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request) throws Exception{

		/**+++++++++++월세액시작+++++++++++++++++++++++++++++++++++++++++++++++++++*/
		//월세액시작
		//월세액
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta5200XmlService) wac.getBean("Yeta5200XmlService" ); 

		}
		
		InfcPkgPdfJ501y_2020_VO yetaPdfJ501yVo = new InfcPkgPdfJ501y_2020_VO();
		InfcPkgPdfJ501m_2020_VO yetaPdfJ501mVo = new InfcPkgPdfJ501m_2020_VO();
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
		yetaPdfJ501yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfJ501yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfJ501yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfJ501yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		
		yetaPayr3200Service.yeta5200_PDF_J501Y_2020_Delete(yetaPdfJ501yVo);
		
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
				
				String strValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
				
				yetaPdfJ501yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
				yetaPdfJ501yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
				yetaPdfJ501yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
				yetaPdfJ501yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
				yetaPdfJ501yVo.setFormCd(strFormCd);
				yetaPdfJ501yVo.setResid(strValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfJ501yVo.setName(strName);

				yetaPdfJ501yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfJ501yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfJ501yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfJ501yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				/*logger.debug(strDatCd);
				logger.debug(yetaPdfJ501yVo.getDpobCd());
				logger.debug(yetaPdfJ501yVo.getYrtxBlggYr());
				logger.debug(yetaPdfJ501yVo.getClutSeptCd());
				logger.debug(yetaPdfJ501yVo.getSystemkey());
				logger.debug(strFormCd);
				logger.debug(yetaPdfJ501yVo.getFormCd());
				logger.debug(yetaPdfJ501yVo.getResid());
				logger.debug(strName);
				logger.debug(yetaPdfJ501yVo.getName());*/
				
				
				if (strDatCd.equals("G0037")) { //월세액

					
					yetaPdfJ501yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfJ501yVo.setLsorNo(subXmlElData.getAttribute("lsor_no"));			//사업자번호
					yetaPdfJ501yVo.setLsorNm(subXmlElData.getAttribute("lsor_nm"));	//상호명
					
					yetaPdfJ501yVo.setRentalSt(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)));
					yetaPdfJ501yVo.setRentalDt(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("end_dt", subXmlElData)));
					yetaPdfJ501yVo.setRentalAdr(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("adr", subXmlElData)));
					yetaPdfJ501yVo.setRentalArea(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("area", subXmlElData)));
					yetaPdfJ501yVo.setRentalCd(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("typeCd", subXmlElData)));
					/*yetaPdfJ501yVo.setRentalSt(subXmlElData.getAttribute("strt_dt"));
					yetaPdfJ501yVo.setRentalDt(subXmlElData.getAttribute("end_dt"));
					yetaPdfJ501yVo.setRentalAdr(subXmlElData.getAttribute("adr"));
					yetaPdfJ501yVo.setRentalArea(subXmlElData.getAttribute("area"));*/
					
					//LOGGER
					/*logger.debug(yetaPdfJ501yVo.getDatCd());
					logger.debug(yetaPdfJ501yVo.getLsorNo());
					logger.debug(yetaPdfJ501yVo.getLsorNm());
					
					logger.debug(yetaPdfJ501yVo.getRentalCd());
					logger.debug(yetaPdfJ501yVo.getRentalSt());
					logger.debug(yetaPdfJ501yVo.getRentalDt());
					logger.debug(yetaPdfJ501yVo.getRentalAdr());
					logger.debug(yetaPdfJ501yVo.getRentalArea());*/
					
					if (yetaPdfJ501yVo.getRentalCd().equals("01")){
						
						setPdfJ501yVo(yetaPdfJ501yVo, request, subXmlElData);
						
					} else if(yetaPdfJ501yVo.getRentalCd().equals("02")){
						
						setPdfJ501yVo(yetaPdfJ501yVo, request, subXmlElData);
						
					} else if(yetaPdfJ501yVo.getRentalCd().equals("03")){
						
						setPdfJ501yVo(yetaPdfJ501yVo, request, subXmlElData);
						
					} else if(yetaPdfJ501yVo.getRentalCd().equals("04")){
						
						setPdfJ501yVo(yetaPdfJ501yVo, request, subXmlElData);
						
					} else if(yetaPdfJ501yVo.getRentalCd().equals("05")){
						
						setPdfJ501yVo(yetaPdfJ501yVo, request, subXmlElData);
						
					} else if(yetaPdfJ501yVo.getRentalCd().equals("06")){
						
						setPdfJ501yVo(yetaPdfJ501yVo, request, subXmlElData);
						
					} else if(yetaPdfJ501yVo.getRentalCd().equals("07")){
						
						setPdfJ501yVo(yetaPdfJ501yVo, request, subXmlElData);
						
					} else if(yetaPdfJ501yVo.getRentalCd().equals("99")){
						
						setPdfJ501yVo(yetaPdfJ501yVo, request, subXmlElData);
						
					}
						
					/*yetaPdfJ501yVo.setRentalAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));*/
					
					/*yetaPdfJ501yVo.setPdfDatAppYn("N");
					
					yetaPayr3200Service.yeta5200_PDF_J501Y_2020_Insert(yetaPdfJ501yVo);*/
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
	
	
	
	public static void setPdfJ501yVo (InfcPkgPdfJ501y_2020_VO yetaPdfJ501yVo, HttpServletRequest request, Element subXmlElData) throws Exception{
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta5200XmlService) wac.getBean("Yeta5200XmlService" ); 
		}
		yetaPdfJ501yVo.setRentalAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));

		yetaPdfJ501yVo.setPdfDatAppYn("N");
		
		yetaPayr3200Service.yeta5200_PDF_J501Y_2020_Insert(yetaPdfJ501yVo);
	}
	
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 월세액 내역 월세액 테이블에 인서트 
	 * 2. 처리내용 : 월세액 내역 월세액 테이블에 인서트 
	 * </pre>
	 * @Method Name : func_2020_J501Y_YetaCalc
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
	public static void func_2020_J501Y_YetaCalc(InfcPkgYe161010_2020_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta5200XmlService)BeanFinder.getBean("Yeta5200XmlService");
		 
		int statCnt = 0;
	  	String dataCheck = "";
	  	
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
		
		
		//**+++++++++++월세액시작+++++++++++++++++++++++++++++++++++++++++++++++++++*//*
        //월세액시작,161080,162510
        //월세액
		InfcPkgYe162510_2020_VO infcPkgYe162510Vo = new InfcPkgYe162510_2020_VO();
		
		infcPkgYe162510Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe162510Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe162510Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe162510Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe162510Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe162510Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe162510Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe162510Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		//월세액 국세청 데이타 업데이트 
		yetaPayr3200Service.PdfYeta5200_J501Y_YE162510_Delete(infcPkgYe162510Vo); 
		yetaPayr3200Service.PdfYeta5200_J501Y_YE162510_Insert(infcPkgYe162510Vo); 
		
	
        InfcPkgYe161080_2020_VO infcPkgYe161080Vo = new InfcPkgYe161080_2020_VO();
		
        infcPkgYe161080Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161080Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161080Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161080Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161080Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161080Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161080Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		// 월세액정리 합계  
        yetaPayr3200Service.fnYeta5200_J501Y_YE161080_2020_Update(infcPkgYe161080Vo); 
				 
	}		
	
}
