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

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.basis.client.dto.Bass0200DTO;
import com.app.exterms.basis.client.service.Bass0200Service;
import com.app.exterms.basis.server.service.dao.Bass0200DAO;
import com.app.exterms.basis.server.vo.Bass0200SrhVO;
import com.app.exterms.basis.server.vo.Bass0200VO;
import com.app.exterms.basis.shared.BasisDaoConstants;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Bass0200Service")
public class Bass0200ServiceImpl  extends AbstractCustomServiceImpl implements  BasisDaoConstants ,Bass0200Service {
	
	private static final Logger logger = LoggerFactory.getLogger(Bass0200ServiceImpl.class);
	private static final String calledClass = Bass0200ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="Bass0200DAO")
    private Bass0200DAO bass0200DAO;
 
    /** ID Generation */
    //@Resource(name="{egovBass0200IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

 
 
	public PagingLoadResult<BaseModel> getSelectBass0200List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_BASS0200_LIST;
        Bass0200SrhVO   bass0200SrhVO = new Bass0200SrhVO();
        Bass0200VO      bass0200Vo = new Bass0200VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>(); 
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
     
        if  (MSFSharedUtils.paramNull(bass0200DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	bass0200DAO = (Bass0200DAO) wac.getBean("Bass0200DAO" ); 
        	 
        }
         
       
        try {
        	 
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0100BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            String paramValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "pubcHodyCtnt"));
            
            /** 조건절 */
            bass0200SrhVO.setDpobCd(sessionUser.getDpobCd());
            bass0200SrhVO.setPubcHodyCtnt(paramValue); 
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	       if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = bass0200DAO.selectBass0200ListTotCnt(bass0200SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            } 
        
            TimingInfo millisBeginSelectBass0200List = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            bass0200SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	bass0200SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	bass0200SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = bass0200DAO.selectBass0200List(bass0200SrhVO);
	            Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("pubcHodyDt").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0200List, "selectBass0200List");

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }

	
 public Long activityOnBass0200(Bass0200DTO bass0200Dto,  ActionDatabase actionDatabase)  throws MSFException  {
	 
	 	String method = calledClass + ".deleteHist0100";
	 	
		String windowNm = "휴일관리";
		String windowId = "BASS0200";
       
        Long result = new Long(1);
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        try {
        	Bass0200VO  bass0200Vo = new Bass0200VO();
        	
            BeanUtils.copyProperties(bass0200Vo, bass0200Dto);  
          
            bass0200Vo.setPubcHodyYn( Boolean.TRUE.equals(bass0200Dto.getPubcHodyYn()) ? "Y" : "N");
            bass0200Vo.setPaidPubcHodyYn( Boolean.TRUE.equals(bass0200Dto.getPaidPubcHodyYn()) ? "Y" : "N");
            bass0200Vo.setPubcHodyDt(bass0200Dto.getPubcHodyDt());
            Bass0200VO  bass0200ChkVo = new Bass0200VO();
            bass0200ChkVo = bass0200DAO.selectCoCalendar(bass0200Vo);
            
            if(bass0200ChkVo.getOffdayKubn().equals("1")){
            	result = new Long(2);
            }else{
            	switch (actionDatabase) { 
            	case INSERT:
            		if (MSFSharedUtils.paramNull(bass0200Vo.getDpobCd())) { 
            			bass0200Vo.setDpobCd(sessionUser.getDpobCd());     
            		}
            		bass0200DAO.insertBass0200(bass0200Vo);
            		break;
            	case UPDATE: 
            		bass0200DAO.updateBass0200(bass0200Vo);
            		break;
            	case DELETE:
            		bass0200DAO.deleteBass0200(bass0200Vo);
            		break;
            	}
            }
            
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
            MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
        }
        catch (Exception ex) {
            //logger.error("EXCEPTION calling activityOnVoceMenu(): "+ex); 
            result = new Long(0);
            ex.printStackTrace();
            
            /** 에러 로그 **/			
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),ex, windowNm , windowId);
            
            throw MSFServerUtils.getOperationException("activityOnBass0200", ex, logger);
        }
        finally {
          
        }
        return result;
    }
 
     
 
}
