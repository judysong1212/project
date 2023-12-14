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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG104yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG206mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfG206yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfYE162015VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161040VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161070VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe166020VO;
import com.app.smrmf.pkg.yeta.yeta2017.pdfxml.service.Yeta2200XmlService;

public class Func_Pdf_G206Y {

	@Resource(name = "Yeta2200XmlService")
	private static Yeta2200XmlService yetaPayr2200Service;

	private static NodeList subXmlElChildForm = null;
	private static Node subXmlItemMan = null;
	private static NodeList subXmlElChildMan = null;
	private static Element subXmlElMan = null;
	private static Node subXmlItemData = null;
	private static Element subXmlElData = null;

	private static NodeList subXmlElChildAmt = null;
	private static Element subXmlElAmt = null;
	private static Node subXmlItemAmt = null;

	private static String strResid = "";
	private static String strDatCd = "";
	private static String strMn= "";
	private static BigDecimal strAmt= null;
	private static String strFormCd = "";
	private static String strName = "";

	public static void func_2017_G206Y_G206M(InfcPkgYe161010VO ye161010VO, Element  subXmlElForm, String nResult , HttpServletRequest request ) throws Exception{

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
		

		InfcPkgPdfG206yVO yetaPdfG206yVo = new InfcPkgPdfG206yVO();
		InfcPkgPdfG206mVO yetaPdfG206mVo = new InfcPkgPdfG206mVO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		yetaPdfG206yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG206yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG206yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG206yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 

		yetaPayr2200Service.yeta2200_PDF_G206Y_2017_Delete(yetaPdfG206yVo);
		
		yetaPdfG206mVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG206mVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG206mVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG206mVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr2200Service.yeta2200_PDF_G206M_2017_Delete(yetaPdfG206mVo);
		
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

				yetaPdfG206yVo.setFormCd(strFormCd);
				yetaPdfG206yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfG206yVo.setName(strName);
				yetaPdfG206yVo.setPdfDatAppYn("N");

				yetaPdfG206yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfG206yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfG206yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfG206yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0013")) { //if strDatCd  = 'G02' then

					yetaPdfG206yVo.setDatCd(strDatCd);

					if ((subXmlElData.getAttribute("use_place_cd")).equals("1") )  {
						setPdfG206yVo(yetaPdfG206yVo, request, subXmlElData);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("2") )  {
						setPdfG206yVo(yetaPdfG206yVo, request, subXmlElData);
					}
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("3") )  {
						setPdfG206yVo(yetaPdfG206yVo, request, subXmlElData);
					}
					
					if (strFormCd.equals("G206M")) {

						subXmlElChildAmt = subXmlElData.getElementsByTagName("amt");
						
						for(int i = 0; i < subXmlElChildAmt.getLength(); i++) {  
							subXmlItemAmt =  subXmlElChildAmt.item(i);
							subXmlElAmt = (Element) subXmlItemAmt;
							strMn = subXmlElAmt.getAttribute("mm");
							strAmt = new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElAmt.getFirstChild().getNodeValue(),"0"));

