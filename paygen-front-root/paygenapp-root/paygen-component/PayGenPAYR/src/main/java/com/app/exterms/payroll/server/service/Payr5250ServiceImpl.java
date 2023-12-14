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
import com.app.exterms.payroll.client.dto.Payr0416DTO;
import com.app.exterms.payroll.client.dto.Payr0417DTO;
import com.app.exterms.payroll.client.service.Payr5250Service;
import com.app.exterms.payroll.server.service.dao.Payr0416DAO;
import com.app.exterms.payroll.server.service.dao.Payr0417DAO;
import com.app.exterms.payroll.server.vo.Payr0416SrhVO;
import com.app.exterms.payroll.server.vo.Payr0416VO;
import com.app.exterms.payroll.server.vo.Payr0417SrhVO;
import com.app.exterms.payroll.server.vo.Payr0417VO;
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

@Service("Payr5250Service")
public class Payr5250ServiceImpl extends AbstractCustomServiceImpl implements Payr5250Service , PayrDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Payr5250ServiceImpl.class);
	private static final String calledClass = Payr5250ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "Payr0416DAO")
	private Payr0416DAO payr0416DAO;

	@Autowired
	@Resource(name = "Payr0417DAO")
	private Payr0417DAO payr0417DAO;

	public PagingLoadResult<BaseModel> getPayr0416DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0416_DATA_LIST;
        Payr0416SrhVO   payr0416SrhVO = new Payr0416SrhVO();
//        Payr0415VO      payr0415VO = new Payr0415VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
 
        try {
        	
        	payr0416DAO = (Payr0416DAO)BeanFinder.getBean("Payr0416DAO");
        	
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
            payr0416SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0416SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
            payr0416SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
          //  payr0415SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0416SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0416SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
          //  payr0415SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));  
            payr0416SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));  
//            payr0416SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));  
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
             
            	if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
               	 
            		payr0416SrhVO.setDeptCd(sessionUser.getDeptCd()); 
           	 } else {
           		payr0416SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))));
                    
           	 }  
            	
            	
            	payr0416SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	payr0416SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
                     if (payr0416SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                    	 payr0416SrhVO.setDeptCd("");  					//부서코드
                     } else {
                    	 payr0416SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))));
                     } 
            	}
            
//            } else {
//            	
//            }
           /******************************** 권한 ************************************************************************/		            
            
            int iCheck= payr0416DAO.selectPayr0416ListTotCnt(payr0416SrhVO);  
            
            if(iCheck > 0 ) {
            	payr0416SrhVO.setChkPayrMangDeptCd("Y");
            }else {
            	payr0416SrhVO.setChkPayrMangDeptCd("N");
            }
//            
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0416DAO.selectPayr0416ListTotCnt(payr0416SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                      
                
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0415DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0416SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0416SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0416SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));       
            }            
           
            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0416DAO.selectPayr0416List(payr0416SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("typOccuCd").toString();
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
	
	
	
	public PagingLoadResult<BaseModel> getPayr0417DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0417_DATA_LIST;
        Payr0417SrhVO   payr0417SrhVO = new Payr0417SrhVO();
//        Payr0415VO      payr0415VO = new Payr0415VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
 
        try {
        	
        	payr0417DAO = (Payr0417DAO)BeanFinder.getBean("Payr0417DAO");
        	
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
            payr0417SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0417SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
            payr0417SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
          //  payr0415SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
//            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
//            payr0417SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//            payr0417SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
          //  payr0415SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));  
//            payr0416SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));  
            payr0417SrhVO.setDtilOccuDlySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuDlySeilNum"), "0") ));
            
            
            payr0417SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));  
            
