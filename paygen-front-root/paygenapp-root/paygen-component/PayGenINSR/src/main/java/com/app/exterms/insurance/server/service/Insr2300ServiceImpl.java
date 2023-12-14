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

import com.app.exterms.insurance.client.dto.Insr2200DTO;
import com.app.exterms.insurance.client.service.Insr2300Service;
import com.app.exterms.insurance.server.service.dao.Insr1500DAO;
import com.app.exterms.insurance.server.service.dao.Insr1600DAO;
import com.app.exterms.insurance.server.service.dao.Insr2100DAO;
import com.app.exterms.insurance.server.service.dao.Insr2200DAO;
import com.app.exterms.insurance.server.service.dao.Insr2500DAO;
import com.app.exterms.insurance.server.vo.Insr1500SrhVO;
import com.app.exterms.insurance.server.vo.Insr1500VO;
import com.app.exterms.insurance.server.vo.Insr1550SrhVO;
import com.app.exterms.insurance.server.vo.Insr1600VO;
import com.app.exterms.insurance.server.vo.Insr2100SrhVO;
import com.app.exterms.insurance.server.vo.Insr2100VO;
import com.app.exterms.insurance.server.vo.Insr2200SrhVO;
import com.app.exterms.insurance.server.vo.Insr2200VO;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.props.ExtermsProps;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

import egovframework.rte.psl.dataaccess.util.EgovMap;
 
@Service("Insr2300Service")
public class Insr2300ServiceImpl extends AbstractCustomServiceImpl implements Insr2300Service,InsrDaoConstants {
	
		private static final Logger logger = LoggerFactory.getLogger(Insr2300ServiceImpl.class);
		private static final String calledClass = Insr2300ServiceImpl.class.getName();
		
		@Autowired
	    @Resource(name="Insr2100DAO")
	    private Insr2100DAO insr2100DAO;
		
		@Autowired
	    @Resource(name="Insr2200DAO")
	    private Insr2200DAO insr2200DAO;
		
		@Autowired
	    @Resource(name="Insr1500DAO")
	    private Insr1500DAO insr1500DAO;
		
		@Autowired
	    @Resource(name="Insr1600DAO")
	    private Insr1600DAO insr1600DAO;
		
		@Autowired
	    @Resource(name="Insr2500DAO")
	    private Insr2500DAO insr2500DAO;
		
		/*@Autowired
	    @Resource(name="Insr2100DAO")
	    private Insr2100DAO insr2100DAO;*/
		
/*		@Autowired
	    @Resource(name="Insr1300DAO")
	    private Insr1300DAO insr1300DAO;*/
			
		  /** ID Generation */
	    //@Resource(name="{egovInsr2100IdGnrService}")    
	    //private EgovIdGnrService egovIdGnrService;
		
		public PagingLoadResult<BaseModel> getInsr2300ToInsr2100DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_INSR2300TOINSR2100_DAO_LIST;
	        Insr2100SrhVO   insr2100SrhVO = new Insr2100SrhVO();
	        Insr2100VO      insr2100VO = new Insr2100VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        List<String> listDeptCd = new ArrayList<String>();
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(insr2100DAO)) {
	        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	insr2100DAO = (Insr2100DAO) wac.getBean("Insr2100DAO" ); 
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
	            insr2100SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            insr2100SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            
	            
	            insr2100SrhVO.setSoctyInsurCmptnDt01(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "soctyInsurCmptnDt01"))) ;   //작성기간-시작일자
	            insr2100SrhVO.setSoctyInsurCmptnDt02(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "soctyInsurCmptnDt02"))) ;   //작성기간-종료일자
	            
	           
	            insr2100SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	             
	            insr2100SrhVO.setUsrId(sessionUser.getUsrId());  
	            insr2100SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            insr2100SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));    
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	               insr2100SrhVO.setDeptCd(sessionUser.getDeptCd()); 
	               listDeptCd.add(sessionUser.getDeptCd());
	               insr2100SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
	               insr2100SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	    
	            	 insr2100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
	                     if (insr2100SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                     	 listDeptCd = null; 
	                     	insr2100SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	                     	insr2100SrhVO.setDeptCd("");  //부서코드
	                     } else {
	                    	 insr2100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                          insr2100SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	                     } 
	                  
	            }
	             
	             
	            /******************************** 권한 ************************************************************************/
	            
	           // insr2100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            insr2100SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	            //insr2100SrhVO.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            insr2100SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	            insr2100SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
//	            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	            insr2100SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	            insr2100SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            insr2100SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            insr2100SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	            
	            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
	            insr2100SrhVO.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
	            insr2100SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
	            
	           
	            insr2100SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            insr2100SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = insr2100DAO.selectInsr2300ToInsr2100ListTotCnt(insr2100SrhVO);  
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginInsr2300ToInsr2100DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            insr2100SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	insr2100SrhVO.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	insr2100SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

