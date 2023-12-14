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
package com.app.exterms.payroll.server.service;

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

import com.app.exterms.payroll.client.dto.Payr0480DTO;
import com.app.exterms.payroll.client.service.Payr1300Service;
import com.app.exterms.payroll.server.service.dao.Payr0480DAO;
import com.app.exterms.payroll.server.vo.Payr0480SrhVO;
import com.app.exterms.payroll.server.vo.Payr0480VO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
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

@Service("Payr1300Service")
public class Payr1300ServiceImpl extends AbstractCustomServiceImpl implements Payr1300Service  ,PayrDaoConstants {

		private static final Logger logger = LoggerFactory.getLogger(Payr1300ServiceImpl.class);
		private static final String calledClass = Payr1300ServiceImpl.class.getName();
		
		@Autowired
	    @Resource(name="Payr0480DAO")
	    private Payr0480DAO payr0480DAO;
	    
	    /** ID Generation */
	    //@Resource(name="{egovPayr0480IdGnrService}")    
	    //private EgovIdGnrService egovIdGnrService;
		public PagingLoadResult<BaseModel> getPayr0480DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_PAYR0480_DATA_LIST;
	        Payr0480SrhVO   payr0480SrhVO = new Payr0480SrhVO();
	        Payr0480VO      payr0480VO ; 
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        

