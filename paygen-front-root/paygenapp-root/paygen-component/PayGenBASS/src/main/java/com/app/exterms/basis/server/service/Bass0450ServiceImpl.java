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

import com.app.exterms.basis.client.dto.Bass0360DTO;
import com.app.exterms.basis.client.service.Bass0450Service;
import com.app.exterms.basis.server.service.dao.Bass0350DAO;
import com.app.exterms.basis.server.service.dao.Bass0360DAO;
import com.app.exterms.basis.server.service.dao.Bass0400DAO;
import com.app.exterms.basis.server.vo.Bass0360SrhVO;
import com.app.exterms.basis.server.vo.Bass0360VO;
import com.app.exterms.basis.server.vo.Bass0400SrhVO;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Bass0450Service")
public class Bass0450ServiceImpl extends AbstractCustomServiceImpl implements BasisDaoConstants, Bass0450Service {

	private static final Logger logger = LoggerFactory.getLogger(Bass0450ServiceImpl.class);
	private static final String calledClass = Bass0450ServiceImpl.class.getName();

	@Autowired
	@Resource(name = "Bass0400DAO")
	private Bass0400DAO bass0400DAO;
	
	@Autowired
	@Resource(name = "Bass0360DAO")
	private Bass0360DAO bass0360DAO;
	
	@Autowired
	@Resource(name = "Bass0350DAO")
	private Bass0350DAO bass0350DAO;
	 
