package com.app.exterms.personal.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.exterms.personal.client.dto.Psnl0131DTO;
import com.app.exterms.personal.client.dto.Psnl0132DTO;
import com.app.exterms.personal.client.service.PsnlP010001Service;
import com.app.exterms.personal.server.service.dao.Psnl0131DAO;
import com.app.exterms.personal.server.service.dao.Psnl0132DAO;
import com.app.exterms.personal.server.vo.Psnl0131SrhVO;
import com.app.exterms.personal.server.vo.Psnl0131VO;
import com.app.exterms.personal.server.vo.Psnl0132SrhVO;
import com.app.exterms.personal.server.vo.Psnl0132VO;
import com.app.exterms.personal.shared.PsnlDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;

/**
 * @Class Name : Psnl0131ServiceImpl.java
 * @Description : Psnl0131 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@SuppressWarnings("serial")
@Service("PsnlP010001Service")
public class PsnlP010001ServiceImpl    extends AbstractCustomServiceImpl  implements PsnlP010001Service, PsnlDaoConstants {
	
	 private static final Logger logger = LoggerFactory.getLogger(PsnlP010001ServiceImpl.class);
	 private static final String calledClass = PsnlP010001ServiceImpl.class.getName();
	 

	@Resource(name = "Psnl0131DAO")
	private Psnl0131DAO psnl0131DAO;
	
	@Resource(name = "Psnl0132DAO")
	private Psnl0132DAO psnl0132DAO;
	
		/** 데이터 조회 **/
