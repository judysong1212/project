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
package com.app.exterms.prgm.server.service;

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

import com.any.smrmf.utils.BeanFinder;
import com.app.exterms.prgm.client.dto.PrgmComPayr0480DTO;
import com.app.exterms.prgm.client.service.PrgmComPayr0480Service;
import com.app.exterms.prgm.server.service.dao.PrgmComPayr0470DAO;
import com.app.exterms.prgm.server.service.dao.PrgmComPayr0480DAO;
import com.app.exterms.prgm.server.vo.PrgmComPayr0480SrhVO;
import com.app.exterms.prgm.server.vo.PrgmComPayr0480VO;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerExtAuth;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
//import com.googlecode.ehcache.annotations.Cacheable;
@Service("PrgmComPayr0480Service")  
public class PrgmComPayr0480ServiceImpl extends AbstractCustomServiceImpl implements PrgmComDaoConstants,PrgmComPayr0480Service {
    
    private static final Logger logger = LoggerFactory.getLogger(PrgmComPayr0480ServiceImpl.class);

    public PrgmComPayr0480ServiceImpl() {
    
    }
        
    @Autowired
    @Resource(name="PrgmComPayr0480DAO")
    private PrgmComPayr0480DAO payr0480DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPayr0480IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

 
    
    public PagingLoadResult<BaseModel> getLookupComp0500ToPayr0480List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  PRGMCOM_METHOD_COMP0500TOPAYR0480_List;
        PrgmComPayr0480SrhVO   sysComPayr0480SrhVo = new PrgmComPayr0480SrhVO();
        PrgmComPayr0480VO sysComPayr0480Vo = new PrgmComPayr0480VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(payr0480DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            payr0480DAO = (PrgmComPayr0480DAO) wac.getBean("PrgmComPayr0480DAO" ); 
//        }
        payr0480DAO = (PrgmComPayr0480DAO)BeanFinder.getBean("PrgmComPayr0480DAO");
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0100BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
           
            /** 조건절 */
            sysComPayr0480SrhVo.setDpobCd(sessionUser.getDpobCd()); 
            if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(sessionUser.getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(sessionUser.getUsrDivCd()))) {
                sysComPayr0480SrhVo.setPayrTermUseYn("Y");
                
            } else {
                sysComPayr0480SrhVo.setPayrTermUseYn("");
            }
         
