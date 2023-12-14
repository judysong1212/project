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

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167410_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167420_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167430_2020_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe167440_2020_VO;
import com.app.smrmf.pkg.yeta.yeta2020.pdfxml.service.Yeta5200XmlService;

public class Func2020_Pdf_DDC_E101Y {

	@Resource(name = "Yeta5200XmlService")
	private static Yeta5200XmlService yetaPayr3200Service;

	private static NodeList subXmlElChildForm = null;
	private static Node subXmlItemMan = null;
	private static NodeList subXmlElChildMan = null;
	private static Element subXmlElMan = null;
	private static Node subXmlItemData = null;
	private static Element subXmlElData = null;

	private static String strConbCd = "";
	private static String strAmtSum = "";
	private static String strConbCddl = "";
	
	private static String strFnm = "";
	private static String strResno = "";
	private static String strTnm = "";				
	private static String strBsnoEncCntn = "";	
	
	private static String strAdr= "";	
	private static String strPfbAdr = "";		 
	private static String strFormCd  = "";
	private static int FamCd = 0;

	public static void func_2020_E101Y(InfcPkgYe161010_2020_VO ye161010Vo, Element  xmlelDoc, Element  subXmlElForm, String nResult, HttpServletRequest request) throws Exception{ 

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta5200XmlService) wac.getBean("Yeta5200XmlService" ); 

		}
		InfcPkgYe167410_2020_VO ye167410Vo = new InfcPkgYe167410_2020_VO();
		InfcPkgYe167420_2020_VO ye167420Vo = new InfcPkgYe167420_2020_VO();
		InfcPkgYe167430_2020_VO ye167430Vo = new InfcPkgYe167430_2020_VO();
		InfcPkgYe167440_2020_VO ye167440Vo = new InfcPkgYe167440_2020_VO();
		
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
			strResno= subXmlElMan.getAttribute("resno");   //주민번호
			strAdr	= subXmlElMan.getAttribute("adr");   //주소
			strPfbAdr = subXmlElMan.getAttribute("pfbAdr");   //사업장소재지
			
			String strValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResno).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			
			/** -------------------------------- 초기화 작업 시작 ------------------------------------*/
			ye167410Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167410Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167410Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167410Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta5200_PDF_YE167410_2020_Delete(ye167410Vo);	//인적공제 삭제	
			
			ye167420Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167420Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167420Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167420Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta5200_PDF_YE167420_2020_Delete(ye167420Vo);	//인적공제 삭제	
			
			ye167430Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167430Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167430Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167430Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta5200_PDF_YE167430_2020_Delete(ye167430Vo);	//인적공제 삭제	
			
			ye167440Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167440Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167440Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167440Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr3200Service.yeta5200_PDF_YE167440_2020_Delete(ye167440Vo);	//인적공제 삭제	
			
			/** -------------------------------- 초기화 작업 종료 ------------------------------------*/
			
			ye167410Vo.setFormCd(strFormCd);
			ye167410Vo.setTnm(strTnm);
			ye167410Vo.setBsnoEncCntn(strBsnoEncCntn);
			ye167410Vo.setFnm(strFnm);
			ye167410Vo.setResno(strValue);
			
			ye167410Vo.setAdr(strAdr);
			ye167410Vo.setPfbAdr(strPfbAdr);
			
			ye167410Vo.setKybdr(sessionUser.getUsrId());
			ye167410Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			ye167410Vo.setIsmt(sessionUser.getUsrId());
			ye167410Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			yetaPayr3200Service.yeta5200_PDF_YE167410_2020_Insert(ye167410Vo);	//기본정보 입력
			
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");

			//상품별 반복구간
			for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
				System.out.println("길이 :" + subXmlElChildMan.getLength());
				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				
				strConbCd = subXmlElData.getAttribute("conbCd"); 
				strAmtSum = subXmlElData.getAttribute("amtSum");
				strConbCddl = subXmlElData.getAttribute("conbCddl");
				
				if (!strConbCd.equals("")) { // 해당 연도 기부 명세 반복 구간
					setYe167420Vo(ye167420Vo, request);
				}
				else if (!strAmtSum.equals("")) { // 구분 코드별 기부금의 합계 반복 구간
					setYe167430Vo(ye167430Vo, FamCd, request);
					FamCd++;
				}
				else if (!strConbCddl.equals("")) { // 기부금 조정 명세 반복 구간
					setYe167440Vo(ye167440Vo, request);
				}
			}

		}

	}
	
	public static void setYe167420Vo(InfcPkgYe167420_2020_VO ye167420Vo , HttpServletRequest request) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta5200XmlService) wac.getBean("Yeta5200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167420Vo.setConbCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("conbCd")));    								             /** column 기부유형 : conbCd */
		ye167420Vo.setConbNm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("conbNm")));    								             /** column 기부코드 : conbNm */
		ye167420Vo.setYrsMateClCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("yrsMateClCd")));    						             /** column 기부자료구분코드 : yrsMateClCd */
		ye167420Vo.setDntCntn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("dntCntn")));    								             /** column 기부내용 : dntCntn */
		                                                                                                                                     
		ye167420Vo.setCoplNm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("coplNm")));    								             /** column 기부처_상호명 : coplNm */
		ye167420Vo.setBsnoEncCntn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("bsnoEncCntn")));    						             /** column 기부처_사업자등록번호 : bsnoEncCntn */
		ye167420Vo.setCnbtRltClCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("cnbtRltClCd")));    						             /** column 기부자관계코드 : cnbtRltClCd */
		ye167420Vo.setCnbtFnm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("cnbtFnm")));    								             /** column 기부자성명 : cnbtFnm */
		ye167420Vo.setResnoEncCntn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("resnoEncCntn")));    					             /** column 기부자_주민등록번호 : resnoEncCntn */
		                                                                                                                                     
		ye167420Vo.setDntScnt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("dntScnt"),"0")));    	      	         /** column 기부명세건수 : dntScnt */
		ye167420Vo.setUseSumAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("useSumAmt"),"0")));    	             /** column 기부명세합계금액 : useSumAmt */
		ye167420Vo.setDdcTrgtConbAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ddcTrgtConbAmt"),"0")));          /** column 공제대상기부금액 : ddcTrgtConbAmt */
		ye167420Vo.setConbSumAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbSumAmt"),"0")));    	             /** column 기부장려금신청금 : conbSumAmt */
		ye167420Vo.setDdcExclConbEtcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ddcExclConbEtcAmt"),"0")));    /** column 공제제외기부금기타금액 : ddcExclConbEtcAmt */
		
		ye167420Vo.setKybdr(sessionUser.getUsrId());                                        									             /** column 입력자 : kybdr */
		ye167420Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());       	 							             /** column 입력주소 : inptAddr */
		ye167420Vo.setIsmt(sessionUser.getUsrId());                                         									             /** column 수정자 : ismt */
		ye167420Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());      								             /** column 수정주소 : revnAddr */
		
		yetaPayr3200Service.yeta5200_PDF_YE167420_2020_Insert(ye167420Vo);	//기본정보 입력 
	}
	
	public static void setYe167430Vo(InfcPkgYe167430_2020_VO ye167430Vo , int FamCd , HttpServletRequest request) throws Exception{
		
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			
			yetaPayr3200Service = (Yeta5200XmlService) wac.getBean("Yeta5200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167430Vo.setFamRltClCd(MSFSharedUtils.allowNulls(String.valueOf(FamCd)));
		
		ye167430Vo.setAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("amtSum"),"0")));    /** column 기부금총합계 : amtSum */
		ye167430Vo.setAmt10(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("amt10"),"0")));    /** column 기부금_법정기부금_10 : amt10 */
		ye167430Vo.setAmt20(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("amt20"),"0")));    /** column 기부금_정치자금기부금_20 : amt20 */
		ye167430Vo.setAmt40(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("amt40"),"0")));    /** column 기부금_종교단체외지정기부금_40 : amt40 */
		ye167430Vo.setAmt41(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("amt41"),"0")));    /** column 기부금_종교단체지정기부금_41 : amt41 */
		
		ye167430Vo.setAmt42(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("amt42"),"0")));    /** column 기부금_우리사주조합기부금_42 : amt42 */
		ye167430Vo.setDntSbdyAplnAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("dntSbdyAplnAmt"),"0")));    /** column 기부장려금신청금액 : dntSbdyAplnAmt */
		ye167430Vo.setAmt50(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("amt50"),"0")));    /** column 기부금_공제제외기부금_50 : amt50 */
		
		ye167430Vo.setKybdr(sessionUser.getUsrId());
		ye167430Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167430Vo.setIsmt(sessionUser.getUsrId());
		ye167430Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta5200_PDF_YE167430_2020_Insert(ye167430Vo);	//기본정보 입력
	}
	
	public static void setYe167440Vo(InfcPkgYe167440_2020_VO ye167440Vo , HttpServletRequest request) throws Exception{
		
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());
			
			yetaPayr3200Service = (Yeta5200XmlService) wac.getBean("Yeta5200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		
		ye167440Vo.setConbSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("conbSeilNum"),"0")));    /** column 기부금조정일련번호 : conbSeilNum */
		ye167440Vo.setAttrYr(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("attrYr")));    /** column 기부년도 : attrYr */
		ye167440Vo.setConbCddl(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("conbCddl")));    /** column 기부금코드 : conbCddl */
		ye167440Vo.setUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("useAmt"),"0")));    /** column 기부금액 : useAmt */
		ye167440Vo.setPyrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("pyrDdcAmt"),"0")));    /** column 전년도공제된금액 : pyrDdcAmt */
		
		ye167440Vo.setDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("ddcTrgtAmt"),"0")));    /** column 기부금공제대상금액 : ddcTrgtAmt */
		ye167440Vo.setThcYrDdcAmtNdXps(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("thcYrDdcAmtNdXps"),"0")));    /** column 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
		ye167440Vo.setThcYrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("thcYrDdcAmt"),"0")));    /** column 해당연도공제금액세액공제금액 : thcYrDdcAmt */
		ye167440Vo.setThcYrNducExtnAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("thcYrNducExtnAmt"),"0")));    /** column 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
		ye167440Vo.setThcYrNducCrfwAmt(new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElData.getAttribute("thcYrNducCrfwAmt"),"0")));    /** column 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */
		
		ye167440Vo.setKybdr(sessionUser.getUsrId());
		ye167440Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167440Vo.setIsmt(sessionUser.getUsrId());
		ye167440Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr3200Service.yeta5200_PDF_YE167440_2020_Insert(ye167440Vo);	//기본정보 입력
	}
}
