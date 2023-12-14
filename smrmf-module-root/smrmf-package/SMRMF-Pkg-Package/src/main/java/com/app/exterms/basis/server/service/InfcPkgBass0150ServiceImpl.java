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
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.basis.client.dto.InfcPkgBass0150DTO;
import com.app.exterms.basis.client.dto.InfcPkgBass0500DTO;
import com.app.exterms.basis.client.service.InfcPkgBass0150Service;
import com.app.exterms.basis.shared.PkgBasisDaoConstants;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.basis.server.service.dao.InfcPkgBass0150DAO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0150SrhVO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0150VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("InfcPkgBass0150Service")
public class InfcPkgBass0150ServiceImpl  extends AbstractCustomServiceImpl implements  PkgBasisDaoConstants , InfcPkgBass0150Service  {

	private static final Logger logger = LoggerFactory.getLogger(InfcPkgBass0150ServiceImpl.class);
	private static final String calledClass = InfcPkgBass0150ServiceImpl.class.getName();

	@Autowired
	@Resource(name="InfcPkgBass0150DAO")
	private InfcPkgBass0150DAO bass0150DAO;


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta2070ToBass0150List(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2070_BASS0150_LIST;
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		InfcPkgBass0150SrhVO srhVo = new InfcPkgBass0150SrhVO();

		if(MSFSharedUtils.paramNull(bass0150DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
		}
		try{
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
			PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

			String srhDegtrResnRegnNum = MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm"));

			if ( pagingValues.executeRecordCount ) { 
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				int iResultCnt = bass0150DAO.selectYeta2070ToBass0150ListTotCnt(srhVo);
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}

				pagingValues.totalRecordCount = iResultCnt;	       
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
			TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);

			srhVo.setPageSize(pagingValues.totalRecordCount);
			if( pagingValues.start > 0){
				srhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			List list = bass0150DAO.selectYeta2070ToBass0150List(srhVo);
			Iterator<Map<String, Object>> iter = list.iterator();
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");


			while ( iter.hasNext() ) {
				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = map.get("dpobCdPayrMangDeptCd").toString();

				BaseModel bm = new BaseModel();

				for ( int i=0 ; i<tableAttributes.length ; i++ ) {

					if(	"degtrResnRegnNum".equals(tableAttributes[i].getName())) {

						String rrnDecCrypt = "";

						// TODO 주민번호
						nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("degtrResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

						String strValue = rrnDecCrypt;
						bm.set(tableAttributes[i].getName(), strValue);
					}else{	
						Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
								map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
						bm.set(tableAttributes[i].getName(), baseModelValue);
					}
				}
				bm.set(TableDef.ID_PROPERTY_NAME, idValue);

				bmResult.add(bm);
			}
			retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);

			SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "selectBass0150List");

		}catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;

	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta3070ToBass0150List(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA2070_BASS0150_LIST;
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		InfcPkgBass0150SrhVO srhVo = new InfcPkgBass0150SrhVO();

		if(MSFSharedUtils.paramNull(bass0150DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
		}
		try{
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
			PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

			String srhDegtrResnRegnNum = MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm"));

			if ( pagingValues.executeRecordCount ) { 
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				int iResultCnt = bass0150DAO.selectYeta2070ToBass0150ListTotCnt(srhVo);
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}

				pagingValues.totalRecordCount = iResultCnt;	       
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
			TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);

			srhVo.setPageSize(pagingValues.totalRecordCount);
			if( pagingValues.start > 0){
				srhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			List list = bass0150DAO.selectYeta2070ToBass0150List(srhVo);
			Iterator<Map<String, Object>> iter = list.iterator();
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");


			while ( iter.hasNext() ) {
				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = map.get("dpobCdPayrMangDeptCd").toString();

				BaseModel bm = new BaseModel();

				for ( int i=0 ; i<tableAttributes.length ; i++ ) {

					if(	"degtrResnRegnNum".equals(tableAttributes[i].getName())) {

						String rrnDecCrypt = "";

						// TODO 주민번호
						nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("degtrResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

						String strValue = rrnDecCrypt;
						bm.set(tableAttributes[i].getName(), strValue);
					}else{	
						Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
								map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
						bm.set(tableAttributes[i].getName(), baseModelValue);
					}
				}
				bm.set(TableDef.ID_PROPERTY_NAME, idValue);

				bmResult.add(bm);
			}
			retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);

			SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "selectBass0150List");

		}catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;

	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta2070ToBass0120List(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method =  METHOD_LOOK_BASS0120_LIST;
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		InfcPkgBass0150SrhVO srhVo = new InfcPkgBass0150SrhVO();

		if(MSFSharedUtils.paramNull(bass0150DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
		}
		try{
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0100BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            srhVo.setUntDpobFndtnUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "untDpobFndtnUseYn")));
            /** 조건절 */
                
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
            if ( pagingValues.executeRecordCount ) { 
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				System.out.println("확인해보자");
				int iResultCnt = bass0150DAO.selectYeta2070ToBass0120ListTotCnt(srhVo);
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}

				pagingValues.totalRecordCount = iResultCnt;	       
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

            /**페이지 카운트 처리를 위한 부분 */ 
            TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);

			srhVo.setPageSize(pagingValues.totalRecordCount);
			if( pagingValues.start > 0){
				srhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//          Collection<Map<String, Object>> list ??????
            List list = bass0150DAO.selectYeta2070ToBass0120List(srhVo);
            
            Iterator<Map<String, Object>> iter = list.iterator();
            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("utDpobCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "getSelectYeta2070ToBass0120List");
       

        }catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;

	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta3070ToBass0120List(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method =  METHOD_LOOK_BASS0120_LIST;
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		InfcPkgBass0150SrhVO srhVo = new InfcPkgBass0150SrhVO();

		if(MSFSharedUtils.paramNull(bass0150DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
		}
		try{
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0100BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            srhVo.setUntDpobFndtnUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "untDpobFndtnUseYn")));
            /** 조건절 */
                
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
            if ( pagingValues.executeRecordCount ) { 
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				System.out.println("확인해보자");
				int iResultCnt = bass0150DAO.selectYeta2070ToBass0120ListTotCnt(srhVo);
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}

				pagingValues.totalRecordCount = iResultCnt;	       
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

            /**페이지 카운트 처리를 위한 부분 */ 
            TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);

			srhVo.setPageSize(pagingValues.totalRecordCount);
			if( pagingValues.start > 0){
				srhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//          Collection<Map<String, Object>> list ??????
            List list = bass0150DAO.selectYeta2070ToBass0120List(srhVo);
            
            Iterator<Map<String, Object>> iter = list.iterator();
            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("utDpobCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "getSelectYeta2070ToBass0120List");
       

        }catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;

	}
		
	@Override
	public Long yeta2070ToBass0150Update(List<InfcPkgBass0150DTO> listPkgBass0150Dto, ActionDatabase actionDatabase) throws MSFException {

		String method = calledClass + ".yeta2070ToBass0150Update";

		String windowNm = "주(총괄납부)사업장사업관리";
		String windowId = "YETA2070";
		
		if(MSFSharedUtils.paramNull(bass0150DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
		}
    	 
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    		
		Long retval = 0L;
    	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  

    	InfcPkgBass0150VO pkgBass0150Vo = new InfcPkgBass0150VO(); // 현근무지급여지급명세
		   
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
		
	    try {

			for (int iCnt = 0; iCnt < listPkgBass0150Dto.size(); iCnt++) {
		                
				InfcPkgBass0150DTO PkgBass0150Dto = new InfcPkgBass0150DTO(); // 연말정산대상자기본
				PkgBass0150Dto = listPkgBass0150Dto.get(iCnt);
				
				pkgBass0150Vo.setPayrMangDeptCd(PkgBass0150Dto.getPayrMangDeptCd());
				pkgBass0150Vo.setUntDpobCd(PkgBass0150Dto.getUntDpobCd());
				
				bass0150DAO.updateYeta2070ToBass0150(pkgBass0150Vo);
				
				retval = 1L;
			}
			
	        }catch (Exception ex) {
	        	 
	            logger.error("EXCEPTION calling yeta2070ToBass0150Update(): "+ex); 
	            
	            /** 에러 로그 **/			
	            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
	            
	            retval = 0L;
	            throw MSFServerUtils.getOperationException("yeta2070ToBass0150Update", ex, logger);
	        } 
	        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D"); 
	        
	        return retval;
	
	}
	@Override
	public Long yeta3070ToBass0150Update(List<InfcPkgBass0150DTO> listPkgBass0150Dto, ActionDatabase actionDatabase) throws MSFException {

		String method = calledClass + ".yeta2070ToBass0150Update";

		String windowNm = "주(총괄납부)사업장사업관리";
		String windowId = "YETA3070";
		
		if(MSFSharedUtils.paramNull(bass0150DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
		}
    	 
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    		
		Long retval = 0L;
    	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  

    	InfcPkgBass0150VO pkgBass0150Vo = new InfcPkgBass0150VO(); // 현근무지급여지급명세
		   
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
		
	    try {

			for (int iCnt = 0; iCnt < listPkgBass0150Dto.size(); iCnt++) {
		                
				InfcPkgBass0150DTO PkgBass0150Dto = new InfcPkgBass0150DTO(); // 연말정산대상자기본
				PkgBass0150Dto = listPkgBass0150Dto.get(iCnt);
				
				pkgBass0150Vo.setPayrMangDeptCd(PkgBass0150Dto.getPayrMangDeptCd());
				pkgBass0150Vo.setUntDpobCd(PkgBass0150Dto.getUntDpobCd());
				
				bass0150DAO.updateYeta2070ToBass0150(pkgBass0150Vo);
				
				retval = 1L;
			}
			
	        }catch (Exception ex) {
	        	 
	            logger.error("EXCEPTION calling yeta3070ToBass0150Update(): "+ex); 
	            
	            /** 에러 로그 **/			
	            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
	            
	            retval = 0L;
	            throw MSFServerUtils.getOperationException("yeta3070ToBass0150Update", ex, logger);
	        } 
	        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D"); 
	        
	        return retval;
	
	}
//----------------------------------------------------------------------------------------------------------------------------------------------2019
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta4070ToBass0150List(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA4070_BASS0150_LIST;
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		InfcPkgBass0150SrhVO srhVo = new InfcPkgBass0150SrhVO();

		if(MSFSharedUtils.paramNull(bass0150DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
		}
		try{
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
			PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

			String srhDegtrResnRegnNum = MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm"));

			if ( pagingValues.executeRecordCount ) { 
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				int iResultCnt = bass0150DAO.selectYeta2070ToBass0150ListTotCnt(srhVo);
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}

				pagingValues.totalRecordCount = iResultCnt;	       
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
			TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);

			srhVo.setPageSize(pagingValues.totalRecordCount);
			if( pagingValues.start > 0){
				srhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			List list = bass0150DAO.selectYeta2070ToBass0150List(srhVo);
			Iterator<Map<String, Object>> iter = list.iterator();
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");


			while ( iter.hasNext() ) {
				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = map.get("dpobCdPayrMangDeptCd").toString();

				BaseModel bm = new BaseModel();

				for ( int i=0 ; i<tableAttributes.length ; i++ ) {

					if(	"degtrResnRegnNum".equals(tableAttributes[i].getName())) {

						String rrnDecCrypt = "";

						// TODO 주민번호
						nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("degtrResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

						String strValue = rrnDecCrypt;
						bm.set(tableAttributes[i].getName(), strValue);
					}else{	
						Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
								map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
						bm.set(tableAttributes[i].getName(), baseModelValue);
					}
				}
				bm.set(TableDef.ID_PROPERTY_NAME, idValue);

				bmResult.add(bm);
			}
			retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);

			SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "selectBass0150List");

		}catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectYeta4070ToBass0120List(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method =  METHOD_LOOK_BASS0120_LIST;
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		InfcPkgBass0150SrhVO srhVo = new InfcPkgBass0150SrhVO();

		if(MSFSharedUtils.paramNull(bass0150DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
		}
		try{
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0100BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            srhVo.setUntDpobFndtnUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "untDpobFndtnUseYn")));
            /** 조건절 */
                
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
            if ( pagingValues.executeRecordCount ) { 
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				System.out.println("확인해보자");
				int iResultCnt = bass0150DAO.selectYeta2070ToBass0120ListTotCnt(srhVo);
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}

				pagingValues.totalRecordCount = iResultCnt;	       
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

            /**페이지 카운트 처리를 위한 부분 */ 
            TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);

			srhVo.setPageSize(pagingValues.totalRecordCount);
			if( pagingValues.start > 0){
				srhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//          Collection<Map<String, Object>> list ??????
            List list = bass0150DAO.selectYeta2070ToBass0120List(srhVo);
            
            Iterator<Map<String, Object>> iter = list.iterator();
            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("utDpobCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "getSelectYeta2070ToBass0120List");
       

        }catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;

	}
	
	public Long yeta4070ToBass0150Update(List<InfcPkgBass0150DTO> listPkgBass0150Dto, ActionDatabase actionDatabase) throws MSFException {

		String method = calledClass + ".yeta4070ToBass0150Update";

		String windowNm = "주(총괄납부)사업장사업관리";
		String windowId = "YETA4070";
		
		if(MSFSharedUtils.paramNull(bass0150DAO)){
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
		}
    	 
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    		
		Long retval = 0L;
    	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  

    	InfcPkgBass0150VO pkgBass0150Vo = new InfcPkgBass0150VO(); // 현근무지급여지급명세
		   
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
		
	    try {

			for (int iCnt = 0; iCnt < listPkgBass0150Dto.size(); iCnt++) {
		                
				InfcPkgBass0150DTO PkgBass0150Dto = new InfcPkgBass0150DTO(); // 연말정산대상자기본
				PkgBass0150Dto = listPkgBass0150Dto.get(iCnt);
				
				pkgBass0150Vo.setPayrMangDeptCd(PkgBass0150Dto.getPayrMangDeptCd());
				pkgBass0150Vo.setUntDpobCd(PkgBass0150Dto.getUntDpobCd());
				
				bass0150DAO.updateYeta2070ToBass0150(pkgBass0150Vo);
				
				retval = 1L;
			}
			
	        }catch (Exception ex) {
	        	 
	            logger.error("EXCEPTION calling yeta4070ToBass0150Update(): "+ex); 
	            
	            /** 에러 로그 **/			
	            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
	            
	            retval = 0L;
	            throw MSFServerUtils.getOperationException("yeta3070ToBass0150Update", ex, logger);
	        } 
	        
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D"); 
	        
	        return retval;
	
	}
	
	
	
	
	
	//----------------------------------------------------------------------------------------------------------------------------------------------2020
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public PagingLoadResult<BaseModel> getSelectYeta5070ToBass0150List(ServiceParameters serviceParameters) throws MSFException {

			PagingLoadResult<BaseModel> retval = null;
			String method =  CLASS_YETA5070_BASS0150_LIST;
			List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			InfcPkgBass0150SrhVO srhVo = new InfcPkgBass0150SrhVO();

			if(MSFSharedUtils.paramNull(bass0150DAO)){
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
			}
			try{
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
				IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
				List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
				PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

				PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

				String srhDegtrResnRegnNum = MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm"));

				if ( pagingValues.executeRecordCount ) { 
					TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
					int iResultCnt = bass0150DAO.selectYeta2070ToBass0150ListTotCnt(srhVo);
					SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

					//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
					if (!pagingValues.pageExecute) { 
						pagingValues.offsetLimit = iResultCnt;       
					}

					pagingValues.totalRecordCount = iResultCnt;	       
					logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
				}
				TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);

				srhVo.setPageSize(pagingValues.totalRecordCount);
				if( pagingValues.start > 0){
					srhVo.setFirstIndex(pagingValues.start);
				}
				if (pagingValues.offsetLimit > 0) {
					srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
				}
				TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

				List list = bass0150DAO.selectYeta2070ToBass0150List(srhVo);
				Iterator<Map<String, Object>> iter = list.iterator();
				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");


				while ( iter.hasNext() ) {
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("dpobCdPayrMangDeptCd").toString();

					BaseModel bm = new BaseModel();

					for ( int i=0 ; i<tableAttributes.length ; i++ ) {

						if(	"degtrResnRegnNum".equals(tableAttributes[i].getName())) {

							String rrnDecCrypt = "";

							// TODO 주민번호
							nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("degtrResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

							String strValue = rrnDecCrypt;
							bm.set(tableAttributes[i].getName(), strValue);
						}else{	
							Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
									map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
							bm.set(tableAttributes[i].getName(), baseModelValue);
						}
					}
					bm.set(TableDef.ID_PROPERTY_NAME, idValue);

					bmResult.add(bm);
				}
				retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);

				SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "selectBass0150List");

			}catch (Exception ex) {
				ex.printStackTrace();
				//Return operation exception
				throw MSFServerUtils.getOperationException(method, ex, logger);
			}

			return retval;
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public PagingLoadResult<BaseModel> getSelectYeta5070ToBass0120List(ServiceParameters serviceParameters) throws MSFException {

			PagingLoadResult<BaseModel> retval = null;
			String method =  METHOD_LOOK_BASS0120_LIST;
			List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			InfcPkgBass0150SrhVO srhVo = new InfcPkgBass0150SrhVO();

			if(MSFSharedUtils.paramNull(bass0150DAO)){
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
			}
			try{
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	           // Sysm0100BM          user             = serviceParameters.getUser();
	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

	            //Get paging configuration
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
	            
	            srhVo.setUntDpobFndtnUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "untDpobFndtnUseYn")));
	            /** 조건절 */
	                
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	            if ( pagingValues.executeRecordCount ) { 
					TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
					System.out.println("확인해보자");
					int iResultCnt = bass0150DAO.selectYeta2070ToBass0120ListTotCnt(srhVo);
					SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

					//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
					if (!pagingValues.pageExecute) { 
						pagingValues.offsetLimit = iResultCnt;       
					}

					pagingValues.totalRecordCount = iResultCnt;	       
					logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
				}

	            /**페이지 카운트 처리를 위한 부분 */ 
	            TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);

