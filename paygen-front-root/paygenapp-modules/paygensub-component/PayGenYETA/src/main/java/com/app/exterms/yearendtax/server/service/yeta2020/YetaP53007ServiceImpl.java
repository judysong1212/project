package com.app.exterms.yearendtax.server.service.yeta2020;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.yearendtax.client.dto.yeta2020.Ye162010DTO;
import com.app.exterms.yearendtax.client.service.yeta2020.YetaP53007Service;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye162010_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye162020_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye162030_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye162040_2020_DAO;
import com.app.exterms.yearendtax.server.vo.Ye162010Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye162010_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye162020_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye162030_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye162040_2020_VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.pkg.listener.yeta.yeta2020.Yeta5300ListenerAdapter;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;


@Service("YetaP53007Service")
public class YetaP53007ServiceImpl  extends AbstractCustomServiceImpl implements YetaP53007Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(YetaP53007ServiceImpl.class);
	private static final String calledClass = YetaP53007ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "Ye162010_2020_DAO")
	private Ye162010_2020_DAO ye162010DAO;
	
	@Autowired
	@Resource(name = "Ye162020_2020_DAO")
	private Ye162020_2020_DAO ye162020DAO;
	
	@Autowired
	@Resource(name = "Ye162030_2020_DAO")
	private Ye162030_2020_DAO ye162030DAO;
	
	@Autowired
	@Resource(name = "Ye162040_2020_DAO")
	private Ye162040_2020_DAO ye162040DAO;
	
	/** 연금저축소득공제 등록 팝업 수정 및 삭제 **/
	@Override
	public Long activityOnYetaP53007ToYe162010(List<Ye162010DTO> listYe162010Dto, ActionDatabase actionDatabase) throws MSFException {
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		BigDecimal seqn = new BigDecimal(0);
		
		MSFSysm0100BM sessionUser;
		String method = calledClass + ".activityOnYetaP53007ToYe162010";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETAP530007";
		
		
		Ye162010DTO ye162010Dto = new Ye162010DTO();  
		Ye162010_2020_VO ye162010Vo = new Ye162010_2020_VO();  
		Ye162020_2020_VO ye162020Vo = new Ye162020_2020_VO();  
		Ye162030_2020_VO ye162030Vo = new Ye162030_2020_VO();  
		Ye162040_2020_VO ye162040Vo = new Ye162040_2020_VO();  
		
		InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO(); 
		Yeta5300ListenerAdapter  Yeta5300ListenerAdt = new Yeta5300ListenerAdapter();


		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
			
		try { 
			
			
			if (MSFSharedUtils.paramNull(ye162010DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

				ye162010DAO = (Ye162010_2020_DAO) wac.getBean("Ye162010_2020_DAO" ); 
			}
			
			if (MSFSharedUtils.paramNull(ye162020DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				
				ye162020DAO = (Ye162020_2020_DAO) wac.getBean("Ye162020_2020_DAO" ); 
			}
			
			if (MSFSharedUtils.paramNull(ye162030DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				
				ye162030DAO = (Ye162030_2020_DAO) wac.getBean("Ye162030_2020_DAO" ); 
			}
			
			if (MSFSharedUtils.paramNull(ye162040DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				
				ye162040DAO = (Ye162040_2020_DAO) wac.getBean("Ye162040_2020_DAO" ); 
			}
		            
			for(int iPsnlCnt=0;iPsnlCnt < listYe162010Dto.size();iPsnlCnt++) {
		                

				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

				
				ye162010Dto = new Ye162010DTO();
				ye162010Dto = listYe162010Dto.get(iPsnlCnt);

				ye162010Vo = new   Ye162010_2020_VO();  
		            
		        ye162010Vo.setDpobCd(sessionUser.getDpobCd());    																		/** column 사업장코드 : dpobCd */
		        ye162010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye162010Dto.getYrtxBlggYr()));    									/** column 귀속년도 : yrtxBlggYr */
		        ye162010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye162010Dto.getClutSeptCd()));    									/** column 연말정산구분코드 : clutSeptCd */
		        ye162010Vo.setSystemkey(MSFSharedUtils.allowNulls(ye162010Dto.getSystemkey()));    										/** column SYSTEMKEY : systemkey */
		        ye162010Vo.setPnsnSvngAccAccno(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngAccAccno()));    						/** column 계좌번호_증권번호 : pnsnSvngAccAccno */
		        ye162010Vo.setTaxVvalKrnCd(MSFSharedUtils.allowNulls(ye162010Dto.getTaxVvalKrnCd()));   								/** column 국세청자료구분코드 : taxVvalKrnCd */
		        
		        
		        ye162010Vo.setPnsnSvngAccPnsnSvngCl(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngAccPnsnSvngCl()));   				/** column 연금저축소득공제구분코드 : pnsnSvngAccPnsnSvngCl */
		        ye162010Vo.setPnsnSvngFnnOrgnCd(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngFnnOrgnCd()));    						/** column 연금저축금융기관코드 : pnsnSvngFnnOrgnCd */
		        ye162010Vo.setPnsnSvngAccFnnCmp(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngAccFnnCmp()));    						/** column 굼융회사등명 : pnsnSvngAccFnnCmp */
		        ye162010Vo.setPnsnSvngAccPymAmt( new BigDecimal(MSFSharedUtils.defaultNulls(ye162010Dto.getPnsnSvngAccPymAmt(), "0"))); /** column 연금저축계좌납입금액 : pnsnSvngAccPymAmt */
		        ye162010Vo.setIpnsnSvngAccddcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye162010Dto.getIpnsnSvngAccddcAmt(), "0")));/** column 연금저축계좌세액공제금액 : ipnsnSvngAccddcAmt */

		        ye162010Vo.setPnsnSvngAccTgtAmt(new BigDecimal("0"));	   
		        ye162010Vo.setIsmt(sessionUser.getUsrId());																				/** column 수정자 : ismt */
		        ye162010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 										/** column 수정주소 : revnAddr */
		        
		        ye162020Vo.setDpobCd(sessionUser.getDpobCd());    																		/** column 사업장코드 : dpobCd */
		        ye162020Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye162010Dto.getYrtxBlggYr()));    									/** column 귀속년도 : yrtxBlggYr */
		        ye162020Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye162010Dto.getClutSeptCd()));    									/** column 연말정산구분코드 : clutSeptCd */
		        ye162020Vo.setSystemkey(MSFSharedUtils.allowNulls(ye162010Dto.getSystemkey()));    										/** column SYSTEMKEY : systemkey */
		        ye162020Vo.setRtpnAccAccno(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngAccAccno()));    						/** column 계좌번호_증권번호 : pnsnSvngAccAccno */
		        ye162020Vo.setTaxVvalKrnCd(MSFSharedUtils.allowNulls(ye162010Dto.getTaxVvalKrnCd()));   								/** column 국세청자료구분코드 : taxVvalKrnCd */

		        ye162020Vo.setRtpnAccRtpnCl(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngAccPnsnSvngCl()));   				/** column 연금저축소득공제구분코드 : pnsnSvngAccPnsnSvngCl */
		        ye162020Vo.setRtpnFnnOrgnCd(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngFnnOrgnCd()));    						/** column 연금저축금융기관코드 : pnsnSvngFnnOrgnCd */
		        ye162020Vo.setRtpnAccFnnCmp(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngAccFnnCmp()));    						/** column 굼융회사등명 : pnsnSvngAccFnnCmp */
		        ye162020Vo.setRtpnAccPymAmt( new BigDecimal(MSFSharedUtils.defaultNulls(ye162010Dto.getPnsnSvngAccPymAmt(), "0"))); /** column 연금저축계좌납입금액 : pnsnSvngAccPymAmt */
		        ye162020Vo.setRtpnAccTxamtDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye162010Dto.getIpnsnSvngAccddcAmt(), "0")));/** column 연금저축계좌세액공제금액 : ipnsnSvngAccddcAmt */

		        ye162020Vo.setRtpnAccTgtAmt(new BigDecimal("0"));
		        ye162020Vo.setIsmt(sessionUser.getUsrId());																				/** column 수정자 : ismt */
		        ye162020Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 
		        
		        ye162030Vo.setDpobCd(sessionUser.getDpobCd());    																		/** column 사업장코드 : dpobCd */
		        ye162030Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye162010Dto.getYrtxBlggYr()));    									/** column 귀속년도 : yrtxBlggYr */
		        ye162030Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye162010Dto.getClutSeptCd()));    									/** column 연말정산구분코드 : clutSeptCd */
		        ye162030Vo.setSystemkey(MSFSharedUtils.allowNulls(ye162010Dto.getSystemkey()));    										/** column SYSTEMKEY : systemkey */
		        ye162030Vo.setHsngPrptSvngAccNo(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngAccAccno()));    						/** column 계좌번호_증권번호 : pnsnSvngAccAccno */
		        ye162030Vo.setTaxVvalKrnCd(MSFSharedUtils.allowNulls(ye162010Dto.getTaxVvalKrnCd()));   								/** column 국세청자료구분코드 : taxVvalKrnCd */
		        
		        ye162030Vo.setHsngPrptSvngSvngCl(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngAccPnsnSvngCl()));   				/** column 연금저축소득공제구분코드 : pnsnSvngAccPnsnSvngCl */
		        ye162030Vo.setHsngPrptSvngFnnOrgnCd(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngFnnOrgnCd()));    						/** column 연금저축금융기관코드 : pnsnSvngFnnOrgnCd */
		        ye162030Vo.setHsngPrptSvngFnnCmp(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngAccFnnCmp()));    						/** column 굼융회사등명 : pnsnSvngAccFnnCmp */
		        ye162030Vo.setHsngPrptSvngPymAmt( new BigDecimal(MSFSharedUtils.defaultNulls(ye162010Dto.getPnsnSvngAccPymAmt(), "0"))); /** column 연금저축계좌납입금액 : pnsnSvngAccPymAmt */
		        ye162030Vo.setHsngPrptSvngIncDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye162010Dto.getIpnsnSvngAccddcAmt(), "0")));/** column 연금저축계좌세액공제금액 : ipnsnSvngAccddcAmt */
		        
		        ye162030Vo.setHsngPrptSvngTgtAmt(new BigDecimal("0"));
		        ye162030Vo.setIsmt(sessionUser.getUsrId());																				/** column 수정자 : ismt */
		        ye162030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 
		        		        
		        ye162040Vo.setDpobCd(sessionUser.getDpobCd());    																		/** column 사업장코드 : dpobCd */
		        ye162040Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye162010Dto.getYrtxBlggYr()));    									/** column 귀속년도 : yrtxBlggYr */
		        ye162040Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye162010Dto.getClutSeptCd()));    									/** column 연말정산구분코드 : clutSeptCd */
		        ye162040Vo.setSystemkey(MSFSharedUtils.allowNulls(ye162010Dto.getSystemkey()));    										/** column SYSTEMKEY : systemkey */
		        ye162040Vo.setLtrmCniSsAccno(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngAccAccno()));    						/** column 계좌번호_증권번호 : pnsnSvngAccAccno */
		        ye162040Vo.setTaxVvalKrnCd(MSFSharedUtils.allowNulls(ye162010Dto.getTaxVvalKrnCd()));   								/** column 국세청자료구분코드 : taxVvalKrnCd */
		        
		        ye162040Vo.setLtrmCniSsfnnCl(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngAccPnsnSvngCl()));   				/** column 연금저축소득공제구분코드 : pnsnSvngAccPnsnSvngCl */
		        ye162040Vo.setLtrmCniSsfnnOrgnCd(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngFnnOrgnCd()));    						/** column 연금저축금융기관코드 : pnsnSvngFnnOrgnCd */
		        ye162040Vo.setLtrmCniSsFnnCmp(MSFSharedUtils.allowNulls(ye162010Dto.getPnsnSvngAccFnnCmp()));    						/** column 굼융회사등명 : pnsnSvngAccFnnCmp */
		        ye162040Vo.setLtrmCniSsPymAmt( new BigDecimal(MSFSharedUtils.defaultNulls(ye162010Dto.getPnsnSvngAccPymAmt(), "0"))); /** column 연금저축계좌납입금액 : pnsnSvngAccPymAmt */
		        ye162040Vo.setLtrmCniSsIncDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye162010Dto.getIpnsnSvngAccddcAmt(), "0")));/** column 연금저축계좌세액공제금액 : ipnsnSvngAccddcAmt */
		        
		        ye162040Vo.setIsmt(sessionUser.getUsrId());																				/** column 수정자 : ismt */
		        ye162040Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 
		        
		        switch (actionDatabase) {
        		case INSERT:
        			if (ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040010")||ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040020")) {
        			    ye162020DAO.insertYe162020(ye162020Vo);
        			} 
        			else if (ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040050")||ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040060")
        					||ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040080")) {
        				ye162030DAO.insertYe162030(ye162030Vo);
        			}
        			else if (ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040110")) {
        				ye162040DAO.insertYe162040(ye162040Vo);
        			}
        			else {
        				ye162010Vo.setIsmt(sessionUser.getUsrId());																			/** column 수정자 : ismt */
            			ye162010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 									/** column 수정주소 : revnAddr */
            			
            			ye162010DAO.insertYetaP53007ToYe162010(ye162010Vo); 
        			}
        			
        			break;
            	case UPDATE:
            		
            		if (ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040010")||ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040020")) {
       			     	ye162020DAO.updateYe162020(ye162020Vo);
            		}
            		else if (ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040050")||ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040060")
        					||ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040080")) {
            			ye162030DAO.updateYe162030(ye162030Vo);
        			}
            		else {
            			ye162010DAO.updateYetaP53007ToYe162010(ye162010Vo);
            		}
        			
            		break;
            		
            	case DELETE: 
            		if (ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040010")||ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040020")) {
          			     ye162020DAO.deleteYe162020(ye162020Vo);
               		}
            		else if (ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040050")||ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040060")
        					||ye162010Vo.getPnsnSvngAccPnsnSvngCl().equals("Y0040080")) {
            			ye162030DAO.deleteYe162030(ye162030Vo);
        			}
            		else {
            			 ye162010DAO.deleteYetaP53007ToYe162010(ye162010Vo); 
            		}
            		
            		break;
		        } 
		        
		            
		        iCnt = iCnt + 1; 
		        
		    	BeanUtils.copyProperties(infcPkgYe161010Vo , ye162010Vo);  
				Yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE162010");
		                    
			} 
			
		result = iCnt;
		          
		} catch (Exception ex) {
			
			logger.error("EXCEPTION calling activityOnYetaP53007ToYe162010(): "+ex); 
		            
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,  actionDatabase.toString(), ex, windowNm , windowId);
		            
			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnYetaP53007ToYe162010", ex, logger);
			
		} finally {

		}
		
		
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());

		return result;
	}

	
	/** 연금저축소득공제 조회 **/
	public PagingLoadResult<BaseModel> getYeta5300ToYe162010DataList(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETAP53007_TO_YE162010_DATA_LIST;
		Ye162010Srh_2020_VO   ye162010SrhVo = new Ye162010Srh_2020_VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(ye162010DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			ye162010DAO = (Ye162010_2020_DAO) wac.getBean("Ye162010_2020_DAO"); 
		}
	        
		try {
			//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
			ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
			PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			//Get paging configuration
	    	PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	    	//Get query parameters
	      	//String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	    	
//	    	List<String> listDeptCd = new ArrayList<String>();    
	      	/** 조건절 */
	    	ye162010SrhVo.setDpobCd(sessionUser.getDpobCd());    																	/** column 사업장코드 : dpobCd */
	    	ye162010SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));    	/** column 귀속년도 : yrtxBlggYr */
	    	ye162010SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));    	/** column 연말정산구분코드 : clutSeptCd */
	    	ye162010SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));    	/** column SYSTEMKEY : systemkey */
