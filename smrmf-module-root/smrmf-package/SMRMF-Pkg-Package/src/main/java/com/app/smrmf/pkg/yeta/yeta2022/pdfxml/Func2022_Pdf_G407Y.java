package com.app.smrmf.pkg.yeta.yeta2022.pdfxml;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG107m_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG407m_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG407y_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG407m_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfG407y_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfYE162015_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161040_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161070_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe166020_2022_VO;
import com.app.smrmf.pkg.yeta.yeta2016.pdfxml.service.YetaPayr1200Service;
import com.app.smrmf.pkg.yeta.yeta2022.pdfxml.service.Yeta7200XmlService;

public class Func2022_Pdf_G407Y {

	@Resource(name = "Yeta7200XmlService")
	private static Yeta7200XmlService yetaPayr3200Service;

	private static NodeList subXmlElChildForm = null;
	private static Node subXmlItemMan = null;
	private static NodeList subXmlElChildMan = null;
	private static Element subXmlElMan = null;
	private static Node subXmlItemData = null;
	private static Element subXmlElData = null;

	private static String strResid = "";
	private static String strDatCd = "";
	private static String strMn= "";
	private static String strFormCd = "";
	private static String strName = "";

	public static void func_2022_G407Y_G407M(InfcPkgYe161010_2022_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request ) throws Exception{

		/**+++++++++++  직불카드 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		//    직불카드 시작
		//직불카드등  연간합계 G302M 월별 G03 직불카드 등 본인+가족
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta7200XmlService) wac.getBean("Yeta7200XmlService" ); 
		}

		InfcPkgPdfG407y_2022_VO yetaPdfG407yVo = new InfcPkgPdfG407y_2022_VO();
		InfcPkgPdfG407m_2022_VO yetaPdfG407mVo = new InfcPkgPdfG407m_2022_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

		yetaPdfG407yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG407yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG407yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG407yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr3200Service.yeta7200_PDF_G407Y_2022_Delete(yetaPdfG407yVo);
		
		yetaPdfG407mVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG407mVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG407mVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG407mVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr3200Service.yeta7200_PDF_G407M_2022_Delete(yetaPdfG407mVo);
		
		strDatCd = "";
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		
		InfcPkgPdfYE162015_2022_VO yetaPdfYE162015Vo = new InfcPkgPdfYE162015_2022_VO();
		
		yetaPdfYE162015Vo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfYE162015Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfYE162015Vo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfYE162015Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfYE162015Vo.setFileAppPaprDivCd(strFormCd);
		
		yetaPayr3200Service.yeta7200_PDF_YE162015_2022_Delete(yetaPdfYE162015Vo);
		
		//인원별 반복구간
		for (int j = 0; j < subXmlElChildForm.getLength();j++) { 

			subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			subXmlElMan  = (Element) subXmlItemMan;

			strResid = subXmlElMan.getAttribute("resid");   //주민번호
			strName = subXmlElMan.getAttribute("name");	//이름
			
			
			
			//2021연말정산_추가
			//tot_pre_year_sum : 전년도 신용카드 사용합계액
			yetaPdfG407mVo.setTotPreYearSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tot_pre_year_sum", subXmlElMan), "0")));
			//tot_curr_year_sum : 이번년도 신용카드 사용합계액
			yetaPdfG407mVo.setTotCurrYearSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tot_curr_year_sum", subXmlElMan), "0")));
			
			//2022연말정산_추가
			//tdmr_tot_pre_year_sum : 전년도 전통시장 사용금액 합계
			yetaPdfG407mVo.setTdmrTotPreYearSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tdmr_tot_pre_year_sum", subXmlElMan), "0")));
			//tdmr_tot_curr_year_sum : 이번년도 전통시장 사용금액 합계
			yetaPdfG407mVo.setTdmrTotCurrYearSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tdmr_tot_curr_year_sum", subXmlElMan), "0")));
			//gnrl_sum : 2022일반합계
			yetaPdfG407mVo.setGnrlSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("gnrl_sum", subXmlElMan), "0")));
			//tdmr_sum : 2022전통시장합계
			yetaPdfG407mVo.setTdmrSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tdmr_sum", subXmlElMan), "0")));
			//trp_sum : 2022대중교통합계
			yetaPdfG407mVo.setTrpSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("trp_sum", subXmlElMan), "0")));
			//isld_sum : 2022도서공연등합계
			yetaPdfG407mVo.setIsldSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("isld_sum", subXmlElMan), "0")));
			//tot_sum : 2022총합계
			yetaPdfG407mVo.setTotSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tot_sum", subXmlElMan), "0")));
			//tfhy_gnrl_sum : 2022상반기일반합계
			yetaPdfG407mVo.setTfhyGnrlSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tfhy_gnrl_sum", subXmlElMan), "0")));
			//tfhy_tdmr_sum : 2022상반기전통시장합계
			yetaPdfG407mVo.setTfhyTdmrSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tfhy_tdmr_sum", subXmlElMan), "0")));
			//tfhy_trp_sum : 2022상반기대중교통합계
			yetaPdfG407mVo.setTfhyTrpSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tfhy_trp_sum", subXmlElMan), "0")));
			//tfhy_isld_sum : 2022상반기도서공연등합계
			yetaPdfG407mVo.setTfhyIsldSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tfhy_isld_sum", subXmlElMan), "0")));
			//tfhy_tot_sum : 2022상반기총합계
			yetaPdfG407mVo.setTfhyTotSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tfhy_tot_sum", subXmlElMan), "0")));
			//shfy_gnrl_sum : 2022하반기일반합계
			yetaPdfG407mVo.setShfyGnrlSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("shfy_gnrl_sum", subXmlElMan), "0")));
			//shfy_tdmr_sum : 2022하반기전통시장합계
			yetaPdfG407mVo.setShfyTdmrSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("shfy_tdmr_sum", subXmlElMan), "0")));
			//shfy_trp_sum : 2022하반기대중교통합계
			yetaPdfG407mVo.setShfyTrpSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("shfy_trp_sum", subXmlElMan), "0")));
			//shfy_isld_sum : 2022하반기도서공연등합계
			yetaPdfG407mVo.setShfyIsldSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("shfy_isld_sum", subXmlElMan), "0")));
			//shfy_tot_sum : 2022하반기총합계
			yetaPdfG407mVo.setShfyTotSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("shfy_tot_sum", subXmlElMan), "0")));
			//---------------------------
		
			
			
			yetaPdfG407mVo.setKybdr(sessionUser.getUsrId());
			yetaPdfG407mVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			yetaPdfG407mVo.setIsmt(sessionUser.getUsrId());
			yetaPdfG407mVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			String residValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			
			yetaPdfG407mVo.setResid(residValue);
			
			yetaPayr3200Service.yeta7200_PDF_G407M_2022_Insert(yetaPdfG407mVo);
			
			
			
			
			// 상품별 반복구간
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			
			//상품별 반복구간
			for(int k = 0; k < subXmlElChildMan.getLength();k++) {  

				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				strDatCd = subXmlElData.getAttribute("dat_cd"); 

				String strDecValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
				
				yetaPdfG407yVo.setFormCd(strFormCd);
				yetaPdfG407yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfG407yVo.setName(strName);
				yetaPdfG407yVo.setPdfDatAppYn("N");

				yetaPdfG407yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfG407yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfG407yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfG407yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0014")) { //  if strDatCd  = 'G03' then

					yetaPdfG407yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfG407yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfG407yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					
					if ((subXmlElData.getAttribute("use_place_cd")).equals("1") )  {
						setPdfG407yVo(yetaPdfG407yVo, request);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("2") )  {
						setPdfG407yVo(yetaPdfG407yVo, request);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("3") )  {
						setPdfG407yVo(yetaPdfG407yVo, request);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("4") )  {
						setPdfG407yVo(yetaPdfG407yVo, request);
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
		
		yetaPayr3200Service.yeta7200_PDF_YE162015_2022_Insert(yetaPdfYE162015Vo);
		//현금 영수증 종료
	}

	public static void setPdfG407yVo(InfcPkgPdfG407y_2022_VO yetaPdfG407yVo , HttpServletRequest request) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta7200XmlService) wac.getBean("Yeta7200XmlService" ); 
		}
		yetaPdfG407yVo.setUsePlaceCd(subXmlElData.getAttribute("use_place_cd"));
		yetaPdfG407yVo.setZeroAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));

		yetaPayr3200Service.yeta7200_PDF_G407Y_2022_Insert(yetaPdfG407yVo);

	}
	
	

	public static void func_2022_G407Y_YetaCalc(InfcPkgYe161010_2022_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta7200XmlService)BeanFinder.getBean("Yeta7200XmlService");
		int dataChk = 0;
		String datacheck = "";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
		/**+++++++++++  직불카드 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		//    직불카드 시작
        //직불카드등  연간합계 G302M 월별 G03 직불카드 등 본인+가족
		
		//2022연말정산_추가
		InfcPkgPdfG407m_2022_VO yetaPdfG407mVo = new InfcPkgPdfG407m_2022_VO();
				
		yetaPdfG407mVo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfG407mVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfG407mVo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfG407mVo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfG407mVo.setKybdr(sessionUser.getUsrId());
		yetaPdfG407mVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		yetaPdfG407mVo.setIsmt(sessionUser.getUsrId());
		yetaPdfG407mVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
		yetaPayr3200Service.yeta7200_PDF_G407M_2022_Update(yetaPdfG407mVo);
		
		
		
		InfcPkgYe161040_2022_VO infcPkgYe161040Vo = new InfcPkgYe161040_2022_VO();
			
		infcPkgYe161040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161040Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161040Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//YE161040 소득공제명세에 신용카드 
		dataChk = yetaPayr3200Service.PdfYeta2022_G407Y_YE161040_Update(infcPkgYe161040Vo); 
		
		if (dataChk >= 0) { 

			InfcPkgYe166020_2022_VO infcPkgYe166020Vo = new InfcPkgYe166020_2022_VO();
			
			infcPkgYe166020Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe166020Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe166020Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe166020Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
			infcPkgYe166020Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe166020Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe166020Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe166020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
				 
			yetaPayr3200Service.PdfYeta7200_G107Y_YE166020_Update(infcPkgYe166020Vo);  
			
			//신용카드
			InfcPkgYe161070_2022_VO infcPkgYe161070Vo = new InfcPkgYe161070_2022_VO();
			
			
			infcPkgYe161070Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe161070Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe161070Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe161070Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
			infcPkgYe161070Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe161070Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe161070Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe161070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
			// 신용카드  
	         yetaPayr3200Service.fnYeta7200_G407Y_YE161070_2022_Update(infcPkgYe161070Vo); 
	         
		}
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
	}	

}