							yetaPdfG206mVo.setResid(strDecValue);
							yetaPdfG206mVo.setUsePlaceCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("use_place_cd")));
							
							yetaPdfG206mVo.setKybdr(sessionUser.getUsrId());
							yetaPdfG206mVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							yetaPdfG206mVo.setIsmt(sessionUser.getUsrId());
							yetaPdfG206mVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							
							yetaPdfG206mVo.setChahUseAmtMn(strMn);

							if (strMn.equals("01")) {
								setPdfG206mVo(yetaPdfG206mVo, request, subXmlElData);
							}
							else if (strMn.equals("02")) {
								setPdfG206mVo(yetaPdfG206mVo, request, subXmlElData);
							}
							else if (strMn.equals("03")) {
								setPdfG206mVo(yetaPdfG206mVo, request, subXmlElData);
							}
							else if (strMn.equals("04")) {
								setPdfG206mVo(yetaPdfG206mVo, request, subXmlElData);
							}
							else if (strMn.equals("05")) {
								setPdfG206mVo(yetaPdfG206mVo, request, subXmlElData);
							}
							else if (strMn.equals("06")) {
								setPdfG206mVo(yetaPdfG206mVo, request, subXmlElData);
							}
							else if (strMn.equals("07")) {
								setPdfG206mVo(yetaPdfG206mVo, request, subXmlElData);
							}
							else if (strMn.equals("08")) {
								setPdfG206mVo(yetaPdfG206mVo, request, subXmlElData);
							}
							else if (strMn.equals("09")) {
								setPdfG206mVo(yetaPdfG206mVo, request, subXmlElData);
							}
							else if (strMn.equals("10")) {
								setPdfG206mVo(yetaPdfG206mVo, request, subXmlElData);
							}
							else if (strMn.equals("11")) {
								setPdfG206mVo(yetaPdfG206mVo, request, subXmlElData);
							}
							else if (strMn.equals("12")) {
								setPdfG206mVo(yetaPdfG206mVo, request, subXmlElData);
							}
							
						}


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
		
		yetaPayr2200Service.yeta2200_PDF_YE162015_2017_Insert(yetaPdfYE162015Vo);
		//현금 영수증 종료
	}

	public static void setPdfG206yVo(InfcPkgPdfG206yVO yetaPdfG206yVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 
		}
		yetaPdfG206yVo.setUsePlaceCd(subXmlElData.getAttribute("use_place_cd"));
		yetaPdfG206yVo.setCashCardSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));
		
		yetaPayr2200Service.yeta2200_PDF_G206Y_2017_Insert(yetaPdfG206yVo);

	}
	
	public static void setPdfG206mVo(InfcPkgPdfG206mVO yetaPdfG206mVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 
		}

		yetaPdfG206mVo.setCashMmAmt(strAmt);
		
		yetaPayr2200Service.yeta2200_PDF_G206M_2017_Insert(yetaPdfG206mVo);

	}
	
	

	public static void func_2017_G206Y_YetaCalc(InfcPkgYe161010VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr2200Service = (Yeta2200XmlService)BeanFinder.getBean("Yeta2200XmlService");
		int dataChk = 0;
		String datacheck = "";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
	
		   //  현금 영수증 시작
        //현금영수증 - - G203M 월별 G02 현금영수증 본인+가족
        //종류확인.  기본서직없음. 상세...
		
		 InfcPkgYe161040VO infcPkgYe161040Vo = new InfcPkgYe161040VO();
			
		infcPkgYe161040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161040Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161040Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//YE161040 소득공제명세에 신용카드 
		dataChk = yetaPayr2200Service.PdfYeta2017_G206Y_YE161040_Update(infcPkgYe161040Vo); 
		
		if (dataChk >= 0) {
			
			InfcPkgYe166020VO infcPkgYe166020Vo = new InfcPkgYe166020VO();
			
			infcPkgYe166020Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe166020Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe166020Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe166020Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
			infcPkgYe166020Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe166020Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe166020Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe166020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
			
			//신용카드
			yetaPayr2200Service.PdfYeta2200_G106Y_YE166020_Update(infcPkgYe166020Vo);  
			  
			//신용카드
			InfcPkgYe161070VO infcPkgYe161070Vo = new InfcPkgYe161070VO();
			
			
			infcPkgYe161070Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe161070Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe161070Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe161070Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
			infcPkgYe161070Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe161070Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe161070Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe161070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
			// 신용카드  
	         yetaPayr2200Service.fnYeta2200_G206Y_YE161070_2017_Update(infcPkgYe161070Vo); 
	         
		}
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr2200Service.yeta2200_PDF_YE162015_2017_Insert(ye161010VO);

		 
	}	
}
