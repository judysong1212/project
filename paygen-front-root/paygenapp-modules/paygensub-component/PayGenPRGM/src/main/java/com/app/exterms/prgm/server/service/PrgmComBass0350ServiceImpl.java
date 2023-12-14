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
import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0350Service;
import com.app.exterms.prgm.server.service.dao.PrgmComBass0300DAO;
import com.app.exterms.prgm.server.service.dao.PrgmComBass0320DAO;
import com.app.exterms.prgm.server.service.dao.PrgmComBass0350DAO;
import com.app.exterms.prgm.server.utils.PrgmComServerUtils;
import com.app.exterms.prgm.server.vo.PrgmComBass0320VO;
import com.app.exterms.prgm.server.vo.PrgmComBass0350VO;
import com.app.exterms.prgm.server.vo.PrgmComSearchVO;
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

@Service("PrgmComBass0350Service")
public class PrgmComBass0350ServiceImpl extends AbstractCustomServiceImpl implements  PrgmComBass0350Service , PrgmComDaoConstants {
	

	private static final Logger logger = LoggerFactory.getLogger(PrgmComBass0350ServiceImpl.class);
	private static final String calledClass = PrgmComBass0350ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="PrgmComBass0350DAO")
    private PrgmComBass0350DAO bass0350DAO;
	
	@Autowired
    @Resource(name="PrgmComBass0320DAO")
    private PrgmComBass0320DAO bass0320DAO;
	
	 
    
    /** ID Generation */
    //@Resource(name="{egovBass0350IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
 
   
	/**
	 * <pre>
	 * 1. 개요 : 일반 콤보형태 처리 직종세 
	 * 2. 처리내용 : PrgmComComboUtils.class 에서  getSingleBass0350ComboData(PrgmComBass0350DTO sysComBass0350Dto) 에서 호출 
	 * </pre>
	 * @Method Name : getPrgmComComboBass0350List
	 * @date : Nov 16, 2015
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Nov 16, 2015		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.app.exterms.prgm.client.service.PrgmComBass0350Service#getPrgmComComboBass0350List(com.app.exterms.prgm.client.dto.PrgmComBass0350DTO)
	 * @param sysComBass0350Dto
	 * @return
	 * @throws MSFException
	 */ 	
	public List<BaseModel> getPrgmComComboBass0350List(PrgmComBass0350DTO sysComBass0350Dto) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getPrgmComComboBass0350List";
        PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
        PrgmComBass0350VO sysComBass0350Vo = new PrgmComBass0350VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        List<String> listDeptCd = new ArrayList<String>();
