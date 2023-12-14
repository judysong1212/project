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
import com.app.exterms.payroll.client.dto.Payr0600DTO;
import com.app.exterms.payroll.client.dto.Payr0650DTO;
import com.app.exterms.payroll.client.service.Payr4600Service;
import com.app.exterms.payroll.server.service.dao.Payr0600DAO;
import com.app.exterms.payroll.server.service.dao.Payr0650DAO;
import com.app.exterms.payroll.server.vo.Payr0600SrhVO;
import com.app.exterms.payroll.server.vo.Payr0600VO;
import com.app.exterms.payroll.server.vo.Payr0650SrhVO;
import com.app.exterms.payroll.server.vo.Payr0650VO;
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
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Payr4600Service")
public class Payr4600ServiceImpl extends AbstractCustomServiceImpl implements Payr4600Service ,PayrDaoConstants {

	
	private static final Logger logger = LoggerFactory.getLogger(Payr4600ServiceImpl.class);
	private static final String calledClass = Payr4600ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="Payr0600DAO")
    private Payr0600DAO payr0600DAO;
	
	@Autowired
    @Resource(name="Payr0650DAO")
    private Payr0650DAO payr0650DAO;

    public PagingLoadResult<BaseModel> getCboPayr0600DtlWrkrIncmBlggYrList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getPayr0600ApptnYrList";
        Payr0600SrhVO   payr0600SrhVO = new Payr0600SrhVO();
        Payr0600VO payr0600VO = new Payr0600VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();

        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

        // 1. 암호화 객체 생성
