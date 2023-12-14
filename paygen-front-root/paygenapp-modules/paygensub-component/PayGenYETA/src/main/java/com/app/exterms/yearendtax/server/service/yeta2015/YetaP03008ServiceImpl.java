package com.app.exterms.yearendtax.server.service.yeta2015;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
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

import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3200DTO;
import com.app.exterms.yearendtax.client.service.yeta2015.YetaP03008Service;
import com.app.exterms.yearendtax.server.service.yeta2015.dao.Yeta3200DAO;
import com.app.exterms.yearendtax.server.vo.Yeta3200SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3200VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;

@Service("YetaP03008Service")
public class YetaP03008ServiceImpl  extends AbstractCustomServiceImpl implements YetaP03008Service  ,YetaDaoConstants {

	// private  static final Logger LOGGER = LoggerFactory.getLogger(Yeta0100ServiceImpl.class);
	// private static final String calledClass = Yeta0100ServiceImpl.class.getName();
	private static final Logger logger = LoggerFactory.getLogger(YetaP03008ServiceImpl.class);
	private static final String calledClass = YetaP03008ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "Yeta3200DAO")
	private Yeta3200DAO yeta3200DAO;	
	
	
	//비과세 및 감면소득 신규 및 수정
	@Override
	public Long activityOnYetaP03008ToYeta3200(List<Yeta3200DTO> listYeta3200dto, ActionDatabase actionDatabase) throws MSFException {
			// TODO Auto-generated method stub
			Long result = new Long(0);
			Long iCnt = new Long(0);
			
			MSFSysm0100BM sessionUser;
			String method = calledClass + ".activityOnYetaP03008ToYeta3200";
			
			String windowNm = "소득공제신고자료관리";
			String windowId = "YETAP030008";
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
			
			try {  
				if (MSFSharedUtils.paramNull(yeta3200DAO)) {
					WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

					yeta3200DAO = (Yeta3200DAO) wac.getBean("yeta3200DAO"); 
				}
		            
				for(int iPsnlCnt=0;iPsnlCnt < listYeta3200dto.size();iPsnlCnt++) {
		                
					Yeta3200DTO yeta3200Dto = new Yeta3200DTO();  
					yeta3200Dto = listYeta3200dto.get(iPsnlCnt);
		                 
		            Yeta3200VO yeta3200Vo = new Yeta3200VO(); 
		            
		            
		            yeta3200Vo.setDpobCd(MSFSharedUtils.allowNulls(yeta3200Dto.getDpobCd()));		/** column 사업장코드 : dpobCd */
		            yeta3200Vo.setSystemkey(MSFSharedUtils.allowNulls(yeta3200Dto.getSystemkey()));	/** column SYSTEMKEY : systemkey */
		            yeta3200Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta3200Dto.getEdacRvyy()));	/** column 연말정산귀속년도 : edacRvyy */
		            yeta3200Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta3200Dto.getSettGbcd()));	/** column 정산구분코드 : settGbcd */
		            
		            
		            yeta3200Vo.setSiteNumb(MSFSharedUtils.allowNulls(yeta3200Dto.getSiteNumb().replace("-", "")));	/** column 사업자등록번호 : siteNumb */
