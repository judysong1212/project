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
import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0150Service;
import com.app.exterms.prgm.server.service.dao.PrgmComBass0120DAO;
import com.app.exterms.prgm.server.service.dao.PrgmComBass0150DAO;
import com.app.exterms.prgm.server.vo.PrgmComBass0150SrhVO;
import com.app.exterms.prgm.server.vo.PrgmComBass0150VO;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
@Service("PrgmComBass0150Service")  
public class PrgmComBass0150ServiceImpl extends AbstractCustomServiceImpl implements PrgmComBass0150Service ,PrgmComDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(PrgmComBass0150ServiceImpl.class);
	private static final String calledClass = PrgmComBass0150ServiceImpl.class.getName();

	 
	@Autowired 
    @Resource(name="PrgmComBass0150DAO")
    private PrgmComBass0150DAO bass0150DAO;
 
	/**
	 * 일반 콤보형태 처리 
	 * @param sysComBass0150Dto
	 * @return
	 * @throws MSFException
	 */
	  
	public List<BaseModel> getPrgmComComboBass0150List(PrgmComBass0150DTO sysComBass0150Dto) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getPrgmComComboBass0150List";
        PrgmComBass0150SrhVO  sysComBass0150SrhVO = new PrgmComBass0150SrhVO();
        PrgmComBass0150VO sysComBass0150VO = new PrgmComBass0150VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        
        try {
        	
        	bass0150DAO = (PrgmComBass0150DAO)BeanFinder.getBean("PrgmComBass0150DAO");
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
           
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
 	        
        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                     ,new ColumnAttribute("payrMangDeptCd", "payrMangDeptCd", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("payrMangDeptNm", "payrMangDeptNm", ColumnDef.TYPE_STRING) };
        	
        	 
            //Get paging configuration
           // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
        	sysComBass0150SrhVO.setDpobCd(sessionUser.getDpobCd());
         
        	//권한 처리 루틴 추가 2015-11-13 
        	String chkPayrMangDept = sessionUser.getAuthCheck().getAuthCheck01();
            if ("FALSE".equals(chkPayrMangDept)) {
            	sysComBass0150SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
            } else {
            	sysComBass0150SrhVO.setPayrMangDeptCd("");
            }
          
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        //    if ( pagingValues.executeRecordCount ) { 
	            	
//                //Execute query that returns a single value
//                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//                 
//                int iResultCnt =  bass0150DAO.selectBass0150ListTotCnt(sysComBass0150SrhVO);  
//              
//                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
         //       pagingValues.totalRecordCount = iResultCnt;	       
                
         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         //  }
        
            TimingInfo millisBeginSelectComboBass0150List = SmrmfUtils.startTiming(logger);
        
        	 

            /**페이지 카운트 처리를 위한 부분 */ 
          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
           // 	sysComSrhVo.setFirstIndex(pagingValues.start);
           // }
           // if (pagingValues.offsetLimit > 0) {
           // 	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            sysComBass0150SrhVO.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = bass0150DAO.selectBass0150List(sysComBass0150SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payrMangDeptCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectComboBass0150List, "getPrgmComComboBass0150List");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return bmResult;
    }
	
	  
		/**
		 * 팝업형태 나 콤보 형태를 공통 rpc 로직을 호출 하여 처리 할 경우 
		 * @param serviceParameters
		 * @return
		 * @throws MSFException
		 */ 
	
		public PagingLoadResult<BaseModel> getPrgmComLookBass0150List(ServiceParameters serviceParameters) throws MSFException {

			    PagingLoadResult<BaseModel> retval = null;
		        String method = "getPrgmComComboBass0150List";
		        PrgmComBass0150SrhVO  sysComBass0150SrhVO = new PrgmComBass0150SrhVO();
		        PrgmComBass0150VO sysComBass0150VO = new PrgmComBass0150VO();
		        List<BaseModel> bmResult = new ArrayList<BaseModel>();
		        
		        try {
		        	
		        	bass0150DAO = (PrgmComBass0150DAO)BeanFinder.getBean("PrgmComBass0150DAO");
		            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
		        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		           
		            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
		            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
		            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
		            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
		 
		 	        
//		        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
//		                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
//		                     ,new ColumnAttribute("payrMangDeptCd", "payrMangDeptCd", ColumnDef.TYPE_STRING)
//		                      ,new ColumnAttribute("payMangeDeptNm", "payMangeDeptNm", ColumnDef.TYPE_STRING) };
		        	
		        	 
		            //Get paging configuration
		            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

		            //Get query parameters
		           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
		           
		            /** 조건절 */
		        	sysComBass0150SrhVO.setDpobCd(sessionUser.getDpobCd());
		        	
		        	//권한 처리 루틴 추가 2015-11-13 
		        	String chkPayrMangDept = sessionUser.getAuthCheck().getAuthCheck01();
		            if ("FALSE".equals(chkPayrMangDept)) {
		            	sysComBass0150SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
		            } else {
		            	sysComBass0150SrhVO.setPayrMangDeptCd("");
		            }
		            
		            //Get total record count //전체 데이터 갯수를 가지고 온다. 
			     if ( pagingValues.executeRecordCount ) { 
			            	
		                //Execute query that returns a single value
		                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		                int iResultCnt =  bass0150DAO.selectBass0150ListTotCnt(sysComBass0150SrhVO);  
		              
		                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
		                pagingValues.totalRecordCount = iResultCnt;	       
		                
		                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
		           }
		        
		            TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);
		         

		            /**페이지 카운트 처리를 위한 부분 */ 
		            sysComBass0150SrhVO.setPageSize(pagingValues.totalRecordCount);  
		            
		            //Apply paging
		            if (pagingValues.start > 0) {
		            	sysComBass0150SrhVO.setFirstIndex(pagingValues.start);
		            }
		            if (pagingValues.totalRecordCount < 100) {
		            	sysComBass0150SrhVO.setLastIndex(pagingValues.totalRecordCount); 
		            } else if (pagingValues.offsetLimit > 0) {
		            	sysComBass0150SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
		            }

		            //Execute query and convert to BaseModel list
		            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
		            
		            @SuppressWarnings("unchecked")
//		            Collection<Map<String, Object>> list ??????
		            List list = bass0150DAO.selectBass0150List(sysComBass0150SrhVO);
		            
			        Iterator<Map<String, Object>> iter = list.iterator();
			            
		            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		            while ( iter.hasNext() ) {
		                Map<String, Object> map = (Map<String, Object>) iter.next();
		                String idValue = map.get("dpobCd").toString()+map.get("payrMangDeptCd").toString();
		                BaseModel bm = new BaseModel();
 
		                //bm.setProperties(map);
		                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
		                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
		                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
		                    bm.set(tableAttributes[i].getName(), baseModelValue);
		                }

		                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
		                bmResult.add(bm);
		            } 

		            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
		            
	                SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "selectBass0150List");
		       
	 
		        }
		        catch (Exception ex) {
		        	ex.printStackTrace();
		            //Return operation exception
		            throw MSFServerUtils.getOperationException(method, ex, logger);
		        }

		        return retval;
		    }
		
	 
 
}
