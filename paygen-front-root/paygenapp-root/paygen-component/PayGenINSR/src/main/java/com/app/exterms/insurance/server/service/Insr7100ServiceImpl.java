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
package com.app.exterms.insurance.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.exterms.insurance.client.service.Insr7100Service;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
@Service("Insr7100Service")
public class Insr7100ServiceImpl extends AbstractCustomServiceImpl implements Insr7100Service ,InsrDaoConstants{
	
		private static final Logger logger = LoggerFactory.getLogger(Insr7100ServiceImpl.class);
		private static final String calledClass = Insr7100ServiceImpl.class.getName();
		

		  /** ID Generation */
	    //@Resource(name="{egovPayr0400IdGnrService}")    
	    //private EgovIdGnrService egovIdGnrService;
//		
//		public PagingLoadResult<BaseModel> getPayr0400DataList(ServiceParameters serviceParameters) throws MSFException {
//
//	        PagingLoadResult<BaseModel> retval = null;
//	        String method =  CLASS_PAYR0400_DATA_LIST;
//	        Payr0400SrhVO   payr0400SrhVO = new Payr0400SrhVO();
//	        Payr0400VO      payr0400VO = new Payr0400VO();
//	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
//	        
//	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//	        
//	        if  (MSFSharedUtils.paramNull(payr0400DAO)) {
//	        
//	        	WebApplicationContext wac = WebApplicationContextUtils.
//	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//	        	payr0400DAO = (Payr0400DAO) wac.getBean("Payr0400DAO" ); 
//	        }
//	        
//	        try {
//	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
//	           // Sysm0400BM          user             = serviceParameters.getUser();
//	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
//	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
//	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
//	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
//
//	            //Get paging configuration
//	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
//
//	            //Get query parameters
//	            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
//	           
//	            /** 조건절 */
//	            payr0400SrhVO.setDpobCd(sessionUser.getDpobCd());
//	            payr0400SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
//	            payr0400SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
//	            payr0400SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));
//	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
//		         if ( pagingValues.executeRecordCount ) { 
//		            	
//	                //Execute query that returns a single value
//	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//	                 
//	                int iResultCnt = payr0400DAO.selectPayr0400ListTotCnt(payr0400SrhVO);  
//	              
//	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
//	                pagingValues.totalRecordCount = iResultCnt;	       
//	                
//	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//	            }
//	        
//	            TimingInfo millisBeginPayr0400DataList = SmrmfUtils.startTiming(logger);
//	        
//	            /**페이지 카운트 처리를 위한 부분 */ 
//	            payr0400SrhVO.setPageSize(pagingValues.totalRecordCount);  
//	            
//	            //Apply paging
//	            if (pagingValues.start > 0) {
//	            	payr0400SrhVO.setFirstIndex(pagingValues.start);
//	            }
//	            if (pagingValues.offsetLimit > 0) {
//	            	payr0400SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
//	            }
//
//	            //Execute query and convert to BaseModel list
//	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//	            
//	            @SuppressWarnings("unchecked")
////			            Collection<Map<String, Object>> list ??????
//	            List list = payr0400DAO.selectPayr0400List(payr0400SrhVO);
//	            
//		        Iterator<Map<String, Object>> iter = list.iterator();
//		            
//	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
//	           
//	        
//	            while ( iter.hasNext() ) {
//	                Map<String, Object> map = (Map<String, Object>) iter.next();
//	                String idValue = map.get("typOccuCd").toString();
//	                BaseModel bm = new BaseModel();
//	 
//	                //bm.setProperties(map);
//	                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
//	                	
//	                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
//	                    Object mapCon = map.get(tableAttributes[i].getName());  
//	                     
//	                    switch ( tableAttributes[i].getType() ) {  
//	                    case ColumnDef.TYPE_DATE: 
//	                    case ColumnDef.TYPE_DATETIME: 
//	                       
//	                     Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"yyyyMMdd");
//	                     map.put(tableAttributes[i].getName(), value);
//	                     
//	                       break; 
//	                       
//	                     case ColumnDef.TYPE_LONG:   
//	                     
//	                    if (mapCon != null) {  
//	                        Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
//	                        map.put(tableAttributes[i].getName(), lValue); 
//	                    }  
//	                       
//	                     break;
//	                     
//	                     case ColumnDef.TYPE_DOUBLE:  
//	                     
//	                      if (mapCon != null) {      
//	                         Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue(); 
//	                         map.put(tableAttributes[i].getName(), dbValue); 
//	                      }  
//	                       
//	                         break;
//	                    }
//	                     /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
//	                    Object baseModelValue = null;
//	                    //콤보박스처리를 위해 추가함
//	                    if (tableAttributes[i].getName().contains("$")) {
//	                         String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
//	                              
//	                         map.put(tableAttributes[i].getName(),map.get(strMapCon));
//	                         
//	                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//	                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//	                    } else {
//	                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//	                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//	                    }
//	                 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//	                    
//	                    bm.set(tableAttributes[i].getName(), baseModelValue);
//	                }
//
//	                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
//	                bmResult.add(bm);
//	            } 
//
//	            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
//	            
//	            SmrmfUtils.endTiming(logger, millisBeginPayr0400DataList, "getPayr0400DataList");
//	       
//
//	        }
//	        catch (Exception ex) {
//	        	ex.printStackTrace();
//	            //Return operation exception
//	            throw MSFServerUtils.getOperationException(method, ex, logger);
//	        }
//
//	        return retval;
//	    }
}
