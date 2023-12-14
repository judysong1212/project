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

import java.util.ArrayList;
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
import com.app.exterms.prgm.client.dto.PrgmComBass0120DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0120Service;
import com.app.exterms.prgm.server.service.dao.PrgmComBass0120DAO;
import com.app.exterms.prgm.server.vo.PrgmComBass0120SrhVO;
import com.app.exterms.prgm.server.vo.PrgmComBass0120VO;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
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

@Service("PrgmComBass0120Service")
public class PrgmComBass0120ServiceImpl  extends AbstractCustomServiceImpl implements  PrgmComDaoConstants , PrgmComBass0120Service  {

	private static final Logger logger = LoggerFactory.getLogger(PrgmComBass0120ServiceImpl.class);
	private static final String calledClass = PrgmComBass0120ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name="PrgmComBass0120DAO")
	private PrgmComBass0120DAO bass0120DAO;
	    

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagingLoadResult<BaseModel> getSelectPrgmComBass0120List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String nResult = null;
        String method =  PRGMCOM_METHOD_BASS0120_LIST;
        PrgmComBass0120SrhVO   bass0120SrhVO = new PrgmComBass0120SrhVO();
        PrgmComBass0120VO      bass0120Vo = new PrgmComBass0120VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        //MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if(MSFSharedUtils.paramNull(bass0120DAO)){
//        	WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//        	bass0120DAO = (PrgmComBass0120DAO) wac.getBean("PrgmComBass0120DAO");
//        }
        bass0120DAO = (PrgmComBass0120DAO)BeanFinder.getBean("PrgmComBass0120DAO");
        
        try{
        	
        	
        	ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            String srhDpobNm = MSFServerUtils.getFilterValue(columnFilters, "utDpobNm") == null ? "" : String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "utDpobNm"));
             
            bass0120SrhVO.setUtDpobNm(srhDpobNm); 
            
            if ( pagingValues.executeRecordCount ) { 
            	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
            	int iResultCnt = bass0120DAO.selectBass0120ListTotCnt(bass0120SrhVO);
            	
            	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
            TimingInfo millisBeginSelectBass0120List = SmrmfUtils.startTiming(logger);
            
            bass0120SrhVO.setPageSize(pagingValues.totalRecordCount);
            if( pagingValues.start > 0){
            	bass0120SrhVO.setFirstIndex(pagingValues.start);
            }
            
            if (pagingValues.totalRecordCount < 100) {
            	bass0120SrhVO.setLastIndex(pagingValues.totalRecordCount); 
            } else if (pagingValues.offsetLimit > 0) {
            	bass0120SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            } 
            
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            List list = bass0120DAO.selectBass0120List(bass0120SrhVO);
            
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
            
        
            while ( iter.hasNext() ) { 

                  nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
                
                
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("dpobCd").toString();
                BaseModel bm = new BaseModel();

                for ( int i=0 ; i<tableAttributes.length ; i++ ) {

                	if(	"degtrResnRegnNum".equals(tableAttributes[i].getName())) {

                		String rrnDecCrypt = "";

                		// TODO 주민번호
                		nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
                		rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("degtrResnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

                		String strValue = rrnDecCrypt;
                		bm.set(tableAttributes[i].getName(), strValue);
                		
                	}else if("resuNumb".equals(tableAttributes[i].getName())){
                		
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0120List, "getSelectPrgmComBass0120List");
            
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
        
    }


	@Override
	public List<BaseModel> getPrgmComComboBass0120List(
			PrgmComBass0120DTO sysComBass0120Dto) {
		// TODO Auto-generated method stub
		return null;
	}
	 

}
