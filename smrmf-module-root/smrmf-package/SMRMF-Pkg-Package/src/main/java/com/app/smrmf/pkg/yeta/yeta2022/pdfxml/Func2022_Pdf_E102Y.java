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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfE102m_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfE102y_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgPdfYE162015_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161010_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe161080_2022_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2022.InfcPkgYe162010_2022_VO;
import com.app.smrmf.pkg.yeta.yeta2022.pdfxml.service.Yeta7200XmlService;

public class Func2022_Pdf_E102Y {

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
	private static String strFormCd = "";
	private static String strName = "";

	public static void func_2022_E102Y_E102M(InfcPkgYe161010_2022_VO ye161010VO, Element  subXmlElForm, String nResult , HttpServletRequest request ) throws Exception{
		
		/**+++++++++++2012년도 : 연금저축 E101Y 연간합계 E101M+++++++++++++++++++++++++++++++++++++++++++++++++*/

		// 2012년도 : 연금저축 E101Y 연간합계 E101M
		// 연금 저축 시작
		//월별 E01 연금저축 본인
		//근로자 본인 명의로 2001.1.1 이후에 가입하여 해당 과세기간에 불입한 금액
		//Y0040040  	B011	0040	연금저축					22

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta7200XmlService) wac.getBean("Yeta7200XmlService" ); 
		}
		
		InfcPkgPdfE102y_2022_VO yetaPdfE102yVo = new InfcPkgPdfE102y_2022_VO();
		InfcPkgPdfE102m_2022_VO yetaPdfE102mVo = new InfcPkgPdfE102m_2022_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

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
			// 상품별 반복구간
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");
			//상품별 반복구간
			for(int k = 0; k < subXmlElChildMan.getLength();k++) {  

				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				strDatCd = subXmlElData.getAttribute("dat_cd"); 

				String strDecValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호

				yetaPdfE102yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
				yetaPdfE102yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
				yetaPdfE102yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
				yetaPdfE102yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
				yetaPdfE102yVo.setFormCd(strFormCd);
				yetaPdfE102yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfE102yVo.setName(strName);
				yetaPdfE102yVo.setPdfDatAppYn("N");
				
				yetaPdfE102yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfE102yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfE102yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfE102yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				if (strDatCd.equals("G0010")) {
					
					yetaPdfE102yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfE102yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfE102yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					yetaPdfE102yVo.setPnsnSvSeilNum(subXmlElData.getAttribute("acc_no"));
					//2022연말정산_변경점
					//ISA 납입금액 포함된 당해년도 납입금액
					yetaPdfE102yVo.setAnnTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("ann_tot_amt", subXmlElData),"0")));
					//ISA 납입금액 중 인출금액 포함 당해년도 인출금액
					yetaPdfE102yVo.setTaxYearAmt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tax_year_amt", subXmlElData),"0")));
					//ISA 순납입금액 포함 당해년도 순납입금액
					yetaPdfE102yVo.setDdctBsAssAmt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("ddct_bs_ass_amt", subXmlElData),"0")));
					
					yetaPdfE102yVo.setComCd(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData)));
					
					//2022연말정산_추가
					//ISA계좌 만기전환 납입금액
					yetaPdfE102yVo.setIsaAnnTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("isa_ann_tot_amt", subXmlElData),"0")));
					//ISA계좌 만기전환 인출금액
					yetaPdfE102yVo.setIsaTaxYearAmt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("isa_tax_year_amt", subXmlElData),"0")));
					//ISA계좌 만기전환 순납입금액
					yetaPdfE102yVo.setIsaDdctBsAssAmt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("isa_ddct_bs_ass_amt", subXmlElData),"0")));
					//
					
					yetaPayr3200Service.yeta7200_PDF_E102Y_2022_Delete(yetaPdfE102yVo);
					yetaPayr3200Service.yeta7200_PDF_E102Y_2022_Insert(yetaPdfE102yVo);
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

		//연금저축 종료
	
	}
	

	public static void func_2022_E102Y_YetaCalc(InfcPkgYe161010_2022_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta7200XmlService)BeanFinder.getBean("Yeta7200XmlService");
		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
	
		/**+++++++++++2012년도 : 연금저축 E101Y 연간합계 E101M+++++++++++++++++++++++++++++++++++++++++++++++++*/
        
        // 2012년도 : 연금저축 E101Y 연간합계 E101M
        // 연금 저축 시작
        //월별 E01 연금저축 본인
        //근로자 본인 명의로 2001.1.1 이후에 가입하여 해당 과세기간에 불입한 금액
        //Y0040040  	B011	0040	연금저축					22
		
		InfcPkgYe162010_2022_VO infcPkgYe162010Vo = new InfcPkgYe162010_2022_VO();
		
		infcPkgYe162010Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe162010Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe162010Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe162010Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe162010Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe162010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe162010Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe162010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//연금저축 
		yetaPayr3200Service.PdfYeta7200_E102Y_YE162010_Delete(infcPkgYe162010Vo); 
		yetaPayr3200Service.PdfYeta7200_E102Y_YE162010_Insert(infcPkgYe162010Vo); 
		 
		//연금저축
		InfcPkgYe161080_2022_VO infcPkgYe161080Vo = new InfcPkgYe161080_2022_VO();
		
		
		infcPkgYe161080Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161080Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161080Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161080Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161080Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161080Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161080Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
		//연금저축 합계
         yetaPayr3200Service.fnYeta7200_E102Y_YE161080_2022_Update(infcPkgYe161080Vo); 
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr3200Service.yeta3200_PDF_YE162015_2022_Insert(ye161010VO);

		 
	}		
}
