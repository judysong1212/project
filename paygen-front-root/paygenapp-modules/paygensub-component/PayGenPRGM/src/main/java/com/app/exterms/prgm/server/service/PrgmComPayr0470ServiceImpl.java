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
package com.app.exterms.prgm.server.service;

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
import com.app.exterms.prgm.client.dto.PrgmComPayr0470DTO;
import com.app.exterms.prgm.client.service.PrgmComPayr0470Service;
import com.app.exterms.prgm.server.service.dao.PrgmComBass0500DAO;
import com.app.exterms.prgm.server.service.dao.PrgmComPayr0470DAO;
import com.app.exterms.prgm.server.vo.PrgmComPayr0470SrhVO;
import com.app.exterms.prgm.server.vo.PrgmComPayr0470VO;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerExtAuth;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
//import com.googlecode.ehcache.annotations.Cacheable;
@Service("PrgmComPayr0470Service")  
public class PrgmComPayr0470ServiceImpl extends AbstractCustomServiceImpl implements PrgmComDaoConstants,PrgmComPayr0470Service {
    
    private static final Logger logger = LoggerFactory.getLogger(PrgmComPayr0470ServiceImpl.class);

    public PrgmComPayr0470ServiceImpl() {
    
    }
        
    @Autowired
    @Resource(name="PrgmComPayr0470DAO")
    private PrgmComPayr0470DAO payr0470DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPayr0470IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

//    /**
//     * PAYR0480을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Payr0470VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    public String insertPayr0470(PrgmComPayr0470VO vo) throws Exception {
//        log.debug(vo.toString());
//        
//        /** ID Generation Service */
//        //TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//        //String id = egovIdGnrService.getNextStringId();
//        //vo.setId(id);
//        log.debug(vo.toString());
//        
//        payr0470DAO.insertPayr0470(vo);
//        //TODO 해당 테이블 정보에 맞게 수정     
//        return null;
//    }
//
//    /**
//     * PAYR0480을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Payr0470VO
//     * @return void형
//     * @exception Exception
//     */
//    public void updatePayr0470(PrgmComPayr0470VO vo) throws Exception {
//        payr0470DAO.updatePayr0470(vo);
//    }
//
//    /**
//     * PAYR0480을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Payr0470VO
//     * @return void형 
//     * @exception Exception
//     */
//    public void deletePayr0470(PrgmComPayr0470VO vo) throws Exception {
//        payr0470DAO.deletePayr0470(vo);
//    }
//
//    /**
//     * PAYR0480을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Payr0470VO
//     * @return 조회한 PAYR0480
//     * @exception Exception
//     */
//    public PrgmComPayr0470VO selectPayr0470(PrgmComPayr0470VO vo) throws Exception {
//        PrgmComPayr0470VO resultVO = payr0470DAO.selectPayr0470(vo);
//        if (resultVO == null)
//            throw processException("info.nodata.msg");
//        return resultVO;
//    }
//
//    /**
//     * PAYR0480 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return PAYR0480 목록
//     * @exception Exception
//     */
//    public List selectPayr0470List(PrgmComPayr0470SrhVO searchVO) throws Exception {
//        return payr0470DAO.selectPayr0470List(searchVO);
//    }
//
//    /**
//     * PAYR0480 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return PAYR0480 총 갯수
//     * @exception
//     */
//    public int selectPayr0470ListTotCnt(PrgmComPayr0470SrhVO searchVO) {
//        return payr0470DAO.selectPayr0470ListTotCnt(searchVO);
//    }
    
 
    public PagingLoadResult<BaseModel> getPrgmComLookupPayr0470List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  PRGMCOM_METHOD_COMBO_PAYR0470_LIST;
        PrgmComPayr0470SrhVO   sysComPayr0470SrhVo = new PrgmComPayr0470SrhVO();
        PrgmComPayr0470VO sysComPayr0470Vo = new PrgmComPayr0470VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(payr0470DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            payr0470DAO = (PrgmComPayr0470DAO) wac.getBean("PrgmComPayr0470DAO" ); 
//        }
        payr0470DAO = (PrgmComPayr0470DAO)BeanFinder.getBean("PrgmComPayr0470DAO");
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0100BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
           
            /** 조건절 */
            sysComPayr0470SrhVo.setDpobCd(sessionUser.getDpobCd()); 
//            if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(sessionUser.getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(sessionUser.getUsrDivCd()))) {
//                sysComPayr0470SrhVo.setPayrTermUseYn("Y");
//                
//            } else {
//                sysComPayr0470SrhVo.setPayrTermUseYn("");
//            }
         
            sysComPayr0470SrhVo.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));   
            sysComPayr0470SrhVo.setPayDducNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payDducNm")));   
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
            if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
               
                int iResultCnt = payr0470DAO.selectPrgmComPayr0470ListTotCnt(sysComPayr0470SrhVo);  
                pagingValues.offsetLimit = iResultCnt;       
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPayr0470List = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            sysComPayr0470SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                sysComPayr0470SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                 sysComPayr0470SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0470DAO.selectPrgmComPayr0470List(sysComPayr0470SrhVo);
            
                Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payDducCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayr0470List, "selectPayr0470List");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
    
    public PagingLoadResult<BaseModel> getPrgmComPopupPayr0470List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  "getPrgmComPopupPayr0470List";
        PrgmComPayr0470SrhVO   sysComPayr0470SrhVo = new PrgmComPayr0470SrhVO();
        PrgmComPayr0470VO sysComPayr0470Vo = new PrgmComPayr0470VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        payr0470DAO = (PrgmComPayr0470DAO)BeanFinder.getBean("PrgmComPayr0470DAO");
