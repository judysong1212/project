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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.payroll.client.dto.Payr0485DTO;
import com.app.exterms.payroll.client.service.Payr1450Service;
import com.app.exterms.payroll.server.service.dao.Payr0470DAO;
import com.app.exterms.payroll.server.service.dao.Payr0485DAO;
import com.app.exterms.payroll.server.vo.Payr0470SrhVO;
import com.app.exterms.payroll.server.vo.Payr0470VO;
import com.app.exterms.payroll.server.vo.Payr0485SrhVO;
import com.app.exterms.payroll.server.vo.Payr0485VO;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
@Service("Payr1450Service")
public class Payr1450ServiceImpl extends AbstractCustomServiceImpl implements Payr1450Service, PayrDaoConstants {


	private static final Logger logger = LoggerFactory.getLogger(Payr1450ServiceImpl.class);
	private static final String calledClass = Payr1450ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="Payr0470DAO")
    private Payr0470DAO payr0470DAO;
	
    @Autowired
    @Resource(name="Payr0485DAO")
    private Payr0485DAO payr0485DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPayr0470IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
    
    
    /** PAYR0470, 0480 수당공제항목 조회 **/
	public PagingLoadResult<BaseModel> getPayr0470DataList(ServiceParameters serviceParameters) throws MSFException {
        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0470TO0485_DATA_LIST;
        Payr0470SrhVO   payr0470SrhVO = new Payr0470SrhVO();
        Payr0470VO      payr0470VO = new Payr0470VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(payr0470DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	payr0470DAO = (Payr0470DAO) wac.getBean("Payr0470DAO" ); 
        }
        
        try {
        	
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
            payr0470SrhVO.setEmymtDivCd(MSFSharedUtils.defaultNulls( MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd"),"")); //고용구분코드
           
            payr0470SrhVO.setPymtDducDivCd(MSFSharedUtils.defaultNulls( MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd"),"")); //지급공제구분코드
//            List<String> lsPymtDducDivCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd"))); 
//            payr0470SrhVO.setPymtDducDivCdArr(lsPymtDducDivCd); //수당그룹코드<list>
            
            
            payr0470SrhVO.setDtilPayExtpyGrpCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payExtpyGrpCd")));
            List<String> lstDtilPayExtpyGrpCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payExtpyGrpCd"))); 
            payr0470SrhVO.setDtilPayExtpyGrpCdArr(lstDtilPayExtpyGrpCd); //수당그룹코드<list>
           
            
            // payr0470SrhVO.setPayExtpyGrpCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payExtpyGrpCd"))); //수당그룹코드
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0470DAO.selectPayr0470ListTotCnt(payr0470SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0470DataList = SmrmfUtils.startTiming(logger);
        
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
            List list = payr0470DAO.selectPayr0470ToPayr0480List(payr0470SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
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
                       
                     case ColumnDef.TYPE_LONG:   
                     
                    if (mapCon != null) {  
                        Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
                        map.put(tableAttributes[i].getName(), lValue); 
                    }  
                       
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0470DataList, "getPayr0470DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	
	/** PAYR0485 수당공제항목 조회 **/
	public PagingLoadResult<BaseModel> getPayr1450ToPayr0485DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR1450TOPAYR0485_DATA_LIST;
        Payr0485SrhVO   payr0485SrhVO = new Payr0485SrhVO(); 
        //Payr0470SrhVO   payr0470SrhVO = new Payr0470SrhVO();
        Payr0485VO payr0485VO = new Payr0485VO();
        //Payr0470VO      payr0470VO = new Payr0470VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(payr0485DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	payr0485DAO = (Payr0485DAO) wac.getBean("Payr0485DAO" ); 
        }
        
        try {
        	
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
            payr0485SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0485SrhVO.setEmymtDivCd(MSFSharedUtils.defaultNulls( MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd"),"")); //고용구분코드
//            payr0485SrhVO.setPymtDducDivCd(MSFSharedUtils.defaultNulls( MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd"),"")); //지급공제구분코드
            payr0485SrhVO.setPymtDducDivCd(MSFSharedUtils.defaultNulls( MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd"),"")); //지급공제구분코드
//            List<String> lsPymtDducDivCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd"))); 
//            payr0485SrhVO.setPymtDducDivCdArr(lsPymtDducDivCd); //수당그룹코드<list>          
            
            
            payr0485SrhVO.setDtilPayExtpyGrpCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payExtpyGrpCd")));
            List<String> lstDtilPayExtpyGrpCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payExtpyGrpCd"))); 
            payr0485SrhVO.setDtilPayExtpyGrpCdArr(lstDtilPayExtpyGrpCd); //수당그룹코드<list>
           // payr0470SrhVO.setPayExtpyGrpCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payExtpyGrpCd"))); //수당그룹코드
           
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0485DAO.selectPayr0485ListTotCnt(payr0485SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0470DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0485SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0485SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0485SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0485DAO.selectPayr0145ToPayr0485List(payr0485SrhVO);
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payItemCd").toString();
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
                    			
                 		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
                 	          			
                 			String rrnDecCrypt = "";
                 	          			
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0470DataList, "getPayr1450ToPayr0485DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	
//    @Override
//    public Long activityOnPayr1400Save(List<Payr0470DTO> listPayr0470dto) {
//        // TODO Auto-generated method stub
//        Long result = new Long(0);
//        Long iCnt = new Long(0);
//        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//        try { 
//            
//            Payr0470SrhVO payr0470SrhVo = new Payr0470SrhVO(); 
//            
//        	// 1. 암호화 객체 생성
////        	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//            
//            if  (MSFSharedUtils.paramNull(payr0470DAO)) {
//                
//                WebApplicationContext wac = WebApplicationContextUtils.
//                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//                payr0470DAO = (Payr0470DAO) wac.getBean("Payr0470DAO" ); 
//            }
//          
//            for(int iPayrCnt=0;iPayrCnt < listPayr0470dto.size();iPayrCnt++) {
//                
//                   Payr0470DTO payr0470dto = new Payr0470DTO(); 
//                   payr0470dto = listPayr0470dto.get(iPayrCnt);
//                  
//                    Payr0470VO payr0470Vo = new Payr0470VO(); 
//                    Payr0470VO tpPayr0470Vo = new Payr0470VO(); 
//
//                    payr0470Vo.setDpobCd(payr0470dto.getDpobCd());    													/** column 사업장코드 : dpobCd */
//                    payr0470Vo.setPayDducCd(payr0470dto.getPayDducCd());    											/** column 급여공제코드 : payDducCd */
//                    payr0470Vo.setPymtDducDivCd(payr0470dto.getPymtDducDivCd());    									/** column 지급공제구분코드 : pymtDducDivCd */
//                    payr0470Vo.setPayDducGrpCd(payr0470dto.getPayDducGrpCd());    										/** column 급여공제그룹코드 : payDducGrpCd */
//                    payr0470Vo.setPayDducNm(payr0470dto.getPayDducNm());    											/** column 급여공제명 : payDducNm */
//                    payr0470Vo.setPayDducUseYn(Boolean.TRUE.equals(payr0470dto.getPayDducUseYn()) ? "Y" : "N" );    	/** column 급여공제사용여부 : payDducUseYn */
//                    payr0470Vo.setPayDducSum(new BigDecimal(MSFSharedUtils.allowNulls(payr0470dto.getPayDducSum())));	/** column 급여공제금액 : payDducSum */
//                    payr0470Vo.setPayDducRto(new BigDecimal(MSFSharedUtils.allowNulls(payr0470dto.getPayDducRto())));	/** column 급여공제비율 : payDducRto */
//                    payr0470Vo.setYrtxDducDivCd(payr0470dto.getYrtxDducDivCd());    									/** column 연말정산_공제구분코드 : yrtxDducDivCd */
//                    payr0470Vo.setGrpApptnDivCd(payr0470dto.getGrpApptnDivCd());    									/** column 그룹적용구분코드 : grpApptnDivCd */
//                    payr0470Vo.setPayDducBgnnDt(payr0470dto.getPayDducBgnnDt());    									/** column 급여공제시작일자 : payDducBgnnDt */
//                    payr0470Vo.setPayDducEndDt(payr0470dto.getPayDducEndDt());    										/** column 급여공제종료일자 : payDducEndDt */
//                    payr0470Vo.setPayrTermDducYn(Boolean.TRUE.equals(payr0470dto.getPayDducUseYn()) ? "Y" : "N" );    	/** column 기간제공제사용여부 : payrTermDducYn */
//                    payr0470Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
//                    payr0470Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    				/** column 입력주소 : inptAddr */
//                    payr0470Vo.setIsmt(sessionUser.getUsrId());    														/** column 수정자 : ismt */
//                    payr0470Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    				/** column 수정주소 : revnAddr */
//                    
//                    tpPayr0470Vo = payr0470DAO.selectPayr0470(payr0470Vo);
//                     
//                    if (tpPayr0470Vo == null) { 
//                      
//                          payr0470DAO.insertPayr0470(payr0470Vo); 
//                          iCnt = iCnt + 1;
//                    } else {
//                          payr0470DAO.updatePayr0470(payr0470Vo); 
//                          iCnt = iCnt + 1;
//                    }       
//                          
//                    
//               } 
//                result = iCnt;
//          
//        }
//        catch (Exception ex) {
//            logger.error("EXCEPTION calling activityOnPayr1500BfToNew(): "+ex); 
//            result = new Long(0);
//            throw MSFServerUtils.getOperationException("activityOnPayr1500BfToNew", ex, logger);
//        }
//        finally {
//          
//        }
//        
//        return result;
//    }
//    @Override
//    public Long activityOnPayr1400Delete(List<BaseModel> listModels) {
//        // TODO Auto-generated method stub
//        Long result = new Long(0);
//        Long iCnt = new Long(0);
//        try { 
//            
//            Payr0470VO payr0470Vo = new Payr0470VO(); 
//            
//            if  (MSFSharedUtils.paramNull(payr0470DAO)) {
//                
//                WebApplicationContext wac = WebApplicationContextUtils.
//                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//                payr0470DAO = (Payr0470DAO) wac.getBean("Payr0470DAO" ); 
//            }
//      
//         
//                Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)listModels.iterator();
//                while (iterRecords.hasNext()) {
//                  
//                    BaseModel bmMapModel = (BaseModel) iterRecords.next();
//                       
//                    payr0470Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd"))); 
//                    payr0470Vo.setPayDducCd(MSFSharedUtils.allowNulls(bmMapModel.get("payDducCd"))) ; 
//                       
//                    payr0470DAO.deletePayr0470(payr0470Vo);  
//                  
//                    iCnt = iCnt + 1;
//                     
//               } 
//                result = iCnt;
//          
//        }
//        catch (Exception ex) {
//            logger.error("EXCEPTION calling activityOnPayr1300Delete(): "+ex); 
//            result = new Long(0);
//            throw MSFServerUtils.getOperationException("activityOnPayr1300Delete", ex, logger);
//        }
//        finally {
//          
//        }
//        
//        return result;
//    }
//   
    //payr1450.java 출력항목 미상태 사용버튼
    @Override
	public Long payr1450Insert(Payr0485DTO payr0485Dto) throws MSFException {
		
		Long rtnData = 0L;
		Payr0485VO payr0485Vo = new Payr0485VO();
		String method = calledClass + ".payr1450Insert";
		MSFSysm0100BM sessionUser;

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		 
		try {
			
			payr0485Vo.setDpobCd(sessionUser.getDpobCd());    									/** column 사업장코드 : dpobCd */
			payr0485Vo.setEmymtDivCd(payr0485Dto.getEmymtDivCd()); 								/** column 고용구분코드 : emymtDivCd */
			payr0485Vo.setPayItemCd(payr0485Dto.getPayItemCd());  								/** column 항목코드 : payItemCd */
			payr0485Vo.setExtptDducUseYn(payr0485Dto.getExtptDducUseYn()); 						/** column 사용여부 : extptDducUseYn */
			payr0485Vo.setYrtxFreeDtyReduCd(payr0485Dto.getYrtxFreeDtyReduCd());  				/** column 비과세감면코드 : yrtxFreeDtyReduCd */
			payr0485Vo.setAccAccCd(payr0485Dto.getAccAccCd());  								/** column 회계계정코드 : accAccCd */
			payr0485Vo.setSevePayYn(payr0485Dto.getSevePayYn());  								/** column 퇴직여부 : sevePayYn */
			payr0485Vo.setPymtDducDivCd(payr0485Dto.getPymtDducDivCd());     					/** set 지급공제구분코드 : pymtDducDivCd */
			
			payr0485Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */
			payr0485Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  /** column 입력주소 : inptAddr */
			payr0485Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
			payr0485Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  /** column 수정주소 : revnAddr */
			
			payr0485DAO.insertPayr0485(payr0485Vo);	
 			
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
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C");
			
		   	rtnData = 1L;
		}catch(Exception e){
			e.printStackTrace();
			rtnData = 0L;
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}

		return rtnData;
	}
    
public Long updatePayr0485(Payr0485DTO payr0485Dto) throws MSFException {
		
		Long rtnData = 0L;
		Payr0485VO payr0485Vo = new Payr0485VO();
		String method = calledClass + ".payr1450Insert";
		MSFSysm0100BM sessionUser;

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		 
		try {
			
			payr0485Vo.setDpobCd(payr0485Dto.getDpobCd());							/** column 사업장코드 : dpobCd */
			payr0485Vo.setEmymtDivCd(payr0485Dto.getEmymtDivCd());
			payr0485Vo.setPayItemCd(payr0485Dto.getPayItemCd());					/** column 급여공제항목코드 : payItemCd */
			payr0485Vo.setYrtxFreeDtyReduCd(payr0485Dto.getYrtxFreeDtyReduCd());	/** column 비과세감면코드 : yrtxFreeDtyReduCd */
			payr0485Vo.setAccAccCd(payr0485Dto.getAccAccCd());						/** column 회계계정코드 : accAccCd */
			payr0485Vo.setSevePayYn(payr0485Dto.getSevePayYn());					/** column 퇴직정산포함 : sevePayYn */
			payr0485Vo.setPayrTermUseYn(payr0485Dto.getPayrTermUseYn());			/** column 기간제출력 : payrTermUseYn */
			payr0485Vo.setYrtxDotnCd(payr0485Dto.getYrtxDotnCd());					/** column 기부금유형 : yrtxDotnCd */
			payr0485Vo.setExtptDducDspyYn(payr0485Dto.getExtptDducDspyYn());		/** column 화면출력 : extptDducDspyYn */
			payr0485Vo.setExtptDducUseYn(payr0485Dto.getExtptDducUseYn());			/** column 사용 : extptDducUseYn */
			
			payr0485Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
			payr0485Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  /** column 수정주소 : revnAddr */
			
			payr0485DAO.updatePayr0485(payr0485Vo);	
 			
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
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C");
			
		   	rtnData = 1L;
		}catch(Exception e){
			e.printStackTrace();
			rtnData = 0L;
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}

		return rtnData;
	}
//다시구현
public Long payrUpdate0485Yn(Payr0485DTO payr0485Dto) throws MSFException {
	
	Long rtnData = 0L;
	Payr0485VO payr0485Vo = new Payr0485VO();
	String method = calledClass + ".payrUpdate0485Yn";
	MSFSysm0100BM sessionUser;

	if (RemoteServiceUtil.getThreadLocalRequest() != null) {
		sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	} else {
		sessionUser = getUser();
	}
	 
	try {
		
		payr0485Vo.setDpobCd(payr0485Dto.getDpobCd());							/** column 사업장코드 : dpobCd */
		payr0485Vo.setPayItemCd(payr0485Dto.getPayItemCd());					/** column 급여공제항목코드 : payItemCd */
		payr0485Vo.setYrtxFreeDtyReduCd(payr0485Dto.getYrtxFreeDtyReduCd());	/** column 비과세감면코드 : yrtxFreeDtyReduCd */
		payr0485Vo.setAccAccCd(payr0485Dto.getAccAccCd());						/** column 회계계정코드 : accAccCd */
		payr0485Vo.setSevePayYn(payr0485Dto.getSevePayYn());					/** column 퇴직정산포함 : sevePayYn */
		payr0485Vo.setPayrTermUseYn(payr0485Dto.getPayrTermUseYn());			/** column 기간제출력 : payrTermUseYn */
		payr0485Vo.setYrtxDotnCd(payr0485Dto.getYrtxDotnCd());					/** column 기부금유형 : yrtxDotnCd */
		payr0485Vo.setExtptDducDspyYn(payr0485Dto.getExtptDducDspyYn());		/** column 화면출력 : extptDducDspyYn */
		payr0485Vo.setExtptDducUseYn(payr0485Dto.getExtptDducUseYn());			/** column 사용 : extptDducUseYn */
		
		payr0485DAO.payrUpdate0485Yn(payr0485Vo);	
			
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
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C");
		
	   	rtnData = 1L;
	}catch(Exception e){
		e.printStackTrace();
		rtnData = 0L;
		throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
	}

	return rtnData;
}
 

public Long payrDelte0485(Payr0485DTO payr0485Dto) throws MSFException {
	
	Long rtnData = 0L;
	Payr0485VO payr0485Vo = new Payr0485VO();
	String method = calledClass + ".payrUpdate0485Yn";
	MSFSysm0100BM sessionUser;

	if (RemoteServiceUtil.getThreadLocalRequest() != null) {
		sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	} else {
		sessionUser = getUser();
	}
	 
	try {
		
		payr0485Vo.setDpobCd(payr0485Dto.getDpobCd());							/** column 사업장코드 : dpobCd */
		payr0485Vo.setPayItemCd(payr0485Dto.getPayItemCd());					/** column 급여공제항목코드 : payItemCd */
		payr0485Vo.setYrtxFreeDtyReduCd(payr0485Dto.getYrtxFreeDtyReduCd());	/** column 비과세감면코드 : yrtxFreeDtyReduCd */
		payr0485Vo.setAccAccCd(payr0485Dto.getAccAccCd());						/** column 회계계정코드 : accAccCd */
		payr0485Vo.setSevePayYn(payr0485Dto.getSevePayYn());					/** column 퇴직정산포함 : sevePayYn */
		payr0485Vo.setPayrTermUseYn(payr0485Dto.getPayrTermUseYn());			/** column 기간제출력 : payrTermUseYn */
		payr0485Vo.setYrtxDotnCd(payr0485Dto.getYrtxDotnCd());					/** column 기부금유형 : yrtxDotnCd */
		payr0485Vo.setExtptDducDspyYn(payr0485Dto.getExtptDducDspyYn());		/** column 화면출력 : extptDducDspyYn */
		payr0485Vo.setExtptDducUseYn(payr0485Dto.getExtptDducUseYn());			/** column 사용 : extptDducUseYn */
		
		payr0485DAO.payrDelte0485(payr0485Vo);	
			
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
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C");
		
	   	rtnData = 1L;
	}catch(Exception e){
		e.printStackTrace();
		rtnData = 0L;
		throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
	}

	return rtnData;
}
}
