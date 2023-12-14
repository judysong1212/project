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

import com.app.exterms.basis.client.dto.Bass0150DTO;
import com.app.exterms.basis.client.service.Bass0150Service;
import com.app.exterms.basis.server.service.dao.Bass0150DAO;
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
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Bass0150Service")
public class Bass0150ServiceImpl  extends AbstractCustomServiceImpl implements  BasisDaoConstants , Bass0150Service  {

	private static final Logger logger = LoggerFactory.getLogger(Bass0150ServiceImpl.class);
	private static final String calledClass = Bass0150ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name="Bass0150DAO")
	private Bass0150DAO bass0150DAO;
	    

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectBass0150List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_BASS0150_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        Bass0150DTO srhDto = new Bass0150DTO();
        
        if(MSFSharedUtils.paramNull(bass0150DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
        	bass0150DAO = (Bass0150DAO) wac.getBean("Bass0150DAO");
        }
        try{
        	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            String srhPayMangeDeptNm = MSFServerUtils.getFilterValue(columnFilters, "srhPayrMangeDeptNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhPayrMangeDeptNm"));
            String srhDegtrResnRegnNum = MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm"));
            
            srhDto.setPayMangeDeptNm(srhPayMangeDeptNm);
            srhDto.setDegtrNm(srhDegtrResnRegnNum);
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = bass0150DAO.selectBass0150ListTotCnt(srhDto);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);
            
            srhDto.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	srhDto.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	srhDto.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = bass0150DAO.selectBass0150List(srhDto);
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            
            
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("dpobCdPayrMangDeptCd").toString();
                
                BaseModel bm = new BaseModel();
                
                for ( int i=0 ; i<tableAttributes.length ; i++ ) {

                	if(	"degtrResnRegnNum".equals(tableAttributes[i].getName())) {

                		String rrnDecCrypt = "";

                		// TODO 주민번호
                		nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
                		rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("degtrResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

                		String strValue = rrnDecCrypt;
                		bm.set(tableAttributes[i].getName(), strValue);
                	}else{	
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                	}
                }
                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                
                bmResult.add(bm);
            }
            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "selectBass0150List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }

	@SuppressWarnings("incomplete-switch")
	@Override
	public String saveBass0150(Bass0150DTO dto, ActionDatabase actionDatabase) throws MSFException {
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".saveBass0150";
		
		String windowNm = "단위기관관리";
		String windowId = "BASS0150";
		
		int returnCnt = 0;
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		dto.setIsmt(sessionUser.getUsrId());
		dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		String extName = "";
		//이미지명
		
		dto.setDegtrResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getDegtrResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		
		if (MSFSharedUtils.paramNotNull(dto.getPayMangeDeptSealFlNm())) {
		  extName = dto.getPayrMangDeptCd().concat(dto.getPayMangeDeptSealFlNm().substring(dto.getPayMangeDeptSealFlNm().lastIndexOf("."), dto.getPayMangeDeptSealFlNm().length()));
		}  
		dto.setPayMangeDeptSealFlNm(extName);
		
		try {
			switch(actionDatabase){
				case INSERT : returnCnt = bass0150DAO.saveBass0150(dto);
					break;
				case UPDATE : returnCnt = bass0150DAO.saveBass0150(dto);
					break;
				case DELETE : returnCnt = bass0150DAO.deleteBass0150(dto);
					break;
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
		} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), ex, windowNm, windowId);
				
				throw MSFServerUtils.getOperationException(calledClass, ex, logger);
		}
		return returnCnt+"";
	}

	//징수의무자 콤보박스
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BaseModel> getDpobCd() throws MSFException {

		String method = calledClass + ".getDpobCd";
		MSFSysm0100BM sessionUser;

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		try{
			
			egovResultDataList = bass0150DAO.getDpobCd();
			
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

   
	
}
