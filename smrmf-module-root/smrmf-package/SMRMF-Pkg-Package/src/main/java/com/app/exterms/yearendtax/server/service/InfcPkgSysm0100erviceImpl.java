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
package com.app.exterms.yearendtax.server.service;

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

import com.app.exterms.yearendtax.client.dto.InfcPkgSysm0100DTO;
import com.app.exterms.yearendtax.client.service.InfcPkgSysm0100Service;
import com.app.exterms.yearendtax.shared.InfcPkgSysmDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysauth.system.server.service.dao.InfcPkgSysm0100DAO;
import com.app.smrmf.infc.sysauth.system.server.service.dao.InfcPkgSysm0500DAO;
import com.app.smrmf.infc.sysauth.system.server.vo.InfcPkgSysm0100SrhVO;
import com.app.smrmf.infc.sysauth.system.server.vo.InfcPkgSysm0100VO;
import com.app.smrmf.infc.sysauth.system.server.vo.InfcPkgSysm0500VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("InfcPkgSysm0100Service")
public class InfcPkgSysm0100erviceImpl extends AbstractCustomServiceImpl implements InfcPkgSysm0100Service, InfcPkgSysmDaoConstants {
	
	private static final Logger logger = LoggerFactory.getLogger(InfcPkgSysm0100erviceImpl.class);
	private static final String calledClass = InfcPkgSysm0100erviceImpl.class.getName();
	
	@Autowired
	@Resource(name = "InfcPkgSysm0100DAO")
	private InfcPkgSysm0100DAO infcPkgSysm0100DAO;
	
	@Autowired
	@Resource(name = "InfcPkgSysm0500DAO")
	private InfcPkgSysm0500DAO infcPkgSysm0500DAO;
	
	/** 연말정산등록담당자 조회 **/
	public PagingLoadResult<BaseModel> getYeta2080ToInfcPkgSysm0100OffList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA2080_TO_SYSM0100_OFF_LIST;
		
