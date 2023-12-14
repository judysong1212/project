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

import com.any.smrmf.utils.BeanFinder;
import com.app.exterms.payroll.client.dto.Payr0490DTO;
import com.app.exterms.payroll.client.service.PayrP530002Service;
import com.app.exterms.payroll.server.service.dao.Payr0490DAO;
import com.app.exterms.payroll.server.vo.Payr0490SrhVO;
import com.app.exterms.payroll.server.vo.Payr0490VO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("PayrP530002Service")
public class PayrP530002ServiceImpl extends AbstractCustomServiceImpl implements PayrP530002Service, PayrDaoConstants{

	private static final Logger logger = LoggerFactory.getLogger(PayrP530002ServiceImpl.class);
	private static final String calledClass = PayrP530002ServiceImpl.class.getName();


	@Autowired
	@Resource(name="Payr0490DAO")
	private Payr0490DAO payr0490DAO;

	public PagingLoadResult<BaseModel> getPayr0490DataList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method =  POPUP_PAYR530002_PAYR0490_DATA_LIST;
		Payr0490SrhVO   payr0490SrhVO = new Payr0490SrhVO();
		Payr0490VO      payr0490VO = new Payr0490VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		// 1. 암호화 객체 생성
		//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		try {

			payr0490DAO = (Payr0490DAO)BeanFinder.getBean("Payr0490DAO");


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
			payr0490SrhVO.setDpobCd(sessionUser.getDpobCd());
			payr0490SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
			payr0490SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));
			payr0490SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
			payr0490SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = payr0490DAO.selectPayr0490ListTotCnt(payr0490SrhVO);  

				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				} 
				pagingValues.totalRecordCount = iResultCnt;	       

				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginPayr0490DataList = SmrmfUtils.startTiming(logger);

			/**페이지 카운트 처리를 위한 부분 */ 
			payr0490SrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				payr0490SrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.totalRecordCount < 100) {
				payr0490SrhVO.setLastIndex(pagingValues.totalRecordCount); 
			} else if (pagingValues.offsetLimit > 0) {
				payr0490SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
			}

			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//            Collection<Map<String, Object>> list ??????
			List list = payr0490DAO.selectPayr0490List(payr0490SrhVO);

			Iterator<Map<String, Object>> iter = list.iterator();

			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 


			while ( iter.hasNext() ) {
				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = map.get("payItemCd").toString();
				BaseModel bm = new BaseModel();

				//bm.setProperties(map);
				for ( int i=0 ; i<tableAttributes.length ; i++ ) {

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

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

						//3. 복호화
					case ColumnDef.TYPE_STRING: 

						String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

						String rrnDecCrypt = "";

						if(	"resnRegnNum".equals(tableAttributes[i].getName())) {


							// 주민번호(복호화)
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

							strValue = rrnDecCrypt;

						}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

							// 주민번호(복호화)
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

							strValue = rrnDecCrypt;

						}

						map.put(tableAttributes[i].getName(), strValue);

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

			SmrmfUtils.endTiming(logger, millisBeginPayr0490DataList, "getPayr0490DataList");


		}
		catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}

	@Override
	public int copyPkgUnitPriceItemsPayrP530002(	List<Payr0490DTO> listPayr0490Dto) throws MSFException {

		String method = calledClass + ".copyPkgHodyNumDysBass031002";
		String windowNm = "휴가일수 일괄 복사";
		String windowId = "BASSP031001";

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		Payr0490VO payr0490Vo = new Payr0490VO();
		int result = 0;

		try {

			for (int iBassCnt = 0; iBassCnt < listPayr0490Dto.size(); iBassCnt++) {

				/** 기본 직종의 데이터 가져온다 */
				Payr0490DTO payr0490Dto = new Payr0490DTO();
				payr0490Dto = listPayr0490Dto.get(iBassCnt);

				payr0490Vo.setDpobCd(payr0490Dto.getDpobCd());    										/** column 사업장코드 : dpobCd */
				payr0490Vo.setPayYr(payr0490Dto.getPayYr());    											/** column 급여년도 : payYr */
				payr0490Vo.setBusinCd(payr0490Dto.getBusinCd());    										/** column 사업코드 : businCd */
				payr0490Vo.setDeptCd(payr0490Dto.getDeptCd()) ;   										/** column 부서코드 : deptCd */
				payr0490Vo.setPayrMangDeptCd(payr0490Dto.getPayrMangDeptCd());    						/** column 급여관리부서코드 : payrMangDeptCd */
				
				payr0490Vo.setPayCd(payr0490Dto.getPayCd());    											/** column 급여구분코드 : payCd */
				payr0490Vo.setPayItemCd(payr0490Dto.getPayItemCd());    		/** column 급여항목코드 : payItemCd */
				payr0490Vo.setItemNm(payr0490Dto.getItemNm());    		/** column 항목명 : itemNm */
				payr0490Vo.setPymtDducDivCd(payr0490Dto.getPymtDducDivCd());	/** column 지급공제구분코드 : pymtDducDivCd */
				payr0490Vo.setPymtDducFrmCd(payr0490Dto.getPymtDducFrmCd());    										/** column 지급공제유형코드 : pymtDducFrmCd */
				
				payr0490Vo.setPymtDducRate(new BigDecimal(payr0490Dto.getPymtDducRate()));	/** column 지급공제율 : pymtDducRate */
				payr0490Vo.setPymtDducSum(new BigDecimal(payr0490Dto.getPymtDducSum()));	/** column 지급공제액 : pymtDducSum */
				payr0490Vo.setTxtnDivCd(payr0490Dto.getTxtnDivCd());    												/** column 과세구분코드 : txtnDivCd */
				payr0490Vo.setFreeDtyRate(new BigDecimal(payr0490Dto.getFreeDtyRate()));   	 													/** column 비과세율 : freeDtyRate */
				payr0490Vo.setFreeDtySum(new BigDecimal(payr0490Dto.getFreeDtySum()));    														/** column 비과세금액 : freeDtySum */

				payr0490Vo.setJan(payr0490Dto.getJan()? "Y" : "N");    /** column 1월 : jan */
				payr0490Vo.setFeb(payr0490Dto.getFeb()? "Y" : "N");    /** column 2월 : feb */
				payr0490Vo.setMar(payr0490Dto.getMar()? "Y" : "N");    /** column 3월 : mar */
				payr0490Vo.setApr(payr0490Dto.getApr()? "Y" : "N");    /** column 4월 : apr */
				payr0490Vo.setMay(payr0490Dto.getMay()? "Y" : "N");    /** column 5월 : may */
				
				payr0490Vo.setJun(payr0490Dto.getJun()? "Y" : "N");    /** column 6월 : jun */
				payr0490Vo.setJul(payr0490Dto.getJul()? "Y" : "N");    /** column 7월 : jul */
				payr0490Vo.setAug(payr0490Dto.getAug()? "Y" : "N");    /** column 8월 : aug */
				payr0490Vo.setSep(payr0490Dto.getSep()? "Y" : "N");    /** column 9월 : sep */
				payr0490Vo.setOct(payr0490Dto.getOct()? "Y" : "N");    /** column 10월 : oct */
				
				payr0490Vo.setNov(payr0490Dto.getNov()? "Y" : "N");    /** column 11월 : nov */
				payr0490Vo.setDec(payr0490Dto.getDec()? "Y" : "N");    /** column 12월 : dec */		
				payr0490Vo.setRngeOrd(new BigDecimal(payr0490Dto.getRngeOrd()));   											/** column 정렬순서 : rngeOrd */
				payr0490Vo.setPayItemUseYn(payr0490Dto.getPayItemUseYn()? "Y" : "N");    													/** column 급여항목사용여부 : payItemUseYn */
				payr0490Vo.setItemApptnBgnnDt(payr0490Dto.getItemApptnBgnnDt());    					/** column 항목적용시작일자 : itemApptnBgnnDt */
				
				payr0490Vo.setItemApptnEndDt(payr0490Dto.getItemApptnEndDt());    					/** column 항목적용종료일자 : itemApptnEndDt */
				payr0490Vo.setDayMnthAmntDivCd(payr0490Dto.getDayMnthAmntDivCd());    				/** column 일월액구분코드 : dayMnthAmntDivCd */
				payr0490Vo.setCalcStdDivCd(payr0490Dto.getCalcStdDivCd());    						/** column 계산기준구분코드 : calcStdDivCd */
				payr0490Vo.setEmymtDivCd(payr0490Dto.getEmymtDivCd());    							/** column 고용구분코드 : emymtDivCd */
				payr0490Vo.setUsalyAmntYn(payr0490Dto.getUsalyAmntYn()? "Y" : "N");    			/** column 통상임금여부 : usalyAmntYn */
				
				payr0490Vo.setPayItemNoteCtnt(payr0490Dto.getPayItemNoteCtnt());    					/** column 급여항목비고내용 : payItemNoteCtnt */
				payr0490Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
				payr0490Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
				payr0490Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
				payr0490Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
				payr0490Vo.setCalcStdFunc(payr0490Dto.getCalcStdFunc());
				
				payr0490DAO.insertCopyPayr0490(payr0490Vo);
				
				result = result + 1;
				/**
				 * 로그반영 CRUDSBLO C:create R:read U:update D:delete S:select B:배치
				 * L:로그인 O:로그아웃
				 */
				MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C");

			}

			/**
			 * 로그반영 CRUDSBLO C:create R:read U:update D:delete S:select B:배치
			 * L:로그인 O:로그아웃
			 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S:C");

		} catch (Exception e) {

			e.printStackTrace();

			/** 에러 로그 **/
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method,
					calledClass, "S:C", e, windowNm, windowId);

			throw MSFServerUtils.getOperationException(this.getClass()	.getName() + " " + "오류 발생 <br> 관리자에게 문의해 주세요.", e,	logger);

		}

		return result;
	}

}
