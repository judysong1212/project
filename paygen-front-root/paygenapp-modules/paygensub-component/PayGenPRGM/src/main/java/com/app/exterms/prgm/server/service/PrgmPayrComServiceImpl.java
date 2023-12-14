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
import com.app.exterms.prgm.client.service.PrgmPayrComService;
import com.app.exterms.prgm.server.service.dao.PrgmComPsnl0100DAO;
import com.app.exterms.prgm.server.service.dao.PrgmComPayr0304DAO;
import com.app.exterms.prgm.server.service.dao.PrgmComPayr0400DAO;
import com.app.exterms.prgm.server.utils.PrgmComServerUtils;
import com.app.exterms.prgm.server.vo.PrgmComPsnl0100VO;
import com.app.exterms.prgm.server.vo.PrgmComSearchVO;
import com.app.exterms.prgm.server.vo.PrgmPayr0400SrhVO;
import com.app.exterms.prgm.server.vo.PrgmPayr0400VO;
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
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("PrgmPayrComService")
public class PrgmPayrComServiceImpl extends AbstractCustomServiceImpl  implements  PrgmPayrComService ,PrgmComDaoConstants {
    
    private static final Logger logger = LoggerFactory.getLogger(PrgmPayrComServiceImpl.class);
    private static final String calledClass =  PrgmPayrComServiceImpl.class.getName();
    
    
    @Autowired
    @Resource(name="PrgmComPayr0400DAO")
    private PrgmComPayr0400DAO sysPayr0400DAO;
    
    
    @Autowired
    @Resource(name="PrgmComPsnl0100DAO")
    private PrgmComPsnl0100DAO psnl0100DAO;
    

