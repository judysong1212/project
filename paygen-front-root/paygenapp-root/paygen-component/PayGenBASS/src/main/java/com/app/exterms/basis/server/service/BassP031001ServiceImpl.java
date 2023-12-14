package com.app.exterms.basis.server.service;

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

import com.app.exterms.basis.client.service.BassP031001Service;
import com.app.exterms.basis.server.service.dao.Psnl2100DAO;
import com.app.exterms.basis.server.vo.Psnl2100SrhVO;
import com.app.exterms.basis.server.vo.Psnl2100VO;
import com.app.exterms.basis.shared.BasisDaoConstants;
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
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("BassP031001Service")
public class BassP031001ServiceImpl extends AbstractCustomServiceImpl implements
		BasisDaoConstants, BassP031001Service {

	private static final Logger logger = LoggerFactory.getLogger(BassP031001ServiceImpl.class);
	private static final String calledClass = BassP031001ServiceImpl.class
			.getName();

	@Autowired
	@Resource(name = "Psnl2100DAO")
	private Psnl2100DAO psnl2100DAO;

	/** ID Generation */
	// @Resource(name="{egovPsnl2100IdGnrService}")
	// private EgovIdGnrService egovIdGnrService;

	public PagingLoadResult<BaseModel> getSelectBass031001ToPsnl2100List(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_BASS0310_PSNL2100_COPY_LIST;
		Psnl2100SrhVO psnl2100SrhVo = new Psnl2100SrhVO();
		Psnl2100VO psnl2100Vo = new Psnl2100VO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		if (MSFSharedUtils.paramNull(psnl2100DAO)) {

			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
							.getSession().getServletContext());

			psnl2100DAO = (Psnl2100DAO) wac.getBean("Psnl2100DAO");
		}

		try {
			// TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가
			// Psnl2100BM user = serviceParameters.getUser();
			ColumnAttribute[] tableAttributes = serviceParameters.getTableAttributes();
			IColumnFilter columnFilters = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders = serviceParameters.getColumnOrders();
			PagingLoadConfig pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			// Get paging configuration
			PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

			/** 조건절 */
			psnl2100SrhVo.setDpobCd(sessionUser.getDpobCd());
			psnl2100SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); // 검색조건처리

			// 페이징
			// Get total record count //전체 데이터 갯수를 가지고 온다.
			if (pagingValues.executeRecordCount) {

				// Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = psnl2100DAO.selectBass031001ToPsnl2100ListTotCnt(psnl2100SrhVo);

				SmrmfUtils.endTiming(logger, millisBeginQueryCount,"QueryCount");

				if (!pagingValues.pageExecute) {
					pagingValues.offsetLimit = iResultCnt;
				}

				pagingValues.totalRecordCount = iResultCnt;

				logger.debug("totalRecordCount : "+ pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginSelectPsnl2100List = SmrmfUtils.startTiming(logger);

			/** 페이지 카운트 처리를 위한 부분 */
			psnl2100SrhVo.setPageSize(pagingValues.totalRecordCount);
			// Apply paging
			if (pagingValues.start > 0) {
				psnl2100SrhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				psnl2100SrhVo.setLastIndex(Math.min(pagingValues.start+ pagingValues.offsetLimit,pagingValues.totalRecordCount));
			}

			// Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			// Collection<Map<String, Object>> list ??????
			List list = psnl2100DAO.selectBass031001ToPsnl2100List(psnl2100SrhVo);

			Iterator<Map<String, Object>> iter = list.iterator();

			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");

			while (iter.hasNext()) {
				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = map.get("typOccuCd").toString();
				BaseModel bm = new BaseModel();

				// bm.setProperties(map);
				for (int i = 0; i < tableAttributes.length; i++) {
					// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					Object mapCon = map.get(tableAttributes[i].getName());

					switch (tableAttributes[i].getType()) {
					case ColumnDef.TYPE_DATE:
					case ColumnDef.TYPE_DATETIME:

						Date value = SmrmfUtils.getDateFromString(String.valueOf(mapCon), "yyyyMMdd");
						map.put(tableAttributes[i].getName(), value);

						break;

					case ColumnDef.TYPE_LONG:

						if (mapCon != null) {
							Long lValue = (new BigDecimal(mapCon.toString())).longValue();
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
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * ++++++++++++++++++++++++++++++
					 */
					Object baseModelValue = null;
					// 콤보박스처리를 위해 추가함
					if (tableAttributes[i].getName().contains("$")) {
						String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();

						map.put(tableAttributes[i].getName(),map.get(strMapCon));

						baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
										map.get(tableAttributes[i].getName()),
										tableAttributes[i].getType());
					} else {
						baseModelValue = MSFSharedUtils
								.convertObjectValueToBaseModelValue(
										map.get(tableAttributes[i].getName()),
										tableAttributes[i].getType());
					}
					/**
					 * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					 * ++++++++++++++++++++++++++++++
					 */
					bm.set(tableAttributes[i].getName(), baseModelValue);
				}

				bm.set(TableDef.ID_PROPERTY_NAME, idValue);
				bmResult.add(bm);
			}

			retval = new BasePagingLoadResult<BaseModel>(bmResult,
					pagingValues.start, pagingValues.totalRecordCount);

			SmrmfUtils.endTiming(logger, millisBeginSelectPsnl2100List,
					"selectPsnl2100List");
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}

}
