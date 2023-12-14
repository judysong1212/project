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
package com.app.exterms.basis.server.service;

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
import com.app.exterms.basis.client.dto.Bass5510DTO;
import com.app.exterms.basis.client.service.Bass5510Service;
import com.app.exterms.basis.server.service.dao.Bass5510DAO;
import com.app.exterms.basis.server.vo.Bass5510SrhVO;
import com.app.exterms.basis.server.vo.Bass5510VO;
import com.app.exterms.basis.shared.BasisDaoConstants;
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

@Service("Bass5510Service")
public class Bass5510ServiceImpl  extends AbstractCustomServiceImpl  implements BasisDaoConstants, Bass5510Service {
	private static final Logger logger = LoggerFactory.getLogger(Bass5510ServiceImpl.class);
	private static final String calledClass = Bass5510ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="Bass5510DAO")
    private Bass5510DAO bass5510DAO;
    
    /** ID Generation */
    //@Resource(name="{egovBass5510IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	public PagingLoadResult<BaseModel> getBass5510DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_BASS5510_DATA_LIST;
        Bass5510SrhVO   bass5510SrhVO = new Bass5510SrhVO();
        Bass5510VO      bass5510VO = new Bass5510VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
     
        MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        //beanFinder 추가로 전체 내용 수정 해야 함. 
        bass5510DAO = (Bass5510DAO)BeanFinder.getBean("Bass5510DAO");
        
        
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
            bass5510SrhVO.setDpobCd(sessionUser.getDpobCd());
            bass5510SrhVO.setApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "apptnYr")));
            bass5510SrhVO.setApptnStdBgnnDt(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "apptnStdBgnnDt")));
          
                //Get total record count //전체 데이터 갯수를 가지고 온다. 
    	         if ( pagingValues.executeRecordCount ) { 
    	            	
                    //Execute query that returns a single value
                    TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                     
                    int iResultCnt = bass5510DAO.selectBass5510ListTotCnt(bass5510SrhVO);  
                  
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
            
                TimingInfo millisBeginBass5510DataList = SmrmfUtils.startTiming(logger);
            
                /**페이지 카운트 처리를 위한 부분 */ 
                bass5510SrhVO.setPageSize(pagingValues.totalRecordCount);  
                
          
                //Apply paging
                if (pagingValues.start > 0) {
                	bass5510SrhVO.setFirstIndex(pagingValues.start);
                }
                if (pagingValues.offsetLimit > 0) {
                	bass5510SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));  
                }
                
//            if (!blnExecuteCount) {    
//                bass5510SrhVO.setLastIndex(-1); 
//            }
            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = bass5510DAO.selectBass5510List(bass5510SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginBass5510DataList, "getBass5510DataList");
       

        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }

	public PagingLoadResult<BaseModel> getBass5510ApptnYrList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getBass5510ApptnYrList";
        Bass5510SrhVO   bass5510SrhVO = new Bass5510SrhVO();
        Bass5510VO      bass5510VO = new Bass5510VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
      
        bass5510DAO = (Bass5510DAO)BeanFinder.getBean("Bass5510DAO");
        
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
             bass5510SrhVO.setDpobCd(sessionUser.getDpobCd());
           // sysComSrhVo.setRpsttvCd(sysComBass0300Dto.getRpsttvCd());
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  bass5510DAO.selectBass5510ApptnYrListTotCnt(bass5510SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
               logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectBass5510List = SmrmfUtils.startTiming(logger);
         
          
            /**페이지 카운트 처리를 위한 부분 */ 
            bass5510SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	bass5510SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	bass5510SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }
           

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = bass5510DAO.selectBass5510ApptnYrList(bass5510SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass5510List, "getBass5510ApptnYrList");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }	
	
	
	public PagingLoadResult<BaseModel> getBass5510ApptnStdBgnnDtList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getBass5510ApptnStdBgnnDtList";
        Bass5510SrhVO   bass5510SrhVO = new Bass5510SrhVO();
        Bass5510VO      bass5510VO = new Bass5510VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
         
        bass5510DAO = (Bass5510DAO)BeanFinder.getBean("Bass5510DAO");
        
         
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
             bass5510SrhVO.setDpobCd(sessionUser.getDpobCd());
             bass5510SrhVO.setApptnYr(strCriteriaValue);   //년도 
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  bass5510DAO.selectBass5510ApptnStdBgnnDtListTotCnt(bass5510SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
               logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginBass5510ApptnStdBgnnDtList = SmrmfUtils.startTiming(logger);
         
          
            /**페이지 카운트 처리를 위한 부분 */ 
            bass5510SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	bass5510SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	bass5510SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }
           

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = bass5510DAO.selectBass5510ApptnStdBgnnDtList(bass5510SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginBass5510ApptnStdBgnnDtList, "getBass5510ApptnStdBgnnDtList");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }	
	
	/** 간이소득세액이관 **/
    @Override
    public Long bass5510Transfer(Bass5510DTO bass5510Dto) {
    	
        // TODO Auto-generated method stub 
        Long result = new Long(1);
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());  
		String method = calledClass + ".bass5510Transfer";
        
		int monthS = 1;
		int monthE = 12;
		int maxDays = 0;
		
		String windowNm = "기준정보관리";
		String windowId = "PAYR1000";
        
        try{
        	
            /** ++++++++++++++++++++++  기존 간이세액표 마감 처리를 위한 ++++++++++++++++++++++ **/
            Bass5510VO bass5510Vo = new Bass5510VO();  
            
//            int iResult = bass5510DAO.selectBass5510ListTotCnt(bass5510SrhVo);
            // 마감처리 안된 데이터가 있을 경우
//            if(iResult > 0) {
            	
        	    bass5510Vo.setDpobCd(sessionUser.getDpobCd());
//        	    bass5510Vo.setApptnYr(bass5510Dto.getApptnYr());
        	    bass5510Vo.setApptnYr(bass5510Dto.getCreTransferYr());	//적용년도
//        	    bass5510Vo.setTempApptnYr(bass5510Dto.getCreTransferYr());
//        	    bass5510Vo.setEandIncmBaseDt(MSFSharedUtils.allowNulls(bass5510Dto.getApptnStdBgnnDt()));    /** column null : eandIncmBaseDt */
//        	    bass5510Vo.setApptnStdBgnnDt(bass5510Dto.getApptnStdBgnnDt());			/** column 적용기준시작일자 : apptnStdBgnnDt */
        	    bass5510Vo.setApptnStdEndDt(bass5510Dto.getCreTransferStdBgnnDt());		/** column 적용기준종료일자 : apptnStdEndDt */
//        	    bass5510Vo.setApptnStdEndDt("99991231");
//        	    bass5510Vo.setEandIncmBaseYn(MSFSharedUtils.allowNulls("N"));    		/** column null : eandIncmBaseYn */
				bass5510Vo.setIsmt(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));	/** column 수정자 : ismt */
				bass5510Vo.setRevnAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));    /** column 수정주소 : revnAddr */
				
				bass5510DAO.updateBass5510_apptnStdEndDt(bass5510Vo);
