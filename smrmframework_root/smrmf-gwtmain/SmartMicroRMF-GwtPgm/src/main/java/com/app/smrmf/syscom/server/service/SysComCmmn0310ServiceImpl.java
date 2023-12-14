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

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.syscom.client.service.SysComCmmn0310Service;
import com.app.smrmf.syscom.server.service.dao.SysComCmmn0310DAO;
import com.app.smrmf.syscom.shared.SysComDaoConstants;

public class SysComCmmn0310ServiceImpl extends AbstractCustomServiceImpl implements  SysComDaoConstants , SysComCmmn0310Service {
	
	private static final Logger logger = LoggerFactory.getLogger(SysComCmmn0310ServiceImpl.class);

	public SysComCmmn0310ServiceImpl() {
	
	}
	    
	@Autowired
	@Resource(name="SysComCmmn0310DAO")
    private SysComCmmn0310DAO cmmn0310DAO;
	
	/**
	 * 팝업형태 나 콤보 형태를 공통 rpc 로직을 호출 하여 처리 할 경우 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */ 
//	public PagingLoadResult<BaseModel> getSysComPopupBass0300List(ServiceParameters serviceParameters) throws MSFException {
//
//	        PagingLoadResult<BaseModel> retval = null;
//	        String method =  MSFCOM_METHOD_POPUP_BASS0300_List;
//	        SysComSearchVO   sysComSrhVo = new SysComSearchVO();
//	        SysComBass0300VO sysComBass0300Vo = new SysComBass0300VO();
//	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
//	        
//	        Sysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//	        
//	        if  (MSFSharedUtils.paramNull(bass0300DAO)) {
//	        
//	        	WebApplicationContext wac = WebApplicationContextUtils.
//	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//	        	bass0300DAO = (SysComBass0300DAO) wac.getBean("SysComBass0300DAO" ); 
//	        }
//	        
//	        try {
//                //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
//	           // Sysm0100BM          user             = serviceParameters.getUser();
//	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
//	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
//	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
//	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
// 
//	            //Get paging configuration
//	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
//
//	            //Get query parameters
//	            String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
//	           
//	            /** 조건절 */
//	            sysComSrhVo.setDpobCd(sessionUser.getDpobCd());
//	            sysComSrhVo.setRpsttvCd(strCriteriaValue); 
//             
//	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
// 	            if ( pagingValues.executeRecordCount ) { 
// 	            	
//	                //Execute query that returns a single value
//	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//	                 
//	                int iResultCnt = bass0300DAO.selectBass0300ListTotCnt(sysComSrhVo);  
//	              
//	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
//	                pagingValues.totalRecordCount = iResultCnt;	       
//	                
//	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//                }
//	        
//	            TimingInfo millisBeginSelectBass0300List = SmrmfUtils.startTiming(logger);
//            
//	            /**페이지 카운트 처리를 위한 부분 */ 
//	            sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
//	            
//	            //Apply paging
//	            if (pagingValues.start > 0) {
//	            	sysComSrhVo.setFirstIndex(pagingValues.start);
//	            }
//	            if (pagingValues.offsetLimit > 0) {
//	            	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
//	            }
//	
//	            //Execute query and convert to BaseModel list
//	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//	            
//	            @SuppressWarnings("unchecked")
////	            Collection<Map<String, Object>> list ??????
//	            List list = bass0300DAO.selectBass0300List(sysComSrhVo);
//                
// 	            Iterator<Map<String, Object>> iter = list.iterator();
// 	            
//	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
//	           
//	            while ( iter.hasNext() ) {
//	                Map<String, Object> map = (Map<String, Object>) iter.next();
//	                String idValue = map.get("commCd").toString();
//	                BaseModel bm = new BaseModel();
//	
//	                //bm.setProperties(map);
//	                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
//	                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//	                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//	                    bm.set(tableAttributes[i].getName(), baseModelValue);
//	                }
//	
//	                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
//	                bmResult.add(bm);
//	            } 
//
//	            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
//	            
//                SmrmfUtils.endTiming(logger, millisBeginSelectBass0300List, "selectBass0300List");
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
}
