package com.app.exterms.yearendtax.server.service.yeta2023;

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

import com.app.exterms.yearendtax.client.service.yeta2023.Yeta8070Service;
import com.app.exterms.yearendtax.server.service.yeta2023.dao.Yeta8070_2023_DAO;
import com.app.exterms.yearendtax.server.vo.Yeta2070Srh_2023_VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstantsGenerated;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Yeta8070Service")
public class Yeta8070ServiceImpl extends AbstractCustomServiceImpl implements YetaDaoConstantsGenerated, Yeta8070Service {

	private static final Logger logger = LoggerFactory.getLogger(Yeta8070ServiceImpl.class);
	private static final String calledClass = Yeta8070ServiceImpl.class.getName();

	@Autowired
	@Resource(name = "Yeta8070_2023_DAO")
	private Yeta8070_2023_DAO yeta8070DAO;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta8070ToBass0120List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_YETA4070TOBASS0120_LIST;
        Yeta2070Srh_2023_VO   Yeta2070SrhVO = new Yeta2070Srh_2023_VO();
        //Yeta2070VO      Yeta2070Vo = new Yeta2070VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if(MSFSharedUtils.paramNull(yeta8070DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
        	yeta8070DAO = (Yeta8070_2023_DAO) wac.getBean("Yeta8070_2023_DAO");
        }
        try{
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            Yeta2070SrhVO.setDpobCd(sessionUser.getDpobCd());
            
            if(pagingValues.executeRecordCount){ 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = yeta8070DAO.selectYeta8070ListTotCnt(Yeta2070SrhVO);
            	
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
            	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectYeta2070List = SmrmfUtils.startTiming(logger);
            
            Yeta2070SrhVO.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	Yeta2070SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	Yeta2070SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = yeta8070DAO.selectYeta8070List(Yeta2070SrhVO);
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectYeta2070List, "selectYeta8070List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }	
}
