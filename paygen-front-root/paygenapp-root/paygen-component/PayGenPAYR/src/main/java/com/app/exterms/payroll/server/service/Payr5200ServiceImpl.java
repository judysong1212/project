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
import java.text.SimpleDateFormat;
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

import com.any.smrmf.utils.BeanFinder;
import com.app.exterms.payroll.client.dto.Payr0440DTO;
import com.app.exterms.payroll.client.dto.Payr0445DTO;
import com.app.exterms.payroll.client.service.Payr5200Service;
import com.app.exterms.payroll.server.service.dao.Payr0440DAO;
import com.app.exterms.payroll.server.service.dao.Payr0445DAO;
import com.app.exterms.payroll.server.vo.Payr0440SrhVO;
import com.app.exterms.payroll.server.vo.Payr0440VO;
import com.app.exterms.payroll.server.vo.Payr0445SrhVO;
import com.app.exterms.payroll.server.vo.Payr0445VO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.exterms.prgm.server.service.dao.PrgmComBass0500DAO;
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

@Service("Payr5200Service")
public class Payr5200ServiceImpl extends AbstractCustomServiceImpl implements Payr5200Service , PayrDaoConstants{


	private static final Logger logger = LoggerFactory.getLogger(Payr5200ServiceImpl.class);
	private static final String calledClass = Payr5200ServiceImpl.class.getName();
	 
	@Autowired
    @Resource(name="Payr0440DAO")
    private Payr0440DAO payr0440DAO;
	
	@Autowired
    @Resource(name="Payr0445DAO")
    private Payr0445DAO payr0445DAO;
    
	
     @Autowired
     @Resource(name="PrgmComBass0500DAO")
     private PrgmComBass0500DAO bass0500DAO;
 
    
    /** ID Generation */
    //@Resource(name="{egovPayr0440IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
	
     
     public PagingLoadResult<BaseModel> getSelectPayr5200ToPayr0445List(ServiceParameters serviceParameters) throws MSFException {

         PagingLoadResult<BaseModel> retval = null;
         String method =  CLASS_PAYR5200_PAYR0445_DATA_LIST;
         Payr0445SrhVO   payr0445SrhVO = new Payr0445SrhVO();
         Payr0445VO      payr0445VO = new Payr0445VO();
         List<BaseModel>  bmResult = new ArrayList<BaseModel>();
         
         MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
         
     	// 1. 암호화 객체 생성
//     	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
         
         try {
        	 
        	 payr0445DAO = (Payr0445DAO)BeanFinder.getBean("Payr0445DAO");
        	 
        	 
             //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
            // Sysm0100BM          user             = serviceParameters.getUser();
             ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
             IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
             List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
             PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

             //Get paging configuration
             PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

             //Get query parameters
             //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
            
             /** 조건절 */
             payr0445SrhVO.setDpobCd(sessionUser.getDpobCd());
             payr0445SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
             
            
            if (MSFSharedUtils.paramNotNull(MSFServerUtils.getFilterValue(columnFilters, "occuClssPayCmpttnStd"))) {

                SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyyMMdd"); 
                String strOccuClssPayCmpttnStd = dateFormatGmt.format((Date)MSFServerUtils.getFilterValue(columnFilters, "occuClssPayCmpttnStd"));
                payr0445SrhVO.setOccuClssPayCmpttnStd(strOccuClssPayCmpttnStd);
                
            } else {
                payr0445SrhVO.setOccuClssPayCmpttnStd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "occuClssPayCmpttnStd")));
            }
            
             payr0445SrhVO.setTypOccuGrdeMppgSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuGrdeMppgSeilNum"),"0"))); //직종등급맵핑일련번호
        
             payr0445SrhVO.setPyspLogSvcYrNumCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspLogSvcYrNumCd")));    //호봉근속년수코드
                    
             //Get total record count //전체 데이터 갯수를 가지고 온다. 
              if ( pagingValues.executeRecordCount ) { 
                     
                 //Execute query that returns a single value
                 TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                  
                 int iResultCnt = payr0445DAO.selectPayr0445ListTotCnt(payr0445SrhVO);  
               
                 SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                 if (!pagingValues.pageExecute) { 
                     pagingValues.offsetLimit = iResultCnt;       
                 }
                 pagingValues.totalRecordCount = iResultCnt;        
                 
                 logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
             }
         
             TimingInfo millisBeginPayr0445ToPayr5200DataList = SmrmfUtils.startTiming(logger);
         
             /**페이지 카운트 처리를 위한 부분 */ 
             payr0445SrhVO.setPageSize(pagingValues.totalRecordCount);  
             
             //Apply paging
             if (pagingValues.start > 0) {
                 payr0445SrhVO.setFirstIndex(pagingValues.start);
             }
             if (pagingValues.offsetLimit > 0) {
                 payr0445SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
             }

             //Execute query and convert to BaseModel list
             TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
             
             @SuppressWarnings("unchecked")
