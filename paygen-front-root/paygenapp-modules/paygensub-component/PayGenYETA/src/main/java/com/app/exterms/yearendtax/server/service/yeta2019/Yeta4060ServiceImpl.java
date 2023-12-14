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
package com.app.exterms.yearendtax.server.service.yeta2019;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.app.exterms.yearendtax.client.dto.yeta2019.Yeta4060DTO;
import com.app.exterms.yearendtax.client.service.yeta2019.Yeta4060Service;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye161005_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Ye161010_2019_DAO;
import com.app.exterms.yearendtax.server.service.yeta2019.dao.Yeta4060_2019_DAO;
import com.app.exterms.yearendtax.server.vo.Ye161005_2019_VO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3060Srh_2019_VO;
import com.app.exterms.yearendtax.server.vo.Yeta3060_2019_VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstantsGenerated;
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
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.ibm.icu.math.BigDecimal;

@Service("Yeta4060Service")
public class Yeta4060ServiceImpl  extends AbstractCustomServiceImpl implements YetaDaoConstantsGenerated , Yeta4060Service  {

	private static final Logger logger = LoggerFactory.getLogger(Yeta4060ServiceImpl.class);
	private static final String calledClass = Yeta4060ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name="Yeta4060_2019_DAO")
	private Yeta4060_2019_DAO yeta4060DAO;
	
	@Autowired
	@Resource(name="Ye161005_2019_DAO")
	private Ye161005_2019_DAO ye161005DAO;
	
	@Autowired
	@Resource(name="Ye161010_2019_DAO")
	private Ye161010_2019_DAO ye161010DAO;
	    

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta4060List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String nResult = null;
        String method =  CLASS_YETA4060_LIST;
        Yeta3060Srh_2019_VO   Yeta2060SrhVO = new Yeta3060Srh_2019_VO();
        //Yeta2060VO      Yeta2060Vo = new Yeta2060VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if(MSFSharedUtils.paramNull(yeta4060DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
        	yeta4060DAO = (Yeta4060_2019_DAO) wac.getBean("Yeta4060_2019_DAO");
        }
        try{
        	
        	
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            String srhDpobNm = MSFServerUtils.getFilterValue(columnFilters, "srhDpobNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDpobNm"));
            String srhDegtrNm = MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm"));
            
            Yeta2060SrhVO.setDpobCd(sessionUser.getDpobCd());
            Yeta2060SrhVO.setUtDpobNm(srhDpobNm);
            Yeta2060SrhVO.setDegtrNm(srhDegtrNm);
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = yeta4060DAO.selectYeta4060ListTotCnt(Yeta2060SrhVO);
            	
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectYeta2060List = SmrmfUtils.startTiming(logger);
            
            Yeta2060SrhVO.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	Yeta2060SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	Yeta2060SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = yeta4060DAO.selectYeta4060List(Yeta2060SrhVO);
            
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            
            
            while ( iter.hasNext() ) {
            	

                  nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
                
                
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("dpobCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectYeta2060List, "selectYeta4060List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYetaM4060List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_YETA4060_MLIST;
        Yeta3060Srh_2019_VO   Yeta2060SrhVO = new Yeta3060Srh_2019_VO();
        //Yeta2060VO      Yeta2060Vo = new Yeta2060VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if(MSFSharedUtils.paramNull(yeta4060DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
        	yeta4060DAO = (Yeta4060_2019_DAO) wac.getBean("Yeta4060_2019_DAO");
        }
        try{
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            String srhDpobNm = MSFServerUtils.getFilterValue(columnFilters, "srhDpobNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDpobNm"));
            String srhDegtrNm = MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm"));
            
            Yeta2060SrhVO.setDpobCd(sessionUser.getDpobCd());
            Yeta2060SrhVO.setUtDpobNm(srhDpobNm);
            Yeta2060SrhVO.setDegtrNm(srhDegtrNm);
            
            if(pagingValues.executeRecordCount){ 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = yeta4060DAO.selectYeta4060ListTotCnt(Yeta2060SrhVO);
            	
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
            	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectYeta4060List = SmrmfUtils.startTiming(logger);
            
            Yeta2060SrhVO.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	Yeta2060SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	Yeta2060SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = yeta4060DAO.selectYeta4060List(Yeta2060SrhVO);
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            
            
            while ( iter.hasNext() ) {
            	
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("dpobCd").toString();
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
    	            	
    	          		case ColumnDef.TYPE_STRING: 
    	          			
    	          			
    	          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
       			
    	                	if(	"degtrResnRegnNum".equals(tableAttributes[i].getName())) {
    	          			
    	                		String rrnDecCrypt = "";
    	          			
    	          			  	// TODO 주민번호
    	          				nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("degtrResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
    	          			
    	          				strValue = rrnDecCrypt;
    	          			 	bm.set(tableAttributes[i].getName(), strValue);
    	                	}else{
    	                		Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
    	                		map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
    	                		bm.set(tableAttributes[i].getName(), baseModelValue);
    	                	}
     	                       
    		            map.put(tableAttributes[i].getName(), strValue);
    		                    
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

//                	if(	"degtrResnRegnNum".equals(tableAttributes[i].getName())) {
//
//                		String rrnDecCrypt = "";
//
//                		// TODO 주민번호
//                		nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//                		rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("degtrResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//
//                		String strValue = rrnDecCrypt;
//                		bm.set(tableAttributes[i].getName(), strValue);
//                	}else{
//                		Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//                				map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//                		bm.set(tableAttributes[i].getName(), baseModelValue);
//                	}
                }
                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            }
            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);
            
            SmrmfUtils.endTiming(logger, millisBeginSelectYeta4060List, "selectYeta4060List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYetaS4060List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_YETA4060_MLIST;
        Yeta3060Srh_2019_VO   Yeta2060SrhVO = new Yeta3060Srh_2019_VO();
        //Yeta2060VO      Yeta2060Vo = new Yeta2060VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if(MSFSharedUtils.paramNull(yeta4060DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
        	yeta4060DAO = (Yeta4060_2019_DAO) wac.getBean("Yeta4060_2019_DAO");
        }
        try{
        	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        	
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            String srhDpobNm = MSFServerUtils.getFilterValue(columnFilters, "srhDpobNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDpobNm"));
            String srhDegtrNm = MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm"));
            
            Yeta2060SrhVO.setDpobCd(sessionUser.getDpobCd());
            Yeta2060SrhVO.setUtDpobNm(srhDpobNm);
            Yeta2060SrhVO.setDegtrNm(srhDegtrNm);
//            Yeta2060SrhVO.setMtstBusinDivCd("C0040020");	// 종사업장코드
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = yeta4060DAO.selectYeta4060ListTotCnt(Yeta2060SrhVO);
            	
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectYeta4060List = SmrmfUtils.startTiming(logger);
            
            Yeta2060SrhVO.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	Yeta2060SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	Yeta2060SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = yeta4060DAO.selectYeta4060List(Yeta2060SrhVO);
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            
            
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("dpobCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectYeta4060List, "selectYeta4060List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYetaM406001List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_YETA4060_MLIST;
        Yeta3060Srh_2019_VO   Yeta2060SrhVO = new Yeta3060Srh_2019_VO();
        //Yeta2060VO      Yeta2060Vo = new Yeta2060VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if(MSFSharedUtils.paramNull(yeta4060DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
        	yeta4060DAO = (Yeta4060_2019_DAO) wac.getBean("Yeta4060_2019_DAO");
        }
        try{
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            String srhUtDpobCd = MSFServerUtils.getFilterValue(columnFilters, "srhDpobCdm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDpobNm"));
            
            Yeta2060SrhVO.setDpobCd(sessionUser.getDpobCd());
            Yeta2060SrhVO.setMtstBusinDivCd("C0030010");	// 주사업장코드
            
            if(pagingValues.executeRecordCount){ 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = yeta4060DAO.selectYetaM406001ListTotCnt(Yeta2060SrhVO);
            	
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
            	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectYeta2060List = SmrmfUtils.startTiming(logger);
            
            Yeta2060SrhVO.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	Yeta2060SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	Yeta2060SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = yeta4060DAO.selectYetaM406001List(Yeta2060SrhVO);
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            
            
            while ( iter.hasNext() ) {
            	
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("dpobCd").toString();
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
    	            	
    	          		case ColumnDef.TYPE_STRING: 
    	          			
    	          			
    	          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
       			
    	                	if(	"degtrResnRegnNum".equals(tableAttributes[i].getName())) {
    	          			
    	                		String rrnDecCrypt = "";
    	          			
    	          			  	// TODO 주민번호
    	          				nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("degtrResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
    	          			
    	          				strValue = rrnDecCrypt;
    	          			 	bm.set(tableAttributes[i].getName(), strValue);
    	                	}else{
    	                		Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
    	                		map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
    	                		bm.set(tableAttributes[i].getName(), baseModelValue);
    	                	}
     	                       
    		            map.put(tableAttributes[i].getName(), strValue);
    		                    
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectYeta2060List, "selectYeta4060List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYetaS406001List(ServiceParameters serviceParameters) throws MSFException {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA4060_MLIST;
		Yeta3060Srh_2019_VO   Yeta2060SrhVO = new Yeta3060Srh_2019_VO();
		//Yeta2060VO      Yeta2060Vo = new Yeta2060VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if(MSFSharedUtils.paramNull(yeta4060DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
			yeta4060DAO = (Yeta4060_2019_DAO) wac.getBean("Yeta4060_2019_DAO");
		}
		try{
			ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
			PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
			
			PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
			
			String srhUtDpobCd = MSFServerUtils.getFilterValue(columnFilters, "utDpobCd") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "utDpobCd"));
            
            Yeta2060SrhVO.setDpobCd(sessionUser.getDpobCd());
            Yeta2060SrhVO.setMtstBusinDivCd("C0030010");	// 주사업장코드
            Yeta2060SrhVO.setUtDpobCd(srhUtDpobCd);
			
			if(pagingValues.executeRecordCount){ 
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				int iResultCnt = yeta4060DAO.selectYetaS406001ListTotCnt(Yeta2060SrhVO);
				
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}
				pagingValues.totalRecordCount = iResultCnt;	       
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
			TimingInfo millisBeginSelectYeta2060List = SmrmfUtils.startTiming(logger);
			
			Yeta2060SrhVO.setPageSize(pagingValues.totalRecordCount);
			if( pagingValues.start > 0){
				Yeta2060SrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				Yeta2060SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			
			List list = yeta4060DAO.selectYetaS406001List(Yeta2060SrhVO);
			Iterator<Map<String, Object>> iter = list.iterator();
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
			
			
			while ( iter.hasNext() ) {
				
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = map.get("dpobCd").toString();
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
						
					case ColumnDef.TYPE_STRING: 
						
						
						String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
						
						if(	"degtrResnRegnNum".equals(tableAttributes[i].getName())) {
							
							String rrnDecCrypt = "";
							
							// TODO 주민번호
							nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("degtrResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
							
							strValue = rrnDecCrypt;
							bm.set(tableAttributes[i].getName(), strValue);
						}else{
							Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
									map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
							bm.set(tableAttributes[i].getName(), baseModelValue);
						}
						
						map.put(tableAttributes[i].getName(), strValue);
						
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
			
			SmrmfUtils.endTiming(logger, millisBeginSelectYeta2060List, "selectYeta4060List");
			
		}catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		
		return retval;
		
	}	
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public int chkYeta4060(Yeta4060DTO dto, ActionDatabase actionDatabase)throws MSFException {
		
		int returnCnt = 0;
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".saveYeta4060";
		
		String windowNm = "사업장관리";
		String windowId = "Yeta4060";
		
		Yeta3060Srh_2019_VO Yeta2060SrhVo = new Yeta3060Srh_2019_VO();

		System.out.println("DegtrResnRegnNum 이전 ---" +dto.getDegtrResnRegnNum() );
		
		dto.setDegtrResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getDegtrResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
        
		System.out.println("DegtrResnRegnNum 이후 ----" +dto.getDegtrResnRegnNum() );
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		dto.setIsmt(sessionUser.getUsrId());
		dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		try {
			switch(actionDatabase){
				case INSERT : 
					
					if(dto.getMtstBusinDivCd() == "C0030010" || "C0030010".equals(dto.getMtstBusinDivCd())) {
						Yeta2060SrhVo = new Yeta3060Srh_2019_VO();
						Yeta2060SrhVo.setMtstBusinDivCd(dto.getMtstBusinDivCd());
						
						int iCnt = yeta4060DAO.selectYeta4060ListTotCnt(Yeta2060SrhVo);
						
						if(iCnt > 0) {
							returnCnt = 1;
						}else {
							returnCnt = 0;
						}
						
					}
					
					break;
			} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), e, windowNm, windowId);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
		
		return returnCnt;
		
	}
	
	
	/** 삭제 방어 로직 **/
	@Override
	public int delChkYeta4060(Yeta4060DTO dto, ActionDatabase actionDatabase)throws MSFException {
		
		int returnCnt = 0;
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".delChkYeta4060";
		
		String windowNm = "단위사업장등록관리";
		String windowId = "Yeta4060";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		Ye161010Srh_2019_VO ye161005SrhVo = new Ye161010Srh_2019_VO();
		
		ye161005SrhVo.setDpobCd(dto.getDpobCd());
		ye161005SrhVo.setYrtxBlggYr(dto.getYrtxBlggYr());
		ye161005SrhVo.setClutSeptCd(dto.getClutSeptCd());
		ye161005SrhVo.setUtDpobCd(dto.getUtDpobCd());	
        
		
		
		try {
						
			int iCnt = ye161010DAO.selectYeta4060ToYe161010ListTotCnt(ye161005SrhVo);

			if (iCnt > 0) {
				returnCnt = 1;
			} else {
				returnCnt = 0;
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), e, windowNm, windowId);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
		
		return returnCnt;
		
	}
	
	
	
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public String saveYeta4060(Yeta4060DTO dto, ActionDatabase actionDatabase)throws MSFException {
		
		int returnCnt = 0;
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".saveYeta4060";
		
		String windowNm = "사업장관리";
		String windowId = "Yeta4060";
		
		Ye161005_2019_VO ye161005Vo = new Ye161005_2019_VO();

		dto.setDegtrResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getDegtrResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		dto.setDpobCd(sessionUser.getDpobCd());
		dto.setKybdr(sessionUser.getUsrId());
		dto.setIsmt(sessionUser.getUsrId());
		dto.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		
		/** Ye161005 Table Insert Dto set Start*/
		ye161005Vo.setDpobCd(sessionUser.getDpobCd());
		ye161005Vo.setWhdgTxRegrstDeptCd(MSFSharedUtils.allowNulls(dto.getWhdgTxRegrstDeptCd()));
		ye161005Vo.setHhrkWhdgRegrstDeptCd(MSFSharedUtils.allowNulls(dto.getWhdgTxRegrstDeptCd()));
		ye161005Vo.setTxOffcCd("");
		ye161005Vo.setPentrSeptCd("");
		
		ye161005Vo.setTxDeptyMangeNum("");
		ye161005Vo.setHmtxId("");
		ye161005Vo.setTxPgmCd("");
		ye161005Vo.setBusoprRgstnum(MSFSharedUtils.allowNulls(dto.getBusoprRgstnNum().replaceAll("-","")));
		ye161005Vo.setCorpFmnmNm(MSFSharedUtils.allowNulls(dto.getUtDpobNm()));
		
		ye161005Vo.setPernChrgDeptNm("");
		ye161005Vo.setPernChrgNm("");
		ye161005Vo.setPernChrgPhnNum("");
		ye161005Vo.setUseHanCd("");
		ye161005Vo.setSumtTgtPridCd("");
		
		ye161005Vo.setCorpNum(MSFSharedUtils.allowNulls(dto.getCorpRgstnNum()));
		ye161005Vo.setIncmPost(MSFSharedUtils.allowNulls(dto.getUntDpobZpcd()));
		ye161005Vo.setIncmAddr(MSFSharedUtils.allowNulls(dto.getUntDpobFndtnAddr()));
		ye161005Vo.setIncmAdtl(MSFSharedUtils.allowNulls(dto.getUntDpobDtlPatrAddr()));		
		ye161005Vo.setKybdr(MSFSharedUtils.allowNulls(dto.getKybdr()));
		
		ye161005Vo.setInptAddr(MSFSharedUtils.allowNulls(dto.getInptAddr()));
		ye161005Vo.setIsmt(MSFSharedUtils.allowNulls(dto.getIsmt()));
		ye161005Vo.setRevnAddr(MSFSharedUtils.allowNulls(dto.getRevnAddr()));		
		ye161005Vo.setReprName(MSFSharedUtils.allowNulls(dto.getDegtrNm()));
		
		ye161005Vo.setResuNumb(MSFSharedUtils.allowNulls(dto.getDegtrResnRegnNum()));
		ye161005Vo.setYetaC171("Y".equals(dto.getUpDpobUtynC171()) ? "1" : "2");
		ye161005Vo.setYetaC172("0000");
		ye161005Vo.setClutSeptCd("Y0020010");
		ye161005Vo.setYrtxBlggYr("2019");
		
		/** Ye161005 Table Insert Dto set End */
		
		try {			
			switch(actionDatabase){
				case INSERT : 
					returnCnt = yeta4060DAO.saveYeta4060(dto);
					ye161005DAO.insertYe161005(ye161005Vo);
					break;
				case UPDATE : 
					returnCnt = yeta4060DAO.saveYeta4060(dto);
					ye161005DAO.updateYe161005(ye161005Vo);
					break;
				case DELETE : 
					returnCnt = yeta4060DAO.deleteYeta4060(dto);
					ye161005DAO.deleteYe161005(ye161005Vo);
					break;
			} 
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), e, windowNm, windowId);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
		
		return returnCnt + "";
	}	

	//상위사업장
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BaseModel> getParentDpobCd() throws MSFException {
		
		String method = calledClass + ".getParentDpobCd";
		MSFSysm0100BM sessionUser;

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		try{
			
			egovResultDataList = yeta4060DAO.getParentDpobCd();
			
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
	

	
	//적용시스템
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BaseModel> getYeta4060sysDivCdList() throws MSFException {
		
		String method = calledClass + ".getYeta4060sysDivCdList";
		MSFSysm0100BM sessionUser;

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		try{
			egovResultDataList = yeta4060DAO.selectYeta4060sysDivCdList();
			
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
	
	
	
	/** 시스템 사업장 코드 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<BaseModel> getSysDpobCd() throws MSFException {
		
		String method = calledClass + ".getSysDpobCd";
		MSFSysm0100BM sessionUser;

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		try{
			
			egovResultDataList = yeta4060DAO.getSysDpobCd();
			
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
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public int insertYetaS406001(Yeta4060DTO dto, ActionDatabase actionDatabase)throws MSFException {
		int returnCnt = 0;
				
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".insertYetaS406001";
		
		String windowNm = "사업장관리";
		String windowId = "Yeta4060";
		
		Yeta3060_2019_VO Yeta4060Vo = new Yeta3060_2019_VO();
		Ye161005_2019_VO ye161005Vo = new Ye161005_2019_VO();

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		
		try {
			
			Yeta4060Vo.setDpobCd(sessionUser.getDpobCd());
			Yeta4060Vo.setUtDpobCd(MSFSharedUtils.allowNulls(dto.getUtDpobCd()));
			Yeta4060Vo.setHhrkUntDpobCd(MSFSharedUtils.allowNulls(dto.getHhrkUntDpobCd()));
			Yeta4060Vo.setBusoprRgstnNum(MSFSharedUtils.allowNulls(dto.getBusoprRgstnNum()));
			Yeta4060Vo.setBefBusoprRgstnNum(MSFSharedUtils.allowNulls(dto.getBefBusoprRgstnNum()));
			Yeta4060Vo.setMtstBusinDivCd("C0030020");
			Yeta4060Vo.setIsmt(sessionUser.getUsrId());
			Yeta4060Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			returnCnt = yeta4060DAO.insertYetaS406001(Yeta4060Vo);
			
			ye161005Vo.setDpobCd(sessionUser.getDpobCd());
			ye161005Vo.setWhdgTxRegrstDeptCd(MSFSharedUtils.allowNulls(dto.getUtDpobCd()));
			ye161005Vo.setHhrkWhdgRegrstDeptCd(MSFSharedUtils.allowNulls(dto.getHhrkUntDpobCd()));
			ye161005Vo.setIsmt(sessionUser.getUsrId());
			ye161005Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			ye161005DAO.insertYetaS206001ToYe161005(ye161005Vo);
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), e, windowNm, windowId);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
		
		return returnCnt;
	}

	@Override
	public Long Yeta406001_Delete(List<Yeta4060DTO> listYeta4060Dto,ActionDatabase actionDatabase) throws MSFException {
    	
		String method = calledClass + ".Yeta406001_Delete";

		String windowNm = "주(총괄납부)사업장관리";
		String windowId = "YETA406001";
    	 
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    		
		Long retval = 0L;
    	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  

    	Yeta3060_2019_VO ye2060Vo = new Yeta3060_2019_VO(); // 현근무지급여지급명세
    	Ye161005_2019_VO ye161005Vo = new Ye161005_2019_VO();
		   
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
		
	    try {

			for (int iCnt = 0; iCnt < listYeta4060Dto.size(); iCnt++) {
		                
				Yeta4060DTO ye2060Dto = new Yeta4060DTO(); // 연말정산대상자기본
				ye2060Dto = listYeta4060Dto.get(iCnt);
				
				ye2060Vo.setDpobCd(sessionUser.getDpobCd());
				ye2060Vo.setUtDpobCd(MSFSharedUtils.allowNulls(ye2060Dto.getUtDpobCd()));
				ye2060Vo.setHhrkUntDpobCd(ye2060Dto.getHhrkUntDpobCd());
				ye2060Vo.setBusoprRgstnNum(ye2060Dto.getBusoprRgstnNum());
				ye2060Vo.setMtstDpobSeilNumC172(ye2060Dto.getMtstDpobSeilNumC172());
				ye2060Vo.setBefBusoprRgstnNum(ye2060Dto.getBefBusoprRgstnNum());
				ye2060Vo.setIsmt(sessionUser.getUsrId());
				ye2060Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				yeta4060DAO.deleteYeta406001(ye2060Vo);
				
				ye161005Vo.setDpobCd(sessionUser.getDpobCd());
				ye161005Vo.setWhdgTxRegrstDeptCd(MSFSharedUtils.allowNulls(ye2060Dto.getUtDpobCd()));
				ye161005Vo.setHhrkWhdgRegrstDeptCd(MSFSharedUtils.allowNulls(ye2060Dto.getUtDpobCd()));
				ye161005Vo.setYetaC172("");
				ye161005Vo.setIsmt(sessionUser.getUsrId());
				ye161005Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				ye161005DAO.deleteYeta406001ToYe161005(ye161005Vo);
				
				retval = 1L;
			}
			
	        }catch (Exception ex) {
	        	 
	            logger.error("EXCEPTION calling Yeta4100ToYe160401_Delete(): "+ex); 
	            
	            /** 에러 로그 **/			
	            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
	            
	            retval = 0L;
	            throw MSFServerUtils.getOperationException("Yeta4100ToYe160401_Delete", ex, logger);
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
	public Long Yeta406001NumUpdate(List<Yeta4060DTO> listYeta4060Dto,ActionDatabase actionDatabase) throws MSFException {
		String method = calledClass + ".Yeta406001NumUpdate";

		String windowNm = "주(총괄납부)사업장관리";
		String windowId = "YETA406001";
    	 
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    		
		Long retval = 0L;
    	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  

    	Yeta3060_2019_VO ye2060Vo = new Yeta3060_2019_VO(); // 현근무지급여지급명세
    	Ye161005_2019_VO ye161005Vo = new Ye161005_2019_VO();
		   
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
		
	    try {

			for (int iCnt = 0; iCnt < listYeta4060Dto.size(); iCnt++) {
		                
				Yeta4060DTO ye4060Dto = new Yeta4060DTO(); // 연말정산대상자기본
				ye4060Dto = listYeta4060Dto.get(iCnt);
				
				ye2060Vo.setDpobCd(sessionUser.getDpobCd());
				ye2060Vo.setUtDpobCd(ye4060Dto.getUtDpobCd());
				ye2060Vo.setMtstDpobSeilNumC172(ye4060Dto.getMtstDpobSeilNumC172());
				ye2060Vo.setIsmt(sessionUser.getUsrId());
				ye2060Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				yeta4060DAO.updateNumYetaS406001(ye2060Vo);
				
				ye161005Vo.setDpobCd(sessionUser.getDpobCd());
				ye161005Vo.setWhdgTxRegrstDeptCd(ye4060Dto.getUtDpobCd());
				ye161005Vo.setYetaC172(ye4060Dto.getMtstDpobSeilNumC172());
				ye161005Vo.setIsmt(sessionUser.getUsrId());
				ye161005Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				ye161005DAO.updateNumYetaS206001ToYe161005(ye161005Vo);
				
				retval = 1L;
			}
			
	        }catch (Exception ex) {
	        	 
	            logger.error("EXCEPTION calling Yeta4100ToYe160401_Delete(): "+ex); 
	            
	            /** 에러 로그 **/			
	            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
	            
	            retval = 0L;
	            throw MSFServerUtils.getOperationException("Yeta4100ToYe160401_Delete", ex, logger);
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
