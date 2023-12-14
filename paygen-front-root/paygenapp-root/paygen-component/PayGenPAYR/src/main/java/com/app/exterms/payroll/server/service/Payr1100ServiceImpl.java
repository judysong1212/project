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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.any.smrmf.utils.BeanFinder;
import com.app.exterms.payroll.client.dto.Payr0100DTO;
import com.app.exterms.payroll.client.service.Payr1100Service;
import com.app.exterms.payroll.server.service.dao.Payr0100DAO;
import com.app.exterms.payroll.server.vo.Payr0100SrhVO;
import com.app.exterms.payroll.server.vo.Payr0100VO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("Payr1100Service")
public class Payr1100ServiceImpl  extends AbstractCustomServiceImpl  implements PayrDaoConstants, Payr1100Service {
	private static final Logger logger = LoggerFactory.getLogger(Payr1100ServiceImpl.class);
	private static final String calledClass = Payr1100ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="Payr0100DAO")
    private Payr0100DAO payr0100DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPayr0100IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	public PagingLoadResult<BaseModel> getPayr0100DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0100_DATA_LIST;
        Payr0100SrhVO   payr0100SrhVO = new Payr0100SrhVO();
        Payr0100VO      payr0100VO = new Payr0100VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
     
        MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        //beanFinder 추가로 전체 내용 수정 해야 함. 
        payr0100DAO = (Payr0100DAO)BeanFinder.getBean("Payr0100DAO");
        
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0100BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
//            Boolean blnExecuteCount            = serviceParameters.isNoPageData();
            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
            payr0100SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0100SrhVO.setApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "apptnYr")));
            payr0100SrhVO.setApptnStdBgnnDt(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "apptnStdBgnnDt")));
          
                //Get total record count //전체 데이터 갯수를 가지고 온다. 
    	         if ( pagingValues.executeRecordCount ) { 
    	            	
                    //Execute query that returns a single value
                    TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                     
                    int iResultCnt = payr0100DAO.selectPayr0100ListTotCnt(payr0100SrhVO);  
                  
//                    SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
//                    pagingValues.totalRecordCount = iResultCnt;	       
//                    
//                    logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
                    
                	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
    	          	
    	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                    if (!pagingValues.pageExecute) { 
                        pagingValues.offsetLimit = iResultCnt;       
                    }
                    
    	         	pagingValues.totalRecordCount = iResultCnt;	       
    	                
    	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
                }
            
                TimingInfo millisBeginPayr0100DataList = SmrmfUtils.startTiming(logger);
            
                /**페이지 카운트 처리를 위한 부분 */ 
                payr0100SrhVO.setPageSize(pagingValues.totalRecordCount);  
                
          
                //Apply paging
                if (pagingValues.start > 0) {
                	payr0100SrhVO.setFirstIndex(pagingValues.start);
                }
                if (pagingValues.offsetLimit > 0) {
                	payr0100SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));  
                }
                