//	//조회
//	public PagingLoadResult<BaseModel> getPsnl0131DataList(ServiceParameters serviceParameters) throws MSFException {
//				
//
//				PagingLoadResult<BaseModel> retval = null;
//				String method =  CLASS_PSNL0131_DATA_LIST;
//				Psnl0131SrhVO   psnl0131SrhVO = new Psnl0131SrhVO();
////				Psnl0100VO      psnl0100VO = new Psnl0100VO();
//				List<BaseModel>  bmResult = new ArrayList<BaseModel>();
//				MSFSysm0100BM sessionUser;
//				
//				// 1. 암호화 객체 생성
//				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//			        
//			        
//				if (RemoteServiceUtil.getThreadLocalRequest() != null) {
//					sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//				} else {
//					sessionUser = getUser();
//				}
//			      
//				if  (MSFSharedUtils.paramNull(psnl0131DAO)) {
//					WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//					psnl0131DAO = (Psnl0131DAO) wac.getBean("psnl0131DAO"); 
//				}
//			        
//				try {
//					//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
//					ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
//					IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
//					List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
//					PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
//
//					//Get paging configuration
//			    	PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
//
//			    	//Get query parameters
////			      	String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
//			      	/** 조건절 */
//			    	 psnl0131SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
//			    	 psnl0131SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
////			    	 psnl0131SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));
//			            
//			      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
//					if ( pagingValues.executeRecordCount ) { 
//				            	
//						//Execute query that returns a single value
//			        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//			                 
//			          	int iResultCnt = psnl0131DAO.selectPsnl0131ListCnt(psnl0131SrhVO);  
//			              
//			          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
//			          	
//			          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
//		                if (!pagingValues.pageExecute) { 
//		                    pagingValues.offsetLimit = iResultCnt;       
//		                }
//		                
//			         	pagingValues.totalRecordCount = iResultCnt;	       
//			                
//			        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//					}
//			        
//			     	TimingInfo millisBeginPsnl0131DataList = SmrmfUtils.startTiming(logger);
//			        
//			     	/**페이지 카운트 처리를 위한 부분 */ 
//			     	psnl0131SrhVO.setPageSize(pagingValues.totalRecordCount);  
//			            
//			     	//Apply paging
//			     	if (pagingValues.start > 0) {
//			     		psnl0131SrhVO.setFirstIndex(pagingValues.start);
//			     	}
//			     	if (pagingValues.offsetLimit > 0) {
//			     		psnl0131SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
//			     	}
//		//
//			     	//Execute query and convert to BaseModel list
//			     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//			            
//			     	@SuppressWarnings("unchecked")
////			            Collection<Map<String, Object>> list ??????
//			     	List list = psnl0131DAO.selectPsnl0131(psnl0131SrhVO);
//			            
//					Iterator<Map<String, Object>> iter = list.iterator();
//				            
//					SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
//			           
//			        
//					while (iter.hasNext()) {
//						Map<String, Object> map = (Map<String, Object>) iter.next();
//						String idValue = map.get("systemkey").toString();
//			        	BaseModel bm = new BaseModel();
//			 
//				       	//bm.setProperties(map);
//				     	for ( int i=0 ; i<tableAttributes.length ; i++ ) {
//				     		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
//				     		Object mapCon = map.get(tableAttributes[i].getName());  
//				                     
//				     		switch ( tableAttributes[i].getType() ) {  
//				          		case ColumnDef.TYPE_DATE: 
//				          		case ColumnDef.TYPE_DATETIME: 
//				                       
//				             	Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"yyyyMMdd");
//				            	map.put(tableAttributes[i].getName(), value);
//				                     
//				            	break; 
//				            	
//				          		case ColumnDef.TYPE_STRING: 
//					          			
//				          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
//				          	   			
//				          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
//				          		          			
//				          				String rrnDecCrypt = "";
//				          		          			
//				          				// TODO 주민번호 
//				          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//				          		          		
//				          				strValue = rrnDecCrypt;
//				          							
//				          			}
//				          	 	                       
//				          			map.put(tableAttributes[i].getName(), strValue);
//				          		
//				          		 break;
//				                       
//				          		case ColumnDef.TYPE_LONG:   
//				                     
//				          			if (mapCon != null) {  
//				          				Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
//				                        map.put(tableAttributes[i].getName(), lValue); 
//				                    }  
//				                       
//				                     break;
//				                     
//				          		case ColumnDef.TYPE_DOUBLE:  
//				          			
//				                      if (mapCon != null) {      
//				                         Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue(); 
//				                         map.put(tableAttributes[i].getName(), dbValue); 
//				                      }  
//				                       
//				                   	break;
//				     		}
//				     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
//				     			Object baseModelValue = null;
//				            	//콤보박스처리를 위해 추가함
//				     			if (tableAttributes[i].getName().contains("$")) {
//				     				
//				     				String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
//				                              
//				     				map.put(tableAttributes[i].getName(),map.get(strMapCon));
//				                         
//				                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//				                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//				     			} else {
//				                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//				                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//				     			}
//				     		/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//				                    
//				                    bm.set(tableAttributes[i].getName(), baseModelValue);
//				     	}
//
//			     	bm.set(TableDef.ID_PROPERTY_NAME, idValue);
//			     	bmResult.add(bm);
//				} 
//
//					retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
//			            
//					SmrmfUtils.endTiming(logger, millisBeginPsnl0131DataList, "getPsnl0100To0131DataList");
//			       
//			} catch (Exception ex) {
//				ex.printStackTrace();
//				// Return operation exception
//				throw MSFServerUtils.getOperationException(method, ex, logger);
//			}
//			return retval;
//		}
		
	 
	 
	 	// 조회
	 	@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public BaseListLoadResult<Psnl0131DTO> selectPsnl0131(BaseListLoadConfig config, Psnl0131DTO psnl0131Dto)throws MSFException {
			
			String windowNm = "인사";
			String windowId = "PSNL0100/PSNL0200";
			
			// TODO Auto-generated method stub
			List<Psnl0131DTO> returnValue = new ArrayList<Psnl0131DTO>();
			List<Psnl0132DTO> lsPsnl0132Dto = new ArrayList<Psnl0132DTO>();
			List egovResultDataList = new ArrayList();
			List egovResultDataList2 = new ArrayList();
			Psnl0131SrhVO psnl0131SrhVo = new Psnl0131SrhVO();
			Psnl0132SrhVO psnl0132SrhVo = new Psnl0132SrhVO();
			
			
			String method = calledClass + ".selectPsnl0131";
			MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			
			
			try {
				
				psnl0131SrhVo.setDpobCd(sessionUser.getDpobCd());
				psnl0131SrhVo.setSystemkey(psnl0131Dto.getSystemkey());

				
				// 삭제처리 되지 않은 데이터만 가져옹.
				egovResultDataList = psnl0131DAO.selectPsnl0131(psnl0131SrhVo);
				
				if(egovResultDataList != null && egovResultDataList.size() > 0){
					for(int i = 0 ; i < egovResultDataList.size(); i++){
						Psnl0131DTO dto = new Psnl0131DTO();
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
						//삭제 여부가 필요한 그리드 데이터일 경우 delChk를 false값을 필수로 넘겨준다.
						dto.setDelChk(false);
						
						
		            	if(Long.parseLong(MSFSharedUtils.defaultNulls(dto.getRefeSeilNum(), "0")) > 0L ){
		            		
		            		psnl0132SrhVo = new Psnl0132SrhVO();
		            		psnl0132SrhVo.setDpobCd(sessionUser.getDpobCd());
		            		psnl0132SrhVo.setSystemkey(psnl0131Dto.getSystemkey());
		            		psnl0132SrhVo.setRefeSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(dto.getRefeSeilNum(), "0")));
		            		
		            		
		            		// 근거파일 존재할 경우 해당 데이터 dto에 담아줌.(파일 일련번호만....)
		            		egovResultDataList2 = psnl0132DAO.selectPsnl0132(psnl0132SrhVo);
		            		
		            		if(egovResultDataList2 != null && egovResultDataList2.size() > 0){
		            			
		            			lsPsnl0132Dto = new ArrayList<Psnl0132DTO>();
		            			
		            			for(int j = 0 ; j < egovResultDataList2.size(); j++){
		    						Psnl0132DTO dto2 = new Psnl0132DTO();
		    						Map tempMap2 = (Map)egovResultDataList2.get(j);
		    						Iterator<String> keys2 = tempMap2.keySet().iterator();
		    						while( keys2.hasNext() ){
		    				            String key2 = keys2.next();
		    				            
		    				            //형 타입이 숫자형일경우 형변환 해준다.
		    			            	if(tempMap2.get(key2) instanceof java.math.BigDecimal){
		    			            		dto2.set(key2, String.valueOf(tempMap2.get(key2)));
		    			            	}else{
		    			            		dto2.set(key2, tempMap2.get(key2));
		    			            	}
		    				        }
		    						
		    						lsPsnl0132Dto.add(dto2);
		    					}
		            			
		            			if(lsPsnl0132Dto.size() > 0) {
		            				for(int k = 0; k < lsPsnl0132Dto.size(); k ++) {
		            					
		            						// 값을 순서대로 담아줌.
			            					if(k == 0) {
			            						dto.setRefeFlSeilNum1( MSFSharedUtils.defaultNulls(lsPsnl0132Dto.get(k).getRefeFlSeilNum(), "0"));
			            					}else if(k == 1) {
			            						dto.setRefeFlSeilNum2( MSFSharedUtils.defaultNulls(lsPsnl0132Dto.get(k).getRefeFlSeilNum(), "0"));
			            					}else if(k == 2) {
			            						dto.setRefeFlSeilNum3( MSFSharedUtils.defaultNulls(lsPsnl0132Dto.get(k).getRefeFlSeilNum(), "0"));
			            					}
		            				}
		            				
		            				
		            				dto.setRefeFlSeilNum1( MSFSharedUtils.defaultNulls(dto.getRefeFlSeilNum1(), "0"));
		            				dto.setRefeFlSeilNum2( MSFSharedUtils.defaultNulls(dto.getRefeFlSeilNum2(), "0"));
		            				dto.setRefeFlSeilNum3( MSFSharedUtils.defaultNulls(dto.getRefeFlSeilNum3(), "0"));
		            				
		            			}
		            			
		            		}else {
			            		dto.setRefeFlSeilNum1("0");
			            		dto.setRefeFlSeilNum2("0");
			            		dto.setRefeFlSeilNum3("0");
			            	}
		            		
		            	}
						returnValue.add(dto);
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
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
			
			return new BaseListLoadResult<Psnl0131DTO>(returnValue);
		}
	 
	 	
	 
	 	/** 선택한 데이터를 가져옴 **/
	 	@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public Psnl0131DTO selectPsnl0131Data(Psnl0131DTO psnl0131Dto)throws MSFException {
			
			String windowNm = "인사";
			String windowId = "PSNL0100/PSNL0200";
			
			// TODO Auto-generated method stub
			Psnl0131DTO returnValue = new Psnl0131DTO();
			List<Psnl0132DTO> lsPsnl0132Dto = new ArrayList<Psnl0132DTO>();
			List egovResultDataList = new ArrayList();
			List egovResultDataList2 = new ArrayList();
			Psnl0131SrhVO psnl0131SrhVo = new Psnl0131SrhVO();
			Psnl0132SrhVO psnl0132SrhVo = new Psnl0132SrhVO();
			
			
			String method = calledClass + ".selectPsnl0131";
			MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			
			
			try {
				
				psnl0131SrhVo.setDpobCd(sessionUser.getDpobCd());
				psnl0131SrhVo.setSystemkey(psnl0131Dto.getSystemkey());
				psnl0131SrhVo.setRefeSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0131Dto.getRefeSeilNum(), "0")));
				
				// 삭제처리 되지 않은 데이터만 가져옹.
				egovResultDataList = psnl0131DAO.selectPsnl0131(psnl0131SrhVo);
				
				if(egovResultDataList != null && egovResultDataList.size() > 0){
					for(int i = 0 ; i < egovResultDataList.size(); i++){
						returnValue = new Psnl0131DTO();
						Map tempMap = (Map)egovResultDataList.get(i);
						Iterator<String> keys = tempMap.keySet().iterator();
						while( keys.hasNext() ){
				            String key = keys.next();
				            
				            //형 타입이 숫자형일경우 형변환 해준다.
			            	if(tempMap.get(key) instanceof java.math.BigDecimal){
			            		returnValue.set(key, String.valueOf(tempMap.get(key)));
			            	}else{
			            		returnValue.set(key, tempMap.get(key));
			            	}
				        }
						//삭제 여부가 필요한 그리드 데이터일 경우 delChk를 false값을 필수로 넘겨준다.
//						dto.setDelChk(false);
						
						
		            	if(Long.parseLong(MSFSharedUtils.defaultNulls(returnValue.getRefeSeilNum(), "0")) > 0L ){
		            		
		            		psnl0132SrhVo = new Psnl0132SrhVO();
		            		psnl0132SrhVo.setDpobCd(sessionUser.getDpobCd());
		            		psnl0132SrhVo.setSystemkey(psnl0131Dto.getSystemkey());
		            		psnl0132SrhVo.setRefeSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(returnValue.getRefeSeilNum(), "0")));
		            		
		            		
		            		// 근거파일 존재할 경우 해당 데이터 dto에 담아줌.(파일 일련번호만....)
		            		egovResultDataList2 = psnl0132DAO.selectPsnl0132(psnl0132SrhVo);
		            		
		            		if(egovResultDataList2 != null && egovResultDataList2.size() > 0){
		            			
		            			lsPsnl0132Dto = new ArrayList<Psnl0132DTO>();
		            			
		            			for(int j = 0 ; j < egovResultDataList2.size(); j++){
		    						Psnl0132DTO dto2 = new Psnl0132DTO();
		    						Map tempMap2 = (Map)egovResultDataList2.get(j);
		    						Iterator<String> keys2 = tempMap2.keySet().iterator();
		    						while( keys2.hasNext() ){
		    				            String key2 = keys2.next();
		    				            
		    				            //형 타입이 숫자형일경우 형변환 해준다.
		    			            	if(tempMap2.get(key2) instanceof java.math.BigDecimal){
		    			            		dto2.set(key2, String.valueOf(tempMap2.get(key2)));
		    			            	}else{
		    			            		dto2.set(key2, tempMap2.get(key2));
		    			            	}
		    				        }
		    						
		    						lsPsnl0132Dto.add(dto2);
		    					}
		            			
		            			if(lsPsnl0132Dto.size() > 0) {
		            				for(int k = 0; k < lsPsnl0132Dto.size(); k ++) {
		            					
		            						// 값을 순서대로 담아줌.
			            					if(k == 0) {
			            						returnValue.setRefeFlSeilNum1( MSFSharedUtils.defaultNulls(lsPsnl0132Dto.get(k).getRefeFlSeilNum(), "0"));
			            						returnValue.setRefeOrgFlnm1( MSFSharedUtils.allowNulls(lsPsnl0132Dto.get(k).getRefeOrgFlnm()));
			            						returnValue.setRefeFlnm1(MSFSharedUtils.allowNulls(lsPsnl0132Dto.get(k).getRefeFlnm()));
			            						
			            					}else if(k == 1) {
			            						returnValue.setRefeFlSeilNum2( MSFSharedUtils.defaultNulls(lsPsnl0132Dto.get(k).getRefeFlSeilNum(), "0"));
			            						returnValue.setRefeOrgFlnm2( MSFSharedUtils.allowNulls(lsPsnl0132Dto.get(k).getRefeOrgFlnm()));
			            						returnValue.setRefeFlnm2(MSFSharedUtils.allowNulls(lsPsnl0132Dto.get(k).getRefeFlnm()));
			            					}else if(k == 2) {
			            						returnValue.setRefeFlSeilNum3( MSFSharedUtils.defaultNulls(lsPsnl0132Dto.get(k).getRefeFlSeilNum(), "0"));
			            						returnValue.setRefeOrgFlnm3( MSFSharedUtils.allowNulls(lsPsnl0132Dto.get(k).getRefeOrgFlnm()));
			            						returnValue.setRefeFlnm3(MSFSharedUtils.allowNulls(lsPsnl0132Dto.get(k).getRefeFlnm()));
			            					}
		            				}
		            				
		            				
		            				returnValue.setRefeFlSeilNum1( MSFSharedUtils.defaultNulls(returnValue.getRefeFlSeilNum1(), "0"));
		            				returnValue.setRefeFlSeilNum2( MSFSharedUtils.defaultNulls(returnValue.getRefeFlSeilNum2(), "0"));
		            				returnValue.setRefeFlSeilNum3( MSFSharedUtils.defaultNulls(returnValue.getRefeFlSeilNum3(), "0"));
		            				
		            				returnValue.setRefeOrgFlnm1( MSFSharedUtils.allowNulls(returnValue.getRefeOrgFlnm1()));
		            				returnValue.setRefeOrgFlnm2( MSFSharedUtils.allowNulls(returnValue.getRefeOrgFlnm2()));
		            				returnValue.setRefeOrgFlnm3( MSFSharedUtils.allowNulls(returnValue.getRefeOrgFlnm3()));
		            				
		            				returnValue.setRefeFlnm1( MSFSharedUtils.allowNulls(returnValue.getRefeFlnm1()));
		            				returnValue.setRefeFlnm2( MSFSharedUtils.allowNulls(returnValue.getRefeFlnm2()));
		            				returnValue.setRefeFlnm3( MSFSharedUtils.allowNulls(returnValue.getRefeFlnm3()));
		            				
		            				
		            			}
		            			
		            		}else {
		            			returnValue.setRefeFlSeilNum1("0");
			            		returnValue.setRefeFlSeilNum2("0");
			            		returnValue.setRefeFlSeilNum3("0");
			            		
			            		returnValue.setRefeOrgFlnm1("");
	            				returnValue.setRefeOrgFlnm2("");
	            				returnValue.setRefeOrgFlnm3("");
	            				
	            				returnValue.setRefeFlnm1("");
	            				returnValue.setRefeFlnm2("");
	            				returnValue.setRefeFlnm3("");
			            	}
		            	}
					}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
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
			
			return returnValue;
		}
	 
	
	 	
	 	
	 	/** 데이터 등록 수정 삭제 **/
		@SuppressWarnings({ "unchecked", "rawtypes" })
		@Override
		public Long savePsnl0131(Psnl0131DTO psnl0131Dto, ActionDatabase actionDatabase) throws MSFException {
			
			
			Long returnVal = new Long(1);
			Long refeSeilNumVal = new Long(0);
			
			String windowNm = "인사";
			String windowId = "PSNL0100/PSNL0200";
			
			
			Psnl0131VO psnl0131Vo = new Psnl0131VO();
			Psnl0132VO psnl0132Vo = new Psnl0132VO();
			
			// TODO Auto-generated method stub
			
			String method = calledClass + ".insertPsnl0131"; 
			String systemkey = "";
			MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			try{
				
				//이미지 저장정보를 가지고 온다.
				HashMap<String, String> globals = MSFServerUtils.getLocalidedMessages(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest()); 
				String UPLOAD_DIRECTORY =  globals.get("PayGen.fileStorePath");
						
						
				psnl0131Vo.setDpobCd(sessionUser.getDpobCd());    															/** column 사업장코드 : dpobCd */
				psnl0131Vo.setSystemkey(psnl0131Dto.getSystemkey());    													/** column SYSTEMKEY : systemkey */
				psnl0131Vo.setRefeSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0131Dto.getRefeSeilNum(), "0")));	/** column 관련근거일련번호 : refeSeilNum */
				psnl0131Vo.setRefeIndt(SmrmfUtils.getStringFromDate(psnl0131Dto.getRefeIndt(), "yyyyMMdd"));    		/** column 관련근거등록일자 : refeIndt */
				psnl0131Vo.setRefePrchNm(MSFSharedUtils.allowNulls(psnl0131Dto.getRefePrchNm()));    						/** column 관련근거담당자명 : refePrchNm */
				psnl0131Vo.setRefePrchTel(MSFSharedUtils.allowNulls(psnl0131Dto.getRefePrchTel()));    						/** column 관련근거담당전화번호 : refePrchTel */
				psnl0131Vo.setRefeDivCd(MSFSharedUtils.allowNulls(psnl0131Dto.getRefeDivCd()));    							/** column 관련근거구분코드 : refeDivCd */
				psnl0131Vo.setRefeTitl(MSFSharedUtils.allowNulls(psnl0131Dto.getRefeTitl()));   		 					/** column 관련근거제목 : refeTitl */
				psnl0131Vo.setRefeCtnt(MSFSharedUtils.allowNulls(psnl0131Dto.getRefeCtnt()));    							/** column 관련근거내용 : refeCtnt */
				
	        	switch (actionDatabase) {
        		case INSERT:
    				psnl0131Vo.setKybdr(sessionUser.getUsrId());    															/** column 입력자 : kybdr */
    				psnl0131Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    						/** column 입력주소 : inptAddr */
    				psnl0131Vo.setIsmt(sessionUser.getUsrId());    																/** column 수정자 : ismt */
    				psnl0131Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    						/** column 수정주소 : revnAddr */
    				
    				
    				refeSeilNumVal = psnl0131DAO.insertPsnl0131(psnl0131Vo);
    				
    				// 일련번호가 0보다 크지 않으면 오류로 처리.
    				if(refeSeilNumVal > 0L) {
    					
    					// 파일 업로드 존재할 경우
    					if(psnl0131Dto.getRefeOrgFlnm().replaceAll("\\?", "")!= null && !"".equals(psnl0131Dto.getRefeOrgFlnm().replaceAll("\\?", ""))){
    						
    						psnl0132Vo = new Psnl0132VO();
    						
//    						psnl0132Vo.setRefeFlSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(psnl0131Dto.getRefeFlSeilNum(), "0");    /** column 관련근거파일일련번호 : refeFlSeilNum */
    						psnl0132Vo.setDpobCd(sessionUser.getDpobCd());    									/** column 사업장코드 : dpobCd */
    						psnl0132Vo.setSystemkey(psnl0131Dto.getSystemkey());    							/** column SYSTEMKEY : systemkey */
    						psnl0132Vo.setRefeSeilNum(new BigDecimal(refeSeilNumVal));    						/** column 관련근거일련번호 : refeSeilNum */
    						psnl0132Vo.setRefeFlcos(UPLOAD_DIRECTORY);    										/** column 관련근거파일경로 : refeFlcos */
    						
    						
    						
//    						psnl0132Vo.setRefeFlnm(psnl0131Dto.getRefeFlnm());    								/** column 관련근거파일명 : refeFlnm */
//    						psnl0132Vo.setRefeFlcos(UPLOAD_DIRECTORY);    										/** column 관련근거파일경로 : refeFlcos */
//    						psnl0132Vo.setRefeFlsz(psnl0132Dto.getRefeFlsz());    									/** column 관련근거파일크기 : refeFlsz */
    						psnl0132Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */
    						psnl0132Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  /** column 입력주소 : inptAddr */
    						psnl0132Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
    						psnl0132Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  /** column 수정주소 : revnAddr */
    						
    						
    						// split()을 이용해 ','을 기준으로 가져온 파일명들을 자른다.
    	            		String refeOrgFlnm = psnl0131Dto.getRefeOrgFlnm();
    	            		
    	            		String refeFlnm = "";
    	            		String refeFlSeilNum ="";
    	            				
    	            		String refeOrgFlnms[] = refeOrgFlnm.split("\\?");
    	            		for(int j = 0; j < refeOrgFlnms.length; j ++) {
//    	            			System.out.println(refeOrgFlnms[j]);
    	            			String[] refeFlSeilNums = refeOrgFlnms[j].split(":");
    	            			
    	            			for(int x = 0; x < refeFlSeilNums.length; x ++) {
    	            				
    	            				// 파일명 ; 일련번호 이런 형태로 데이터가 들어있으므로 0번재 값은 파일명, 1번째값은 일련번호
    	            				if(x == 0) {
    	            					refeFlnm = refeFlSeilNums[x];
    	            					psnl0132Vo.setRefeOrgFlnm(refeFlnm);			/** column 관련근거원본파일명 : refeOrgFlnm */
    	            				}else {
    	            					refeFlSeilNum = refeFlSeilNums[x];
    	            					psnl0132Vo.setRefeFlSeilNum(refeFlSeilNum);    	/** column 관련근거파일일련번호 : refeFlSeilNum */
    	            					
    	            					// 일련번호가 0일 경우 파일은 insert 처리. 0이 아닐 경우에는 해당 일련번호로 update 처리
    	        						if("0".equals(psnl0132Vo.getRefeFlSeilNum()) || psnl0132Vo.getRefeFlSeilNum() == "0") {
    	        							psnl0132DAO.insertPsnl0132(psnl0132Vo);
    	        						}
    	            				}
    	            			}
    						
    	            		}
    						
    						
//    						// split()을 이용해 ','을 기준으로 가져온 파일명들을 자른다.
//    						String refeOrgFlnm = psnl0131Dto.getRefeOrgFlnm();
//    						String refeOrgFlnms[] = refeOrgFlnm.split(",");
//    						
//    						for(int j = 0; j < refeOrgFlnms.length; j ++) {
//    							
//    							psnl0132Vo.setRefeOrgFlnm(refeOrgFlnms[j]);    						/** column 관련근거원본파일명 : refeOrgFlnm */
//    							psnl0132DAO.insertPsnl0132(psnl0132Vo);
//    						}
    					}
    					
    				}else {
    					returnVal = new Long(0);
    				}
        			break;
        			
            	case UPDATE: 
            		
            		psnl0131DAO.updatePsnl0131(psnl0131Vo);

    				
    				psnl0132Vo = new Psnl0132VO();
					

					psnl0132Vo.setDpobCd(sessionUser.getDpobCd());    									/** column 사업장코드 : dpobCd */
					psnl0132Vo.setSystemkey(psnl0131Dto.getSystemkey());    							/** column SYSTEMKEY : systemkey */
    				psnl0132Vo.setRefeFlcos(UPLOAD_DIRECTORY);    										/** column 관련근거파일경로 : refeFlcos */
					psnl0132Vo.setRefeSeilNum(psnl0131Vo.getRefeSeilNum());    							/** column 관련근거일련번호 : refeSeilNum */
					psnl0132Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
					psnl0132Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  /** column 수정주소 : revnAddr */
    				
            		// split()을 이용해 ','을 기준으로 가져온 파일명들을 자른다.
            		String refeOrgFlnm = psnl0131Dto.getRefeOrgFlnm();
            		
            		String refeFlnm = "";
            		String refeFlSeilNum ="";
            				
            		String refeOrgFlnms[] = refeOrgFlnm.split("\\?");
            		for(int j = 0; j < refeOrgFlnms.length; j ++) {
//            			System.out.println(refeOrgFlnms[j]);
            			String[] refeFlSeilNums = refeOrgFlnms[j].split(":");
            			
            			for(int x = 0; x < refeFlSeilNums.length; x ++) {
            				
            				// 파일명 ; 일련번호 이런 형태로 데이터가 들어있으므로 0번재 값은 파일명, 1번째값은 일련번호
            				if(x == 0) {
            					refeFlnm = refeFlSeilNums[x];
            					psnl0132Vo.setRefeOrgFlnm(refeFlnm);			/** column 관련근거원본파일명 : refeOrgFlnm */
            				}else {
            					refeFlSeilNum = refeFlSeilNums[x];
            					psnl0132Vo.setRefeFlSeilNum(refeFlSeilNum);    	/** column 관련근거파일일련번호 : refeFlSeilNum */
            					
            					// 일련번호가 0일 경우 파일은 insert 처리. 0이 아닐 경우에는 해당 일련번호로 update 처리
        						if("0".equals(psnl0132Vo.getRefeFlSeilNum()) || psnl0132Vo.getRefeFlSeilNum() == "0") {
        							psnl0132DAO.insertPsnl0132(psnl0132Vo);
        						}else {
        							psnl0132DAO.updatePsnl0132(psnl0132Vo); 
        						}
            				}

            			}
					
            		}
            		
            		break;
            		
            	case DELETE: 
            		psnl0131Vo.setIsmt(sessionUser.getUsrId());    											/** column 수정자 : ismt */
    				psnl0131Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 수정주소 : revnAddr */
    				psnl0131Vo.setRefeDelFg(psnl0131Dto.getRefeDelFg());    								/** column null : refeDelFg */
    				
    				psnl0131DAO.updatePsnl0131(psnl0131Vo);
    				
            		break;
	        	}	 
			
			}catch(Exception e) {
				e.printStackTrace();
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:S",e, windowNm , windowId);
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:U");
			
			//급여인사 마스트 등록 추가 끝
			return returnVal;
			
		} 
		
		
		
	 
	 
	 
	 
	 
	 
	 
	


}