//		            yeta3200Vo.setElctYymm(MSFSharedUtils.allowNulls(yeta3200Dto.getElctYymm()));	/** column 지급년월 : elctYymm */		            
		            yeta3200Vo.setSiteCtnt(MSFSharedUtils.allowNulls(yeta3200Dto.getSiteCtnt()));	/** column 근무지명 : siteCtnt */	
		            
		            yeta3200Vo.setTaxmEa01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEa01(),"0")));	/** column 비과세소득_A01 : taxmEa01 */
		            yeta3200Vo.setTaxmEb01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEb01(),"0")));	/** column 비과세소득_B01 : taxmEb01 */		            
		            yeta3200Vo.setTaxmEc01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEc01(),"0")));	/** column 비과세소득_C01 : taxmEc01 */
		            yeta3200Vo.setTaxmEd01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEd01(),"0")));	/** column 비과세소득_D01 : taxmEd01 */
		            yeta3200Vo.setTaxmEe01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEe01(),"0")));	/** column 비과세소득_E01 : taxmEe01 */
		            yeta3200Vo.setTaxmEe02(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEe02(),"0")));	/** column 비과세소득_E02 : taxmEe02 */		            
		            yeta3200Vo.setTaxmEe10(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEe10(),"0")));	/** column 비과세소득_E10 : taxmEe10 */		            
		            yeta3200Vo.setTaxmEf01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEf01(),"0")));	/** column 비과세소득_F01 : taxmEf01 */		            
		            yeta3200Vo.setTaxmEg01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEg01(),"0")));	/** column 비과세소득_G01 : taxmEg01 */		            
		            yeta3200Vo.setTaxmEh01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh01(),"0")));	/** column 비과세소득_H01 : taxmEh01 */
		            yeta3200Vo.setTaxmEh02(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh02(),"0")));	/** column 비과세소득_H02 : taxmEh02 */
		            yeta3200Vo.setTaxmEh03(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh03(),"0")));	/** column 비과세소득_H03 : taxmEh03 */
		            yeta3200Vo.setTaxmEh04(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh04(),"0")));	/** column 비과세소득_H04 : taxmEh04 */
		            yeta3200Vo.setTaxmEh05(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh05(),"0")));	/** column 비과세소득_H05 : taxmEh05 */
		            yeta3200Vo.setTaxmEh06(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh06(),"0")));	/** column 비과세소득_H06 : taxmEh06 */
		            yeta3200Vo.setTaxmEh07(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh07(),"0")));	/** column 비과세소득_H07 : taxmEh07 */
		            yeta3200Vo.setTaxmEh08(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh08(),"0")));	/** column 비과세소득_H08 : taxmEh08 */
		            yeta3200Vo.setTaxmEh09(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh09(),"0")));	/** column 비과세소득_H09 : taxmEh09 */
		            yeta3200Vo.setTaxmEh10(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh10(),"0")));	/** column 비과세소득_H10 : taxmEh10 */
		            yeta3200Vo.setTaxmEh14(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh14(),"0")));	/** column 비과세소득_H14 : taxmEh14 */
		            yeta3200Vo.setTaxmEh15(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh15(),"0")));	/** column 비과세소득_H15 : taxmEh15 */
		            yeta3200Vo.setTaxmEh11(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh11(),"0")));	/** column 비과세소득_H11 : taxmEh11 */
		            yeta3200Vo.setTaxmEh12(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh12(),"0")));	/** column 비과세소득_H12 : taxmEh12 */
		            yeta3200Vo.setTaxmEh13(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh13(),"0")));	/** column 비과세소득_H13 : taxmEh13 */
		            yeta3200Vo.setTaxmEh16(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEh16(),"0")));	/** column 비과세소득_H16 : taxmEh16 */		            
		            yeta3200Vo.setTaxmEi01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEi01(),"0")));	/** column 비과세소득_I01 : taxmEi01 */
		            yeta3200Vo.setTaxmEj01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEj01(),"0")));	/** column 비과세소득_J01 : taxmEj01 */
		            yeta3200Vo.setTaxmEj10(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEj10(),"0")));	/** column 비과세소득_J10 : taxmEj10 */
		            yeta3200Vo.setTaxmEk01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEk01(),"0")));	/** column 비과세소득_K01 : taxmEk01 */
		            yeta3200Vo.setTaxmEl01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEl01(),"0")));	/** column 비과세소득_L01 : taxmEl01 */
		            yeta3200Vo.setTaxmEm01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEm01(),"0")));	/** column 비과세소득_M01 : taxmEm01 */
		            yeta3200Vo.setTaxmEm02(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEm02(),"0")));	/** column 비과세소득_M02 : taxmEm02 */
		            yeta3200Vo.setTaxmEm03(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEm03(),"0")));	/** column 비과세소득_M03 : taxmEm03 */
		            yeta3200Vo.setTaxmEn01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEn01(),"0")));	/** column 비과세소득_N01 : taxmEn01 */
		            yeta3200Vo.setTaxmEo01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEo01(),"0")));	/** column 비과세소득_O01 : taxmEo01 */
		            yeta3200Vo.setTaxmEp01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEp01(),"0")));	/** column 비과세소득_P01 : taxmEp01 */
		            yeta3200Vo.setTaxmEp02(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEp02(),"0")));	/** column 비과세소득_P02 : taxmEp02 */
		            yeta3200Vo.setTaxmEq01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEq01(),"0")));	/** column 비과세소득_Q01 : taxmEq01 */
		            yeta3200Vo.setTaxmEr01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEr01(),"0")));	/** column 비과세소득_R01 : taxmEr01 */
		            yeta3200Vo.setTaxmEr10(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEr10(),"0")));	/** column 비과세소득_R10 : taxmEr10 */
		            yeta3200Vo.setTaxmEs01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEs01(),"0")));	/** column 비과세소득_S01 : taxmEs01 */
		            yeta3200Vo.setTaxmEy02(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEy02(),"0")));	/** column 비과세소득_Y02 : taxmEy02 */
		            yeta3200Vo.setTaxmEy03(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEy03(),"0")));	/** column 비과세소득_Y03 : taxmEy03 */
		            yeta3200Vo.setTaxmEy21(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEy21(),"0")));	/** column 비과세소득_Y21 : taxmEy21 */
		            yeta3200Vo.setTaxmEy22(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEy22(),"0")));	/** column 비과세소득_Y22 : taxmEy22 */
		            
		            yeta3200Vo.setTaxmEt01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEt01(),"0")));	/** column 감면소득_T01 : taxmEt01 */
		            yeta3200Vo.setTaxmEt10(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEt10(),"0")));	/** column 감면소득_T10 : taxmEt10 */
		            yeta3200Vo.setTaxmEt20(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEt20(),"0")));	/** column 감면소득_T20 : taxmEt20 */
		            
