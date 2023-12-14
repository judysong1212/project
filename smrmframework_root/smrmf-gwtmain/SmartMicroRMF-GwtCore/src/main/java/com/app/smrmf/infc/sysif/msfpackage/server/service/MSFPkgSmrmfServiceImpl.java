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
package com.app.smrmf.infc.sysif.msfpackage.server.service;

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
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0320DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0350DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.service.MSFPkgSmrmfService;
import com.app.smrmf.infc.sysif.msfpackage.server.service.dao.SysIfSsoSmrmfDAO;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;
import com.app.smrmf.sysm.server.service.dao.SysIfPkgSmrmfDAO;
import com.app.smrmf.sysm.server.service.vo.SysComSearchVO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0320VO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;
import com.app.smrmf.sysm.server.service.vo.SysIfPsnl0100VO;
import com.app.smrmf.sysm.server.vo.system.SsoxUserSrhVO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.app.smrmf.infc.sysif.msfpackage.server.service.dao.SysIfSsomUserDAO;


/**
 * <pre>
 * com.app.smrmf.sysauth.system.server.service 
 *    |_ MSFPkgSmrmfServiceImpl.java
 * 
 * </pre>
 * @date : Nov 11, 2015 1:22:12 PM
 * @version : 
 * @author : leeheuisung
 */
@Service("MSFPkgSmrmfService") 
public   class MSFPkgSmrmfServiceImpl  extends AbstractCustomServiceImpl implements  MSFPkgDaoConstants ,MSFPkgSmrmfService  {

	private static Logger logger = LoggerFactory.getLogger(MSFPkgSmrmfServiceImpl.class);
	private static final String calledClass = MSFPkgSmrmfServiceImpl.class.getName();
	
	@Autowired 
	@Resource(name="SysIfPkgSmrmfDAO")
	private SysIfPkgSmrmfDAO msfPkgSmrmfDAO;
	
	
	@Autowired 
	@Resource(name="SysIfSsoSmrmfDAO")
	private SysIfSsoSmrmfDAO msfPkgSsoSmrmfDAO;
	
	@Autowired 
	@Resource(name="SysIfSsomUserDAO")
	private SysIfSsomUserDAO sysIfSsomUserDAO;
 
