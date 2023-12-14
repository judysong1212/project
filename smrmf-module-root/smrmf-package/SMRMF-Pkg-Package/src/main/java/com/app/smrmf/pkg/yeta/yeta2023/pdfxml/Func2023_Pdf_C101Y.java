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

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.egov.comutils.payr.PkgFuncUtils;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfC101m_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfC101y_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgPdfYE162015_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161010_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161040_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161080_2023_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2023.InfcPkgYe161090_2023_VO;
import com.app.smrmf.pkg.yeta.yeta2023.pdfxml.service.Yeta8200XmlService;

public class Func2023_Pdf_C101Y {

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
	private static String strEduTp = "";
	private static String strName = "";
	private static String strFormCd  = "";

	public static void func_2023_C101Y_C101M(InfcPkgYe161010_2023_VO ye161010VO, Element  subXmlElForm, String nResult , HttpServletRequest request) throws Exception{
		/**+++++++++++/교육비  기본 타입 있음...초중고 구분등+++++++++++++++++++++++++++++++++++++++++++++++++++*/
		//교육비  기본 타입 있음...초중고 구분등
		//  {G0004 교육비-유초중고 본인+가족(시도교육청)
		//   G0006 교육비-대학 본인+가족
		//   G0007 교육비-기타 본인+가족}
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta8200XmlService) wac.getBean("Yeta8200XmlService" ); 
		}

		InfcPkgPdfC101y_2023_VO yetaPdfC101yVo = new InfcPkgPdfC101y_2023_VO();
		InfcPkgPdfC101m_2023_VO yetaPdfC101mVo = new InfcPkgPdfC101m_2023_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		yetaPdfC101yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfC101yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfC101yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfC101yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr3200Service.yeta8200_PDF_C101Y_2023_Delete(yetaPdfC101yVo);

		strDatCd = "";
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		
		InfcPkgPdfYE162015_2023_VO yetaPdfYE162015Vo = new InfcPkgPdfYE162015_2023_VO();
		
		yetaPdfYE162015Vo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfYE162015Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfYE162015Vo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfYE162015Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfYE162015Vo.setFileAppPaprDivCd(strFormCd);
		
		yetaPayr3200Service.yeta8200_PDF_YE162015_2023_Delete(yetaPdfYE162015Vo);
		
		for (int j = 0; j < subXmlElChildForm.getLength();j++) { 

			strResid = "";

			subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			subXmlElMan  = (Element) subXmlItemMan;

			strResid = subXmlElMan.getAttribute("resid");   //주민번호 
			strName = subXmlElMan.getAttribute("name");	//이름
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			//상품별 반복구간
			for(int k = 0; k < subXmlElChildMan.getLength();k++) {  

				strEduTp = "";
				strDatCd = "";

				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				strDatCd = subXmlElData.getAttribute("dat_cd"); 
				strEduTp =  subXmlElData.getAttribute("edu_tp");  //교육비종류 


				String strDecValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호

				yetaPdfC101yVo.setFormCd(strFormCd);
				yetaPdfC101yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfC101yVo.setName(strName);

				yetaPdfC101yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfC101yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfC101yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfC101yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0004")) { 
					
					yetaPdfC101yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfC101yVo.setPdfDatAppYn("N");

 					setPdfC101yVo(yetaPdfC101yVo,request);
				}
				else if ( strDatCd.equals("G0006")) {
					// C03 교육비-대학 본인+가족
					yetaPdfC101yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfC101yVo.setPdfDatAppYn("N");
					
 					setPdfC101yVo(yetaPdfC101yVo,request);
				}
				else if ( strDatCd.equals("G0007")) {
					// C04 교육비-기타 본인+가족
					yetaPdfC101yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfC101yVo.setPdfDatAppYn("N");
					
 					setPdfC101yVo(yetaPdfC101yVo,request);
				}
				else if ( strDatCd.equals("G0008")) {
					// C04 교육비-기타 본인+가족
					yetaPdfC101yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfC101yVo.setPdfDatAppYn("N");
					
 					setPdfC101yVo(yetaPdfC101yVo,request);
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
	
	public static void setPdfC101yVo(InfcPkgPdfC101y_2023_VO yetaPdfC101yVo , HttpServletRequest request) throws Exception{
		
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta8200XmlService) wac.getBean("Yeta8200XmlService" ); 
		}
		
		yetaPdfC101yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
		yetaPdfC101yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
		yetaPdfC101yVo.setEduTp(subXmlElData.getAttribute("edu_tp"));
		yetaPdfC101yVo.setEduCl(subXmlElData.getAttribute("edu_cl"));
		yetaPdfC101yVo.setEdiSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));
		
		yetaPayr3200Service.yeta8200_PDF_C101Y_2023_Insert(yetaPdfC101yVo);
		
	}
	
	
	
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 교육비(유초중고,대학,기타) 2017귀속분  
	 * 2. 처리내용 : 교육비(유초중고,대학,기타) 2017귀속분 
	 * </pre>
	 * @Method Name : func_2023_C102Y_YetaCalc
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
	public static void func_2023_C101Y_YetaCalc(InfcPkgYe161010_2023_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta8200XmlService)BeanFinder.getBean("Yeta8200XmlService");
		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
		
		
		/**+++++++++++/교육비  기본 타입 있음...초중고 구분등+++++++++++++++++++++++++++++++++++++++++++++++++++*/
        //교육비  기본 타입 있음...초중고 구분등
      //  {G0004 교육비-유초중고 본인+가족(시도교육청)
      //   G0006 교육비-대학 본인+가족
      //   G0007 교육비-기타 본인+가족 개별제출
		// G0008 교육비 - 유초중고(개별제출)}
		
		InfcPkgYe161090_2023_VO infcPkgYe161090Vo = new InfcPkgYe161090_2023_VO();
		
		infcPkgYe161090Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161090Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161090Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161090Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		
		//교육비 
		yetaPayr3200Service.PdfYeta8200_C101Y_YE161090_Delete(infcPkgYe161090Vo); 
		yetaPayr3200Service.PdfYeta8200_C101Y_YE161090_Insert(infcPkgYe161090Vo); 
		
	
        InfcPkgYe161040_2023_VO infcPkgYe161040Vo = new InfcPkgYe161040_2023_VO();
		
		infcPkgYe161040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		
		//YE161040 소득공제명세에 교육비개별 
		yetaPayr3200Service.PdfYeta2023_C101Y_YE161040_Update(infcPkgYe161040Vo); 
		 
		
		//교육비 금액 
		InfcPkgYe161080_2023_VO infcPkgYe161080Vo = new InfcPkgYe161080_2023_VO();
		
		
		infcPkgYe161080Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161080Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161080Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161080Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161080Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161080Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161080Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
		// 교육비 합계  
         yetaPayr3200Service.fnYeta8200_C101Y_YE161080_2023_Update(infcPkgYe161080Vo); 
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr3200Service.yeta3200_PDF_YE162015_2023_Insert(ye161010VO);

		 
	}	
}