//        if  (MSFSharedUtils.paramNull(bass0350DAO)) {
//            
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            bass0350DAO = (PrgmComBass0350DAO) wac.getBean("PrgmComBass0350DAO" ); 
//        }
        
        bass0350DAO = (PrgmComBass0350DAO)BeanFinder.getBean("PrgmComBass0350DAO");
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
           
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
  
        	   ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                       new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                      ,new ColumnAttribute("typOccuCd", "typOccuCd", ColumnDef.TYPE_STRING ) 
                       ,new ColumnAttribute("dtilOccuInttnCd", "dtilOccuInttnCd", ColumnDef.TYPE_STRING )   //직종세 통합코드 
                      ,new ColumnAttribute("dtilOccuClsDivCd", "dtilOccuClsDivCd", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("pyspGrdeCd", "pyspGrdeCd", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("dtilOccuClsNm", "dtilOccuClsNm", ColumnDef.TYPE_STRING)};
       
        	
            //Get paging configuration
           // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
           
        	   /** 조건절 */
               sysComSrhVo.setDpobCd(sessionUser.getDpobCd()); 
               sysComSrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());
               sysComSrhVo.setUsrId(sessionUser.getUsrId());
               sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
               /******************************** 권한 ************************************************************************/
               String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
               if ("FALSE".equals(chkDeptCd)) {
            	   
           	     if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(sysComBass0350Dto.getDeptCd(),sessionUser.getDeptCd()))) {
       			    sysComSrhVo.setDeptCd(sessionUser.getDeptCd()); 
                    listDeptCd.add( sessionUser.getDeptCd() );
                    sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드    
            	   } else {
            		   sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()));
                       listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()));  
                       sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드   
            		 
            	  }  
           	    
                  
               } else { 
               	 
               	
                    sysComSrhVo.setPayrMangDeptCd(MSFSharedUtils.defaultNulls(sysComBass0350Dto.getPayrMangDeptCd(),sessionUser.getTplvlDeptCd()));    
                    if (sysComSrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()))) { 
                        listDeptCd = null; 
                    	sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                    	sysComSrhVo.setDeptCd("");  //부서코드
                    } else {
                   	     sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()));
                         listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()));  
                         sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                    } 
                     
               } 
               sysComSrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
               sysComSrhVo.setDtilOccuInttnCdAuth("");
               /******************************** 권한 ************************************************************************/
               List<String> lstTypeOccuCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(sysComBass0350Dto.getTypOccuCd())); 
               sysComSrhVo.setTypOccuCdArr(lstTypeOccuCd); 
               sysComSrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(sysComBass0350Dto.getTypOccuCd())); 
         
            //  sysComSrhVo.setPyspGrdeCd( sysComBass0350Dto.getPyspGrdeCd()); 
            
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        //    if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  bass0350DAO.selectBass0350ListTotCnt(sysComSrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
         //       pagingValues.totalRecordCount = iResultCnt;	       
                
         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         //  }
        
            TimingInfo millisBeginSelectBass0350List = SmrmfUtils.startTiming(logger);
        
        	 

            /**페이지 카운트 처리를 위한 부분 */ 
          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
           // 	sysComSrhVo.setFirstIndex(pagingValues.start);
           // }
           // if (pagingValues.offsetLimit > 0) {
           // 	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            sysComSrhVo.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = bass0350DAO.selectBass0350List(sysComSrhVo);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("typOccuCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0350List, "selectBass0350List");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
        	throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return bmResult;
    } 
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 권한 없이 직종세 데이타 가져오기  
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getPrgmComboNonBass0350List
	 * @date : Apr 21, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Apr 21, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.app.exterms.prgm.client.service.PrgmComBass0350Service#getPrgmComboNonBass0350List(com.app.exterms.prgm.client.dto.PrgmComBass0350DTO)
	 * @param sysComBass0350Dto
	 * @return
	 * @throws MSFException
	 */
	public List<BaseModel> getPrgmComboNonBass0350List(PrgmComBass0350DTO sysComBass0350Dto) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getPrgmComboNonBass0350List";
        PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
        PrgmComBass0350VO sysComBass0350Vo = new PrgmComBass0350VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        List<String> listDeptCd = new ArrayList<String>();
