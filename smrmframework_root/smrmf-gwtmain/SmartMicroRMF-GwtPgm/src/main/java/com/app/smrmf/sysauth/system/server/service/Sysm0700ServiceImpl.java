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
package com.app.smrmf.sysauth.system.server.service;

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

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0700DTO;
import com.app.smrmf.sysauth.system.client.service.Sysm0700Service;
import com.app.smrmf.sysauth.system.shared.SysmDaoConstants;
import com.app.smrmf.sysm.server.service.dao.SysIfBass0360DAO;
import com.app.smrmf.sysm.server.service.dao.Sysm0100DAO;
import com.app.smrmf.sysm.server.service.dao.Sysm0700DAO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0360SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100VO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0700SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0700VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

/**
 * <pre>
 * com.app.smrmf.sysauth.system.server.service 
 *    |_ Sysm0700ServiceImpl.java
 * 
 * </pre>
 * @date : Nov 11, 2015 11:35:06 PM
 * @version : 
 * @author : leeheuisung
 */
@Service("Sysm0700Service")
public class Sysm0700ServiceImpl extends AbstractCustomServiceImpl implements  SysmDaoConstants ,  Sysm0700Service {
	 
	private static final Logger logger = LoggerFactory.getLogger(Sysm0700ServiceImpl.class);
	private static final String calledClass = Sysm0700ServiceImpl.class.getName();
	
	@Autowired 
    @Resource(name="Sysm0700DAO")
    private Sysm0700DAO sysm0700DAO;
	

	@Autowired
	@Resource(name = "SysIfBass0360DAO")
	private SysIfBass0360DAO sysIfBass0360Dao; 
	
