/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.app.exterms.insurance.server.service;

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

import com.app.exterms.insurance.client.service.InsrP410003Service;
import com.app.exterms.insurance.server.service.dao.Insr3000DAO;
import com.app.exterms.insurance.server.vo.Insr3000SrhVO;
import com.app.exterms.insurance.server.vo.Insr3000VO;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.exterms.payroll.shared.InfcPkgPayrDaoConstants;
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
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0304DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0304SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0304VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
@Service("InsrP410003Service")
public class InsrP410003ServiceImpl extends AbstractCustomServiceImpl implements InsrP410003Service ,InsrDaoConstants,InfcPkgPayrDaoConstants{
	
	 
		 
			private static final Logger logger = LoggerFactory.getLogger(InsrP410003ServiceImpl.class);
			private static final String calledClass = InsrP410003ServiceImpl.class.getName();
			
			
			@Autowired
		    @Resource(name="InfcPkgPayr0304DAO")
		    private InfcPkgPayr0304DAO infcPayr0304DAO;
			
			@Autowired
		    @Resource(name="Insr3000DAO")
		    private Insr3000DAO insr3000DAO; 

			  /** ID Generation */
		    //@Resource(name="{egovInsrRP410003Payr0304IdGnrService}")    
		    //private EgovIdGnrService egovIdGnrService;
 		
			/**
			 * 건강보험 개별납부실적조회
			 * @param serviceParameters
			 * @return
			 * @throws MSFException
			 */ 
		        public PagingLoadResult<BaseModel> getInsrP410003ToInsr3000DataList(ServiceParameters serviceParameters) throws MSFException {

			        PagingLoadResult<BaseModel> retval = null;
			        String method =  CLASS_INSRP410003TOINSR3000_DAO_LIST;
			        Insr3000SrhVO   insr3000SrhVo = new Insr3000SrhVO();
			        Insr3000VO      insr3000Vo = new Insr3000VO();
			        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			        
			        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			        
			        if  (MSFSharedUtils.paramNull(insr3000DAO)) {
			        
			        	WebApplicationContext wac = WebApplicationContextUtils.
			                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

			        	insr3000DAO = (Insr3000DAO) wac.getBean("Insr3000DAO" ); 
			        }
			        
			        try {
			        	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
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
			           
			            /** 조건절 */
			            insr3000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
			            insr3000SrhVo.setPymtYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYr"))); //지급년도
			            insr3000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키 
			            
			            //Get total record count //전체 데이터 갯수를 가지고 온다. 
				         if ( pagingValues.executeRecordCount ) { 
				            	
			                //Execute query that returns a single value
			                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
			                 
			                int iResultCnt = insr3000DAO.selectInsrP410003ToInsr3000ListTotCnt(insr3000SrhVo);  
			                if (!pagingValues.pageExecute) { 
			                    pagingValues.offsetLimit = iResultCnt;       
			                }
			                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
			                pagingValues.totalRecordCount = iResultCnt;	       
			                
			                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			            }
			        
			            TimingInfo millisBeginInsrP410003ToInsr3000DataList = SmrmfUtils.startTiming(logger);
			        
			            /**페이지 카운트 처리를 위한 부분 */ 
			            insr3000SrhVo.setPageSize(pagingValues.totalRecordCount);  
			            
			            //Apply paging
			            if (pagingValues.start > 0) {
			            	insr3000SrhVo.setFirstIndex(pagingValues.start);
			            }
			            if (pagingValues.offsetLimit > 0) {
			            	insr3000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
			            }

			            //Execute query and convert to BaseModel list
			            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			            
			            @SuppressWarnings("unchecked")
//					            Collection<Map<String, Object>> list ??????
			            List list = insr3000DAO.selectInsrP410003ToInsr3000List(insr3000SrhVo);
			            
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
			                	case ColumnDef.TYPE_STRING: 
			                		String strValue = String.valueOf(mapCon);
			                		if("resnRegnNum".equals(tableAttributes[i].getName())) {
			                			// TODO 주민번호		
			                			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
			                		}
			                		map.put(tableAttributes[i].getName(), strValue);
			                		break;

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
			            
			            SmrmfUtils.endTiming(logger, millisBeginInsrP410003ToInsr3000DataList, "getInsrP410003ToInsr3000DataList");
			       

			        }
			        catch (Exception ex) {
			        	ex.printStackTrace();
			            //Return operation exception
			            throw MSFServerUtils.getOperationException(method, ex, logger);
			        }

			        return retval;
			    }
			
