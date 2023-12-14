package com.app.exterms.personal.server.service;

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
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.exterms.personal.client.dto.Psnl0300DTO;
import com.app.exterms.personal.client.service.Psnl0300Service;
import com.app.exterms.personal.server.service.dao.Psnl0100DAO;
import com.app.exterms.personal.server.service.dao.Psnl0300DAO;
import com.app.exterms.personal.server.service.dao.Psnl0310DAO;
import com.app.exterms.personal.server.vo.Psnl0110VO;
import com.app.exterms.personal.server.vo.Psnl0300SrhVO;
import com.app.exterms.personal.server.vo.Psnl0300VO;
import com.app.exterms.personal.server.vo.Psnl0310VO;
import com.app.exterms.personal.shared.PsnlDaoConstants;
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
import com.ext.constants.PropPayGenConfs;
import com.ext.constants.SysmConf;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.ibm.icu.text.SimpleDateFormat;

/**
 * @Class Name : Psnl0300ServiceImpl.java
 * @Description : Psnl0300 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("psnl0300Service")
public class Psnl0300ServiceImpl extends AbstractCustomServiceImpl implements Psnl0300Service, PsnlDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Psnl0300ServiceImpl.class);	
    private static final String calledClass = Psnl0300ServiceImpl.class.getName();
	
    private static final long serialVersionUID = 1L;
    
    
	@Resource(name="psnl0100DAO")
    private Psnl0100DAO psnl0100DAO;
	
	@Resource(name="psnl0300DAO")
    private Psnl0300DAO psnl0300DAO;
	
	@Resource(name="psnl0310DAO")
    private Psnl0310DAO psnl0310DAO;
	
	
	
	//조회
	public PagingLoadResult<BaseModel> getPsnl0300DataList(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0300_DATA_LIST;
		Psnl0300SrhVO   psnl0300SrhVO = new Psnl0300SrhVO();
//		Psnl0126VO      psnl0126VO = new Psnl0126VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(psnl0300DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			psnl0300DAO = (Psnl0300DAO) wac.getBean("psnl0300DAO" ); 
		}
	        
		try {
			
			//암호화 객체 생성
	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    	
			//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
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
//	    	psnl0300SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
//	    	psnl0300SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
////	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
//	     	
//	    	psnl0300SrhVO.setUsrId(sessionUser.getUsrId());
//            /******************************** 권한 ************************************************************************/
//            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//            if ("FALSE".equals(chkDeptCd)) {
//            	psnl0300SrhVO.setDeptCd(sessionUser.getDeptCd()); 
//               listDeptCd.add(sessionUser.getDeptCd());
//               psnl0300SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
//               psnl0300SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//            } else {
//            	psnl0300SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
//                     if (psnl0300SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
//                     	 listDeptCd = null; 
//                     	psnl0300SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//                     	psnl0300SrhVO.setDeptCd("");  //부서코드
//                     } else {
//                    	 psnl0300SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
//                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//                          psnl0300SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
//                     } 
//            }
//            
////            } else {
////            	
////            }
//            
//            psnl0300SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
//            psnl0300SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
//            
//           /******************************** 권한 ************************************************************************/
//	     	
//	     	
//	        psnl0300SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
//	            
////	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
////	     	psnl0300SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
////	      	psnl0300SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//	            
//	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
//	      	psnl0300SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
//	     	psnl0300SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//	           
////	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
////	     	psnl0300SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
////	     	psnl0300SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//	             
//	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
//	      	psnl0300SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//	     	psnl0300SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
//	             
//	    	psnl0300SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
//	           
//	           
//	    	psnl0300SrhVO.setHodyApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hodyApptnYr"))); //년도
//	       	psnl0300SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
//	      	psnl0300SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	          
	    	
	    	
	    	psnl0300SrhVO.setAppmtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "appmtDivCd")));  
	    	psnl0300SrhVO.setAppmtFixYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "appmtFixYn")));  
	    	psnl0300SrhVO.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")));  
	    	psnl0300SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));  
	    	psnl0300SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	    	psnl0300SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));  
	    	psnl0300SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")));
	    	psnl0300SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  
	    	
	    	
	    	
	    	
//	    	psnl0300SrhVO.setResnRegnNum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "resnRegnNum")));  
	    	// 2. 파라미터 보낼 때(암호화)
	    	psnl0300SrhVO.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));			
	    	
	    	
	    	psnl0300SrhVO.setAppmtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "appmtDtS")));
	    	psnl0300SrhVO.setAppmtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "appmtDtE")));
	    	psnl0300SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));
	    	
	    	
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = psnl0300DAO.selectPsnl0300ListTotCnt(psnl0300SrhVO);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0300DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	psnl0300SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		psnl0300SrhVO.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		psnl0300SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = psnl0300DAO.selectPsnl0300List(psnl0300SrhVO);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
			
	           
			while (iter.hasNext()) {
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
	            	
	          		case ColumnDef.TYPE_STRING: 
	          			
	          			
	          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
   			
		          		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
		          			
		          			String rrnDecCrypt = "";
		          			
		          			// TODO 주민번호
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		
							strValue = rrnDecCrypt;
							
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0300DataList, "getPsnl0300DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	/** 발령 팝업 조회 **/
	public PagingLoadResult<BaseModel> getPsnlP0300DataList(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNLP0300_DATA_LIST;
		Psnl0300SrhVO   psnl0300SrhVO = new Psnl0300SrhVO();
//		Psnl0126VO      psnl0126VO = new Psnl0126VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(psnl0300DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			psnl0300DAO = (Psnl0300DAO) wac.getBean("psnl0300DAO" ); 
		}
	        
		try {
			
			//암호화 객체 생성
	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    	
			//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
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
//	    	psnl0300SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
//	    	psnl0300SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
////	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
//	     	
//	    	psnl0300SrhVO.setUsrId(sessionUser.getUsrId());
//            /******************************** 권한 ************************************************************************/
//            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//            if ("FALSE".equals(chkDeptCd)) {
//            	psnl0300SrhVO.setDeptCd(sessionUser.getDeptCd()); 
//               listDeptCd.add(sessionUser.getDeptCd());
//               psnl0300SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
//               psnl0300SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//            } else {
//            	psnl0300SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
//                     if (psnl0300SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
//                     	 listDeptCd = null; 
//                     	psnl0300SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//                     	psnl0300SrhVO.setDeptCd("");  //부서코드
//                     } else {
//                    	 psnl0300SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
//                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//                          psnl0300SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
//                     } 
//            }
//            
////            } else {
////            	
////            }
//            
//            psnl0300SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
//            psnl0300SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
//            
//           /******************************** 권한 ************************************************************************/
//	     	
//	     	
//	        psnl0300SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
//	            
////	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
////	     	psnl0300SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
////	      	psnl0300SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//	            
//	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
//	      	psnl0300SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
//	     	psnl0300SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//	           
////	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
////	     	psnl0300SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
////	     	psnl0300SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//	             
//	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
//	      	psnl0300SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//	     	psnl0300SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
//	             
//	    	psnl0300SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
//	           
//	           
//	    	psnl0300SrhVO.setHodyApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hodyApptnYr"))); //년도
//	       	psnl0300SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
//	      	psnl0300SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	          
	    	
	    	
	    	psnl0300SrhVO.setAppmtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "appmtDivCd")));  
//	    	psnl0300SrhVO.setAppmtFixYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "appmtFixYn")));  
//	    	psnl0300SrhVO.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "currAffnDeptCd")));  
	    	psnl0300SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));  
	    	psnl0300SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	    	psnl0300SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));  
	    	psnl0300SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  
	    	
	    	
	    	
	    	
	    	// 2. 파라미터 보낼 때(암호화)
//	    	psnl0300SrhVO.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));			
//	    	
//	    	
//	    	psnl0300SrhVO.setAppmtDtS(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "appmtDtS")));
//	    	psnl0300SrhVO.setAppmtDtE(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "appmtDtE")));
//	    	psnl0300SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));
	    	
	    	
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = psnl0300DAO.selectPsnlP0300ListTotCnt(psnl0300SrhVO);  
	          	
	          	if(iResultCnt == 0){// 발령대상자가 없을경우  인사마스터에서 재직인 상대 목록 가져옴.
	          		iResultCnt = psnl0300DAO.selectPsnlP0300MasterListTotCnt(psnl0300SrhVO);
				}
	          	
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0300DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	psnl0300SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		psnl0300SrhVO.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		psnl0300SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	
	     	
	     	List list = psnl0300DAO.selectPsnlP0300List(psnl0300SrhVO);
			
			if(list == null || list.size() == 0){// 발령대상자가 없을경우  인사마스터에서 재직인 상대 목록 가져옴.
				list = psnl0300DAO.selectPsnlP0300MasterList(psnl0300SrhVO);
			}
	     	
	     	
