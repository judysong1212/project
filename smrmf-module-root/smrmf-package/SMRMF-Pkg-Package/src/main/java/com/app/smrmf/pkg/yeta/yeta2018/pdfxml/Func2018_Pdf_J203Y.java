package com.app.smrmf.pkg.yeta.yeta2018.pdfxml;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfJ203m_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfJ203ySrh_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfJ203y_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgPdfYE162015_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161010_2018_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2018.InfcPkgYe161060_2018_VO;
import com.app.smrmf.pkg.yeta.yeta2018.pdfxml.service.Yeta3200XmlService;

public class Func2018_Pdf_J203Y {

	@Resource(name = "Yeta3200XmlService")
	private static Yeta3200XmlService yetaPayr3200Service;

	private static NodeList subXmlElChildForm = null;
	private static Node subXmlItemMan = null;
	private static NodeList subXmlElChildMan = null;
	private static Element subXmlElMan = null;
	private static Node subXmlItemData = null;
	private static Element subXmlElData = null;
	
	private static NodeList subXmlElChildSum = null;
	private static Element subXmlElSum = null;
	private static Node subXmlItemSum = null;
	
	private static NodeList subXmlElChildAmt = null;
	private static Element subXmlElAmt = null;
	private static Node subXmlItemAmt = null;

	private static String strResid = "";
	private static String strDatCd = "";
	private static String strDdct = "";
	private static String strMm = "";
	private static String strFixCd = "";
	private static String strFormCd = "";
	private static String strName = "";
	