				srhVo.setPageSize(pagingValues.totalRecordCount);
				if( pagingValues.start > 0){
					srhVo.setFirstIndex(pagingValues.start);
				}
				if (pagingValues.offsetLimit > 0) {
					srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
				}
				TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	          Collection<Map<String, Object>> list ??????
	            List list = bass0150DAO.selectYeta2070ToBass0120List(srhVo);
	            
	            Iterator<Map<String, Object>> iter = list.iterator();
	            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("utDpobCd").toString();
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "getSelectYeta2070ToBass0120List");
	       

	        }catch (Exception ex) {
				ex.printStackTrace();
				//Return operation exception
				throw MSFServerUtils.getOperationException(method, ex, logger);
			}

			return retval;

		}
		
		public Long yeta5070ToBass0150Update(List<InfcPkgBass0150DTO> listPkgBass0150Dto, ActionDatabase actionDatabase) throws MSFException {

			String method = calledClass + ".yeta5070ToBass0150Update";

			String windowNm = "주(총괄납부)사업장사업관리";
			String windowId = "YETA5070";
			
			if(MSFSharedUtils.paramNull(bass0150DAO)){
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
			}
	    	 
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		
			Long retval = 0L;
	    	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  

	    	InfcPkgBass0150VO pkgBass0150Vo = new InfcPkgBass0150VO(); // 현근무지급여지급명세
			   
		    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		    System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
			
		    try {

				for (int iCnt = 0; iCnt < listPkgBass0150Dto.size(); iCnt++) {
			                
					InfcPkgBass0150DTO PkgBass0150Dto = new InfcPkgBass0150DTO(); // 연말정산대상자기본
					PkgBass0150Dto = listPkgBass0150Dto.get(iCnt);
					
					pkgBass0150Vo.setPayrMangDeptCd(PkgBass0150Dto.getPayrMangDeptCd());
					pkgBass0150Vo.setUntDpobCd(PkgBass0150Dto.getUntDpobCd());
					
					bass0150DAO.updateYeta2070ToBass0150(pkgBass0150Vo);
					
					retval = 1L;
				}
				
		        }catch (Exception ex) {
		        	 
		            logger.error("EXCEPTION calling yeta5070ToBass0150Update(): "+ex); 
		            
		            /** 에러 로그 **/			
		            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
		            
		            retval = 0L;
		            throw MSFServerUtils.getOperationException("yeta3070ToBass0150Update", ex, logger);
		        } 
		        
				/** 로그반영
				 * CRUDSBLO
				 * C:create		R:read		U:update
		    	 * D:delete		S:select	B:배치 
		    	 * L:로그인		O:로그아웃
		    	 */
				MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D"); 
		        
		        return retval;
		
		}
	
		
		
		
		//----------------------------------------------------------------------------------------------------------------------------------------------2021
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public PagingLoadResult<BaseModel> getSelectYeta6070ToBass0150List(ServiceParameters serviceParameters) throws MSFException {

			PagingLoadResult<BaseModel> retval = null;
			String method =  CLASS_YETA6070_BASS0150_LIST;
			List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			InfcPkgBass0150SrhVO srhVo = new InfcPkgBass0150SrhVO();

			if(MSFSharedUtils.paramNull(bass0150DAO)){
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
			}
			try{
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
				IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
				List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
				PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

				PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

				String srhDegtrResnRegnNum = MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm"));

				if ( pagingValues.executeRecordCount ) { 
					TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
					int iResultCnt = bass0150DAO.selectYeta2070ToBass0150ListTotCnt(srhVo);
					SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

					//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
					if (!pagingValues.pageExecute) { 
						pagingValues.offsetLimit = iResultCnt;       
					}

					pagingValues.totalRecordCount = iResultCnt;	       
					logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
				}
				TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);

				srhVo.setPageSize(pagingValues.totalRecordCount);
				if( pagingValues.start > 0){
					srhVo.setFirstIndex(pagingValues.start);
				}
				if (pagingValues.offsetLimit > 0) {
					srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
				}
				TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

				List list = bass0150DAO.selectYeta2070ToBass0150List(srhVo);
				Iterator<Map<String, Object>> iter = list.iterator();
				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");


				while ( iter.hasNext() ) {
					Map<String, Object> map = (Map<String, Object>) iter.next();
					String idValue = map.get("dpobCdPayrMangDeptCd").toString();

					BaseModel bm = new BaseModel();

					for ( int i=0 ; i<tableAttributes.length ; i++ ) {

						if(	"degtrResnRegnNum".equals(tableAttributes[i].getName())) {

							String rrnDecCrypt = "";

							// TODO 주민번호
							nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("degtrResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

							String strValue = rrnDecCrypt;
							bm.set(tableAttributes[i].getName(), strValue);
						}else{	
							Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
									map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
							bm.set(tableAttributes[i].getName(), baseModelValue);
						}
					}
					bm.set(TableDef.ID_PROPERTY_NAME, idValue);

					bmResult.add(bm);
				}
				retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);

				SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "selectBass0150List");

			}catch (Exception ex) {
				ex.printStackTrace();
				//Return operation exception
				throw MSFServerUtils.getOperationException(method, ex, logger);
			}

			return retval;
		}
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public PagingLoadResult<BaseModel> getSelectYeta6070ToBass0120List(ServiceParameters serviceParameters) throws MSFException {

			PagingLoadResult<BaseModel> retval = null;
			String method =  METHOD_LOOK_BASS0120_LIST;
			List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			InfcPkgBass0150SrhVO srhVo = new InfcPkgBass0150SrhVO();

			if(MSFSharedUtils.paramNull(bass0150DAO)){
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
			}
			try{
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	           // Sysm0100BM          user             = serviceParameters.getUser();
	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

	            //Get paging configuration
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
	            
	            srhVo.setUntDpobFndtnUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "untDpobFndtnUseYn")));
	            /** 조건절 */
	                
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	            if ( pagingValues.executeRecordCount ) { 
					TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
					System.out.println("확인해보자");
					int iResultCnt = bass0150DAO.selectYeta2070ToBass0120ListTotCnt(srhVo);
					SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

					//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
					if (!pagingValues.pageExecute) { 
						pagingValues.offsetLimit = iResultCnt;       
					}

					pagingValues.totalRecordCount = iResultCnt;	       
					logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
				}

	            /**페이지 카운트 처리를 위한 부분 */ 
	            TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);

				srhVo.setPageSize(pagingValues.totalRecordCount);
				if( pagingValues.start > 0){
					srhVo.setFirstIndex(pagingValues.start);
				}
				if (pagingValues.offsetLimit > 0) {
					srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
				}
				TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	          Collection<Map<String, Object>> list ??????
	            List list = bass0150DAO.selectYeta2070ToBass0120List(srhVo);
	            
	            Iterator<Map<String, Object>> iter = list.iterator();
	            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("utDpobCd").toString();
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "getSelectYeta2070ToBass0120List");
	       

	        }catch (Exception ex) {
				ex.printStackTrace();
				//Return operation exception
				throw MSFServerUtils.getOperationException(method, ex, logger);
			}

			return retval;

		}
		
		public Long yeta6070ToBass0150Update(List<InfcPkgBass0150DTO> listPkgBass0150Dto, ActionDatabase actionDatabase) throws MSFException {

			String method = calledClass + ".yeta6070ToBass0150Update";

			String windowNm = "주(총괄납부)사업장사업관리";
			String windowId = "YETA6070";
			
			if(MSFSharedUtils.paramNull(bass0150DAO)){
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
			}
	    	 
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    		
			Long retval = 0L;
	    	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  

	    	InfcPkgBass0150VO pkgBass0150Vo = new InfcPkgBass0150VO(); // 현근무지급여지급명세
			   
		    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		    System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
			
		    try {

				for (int iCnt = 0; iCnt < listPkgBass0150Dto.size(); iCnt++) {
			                
					InfcPkgBass0150DTO PkgBass0150Dto = new InfcPkgBass0150DTO(); // 연말정산대상자기본
					PkgBass0150Dto = listPkgBass0150Dto.get(iCnt);
					
					pkgBass0150Vo.setPayrMangDeptCd(PkgBass0150Dto.getPayrMangDeptCd());
					pkgBass0150Vo.setUntDpobCd(PkgBass0150Dto.getUntDpobCd());
					
					bass0150DAO.updateYeta2070ToBass0150(pkgBass0150Vo);
					
					retval = 1L;
				}
				
		        }catch (Exception ex) {
		        	 
		            logger.error("EXCEPTION calling yeta6070ToBass0150Update(): "+ex); 
		            
		            /** 에러 로그 **/			
		            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
		            
		            retval = 0L;
		            throw MSFServerUtils.getOperationException("yeta6070ToBass0150Update", ex, logger);
		        } 
		        
				/** 로그반영
				 * CRUDSBLO
				 * C:create		R:read		U:update
		    	 * D:delete		S:select	B:배치 
		    	 * L:로그인		O:로그아웃
		    	 */
				MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D"); 
		        
		        return retval;
		
		}
		
		

		
		//----------------------------------------------------------------------------------------------------------------------------------------------2022
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public PagingLoadResult<BaseModel> getSelectYeta7070ToBass0150List(ServiceParameters serviceParameters) throws MSFException {

					PagingLoadResult<BaseModel> retval = null;
					String method =  CLASS_YETA7070_BASS0150_LIST;
					List<BaseModel>  bmResult = new ArrayList<BaseModel>();
					InfcPkgBass0150SrhVO srhVo = new InfcPkgBass0150SrhVO();

					if(MSFSharedUtils.paramNull(bass0150DAO)){
						WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
						bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
					}
					try{
						String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
						ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
						IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
						List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
						PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

						PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

						String srhDegtrResnRegnNum = MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm"));

						if ( pagingValues.executeRecordCount ) { 
							TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
							int iResultCnt = bass0150DAO.selectYeta2070ToBass0150ListTotCnt(srhVo);
							SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

							//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
							if (!pagingValues.pageExecute) { 
								pagingValues.offsetLimit = iResultCnt;       
							}

							pagingValues.totalRecordCount = iResultCnt;	       
							logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
						}
						TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);

						srhVo.setPageSize(pagingValues.totalRecordCount);
						if( pagingValues.start > 0){
							srhVo.setFirstIndex(pagingValues.start);
						}
						if (pagingValues.offsetLimit > 0) {
							srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
						}
						TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

						List list = bass0150DAO.selectYeta2070ToBass0150List(srhVo);
						Iterator<Map<String, Object>> iter = list.iterator();
						SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");


						while ( iter.hasNext() ) {
							Map<String, Object> map = (Map<String, Object>) iter.next();
							String idValue = map.get("dpobCdPayrMangDeptCd").toString();

							BaseModel bm = new BaseModel();

							for ( int i=0 ; i<tableAttributes.length ; i++ ) {

								if(	"degtrResnRegnNum".equals(tableAttributes[i].getName())) {

									String rrnDecCrypt = "";

									// TODO 주민번호
									nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
									rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("degtrResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

									String strValue = rrnDecCrypt;
									bm.set(tableAttributes[i].getName(), strValue);
								}else{	
									Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
											map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
									bm.set(tableAttributes[i].getName(), baseModelValue);
								}
							}
							bm.set(TableDef.ID_PROPERTY_NAME, idValue);

							bmResult.add(bm);
						}
						retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);

						SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "selectBass0150List");

					}catch (Exception ex) {
						ex.printStackTrace();
						//Return operation exception
						throw MSFServerUtils.getOperationException(method, ex, logger);
					}

					return retval;
				}
				
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public PagingLoadResult<BaseModel> getSelectYeta7070ToBass0120List(ServiceParameters serviceParameters) throws MSFException {

					PagingLoadResult<BaseModel> retval = null;
					String method =  METHOD_LOOK_BASS0120_LIST;
					List<BaseModel>  bmResult = new ArrayList<BaseModel>();
					InfcPkgBass0150SrhVO srhVo = new InfcPkgBass0150SrhVO();

					if(MSFSharedUtils.paramNull(bass0150DAO)){
						WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
						bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
					}
					try{
			            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
			           // Sysm0100BM          user             = serviceParameters.getUser();
			            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
			            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			            //Get paging configuration
			            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
			            
			            srhVo.setUntDpobFndtnUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "untDpobFndtnUseYn")));
			            /** 조건절 */
			                
			            //Get total record count //전체 데이터 갯수를 가지고 온다. 
			            if ( pagingValues.executeRecordCount ) { 
							TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
							System.out.println("확인해보자");
							int iResultCnt = bass0150DAO.selectYeta2070ToBass0120ListTotCnt(srhVo);
							SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

							//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
							if (!pagingValues.pageExecute) { 
								pagingValues.offsetLimit = iResultCnt;       
							}

							pagingValues.totalRecordCount = iResultCnt;	       
							logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
						}

			            /**페이지 카운트 처리를 위한 부분 */ 
			            TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);

						srhVo.setPageSize(pagingValues.totalRecordCount);
						if( pagingValues.start > 0){
							srhVo.setFirstIndex(pagingValues.start);
						}
						if (pagingValues.offsetLimit > 0) {
							srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
						}
						TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			            
			            @SuppressWarnings("unchecked")