//             Collection<Map<String, Object>> list 
             List list = payr0445DAO.selectPayr0445List(payr0445SrhVO);
             
             Iterator<Map<String, Object>> iter = list.iterator();
                 
             SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
            
         
             while ( iter.hasNext() ) {
                 Map<String, Object> map = (Map<String, Object>) iter.next();
                 String idValue = map.get("typOccuGrdeMppgSeilNum").toString();
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
             
             SmrmfUtils.endTiming(logger, millisBeginPayr0445ToPayr5200DataList, "getSelectPayr5200ToPayr0445List");
        

         }
         catch (Exception ex) {
             ex.printStackTrace();
             //Return operation exception
             throw MSFServerUtils.getOperationException(method, ex, logger);
         }

         return retval;
     }
     
     
     public PagingLoadResult<BaseModel> getPayr0440ToPayr5200DataList(ServiceParameters serviceParameters) throws MSFException {

         PagingLoadResult<BaseModel> retval = null;
         String method =  CLASS_PAYR0440_PAYR5200_DATA_LIST;
         Payr0440SrhVO   payr0440SrhVO = new Payr0440SrhVO();
         Payr0440VO      payr0440VO = new Payr0440VO();
         List<BaseModel>  bmResult = new ArrayList<BaseModel>();
         
     		// 1. 암호화 객체 생성
//     		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
         
         MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
         try {
        	 
        	 payr0440DAO = (Payr0440DAO)BeanFinder.getBean("Payr0440DAO");
        	 
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
             payr0440SrhVO.setDpobCd(sessionUser.getDpobCd());
             payr0440SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
             
             payr0440SrhVO.setOccuClssPayCmpttnStd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "occuClssPayCmpttnStd")));
           
             payr0440SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
          
             payr0440SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
            // payr0440SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
            // payr0440SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));
             List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
             payr0440SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
             payr0440SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
             
             //Get total record count //전체 데이터 갯수를 가지고 온다. 
              if ( pagingValues.executeRecordCount ) { 
                     
                 //Execute query that returns a single value
                 TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                  
                 int iResultCnt = payr0440DAO.selectPayr0440ToPayr5200ListTotCnt(payr0440SrhVO);  
               
                 SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                 pagingValues.totalRecordCount = iResultCnt;        
                 
                 logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
             }
         
             TimingInfo millisBeginPayr0440ToPayr5200DataList = SmrmfUtils.startTiming(logger);
         
             /**페이지 카운트 처리를 위한 부분 */ 
             payr0440SrhVO.setPageSize(pagingValues.totalRecordCount);  
             
             //Apply paging
             if (pagingValues.start > 0) {
                 payr0440SrhVO.setFirstIndex(pagingValues.start);
             }
             if (pagingValues.offsetLimit > 0) {
                 payr0440SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
             }

             //Execute query and convert to BaseModel list
             TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
             
             @SuppressWarnings("unchecked")
