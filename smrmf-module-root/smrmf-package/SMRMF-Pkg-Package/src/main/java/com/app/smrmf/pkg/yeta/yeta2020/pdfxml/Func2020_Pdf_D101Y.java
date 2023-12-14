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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfD101m_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfD101y_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgPdfYE162015_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161070_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe162010_2020_VO;
import com.app.smrmf.pkg.yeta.yeta2020.pdfxml.service.Yeta5200XmlService;

public class Func2020_Pdf_D101Y {

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

	public static void func_2020_D101Y_D101M(InfcPkgYe161010_2020_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request ) throws Exception{
		
		/**+++++++++++개인연금저축 시작++++++++++++++++++++++++++++++++++++++++++++++++++*/

		// 개인연금저축 시작
		//개인연금저축 D101Y 연간합계 D101M 월별 D01 개인연금저축 본인
		//근로자 본인 명의로 2000.12.31 이전에 가입하여 해당 과세기간에 불입한 금액
		//Y0040030	Y004 	0030	개인연금저축					21
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta5200XmlService) wac.getBean("Yeta5200XmlService" ); 

		}
		
		InfcPkgPdfD101y_2020_VO yetaPdfD101yVo = new InfcPkgPdfD101y_2020_VO();
		InfcPkgPdfD101m_2020_VO yetaPdfD101mVo = new InfcPkgPdfD101m_2020_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
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
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			//상품별 반복구간
			for(int k = 0; k < subXmlElChildMan.getLength();k++) {  

				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				strDatCd = subXmlElData.getAttribute("dat_cd"); 
				
				String strDecValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호

				yetaPdfD101yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
				yetaPdfD101yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
				yetaPdfD101yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
				yetaPdfD101yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
				yetaPdfD101yVo.setFormCd(strFormCd);				
				yetaPdfD101yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfD101yVo.setName(strName);
				
				yetaPdfD101yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfD101yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfD101yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfD101yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfD101yVo.setPdfDatAppYn("N");
				
				if (strDatCd.equals("G0009")) {
					
					yetaPdfD101yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfD101yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfD101yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					yetaPdfD101yVo.setPnsnSeilNum(subXmlElData.getAttribute("acc_no"));
					yetaPdfD101yVo.setStartDt(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)));
					yetaPdfD101yVo.setEndDt(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("end_dt", subXmlElData)));
					yetaPdfD101yVo.setComCd(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData)));
					yetaPdfD101yVo.setPnsnAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));
					
					yetaPayr3200Service.yeta5200_PDF_D101Y_2020_Delete(yetaPdfD101yVo);
					yetaPayr3200Service.yeta5200_PDF_D101Y_2020_Insert(yetaPdfD101yVo);
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

		//개인 연금 저축 종료
	}
	
	
	public static void func_2020_D101Y_YetaCalc(InfcPkgYe161010_2020_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta5200XmlService)BeanFinder.getBean("Yeta5200XmlService");
		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
		
		/**+++++++++++개인연금저축 시작++++++++++++++++++++++++++++++++++++++++++++++++++*/
        
	    // 개인연금저축 시작
        //개인연금저축 D101Y 연간합계 D101M 월별 D01 개인연금저축 본인
        //근로자 본인 명의로 2000.12.31 이전에 가입하여 해당 과세기간에 불입한 금액
        //Y0040030	Y004 	0030	개인연금저축					21
		
		InfcPkgYe162010_2020_VO infcPkgYe162010Vo = new InfcPkgYe162010_2020_VO();
		
		infcPkgYe162010Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe162010Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe162010Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe162010Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe162010Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe162010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe162010Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe162010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//개인연금저축 
		yetaPayr3200Service.PdfYeta5200_D101Y_YE162010_Delete(infcPkgYe162010Vo); 
		yetaPayr3200Service.PdfYeta5200_D101Y_YE162010_Insert(infcPkgYe162010Vo); 
		 
		//개인연금저축
		InfcPkgYe161070_2020_VO infcPkgYe161070Vo = new InfcPkgYe161070_2020_VO();
		
		
		infcPkgYe161070Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161070Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161070Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161070Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161070Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161070Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161070Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
		// 교육비 합계  
         yetaPayr3200Service.fnYeta5200_D101Y_YE161070_2020_Update(infcPkgYe161070Vo); 
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr3200Service.yeta3200_PDF_YE162015_2020_Insert(ye161010VO);

		 
	}	
}