    public PagingLoadResult<BaseModel> getPrgmPayr0400TypOccuCdList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_SYSPAYR0400_TYP_OCCU_CD;
        PrgmPayr0400SrhVO   sysPayr0400SrhVO = new PrgmPayr0400SrhVO();
        PrgmPayr0400VO      sysPayr0400VO = new PrgmPayr0400VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(sysPayr0400DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            sysPayr0400DAO = (PrgmComPayr0400DAO) wac.getBean("SysPayr0400DAO" ); 
//        }
        
        sysPayr0400DAO = (PrgmComPayr0400DAO)BeanFinder.getBean("PrgmComPayr0400DAO");
        
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
            sysPayr0400SrhVO.setDpobCd(sessionUser.getDpobCd());
           // sysPayr0400SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
           // sysPayr0400SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
           // sysPayr0400SrhVO.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsDivCd")));
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = sysPayr0400DAO.selectPrgmPayr0400TypOccuCdListTotCnt(sysPayr0400SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSysPayr0400TypOccuCdList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            sysPayr0400SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                sysPayr0400SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                sysPayr0400SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = sysPayr0400DAO.selectPrgmPayr0400TypOccuCdList(sysPayr0400SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginSysPayr0400TypOccuCdList, "getSysPayr0400TypOccuCdList");
       

        }
        catch (Exception ex) {
         
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
    
    

    public PagingLoadResult<BaseModel> getPsnl0100ToPayr1700DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  "getPsnl0100ToPayr1700DataList";
        PrgmComSearchVO   sysComSearchVo = new PrgmComSearchVO();
        PrgmComPsnl0100VO      sysComPsnl0100Vo = new PrgmComPsnl0100VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        //암호화 추가 처리 함. 
        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(psnl0100DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            psnl0100DAO = (PrgmComPsnl0100DAO) wac.getBean("PrgmComPsnl0100DAO" ); 
//        }
        psnl0100DAO = (PrgmComPsnl0100DAO)BeanFinder.getBean("PrgmComPsnl0100DAO");
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
            List<String> listDeptCd = new ArrayList<String>();
            /** 조건절 */
            sysComSearchVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            sysComSearchVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
           
            sysComSearchVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
             
            sysComSearchVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
       	    sysComSearchVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
           
       	 
            sysComSearchVo.setUsrId(sessionUser.getUsrId()); 
            sysComSearchVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            sysComSearchVo.setDtilOccuInttnCdAuth("");
         
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	
        	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {

               	    sysComSearchVo.setDeptCd(sessionUser.getDeptCd()); 
                    listDeptCd.add( sessionUser.getDeptCd() );
                    sysComSearchVo.setDeptCdArr(listDeptCd);     //부서코드    
                    
            	   } else {
            		   sysComSearchVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
                       listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                       sysComSearchVo.setDeptCdArr(listDeptCd);     //부서코드   
            		 
            	  }  
        	    
               
            } else { 
            	 
            	
            	 if (sysComSearchVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     listDeptCd = null; 
                     sysComSearchVo.setDeptCdArr(listDeptCd);     //부서코드 
                     sysComSearchVo.setDeptCd("");  //부서코드
                 } else {
              	      sysComSearchVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
                      listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                      sysComSearchVo.setDeptCdArr(listDeptCd);     //부서코드   
                 } 
                  
            } 
           
            /******************************** 권한 ************************************************************************/
             
            
           // sysComSearchVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
            sysComSearchVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
            sysComSearchVo.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
            
            List<String> lstTypeOccuCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
            sysComSearchVo.setTypOccuCdArr(lstTypeOccuCd); 
            sysComSearchVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
           
            List<String> lstPyspGrdeCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
            sysComSearchVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
            sysComSearchVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
             
            List<String> lstDtilOccuClsDivCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsDivCd"))); 
            sysComSearchVo.setDtilOccuClsDivCdArr(lstDtilOccuClsDivCd);  
            sysComSearchVo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsDivCd"))); //직종세
            
            sysComSearchVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
            
            sysComSearchVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            sysComSearchVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
            
            sysComSearchVo.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"mangeDeptCd")));    //관리부서 
            sysComSearchVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")) ); //호봉제구분
            
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = psnl0100DAO.selectPsnl0100ToPayr1700ListTotCnt(sysComSearchVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPsnl0100ToPayr1700DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            sysComSearchVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                sysComSearchVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                sysComSearchVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = psnl0100DAO.selectPsnl0100ToPayr1700List(sysComSearchVo);
            
            Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("systemkey").toString();
                BaseModel bm = new BaseModel();
 
                //bm.setProperties(map);
                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
                	
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
	                     case ColumnDef.TYPE_STRING:  
	                    	 String strValue = "";
	                         if (MSFSharedUtils.paramNotNull(mapCon)) {     
	                        	 strValue = mapCon.toString(); 
	                        	 if ("resnRegnNum".equals(tableAttributes[i].getName())) {
	                        		strValue =   AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	                        	 }  
	                         }  
	                         map.put(tableAttributes[i].getName(), strValue); 
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
            
            SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToPayr1700DataList, "getPsnl0100ToPayr1700DataList");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
       

    //기본정보 
      public PagingLoadResult<BaseModel> getPsnl0100ToPayr4100DataList(ServiceParameters serviceParameters) throws MSFException {

          PagingLoadResult<BaseModel> retval = null;
          String method =  "getPsnl0100ToPayr4100DataList";
          PrgmComSearchVO   sysComSearchVo = new PrgmComSearchVO();
          PrgmComPsnl0100VO      sysComPsnl0100Vo = new PrgmComPsnl0100VO();
          List<BaseModel>  bmResult = new ArrayList<BaseModel>();
          //암호화 추가 처리 함. 
          String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
          
          MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
          
//          if  (MSFSharedUtils.paramNull(psnl0100DAO)) {
//          
//              WebApplicationContext wac = WebApplicationContextUtils.
//                      getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//              psnl0100DAO = (PrgmComPsnl0100DAO) wac.getBean("PrgmComPsnl0100DAO" ); 
//          }
          psnl0100DAO = (PrgmComPsnl0100DAO)BeanFinder.getBean("PrgmComPsnl0100DAO");
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
              List<String> listDeptCd = new ArrayList<String>();
              /** 조건절 */
              sysComSearchVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
              sysComSearchVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
            
              sysComSearchVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
             
              sysComSearchVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
              sysComSearchVo.setDtilOccuInttnCdAuth("");
              sysComSearchVo.setUsrId(sessionUser.getUsrId()); 
              /******************************** 권한 ************************************************************************/
              String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
              sysComSearchVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
        	  sysComSearchVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
              if ("FALSE".equals(chkDeptCd)) {
            	  
          	       if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
       			 
          	    	  sysComSearchVo.setDeptCd(sessionUser.getDeptCd()); 
                      listDeptCd.add( sessionUser.getDeptCd() );
                      sysComSearchVo.setDeptCdArr(listDeptCd);     //부서코드    
            	   } else {
            		   sysComSearchVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
                       listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                       sysComSearchVo.setDeptCdArr(listDeptCd);     //부서코드   
            		 
            	  }  
          	    
            	
                 
              } else {  
            	  
                   if (sysComSearchVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                       listDeptCd = null; 
                       sysComSearchVo.setDeptCdArr(listDeptCd);     //부서코드 
                       sysComSearchVo.setDeptCd("");  //부서코드
                   } else {
                	   sysComSearchVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
                        listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                        sysComSearchVo.setDeptCdArr(listDeptCd);     //부서코드   
                   } 
                    
              } 
             
              /******************************** 권한 ************************************************************************/ 
              
              
              List<String> lstTypeOccuCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
              sysComSearchVo.setTypOccuCdArr(lstTypeOccuCd); 
              sysComSearchVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
             
              List<String> lstPyspGrdeCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
              sysComSearchVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
              sysComSearchVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
               
              List<String> lstDtilOccuClsDivCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsDivCd"))); 
              sysComSearchVo.setDtilOccuClsDivCdArr(lstDtilOccuClsDivCd);  
              sysComSearchVo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsDivCd"))); //직종세 
              
              sysComSearchVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
              sysComSearchVo.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
            
              sysComSearchVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
              sysComSearchVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
              
              String strHdofcCodtnCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"));
              
              List<String> listHdofcCodtnCd = new ArrayList<String>(); 
             
              String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
              
              for (int i=0; i<ray.length; i++){ 
                  listHdofcCodtnCd.add(ray[i]);
              } 
              sysComSearchVo.setHdofcCodtnCdArr(listHdofcCodtnCd);    //재직상
              sysComSearchVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));    //재직상
              
              sysComSearchVo.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"mangeDeptCd")));    //관리부서 
              sysComSearchVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")) ); //호봉제구분
              
              //Get total record count //전체 데이터 갯수를 가지고 온다. 
               if ( pagingValues.executeRecordCount ) { 
                      
                  //Execute query that returns a single value
                  TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                   
                  int iResultCnt = psnl0100DAO.selectPsnl0100ToPayr4100ListTotCnt(sysComSearchVo);  
                
                  SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                  pagingValues.totalRecordCount = iResultCnt;        
                  
                  logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
              }
          
              TimingInfo millisBeginPsnl0100ToPayr4100DataList = SmrmfUtils.startTiming(logger);
          
              /**페이지 카운트 처리를 위한 부분 */ 
              sysComSearchVo.setPageSize(pagingValues.totalRecordCount);  
              
              //Apply paging
              if (pagingValues.start > 0) {
                  sysComSearchVo.setFirstIndex(pagingValues.start);
              }
              if (pagingValues.offsetLimit > 0) {
                  sysComSearchVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
              }

              //Execute query and convert to BaseModel list
              TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
              
              @SuppressWarnings("unchecked")
//              Collection<Map<String, Object>> list  
              List list = psnl0100DAO.selectPsnl0100ToPayr4100List(sysComSearchVo);
              
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
                       case ColumnDef.TYPE_STRING:  
                    	   String strValue = "";
                           if (MSFSharedUtils.paramNotNull(mapCon)) {     
                          	 strValue = mapCon.toString();   
                          	 if ("resnRegnNum".equals(tableAttributes[i].getName())) {
                          		strValue =   AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                          	 }  
                           }  
                           map.put(tableAttributes[i].getName(), strValue); 
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
              
              SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToPayr4100DataList, "getPsnl0100ToPayr4100DataList");
         

          }
          catch (Exception ex) {
              ex.printStackTrace();
              //Return operation exception
              throw MSFServerUtils.getOperationException(method, ex, logger);
          }

          return retval;
      } 
    
      
}
