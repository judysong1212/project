/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.app.exterms.yearendtax.server.service.yeta2016;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3120DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3160DTO;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP13004Service;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3120DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3130DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3160DAO;
import com.app.exterms.yearendtax.server.vo.Yeta3120SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3120VO;
import com.app.exterms.yearendtax.server.vo.Yeta3160SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3160VO;
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
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("YetaP13004Service")
public class YetaP13004ServiceImpl  extends AbstractCustomServiceImpl implements YetaP13004Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(YetaP13004ServiceImpl.class);
	private static final String calledClass = YetaP13004ServiceImpl.class.getName();
	  
	@Autowired
	@Resource(name = "Ye16Ta3120DAO")
	private Ye16Ta3120DAO yeta3120DAO;
	
	@Autowired
	@Resource(name = "Ye16Ta3130DAO")
	private Ye16Ta3130DAO yeta3130DAO;
	
	@Autowired
	@Resource(name = "Ye16Ta3160DAO")
	private Ye16Ta3160DAO yeta3160DAO;
	
	
	//거주자간 주택임차차입금 원리금 상환액 - 금전소비대차계약 수정 삭제부
	@Override
	public Long activityOnYetaP13004ToYeta3120(List<Ye16Ta3120DTO> listYeta3120dto, ActionDatabase actionDatabase) throws MSFException {
			// TODO Auto-generated method stub
			Long result = new Long(0);
			Long iCnt = new Long(0);
			BigDecimal seqn = new BigDecimal(0);
			
			String windowNm = "소득공제신고자료관리";
			String windowId = "YETAP130004";
			
		
			MSFSysm0100BM sessionUser;
			String method = calledClass + ".activityOnYetaP13004ToYeta3120";
	        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
			
			try {  
				if (MSFSharedUtils.paramNull(yeta3120DAO)) {
					WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

					yeta3120DAO = (Ye16Ta3120DAO) wac.getBean("Ye16Ta3120DAO"); 
				}
		            
				for(int iPsnlCnt=0;iPsnlCnt < listYeta3120dto.size();iPsnlCnt++) {
		                
					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
					
					
					Ye16Ta3120DTO yeta3120Dto = new Ye16Ta3120DTO();  
					yeta3120Dto = listYeta3120dto.get(iPsnlCnt);
		                 
		            Yeta3120VO yeta3120Vo = new Yeta3120VO();  
		            
		            yeta3120Vo.setDpobCd(MSFSharedUtils.allowNulls(yeta3120Dto.getDpobCd()));    							/** column 사업장코드 : dpobCd */
		            yeta3120Vo.setSystemkey(MSFSharedUtils.allowNulls(yeta3120Dto.getSystemkey()));    						/** column SYSTEMKEY : systemkey */
		            
		            yeta3120Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta3120Dto.getEdacRvyy()));    						/** column 연말정산귀속년도 : edacRvyy */
		            yeta3120Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta3120Dto.getSettGbcd()));    						/** column 정산구분코드 : settGbcd */
		            yeta3120Vo.setCnclSqno(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3120Dto.getCnclSqno(), "0")));    /** column 금전소비대차일련번호 : cnclSqno */
		            yeta3120Vo.setCnclName(MSFSharedUtils.allowNulls(yeta3120Dto.getCnclName()));    						/** column 금전소비대차_임대인성명 : cnclName */
