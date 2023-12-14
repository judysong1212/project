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
package com.app.exterms.payroll.server.service;

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

import com.any.smrmf.utils.BeanFinder;
import com.app.exterms.payroll.client.service.Payr4450Service;
import com.app.exterms.payroll.server.service.dao.Payr0470DAO;
import com.app.exterms.payroll.server.service.dao.Payr0480DAO;
import com.app.exterms.payroll.server.vo.Payr0470SrhVO;
import com.app.exterms.payroll.server.vo.Payr0470VO;
import com.app.exterms.payroll.server.vo.Payr0480SrhVO;
import com.app.exterms.payroll.server.vo.Payr0480VO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
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
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Payr4450Service")
public class Payr4450ServiceImpl extends AbstractCustomServiceImpl implements Payr4450Service ,PayrDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Payr4450ServiceImpl.class);
	private static final String calledClass = Payr4450ServiceImpl.class.getName();
	 
	//수당 
	@Autowired
    @Resource(name="Payr0480DAO")
    private Payr0480DAO payr0480DAO;
	
   //공제 
	@Autowired
    @Resource(name="Payr0470DAO")
    private Payr0470DAO payr0470DAO;
    
	
    
	public PagingLoadResult<BaseModel> getPayr0480ToPayr4450DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0480TOPAYR4450_DATA_LIST;
        Payr0480SrhVO   payr0480SrhVO = new Payr0480SrhVO();
        Payr0480VO      payr0480VO ; 
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
         
        try {
        	
        	payr0480DAO = (Payr0480DAO)BeanFinder.getBean("Payr0480DAO");
        	
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0480BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

           
            /** 조건절 */
            payr0480SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0480SrhVO.setArrPayExtpyCd((ArrayList<String>)MSFServerUtils.getFilterValue(columnFilters, "arrPayExtpyCd"));
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0480DAO.selectPayr0480ToPayr4450ListTotCnt(payr0480SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0480ToPayr4450DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0480SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0480SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0480SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0480DAO.selectPayr0480ToPayr4450List(payr0480SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
           
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
            
            String rrnDecCrypt = "";
  
            while ( iter.hasNext() ) {
            	// 1. 암호화 객체 생성
    	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	    	
               Map<String, Object> map = (Map<String, Object>) iter.next();  
             
                String idValue = map.get("payExtpyCd").toString();
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
                   			
                		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {               			
                	          			
                			// 주민번호(복호화)
                			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);                	          		
                			strValue = rrnDecCrypt;
                						
                		}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

            				// 주민번호(복호화)
            				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);                      		
            				idValue = rrnDecCrypt;
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0480ToPayr4450DataList, "getPayr0480ToPayr4450DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
 
	public PagingLoadResult<BaseModel> getPayr0470ToPayr4450DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0470TOPAYR4450_DATA_LIST;
        Payr0470SrhVO   payr0470SrhVO = new Payr0470SrhVO();
        Payr0470VO      payr0470VO = new Payr0470VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
       
        try {
        	
        	payr0470DAO = (Payr0470DAO)BeanFinder.getBean("Payr0470DAO");
        	
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0470BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
            payr0470SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0470SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd"))) ;   //지급공제구분코드  
           
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0470DAO.selectPayr0470ToPayr4450ListTotCnt(payr0470SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0470ToPayr4450DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0470SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0470SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0470SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0470DAO.selectPayr0470ToPayr4450List(payr0470SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
            
            String rrnDecCrypt = "";
            
            while ( iter.hasNext() ) {
            	// 1. 암호화 객체 생성
    	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	    	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payDducCd").toString();
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
                   			
                		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {               			
                	          			
                			// 주민번호(복호화)
                			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);                	          		
                			strValue = rrnDecCrypt;
                						
                		}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

            				// 주민번호(복호화)
            				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);                      		
            				idValue = rrnDecCrypt;
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0470ToPayr4450DataList, "getPayr0470ToPayr4450DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
}
