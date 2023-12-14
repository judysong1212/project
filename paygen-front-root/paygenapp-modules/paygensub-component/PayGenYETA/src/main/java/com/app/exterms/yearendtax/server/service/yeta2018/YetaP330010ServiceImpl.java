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

import com.app.exterms.yearendtax.client.dto.yeta2018.Ye160405DTO;
import com.app.exterms.yearendtax.client.service.yeta2018.YetaP330010Service;
import com.app.exterms.yearendtax.server.service.yeta2018.dao.Ye160404_2018_DAO;
import com.app.exterms.yearendtax.server.service.yeta2018.dao.Ye160405_2018_DAO;
import com.app.exterms.yearendtax.server.vo.Ye160405Srh_2018_VO;
import com.app.exterms.yearendtax.server.vo.Ye160405_2018_VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

@Service("YetaP330010Service")
public class YetaP330010ServiceImpl  extends AbstractCustomServiceImpl implements YetaP330010Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(YetaP330010ServiceImpl.class);
	private static final String calledClass = YetaP330010ServiceImpl.class.getName();
	
	
	@Autowired
	@Resource(name = "Ye160405_2018_DAO")
	private Ye160405_2018_DAO ye160405DAO;	
	
	
	
	/** 현근무지비과세_감면소득 팝업 저장 **/
	@Override
	public int activityOnYetaP330010ToYe160405(Ye160405DTO ye160405Dto, ActionDatabase actionDatabase) throws MSFException {
		
		// TODO Auto-generated method stub
		int  result = 0;
		Long iCnt = new Long(0);

		MSFSysm0100BM sessionUser;
		String method = calledClass + ".activityOnYetaP330010ToYe160405";

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETAP3300";
			
		Ye160405_2018_VO ye160405Vo = new Ye160405_2018_VO(); 
		
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		try {

			if (MSFSharedUtils.paramNull(ye160405DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				ye160405DAO = (Ye160405_2018_DAO) wac.getBean("Ye160405_2018_DAO"); 
			}
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		                
		            
				ye160405Vo.setDpobCd(MSFSharedUtils.allowNulls(ye160405Dto.getDpobCd()));    								/** column 사업장코드 : dpobCd */
				ye160405Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye160405Dto.getYrtxBlggYr()));    						/** column 귀속연도 : yrtxBlggYr */
				ye160405Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye160405Dto.getClutSeptCd()));    						/** column 연말정산구분코드 : clutSeptCd */
				ye160405Vo.setSystemkey(MSFSharedUtils.allowNulls(ye160405Dto.getSystemkey()));    							/** column SYSTEMKEY : systemkey */
				ye160405Vo.setWhdgDebrBusoprRgstnum(MSFSharedUtils.allowNulls(ye160405Dto.getWhdgDebrBusoprRgstnum()));		/** column D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
				
				ye160405Vo.setTaxmSa01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSa01Jong(),"0")));    /** column 비과세소득_A01_종전 : taxmSa01Jong */
				ye160405Vo.setTaxmSb01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSb01Jong(),"0")));    /** column 비과세소득_B01_종전 : taxmSb01Jong */
				ye160405Vo.setTaxmSc01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSc01Jong(),"0")));    /** column 비과세소득_C01_종전 : taxmSc01Jong */
				ye160405Vo.setTaxmSd01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSd01Jong(),"0")));    /** column 비과세소득_D01_종전 : taxmSd01Jong */
				ye160405Vo.setTaxmSe01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSe01Jong(),"0")));    /** column 비과세소득_E01_종전 : taxmSe01Jong */
				ye160405Vo.setTaxmSe02Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSe02Jong(),"0")));    /** column 비과세소득_E02_종전 : taxmSe02Jong */
				ye160405Vo.setTaxmSe10Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSe10Jong(),"0")));    /** column 비과세소득_E10_종전 : taxmSe10Jong */
				ye160405Vo.setTaxmSf01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSf01Jong(),"0")));    /** column 비과세소득_F01_종전 : taxmSf01Jong */
				ye160405Vo.setTaxmSg01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSg01Jong(),"0")));    /** column 비과세소득_G01_종전 : taxmSg01Jong */
				ye160405Vo.setTaxmSh01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh01Jong(),"0")));    /** column 비과세소득_H01_종전 : taxmSh01Jong */
				ye160405Vo.setTaxmSh02Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh02Jong(),"0")));    /** column 비과세소득_H02_종전 : taxmSh02Jong */
				ye160405Vo.setTaxmSh03Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh03Jong(),"0")));    /** column 비과세소득_H03_종전 : taxmSh03Jong */
				ye160405Vo.setTaxmSh04Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh04Jong(),"0")));    /** column 비과세소득_H04_종전 : taxmSh04Jong */
				ye160405Vo.setTaxmSh05Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh05Jong(),"0")));    /** column 비과세소득_H05_종전 : taxmSh05Jong */
				ye160405Vo.setTaxmSh06Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh06Jong(),"0")));    /** column 비과세소득_H06_종전 : taxmSh06Jong */
				ye160405Vo.setTaxmSh07Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh07Jong(),"0")));    /** column 비과세소득_H07_종전 : taxmSh07Jong */
				ye160405Vo.setTaxmSh08Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh08Jong(),"0")));    /** column 비과세소득_H08_종전 : taxmSh08Jong */
				ye160405Vo.setTaxmSh09Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh09Jong(),"0")));    /** column 비과세소득_H09_종전 : taxmSh09Jong */
				ye160405Vo.setTaxmSh10Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh10Jong(),"0")));    /** column 비과세소득_H10_종전 : taxmSh10Jong */
				ye160405Vo.setTaxmSh14Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh14Jong(),"0")));    /** column 비과세소득_H14_종전 : taxmSh14Jong */
				ye160405Vo.setTaxmSh15Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh15Jong(),"0")));    /** column 비과세소득_H15_종전 : taxmSh15Jong */
				ye160405Vo.setTaxmSh11Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh11Jong(),"0")));    /** column 비과세소득_H11_종전 : taxmSh11Jong */
				ye160405Vo.setTaxmSh12Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh12Jong(),"0")));    /** column 비과세소득_H12_종전 : taxmSh12Jong */
				ye160405Vo.setTaxmSh13Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh13Jong(),"0")));    /** column 비과세소득_H13_종전 : taxmSh13Jong */
				ye160405Vo.setTaxmSh16Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSh16Jong(),"0")));    /** column 비과세소득_H16_종전 : taxmSh16Jong */
				ye160405Vo.setTaxmSi01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSi01Jong(),"0")));    /** column 비과세소득_I01_종전 : taxmSi01Jong */
				ye160405Vo.setTaxmSj01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSj01Jong(),"0")));    /** column 비과세소득_J01_종전 : taxmSj01Jong */
				ye160405Vo.setTaxmSj10Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSj10Jong(),"0")));    /** column 비과세소득_J10_종전 : taxmSj10Jong */
				ye160405Vo.setTaxmSk01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSk01Jong(),"0")));    /** column 비과세소득_K01_종전 : taxmSk01Jong */
				ye160405Vo.setTaxmSl01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSl01Jong(),"0")));    /** column 비과세소득_L01_종전 : taxmSl01Jong */
				ye160405Vo.setTaxmSm01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSm01Jong(),"0")));    /** column 비과세소득_M01_종전 : taxmSm01Jong */
				ye160405Vo.setTaxmSm02Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSm02Jong(),"0")));    /** column 비과세소득_M02_종전 : taxmSm02Jong */
				ye160405Vo.setTaxmSm03Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSm03Jong(),"0")));    /** column 비과세소득_M03_종전 : taxmSm03Jong */
				ye160405Vo.setTaxmSn01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSn01Jong(),"0")));    /** column 비과세소득_N01_종전 : taxmSn01Jong */
				ye160405Vo.setTaxmSo01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSo01Jong(),"0")));    /** column 비과세소득_O01_종전 : taxmSo01Jong */
				ye160405Vo.setTaxmSp01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSp01Jong(),"0")));    /** column 비과세소득_P01_종전 : taxmSp01Jong */
				ye160405Vo.setTaxmSp02Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSp02Jong(),"0")));    /** column 비과세소득_P02_종전 : taxmSp02Jong */
				ye160405Vo.setTaxmSq01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSq01Jong(),"0")));    /** column 비과세소득_Q01_종전 : taxmSq01Jong */
				ye160405Vo.setTaxmSr01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSr01Jong(),"0")));    /** column 비과세소득_R01_종전 : taxmSr01Jong */
				ye160405Vo.setTaxmSr10Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSr10Jong(),"0")));    /** column 비과세소득_R10_종전 : taxmSr10Jong */
				ye160405Vo.setTaxmSs01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSs01Jong(),"0")));    /** column 비과세소득_S01_종전 : taxmSs01Jong */
				ye160405Vo.setTaxmSy02Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSy02Jong(),"0")));    /** column 비과세소득_Y02_종전 : taxmSy02Jong */
				ye160405Vo.setTaxmSy03Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSy03Jong(),"0")));    /** column 비과세소득_Y03_종전 : taxmSy03Jong */
				ye160405Vo.setTaxmSy04Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSy04Jong(),"0")));    /** column 비과세소득_Y04_종전 : taxmSy04Jong */
				ye160405Vo.setTaxmSy21Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSy21Jong(),"0")));    /** column 비과세소득_Y21_종전 : taxmSy21Jong */
				ye160405Vo.setTaxmSy22Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSy22Jong(),"0")));    /** column 비과세소득_Y22_종전 : taxmSy22Jong */
				ye160405Vo.setTaxmSt01Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSt01Jong(),"0")));    /** column 감면소득_T01_종전 : taxmSt01Jong */
				ye160405Vo.setTaxmSt10Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSt10Jong(),"0")));    /** column 감면소득_T10_종전 : taxmSt10Jong */
				ye160405Vo.setTaxmSt11Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSt11Jong(),"0")));    /** column 감면소득_T11_종전 : taxmSt11Jong */
				ye160405Vo.setTaxmSt12Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSt12Jong(),"0")));    /** column 감면소득_T12_종전 : taxmSt12Jong */
				ye160405Vo.setTaxmSt20Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSt20Jong(),"0")));    /** column 감면소득_T20_종전 : taxmSt20Jong */
				ye160405Vo.setTaxmSr11Jong(new BigDecimal(MSFSharedUtils.defaultNulls(ye160405Dto.getTaxmSr11Jong(),"0")));    /** column 비과세소득_R11_종전 : taxmSr11Jong */
				
				ye160405Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
				ye160405Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
				ye160405Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
				ye160405Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */
		    	
				result = ye160405DAO.updateYetaP330010ToYe160405(ye160405Vo); 
		          
		} catch (Exception ex) {
			logger.error("EXCEPTION calling activityOnYetaP330010ToYe160405(): "+ ex);

			/** 에러 로그 **/
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method,calledClass, actionDatabase.toString(), ex, windowNm,windowId);

			result = 0;
			throw MSFServerUtils.getOperationException("activityOnYetaP330010ToYe160405", ex, logger);
			
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
	public Ye160405DTO getYetaP330010ToYe160405List(Ye160405DTO ye160405Dto) throws MSFException {
		
		Ye160405Srh_2018_VO ye160405SrhVo = new Ye160405Srh_2018_VO();
		MSFSysm0100BM sessionUser;

		String method = calledClass + ".getYetaP330010ToYe160405List";

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETAP330008";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(ye160405DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
							.getSession().getServletContext());
			ye160405DAO = (Ye160405_2018_DAO) wac.getBean("Ye160405_2018_DAO");
		}
		

		/** 조건절 */
		
		ye160405SrhVo.setDpobCd(sessionUser.getDpobCd());    														/** column 사업장코드 : dpobCd */
		ye160405SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye160405Dto.getYrtxBlggYr()));						/** column 귀속연도 : yrtxBlggYr */
		ye160405SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(ye160405Dto.getClutSeptCd()));						/** column 연말정산구분코드 : clutSeptCd */
		ye160405SrhVo.setSystemkey(MSFSharedUtils.allowNulls(ye160405Dto.getSystemkey()));							/** column SYSTEMKEY : systemkey */
		ye160405SrhVo.setWhdgDebrBusoprRgstnum(MSFSharedUtils.allowNulls(ye160405Dto.getWhdgDebrBusoprRgstnum()));	/** column D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
		

		Ye160405DTO returnYe160405Dto = new Ye160405DTO();
		List egovResultDataList = new ArrayList();

		try {

			egovResultDataList = ye160405DAO.selectYetaP330010ToYe160405List(ye160405SrhVo);
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());			

			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";

			if (egovResultDataList != null && egovResultDataList.size() > 0) {
				
				for (int i = 0; i < egovResultDataList.size(); i++) {
					 
					
					Map tempMap = (Map)egovResultDataList.get(i); 
					 
					returnYe160405Dto.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    								/** column 사업장코드 : dpobCd */
					returnYe160405Dto.setYrtxBlggYr(MSFSharedUtils.allowNulls(tempMap.get("yrtxBlggYr")));    						/** column 귀속연도 : yrtxBlggYr */
					returnYe160405Dto.setClutSeptCd(MSFSharedUtils.allowNulls(tempMap.get("clutSeptCd")));    						/** column 연말정산구분코드 : clutSeptCd */
					returnYe160405Dto.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));   	 						/** column SYSTEMKEY : systemkey */
					returnYe160405Dto.setWhdgDebrBusoprRgstnum(MSFSharedUtils.allowNulls(tempMap.get("whdgDebrBusoprRgstnum")));    /** column D5_원천징수의무자사업자등록번호 : whdgDebrBusoprRgstnum */
					
					returnYe160405Dto.setTaxmSa01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSa01Jong"),"0")));    /** column 비과세소득_A01_종전 : taxmSa01Jong */
					returnYe160405Dto.setTaxmSb01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSb01Jong"),"0")));    /** column 비과세소득_B01_종전 : taxmSb01Jong */
					returnYe160405Dto.setTaxmSc01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSc01Jong"),"0")));    /** column 비과세소득_C01_종전 : taxmSc01Jong */
					returnYe160405Dto.setTaxmSd01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSd01Jong"),"0")));    /** column 비과세소득_D01_종전 : taxmSd01Jong */
					returnYe160405Dto.setTaxmSe01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSe01Jong"),"0")));    /** column 비과세소득_E01_종전 : taxmSe01Jong */
					returnYe160405Dto.setTaxmSe02Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSe02Jong"),"0")));    /** column 비과세소득_E02_종전 : taxmSe02Jong */
					returnYe160405Dto.setTaxmSe10Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSe10Jong"),"0")));    /** column 비과세소득_E10_종전 : taxmSe10Jong */
					returnYe160405Dto.setTaxmSf01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSf01Jong"),"0")));    /** column 비과세소득_F01_종전 : taxmSf01Jong */
					returnYe160405Dto.setTaxmSg01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSg01Jong"),"0")));    /** column 비과세소득_G01_종전 : taxmSg01Jong */
					returnYe160405Dto.setTaxmSh01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh01Jong"),"0")));    /** column 비과세소득_H01_종전 : taxmSh01Jong */
					returnYe160405Dto.setTaxmSh02Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh02Jong"),"0")));    /** column 비과세소득_H02_종전 : taxmSh02Jong */
					returnYe160405Dto.setTaxmSh03Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh03Jong"),"0")));    /** column 비과세소득_H03_종전 : taxmSh03Jong */
					returnYe160405Dto.setTaxmSh04Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh04Jong"),"0")));    /** column 비과세소득_H04_종전 : taxmSh04Jong */
					returnYe160405Dto.setTaxmSh05Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh05Jong"),"0")));    /** column 비과세소득_H05_종전 : taxmSh05Jong */
					returnYe160405Dto.setTaxmSh06Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh06Jong"),"0")));    /** column 비과세소득_H06_종전 : taxmSh06Jong */
					returnYe160405Dto.setTaxmSh07Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh07Jong"),"0")));    /** column 비과세소득_H07_종전 : taxmSh07Jong */
					returnYe160405Dto.setTaxmSh08Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh08Jong"),"0")));    /** column 비과세소득_H08_종전 : taxmSh08Jong */
					returnYe160405Dto.setTaxmSh09Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh09Jong"),"0")));    /** column 비과세소득_H09_종전 : taxmSh09Jong */
					returnYe160405Dto.setTaxmSh10Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh10Jong"),"0")));    /** column 비과세소득_H10_종전 : taxmSh10Jong */
					returnYe160405Dto.setTaxmSh14Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh14Jong"),"0")));    /** column 비과세소득_H14_종전 : taxmSh14Jong */
					returnYe160405Dto.setTaxmSh15Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh15Jong"),"0")));    /** column 비과세소득_H15_종전 : taxmSh15Jong */
					returnYe160405Dto.setTaxmSh11Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh11Jong"),"0")));    /** column 비과세소득_H11_종전 : taxmSh11Jong */
					returnYe160405Dto.setTaxmSh12Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh12Jong"),"0")));    /** column 비과세소득_H12_종전 : taxmSh12Jong */
					returnYe160405Dto.setTaxmSh13Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh13Jong"),"0")));    /** column 비과세소득_H13_종전 : taxmSh13Jong */
					returnYe160405Dto.setTaxmSh16Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSh16Jong"),"0")));    /** column 비과세소득_H16_종전 : taxmSh16Jong */
					returnYe160405Dto.setTaxmSi01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSi01Jong"),"0")));    /** column 비과세소득_I01_종전 : taxmSi01Jong */
					returnYe160405Dto.setTaxmSj01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSj01Jong"),"0")));    /** column 비과세소득_J01_종전 : taxmSj01Jong */
					returnYe160405Dto.setTaxmSj10Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSj10Jong"),"0")));    /** column 비과세소득_J10_종전 : taxmSj10Jong */
					returnYe160405Dto.setTaxmSk01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSk01Jong"),"0")));    /** column 비과세소득_K01_종전 : taxmSk01Jong */
					returnYe160405Dto.setTaxmSl01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSl01Jong"),"0")));    /** column 비과세소득_L01_종전 : taxmSl01Jong */
					returnYe160405Dto.setTaxmSm01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSm01Jong"),"0")));    /** column 비과세소득_M01_종전 : taxmSm01Jong */
					returnYe160405Dto.setTaxmSm02Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSm02Jong"),"0")));    /** column 비과세소득_M02_종전 : taxmSm02Jong */
					returnYe160405Dto.setTaxmSm03Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSm03Jong"),"0")));    /** column 비과세소득_M03_종전 : taxmSm03Jong */
					returnYe160405Dto.setTaxmSn01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSn01Jong"),"0")));    /** column 비과세소득_N01_종전 : taxmSn01Jong */
					returnYe160405Dto.setTaxmSo01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSo01Jong"),"0")));    /** column 비과세소득_O01_종전 : taxmSo01Jong */
					returnYe160405Dto.setTaxmSp01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSp01Jong"),"0")));    /** column 비과세소득_P01_종전 : taxmSp01Jong */
					returnYe160405Dto.setTaxmSp02Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSp02Jong"),"0")));    /** column 비과세소득_P02_종전 : taxmSp02Jong */
					returnYe160405Dto.setTaxmSq01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSq01Jong"),"0")));    /** column 비과세소득_Q01_종전 : taxmSq01Jong */
					returnYe160405Dto.setTaxmSr01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSr01Jong"),"0")));    /** column 비과세소득_R01_종전 : taxmSr01Jong */
					returnYe160405Dto.setTaxmSr10Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSr10Jong"),"0")));    /** column 비과세소득_R10_종전 : taxmSr10Jong */
					returnYe160405Dto.setTaxmSs01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSs01Jong"),"0")));    /** column 비과세소득_S01_종전 : taxmSs01Jong */
					returnYe160405Dto.setTaxmSy02Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSy02Jong"),"0")));    /** column 비과세소득_Y02_종전 : taxmSy02Jong */
					returnYe160405Dto.setTaxmSy03Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSy03Jong"),"0")));    /** column 비과세소득_Y03_종전 : taxmSy03Jong */
					returnYe160405Dto.setTaxmSy04Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSy04Jong"),"0")));    /** column 비과세소득_Y04_종전 : taxmSy04Jong */
					returnYe160405Dto.setTaxmSy21Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSy21Jong"),"0")));    /** column 비과세소득_Y21_종전 : taxmSy21Jong */
					returnYe160405Dto.setTaxmSy22Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSy22Jong"),"0")));    /** column 비과세소득_Y22_종전 : taxmSy22Jong */
					returnYe160405Dto.setTaxmSt01Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSt01Jong"),"0")));    /** column 감면소득_T01_종전 : taxmSt01Jong */
					returnYe160405Dto.setTaxmSt10Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSt10Jong"),"0")));    /** column 감면소득_T10_종전 : taxmSt10Jong */
					returnYe160405Dto.setTaxmSt11Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSt11Jong"),"0")));    /** column 감면소득_T11_종전 : taxmSt11Jong */
					returnYe160405Dto.setTaxmSt12Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSt12Jong"),"0")));    /** column 감면소득_T12_종전 : taxmSt12Jong */
					returnYe160405Dto.setTaxmSt20Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSt20Jong"),"0")));    /** column 감면소득_T20_종전 : taxmSt20Jong */
					returnYe160405Dto.setTaxmSr11Jong(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmSr11Jong"),"0")));    /** column 비과세소득_R11_종전 : taxmSr11Jong */

					returnYe160405Dto.setTaxeTotl(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxeTotl"),"0")));
					returnYe160405Dto.setTaxmTotl(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmTotl"),"0")));
					
					
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

		return returnYe160405Dto;

	}

}