//			          Collection<Map<String, Object>> list ??????
			            List list = bass0150DAO.selectYeta2070ToBass0120List(srhVo);
			            
			            Iterator<Map<String, Object>> iter = list.iterator();
			            
			            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
			           
			            while ( iter.hasNext() ) {
			                Map<String, Object> map = (Map<String, Object>) iter.next();
			                String idValue = map.get("utDpobCd").toString();
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
			            
			            SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "getSelectYeta2070ToBass0120List");
			       

			        }catch (Exception ex) {
						ex.printStackTrace();
						//Return operation exception
						throw MSFServerUtils.getOperationException(method, ex, logger);
					}

					return retval;

				}
				
				public Long yeta7070ToBass0150Update(List<InfcPkgBass0150DTO> listPkgBass0150Dto, ActionDatabase actionDatabase) throws MSFException {

					String method = calledClass + ".yeta7070ToBass0150Update";

					String windowNm = "주(총괄납부)사업장사업관리";
					String windowId = "YETA7070";
					
					if(MSFSharedUtils.paramNull(bass0150DAO)){
						WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
						bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
					}
			    	 
					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			    		
					Long retval = 0L;
			    	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  

			    	InfcPkgBass0150VO pkgBass0150Vo = new InfcPkgBass0150VO(); // 현근무지급여지급명세
					   
				    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
				    System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
					
				    try {

						for (int iCnt = 0; iCnt < listPkgBass0150Dto.size(); iCnt++) {
					                
							InfcPkgBass0150DTO PkgBass0150Dto = new InfcPkgBass0150DTO(); // 연말정산대상자기본
							PkgBass0150Dto = listPkgBass0150Dto.get(iCnt);
							
							pkgBass0150Vo.setPayrMangDeptCd(PkgBass0150Dto.getPayrMangDeptCd());
							pkgBass0150Vo.setUntDpobCd(PkgBass0150Dto.getUntDpobCd());
							
							bass0150DAO.updateYeta2070ToBass0150(pkgBass0150Vo);
							
							retval = 1L;
						}
						
				        }catch (Exception ex) {
				        	 
				            logger.error("EXCEPTION calling yeta7070ToBass0150Update(): "+ex); 
				            
				            /** 에러 로그 **/			
				            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
				            
				            retval = 0L;
				            throw MSFServerUtils.getOperationException("yeta7070ToBass0150Update", ex, logger);
				        } 
				        
						/** 로그반영
						 * CRUDSBLO
						 * C:create		R:read		U:update
				    	 * D:delete		S:select	B:배치 
				    	 * L:로그인		O:로그아웃
				    	 */
						MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D"); 
				        
				        return retval;
				
				}
				
				
				
				//----------------------------------------------------------------------------------------------------------------------------------------------2023
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public PagingLoadResult<BaseModel> getSelectYeta8070ToBass0150List(ServiceParameters serviceParameters) throws MSFException {

					PagingLoadResult<BaseModel> retval = null;
					String method =  CLASS_YETA8070_BASS0150_LIST;
					List<BaseModel>  bmResult = new ArrayList<BaseModel>();
					InfcPkgBass0150SrhVO srhVo = new InfcPkgBass0150SrhVO();

					if(MSFSharedUtils.paramNull(bass0150DAO)){
						WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
						bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
					}
					try{
						String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
						ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
						IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
						List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
						PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

						PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

						String srhDegtrResnRegnNum = MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "srhDegtrNm"));

						if ( pagingValues.executeRecordCount ) { 
							TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
							int iResultCnt = bass0150DAO.selectYeta2070ToBass0150ListTotCnt(srhVo);
							SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

							//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
							if (!pagingValues.pageExecute) { 
								pagingValues.offsetLimit = iResultCnt;       
							}

							pagingValues.totalRecordCount = iResultCnt;	       
							logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
						}
						TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);

						srhVo.setPageSize(pagingValues.totalRecordCount);
						if( pagingValues.start > 0){
							srhVo.setFirstIndex(pagingValues.start);
						}
						if (pagingValues.offsetLimit > 0) {
							srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
						}
						TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

						List list = bass0150DAO.selectYeta2070ToBass0150List(srhVo);
						Iterator<Map<String, Object>> iter = list.iterator();
						SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");


						while ( iter.hasNext() ) {
							Map<String, Object> map = (Map<String, Object>) iter.next();
							String idValue = map.get("dpobCdPayrMangDeptCd").toString();

							BaseModel bm = new BaseModel();

							for ( int i=0 ; i<tableAttributes.length ; i++ ) {

								if(	"degtrResnRegnNum".equals(tableAttributes[i].getName())) {

									String rrnDecCrypt = "";

									// TODO 주민번호
									nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
									rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("degtrResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

									String strValue = rrnDecCrypt;
									bm.set(tableAttributes[i].getName(), strValue);
								}else{	
									Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
											map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
									bm.set(tableAttributes[i].getName(), baseModelValue);
								}
							}
							bm.set(TableDef.ID_PROPERTY_NAME, idValue);

							bmResult.add(bm);
						}
						retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);

						SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "selectBass0150List");

					}catch (Exception ex) {
						ex.printStackTrace();
						//Return operation exception
						throw MSFServerUtils.getOperationException(method, ex, logger);
					}

					return retval;
				}
				
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public PagingLoadResult<BaseModel> getSelectYeta8070ToBass0120List(ServiceParameters serviceParameters) throws MSFException {

					PagingLoadResult<BaseModel> retval = null;
					String method =  METHOD_LOOK_BASS0120_LIST;
					List<BaseModel>  bmResult = new ArrayList<BaseModel>();
					InfcPkgBass0150SrhVO srhVo = new InfcPkgBass0150SrhVO();

					if(MSFSharedUtils.paramNull(bass0150DAO)){
						WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
						bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
					}
					try{
			            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
			           // Sysm0100BM          user             = serviceParameters.getUser();
			            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
			            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			            //Get paging configuration
			            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
			            
			            srhVo.setUntDpobFndtnUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "untDpobFndtnUseYn")));
			            /** 조건절 */
			                
			            //Get total record count //전체 데이터 갯수를 가지고 온다. 
			            if ( pagingValues.executeRecordCount ) { 
							TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
							System.out.println("확인해보자");
							int iResultCnt = bass0150DAO.selectYeta2070ToBass0120ListTotCnt(srhVo);
							SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

							//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
							if (!pagingValues.pageExecute) { 
								pagingValues.offsetLimit = iResultCnt;       
							}

							pagingValues.totalRecordCount = iResultCnt;	       
							logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
						}

			            /**페이지 카운트 처리를 위한 부분 */ 
			            TimingInfo millisBeginSelectBass0150List = SmrmfUtils.startTiming(logger);

						srhVo.setPageSize(pagingValues.totalRecordCount);
						if( pagingValues.start > 0){
							srhVo.setFirstIndex(pagingValues.start);
						}
						if (pagingValues.offsetLimit > 0) {
							srhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
						}
						TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			            
			            @SuppressWarnings("unchecked")