//    	String nResult = MSFCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

        if  (MSFSharedUtils.paramNull(payr0600DAO)) {

            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            payr0600DAO = (Payr0600DAO) wac.getBean("Payr0600DAO" );
        }
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
            payr0600SrhVO.setDpobCd(sessionUser.getDpobCd());
            // sysComSrhVo.setRpsttvCd(sysComBass0300Dto.getRpsttvCd());

            //Get total record count //전체 데이터 갯수를 가지고 온다.
            if ( pagingValues.executeRecordCount ) {

                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

                int iResultCnt =  payr0600DAO.selectPayr0600DtlWrkrIncmBlggYrListTotCnt(payr0600SrhVO);

                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
                pagingValues.totalRecordCount = iResultCnt;

                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }

            TimingInfo millisBeginSelectPayr0600List = SmrmfUtils.startTiming(logger);


            /**페이지 카운트 처리를 위한 부분 */
            payr0600SrhVO.setPageSize(pagingValues.totalRecordCount);

            //Apply paging
            if (pagingValues.start > 0) {
                payr0600SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                payr0600SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }


            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
                    List list = payr0600DAO.selectPayr0600DtlWrkrIncmBlggYrList(payr0600SrhVO);

            Iterator<Map<String, Object>> iter = list.iterator();

            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");

            String rrnDecCrypt = "";

            while ( iter.hasNext() ) {

                // 1. 암호화 객체 생성
                String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("dilWrkrIncmBlggYr").toString();
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

                        //3. 복호화
                        case ColumnDef.TYPE_STRING:

                            String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

                            if(	"resnRegnNum".equals(tableAttributes[i].getName())) {

                                // 주민번호(복호화)
                                rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                                strValue = rrnDecCrypt;

                            }else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

                                // 주민번호(복호화)
                                rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
                                idValue = rrnDecCrypt;
                            }

                            map.put(tableAttributes[i].getName(), strValue);

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

            SmrmfUtils.endTiming(logger, millisBeginSelectPayr0600List, "getPayr0600ApptnYrList");



        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }


    public PagingLoadResult<BaseModel> getPayr0650LeftDataList(ServiceParameters serviceParameters) throws MSFException {
        PagingLoadResult<BaseModel> retval = null;
        String method = CLASS_PAYR0650_LEFT_DATA_LIST;
        Payr0650SrhVO payr0650SrhVO = new Payr0650SrhVO();
        Payr0650VO payr0650VO = new Payr0650VO();
        List<BaseModel> bmResult = new ArrayList();
      
        try {
        	
        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
            String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());
          
        	payr0650DAO = (Payr0650DAO)BeanFinder.getBean("Payr0650DAO");
        	
            ColumnAttribute[] tableAttributes = serviceParameters.getTableAttributes();
            IColumnFilter columnFilters = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders = serviceParameters.getColumnOrders();
            PagingLoadConfig pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            /* Primary Key
               DPOB_CD                        -- 사업장코드
               DIL_WRKR_INCM_BLGG_YR          -- 일용근로소득귀속년도
               DIL_WRKR_INCM_BLGG_QATR_DIV_CD -- 일용근로소득귀속분기구분코드
               DIL_WRKR_INCM_SEIL_NUM         -- 일용근로소득일련번호
               SYSTEMKEY                      -- SYSTEMKEY
               DIL_WRKR_INCM_PYMT_YR_MNTH     -- 일용근로소득지급년월
             */
            payr0650SrhVO.setDpobCd(sessionUser.getDpobCd());

            payr0650SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
            payr0650SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));
            payr0650SrhVO.setDilWrkrIncmBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dilWrkrIncmBlggYr")));
            payr0650SrhVO.setDilWrkrIncmBlggQatrDivCdArr(SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dilWrkrIncmBlggQatrDivCdArr"))));
            payr0650SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));
            payr0650SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"mangeDeptCd")));    //관리부서
            
            
            TimingInfo millisBeginSelectPayr0650List;
            if (pagingValues.executeRecordCount) {
                millisBeginSelectPayr0650List = SmrmfUtils.startTiming(logger);
                int iResultCnt = this.payr0650DAO.selectPayr0650LeftGridTotCnt(payr0650SrhVO);
                SmrmfUtils.endTiming(logger, millisBeginSelectPayr0650List, "QueryCount");
                pagingValues.totalRecordCount = iResultCnt;
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }

            millisBeginSelectPayr0650List = SmrmfUtils.startTiming(logger);
            payr0650SrhVO.setPageSize(pagingValues.totalRecordCount);
            if (pagingValues.start > 0) {
                payr0650SrhVO.setFirstIndex(pagingValues.start);
            }

            if (pagingValues.offsetLimit > 0) {
                payr0650SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }

            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            List list = this.payr0650DAO.selectPayr0650LeftGrid(payr0650SrhVO);
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");

            while(iter.hasNext()) {
                Map<String, Object> map = (Map)iter.next();
                String idValue = map.get("dilWrkrIncmSeilNum").toString();
                BaseModel bm = new BaseModel();

                for(int i = 0; i < tableAttributes.length; ++i) {
                    Object mapCon = map.get(tableAttributes[i].getName());
                    Date baseModelValue;
                    String strValue;
                    switch(tableAttributes[i].getType()) {
                        case 1:
                            strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
                            String rrnDecCrypt = "";
                            if ("resnRegnNum".equals(tableAttributes[i].getName())) {
                                rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult, MSFSharedUtils.allowNulls(strValue).replace("-", ""), AnyCryptUtils.SEC_RRNUMC);
                                strValue = rrnDecCrypt;
                            } else if ("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {
                                rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult, MSFSharedUtils.allowNulls(strValue).replace("-", ""), AnyCryptUtils.SEC_RRNUMC);
                                strValue = rrnDecCrypt;
                            }

                            map.put(tableAttributes[i].getName(), strValue);
                            break;
                        case 2:
                        case 6:
                            baseModelValue = SmrmfUtils.getDateFromString(String.valueOf(mapCon), "yyyyMMdd");
                            map.put(tableAttributes[i].getName(), baseModelValue);
                            break;
                        case 3:
                            if (mapCon != null) {
                                Long lValue = (new BigDecimal(mapCon.toString())).longValue();
                                map.put(tableAttributes[i].getName(), lValue);
                            }
                            break;
                        case 4:
                            if (mapCon != null) {
                                Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue();
                                map.put(tableAttributes[i].getName(), dbValue);
                            }
                        case 5:
                    }

                    baseModelValue = null;
                    Object baseModelVal;
                    if (tableAttributes[i].getName().contains("$")) {
                        strValue = tableAttributes[i].getName().replace("$", "").toLowerCase();
                        map.put(tableAttributes[i].getName(), map.get(strValue));
                        baseModelVal = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    } else {
                        baseModelVal = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    }

                    bm.set(tableAttributes[i].getName(), baseModelVal);
                }

                bm.set("@ID@", idValue);
                bmResult.add(bm);
            }

            retval = new BasePagingLoadResult(bmResult, pagingValues.start, pagingValues.totalRecordCount);
            SmrmfUtils.endTiming(logger, millisBeginSelectPayr0650List, "getPayr0650RightDataList");
            return retval;
        } catch (Exception var27) {
            var27.printStackTrace();
            throw MSFServerUtils.getOperationException(method, var27, logger);
        }
    }

    public PagingLoadResult<BaseModel> getPayr0650RightDataList(ServiceParameters serviceParameters) throws MSFException {
        PagingLoadResult<BaseModel> retval = null;
        String method = CLASS_PAYR0650_RIGHT_DATA_LIST;
        Payr0650SrhVO payr0650SrhVO = new Payr0650SrhVO();
        Payr0650VO payr6000VO = new Payr0650VO();
        List<BaseModel> bmResult = new ArrayList();
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(), RemoteServiceUtil.getThreadLocalRequest());
       
        try {
        	
        	payr0650DAO = (Payr0650DAO)BeanFinder.getBean("Payr0650DAO");
        	
            ColumnAttribute[] tableAttributes = serviceParameters.getTableAttributes();
            IColumnFilter columnFilters = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders = serviceParameters.getColumnOrders();
            PagingLoadConfig pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            payr0650SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));

            TimingInfo millisBeginSelectPayr0650List;
            if (pagingValues.executeRecordCount) {
                millisBeginSelectPayr0650List = SmrmfUtils.startTiming(logger);
                int iResultCnt = this.payr0650DAO.selectPayr0650RightGridTotCnt(payr0650SrhVO);
                SmrmfUtils.endTiming(logger, millisBeginSelectPayr0650List, "QueryCount");
                pagingValues.totalRecordCount = iResultCnt;
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }

            millisBeginSelectPayr0650List = SmrmfUtils.startTiming(logger);
            payr0650SrhVO.setPageSize(pagingValues.totalRecordCount);
            if (pagingValues.start > 0) {
                payr0650SrhVO.setFirstIndex(pagingValues.start);
            }

            if (pagingValues.offsetLimit > 0) {
                payr0650SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
            }

            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            List list = this.payr0650DAO.selectPayr0650RightGrid(payr0650SrhVO);
            Iterator<Map<String, Object>> iter = list.iterator();
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");

            while(iter.hasNext()) {
                Map<String, Object> map = (Map)iter.next();
                String idValue = map.get("dilWrkrIncmSeilNum").toString();
                BaseModel bm = new BaseModel();

                for(int i = 0; i < tableAttributes.length; ++i) {
                    Object mapCon = map.get(tableAttributes[i].getName());
                    Date baseModelValue;
                    String strValue;
                    switch(tableAttributes[i].getType()) {
                        case 1:
                            strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
                            String rrnDecCrypt = "";
                            if ("resnRegnNum".equals(tableAttributes[i].getName())) {
                                rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult, MSFSharedUtils.allowNulls(strValue).replace("-", ""), AnyCryptUtils.SEC_RRNUMC);
                                strValue = rrnDecCrypt;
                            } else if ("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {
                                rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult, MSFSharedUtils.allowNulls(strValue).replace("-", ""), AnyCryptUtils.SEC_RRNUMC);
                                strValue = rrnDecCrypt;
                            }

                            map.put(tableAttributes[i].getName(), strValue);
                            break;
                        case 2:
                        case 6:
                            baseModelValue = SmrmfUtils.getDateFromString(String.valueOf(mapCon), "yyyyMMdd");
                            map.put(tableAttributes[i].getName(), baseModelValue);
                            break;
                        case 3:
                            if (mapCon != null) {
                                Long lValue = (new BigDecimal(mapCon.toString())).longValue();
                                map.put(tableAttributes[i].getName(), lValue);
                            }
                            break;
                        case 4:
                            if (mapCon != null) {
                                Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue();
                                map.put(tableAttributes[i].getName(), dbValue);
                            }
                        case 5:
                    }

                    baseModelValue = null;
                    Object baseModelVal;
                    if (tableAttributes[i].getName().contains("$")) {
                        strValue = tableAttributes[i].getName().replace("$", "").toLowerCase();
                        map.put(tableAttributes[i].getName(), map.get(strValue));
                        baseModelVal = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    } else {
                        baseModelVal = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    }

                    bm.set(tableAttributes[i].getName(), baseModelVal);
                }

                bm.set("@ID@", idValue);
                bmResult.add(bm);
            }

            retval = new BasePagingLoadResult(bmResult, pagingValues.start, pagingValues.totalRecordCount);
            SmrmfUtils.endTiming(logger, millisBeginSelectPayr0650List, "getPayr0650RightDataList");
            return retval;
        } catch (Exception var27) {
            var27.printStackTrace();
            throw MSFServerUtils.getOperationException(method, var27, logger);
        }
    }


    @Override
    public long savePayr4600(Payr0600DTO payr0600DTO, ActionDatabase actionDatabase) throws MSFException{
        List<BaseModel> lsBmResult = new ArrayList();
        Long returnCnt = 1L;
        String method = calledClass + ".savePayr4600";
        String windowNm = "savePayr4600";
        String windowId = "PAYR4600";
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

        try {
            Payr0650DTO payr0650DTO = new Payr0650DTO();

            payr0600DTO.setDpobCd(sessionUser.getDpobCd());
            payr0600DTO.setDilWrkrIncmBlggQatrDivCdArr(SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr0600DTO.getDilWrkrIncmBlggQatrDivCd())));

            payr0650DTO.setDpobCd(sessionUser.getDpobCd());
            //payr0650DTO.setDilWrkrIncmBlggQatrDivCd(payr0600DTO.getDilWrkrIncmBlggQatrDivCd());
            payr0650DTO.setDilWrkrIncmBlggQatrDivCdArr(SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr0600DTO.getDilWrkrIncmBlggQatrDivCd())));
            payr0650DTO.setDilWrkrIncmBlggYr(payr0600DTO.getDilWrkrIncmBlggYr());
            payr0650DTO.setDeptCd(payr0600DTO.getDeptCd());
            payr0650DTO.setBusinCd(payr0600DTO.getBusinCd());
            payr0650DTO.setSystemkey(payr0600DTO.getSystemkey());

            payr0600DTO.setDilWrkrIncmBlggQatrDivCd(null);      //단일삭제용 null 처리

            deletePayr0650ForInsert(payr0650DTO);
            deletePayr0600ForInsert(payr0600DTO);
            insertPayr0600MultipleRow(payr0600DTO);
            insertPayr0650MultipleRow(payr0650DTO);

        } catch (Exception var22) {
            logger.error("EXCEPTION calling Payr4600ServiceImpl.savePayr4600(): " + var22);
            var22.printStackTrace();
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, actionDatabase.toString(), var22, windowNm, windowId);

        }
        MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
        return returnCnt;
    }

    @Override
    public long deletePayr4600(List<Payr0650DTO> payr0650DTOList, ActionDatabase actionDatabase) {
        List<BaseModel> lsBmResult = new ArrayList();
        Long returnCnt = 1L;
        String method = calledClass + ".deletePayr4600";
        String windowNm = "deletePayr4600";
        String windowId = "PAYR4600";
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

        List<Payr0600DTO> payr0600DTOList = new ArrayList();
        Payr0600DTO payr0600DTO;
        Payr0650DTO row0650;
        boolean addRow = true;

        try {
            for(int i = 0; i < payr0650DTOList.size() ; i++){
                row0650 = payr0650DTOList.get(i);
                deletePayr0650(row0650);
                if(payr0600DTOList.size() != 0){
                    for(Payr0600DTO compareRow : payr0600DTOList){
                        if(!(row0650.getDpobCd().equals(compareRow.getDpobCd()) &&
                           row0650.getDilWrkrIncmBlggYr().equals(compareRow.getDilWrkrIncmBlggYr()) &&
                           row0650.getDilWrkrIncmBlggQatrDivCd().equals(compareRow.getDilWrkrIncmBlggQatrDivCd()) &&
                           row0650.getDilWrkrIncmSeilNum().equals(compareRow.getDilWrkrIncmSeilNum())
                            )){
                            addRow = true;
                        }else{
                            addRow = false;
                        }
                    }
                }
                if(addRow){
                    payr0600DTO = new Payr0600DTO();
                    payr0600DTO.setDpobCd(row0650.getDpobCd());
                    payr0600DTO.setDilWrkrIncmBlggYr(row0650.getDilWrkrIncmBlggYr());
                    payr0600DTO.setDilWrkrIncmBlggQatrDivCd(row0650.getDilWrkrIncmBlggQatrDivCd());
                    payr0600DTO.setDilWrkrIncmSeilNum(row0650.getDilWrkrIncmSeilNum());

                    payr0600DTOList.add(payr0600DTO);
                }
            }

            if(payr0600DTOList.size() != 0) {
                for(Payr0600DTO row0600 : payr0600DTOList){
                    updatePayr0600(row0600);
                }
            }


        } catch (Exception var22) {
            logger.error("EXCEPTION calling Payr4600ServiceImpl.deletePayr4600(): " + var22);
            var22.printStackTrace();
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, actionDatabase.toString(), var22, windowNm, windowId);
            returnCnt = 0L;
        }
        MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
        return returnCnt;
    }



    @Override
    public long savePayr0600PentrInfo(Payr0600DTO payr0600DTO, ActionDatabase actionDatabase) throws MSFException{
        List<BaseModel> lsBmResult = new ArrayList();
        Long returnCnt = 1L;
        String method = calledClass + ".savePayr0600PentrInfo";
        String windowNm = "savePayr0600PentrInfo";
        String windowId = "PAYR4600";
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

        try {

            payr0600DTO.setDilWrkrIncmBlggQatrDivCdArr(SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(payr0600DTO.getDilWrkrIncmBlggQatrDivCd())));

            updatePayr0600PentrInfo(payr0600DTO);

        } catch (Exception var22) {
            logger.error("EXCEPTION calling Payr4600ServiceImpl.savePayr0600PentrInfo(): " + var22);
            var22.printStackTrace();
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method, calledClass, actionDatabase.toString(), var22, windowNm, windowId);
        }
        MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
        return returnCnt;
    }



    public int deletePayr0650ForInsert(Payr0650DTO payr0650DTO)  throws Exception{
        return payr0650DAO.deletePayr0650ForInsert(payr0650DTO);
    }

    public int deletePayr0600ForInsert(Payr0600DTO payr0600DTO) throws Exception{
        return payr0600DAO.deletePayr0600ForInsert(payr0600DTO);
    }

    public String insertPayr0600MultipleRow(Payr0600DTO payr0600DTO)  throws Exception{
        return payr0600DAO.insertPayr0600MultipleRow(payr0600DTO);
    }

    public String insertPayr0650MultipleRow(Payr0650DTO payr0650DTO)  throws Exception{
        return payr0650DAO.insertPayr0650MultipleRow(payr0650DTO);
    }

    public int deletePayr0650(Payr0650DTO payr0650DTO) throws Exception {
        return payr0650DAO.deletePayr0650(payr0650DTO);
    }

    public int updatePayr0600(Payr0600DTO payr0600DTO) throws Exception{
        return payr0600DAO.updatePayr0600(payr0600DTO);
    }

    public int updatePayr0600PentrInfo(Payr0600DTO payr0600DTO) throws Exception{
        return payr0600DAO.updatePayr0600PentrInfo(payr0600DTO);
    }
}
