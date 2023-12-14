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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ301mVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfJ301yVO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgPdfYE162015VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161070VO;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe162030VO;
import com.app.smrmf.pkg.yeta.yeta2017.pdfxml.service.Yeta2200XmlService;

public class Func_Pdf_J301Y {

	@Resource(name = "Yeta2200XmlService")
	private static Yeta2200XmlService yetaPayr2200Service;

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
	
	public static void func_2017_J301Y_J301M(InfcPkgYe161010VO ye161010VO, Element  subXmlElForm, String nResult, HttpServletRequest request ) throws Exception{
		
		/**+++++++++++   주택마련 저축 시작++++++++++++++++++++++++++++++++++++++++++++++++*/

		//  주택마련 저축 시작
		//주택마련저축 J301Y 연간합계 J301M 월별 J03 주택마련저축 본인
		// Y0040050	B011	0050	청약저축					31
		//Y0040060	B011	0060	주택청약종합저축       					32
		//Y0040080	B011	0080	근로자주택마련저축     					34
		if  (yetaPayr2200Service == null) { 
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( request.getSession().getServletContext());

			yetaPayr2200Service = (Yeta2200XmlService) wac.getBean("Yeta2200XmlService" ); 
		}
		
		InfcPkgPdfJ301yVO yetaPdfJ301yVo = new InfcPkgPdfJ301yVO();
		InfcPkgPdfJ301mVO yetaPdfJ301mVo = new InfcPkgPdfJ301mVO();
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
				
				yetaPdfJ301yVo.setDpobCd(ye161010VO.getDpobCd()); /** column 사업장코드 : dpobCd */
				yetaPdfJ301yVo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr()); /** column 귀속년도 : srhClutYr */
				yetaPdfJ301yVo.setClutSeptCd(ye161010VO.getClutSeptCd()); /** column 연말정산구분코드 : settGbcd */
				yetaPdfJ301yVo.setSystemkey(ye161010VO.getSystemkey()); /** column 시스템키 : systemkey */ 
				yetaPdfJ301yVo.setFormCd(strFormCd);
				yetaPdfJ301yVo.setResid(strDecValue);    /** column 주민등록번호 : rsnoNumb */ 
				yetaPdfJ301yVo.setName(strName);
				yetaPdfJ301yVo.setPdfDatAppYn("N");
				
				yetaPdfJ301yVo.setKybdr(sessionUser.getUsrId());
				yetaPdfJ301yVo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				yetaPdfJ301yVo.setIsmt(sessionUser.getUsrId());
				yetaPdfJ301yVo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

				if (strDatCd.equals("G0018")) {
					
					yetaPdfJ301yVo.setDatCd(MSFSharedUtils.allowNulls(strDatCd));
					yetaPdfJ301yVo.setBusnid(subXmlElData.getAttribute("busnid"));			//사업자번호
					yetaPdfJ301yVo.setTradeNm(subXmlElData.getAttribute("trade_nm"));	//상호명
					yetaPdfJ301yVo.setHomeSeilSum(subXmlElData.getAttribute("acc_no"));
					yetaPdfJ301yVo.setGoodsNm(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("goods_nm", subXmlElData)));
					yetaPdfJ301yVo.setSavingGubn(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("saving_gubn", subXmlElData)));
					yetaPdfJ301yVo.setRegDt(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("reg_dt", subXmlElData)));
					yetaPdfJ301yVo.setComCd(MSFSharedUtils.allowNulls(PkgFuncUtils.getXmlTagValue("com_cd", subXmlElData)));
					yetaPdfJ301yVo.setHomeAmtSum(new BigDecimal(MSFSharedUtils.defaultNulls(PkgFuncUtils.getXmlTagValue("sum", subXmlElData),"0")));
					
					yetaPayr2200Service.yeta2200_PDF_J301Y_2017_Delete(yetaPdfJ301yVo);
					yetaPayr2200Service.yeta2200_PDF_J301Y_2017_Insert(yetaPdfJ301yVo);
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
	
	}
	

	public static void func_2017_J301Y_YetaCalc(InfcPkgYe161010VO ye161010VO, HttpServletRequest request) throws Exception{ 

		 
		yetaPayr2200Service = (Yeta2200XmlService)BeanFinder.getBean("Yeta2200XmlService");
		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(request); 
	
		/**+++++++++++   주택마련 저축 시작++++++++++++++++++++++++++++++++++++++++++++++++*/
        
        //  주택마련 저축 시작
         //주택마련저축 J301Y 연간합계 J301M 월별 J03 주택마련저축 본인
        // Y0040050	B011	0050	청약저축					31
         //Y0040060	B011	0060	주택청약종합저축       					32
         //Y0040080	B011	0080	근로자주택마련저축     					34
		
		InfcPkgYe162030VO infcPkgYe162030Vo = new InfcPkgYe162030VO();
		
		infcPkgYe162030Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe162030Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe162030Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe162030Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe162030Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe162030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe162030Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe162030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	
		
		//주택마련
		yetaPayr2200Service.PdfYeta2200_J301Y_YE162030_Delete(infcPkgYe162030Vo); 
		yetaPayr2200Service.PdfYeta2200_J301Y_YE162030_Insert(infcPkgYe162030Vo); 
		 
		//주택마련
		InfcPkgYe161070VO infcPkgYe161070Vo = new InfcPkgYe161070VO();
		
		
		infcPkgYe161070Vo.setDpobCd(sessionUser.getDpobCd());
		infcPkgYe161070Vo.setYrtxBlggYr(ye161010VO.getYrtxBlggYr());
		infcPkgYe161070Vo.setSystemkey(ye161010VO.getSystemkey());
		infcPkgYe161070Vo.setClutSeptCd(ye161010VO.getClutSeptCd());
		infcPkgYe161070Vo.setKybdr(sessionUser.getUsrId());
		infcPkgYe161070Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		infcPkgYe161070Vo.setIsmt(sessionUser.getUsrId());
		infcPkgYe161070Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					 
		// 주택마련 합계  
         yetaPayr2200Service.fnYeta2200_J301Y_YE161070_2017_Update(infcPkgYe161070Vo); 
     
         
         //테이블에 넣은 데이타에 대해 업데이트하기 이부분은 수정필요함. 돌면서 처리해야함. 일단 로직 만들고 작업진행 
         
         
         
//		ye161010VO.setKybdr(sessionUser.getUsrId());
//		ye161010VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		ye161010VO.setIsmt(sessionUser.getUsrId());
//		ye161010VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//		
//		yetaPayr2200Service.yeta2200_PDF_YE162015_2017_Insert(ye161010VO);

		 
	}	
}