//	    	ye162010SrhVo.setPnsnSvngAccAccno(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pnsnSvngAccAccno"))));    /** column 계좌번호_증권번호 : pnsnSvngAccAccno */

	    	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = ye162010DAO.selectYetaP53007ToYe162010ListTotCnt(ye162010SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0126DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	ye162010SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		ye162010SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		ye162010SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = ye162010DAO.selectYetaP53007ToYe162010List(ye162010SrhVo);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {

				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			        
				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = map.get("systemkey").toString();
	        	BaseModel bm = new BaseModel();
	 
	       	//bm.setProperties(map);
	     	for ( int i=0 ; i<tableAttributes.length ; i++ ) {
	     		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
	     		Object mapCon = map.get(tableAttributes[i].getName());  
	                     
	     		switch ( tableAttributes[i].getType() ) {  
	          		case ColumnDef.TYPE_DATE: 
	          		case ColumnDef.TYPE_DATETIME: 
	                       
	             	Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"yyyyMMdd");
	            	map.put(tableAttributes[i].getName(), value);
	                     
	            	break; 
	            	
	            	//3. 복호화
	          		case ColumnDef.TYPE_STRING: 
	          		          			          			
	          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

	          			String rrnDecCrypt = "";
	          	   			
	          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	          		          			
	          		          			
	          				// 주민번호(복호화)
	          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	          		          		
	          				strValue = rrnDecCrypt;
	          							
	          			}
	          				
	          		map.put(tableAttributes[i].getName(), strValue);
	          			                    
	          		break;
	                       
	          		case ColumnDef.TYPE_LONG:   
	                     
	          			if (mapCon != null) {  
	          				Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
	                        map.put(tableAttributes[i].getName(), lValue); 
	                    }  
	                       
	                     break;
	                     
	          		case ColumnDef.TYPE_DOUBLE:  
	          			
	                      if (mapCon != null) {      
	                         Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue(); 
	                         map.put(tableAttributes[i].getName(), dbValue); 
	                      }  
	                       
	                   	break;
	     		}
	     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
	     			Object baseModelValue = null;
	            	//콤보박스처리를 위해 추가함
	     			if (tableAttributes[i].getName().contains("$")) {
	     				
	     				String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
	                              
	     				map.put(tableAttributes[i].getName(),map.get(strMapCon));
	                         
	                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
	                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
	     			} else {
	                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
	                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
	     			}
	     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                    
	                    bm.set(tableAttributes[i].getName(), baseModelValue);
	     	}

	     	bm.set(TableDef.ID_PROPERTY_NAME, idValue);
	     	bmResult.add(bm);
		} 

			retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYetaP53007ToYe162010List");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}	
	
	
	
	
} 
  