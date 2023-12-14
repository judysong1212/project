package com.app.smrmf.pkg.yeta.yeta2023.pdfxml;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfB201m_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfB201y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfYE162015_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161040_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161080_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe164010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe166030_2023_VO;
import com.app.smrmf.pkg.yeta.yeta2023.pdfxml.service.Yeta8200XmlService;

public class Func2023_Pdf_B201Y {

	@Resource(name = "Yeta8200XmlService")
	private static Yeta8200XmlService yetaPayr3200Service;

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
	
	private static final Logger logger = LoggerFactory.getLogger(Func2023_Pdf_B201Y.class);


	public static void func_2023_B201Y_B201M(InfcPkgYe161010_2023_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request) throws Exception{

		/**+++++++++++실손보험금시작+++++++++++++++++++++++++++++++++++++++++++++++++++*/
		//실손보험금시작
		//실손보험금
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta8200XmlService) wac.getBean("Yeta8200XmlService" ); 

		}
		
		InfcPkgPdfB201y_2023_VO yetaPdfB201yVo = new InfcPkgPdfB201y_2023_VO();
		InfcPkgPdfB201m_2023_VO yetaPdfB201mVo = new InfcPkgPdfB201m_2023_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		
		InfcPkgPdfYE162015_2023_VO yetaPdfYE162015Vo = new InfcPkgPdfYE162015_2023_VO();
		
		yetaPdfYE162015Vo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfYE162015Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfYE162015Vo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfYE162015Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfYE162015Vo.setFileAppPaprDivCd(strFormCd);
		
		//추가 20231215
		yetaPdfB201yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfB201yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfB201yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfB201yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		
		yetaPayr3200Service.yeta8200_PDF_B201Y_2023_Delete(yetaPdfB201yVo);
		
		yetaPayr3200Service.yeta8200_PDF_YE162015_2023_Delete(yetaPdfYE162015Vo);
		
		
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
				
				yetaPdfB201yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
				yetaPdfB201yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
				yetaPdfB201yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
				yetaPdfB201yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
				yetaPdfB201yVo.setFormCd(strFormCd);
				yetaPdfB201yVo.setResid(strValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfB201yVo.setName(strName);

				yetaPdfB201yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfB201yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfB201yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfB201yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				if (strDatCd.equals("G0040")) { //실손의료보험금

					
					yetaPdfB201yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfB201yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfB201yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					yetaPdfB201yVo.setAccNo(subXmlElData.getAttribute("acc_no"));
					
					//추가20201214
					yetaPdfB201yVo.setGoodsNm(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("goods_nm", subXmlElData)));
					
					
					yetaPdfB201yVo.setInsuResid(AnyCryptUtils.getEncSyncCrypt(nResult ,MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("insu_resid", subXmlElData)),AnyCryptUtils.SEC_RRNUMC));
					yetaPdfB201yVo.setInsuNm(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("insu_nm", subXmlElData)));
					
					yetaPdfB201yVo.setManSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));
					
					yetaPdfB201yVo.setPdfDatAppYn("N");
					
					/*yetaPayr3200Service.yeta8200_PDF_B201Y_2023_Delete(yetaPdfB201yVo);*/
					
					yetaPayr3200Service.yeta8200_PDF_B201Y_2023_Insert(yetaPdfB201yVo);
				} 
				
			}
		}
		yetaPdfYE162015Vo.setFileAppPaprSbtYn("Y");
		yetaPdfYE162015Vo.setFileAppPaprYetaYn("N");
		
		yetaPdfYE162015Vo.setKybdr(sessionUser.getUsrId());
		yetaPdfYE162015Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		yetaPdfYE162015Vo.setIsmt(sessionUser.getUsrId());
		yetaPdfYE162015Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta8200_PDF_YE162015_2023_Insert(yetaPdfYE162015Vo);
	}
	
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 실손보험금 내역 실손보험금 테이블에 인서트 
	 * 2. 처리내용 : 실손보험금 내역 실손보험금 테이블에 인서트 
	 * </pre>
	 * @Method Name : func_2023_B201Y_YetaCalc
	 * @date : 2023. 1. 23.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2023. 1. 23.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param ye161010VO
	 * @param request
	 * @throws Exception
	 */
	public static void func_2023_B201Y_YetaCalc(InfcPkgYe161010_2023_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta8200XmlService)BeanFinder.getBean("Yeta8200XmlService");
		 
		int statCnt = 0;
	  	String dataCheck = "";
	  	
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
		
		
		//**+++++++++++실손보험금시작+++++++++++++++++++++++++++++++++++++++++++++++++++*//*
        //실손보험금시작
        //실손보험금
		InfcPkgYe166030_2023_VO infcPkgYe166030Vo = new InfcPkgYe166030_2023_VO();
		
		infcPkgYe166030Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe166030Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe166030Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe166030Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe166030Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe166030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe166030Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe166030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		//실손의료보험 국세청 데이타 업데이트 
		yetaPayr3200Service.PdfYeta8200_B201Y_YE166030_Delete(infcPkgYe166030Vo); 
		
		yetaPayr3200Service.PdfYeta8200_B201Y_YE166030_Insert(infcPkgYe166030Vo); 
		
	
        InfcPkgYe161040_2023_VO infcPkgYe161040Vo = new InfcPkgYe161040_2023_VO();
		
		infcPkgYe161040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161040Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161040Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		statCnt = 0;
		//YE161040 소득공제명세에 실손보험금 개별 
		statCnt = yetaPayr3200Service.PdfYeta2023_B201Y_YE161040_Update(infcPkgYe161040Vo); 
	 
		if (statCnt >= 0) { 

			//실손보험금정리 
		    InfcPkgYe161080_2023_VO infcPkgYe161080Vo = new InfcPkgYe161080_2023_VO();
			
			
			infcPkgYe161080Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe161080Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe161080Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe161080Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
			infcPkgYe161080Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe161080Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe161080Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
			// 실손보험금정리 합계  
	         yetaPayr3200Service.fnYeta8200_B201Y_YE161080_2023_Update(infcPkgYe161080Vo); 
				 
		}
	}	
	
}