//            }
            /** ++++++++++++++++++++++  기존 간이세액표 마감 처리를 위한 ++++++++++++++++++++++ **/
            
            /** ++++++++++++++++++++++  간이세액소득표 이관 부분 ++++++++++++++++++++++ **/
				Bass5510SrhVO bass5510SrhVo = new Bass5510SrhVO();
				 
	            bass5510SrhVo.setDpobCd(sessionUser.getDpobCd());
	            bass5510SrhVo.setApptnYr(bass5510Dto.getApptnYr());
	            bass5510SrhVo.setApptnStdBgnnDt(bass5510Dto.getApptnStdBgnnDt());
	            bass5510SrhVo.setApptnStdEndDt("99991231");
            
	            
	        //이관할 간이세액소득표 데이터를 가져옴    
			List bass5510YrList = bass5510DAO.getBass5510BeforeList(bass5510SrhVo);
			
			for (int i = 0; i < bass5510YrList.size(); i++) {
				
				bass5510Vo = new Bass5510VO();
				
				EgovMap egovMap = (EgovMap) bass5510YrList.get(i);
				
				bass5510Vo.setDpobCd(MSFSharedUtils.allowNulls(egovMap.get("dpobCd")));    /** column 사업장코드 : dpobCd */
				bass5510Vo.setApptnYr(bass5510Dto.getCreTransferYr());		/** column 적용년도 : apptnYr  - 이관년도 가져옴*/
				bass5510Vo.setEandIncmTxtbSimfTxsNum(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("eandIncmTxtbSimfTxsNum"), "0")));    /** column 근로소득간이세액표일련번호 : eandIncmTxtbSimfTxsNum */
//				bass5510Vo.setApptnStdBgnnDt(MSFSharedUtils.allowNulls(bass5510Dto.getCreTransferStdBgnnDt()));    /** column 적용기준시작일자 : apptnStdBgnnDt */
				
				//========= 시작일자 계산하여 mapping ========	
				Calendar  intiCal =  Calendar.getInstance();
            	SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
            	
            	intiCal.set(Integer.parseInt(bass5510Vo.getApptnYr()), monthS -1, 1);
            	bass5510Vo.setApptnStdBgnnDt(bass5510Dto.getCreTransferStdBgnnDt());/** column 적용기준시작일자 : apptnStdBgnnDt */
            	bass5510Vo.setEandIncmBaseDt(format.format(intiCal.getTime()));    	/** column null : eandIncmBaseDt */
            	bass5510Vo.setApptnStdEndDt(MSFSharedUtils.allowNulls("99991231"));	/** column 적용기준종료일자 : apptnStdEndDt */
            	bass5510Vo.setTempApptnStdEndDt(MSFSharedUtils.allowNulls(String.valueOf(egovMap.get("apptnStdBgnnDt"))));
