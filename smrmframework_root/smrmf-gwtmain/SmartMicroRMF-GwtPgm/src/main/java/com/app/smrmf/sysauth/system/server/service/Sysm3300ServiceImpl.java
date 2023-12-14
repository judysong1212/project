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
package com.app.smrmf.sysauth.system.server.service;
 
 
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

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfHist0300DTO;
import com.app.smrmf.sysauth.system.client.service.Sysm3300Service;
import com.app.smrmf.sysauth.system.shared.SysmDaoConstants;
import com.app.smrmf.sysm.server.service.dao.SysmHist0300DAO;
import com.app.smrmf.sysm.server.vo.SysIfHist0300SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfHist0300VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

/**
 * 
* <pre>
* 1. 패키지명 : com.app.exterms.yearendtax.server.service
* 2. 타입명 : Stts0300ServiceImpl.java
* 3. 작성일 : Jan 13, 2016 5:12:49 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Service("Sysm3300Service")
public class Sysm3300ServiceImpl  extends AbstractCustomServiceImpl implements Sysm3300Service, SysmDaoConstants {

	// private  static final Logger LOGGER = LoggerFactory.getLogger(Stts0300ServiceImpl.class);
	// private static final String calledClass = Stts0300ServiceImpl.class.getName();
	  private static final Logger logger = LoggerFactory.getLogger(Sysm3300ServiceImpl.class);
	  private static final String calledClass = Sysm3300ServiceImpl.class.getName();
	  
	  
	    @Autowired
	    @Resource(name="SysmHist0300DAO")
	    private SysmHist0300DAO hist0300DAO;  
	  
	  /** 
	     * 사용자 접속 로그 조회
	     * @param serviceParameters
	     * @return
	     * @throws MSFException
	     */
	    public PagingLoadResult<BaseModel> getHist0300DataList(ServiceParameters serviceParameters) throws MSFException {

 	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_HIST0300_DATA_LIST;
	        SysIfHist0300SrhVO   hist0300SrhVo = new SysIfHist0300SrhVO();
	        SysIfHist0300VO      hist0300Vo = new SysIfHist0300VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(hist0300DAO)) {
	        
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            hist0300DAO = (SysmHist0300DAO) wac.getBean("SysmHist0300DAO"); 
	        }
	        
	        try {
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	           // Sysm0400BM          user             = serviceParameters.getUser();
	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

	            //Get paging configuration
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	            //Get query parameters
	            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	              
	            List<String> listDeptCd = new ArrayList<String>();
	            /** 조건절 */
	            hist0300SrhVo.setDpobCd(sessionUser.getDpobCd());   													 												/** column 사업장코드 : dpobCd */
	            hist0300SrhVo.setUsrConnectDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,  "usrConnectDivCd")));    		/** column 사용자접속구분코드 : usrConnectDivCd */
 
	            hist0300SrhVo.setErrOccrrncDtntmS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,  "errOccrrncDtntmS")));    	/** column 에러발생일시 : errOccrrncDtntm */
	            hist0300SrhVo.setErrOccrrncDtntmE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,  "errOccrrncDtntmE")));    	/** column 에러발생일시 : errOccrrncDtntm */
	              
	            hist0300SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	            listDeptCd = MSFSharedUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	            hist0300SrhVo.setDeptCdArr(listDeptCd);    																													/** column 부서코드 : deptCd */
	             
	            hist0300SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,  "systemkey")));    						/** column systemkey : systemkey */
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	             if ( pagingValues.executeRecordCount ) { 
	                    
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = hist0300DAO.selectHist0300ListTotCnt(hist0300SrhVo);  
	                
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;        
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginPsnl0300ToRemt0300DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            hist0300SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	hist0300SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	hist0300SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list  
	            List list = hist0300DAO.selectHist0300List(hist0300SrhVo);
	            
	            Iterator<Map<String, Object>> iter = list.iterator();
	                
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	            
	        
	            while ( iter.hasNext() ) {
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginPsnl0300ToRemt0300DataList, "getHist0300DataList");
	       

	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    } 
	  
	  
		@Override
		public int deleteHist0300(List<SysIfHist0300DTO> listHist0300dto) throws MSFException {
			// TODO Auto-generated method stub
			
			int returnVal = 0;
			
			SysIfHist0300SrhVO hist0300SrhVo = new SysIfHist0300SrhVO();
			
			String method = calledClass + ".deleteHist0300";
			MSFSysm0100BM sessionUser;

			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
			
			try{
				
	            for(int iHistCnt=0; iHistCnt < listHist0300dto.size(); iHistCnt++) {
	            	
	            	SysIfHist0300DTO hist0300Dto = new SysIfHist0300DTO();  
	            	hist0300Dto = listHist0300dto.get(iHistCnt);   
	            	
	            	hist0300SrhVo.setDpobCd(MSFSharedUtils.allowNulls(hist0300Dto.getDpobCd()));    														/** column 사업장코드 : dpobCd */
	            	hist0300SrhVo.setErrOccrrncYr(MSFSharedUtils.allowNulls(hist0300Dto.getErrOccrrncYr()));    											/** column 에러발생년도 errOccrrncYr */
	            	hist0300SrhVo.setUsrId(MSFSharedUtils.allowNulls(hist0300Dto.getUsrId()));   																/** column 사용자아이디 : usrId */
	            	hist0300SrhVo.setErrSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(hist0300Dto.getErrSeilNum(),"0")))						;/** column 에러일련번호 : errSeilNum */
	            	
	            	hist0300DAO.deleteHist0300(hist0300SrhVo);
	            	
	            	returnVal++;
				}
	            
			}catch(Exception e) {
				
				e.printStackTrace();
				throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C   //create  
	    	 * R   //read
	    	 * U   //update
	    	 * D   //delete
	    	 * S   //select
	    	 * B   //배치 
	    	 * L   //로그인 
	    	 * O   //로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D");
			
			return returnVal;
			
		}
		
		/** 시간을 가져옴 **/
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public List<BaseModel> getHourList() throws MSFException {
			
			List<BaseModel> returnValue = new ArrayList<BaseModel>();
			List egovResultDataList = new ArrayList();
			
			String method = calledClass + ".getHourList";
			MSFSysm0100BM sessionUser;

			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
			
			try{
				
				egovResultDataList = hist0300DAO.getHourList();
				
				/** 로그반영
				 * CRUDSBLO
				 * C   //create  
		    	 * R   //read
		    	 * U   //update
		    	 * D   //delete
		    	 * S   //select
		    	 * B   //배치 
		    	 * L   //로그인 
		    	 * O   //로그아웃
		    	 */
//				MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
				
				if(egovResultDataList != null && egovResultDataList.size() > 0){
					for(int i = 0 ; i < egovResultDataList.size(); i++){
						BaseModel bm = new BaseModel();
						Map tempMap = (Map)egovResultDataList.get(i);
						Iterator<String> keys = tempMap.keySet().iterator();
						while( keys.hasNext() ){
				            String key = keys.next();
				            //형 타입이 숫자형일경우 형변환 해준다.
			            	if(tempMap.get(key) instanceof java.math.BigDecimal){
			            		bm.set(key, String.valueOf(tempMap.get(key)));
			            	}else{
			            		bm.set(key, tempMap.get(key));
			            	}
			            }
						returnValue.add(bm);
					}
				}
				
				
			}catch(Exception e){
				e.printStackTrace();
				throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			}
			return returnValue;
		}
		
		
		/** 분을 가져옴 **/
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public List<BaseModel> getMinuteList() throws MSFException {
			
			List<BaseModel> returnValue = new ArrayList<BaseModel>();
			List egovResultDataList = new ArrayList();
			
			String method = calledClass + ".getMinuteList";
			MSFSysm0100BM sessionUser;

			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
			
			try{
				
				egovResultDataList = hist0300DAO.getMinuteList();
				
				/** 로그반영
				 * CRUDSBLO
				 * C   //create  
		    	 * R   //read
		    	 * U   //update
		    	 * D   //delete
		    	 * S   //select
		    	 * B   //배치 
		    	 * L   //로그인 
		    	 * O   //로그아웃
		    	 */
//				MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
				
				if(egovResultDataList != null && egovResultDataList.size() > 0){
					for(int i = 0 ; i < egovResultDataList.size(); i++){
						BaseModel bm = new BaseModel();
						Map tempMap = (Map)egovResultDataList.get(i);
						Iterator<String> keys = tempMap.keySet().iterator();
						while( keys.hasNext() ){
				            String key = keys.next();
				            //형 타입이 숫자형일경우 형변환 해준다.
			            	if(tempMap.get(key) instanceof java.math.BigDecimal){
			            		bm.set(key, String.valueOf(tempMap.get(key)));
			            	}else{
			            		bm.set(key, tempMap.get(key));
			            	}
			            }
						returnValue.add(bm);
					}
				}
				
			}catch(Exception e){
				e.printStackTrace();
				throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			}
			return returnValue;
		}
 
	  
}
