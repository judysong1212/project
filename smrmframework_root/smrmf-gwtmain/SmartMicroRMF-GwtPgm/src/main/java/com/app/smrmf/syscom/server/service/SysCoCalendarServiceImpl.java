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
package com.app.smrmf.syscom.server.service;

import java.util.ArrayList;
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
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.syscom.client.dto.SysCoCalendarDTO;
import com.app.smrmf.syscom.client.service.SysCoCalendarService;
import com.app.smrmf.syscom.server.service.dao.SysCoCalendarDAO;
import com.app.smrmf.syscom.shared.SysComDaoConstants;
import com.app.smrmf.sysm.server.service.vo.SysCoCalendarSrhVO;
import com.app.smrmf.sysm.server.service.vo.SysCoCalendarVO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("SysCoCalendarService") 
public class SysCoCalendarServiceImpl extends AbstractCustomServiceImpl implements SysCoCalendarService ,SysComDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(SysCoCalendarServiceImpl.class);
	private static final String calledClass = SysCoCalendarServiceImpl.class.getName();

	 
	    @Autowired  
	    @Resource(name="SysCoCalendarDAO")
	    private SysCoCalendarDAO coCalendarDAO;
	    
	    /** ID Generation */
	    //@Resource(name="{egovCoCalendarIdGnrService}")    
	    //private EgovIdGnrService egovIdGnrService;

	    /**
		 *  콤보형태 처리 
		 * @param sysComBass0300Dto
		 * @return
		 * @throws MSFException
		 */
		public List<BaseModel> getSysComComboYearList(SysCoCalendarDTO msfCoCalendarDto) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method = "getSysComComboYearList";
	        SysCoCalendarSrhVO  msfCoCalendarSrhVo = new SysCoCalendarSrhVO();
	        SysCoCalendarVO msfCoCalendarVo = new SysCoCalendarVO();
	        List<BaseModel> bmResult = new ArrayList<BaseModel>();
	        
	        try {
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        	coCalendarDAO = (SysCoCalendarDAO)BeanFinder.getBean("SysCoCalendarDAO");
	           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
	 
	 	        
	        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
	                      new ColumnAttribute("year", "year", ColumnDef.TYPE_STRING )
	                     ,new ColumnAttribute("yearDisp", "yearDisp", ColumnDef.TYPE_STRING) };
	        	
	            //Get paging configuration
	           // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	            //Get query parameters
	           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	           
	            /** 조건절 */
	        	//msfCoCalendarSrhVo.setDpobCd(sessionUser.getDpobCd());
	          
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		        //    if ( pagingValues.executeRecordCount ) { 
		            	
//	                //Execute query that returns a single value
//	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//	                 
//	                int iResultCnt =  bass0300DAO.selectBass0300ListTotCnt(sysComSrhVo);  
//	              
//	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	         //       pagingValues.totalRecordCount = iResultCnt;	       
	                
	         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	         //  }
	        
	            TimingInfo millisBeginSelectComboYearList = SmrmfUtils.startTiming(logger);
	        
	        	 

	            /**페이지 카운트 처리를 위한 부분 */ 
	          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	           // if (pagingValues.start > 0) {
	           // 	sysComSrhVo.setFirstIndex(pagingValues.start);
	           // }
	           // if (pagingValues.offsetLimit > 0) {
	           // 	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	           // }
	            msfCoCalendarSrhVo.setLastIndex(-1); 

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = coCalendarDAO.selectCoCalendarList(msfCoCalendarSrhVo);
	            
		        Iterator<Map<String, Object>> iter = list.iterator();
		            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("year").toString();
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginSelectComboYearList, "getSysComComboYearList");
	            
	       

	        }
	        catch (Exception ex) {
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return bmResult;
	    }
 
		public List<BaseModel> getSysComComboMonthList(
				SysCoCalendarDTO msfCoCalendarDto) {

	        PagingLoadResult<BaseModel> retval = null;
	        String method = "getSysComComboMonthList";
	        SysCoCalendarSrhVO  msfCoCalendarSrhVo = new SysCoCalendarSrhVO();
	        SysCoCalendarVO msfCoCalendarVo = new SysCoCalendarVO();
	        List<BaseModel> bmResult = new ArrayList<BaseModel>();
	        
	        try {
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        	coCalendarDAO = (SysCoCalendarDAO)BeanFinder.getBean("SysCoCalendarDAO");
	           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
	 
	 	        
	        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
	                      new ColumnAttribute("month", "month", ColumnDef.TYPE_STRING )
	                     ,new ColumnAttribute("monthDisp", "monthDisp", ColumnDef.TYPE_STRING) };
	        	
	            //Get paging configuration
	           // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	            //Get query parameters
	           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	           
	            /** 조건절 */
	        	//msfCoCalendarSrhVo.setDpobCd(sessionUser.getDpobCd());
	          
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		        //    if ( pagingValues.executeRecordCount ) { 
		            	
//	                //Execute query that returns a single value
//	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//	                 
//	                int iResultCnt =  bass0300DAO.selectBass0300ListTotCnt(sysComSrhVo);  
//	              
//	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	         //       pagingValues.totalRecordCount = iResultCnt;	       
	                
	         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	         //  }
	        
	            TimingInfo millisBeginSelectComboMonthList = SmrmfUtils.startTiming(logger);
	        
	        	 

	            /**페이지 카운트 처리를 위한 부분 */ 
	          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	           // if (pagingValues.start > 0) {
	           // 	sysComSrhVo.setFirstIndex(pagingValues.start);
	           // }
	           // if (pagingValues.offsetLimit > 0) {
	           // 	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	           // }
	            msfCoCalendarSrhVo.setLastIndex(-1); 

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = coCalendarDAO.selectCoCalendarMonthList(msfCoCalendarSrhVo);
	            
		        Iterator<Map<String, Object>> iter = list.iterator();
		            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("month").toString();
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginSelectComboMonthList, "getSysComComboMonthList");
	            
	       

	        }
	        catch (Exception ex) {
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return bmResult;
		}
 
	   
 

	 
}
