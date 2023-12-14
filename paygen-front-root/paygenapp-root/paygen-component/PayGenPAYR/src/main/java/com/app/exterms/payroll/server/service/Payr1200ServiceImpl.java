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

import com.app.exterms.payroll.client.dto.Payr0400DTO;
import com.app.exterms.payroll.client.service.Payr1200Service;
import com.app.exterms.payroll.server.service.dao.Payr0400DAO;
import com.app.exterms.payroll.server.service.dao.Payr0430DAO;
import com.app.exterms.payroll.server.service.dao.Payr0440DAO;
import com.app.exterms.payroll.server.vo.Payr0400SrhVO;
import com.app.exterms.payroll.server.vo.Payr0400VO;
import com.app.exterms.payroll.server.vo.Payr0430SrhVO;
import com.app.exterms.payroll.server.vo.Payr0430VO;
import com.app.exterms.payroll.server.vo.Payr0440SrhVO;
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
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0400VO;
import com.app.smrmf.pkg.listener.PayrListenerAdapter;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
@Service("Payr1200Service")
public class Payr1200ServiceImpl extends AbstractCustomServiceImpl implements Payr1200Service ,PayrDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Payr1200ServiceImpl.class);
	private static final String calledClass = Payr1200ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="Payr0400DAO")
    private Payr0400DAO payr0400DAO;
    
	@Autowired
    @Resource(name="Payr0430DAO")
    private Payr0430DAO payr0430DAO;
    
	  
    @Autowired
    @Resource(name="Payr0440DAO")
    private Payr0440DAO payr0440DAO;
    

    /** ID Generation */
    //@Resource(name="{egovPayr0400IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
	
	public PagingLoadResult<BaseModel> getPayr0400DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0400_DATA_LIST;
        Payr0400SrhVO   payr0400SrhVO = new Payr0400SrhVO();
        Payr0400VO      payr0400VO = new Payr0400VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        
