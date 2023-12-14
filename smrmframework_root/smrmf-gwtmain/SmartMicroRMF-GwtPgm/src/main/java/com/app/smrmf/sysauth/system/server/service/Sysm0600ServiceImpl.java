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
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0360DTO;
import com.app.smrmf.sysauth.system.client.service.Sysm0600Service;
import com.app.smrmf.sysauth.system.shared.SysmDaoConstants;
import com.app.smrmf.sysm.server.service.dao.SysIfBass0150DAO;
import com.app.smrmf.sysm.server.service.dao.SysIfBass0360DAO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0150SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0360SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0360VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
@Service("Sysm0600Service")
public class Sysm0600ServiceImpl extends AbstractCustomServiceImpl implements SysmDaoConstants, Sysm0600Service {  
	
	private static final Logger logger = LoggerFactory.getLogger(Sysm0600ServiceImpl.class);
	private static final String calledClass = Sysm0600ServiceImpl.class.getName();

	@Autowired
	@Resource(name = "SysIfBass0150DAO")
	private SysIfBass0150DAO sysIfBass0150Dao;
	
	@Autowired
	@Resource(name = "SysIfBass0360DAO")
	private SysIfBass0360DAO sysIfBass0360Dao; 
	
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 단위기관 권한 맵핑 화면  
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
	public PagingLoadResult<BaseModel> getSelectSysm0600ToBass0150List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_SYSM0600TOBASS0150_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
//      Bass0400VO bass0400Vo = new Bass0400VO();
        SysIfBass0150SrhVO sysIfBass0150SrhVo = new SysIfBass0150SrhVO();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if(MSFSharedUtils.paramNull(sysIfBass0150Dao)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
        	sysIfBass0150Dao = (SysIfBass0150DAO) wac.getBean("SysIfBass0150DAO");
        }
        try{
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            sysIfBass0150SrhVo.setDpobCd(sessionUser.getDpobCd());
            sysIfBass0150SrhVo.setPayMangeDeptNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payMangeDeptNm"))); 
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = sysIfBass0150Dao.selectSysm0600ToBass0150ListTotCnt(sysIfBass0150SrhVo);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectBass0450ToBass0400List = SmrmfUtils.startTiming(logger);
            
            sysIfBass0150SrhVo.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	sysIfBass0150SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	sysIfBass0150SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = sysIfBass0150Dao.selectSysm0600ToBass0150List(sysIfBass0150SrhVo);
            
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            
            
            while (iter.hasNext() ) {
            	
            	Map<String, Object> map = (Map<String, Object>) iter.next();
                String deptCd = String.valueOf(map.get("deptCd"));
                
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
	  * 1. 개요 : 단위기관 권한 맵핑 후 사용직종세 조회  
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
	public PagingLoadResult<BaseModel> getSelectSysm0600TopToBass0360List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_SYSM0600TOPTOBASS0360_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        SysIfBass0360SrhVO bass0360SrhVo = new SysIfBass0360SrhVO();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        
        if(MSFSharedUtils.paramNull(sysIfBass0360Dao)){
       	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
       	sysIfBass0360Dao = (SysIfBass0360DAO) wac.getBean("SysIfBass0360DAO");
        }

        try{
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            bass0360SrhVo.setDpobCd(sessionUser.getDpobCd()); 
            bass0360SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
            bass0360SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
            bass0360SrhVo.setDtilOccuClsNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsNm")));
            
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = sysIfBass0360Dao.selectSysm0600TopToBass0360ListTotCnt(bass0360SrhVo);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginselectBass0450ToBass0360List = SmrmfUtils.startTiming(logger);
            
            bass0360SrhVo.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	bass0360SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	bass0360SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = sysIfBass0360Dao.selectSysm0600TopToBass0360List(bass0360SrhVo);
            
            Iterator iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            while ( iter.hasNext() ) {
            	Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = String.valueOf(map.get("dpobCd"))+String.valueOf(map.get("payMangeDeptCd"));
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
            
            SmrmfUtils.endTiming(logger, millisBeginselectBass0450ToBass0360List, "selectBass0450ToBass0360List");
            
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
	 * 1. 개요 : 단위기관 권한 맵핑 미사용 직종세 조회  
	 * 2. 처리내용 : 
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
	public PagingLoadResult<BaseModel> getSelectSysm0600BtmToBass0360List(ServiceParameters serviceParameters) throws MSFException {
		 PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_SYSM0600BTMTOBASS0360_LIST;
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
	            bass0360SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	            bass0360SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
	            bass0360SrhVo.setDtilOccuClsNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsNm")));
	             
	            
	            if ( pagingValues.executeRecordCount ) { 
	            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	            	int iResultCnt = sysIfBass0360Dao.selectSysm0600BtmToBass0360ListTotCnt(bass0360SrhVo);
	            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	            TimingInfo millisBeginSelectBass0450ToBass0350List = SmrmfUtils.startTiming(logger);
	            
	            bass0360SrhVo.setPageSize(pagingValues.totalRecordCount);
	            if( pagingValues.start > 0){
	            	bass0360SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	bass0360SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	            }
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            List list = sysIfBass0360Dao.selectSysm0600BtmToBass0360List(bass0360SrhVo);
	            
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginSelectBass0450ToBass0350List, "selectBass0450ToBass0350List");
	            
	        }catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;		
	} 
 
	@Override
	public Long bass0360Delete(SysIfBass0360DTO bass0360Dto) throws MSFException {
		
	   Long rtnData = 0L;
	   SysIfBass0360VO bass0360Vo = new SysIfBass0360VO();
	   String method = calledClass + ".bass0360Delete";
	   
		MSFSysm0100BM sessionUser;
		
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
	try {	
		

		bass0360Vo.setDpobCd(bass0360Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
		bass0360Vo.setDtilOccuInttnCd(bass0360Dto.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
		bass0360Vo.setTypOccuCd(bass0360Dto.getTypOccuCd());    /** column 직종코드 : typOccuCd */
		bass0360Vo.setDeptCd(bass0360Dto.getDeptCd());    /** column 부서코드 : deptCd */
 		bass0360Vo.setPayrMangDeptCd(bass0360Dto.getPayrMangDeptCd());    /** column 단위기관코드 : payrMangDeptCd */
//		bass0360Vo.setKybdr(bass0360Dto.getKybdr());    /** column 입력자 : kybdr */
//		bass0360Vo.setInptDt(bass0360Dto.getInptDt());    /** column 입력일자 : inptDt */
//		bass0360Vo.setInptAddr(bass0360Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//		bass0360Vo.setIsmt(bass0360Dto.getIsmt());    /** column 수정자 : ismt */
//		bass0360Vo.setRevnDt(bass0360Dto.getRevnDt());    /** column 수정일자 : revnDt */
//		bass0360Vo.setRevnAddr(bass0360Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
 
		sysIfBass0360Dao.updateBass0360(bass0360Vo);
		
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
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		rtnData = 1L;
	}catch(Exception e){
		e.printStackTrace();
		rtnData = 0L;
		throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
	}
	
		return rtnData;
	}

	  
	 
	@Override
	public Long bass0360Insert(SysIfBass0360DTO bass0360Dto) throws MSFException {
		
		String method = calledClass + ".bass0360Insert";
		
		MSFSysm0100BM sessionUser;
		
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		Long rtnData = 0L;
		SysIfBass0360VO bass0360Vo = new SysIfBass0360VO();
		
		try {
			
			bass0360Vo.setDpobCd(bass0360Dto.getDpobCd());    					/** column 사업장코드 : dpobCd */
			bass0360Vo.setDtilOccuInttnCd(bass0360Dto.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
			bass0360Vo.setTypOccuCd(bass0360Dto.getTypOccuCd());   	 			/** column 직종코드 : typOccuCd */
			bass0360Vo.setDeptCd(bass0360Dto.getDeptCd());    					/** column 부서코드 : deptCd */
 			bass0360Vo.setPayrMangDeptCd(bass0360Dto.getPayrMangDeptCd());    	/** column 단위기관코드 : payrMangDeptCd */
//			bass0360Vo.setKybdr(bass0360Dto.getKybdr());    /** column 입력자 : kybdr */
//			bass0360Vo.setInptDt(bass0360Dto.getInptDt());    /** column 입력일자 : inptDt */
//			bass0360Vo.setInptAddr(bass0360Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//			bass0360Vo.setIsmt(bass0360Dto.getIsmt());    /** column 수정자 : ismt */
//			bass0360Vo.setRevnDt(bass0360Dto.getRevnDt());    /** column 수정일자 : revnDt */
//			bass0360Vo.setRevnAddr(bass0360Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
			 	
		   	 
		   	sysIfBass0360Dao.updateBass0360(bass0360Vo);
		   	
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
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
			
		   	
		   	rtnData = 1L;
		}catch(Exception e){
			e.printStackTrace();
			rtnData = 0L;
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}

		return rtnData;
	}


	 
}