//        if  (MSFSharedUtils.paramNull(bass0350DAO)) {
//            
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            bass0350DAO = (PrgmComBass0350DAO) wac.getBean("PrgmComBass0350DAO" ); 
//        }
        bass0350DAO = (PrgmComBass0350DAO)BeanFinder.getBean("PrgmComBass0350DAO");
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
           
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
  
        	   ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                       new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                      ,new ColumnAttribute("typOccuCd", "typOccuCd", ColumnDef.TYPE_STRING ) 
                       ,new ColumnAttribute("dtilOccuInttnCd", "dtilOccuInttnCd", ColumnDef.TYPE_STRING )   //직종세 통합코드 
                      ,new ColumnAttribute("dtilOccuClsDivCd", "dtilOccuClsDivCd", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("pyspGrdeCd", "pyspGrdeCd", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("dtilOccuClsNm", "dtilOccuClsNm", ColumnDef.TYPE_STRING)};
       
        	
            //Get paging configuration
           // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
         
        	   /** 조건절 */
               sysComSrhVo.setDpobCd(sessionUser.getDpobCd()); 
               
               List<String> lstTypeOccuCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(sysComBass0350Dto.getTypOccuCd())); 
               sysComSrhVo.setTypOccuCdArr(lstTypeOccuCd); 
               sysComSrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(sysComBass0350Dto.getTypOccuCd())); 
         
               sysComSrhVo.setDtilOccuClsUseYn(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDtilOccuClsUseYn()));
            
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        //    if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  bass0350DAO.selectNonBass0350ListTotCnt(sysComSrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
         //       pagingValues.totalRecordCount = iResultCnt;	       
                
         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         //  }
        
            TimingInfo millisBeginSelectBass0350List = SmrmfUtils.startTiming(logger);
        
        	 

            /**페이지 카운트 처리를 위한 부분 */ 
          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
           // 	sysComSrhVo.setFirstIndex(pagingValues.start);
           // }
           // if (pagingValues.offsetLimit > 0) {
           // 	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            sysComSrhVo.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = bass0350DAO.selectNonBass0350List(sysComSrhVo);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("dtilOccuInttnCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0350List, "selectBass0350List");
             

        }
        catch (Exception ex) {
            //Return operation exception
        	throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return bmResult;
    } 
 
	/**
	 * <pre>
	 * 1. 개요 : 콤보 형태를 공통 rpc 로직을 호출 하여 처리 할 경우 
	 * 2. 처리내용 : LookupPrgmComBass0350 에서 호출하여 사용함.
	 * </pre>
	 * @Method Name : getPrgmComLookBass0350List
	 * @date : Nov 16, 2015
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Nov 16, 2015		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */ 	
	public PagingLoadResult<BaseModel> getPrgmComLookBass0350List(ServiceParameters serviceParameters) throws MSFException {

		    PagingLoadResult<BaseModel> retval = null;
	        String method = "getPrgmComLookBass0350List";
	        PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
	        PrgmComBass0350VO sysComBass0350VO = new PrgmComBass0350VO();
	        List<BaseModel> bmResult = new ArrayList<BaseModel>();
	        List<String> listDeptCd = new ArrayList<String>();
//	        if  (MSFSharedUtils.paramNull(bass0350DAO)) {
//	            
//	            WebApplicationContext wac = WebApplicationContextUtils.
//	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//	            bass0350DAO = (PrgmComBass0350DAO) wac.getBean("PrgmComBass0350DAO" ); 
//	        }
	        
	        bass0350DAO = (PrgmComBass0350DAO)BeanFinder.getBean("PrgmComBass0350DAO");
	        try {
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	           
	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
	 
	 	        
//	        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
//	                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
//	                     ,new ColumnAttribute("payrMangDeptCd", "payrMangDeptCd", ColumnDef.TYPE_STRING)
//	                      ,new ColumnAttribute("payMangeDeptNm", "payMangeDeptNm", ColumnDef.TYPE_STRING) };
	        	
	        	 
	            //Get paging configuration
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	            //Get query parameters
	           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	          
	            /** 조건절 */
	            sysComSrhVo.setDpobCd(sessionUser.getDpobCd()); 
	            sysComSrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());
	            sysComSrhVo.setUsrId(sessionUser.getUsrId()); 
	            
	            sysComSrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
                sysComSrhVo.setDtilOccuInttnCdAuth("");
              
                sysComSrhVo.setPayrMangDeptCd(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"),sessionUser.getTplvlDeptCd()));    
                
	            /******************************** 권한 ************************************************************************/
                String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
                if ("FALSE".equals(chkDeptCd)) {
            	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {

                    	   sysComSrhVo.setDeptCd(sessionUser.getDeptCd()); 
                        listDeptCd.add( sessionUser.getDeptCd() );
                        sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드    
                        
                	   } else {
                		   sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                           listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                           sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                		 
                	  }  
            	    
                   sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
                } else { 
                 
                        if (sysComSrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                            listDeptCd = null; 
                         	sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                         	sysComSrhVo.setDeptCd("");  //부서코드
                         } else {
                        	  sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                              listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                              sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                         } 
                      
                }  
              
	            
	            List<String> lstTypeOccuCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            sysComSrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	            sysComSrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
	             
	        	//  sysComSrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
	            sysComSrhVo.setDtilOccuClsUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsUseYn")));
	             
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		     if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt =  bass0350DAO.selectBass0350ListTotCnt(sysComSrhVo);  
	              
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	           }
	        
	            TimingInfo millisBeginSelectBass0350List = SmrmfUtils.startTiming(logger);
	         

	            /**페이지 카운트 처리를 위한 부분 */ 
	            sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	sysComSrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.totalRecordCount < 100) {
	            	sysComSrhVo.setLastIndex(pagingValues.totalRecordCount); 
	            } else if (pagingValues.offsetLimit > 0) {
	            	sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = bass0350DAO.selectBass0350List(sysComSrhVo);
	            
		        Iterator<Map<String, Object>> iter = list.iterator();
		            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("dpobCd").toString()+map.get("dtilOccuClsDivCd").toString();
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
	            
                SmrmfUtils.endTiming(logger, millisBeginSelectBass0350List, "getPrgmComLookBass0350List");
	       
 
	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }
		

	 
    /**
	 * BASS0350 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BASS0350 총 갯수
	 * @exception
	 */
    public int selectBass0350ListTotCnt(PrgmComSearchVO searchVO) {
		return bass0350DAO.selectBass0350ListTotCnt(searchVO);
	}

    /**
     * <pre>
     * 1. 개요 :  직종세 콤보값을 가지고 온다.
     * 2. 처리내용 : 직종에 따른 직종세 콤보처리 루틴 (콤보) 
     * </pre>
     * @Method Name : getPrgmComComboPayrBass0350List
     * @date : Nov 13, 2015
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Nov 13, 2015		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see com.app.exterms.prgm.client.service.PrgmComBass0350Service#getPrgmComComboPayrBass0350List(com.app.exterms.prgm.client.dto.PrgmComBass0350DTO)
     * @param sysComBass0350Dto
     * @return
     */ 	
    @Override
    public List<BaseModel> getPrgmComComboPayrBass0350List(PrgmComBass0350DTO sysComBass0350Dto) {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getPrgmComComboBass0350List";
        PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
        PrgmComBass0350VO sysComBass0350Vo = new PrgmComBass0350VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        List<String> listDeptCd = new ArrayList<String>();
//        if  (MSFSharedUtils.paramNull(bass0350DAO)) {
//            
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            bass0350DAO = (PrgmComBass0350DAO) wac.getBean("PrgmComBass0350DAO" ); 
//        }
        bass0350DAO = (PrgmComBass0350DAO)BeanFinder.getBean("PrgmComBass0350DAO");
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
           
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
  
            ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                     ,new ColumnAttribute("typOccuCd", "typOccuCd", ColumnDef.TYPE_STRING ) 
                      ,new ColumnAttribute("dtilOccuInttnCd", "dtilOccuInttnCd", ColumnDef.TYPE_STRING )   //직종세 통합코드 
                     ,new ColumnAttribute("dtilOccuClsDivCd", "dtilOccuClsDivCd", ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("pyspGrdeCd", "pyspGrdeCd", ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("dtilOccuClsNm", "dtilOccuClsNm", ColumnDef.TYPE_STRING)};
             
            /** 조건절 */
            sysComSrhVo.setDpobCd(sessionUser.getDpobCd()); 
            sysComSrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());
            sysComSrhVo.setUsrId(sessionUser.getUsrId());
            sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            sysComSrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
            sysComSrhVo.setDtilOccuInttnCdAuth("");
            
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	
        	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(sysComBass0350Dto.getDeptCd(),sessionUser.getDeptCd()))) {
       			 
                	   sysComSrhVo.setDeptCd(sessionUser.getDeptCd()); 
                    listDeptCd.add( sessionUser.getDeptCd()  );
                    sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드    
                    
            	   } else {
            		 
            		   sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()));
                       listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()));  
                       sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드   
            	  }  
        	    
               
            } else {  
            	 sysComSrhVo.setPayrMangDeptCd(MSFSharedUtils.defaultNulls(sysComBass0350Dto.getPayrMangDeptCd(),sessionUser.getTplvlDeptCd()));   
                 if (sysComSrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()))) { 
                 	 listDeptCd = null; 
                 	sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                 	sysComSrhVo.setDeptCd("");  //부서코드
                 } else {
                	
                	  sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()));
                      listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()));  
                      sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                 } 
                  
            } 
            
        
            
            List<String> lstTypeOccuCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(sysComBass0350Dto.getTypOccuCd())); 
            sysComSrhVo.setTypOccuCdArr(lstTypeOccuCd); 
            sysComSrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(sysComBass0350Dto.getTypOccuCd()));
           
           // List<String> lstPyspGrdeCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(sysComBass0350Dto.getPyspGrdeCd())); 
           // sysComSrhVo.setPyspGrdeCdArr(lstPyspGrdeCd); 
           // sysComSrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(sysComBass0350Dto.getPyspGrdeCd()) );
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
            //    if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  bass0350DAO.selectPayrBass0350ListTotCnt(sysComSrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
         //       pagingValues.totalRecordCount = iResultCnt;          
                
         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         //  }
        
            TimingInfo millisBeginSelectBass0350List = SmrmfUtils.startTiming(logger);
         

            /**페이지 카운트 처리를 위한 부분 */ 
          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
           //   sysComSrhVo.setFirstIndex(pagingValues.start);
           // }
           // if (pagingValues.offsetLimit > 0) {
           //    sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            sysComSrhVo.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = bass0350DAO.selectPayrBass0350List(sysComSrhVo);
            
            Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("dtilOccuInttnCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0350List, "selectBass0350List");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return bmResult;
    }
     
    
    /**
     * <pre>
     * 1. 개요 : 직종  콤보 형태를 공통 rpc 로직을 호출 하여 처리 할 경우 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getPrgmComLookBass0320List
     * @date : Nov 13, 2015
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Nov 13, 2015		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param serviceParameters
     * @return PagingLoadResult<BaseModel>
     * @throws MSFException
     */ 	
    public PagingLoadResult<BaseModel> getPrgmComLookBass0320List(ServiceParameters serviceParameters) throws MSFException {

            PagingLoadResult<BaseModel> retval = null;
            String method = "getPrgmComLookBass0320List";
            PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
            PrgmComBass0320VO sysComBass0320VO = new PrgmComBass0320VO();
            List<BaseModel> bmResult = new ArrayList<BaseModel>();
            MSFServerExtAuth msfServerExtAuth = MSFServerExtAuth.getInstance();
            List<String> listDeptCd = new ArrayList<String>();
//            if  (MSFSharedUtils.paramNull(bass0320DAO)) {
//                
//                WebApplicationContext wac = WebApplicationContextUtils.
//                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//                bass0320DAO = (PrgmComBass0320DAO) wac.getBean("PrgmComBass0320DAO" ); 
//            }
            
            bass0320DAO = (PrgmComBass0320DAO)BeanFinder.getBean("PrgmComBass0320DAO");
            
            try {
                //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
                MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
               
                ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
                IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
                List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
                PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
     
                 
                //Get paging configuration
                PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

                //Get query parameters
               // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
               
                /** 조건절 */
                sysComSrhVo.setDpobCd(sessionUser.getDpobCd()); 
                sysComSrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());
                sysComSrhVo.setUsrId(sessionUser.getUsrId());
                
                sysComSrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
                sysComSrhVo.setDtilOccuInttnCdAuth("");
                /******************************** 권한 ************************************************************************/
                String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
                if ("FALSE".equals(chkDeptCd)) {
            	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
           			 

                    	   sysComSrhVo.setDeptCd(sessionUser.getDeptCd()); 
                        listDeptCd.add(sessionUser.getDeptCd());
                        sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드  
                        
                	   } else {
                		 
                		   sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                           listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                           sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                	  }  
            	      
                   sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
                } else {
                	    
                         sysComSrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));    
                         if (sysComSrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                         	 listDeptCd = null; 
                         	sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                         	sysComSrhVo.setDeptCd("");  //부서코드
                         } else {
                        	  sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                              listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                              sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                         } 
                      
                }
               