//    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(payr0400DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	payr0400DAO = (Payr0400DAO) wac.getBean("Payr0400DAO" ); 
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
            payr0400SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0400SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
           // payr0400SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0400SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0400SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0400DAO.selectPayr0400ListTotCnt(payr0400SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;
   
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0400DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0400SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0400SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0400SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0400DAO.selectPayr0400List(payr0400SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0400DataList, "getPayr0400DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	
	public PagingLoadResult<BaseModel> getPayr0430DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0430_DATA_LIST;
        Payr0430SrhVO   payr0430SrhVO = new Payr0430SrhVO();
        Payr0430VO      payr0430VO = new Payr0430VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        

//    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(payr0430DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	payr0430DAO = (Payr0430DAO) wac.getBean("Payr0430DAO" ); 
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
            payr0430SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0430SrhVO.setTypOccuGrdeMppgSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuGrdeMppgSeilNum"),"0")));
            payr0430SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
          //  payr0430SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
            payr0430SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0430DAO.selectPayr0430ListTotCnt(payr0430SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0430DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            //payr0430SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0430SrhVO.setFirstIndex(pagingValues.start);
            }
            
            if (pagingValues.offsetLimit > 0) {
            	payr0430SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));   
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0430DAO.selectPayr0430List(payr0430SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("pyspLogSvcYrNumCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0430DataList, "getPayr0430DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	
	
	
	  

    @Override
    public Long activityOnPayr0400Insert(List<BaseModel> listModels, ActionDatabase actionDatabase)  throws MSFException {
        // TODO Auto-generated method stub
        Long result = new Long(1);
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
            
            if  (MSFSharedUtils.paramNull(payr0400DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                payr0400DAO = (Payr0400DAO) wac.getBean("Payr0400DAO" ); 
            }
             
            
        	// 1. 암호화 객체 생성
//        	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
  
            
          Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)listModels.iterator();
          
          while (iterRecords.hasNext()) {
              try { 
                  
                      BaseModel bmMapModel = (BaseModel) iterRecords.next();
                       
                      Payr0400VO payr0400Vo = new Payr0400VO();
                      
                      payr0400Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));
                      payr0400Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd"))) ;
                      payr0400Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuClsDivCd"))+MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd"))) ;
                      //payr0400Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd"))); 
 
                      payr0400Vo.setTypOccuGrdeMppgCtnt(""); 
                      payr0400Vo.setTypOccuGrdeMppgDelYn("N");  
                      
                      payr0400Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
                      payr0400Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
                      payr0400Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
                      payr0400Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
                       
                   
                      switch (actionDatabase) {
                      case INSERT:
                    	  
//                    	  if(0 < payr0400DAO.selectPayr0400CheckCnt(payr0400Vo)){
//                    		  logger.debug("dtilOccuInttnCd 중복");
//                    	  }else{
                 		    payr0400DAO.insertPayr0400(payr0400Vo); 
//                    	  }
                          
                          break; 
                      }
              } catch (Exception ex) {
                  
                  result = new Long(0);
                  throw MSFServerUtils.getOperationException("activityOnPayr0400Insert()", ex, logger);
                 
              }
              finally {
                
              }
          } 
        
        return result;
    }


    @Override
    public Long activityOnPayr0400Save(Payr0400DTO payr0400Dto, ActionDatabase actionDatabase)  throws MSFException {
        // TODO Auto-generated method stub
        Long result = new Long(1);
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(payr0440DAO)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            payr0440DAO = (Payr0440DAO) wac.getBean("Payr0440DAO" ); 
        }
        
        if  (MSFSharedUtils.paramNull(payr0430DAO)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            payr0430DAO = (Payr0430DAO) wac.getBean("Payr0430DAO" ); 
        }
        
        try { 
          
            Payr0400VO payr0400Vo = new Payr0400VO(); 
            Payr0430VO payr0430Vo = new Payr0430VO(); 
            Payr0440SrhVO payr0440SrhVo = new Payr0440SrhVO();
            
            BeanUtils.copyProperties(payr0400Vo, payr0400Dto);
          
            payr0440SrhVo.setDpobCd(payr0400Dto.getDpobCd());
            payr0440SrhVo.setTypOccuGrdeMppgSeilNum(new BigDecimal(payr0400Dto.getTypOccuGrdeMppgSeilNum()));
            int iPayr0440Cnt = payr0440DAO.selectPayr0440ListTotCnt(payr0440SrhVo);
            
            
            switch (actionDatabase) {
            case INSERT:
               break;
            case UPDATE: 
            	
            	payr0400Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
            	payr0400Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
            	payr0400Vo.setIsmt(sessionUser.getUsrId());    											/** column 수정자 : ismt */
            	payr0400Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 수정주소 : revnAddr */
                    
                payr0400DAO.updatePayr0400(payr0400Vo);  
                break;
            case DELETE: 
                if (iPayr0440Cnt > 0)  {
                    payr0400DAO.deletePayr0400Flag(payr0400Vo);  
                } else {                    

                    payr0430Vo.setDpobCd(payr0400Dto.getDpobCd());
                    payr0430Vo.setTypOccuGrdeMppgSeilNum(new BigDecimal(payr0400Dto.getTypOccuGrdeMppgSeilNum()));
                    payr0430Vo.setPyspLogSvcYrNumCd("");
                    payr0430Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */
                    payr0430Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 	/** column 입력주소 : inptAddr */
                    payr0430Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
                    payr0430Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 수정주소 : revnAddr */
                     
                    
                    Long iChk = deleteOnPayr0430(payr0430Vo,actionDatabase.DELETE); 
                    
                    if (iChk > 0 ){
                        payr0400DAO.deletePayr0400(payr0400Vo);  
                    }
                } 
             
                break;
            }
            
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr0400Save(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnPayr0400Save()", ex, logger);
        }
        finally {
          
        }
        return result;
    }
    
    
   
    private Long deleteOnPayr0430(Payr0430VO payr0430Vo, ActionDatabase actionDatabase) throws MSFException  {
        // TODO Auto-generated method stub
        Long result = new Long(1);
        try { 
           
            switch (actionDatabase) {
            case INSERT:
               break;
            case UPDATE: 
                break;
            case DELETE: 
                payr0430DAO.deletePayr0430(payr0430Vo);
                break;
            }
            
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr0400Save(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("deleteOnPayr0430()", ex, logger);
        }
        finally {
          
        }
        return result;
    }

    
    @Override
    public Long createPyspLogSvcYrNumCd(Payr0400DTO payr0400Dto) {
        // TODO Auto-generated method stub
        Long result = new Long(1);
        try { 
          
            InfcPkgPayr0400VO payr0400Vo = new InfcPkgPayr0400VO();
            Payr0430VO payr0430Vo = new Payr0430VO();
            
            BeanUtils.copyProperties(payr0430Vo, payr0400Dto); 
            BeanUtils.copyProperties(payr0400Vo, payr0400Dto); 
            //근속년수 맵핑 처리를 하는 메서드 호출 
            result = deleteOnPayr0430(payr0430Vo,ActionDatabase.DELETE);
            
            if (result > 0) {
                PayrListenerAdapter payrAdapter = new PayrListenerAdapter(); 
                result = (long) payrAdapter.createPyspLogSvcYrNumCd(RemoteServiceUtil.getThreadLocalRequest(),payr0400Vo);
            } 
            
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling createPyspLogSvcYrMumCd(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("createPyspLogSvcYrNumCd()", ex, logger);
        }
        finally {
          
        }
        return result;
    }


    @Override
    public Long deletePayr0430(List<BaseModel> listModels)  throws MSFException {
        // TODO Auto-generated method stub
        Long result = new Long(1);
        try { 
            
            if  (MSFSharedUtils.paramNull(payr0430DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                payr0430DAO = (Payr0430DAO) wac.getBean("Payr0430DAO" ); 
            }
            
          
            
          Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)listModels.iterator();
          while (iterRecords.hasNext()) {
            
              BaseModel bmMapModel = (BaseModel) iterRecords.next();
               
              Payr0430VO payr0430Vo = new Payr0430VO();
              
              payr0430Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));
              payr0430Vo.setTypOccuGrdeMppgSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(bmMapModel.get("typOccuGrdeMppgSeilNum"),"0")));
              payr0430Vo.setPyspLogSvcYrNumCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspLogSvcYrNumCd")) );
             // payr0430Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd"))) ;
             // payr0430Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd"))) ;
             // payr0430Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));  
              
              payr0430DAO.deletePayr0430(payr0430Vo); 
               
              result = result + 1;
              
          } 
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling deletePayr0430(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("deletePayr0430()", ex, logger);
        }
        finally {
          
        }
        return result;
    }
}