//		            yeta3120Vo.setCnclRsno(MSFSharedUtils.allowNulls(yeta3120Dto.getCnclRsno()));    /** column 금전소비대차_주민번호 : cnclRsno */
		            // 암호화
		            yeta3120Vo.setCnclRsno(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta3120Dto.getCnclRsno()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));  
		            
		            yeta3120Vo.setCnclStdt(MSFSharedUtils.allowNulls(yeta3120Dto.getCnclStdt()));    						/** column 금전소비대차_계약시작일자 : cnclStdt */
		            yeta3120Vo.setCnclEddt(MSFSharedUtils.allowNulls(yeta3120Dto.getCnclEddt()));    						/** column 금전소비대차_계약종료일자 : cnclEddt */
		            yeta3120Vo.setCnclItro(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3120Dto.getCnclItro(), "0")));    /** column 금전소비대차_차입금이자율 : cnclItro */
		            yeta3120Vo.setCnclRdmt(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3120Dto.getCnclRdmt(), "0")));    /** column 금전소비대차_원리금상환액계 : cnclRdmt */
		            yeta3120Vo.setCnclPrpl(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3120Dto.getCnclPrpl(), "0")));    /** column 금전소비대차_원리금 : cnclPrpl */
		            yeta3120Vo.setCnclItrt(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3120Dto.getCnclItrt(), "0")));    /** column 금전소비대차_이자 : cnclItrt */
		            yeta3120Vo.setCnclDuam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3120Dto.getCnclDuam(), "0")));    /** column 금전소비대차_공제금액 : cnclDuam */
		            
		            
		            
		            if((ActionDatabase.INSERT).equals(actionDatabase) || (ActionDatabase.UPDATE).equals(actionDatabase)) {
		            	//신규인지 수정인지 일련번호로 구분
//		            	if("0".equals(yeta3120Vo.getCnclSqno())) {
		            	if("0".equals((String) MSFSharedUtils.defaultNulls(yeta3120Dto.getCnclSqno(), "0"))) {
		            		
		            		yeta3120Vo.setKybdr(sessionUser.getUsrId()); 													/** column 입력자 : kybdr */ 
		            		yeta3120Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());				/** column 입력주소 : inptAddr */ 
				    		
		            		yeta3120Vo.setIsmt(sessionUser.getUsrId());														/** column 수정자 : ismt */
		            		yeta3120Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 				/** column 수정주소 : revnAddr */
				    		
		            		yeta3120DAO.insertYetaP03004To3120(yeta3120Vo);  
		            	}else {
		            		
		            		yeta3120Vo.setIsmt(sessionUser.getUsrId());														/** column 수정자 : ismt */
		            		yeta3120Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 				/** column 수정주소 : revnAddr */
		            		
		            		yeta3120DAO.updateYetaP03004To3120(yeta3120Vo);
		            	}
		            }else if((ActionDatabase.DELETE).equals(actionDatabase)) {
		            		yeta3120DAO.deleteYetaP03004To3120(yeta3120Vo);
		            }
		            
//		        	switch (actionDatabase) {
//		        		case INSERT:
//		        			yeta3120DAO.insertYetaP03004To3120(yeta3120Vo); 
//		        			break;
//		            	case UPDATE: 
//		            		yeta3120DAO.updateYetaP03004To3120(yeta3120Vo); 
//		            		break;
//		            	case DELETE: 
//		            		yeta3120DAO.deleteYetaP03004To3120(yeta3120Vo); 
//		            		break;
//		        	} 
		        		iCnt = iCnt + 1; 
		                    
				} 
				result = iCnt;
		          
		        } catch (Exception ex) {
		        	
		            logger.error("EXCEPTION calling activityOnYetaP13004ToYeta3120(): "+ex); 
		            
		            /** 에러 로그 **/			
		            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:U:D",ex, windowNm , windowId);
		            
		            result = new Long(0);
		            throw MSFServerUtils.getOperationException("activityOnYetaP13004ToYeta3120", ex, logger);
		        }
		        finally {
		          
		        }
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:U:D");
			
			return result;
		}	 


	
	//거주자간 주택임차차입금 원리금 상환액 - 임대차계약 수정 삭제부
	@Override
	public Long activityOnYetaP13004ToYeta3160(List<Ye16Ta3160DTO> listYeta3160dto, ActionDatabase actionDatabase) throws MSFException {
			// TODO Auto-generated method stub
			Long result = new Long(0);
			Long iCnt = new Long(0);
			BigDecimal seqn = new BigDecimal(0);
			
			String windowNm = "소득공제신고자료관리";
			String windowId = "YETAP130004";
			
			
			MSFSysm0100BM sessionUser;
			String method = calledClass + ".activityOnYetaP13004ToYeta3160";
	        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
			
			try {  
				if (MSFSharedUtils.paramNull(yeta3160DAO)) {
					WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

					yeta3160DAO = (Ye16Ta3160DAO) wac.getBean("Ye16Ta3160DAO"); 
				}
		            
				for(int iPsnlCnt=0;iPsnlCnt < listYeta3160dto.size();iPsnlCnt++) {
		                
					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
					
					
					Ye16Ta3160DTO yeta3160Dto = new Ye16Ta3160DTO();  
					yeta3160Dto = listYeta3160dto.get(iPsnlCnt);
		                 
		            Yeta3160VO yeta3160Vo = new Yeta3160VO();  
		            
		            yeta3160Vo.setDpobCd(MSFSharedUtils.allowNulls(yeta3160Dto.getDpobCd()));    	/** column 사업장코드 : dpobCd */
		            yeta3160Vo.setSystemkey(MSFSharedUtils.allowNulls(yeta3160Dto.getSystemkey()));	/** column SYSTEMKEY : systemkey */
		            yeta3160Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta3160Dto.getEdacRvyy()));   /** column 연말정산귀속년도 : edacRvyy */
		            yeta3160Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta3160Dto.getSettGbcd()));   /** column 정산구분코드 : settGbcd */
		            
		            yeta3160Vo.setLeasSqno(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3160Dto.getLeasSqno(), "0"))); /** column 임대차일련번호 : leasSqno */
		           
		            yeta3160Vo.setLeasName(MSFSharedUtils.allowNulls(yeta3160Dto.getLeasName()));   /** column 임대차_임대인성명 : leasName */
