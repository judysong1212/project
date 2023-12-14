package com.app.exterms.yearendtax.server.service.yeta2018;

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

import com.app.exterms.yearendtax.client.service.yeta2018.Yeta3080Service;
import com.app.exterms.yearendtax.server.service.yeta2018.dao.Yeta3080_2018_DAO;
import com.app.exterms.yearendtax.server.vo.Yeta2080Srh_2018_VO;
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
import com.app.smrmf.infc.sysauth.system.server.service.dao.InfcPkgSysm0100DAO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Yeta3080Service")
public class Yeta3080ServiceImpl extends AbstractCustomServiceImpl implements YetaDaoConstantsGenerated, Yeta3080Service {

	private static final Logger logger = LoggerFactory.getLogger(Yeta3080ServiceImpl.class);
	private static final String calledClass = Yeta3080ServiceImpl.class.getName();

	@Autowired
	@Resource(name = "Yeta3080_2018_DAO")
	private Yeta3080_2018_DAO yeta3080DAO;
	
	@Autowired
	@Resource(name = "InfcPkgSysm0100DAO")
	private InfcPkgSysm0100DAO infcPkgSysm0100DAO;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta3080ToBass0400List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_YETA2080_TO_BASS0400_LIST;
        Yeta2080Srh_2018_VO   yeta2080SrhVo = new Yeta2080Srh_2018_VO();
        //Yeta2080VO      Yeta2080Vo = new Yeta2080VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if(MSFSharedUtils.paramNull(yeta3080DAO)){
        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
        	yeta3080DAO = (Yeta3080_2018_DAO) wac.getBean("Yeta3080_2018_DAO");
        }
        
        try{
        	
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
	      	/** 조건절 */
            yeta2080SrhVo.setDpobCd(sessionUser.getDpobCd());    /** column 사업장코드 : dpobCd */
            yeta2080SrhVo.setDeptNmHan(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptNmHan")));
            
            if(pagingValues.executeRecordCount){ 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = yeta3080DAO.selectYeta3080ListTotCnt(yeta2080SrhVo);
            	
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
            	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectYeta2080List = SmrmfUtils.startTiming(logger);
            
            yeta2080SrhVo.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	yeta2080SrhVo.setFirstIndex(pagingValues.start);
            }
            
            if (pagingValues.offsetLimit > 0) {
            	yeta2080SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = yeta3080DAO.selectYeta3080List(yeta2080SrhVo);
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectYeta2080List, "selectYeta3080List");
            
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

        return retval;
        
    }
	
	
	
//	/** 연말정산등록담당자 조회 **/
//	public PagingLoadResult<BaseModel> getYeta2080ToInfcPkgSysm0100List(ServiceParameters serviceParameters) throws MSFException {
//
//		PagingLoadResult<BaseModel> retval = null;
//		String method = CLASS_YETA2080_TO_SYSM0100_LIST;
//		
//		InfcPkgSysm0100SrhVO infcPkgSysm0100SrhVo = new InfcPkgSysm0100SrhVO();
//		List<BaseModel> bmResult = new ArrayList<BaseModel>();
//		MSFSysm0100BM sessionUser;
//			
//		        
//			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
//				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//			} else {
//				sessionUser = getUser();
//			}
//		      
//			if  (MSFSharedUtils.paramNull(infcPkgSysm0100DAO)) {
//				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//				infcPkgSysm0100DAO = (InfcPkgSysm0100DAO) wac.getBean("InfcPkgSysm0100DAO"); 
//			}
//		        
//			try {
//				//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
//				ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
//				IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
//				List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
//				PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
//
//				//Get paging configuration
//		    	PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
//
//		    	//Get query parameters
//		      	//String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
//		    	
////		    	List<String> listDeptCd = new ArrayList<String>();    
//		      	/** 조건절 */
//		    	infcPkgSysm0100SrhVo.setUsrNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자성명 : usrNm */   
//		    	infcPkgSysm0100SrhVo.setUsrDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrNm")));    				/** column 사용자권한구분코드 : usrDivCd */
//		    	infcPkgSysm0100SrhVo.setUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "useYn")));    				/** column 사용자사용여부 : useYn */
//		    	infcPkgSysm0100SrhVo.setYrtxInptPrcsYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxInptPrcsYn"))); 	/** column 연말정산입력처리여부 : yrtxInptPrcsYn */
//		    	
//		    	// Get total record count //전체 데이터 갯수를 가지고 온다. 
//				if ( pagingValues.executeRecordCount ) { 
//			            	
//					//Execute query that returns a single value
//		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//		                 
//		          	int iResultCnt = infcPkgSysm0100DAO.selectYeta2080ToSysm0100ListCnt(infcPkgSysm0100SrhVo);  
//		              
//		          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
//		          	
//		          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
//	                if (!pagingValues.pageExecute) { 
//	                    pagingValues.offsetLimit = iResultCnt;       
//	                }
//	                
//		         	pagingValues.totalRecordCount = iResultCnt;	       
//		                
//		        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//				}
//		        
//		     	TimingInfo millisBeginPsnl0126DataList = SmrmfUtils.startTiming(logger);
//		        
//		     	/**페이지 카운트 처리를 위한 부분 */ 
//		     	infcPkgSysm0100SrhVo.setPageSize(pagingValues.totalRecordCount);  
//		            
//		     	//Apply paging
//		     	if (pagingValues.start > 0) {
//		     		infcPkgSysm0100SrhVo.setFirstIndex(pagingValues.start);
//		     	}
//		     	if (pagingValues.offsetLimit > 0) {
//		     		infcPkgSysm0100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
//		     	}
//
//		     	//Execute query and convert to BaseModel list
//		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
////		            
////		     	@SuppressWarnings("unchecked")
//////		            Collection<Map<String, Object>> list ??????
//		     	List list = infcPkgSysm0100DAO.selectYeta2080ToSysm0100List(infcPkgSysm0100SrhVo);
//		            
//				Iterator<Map<String, Object>> iter = list.iterator();
//			            
////				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
//		           
//		        
//				while (iter.hasNext()) { 
//
//					// 1. 암호화 객체 생성
//					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//				        
//					Map<String, Object> map = (Map<String, Object>) iter.next();
//					String idValue = map.get("usrId").toString();
//		        	BaseModel bm = new BaseModel();
//		 
//		       	//bm.setProperties(map);
//		     	for ( int i=0 ; i<tableAttributes.length ; i++ ) {
//		     		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
//		     		Object mapCon = map.get(tableAttributes[i].getName());  
//		                     
//		     		switch ( tableAttributes[i].getType() ) {  
//		          		case ColumnDef.TYPE_DATE: 
//		          		case ColumnDef.TYPE_DATETIME: 
//		                       
//		             	Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"yyyyMMdd");
//		            	map.put(tableAttributes[i].getName(), value);
//		                     
//		            	break; 
//		                       
//		          		case ColumnDef.TYPE_LONG:   
//		                     
//		          			if (mapCon != null) {  
//		          				Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
//		                        map.put(tableAttributes[i].getName(), lValue); 
//		                    }  
//		                       
//		                     break;
//		                     
//		          		case ColumnDef.TYPE_STRING: 
//		          		          			          			
//		          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
//
//		          			map.put(tableAttributes[i].getName(), strValue);
//		          			                    
//		          		break;
//     
//		                     
//		          		case ColumnDef.TYPE_DOUBLE:  
//		          			
//		                      if (mapCon != null) {      
//		                         Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue(); 
//		                         map.put(tableAttributes[i].getName(), dbValue); 
//		                      }  
//		                       
//		                   	break;
//		     		}
//		     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
//		     			Object baseModelValue = null;
//		            	//콤보박스처리를 위해 추가함
//		     			if (tableAttributes[i].getName().contains("$")) {
//		     				
//		     				String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
//		                              
//		     				map.put(tableAttributes[i].getName(),map.get(strMapCon));
//		                         
//		                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//		                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//		     			} else {
//		                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//		                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//		     			}
//		     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//		                    
//		                    bm.set(tableAttributes[i].getName(), baseModelValue);
//		     	}
//
//		     	bm.set(TableDef.ID_PROPERTY_NAME, idValue);
//		     	bmResult.add(bm);
//			} 
//
//				retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
//		            
////				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
//		       
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			// Return operation exception
//			throw MSFServerUtils.getOperationException(method, ex, logger);
//		}
//		return retval;
//	}
    
  
}
