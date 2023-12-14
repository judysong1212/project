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
import com.app.exterms.payroll.client.dto.Payr0410DTO;
import com.app.exterms.payroll.client.dto.Payr0410DTO;
import com.app.exterms.payroll.client.service.PayrP150003Service;
import com.app.exterms.payroll.server.service.dao.Payr0410DAO;
import com.app.exterms.payroll.server.vo.Payr0410SrhVO;
import com.app.exterms.payroll.server.vo.Payr0410VO;
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

@Service("PayrP150003Service")
public class PayrP150003ServiceImpl extends AbstractCustomServiceImpl implements PayrP150003Service, PayrDaoConstants{

	private static final Logger logger = LoggerFactory.getLogger(PayrP150003ServiceImpl.class);
	private static final String calledClass = PayrP150003ServiceImpl.class.getName();


	@Autowired
	@Resource(name="Payr0410DAO")
	private Payr0410DAO payr0410DAO;

	public PagingLoadResult<BaseModel> getPayr150003ToPayr0410DataList(ServiceParameters serviceParameters) throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PAYR150003TOPAYR0410_DATA_LIST;
		Payr0410SrhVO   payr0410SrhVO = new Payr0410SrhVO();
		Payr0410VO      payr0410VO = new Payr0410VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();

		// 1. 암호화 객체 생성
		//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		if  (MSFSharedUtils.paramNull(payr0410DAO)) {

			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

