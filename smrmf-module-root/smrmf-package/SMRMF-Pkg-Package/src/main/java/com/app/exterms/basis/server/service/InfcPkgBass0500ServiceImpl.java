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

import org.apache.commons.beanutils.BeanUtilsBean;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.basis.client.dto.InfcPkgBass0500DTO;
import com.app.exterms.basis.client.service.InfcPkgBass0500Service;
import com.app.exterms.basis.shared.PkgBasisDaoConstantsGenerated;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
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
import com.app.smrmf.infc.basis.server.service.dao.InfcPkgBass0500DAO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0500SrhVO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0500VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
 

@Service("InfcPkgBass0500Service")
public class InfcPkgBass0500ServiceImpl extends AbstractCustomServiceImpl implements PkgBasisDaoConstantsGenerated, InfcPkgBass0500Service {
	
	private static final Logger logger = LoggerFactory.getLogger(InfcPkgBass0500ServiceImpl.class);
	private static final String calledClass = InfcPkgBass0500ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "InfcPkgBass0500DAO")
	private InfcPkgBass0500DAO bass0500DAO;
 
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BaseModel> getYearList() throws Exception {
		
		String method = calledClass + ".getYearList";
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		String srhDpobCd = sessionUser.getDpobCd();
		
		 if  (MSFSharedUtils.paramNull(bass0500DAO)) {
		        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO"); 
	        }
		 
		
		try{
			InfcPkgBass0500DTO dto = new InfcPkgBass0500DTO();
			dto.setDpobCd(srhDpobCd);
			
			egovResultDataList = bass0500DAO.getYearList(dto);
			
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
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
//		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");	
		
		return returnValue;
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BaseModel> getBass0500BusinYrList() throws MSFException {
		
		String method = calledClass + ".getBass0500BusinYrList";
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		 if  (MSFSharedUtils.paramNull(bass0500DAO)) {
		        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO"); 
	     }
		 
		try{
			InfcPkgBass0500DTO dto = new InfcPkgBass0500DTO();
			
			dto.setDpobCd(sessionUser.getDpobCd());
			
			egovResultDataList = bass0500DAO.getCreBass0500BusinYrList(dto);
			
			
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
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
//		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return returnValue;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta2070ToBass0500OnList(ServiceParameters serviceParameters) throws Exception  {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_YETA2070_BASS0500_ON_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        InfcPkgBass0500SrhVO srhVo = new InfcPkgBass0500SrhVO();
        
        System.out.println("Bass0500Def test...");
        if(MSFSharedUtils.paramNull(bass0500DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
        	bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
        }
        
        
        try{
        	
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    		
            String srhDpobCd = sessionUser.getDpobCd();
            String srhUntDpobCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobCd"));
            String srhDeptCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
            
            
            srhVo.setDpobCd(srhDpobCd);
            srhVo.setDeptCd(srhDeptCd);
            srhVo.setUntDpobCd(srhUntDpobCd);
            srhVo.setBusinApptnYr("2017");
			srhVo.setBusinUseYn("Y");
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	
            	int iResultCnt = bass0500DAO.selectYeta2017ToBass0500OnListTotCnt(srhVo);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
            	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
            	
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            
            TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
            
            srhVo.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	srhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = bass0500DAO.selectYeta2017ToBass0500OnList(srhVo);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta3070ToBass0500OnList(ServiceParameters serviceParameters) throws Exception  {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_YETA2070_BASS0500_ON_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        InfcPkgBass0500SrhVO srhVo = new InfcPkgBass0500SrhVO();
        
        System.out.println("Bass0500Def test...");
        if(MSFSharedUtils.paramNull(bass0500DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
        	bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
        }
        
        
        try{
        	
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    		
            String srhDpobCd = sessionUser.getDpobCd();
            String srhUntDpobCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobCd"));
            String srhDeptCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
            
            
            srhVo.setDpobCd(srhDpobCd);
            srhVo.setDeptCd(srhDeptCd);
            srhVo.setUntDpobCd(srhUntDpobCd);
            srhVo.setBusinApptnYr("2018");
			srhVo.setBusinUseYn("Y");
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	
            	int iResultCnt = bass0500DAO.selectYeta2017ToBass0500OnListTotCnt(srhVo);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
            	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
            	
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            
            TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
            
            srhVo.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	srhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = bass0500DAO.selectYeta2017ToBass0500OnList(srhVo);
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
	
	//2019년
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta4070ToBass0500OnList(ServiceParameters serviceParameters) throws Exception  {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_YETA2070_BASS0500_ON_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        InfcPkgBass0500SrhVO srhVo = new InfcPkgBass0500SrhVO();
        
        System.out.println("Bass0500Def test...");
        if(MSFSharedUtils.paramNull(bass0500DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
        	bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
        }
        
        
        try{
        	
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    		
            String srhDpobCd = sessionUser.getDpobCd();
            String srhUntDpobCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobCd"));
            String srhDeptCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
            
            
            srhVo.setDpobCd(srhDpobCd);
            srhVo.setDeptCd(srhDeptCd);
            srhVo.setUntDpobCd(srhUntDpobCd);
            srhVo.setBusinApptnYr("2019");
			srhVo.setBusinUseYn("Y");
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	
            	int iResultCnt = bass0500DAO.selectYeta2017ToBass0500OnListTotCnt(srhVo);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
            	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
            	
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            
            TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
            
            srhVo.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	srhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = bass0500DAO.selectYeta2017ToBass0500OnList(srhVo);
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
	
	//2020년
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta5070ToBass0500OnList(ServiceParameters serviceParameters) throws Exception  {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_YETA2070_BASS0500_ON_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        InfcPkgBass0500SrhVO srhVo = new InfcPkgBass0500SrhVO();
        
        System.out.println("Bass0500Def test...");
        if(MSFSharedUtils.paramNull(bass0500DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
        	bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
        }
        
        
        try{
        	
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    		
            String srhDpobCd = sessionUser.getDpobCd();
            String srhUntDpobCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobCd"));
            String srhDeptCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
            
            
            srhVo.setDpobCd(srhDpobCd);
            srhVo.setDeptCd(srhDeptCd);
            srhVo.setUntDpobCd(srhUntDpobCd);
            srhVo.setBusinApptnYr("2020");
			srhVo.setBusinUseYn("Y");
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	
            	int iResultCnt = bass0500DAO.selectYeta2017ToBass0500OnListTotCnt(srhVo);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
            	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
            	
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            
            TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
            
            srhVo.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	srhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = bass0500DAO.selectYeta2017ToBass0500OnList(srhVo);
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
	
	
	//2021년
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public PagingLoadResult<BaseModel> getSelectYeta6070ToBass0500OnList(ServiceParameters serviceParameters) throws Exception  {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_YETA2070_BASS0500_ON_LIST;
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        InfcPkgBass0500SrhVO srhVo = new InfcPkgBass0500SrhVO();
	        
	        System.out.println("Bass0500Def test...");
	        if(MSFSharedUtils.paramNull(bass0500DAO)){
	        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	        	bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
	        }
	        
	        
	        try{
	        	
	        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
	            
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
	            
	            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    		
	            String srhDpobCd = sessionUser.getDpobCd();
	            String srhUntDpobCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobCd"));
	            String srhDeptCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
	            
	            
	            srhVo.setDpobCd(srhDpobCd);
	            srhVo.setDeptCd(srhDeptCd);
	            srhVo.setUntDpobCd(srhUntDpobCd);
	            srhVo.setBusinApptnYr("2021");
				srhVo.setBusinUseYn("Y");
	            
	            if ( pagingValues.executeRecordCount ) { 
	            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	            	
	            	int iResultCnt = bass0500DAO.selectYeta2017ToBass0500OnListTotCnt(srhVo);
	            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	            	
		          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	            	
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	            
	            TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
	            
	            srhVo.setPageSize(pagingValues.totalRecordCount);
	            if( pagingValues.start > 0){
	            	srhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	            }
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            List list = bass0500DAO.selectYeta2017ToBass0500OnList(srhVo);
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
		
		
		//2022년
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public PagingLoadResult<BaseModel> getSelectYeta7070ToBass0500OnList(ServiceParameters serviceParameters) throws Exception  {

			        PagingLoadResult<BaseModel> retval = null;
			        String method =  CLASS_YETA2070_BASS0500_ON_LIST;
			        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			        InfcPkgBass0500SrhVO srhVo = new InfcPkgBass0500SrhVO();
			        
			        System.out.println("Bass0500Def test...");
			        if(MSFSharedUtils.paramNull(bass0500DAO)){
			        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			        	bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
			        }
			        
			        
			        try{
			        	
			        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
			            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
			            
			            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
			            
			            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			    		
			            String srhDpobCd = sessionUser.getDpobCd();
			            String srhUntDpobCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobCd"));
			            String srhDeptCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
			            
			            
			            srhVo.setDpobCd(srhDpobCd);
			            srhVo.setDeptCd(srhDeptCd);
			            srhVo.setUntDpobCd(srhUntDpobCd);
			            srhVo.setBusinApptnYr("2022");
						srhVo.setBusinUseYn("Y");
			            
			            if ( pagingValues.executeRecordCount ) { 
			            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
			            	
			            	int iResultCnt = bass0500DAO.selectYeta2017ToBass0500OnListTotCnt(srhVo);
			            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
			            	
				          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
			                if (!pagingValues.pageExecute) { 
			                    pagingValues.offsetLimit = iResultCnt;       
			                }
			            	
			                pagingValues.totalRecordCount = iResultCnt;	       
			                
			                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			            }
			            
			            TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
			            
			            srhVo.setPageSize(pagingValues.totalRecordCount);
			            if( pagingValues.start > 0){
			            	srhVo.setFirstIndex(pagingValues.start);
			            }
			            if (pagingValues.offsetLimit > 0) {
			            	srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			            }
			            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			            
			            List list = bass0500DAO.selectYeta2017ToBass0500OnList(srhVo);
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
				
				
				//2023년
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public PagingLoadResult<BaseModel> getSelectYeta8070ToBass0500OnList(ServiceParameters serviceParameters) throws Exception  {

			        PagingLoadResult<BaseModel> retval = null;
			        String method =  CLASS_YETA2070_BASS0500_ON_LIST;
			        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			        InfcPkgBass0500SrhVO srhVo = new InfcPkgBass0500SrhVO();
			        
			        System.out.println("Bass0500Def test...");
			        if(MSFSharedUtils.paramNull(bass0500DAO)){
			        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			        	bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
			        }
			        
			        
			        try{
			        	
			        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
			            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
			            
			            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
			            
			            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			    		
			            String srhDpobCd = sessionUser.getDpobCd();
			            String srhUntDpobCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobCd"));
			            String srhDeptCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
			            
			            
			            srhVo.setDpobCd(srhDpobCd);
			            srhVo.setDeptCd(srhDeptCd);
			            srhVo.setUntDpobCd(srhUntDpobCd);
			            srhVo.setBusinApptnYr("2022");
						srhVo.setBusinUseYn("Y");
			            
			            if ( pagingValues.executeRecordCount ) { 
			            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
			            	
			            	int iResultCnt = bass0500DAO.selectYeta2017ToBass0500OnListTotCnt(srhVo);
			            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
			            	
				          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
			                if (!pagingValues.pageExecute) { 
			                    pagingValues.offsetLimit = iResultCnt;       
			                }
			            	
			                pagingValues.totalRecordCount = iResultCnt;	       
			                
			                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			            }
			            
			            TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
			            
			            srhVo.setPageSize(pagingValues.totalRecordCount);
			            if( pagingValues.start > 0){
			            	srhVo.setFirstIndex(pagingValues.start);
			            }
			            if (pagingValues.offsetLimit > 0) {
			            	srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			            }
			            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			            
			            List list = bass0500DAO.selectYeta2017ToBass0500OnList(srhVo);
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
		
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta2070ToBass0500OffList(ServiceParameters serviceParameters) throws Exception  {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2070_BASS0500_OFF_LIST;
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		InfcPkgBass0500SrhVO srhVo = new InfcPkgBass0500SrhVO();
		
		if(MSFSharedUtils.paramNull(bass0500DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
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
			String srhDeptCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
			
			srhVo.setDpobCd(srhDpobCd);
			srhVo.setDeptCd(srhDeptCd);
			srhVo.setBusinApptnYr("2017");
			srhVo.setBusinUseYn("Y");
			
			
			if ( pagingValues.executeRecordCount ) { 
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				
				int iResultCnt = bass0500DAO.selectYeta2017ToBass0500OffListTotCnt(srhVo);
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
				
				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}
				
				pagingValues.totalRecordCount = iResultCnt;	       
				
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
			
			TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
			
			srhVo.setPageSize(pagingValues.totalRecordCount);
			if( pagingValues.start > 0){
				srhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			
			List list = bass0500DAO.selectYeta2017ToBass0500OffList(srhVo);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta3070ToBass0500OffList(ServiceParameters serviceParameters) throws Exception  {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2070_BASS0500_OFF_LIST;
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		InfcPkgBass0500SrhVO srhVo = new InfcPkgBass0500SrhVO();
		
		if(MSFSharedUtils.paramNull(bass0500DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
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
			String srhDeptCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
			
			srhVo.setDpobCd(srhDpobCd);
			srhVo.setDeptCd(srhDeptCd);
			srhVo.setBusinApptnYr("2018");
			srhVo.setBusinUseYn("Y");
			
			
			if ( pagingValues.executeRecordCount ) { 
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				
				int iResultCnt = bass0500DAO.selectYeta2017ToBass0500OffListTotCnt(srhVo);
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
				
				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}
				
				pagingValues.totalRecordCount = iResultCnt;	       
				
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
			
			TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
			
			srhVo.setPageSize(pagingValues.totalRecordCount);
			if( pagingValues.start > 0){
				srhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			
			List list = bass0500DAO.selectYeta2017ToBass0500OffList(srhVo);
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
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta4070ToBass0500OffList(ServiceParameters serviceParameters) throws Exception  {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2070_BASS0500_OFF_LIST;
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		InfcPkgBass0500SrhVO srhVo = new InfcPkgBass0500SrhVO();
		
		if(MSFSharedUtils.paramNull(bass0500DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
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
			String srhDeptCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
			
			srhVo.setDpobCd(srhDpobCd);
			srhVo.setDeptCd(srhDeptCd);
			srhVo.setBusinApptnYr("2019");
			srhVo.setBusinUseYn("Y");
			
			
			if ( pagingValues.executeRecordCount ) { 
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				
				int iResultCnt = bass0500DAO.selectYeta2017ToBass0500OffListTotCnt(srhVo);
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
				
				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}
				
				pagingValues.totalRecordCount = iResultCnt;	       
				
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
			
			TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
			
			srhVo.setPageSize(pagingValues.totalRecordCount);
			if( pagingValues.start > 0){
				srhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			
			List list = bass0500DAO.selectYeta2017ToBass0500OffList(srhVo);
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
	
	
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta5070ToBass0500OffList(ServiceParameters serviceParameters) throws Exception  {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2070_BASS0500_OFF_LIST;
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		InfcPkgBass0500SrhVO srhVo = new InfcPkgBass0500SrhVO();
		
		if(MSFSharedUtils.paramNull(bass0500DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
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
			String srhDeptCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
			
			srhVo.setDpobCd(srhDpobCd);
			srhVo.setDeptCd(srhDeptCd);
			srhVo.setBusinApptnYr("2020");
			srhVo.setBusinUseYn("Y");
			
			
			if ( pagingValues.executeRecordCount ) { 
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				
				int iResultCnt = bass0500DAO.selectYeta2017ToBass0500OffListTotCnt(srhVo);
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
				
				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}
				
				pagingValues.totalRecordCount = iResultCnt;	       
				
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
			
			TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
			
			srhVo.setPageSize(pagingValues.totalRecordCount);
			if( pagingValues.start > 0){
				srhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			
			List list = bass0500DAO.selectYeta2017ToBass0500OffList(srhVo);
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
	
	
	//---------------------------------------------------------------2021
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta6070ToBass0500OffList(ServiceParameters serviceParameters) throws Exception  {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2070_BASS0500_OFF_LIST;
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		InfcPkgBass0500SrhVO srhVo = new InfcPkgBass0500SrhVO();
		
		if(MSFSharedUtils.paramNull(bass0500DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
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
			String srhDeptCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
			
			srhVo.setDpobCd(srhDpobCd);
			srhVo.setDeptCd(srhDeptCd);
			srhVo.setBusinApptnYr("2021");
			srhVo.setBusinUseYn("Y");
			
			
			if ( pagingValues.executeRecordCount ) { 
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				
				int iResultCnt = bass0500DAO.selectYeta2017ToBass0500OffListTotCnt(srhVo);
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
				
				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}
				
				pagingValues.totalRecordCount = iResultCnt;	       
				
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
			
			TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
			
			srhVo.setPageSize(pagingValues.totalRecordCount);
			if( pagingValues.start > 0){
				srhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			
			List list = bass0500DAO.selectYeta2017ToBass0500OffList(srhVo);
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
	
	//---------------------------------------------------------------2021
	
	
	
	//---------------------------------------------------------------2022
	
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public PagingLoadResult<BaseModel> getSelectYeta7070ToBass0500OffList(ServiceParameters serviceParameters) throws Exception  {
			
			PagingLoadResult<BaseModel> retval = null;
			String method =  CLASS_YETA2070_BASS0500_OFF_LIST;
			List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			InfcPkgBass0500SrhVO srhVo = new InfcPkgBass0500SrhVO();
			
			if(MSFSharedUtils.paramNull(bass0500DAO)){
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
			}
			
			
			try{
				
				ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
				IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
				List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
				PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
				
				PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
				
				MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
				
//	            String srhDeptCd = MSFServerUtils.getFilterValue(columnFilters, "srhDeptCd") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDeptCd"));
//	            String srhBusinApptnYr = MSFServerUtils.getFilterValue(columnFilters, "srhBusinApptnYr") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhBusinApptnYr"));
//	            String srhBusinNm = MSFServerUtils.getFilterValue(columnFilters, "srhBusinNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhBusinNm"));
				
				
				String srhDpobCd = sessionUser.getDpobCd();
				String srhDeptCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
				
				srhVo.setDpobCd(srhDpobCd);
				srhVo.setDeptCd(srhDeptCd);
				srhVo.setBusinApptnYr("2022");
				srhVo.setBusinUseYn("Y");
				
				
				if ( pagingValues.executeRecordCount ) { 
					TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
					
					int iResultCnt = bass0500DAO.selectYeta2017ToBass0500OffListTotCnt(srhVo);
					SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
					
					//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
					if (!pagingValues.pageExecute) { 
						pagingValues.offsetLimit = iResultCnt;       
					}
					
					pagingValues.totalRecordCount = iResultCnt;	       
					
					logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
				}
				
				TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
				
				srhVo.setPageSize(pagingValues.totalRecordCount);
				if( pagingValues.start > 0){
					srhVo.setFirstIndex(pagingValues.start);
				}
				if (pagingValues.offsetLimit > 0) {
					srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
				}
				TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
				
				List list = bass0500DAO.selectYeta2017ToBass0500OffList(srhVo);
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
		
		//---------------------------------------------------------------2022

		
		
		//---------------------------------------------------------------2023
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public PagingLoadResult<BaseModel> getSelectYeta8070ToBass0500OffList(ServiceParameters serviceParameters) throws Exception  {
			
			PagingLoadResult<BaseModel> retval = null;
			String method =  CLASS_YETA2070_BASS0500_OFF_LIST;
			List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			InfcPkgBass0500SrhVO srhVo = new InfcPkgBass0500SrhVO();
			
			if(MSFSharedUtils.paramNull(bass0500DAO)){
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
			}
			
			
			try{
				
				ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
				IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
				List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
				PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
				
				PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
				
				MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
				
//	            String srhDeptCd = MSFServerUtils.getFilterValue(columnFilters, "srhDeptCd") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDeptCd"));
//	            String srhBusinApptnYr = MSFServerUtils.getFilterValue(columnFilters, "srhBusinApptnYr") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhBusinApptnYr"));
//	            String srhBusinNm = MSFServerUtils.getFilterValue(columnFilters, "srhBusinNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhBusinNm"));
				
				
				String srhDpobCd = sessionUser.getDpobCd();
				String srhDeptCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
				
				srhVo.setDpobCd(srhDpobCd);
				srhVo.setDeptCd(srhDeptCd);
				srhVo.setBusinApptnYr("2022");
				srhVo.setBusinUseYn("Y");
				
				
				if ( pagingValues.executeRecordCount ) { 
					TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
					
					int iResultCnt = bass0500DAO.selectYeta2017ToBass0500OffListTotCnt(srhVo);
					SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
					
					//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
					if (!pagingValues.pageExecute) { 
						pagingValues.offsetLimit = iResultCnt;       
					}
					
					pagingValues.totalRecordCount = iResultCnt;	       
					
					logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
				}
				
				TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
				
				srhVo.setPageSize(pagingValues.totalRecordCount);
				if( pagingValues.start > 0){
					srhVo.setFirstIndex(pagingValues.start);
				}
				if (pagingValues.offsetLimit > 0) {
					srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
				}
				TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
				
				List list = bass0500DAO.selectYeta2017ToBass0500OffList(srhVo);
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
		
		//---------------------------------------------------------------2023

	
	


	@Override
	public Long yeta2070ToBass0500OnUpdate(List<InfcPkgBass0500DTO> listPkgBass0500Dto, ActionDatabase actionDatabase) throws MSFException {

		String method = calledClass + ".yeta2070ToBass0500OnUpdate";

		String windowNm = "주(총괄납부)사업장사업관리";
		String windowId = "YETA2070";
		
		if(MSFSharedUtils.paramNull(bass0500DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
		}
    	 
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    		
		Long retval = 0L;
    	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  

    	InfcPkgBass0500VO pkgBass0500Vo = new InfcPkgBass0500VO(); // 현근무지급여지급명세
		   
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
		
	    try {

			for (int iCnt = 0; iCnt < listPkgBass0500Dto.size(); iCnt++) {
		                
				InfcPkgBass0500DTO PkgBass0500Dto = new InfcPkgBass0500DTO(); // 연말정산대상자기본
				PkgBass0500Dto = listPkgBass0500Dto.get(iCnt);
				
				pkgBass0500Vo.setBusinCd(PkgBass0500Dto.getBusinCd());
				pkgBass0500Vo.setUntDpobCd(PkgBass0500Dto.getUntDpobCd());
				
				bass0500DAO.updateOnYeta2070ToBass0500(pkgBass0500Vo);
				
				retval = 1L;
			}
			
	        }catch (Exception ex) {
	        	 
	            logger.error("EXCEPTION calling yeta2070ToBass0500OnUpdate(): "+ex); 
	            
	            /** 에러 로그 **/			
	            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
	            
	            retval = 0L;
	            throw MSFServerUtils.getOperationException("yeta2070ToBass0500OnUpdate", ex, logger);
	        } 
	        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D"); 
	        
	        return retval;
	
	}

	@Override
	public Long yeta3070ToBass0500OnUpdate(List<InfcPkgBass0500DTO> listPkgBass0500Dto, ActionDatabase actionDatabase) throws MSFException {

		String method = calledClass + ".yeta2070ToBass0500OnUpdate";

		String windowNm = "주(총괄납부)사업장사업관리";
		String windowId = "YETA3070";
		
		if(MSFSharedUtils.paramNull(bass0500DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0500DAO = (InfcPkgBass0500DAO) wac.getBean("InfcPkgBass0500DAO");
		}
    	 
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    		
		Long retval = 0L;
    	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  

    	InfcPkgBass0500VO pkgBass0500Vo = new InfcPkgBass0500VO(); // 현근무지급여지급명세
		   
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
		
	    try {

			for (int iCnt = 0; iCnt < listPkgBass0500Dto.size(); iCnt++) {
		                
				InfcPkgBass0500DTO PkgBass0500Dto = new InfcPkgBass0500DTO(); // 연말정산대상자기본
				PkgBass0500Dto = listPkgBass0500Dto.get(iCnt);
				
				pkgBass0500Vo.setBusinCd(PkgBass0500Dto.getBusinCd());
				pkgBass0500Vo.setUntDpobCd(PkgBass0500Dto.getUntDpobCd());
				
				bass0500DAO.updateOnYeta2070ToBass0500(pkgBass0500Vo);
				
				retval = 1L;
			}
			
	        }catch (Exception ex) {
	        	 
	            logger.error("EXCEPTION calling yeta3070ToBass0500OnUpdate(): "+ex); 
	            
	            /** 에러 로그 **/			
	            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
	            
	            retval = 0L;
	            throw MSFServerUtils.getOperationException("yeta3070ToBass0500OnUpdate", ex, logger);
	        } 
	        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D"); 
	        
	        return retval;
	
	}
	
	


	@Override
	public Long yeta2070ToBass0500OffUpdate(List<InfcPkgBass0500DTO> listPkgBass0500Dto, ActionDatabase actionDatabase) throws MSFException {

		String method = calledClass + ".yeta2070ToBass0500OffUpdate";

		String windowNm = "주(총괄납부)사업장사업관리";
		String windowId = "YETA2070";
    	 
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    		
		Long retval = 0L;
    	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  

    	InfcPkgBass0500VO pkgBass0500Vo = new InfcPkgBass0500VO(); // 현근무지급여지급명세
		   
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
		
	    try {

			for (int iCnt = 0; iCnt < listPkgBass0500Dto.size(); iCnt++) {
		                
				InfcPkgBass0500DTO PkgBass0500Dto = new InfcPkgBass0500DTO(); // 연말정산대상자기본
				PkgBass0500Dto = listPkgBass0500Dto.get(iCnt);
				
				pkgBass0500Vo.setBusinCd(PkgBass0500Dto.getBusinCd());
				pkgBass0500Vo.setUntDpobCd("");
				
				bass0500DAO.updateOffYeta2070ToBass0500(pkgBass0500Vo);
				
				retval = 1L;
			}
			
	        }catch (Exception ex) {
	        	 
	            logger.error("EXCEPTION calling yeta2070ToBass0500OffUpdate(): "+ex); 
	            
	            /** 에러 로그 **/			
	            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
	            
	            retval = 0L;
	            throw MSFServerUtils.getOperationException("yeta2070ToBass0500OffUpdate", ex, logger);
	        } 
	        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D"); 
	        
	        return retval;
	
	}
	@Override
	public Long yeta3070ToBass0500OffUpdate(List<InfcPkgBass0500DTO> listPkgBass0500Dto, ActionDatabase actionDatabase) throws MSFException {

		String method = calledClass + ".yeta2070ToBass0500OffUpdate";

		String windowNm = "주(총괄납부)사업장사업관리";
		String windowId = "YETA3070";
    	 
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    		
		Long retval = 0L;
    	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  

    	InfcPkgBass0500VO pkgBass0500Vo = new InfcPkgBass0500VO(); // 현근무지급여지급명세
		   
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
		
	    try {

			for (int iCnt = 0; iCnt < listPkgBass0500Dto.size(); iCnt++) {
		                
				InfcPkgBass0500DTO PkgBass0500Dto = new InfcPkgBass0500DTO(); // 연말정산대상자기본
				PkgBass0500Dto = listPkgBass0500Dto.get(iCnt);
				
				pkgBass0500Vo.setBusinCd(PkgBass0500Dto.getBusinCd());
				pkgBass0500Vo.setUntDpobCd("");
				
				bass0500DAO.updateOffYeta2070ToBass0500(pkgBass0500Vo);
				
				retval = 1L;
			}
			
	        }catch (Exception ex) {
	        	 
	            logger.error("EXCEPTION calling yeta3070ToBass0500OffUpdate(): "+ex); 
	            
	            /** 에러 로그 **/			
	            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
	            
	            retval = 0L;
	            throw MSFServerUtils.getOperationException("yeta3070ToBass0500OffUpdate", ex, logger);
	        } 
	        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D"); 
	        
	        return retval;
	
	}  
}
