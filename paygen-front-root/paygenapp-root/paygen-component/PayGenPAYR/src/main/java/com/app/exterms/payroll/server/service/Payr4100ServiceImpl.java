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
import com.app.exterms.payroll.client.dto.Payr0500DTO;
import com.app.exterms.payroll.client.dto.Payr0520DTO;
import com.app.exterms.payroll.client.dto.Payr0530DTO;
import com.app.exterms.payroll.client.dto.Payr0540DTO;
import com.app.exterms.payroll.client.service.Payr4100Service;
import com.app.exterms.payroll.server.service.dao.Payr0200DAO;
import com.app.exterms.payroll.server.service.dao.Payr0220DAO;
import com.app.exterms.payroll.server.service.dao.Payr0450DAO;
import com.app.exterms.payroll.server.service.dao.Payr0500DAO;
import com.app.exterms.payroll.server.service.dao.Payr0520DAO;
import com.app.exterms.payroll.server.service.dao.Payr0530DAO;
import com.app.exterms.payroll.server.service.dao.Payr0540DAO;
import com.app.exterms.payroll.server.utils.PayrServerUtils;
import com.app.exterms.payroll.server.vo.Payr0220SrhVO;
import com.app.exterms.payroll.server.vo.Payr0220VO;
import com.app.exterms.payroll.server.vo.Payr0450VO;
import com.app.exterms.payroll.server.vo.Payr0500SrhVO;
import com.app.exterms.payroll.server.vo.Payr0500VO;
import com.app.exterms.payroll.server.vo.Payr0520SrhVO;
import com.app.exterms.payroll.server.vo.Payr0520VO;
import com.app.exterms.payroll.server.vo.Payr0530SrhVO;
import com.app.exterms.payroll.server.vo.Payr0530VO;
import com.app.exterms.payroll.server.vo.Payr0540SrhVO;
import com.app.exterms.payroll.server.vo.Payr0540VO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.exterms.prgm.server.service.dao.PrgmComPsnl0100DAO;
import com.app.exterms.retirement.shared.InfcPkgRemtDaoConstants;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.personal.server.service.dao.InfcPkgPsnl0100DAO;
import com.app.smrmf.infc.personal.server.service.dao.InfcPkgPsnl0123DAO;
import com.app.smrmf.infc.personal.server.service.dao.InfcPkgPsnl0127DAO;
import com.app.smrmf.infc.personal.server.service.dao.InfcPkgPsnl0130DAO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0100VO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0123SrhVO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0123VO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0127VO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0130SrhVO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0130VO;
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt3500DAO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3500SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3500VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Payr4100Service")
public class Payr4100ServiceImpl extends AbstractCustomServiceImpl implements Payr4100Service , PayrDaoConstants , InfcPkgRemtDaoConstants{ 

	private static final Logger logger = LoggerFactory.getLogger(Payr4100ServiceImpl.class);
	private static final String calledClass = Payr4100ServiceImpl.class.getName();
	

	 @Autowired
	 @Resource(name="Payr0450DAO")
	 private Payr0450DAO payr0450DAO;
	 
	@Autowired
    @Resource(name="PrgmComPsnl0100DAO")
    private PrgmComPsnl0100DAO psnl0100DAO;
	
	@Autowired
    @Resource(name="InfcPkgPsnl0100DAO")
    private InfcPkgPsnl0100DAO psnlUp0100DAO;
 
    @Resource(name="InfcPkgPsnl0127DAO")
    private InfcPkgPsnl0127DAO psnl0127DAO;
    
	@Autowired
    @Resource(name="Payr0500DAO")
    private Payr0500DAO payr0500DAO;
	
	@Autowired
    @Resource(name="Payr0520DAO")
    private Payr0520DAO payr0520DAO;
	

	@Autowired
    @Resource(name="Payr0200DAO")
    private Payr0200DAO payr0200DAO;
	
	@Autowired
    @Resource(name="Payr0530DAO")
    private Payr0530DAO payr0530DAO;
	
	@Autowired
    @Resource(name="Payr0540DAO")
    private Payr0540DAO payr0540DAO;
	
	@Resource(name="InfcPkgPsnl0123DAO")
    private InfcPkgPsnl0123DAO psnl0123DAO;
	
    @Resource(name="InfcPkgPsnl0130DAO")
    private InfcPkgPsnl0130DAO psnl0130DAO;
    
    @Autowired
    @Resource(name="Payr0220DAO")
    private Payr0220DAO payr0220DAO;
    
    @Autowired 
    @Resource(name="InfcPkgRemt3500DAO")
    private InfcPkgRemt3500DAO remt3500DAO;
    
    
    /** ID Generation */
    //@Resource(name="{egovPayr0500IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	
	//기본상세정보 
	
	public PagingLoadResult<BaseModel> getPayr0500DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0530_DATA_LIST;
        Payr0500SrhVO   payr0500SrhVO = new Payr0500SrhVO();
        Payr0500VO      payr0500VO = new Payr0500VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
     