//		            yeta3200Vo.setTaxmTotl(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmTotl(),"0")));	/** column 감면 합계 : taxmTotl */
//		            yeta3200Vo.setTaxeTotl(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxeTotl(),"0")));	/** column 비과세 합계 : taxeTotl */
		            		            
		            yeta3200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
		            
		            yeta3200Vo.setIsmt(sessionUser.getUsrId());/** column 수정자 : ismt */
		            yeta3200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); /** column 수정주소 : revnAddr */
		    		
//		            yeta3200Vo.setInptDt(MSFSharedUtils.allowNulls(yeta3200Vo.getinptDt));    /** column 입력일자 : inptDt */
//		            yeta3200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */ 
//		            yeta3200Vo.setIsmt(MSFSharedUtils.allowNulls(yeta3200Vo.getismt));    /** column 수정자 : ismt */
//		            yeta3200Vo.setRevnDt(MSFSharedUtils.allowNulls(yeta3200Vo.getrevnDt));    /** column 수정일자 : revnDt */
//		            yeta3200Vo.setRevnAddr(MSFSharedUtils.allowNulls(yeta3200Vo.getrevnAddr));    /** column 수정주소 : revnAddr */
		            
		                      
		        	switch (actionDatabase) {
		        		case INSERT: 
		        			yeta3200DAO.insertYetaP03008To3200(yeta3200Vo); 
		        		break;
	            		
	            		
		            	case UPDATE: 
		            		yeta3200DAO.updateYetaP03008To3200(yeta3200Vo); 
		            	break;
		        	} 
		        		iCnt = iCnt + 1; 
		                    
				} 
				result = iCnt;
		          
		        } catch (Exception ex) {
		            logger.error("EXCEPTION calling activityOnYetaP03008ToYeta3200(): "+ex); 
		            
		            /** 에러 로그 **/			
		            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(), ex, windowNm , windowId);
		            
		            result = new Long(0);
		            throw MSFServerUtils.getOperationException("activityOnYetaP03008ToYeta3200", ex, logger);
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

	
//	//비과세 및 감면소득 조회
//	public PagingLoadResult<BaseModel> getYetaP03008To3200List(ServiceParameters serviceParameters) throws MSFException {
//		
//
//		PagingLoadResult<BaseModel> retval = null;
//		String method =  CLASS_YETAP03008TOYETA3200_DATA_LIST;
//		Yeta3200SrhVO   yeta3200SrhVo = new Yeta3200SrhVO();
//		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
//		MSFSysm0100BM sessionUser;
//	        
//	        
//		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
//			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//		} else {
//			sessionUser = getUser();
//		}
//	      
//		if  (MSFSharedUtils.paramNull(yeta3200DAO)) {
//			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//			yeta3200DAO = (Yeta3200DAO) wac.getBean("Yeta3200DAO"); 
//		}
//	        
//		try {
//			//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
//			ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
//			IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
//			List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
//			PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
//
//			//Get paging configuration
//	    	PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
//
//	    	//Get query parameters
//	      	//String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
//	    	
////	    	List<String> listDeptCd = new ArrayList<String>();    
//	      	/** 조건절 */
//	    	yeta3200SrhVo.setDpobCd(sessionUser.getDeptCd());    /** column 사업장코드 : dpobCd */
//	    	yeta3200SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy")));    	/** column 연말정산귀속년도 : edacRvyy */
//	    	yeta3200SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd")));		/** column 정산구분코드 : settGbcd */
//	    	yeta3200SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));	/** column SYSTEMKEY : systemkey */
//	    	yeta3200SrhVo.setSiteNumb(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "siteNumb")));    	/** column 사업자등록번호 : siteNumb */
////	    	yeta3220SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
////	    	yeta3220SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//////	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
////	     	
////	    	yeta3220SrhVo.setUsrId(sessionUser.getUsrId());
////            /******************************** 권한 ************************************************************************/
////            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
////            if ("FALSE".equals(chkDeptCd)) {
////            	yeta3220SrhVo.setDeptCd(sessionUser.getDeptCd()); 
////               listDeptCd.add(sessionUser.getDeptCd());
////               yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
////               yeta3220SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
////            } else {
////            	yeta3220SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
////                     if (yeta3220SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
////                     	 listDeptCd = null; 
////                     	yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
////                     	yeta3220SrhVo.setDeptCd("");  //부서코드
////                     } else {
////                    	 yeta3220SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
////                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
////                          yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
////                     } 
////            }
////            
//////            } else {
//////            	
//////            }
////            
////            yeta3220SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
////            yeta3220SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
////            
////           /******************************** 권한 ************************************************************************/
////	     	
////	     	
////            yeta3220SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
////	            
//////	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//////	     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//////	      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
////	            
////	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
////	       	yeta3220SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
////	       	yeta3220SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
////	           
//////	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//////	     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//////	     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
////	             
////	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
////	      	yeta3220SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
////	      	yeta3220SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
////	             
////	      	yeta3220SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
////	           
////	           
////	      	yeta3220SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //년도
////	      	yeta3220SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
////	      	yeta3220SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
//	            
//	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
//			if ( pagingValues.executeRecordCount ) { 
//		            	
//				//Execute query that returns a single value
//	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//	                 
//	          	int iResultCnt = yeta3200DAO.selectYetaP03008To3200ListTotCnt(yeta3200SrhVo);  
//	          	
//	          	
//	              
//	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
//	          	
//	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
//                if (!pagingValues.pageExecute) { 
//                    pagingValues.offsetLimit = iResultCnt;       
//                }
//                
//	         	pagingValues.totalRecordCount = iResultCnt;	       
//	                
//	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//			}
//	        
//	     	TimingInfo millisBeginPsnl0126DataList = SmrmfUtils.startTiming(logger);
//	        
//	     	/**페이지 카운트 처리를 위한 부분 */ 
//	     	yeta3200SrhVo.setPageSize(pagingValues.totalRecordCount);  
//	            
//	     	//Apply paging
//	     	if (pagingValues.start > 0) {
//	     		yeta3200SrhVo.setFirstIndex(pagingValues.start);
//	     	}
//	     	if (pagingValues.offsetLimit > 0) {
//	     		yeta3200SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
//	     	}
//
//	     	//Execute query and convert to BaseModel list
//	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//	            
//	     	@SuppressWarnings("unchecked")
////	            Collection<Map<String, Object>> list ??????
//	     	List list = yeta3200DAO.selectYetaP03001To3200List(yeta3200SrhVo);
//	            
//			Iterator<Map<String, Object>> iter = list.iterator();
//		            
//			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
//	           
//	        
//			while (iter.hasNext()) {
//				Map<String, Object> map = (Map<String, Object>) iter.next();
//				String idValue = map.get("systemkey").toString();
//	        	BaseModel bm = new BaseModel();
//	 
//	       	//bm.setProperties(map);
//	     	for ( int i=0 ; i<tableAttributes.length ; i++ ) {
//	     		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
//	     		Object mapCon = map.get(tableAttributes[i].getName());  
//	                     
//	     		switch ( tableAttributes[i].getType() ) {  
//	          		case ColumnDef.TYPE_DATE: 
//	          		case ColumnDef.TYPE_DATETIME: 
//	                       
//	             	Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"yyyyMMdd");
//	            	map.put(tableAttributes[i].getName(), value);
//	                     
//	            	break; 
//	                       
//	          		case ColumnDef.TYPE_LONG:   
//	                     
//	          			if (mapCon != null) {  
//	          				Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
//	                        map.put(tableAttributes[i].getName(), lValue); 
//	                    }  
//	                       
//	                     break;
//	                     
//	          		case ColumnDef.TYPE_DOUBLE:  
//	          			
//	                      if (mapCon != null) {      
//	                         Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue(); 
//	                         map.put(tableAttributes[i].getName(), dbValue); 
//	                      }  
//	                       
//	                   	break;
//	     		}
//	     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
//	     			Object baseModelValue = null;
//	            	//콤보박스처리를 위해 추가함
//	     			if (tableAttributes[i].getName().contains("$")) {
//	     				
//	     				String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
//	                              
//	     				map.put(tableAttributes[i].getName(),map.get(strMapCon));
//	                         
//	                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//	                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//	     			} else {
//	                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//	                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//	     			}
//	     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//	                    
//	                    bm.set(tableAttributes[i].getName(), baseModelValue);
//	     	}
//
//	     	bm.set(TableDef.ID_PROPERTY_NAME, idValue);
//	     	bmResult.add(bm);
//		} 
//
//			retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
//	            
//			SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYetaP03008To3200List");
//	       
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			//Return operation exception
//			throw MSFServerUtils.getOperationException(method, ex, logger);
//		}
//		return retval;
//	}	
	
	
	//비과세 및 감면소득 조회
	public Yeta3200DTO getYetaP03008To3200List(Yeta3200DTO yeta3200Dto) throws MSFException {
		

		Yeta3200SrhVO yeta3200SrhVo = new Yeta3200SrhVO();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		String method = calledClass + ".getYetaP03008To3200List";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETAP030008";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(yeta3200DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
							.getSession().getServletContext());
			yeta3200DAO = (Yeta3200DAO) wac.getBean("Yeta3200DAO");
		}
		
		

		/** 조건절 */
		yeta3200SrhVo.setDpobCd(sessionUser.getDeptCd());									/** column 사업장코드 : dpobCd */
		yeta3200SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta3200Dto.getEdacRvyy()));	/** column 연말정산귀속년도 : edacRvyy */
		yeta3200SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(yeta3200Dto.getSettGbcd()));	/** column 정산구분코드 : settGbcd */
		yeta3200SrhVo.setSystemkey(MSFSharedUtils.allowNulls(yeta3200Dto.getSystemkey()));	/** column SYSTEMKEY : systemkey */
		yeta3200SrhVo.setSiteNumb(MSFSharedUtils.allowNulls(yeta3200Dto.getSiteNumb()));	/** column 사업자등록번호 : siteNumb */

		int iResultCnt = yeta3200DAO.selectYetaP03008To3200ListTotCnt(yeta3200SrhVo);
		
		Yeta3200DTO returnYeta3200Dto = new Yeta3200DTO();
		List egovResultDataList = new ArrayList();

		try {
			
			egovResultDataList = yeta3200DAO.selectYetaP03001To3200List(yeta3200SrhVo);
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";

			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		returnYeta3200Dto.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		
		            		if("resnRegnNum".equals(key)) {
		            			
		            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get(key))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		            			returnYeta3200Dto.set(key, rrnDecCrypt);
		            			
		            		}else {
		            			
		            			returnYeta3200Dto.set(key, tempMap.get(key));
		            		}
//		            		returnYeta3200Dto.set(key, tempMap.get(key));
		            	}
		            }
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

		return returnYeta3200Dto;
		
	}


} 
