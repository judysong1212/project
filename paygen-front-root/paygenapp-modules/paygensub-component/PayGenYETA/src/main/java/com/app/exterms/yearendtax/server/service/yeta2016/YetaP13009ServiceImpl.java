package com.app.exterms.yearendtax.server.service.yeta2016;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3210DTO;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP13009Service;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3210DAO;
import com.app.exterms.yearendtax.server.vo.Yeta3210VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

@Service("YetaP13009Service")
public class YetaP13009ServiceImpl  extends AbstractCustomServiceImpl implements YetaP13009Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(YetaP13009ServiceImpl.class);
	private static final String calledClass = YetaP13009ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "Ye16Ta3210DAO")
	private Ye16Ta3210DAO yeta3210DAO;	
	

	@Override
	public Long activityOnYetaP13009ToYeta3210(List<Ye16Ta3210DTO> listYeta3210dto, ActionDatabase actionDatabase) throws MSFException {
		
		String method = calledClass + ".activityOnYetaP13009ToYeta3210";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETAP130009";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Long result = new Long(0);
		Long iCnt = new Long(0);
			MSFSysm0100BM sessionUser;
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
			
		try {  
			if (MSFSharedUtils.paramNull(yeta3210DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				yeta3210DAO = (Ye16Ta3210DAO) wac.getBean("Ye16Ta3210DAO" ); 
			}
		            
			for(int iPsnlCnt=0;iPsnlCnt < listYeta3210dto.size();iPsnlCnt++) {
		                
					Ye16Ta3210DTO yeta3210Dto = new Ye16Ta3210DTO();  
					yeta3210Dto = listYeta3210dto.get(iPsnlCnt);
		                 
		            Yeta3210VO yeta3210Vo = new Yeta3210VO();  	            
		            
		            yeta3210Vo.setDpobCd(MSFSharedUtils.allowNulls(yeta3210Dto.getDpobCd()));    	/** column 사업장코드 : dpobCd */
		            yeta3210Vo.setSystemkey(MSFSharedUtils.allowNulls(yeta3210Dto.getSystemkey()));	/** column SYSTEMKEY : systemkey */
		            yeta3210Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta3210Dto.getEdacRvyy()));   /** column 연말정산귀속년도 : edacRvyy */
		            yeta3210Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta3210Dto.getSettGbcd()));   /** column 정산구분코드 : settGbcd */
		           
		            yeta3210Vo.setElctYymm(MSFSharedUtils.allowNulls(yeta3210Dto.getSettGbcd()));	/** column 지급년월 : elctYymm */
		            yeta3210Vo.setElctDate(MSFSharedUtils.allowNulls(yeta3210Dto.getElctDate()));	/** column 급여지급일자 : elctDate */
		            yeta3210Vo.setSuprTxam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getSuprTxam(),"0")));	/** column 급여지급금액_과세 : suprTxam */
		            yeta3210Vo.setBuamTxam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getBuamTxam(),"0")));	/** column 상여금_과세 : buamTxam */
		            yeta3210Vo.setInbsAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getInbsAmnt(),"0")));	/** column 인정상여금액 : inbsAmnt */
		            yeta3210Vo.setStckInam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getStckInam(),"0")));	/** column 주식행사이익금액 : stckInam */
		            yeta3210Vo.setSpbmTxam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getSpbmTxam(),"0")));	/** column 급여_상여합계금액 : spbmTxam */
		            yeta3210Vo.setEcinTxam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getEcinTxam(),"0")));	/** column 외국인소득금액_과세 : ecinTxam */
		            yeta3210Vo.setTaxmEcin(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getTaxmEcin(),"0")));	/** column 외국인소득금액_비과세 : taxmEcin */
		            yeta3210Vo.setEarnTaxn(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getEarnTaxn(),"0")));	/** column 자가운전보조금_비과세 : taxmEarn */
		            yeta3210Vo.setTaxmEtam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getTaxmEtam(),"0")));	/** column 정액급식비_비과세 : taxmEtam */
		            yeta3210Vo.setTxetTxam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getTxetTxam(),"0")));	/** column 정액급식비_과세 : txetTxam */
		            yeta3210Vo.setAddrBhtx(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getAddrBhtx(),"0")));	/** column 출산보육수당_비과세 : addrBhtx */
		            yeta3210Vo.setSpciHlth(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getSpciHlth(),"0")));	/** column 건강보험료금액 : spciHlth */
		            yeta3210Vo.setSpciEmpf(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getSpciEmpf(),"0")));	/** column 고용보험료금액 : spciEmpf */
		            yeta3210Vo.setNatnPsnf(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getNatnPsnf(),"0")));	/** column 국민연금금액 : natnPsnf */
		            yeta3210Vo.setEarnTaxn(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getEarnTaxn(),"0")));	/** column 소득세 : earnTaxn */
		            yeta3210Vo.setIhtxTaxn(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getIhtxTaxn(),"0")));	/** column 지방소득세 : ihtxTaxn */
		            yeta3210Vo.setEtccTxam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getEtccTxam(),"0")));	/** column 기타금액_과세 : etccTxam */
		            yeta3210Vo.setEtccEtam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3210Dto.getEtccEtam(),"0")));	/** column 기타금액_비과세 : etccEtam */
		            
		            yeta3210Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
//		            yeta3210Vo.setInptDt(MSFSharedUtils.allowNulls(yeta3100Dto.getinptDt));    /** column 입력일자 : inptDt */
		            yeta3210Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */ 
//		            yeta3210Vo.setIsmt(MSFSharedUtils.allowNulls(yeta3100Dto.getismt));    /** column 수정자 : ismt */
//		            yeta3210Vo.setRevnDt(MSFSharedUtils.allowNulls(yeta3100Dto.getrevnDt));    /** column 수정일자 : revnDt */
//		            yeta3210Vo.setRevnAddr(MSFSharedUtils.allowNulls(yeta3100Dto.getrevnAddr));    /** column 수정주소 : revnAddr */
		             
		            
		        	switch (actionDatabase) {
		        		case INSERT:
		        			yeta3210DAO.insertYetaP03009To3210(yeta3210Vo); 
		        			break;
		            	case UPDATE: 
		            		yeta3210DAO.updateYetaP03009To3210(yeta3210Vo); 
		            		break;
		            	case DELETE: 
		            		yeta3210DAO.deleteYetaP03009To3210(yeta3210Vo); 
		            		break;
		        	} 
		        		iCnt = iCnt + 1; 
		                    
				} 
				result = iCnt;
		          
		        } catch (Exception ex) {
		            logger.error("EXCEPTION calling activityOnYetaP13009ToYeta3210(): "+ex); 
		            
		            /** 에러 로그 **/			
		            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), ex, windowNm , windowId);
		            
		            result = new Long(0);
		            throw MSFServerUtils.getOperationException("activityOnYetaP13009ToYeta3210", ex, logger);
		        }
		        finally {
		          
		        }
		
		
				/** 로그반영
				 * CRUDSBLO
				 * C:create		R:read		U:update
		    	 * D:delete		S:select	B:배치 
		    	 * L:로그인		O:로그아웃
		    	 */
				MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
				
				return result;
		}
}