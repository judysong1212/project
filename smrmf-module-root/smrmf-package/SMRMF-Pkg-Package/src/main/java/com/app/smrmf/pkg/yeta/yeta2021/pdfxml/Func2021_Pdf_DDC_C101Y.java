package com.app.smrmf.pkg.yeta.yeta2021.pdfxml;

import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.gwtrpcspring.RemoteServiceUtil;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167120_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167130_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167140_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167150_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167210_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167220_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167230_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167240_2021_VO;
import com.app.smrmf.pkg.yeta.yeta2021.pdfxml.service.Yeta6200XmlService;

public class Func2021_Pdf_DDC_C101Y {

	@Resource(name = "Yeta6200XmlService")
	private static Yeta6200XmlService yetaPayr3200Service;

	private static NodeList subXmlElChildForm = null;
	private static Node subXmlItemMan = null;
	private static NodeList subXmlElChildMan = null;
	private static Element subXmlElMan = null;
	private static Node subXmlItemData = null;
	private static Element subXmlElData = null;

	private static String strmMrCtrTermStrtDt = "";
	private static String strPnamt = "";
	private static String strCtrTermStrtDt = "";
	
	private static String strFnm = "";
	private static String strResnoEncCntn = "";
	private static String strTnm = "";				
	private static String strBsnoEncCntn = "";	
	
	private static String strAdr= "";	
	private static String strPfbAdr = "";		 
	private static String strFormCd  = "";

	public static void func_2021_C101Y(InfcPkgYe161010_2021_VO ye161010Vo, Element  xmlelDoc, Element  subXmlElForm, String nResult, HttpServletRequest request) throws Exception{ 

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 

		}
		InfcPkgYe167210_2021_VO ye167210Vo = new InfcPkgYe167210_2021_VO();
		InfcPkgYe167220_2021_VO ye167220Vo = new InfcPkgYe167220_2021_VO();
		InfcPkgYe167230_2021_VO ye167230Vo = new InfcPkgYe167230_2021_VO();
		InfcPkgYe167240_2021_VO ye167240Vo = new InfcPkgYe167240_2021_VO();
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		
		//인원별 반복구간
		for (int j = 0; j < subXmlElChildForm.getLength();j++) { 

			subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			subXmlElMan  = (Element) subXmlItemMan;

			strTnm = subXmlElMan.getAttribute("tnm");   //근무처명칭				
			strBsnoEncCntn = subXmlElMan.getAttribute("bsnoEncCntn");   //사업자등록번호
			strFnm = subXmlElMan.getAttribute("fnm");	//이름
			strResnoEncCntn = subXmlElMan.getAttribute("resnoEncCntn");   //주민번호
			strAdr	= subXmlElMan.getAttribute("adr");   //주소
			strPfbAdr = subXmlElMan.getAttribute("pfbAdr");   //사업장소재지
			
			String strValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResnoEncCntn).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			
			/** -------------------------------- 초기화 작업 시작 ------------------------------------*/
			ye167210Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167210Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167210Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167210Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta6200_PDF_YE167210_2021_Delete(ye167210Vo);	//기본정보 삭제
			
			ye167220Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167220Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167220Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167220Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta6200_PDF_YE167220_2021_Delete(ye167220Vo);	//인적공제 삭제	
			
			ye167230Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167230Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167230Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167230Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta6200_PDF_YE167230_2021_Delete(ye167230Vo);	//인적공제 삭제	
			
			ye167240Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167240Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167240Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167240Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta6200_PDF_YE167240_2021_Delete(ye167240Vo);	//연금 보험 삭제
			
			/** -------------------------------- 초기화 작업 종료 ------------------------------------*/
			
			ye167210Vo.setFormCd(strFormCd);
			ye167210Vo.setTnm(strTnm);
			ye167210Vo.setBsnoEncCntn(strBsnoEncCntn);
			ye167210Vo.setFnm(strFnm);
			ye167210Vo.setResnoEncCntn(strValue);  
			 	
			ye167210Vo.setAdr(strAdr);
			ye167210Vo.setPdfAdr(strPfbAdr);
			
			ye167210Vo.setKybdr(sessionUser.getUsrId());
			ye167210Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			ye167210Vo.setIsmt(sessionUser.getUsrId());
			ye167210Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			yetaPayr3200Service.yeta6200_PDF_YE167210_2021_Insert(ye167210Vo);	//기본정보 입력
			
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");

