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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC202mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfC202yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfYE162015VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161080VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161090VO;
import com.app.smrmf.pkg.yeta.yeta2017.pdfxml.service.Yeta2200XmlService;

public class Func_Pdf_C202Y {

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
	private static String strFormCd = "";
	private static String strName = "";

	public static void func_2017_C202Y_C202M(InfcPkgYe161010VO ye161010VO, Element  subXmlElForm, String nResult , HttpServletRequest request ) throws Exception{
		/**+++++++++++/직업훈련비(본인교육비에 해당)  C02 직업훈련비 본인+++++++++++++++++++++++++++++++++++++++++++++++++++*/
		//직업훈련비(본인교육비에 해당)  C02 직업훈련비 본인
		
		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 
		}
		
		InfcPkgPdfC202yVO yetaPdfC202yVo = new InfcPkgPdfC202yVO();
		InfcPkgPdfC202mVO yetaPdfC202mVo = new InfcPkgPdfC202mVO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		yetaPdfC202yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfC202yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfC202yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfC202yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr2200Service.yeta2200_PDF_C202Y_2017_Delete(yetaPdfC202yVo);
		
		//인원별 반복구간
		
		strDatCd =  "";
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");

		InfcPkgPdfYE162015VO yetaPdfYE162015Vo = new InfcPkgPdfYE162015VO();
		
		yetaPdfYE162015Vo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfYE162015Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfYE162015Vo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfYE162015Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfYE162015Vo.setFileAppPaprDivCd(strFormCd);
		
		yetaPayr2200Service.yeta2200_PDF_YE162015_2017_Delete(yetaPdfYE162015Vo);
		//인원별 반복구간
		for (int j = 0; j < subXmlElChildForm.getLength();j++) { 

			subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			subXmlElMan  = (Element) subXmlItemMan;

			strResid = subXmlElMan.getAttribute("resid");   //주민번호 
			strName = subXmlElMan.getAttribute("name");	//이름
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			//과정별반복구간

			for(int k = 0; k < subXmlElChildMan.getLength();k++) {   

				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				strDatCd = subXmlElData.getAttribute("dat_cd"); 

				String strDecValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호

				yetaPdfC202yVo.setFormCd(strFormCd);
				yetaPdfC202yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfC202yVo.setName(strName);
				yetaPdfC202yVo.setPdfDatAppYn("N");
				
				yetaPdfC202yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfC202yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfC202yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfC202yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				if (strDatCd.equals("G0005")) {
					
					yetaPdfC202yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfC202yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfC202yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					yetaPdfC202yVo.setCourseCd(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("course_cd", subXmlElData)));
					yetaPdfC202yVo.setSubjectNm(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("subject_nm", subXmlElData)));
					yetaPdfC202yVo.setJobEdiSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));
					
					yetaPayr2200Service.yeta2200_PDF_C202Y_2017_Insert(yetaPdfC202yVo);

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
	
	
	public static void func_2017_C202Y_YetaCalc(InfcPkgYe161010VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr2200Service = (Yeta2200XmlService)BeanFinder.getBean("Yeta2200XmlService");
		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
		
		
		/**+++++++++++/직업훈련비(본인교육비에 해당)  C02 직업훈련비 본인+++++++++++++++++++++++++++++++++++++++++++++++++++*/
        //직업훈련비(본인교육비에 해당)  C02 직업훈련비 본인
		
		InfcPkgYe161090VO infcPkgYe161090Vo = new InfcPkgYe161090VO();
		
		infcPkgYe161090Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161090Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161090Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161090Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161090Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161090Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161090Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161090Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//교육비 
		yetaPayr2200Service.PdfYeta2200_C202Y_YE161090_Delete(infcPkgYe161090Vo); 
		yetaPayr2200Service.PdfYeta2200_C202Y_YE161090_Insert(infcPkgYe161090Vo); 
		
	
        InfcPkgYe161040VO infcPkgYe161040Vo = new InfcPkgYe161040VO();
		
		infcPkgYe161040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161040Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161040Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//YE161040 소득공제명세에 교육비개별 
		yetaPayr2200Service.PdfYeta2017_C101Y_YE161040_Update(infcPkgYe161040Vo); 
		 
		
		//교육비 금액 
		InfcPkgYe161080VO infcPkgYe161080Vo = new InfcPkgYe161080VO();
		
		
		infcPkgYe161080Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161080Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161080Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161080Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161080Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161080Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161080Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
		// 교육비 합계  
         yetaPayr2200Service.fnYeta2200_C101Y_YE161080_2017_Update(infcPkgYe161080Vo); 
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr2200Service.yeta2200_PDF_YE162015_2017_Insert(ye161010VO);

		 
	}	
}