//	     	List list = psnl0300DAO.selectPsnl0300List(psnl0300SrhVO);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
			
	           
			while (iter.hasNext()) {
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
	            	
	          		case ColumnDef.TYPE_STRING: 
	          			
	          			
	          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
   			
		          		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
		          			
		          			String rrnDecCrypt = "";
		          			
		          			// TODO 주민번호
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		
							strValue = rrnDecCrypt;
							
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0300DataList, "getPsnl0300DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
		
	
	
	
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BaseListLoadResult<Psnl0300DTO> selectPsnl0300(
			BaseListLoadConfig config, Psnl0300DTO dtoParam) throws Exception {
		List<Psnl0300DTO> returnValue = new ArrayList<Psnl0300DTO>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".selectPsnl0300";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "발령관리";
		String windowId = "PSNL0300";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		try{
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";
			
			egovResultDataList = psnl0300DAO.selectPsnl0300(dtoParam);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0300DTO dto = new Psnl0300DTO();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		dto.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		dto.set(key, tempMap.get(key));
		            	}
		            }
					
					// 3.복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dto.setResnRegnNum(rrnDecCrypt);
					
					returnValue.add(dto);
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
		
		return new BaseListLoadResult<Psnl0300DTO>(returnValue);
	}

	@Override
	public int deletePsnl0300(List<Psnl0300DTO> list) throws Exception {
		int delCnt = 0; 
		for(Psnl0300DTO dto : list){
			int del = psnl0300DAO.deletePsnl0300(dto);
			del += psnl0300DAO.deletePsnl0310(dto);
			if(del == 2)delCnt++;
		}
		return delCnt;
	}
	
	
    @Override
    public int deletePsnl0300List(List<BaseModel> listModels) {
    	
        // TODO Auto-generated method stub
    	int result = 0;
        int iCnt = 0;
        int delCnt = 0; 
		
        try { 
            
        	Psnl0300DTO dto = new Psnl0300DTO(); 
            
			if (MSFSharedUtils.paramNull(psnl0300DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils
						.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
				psnl0300DAO = (Psnl0300DAO) wac.getBean("Psnl0300DAO");
			}
            
      
			Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)listModels.iterator();
			while (iterRecords.hasNext()) {
                  
				BaseModel bmMapModel = (BaseModel) iterRecords.next();
                       
//				dto.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd"))); 
//				dto.setAppmtSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("appmtSeilNum"))); 
//				dto.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey"))) ; 
//				dto.setAppmtSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("appmtSeilNum"))) ; 
                    
				int del = psnl0300DAO.deletePsnl0300(dto);
				del += psnl0300DAO.deletePsnl0310(dto);

				if (del == 2) {
					iCnt++;
				}
			}
			result = iCnt;
		}
        catch (Exception ex) {
            logger.error("EXCEPTION calling deletePsnl0300List(): "+ex); 
            result = 0;
            throw MSFServerUtils.getOperationException("deletePsnl0300List", ex, logger);
        }
        finally {
          
        }
        return result;
    }

    
    /** 개별발령 저장 **/
	@Override
	public String appointmentSave(Psnl0300DTO psnl0300Dto) throws Exception {
		
		
		
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//		dto.setIsmt(sessionUser.getUsrId());
//		dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		String returnValue = "";
		try{
			
			//발령일련번호를 가져온다.
			String appmtSeilNum = psnl0300DAO.getMaxAppmtSeilNum();
//			dto.setAppmtSeilNum(appmtSeilNum);

			Psnl0300VO psnl0300Vo = new Psnl0300VO();  
         
			psnl0300Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    								/** column 사업장코드 : dpobCd */
			psnl0300Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0300Dto.getSystemkey()));    							/** column SYSTEMKEY : systemkey */
			psnl0300Vo.setAppmtNum(MSFSharedUtils.allowNulls(psnl0300Dto.getAppmtNum()));    							/** column 발령번호 : appmtNum */
			psnl0300Vo.setAppmtDivCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAppmtDivCd()));    						/** column 발령구분코드 : appmtDivCd */
			psnl0300Vo.setAppmtDt(MSFSharedUtils.allowNulls(psnl0300Dto.getAppmtDt()));    								/** column 발령일자 : appmtDt */
			psnl0300Vo.setAppmtBssCtnt(MSFSharedUtils.allowNulls(psnl0300Dto.getAppmtBssCtnt()));    					/** column 발령근거내용 : appmtBssCtnt */
			psnl0300Vo.setAppmtIstut(MSFSharedUtils.allowNulls(psnl0300Dto.getAppmtIstut()));    						/** column 발령기관 : appmtIstut */
			psnl0300Vo.setBgnnDt(MSFSharedUtils.allowNulls(psnl0300Dto.getBgnnDt()));    								/** column 시작일자 : bgnnDt */
			psnl0300Vo.setEndDt(MSFSharedUtils.allowNulls(psnl0300Dto.getEndDt()));    									/** column 종료일자 : endDt */
			psnl0300Vo.setDeptCd(MSFSharedUtils.allowNulls(psnl0300Dto.getDeptCd()));    								/** column 부서코드 : deptCd */
			psnl0300Vo.setBusinCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBusinCd()));    								/** column 사업코드 : businCd */
			psnl0300Vo.setTypOccuCd(MSFSharedUtils.allowNulls(psnl0300Dto.getTypOccuCd()));    							/** column 직종코드 : typOccuCd */
			psnl0300Vo.setOdtyCd(MSFSharedUtils.allowNulls(psnl0300Dto.getOdtyCd()));    								/** column 직책코드 : odtyCd */
			psnl0300Vo.setPyspCd(MSFSharedUtils.allowNulls(psnl0300Dto.getPyspCd()));    								/** column 호봉코드 : pyspCd */
			psnl0300Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(psnl0300Dto.getPyspGrdeCd()));    						/** column 호봉등급코드 : pyspGrdeCd */
			psnl0300Vo.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(psnl0300Dto.getLogSvcYrNumCd()));   	 				/** column 근속년수코드 : logSvcYrNumCd */
			psnl0300Vo.setDsnyActDivCd(MSFSharedUtils.allowNulls(psnl0300Dto.getDsnyActDivCd()));    					/** column 징계구분코드 : dsnyActDivCd */
			psnl0300Vo.setCtwpMnthNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0300Dto.getCtwpMnthNum(), "0"))); 	/** column 감봉월수 : ctwpMnthNum */
			psnl0300Vo.setPernAppmtNoteCtnt(MSFSharedUtils.allowNulls(psnl0300Dto.getPernAppmtNoteCtnt()));    			/** column 인사발령비고내용 : pernAppmtNoteCtnt */
			psnl0300Vo.setAppmtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(appmtSeilNum, "0")));					/** column 발령일련번호 : appmtSeilNum */
			psnl0300Vo.setTypOccuInttnCd(MSFSharedUtils.allowNulls(psnl0300Dto.getTypOccuInttnCd()));    				/** column 직종통합코드 : typOccuInttnCd */
			psnl0300Vo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(psnl0300Dto.getDtilOccuClsDivCd()));    			/** column 직종세구분코드 : dtilOccuClsDivCd */
			psnl0300Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(psnl0300Dto.getDtilOccuInttnCd()));    				/** column 직종세통합구분코드 : dtilOccuInttnCd */
			psnl0300Vo.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(psnl0300Dto.getLogSvcMnthIcmCd()));    				/** column 근속월수코드 : logSvcMnthIcmCd */
			
			psnl0300Vo.setKybdr(sessionUser.getUsrId());    															/** column 입력자 : kybdr */
			psnl0300Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    						/** column 입력주소 : inptAddr */
			psnl0300Vo.setIsmt(sessionUser.getUsrId());    																/** column 수정자 : ismt */
			psnl0300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    						/** column 수정주소 : revnAddr */
			
			Psnl0310VO psnl0310Vo = new Psnl0310VO();  
			
			psnl0310Vo.setDpobCd(MSFSharedUtils.allowNulls(psnl0300Vo.getDpobCd()));    							/** column 사업장코드 : dpobCd */
			psnl0310Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0300Vo.getSystemkey()));    						/** column SYSTEMKEY : systemkey */
			psnl0310Vo.setAppmtSeilNum(psnl0300Vo.getAppmtSeilNum());    											/** column 발령일련번호 : appmtSeilNum */
			psnl0310Vo.setAppmtDivCd(MSFSharedUtils.allowNulls(psnl0300Vo.getAppmtDivCd()));    					/** column 발령구분코드 : appmtDivCd */
			psnl0310Vo.setAppmtDt(MSFSharedUtils.allowNulls(psnl0300Dto.getAppmtDt()));    							/** column 발령일자 : appmtDt */
			psnl0310Vo.setBfrDeptCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrDeptCd()));    						/** column 전_부서코드 : bfrDeptCd */
			psnl0310Vo.setBfrBusinCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrBusinCd()));    					/** column 전_사업코드 : bfrBusinCd */
			psnl0310Vo.setBfrTypOccuDivCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrTypOccuDivCd()));    			/** column 전_직종구분코드 : bfrTypOccuDivCd */
			psnl0310Vo.setBfrOdtyDivCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrOdtyDivCd()));    				/** column 전_직책구분코드 : bfrOdtyDivCd */
			psnl0310Vo.setBfrPyspCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrPyspCd()));    						/** column 전호봉코드 : bfrPyspCd */
			psnl0310Vo.setBfrPyspGrdeCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrPyspGrdeCd()));    				/** column 전호봉등급코드 : bfrPyspGrdeCd */
			psnl0310Vo.setBfrLogSvcYrNumCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrLogSvcYrNumCd()));    		/** column 전근속년수코드 : bfrLogSvcYrNumCd */
			psnl0310Vo.setAftDeptCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftDeptCd()));    						/** column 후_부서코드 : aftDeptCd */
			psnl0310Vo.setAftBusinCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftBusinCd()));    					/** column 후_사업코드 : aftBusinCd */
			psnl0310Vo.setAftTypOccuDivCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftTypOccuDivCd()));    			/** column 후_직종구분코드 : aftTypOccuDivCd */
			psnl0310Vo.setAftOdtyDivCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftOdtyDivCd()));    				/** column 후_직책구분코드 : aftOdtyDivCd */
			psnl0310Vo.setAftPyspCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftPyspCd()));    						/** column 후_호봉코드 : aftPyspCd */
			psnl0310Vo.setAftPyspGrdeCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftPyspGrdeCd()));    				/** column 후_호봉등급코드 : aftPyspGrdeCd */
			psnl0310Vo.setAftLogSvcYrNumCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftLogSvcYrNumCd()));    		/** column 후_근속년수코드 : aftLogSvcYrNumCd */
			psnl0310Vo.setAppmtFixYn(MSFSharedUtils.allowNulls(psnl0300Dto.getAppmtFixYn()));    					/** column 발령확정여부 : appmtFixYn */
			psnl0310Vo.setConfrtnPrtcDt(MSFSharedUtils.allowNulls(psnl0300Dto.getConfrtnPrtcDt()));    				/** column 배치실행일자 : confrtnPrtcDt */
			psnl0310Vo.setConfrtnPrcsYn(MSFSharedUtils.allowNulls(psnl0300Dto.getConfrtnPrcsYn()));    				/** column 배치처리여부 : confrtnPrcsYn */

			psnl0310Vo.setBfrDtilOccuInttnCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrDtilOccuInttnCd()));    	/** column 전직종세통합코드 : bfrDtilOccuInttnCd */
			psnl0310Vo.setBfrLogSvcMnthCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrLogSvcMnthCd()));    			/** column 전근속월수코드 : bfrLogSvcMnthCd */
			psnl0310Vo.setAftDtilOccuInttnCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftDtilOccuInttnCd()));    	/** column 후직종세통합코드 : aftDtilOccuInttnCd */
			psnl0310Vo.setAftLogSvcMnthCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftLogSvcMnthCd()));    			/** column 후근속월수코드 : aftLogSvcMnthCd */
			
			psnl0310Vo.setKybdr(sessionUser.getUsrId());    														/** column 입력자 : kybdr */
			psnl0310Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());						/** column 입력주소 : inptAddr */
			psnl0310Vo.setIsmt(sessionUser.getUsrId());    															/** column 수정자 : ismt */
			psnl0310Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());						/** column 수정주소 : revnAddr */
		
		
			//발령대상자 정보를 등록한다. PSNL0310
			psnl0310DAO.inserPsnl0310(psnl0310Vo);
			//인사발령 정보를 등록한다. PSNL0300
			psnl0300DAO.insertPsnl0300(psnl0300Vo);
			
		}catch(Exception ex) {
			
			
		}