            sysComPayr0480SrhVo.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));   
            sysComPayr0480SrhVo.setPayExtpyNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payExtpyNm")));
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
                if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0480DAO.selectComp0500ToPayr0480ListTotCnt(sysComPayr0480SrhVo);  
                pagingValues.offsetLimit = iResultCnt;       
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectComp0500ToPayr0480List = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            sysComPayr0480SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                sysComPayr0480SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                 sysComPayr0480SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0480DAO.selectComp0500ToPayr0480List(sysComPayr0480SrhVo);
            
                Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectComp0500ToPayr0480List, "selectPayr0480List");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
    
    public PagingLoadResult<BaseModel> getPopupComp0500ToPayr0480List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  PRGMCOM_METHOD_COMP0500TOPAYR0480_List;
        PrgmComPayr0480SrhVO   sysComPayr0480SrhVo = new PrgmComPayr0480SrhVO();
        PrgmComPayr0480VO sysComPayr0480Vo = new PrgmComPayr0480VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(payr0480DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            payr0480DAO = (PrgmComPayr0480DAO) wac.getBean("PrgmComPayr0480DAO" ); 
//        }
        payr0480DAO = (PrgmComPayr0480DAO)BeanFinder.getBean("PrgmComPayr0480DAO");
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0100BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
           
            /** 조건절 */
            sysComPayr0480SrhVo.setDpobCd(sessionUser.getDpobCd()); 
            if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(sessionUser.getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(sessionUser.getUsrDivCd()))) {
                sysComPayr0480SrhVo.setPayrTermUseYn("Y");
                
            } else {
                sysComPayr0480SrhVo.setPayrTermUseYn("");
            }
         
            sysComPayr0480SrhVo.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));   
            sysComPayr0480SrhVo.setPayExtpyNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payExtpyNm"))); 
 
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
                if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0480DAO.selectComp0500ToPayr0480ListTotCnt(sysComPayr0480SrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectComp0500ToPayr0480List = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            sysComPayr0480SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                sysComPayr0480SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                 sysComPayr0480SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0480DAO.selectComp0500ToPayr0480List(sysComPayr0480SrhVo);
            
                Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectComp0500ToPayr0480List, "selectPayr0480List");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
    

    public PagingLoadResult<BaseModel> getPrgmComLookupPayr0480List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  PRGMCOM_METHOD_COMBO_PAYR0480_LIST;
        PrgmComPayr0480SrhVO   sysComPayr0480SrhVo = new PrgmComPayr0480SrhVO();
        PrgmComPayr0480VO sysComPayr0480Vo = new PrgmComPayr0480VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(payr0480DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            payr0480DAO = (PrgmComPayr0480DAO) wac.getBean("PrgmComPayr0480DAO" ); 
//        }
        payr0480DAO = (PrgmComPayr0480DAO)BeanFinder.getBean("PrgmComPayr0480DAO");
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0100BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
           
            /** 조건절 */
            sysComPayr0480SrhVo.setDpobCd(sessionUser.getDpobCd()); 
           // if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(sessionUser.getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(sessionUser.getUsrDivCd()))) {
           //     sysComPayr0480SrhVo.setPayrTermUseYn("Y");
          //      
           // } else {
                sysComPayr0480SrhVo.setPayrTermUseYn("");
          //  }
         
            sysComPayr0480SrhVo.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));   
            sysComPayr0480SrhVo.setPayExtpyNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payExtpyNm")));   
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
                if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0480DAO.selectPrgmComPayr0480ListTotCnt(sysComPayr0480SrhVo);  
                pagingValues.offsetLimit = iResultCnt;       
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPrgmComPayr0480List = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            sysComPayr0480SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                sysComPayr0480SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                 sysComPayr0480SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0480DAO.selectPrgmComPayr0480List(sysComPayr0480SrhVo);
            
                Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPrgmComPayr0480List, "selectPayr0480List");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
    
    public PagingLoadResult<BaseModel> getPrgmComPopupPayr0480List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  "getPrgmComPopupPayr0480List";
        PrgmComPayr0480SrhVO   sysComPayr0480SrhVo = new PrgmComPayr0480SrhVO();
        PrgmComPayr0480VO sysComPayr0480Vo = new PrgmComPayr0480VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(payr0480DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            payr0480DAO = (PrgmComPayr0480DAO) wac.getBean("PrgmComPayr0480DAO" ); 
//        }
        payr0480DAO = (PrgmComPayr0480DAO)BeanFinder.getBean("PrgmComPayr0480DAO");
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0100BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
           
            /** 조건절 */
            sysComPayr0480SrhVo.setDpobCd(sessionUser.getDpobCd()); 
           // if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(sessionUser.getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(sessionUser.getUsrDivCd()))) {
           //     sysComPayr0480SrhVo.setPayrTermUseYn("Y");
                
           // } else {
                sysComPayr0480SrhVo.setPayrTermUseYn("");
           // }
         
            sysComPayr0480SrhVo.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));   
            sysComPayr0480SrhVo.setPayExtpyNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payExtpyNm")));   
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
                if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0480DAO.selectPrgmComPayr0480ListTotCnt(sysComPayr0480SrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPayr0480List = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            sysComPayr0480SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                sysComPayr0480SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                 sysComPayr0480SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0480DAO.selectPrgmComPayr0480List(sysComPayr0480SrhVo);
            
                Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayr0480List, "selectPayr0480List");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
    
    
    public List<BaseModel> getPrgmComComboPayr0480List(PrgmComPayr0480DTO sysComPayr0480Dto) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getPrgmComComboPayr0480List";
        PrgmComPayr0480SrhVO  sysComPayr0480SrhVo = new PrgmComPayr0480SrhVO();
        PrgmComPayr0480VO sysComPayr0480Vo = new PrgmComPayr0480VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        MSFServerExtAuth msfServerExtAuth = MSFServerExtAuth.getInstance();
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        	 payr0480DAO = (PrgmComPayr0480DAO)BeanFinder.getBean("PrgmComPayr0480DAO"); 
//    	  if  (MSFSharedUtils.paramNull(payr0480DAO)) {
//    	        
//              WebApplicationContext wac = WebApplicationContextUtils.
//                      getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//              payr0480DAO = (PrgmComPayr0480DAO) wac.getBean("PrgmComPayr0480DAO" ); 
//          }
    	  
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
 	        
        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                     ,new ColumnAttribute("payExtpyCd", "payExtpyCd", ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("payExtpyNm", "payExtpyNm", ColumnDef.TYPE_STRING)
                      };
        	
            //Get paging configuration
           // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
        	sysComPayr0480SrhVo.setDpobCd(sessionUser.getDpobCd());
            
            
        	sysComPayr0480SrhVo.setPymtDducDivCd(sysComPayr0480Dto.getPymtDducDivCd());
        	sysComPayr0480SrhVo.setPayExtpyUseYn((Boolean.TRUE.equals(sysComPayr0480Dto.getPayExtpyUseYn()) ? "Y" : "N")); 
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        //    if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  payr0480DAO.selectPrgmComPayr0480ListTotCnt(sysComPayr0480SrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
         //       pagingValues.totalRecordCount = iResultCnt;	       
                
         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         //  }
        
            TimingInfo millisBeginSelectPayr0480List = SmrmfUtils.startTiming(logger);
        
        	 

            /**페이지 카운트 처리를 위한 부분 */ 
          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
           // 	sysComSrhVo.setFirstIndex(pagingValues.start);
           // }
           // if (pagingValues.offsetLimit > 0) {
           // 	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            sysComPayr0480SrhVo.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0480DAO.selectPrgmComPayr0480List(sysComPayr0480SrhVo);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payExtpyCd").toString();
                BaseModel bm = new BaseModel();

                //bm.setProperties(map);
                for ( int i=0 ; i<columnAttributes.length ; i++ ) {
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(columnAttributes[i].getName()), columnAttributes[i].getType());
                    bm.set(columnAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            //retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayr0480List, "selectPayr0480List"); 
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return bmResult;
    }
}
