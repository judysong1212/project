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

import com.any.smrmf.utils.BeanFinder;
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
import com.app.smrmf.syscom.client.dto.SysComCmmn0320DTO;
import com.app.smrmf.syscom.client.service.SysComCmmn0320Service;
import com.app.smrmf.syscom.server.service.dao.SysCoCalendarDAO;
import com.app.smrmf.syscom.server.service.dao.SysComCmmn0320DAO;
import com.app.smrmf.syscom.shared.SysComDaoConstants;
import com.app.smrmf.sysm.server.service.vo.Cmmn0320SrhVO;
import com.app.smrmf.sysm.server.service.vo.Cmmn0320VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("SysComCmmn0320Service")
public class SysComCmmn0320ServiceImpl extends AbstractCustomServiceImpl implements  SysComDaoConstants , SysComCmmn0320Service {
	
	private static final Logger logger = LoggerFactory.getLogger(SysComCmmn0320ServiceImpl.class);
	private static final String calledClass = SysComCmmn0320ServiceImpl.class.getName();
	 
	@Autowired
	@Resource(name="SysComCmmn0320DAO")
    private SysComCmmn0320DAO cmmn0320DAO;
	
	/**
	 * 팝업형태 나 콤보 형태를 공통 rpc 로직을 호출 하여 처리 할 경우 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */ 
	public PagingLoadResult<BaseModel> getSysComPopupCmmn0320List(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  MSFCOM_METHOD_POPUP_CMMN0320_List;
	        Cmmn0320SrhVO   sysComCmmn0320SrhVo = new Cmmn0320SrhVO();
	        Cmmn0320VO sysComCmmn0320Vo = new Cmmn0320VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
//	        if  (MSFSharedUtils.paramNull(cmmn0320DAO)) {
//	        
//	        	WebApplicationContext wac = WebApplicationContextUtils.
//	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//	        	cmmn0320DAO = (SysComCmmn0320DAO) wac.getBean("SysComCmmn0320DAO" ); 
//	        }
	        cmmn0320DAO = (SysComCmmn0320DAO)BeanFinder.getBean("SysComCmmn0320DAO");
	        try {
                //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	           // Sysm0100BM          user             = serviceParameters.getUser();
	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
	            //Get paging configuration
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
	            /** 조건절 */ 
	            
	            
	            sysComCmmn0320SrhVo.setSearchWord(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "searchWord"))); //통합검색
	            
	           
	            sysComCmmn0320SrhVo.setRoadNmCtapv(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "roadNmCtapv"))); 
	            sysComCmmn0320SrhVo.setRoadNmCtatgu(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "roadNmCtatgu"))); 
             
	            if ("".equals(sysComCmmn0320SrhVo.getRoadNmCtapv())) {
	            	sysComCmmn0320SrhVo.setSearchWord("");
	            	sysComCmmn0320SrhVo.setRoadNmCtapv("TTTT");
	            	sysComCmmn0320SrhVo.setRoadNmCtatgu("TTTT");
	            } 
	            
	            if ("01".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "valueAttribute")))) {
	                
	                sysComCmmn0320SrhVo.setRoadNmTat(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "roadNmTat")));
	                sysComCmmn0320SrhVo.setRoadNmLi(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "roadNmLi")));
	                
	                sysComCmmn0320SrhVo.setRoadNmLtnumBobn(new BigDecimal(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "roadNmLtnumBobn"),"0"))); 
	                 
	            } else if ("02".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "valueAttribute")))) {
	                 
	                sysComCmmn0320SrhVo.setRoadNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "roadNm"))); 
                    sysComCmmn0320SrhVo.setBuildNumBobn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "buildNumBobn"))); 
	                
	            } else if ("03".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "valueAttribute")))) {
	                sysComCmmn0320SrhVo.setBuildNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "buildNm"))); 
	            }   else  {
                    
                   sysComCmmn0320SrhVo.setRoadNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "roadNm"))); 
                   sysComCmmn0320SrhVo.setBuildNumBobn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "buildNumBobn"))); 
                   
               }
	            
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
 	            if ( pagingValues.executeRecordCount ) { 
 	            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = cmmn0320DAO.selectCmmn0320ListTotCnt(sysComCmmn0320SrhVo);  
	              
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
                }
	        
	            TimingInfo millisBeginSelectCmmn0320List = SmrmfUtils.startTiming(logger);
            
	            /**페이지 카운트 처리를 위한 부분 */ 
	            sysComCmmn0320SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	sysComCmmn0320SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	sysComCmmn0320SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }
	
	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = cmmn0320DAO.selectCmmn0320List(sysComCmmn0320SrhVo);
                
 	            Iterator<Map<String, Object>> iter = list.iterator();
 	            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("zpcd").toString();
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
	            
                SmrmfUtils.endTiming(logger, millisBeginSelectCmmn0320List, "selectCmmn0320List");
	       
 
	        }
	        catch (Exception ex) { 
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }

    @Override
    public List<BaseModel> getSysComComboRoadNmCtapv(SysComCmmn0320DTO sysComCmmn0320Dto) {
        // TODO Auto-generated method stub 
        String method =  "getSysComComboRoadNmCtapv";
        Cmmn0320SrhVO   sysComCmmn0320SrhVo = new Cmmn0320SrhVO();
        Cmmn0320VO sysComCmmn0320Vo = new Cmmn0320VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(cmmn0320DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            cmmn0320DAO = (SysComCmmn0320DAO) wac.getBean("SysComCmmn0320DAO" ); 
//        }
        cmmn0320DAO = (SysComCmmn0320DAO)BeanFinder.getBean("SysComCmmn0320DAO");
        try {
          
            /** 조건절 */
            sysComCmmn0320SrhVo.setDpobCd(sessionUser.getDpobCd()); 
         
            ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                    new ColumnAttribute("roadNmCtapv", "roadNmCtapv", ColumnDef.TYPE_STRING )
                   ,new ColumnAttribute("roadNmCtapvDisp", "roadNmCtapvDisp", ColumnDef.TYPE_STRING) 
                    };
           
            TimingInfo millisBeginSelectCmmn0320List = SmrmfUtils.startTiming(logger);
         
            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//          Collection<Map<String, Object>> list ??????
            List list = cmmn0320DAO.selectCmmn0320RoadNmCtapvList(sysComCmmn0320SrhVo);
            
            Iterator<Map<String, Object>> iter = list.iterator();
            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("roadNmCtapv").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectCmmn0320List, "getSysComComboRoadNmCtapv");
       

        }
        catch (Exception ex) { 
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return bmResult;
    }

    @Override
    public List<BaseModel> getSysComComboRoadNmCtatgu(SysComCmmn0320DTO sysComCmmn0320Dto) {
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub 
        String method =  "getSysComComboRoadNmCtatgu";
        Cmmn0320SrhVO   sysComCmmn0320SrhVo = new Cmmn0320SrhVO();
        Cmmn0320VO sysComCmmn0320Vo = new Cmmn0320VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(cmmn0320DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            cmmn0320DAO = (SysComCmmn0320DAO) wac.getBean("SysComCmmn0320DAO" ); 
//        }
        cmmn0320DAO = (SysComCmmn0320DAO)BeanFinder.getBean("SysComCmmn0320DAO");
        try {
          
            /** 조건절 */ 
            sysComCmmn0320SrhVo.setRoadNmCtapv(sysComCmmn0320Dto.getRoadNmCtapv()); 
         
            ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                    new ColumnAttribute("roadNmCtatgu", "roadNmCtatgu", ColumnDef.TYPE_STRING )
                   ,new ColumnAttribute("roadNmCtatguDisp", "roadNmCtatguDisp", ColumnDef.TYPE_STRING) 
                    };
           
            TimingInfo millisBeginSelectCmmn0320List = SmrmfUtils.startTiming(logger);
         
            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//          Collection<Map<String, Object>> list ??????
            List list = cmmn0320DAO.selectCmmn0320RoadNmCtatguList(sysComCmmn0320SrhVo);
            
            Iterator<Map<String, Object>> iter = list.iterator();
            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("roadNmCtatguDisp").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectCmmn0320List, "getSysComComboRoadNmCtatgu");
       

        }
        catch (Exception ex) { 
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return bmResult;
    }
}
