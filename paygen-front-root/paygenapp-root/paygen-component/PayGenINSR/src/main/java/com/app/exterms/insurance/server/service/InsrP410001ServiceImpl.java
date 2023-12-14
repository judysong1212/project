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

import com.app.exterms.insurance.client.service.InsrP410001Service;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.exterms.payroll.client.dto.InfcPkgPayr0540DTO;
import com.app.exterms.payroll.shared.InfcPkgPayrDaoConstants;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0540DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0540SrhVO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0540VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
@Service("InsrP410001Service")
public class InsrP410001ServiceImpl extends AbstractCustomServiceImpl implements InsrP410001Service ,InsrDaoConstants,InfcPkgPayrDaoConstants{
	
	private static final Logger logger = LoggerFactory.getLogger(InsrP410001ServiceImpl.class);
	private static final String calledClass = InsrP410001ServiceImpl.class.getName();
	  
	
	@Autowired
    @Resource(name="InfcPkgPayr0540DAO")
    private InfcPkgPayr0540DAO infcPayr0540DAO;

	
	
	 /** ID Generation */
	//@Resource(name="{egovPayr0400IdGnrService}")    
	//private EgovIdGnrService egovIdGnrService;
			 
			 
	/**
	 * 예외처리대상자		
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getInsrLP410001Payr0540DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_INSRLP410001_PAYR0540_DATA_LIST;
        InfcPkgPayr0540SrhVO   payr0540SrhVO = new InfcPkgPayr0540SrhVO();
        InfcPkgPayr0540VO      payr0540VO = new InfcPkgPayr0540VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(infcPayr0540DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	infcPayr0540DAO = (InfcPkgPayr0540DAO) wac.getBean("InfcPkgPayr0540DAO" ); 
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
            List<String> listDeptCd = new ArrayList<String>();
            /** 조건절 */
            payr0540SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            payr0540SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
           
            payr0540SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
             
            payr0540SrhVO.setUsrId(sessionUser.getUsrId());  
            
