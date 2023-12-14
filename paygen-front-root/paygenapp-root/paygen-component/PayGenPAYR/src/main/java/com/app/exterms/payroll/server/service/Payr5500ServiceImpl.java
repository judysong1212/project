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
import com.app.exterms.payroll.client.dto.Payr0460DTO;
import com.app.exterms.payroll.client.service.Payr5500Service;
import com.app.exterms.payroll.server.service.dao.Payr0460DAO;
import com.app.exterms.payroll.server.vo.Payr0460SrhVO;
import com.app.exterms.payroll.server.vo.Payr0460VO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Payr5500Service")
public class Payr5500ServiceImpl extends AbstractCustomServiceImpl implements Payr5500Service , PayrDaoConstants { 

	private static final Logger logger = LoggerFactory.getLogger(Payr5500ServiceImpl.class);
	private static final String calledClass = Payr5500ServiceImpl.class.getName();
	@Autowired
    @Resource(name="Payr0460DAO")
    private Payr0460DAO payr0460DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPayr0460IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

 
    public PagingLoadResult<BaseModel> getPayr0460DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0460_DATA_LIST;
        Payr0460SrhVO   payr0460SrhVO = new Payr0460SrhVO();
        Payr0460VO      payr0460VO = new Payr0460VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        

    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
       
        
        try {
        	
        	payr0460DAO = (Payr0460DAO)BeanFinder.getBean("Payr0460DAO");
        	
        	
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
           
            /** 조건절 */
            payr0460SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0460SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
            payr0460SrhVO.setPayItemCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payExtpyCd"))); 
          
               //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0460DAO.selectPayr0460ListTotCnt(payr0460SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0460DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0460SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                payr0460SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                payr0460SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0460DAO.selectPayr0460List(payr0460SrhVO);
            
            Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payItemCd").toString();
                BaseModel bm = new BaseModel();
 
                //bm.setProperties(map);
                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
                	
                	// 1. 암호화 객체 생성
            		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
                    
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0460DataList, "getPayr0460DataList");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
    
   
    public PagingLoadResult<BaseModel> getPayr0460ToPayr5500DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0460_PAYR5500_DATA_LIST;
        Payr0460SrhVO   payr0460SrhVO = new Payr0460SrhVO();
        Payr0460VO      payr0460VO = new Payr0460VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
       
        try {
        	
        	payr0460DAO = (Payr0460DAO)BeanFinder.getBean("Payr0460DAO");
        	
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
           
            /** 조건절 */ 
            payr0460SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0460SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));  
            
               //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0460DAO.selectPayr0460ToPayr5500ListTotCnt(payr0460SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0460DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0460SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                payr0460SrhVO.setFirstIndex(pagingValues.start);
            }
            
            if (pagingValues.totalRecordCount < 100) {
                payr0460SrhVO.setLastIndex(pagingValues.totalRecordCount); 
            } else if (pagingValues.offsetLimit > 0) {
                payr0460SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0460DAO.selectPayr0460ToPayr5500List(payr0460SrhVO);
            
            Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payExtpyCd").toString();
                BaseModel bm = new BaseModel();
 
                //bm.setProperties(map);
                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
                	
                	// 1. 암호화 객체 생성
            		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
                    
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0460DataList, "getPayr0460DataList");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
    

    @Override
    public Long activityOnPayr5500(List<Payr0460DTO> listPayr0460dto, ActionDatabase actionDatabase)  throws MSFException  {
         
        Long result = new Long(0);
        Long iCnt = new Long(0);
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        try { 
             
        	payr0460DAO = (Payr0460DAO)BeanFinder.getBean("Payr0460DAO");
           
          
            for(int iPayrCnt=0;iPayrCnt < listPayr0460dto.size();iPayrCnt++) {
                
                Payr0460DTO payr0460Dto = new Payr0460DTO();  
                payr0460Dto = listPayr0460dto.get(iPayrCnt);
              
                Payr0460VO payr0460Vo = new Payr0460VO();  
                Payr0460VO tpPayr0460Vo = new Payr0460VO();   
                  
                    
                payr0460Vo.setPayYr(payr0460Dto.getPayYr());    																/** column 급여년도 : payYr */
                payr0460Vo.setDpobCd(payr0460Dto.getDpobCd());    																/** column 사업장코드 : dpobCd */
                payr0460Vo.setOdtyDtilOccuClsCd(payr0460Dto.getOdtyDtilOccuClsCd());    										/** column 직책_직종세코드 : odtyDtilOccuClsCd */
                payr0460Vo.setPayItemCd(payr0460Dto.getPayItemCd());    														/** column 급여항목코드 : payItemCd */
                payr0460Vo.setOdtyDtilOccuClsSum(new BigDecimal(payr0460Dto.getOdtyDtilOccuClsSum()));							/** column 직책_직종세수당금액 : odtyDtilOccuClsSum */
                payr0460Vo.setOdtyDtilOccuClsNoteCtnt(payr0460Dto.getOdtyDtilOccuClsNoteCtnt());    							/** column 직책_직종세수당비고내용 : odtyDtilOccuClsNoteCtnt */
                payr0460Vo.setOdtyDtilOccuClsDelYn((Boolean.TRUE.equals(payr0460Dto.getOdtyDtilOccuClsDelYn()) ? "Y" : "N") );	/** column 직책_직종세수당삭제여부 : odtyDtilOccuClsDelYn */
                payr0460Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
                payr0460Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
                payr0460Vo.setIsmt(sessionUser.getUsrId());    																	/** column 수정자 : ismt */
                payr0460Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */

                     
                   
                //   tpPayr0460Vo = payr0460DAO.selectPayr0460(payr0460Vo); 
                   
                //   if (tpPayr0460Vo != null) {
                      
                       switch (actionDatabase) {
                       case INSERT:
                           payr0460DAO.insertPayr0460(payr0460Vo); 
                           break;
                       case UPDATE: 
                           payr0460DAO.updatePayr0460(payr0460Vo); 
                           break;
                       case DELETE: 
                           payr0460DAO.deletePayr0460(payr0460Vo);
                          
                           break;
                       } 
                       
                       iCnt = iCnt + 1; 
                  // } 
              } 
                result = iCnt;
          
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr5500(): "+ex); 
            
            result = new Long(0);
        }
        finally {
          
        }
        
        return result;
        
    }
 
   
	
}