//            payr0416SrhVO.setCreateYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "createYr")));
            
            
//            int iCheck= payr0416DAO.selectPayr0416ListTotCnt(payr0416SrhVO);  
//            
//            if(iCheck > 0 ) {
//            	payr0416SrhVO.setChkPayrMangDeptCd("Y");
//            }else {
//            	payr0416SrhVO.setChkPayrMangDeptCd("N");
//            }
//            
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0417DAO.selectPayr0417ListTotCnt(payr0417SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                      
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;
                
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0417DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0417SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0417SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0417SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));       
            }            
           
            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0417DAO.selectPayr0417List(payr0417SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0417DataList, "getPayr0417DataList");
       

		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}
	
	
	
	
    @Override
    public Long activityOnPayr5250Insert(Payr0416DTO payr0416Dto, List<BaseModel> listModels, ActionDatabase actionDatabase) throws MSFException  {
        // TODO Auto-generated method stub
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    	
        Long result = new Long(0);
        Long iCnt = new Long(0);
        try { 
            
        	payr0416DAO = (Payr0416DAO)BeanFinder.getBean("Payr0416DAO");
        	
           
          Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)listModels.iterator();
          while (iterRecords.hasNext()) {
            
              BaseModel bmMapModel = (BaseModel) iterRecords.next();
               
              Payr0416VO payr0416Vo = new Payr0416VO();
              
              payr0416Vo.setPayYr(MSFSharedUtils.allowNulls(payr0416Dto.getPayYr()));
              payr0416Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0416Dto.getDpobCd()));
              payr0416Vo.setDeptCd(MSFSharedUtils.allowNulls(payr0416Dto.getDeptCd()));
              payr0416Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd"))) ;
              payr0416Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd"))) ;
              payr0416Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));  
               

              payr0416Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
              payr0416Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
              payr0416Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
              payr0416Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
              
              
            switch (actionDatabase) {
            case INSERT:
                payr0416DAO.insertPayr0416(payr0416Vo); 
                break; 
            }
            
            iCnt = iCnt + 1;
              
          } 
          
          result = iCnt;
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr5250Insert(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnPayr5250Insert", ex, logger);
        }
        finally {
          
        }
        
        return result;
    }
	
    
    
    @Override
    public Long activityOnPayr5250Delete(List<Payr0416DTO> listPayr0416Dto, ActionDatabase actionDatabase) throws MSFException  {
        // TODO Auto-generated method stub
    	
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    	
        Long result = new Long(0);
//        Long iCnt = new Long(0);
        try { 
        	
        	payr0416DAO = (Payr0416DAO)BeanFinder.getBean("Payr0416DAO");
            
            
            for(int iPayrCnt=0;iPayrCnt < listPayr0416Dto.size();iPayrCnt++) {
	            
            	Payr0416DTO payr0416Dto = new Payr0416DTO();  
            	payr0416Dto = listPayr0416Dto.get(iPayrCnt);
          
            	Payr0416VO payr0416Vo = new Payr0416VO(); 
            	Payr0417VO payr0417Vo = new Payr0417VO(); 
            	
            	
                payr0416Vo.setPayYr(MSFSharedUtils.allowNulls(payr0416Dto.getPayYr()));
                payr0416Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0416Dto.getDpobCd()));
                payr0416Vo.setTypOccuCd(MSFSharedUtils.allowNulls(payr0416Dto.getTypOccuCd())) ;
                payr0416Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(payr0416Dto.getDtilOccuInttnCd()));
                payr0416Vo.setDtilOccuDlySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0416Dto.getDtilOccuDlySeilNum(), "0"))) ;
            	
                
                payr0417Vo.setPayYr(MSFSharedUtils.allowNulls(payr0416Dto.getPayYr()));
                payr0417Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0416Dto.getDpobCd()));
                payr0417Vo.setDtilOccuDlySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0416Dto.getDtilOccuDlySeilNum(), "0"))) ;
                
                
				// 디테일 삭제
				payr0417DAO.deletePayr0417_D(payr0417Vo);

				// 마스터 삭제
				payr0416DAO.deletePayr0416(payr0416Vo);

				result = result + 1;
			}
            
          
		} catch (Exception ex) {
			logger.error("EXCEPTION calling activityOnPayr5250Delete(): " + ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException(
					"activityOnPayr5250Delete", ex, logger);
		} finally {

		}

		return result;
	}
    
    
    @Override
    public Long activityOnPayr0417Insert(Payr0417DTO payr0417Dto, List<BaseModel> listModels, ActionDatabase actionDatabase) {
    	
    	
        Long result = new Long(0);
        Long iCnt = new Long(0);
        
        
        try { 
            
        	payr0417DAO = (Payr0417DAO)BeanFinder.getBean("Payr0417DAO");
        	
            
            
       	 	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
            
       	 	Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)listModels.iterator();
       	 	while (iterRecords.hasNext()) {
            
       	 		BaseModel bmMapModel = (BaseModel) iterRecords.next();
               
       	 		Payr0417VO payr0417Vo = new Payr0417VO();
              
              
              
       	 		payr0417Vo.setPayYr(MSFSharedUtils.allowNulls(payr0417Dto.getPayYr()));    												/** column 급여년도 : payYr */
       	 		payr0417Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0417Dto.getDpobCd()));    											/** column 사업장코드 : dpobCd */
       	 		payr0417Vo.setItemDlySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0417Dto.getItemDlySeilNum(),"0")));    		/** column 급여일용단가항목일련번호 : itemDlySeilNum */
       	 		payr0417Vo.setDtilOccuDlySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0417Dto.getDtilOccuDlySeilNum(),"0")));	/** column 직종세단가항목일련번호 : dtilOccuDlySeilNum */
       	 		payr0417Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(payr0417Dto.getPayrMangDeptCd()));    							/** column 급여관리부서코드 : payrMangDeptCd */
       	 		payr0417Vo.setPayrImcd(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyCd")));    									/** column 급여항목코드 : payrImcd */
       	 		payr0417Vo.setItemNm(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyNm")));    										/** column 항목명 : itemNm */
       	 		payr0417Vo.setPayCd(MSFSharedUtils.allowNulls(payr0417Dto.getPayCd()));    												/** column 급여구분코드 : payCd */
       	 		payr0417Vo.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd"))); 				/** column 지급공제구분코드 : pymtDducDivCd */
       	 		payr0417Vo.setPymtDducFrmCd(MSFSharedUtils.allowNulls(payr0417Dto.getPymtDducFrmCd())); 				/** column 지급공제유형코드 : pymtDducFrmCd */
              	payr0417Vo.setPymtDducRate(new BigDecimal(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyRto"))));	/** column 지급공제율 : pymtDducRate */
              	payr0417Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpySum"))));	/** column 지급공제액 : pymtDducSum */
              	payr0417Vo.setTxtnDivCd(MSFSharedUtils.allowNulls(payr0417Dto.getTxtnDivCd()));    						/** column 과세구분코드 : txtnDivCd */
              	payr0417Vo.setFreeDtyRate(BigDecimal.ZERO);	/** column 비과세율 : freeDtyRate */
              	payr0417Vo.setFreeDtySum(BigDecimal.ZERO);	/** column 비과세금액 : freeDtySum */
              	payr0417Vo.setJan("N");    					/** column 1월 : jan */
              	payr0417Vo.setFeb("N");    					/** column 2월 : feb */
              	payr0417Vo.setMar("N");    					/** column 3월 : mar */
              	payr0417Vo.setApr("N");    					/** column 4월 : apr */
              	payr0417Vo.setMay("N");    					/** column 5월 : may */
              	payr0417Vo.setJun("N");    					/** column 6월 : jun */
              	payr0417Vo.setJul("N");    					/** column 7월 : jul */
              	payr0417Vo.setAug("N");    					/** column 8월 : aug */
              	payr0417Vo.setSep("N");    					/** column 9월 : sep */
              	payr0417Vo.setOct("N");    					/** column 10월 : oct */
              	payr0417Vo.setNov("N");    					/** column 11월 : nov */
              	payr0417Vo.setDec("N");    					/** column 12월 : dec */
              	payr0417Vo.setRngeOrd(BigDecimal.ZERO);    	/** column 정렬순서 : rngeOrd */
              	payr0417Vo.setSumOhrItemApptnYn(MSFSharedUtils.allowNulls(payr0417Dto.getSumOhrItemApptnYn()));	/** column 금액타항목동일적용여부 : sumOhrItemApptnYn */
              	payr0417Vo.setPayItemUseYn("Y");    		/** column 급여항목사용여부 : payItemUseYn */
              	payr0417Vo.setItemApptnBgnnDt(MSFSharedUtils.allowNulls(payr0417Dto.getItemApptnBgnnDt()));		/** column 항목적용시작일자 : itemApptnBgnnDt */
              	payr0417Vo.setItemApptnEndDt(MSFSharedUtils.allowNulls(payr0417Dto.getItemApptnEndDt()));    	/** column 항목적용종료일자 : itemApptnEndDt */
              	payr0417Vo.setDayMnthAmntDivCd(MSFSharedUtils.allowNulls(payr0417Dto.getDayMnthAmntDivCd()));	/** column 일월액구분코드 : dayMnthAmntDivCd */
              	payr0417Vo.setCalcStdDivCd(MSFSharedUtils.allowNulls(payr0417Dto.getCalcStdDivCd()));    		/** column 계산기준구분코드 : calcStdDivCd */
              	payr0417Vo.setCalcStdFunc(MSFSharedUtils.allowNulls(payr0417Dto.getCalcStdFunc()));    			/** column 계산수식내용 : calcStdFunc */
              	payr0417Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(payr0417Dto.getEmymtDivCd()));    			/** column 고용구분코드 : emymtDivCd */
              	payr0417Vo.setUsalyAmntYn("N");    				/** column 통상임금여부 : usalyAmntYn */
              	payr0417Vo.setPayItemNoteCtnt(MSFSharedUtils.allowNulls(payr0417Dto.getPayItemNoteCtnt()));		/** column 급여항목비고내용 : payItemNoteCtnt */
              	payr0417Vo.setKybdr(sessionUser.getUsrId());	/** column 입력자 : kybdr */
//              payr0417Vo.setInptDt(payr0417Dto.getInptDt());    /** column 입력일자 : inptDt */
              	payr0417Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
              	payr0417Vo.setIsmt(sessionUser.getUsrId());		/** column 수정자 : ismt */
//              payr0417Vo.setRevnDt(payr0417Dto.getRevnDt());    /** column 수정일자 : revnDt */
              	payr0417Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */              
              
               
            switch (actionDatabase) {
            case INSERT:
                payr0417DAO.insertPayr0417(payr0417Vo); 
                break; 
            }
            
            iCnt = iCnt + 1;

			}

			result = iCnt;
		} catch (Exception ex) {
			logger.error("EXCEPTION calling activityOnPayr0400Insert(): " + ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException(
					"activityOnPayr0400Insert", ex, logger);

		} finally {

		}

		return result;
	}
    
    
	/** 지급공제항목 수정 **/
    @Override
    public Long activityOnPayr0417DetailFormSave(Payr0417DTO payr0417Dto, ActionDatabase actionDatabase)throws MSFException {
    	
    	
        // TODO Auto-generated method stub
		Long result = new Long(1);
		Long iCnt = new Long(0);
		
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

        try { 
          
            Payr0417VO payr0417Vo = new Payr0417VO();

            payr0417Vo.setPayYr(MSFSharedUtils.allowNulls(payr0417Dto.getPayYr()));    												/** column 급여년도 : payYr */
            payr0417Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0417Dto.getDpobCd()));    											/** column 사업장코드 : dpobCd */
            payr0417Vo.setItemDlySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0417Dto.getItemDlySeilNum(), "0")));    	/** column 급여일용단가항목일련번호 : itemDlySeilNum */
            payr0417Vo.setDtilOccuDlySeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0417Dto.getDtilOccuDlySeilNum(), "0")));/** column 직종세단가항목일련번호 : dtilOccuDlySeilNum */
            payr0417Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(payr0417Dto.getPayrMangDeptCd()));    							/** column 급여관리부서코드 : payrMangDeptCd */
            payr0417Vo.setPayrImcd(MSFSharedUtils.allowNulls(payr0417Dto.getPayrImcd()));    										/** column 급여항목코드 : payrImcd */
            payr0417Vo.setItemNm(MSFSharedUtils.allowNulls(payr0417Dto.getItemNm()));    											/** column 항목명 : itemNm */
            payr0417Vo.setPayCd(MSFSharedUtils.allowNulls(payr0417Dto.getPayCd()));    												/** column 급여구분코드 : payCd */
            payr0417Vo.setPymtDducDivCd(MSFSharedUtils.allowNulls(payr0417Dto.getPymtDducDivCd()));    								/** column 지급공제구분코드 : pymtDducDivCd */
            payr0417Vo.setPymtDducFrmCd(MSFSharedUtils.allowNulls(payr0417Dto.getPymtDducFrmCd()));    								/** column 지급공제유형코드 : pymtDducFrmCd */
            payr0417Vo.setPymtDducRate(new BigDecimal(MSFSharedUtils.defaultNulls(payr0417Dto.getPymtDducRate(), "0")));    		/** column 지급공제율 : pymtDducRate */
            payr0417Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0417Dto.getPymtDducSum(), "0")));    			/** column 지급공제액 : pymtDducSum */
            payr0417Vo.setTxtnDivCd(MSFSharedUtils.allowNulls(payr0417Dto.getTxtnDivCd()));    										/** column 과세구분코드 : txtnDivCd */
            payr0417Vo.setFreeDtyRate(new BigDecimal(MSFSharedUtils.defaultNulls(payr0417Dto.getFreeDtyRate(), "0")));    			/** column 비과세율 : freeDtyRate */
            payr0417Vo.setFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0417Dto.getFreeDtySum(), "0")));    			/** column 비과세금액 : freeDtySum */
            payr0417Vo.setJan(MSFSharedUtils.allowNulls(payr0417Dto.getJan()));    													/** column 1월 : jan */
            payr0417Vo.setFeb(MSFSharedUtils.allowNulls(payr0417Dto.getFeb()));    													/** column 2월 : feb */
            payr0417Vo.setMar(MSFSharedUtils.allowNulls(payr0417Dto.getMar()));    													/** column 3월 : mar */
            payr0417Vo.setApr(MSFSharedUtils.allowNulls(payr0417Dto.getApr()));    													/** column 4월 : apr */
            payr0417Vo.setMay(MSFSharedUtils.allowNulls(payr0417Dto.getMay()));    													/** column 5월 : may */
            payr0417Vo.setJun(MSFSharedUtils.allowNulls(payr0417Dto.getJun()));   													/** column 6월 : jun */
            payr0417Vo.setJul(MSFSharedUtils.allowNulls(payr0417Dto.getJul()));    													/** column 7월 : jul */
            payr0417Vo.setAug(MSFSharedUtils.allowNulls(payr0417Dto.getAug()));   			 										/** column 8월 : aug */
            payr0417Vo.setSep(MSFSharedUtils.allowNulls(payr0417Dto.getSep()));    													/** column 9월 : sep */
            payr0417Vo.setOct(MSFSharedUtils.allowNulls(payr0417Dto.getOct()));    													/** column 10월 : oct */
            payr0417Vo.setNov(MSFSharedUtils.allowNulls(payr0417Dto.getNov()));    													/** column 11월 : nov */
            payr0417Vo.setDec(MSFSharedUtils.allowNulls(payr0417Dto.getDec()));    													/** column 12월 : dec */
            payr0417Vo.setRngeOrd(new BigDecimal(MSFSharedUtils.defaultNulls(payr0417Dto.getRngeOrd(), "0")));    					/** column 정렬순서 : rngeOrd */
            payr0417Vo.setSumOhrItemApptnYn(MSFSharedUtils.allowNulls(payr0417Dto.getSumOhrItemApptnYn()));    						/** column 금액타항목동일적용여부 : sumOhrItemApptnYn */
            payr0417Vo.setPayItemUseYn(MSFSharedUtils.allowNulls(payr0417Dto.getPayItemUseYn()));    								/** column 급여항목사용여부 : payItemUseYn */
            payr0417Vo.setItemApptnBgnnDt(MSFSharedUtils.allowNulls(payr0417Dto.getItemApptnBgnnDt()));    							/** column 항목적용시작일자 : itemApptnBgnnDt */
            payr0417Vo.setItemApptnEndDt(MSFSharedUtils.allowNulls(payr0417Dto.getItemApptnEndDt()));    							/** column 항목적용종료일자 : itemApptnEndDt */
            payr0417Vo.setDayMnthAmntDivCd(MSFSharedUtils.allowNulls(payr0417Dto.getDayMnthAmntDivCd()));    						/** column 일월액구분코드 : dayMnthAmntDivCd */
            payr0417Vo.setCalcStdDivCd(MSFSharedUtils.allowNulls(payr0417Dto.getCalcStdDivCd()));    								/** column 계산기준구분코드 : calcStdDivCd */
            payr0417Vo.setCalcStdFunc(MSFSharedUtils.allowNulls(payr0417Dto.getCalcStdFunc()));    									/** column 계산수식내용 : calcStdFunc */
            payr0417Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(payr0417Dto.getEmymtDivCd()));    									/** column 고용구분코드 : emymtDivCd */
            payr0417Vo.setUsalyAmntYn(MSFSharedUtils.allowNulls(payr0417Dto.getUsalyAmntYn()));    									/** column 통상임금여부 : usalyAmntYn */
            payr0417Vo.setPayItemNoteCtnt(MSFSharedUtils.allowNulls(payr0417Dto.getPayItemNoteCtnt()));    							/** column 급여항목비고내용 : payItemNoteCtnt */
