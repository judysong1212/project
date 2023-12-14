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

import com.any.smrmf.utils.BeanFinder;
import com.app.exterms.payroll.client.service.Payr8500Service;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.exterms.retirement.client.dto.InfcPkgRemt2000DTO;
import com.app.exterms.retirement.client.dto.InfcPkgRemt2100DTO;
import com.app.exterms.retirement.client.dto.InfcPkgRemt2200DTO;
import com.app.exterms.retirement.client.dto.InfcPkgRemtDays0100DTO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt2000DAO;
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt2100DAO;
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt2200DAO;
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt2300DAO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2000SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2000VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2100SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2200SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2200VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2300SrhVO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2300VO;
import com.app.smrmf.pkg.listener.remt.remt2018.RemtListenerAdapter;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

/**
 * @Class Name : Payr8500ServiceImpl.java
 * @Description : Payr8500 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.07.11
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@Service("Payr8500Service")
public class Payr8500ServiceImpl extends AbstractCustomServiceImpl  implements Payr8500Service, PayrDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Payr8500ServiceImpl.class);
	private static final String calledClass = Payr8500ServiceImpl.class.getName();
	
    @Autowired
    @Resource(name="InfcPkgRemt2000DAO")
    private InfcPkgRemt2000DAO remt2000DAO;
    
    @Autowired
    @Resource(name="InfcPkgRemt2100DAO")
    private InfcPkgRemt2100DAO remt2100DAO;
    
    @Autowired
    @Resource(name="InfcPkgRemt2200DAO")
    private InfcPkgRemt2200DAO remt2200DAO;
    
    @Autowired
    @Resource(name="InfcPkgRemt2300DAO")
    private InfcPkgRemt2300DAO remt2300DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPayr8500IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
    
    
    
    /** 
     * 퇴직금계산 대상자 조회
     * @param serviceParameters
     * @return
     * @throws MSFException
     */
    public PagingLoadResult<BaseModel> getPayr8500ToPsnl0100ToRemt0100DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
