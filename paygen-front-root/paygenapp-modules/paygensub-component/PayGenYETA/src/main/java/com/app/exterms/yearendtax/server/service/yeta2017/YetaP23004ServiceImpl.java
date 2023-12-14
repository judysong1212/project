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
package com.app.exterms.yearendtax.server.service.yeta2017;

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

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye162520DTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.Ye162530DTO;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP23004Service;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye162520DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye162530DAO;
import com.app.exterms.yearendtax.server.vo.Ye162520SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye162520VO;
import com.app.exterms.yearendtax.server.vo.Ye162530SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye162530VO;
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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.pkg.listener.yeta.yeta2017.Yeta2300ListenerAdapter;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;




/**
 * @Class Name : YetaP23004ServiceImpl.java
 * @since : 2017. 12. 21. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Service("YetaP23004Service")
public class YetaP23004ServiceImpl  extends AbstractCustomServiceImpl implements YetaP23004Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(YetaP23004ServiceImpl.class);
	private static final String calledClass = YetaP23004ServiceImpl.class.getName();
	  
	
	@Autowired
	@Resource(name = "Ye162520DAO")
	private Ye162520DAO ye162520DAO;
	
	@Autowired
	@Resource(name = "Ye162530DAO")
	private Ye162530DAO ye162530DAO;
	
	
	/** 거주자간 주택임차차입금 원리금 상환액 - 금전소비대차계약 수정 삭제부 **/
	@Override
	public Long activityOnYetaP23004ToYe162520(List<Ye162520DTO> listYe162520Dto, ActionDatabase actionDatabase) throws MSFException {
		
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		BigDecimal seqn = new BigDecimal(0);

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETAP230004";
		
		InfcPkgYe161010VO infcPkgYe161010Vo = new InfcPkgYe161010VO(); 
		Yeta2300ListenerAdapter  yeta2300ListenerAdt = new Yeta2300ListenerAdapter();
			
		
		MSFSysm0100BM sessionUser;
		String method = calledClass + ".activityOnYetaP23004ToYe162520";

		Ye162520DTO ye162520Dto = new Ye162520DTO();
		Ye162520VO ye162520Vo = new Ye162520VO();
			
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
			
		
		try {

			if (MSFSharedUtils.paramNull(ye162520DAO)) {
				
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				ye162520DAO = (Ye162520DAO) wac.getBean("Ye162520DAO");
				
			}
		            
			for (int iPsnlCnt = 0; iPsnlCnt < listYe162520Dto.size(); iPsnlCnt++) {
		                
				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

				ye162520Dto = new Ye162520DTO();
				ye162520Dto = listYe162520Dto.get(iPsnlCnt);
				ye162520Vo = new Ye162520VO();
					
					
				ye162520Vo.setDpobCd(sessionUser.getDpobCd());    																			/** column 사업장코드 : dpobCd */
				ye162520Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye162520Dto.getYrtxBlggYr()));    										/** column 연말정산귀속년도 : yrtxBlggYr */
				ye162520Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye162520Dto.getClutSeptCd()));    										/** column 정산구분코드 : clutSeptCd */
				ye162520Vo.setSystemkey(MSFSharedUtils.allowNulls(ye162520Dto.getSystemkey()));    											/** column SYSTEMKEY : systemkey */
				ye162520Vo.setComrCalnSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(ye162520Dto.getComrCalnSeilNum(), "0"))); 			/** column 금전소비대차일련번호 : comrCalnSeilNum */
				ye162520Vo.setTaxVvalKrnCd(MSFSharedUtils.allowNulls(ye162520Dto.getTaxVvalKrnCd()));    									/** column 국세청자료구분코드 : taxVvalKrnCd */
				
				ye162520Vo.setComrCdtrNm(MSFSharedUtils.allowNulls(ye162520Dto.getComrCdtrNm()));    										/** column G16_금전소비대차_대주성명 : comrCdtrNm */
				ye162520Vo.setComrCdtrResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult
						, MSFSharedUtils.allowNulls(ye162520Dto.getComrCdtrResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));    /** column G17_금전소비대차_대주주민등록번호 : comrCdtrResnRegnNum */
				ye162520Vo.setComrCnttPridBgnnDt(MSFSharedUtils.allowNulls(ye162520Dto.getComrCnttPridBgnnDt()));    						/** column G18_금전소비대차_계약기간시작일자 : comrCnttPridBgnnDt */
				ye162520Vo.setComrCnttPridEndDt(MSFSharedUtils.allowNulls(ye162520Dto.getComrCnttPridEndDt()));    							/** column G19_금전소비대차_계약기간종료일자 : comrCnttPridEndDt */
				ye162520Vo.setComrLoanItrtRate(new BigDecimal(MSFSharedUtils.defaultNulls(ye162520Dto.getComrLoanItrtRate(), "0")));		/** column G20_금전소비대차_차입금이자율 : comrLoanItrtRate */
				ye162520Vo.setComrPclttAmtftAggr(new BigDecimal(MSFSharedUtils.defaultNulls(ye162520Dto.getComrPclttAmtftAggr(), "0")));    /** column G21_금전소비대차_원리금상환액합계 : comrPclttAmtftAggr */
				ye162520Vo.setComrPrnilSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye162520Dto.getComrPrnilSum(), "0")));    			/** column G22_금전소비대차_원금금액 : comrPrnilSum */
				ye162520Vo.setComrItrtSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye162520Dto.getComrItrtSum(), "0")));    				/** column G23_금전소비대차_이자금액 : comrItrtSum */
				ye162520Vo.setComrDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye162520Dto.getComrDducSum(), "0")));    				/** column G24_금전소비대차_공제금액 : comrDducSum */
