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
package com.app.smrmf.sysauth.system.server.service;

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
import com.app.smrmf.sysauth.system.client.service.Sysm0900Service;
import com.app.smrmf.sysauth.system.shared.SysmDaoConstants;
import com.app.smrmf.sysm.server.service.dao.Sysm0900DAO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0900SrhVO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

/**
 * <pre>
 * com.app.smrmf.sysauth.system.server.service 
 *    |_ Sysm0700ServiceImpl.java
 * 
 * </pre>
 * @date : Nov 11, 2015 11:35:06 PM
 * @version : 
 * @author : leeheuisung
 */
@Service("Sysm0900Service")
public class Sysm0900ServiceImpl extends AbstractCustomServiceImpl implements  SysmDaoConstants ,  Sysm0900Service {
	 
	private static final Logger logger = LoggerFactory.getLogger(Sysm0900ServiceImpl.class);
	private static final String calledClass = Sysm0900ServiceImpl.class.getName();
	
	@Autowired 
    @Resource(name="Sysm0900DAO")
    private Sysm0900DAO sysm0900DAO;
	
	   
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 암복호화 된 데이터를 출력한다.
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getSelectSysm0900List
	 * @date : 
	 * @author : 
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	
	 *	-----------------------------------------------------------------------
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getSelectSysm0900List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_SYSM0900_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>(); 
        SysIfSysm0900SrhVO   sysm0900SrhVo = new SysIfSysm0900SrhVO();
        
        int iResultCnt;
        List list;
        
        // 1. 암호화 객체 생성
     	String nResult;
		try {
			    nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
        
		     	 MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		        if(MSFSharedUtils.paramNull(sysm0900DAO)){
		        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
		        	sysm0900DAO = (Sysm0900DAO) wac.getBean("Sysm0900DAO");
		        }
		        try{
		        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
		            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
		            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
		            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();            
		            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
		            
		            
		            sysm0900SrhVo.setDpobCd(sessionUser.getDpobCd());
		            sysm0900SrhVo.setDataType(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dataType"))); 
		            sysm0900SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd"))); 
		            
			      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
					if ( pagingValues.executeRecordCount ) { 
				            	
						//Execute query that returns a single value
			        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
			                 
		            	if("PSNL0100".equals(sysm0900SrhVo.getDataType())) {
		            		iResultCnt = sysm0900DAO.selectSysm0900ToPsnl0100ListCnt(sysm0900SrhVo);
		            	}else {
		            		iResultCnt = sysm0900DAO.selectSysm0900ToPsnl0115ListCnt(sysm0900SrhVo);
		            	}
			              
			          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
			          	
			          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
		                if (!pagingValues.pageExecute) { 
		                    pagingValues.offsetLimit = iResultCnt;       
		                }
		                
			         	pagingValues.totalRecordCount = iResultCnt;	       
			                
			        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
					}
					
					TimingInfo millisBeginSelectBass0450ToBass0400List = SmrmfUtils.startTiming(logger);
		            
		            sysm0900SrhVo.setPageSize(pagingValues.totalRecordCount);
		            if( pagingValues.start > 0){
		            	sysm0900SrhVo.setFirstIndex(pagingValues.start);
		            }
		            if (pagingValues.offsetLimit > 0) {
		            	sysm0900SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		            }
		            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
		            
		            
		        	if("PSNL0100".equals(sysm0900SrhVo.getDataType())) {
		        		list = sysm0900DAO.selectSysm0900ToPsnl0100List(sysm0900SrhVo);
		        	}else {
		        		list = sysm0900DAO.selectSysm0900ToPsnl0115List(sysm0900SrhVo);
		        	}
		            
		            
		            Iterator<Map<String, Object>> iter = list.iterator();
		            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
		            
		            
		            while (iter.hasNext() ) {
		            	
		            	Map<String, Object> map = (Map<String, Object>) iter.next();
		                String deptCd = String.valueOf(map.get("systemkey"));
		                
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
			          			String rrnDecCrypt = "";
			          	   			
			          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
			          		          			
			          				rrnDecCrypt = "";
			          		          			
			          				// TODO 주민번호 
			          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
			          		          		
			          				strValue = rrnDecCrypt;
			          							
			          			}else if("famyResnRegnNum".equals(tableAttributes[i].getName())) {
			          				
			          				rrnDecCrypt = "";
		  		          			
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
		                bm.set(TableDef.ID_PROPERTY_NAME, deptCd);
		                
		                bmResult.add(bm);
		            }
		            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);
		            
		            SmrmfUtils.endTiming(logger, millisBeginSelectBass0450ToBass0400List, "getSelectSysm0900List");
		            
		        }catch (Exception ex) {
		        	ex.printStackTrace();
		            //Return operation exception
		            throw MSFServerUtils.getOperationException(method, ex, logger);
		        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return retval;
        
    }
	

}