			/**
			 * 개별대상자조회리스트 
			 * 
			 * @param serviceParameters
			 * @return
			 * @throws MSFException
			 */
			public PagingLoadResult<BaseModel> getInsrRP410003Payr0304DataList(ServiceParameters serviceParameters) throws MSFException {

		        PagingLoadResult<BaseModel> retval = null;
		        String method =  CLASS_PAYR0304TOINSRP410003_DATA_LIST;
		        InfcPkgPayr0304SrhVO   payr0304SrhVO = new InfcPkgPayr0304SrhVO();
		        InfcPkgPayr0304VO      payr0304VO = new InfcPkgPayr0304VO();
		        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		        
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		        if  (MSFSharedUtils.paramNull(infcPayr0304DAO)) {
		        
		        	WebApplicationContext wac = WebApplicationContextUtils.
		                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

		        	infcPayr0304DAO = (InfcPkgPayr0304DAO) wac.getBean("InfcPkgPayr0304DAO" ); 
		        }
		        
		        try {
		        	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
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
		            payr0304SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
		            payr0304SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
		           
		            payr0304SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
		            
		            payr0304SrhVO.setUsrId(sessionUser.getUsrId());  
		            
		            /******************************** 권한 ************************************************************************/
		            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
		            if ("FALSE".equals(chkDeptCd)) {
		            	payr0304SrhVO.setDeptCd(sessionUser.getDeptCd()); 
		               listDeptCd.add(sessionUser.getDeptCd());
		               payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
		               payr0304SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
		            } else {
		            	    
		            	 payr0304SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
		                     if (payr0304SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
		                     	 listDeptCd = null; 
		                     	payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
		                     	payr0304SrhVO.setDeptCd("");  //부서코드
		                     } else {
		                    	 payr0304SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
		                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
		                          payr0304SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
		                     } 
		                  
		            }
		            
		            payr0304SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
		            payr0304SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
		            /******************************** 권한 ************************************************************************/
		            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
		            payr0304SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
		            payr0304SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
		           
//		            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//		            payr0304SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//		            payr0304SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
		             
		            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
		            payr0304SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		            payr0304SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
		            
		            payr0304SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
		            
		            payr0304SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  //급여구분코드 
		            payr0304SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr"))); //지급년
		            payr0304SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
		            payr0304SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
		            
		            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
		            payr0304SrhVO.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
		            payr0304SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
		            
		            //Get total record count //전체 데이터 갯수를 가지고 온다. 
			         if ( pagingValues.executeRecordCount ) { 
			            	
		                //Execute query that returns a single value
		                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		                int iResultCnt = infcPayr0304DAO.selectInsrRP410003Payr0304ListTotCnt(payr0304SrhVO);  
		              
		                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
		                pagingValues.totalRecordCount = iResultCnt;	       
		                
		                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
		            }
		        
		            TimingInfo millisBeginInsrRP410003Payr0304DataList = SmrmfUtils.startTiming(logger);
		        
		            /**페이지 카운트 처리를 위한 부분 */ 
		            payr0304SrhVO.setPageSize(pagingValues.totalRecordCount);  
		            
		            //Apply paging
		            if (pagingValues.start > 0) {
		            	payr0304SrhVO.setFirstIndex(pagingValues.start);
		            }
		            if (pagingValues.offsetLimit > 0) {
		            	payr0304SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
		            }

		            //Execute query and convert to BaseModel list
		            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
		            
		            @SuppressWarnings("unchecked")
//		            Collection<Map<String, Object>> list ??????
		            List list = infcPayr0304DAO.selectInsrRP410003Payr0304List(payr0304SrhVO);
		            
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
		                    case ColumnDef.TYPE_STRING: 
		                    	String strValue = String.valueOf(mapCon);
		                    	if("resnRegnNum".equals(tableAttributes[i].getName())) {
		                    		// TODO 주민번호		
		                    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		                    	}
		                    	map.put(tableAttributes[i].getName(), strValue);
		                    	break;
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
		            
		            SmrmfUtils.endTiming(logger, millisBeginInsrRP410003Payr0304DataList, "getInsrRP410003Payr0304DataList");
		       

		        }
		        catch (Exception ex) {
		        	ex.printStackTrace();
		            //Return operation exception
		            throw MSFServerUtils.getOperationException(method, ex, logger);
		        }

		        return retval;
		    }
}