//				ye162520Vo.setEctnFlTrnrCtlYn(MSFSharedUtils.allowNulls(ye162520Dto.getEctnFlTrnrCtlYn()));    								/** column 전자파일이관여부 : ectnFlTrnrCtlYn */
				
				ye162520Vo.setIsmt(sessionUser.getUsrId());																					/** column 수정자 : ismt */
				ye162520Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 											/** column 수정주소 : revnAddr */
		            
				switch (actionDatabase) {
				case INSERT:

					ye162520Vo.setKybdr(sessionUser.getUsrId());																			/** column 입력자 : kybdr */
					ye162520Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());										/** column 입력주소 : inptAddr */

					ye162520DAO.insertYetaP23004ToYe162520(ye162520Vo);
					break;
					
				case UPDATE:
					
					ye162520DAO.updateYetaP23004ToYe162520(ye162520Vo);
					break;
					
				case DELETE:
					
					ye162520DAO.deleteYetaP23004ToYe162520(ye162520Vo);
					break;
					
				}

				iCnt = iCnt + 1;
				
				BeanUtils.copyProperties(infcPkgYe161010Vo , ye162520Vo);  
				yeta2300ListenerAdt = new Yeta2300ListenerAdapter();
				yeta2300ListenerAdt.fnYeta2300_Ye161010_2017_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE165010");

			}

			result = iCnt;

		} catch (Exception ex) {
		        	
			logger.error("EXCEPTION calling activityOnYetaP23004ToYe162520(): "+ex); 
		            
			/** 에러 로그 **/			
		    MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:U:D",ex, windowNm , windowId);
		            
		    result = new Long(0);
		    throw MSFServerUtils.getOperationException("activityOnYetaP23004ToYe162520", ex, logger);

		} finally {

		}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,"C:U:D");

		return result;
	}


	/** 거주자간 주택임차차입금 원리금 상환액 - 임대차계약 수정 삭제부 **/
	@Override
	public Long activityOnYetaP23004ToYe162530(List<Ye162530DTO> listYe162530Dto, ActionDatabase actionDatabase) throws MSFException {
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		BigDecimal seqn = new BigDecimal(0);

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETAP230004";
			
			
		MSFSysm0100BM sessionUser;
		String method = calledClass + ".activityOnYetaP23004ToYe162530";

		Ye162530DTO ye162530Dto = new Ye162530DTO();
		Ye162530VO ye162530Vo = new Ye162530VO();
			
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
			
		try {
			if (MSFSharedUtils.paramNull(ye162530DAO)) {
				
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
				ye162530DAO = (Ye162530DAO) wac.getBean("Ye162530DAO");
				
			}
		            
			for (int iPsnlCnt = 0; iPsnlCnt < listYe162530Dto.size(); iPsnlCnt++) {

				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
					
				ye162530Dto = new Ye162530DTO();
				ye162530Dto = listYe162530Dto.get(iPsnlCnt);

				ye162530Vo = new Ye162530VO();  
				
				ye162530Vo.setDpobCd(sessionUser.getDpobCd());    																			/** column 사업장코드 : dpobCd */
				ye162530Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye162530Dto.getYrtxBlggYr()));    										/** column 연말정산귀속년도 : yrtxBlggYr */
				ye162530Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye162530Dto.getClutSeptCd()));    										/** column 정산구분코드 : clutSeptCd */
				ye162530Vo.setSystemkey(MSFSharedUtils.allowNulls(ye162530Dto.getSystemkey()));    											/** column SYSTEMKEY : systemkey */
				ye162530Vo.setRntlCttSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(ye162530Dto.getRntlCttSeilNum(), "0")));    		/** column 임대차계약 일련번호 : rntlCttSeilNum */
				ye162530Vo.setTaxVvalKrnCd(MSFSharedUtils.allowNulls(ye162530Dto.getTaxVvalKrnCd()));    									/** column 국세청자료구분코드 : taxVvalKrnCd */
				
				ye162530Vo.setRntlCttLehdrNm(MSFSharedUtils.allowNulls(ye162530Dto.getRntlCttLehdrNm()));    								/** column G25_임대차계약_임대인성명_상호명 : rntlCttLehdrNm */
				
				ye162530Vo.setRntlCttBusoprRgstnum(AnyCryptUtils.getEncSyncCrypt(nResult
						, MSFSharedUtils.allowNulls(ye162530Dto.getRntlCttBusoprRgstnum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	/** column G26_임대차계약_주민_사업자등록번호 : rntlCttBusoprRgstnum */	
				
				ye162530Vo.setRntlCttHusFrmCd(MSFSharedUtils.allowNulls(ye162530Dto.getRntlCttHusFrmCd()));    								/** column G27_임대차계약_주택유형코드 : rntlCttHusFrmCd */
				ye162530Vo.setRntlCttHusCnttArea(new BigDecimal(MSFSharedUtils.defaultNulls(ye162530Dto.getRntlCttHusCnttArea(), "0")));	/** column G28_임대차계약_주택계약면적 : rntlCttHusCnttArea */
				ye162530Vo.setRntlCttAddr(MSFSharedUtils.allowNulls(ye162530Dto.getRntlCttAddr()));    										/** column G29_임대차계약_임대차계약서상주소지 : rntlCttAddr */
				ye162530Vo.setRntlCttPridBgnnDt(MSFSharedUtils.allowNulls(ye162530Dto.getRntlCttPridBgnnDt()));    							/** column G30_임대차계약_임대차계약기간시작일자 : rntlCttPridBgnnDt */
				ye162530Vo.setRntlCttPridEndDt(MSFSharedUtils.allowNulls(ye162530Dto.getRntlCttPridEndDt()));    							/** column G31_임대차계약_임대차계약기간종료일자 : rntlCttPridEndDt */
				ye162530Vo.setRntlCttChrtrGrnteSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye162530Dto.getRntlCttChrtrGrnteSum(), "0")));/** column G32_임대차계약_전세보증금액 : rntlCttChrtrGrnteSum */