//            if (!blnExecuteCount) {    
//                payr0100SrhVO.setLastIndex(-1); 
//            }
            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0100DAO.selectPayr0100List(payr0100SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
            
        
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("apptnStdBgnnDt").toString();
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
                	
                  //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                 
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0100DataList, "getPayr0100DataList");
       

        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }

	public PagingLoadResult<BaseModel> getPayr0100ApptnYrList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getPayr0100ApptnYrList";
        Payr0100SrhVO   payr0100SrhVO = new Payr0100SrhVO();
        Payr0100VO      payr0100VO = new Payr0100VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
      
        payr0100DAO = (Payr0100DAO)BeanFinder.getBean("Payr0100DAO");
        
        try {
          
             ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
             IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
             List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
             PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
 	         
        	
            //Get paging configuration
             PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
             payr0100SrhVO.setDpobCd(sessionUser.getDpobCd());
           // sysComSrhVo.setRpsttvCd(sysComBass0300Dto.getRpsttvCd());
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  payr0100DAO.selectPayr0100ApptnYrListTotCnt(payr0100SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
               logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPayr0100List = SmrmfUtils.startTiming(logger);
         
          
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0100SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0100SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0100SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }
           

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0100DAO.selectPayr0100ApptnYrList(payr0100SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("apptnYr").toString();
                BaseModel bm = new BaseModel();

                //bm.setProperties(map);
                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayr0100List, "getPayr0100ApptnYrList");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }	
	
	
	public PagingLoadResult<BaseModel> getPayr0100ApptnStdBgnnDtList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getPayr0100ApptnStdBgnnDtList";
        Payr0100SrhVO   payr0100SrhVO = new Payr0100SrhVO();
        Payr0100VO      payr0100VO = new Payr0100VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
         
        payr0100DAO = (Payr0100DAO)BeanFinder.getBean("Payr0100DAO");
        
         
        try {
          
             ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
             IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
             List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
             PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
 	         
        	
            //Get paging configuration
             PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
             String strCriteriaValue = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "apptnYr"));
           
            /** 조건절 */
             payr0100SrhVO.setDpobCd(sessionUser.getDpobCd());
             payr0100SrhVO.setApptnYr(strCriteriaValue);   //년도 
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  payr0100DAO.selectPayr0100ApptnStdBgnnDtListTotCnt(payr0100SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
               logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0100ApptnStdBgnnDtList = SmrmfUtils.startTiming(logger);
         
          
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0100SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0100SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0100SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }
           

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0100DAO.selectPayr0100ApptnStdBgnnDtList(payr0100SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("apptnStdBgnnDt").toString();
                BaseModel bm = new BaseModel();

                //bm.setProperties(map);
                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0100ApptnStdBgnnDtList, "getPayr0100ApptnStdBgnnDtList");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }	
	
	/** 간이소득세액이관 **/
    @Override
    public Long payr0100Transfer(Payr0100DTO payr0100Dto) {
    	
        // TODO Auto-generated method stub 
        Long result = new Long(1);
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());  
		String method = calledClass + ".payr0100Transfer";
        
		int monthS = 1;
		int monthE = 12;
		int maxDays = 0;
		
		String windowNm = "기준정보관리";
		String windowId = "PAYR1000";
        
        try{
        	
            /** ++++++++++++++++++++++  기존 간이세액표 마감 처리를 위한 ++++++++++++++++++++++ **/
            Payr0100VO payr0100Vo = new Payr0100VO();  
            
//            int iResult = payr0100DAO.selectPayr0100ListTotCnt(payr0100SrhVo);
            // 마감처리 안된 데이터가 있을 경우
//            if(iResult > 0) {
            	
        	    payr0100Vo.setDpobCd(sessionUser.getDpobCd());
//        	    payr0100Vo.setApptnYr(payr0100Dto.getApptnYr());
        	    payr0100Vo.setApptnYr(payr0100Dto.getCreTransferYr());	//적용년도
//        	    payr0100Vo.setTempApptnYr(payr0100Dto.getCreTransferYr());
//        	    payr0100Vo.setEandIncmBaseDt(MSFSharedUtils.allowNulls(payr0100Dto.getApptnStdBgnnDt()));    /** column null : eandIncmBaseDt */
//        	    payr0100Vo.setApptnStdBgnnDt(payr0100Dto.getApptnStdBgnnDt());			/** column 적용기준시작일자 : apptnStdBgnnDt */
        	    payr0100Vo.setApptnStdEndDt(payr0100Dto.getCreTransferStdBgnnDt());		/** column 적용기준종료일자 : apptnStdEndDt */
//        	    payr0100Vo.setApptnStdEndDt("99991231");
//        	    payr0100Vo.setEandIncmBaseYn(MSFSharedUtils.allowNulls("N"));    		/** column null : eandIncmBaseYn */
				payr0100Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));	/** column 수정자 : ismt */
				payr0100Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));    /** column 수정주소 : revnAddr */
				
				payr0100DAO.updatePayr0100_apptnStdEndDt(payr0100Vo);
