package com.app.smrmf.pkg.yeta.yeta2018.pdfxml;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG307m_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG307y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG307m_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfG307y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfYE162015_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161040_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161070_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe166020_2018_VO;
import com.app.smrmf.pkg.yeta.yeta2016.pdfxml.service.YetaPayr1200Service;
import com.app.smrmf.pkg.yeta.yeta2018.pdfxml.service.Yeta3200XmlService;

public class Func2018_Pdf_G307Y {

	@Resource(name = "Yeta3200XmlService")
	private static Yeta3200XmlService yetaPayr3200Service;

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

	public static void func_2018_G307Y_G307M(InfcPkgYe161010_2018_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request ) throws Exception{

		/**+++++++++++  직불카드 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		//    직불카드 시작
		//직불카드등  연간합계 G302M 월별 G03 직불카드 등 본인+가족
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta3200XmlService) wac.getBean("Yeta3200XmlService" ); 
		}

		InfcPkgPdfG307y_2018_VO yetaPdfG307yVo = new InfcPkgPdfG307y_2018_VO();
		InfcPkgPdfG307m_2018_VO yetaPdfG307mVo = new InfcPkgPdfG307m_2018_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

		yetaPdfG307yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG307yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG307yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG307yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr3200Service.yeta3200_PDF_G307Y_2018_Delete(yetaPdfG307yVo);
		
		yetaPdfG307mVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG307mVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG307mVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG307mVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr3200Service.yeta3200_PDF_G307M_2018_Delete(yetaPdfG307mVo);
		
		strDatCd = "";
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		
		InfcPkgPdfYE162015_2018_VO yetaPdfYE162015Vo = new InfcPkgPdfYE162015_2018_VO();
		
		yetaPdfYE162015Vo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfYE162015Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfYE162015Vo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfYE162015Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfYE162015Vo.setFileAppPaprDivCd(strFormCd);
		
		yetaPayr3200Service.yeta3200_PDF_YE162015_2018_Delete(yetaPdfYE162015Vo);
		
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
				
				yetaPdfG307yVo.setFormCd(strFormCd);
				yetaPdfG307yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfG307yVo.setName(strName);
				yetaPdfG307yVo.setPdfDatAppYn("N");

				yetaPdfG307yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfG307yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfG307yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfG307yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0014")) { //  if strDatCd  = 'G03' then

					yetaPdfG307yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfG307yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfG307yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					
					if ((subXmlElData.getAttribute("use_place_cd")).equals("1") )  {
						setPdfG307yVo(yetaPdfG307yVo, request, subXmlElData);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("2") )  {
						setPdfG307yVo(yetaPdfG307yVo, request, subXmlElData);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("3") )  {
						setPdfG307yVo(yetaPdfG307yVo, request, subXmlElData);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("4") )  {
						setPdfG307yVo(yetaPdfG307yVo, request, subXmlElData);
					}
				}

				if (strFormCd.equals("G306M")) {

					subXmlElChildAmt = subXmlElData.getElementsByTagName("amt");

					for(int i = 0; i < subXmlElChildAmt.getLength(); i++) {  
						subXmlItemAmt =  subXmlElChildAmt.item(i);
						subXmlElAmt = (Element) subXmlItemAmt;
						strMn = subXmlElAmt.getAttribute("mm");

						yetaPdfG307mVo.setKybdr(sessionUser.getUsrId());
						yetaPdfG307mVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
						yetaPdfG307mVo.setIsmt(sessionUser.getUsrId());
						yetaPdfG307mVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

						if (strMn.equals("01")) {
							setPdfG307mVo(yetaPdfG307mVo, request, subXmlElData);
						}
						else if (strMn.equals("02")) {
							setPdfG307mVo(yetaPdfG307mVo, request, subXmlElData);
						}
						else if (strMn.equals("03")) {
							setPdfG307mVo(yetaPdfG307mVo, request, subXmlElData);
						}
						else if (strMn.equals("04")) {
							setPdfG307mVo(yetaPdfG307mVo, request, subXmlElData);
						}
						else if (strMn.equals("05")) {
							setPdfG307mVo(yetaPdfG307mVo, request, subXmlElData);
						}
						else if (strMn.equals("06")) {
							setPdfG307mVo(yetaPdfG307mVo, request, subXmlElData);
						}
						else if (strMn.equals("07")) {
							setPdfG307mVo(yetaPdfG307mVo, request, subXmlElData);
						}
						else if (strMn.equals("08")) {
							setPdfG307mVo(yetaPdfG307mVo, request, subXmlElData);
						}
						else if (strMn.equals("09")) {
							setPdfG307mVo(yetaPdfG307mVo, request, subXmlElData);
						}
						else if (strMn.equals("10")) {
							setPdfG307mVo(yetaPdfG307mVo, request, subXmlElData);
						}
						else if (strMn.equals("11")) {
							setPdfG307mVo(yetaPdfG307mVo, request, subXmlElData);
						}
						else if (strMn.equals("12")) {
							setPdfG307mVo(yetaPdfG307mVo, request, subXmlElData);
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
		
		yetaPayr3200Service.yeta3200_PDF_YE162015_2018_Insert(yetaPdfYE162015Vo);
		//현금 영수증 종료
	}

	public static void setPdfG307yVo(InfcPkgPdfG307y_2018_VO yetaPdfG307yVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta3200XmlService) wac.getBean("Yeta3200XmlService" ); 
		}
		yetaPdfG307yVo.setUsePlaceCd(subXmlElData.getAttribute("use_place_cd"));
		yetaPdfG307yVo.setDirCardAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));

		yetaPayr3200Service.yeta3200_PDF_G307Y_2018_Insert(yetaPdfG307yVo);

	}
	
	public static void setPdfG307mVo(InfcPkgPdfG307m_2018_VO yetaPdfG307mVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta3200XmlService) wac.getBean("Yeta3200XmlService" ); 
		}

		yetaPdfG307mVo.setDirCardAmtMn(strMn);
		yetaPdfG307mVo.setDirCardMmAmt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("amt", subXmlElData),"0")));
		
		yetaPayr3200Service.yeta3200_PDF_G307M_2018_Insert(yetaPdfG307mVo);

	}
	

	public static void func_2018_G307Y_YetaCalc(InfcPkgYe161010_2018_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta3200XmlService)BeanFinder.getBean("Yeta3200XmlService");
		int dataChk = 0;
		String datacheck = "";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
		/**+++++++++++  직불카드 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		//    직불카드 시작
        //직불카드등  연간합계 G302M 월별 G03 직불카드 등 본인+가족
		
		InfcPkgYe161040_2018_VO infcPkgYe161040Vo = new InfcPkgYe161040_2018_VO();
			
		infcPkgYe161040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161040Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161040Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//YE161040 소득공제명세에 신용카드 
		dataChk = yetaPayr3200Service.PdfYeta2018_G307Y_YE161040_Update(infcPkgYe161040Vo); 
		
		if (dataChk >= 0) { 

			InfcPkgYe166020_2018_VO infcPkgYe166020Vo = new InfcPkgYe166020_2018_VO();
			
			infcPkgYe166020Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe166020Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe166020Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe166020Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
			infcPkgYe166020Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe166020Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe166020Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe166020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
			
			//신용카드
			//yetaPayr3200Service.Pdfyeta3200_G106Y_YE166020_Update(infcPkgYe166020Vo);  
			 

				 
			//신용카드
			InfcPkgYe161070_2018_VO infcPkgYe161070Vo = new InfcPkgYe161070_2018_VO();
			
			
			infcPkgYe161070Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe161070Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe161070Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe161070Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
			infcPkgYe161070Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe161070Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe161070Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe161070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
			// 신용카드  
	         yetaPayr3200Service.fnYeta3200_G307Y_YE161070_2018_Update(infcPkgYe161070Vo); 
	         
		}
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr3200Service.yeta3200_PDF_YE162015_2018_Insert(ye161010VO);

		 
	}	

}
