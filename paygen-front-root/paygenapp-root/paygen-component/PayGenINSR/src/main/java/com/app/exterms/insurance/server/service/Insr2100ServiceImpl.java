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

import com.app.exterms.insurance.client.dto.Insr1100DTO;
import com.app.exterms.insurance.client.dto.Insr1200DTO;
import com.app.exterms.insurance.client.dto.Insr1550DTO;
import com.app.exterms.insurance.client.service.Insr2100Service;
import com.app.exterms.insurance.server.service.dao.Insr1100DAO;
import com.app.exterms.insurance.server.service.dao.Insr1200DAO;
import com.app.exterms.insurance.server.service.dao.Insr1300DAO;
import com.app.exterms.insurance.server.service.dao.Insr1500DAO;
import com.app.exterms.insurance.server.service.dao.Insr1600DAO;
import com.app.exterms.insurance.server.vo.Insr1100SrhVO;
import com.app.exterms.insurance.server.vo.Insr1100VO;
import com.app.exterms.insurance.server.vo.Insr1200SrhVO;
import com.app.exterms.insurance.server.vo.Insr1200VO;
import com.app.exterms.insurance.server.vo.Insr1300VO;
import com.app.exterms.insurance.server.vo.Insr1500VO;
import com.app.exterms.insurance.server.vo.Insr1550SrhVO;
import com.app.exterms.insurance.server.vo.Insr1550VO;
import com.app.exterms.insurance.server.vo.Insr1600VO;
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
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
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
@Service("Insr2100Service")
public class Insr2100ServiceImpl extends AbstractCustomServiceImpl implements Insr2100Service ,InsrDaoConstants{
	
		private static final Logger logger = LoggerFactory.getLogger(Insr2100ServiceImpl.class);
		private static final String calledClass = Insr2100ServiceImpl.class.getName();
		

		@Autowired
	    @Resource(name="Insr1100DAO")
	    private Insr1100DAO insr1100DAO;
		
		@Autowired
	    @Resource(name="Insr1200DAO")
	    private Insr1200DAO insr1200DAO;
		
		@Autowired
	    @Resource(name="Insr1300DAO")
	    private Insr1300DAO insr1300DAO;
		
		@Autowired
	    @Resource(name="Insr1500DAO")
	    private Insr1500DAO insr1500DAO;
		
		@Autowired
	    @Resource(name="Insr1600DAO")
	    private Insr1600DAO insr1600DAO;
			
		  /** ID Generation */
	    //@Resource(name="{egovInsr1100IdGnrService}")    
	    //private EgovIdGnrService egovIdGnrService;
		
		public PagingLoadResult<BaseModel> getInsr2100ToInsr1100DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_INSR2100TOINSR1100_DAO_LIST;
	        Insr1100SrhVO   insr1100SrhVO = new Insr1100SrhVO();
	        Insr1100VO      insr1100VO = new Insr1100VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        List<String> listDeptCd = new ArrayList<String>();
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        
	        if  (MSFSharedUtils.paramNull(insr1100DAO)) {
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	insr1100DAO = (Insr1100DAO) wac.getBean("Insr1100DAO" ); 
	        }
	        