//             Collection<Map<String, Object>> list ??????
             List list = payr0440DAO.selectPayr0440ToPayr5200List(payr0440SrhVO);
             
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
             
             SmrmfUtils.endTiming(logger, millisBeginPayr0440ToPayr5200DataList, "getPayr0440ToPayr5200DataList");
        

         }
         catch (Exception ex) {
             ex.printStackTrace();
             //Return operation exception
             throw MSFServerUtils.getOperationException(method, ex, logger);
         }

         return retval;
     }
	public PagingLoadResult<BaseModel> getPayr0440DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0440_PAYR5200_DATA_LIST;
        Payr0440SrhVO   payr0440SrhVO = new Payr0440SrhVO();
        Payr0440VO      payr0440VO = new Payr0440VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
         
        try {
        	
        	 payr0440DAO = (Payr0440DAO)BeanFinder.getBean("Payr0440DAO");
        	 
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0400BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtisls.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
			   
            payr0440SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0440SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
 
          //  Date dtUcstDgmApptn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z").parse(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "ucstDgmApptnDt")));
           // payr0440SrhVO.setUcstDgmApptnDt(new SimpleDateFormat("yyyyMMdd").format(dtUcstDgmApptn));
          if (MSFSharedUtils.paramNotNull(MSFServerUtils.getFilterValue(columnFilters, "occuClssPayCmpttnStd"))) {
            payr0440SrhVO.setOccuClssPayCmpttnStd(new SimpleDateFormat("yyyyMMdd").format((Date)MSFServerUtils.getFilterValue(columnFilters, "occuClssPayCmpttnStd")));
            
          } else {
              payr0440SrhVO.setOccuClssPayCmpttnStd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "occuClssPayCmpttnStd")));
          }
          
           // payr0440SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
         
            payr0440SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
           // payr0440SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
           // payr0440SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0440SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0440SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
            
            payr0440SrhVO.setPyspLogSvcYrNumCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspLogSvcYrNumCd")));
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0440DAO.selectPayr0440ListTotCnt(payr0440SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0440DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0440SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0440SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0440SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0440DAO.selectPayr0440List(payr0440SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("pyspLogSvcYrNumCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0440DataList, "getPayr0440DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	

	public PagingLoadResult<BaseModel> getCboPayr0440PayYrList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getCboPayr0440PayYrList";
        Payr0440SrhVO   payr0440SrhVO = new Payr0440SrhVO();
        Payr0440VO      payr0440VO = new Payr0440VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
         
        try {
          
        	 payr0440DAO = (Payr0440DAO)BeanFinder.getBean("Payr0440DAO");
        	 
             ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
             IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
             List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
             PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
 	         
        	
            //Get paging configuration
             PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
             payr0440SrhVO.setDpobCd(sessionUser.getDpobCd());
           // sysComSrhVo.setRpsttvCd(sysComBass0300Dto.getRpsttvCd());
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  payr0440DAO.selectPayr0440PayYrListTotCnt(payr0440SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
               logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPayr0440PayYrList = SmrmfUtils.startTiming(logger);
         
          
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0440SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0440SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.totalRecordCount < 100) {
            	payr0440SrhVO.setLastIndex(pagingValues.totalRecordCount); 
            } else  if (pagingValues.offsetLimit > 0) {
            	payr0440SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            } 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//          Collection<Map<String, Object>> list ?????? 
            List list = payr0440DAO.selectPayr0440PayYrList(payr0440SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
            
            String rrnDecCrypt = "";
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payYr").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayr0440PayYrList, "getCboPayr0440PayYrList");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }	
	

	public PagingLoadResult<BaseModel> getCboPayr0440UcstDgmApptnDtList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getCboPayr0440UcstDgmApptnDtList";
        Payr0440SrhVO   payr0440SrhVO = new Payr0440SrhVO();
        Payr0440VO      payr0440VO = new Payr0440VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        // 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
      
        try {
        	
        	 payr0440DAO = (Payr0440DAO)BeanFinder.getBean("Payr0440DAO");
          
             ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
             IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
             List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
             PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
          
            //Get paging configuration
             PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
             payr0440SrhVO.setDpobCd(sessionUser.getDpobCd()); 
             payr0440SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  payr0440DAO.selectPayr0440UcstDgmApptnDtListTotCnt(payr0440SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
               logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPayr0440UcstDgmApptnDtList = SmrmfUtils.startTiming(logger);
         
          
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0440SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0440SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.totalRecordCount < 100) {
            	payr0440SrhVO.setLastIndex(pagingValues.totalRecordCount); 
            } else  if (pagingValues.offsetLimit > 0) {
            	payr0440SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            } 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ?????? 
            List list = payr0440DAO.selectPayr0440UcstDgmApptnDtList(payr0440SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
            
            String rrnDecCrypt = "";
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("occuClssPayCmpttnStd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayr0440UcstDgmApptnDtList, "getCboPayr0440UcstDgmApptnDtList");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }

	@Override
	public Long activityOnPayr5200(Payr0440DTO payr0440Dto,
			ActionDatabase actionDatabase) {
	    Long result = new Long(1);
        try { 
          
            Payr0440VO payr0440Vo = new Payr0440VO(); 
            BeanUtils.copyProperties(payr0440Vo, payr0440Dto);
             

            switch (actionDatabase) {
            case INSERT:
            	payr0440DAO.insertPayr0440(payr0440Vo);
            	 
            	break;
            case UPDATE: 
            	payr0440DAO.updatePayr0440(payr0440Vo); 
            	 
                break;
            case DELETE: 
                payr0440DAO.deletePayr0440(payr0440Vo);
               
                break;
            }
            
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr5200(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnPayr5200", ex, logger);
        }
        finally {
          
        }
        return result;
	}
    @Override
    public Long activityOnPayr0440DetailFormSave(List<Payr0440DTO> listPayr0440dto, ActionDatabase actionDatabase) throws MSFException  {
        Long result = new Long(0);
        Long iCnt = new Long(0);
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        try { 
            
        	 payr0440DAO = (Payr0440DAO)BeanFinder.getBean("Payr0440DAO");
        	 
            Payr0440SrhVO payr0440SrhVo = new Payr0440SrhVO(); 
            
            
            
            for(int iPayrCnt=0;iPayrCnt < listPayr0440dto.size();iPayrCnt++) {
                
                    Payr0440DTO payr0440Dto = new Payr0440DTO();  
                    payr0440Dto = listPayr0440dto.get(iPayrCnt);
                
                    Payr0440VO payr0440Vo = new Payr0440VO();  
                     

                    payr0440Vo.setDpobCd(payr0440Dto.getDpobCd());    												/** column 사업장코드 : dpobCd */
                    payr0440Vo.setPayYr(payr0440Dto.getPayYr());    												/** column 급여년도 : payYr */
                    payr0440Vo.setPyspLogSvcYrNumCd(payr0440Dto.getPyspLogSvcYrNumCd());    						/** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
                    payr0440Vo.setTypOccuGrdeMppgSeilNum(new BigDecimal(payr0440Dto.getTypOccuGrdeMppgSeilNum()));	/** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
                    payr0440Vo.setPayrItemSeilNum(new BigDecimal(payr0440Dto.getPayrItemSeilNum()));    			/** column 급여항목일련번호 : payrItemSeilNum */
                    payr0440Vo.setOccuClssPayCmpttnStd(payr0440Dto.getOccuClssPayCmpttnStd());    					/** column 직종세별급여생성일자 : occuClssPayCmpttnStd */
                    payr0440Vo.setPayrMangDeptCd(payr0440Dto.getPayrMangDeptCd());    								/** column 급여관리부서코드 : payrMangDeptCd */
                    payr0440Vo.setUcstSum(new BigDecimal(payr0440Dto.getUcstSum()));    							/** column 단가금액 : ucstSum */
                    payr0440Vo.setUcstCalcDivCd(payr0440Dto.getUcstCalcDivCd());    								/** column 단가계산구분코드 : ucstCalcDivCd */
                    payr0440Vo.setUcstPrntOrd(new BigDecimal(payr0440Dto.getUcstPrntOrd()));						/** column 단가출력순서 : ucstPrntOrd */
                    payr0440Vo.setUcstDgmBgnnDt(payr0440Dto.getUcstDgmBgnnDt());    								/** column 단가표시작일자 : ucstDgmBgnnDt */
                    payr0440Vo.setUcstDgmEndDt(payr0440Dto.getUcstDgmEndDt());    									/** column 단가표종료일자 : ucstDgmEndDt */
                    payr0440Vo.setUcstDgmUseYn((Boolean.TRUE.equals(payr0440Dto.getUcstDgmUseYn()) ? "Y" : "N") );  /** column 단가표사용여부 : ucstDgmUseYn */
                    payr0440Vo.setUcstNoteCtnt(payr0440Dto.getUcstNoteCtnt());    									/** column 단가비고내용 : ucstNoteCtnt */
                    payr0440Vo.setPayrItemCd(payr0440Dto.getPayrItemCd());    										/** column 지급항목코드 : payrItemCd */
                    
                    payr0440Vo.setKybdr(sessionUser.getUsrId());    												/** column 입력자 : kybdr */
                    payr0440Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 				/** column 입력주소 : inptAddr */
                    payr0440Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
                    payr0440Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */

 
                    switch (actionDatabase) {
                  
                    case UPDATE: 
                        payr0440DAO.updatePayr0440(payr0440Vo); 
                        iCnt = iCnt + 1;
                        break;
                 
                    }
                  
                    
               } 
                result = iCnt;
          
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr0440DetailFormSave(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnPayr0440DetailFormSave", ex, logger);
        }
        finally {
          
        }
        
        return result;
    }


    @Override
    public Long activityOnPayr0445DetailFormSave(List<Payr0445DTO> listPayr0445dto, ActionDatabase actionDatabase) {
        // TODO Auto-generated method stub
        Long result = new Long(0);
        Long iCnt = new Long(0);
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        try { 
            
        	payr0445DAO = (Payr0445DAO)BeanFinder.getBean("Payr0445DAO");
        	 
        	 
            Payr0445SrhVO payr0445SrhVo = new Payr0445SrhVO(); 
            
           
            for(int iPayrCnt=0;iPayrCnt < listPayr0445dto.size();iPayrCnt++) {
                
                    Payr0445DTO payr0445Dto = new Payr0445DTO();  
                    payr0445Dto = listPayr0445dto.get(iPayrCnt);
                
                    Payr0445VO payr0445Vo = new Payr0445VO();    
                    
                    payr0445Vo.setDpobCd(payr0445Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
                    payr0445Vo.setPayYr(payr0445Dto.getPayYr());    /** column 급여년도 : payYr */
                    payr0445Vo.setTypOccuGrdeMppgSeilNum(new BigDecimal(payr0445Dto.getTypOccuGrdeMppgSeilNum()));    /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
                    payr0445Vo.setPyspLogSvcYrNumCd(payr0445Dto.getPyspLogSvcYrNumCd());    /** column 호봉근속년수코드 : pyspLogSvcYrNumCd */
                    payr0445Vo.setPayrItemSeilNum(new BigDecimal(payr0445Dto.getPayrItemSeilNum()));    /** column 급여항목일련번호 : payrItemSeilNum */
                    payr0445Vo.setOccuClssPayCmpttnStd(payr0445Dto.getOccuClssPayCmpttnStd());    /** column 직종세별급여생성일자 : occuClssPayCmpttnStd */
                    payr0445Vo.setMnthUsalyAmntWag(new BigDecimal(payr0445Dto.getMnthUsalyAmntWag()));    /** column 월통상임금액 : mnthUsalyAmntWag */
                    payr0445Vo.setMnthUsalyAmntAllwBnusSum(new BigDecimal(payr0445Dto.getMnthUsalyAmntAllwBnusSum()));    /** column 월통상임금상여금액 : mnthUsalyAmntAllwBnusSum */
                    payr0445Vo.setUsalyAmntPdyQnty(new BigDecimal(payr0445Dto.getUsalyAmntPdyQnty()));    /** column 통상임금일급액 : usalyAmntPdyQnty */
                    payr0445Vo.setUsalyAmntHrwgQnty(new BigDecimal(payr0445Dto.getUsalyAmntHrwgQnty()));    /** column 통상임금시급액 : usalyAmntHrwgQnty */
                    payr0445Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
                    payr0445Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
                    payr0445Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
                    payr0445Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */

 
 
                    switch (actionDatabase) {
                  
                    case UPDATE: 
                        payr0445DAO.updatePayr0445(payr0445Vo); 
                        iCnt = iCnt + 1;
                        break;
                 
                    }
                  
                    
               } 
                result = iCnt;
          
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr0445DetailFormSave(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnPayr0445DetailFormSave", ex, logger);
        }
        finally {
          
        }
        
        return result;
    }
 
		 
}
