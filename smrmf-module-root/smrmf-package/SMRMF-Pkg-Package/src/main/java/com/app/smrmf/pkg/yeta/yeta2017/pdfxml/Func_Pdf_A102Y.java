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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfA102yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfYE162015VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161080VO;
import com.app.smrmf.pkg.yeta.yeta2017.pdfxml.service.Yeta2200XmlService;

public class Func_Pdf_A102Y {

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
	private static String strName = "";
	private static String  strFormCd  = "";

	public static void func_2017_A102Y_A102M(InfcPkgYe161010VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request) throws Exception{ 

		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 

		}
		
		InfcPkgPdfA102yVO yetaPdfA102yVo = new InfcPkgPdfA102yVO();
		InfcPkgPdfA102mVO yetaPdfA102mVo = new InfcPkgPdfA102mVO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		//보장성보험(G0001) , 장애인전용보장성 보험(G0002). 기본내역
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
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");

			//상품별 반복구간
			for(int k = 0; k < subXmlElChildMan.getLength();k++) {  

				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				strDatCd = subXmlElData.getAttribute("dat_cd"); 

				String strValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResid).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호

				yetaPdfA102yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
				yetaPdfA102yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
				yetaPdfA102yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
				yetaPdfA102yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
				yetaPdfA102yVo.setFormCd(strFormCd);
				yetaPdfA102yVo.setResid(strValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfA102yVo.setName(strName);

				yetaPdfA102yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfA102yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfA102yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfA102yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());


