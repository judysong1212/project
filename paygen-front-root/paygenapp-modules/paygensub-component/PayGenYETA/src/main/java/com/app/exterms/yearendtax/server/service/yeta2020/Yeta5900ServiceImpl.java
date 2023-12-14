package com.app.exterms.yearendtax.server.service.yeta2020;
 
 
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

import com.app.exterms.yearendtax.client.dto.yeta2020.Pyyt0302DTO;
import com.app.exterms.yearendtax.client.dto.yeta2020.Pyyt0304BM;
import com.app.exterms.yearendtax.client.dto.yeta2020.Pyyt0304DTO;
import com.app.exterms.yearendtax.client.service.yeta2020.Yeta5900Service;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye17TaPyyt0302_2020_DAO;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye17TaPyyt0304_2020_DAO;
import com.app.exterms.yearendtax.server.vo.Pyyt0302Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Pyyt0302_2020_VO;
import com.app.exterms.yearendtax.server.vo.Pyyt0304Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Pyyt0304_2020_VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
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

/**
 * 
* <pre>
* 1. 패키지명 : com.app.exterms.yearendtax.server.service
* 2. 타입명 : Yeta0100ServiceImpl.java
* 3. 작성일 : Jan 13, 2016 5:12:49 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Service("Yeta5900Service")
public class Yeta5900ServiceImpl  extends AbstractCustomServiceImpl implements Yeta5900Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(Yeta5900ServiceImpl.class);
	private static final String calledClass = Yeta5900ServiceImpl.class.getName();

	// 급여대상자
	@Autowired
	@Resource(name = "Ye17TaPyyt0304_2020_DAO")
	private Ye17TaPyyt0304_2020_DAO pyyt0304DAO;
	
	// 수당/공제내역
	@Autowired
	@Resource(name = "Ye17TaPyyt0302_2020_DAO")
	private Ye17TaPyyt0302_2020_DAO pyyt0302DAO;
	    
	    
	/**
	 * 급여 대상자 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getYeta5900ToPyyt0304List(ServiceParameters serviceParameters) throws MSFException {

 	        PagingLoadResult<BaseModel> retval = null;
//	        String method =  "getPsnl0100ToRemt0100DataList";
	        String method = CLASS_YETA5900_TO_PYYT0304_DATA_LIST;
	        Pyyt0304Srh_2020_VO   pyyt0304SrhVo = new Pyyt0304Srh_2020_VO();
	        Pyyt0304_2020_VO      pyyt0304Vo = new Pyyt0304_2020_VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	    	// 1. 암호화 객체 생성
	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(pyyt0304DAO)) {
	        
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            pyyt0304DAO = (Ye17TaPyyt0304_2020_DAO) wac.getBean("Ye17TaPyyt0304_2020_DAO"); 
	        }
	        
	        try {
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	           // Sysm0400BM          user             = serviceParameters.getUser();
	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

	            //Get paging configuration
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	            //Get query parameters
	            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	              
	            List<String> listDeptCd = new ArrayList<String>();
	            /** 조건절 */
	            pyyt0304SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            pyyt0304SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            pyyt0304SrhVo.setUsrId(sessionUser.getUsrId());  
	            pyyt0304SrhVo.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd"))) ;   				//급여구분  
	            
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	
	            	if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {

		            	pyyt0304SrhVo.setDeptCd(sessionUser.getDeptCd()); 
		               listDeptCd.add(sessionUser.getDeptCd());
		               pyyt0304SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	                     
	            	 } else {
	            		 pyyt0304SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                         listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                         pyyt0304SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	                     
	            	 }  
	            	
	               pyyt0304SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	    
	            	pyyt0304SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
	                     if (pyyt0304SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                     	 listDeptCd = null; 
	                     	pyyt0304SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                     	pyyt0304SrhVo.setDeptCd("");  //부서코드
	                     } else {
	                    	 pyyt0304SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                          pyyt0304SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                     } 
	                  
	            }
	            
	            pyyt0304SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            pyyt0304SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