	        try {
	        	
//	        	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
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
	            insr1100SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            insr1100SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            
	            
	            insr1100SrhVO.setSoctyInsurCmptnDt01(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "soctyInsurCmptnDt01"))) ;   //작성기간-시작일자
	            insr1100SrhVO.setSoctyInsurCmptnDt02(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "soctyInsurCmptnDt02"))) ;   //작성기간-종료일자
	            
	           
	            insr1100SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	             
	            insr1100SrhVO.setUsrId(sessionUser.getUsrId());  
	            insr1100SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            insr1100SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));  
	            insr1100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
           	    insr1100SrhVO.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드

	            
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	insr1100SrhVO.setDeptCd(sessionUser.getDeptCd()); 
	               listDeptCd.add(sessionUser.getDeptCd());
	               insr1100SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
	               insr1100SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	            	 
	                     if (insr1100SrhVO.getPayrMangeDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                     	 listDeptCd = null; 
	                     	insr1100SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	                     	insr1100SrhVO.setDeptCd("");  //부서코드
	                     } else {
	                    	 insr1100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                          insr1100SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	                     } 
	                  
	            }
	            
	            
	            
	           // insr1100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            insr1100SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	            //insr1100SrhVO.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            insr1100SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	            insr1100SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
	            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
	            insr1100SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	            insr1100SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            insr1100SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            insr1100SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	            
	            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
	            insr1100SrhVO.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
	            insr1100SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
	            
	            
	            insr1100SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            insr1100SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
	            
	            insr1100SrhVO.setfamyQuftDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "famyQuftDivCd"))); //취득상실
	            
	            
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = insr1100DAO.selectInsr2100ToInsr1100ListTotCnt(insr1100SrhVO);  
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginInsr2100ToInsr1100DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            insr1100SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	insr1100SrhVO.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	insr1100SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//			            Collection<Map<String, Object>> list ??????
	            List list = insr1100DAO.selectInsr2100ToInsr1100List(insr1100SrhVO);
	            
		        Iterator<Map<String, Object>> iter = list.iterator();
		            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("systemkey").toString();
	                BaseModel bm = new BaseModel();
	 
	                //bm.setProperties(map);
	                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
	                	
	                	// 1. 암호화 객체 생성
	            		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

	                	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
	                	Object mapCon = map.get(tableAttributes[i].getName());  

	                	switch ( tableAttributes[i].getType() ) {  


	                	case ColumnDef.TYPE_STRING: 
	                		String strValue = String.valueOf(mapCon);
	                		if("resnRegnNum".equals(tableAttributes[i].getName())) {
	                			// TODO 주민번호
	                			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	                		}
	                		if("socnsrAqtnRegVal03".equals(tableAttributes[i].getName())) {
	                			// TODO 주민번호
	                			strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("socnsrAqtnRegVal03")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginInsr2100ToInsr1100DataList, "getInsr2100ToInsr1100DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }
		
		
		public PagingLoadResult<BaseModel> getInsr2150ToInsr1100DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_INSR2100TOINSR1100_DAO_LIST;
	        Insr1100SrhVO   insr1100SrhVO = new Insr1100SrhVO();
	        Insr1100VO      insr1100VO = new Insr1100VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        List<String> listDeptCd = new ArrayList<String>();
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        
	        if  (MSFSharedUtils.paramNull(insr1100DAO)) {
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	insr1100DAO = (Insr1100DAO) wac.getBean("Insr1100DAO" ); 
	        }
	        
	        try {
//	        	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
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
	            insr1100SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            insr1100SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            
	            
	            insr1100SrhVO.setSoctyInsurCmptnDt01(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "soctyInsurCmptnDt01"))) ;   //작성기간-시작일자
	            insr1100SrhVO.setSoctyInsurCmptnDt02(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "soctyInsurCmptnDt02"))) ;   //작성기간-종료일자
	            
	           
	            insr1100SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	             
	            insr1100SrhVO.setUsrId(sessionUser.getUsrId());  
	            insr1100SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            insr1100SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));  
	            insr1100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
           	    insr1100SrhVO.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드

           	    
           	    insr1100SrhVO.setApplyAqtnLssYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "applyAqtnLssYn"))) ;   //취득상실 미선택시 신고여부
           	    insr1100SrhVO.setApplyAqtnYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "applyAqtnYn"))) ;         //취득 선택시 신고여부
           	    insr1100SrhVO.setApplyLssYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "applyLssYn"))) ;           //상실 선택시 신고여부
	            
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	insr1100SrhVO.setDeptCd(sessionUser.getDeptCd()); 
	               listDeptCd.add(sessionUser.getDeptCd());
	               insr1100SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
	               insr1100SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	            	 
	                     if (insr1100SrhVO.getPayrMangeDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                     	 listDeptCd = null; 
	                     	insr1100SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	                     	insr1100SrhVO.setDeptCd("");  //부서코드
	                     } else {
	                    	 insr1100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                          insr1100SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	                     } 
	                  
	            }
	            
	            
	            
	           // insr1100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            insr1100SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	            //insr1100SrhVO.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            insr1100SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	            insr1100SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
	            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
	            insr1100SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
	            insr1100SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            insr1100SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            insr1100SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	            
	            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
	            insr1100SrhVO.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
	            insr1100SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
	            
	            
	            insr1100SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            insr1100SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
	            
	            insr1100SrhVO.setfamyQuftDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "famyQuftDivCd"))); //취득상실
	            String famyQuftDivCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "famyQuftDivCd"));
	            
	            
	            if(famyQuftDivCd != null && !famyQuftDivCd.equals("")){
	            	if(famyQuftDivCd.equals("I0100001")) insr1100SrhVO.setfamyQuftDivCdAqtn(famyQuftDivCd);
	            	else if(famyQuftDivCd.equals("I0100002")) insr1100SrhVO.setfamyQuftDivCdLss(famyQuftDivCd);
	            }
	            
	            
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = insr1100DAO.selectInsr2150ToInsr1100ListTotCnt(insr1100SrhVO);  
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginInsr2100ToInsr1100DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            insr1100SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	insr1100SrhVO.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	insr1100SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//			            Collection<Map<String, Object>> list ??????
	            List list = insr1100DAO.selectInsr2150ToInsr1100List(insr1100SrhVO);
	            
		        Iterator<Map<String, Object>> iter = list.iterator();
		            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("systemkey").toString();
	                BaseModel bm = new BaseModel();
	 
	                //bm.setProperties(map);
	                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
	                	
	                	// 1. 암호화 객체 생성
	            		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	                	
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginInsr2100ToInsr1100DataList, "getInsr2100ToInsr1100DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }
		
		
		/**
		 * 자격취득상세정보 
		 * @param serviceParameters
		 * @return
		 * @throws MSFException
		 */
		public PagingLoadResult<BaseModel> getInsr2100ToInsr1200DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_INSR2100TOINSR1200_DAO_LIST;
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
	            
	            
	            /** 조건절 */
	            insr1200SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드  
	            insr1200SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            
	            insr1200SrhVO.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "soctyInsurCmptnDt")));     /** set 사회보험작성일자 : soctyInsurCmptnDt */
	            insr1200SrhVO.setSocInsrAqtnEmymtNum(new BigDecimal(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "socInsrAqtnEmymtNum"),"0")));    /** set 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	            
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = insr1200DAO.selectInsr2100ToInsr1200ListTotCnt(insr1200SrhVO);  
	                
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginInsr2100ToInsr1200DataList = SmrmfUtils.startTiming(logger);
	        
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
	            List list = insr1200DAO.selectInsr2100ToInsr1200List(insr1200SrhVO);
	            
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginInsr2100ToInsr1200DataList, "getInsr2100ToInsr1200DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }
		
		
	  @Override
	  	public Insr1200DTO activityOnReadInsr1200(Insr1200DTO insr1200Dto) throws MSFException {
		  
			String method = calledClass + ".activityOnReadInsr1200";
			
			String windowNm = "사회보험자격취득신고";
			String windowId = "INSR2100";
	 
	  		Insr1200DTO reltInsr1200 = new Insr1200DTO();
		    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());  
	       
	       try { 
	       
	          
		    	   Insr1200VO  insr1200Vo = new Insr1200VO();
		    	   Insr1200VO  tpInsr1200Vo = new Insr1200VO();
		            
		    	   tpInsr1200Vo.setDpobCd(insr1200Dto.getDpobCd());   			 	/** column 사업장코드 : dpobCd */
		    	   tpInsr1200Vo.setSystemkey(insr1200Dto.getSystemkey());    		/** column SYSTEMKEY : systemkey */
		    	   tpInsr1200Vo.setSoctyInsurCmptnDt(insr1200Dto.getSoctyInsurCmptnDt());   			/** column 사회보험작성일자 : soctyInsurCmptnDt */
		    	   tpInsr1200Vo.setSocInsrAqtnEmymtNum(insr1200Dto.getSocInsrAqtnEmymtNum());	/** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	   
				   insr1200Vo = insr1200DAO.selectInsr1200(tpInsr1200Vo);
				   
				   if (MSFSharedUtils.paramNotNull(insr1200Vo) && MSFSharedUtils.paramNotNull(insr1200Vo.getSystemkey())) {
	         
	
					   reltInsr1200.setDpobCd(insr1200Vo.getDpobCd());    													/** column 사업장코드 : dpobCd */
					   reltInsr1200.setSystemkey(insr1200Vo.getSystemkey());    												/** column SYSTEMKEY : systemkey */
					   reltInsr1200.setSoctyInsurCmptnDt(insr1200Vo.getSoctyInsurCmptnDt());    							/** column 사회보험작성일자 : soctyInsurCmptnDt */
					   reltInsr1200.setSocInsrAqtnEmymtNum(insr1200Vo.getSocInsrAqtnEmymtNum().longValue());    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	
						//공단구분 4대보험 구분자로 분리 .
						reltInsr1200.setSocnsrAqtnRegVal01(insr1200Vo.getSocnsrAqtnRegVal01());    /** column 공단구분 : socnsrAqtnRegVal01 */
						
						reltInsr1200.setNatPennRegrstYn(MSFSharedUtils.convertStringToBoolean(insr1200Vo.getSocnsrAqtnRegVal01().substring(0, 1)));    /** column 국민연금신고여부 : natPennRegrstYn */
						reltInsr1200.setHlthInsrRegrstYn(MSFSharedUtils.convertStringToBoolean(insr1200Vo.getSocnsrAqtnRegVal01().substring(1, 2)));    /** column 건강보험신고여부 : hlthInsrRegrstYn */
						
						reltInsr1200.setUmytInsrRegrstYn(MSFSharedUtils.convertStringToBoolean(insr1200Vo.getSocnsrAqtnRegVal01().substring(2, 3)));    /** column 고용보험신고여부 : umytInsrRegrstYn */
						reltInsr1200.setIdtlAccdtRegrstYn(MSFSharedUtils.convertStringToBoolean(insr1200Vo.getSocnsrAqtnRegVal01().substring(3, 4)));    /** column 산재보험신고여부 : idtlAccdtRegrstYn */
						 
						reltInsr1200.setSocnsrAqtnRegVal02(insr1200Vo.getSocnsrAqtnRegVal02());    /** column 성명 : socnsrAqtnRegVal02 */
						
						String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
						nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            			String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr1200Vo.getSocnsrAqtnRegVal03()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
            			reltInsr1200.setSocnsrAqtnRegVal03(strValue);    /** column 주민등록번호 : socnsrAqtnRegVal03 */
            			
						reltInsr1200.setSocnsrAqtnRegVal04(insr1200Vo.getSocnsrAqtnRegVal04());    /** column 국적 : socnsrAqtnRegVal04 */
						reltInsr1200.setSocnsrAqtnRegVal04Nm(insr1200Vo.getSocnsrAqtnRegVal04Nm());    /** column 국적 : socnsrAqtnRegVal04 */
						reltInsr1200.setSocnsrAqtnRegVal05(insr1200Vo.getSocnsrAqtnRegVal05());    /** column 체류자격 : socnsrAqtnRegVal05 */
						reltInsr1200.setSocnsrAqtnRegVal06(MSFSharedUtils.convertValToBoolean(insr1200Vo.getSocnsrAqtnRegVal06()));    /** column 대표자여부 : socnsrAqtnRegVal06 */
						reltInsr1200.setSocnsrAqtnRegVal07(Long.parseLong(MSFSharedUtils.defaultNulls(insr1200Vo.getSocnsrAqtnRegVal07(),"0")));    /** column 연금_소득월액 : socnsrAqtnRegVal07 */
						reltInsr1200.setSocnsrAqtnRegVal08(MSFSharedUtils.convertValToBoolean(insr1200Vo.getSocnsrAqtnRegVal08()));    /** column 연금_취득월납부여부 : socnsrAqtnRegVal08 */
						reltInsr1200.setSocnsrAqtnRegVal09(insr1200Vo.getSocnsrAqtnRegVal09());    /** column 연금_취득부호 : socnsrAqtnRegVal09 */
						reltInsr1200.setSocnsrAqtnRegVal10(insr1200Vo.getSocnsrAqtnRegVal10());    /** column 연금_자격취득일 : socnsrAqtnRegVal10 */
						reltInsr1200.setSocnsrAqtnRegVal11(insr1200Vo.getSocnsrAqtnRegVal11());    /** column 연금_특수직종 : socnsrAqtnRegVal11 */
						reltInsr1200.setSocnsrAqtnRegVal12(insr1200Vo.getSocnsrAqtnRegVal12());    /** column 연금_직역연금부호 : socnsrAqtnRegVal12 */
						reltInsr1200.setSocnsrAqtnRegVal13(insr1200Vo.getSocnsrAqtnRegVal13());    /** column 건강_단위사업장기호 : socnsrAqtnRegVal13 */
						reltInsr1200.setSocnsrAqtnRegVal14(insr1200Vo.getSocnsrAqtnRegVal14());    /** column 건강_단위사업장명칭 : socnsrAqtnRegVal14 */
						reltInsr1200.setSocnsrAqtnRegVal15(Long.parseLong(MSFSharedUtils.defaultNulls(insr1200Vo.getSocnsrAqtnRegVal15(),"0")));    /** column 건강_보수월액 : socnsrAqtnRegVal15 */
						reltInsr1200.setSocnsrAqtnRegVal16(insr1200Vo.getSocnsrAqtnRegVal16());    /** column 건강_취득부호 : socnsrAqtnRegVal16 */
						reltInsr1200.setSocnsrAqtnRegVal17(insr1200Vo.getSocnsrAqtnRegVal17());    /** column 건강_자격취득일 : socnsrAqtnRegVal17 */
						reltInsr1200.setSocnsrAqtnRegVal18(insr1200Vo.getSocnsrAqtnRegVal18());    /** column 건강_감면 : socnsrAqtnRegVal18 */
						reltInsr1200.setSocnsrAqtnRegVal19(MSFSharedUtils.convertValToBoolean(insr1200Vo.getSocnsrAqtnRegVal19()));    /** column 건강_건강보험증 발송여부 : socnsrAqtnRegVal19 */
						reltInsr1200.setSocnsrAqtnRegVal20(insr1200Vo.getSocnsrAqtnRegVal20());    /** column 건강_회계 : socnsrAqtnRegVal20 */
						reltInsr1200.setSocnsrAqtnRegVal21(insr1200Vo.getSocnsrAqtnRegVal21());    /** column 건강_직종 : socnsrAqtnRegVal21 */
						reltInsr1200.setSocnsrAqtnRegVal22(insr1200Vo.getSocnsrAqtnRegVal22());    /** column 고용_자격취득일 : socnsrAqtnRegVal22 */
						reltInsr1200.setSocnsrAqtnRegVal23(insr1200Vo.getSocnsrAqtnRegVal23());    /** column 고용_직종 : socnsrAqtnRegVal23 */
						reltInsr1200.setSocnsrAqtnRegVal23Nm(insr1200Vo.getSocnsrAqtnRegVal23Nm());    /** column 고용_직종 : socnsrAqtnRegVal23 */
						reltInsr1200.setSocnsrAqtnRegVal24(Double.parseDouble(MSFSharedUtils.defaultNulls(insr1200Vo.getSocnsrAqtnRegVal24(),"0")));    /** column 고용_주소정근로시간 : socnsrAqtnRegVal24 */
						reltInsr1200.setSocnsrAqtnRegVal25(MSFSharedUtils.convertValToBoolean(insr1200Vo.getSocnsrAqtnRegVal25()));    /** column 고용_계약직여부 : socnsrAqtnRegVal25 */
						reltInsr1200.setSocnsrAqtnRegVal26(insr1200Vo.getSocnsrAqtnRegVal26());    /** column 고용_계약직종료년월 : socnsrAqtnRegVal26 */
						reltInsr1200.setSocnsrAqtnRegVal27(Long.parseLong(MSFSharedUtils.defaultNulls(insr1200Vo.getSocnsrAqtnRegVal27(),"0")));    /** column 고용_월평균보수 : socnsrAqtnRegVal27 */
						reltInsr1200.setSocnsrAqtnRegVal28(insr1200Vo.getSocnsrAqtnRegVal28());    /** column 고용_비고 : socnsrAqtnRegVal28 */
						reltInsr1200.setSocnsrAqtnRegVal29(insr1200Vo.getSocnsrAqtnRegVal29());    /** column 고용_보험료부과구분부호 : socnsrAqtnRegVal29 */
						reltInsr1200.setSocnsrAqtnRegVal30(insr1200Vo.getSocnsrAqtnRegVal30());    /** column 고용_보험료부과사유 : socnsrAqtnRegVal30 */
						reltInsr1200.setSocnsrAqtnRegVal31(insr1200Vo.getSocnsrAqtnRegVal31());    /** column 산재_자격취득일 : socnsrAqtnRegVal31 */
						reltInsr1200.setSocnsrAqtnRegVal32(insr1200Vo.getSocnsrAqtnRegVal32());    /** column 산재_직종 : socnsrAqtnRegVal32 */
						reltInsr1200.setSocnsrAqtnRegVal32Nm(insr1200Vo.getSocnsrAqtnRegVal32Nm());    /** column 산재_직종 : socnsrAqtnRegVal32 */
						reltInsr1200.setSocnsrAqtnRegVal33(Double.parseDouble(MSFSharedUtils.defaultNulls(insr1200Vo.getSocnsrAqtnRegVal33(),"0")));    /** column 산재_주소정근로시간 : socnsrAqtnRegVal33 */
						reltInsr1200.setSocnsrAqtnRegVal34(MSFSharedUtils.convertValToBoolean(insr1200Vo.getSocnsrAqtnRegVal34()));    /** column 산재_계약직여부 : socnsrAqtnRegVal34 */
						reltInsr1200.setSocnsrAqtnRegVal35(insr1200Vo.getSocnsrAqtnRegVal35());    /** column 산재_계약직종료년월 : socnsrAqtnRegVal35 */
						reltInsr1200.setSocnsrAqtnRegVal36(Long.parseLong(MSFSharedUtils.defaultNulls(insr1200Vo.getSocnsrAqtnRegVal36(),"0")));    /** column 산재_월평균보수 : socnsrAqtnRegVal36 */
						reltInsr1200.setSocnsrAqtnRegVal37(insr1200Vo.getSocnsrAqtnRegVal37());    /** column 산재_비고 : socnsrAqtnRegVal37 */
						reltInsr1200.setSocnsrAqtnRegVal38(insr1200Vo.getSocnsrAqtnRegVal38());    /** column 산재_보험료부과구분부호 : socnsrAqtnRegVal38 */
						reltInsr1200.setSocnsrAqtnRegVal39(insr1200Vo.getSocnsrAqtnRegVal39());    /** column 산재_보험료부과구분사유 : socnsrAqtnRegVal39 */
						reltInsr1200.setSocnsrAqtnRegVal40(insr1200Vo.getSocnsrAqtnRegVal40());    /** column 사회보험취득신고_ITEM_VALUE40 : socnsrAqtnRegVal40 */
						reltInsr1200.setSocnsrAqtnRegVal41(insr1200Vo.getSocnsrAqtnRegVal41());    /** column 사회보험취득신고_ITEM_VALUE41 : socnsrAqtnRegVal41 */
						reltInsr1200.setSocnsrAqtnRegVal42(insr1200Vo.getSocnsrAqtnRegVal42());    /** column 사회보험취득신고_ITEM_VALUE42 : socnsrAqtnRegVal42 */
						reltInsr1200.setSocnsrAqtnRegVal43(insr1200Vo.getSocnsrAqtnRegVal43());    /** column 사회보험취득신고_ITEM_VALUE43 : socnsrAqtnRegVal43 */
						reltInsr1200.setSocnsrAqtnRegVal44(insr1200Vo.getSocnsrAqtnRegVal44());    /** column 사회보험취득신고_ITEM_VALUE44 : socnsrAqtnRegVal44 */
						reltInsr1200.setSocnsrAqtnRegVal45(insr1200Vo.getSocnsrAqtnRegVal45());    /** column 사회보험취득신고_ITEM_VALUE45 : socnsrAqtnRegVal45 */
						reltInsr1200.setSocnsrAqtnRegVal46(insr1200Vo.getSocnsrAqtnRegVal46());    /** column 사회보험취득신고_ITEM_VALUE46 : socnsrAqtnRegVal46 */
						reltInsr1200.setSocnsrAqtnRegVal47(insr1200Vo.getSocnsrAqtnRegVal47());    /** column 사회보험취득신고_ITEM_VALUE47 : socnsrAqtnRegVal47 */
						reltInsr1200.setSocnsrAqtnRegVal48(insr1200Vo.getSocnsrAqtnRegVal48());    /** column 사회보험취득신고_ITEM_VALUE48 : socnsrAqtnRegVal48 */
						reltInsr1200.setSocnsrAqtnRegVal49(insr1200Vo.getSocnsrAqtnRegVal49());    /** column 사회보험취득신고_ITEM_VALUE49 : socnsrAqtnRegVal49 */
						reltInsr1200.setSocnsrAqtnRegVal50(insr1200Vo.getSocnsrAqtnRegVal50());    /** column 사회보험취득신고_ITEM_VALUE50 : socnsrAqtnRegVal50 */
						reltInsr1200.setSocnsrAqtnRegVal51(insr1200Vo.getSocnsrAqtnRegVal51());    /** column 사회보험취득신고_ITEM_VALUE51 : socnsrAqtnRegVal51 */
						reltInsr1200.setSocnsrAqtnRegVal52(insr1200Vo.getSocnsrAqtnRegVal52());    /** column 사회보험취득신고_ITEM_VALUE52 : socnsrAqtnRegVal52 */
						reltInsr1200.setSocnsrAqtnRegVal53(insr1200Vo.getSocnsrAqtnRegVal53());    /** column 사회보험취득신고_ITEM_VALUE53 : socnsrAqtnRegVal53 */
						reltInsr1200.setSocnsrAqtnRegVal54(insr1200Vo.getSocnsrAqtnRegVal54());    /** column 사회보험취득신고_ITEM_VALUE54 : socnsrAqtnRegVal54 */
						reltInsr1200.setSocnsrAqtnRegVal55(insr1200Vo.getSocnsrAqtnRegVal55());    /** column 사회보험취득신고_ITEM_VALUE55 : socnsrAqtnRegVal55 */
						reltInsr1200.setSocnsrAqtnRegVal56(insr1200Vo.getSocnsrAqtnRegVal56());    /** column 사회보험취득신고_ITEM_VALUE56 : socnsrAqtnRegVal56 */
						reltInsr1200.setSocnsrAqtnRegVal57(insr1200Vo.getSocnsrAqtnRegVal57());    /** column 사회보험취득신고_ITEM_VALUE57 : socnsrAqtnRegVal57 */
						reltInsr1200.setSocnsrAqtnRegVal58(insr1200Vo.getSocnsrAqtnRegVal58());    /** column 사회보험취득신고_ITEM_VALUE58 : socnsrAqtnRegVal58 */
						reltInsr1200.setSocnsrAqtnRegVal59(insr1200Vo.getSocnsrAqtnRegVal59());    /** column 사회보험취득신고_ITEM_VALUE59 : socnsrAqtnRegVal59 */
						reltInsr1200.setSocnsrAqtnRegVal60(insr1200Vo.getSocnsrAqtnRegVal60());    /** column 사회보험취득신고_ITEM_VALUE60 : socnsrAqtnRegVal60 */
						reltInsr1200.setSocnsrAqtnRegVal61(insr1200Vo.getSocnsrAqtnRegVal61());    /** column 사회보험취득신고_ITEM_VALUE61 : socnsrAqtnRegVal61 */
						reltInsr1200.setSocnsrAqtnRegVal62(insr1200Vo.getSocnsrAqtnRegVal62());    /** column 사회보험취득신고_ITEM_VALUE62 : socnsrAqtnRegVal62 */
						reltInsr1200.setSocnsrAqtnRegVal63(insr1200Vo.getSocnsrAqtnRegVal63());    /** column 사회보험취득신고_ITEM_VALUE63 : socnsrAqtnRegVal63 */
						reltInsr1200.setSocnsrAqtnRegVal64(insr1200Vo.getSocnsrAqtnRegVal64());    /** column 사회보험취득신고_ITEM_VALUE64 : socnsrAqtnRegVal64 */
						reltInsr1200.setSocnsrAqtnRegVal65(insr1200Vo.getSocnsrAqtnRegVal65());    /** column 사회보험취득신고_ITEM_VALUE65 : socnsrAqtnRegVal65 */
						reltInsr1200.setSocnsrAqtnRegVal66(insr1200Vo.getSocnsrAqtnRegVal66());    /** column 사회보험취득신고_ITEM_VALUE66 : socnsrAqtnRegVal66 */
						reltInsr1200.setSocnsrAqtnRegVal67(insr1200Vo.getSocnsrAqtnRegVal67());    /** column 사회보험취득신고_ITEM_VALUE67 : socnsrAqtnRegVal67 */
						reltInsr1200.setSocnsrAqtnRegVal68(insr1200Vo.getSocnsrAqtnRegVal68());    /** column 사회보험취득신고_ITEM_VALUE68 : socnsrAqtnRegVal68 */
						reltInsr1200.setSocnsrAqtnRegVal69(insr1200Vo.getSocnsrAqtnRegVal69());    /** column 사회보험취득신고_ITEM_VALUE69 : socnsrAqtnRegVal69 */
						reltInsr1200.setSocnsrAqtnRegVal70(insr1200Vo.getSocnsrAqtnRegVal70());    /** column 사회보험취득신고_ITEM_VALUE70 : socnsrAqtnRegVal70 */
						reltInsr1200.setSocnsrAqtnRegVal71(insr1200Vo.getSocnsrAqtnRegVal71());    /** column 사회보험취득신고_ITEM_VALUE71 : socnsrAqtnRegVal71 */
						reltInsr1200.setSocnsrAqtnRegVal72(insr1200Vo.getSocnsrAqtnRegVal72());    /** column 사회보험취득신고_ITEM_VALUE72 : socnsrAqtnRegVal72 */
						reltInsr1200.setSocnsrAqtnRegVal73(insr1200Vo.getSocnsrAqtnRegVal73());    /** column 사회보험취득신고_ITEM_VALUE73 : socnsrAqtnRegVal73 */
						reltInsr1200.setSocnsrAqtnRegVal74(insr1200Vo.getSocnsrAqtnRegVal74());    /** column 사회보험취득신고_ITEM_VALUE74 : socnsrAqtnRegVal74 */
						reltInsr1200.setSocnsrAqtnRegVal75(insr1200Vo.getSocnsrAqtnRegVal75());    /** column 사회보험취득신고_ITEM_VALUE75 : socnsrAqtnRegVal75 */
						reltInsr1200.setSocnsrAqtnRegVal76(insr1200Vo.getSocnsrAqtnRegVal76());    /** column 사회보험취득신고_ITEM_VALUE76 : socnsrAqtnRegVal76 */
						reltInsr1200.setSocnsrAqtnRegVal77(insr1200Vo.getSocnsrAqtnRegVal77());    /** column 사회보험취득신고_ITEM_VALUE77 : socnsrAqtnRegVal77 */
						reltInsr1200.setSocnsrAqtnRegVal78(insr1200Vo.getSocnsrAqtnRegVal78());    /** column 사회보험취득신고_ITEM_VALUE78 : socnsrAqtnRegVal78 */
						reltInsr1200.setSocnsrAqtnRegVal79(insr1200Vo.getSocnsrAqtnRegVal79());    /** column 사회보험취득신고_ITEM_VALUE79 : socnsrAqtnRegVal79 */
						reltInsr1200.setSocnsrAqtnRegVal80(insr1200Vo.getSocnsrAqtnRegVal80());    /** column 사회보험취득신고_ITEM_VALUE80 : socnsrAqtnRegVal80 */ 
	
						reltInsr1200.setEmymtDivCd(insr1200Vo.getEmymtDivCd());						/** column 고용구분코드 : emymtDivCd */
						reltInsr1200.setEmymtDivNm(insr1200Vo.getEmymtDivNm());    					/** column 고용구분 : emymtDivNm */
						reltInsr1200.setDeptCd(insr1200Vo.getDeptCd());    								/** column 부서코드 : deptCd */
						reltInsr1200.setDeptNm(insr1200Vo.getDeptNm());    								/** column 부서 : deptNm */
						reltInsr1200.setTypOccuCd(insr1200Vo.getTypOccuCd());   						/** column 직종코드 : typOccuCd */
						reltInsr1200.setTypOccuNm(insr1200Vo.getTypOccuNm());    						/** column 직종 : typOccuNm */
						reltInsr1200.setPyspGrdeCd(insr1200Vo.getPyspGrdeCd());    						/** column 호봉등급코드 : pyspGrdeCd */
						reltInsr1200.setPyspGrdeNm(insr1200Vo.getPyspGrdeNm());    					/** column 호봉등급 : pyspGrdeNm */
						reltInsr1200.setDtilOccuInttnCd(insr1200Vo.getDtilOccuInttnCd());    			/** column 직종세구분코드 : dtilOccuInttnCd */
						reltInsr1200.setDtilOccuClsDivNm(insr1200Vo.getDtilOccuClsDivNm());   		/** column 직종세구분 : dtilOccuClsDivNm */
						reltInsr1200.setBusinCd(insr1200Vo.getBusinCd());    								/** column 사업코드 : businCd */
						reltInsr1200.setBusinNm(insr1200Vo.getBusinNm());    								/** column 사업 : businNm */
	
				   } else {
					   MSFErrorMessage errMsg = new MSFErrorMessage("4대보험취득신고", "", 5, "데이타가 존재하지 않습니다."); 
					   throw MSFServerUtils.getValidationException("activityOnReadInsr1200", errMsg, logger) ; 
				   }
	     
	       
	   }  catch (Exception ex) {
	       ex.printStackTrace();
	       
	       /** 에러 로그 **/			
	       MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
	       
	       throw MSFServerUtils.getOperationException("activityOnReadInsr1200", ex, logger);
		} finally {
	
		}
	       
	       /** 로그반영
	        * CRUDSBLO
	        * C:create		R:read		U:update
	        * D:delete		S:select	B:배치 
	        * L:로그인		O:로그아웃
	        */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
	       return reltInsr1200;
	  }
	  
	  @Override
	  public Insr1550DTO activityOnReadInsr1500(Insr1550DTO insr1550Dto) throws MSFException {
		  
		  String method = calledClass + ".activityOnReadInsr1500";
		  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		  Insr1550DTO reltInsr1550 = new Insr1550DTO();
		  
		  String windowNm = "사회보험자격취득신고";
		  String windowId = "INSR2100";
		  
		  try {
			//  Insr1200VO  tpInsr1200Vo = new Insr1200VO();
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			  Insr1550VO tpInsr1550Vo = new Insr1550VO();
			  
			  
			  Insr1500VO  insr1500Vo = new Insr1500VO();
			  
			  tpInsr1550Vo.setDpobCd(insr1550Dto.getDpobCd());    										/** column 사업장코드 : dpobCd */
			  tpInsr1550Vo.setSystemkey(insr1550Dto.getSystemkey());   								 	/** column SYSTEMKEY : systemkey */
			  tpInsr1550Vo.setSoctyInsurCmptnDt(insr1550Dto.getSoctyInsurCmptnDt());    			/** column 사회보험작성일자 : soctyInsurCmptnDt */
			  tpInsr1550Vo.setSocInsrAqtnEmymtNum(insr1550Dto.getSocInsrAqtnEmymtNum());    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
			  tpInsr1550Vo.setFamyQuftDivCd(insr1550Dto.getFamyQuftDivCd());
			  
			  
			  insr1500Vo = insr1500DAO.selectInsr1500(tpInsr1550Vo);
			  
			  if (MSFSharedUtils.paramNotNull(insr1500Vo) && MSFSharedUtils.paramNotNull(insr1500Vo.getSystemkey())) {

				  reltInsr1550.setDpobCd(insr1500Vo.getDpobCd());               
				  reltInsr1550.setSystemkey(insr1500Vo.getSystemkey());            
				  reltInsr1550.setFamyAqtnLssNum(insr1500Vo.getFamyAqtnLssNum());       
				  reltInsr1550.setInsrDpobNum(insr1500Vo.getInsrDpobNum());          
				  reltInsr1550.setInsrDpobNm(insr1500Vo.getInsrDpobNm());           
				  reltInsr1550.setInsrDpobPhnNum(insr1500Vo.getInsrDpobPhnNum());       
				  reltInsr1550.setInsrUsePhnNum(insr1500Vo.getInsrUsePhnNum());       
				  reltInsr1550.setHanNm(insr1500Vo.getHanNm());      
				  
				  
				  String strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr1500Vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				  
				  reltInsr1550.setResnRegnNum(strValue); 
				  
				  reltInsr1550.setNatnCd(insr1500Vo.getNatnCd());               
				  reltInsr1550.setNatnNm(insr1500Vo.getNatnNm());               
				  
				  
				  String strValue2 = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(insr1500Vo.getUseResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
				  
				  reltInsr1550.setUseResnRegnNum(strValue2);  
				  
				  reltInsr1550.setEmymtDivCd(insr1500Vo.getEmymtDivCd());           
				  reltInsr1550.setEmymtDivNm(insr1500Vo.getEmymtDivNm());           
				  reltInsr1550.setDeptCd(insr1500Vo.getDeptCd());               
				  reltInsr1550.setDeptNm(insr1500Vo.getDeptNm());               
				  reltInsr1550.setTypOccuCd(insr1500Vo.getTypOccuCd());            
				  reltInsr1550.setTypOccuNm(insr1500Vo.getTypOccuNm());            
				  reltInsr1550.setPyspGrdeCd(insr1500Vo.getPyspGrdeCd());           
				  reltInsr1550.setPyspGrdeNm(insr1500Vo.getPyspGrdeNm());           
				  reltInsr1550.setBusinCd(insr1500Vo.getBusinCd());              
				  reltInsr1550.setBusinNm(insr1500Vo.getBusinNm());              
				  reltInsr1550.setDtilOccuClsDivCd(insr1500Vo.getDtilOccuClsDivCd());     
				  reltInsr1550.setDtilOccuInttnCd(insr1500Vo.getDtilOccuInttnCd());      
				  reltInsr1550.setDtilOccuClsDivNm(insr1500Vo.getDtilOccuClsDivNm());     
				  reltInsr1550.setFamyQuftDivCdAqtn(insr1500Vo.getFamyQuftDivCdAqtn());
				  reltInsr1550.setFamyQuftDivCdLss(insr1500Vo.getFamyQuftDivCdLss());
				  
				  
			  } 
		  }  
		  
		  catch (Exception ex) {
			  ex.printStackTrace();
			  
			  /** 에러 로그 **/			
			  MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
			  
			  throw MSFServerUtils.getOperationException("activityOnReadInsr1500", ex, logger);
		  }
		  finally {
			  
		  }
		  
		  /** 로그반영
		   * CRUDSBLO
		   * C:create		R:read		U:update
		   * D:delete		S:select	B:배치 
		   * L:로그인		O:로그아웃
		   */
		  MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		  
		  return reltInsr1550;
	  }
	  
	    /**
	     * 삭제처리 로직  TODO  차후 멀티건에 대한 삭제 기능 추가 
	 */
	@Override
	 	public Long activityOnDeleteInsr2100(Insr1100DTO insr1100Dto) throws MSFException { 
		
		    Long result = new Long(0); 
	        
	       // MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	
	try {  
	    
		if  (MSFSharedUtils.paramNull(insr1100DAO)) {
	        
	    	WebApplicationContext wac = WebApplicationContextUtils.
	                getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	
	    	insr1100DAO = (Insr1100DAO) wac.getBean("Insr1100DAO" ); 
	    }
		
	if  (MSFSharedUtils.paramNull(insr1200DAO)) {
			       	        
	    	WebApplicationContext wac = WebApplicationContextUtils.
	                getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	
	    	insr1200DAO = (Insr1200DAO) wac.getBean("Insr1200DAO" ); 
	    }
	
	if  (MSFSharedUtils.paramNull(insr1300DAO)) {
	        
	   	WebApplicationContext wac = WebApplicationContextUtils.
	               getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	
	   	insr1300DAO = (Insr1300DAO) wac.getBean("Insr1300DAO" ); 
	   }
	    
	  Insr1100VO  insr1100Vo = new Insr1100VO();
	  Insr1200VO  insr1200Vo = new Insr1200VO();
	  Insr1300VO  insr1300Vo = new Insr1300VO();
	
	  insr1100Vo.setDpobCd(insr1100Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
	  insr1100Vo.setSystemkey(insr1100Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
	  insr1100Vo.setSoctyInsurCmptnDt(insr1100Dto.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
	  insr1100Vo.setSocInsrAqtnEmymtNum(insr1100Dto.getSocInsrAqtnEmymtNum().longValue());    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	  
	  insr1200Vo.setDpobCd(insr1100Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
	  insr1200Vo.setSystemkey(insr1100Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
	  insr1200Vo.setSoctyInsurCmptnDt(insr1100Dto.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
	  insr1200Vo.setSocInsrAqtnEmymtNum(insr1100Dto.getSocInsrAqtnEmymtNum());    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	  
	  insr1300Vo.setDpobCd(insr1100Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
	  insr1300Vo.setSystemkey(insr1100Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
	  insr1300Vo.setSoctyInsurCmptnDt(insr1100Dto.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
	  insr1300Vo.setSocInsrAqtnEmymtNum(new BigDecimal(insr1100Dto.getSocInsrAqtnEmymtNum()));    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	  
	  insr1300DAO.deleteInsr1300(insr1300Vo);			
	  insr1200DAO.deleteInsr1200(insr1200Vo);
	  insr1100DAO.deleteInsr1100(insr1100Vo);
	  
	  result = 1L;
	  
	}
	catch (Exception ex) {
	    logger.error("EXCEPTION calling activityOnDeleteInsr2100(): "+ex); 
	
	result = new Long(0);
	throw MSFServerUtils.getOperationException("activityOnDeleteInsr2100", ex, logger);
	        }
	        finally {
	          
	        }
	        
	        return result;
	} 
	
	@Override
	 	public Long activityOnUpdateInsr2100(Insr1200DTO insr1200Dto) throws MSFException {
		    Long result = new Long(0);
	       
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        try {  
	            
	        
	        if  (MSFSharedUtils.paramNull(insr1100DAO)) {
	       	        
	   	        	WebApplicationContext wac = WebApplicationContextUtils.
	   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	
	   	        	insr1100DAO = (Insr1100DAO) wac.getBean("Insr1100DAO" ); 
	    }
		
	if  (MSFSharedUtils.paramNull(insr1200DAO)) {
			       	        
	    	WebApplicationContext wac = WebApplicationContextUtils.
	                getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	
	    	insr1200DAO = (Insr1200DAO) wac.getBean("Insr1200DAO" ); 
	    }
	
	if  (MSFSharedUtils.paramNull(insr1300DAO)) {
	        
	   	WebApplicationContext wac = WebApplicationContextUtils.
	               getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	
	   	insr1300DAO = (Insr1300DAO) wac.getBean("Insr1300DAO" ); 
	   }
	    
	  Insr1100VO  insr1100Vo = new Insr1100VO();
	  Insr1200VO  insr1200Vo = new Insr1200VO();
	  Insr1300VO  insr1300Vo = new Insr1300VO();
	
	  insr1100Vo.setDpobCd(insr1200Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
	  insr1100Vo.setSystemkey(insr1200Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
	  insr1100Vo.setSoctyInsurCmptnDt(insr1200Dto.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
	  insr1100Vo.setSocInsrAqtnEmymtNum(insr1200Dto.getSocInsrAqtnEmymtNum().longValue());    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	  insr1100Vo.setNatnCd(insr1200Dto.getSocnsrAqtnRegVal04());    /** column 국적코드 : natnCd */
	  insr1100Vo.setSocInsrDegtrYn( MSFSharedUtils.convertBooleanToVal(insr1200Dto.getSocnsrAqtnRegVal06()));    /** column 사회보험대표자여부 : socInsrDegtrYn */
	  insr1100Vo.setSocInsrStyQftntCd(insr1200Dto.getSocnsrAqtnRegVal05());    /** column 사회보험체류자격코드 : socInsrStyQftntCd */
	  insr1100Vo.setIsmt(sessionUser.getUsrId());    /** column 입력주소 : inptAddr */ 
	  insr1100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
	   
	  
	  
	  insr1200Vo.setDpobCd(insr1200Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
	  insr1200Vo.setSystemkey(insr1200Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
	  insr1200Vo.setSoctyInsurCmptnDt(insr1200Dto.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
	  insr1200Vo.setSocInsrAqtnEmymtNum(insr1200Dto.getSocInsrAqtnEmymtNum());    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	  
	  String StringnatPennRegrstYn = "";
	String StrinhlthInsrRegrstYn = "";
	String StringumytInsrRegrstYn = "";
	String StringidtlAccdtRegrstYn = "";
	
	if(insr1200Dto.getNatPennRegrstYn()) StringnatPennRegrstYn = "Y"; 
	else StringnatPennRegrstYn = "N"; 
	if(insr1200Dto.getHlthInsrRegrstYn()) StrinhlthInsrRegrstYn = "Y"; 
	else StrinhlthInsrRegrstYn = "N";
	if(insr1200Dto.getUmytInsrRegrstYn()) StringumytInsrRegrstYn = "Y"; 
	else StringumytInsrRegrstYn = "N";
	if(insr1200Dto.getIdtlAccdtRegrstYn()) StringidtlAccdtRegrstYn = "Y"; 
	else StringidtlAccdtRegrstYn = "N";
		
	  String  socnsrAqtnRegVal01 = "";
	  socnsrAqtnRegVal01 = StringnatPennRegrstYn
			              			.concat(StrinhlthInsrRegrstYn)
			              			.concat(StringumytInsrRegrstYn)
			            			.concat(StringidtlAccdtRegrstYn);
			  
	  insr1200Vo.setSocnsrAqtnRegVal01(socnsrAqtnRegVal01);                                                                    
	  insr1200Vo.setSocnsrAqtnRegVal02(insr1200Dto.getSocnsrAqtnRegVal02());   /** column 성명 : socnsrAqtnRegVal02 */                                                                                   
	  insr1200Vo.setSocnsrAqtnRegVal03(insr1200Dto.getSocnsrAqtnRegVal03());   /** column 주민등록번호 : socnsrAqtnRegVal03 */                                                                               
	  insr1200Vo.setSocnsrAqtnRegVal04(insr1200Dto.getSocnsrAqtnRegVal04());   /** column 국적 : socnsrAqtnRegVal04 */                                                                                   
	  insr1200Vo.setSocnsrAqtnRegVal05(insr1200Dto.getSocnsrAqtnRegVal05());   /** column 체류자격 : socnsrAqtnRegVal05 */                                                                                 
	  insr1200Vo.setSocnsrAqtnRegVal06( MSFSharedUtils.convertBooleanToVal(insr1200Dto.getSocnsrAqtnRegVal06()));   /** column 대표자여부 : socnsrAqtnRegVal06 */                                                                                
	  insr1200Vo.setSocnsrAqtnRegVal07(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal07()));   /** column 연금_소득월액 : socnsrAqtnRegVal07 */                                                                              
	  insr1200Vo.setSocnsrAqtnRegVal08(MSFSharedUtils.convertBooleanToVal(insr1200Dto.getSocnsrAqtnRegVal08()));   /** column 연금_취득월납부여부 : socnsrAqtnRegVal08 */                                                                           
	  insr1200Vo.setSocnsrAqtnRegVal09(insr1200Dto.getSocnsrAqtnRegVal09());   /** column 연금_취득부호 : socnsrAqtnRegVal09 */                                                                              
	  insr1200Vo.setSocnsrAqtnRegVal10(insr1200Dto.getSocnsrAqtnRegVal10());   /** column 연금_자격취득일 : socnsrAqtnRegVal10 */                                                                             
	  insr1200Vo.setSocnsrAqtnRegVal11(insr1200Dto.getSocnsrAqtnRegVal11());   /** column 연금_특수직종 : socnsrAqtnRegVal11 */                                                                              
	  insr1200Vo.setSocnsrAqtnRegVal12(insr1200Dto.getSocnsrAqtnRegVal12());   /** column 연금_직역연금부호 : socnsrAqtnRegVal12 */                                                                            
	  insr1200Vo.setSocnsrAqtnRegVal13(insr1200Dto.getSocnsrAqtnRegVal13());   /** column 건강_단위사업장기호 : socnsrAqtnRegVal13 */                                                                           
	  insr1200Vo.setSocnsrAqtnRegVal14(insr1200Dto.getSocnsrAqtnRegVal14());   /** column 건강_단위사업장명칭 : socnsrAqtnRegVal14 */                                                                           
	  insr1200Vo.setSocnsrAqtnRegVal15(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal15()));   /** column 건강_보수월액 : socnsrAqtnRegVal15 */                                                                              
	  insr1200Vo.setSocnsrAqtnRegVal16(insr1200Dto.getSocnsrAqtnRegVal16());   /** column 건강_취득부호 : socnsrAqtnRegVal16 */                                                                              
	  insr1200Vo.setSocnsrAqtnRegVal17(insr1200Dto.getSocnsrAqtnRegVal17());   /** column 건강_자격취득일 : socnsrAqtnRegVal17 */                                                                             
	  insr1200Vo.setSocnsrAqtnRegVal18(insr1200Dto.getSocnsrAqtnRegVal18());   /** column 건강_감면 : socnsrAqtnRegVal18 */                                                                                
	  insr1200Vo.setSocnsrAqtnRegVal19(MSFSharedUtils.convertBooleanToVal(insr1200Dto.getSocnsrAqtnRegVal19()));   /** column 건강_건강보험증 발송여부 : socnsrAqtnRegVal19 */                                                                        
	  insr1200Vo.setSocnsrAqtnRegVal20(insr1200Dto.getSocnsrAqtnRegVal20());   /** column 건강_회계 : socnsrAqtnRegVal20 */                                                                                
	  insr1200Vo.setSocnsrAqtnRegVal21(insr1200Dto.getSocnsrAqtnRegVal21());   /** column 건강_직종 : socnsrAqtnRegVal21 */     
	  insr1200Vo.setSocnsrAqtnRegVal22(insr1200Dto.getSocnsrAqtnRegVal22());   /** column 고용_자격취득일 : socnsrAqtnRegVal22 */                                                                             
	  insr1200Vo.setSocnsrAqtnRegVal23(insr1200Dto.getSocnsrAqtnRegVal23());   /** column 고용_직종 : socnsrAqtnRegVal23 */                                                                                
	  insr1200Vo.setSocnsrAqtnRegVal24(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal24()));   /** column 고용_주소정근로시간 : socnsrAqtnRegVal24 */                                                                           
	  insr1200Vo.setSocnsrAqtnRegVal25(MSFSharedUtils.convertBooleanToVal(insr1200Dto.getSocnsrAqtnRegVal25()));   /** column 고용_계약직여부 : socnsrAqtnRegVal25 */                                                                             
	  insr1200Vo.setSocnsrAqtnRegVal26(insr1200Dto.getSocnsrAqtnRegVal26());   /** column 고용_계약직종료년월 : socnsrAqtnRegVal26 */                                                                           
	  insr1200Vo.setSocnsrAqtnRegVal27(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal27()));   /** column 고용_월평균보수 : socnsrAqtnRegVal27 */                                                                             
	  insr1200Vo.setSocnsrAqtnRegVal28(insr1200Dto.getSocnsrAqtnRegVal28());   /** column 고용_비고 : socnsrAqtnRegVal28 */                                                                                
	  insr1200Vo.setSocnsrAqtnRegVal29(insr1200Dto.getSocnsrAqtnRegVal29());   /** column 고용_보험료부과구분부호 : socnsrAqtnRegVal29 */                                                                         
	  insr1200Vo.setSocnsrAqtnRegVal30(insr1200Dto.getSocnsrAqtnRegVal30());   /** column 고용_보험료부과사유 : socnsrAqtnRegVal30 */   
	  insr1200Vo.setSocnsrAqtnRegVal31(insr1200Dto.getSocnsrAqtnRegVal31());   /** column 산재_자격취득일 : socnsrAqtnRegVal31 */                                                                             
	  insr1200Vo.setSocnsrAqtnRegVal32(insr1200Dto.getSocnsrAqtnRegVal32());   /** column 산재_직종 : socnsrAqtnRegVal32 */                                                                                
	  insr1200Vo.setSocnsrAqtnRegVal33(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal33()));   /** column 산재_주소정근로시간 : socnsrAqtnRegVal33 */                                                                           
	  insr1200Vo.setSocnsrAqtnRegVal34(MSFSharedUtils.convertBooleanToVal(insr1200Dto.getSocnsrAqtnRegVal34()));   /** column 산재_계약직여부 : socnsrAqtnRegVal34 */                                                                             
	  insr1200Vo.setSocnsrAqtnRegVal35(insr1200Dto.getSocnsrAqtnRegVal35());   /** column 산재_계약직종료년월 : socnsrAqtnRegVal35 */                                                                           
	  insr1200Vo.setSocnsrAqtnRegVal36(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal36()));   /** column 산재_월평균보수 : socnsrAqtnRegVal36 */                                                                             
	  insr1200Vo.setSocnsrAqtnRegVal37(insr1200Dto.getSocnsrAqtnRegVal37());   /** column 산재_비고 : socnsrAqtnRegVal37 */                                                                                
	  insr1200Vo.setSocnsrAqtnRegVal38(insr1200Dto.getSocnsrAqtnRegVal38());   /** column 산재_보험료부과구분부호 : socnsrAqtnRegVal38 */                                                                         
	  insr1200Vo.setSocnsrAqtnRegVal39(insr1200Dto.getSocnsrAqtnRegVal39());   /** column 산재_보험료부과구분사유 : socnsrAqtnRegVal39 */     
	  insr1200Vo.setIsmt(sessionUser.getUsrId());    /** column 입력주소 : inptAddr */ 
	  insr1200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
	   
	  
	  insr1300Vo.setDpobCd(insr1200Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
	  insr1300Vo.setSystemkey(insr1200Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
	  insr1300Vo.setSoctyInsurCmptnDt(insr1200Dto.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
	  insr1300Vo.setSocInsrAqtnEmymtNum(new BigDecimal(insr1200Dto.getSocInsrAqtnEmymtNum()));    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	  insr1300Vo.setNatPennIncmMnthAmnt(new BigDecimal(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal15())));    /** column 국민연금소득월액 : natPennIncmMnthAmnt */
	  insr1300Vo.setHlthInsrMnthRuntnAmnt(new BigDecimal(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal15())));    /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
	  insr1300Vo.setUmytInsrPayMnthAmnt(new BigDecimal(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal27())));    /** column 고용보험보수월액 : umytInsrPayMnthAmnt */
	  insr1300Vo.setIdtlAccdtPayMnthAmnt(new BigDecimal(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal36())));    /** column 산재보험보수월액 : idtlAccdtPayMnthAmnt */
	  insr1300Vo.setIsmt(sessionUser.getUsrId());    /** column 입력주소 : inptAddr */ 
	  insr1300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
	  
	  insr1100DAO.updateInsr2100ToInsr1100(insr1100Vo);
	  insr1200DAO.updateInsr1200(insr1200Vo);
	  insr1300DAO.updateInsr1300(insr1300Vo);			
	  
	  result = 1L; 
	  
	}
	catch (Exception ex) {
	    logger.error("EXCEPTION calling activityOnUpdateInsr2100(): "+ex); 
	
	result = new Long(0);
	throw MSFServerUtils.getOperationException("activityOnUpdateInsr2100", ex, logger);
	        }
	        finally {
	          
	        }
	        
	        return result;
	}
	
	@Override
	public Long activityOnInsertInsr2100(List<BaseModel> mapModels) throws MSFException {
		Long result = new Long(0);
		Long iCnt = new Long(0);
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
		try {
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			if  (MSFSharedUtils.paramNull(insr1100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				insr1100DAO = (Insr1100DAO) wac.getBean("Insr1100DAO" );
			}
			if  (MSFSharedUtils.paramNull(insr1200DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				insr1200DAO = (Insr1200DAO) wac.getBean("Insr1200DAO" );
			}
			if  (MSFSharedUtils.paramNull(insr1300DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				insr1300DAO = (Insr1300DAO) wac.getBean("Insr1300DAO" );
			}
			
			Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
			
			while (iterRecords.hasNext()) {
				
				BaseModel bmMapModel = (BaseModel) iterRecords.next(); 
	    
				Insr1100VO  insr1100Vo = new Insr1100VO();
				Insr1200VO  insr1200Vo = new Insr1200VO();
				Insr1300VO  insr1300Vo = new Insr1300VO();
				
				insr1100Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
				insr1100Vo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
				insr1100Vo.setSoctyInsurCmptnDt("");    /** column 사회보험작성일자 : soctyInsurCmptnDt */
				//BigDecimal bigDecimal =  (BigDecimal) bmMapModel.get("socInsrAqtnEmymtNum"); /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */	
				//insr1100Vo.setSocInsrAqtnEmymtNum(bigDecimal.longValue());    
				insr1100Vo.setNatnCd("");    /** column 국적코드 : natnCd */
				insr1100Vo.setSocInsrDegtrYn("2");    /** column 사회보험대표자여부 : socInsrDegtrYn */
				insr1100Vo.setSocInsrStyQftntCd("");    /** column 사회보험체류자격코드 : socInsrStyQftntCd */
				insr1100Vo.setHlthInsrRegrstYn("N");    /** column 건강보험신고여부 : hlthInsrRegrstYn */
				insr1100Vo.setNatPennRegrstYn("N");    /** column 국민연금신고여부 : natPennRegrstYn */
				insr1100Vo.setUmytInsrRegrstYn("N");    /** column 고용보험신고여부 : umytInsrRegrstYn */
				insr1100Vo.setIdtlAccdtRegrstYn("N");    /** column 산재보험신고여부 : idtlAccdtRegrstYn */
				insr1100Vo.setKybdr(sessionUser.getUsrId());    /** column 입력주소 : inptAddr */ 
				insr1100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */

				insr1200Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
				insr1200Vo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
				insr1200Vo.setSoctyInsurCmptnDt("");    /** column 사회보험작성일자 : soctyInsurCmptnDt */
				//insr1200Vo.setSocInsrAqtnEmymtNum(BigDecimal.ZERO);    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
				insr1200Vo.setSocnsrAqtnRegVal01("YYYY"); 
				insr1200Vo.setSocnsrAqtnRegVal02(MSFSharedUtils.allowNulls(bmMapModel.get("hanNm")));  /*성명*/ 
				//insr1200Vo.setSocnsrAqtnRegVal03(MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")).replace("-", ""));  /*주민등록번호*/ 
				
				insr1200Vo.setSocnsrAqtnRegVal03(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(bmMapModel.get("resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
				
				insr1200Vo.setSocnsrAqtnRegVal04(MSFSharedUtils.allowNulls(bmMapModel.get("natnCd")));    //국가코드
				insr1200Vo.setSocnsrAqtnRegVal10(MSFSharedUtils.allowNulls(bmMapModel.get("frstEmymtDt")));	// 최초고용일자	 
				insr1200Vo.setSocnsrAqtnRegVal17(MSFSharedUtils.allowNulls(bmMapModel.get("frstEmymtDt")));	// 최초고용일자	 
				insr1200Vo.setSocnsrAqtnRegVal22(MSFSharedUtils.allowNulls(bmMapModel.get("frstEmymtDt")));	// 최초고용일자	 
				insr1200Vo.setSocnsrAqtnRegVal31(MSFSharedUtils.allowNulls(bmMapModel.get("frstEmymtDt")));	// 최초고용일자	 
				insr1200Vo.setSocnsrAqtnRegVal24(ExtermsProps.USR_WEEK_WORK_TIME);	// 최초고용일자	 
				insr1200Vo.setSocnsrAqtnRegVal33(ExtermsProps.USR_WEEK_WORK_TIME);	// 최초고용일자	 
				insr1200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력주소 : inptAddr */ 
				insr1200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */

				insr1300Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
				insr1300Vo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
				insr1300Vo.setSoctyInsurCmptnDt("");    /** column 사회보험작성일자 : soctyInsurCmptnDt */
				//insr1300Vo.setSocInsrAqtnEmymtNum(BigDecimal.ZERO);    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
				insr1300Vo.setNatPennIncmMnthAmnt(BigDecimal.ZERO);    /** column 국민연금소득월액 : natPennIncmMnthAmnt */
				insr1300Vo.setHlthInsrMnthRuntnAmnt(BigDecimal.ZERO);    /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
				insr1300Vo.setUmytInsrPayMnthAmnt(BigDecimal.ZERO);    /** column 고용보험보수월액 : umytInsrPayMnthAmnt */
				insr1300Vo.setIdtlAccdtPayMnthAmnt(BigDecimal.ZERO);    /** column 산재보험보수월액 : idtlAccdtPayMnthAmnt */
				insr1300Vo.setKybdr(sessionUser.getUsrId());    /** column 입력주소 : inptAddr */ 
				insr1300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
			 
				Long socInsrAqtnEmymtNum = insr1200DAO.getInsr1200EmymtSeilNum(insr1200Vo);
				System.out.println("==========================> socInsrAqtnEmymtNum  : " +socInsrAqtnEmymtNum);
				insr1200Vo.setSocInsrAqtnEmymtNum(socInsrAqtnEmymtNum);    /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
				
				if( 0 < insr1200DAO.selectInsr1200Chk(insr1200Vo) ){
					System.out.println("==========================> insr1200DAO.selectInsr1200Chk  : 이미 등록된 대상자 ");
				}
				// 등록전
				else{
					insr1100DAO.insertInsr1100(insr1100Vo); 
					insr1200DAO.insertInsr1200(insr1200Vo);
					insr1300DAO.insertInsr1300(insr1300Vo);

					iCnt = iCnt + 1;
				}
			}
			
			result = iCnt;
		}
		catch (Exception ex) {
			logger.error("EXCEPTION calling activityOnDlgn0250(): "+ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnDlgn0250", ex, logger);
		}
		finally {
			
		}
		
		return result;
	}
	
	@Override
	 	public Long updateInsr2100AllGridBatch(List<Insr1200DTO> mapModels) throws MSFException {
		    Long result = new Long(0);
		    Long iCnt = new Long(0);
		    
		    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	
		    try {
	    		if  (MSFSharedUtils.paramNull(insr1200DAO)) {
	
	        		WebApplicationContext wac = WebApplicationContextUtils.
	        		getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	
	        		insr1200DAO = (Insr1200DAO) wac.getBean("Insr1200DAO" ); 
	}
	
	Iterator<Insr1200DTO> iterRecords = (Iterator<Insr1200DTO>)mapModels.iterator();
	
	while (iterRecords.hasNext()) {
		
		Insr1200DTO insr1200Dto = (Insr1200DTO) iterRecords.next(); 
		Insr1200VO  insr1200Vo = new Insr1200VO();
	
		insr1200Vo.setDpobCd(MSFSharedUtils.allowNulls(insr1200Dto.getDpobCd()));    /** column 사업장코드 : dpobCd */
	insr1200Vo.setSystemkey(MSFSharedUtils.allowNulls(insr1200Dto.getSystemkey()));    /** column SYSTEMKEY : systemkey */
	insr1200Vo.setSoctyInsurCmptnDt(insr1200Dto.getSoctyInsurCmptnDt());    /** column 사회보험작성일자 : soctyInsurCmptnDt */
	
	if (insr1200Dto.getBatchDiv().equals("VAL01")) { // 신고구분 변경
		String StringnatPennRegrstYn ="";
		String StrinhlthInsrRegrstYn ="";
		String StringumytInsrRegrstYn ="";
		String StringidtlAccdtRegrstYn ="";
	
		if(insr1200Dto.getNatPennRegrstYn()) StringnatPennRegrstYn = "Y"; 
		else StringnatPennRegrstYn = "N"; 
		if(insr1200Dto.getHlthInsrRegrstYn()) StrinhlthInsrRegrstYn = "Y"; 
		else StrinhlthInsrRegrstYn = "N";
		if(insr1200Dto.getUmytInsrRegrstYn()) StringumytInsrRegrstYn = "Y"; 
		else StringumytInsrRegrstYn = "N";
		if(insr1200Dto.getIdtlAccdtRegrstYn()) StringidtlAccdtRegrstYn = "Y"; 
		else StringidtlAccdtRegrstYn = "N";
	
		String  socnsrAqtnRegVal01 = "";
		socnsrAqtnRegVal01 = StringnatPennRegrstYn
				        			.concat(StrinhlthInsrRegrstYn)
				        			.concat(StringumytInsrRegrstYn)
				        			.concat(StringidtlAccdtRegrstYn);
	
		insr1200Vo.setSocnsrAqtnRegVal01(socnsrAqtnRegVal01);
	}
	
	if (insr1200Dto.getBatchDiv().equals("VAL07")) { // 국민_소득월액
		insr1200Vo.setSocnsrAqtnRegVal07(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal07()));
	}
	if (insr1200Dto.getBatchDiv().equals("VAL08")) { // 국민_취득월납부여부
		if ( insr1200Dto.getSocnsrAqtnRegVal08() ) insr1200Vo.setSocnsrAqtnRegVal08("1");
		else insr1200Vo.setSocnsrAqtnRegVal08("2");
	}
	if (insr1200Dto.getBatchDiv().equals("VAL09")) { // 국민_취득부호
		insr1200Vo.setSocnsrAqtnRegVal09(insr1200Dto.getSocnsrAqtnRegVal09());
	}
	if (insr1200Dto.getBatchDiv().equals("VAL10")) { // 국민_자격취득일
		insr1200Vo.setSocnsrAqtnRegVal10(insr1200Dto.getSocnsrAqtnRegVal10());
	}
	if (insr1200Dto.getBatchDiv().equals("VAL11")) { // 국민_자격취득일
		insr1200Vo.setSocnsrAqtnRegVal11(insr1200Dto.getSocnsrAqtnRegVal11());
	}
	if (insr1200Dto.getBatchDiv().equals("VAL12")) { // 국민_자격취득일
		insr1200Vo.setSocnsrAqtnRegVal12(insr1200Dto.getSocnsrAqtnRegVal12());
	}
	
	if (insr1200Dto.getBatchDiv().equals("VAL15")) { //건강_보수월액
		insr1200Vo.setSocnsrAqtnRegVal15(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal15()));
	}
	if (insr1200Dto.getBatchDiv().equals("VAL17")) { //건강_자격취득일
		insr1200Vo.setSocnsrAqtnRegVal17(insr1200Dto.getSocnsrAqtnRegVal17());
	}
	if (insr1200Dto.getBatchDiv().equals("VAL16")) { //건강_취득부호
		insr1200Vo.setSocnsrAqtnRegVal16(insr1200Dto.getSocnsrAqtnRegVal16());
	}
	if (insr1200Dto.getBatchDiv().equals("VAL18")) { //건강_감면부호
		insr1200Vo.setSocnsrAqtnRegVal18(insr1200Dto.getSocnsrAqtnRegVal18());
	}
	if (insr1200Dto.getBatchDiv().equals("VAL19")) { //건강_발송희망
		if ( insr1200Dto.getSocnsrAqtnRegVal19() ) insr1200Vo.setSocnsrAqtnRegVal19("1");
		else insr1200Vo.setSocnsrAqtnRegVal19("2");
	}
	if (insr1200Dto.getBatchDiv().equals("VAL20")) { //건강_회계부호
		insr1200Vo.setSocnsrAqtnRegVal20(insr1200Dto.getSocnsrAqtnRegVal20());
	}
	if (insr1200Dto.getBatchDiv().equals("VAL21")) { //건강_직종부호
		insr1200Vo.setSocnsrAqtnRegVal21(insr1200Dto.getSocnsrAqtnRegVal21());
	}
	
	if (insr1200Dto.getBatchDiv().equals("VAL27")) { //고용_월평균보수
		insr1200Vo.setSocnsrAqtnRegVal27(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal27()));   
	}
	if (insr1200Dto.getBatchDiv().equals("VAL22")) { //고용_취득일
		insr1200Vo.setSocnsrAqtnRegVal22(insr1200Dto.getSocnsrAqtnRegVal22());   
	}
	if (insr1200Dto.getBatchDiv().equals("VAL24")) { //고용_주소정근로
		insr1200Vo.setSocnsrAqtnRegVal24(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal24())); 
	}
	if (insr1200Dto.getBatchDiv().equals("VAL23")) { //고용_직종
		insr1200Vo.setSocnsrAqtnRegVal23(insr1200Dto.getSocnsrAqtnRegVal23());
	}
	if (insr1200Dto.getBatchDiv().equals("VAL25")) { //고용_계약직여부
		if( insr1200Dto.getSocnsrAqtnRegVal25() ) insr1200Vo.setSocnsrAqtnRegVal25("1");
		else insr1200Vo.setSocnsrAqtnRegVal25("2");
	}
	if (insr1200Dto.getBatchDiv().equals("VAL26")) { //고용_계약종료월
		insr1200Vo.setSocnsrAqtnRegVal26(insr1200Dto.getSocnsrAqtnRegVal26()); 
	}
	if (insr1200Dto.getBatchDiv().equals("VAL29")) { //고용_부과구분부호
		insr1200Vo.setSocnsrAqtnRegVal29(insr1200Dto.getSocnsrAqtnRegVal29());
	}
	if (insr1200Dto.getBatchDiv().equals("VAL30")) { //고용_부과구분사유
		insr1200Vo.setSocnsrAqtnRegVal30(insr1200Dto.getSocnsrAqtnRegVal30()); 
	}
	if (insr1200Dto.getBatchDiv().equals("VAL28")) { //고용_비고
		insr1200Vo.setSocnsrAqtnRegVal28(insr1200Dto.getSocnsrAqtnRegVal28()); 
	}
	
	if (insr1200Dto.getBatchDiv().equals("VAL36")) { //산재_월평균보수
		insr1200Vo.setSocnsrAqtnRegVal36(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal36()));   
	}
	if (insr1200Dto.getBatchDiv().equals("VAL31")) { //산재_취득일
		insr1200Vo.setSocnsrAqtnRegVal31(insr1200Dto.getSocnsrAqtnRegVal31());   
	}
	if (insr1200Dto.getBatchDiv().equals("VAL33")) { //산재_주소정근로
		insr1200Vo.setSocnsrAqtnRegVal33(String.valueOf(insr1200Dto.getSocnsrAqtnRegVal33())); 
	}
	if (insr1200Dto.getBatchDiv().equals("VAL32")) { //산재_직종
		insr1200Vo.setSocnsrAqtnRegVal32(insr1200Dto.getSocnsrAqtnRegVal32());
	}
	if (insr1200Dto.getBatchDiv().equals("VAL34")) { //산재_계약직여부
		if( insr1200Dto.getSocnsrAqtnRegVal34() ) insr1200Vo.setSocnsrAqtnRegVal34("1");
		else insr1200Vo.setSocnsrAqtnRegVal34("2");
	}
	if (insr1200Dto.getBatchDiv().equals("VAL35")) { //산재_계약종료월
		insr1200Vo.setSocnsrAqtnRegVal35(insr1200Dto.getSocnsrAqtnRegVal35()); 
	}
	if (insr1200Dto.getBatchDiv().equals("VAL38")) { //산재_부과구분부호
		insr1200Vo.setSocnsrAqtnRegVal38(insr1200Dto.getSocnsrAqtnRegVal38());
	}
	if (insr1200Dto.getBatchDiv().equals("VAL39")) { //산재_부과구분사유
		insr1200Vo.setSocnsrAqtnRegVal39(insr1200Dto.getSocnsrAqtnRegVal39()); 
	}
	if (insr1200Dto.getBatchDiv().equals("VAL37")) { //산재_비고
		insr1200Vo.setSocnsrAqtnRegVal37(insr1200Dto.getSocnsrAqtnRegVal37()); 
	}
	
	insr1200Vo.setSocInsrAqtnEmymtNum(insr1200Dto.getSocInsrAqtnEmymtNum()); /** set 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	insr1200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 ismt */
	insr1200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
	
			insr1200DAO.updateInsr2100AllGridBatch(insr1200Vo);
	
			iCnt = iCnt + 1;
		}
		result = iCnt;
	}
	catch (Exception ex) {
	    logger.error("EXCEPTION calling updateInsr2100AllGridBatch(): "+ex); 
	
	result = new Long(0);
	throw MSFServerUtils.getOperationException("updateInsr2100AllGridBatch", ex, logger);
	        }
	        finally {
	          
	        }
	        
	        return result;
	}
	
	/**
	 	* 삭제처리 로직  TODO  차후 멀티건에 대한 삭제 기능 추가 
	 */
	@Override
	public Long deleteInsr2100(List<Insr1200DTO> listInsr1200Dto) throws MSFException { 
		Long result = new Long(1);
		Long iCnt = new Long(0);
		
		try {  
	
			if  (MSFSharedUtils.paramNull(insr1100DAO)) {
	        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	        	insr1100DAO = (Insr1100DAO) wac.getBean("Insr1100DAO" ); 
			}
	
			if  (MSFSharedUtils.paramNull(insr1200DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				insr1200DAO = (Insr1200DAO) wac.getBean("Insr1200DAO" ); 
			}
	
			if  (MSFSharedUtils.paramNull(insr1300DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				insr1300DAO = (Insr1300DAO) wac.getBean("Insr1300DAO" ); 
			}
	
			for(int iInsrCnt=0; iInsrCnt < listInsr1200Dto.size(); iInsrCnt++) {
	
				Insr1200DTO Insr1200DTO = new Insr1200DTO();  
				Insr1200DTO = listInsr1200Dto.get(iInsrCnt);   

				Insr1100VO  insr1100Vo = new Insr1100VO();
				Insr1200VO  insr1200Vo = new Insr1200VO();
				Insr1300VO  insr1300Vo = new Insr1300VO();
				
				insr1100Vo.setDpobCd(MSFSharedUtils.allowNulls(Insr1200DTO.getDpobCd()));    /** column 사업장코드 : dpobCd */
				insr1100Vo.setSystemkey(MSFSharedUtils.allowNulls(Insr1200DTO.getSystemkey()));    /** column SYSTEMKEY : systemkey */
				insr1100Vo.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls(Insr1200DTO.getSoctyInsurCmptnDt()));    /** column 사회보험작성일자 : soctyInsurCmptnDt */
				insr1100Vo.setSocInsrAqtnEmymtNum(Insr1200DTO.getSocInsrAqtnEmymtNum()); /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	
				insr1200Vo.setDpobCd(MSFSharedUtils.allowNulls(Insr1200DTO.getDpobCd()));    /** column 사업장코드 : dpobCd */
				insr1200Vo.setSystemkey(MSFSharedUtils.allowNulls(Insr1200DTO.getSystemkey()));    /** column SYSTEMKEY : systemkey */
				insr1200Vo.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls(Insr1200DTO.getSoctyInsurCmptnDt()));    /** column 사회보험작성일자 : soctyInsurCmptnDt */
				insr1200Vo.setSocInsrAqtnEmymtNum(Insr1200DTO.getSocInsrAqtnEmymtNum()); /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	
				insr1300Vo.setDpobCd(MSFSharedUtils.allowNulls(Insr1200DTO.getDpobCd()));    /** column 사업장코드 : dpobCd */
				insr1300Vo.setSystemkey(MSFSharedUtils.allowNulls(Insr1200DTO.getSystemkey()));    /** column SYSTEMKEY : systemkey */
				insr1300Vo.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls(Insr1200DTO.getSoctyInsurCmptnDt()));    /** column 사회보험작성일자 : soctyInsurCmptnDt */
				insr1300Vo.setSocInsrAqtnEmymtNum(new BigDecimal(MSFSharedUtils.defaultNulls(Insr1200DTO.getSocInsrAqtnEmymtNum(),"0"))); /** column 사회보험취득_고용_일련번호 : socInsrAqtnEmymtNum */
	
				insr1100DAO.deleteInsr1100(insr1100Vo);
				insr1200DAO.deleteInsr1200(insr1200Vo);
				insr1300DAO.deleteInsr1300(insr1300Vo);
				
				iCnt = iCnt + 1;
			}
			
			result = iCnt;
		}
		
		catch (Exception ex) {
			logger.error("EXCEPTION calling activityOnDeleteInsr2100(): "+ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnDeleteInsr2100", ex, logger);
		}
		finally {
		}
		
		return result;
	}
			
		@Override
		public Long countInsr1550(List<Insr1200DTO> listInsr1200Dto) throws MSFException {
		
			Long result = new Long(0);
			Long iCnt = new Long(0);
			
			try {
				
				if  (MSFSharedUtils.paramNull(insr1200DAO)) {

					WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				
					insr1200DAO = (Insr1200DAO) wac.getBean("Insr1200DAO" ); 
				}
				
				for(int iInsrCnt=0; iInsrCnt < listInsr1200Dto.size(); iInsrCnt++) {
					
					Insr1200DTO insr1200Dto = new Insr1200DTO();  
					insr1200Dto = listInsr1200Dto.get(iInsrCnt);   

					Insr1550SrhVO  insr1550SrhVo = new Insr1550SrhVO();
					
					insr1550SrhVo.setDpobCd(insr1200Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
					insr1550SrhVo.setSystemkey(insr1200Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
					insr1550SrhVo.setFamyAqtnLssNum((Long)insr1200Dto.getSocInsrAqtnEmymtNum());    /** column 사회보험취득_고용_일련번호 : famyAqtnLssNum */

					int cnt = insr1200DAO.countInsr1550(insr1550SrhVo);

					result = (long) cnt; 
					
					iCnt = iCnt + 1;
				}
				
				result = iCnt;
			}
			catch (Exception ex) {
				logger.error("EXCEPTION calling countInsr1550(): "+ex); 

				result = new Long(0);
				throw MSFServerUtils.getOperationException("countInsr1550", ex, logger);
			}
			finally {

			}

			return result;
	}	 
			
		
		@Override
		public Long activityOnInsr1500(List<Insr1550DTO> listInsr1550DTO, ActionDatabase actionDatabase)  throws MSFException {
			
			Long result = new Long(1);
			Long iCnt = new Long(0);
			
			String windowNm = "사회보험자격취득신고";
			String windowId = "INSR2100";
			
			MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			String method = calledClass + ".List<Insr1550DTO> listInsr1550DTO, ActionDatabase actionDatabase";
			
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
	                
	                
	                //Insr1550Vo.setSocInsrAqtnEmymtNum(Insr1550DTO.getSocInsrAqtnEmymtNum());
	                //Insr1550Vo.setSoctyInsurCmptnDt(Insr1550DTO.getSoctyInsurCmptnDt()); //사회보험취득작성일자
	                //Insr1550Vo.setSocInsrLssCmptnDt(Insr1550DTO.getSocInsrLssCmptnDt());//부양자가 상실될경우 피부양자는 자동으로 상실 되므로 다시 상실될경우가 없음으로 빈값을 셋팅한다.          
	                //Insr1550Vo.setSocInsrLssEmymtNum(Insr1550DTO.getSocInsrLssEmymtNum());
	                
	                
	        	    Insr1550Vo.setFamyAqtnLssNum(Insr1550DTO.getFamyAqtnLssNum()); // 취득일련번호
	                Insr1550Vo.setDpobCd(Insr1550DTO.getDpobCd());    /** column 사업장코드 : dpobCd */
	                Insr1550Vo.setSystemkey(Insr1550DTO.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                Insr1550Vo.setFamySeilNum(Insr1550DTO.getFamySeilNum());    /** column 급여가족사항일련번호 : famySeilNum */
	                Insr1550Vo.setFamyResnRegnNum(Insr1550DTO.getFamyResnRegnNum());    /** column 급여가족주민번호 : famyResnRegnNum */
	                
	                Insr1550Vo.setFamyResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(Insr1550DTO.getFamyResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
	                
	                Insr1550Vo.setFamyNm(Insr1550DTO.getFamyNm());    /** column 한글성명 : famyNm */
	                Insr1550Vo.setFamyRelaDivCd(Insr1550DTO.getFamyRelaDivCd());    /** column 가족관계구분코드 : famyRelaDivCd */
	                Insr1550Vo.setDbpsnNatnCd(Insr1550DTO.getDbpsnNatnCd()); //국적코드
	                Insr1550Vo.setAqtnDivCd(Insr1550DTO.getAqtnDivCd()); //취득구분 
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
	                
//	                System.out.println("2============================================2");
//	                System.out.println("getFamyAqtnLssNum>  "+Insr1550Vo.getFamyAqtnLssNum());
//	                System.out.println("getFamyAqtnLssDt>  "+Insr1550Vo.getFamyAqtnLssDt());
//	                System.out.println("getAqtnDt>  "+Insr1550Vo.getAqtnDt());
//	                System.out.println("getAqtnReasCd>  "+Insr1550Vo.getAqtnReasCd());
//	                System.out.println("getDbpsnAssttnSgnCd>  "+Insr1550Vo.getDbpsnAssttnSgnCd());
//	                System.out.println("getDbpsnGrdeCd>  "+Insr1550Vo.getDbpsnGrdeCd());
//	                System.out.println("getDbpsnRgstnDt>  "+Insr1550Vo.getDbpsnRgstnDt());
//	                System.out.println("getFrgnrStyQftntCd>  "+Insr1550Vo.getFrgnrStyQftntCd());
//	                System.out.println("getFrgnrStyBgnnDt>  "+Insr1550Vo.getFrgnrStyBgnnDt());
//	                System.out.println("getFrgnrStyEndDt>  "+Insr1550Vo.getFrgnrStyEndDt());
//	                System.out.println("getInsrDpobNm>  "+Insr1550Vo.getInsrDpobNm());
//	                System.out.println("getInsrDpobNum>  "+Insr1550Vo.getInsrDpobNum());
//	                System.out.println("getInsrDpobPhnNum>  "+Insr1550Vo.getInsrDpobPhnNum());
//	                System.out.println("getInsrUsePhnNum>  "+Insr1550Vo.getInsrUsePhnNum());
					
					Insr1550Vo.setSocrAqtnFamyYn(Insr1550DTO.getSocrAqtnFamyYn());
					Insr1550Vo.setSocrLssFamyYn(Insr1550DTO.getSocrLssFamyYn());
	                
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
	                				if(iInsrCnt == 0){
	                					//insr1500DAO.updateInsr1500(Insr1550Vo);
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
	                		if(iInsrCnt == 0){            					
        						insr1500DAO.updateInsr1500(Insr1550Vo);
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
				
			}finally {
	          
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
			
		
		//인쇄시 insr1200 업데이트
		@Override
		 public Long activityOnUpdateInsr1200(BaseModel bm) throws MSFException {
			    Long result = new Long(0);
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        List<String> listDeptCd = new ArrayList<String>();
		        
		        Insr1200SrhVO insr1200SrhVo = new Insr1200SrhVO();

		        insr1200SrhVo.setUsrId(sessionUser.getUsrId());  
		        insr1200SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
		        insr1200SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
		        insr1200SrhVo.setSoctyInsurCmptnDt01(MSFSharedUtils.allowNulls(bm.get("soctyInsurCmptnDt01")));
		        insr1200SrhVo.setSoctyInsurCmptnDt02(MSFSharedUtils.allowNulls(bm.get("soctyInsurCmptnDt02")));
				List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(bm.get("hdofcCodtnCd"))); 
				
				
				
				insr1200SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(bm.get("hdofcCodtnCd")));
				insr1200SrhVo.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태
				insr1200SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(bm.get("emymtDivCd")));	         //고용구분
		        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(bm.get("typeOccuCd"))); 
		        insr1200SrhVo.setTypOccuCdArr(lstTypeOccuCd); //직종       
		     	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(bm.get("dtilOccuInttnCd"))); 
		     	insr1200SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세
		     	insr1200SrhVo.setBusinCd(MSFSharedUtils.allowNulls(bm.get("businCd")));   //사업
		        
		     	insr1200SrhVo.setHanNm(MSFSharedUtils.allowNulls(bm.get("hanNm")));			//성명
		     	insr1200SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(bm.get("resnRegnNum")));//주민번호

		     	insr1200SrhVo.setSystemkey(MSFSharedUtils.allowNulls(bm.get("systemkey")));	//시스템키
		        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(bm.get("systemkey"))); 
		        insr1200SrhVo.setSystemKeyArr(systemKeyArr);
		        insr1200SrhVo.setDeptCd(MSFSharedUtils.allowNulls(bm.get("deptCd")));

		        insr1200SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bm.get("payrMangDeptCd")));
	        	insr1200SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr1200SrhVo.getPayrMangDeptCd())); 		        
		        
		        insr1200SrhVo.setDeptCdAuth(insr1200SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
		        insr1200SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr1200SrhVo.getDtilOccuInttnCd()).replace(",", ""));
		        /******************************** 권한 ************************************************************************/
		        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
		        if ("FALSE".equals(chkDeptCd)) {
		        	insr1200SrhVo.setDeptCd(sessionUser.getDeptCd()); 
		           listDeptCd.add(sessionUser.getDeptCd());
		           insr1200SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
		           insr1200SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
		        } else {
		        	    
		        	
		                 if (insr1200SrhVo.getPayrMangDeptCd().equals(insr1200SrhVo.getDeptCd())) { 
		                 	 listDeptCd = null; 
		                 	insr1200SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
		                 	insr1200SrhVo.setDeptCd("");  //부서코드
		                 } else {
		                	 insr1200SrhVo.setDeptCd(MSFSharedUtils.allowNulls(insr1200SrhVo.getDeptCd()));
		                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(insr1200SrhVo.getDeptCd()));  
		                      insr1200SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
		                 } 
		              
		        }
		       
		        
		       /******************************** 권한 ************************************************************************/
		        
		        try {  
		        	if  (MSFSharedUtils.paramNull(insr1100DAO)) {
		        		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
		        		insr1100DAO = (Insr1100DAO) wac.getBean("Insr1100DAO" ); 
		        	}
		        	if  (MSFSharedUtils.paramNull(insr1200DAO)) {
		        		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
		        		insr1200DAO = (Insr1200DAO) wac.getBean("Insr1200DAO" ); 
		        	}
		        	if  (MSFSharedUtils.paramNull(insr1500DAO)) {				        
			        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			        	insr1500DAO = (Insr1500DAO) wac.getBean("Insr1500DAO" ); 
			        }
			
				 List listInsr1200 = insr1200DAO.selectXlsInsr1200List(insr1200SrhVo);

			        for(int i=0; i<listInsr1200.size(); i++){
			        	
			        	EgovMap eMap = (EgovMap)listInsr1200.get(i);
			        	
			        	Insr1100VO insr1100Vo = new  Insr1100VO();
			   	        insr1100Vo.setDpobCd((String)eMap.get("dpobCd"));    /** column 사업장코드 : dpobCd */
			   	        insr1100Vo.setSystemkey(MSFSharedUtils.allowNulls(eMap.get("systemkey")));    /** column SYSTEMKEY : systemkey */
			   	        insr1100Vo.setSoctyInsurCmptnDt(MSFSharedUtils.allowNulls(eMap.get("soctyInsurCmptnDt")));	/*사회보험작성일자*/      
			   	        BigDecimal bigDecimal =  (BigDecimal) eMap.get("socInsrAqtnEmymtNum");
			   	        insr1100Vo.setSocInsrAqtnEmymtNum(bigDecimal.longValue());    /** column 사회보험상실_고용_일련번호 : socInsrAqtnEmymtNum */		   	         
			   	        insr1100Vo.setNatPennRegrstYn((String) eMap.get("natPennRegrstYn"));    /** column 국민연금신고여부 : natPennRegrstYn */
		        		insr1100Vo.setHlthInsrRegrstYn((String) eMap.get("hlthInsrRegrstYn"));    /** column 건강보험신고여부 : hlthInsrRegrstYn */
		        		insr1100Vo.setUmytInsrRegrstYn((String) eMap.get("umytInsrRegrstYn"));    /** column 고용보험신고여부 : umytInsrRegrstYn */
		        		insr1100Vo.setIdtlAccdtRegrstYn((String) eMap.get("idtlAccdtRegrstYn"));    /** column 산재보험신고여부 : idtlAccdtRegrstYn */			   	        
			   	        insr1100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
			   	        insr1100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());			        	
		        		insr1100DAO.updateXlsInsr1100(insr1100Vo);

		            	//피부양자 업데이트				      				        
				        Insr1550VO insr1550Vo = new Insr1550VO();
				        insr1550Vo.setDpobCd((String)eMap.get("dpobCd"));
			   	        insr1550Vo.setSystemkey(MSFSharedUtils.allowNulls(eMap.get("systemkey")));
			   	        insr1550Vo.setFamyAqtnLssNum(bigDecimal.longValue());    /** column 피부양자취득상실_고용일련번호 : famyAqtnLssNum */
			   	        insr1550Vo.setSocrAqtnFamyYn("Y");
			   	        insr1550Vo.setFamyQuftDivCd("I0100001");
			   	        insr1550Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
			   	        insr1550Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
			   	        if(0 < insr1500DAO.selectInsr1550Check(insr1550Vo)){
			   	        	insr1500DAO.updateXlsInsr1550(insr1550Vo);
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
		
		//인쇄시 insr1200 업데이트
				@Override
				 public Long activityOnUpdateInsr1550AndInsr1600(BaseModel bm) throws MSFException {

					   Long result = new Long(0);
					
				        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
				        List<String> listDeptCd = new ArrayList<String>();
				        
				        Insr1550SrhVO insr1550SrhVo = new Insr1550SrhVO();

				        insr1550SrhVo.setUsrId(sessionUser.getUsrId());  
				        insr1550SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
				        insr1550SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
				        insr1550SrhVo.setSoctyInsurCmptnDt01(MSFSharedUtils.allowNulls(bm.get("soctyInsurCmptnDt01")));
				        insr1550SrhVo.setSoctyInsurCmptnDt02(MSFSharedUtils.allowNulls(bm.get("soctyInsurCmptnDt02")));
						List<String> hdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(bm.get("hdofcCodtnCd"))); 

						insr1550SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(bm.get("hdofcCodtnCd")));
						insr1550SrhVo.setHdofcCodtnCdArr(hdofcCodtnCd); //재직상태
						insr1550SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(bm.get("emymtDivCd")));	         //고용구분
				        List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(bm.get("typeOccuCd"))); 
				        insr1550SrhVo.setTypOccuCdArr(lstTypeOccuCd); //직종       
				     	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(bm.get("dtilOccuInttnCd"))); 
				     	insr1550SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  //직종세
				     	insr1550SrhVo.setBusinCd(MSFSharedUtils.allowNulls(bm.get("businCd")));   //사업
				        
				     	insr1550SrhVo.setHanNm(MSFSharedUtils.allowNulls(bm.get("hanNm")));			//성명
				     	insr1550SrhVo.setResnRegnNum(MSFSharedUtils.allowNulls(bm.get("resnRegnNum")));//주민번호

				     	insr1550SrhVo.setSystemkey(MSFSharedUtils.allowNulls(bm.get("systemkey")));	//시스템키
				        List<String> systemKeyArr = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(bm.get("systemkey"))); 
				        insr1550SrhVo.setSystemKeyArr(systemKeyArr);
				        insr1550SrhVo.setDeptCd(MSFSharedUtils.allowNulls(bm.get("deptCd")));

				        insr1550SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(bm.get("payrMangDeptCd")));
				        insr1550SrhVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(insr1550SrhVo.getPayrMangDeptCd())); 		        
				        
				        insr1550SrhVo.setDeptCdAuth(insr1550SrhVo.getDeptCd().replace(",", ""));  //권한처리를위해 추가  
				        insr1550SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(insr1550SrhVo.getDtilOccuInttnCd()).replace(",", ""));
				        
				        insr1550SrhVo.setApplyAqtnLssYn(MSFSharedUtils.allowNulls(bm.get("applyAqtnLssYn"))) ;   //취득상실 미선택시 신고여부
				    	insr1550SrhVo.setApplyAqtnYn(MSFSharedUtils.allowNulls(bm.get("applyAqtnYn"))) ;         //취득 선택시 신고여부
				    	insr1550SrhVo.setApplyLssYn(MSFSharedUtils.allowNulls(bm.get("applyLssYn"))) ;           //상실 선택시 신고여부
				    	String famyQuftDivCd = MSFSharedUtils.allowNulls(bm.get("famyQuftDivCd"));
				    	insr1550SrhVo.setFamyQuftDivCd(MSFSharedUtils.allowNulls(bm.get("famyQuftDivCd"))); //취득상실


				    	if(famyQuftDivCd != null && !famyQuftDivCd.equals("")){
				    		if(famyQuftDivCd.equals("I0100001")) insr1550SrhVo.setFamyQuftDivCdAqtn(famyQuftDivCd);
				    		else if(famyQuftDivCd.equals("I0100002")) insr1550SrhVo.setFamyQuftDivCdLss(famyQuftDivCd);
				    	}

				        
				        
				        
				        /******************************** 권한 ************************************************************************/
				        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
				        if ("FALSE".equals(chkDeptCd)) {
				        	insr1550SrhVo.setDeptCd(sessionUser.getDeptCd()); 
				           listDeptCd.add(sessionUser.getDeptCd());
				           insr1550SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
				           insr1550SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
				        } else {
				        	    
				        	
				                 if (insr1550SrhVo.getPayrMangDeptCd().equals(bm.get("deptCd"))) { 
				                 	 listDeptCd = null; 
				                 	insr1550SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
				                 	insr1550SrhVo.setDeptCd("");  //부서코드
				                 } else {
				                	 insr1550SrhVo.setDeptCd(MSFSharedUtils.allowNulls(bm.get("deptCd")));
				                      listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(bm.get("deptCd")));  
				                      insr1550SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
				                 } 
				        }
				       /******************************** 권한 ************************************************************************/
				        
				        try {  
				        	if  (MSFSharedUtils.paramNull(insr1500DAO)) {				        
					        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
					        	insr1500DAO = (Insr1500DAO) wac.getBean("Insr1500DAO" ); 
					        }
				        	if  (MSFSharedUtils.paramNull(insr1600DAO)) {				        
					        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
					        	insr1600DAO = (Insr1600DAO) wac.getBean("Insr1600DAO" ); 
					        }
					
				        	List<EgovMap> InsrList = null;
				        	
				        	if(famyQuftDivCd.equals("I0100001")){
				        		InsrList = insr1500DAO.selectXlsInsr1550List(insr1550SrhVo);
				        		for(int i=0; i<InsrList.size(); i++){
				        			Insr1550VO insr1550Vo = new  Insr1550VO();
				        			EgovMap eMap = (EgovMap) InsrList.get(i);
				        			BigDecimal famySeilNum =  (BigDecimal) eMap.get("famySeilNum");	
				        			insr1550Vo.setFamySeilNum(famySeilNum.longValue());
				        			insr1550Vo.setDpobCd((String) eMap.get("dpobCd"));
				        			insr1550Vo.setSystemkey((String) eMap.get("systemkey"));
				        			BigDecimal famyAqtnLssNum =  (BigDecimal) eMap.get("famyAqtnLssNum");	
				        			insr1550Vo.setFamyAqtnLssNum(famyAqtnLssNum.longValue());
				        			insr1550Vo.setFamyQuftDivCd((String) eMap.get("famyQuftDivCd"));
				        			insr1550Vo.setSocrAqtnFamyYn("Y");
				        			insr1550Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
				        			insr1550Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
				        		  	insr1500DAO.updateXlsInsr2150ToInsr1550(insr1550Vo);			        		
				        		}	
				        	}else if(famyQuftDivCd.equals("I0100001")){
				        		InsrList = insr1600DAO.selectXlsInsr1600List(insr1550SrhVo);
				        		for(int i=0; i<InsrList.size(); i++){
				        			Insr1600VO insr1600Vo = new  Insr1600VO();
				        			EgovMap eMap = (EgovMap) InsrList.get(i);
				        			BigDecimal famySeilNum =  (BigDecimal) eMap.get("famySeilNum");	
				        			insr1600Vo.setFamySeilNum(famySeilNum.longValue());
				        			insr1600Vo.setDpobCd((String) eMap.get("dpobCd"));
				        			insr1600Vo.setSystemkey((String) eMap.get("systemkey"));
				        			BigDecimal famyAqtnLssNum =  (BigDecimal) eMap.get("famyAqtnLssNum");	
				        			insr1600Vo.setFamyAqtnLssNum(famyAqtnLssNum.longValue());
				        			insr1600Vo.setFamyQuftDivCd((String) eMap.get("famyQuftDivCd"));
				        			insr1600Vo.setSocrLssFamyYn("Y");
				        			insr1600Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
				           	        insr1600Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
				           	        insr1600DAO.updateXlsInsr2150ToInsr1600(insr1600Vo);
				        		}
				        	}
				        
				        
				        	result = 1L; 
				        
				        
				        }catch (Exception ex) {
				        	logger.error("EXCEPTION calling updateXlsInsr2100(): "+ex); 
				        	result = new Long(0);
			         		throw MSFServerUtils.getOperationException("updateXlsInsr2100", ex, logger);
				        }
				        finally {
				          
				        }
				        
				        return result;
				}
				
}