	    	// 1. 암호화 객체 생성
//	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(payr0480DAO)) {
	        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	payr0480DAO = (Payr0480DAO) wac.getBean("Payr0480DAO" ); 
	        }
	        
	        try {
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	           // Sysm0480BM          user             = serviceParameters.getUser();
	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

	            //Get paging configuration
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	            //Get query parameters
	            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	           
	            /** 조건절 */
	            payr0480SrhVO.setDpobCd(sessionUser.getDpobCd());
	            payr0480SrhVO.setPayExtpyGrpCd(String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "payExtpyGrpCd")));
	            payr0480SrhVO.setPayExtpyNm(String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "payExtpyNm")));
	         
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = payr0480DAO.selectPayr0480ListTotCnt(payr0480SrhVO);  
	              
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginPayr0480DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            payr0480SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	payr0480SrhVO.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	payr0480SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = payr0480DAO.selectPayr0480List(payr0480SrhVO);
	            
		      //  Iterator<Map<String, Object>> iter = list.iterator();
	            Iterator iter = list.iterator();
		            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	  
	            while ( iter.hasNext() ) {
	            	
	            	// 1. 암호화 객체 생성
	            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	            	
	                Map<String, Object> map = (Map<String, Object>) iter.next();  
	                String idValue = map.get("payExtpyCd").toString();
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginPayr0480DataList, "getPayr0480DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }

        @Override
        public Long activityOnPayr1300Save(List<Payr0480DTO> listPayr0480dto) {
            // TODO Auto-generated method stub
            Long result = new Long(0);
            Long iCnt = new Long(0);
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
            
        	// 1. 암호화 객체 생성
//        	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            
            try { 
                
                Payr0480SrhVO payr0480SrhVo = new Payr0480SrhVO(); 
                
                if  (MSFSharedUtils.paramNull(payr0480DAO)) {
                    
                    WebApplicationContext wac = WebApplicationContextUtils.
                            getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                    payr0480DAO = (Payr0480DAO) wac.getBean("Payr0480DAO" ); 
                }
              
                 
                 for(int iPayrCnt=0;iPayrCnt < listPayr0480dto.size();iPayrCnt++) {
                  
                        Payr0480DTO payr0480dto = new Payr0480DTO(); 
                        payr0480dto = listPayr0480dto.get(iPayrCnt);
                          
                        Payr0480VO payr0480Vo = new Payr0480VO(); 
                        Payr0480VO tpPayr0480Vo = new Payr0480VO(); 
                         
                        payr0480Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0480dto.getDpobCd()));    /** column 사업장코드 : dpobCd */
                        payr0480Vo.setPayExtpyCd(MSFSharedUtils.allowNulls(payr0480dto.getPayExtpyCd()));    /** column 급여수당코드 : payExtpyCd */
                        payr0480Vo.setPayExtpyGrpCd(MSFSharedUtils.allowNulls(payr0480dto.getPayExtpyGrpCd()));    /** column 급여수당그룹코드 : payExtpyGrpCd */ 
                        payr0480Vo.setPayExtpyNm(MSFSharedUtils.allowNulls(payr0480dto.getPayExtpyNm()));    /** column 급여수당명 : payExtpyNm */
                        payr0480Vo.setPayExtpyPymtPrdDivCd(MSFSharedUtils.allowNulls(payr0480dto.getPayExtpyPymtPrdDivCd()));   /** column 급여수당지급시기구분코드 : payExtpyPymtPrdDivCd */
                        payr0480Vo.setPayExtpyUseYn((Boolean.TRUE.equals(payr0480dto.getPayExtpyUseYn()) ? "Y" : "N")) ;   /** column 급여수당사용여부 : payExtpyUseYn */
                        payr0480Vo.setPayRevnPsbyYn((Boolean.TRUE.equals(payr0480dto.getPayRevnPsbyYn()) ? "Y" : "N"));    /** column 급여수정가능여부 : payRevnPsbyYn */
                        payr0480Vo.setSevePayYn((Boolean.TRUE.equals(payr0480dto.getSevePayYn()) ? "Y" : "N"));    /** column 퇴직정산여부 : sevePayYn */
                        payr0480Vo.setAccAccCd(MSFSharedUtils.allowNulls(payr0480dto.getAccAccCd())) ;   /** column 회계계정코드 : accAccCd */
                        payr0480Vo.setYrtxFreeDtyReduCd(MSFSharedUtils.allowNulls(payr0480dto.getYrtxFreeDtyReduCd()));    /** column 연말정산_비과세감면코드 : yrtxFreeDtyReduCd */
                        payr0480Vo.setPymtDducDivCd(MSFSharedUtils.allowNulls(payr0480dto.getPymtDducDivCd()));    /** column 지급공제구분코드 : pymtDducDivCd */
                        payr0480Vo.setPayrTermUseYn((Boolean.TRUE.equals(payr0480dto.getPayrTermUseYn()) ? "Y" : "N"));    /** column 기간제수당사용여부 : payrTermUseYn */
                        payr0480Vo.setUsalyAmntYn((Boolean.TRUE.equals(payr0480dto.getUsalyAmntYn()) ? "Y" : "N"));    /** column 통상임금여부 : usalyAmntYn */
                        payr0480Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
                        payr0480Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
                        payr0480Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
                        payr0480Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
        	        	
                        
                        tpPayr0480Vo = payr0480DAO.selectPayr0480(payr0480Vo);
                         
                        
                        if (tpPayr0480Vo == null) { 
                          
                              payr0480DAO.insertPayr0480(payr0480Vo); 
                              iCnt = iCnt + 1;
                        } else {
                              payr0480DAO.updatePayr0480(payr0480Vo); 
                              iCnt = iCnt + 1;
                        }       
                              
                        
                   } 
                    result = iCnt;
              
            }
            catch (Exception ex) {
                logger.error("EXCEPTION calling activityOnPayr1500BfToNew(): "+ex); 
                result = new Long(0);
                throw MSFServerUtils.getOperationException("activityOnPayr1500BfToNew", ex, logger);
            }
            finally {
              
            }
            
            return result;
        }

        @Override
        public Long activityOnPayr1300Delete(List<BaseModel> listModels) {
            // TODO Auto-generated method stub
            Long result = new Long(0);
            Long iCnt = new Long(0);
            try { 
                
                Payr0480VO payr0480Vo = new Payr0480VO(); 
                
                if  (MSFSharedUtils.paramNull(payr0480DAO)) {
                    
                    WebApplicationContext wac = WebApplicationContextUtils.
                            getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                    payr0480DAO = (Payr0480DAO) wac.getBean("Payr0480DAO" ); 
                }
          
             
                    Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)listModels.iterator();
                    while (iterRecords.hasNext()) {
                      
                        BaseModel bmMapModel = (BaseModel) iterRecords.next();
                           
                        payr0480Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd"))); 
                        payr0480Vo.setPayExtpyCd(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyCd"))) ; 
                           
                        payr0480DAO.deletePayr0480(payr0480Vo);  
                      
                        iCnt = iCnt + 1;
                         
                   } 
                    result = iCnt;
              
            }
            catch (Exception ex) {
                logger.error("EXCEPTION calling activityOnPayr1300Delete(): "+ex); 
                result = new Long(0);
                throw MSFServerUtils.getOperationException("activityOnPayr1300Delete", ex, logger);
            }
            finally {
              
            }
            
            return result;
        }

       
}