//          	payr0417Vo.setKybdr(sessionUser.getUsrId());																			/** column 입력자 : kybdr */
//          payr0417Vo.setInptDt(payr0417Dto.getInptDt());    /** column 입력일자 : inptDt */
//          	payr0417Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    									/** column 입력주소 : inptAddr */
          	payr0417Vo.setIsmt(sessionUser.getUsrId());																				/** column 수정자 : ismt */
//          payr0417Vo.setRevnDt(payr0417Dto.getRevnDt());    /** column 수정일자 : revnDt */
          	payr0417Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    									/** column 수정주소 : revnAddr */   
           
            switch (actionDatabase) {
            case INSERT:
               break;
            case UPDATE: 
                payr0417DAO.updatePayr0417(payr0417Vo);
                break;
            case DELETE: 
                payr0417DAO.deletePayr0417(payr0417Vo);
                break;
            }
            
        }catch (Exception ex) {
            
            logger.error("EXCEPTION calling activityOnPayr0417DetailFormSave(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnPayr0417DetailFormSave", ex, logger);
        }finally {
          
        }
        return result; 
    }

	
    /**
     * 
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getCboPayr0416PayYrList
     * @date : 2017. 5. 10.
     * @author : paygen
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2017. 5. 10.		paygen				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param serviceParameters
     * @return
     * @throws MSFException
     */
    public PagingLoadResult<BaseModel> getCboPayr0416PayYrList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getCboPayr0416PayYrList";
        Payr0416SrhVO   payr0416SrhVO = new Payr0416SrhVO();
        Payr0416VO      payr0416VO = new Payr0416VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
         
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        try {
          
        	payr0416DAO = (Payr0416DAO)BeanFinder.getBean("Payr0416DAO");
        	
        	
             ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
             IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
             List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
             PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
 	         
        	
            //Get paging configuration
             PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
             payr0416SrhVO.setDpobCd(sessionUser.getDpobCd());
           // sysComSrhVo.setRpsttvCd(sysComBass0300Dto.getRpsttvCd());
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  payr0416DAO.selectPayr0416PayYrListTotCnt(payr0416SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;
                      
                
               logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPayr0415PayYrList = SmrmfUtils.startTiming(logger);
         
          
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0416SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0416SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.totalRecordCount < 100) {
            	payr0416SrhVO.setLastIndex(pagingValues.totalRecordCount); 
            } else  if (pagingValues.offsetLimit > 0) {
            	payr0416SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            } 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ?????? 
            List list = payr0416DAO.selectPayr0416PayYrList(payr0416SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayr0415PayYrList, "getCboPayr0416PayYrList");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }	
	
	
	
	
 
}