//	            System.out.println("pagingValues.start : "+pagingValues.start);
//	            System.out.println("pagingValues.offsetLimit : "+pagingValues.offsetLimit);
//	            System.out.println("pagingValues.totalRecordCount : "+pagingValues.totalRecordCount);
//	            System.out.println("insr2100SrhVO.getLastIndex() : "+insr2100SrhVO.getLastIndex());
	            
	            
	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//			            Collection<Map<String, Object>> list ??????
	            List list = insr2100DAO.selectInsr2300ToInsr2100List(insr2100SrhVO);
	            
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginInsr2300ToInsr2100DataList, "getInsr2300ToInsr2100DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }
		
		/**
		 * 자격상실상세정보 
		 * @param serviceParameters
		 * @return
		 * @throws MSFException
		 */
		public PagingLoadResult<BaseModel> getInsr2300ToInsr2200DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_INSR2300TOINSR2200_DAO_LIST;
	        Insr2200SrhVO   insr2200SrhVO = new Insr2200SrhVO();
	        Insr2200VO      insr2200VO = new Insr2200VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        List<String> listDeptCd = new ArrayList<String>();
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(insr2200DAO)) {
	        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	insr2200DAO = (Insr2200DAO) wac.getBean("Insr2200DAO" ); 
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
	            insr2200SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드             
	            insr2200SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            
	           //insr2200SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키	            
	           //insr2200SrhVO.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "soctyInsurCmptnDt")));     /** set 사회보험작성일자 : soctyInsurCmptnDt */
	           //insr2200SrhVO.setSocInsrAqtnEmymtNum(new BigDecimal(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "socInsrAqtnEmymtNum"),"0")));    /** set 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	           
	            insr2200SrhVO.setSoctyInsurCmptnDt01(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "soctyInsurCmptnDt01"))) ;   //작성기간-시작일자
	            insr2200SrhVO.setSoctyInsurCmptnDt02(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "soctyInsurCmptnDt02"))) ;   //작성기간-종료일자
	            
	           
	            insr2200SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            
	            
	            insr2200SrhVO.setUsrId(sessionUser.getUsrId());  
	            insr2200SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            insr2200SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));    
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	insr2200SrhVO.setDeptCd(sessionUser.getDeptCd()); 
	               listDeptCd.add(sessionUser.getDeptCd());
	               insr2200SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
	               insr2200SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	               //insr2200SrhVO.setPayrMangeDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	    
	            	insr2200SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
	            	insr2200SrhVO.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))); 
	                     if (insr2200SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                     	 listDeptCd = null; 
	                     	insr2200SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	                     	insr2200SrhVO.setDeptCd("");  //부서코드
	                     } else {
	                    	 insr2200SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                          insr2200SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	                     } 
	                  
	            }
	             
	             
	            /******************************** 권한 ************************************************************************/
		        //insr2200SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            insr2200SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	            //insr2100SrhVO.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            insr2200SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	            insr2200SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
	            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
	            insr2200SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	            insr2200SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            insr2200SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            insr2200SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	            
	            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
	            insr2200SrhVO.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
	            insr2200SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
	            
	           
	            insr2200SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            insr2200SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	               // int iResultCnt = insr2200DAO.selectInsr2100ToInsr2200ListTotCnt(insr2200SrhVO);  
	                int iResultCnt = insr2200DAO.selectInsr2200ListTotCnt(insr2200SrhVO); 
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginInsr2100ToInsr2200DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            insr2200SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	insr2200SrhVO.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	insr2200SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }
	            
	         
	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//			            Collection<Map<String, Object>> list ??????
	            //List list = insr2200DAO.selectInsr2100ToInsr2200List(insr2200SrhVO);
	            List list = insr2200DAO.selectInsr2200List(insr2200SrhVO);
	            
	            
	            
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
	                    		//nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	                    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	                    	}
	                    	if("socnsrIssRegVal03".equals(tableAttributes[i].getName())) {
	                    		// TODO 주민번호
	                    		//nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	                    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("socnsrIssRegVal03")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginInsr2100ToInsr2200DataList, "getInsr2100ToInsr2200DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }
		
		/**
		 * 자격상실상세정보(고용이Y인것) 
		 * @param serviceParameters
		 * @return
		 * @throws MSFException
		 */
		public PagingLoadResult<BaseModel> getInsr2400ToInsr2200DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_INSR2400TOINSR2200_DAO_LIST;
	        Insr2200SrhVO   insr2200SrhVO = new Insr2200SrhVO();
	        Insr2200VO      insr2200VO = new Insr2200VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        List<String> listDeptCd = new ArrayList<String>();
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(insr2200DAO)) {
	        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	insr2200DAO = (Insr2200DAO) wac.getBean("Insr2200DAO" ); 
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
	            insr2200SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드             
	            insr2200SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            
	           //insr2200SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키	            
	           //insr2200SrhVO.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "soctyInsurCmptnDt")));     /** set 사회보험작성일자 : soctyInsurCmptnDt */
	           //insr2200SrhVO.setSocInsrAqtnEmymtNum(new BigDecimal(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "socInsrAqtnEmymtNum"),"0")));    /** set 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	           
	            insr2200SrhVO.setSoctyInsurCmptnDt01(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "soctyInsurCmptnDt01"))) ;   //작성기간-시작일자
	            insr2200SrhVO.setSoctyInsurCmptnDt02(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "soctyInsurCmptnDt02"))) ;   //작성기간-종료일자
	            
	           
	            insr2200SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            
	            
	            insr2200SrhVO.setUsrId(sessionUser.getUsrId());  
	            insr2200SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            insr2200SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));    
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	insr2200SrhVO.setDeptCd(sessionUser.getDeptCd()); 
	               listDeptCd.add(sessionUser.getDeptCd());
	               insr2200SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
	               insr2200SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	               //insr2200SrhVO.setPayrMangeDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	    
	            	insr2200SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
	            	insr2200SrhVO.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))); 
	                     if (insr2200SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                     	 listDeptCd = null; 
	                     	insr2200SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	                     	insr2200SrhVO.setDeptCd("");  //부서코드
	                     } else {
	                    	 insr2200SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                          insr2200SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	                     } 
	                  
	            }
	             
	             
	            /******************************** 권한 ************************************************************************/
		        //insr2200SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            insr2200SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	            //insr2100SrhVO.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            insr2200SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	            insr2200SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
	            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
	            insr2200SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	            insr2200SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            insr2200SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            insr2200SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	            
	            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
	            insr2200SrhVO.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
	            insr2200SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
	            
	           
	            insr2200SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            insr2200SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	               // int iResultCnt = insr2200DAO.selectInsr2100ToInsr2200ListTotCnt(insr2200SrhVO);  
	                int iResultCnt = insr2200DAO.selectInsr2200ToInsr2400ListTotCnt(insr2200SrhVO); 
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginInsr2100ToInsr2200DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            insr2200SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	insr2200SrhVO.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	insr2200SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }
	            
	         
	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//			            Collection<Map<String, Object>> list ??????
	            //List list = insr2200DAO.selectInsr2100ToInsr2200List(insr2200SrhVO);
	            List list = insr2200DAO.selectInsr2200ToInsr2400List(insr2200SrhVO);
	            
	            
	            
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
	                		//nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	                		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	                	}
	                	if("socnsrIssRegVal03".equals(tableAttributes[i].getName())) {
	                		// TODO 주민번호
	                		//nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	                		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("socnsrIssRegVal03")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginInsr2100ToInsr2200DataList, "getInsr2100ToInsr2200DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }
		
		
		  @Override
		  public Insr2200DTO activityOnReadInsr2200(Insr2200DTO insr2200Dto) throws MSFException {
			  
				String windowNm = "사회보험자격상실신고";
				String windowId = "INSR2300";
	     
		  		Insr2200DTO reltInsr2200 = new Insr2200DTO();
			    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());  
				String method = calledClass + ".activityOnReadInsr2200";
	           
	           try { 
	           
	              
	        	   Insr2200VO  insr2200Vo = new Insr2200VO();
	        	   Insr2200VO  tpInsr2200Vo = new Insr2200VO();
	        	   
	        	   tpInsr2200Vo.setDpobCd(insr2200Dto.getDpobCd());
	        	   tpInsr2200Vo.setSystemkey(insr2200Dto.getSystemkey());
	        	   tpInsr2200Vo.setSoctyInsurCmptnDt(insr2200Dto.getSoctyInsurCmptnDt());
	        	   tpInsr2200Vo.setSocInsrLssEmymtNum(insr2200Dto.getSocInsrLssEmymtNum());
	        	   
	        	   insr2200Vo = insr2200DAO.selectInsr2200(tpInsr2200Vo);
	        	   
                   if (MSFSharedUtils.paramNotNull(insr2200Vo) && MSFSharedUtils.paramNotNull(insr2200Vo.getSystemkey())) {
//
						reltInsr2200.setDpobCd(insr2200Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
						reltInsr2200.setSystemkey(insr2200Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
						reltInsr2200.setSoctyInsurCmptnDt(insr2200Vo.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
						reltInsr2200.setSocInsrLssEmymtNum(insr2200Vo.getSocInsrLssEmymtNum().longValue());    /** column 사회보험상실_고용_일련번호 : socInsrAqtnEmymtNum */
//						
						//공단구분 4대보험 구분자로 분리 .
						reltInsr2200.setSocnsrIssRegVal01(insr2200Vo.getSocnsrIssRegVal01());    /** column 공단구분 : socnsrAqtnRegVal01 */
						
						reltInsr2200.setHlthInsrRegrstYn(MSFSharedUtils.convertStringToBoolean(insr2200Vo.getSocnsrIssRegVal01().substring(0, 1)));    /** column 건강보험신고여부 : hlthInsrRegrstYn */
						reltInsr2200.setNatPennRegrstYn(MSFSharedUtils.convertStringToBoolean(insr2200Vo.getSocnsrIssRegVal01().substring(1, 2)));    /** column 국민연금신고여부 : natPennRegrstYn */
						reltInsr2200.setUmytInsrRegrstYn(MSFSharedUtils.convertStringToBoolean(insr2200Vo.getSocnsrIssRegVal01().substring(2, 3)));    /** column 고용보험신고여부 : umytInsrRegrstYn */
						reltInsr2200.setIdtlAccdtRegrstYn(MSFSharedUtils.convertStringToBoolean(insr2200Vo.getSocnsrIssRegVal01().substring(3, 4)));    /** column 산재보험신고여부 : idtlAccdtRegrstYn */
                	   
						reltInsr2200.setSocnsrIssRegVal02(insr2200Vo.getSocnsrIssRegVal02());    /** column 성명 : socnsrAqtnRegVal02 */
						reltInsr2200.setSocnsrIssRegVal03(insr2200Vo.getSocnsrIssRegVal03());    /** column 주민등록번호 : socnsrAqtnRegVal03 */
						reltInsr2200.setSocnsrIssRegVal04(insr2200Vo.getSocnsrIssRegVal04());    /** column 전화번호 : socnsrAqtnRegVal04 */
						reltInsr2200.setSocnsrIssRegVal05(insr2200Vo.getSocnsrIssRegVal05());    /** column 연금 상실일 : socnsrAqtnRegVal05 */
						reltInsr2200.setSocnsrIssRegVal06(insr2200Vo.getSocnsrIssRegVal06());    /** column 연금 상실부호 : socnsrAqtnRegVal06 */
						reltInsr2200.setSocnsrIssRegVal07(MSFSharedUtils.convertValToBoolean(insr2200Vo.getSocnsrIssRegVal07()));    /** column 연금_초일취득,당월상실자 납부여부 : socnsrAqtnRegVal07 */
						reltInsr2200.setSocnsrIssRegVal08(insr2200Vo.getSocnsrIssRegVal08());    /** column 건강 상실일 : socnsrAqtnRegVal08 */
						reltInsr2200.setSocnsrIssRegVal09(insr2200Vo.getSocnsrIssRegVal09());    /** column 건강_상실부호 : socnsrAqtnRegVal09 */
						reltInsr2200.setSocnsrIssRegVal10(Long.parseLong(insr2200Vo.getSocnsrIssRegVal10()));    /** column 건강_퇴직전3개월평균보수 : socnsrAqtnRegVal10 */
						reltInsr2200.setSocnsrIssRegVal11(Long.parseLong(insr2200Vo.getSocnsrIssRegVal11()));    /** column 건강_당해년도 보수총액 : socnsrAqtnRegVal11 */
						reltInsr2200.setSocnsrIssRegVal12(Long.parseLong(insr2200Vo.getSocnsrIssRegVal12()));    /** column 건강_당해연도 산정월수 : socnsrAqtnRegVal12 */
						reltInsr2200.setSocnsrIssRegVal13(insr2200Vo.getSocnsrIssRegVal13());    /** column 건강_전녀도 정산구분 : socnsrAqtnRegVal13 */
						reltInsr2200.setSocnsrIssRegVal14(Long.parseLong(insr2200Vo.getSocnsrIssRegVal14()));    /** column 건강_전년도 보수총액 : socnsrAqtnRegVal14 */
						reltInsr2200.setSocnsrIssRegVal15(Long.parseLong(insr2200Vo.getSocnsrIssRegVal15()));    /** column 건강_전년도 산정월수 : socnsrAqtnRegVal15 */
						reltInsr2200.setSocnsrIssRegVal16(insr2200Vo.getSocnsrIssRegVal16());    /** column 고용_상실사유 : socnsrAqtnRegVal16 */
						reltInsr2200.setSocnsrIssRegVal17(insr2200Vo.getSocnsrIssRegVal17());    /** column 고용_구체적 상실사유 : socnsrAqtnRegVal17 */
						reltInsr2200.setSocnsrIssRegVal18(insr2200Vo.getSocnsrIssRegVal18());    /** column 공용_상실일 : socnsrAqtnRegVal18 */
						reltInsr2200.setSocnsrIssRegVal19(Long.parseLong(insr2200Vo.getSocnsrIssRegVal19()));    /** column 고용_당해년도 보수총액 : socnsrAqtnRegVal19 */
						reltInsr2200.setSocnsrIssRegVal20(insr2200Vo.getSocnsrIssRegVal20());    /** column 산재_상실사유 : socnsrAqtnRegVal20 */
						reltInsr2200.setSocnsrIssRegVal21(insr2200Vo.getSocnsrIssRegVal21());    /** column 산재_구체적 상실사유 : socnsrAqtnRegVal21 */
						reltInsr2200.setSocnsrIssRegVal22(insr2200Vo.getSocnsrIssRegVal22());    /** column 산재_상실일 : socnsrAqtnRegVal22 */
						reltInsr2200.setSocnsrIssRegVal23(Long.parseLong(insr2200Vo.getSocnsrIssRegVal23()));    /** column 산재_당해년도 보수총액 : socnsrAqtnRegVal23 */
						
						reltInsr2200.setHanNm(insr2200Vo.getHanNm());
						reltInsr2200.setResnRegnNum(insr2200Vo.getResnRegnNum());
						reltInsr2200.setEmymtDivNm(insr2200Vo.getEmymtDivNm());
						reltInsr2200.setDeptNm(insr2200Vo.getDeptNm());
						reltInsr2200.setTypOccuNm(insr2200Vo.getTypOccuNm());
		
                  } else {
                	   MSFErrorMessage errMsg = new MSFErrorMessage("4대보험취득신고", "", 5, "데이타가 존재하지 않습니다."); 
                       throw MSFServerUtils.getValidationException("activityOnReadInsr2200", errMsg, logger) ; 
                  }
	            
	           }  catch (Exception ex) {
	                
	               ex.printStackTrace();
	               
	               /** 에러 로그 **/			
	               MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
	               
	               throw MSFServerUtils.getOperationException("activityOnReadInsr2200", ex, logger);
	               
	           }finally {
	             
	           }
	
   			/** 로그반영
   			 * CRUDSBLO
   			 * C:create		R:read		U:update
   	    	 * D:delete		S:select	B:배치 
   	    	 * L:로그인		O:로그아웃
   	    	 */
   			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");	           
	           
	           return reltInsr2200;
		  }
		  
		    /**
		     * 삭제처리 로직  TODO  차후 멀티건에 대한 삭제 기능 추가 
		     */
			@Override
			 public Long activityOnDeleteInsr2300(List<BaseModel> list) throws MSFException { 
				
				    Long result = new Long(0); 
				  
			       // MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			        
			        try {  
			            
			        if  (MSFSharedUtils.paramNull(insr2100DAO)) {
			       	        
			   	        	WebApplicationContext wac = WebApplicationContextUtils.
			   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

			   	        	insr2100DAO = (Insr2100DAO) wac.getBean("Insr2100DAO" ); 
			   	        }
			        	
					if  (MSFSharedUtils.paramNull(insr2200DAO)) {
							       	        
			   	        	WebApplicationContext wac = WebApplicationContextUtils.
			   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

			   	        	insr2200DAO = (Insr2200DAO) wac.getBean("Insr2200DAO" ); 
			   	        }
					
					
					if  (MSFSharedUtils.paramNull(insr1600DAO)) {
							       	        
			   	        	WebApplicationContext wac = WebApplicationContextUtils.
			   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

			   	        	insr1600DAO = (Insr1600DAO) wac.getBean("Insr1600DAO" ); 
			   	        }
					
					 Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)list.iterator();
					 
	                    while (iterRecords.hasNext()) {
	                              BaseModel bmMapModel = (BaseModel) iterRecords.next();
	                              
	                              Insr2100VO  insr2100Vo = new Insr2100VO();
	                              Insr2200VO  insr2200Vo = new Insr2200VO();
	                              Insr1600VO  insr1600Vo = new Insr1600VO();
	                              
	                              insr2200Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	                              insr2200Vo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
	                              insr2200Vo.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls(bmMapModel.get("soctyInsurCmptnDt")));    /** column SYSTEMKEY : systemkey */
	                              insr2200Vo.setSocInsrLssEmymtNum((Long)bmMapModel.get("socInsrLssEmymtNum"));
	                              
	                              insr2100Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	                              insr2100Vo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
	                              insr2100Vo.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls(bmMapModel.get("soctyInsurCmptnDt")));    /** column SYSTEMKEY : systemkey */
	                              insr2100Vo.setSocInsrLssEmymtNum((Long)bmMapModel.get("socInsrLssEmymtNum"));
	                              
	                              insr2200DAO.deleteInsr2200(insr2200Vo);
	                              insr2100DAO.deleteInsr2100(insr2100Vo);
	                              
	                              //피부양자 취득상실신고 작성일자가 같으면 삭제한다....
	                              insr1600Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));
	                              insr1600Vo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
	                              insr1600Vo.setFamyAqtnLssNum((Long)bmMapModel.get("socInsrLssEmymtNum"));
	                              insr1600Vo.setFamyQuftDivCd("I0100002");
	                              insr1600Vo.setFamyAqtnLssDt(MSFSharedUtils.allowNulls(bmMapModel.get("soctyInsurCmptnDt")));
	                              
	                              insr1600DAO.deleteInsr1600(insr1600Vo);
	                              
	                    }
			            
			          result = 1L;
			          
			        }
			        catch (Exception ex) {
			            logger.error("EXCEPTION calling activityOnDeleteInsr2100(): "+ex); 
			            
			            result = new Long(0);
			            throw MSFServerUtils.getOperationException("activityOnDeleteInsr2200", ex, logger);
			        }
			        finally {
			          
			        }
			        
			        return result;
			} 
			
			@Override
			 public Long activityOnUpdateInsr2300(Insr2200DTO insr2200Dto) throws MSFException {
				    Long result = new Long(0);
			       
			        
			        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			        
			        try {  
			            
			        
	                if  (MSFSharedUtils.paramNull(insr2100DAO)) {
			       	        
			   	        	WebApplicationContext wac = WebApplicationContextUtils.
			   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

			   	        	insr2100DAO = (Insr2100DAO) wac.getBean("Insr2100DAO" ); 
			   	        }
			        	
					if  (MSFSharedUtils.paramNull(insr2200DAO)) {
							       	        
			   	        	WebApplicationContext wac = WebApplicationContextUtils.
			   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

			   	        	insr2200DAO = (Insr2200DAO) wac.getBean("Insr2200DAO" ); 
			   	        }
					 
					  Insr2100VO  insr2100Vo = new Insr2100VO();
					  Insr2200VO  insr2200Vo = new Insr2200VO();
					 // Insr1300VO  insr1300Vo = new Insr1300VO();
					
					  insr2100Vo.setDpobCd(insr2200Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
					  insr2100Vo.setSystemkey(insr2200Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
					  insr2100Vo.setSoctyInsurCmptnDt(insr2200Dto.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
					  insr2100Vo.setSocInsrLssEmymtNum(insr2200Dto.getSocInsrLssEmymtNum().longValue());    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
					  
				
					  insr2100Vo.setIsmt(sessionUser.getUsrId());    /** column 입력주소 : inptAddr */ 
					  insr2100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
					   
					 
					  insr2100Vo.setHlthInsrRegrstYn(MSFSharedUtils.convertBooleanToVal(insr2200Dto.getHlthInsrRegrstYn()));    /** column 건강보험신고여부 : hlthInsrRegrstYn */
					  insr2100Vo.setNatPennRegrstYn(MSFSharedUtils.convertBooleanToVal(insr2200Dto.getNatPennRegrstYn()));    /** column 국민연금신고여부 : natPennRegrstYn */
					  insr2100Vo.setUmytInsrRegrstYn(MSFSharedUtils.convertBooleanToVal(insr2200Dto.getUmytInsrRegrstYn()));   /** column 고용보험신고여부 : umytInsrRegrstYn */
					  insr2100Vo.setIdtlAccdtRegrstYn(MSFSharedUtils.convertBooleanToVal(insr2200Dto.getIdtlAccdtRegrstYn()));  /** column 산재보험신고여부 : idtlAccdtRegrstYn */
					  insr2100Vo.setSocInsrMbrPhnNum(insr2200Dto.getSocnsrIssRegVal04());
					  insr2100Vo.setSoctyInsurLssDt(insr2200Dto.getSocnsrIssRegVal08());/*사회보험상실일자*/       

	                  
					  insr2200Vo.setDpobCd(insr2200Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
					  insr2200Vo.setSystemkey(insr2200Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
					  insr2200Vo.setSoctyInsurCmptnDt(insr2200Dto.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
					  insr2200Vo.setSocInsrLssEmymtNum(insr2200Dto.getSocInsrLssEmymtNum().longValue());    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
					/*  
					  String  socnsrIssRegVal01 = "";
					  if(insr2200Dto.getNatPennRegrstYn())? "Y" : "N";	 
					  socnsrIssRegVal01 = 
							              .concat(MSFSharedUtils.convertStringToBoolean(insr2200Dto.getHlthInsrRegrstYn())
							            		  .concat(MSFSharedUtils.convertStringToBoolean(insr2200Dto.getUmytInsrRegrstYn())
							            				  .concat(MSFSharedUtils.convertStringToBoolean(insr2200Dto.getIdtlAccdtRegrstYn()))));
							  */
					  insr2200Vo.setSocnsrIssRegVal01(insr2200Dto.getSocnsrIssRegVal01());                                                                    
					  insr2200Vo.setSocnsrIssRegVal02(insr2200Dto.getSocnsrIssRegVal02());   /** column 성명 : socnsrAqtnRegVal02 */                                                                                   
					  insr2200Vo.setSocnsrIssRegVal03(insr2200Dto.getSocnsrIssRegVal03());   /** column 주민등록번호 : socnsrAqtnRegVal03 */                                                                               
					  insr2200Vo.setSocnsrIssRegVal04(insr2200Dto.getSocnsrIssRegVal04());   /** column 전화번호 : socnsrAqtnRegVal04 */                                                                                   
					  insr2200Vo.setSocnsrIssRegVal05(insr2200Dto.getSocnsrIssRegVal05());   /** column 상실일 : socnsrAqtnRegVal05 */           
					  
					  insr2200Vo.setSocnsrIssRegVal06(insr2200Dto.getSocnsrIssRegVal06());   /** column 대표자여부 : socnsrAqtnRegVal06 */                                                                                
					  insr2200Vo.setSocnsrIssRegVal07(MSFSharedUtils.convertBooleanToVal(insr2200Dto.getSocnsrIssRegVal07()));   /** column 연금_소득월액 : socnsrAqtnRegVal07 */                                                                              
					  insr2200Vo.setSocnsrIssRegVal08(insr2200Dto.getSocnsrIssRegVal08());   /*사회보험상실일자*/                                                                              
					  insr2200Vo.setSocnsrIssRegVal09(insr2200Dto.getSocnsrIssRegVal09());                                             
					  insr2200Vo.setSocnsrIssRegVal10(String.valueOf(insr2200Dto.getSocnsrIssRegVal10()));                                                                               
					  insr2200Vo.setSocnsrIssRegVal11(String.valueOf(insr2200Dto.getSocnsrIssRegVal11()));                                                                                
					  insr2200Vo.setSocnsrIssRegVal12(String.valueOf(insr2200Dto.getSocnsrIssRegVal12()));                                                                           
					  insr2200Vo.setSocnsrIssRegVal13(insr2200Dto.getSocnsrIssRegVal13());                                                                             
					  insr2200Vo.setSocnsrIssRegVal14(String.valueOf(insr2200Dto.getSocnsrIssRegVal14()));                                                                             
					  insr2200Vo.setSocnsrIssRegVal15(String.valueOf(insr2200Dto.getSocnsrIssRegVal15()));                                                                            
					  insr2200Vo.setSocnsrIssRegVal16(insr2200Dto.getSocnsrIssRegVal16());                                                                               
					  insr2200Vo.setSocnsrIssRegVal17(insr2200Dto.getSocnsrIssRegVal17());                                                                             
					  insr2200Vo.setSocnsrIssRegVal18(insr2200Dto.getSocnsrIssRegVal18());                                                                              
					  insr2200Vo.setSocnsrIssRegVal19(String.valueOf(insr2200Dto.getSocnsrIssRegVal19()));                                                                         
					  insr2200Vo.setSocnsrIssRegVal20(insr2200Dto.getSocnsrIssRegVal20());                                                                              
					  insr2200Vo.setSocnsrIssRegVal21(insr2200Dto.getSocnsrIssRegVal21());     
					  
					  insr2200Vo.setSocnsrIssRegVal22(insr2200Dto.getSocnsrIssRegVal22());                                                                            
					  insr2200Vo.setSocnsrIssRegVal23(String.valueOf(insr2200Dto.getSocnsrIssRegVal23()));                                                                                  
					      
				  
					  insr2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : inptAddr */ 
					  insr2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
					   
	                  
//					  insr1300Vo.setDpobCd(insr2200Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
//					  insr1300Vo.setSystemkey(insr2200Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
//					  insr1300Vo.setSoctyInsurCmptnDt(insr2200Dto.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
//					  insr1300Vo.setSocInsrAqtnEmymtNum(new BigDecimal(insr2200Dto.getSocInsrAqtnEmymtNum()));    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
//					  
//					  insr1300Vo.setNatPennIncmMnthAmnt(new BigDecimal(String.valueOf(insr2200Dto.getSocnsrIssRegVal15())));    /** column 국민연금소득월액 : natPennIncmMnthAmnt */
//					  insr1300Vo.setHlthInsrMnthRuntnAmnt(new BigDecimal(String.valueOf(insr2200Dto.getSocnsrIssRegVal15())));    /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
//					  insr1300Vo.setUmytInsrPayMnthAmnt(new BigDecimal(String.valueOf(insr2200Dto.getSocnsrIssRegVal27())));    /** column 고용보험보수월액 : umytInsrPayMnthAmnt */
//					  insr1300Vo.setIdtlAccdtPayMnthAmnt(new BigDecimal(String.valueOf(insr2200Dto.getSocnsrIssRegVal27())));    /** column 산재보험보수월액 : idtlAccdtPayMnthAmnt */
//					  
//					  insr1300Vo.setIsmt(sessionUser.getUsrId());    /** column 입력주소 : inptAddr */ 
//					  insr1300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
//					   
//	                  
//					  insr1300DAO.updateInsr1300(insr1300Vo);	
					  
					  
					  
					  insr2200DAO.updateInsr2200(insr2200Vo);
					  insr2100DAO.updateInsr2100LssDt(insr2100Vo);
					  
			          result = 1L; 
			          
			        }
			        catch (Exception ex) {
			            logger.error("EXCEPTION calling activityOnUpdateInsr2300(): "+ex); 
			            
			            result = new Long(0);
			            throw MSFServerUtils.getOperationException("activityOnUpdateInsr2300", ex, logger);
			        }
			        finally {
			          
			        }
			        
			        return result;
			}
			
			
			@Override
			 public Long activityOnUpdateInsr2300(List<Insr2200DTO> insr2200Arr) throws MSFException {
				    Long result = new Long(0);
			        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			        
			        try {  
			            
			        
	                if  (MSFSharedUtils.paramNull(insr2100DAO)) {
			       	        
			   	        	WebApplicationContext wac = WebApplicationContextUtils.
			   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

			   	        	insr2100DAO = (Insr2100DAO) wac.getBean("Insr2100DAO" ); 
			   	        }
			        	
					if  (MSFSharedUtils.paramNull(insr2200DAO)) {
							       	        
			   	        	WebApplicationContext wac = WebApplicationContextUtils.
			   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

			   	        	insr2200DAO = (Insr2200DAO) wac.getBean("Insr2200DAO" ); 
			   	        }
					for(int i=0; i<insr2200Arr.size(); i++){ 
						Insr2200DTO insr2200Dto = (Insr2200DTO)insr2200Arr.get(i);
						Insr2200VO  insr2200Vo = new Insr2200VO();
						  insr2200Vo.setDpobCd(insr2200Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
						  insr2200Vo.setSystemkey(insr2200Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
						  insr2200Vo.setSoctyInsurCmptnDt(insr2200Dto.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
						  insr2200Vo.setSocInsrLssEmymtNum(insr2200Dto.getSocInsrLssEmymtNum().longValue());    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */ 
						  insr2200Vo.setSocnsrIssRegVal05(insr2200Dto.getSocnsrIssRegVal05());   /** column 상실일 : socnsrAqtnRegVal05 */           
						  insr2200Vo.setSocnsrIssRegVal06(insr2200Dto.getSocnsrIssRegVal06());   /** column 대표자여부 : socnsrAqtnRegVal06 */                                                                                				                                                                                
						  insr2200Vo.setSocnsrIssRegVal08(insr2200Dto.getSocnsrIssRegVal08());   /** column 연금_취득월납부여부 : socnsrAqtnRegVal08 */                                                                           
						  insr2200Vo.setSocnsrIssRegVal09(insr2200Dto.getSocnsrIssRegVal09());   /** column 연금_취득부호 : socnsrAqtnRegVal09 */  
						  insr2200Vo.setSocnsrIssRegVal10(MSFSharedUtils.allowNulls(insr2200Dto.getSocnsrIssRegVal10()));   /** column 연금_자격취득일 : socnsrAqtnRegVal10 */                                                                             
						  insr2200Vo.setSocnsrIssRegVal16(insr2200Dto.getSocnsrIssRegVal16());   /** column 건강_취득부호 : socnsrAqtnRegVal16 */                                                                              
						  insr2200Vo.setSocnsrIssRegVal17(insr2200Dto.getSocnsrIssRegVal17());   /** column 건강_자격취득일 : socnsrAqtnRegVal17 */                                                                             
						  insr2200Vo.setSocnsrIssRegVal18(insr2200Dto.getSocnsrIssRegVal18());   /** column 건강_감면 : socnsrAqtnRegVal18 */                                                                                						                                                                      
						  insr2200Vo.setSocnsrIssRegVal20(insr2200Dto.getSocnsrIssRegVal20());   /** column 건강_회계 : socnsrAqtnRegVal20 */                                                                                
						  insr2200Vo.setSocnsrIssRegVal21(insr2200Dto.getSocnsrIssRegVal21());   /** column 건강_직종 : socnsrAqtnRegVal21 */     						  
						  insr2200Vo.setSocnsrIssRegVal22(insr2200Dto.getSocnsrIssRegVal22());   /** column 고용_자격취득일 : socnsrAqtnRegVal22 */          
						  insr2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : inptAddr */ 
						  insr2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */			  
						  insr2200DAO.updateInsr2200Bnde(insr2200Vo);
					}		  
			          result = 1L;    
			        }
			        catch (Exception ex) {
			            logger.error("EXCEPTION calling activityOnUpdateInsr2300(): "+ex); 
			            
			            result = new Long(0);
			            throw MSFServerUtils.getOperationException("activityOnUpdateInsr2300", ex, logger);
			        }
			        finally {
			          
			        }
			        
			        return result;
			}
			
			//인쇄시 insr2100 업데이트
			@Override
			 public Long activityOnUpdateInsr2100(BaseModel bm) throws MSFException {
				    Long result = new Long(0);
			        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			        List<String> listDeptCd = new ArrayList<String>();
			        
			        Insr2200SrhVO insr2200SrhVo = new Insr2200SrhVO();

			        insr2200SrhVo.setUsrId(sessionUser.getUsrId());  
			        insr2200SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
			        insr2200SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
					insr2200SrhVo.setSoctyInsurCmptnDt01(MSFSharedUtils.allowNulls(bm.get("soctyInsurCmptnDt01")));
					insr2200SrhVo.setSoctyInsurCmptnDt02(MSFSharedUtils.allowNulls(bm.get("soctyInsurCmptnDt02")));
					insr2200SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(bm.get("hdofcCodtnCd")));
					
					List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(bm.get("hdofcCodtnCd"))); 
					insr2200SrhVo.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태
					insr2200SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(bm.get("emymtDivCd")));	         //고용구분
			        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(bm.get("typeOccuCd"))); 
			        insr2200SrhVo.setTypOccuCdArr(lstTypeOccuCd); //직종       
			     	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(bm.get("dtilOccuInttnCd"))); 
			     	insr2200SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세
			     	insr2200SrhVo.setBusinCd(MSFSharedUtils.allowNulls(bm.get("businCd")));   //사업
			        
			        insr2200SrhVo.setHanNm(MSFSharedUtils.allowNulls(bm.get("hanNm")));			//성명
			        insr2200SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(bm.get("resnRegnNum")));//주민번호

			        insr2200SrhVo.setSystemkey(MSFSharedUtils.allowNulls(bm.get("systemkey")));	//시스템키
			        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(bm.get("systemkey"))); 
			        insr2200SrhVo.setSystemKeyArr(systemKeyArr);
			        insr2200SrhVo.setDeptCd(MSFSharedUtils.allowNulls(bm.get("deptCd")));

			        insr2200SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bm.get("payrMangDeptCd")));
			        
			        insr2200SrhVo.setDeptCdAuth(insr2200SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
			        insr2200SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr2200SrhVo.getDtilOccuInttnCd()).replace(",", ""));
			        /******************************** 권한 ************************************************************************/
			        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
			        if ("FALSE".equals(chkDeptCd)) {
			        	insr2200SrhVo.setDeptCd(sessionUser.getDeptCd()); 
			           listDeptCd.add(sessionUser.getDeptCd());
			           insr2200SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
			           insr2200SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
			        } else {
			        	    
			        	insr2200SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(insr2200SrhVo.getPayrMangDeptCd()));    
			        	insr2200SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr2200SrhVo.getPayrMangDeptCd())); 
			                 if (insr2200SrhVo.getPayrMangDeptCd().equals(insr2200SrhVo.getDeptCd())) { 
			                 	 listDeptCd = null; 
			                 	insr2200SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
			                 	insr2200SrhVo.setDeptCd("");  //부서코드
			                 } else {
			                	 insr2200SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr2200SrhVo.getDeptCd()));
			                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr2200SrhVo.getDeptCd()));  
			                      insr2200SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
			                 } 
			              
			        }
			       
			        
			       /******************************** 권한 ************************************************************************/
			        
			        try {  
			        
	                if  (MSFSharedUtils.paramNull(insr2100DAO)) {
			   	        	WebApplicationContext wac = WebApplicationContextUtils.
			   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			   	        	insr2100DAO = (Insr2100DAO) wac.getBean("Insr2100DAO" ); 
			   	        }
					if  (MSFSharedUtils.paramNull(insr2200DAO)) {
			   	        	WebApplicationContext wac = WebApplicationContextUtils.
			   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			   	        	insr2200DAO = (Insr2200DAO) wac.getBean("Insr2200DAO" ); 
			   	        }
					
			    	if  (MSFSharedUtils.paramNull(insr1600DAO)) {
			    		WebApplicationContext wac = WebApplicationContextUtils.
			    				getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			    			insr1600DAO = (Insr1600DAO) wac.getBean("Insr1600DAO" ); 
			    		}
				
					
					 List listInsr2200 = insr2200DAO.selectXlsInsr2200List(insr2200SrhVo);

				        for(int i=0; i<listInsr2200.size(); i++){
				        	EgovMap eMap = (EgovMap)listInsr2200.get(i);
				        	Insr2100VO insr2100Vo = new  Insr2100VO();
				        	insr2100Vo.setDpobCd((String)eMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
				        	insr2100Vo.setSystemkey(MSFSharedUtils.allowNulls(eMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
				        	insr2100Vo.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls( eMap.get("soctyInsurCmptnDt")));
				        	BigDecimal bigDecimal =  (BigDecimal) eMap.get("socInsrLssEmymtNum");	
				        	insr2100Vo.setSocInsrLssEmymtNum(bigDecimal.longValue());    /** column 사회보험상실_고용_일련번호 : socInsrAqtnEmymtNum */
				        	insr2100Vo.setSocInsrMbrPhnNum((String) eMap.get("socnsrIssRegVal04")); /*사회보험가입자전화번호*/     	
				        	insr2100Vo.setSoctyInsurLssDt(MSFSharedUtils.allowNulls(eMap.get("socnsrIssRegVal08")));	/*사회보험상실일자*/       
				        	insr2100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
				        	insr2100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */		
			        		insr2100Vo.setNatPennRegrstYn((String) eMap.get("natPennRegrstYn"));    /** column 국민연금신고여부 : natPennRegrstYn */
			            	insr2100Vo.setHlthInsrRegrstYn((String) eMap.get("hlthInsrRegrstYn"));    /** column 건강보험신고여부 : hlthInsrRegrstYn */
			            	insr2100Vo.setUmytInsrRegrstYn((String) eMap.get("umytInsrRegrstYn"));    /** column 고용보험신고여부 : umytInsrRegrstYn */
			            	insr2100Vo.setIdtlAccdtRegrstYn((String) eMap.get("idtlAccdtRegrstYn"));    /** column 산재보험신고여부 : idtlAccdtRegrstYn */
			            	insr2100DAO.updateInsr2100(insr2100Vo);
			            	 //피부양자 업데이트
					        Insr1600VO insr1600Vo = new Insr1600VO();
					        insr1600Vo.setDpobCd((String)eMap.get("dpobCd"));
					        insr1600Vo.setSystemkey(MSFSharedUtils.allowNulls(eMap.get("systemkey")));
					        insr1600Vo.setFamyAqtnLssNum(bigDecimal.longValue());    /** column 피부양자취득상실_고용일련번호 : famyAqtnLssNum */
					        insr1600Vo.setFamyQuftDivCd("I0100002");
					        insr1600Vo.setSocrLssFamyYn("Y");
					        insr1600Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
					        insr1600Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
					        
					        if(0 < insr1600DAO.selectInsr1600Check(insr1600Vo)){
					        	insr1600DAO.updateInsr1600(insr1600Vo);
					        }
				        }
			          result = 1L;    
			        }
			        catch (Exception ex) {
			        	logger.error("EXCEPTION calling updateXlsInsr2100(): "+ex); 
		         		result = new Long(0);
		         		throw MSFServerUtils.getOperationException("updateXlsInsr2100", ex, logger);
			        }
			        finally {
			          
			        }
			        
			        return result;
			}
			
			@Override
			 public Long activityOnInsertInsr2300(List<BaseModel> mapModels) throws MSFException {
				    Long result = new Long(0);
				    Long iCnt = new Long(0);

				    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

				    try {  
				    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

				    	if  (MSFSharedUtils.paramNull(insr2100DAO)) {
				    		WebApplicationContext wac = WebApplicationContextUtils.
				    				getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				    		insr2100DAO = (Insr2100DAO) wac.getBean("Insr2100DAO" ); 
				    	}

				    	if  (MSFSharedUtils.paramNull(insr2200DAO)) {
				    		WebApplicationContext wac = WebApplicationContextUtils.
				    				getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				    		insr2200DAO = (Insr2200DAO) wac.getBean("Insr2200DAO" ); 
				    	}
				    	if  (MSFSharedUtils.paramNull(insr1500DAO)) {
				    		WebApplicationContext wac = WebApplicationContextUtils.
				    				getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				    		insr1500DAO = (Insr1500DAO) wac.getBean("Insr1500DAO" ); 
				    	}
				    	if  (MSFSharedUtils.paramNull(insr1600DAO)) {
				    		WebApplicationContext wac = WebApplicationContextUtils.
				    				getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				    		insr1600DAO = (Insr1600DAO) wac.getBean("Insr1600DAO" ); 
				    	}
			            
					 Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
					 
					 boolean flag = false;
					 
                    while (iterRecords.hasNext()) {
                    	
                    		  flag = false;
                    	
                              BaseModel bmMapModel = (BaseModel) iterRecords.next(); 
                              Insr2100SrhVO insr2100SrhVo = new Insr2100SrhVO();
							  Insr2100VO  insr2100Vo = new Insr2100VO();
							  Insr2200VO  insr2200Vo = new Insr2200VO();
							 				

							  Insr1500SrhVO insr1500SrhVo = new Insr1500SrhVO();
							  Insr1500VO insr1500Vo = new Insr1500VO();
							  
							  
							  
							  insr2100SrhVo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
							  insr2100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
							  insr2100SrhVo.setRetryDt(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));
							  
							  insr2100Vo.setDpobCd(insr2100SrhVo.getDpobCd());
							  insr2100Vo.setSystemkey(insr2100SrhVo.getSystemkey());
						
							  logger.info("======================> 성명 : "+MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));
							  logger.info("======================> 주민번호 : "+MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")));
							  logger.info("======================> 퇴직일자 : "+MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));
							  logger.info("======================> 재직상태 : "+MSFSharedUtils.allowNulls(bmMapModel.get("hdofcCodtnNm")));
							  logger.info("======================> 재직상태 : "+MSFSharedUtils.allowNulls(bmMapModel.get("hdofcCodtnCd")));
							  //이미 등록한 사람이면 						  
							  //재직상태 비교 A0030020 
					     if(ExtermsProps.getProps("HDOFC_CODTN_CD_20").equals(MSFSharedUtils.allowNulls(bmMapModel.get("hdofcCodtnCd")))){
						 //if("퇴직".equals(MSFSharedUtils.allowNulls(bmMapModel.get("hdofcCodtnNm")).trim())){

							  EgovMap insrMap = insr2100DAO.selectInsr2300ToInsr1100And1200(insr2100SrhVo);

							  if(insrMap != null && insrMap.size() > 0){
								  logger.info("======================>INSR : "+insrMap.size());						              
							  	  insr2100Vo.setSoctyInsurCmptnDt((String) insrMap.get("nowDay"));    /** column 사회보험작성일자 : soctyInsurCmptnDt */
					              BigDecimal bigDecimal =  (BigDecimal) insrMap.get("socInsrAqtnEmymtNum");	
					              insr2100Vo.setSocInsrLssEmymtNum(bigDecimal.longValue());    /** column 사회보험상실_고용_일련번호 : socInsrAqtnEmymtNum */
					        	  insr2100Vo.setSocInsrMbrPhnNum((String) insrMap.get("")); /*사회보험가입자전화번호*/
								  insr2100Vo.setHlthInsrRegrstYn((String) insrMap.get("hlthInsrRegrstYn"));    /** column 건강보험신고여부 : hlthInsrRegrstYn */
								  insr2100Vo.setNatPennRegrstYn((String) insrMap.get("natPennRegrstYn"));    /** column 국민연금신고여부 : natPennRegrstYn */
								  insr2100Vo.setUmytInsrRegrstYn((String) insrMap.get("umytInsrRegrstYn"));    /** column 고용보험신고여부 : umytInsrRegrstYn */
								  insr2100Vo.setIdtlAccdtRegrstYn((String) insrMap.get("idtlAccdtRegrstYn"));    /** column 산재보험신고여부 : idtlAccdtRegrstYn */
								  insr2100Vo.setSoctyInsurLssDt(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));	/*사회보험상실일자*/
								  insr2100Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
								  insr2100Vo.setInptDt((String) insrMap.get("nowDay"));	  /* 입력일자*/
								  insr2100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/*입력주소*/							  
								  insr2100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
								  insr2100Vo.setRevnDt((String) insrMap.get("nowDay"));	/*수정일자*/
								  insr2100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());   /** column 수정주소 : revnAddr */
								 
								  insr2200Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
								  insr2200Vo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
								  insr2200Vo.setSoctyInsurCmptnDt(insr2100Vo.getSoctyInsurCmptnDt());      /** column 사회보험작성일자 : soctyInsurCmptnDt */
								  insr2200Vo.setSocInsrLssEmymtNum(insr2100Vo.getSocInsrLssEmymtNum());    /** column 사회보험상실_고용_일련번호 : socInsrAqtnEmymtNum */											        
								  insr2200Vo.setSocnsrIssRegVal01(insr2100Vo.getNatPennRegrstYn()+insr2100Vo.getHlthInsrRegrstYn()+insr2100Vo.getUmytInsrRegrstYn()+insr2100Vo.getIdtlAccdtRegrstYn()); /*공단구분*/
								  insr2200Vo.setSocnsrIssRegVal02(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));	/*성명*/
								  //insr2200Vo.setSocnsrIssRegVal03(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum"))); /*주민등록번호*/
								  insr2200Vo.setSocnsrIssRegVal03(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
								  
								  insr2200Vo.setSocnsrIssRegVal04(MSFSharedUtils.allowNulls(bmMapModel.get(""))); /*전화번호*/
								  insr2200Vo.setSocnsrIssRegVal05(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt"))); /*연금 상실일(퇴직일자)*/              
								  insr2200Vo.setSocnsrIssRegVal06(""); 
								  insr2200Vo.setSocnsrIssRegVal07("0");
								  insr2200Vo.setSocnsrIssRegVal08(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));/*건강_상실일(퇴직일자)*/
								  insr2200Vo.setSocnsrIssRegVal09("");
								  insr2200Vo.setSocnsrIssRegVal10("0");
								  insr2200Vo.setSocnsrIssRegVal11("0");
								  insr2200Vo.setSocnsrIssRegVal12("0");
								  insr2200Vo.setSocnsrIssRegVal13("0");
								  insr2200Vo.setSocnsrIssRegVal14("0");
								  insr2200Vo.setSocnsrIssRegVal15("0");
								  insr2200Vo.setSocnsrIssRegVal16("");
								  insr2200Vo.setSocnsrIssRegVal17("");
								  insr2200Vo.setSocnsrIssRegVal18(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));/*고용_상실일(퇴직일자)*/
								  insr2200Vo.setSocnsrIssRegVal19("0");
								  insr2200Vo.setSocnsrIssRegVal20("");
								  insr2200Vo.setSocnsrIssRegVal21("");
								  insr2200Vo.setSocnsrIssRegVal22(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));/*산재_상실일(퇴직일자)*/
								  insr2200Vo.setSocnsrIssRegVal23("0");
								  insr2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력주소 : inptAddr */ 
								  insr2200Vo.setInptDt("");	  /* 입력일자*/
								  insr2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/*입력주소*/
								  insr2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
								  insr2200Vo.setRevnDt("");	/*수정일자*/
								  insr2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());   /** column 수정주소 : revnAddr */

								  
								  if(0 < insr2100DAO.selectInsr2100Chk(insr2100Vo)){
									  logger.info("==========================> insr2100DAO.selectInsr2100Chk  : 이미 상실된 대상자 ");
								  }else{
									  insr2100DAO.insertInsr2100(insr2100Vo); 
									  insr2200DAO.insertInsr2200(insr2200Vo);
									  flag = true;								
									  iCnt = iCnt + 1;
								  }	
 
							  }else{
								  
								  EgovMap psnlMap = insr2100DAO.selectInsr2300ToPsnl0110(insr2100SrhVo);
								  
								  if(psnlMap == null)
								  {
									  logger.info("psnl0110 no data!!"); 
								  }else{
									  logger.info("==========================> PSNL0110 SELECT : "+psnlMap.size());
									  
									  insr2100Vo.setSoctyInsurCmptnDt((String) psnlMap.get("nowDay"));    /** column 사회보험작성일자 : soctyInsurCmptnDt */
									  BigDecimal bigDecimal =  (BigDecimal) psnlMap.get("emymtSeilNum");	
						              insr2100Vo.setSocInsrLssEmymtNum(bigDecimal.longValue());    /** column 사회보험상실_고용_일련번호 : socInsrAqtnEmymtNum */						  
									  insr2100Vo.setSocInsrMbrPhnNum("");	/*사회보험가입자전화번호*/
									  insr2100Vo.setHlthInsrRegrstYn("N");    /** column 건강보험신고여부 : hlthInsrRegrstYn */
									  insr2100Vo.setNatPennRegrstYn("N");    /** column 국민연금신고여부 : natPennRegrstYn */
									  insr2100Vo.setUmytInsrRegrstYn("N");    /** column 고용보험신고여부 : umytInsrRegrstYn */
									  insr2100Vo.setIdtlAccdtRegrstYn("N");    /** column 산재보험신고여부 : idtlAccdtRegrstYn */
									  insr2100Vo.setSoctyInsurLssDt(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));	/*사회보험상실일자*/
									  insr2100Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */ 
									  insr2100Vo.setInptDt((String) psnlMap.get("nowDay"));	  /* 입력일자*/
									  insr2100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/*입력주소*/							  
									  insr2100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
									  insr2100Vo.setRevnDt((String) psnlMap.get("nowDay"));	/*수정일자*/
									  insr2100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());   /** column 수정주소 : revnAddr */
									 
									  insr2200Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
									  insr2200Vo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
									  insr2200Vo.setSoctyInsurCmptnDt(insr2100Vo.getSoctyInsurCmptnDt());      /** column 사회보험작성일자 : soctyInsurCmptnDt */
									  insr2200Vo.setSocInsrLssEmymtNum(insr2100Vo.getSocInsrLssEmymtNum());    /** column 사회보험상실_고용_일련번호 : socInsrAqtnEmymtNum */			
									  insr2200Vo.setSocnsrIssRegVal01("NNNN");  /*공단구분*/          
									  insr2200Vo.setSocnsrIssRegVal02(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));	/*성명*/
									  insr2200Vo.setSocnsrIssRegVal03((String) psnlMap.get("resnRegnNum")); /*주민등록번호*/
									  insr2200Vo.setSocnsrIssRegVal04(MSFSharedUtils.allowNulls(bmMapModel.get(""))); /*전화번호*/
									  insr2200Vo.setSocnsrIssRegVal05(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt"))); /*연금_상실일(퇴직일자)*/
		                                                 
									  insr2200Vo.setSocnsrIssRegVal06(""); 
									  insr2200Vo.setSocnsrIssRegVal07("0");
									  insr2200Vo.setSocnsrIssRegVal08(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));/*건강_상실일(퇴직일자)*/
									  insr2200Vo.setSocnsrIssRegVal09("");
									  insr2200Vo.setSocnsrIssRegVal10("0");
									  insr2200Vo.setSocnsrIssRegVal11("0");
									  insr2200Vo.setSocnsrIssRegVal12("0");
									  insr2200Vo.setSocnsrIssRegVal13("0");
									  insr2200Vo.setSocnsrIssRegVal14("0");
									  insr2200Vo.setSocnsrIssRegVal15("0");
									  insr2200Vo.setSocnsrIssRegVal16("");
									  insr2200Vo.setSocnsrIssRegVal17("");
									  insr2200Vo.setSocnsrIssRegVal18(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));/*고용_상실일(퇴직일자)*/
									  insr2200Vo.setSocnsrIssRegVal19("0");
									  insr2200Vo.setSocnsrIssRegVal20("");
									  insr2200Vo.setSocnsrIssRegVal21("");
									  insr2200Vo.setSocnsrIssRegVal22(MSFSharedUtils.allowNulls(bmMapModel.get("retryDt")));/*산재_상실일(퇴직일자)*/
									  insr2200Vo.setSocnsrIssRegVal23("0");
									  insr2200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력주소 : inptAddr */ 
									  insr2200Vo.setInptDt("");	  /* 입력일자*/
									  insr2200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/*입력주소*/
									  insr2200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
									  insr2200Vo.setRevnDt("");	/*수정일자*/
									  insr2200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());   /** column 수정주소 : revnAddr */
									  
									  if(0 < insr2100DAO.selectInsr2100Chk(insr2100Vo)){
										  logger.info("==========================> insr2100DAO.selectInsr2100Chk  : 이미 상실된 대상자 ");
									  }else{
										  insr2100DAO.insertInsr2100(insr2100Vo); 
										  insr2200DAO.insertInsr2200(insr2200Vo);
										  flag = true;	
										  iCnt = iCnt + 1;
									  }
 
								  }
							  }
							      
							//피부양
							  if(flag){
								  
								  insr1500SrhVo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));
								  insr1500SrhVo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
								  insr1500SrhVo.setFamyAqtnLssNum(insr2100Vo.getSocInsrLssEmymtNum());
								  insr1500SrhVo.setFamyQuftDivCd("I0100001"); 
								  //피부양자 취득 마스터 조회
								  insr1500Vo = insr1500DAO.selectInsr1500Aqtn(insr1500SrhVo);
								  
								  if(insr1500Vo != null && insr1500Vo.getSystemkey() != null && !insr1500Vo.getSystemkey().equals("")){

									  
									  insr1500Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
									  insr1500Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
									  insr1500Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
									  insr1500Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
									  insr1500Vo.setFamyQuftDivCd("I0100002");
									  insr1500Vo.setSocInsrLssCmptnDt(insr2100Vo.getSoctyInsurCmptnDt());//상실 작성일자
									  insr1500Vo.setSocInsrLssEmymtNum(insr1500Vo.getFamyAqtnLssNum());	 //상실 고용일련번호
									  
									  //피부양자 상실 마스터 조회
									  if(0 < insr1500DAO.selectInsr2300To1500Check(insr1500Vo)){									  
										  insr1500DAO.updateInsr1500Lss(insr1500Vo);
									  }else{
										  insr1500DAO.insertInsr1500Lss(insr1500Vo);
									  }
									  
									  Insr1600VO insr1600SrhVo = new Insr1600VO();
									  insr1600SrhVo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));
									  insr1600SrhVo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
									  insr1600SrhVo.setFamyAqtnLssNum(insr1500Vo.getFamyAqtnLssNum());
									  insr1600SrhVo.setFamyQuftDivCd("I0100002");
									  
									  List<EgovMap> resArr = new ArrayList<EgovMap>();
									  
									  
									  //피부양자 상실 조회
									  if(0 < insr1600DAO.selectInsr1600Check(insr1600SrhVo)){
										  
										  Insr1550SrhVO insr1550SrhVo = new Insr1550SrhVO();
										  insr1550SrhVo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));
										  insr1550SrhVo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
										  insr1550SrhVo.setFamyAqtnLssNum(insr1500Vo.getFamyAqtnLssNum());
										  insr1550SrhVo.setFamyQuftDivCdAqtn("I0100001");
										  insr1550SrhVo.setFamyQuftDivCdLss("I0100002");
										  //이미 상실된 피부양자 빼고 나머지 취득된 피부양자 조회 
										  resArr =  insr1500DAO.selectInsr1550List2(insr1550SrhVo);
									  }else{
										  
										  Insr1550SrhVO insr1550SrhVo = new Insr1550SrhVO();
										  insr1550SrhVo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));
										  insr1550SrhVo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
										  insr1550SrhVo.setFamyAqtnLssNum(insr1500Vo.getFamyAqtnLssNum());
										  insr1550SrhVo.setFamyQuftDivCd("I0100001");
										  //취득된 피부양자 조회
										  resArr =  insr1500DAO.selectInsr1550List(insr1550SrhVo);
									  }

									  if(resArr != null && resArr.size() > 0){
										  for(int i=0; i<resArr.size(); i++){
											  EgovMap resMap = resArr.get(i);
											  Insr1600VO insr1600Vo = new Insr1600VO();
											  
											  BigDecimal famySeilNum =  (BigDecimal) resMap.get("famySeilNum");	
											  insr1600Vo.setFamySeilNum(famySeilNum.longValue());    /** column 가족일련번호 : famySeilNum */
											  insr1600Vo.setDpobCd((String) resMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
											  insr1600Vo.setSystemkey((String) resMap.get("systemkey"));    /** column SYSTEMKEY : systemkey */
											  BigDecimal famyAqtnLssNum =  (BigDecimal) resMap.get("famyAqtnLssNum");	
											  insr1600Vo.setFamyAqtnLssNum(famyAqtnLssNum.longValue());    /** column 피부양자취득상실_고용일련번호 : famyAqtnLssNum */
											  insr1600Vo.setFamyQuftDivCd("I0100002");
											  insr1600Vo.setFamyAqtnLssDt((String) resMap.get("famyAqtnLssDt"));    /** column 피부양자취득상실신고작성일자 : famyAqtnLssDt */	 										  											  
											  insr1600Vo.setFamyRelaDivCd((String) resMap.get("famyRelaDivCd"));    /** column 가족관계구분코드 : famyRelaDivCd */
											  insr1600Vo.setFamyNm((String) resMap.get("famyNm"));    /** column 가족성명 : famyNm */
											  insr1600Vo.setFamyResnRegnNum((String) resMap.get("famyResnRegnNum"));    /** column 가족주민등록번호 : famyResnRegnNum */
											  insr1600Vo.setAqtnLssDt(insr2100Vo.getSoctyInsurCmptnDt());    /** column 피부양자상실일자 : aqtnLssDt */
											  insr1600Vo.setLssReasCd("I0110006");    /** column 피부양자상실사유코드 : lssReasCd */
											  insr1600Vo.setDbpsnAssttnSgnCd((String) resMap.get("dbpsnAssttnSgnCd"));    /** column 장애인_종별부호코드 : dbpsnAssttnSgnCd */
											  insr1600Vo.setDbpsnGrdeCd((String) resMap.get("dbpsnGrdeCd"));    /** column 장애인_등급코드 : dbpsnGrdeCd */
											  insr1600Vo.setDbpsnRgstnDt((String) resMap.get("dbpsnRgstnDt"));    /** column 장애인_등록일자 : dbpsnRgstnDt */
											  insr1600Vo.setDbpsnNatnCd((String) resMap.get("dbpsnNatnCd"));    /** column 장애인_국적코드 : dbpsnNatnCd */
											  insr1600Vo.setFrgnrStyQftntCd((String) resMap.get("frgnrStyQftntCd"));    /** column 외국인_체류자격코드 : frgnrStyQftntCd */
											  insr1600Vo.setFrgnrStyBgnnDt((String) resMap.get("frgnrStyBgnnDt"));    /** column 외국인_체류시작일자 : frgnrStyBgnnDt */
											  insr1600Vo.setFrgnrStyEndDt((String) resMap.get("frgnrStyEndDt"));    /** column 외국인_체류종료일자 : frgnrStyEndDt */
											  insr1600Vo.setSocrAqtnFamyYn((String) resMap.get("socrAqtnFamyYn"));    /** column 사회보험취득가족신고여부 : socrAqtnFamyYn */
											  insr1600Vo.setSocrLssFamyYn((String) resMap.get("socrLssFamyYn"));    /** column 사회보험상실가족신고여부 : socrLssFamyYn */
											  insr1600Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
											  insr1600Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
											  insr1600Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
											  insr1600Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
											  insr1600DAO.insertInsr1500(insr1600Vo);
										  } 
									  }
								  }

							  }
						   }
		                    
		               } 
		                result = iCnt;
		                
		                logger.info("result : "+result);
		                
			        }
			        catch (Exception ex) {
			            logger.error("EXCEPTION calling activityOnInsertInsr2300(): "+ex); 
			            
			            result = new Long(0);
			            throw MSFServerUtils.getOperationException("activityOnInsertInsr2300", ex, logger);
			        }
			        finally {
			          
			        }
			        
			        return result;
			} 
}