		InfcPkgSysm0100SrhVO infcPkgSysm0100SrhVo = new InfcPkgSysm0100SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(infcPkgSysm0100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				infcPkgSysm0100DAO = (InfcPkgSysm0100DAO) wac.getBean("InfcPkgSysm0100DAO"); 
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
		    	infcPkgSysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자성명 : usrNm */   
		    	infcPkgSysm0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));    				/** column 부서코드 : deptCd */
		    	infcPkgSysm0100SrhVo.setUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "useYn")));    				/** column 사용자사용여부 : useYn */
		    	infcPkgSysm0100SrhVo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxInptPrcsYn"))); 	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
		    	
		    	// Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = infcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt(infcPkgSysm0100SrhVo);  
		              
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
		     	infcPkgSysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		infcPkgSysm0100SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		infcPkgSysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = infcPkgSysm0100DAO.selectYeta2080ToSysm0100List(infcPkgSysm0100SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) { 

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("usrId").toString();
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
		                     
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}	
	
	/** 연말정산등록담당자 조회 **/
	public PagingLoadResult<BaseModel> getYeta3080ToInfcPkgSysm0100OffList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA2080_TO_SYSM0100_OFF_LIST;
		
		InfcPkgSysm0100SrhVO infcPkgSysm0100SrhVo = new InfcPkgSysm0100SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(infcPkgSysm0100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				infcPkgSysm0100DAO = (InfcPkgSysm0100DAO) wac.getBean("InfcPkgSysm0100DAO"); 
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
		    	infcPkgSysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자성명 : usrNm */   
		    	infcPkgSysm0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));    				/** column 부서코드 : deptCd */
		    	infcPkgSysm0100SrhVo.setUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "useYn")));    				/** column 사용자사용여부 : useYn */
		    	infcPkgSysm0100SrhVo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxInptPrcsYn"))); 	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
		    	
		    	// Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = infcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt(infcPkgSysm0100SrhVo);  
		              
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
		     	infcPkgSysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		infcPkgSysm0100SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		infcPkgSysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = infcPkgSysm0100DAO.selectYeta2080ToSysm0100List(infcPkgSysm0100SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) { 

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("usrId").toString();
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
		                     
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}	
		
	/** 2019 연말정산등록담당자 조회 **/
	public PagingLoadResult<BaseModel> getYeta4080ToInfcPkgSysm0100OffList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA2080_TO_SYSM0100_OFF_LIST;
		
		InfcPkgSysm0100SrhVO infcPkgSysm0100SrhVo = new InfcPkgSysm0100SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(infcPkgSysm0100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				infcPkgSysm0100DAO = (InfcPkgSysm0100DAO) wac.getBean("InfcPkgSysm0100DAO"); 
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
		    	infcPkgSysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자성명 : usrNm */   
		    	infcPkgSysm0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));    				/** column 부서코드 : deptCd */
		    	infcPkgSysm0100SrhVo.setUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "useYn")));    				/** column 사용자사용여부 : useYn */
		    	infcPkgSysm0100SrhVo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxInptPrcsYn"))); 	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
		    	
		    	// Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = infcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt(infcPkgSysm0100SrhVo);  
		              
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
		     	infcPkgSysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		infcPkgSysm0100SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		infcPkgSysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = infcPkgSysm0100DAO.selectYeta2080ToSysm0100List(infcPkgSysm0100SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) { 

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("usrId").toString();
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
		                     
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	//============================================================================================================================================2019
	
	
	/** 2020 연말정산등록담당자 조회 **/
	public PagingLoadResult<BaseModel> getYeta5080ToInfcPkgSysm0100OffList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA2080_TO_SYSM0100_OFF_LIST;
		
		InfcPkgSysm0100SrhVO infcPkgSysm0100SrhVo = new InfcPkgSysm0100SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(infcPkgSysm0100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				infcPkgSysm0100DAO = (InfcPkgSysm0100DAO) wac.getBean("InfcPkgSysm0100DAO"); 
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
		    	infcPkgSysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자성명 : usrNm */   
		    	infcPkgSysm0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));    				/** column 부서코드 : deptCd */
		    	infcPkgSysm0100SrhVo.setUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "useYn")));    				/** column 사용자사용여부 : useYn */
		    	infcPkgSysm0100SrhVo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxInptPrcsYn"))); 	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
		    	
		    	// Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = infcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt(infcPkgSysm0100SrhVo);  
		              
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
		     	infcPkgSysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		infcPkgSysm0100SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		infcPkgSysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = infcPkgSysm0100DAO.selectYeta2080ToSysm0100List(infcPkgSysm0100SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) { 

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("usrId").toString();
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
		                     
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	//============================================================================================================================================2020
	
	
	
	
	/** 2021 연말정산등록담당자 조회 **/
	public PagingLoadResult<BaseModel> getYeta6080ToInfcPkgSysm0100OffList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA2080_TO_SYSM0100_OFF_LIST;
		
		InfcPkgSysm0100SrhVO infcPkgSysm0100SrhVo = new InfcPkgSysm0100SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(infcPkgSysm0100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				infcPkgSysm0100DAO = (InfcPkgSysm0100DAO) wac.getBean("InfcPkgSysm0100DAO"); 
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
		    	infcPkgSysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자성명 : usrNm */   
		    	infcPkgSysm0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));    				/** column 부서코드 : deptCd */
		    	infcPkgSysm0100SrhVo.setUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "useYn")));    				/** column 사용자사용여부 : useYn */
		    	infcPkgSysm0100SrhVo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxInptPrcsYn"))); 	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
		    	
		    	// Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = infcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt(infcPkgSysm0100SrhVo);  
		              
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
		     	infcPkgSysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		infcPkgSysm0100SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		infcPkgSysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = infcPkgSysm0100DAO.selectYeta2080ToSysm0100List(infcPkgSysm0100SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) { 

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("usrId").toString();
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
		                     
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	//============================================================================================================================================2021
	
	
	
	
	
	
	
	/** 2022 연말정산등록담당자 조회 **/
	public PagingLoadResult<BaseModel> getYeta7080ToInfcPkgSysm0100OffList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA2080_TO_SYSM0100_OFF_LIST;
		
		InfcPkgSysm0100SrhVO infcPkgSysm0100SrhVo = new InfcPkgSysm0100SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(infcPkgSysm0100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				infcPkgSysm0100DAO = (InfcPkgSysm0100DAO) wac.getBean("InfcPkgSysm0100DAO"); 
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
		    	infcPkgSysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자성명 : usrNm */   
		    	infcPkgSysm0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));    				/** column 부서코드 : deptCd */
		    	infcPkgSysm0100SrhVo.setUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "useYn")));    				/** column 사용자사용여부 : useYn */
		    	infcPkgSysm0100SrhVo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxInptPrcsYn"))); 	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
		    	
		    	// Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = infcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt(infcPkgSysm0100SrhVo);  
		              
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
		     	infcPkgSysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		infcPkgSysm0100SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		infcPkgSysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = infcPkgSysm0100DAO.selectYeta2080ToSysm0100List(infcPkgSysm0100SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) { 

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("usrId").toString();
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
		                     
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	//============================================================================================================================================2022
	
	
	
	
	
	/** 2023 연말정산등록담당자 조회 **/
	public PagingLoadResult<BaseModel> getYeta8080ToInfcPkgSysm0100OffList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA2080_TO_SYSM0100_OFF_LIST;
		
		InfcPkgSysm0100SrhVO infcPkgSysm0100SrhVo = new InfcPkgSysm0100SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(infcPkgSysm0100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				infcPkgSysm0100DAO = (InfcPkgSysm0100DAO) wac.getBean("InfcPkgSysm0100DAO"); 
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
		    	infcPkgSysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자성명 : usrNm */   
		    	infcPkgSysm0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));    				/** column 부서코드 : deptCd */
		    	infcPkgSysm0100SrhVo.setUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "useYn")));    				/** column 사용자사용여부 : useYn */
		    	infcPkgSysm0100SrhVo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxInptPrcsYn"))); 	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
		    	
		    	// Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = infcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt(infcPkgSysm0100SrhVo);  
		              
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
		     	infcPkgSysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		infcPkgSysm0100SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		infcPkgSysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = infcPkgSysm0100DAO.selectYeta2080ToSysm0100List(infcPkgSysm0100SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) { 

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("usrId").toString();
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
		                     
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	//============================================================================================================================================2023
	
	
	
	
	
	
	
	
 
	/** 연말정산등록담당자 조회 **/
	public PagingLoadResult<BaseModel> getYeta2080ToInfcPkgSysm0100OnList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA2080_TO_SYSM0100_ON_LIST;
		
		InfcPkgSysm0100SrhVO infcPkgSysm0100SrhVo = new InfcPkgSysm0100SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(infcPkgSysm0100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				infcPkgSysm0100DAO = (InfcPkgSysm0100DAO) wac.getBean("InfcPkgSysm0100DAO"); 
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
		    	infcPkgSysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자성명 : usrNm */   
		    	infcPkgSysm0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));    				/** column 부서코드 : deptCd */
		    	infcPkgSysm0100SrhVo.setUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "useYn")));    				/** column 사용자사용여부 : useYn */
		    	infcPkgSysm0100SrhVo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxInptPrcsYn"))); 	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
		    	
		    	// Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = infcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt(infcPkgSysm0100SrhVo);  
		              
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
		     	infcPkgSysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		infcPkgSysm0100SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		infcPkgSysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = infcPkgSysm0100DAO.selectYeta2080ToSysm0100List(infcPkgSysm0100SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) { 

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("usrId").toString();
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
		                     
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
    
	/** 연말정산등록담당자 조회 **/
	public PagingLoadResult<BaseModel> getYeta3080ToInfcPkgSysm0100OnList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA2080_TO_SYSM0100_ON_LIST;
		
		InfcPkgSysm0100SrhVO infcPkgSysm0100SrhVo = new InfcPkgSysm0100SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(infcPkgSysm0100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				infcPkgSysm0100DAO = (InfcPkgSysm0100DAO) wac.getBean("InfcPkgSysm0100DAO"); 
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
		    	infcPkgSysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자성명 : usrNm */   
		    	infcPkgSysm0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));    				/** column 부서코드 : deptCd */
		    	infcPkgSysm0100SrhVo.setUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "useYn")));    				/** column 사용자사용여부 : useYn */
		    	infcPkgSysm0100SrhVo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxInptPrcsYn"))); 	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
		    	
		    	// Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = infcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt(infcPkgSysm0100SrhVo);  
		              
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
		     	infcPkgSysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		infcPkgSysm0100SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		infcPkgSysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = infcPkgSysm0100DAO.selectYeta2080ToSysm0100List(infcPkgSysm0100SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) { 

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("usrId").toString();
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
		                     
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	/** 2019 연말정산등록담당자 조회 **/
	public PagingLoadResult<BaseModel> getYeta4080ToInfcPkgSysm0100OnList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA2080_TO_SYSM0100_ON_LIST;
		
		InfcPkgSysm0100SrhVO infcPkgSysm0100SrhVo = new InfcPkgSysm0100SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(infcPkgSysm0100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				infcPkgSysm0100DAO = (InfcPkgSysm0100DAO) wac.getBean("InfcPkgSysm0100DAO"); 
			}
		        
			try {
				//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
				ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
				IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
				List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
				PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

				//Get paging configuration
		    	PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
		      	/** 조건절 */
		    	infcPkgSysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자성명 : usrNm */   
		    	infcPkgSysm0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));    				/** column 부서코드 : deptCd */
		    	infcPkgSysm0100SrhVo.setUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "useYn")));    				/** column 사용자사용여부 : useYn */
		    	infcPkgSysm0100SrhVo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxInptPrcsYn"))); 	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
		    	
		    	// Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = infcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt(infcPkgSysm0100SrhVo);  
		              
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
		     	infcPkgSysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		infcPkgSysm0100SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		infcPkgSysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = infcPkgSysm0100DAO.selectYeta2080ToSysm0100List(infcPkgSysm0100SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) { 

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("usrId").toString();
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
		                     
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	//=============================================================================================================================2019
	
	
	
	
	/** 2020 연말정산등록담당자 조회 **/
	public PagingLoadResult<BaseModel> getYeta5080ToInfcPkgSysm0100OnList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA2080_TO_SYSM0100_ON_LIST;
		
		InfcPkgSysm0100SrhVO infcPkgSysm0100SrhVo = new InfcPkgSysm0100SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(infcPkgSysm0100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				infcPkgSysm0100DAO = (InfcPkgSysm0100DAO) wac.getBean("InfcPkgSysm0100DAO"); 
			}
		        
			try {
				//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
				ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
				IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
				List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
				PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

				//Get paging configuration
		    	PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
		      	/** 조건절 */
		    	infcPkgSysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자성명 : usrNm */   
		    	infcPkgSysm0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));    				/** column 부서코드 : deptCd */
		    	infcPkgSysm0100SrhVo.setUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "useYn")));    				/** column 사용자사용여부 : useYn */
		    	infcPkgSysm0100SrhVo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxInptPrcsYn"))); 	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
		    	
		    	// Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = infcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt(infcPkgSysm0100SrhVo);  
		              
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
		     	infcPkgSysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		infcPkgSysm0100SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		infcPkgSysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = infcPkgSysm0100DAO.selectYeta2080ToSysm0100List(infcPkgSysm0100SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) { 

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("usrId").toString();
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
		                     
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	//=============================================================================================================================2020
	
	
	
	
	
	/** 2021 연말정산등록담당자 조회 **/
	public PagingLoadResult<BaseModel> getYeta6080ToInfcPkgSysm0100OnList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA2080_TO_SYSM0100_ON_LIST;
		
		InfcPkgSysm0100SrhVO infcPkgSysm0100SrhVo = new InfcPkgSysm0100SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(infcPkgSysm0100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				infcPkgSysm0100DAO = (InfcPkgSysm0100DAO) wac.getBean("InfcPkgSysm0100DAO"); 
			}
		        
			try {
				//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
				ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
				IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
				List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
				PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

				//Get paging configuration
		    	PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
		      	/** 조건절 */
		    	infcPkgSysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자성명 : usrNm */   
		    	infcPkgSysm0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));    				/** column 부서코드 : deptCd */
		    	infcPkgSysm0100SrhVo.setUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "useYn")));    				/** column 사용자사용여부 : useYn */
		    	infcPkgSysm0100SrhVo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxInptPrcsYn"))); 	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
		    	
		    	// Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = infcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt(infcPkgSysm0100SrhVo);  
		              
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
		     	infcPkgSysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		infcPkgSysm0100SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		infcPkgSysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = infcPkgSysm0100DAO.selectYeta2080ToSysm0100List(infcPkgSysm0100SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) { 

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("usrId").toString();
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
		                     
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	//=============================================================================================================================2021
	
	
	
	
	
	/** 2022 연말정산등록담당자 조회 **/
	public PagingLoadResult<BaseModel> getYeta7080ToInfcPkgSysm0100OnList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA2080_TO_SYSM0100_ON_LIST;
		
		InfcPkgSysm0100SrhVO infcPkgSysm0100SrhVo = new InfcPkgSysm0100SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(infcPkgSysm0100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				infcPkgSysm0100DAO = (InfcPkgSysm0100DAO) wac.getBean("InfcPkgSysm0100DAO"); 
			}
		        
			try {
				//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
				ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
				IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
				List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
				PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

				//Get paging configuration
		    	PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
		      	/** 조건절 */
		    	infcPkgSysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자성명 : usrNm */   
		    	infcPkgSysm0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));    				/** column 부서코드 : deptCd */
		    	infcPkgSysm0100SrhVo.setUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "useYn")));    				/** column 사용자사용여부 : useYn */
		    	infcPkgSysm0100SrhVo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxInptPrcsYn"))); 	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
		    	
		    	// Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = infcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt(infcPkgSysm0100SrhVo);  
		              
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
		     	infcPkgSysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		infcPkgSysm0100SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		infcPkgSysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = infcPkgSysm0100DAO.selectYeta2080ToSysm0100List(infcPkgSysm0100SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) { 

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("usrId").toString();
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
		                     
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	//=============================================================================================================================2022
	
	
	
	
	/** 2023 연말정산등록담당자 조회 **/
	public PagingLoadResult<BaseModel> getYeta8080ToInfcPkgSysm0100OnList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA2080_TO_SYSM0100_ON_LIST;
		
		InfcPkgSysm0100SrhVO infcPkgSysm0100SrhVo = new InfcPkgSysm0100SrhVO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(infcPkgSysm0100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				infcPkgSysm0100DAO = (InfcPkgSysm0100DAO) wac.getBean("InfcPkgSysm0100DAO"); 
			}
		        
			try {
				//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
				ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
				IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
				List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
				PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

				//Get paging configuration
		    	PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
		      	/** 조건절 */
		    	infcPkgSysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자성명 : usrNm */   
		    	infcPkgSysm0100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));    				/** column 부서코드 : deptCd */
		    	infcPkgSysm0100SrhVo.setUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "useYn")));    				/** column 사용자사용여부 : useYn */
		    	infcPkgSysm0100SrhVo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxInptPrcsYn"))); 	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
		    	
		    	// Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = infcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt(infcPkgSysm0100SrhVo);  
		              
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
		     	infcPkgSysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		infcPkgSysm0100SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		infcPkgSysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = infcPkgSysm0100DAO.selectYeta2080ToSysm0100List(infcPkgSysm0100SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
				while (iter.hasNext()) { 

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("usrId").toString();
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
		                     
		          		case ColumnDef.TYPE_STRING: 
		          		          			          			
		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	//=============================================================================================================================2023
	
	
	
	
	
    	
	/** 연말정산담당자 등록 **/
	@Override
	public int updateInfcPkgSysm0100Yn(List<InfcPkgSysm0100DTO> lsInfcPkgSysm0100Dto) throws MSFException  {
    	
        // TODO Auto-generated method stub
        int result = 0;
        
        InfcPkgSysm0100VO  infcPkgSysm0100Vo 	= new InfcPkgSysm0100VO();
        InfcPkgSysm0500VO  infcPkgSysm0500Vo 	= new InfcPkgSysm0500VO();
        InfcPkgSysm0100DTO infcPkgSysm0100Dto 	= new InfcPkgSysm0100DTO();
        
        try { 
        	
        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        	
        	for(int i = 0; i < lsInfcPkgSysm0100Dto.size(); i ++) {
        		
        		infcPkgSysm0100Dto 	= new InfcPkgSysm0100DTO();
        		infcPkgSysm0100Vo 	= new InfcPkgSysm0100VO();
        		infcPkgSysm0500Vo 	= new InfcPkgSysm0500VO();
        		
        		infcPkgSysm0100Dto 	= lsInfcPkgSysm0100Dto.get(i);
        		
        		infcPkgSysm0100Vo.setSysDivCd(MSFSharedUtils.allowNulls(infcPkgSysm0100Dto.getSysDivCd()));    			/** column 시스템구분코드 : sysDivCd */
        		infcPkgSysm0100Vo.setUsrId(MSFSharedUtils.allowNulls(infcPkgSysm0100Dto.getUsrId()));    				/** column 사용자아이디 : usrId */
        		infcPkgSysm0100Vo.setUsrNm(MSFSharedUtils.allowNulls(infcPkgSysm0100Dto.getUsrNm()));    				/** column 사용자성명 : usrNm */
        		infcPkgSysm0100Vo.setUsrDivCd(MSFSharedUtils.allowNulls(infcPkgSysm0100Dto.getUsrDivCd()));    			/** column 사용자권한구분코드 : usrDivCd */
        		infcPkgSysm0100Vo.setSystemkey(MSFSharedUtils.allowNulls(infcPkgSysm0100Dto.getSystemkey()));    		/** column SYSTEMKEY : systemkey */
        		infcPkgSysm0100Vo.setDeptCd(MSFSharedUtils.allowNulls(infcPkgSysm0100Dto.getDeptCd()));    				/** column 부서코드 : deptCd */
        		infcPkgSysm0100Vo.setPayMangeDeptCd(MSFSharedUtils.allowNulls(infcPkgSysm0100Dto.getPayMangeDeptCd()));	/** column 단위기관코드 : payMangeDeptCd */  							
        		infcPkgSysm0100Vo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(infcPkgSysm0100Dto.getYrtxInptPrcsYn())); /** column 연말정산입력처리여부 : yrtxInptPrcsYn */
        		
        		infcPkgSysm0100Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    						/** column 수정자 : ismt */
        		infcPkgSysm0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 				/** column 수정주소 : revnAddr */
				
        		result += infcPkgSysm0100DAO.updaetYeta2080ToSysm0100Yn(infcPkgSysm0100Vo);
        		
        		
        		
        		infcPkgSysm0500Vo.setSysDivCd(MSFSharedUtils.allowNulls(infcPkgSysm0100Vo.getSysDivCd()));	/** column 시스템구분코드 : sysDivCd */
        		infcPkgSysm0500Vo.setAuthGrpSeilNum(new BigDecimal("25"));    								/** column 권한그룹일련번호 : authGrpSeilNum */
        		infcPkgSysm0500Vo.setUsrId(infcPkgSysm0100Vo.getUsrId());    								/** column 사용자아이디 : usrId */
        		infcPkgSysm0500Vo.setUsrAuthUseYn("Y");    													/** column 사용자권한사용여부 : usrAuthUseYn */
        		
        		infcPkgSysm0500Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    			/** column 입력자 : kybdr */
        		infcPkgSysm0500Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    			/** column 수정자 : ismt */
        		infcPkgSysm0500Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 	/** column 수정주소 : revnAddr */
        		infcPkgSysm0500Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 	/** column 입력주소 : inptAddr */
        		
        		
        		if("N".equals(infcPkgSysm0100Vo.getYrtxInptPrcsYn())) {
        			infcPkgSysm0500DAO.deleteYeta2080ToSysm0500(infcPkgSysm0500Vo);
        		}else {
        			infcPkgSysm0500DAO.deleteYeta2080ToSysm0500(infcPkgSysm0500Vo);
        			infcPkgSysm0500DAO.insertYeta2080ToSysm0500(infcPkgSysm0500Vo);
        		}
        		
        	}
           
            
        } catch (Exception ex) {
          
        	logger.error("EXCEPTION calling updateInfcPkgSysm0100Yn(): "+ex); 
            result = 0;
            throw MSFServerUtils.getOperationException("updateInfcPkgSysm0100Yn()", ex, logger);
        
        }finally {
          
        }
        
        return result;
    }
	

	 
  
}
