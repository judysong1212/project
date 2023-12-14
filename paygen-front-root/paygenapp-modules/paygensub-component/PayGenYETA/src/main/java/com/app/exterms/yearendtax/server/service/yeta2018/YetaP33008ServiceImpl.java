package com.app.exterms.yearendtax.server.service.yeta2018;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.app.exterms.yearendtax.client.dto.yeta2018.Ye160403DTO;
import com.app.exterms.yearendtax.client.service.yeta2018.YetaP33008Service;
import com.app.exterms.yearendtax.server.service.yeta2018.dao.Ye160403_2018_DAO;
import com.app.exterms.yearendtax.server.vo.Ye160403Srh_2018_VO;
import com.app.exterms.yearendtax.server.vo.Ye160403_2018_VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

@Service("YetaP33008Service")
public class YetaP33008ServiceImpl  extends AbstractCustomServiceImpl implements YetaP33008Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(YetaP33008ServiceImpl.class);
	private static final String calledClass = YetaP33008ServiceImpl.class.getName();
	
	
	@Autowired
	@Resource(name = "Ye160403_2018_DAO")
	private Ye160403_2018_DAO ye160403DAO;	
	
	
	
	/** 현근무지비과세_감면소득 팝업 저장 **/
	@Override
	public Long activityOnYetaP33008ToYe160403(Ye160403DTO ye160403Dto, ActionDatabase actionDatabase) throws MSFException {
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);

		MSFSysm0100BM sessionUser;
		String method = calledClass + ".activityOnYetaP33008ToYe160403";

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETAP3300";
			
		Ye160403_2018_VO ye160403Vo = new Ye160403_2018_VO(); 
		
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		try {

			if (MSFSharedUtils.paramNull(ye160403DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				ye160403DAO = (Ye160403_2018_DAO) wac.getBean("Ye160403_2018_DAO"); 
			}
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		                
		            
				ye160403Vo.setDpobCd(MSFSharedUtils.allowNulls(ye160403Dto.getDpobCd()));    			/** column 사업장코드 : dpobCd */
				ye160403Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye160403Dto.getYrtxBlggYr()));    	/** column 귀속연도 : yrtxBlggYr */
				ye160403Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye160403Dto.getClutSeptCd()));    	/** column 연말정산구분코드 : clutSeptCd */
				ye160403Vo.setSystemkey(MSFSharedUtils.allowNulls(ye160403Dto.getSystemkey()));    		/** column SYSTEMKEY : systemkey */
				ye160403Vo.setElctYymm(MSFSharedUtils.allowNulls(ye160403Dto.getElctYymm()));    		/** column 지급년월 : elctYymm */
				
				ye160403Vo.setTaxmSa01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSa01Bi(),"0")));    /** column 비과세소득_A01_비과세 : taxmSa01Bi */
				ye160403Vo.setTaxmSb01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSb01Bi(),"0")));    /** column 비과세소득_B01_비과세 : taxmSb01Bi */
				ye160403Vo.setTaxmSc01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSc01Bi(),"0")));    /** column 비과세소득_C01_비과세 : taxmSc01Bi */
				ye160403Vo.setTaxmSd01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSd01Bi(),"0")));    /** column 비과세소득_D01_비과세 : taxmSd01Bi */
				ye160403Vo.setTaxmSe01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSe01Bi(),"0")));    /** column 비과세소득_E01_비과세 : taxmSe01Bi */
				ye160403Vo.setTaxmSe02Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSe02Bi(),"0")));    /** column 비과세소득_E02_비과세 : taxmSe02Bi */
				ye160403Vo.setTaxmSe10Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSe10Bi(),"0")));    /** column 비과세소득_E10_비과세 : taxmSe10Bi */
				ye160403Vo.setTaxmSf01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSf01Bi(),"0")));    /** column 비과세소득_F01_비과세 : taxmSf01Bi */
				ye160403Vo.setTaxmSg01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSg01Bi(),"0")));    /** column 비과세소득_G01_비과세 : taxmSg01Bi */
				ye160403Vo.setTaxmSh01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh01Bi(),"0")));    /** column 비과세소득_H01_비과세 : taxmSh01Bi */
				ye160403Vo.setTaxmSh02Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh02Bi(),"0")));    /** column 비과세소득_H02_비과세 : taxmSh02Bi */
				ye160403Vo.setTaxmSh03Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh03Bi(),"0")));    /** column 비과세소득_H03_비과세 : taxmSh03Bi */
				ye160403Vo.setTaxmSh04Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh04Bi(),"0")));    /** column 비과세소득_H04_비과세 : taxmSh04Bi */
				ye160403Vo.setTaxmSh05Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh05Bi(),"0")));    /** column 비과세소득_H05_비과세 : taxmSh05Bi */
				ye160403Vo.setTaxmSh06Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh06Bi(),"0")));    /** column 비과세소득_H06_비과세 : taxmSh06Bi */
				ye160403Vo.setTaxmSh07Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh07Bi(),"0")));    /** column 비과세소득_H07_비과세 : taxmSh07Bi */
				ye160403Vo.setTaxmSh08Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh08Bi(),"0")));    /** column 비과세소득_H08_비과세 : taxmSh08Bi */
				ye160403Vo.setTaxmSh09Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh09Bi(),"0")));    /** column 비과세소득_H09_비과세 : taxmSh09Bi */
				ye160403Vo.setTaxmSh10Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh10Bi(),"0")));    /** column 비과세소득_H10_비과세 : taxmSh10Bi */
				ye160403Vo.setTaxmSh14Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh14Bi(),"0")));    /** column 비과세소득_H14_비과세 : taxmSh14Bi */
				ye160403Vo.setTaxmSh15Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh15Bi(),"0")));    /** column 비과세소득_H15_비과세 : taxmSh15Bi */
				ye160403Vo.setTaxmSh11Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh11Bi(),"0")));    /** column 비과세소득_H11_비과세 : taxmSh11Bi */
				ye160403Vo.setTaxmSh12Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh12Bi(),"0")));    /** column 비과세소득_H12_비과세 : taxmSh12Bi */
				ye160403Vo.setTaxmSh13Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh13Bi(),"0")));    /** column 비과세소득_H13_비과세 : taxmSh13Bi */
				ye160403Vo.setTaxmSh16Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSh16Bi(),"0")));    /** column 비과세소득_H16_비과세 : taxmSh16Bi */
				ye160403Vo.setTaxmSi01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSi01Bi(),"0")));    /** column 비과세소득_I01_비과세 : taxmSi01Bi */
				ye160403Vo.setTaxmSj01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSj01Bi(),"0")));    /** column 비과세소득_J01_비과세 : taxmSj01Bi */
				ye160403Vo.setTaxmSj10Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSj10Bi(),"0")));    /** column 비과세소득_J10_비과세 : taxmSj10Bi */
				ye160403Vo.setTaxmSk01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSk01Bi(),"0")));    /** column 비과세소득_K01_비과세 : taxmSk01Bi */
				ye160403Vo.setTaxmSl01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSl01Bi(),"0")));    /** column 비과세소득_L01_비과세 : taxmSl01Bi */
				ye160403Vo.setTaxmSm01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSm01Bi(),"0")));    /** column 비과세소득_M01_비과세 : taxmSm01Bi */
				ye160403Vo.setTaxmSm02Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSm02Bi(),"0")));    /** column 비과세소득_M02_비과세 : taxmSm02Bi */
				ye160403Vo.setTaxmSm03Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSm03Bi(),"0")));    /** column 비과세소득_M03_비과세 : taxmSm03Bi */
				ye160403Vo.setTaxmSn01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSn01Bi(),"0")));    /** column 비과세소득_N01_비과세 : taxmSn01Bi */
				ye160403Vo.setTaxmSo01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSo01Bi(),"0")));    /** column 비과세소득_O01_비과세 : taxmSo01Bi */
				ye160403Vo.setTaxmSp01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSp01Bi(),"0")));    /** column 비과세소득_P01_비과세 : taxmSp01Bi */
				ye160403Vo.setTaxmSp02Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSp02Bi(),"0")));    /** column 비과세소득_P02_비과세 : taxmSp02Bi */
				ye160403Vo.setTaxmSq01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSq01Bi(),"0")));    /** column 비과세소득_Q01_비과세 : taxmSq01Bi */
				ye160403Vo.setTaxmSr01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSr01Bi(),"0")));    /** column 비과세소득_R01_비과세 : taxmSr01Bi */
				ye160403Vo.setTaxmSr10Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSr10Bi(),"0")));    /** column 비과세소득_R10_비과세 : taxmSr10Bi */
				ye160403Vo.setTaxmSs01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSs01Bi(),"0")));    /** column 비과세소득_S01_비과세 : taxmSs01Bi */
				ye160403Vo.setTaxmSy02Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSy02Bi(),"0")));    /** column 비과세소득_Y02_비과세 : taxmSy02Bi */
				ye160403Vo.setTaxmSy03Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSy03Bi(),"0")));    /** column 비과세소득_Y03_비과세 : taxmSy03Bi */
				ye160403Vo.setTaxmSy04Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSy04Bi(),"0")));    /** column 비과세소득_Y04_비과세 : taxmSy04Bi */
				ye160403Vo.setTaxmSy21Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSy21Bi(),"0")));    /** column 비과세소득_Y21_비과세 : taxmSy21Bi */
				ye160403Vo.setTaxmSy22Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSy22Bi(),"0")));    /** column 비과세소득_Y22_비과세 : taxmSy22Bi */
				ye160403Vo.setTaxmSt01Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSt01Bi(),"0")));    /** column 감면소득_T01_비과세 : taxmSt01Bi */
				ye160403Vo.setTaxmSt10Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSt10Bi(),"0")));    /** column 감면소득_T10_비과세 : taxmSt10Bi */
				ye160403Vo.setTaxmSt11Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSt11Bi(),"0")));    /** column 감면소득_T11_비과세 : taxmSt11Bi */
				ye160403Vo.setTaxmSt12Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSt12Bi(),"0")));    /** column 감면소득_T12_비과세 : taxmSt12Bi */
				ye160403Vo.setTaxmSt20Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSt20Bi(),"0")));    /** column 감면소득_T20_비과세 : taxmSt20Bi */
				ye160403Vo.setTaxmSr11Bi(new BigDecimal(MSFSharedUtils.defaultNulls(ye160403Dto.getTaxmSr11Bi(),"0")));    /** column 비과세소득_R11_비과세 : taxmSr11Bi */
				
				ye160403Vo.setKybdr(sessionUser.getUsrId());    															/** column 입력자 : kybdr */
				ye160403Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    						/** column 입력주소 : inptAddr */
				ye160403Vo.setIsmt(sessionUser.getUsrId());    																/** column 수정자 : ismt */
				ye160403Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    						/** column 수정주소 : revnAddr */
		    		
			ye160403DAO.updateYetaP33008ToYe160403(ye160403Vo); 
		          
		} catch (Exception ex) {
			logger.error("EXCEPTION calling activityOnYetaP33008ToYe160403(): "+ ex);

			/** 에러 로그 **/
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method,calledClass, actionDatabase.toString(), ex, windowNm,windowId);

			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnYetaP33008ToYe160403", ex, logger);
			
		} finally {

			
		}

		/**
		 * 로그반영 CRUDSBLO C:create R:read U:update D:delete S:select B:배치 L:로그인
		 * O:로그아웃
		 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,actionDatabase.toString());

		return result;
	}
	
	
	
	/** 현근무지비과세_비과세 감면소득 조회 **/
	public Ye160403DTO getYetaP33008ToYe160403List(Ye160403DTO ye160403Dto) throws MSFException {
		
		Ye160403Srh_2018_VO ye160403SrhVo = new Ye160403Srh_2018_VO();
		MSFSysm0100BM sessionUser;

		String method = calledClass + ".getYetaP33008ToYe160403List";

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETAP330008";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(ye160403DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
							.getSession().getServletContext());
			ye160403DAO = (Ye160403_2018_DAO) wac.getBean("Ye160403_2018_DAO");
		}
		

		/** 조건절 */
		
		ye160403SrhVo.setDpobCd(sessionUser.getDpobCd());    									/** column 사업장코드 : dpobCd */
		ye160403SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye160403Dto.getYrtxBlggYr()));	/** column 귀속연도 : yrtxBlggYr */
		ye160403SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(ye160403Dto.getClutSeptCd()));	/** column 연말정산구분코드 : clutSeptCd */
		ye160403SrhVo.setSystemkey(MSFSharedUtils.allowNulls(ye160403Dto.getSystemkey()));		/** column SYSTEMKEY : systemkey */
		ye160403SrhVo.setElctYymm(MSFSharedUtils.allowNulls(ye160403Dto.getElctYymm()));    	/** column 지급년월 : elctYymm */	
		

		Ye160403DTO returnYe160403Dto = new Ye160403DTO();
		List egovResultDataList = new ArrayList();

		try {

			egovResultDataList = ye160403DAO.selectYetaP33008ToYe160403List(ye160403SrhVo);
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());			

			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";

			if (egovResultDataList != null && egovResultDataList.size() > 0) {
				
				for (int i = 0; i < egovResultDataList.size(); i++) {
					 
					
					Map tempMap = (Map)egovResultDataList.get(i); 
					 
					returnYe160403Dto.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    								/** column 사업장코드 : dpobCd */
					returnYe160403Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(tempMap.get("yrtxBlggYr")));    						/** column 귀속연도 : yrtxBlggYr */
					returnYe160403Dto.setClutSeptCd(MSFSharedUtils.allowNulls(tempMap.get("clutSeptCd")));    						/** column 연말정산구분코드 : clutSeptCd */
					returnYe160403Dto.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));   	 						/** column SYSTEMKEY : systemkey */
					returnYe160403Dto.setElctYymm(MSFSharedUtils.allowNulls(tempMap.get("elctYymm")));    							/** column 지급년월 : elctYymm */
					
					returnYe160403Dto.setTaxmSa01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSa01Bi"),"0")));    /** column 비과세소득_A01_비과세 : taxmSa01Bi */
					returnYe160403Dto.setTaxmSb01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSb01Bi"),"0")));    /** column 비과세소득_B01_비과세 : taxmSb01Bi */
					returnYe160403Dto.setTaxmSc01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSc01Bi"),"0")));    /** column 비과세소득_C01_비과세 : taxmSc01Bi */
					returnYe160403Dto.setTaxmSd01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSd01Bi"),"0")));    /** column 비과세소득_D01_비과세 : taxmSd01Bi */
					returnYe160403Dto.setTaxmSe01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSe01Bi"),"0")));    /** column 비과세소득_E01_비과세 : taxmSe01Bi */
					returnYe160403Dto.setTaxmSe02Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSe02Bi"),"0")));    /** column 비과세소득_E02_비과세 : taxmSe02Bi */
					returnYe160403Dto.setTaxmSe10Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSe10Bi"),"0")));    /** column 비과세소득_E10_비과세 : taxmSe10Bi */
					returnYe160403Dto.setTaxmSf01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSf01Bi"),"0")));    /** column 비과세소득_F01_비과세 : taxmSf01Bi */
					returnYe160403Dto.setTaxmSg01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSg01Bi"),"0")));    /** column 비과세소득_G01_비과세 : taxmSg01Bi */
					returnYe160403Dto.setTaxmSh01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh01Bi"),"0")));    /** column 비과세소득_H01_비과세 : taxmSh01Bi */
					returnYe160403Dto.setTaxmSh02Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh02Bi"),"0")));    /** column 비과세소득_H02_비과세 : taxmSh02Bi */
					returnYe160403Dto.setTaxmSh03Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh03Bi"),"0")));    /** column 비과세소득_H03_비과세 : taxmSh03Bi */
					returnYe160403Dto.setTaxmSh04Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh04Bi"),"0")));    /** column 비과세소득_H04_비과세 : taxmSh04Bi */
					returnYe160403Dto.setTaxmSh05Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh05Bi"),"0")));    /** column 비과세소득_H05_비과세 : taxmSh05Bi */
					returnYe160403Dto.setTaxmSh06Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh06Bi"),"0")));    /** column 비과세소득_H06_비과세 : taxmSh06Bi */
					returnYe160403Dto.setTaxmSh07Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh07Bi"),"0")));    /** column 비과세소득_H07_비과세 : taxmSh07Bi */
					returnYe160403Dto.setTaxmSh08Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh08Bi"),"0")));    /** column 비과세소득_H08_비과세 : taxmSh08Bi */
					returnYe160403Dto.setTaxmSh09Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh09Bi"),"0")));    /** column 비과세소득_H09_비과세 : taxmSh09Bi */
					returnYe160403Dto.setTaxmSh10Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh10Bi"),"0")));    /** column 비과세소득_H10_비과세 : taxmSh10Bi */
					returnYe160403Dto.setTaxmSh14Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh14Bi"),"0")));    /** column 비과세소득_H14_비과세 : taxmSh14Bi */
					returnYe160403Dto.setTaxmSh15Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh15Bi"),"0")));    /** column 비과세소득_H15_비과세 : taxmSh15Bi */
					returnYe160403Dto.setTaxmSh11Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh11Bi"),"0")));    /** column 비과세소득_H11_비과세 : taxmSh11Bi */
					returnYe160403Dto.setTaxmSh12Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh12Bi"),"0")));    /** column 비과세소득_H12_비과세 : taxmSh12Bi */
					returnYe160403Dto.setTaxmSh13Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh13Bi"),"0")));    /** column 비과세소득_H13_비과세 : taxmSh13Bi */
					returnYe160403Dto.setTaxmSh16Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh16Bi"),"0")));    /** column 비과세소득_H16_비과세 : taxmSh16Bi */
					returnYe160403Dto.setTaxmSi01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSi01Bi"),"0")));    /** column 비과세소득_I01_비과세 : taxmSi01Bi */
					returnYe160403Dto.setTaxmSj01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSj01Bi"),"0")));    /** column 비과세소득_J01_비과세 : taxmSj01Bi */
					returnYe160403Dto.setTaxmSj10Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSj10Bi"),"0")));    /** column 비과세소득_J10_비과세 : taxmSj10Bi */
					returnYe160403Dto.setTaxmSk01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSk01Bi"),"0")));    /** column 비과세소득_K01_비과세 : taxmSk01Bi */
					returnYe160403Dto.setTaxmSl01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSl01Bi"),"0")));    /** column 비과세소득_L01_비과세 : taxmSl01Bi */
					returnYe160403Dto.setTaxmSm01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSm01Bi"),"0")));    /** column 비과세소득_M01_비과세 : taxmSm01Bi */
					returnYe160403Dto.setTaxmSm02Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSm02Bi"),"0")));    /** column 비과세소득_M02_비과세 : taxmSm02Bi */
					returnYe160403Dto.setTaxmSm03Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSm03Bi"),"0")));    /** column 비과세소득_M03_비과세 : taxmSm03Bi */
					returnYe160403Dto.setTaxmSn01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSn01Bi"),"0")));    /** column 비과세소득_N01_비과세 : taxmSn01Bi */
					returnYe160403Dto.setTaxmSo01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSo01Bi"),"0")));    /** column 비과세소득_O01_비과세 : taxmSo01Bi */
					returnYe160403Dto.setTaxmSp01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSp01Bi"),"0")));    /** column 비과세소득_P01_비과세 : taxmSp01Bi */
					returnYe160403Dto.setTaxmSp02Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSp02Bi"),"0")));    /** column 비과세소득_P02_비과세 : taxmSp02Bi */
					returnYe160403Dto.setTaxmSq01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSq01Bi"),"0")));    /** column 비과세소득_Q01_비과세 : taxmSq01Bi */
					returnYe160403Dto.setTaxmSr01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSr01Bi"),"0")));    /** column 비과세소득_R01_비과세 : taxmSr01Bi */
					returnYe160403Dto.setTaxmSr10Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSr10Bi"),"0")));    /** column 비과세소득_R10_비과세 : taxmSr10Bi */
					returnYe160403Dto.setTaxmSs01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSs01Bi"),"0")));    /** column 비과세소득_S01_비과세 : taxmSs01Bi */
					returnYe160403Dto.setTaxmSy02Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSy02Bi"),"0")));    /** column 비과세소득_Y02_비과세 : taxmSy02Bi */
					returnYe160403Dto.setTaxmSy03Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSy03Bi"),"0")));    /** column 비과세소득_Y03_비과세 : taxmSy03Bi */
					returnYe160403Dto.setTaxmSy04Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSy04Bi"),"0")));    /** column 비과세소득_Y04_비과세 : taxmSy04Bi */
					returnYe160403Dto.setTaxmSy21Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSy21Bi"),"0")));    /** column 비과세소득_Y21_비과세 : taxmSy21Bi */
					returnYe160403Dto.setTaxmSy22Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSy22Bi"),"0")));    /** column 비과세소득_Y22_비과세 : taxmSy22Bi */
					returnYe160403Dto.setTaxmSt01Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSt01Bi"),"0")));    /** column 감면소득_T01_비과세 : taxmSt01Bi */
					returnYe160403Dto.setTaxmSt10Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSt10Bi"),"0")));    /** column 감면소득_T10_비과세 : taxmSt10Bi */
					returnYe160403Dto.setTaxmSt11Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSt11Bi"),"0")));    /** column 감면소득_T11_비과세 : taxmSt11Bi */
					returnYe160403Dto.setTaxmSt12Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSt12Bi"),"0")));    /** column 감면소득_T12_비과세 : taxmSt12Bi */
					returnYe160403Dto.setTaxmSt20Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSt20Bi"),"0")));    /** column 감면소득_T20_비과세 : taxmSt20Bi */
					returnYe160403Dto.setTaxmSr11Bi(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSr11Bi"),"0")));    /** column 비과세소득_R11_비과세 : taxmSr11Bi */

					returnYe160403Dto.setTaxeTotl(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxeTotl"),"0")));
					returnYe160403Dto.setTaxmTotl(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmTotl"),"0")));
					
					
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
			
			// Return operation exception
		}
		
		/** 로그반영
		 * CRUDSBLO 
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");

		return returnYe160403Dto;

	}

}