//                String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//                if ("FALSE".equals(chkTypOccuCd)) {
//                	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//                	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//                } else {
//                	
//                }
                
               /******************************** 권한 ************************************************************************/
                sysComSrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
                
                //사용여부 추가 20170914
                sysComSrhVo.setTypOccuUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuUseYn"))); 
               
                
              //  sysComSrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
                //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                        
                    //Execute query that returns a single value
                    TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                     
                    int iResultCnt =  bass0320DAO.selectBass0320ComboTypOccuCdListTotCnt(sysComSrhVo);  
                  
                    SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                    pagingValues.totalRecordCount = iResultCnt;        
                    
                    logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
               }
            
                TimingInfo millisBeginSelectBass0320List = SmrmfUtils.startTiming(logger);
             

                /**페이지 카운트 처리를 위한 부분 */ 
                sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
                
                //Apply paging
                if (pagingValues.start > 0) {
                    sysComSrhVo.setFirstIndex(pagingValues.start);
                }
                if (pagingValues.totalRecordCount < 100) {
                    sysComSrhVo.setLastIndex(pagingValues.totalRecordCount); 
                } else if (pagingValues.offsetLimit > 0) {
                    sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
                }

                //Execute query and convert to BaseModel list
                TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
                
                @SuppressWarnings("unchecked")