        try {
        	
        	   payr0500DAO = (Payr0500DAO)BeanFinder.getBean("Payr0500DAO");
        	   
        	   
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0530BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            /** 조건절 */
            payr0500SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            payr0500SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"))) ;   //systemkey
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0500DAO.selectPayr0500ListTotCnt(payr0500SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBegingetPayr0500DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0500SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                payr0500SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                payr0500SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0500DAO.selectPayr0500List(payr0500SrhVO);
            
            Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("systemkey").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBegingetPayr0500DataList, "getPayr0500DataList");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	//가족사항
	public PagingLoadResult<BaseModel> getPayr0530DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0530_DATA_LIST;
        Payr0530SrhVO   payr0530SrhVO = new Payr0530SrhVO();
        Payr0530VO      payr0530VO = new Payr0530VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        payr0530DAO = (Payr0530DAO)BeanFinder.getBean("Payr0530DAO");
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0530BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
            payr0530SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            payr0530SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"))) ;   //systemkey
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0530DAO.selectPayr0530ListTotCnt(payr0530SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0530DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0530SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0530SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0530SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0530DAO.selectPayr0530List(payr0530SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payFamyRsptSeilNum").toString();
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
                         
                         
                     //3. 복호화
                 	case ColumnDef.TYPE_STRING: 
                 	          			          			
                 		String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
                    			
                 		if(	"payFamyResnRegnNum".equals(tableAttributes[i].getName())) {
                 	          			
                 			String rrnDecCrypt = "";
                 	          			
                 			// 급여가족주민번호(복호화)
                 			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                 	          		
                 			strValue = rrnDecCrypt;
                 						
                 		}
                  	                       
                 	map.put(tableAttributes[i].getName(), strValue);
                 		                    
                 	break;
                    }
                     /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
                    Object baseModelValue = null;
                    //콤보박스처리를 위해 추가함
                    if (tableAttributes[i].getName().contains("$")) {
                         String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
                         
                         //길이가 긴데이타가 있어 어쩔수 없이 루틴 추가 schlExpnAdmclExtpyDivCdcommCdNm
                         if (strMapCon.equals("schlexpnadmclextpydivcdcommcdnm")) {
                             
                             strMapCon = "schlexpnadmcldivcdcommcdnm";
                             
                         } else if (strMapCon.equals("schlexpnadmclextpydivcdcommcd")) {
                             strMapCon = "schlexpnadmcldivcdcommcd";
                         }
                              
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0530DataList, "getPayr0530DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	//수당
	 public PagingLoadResult<BaseModel> getPayr0520DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_PAYR0520_DATA_LIST;
	        Payr0520SrhVO   payr0520SrhVO = new Payr0520SrhVO();
	        Payr0520VO      payr0520VO = new Payr0520VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	    	// 1. 암호화 객체 생성
//	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	      
	        payr0520DAO = (Payr0520DAO)BeanFinder.getBean("Payr0520DAO");
	        
	        try {
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	           // Sysm0520BM          user             = serviceParameters.getUser();
	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

	            //Get paging configuration
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	            //Get query parameters
	            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	           
	            /** 조건절 */
	            payr0520SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            payr0520SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"))) ;   //systemkey
	            
	            List<String> lstPymtDducDivCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd"))); 
	            payr0520SrhVO.setPymtDducDivCdArr(lstPymtDducDivCd); 
	              
	            payr0520SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd"))) ;   //지급공제구분코드 
	            payr0520SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducItemBgnnDt"))) ;   //수당공제년도 
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = payr0520DAO.selectPayr0520ListTotCnt(payr0520SrhVO);  
	              
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginPayr0520DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            payr0520SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	payr0520SrhVO.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	payr0520SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = payr0520DAO.selectPayr0520List(payr0520SrhVO);
	            
		        Iterator<Map<String, Object>> iter = list.iterator();
		            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
	            while ( iter.hasNext() ) {
	            	
	            	// 1. 암호화 객체 생성
	            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("systemkey").toString();
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginPayr0520DataList, "getPayr0520DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }
	  
//	//공제 
//	 public PagingLoadResult<BaseModel> getPayr0200ToPayr4100DataList(ServiceParameters serviceParameters) throws MSFException {
//
//	        PagingLoadResult<BaseModel> retval = null;
//	        String method =  CLASS_PAYR0200_PAYR4100_DATA_LIST;
//	        Payr0200SrhVO   payr0200SrhVO = new Payr0200SrhVO();
//	        Payr0200VO      payr0200VO = new Payr0200VO();
//	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
//	        
//	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//	        
//	        if  (MSFSharedUtils.paramNull(payr0200DAO)) {
//	        
//	        	WebApplicationContext wac = WebApplicationContextUtils.
//	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//	        	payr0200DAO = (Payr0200DAO) wac.getBean("Payr0200DAO" ); 
//	        }
//	        
//	        try {
//	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
//	           // Sysm0200BM          user             = serviceParameters.getUser();
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
//	            payr0200SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//	            payr0200SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"))) ;   //systemkey
//	            
//	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
//		         if ( pagingValues.executeRecordCount ) { 
//		            	
//	                //Execute query that returns a single value
//	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//	                 
//	                int iResultCnt = payr0200DAO.selectPayr0200ToPayr4100ListTotCnt(payr0200SrhVO);  
//	              
//	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
//	                pagingValues.totalRecordCount = iResultCnt;	       
//	                
//	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//	            }
//	        
//	            TimingInfo millisBeginPayr0200ToPayr4100DataList = SmrmfUtils.startTiming(logger);
//	        
//	            /**페이지 카운트 처리를 위한 부분 */ 
//	            payr0200SrhVO.setPageSize(pagingValues.totalRecordCount);  
//	            
//	            //Apply paging
//	            if (pagingValues.start > 0) {
//	            	payr0200SrhVO.setFirstIndex(pagingValues.start);
//	            }
//	            if (pagingValues.offsetLimit > 0) {
//	            	payr0200SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
//	            }
//
//	            //Execute query and convert to BaseModel list
//	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//	            
//	            @SuppressWarnings("unchecked")
////	            Collection<Map<String, Object>> list ??????
//	            List list = payr0200DAO.selectPayr0200ToPayr4100List(payr0200SrhVO);
//	            
//		        Iterator<Map<String, Object>> iter = list.iterator();
//		            
//	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
//	           
//	        
//	            while ( iter.hasNext() ) {
//	                Map<String, Object> map = (Map<String, Object>) iter.next();
//	                String idValue = map.get("payScduSeilNum").toString();
//	                BaseModel bm = new BaseModel();
//	 
//	                //bm.setProperties(map);
//	                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
//	                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
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
//	            SmrmfUtils.endTiming(logger, millisBeginPayr0200ToPayr4100DataList, "getPayr0200ToPayr4100DataList");
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
	 
	//계좌정보 
	public PagingLoadResult<BaseModel> getSelectPayr0130ToPayr4100List(ServiceParameters serviceParameters) throws MSFException {
		  PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_PAYR4100_DAO_LIST;
	        InfcPkgPsnl0130SrhVO   psnl0130SrhVo = new InfcPkgPsnl0130SrhVO();
	        InfcPkgPsnl0130VO      psnl0130Vo = new InfcPkgPsnl0130VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	    	// 1. 암호화 객체 생성
//	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
	        try {
	        	

		        psnl0130DAO = (InfcPkgPsnl0130DAO)BeanFinder.getBean("InfcPkgPsnl0130DAO");
		        
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
	            psnl0130SrhVo.setDpobCd(sessionUser.getDpobCd());
	            psnl0130SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));
	          
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = psnl0130DAO.selectPsnl0130ListTotCnt(psnl0130SrhVo);  
	              
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginPsnl0130DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            psnl0130SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	psnl0130SrhVo.setFirstIndex(pagingValues.start);
	            }
	            
	            if (pagingValues.offsetLimit > 0) {
	            	psnl0130SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = psnl0130DAO.selectPsnl0130List(psnl0130SrhVo);
	            
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginPsnl0130DataList, "getPsnl0130DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
  }

	//채권압류  

	public PagingLoadResult<BaseModel> getPayr0220ToPayr4100DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0220_PAYR4100_DATA_LIST;
        Payr0220SrhVO   payr0220SrhVO = new Payr0220SrhVO();
        Payr0220VO      payr0220VO = new Payr0220VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
         
        try { 

        	payr0220DAO = (Payr0220DAO)BeanFinder.getBean("Payr0220DAO");
	        
	        
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0220BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
          
            payr0220SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드 
            payr0220SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
             
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0220DAO.selectPayr0220ToPayr4100ListTotCnt(payr0220SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0220ToPayr4100DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0220SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0220SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0220SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0220DAO.selectPayr0220ToPayr4100List(payr0220SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("systemkey").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0220ToPayr4100DataList, "getPayr0220ToPayr4100DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }	
	
	//퇴직정산  
	   public PagingLoadResult<BaseModel> getSelectPayr4100ToRemt3500List(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  "com.app.exterms.payroll.server.service.Payr4100ServiceImpl.getSelectPayr4100ToRemt3500List";
	        InfcPkgRemt3500SrhVO   remt3500SrhVo = new InfcPkgRemt3500SrhVO();
	        InfcPkgRemt3500VO      remt3500Vo = new InfcPkgRemt3500VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	    	// 1. 암호화 객체 생성
//	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	       
	        
	        try {
	        	
	        	remt3500DAO = (InfcPkgRemt3500DAO)BeanFinder.getBean("InfcPkgRemt3500DAO");
	        	
	        	
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
	            remt3500SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드 
	            remt3500SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키 
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	             if ( pagingValues.executeRecordCount ) { 
	                    
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = remt3500DAO.selectPayr4100ToRemt3500ListTotCnt(remt3500SrhVo);  
	              
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;        
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginPayr4100ToRemt3500DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            remt3500SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	                remt3500SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	                remt3500SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list  
	            List list = remt3500DAO.selectPayr4100ToRemt3500List(remt3500SrhVo);
	            
	            Iterator<Map<String, Object>> iter = list.iterator();
	                
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
	            while ( iter.hasNext() ) {
	            	
	            	// 1. 암호화 객체 생성
	            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	            	
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("systemkey").toString();
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginPayr4100ToRemt3500DataList, "getSelectPayr4100ToRemt3500List");
	       

	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    } 
	
	   
		  //휴직정보
		public PagingLoadResult<BaseModel> getSelectPsnl0123ToPayr4100List(ServiceParameters serviceParameters) throws MSFException {
			  
			    PagingLoadResult<BaseModel> retval = null;
		        String method =  CLASS_PSNL0123_PAYR4100_DAO_LIST;
		        InfcPkgPsnl0123SrhVO   psnl0123SrhVo = new InfcPkgPsnl0123SrhVO();
		        InfcPkgPsnl0123VO      psnl0123Vo = new InfcPkgPsnl0123VO();
		        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		        
		    	// 1. 암호화 객체 생성
//		    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		        
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		       
		        try {
		        	
		        	psnl0123DAO = (InfcPkgPsnl0123DAO)BeanFinder.getBean("InfcPkgPsnl0123DAO");
		        	
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
		            psnl0123SrhVo.setDpobCd(sessionUser.getDpobCd());
		            psnl0123SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));
		          
		            //Get total record count //전체 데이터 갯수를 가지고 온다. 
			         if ( pagingValues.executeRecordCount ) { 
			            	
		                //Execute query that returns a single value
		                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		                int iResultCnt = psnl0123DAO.selectPsnl0123ToPayr4100ListTotCnt(psnl0123SrhVo);  
		              
		                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
		                pagingValues.totalRecordCount = iResultCnt;	       
		                
		                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
		            }
		        
		            TimingInfo millisBeginPsnl0123ToPayr4100DataList = SmrmfUtils.startTiming(logger);
		        
		            /**페이지 카운트 처리를 위한 부분 */ 
		            psnl0123SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		            //Apply paging
		            if (pagingValues.start > 0) {
		            	psnl0123SrhVo.setFirstIndex(pagingValues.start);
		            }
		            
		            if (pagingValues.offsetLimit > 0) {
		            	psnl0123SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
		            }

		            //Execute query and convert to BaseModel list
		            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
		            
		            @SuppressWarnings("unchecked")
//			            Collection<Map<String, Object>> list ??????
		            List list = psnl0123DAO.selectPsnl0123ToPayr4100List(psnl0123SrhVo);
		            
			        Iterator<Map<String, Object>> iter = list.iterator();
			            
		            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
		            while ( iter.hasNext() ) {
		            	
		            	// 1. 암호화 객체 생성
		            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		            	
		                Map<String, Object> map = (Map<String, Object>) iter.next();
		                String idValue = map.get("levfAbncSeilNum").toString();
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
		            
		            SmrmfUtils.endTiming(logger, millisBeginPsnl0123ToPayr4100DataList, "getPsnl0123ToPayr4100DataList");
		       

		        }
		        catch (Exception ex) {
		        	ex.printStackTrace();
		            //Return operation exception
		            throw MSFServerUtils.getOperationException(method, ex, logger);
		        }

		        return retval;
	  }
		
		 //예외 
	  	 public PagingLoadResult<BaseModel> getPayr0540DataList(ServiceParameters serviceParameters) throws MSFException {

	  	        PagingLoadResult<BaseModel> retval = null;
	  	        String method =  CLASS_PAYR0540_DATA_LIST;
	  	        Payr0540SrhVO   payr0540SrhVO = new Payr0540SrhVO();
	  	        Payr0540VO      payr0540VO = new Payr0540VO();
	  	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	  	        
	  	        
	  	        // 1. 암호화 객체 생성
//	  	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	  	        
	  	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	  	        
	  	     
	  	        try {
	  	        	
	  	        	payr0540DAO = (Payr0540DAO)BeanFinder.getBean("Payr0540DAO");
	  	        	
	  	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	  	           // Sysm0540BM          user             = serviceParameters.getUser();
	  	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	  	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	  	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	  	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

	  	            //Get paging configuration
	  	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	  	            //Get query parameters
	  	            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	  	           
	  	            /** 조건절 */
	  	            payr0540SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	  	            payr0540SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"))) ;   //systemkey
	  	            
	  	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	  		         if ( pagingValues.executeRecordCount ) { 
	  		            	
	  	                //Execute query that returns a single value
	  	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	  	                 
	  	                int iResultCnt = payr0540DAO.selectPayr0540ListTotCnt(payr0540SrhVO);  
	  	              
	  	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	  	                pagingValues.totalRecordCount = iResultCnt;	       
	  	                
	  	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	  	            }
	  	        
	  	            TimingInfo millisBeginPayr0540DataList = SmrmfUtils.startTiming(logger);
	  	        
	  	            /**페이지 카운트 처리를 위한 부분 */ 
	  	            payr0540SrhVO.setPageSize(pagingValues.totalRecordCount);  
	  	            
	  	            //Apply paging
	  	            if (pagingValues.start > 0) {
	  	            	payr0540SrhVO.setFirstIndex(pagingValues.start);
	  	            }
	  	            if (pagingValues.offsetLimit > 0) {
	  	            	payr0540SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	  	            }

	  	            //Execute query and convert to BaseModel list
	  	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	  	            
	  	            @SuppressWarnings("unchecked")
//	  	            Collection<Map<String, Object>> list ??????
	  	            List list = payr0540DAO.selectPayr0540List(payr0540SrhVO);
	  	            
	  		        Iterator<Map<String, Object>> iter = list.iterator();
	  		            
	  	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	  	           
	  	        
	  	            while ( iter.hasNext() ) {
	  	            	
	  	            	// 1. 암호화 객체 생성
	  	            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	  	          	
	  	                Map<String, Object> map = (Map<String, Object>) iter.next();
	  	                String idValue = map.get("exptnPrcsSeilNum").toString();
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
	  	                
//	  	                    switch ( tableAttributes[i].getType() ) {  
//	  	                    case ColumnDef.TYPE_BIGDECIMAL: 
//	  	                    	if (baseModelValue == null) {
//	  	                    		baseModelValue = BigDecimal.ZERO;
//	  	                    	}
//	  	                        break; 
//	  	                    }
	  	                    
	  	                    bm.set(tableAttributes[i].getName(), baseModelValue);
	  	                }

	  	                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
	  	                bmResult.add(bm);
	  	            } 

	  	            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
	  	            
	  	            SmrmfUtils.endTiming(logger, millisBeginPayr0540DataList, "getPayr0540DataList");
	  	       

	  	        }
	  	        catch (Exception ex) {
	  	        	ex.printStackTrace();
	  	            //Return operation exception
	  	            throw MSFServerUtils.getOperationException(method, ex, logger);
	  	        }

	  	        return retval;
	  	    }
	  	 
	  	@Override
		 public Long activityOnPayr0530(List<Payr0530DTO> listPayr0530dto, ActionDatabase actionDatabase)  throws MSFException {
			
			String method = calledClass + ".activityOnPayr0530";
			MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			
			String windowNm = "급여대상자관리";
			String windowId = "PAYR4100";
			
			// 1. 암호화 객체 생성
//			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			  Long result = new Long(1);
			  Long iCnt = new Long(0);
		        try { 
		        
		        	   payr0530DAO = (Payr0530DAO)BeanFinder.getBean("Payr0530DAO");
		        	
		                Payr0500VO  payr0500Vo = new Payr0500VO();   
		                Payr0530VO  payr0530Vo = new Payr0530VO();
		                
		                for(int iPayrCnt=0;iPayrCnt < listPayr0530dto.size();iPayrCnt++) {
		                	
		                	// 1. 암호화 객체 생성
		                	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		                	
		                    
		                        Payr0530DTO payr0530Dto = new Payr0530DTO();  
		                        payr0530Dto = listPayr0530dto.get(iPayrCnt);   
           		        	
           		        	Payr0530VO  tpPayr0530Vo = new Payr0530VO();
           		        	
                               //TODO 가족수당,학비보조수당적용처리 추가 ..
                               payr0530Vo.setDpobCd(payr0530Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
                               payr0530Vo.setSystemkey(payr0530Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
                               payr0530Vo.setPayFamyRsptSeilNum(new BigDecimal(payr0530Dto.getPayFamyRsptSeilNum()));    /** column 급여가족사항일련번호 : payFamyRsptSeilNum */
//                               payr0530Vo.setPayFamyResnRegnNum(payr0530Dto.getPayFamyResnRegnNum());    /** column 급여가족주민번호 : payFamyResnRegnNum */
                               
                           	// 2. 파라미터 보낼 때(암호화)
                               payr0530Vo.setPayFamyResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(payr0530Dto.getPayFamyResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
                               
                               
                               payr0530Vo.setHanNm(payr0530Dto.getHanNm());    /** column 한글성명 : hanNm */
                               payr0530Vo.setFamyRelaDivCd(payr0530Dto.getFamyRelaDivCd());    /** column 가족관계구분코드 : famyRelaDivCd */
                               payr0530Vo.setFamyAllwPymtYn((Boolean.TRUE.equals(payr0530Dto.getFamyAllwPymtYn()) ? "Y" : "N"));    /** column 가족수당지급여부 : famyAllwPymtYn */
                               payr0530Vo.setChdnChdRrgEpnsPymtYn((Boolean.TRUE.equals(payr0530Dto.getChdnChdRrgEpnsPymtYn()) ? "Y" : "N"));    /** column 자녀양육비지급여부 : chdnChdRrgEpnsPymtYn */
                               payr0530Vo.setFndtnDducYn((Boolean.TRUE.equals(payr0530Dto.getFndtnDducYn()) ? "Y" : "N"));    /** column 기본공제여부 : fndtnDducYn */
                               payr0530Vo.setSpueDducYn((Boolean.TRUE.equals(payr0530Dto.getSpueDducYn()) ? "Y" : "N"));    /** column 배우자공제여부 : spueDducYn */
                               payr0530Vo.setWmnDducYn((Boolean.TRUE.equals(payr0530Dto.getWmnDducYn()) ? "Y" : "N"));    /** column 부녀자공제여부 : wmnDducYn */
                               payr0530Vo.setRftaGvstDducYn((Boolean.TRUE.equals(payr0530Dto.getRftaGvstDducYn()) ? "Y" : "N"));    /** column 경로우대공제여부 : rftaGvstDducYn */
                               payr0530Vo.setDabpnDducYn((Boolean.TRUE.equals(payr0530Dto.getDabpnDducYn()) ? "Y" : "N"));    /** column 장애자공제여부 : dabpnDducYn */
                               payr0530Vo.setSgpnFmlyDducYn((Boolean.TRUE.equals(payr0530Dto.getSgpnFmlyDducYn()) ? "Y" : "N"));    /** column 한가족공제여부 : sgpnFmlyDducYn */
                               payr0530Vo.setChdnChdRrgEpnsDducYn((Boolean.TRUE.equals(payr0530Dto.getChdnChdRrgEpnsDducYn()) ? "Y" : "N"));    /** column 자녀양육비공제여부 : chdnChdRrgEpnsDducYn */
                               payr0530Vo.setFamyExtpyDivCd(payr0530Dto.getFamyExtpyDivCd());    /** column 가족수당구분코드 : famyExtpyDivCd */
                               payr0530Vo.setSchlExpnAdmclExtpyDivCd(payr0530Dto.getSchlExpnAdmclExtpyDivCd());    /** column 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
                               payr0530Vo.setSchlExpnAdmclExtpySum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530Dto.getSchlExpnAdmclExtpySum(),"0")));    /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
                               // 2019 용인개발 자녀나이 20세 초과자 수당등록 막기, A0190005 - 자녀,둘째자녀,세째자녀_장애인자녀 예외처리 추가_20201006
                               if (("A0190005".equals(payr0530Dto.getFamyRelaDivCd())) && (!PayrServerUtils.getAgeYn(MSFSharedUtils.allowNulls(payr0530Dto.getPayFamyResnRegnNum()).replaceAll("-", ""))) && ("N".equals(payr0530Dto.getDabpnDducYn()))) {
                            	   payr0530Vo.setFamyExtpySum(new BigDecimal("0"));
                               } else {
                                   payr0530Vo.setFamyExtpySum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530Dto.getFamyExtpySum(), "0")));
                                 }
                               //payr0530Vo.setFamyExtpySum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0530Dto.getFamyExtpySum(),"0")));    /** column 가족수당금액 : famyExtpySum */
                               payr0530Vo.setSchlExpnExtpyPymtBgnnDt(payr0530Dto.getSchlExpnExtpyPymtBgnnDt());    /** column 학비수당지급시작일자 : schlExpnExtpyPymtBgnnDt */
                               payr0530Vo.setSchlExpnExtpyPymtEndDt(payr0530Dto.getSchlExpnExtpyPymtEndDt());    /** column 학비수당지급종료일자 : schlExpnExtpyPymtEndDt */
           //                    payr0530Vo.setKybdr(payr0530Dto.getKybdr());    /** column 입력자 : kybdr */
           //                    payr0530Vo.setInptDt(payr0530Dto.getInptDt());    /** column 입력일자 : inptDt */
           //                    payr0530Vo.setInptAddr(payr0530Dto.getInptAddr());    /** column 입력주소 : inptAddr */
           //                    payr0530Vo.setIsmt(payr0530Dto.getIsmt());    /** column 수정자 : ismt */
           //                    payr0530Vo.setRevnDt(payr0530Dto.getRevnDt());    /** column 수정일자 : revnDt */
           //                    payr0530Vo.setRevnAddr(payr0530Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
            
           		            switch (actionDatabase) { 
           		            case INSERT:
           		                tpPayr0530Vo = payr0530DAO.selectPayr0530Check(payr0530Vo);
           		             
           		                if (MSFSharedUtils.paramNotNull(tpPayr0530Vo) && MSFSharedUtils.paramNotNull(tpPayr0530Vo.getPayFamyResnRegnNum())) {
           		                   
           		                } else {
           		                    payr0530DAO.insertPayr0530(payr0530Vo);
           		                }
           		                 
           		               break;
           		            case UPDATE: 
           		                
           		                if ("Y".equals(payr0530Vo.getFamyAllwPymtYn())) {
           		                    //가족수당지급여부 C9050100
           		                    Payr0450VO payr0450Vo = new Payr0450VO(); //0450vo를 불러온다

                                       payr0450Vo.setDpobCd(payr0530Vo.getDpobCd()); //0530vo의 사업장코드를 0450vo에 넣는다   /** column 사업장코드 : dpobCd */
           		                    payr0450Vo.setPayItemCd("C9050100"); //0450vo에 급여항목코드를 넣어준다 -> 가족수당
           		                    payr0450Vo.setItemExtpyDivCd(payr0530Dto.getFamyExtpyDivCd()); //0530dto의 가족수당구분코드를 0450vo의 항목수당구분코드에 넣어준다 ex)B0260045 -> 둘째자녀
           		                    /**
           		                     * 
                                              B0260060    B026    0060    세째자녀(년도기준)
                                              B0260070    B026    0070    세째자녀(통합가산)
                                              B0260030    B026    0030    자녀
                                              B0260040    B026    0040    자녀(년도기준)
                                              B0260045    B026    0045    둘째자녀
                                              B0260010    B026    0010    배우자
                                              B0260020    B026    0020    부모
                                              B0260050    B026    0050    세째자녀(개별가산)
           		                     */
           		                    if (MSFSharedUtils.paramNull(payr0450Vo.getItemExtpyDivCd())) {
               		                    if ("A0190002".equals(payr0530Vo.getFamyRelaDivCd())) {    /** column 가족관계구분코드 : famyRelaDivCd */
               		                    //처 - B0260010
               		                        payr0450Vo.setItemExtpyDivCd("B0260010");
               		                    } else if ("A0190007".equals(payr0530Vo.getFamyRelaDivCd())) { 
               		                        //남편 B0260010
               		                        payr0450Vo.setItemExtpyDivCd("B0260010");
               		                    } else if ("A0190005".equals(payr0530Vo.getFamyRelaDivCd())) { 
                                               // 자 B0260030
               		                        payr0450Vo.setItemExtpyDivCd("B0260030");
                                           } else { 
                                               //  A019  0003    부  A019    0004    모   ---B0260020
                                               payr0450Vo.setItemExtpyDivCd("B0260020");
                                              
                                           }
           		                    }  
           		                   
                                       payr0450Vo.setItemListExtpyDelYn("N");    /** column 항목별수당삭제여부 : itemListExtpyDelYn */
                              
           		                    //가족수당가져오기 
                                       payr0450Vo =  payr0450DAO.selectPayr0450ToPayr4100(payr0450Vo);
                                       if (MSFSharedUtils.paramNotNull(payr0450Vo)) { 
                                         
                                           payr0530Vo.setFamyExtpyDivCd(payr0450Vo.getItemExtpyDivCd());    /** column 가족수당구분코드 : famyExtpyDivCd */
                                           
                                           if (("B0260030".equals(payr0450Vo.getItemExtpyDivCd())) && (!PayrServerUtils.getAgeYn(MSFSharedUtils.allowNulls(payr0530Dto.getPayFamyResnRegnNum()).replaceAll("-", ""))) && ("N".equals(payr0530Vo.getDabpnDducYn()))) {
                                            	   payr0530Vo.setFamyExtpySum(new BigDecimal("0"));
                                             } 
                                           else if (("B0260045".equals(payr0450Vo.getItemExtpyDivCd())) && (!PayrServerUtils.getAgeYn(MSFSharedUtils.allowNulls(payr0530Dto.getPayFamyResnRegnNum()).replaceAll("-", ""))) && ("N".equals(payr0530Vo.getDabpnDducYn()))){
                                            	   payr0530Vo.setFamyExtpySum(new BigDecimal("0"));
                                           }
                                           else if(("B0260060".equals(payr0450Vo.getItemExtpyDivCd())) && (!PayrServerUtils.getAgeYn(MSFSharedUtils.allowNulls(payr0530Dto.getPayFamyResnRegnNum()).replaceAll("-", ""))) && ("N".equals(payr0530Vo.getDabpnDducYn()))){
                                            	   payr0530Vo.setFamyExtpySum(new BigDecimal("0"));
                                           }
                                           else {
                                               payr0530Vo.setFamyExtpySum(payr0450Vo.getPymtDducSum().add(payr0450Vo.getAddPymtDducSum()));
                                             }
                                           
                                           }
           		                } else {
           		                    payr0530Vo.setFamyExtpyDivCd("");    /** column 가족수당구분코드 : famyExtpyDivCd */
                                       payr0530Vo.setFamyExtpySum(new BigDecimal("0"));    /** column 가족수당금액 : famyExtpySum */
           		                }
           		                
           		                if (MSFSharedUtils.paramNotNull(payr0530Vo.getSchlExpnAdmclExtpyDivCd())) {
                                       //학비보조수당구분코드  C9060100 
           		                    Payr0450VO payr0450Vo = new Payr0450VO(); 
           		                    
           		                    payr0450Vo.setDpobCd(payr0530Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
                                       payr0450Vo.setPayItemCd("C9060100");
                                       payr0450Vo.setItemExtpyDivCd(payr0530Dto.getSchlExpnAdmclExtpyDivCd());    /** column 학비보조수당구분코드 : schlExpnAdmclExtpyDivCd */
                                    
                                       payr0450Vo.setItemListExtpyDelYn("N");    /** column 항목별수당삭제여부 : itemListExtpyDelYn */
                                        
                                       //학비보조수당가져오기 
                                       payr0450Vo =  payr0450DAO.selectPayr0450ToPayr4100(payr0450Vo);
                                       if (MSFSharedUtils.paramNotNull(payr0450Vo)) { 
                                           payr0530Vo.setSchlExpnAdmclExtpySum(payr0450Vo.getPymtDducSum());    /** column 학비보조수당금액 : schlExpnAdmclExtpySum */ 
                                       }
           		                   
           		                } else {
                                       payr0530Vo.setSchlExpnAdmclExtpySum(new BigDecimal("0"));    /** column 학비보조수당금액 : schlExpnAdmclExtpySum */
                                       payr0530Vo.setSchlExpnExtpyPymtBgnnDt("");    /** column 학비수당지급시작일자 : schlExpnExtpyPymtBgnnDt */
                                       payr0530Vo.setSchlExpnExtpyPymtEndDt("");    /** column 학비수당지급종료일자 : schlExpnExtpyPymtEndDt */
                                   }
                                   
           		            	payr0530DAO.updatePayr0530(payr0530Vo);
           		            	 
           		                break;
           		            case DELETE:
           		            	payr0530DAO.deletePayr0530(payr0530Vo);
           		                break;
           		            }
           		            
           		            iCnt = iCnt + 1;
		                }
		                
		                /*********************************************************************************************
		                 * 소득세 공제 처리를 위한 구현부로 추후 수정가능성있음. 
		                 *********************************************************************************************/
		              //payr0500 업데이트 처리 필요
		              //배우자 및 부양가족수  
//		                A0190001     본인
//		                A0190002    처
//		                A0190003    부
//		                A0190004    모
//		                A0190005    자
//		                A0190007    남편
		                
		                payr0500Vo.setDpobCd(payr0530Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
	                    payr0500Vo.setSystemkey(payr0530Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
	  
	                    payr0500Vo = payr0500DAO.selectPayr0500ToPayr0530(payr0500Vo);

	                    if (MSFSharedUtils.paramNotNull(payr0500Vo)) {
                              payr0500Vo.setSpueYn(payr0500Vo.getSpueYn());    /** column 배우자유무 : spueYn */                    
       		               payr0500Vo.setSuprtFamyNumTwenChDn(payr0500Vo.getSuprtFamyNumTwenChDn());    /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
                              payr0500Vo.setSuprtFamyNumTreOvrChdnYn(payr0500Vo.getSuprtFamyNumTreOvrChdnYn());    /** column 부양가족수_3_이상자녀여부 : suprtFamyNumTreOvrChdnYn */
                              payr0500Vo.setSuprtFamyNumEtc(payr0500Vo.getSuprtFamyNumEtc());    /** column 부양가족수_기타 : suprtFamyNumEtc */
                            
                              if (MSFSharedUtils.paramNotNull(payr0530Vo.getSchlExpnAdmclExtpyDivCd())) {
                                  payr0500Vo.setChdnSchlExpnAdmclYn("Y");    /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */
                              } else {
                                  payr0500Vo.setChdnSchlExpnAdmclYn("N");    /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */
                              } 
                         //     payr0500Vo.setLogSvcExtpyApptnYn((Boolean.TRUE.equals(payr0500Dto.getLogSvcExtpyApptnYn()) ? "Y" : "N"));    /** column 근속수당적용여부 : logSvcExtpyApptnYn */
        
                              payr0500DAO.updatePayr0500ToPayr0530(payr0500Vo); 
	                    }   
	                    
		            result = iCnt;
		            
		        }  catch (Exception ex) {
		        	
		            //logger.error("EXCEPTION calling activityOnVoceMenu(): "+ex); 
		            result = new Long(0);
		            ex.printStackTrace();
		            
		            /** 에러 로그 **/			
		            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:" + actionDatabase.toString(), ex, windowNm , windowId);
		            
		            throw MSFServerUtils.getOperationException("activityOnPayr0530", ex, logger);
		            
		        } finally {
		          
		        }
		        
   			/** 로그반영
   			 * CRUDSBLO
   			 * C:create		R:read		U:update
   	    	 * D:delete		S:select	B:배치 
   	    	 * L:로그인		O:로그아웃
   	    	 */
   			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:" + actionDatabase.toString()); 
   			
		        return result;
		}
		@Override
		public Long activityOnPayr0520(Payr0520DTO payr0520Dto,
				ActionDatabase actionDatabase) {
			
			// TODO Auto-generated method stub
			  Long result = new Long(1);
			  String method = calledClass + ".activityOnPayr0520";
			  

			  String windowNm = "급여대상자관리";
			  String windowId = "PAYR4100";
		        
			  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			  
		        try {
		           
		        	payr0520DAO = (Payr0520DAO)BeanFinder.getBean("Payr0520DAO");
		        	 
		        	Payr0520VO  payr0520Vo = new Payr0520VO();
		        	

                        payr0520Vo.setDpobCd(payr0520Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
                        payr0520Vo.setSystemkey(payr0520Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
                        payr0520Vo.setPayItemCd(payr0520Dto.getPayItemCd());    /** column 급여항목코드 : payItemCd */
                        payr0520Vo.setPymtDducItemSilNum(new BigDecimal(payr0520Dto.getPymtDducItemSilNum()));    /** column 개별지급공제항목일련번호 : pymtDducItemSilNum */
                        payr0520Vo.setPymtDducDivCd(payr0520Dto.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
                        payr0520Vo.setPymtDducSum(new BigDecimal(payr0520Dto.getPymtDducSum()));    /** column 지급공제금액 : pymtDducSum */
                        payr0520Vo.setPymtDducRate(new BigDecimal(payr0520Dto.getPymtDducRate()));    /** column 지급공제율 : pymtDducRate */
                        payr0520Vo.setPymtDducFreeDtySum(new BigDecimal(payr0520Dto.getPymtDducFreeDtySum()));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
                        payr0520Vo.setPymtDducItemCretnDivCd(payr0520Dto.getPymtDducItemCretnDivCd());    /** column 지급공제항목생성구분코드 : pymtDducItemCretnDivCd */
                        payr0520Vo.setPymtDducItemBgnnDt(payr0520Dto.getPymtDducItemBgnnDt());    /** column 지급공제항목시작일자 : pymtDducItemBgnnDt */
                        payr0520Vo.setPymtDducItemEndDt(payr0520Dto.getPymtDducItemEndDt());    /** column 지급공제항목종료일자 : pymtDducItemEndDt */
                        payr0520Vo.setPymtDducItemDelYn((Boolean.TRUE.equals(payr0520Dto.getPymtDducItemDelYn()) ? "Y" : "N") );    /** column 지급공제항목삭제여부 : pymtDducItemDelYn */
                        payr0520Vo.setPymtDducItemNoteCtnt(payr0520Dto.getPymtDducItemNoteCtnt());    /** column 지급공제항목비고내용 : pymtDducItemNoteCtnt */
                        payr0520Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
                        payr0520Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
                        payr0520Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
                        payr0520Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
		            
		            switch (actionDatabase) { 
		            case INSERT:
		            	payr0520DAO.insertPayr0520(payr0520Vo);
		               break;
		            case UPDATE: 
		            	payr0520DAO.updatePayr0520(payr0520Vo);
		                break;
		            case DELETE:
		            	payr0520DAO.deletePayr0520(payr0520Vo);
		                break;
		            }
		            
		        }catch (Exception ex) {
		            //logger.error("EXCEPTION calling activityOnVoceMenu(): "+ex); 
		            result = new Long(0);
		            ex.printStackTrace();
		            
		            /** 에러 로그 **/			
		            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), ex, windowNm , windowId);
		            
		            throw MSFServerUtils.getOperationException("activityOnPayr0520", ex, logger);
		        }
		        finally {
		          
		        }
		        
    			/** 로그반영
    			 * CRUDSBLO
    			 * C:create		R:read		U:update
    	    	 * D:delete		S:select	B:배치 
    	    	 * L:로그인		O:로그아웃
    	    	 */
	            MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
	            
		        return result;
		        
		}
 

        @Override
        public Long activityOnUpdatePayr4100Save(Payr0500DTO payr0500Dto) {
        	
            // TODO Auto-generated method stub 
            Long result = new Long(1);
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());  
			String method = calledClass + ".activityOnUpdatePayr4100Save";
			
			String windowNm = "급여대상자관리";
			String windowId = "PAYR4100";
			
			
              try {
            	   
                  //1.인사마스터 근속년수 업데이트 처리 
                  //2.급여인사마스터 사대보험관련 업데이트 처리 
                  //3.급여 보수총액 관련 업데이트 
                  Payr0500VO  payr0500Vo = new Payr0500VO(); 
                  Payr0500VO  tpPayr0500Vo = new Payr0500VO(); 
                  InfcPkgPsnl0100VO  psnl0100Vo = new InfcPkgPsnl0100VO();
                  InfcPkgPsnl0127VO  psnl0127Vo = new InfcPkgPsnl0127VO();
                  InfcPkgPsnl0127VO  tpPsnl0127Vo = new InfcPkgPsnl0127VO(); 
                   
                //*******************************************************************************************************/
                  //근속년수 업데이트 
                  // 2016.05.25 호봉, 노조가입여부 추가
                 psnl0100Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0500Dto.getDpobCd()));    						/** column 사업장코드 : dpobCd */
                 psnl0100Vo.setSystemkey(MSFSharedUtils.allowNulls(payr0500Dto.getSystemkey()));    				/** column SYSTEMKEY : systemkey */
                
                 psnl0100Vo.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(payr0500Dto.getLogSvcYrNumCd()));    		/** column 근속년수코드 : logSvcYrNumCd */
                 psnl0100Vo.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(payr0500Dto.getLogSvcMnthIcmCd()));		/** column 근속월수코드 : logSvcMnthIcmCd */ 
                 
                 psnlUp0100DAO.updatePsnl0100ToPayr4100(psnl0100Vo);
                 
                 psnl0100Vo.setPyspCd(MSFSharedUtils.allowNulls(payr0500Dto.getPyspCd()));							/** column 호봉코드 : pyspCd */
                 psnl0100Vo.setUnnMbspSttYn(MSFSharedUtils.allowNulls(payr0500Dto.getUnnMbspSttYn()));				/** column 노조가입여부 : unnMbspSttYn */
                 
                 psnlUp0100DAO.updatePsnl0100ToPayr4100_2(psnl0100Vo);
                   

                //*******************************************************************************************************/
                // 사회보험 변동 
                                
                psnl0127Vo.setDpobCd(payr0500Dto.getDpobCd());    					/** column 사업장코드 : dpobCd */
                psnl0127Vo.setSystemkey(payr0500Dto.getSystemkey());    			/** column SYSTEMKEY : systemkey */
                psnl0127Vo.setSoctyInsurYr(payr0500Dto.getSoctyInsurYr());    		/** column 사회보험년도 : soctyInsurYr */
              //  psnl0127Vo.setHlthInsurFlucDt(payr0500Dto.getHlthInsurFlucDt());    /** column 건강보험변동일자 : hlthInsurFlucDt */
              //  psnl0127Vo.setHlthInsrPayTotAmnt(new BigDecimal(payr0500Dto.getHlthInsrPayTotAmnt()));    /** column 건강보험보수총액 : hlthInsrPayTotAmnt */
                psnl0127Vo.setHlthInsrMnthRuntnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0500Dto.getHlthInsrMnthRuntnAmnt(),"0")));    		/** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
              //  psnl0127Vo.setHlthInsrGrde(payr0500Dto.getHlthInsrGrde());    /** column 건강보험등급 : hlthInsrGrde */
              //  psnl0127Vo.setHlthInsrCertNum(payr0500Dto.getHlthInsrCertNum());    /** column 건강보험증번호 : hlthInsrCertNum */
              //  psnl0127Vo.setNatPennInsurFlucDt(payr0500Dto.getNatPennInsurFlucDt());    /** column 국민연금변동일자 : natPennInsurFlucDt */
                psnl0127Vo.setNatPennStdIncmMnthAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0500Dto.getNatPennStdIncmMnthAmnt(), "0")));    /** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
              //  psnl0127Vo.setNatPennGrde(payr0500Dto.getNatPennGrde());    /** column 국민연금등급 : natPennGrde */
                psnl0127Vo.setHlthInsrApptnYn((Boolean.TRUE.equals(payr0500Dto.getHlthInsrApptnYn()) ? "Y" : "N"));    				/** column 건강보험적용여부 : hlthInsrApptnYn */
                psnl0127Vo.setNatPennApptnYn((Boolean.TRUE.equals(payr0500Dto.getNatPennApptnYn()) ? "Y" : "N"));    				/** column 국민연금적용여부 : natPennApptnYn */
                psnl0127Vo.setUmytInsrApptnYn((Boolean.TRUE.equals(payr0500Dto.getUmytInsrApptnYn()) ? "Y" : "N"));   				 /** column 고용보험적용여부 : umytInsrApptnYn */
                psnl0127Vo.setIdtlAccdtInsurApptnYn((Boolean.TRUE.equals(payr0500Dto.getIdtlAccdtInsurApptnYn()) ? "Y" : "N"));    /** column 산재보험적용여부 : idtlAccdtInsurApptnYn */
          
              //  psnl0127Vo.setUmytInsrFlucDt(payr0500Dto.getUmytInsrFlucDt());    /** column 고용보험변동일자 : umytInsrFlucDt */
              //  psnl0127Vo.setUmytInsrPayTotAmnt(new BigDecimal(payr0500Dto.getUmytInsrPayTotAmnt()));    /** column 고용보험보수총액 : umytInsrPayTotAmnt */
                psnl0127Vo.setUmytInsrPayMnthAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0500Dto.getUmytInsrPayMnthAmnt(),"0")));    /** column 고용보험보수월액 : umytInsrPayMnthAmnt */
               // psnl0127Vo.setIdtlAccdtFlucDt(payr0500Dto.getIdtlAccdtFlucDt());    /** column 산재보험변동일자 : idtlAccdtFlucDt */
               // psnl0127Vo.setIdtlAccdtPayTotAmnt(new BigDecimal(payr0500Dto.getIdtlAccdtPayTotAmnt()));    /** column 산재보험보수총액 : idtlAccdtPayTotAmnt */
                psnl0127Vo.setIdtlAccdtPayMnthAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(payr0500Dto.getIdtlAccdtPayMnthAmnt(),"0")));    /** column 산재보험보수월액 : idtlAccdtPayMnthAmnt */

