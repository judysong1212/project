package com.app.exterms.prgm.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.any.smrmf.utils.BeanFinder;
import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0300Service;
import com.app.exterms.prgm.server.service.dao.PrgmComBass0150DAO;
import com.app.exterms.prgm.server.service.dao.PrgmComBass0300DAO;
import com.app.exterms.prgm.server.vo.PrgmComBass0300VO;
import com.app.exterms.prgm.server.vo.PrgmComSearchVO;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerExtAuth;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
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

@Service("PrgmComBass0300Service") 
@Transactional 
public class PrgmComBass0300ServiceImpl extends AbstractCustomServiceImpl implements PrgmComBass0300Service, PrgmComDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(PrgmComBass0300ServiceImpl.class);
	private static final String calledClass = PrgmComBass0300ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="PrgmComBass0300DAO")
    private PrgmComBass0300DAO bass0300DAO;	  
    
	/**
	 * 팝업형태 공통 rpc 로직을 호출 하여 처리 할 경우 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */ 
	  
	public PagingLoadResult<BaseModel> getPrgmComPopupBass0300List(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  PRGMCOM_METHOD_POPUP_BASS0300_List;
	        PrgmComSearchVO   sysComSrhVo = new PrgmComSearchVO();
	        PrgmComBass0300VO sysComBass0300Vo = new PrgmComBass0300VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
//	        if  (MSFSharedUtils.paramNull(bass0300DAO)) {
//	        
//	        	WebApplicationContext wac = WebApplicationContextUtils.
//	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//	        	bass0300DAO = (PrgmComBass0300DAO) wac.getBean("PrgmComBass0300DAO" ); 
//	        }
	        
	        bass0300DAO = (PrgmComBass0300DAO)BeanFinder.getBean("PrgmComBass0300DAO");
	        
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
	           // String strCriteriaValue = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	           
	            /** 조건절 */
	            sysComSrhVo.setDpobCd(sessionUser.getDpobCd()); 
	           
	            sysComSrhVo.setRpsttvCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"))); 
	            if (!"combo".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "chkCombo")))) {
	                sysComSrhVo.setCommCdNm(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "commCdNm"),"^^")); 
                } 
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
	            
	            //공통코드 가져오기 구분자 20170914
                sysComSrhVo.setCommUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "commUseYn"))); 
	              
	            if ("combo".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "chkCombo")))) {
	            	sysComSrhVo.setLastIndex(-1);
	            } else {
	            	
	            	  //Get total record count //전체 데이터 갯수를 가지고 온다. 
	 	            if ( pagingValues.executeRecordCount ) { 
	 	            	
		                //Execute query that returns a single value
		                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		                int iResultCnt = bass0300DAO.selectBass0300ListTotCnt(sysComSrhVo);  
		              
		                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
		                pagingValues.totalRecordCount = iResultCnt;	       
		                
		                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	                }
		        
		            /**페이지 카운트 처리를 위한 부분 */ 
		            sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		            //Apply paging
		            if (pagingValues.start > 0) {
		            	sysComSrhVo.setFirstIndex(pagingValues.start);
		            }
		            if (pagingValues.totalRecordCount < 100) {
		            	 sysComSrhVo.setLastIndex(pagingValues.totalRecordCount); 
		            } else if (pagingValues.offsetLimit > 0) {
		            	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
		            }
	            }

	            TimingInfo millisBeginSelectBass0300List = SmrmfUtils.startTiming(logger);
            
	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = bass0300DAO.selectBass0300List(sysComSrhVo);
                
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
	
 
    /**
     * <pre>
     * 1. 개요 : 공통함수에 의한 콤보박스 로직을 호출 하여 처리 할 경우 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getPrgmComComboBass0300List
     * @date : Nov 13, 2015
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Nov 13, 2015		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param serviceParameters
     * @return
     * @throws MSFException
     */ 	
    public PagingLoadResult<BaseModel> getPrgmComComboBass0300List(ServiceParameters serviceParameters) throws MSFException {

            PagingLoadResult<BaseModel> retval = null;
            String method =  PRGMCOM_METHOD_COMBO_BASS0300_List;
            PrgmComSearchVO   sysComSrhVo = new PrgmComSearchVO();
            PrgmComBass0300VO sysComBass0300Vo = new PrgmComBass0300VO();
            List<BaseModel>  bmResult = new ArrayList<BaseModel>();
            MSFServerExtAuth msfServerExtAuth = MSFServerExtAuth.getInstance();
            
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
            
//            if  (MSFSharedUtils.paramNull(bass0300DAO)) {
//            
//                WebApplicationContext wac = WebApplicationContextUtils.
//                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//                bass0300DAO = (PrgmComBass0300DAO) wac.getBean("PrgmComBass0300DAO" ); 
//            }
            
            bass0300DAO = (PrgmComBass0300DAO)BeanFinder.getBean("PrgmComBass0300DAO");
            
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
               // String strCriteriaValue = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
               
                /** 조건절 */
                sysComSrhVo.setDpobCd(sessionUser.getDpobCd());  
                sysComSrhVo.setRpsttvCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd")));  
                sysComSrhVo.setCommCd("");
                
                /******************************** 권한 ************************************************************************/
                //권한처리 - 고용구분인경우에 만 해당됨.
                if (MSFConfiguration.EMYMT_DA002.equals(sysComSrhVo.getRpsttvCd())) {
	             	//권한 처리 루틴 추가 2015-11-13 
	            	String chEmymtDivCd = MSFSharedUtils.allowNulls(sessionUser.getAuthCheck().getAuthCheck02());  //고용구분코드 
	                if ("FALSE".equals(chEmymtDivCd)) { 
	                	//sysComSrhVo.setCommCd(msfServerExtAuth.getAuthEmymtDivCd(sessionUser));
	                } else {
	                	
	                }
                }
                /******************************** 권한 ************************************************************************/
                sysComSrhVo.setCommCdNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "commCdNm")));  
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
                //공통코드 가져오기 구분자 20170914
                sysComSrhVo.setCommUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "commUseYn"))); 
                  
                if ("combo".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "chkCombo")))) {
                    sysComSrhVo.setLastIndex(-1);
                } else {
                    
                      //Get total record count //전체 데이터 갯수를 가지고 온다. 
                    if ( pagingValues.executeRecordCount ) { 
                        
                        //Execute query that returns a single value
                        TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                         
                        int iResultCnt = bass0300DAO.selectBass0300ListTotCnt(sysComSrhVo);  
                      
                        SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                        pagingValues.totalRecordCount = iResultCnt;        
                        
                        logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
                    }
                
                    /**페이지 카운트 처리를 위한 부분 */ 
                    sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
                    
                    //Apply paging
                    if (pagingValues.start > 0) {
                        sysComSrhVo.setFirstIndex(pagingValues.start);
                    }
                    if (pagingValues.totalRecordCount < 100) {
                         sysComSrhVo.setLastIndex(pagingValues.totalRecordCount); 
                    } else if (pagingValues.offsetLimit > 0) {
                         sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
                    }
                }

                TimingInfo millisBeginPrgmComComboBass0300List = SmrmfUtils.startTiming(logger);
            
                //Execute query and convert to BaseModel list
                TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
                
                @SuppressWarnings("unchecked")