//              Collection<Map<String, Object>> list ??????
                List list = bass0320DAO.selectBass0320ComboTypOccuCdList(sysComSrhVo);
                
                Iterator<Map<String, Object>> iter = list.iterator();
                    
                SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
               
                while ( iter.hasNext() ) {
                    Map<String, Object> map = (Map<String, Object>) iter.next();
                    String idValue = map.get("typOccuCd").toString();
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
                
                SmrmfUtils.endTiming(logger, millisBeginSelectBass0320List, "getPrgmComLookBass0320List");
           
 
            }
            catch (Exception ex) {
                ex.printStackTrace();
                //Return operation exception
                throw MSFServerUtils.getOperationException(method, ex, logger);
            }

            return retval;
        }
    
    /**
     * <pre>
     * 1. 개요 : 일반 콤보형태 처리 직종  현재사용유무확인 필요 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getPrgmComComboTypOccuCdList
     * @date : Nov 16, 2015
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Nov 16, 2015		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see com.app.exterms.prgm.client.service.PrgmComBass0350Service#getPrgmComComboTypOccuCdList(com.app.exterms.prgm.client.dto.PrgmComBass0350DTO)
     * @param sysComBass0350Dto
     * @return
     * @throws MSFException
     */ 	
    public List<BaseModel> getPrgmComComboTypOccuCdList(PrgmComBass0320DTO sysComBass0320Dto) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getPrgmComComboTypOccuCdList";
        PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
        PrgmComBass0320VO sysComBass0320Vo = new PrgmComBass0320VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        MSFServerExtAuth msfServerExtAuth = MSFServerExtAuth.getInstance();
        List<String> listDeptCd = new ArrayList<String>();
        
