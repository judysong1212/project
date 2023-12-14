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

import com.app.exterms.insurance.client.service.Insr3200Service;
import com.app.exterms.insurance.server.service.dao.Insr4300DAO;
import com.app.exterms.insurance.server.vo.Insr4300SrhVO;
import com.app.exterms.insurance.server.vo.Insr4300VO;
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
@Service("Insr3200Service")
public class Insr3200ServiceImpl extends AbstractCustomServiceImpl implements Insr3200Service ,InsrDaoConstants{
	
		private static final Logger logger = LoggerFactory.getLogger(Insr3200ServiceImpl.class);
		private static final String calledClass = Insr3200ServiceImpl.class.getName();
		
		
		@Autowired
	    @Resource(name="Insr4300DAO")
	    private Insr4300DAO insr4300DAO;
		
		
		  /** ID Generation */
	    //@Resource(name="{egovPayr0400IdGnrService}")    
	    //private EgovIdGnrService egovIdGnrService;
		
		public PagingLoadResult<BaseModel> getInsr3200ToInsr4300DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_INSR3200TOINSR4300_DAO_LIST;
	        Insr4300SrhVO   insr4300SrhVo = new Insr4300SrhVO();
	        Insr4300VO      insr4300Vo = new Insr4300VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        String chkAntyDeinYr = "";   //구분자에 따라 쿼리를 다르게 가져옴.
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(insr4300DAO)) {
	        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	insr4300DAO = (Insr4300DAO) wac.getBean("Insr4300DAO" ); 
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
	            insr4300SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            insr4300SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            insr4300SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd"))); //관리부서
	            insr4300SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")));       //호봉제 구분
	            insr4300SrhVo.setAntyDeinYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "antyDeinYr"))); //지급년월
	            
	           
	            insr4300SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            
	            insr4300SrhVo.setUsrId(sessionUser.getUsrId());  
	            insr4300SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            insr4300SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	insr4300SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	               listDeptCd.add(sessionUser.getDeptCd());
	               insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	               insr4300SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	    
	            	 insr4300SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
	                     if (insr4300SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                     	 listDeptCd = null; 
	                     	insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                     	insr4300SrhVo.setDeptCd("");  //부서코드
	                     } else {
	                    	 insr4300SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                          insr4300SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                     } 
	                  
	            }
	            
	            
	            /******************************** 권한 ************************************************************************/
	            
	            
	            chkAntyDeinYr = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "chkAntyDeinYr"));
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            insr4300SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	            insr4300SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
//	            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	            insr4300SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	            insr4300SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            insr4300SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            insr4300SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	            
	            insr4300SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
	             
	           
	            insr4300SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            insr4300SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	            
	            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
	            insr4300SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
	            insr4300SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
	             
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt =  0;
	                if ("01".equals(chkAntyDeinYr)) {
	                	iResultCnt = insr4300DAO.selectInsr320001ToInsr4300ListTotCnt(insr4300SrhVo);  
	                } else {
	                	iResultCnt = insr4300DAO.selectInsr320002ToInsr4300ListTotCnt(insr4300SrhVo);  
	                }
	                 
//	                if (!pagingValues.pageExecute) { 
//	                    pagingValues.offsetLimit = iResultCnt;       
//	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                
		         	pagingValues.totalRecordCount = iResultCnt;	

	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginInsr3200ToInsr4300DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            insr4300SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	insr4300SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	insr4300SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            List list = null;
	            if ("01".equals(chkAntyDeinYr)) {  
	 	           list = insr4300DAO.selectInsr320001ToInsr4300List(insr4300SrhVo);  //insr4300 table
                } else { 
     	           list = insr4300DAO.selectInsr320002ToInsr4300List(insr4300SrhVo);  //연말정산데이터를 가지고온다.
                } 
	            
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginInsr3200ToInsr4300DataList, "getInsr3200ToInsr4300DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }
}
