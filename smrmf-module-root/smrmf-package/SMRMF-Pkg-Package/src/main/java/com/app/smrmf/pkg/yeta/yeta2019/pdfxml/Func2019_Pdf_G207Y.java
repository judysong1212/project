package com.app.smrmf.pkg.yeta.yeta2019.pdfxml;

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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfG104y_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfG207m_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfG207y_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgPdfYE162015_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161010_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161040_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe161070_2019_VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2019.InfcPkgYe166020_2019_VO;
import com.app.smrmf.pkg.yeta.yeta2019.pdfxml.service.Yeta4200XmlService;

public class Func2019_Pdf_G207Y {

	@Resource(name = "Yeta4200XmlService")
	private static Yeta4200XmlService yetaPayr3200Service;

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

	public static void func_2019_G207Y_G207M(InfcPkgYe161010_2019_VO ye161010VO, Element  subXmlElForm, String nResult , HttpServletRequest request ) throws Exception{

		/**+++++++++++2012년도 : 연금저축 E101Y 연간합계 E101M+++++++++++++++++++++++++++++++++++++++++++++++++*/

		// 2012년도 : 연금저축 E101Y 연간합계 E101M
		// 연금 저축 시작
		//월별 E01 연금저축 본인
		//근로자 본인 명의로 2001.1.1 이후에 가입하여 해당 과세기간에 불입한 금액
		//Y0040040  	B011	0040	연금저축					22
		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta4200XmlService) wac.getBean("Yeta4200XmlService" ); 
		}
		

		InfcPkgPdfG207y_2019_VO yetaPdfG207yVo = new InfcPkgPdfG207y_2019_VO();
		InfcPkgPdfG207m_2019_VO yetaPdfG207mVo = new InfcPkgPdfG207m_2019_VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request);
		
		yetaPdfG207yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG207yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG207yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG207yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 

		yetaPayr3200Service.yeta4200_PDF_G207Y_2019_Delete(yetaPdfG207yVo);
		
		yetaPdfG207mVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
		yetaPdfG207mVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
		yetaPdfG207mVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
		yetaPdfG207mVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
		
		yetaPayr3200Service.yeta4200_PDF_G207M_2019_Delete(yetaPdfG207mVo);
		
		strDatCd = "";
		subXmlElChildForm =  subXmlElForm.getElementsByTagName("man");
		strFormCd  = subXmlElForm.getAttribute("form_cd"); 
		
		InfcPkgPdfYE162015_2019_VO yetaPdfYE162015Vo = new InfcPkgPdfYE162015_2019_VO();
		
		yetaPdfYE162015Vo.setDpobCd(sessionUser.getDpobCd());
		yetaPdfYE162015Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		yetaPdfYE162015Vo.setSystemkey(ye161010VO.getSystemkey());
		yetaPdfYE162015Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		yetaPdfYE162015Vo.setFileAppPaprDivCd(strFormCd);
		
		yetaPayr3200Service.yeta4200_PDF_YE162015_2019_Delete(yetaPdfYE162015Vo);
		
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

				yetaPdfG207yVo.setFormCd(strFormCd);
				yetaPdfG207yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfG207yVo.setName(strName);
				yetaPdfG207yVo.setPdfDatAppYn("N");

				yetaPdfG207yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfG207yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfG207yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfG207yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0013")) { //if strDatCd  = 'G02' then

					yetaPdfG207yVo.setDatCd(strDatCd);

					// 일반
					if ((subXmlElData.getAttribute("use_place_cd")).equals("1") )  {
						setPdfG207yVo(yetaPdfG207yVo, request, subXmlElData);
					}
					// 전통시장
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("2") )  {
						setPdfG207yVo(yetaPdfG207yVo, request, subXmlElData);
					}
					// 대중교통
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("3") )  {
						setPdfG207yVo(yetaPdfG207yVo, request, subXmlElData);
					}
					// 도서공연비
					else  if ((subXmlElData.getAttribute("use_place_cd")).equals("4") )  {
						setPdfG207yVo(yetaPdfG207yVo, request, subXmlElData);
					}
					
					if (strFormCd.equals("G207M")) {

						subXmlElChildAmt = subXmlElData.getElementsByTagName("amt");
						
						for(int i = 0; i < subXmlElChildAmt.getLength(); i++) {  
							subXmlItemAmt =  subXmlElChildAmt.item(i);
							subXmlElAmt = (Element) subXmlItemAmt;
							strMn = subXmlElAmt.getAttribute("mm");
							strAmt = new BigDecimal(MSFSharedUtils.defaultNulls(subXmlElAmt.getFirstChild().getNodeValue(),"0"));

							yetaPdfG207mVo.setResid(strDecValue);
							yetaPdfG207mVo.setUsePlaceCd(MSFSharedUtils.allowNulls(subXmlElData.getAttribute("use_place_cd")));
							
							yetaPdfG207mVo.setKybdr(sessionUser.getUsrId());
							yetaPdfG207mVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							yetaPdfG207mVo.setIsmt(sessionUser.getUsrId());
							yetaPdfG207mVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
							
							yetaPdfG207mVo.setChahUseAmtMn(strMn);

							if (strMn.equals("01")) {
								setPdfG207mVo(yetaPdfG207mVo, request, subXmlElData);
							}
							else if (strMn.equals("02")) {
								setPdfG207mVo(yetaPdfG207mVo, request, subXmlElData);
							}
							else if (strMn.equals("03")) {
								setPdfG207mVo(yetaPdfG207mVo, request, subXmlElData);
							}
							else if (strMn.equals("04")) {
								setPdfG207mVo(yetaPdfG207mVo, request, subXmlElData);
							}
							else if (strMn.equals("05")) {
								setPdfG207mVo(yetaPdfG207mVo, request, subXmlElData);
							}
							else if (strMn.equals("06")) {
								setPdfG207mVo(yetaPdfG207mVo, request, subXmlElData);
							}
							else if (strMn.equals("07")) {
								setPdfG207mVo(yetaPdfG207mVo, request, subXmlElData);
							}
							else if (strMn.equals("08")) {
								setPdfG207mVo(yetaPdfG207mVo, request, subXmlElData);
							}
							else if (strMn.equals("09")) {
								setPdfG207mVo(yetaPdfG207mVo, request, subXmlElData);
							}
							else if (strMn.equals("10")) {
								setPdfG207mVo(yetaPdfG207mVo, request, subXmlElData);
							}
							else if (strMn.equals("11")) {
								setPdfG207mVo(yetaPdfG207mVo, request, subXmlElData);
							}
							else if (strMn.equals("12")) {
								setPdfG207mVo(yetaPdfG207mVo, request, subXmlElData);
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
		
		yetaPayr3200Service.yeta4200_PDF_YE162015_2019_Insert(yetaPdfYE162015Vo);
		//현금 영수증 종료
	}

	public static void setPdfG207yVo(InfcPkgPdfG207y_2019_VO yetaPdfG207yVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta4200XmlService) wac.getBean("Yeta4200XmlService" ); 
		}
		yetaPdfG207yVo.setUsePlaceCd(subXmlElData.getAttribute("use_place_cd"));
		yetaPdfG207yVo.setCashCardSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));
		
		yetaPayr3200Service.yeta4200_PDF_G207Y_2019_Insert(yetaPdfG207yVo);

	}
	
	public static void setPdfG207mVo(InfcPkgPdfG207m_2019_VO yetaPdfG207mVo , HttpServletRequest request, Element subXmlElData) throws Exception{

		if  (yetaPayr3200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr3200Service = (Yeta4200XmlService) wac.getBean("Yeta4200XmlService" ); 
		}

		yetaPdfG207mVo.setCashMmAmt(strAmt);
		
		yetaPayr3200Service.yeta4200_PDF_G207M_2019_Insert(yetaPdfG207mVo);

	}
	
	

	public static void func_2019_G207Y_YetaCalc(InfcPkgYe161010_2019_VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr3200Service = (Yeta4200XmlService)BeanFinder.getBean("Yeta4200XmlService");
		int dataChk = 0;
		String datacheck = "";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
	
		   //  현금 영수증 시작
        //현금영수증 - - G203M 월별 G02 현금영수증 본인+가족
        //종류확인.  기본서직없음. 상세...
		
		 InfcPkgYe161040_2019_VO infcPkgYe161040Vo = new InfcPkgYe161040_2019_VO();
			
		infcPkgYe161040Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161040Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161040Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161040Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161040Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161040Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161040Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//YE161040 소득공제명세에 신용카드 
		dataChk = yetaPayr3200Service.PdfYeta2019_G207Y_YE161040_Update(infcPkgYe161040Vo); 
		
		if (dataChk >= 0) {
			
			InfcPkgYe166020_2019_VO infcPkgYe166020Vo = new InfcPkgYe166020_2019_VO();
			
			infcPkgYe166020Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe166020Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe166020Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe166020Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
			infcPkgYe166020Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe166020Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe166020Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe166020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
			
			//신용카드
			yetaPayr3200Service.PdfYeta4200_G107Y_YE166020_Update(infcPkgYe166020Vo);  
			  
			//신용카드
			InfcPkgYe161070_2019_VO infcPkgYe161070Vo = new InfcPkgYe161070_2019_VO();
			
			
			infcPkgYe161070Vo.setDpobCd(sessionUser.getDpobCd());
			infcPkgYe161070Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
			infcPkgYe161070Vo.setSystemkey(ye161010VO.getSystemkey());
			infcPkgYe161070Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
			infcPkgYe161070Vo.setKybdr(sessionUser.getUsrId());
			infcPkgYe161070Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			infcPkgYe161070Vo.setIsmt(sessionUser.getUsrId());
			infcPkgYe161070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
			// 신용카드  
	         yetaPayr3200Service.fnYeta4200_G207Y_YE161070_2019_Update(infcPkgYe161070Vo); 
	         
		}
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr3200Service.yeta4200_PDF_YE162015_2019_Insert(ye161010VO);

		 
	}	
}