//        if  (MSFSharedUtils.paramNull(bass0320DAO)) {
//            
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            bass0320DAO = (PrgmComBass0320DAO) wac.getBean("PrgmComBass0320DAO" ); 
//        }
        bass0320DAO = (PrgmComBass0320DAO)BeanFinder.getBean("PrgmComBass0320DAO");
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
           
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
  
            ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                     ,new ColumnAttribute("typOccuCd", "typOccuCd", ColumnDef.TYPE_STRING ) 
                     ,new ColumnAttribute("typOccuNm", "typOccuNm", ColumnDef.TYPE_STRING) 
                  };
            
         // ,new ColumnAttribute("pyspGrdeCd", "pyspGrdeCd", ColumnDef.TYPE_STRING)
            /** 조건절 */
            /****************************************************************************/
            sysComSrhVo.setDpobCd(sessionUser.getDpobCd()); 
            sysComSrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());
            sysComSrhVo.setUsrId(sessionUser.getUsrId());
            sysComSrhVo.setUsrDivCd(sessionUser.getUsrDivCd());
            /****************************************************************************/
            sysComSrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(sysComBass0320Dto.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
            sysComSrhVo.setDtilOccuInttnCdAuth("");
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	
        	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(sysComBass0320Dto.getDeptCd(),sessionUser.getDeptCd()))) {
       			 
        	    	sysComSrhVo.setDeptCd(sessionUser.getDeptCd()); 
                    listDeptCd.add(sessionUser.getDeptCd());
                    sysComSrhVo.setDeptCdArr(listDeptCd);  //부서코드   
            	   } else {
            		 
            		   sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(sysComBass0320Dto.getDeptCd()));
                       listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(sysComBass0320Dto.getDeptCd()));  
                       sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드   
            	  }  
           	    
               sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	     sysComSrhVo.setPayrMangDeptCd(MSFSharedUtils.defaultNulls(sysComBass0320Dto.getPayrMangDeptCd(),sessionUser.getTplvlDeptCd()));  
                     if (sysComSrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(sysComBass0320Dto.getDeptCd()))) { 
                     	 listDeptCd = null; 
                     	 sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                     	 sysComSrhVo.setDeptCd("");  //부서코드
                     } else {
                    	  sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(sysComBass0320Dto.getDeptCd()));
                          listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(sysComBass0320Dto.getDeptCd()));  
                          sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            } 
            
            sysComSrhVo.setTypOccuCd(sysComBass0320Dto.getTypOccuCd());
           // sysComSrhVo.setPyspGrdeCd( sysComBass0350Dto.getPyspGrdeCd());
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
            //    if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
           //     int iResultCnt =  bass0320DAO.selectBass0320TypOccuCdListTotCnt(sysComSrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
         //       pagingValues.totalRecordCount = iResultCnt;          
                
         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         //  }
        
            TimingInfo millisBeginSelectBass0320List = SmrmfUtils.startTiming(logger);
        
             

            /**페이지 카운트 처리를 위한 부분 */ 
          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
           //   sysComSrhVo.setFirstIndex(pagingValues.start);
           // }
           // if (pagingValues.offsetLimit > 0) {
           //    sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            sysComSrhVo.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = bass0320DAO.selectBass0320TypOccuCdList(sysComSrhVo);
            
            Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("typOccuCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0320List, "selectBass0350List");
            
        
        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return bmResult;
    }
    
    /**
     * <pre>
     * 1. 개요 : 일반 콤보형태 처리 직종  전체가져오기
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getPrgmNonTypOccuCdList
     * @date : Nov 16, 2015
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Nov 16, 2015		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @see com.app.exterms.prgm.client.service.PrgmComBass0350Service#getPrgmNonTypOccuCdList(com.app.exterms.prgm.client.dto.PrgmComBass0350DTO)
     * @param sysComBass0350Dto
     * @return
     * @throws MSFException
     */ 
    public List<BaseModel> getPrgmNonTypOccuCdList(PrgmComBass0320DTO sysComBass0320Dto) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getPrgmNonTypOccuCdList";
        PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
        PrgmComBass0320VO sysComBass0320Vo = new PrgmComBass0320VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        MSFServerExtAuth msfServerExtAuth = MSFServerExtAuth.getInstance();
        List<String> listDeptCd = new ArrayList<String>();
        