//        		maxDays = intiCal.getActualMaximum (intiCal.DAY_OF_MONTH); 
//        		Calendar  intieCal =   Calendar.getInstance();
//        	    intieCal.set(Integer.parseInt(bass5510Vo.getApptnYr()), monthE - 1, maxDays); 
//        	    bass5510Vo.setApptnStdEndDt(format.format(intiCal.getTime()));	/** column 적용기준종료일자 : apptnStdEndDt */
            	//========= 시작일자 계산하여 mapping ========	
				
				bass5510Vo.setOvr(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("ovr"), "0")));    /** column 이상 : ovr */
				bass5510Vo.setUdr(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("udr"), "0")));    /** column 미만 : udr */
				bass5510Vo.setOneOfPepl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("oneOfPepl"), "0"))); 	/** column 1인 : oneOfPepl */
				bass5510Vo.setTwoOfPepl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("twoOfPepl"), "0")));    /** column 2인 : twoOfPepl */
				bass5510Vo.setTreOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("treOfGerl"), "0")));    /** column 3인일반 : treOfGerl */
				bass5510Vo.setFurOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("furOfGerl"), "0")));    /** column 4인일반 : furOfGerl */
				bass5510Vo.setFveOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("fveOfGerl"), "0")));    /** column 5인일반 : fveOfGerl */
				bass5510Vo.setSixOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("sixOfGerl"), "0")));    /** column 6인일반 : sixOfGerl */
				bass5510Vo.setSvnOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("svnOfGerl"), "0")));    /** column 7인일반 : svnOfGerl */
				bass5510Vo.setEgtOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("egtOfGerl"), "0")));    /** column 8인일반 : egtOfGerl */
				bass5510Vo.setNineOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("nineOfGerl"), "0")));	/** column 9인일반 : nineOfGerl */
				bass5510Vo.setTenOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("tenOfGerl"), "0")));    /** column 10인일반 : tenOfGerl */
				bass5510Vo.setEvthOfGerl(new BigDecimal(MSFSharedUtils.defaultNulls(egovMap.get("evthOfGerl"), "0")));	/** column 11인일반 : evthOfGerl */
				bass5510Vo.setEandIncmBaseYn(MSFSharedUtils.allowNulls("Y"));    		/** column null : eandIncmBaseYn */
				
				bass5510Vo.setKybdr(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));    /** column 입력자 : kybdr */
//				bass5510Vo.setInptDt(MSFSharedUtils.allowNulls(egovMap.get("inptDt")));    /** column 입력일자 : inptDt */
				bass5510Vo.setInptAddr(MSFSharedUtils.allowNulls(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()));  /** column 입력주소 : inptAddr */
//				bass5510Vo.setIsmt(MSFSharedUtils.allowNulls(egovMap.get("ismt")));    /** column 수정자 : ismt */
//				bass5510Vo.setRevnDt(MSFSharedUtils.allowNulls(egovMap.get("revnDt")));    /** column 수정일자 : revnDt */
//				bass5510Vo.setRevnAddr(MSFSharedUtils.allowNulls(egovMap.get("revnAddr")));    /** column 수정주소 : revnAddr */
				
				bass5510DAO.deleteBass5510_T(bass5510Vo);
 				bass5510DAO.insertBass5510_T(bass5510Vo);
			}
            /** ++++++++++++++++++++++  간이세액소득표 이관 부분 ++++++++++++++++++++++ **/
			
        	
        }catch(Exception e) {
        	result = new Long(0);
            e.printStackTrace();
            
            /** 에러 로그 **/			
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S:U:C:D:B",e, windowNm , windowId);
            
            throw MSFServerUtils.getOperationException("activityOnBass5510", e, logger);
            
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
    public Long activityOnBass5510(Bass5510DTO bass5510Dto, ActionDatabase actionDatabase) {
    	
        // TODO Auto-generated method stub 
        Long result = new Long(1);
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());  
		String method = calledClass + ".activityOnPayr1100";
		
		String windowNm = "기준정보관리";
		String windowId = "PAYR1000";
        
        try{
        	
        	 Bass5510VO bass5510Vo = new Bass5510VO();  
            
        	 bass5510Vo.setDpobCd(sessionUser.getDpobCd());
        	 bass5510Vo.setApptnYr(bass5510Dto.getApptnYr());
        	 bass5510Vo.setEandIncmBaseDt(bass5510Dto.getApptnStdBgnnDt());
        	 
        	 bass5510DAO.deleteBass5510(bass5510Vo);
        	 
        }catch(Exception e) {
        	result = new Long(0);
            e.printStackTrace();
            
            /** 에러 로그 **/			
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D",e, windowNm , windowId); 
            
            throw MSFServerUtils.getOperationException("activityOnBass5510", e, logger);
            
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
