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
package com.app.exterms.insurance.server.service;

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

import com.app.exterms.insurance.client.dto.Insr3300DTO;
import com.app.exterms.insurance.client.service.Insr4200Service;
import com.app.exterms.insurance.server.service.dao.Insr3200DAO;
import com.app.exterms.insurance.server.service.dao.Insr3300DAO;
import com.app.exterms.insurance.server.vo.Insr3200SrhVO;
import com.app.exterms.insurance.server.vo.Insr3200VO;
import com.app.exterms.insurance.server.vo.Insr3300VO;
import com.app.exterms.insurance.shared.InsrDaoConstants;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
@Service("Insr4200Service")
public class Insr4200ServiceImpl extends AbstractCustomServiceImpl implements Insr4200Service, InsrDaoConstants {
	private static final Logger logger = LoggerFactory.getLogger(Insr4200ServiceImpl.class);
	private static final String calledClass = Insr4200ServiceImpl.class.getName();
	
	@Autowired
	@Resource(name = "Insr3200DAO")
	private Insr3200DAO insr3200DAO;
	
	@Autowired
	@Resource(name = "Insr3300DAO")
	private Insr3300DAO insr3300DAO;

	public PagingLoadResult<BaseModel> getInsr4200ToInsr3200DataList(ServiceParameters serviceParameters) throws MSFException {
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_INSR4200TOINSR3200_DAO_LIST;
		Insr3200SrhVO insr3200SrhVO = new Insr3200SrhVO();
		Insr3200VO insr3200VO = new Insr3200VO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if(MSFSharedUtils.paramNull(insr3200DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
			insr3200DAO = (Insr3200DAO)wac.getBean("Insr3200DAO" );
		}
		
		try {
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
			PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
			
			/* Get paging configuration */
			PagingValues pagingValues		   = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

			/* Get query parameters */
			List<String> listDeptCd = new ArrayList<String>();
			
			/** 조건절 */
			insr3200SrhVO.setDpobCd(sessionUser.getDpobCd());																		/* 사업장코드			*/
			insr3200SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());														/* 단위기관담당자여부	*/
			insr3200SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")));	// 관리부서													/* 단위기관담당자여부	*/
			insr3200SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")));       //호봉제 구분
			insr3200SrhVO.setNofctYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nofctYrMnth")));	/* 지급년월			*/
			insr3200SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));		/* 고용구분코드		*/
			insr3200SrhVO.setUsrId(sessionUser.getUsrId());  
			insr3200SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));	/* 권한처리	*/
			insr3200SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));
			/******************************** 권한 ************************************************************************/
			
			String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
			if("FALSE".equals(chkDeptCd)) {
				insr3200SrhVO.setDeptCd(sessionUser.getDeptCd());
				listDeptCd.add(sessionUser.getDeptCd());
				insr3200SrhVO.setDeptCdArr(listDeptCd);		/* 부서코드	*/
				insr3200SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
			} else {
				insr3200SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));	/* 단위기관코드	*/
				if(insr3200SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
					listDeptCd = null;
					insr3200SrhVO.setDeptCdArr(listDeptCd);	/* 부서코드	*/
					insr3200SrhVO.setDeptCd("");			/* 부서코드	*/
				} else {
					insr3200SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
					listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
					insr3200SrhVO.setDeptCdArr(listDeptCd);	/* 부서코드	*/
				} 
			}
			/******************************** 권한 ************************************************************************/
			List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
			insr3200SrhVO.setTypOccuCdArr(lstTypeOccuCd);
			insr3200SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));	/* 직종	*/
			
			List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
			insr3200SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);
			insr3200SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));	/* 호봉등급코드	*/
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));
			insr3200SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);
			insr3200SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));	/* 직종세	*/
			
			insr3200SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));	/* 사업코드	*/
			
			insr3200SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));	/* 시스템키	*/
			insr3200SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));			/* 한글성명	*/
			
			List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));
			insr3200SrhVO.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
			insr3200SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));	/* 재직상태	*/
			
			/* Get total record count 전체 데이터 수 */
			if(pagingValues.executeRecordCount) {
				/* Execute query that returns a single value */
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				
				///////////////////////////////
				// 월별 건강보험대사 건수 조회 하기 
				int iResultCnt = insr3200DAO.selectInsr3200ListTotCnt(insr3200SrhVO);
				
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
				
				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if(!pagingValues.pageExecute) {
					pagingValues.offsetLimit = iResultCnt;
				}
				
				pagingValues.totalRecordCount = iResultCnt;
				
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
			TimingInfo millisBeginInsr4200ToInsr3200DataList = SmrmfUtils.startTiming(logger);
			
			/**페이지 카운트 처리 */
			insr3200SrhVO.setPageSize(pagingValues.totalRecordCount);
			
			/* Apply paging */
			if(pagingValues.start > 0) {
				insr3200SrhVO.setFirstIndex(pagingValues.start);
			}
			if(pagingValues.offsetLimit > 0) {
				insr3200SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			
			/* Execute query and convert to BaseModel list */
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			
			///////////////////////////////
			// 월별 건강보험대사 조회 하기 
			@SuppressWarnings("unchecked")
//			Collection<Map<String, Object>> list ??????
			List list = insr3200DAO.selectInsr3200List(insr3200SrhVO);
			
			Iterator<Map<String, Object>> iter = list.iterator();
			
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
			
			while(iter.hasNext()) {
				Map<String, Object> map = (Map<String, Object>)iter.next();
				String idValue = map.get("systemkey").toString();
				BaseModel bm = new BaseModel();
				
//				bm.setProperties(map);
				for(int i = 0; i < tableAttributes.length; i++) {
					Object mapCon = map.get(tableAttributes[i].getName());
					switch(tableAttributes[i].getType()) {
					case ColumnDef.TYPE_STRING: 
						String strValue = String.valueOf(mapCon);
						if("resnRegnNum".equals(tableAttributes[i].getName())) {
							// TODO 주민번호		
							strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						}
						map.put(tableAttributes[i].getName(), strValue);
						break;
						case ColumnDef.TYPE_DATE:
						case ColumnDef.TYPE_DATETIME:
							Date value = SmrmfUtils.getDateFromString(String.valueOf(mapCon), "yyyyMMdd");
							map.put(tableAttributes[i].getName(), value);
							break;
						case ColumnDef.TYPE_LONG:
							if(mapCon != null) {
								Long lValue = (new BigDecimal(mapCon.toString())).longValue();
								map.put(tableAttributes[i].getName(), lValue);
							}
							break;
						case ColumnDef.TYPE_DOUBLE:
							if(mapCon != null) {
								Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue();
								map.put(tableAttributes[i].getName(), dbValue);
							}
							break;
					}
					Object baseModelValue = null;
					/* 콤보박스처리를 위해 추가 */
					if(tableAttributes[i].getName().contains("$")) {
						String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
						map.put(tableAttributes[i].getName(),map.get(strMapCon));
						
						baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(  map.get(tableAttributes[i].getName())
																						   , tableAttributes[i].getType()
																						  );
					} else {
						baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(  map.get(tableAttributes[i].getName())
																						   , tableAttributes[i].getType()
																						  );
					}
					bm.set(tableAttributes[i].getName(), baseModelValue);
				}
				bm.set(TableDef.ID_PROPERTY_NAME, idValue);
				bmResult.add(bm);
			}
			retval = new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);
			
			SmrmfUtils.endTiming(logger, millisBeginInsr4200ToInsr3200DataList, "getInsr4200ToInsr3200DataList");
		} catch (Exception ex) {
			ex.printStackTrace();
			/* Return operation exception */
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	/* */
	public PagingLoadResult<BaseModel> getInsrP420001ToInsr3200DataList(ServiceParameters serviceParameters) throws MSFException {
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_INSRP420001TOINSR3200_DAO_LIST;
		Insr3200SrhVO insr3200SrhVO = new Insr3200SrhVO();
		Insr3200VO insr3200VO = new Insr3200VO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		if(MSFSharedUtils.paramNull(insr3200DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
			insr3200DAO = (Insr3200DAO)wac.getBean("Insr3200DAO" );
		}
		
		try {
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
			PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
			
			/* Get paging configuration */
			PagingValues pagingValues		   = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

			/* Get query parameters */
			List<String> listDeptCd = new ArrayList<String>();
			
			/** 조건절 */
			insr3200SrhVO.setDpobCd(sessionUser.getDpobCd());																		/* 사업장코드			*/
			insr3200SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());														/* 단위기관담당자여부	*/
			//insr3200SrhVO.setNofctYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth")));	/* 지급년월			*/
			
			insr3200SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth")));	/* 지급년월			*/
			
			insr3200SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));		/* 고용구분코드		*/
			insr3200SrhVO.setUsrId(sessionUser.getUsrId());  
			insr3200SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));	/* 권한처리	*/
			insr3200SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));
			/******************************** 권한 ************************************************************************/
			
			String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
			if("FALSE".equals(chkDeptCd)) {
				insr3200SrhVO.setDeptCd(sessionUser.getDeptCd());
				listDeptCd.add(sessionUser.getDeptCd());
				insr3200SrhVO.setDeptCdArr(listDeptCd);		/* 부서코드	*/
				insr3200SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
			} else {
				insr3200SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));	/* 단위기관코드	*/
				if(insr3200SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
					listDeptCd = null;
					insr3200SrhVO.setDeptCdArr(listDeptCd);	/* 부서코드	*/
					insr3200SrhVO.setDeptCd("");			/* 부서코드	*/
				} else {
					insr3200SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
					listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
					insr3200SrhVO.setDeptCdArr(listDeptCd);	/* 부서코드	*/
				} 
			}
			/******************************** 권한 ************************************************************************/
			List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
			insr3200SrhVO.setTypOccuCdArr(lstTypeOccuCd);
			insr3200SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));	/* 직종	*/
			
			List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
			insr3200SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);
			insr3200SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));	/* 호봉등급코드	*/
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsDivCd")));
			insr3200SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);
			insr3200SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsDivCd")));	/* 직종세	*/
			
			insr3200SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));	/* 사업코드	*/
			
			insr3200SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));	/* 시스템키	*/
			insr3200SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));			/* 한글성명	*/
			
			List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));
			insr3200SrhVO.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
			insr3200SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));	/* 재직상태	*/
			
			/* Get total record count 전체 데이터 수 */
			if(pagingValues.executeRecordCount) {
				/* Execute query that returns a single value */
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				
				int iResultCnt = insr3200DAO.selectInsrP420001ToInsr3200ListTotCnt(insr3200SrhVO);
				
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
				
				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if(!pagingValues.pageExecute) {
					pagingValues.offsetLimit = iResultCnt;
				}
				
				pagingValues.totalRecordCount = iResultCnt;
				
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
			TimingInfo millisBeginInsr4200ToInsr3200DataList = SmrmfUtils.startTiming(logger);
			
			/**페이지 카운트 처리 */
			insr3200SrhVO.setPageSize(pagingValues.totalRecordCount);
			
			/* Apply paging */
			if(pagingValues.start > 0) {
				insr3200SrhVO.setFirstIndex(pagingValues.start);
			}
			if(pagingValues.offsetLimit > 0) {
				insr3200SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			
			/* Execute query and convert to BaseModel list */
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			
			@SuppressWarnings("unchecked")
//			Collection<Map<String, Object>> list ??????
			List list = insr3200DAO.selectInsrP420001ToInsr3200List(insr3200SrhVO);
			
			Iterator<Map<String, Object>> iter = list.iterator();
			
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
			
			while(iter.hasNext()) {
				Map<String, Object> map = (Map<String, Object>)iter.next();
				String idValue = map.get("systemkey").toString();
				BaseModel bm = new BaseModel();
				
//				bm.setProperties(map);
				for(int i = 0; i < tableAttributes.length; i++) {
					Object mapCon = map.get(tableAttributes[i].getName());
					switch(tableAttributes[i].getType()) {
					case ColumnDef.TYPE_STRING: 
						String strValue = String.valueOf(mapCon);
						if("resnRegnNum".equals(tableAttributes[i].getName())) {
							// TODO 주민번호		
							strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						}
						map.put(tableAttributes[i].getName(), strValue);
						break;
						case ColumnDef.TYPE_DATE:
						case ColumnDef.TYPE_DATETIME:
							Date value = SmrmfUtils.getDateFromString(String.valueOf(mapCon), "yyyyMMdd");
							map.put(tableAttributes[i].getName(), value);
							break;
						case ColumnDef.TYPE_LONG:
							if(mapCon != null) {
								Long lValue = (new BigDecimal(mapCon.toString())).longValue();
								map.put(tableAttributes[i].getName(), lValue);
							}
							break;
						case ColumnDef.TYPE_DOUBLE:
							if(mapCon != null) {
								Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue();
								map.put(tableAttributes[i].getName(), dbValue);
							}
							break;
					}
					Object baseModelValue = null;
					/* 콤보박스처리를 위해 추가 */
					if(tableAttributes[i].getName().contains("$")) {
						String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
						map.put(tableAttributes[i].getName(),map.get(strMapCon));
						
						baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(  map.get(tableAttributes[i].getName())
																						   , tableAttributes[i].getType()
																						  );
					} else {
						baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(  map.get(tableAttributes[i].getName())
																						   , tableAttributes[i].getType()
																						  );
					}
					bm.set(tableAttributes[i].getName(), baseModelValue);
				}
				bm.set(TableDef.ID_PROPERTY_NAME, idValue);
				bmResult.add(bm);
			}
			retval = new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);
			
			SmrmfUtils.endTiming(logger, millisBeginInsr4200ToInsr3200DataList, "getInsr4200ToInsr3200DataList");
		} catch (Exception ex) {
			ex.printStackTrace();
			/* Return operation exception */
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	/* 당/차월 급여 반영 */
	@Override
	public Long activityOnInsr3300(List<Insr3300DTO> listInsr3300dto, ActionDatabase actionDatabase) throws MSFException {
		Long result	= new Long(0);
		Long iCnt	= new Long(0);
		
        int colseCnt = 0;
        int breakCnt = 0;
        
        String payGubn = "";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		try {
			if(MSFSharedUtils.paramNull(insr3300DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().
																										getSession().
																										getServletContext()
																									   );
				insr3300DAO = (Insr3300DAO)wac.getBean("insr3300DAO");
			}
			
			for(int iPsnlCnt = 0; iPsnlCnt < listInsr3300dto.size(); iPsnlCnt++) {
				Insr3300DTO insr3300dto = new Insr3300DTO();
				insr3300dto = listInsr3300dto.get(iPsnlCnt);
				Insr3300VO insr3300Vo = new Insr3300VO();
				Insr3200VO insr3200Vo = new Insr3200VO();
				
				insr3300Vo.setDpobCd(		   insr3300dto.getDpobCd());							/** column 사업장코드			: dpobCd			*/
				insr3300Vo.setSystemkey(	   insr3300dto.getSystemkey());							/** column SYSTEMKEY		: systemkey			*/
				insr3300Vo.setNofctYrMnth(	   insr3300dto.getNofctYrMnth());						/** column 고지년월			: nofctYrMnth		*/
				insr3300Vo.setNofctDspty((Long)insr3300dto.getNofctDspty());						/** column 고지차수			: nofctDspty		*/
				insr3300Vo.setDducYrMnth(	   insr3300dto.getDducYrMnth());						/** column 공제년월			: dducyrMnth		*/
				insr3300Vo.setHlthInsrPrmmSrd(	   insr3300dto.getHlthInsrPrmmSrd());				/** column 건강보험보험료차액 : hlthInsrPrmmSrd		*/
				insr3300Vo.setLgtmRcptnInsurSrd(	   insr3300dto.getLgtmRcptnInsurSrd());			/** column 장기요양보험차액 : lgtmRcptnInsurSrd		*/
				insr3300Vo.setSrdAggrSum(	   insr3300dto.getSrdAggrSum());						/** column 차액합계 : srdAggrSum 		*/
				insr3300Vo.setHlthInsrPrcsDt(  insr3300dto.getHlthInsrPrcsDt());					/** column 건강보험처리일자	: hlthInsrPrcsDt	*/
				insr3300Vo.setHlthInsrPrcsYn(  insr3300dto.getHlthInsrPrcsYn());					/** column 건강보험처리여부	: hlthInsrPrcsYn	*/
				insr3300Vo.setIsmt(			   sessionUser.getUsrId());								/** column 수정자			: ismt				*/
				insr3300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 수정주소			: revnAddr			*/
				
				
				colseCnt = insr3300DAO.selectPayCloseChkCnt(insr3300Vo); 
				
	          	  
	          	  if( (colseCnt <=0 &&  "pay".equals(insr3300dto.getDducYrMnth())) || (colseCnt >0 && "this".equals(insr3300dto.getDducYrMnth()))){	  
	        		  payGubn = insr3300dto.getDducYrMnth();
	        		  breakCnt = breakCnt+1;
	        		  break;
	        	  }
				
				insr3300DAO.updatePayRflctnInsr3300(insr3300Vo);
				

				
				
				insr3200Vo.setDpobCd(		   insr3300dto.getDpobCd());							/** column 사업장코드			: dpobCd			*/
				insr3200Vo.setSystemkey(	   insr3300dto.getSystemkey());							/** column SYSTEMKEY		: systemkey			*/
				insr3200Vo.setNofctYrMnth(	   insr3300dto.getNofctYrMnth());						/** column 고지년월			: nofctYrMnth		*/
				insr3200Vo.setNofctDspty((Long)insr3300dto.getNofctDspty());						/** column 고지차수			: nofctDspty		*/
				insr3200Vo.setDducYrMnth(	   insr3300dto.getDducYrMnth());						/** column 공제년월			: dducyrMnth		*/
				insr3200Vo.setPayCalcHlthInsrSum(      insr3300dto.getCalcPrmm()                  ); /** column 급여산출건강보험금액 : payCalcHlthInsrSum */
				insr3200Vo.setPayCalcRcptnInsurSum(      insr3300dto.getLgtmRcptnCalcPrmm()                 );	/** set 급여산출요양보험금액 : payCalcRcptnInsurSum */		
				insr3300Vo.setIsmt(			   sessionUser.getUsrId());								/** column 수정자			: ismt				*/
				insr3300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 수정주소			: revnAddr			*/
				
				if("pay".equals(insr3300dto.getDducYrMnth())){
					insr3200DAO.updatePayCalcInsr3200(insr3200Vo);	
				}
				
				iCnt = iCnt + 1;
			}
			
        	if(breakCnt>0 && "pay".equals(payGubn) ){
        		result = -99L ;
        	}else if(breakCnt>0 && "this".equals(payGubn) ){
        	
        		result = -88L ;
    		}else{
        		result = iCnt;
        	}
		} catch(Exception ex) {
			logger.error("EXCEPTION calling activityOnInsr3300(): " + ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnPsnl0126", ex, logger);
		} finally {
			
		}
		return result;
	}
}