//		            yeta3160Vo.setLeasRsno(MSFSharedUtils.allowNulls(yeta3160Dto.getLeasRsno()));    /** column 임대차_주민번호 : leasRsno */
		            // 암호화
		            yeta3160Vo.setLeasRsno(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta3160Dto.getLeasRsno()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
		            
		            yeta3160Vo.setLeasTyhu(MSFSharedUtils.allowNulls(yeta3160Dto.getLeasTyhu()));    /** column 임대차_주택유형코드 : leasTyhu */
		            yeta3160Vo.setLeasArea(MSFSharedUtils.allowNulls(yeta3160Dto.getLeasArea()));    /** column 임대차_주책계약면적 : leasArea */
		            yeta3160Vo.setLeasAddr(MSFSharedUtils.allowNulls(yeta3160Dto.getLeasAddr()));    /** column 임대차_계약서상주소 : leasAddr */
		            yeta3160Vo.setLeasStdt(MSFSharedUtils.allowNulls(yeta3160Dto.getLeasStdt()));    /** column 임대차_계약시작일자 : leasStdt */
		            yeta3160Vo.setLeasEddt(MSFSharedUtils.allowNulls(yeta3160Dto.getLeasEddt()));    /** column 임대차_계약종료일자 : leasEddt */
		            yeta3160Vo.setLeasDpst(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3160Dto.getLeasDpst(), "0"))); /** column 임대차_전세보증금액 : leasDpst */
		            
		            
		            if((ActionDatabase.INSERT).equals(actionDatabase) || (ActionDatabase.UPDATE).equals(actionDatabase)) {
		            	//신규인지 수정인지 일련번호로 구분
//		            	if("0".equals(yeta3130Vo.getMnrnSqno())) {
		            	if("0".equals((String) MSFSharedUtils.defaultNulls(yeta3160Dto.getLeasSqno(), "0"))) {
		            		
//		            		yeta3160Vo.setKybdr(sessionUser.getUsrId()); 	/** column 입력자 : kybdr */ 
//		            		yeta3160Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());/** column 입력주소 : inptAddr */ 
//				    		
//		            		yeta3160Vo.setIsmt(sessionUser.getUsrId());		/** column 수정자 : ismt */
//		            		yeta3160Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());/** column 수정주소 : revnAddr */
		            		
		            		yeta3160DAO.insertYetaP03004To3160(yeta3160Vo);  
		            		
		            	}else {
		            		
//		            		yeta3160Vo.setIsmt(sessionUser.getUsrId());		/** column 수정자 : ismt */
//		            		yeta3160Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());/** column 수정주소 : revnAddr */
		            		
		            		yeta3160DAO.updateYetaP03004To3160(yeta3160Vo); 
		            	}
		            }else if((ActionDatabase.DELETE).equals(actionDatabase)) {
		            	
		            	yeta3160DAO.deleteYetaP03004To3160(yeta3160Vo);
		            	
		            }
		            
		        		iCnt = iCnt + 1; 
				} 
				result = iCnt;
		          
		        } catch (Exception ex) {
		            logger.error("EXCEPTION calling activityOnYetaP13004ToYeta3160(): "+ex); 
		            
		            /** 에러 로그 **/			
		            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),ex, windowNm , windowId);
		            
		            result = new Long(0);
		            throw MSFServerUtils.getOperationException("activityOnYetaP13004ToYeta3160", ex, logger);
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
	
	
	
	//금전소비대차계약 조회
	public PagingLoadResult<BaseModel> getYetaP13004To3120List(ServiceParameters serviceParameters) throws MSFException {
			

			PagingLoadResult<BaseModel> retval = null;
			String method =  CLASS_YETAP13004TOYETA3120_DATA_LIST;
			Yeta3120SrhVO   yeta3120SrhVo = new Yeta3120SrhVO();
			List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			MSFSysm0100BM sessionUser;
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(yeta3120DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				yeta3120DAO = (Ye16Ta3120DAO) wac.getBean("Ye16Ta3120DAO"); 
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
		    	
//		    	List<String> listDeptCd = new ArrayList<String>();    
		      	/** 조건절 */
		    	yeta3120SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
		    	yeta3120SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"))) ;   //systemkey
		    	yeta3120SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy")));   
		    	yeta3120SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd")));   

		    	
//		    	yeta3220SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
//		    	yeta3220SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
////		     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
//		     	
//		    	yeta3220SrhVo.setUsrId(sessionUser.getUsrId());
//	            /******************************** 권한 ************************************************************************/
//	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//	            if ("FALSE".equals(chkDeptCd)) {
//	            	yeta3220SrhVo.setDeptCd(sessionUser.getDeptCd()); 
//	               listDeptCd.add(sessionUser.getDeptCd());
//	               yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
//	               yeta3220SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//	            } else {
//	            	yeta3220SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
//	                     if (yeta3220SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
//	                     	 listDeptCd = null; 
//	                     	yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	                     	yeta3220SrhVo.setDeptCd("");  //부서코드
//	                     } else {
//	                    	 yeta3220SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
//	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	                          yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
//	                     } 
//	            }
//	            
////	            } else {
////	            	
////	            }
//	            
//	            yeta3220SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
//	            yeta3220SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
//	            
//	           /******************************** 권한 ************************************************************************/
//		     	
//		     	
//	            yeta3220SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
//		            
////		       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
////		     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
////		      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//		            
//		       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
//		       	yeta3220SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
//		       	yeta3220SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//		           
////		     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
////		     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
////		     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//		             
//		      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
//		      	yeta3220SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//		      	yeta3220SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
//		             
//		      	yeta3220SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
//		           
//		           
//		      	yeta3220SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //년도
//		      	yeta3220SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
//		      	yeta3220SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
		            
		      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = yeta3120DAO.selectYetaP03004To3120ListTotCnt(yeta3120SrhVo);  
		              
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
		     	yeta3120SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		yeta3120SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		yeta3120SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
		            
		     	@SuppressWarnings("unchecked")
//		            Collection<Map<String, Object>> list ??????
		     	List list = yeta3120DAO.selectYetaP03004To3120List(yeta3120SrhVo);
		            
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
		          							
		          			}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("degtrResnRegnNum".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("rsnoNumb".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("cnclRsno".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("leasRsno".equals(tableAttributes[i].getName())) {

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
		            
				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYetaP03004To3120List");
		       
			} catch (Exception ex) {
				ex.printStackTrace();
				//Return operation exception
				throw MSFServerUtils.getOperationException(method, ex, logger);
			}
			
			return retval;
		}	
	
	
	//임대차계약 조회
	public PagingLoadResult<BaseModel> getYetaP13004To3160List(ServiceParameters serviceParameters) throws MSFException {
			

			PagingLoadResult<BaseModel> retval = null;
			String method =  CLASS_YETAP13004TOYETA3160_DATA_LIST;
			Yeta3160SrhVO   yeta3160SrhVo = new Yeta3160SrhVO();
			List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(yeta3160DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				yeta3160DAO = (Ye16Ta3160DAO) wac.getBean("Ye16Ta3160DAO"); 
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
		    	
		      	/** 조건절 */
		    	yeta3160SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
		    	yeta3160SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy")));   
		    	yeta3160SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd")));   
		    	yeta3160SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));   
		    	
		            
		      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = yeta3160DAO.selectYetaP03004To3160ListTotCnt(yeta3160SrhVo);  
		              
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
		     	yeta3160SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		yeta3160SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		yeta3160SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
		            
		     	@SuppressWarnings("unchecked")
//		            Collection<Map<String, Object>> list ??????
		     	List list = yeta3160DAO.selectYetaP03004To3160List(yeta3160SrhVo);
		            
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
		                       
		          		case ColumnDef.TYPE_LONG:   
		                     
		          			if (mapCon != null) {  
		          				Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
		                        map.put(tableAttributes[i].getName(), lValue); 
		                    }  
		                       
		                     break;
		                     
		                 	//3. 복호화
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

		          			String rrnDecCrypt = "";
		          	   			
		          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
		          		          			
		          		          			
		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;
		          							
		          			}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("degtrResnRegnNum".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("rsnoNumb".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("cnclRsno".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("leasRsno".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }
		          				
		          		map.put(tableAttributes[i].getName(), strValue);
		          			                    
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
		            
				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYetaP13004To3160List");
		       
			} catch (Exception ex) {
				ex.printStackTrace();
				//Return operation exception
				throw MSFServerUtils.getOperationException(method, ex, logger);
			}
			
			return retval;
		}	
		
	  
	  
}
 
 