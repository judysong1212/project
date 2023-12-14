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
import com.app.smrmf.egov.comutils.payr.PkgFuncUtils;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe161010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167010_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167020_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167030_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167040_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167050_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167060_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167070_2021_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2021.InfcPkgYe167530_2021_VO;
import com.app.smrmf.pkg.yeta.yeta2021.pdfxml.service.Yeta6200XmlService;

public class Func2021_Pdf_DDC_A101Y {

	@Resource(name = "Yeta6200XmlService")
	private static Yeta6200XmlService yetaPayr3200Service;

	private static NodeList subXmlElChildForm = null;
	private static Node subXmlItemMan = null;
	private static NodeList subXmlElChildMan = null;
	private static Element subXmlElMan = null;
	private static Node subXmlItemData = null;
	private static Element subXmlElData = null;

	private static String strDocType = "";
	private static String strSeq  = "";
	
	private static String strSuptFmlyRltClCd = "";
	private static String strNpHthrWaInfeeAmt = "";
	private static String strHthrHifeAmt = "";
	private static String strYr2000BefNtplPnsnSvngUseAmt = "";
	private static String strTchIntdCtrYn = "";
	private static String strBrwOrgnBrwnHsngTennLnpbSrmNtsAmt = "";
	
	private static String strFnm = "";
	private static String strResnoEncCntn = "";
	private static String strTnm = "";				
	private static String strBsnoEncCntn = "";	
	
	private static String strHshrClCd = "";	
	private static String strRsplNtnInfr = "";		 
	private static String strDtyStrtDt = "";	
	private static String strDtyEndDt = "";	
	private static String strReStrtDt = "";	
	
	private static String strReEndDt = "";		
	private static String strRsdtClCd = "";
	private static String strRsplNtnCd = ""; 
	private static String strInctxWhtxTxamtMetnCd = "";	
	private static String strInpmYn	= "";
	
	private static String strPrifChngYn = "";
	private static String strBscDdcNfpCnt = ""; 
	private static String strSccNfpCnt = "";	 
	private static String strChbtAdopNfpCnt	= "";	
	private static String strWmnNfpCnt = "";	 
	
	private static String strSnprntNfpCnt = "";	 
	private static String strDsbrNfpCnt	= "";	 
	private static String strAge6LtNfpCnt = "";	
	private static String strFormCd  = "";

	public static void func_2021_A101Y(InfcPkgYe161010_2021_VO ye161010Vo, Element  xmlelDoc, Element  subXmlElForm, String nResult, HttpServletRequest request) throws Exception{ 

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 

		}
		InfcPkgYe167010_2021_VO ye167010Vo = new InfcPkgYe167010_2021_VO();
		InfcPkgYe167020_2021_VO ye167020Vo = new InfcPkgYe167020_2021_VO();
		InfcPkgYe167030_2021_VO ye167030Vo = new InfcPkgYe167030_2021_VO();
		InfcPkgYe167040_2021_VO ye167040Vo = new InfcPkgYe167040_2021_VO();
		InfcPkgYe167050_2021_VO ye167050Vo = new InfcPkgYe167050_2021_VO();
		InfcPkgYe167060_2021_VO ye167060Vo = new InfcPkgYe167060_2021_VO();
		InfcPkgYe167070_2021_VO ye167070Vo = new InfcPkgYe167070_2021_VO();
		InfcPkgYe167530_2021_VO ye167530Vo = new InfcPkgYe167530_2021_VO();
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		strDocType = PkgFuncUtils.getXmlTagValue("doc_type", xmlelDoc);    //문서종류   
		strSeq=  PkgFuncUtils.getXmlTagValue("seq", xmlelDoc); //일련번호 
		
		//보장성보험(G0001) , 장애인전용보장성 보험(G0002). 기본내역
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		
		//인원별 반복구간
		for (int j = 0; j < subXmlElChildForm.getLength();j++) { 

			subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			subXmlElMan  = (Element) subXmlItemMan;

			strFnm = subXmlElMan.getAttribute("fnm");	//이름
			strResnoEncCntn = subXmlElMan.getAttribute("resnoEncCntn");   //주민번호
			strTnm = subXmlElMan.getAttribute("tnm");   //근무처명칭				
			strBsnoEncCntn = subXmlElMan.getAttribute("bsnoEncCntn");   //사업자등록번호		
			strHshrClCd = subXmlElMan.getAttribute("hshrClCd");   //세대주여부	
			
			strRsplNtnInfr = subXmlElMan.getAttribute("rsplNtnInfr");   //국적		
			strDtyStrtDt = subXmlElMan.getAttribute("dtyStrtDt");   //근무기간시작일	 
			strDtyEndDt = subXmlElMan.getAttribute("dtyEndDt");   //근무기간종료일	     
			strReStrtDt = subXmlElMan.getAttribute("reStrtDt");   //감면기간시작일	     
			strReEndDt = subXmlElMan.getAttribute("reEndDt");   //감면기간종료일	
			
			strRsdtClCd = subXmlElMan.getAttribute("rsdtClCd");   //거주구분     
			strRsplNtnCd = subXmlElMan.getAttribute("rsplNtnCd");   //거주지국    
			strInctxWhtxTxamtMetnCd = subXmlElMan.getAttribute("inctxWhtxTxamtMetnCd");   //소득세 원천징수세액 조정신청
			strInpmYn	= subXmlElMan.getAttribute("inpmYn");   //분납신청 여부        
			strPrifChngYn = subXmlElMan.getAttribute("prifChngYn");   //인적공제 항목 변동여부  
			
			strBscDdcNfpCnt = subXmlElMan.getAttribute("bscDdcNfpCnt");   //기본공제인원수 
			strSccNfpCnt = subXmlElMan.getAttribute("sccNfpCnt");   //경로우대인원수 
			strChbtAdopNfpCnt	= subXmlElMan.getAttribute("chbtAdopNfpCnt");   //출산입양인원수
			strWmnNfpCnt = subXmlElMan.getAttribute("wmnNfpCnt");   //부녀자인원수	 
			strSnprntNfpCnt = subXmlElMan.getAttribute("snprntNfpCnt");   //한부모인원수	
			
			strDsbrNfpCnt	= subXmlElMan.getAttribute("dsbrNfpCnt");   //장애인인원수	 
			strAge6LtNfpCnt = subXmlElMan.getAttribute("age6LtNfpCnt");   //6세이하인원수	
			
			String strValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResnoEncCntn).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			
			/** -------------------------------- 초기화 작업 시작 ------------------------------------*/
			ye167010Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167010Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167010Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167010Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta6200_PDF_YE167010_2021_Delete(ye167010Vo);	//기본정보 삭제
			
