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
import com.app.exterms.prgm.client.service.PrgmComYetaP0100Service;
import com.app.exterms.prgm.server.service.dao.PrgmComPayr0304DAO;
import com.app.exterms.prgm.server.service.dao.PrgmComPsnl0115DAO;
import com.app.exterms.prgm.server.vo.PrgmComPsnl0100VO;
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
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

/**
 * @Class Name : Psnl0100ServiceImpl.java
 * @Description : Psnl0100 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@Service("PrgmComYetaP0100Service")  
public class PrgmComYetaP0100ServiceImpl extends AbstractCustomServiceImpl implements PrgmComDaoConstants, PrgmComYetaP0100Service{

	private static final Logger logger = LoggerFactory.getLogger(PrgmComYetaP0100ServiceImpl.class);

	public PrgmComYetaP0100ServiceImpl() {

	}

	@Autowired
	@Resource(name="PrgmComPayr0304DAO")
	private PrgmComPayr0304DAO payr0304DAO;


	/**
	 * 연말정산 대상자 선택 멀티건 처리 
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getPrgmComPopupYeta0100Payr0304List(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method =  PRGMCOM_METHOD_POPUP_YETA0100_PAYR0304_List;
		PrgmComSearchVO   sysComSrhVo = new PrgmComSearchVO();
		PrgmComPsnl0100VO sysComPsnl0100Vo = new PrgmComPsnl0100VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		//암호화 추가 처리 함. 
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

//		if  (MSFSharedUtils.paramNull(payr0304DAO)) {
//
//			WebApplicationContext wac = WebApplicationContextUtils.
//					getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//			payr0304DAO = (PrgmComPayr0304DAO) wac.getBean("PrgmComPayr0304DAO" ); 
//		}
		
		payr0304DAO = (PrgmComPayr0304DAO)BeanFinder.getBean("PrgmComPayr0304DAO");
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
			sysComSrhVo.setDpobCd(sessionUser.getDpobCd());  
			sysComSrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));
			sysComSrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
			sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
			sysComSrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
			sysComSrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드  
			sysComSrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
			sysComSrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
			sysComSrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));    //재직상
			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = payr0304DAO.selectYetaP0100ListTotCnt(sysComSrhVo);  

				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
				pagingValues.totalRecordCount = iResultCnt;	       

				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginSelectYetaP0100List = SmrmfUtils.startTiming(logger);

			/**페이지 카운트 처리를 위한 부분 */ 
			sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				sysComSrhVo.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
			}

			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//	              Collection<Map<String, Object>> list  
			List list = payr0304DAO.selectYetaP0100List(sysComSrhVo);

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

			SmrmfUtils.endTiming(logger, millisBeginSelectYetaP0100List, "selectYetaP0100List");


		}
		catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}
	
}