//            }
            /** ++++++++++++++++++++++  기존 간이세액표 마감 처리를 위한 ++++++++++++++++++++++ **/
            
            /** ++++++++++++++++++++++  간이세액소득표 이관 부분 ++++++++++++++++++++++ **/
				Payr0100SrhVO payr0100SrhVo = new Payr0100SrhVO();
				 
	            payr0100SrhVo.setDpobCd(sessionUser.getDpobCd());
	            payr0100SrhVo.setApptnYr(payr0100Dto.getApptnYr());
	            payr0100SrhVo.setApptnStdBgnnDt(payr0100Dto.getApptnStdBgnnDt());
	            payr0100SrhVo.setApptnStdEndDt("99991231");
            
	            
	        //이관할 간이세액소득표 데이터를 가져옴    
			List payr0100YrList = payr0100DAO.getPayr0100BeforeList(payr0100SrhVo);
			
			for (int i = 0; i < payr0100YrList.size(); i++) {
				
				payr0100Vo = new Payr0100VO();
				
				EgovMap egovMap = (EgovMap) payr0100YrList.get(i);
				
				payr0100Vo.setDpobCd(MSFSharedUtils.allowNulls(egovMap.get("dpobCd")));    /** column 사업장코드 : dpobCd */
				payr0100Vo.setApptnYr(payr0100Dto.getCreTransferYr());		/** column 적용년도 : apptnYr  - 이관년도 가져옴*/
				payr0100Vo.setEandIncmTxtbSimfTxsNum(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("eandIncmTxtbSimfTxsNum"), "0")));    /** column 근로소득간이세액표일련번호 : eandIncmTxtbSimfTxsNum */
//				payr0100Vo.setApptnStdBgnnDt(MSFSharedUtils.allowNulls(payr0100Dto.getCreTransferStdBgnnDt()));    /** column 적용기준시작일자 : apptnStdBgnnDt */
				
				//========= 시작일자 계산하여 mapping ========	
				Calendar  intiCal =  Calendar.getInstance();
            	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            	
            	intiCal.set(Integer.parseInt(payr0100Vo.getApptnYr()), monthS -1, 1);
            	payr0100Vo.setApptnStdBgnnDt(payr0100Dto.getCreTransferStdBgnnDt());/** column 적용기준시작일자 : apptnStdBgnnDt */
            	payr0100Vo.setEandIncmBaseDt(format.format(intiCal.getTime()));    	/** column null : eandIncmBaseDt */
            	payr0100Vo.setApptnStdEndDt(MSFSharedUtils.allowNulls("99991231"));	/** column 적용기준종료일자 : apptnStdEndDt */
            	payr0100Vo.setTempApptnStdEndDt(MSFSharedUtils.allowNulls(String.valueOf(egovMap.get("apptnStdBgnnDt"))));
