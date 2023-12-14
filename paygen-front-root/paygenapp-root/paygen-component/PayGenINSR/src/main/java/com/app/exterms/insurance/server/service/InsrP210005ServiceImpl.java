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

import com.app.exterms.insurance.client.service.InsrP210005Service;
import com.app.exterms.insurance.server.service.dao.Insr1200DAO;
import com.app.exterms.insurance.server.vo.Insr1200SrhVO;
import com.app.exterms.insurance.server.vo.Insr1200VO;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
@Service("InsrP210005Service")
public class InsrP210005ServiceImpl extends AbstractCustomServiceImpl implements InsrP210005Service ,InsrDaoConstants{
	
		private static final Logger logger = LoggerFactory.getLogger(InsrP210005ServiceImpl.class);
		private static final String calledClass = InsrP210005ServiceImpl.class.getName();
		

		@Autowired
	    @Resource(name="Insr1200DAO")
	    private Insr1200DAO insr1200DAO;
		
		  /** ID Generation */
	    //@Resource(name="{egovPayr0400IdGnrService}")    
	    //private EgovIdGnrService egovIdGnrService;
		
		
		/**
		 * 자격취득신고내역보기
		 * @param serviceParameters
		 * @return
		 * @throws MSFException
		 */
		public PagingLoadResult<BaseModel> getInsrP210005ToInsr1200DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_INSRP210005TOINSR1200_DAO_LIST;
	        Insr1200SrhVO   insr1200SrhVO = new Insr1200SrhVO();
	        Insr1200VO      insr1200VO = new Insr1200VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(insr1200DAO)) {
	        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	insr1200DAO = (Insr1200DAO) wac.getBean("Insr1200DAO" ); 
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
	            insr1200SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드 
	            insr1200SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            
	            insr1200SrhVO.setSoctyInsurCmptnDt01(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "soctyInsurCmptnDt01"))) ;   //작성기간-시작일자
	            insr1200SrhVO.setSoctyInsurCmptnDt02(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "soctyInsurCmptnDt02"))) ;   //작성기간-종료일자
	            
	           
	            insr1200SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	             
	            insr1200SrhVO.setUsrId(sessionUser.getUsrId());  
	            
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	insr1200SrhVO.setDeptCd(sessionUser.getDeptCd()); 
	               listDeptCd.add(sessionUser.getDeptCd());
	               insr1200SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
	               insr1200SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	    
	            	 insr1200SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
	                     if (insr1200SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                     	 listDeptCd = null; 
	                     	insr1200SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	                     	insr1200SrhVO.setDeptCd("");  //부서코드
	                     } else {
	                    	 insr1200SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                          insr1200SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	                     } 
	                  
	            }
	            
	            insr1200SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            insr1200SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
	            /******************************** 권한 ************************************************************************/
	            
	           // insr1200SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            insr1200SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	            //insr1200SrhVO.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            insr1200SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	            insr1200SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
//	            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	            insr1200SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	            insr1200SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            insr1200SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            insr1200SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	            
	            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
	            insr1200SrhVO.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
	            insr1200SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
	            
	            
	            insr1200SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            insr1200SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = insr1200DAO.selectInsrP210005ToInsr1200ListTotCnt(insr1200SrhVO);  
	                 
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginInsrP210005ToInsr1200DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            insr1200SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	insr1200SrhVO.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	insr1200SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//			            Collection<Map<String, Object>> list ??????
	            List list = insr1200DAO.selectInsrP210005ToInsr1200List(insr1200SrhVO);
	            
		        Iterator<Map<String, Object>> iter = list.iterator();
		            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
	            while ( iter.hasNext() ) {
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginInsrP210005ToInsr1200DataList, "getInsrP210005ToInsr1200DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }		
		
		
		 
		
		
}
