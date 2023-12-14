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
import com.app.exterms.payroll.client.dto.Payr0417DTO;
import com.app.exterms.payroll.client.service.PayrP525003Service;
import com.app.exterms.payroll.server.service.dao.Payr0416DAO;
import com.app.exterms.payroll.server.service.dao.Payr0417DAO;
import com.app.exterms.payroll.server.vo.Payr0416SrhVO;
import com.app.exterms.payroll.server.vo.Payr0416VO;
import com.app.exterms.payroll.server.vo.Payr0417SrhVO;
import com.app.exterms.payroll.server.vo.Payr0417VO;
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

@Service("PayrP525003Service")
public class PayrP525003ServiceImpl extends AbstractCustomServiceImpl implements PayrP525003Service, PayrDaoConstants{

	private static final Logger logger = LoggerFactory.getLogger(PayrP525003ServiceImpl.class);
	private static final String calledClass = PayrP525003ServiceImpl.class.getName();

	@Autowired
	@Resource(name = "Payr0416DAO")
	private Payr0416DAO payr0416DAO;
	
	@Autowired
	@Resource(name="Payr0417DAO")
	private Payr0417DAO payr0417DAO;

	public PagingLoadResult<BaseModel> getPayrP52003ToPayr0417DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR525003_PAYR0417_DATA_LIST;
        Payr0417SrhVO   payr0417SrhVO = new Payr0417SrhVO();
        Payr0416SrhVO   payr0416SrhVO = new Payr0416SrhVO();
        Payr0416VO      payr0416VO = new Payr0416VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
 
