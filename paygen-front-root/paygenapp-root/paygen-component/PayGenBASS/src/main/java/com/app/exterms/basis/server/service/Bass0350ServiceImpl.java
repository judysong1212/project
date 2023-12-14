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

import com.app.exterms.basis.client.dto.Bass0350DTO;
import com.app.exterms.basis.client.service.Bass0350Service;
import com.app.exterms.basis.server.service.dao.Bass0350DAO;
import com.app.exterms.basis.server.vo.Bass0350VO;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
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

@Service("Bass0350Service")
public class Bass0350ServiceImpl extends AbstractCustomServiceImpl implements	BasisDaoConstants, Bass0350Service {
	
	private static final Logger logger = LoggerFactory.getLogger(Bass0350ServiceImpl.class);
	private static final String calledClass = Bass0350ServiceImpl.class.getName();
	
	
	@Autowired
	@Resource(name = "Bass0350DAO")
	private Bass0350DAO bass0350DAO;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectBass0350List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_BASS0350_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        Bass0350DTO srhDto = new Bass0350DTO();
        
        if(MSFSharedUtils.paramNull(bass0350DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
        	bass0350DAO = (Bass0350DAO) wac.getBean("Bass0350DAO");
        }
        try{
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    		
            String srhDpobCd = sessionUser.getDpobCd();
            String srhTypOccuCd = MSFServerUtils.getFilterValue(columnFilters, "srhTypOccuCd") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhTypOccuCd"));
            String srhDtilOccuClsNm = MSFServerUtils.getFilterValue(columnFilters, "srhDtilOccuClsNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDtilOccuClsNm"));
            String srhDtilOccuClsUseYn = MSFServerUtils.getFilterValue(columnFilters, "srhDtilOccuClsUseYn") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDtilOccuClsUseYn")); //사용여부 검색조건 추가
            srhDto.setDpobCd(srhDpobCd);
            srhDto.setTypOccuCd(srhTypOccuCd);
            srhDto.setDtilOccuClsNm(srhDtilOccuClsNm);
            srhDto.setDtilOccuClsUseYn(srhDtilOccuClsUseYn);	//사용여부 검색조건 추가
            
            if (pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = bass0350DAO.selectBass0350ListTotCnt(srhDto);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectBass0350List = SmrmfUtils.startTiming(logger);
            
            srhDto.setPageSize(pagingValues.totalRecordCount);
            if (pagingValues.start > 0){
            	srhDto.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	srhDto.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = bass0350DAO.selectBass0350List(srhDto);
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = String.valueOf(map.get("dpobCd"))+String.valueOf(map.get("typOccuCd"))+String.valueOf(map.get("dtilOccuClsDivCd"));
                
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0350List, "selectBass0350List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }
        return retval;
    }
	
	
	
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public String saveBass0350(Bass0350DTO dto, ActionDatabase actionDatabase) throws MSFException {
		
		int returnCnt = 0;
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".saveBass0350";
		
		String windowNm = "직종세관리";
		String windowId = "BASS0350";
		
		Bass0350VO bass0350vo = new Bass0350VO();
		
		if("".equals(dto.getDpobCd()) || dto.getDpobCd() == null){
			dto.setDpobCd(sessionUser.getDpobCd());
		}
		dto.setIsmt(sessionUser.getUsrId());
		dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		bass0350vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd())); /** set 사업장코드 : dpobCd *///
		bass0350vo.setTypOccuCd(dto.getTypOccuCd());
		bass0350vo.setDtilOccuClsNm(dto.getDtilOccuClsNm());
		
		//직종세 유무 파악
		int iCount2 = bass0350DAO.selectBassP035001ListTotCnt(bass0350vo);
				
		try {
			switch(actionDatabase){
				case INSERT :
					if(iCount2 > 0){
						MSFErrorMessage errMsg1 = new MSFErrorMessage("","", 2,"동일한 직종세가 존재하고 있습니다. 다시 확인해주세요."); 
	        			throw MSFServerUtils.getValidationException("saveBass0350_bass0350DAO.selectBassP035001ListTotCnt(bass0350vo)", errMsg1, logger) ;						
					}else{
						bass0350DAO.insertBass0350(dto);
						bass0350DAO.updateChrBass0350(dto);
						returnCnt = 1;						
					}					
					break;
				case UPDATE : 
					returnCnt = bass0350DAO.updateBass0350(dto);
					break;
				case DELETE : returnCnt = bass0350DAO.deleteBass0350(dto);
					break;
				}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
			
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),e, windowNm , windowId);
			throw MSFServerUtils.getOperationException(this.getClass().getName() + " " + "직종세 생성 오류 발생 <br> 관리자에게 문의해 주세요.", e, logger);
			
		}
		return returnCnt+"";
	}
}
