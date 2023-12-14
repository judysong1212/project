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

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye165010DTO;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP23003Service;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye165010DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye165020DAO;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye165030DAO;
import com.app.exterms.yearendtax.server.vo.Ye165010SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye165010VO;
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

@Service("YetaP23003Service")
public class YetaP23003ServiceImpl  extends AbstractCustomServiceImpl implements YetaP23003Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(YetaP23003ServiceImpl.class);
	private static final String calledClass = YetaP23003ServiceImpl.class.getName();

	
	@Autowired
	@Resource(name = "Ye165010DAO")
	private Ye165010DAO ye165010DAO; 
	
	
	@Autowired
	@Resource(name = "Ye165020DAO")
	private Ye165020DAO ye165020DAO; 
	
	
	@Autowired
	@Resource(name = "Ye165030DAO")
	private Ye165030DAO ye165030DAO; 
	
	
	
	/** 이월기부금 신규 수정 삭제부 **/
	@Override
	public Long activityOnYetaP23003ToYe165010(List<Ye165010DTO> listYe165010Dto, ActionDatabase actionDatabase) throws MSFException {
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		BigDecimal seqn = new BigDecimal(0);
		MSFSysm0100BM sessionUser;

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETAP230003";
	        
		String method = calledClass + ".activityOnYetaP23003ToYe165010";

		
		Ye165010DTO ye165010Dto = new Ye165010DTO();
		Ye165010VO ye165010Vo = new Ye165010VO();
		
		InfcPkgYe161010VO infcPkgYe161010Vo = new InfcPkgYe161010VO(); 
		Yeta2300ListenerAdapter  yeta2300ListenerAdt = new Yeta2300ListenerAdapter();
		
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
			
			
		try {
			
			if (MSFSharedUtils.paramNull(ye165010DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
				ye165010DAO = (Ye165010DAO) wac.getBean("Ye165010DAO");
			}
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		            
			for(int iPsnlCnt=0;iPsnlCnt < listYe165010Dto.size();iPsnlCnt++) {
					
				ye165010Dto = new Ye165010DTO();
				ye165010Dto = listYe165010Dto.get(iPsnlCnt);

				ye165010Vo = new Ye165010VO();
				
				ye165010Vo.setDpobCd(sessionUser.getDpobCd());    															/** column 사업장코드 : dpobCd */
				ye165010Vo.setSystemkey(MSFSharedUtils.allowNulls(ye165010Dto.getSystemkey()));    							/** column SYSTEMKEY : systemkey */
				ye165010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye165010Dto.getYrtxBlggYr()));   				 		/** column 귀속연도 : yrtxBlggYr */
				ye165010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye165010Dto.getClutSeptCd()));    						/** column 연말정산구분코드 : clutSeptCd */
				ye165010Vo.setCnbtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(ye165010Dto.getCnbtSeilNum(), "0")));	/** column 기부금일련번호 : cnbtSeilNum */
				
				ye165010Vo.setConbCd(MSFSharedUtils.allowNulls(ye165010Dto.getConbCd()));    										/** column 기부유형 : conbCd */
				ye165010Vo.setConbChgCd(MSFSharedUtils.allowNulls(ye165010Dto.getConbChgCd()));    									/** column 기부코드 : conbChgCd */
				ye165010Vo.setYrsMateClCd(MSFSharedUtils.allowNulls(ye165010Dto.getYrsMateClCd()));    								/** column 기부자료구분코드 : yrsMateClCd */
				ye165010Vo.setDntcntn(MSFSharedUtils.allowNulls(ye165010Dto.getDntcntn()));    										/** column 기부내용 : dntcntn */
				ye165010Vo.setCoplNm(MSFSharedUtils.allowNulls(ye165010Dto.getCoplNm()));   					 					/** column 기부처_상호명 : coplNm */
				ye165010Vo.setBsnoEncCntn(MSFSharedUtils.allowNulls(ye165010Dto.getBsnoEncCntn()));    								/** column 기부처_사업자등록번호 : bsnoEncCntn */
				ye165010Vo.setCnbtRltClCd(MSFSharedUtils.allowNulls(ye165010Dto.getCnbtRltClCd()));    								/** column 기부자관계코드 : cnbtRltClCd */
				ye165010Vo.setCnbtFnm(MSFSharedUtils.allowNulls(ye165010Dto.getCnbtFnm()));    										/** column 기부자성명 : cnbtFnm */
				ye165010Vo.setResnoEncCntn(MSFSharedUtils.allowNulls(ye165010Dto.getResnoEncCntn()));    
				
				ye165010Vo.setResnoEncCntn(AnyCryptUtils.getEncSyncCrypt(nResult 
						, MSFSharedUtils.allowNulls(ye165010Dto.getResnoEncCntn()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	/** column 기부자_주민등록번호 : resnoEncCntn */
				
				
				ye165010Vo.setDntScnt(new BigDecimal(MSFSharedUtils.defaultNulls(ye165010Dto.getDntScnt(), "0")));    				/** column 기부명세건수 : dntScnt */
				ye165010Vo.setUseSumAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye165010Dto.getUseSumAmt(), "0")));    			/** column 기부명세합계금액 : useSumAmt */
				ye165010Vo.setConbSumAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye165010Dto.getConbSumAmt(), "0")));    		/** column 기부장려금신청금 : conbSumAmt */
				ye165010Vo.setCnbtEtc(MSFSharedUtils.defaultNulls(ye165010Dto.getCnbtEtc(), "0"));    								/** column 기부금기타 : cnbtEtc */
				
				// 공제금액 = 기부금액 - 기부장려신청금 - 기부금기타
				ye165010Vo.setDdcTrgtConbAmt(ye165010Vo.getUseSumAmt().subtract(
												ye165010Vo.getConbSumAmt().subtract(
													new BigDecimal(MSFSharedUtils.defaultNulls(ye165010Dto.getCnbtEtc(), "0")))));	/** column 공제대상기부금액 : ddcTrgtConbAmt */
				
				ye165010Vo.setIsmt(sessionUser.getUsrId());																			/** column 수정자 : ismt */
				ye165010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 									/** column 수정주소 : revnAddr */	
		            
		            
		            
				
				
				switch (actionDatabase) {
				case INSERT:

					ye165010Vo.setKybdr(sessionUser.getUsrId());										/** column 입력자 : kybdr */
					ye165010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */
					ye165010DAO.insertYetaP23003ToYe165010(ye165010Vo);
					break;
					
				case UPDATE:
					
					ye165010DAO.updateYetaP23003ToYe165010(ye165010Vo);
					break;
					
				case DELETE:
					
					ye165010DAO.deleteYetaP23003ToYe165010(ye165010Vo);
					break;
					
				}
				
				
				
				if (MSFSharedUtils.paramNotNull(ye165010Vo.getConbCd())) {
						BeanUtils.copyProperties(infcPkgYe161010Vo , ye165010Vo);  
						yeta2300ListenerAdt = new Yeta2300ListenerAdapter();
						yeta2300ListenerAdt.fnYeta2300_Ye161010_2017_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE165010");
				}
				
				iCnt = iCnt + 1;

			}
			
		
			