//				ye162530Vo.setEctnFlTrnrCtlYn(MSFSharedUtils.allowNulls(ye162530Dto.getEctnFlTrnrCtlYn()));    								/** column 전자파일이관여부 : ectnFlTrnrCtlYn */				
				
				ye162530Vo.setIsmt(sessionUser.getUsrId());   																			 	/** column 수정자 : ismt */
				ye162530Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    										/** column 수정주소 : revnAddr */				
		            
		            
		            
				switch (actionDatabase) {
					case INSERT:

						ye162530Vo.setKybdr(sessionUser.getUsrId()); 																		/** column 입력자 : kybdr */ 
		        		ye162530Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());									/** column 입력주소 : inptAddr */ 
	        		
		        		ye162530DAO.insertYetaP23004ToYe162530(ye162530Vo); 
		        		
		        		break;
		        	
		            case UPDATE: 
		            	
		            	ye162530DAO.updateYetaP23004ToYe162530(ye162530Vo);
		            	break;
		            	
		            case DELETE: 
		            	ye162530DAO.deleteYetaP23004ToYe162530(ye162530Vo); 
		            	break;
		            	
				}

				iCnt = iCnt + 1;
			}

			result = iCnt;

		} catch (Exception ex) {
			
			logger.error("EXCEPTION calling activityOnYetaP23004ToYe162530(): "+ex); 
		            
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),ex, windowNm , windowId);
		            
			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnYetaP23004ToYe162530", ex, logger);
			
		} finally {

		}
			
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
	     * D:delete		S:select	B:배치 
	     * L:로그인		O:로그아웃
	     */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,actionDatabase.toString());

		return result;

	}
	
	
	/** 금전소비대차계약 조회 **/
	public PagingLoadResult<BaseModel> getYetaP23004ToYe162520DataList(ServiceParameters serviceParameters) throws MSFException {
			

			PagingLoadResult<BaseModel> retval = null;
			String method =  CLASS_YETAP23004_TO_YE162520_DATA_LIST;
			Ye162520SrhVO   ye162520SrhVo = new Ye162520SrhVO();
			List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			MSFSysm0100BM sessionUser;
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(ye162520DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				ye162520DAO = (Ye162520DAO) wac.getBean("Ye162520DAO"); 
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
		    	ye162520SrhVo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
		    	ye162520SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));	/** column 연말정산귀속년도 : yrtxBlggYr */
		    	ye162520SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd"))); /** column 정산구분코드 : clutSeptCd */
		    	ye162520SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));   /** column SYSTEMKEY : systemkey */
