package com.app.exterms.diligence.server.service;

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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.diligence.server.service.dao.Dlgn0100DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0110DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0200DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0210DAO;
import com.app.exterms.diligence.server.vo.Dlgn0100SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0100VO;
import com.app.exterms.diligence.server.vo.Dlgn0110SrhVO;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.ibm.icu.math.BigDecimal;


//@Service("dlgn0100Service")
public class Dlgn0100_1ServiceImpl extends AbstractCustomServiceImpl {

	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(Dlgn0100_1ServiceImpl.class);
	private static final String calledClass = Dlgn0100_1ServiceImpl.class.getName();
	
	@Resource(name="dlgn0100DAO")
	private Dlgn0100DAO dlgn0100Dao;
	
	@Resource(name="dlgn0200DAO")
	private Dlgn0200DAO dlgn0200Dao;
	
	@Resource(name="dlgn0110DAO")
	private Dlgn0110DAO dlgn0110DAO;
	
	@Resource(name="dlgn0210DAO")
	private Dlgn0210DAO dlgn0210DAO;
	
	//Dlgn근무내역등록 그리드 조회
	
	public PagingLoadResult<BaseModel> getDlgn0100List(ServiceParameters serviceParameters) throws MSFException {
		
        PagingLoadResult<BaseModel> retval = null;
        String method = calledClass + ".getPayrMangDeptCd";
        String windowNm = "기본근무관리";
		String windowId = "DLGN0100";
        //        String method =  CLASS_DLGN0100LIST_01;
        Dlgn0100SrhVO   dlgn0100SrhVO = new Dlgn0100SrhVO(); 
        Dlgn0110SrhVO   dlgn0110SrhVO = new Dlgn0110SrhVO();
        Dlgn0100VO dlgn0200VO = new Dlgn0100VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
	      if  (MSFSharedUtils.paramNull(dlgn0110DAO)) {
	      
	          WebApplicationContext wac = WebApplicationContextUtils.
	                  getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	
	          dlgn0110DAO = (Dlgn0110DAO) wac.getBean("dlgn0110DAO" ); 
	      }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0470BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
            dlgn0110SrhVO.setDpobCd(sessionUser.getDpobCd());
            dlgn0110SrhVO.setEmymtDivCd(MSFSharedUtils.defaultNulls( MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd"),"")); 				// 고용구분코드
            dlgn0110SrhVO.setDilnlazYrMnth(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailYm"), "")); 				// 근태년월
            dlgn0110SrhVO.setHanNm(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailName"), "")); 					//성명
            dlgn0110SrhVO.setDilnlazDutyBgnnDt(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailEmymtBgnnDt"), "")); // 시작일자
            dlgn0110SrhVO.setDilnlazDutyEndDt(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailEmymtEndDt"), "")); 	// 종료일자
            dlgn0110SrhVO.setSystemkey(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"), "")); 				// 시스템키
            dlgn0110SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  								// 급여구분코드
            dlgn0110SrhVO.setTypOccuBusinVal(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuBusinVal")));			// 복무통합코드
            
            
//            //Get total record count //전체 데이터 갯수를 가지고 온다.
	         if ( pagingValues.executeRecordCount ) {
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
//                int iResultCnt = 0 ;
                int iResultCnt = dlgn0110DAO.selectDlgn0100ListTotCnt(dlgn0110SrhVO);
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginDlgn0100DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            dlgn0110SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	dlgn0110SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	dlgn0110SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = dlgn0110DAO.selectDlgn0100List_1(dlgn0110SrhVO);
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("systemkey").toString();
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
                     
                 	//3. 복호화
                 	case ColumnDef.TYPE_STRING: 
                 	          			          			
                 		String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
                    			
                 		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
                 	          			
                 			String rrnDecCrypt = "";
                 	          			
                 			// 주민번호(복호화)
                 			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                 	          		
                 			strValue = rrnDecCrypt;
                 						
                 		}
                  	                       
                 	map.put(tableAttributes[i].getName(), strValue);
                 		                    
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
            
            SmrmfUtils.endTiming(logger, millisBeginDlgn0100DataList, "getDlgn0100List");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
        	/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"s",ex, windowNm , windowId);
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }
        
        MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
        return retval;
    }
}
