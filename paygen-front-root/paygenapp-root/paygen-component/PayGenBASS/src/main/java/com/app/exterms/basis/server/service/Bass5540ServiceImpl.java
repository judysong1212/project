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
package com.app.exterms.basis.server.service;

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

import com.app.exterms.basis.client.dto.Bass5540DTO;
import com.app.exterms.basis.client.service.Bass5540Service;
import com.app.exterms.basis.server.service.dao.Bass5540DAO;
import com.app.exterms.basis.server.vo.Bass5540SrhVO;
import com.app.exterms.basis.server.vo.Bass5540VO;
import com.app.exterms.basis.shared.BasisDaoConstants;
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
@Service("Bass5540Service")
public class Bass5540ServiceImpl extends AbstractCustomServiceImpl implements Bass5540Service, BasisDaoConstants {


	private static final Logger logger = LoggerFactory.getLogger(Bass5540ServiceImpl.class);
	private static final String calledClass = Bass5540ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="Bass5540DAO")
    private Bass5540DAO bass5540DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPayr0470IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
	public PagingLoadResult<BaseModel> getBass5540DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_BASS5540_DATA_LIST;
        Bass5540SrhVO   bass5540SrhVO = new Bass5540SrhVO();
        Bass5540VO      bass5540VO = new Bass5540VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(bass5540DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	bass5540DAO = (Bass5540DAO) wac.getBean("Bass5540DAO" ); 
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
            bass5540SrhVO.setDpobCd(sessionUser.getDpobCd());
            bass5540SrhVO.setPayDducGrpCd(MSFSharedUtils.defaultNulls( MSFServerUtils.getFilterValue(columnFilters, "payDducGrpCd"),""));
            bass5540SrhVO.setPayDducNm(MSFSharedUtils.defaultNulls( MSFServerUtils.getFilterValue(columnFilters, "payDducNm"),""));
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = bass5540DAO.selectBass5540ListTotCnt(bass5540SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0470DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            bass5540SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	bass5540SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	bass5540SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = bass5540DAO.selectBass5540List(bass5540SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payDducCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0470DataList, "getPayr0470DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
    @Override
    public Long activityOnBass5540Save(List<Bass5540DTO> listPayr0470dto) {
        // TODO Auto-generated method stub
        Long result = new Long(0);
        Long iCnt = new Long(0);
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        try { 
            
            Bass5540SrhVO payr0470SrhVo = new Bass5540SrhVO(); 
            
        	// 1. 암호화 객체 생성
//        	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            
            if  (MSFSharedUtils.paramNull(bass5540DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                bass5540DAO = (Bass5540DAO) wac.getBean("Bass5540DAO" ); 
            }
          
            for(int iPayrCnt=0;iPayrCnt < listPayr0470dto.size();iPayrCnt++) {
                
                   Bass5540DTO payr0470dto = new Bass5540DTO(); 
                   payr0470dto = listPayr0470dto.get(iPayrCnt);
                  
                    Bass5540VO payr0470Vo = new Bass5540VO(); 
                    Bass5540VO tpPayr0470Vo = new Bass5540VO(); 

                    payr0470Vo.setDpobCd(payr0470dto.getDpobCd());    													/** column 사업장코드 : dpobCd */
                    payr0470Vo.setPayDducCd(payr0470dto.getPayDducCd());    											/** column 급여공제코드 : payDducCd */
                    payr0470Vo.setPymtDducDivCd(payr0470dto.getPymtDducDivCd());    									/** column 지급공제구분코드 : pymtDducDivCd */
                    payr0470Vo.setPayDducGrpCd(payr0470dto.getPayDducGrpCd());    										/** column 급여공제그룹코드 : payDducGrpCd */
                    payr0470Vo.setPayDducNm(payr0470dto.getPayDducNm());    											/** column 급여공제명 : payDducNm */
                    payr0470Vo.setPayDducUseYn(Boolean.TRUE.equals(payr0470dto.getPayDducUseYn()) ? "Y" : "N" );    	/** column 급여공제사용여부 : payDducUseYn */
                    payr0470Vo.setPayDducSum(new BigDecimal(MSFSharedUtils.allowNulls(payr0470dto.getPayDducSum())));	/** column 급여공제금액 : payDducSum */
                    payr0470Vo.setPayDducRto(new BigDecimal(MSFSharedUtils.allowNulls(payr0470dto.getPayDducRto())));	/** column 급여공제비율 : payDducRto */
                    payr0470Vo.setYrtxDducDivCd(payr0470dto.getYrtxDducDivCd());    									/** column 연말정산_공제구분코드 : yrtxDducDivCd */
                    payr0470Vo.setGrpApptnDivCd(payr0470dto.getGrpApptnDivCd());    									/** column 그룹적용구분코드 : grpApptnDivCd */
                    payr0470Vo.setPayDducBgnnDt(payr0470dto.getPayDducBgnnDt());    									/** column 급여공제시작일자 : payDducBgnnDt */
                    payr0470Vo.setPayDducEndDt(payr0470dto.getPayDducEndDt());    										/** column 급여공제종료일자 : payDducEndDt */
                    payr0470Vo.setPayrTermDducYn(Boolean.TRUE.equals(payr0470dto.getPayrTermDducYn()) ? "Y" : "N" );    /** column 기간제공제사용여부 : payrTermDducYn */
                    payr0470Vo.setKybdr(sessionUser.getUsrId());    													/** column 입력자 : kybdr */
                    payr0470Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    				/** column 입력주소 : inptAddr */
                    payr0470Vo.setIsmt(sessionUser.getUsrId());    														/** column 수정자 : ismt */
                    payr0470Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    				/** column 수정주소 : revnAddr */
                    
                    tpPayr0470Vo = bass5540DAO.selectBass5540(payr0470Vo);
                     
                    if (tpPayr0470Vo == null) { 
                      
                          bass5540DAO.insertBass5540(payr0470Vo); 
                          iCnt = iCnt + 1;
                    } else {
                          bass5540DAO.updateBass5540(payr0470Vo); 
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
    public Long activityOnBass5540Delete(List<BaseModel> listModels) {
        // TODO Auto-generated method stub
        Long result = new Long(0);
        Long iCnt = new Long(0);
        try { 
            
            Bass5540VO payr0470Vo = new Bass5540VO(); 
            
            if  (MSFSharedUtils.paramNull(bass5540DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                bass5540DAO = (Bass5540DAO) wac.getBean("Bass5540DAO" ); 
            }
      
         
                Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)listModels.iterator();
                while (iterRecords.hasNext()) {
                  
                    BaseModel bmMapModel = (BaseModel) iterRecords.next();
                       
                    payr0470Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd"))); 
                    payr0470Vo.setPayDducCd(MSFSharedUtils.allowNulls(bmMapModel.get("payDducCd"))) ; 
                       
                    bass5540DAO.deleteBass5540(payr0470Vo);  
                  
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