                psnl0127Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
               // psnl0127Vo.setInptDt(payr0500Dto.getInptDt());    /** column 입력일자 : inptDt */
               // psnl0127Vo.setInptAddr(payr0500Dto.getInptAddr());    /** column 입력주소 : inptAddr */
                psnl0127Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
               // psnl0127Vo.setRevnDt(payr0500Dto.getRevnDt());    /** column 수정일자 : revnDt */
               // psnl0127Vo.setRevnAddr(payr0500Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
                
                tpPsnl0127Vo = psnl0127DAO.selectPsnl0127(psnl0127Vo); 
                
//                String strJobSeptDivCd = "";
                
                if (MSFSharedUtils.paramNotNull(tpPsnl0127Vo) && MSFSharedUtils.paramNotNull(tpPsnl0127Vo.getSystemkey())) {
                    
                    psnl0127Vo.setSoctyInsurYr(tpPsnl0127Vo.getSoctyInsurYr());    /** column 사회보험년도 : soctyInsurYr */
                    psnl0127DAO.updatePsnl0127ToPayr4100(psnl0127Vo);
                    
                    
                } else {
                    
                    psnl0127DAO.insertPsnl0127(psnl0127Vo);
                    
                }
                
               //*******************************************************************************************************/
                // 급여인사마스터 업데이트  

