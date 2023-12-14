package com.app.exterms.yearendtax.server.service.yeta2016;

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

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3200DTO;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP13008Service;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3200DAO;
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

@Service("YetaP13008Service")
public class YetaP13008ServiceImpl  extends AbstractCustomServiceImpl implements YetaP13008Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(YetaP13008ServiceImpl.class);
	private static final String calledClass = YetaP13008ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "Ye16Ta3200DAO")
	private Ye16Ta3200DAO yeta3200DAO;	
	
	
	//비과세 및 감면소득 신규 및 수정
	@Override
	public Long activityOnYetaP13008ToYeta3200(List<Ye16Ta3200DTO> listYeta3200dto, ActionDatabase actionDatabase) throws MSFException {
			// TODO Auto-generated method stub
			Long result = new Long(0);
			Long iCnt = new Long(0);
			
			MSFSysm0100BM sessionUser;
			String method = calledClass + ".activityOnYetaP13008ToYeta3200";
			
			String windowNm = "소득공제신고자료관리";
			String windowId = "YETAP130008";
			
		
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
			
			try {  
				if (MSFSharedUtils.paramNull(yeta3200DAO)) {
					WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

					yeta3200DAO = (Ye16Ta3200DAO) wac.getBean("Ye16Ta3200DAO"); 
				}
		            
				for(int iPsnlCnt=0;iPsnlCnt < listYeta3200dto.size();iPsnlCnt++) {
		                
					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			        
			        
					
					Ye16Ta3200DTO yeta3200Dto = new Ye16Ta3200DTO();  
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
		            yeta3200Vo.setTaxmEy04(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEy04(),"0")));	/** column 비과세소득_Y04 : taxmEy04 */
		            yeta3200Vo.setTaxmEy21(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEy21(),"0")));	/** column 비과세소득_Y21 : taxmEy21 */
		            yeta3200Vo.setTaxmEy22(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEy22(),"0")));	/** column 비과세소득_Y22 : taxmEy22 */
		            
		            yeta3200Vo.setTaxmEt01(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEt01(),"0")));	/** column 감면소득_T01 : taxmEt01 */
		            yeta3200Vo.setTaxmEt10(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEt10(),"0")));	/** column 감면소득_T10 : taxmEt10 */
		            
		            yeta3200Vo.setTaxmEt11(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEt11(),"0")));	/** column 감면소득_T11 : taxmEt11 */
		            yeta3200Vo.setTaxmEt12(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3200Dto.getTaxmEt12(),"0")));	/** column 감면소득_T12 : taxmEt12 */
		            
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
		            logger.error("EXCEPTION calling activityOnYetaP13008ToYeta3200(): "+ex); 
		            
		            /** 에러 로그 **/			
		            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(), ex, windowNm , windowId);
		            
		            result = new Long(0);
		            throw MSFServerUtils.getOperationException("activityOnYetaP13008ToYeta3200", ex, logger);
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
//	public PagingLoadResult<BaseModel> getYetaP13008To3200List(ServiceParameters serviceParameters) throws MSFException {
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
//			yeta3200DAO = (Ye16Ta3200DAO) wac.getBean("Ye16Ta3200DAO"); 
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
	public Ye16Ta3200DTO getYetaP13008To3200List(Ye16Ta3200DTO yeta3200Dto) throws MSFException {
		

		Yeta3200SrhVO yeta3200SrhVo = new Yeta3200SrhVO();
		MSFSysm0100BM sessionUser;
		
		String method = calledClass + ".getYetaP13008To3200List";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETAP130008";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(yeta3200DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
							.getSession().getServletContext());
			yeta3200DAO = (Ye16Ta3200DAO) wac.getBean("Ye16Ta3200DAO");
		}
		
		

		/** 조건절 */
		yeta3200SrhVo.setDpobCd(sessionUser.getDeptCd());									/** column 사업장코드 : dpobCd */
		yeta3200SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta3200Dto.getEdacRvyy()));	/** column 연말정산귀속년도 : edacRvyy */
		yeta3200SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(yeta3200Dto.getSettGbcd()));	/** column 정산구분코드 : settGbcd */
		yeta3200SrhVo.setSystemkey(MSFSharedUtils.allowNulls(yeta3200Dto.getSystemkey()));	/** column SYSTEMKEY : systemkey */
		yeta3200SrhVo.setSiteNumb(MSFSharedUtils.allowNulls(yeta3200Dto.getSiteNumb()));	/** column 사업자등록번호 : siteNumb */

		int iResultCnt = yeta3200DAO.selectYetaP03008To3200ListTotCnt(yeta3200SrhVo);
		
		Ye16Ta3200DTO returnYeta3200Dto = new Ye16Ta3200DTO();
		List egovResultDataList = new ArrayList();

		try {
			
			egovResultDataList = yeta3200DAO.selectYetaP03001To3200List(yeta3200SrhVo);
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";

			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					

					// 1. 암호화 객체 생성
				//	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
					 
					
					Map tempMap = (Map)egovResultDataList.get(i); 
					 
					returnYeta3200Dto.setDpobCd(MSFSharedUtils.allowNulls(tempMap.get("dpobCd")));    /** column 사업장코드 : dpobCd */
					returnYeta3200Dto.setEdacRvyy(MSFSharedUtils.allowNulls(tempMap.get("edacRvyy")));    /** column 연말정산귀속년도 : edacRvyy */
					returnYeta3200Dto.setSettGbcd(MSFSharedUtils.allowNulls(tempMap.get("settGbcd")));    /** column 정산구분코드 : settGbcd */
					returnYeta3200Dto.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
					returnYeta3200Dto.setSiteNumb(MSFSharedUtils.allowNulls(tempMap.get("siteNumb")));    /** column 사업자등록번호 : siteNumb */
					
					returnYeta3200Dto.setHanNm(MSFSharedUtils.allowNulls(tempMap.get("hanNm")));    /** column  성명 */
					returnYeta3200Dto.setSiteCtnt(MSFSharedUtils.allowNulls(tempMap.get("siteCtnt")));    /** column 사업자등록번호 */
					
					returnYeta3200Dto.setTaxmEa01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEa01"),"0")));    /** column 비과세소득_A01 : taxmEa01 */
					returnYeta3200Dto.setTaxmEb01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEb01"),"0")));    /** column 비과세소득_B01 : taxmEb01 */
					returnYeta3200Dto.setTaxmEc01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEc01"),"0")));    /** column 비과세소득_C01 : taxmEc01 */
					returnYeta3200Dto.setTaxmEd01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEd01"),"0")));    /** column 비과세소득_D01 : taxmEd01 */
					returnYeta3200Dto.setTaxmEe01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEe01"),"0")));    /** column 비과세소득_E01 : taxmEe01 */
					returnYeta3200Dto.setTaxmEe02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEe02"),"0")));    /** column 비과세소득_E02 : taxmEe02 */
					returnYeta3200Dto.setTaxmEe10(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEe10"),"0")));    /** column 비과세소득_E10 : taxmEe10 */
					returnYeta3200Dto.setTaxmEf01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEf01"),"0")));    /** column 비과세소득_F01 : taxmEf01 */
					returnYeta3200Dto.setTaxmEg01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEg01"),"0")));    /** column 비과세소득_G01 : taxmEg01 */
					returnYeta3200Dto.setTaxmEh01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh01"),"0")));    /** column 비과세소득_H01 : taxmEh01 */
					returnYeta3200Dto.setTaxmEh02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh02"),"0")));    /** column 비과세소득_H02 : taxmEh02 */
					returnYeta3200Dto.setTaxmEh03(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh03"),"0")));    /** column 비과세소득_H03 : taxmEh03 */
					returnYeta3200Dto.setTaxmEh04(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh04"),"0")));    /** column 비과세소득_H04 : taxmEh04 */
					returnYeta3200Dto.setTaxmEh05(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh05"),"0")));    /** column 비과세소득_H05 : taxmEh05 */
					returnYeta3200Dto.setTaxmEh06(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh06"),"0")));    /** column 비과세소득_H06 : taxmEh06 */
					returnYeta3200Dto.setTaxmEh07(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh07"),"0")));    /** column 비과세소득_H07 : taxmEh07 */
					returnYeta3200Dto.setTaxmEh08(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh08"),"0")));    /** column 비과세소득_H08 : taxmEh08 */
					returnYeta3200Dto.setTaxmEh09(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh09"),"0")));    /** column 비과세소득_H09 : taxmEh09 */
					returnYeta3200Dto.setTaxmEh10(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh10"),"0")));    /** column 비과세소득_H10 : taxmEh10 */
					returnYeta3200Dto.setTaxmEh14(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh14"),"0")));    /** column 비과세소득_H14 : taxmEh14 */
					returnYeta3200Dto.setTaxmEh15(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh15"),"0")));    /** column 비과세소득_H15 : taxmEh15 */
					returnYeta3200Dto.setTaxmEh11(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh11"),"0")));    /** column 비과세소득_H11 : taxmEh11 */
					returnYeta3200Dto.setTaxmEh12(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh12"),"0")));    /** column 비과세소득_H12 : taxmEh12 */
					returnYeta3200Dto.setTaxmEh13(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh13"),"0")));    /** column 비과세소득_H13 : taxmEh13 */
					returnYeta3200Dto.setTaxmEh16(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEh16"),"0")));    /** column 비과세소득_H16 : taxmEh16 */
					returnYeta3200Dto.setTaxmEi01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEi01"),"0")));    /** column 비과세소득_I01 : taxmEi01 */
					returnYeta3200Dto.setTaxmEj01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEj01"),"0")));    /** column 비과세소득_J01 : taxmEj01 */
					returnYeta3200Dto.setTaxmEj10(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEj10"),"0")));    /** column 비과세소득_J10 : taxmEj10 */
					returnYeta3200Dto.setTaxmEk01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEk01"),"0")));    /** column 비과세소득_K01 : taxmEk01 */
					returnYeta3200Dto.setTaxmEl01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEl01"),"0")));    /** column 비과세소득_L01 : taxmEl01 */
					returnYeta3200Dto.setTaxmEm01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEm01"),"0")));    /** column 비과세소득_M01 : taxmEm01 */
					returnYeta3200Dto.setTaxmEm02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEm02"),"0")));    /** column 비과세소득_M02 : taxmEm02 */
					returnYeta3200Dto.setTaxmEm03(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEm03"),"0")));    /** column 비과세소득_M03 : taxmEm03 */
					returnYeta3200Dto.setTaxmEn01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEn01"),"0")));    /** column 비과세소득_N01 : taxmEn01 */
					returnYeta3200Dto.setTaxmEo01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEo01"),"0")));    /** column 비과세소득_O01 : taxmEo01 */
					returnYeta3200Dto.setTaxmEp01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEp01"),"0")));    /** column 비과세소득_P01 : taxmEp01 */
					returnYeta3200Dto.setTaxmEp02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEp02"),"0")));    /** column 비과세소득_P02 : taxmEp02 */
					returnYeta3200Dto.setTaxmEq01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEq01"),"0")));    /** column 비과세소득_Q01 : taxmEq01 */
					returnYeta3200Dto.setTaxmEr01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEr01"),"0")));    /** column 비과세소득_R01 : taxmEr01 */
					returnYeta3200Dto.setTaxmEr10(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEr10"),"0")));    /** column 비과세소득_R10 : taxmEr10 */
					returnYeta3200Dto.setTaxmEs01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEs01"),"0")));    /** column 비과세소득_S01 : taxmEs01 */
					returnYeta3200Dto.setTaxmEy02(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEy02"),"0")));    /** column 비과세소득_Y02 : taxmEy02 */
					returnYeta3200Dto.setTaxmEy03(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEy03"),"0")));    /** column 비과세소득_Y03 : taxmEy03 */
					returnYeta3200Dto.setTaxmEy21(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEy21"),"0")));    /** column 비과세소득_Y21 : taxmEy21 */
					returnYeta3200Dto.setTaxmEy22(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEy22"),"0")));    /** column 비과세소득_Y22 : taxmEy22 */
					returnYeta3200Dto.setTaxmEt01(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEt01"),"0")));    /** column 감면소득_T01 : taxmEt01 */
					returnYeta3200Dto.setTaxmEt10(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEt10"),"0")));    /** column 감면소득_T10 : taxmEt10 */
					returnYeta3200Dto.setTaxmEt20(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEt20"),"0")));    /** column 감면소득_T20 : taxmEt20 */
				   
					returnYeta3200Dto.setTaxmEy04(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEy04"),"0")));    /** column 비과세소득_Y04 : taxmEy04 */
					returnYeta3200Dto.setTaxmEt11(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEt11"),"0")));    /** column 감면소득_T11 : taxmEt11 */
					returnYeta3200Dto.setTaxmEt12(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEt12"),"0")));    /** column 감면소득_T12 : taxmEt12 */
					
					
					returnYeta3200Dto.setTaxmEt11(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEt11"),"0")));    // ⑳ 비과세 계
					returnYeta3200Dto.setTaxmEt12(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmEt12"),"0")));   // ⑳-1 감면소득 계  

					returnYeta3200Dto.setTaxeTotl(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxeTotl"),"0")));
					returnYeta3200Dto.setTaxmTotl(Long.parseLong(MSFSharedUtils.defaultNulls(tempMap.get("taxmTotl"),"0")));
					
					
//					Iterator<String> keys = tempMap.keySet().iterator();
				
//					while( keys.hasNext() ){
//			            String key = keys.next();
//			            //형 타입이 숫자형일경우 형변환 해준다.
//		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
//		            		returnYeta3200Dto.set(key, String.valueOf(tempMap.get(key)));
//		            	}else{
//		            		
//		            		if("resnRegnNum".equals(key)) {
//		            			
//		            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get(key))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//		            			returnYeta3200Dto.set(key, rrnDecCrypt);
//		            			
//		            		}else {
//		            			
//		            			returnYeta3200Dto.set(key, tempMap.get(key));
//		            		}
////		            		returnYeta3200Dto.set(key, tempMap.get(key));
//		            	}
//		            }
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
