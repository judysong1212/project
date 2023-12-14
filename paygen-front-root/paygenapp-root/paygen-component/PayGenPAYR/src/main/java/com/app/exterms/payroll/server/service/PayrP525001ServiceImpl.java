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

import com.app.exterms.payroll.client.service.PayrP525001Service;
import com.app.exterms.payroll.server.service.dao.Payr0416DAO;
import com.app.exterms.payroll.server.service.dao.Payr0417DAO;
import com.app.exterms.payroll.server.vo.Payr0416SrhVO;
import com.app.exterms.payroll.server.vo.Payr0416VO;
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

@Service("PayrP525001Service")
public class PayrP525001ServiceImpl extends AbstractCustomServiceImpl implements PayrP525001Service , PayrDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(PayrP525001ServiceImpl.class);
	private static final String calledClass = PayrP525001ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="Payr0416DAO")
    private Payr0416DAO payr0416DAO;
    
	
	@Autowired
    @Resource(name="Payr0417DAO")
    private Payr0417DAO payr0417DAO;
	
	/** 이전년도직종세이관 조회 **/
	public PagingLoadResult<BaseModel> getPayr0416CopyDataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0416_COPY_DATA_LIST;
        Payr0416SrhVO   payr0416SrhVO = new Payr0416SrhVO();
        Payr0416VO      payr0416VO = new Payr0416VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(payr0416DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	payr0416DAO = (Payr0416DAO) wac.getBean("Payr0416DAO" ); 
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
           
            /** 조건절 */
            payr0416SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0416SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
            payr0416SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
          //  payr0415SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0416SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0416SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
          //  payr0415SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));  
            payr0416SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));  
            payr0416SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));  
            
            payr0416SrhVO.setCreateYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "createYr")));
            
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0416DAO.selectBeforePayr0416ListTotCnt(payr0416SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;
                
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0415DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0416SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0416SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0416SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            	
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0416DAO.selectBeforePayr0416List(payr0416SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("typOccuCd").toString();
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
                  	
                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    
                    if("transferYn".equals(tableAttributes[i].getName())){
                    	if(null == baseModelValue || "".equals(baseModelValue)){
                    		baseModelValue = false;
                    	}
                    }
                    	bm.set(tableAttributes[i].getName(), baseModelValue); 
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0415DataList, "getPayr0416CopyDataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	
	/** 직종세 이관 **/
	@Override
	public Long activityOnPayr0416Copy(List<BaseModel> list, BaseModel bm) throws MSFException { 

		Long result = new Long(0); 

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		// 1. 암호화 객체 생성
//		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		try {  
			if  (MSFSharedUtils.paramNull(payr0416DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.
						getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				payr0416DAO = (Payr0416DAO) wac.getBean("Payr0416DAO" ); 
			}

			Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)list.iterator();
			while (iterRecords.hasNext()) {
				BaseModel bmMapModel = (BaseModel) iterRecords.next();
				Payr0416VO  payr0416Vo = new Payr0416VO();
				String transferYn = MSFSharedUtils.allowNulls(bmMapModel.get("transferYn"));
				if(transferYn.equals("false")){
					
					String createYr = MSFSharedUtils.allowNulls(bm.get("createYr"));
					
					if(createYr != null && !createYr.equals("")){
						
						payr0416Vo.setDpobCd(sessionUser.getDpobCd());
						payr0416Vo.setPayYr(createYr);
						
						payr0416Vo.setPayYr(MSFSharedUtils.allowNulls(createYr));
//			            payr0416Vo.setDeptCd(MSFSharedUtils.allowNulls(bmMapModel.get("deptCd").toString()));
//			            payr0416Vo.setTypOccuCd(MSFSharedUtils.allowNulls(bmMapModel.get("typOccuCd"))) ;
//			            payr0416Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(bmMapModel.get("dtilOccuInttnCd"))) ;
//			            payr0416Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(bmMapModel.get("pyspGrdeCd")));  
			            payr0416Vo.setDtilOccuDlySeilNum(new BigDecimal(bmMapModel.get("dtilOccuDlySeilNum").toString()));
			               
			            payr0416Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
			            payr0416Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
			            payr0416Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
			            payr0416Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
						
						
						payr0416DAO.insertPayr0416Copy(payr0416Vo);

						result = result + 1;
					}
				}
			}

		}catch (Exception ex) {
			logger.error("EXCEPTION calling activityOnPayr0416Copy(): "+ex); 
			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnPayr0416Copy", ex, logger);
		}
		
		finally {

		}

		return result;
	} 

	
 
}