			ye167020Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167020Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167020Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167020Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta6200_PDF_YE167020_2021_Delete(ye167020Vo);	//인적공제 삭제	
			
			ye167030Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167030Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167030Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167030Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta6200_PDF_YE167030_2021_Delete(ye167030Vo);	//인적공제 삭제	
			
			ye167040Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167040Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167040Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167040Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta6200_PDF_YE167040_2021_Delete(ye167040Vo);	//연금 보험 삭제
			
			ye167050Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167050Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167050Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167050Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta6200_PDF_YE167050_2021_Delete(ye167050Vo);	//특별소득공제 삭제
			
			ye167060Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167060Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167060Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167060Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta6200_PDF_YE167060_2021_Delete(ye167060Vo);	//그 밖의 소득공제 삭제
			
			ye167070Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167070Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167070Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167070Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta6200_PDF_YE167070_2021_Delete(ye167070Vo);	//세액감면 및 공제 삭제
			
			ye167530Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167530Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167530Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167530Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta6200_PDF_YE167530_2021_Delete(ye167530Vo);	//국세청, 기타자료 항목구분 삭제
			
			/** -------------------------------- 초기화 작업 종료 ------------------------------------*/
			
			ye167010Vo.setFnm(strFnm);
			
			ye167010Vo.setResnoEncCntn(strValue);  
			ye167010Vo.setTnm(strTnm);
			ye167010Vo.setBsnoEncCntn(strBsnoEncCntn);
			ye167010Vo.setHshrClCd(strHshrClCd);
			ye167010Vo.setRsplNtnInfrCd(strRsplNtnInfr);
			
			ye167010Vo.setDtyStrtDt(strDtyStrtDt);
			ye167010Vo.setDtyEndDt(strDtyEndDt);
			ye167010Vo.setReStrtDt(strReStrtDt);
			ye167010Vo.setReEndDt(strReEndDt);
			ye167010Vo.setRsdtClCd(strRsdtClCd);
			
			ye167010Vo.setRsplNtnCd(strRsplNtnCd);
			ye167010Vo.setInctxWhtxTxamtMetnCd(strInctxWhtxTxamtMetnCd);
			ye167010Vo.setInpmYn(strInpmYn);
			ye167010Vo.setPrifChngYn(strPrifChngYn);
			ye167010Vo.setBscDdcnFpCnt(MSFSharedUtils.convertStringToBigDecimal(strBscDdcNfpCnt));
			
			ye167010Vo.setSccNfpCnt(MSFSharedUtils.convertStringToBigDecimal(strSccNfpCnt));
			ye167010Vo.setChbtAdopNfpCnt(MSFSharedUtils.convertStringToBigDecimal(strChbtAdopNfpCnt));
			ye167010Vo.setWmnNfpCnt(MSFSharedUtils.convertStringToBigDecimal(strWmnNfpCnt));
			ye167010Vo.setSnprntNfpCnt(MSFSharedUtils.convertStringToBigDecimal(strSnprntNfpCnt));
			ye167010Vo.setDsbrNfpCnt(MSFSharedUtils.convertStringToBigDecimal(strDsbrNfpCnt));
			
			ye167010Vo.setAge6ltNfpCnt(MSFSharedUtils.convertStringToBigDecimal(strAge6LtNfpCnt));
			ye167010Vo.setDocType(strDocType);
			ye167010Vo.setIssDtSeilNum(MSFSharedUtils.convertStringToBigDecimal(strSeq));			
			ye167010Vo.setFormCd(strFormCd); 			
			ye167010Vo.setFileAppYn("N");
			
			ye167010Vo.setFileSbtYn("Y");
			ye167010Vo.setKybdr(sessionUser.getUsrId());
			ye167010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			ye167010Vo.setIsmt(sessionUser.getUsrId());
			ye167010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			yetaPayr3200Service.yeta6200_PDF_YE167010_2021_Insert(ye167010Vo);	//기본정보 입력
			
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");

			//상품별 반복구간
			for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
				System.out.println("길이 :" + subXmlElChildMan.getLength());
				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				
				//
				strSuptFmlyRltClCd = subXmlElData.getAttribute("suptFmlyRltClCd"); 
				strNpHthrWaInfeeAmt = subXmlElData.getAttribute("npHthrWaInfeeAmt");
				strHthrHifeAmt = subXmlElData.getAttribute("hthrHifeAmt");
				strYr2000BefNtplPnsnSvngUseAmt = subXmlElData.getAttribute("yr2000BefNtplPnsnSvngUseAmt");
				strTchIntdCtrYn = subXmlElData.getAttribute("tchIntdCtrYn");
				strBrwOrgnBrwnHsngTennLnpbSrmNtsAmt = subXmlElData.getAttribute("brwOrgnBrwnHsngTennLnpbSrmNtsAmt");
				