				if (strDatCd.equals("G0001")) { //보장성 총 금액

					yetaPdfA102yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));			//자료코드
					yetaPdfA102yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfA102yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));		//상호명
					yetaPdfA102yVo.setAccNo(subXmlElData.getAttribute("acc_no" ));			//증권번호
					yetaPdfA102yVo.setGoodsNm(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("goods_nm", subXmlElData)));
					
					yetaPdfA102yVo.setInsu1Resid(AnyCryptUtils.getEncSyncCrypt(nResult ,
														MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("insu1_resid", subXmlElData)),AnyCryptUtils.SEC_RRNUMC));
					yetaPdfA102yVo.setInsu1Nm(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("insu1_nm", subXmlElData)));
					
					yetaPdfA102yVo.setInsu2Resid1(AnyCryptUtils.getEncSyncCrypt(nResult ,
														MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("insu2_resid_1", subXmlElData)),AnyCryptUtils.SEC_RRNUMC));
					yetaPdfA102yVo.setInsu2Nm1(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("insu2_nm_1", subXmlElData)));
					
					yetaPdfA102yVo.setInsu2Resid2(AnyCryptUtils.getEncSyncCrypt(nResult ,
														MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("insu2_resid_2", subXmlElData)),AnyCryptUtils.SEC_RRNUMC));
					yetaPdfA102yVo.setInsu2Nm2(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("insu2_nm_2", subXmlElData)));
					
					yetaPdfA102yVo.setInsu2Resid3(AnyCryptUtils.getEncSyncCrypt(nResult ,
													MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("insu2_resid_3", subXmlElData)),AnyCryptUtils.SEC_RRNUMC));
					yetaPdfA102yVo.setInsu2Nm3(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("insu2_nm_3", subXmlElData)));
					
					
					yetaPdfA102yVo.setInsuPaySum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));
					yetaPdfA102yVo.setPdfDatAppYn("N");
					
					yetaPayr2200Service.yeta2200_PDF_A102Y_2017_Delete(yetaPdfA102yVo); 
					yetaPayr2200Service.yeta2200_PDF_A102Y_2017_Insert(yetaPdfA102yVo);
					

				}else if (strDatCd.equals("G0002")) { //장애인전용 총 금액

					yetaPdfA102yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));	//자료코드
					yetaPdfA102yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfA102yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					yetaPdfA102yVo.setAccNo(subXmlElData.getAttribute("acc_no" ));			//증권번호
					yetaPdfA102yVo.setGoodsNm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("goods_nm")));
					
					yetaPdfA102yVo.setInsu1Resid(AnyCryptUtils.getEncSyncCrypt(nResult ,
													MSFSharedUtils.allowNulls(subXmlElData.getAttribute("insu1_resid")),AnyCryptUtils.SEC_RRNUMC));
					yetaPdfA102yVo.setInsu1Nm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("insu1_nm")));
					
					yetaPdfA102yVo.setInsu2Resid1(AnyCryptUtils.getEncSyncCrypt(nResult ,
													MSFSharedUtils.allowNulls(subXmlElData.getAttribute("insu2_resid_1")),AnyCryptUtils.SEC_RRNUMC));
					yetaPdfA102yVo.setInsu2Nm1(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("insu2_nm_1")));
					
					yetaPdfA102yVo.setInsu2Resid2(AnyCryptUtils.getEncSyncCrypt(nResult ,
													MSFSharedUtils.allowNulls(subXmlElData.getAttribute("insu2_resid_2")),AnyCryptUtils.SEC_RRNUMC));
					yetaPdfA102yVo.setInsu2Nm2(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("insu2_nm_2")));
					
					yetaPdfA102yVo.setInsu2Resid3(AnyCryptUtils.getEncSyncCrypt(nResult ,
													MSFSharedUtils.allowNulls(subXmlElData.getAttribute("insu2_resid_3")),AnyCryptUtils.SEC_RRNUMC));
					yetaPdfA102yVo.setInsu2Nm3(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("insu2_nm_3")));
					
					yetaPdfA102yVo.setInsuPaySum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData), "0")));
					yetaPdfA102yVo.setPdfDatAppYn("N");
					
					yetaPayr2200Service.yeta2200_PDF_A102Y_2017_Delete(yetaPdfA102yVo);
					yetaPayr2200Service.yeta2200_PDF_A102Y_2017_Insert(yetaPdfA102yVo);

				}
				
			}

			/**	 PDFA102Y insert		:  PDFA102M은 상세 첨부가 되어 있지 않기 때문에 뺏음			*/

		}
		
		yetaPdfYE162015Vo.setFileAppPaprSbtYn("Y");
		yetaPdfYE162015Vo.setFileAppPaprYetaYn("N");
		
		yetaPdfYE162015Vo.setKybdr(sessionUser.getUsrId());
		yetaPdfYE162015Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		yetaPdfYE162015Vo.setIsmt(sessionUser.getUsrId());
		yetaPdfYE162015Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr2200Service.yeta2200_PDF_YE162015_2017_Insert(yetaPdfYE162015Vo);

		//보험료 종료
	}
	
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 보장성 보험료  연말정산 기본대상에 인서트 하기  
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : func_2017_A102Y_YetaCalc
	 * @date : 2018. 1. 22.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 22.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param ye161010VO
	 * @param request
	 * @throws Exception
	 */
	public static void func_2017_A102Y_YetaCalc(InfcPkgYe161010VO ye161010VO, HttpServletRequest request) throws Exception{ 

	 
		yetaPayr2200Service = (Yeta2200XmlService)BeanFinder.getBean("Yeta2200XmlService");
		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		   
		 //보험료(A102Y/A102M) 
         //보장성보험(G0001) , 장애인전용보장성 보험(G0002). 기본내역
		InfcPkgYe161040VO infcPkgYe161040Vo = new InfcPkgYe161040VO();
		
		infcPkgYe161040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161040Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161040Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		//YE161040 소득공제명세에 데이타 넣기
		yetaPayr2200Service.PdfYeta2017_A102Y_YE161040_Update(infcPkgYe161040Vo); 
		
		InfcPkgYe161080VO infcPkgYe161080Vo = new InfcPkgYe161080VO();
		
		
		infcPkgYe161080Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161080Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161080Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161080Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161080Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161080Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161080Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161080Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		//보험료 합산금액 넣기 
         yetaPayr2200Service.fnYeta2200_A102Y_YE161080_2017_Update(infcPkgYe161080Vo); 
        //보험료 종료
      
        
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr2200Service.yeta2200_PDF_YE162015_2017_Insert(ye161010VO);

		//보험료 종료
	}	
	
}