            payr0540SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
            payr0540SrhVO.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
            
            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
            payr0540SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
            payr0540SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
           
//            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//            payr0540SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//            payr0540SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
             
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0540SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0540SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
            
            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
            payr0540SrhVO.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
            payr0540SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
            
            
            payr0540SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            payr0540SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
            
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	payr0540SrhVO.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               payr0540SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
               payr0540SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	 payr0540SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
                     if (payr0540SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	payr0540SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	payr0540SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	 payr0540SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          payr0540SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
            
            payr0540SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            payr0540SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
            
            /******************************** 권한 ************************************************************************/ 
           // payr0540SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
           
            
           
             
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = infcPayr0540DAO.selectInsrLP410001Payr0540ListTotCnt(payr0540SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginInsrLP410001Payr0540DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0540SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0540SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0540SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//		            Collection<Map<String, Object>> list ??????
            List list = infcPayr0540DAO.selectInsrLP410001Payr0540List(payr0540SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginInsrLP410001Payr0540DataList, "getInsrLP410001Payr0540DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	 
	/**
	 * 예외처리내역
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getInsrRP410001Payr0540DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_INSRRP410001_PAYR0540_DATA_LIST;
        InfcPkgPayr0540SrhVO   payr0540SrhVO = new InfcPkgPayr0540SrhVO();
        InfcPkgPayr0540VO      payr0540VO = new InfcPkgPayr0540VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(infcPayr0540DAO)) {
        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	infcPayr0540DAO = (InfcPkgPayr0540DAO) wac.getBean("InfcPkgPayr0540DAO"); 
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
            payr0540SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//            payr0540SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//            payr0540SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
//            payr0540SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
//             
//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//            payr0540SrhVO.setDeptCdArr(listDeptCd);     //부서코드
//            payr0540SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//            
//           // payr0540SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//            payr0540SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
//            payr0540SrhVO.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
//            
//            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
//            payr0540SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
//            payr0540SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//           
//            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//            payr0540SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//            payr0540SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//             
//            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
//            payr0540SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//            payr0540SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
//            
//            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
//            payr0540SrhVO.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
//            payr0540SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
            
            
            payr0540SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
//            payr0540SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
             
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = infcPayr0540DAO.selectInsrRP410001Payr0540ListTotCnt(payr0540SrhVO);  
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginInsrRP410001Payr0540DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0540SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0540SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0540SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//		            Collection<Map<String, Object>> list ??????
            List list = infcPayr0540DAO.selectInsrRP410001Payr0540List(payr0540SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginInsrRP410001Payr0540DataList, "getInsrRP410001Payr0540DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	
	/**
	 * 에외처리등록수정삭제
	 */
	@Override
	public Long activityOnInsrP400001Payr0540(
			List<InfcPkgPayr0540DTO> listPayr0540dto,
			ActionDatabase actionDatabase) {
		    Long result = new Long(0);
		    Long iCnt = new Long(0);
		    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		    try { 
		         
	    	   if  (MSFSharedUtils.paramNull(infcPayr0540DAO)) {
	                
	                WebApplicationContext wac = WebApplicationContextUtils.
	                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                infcPayr0540DAO = (InfcPkgPayr0540DAO) wac.getBean("InfcPkgPayr0540DAO" ); 
	            }
		      
		        for(int iPayrCnt=0;iPayrCnt < listPayr0540dto.size();iPayrCnt++) {
		            
		        	InfcPkgPayr0540DTO infcPayr0540Dto = new InfcPkgPayr0540DTO();  
		        	infcPayr0540Dto = listPayr0540dto.get(iPayrCnt);
		             
		        	InfcPkgPayr0540VO infcPayr0540VO = new InfcPkgPayr0540VO();  
		                

							infcPayr0540VO.setDpobCd(infcPayr0540Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
							infcPayr0540VO.setSystemkey(infcPayr0540Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
							infcPayr0540VO.setExptnPrcsSeilNum(new BigDecimal(infcPayr0540Dto.getExptnPrcsSeilNum()));    /** column 예외처리일련번호 : exptnPrcsSeilNum */
							infcPayr0540VO.setExptnDivCd(infcPayr0540Dto.getExptnDivCd());    /** column 예외구분코드 : exptnDivCd */
							infcPayr0540VO.setPymtDducDivCd(infcPayr0540Dto.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
							infcPayr0540VO.setPayItemCd(infcPayr0540Dto.getPayItemCd());    /** column 급여항목코드 : payItemCd */
							
							infcPayr0540VO.setExmtnYn((Boolean.TRUE.equals(infcPayr0540Dto.getExmtnYn()) ? "Y" : "N") );    /** column 면제여부 : exmtnYn */
							infcPayr0540VO.setExptnPrcsPymtSum(new BigDecimal(infcPayr0540Dto.getExptnPrcsPymtSum()));    /** column 예외처리공제금액 : exptnPrcsPymtSum */
							infcPayr0540VO.setExptnPrcsPymtRto(new BigDecimal(infcPayr0540Dto.getExptnPrcsPymtRto()));    /** column 예외처리공제비율 : exptnPrcsPymtRto */
							infcPayr0540VO.setExptnPrcsBgnnDt(infcPayr0540Dto.getExptnPrcsBgnnDt());    /** column 예외처리시작일자 : exptnPrcsBgnnDt */
							infcPayr0540VO.setExptnPrcsEndDt(infcPayr0540Dto.getExptnPrcsEndDt());    /** column 예외처리종료일자 : exptnPrcsEndDt */
							infcPayr0540VO.setExptnPrcsNoteCtnt(infcPayr0540Dto.getExptnPrcsNoteCtnt());    /** column 예외처리내용 : exptnPrcsNoteCtnt */
							infcPayr0540VO.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
							infcPayr0540VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
						//	infcPayr0540VO.setInptDt(infcPayr0540Dto.getInptDt());    /** column 입력일자 : inptDt */
							infcPayr0540VO.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
						//	infcPayr0540VO.setRevnDt(infcPayr0540Dto.getRevnDt());    /** column 수정일자 : revnDt */
							infcPayr0540VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
							
		                     
		                  
		               switch (actionDatabase) {
		               case INSERT:
		            	   infcPayr0540DAO.insertPayr0540(infcPayr0540VO); 
		                   break;
		               case UPDATE: 
		            	   infcPayr0540DAO.updatePayr0540(infcPayr0540VO); 
		                   break;
		               case DELETE: 
		            	   infcPayr0540DAO.deletePayr0540(infcPayr0540VO); 
		                   break;
		               } 
		               iCnt = iCnt + 1; 
		                
		           } 
		            result = iCnt;
		      
		    }
		    catch (Exception ex) {
		        logger.error("EXCEPTION calling activityOnInsrP400001Payr0540(): "+ex); 
		        
		        result = new Long(0);
		        throw MSFServerUtils.getOperationException("activityOnInsrP400001Payr0540", ex, logger);
		    }
		    finally {
		      
		    }
		    
		    return result;
	}
	/**
	 * 예외처리 대상자 등록
	 */
	@Override
	public Long activityOnInsertInsrP410001(List<BaseModel> mapModels) {
		// TODO Auto-generated method stub
		    Long result = new Long(0);
	        Long iCnt = new Long(0);

	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        try {
	        	
	            if  (MSFSharedUtils.paramNull(infcPayr0540DAO)) {
	                
	                WebApplicationContext wac = WebApplicationContextUtils.
	                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                infcPayr0540DAO = (InfcPkgPayr0540DAO) wac.getBean("InfcPkgPayr0540DAO" ); 
	            }
	            
	       
	            Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
	            while (iterRecords.hasNext()) {
	              

	                InfcPkgPayr0540VO infcPayr0540Vo = new InfcPkgPayr0540VO(); 
	                
	                BaseModel bmMapModel = (BaseModel) iterRecords.next(); 

	                infcPayr0540Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	                infcPayr0540Vo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
				//	infcPayr0540Vo.setExptnPrcsSeilNum(MSFSharedUtils.allowNulls(bmMapModel.get("exptnPrcsSeilNum")));    /** column 예외처리일련번호 : exptnPrcsSeilNum */
				//	infcPayr0540Vo.setExptnDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("exptnDivCd")));    /** column 예외구분코드 : exptnDivCd */
	                infcPayr0540Vo.setPymtDducDivCd("B0080030");    /** column 지급공제구분코드 : pymtDducDivCd */
	                infcPayr0540Vo.setPayItemCd("");    /** column 급여항목코드 : payItemCd */ 
	                infcPayr0540Vo.setExmtnYn("N");    /** column 면제여부 : exmtnYn */
	                infcPayr0540Vo.setExptnPrcsPymtSum(BigDecimal.ZERO);    /** column 예외처리공제금액 : exptnPrcsPymtSum */
	                infcPayr0540Vo.setExptnPrcsPymtRto(BigDecimal.ZERO);    /** column 예외처리공제비율 : exptnPrcsPymtRto */
	                infcPayr0540Vo.setExptnPrcsBgnnDt("");    /** column 예외처리시작일자 : exptnPrcsBgnnDt */
	                infcPayr0540Vo.setExptnPrcsEndDt("");    /** column 예외처리종료일자 : exptnPrcsEndDt */ 
	                infcPayr0540Vo.setExptnPrcsNoteCtnt("");    /** column 예외처리내용 : exptnPrcsNoteCtnt */
	                infcPayr0540Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
	                infcPayr0540Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
					 
	                InfcPkgPayr0540SrhVO tpInfcPayr0540SrhVo = new InfcPkgPayr0540SrhVO();  
	                tpInfcPayr0540SrhVo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
	                tpInfcPayr0540SrhVo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
	                
	                
	                List listPayr0540 = infcPayr0540DAO.selectInsr410001ToPayr0540(tpInfcPayr0540SrhVo);
	                
	                if ( listPayr0540.size() <= 0) {
	                	 
	                	infcPayr0540DAO.insertPayr0540(infcPayr0540Vo);  
	                	 
	                	// String errMsg = payr0300Vo.getPymtYrMnth() + ":" + MSFSharedUtils.allowNulls(bmMapModel.get("jobNm")) + "!! => 급여 계산 처리된 스케줄은 삭제할 수 없습니다."; 
	                	// throw MSFServerUtils.getSimpleMessageException("activityOnInsertInsrP410001", errMsg, logger); 
	                } 
	              
	                iCnt = iCnt + 1;
	                 
	           } 
	            result = iCnt;
				 
	        }
	        catch (Exception ex) {
	            logger.error("EXCEPTION calling activityOnInsertInsrP410001(): "+ex); 
	            result = new Long(0);
	            throw MSFServerUtils.getOperationException("activityOnInsertInsrP410001", ex, logger);
	        }
	        finally {
	          
	        }
	        
	        return result;
	}
	
	@Override
	public Long deleteInsrP410001(List<BaseModel> listModels, ActionDatabase actionDatabase)  throws MSFException  {
		
	    Long result = new Long(0);
        Long iCnt = new Long(0);
        

       // MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        try {
        	
    	   if  (MSFSharedUtils.paramNull(infcPayr0540DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                infcPayr0540DAO = (InfcPkgPayr0540DAO) wac.getBean("InfcPkgPayr0540DAO" ); 
            }
            
            Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)listModels.iterator();
            while (iterRecords.hasNext()) { 

                InfcPkgPayr0540VO infcPayr0540Vo = new InfcPkgPayr0540VO();  
                InfcPkgPayr0540SrhVO tpInfcPayr0540SrhVo = new InfcPkgPayr0540SrhVO();  
             
                BaseModel bmMapModel = (BaseModel) iterRecords.next();
                 
                infcPayr0540Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                infcPayr0540Vo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
		  
                tpInfcPayr0540SrhVo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
                tpInfcPayr0540SrhVo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
                
                List listPayr0540 = infcPayr0540DAO.selectInsr410001ToPayr0540(tpInfcPayr0540SrhVo);
                
                if ( listPayr0540.size() > 1) { 
                	
                	 result = new Long(0);
                	 String errMsg = "데이타확인 : " + "예외건강보험이 여러건 존재하는 대상자가 존재하면 삭제할 수 없습니다."; 
                	 throw MSFServerUtils.getSimpleMessageException("deleteInsrP410001", errMsg, logger); 
                }
                
                infcPayr0540DAO.deleteInsr410001ToPayr0540(infcPayr0540Vo);  
              
                iCnt = iCnt + 1;
                 
           } 
            result = iCnt;
			 
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling deleteInsrP410001(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("deleteInsrP410001", ex, logger);
        }
        finally {
          
        }
        
        return result;
		
	}
}