//        if  (MSFSharedUtils.paramNull(bass0320DAO)) {
//            
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            bass0320DAO = (PrgmComBass0320DAO) wac.getBean("PrgmComBass0320DAO" ); 
//        }
        bass0320DAO = (PrgmComBass0320DAO)BeanFinder.getBean("PrgmComBass0320DAO");
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
           
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
  
            ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                     ,new ColumnAttribute("typOccuCd", "typOccuCd", ColumnDef.TYPE_STRING ) 
                     ,new ColumnAttribute("typOccuNm", "typOccuNm", ColumnDef.TYPE_STRING) 
                  };
            
         // ,new ColumnAttribute("pyspGrdeCd", "pyspGrdeCd", ColumnDef.TYPE_STRING)
            /** 조건절 */
          
            sysComSrhVo.setDpobCd(sessionUser.getDpobCd()); 
            
            sysComSrhVo.setTypOccuCd(sysComBass0320Dto.getTypOccuCd());
            sysComSrhVo.setTypOccuUseYn(sysComBass0320Dto.getTypOccuUseYn());
           // sysComSrhVo.setPyspGrdeCd( sysComBass0350Dto.getPyspGrdeCd());
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
            //    if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
           //     int iResultCnt =  bass0320DAO.selectBass0320TypOccuCdListTotCnt(sysComSrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
         //       pagingValues.totalRecordCount = iResultCnt;          
                
         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         //  }
        
            TimingInfo millisBeginSelectBass0320List = SmrmfUtils.startTiming(logger);
        
             

            /**페이지 카운트 처리를 위한 부분 */ 
          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
           //   sysComSrhVo.setFirstIndex(pagingValues.start);
           // }
           // if (pagingValues.offsetLimit > 0) {
           //    sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            sysComSrhVo.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = bass0320DAO.selectNonBass0320TypOccuCdList(sysComSrhVo);
            
            Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("typOccuCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0320List, "selectBass0350List");
            
        
        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return bmResult;
    }
    
       
    
	/**
     * TODO 사용안함. 최종 확인후 삭제  팝업 rpc service
     * @param serviceParameters
     * @return
     * @throws MSFException
     */  
    public PagingLoadResult<BaseModel> getPrgmComPopupBass0350List(ServiceParameters serviceParameters) throws MSFException {

            PagingLoadResult<BaseModel> retval = null;
            String method = "getPrgmComPopupBass0350List";
            PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
            PrgmComBass0350VO sysComBass0350VO = new PrgmComBass0350VO();
            List<BaseModel> bmResult = new ArrayList<BaseModel>();
            
//            if  (MSFSharedUtils.paramNull(bass0350DAO)) {
//                
//                WebApplicationContext wac = WebApplicationContextUtils.
//                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//                bass0350DAO = (PrgmComBass0350DAO) wac.getBean("PrgmComBass0350DAO" ); 
//            }
            bass0320DAO = (PrgmComBass0320DAO)BeanFinder.getBean("PrgmComBass0320DAO");
            try {
                //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
                MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
               
                ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
                IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
                List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
                PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
      
                 
                //Get paging configuration
                PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
                /** 조건절 */
                sysComSrhVo.setDpobCd(sessionUser.getDpobCd()); 
                sysComSrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
                sysComSrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
               
                sysComSrhVo.setDtilOccuClsNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsNm")));

                
                //Get total record count //전체 데이터 갯수를 가지고 온다. 
               if ( pagingValues.executeRecordCount ) { 
                        
                    //Execute query that returns a single value
                    TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                     
                    int iResultCnt =  bass0350DAO.selectBass0350PopupListTotCnt(sysComSrhVo);  
                  
                    SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                    pagingValues.totalRecordCount = iResultCnt;        
                    
                    logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
                }
            
                TimingInfo millisBeginSelectBass0350List = SmrmfUtils.startTiming(logger);
             

                /**페이지 카운트 처리를 위한 부분 */ 
                sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
                
                //Apply paging
                if (pagingValues.start > 0) {
                    sysComSrhVo.setFirstIndex(pagingValues.start);
                }
                if (pagingValues.totalRecordCount < 100) {
                    sysComSrhVo.setLastIndex(pagingValues.totalRecordCount); 
                } else if (pagingValues.offsetLimit > 0) {
                    sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
                }

                //Execute query and convert to BaseModel list
                TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
                
                @SuppressWarnings("unchecked")
//              Collection<Map<String, Object>> list ??????
                List list = bass0350DAO.selectBass0350PopupList(sysComSrhVo);
                
                Iterator<Map<String, Object>> iter = list.iterator();
                    
                SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
               
                while ( iter.hasNext() ) {
                    Map<String, Object> map = (Map<String, Object>) iter.next();
                    String idValue = map.get("dpobCd").toString();
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
                
                SmrmfUtils.endTiming(logger, millisBeginSelectBass0350List, "selectBass0350List");
           
 
            }
            catch (Exception ex) {
                ex.printStackTrace();
                //Return operation exception
                throw MSFServerUtils.getOperationException(method, ex, logger);
            }

            return retval;
        }
        
    
}