//        if  (MSFSharedUtils.paramNull(payr0470DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            payr0470DAO = (PrgmComPayr0470DAO) wac.getBean("PrgmComPayr0470DAO" ); 
//        }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0100BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
           
            /** 조건절 */
            sysComPayr0470SrhVo.setDpobCd(sessionUser.getDpobCd()); 
//            if ( (MSFConfiguration.AUTH_USR_DIV_20.equals(sessionUser.getUsrDivCd())) || (MSFConfiguration.AUTH_USR_DIV_40.equals(sessionUser.getUsrDivCd()))) {
//                sysComPayr0470SrhVo.setPayrTermUseYn("Y");
//                
//            } else {
//                sysComPayr0470SrhVo.setPayrTermUseYn("");
//            }
         
            sysComPayr0470SrhVo.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));   
            sysComPayr0470SrhVo.setPayDducNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payDducNm")));   
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
                if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0470DAO.selectPrgmComPayr0470ListTotCnt(sysComPayr0470SrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPayr0470List = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            sysComPayr0470SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                sysComPayr0470SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                 sysComPayr0470SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0470DAO.selectPrgmComPayr0470List(sysComPayr0470SrhVo);
            
                Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payDducCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayr0470List, "selectPayr0470List");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
    
    public List<BaseModel> getPrgmComComboPayr0470List(PrgmComPayr0470DTO sysComPayr0470Dto) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getPrgmComComboPayr0470List";
        PrgmComPayr0470SrhVO  sysComPayr0470SrhVo = new PrgmComPayr0470SrhVO();
        PrgmComPayr0470VO sysComPayr0470Vo = new PrgmComPayr0470VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        MSFServerExtAuth msfServerExtAuth = MSFServerExtAuth.getInstance();
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        	 payr0470DAO = (PrgmComPayr0470DAO)BeanFinder.getBean("PrgmComPayr0470DAO");
//        	 if  (MSFSharedUtils.paramNull(payr0470DAO)) {
//        	        
//                 WebApplicationContext wac = WebApplicationContextUtils.
//                         getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//                 payr0470DAO = (PrgmComPayr0470DAO) wac.getBean("PrgmComPayr0470DAO" ); 
//             }
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
 	        
        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                     ,new ColumnAttribute("payDducCd", "payDducCd", ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("payDducNm", "payDducNm", ColumnDef.TYPE_STRING)
                      };
        	
            //Get paging configuration
           // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
        	sysComPayr0470SrhVo.setDpobCd(sessionUser.getDpobCd());
            
            
        	sysComPayr0470SrhVo.setPymtDducDivCd(sysComPayr0470Dto.getPymtDducDivCd());
        	sysComPayr0470SrhVo.setPayDducUseYn((Boolean.TRUE.equals(sysComPayr0470Dto.getPayDducUseYn()) ? "Y" : "N")); 
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        //    if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  payr0470DAO.selectPrgmComPayr0470ListTotCnt(sysComPayr0470SrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
         //       pagingValues.totalRecordCount = iResultCnt;	       
                
         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         //  }
        
            TimingInfo millisBeginSelectPayr0470List = SmrmfUtils.startTiming(logger);
        
        	 

            /**페이지 카운트 처리를 위한 부분 */ 
          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
           // 	sysComSrhVo.setFirstIndex(pagingValues.start);
           // }
           // if (pagingValues.offsetLimit > 0) {
           // 	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            sysComPayr0470SrhVo.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0470DAO.selectPrgmComPayr0470List(sysComPayr0470SrhVo);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payDducCd").toString();
                BaseModel bm = new BaseModel();

                //bm.setProperties(map);
                for ( int i=0 ; i<columnAttributes.length ; i++ ) {
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(columnAttributes[i].getName()), columnAttributes[i].getType());
                    bm.set(columnAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            //retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayr0470List, "selectPayr0470List"); 
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return bmResult;
    }
}