//        		maxDays = intiCal.getActualMaximum (intiCal.DAY_OF_MONTH); 
//        		Calendar  intieCal =   Calendar.getInstance();
//        	    intieCal.set(Integer.parseInt(payr0100Vo.getApptnYr()), monthE - 1, maxDays); 
//        	    payr0100Vo.setApptnStdEndDt(format.format(intiCal.getTime()));	/** column 적용기준종료일자 : apptnStdEndDt */
            	//========= 시작일자 계산하여 mapping ========	
				
				payr0100Vo.setOvr(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("ovr"), "0")));    /** column 이상 : ovr */
				payr0100Vo.setUdr(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("udr"), "0")));    /** column 미만 : udr */
				payr0100Vo.setOneOfPepl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("oneOfPepl"), "0"))); 	/** column 1인 : oneOfPepl */
				payr0100Vo.setTwoOfPepl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("twoOfPepl"), "0")));    /** column 2인 : twoOfPepl */
				payr0100Vo.setTreOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("treOfGerl"), "0")));    /** column 3인일반 : treOfGerl */
				payr0100Vo.setFurOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("furOfGerl"), "0")));    /** column 4인일반 : furOfGerl */
				payr0100Vo.setFveOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("fveOfGerl"), "0")));    /** column 5인일반 : fveOfGerl */
				payr0100Vo.setSixOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("sixOfGerl"), "0")));    /** column 6인일반 : sixOfGerl */
				payr0100Vo.setSvnOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("svnOfGerl"), "0")));    /** column 7인일반 : svnOfGerl */
				payr0100Vo.setEgtOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("egtOfGerl"), "0")));    /** column 8인일반 : egtOfGerl */
				payr0100Vo.setNineOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("nineOfGerl"), "0")));	/** column 9인일반 : nineOfGerl */
				payr0100Vo.setTenOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("tenOfGerl"), "0")));    /** column 10인일반 : tenOfGerl */
				payr0100Vo.setEvthOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("evthOfGerl"), "0")));	/** column 11인일반 : evthOfGerl */
				payr0100Vo.setEandIncmBaseYn(MSFSharedUtils.allowNulls("Y"));    		/** column null : eandIncmBaseYn */
				
				payr0100Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    /** column 입력자 : kybdr */
//				payr0100Vo.setInptDt(MSFSharedUtils.allowNulls(egovMap.get("inptDt")));    /** column 입력일자 : inptDt */
				payr0100Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  /** column 입력주소 : inptAddr */
//				payr0100Vo.setIsmt(MSFSharedUtils.allowNulls(egovMap.get("ismt")));    /** column 수정자 : ismt */
//				payr0100Vo.setRevnDt(MSFSharedUtils.allowNulls(egovMap.get("revnDt")));    /** column 수정일자 : revnDt */
//				payr0100Vo.setRevnAddr(MSFSharedUtils.allowNulls(egovMap.get("revnAddr")));    /** column 수정주소 : revnAddr */
				
				payr0100DAO.deletePayr0100_T(payr0100Vo);
 				payr0100DAO.insertPayr0100_T(payr0100Vo);
			}
            /** ++++++++++++++++++++++  간이세액소득표 이관 부분 ++++++++++++++++++++++ **/
			
        	
        }catch(Exception e) {
        	result = new Long(0);
            e.printStackTrace();
            
            /** 에러 로그 **/			
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:U:C:D:B",e, windowNm , windowId);
            
            throw MSFServerUtils.getOperationException("activityOnPayr0100", e, logger);
            
        }finally {
          
        }
        
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:U:C:D:B");
		
        return result;
    }
    
    
    
	/** 간이세액소득표 삭제 **/
    @Override
    public Long activityOnPayr1100(Payr0100DTO payr0100Dto, ActionDatabase actionDatabase) {
    	
        // TODO Auto-generated method stub 
        Long result = new Long(1);
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());  
		String method = calledClass + ".activityOnPayr1100";
		
		String windowNm = "기준정보관리";
		String windowId = "PAYR1000";
        
        try{
        	
        	 Payr0100VO payr0100Vo = new Payr0100VO();  
            
        	 payr0100Vo.setDpobCd(sessionUser.getDpobCd());
        	 payr0100Vo.setApptnYr(payr0100Dto.getApptnYr());
        	 payr0100Vo.setEandIncmBaseDt(payr0100Dto.getApptnStdBgnnDt());
        	 
        	 payr0100DAO.deletePayr0100(payr0100Vo);
        	 
        }catch(Exception e) {
        	result = new Long(0);
            e.printStackTrace();
            
            /** 에러 로그 **/			
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D",e, windowNm , windowId); 
            
            throw MSFServerUtils.getOperationException("activityOnPayr0100", e, logger);
            
        }finally {
          
        }
        
        /** 로그반영
         * CRUDSBLO
		 * C:create		R:read		U:update
	     * D:delete		S:select	B:배치 
	     * L:로그인		O:로그아웃
	     */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D");
			
        return result;
        
    }
	 
	
}
