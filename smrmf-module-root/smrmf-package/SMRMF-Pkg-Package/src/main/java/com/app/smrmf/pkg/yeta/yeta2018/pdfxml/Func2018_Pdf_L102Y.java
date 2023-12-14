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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfL102d_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfL102y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfYE162015_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161040_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161060_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161080_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165020_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe165030_2018_VO;
import com.app.smrmf.pkg.yeta.yeta2018.pdfxml.service.Yeta3200XmlService;

public class Func2018_Pdf_L102Y {

	@Resource(name = "Yeta3200XmlService")
	private static Yeta3200XmlService yetaPayr3200Service;

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

	public static void func_2018_L102Y_L102D(InfcPkgYe161010_2018_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request) throws Exception{

		/**+++++++++++    기부금시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		//  기부금시작
		// 기부금 L101Y 연간합계 L101D 일별 L01 기부금 본인+가족
		//  arrSPCI_PAY   : array[1..10] of array[1..10] of string;
		//edSpciFbam, edSpciPltc,edSpciExam,edSpciUnon, edSpciNamt, edSpciYamt, edSPCI_HFAM
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta3200XmlService) wac.getBean("Yeta3200XmlService" ); 
		}
		
		InfcPkgPdfL102y_2018_VO yetaPdfL102yVo = new InfcPkgPdfL102y_2018_VO();
		InfcPkgPdfL102d_2018_VO yetaPdfL102dVo = new InfcPkgPdfL102d_2018_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

		yetaPdfL102yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfL102yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfL102yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfL102yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr3200Service.yeta3200_PDF_L102Y_2018_Delete(yetaPdfL102yVo);
		
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

				yetaPdfL102yVo.setFormCd(strFormCd);
				yetaPdfL102yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfL102yVo.setName(strName);
				yetaPdfL102yVo.setPdfDatAppYn("N");

				yetaPdfL102yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfL102yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfL102yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfL102yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0020")) {
					yetaPdfL102yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfL102yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfL102yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					yetaPdfL102yVo.setDonationCd(subXmlElData.getAttribute("donation_cd"));
					
					yetaPdfL102yVo.setConbAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));
					yetaPdfL102yVo.setSbdyAplnSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sbdy_apln_sum", subXmlElData),"0")));
					yetaPdfL102yVo.setConbSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("conb_sum", subXmlElData),"0")));
					
					yetaPayr3200Service.yeta3200_PDF_L102Y_2018_Insert(yetaPdfL102yVo);
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
	}
	

	public static void func_2018_L102Y_YetaCalc(InfcPkgYe161010_2018_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta3200XmlService)BeanFinder.getBean("Yeta3200XmlService");
		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
		/**+++++++++++    기부금시작++++++++++++++++++++++++++++++++++++++++++++++++*/
    	//  기부금시작
         // 기부금 L101Y 연간합계 L101D 일별 L01 기부금 본인+가족
         //  arrSPCI_PAY   : array[1..10] of array[1..10] of string;
         //edSpciFbam, edSpciPltc,edSpciExam,edSpciUnon, edSpciNamt, edSpciYamt, edSPCI_HFAM
		
		InfcPkgYe165010_2018_VO infcPkgYe165010Vo = new InfcPkgYe165010_2018_VO();
		
		infcPkgYe165010Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe165010Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe165010Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe165010Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe165010Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe165010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe165010Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe165010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//기부금
		yetaPayr3200Service.PdfYeta3200_L102Y_YE165010_Delete(infcPkgYe165010Vo); 
		yetaPayr3200Service.PdfYeta3200_L102Y_YE165010_Insert(infcPkgYe165010Vo); 
		 
		
		
		InfcPkgYe165020_2018_VO infcPkgYe165020Vo = new InfcPkgYe165020_2018_VO();
		
		infcPkgYe165020Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe165020Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe165020Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe165020Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe165020Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe165020Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe165020Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe165020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//기부금
		yetaPayr3200Service.PdfYeta3200_L102Y_YE165020_Delete(infcPkgYe165020Vo); 
		yetaPayr3200Service.PdfYeta3200_L102Y_YE165020_Insert(infcPkgYe165020Vo);
		
		
        InfcPkgYe165030_2018_VO infcPkgYe165030Vo = new InfcPkgYe165030_2018_VO();
		
        infcPkgYe165030Vo.setDpobCd(sessionUser.getDpobCd());
        infcPkgYe165030Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
        infcPkgYe165030Vo.setSystemkey(ye161010VO.getSystemkey());
        infcPkgYe165030Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
        infcPkgYe165030Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe165030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe165030Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe165030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//기부금
		yetaPayr3200Service.PdfYeta3200_L102Y_YE165030_Delete(infcPkgYe165030Vo); 
		yetaPayr3200Service.PdfYeta3200_L102Y_YE165030_Insert(infcPkgYe165030Vo);
		
		
		
		//기부금
		InfcPkgYe161040_2018_VO infcPkgYe161040Vo = new InfcPkgYe161040_2018_VO();
		
		
		infcPkgYe161040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161040Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161040Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());		
	
		
		yetaPayr3200Service.fnYeta3200_L102Y_YE161040_2018_Update(infcPkgYe161040Vo); 
		
		//기부금
		InfcPkgYe161080_2018_VO infcPkgYe161080Vo = new InfcPkgYe161080_2018_VO();
		
		
		infcPkgYe161080Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161080Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161080Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161080Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161080Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161080Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161080Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
		// 기부금 합계  
         yetaPayr3200Service.fnYeta3200_L102Y_YE161080_2018_Update(infcPkgYe161080Vo); 
     
         
         
       //이월기부금처리 
 		InfcPkgYe161060_2018_VO infcPkgYe161060Vo = new InfcPkgYe161060_2018_VO();
 		
 		
 		infcPkgYe161060Vo.setDpobCd(sessionUser.getDpobCd());
 		infcPkgYe161060Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
 		infcPkgYe161060Vo.setSystemkey(ye161010VO.getSystemkey());
 		infcPkgYe161060Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
 		infcPkgYe161060Vo.setKybdr(sessionUser.getUsrId());
 		infcPkgYe161060Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
 		infcPkgYe161060Vo.setIsmt(sessionUser.getUsrId());
 		infcPkgYe161060Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
 		// 기부금 합계  
          yetaPayr3200Service.fnYeta3200_L102Y_YE161060_2018_Update(infcPkgYe161060Vo); 
      
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr3200Service.yeta3200_PDF_YE162015_2018_Insert(ye161010VO);

		 
	}	
}