    /**
     * <pre>
     * 1. 개요 : 
     * 2. 처리내용 : 팝업형태 공통 rpc 로직을 호출 하여 처리 할 경우 
     * </pre>
     * @Method Name : getMSFPkgComboBass0300List
     * @date : Nov 11, 2015
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Nov 11, 2015		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param serviceParameters
     * @return
     * @throws MSFException
     */ 	
    public PagingLoadResult<BaseModel> getMSFPkgComboBass0300List(ServiceParameters serviceParameters) throws MSFException {

            PagingLoadResult<BaseModel> retval = null;
            String method =  MSFPKG_METHOD_COMBO_BASS0300_List;
            SysComSearchVO   msfPkgSrhVo = new SysComSearchVO();
           
            List<BaseModel>  bmResult = new ArrayList<BaseModel>();
            
            MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
            
            if  (MSFSharedUtils.paramNull(msfPkgSmrmfDAO)) {
            
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
            }
            
            try {
                //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
               // Sysm0100BM          user             = serviceParameters.getUser();
                ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
                IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
                List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
                PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
                //Get paging configuration
                PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

                //Get query parameters
               // String strCriteriaValue = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
               
                /** 조건절 */
                msfPkgSrhVo.setDpobCd(sessionUser.getDpobCd());  
                msfPkgSrhVo.setRpsttvCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd")));  
                msfPkgSrhVo.setCommCdNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "commCdNm")));  
                msfPkgSrhVo.setMangeItem01(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem01"))); 
                msfPkgSrhVo.setMangeItem02(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem02"))); 
                msfPkgSrhVo.setMangeItem03(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem03"))); 
                msfPkgSrhVo.setMangeItem04(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem04"))); 
                msfPkgSrhVo.setMangeItem05(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem05"))); 
                msfPkgSrhVo.setMangeItem06(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem06"))); 
                msfPkgSrhVo.setMangeItem07(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem07"))); 
                msfPkgSrhVo.setMangeItem08(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem08"))); 
                msfPkgSrhVo.setMangeItem09(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem09"))); 
                msfPkgSrhVo.setMangeItem10(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem10"))); 
                msfPkgSrhVo.setMangeItem11(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem11"))); 
                msfPkgSrhVo.setMangeItem12(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem12"))); 
                msfPkgSrhVo.setMangeItem13(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem13"))); 
                msfPkgSrhVo.setMangeItem14(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem14"))); 
                msfPkgSrhVo.setMangeItem15(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem15"))); 
                msfPkgSrhVo.setMangeItem16(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem16"))); 
                msfPkgSrhVo.setMangeItem17(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem17"))); 
                msfPkgSrhVo.setMangeItem18(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem18"))); 
                msfPkgSrhVo.setMangeItem19(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem19"))); 
                msfPkgSrhVo.setMangeItem10(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeItem20"))); 
                  
                if ("combo".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "chkCombo")))) {
                    msfPkgSrhVo.setLastIndex(-1);
                } else {
                    
                      //Get total record count //전체 데이터 갯수를 가지고 온다. 
                    if ( pagingValues.executeRecordCount ) { 
                        
                        //Execute query that returns a single value
                        TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                         
                        int iResultCnt = msfPkgSmrmfDAO.selectBass0300ListTotCnt(msfPkgSrhVo);  
                      
                        SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                        pagingValues.totalRecordCount = iResultCnt;        
                        
                        logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
                    }
                
                    /**페이지 카운트 처리를 위한 부분 */ 
                    msfPkgSrhVo.setPageSize(pagingValues.totalRecordCount);  
                    
                    //Apply paging
                    if (pagingValues.start > 0) {
                        msfPkgSrhVo.setFirstIndex(pagingValues.start);
                    }
                    if (pagingValues.totalRecordCount < 100) {
                         msfPkgSrhVo.setLastIndex(pagingValues.totalRecordCount); 
                    } else if (pagingValues.offsetLimit > 0) {
                         msfPkgSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
                    }
                }

                TimingInfo millisBeginMSFCoreComboBass0300List = SmrmfUtils.startTiming(logger);
            
                //Execute query and convert to BaseModel list
                TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
                
                @SuppressWarnings("unchecked")
//              Collection<Map<String, Object>> list ??????
                List list = msfPkgSmrmfDAO.selectBass0300List(msfPkgSrhVo);
                
                Iterator<Map<String, Object>> iter = list.iterator();
                
                SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
               
                while ( iter.hasNext() ) {
                    Map<String, Object> map = (Map<String, Object>) iter.next();
                    String idValue = map.get("commCd").toString();
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
                
                SmrmfUtils.endTiming(logger, millisBeginMSFCoreComboBass0300List, "getmillisBeginMSFCoreComboBass0300List");
           
 
            } catch (Exception ex) {
                ex.printStackTrace();
                //Return operation exception
                throw MSFServerUtils.getOperationException(method, ex, logger);
            }

            return retval;
        }
    
    
    /**
     *  직종+호봉등급 콤보 형태를 공통 rpc 로직을 호출 하여 처리 할 경우 
     * @param serviceParameters
     * @return
     * @throws MSFException
     */ 
    
    public PagingLoadResult<BaseModel> getSysIfLookBass0350TypOccuCdList(ServiceParameters serviceParameters) throws MSFException {

            PagingLoadResult<BaseModel> retval = null;
            String method = MSFPKG_METHOD_COMBO_BASS0350TypOccuCd_List;
            SysComSearchVO  msfPkgSrhVo = new SysComSearchVO();
           
            List<BaseModel> bmResult = new ArrayList<BaseModel>();
            
            if  (MSFSharedUtils.paramNull(msfPkgSmrmfDAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
            }
            
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
                msfPkgSrhVo.setDpobCd(sessionUser.getDpobCd()); 
                msfPkgSrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
                msfPkgSrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
                //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                        
                    //Execute query that returns a single value
                    TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                     
                    int iResultCnt =  msfPkgSmrmfDAO.selectBass0350ComboTypOccuCdListTotCnt(msfPkgSrhVo);  
                  
                    SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                    pagingValues.totalRecordCount = iResultCnt;        
                    
                    logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
               }
            
                TimingInfo millisBeginSysIfLookBass0350TypOccuCdList = SmrmfUtils.startTiming(logger);
             

                /**페이지 카운트 처리를 위한 부분 */ 
                msfPkgSrhVo.setPageSize(pagingValues.totalRecordCount);  
                
                //Apply paging
                if (pagingValues.start > 0) {
                    msfPkgSrhVo.setFirstIndex(pagingValues.start);
                }
                if (pagingValues.totalRecordCount < 100) {
                    msfPkgSrhVo.setLastIndex(pagingValues.totalRecordCount); 
                } else if (pagingValues.offsetLimit > 0) {
                    msfPkgSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
                }

                //Execute query and convert to BaseModel list
                TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
                
                @SuppressWarnings("unchecked")
//              Collection<Map<String, Object>> list ??????
                List list = msfPkgSmrmfDAO.selectBass0350ComboTypOccuCdList(msfPkgSrhVo);
                
                Iterator<Map<String, Object>> iter = list.iterator();
                    
                SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
               
                while ( iter.hasNext() ) {
                    Map<String, Object> map = (Map<String, Object>) iter.next();
                    String idValue = map.get("typOccuCd").toString()+map.get("pyspGrdeCd").toString();
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
                
                SmrmfUtils.endTiming(logger, millisBeginSysIfLookBass0350TypOccuCdList, "getSysIfLookBass0350TypOccuCdList");
           
            }catch (Exception ex) {
                ex.printStackTrace();
                //Return operation exception
                throw MSFServerUtils.getOperationException(method, ex, logger);
            }

            return retval;
        }
    
    
    public PagingLoadResult<BaseModel> getSysIfLookupWithBass0400List(ServiceParameters serviceParameters) {
        PagingLoadResult<BaseModel> retval = null;
        String method =  MSFPKG_METHOD_LOOKUP_BASS0400_List;
        SysComSearchVO   msfPkgSrhVo = new SysComSearchVO();
       
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        List<String> listDeptCd = new ArrayList<String>();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(msfPkgSmrmfDAO)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
        }
        
        try {
          
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
   
          ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                  new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                 ,new ColumnAttribute("deptCd", "deptCd", ColumnDef.TYPE_STRING)
                 ,new ColumnAttribute("deptNmHan", "deptNmHan", ColumnDef.TYPE_STRING)
                 ,new ColumnAttribute("deptNmRtchnt", "deptNmRtchnt", ColumnDef.TYPE_STRING)
                  };
          
            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
            msfPkgSrhVo.setDpobCd(sessionUser.getDpobCd()); 
            msfPkgSrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());
            msfPkgSrhVo.setUsrId(sessionUser.getUsrId());
            msfPkgSrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));    
            msfPkgSrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")));
            msfPkgSrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            msfPkgSrhVo.setDtilOccuInttnCdAuth("");
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
             
            if ("FALSE".equals(chkDeptCd)) { 
            	msfPkgSrhVo.setDeptCd(sessionUser.getDeptCd()); 
                listDeptCd.add(sessionUser.getDeptCd());
                msfPkgSrhVo.setDeptCdArr(listDeptCd);     //부서코드    
                msfPkgSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
             } else if ("Y".equals(sessionUser.getYrtxInptPrcsYn())) {
             // 연말정산 처리를 위해 추가됨.
            	 msfPkgSrhVo.setDeptCd(sessionUser.getDeptCd()); 
                  listDeptCd.add(sessionUser.getDeptCd());
                  msfPkgSrhVo.setDeptCdArr(listDeptCd);     //부서코드    
                  msfPkgSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
             } else {
            	
                  if (msfPkgSrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                  	 listDeptCd = null; 
                  	msfPkgSrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                  	msfPkgSrhVo.setDeptCd("");  //부서코드
                  } else {
                	  msfPkgSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                       listDeptCd = MSFSharedUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                       msfPkgSrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                  } 
                   
             }
            
          /** 조건절 */ 
         // msfPkgSrhVo.setDpobCd(sessionUser.getDpobCd());
         // msfPkgSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
          msfPkgSrhVo.setEmymtDivCd("");
        //  msfPkgSrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))); 
         
       //   msfPkgSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd"))); 
          msfPkgSrhVo.setDeptNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptNm")));       //부서명
          msfPkgSrhVo.setDeptDspyYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptDspyYn"))); //display
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
           // if ( pagingValues.executeRecordCount ) { 
                      
                //Execute query that returns a single value
           //     TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
           //     int iResultCnt =  msfPkgSmrmfDAO.selectPayrWithBass0400ListTotCnt(msfPkgSrhVo);  
              
            //    SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
            //    pagingValues.totalRecordCount = iResultCnt;        
                
            //    logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
           // }
        
            TimingInfo millisBeginSelectPayrWithBass0400List = SmrmfUtils.startTiming(logger);
         
            /**페이지 카운트 처리를 위한 부분 */ 
          //  msfPkgSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
                msfPkgSrhVo.setFirstIndex(-1);   //pagingValues.start
           // }
           // if (pagingValues.offsetLimit > 0) {
           //      msfPkgSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            msfPkgSrhVo.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked") 
            List list = msfPkgSmrmfDAO.selectBass0400ComboList(msfPkgSrhVo);
            
            Iterator<Map<String, Object>> iter = list.iterator();
                  
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("deptCd").toString();
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

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayrWithBass0400List, "getPayrWithBass0400List");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
    
   
    /**
 	 * 부서를 일반 콤보형태 처리 
 	 * @param  
 	 * @return
 	 * @throws MSFException
 	 */
 	 
 	public List<BaseModel> getSysIfWithNoLoginBass0400List() throws MSFException {

      //   PagingLoadResult<BaseModel> retval = null; 
         SysComSearchVO  msfPkgSrhVo = new SysComSearchVO(); 
        
         List<BaseModel> bmResult = new ArrayList<BaseModel>();
         
         if  (MSFSharedUtils.paramNull(msfPkgSmrmfDAO)) {
             
             WebApplicationContext wac = WebApplicationContextUtils.
                     getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

             msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
         }
         
         try {
             //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
         	//MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(getThreadLocalRequest());
            
            // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
   
  	        
         	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                       new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                      ,new ColumnAttribute("deptCd", "deptCd", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("deptNmHan", "deptNmHan", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("deptNmRtchnt", "deptNmRtchnt", ColumnDef.TYPE_STRING)
                       };
         	
             //Get paging configuration
            // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

             //Get query parameters
            // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
            
             /** 조건절 */
          	 msfPkgSrhVo.setDpobCd("");
             msfPkgSrhVo.setDeptCd(""); 
             msfPkgSrhVo.setMangeDeptCd(""); 
             msfPkgSrhVo.setDeptDspyYn("Y");
             //Get total record count //전체 데이터 갯수를 가지고 온다. 
 	        //    if ( pagingValues.executeRecordCount ) { 
 	            	
                 //Execute query that returns a single value
                 TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                  
               //  int iResultCnt = selectBass0400ListTotCnt(msfPkgSrhVo); 
               
                 SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
          //       pagingValues.totalRecordCount = iResultCnt;	       
                 
          //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
          //  }
         
             TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
         
         	 

             /**페이지 카운트 처리를 위한 부분 */ 
         
             msfPkgSrhVo.setLastIndex(-1); 
           
             TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
             
             @SuppressWarnings("unchecked")
 
             List list = msfPkgSmrmfDAO.selectBass0400ComboList(msfPkgSrhVo);
             
 	        Iterator<Map<String, Object>> iter = list.iterator();
 	            
             SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
            
             while ( iter.hasNext() ) {
                 Map<String, Object> map = (Map<String, Object>) iter.next();
                 String idValue = map.get("deptCd").toString();
                 BaseModel bm = new BaseModel();

                // bm.setProperties(map);
                 for ( int i=0 ; i<columnAttributes.length ; i++ ) {
                     Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                             map.get(columnAttributes[i].getName()), columnAttributes[i].getType());
                     bm.set(columnAttributes[i].getName(), baseModelValue);
                 }

                 bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                 bmResult.add(bm);
             } 
 
             SmrmfUtils.endTiming(logger, millisBeginSelectBass0400List, "selectBass0400List"); 
        

         }
         catch (Exception ex) {
             //Return operation exception
             throw MSFServerUtils.getOperationException("getSysIfWithBass0400List", ex, logger);
         }

         return bmResult;
     }
 	
    
 	/**
 	 * 부서를 일반 콤보형태 처리 
 	 * @param  
 	 * @return
 	 * @throws MSFException
 	 */
 	 
 	public List<BaseModel> getSysIfWithBass0400List() throws MSFException {

      //   PagingLoadResult<BaseModel> retval = null; 
         SysComSearchVO  msfPkgSrhVo = new SysComSearchVO(); 
        
         List<BaseModel> bmResult = new ArrayList<BaseModel>();
         
         if  (MSFSharedUtils.paramNull(msfPkgSmrmfDAO)) {
             
             WebApplicationContext wac = WebApplicationContextUtils.
                     getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

             msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
         }
         
         try {
             //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
         	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
            
            // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
   
  	        
         	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                       new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                      ,new ColumnAttribute("deptCd", "deptCd", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("deptNmHan", "deptNmHan", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("deptNmRtchnt", "deptNmRtchnt", ColumnDef.TYPE_STRING)
                       };
         	
             //Get paging configuration
            // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

             //Get query parameters
            // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
            
             /** 조건절 */
         	msfPkgSrhVo.setDpobCd(sessionUser.getDpobCd());
             msfPkgSrhVo.setDeptCd(""); 
             msfPkgSrhVo.setMangeDeptCd(""); 
             msfPkgSrhVo.setDeptDspyYn("");
             //Get total record count //전체 데이터 갯수를 가지고 온다. 
 	        //    if ( pagingValues.executeRecordCount ) { 
 	            	
                 //Execute query that returns a single value
                 TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                  
               //  int iResultCnt = selectBass0400ListTotCnt(msfPkgSrhVo); 
               
                 SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
          //       pagingValues.totalRecordCount = iResultCnt;	       
                 
          //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
          //  }
         
             TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
         
         	 

             /**페이지 카운트 처리를 위한 부분 */ 
           //  msfPkgSrhVo.setPageSize(pagingValues.totalRecordCount);  
             
             //Apply paging
            // if (pagingValues.start > 0) {
            // 	msfPkgSrhVo.setFirstIndex(pagingValues.start);
            // }
            // if (pagingValues.offsetLimit > 0) {
            // 	 msfPkgSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            // }
             msfPkgSrhVo.setLastIndex(-1); 
             //Execute query and convert to BaseModel list
             TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
             
             @SuppressWarnings("unchecked")
//             Collection<Map<String, Object>> list ??????
             List list = msfPkgSmrmfDAO.selectBass0400ComboList(msfPkgSrhVo);
             
 	        Iterator<Map<String, Object>> iter = list.iterator();
 	            
             SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
            
             while ( iter.hasNext() ) {
                 Map<String, Object> map = (Map<String, Object>) iter.next();
                 String idValue = map.get("deptCd").toString();
                 BaseModel bm = new BaseModel();

                // bm.setProperties(map);
                 for ( int i=0 ; i<columnAttributes.length ; i++ ) {
                     Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                             map.get(columnAttributes[i].getName()), columnAttributes[i].getType());
                     bm.set(columnAttributes[i].getName(), baseModelValue);
                 }

                 bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                 bmResult.add(bm);
             } 

             //retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
             
             SmrmfUtils.endTiming(logger, millisBeginSelectBass0400List, "selectBass0400List"); 
        

         }
         catch (Exception ex) {
             //Return operation exception
             throw MSFServerUtils.getOperationException("getSysIfWithBass0400List", ex, logger);
         }

         return bmResult;
     }
 	
 	/**
	 * 일반 콤보형태 처리 
	 * @param msfPkgBass0300Dto
	 * @return
	 * @throws MSFException
	 */
	 
	public List<BaseModel> getSysIfComboBass0300List(SysIfBass0300DTO msfPkgBass0300Dto) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getSysIfComboBass0300List";
        SysComSearchVO  msfPkgSrhVo = new SysComSearchVO(); 
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        
        if  (MSFSharedUtils.paramNull(msfPkgSmrmfDAO)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
        }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
           
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
 	        
        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                     ,new ColumnAttribute("commCd", "commCd", ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("commCdNm", "commCdNm", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem01", "mangeItem01", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem02", "mangeItem02", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem03", "mangeItem03", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem04", "mangeItem04", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem05", "mangeItem05", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem06", "mangeItem06", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem07", "mangeItem07", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem08", "mangeItem08", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem09", "mangeItem09", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem10", "mangeItem10", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem11", "mangeItem11", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem12", "mangeItem12", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem13", "mangeItem13", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem14", "mangeItem14", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem15", "mangeItem15", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem16", "mangeItem16", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem17", "mangeItem17", ColumnDef.TYPE_STRING)
                      ,new ColumnAttribute("mangeItem18", "mangeItem18", ColumnDef.TYPE_STRING)};
        	
            //Get paging configuration
           // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
        	msfPkgSrhVo.setDpobCd(sessionUser.getDpobCd());
            msfPkgSrhVo.setRpsttvCd(msfPkgBass0300Dto.getRpsttvCd()); 
            msfPkgSrhVo.setMangeItem01(msfPkgBass0300Dto.getMangeItem01()); 
            msfPkgSrhVo.setMangeItem02(msfPkgBass0300Dto.getMangeItem02()); 
            msfPkgSrhVo.setMangeItem03(msfPkgBass0300Dto.getMangeItem03()); 
            msfPkgSrhVo.setMangeItem04(msfPkgBass0300Dto.getMangeItem04()); 
            msfPkgSrhVo.setMangeItem05(msfPkgBass0300Dto.getMangeItem05()); 
            msfPkgSrhVo.setMangeItem06(msfPkgBass0300Dto.getMangeItem06()); 
            msfPkgSrhVo.setMangeItem07(msfPkgBass0300Dto.getMangeItem07()); 
            msfPkgSrhVo.setMangeItem08(msfPkgBass0300Dto.getMangeItem08()); 
            msfPkgSrhVo.setMangeItem09(msfPkgBass0300Dto.getMangeItem09()); 
            msfPkgSrhVo.setMangeItem10(msfPkgBass0300Dto.getMangeItem10()); 
            msfPkgSrhVo.setMangeItem11(msfPkgBass0300Dto.getMangeItem11()); 
            msfPkgSrhVo.setMangeItem12(msfPkgBass0300Dto.getMangeItem12()); 
            msfPkgSrhVo.setMangeItem13(msfPkgBass0300Dto.getMangeItem13()); 
            msfPkgSrhVo.setMangeItem14(msfPkgBass0300Dto.getMangeItem14()); 
            msfPkgSrhVo.setMangeItem15(msfPkgBass0300Dto.getMangeItem15()); 
            msfPkgSrhVo.setMangeItem16(msfPkgBass0300Dto.getMangeItem16()); 
            msfPkgSrhVo.setMangeItem17(msfPkgBass0300Dto.getMangeItem17()); 
            msfPkgSrhVo.setMangeItem18(msfPkgBass0300Dto.getMangeItem18()); 
            msfPkgSrhVo.setMangeItem19(msfPkgBass0300Dto.getMangeItem19()); 
            msfPkgSrhVo.setMangeItem10(msfPkgBass0300Dto.getMangeItem20()); 
            
            msfPkgSrhVo.setCommKey(sessionUser.getDpobCd() 
                    + msfPkgBass0300Dto.getRpsttvCd() 
                    + msfPkgBass0300Dto.getMangeItem01()
                    + msfPkgBass0300Dto.getMangeItem02()
                    + msfPkgBass0300Dto.getMangeItem03()
                    + msfPkgBass0300Dto.getMangeItem04()
                    + msfPkgBass0300Dto.getMangeItem05()
                    + msfPkgBass0300Dto.getMangeItem06()
                    + msfPkgBass0300Dto.getMangeItem07()
                    + msfPkgBass0300Dto.getMangeItem08()
                    + msfPkgBass0300Dto.getMangeItem09()
                    + msfPkgBass0300Dto.getMangeItem10());
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        //    if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  msfPkgSmrmfDAO.selectBass0300ListTotCnt(msfPkgSrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
         //       pagingValues.totalRecordCount = iResultCnt;	       
                
         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         //  }
        
            TimingInfo millisBeginSelectBass0300List = SmrmfUtils.startTiming(logger);
        
        	 

            /**페이지 카운트 처리를 위한 부분 */ 
          //  msfPkgSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
           // 	msfPkgSrhVo.setFirstIndex(pagingValues.start);
           // }
           // if (pagingValues.offsetLimit > 0) {
           // 	 msfPkgSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            msfPkgSrhVo.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = msfPkgSmrmfDAO.selectBass0300ComboList(msfPkgSrhVo);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("commCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0300List, "selectBass0300List");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return bmResult;
    }
 	
	public PagingLoadResult<BaseModel> getSelectSsoxIfUserList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  MSFPKG_SSOXUSER_LIST;
        SsoxUserSrhVO   ssoxUserSrhVo = new SsoxUserSrhVO(); 
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
       if  (MSFSharedUtils.paramNull(msfPkgSsoSmrmfDAO)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            msfPkgSsoSmrmfDAO = (SysIfSsoSmrmfDAO) wac.getBean("SysIfSsoSmrmfDAO" ); 
        }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // SsoxIfUserBM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */ 
            ssoxUserSrhVo.setDpobCd(sessionUser.getDpobCd());
            ssoxUserSrhVo.setUserName(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "userName")));    //검색조건처리 
            ssoxUserSrhVo.setDeptId(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptId")));  
            
            //sysComSrhVo.setRpsttvCd(strCriteriaValue); 
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	            if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = msfPkgSsoSmrmfDAO.selectSsoxIfUserListTotCnt(ssoxUserSrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectSsoxIfUserList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            ssoxUserSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	ssoxUserSrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	ssoxUserSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = msfPkgSsoSmrmfDAO.selectSsoxIfUserList(ssoxUserSrhVo);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("userId").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectSsoxIfUserList, "selectSsoxIfUserList");
			

        } catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }  
	
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 올레 로컬데이타 올레정보가져오기  
	 * 2. 처리내용 : 올레 로컬데이타 올레정보가져오기  
	 * </pre>
	 * @Method Name : getSelectSsomIfUserList
	 * @date : 2018. 1. 25.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2018. 1. 25.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getSelectSsomIfUserList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  MSFPKG_SSOMUSER_LIST;
        SsoxUserSrhVO   ssoxUserSrhVo = new SsoxUserSrhVO(); 
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
       if  (MSFSharedUtils.paramNull(sysIfSsomUserDAO)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            sysIfSsomUserDAO = (SysIfSsomUserDAO) wac.getBean("SysIfSsomUserDAO" ); 
        }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // SsoxIfUserBM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */ 
            ssoxUserSrhVo.setDpobCd(sessionUser.getDpobCd());
            ssoxUserSrhVo.setUserName(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "userName")));    //검색조건처리 
            ssoxUserSrhVo.setDeptId(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptId")));  
            
            //sysComSrhVo.setRpsttvCd(strCriteriaValue); 
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	            if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = sysIfSsomUserDAO.selectSsomIfUserListTotCnt(ssoxUserSrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectSsomIfUserList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            ssoxUserSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	ssoxUserSrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	ssoxUserSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = sysIfSsomUserDAO.selectSsomIfUserList(ssoxUserSrhVo);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("userId").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectSsomIfUserList, "selectSsomIfUserList");
			

        } catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }  
	
	
	/** 인사 팝업 검색 **/
	public PagingLoadResult<BaseModel> getSysComPopupPsnl0100List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  MSFPKG_METHOD_POPUP_PSNL0100_List;
        SysComSearchVO   msfPkgSearchVO = new SysComSearchVO();
        SysIfPsnl0100VO sysComPsnl0100Vo = new SysIfPsnl0100VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(msfPkgSmrmfDAO)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
        }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0100BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
            msfPkgSearchVO.setDpobCd(sessionUser.getDpobCd());  
            msfPkgSearchVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
            msfPkgSearchVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
            msfPkgSearchVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
            sysComPsnl0100Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
          //  sysComSrhVo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsDivCd"))); 
            sysComPsnl0100Vo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드  
            sysComPsnl0100Vo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            sysComPsnl0100Vo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
            sysComPsnl0100Vo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));    //재직상
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	            if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = msfPkgSmrmfDAO.selectPsnl0100ListTotCnt(msfPkgSearchVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPsnl0100List = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            msfPkgSearchVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	msfPkgSearchVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	msfPkgSearchVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list  
            List list = msfPkgSmrmfDAO.selectPsnl0100List(msfPkgSearchVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPsnl0100List, "selectPsnl0100List");
       
        } catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	
	  /**
     * <pre>
     * 1. 개요 : 직종  콤보 형태를 공통 rpc 로직을 호출 하여 처리 할 경우 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getSysComLookBass0320List
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
    public PagingLoadResult<BaseModel> getSysComLookBass0320List(ServiceParameters serviceParameters) throws MSFException {

   	 
            PagingLoadResult<BaseModel> retval = null;
            String method = MSFPKG_METHOD_COMBO_BASS0320_List;
            SysComSearchVO  msfPkgSearchVO = new SysComSearchVO();
            SysIfBass0320VO sysComBass0320VO = new SysIfBass0320VO();
            List<BaseModel> bmResult = new ArrayList<BaseModel>();
            MSFServerExtAuth msfServerExtAuth = MSFServerExtAuth.getInstance();
            List<String> listDeptCd = new ArrayList<String>();
            
            if  (MSFSharedUtils.paramNull(msfPkgSmrmfDAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
            }
            
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
                msfPkgSearchVO.setDpobCd(sessionUser.getDpobCd()); 
                msfPkgSearchVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());
                msfPkgSearchVO.setUsrId(sessionUser.getUsrId());
                
                msfPkgSearchVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
                msfPkgSearchVO.setDtilOccuInttnCdAuth("");
                /******************************** 권한 ************************************************************************/
                String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
                
                
                if ("FALSE".equals(chkDeptCd)) {
                	
                   msfPkgSearchVO.setDeptCd(sessionUser.getDeptCd()); 
                   listDeptCd.add(sessionUser.getDeptCd());
                   msfPkgSearchVO.setDeptCdArr(listDeptCd);     //부서코드    
                   msfPkgSearchVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
                } else if ("Y".equals(sessionUser.getYrtxInptPrcsYn())) {
                // 연말정산 처리를 위해 추가됨.
                	 msfPkgSearchVO.setDeptCd(sessionUser.getDeptCd()); 
                     listDeptCd.add(sessionUser.getDeptCd());
                     msfPkgSearchVO.setDeptCdArr(listDeptCd);     //부서코드    
                     msfPkgSearchVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
                } else {
                	    
                	msfPkgSearchVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));    
                         if (msfPkgSearchVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                         	 listDeptCd = null; 
                         	msfPkgSearchVO.setDeptCdArr(listDeptCd);     //부서코드 
                         	msfPkgSearchVO.setDeptCd("");  //부서코드
                         } else {
                        	 msfPkgSearchVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                              listDeptCd = MSFSharedUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                              msfPkgSearchVO.setDeptCdArr(listDeptCd);     //부서코드   
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
                msfPkgSearchVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
               
                
              //  sysComSrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
                //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                        
                    //Execute query that returns a single value
                    TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                     
                    int iResultCnt =  msfPkgSmrmfDAO.selectBass0320ComboTypOccuCdListTotCnt(msfPkgSearchVO);  
                  
                    SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                    pagingValues.totalRecordCount = iResultCnt;        
                    
                    logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
               }
            
                TimingInfo millisBeginSelectBass0320List = SmrmfUtils.startTiming(logger);
             

                /**페이지 카운트 처리를 위한 부분 */ 
                msfPkgSearchVO.setPageSize(pagingValues.totalRecordCount);  
                
                //Apply paging
                if (pagingValues.start > 0) {
                	msfPkgSearchVO.setFirstIndex(pagingValues.start);
                }
                if (pagingValues.totalRecordCount < 100) {
                	msfPkgSearchVO.setLastIndex(pagingValues.totalRecordCount); 
                } else if (pagingValues.offsetLimit > 0) {
                	msfPkgSearchVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
                }

                //Execute query and convert to BaseModel list
                TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
                
                @SuppressWarnings("unchecked")
//              Collection<Map<String, Object>> list ??????
                List list = msfPkgSmrmfDAO.selectBass0320ComboTypOccuCdList(msfPkgSearchVO);
                
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
                
                SmrmfUtils.endTiming(logger, millisBeginSelectBass0320List, "getSysComLookBass0320List");
           
            } catch (Exception ex) {
                ex.printStackTrace();
                //Return operation exception
                throw MSFServerUtils.getOperationException(method, ex, logger);
            }

            return retval;
      }
     
    
    public SysIfBass0400DTO getFuncBeforComboBass0400List(SysIfBass0400DTO sysIfBass0400Dto) throws MSFException { 
     
        SysComSearchVO  msfPkgSrhVo = new SysComSearchVO(); 
       
        List<String> bmResult = new  ArrayList<String>();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
  
        
        if  (MSFSharedUtils.paramNull(msfPkgSmrmfDAO)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
        }
        
        try {
             
            /** 조건절 */
        	msfPkgSrhVo.setYmdGb(sysIfBass0400Dto.getYmdGb());
            msfPkgSrhVo.setStrDate(sysIfBass0400Dto.getStrDate());
            msfPkgSrhVo.setDpobCd(sessionUser.getDpobCd());
            msfPkgSrhVo.setDeptCd(sysIfBass0400Dto.getDeptCd());
            msfPkgSrhVo.setDeptCdArr(sysIfBass0400Dto.getDeptCdArr());
            msfPkgSrhVo.setDeptDspyYn("Y"); 

            List list = msfPkgSmrmfDAO.setFuncBeforComboBass0400List(msfPkgSrhVo); 
            
            if (list.size() > 0) {
            	 bmResult.addAll(sysIfBass0400Dto.getDeptCdArr());
            	 for(int ic=0;ic < list.size();ic++) {
	                	Map mapList = (Map)list.get(ic);
	                	bmResult.add(String.valueOf(mapList.get("dtilOccuInttnCd")));
	             }
            	 sysIfBass0400Dto.setDeptCdArr(bmResult);
            } 
	       
        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException("getFuncBeforComboBass0400List", ex, logger);
        }

        return sysIfBass0400Dto;
    }
    
	 public SysIfBass0320DTO getFuncBeforComboBass0320List(SysIfBass0320DTO sysComBass0320Dto) throws MSFException {
		  //   PagingLoadResult<BaseModel> retval = null; 
		     SysComSearchVO  msfPkgSrhVo = new SysComSearchVO(); 
	       
		    List<String> bmResult = new  ArrayList<String>();
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	  
	        
	        if  (MSFSharedUtils.paramNull(msfPkgSmrmfDAO)) {
	            
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
	        }
	        
	        try {
	             
	            /** 조건절 */
	        	msfPkgSrhVo.setYmdGb(sysComBass0320Dto.getYmdGb());
	            msfPkgSrhVo.setStrDate(sysComBass0320Dto.getStrDate());
	            msfPkgSrhVo.setDpobCd(sessionUser.getDpobCd());
	         //   msfPkgSrhVo.setDeptCd(sysComBass0320Dto.getDeptCd());
	         //   msfPkgSrhVo.setDeptCdArr(sysComBass0320Dto.getDeptCdArr());
	            msfPkgSrhVo.setTypOccuCd(sysComBass0320Dto.getTypOccuCd());
	            msfPkgSrhVo.setTypOccuCdArr(sysComBass0320Dto.getTypOccuCdArr());

	            List list = msfPkgSmrmfDAO.setFuncBeforComboBass0320List(msfPkgSrhVo); 
	            
	            if (list.size() > 0) {
	            	bmResult.addAll(sysComBass0320Dto.getRtnTypOccuCdArr());
	            	 for(int ic=0;ic < list.size();ic++) {
		                	Map mapList = (Map)list.get(ic);
		                	bmResult.add(String.valueOf(mapList.get("dtilOccuInttnCd")));
		                }
	            	 sysComBass0320Dto.setRtnTypOccuCdArr(bmResult);
	            } 
		       
	        }
	        catch (Exception ex) {
	            //Return operation exception
	            throw MSFServerUtils.getOperationException("getFuncBeforComboBass0320List", ex, logger);
	        }

	        return sysComBass0320Dto;
	 }
	
	 
	 @SuppressWarnings("unchecked")
	public SysIfBass0350DTO getFuncBeforComboBass0350List(SysIfBass0350DTO sysIfBass0350Dto) throws MSFException {
		    SysComSearchVO  msfPkgSrhVo = new SysComSearchVO(); 
	       
		    List<String> bmResult = new  ArrayList<String>();
		    List<String> bmResultInttn = new  ArrayList<String>();
		    
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	  
	        
	        if  (MSFSharedUtils.paramNull(msfPkgSmrmfDAO)) {
	            
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
	        }
	        
	        try {
	             
	            /** 조건절 */
	        	msfPkgSrhVo.setYmdGb(sysIfBass0350Dto.getYmdGb());
	            msfPkgSrhVo.setStrDate(sysIfBass0350Dto.getStrDate());
	            msfPkgSrhVo.setDpobCd(sessionUser.getDpobCd());
	            //msfPkgSrhVo.setDeptCd(sysIfBass0350Dto.getDeptCd());
	            //msfPkgSrhVo.setDeptCdArr(sysIfBass0350Dto.getDeptCdArr()); 
	            msfPkgSrhVo.setTypOccuCd(sysIfBass0350Dto.getTypOccuCd());
	            msfPkgSrhVo.setTypOccuCdArr(sysIfBass0350Dto.getTypOccuCdArr());
	            msfPkgSrhVo.setDtilOccuInttnCd(sysIfBass0350Dto.getDtilOccuInttnCd());
	            msfPkgSrhVo.setDtilOccuInttnCdArr(sysIfBass0350Dto.getDtilOccuInttnCdArr());
	            
	            List list = msfPkgSmrmfDAO.setFuncBeforComboBass0350List(msfPkgSrhVo); 
	            
	            if (list.size() > 0) {
	            	
	            	bmResult.addAll(sysIfBass0350Dto.getTypOccuCdArr());
		           	 for(int ic=0;ic < list.size();ic++) {
		                	Map mapList = (Map)list.get(ic);
		                	bmResult.add(String.valueOf(mapList.get("typOccuCd")));
		                }
		           	  sysIfBass0350Dto.setRtnTypOccuCdArr(bmResult);
		           	  
		           	bmResultInttn.addAll(sysIfBass0350Dto.getDtilOccuInttnCdArr());
	           	 for(int ic=0;ic < list.size();ic++) {
	                	Map mapList = (Map)list.get(ic);
	                	bmResultInttn.add(String.valueOf(mapList.get("dtilOccuInttnCd")));
	                }
	           	  sysIfBass0350Dto.setRtnDtilOccuInttnCdArr(bmResultInttn);
	            }  
		       
	        }
	        catch (Exception ex) {
	            //Return operation exception
	            throw MSFServerUtils.getOperationException("getFuncBeforComboBass0350List", ex, logger);
	        }

	        return sysIfBass0350Dto;
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
	     * @see com.app.exterms.prgm.client.service.SysIfBass0350Service#getPrgmComComboTypOccuCdList(com.app.exterms.prgm.client.dto.SysIfBass0350DTO)
	     * @param sysComBass0350Dto
	     * @return
	     * @throws MSFException
	     */ 	
	    public List<BaseModel> getSysIfComboTypOccuCdList(SysIfBass0320DTO sysComBass0320Dto) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method = "getSysIfComboTypOccuCdList";
	        SysComSearchVO  sysComSrhVo = new SysComSearchVO();
	        SysIfBass0320VO sysComBass0320Vo = new SysIfBass0320VO();
	        List<BaseModel> bmResult = new ArrayList<BaseModel>();
	        MSFServerExtAuth msfServerExtAuth = MSFServerExtAuth.getInstance();
	        List<String> listDeptCd = new ArrayList<String>();
	        
	        if  (MSFSharedUtils.paramNull(msfPkgSmrmfDAO)) {
	            
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
	        }
	        
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
	           	   sysComSrhVo.setDeptCd(sessionUser.getDeptCd()); 
	               listDeptCd.add(sessionUser.getDeptCd());
	               sysComSrhVo.setDeptCdArr(listDeptCd);  //부서코드    
	               sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	    
	            	     sysComSrhVo.setPayrMangDeptCd(MSFSharedUtils.defaultNulls(sysComBass0320Dto.getPayrMangDeptCd(),sessionUser.getTplvlDeptCd()));  
	                     if (sysComSrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(sysComBass0320Dto.getDeptCd()))) { 
	                     	 listDeptCd = null; 
	                     	 sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                     	 sysComSrhVo.setDeptCd("");  //부서코드
	                     } else {
	                    	  sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(sysComBass0320Dto.getDeptCd()));
	                          listDeptCd = MSFSharedUtils.getStrToArrayList(MSFSharedUtils.allowNulls(sysComBass0320Dto.getDeptCd()));  
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
//	            Collection<Map<String, Object>> list ??????
	            List list = msfPkgSmrmfDAO.selectBass0320TypOccuCdList(sysComSrhVo);
	            
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
		 * 1. 개요 : 일반 콤보형태 처리 직종세 
		 * 2. 처리내용 : PrgmComComboUtils.class 에서  getSingleBass0350ComboData(SysIfBass0350DTO sysComBass0350Dto) 에서 호출 
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
		 * @see com.app.exterms.prgm.client.service.SysIfBass0350Service#getPrgmComComboBass0350List(com.app.exterms.prgm.client.dto.SysIfBass0350DTO)
		 * @param sysComBass0350Dto
		 * @return
		 * @throws MSFException
		 */ 	
		public List<BaseModel> getSysIfComboBass0350List(SysIfBass0350DTO sysComBass0350Dto) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method = "getSysIfComboBass0350List";
	        SysComSearchVO  sysComSrhVo = new SysComSearchVO();
	        SysIfBass0350VO sysComBass0350Vo = new SysIfBass0350VO();
	        List<BaseModel> bmResult = new ArrayList<BaseModel>();
	        List<String> listDeptCd = new ArrayList<String>();
	        if  (MSFSharedUtils.paramNull(msfPkgSmrmfDAO)) {
	            
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            msfPkgSmrmfDAO = (SysIfPkgSmrmfDAO) wac.getBean("SysIfPkgSmrmfDAO" ); 
	        }
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
	              	  sysComSrhVo.setDeptCd(sessionUser.getDeptCd()); 
	                  listDeptCd.add( sessionUser.getDeptCd() );
	                  sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	                  
	               } else { 
	               	 
	               	
	                    sysComSrhVo.setPayrMangDeptCd(MSFSharedUtils.defaultNulls(sysComBass0350Dto.getPayrMangDeptCd(),sessionUser.getTplvlDeptCd()));    
	                    if (sysComSrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()))) { 
	                        listDeptCd = null; 
	                    	sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                    	sysComSrhVo.setDeptCd("");  //부서코드
	                    } else {
	                   	     sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()));
	                         listDeptCd = MSFSharedUtils.getStrToArrayList(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()));  
	                         sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                    } 
	                     
	               } 
	               sysComSrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(sysComBass0350Dto.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
	               sysComSrhVo.setDtilOccuInttnCdAuth("");
	               /******************************** 권한 ************************************************************************/
	               List<String> lstTypeOccuCd = MSFSharedUtils.getStrToArrayList(MSFSharedUtils.allowNulls(sysComBass0350Dto.getTypOccuCd())); 
	               sysComSrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	               sysComSrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(sysComBass0350Dto.getTypOccuCd())); 
	         
	            //  sysComSrhVo.setPyspGrdeCd( sysComBass0350Dto.getPyspGrdeCd()); 
	            
	         
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		        //    if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt =  msfPkgSmrmfDAO.selectSysIfBass0350ListTotCnt(sysComSrhVo);  
	              
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
//	            Collection<Map<String, Object>> list ??????
	            List list = msfPkgSmrmfDAO.selectSysIfBass0350List(sysComSrhVo);
	            
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
	    
 
}