//		//발령대상자 정보를 등록한다. PSNL0310
//		psnl0300DAO.inserPsnl0310(dto);
//		//인사발령 정보를 등록한다. PSNL0300
//		psnl0300DAO.insertPsnl0300(dto);
		
		return returnValue;
	}
	
	
	/** 개별발령 확정 **/
	@Override
	public String appointmentConfirmList(List<Psnl0300DTO> list) throws Exception {
		
		String returnValue = "";
		HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
		
		Psnl0110VO psnl0110Vo = new Psnl0110VO();  
		Psnl0300VO psnl0300Vo = new Psnl0300VO();  
		Psnl0310VO psnl0310Vo = new Psnl0310VO();  
		Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
		
		if(list != null && list.size() > 0){
			for(Psnl0300DTO dto : list){
				
				if("N".equals(dto.getAppmtFixYn())){
					MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
					dto.setIsmt(sessionUser.getUsrId());
					dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
					
					
					
//					/**
//					 * 1. 발령 관리 테이블 처리
//					 */
//					//과거 발령데이터 PSNL0300 종료일자 업데이트 처리한다.
//					psnl0300DAO.updatePsnl0300(dto);
//					//발령정보 여부를 Y로 업데이트 한다.
//					psnl0300DAO.updatePsnl0310(dto);
//					
////					//메인 인사테이블 수정
////					psnl0300DAO.updatePsnl0100(dto);
//					
//
//					/**
//					 * 2. 고용 관련 테이블 처리
//					 */
//					//발령구분 정보가 재고용(A0460020) 및 퇴직(A0460060)일 경우 고용구분 테이블에 등록  
//					if("A0460020".equals(dto.getAppmtDivCd()) || "A0460060".equals(dto.getAppmtDivCd()) ){
//						psnl0300DAO.insertPsnl0110(dto);
//					}
//					//직제변경(A0460080), 사업변경(A0460090) 일 경우 최상위 등록 처리
//					if("A0460080".equals(dto.getAppmtDivCd()) || "A0460090".equals(dto.getAppmtDivCd()) ){
//						psnl0300DAO.insertPsnl0110(dto);
//						//psnl0300DAO.updatePsnl0110(dto);
//					}
//					
//					
//					/**
//					 * 3. 인사 마스터 관련 테이블 처리
//					 */
//					
//					//메인 인사테이블 수정
//					psnl0300DAO.updatePsnl0100(dto);
//					
//					Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
//					psnl0100Dto.setDpobCd(sessionUser.getDpobCd());
//					psnl0100Dto.setSystemkey(dto.getSystemkey());
//					psnl0100Dto.setEmymtDivCd(dto.getEmymtDivCd());
//					psnl0100Dto.setEmymtBgnnDt(dto.getAppmtDt());
//					psnl0100Dto.setDeptCd(dto.getAftDeptCd());
//					psnl0100Dto.setBusinCd(dto.getAftBusinCd());
//					psnl0100Dto.setTypOccuCd(dto.getAftTypOccuDivCd());
////					psnl0100Dto.setDtilOccuInttnCd(dto.);
//					
//					
//					String yearStr = new SimpleDateFormat("yyyy").format(new Date());
//					
//					/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
//					/** 1차 : 고용 구분에 따라 **/
//					//기간제일 때
//					if("A0020020".equals(psnl0100Dto.getEmymtDivCd())) {
//						
//						// 연장계약 (재고용) 이며, 고용시작일자가 현재 년도보다 클 경우 사업은 update 쳐주지 않는다.
//						if(( "A0420030".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd()))
//							&& Integer.parseInt( psnl0100Dto.getEmymtBgnnDt().substring(0, 4)) > Integer.parseInt(yearStr)
//							) {
//							
//						}else {
//							returnValue += "_"+ psnl0100DAO.updatePsnl0100BUSIN_CD(psnl0100Dto);					//사업
//						}
//						
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
//						
//					}else if("A0020010".equals(psnl0100Dto.getEmymtDivCd())) {
//						
//						//공무직일 때
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100TYP_OCCU_CD(psnl0100Dto);					//직종
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100DTIL_OCCU_INTTN_CD(psnl0100Dto);			//직종세
//						
//					}
//					/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
//					
//					
//					
//					/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
//					/** 2차 : 고용 유형에 따라 **/
//					//신규 or 재고용
//					if("A0420010".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd())) {
//						
//						//고용구분코드 신규 or 직제개편
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				//소속 부서 
//						
//						// 진안군의 경우 기간제 -> 공무직 전환 시 현부서발령일은 공무직 신규입사일로 처리.
//						if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//							
//							psnl0100Dto.setEmymtDtTyp(psnl0100Dto.getEmymtDivCd());
//							
//						}else {
//							
//							psnl0100Dto.setEmymtDtTyp("");
//							
//						}
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);		//현부서 발령일
//						
//						
//						// 진안군의 경우 기간제 -> 공무직 전환 시 최초입사일자는 공무직 신규입사일로 처리.
//						if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//							
//							psnl0100Dto.setEmymtDtTyp(psnl0100Dto.getEmymtDivCd());
//							
//						}else {
//							
//							psnl0100Dto.setEmymtDtTyp("");
//							
//						}
//						//고용구분코드 신규일 때
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100FRST_EMYMT_DT(psnl0100Dto);				//최초고용일자
//						
//						
//					//직제개편	
//					}else if("A0420050".equals(psnl0100Dto.getEmymtTypCd())) {
//						//고용구분코드 신규 or 직제개편
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				//현부서
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
//					
//					//퇴직
//					}else if("A0420990".equals(psnl0100Dto.getEmymtTypCd())) {
//						//고용유형이 퇴직일때만
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
//							
//					//전보
//					}else if("A0420060".equals(psnl0100Dto.getEmymtTypCd())) {
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				//소속 부서 
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
//					// 연장계약
//					}else if("A0420030".equals(psnl0100Dto.getEmymtTypCd())) {
//						// 퇴직 후 연장계약 하는 경우도 있으므로 기존의 퇴직일자를 없애주기 위해 연장계약일 때도 퇴직일자 로직 타게끔 추가
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
//					}
//					/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
//						
//					
//					/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
//					/** 3차 : 공통 사항 **/
//		//			returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_DIV_CD(psnl0100Dto);	//고용구분
//					// 1. 고용구분 : 기간제 근로자, 2. 고용유형 : 재고용, 연장계약 , 3. 사업년도가 올해년도 보다 클 경우
//					if("A0020020".equals(psnl0100Dto.getEmymtDivCd()) 
//							&& ( "A0420030".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd()))
//							&& Integer.parseInt( psnl0100Dto.getEmymtBgnnDt().substring(0, 4)) > Integer.parseInt(yearStr)
//							) {
//						
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);					//고용종료일
//								
//					}else {
//						
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100EMYMT_BGNN_DT(psnl0100Dto);					//고용시작일
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);					//고용종료일
//						
//					}
//					
//					returnValue += "_"+ psnl0100DAO.updatePsnl0100HDOFC_CODTN_CD(psnl0100Dto);					//재직상태코드
//					returnValue += "_"+ psnl0100DAO.updatePsnl0100ODTY_CD(psnl0100Dto);							//직책코드
//					returnValue += "_"+ psnl0100DAO.updatePsnl0100RETRY_REAS_CTNT(psnl0100Dto);					//고용해제사유
//					
//					
//					// 용인시의 경우에는 소속부서 update 시 관리부서도 동일하게 update 처리 해준다.
//					if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//						returnValue += "_"+ psnl0100DAO.updatePsnl0100DEPT_CD(psnl0100Dto);						//관리 부서 
//						
//					}
//					/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
					
					
		                 
		            psnl0300Vo = new Psnl0300VO();  
		            
					psnl0300Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    						/** column 사업장코드 : dpobCd */
					psnl0300Vo.setSystemkey(MSFSharedUtils.allowNulls(dto.getSystemkey()));    							/** column SYSTEMKEY : systemkey */
					psnl0300Vo.setAppmtNum(MSFSharedUtils.allowNulls(dto.getAppmtNum()));    							/** column 발령번호 : appmtNum */
					psnl0300Vo.setAppmtDivCd(MSFSharedUtils.allowNulls(dto.getAppmtDivCd()));    						/** column 발령구분코드 : appmtDivCd */
					psnl0300Vo.setAppmtDt(MSFSharedUtils.allowNulls(dto.getAppmtDt()));    								/** column 발령일자 : appmtDt */
					psnl0300Vo.setAppmtBssCtnt(MSFSharedUtils.allowNulls(dto.getAppmtBssCtnt()));    					/** column 발령근거내용 : appmtBssCtnt */
					psnl0300Vo.setAppmtIstut(MSFSharedUtils.allowNulls(dto.getAppmtIstut()));    						/** column 발령기관 : appmtIstut */
					psnl0300Vo.setBgnnDt(MSFSharedUtils.allowNulls(dto.getBgnnDt()));    								/** column 시작일자 : bgnnDt */
					psnl0300Vo.setEndDt(MSFSharedUtils.allowNulls(dto.getEndDt()));    									/** column 종료일자 : endDt */
					psnl0300Vo.setDeptCd(MSFSharedUtils.allowNulls(dto.getAftDeptCd()));    							/** column 부서코드 : deptCd */
					psnl0300Vo.setBusinCd(MSFSharedUtils.allowNulls(dto.getAftBusinCd()));    							/** column 사업코드 : businCd */
					psnl0300Vo.setTypOccuCd(MSFSharedUtils.allowNulls(dto.getAftTypOccuDivCd()));    					/** column 직종코드 : typOccuCd */
					psnl0300Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(dto.getAftDtilOccuInttnCd()));    			/** column 직종세통합구분코드 : dtilOccuInttnCd */
					
					if(MSFSharedUtils.paramNotNull(dto.getAftDtilOccuInttnCd())) {
						psnl0300Vo.setDtilOccuClsDivCd(dto.getAftDtilOccuInttnCd().substring(0, 8));    				/** column 직종세구분코드 : dtilOccuClsDivCd */
					}
					
					psnl0300Vo.setOdtyCd(MSFSharedUtils.allowNulls(dto.getAftOdtyDivCd()));    							/** column 직책코드 : odtyCd */
					psnl0300Vo.setPyspCd(MSFSharedUtils.allowNulls(dto.getAftPyspCd()));    							/** column 호봉코드 : pyspCd */
					psnl0300Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(dto.getPyspGrdeCd()));    						/** column 호봉등급코드 : pyspGrdeCd */
					psnl0300Vo.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(dto.getLogSvcYrNumCd()));   	 				/** column 근속년수코드 : logSvcYrNumCd */
					psnl0300Vo.setDsnyActDivCd(MSFSharedUtils.allowNulls(dto.getDsnyActDivCd()));    					/** column 징계구분코드 : dsnyActDivCd */
					psnl0300Vo.setCtwpMnthNum(new BigDecimal(MSFSharedUtils.defaultNulls(dto.getCtwpMnthNum(), "0"))); 	/** column 감봉월수 : ctwpMnthNum */
					psnl0300Vo.setPernAppmtNoteCtnt(MSFSharedUtils.allowNulls(dto.getPernAppmtNoteCtnt()));    			/** column 인사발령비고내용 : pernAppmtNoteCtnt */
					psnl0300Vo.setAppmtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(dto.getAppmtSeilNum(), "0")));/** column 발령일련번호 : appmtSeilNum */
					psnl0300Vo.setTypOccuInttnCd(MSFSharedUtils.allowNulls(dto.getTypOccuInttnCd()));    				/** column 직종통합코드 : typOccuInttnCd */
				
					
					psnl0300Vo.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(dto.getLogSvcMnthIcmCd()));    				/** column 근속월수코드 : logSvcMnthIcmCd */
					
					psnl0300Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
					psnl0300Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    				/** column 입력주소 : inptAddr */
					psnl0300Vo.setIsmt(sessionUser.getUsrId());    														/** column 수정자 : ismt */
					psnl0300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    				/** column 수정주소 : revnAddr */
					
					psnl0310Vo = new Psnl0310VO();  
					
					psnl0310Vo.setDpobCd(MSFSharedUtils.allowNulls(psnl0300Vo.getDpobCd()));    						/** column 사업장코드 : dpobCd */
					psnl0310Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0300Vo.getSystemkey()));    					/** column SYSTEMKEY : systemkey */
					psnl0310Vo.setAppmtSeilNum(psnl0300Vo.getAppmtSeilNum());    										/** column 발령일련번호 : appmtSeilNum */
					psnl0310Vo.setAppmtDivCd(MSFSharedUtils.allowNulls(psnl0300Vo.getAppmtDivCd()));    				/** column 발령구분코드 : appmtDivCd */
					psnl0310Vo.setAppmtDt(MSFSharedUtils.allowNulls(dto.getAppmtDt()));    								/** column 발령일자 : appmtDt */
					psnl0310Vo.setBfrDeptCd(MSFSharedUtils.allowNulls(dto.getBfrDeptCd()));    							/** column 전_부서코드 : bfrDeptCd */
					psnl0310Vo.setBfrBusinCd(MSFSharedUtils.allowNulls(dto.getBfrBusinCd()));    						/** column 전_사업코드 : bfrBusinCd */
					psnl0310Vo.setBfrTypOccuDivCd(MSFSharedUtils.allowNulls(dto.getBfrTypOccuDivCd()));    				/** column 전_직종구분코드 : bfrTypOccuDivCd */
					psnl0310Vo.setBfrOdtyDivCd(MSFSharedUtils.allowNulls(dto.getBfrOdtyDivCd()));    					/** column 전_직책구분코드 : bfrOdtyDivCd */
					psnl0310Vo.setBfrPyspCd(MSFSharedUtils.allowNulls(dto.getBfrPyspCd()));    							/** column 전호봉코드 : bfrPyspCd */
					psnl0310Vo.setBfrPyspGrdeCd(MSFSharedUtils.allowNulls(dto.getBfrPyspGrdeCd()));    					/** column 전호봉등급코드 : bfrPyspGrdeCd */
					psnl0310Vo.setBfrLogSvcYrNumCd(MSFSharedUtils.allowNulls(dto.getBfrLogSvcYrNumCd()));    			/** column 전근속년수코드 : bfrLogSvcYrNumCd */
					psnl0310Vo.setAftDeptCd(MSFSharedUtils.allowNulls(dto.getAftDeptCd()));    							/** column 후_부서코드 : aftDeptCd */
					psnl0310Vo.setAftBusinCd(MSFSharedUtils.allowNulls(dto.getAftBusinCd()));    						/** column 후_사업코드 : aftBusinCd */
					psnl0310Vo.setAftTypOccuDivCd(MSFSharedUtils.allowNulls(dto.getAftTypOccuDivCd()));    				/** column 후_직종구분코드 : aftTypOccuDivCd */
					psnl0310Vo.setAftOdtyDivCd(MSFSharedUtils.allowNulls(dto.getAftOdtyDivCd()));    					/** column 후_직책구분코드 : aftOdtyDivCd */
					psnl0310Vo.setAftPyspCd(MSFSharedUtils.allowNulls(dto.getAftPyspCd()));    							/** column 후_호봉코드 : aftPyspCd */
					psnl0310Vo.setAftPyspGrdeCd(MSFSharedUtils.allowNulls(dto.getAftPyspGrdeCd()));    					/** column 후_호봉등급코드 : aftPyspGrdeCd */
					psnl0310Vo.setAftLogSvcYrNumCd(MSFSharedUtils.allowNulls(dto.getAftLogSvcYrNumCd()));    			/** column 후_근속년수코드 : aftLogSvcYrNumCd */
					psnl0310Vo.setAppmtFixYn(MSFSharedUtils.allowNulls(dto.getAppmtFixYn()));    						/** column 발령확정여부 : appmtFixYn */
					psnl0310Vo.setConfrtnPrtcDt(MSFSharedUtils.allowNulls(dto.getConfrtnPrtcDt()));    					/** column 배치실행일자 : confrtnPrtcDt */
					psnl0310Vo.setConfrtnPrcsYn(MSFSharedUtils.allowNulls(dto.getConfrtnPrcsYn()));    					/** column 배치처리여부 : confrtnPrcsYn */
		
					psnl0310Vo.setBfrDtilOccuInttnCd(MSFSharedUtils.allowNulls(dto.getBfrDtilOccuInttnCd()));    		/** column 전직종세통합코드 : bfrDtilOccuInttnCd */
					psnl0310Vo.setBfrLogSvcMnthCd(MSFSharedUtils.allowNulls(dto.getBfrLogSvcMnthCd()));    				/** column 전근속월수코드 : bfrLogSvcMnthCd */
					psnl0310Vo.setAftDtilOccuInttnCd(MSFSharedUtils.allowNulls(dto.getAftDtilOccuInttnCd()));    		/** column 후직종세통합코드 : aftDtilOccuInttnCd */
					psnl0310Vo.setAftLogSvcMnthCd(MSFSharedUtils.allowNulls(dto.getAftLogSvcMnthCd()));    				/** column 후근속월수코드 : aftLogSvcMnthCd */
					
					psnl0310Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
					psnl0310Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					/** column 입력주소 : inptAddr */
					psnl0310Vo.setIsmt(sessionUser.getUsrId());    														/** column 수정자 : ismt */
					psnl0310Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());					/** column 수정주소 : revnAddr */
					
					
					// ==============================================================================================
					// 1. 인사마스터 정보데이터일경우 먼저 발령테이블에 등록하여준다.
					// ==============================================================================================
					if("0".equals(MSFSharedUtils.defaultNulls(dto.getAppmtSeilNum(), "0"))
							|| MSFSharedUtils.defaultNulls(dto.getAppmtSeilNum(), "0") == "0" ){ //인사마스터 정보데이터
						//발령일련번호를 가져온다.
						String appmtSeilNum = psnl0300DAO.getMaxAppmtSeilNum();
//						dto.setAppmtSeilNum(appmtSeilNum);
						
						
						psnl0300Vo.setAppmtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(appmtSeilNum, "0")));				/** column 발령일련번호 : appmtSeilNum */
						psnl0310Vo.setAppmtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(appmtSeilNum, "0")));				/** column 발령일련번호 : appmtSeilNum */
						
						
						//발령대상자 정보를 등록한다. PSNL0310
						psnl0310DAO.inserPsnl0310(psnl0310Vo);
						//인사발령 정보를 등록한다. PSNL0300
						psnl0300DAO.insertPsnl0300(psnl0300Vo);
						
					}
					
					// ==============================================================================================
					// 2. 과거 발령데이터 PSNL0300 종료일자 업데이트 처리한다.
					// ==============================================================================================
					psnl0300DAO.updatePsnl0300_END_DT(psnl0300Vo);
					
					
					// ==============================================================================================
					// 3. 발령정보 여부를 Y로 업데이트 한다.
					// ==============================================================================================
					psnl0310DAO.updatePsnl0310_APPMT_FIX_YN(psnl0310Vo);
					
					
					
					// ==============================================================================================
					// 4. 발령구분 정보가 재고용(A0460020), 퇴직(A0460060), 직제변경(A0460080), 사업변경(A0460090)일 경우 고용구분 테이블에 등록  
					// ==============================================================================================
					if("A0460020".equals(psnl0300Vo.getAppmtDivCd()) || "A0460060".equals(psnl0300Vo.getAppmtDivCd()) 
							|| "A0460080".equals(psnl0300Vo.getAppmtDivCd()) || "A0460090".equals(psnl0300Vo.getAppmtDivCd())){
						
						psnl0110Vo = new Psnl0110VO(); 
						
						psnl0110Vo.setDpobCd(psnl0300Vo.getDpobCd());    								/** column 사업장코드 : dpobCd */
						psnl0110Vo.setSystemkey(psnl0300Vo.getSystemkey());    							/** column SYSTEMKEY : systemkey */
//						psnl0110Vo.setEmymtSeilNum(psnl0110Dto.getEmymtSeilNum());    /** column 고용일련번호 : emymtSeilNum */
						psnl0110Vo.setEmymtDivCd(dto.getEmymtDivCd());    								/** column 고용구분코드 : emymtDivCd */
						psnl0110Vo.setEmymtTypCd(psnl0300Vo.getAppmtDivCd());    						/** column 고용유형코드 : emymtTypCd */
						psnl0110Vo.setEmymtBgnnDt(psnl0300Vo.getAppmtDt());    							/** column 고용시작일자 : emymtBgnnDt */

						psnl0110Vo.setDeptCd(psnl0300Vo.getDeptCd());    								/** column 부서코드 : deptCd */
						psnl0110Vo.setBusinCd(psnl0300Vo.getBusinCd());    								/** column 사업코드 : businCd */
						psnl0110Vo.setTypOccuCd(psnl0300Vo.getTypOccuCd());    							/** column 직종코드 : typOccuCd */
						psnl0110Vo.setDtilOccuClsDivCd(psnl0300Vo.getDtilOccuClsDivCd());    			/** column 직종세구분코드 : dtilOccuClsDivCd */
						psnl0110Vo.setOdtyCd(psnl0300Vo.getOdtyCd());    								/** column 직책코드 : odtyCd */
						psnl0110Vo.setDtilOccuInttnCd(psnl0300Vo.getDtilOccuInttnCd());    				/** column 직종통합코드 : dtilOccuInttnCd */
						psnl0110Vo.setPyspGrdeCd(psnl0300Vo.getPyspGrdeCd());    						/** column 호봉등급코드 : pyspGrdeCd */
						
						// 종료일자는 쿼리에서 가장 최신의 종료일자를 가지고 와 입력해준다.
//						psnl0110Vo.setEmymtEndDt(psnl0110Dto.getEmymtEndDt());    		/** column 고용종료일자 : emymtEndDt */
						// 현근무지명은  쿼리에서 가장 최신의 종료일자를 가지고 와 입력해준다.
//						psnl0110Vo.setCurrPaeWorkNm(psnl0110Dto.getCurrPaeWorkNm());    /** column 현근무지명 : currPaeWorkNm */
//						psnl0110Vo.setPayPymtDivCd(psnl0110Dto.getPayPymtDivCd());    						/** column 급여지급구분코드 : payPymtDivCd */
//						psnl0110Vo.setEmymtSum(psnl0110Dto.getEmymtSum());    								/** column 고용금액 : emymtSum */
//						psnl0110Vo.setCertNumHuhd(psnl0110Dto.getCertNumHuhd());    						/** column 증번호 : certNumHuhd */
//						psnl0110Vo.setRducBgnnDt(psnl0110Dto.getRducBgnnDt());    							/** column 경감시작일자 : rducBgnnDt */
//						psnl0110Vo.setRducEndDt(psnl0110Dto.getRducEndDt());    							/** column 경감종료일자 : rducEndDt */
						

						psnl0110Vo.setCvsnRtoDivCd("");    													/** column 환산비율구분코드 : cvsnRtoDivCd */
						psnl0110Vo.setDutyYrNum(new BigDecimal("0"));    									/** column 근속년수 : dutyYrNum */
						psnl0110Vo.setDutyMnthIcm(new BigDecimal("0"));    									/** column 근속월수 : dutyMnthIcm */
						psnl0110Vo.setDutyDayNum(new BigDecimal("0"));    									/** column 근속일수 : dutyDayNum */
						psnl0110Vo.setDutyTotDayNum(new BigDecimal("0"));    								/** column 근속전체일수 : dutyTotDayNum */
						
						psnl0110Vo.setEmymtReasCtnt(psnl0300Vo.getPernAppmtNoteCtnt());    					/** column 비고내용 : emymtReasCtnt */
						psnl0110Vo.setRetryReasCtnt("");    												/** column 퇴직사유내용 : retryReasCtnt */
						psnl0110Vo.setRetryDivCd("");    													/** column 퇴직이직사유구분코드 : retryDivCd */
						
						
						psnl0110Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */
//						psnl0110Vo.setInptDt(psnl0110Dto.getInptDt());    			/** column 입력일자 : inptDt */
						psnl0110Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  /** column 입력주소 : inptAddr */
						psnl0110Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
//						psnl0110Vo.setRevnDt(psnl0110Dto.getRevnDt());   	 		/** column 수정일자 : revnDt */
						psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 	/** column 수정주소 : revnAddr */
						
						
						// ==============================================================================================
						// 4-1. 고용 테이블에 해당 발령 이력 INSERT 처리
						// ==============================================================================================
						psnl0300DAO.insertPsnl0110_S(psnl0110Vo);
						
						
						// ==============================================================================================
						// 4-2. 고용 테이블에 발령 직전 데이터 종료일자 update 쳐준다.
						// ==============================================================================================
						psnl0300DAO.updatePsnl0110_EMYMT_END_DT(psnl0110Vo);
						
					}
					
					// ==============================================================================================
					// 5. 발령에 따른 인사 마스터 UPDATE 처리
					// ==============================================================================================
					
					psnl0100Dto = new Psnl0100DTO();
					psnl0100Dto.setDpobCd(psnl0110Vo.getDpobCd());
					psnl0100Dto.setSystemkey(psnl0110Vo.getSystemkey());
					psnl0100Dto.setEmymtDivCd(psnl0110Vo.getEmymtDivCd());
					psnl0100Dto.setEmymtTypCd(psnl0110Vo.getEmymtTypCd());
					String yearStr = new SimpleDateFormat("yyyy").format(new Date());
					
					
					psnl0100Update(psnl0110Vo, psnl0100Dto);
					
