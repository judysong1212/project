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

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167310VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe167320VO;
import com.app.smrmf.pkg.yeta.yeta2017.pdfxml.service.Yeta2200XmlService;

public class Func_Pdf_DDC_D101Y {

	@Resource(name = "Yeta2200XmlService")
	private static Yeta2200XmlService yetaPayr2200Service;

	private static NodeList subXmlElChildForm = null;
	private static Node subXmlItemMan = null;
	private static NodeList subXmlElChildMan = null;
	private static Element subXmlElMan = null;
	private static Node subXmlItemData = null;
	private static Element subXmlElData = null;

	private static String strResnoEncCntn = "";
	
	private static String strFnm = "";
	private static String strResno = "";
	private static String strTnm = "";				
	private static String strBsnoEncCntn = "";	
	
	private static String strAttrYr= "";	
	private static String strFormCd  = "";

	public static void func_2017_D101Y(InfcPkgYe161010VO ye161010Vo, Element  xmlelDoc, Element  subXmlElForm, String nResult, HttpServletRequest request) throws Exception{ 

		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 

		}
		InfcPkgYe167310VO ye167310Vo = new InfcPkgYe167310VO();
		InfcPkgYe167320VO ye167320Vo = new InfcPkgYe167320VO();
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		
		//인원별 반복구간
		for (int j = 0; j < subXmlElChildForm.getLength();j++) { 

			subXmlItemMan =  subXmlElChildForm.item(j);  //인원별 데이터
			subXmlElMan  = (Element) subXmlItemMan;

			strFnm = subXmlElMan.getAttribute("fnm");	//이름
			strResno = subXmlElMan.getAttribute("resno");   //주민번호
			strTnm = subXmlElMan.getAttribute("tnm");   //근무처명칭				
			strBsnoEncCntn = subXmlElMan.getAttribute("bsnoEncCntn");   //사업자등록번호
			strAttrYr	= subXmlElMan.getAttribute("attrYr");   //주소
			
			String strValue = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(strResno).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC);	//주민번호
			
			/** -------------------------------- 초기화 작업 시작 ------------------------------------*/
			ye167310Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167310Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167310Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167310Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr2200Service.yeta2200_PDF_YE167310_2017_Delete(ye167310Vo);	//기본정보 삭제
			
			ye167320Vo.setDpobCd(ye161010Vo.getDpobCd()); 				
			ye167320Vo.setYrtxBlggYr(ye161010Vo.getYrtxBlggYr()); 		
			ye167320Vo.setSystemkey(ye161010Vo.getSystemkey()); 		
			ye167320Vo.setClutSeptCd(ye161010Vo.getClutSeptCd());	
			
			yetaPayr2200Service.yeta2200_PDF_YE167320_2017_Delete(ye167320Vo);	//인적공제 삭제	
			
			/** -------------------------------- 초기화 작업 종료 ------------------------------------*/
			
			ye167310Vo.setFormCd(strFormCd);
			ye167310Vo.setTnm(strTnm);
			ye167310Vo.setBsnoEncCntn(strBsnoEncCntn);
			ye167310Vo.setFnm(strFnm);
			ye167310Vo.setResno(strValue);  
			 	
			ye167310Vo.setAttrYr(strAttrYr);
			
			ye167310Vo.setKybdr(sessionUser.getUsrId());
			ye167310Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			ye167310Vo.setIsmt(sessionUser.getUsrId());
			ye167310Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			yetaPayr2200Service.yeta2200_PDF_YE167310_2017_Insert(ye167310Vo);	//기본정보 입력
			
			subXmlElChildMan =  subXmlElMan.getElementsByTagName("data");

			//상품별 반복구간
			for(int k = 0; k < subXmlElChildMan.getLength();k++) {  
				System.out.println("길이 :" + subXmlElChildMan.getLength());
				subXmlItemData =  subXmlElChildMan.item(k); 
				subXmlElData  = (Element) subXmlItemData;
				
				strResnoEncCntn = subXmlElData.getAttribute("resnoEncCntn"); 
				
				if (!strResnoEncCntn.equals("")) { // 의료비 지급명세 반복 구간
					setYe167320Vo(ye167320Vo, request);
				}
			}

		}

	}
	
	public static void setYe167320Vo(InfcPkgYe167320VO ye167320Vo , HttpServletRequest request) throws Exception{

		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 
		}
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		ye167320Vo.setResnoEncCntn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("resnoEncCntn")));
		ye167320Vo.setYn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("yn")));
		ye167320Vo.setBsnoEncCntn(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("bsnoEncCntn")));
		ye167320Vo.setPlymNm(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("plymNm")));
		ye167320Vo.setMdxpsPrfClCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("mdxpsPrfClCd")));
		
		ye167320Vo.setScnt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("scnt")));
		ye167320Vo.setUseAmt(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("useAmt")));
		ye167320Vo.setYn2(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("yn2")));
		
		ye167320Vo.setKybdr(sessionUser.getUsrId());
		ye167320Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		ye167320Vo.setIsmt(sessionUser.getUsrId());
		ye167320Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yetaPayr2200Service.yeta2200_PDF_YE167320_2017_Insert(ye167320Vo);	//기본정보 입력
	}
}