	@Autowired 
	@Resource(name="Sysm0100DAO")
	private Sysm0100DAO sysm0100DAO;
	   
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 개인별 직종 맵핑을 위한사용자정보 조회   
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getSelectSysm0600ToBass0150List
	 * @date : Dec 23, 2015
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Dec 23, 2015		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getSelectSysm0700ToSysm0100List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_SYSM0700TOSYSM0100_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>(); 
        SysIfSysm0100SrhVO   sysm0100SrhVo = new SysIfSysm0100SrhVO();
        SysIfSysm0100VO      sysm0100Vo = new SysIfSysm0100VO();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if(MSFSharedUtils.paramNull(sysm0100DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
        	sysm0100DAO = (Sysm0100DAO) wac.getBean("Sysm0100DAO");
        }
        try{
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            sysm0100SrhVo.setDpobCd(sessionUser.getDpobCd());
            sysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm"))); 
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = sysm0100DAO.selectSysm0700ToSysm0100ListTotCnt(sysm0100SrhVo);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectBass0450ToBass0400List = SmrmfUtils.startTiming(logger);
            
            sysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	sysm0100SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	sysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = sysm0100DAO.selectSysm0700ToSysm0100List(sysm0100SrhVo);
            
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            
            
            while (iter.hasNext() ) {
            	
            	Map<String, Object> map = (Map<String, Object>) iter.next();
                String deptCd = String.valueOf(map.get("usrId"));
                
                BaseModel bm = new BaseModel();
                
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
                bm.set(TableDef.ID_PROPERTY_NAME, deptCd);
                
                bmResult.add(bm);
            }
            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0450ToBass0400List, "getSelectBass0450ToBass0400List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }
 
	
	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 개인별 권한 맵핑 후 사용직종세 조회  
	  * 2. 처리내용 : 
	  * </pre>
	  * @Method Name : getSelectSysm0600TopToBass0360List
	  * @date : Dec 23, 2015
	  * @author : leeheuisung
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	Dec 23, 2015		leeheuisung				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param serviceParameters
	  * @return
	  * @throws MSFException
	  */
	public PagingLoadResult<BaseModel> getSelectSysm0700ToSysm0700List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_SYSM0700TOSYSM0700_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        SysIfSysm0700SrhVO sysm0700SrhVO = new SysIfSysm0700SrhVO();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        
        if(MSFSharedUtils.paramNull(sysm0700DAO)){
       	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
       	sysm0700DAO = (Sysm0700DAO) wac.getBean("Sysm0700DAO");
        }

        try{
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            sysm0700SrhVO.setDpobCd(sessionUser.getDpobCd()); 
            sysm0700SrhVO.setUsrId(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrId"))); 
            sysm0700SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
            sysm0700SrhVO.setDtilOccuClsNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsNm")));
            
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = sysm0700DAO.selectSysm0700ToSysm0700ListTotCnt(sysm0700SrhVO);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginselectSysm0700ToSysm0700List = SmrmfUtils.startTiming(logger);
            
            sysm0700SrhVO.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	sysm0700SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	sysm0700SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = sysm0700DAO.selectSysm0700ToSysm0700List(sysm0700SrhVO);
            
            
            Iterator iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            while ( iter.hasNext() ) {
            	Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = String.valueOf(map.get("dpobCd"))+String.valueOf(map.get("usrId"));
                BaseModel bm = new BaseModel();
                
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
            
            SmrmfUtils.endTiming(logger, millisBeginselectSysm0700ToSysm0700List, "selectBass0450ToBass0360List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 개인별  권한 맵핑 미사용 직종세 조회  
	 * 2. 처리내용 : 개인별 권한 맵핑이 안된 정보와 단위기관 맵핑이 안된 내역에 대해 조회 
	 * </pre>
	 * @Method Name : getSelectBass0450ToBass0350List
	 * @date : Dec 23, 2015
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Dec 23, 2015		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getSelectSysm0700ToBass0360List(ServiceParameters serviceParameters) throws MSFException {
		 PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_SYSM0700TOBASS0360_LIST;
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        SysIfBass0360SrhVO bass0360SrhVo = new SysIfBass0360SrhVO();
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if(MSFSharedUtils.paramNull(sysIfBass0360Dao)){
	        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	        	sysIfBass0360Dao = (SysIfBass0360DAO) wac.getBean("SysIfBass0360DAO");
	        }

	        try{
	        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();            
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
	            
	            bass0360SrhVo.setDpobCd(sessionUser.getDpobCd()); 
	            bass0360SrhVo.setUsrId(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrId")));
	            bass0360SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	            bass0360SrhVo.setDtilOccuClsNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsNm")));
	             
	            
	            if ( pagingValues.executeRecordCount ) { 
	            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	            	int iResultCnt = sysIfBass0360Dao.selectSysm0700ToBass0360ListTotCnt(bass0360SrhVo);
	            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	            TimingInfo millisBeginSelectSysm0700ToBass0360List = SmrmfUtils.startTiming(logger);
	            
	            bass0360SrhVo.setPageSize(pagingValues.totalRecordCount);
	            if( pagingValues.start > 0){
	            	bass0360SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	bass0360SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	            }
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            List list = sysIfBass0360Dao.selectSysm0700ToBass0360List(bass0360SrhVo);
	            
	            Iterator iter = list.iterator();
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
	            while ( iter.hasNext() ) {
	            	Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = String.valueOf(map.get("dpobCd"))+String.valueOf(map.get("deptCd"));
	                BaseModel bm = new BaseModel();
	                
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginSelectSysm0700ToBass0360List, "selectBass0450ToBass0350List");
	            
	        }catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;		
	} 
 
	@Override
	public Long sysm0700Delete(SysIfSysm0700DTO sysm0700Dto) throws MSFException {
		
		String method = calledClass + ".sysm0700Delete";

		Long rtnData = 0L;
		SysIfSysm0700VO sysm0700Vo = new SysIfSysm0700VO();
		
		MSFSysm0100BM sessionUser;

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
	try {	
		
		
		sysm0700Vo.setDpobCd(sysm0700Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
		sysm0700Vo.setDtilOccuInttnCd(sysm0700Dto.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
		sysm0700Vo.setTypOccuCd(sysm0700Dto.getTypOccuCd());    /** column 직종코드 : typOccuCd */
		sysm0700Vo.setDeptCd(sysm0700Dto.getDeptCd());    /** column 부서코드 : deptCd */
		sysm0700Vo.setUsrId(sysm0700Dto.getUsrId());    /** column 사용자아이디 : usrId */
//		sysm0700Vo.setKybdr(sysm0700Dto.getKybdr());    /** column 입력자 : kybdr */
//		sysm0700Vo.setInptDt(sysm0700Dto.getInptDt());    /** column 입력일자 : inptDt */
//		sysm0700Vo.setInptAddr(sysm0700Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//		sysm0700Vo.setIsmt(sysm0700Dto.getIsmt());    /** column 수정자 : ismt */
//		sysm0700Vo.setRevnDt(sysm0700Dto.getRevnDt());    /** column 수정일자 : revnDt */
//		sysm0700Vo.setRevnAddr(sysm0700Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
 
 
		sysm0700DAO.deleteSysm0700(sysm0700Vo);	
		
		rtnData = 1L;
	}catch(Exception e){
		e.printStackTrace();
		rtnData = 0L;
		throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
	}
	
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
	MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D");
	
	
		return rtnData;
	}

	  
	 
	@Override
	public Long sysm0700Insert(SysIfSysm0700DTO sysm0700Dto) throws MSFException {
		
		Long rtnData = 0L;
		SysIfSysm0700VO sysm0700Vo = new SysIfSysm0700VO();
		String method = calledClass + ".sysm0700Insert";
		MSFSysm0100BM sessionUser;

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		 
		try {
			
			sysm0700Vo.setDpobCd(sysm0700Dto.getDpobCd());    				/** column 사업장코드 : dpobCd */
			sysm0700Vo.setDtilOccuInttnCd(sysm0700Dto.getDtilOccuInttnCd());/** column 직종세통합코드 : dtilOccuInttnCd */
			sysm0700Vo.setTypOccuCd(sysm0700Dto.getTypOccuCd());    		/** column 직종코드 : typOccuCd */
			sysm0700Vo.setDeptCd(sysm0700Dto.getDeptCd());    				/** column 부서코드 : deptCd */
			sysm0700Vo.setUsrId(sysm0700Dto.getUsrId());    				/** column 사용자아이디 : usrId */
//			sysm0700Vo.setKybdr(sysm0700Dto.getKybdr());    /** column 입력자 : kybdr */
//			sysm0700Vo.setInptDt(sysm0700Dto.getInptDt());    /** column 입력일자 : inptDt */
//			sysm0700Vo.setInptAddr(sysm0700Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//			sysm0700Vo.setIsmt(sysm0700Dto.getIsmt());    /** column 수정자 : ismt */
//			sysm0700Vo.setRevnDt(sysm0700Dto.getRevnDt());    /** column 수정일자 : revnDt */
//			sysm0700Vo.setRevnAddr(sysm0700Dto.getRevnAddr());    /** column 수정주소 : revnAddr */

		   	 
 			sysm0700DAO.insertSysm0700(sysm0700Vo);	
 			
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