//					/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
//					/** 1차 : 고용 구분에 따라 **/
//					//기간제일 때
//					if("A0020020".equals(psnl0100Dto.getEmymtDivCd())) {
//						
//						// 연장계약 (재고용) 이며, 고용시작일자가 현재 년도보다 클 경우 사업은 update 쳐주지 않는다.
//						if(( "A0420030".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd()))
//							&& Integer.parseInt( psnl0100Dto.getEmymtBgnnDt().substring(0, 4)) > Integer.parseInt(yearStr)
//							) {
//							
//						}else {
//							
//							psnl0100DAO.updatePsnl0100BUSIN_CD(psnl0100Dto);					//사업
//							
//						}
//						
//						psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
//						
//					}else if("A0020010".equals(psnl0100Dto.getEmymtDivCd())) {
//						
//						//공무직일 때
//						psnl0100DAO.updatePsnl0100TYP_OCCU_CD(psnl0100Dto);					//직종
//						psnl0100DAO.updatePsnl0100DTIL_OCCU_INTTN_CD(psnl0100Dto);			//직종세
//						
//					}
//					/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
//					
//					
//					/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
//					/** 2차 : 고용 유형에 따라 **/
//					//신규 or 재고용
//					if("A0420010".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd())) {
//						
//						psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);	//소속 부서 
//						
//						// 진안군의 경우 기간제 -> 공무직 전환 시 현부서발령일은 공무직 신규입사일로 처리.
//						if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//							
//							psnl0100Dto.setEmymtDtTyp(psnl0100Dto.getEmymtDivCd());
//							
//						}else {
//							
//							psnl0100Dto.setEmymtDtTyp("");
//							
//						}
//						psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);		//현부서 발령일
//						
//						
//						// 진안군의 경우 기간제 -> 공무직 전환 시 최초입사일자는 공무직 신규입사일로 처리.
//						if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//							
//							psnl0100Dto.setEmymtDtTyp(psnl0100Dto.getEmymtDivCd());
//							
//						}else {
//							
//							psnl0100Dto.setEmymtDtTyp("");
//							
//						}
//						//고용구분코드 신규일 때
//						psnl0100DAO.updatePsnl0100FRST_EMYMT_DT(psnl0100Dto);				//최초고용일자
//						
//						
//						
//						
//					//직제개편	
//					}else if("A0420050".equals(psnl0100Dto.getEmymtTypCd())) {
//						//고용구분코드 신규 or 직제개편
//		//				returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);	//현부서
//						psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
//					
//					//퇴직
//					}else if("A0420990".equals(psnl0100Dto.getEmymtTypCd())) {
//						//고용유형이 퇴직일때만
//						psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
//						
//					//전보
//					}else if("A0420060".equals(psnl0100Dto.getEmymtTypCd())) {
//						psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				//소속 부서 
//							psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
//					// 연장계약
//					}else if("A0420030".equals(psnl0100Dto.getEmymtTypCd())) {
//						// 퇴직 후 연장계약 하는 경우도 있으므로 기존의 퇴직일자를 없애주기 위해 연장계약일 때도 퇴직일자 로직 타게끔 추가
//						psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
//					}
//					/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
//					
//					/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
//					/** 3차 : 공통 사항 **/
//		//			returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_DIV_CD(psnl0100Dto);	//고용구분
//					
//					// 1. 고용구분 : 기간제 근로자, 2. 고용유형 : 재고용, 연장계약 , 3. 사업년도가 올해년도 보다 클 경우
//					if("A0020020".equals(psnl0100Dto.getEmymtDivCd()) 
//							&& ( "A0420030".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd()))
//							&& Integer.parseInt( psnl0100Dto.getEmymtBgnnDt().substring(0, 4)) > Integer.parseInt(yearStr)
//							) {
//						
//							psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);			//고용종료일
//								
//					}else {
//						
//						psnl0100DAO.updatePsnl0100EMYMT_BGNN_DT(psnl0100Dto);					//고용시작일
//						psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);					//고용종료일
//						
//					}
//
//						psnl0100DAO.updatePsnl0100HDOFC_CODTN_CD(psnl0100Dto);					//재직상태코드
//					
//						psnl0100DAO.updatePsnl0100ODTY_CD(psnl0100Dto);							//직책코드
//						psnl0100DAO.updatePsnl0100RETRY_REAS_CTNT(psnl0100Dto);					//고용해제사유
//					
//					// 용인시의 경우에는 소속부서 update 시 관리부서도 동일하게 update 처리 해준다.
//					if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//						psnl0100DAO.updatePsnl0100DEPT_CD(psnl0100Dto);						//관리 부서 
//					}
//					/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
					
				}
			}
		}
		
		return returnValue;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BaseListLoadResult<Psnl0300DTO> selectPsnlP0300(
			BaseListLoadConfig config, Psnl0300DTO dtoParam) throws Exception {
		
		List<Psnl0300DTO> returnValue = new ArrayList<Psnl0300DTO>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".selectPsnlP0300";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "발령관리";
		String windowId = "PSNL0300";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		try{
			
			egovResultDataList = psnl0300DAO.selectPsnlP0300(dtoParam);
			
			if(egovResultDataList == null || egovResultDataList.size() == 0){// 발령대상자가 없을경우  인사마스터에서 재직인 상대 목록 가져옴.
				egovResultDataList = psnl0300DAO.selectPsnlP0300Master(dtoParam);
			}
			
			// 2.복호화 리턴받을 값 선언
			String rrnDecCrypt = "";
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0300DTO dto = new Psnl0300DTO();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		dto.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		dto.set(key, tempMap.get(key));
		            	}
		            }
					
					// 3.복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dto.setResnRegnNum(rrnDecCrypt);
					
					returnValue.add(dto);
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
		
		return new BaseListLoadResult<Psnl0300DTO>(returnValue);
	}

	
	
	/** 일괄 발령 확정 **/
	@Override
	public int appointmentSaveList(List<Psnl0300DTO> list) throws Exception {
		
		String method = calledClass + ".appointmentSaveList";
		
		String windowNm = "발령관리";
		String windowId = "PSNL0300";
		
		int result = 0;
		
		
		MSFSysm0100BM sessionUser;
		
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		Psnl0110VO psnl0110Vo = new Psnl0110VO();  
		Psnl0300VO psnl0300Vo = new Psnl0300VO();  
		Psnl0310VO psnl0310Vo = new Psnl0310VO();  
		Psnl0100DTO psnl0100Dto = new Psnl0100DTO();
		
		
		try {  
			
			HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
			
			if (MSFSharedUtils.paramNull(psnl0300DAO)) {
				
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				psnl0300DAO = (Psnl0300DAO) wac.getBean("psnl0300DAO" ); 
				
			}else if(MSFSharedUtils.paramNull(psnl0310DAO)) {
				
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				psnl0310DAO = (Psnl0310DAO) wac.getBean("psnl0310DAO" ); 
				
			}
			
			for(int iPsnlCnt=0; iPsnlCnt < list.size(); iPsnlCnt++) {
				
				Psnl0300DTO psnl0300Dto = new Psnl0300DTO();  
				psnl0300Dto = list.get(iPsnlCnt);
	                 
	            psnl0300Vo = new Psnl0300VO();  
	            
				psnl0300Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    								/** column 사업장코드 : dpobCd */
				psnl0300Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0300Dto.getSystemkey()));    							/** column SYSTEMKEY : systemkey */
				psnl0300Vo.setAppmtNum(MSFSharedUtils.allowNulls(psnl0300Dto.getAppmtNum()));    							/** column 발령번호 : appmtNum */
				psnl0300Vo.setAppmtDivCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAppmtDivCd()));    						/** column 발령구분코드 : appmtDivCd */
				psnl0300Vo.setAppmtDt(MSFSharedUtils.allowNulls(psnl0300Dto.getAppmtDt()));    								/** column 발령일자 : appmtDt */
				psnl0300Vo.setAppmtBssCtnt(MSFSharedUtils.allowNulls(psnl0300Dto.getAppmtBssCtnt()));    					/** column 발령근거내용 : appmtBssCtnt */
				psnl0300Vo.setAppmtIstut(MSFSharedUtils.allowNulls(psnl0300Dto.getAppmtIstut()));    						/** column 발령기관 : appmtIstut */
				psnl0300Vo.setBgnnDt(MSFSharedUtils.allowNulls(psnl0300Dto.getBgnnDt()));    								/** column 시작일자 : bgnnDt */
				psnl0300Vo.setEndDt(MSFSharedUtils.allowNulls(psnl0300Dto.getEndDt()));    									/** column 종료일자 : endDt */
				psnl0300Vo.setDeptCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftDeptCd()));    							/** column 부서코드 : deptCd */
				psnl0300Vo.setBusinCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftBusinCd()));    							/** column 사업코드 : businCd */
				psnl0300Vo.setTypOccuCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftTypOccuDivCd()));    					/** column 직종코드 : typOccuCd */
				psnl0300Vo.setTypOccuInttnCd(MSFSharedUtils.allowNulls(psnl0300Dto.getTypOccuInttnCd()));    				/** column 직종통합코드 : typOccuInttnCd */
				psnl0300Vo.setOdtyCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftOdtyDivCd()));    							/** column 직책코드 : odtyCd */
				psnl0300Vo.setPyspCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftPyspCd()));    							/** column 호봉코드 : pyspCd */
				psnl0300Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(psnl0300Dto.getPyspGrdeCd()));    						/** column 호봉등급코드 : pyspGrdeCd */
				psnl0300Vo.setLogSvcYrNumCd(MSFSharedUtils.allowNulls(psnl0300Dto.getLogSvcYrNumCd()));   	 				/** column 근속년수코드 : logSvcYrNumCd */
				psnl0300Vo.setDsnyActDivCd(MSFSharedUtils.allowNulls(psnl0300Dto.getDsnyActDivCd()));    					/** column 징계구분코드 : dsnyActDivCd */
				psnl0300Vo.setCtwpMnthNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0300Dto.getCtwpMnthNum(), "0"))); 	/** column 감봉월수 : ctwpMnthNum */
				psnl0300Vo.setPernAppmtNoteCtnt(MSFSharedUtils.allowNulls(psnl0300Dto.getPernAppmtNoteCtnt()));    			/** column 인사발령비고내용 : pernAppmtNoteCtnt */
				psnl0300Vo.setAppmtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0300Dto.getAppmtSeilNum(), "0")));/** column 발령일련번호 : appmtSeilNum */
				
				
				if(MSFSharedUtils.paramNotNull(psnl0300Dto.getDtilOccuClsDivCd())) {
					psnl0300Vo.setDtilOccuClsDivCd(psnl0300Dto.getAftDtilOccuInttnCd().substring(0, 8));    				/** column 직종세구분코드 : dtilOccuClsDivCd */
				}
				psnl0300Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftDtilOccuInttnCd()));    			/** column 직종세통합구분코드 : dtilOccuInttnCd */
				psnl0300Vo.setLogSvcMnthIcmCd(MSFSharedUtils.allowNulls(psnl0300Dto.getLogSvcMnthIcmCd()));    				/** column 근속월수코드 : logSvcMnthIcmCd */
				psnl0300Vo.setKybdr(sessionUser.getUsrId());    															/** column 입력자 : kybdr */
				psnl0300Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    						/** column 입력주소 : inptAddr */
				psnl0300Vo.setIsmt(sessionUser.getUsrId());    																/** column 수정자 : ismt */
				psnl0300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    						/** column 수정주소 : revnAddr */
				
				
				psnl0310Vo = new Psnl0310VO();  
				
				psnl0310Vo.setDpobCd(MSFSharedUtils.allowNulls(psnl0300Vo.getDpobCd()));    							/** column 사업장코드 : dpobCd */
				psnl0310Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0300Vo.getSystemkey()));    						/** column SYSTEMKEY : systemkey */
				psnl0310Vo.setAppmtSeilNum(psnl0300Vo.getAppmtSeilNum());    											/** column 발령일련번호 : appmtSeilNum */
				psnl0310Vo.setAppmtDivCd(MSFSharedUtils.allowNulls(psnl0300Vo.getAppmtDivCd()));    					/** column 발령구분코드 : appmtDivCd */
				psnl0310Vo.setAppmtDt(MSFSharedUtils.allowNulls(psnl0300Dto.getAppmtDt()));    							/** column 발령일자 : appmtDt */
				psnl0310Vo.setBfrDeptCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrDeptCd()));    						/** column 전_부서코드 : bfrDeptCd */
				psnl0310Vo.setBfrBusinCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrBusinCd()));    					/** column 전_사업코드 : bfrBusinCd */
				psnl0310Vo.setBfrTypOccuDivCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrTypOccuDivCd()));    			/** column 전_직종구분코드 : bfrTypOccuDivCd */
				psnl0310Vo.setBfrOdtyDivCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrOdtyDivCd()));    				/** column 전_직책구분코드 : bfrOdtyDivCd */
				psnl0310Vo.setBfrPyspCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrPyspCd()));    						/** column 전호봉코드 : bfrPyspCd */
				psnl0310Vo.setBfrPyspGrdeCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrPyspGrdeCd()));    				/** column 전호봉등급코드 : bfrPyspGrdeCd */
				psnl0310Vo.setBfrLogSvcYrNumCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrLogSvcYrNumCd()));    		/** column 전근속년수코드 : bfrLogSvcYrNumCd */
				psnl0310Vo.setAftDeptCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftDeptCd()));    						/** column 후_부서코드 : aftDeptCd */
				psnl0310Vo.setAftBusinCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftBusinCd()));    					/** column 후_사업코드 : aftBusinCd */
				psnl0310Vo.setAftTypOccuDivCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftTypOccuDivCd()));    			/** column 후_직종구분코드 : aftTypOccuDivCd */
				psnl0310Vo.setAftOdtyDivCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftOdtyDivCd()));    				/** column 후_직책구분코드 : aftOdtyDivCd */
				psnl0310Vo.setAftPyspCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftPyspCd()));    						/** column 후_호봉코드 : aftPyspCd */
				psnl0310Vo.setAftPyspGrdeCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftPyspGrdeCd()));    				/** column 후_호봉등급코드 : aftPyspGrdeCd */
				psnl0310Vo.setAftLogSvcYrNumCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftLogSvcYrNumCd()));    		/** column 후_근속년수코드 : aftLogSvcYrNumCd */
				psnl0310Vo.setAppmtFixYn(MSFSharedUtils.allowNulls(psnl0300Dto.getAppmtFixYn()));    					/** column 발령확정여부 : appmtFixYn */
				psnl0310Vo.setConfrtnPrtcDt(MSFSharedUtils.allowNulls(psnl0300Dto.getConfrtnPrtcDt()));    				/** column 배치실행일자 : confrtnPrtcDt */
				psnl0310Vo.setConfrtnPrcsYn(MSFSharedUtils.allowNulls(psnl0300Dto.getConfrtnPrcsYn()));    				/** column 배치처리여부 : confrtnPrcsYn */
	
				psnl0310Vo.setBfrDtilOccuInttnCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrDtilOccuInttnCd()));    	/** column 전직종세통합코드 : bfrDtilOccuInttnCd */
				psnl0310Vo.setBfrLogSvcMnthCd(MSFSharedUtils.allowNulls(psnl0300Dto.getBfrLogSvcMnthCd()));    			/** column 전근속월수코드 : bfrLogSvcMnthCd */
				psnl0310Vo.setAftDtilOccuInttnCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftDtilOccuInttnCd()));    	/** column 후직종세통합코드 : aftDtilOccuInttnCd */
				psnl0310Vo.setAftLogSvcMnthCd(MSFSharedUtils.allowNulls(psnl0300Dto.getAftLogSvcMnthCd()));    			/** column 후근속월수코드 : aftLogSvcMnthCd */
				
				psnl0310Vo.setKybdr(sessionUser.getUsrId());    														/** column 입력자 : kybdr */
				psnl0310Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());						/** column 입력주소 : inptAddr */
				psnl0310Vo.setIsmt(sessionUser.getUsrId());    															/** column 수정자 : ismt */
				psnl0310Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());						/** column 수정주소 : revnAddr */
				
				// ==============================================================================================
				// 1. 인사마스터 정보데이터일경우 먼저 발령테이블에 등록하여준다.
				// ==============================================================================================
				if("0".equals(MSFSharedUtils.defaultNulls(psnl0300Dto.getAppmtSeilNum(), "0"))
						|| MSFSharedUtils.defaultNulls(psnl0300Dto.getAppmtSeilNum(), "0") == "0" ){ //인사마스터 정보데이터
					//발령일련번호를 가져온다.
					String appmtSeilNum = psnl0300DAO.getMaxAppmtSeilNum();
//					dto.setAppmtSeilNum(appmtSeilNum);
					
					
					psnl0300Vo.setAppmtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(appmtSeilNum, "0")));				/** column 발령일련번호 : appmtSeilNum */
					psnl0310Vo.setAppmtSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(appmtSeilNum, "0")));				/** column 발령일련번호 : appmtSeilNum */
					
					
					//발령대상자 정보를 등록한다. PSNL0310
					psnl0310DAO.inserPsnl0310(psnl0310Vo);
					//인사발령 정보를 등록한다. PSNL0300
					psnl0300DAO.insertPsnl0300(psnl0300Vo);
					
					
					
				}
				
				// ==============================================================================================
				// 2. 과거 발령데이터 PSNL0300 종료일자 업데이트 처리한다.
				// ==============================================================================================
				psnl0300DAO.updatePsnl0300_END_DT(psnl0300Vo);
				
				
				// ==============================================================================================
				// 3. 발령정보 여부를 Y로 업데이트 한다.
				// ==============================================================================================
				psnl0310DAO.updatePsnl0310_APPMT_FIX_YN(psnl0310Vo);
				
				
				
				// ==============================================================================================
				// 4. 발령구분 정보가 재고용(A0460020), 퇴직(A0460060), 직제변경(A0460080), 사업변경(A0460090)일 경우 고용구분 테이블에 등록  
				// ==============================================================================================
				if("A0460020".equals(psnl0300Vo.getAppmtDivCd()) || "A0460060".equals(psnl0300Vo.getAppmtDivCd()) 
						|| "A0460080".equals(psnl0300Vo.getAppmtDivCd()) || "A0460090".equals(psnl0300Vo.getAppmtDivCd())){
					
					psnl0110Vo = new Psnl0110VO(); 
					
					psnl0110Vo.setDpobCd(psnl0300Vo.getDpobCd());    								/** column 사업장코드 : dpobCd */
					psnl0110Vo.setSystemkey(psnl0300Vo.getSystemkey());    							/** column SYSTEMKEY : systemkey */
//					psnl0110Vo.setEmymtSeilNum(psnl0110Dto.getEmymtSeilNum());    /** column 고용일련번호 : emymtSeilNum */
					psnl0110Vo.setEmymtDivCd(psnl0300Dto.getEmymtDivCd());    						/** column 고용구분코드 : emymtDivCd */
					psnl0110Vo.setEmymtTypCd(psnl0300Vo.getAppmtDivCd());    						/** column 고용유형코드 : emymtTypCd */
					psnl0110Vo.setEmymtBgnnDt(psnl0300Vo.getAppmtDt());    							/** column 고용시작일자 : emymtBgnnDt */

					psnl0110Vo.setDeptCd(psnl0300Vo.getDeptCd());    								/** column 부서코드 : deptCd */
					psnl0110Vo.setBusinCd(psnl0300Vo.getBusinCd());    								/** column 사업코드 : businCd */
					psnl0110Vo.setTypOccuCd(psnl0300Vo.getTypOccuCd());    							/** column 직종코드 : typOccuCd */
					psnl0110Vo.setDtilOccuClsDivCd(psnl0300Vo.getDtilOccuClsDivCd());    			/** column 직종세구분코드 : dtilOccuClsDivCd */
					psnl0110Vo.setOdtyCd(psnl0300Vo.getOdtyCd());    								/** column 직책코드 : odtyCd */
					psnl0110Vo.setDtilOccuInttnCd(psnl0300Vo.getDtilOccuInttnCd());    				/** column 직종통합코드 : dtilOccuInttnCd */
					psnl0110Vo.setPyspGrdeCd(psnl0300Vo.getPyspGrdeCd());    						/** column 호봉등급코드 : pyspGrdeCd */
					
					
					// 종료일자는 쿼리에서 가장 최신의 종료일자를 가지고 와 입력해준다.
//					psnl0110Vo.setEmymtEndDt(psnl0110Dto.getEmymtEndDt());    		/** column 고용종료일자 : emymtEndDt */
					// 현근무지명은  쿼리에서 가장 최신의 종료일자를 가지고 와 입력해준다.
//					psnl0110Vo.setCurrPaeWorkNm(psnl0110Dto.getCurrPaeWorkNm());    /** column 현근무지명 : currPaeWorkNm */
//					psnl0110Vo.setPayPymtDivCd(psnl0110Dto.getPayPymtDivCd());    						/** column 급여지급구분코드 : payPymtDivCd */
//					psnl0110Vo.setEmymtSum(psnl0110Dto.getEmymtSum());    								/** column 고용금액 : emymtSum */
//					psnl0110Vo.setCertNumHuhd(psnl0110Dto.getCertNumHuhd());    						/** column 증번호 : certNumHuhd */
//					psnl0110Vo.setRducBgnnDt(psnl0110Dto.getRducBgnnDt());    							/** column 경감시작일자 : rducBgnnDt */
//					psnl0110Vo.setRducEndDt(psnl0110Dto.getRducEndDt());    							/** column 경감종료일자 : rducEndDt */
					

					psnl0110Vo.setCvsnRtoDivCd("");    													/** column 환산비율구분코드 : cvsnRtoDivCd */
					psnl0110Vo.setDutyYrNum(new BigDecimal("0"));    									/** column 근속년수 : dutyYrNum */
					psnl0110Vo.setDutyMnthIcm(new BigDecimal("0"));    									/** column 근속월수 : dutyMnthIcm */
					psnl0110Vo.setDutyDayNum(new BigDecimal("0"));    									/** column 근속일수 : dutyDayNum */
					psnl0110Vo.setDutyTotDayNum(new BigDecimal("0"));    								/** column 근속전체일수 : dutyTotDayNum */
					
					psnl0110Vo.setEmymtReasCtnt(psnl0300Vo.getPernAppmtNoteCtnt());    					/** column 비고내용 : emymtReasCtnt */
					psnl0110Vo.setRetryReasCtnt("");    												/** column 퇴직사유내용 : retryReasCtnt */
					psnl0110Vo.setRetryDivCd("");    													/** column 퇴직이직사유구분코드 : retryDivCd */
					
					
					psnl0110Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */
//					psnl0110Vo.setInptDt(psnl0110Dto.getInptDt());    			/** column 입력일자 : inptDt */
					psnl0110Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  /** column 입력주소 : inptAddr */
					psnl0110Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
//					psnl0110Vo.setRevnDt(psnl0110Dto.getRevnDt());   	 		/** column 수정일자 : revnDt */
					psnl0110Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 	/** column 수정주소 : revnAddr */
					
					
					
					// ==============================================================================================
					// 4-1. 고용 테이블에 해당 발령 이력 INSERT 처리
					// ==============================================================================================
					psnl0300DAO.insertPsnl0110_S(psnl0110Vo);
					
					
					// ==============================================================================================
					// 4-2. 고용 테이블에 발령 직전 데이터 종료일자 update 쳐준다.
					// ==============================================================================================
					psnl0300DAO.updatePsnl0110_EMYMT_END_DT(psnl0110Vo);
					
				}
				
				// ==============================================================================================
				// 5. 발령에 따른 인사 마스터 UPDATE 처리
				// ==============================================================================================
				
				psnl0100Dto = new Psnl0100DTO();
				psnl0100Dto.setDpobCd(psnl0110Vo.getDpobCd());
				psnl0100Dto.setSystemkey(psnl0110Vo.getSystemkey());
				psnl0100Dto.setEmymtDivCd(psnl0110Vo.getEmymtDivCd());
				psnl0100Dto.setEmymtTypCd(psnl0110Vo.getEmymtTypCd());
				
				psnl0100Update(psnl0110Vo, psnl0100Dto);
				
