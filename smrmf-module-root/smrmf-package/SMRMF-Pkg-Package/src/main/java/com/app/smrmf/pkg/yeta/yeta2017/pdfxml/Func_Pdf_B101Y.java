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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfB101dVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfB101yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfYE162015VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161080VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe164010VO;
import com.app.smrmf.pkg.yeta.yeta2017.pdfxml.service.Yeta2200XmlService;

public class Func_Pdf_B101Y {

	@Resource(name = "Yeta2200XmlService")
	private static Yeta2200XmlService yetaPayr2200Service;

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


	public static void func_2017_B101Y_B101D(InfcPkgYe161010VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request) throws Exception{

		/**+++++++++++의료비시작+++++++++++++++++++++++++++++++++++++++++++++++++++*/
		//의료비시작
		//의료비 . 기본내역 (B01의료비 ) B03,B04,B05
		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 

		}
		
		InfcPkgPdfB101yVO yetaPdfB101yVo = new InfcPkgPdfB101yVO();
		InfcPkgPdfB101dVO yetaPdfB101dVo = new InfcPkgPdfB101dVO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		yetaPdfB101yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfB101yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfB101yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfB101yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr2200Service.yeta2200_PDF_B101Y_2017_Delete(yetaPdfB101yVo);
		
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
				
				yetaPdfB101yVo.setFormCd(strFormCd);
				yetaPdfB101yVo.setResid(strValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfB101yVo.setName(strName);

				yetaPdfB101yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfB101yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfB101yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfB101yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0003")) { //의료비
					yetaPdfB101yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfB101yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfB101yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					yetaPdfB101yVo.setPdfDatAppYn("N");
					yetaPdfB101yVo.setManSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));
					
					yetaPayr2200Service.yeta2200_PDF_B101Y_2017_Insert(yetaPdfB101yVo);
				} 
				else if  (strDatCd.equals("G0025")) {  //의료기기 구입비용
					yetaPdfB101yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfB101yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfB101yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					yetaPdfB101yVo.setManSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));
					yetaPdfB101yVo.setPdfDatAppYn("N");
					
					yetaPayr2200Service.yeta2200_PDF_B101Y_2017_Insert(yetaPdfB101yVo);
				}
				else if  (strDatCd.equals("G0026")) {   // 안경 또는 콘텍트렌즈 구입비용
					yetaPdfB101yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfB101yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfB101yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					yetaPdfB101yVo.setManSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));
					yetaPdfB101yVo.setPdfDatAppYn("N");

					yetaPayr2200Service.yeta2200_PDF_B101Y_2017_Insert(yetaPdfB101yVo);
				}
				else if  (strDatCd.equals("G0027")) {  //보청기 또는 장애인 보장구 구입비용
					yetaPdfB101yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfB101yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfB101yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					yetaPdfB101yVo.setManSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));
					yetaPdfB101yVo.setPdfDatAppYn("N");

					yetaPayr2200Service.yeta2200_PDF_B101Y_2017_Insert(yetaPdfB101yVo);
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
	
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 의료비 내역 의료비 테이블에 인서트 
	 * 2. 처리내용 : 의료비 내역 의료비 테이블에 인서트 
	 * </pre>
	 * @Method Name : func_2017_B101Y_YetaCalc
	 * @date : 2018. 1. 23.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 23.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param ye161010VO
	 * @param request
	 * @throws Exception
	 */
	public static void func_2017_B101Y_YetaCalc(InfcPkgYe161010VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr2200Service = (Yeta2200XmlService)BeanFinder.getBean("Yeta2200XmlService");
		 
		int statCnt = 0;
	  	String dataCheck = "";
	  	
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
		
		
		/**+++++++++++의료비시작+++++++++++++++++++++++++++++++++++++++++++++++++++*/
        //의료비시작
        //의료비 . 기본내역 (B01의료비 ) B03,B04,B05
		InfcPkgYe164010VO infcPkgYe164010Vo = new InfcPkgYe164010VO();
		
		infcPkgYe164010Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe164010Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe164010Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe164010Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe164010Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe164010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe164010Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe164010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		//의료보험 국세청 데이타 업데이트 
		yetaPayr2200Service.PdfYeta2200_B101Y_YE164010_Delete(infcPkgYe164010Vo); 
		yetaPayr2200Service.PdfYeta2200_B101Y_YE164010_Insert(infcPkgYe164010Vo); 
		
	
        InfcPkgYe161040VO infcPkgYe161040Vo = new InfcPkgYe161040VO();
		
		infcPkgYe161040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161040Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161040Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		statCnt = 0;
		//YE161040 소득공제명세에 의료비 개별 
		statCnt = yetaPayr2200Service.PdfYeta2017_B101Y_YE161040_Update(infcPkgYe161040Vo); 
	 
		if (statCnt >= 0) { 

			//의료비정리 
		    InfcPkgYe161080VO infcPkgYe161080Vo = new InfcPkgYe161080VO();
			
			
			infcPkgYe161080Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe161080Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe161080Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe161080Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
			infcPkgYe161080Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe161080Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe161080Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
			// 의료비정리 합계  
	         yetaPayr2200Service.fnYeta2200_B101Y_YE161080_2017_Update(infcPkgYe161080Vo); 
				 
		}
		
			
//		//제외 
//		InfcPkgYe161080VO infcPkgYe161080Vo = new InfcPkgYe161080VO();
//		
//		
//		infcPkgYe161080Vo.setDpobCd(sessionUser.getDpobCd());
//		infcPkgYe161080Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
//		infcPkgYe161080Vo.setSystemkey(ye161010VO.getSystemkey());
//		infcPkgYe161080Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
//		 					 
//		//의료비 합산금액처리 
//         yetaPayr2200Service.fnYeta2200_A102Y_YE161080_2017_Update(infcPkgYe161080Vo); 
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr2200Service.yeta2200_PDF_YE162015_2017_Insert(ye161010VO);

		//보험료 종료
	}		
	
}