        try {
        	
        	payr0416DAO = (Payr0416DAO)BeanFinder.getBean("Payr0416DAO");
        	payr0417DAO = (Payr0417DAO)BeanFinder.getBean("Payr0417DAO");
        	
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0400BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            
            payr0416SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0416SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
            payr0416SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
            payr0416SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));
            
            payr0416VO = payr0416DAO.selectPayrP525003ToPayr0416PayYrList(payr0416SrhVO);
            
            /** 조건절 */
            payr0417SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0417SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
            payr0417SrhVO.setDtilOccuDlySeilNum(payr0416VO.getDtilOccuDlySeilNum());
            payr0417SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));  
            payr0417SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd"))); //급여구분코드
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0417DAO.selectPayrP525003ToPayr0417ListTotCnt(payr0417SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                      
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;
                
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0417DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0417SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0417SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0417SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));       
            }            
           
            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0417DAO.selectPayrP525003ToPayr0417List(payr0417SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payCd").toString();
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
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    
                    if("transferYn".equals(tableAttributes[i].getName())){
                    	if(null == baseModelValue){
                    		baseModelValue = "N";
                    	}
                    }
                    
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0417DataList, "getPayr0417DataList");
       

		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}

	@Override
	public int copyPkgUnitPriceItemsPayrP525003(	List<Payr0417DTO> listPayr0417Dto) throws MSFException {

		String method = calledClass + ".copyPkgUnitPriceItemsPayrP525003";
		String windowNm = "무기계약(일용) 단가항목 복사";
		String windowId = "PAYRP525003";

		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		Payr0417VO payr0417Vo = new Payr0417VO();
		int result = 0;

		try {

			for (int iBassCnt = 0; iBassCnt < listPayr0417Dto.size(); iBassCnt++) {

				/** 기본 직종의 데이터 가져온다 */
				Payr0417DTO payr0417Dto = new Payr0417DTO();
				payr0417Dto = listPayr0417Dto.get(iBassCnt);

				payr0417Vo.setDpobCd(payr0417Dto.getDpobCd());    										/** column 사업장코드 : dpobCd */
				payr0417Vo.setPayYr(payr0417Dto.getPayYr());    											/** column 급여년도 : payYr */
				payr0417Vo.setItemDlySeilNum(new BigDecimal(payr0417Dto.getItemDlySeilNum()));
				payr0417Vo.setDtilOccuDlySeilNum(new BigDecimal(payr0417Dto.getDtilOccuDlySeilNum()));
				payr0417Vo.setPayrMangDeptCd(payr0417Dto.getPayrMangDeptCd());    		/** column 급여관리부서코드 : payrMangDeptCd */
				
				payr0417Vo.setPayrImcd(payr0417Dto.getPayrImcd());    		/** column 급여항목코드 : payrImCd */				
				payr0417Vo.setItemNm(payr0417Dto.getItemNm());    		/** column 항목명 : itemNm */
				payr0417Vo.setPayCd(payr0417Dto.getPayCd());    											/** column 급여구분코드 : payCd */
				payr0417Vo.setPymtDducDivCd(payr0417Dto.getPymtDducDivCd());	/** column 지급공제구분코드 : pymtDducDivCd */
				payr0417Vo.setPymtDducFrmCd(payr0417Dto.getPymtDducFrmCd());    										/** column 지급공제유형코드 : pymtDducFrmCd */
				
				payr0417Vo.setPymtDducRate(new BigDecimal(payr0417Dto.getPymtDducRate()));	/** column 지급공제율 : pymtDducRate */
				payr0417Vo.setPymtDducSum(new BigDecimal(payr0417Dto.getPymtDducSum()));	/** column 지급공제액 : pymtDducSum */
				payr0417Vo.setTxtnDivCd(payr0417Dto.getTxtnDivCd());    												/** column 과세구분코드 : txtnDivCd */
				payr0417Vo.setFreeDtyRate(new BigDecimal(payr0417Dto.getFreeDtyRate()));   	 													/** column 비과세율 : freeDtyRate */
				payr0417Vo.setFreeDtySum(new BigDecimal(payr0417Dto.getFreeDtySum()));    														/** column 비과세금액 : freeDtySum */
				
				payr0417Vo.setJan(payr0417Dto.getJan());    /** column 1월 : jan */
				payr0417Vo.setFeb(payr0417Dto.getFeb());    /** column 2월 : feb */
				payr0417Vo.setMar(payr0417Dto.getMar());    /** column 3월 : mar */
				payr0417Vo.setApr(payr0417Dto.getApr());    /** column 4월 : apr */
				payr0417Vo.setMay(payr0417Dto.getMay());    /** column 5월 : may */
				
				payr0417Vo.setJun(payr0417Dto.getJun());    /** column 6월 : jun */
				payr0417Vo.setJul(payr0417Dto.getJul());    /** column 7월 : jul */
				payr0417Vo.setAug(payr0417Dto.getAug());    /** column 8월 : aug */
				payr0417Vo.setSep(payr0417Dto.getSep());    /** column 9월 : sep */
				payr0417Vo.setOct(payr0417Dto.getOct());    /** column 10월 : oct */
				
				payr0417Vo.setNov(payr0417Dto.getNov());    /** column 11월 : nov */
				payr0417Vo.setDec(payr0417Dto.getDec());    /** column 12월 : dec */		
				payr0417Vo.setRngeOrd(new BigDecimal(payr0417Dto.getRngeOrd()));   											/** column 정렬순서 : rngeOrd */
				payr0417Vo.setSumOhrItemApptnYn(payr0417Dto.getSumOhrItemApptnYn());
				payr0417Vo.setPayItemUseYn(payr0417Dto.getPayItemUseYn());    													/** column 급여항목사용여부 : payItemUseYn */
				
				payr0417Vo.setItemApptnBgnnDt(payr0417Dto.getItemApptnBgnnDt());    					/** column 항목적용시작일자 : itemApptnBgnnDt */
				payr0417Vo.setItemApptnEndDt(payr0417Dto.getItemApptnEndDt());    					/** column 항목적용종료일자 : itemApptnEndDt */
				payr0417Vo.setDayMnthAmntDivCd(payr0417Dto.getDayMnthAmntDivCd());    				/** column 일월액구분코드 : dayMnthAmntDivCd */
				payr0417Vo.setCalcStdDivCd(payr0417Dto.getCalcStdDivCd());    						/** column 계산기준구분코드 : calcStdDivCd */
				payr0417Vo.setCalcStdFunc(payr0417Dto.getCalcStdFunc());
				
				payr0417Vo.setEmymtDivCd(payr0417Dto.getEmymtDivCd());    							/** column 고용구분코드 : emymtDivCd */
				payr0417Vo.setUsalyAmntYn(payr0417Dto.getUsalyAmntYn());    			/** column 통상임금여부 : usalyAmntYn */
				payr0417Vo.setPayItemNoteCtnt(payr0417Dto.getPayItemNoteCtnt());    					/** column 급여항목비고내용 : payItemNoteCtnt */
				payr0417Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
				payr0417Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
				payr0417Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
				payr0417Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */

				payr0417DAO.insertPayrP525003ToPayr0417(payr0417Vo);

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