			payr0410DAO = (Payr0410DAO) wac.getBean("Payr0410DAO" ); 
		}

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
			payr0410SrhVO.setDpobCd(sessionUser.getDpobCd());
			payr0410SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
			payr0410SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
			payr0410SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
			payr0410SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
			payr0410SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd"))); //급여구분코드

			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 

				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = payr0410DAO.selectPayr150003ToPayr0410ListTotCnt(payr0410SrhVO);  

				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 


				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}
				pagingValues.totalRecordCount = iResultCnt;


				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginPayr0410DataList = SmrmfUtils.startTiming(logger);

			/**페이지 카운트 처리를 위한 부분 */ 
			//payr0410SrhVO.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0) {
				payr0410SrhVO.setFirstIndex(pagingValues.start);
			}

			if (pagingValues.offsetLimit > 0) {
				payr0410SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));   
			}

			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);

			@SuppressWarnings("unchecked")
			//            Collection<Map<String, Object>> list ??????
			List list = payr0410DAO.selectPayr150003ToPayr0410List(payr0410SrhVO);

			Iterator<Map<String, Object>> iter = list.iterator();

			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 

			while ( iter.hasNext() ) {

				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());


				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = map.get("payrImcd").toString();
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

							String rrnDecCrypt = "";

							// 주민번호(복호화)
							rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);

							strValue = rrnDecCrypt;

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

					//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
					Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
							map.get(tableAttributes[i].getName()), tableAttributes[i].getType());

					//                    switch ( tableAttributes[i].getType() ) {  
					//                    case ColumnDef.TYPE_BIGDECIMAL: 
					//                    	if (baseModelValue == null) {
					//                    		baseModelValue = BigDecimal.ZERO;
					//                    	}
					//                        break; 
					//                    }

					bm.set(tableAttributes[i].getName(), baseModelValue);
				}

				bm.set(TableDef.ID_PROPERTY_NAME, idValue);
				bmResult.add(bm);
			} 

			retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  

			SmrmfUtils.endTiming(logger, millisBeginPayr0410DataList, "getPayr0410DataList");


		}
		catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}

	@Override
	public int copyPkgUnitPriceItemsPayrP150003(	List<Payr0410DTO> listPayr0410Dto) throws MSFException {

		String method = calledClass + ".copyPkgUnitPriceItemsPayrP150003";
		String windowNm = "무기계약(호봉) 단가항목 복사";
		String windowId = "PAYRP150003";

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		Payr0410VO payr0410Vo = new Payr0410VO();
		int result = 0;

		try {

			for (int iBassCnt = 0; iBassCnt < listPayr0410Dto.size(); iBassCnt++) {

				/** 기본 직종의 데이터 가져온다 */
				Payr0410DTO payr0410Dto = new Payr0410DTO();
				payr0410Dto = listPayr0410Dto.get(iBassCnt);

				payr0410Vo.setDpobCd(payr0410Dto.getDpobCd());    										/** column 사업장코드 : dpobCd */
				payr0410Vo.setPayYr(payr0410Dto.getPayYr());    											/** column 급여년도 : payYr */
				payr0410Vo.setTypOccuGrdeMppgSeilNum(new BigDecimal(payr0410Dto.getTypOccuGrdeMppgSeilNum()));				
				payr0410Vo.setPayrMangDeptCd(payr0410Dto.getPayrMangDeptCd());    		/** column 급여관리부서코드 : payrMangDeptCd */
				payr0410Vo.setPayrImcd(payr0410Dto.getPayrImcd());    		/** column 급여항목코드 : payrImCd */
				
				payr0410Vo.setItemNm(payr0410Dto.getItemNm());    		/** column 항목명 : itemNm */
				payr0410Vo.setPayCd(payr0410Dto.getPayCd());    											/** column 급여구분코드 : payCd */
				payr0410Vo.setPymtDducDivCd(payr0410Dto.getPymtDducDivCd());	/** column 지급공제구분코드 : pymtDducDivCd */
				payr0410Vo.setPymtDducFrmCd(payr0410Dto.getPymtDducFrmCd());    										/** column 지급공제유형코드 : pymtDducFrmCd */
				payr0410Vo.setPymtDducRate(new BigDecimal(payr0410Dto.getPymtDducRate()));	/** column 지급공제율 : pymtDducRate */
				
				payr0410Vo.setPymtDducSum(new BigDecimal(payr0410Dto.getPymtDducSum()));	/** column 지급공제액 : pymtDducSum */
				payr0410Vo.setTxtnDivCd(payr0410Dto.getTxtnDivCd());    												/** column 과세구분코드 : txtnDivCd */
				payr0410Vo.setFreeDtyRate(new BigDecimal(payr0410Dto.getFreeDtyRate()));   	 													/** column 비과세율 : freeDtyRate */
				payr0410Vo.setFreeDtySum(new BigDecimal(payr0410Dto.getFreeDtySum()));    														/** column 비과세금액 : freeDtySum */
				payr0410Vo.setJan(payr0410Dto.getJan()? "Y" : "N");    /** column 1월 : jan */
				
				payr0410Vo.setFeb(payr0410Dto.getFeb()? "Y" : "N");    /** column 2월 : feb */
				payr0410Vo.setMar(payr0410Dto.getMar()? "Y" : "N");    /** column 3월 : mar */
				payr0410Vo.setApr(payr0410Dto.getApr()? "Y" : "N");    /** column 4월 : apr */
				payr0410Vo.setMay(payr0410Dto.getMay()? "Y" : "N");    /** column 5월 : may */
				payr0410Vo.setJun(payr0410Dto.getJun()? "Y" : "N");    /** column 6월 : jun */
				
				payr0410Vo.setJul(payr0410Dto.getJul()? "Y" : "N");    /** column 7월 : jul */
				payr0410Vo.setAug(payr0410Dto.getAug()? "Y" : "N");    /** column 8월 : aug */
				payr0410Vo.setSep(payr0410Dto.getSep()? "Y" : "N");    /** column 9월 : sep */
				payr0410Vo.setOct(payr0410Dto.getOct()? "Y" : "N");    /** column 10월 : oct */
				payr0410Vo.setNov(payr0410Dto.getNov()? "Y" : "N");    /** column 11월 : nov */
				
				payr0410Vo.setDec(payr0410Dto.getDec()? "Y" : "N");    /** column 12월 : dec */		
				payr0410Vo.setRngeOrd(new BigDecimal(payr0410Dto.getRngeOrd()));   											/** column 정렬순서 : rngeOrd */
				payr0410Vo.setPayItemUseYn(payr0410Dto.getPayItemUseYn()? "Y" : "N");    													/** column 급여항목사용여부 : payItemUseYn */
				payr0410Vo.setItemApptnBgnnDt(payr0410Dto.getItemApptnBgnnDt());    					/** column 항목적용시작일자 : itemApptnBgnnDt */
				payr0410Vo.setItemApptnEndDt(payr0410Dto.getItemApptnEndDt());    					/** column 항목적용종료일자 : itemApptnEndDt */
				
				payr0410Vo.setDayMnthAmntDivCd(payr0410Dto.getDayMnthAmntDivCd());    				/** column 일월액구분코드 : dayMnthAmntDivCd */
				payr0410Vo.setCalcStdDivCd(payr0410Dto.getCalcStdDivCd());    						/** column 계산기준구분코드 : calcStdDivCd */
				payr0410Vo.setCalcStdFunc(payr0410Dto.getCalcStdFunc());
				payr0410Vo.setEmymtDivCd(payr0410Dto.getEmymtDivCd());    							/** column 고용구분코드 : emymtDivCd */
				payr0410Vo.setUsalyAmntYn(payr0410Dto.getUsalyAmntYn()? "Y" : "N");    			/** column 통상임금여부 : usalyAmntYn */
				
				payr0410Vo.setPayItemNoteCtnt(payr0410Dto.getPayItemNoteCtnt());    					/** column 급여항목비고내용 : payItemNoteCtnt */
				payr0410Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
				payr0410Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
				payr0410Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
				payr0410Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */

				payr0410DAO.insertCopyPayr0410(payr0410Vo);

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