//        String method =  CLASS_SYSCOM_PSNL0100_REMT0100_DATALIST;
        String method = "com.app.exterms.payroll.server.service.Payr8500ServiceImpl.getPayr8500ToPsnl0100ToRemt0100DataList";
        InfcPkgRemt2000SrhVO   remt2000SrhVo = new InfcPkgRemt2000SrhVO();
        InfcPkgRemt2000VO      remt2000Vo = new InfcPkgRemt2000VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
      
        try {
        	
        	remt2000DAO = (InfcPkgRemt2000DAO)BeanFinder.getBean("InfcPkgRemt2000DAO");
        	
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
            remt2000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            remt2000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
            remt2000SrhVo.setUsrId(sessionUser.getUsrId());  
              
            
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	
            	if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {

                	remt2000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
                   listDeptCd.add(sessionUser.getDeptCd());
                   remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
                    
           	 } else {
           		 
           		 remt2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                 listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                 remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드     
           	 }  
            	
               remt2000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	 remt2000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
                     if (remt2000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                     	remt2000SrhVo.setDeptCd("");  //부서코드
                     } else {
                    	 remt2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
            
            remt2000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            remt2000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
           /******************************** 권한 ************************************************************************/
            
            
            remt2000SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYrMnth"))); //퇴직정산년월
            remt2000SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnDivCd")));  //퇴직정산구분코드  
            
            remt2000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
            
            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
            remt2000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
            remt2000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
           
             
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            remt2000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            remt2000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세 
            
            remt2000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
            remt2000SrhVo.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
          
            remt2000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            remt2000SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
            
            String strHdofcCodtnCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"));
            
            List<String> listHdofcCodtnCd = new ArrayList<String>(); 
           
            String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
            
            for (int i=0; i<ray.length; i++){ 
                listHdofcCodtnCd.add(ray[i]);
            } 
            remt2000SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);    //재직상
            remt2000SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));    //재직상
            
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = remt2000DAO.selectPsnl0100ToRemt0100ListTotCnt(remt2000SrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPsnl0100ToRemt0100DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            remt2000SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                remt2000SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                remt2000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list  
            List list = remt2000DAO.selectPsnl0100ToRemt0100List(remt2000SrhVo);
            
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

                 		String rrnDecCrypt = "";
                    			
                 		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
                 	          			
                 	          			
                 			// 주민번호(복호화)
                 			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                 	          		
                 			strValue = rrnDecCrypt;
                 						
                 		}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

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
                         
                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    } else {
                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    }
                 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
                    
                    
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToRemt0100DataList, "getPsnl0100ToRemt0100DataList");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
    
    
    /**
     * 퇴직금지급내역 조회 
     * @param serviceParameters
     * @return
     * @throws MSFException
     */
    public PagingLoadResult<BaseModel> getSelectRemtPymt0100ToRemt2000List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR8500_TO_REMTPYMT0100_REMT2000_DATALIST;
        InfcPkgRemt2000SrhVO   remt2000SrhVo = new InfcPkgRemt2000SrhVO();
        InfcPkgRemt2000VO      remt2000Vo = new InfcPkgRemt2000VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
         
        try {
        	
        	remt2000DAO = (InfcPkgRemt2000DAO)BeanFinder.getBean("InfcPkgRemt2000DAO");
        	
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
            remt2000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드 D
            remt2000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키 
            remt2000SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYrMnth"))); //퇴직정산년월
            remt2000SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnDivCd")));  //퇴직정산구분코드  
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = remt2000DAO.selectRemtPymt0100ToRemt2000ListTotCnt(remt2000SrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginRemtPymt0100ToRemt2000DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            remt2000SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	remt2000SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	remt2000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list  
            List list = remt2000DAO.selectRemtPymt0100ToRemt2000List(remt2000SrhVo);
            
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

                 		String rrnDecCrypt = "";
                    			
                 		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
                 	          			
                 	          			
                 			// 주민번호(복호화)
                 			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                 	          		
                 			strValue = rrnDecCrypt;
                 						
                 		}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

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
            
            SmrmfUtils.endTiming(logger, millisBeginRemtPymt0100ToRemt2000DataList, "getSelectRemtPymt0100ToRemt2000List");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    } 
    
    
	/**
	 * 퇴직금 공제항목 리스트 출력
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getSelectRemt0100ToRemt2300List(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_PAYR8500_TO_REMTPYMT0100_REMT2000_DATALIST;
		InfcPkgRemt2300SrhVO Remt2300SrhVo = new InfcPkgRemt2300SrhVO();
		InfcPkgRemt2300VO Remt2300Vo = new InfcPkgRemt2300VO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		

		// 1. 암호화 객체 생성
//		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		if (MSFSharedUtils.paramNull(remt2300DAO)) {

			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());

			remt2300DAO = (InfcPkgRemt2300DAO) wac.getBean("InfcPkgRemt2300DAO");
		}

		try {
			// TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가
			// Sysm0400BM user = serviceParameters.getUser();
			ColumnAttribute[] tableAttributes = serviceParameters.getTableAttributes();
			IColumnFilter columnFilters = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders = serviceParameters.getColumnOrders();
			PagingLoadConfig pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			// Get paging configuration
			PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

			// Get query parameters
			// String strCriteriaValue =
			// String.valueOf(MSFServerUtils.getFilterValue(columnFilters,
			// "rpsttvCd"));

			/** 조건절 */
			Remt2300SrhVo.setDpobCd(sessionUser.getDpobCd()); // 사업장코드
			Remt2300SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"))); // 시스템키
			Remt2300SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,	"calcSevePayPsnDivCd")));/** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
			Remt2300SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"clutYrMnth")));/** set 정산년월 : clutYrMnth */

			// Get total record count //전체 데이터 갯수를 가지고 온다.
			if (pagingValues.executeRecordCount) {

				// Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = remt2300DAO.selectRemt0100ToRemt2300ListTotCnt(Remt2300SrhVo);
				if (!pagingValues.pageExecute) {
					pagingValues.offsetLimit = iResultCnt;
				}
				SmrmfUtils.endTiming(logger, millisBeginQueryCount,"QueryCount");
				pagingValues.totalRecordCount = iResultCnt;

				logger.debug("totalRecordCount : "+ pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginRemt0100ToRemt2300DataList = SmrmfUtils.startTiming(logger);

			/** 페이지 카운트 처리를 위한 부분 */
			Remt2300SrhVo.setPageSize(pagingValues.totalRecordCount);

			// Apply paging
			if (pagingValues.start > 0) {
				Remt2300SrhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				Remt2300SrhVo.setLastIndex(Math.min(pagingValues.start+ pagingValues.offsetLimit,pagingValues.totalRecordCount));
			}

			// Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			// Collection<Map<String, Object>> list
			List list = remt2300DAO.selectRemt0100ToRemt2300List(Remt2300SrhVo);

			Iterator<Map<String, Object>> iter = list.iterator();

			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");

			while (iter.hasNext()) {
				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = map.get("systemkey").toString();
				BaseModel bm = new BaseModel();

				// bm.setProperties(map);
				for (int i = 0; i < tableAttributes.length; i++) {
					
					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					Object mapCon = map.get(tableAttributes[i].getName());

					switch (tableAttributes[i].getType()) {
					case ColumnDef.TYPE_DATE:
					case ColumnDef.TYPE_DATETIME:

						Date value = SmrmfUtils.getDateFromString(String.valueOf(mapCon), "yyyyMMdd");
						map.put(tableAttributes[i].getName(), value);

						break;
						
						
						//3. 복호화
					case ColumnDef.TYPE_STRING: 
					          			          			
						String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

						String rrnDecCrypt = "";
				   			
						if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
					          			
					          			
							// 주민번호(복호화)
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					          		
							strValue = rrnDecCrypt;
										
						}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

							// 주민번호(복호화)
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					          		
							strValue = rrnDecCrypt;

				        }
							
					map.put(tableAttributes[i].getName(), strValue);
						                    
					break;
	

					case ColumnDef.TYPE_LONG:

						if (mapCon != null) {
							Long lValue = (new BigDecimal(mapCon.toString())).longValue();
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
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					Object baseModelValue = null;
					// 콤보박스처리를 위해 추가함
					if (tableAttributes[i].getName().contains("$")) {
						String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();

						map.put(tableAttributes[i].getName(),map.get(strMapCon));

						baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()),tableAttributes[i].getType());
					} else {
						baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()),tableAttributes[i].getType());
					}
					/**
					 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */

					bm.set(tableAttributes[i].getName(), baseModelValue);
				}

				bm.set(TableDef.ID_PROPERTY_NAME, idValue);
				bmResult.add(bm);
			}

			retval = new BasePagingLoadResult<BaseModel>(bmResult,pagingValues.start, pagingValues.totalRecordCount);

			SmrmfUtils.endTiming(logger,millisBeginRemt0100ToRemt2300DataList,"getSelectRemt0100ToRemt2300List");

		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}
    
    
	   public PagingLoadResult<BaseModel> getSelectRemt0150ToRemt2000List(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_PAYR8500_TO_REMT0150_REMT2000_DATALIST;
	        InfcPkgRemt2000SrhVO   remt2000SrhVo = new InfcPkgRemt2000SrhVO();
	        InfcPkgRemt2000VO      remt2000Vo = new InfcPkgRemt2000VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	    	// 1. 암호화 객체 생성
//	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	         
	        
	        try {
	        	
	        	remt2000DAO = (InfcPkgRemt2000DAO)BeanFinder.getBean("InfcPkgRemt2000DAO");
	        	
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
	            remt2000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            remt2000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            remt2000SrhVo.setUsrId(sessionUser.getUsrId());  
	              
	            
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	
	            	if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {

		            	remt2000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
		               listDeptCd.add(sessionUser.getDeptCd());
		               remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                     
	            	 } else {
	            		 remt2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                         listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                         remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                     
	            	 }  
	            	 
	               remt2000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	    
	            	remt2000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
	                     if (remt2000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                     	 listDeptCd = null; 
	                     	remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                     	remt2000SrhVo.setDeptCd("");  //부서코드
	                     } else {
	                    	 remt2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                          remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                     } 
	                  
	            }
	            
	            remt2000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            remt2000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
	            
//	            String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//	            if ("FALSE".equals(chkTypOccuCd)) {
//	            	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//	            	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//	            } else {
//	            	
//	            }
	            
	           /******************************** 권한 ************************************************************************/
	            
	            
	            
	            remt2000SrhVo.setClutYrMnth01(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYrMnth01"))); //퇴직정산기간01 
	            remt2000SrhVo.setClutYrMnth02(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYrMnth02"))); //퇴직정산기간02   
	            remt2000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            
	            
	            
//	              if (remt2000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
//	            	remt2000SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//	            	List<String> listDeptCd = null; 
//	                remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	                remt2000SrhVo.setDeptCd("");     //부서코드
//	            } else {
//	            	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	                remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	                remt2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//	            }
	              
	              
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            remt2000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	            remt2000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
//	            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	            remt2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	            remt2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            remt2000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            remt2000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	            
	            
	            remt2000SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnDivCd")));  //퇴직정산구분코드   
	            remt2000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
	            remt2000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            remt2000SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
	             
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	             if ( pagingValues.executeRecordCount ) { 
	                    
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = remt2000DAO.selectRemt0150ToRemt2000ListTotCnt(remt2000SrhVo);  
	              
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;        
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginRemt0150ToRemt2000DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            remt2000SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	remt2000SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	remt2000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//		            Collection<Map<String, Object>> list  
	            List list = remt2000DAO.selectRemt0150ToRemt2000List(remt2000SrhVo);
	            
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
	                    case ColumnDef.TYPE_DATE: 
	                    case ColumnDef.TYPE_DATETIME: 
	                       
	                     Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"yyyyMMdd");
	                     map.put(tableAttributes[i].getName(), value);
	                     
	                       break; 
	                       
	                   	//3. 복호화
	                	case ColumnDef.TYPE_STRING: 
	                	          			          			
	                		String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

	                		String rrnDecCrypt = "";
	                   			
	                		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	                	          			
	                	          			
	                			// 주민번호(복호화)
	                			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	                	          		
	                			strValue = rrnDecCrypt;
	                						
	                		}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

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
	            
	            SmrmfUtils.endTiming(logger, millisBeginRemt0150ToRemt2000DataList, "getSelectRemt0150ToRemt2000List");
	       

	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    } 
	
	
	/** 산정결과 **/
	@Override
	public InfcPkgRemt2000DTO activityOnReadPayr8500ToRemt0100(InfcPkgRemt2000DTO remt2000Dto)throws MSFException {

		InfcPkgRemt2000DTO rtnRemt2000Dto = new InfcPkgRemt2000DTO();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
 
		try {

			remt2000DAO = (InfcPkgRemt2000DAO)BeanFinder.getBean("InfcPkgRemt2000DAO");
			
			InfcPkgRemt2000VO remt2000Vo = new InfcPkgRemt2000VO();
			InfcPkgRemt2000VO rtnRemt2000Vo = new InfcPkgRemt2000VO();

			remt2000Vo.setDpobCd(MSFSharedUtils.allowNulls(remt2000Dto.getDpobCd()));							/** column 사업장코드 : dpobCd */
			remt2000Vo.setSystemkey(MSFSharedUtils.allowNulls(remt2000Dto.getSystemkey()));						/** column SYSTEMKEY : systemkey */
			remt2000Vo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(remt2000Dto.getCalcSevePayPsnDivCd()));	/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			remt2000Vo.setClutYrMnth(MSFSharedUtils.allowNulls(remt2000Dto.getClutYrMnth()));					/** column 정산년월 : clutYrMnth */

			rtnRemt2000Vo = remt2000DAO.selectRemt2000(remt2000Vo);

			if (MSFSharedUtils.paramNotNull(rtnRemt2000Vo)) {

				rtnRemt2000Dto.setDpobCd(rtnRemt2000Vo.getDpobCd());											/** column 사업장코드 : dpobCd */
				rtnRemt2000Dto.setSystemkey(rtnRemt2000Vo.getSystemkey());										/** column SYSTEMKEY : systemkey */
				rtnRemt2000Dto.setCalcSevePayPsnDivCd(rtnRemt2000Vo.getCalcSevePayPsnDivCd());					/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
				rtnRemt2000Dto.setClutYrMnth(rtnRemt2000Vo.getClutYrMnth());									/** column 정산년월 : clutYrMnth */
				rtnRemt2000Dto.setClutYr(rtnRemt2000Vo.getClutYrMnth().substring(0, 4));						/** column 정산년월 : clutYrMnth */
				rtnRemt2000Dto.setClutMnth(rtnRemt2000Vo.getClutYrMnth().substring(4, 6));						/** column 정산년월 : clutYrMnth */
				rtnRemt2000Dto.setEmymtDivCd(rtnRemt2000Vo.getEmymtDivCd());									/** column 고용구분코드 : emymtDivCd */
				rtnRemt2000Dto.setEmymtDivNm(rtnRemt2000Vo.getEmymtDivNm());									/** column 고용구분 : emymtDivNm */
				rtnRemt2000Dto.setDeptCd(rtnRemt2000Vo.getDeptCd());											/** column 부서코드 : deptCd */
				rtnRemt2000Dto.setDeptNm(rtnRemt2000Vo.getDeptNm());											/** column 부서 : deptNm */
				rtnRemt2000Dto.setTypOccuCd(rtnRemt2000Vo.getTypOccuCd());										/** column 직종코드 : typOccuCd */
				rtnRemt2000Dto.setTypOccuNm(rtnRemt2000Vo.getTypOccuNm());										/** column 직종 : typOccuNm */
				// rtnRemt2000Dto.setPyspGrdeCd(rtnRemt2000Vo.getPyspGrdeCd());
				// /** column 호봉등급코드 : pyspGrdeCd */
				// rtnRemt2000Dto.setPyspGrdeNm(rtnRemt2000Vo.getPyspGrdeNm());
				// /** column 호봉등급 : pyspGrdeNm */
				rtnRemt2000Dto.setDtilOccuInttnCd(rtnRemt2000Vo.getDtilOccuInttnCd());							/** column 직종세구분코드 : dtilOccuInttnCd */
				rtnRemt2000Dto.setDtilOccuClsDivNm(rtnRemt2000Vo.getDtilOccuClsDivNm());						/** column 직종세구분 : dtilOccuClsDivNm */
				
				rtnRemt2000Dto.setBusinCd(rtnRemt2000Vo.getBusinCd());											/** column 사업코드 : businCd */
				rtnRemt2000Dto.setBusinNm(rtnRemt2000Vo.getBusinNm());											/** column 사업 : businNm */
				rtnRemt2000Dto.setInbyCd(rtnRemt2000Vo.getInbyCd());											/** column 직위코드 : inbyCd */
				rtnRemt2000Dto.setPyspCd(rtnRemt2000Vo.getPyspCd());											/** column 호봉코드 : pyspCd */
				
				rtnRemt2000Dto.setLogSvcYrNumCd(rtnRemt2000Vo.getLogSvcYrNumCd());								/** column 근속년수코드 : logSvcYrNumCd */
				rtnRemt2000Dto.setLogSvcMnthIcmCd(rtnRemt2000Vo.getLogSvcMnthIcmCd());							/** column 근속월수코드 : logSvcMnthIcmCd */
				
				rtnRemt2000Dto.setNm(rtnRemt2000Vo.getNm());													/** column 성명 : nm */
				rtnRemt2000Dto.setResnRegnNum(rtnRemt2000Vo.getResnRegnNum());									/** column 주민등록번호 : resnRegnNum */
				
				rtnRemt2000Dto.setIcncDt(rtnRemt2000Vo.getIcncDt());											/** column 입사일자 : icncDt */
				rtnRemt2000Dto.setRkfcdDt(rtnRemt2000Vo.getRkfcdDt());											/** column 기산일자 : rkfcdDt */
				rtnRemt2000Dto.setRetryDt(rtnRemt2000Vo.getRetryDt());											/** column 퇴직일자 : retryDt */
				
				rtnRemt2000Dto.setLogSvcYrNum(rtnRemt2000Vo.getLogSvcYrNum().longValue());						/** column 근속년수 : logSvcYrNum */
				rtnRemt2000Dto.setLogSvcMnthIcm(rtnRemt2000Vo.getLogSvcMnthIcm().longValue());					/** column 근속월수 : logSvcMnthIcm */
				rtnRemt2000Dto.setAmcrrLogSvcYrNum(rtnRemt2000Vo.getAmcrrLogSvcYrNum().longValue());			/** column 군경력근속년수 : amcrrLogSvcYrNum */
				
				rtnRemt2000Dto.setAmcrrLogSvcMnthIcm(rtnRemt2000Vo.getAmcrrLogSvcMnthIcm().longValue());		/** column 군경력근속월수 : amcrrLogSvcMnthIcm */
				rtnRemt2000Dto.setEepnMnthIcm2012Bfr(rtnRemt2000Vo.getEepnMnthIcm2012Bfr().longValue());		/** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
				rtnRemt2000Dto.setEepnMnthIcm2013Aft(rtnRemt2000Vo.getEepnMnthIcm2013Aft().longValue());		/** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
				rtnRemt2000Dto.setAddMnthIcm2012Bfr(rtnRemt2000Vo.getAddMnthIcm2012Bfr().longValue());			/** column 가산월수_2012이전 : addMnthIcm2012Bfr */
				rtnRemt2000Dto.setAddMnthIcm2013Aft(rtnRemt2000Vo.getAddMnthIcm2013Aft().longValue());			/** column 가산월수_2013이후 : addMnthIcm2013Aft */
				
				rtnRemt2000Dto.setEepnDayIcmDys(rtnRemt2000Vo.getEepnDayIcmDys().longValue());					/** column 제외일수 : eepnDayIcmDys */
				rtnRemt2000Dto.setLogSvcNumDys(rtnRemt2000Vo.getLogSvcNumDys().longValue());					/** column 근속일수 : logSvcNumDys */
				rtnRemt2000Dto.setTurtyDutyYrNum(rtnRemt2000Vo.getTurtyDutyYrNum().longValue());				/** column 실근무년수 : turtyDutyYrNum */
				rtnRemt2000Dto.setTurtyDutyMnthNum(rtnRemt2000Vo.getTurtyDutyMnthNum().longValue());			/** column 실근무개월수 : turtyDutyMnthNum */
				rtnRemt2000Dto.setTurtyDutyNumDys(rtnRemt2000Vo	.getTurtyDutyNumDys().longValue());				/** column 실근무일수 : turtyDutyNumDys */
				rtnRemt2000Dto.setAmcrrLogSvcNumDys(rtnRemt2000Vo.getAmcrrLogSvcNumDys().longValue());			/** column 군경력근무일수 : amcrrLogSvcNumDys */
				
				rtnRemt2000Dto.setPayCmpttnBgnnDt(rtnRemt2000Vo.getPayCmpttnBgnnDt());							/** column 급여산정시작일자 : payCmpttnBgnnDt */
				rtnRemt2000Dto.setPayCmpttnEndDt(rtnRemt2000Vo.getPayCmpttnEndDt());							/** column 급여산정종료일자 : payCmpttnEndDt */
				
				rtnRemt2000Dto.setFndtnPayAggrSumSum(rtnRemt2000Vo.getFndtnPayAggrSumSum().longValue());		/** column 기본급여합계금액 : fndtnPayAggrSumSum */
				rtnRemt2000Dto.setSnryAllwAggrSum(rtnRemt2000Vo.getSnryAllwAggrSum().longValue());				/** column 제수당합계금액 : snryAllwAggrSum */
				rtnRemt2000Dto.setWelfWelfSpdgAggrSum(rtnRemt2000Vo.getWelfWelfSpdgAggrSum().longValue());		/** column 후생복지비합계금액 : welfWelfSpdgAggrSum */
				
				rtnRemt2000Dto.setMarPubcWelfAmnt(rtnRemt2000Vo.getMarPubcWelfAmnt().longValue());				/** column 3월간후생복지비 : marPubcWelfAmnt */
				rtnRemt2000Dto.setMarTotAmntWag(rtnRemt2000Vo.getMarTotAmntWag().longValue());					/** column 3월간총임금액 : marTotAmntWag */
				rtnRemt2000Dto.setDayAvgAmntWag(rtnRemt2000Vo.getDayAvgAmntWag().longValue());					/** column 1일평균임금액 : dayAvgAmntWag */
				rtnRemt2000Dto.setSevePayCmpttnSum(rtnRemt2000Vo.getSevePayCmpttnSum().longValue());			/** column 퇴직금산정금액 : sevePayCmpttnSum */
				rtnRemt2000Dto.setSevePayAddSum(rtnRemt2000Vo.getSevePayAddSum().longValue());					/** column 퇴직금가산금액 : sevePayAddSum */
				rtnRemt2000Dto.setSevePayAddRate(rtnRemt2000Vo.getSevePayAddRate().doubleValue());				/** column 퇴직금가산율 : sevePayAddRate */
				
				rtnRemt2000Dto.setSevePayAddApptnSum(rtnRemt2000Vo.getSevePayAddApptnSum().longValue());		/** column 퇴직금가산적용금액 : sevePayAddApptnSum */
				rtnRemt2000Dto.setAmcrrClutInsnYn(MSFSharedUtils.convertStringToBoolean(rtnRemt2000Vo.getAmcrrClutInsnYn()));/** column 군경력정산포함여부 : amcrrClutInsnYn */
				rtnRemt2000Dto.setAmcrrAddApptnSum(rtnRemt2000Vo.getAmcrrAddApptnSum().longValue());			/** column 군경력가산적용금액 : amcrrAddApptnSum */
				rtnRemt2000Dto.setTotLogSvcNumDys(rtnRemt2000Vo.getTotLogSvcNumDys().longValue());				/** column 총근무일수 : totLogSvcNumDys */
				rtnRemt2000Dto.setSevePayPymtSum(rtnRemt2000Vo.getSevePayPymtSum().longValue());				/** column 퇴직금지급액 : sevePayPymtSum */
				
				rtnRemt2000Dto.setSevePayCmpttnFreeDtySum(rtnRemt2000Vo.getSevePayCmpttnFreeDtySum().longValue());			/** column 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
				rtnRemt2000Dto.setSevePayCmpttnTxtnSum(rtnRemt2000Vo.getSevePayCmpttnTxtnSum().longValue());				/** column 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
				rtnRemt2000Dto.setSevePayPymtYn(MSFSharedUtils.convertStringToBoolean(rtnRemt2000Vo.getSevePayPymtYn()));	/** column 퇴직금지급여부 : sevePayPymtYn */
				
				rtnRemt2000Dto.setSevePayPymtDducSum(rtnRemt2000Vo.getSevePayPymtDducSum().longValue());		/** column 퇴직금지급공제금액 : sevePayPymtDducSum */
				rtnRemt2000Dto.setSevePayTurtyPymtSum(rtnRemt2000Vo.getSevePayTurtyPymtSum().longValue());		/** column 퇴직금실지급금액 : sevePayTurtyPymtSum */
				rtnRemt2000Dto.setDdlneYn(MSFSharedUtils.convertStringToBoolean(rtnRemt2000Vo.getDdlneYn()));	/** column 마감여부 : ddlneYn */
				
				rtnRemt2000Dto.setSevePayNoteCtnt(rtnRemt2000Vo.getSevePayNoteCtnt());							/** column 퇴직금비고내용 : sevePayNoteCtnt */
				rtnRemt2000Dto.setSevePayPymtDt(rtnRemt2000Vo.getSevePayPymtDt());								/** column 퇴직금지급일자 : sevePayPymtDt */
				rtnRemt2000Dto.setDdlneDt(rtnRemt2000Vo.getDdlneDt());											/** column 마감일시 : ddlneDt */

			} else {

			}
		} catch (Exception ex) {

			logger.error("EXCEPTION calling activityOnReadRemt0100(): " + ex);
			throw MSFServerUtils.getOperationException("activityOnReadRemt0100", ex, logger);

		}

		finally {

		}

		return rtnRemt2000Dto;
	}

	
	/** 급여내역 퇴직금 재산정11 **/
	@Override
	public Long activityOnUpdatePayr8500ToRemt0100ToPayrCalc(List<InfcPkgRemt2200DTO> listInfcRemt2200dto) throws MSFException {

		Long retval = 0L;

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		try {

			List<InfcPkgRemt2200VO> lstInfcRemt2200Vo = new ArrayList<InfcPkgRemt2200VO>();

			for (int iCnt = 0; iCnt < listInfcRemt2200dto.size(); iCnt++) {

				InfcPkgRemt2200VO infcRemt2200Vo = new InfcPkgRemt2200VO();
				InfcPkgRemt2200DTO remt2200Dto = new InfcPkgRemt2200DTO();

				remt2200Dto = (InfcPkgRemt2200DTO) listInfcRemt2200dto.get(iCnt);

				infcRemt2200Vo.setDpobCd(remt2200Dto.getDpobCd());										/** column 사업장코드 : dpobCd */
				infcRemt2200Vo.setSystemkey(remt2200Dto.getSystemkey());								/** column SYSTEMKEY : systemkey */
				infcRemt2200Vo.setClutYrMnth(remt2200Dto.getClutYrMnth());								/** column 정산년월 : clutYrMnth */
				infcRemt2200Vo.setCalcSevePayPsnDivCd(remt2200Dto.getCalcSevePayPsnDivCd());			/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
				infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(remt2200Dto.getSevePayDtlPatrNum()));/** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
				infcRemt2200Vo.setPayItemCd(remt2200Dto.getPayItemCd());								/** column 급여항목코드 : payItemCd */
				infcRemt2200Vo.setExtpyGrpCd(remt2200Dto.getExtpyGrpCd());								/** column 수당그룹코드 : extpyGrpCd */
				infcRemt2200Vo.setSevePayCmpttnTm(remt2200Dto.getSevePayCmpttnTm());					/** column 퇴직금산정시간 : sevePayCmpttnTm */
				infcRemt2200Vo.setPymtSum(new BigDecimal(remt2200Dto.getPymtSum()));					/** column 지급금액 : pymtSum */

				lstInfcRemt2200Vo.add(infcRemt2200Vo);
			}

			RemtListenerAdapter remtAdapter = new RemtListenerAdapter();
			retval = remtAdapter.setActivityOnUpdateRemt0100ToPayrCalc(RemoteServiceUtil.getThreadLocalRequest(),lstInfcRemt2200Vo);

		} catch (Exception ex) {

			logger.error("EXCEPTION calling activityOnUpdateRemt0100ToPayrCalc(): "+ ex);
			retval = 0L;
			throw MSFServerUtils.getOperationException("activityOnUpdateRemt0100ToPayrCalc", ex, logger);
		} finally {

		}
		return retval;
	}
	
	
	/** 후생복지비 퇴직금 재산정 22**/
	@Override
	public Long activityOnUpdatePayr8500ToRemt0100ToPayrWfepCalc(List<InfcPkgRemt2200DTO> listInfcRemt2200dto) throws MSFException {

		Long retval = 0L;

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		

		try {

			List<InfcPkgRemt2200VO> lstInfcRemt2200Vo = new ArrayList<InfcPkgRemt2200VO>();

			for (int iCnt = 0; iCnt < listInfcRemt2200dto.size(); iCnt++) {

				InfcPkgRemt2200VO infcRemt2200Vo = new InfcPkgRemt2200VO();
				InfcPkgRemt2200DTO remt2200Dto = new InfcPkgRemt2200DTO();

				remt2200Dto = (InfcPkgRemt2200DTO) listInfcRemt2200dto.get(iCnt);

				infcRemt2200Vo.setDpobCd(remt2200Dto.getDpobCd());										/** column 사업장코드 : dpobCd */
				infcRemt2200Vo.setSystemkey(remt2200Dto.getSystemkey());								/** column SYSTEMKEY : systemkey */
				infcRemt2200Vo.setClutYrMnth(remt2200Dto.getClutYrMnth());								/** column 정산년월 : clutYrMnth */
				infcRemt2200Vo.setCalcSevePayPsnDivCd(remt2200Dto.getCalcSevePayPsnDivCd());			/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
				infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(remt2200Dto.getSevePayDtlPatrNum()));/** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
				infcRemt2200Vo.setPayItemCd(remt2200Dto.getPayItemCd());								/** column 급여항목코드 : payItemCd */
				infcRemt2200Vo.setExtpyGrpCd(remt2200Dto.getExtpyGrpCd());								/** column 수당그룹코드 : extpyGrpCd */
				infcRemt2200Vo.setSevePayCmpttnTm(remt2200Dto.getSevePayCmpttnTm());					/** column 퇴직금산정시간 : sevePayCmpttnTm */
				infcRemt2200Vo.setPymtSum(new BigDecimal(remt2200Dto.getPymtSum()));					/** column 지급금액 : pymtSum */

				lstInfcRemt2200Vo.add(infcRemt2200Vo);
			}

			RemtListenerAdapter remtAdapter = new RemtListenerAdapter();
			retval = remtAdapter.setActivityOnUpdateRemt0100ToPayrWfepCalc(RemoteServiceUtil.getThreadLocalRequest(),lstInfcRemt2200Vo);
		} catch (Exception ex) {

			logger.error("EXCEPTION calling activityOnUpdateRemt0100ToPayrWfepCalc(): "+ ex);
			retval = 0L;
			throw MSFServerUtils.getOperationException(
					"activityOnUpdateRemt0100ToPayrWfepCalc", ex, logger);
		} finally {

		}

		return retval;
	}
	
	/** 급여지급기간 셋팅 44**/
	@Override
	public List<InfcPkgRemtDays0100DTO> activityOnPayr8500ToRemt0100Header(InfcPkgRemt2100DTO remt2100Dto) throws MSFException {

		// List<BaseModel> rtnBm = new ArrayList<BaseModel>();

		List<InfcPkgRemtDays0100DTO> rtnBm = new ArrayList<InfcPkgRemtDays0100DTO>();
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

	 
		try {

			remt2100DAO = (InfcPkgRemt2100DAO)BeanFinder.getBean("InfcPkgRemt2100DAO");
			
			InfcPkgRemt2100SrhVO remt2100SrhVo = new InfcPkgRemt2100SrhVO();

			remt2100SrhVo.setDpobCd(MSFSharedUtils.allowNulls(remt2100Dto.getDpobCd()));							/** column 사업장코드 : dpobCd */
			remt2100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(remt2100Dto.getSystemkey()));						/** column SYSTEMKEY : systemkey */
			remt2100SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(remt2100Dto.getCalcSevePayPsnDivCd()));	/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
			remt2100SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(remt2100Dto.getClutYrMnth()));					/** column 정산년월 : clutYrMnth */

			List lstRemtPayr0100Vo = remt2100DAO.selectRemt0100ToRemt2100List(remt2100SrhVo);

			if (lstRemtPayr0100Vo.size() > 0) {

				Iterator<Map<String, Object>> iter = lstRemtPayr0100Vo.iterator();

				while (iter.hasNext()) {

					InfcPkgRemtDays0100DTO remtDays0100Dto = new InfcPkgRemtDays0100DTO();
					Map<String, Object> map = (Map<String, Object>) iter.next();

					remtDays0100Dto.setItemStDt01(MSFSharedUtils.allowNulls(map.get("itemStDt01")));/** set 급여기간시작일자01 : itemStDt01 */
					remtDays0100Dto.setItemEdDt01(MSFSharedUtils.allowNulls(map.get("itemEdDt01")));/** set 급여기간종료일자01 : itemEdDt01 */
					remtDays0100Dto.setItemStDt02(MSFSharedUtils.allowNulls(map.get("itemStDt02")));/** set 급여기간시작일자02 : itemStDt02 */
					remtDays0100Dto.setItemStDt02(MSFSharedUtils.allowNulls(map.get("itemStDt02")));/** set 급여기간종료일자02 : itemEdDt02 */
					remtDays0100Dto.setItemStDt03(MSFSharedUtils.allowNulls(map.get("itemStDt03")));/** set 급여기간시작일자03 : itemStDt03 */
					remtDays0100Dto.setItemStDt03(MSFSharedUtils.allowNulls(map.get("itemStDt03")));/** set 급여기간종료일자03 : itemEdDt03 */
					remtDays0100Dto.setItemStDt04(MSFSharedUtils.allowNulls(map.get("itemStDt04")));/** set 급여기간시작일자04 : itemStDt04 */
					remtDays0100Dto.setItemStDt04(MSFSharedUtils.allowNulls(map.get("itemStDt04")));/** set 급여기간종료일자04 : itemEdDt04 */
					
					remtDays0100Dto.setItemDays01(Long.parseLong(MSFSharedUtils.defaultNulls(map.get("itemDays01"), "0")));		/** set 급여기간일수 : itemDays01 */
					remtDays0100Dto.setItemDays02(Long.parseLong(MSFSharedUtils.defaultNulls(map.get("itemDays02"), "0")));		/** set 급여기간일수 : itemDays02 */
					remtDays0100Dto.setItemDays03(Long.parseLong(MSFSharedUtils.defaultNulls(map.get("itemDays03"), "0")));		/** set 급여기간일수 : itemDays03 */
					remtDays0100Dto.setItemDays04(Long.parseLong(MSFSharedUtils.defaultNulls(map.get("itemDays04"), "0")));		/** set 급여기간일수 : itemDays04 */
					remtDays0100Dto.setItemTotDays(Long.parseLong(MSFSharedUtils.defaultNulls(map.get("itemTotDays"), "0")));	/** set 급여기간총일수 : itemTotDays */

					rtnBm.add(remtDays0100Dto);

				}

			}
		} catch (Exception ex) {

			logger.error("EXCEPTION calling activityOnReadRemt0100(): " + ex);
			throw MSFServerUtils.getOperationException(
					"activityOnReadRemt0100", ex, logger);

		}

		finally {

		}

		return rtnBm;
	}
	
	
	
	@Override
	public PagingLoadResult<ShowMessageBM> activityOnInsertPayr8500ToRemt0100(List<BaseModel> mapModels, InfcPkgRemt2000DTO remt2000Dto)throws MSFException {

		PagingLoadResult<ShowMessageBM> retval = null;

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		try {

			// 대상자선택에 따른 기본산정내역을 산출하는 메서드를 호출한다.
			Iterator<BaseModel> iterRecords = (Iterator<BaseModel>) mapModels.iterator();
			ArrayList<InfcPkgRemt2000VO> lstInfcRemt2000Vo = new ArrayList<InfcPkgRemt2000VO>();

			while (iterRecords.hasNext()) {
				BaseModel bmMapModel = (BaseModel) iterRecords.next();

				InfcPkgRemt2000VO infcRemt2000Vo = new InfcPkgRemt2000VO();

				infcRemt2000Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));							/** column 사업장코드 : dpobCd */
				infcRemt2000Vo.setSystemkey(MSFSharedUtils	.allowNulls(bmMapModel.get("systemkey")));					/** column SYSTEMKEY : systemkey */
				infcRemt2000Vo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(remt2000Dto.getCalcSevePayPsnDivCd()));	/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
				infcRemt2000Vo.setClutYrMnth(MSFSharedUtils.allowNulls(remt2000Dto.getClutYrMnth()));					/** column 정산년월 : clutYrMnth */

				lstInfcRemt2000Vo.add(infcRemt2000Vo);
				// remt2000DAO.insertRemt2000(remt2000Vo);

			}

			RemtListenerAdapter remtAdapter = new RemtListenerAdapter();
			retval = remtAdapter.setRemt0100ToRetirementCalc(RemoteServiceUtil.getThreadLocalRequest(),lstInfcRemt2000Vo);

		} catch (Exception ex) {

			logger.error("EXCEPTION calling activityOnInsertRemt0100(): " + ex);

			throw MSFServerUtils.getOperationException("activityOnInsertRemt0100", ex, logger);
		} finally {

		}
		return retval;
	}
	
	
	
	  /**
	   * 최근 3개월간 기본급여 및 제수당 
	   * @param serviceParameters
	   * @return
	   * @throws MSFException
	   */
	   public PagingLoadResult<BaseModel> getSelectPayrToRemtRemt2200List(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
//	        String method =  CLASS_PAYR_REMT2200_DATALIST;
	        String method =  "com.app.exterms.payroll.server.service.Payr8500ServiceImpl.getSelectPayrToRemtRemt2200List";
	        InfcPkgRemt2200SrhVO   Remt2200SrhVo = new InfcPkgRemt2200SrhVO();
	        InfcPkgRemt2200VO      Remt2200Vo = new InfcPkgRemt2200VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	    	// 1. 암호화 객체 생성
//	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        try {
	        	
	        	remt2200DAO = (InfcPkgRemt2200DAO)BeanFinder.getBean("InfcPkgRemt2200DAO");
	        	
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
	            Remt2200SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드 
	            Remt2200SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키 
	            Remt2200SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYrMnth"))); //퇴직정산년월
	            Remt2200SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnDivCd")));  //퇴직정산구분코드  
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	             if ( pagingValues.executeRecordCount ) { 
	                    
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = remt2200DAO.selectRemt0100ToRemt2200ListTotCnt(Remt2200SrhVo);  
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;        
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginRemt0100ToRemt2200DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            Remt2200SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	Remt2200SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	Remt2200SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list  
	            List list = remt2200DAO.selectRemt0100ToRemt2200List(Remt2200SrhVo);
	            
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

	                 		String rrnDecCrypt = "";
	                    			
	                 		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	                 	          			
	                 	          			
	                 			// 주민번호(복호화)
	                 			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	                 	          		
	                 			strValue = rrnDecCrypt;
	                 						
	                 		}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

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
	                         
	                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
	                    } else {
	                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
	                    }
	                 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
	                    
	                    
	                    bm.set(tableAttributes[i].getName(), baseModelValue);
	                }

	                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
	                bmResult.add(bm);
	            } 

	            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
	            
	            SmrmfUtils.endTiming(logger, millisBeginRemt0100ToRemt2200DataList, "getSelectRemt0100ToRemt2200List");
	       

	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    } 
	   
	   
	   
	/**
	 * 퇴직금급여 - 후생복지비 내역을 조회한다.
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getSelectRemtWfep0100ToRemtRemt2200List(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
//		String method = CLASS_REMTWFEP0100_REMT2200_DATALIST;
		String method = "com.app.exterms.payroll.server.service.Payr8500ServiceImpl.getSelectRemtWfep0100ToRemtRemt2200List";
		InfcPkgRemt2200SrhVO Remt2200SrhVo = new InfcPkgRemt2200SrhVO();
		InfcPkgRemt2200VO Remt2200Vo = new InfcPkgRemt2200VO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		
		// 1. 암호화 객체 생성
//		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils
				.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
 
		try {
			
			remt2200DAO = (InfcPkgRemt2200DAO)BeanFinder.getBean("InfcPkgRemt2200DAO");
			
			// TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가
			// Sysm0400BM user = serviceParameters.getUser();
			ColumnAttribute[] tableAttributes = serviceParameters.getTableAttributes();
			IColumnFilter columnFilters = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders = serviceParameters.getColumnOrders();
			PagingLoadConfig pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			// Get paging configuration
			PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

			// Get query parameters
			// String strCriteriaValue =
			// String.valueOf(MSFServerUtils.getFilterValue(columnFilters,
			// "rpsttvCd"));

			/** 조건절 */
			Remt2200SrhVo.setDpobCd(sessionUser.getDpobCd()); // 사업장코드
			Remt2200SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"))); // 시스템키
			Remt2200SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,	"clutYrMnth"))); // 퇴직정산년월
			Remt2200SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"calcSevePayPsnDivCd"))); // 퇴직정산구분코드

			// Get total record count //전체 데이터 갯수를 가지고 온다.
			if (pagingValues.executeRecordCount) {

				// Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = remt2200DAO.selectRemtWfep0100ToRemt2200ListTotCnt(Remt2200SrhVo);

				SmrmfUtils.endTiming(logger, millisBeginQueryCount,"QueryCount");
				pagingValues.totalRecordCount = iResultCnt;

				logger.debug("totalRecordCount : "+ pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginRemtWfep0100ToRemt2200DataList = SmrmfUtils.startTiming(logger);

			/** 페이지 카운트 처리를 위한 부분 */
			Remt2200SrhVo.setPageSize(pagingValues.totalRecordCount);

			// Apply paging
			if (pagingValues.start > 0) {
				Remt2200SrhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				Remt2200SrhVo.setLastIndex(Math.min(pagingValues.start+ pagingValues.offsetLimit,pagingValues.totalRecordCount));
			}

			// Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			// Collection<Map<String, Object>> list
			List list = remt2200DAO.selectRemtWfep0100ToRemt2200List(Remt2200SrhVo);

			Iterator<Map<String, Object>> iter = list.iterator();

			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");

			while (iter.hasNext()) {
				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = map.get("systemkey").toString();
				BaseModel bm = new BaseModel();

				// bm.setProperties(map);
				for (int i = 0; i < tableAttributes.length; i++) {
					
					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					Object mapCon = map.get(tableAttributes[i].getName());

					switch (tableAttributes[i].getType()) {
					case ColumnDef.TYPE_DATE:
					case ColumnDef.TYPE_DATETIME:

						Date value = SmrmfUtils.getDateFromString(String.valueOf(mapCon), "yyyyMMdd");
						map.put(tableAttributes[i].getName(), value);

						break;
						
					//3. 복호화
					case ColumnDef.TYPE_STRING: 
					          			          			
						String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

						String rrnDecCrypt = "";
				   			
						if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
					          			
					          			
							// 주민번호(복호화)
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					          		
							strValue = rrnDecCrypt;
										
						}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

							// 주민번호(복호화)
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					          		
							strValue = rrnDecCrypt;

				        }
							
					map.put(tableAttributes[i].getName(), strValue);
						                    
					break;

					case ColumnDef.TYPE_LONG:

						if (mapCon != null) {
							Long lValue = (new BigDecimal(mapCon.toString())).longValue();
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
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */
					Object baseModelValue = null;
					// 콤보박스처리를 위해 추가함
					if (tableAttributes[i].getName().contains("$")) {
						String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();

						map.put(tableAttributes[i].getName(),map.get(strMapCon));

						baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()),tableAttributes[i].getType());
					} else {
						baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()),tableAttributes[i].getType());
					}
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 */

					bm.set(tableAttributes[i].getName(), baseModelValue);
				}

				bm.set(TableDef.ID_PROPERTY_NAME, idValue);
				bmResult.add(bm);
			}

			retval = new BasePagingLoadResult<BaseModel>(bmResult,pagingValues.start, pagingValues.totalRecordCount);

			SmrmfUtils.endTiming(logger,millisBeginRemtWfep0100ToRemt2200DataList,"getSelectRemtWfep0100ToRemt2200List");

		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}
	

}
