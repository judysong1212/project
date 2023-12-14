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
package com.app.smrmf.infc.sysif.msfpackage.server.service;

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
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0100DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.service.SysIfBass0100Service;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;
import com.app.smrmf.sysm.server.service.dao.SysIfBass0100DAO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0100SrhVO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0100VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.ibm.icu.math.BigDecimal;

@Service("SysIfBass0100Service")
public class SysIfBass0100ServiceImpl  extends AbstractCustomServiceImpl implements  MSFPkgDaoConstants , SysIfBass0100Service  {

	private static final Logger logger = LoggerFactory.getLogger(SysIfBass0100ServiceImpl.class);
	private static final String calledClass = SysIfBass0100ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name="SysIfBass0100DAO")
	private SysIfBass0100DAO bass0100DAO;
	    

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectBass0100List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String nResult = null;
        String method =  CLASS_SYSMUSR0050TOBASS0100_LIST;
        SysIfBass0100SrhVO   bass0100SrhVO = new SysIfBass0100SrhVO();
        //Bass0100VO      bass0100Vo = new Bass0100VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if(MSFSharedUtils.paramNull(bass0100DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
        	bass0100DAO = (SysIfBass0100DAO) wac.getBean("SysIfBass0100DAO");
        }
        try{
        	
        	
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            String srhDpobNm = MSFServerUtils.getFilterValue(columnFilters, "srhDpobNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDpobNm"));
            String srhDegtrNm = MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm"));
            
            bass0100SrhVO.setDpobNm(srhDpobNm);
            bass0100SrhVO.setDegtrNm(srhDegtrNm);
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = bass0100DAO.selectBass0100ListTotCnt(bass0100SrhVO);
            	
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectBass0100List = SmrmfUtils.startTiming(logger);
            
            bass0100SrhVO.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	bass0100SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	bass0100SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = bass0100DAO.selectBass0100List(bass0100SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0100List, "selectBass0100List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectBassM0100List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_SYSMUSR0050TOBASS0100_MLIST;
        SysIfBass0100SrhVO   bass0100SrhVO = new SysIfBass0100SrhVO();
        //Bass0100VO      bass0100Vo = new Bass0100VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        //MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if(MSFSharedUtils.paramNull(bass0100DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
        	bass0100DAO = (SysIfBass0100DAO) wac.getBean("SysIfBass0100DAO");
        }
        try{
        	
        	
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            String srhDpobNm = MSFServerUtils.getFilterValue(columnFilters, "srhDpobNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDpobNm"));
            String srhDegtrNm = MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm"));
            
            bass0100SrhVO.setDpobNm(srhDpobNm);
            bass0100SrhVO.setDegtrNm(srhDegtrNm);
            bass0100SrhVO.setMtstBusinDivCd("C0030010");	// 주사업장코드
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = bass0100DAO.selectBass0100ListTotCnt(bass0100SrhVO);
            	
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectBass0100List = SmrmfUtils.startTiming(logger);
            
            bass0100SrhVO.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	bass0100SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	bass0100SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = bass0100DAO.selectBass0100List(bass0100SrhVO);
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0100List, "selectBass0100List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectBassS0100List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_SYSMUSR0050TOBASS0100_MLIST;
        SysIfBass0100SrhVO   bass0100SrhVO = new SysIfBass0100SrhVO();
        //Bass0100VO      bass0100Vo = new Bass0100VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        //MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if(MSFSharedUtils.paramNull(bass0100DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
        	bass0100DAO = (SysIfBass0100DAO) wac.getBean("SysIfBass0100DAO");
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
            
            bass0100SrhVO.setDpobNm(srhDpobNm);
            bass0100SrhVO.setDegtrNm(srhDegtrNm);
            bass0100SrhVO.setMtstBusinDivCd("C0030020");	// 종사업장코드
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = bass0100DAO.selectBass0100ListTotCnt(bass0100SrhVO);
            	
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectBass0100List = SmrmfUtils.startTiming(logger);
            
            bass0100SrhVO.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	bass0100SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	bass0100SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = bass0100DAO.selectBass0100List(bass0100SrhVO);
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0100List, "selectBass0100List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }	
	
	
/**
	@SuppressWarnings("incomplete-switch")
	@Override
	public String saveBass0100(InfcSysIfBass0100VO dto, ActionDatabase actionDatabase)
			throws Exception {
		int returnCnt = 0;
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		dto.setIsmt(sessionUser.getUsrId());
		dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		switch(actionDatabase){
			case INSERT : returnCnt = bass0100DAO.saveBass0100(dto);
				break;
			case UPDATE : returnCnt = bass0100DAO.saveBass0100(dto);
				break;
			case DELETE : returnCnt = bass0100DAO.deleteBass0100(dto);
				break;
		
		}
		return returnCnt+"";
	}
*/	
	
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public int chkBass0100(SysIfBass0100DTO dto, ActionDatabase actionDatabase)throws MSFException {
		int returnCnt = 0;
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".saveBass0100";
		
		String windowNm = "시스템사업장관리";
		String windowId = "BASS0100";
		
		SysIfBass0100SrhVO bass0100SrhVo = new SysIfBass0100SrhVO();
		SysIfBass0100VO bass0100Vo = new SysIfBass0100VO();
		
		dto.setDegtrResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getDegtrResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
         
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		dto.setIsmt(sessionUser.getUsrId());
		dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		try {
			switch(actionDatabase){
				case INSERT : 
					
					if(dto.getMtstBusinDivCd() == "C0030010" || "C0030010".equals(dto.getMtstBusinDivCd())) {
						
						bass0100SrhVo = new SysIfBass0100SrhVO();
						bass0100SrhVo.setMtstBusinDivCd(dto.getMtstBusinDivCd());
						
						int iCnt = bass0100DAO.selectBass0100ListTotCnt(bass0100SrhVo);
						
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
	
	@SuppressWarnings("incomplete-switch")
	@Override
	public String saveBass0100(SysIfBass0100DTO dto, ActionDatabase actionDatabase)throws MSFException {
		int returnCnt = 0;
		
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		String method = calledClass + ".saveBass0100";
		 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "시스템사업장관리";
		String windowId = "SYSIFBASS0100";
		
		SysIfBass0100SrhVO bass0100SrhVo = new SysIfBass0100SrhVO();
		SysIfBass0100VO bass0100Vo = new SysIfBass0100VO();
 

		bass0100Vo.setDpobCd(MSFSharedUtils.allowNulls(dto.getDpobCd()));    /** column 사업장코드 : dpobCd */
		bass0100Vo.setDpobNm(MSFSharedUtils.allowNulls(dto.getDpobNm()));    /** column 사업장명 : dpobNm */
		bass0100Vo.setDegtrResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getDegtrResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));    /** column 대표자주민번호 : degtrResnRegnNum */
		bass0100Vo.setTplvlDpobCd(MSFSharedUtils.allowNulls(dto.getTplvlDpobCd()));    /** column null : tplvlDpobCd */
		bass0100Vo.setDegtrNm(MSFSharedUtils.allowNulls(dto.getDegtrNm()));    /** column 대표자명 : degtrNm */
		bass0100Vo.setBusoprRgstnNum(MSFSharedUtils.allowNulls(dto.getBusoprRgstnNum()));    /** column 사업자등록번호 : busoprRgstnNum */
		bass0100Vo.setCorpRgstnNum(MSFSharedUtils.allowNulls(dto.getCorpRgstnNum()));    /** column 법인등록번호 : corpRgstnNum */
		bass0100Vo.setCorpDivCd(MSFSharedUtils.allowNulls(dto.getCorpDivCd()));    /** column 법인구분코드 : corpDivCd */
		bass0100Vo.setDpobZpcd(MSFSharedUtils.allowNulls(dto.getDpobZpcd()));    /** column 사업장우편번호 : dpobZpcd */
		bass0100Vo.setDpobFndtnAddr(MSFSharedUtils.allowNulls(dto.getDpobFndtnAddr()));    /** column 사업장기본주소 : dpobFndtnAddr */
		bass0100Vo.setDpobDtlPatrAddr(MSFSharedUtils.allowNulls(dto.getDpobDtlPatrAddr()));    /** column 사업장상세주소 : dpobDtlPatrAddr */
		bass0100Vo.setDpobPhnNum(MSFSharedUtils.allowNulls(dto.getDpobPhnNum()));    /** column 사업장전화번호 : dpobPhnNum */
		bass0100Vo.setDpobFaxNum(MSFSharedUtils.allowNulls(dto.getDpobFaxNum()));    /** column 사업장팩스번호 : dpobFaxNum */
		bass0100Vo.setDpobSealWrdNm(MSFSharedUtils.allowNulls(dto.getDpobSealWrdNm()));    /** column 사업장직인문구명 : dpobSealWrdNm */
		bass0100Vo.setDpobSealRftaNm(MSFSharedUtils.allowNulls(dto.getDpobSealRftaNm()));    /** column 사업장직인경로 : dpobSealRftaNm */
		bass0100Vo.setDpobSealFlNm(MSFSharedUtils.allowNulls(dto.getDpobSealFlNm()));    /** column 사업장직인파일명 : dpobSealFlNm */
		bass0100Vo.setDpobFndtnUseYn(MSFSharedUtils.allowNulls(dto.getDpobFndtnUseYn()));    /** column 사업장기본사용여부 : dpobFndtnUseYn */
		bass0100Vo.setHlthInsrSym(MSFSharedUtils.allowNulls(dto.getHlthInsrSym()));    /** column 건강보험기호 : hlthInsrSym */
		bass0100Vo.setNatPennSym(MSFSharedUtils.allowNulls(dto.getNatPennSym()));    /** column 국민연금기호 : natPennSym */
		bass0100Vo.setUmytInsrSym(MSFSharedUtils.allowNulls(dto.getUmytInsrSym()));    /** column 고용보험기호 : umytInsrSym */
		bass0100Vo.setSysDivCd(MSFSharedUtils.allowNulls(dto.getSysDivCd()));    /** column 시스템플래그 : sysDivCd */
	
		bass0100Vo.setRetryCllnDebrDivCd(MSFSharedUtils.allowNulls(dto.getRetryCllnDebrDivCd()));    /** column 퇴직징수의무자구분코드 : retryCllnDebrDivCd */
		bass0100Vo.setInsurPrvaffAgcyIstutNum(MSFSharedUtils.allowNulls(dto.getInsurPrvaffAgcyIstutNum()));    /** column 보험사무대행기관번호 : insurPrvaffAgcyIstutNum */
		bass0100Vo.setInsurPrvaffAgcyIstutNm(MSFSharedUtils.allowNulls(dto.getInsurPrvaffAgcyIstutNm()));    /** column 보험사무대행기관명 : insurPrvaffAgcyIstutNm */
		bass0100Vo.setHlthInsrOfceSym(MSFSharedUtils.allowNulls(dto.getHlthInsrOfceSym()));    /** column 건강보험영업소기호 : hlthInsrOfceSym */
		bass0100Vo.setIdtlAccdtInsurSym(MSFSharedUtils.allowNulls(dto.getIdtlAccdtInsurSym()));    /** column 산재보험기호 : idtlAccdtInsurSym */
		bass0100Vo.setMtstBusinDivCd(MSFSharedUtils.allowNulls(dto.getMtstBusinDivCd()));    /** column 주종사업장구분코드 : mtstBusinDivCd */
		bass0100Vo.setSysDpobCd(MSFSharedUtils.allowNulls(dto.getSysDpobCd()));    /** column 시스템사업장코드 : sysDpobCd */
		bass0100Vo.setDpobEctnMailAddr(MSFSharedUtils.allowNulls(dto.getDpobEctnMailAddr()));    /** column 사업장전자우편주소 : dpobEctnMailAddr */
		
		bass0100Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
	//	bass0100Vo.setInptDt(MSFSharedUtils.allowNulls(dto.getInptDt()));    /** column 입력일자 : inptDt */
		bass0100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
		bass0100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
	//	bass0100Vo.setRevnDt(MSFSharedUtils.allowNulls(dto.getRevnDt()));    /** column 수정일자 : revnDt */
		bass0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정자주소 : revnAddr */
		 
		
		try {
			switch(actionDatabase){
				case INSERT : 
					returnCnt = bass0100DAO.saveBass0100(bass0100Vo);
					break;
				case UPDATE : returnCnt = bass0100DAO.saveBass0100(bass0100Vo);
					break;
				case DELETE : returnCnt = bass0100DAO.deleteBass0100(bass0100Vo);
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
		
		return returnCnt+"";
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
			
			egovResultDataList = bass0100DAO.getParentDpobCd();
			
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
	public List<BaseModel> getBass0100sysDivCdList() throws MSFException {
		
		String method = calledClass + ".getBass0100sysDivCdList";
		MSFSysm0100BM sessionUser;

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		try{
			egovResultDataList = bass0100DAO.selectBass0100sysDivCdList();
			
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
			
			egovResultDataList = bass0100DAO.getSysDpobCd();
			
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