//			          Collection<Map<String, Object>> list ??????
			            List list = bass0150DAO.selectYeta2070ToBass0120List(srhVo);
			            
			            Iterator<Map<String, Object>> iter = list.iterator();
			            
			            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
			           
			            while ( iter.hasNext() ) {
			                Map<String, Object> map = (Map<String, Object>) iter.next();
			                String idValue = map.get("utDpobCd").toString();
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
			            
			            SmrmfUtils.endTiming(logger, millisBeginSelectBass0150List, "getSelectYeta2070ToBass0120List");
			       

			        }catch (Exception ex) {
						ex.printStackTrace();
						//Return operation exception
						throw MSFServerUtils.getOperationException(method, ex, logger);
					}

					return retval;

				}
				
				public Long yeta8070ToBass0150Update(List<InfcPkgBass0150DTO> listPkgBass0150Dto, ActionDatabase actionDatabase) throws MSFException {

					String method = calledClass + ".yeta8070ToBass0150Update";

					String windowNm = "주(총괄납부)사업장사업관리";
					String windowId = "YETA8070";
					
					if(MSFSharedUtils.paramNull(bass0150DAO)){
						WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
						bass0150DAO = (InfcPkgBass0150DAO) wac.getBean("InfcPkgBass0150DAO");
					}
			    	 
					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			    		
					Long retval = 0L;
			    	BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  

			    	InfcPkgBass0150VO pkgBass0150Vo = new InfcPkgBass0150VO(); // 현근무지급여지급명세
					   
				    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
				    System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
					
				    try {

						for (int iCnt = 0; iCnt < listPkgBass0150Dto.size(); iCnt++) {
					                
							InfcPkgBass0150DTO PkgBass0150Dto = new InfcPkgBass0150DTO(); // 연말정산대상자기본
							PkgBass0150Dto = listPkgBass0150Dto.get(iCnt);
							
							pkgBass0150Vo.setPayrMangDeptCd(PkgBass0150Dto.getPayrMangDeptCd());
							pkgBass0150Vo.setUntDpobCd(PkgBass0150Dto.getUntDpobCd());
							
							bass0150DAO.updateYeta2070ToBass0150(pkgBass0150Vo);
							
							retval = 1L;
						}
						
				        }catch (Exception ex) {
				        	 
				            logger.error("EXCEPTION calling yeta8070ToBass0150Update(): "+ex); 
				            
				            /** 에러 로그 **/			
				            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D", ex, windowNm , windowId);
				            
				            retval = 0L;
				            throw MSFServerUtils.getOperationException("yeta8070ToBass0150Update", ex, logger);
				        } 
				        
						/** 로그반영
						 * CRUDSBLO
						 * C:create		R:read		U:update
				    	 * D:delete		S:select	B:배치 
				    	 * L:로그인		O:로그아웃
				    	 */
						MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D"); 
				        
				        return retval;
				
				}
		
	
	
	
	
	
	
}
