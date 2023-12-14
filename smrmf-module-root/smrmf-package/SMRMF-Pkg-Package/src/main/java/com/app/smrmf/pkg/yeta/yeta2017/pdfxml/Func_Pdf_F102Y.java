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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfF102mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfF102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfYE162015VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161080VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162020VO;
import com.app.smrmf.pkg.yeta.yeta2017.pdfxml.service.Yeta2200XmlService;

public class Func_Pdf_F102Y {

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

	public static void func_2017_F102Y_F102M(InfcPkgYe161010VO ye161010VO, Element  subXmlElForm, String nResult , HttpServletRequest request ) throws Exception{
		
		/**+++++++++++2012년도 : 연금저축 E101Y 연간합계 E101M+++++++++++++++++++++++++++++++++++++++++++++++++*/

		// 2012년도 : 연금저축 E101Y 연간합계 E101M
		// 연금 저축 시작
		//월별 E01 연금저축 본인
		//근로자 본인 명의로 2001.1.1 이후에 가입하여 해당 과세기간에 불입한 금액
		//Y0040040  	B011	0040	연금저축					22

		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 
		}
		
		InfcPkgPdfF102yVO yetaPdfF102yVo = new InfcPkgPdfF102yVO();
		InfcPkgPdfF102mVO yetaPdfF102mVo = new InfcPkgPdfF102mVO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
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

				yetaPdfF102yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
				yetaPdfF102yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
				yetaPdfF102yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
				yetaPdfF102yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
				yetaPdfF102yVo.setFormCd(strFormCd);
				yetaPdfF102yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfF102yVo.setName(strName);
				yetaPdfF102yVo.setPdfDatAppYn("N");
				
				yetaPdfF102yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfF102yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfF102yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfF102yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0011")) {
					
					yetaPdfF102yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfF102yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfF102yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					yetaPdfF102yVo.setAccNo(subXmlElData.getAttribute("acc_no"));
					
					yetaPdfF102yVo.setComCd(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData)));
					yetaPdfF102yVo.setPensionCd(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("pension_cd", subXmlElData)));
					yetaPdfF102yVo.setAnnTotAmt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("ann_tot_amt", subXmlElData),"0")));
					yetaPdfF102yVo.setTaxYearAmt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("tax_year_amt", subXmlElData),"0")));
					yetaPdfF102yVo.setDdctBsAssAmt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("ddct_bs_ass_amt", subXmlElData),"0")));
//					yetaPdfF102yVo.setRetirPnsnAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));
					
					yetaPayr2200Service.yeta2200_PDF_F102Y_2017_Delete(yetaPdfF102yVo);
					yetaPayr2200Service.yeta2200_PDF_F102Y_2017_Insert(yetaPdfF102yVo);
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
		//퇴직연금 종료 
	
	}
	
	
	public static void func_2017_F102Y_YetaCalc(InfcPkgYe161010VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr2200Service = (Yeta2200XmlService)BeanFinder.getBean("Yeta2200XmlService");
		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
	
		/**+++++++++++퇴직연금 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
		 // 퇴직연금 시작
        // 2012년도  : 퇴직연금 F101Y 연간합계 F101M
        //  월별 F01 퇴직연금 본인
        // Y0040010	B011	0010	근로자퇴직연금보장법.	11
        // Y0040020	B011	0020	과학기술인공제회	12
        // B0110025	B011	0025	확정기여형퇴직연금.	13  ---삭제 ,''B0110025''
		
		InfcPkgYe162020VO infcPkgYe162020Vo = new InfcPkgYe162020VO();
		
		infcPkgYe162020Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe162020Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe162020Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe162020Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe162020Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe162020Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe162020Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe162020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//퇴직연금
		yetaPayr2200Service.PdfYeta2200_F102Y_YE162020_Delete(infcPkgYe162020Vo); 
		yetaPayr2200Service.PdfYeta2200_F102Y_YE162020_Insert(infcPkgYe162020Vo); 
		 
		//퇴직연금
		InfcPkgYe161080VO infcPkgYe161080Vo = new InfcPkgYe161080VO();
		
		
		infcPkgYe161080Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161080Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161080Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161080Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161080Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161080Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161080Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
		// 퇴직연금 합계  
         yetaPayr2200Service.fnYeta2200_F102Y_YE161080_2017_Update(infcPkgYe161080Vo); 
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr2200Service.yeta2200_PDF_YE162015_2017_Insert(ye161010VO);

		 
	}	
}