	public PagingLoadResult<BaseModel> getSelectBass0450ToBass0400List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_BASS0450TOBASS0400_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
//      Bass0400VO bass0400Vo = new Bass0400VO();
        Bass0400SrhVO bass0400SrhVo = new Bass0400SrhVO();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if(MSFSharedUtils.paramNull(bass0400DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
        	bass0400DAO = (Bass0400DAO) wac.getBean("Bass0400DAO");
        }
        try{
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            bass0400SrhVo.setDpobCd(sessionUser.getDpobCd());
            bass0400SrhVo.setDeptNmHan(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptNmHan"))); 
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = bass0400DAO.selectBass0450ToBass0400ListTotCnt(bass0400SrhVo);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
            	if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectBass0450ToBass0400List = SmrmfUtils.startTiming(logger);
            
            bass0400SrhVo.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	bass0400SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	bass0400SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = bass0400DAO.selectBass0450ToBass0400List(bass0400SrhVo);
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            
            
            while (iter.hasNext() ) {
            	
            	Map<String, Object> map = (Map<String, Object>) iter.next();
                String deptCd = String.valueOf(map.get("deptCd"));
                
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
                bm.set(TableDef.ID_PROPERTY_NAME, deptCd);
                
                bmResult.add(bm);
            }
            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0450ToBass0400List, "getSelectBass0450ToBass0400List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }

	public PagingLoadResult<BaseModel> getSelectBass0450ToBass0360List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_BASS0450TOBASS0360_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        Bass0360SrhVO bass0360SrhVo = new Bass0360SrhVO();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        
        if(MSFSharedUtils.paramNull(bass0360DAO)){
       	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
        	bass0360DAO = (Bass0360DAO) wac.getBean("Bass0360DAO");
        }

        try{
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            bass0360SrhVo.setDpobCd(sessionUser.getDpobCd()); 
            bass0360SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
            bass0360SrhVo.setDtilOccuClsNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsNm")));
            
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = bass0360DAO.selectBass0450ToBass0360ListTotCnt(bass0360SrhVo);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
            	if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginselectBass0450ToBass0360List = SmrmfUtils.startTiming(logger);
            
            bass0360SrhVo.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	bass0360SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	bass0360SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = bass0360DAO.selectBass0450ToBass0360List(bass0360SrhVo);
            
            Iterator iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            while ( iter.hasNext() ) {
            	Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = String.valueOf(map.get("dpobCd"))+String.valueOf(map.get("deptCd"));
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
            
            SmrmfUtils.endTiming(logger, millisBeginselectBass0450ToBass0360List, "selectBass0450ToBass0360List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }

	public PagingLoadResult<BaseModel> getSelectBass0450ToBass0350List(ServiceParameters serviceParameters) throws MSFException {
		 PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_BASS0450TOBASS0350_LIST;
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        Bass0360SrhVO bass0360SrhVo = new Bass0360SrhVO();
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
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
	            
	            bass0360SrhVo.setDpobCd(sessionUser.getDpobCd()); 
	            bass0360SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	            bass0360SrhVo.setDtilOccuClsNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsNm")));
	             
	            
	            if ( pagingValues.executeRecordCount ) { 
	            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	            	int iResultCnt = bass0350DAO.selectBass0450ToBass0350ListTotCnt(bass0360SrhVo);
	            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	            	if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                pagingValues.totalRecordCount = iResultCnt;	
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	            TimingInfo millisBeginSelectBass0450ToBass0350List = SmrmfUtils.startTiming(logger);
	            
	            bass0360SrhVo.setPageSize(pagingValues.totalRecordCount);
	            if( pagingValues.start > 0){
	            	bass0360SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	bass0360SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	            }
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            List list = bass0350DAO.selectBass0450ToBass0350List(bass0360SrhVo);
	            
	            Iterator iter = list.iterator();
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
	            while ( iter.hasNext() ) {
	            	Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = String.valueOf(map.get("dpobCd"))+String.valueOf(map.get("deptCd"));
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginSelectBass0450ToBass0350List, "selectBass0450ToBass0350List");
	            
	        }catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;		
	}
	
//	 
//	@Override
//	public List<BaseModel> getBass0150List() throws MSFException {
//		List<BaseModel> returnValue = new ArrayList<BaseModel>();
//		List egovResultDataList = new ArrayList();
//		
//		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//		String srhDpobCd = sessionUser.getDpobCd();
//		
//		try{
//			Bass0400DTO dto = new Bass0400DTO();
//			dto.setDpobCd(srhDpobCd);
//			
//			egovResultDataList = bass0400DAO.getBass0150List(dto);
//			if(egovResultDataList != null && egovResultDataList.size() > 0){
//				for(int i = 0 ; i < egovResultDataList.size(); i++){
//					BaseModel bm = new BaseModel();
//					Map tempMap = (Map)egovResultDataList.get(i);
//					Iterator<String> keys = tempMap.keySet().iterator();
//					while( keys.hasNext() ){
//			            String key = keys.next();
//			            //형 타입이 숫자형일경우 형변환 해준다.
//		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
//		            		bm.set(key, String.valueOf(tempMap.get(key)));
//		            	}else{
//		            		bm.set(key, tempMap.get(key));
//		            	}
//		            }
//					returnValue.add(bm);
//				}
//			}
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
//		}
//		return returnValue;
//	}	
 
	@Override
	public Long bass0360Delete(Bass0360DTO bass0360Dto) throws MSFException {
		
	   Long rtnData = 0L;
	   Bass0360VO bass0360Vo = new Bass0360VO();
	   
	   String windowNm = "부서별직종세맵핑관리";
	   String windowId = "BASS0450";
	   
		String method = calledClass + ".bass0360Delete";
		MSFSysm0100BM sessionUser;

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
	try {	
		

		bass0360Vo.setDpobCd(bass0360Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
		bass0360Vo.setDtilOccuInttnCd(bass0360Dto.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
		bass0360Vo.setTypOccuCd(bass0360Dto.getTypOccuCd());    /** column 직종코드 : typOccuCd */
		bass0360Vo.setDeptCd(bass0360Dto.getDeptCd());    /** column 부서코드 : deptCd */
//		bass0360Vo.setPayrMangDeptCd(bass0360Dto.getPayrMangDeptCd());    /** column 단위기관코드 : payrMangDeptCd */
//		bass0360Vo.setKybdr(bass0360Dto.getKybdr());    /** column 입력자 : kybdr */
//		bass0360Vo.setInptDt(bass0360Dto.getInptDt());    /** column 입력일자 : inptDt */
//		bass0360Vo.setInptAddr(bass0360Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//		bass0360Vo.setIsmt(bass0360Dto.getIsmt());    /** column 수정자 : ismt */
//		bass0360Vo.setRevnDt(bass0360Dto.getRevnDt());    /** column 수정일자 : revnDt */
//		bass0360Vo.setRevnAddr(bass0360Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
 
		bass0360DAO.deleteBass0360(bass0360Vo);	
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D");
		
		rtnData = 1L;
	}catch(Exception e){
		e.printStackTrace();
		
		/** 에러 로그 **/			
		MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D",e, windowNm , windowId);
		
		rtnData = 0L;
		throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
	}
	
		return rtnData;
	}

	  
	 
	@Override
	public Long bass0360Insert(Bass0360DTO bass0360Dto) throws MSFException {
		
		 Long rtnData = 0L;
		 Bass0360VO bass0360Vo = new Bass0360VO();
		 
		String method = calledClass + ".bass0360Insert";
		MSFSysm0100BM sessionUser;
		
		 String windowNm = "부서별직종세맵핑관리";
		 String windowId = "BASS0450";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
			
		try {
			
			bass0360Vo.setDpobCd(bass0360Dto.getDpobCd());    					/** column 사업장코드 : dpobCd */
			bass0360Vo.setDtilOccuInttnCd(bass0360Dto.getDtilOccuInttnCd());    	/** column 직종세통합코드 : dtilOccuInttnCd */
			bass0360Vo.setTypOccuCd(bass0360Dto.getTypOccuCd());    				/** column 직종코드 : typOccuCd */
			bass0360Vo.setDeptCd(bass0360Dto.getDeptCd());    						/** column 부서코드 : deptCd */
//			bass0360Vo.setPayrMangDeptCd(bass0360Dto.getPayrMangDeptCd());    /** column 단위기관코드 : payrMangDeptCd */
//			bass0360Vo.setKybdr(bass0360Dto.getKybdr());    /** column 입력자 : kybdr */
//			bass0360Vo.setInptDt(bass0360Dto.getInptDt());    /** column 입력일자 : inptDt */
//			bass0360Vo.setInptAddr(bass0360Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//			bass0360Vo.setIsmt(bass0360Dto.getIsmt());    /** column 수정자 : ismt */
//			bass0360Vo.setRevnDt(bass0360Dto.getRevnDt());    /** column 수정일자 : revnDt */
//			bass0360Vo.setRevnAddr(bass0360Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
			 	
		   	 
		   	bass0360DAO.insertBass0360(bass0360Vo);
		   	
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C");
		   	
		   	rtnData = 1L;
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C",e, windowNm , windowId);
			
			rtnData = 0L;
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}

		return rtnData;
	}
	
	

	
}
