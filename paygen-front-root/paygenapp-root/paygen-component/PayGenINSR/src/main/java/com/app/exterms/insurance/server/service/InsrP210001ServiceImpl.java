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

import com.app.exterms.insurance.client.dto.Insr1550DTO;
import com.app.exterms.insurance.client.service.InsrP210001Service;
import com.app.exterms.insurance.server.service.dao.Insr1500DAO;
import com.app.exterms.insurance.server.vo.Insr1550SrhVO;
import com.app.exterms.insurance.server.vo.Insr1550VO;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
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
 

@Service("InsrP210001Service")
public class InsrP210001ServiceImpl extends AbstractCustomServiceImpl implements InsrP210001Service,InsrDaoConstants {
	
		private static final Logger logger = LoggerFactory.getLogger(InsrP210001ServiceImpl.class);
		private static final String calledClass = InsrP210001ServiceImpl.class.getName();
		
		@Autowired
	    @Resource(name="Insr1500DAO")
	    private Insr1500DAO insr1500DAO;
		
		public PagingLoadResult<BaseModel> getInsrP210001ToInsr1500DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_INSRP210001TOINSR1500_DAO_LIST;
	        Insr1550SrhVO   insr1550SrhVO = new Insr1550SrhVO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(insr1500DAO)) {
	        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	insr1500DAO = (Insr1500DAO) wac.getBean("Insr1500DAO" ); 
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

	            /** 조건절 */
	            insr1550SrhVO.setDpobCd(sessionUser.getDpobCd());
	            insr1550SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));
	            insr1550SrhVO.setFamyAqtnLssDt(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "famyAqtnLssDt")));     /** set 사회보험작성일자 : soctyInsurCmptnDt */
	            insr1550SrhVO.setFamyAqtnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "aqtnDivCd")));     /** 취득상실 구분 */
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = insr1500DAO.selectInsrP210001ToInsr1500ListTotCnt(insr1550SrhVO);  
	                
	                if (!pagingValues.pageExecute) { 
	                	pagingValues.offsetLimit = iResultCnt;       
                	}
	              
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginInsrP210001ToInsr1500DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            insr1550SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	insr1550SrhVO.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	insr1550SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
	            List list = insr1500DAO.selectInsrP210001ToInsr1500List(insr1550SrhVO);
	            
		        Iterator<Map<String, Object>> iter = list.iterator();
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("systemkey").toString();
	                BaseModel bm = new BaseModel();
	 
	                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
	                	
	                    Object mapCon = map.get(tableAttributes[i].getName());  
	                     
	                    switch ( tableAttributes[i].getType() ) {  
	                    case ColumnDef.TYPE_STRING: 
	                    	String strValue = String.valueOf(mapCon);
	                    	if("famySecRegnNum".equals(tableAttributes[i].getName())) {
	                    		// TODO 주민번호	                    		
	                    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("famySecRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	                    	}	       
	                    	
	                    	if("useResnRegnNum".equals(tableAttributes[i].getName())) {
	                    		// TODO 주민번호	                    			                    		
	                    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("useResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	                    	}	
	                    	if("famyResnRegnNum".equals(tableAttributes[i].getName())) {
	                    		// TODO 주민번호	                    			                    		
	                    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("famyResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
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
	                    
	                    bm.set(tableAttributes[i].getName(), baseModelValue);
	                }

	                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
	                bmResult.add(bm);
	            } 

	            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
	            
	            SmrmfUtils.endTiming(logger, millisBeginInsrP210001ToInsr1500DataList, "getInsrP210001ToInsr1500DataList");
	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }

		@Override
		public Long activityOnInsr1500(List<Insr1550DTO> listInsr1550DTO, ActionDatabase actionDatabase)  throws MSFException {
			
			String method = calledClass + ".activityOnInsr1500";
			
			Long result = new Long(1);
			Long iCnt = new Long(0);
			
			String windowNm = "사회보험자격취득신고";
			String windowId = "INSRP210001";
			
			MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			
			if  (MSFSharedUtils.paramNull(insr1500DAO)) {
		        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	insr1500DAO = (Insr1500DAO) wac.getBean("Insr1500DAO" ); 
	        }

			try {
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				Insr1550VO  Insr1550Vo = new Insr1550VO();
		                
				for(int iInsrCnt=0;iInsrCnt < listInsr1550DTO.size();iInsrCnt++) {
					
					Insr1550DTO Insr1550DTO = new Insr1550DTO();  
	                Insr1550DTO = listInsr1550DTO.get(iInsrCnt);   
	                
	        	    Insr1550Vo.setFamyAqtnLssNum(Insr1550DTO.getFamyAqtnLssNum()); // 취득일련번호
	                Insr1550Vo.setDpobCd(Insr1550DTO.getDpobCd());    /** column 사업장코드 : dpobCd */
	                Insr1550Vo.setSystemkey(Insr1550DTO.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                Insr1550Vo.setFamySeilNum(Insr1550DTO.getFamySeilNum());    /** column 급여가족사항일련번호 : famySeilNum */
	                Insr1550Vo.setFamyResnRegnNum(Insr1550DTO.getFamyResnRegnNum());    /** column 급여가족주민번호 : famyResnRegnNum */
	                
	                Insr1550Vo.setFamyResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(Insr1550DTO.getFamyResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
	                
	                
	                Insr1550Vo.setFamyNm(Insr1550DTO.getFamyNm());    /** column 한글성명 : famyNm */
	                Insr1550Vo.setFamyRelaDivCd(Insr1550DTO.getFamyRelaDivCd());    /** column 가족관계구분코드 : famyRelaDivCd */
	                Insr1550Vo.setDbpsnNatnCd(Insr1550DTO.getDbpsnNatnCd()); //국적코드
	                Insr1550Vo.setAqtnDivCd(Insr1550DTO.getAqtnDivCd()); //취득구분 > 취득
	                Insr1550Vo.setAqtnReasCd(Insr1550DTO.getAqtnReasCd()); //취득사유 > 직장피부양자상실(취득)

	                Insr1550Vo.setFamyAqtnLssNum(Insr1550DTO.getFamyAqtnLssNum());    /** column 피부양자취득상실_고용일련번호 : famyAqtnLssNum */
	                Insr1550Vo.setFamyAqtnLssDt(Insr1550DTO.getFamyAqtnLssDt());    /** column 피부양자취득상실신고작성일자 : famyAqtnLssDt */
	                Insr1550Vo.setAqtnDt(Insr1550DTO.getAqtnDt());    /** column 피부양자취득일자 : aqtnDt */
	                Insr1550Vo.setAqtnReasCd(Insr1550DTO.getAqtnReasCd());    /** column 피부양자취득사유코드 : aqtnReasCd */
	                Insr1550Vo.setDbpsnAssttnSgnCd(Insr1550DTO.getDbpsnAssttnSgnCd());     /** column 장애인_종별부호코드 : dbpsnAssttnSgnCd */
	                Insr1550Vo.setDbpsnGrdeCd(Insr1550DTO.getDbpsnGrdeCd());   /** column 장애인_등급코드 : dbpsnGrdeCd */
	                Insr1550Vo.setDbpsnRgstnDt(Insr1550DTO.getDbpsnRgstnDt());    /** column 장애인_등록일자 : dbpsnRgstnDt */                 
	                Insr1550Vo.setFrgnrStyQftntCd(Insr1550DTO.getFrgnrStyQftntCd());    /** column 외국인_체류자격코드 : frgnrStyQftntCd */
	                Insr1550Vo.setFrgnrStyBgnnDt(Insr1550DTO.getFrgnrStyBgnnDt());    /** column 외국인_체류시작일자 : frgnrStyBgnnDt */
	                Insr1550Vo.setFrgnrStyEndDt(Insr1550DTO.getFrgnrStyEndDt());    /** column 외국인_체류종료일자 : frgnrStyEndDt */
	                
	                Insr1550Vo.setInsrDpobNm(Insr1550DTO.getInsrDpobNm()); //건강보험사업장명
	                Insr1550Vo.setInsrDpobNum(Insr1550DTO.getInsrDpobNum()); //건강보험사업장관리번호
	                Insr1550Vo.setInsrDpobPhnNum(Insr1550DTO.getInsrDpobPhnNum()); //건강보험사업장전화번호
	                Insr1550Vo.setInsrUsePhnNum(Insr1550DTO.getInsrUsePhnNum()); //건강보험가입자전화번호
	                
	                Insr1550Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
	                Insr1550Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
	                Insr1550Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
	                Insr1550Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
	                
	                switch (actionDatabase) {
	                	case INSERT:
	                		int iResultCnt = insr1500DAO.selectInsr1500Check(Insr1550Vo);
	                		int iResultCnt2 = insr1500DAO.selectInsr15501600Check(Insr1550Vo);
	                		
	                		if (iResultCnt == 0) {
	                			insr1500DAO.insertInsr1500(Insr1550Vo);
	                		} 
	                		if (iResultCnt2 == 0) {
	                			if ( !"A0190001".equals(Insr1550Vo.getFamyRelaDivCd()) && Insr1550Vo.getFamyRelaDivCd() != null) {
	                				
	                				if( "I0100001".equals(Insr1550Vo.getAqtnDivCd()) ) {
	                					insr1500DAO.insertInsr1550(Insr1550Vo);
	                				}
	                				else if( "I0100002".equals(Insr1550Vo.getAqtnDivCd()) ) {
	                					insr1500DAO.insertInsr1600(Insr1550Vo);
	                				}
	                			}
	                		} 
	                		break;
	            
	                	case UPDATE:
	                		if( "I0100001".equals(Insr1550Vo.getAqtnDivCd()) ) {
	                			insr1500DAO.updateInsr1550(Insr1550Vo);
            				}
            				else if( "I0100002".equals(Insr1550Vo.getAqtnDivCd()) ) {
            					insr1500DAO.updateInsr1600(Insr1550Vo);
            				}
	                		
	                		break;
	                		
	                	case DELETE:
	                		insr1500DAO.deleteInsr15501600(Insr1550Vo);
	                		break;
	                }
	                
	                iCnt = iCnt + 1;
                }
			result = iCnt;
			
			}  catch (Exception ex) {
				result = new Long(0);
				ex.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, "S:" + actionDatabase.toString(),ex, windowNm , windowId);
				
				throw MSFServerUtils.getOperationException("activityOnInsr1500", ex, logger);
			}
	        finally {
	          
	        }
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
            MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:" + actionDatabase.toString());
	        
			return result;
	}

}
