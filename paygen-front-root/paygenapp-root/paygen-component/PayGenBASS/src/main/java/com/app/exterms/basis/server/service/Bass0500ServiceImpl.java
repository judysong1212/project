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
package com.app.exterms.basis.server.service;

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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.basis.client.dto.Bass0500DTO;
import com.app.exterms.basis.client.service.Bass0500Service;
import com.app.exterms.basis.server.service.dao.Bass0500DAO;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Bass0500Service")
public class Bass0500ServiceImpl extends AbstractCustomServiceImpl implements
		BasisDaoConstants, Bass0500Service {
	
	private static final Logger logger = LoggerFactory.getLogger(Bass0500ServiceImpl.class);
	private static final String calledClass = Bass0500ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "Bass0500DAO")
	private Bass0500DAO bass0500DAO;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectBass0500List(ServiceParameters serviceParameters) throws Exception {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_BASS0500_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        Bass0500DTO srhDto = new Bass0500DTO();
        
        if(MSFSharedUtils.paramNull(bass0500DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
        	bass0500DAO = (Bass0500DAO) wac.getBean("Bass0500DAO");
        }
        
        
        try{
        	
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    		
//            String srhDeptCd = MSFServerUtils.getFilterValue(columnFilters, "srhDeptCd") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDeptCd"));
//            String srhBusinApptnYr = MSFServerUtils.getFilterValue(columnFilters, "srhBusinApptnYr") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhBusinApptnYr"));
//            String srhBusinNm = MSFServerUtils.getFilterValue(columnFilters, "srhBusinNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhBusinNm"));
            
            
            String srhDpobCd = sessionUser.getDpobCd();
            String srhDeptCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "srhDeptCd"));
            String srhBusinApptnYr = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "srhBusinApptnYr"));
            String srhBusinNm = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "srhBusinNm"));
            
            
            srhDto.setDpobCd(srhDpobCd);
            srhDto.setDeptCd(srhDeptCd);
            srhDto.setBusinApptnYr(srhBusinApptnYr);
            srhDto.setBusinNm(srhBusinNm);
            
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	
            	int iResultCnt = bass0500DAO.selectBass0500ListTotCnt(srhDto);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
            	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
            	
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            
            TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
            
            srhDto.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	srhDto.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	srhDto.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = bass0500DAO.selectBass0500List(srhDto);
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            
            
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = String.valueOf(map.get("dpobCd"))+String.valueOf(map.get("deptCd")+String.valueOf(map.get("businApptnYr")+String.valueOf(map.get("businCd"))));
                
                BaseModel bm = new BaseModel();
                
                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }
                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                
                bmResult.add(bm);
            }
            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0400List, "selectBass0500List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }
	
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public String saveBass0500(Bass0500DTO dto, ActionDatabase actionDatabase) throws Exception {
		
		String method = calledClass + ".saveBass0500";
		
		String windowNm = "부서별사업관리";
		String windowId = "BASS0500";

		
		int returnCnt = 0;
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		if("".equals(dto.getDpobCd()) || dto.getDpobCd() == null){
			dto.setDpobCd(sessionUser.getDpobCd());
		}
		dto.setIsmt(sessionUser.getUsrId()); 
		dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		try {
			switch(actionDatabase){
				case INSERT :returnCnt = bass0500DAO.saveBass0500(dto);
					break;
				case UPDATE : returnCnt = bass0500DAO.saveBass0500(dto);
					break;
				case DELETE : returnCnt = bass0500DAO.deleteBass0500(dto);
					break;
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),e, windowNm , windowId);
				
		}
		return returnCnt+"";
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BaseModel> getBass0400List() throws Exception {
		
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".getBass0400List";
		
		String windowNm = "부서별사업관리";
		String windowId = "BASS0400";
		
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		String srhDpobCd = sessionUser.getDpobCd();
		
		try{
			Bass0500DTO dto = new Bass0500DTO();
			dto.setDpobCd(srhDpobCd);
			
			egovResultDataList = bass0500DAO.getBass0400List(dto);
			
			
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");		
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					BaseModel bm = new BaseModel();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		bm.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		bm.set(key, tempMap.get(key));
		            	}
		            }
					returnValue.add(bm);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		return returnValue;
	}
	
	
	/** 생성된 사업의 년도를 가져옴 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BaseModel> getBass0500BusinYrList() throws MSFException {
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".getBass0500BusinYrList";
		

		String windowNm = "부서별사업관리";
		String windowId = "BASS0500";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		try{
			Bass0500DTO dto = new Bass0500DTO();
			
			dto.setDpobCd(sessionUser.getDpobCd());
			
			egovResultDataList = bass0500DAO.getCreBass0500BusinYrList(dto);
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					BaseModel bm = new BaseModel();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		bm.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		bm.set(key, tempMap.get(key));
		            	}
		            }
					returnValue.add(bm);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		return returnValue;
	}

	
  
}