//		    	ye162520SrhVo.setComrCalnSeilNum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "comrCalnSeilNum")));    /** column 금전소비대차일련번호 : comrCalnSeilNum */

		    	
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
		                 
		          	int iResultCnt = ye162520DAO.selectYetaP23004ToYe162520ListTotCnt(ye162520SrhVo);  
		              
		          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
		          	
		          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                
		         	pagingValues.totalRecordCount = iResultCnt;	       
		                
		        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
				}
		        
		     	TimingInfo millisBeginYetaP23004ToYe162520DataList = SmrmfUtils.startTiming(logger);
		        
		     	/**페이지 카운트 처리를 위한 부분 */ 
		     	ye162520SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		ye162520SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		ye162520SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
		            
		     	@SuppressWarnings("unchecked")
//		            Collection<Map<String, Object>> list ??????
		     	List list = ye162520DAO.selectYetaP23004ToYe162520List(ye162520SrhVo);
		            
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
		          	   			
		          			if(	"comrCdtrResnRegnNum".equals(tableAttributes[i].getName())) {
		          		          			
		          		          			
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
		            
				SmrmfUtils.endTiming(logger, millisBeginYetaP23004ToYe162520DataList, "getYetaP23004ToYe162520DataList");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}
	
	
	/** 임대차계약 조회 **/
	public PagingLoadResult<BaseModel> getYetaP23004ToYe162530DataList(ServiceParameters serviceParameters) throws MSFException {
			

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETAP23004_TO_YE162530_DATA_LIST;
		Ye162530SrhVO ye162530SrhVo = new Ye162530SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		      
		if (MSFSharedUtils.paramNull(ye162530DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
			ye162530DAO = (Ye162530DAO) wac.getBean("Ye162530DAO");
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
		    	
		    	ye162530SrhVo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
		    	ye162530SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));	/** column 연말정산귀속년도 : yrtxBlggYr */
		    	ye162530SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd"))); /** column 정산구분코드 : clutSeptCd */
		    	ye162530SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));   /** column SYSTEMKEY : systemkey */
		    	
		            
		      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = ye162530DAO.selectYetaP23004ToYe162530ListTotCnt(ye162530SrhVo);  
		              
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
		     	ye162530SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		ye162530SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		ye162530SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
		            
		     	@SuppressWarnings("unchecked")
//		            Collection<Map<String, Object>> list ??????
		     	List list = ye162530DAO.selectYetaP23004ToYe162530List(ye162530SrhVo);
		            
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
		          	   			
		          			if(	"rntlCttBusoprRgstnum".equals(tableAttributes[i].getName())) {
		          		          			
		          		          			
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
 
 