//	            String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//	            if ("FALSE".equals(chkTypOccuCd)) {
//	            	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//	            	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//	            } else {
//	            	
//	            }
	            
	           /******************************** 권한 ************************************************************************/ 
	      
	            
	            pyyt0304SrhVo.setPyytYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyytYrMnth"))); 			//지급년월
	            
	           
	            pyyt0304SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       		//고용구분코드
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            pyyt0304SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	            pyyt0304SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  				//직종
	           
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            pyyt0304SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            pyyt0304SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 	//직종세 
	            
	            pyyt0304SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   				//사업코드 
	          
	            pyyt0304SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  				//시스템키
	            pyyt0304SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    					//한글성명
	            
	            
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	             if ( pagingValues.executeRecordCount ) { 
	                    
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = pyyt0304DAO.selectPyyt0304ListTotCnt(pyyt0304SrhVo);  
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;        
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginPsnl0100ToRemt0100DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            pyyt0304SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	pyyt0304SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	pyyt0304SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list  
	            List list = pyyt0304DAO.selectPyyt0304List(pyyt0304SrhVo);
	            
	            Iterator<Map<String, Object>> iter = list.iterator();
	                
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
	            while ( iter.hasNext() ) {
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

	                 		String rrnDecCrypt = "";
	                    			
	                 		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	                 	          			
	                 	          			
	                 			// 주민번호(복호화)
	                 			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	                 	          		
	                 			strValue = rrnDecCrypt;
	                 						
	                 		}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

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
	            
	            SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToRemt0100DataList, "getPsnl0100ToRemt0100DataList");
	       

		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}
	
	
	
	
	/**
	 * 수당 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getYeta5900ToPyyt0302ExtpyList(ServiceParameters serviceParameters) throws MSFException {

 	        PagingLoadResult<BaseModel> retval = null;
//	        String method =  "getPsnl0100ToRemt0100DataList";
	        String method = CLASS_YETA5900_TO_PYYT0302_EXTPY_DATA_LIST;
	        Pyyt0302Srh_2020_VO   pyyt0302SrhVo = new Pyyt0302Srh_2020_VO();
	        Pyyt0302_2020_VO      pyyt0304Vo = new Pyyt0302_2020_VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	    	// 1. 암호화 객체 생성
	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(pyyt0302DAO)) {
	        
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            pyyt0302DAO = (Ye17TaPyyt0302_2020_DAO) wac.getBean("Ye17TaPyyt0302_2020_DAO"); 
	        }
	        
	        try {
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	           // Sysm0400BM          user             = serviceParameters.getUser();
	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

	            //Get paging configuration
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	            //Get query parameters
	            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	              
	            List<String> listDeptCd = new ArrayList<String>();
	            
	            
	            
	            /** 조건절 */
	            pyyt0302SrhVo.setPyytItemCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyytItemCd")));	// 급여항목코드
	            pyyt0302SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));	// systemkey
	            pyyt0302SrhVo.setDpobCd(sessionUser.getDpobCd());  																	// 사업장코드
	            pyyt0302SrhVo.setPyytYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyytYrMnth")));	// 지급년월
	            pyyt0302SrhVo.setPyytPymtDducCd("B0080020");																		// 지급공제구분코드(수당)
	            pyyt0302SrhVo.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));			// 지급년월	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	             if ( pagingValues.executeRecordCount ) { 
	                    
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = pyyt0302DAO.selectPyyt0302ListTotCnt(pyyt0302SrhVo);  
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;        
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginPsnl0100ToRemt0100DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            pyyt0302SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	pyyt0302SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	pyyt0302SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list  
	            List list = pyyt0302DAO.selectPyyt0302List(pyyt0302SrhVo);
	            
	            Iterator<Map<String, Object>> iter = list.iterator();
	                
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
	            while ( iter.hasNext() ) {
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

	                 		String rrnDecCrypt = "";
	                    			
	                 		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	                 	          			
	                 	          			
	                 			// 주민번호(복호화)
	                 			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	                 	          		
	                 			strValue = rrnDecCrypt;
	                 						
	                 		}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

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
	            
	            SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToRemt0100DataList, "getPsnl0100ToRemt0100DataList");
	       

		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}
	
	
	
	/**
	 * 공제 조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getYeta5900ToPyyt0302DducList(ServiceParameters serviceParameters) throws MSFException {

 	        PagingLoadResult<BaseModel> retval = null;
//	        String method =  "getPsnl0100ToRemt0100DataList";
	        String method = CLASS_YETA5900_TO_PYYT0302_DDUC_DATA_LIST;
	        Pyyt0302Srh_2020_VO   pyyt0302SrhVo = new Pyyt0302Srh_2020_VO();
	        Pyyt0302_2020_VO      pyyt0304Vo = new Pyyt0302_2020_VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	    	// 1. 암호화 객체 생성
	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(pyyt0302DAO)) {
	        
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            pyyt0302DAO = (Ye17TaPyyt0302_2020_DAO) wac.getBean("Ye17TaPyyt0302_2020_DAO"); 
	        }
	        
	        try {
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	           // Sysm0400BM          user             = serviceParameters.getUser();
	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

	            //Get paging configuration
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	            //Get query parameters
	            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	              
	            List<String> listDeptCd = new ArrayList<String>();
	            
	            
	            
	            /** 조건절 */
	            pyyt0302SrhVo.setPyytItemCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyytItemCd")));	// 급여항목코드
	            pyyt0302SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));	// systemkey
	            pyyt0302SrhVo.setDpobCd(sessionUser.getDpobCd());  																	// 사업장코드
	            pyyt0302SrhVo.setPyytYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyytYrMnth")));	// 지급년월
	            pyyt0302SrhVo.setPyytPymtDducCd("B0080030");																		// 지급공제구분코드(수당)
	            pyyt0302SrhVo.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));			// 급여구분	            
	            
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	             if ( pagingValues.executeRecordCount ) { 
	                    
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = pyyt0302DAO.selectPyyt0302ListTotCnt(pyyt0302SrhVo);  
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;        
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginPsnl0100ToRemt0100DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            pyyt0302SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	pyyt0302SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	pyyt0302SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list  
	            List list = pyyt0302DAO.selectPyyt0302List(pyyt0302SrhVo);
	            
	            Iterator<Map<String, Object>> iter = list.iterator();
	                
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
	            while ( iter.hasNext() ) {
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

	                 		String rrnDecCrypt = "";
	                    			
	                 		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	                 	          			
	                 	          			
	                 			// 주민번호(복호화)
	                 			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	                 	          		
	                 			strValue = rrnDecCrypt;
	                 						
	                 		}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

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
	            
	            SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToRemt0100DataList, "getPsnl0100ToRemt0100DataList");
	       

		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}	
	
	
	
	
	/** 수당/공제항목 저장 및 삭제 **/ 
	@Override
	public int saveYeta5900ToPyyt0302(List<Pyyt0302DTO> listPyyt0302Dto, String flag)throws MSFException {
		// TODO Auto-generated method stub
		
		int iCnt = 0;
		
		Pyyt0302_2020_VO pyyt0302Vo = new Pyyt0302_2020_VO();
		Pyyt0304_2020_VO pyyt0304Vo = new Pyyt0304_2020_VO();
		
		String windowNm = "급여내역(정산용)관리";
		String windowId = "YETA5900";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		String method = calledClass + ".saveYeta5900ToPyyt0302";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		

		
		try{
			
			pyyt0302Vo = new Pyyt0302_2020_VO();
            
			for(int iYetaCnt=0; iYetaCnt < listPyyt0302Dto.size(); iYetaCnt++) {
	                    
				Pyyt0302DTO pyyt0302Dto = new Pyyt0302DTO();  
				pyyt0302Dto = listPyyt0302Dto.get(iYetaCnt);   
			
			
				pyyt0302Vo.setPyytItemCd(MSFSharedUtils.allowNulls(pyyt0302Dto.getPyytItemCd()));    									/** column 급여항목코드 : pyytItemCd */
				pyyt0302Vo.setSystemkey(MSFSharedUtils.allowNulls(pyyt0302Dto.getSystemkey()));    										/** column SYSTEMKEY : systemkey */
				pyyt0302Vo.setPayCd(MSFSharedUtils.allowNulls(pyyt0302Dto.getPayCd()));													/** column 급여구분코드 : payCd */
				pyyt0302Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    											/** column 사업장코드 : dpobCd */
				pyyt0302Vo.setPyytYrMnth(MSFSharedUtils.allowNulls(pyyt0302Dto.getPyytYrMnth()));    									/** column 지급년월 : pyytYrMnth */
				pyyt0302Vo.setPyytPymtDducCd(MSFSharedUtils.allowNulls(pyyt0302Dto.getPyytPymtDducCd()));    							/** column 지급공제구분코드 : pyytPymtDducCd */
				pyyt0302Vo.setPyytPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(pyyt0302Dto.getPyytPymtDducSum(), "0")));    	/** column 지급공제금액 : pyytPymtDducSum */
				pyyt0302Vo.setPyytPyddTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(pyyt0302Dto.getPyytPyddTxtnAmnt(), "0")));    /** column 지급공제과세금액 : pyytPyddTxtnAmnt */
				pyyt0302Vo.setPyytPyddFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(pyyt0302Dto.getPyytPyddFreeDtySum(), "0")));/** column 지급공제비과세금액 : pyytPyddFreeDtySum */
				pyyt0302Vo.setPyytYrtxDotnCd(MSFSharedUtils.allowNulls(pyyt0302Dto.getPyytYrtxDotnCd()));    							/** column 연말정산_기부금코드 : pyytYrtxDotnCd */
				pyyt0302Vo.setPyytYtfeDtyReduCd(MSFSharedUtils.allowNulls(pyyt0302Dto.getPyytYtfeDtyReduCd()));    						/** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
			
				pyyt0302Vo.setKybdr(sessionUser.getUsrId());
				pyyt0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				pyyt0302Vo.setIsmt(sessionUser.getUsrId());
				pyyt0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
				
				if("del".equals(flag)) {
					pyyt0302DAO.deletePyyt0302(pyyt0302Vo);
					
					iCnt = iCnt + 1;
				}else {
					pyyt0302DAO.updatePyyt0302(pyyt0302Vo);
					
					iCnt = iCnt + 1;
				}
				
				
				/** 수당공제항목(pyyt0302) 수정에 대한 마스터(pyyt0304) 업데이트**/
				pyyt0304Vo = new Pyyt0304_2020_VO();
				pyyt0304Vo.setDpobCd(pyyt0302Vo.getDpobCd());
				pyyt0304Vo.setSystemkey(pyyt0302Vo.getSystemkey());
				pyyt0304Vo.setPyytYrMnth(pyyt0302Vo.getPyytYrMnth());
				pyyt0304Vo.setPayCd(pyyt0302Vo.getPayCd());
				
				pyyt0304Vo.setIsmt(sessionUser.getUsrId());
				pyyt0304Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				
				pyyt0304DAO.updatePyyt0304(pyyt0304Vo);
				
			}
			
		}catch(Exception e){
			iCnt = 0;
			e.printStackTrace();
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		// ---------- 기본사항 수정 종료 -------------------
		
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U:D");
		// ---------- 주현근무지기납부세엑 소득세, 지방소득세 수정 종료 -------------------
		
		return iCnt;
	}
	
	
	
	
	/** 대상자 삭제 **/ 
	@Override
	public int deleteYeta5900List(List<Pyyt0302DTO> listPyyt0302Dto)throws MSFException {
		// TODO Auto-generated method stub
		
		int iCnt = 0;
		
		Pyyt0302_2020_VO pyyt0302Vo = new Pyyt0302_2020_VO();
		Pyyt0304_2020_VO pyyt0304Vo = new Pyyt0304_2020_VO();
		
		String windowNm = "급여내역(정산용)관리";
		String windowId = "YETA1900";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		String method = calledClass + ".deleteYeta5900List";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		

		
		try{
			
			pyyt0302Vo = new Pyyt0302_2020_VO();
            
			for(int iYetaCnt=0; iYetaCnt < listPyyt0302Dto.size(); iYetaCnt++) {
	                    
				Pyyt0302DTO pyyt0302Dto = new Pyyt0302DTO();  
				pyyt0302Dto = listPyyt0302Dto.get(iYetaCnt);   
			
			
//				pyyt0302Vo.setPyytItemCd(MSFSharedUtils.allowNulls(pyyt0302Dto.getPyytItemCd()));    									/** column 급여항목코드 : pyytItemCd */
				pyyt0302Vo.setSystemkey(MSFSharedUtils.allowNulls(pyyt0302Dto.getSystemkey()));    										/** column SYSTEMKEY : systemkey */
				pyyt0302Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    											/** column 사업장코드 : dpobCd */
				pyyt0302Vo.setPyytYrMnth(MSFSharedUtils.allowNulls(pyyt0302Dto.getPyytYrMnth()));    									/** column 지급년월 : pyytYrMnth */
//				pyyt0302Vo.setPyytPymtDducCd(MSFSharedUtils.allowNulls(pyyt0302Dto.getPyytPymtDducCd()));    							/** column 지급공제구분코드 : pyytPymtDducCd */
//				pyyt0302Vo.setPyytPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(pyyt0302Dto.getPyytPymtDducSum(), "0")));    	/** column 지급공제금액 : pyytPymtDducSum */
//				pyyt0302Vo.setPyytPyddTxtnAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(pyyt0302Dto.getPyytPyddTxtnAmnt(), "0")));    /** column 지급공제과세금액 : pyytPyddTxtnAmnt */
//				pyyt0302Vo.setPyytPyddFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(pyyt0302Dto.getPyytPyddFreeDtySum(), "0")));/** column 지급공제비과세금액 : pyytPyddFreeDtySum */
//				pyyt0302Vo.setPyytYrtxDotnCd(MSFSharedUtils.allowNulls(pyyt0302Dto.getPyytYrtxDotnCd()));    							/** column 연말정산_기부금코드 : pyytYrtxDotnCd */
//				pyyt0302Vo.setPyytYtfeDtyReduCd(MSFSharedUtils.allowNulls(pyyt0302Dto.getPyytYtfeDtyReduCd()));    						/** column 연말정산_비과세감면코드 : pyytYtfeDtyReduCd */
//				pyyt0302Vo.setKybdr(sessionUser.getUsrId());
//				pyyt0302Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//				pyyt0302Vo.setIsmt(sessionUser.getUsrId());
//				pyyt0302Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
				
				/** 수당공제 내역 삭제 **/
				pyyt0302DAO.deletePyyt0302_D(pyyt0302Vo);
				
				pyyt0304Vo = new Pyyt0304_2020_VO();
				pyyt0304Vo.setDpobCd(pyyt0302Vo.getDpobCd());
				pyyt0304Vo.setSystemkey(pyyt0302Vo.getSystemkey());
				pyyt0304Vo.setPyytYrMnth(pyyt0302Vo.getPyytYrMnth());
				
				/** 대상자 삭제  **/
				pyyt0304DAO.deletePyyt0304(pyyt0304Vo);
				
				iCnt = iCnt + 1;
				
			}
			
		}catch(Exception e){
			iCnt = 0;
			e.printStackTrace();
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		// ---------- 기본사항 수정 종료 -------------------
		
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D");
		// ---------- 주현근무지기납부세엑 소득세, 지방소득세 수정 종료 -------------------
		
		return iCnt;
	}
	
	
	
	/** 급여상세정보 조회 **/
	public Pyyt0304BM Yeta2900InfoList(Pyyt0304DTO pyyt0304Dto) {

		Pyyt0304Srh_2020_VO pyyt0304SrhVo = new Pyyt0304Srh_2020_VO();
		MSFSysm0100BM sessionUser;
			
		String method = calledClass + ".Yeta5900InfoList";

		String windowNm = "급여내역(정산용)관리";
		String windowId = "YETA1900";
			
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(pyyt0304DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
			pyyt0304DAO = (Ye17TaPyyt0304_2020_DAO) wac.getBean("Ye17TaPyyt0304_2020_DAO");
		}

		List<String> listDeptCd = new ArrayList<String>();

			/** 조건절 */
	    	pyyt0304SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	pyyt0304SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
	    	pyyt0304SrhVo.setUsrId(sessionUser.getUsrId());
	    	
	    	pyyt0304SrhVo.setPayCd(pyyt0304Dto.getPayCd());
         /******************************** 권한 ************************************************************************/
         String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
         if ("FALSE".equals(chkDeptCd)) {
        	 
        	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(pyyt0304Dto.getDeptCd(),sessionUser.getDeptCd()))) {
       			 
        	    	pyyt0304SrhVo.setDeptCd(sessionUser.getDeptCd()); 
                    listDeptCd.add(sessionUser.getDeptCd());
                    pyyt0304SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
            	   } else {
            		   pyyt0304SrhVo.setDeptCd(MSFSharedUtils.allowNulls(pyyt0304Dto.getDeptCd()));
                       listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(pyyt0304Dto.getDeptCd()));  
                       pyyt0304SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
            		 
            	  }  
         	
            pyyt0304SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
         } else {
         	pyyt0304SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(pyyt0304Dto.getPayrMangDeptCd())) ;   //단위기관코드   
                  if (pyyt0304SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(pyyt0304Dto.getDeptCd()))) { 
                  	 listDeptCd = null; 
                  	pyyt0304SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                  	pyyt0304SrhVo.setDeptCd("");  //부서코드
                  } else {
                 	 pyyt0304SrhVo.setDeptCd(MSFSharedUtils.allowNulls(pyyt0304Dto.getDeptCd()));
                       listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(pyyt0304Dto.getDeptCd()));  
                       pyyt0304SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                  } 
         }
         
