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
package com.app.smrmf.sysauth.systemmtr.server.service;

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

import com.any.smrmf.utils.BeanFinder;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0800DTO;
import com.app.smrmf.infc.sysif.msfpackage.shared.MSFPkgDaoConstants;
import com.app.smrmf.sysauth.systemmtr.client.service.SysmMtr0500Service;
import com.app.smrmf.sysauth.systemmtr.shared.SysmMtrDaoConstants;
import com.app.smrmf.sysm.server.service.dao.SysIfBass0300DAO;
import com.app.smrmf.sysm.server.service.dao.Sysm0300DAO;
import com.app.smrmf.sysm.server.service.dao.Sysm0800DAO;
import com.app.smrmf.sysm.server.service.vo.SysComSearchVO;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0300VO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0300SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0300VO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0800SrhVO;
import com.app.smrmf.sysm.server.vo.SysIfSysm0800VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("SysmMtr0500Service")
public class SysmMtr0500ServiceImpl extends AbstractCustomServiceImpl implements  SysmMtrDaoConstants , SysmMtr0500Service,MSFPkgDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(SysmMtr0500ServiceImpl.class);
	private static final String calledClass = SysmMtr0500ServiceImpl.class.getName();
	
	@Autowired 
    @Resource(name="Sysm0800DAO")
    private Sysm0800DAO sysm0800DAO;
	
	@Autowired 
    @Resource(name="Sysm0300DAO")
    private Sysm0300DAO sysm0300DAO;
	
	@Autowired 
    @Resource(name="SysIfBass0300DAO")
    private SysIfBass0300DAO sysIfBass0300DAO;
    
    /** ID Generation */
    //@Resource(name="{egovSysm0500IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
  
	 
    public Long sysm0800Insert(SysIfSysm0800DTO sysm0800Dto)   throws MSFException {
        
        Long result = new Long(1);
        try { 
          
        	SysIfSysm0800VO sysm0800Vo = new SysIfSysm0800VO(); 
        
            sysm0800Vo.setSysDivCd(sysm0800Dto.getSysDivCd());
            sysm0800Vo.setUsrDivCd( sysm0800Dto.getUsrDivCd());
            sysm0800Vo.setAuthGrpSeilNum(sysm0800Dto.getAuthGrpSeilNum());     
    	    sysm0800Vo.setUsrAuthGrpUseYn("Y"); 
 
    	    sysm0800DAO.insertSysm0800(sysm0800Vo);
             
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling sysm0800Insert(): "+ex); 
            result = new Long(0);
        }
        finally {
          
        }
        return result;
    }
     
    
 public Long sysm0800Delete(SysIfSysm0800DTO sysm0800Dto)   throws MSFException {
     
     Long result = new Long(1);
     try { 
       
    		SysIfSysm0800VO sysm0800Vo = new SysIfSysm0800VO(); 
            
            sysm0800Vo.setSysDivCd(sysm0800Dto.getSysDivCd());
            sysm0800Vo.setUsrDivCd( sysm0800Dto.getUsrDivCd());
            sysm0800Vo.setAuthGrpSeilNum(sysm0800Dto.getAuthGrpSeilNum());   
             
            sysm0800DAO.deleteSysm0800(sysm0800Vo);
          
     }
     catch (Exception ex) {
         logger.error("EXCEPTION calling sysm0800Delete(): "+ex); 
         result = new Long(0);
     }
     finally {
       
     }
     return result;
 } 
 
  /**
   * 
   * <pre>
   * 1. 개요 : 
   * 2. 처리내용 : 
   * </pre>
   * @Method Name : getSelectSysmMtr0500ToSysm0800List
   * @date : 2017. 11. 9.
   * @author : atres
   * @history : 
   *	-----------------------------------------------------------------------
   *	변경일				작성자						변경내용  
   *	----------- ------------------- ---------------------------------------
   *	2017. 11. 9.		atres				최초 작성 
   *	-----------------------------------------------------------------------
   * 
   * @param serviceParameters
   * @return
   * @throws MSFException
   */
	public PagingLoadResult<BaseModel> getSelectSysmMtr0500ToSysm0800List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_SYSMMTR0500TOSYSM0800_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>(); 
        SysIfSysm0800SrhVO   sysIfSysm0800SrhVO = new SysIfSysm0800SrhVO();
        SysIfSysm0800VO sysm0800Vo = new SysIfSysm0800VO(); 
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
       
        sysm0800DAO = (Sysm0800DAO)BeanFinder.getBean("Sysm0800DAO");
        
        
        try{
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            sysIfSysm0800SrhVO.setSysDivCd("EXTERM00");
            sysIfSysm0800SrhVO.setDpobCd(sessionUser.getDpobCd());
            sysIfSysm0800SrhVO.setUsrDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrDivCd")) );
            sysIfSysm0800SrhVO.setAuthGrpNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "authGrpNm"))); 
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = sysm0800DAO.selectSysmMtr0500ToSysm0800ListTotCnt(sysIfSysm0800SrhVO);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
            	if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectSysmMtr0500ToSysm0800List = SmrmfUtils.startTiming(logger);
            
            sysIfSysm0800SrhVO.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	sysIfSysm0800SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	sysIfSysm0800SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = sysm0800DAO.selectSysmMtr0500ToSysm0800List(sysIfSysm0800SrhVO);
            
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            
            
            while (iter.hasNext() ) {
            	
            	Map<String, Object> map = (Map<String, Object>) iter.next();
                String deptCd = String.valueOf(map.get("authGrpSeilNum"));
                
                BaseModel bm = new BaseModel();
                
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
                bm.set(TableDef.ID_PROPERTY_NAME, deptCd);
                
                bmResult.add(bm);
            }
            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);
            
            SmrmfUtils.endTiming(logger, millisBeginSelectSysmMtr0500ToSysm0800List, "getSelectSysmMtr0500ToSysm0800List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getSelectSysmMtr0500ToBass0300List
	 * @date : 2017. 11. 9.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 11. 9.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getSelectSysmMtr0500ToBass0300List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_SYSMMTR0500TOBASS0300_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>(); 
        SysComSearchVO   sysComSrhVo = new SysComSearchVO();
        SysIfBass0300VO sysComBass0300Vo = new SysIfBass0300VO();
      
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
       
        sysIfBass0300DAO = (SysIfBass0300DAO)BeanFinder.getBean("SysIfBass0300DAO");
         
        
        try{
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            sysComSrhVo.setDpobCd(sessionUser.getDpobCd());
            sysComSrhVo.setRpsttvCd("D001"); 
            sysComSrhVo.setUsrDivNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrDivNm"))); 
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = sysIfBass0300DAO.selectSysmMtr0500ToBass0300ListTotCnt(sysComSrhVo);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
            	if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectSysmMtr0500ToBass0300List = SmrmfUtils.startTiming(logger);
            
            sysComSrhVo.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	sysComSrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = sysIfBass0300DAO.selectSysmMtr0500ToBass0300List(sysComSrhVo);
            
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            
            
            while (iter.hasNext() ) {
            	
            	Map<String, Object> map = (Map<String, Object>) iter.next();
                String deptCd = String.valueOf(map.get("commCd"));
                
                BaseModel bm = new BaseModel();
                
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
                bm.set(TableDef.ID_PROPERTY_NAME, deptCd);
                
                bmResult.add(bm);
            }
            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);
            
            SmrmfUtils.endTiming(logger, millisBeginSelectSysmMtr0500ToBass0300List, "getSelectSysmMtr0500ToBass0300List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }
	
	
	public PagingLoadResult<BaseModel> getSelectSysmMtr0500ToSysm0300List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_SYSMMTR0500TOSYSM0300_LIST;
        List<BaseModel>  bmResult = new ArrayList<BaseModel>(); 
        SysIfSysm0300SrhVO   sysIfSysm0300SrhVO = new SysIfSysm0300SrhVO();
        SysIfSysm0300VO sysm0800Vo = new SysIfSysm0300VO(); 
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
       
        sysm0300DAO = (Sysm0300DAO)BeanFinder.getBean("Sysm0300DAO");
        
        
        try{
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            sysIfSysm0300SrhVO.setSysDivCd("EXTERM00");
            sysIfSysm0300SrhVO.setDpobCd(sessionUser.getDpobCd());
            sysIfSysm0300SrhVO.setUsrDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "usrDivCd")) );
            sysIfSysm0300SrhVO.setAuthGrpNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "authGrpNm"))); 
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = sysm0300DAO.selectSelectSysmMtr0500ToSysm0300ListTotCnt(sysIfSysm0300SrhVO);
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
            	if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectSysmMtr0500ToSysm0300List = SmrmfUtils.startTiming(logger);
            
            sysIfSysm0300SrhVO.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	sysIfSysm0300SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	sysIfSysm0300SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = sysm0300DAO.selectSelectSysmMtr0500ToSysm0300List(sysIfSysm0300SrhVO);
            
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            
            
            while (iter.hasNext() ) {
            	
            	Map<String, Object> map = (Map<String, Object>) iter.next();
                String deptCd = String.valueOf(map.get("authGrpSeilNum"));
                
                BaseModel bm = new BaseModel();
                
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
                bm.set(TableDef.ID_PROPERTY_NAME, deptCd);
                
                bmResult.add(bm);
            }
            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);
            
            SmrmfUtils.endTiming(logger, millisBeginSelectSysmMtr0500ToSysm0300List, "getSelectSelectSysmMtr0500ToSysm0300List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }
	
}