                payr0500Vo.setDpobCd(payr0500Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
                payr0500Vo.setSystemkey(payr0500Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
                payr0500Vo.setPayrMangDeptCd(payr0500Dto.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
                payr0500Vo.setEmymtDivCd(payr0500Dto.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
                payr0500Vo.setLogSvcStdDt(payr0500Dto.getLogSvcStdDt());    /** column 근속기준일자 : logSvcStdDt */
                payr0500Vo.setWmnYn((Boolean.TRUE.equals(payr0500Dto.getWmnYn()) ? "Y" : "N"));    /** column 부녀자여부 : wmnYn */
                payr0500Vo.setRetryClutYn((Boolean.TRUE.equals(payr0500Dto.getRetryClutYn()) ? "Y" : "N"));    /** column 퇴직정산여부 : retryClutYn */
                payr0500Vo.setPayRcptYn((Boolean.TRUE.equals(payr0500Dto.getPayRcptYn()) ? "Y" : "N"));    /** column 급여대상자여부 : payRcptYn */
              //  payr0500Vo.setSpueYn(payr0500Dto.getSpueYn());    /** column 배우자유무 : spueYn */
                payr0500Vo.setHlthInsrApptnYn((Boolean.TRUE.equals(payr0500Dto.getHlthInsrApptnYn()) ? "Y" : "N"));    /** column 건강보험적용여부 : hlthInsrApptnYn */
                payr0500Vo.setNatPennApptnYn((Boolean.TRUE.equals(payr0500Dto.getNatPennApptnYn()) ? "Y" : "N"));    /** column 국민연금적용여부 : natPennApptnYn */
                payr0500Vo.setUmytInsrApptnYn((Boolean.TRUE.equals(payr0500Dto.getUmytInsrApptnYn()) ? "Y" : "N"));    /** column 고용보험적용여부 : umytInsrApptnYn */
                payr0500Vo.setIdtlAccdtInsurApptnYn((Boolean.TRUE.equals(payr0500Dto.getIdtlAccdtInsurApptnYn()) ? "Y" : "N"));    /** column 산재보험적용여부 : idtlAccdtInsurApptnYn */
               // payr0500Vo.setSuprtFamyNumTwenChDn(payr0500Dto.getSuprtFamyNumTwenChDn());    /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
               // payr0500Vo.setSuprtFamyNumTreOvrChdnYn(payr0500Dto.getSuprtFamyNumTreOvrChdnYn());    /** column 부양가족수_3_이상자녀여부 : suprtFamyNumTreOvrChdnYn */
               // payr0500Vo.setSuprtFamyNumEtc(payr0500Dto.getSuprtFamyNumEtc());    /** column 부양가족수_기타 : suprtFamyNumEtc */
               // payr0500Vo.setChdnSchlExpnAdmclYn(payr0500Dto.getChdnSchlExpnAdmclYn());    /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */
                payr0500Vo.setLogSvcExtpyApptnYn((Boolean.TRUE.equals(payr0500Dto.getLogSvcExtpyApptnYn()) ? "Y" : "N"));    /** column 근속수당적용여부 : logSvcExtpyApptnYn */
                payr0500Vo.setDayWorkYn((Boolean.TRUE.equals(payr0500Dto.getDayWorkYn()) ? "Y" : "N"));    /** column 일용직구분 : dayWorkYn */
                payr0500Vo.setMnthPayDlywagSum(new BigDecimal(payr0500Dto.getMnthPayDlywagSum()));    /** column 월급여일당금액 : mnthPayDlywagSum */
                
                payr0500Vo.setPayrIncmExceYn((Boolean.TRUE.equals(payr0500Dto.getPayrIncmExceYn()) ? "Y" : "N"));    /** column 급여소득세제외여부 : payrIncmExceYn */
                 
                
                tpPayr0500Vo = payr0500DAO.selectPayr0500(payr0500Vo);
                
                if (MSFSharedUtils.paramNotNull(tpPayr0500Vo) && MSFSharedUtils.paramNotNull(tpPayr0500Vo.getSystemkey())) { 
                	
                	  if (MSFSharedUtils.allowNulls(tpPayr0500Vo.getAddIncmTxApptnRtoCd()).equals(payr0500Dto.getAddIncmTxApptnRtoCd())
                      		&& MSFSharedUtils.allowNulls(tpPayr0500Vo.getAddIncmTxApptnYrMnth()).equals(payr0500Dto.getAddIncmTxApptnYrMnth()) 
                      		&& "E".equals(MSFSharedUtils.allowNulls(tpPayr0500Vo.getAddIncmTxApptnYn())))  {
                		  
                		  payr0500Vo.setAddIncmTxApptnRtoCd(payr0500Dto.getAddIncmTxApptnRtoCd());    /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
                          payr0500Vo.setAddIncmTxApptnYrMnth(payr0500Dto.getAddIncmTxApptnYrMnth());    /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
                          payr0500Vo.setAddIncmTxApptnYn(payr0500Dto.getAddIncmTxApptnYn());    /** column 추가소득세적용여부 : addIncmTxApptnYn */
                		  
                	  } else {
                		  payr0500Vo.setAddIncmTxApptnRtoCd(payr0500Dto.getAddIncmTxApptnRtoCd());    /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
                          payr0500Vo.setAddIncmTxApptnYrMnth(payr0500Dto.getAddIncmTxApptnYrMnth());    /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
                          payr0500Vo.setAddIncmTxApptnYn("Y");    /** column 추가소득세적용여부 : addIncmTxApptnYn */
                	  }
                } else {
                	//에러메시지
                	 payr0500Vo.setAddIncmTxApptnRtoCd(payr0500Dto.getAddIncmTxApptnRtoCd());    /** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
                     payr0500Vo.setAddIncmTxApptnYrMnth(payr0500Dto.getAddIncmTxApptnYrMnth());    /** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
                     payr0500Vo.setAddIncmTxApptnYn(payr0500Dto.getAddIncmTxApptnYn());    /** column 추가소득세적용여부 : addIncmTxApptnYn */
                }
                
//                payr0500Vo.setKybdr(payr0500Dto.getKybdr());    /** column 입력자 : kybdr */
//                payr0500Vo.setInptDt(payr0500Dto.getInptDt());    /** column 입력일자 : inptDt */
//                payr0500Vo.setInptAddr(payr0500Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//                payr0500Vo.setIsmt(payr0500Dto.getIsmt());    /** column 수정자 : ismt */
//                payr0500Vo.setRevnDt(payr0500Dto.getRevnDt());    /** column 수정일자 : revnDt */
//                payr0500Vo.setRevnAddr(payr0500Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
              
                  payr0500DAO.updatePayr0500ToPayr4100(payr0500Vo); 
                  
              }catch (Exception ex) {
                  //logger.error("EXCEPTION calling activityOnVoceMenu(): "+ex); 
                  result = new Long(0);
                  ex.printStackTrace();
                  
                  /** 에러 로그 **/			
                  MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:U:C",ex, windowNm , windowId);
                  
                  throw MSFServerUtils.getOperationException("activityOnPayr0520", ex, logger);
              }finally {
                
              }
              
  			/** 로그반영
  			 * CRUDSBLO
  			 * C:create		R:read		U:update
  	    	 * D:delete		S:select	B:배치 
  	    	 * L:로그인		O:로그아웃
  	    	 */
  			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:U:C" );
	  			
  			return result;
  			
        }

        @Override
        public Long activityOnPayr0540(List<Payr0540DTO> listPayr0540dto, ActionDatabase actionDatabase) {
         // TODO Auto-generated method stub
            
            Long result = new Long(1);
            Long iCnt = new Long(0);
            
			String method = calledClass + ".activityOnPayr0540";
			
			String windowNm = "급여대상자관리";
			String windowId = "PAYR4100";
            
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());  
            
              try { 
              
                    
                      for(int iPayrCnt=0;iPayrCnt < listPayr0540dto.size();iPayrCnt++) {
                          
                              Payr0540DTO payr0540Dto = new Payr0540DTO();  
                              payr0540Dto = listPayr0540dto.get(iPayrCnt);  
                 
                              Payr0540VO  payr0540Vo = new Payr0540VO();
                              Payr0540VO  tpPayr0540Vo = new Payr0540VO();
                              
                              // BeanUtils.copyProperties(payr0540Vo, payr0540Dto);  
                                 
                                payr0540Vo.setDpobCd(payr0540Dto.getDpobCd());    		/** column 사업장코드 : dpobCd */
                                payr0540Vo.setSystemkey(payr0540Dto.getSystemkey());   	/** column SYSTEMKEY : systemkey */
                                payr0540Vo.setExptnPrcsSeilNum(new BigDecimal(payr0540Dto.getExptnPrcsSeilNum()));    /** column 예외처리일련번호 : exptnPrcsSeilNum */
                                payr0540Vo.setExptnDivCd(payr0540Dto.getExptnDivCd());    	/** column 예외구분코드 : exptnDivCd */
                                payr0540Vo.setPymtDducDivCd(payr0540Dto.getPymtDducDivCd());    								/** column 지급공제구분코드 : pymtDducDivCd */
                                payr0540Vo.setExmtnYn((Boolean.TRUE.equals(payr0540Dto.getExmtnYn()) ? "Y" : "N") );    		/** column 면제여부 : exmtnYn */
                                payr0540Vo.setExptnPrcsPymtSum(new BigDecimal(payr0540Dto.getExptnPrcsPymtSum()));    /** column 예외처리공제금액 : exptnPrcsPymtSum */
                                payr0540Vo.setExptnPrcsPymtRto(new BigDecimal(payr0540Dto.getExptnPrcsPymtRto()));    	/** column 예외처리공제비율 : exptnPrcsPymtRto */
                                payr0540Vo.setExptnPrcsBgnnDt(payr0540Dto.getExptnPrcsBgnnDt());    /** column 예외처리시작일자 : exptnPrcsBgnnDt */
                                payr0540Vo.setExptnPrcsEndDt(payr0540Dto.getExptnPrcsEndDt());   	 /** column 예외처리종료일자 : exptnPrcsEndDt */
                                payr0540Vo.setPayItemCd(payr0540Dto.getPayItemCd());    				/** column 급여항목코드 : payItemCd */
                                payr0540Vo.setExptnPrcsNoteCtnt(payr0540Dto.getExptnPrcsNoteCtnt());    /** column 예외처리내용 : exptnPrcsNoteCtnt */
                                payr0540Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
                                //  payr0540Vo.setInptDt(Payr0540Dto.getInptDt());    /** column 입력일자 : inptDt */
                                 // payr0540Vo.setInptAddr(Payr0540Dto.getInptAddr());    /** column 입력주소 : inptAddr */
                                  payr0540Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
                                 // payr0540Vo.setRevnDt(Payr0540Dto.getRevnDt());    /** column 수정일자 : revnDt */
                                 // payr0540Vo.setRevnAddr(Payr0540Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
                               
                               
                               switch (actionDatabase) { 
                               case INSERT:
//                                   tpPayr0530Vo = payr0540DAO.selectPayr0530(payr0530Vo);
//                                   
//                                   if (MSFSharedUtils.paramNotNull(tpPayr0530Vo) && MSFSharedUtils.paramNotNull(tpPayr0530Vo.getPayFamyResnRegnNum())) {
//                                    
//                                   } else {
                                    payr0540DAO.insertPayr0540(payr0540Vo);
//                                   }
                                  
                                  break;
                               case UPDATE: 
                                   payr0540DAO.updatePayr0540(payr0540Vo);
                                   break;
                               case DELETE:
                                   payr0540DAO.deletePayr0540(payr0540Vo);
                                   break;
                               }
                               
                               iCnt = iCnt + 1;
                               
                      }
                  result = iCnt;
                  
              }  catch (Exception ex) {
            	  
                  //logger.error("EXCEPTION calling activityOnPayr0540(): "+ex); 
                  result = new Long(0);
                  ex.printStackTrace();
                  
                  /** 에러 로그 **/			
                  MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),ex, windowNm , windowId);
                  
                  throw MSFServerUtils.getOperationException("activityOnPayr0540", ex, logger);
                  
              } finally {
                
              }
              
	    	/** 로그반영
	    	 * CRUDSBLO
	    	 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
              MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
              
              return result;
               
        }
 
 
}