//				String yearStr = new SimpleDateFormat("yyyy").format(new Date());
//				
//				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
//				/** 1차 : 고용 구분에 따라 **/
//				//기간제일 때
//				if("A0020020".equals(psnl0100Dto.getEmymtDivCd())) {
//					
//					// 연장계약 (재고용) 이며, 고용시작일자가 현재 년도보다 클 경우 사업은 update 쳐주지 않는다.
//					if(( "A0420030".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd()))
//						&& Integer.parseInt( psnl0100Dto.getEmymtBgnnDt().substring(0, 4)) > Integer.parseInt(yearStr)
//						) {
//						
//					}else {
//						
//						psnl0100DAO.updatePsnl0100BUSIN_CD(psnl0100Dto);					//사업
//						
//					}
//					
//					psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
//					
//				}else if("A0020010".equals(psnl0100Dto.getEmymtDivCd())) {
//					
//					//공무직일 때
//					psnl0100DAO.updatePsnl0100TYP_OCCU_CD(psnl0100Dto);					//직종
//					psnl0100DAO.updatePsnl0100DTIL_OCCU_INTTN_CD(psnl0100Dto);			//직종세
//					
//				}
//				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
//				
//				
//				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
//				/** 2차 : 고용 유형에 따라 **/
//				//신규 or 재고용
//				if("A0420010".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd())) {
//					
//					psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);	//소속 부서 
//					
//					// 진안군의 경우 기간제 -> 공무직 전환 시 현부서발령일은 공무직 신규입사일로 처리.
//					if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//						
//						psnl0100Dto.setEmymtDtTyp(psnl0100Dto.getEmymtDivCd());
//						
//					}else {
//						
//						psnl0100Dto.setEmymtDtTyp("");
//						
//					}
//					psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);		//현부서 발령일
//					
//					
//					// 진안군의 경우 기간제 -> 공무직 전환 시 최초입사일자는 공무직 신규입사일로 처리.
//					if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//						
//						psnl0100Dto.setEmymtDtTyp(psnl0100Dto.getEmymtDivCd());
//						
//					}else {
//						
//						psnl0100Dto.setEmymtDtTyp("");
//						
//					}
//					//고용구분코드 신규일 때
//					psnl0100DAO.updatePsnl0100FRST_EMYMT_DT(psnl0100Dto);				//최초고용일자
//					
//					
//					
//					
//				//직제개편	
//				}else if("A0420050".equals(psnl0100Dto.getEmymtTypCd())) {
//					//고용구분코드 신규 or 직제개편
//	//				returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);	//현부서
//					psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
//				
//				//퇴직
//				}else if("A0420990".equals(psnl0100Dto.getEmymtTypCd())) {
//					//고용유형이 퇴직일때만
//					psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
//					
//				//전보
//				}else if("A0420060".equals(psnl0100Dto.getEmymtTypCd())) {
//					psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				//소속 부서 
//						psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
//				// 연장계약
//				}else if("A0420030".equals(psnl0100Dto.getEmymtTypCd())) {
//					// 퇴직 후 연장계약 하는 경우도 있으므로 기존의 퇴직일자를 없애주기 위해 연장계약일 때도 퇴직일자 로직 타게끔 추가
//					psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
//				}
//				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
//				
//				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
//				/** 3차 : 공통 사항 **/
//	//			returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_DIV_CD(psnl0100Dto);	//고용구분
//				
//				// 1. 고용구분 : 기간제 근로자, 2. 고용유형 : 재고용, 연장계약 , 3. 사업년도가 올해년도 보다 클 경우
//				if("A0020020".equals(psnl0100Dto.getEmymtDivCd()) 
//						&& ( "A0420030".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd()))
//						&& Integer.parseInt( psnl0100Dto.getEmymtBgnnDt().substring(0, 4)) > Integer.parseInt(yearStr)
//						) {
//					
//						psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);			//고용종료일
//							
//				}else {
//					
//					psnl0100DAO.updatePsnl0100EMYMT_BGNN_DT(psnl0100Dto);					//고용시작일
//					psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);					//고용종료일
//					
//				}
//
//					psnl0100DAO.updatePsnl0100HDOFC_CODTN_CD(psnl0100Dto);					//재직상태코드
//				
//					psnl0100DAO.updatePsnl0100ODTY_CD(psnl0100Dto);							//직책코드
//					psnl0100DAO.updatePsnl0100RETRY_REAS_CTNT(psnl0100Dto);					//고용해제사유
//				
//				// 용인시의 경우에는 소속부서 update 시 관리부서도 동일하게 update 처리 해준다.
//				if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
//					psnl0100DAO.updatePsnl0100DEPT_CD(psnl0100Dto);						//관리 부서 
//				}
//				/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
				
				result = result + 1;
			}
			
		}catch(Exception ex) {
			
			
			ex.printStackTrace();
        	/** 에러 로그 **/			
        	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, "C:U",ex, windowNm , windowId);
        	
            logger.error("EXCEPTION calling appointmentSaveList(): "+ex); 
            
            throw MSFServerUtils.getOperationException("appointmentSaveList", ex, logger);
			
			
		}
		
		
		String returnValue = "";
		
		
		
		
		
