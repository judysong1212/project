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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG107m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG107y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfYE162015_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161040_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161070_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe166020_2020_VO;
import com.app.smrmf.pkg.yeta.yeta2020.pdfxml.service.Yeta5200XmlService;

public class Func2020_Pdf_G107Y {

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
	
	private static final Logger logger = LoggerFactory.getLogger(Func2020_Pdf_J501Y.class);

	public static void func_2020_G107Y_G107M(InfcPkgYe161010_2020_VO ye161010VO, Element  subXmlElForm, String nResult , HttpServletRequest request ) throws Exception{

		//신용카드(2017년 귀속부터)
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta5200XmlService) wac.getBean("Yeta5200XmlService" ); 
		}

		InfcPkgPdfG107y_2020_VO yetaPdfG107yVo = new InfcPkgPdfG107y_2020_VO();
		InfcPkgPdfG107m_2020_VO yetaPdfG107mVo = new InfcPkgPdfG107m_2020_VO();
		
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		yetaPdfG107yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG107yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG107yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG107yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr3200Service.yeta5200_PDF_G107Y_2020_Delete(yetaPdfG107yVo);
		
		
		//m테이블사용
		yetaPdfG107mVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG107mVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG107mVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG107mVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */
		
		yetaPayr3200Service.yeta5200_PDF_G107M_2020_Delete(yetaPdfG107mVo);

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
			
			
			//2020연말정산_월별금액위해서 g107m사용
			yetaPdfG107mVo.setCardAmtSum3(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("gnrl_mar_sum", subXmlElMan), "0")));
			yetaPdfG107mVo.setCardAmtSum47(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("gnrl_aprl_sum", subXmlElMan), "0")));
			yetaPdfG107mVo.setCardAmtSumOth(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("gnrl_jan_sum", subXmlElMan), "0")));
			
			yetaPdfG107mVo.setCardTdmrSum3(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tdmr_mar_sum", subXmlElMan), "0")));
			yetaPdfG107mVo.setCardTdmrSum47(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tdmr_aprl_sum", subXmlElMan), "0")));
			yetaPdfG107mVo.setCardTdmrSumOth(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tdmr_jan_sum", subXmlElMan), "0")));
			
			yetaPdfG107mVo.setCardPbtSum3(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("trp_mar_sum", subXmlElMan), "0")));
			yetaPdfG107mVo.setCardPbtSum47(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("trp_aprl_sum", subXmlElMan), "0")));
			yetaPdfG107mVo.setCardPbtSumOth(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("trp_jan_sum", subXmlElMan), "0")));
			
			yetaPdfG107mVo.setCardBookSum3(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("isld_mar_sum", subXmlElMan), "0")));
			yetaPdfG107mVo.setCardBookSum47(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("isld_aprl_sum", subXmlElMan), "0")));
			yetaPdfG107mVo.setCardBookSumOth(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("isld_jan_sum", subXmlElMan), "0")));
			
			yetaPdfG107mVo.setKybdr(sessionUser.getUsrId());
			yetaPdfG107mVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			yetaPdfG107mVo.setIsmt(sessionUser.getUsrId());
			yetaPdfG107mVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			String residValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			
			yetaPdfG107mVo.setResid(residValue);
			
			yetaPayr3200Service.yeta5200_PDF_G107M_2020_Insert(yetaPdfG107mVo);
			
			// 상품별 반복구간
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			//상품별 반복구간
			for(int k = 0; k < subXmlElChildMan.getLength();k++) {  

				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				strDatCd = subXmlElData.getAttribute("dat_cd"); 
				

				String strDecValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
				
				yetaPdfG107yVo.setFormCd(strFormCd);
				yetaPdfG107yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfG107yVo.setName(strName);
				yetaPdfG107yVo.setPdfDatAppYn("N");

				yetaPdfG107yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfG107yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfG107yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfG107yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				
				if (strDatCd.equals("G0012")) { // if strDatCd  = 'G01' then

					yetaPdfG107yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfG107yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfG107yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					// 일반
					if ((subXmlElData.getAttribute("use_place_cd") ).equals("1") )  {
						setPdfG107yVo(yetaPdfG107yVo, request);
					}
					// 전통시장
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("2") )  {
						setPdfG107yVo(yetaPdfG107yVo, request);
					}
					// 대중교통
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("3") )  {
						setPdfG107yVo(yetaPdfG107yVo, request);
					}
					// 도서공연비
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("4") )  {
						setPdfG107yVo(yetaPdfG107yVo, request);
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
		
		yetaPayr3200Service.yeta5200_PDF_YE162015_2020_Insert(yetaPdfYE162015Vo);
		//신용카드 종료

	}

	public static void setPdfG107yVo(InfcPkgPdfG107y_2020_VO yetaPdfG107yVo , HttpServletRequest request) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta5200XmlService) wac.getBean("Yeta5200XmlService" ); 
		}
		yetaPdfG107yVo.setUsePlaceCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("use_place_cd")));
		yetaPdfG107yVo.setCardAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));
		
		
		yetaPayr3200Service.yeta5200_PDF_G107Y_2020_Insert(yetaPdfG107yVo);

	}
	
	

	public static void func_2020_G107Y_YetaCalc(InfcPkgYe161010_2020_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta5200XmlService)BeanFinder.getBean("Yeta5200XmlService");
		int dataChk = 0;
		String datacheck = "";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
	
	//  신용카드 시작
        //신용카드  연간합계 G102M 월별 G01 신용카드 본인+가족
		
		 InfcPkgYe161040_2020_VO infcPkgYe161040Vo = new InfcPkgYe161040_2020_VO();
			
		infcPkgYe161040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161040Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161040Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		
		//YE161040 소득공제명세에 신용카드 
		dataChk =  yetaPayr3200Service.PdfYeta2020_G107Y_YE161040_Update(infcPkgYe161040Vo); 
		
		if (dataChk >= 0) {
			InfcPkgYe166020_2020_VO infcPkgYe166020Vo = new InfcPkgYe166020_2020_VO();
			
			infcPkgYe166020Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe166020Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe166020Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe166020Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
			infcPkgYe166020Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe166020Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe166020Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe166020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
			
			//신용카드
			yetaPayr3200Service.PdfYeta5200_G107Y_YE166020_Update(infcPkgYe166020Vo);  
			  
			//신용카드
			InfcPkgYe161070_2020_VO infcPkgYe161070Vo = new InfcPkgYe161070_2020_VO();
			
			
			infcPkgYe161070Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe161070Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe161070Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe161070Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
			infcPkgYe161070Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe161070Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe161070Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe161070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
			// 신용카드  
	         yetaPayr3200Service.fnYeta5200_G107Y_YE161070_2020_Update(infcPkgYe161070Vo); 
	     
		}
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr3200Service.yeta5200_PDF_YE162015_2020_Insert(ye161010VO);

		 
	}	
}