				//인적 공제 및 소득 세액 공제 명세별 반복 구간
				if (strSuptFmlyRltClCd.equals("0")) { //소득자 본인	
					setYe167020Vo(ye167020Vo, request);
					setYe167030Vo(ye167030Vo, request);
				}
				else if (strSuptFmlyRltClCd.equals("1")) { //소득자의 직계존속
					setYe167020Vo(ye167020Vo, request);
					setYe167030Vo(ye167030Vo, request);
				}
				else if (strSuptFmlyRltClCd.equals("2")) { //배우자의 직계존속
					setYe167020Vo(ye167020Vo, request);
					setYe167030Vo(ye167030Vo, request);
				}
				else if (strSuptFmlyRltClCd.equals("3")) { //배우자
					setYe167020Vo(ye167020Vo, request);
					setYe167030Vo(ye167030Vo, request);
				}
				else if (strSuptFmlyRltClCd.equals("4")) { //직계비속(자녀,입양자)
					setYe167020Vo(ye167020Vo, request);
					setYe167030Vo(ye167030Vo, request);
				}
				else if (strSuptFmlyRltClCd.equals("5")) { //직계비속(자녀,입양자 제외)
					setYe167020Vo(ye167020Vo, request);
					setYe167030Vo(ye167030Vo, request);
				}
				else if (strSuptFmlyRltClCd.equals("6")) { //형제자매
					setYe167020Vo(ye167020Vo, request);
					setYe167030Vo(ye167030Vo, request);
				}
				else if (strSuptFmlyRltClCd.equals("7")) { //수급자
					setYe167020Vo(ye167020Vo, request);
					setYe167030Vo(ye167030Vo, request);
				}
				else if (strSuptFmlyRltClCd.equals("8")) { //위탁아동
					setYe167020Vo(ye167020Vo, request);
					setYe167030Vo(ye167030Vo, request);
				}
				//연금 보험료별 반복 구간 
				else if (!strNpHthrWaInfeeAmt.equals("")){	
					setYe167040Vo(ye167040Vo, request);
				}
				//특별 소득 공제별 반복 구간
				else if (!strHthrHifeAmt.equals("")){	
					setYe167050Vo(ye167050Vo, request);
				}
				//그 밖의 소득 공제별 반복 구간
				else if (!strYr2000BefNtplPnsnSvngUseAmt.equals("")){	
					setYe167060Vo(ye167060Vo, request);
				}
				//세액 감면 및 공제별 반복 구간	
				else if (!strTchIntdCtrYn.equals("")){		
					setYe167070Vo(ye167070Vo, request);		
				}
				// 국세청, 기타자료 항목구분 개별 반복 구간
				else if (!strBrwOrgnBrwnHsngTennLnpbSrmNtsAmt.equals("")) {
					setYe167530Vo(ye167530Vo, request);
				}
				
			}

		}

	}
	
	public static void setYe167020Vo(InfcPkgYe167020_2021_VO ye167020Vo , HttpServletRequest request) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167020Vo.setCdVvalKrnNm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("cdVvalKrnNm")));
		ye167020Vo.setSuptFmlyRltClCd(strSuptFmlyRltClCd);
		ye167020Vo.setNnfClCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("nnfClCd")));
		ye167020Vo.setChild(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("child"),"0")));
		ye167020Vo.setTxprNm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("txprNm")));
		ye167020Vo.setTxprDscmNoCntn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("txprDscmNoCntn")));
		ye167020Vo.setBscDdcClCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("bscDdcClCd")));
		ye167020Vo.setWmnDdcClCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("wmnDdcClCd")));
		ye167020Vo.setSnprntFmlyDdcClCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("snprntFmlyDdcClCd")));
		ye167020Vo.setSccDdcClCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("sccDdcClCd")));
		ye167020Vo.setDsbrDdcClCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("dsbrDdcClCd")));
		ye167020Vo.setChbtAtprDdcClCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("chbtAtprDdcClCd")));
		//ye167020Vo.setAge6Lt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("age6Lt")));
		ye167020Vo.setSchool_Yn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("schoolYn")));
		
		ye167020Vo.setKybdr(sessionUser.getUsrId());
		ye167020Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167020Vo.setIsmt(sessionUser.getUsrId());
		ye167020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta6200_PDF_YE167020_2021_Insert(ye167020Vo);	//인적공제 입력

	}
	
	public static void setYe167030Vo(InfcPkgYe167030_2021_VO ye167030Vo , HttpServletRequest request) throws Exception{
		
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			
			yetaPayr3200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167030Vo.setCdVvalKrnNm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("cdVvalKrnNm")));
		ye167030Vo.setTxprDscmNoCntn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("txprDscmNoCntn")));
		ye167030Vo.setHifeDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hifeDdcTrgtAmt"),"0")));
		ye167030Vo.setCvrgInscDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("cvrgInscDdcTrgtAmt"),"0")));
		ye167030Vo.setDsbrDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("dsbrDdcTrgtAmt"),"0")));
		
		ye167030Vo.setMdxpsDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsDdcTrgtAmt"),"0")));
		ye167030Vo.setScxpsDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsDdcTrgtAmt"),"0")));
		ye167030Vo.setCrdcDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("crdcDdcTrgtAmt"),"0")));
		ye167030Vo.setDrtpCardDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("drtpCardDdcTrgtAmt"),"0")));
		ye167030Vo.setCshptDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("cshptDdcTrgtAmt"),"0")));
		
		ye167030Vo.setTdmrDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("tdmrDdcTrgtAmt"),"0")));
		ye167030Vo.setPbtDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pbtDdcTrgtAmt"),"0")));
		ye167030Vo.setBookShowAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("bookShowAmt"),"0")));
		ye167030Vo.setConbDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbDdcTrgtAmt"),"0")));
		
		ye167030Vo.setKybdr(sessionUser.getUsrId());
		ye167030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167030Vo.setIsmt(sessionUser.getUsrId());
		ye167030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta6200_PDF_YE167030_2021_Insert(ye167030Vo);	//인적공제 입력
		
	}
	
	public static void setYe167040Vo(InfcPkgYe167040_2021_VO ye167040Vo , HttpServletRequest request) throws Exception{
		
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			
			yetaPayr3200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167040Vo.setNpHthrWaInfeeAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("npHthrWaInfeeAmt"),"0")));
		ye167040Vo.setNpHthrWaInfeeDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("npHthrWaInfeeDdcAmt"),"0")));
		ye167040Vo.setNpHthrMcurWkarInfeeAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("npHthrMcurWkarInfeeAmt"),"0")));
		ye167040Vo.setNpHthrMcurWkarDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("npHthrMcurWkarDdcAmt"),"0")));
		ye167040Vo.setHthrPblcPnsnInfeeAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hthrPblcPnsnInfeeAmt"),"0")));
		ye167040Vo.setHthrPblcPnsnInfeeDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hthrPblcPnsnInfeeDdcAmt"),"0")));
		ye167040Vo.setMcurPblcPnsnInfeeAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mcurPblcPnsnInfeeAmt"),"0")));
		ye167040Vo.setMcurPblcPnsnInfeeDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mcurPblcPnsnInfeeDdcAmt"),"0")));
		ye167040Vo.setPnsnInfeeUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pnsnInfeeUseAmtSum"),"0")));
		ye167040Vo.setPnsnInfeeDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pnsnInfeeDdcAmtSum"),"0")));
		
		ye167040Vo.setKybdr(sessionUser.getUsrId());
		ye167040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167040Vo.setIsmt(sessionUser.getUsrId());
		ye167040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

		yetaPayr3200Service.yeta6200_PDF_YE167040_2021_Insert(ye167040Vo);	//연금 보험 입력
		
	}
	
	public static void setYe167050Vo(InfcPkgYe167050_2021_VO ye167050Vo , HttpServletRequest request) throws Exception{
		
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			
			yetaPayr3200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167050Vo.setHthrHifeAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hthrHifeAmt"),"0")));
		ye167050Vo.setHthrHifeDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hthrHifeDdcAmt"),"0")));
		ye167050Vo.setMcurHifeAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mcurHifeAmt"),"0")));
		ye167050Vo.setMcurHifeDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mcurHifeDdcAmt"),"0")));
		ye167050Vo.setHthrUiAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hthrUiAmt"),"0")));
		
		ye167050Vo.setHthrUiDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hthrUiDdcAmt"),"0")));
		ye167050Vo.setMcurUiAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mcurUiAmt"),"0")));
		ye167050Vo.setMcurUiDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mcurUiDdcAmt"),"0")));
		ye167050Vo.setInfeeUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("infeeUseAmtSum"),"0")));
		ye167050Vo.setInfeeDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("infeeDdcAmtSum"),"0")));
		
		ye167050Vo.setBrwLnpbSrmAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("brwOrgnBrwnHsngTennLnpbSrmAmt"),"0")));
		ye167050Vo.setBrwLnpbSrmDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("brwOrgnBrwnHsngTennLnpbSrmDdcAmt"),"0")));
		ye167050Vo.setRsdtLnpbSrmAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("rsdtBrwnHsngTennLnpbSrmAmt"),"0")));
		ye167050Vo.setRsdtLnpbSrmDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("rsdtBrwnHsngTennLnpbSrmDdcAmt"),"0")));
		ye167050Vo.setLthYr15BlwItrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr15BlwItrAmt"),"0")));
		
		ye167050Vo.setLthYr15BlwDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr15BlwDdcAmt"),"0")));
		ye167050Vo.setLthYr29ItrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr29ItrAmt"),"0")));
		ye167050Vo.setLthYr29DdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr29DdcAmt"),"0")));
		ye167050Vo.setLthY30OverItrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbY30OverItrAmt"),"0")));
		ye167050Vo.setLthY30OverDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbY30OverDdcAmt"),"0")));
		
		ye167050Vo.setLthYr2012AfthY15Amt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2012AfthY15OverItrAmt"),"0")));
		ye167050Vo.setLthYr2012AfthY15DdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2012AfthY15OverDdcAmt"),"0")));
		ye167050Vo.setLthYr2012EtcBrwItrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2012EtcBrwItrAmt"),"0")));
		ye167050Vo.setLthYr2012EtcBrwDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2012EtcBrwDdcAmt"),"0")));		
		ye167050Vo.setLthYr2015AfthFxnIrItrAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthFxnIrItrAmt"),"0")));
		
		ye167050Vo.setLthYr2015AfthFxnIrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthY15OverDdcAmtDdcAmt"),"0")));		
		ye167050Vo.setLthYr2015AfthEtcDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthFxnIrDdcAmt"),"0")));
		ye167050Vo.setLthYr2015AfthY15Amt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthY15OverItrAmtItrAmt"),"0")));
		ye167050Vo.setLthYr2015AfthY15DdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthY15OverDdcAmtDdcAmt"),"0")));
		ye167050Vo.setLthYr2015AfthEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthEtcBrwItrAmt"),"0")));
		
		ye167050Vo.setLthYr2015AfthEtcDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthEtcBrwDdcAmt"),"0")));		
		ye167050Vo.setLthYr2015AfthYr15Amt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthYr15BlwItrAmt"),"0")));
		ye167050Vo.setLthYr2015AfthYr15DdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthYr15BlwDdcAmt"),"0")));
		ye167050Vo.setHsngFndsDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hsngFndsDdcAmtSum"),"0")));
		ye167050Vo.setConbReliOrgOthUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtReliOrgOthUseAmt"),"0")));
		
		ye167050Vo.setConbReliOrgOthDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtReliOrgOthDdcAmt"),"0")));		
		ye167050Vo.setConbReliOrgUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtReliOrgUseAmt"),"0")));
		ye167050Vo.setConbReliOrgDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtReliOrgDdcAmt"),"0")));
		ye167050Vo.setConbUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtUseAmtSum"),"0")));
		ye167050Vo.setConbDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtDdcAmtSum"),"0")));
		
		ye167050Vo.setKybdr(sessionUser.getUsrId());
		ye167050Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167050Vo.setIsmt(sessionUser.getUsrId());
		ye167050Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta6200_PDF_YE167050_2021_Insert(ye167050Vo);	//특별공제 입력
		
	}
	
	public static void setYe167060Vo(InfcPkgYe167060_2021_VO ye167060Vo , HttpServletRequest request) throws Exception{
		
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			
			yetaPayr3200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167060Vo.setYr2000PnsnSvngUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("yr2000BefNtplPnsnSvngUseAmt"),"0")));
		ye167060Vo.setYr2000PnsnSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("yr2000BefNtplPnsnSvngDdcAmt"),"0")));
		ye167060Vo.setSmceSbizUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("smceSbizUseAmt"),"0")));
		ye167060Vo.setSmceSbizDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("smceSbizDdcAmt"),"0")));
		ye167060Vo.setSbcSvngUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("sbcSvngUseAmt"),"0")));
		
		ye167060Vo.setSbcSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("sbcSvngDdcAmt"),"0")));
		ye167060Vo.setLbrrPrptSvngUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lbrrHsngPrptSvngUseAmt"),"0")));
		ye167060Vo.setLbrrPrptSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lbrrHsngPrptSvngDdcAmt"),"0")));
		ye167060Vo.setHsngSvngUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hsngSbcSynSvngUseAmt"),"0")));
		ye167060Vo.setHsngSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hsngSbcSynSvngDdcAmt"),"0")));
		
		ye167060Vo.setHsngIncUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hsngPrptSvngIncUseAmtSum"),"0")));
		ye167060Vo.setHsngIncDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hsngPrptSvngIncDdcAmtSum"),"0")));
		ye167060Vo.setCpivAsctUseAmt2(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ftyrCpivAsctUseAmt"),"0")));	//ftyrCpivAsctUseAmt
		ye167060Vo.setCpivAsctDdcAmt2(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ftyrCpivAsctDdcAmt"),"0")));	//ftyrCpivAsctDdcAmt
		ye167060Vo.setCpivVntUseAmt2(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ftyrCpivVntUseAmt"),"0")));	//ftyrCpivVntUseAmt
		
		ye167060Vo.setCpivVntDdcAmt2(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ftyrCpivVntDdcAmt"),"0")));	//ftyrCpivVntDdcAmt
		ye167060Vo.setCpivAsctUseAmt1(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pyrCpivAsctUseAmt"),"0")));	//pyrCpivAsctUseAmt
		ye167060Vo.setCpivAsctDdcAmt1(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pyrCpivAsctDdcAmt"),"0")));	//pyrCpivAsctDdcAmt
		ye167060Vo.setCpivVntUseAmt1(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pyrCpivVntUseAmt"),"0")));		//pyrCpivVntUseAmt
		ye167060Vo.setCpivVntDdcAmt1(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pyrCpivVntDdcAmt"),"0")));		//pyrCpivVntDdcAmt
		
		ye167060Vo.setCpivAsctUseAmt0(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("tyCpivAsctUseAmt"),"0")));	//tyCpivAsctUseAmt
		ye167060Vo.setCpivAsctDdcAmt0(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("tyCpivAsctDdcAmt"),"0")));	//tyCpivAsctDdcAmt
		ye167060Vo.setCpivVntUseAmt0(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("tyCpivVntUseAmt"),"0")));		//tyCpivVntUseAmt
		ye167060Vo.setCpivVntDdcAmt0(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("tyCpivVntDdcAmt"),"0")));		//tyCpivVntDdcAmt
		ye167060Vo.setIvcpInvmUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ivcpInvmUseAmtSum"),"0")));
		
		ye167060Vo.setIvcpInvmDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ivcpInvmDdcAmtSum"),"0")));
		ye167060Vo.setCrdcUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("crdcUseAmt"),"0")));
		ye167060Vo.setDrtpCardUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("drtpCardUseAmt"),"0")));
		ye167060Vo.setCshptUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("cshptUseAmt"),"0")));
		ye167060Vo.setTdmrUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("tdmrUseAmt"),"0")));
		
		ye167060Vo.setPbtUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pbtUseAmt"),"0")));
		ye167060Vo.setBookShowAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("bookShowAmt"),"0")));
		ye167060Vo.setCrdcSumUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("crdcSumUseAmt"),"0")));
		ye167060Vo.setCrdcSumDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("crdcSumDdcAmt"),"0")));
		ye167060Vo.setEmstAsctCntrUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("emstAsctCntrUseAmt"),"0")));
		ye167060Vo.setEmstAsctCntrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("emstAsctCntrDdcAmt"),"0")));
		
		ye167060Vo.setEmpMntnSnmcUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("empMntnSnmcLbrrUseAmt"),"0")));
		ye167060Vo.setEmpMntnSnmcDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("empMntnSnmcLbrrDdcAmt"),"0")));
		ye167060Vo.setLtrmCniSsUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ltrmCniSsUseAmt"),"0")));
		ye167060Vo.setLtrmCniSsDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ltrmCniSsDdcAmt"),"0")));
		
		ye167060Vo.setKybdr(sessionUser.getUsrId());
		ye167060Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167060Vo.setIsmt(sessionUser.getUsrId());
		ye167060Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta6200_PDF_YE167060_2021_Insert(ye167060Vo);	//그 밖의 소득 공제 입력
		
	}
	
	public static void setYe167070Vo(InfcPkgYe167070_2021_VO ye167070Vo , HttpServletRequest request) throws Exception{
		
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			
			yetaPayr3200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167070Vo.setFrgrLbrrEntcPupCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("frgrLbrrEntcPupCd")));
		
		ye167070Vo.setTchIntdCtrYn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("tchIntdCtrYn")));
		ye167070Vo.setGvrnAgmnYn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("gvrnAgmnYn")));
		ye167070Vo.setStclReYn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("stclReYn")));
		ye167070Vo.setTxaTraReYn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("txaTraReYn")));
		ye167070Vo.setFrgrLbrrLbrOfrDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("frgrLbrrLbrOfrDt")));
		
		ye167070Vo.setFrgrLbrrReExryDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("frgrLbrrReExryDt")));
		ye167070Vo.setFrgrLbrrReRcpnDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("frgrLbrrReRcpnDt")));
		ye167070Vo.setFrgrLbrrReAlfaSbmsDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("frgrLbrrReAlfaSbmsDt")));
		ye167070Vo.setFrgrLbrrErinImnRcpnDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("frgrLbrrErinImnRcpnDt")));
		ye167070Vo.setFrgrLbrrErinImnSbmsDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("frgrLbrrErinImnSbmsDt")));
		
		ye167070Vo.setYupSnmcReStrtDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("yupSnmcReStrtDt")));
		ye167070Vo.setYupSnmcReEndDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("yupSnmcReEndDt")));
		ye167070Vo.setSctcHpUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("sctcHpUseAmt"),"0")));
		ye167070Vo.setSctcHpDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("sctcHpDdcTrgtAmt"),"0")));
		ye167070Vo.setSctcHpDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("sctcHpDdcAmt"),"0")));
		
		ye167070Vo.setRtpnUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("rtpnUseAmt"),"0")));
		ye167070Vo.setRtpnDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("rtpnDdcTrgtAmt"),"0")));
		ye167070Vo.setRtpnDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("rtpnDdcAmt"),"0")));
		ye167070Vo.setPnsnSvngUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pnsnSvngUseAmt"),"0")));
		ye167070Vo.setPnsnSvngDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pnsnSvngDdcTrgtAmt"),"0")));
		
		ye167070Vo.setPnsnSvngDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pnsnSvngDdcAmt"),"0")));
		ye167070Vo.setPnsnAccUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pnsnAccUseAmtSum"),"0")));
		ye167070Vo.setPnsnAccDdcTrgtAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pnsnAccDdcTrgtAmtSum"),"0")));
		ye167070Vo.setPnsnAccDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pnsnAccDdcAmtSum"),"0")));
		ye167070Vo.setCvrgInscUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("cvrgInscUseAmt"),"0")));
		
		ye167070Vo.setCvrgInscDdcTrgtAmt2(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("cvrgInscDdcTrgtAmt2"),"0")));
		ye167070Vo.setCvrgInscDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("cvrgInscDdcAmt"),"0")));
		ye167070Vo.setDsbrEuCvrgUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("dsbrEuCvrgUseAmt"),"0")));
		ye167070Vo.setDsbrEuCvrgDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("dsbrEuCvrgDdcTrgtAmt"),"0")));
		ye167070Vo.setDsbrEuCvrgDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("dsbrEuCvrgDdcAmt"),"0")));
		
		ye167070Vo.setInfeePymUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("infeePymUseAmtSum"),"0")));
		ye167070Vo.setInfeePymDdcTrgtAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("infeePymDdcTrgtAmtSum"),"0")));
		ye167070Vo.setInfeePymDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("infeePymDdcAmtSum"),"0")));
		ye167070Vo.setMdxpsSftXpnsUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsSftSprcdXpnsUseAmt"),"0")));
		ye167070Vo.setMdxpsSftXpnsDdctgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsSftSprcdXpnsDdcTrgtAmt"),"0")));
		
		ye167070Vo.setMdxpsSftXpnsDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsSftSprcdXpnsDdcAmt"),"0")));
		ye167070Vo.setMdxpsPrsUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsPrsUseAmt"),"0")));
		ye167070Vo.setMdxpsPrsDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsPrsDdcTrgtAmt"),"0")));
		ye167070Vo.setMdxpsPrsDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsPrsDdcAmt"),"0")));
		ye167070Vo.setMdxpsOthUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsOthUseAmt"),"0")));
		
		ye167070Vo.setMdxpsOthDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsOthDdcTrgtAmt"),"0")));
		ye167070Vo.setMdxpsOthDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsOthDdcAmt"),"0")));
		ye167070Vo.setMdxpsUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsUseAmtSum"),"0")));
		ye167070Vo.setMdxpsDdcTrgtAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsDdcTrgtAmtSum"),"0")));
		ye167070Vo.setMdxpsDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsDdcAmtSum"),"0")));
		
		ye167070Vo.setScxpsPrsUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsPrsUseAmt"),"0")));
		ye167070Vo.setScxpsPrsDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsPrsDdcTrgtAmt"),"0")));
		ye167070Vo.setScxpsPrsDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsPrsDdcAmt"),"0")));
		ye167070Vo.setScxpsKidUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsKidUseAmt"),"0")));
		ye167070Vo.setScxpsKidDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsKidDdcTrgtAmt"),"0")));
		
		ye167070Vo.setScxpsKidDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsKidDdcAmt"),"0")));
		ye167070Vo.setScxpsStdUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsStdUseAmt"),"0")));
		ye167070Vo.setScxpsStdDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsStdDdcTrgtAmt"),"0")));
		ye167070Vo.setScxpsStdDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsStdDdcAmt"),"0")));
		ye167070Vo.setScxpsUndUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsUndUseAmt"),"0")));
		
		ye167070Vo.setScxpsUndDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsUndDdcTrgtAmt"),"0")));
		ye167070Vo.setScxpsUndDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsUndDdcAmt"),"0")));
		ye167070Vo.setScxpsDsbrUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsDsbrUseAmt"),"0")));
		ye167070Vo.setScxpsDsbrDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsDsbrDdcTrgtAmt"),"0")));
		ye167070Vo.setScxpsDsbrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsDsbrDdcAmt"),"0")));
		
		ye167070Vo.setScxpsKidCount(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsKidCount"),"0")));
		ye167070Vo.setScxpsStdCount(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsStdCount"),"0")));
		ye167070Vo.setScxpsUndCount(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsUndCount"),"0")));
		ye167070Vo.setScxpsDsbrCount(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsDsbrCount"),"0")));
		ye167070Vo.setScxpsUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsUseAmtSum"),"0")));
		
		ye167070Vo.setScxpsDdcTrgtAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsDdcTrgtAmtSum"),"0")));
		ye167070Vo.setScxpsDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsDdcAmtSum"),"0")));
		ye167070Vo.setConb10ttswLtUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conb10ttswLtUseAmt"),"0")));
		ye167070Vo.setConb10ttswLtDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conb10ttswLtDdcTrgtAmt"),"0")));
		ye167070Vo.setConb10ttswLtDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conb10ttswLtDdcAmt"),"0")));
		
		ye167070Vo.setConb10excsLtUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conb10excsLtUseAmt"),"0")));
		ye167070Vo.setConb10excsLtDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conb10excsLtDdcTrgtAmt"),"0")));
		ye167070Vo.setConb10excsLtDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conb10excsLtDdcAmt"),"0")));
		ye167070Vo.setConbLglUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbLglUseAmt"),"0")));
		ye167070Vo.setConbLglDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbLglDdcTrgtAmt"),"0")));
		
		ye167070Vo.setConbLglDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbLglDdcAmt"),"0")));
		ye167070Vo.setConbEmstAsctUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbEmstAsctUseAmt"),"0")));
		ye167070Vo.setConbEmstAsctDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbEmstAsctDdcTrgtAmt"),"0")));
		ye167070Vo.setConbEmstAsctDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbEmstAsctDdcAmt"),"0")));
		ye167070Vo.setConbReliOrgOthUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbReliOrgOthAppnUseAmt"),"0")));
		
		ye167070Vo.setConbReliOrgOthDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbReliOrgOthAppnDdcTrgtAmt"),"0")));
		ye167070Vo.setConbReliOrgOthDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbReliOrgOthAppnDdcAmt"),"0")));
		ye167070Vo.setConbReliOrgUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbReliOrgAppnUseAmt"),"0")));
		ye167070Vo.setConbReliOrgDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbReliOrgAppnDdcTrgtAmt"),"0")));
		ye167070Vo.setConbReliOrgDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbReliOrgAppnDdcAmt"),"0")));

		ye167070Vo.setConbUseAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbUseAmtSum"),"0")));
		ye167070Vo.setConbDdcTrgtAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbDdcTrgtAmtSum"),"0")));
		ye167070Vo.setConbDdcAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbDdcAmtSum"),"0")));
		ye167070Vo.setOvrsSurcIncFmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ovrsSurcIncFmt"),"0")));
		ye167070Vo.setFrgnPmtFcTxamt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("frgnPmtFcTxamt"),"0")));
		
		ye167070Vo.setFrgnPmtWcTxamt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("frgnPmtWcTxamt"),"0")));
		ye167070Vo.setFrgnPmtTxamtTxpNtnNm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("frgnPmtTxamtTxpNtnNm")));
		ye167070Vo.setFrgnPmtTxamtPmtDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("frgnPmtTxamtPmtDt")));
		ye167070Vo.setFrgnPmtTxamtAlfaSbmsDt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("frgnPmtTxamtAlfaSbmsDt")));
		ye167070Vo.setFrgnPmtTxamtAbrdWkarNm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("frgnPmtTxamtAbrdWkarNm")));
		
		ye167070Vo.setFrgnDtyTerm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("frgnDtyTerm")));
		ye167070Vo.setFrgnPmtTxamtRfoNm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("frgnPmtTxamtRfoNm")));
		ye167070Vo.setHsngTennLnpbUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hsngTennLnpbUseAmt"),"0")));
		ye167070Vo.setHsngTennLnpbDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hsngTennLnpbDdcAmt"),"0")));
		ye167070Vo.setMmrUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mmrUseAmt"),"0")));
		
		ye167070Vo.setMmrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mmrDdcAmt"),"0")));
		ye167070Vo.setCd218(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("cd218")));
		ye167070Vo.setCd219(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("cd219")));
		ye167070Vo.setCd220(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("cd220")));
		ye167070Vo.setCd221(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("cd221"),"0")));
		
		ye167070Vo.setCd222(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("cd222")));
		ye167070Vo.setCd223(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("cd223"),"0")));
		ye167070Vo.setPrcspWorkIncmSumtYn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("cd224")));	//cd224
		ye167070Vo.setCd225(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("cd225")));
		ye167070Vo.setCd226(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("cd226")));
		
		ye167070Vo.setCd227(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("cd227")));
		ye167070Vo.setCd228(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("cd228")));
		
		ye167070Vo.setKybdr(sessionUser.getUsrId());
		ye167070Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167070Vo.setIsmt(sessionUser.getUsrId());
		ye167070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta6200_PDF_YE167070_2021_Insert(ye167070Vo);	//세액 감면 및 공제 입력
	}
	
	public static void setYe167530Vo(InfcPkgYe167530_2021_VO ye167530Vo , HttpServletRequest request) throws Exception{
		
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			
			yetaPayr3200Service = (Yeta6200XmlService) wac.getBean("Yeta6200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		

		ye167530Vo.setTxprNm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("txprNm")));
		ye167530Vo.setTxprDscmNoCntn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("txprDscmNoCntn")));
		ye167530Vo.setBrwLnpbNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("brwOrgnBrwnHsngTennLnpbSrmNtsAmt"),"0")));
		ye167530Vo.setBrwLnpbEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("brwOrgnBrwnHsngTennLnpbSrmEtcAmt"),"0")));
		ye167530Vo.setRsdtLnpbNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("rsdtBrwnHsngTennLnpbSrmNtsAmt"),"0")));
		
		ye167530Vo.setRsdtLnpbEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("rsdtBrwnHsngTennLnpbSrmEtcAmt"),"0")));
		ye167530Vo.setLthYr15BlwNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr15BlwItrNtsAmt"),"0")));
		ye167530Vo.setLthYr15BlwEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr15BlwItrEtcAmt"),"0")));
		ye167530Vo.setLthYr29ItrNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr29ItrNtsAmt"),"0")));
		ye167530Vo.setLthYr29ItrEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr29ItrEtcAmt"),"0")));
		
		ye167530Vo.setLthY30OverItrNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbY30OverItrNtsAmt"),"0")));
		ye167530Vo.setLthY30OverItrEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbY30OverItrEtcAmt"),"0")));
		ye167530Vo.setLthYr12AfthY15NtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2012AfthY15OverItrNtsAmt"),"0")));
		ye167530Vo.setLthYr12AfthY15EtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2012AfthY15OverItrEtcAmt"),"0")));
		ye167530Vo.setLthYr12EtcBrwNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2012EtcBrwItrNtsAmt"),"0")));
		
		ye167530Vo.setLthYr12EtcBrwEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2012EtcBrwItrEtcAmt"),"0")));
		ye167530Vo.setLthYr15AfthFxnIrNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthFxnIrItrNtsAmt"),"0")));
		ye167530Vo.setLthYr2015AfthFxnIrEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthFxnIrItrEtcAmt"),"0")));
		ye167530Vo.setLthYr15AfthY15NtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthY15OverItrAmtItrNtsAmt"),"0")));
		ye167530Vo.setLthYr15AfthY15EtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthY15OverItrAmtItrEtcAmt"),"0")));
		
		
		ye167530Vo.setLthYr15AfthEtcNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthEtcBrwItrNtsAmt"),"0")));
		ye167530Vo.setLthYr15AfthEtcEtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthEtcBrwItrEtcAmt"),"0")));
		ye167530Vo.setLthYr15AfthYr15NtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthYr15BlwItrNtsAmt"),"0")));
		ye167530Vo.setLthYr15AfthYr15EtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lthClrlLnpbYr2015AfthYr15BlwItrEtcAmt"),"0")));
		ye167530Vo.setYr2000PnsnSvngNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("yr2000BefNtplPnsnSvngUseNtsAmt"),"0")));
		
		ye167530Vo.setYr2000PnsnSvngEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("yr2000BefNtplPnsnSvngUseEtcAmt"),"0")));
		ye167530Vo.setSmceSbizNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("smceSbizUseNtsAmt"),"0")));
		ye167530Vo.setSmceSbizEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("smceSbizUseEtcAmt"),"0")));
		ye167530Vo.setSbcSvngNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("sbcSvngUseNtsAmt"),"0")));
		ye167530Vo.setSbcSvngEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("sbcSvngUseEtcAmt"),"0")));
		
		ye167530Vo.setLbrrPrptSvngNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lbrrHsngPrptSvngUseNtsAmt"),"0")));
		ye167530Vo.setLbrrPrptSvngEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("lbrrHsngPrptSvngUseEtcAmt"),"0")));
		ye167530Vo.setHsngSvngNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hsngSbcSynSvngUseNtsAmt"),"0")));
		ye167530Vo.setHsngSvngEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("hsngSbcSynSvngUseEtcAmt"),"0")));
		ye167530Vo.setCrdcUseNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("crdcUseNtsAmt"),"0")));
		
		ye167530Vo.setCrdcUseEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("crdcUseEtcAmt"),"0")));
		ye167530Vo.setDrtpCardUseNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("drtpCardUseNtsAmt"),"0")));
		ye167530Vo.setDrtpCardUseEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("drtpCardUseEtcAmt"),"0")));
		ye167530Vo.setTdmrUseNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("tdmrUseNtsAmt"),"0")));
		ye167530Vo.setTdmrUseEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("tdmrUseEtcAmt"),"0")));
		
		ye167530Vo.setPbtUseNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pbtUseNtsAmt"),"0")));
		ye167530Vo.setPbtUseEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pbtUseEtcAmt"),"0")));
		ye167530Vo.setSctcHpUseNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("sctcHpUseNtsAmt"),"0")));
		ye167530Vo.setSctcHpUseEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("sctcHpUseEtcAmt"),"0")));
		ye167530Vo.setRtpnUseNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("rtpnUseNtsAmt"),"0")));
		
		ye167530Vo.setRtpnUseEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("rtpnUseEtcAmt"),"0")));
		ye167530Vo.setPnsnSvngUseNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pnsnSvngUseNtsAmt"),"0")));
		ye167530Vo.setPnsnSvngUseEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pnsnSvngUseEtcAmt"),"0")));
		ye167530Vo.setCvrgInscUseNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("cvrgInscUseNtsAmt"),"0")));
		ye167530Vo.setCvrgInscUseEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("cvrgInscUseEtcAmt"),"0")));
		
		ye167530Vo.setDsbrEuCvrgNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("dsbrEuCvrgUseNtsAmt"),"0")));
		ye167530Vo.setDsbrEuCvrgEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("dsbrEuCvrgUseEtcAmt"),"0")));
		ye167530Vo.setMdxpsPrsNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsPrsUseNtsAmt"),"0")));
		ye167530Vo.setMdxpsPrsEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsPrsUseEtcAmt"),"0")));
		ye167530Vo.setMdxpsSftXpnsNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsSftSprcdXpnsNtsAmt"),"0")));
		
		ye167530Vo.setMdxpsSftXpnsEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsSftSprcdXpnsEtcAmt"),"0")));
		ye167530Vo.setMdxpsOthNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsOthUseNtsAmt"),"0")));
		ye167530Vo.setMdxpsOthEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("mdxpsOthUseEtcAmt"),"0")));
		ye167530Vo.setGlssPrchNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("glssPrchNtsAmt"),"0")));
		ye167530Vo.setGlssPrchEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("glssPrchEtcAmt"),"0")));
		
		ye167530Vo.setScxpsPrsNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsPrsUseNtsAmt"),"0")));
		ye167530Vo.setScxpsPrsEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsPrsUseEtcAmt"),"0")));
		ye167530Vo.setScxpsKidNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsKidUseNtsAmt"),"0")));
		ye167530Vo.setScxpsKidEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsKidUseEtcAmt"),"0")));
		ye167530Vo.setScxpsStdNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsStdUseNtsAmt"),"0")));
		
		ye167530Vo.setScxpsStdEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsStdUseEtcAmt"),"0")));
		ye167530Vo.setShufPrchNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("shufPrchUseNtsAmt"),"0")));
		ye167530Vo.setShufPrchEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("shufPrchUseEtcAmt"),"0")));
		ye167530Vo.setExprnStudNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("exprnStudUseNtsAmt"),"0")));
		ye167530Vo.setExprnStudEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("exprnStudUseEtcAmt"),"0")));
		
		ye167530Vo.setScxpsUndNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsUndUseNtsAmt"),"0")));
		ye167530Vo.setScxpsUndEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsUndUseEtcAmt"),"0")));
		ye167530Vo.setScxpsDsbrNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsDsbrUseNtsAmt"),"0")));
		ye167530Vo.setScxpsDsbrEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("scxpsDsbrUseEtcAmt"),"0")));
		ye167530Vo.setConb10ttswLtNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbPltcFndsUseNtsAmt"),"0")));
		
		ye167530Vo.setConb10ttswLtEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbPltcFndsUseEtcAmt"),"0")));
		ye167530Vo.setConbLglNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbLglUseNtsAmt"),"0")));
		ye167530Vo.setConbLglEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbLglUseEtcAmt"),"0")));
		ye167530Vo.setConbEmstAsctNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbEmstAsctUseNtsAmt"),"0")));
		ye167530Vo.setConbEmstAsctEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbEmstAsctUseEtcAmt"),"0")));
		
		ye167530Vo.setConbReliOrgNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbReliOrgAppnUseNtsAmt"),"0")));
		ye167530Vo.setConbReliOrgEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbReliOrgAppnUseEtcAmt"),"0")));
		ye167530Vo.setConbReliOrgOthNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbReliOrgOthAppnUseNtsAmt"),"0")));
		ye167530Vo.setConbReliOrgOthEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbReliOrgOthAppnUseEtcAmt"),"0")));
		ye167530Vo.setConb1LglNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef1AttrYrLglUseNtsAmt"),"0")));
		
		ye167530Vo.setConb1LglEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef1AttrYrLglUseEtcAmt"),"0")));
		ye167530Vo.setConb1ReliOrgNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef1AttrYrReliOrgUseNtsAmt"),"0")));
		ye167530Vo.setConb1ReliOrgEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef1AttrYrReliOrgUseEtcAmt"),"0")));
		ye167530Vo.setConb1ReliOrgOthNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef1AttrYrReliOrgOthUseNtsAmt"),"0")));
		ye167530Vo.setConb1ReliOrgOthEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef1AttrYrReliOrgOthUseEtcAmt"),"0")));
		
		ye167530Vo.setConb2LglNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef2AttrYrLglUseNtsAmt"),"0")));
		ye167530Vo.setConb2LglEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef2AttrYrLglUseEtcAmt"),"0")));
		ye167530Vo.setConb2ReliOrgNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef2AttrYrReliOrgUseNtsAmt"),"0")));
		ye167530Vo.setConb2ReliOrgEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef2AttrYrReliOrgUseEtcAmt"),"0")));
		ye167530Vo.setConb2ReliOrgOthNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef2AttrYrReliOrgOthUseNtsAmt"),"0")));
		
		ye167530Vo.setConb2ReliOrgOthEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef2AttrYrReliOrgOthUseEtcAmt"),"0")));		
		ye167530Vo.setConb3LglNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef3AttrYrLglUseNtsAmt"),"0")));
		ye167530Vo.setConb3LglEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef3AttrYrLglUseEtcAmt"),"0")));
		ye167530Vo.setConb3ReliOrgNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef3AttrYrReliOrgUseNtsAmt"),"0")));
		ye167530Vo.setConb3ReliOrgEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef3AttrYrReliOrgUseEtcAmt"),"0")));
		
		ye167530Vo.setConb3ReliOrgOthNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef3AttrYrReliOrgOthUseNtsAmt"),"0")));
		ye167530Vo.setConb3ReliOrgOthEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef3AttrYrReliOrgOthUseEtcAmt"),"0")));
		ye167530Vo.setConb4LglNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef4AttrYrLglUseNtsAmt"),"0")));
		ye167530Vo.setConb4LglEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef4AttrYrLglUseEtcAmt"),"0")));
		ye167530Vo.setConb4ReliOrgNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef4AttrYrReliOrgUseNtsAmt"),"0")));
		
		ye167530Vo.setConb4ReliOrgEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef4AttrYrReliOrgUseEtcAmt"),"0")));
		ye167530Vo.setConb4ReliOrgOthNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef4AttrYrReliOrgOthUseNtsAmt"),"0")));
		ye167530Vo.setConb4ReliOrgOthEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef4AttrYrReliOrgOthUseEtcAmt"),"0")));
		ye167530Vo.setConb5LglNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef5AttrYrLglUseNtsAmt"),"0")));
		ye167530Vo.setConb5LglEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef5AttrYrLglUseEtcAmt"),"0")));
		
		ye167530Vo.setConb5ReliOrgNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef5AttrYrReliOrgUseNtsAmt"),"0")));
		ye167530Vo.setConb5ReliOrgEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef5AttrYrReliOrgUseEtcAmt"),"0")));
		ye167530Vo.setConb5ReliOrgOthNtsAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef5AttrYrReliOrgOthUseNtsAmt"),"0")));
		ye167530Vo.setConb5ReliOrgOthEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbCrfwAmtBef5AttrYrReliOrgOthUseEtcAmt"),"0")));
		
		ye167530Vo.setKybdr(sessionUser.getUsrId());
		ye167530Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167530Vo.setIsmt(sessionUser.getUsrId());
		ye167530Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta6200_PDF_YE167530_2021_Insert(ye167530Vo);	//국세청, 기타자료 항목구분 입력
	}
}