//			yeta2300ListenerAdt.fnYeta2300_Ye161010_2017_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE166020_NEW");
//			yeta2300ListenerAdt.fnYeta2300_Ye161010_2017_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE166020_INSERT");
			
			
			
			result = iCnt;

		} catch (Exception ex) {
			
			logger.error("EXCEPTION calling activityOnYetaP13001ToYeta3180(): "+ex); 
		            
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),ex, windowNm , windowId);
			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnYetaP23003ToYe165010", ex, logger);
			
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
	
	
	
	/** 기부금등록내역 조회 **/
	public PagingLoadResult<BaseModel> getYetaP23003ToYe165010DataList(ServiceParameters serviceParameters) throws MSFException {
			
		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETAP23003_TO_YE165010_DATA_LIST;
		Ye165010SrhVO ye165010SrhVo = new Ye165010SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		 
		        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		      
		if  (MSFSharedUtils.paramNull(ye165010DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
			ye165010DAO = (Ye165010DAO) wac.getBean("Ye165010DAO");
		}
		        
		try {

			// TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가
			ColumnAttribute[] tableAttributes = serviceParameters.getTableAttributes();
			IColumnFilter columnFilters = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders = serviceParameters.getColumnOrders();
			PagingLoadConfig pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			//Get paging configuration
		    PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

		    	//Get query parameters
		      	//String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
		    	
//		    	List<String> listDeptCd = new ArrayList<String>();    
		      	/** 조건절 */
		    ye165010SrhVo.setDpobCd(sessionUser.getDpobCd());    /** column 사업장코드 : dpobCd */
		    ye165010SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"))); 		/** column SYSTEMKEY : systemkey */
		    ye165010SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));    	/** column 귀속연도 : yrtxBlggYr */
		    ye165010SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));    	/** column 연말정산구분코드 : clutSeptCd */
//		    ye165010SrhVo.setCnbtSeilNum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "cnbtSeilNum"))); 	/** column 기부금일련번호 : cnbtSeilNum */
		    	
		    	
//		    	ye165010SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//		    	ye165010SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));   //systemkey
//		    	ye165010SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy")));	 	//연말정산귀속년도
//		    	ye165010SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd"))); 	//정산구분코드
		    	
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
		            
			// Get total record count //전체 데이터 갯수를 가지고 온다.
			if (pagingValues.executeRecordCount) {

				// Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = ye165010DAO.selectYetaP23003ToYe165010ListTotCnt(ye165010SrhVo);

				SmrmfUtils.endTiming(logger, millisBeginQueryCount,"QueryCount");

				// 페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) {
					pagingValues.offsetLimit = iResultCnt;
				}

				pagingValues.totalRecordCount = iResultCnt;

				logger.debug("totalRecordCount : "+ pagingValues.totalRecordCount);
			}
		        
			TimingInfo millisBeginPsnl0126DataList = SmrmfUtils.startTiming(logger);

			/** 페이지 카운트 처리를 위한 부분 */
			ye165010SrhVo.setPageSize(pagingValues.totalRecordCount);

			// Apply paging
			if (pagingValues.start > 0) {
				ye165010SrhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				ye165010SrhVo.setLastIndex(Math.min(pagingValues.start+ pagingValues.offsetLimit,pagingValues.totalRecordCount));
			}

			// Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			// Collection<Map<String, Object>> list ??????
			List list = ye165010DAO.selectYetaP23003ToYe165010List(ye165010SrhVo);

			Iterator<Map<String, Object>> iter = list.iterator();

			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
			
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			

			while (iter.hasNext()) {
					
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
		          	   			
		          			if(	"resnoEncCntn".equals(tableAttributes[i].getName())) {
		          		          			
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
		            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYetaP23003ToYe165010DataList");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
}
 