	public static void func_2018_J203Y_J203M(InfcPkgYe161010_2018_VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request ) throws Exception{
		
		/**+++++++++++  장기 주택 차입금 시작++++++++++++++++++++++++++++++++++++++++++++++++*/

		//  장기 주택 차입금 시작
		// 장기주택저당차입금 이자상환액 J203Y 연간합계 J203M 월별 J02 장기주택저당차입금 이자상환 본인
		//2010년:J201Y -> 2011년:J202Y -> 2012년:J203Y
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta3200XmlService) wac.getBean("Yeta3200XmlService" ); 
		}
		
		InfcPkgPdfJ203y_2018_VO yetaPdfJ203yVo = new InfcPkgPdfJ203y_2018_VO();
		InfcPkgPdfJ203m_2018_VO yetaPdfJ203mVo = new InfcPkgPdfJ203m_2018_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);

		yetaPdfJ203yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfJ203yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfJ203yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfJ203yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr3200Service.yeta3200_PDF_J203Y_2018_Delete(yetaPdfJ203yVo);
		
		yetaPdfJ203mVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfJ203mVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfJ203mVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfJ203mVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr3200Service.yeta3200_PDF_J203M_2018_Delete(yetaPdfJ203mVo);
		
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
				
				yetaPdfJ203yVo.setFormCd(strFormCd);
				yetaPdfJ203yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfJ203yVo.setName(strName);
				yetaPdfJ203yVo.setPdfDatAppYn("N");
				
				yetaPdfJ203yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfJ203yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfJ203yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfJ203yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				if (strDatCd.equals("G0017")) {
					
					yetaPdfJ203yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfJ203yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfJ203yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					yetaPdfJ203yVo.setAccNo(subXmlElData.getAttribute("acc_no"));
					
					if (PkgFuncUtils.getXmlTagValue("lend_kd", subXmlElData).equals("1")) {
						setPdfJ203yVo(yetaPdfJ203yVo, yetaPdfJ203mVo, ye161010VO, request, subXmlElData, strDecValue, k, sessionUser);
					}
					else if (PkgFuncUtils.getXmlTagValue("lend_kd", subXmlElData).equals("2")) {
						setPdfJ203yVo(yetaPdfJ203yVo, yetaPdfJ203mVo, ye161010VO, request, subXmlElData, strDecValue, k, sessionUser);
					}
					else if (PkgFuncUtils.getXmlTagValue("lend_kd", subXmlElData).equals("3")) {
						setPdfJ203yVo(yetaPdfJ203yVo, yetaPdfJ203mVo, ye161010VO, request, subXmlElData, strDecValue, k, sessionUser);
					}
					else if (PkgFuncUtils.getXmlTagValue("lend_kd", subXmlElData).equals("Z")) {
						setPdfJ203yVo(yetaPdfJ203yVo, yetaPdfJ203mVo, ye161010VO, request, subXmlElData, strDecValue, k, sessionUser);
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

		// 장기주택 저당 차입금 이자상환액 종료
	
	}
	
	public static void setPdfJ203yVo(InfcPkgPdfJ203y_2018_VO yetaPdfJ203yVo, InfcPkgPdfJ203m_2018_VO yetaPdfJ203mVo, InfcPkgYe161010_2018_VO ye161010VO, 
			HttpServletRequest request, Element subXmlElData, String strDecValue, int k, MSFSysm0100BM sessionUser) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta3200XmlService) wac.getBean("Yeta3200XmlService" ); 
		}
		
		yetaPdfJ203yVo.setLendKd(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("lend_kd", subXmlElData))); 
		yetaPdfJ203yVo.setHouseTakeDt(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("house_take_dt", subXmlElData)));
		yetaPdfJ203yVo.setMortSetupDt(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("mort_setup_dt", subXmlElData)));
		yetaPdfJ203yVo.setStartDt(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("start_dt", subXmlElData)));
		yetaPdfJ203yVo.setEndDt(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("end_dt", subXmlElData)));
		yetaPdfJ203yVo.setRepayYears(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("repay_years", subXmlElData),"0")));
		yetaPdfJ203yVo.setLendGoodsNm(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("lend_goods_nm", subXmlElData)));
		yetaPdfJ203yVo.setDebt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("debt", subXmlElData),"0")));
		yetaPdfJ203yVo.setFixedRateDebt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("fixed_rate_debt", subXmlElData),"0")));
		yetaPdfJ203yVo.setNotDeferDebt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("not_defer_debt", subXmlElData),"0")));
		yetaPdfJ203yVo.setThisYearRedeAmt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("this_year_rede_amt", subXmlElData),"0")));
		
		subXmlElChildSum= subXmlElData.getElementsByTagName("sum");

		for(int i = 0; i < subXmlElChildSum.getLength(); i++) {  
			subXmlItemSum =  subXmlElChildSum.item(i);
			subXmlElSum = (Element) subXmlItemSum;
			strDdct = subXmlElSum.getAttribute("ddct");
			yetaPdfJ203yVo.setYearSumDdct(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));
			yetaPdfJ203yVo.setSumDdct(new BigDecimal(MSFSharedUtils.defaultNulls(strDdct,"0")));
			
			yetaPayr3200Service.yeta3200_PDF_J203Y_2018_Insert(yetaPdfJ203yVo);
		}
		
		if (strFormCd.equals("J203M")) {
			
			yetaPdfJ203mVo.setKybdr(sessionUser.getUsrId());
			yetaPdfJ203mVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			yetaPdfJ203mVo.setIsmt(sessionUser.getUsrId());
			yetaPdfJ203mVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			subXmlElChildAmt= subXmlElData.getElementsByTagName("amt");

			for(int i = 0; i < subXmlElChildAmt.getLength(); i++) {  
				subXmlItemAmt =  subXmlElChildAmt.item(i);
				subXmlElAmt = (Element) subXmlItemAmt;
				strMm = subXmlElAmt.getAttribute("mm");
				strFixCd = subXmlElAmt.getAttribute("fix_cd");
				
				if (strMm.equals("01")) {
					setPdfJ203mVo(yetaPdfJ203mVo, request, subXmlElData);
				}
				else if (strMm.equals("02")) {
					setPdfJ203mVo(yetaPdfJ203mVo, request, subXmlElData);
				}
				else if (strMm.equals("03")) {
					setPdfJ203mVo(yetaPdfJ203mVo, request, subXmlElData);
				}
				else if (strMm.equals("04")) {
					setPdfJ203mVo(yetaPdfJ203mVo, request, subXmlElData);
				}
				else if (strMm.equals("05")) {
					setPdfJ203mVo(yetaPdfJ203mVo, request, subXmlElData);
				}
				else if (strMm.equals("06")) {
					setPdfJ203mVo(yetaPdfJ203mVo, request, subXmlElData);
				}
				else if (strMm.equals("07")) {
					setPdfJ203mVo(yetaPdfJ203mVo, request, subXmlElData);
				}
				else if (strMm.equals("08")) {
					setPdfJ203mVo(yetaPdfJ203mVo, request, subXmlElData);
				}
				else if (strMm.equals("09")) {
					setPdfJ203mVo(yetaPdfJ203mVo, request, subXmlElData);
				}
				else if (strMm.equals("10")) {
					setPdfJ203mVo(yetaPdfJ203mVo, request, subXmlElData);
				}
				else if (strMm.equals("11")) {
					setPdfJ203mVo(yetaPdfJ203mVo, request, subXmlElData);
				}
				else if (strMm.equals("12")) {
					setPdfJ203mVo(yetaPdfJ203mVo, request, subXmlElData);
				}
			}
			
		}

	}

	public static void setPdfJ203mVo(InfcPkgPdfJ203m_2018_VO yetaPdfJ203mVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta3200XmlService) wac.getBean("Yeta3200XmlService" ); 
		}

		yetaPdfJ203mVo.setLoanAmtMn(strMm);
		yetaPdfJ203mVo.setLoanMmAmt(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("amt", subXmlElData),"0")));
		yetaPdfJ203mVo.setFixCd(strFixCd);
		
		yetaPayr3200Service.yeta3200_PDF_J203M_2018_Insert(yetaPdfJ203mVo);

	}
	
	public static void func_2018_J203Y_YetaCalc(InfcPkgYe161010_2018_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta3200XmlService)BeanFinder.getBean("Yeta3200XmlService");
		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
	
		/**+++++++++++  장기 주택 차입금 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
        
        //  장기 주택 차입금 시작
        // 장기주택저당차입금 이자상환액 J203Y 연간합계 J203M 월별 J02 장기주택저당차입금 이자상환 본인
        //2010년:J201Y -> 2011년:J202Y -> 2012년:J203Y
		 
		

		   BigDecimal edSpchRe06  = BigDecimal.ZERO;
		   BigDecimal edSpchRe10 = BigDecimal.ZERO;
		   BigDecimal edSpchRe15 = BigDecimal.ZERO;
		   BigDecimal edSPCH_REFX = BigDecimal.ZERO; 
		   BigDecimal edSPCH_REEC  = BigDecimal.ZERO; 
	  
		   BigDecimal edSPCH_15FX = BigDecimal.ZERO;
		   BigDecimal edSPCH_15FB = BigDecimal.ZERO;
		   BigDecimal edSPCH_15EC = BigDecimal.ZERO;
		   BigDecimal edSPCH_10FB = BigDecimal.ZERO;
		   
		   
		InfcPkgPdfJ203ySrh_2018_VO yetaPdfJ203ySrhVo = new InfcPkgPdfJ203ySrh_2018_VO();
		
		yetaPdfJ203ySrhVo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfJ203ySrhVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfJ203ySrhVo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfJ203ySrhVo.setClutSeptCd(ye161010VO.getClutSeptCd());
	
		
		List<InfcPkgPdfJ203y_2018_VO> infcPkgPdfJ203yList = new ArrayList<InfcPkgPdfJ203y_2018_VO>();
		
		//퇴직연금
		infcPkgPdfJ203yList = (List<InfcPkgPdfJ203y_2018_VO>)yetaPayr3200Service.PdfYeta3200_F102Y_PDF_J203Y_Select(yetaPdfJ203ySrhVo);  
		
		if (infcPkgPdfJ203yList.size() > 0) { 
			
			for(int icnt = 0;icnt < infcPkgPdfJ203yList.size();icnt++) {
				
					InfcPkgPdfJ203y_2018_VO vPdfJ203yVo = new InfcPkgPdfJ203y_2018_VO();
					vPdfJ203yVo = infcPkgPdfJ203yList.get(icnt);
					
	                if (vPdfJ203yVo.getDatCd().equals("G0017")) {
	                	 
	                    if ((vPdfJ203yVo.getStartDt().compareTo("20120101") < 0) 
	                   		 && (( vPdfJ203yVo.getRepayYears().compareTo(new BigDecimal("0")) >= 0) 
	                   	 	&& ( vPdfJ203yVo.getRepayYears().compareTo(new BigDecimal("15")) < 0) 
	                   		 )) {
	                    //’11년도 이전 차입분으로 상환기간 15년 미만인
	                      edSpchRe06  = edSpchRe06.add(vPdfJ203yVo.getSumDdct()); 
	                   		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                    }
	                    else if  ((vPdfJ203yVo.getStartDt().compareTo("20120101") < 0) 
	                   		 && (( vPdfJ203yVo.getRepayYears().compareTo(new BigDecimal("15")) >= 0)   
	                   				 && ( vPdfJ203yVo.getRepayYears().compareTo(new BigDecimal("29")) < 0)   )) {
	                    //’11년도 이전 차입분으로 다음에 해당하는 경우 공제한도는 연 1,000만원을 적용함
	                    //- 상환기간 15년 이상 29년 미만인 경우
	                      edSpchRe10   = edSpchRe10.add(vPdfJ203yVo.getSumDdct()); 
	                   		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                    }
	                    else if  ((vPdfJ203yVo.getStartDt().compareTo("20120101") < 0)   
	                   	    && ( vPdfJ203yVo.getRepayYears().compareTo(new BigDecimal("30")) >= 0)) {
	                    // ’11년도 이전 차입분으로 상환기간 30년 이상인 경우 
	                      edSpchRe15   = edSpchRe15.add(vPdfJ203yVo.getSumDdct());
	                   		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                    } 
	                    else if  ((vPdfJ203yVo.getStartDt().compareTo("20150101") < 0) 
	                   	        &&  ( vPdfJ203yVo.getRepayYears().compareTo(new BigDecimal("15")) >= 0))  {
	                     
	                   	 if (( vPdfJ203yVo.getFixedRateDebt().compareTo(BigDecimal.ZERO) > 0)  
	                   		  ||  ( vPdfJ203yVo.getNotDeferDebt().compareTo(BigDecimal.ZERO) > 0)) {
	                          //’12.1.1 이후 신규 차입분(차입금 상환기간 연장 포함)으로서 상환기간이 15년 이상인 차입금
	                          edSPCH_REFX   = edSPCH_REFX.add(vPdfJ203yVo.getSumDdct()); 
	                       		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                   	 }
	                       else
	                       {
	                          //’12.1.1 이후 신규 차입분(차입금 상환 기간 연장 포함)으로서 상환기간이 15년 이상이고
	                          edSPCH_REEC    = edSPCH_REEC.add(vPdfJ203yVo.getSumDdct());
	                       		   
	                       		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                       }
	
	                    }
	                    else if  ((vPdfJ203yVo.getStartDt().compareTo("20150101") >= 0)  
	                   	        && ( vPdfJ203yVo.getRepayYears().compareTo(new BigDecimal("15")) >= 0)) {
	                   	   
	                      if ( ( vPdfJ203yVo.getFixedRateDebt().compareTo(BigDecimal.ZERO) > 0)  
	              		     &&  ( vPdfJ203yVo.getNotDeferDebt().compareTo(BigDecimal.ZERO) > 0)) {
	                   	 
	                          //’15.1.1 이후 신규 차입분(차입금 상환기간 연장 포함)으로서 상환기간이 15년 이상인 차입금 중 고정금리이면서, 비거치상환대출
	                          edSPCH_15FX   = edSPCH_15FX.add(vPdfJ203yVo.getSumDdct());
	                       		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                       } else  if  (( vPdfJ203yVo.getFixedRateDebt().compareTo(BigDecimal.ZERO) > 0)  
	              		     ||  ( vPdfJ203yVo.getNotDeferDebt().compareTo(BigDecimal.ZERO) > 0)) {
	                   	 
	                          //’15.1.1 이후 신규 차입분(차입금 상환기간 연장 포함)으로서 상환기간이 15년 이상인 차입금 중 고정금리이거나 비거치상환대출
	                          edSPCH_15FB  = edSPCH_15FB.add(vPdfJ203yVo.getSumDdct()); 
	                       		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                       }
	                       else
	                       {
	                          //’15.1.1 이후 신규 차입분(차입금 상환 기간 연장 포함)으로서 상환기간이 15년 이상이고 기타대출
	                          edSPCH_15EC    = edSPCH_15EC.add(vPdfJ203yVo.getSumDdct()); 
	                       		   //+ strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                       }
	
	                  }
	                    else if  ((vPdfJ203yVo.getStartDt().compareTo("20150101") >= 0)  
	                   		    &&  (( vPdfJ203yVo.getRepayYears().compareTo(new BigDecimal("10")) >= 0) 
	                   		    		  && ( vPdfJ203yVo.getRepayYears().compareTo(new BigDecimal("15")) < 0)))  {
	                    //’15.1.1 이후 차입분으로 다음에 해당하는 경우 공제한도는 연 300만원을 적용함
	                    //- 상환기간 10년 이상 15년 미만인 경우
	                      if  (( vPdfJ203yVo.getFixedRateDebt().compareTo(BigDecimal.ZERO) > 0)  
	   	                                		  ||  ( vPdfJ203yVo.getNotDeferDebt().compareTo(BigDecimal.ZERO) > 0)) { 
	                          //’12.1.1 이후 신규 차입분(차입금 상환기간 연장 포함)으로서 상환기간이 15년 이상인 차입금 중 고정금리이거나 비거치상환대출
	                          edSPCH_10FB   = edSPCH_10FB.add(vPdfJ203yVo.getSumDdct()); 
	                          // + strtofloat(subXmlItemData.NamedItem['sum'].Text);
	                      }
	                        
	                  }
	              }
  
         
			}
			
			//장기 주택 차입금
			InfcPkgYe161060_2018_VO infcPkgYe161060Vo = new InfcPkgYe161060_2018_VO();
			
			
			infcPkgYe161060Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe161060Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe161060Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe161060Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
			
			
			infcPkgYe161060Vo.setLthYr15BlwItrAmt(edSpchRe06); //	장기주택저장차입금2011년이전차입분중15년미만이자상환액 
			infcPkgYe161060Vo.setLthYr29ItrAmt(edSpchRe10); //	장기주택저당차입금2011년이전차입분중15_29년이자상환액 
			infcPkgYe161060Vo.setLthY30OverItrAmt(edSpchRe15); //	장기주택저당차입금2011이전차입분중30년이상이자상환액 
			infcPkgYe161060Vo.setLthYr2012AfthY15Amt(edSPCH_REFX); //	장기주택저당차입금2012이후고정금리이거나비거치상환대출이자상환액 
			infcPkgYe161060Vo.setLthYr2012EtcBrwItrAmt(edSPCH_REEC); //	장기주택저당차입금2012이후기타대출이자상환액 
			infcPkgYe161060Vo.setLthYr2015AfthFxnIrItrAmt(edSPCH_15FX); //	장기주택저당차입금2015이후_15이상_고정금리이면서비거치상환대출이자상환액 
			infcPkgYe161060Vo.setLthYr2015AfthY15Amt(edSPCH_15FB); //	장기주택저당차입금2015이후_15이상_고정금리이거나비거치상환대출이자상환액 
			infcPkgYe161060Vo.setLthYr2015AfthEtcAmt(edSPCH_15EC); //	장기주택저당차입금2015이후_15이상_기타대출이자상환액 
			infcPkgYe161060Vo.setLthYr2015AfthYr15Amt(edSPCH_10FB); //	장기주택저당차입금_2015이후_10_15고정금리이거나비거치상환대출이자상환액 
			 

//          yeta2000Vo.setSpchRe06(edSpchRe06);  // 특별공제_11년 이전 장기주택저당차입금15년 ~ 29년
//          yeta2000Vo.setSpchRe10(edSpchRe10);  // 특별공제_11년 이전 장기주택저당차입금15년 ~ 29년
//          yeta2000Vo.setSpchRe20(edSpchRe15);  // 특별공제_11년 이전 장기주택저당차입금30년 이상
//          yeta2000Vo.setSpchReec(edSPCH_REEC); // 특별공제_12장기주택저당차입금_기타
//          yeta2000Vo.setSpchRefx(edSPCH_REFX); // 특별공제_12장기주택저당차입금_고정 (고정금리이거나, 비거치상환대출)
//          yeta2000Vo.setSpch15fx(edSPCH_15FX); // 특별공제_15장기주택저당_15고정AND 비거치상환
//          yeta2000Vo.setSpch15fb(edSPCH_15FB); // 특별공제_15장기주택저당_15고정OR 비거치상환 
//          yeta2000Vo.setSpch15ec(edSPCH_15EC); // 특별공제_15장기주택저당_15기타대출
//          yeta2000Vo.setSpch10fb(edSPCH_10FB); // 특별공제_15장기주택저당_10고정 OR 비거치상환
				
			
			infcPkgYe161060Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe161060Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe161060Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe161060Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
			// 장기 주택 차입금 합계  
	         yetaPayr3200Service.fnYeta3200_J203Y_YE161060_2018_Update(infcPkgYe161060Vo); 
	     
			
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