//              Collection<Map<String, Object>> list ??????
                List list = bass0300DAO.selectBass0300List(sysComSrhVo);
                
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
                
                SmrmfUtils.endTiming(logger, millisBeginPrgmComComboBass0300List, "getPrgmComComboBass0300List");
           
 
            }
            catch (Exception ex) {
                ex.printStackTrace();
                //Return operation exception
                throw MSFServerUtils.getOperationException(method, ex, logger);
            }

            return retval;
        }
    
	/**
	 * 일반 콤보형태 처리 
	 * @param sysComBass0300Dto
	 * @return
	 * @throws MSFException
	 */
	 
	public List<BaseModel> getPrgmComComboBass0300List(PrgmComBass0300DTO sysComBass0300Dto) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getPrgmComComboBass0300List";
        PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
        PrgmComBass0300VO sysComBass0300Vo = new PrgmComBass0300VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        MSFServerExtAuth msfServerExtAuth = MSFServerExtAuth.getInstance();
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        	 bass0300DAO = (PrgmComBass0300DAO)BeanFinder.getBean("PrgmComBass0300DAO");
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
 	        
        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                     ,new ColumnAttribute("commCd", "commCd", ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("commCdNm", "commCdNm", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem01", "mangeItem01", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem02", "mangeItem02", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem03", "mangeItem03", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem04", "mangeItem04", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem05", "mangeItem05", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem06", "mangeItem06", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem07", "mangeItem07", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem08", "mangeItem08", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem09", "mangeItem09", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem10", "mangeItem10", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem11", "mangeItem11", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem12", "mangeItem12", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem13", "mangeItem13", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem14", "mangeItem14", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem15", "mangeItem15", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem16", "mangeItem16", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem17", "mangeItem17", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem18", "mangeItem18", ColumnDef.TYPE_STRING)};
        	
            //Get paging configuration
           // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
        	sysComSrhVo.setDpobCd(sessionUser.getDpobCd());
            sysComSrhVo.setRpsttvCd(sysComBass0300Dto.getRpsttvCd()); 
            sysComSrhVo.setCommCd("");
            /******************************** 권한 ************************************************************************/
            //권한처리 - 고용구분인경우에 만 해당됨.
            if (MSFConfiguration.EMYMT_DA002.equals(sysComSrhVo.getRpsttvCd())) {
             	//권한 처리 루틴 추가 2015-11-13 
            	String chEmymtDivCd = sessionUser.getAuthCheck().getAuthCheck02();  //고용구분코드 
                if ("FALSE".equals(chEmymtDivCd)) { 
                	//sysComSrhVo.setCommCd(msfServerExtAuth.getAuthEmymtDivCd(sessionUser));
                } else {
                	
                }
            }
            /******************************** 권한 ************************************************************************/
            
            sysComSrhVo.setMangeItem01(sysComBass0300Dto.getMangeItem01()); 
            sysComSrhVo.setMangeItem02(sysComBass0300Dto.getMangeItem02()); 
            sysComSrhVo.setMangeItem03(sysComBass0300Dto.getMangeItem03()); 
            sysComSrhVo.setMangeItem04(sysComBass0300Dto.getMangeItem04()); 
            sysComSrhVo.setMangeItem05(sysComBass0300Dto.getMangeItem05()); 
            sysComSrhVo.setMangeItem06(sysComBass0300Dto.getMangeItem06()); 
            sysComSrhVo.setMangeItem07(sysComBass0300Dto.getMangeItem07()); 
            sysComSrhVo.setMangeItem08(sysComBass0300Dto.getMangeItem08()); 
            sysComSrhVo.setMangeItem09(sysComBass0300Dto.getMangeItem09()); 
            sysComSrhVo.setMangeItem10(sysComBass0300Dto.getMangeItem10()); 
            sysComSrhVo.setMangeItem11(sysComBass0300Dto.getMangeItem11()); 
            sysComSrhVo.setMangeItem12(sysComBass0300Dto.getMangeItem12()); 
            sysComSrhVo.setMangeItem13(sysComBass0300Dto.getMangeItem13()); 
            sysComSrhVo.setMangeItem14(sysComBass0300Dto.getMangeItem14()); 
            sysComSrhVo.setMangeItem15(sysComBass0300Dto.getMangeItem15()); 
            sysComSrhVo.setMangeItem16(sysComBass0300Dto.getMangeItem16()); 
            sysComSrhVo.setMangeItem17(sysComBass0300Dto.getMangeItem17()); 
            sysComSrhVo.setMangeItem18(sysComBass0300Dto.getMangeItem18()); 
            sysComSrhVo.setMangeItem19(sysComBass0300Dto.getMangeItem19()); 
            sysComSrhVo.setMangeItem10(sysComBass0300Dto.getMangeItem20()); 
          //공통코드 가져오기 구분자 20170914
            sysComSrhVo.setCommUseYn(MSFSharedUtils.allowNulls(sysComBass0300Dto.getCommUseYn()) ); 
            
            sysComSrhVo.setCommKey(sessionUser.getDpobCd() 
                    + sysComBass0300Dto.getRpsttvCd() 
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem01(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem02(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem03(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem04(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem05(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem06(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem07(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem08(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem09(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem10(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem11(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem12(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem13(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem14(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem15(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem16(),"N")
                    + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem17(),"N")
                     + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem18(),"N")
                     + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem19(),"N")
                     + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem20(),"N")
                    );
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        //    if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  bass0300DAO.selectBass0300ListTotCnt(sysComSrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
         //       pagingValues.totalRecordCount = iResultCnt;	       
                
         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         //  }
        
            TimingInfo millisBeginSelectBass0300List = SmrmfUtils.startTiming(logger);
        
        	 

            /**페이지 카운트 처리를 위한 부분 */ 
          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
           // 	sysComSrhVo.setFirstIndex(pagingValues.start);
           // }
           // if (pagingValues.offsetLimit > 0) {
           // 	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            sysComSrhVo.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = bass0300DAO.selectBass0300ComboList(sysComSrhVo);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("commCd").toString();
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

            //retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0300List, "selectBass0300List");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return bmResult;
    }
	
	/**
	 * 해당 코드에 따른 값을 여러개 입력 받아 해당 건을 리턴 한다.
	 * @param sysComBass0300Dto
	 * @return
	 * @throws MSFException
	 */
	 
	public HashMap<String, List<BaseModel>> getPrgmComMultiComboBass0300List(PrgmComBass0300DTO sysComBass0300Dto) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getPrgmComMultiComboBass0300List";
        PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
        PrgmComBass0300VO sysComBass0300Vo = new PrgmComBass0300VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        MSFServerExtAuth msfServerExtAuth = MSFServerExtAuth.getInstance();
        
        HashMap<String, List<BaseModel>> mapResult = new HashMap<String, List<BaseModel>>();
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        	   bass0300DAO = (PrgmComBass0300DAO)BeanFinder.getBean("PrgmComBass0300DAO");
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
 	        
        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                     ,new ColumnAttribute("commCd", "commCd", ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("commCdNm", "commCdNm", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem01", "mangeItem01", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem02", "mangeItem02", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem03", "mangeItem03", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem04", "mangeItem04", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem05", "mangeItem05", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem06", "mangeItem06", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem07", "mangeItem07", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem08", "mangeItem08", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem09", "mangeItem09", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem10", "mangeItem10", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem11", "mangeItem11", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem12", "mangeItem12", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem13", "mangeItem13", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem14", "mangeItem14", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem15", "mangeItem15", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem16", "mangeItem16", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem17", "mangeItem17", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem18", "mangeItem18", ColumnDef.TYPE_STRING) };
        	
            //Get paging configuration
           // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            
        	for (int iCnt =0; iCnt < sysComBass0300Dto.getArrRpsttvCd().size();iCnt++) {
        		
        		/** 조건절 */
            	  sysComSrhVo.setDpobCd(sessionUser.getDpobCd());
        		  sysComSrhVo.setRpsttvCd(sysComBass0300Dto.getArrRpsttvCd().get(iCnt)) ; 
        		  sysComSrhVo.setCommCd("");
        		  /******************************** 권한 ************************************************************************/
                  //권한처리 - 고용구분인경우에 만 해당됨.
                  if (MSFConfiguration.EMYMT_DA002.equals(sysComBass0300Dto.getArrRpsttvCd().get(iCnt))) {
  	             	//권한 처리 루틴 추가 2015-11-13 
  	            	String chEmymtDivCd = sessionUser.getAuthCheck().getAuthCheck02();  //고용구분코드 
  	                if ("FALSE".equals(chEmymtDivCd)) { 
  	                	//sysComSrhVo.setCommCd(msfServerExtAuth.getAuthEmymtDivCd(sessionUser));
  	                } else {
  	                	
  	                }
                  }
                  /******************************** 권한 ************************************************************************/
        		  sysComSrhVo.setMangeItem01(sysComBass0300Dto.getMangeItem01()); 
                  sysComSrhVo.setMangeItem02(sysComBass0300Dto.getMangeItem02()); 
                  sysComSrhVo.setMangeItem03(sysComBass0300Dto.getMangeItem03()); 
                  sysComSrhVo.setMangeItem04(sysComBass0300Dto.getMangeItem04()); 
                  sysComSrhVo.setMangeItem05(sysComBass0300Dto.getMangeItem05()); 
                  sysComSrhVo.setMangeItem06(sysComBass0300Dto.getMangeItem06()); 
                  sysComSrhVo.setMangeItem07(sysComBass0300Dto.getMangeItem07()); 
                  sysComSrhVo.setMangeItem08(sysComBass0300Dto.getMangeItem08()); 
                  sysComSrhVo.setMangeItem09(sysComBass0300Dto.getMangeItem09()); 
                  sysComSrhVo.setMangeItem10(sysComBass0300Dto.getMangeItem10()); 
                  sysComSrhVo.setMangeItem11(sysComBass0300Dto.getMangeItem11()); 
                  sysComSrhVo.setMangeItem12(sysComBass0300Dto.getMangeItem12()); 
                  sysComSrhVo.setMangeItem13(sysComBass0300Dto.getMangeItem13()); 
                  sysComSrhVo.setMangeItem14(sysComBass0300Dto.getMangeItem14()); 
                  sysComSrhVo.setMangeItem15(sysComBass0300Dto.getMangeItem15()); 
                  sysComSrhVo.setMangeItem16(sysComBass0300Dto.getMangeItem16()); 
                  sysComSrhVo.setMangeItem17(sysComBass0300Dto.getMangeItem17()); 
                  sysComSrhVo.setMangeItem18(sysComBass0300Dto.getMangeItem18()); 
                  sysComSrhVo.setMangeItem19(sysComBass0300Dto.getMangeItem19()); 
                  sysComSrhVo.setMangeItem10(sysComBass0300Dto.getMangeItem20()); 
                  
                  //공통코드 가져오기 구분자 20170914
                  sysComSrhVo.setCommUseYn(MSFSharedUtils.allowNulls(sysComBass0300Dto.getCommUseYn()) ); 
	         
                  sysComSrhVo.setCommKey(sessionUser.getDpobCd() 
                          + sysComBass0300Dto.getArrRpsttvCd().get(iCnt)
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem01(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem02(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem03(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem04(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem05(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem06(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem07(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem08(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem09(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem10(),"N"));
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		        //    if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	        //        TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	        //        int iResultCnt =  bass0300DAO.selectBass0300ListTotCnt(sysComSrhVo);  
	              
	        //        SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	         //       pagingValues.totalRecordCount = iResultCnt;	       
	                
	          //      logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	         //  }
	        
	            TimingInfo millisBeginSelectBass0300List = SmrmfUtils.startTiming(logger);
	         
	            /**페이지 카운트 처리를 위한 부분 */ 
	          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	           // if (pagingValues.start > 0) {
	           // 	sysComSrhVo.setFirstIndex(pagingValues.start);
	           // }
	           // if (pagingValues.offsetLimit > 0) {
	           // 	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	           // }
	            sysComSrhVo.setLastIndex(-1); 
	
	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
	//            Collection<Map<String, Object>> list ??????
	            List list = bass0300DAO.selectBass0300ComboList(sysComSrhVo);
	            
		        Iterator<Map<String, Object>> iter = list.iterator();
		            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	            bmResult = new ArrayList<BaseModel>();
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("commCd").toString();
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
	
	            mapResult.put(sysComSrhVo.getRpsttvCd(), bmResult);
	            //retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
	            
	            SmrmfUtils.endTiming(logger, millisBeginSelectBass0300List, "selectBass0300List");
	            
        	}

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return mapResult;
    }
	
	/**
	 * 해당 코드에 따른 값을 여러개 입력 받아 해당 건을 리턴 한다. item 항목조건에 따라 출력하는 조건.
	 * @param sysComBass0300Dto
	 * @return
	 * @throws MSFException
	 */
	 
	public HashMap<String, List<BaseModel>> getPrgmComMultiWithItemComboBass0300List(List<PrgmComBass0300DTO> lstBass0300Dto) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getPrgmComMultiComboBass0300List";
        PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
        PrgmComBass0300VO sysComBass0300Vo = new PrgmComBass0300VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        
        HashMap<String, List<BaseModel>> mapResult = new HashMap<String, List<BaseModel>>();
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        	   bass0300DAO = (PrgmComBass0300DAO)BeanFinder.getBean("PrgmComBass0300DAO");
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
 	        
        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                     ,new ColumnAttribute("commCd", "commCd", ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("commCdNm", "commCdNm", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem01", "mangeItem01", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem02", "mangeItem02", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem03", "mangeItem03", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem04", "mangeItem04", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem05", "mangeItem05", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem06", "mangeItem06", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem07", "mangeItem07", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem08", "mangeItem08", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem09", "mangeItem09", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem10", "mangeItem10", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem11", "mangeItem11", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem12", "mangeItem12", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem13", "mangeItem13", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem14", "mangeItem14", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem15", "mangeItem15", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem16", "mangeItem16", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem17", "mangeItem17", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem18", "mangeItem18", ColumnDef.TYPE_STRING)};
        	
            //Get paging configuration
           // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            
        	for (int iCnt =0; iCnt < lstBass0300Dto.size();iCnt++) {
        		
        		PrgmComBass0300DTO sysComBass0300Dto = new PrgmComBass0300DTO();
        		sysComBass0300Dto = lstBass0300Dto.get(iCnt);
        		/** 조건절 */
            	sysComSrhVo.setDpobCd(sessionUser.getDpobCd());
        		sysComSrhVo.setRpsttvCd(sysComBass0300Dto.getRpsttvCd()) ; 
        		  sysComSrhVo.setMangeItem01(sysComBass0300Dto.getMangeItem01()); 
                  sysComSrhVo.setMangeItem02(sysComBass0300Dto.getMangeItem02()); 
                  sysComSrhVo.setMangeItem03(sysComBass0300Dto.getMangeItem03()); 
                  sysComSrhVo.setMangeItem04(sysComBass0300Dto.getMangeItem04()); 
                  sysComSrhVo.setMangeItem05(sysComBass0300Dto.getMangeItem05()); 
                  sysComSrhVo.setMangeItem06(sysComBass0300Dto.getMangeItem06()); 
                  sysComSrhVo.setMangeItem07(sysComBass0300Dto.getMangeItem07()); 
                  sysComSrhVo.setMangeItem08(sysComBass0300Dto.getMangeItem08()); 
                  sysComSrhVo.setMangeItem09(sysComBass0300Dto.getMangeItem09()); 
                  sysComSrhVo.setMangeItem10(sysComBass0300Dto.getMangeItem10()); 
                  sysComSrhVo.setMangeItem11(sysComBass0300Dto.getMangeItem11()); 
                  sysComSrhVo.setMangeItem12(sysComBass0300Dto.getMangeItem12()); 
                  sysComSrhVo.setMangeItem13(sysComBass0300Dto.getMangeItem13()); 
                  sysComSrhVo.setMangeItem14(sysComBass0300Dto.getMangeItem14()); 
                  sysComSrhVo.setMangeItem15(sysComBass0300Dto.getMangeItem15()); 
                  sysComSrhVo.setMangeItem16(sysComBass0300Dto.getMangeItem16()); 
                  sysComSrhVo.setMangeItem17(sysComBass0300Dto.getMangeItem17()); 
                  sysComSrhVo.setMangeItem18(sysComBass0300Dto.getMangeItem18()); 
                  sysComSrhVo.setMangeItem19(sysComBass0300Dto.getMangeItem19()); 
                  sysComSrhVo.setMangeItem10(sysComBass0300Dto.getMangeItem20()); 
                  
                  //공통코드 가져오기 구분자 20170914
                  sysComSrhVo.setCommUseYn(MSFSharedUtils.allowNulls(sysComBass0300Dto.getCommUseYn()) ); 
	         
                  sysComSrhVo.setCommKey(sessionUser.getDpobCd() 
                          + sysComBass0300Dto.getRpsttvCd() 
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem01(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem02(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem03(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem04(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem05(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem06(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem07(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem08(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem09(),"N")
                          + MSFSharedUtils.defaultNulls(sysComBass0300Dto.getMangeItem10(),"N"));
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		        //    if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	             //   TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	             //   int iResultCnt =  bass0300DAO.selectBass0300ListTotCnt(sysComSrhVo);  
	              
	             //   SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	         //       pagingValues.totalRecordCount = iResultCnt;	       
	                
	         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	         //  }
	        
	            TimingInfo millisBeginSelectBass0300List = SmrmfUtils.startTiming(logger);
	         
	            /**페이지 카운트 처리를 위한 부분 */ 
	          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	           // if (pagingValues.start > 0) {
	           // 	sysComSrhVo.setFirstIndex(pagingValues.start);
	           // }
	           // if (pagingValues.offsetLimit > 0) {
	           // 	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	           // }
	            sysComSrhVo.setLastIndex(-1); 
	
	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
	//            Collection<Map<String, Object>> list ??????
	            List list = bass0300DAO.selectBass0300ComboList(sysComSrhVo);
	            
		        Iterator<Map<String, Object>> iter = list.iterator();
		            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("commCd").toString();
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
	
	            mapResult.put(sysComSrhVo.getRpsttvCd(), bmResult);
	            //retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
	            
	            SmrmfUtils.endTiming(logger, millisBeginSelectBass0300List, "selectBass0300List");
	            
        	}

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return mapResult;
    }
  

}