			//상품별 반복구간
			for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
				System.out.println("길이 :" + subXmlElChildMan.getLength());
				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				
				strmMrCtrTermStrtDt = subXmlElData.getAttribute("mmrCtrTermStrtDt"); 
				strPnamt = subXmlElData.getAttribute("pnamt");
				strCtrTermStrtDt = subXmlElData.getAttribute("ctrTermStrtDt");
				
				if (!strmMrCtrTermStrtDt.equals("")) { // 월세액 세액 공제 명세 반복 구간
					setYe167220Vo(ye167220Vo, request);
				}
				else if (!strPnamt.equals("")) { //금전 소비 대차 계약 내용 반복 구간
					setYe167230Vo(ye167230Vo, request);
				}
				else if (!strCtrTermStrtDt.equals("")) { //임대차 계약 내용 반복 구간
					setYe167240Vo(ye167240Vo, request);
				}
			}

		}

	}
	
	public static void setYe167220Vo(InfcPkgYe167220_2021_VO ye167220Vo , HttpServletRequest request) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167220Vo.setLsorFnm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("lsorFnm")));
		ye167220Vo.setTxprDscmNoEncCntn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("txprDscmNoEncCntn")));
		ye167220Vo.setHsngTypeClCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("hsngTypeClCd")));
		ye167220Vo.setHsngCtrSfl(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hsngCtrSfl"),"0")));
		ye167220Vo.setMmrLsrnCtrpAdr(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("mmrLsrnCtrpAdr")));
		
		ye167220Vo.setMmrCtrTermStrtDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("mmrCtrTermStrtDt")));
		ye167220Vo.setMmrCtrTermEndDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("mmrCtrTermEndDt")));
		ye167220Vo.setUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("useAmt"),"0")));
		ye167220Vo.setMmrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mmrDdcAmt"),"0")));
		
		ye167220Vo.setKybdr(sessionUser.getUsrId());
		ye167220Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167220Vo.setIsmt(sessionUser.getUsrId());
		ye167220Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta6200_PDF_YE167220_2021_Insert(ye167220Vo);	//기본정보 입력
	}
	
	public static void setYe167230Vo(InfcPkgYe167230_2021_VO ye167230Vo , HttpServletRequest request) throws Exception{
		
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			
			yetaPayr3200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167230Vo.setLsorFnm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("lsorFnm")));
		ye167230Vo.setTxprDscmNoEncCntn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("txprDscmNoEncCntn")));
		System.out.println((String)subXmlElData.getAttribute("ctrTermDt").substring(0, 7));
		ye167230Vo.setCtrTermStrDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("ctrTermDt").substring(0, 8)));
		ye167230Vo.setCtrTermEndDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("ctrTermDt").substring(9, 17)));
		ye167230Vo.setLnpbIntrt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lnpbIntrt"),"0")));

		ye167230Vo.setAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("amt"),"0")));
		ye167230Vo.setPnamt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pnamt"),"0")));
		ye167230Vo.setIntrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("intrAmt"),"0")));
		ye167230Vo.setDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ddcAmt"),"0")));
		
		ye167230Vo.setKybdr(sessionUser.getUsrId());
		ye167230Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167230Vo.setIsmt(sessionUser.getUsrId());
		ye167230Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta6200_PDF_YE167230_2021_Insert(ye167230Vo);	//기본정보 입력
	}
	
	public static void setYe167240Vo(InfcPkgYe167240_2021_VO ye167240Vo , HttpServletRequest request) throws Exception{
		
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			
			yetaPayr3200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167240Vo.setLsorFnm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("lsorFnm")));
		ye167240Vo.setXprDscmNoEncCntn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("txprDscmNoEncCntn")));
		ye167240Vo.setHsngTypeClCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("hsngTypeClCd")));
		ye167240Vo.setHsngCtrSfl(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hsngCtrSfl"),"0")));
		ye167240Vo.setLsrnCtrpAdr(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("lsrnCtrpAdr")));
		
		ye167240Vo.setCtrTermStrtDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("ctrTermStrtDt")));
		ye167240Vo.setCtrrTermEndDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("ctrTermEndDt")));
		ye167240Vo.setLfhDpit(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lfhDpit"),"0")));
		
		ye167240Vo.setKybdr(sessionUser.getUsrId());
		ye167240Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167240Vo.setIsmt(sessionUser.getUsrId());
		ye167240Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta6200_PDF_YE167240_2021_Insert(ye167240Vo);	//기본정보 입력
	}
	
}
