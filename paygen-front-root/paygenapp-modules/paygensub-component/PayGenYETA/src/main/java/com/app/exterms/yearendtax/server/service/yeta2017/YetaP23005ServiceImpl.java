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

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye162510DTO;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP23005Service;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye162510DAO;
import com.app.exterms.yearendtax.server.vo.Ye162510SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye162510VO;
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
 * @Class Name : YetaP23005ServiceImpl.java
 * @since : 2017. 12. 25. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@Service("YetaP23005Service")
public class YetaP23005ServiceImpl  extends AbstractCustomServiceImpl implements YetaP23005Service  ,YetaDaoConstants {

 
	private static final Logger logger = LoggerFactory.getLogger(YetaP23005ServiceImpl.class);
	private static final String calledClass = YetaP23005ServiceImpl.class.getName();
	  
	@Autowired
	@Resource(name = "Ye162510DAO")
	private Ye162510DAO ye162510DAO;  
	  
	  
	/** 월세액등록 - 월세액소득공제명세 수정 삭제부 **/
	@Override
	public Long  activityOnYetaP23005ToYe162510(List<Ye162510DTO> listYe162510Dto, ActionDatabase actionDatabase) throws MSFException {
		
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		BigDecimal seqn = new BigDecimal(0);

		MSFSysm0100BM sessionUser;
		String method = calledClass + ".activityOnYetaP23005ToYe162510";

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETAP230005";
		
		Ye162510DTO ye162510Dto = new Ye162510DTO();
		Ye162510VO ye162510Vo   = new Ye162510VO();  
		
		InfcPkgYe161010VO infcPkgYe161010Vo = new InfcPkgYe161010VO(); 
		Yeta2300ListenerAdapter  yeta2300ListenerAdt = new Yeta2300ListenerAdapter();

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
			
		try {
			
			if (MSFSharedUtils.paramNull(ye162510DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
				ye162510DAO = (Ye162510DAO) wac.getBean("Ye162510DAO");
			}
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		            
			for(int iPsnlCnt=0;iPsnlCnt < listYe162510Dto.size();iPsnlCnt++) {
					
				ye162510Dto = new Ye162510DTO();
				ye162510Dto = listYe162510Dto.get(iPsnlCnt);
		                 
				ye162510Vo  = new Ye162510VO();
				
				ye162510Vo.setDpobCd(sessionUser.getDpobCd());    																			/** column 사업장코드 : dpobCd */
				ye162510Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye162510Dto.getYrtxBlggYr()));    										/** column 연말정산귀속년도 : yrtxBlggYr */
				ye162510Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye162510Dto.getClutSeptCd()));    										/** column 정산구분코드 : clutSeptCd */
				ye162510Vo.setSystemkey(MSFSharedUtils.allowNulls(ye162510Dto.getSystemkey()));    											/** column SYSTEMKEY : systemkey */
				ye162510Vo.setMnthRntQntySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(ye162510Dto.getMnthRntQntySeilNum(), "0")));    /** column 월세액소득공제일련번호 : mnthRntQntySeilNum */
				ye162510Vo.setTaxVvalKrnCd(MSFSharedUtils.allowNulls(ye162510Dto.getTaxVvalKrnCd()));    									/** column 국세청자료구분코드 : taxVvalKrnCd */
				
				ye162510Vo.setMnthRnttyLehdrNm(MSFSharedUtils.allowNulls(ye162510Dto.getMnthRnttyLehdrNm()));    							/** column G7_월세액_임대인성명 : mnthRnttyLehdrNm */
				
				ye162510Vo.setMnthRnttyBurRgsum(AnyCryptUtils.getEncSyncCrypt(nResult
						, MSFSharedUtils.allowNulls(ye162510Dto.getMnthRnttyBurRgsum()),AnyCryptUtils.SEC_RRNUMC)); 						/** column G8_월세액_주민_사업자등록번호 : mnthRnttyBurRgsum */	
				
				ye162510Vo.setMnthRnttyHusFrmCd(MSFSharedUtils.allowNulls(ye162510Dto.getMnthRnttyHusFrmCd()));    							/** column G9_월세액_주택유형코드 : mnthRnttyHusFrmCd */
				ye162510Vo.setMnthRnttyHusCnttArea(new BigDecimal(MSFSharedUtils.defaultNulls(ye162510Dto.getMnthRnttyHusCnttArea(), "0")));/** column G10_월세액_주택계약면적 : mnthRnttyHusCnttArea */
				ye162510Vo.setMnthRnttyRntlAddr(MSFSharedUtils.allowNulls(ye162510Dto.getMnthRnttyRntlAddr()));    							/** column G11_월세액_임대차계약서상주소지 : mnthRnttyRntlAddr */
				ye162510Vo.setMnthRnttyRntlBgnnDt(MSFSharedUtils.allowNulls(ye162510Dto.getMnthRnttyRntlBgnnDt()));    						/** column G12_월세액_임대차계약기간시작일자 : mnthRnttyRntlBgnnDt */
				ye162510Vo.setMnthRnttyRntlEndDt(MSFSharedUtils.allowNulls(ye162510Dto.getMnthRnttyRntlEndDt()));    						/** column G13_월세액_임대차계약기간종료일자 : mnthRnttyRntlEndDt */
				ye162510Vo.setMnthRnttyYrlyMnthSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye162510Dto.getMnthRnttyYrlyMnthSum(), "0")));/** column G14_월세액_연간월세금액 : mnthRnttyYrlyMnthSum */
				ye162510Vo.setMnthRnttyTxDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(ye162510Dto.getMnthRnttyTxDducSum(), "0")));    /** column G15_월세액_세액공제금액 : mnthRnttyTxDducSum */
				ye162510Vo.setEctnFlTrnrCtlYn(MSFSharedUtils.allowNulls(ye162510Dto.getEctnFlTrnrCtlYn()));    								/** column 전자파일이관여부 : ectnFlTrnrCtlYn */				
				
		        ye162510Vo.setIsmt(sessionUser.getUsrId());												/** column 수정자 : ismt */
		        ye162510Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 		/** column 수정주소 : revnAddr */		            
		            
		            
				switch (actionDatabase) {
				case INSERT:

					ye162510Vo.setKybdr(sessionUser.getUsrId());										/** column 입력자 : kybdr */
					ye162510Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */

					ye162510DAO.insertYetaP23005ToYe162510(ye162510Vo);
					break;
				case UPDATE:
					ye162510DAO.updateYetaP23005ToYe162510(ye162510Vo);
					break;
				case DELETE:
					ye162510DAO.deleteYetaP23005ToYe162510(ye162510Vo);
					break;
				}
				
				iCnt = iCnt + 1;
				
				
				BeanUtils.copyProperties(infcPkgYe161010Vo , ye162510Vo);  
				yeta2300ListenerAdt.fnYeta2300_Ye161010_2017_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE162510");

			}
			result = iCnt;

		} catch (Exception ex) {
		        	
			logger.error("EXCEPTION calling activityOnYetaP23005ToYe162510(): "+ ex); 
		            
		    /** 에러 로그 **/			
		    MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), ex, windowNm , windowId);
		            
		    result = new Long(0);
		    throw MSFServerUtils.getOperationException("activityOnYetaP23005ToYe162510", ex, logger);
		    
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
	
	
	/** 월세액소득공제명세 조회 **/
	public PagingLoadResult<BaseModel> getYetaP23005ToYe162510DataList(ServiceParameters serviceParameters) throws MSFException {
			

			PagingLoadResult<BaseModel> retval = null;
			String method =  CLASS_YETAP23005_TO_YE162510_DATA_LIST;
			Ye162510SrhVO   ye162510SrhVo = new Ye162510SrhVO();
			List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(ye162510DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				ye162510DAO = (Ye162510DAO) wac.getBean("Ye162510DAO"); 
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
		    	ye162510SrhVo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
		    	ye162510SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));	/** column 연말정산귀속년도 : yrtxBlggYr */
		    	ye162510SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd"))); /** column 정산구분코드 : clutSeptCd */
		    	ye162510SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));	/** column SYSTEMKEY : systemkey */
//		    	ye162510SrhVo.setMnthRntQntySeilNum(ye162510Dto.getMnthRntQntySeilNum());    /** column 월세액소득공제일련번호 : mnthRntQntySeilNum */		    	
		    	
		    	
		    	
		    	
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
		                 
		          	int iResultCnt = ye162510DAO.selectYetaP23005ToYe162510ListTotCnt(ye162510SrhVo);  
		              
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
		     	ye162510SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		ye162510SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		ye162510SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
		            
		     	@SuppressWarnings("unchecked")
//		            Collection<Map<String, Object>> list ??????
		     	List list = ye162510DAO.selectYetaP23005ToYe162510List(ye162510SrhVo);
		            
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

		          	        }else if("mnrnRsno".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;

		          	        }else if("mnthRnttyBurRgsum".equals(tableAttributes[i].getName())) {

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
		            
				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYetaP13005To3130List");
		       
			} catch (Exception ex) {
				ex.printStackTrace();
				//Return operation exception
				throw MSFServerUtils.getOperationException(method, ex, logger);
			}
			return retval;
		}	
			
	  	  
	  
	  
	  
	  
	  
} 