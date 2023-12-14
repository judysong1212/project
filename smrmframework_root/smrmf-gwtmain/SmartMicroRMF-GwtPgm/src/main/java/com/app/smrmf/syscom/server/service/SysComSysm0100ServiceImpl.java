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
import com.app.smrmf.syscom.client.service.SysComSysm0100Service;
import com.app.smrmf.syscom.server.service.dao.SysComCmmn0320DAO;
import com.app.smrmf.syscom.shared.SysComDaoConstants;
import com.app.smrmf.sysm.server.service.dao.Sysm0100DAO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0100VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

/**
 * @Class Name : Psnl0100ServiceImpl.java
 * @Description : Psnl0100 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@Service("SysComSysm0100Service")  
public class SysComSysm0100ServiceImpl extends AbstractCustomServiceImpl implements SysComDaoConstants,SysComSysm0100Service {

	private static final Logger logger = LoggerFactory.getLogger(SysComSysm0100ServiceImpl.class);

	public SysComSysm0100ServiceImpl() {
	
	}
	    
	@Autowired
    @Resource(name="Sysm0100DAO")
    private Sysm0100DAO sysm0100DAO;
    

	public PagingLoadResult<BaseModel> getSysComPopupSysm0100List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  MSFCOM_METHOD_POPUP_SYSM0100_List;
        SysIfSysm0100SrhVO   sysComSrhVo = new SysIfSysm0100SrhVO();
        SysIfSysm0100VO     msfSysm0100VO = new SysIfSysm0100VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(sysm0100DAO)) {
//        
//        	WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//        	sysm0100DAO = (Sysm0100DAO) wac.getBean("Sysm0100DAO" ); 
//        }
        sysm0100DAO = (Sysm0100DAO)BeanFinder.getBean("Sysm0100DAO");
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
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */ 
            sysComSrhVo.setDpobCd(sessionUser.getDpobCd());  
            sysComSrhVo.setUsrDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrDivCd")));       //사용자구분코드
            sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
            sysComSrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    //검색조건처리 
            sysComSrhVo.setSearchKeyword(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "searchKeyword"),"Y")); 
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	            if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = sysm0100DAO.selectPopupSysm0100ListTotCnt(sysComSrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPsnl0100List = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	sysComSrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list  
            List list = sysm0100DAO.selectPopupSysm0100List(sysComSrhVo);
            
	       Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("usrId").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPsnl0100List, "selectPsnl0100List");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	 
}