//		if(list != null && list.size() > 0){
//			for(int i = 0; i < list.size(); i++){
//				Psnl0300DTO dto = list.get(i);
//				MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//				dto.setIsmt(sessionUser.getUsrId());
//				dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
//				
//				
//				//인사마스터 정보데이터일경우 먼저 발령테이블에 등록하여준다.
//				if("".equals(dto.getAppmtSeilNum()) || null == dto.getAppmtSeilNum()){ //인사마스터 정보데이터
//					//발령일련번호를 가져온다.
//					String appmtSeilNum = psnl0300DAO.getMaxAppmtSeilNum();
//					dto.setAppmtSeilNum(appmtSeilNum);
//					//발령대상자 정보를 등록한다. PSNL0310
//					psnl0300DAO.inserPsnl0310(dto);
//					//인사발령 정보를 등록한다. PSNL0300
//					psnl0300DAO.insertPsnl0300(dto);
//				}
//				
//				//과거 발령데이터 PSNL0300 종료일자 업데이트 처리한다.
//				psnl0300DAO.updatePsnl0300(dto);
//				//발령정보 여부를 Y로 업데이트 한다.
//				psnl0300DAO.updatePsnl0310(dto);
//				//메인 인사테이블 수정
//				psnl0300DAO.updatePsnl0100(dto);
//				
//				//발령구분 정보가 재고용(A0460020) 및 퇴직(A0460060)일 경우 고용구분 테이블에 등록  
//				//직제변경(A0460080), 사업변경(A0460090) 일 경우 최상위 업데이트 처리
//				if("A0460020".equals(dto.getAppmtDivCd()) || "A0460060".equals(dto.getAppmtDivCd()) ){
//					psnl0300DAO.insertPsnl0110(dto);
//				}
//				
//				if("A0460080".equals(dto.getAppmtDivCd()) || "A0460090".equals(dto.getAppmtDivCd()) ){
//					psnl0300DAO.insertPsnl0110(dto);
//					//psnl0300DAO.updatePsnl0110(dto);
//				}
//				
//				
//				
//				
//				
//				
//				
//				
//				
//			}
//		}
//		return returnValue;
		return result;
	}
	
	
	/** 인사 마스터 update 처리
	 * @throws Exception **/
	private void psnl0100Update(Psnl0110VO psnl0110Vo, Psnl0100DTO psnl0100Dto) throws Exception {
		
		String method = calledClass + ".psnl0100Update";
		
		String windowNm = "발령관리";
		String windowId = "PSNL0300";
		
		int result = 0;
		
		
		MSFSysm0100BM sessionUser;
		
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		
		HashMap<String, String> extGlobals = SysmConf.getPayGenConfigInfo(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()); 
		String yearStr = new SimpleDateFormat("yyyy").format(new Date());
		
		
		try{
			
			/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
			/** 1차 : 고용 구분에 따라 **/
			//기간제일 때
			if("A0020020".equals(psnl0100Dto.getEmymtDivCd())) {
				
				// 연장계약 (재고용) 이며, 고용시작일자가 현재 년도보다 클 경우 사업은 update 쳐주지 않는다.
				if(( "A0420030".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd()))
					&& Integer.parseInt( psnl0100Dto.getEmymtBgnnDt().substring(0, 4)) > Integer.parseInt(yearStr)
					) {
					
				}else {
					
					psnl0100DAO.updatePsnl0100BUSIN_CD(psnl0100Dto);					//사업
					
				}
				
				psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
				
			}else if("A0020010".equals(psnl0100Dto.getEmymtDivCd())) {
				
				//공무직일 때
				psnl0100DAO.updatePsnl0100TYP_OCCU_CD(psnl0100Dto);					//직종
				psnl0100DAO.updatePsnl0100DTIL_OCCU_INTTN_CD(psnl0100Dto);			//직종세
				
			}
			/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
			
			
			/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
			/** 2차 : 고용 유형에 따라 **/
			//신규 or 재고용
			if("A0420010".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd())) {
				
				psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);	//소속 부서 
				
				// 진안군의 경우 기간제 -> 공무직 전환 시 현부서발령일은 공무직 신규입사일로 처리.
				if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					
					psnl0100Dto.setEmymtDtTyp(psnl0100Dto.getEmymtDivCd());
					
				}else {
					
					psnl0100Dto.setEmymtDtTyp("");
					
				}
				psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);		//현부서 발령일
				
				
				// 진안군의 경우 기간제 -> 공무직 전환 시 최초입사일자는 공무직 신규입사일로 처리.
				if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_20.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
					
					psnl0100Dto.setEmymtDtTyp(psnl0100Dto.getEmymtDivCd());
					
				}else {
					
					psnl0100Dto.setEmymtDtTyp("");
					
				}
				//고용구분코드 신규일 때
				psnl0100DAO.updatePsnl0100FRST_EMYMT_DT(psnl0100Dto);				//최초고용일자
				
				
				
				
			//직제개편	
			}else if("A0420050".equals(psnl0100Dto.getEmymtTypCd())) {
				//고용구분코드 신규 or 직제개편
//					returnVal += "_"+ psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);	//현부서
				psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
			
			//퇴직
			}else if("A0420990".equals(psnl0100Dto.getEmymtTypCd())) {
				//고용유형이 퇴직일때만
				psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
				
			//전보
			}else if("A0420060".equals(psnl0100Dto.getEmymtTypCd())) {
				psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				//소속 부서 
					psnl0100DAO.updatePsnl0100CURR_DEPT_APPMT_DT(psnl0100Dto);			//현부서 발령일
			// 연장계약
			}else if("A0420030".equals(psnl0100Dto.getEmymtTypCd())) {
				// 퇴직 후 연장계약 하는 경우도 있으므로 기존의 퇴직일자를 없애주기 위해 연장계약일 때도 퇴직일자 로직 타게끔 추가
				psnl0100DAO.updatePsnl0100RETRY_DT(psnl0100Dto);						//퇴직일자
			}
			/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
			
			/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
			/** 3차 : 공통 사항 **/
