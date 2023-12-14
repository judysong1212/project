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
package com.app.smrmf.sysauth.systemmtr.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.sysauth.systemmtr.client.service.SysmMtr0300Service;
import com.app.smrmf.sysauth.systemmtr.shared.SysmMtrDaoConstants;
import com.app.smrmf.sysm.server.service.dao.Sysm0300DAO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0300SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0300VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("SysmMtr0300Service")
public class SysmMtr0300ServiceImpl extends AbstractCustomServiceImpl implements  SysmMtrDaoConstants ,SysmMtr0300Service {

	private static final Logger logger = LoggerFactory.getLogger(SysmMtr0300ServiceImpl.class);
	private static final String calledClass = SysmMtr0300ServiceImpl.class.getName();
	
 
	@Autowired 
    @Resource(name="Sysm0300DAO")
    private Sysm0300DAO sysm0300DAO;
    
    /** ID Generation */
    //@Resource(name="{egovSysm0300IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

    public List<BaseModel> activityOnVoceMenuProfile(ServiceParameters serviceParameters) {
    	
    	   String method = calledClass + ".activityOnVoceMenuProfile";
	     
    	   List<BaseModel> lsBmResult = new ArrayList<BaseModel>();
	       String result = "1";  
	       
	       List<BaseModel> listObjects       = serviceParameters.getDataObjects();
	       ActionDatabase actionDatabase     = serviceParameters.getActionDatabase(); 
	       String customMethodName           = serviceParameters.getCustomMethodName();
	       ColumnAttribute[] tableAttributes = serviceParameters.getTableAttributes();
	       Boolean reloadData                = serviceParameters.isReloadData();
	       Boolean noHistory                 = serviceParameters.isNoHistory(); 
	       
	       MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(sysm0300DAO)) {
	        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( RemoteServiceUtil.getThreadLocalRequest().getSession().getServletContext());

	        	sysm0300DAO = (Sysm0300DAO) wac.getBean("Sysm0300DAO" ); 
	        }
	        
	       try {
	             
	            for (BaseModel objectBm : listObjects) { 
	            	
	            	SysIfSysm0300VO sysm0300vo = new SysIfSysm0300VO();
	            	sysm0300vo.setSysDivCd(MSFSharedUtils.defaultNulls(objectBm.get("sysDivCd"),"EXTERM00")) ;
	            	sysm0300vo.setAuthGrpSeilNum(Long.parseLong(MSFSharedUtils.defaultNulls(objectBm.get("authGrpSeilNum"),"0")));
	            	sysm0300vo.setBusinDivCd(MSFSharedUtils.allowNulls(objectBm.get("businDivCd")));
	            	sysm0300vo.setAuthGrpNm(MSFSharedUtils.allowNulls(objectBm.get("authGrpNm")));
	            	sysm0300vo.setGrde(MSFSharedUtils.allowNulls(objectBm.get("grde")));
	            	sysm0300vo.setAuthGrpUseYn((Boolean.TRUE.equals(objectBm.get("authGrpUseYn")) ? "Y" : "N"));
	            	sysm0300vo.setGrpEpln(MSFSharedUtils.allowNulls(objectBm.get("grpEpln")));
	                 
		        	  
		            switch (actionDatabase) {
		            case INSERT: 
		            	sysm0300DAO.insertSysm0300(sysm0300vo); 
		            	break;
		            case UPDATE:  
		                sysm0300DAO.updateSysm0300(sysm0300vo); 
		                break;
		            case DELETE: 
		                sysm0300DAO.deleteSysm0300(sysm0300vo);
		                break;
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
			       	MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
		           
		   
               } 
	            
	           // lsBmResult.add(outbm);
	        }
	        catch (Exception ex) {
	            logger.error("EXCEPTION calling activityOnVoceMenuUser(): "+ex); 
	            ex.printStackTrace();
	            result = "0";
	        }
	        finally {
	          
	        }
	        return lsBmResult;
	    }	

	public PagingLoadResult<BaseModel> getSelectSysmMtr0300List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_SYSMMTR0300_LIST;
        SysIfSysm0300SrhVO   sysm0300SrhVo = new SysIfSysm0300SrhVO();
        SysIfSysm0300VO      sysm0300Vo = new SysIfSysm0300VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(sysm0300DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	sysm0300DAO = (Sysm0300DAO) wac.getBean("Sysm0300DAO" ); 
        }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0300BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
            sysm0300SrhVo.setDpobCd(sessionUser.getDpobCd());  
            sysm0300SrhVo.setAuthGrpNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "authGrpNm")));
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	            if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = sysm0300DAO.selectSysm0300ListTotCnt(sysm0300SrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectSysm0300List = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            sysm0300SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	sysm0300SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	sysm0300SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = sysm0300DAO.selectSysm0300List(sysm0300SrhVo);
            
	            Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("authGrpSeilNum").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectSysm0300List, "selectSysmEx0300List");
       
        } catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	 
}
