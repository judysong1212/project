package com.app.smrmf.syscom.server.service;
  
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
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.ssocom.service.SsoxSmrmfService;
import com.app.smrmf.syscom.client.service.SsoxRpcUserService;
import com.app.smrmf.syscom.shared.SysComDaoConstants;
import com.app.smrmf.sysm.server.vo.system.SsoxUserSrhVO;
import com.app.smrmf.sysm.server.vo.system.SsoxUserVO;
import com.ext.constants.PropConfs;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.sso.constants.SsoConf;

@Service("SsoxRpcUserService")
public class SsoxRpcUserServiceImpl extends AbstractCustomServiceImpl implements SsoxRpcUserService  ,SysComDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(SsoxRpcUserServiceImpl.class);

	public SsoxRpcUserServiceImpl() {
	
	}
	    
	@Autowired 
	@Resource(name = "SsoxSmrmfService")
    private SsoxSmrmfService ssoxUserService;
    
    /** ID Generation */
    //@Resource(name="{egovSsoxUserIdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	public PagingLoadResult<BaseModel> getSelectSsoxUserList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_SSOXUSER_LIST;
        SsoxUserSrhVO   ssoxUserSrhVo = new SsoxUserSrhVO();
        SsoxUserVO      sysm0100Vo = new SsoxUserVO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
     	SsoConf.setSsoConfigFile(PropConfs.APP_CONFIG_FILE);
 	    
     	final HashMap<String, String> ssoGlobals = SsoConf.getPayGenSsoConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest());   
 	   
        if  (MSFSharedUtils.paramNull(ssoxUserService)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	ssoxUserService = (SsoxSmrmfService) wac.getBean("SsoxSmrmfService" ); 
        }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // SsoxUserBM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */ 
            ssoxUserSrhVo.setDpobCd(sessionUser.getDpobCd());
            ssoxUserSrhVo.setUserName(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "userName")));    //검색조건처리 
            ssoxUserSrhVo.setDeptId(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptId")));  
            
            //sysComSrhVo.setRpsttvCd(strCriteriaValue); 
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	            if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                int iResultCnt = 0;
                //세올과 올레 두개의 서비스를 처리하기 위한 수정 
                
                if (("DREAMSECURITY").equals(ssoGlobals.get("PayGen.SsoLinkType"))) {
                	 //kt 올레 공통기반 
                	  iResultCnt = ssoxUserService.selectMagicSsoUserListTotCnt(ssoxUserSrhVo); 
                } else {
                	//세올 공통기반  
                	  iResultCnt = ssoxUserService.selectSsoxUserListTotCnt(ssoxUserSrhVo); 
                }
                
               
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectSsoxUserList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            ssoxUserSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	ssoxUserSrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	ssoxUserSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
          //세올과 올레 두개의 서비스를 처리하기 위한 수정 
            @SuppressWarnings("unchecked")
            List listSso = null;
            if (("DREAMSECURITY").equals(ssoGlobals.get("PayGen.SsoLinkType"))) {
            	 //kt 올레 공통기반 
 
                listSso = ssoxUserService.selectMagicSsoUserList(ssoxUserSrhVo);
                
            } else {
            	//세올 공통기반  
 
                listSso = ssoxUserService.selectSsoxUserList(ssoxUserSrhVo);
            }
            
	        Iterator<Map<String, Object>> iter = listSso.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("userId").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectSsoxUserList, "selectSsoxUserList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
 
}
