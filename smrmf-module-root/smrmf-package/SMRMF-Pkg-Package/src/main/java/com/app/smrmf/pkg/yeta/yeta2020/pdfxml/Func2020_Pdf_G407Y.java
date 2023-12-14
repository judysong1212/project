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
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3000VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3100VO;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta3220VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG407m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG407y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG407m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfG407y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfYE162015_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161040_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161070_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe166020_2020_VO;
import com.app.smrmf.pkg.yeta.yeta2016.pdfxml.service.YetaPayr1200Service;
import com.app.smrmf.pkg.yeta.yeta2020.pdfxml.service.Yeta5200XmlService;

public class Func2020_Pdf_G407Y {

	@Resource(name = "Yeta5200XmlService")
	private static Yeta5200XmlService yetaPayr3200Service;

	private static NodeList subXmlElChildForm = null;
	private static Node subXmlItemMan = null;
	private static NodeList subXmlElChildMan = null;
	private static Element subXmlElMan = null;
	private static Node subXmlItemData = null;
	private static Element subXmlElData = null;

	private static NodeList subXmlElChildAmt = null;
	private static Element subXmlElAmt = null;
	private static Node subXmlItemAmt = null;

	private static String strResid = "";
	private static String strDatCd = "";
	private static String strMn= "";
	private static String strFormCd = "";
	private static String strName = "";
	//추가20201209
	private static BigDecimal strAmt= null;

	public static void func_2020_G407Y_G407M(InfcPkgYe161010_2020_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request ) throws Exception{

		/**+++++++++++  직불카드 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		//    직불카드 시작
		//직불카드등  연간합계 G302M 월별 G03 직불카드 등 본인+가족
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta5200XmlService) wac.getBean("Yeta5200XmlService" ); 
		}

		InfcPkgPdfG407y_2020_VO yetaPdfG407yVo = new InfcPkgPdfG407y_2020_VO();
		InfcPkgPdfG407m_2020_VO yetaPdfG407mVo = new InfcPkgPdfG407m_2020_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

		yetaPdfG407yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG407yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG407yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG407yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr3200Service.yeta5200_PDF_G407Y_2020_Delete(yetaPdfG407yVo);
		
		yetaPdfG407mVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG407mVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG407mVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG407mVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr3200Service.yeta5200_PDF_G407M_2020_Delete(yetaPdfG407mVo);
		
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
						setPdfG407yVo(yetaPdfG407yVo, request, subXmlElData);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("2") )  {
						setPdfG407yVo(yetaPdfG407yVo, request, subXmlElData);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("3") )  {
						setPdfG407yVo(yetaPdfG407yVo, request, subXmlElData);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("4") )  {
						setPdfG407yVo(yetaPdfG407yVo, request, subXmlElData);
					}
				}

				if (strFormCd.equals("G408M")) {

					subXmlElChildAmt = subXmlElData.getElementsByTagName("amt");

					for(int i = 0; i < subXmlElChildAmt.getLength(); i++) {  
						subXmlItemAmt =  subXmlElChildAmt.item(i);
						subXmlElAmt = (Element) subXmlItemAmt;
						strMn = subXmlElAmt.getAttribute("mm");
						//추가20201209
						strAmt = new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElAmt.getFirstChild().getNodeValue(),"0"));
						
						/*추가20201208*/
						yetaPdfG407mVo.setResid(strDecValue);
						yetaPdfG407mVo.setUsePlaceCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("use_place_cd")));
						yetaPdfG407mVo.setBusnid(subXmlElData.getAttribute("busnid"));
						
						yetaPdfG407mVo.setKybdr(sessionUser.getUsrId());
						yetaPdfG407mVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						yetaPdfG407mVo.setIsmt(sessionUser.getUsrId());
						yetaPdfG407mVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

						if (strMn.equals("01")) {
							setPdfG407mVo(yetaPdfG407mVo, request, subXmlElData);
						}
						else if (strMn.equals("02")) {
							setPdfG407mVo(yetaPdfG407mVo, request, subXmlElData);
						}
						else if (strMn.equals("03")) {
							setPdfG407mVo(yetaPdfG407mVo, request, subXmlElData);
						}
						else if (strMn.equals("04")) {
							setPdfG407mVo(yetaPdfG407mVo, request, subXmlElData);
						}
						else if (strMn.equals("05")) {
							setPdfG407mVo(yetaPdfG407mVo, request, subXmlElData);
						}
						else if (strMn.equals("06")) {
							setPdfG407mVo(yetaPdfG407mVo, request, subXmlElData);
						}
						else if (strMn.equals("07")) {
							setPdfG407mVo(yetaPdfG407mVo, request, subXmlElData);
						}
						else if (strMn.equals("08")) {
							setPdfG407mVo(yetaPdfG407mVo, request, subXmlElData);
						}
						else if (strMn.equals("09")) {
							setPdfG407mVo(yetaPdfG407mVo, request, subXmlElData);
						}
						else if (strMn.equals("10")) {
							setPdfG407mVo(yetaPdfG407mVo, request, subXmlElData);
						}
						else if (strMn.equals("11")) {
							setPdfG407mVo(yetaPdfG407mVo, request, subXmlElData);
						}
						else if (strMn.equals("12")) {
							setPdfG407mVo(yetaPdfG407mVo, request, subXmlElData);
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
		
		yetaPayr3200Service.yeta5200_PDF_YE162015_2020_Insert(yetaPdfYE162015Vo);
		//현금 영수증 종료
	}

	public static void setPdfG407yVo(InfcPkgPdfG407y_2020_VO yetaPdfG407yVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta5200XmlService) wac.getBean("Yeta5200XmlService" ); 
		}
		yetaPdfG407yVo.setUsePlaceCd(subXmlElData.getAttribute("use_place_cd"));
		yetaPdfG407yVo.setZeroAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));

		yetaPayr3200Service.yeta5200_PDF_G407Y_2020_Insert(yetaPdfG407yVo);

	}
	
	public static void setPdfG407mVo(InfcPkgPdfG407m_2020_VO yetaPdfG407mVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta5200XmlService) wac.getBean("Yeta5200XmlService" ); 
		}

		yetaPdfG407mVo.setZeroAmtMn(strMn);
		//변경20201209
		yetaPdfG407mVo.setZeroMmAmt(strAmt);
		
		yetaPayr3200Service.yeta5200_PDF_G407M_2020_Insert(yetaPdfG407mVo);

	}
	

	public static void func_2020_G407Y_YetaCalc(InfcPkgYe161010_2020_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta5200XmlService)BeanFinder.getBean("Yeta5200XmlService");
		int dataChk = 0;
		String datacheck = "";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
		/**+++++++++++  직불카드 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		//    직불카드 시작
        //직불카드등  연간합계 G302M 월별 G03 직불카드 등 본인+가족
		
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
		dataChk = yetaPayr3200Service.PdfYeta2020_G407Y_YE161040_Update(infcPkgYe161040Vo); 
		
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
	         yetaPayr3200Service.fnYeta5200_G407Y_YE161070_2020_Update(infcPkgYe161070Vo); 
	         
		}
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
	}	

}
