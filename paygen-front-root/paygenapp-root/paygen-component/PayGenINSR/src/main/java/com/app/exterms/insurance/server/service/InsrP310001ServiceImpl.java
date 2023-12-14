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

import com.app.exterms.insurance.client.service.InsrP310001Service;
import com.app.exterms.insurance.server.service.dao.Insr4100DAO;
import com.app.exterms.insurance.server.vo.Insr4100SrhVO;
import com.app.exterms.insurance.server.vo.Insr4100VO;
import com.app.exterms.insurance.shared.InsrDaoConstants;
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
@Service("InsrP310001Service")
public class InsrP310001ServiceImpl extends AbstractCustomServiceImpl implements InsrP310001Service ,InsrDaoConstants{
	
			private static final Logger logger = LoggerFactory.getLogger(InsrP310001ServiceImpl.class);
			private static final String calledClass = InsrP310001ServiceImpl.class.getName();
			

			@Autowired
		    @Resource(name="Insr4100DAO")
		    private Insr4100DAO insr4100DAO;
			
			
			  /** ID Generation */
		    //@Resource(name="{egovPayr0400IdGnrService}")    
		    //private EgovIdGnrService egovIdGnrService;
			
			public PagingLoadResult<BaseModel> getInsrP310001ToInsr4100DataList(ServiceParameters serviceParameters) throws MSFException {

		        PagingLoadResult<BaseModel> retval = null;
		        String method =  CLASS_INSRP310001TOINSR4100_DAO_LIST;
		        Insr4100SrhVO   insr4100SrhVo = new Insr4100SrhVO();
		        Insr4100VO      insr4100Vo = new Insr4100VO();
		        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		        
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		        if  (MSFSharedUtils.paramNull(insr4100DAO)) {
		        
		        	WebApplicationContext wac = WebApplicationContextUtils.
		                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

		        	insr4100DAO = (Insr4100DAO) wac.getBean("Insr4100DAO" ); 
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
		            List<String> listDeptCd = new ArrayList<String>();
		            /** 조건절 */
		            insr4100SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
		            insr4100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
		           
		            insr4100SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
		            
		            
		            insr4100SrhVo.setUsrId(sessionUser.getUsrId());  
		            
		            /******************************** 권한 ************************************************************************/
		            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
		            if ("FALSE".equals(chkDeptCd)) {
		            	insr4100SrhVo.setDeptCd(sessionUser.getDeptCd()); 
		               listDeptCd.add(sessionUser.getDeptCd());
		               insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
		               insr4100SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
		            } else {
		            	    
		            	 insr4100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
		                     if (insr4100SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
		                     	 listDeptCd = null; 
		                     	insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
		                     	insr4100SrhVo.setDeptCd("");  //부서코드
		                     } else {
		                    	 insr4100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
		                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
		                          insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
		                     } 
		                  
		            }
		            
		            insr4100SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
		            insr4100SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
		            
		            /******************************** 권한 ************************************************************************/ 
		            
		            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
		            insr4100SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
		            insr4100SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
		           
//		            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//		            insr4100SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//		            insr4100SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
		             
		            List<String> lstDtilOccuClsDivCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
		            insr4100SrhVo.setDtilOccuClsDivCdArr(lstDtilOccuClsDivCd);  
		            insr4100SrhVo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
		            
		            insr4100SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
		            
		            insr4100SrhVo.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  //급여구분코드 
		            insr4100SrhVo.setPymtYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth"))); //지급년월
		            insr4100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
		            insr4100SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
		            
		            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
		            insr4100SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
		            insr4100SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
		            
		             
		            
		            //Get total record count //전체 데이터 갯수를 가지고 온다. 
			         if ( pagingValues.executeRecordCount ) { 
			            	
		                //Execute query that returns a single value
		                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		                int iResultCnt = insr4100DAO.selectInsrP310001ToInsr4100ListTotCnt(insr4100SrhVo);  
		               
		                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
//		                pagingValues.totalRecordCount = iResultCnt;	       
			          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
		                if (!pagingValues.pageExecute) { 
		                    pagingValues.offsetLimit = iResultCnt;       
		                }
		                
			         	pagingValues.totalRecordCount = iResultCnt;	       
		                
		                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
		            }
		        
		            TimingInfo millisBeginInsrP310001ToInsr4100DataList = SmrmfUtils.startTiming(logger);
		        
		            /**페이지 카운트 처리를 위한 부분 */ 
		            insr4100SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		            //Apply paging
		            if (pagingValues.start > 0) {
		            	insr4100SrhVo.setFirstIndex(pagingValues.start);
		            }
		            if (pagingValues.offsetLimit > 0) {
		            	insr4100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
		            }

		            //Execute query and convert to BaseModel list
		            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
		            
		            @SuppressWarnings("unchecked")
//				            Collection<Map<String, Object>> list ??????
		            List list = insr4100DAO.selectInsrP310001ToInsr4100List(insr4100SrhVo);
		            
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
		            
		            SmrmfUtils.endTiming(logger, millisBeginInsrP310001ToInsr4100DataList, "getInsrP310001ToInsr4100DataList");
		       

		        }
		        catch (Exception ex) {
		        	ex.printStackTrace();
		            //Return operation exception
		            throw MSFServerUtils.getOperationException(method, ex, logger);
		        }

		        return retval;
		    }
}
