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

import com.app.exterms.payroll.client.dto.Payr0410DTO;
import com.app.exterms.payroll.client.dto.Payr0415DTO;
import com.app.exterms.payroll.client.service.Payr1500Service;
import com.app.exterms.payroll.server.service.dao.Payr0410DAO;
import com.app.exterms.payroll.server.service.dao.Payr0415DAO;
import com.app.exterms.payroll.server.vo.Payr0410SrhVO;
import com.app.exterms.payroll.server.vo.Payr0410VO;
import com.app.exterms.payroll.server.vo.Payr0415SrhVO;
import com.app.exterms.payroll.server.vo.Payr0415VO;
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
import com.app.smrmf.core.msfmainapp.server.utils.ReflectionUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Payr0415Service")
public class Payr1500ServiceImpl extends AbstractCustomServiceImpl implements Payr1500Service , PayrDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Payr1500ServiceImpl.class);
	private static final String calledClass = Payr1500ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="Payr0415DAO")
    private Payr0415DAO payr0415DAO;
    
	
	
	@Autowired
    @Resource(name="Payr0410DAO")
    private Payr0410DAO payr0410DAO;
	
    /** ID Generation */
    //@Resource(name="{egovPayr0415IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	
	public PagingLoadResult<BaseModel> getPayr0415DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0415_DATA_LIST;
        Payr0415SrhVO   payr0415SrhVO = new Payr0415SrhVO();
        Payr0415VO      payr0415VO = new Payr0415VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

        
        if  (MSFSharedUtils.paramNull(payr0415DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	payr0415DAO = (Payr0415DAO) wac.getBean("Payr0415DAO" ); 
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
           
            /** 조건절 */
            payr0415SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0415SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
            payr0415SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
          //  payr0415SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0415SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0415SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
          //  payr0415SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));  
            payr0415SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));  
            payr0415SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));  
            
            payr0415SrhVO.setCreateYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "createYr")));
            
            
            int iCheck= payr0415DAO.selectPayr0415ListTotCnt(payr0415SrhVO);  
            
            if(iCheck > 0 ) {
            	payr0415SrhVO.setChkPayrMangDeptCd("Y");
            }else {
            	payr0415SrhVO.setChkPayrMangDeptCd("N");
            }
            
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0415DAO.selectPayr0415ListTotCnt(payr0415SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                      
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;
                
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0415DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0415SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0415SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0415SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));       
            }            
           
            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0415DAO.selectPayr0415List(payr0415SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("typOccuCd").toString();
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
                	          			
                			String rrnDecCrypt = "";
                	          			
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
                  	
                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    
                    if("transferYn".equals(tableAttributes[i].getName())){
                    	if(null == baseModelValue){
                    		baseModelValue = "N";
                    	}
                    }
                    
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0415DataList, "getPayr0415DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	public PagingLoadResult<BaseModel> getPayr0415CopyDataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0415_DATA_LIST;
        Payr0415SrhVO   payr0415SrhVO = new Payr0415SrhVO();
        Payr0415VO      payr0415VO = new Payr0415VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(payr0415DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	payr0415DAO = (Payr0415DAO) wac.getBean("Payr0415DAO" ); 
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
           
            /** 조건절 */
            payr0415SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0415SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
            payr0415SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
          //  payr0415SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0415SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0415SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
          //  payr0415SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));  
            payr0415SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));  
            payr0415SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));  
            
            payr0415SrhVO.setCreateYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "createYr")));
            
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0415DAO.selectPayr0415ListTotCnt(payr0415SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;
                
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0415DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0415SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0415SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0415SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            	
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0415DAO.selectPayr0415List(payr0415SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("typOccuCd").toString();
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
                	          			
                			String rrnDecCrypt = "";
                	          			
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
                  	
                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    
                    if("transferYn".equals(tableAttributes[i].getName())){
                    	if(null == baseModelValue || "".equals(baseModelValue)){
                    		baseModelValue = false;
                    	}
                    }
                    	bm.set(tableAttributes[i].getName(), baseModelValue); 
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0415DataList, "getPayr0415DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	public PagingLoadResult<BaseModel> getPayr150002Payr0410DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR150002TOPAYR0410_DATA_LIST;
        Payr0410SrhVO   payr0410SrhVO = new Payr0410SrhVO();
        
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(payr0410DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	payr0410DAO = (Payr0410DAO) wac.getBean("Payr0410DAO" ); 
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
           
            /** 조건절 */
            payr0410SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0410SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
            payr0410SrhVO.setPayrImcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrImcd")));
            payr0410SrhVO.setItemNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "itemNm")));
            payr0410SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));
       
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0410DAO.selectPayr150002ToPayr0410ListTotCnt(payr0410SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0415DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0410SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0410SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0410SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            	
            }
            
            

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0410DAO.selectPayr150002ToPayr0410List(payr0410SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("typOccuGrdeMppgSeilNum").toString();
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
                	          			
                			String rrnDecCrypt = "";
                	          			
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
                  	
                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    
                    if("createYn".equals(tableAttributes[i].getName())){
                    	if(null == baseModelValue || "".equals(baseModelValue)){
                    		baseModelValue = false;
                    	}
                    }
                    	bm.set(tableAttributes[i].getName(), baseModelValue); 
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0415DataList, "getPayr0415DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	 /**
     * 삭제처리 로직  TODO  차후 멀티건에 대한 삭제 기능 추가 
     */
	@Override
	public Long activityOnPayr0415Copy(List<BaseModel> list, BaseModel bm) throws MSFException { 

		Long result = new Long(0); 

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		// 1. 암호화 객체 생성
//		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		try {  
			if  (MSFSharedUtils.paramNull(payr0415DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.
						getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				payr0415DAO = (Payr0415DAO) wac.getBean("Payr0415DAO" ); 
			}

			Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)list.iterator();
			while (iterRecords.hasNext()) {
				BaseModel bmMapModel = (BaseModel) iterRecords.next();
				Payr0415VO  payr0415Vo = new Payr0415VO();
				String transferYn = MSFSharedUtils.allowNulls(bmMapModel.get("transferYn"));
				if(transferYn.equals("false")){
					
					String createYr = MSFSharedUtils.allowNulls(bm.get("createYr"));
					
					if(createYr != null && !createYr.equals("")){
						payr0415Vo.setDpobCd(sessionUser.getDpobCd());
						payr0415Vo.setPayYr(createYr);
						payr0415Vo.setTypOccuGrdeMppgSeilNum(new BigDecimal(bmMapModel.get("typOccuGrdeMppgSeilNum").toString()));
						payr0415Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
						payr0415Vo.setIsmt(sessionUser.getUsrId());    											/** column 수정자 : ismt */
						payr0415Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
						payr0415Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 수정주소 : revnAddr */

						payr0415DAO.insertPayr0415Copy(payr0415Vo);

						result = result + 1;
					}
				}
			}

		}catch (Exception ex) {
			logger.error("EXCEPTION calling activityOnPayr0415Copy(): "+ex); 
			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnPayr0415Copy", ex, logger);
		}
		finally {

		}

		return result;
	} 
	
	public PagingLoadResult<BaseModel> getPayr0410DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0410_DATA_LIST;
        Payr0410SrhVO   payr0410SrhVO = new Payr0410SrhVO();
        Payr0410VO      payr0410VO = new Payr0410VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(payr0410DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	payr0410DAO = (Payr0410DAO) wac.getBean("Payr0410DAO" ); 
        }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0430BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
            payr0410SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0410SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
            payr0410SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
           // payr0410SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
           // payr0410SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0410SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0410SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
            payr0410SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));
            payr0410SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
            payr0410SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd"))); //급여구분코드
            
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0410DAO.selectPayr0410ListTotCnt(payr0410SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;
                  
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0410DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            //payr0410SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0410SrhVO.setFirstIndex(pagingValues.start);
            }
            
            if (pagingValues.offsetLimit > 0) {
            	payr0410SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));   
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0410DAO.selectPayr0410List(payr0410SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payrImcd").toString();
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
                	          			
                			String rrnDecCrypt = "";
                	          			
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
                  	
                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                 
//                    switch ( tableAttributes[i].getType() ) {  
//                    case ColumnDef.TYPE_BIGDECIMAL: 
//                    	if (baseModelValue == null) {
//                    		baseModelValue = BigDecimal.ZERO;
//                    	}
//                        break; 
//                    }
                    
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0410DataList, "getPayr0410DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	public PagingLoadResult<BaseModel> getCboPayr0415PayYrList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getCboPayr0415PayYrList";
        Payr0415SrhVO   payr0415SrhVO = new Payr0415SrhVO();
        Payr0415VO      payr0415VO = new Payr0415VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(payr0415DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	payr0415DAO = (Payr0415DAO) wac.getBean("Payr0415DAO" ); 
        }
        try {
          
             ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
             IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
             List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
             PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
 	         
        	
            //Get paging configuration
             PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
             payr0415SrhVO.setDpobCd(sessionUser.getDpobCd());
           // sysComSrhVo.setRpsttvCd(sysComBass0300Dto.getRpsttvCd());
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  payr0415DAO.selectPayr0415PayYrListTotCnt(payr0415SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;
                      
                
               logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPayr0415PayYrList = SmrmfUtils.startTiming(logger);
         
          
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0415SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0415SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.totalRecordCount < 100) {
            	payr0415SrhVO.setLastIndex(pagingValues.totalRecordCount); 
            } else  if (pagingValues.offsetLimit > 0) {
            	payr0415SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            } 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ?????? 
            List list = payr0415DAO.selectPayr0415PayYrList(payr0415SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payYr").toString();
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
                	          			
                			String rrnDecCrypt = "";
                	          			
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayr0415PayYrList, "getCboPayr0415PayYrList");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }	
	
	 

    @Override
    public Long activityOnPayr0415Insert(Payr0415DTO payr0415Dto, List<BaseModel> listModels, ActionDatabase actionDatabase) throws MSFException  {
        // TODO Auto-generated method stub
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    	
        Long result = new Long(0);
        Long iCnt = new Long(0);
        try { 
            
            if  (MSFSharedUtils.paramNull(payr0415DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                payr0415DAO = (Payr0415DAO) wac.getBean("Payr0415DAO" ); 
            }
                  
            
          Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)listModels.iterator();
          while (iterRecords.hasNext()) {
            
              BaseModel bmMapModel = (BaseModel) iterRecords.next();
               
              Payr0415VO payr0415Vo = new Payr0415VO();
              
              payr0415Vo.setPayYr(MSFSharedUtils.allowNulls(payr0415Dto.getPayYr()));
              payr0415Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0415Dto.getDpobCd()));
              payr0415Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd"))) ;
              payr0415Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd"))) ;
            //  payr0415Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));  
               

              payr0415Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
              payr0415Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
              payr0415Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
              payr0415Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
              
              
            switch (actionDatabase) {
            case INSERT:
                payr0415DAO.insertPayr0415(payr0415Vo); 
                break; 
            }
            
            iCnt = iCnt + 1;
              
          } 
          
          result = iCnt;
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr0400Insert(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnPayr0400Insert", ex, logger);
        }
        finally {
          
        }
        
        return result;
    }


    @Override
    public Long activityOnPayr1500BfToNew(Payr0415DTO payr0415Dto, List<BaseModel> listModels, ActionDatabase actionDatabase)throws MSFException  {
        // TODO Auto-generated method stub
        Long result = new Long(0);
        Long iCnt = new Long(0);
        try { 
            
            Payr0415SrhVO payr0415SrhVo = new Payr0415SrhVO();
            Payr0410SrhVO payr0410SrhVo = new Payr0410SrhVO();
            
            if  (MSFSharedUtils.paramNull(payr0415DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                payr0415DAO = (Payr0415DAO) wac.getBean("Payr0415DAO" ); 
            }
            
          //1. 이전데이터가 존재하는 경우 삭제 처리(payr410-> payr415순으로 삭제 ) 
          //2. payr415 인서트 
          //3. payr410 인서트 
         
         
                Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)listModels.iterator();
                while (iterRecords.hasNext()) {
                  
                    BaseModel bmMapModel = (BaseModel) iterRecords.next();
                     
                    Payr0415VO payr0415Vo = new Payr0415VO();
                    Payr0410VO payr0410Vo = new Payr0410VO(); 
                    
                    payr0415Vo.setPayYr(MSFSharedUtils.allowNulls(payr0415Dto.getPayYr()));
                    payr0415Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0415Dto.getDpobCd()));
                    payr0415Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd"))) ;
                    payr0415Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd"))) ;
                  //  payr0415Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));  
                    
                    result = deleteOnPayr1500BfToNew(payr0415Vo,ActionDatabase.DELETE);
                  
                    if (result > 0) {
                        
                        
                      BeanUtils.copyProperties(payr0410Vo, payr0415Vo); 
                        
                      switch (actionDatabase) {
                      case INSERT:
                          
                          payr0415DAO.insertPayr0415(payr0415Vo); 
                          
                          payr0410SrhVo.setDpobCd(MSFSharedUtils.allowNulls(payr0415Vo.getDpobCd()));
                          payr0410SrhVo.setPayYr(String.valueOf((Integer.parseInt(payr0415Vo.getPayYr()) - 1)));
                          payr0410SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd"))) ;
                          payr0410SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd"))) ;
                      //    payr0410SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));  
  
                          List list =  payr0410DAO.selectPayr0410List(payr0410SrhVo);
                         
                          if (list.size() > 0) {
                                
                              Iterator<Map<String, Object>> iter = list.iterator();
                                
                              while ( iter.hasNext() ) {
                                  Map<String, Object> lstMap = (Map<String, Object>) iter.next();
                                 
//                                  for (int iSubCnt = 0; iSubCnt < list.size();iSubCnt++) {
                                  Payr0410VO payr0410SubVo = new Payr0410VO(); 
//                                  Map<String,Object> lstMap = (Map<String,Object>)list.get(iSubCnt);
                                  payr0410SubVo = (Payr0410VO)ReflectionUtils.convertMapToObject(lstMap,Payr0410VO.class);
                                  
                                  payr0410SubVo.setPayYr(payr0410Vo.getPayYr()); //현재년도로 셋팅 
                                  
                                  payr0410DAO.insertPayr0410(payr0410SubVo);
                                  
                              } 
                              
                          }
                          
                          
                          iCnt = iCnt + 1;
                          break; 
                      
                      }       
               } 
                result = iCnt;
            }
              
         
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr1500BfToNew(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnPayr1500BfToNew", ex, logger);
        }
        finally {
          
        }
        
        return result;
    }
    
    

    private Long deleteOnPayr1500BfToNew(Payr0415VO payr0415Vo, ActionDatabase actionDatabase)  throws MSFException {
        // TODO Auto-generated method stub
        Long result = new Long(1);
        
        try { 
            
            Payr0410VO payr0410Vo = new Payr0410VO(); 
            
            payr0410Vo.setDpobCd(payr0415Vo.getDpobCd());    							/** column 사업장코드 : dpobCd */
            payr0410Vo.setPayYr(payr0415Vo.getPayYr()) ;   								/** column 급여년도 : payYr */ 
            payr0410Vo.setTypOccuGrdeMppgSeilNum(payr0415Vo.getTypOccuGrdeMppgSeilNum());
            payr0410Vo.setTypOccuCd(payr0415Vo.getTypOccuCd());  						/** column 직종코드 : typOccuCd */ 
         //   payr0410Vo.setPyspGrdeCd(payr0415Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
            payr0410Vo.setDtilOccuInttnCd(payr0415Vo.getDtilOccuInttnCd());    			/** column 직종세코드 : dtilOccuInttnCd */
            
            switch (actionDatabase) {
            case INSERT:
               break;
            case UPDATE: 
                break;
            case DELETE: 
                payr0410DAO.deleteBfToNewPayr0410(payr0410Vo);
                payr0415DAO.deleteBfToNewPayr0415(payr0415Vo); 
                break;
            }
            
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling deleteOnPayr1500BfToNew(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("deleteOnPayr1500BfToNew", ex, logger);
        }
        finally {
          
        }
        return result;
    }


    @Override
    public Long activityOnPayr0415Save(Payr0415DTO payr0415Dto, ActionDatabase actionDatabase)  throws MSFException  {
        // TODO Auto-generated method stub
        Long result = new Long(1);
        try { 
          
            Payr0415VO payr0415Vo = new Payr0415VO();
            Payr0410VO payr0410Vo = new Payr0410VO();
            
            payr0410Vo.setDpobCd(payr0415Dto.getDpobCd());    					/** column 사업장코드 : dpobCd */
            payr0410Vo.setPayYr(payr0415Dto.getPayYr()) ;   					/** column 급여년도 : payYr */ 
            payr0410Vo.setTypOccuGrdeMppgSeilNum(new BigDecimal(payr0415Dto.getTypOccuGrdeMppgSeilNum()));
            payr0410Vo.setTypOccuCd(payr0415Dto.getTypOccuCd());   				/** column 직종코드 : typOccuCd */ 
           // payr0410Vo.setPyspGrdeCd(payr0415Dto.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
            payr0410Vo.setDtilOccuInttnCd(payr0415Dto.getDtilOccuInttnCd());	/** column 직종세코드 : dtilOccuInttnCd */
             
            payr0415Vo.setDpobCd(payr0415Dto.getDpobCd());    					/** column 사업장코드 : dpobCd */
            payr0415Vo.setPayYr(payr0415Dto.getPayYr()) ;   					/** column 급여년도 : payYr */ 
            payr0415Vo.setTypOccuGrdeMppgSeilNum(new BigDecimal(payr0415Dto.getTypOccuGrdeMppgSeilNum()));
            payr0415Vo.setTypOccuCd(payr0415Dto.getTypOccuCd());   				/** column 직종코드 : typOccuCd */ 
          //  payr0415Vo.setPyspGrdeCd(payr0415Dto.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
            payr0415Vo.setDtilOccuInttnCd(payr0415Dto.getDtilOccuInttnCd());	/** column 직종세코드 : dtilOccuInttnCd */
              
            switch (actionDatabase) {
            case INSERT:
               break;
            case UPDATE:  
                break;
            case DELETE: 
                payr0410DAO.deleteBfToNewPayr0410(payr0410Vo); 
                payr0415DAO.deleteBfToNewPayr0415(payr0415Vo); 
                break;
            }
            
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr0400Save(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnPayr0400Save", ex, logger);
        }
        finally {
          
        }
        return result; 
    }


    @Override
    public Long activityOnPayr0410DetailFormSave(Payr0410DTO payr0410Dto, ActionDatabase actionDatabase)   throws MSFException {
        // TODO Auto-generated method stub
        Long result = new Long(1);
		Long iCnt = new Long(0);
		
        try { 
          
            Payr0410VO payr0410Vo = new Payr0410VO();

            payr0410Vo.setDpobCd(payr0410Dto.getDpobCd());								/** column 사업장코드 : dpobCd */
            payr0410Vo.setPayYr(payr0410Dto.getPayYr());    							/** column 급여년도 : payYr */
            payr0410Vo.setTypOccuGrdeMppgSeilNum(new BigDecimal(payr0410Dto.getTypOccuGrdeMppgSeilNum()));    				/** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
            payr0410Vo.setPayrItemSeilNum(new BigDecimal(payr0410Dto.getPayrItemSeilNum()));    /** column 급여항목일련번호 : payrItemSeilNum */
            payr0410Vo.setPayrMangDeptCd(payr0410Dto.getPayrMangDeptCd());				/** column 급여관리부서코드 : payrMangDeptCd */
            payr0410Vo.setPayrImcd(payr0410Dto.getPayrImcd());							/** column 급여항목코드 : payrImcd */
            payr0410Vo.setItemNm(payr0410Dto.getItemNm());    							/** column 항목명 : itemNm */
            payr0410Vo.setPayCd(payr0410Dto.getPayCd());    							/** column 급여구분코드 : payCd */
            payr0410Vo.setPymtDducDivCd(payr0410Dto.getPymtDducDivCd());    			/** column 지급공제구분코드 : pymtDducDivCd */
            payr0410Vo.setPymtDducFrmCd(payr0410Dto.getPymtDducFrmCd());    			/** column 지급공제유형코드 : pymtDducFrmCd */
            payr0410Vo.setPymtDducRate(new BigDecimal(MSFSharedUtils.defaultNulls(payr0410Dto.getPymtDducRate(),"0")));		/** column 지급공제율 : pymtDducRate */
            payr0410Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0410Dto.getPymtDducSum(),"0")));    	/** column 지급공제액 : pymtDducSum */
            payr0410Vo.setTxtnDivCd(payr0410Dto.getTxtnDivCd());						/** column 과세구분코드 : txtnDivCd */
            payr0410Vo.setFreeDtyRate(new BigDecimal(payr0410Dto.getFreeDtyRate()));    /** column 비과세율 : freeDtyRate */
            payr0410Vo.setFreeDtySum(new BigDecimal(payr0410Dto.getFreeDtySum()));    	/** column 비과세금액 : freeDtySum */
            /** JAN */
            payr0410Vo.setJan((Boolean.TRUE.equals(payr0410Dto.getJan()) ? "Y" : "N"));
            
            /** FEB */
            payr0410Vo.setFeb((Boolean.TRUE.equals(payr0410Dto.getFeb()) ? "Y" : "N"));
            
            /** MAR */
            payr0410Vo.setMar((Boolean.TRUE.equals(payr0410Dto.getMar()) ? "Y" : "N"));
            
            /** APR */
            payr0410Vo.setApr((Boolean.TRUE.equals(payr0410Dto.getApr()) ? "Y" : "N"));
            
            /** MAY */
            payr0410Vo.setMay((Boolean.TRUE.equals(payr0410Dto.getMay()) ? "Y" : "N"));
            
            /** JUN */
            payr0410Vo.setJun((Boolean.TRUE.equals(payr0410Dto.getJun()) ? "Y" : "N"));
            
            /** JUL */
            payr0410Vo.setJul((Boolean.TRUE.equals(payr0410Dto.getJul()) ? "Y" : "N"));
            
            /** AUG */
            payr0410Vo.setAug((Boolean.TRUE.equals(payr0410Dto.getAug()) ? "Y" : "N"));
            
            /** SEP */
            payr0410Vo.setSep((Boolean.TRUE.equals(payr0410Dto.getSep()) ? "Y" : "N"));
            
            /** OCT */
            payr0410Vo.setOct((Boolean.TRUE.equals(payr0410Dto.getOct()) ? "Y" : "N"));
            
            /** NOV */
            payr0410Vo.setNov((Boolean.TRUE.equals(payr0410Dto.getNov()) ? "Y" : "N"));
            
            /** DEC */
            payr0410Vo.setDec((Boolean.TRUE.equals(payr0410Dto.getDec()) ? "Y" : "N"));
            
            payr0410Vo.setRngeOrd(new BigDecimal(payr0410Dto.getRngeOrd()));    /** column 정렬순서 : rngeOrd */
         
            payr0410Vo.setPayItemUseYn((Boolean.TRUE.equals(payr0410Dto.getPayItemUseYn()) ? "Y" : "N"));  /** column 급여항목사용여부 : payItemUseYn */
            
            payr0410Vo.setItemApptnBgnnDt(payr0410Dto.getItemApptnBgnnDt());    /** column 항목적용시작일자 : itemApptnBgnnDt */
            payr0410Vo.setItemApptnEndDt(payr0410Dto.getItemApptnEndDt());    	/** column 항목적용종료일자 : itemApptnEndDt */
            payr0410Vo.setDayMnthAmntDivCd(payr0410Dto.getDayMnthAmntDivCd());	/** column 일월액구분코드 : dayMnthAmntDivCd */
            payr0410Vo.setCalcStdDivCd(payr0410Dto.getCalcStdDivCd());    		/** column 계산기준구분코드 : calcStdDivCd */
            payr0410Vo.setEmymtDivCd(payr0410Dto.getEmymtDivCd());				/** column 고용구분코드 : emymtDivCd */

            /** USALY_AMNT_YN */
            payr0410Vo.setUsalyAmntYn((Boolean.TRUE.equals(payr0410Dto.getUsalyAmntYn()) ? "Y" : "N"));  /** column 통상임금여부 : usalyAmntYn */
          
            payr0410Vo.setPayItemNoteCtnt(payr0410Dto.getPayItemNoteCtnt());    /** column 급여항목비고내용 : payItemNoteCtnt */
            payr0410Vo.setCalcStdFunc(payr0410Dto.getCalcStdFunc());    		/** column 계산수식내용 : calcStdFunc */
            
//            payr0410Vo.setKybdr(payr0410dto.getKybdr());    /** column 입력자 : kybdr */
//            payr0410Vo.setInptDt(payr0410dto.getInptDt());    /** column 입력일자 : inptDt */
//            payr0410Vo.setInptAddr(payr0410dto.getInptAddr());    /** column 입력주소 : inptAddr */
//            payr0410Vo.setIsmt(payr0410dto.getIsmt());    /** column 수정자 : ismt */
//            payr0410Vo.setRevnDt(payr0410dto.getRevnDt());    /** column 수정일자 : revnDt */
//            payr0410Vo.setRevnAddr(payr0410dto.getRevnAddr());    /** column 수정주소 : revnAddr */
           
            switch (actionDatabase) {
            case INSERT:
               break;
            case UPDATE: 
                payr0410DAO.updatePayr0410(payr0410Vo);
                break;
            case DELETE: 
                payr0410DAO.deletePayr0410(payr0410Vo);
                break;
            }
            
        }catch (Exception ex) {
            
            logger.error("EXCEPTION calling activityOnPayr0410DetailFormSave(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnPayr0410DetailFormSave", ex, logger);
        }finally {
          
        }
        return result; 
    }


    @Override
    public Long activityOnPayr0410Insert(Payr0410DTO payr0410Dto, List<BaseModel> listModels, ActionDatabase actionDatabase) {
        Long result = new Long(0);
        Long iCnt = new Long(0);
        try { 
            
            if  (MSFSharedUtils.paramNull(payr0410DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                payr0410DAO = (Payr0410DAO) wac.getBean("Payr0410DAO" ); 
            }
            
          
            
          Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)listModels.iterator();
          while (iterRecords.hasNext()) {
            
              BaseModel bmMapModel = (BaseModel) iterRecords.next();
               
              Payr0410VO payr0410Vo = new Payr0410VO();
              

            payr0410Vo.setDpobCd(payr0410Dto.getDpobCd());    		/** column 사업장코드 : dpobCd */
            payr0410Vo.setPayYr(payr0410Dto.getPayYr()) ;   		/** column 급여년도 : payYr */
            payr0410Vo.setTypOccuGrdeMppgSeilNum(new BigDecimal(payr0410Dto.getTypOccuGrdeMppgSeilNum()));
            payr0410Vo.setPayCd(payr0410Dto.getPayCd());    		/** column 급여구분코드 : payCd */
            payr0410Vo.setTypOccuCd(payr0410Dto.getTypOccuCd());	/** column 직종코드 : typOccuCd */
            payr0410Vo.setPayrImcd(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyCd")));    		/** column 급여항목코드 : payrImcd */
          //  payr0410Vo.setPyspGrdeCd(payr0410Dto.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
            payr0410Vo.setDtilOccuInttnCd(payr0410Dto.getDtilOccuInttnCd());    						/** column 직종세코드 : dtilOccuInttnCd */
            payr0410Vo.setItemNm(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyNm")));    			/** column 항목명 : itemNm */
            payr0410Vo.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd")));    /** column 지급공제구분코드 : pymtDducDivCd */
            payr0410Vo.setPymtDducFrmCd(payr0410Dto.getPymtDducFrmCd());    /** column 지급공제유형코드 : pymtDducFrmCd */
            payr0410Vo.setPymtDducRate(new BigDecimal(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyRto"))));	/** column 지급공제율 : pymtDducRate */
            payr0410Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpySum"))));	/** column 지급공제액 : pymtDducSum */
            payr0410Vo.setTxtnDivCd(payr0410Dto.getTxtnDivCd());    /** column 과세구분코드 : txtnDivCd */
            payr0410Vo.setFreeDtyRate(BigDecimal.ZERO);    			/** column 비과세율 : freeDtyRate */
            payr0410Vo.setFreeDtySum(BigDecimal.ZERO);    			/** column 비과세금액 : freeDtySum */
            payr0410Vo.setJan("N");    /** column 1월 : jan */
            payr0410Vo.setFeb("N");    /** column 2월 : feb */
            payr0410Vo.setMar("N");    /** column 3월 : mar */
            payr0410Vo.setApr("N");    /** column 4월 : apr */
            payr0410Vo.setMay("N");    /** column 5월 : may */
            payr0410Vo.setJun("N");    /** column 6월 : jun */
            payr0410Vo.setJul("N");    /** column 7월 : jul */
            payr0410Vo.setAug("N");    /** column 8월 : aug */
            payr0410Vo.setSep("N");    /** column 9월 : sep */
            payr0410Vo.setOct("N");    /** column 10월 : oct */
            payr0410Vo.setNov("N");    /** column 11월 : nov */
            payr0410Vo.setDec("N");    /** column 12월 : dec */
            payr0410Vo.setRngeOrd(BigDecimal.ZERO);    							/** column 정렬순서 : rngeOrd */
            payr0410Vo.setPayItemUseYn("Y");    								/** column 급여항목사용여부 : payItemUseYn */
            payr0410Vo.setItemApptnBgnnDt(payr0410Dto.getItemApptnBgnnDt());    /** column 항목적용시작일자 : itemApptnBgnnDt */
            payr0410Vo.setItemApptnEndDt(payr0410Dto.getItemApptnEndDt());    	/** column 항목적용종료일자 : itemApptnEndDt */
            payr0410Vo.setDayMnthAmntDivCd(payr0410Dto.getDayMnthAmntDivCd());	/** column 일월액구분코드 : dayMnthAmntDivCd */
            payr0410Vo.setCalcStdDivCd(payr0410Dto.getCalcStdDivCd());    		/** column 계산기준구분코드 : calcStdDivCd */
            payr0410Vo.setEmymtDivCd(payr0410Dto.getEmymtDivCd());    			/** column 고용구분코드 : emymtDivCd */
            payr0410Vo.setUsalyAmntYn("N");    									/** column 통상임금여부 : usalyAmntYn */
            payr0410Vo.setPayItemNoteCtnt(payr0410Dto.getPayItemNoteCtnt());    /** column 급여항목비고내용 : payItemNoteCtnt */
//            payr0410Vo.setKybdr(kybdr)    /** column 입력자 : kybdr */
//            payr0410Vo.setInptDt(inptDt)    /** column 입력일자 : inptDt */
//            payr0410Vo.setInptAddr(inptAddr)    /** column 입력주소 : inptAddr */
//            payr0410Vo.setIsmt(ismt)    /** column 수정자 : ismt */
//            payr0410Vo.setRevnDt(revnDt)    /** column 수정일자 : revnDt */
//            payr0410Vo.setRevnAddr(revnAddr)    /** column 수정주소 : revnAddr */
 
               
            switch (actionDatabase) {
            case INSERT:
                payr0410DAO.insertPayr0410(payr0410Vo); 
                break; 
            }
            
            iCnt = iCnt + 1;
              
          } 
          
          result = iCnt;
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr0400Insert(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnPayr0400Insert", ex, logger);
            
        }
        finally {
          
        }
        
        return result;
    }

 

    @Override
    public Long activityOnPayr150002ToPayr0410Insert(List<BaseModel> list, Payr0410DTO payr0410Dto)   throws MSFException {
    	
    	 if  (MSFSharedUtils.paramNull(payr0410DAO)) {
             
             WebApplicationContext wac = WebApplicationContextUtils.
                     getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

             payr0410DAO = (Payr0410DAO) wac.getBean("Payr0410DAO" ); 
         }
    	 
    	 MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    	
        Long result = new Long(1);
		Long iCnt = new Long(0);
		
        try { 
         
            
            
        	Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)list.iterator();
			while (iterRecords.hasNext()) {
				BaseModel bmMapModel = (BaseModel) iterRecords.next();
				 
				
				
	            Payr0410VO payr0410Vo = new Payr0410VO();

	            payr0410Vo.setDpobCd(sessionUser.getDpobCd());									/** column 사업장코드 : dpobCd */
	            payr0410Vo.setPayYr(payr0410Dto.getPayYr());    								/** column 급여년도 : payYr */
	            payr0410Vo.setTypOccuGrdeMppgSeilNum(new BigDecimal(bmMapModel.get("typOccuGrdeMppgSeilNum").toString()));    /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
	           // payr0410Vo.setPayrItemSeilNum(new BigDecimal(payr0410Dto.getPayrItemSeilNum()));    /** column 급여항목일련번호 : payrItemSeilNum */

	            payr0410Vo.setPayrMangDeptCd(payr0410Dto.getPayrMangDeptCd());					/** column 급여관리부서코드 : payrMangDeptCd */
	            payr0410Vo.setPayrImcd(payr0410Dto.getPayrImcd());								/** column 급여항목코드 : payrImcd */
	            payr0410Vo.setItemNm(payr0410Dto.getItemNm());    								/** column 항목명 : itemNm */
	            payr0410Vo.setPayCd(payr0410Dto.getPayCd());    								/** column 급여구분코드 : payCd */
	            payr0410Vo.setPymtDducDivCd(payr0410Dto.getPymtDducDivCd());    				/** column 지급공제구분코드 : pymtDducDivCd */
	            payr0410Vo.setPymtDducFrmCd(payr0410Dto.getPymtDducFrmCd());    				/** column 지급공제유형코드 : pymtDducFrmCd */
	            payr0410Vo.setPymtDducRate(new BigDecimal(MSFSharedUtils.defaultNulls(payr0410Dto.getPymtDducRate(),"0")));	/** column 지급공제율 : pymtDducRate */
	            payr0410Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0410Dto.getPymtDducSum(),"0")));	/** column 지급공제액 : pymtDducSum */
	            payr0410Vo.setTxtnDivCd(payr0410Dto.getTxtnDivCd());							/** column 과세구분코드 : txtnDivCd */
	            
	            if(null == payr0410Dto.getFreeDtyRate()){
	            	payr0410Vo.setFreeDtyRate(BigDecimal.ZERO);    								/** column 비과세율 : freeDtyRate */
	            }else{
	            	payr0410Vo.setFreeDtyRate(new BigDecimal(payr0410Dto.getFreeDtyRate())); 	/** column 비과세율 : freeDtyRate */
	            }
	            if(null == payr0410Dto.getFreeDtySum()){
	            	payr0410Vo.setFreeDtySum(BigDecimal.ZERO);    								/** column 비과세금액 : freeDtySum */
	            }else{
	            	payr0410Vo.setFreeDtySum(new BigDecimal(payr0410Dto.getFreeDtySum()));		/** column 비과세금액 : freeDtySum */
	            }
	            
	            
	            
	            /** JAN */
	            payr0410Vo.setJan((Boolean.TRUE.equals(payr0410Dto.getJan()) ? "Y" : "N"));
	            
	            /** FEB */
	            payr0410Vo.setFeb((Boolean.TRUE.equals(payr0410Dto.getFeb()) ? "Y" : "N"));
	            
	            /** MAR */
	            payr0410Vo.setMar((Boolean.TRUE.equals(payr0410Dto.getMar()) ? "Y" : "N"));
	            
	            /** APR */
	            payr0410Vo.setApr((Boolean.TRUE.equals(payr0410Dto.getApr()) ? "Y" : "N"));
	            
	            /** MAY */
	            payr0410Vo.setMay((Boolean.TRUE.equals(payr0410Dto.getMay()) ? "Y" : "N"));
	            
	            /** JUN */
	            payr0410Vo.setJun((Boolean.TRUE.equals(payr0410Dto.getJun()) ? "Y" : "N"));
	            
	            /** JUL */
	            payr0410Vo.setJul((Boolean.TRUE.equals(payr0410Dto.getJul()) ? "Y" : "N"));
	            
	            /** AUG */
	            payr0410Vo.setAug((Boolean.TRUE.equals(payr0410Dto.getAug()) ? "Y" : "N"));
	            
	            /** SEP */
	            payr0410Vo.setSep((Boolean.TRUE.equals(payr0410Dto.getSep()) ? "Y" : "N"));
	            
	            /** OCT */
	            payr0410Vo.setOct((Boolean.TRUE.equals(payr0410Dto.getOct()) ? "Y" : "N"));
	            
	            /** NOV */
	            payr0410Vo.setNov((Boolean.TRUE.equals(payr0410Dto.getNov()) ? "Y" : "N"));
	            
	            /** DEC */
	            payr0410Vo.setDec((Boolean.TRUE.equals(payr0410Dto.getDec()) ? "Y" : "N"));
	            
	            if(null == payr0410Dto.getRngeOrd()){
	            	payr0410Vo.setRngeOrd(BigDecimal.ZERO);    							/** column 정렬순서 : rngeOrd */
	            }else{
	            	payr0410Vo.setRngeOrd(new BigDecimal(payr0410Dto.getRngeOrd()));    /** column 정렬순서 : rngeOrd */
	            }
	            payr0410Vo.setPayItemUseYn((Boolean.TRUE.equals(payr0410Dto.getPayItemUseYn()) ? "Y" : "N"));  /** column 급여항목사용여부 : payItemUseYn */
	            
	            payr0410Vo.setItemApptnBgnnDt(payr0410Dto.getItemApptnBgnnDt());    	/** column 항목적용시작일자 : itemApptnBgnnDt */
	            payr0410Vo.setItemApptnEndDt(payr0410Dto.getItemApptnEndDt());    		/** column 항목적용종료일자 : itemApptnEndDt */
	            payr0410Vo.setDayMnthAmntDivCd(payr0410Dto.getDayMnthAmntDivCd());		/** column 일월액구분코드 : dayMnthAmntDivCd */
	            payr0410Vo.setCalcStdDivCd(payr0410Dto.getCalcStdDivCd());    			/** column 계산기준구분코드 : calcStdDivCd */
	            payr0410Vo.setEmymtDivCd(payr0410Dto.getEmymtDivCd());					/** column 고용구분코드 : emymtDivCd */

	            /** USALY_AMNT_YN */
	            payr0410Vo.setUsalyAmntYn((Boolean.TRUE.equals(payr0410Dto.getUsalyAmntYn()) ? "Y" : "N"));  /** column 통상임금여부 : usalyAmntYn */
	          
	            payr0410Vo.setPayItemNoteCtnt(payr0410Dto.getPayItemNoteCtnt());    	/** column 급여항목비고내용 : payItemNoteCtnt */
	            payr0410Vo.setCalcStdFunc(payr0410Dto.getCalcStdFunc());    			/** column 계산수식내용 : calcStdFunc */
				
	            payr0410Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
	            payr0410Vo.setIsmt(sessionUser.getUsrId());    											/** column 수정자 : ismt */
	            payr0410Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
	            payr0410Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 수정주소 : revnAddr */
	            
	            
	            payr0410DAO.deletePayr510002To0410(payr0410Vo);
	            payr0410DAO.insertPayr0410(payr0410Vo);
	            

			}

        }catch (Exception ex) {
            
            logger.error("EXCEPTION calling activityOnPayr150002ToPayr0410Insert(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnPayr150002ToPayr0410Insert", ex, logger);
        }finally {
          
        }
        return result; 
    }
 
}