//         } else {
//         	
//         }
         
         pyyt0304SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(pyyt0304Dto.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
         pyyt0304SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(pyyt0304Dto.getDtilOccuInttnCd()).replace(",", ""));   
         
        /******************************** 권한 ************************************************************************/
	     	
	     	
	        pyyt0304SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(pyyt0304Dto.getEmymtDivCd()));       //고용구분코드
	            
//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	     	pyyt0304SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	      	pyyt0304SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(pyyt0304Dto.getTypOccuCd())); 
	      	pyyt0304SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	     	pyyt0304SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(pyyt0304Dto.getTypOccuCd()));  //직종
	           
//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	     	pyyt0304SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	     	pyyt0304SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(pyyt0304Dto.getDtilOccuInttnCd())); 
	      	pyyt0304SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	pyyt0304SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(pyyt0304Dto.getDtilOccuInttnCd())); 	//직종세
	             
	    	pyyt0304SrhVo.setBusinCd(MSFSharedUtils.allowNulls(pyyt0304Dto.getBusinCd()));   				//사업코드
	           
	           
	    	pyyt0304SrhVo.setPyytYrMnth(MSFSharedUtils.allowNulls(pyyt0304Dto.getPyytYrMnth())); 			//년도
	       	pyyt0304SrhVo.setSystemkey(MSFSharedUtils.allowNulls(pyyt0304Dto.getSystemkey()));  			//시스템키
	      	pyyt0304SrhVo.setHanNm(MSFSharedUtils.allowNulls(pyyt0304Dto.getHanNm()));    					//한글성명 
	      	
	      	pyyt0304SrhVo.setFirstIndex(1);
	      	pyyt0304SrhVo.setLastIndex(1);
	      	

