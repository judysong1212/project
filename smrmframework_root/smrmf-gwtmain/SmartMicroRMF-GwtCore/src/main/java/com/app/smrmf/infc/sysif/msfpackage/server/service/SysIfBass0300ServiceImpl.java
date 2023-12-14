package com.app.smrmf.infc.sysif.msfpackage.server.service;

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
import com.app.smrmf.infc.sysif.msfpackage.client.service.SysIfBass0300Service;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;
import com.app.smrmf.sysm.server.service.dao.SysIfBass0300DAO;
import com.app.smrmf.sysm.server.service.vo.SysComSearchVO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0300VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
//import com.googlecode.ehcache.annotations.Cacheable;

/**
 * @Class Name : Bass0300ServiceImpl.java
 * @Description : Bass0300 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("SysIfBass0300Service") 
public class SysIfBass0300ServiceImpl extends AbstractCustomServiceImpl implements SysIfBass0300Service, MSFPkgDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(SysIfBass0300ServiceImpl.class);
	private static final String calledClass = SysIfBass0300ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="SysIfBass0300DAO")
    private SysIfBass0300DAO bass0300DAO;	  
    
	/**
	 * 팝업형태 공통 rpc 로직을 호출 하여 처리 할 경우 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */ 
	  
	public PagingLoadResult<BaseModel> getSelectSysmMtr0500ToBass0300List(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_SYSMMTR0500TOBASS0300_LIST;
	        SysComSearchVO   sysComSrhVo = new SysComSearchVO();
	        SysIfBass0300VO sysComBass0300Vo = new SysIfBass0300VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        bass0300DAO = (SysIfBass0300DAO)BeanFinder.getBean("SysIfBass0300DAO");
	       
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
	            sysComSrhVo.setDpobCd(sessionUser.getDpobCd()); 
	           
	            sysComSrhVo.setRpsttvCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd")));  
	            sysComSrhVo.setMangeItem01(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem01"))); 
	            sysComSrhVo.setMangeItem02(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem02"))); 
	            sysComSrhVo.setMangeItem03(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem03"))); 
	            sysComSrhVo.setMangeItem04(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem04"))); 
	            sysComSrhVo.setMangeItem05(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem05"))); 
	            sysComSrhVo.setMangeItem06(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem06"))); 
	            sysComSrhVo.setMangeItem07(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem07"))); 
	            sysComSrhVo.setMangeItem08(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem08"))); 
	            sysComSrhVo.setMangeItem09(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem09"))); 
	            sysComSrhVo.setMangeItem10(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem10"))); 
	            sysComSrhVo.setMangeItem11(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem11"))); 
	            sysComSrhVo.setMangeItem12(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem12"))); 
	            sysComSrhVo.setMangeItem13(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem13"))); 
	            sysComSrhVo.setMangeItem14(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem14"))); 
	            sysComSrhVo.setMangeItem15(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem15"))); 
	            sysComSrhVo.setMangeItem16(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem16"))); 
	            sysComSrhVo.setMangeItem17(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem17"))); 
	            sysComSrhVo.setMangeItem18(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem18"))); 
	            sysComSrhVo.setMangeItem19(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem19"))); 
	            sysComSrhVo.setMangeItem10(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem20"))); 
	            
	           	sysComSrhVo.setLastIndex(-1); 

	            TimingInfo millisBeginSelectBass0300List = SmrmfUtils.startTiming(logger);
            
	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = bass0300DAO.selectSysmMtr0500ToBass0300List(sysComSrhVo);
                
 	            Iterator<Map<String, Object>> iter = list.iterator();
 	            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("commCd").toString();
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
	            
                SmrmfUtils.endTiming(logger, millisBeginSelectBass0300List, "selectBass0300List");
	       
 
	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }
	
  
}
