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
import com.app.exterms.prgm.client.service.PrgmComPsnl0115Service;
import com.app.exterms.prgm.server.service.dao.PrgmComPsnl0100DAO;
import com.app.exterms.prgm.server.service.dao.PrgmComPsnl0115DAO;
import com.app.exterms.prgm.server.vo.PrgmComPsnl0115SrhVO;
import com.app.exterms.prgm.server.vo.PrgmComPsnl0115VO;
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
@Service("PrgmComPsnl0115Service")  
public class PrgmComPsnl0115ServiceImpl extends AbstractCustomServiceImpl implements PrgmComDaoConstants, PrgmComPsnl0115Service {
    private static final Logger logger = LoggerFactory.getLogger(PrgmComPsnl0115ServiceImpl.class);

    public PrgmComPsnl0115ServiceImpl() {
    
    }
        
    @Autowired
    @Resource(name="PrgmComPsnl0115DAO")
    private PrgmComPsnl0115DAO psnl0115DAO;
    
//    /** ID Generation */
//    //@Resource(name="{egovPsnl0115IdGnrService}")    
//    //private EgovIdGnrService egovIdGnrService;
//
//    /**
//     * PSNL0115을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Psnl0115VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    public String insertPsnl0115(PrgmComPsnl0115VO vo) throws Exception {
//        log.debug(vo.toString());
//        
//        /** ID Generation Service */
//        //TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//        //String id = egovIdGnrService.getNextStringId();
//        //vo.setId(id);
//        log.debug(vo.toString());
//        
//        psnl0115DAO.insertPsnl0115(vo);
//        //TODO 해당 테이블 정보에 맞게 수정     
//        return null;
//    }
//
//    /**
//     * PSNL0115을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Psnl0115VO
//     * @return void형
//     * @exception Exception
//     */
//    public void updatePsnl0115(PrgmComPsnl0115VO vo) throws Exception {
//        psnl0115DAO.updatePsnl0115(vo);
//    }
//
//    /**
//     * PSNL0115을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Psnl0115VO
//     * @return void형 
//     * @exception Exception
//     */
//    public void deletePsnl0115(PrgmComPsnl0115VO vo) throws Exception {
//        psnl0115DAO.deletePsnl0115(vo);
//    }
//
//    /**
//     * PSNL0115을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Psnl0115VO
//     * @return 조회한 PSNL0115
//     * @exception Exception
//     */
//    public PrgmComPsnl0115VO selectPsnl0115(PrgmComPsnl0115VO vo) throws Exception {
//        PrgmComPsnl0115VO resultVO = psnl0115DAO.selectPsnl0115(vo);
//        if (resultVO == null)
//            throw processException("info.nodata.msg");
//        return resultVO;
//    }
//
//    /**
//     * PSNL0115 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return PSNL0115 목록
//     * @exception Exception
//     */
//    public List selectPsnl0115List(PrgmComPsnl0115SrhVO searchVO) throws Exception {
//        return psnl0115DAO.selectPsnl0115List(searchVO);
//    }
//
//    /**
//     * PSNL0115 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return PSNL0115 총 갯수
//     * @exception
//     */
//    public int selectPsnl0115ListTotCnt(PrgmComPsnl0115SrhVO searchVO) {
//        return psnl0115DAO.selectPsnl0115ListTotCnt(searchVO);
//    }

    public PagingLoadResult<BaseModel> getPrgmComPopupPsnl0115List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  PRGMCOM_METHOD_POPUP_PSNL0100_List;
        PrgmComPsnl0115SrhVO   sysComPsnl0115SrhVo = new PrgmComPsnl0115SrhVO();
        PrgmComPsnl0115VO sysComPsnl0115Vo = new PrgmComPsnl0115VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        //암호화 추가 처리 함. 
        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
       
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(psnl0115DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            psnl0115DAO = (PrgmComPsnl0115DAO) wac.getBean("PrgmComPsnl0115DAO" ); 
//        }
        
        psnl0115DAO = (PrgmComPsnl0115DAO)BeanFinder.getBean("PrgmComPsnl0115DAO");
        
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
             sysComPsnl0115SrhVo.setDpobCd(sessionUser.getDpobCd());  
           
             sysComPsnl0115SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
             //Get total record count //전체 데이터 갯수를 가지고 온다. 
                if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = psnl0115DAO.selectPsnl0115ListTotCnt(sysComPsnl0115SrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPsnl0115List = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            sysComPsnl0115SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                sysComPsnl0115SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                 sysComPsnl0115SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = psnl0115DAO.selectPsnl0115List(sysComPsnl0115SrhVo);
            
                Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("systemkey").toString();
                BaseModel bm = new BaseModel();

                //bm.setProperties(map);
                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
                    
                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++   
                    Object mapCon = MSFSharedUtils.allowNulls(map.get(tableAttributes[i].getName()));  
                     
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
                        	 //가족주민등록번호  
                        	 if ("famyResnRegnNum".equals(tableAttributes[i].getName())) {
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPsnl0115List, "selectPsnl0115List");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
  
}