//			int iResultCnt = yeta2000DAO.selectYeta0300To2000ListTotCnt(pyyt0304SrhVo);  
			
			Pyyt0304BM returnPyyt0304 = new Pyyt0304BM();
			List egovResultDataList = new ArrayList();
			

			try {
				
				egovResultDataList =  pyyt0304DAO.selectPyyt0304List(pyyt0304SrhVo);
				
				// 2.복호화 리턴받을 값 선언
				String rrnDecCrypt = "";

				if(egovResultDataList != null && egovResultDataList.size() > 0){
					for(int i = 0 ; i < egovResultDataList.size(); i++){
						
						Map tempMap = (Map)egovResultDataList.get(i);
						Iterator<String> keys = tempMap.keySet().iterator();
						while( keys.hasNext() ){
				            String key = keys.next();
				            //형 타입이 숫자형일경우 형변환 해준다.
			            	if(tempMap.get(key) instanceof java.math.BigDecimal){
			            		returnPyyt0304.set(key, String.valueOf(tempMap.get(key)));
			            	}else{
			            		
			            		if("resnRegnNum".equals(key)) {
			            			// 복호화
			            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get(key))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
			            			returnPyyt0304.set(key, rrnDecCrypt);
			            			
			            		}else {
			            			returnPyyt0304.set(key, tempMap.get(key));
			            		}
			            	}
			            }
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
				
				// Return operation exception
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
			return returnPyyt0304;
		}




	@Override
	public Pyyt0304BM Yeta5900InfoList(Pyyt0304DTO Pyyt0304Dto)
			throws MSFException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