//				returnVal += "_"+ psnl0100DAO.updatePsnl0100EMYMT_DIV_CD(psnl0100Dto);	//고용구분
			
			// 1. 고용구분 : 기간제 근로자, 2. 고용유형 : 재고용, 연장계약 , 3. 사업년도가 올해년도 보다 클 경우
			if("A0020020".equals(psnl0100Dto.getEmymtDivCd()) 
					&& ( "A0420030".equals(psnl0100Dto.getEmymtTypCd()) || "A0420020".equals(psnl0100Dto.getEmymtTypCd()))
					&& Integer.parseInt( psnl0100Dto.getEmymtBgnnDt().substring(0, 4)) > Integer.parseInt(yearStr)
					) {
				
					psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);			//고용종료일
						
			}else {
				
				psnl0100DAO.updatePsnl0100EMYMT_BGNN_DT(psnl0100Dto);					//고용시작일
				psnl0100DAO.updatePsnl0100EMYMT_END_DT(psnl0100Dto);					//고용종료일
				
			}

				psnl0100DAO.updatePsnl0100HDOFC_CODTN_CD(psnl0100Dto);					//재직상태코드
			
				psnl0100DAO.updatePsnl0100ODTY_CD(psnl0100Dto);							//직책코드
				psnl0100DAO.updatePsnl0100RETRY_REAS_CTNT(psnl0100Dto);					//고용해제사유
				psnl0100DAO.updatePsnl0100CURR_AFFN_DEPT_CD(psnl0100Dto);				//소속 부서 
			// 용인시의 경우에는 소속부서 update 시 관리부서도 동일하게 update 처리 해준다.
			if (PropPayGenConfs.PAYGEN_MUNICIPALITIES_01.equals(extGlobals.get("PayGen.MunicipalitiesName"))) {
				psnl0100DAO.updatePsnl0100DEPT_CD(psnl0100Dto);						//관리 부서 
			}
			/** +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ **/
			
		}catch(Exception e) {
			
			e.printStackTrace();
        	/** 에러 로그 **/			
        	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, "C:U",e, windowNm , windowId);
        	
            logger.error("EXCEPTION calling appointmentSaveList(): "+e); 
            
            throw MSFServerUtils.getOperationException("psnl0100Update", e, logger);
			
		}
		
		
	}

    
}
