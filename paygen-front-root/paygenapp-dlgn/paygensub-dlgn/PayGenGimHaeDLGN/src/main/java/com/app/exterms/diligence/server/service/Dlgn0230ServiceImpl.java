package com.app.exterms.diligence.server.service;

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

import com.app.exterms.diligence.client.dto.Dlgn0100DTO;
import com.app.exterms.diligence.client.dto.Dlgn0110DTO;
import com.app.exterms.diligence.client.dto.Dlgn0200DTO;
import com.app.exterms.diligence.client.dto.Dlgn0210DTO;
import com.app.exterms.diligence.client.service.Dlgn0230Service;
import com.app.exterms.diligence.server.service.dao.Dlgn0100DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0110DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0200DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0210DAO;
import com.app.exterms.diligence.server.vo.Dlgn0100SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0100VO;
import com.app.exterms.diligence.server.vo.Dlgn0110SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0200SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0200VO;
import com.app.exterms.diligence.server.vo.Dlgn0210SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0210VO;
import com.app.exterms.diligence.shared.DiligenceDaoConstants;
import com.app.exterms.dlgn.server.utils.DiligenceCommonConstants;
import com.app.exterms.dlgn.server.utils.DlgnServerUtils;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100VO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0200VO;
import com.app.smrmf.pkg.listener.DlgnListenerAdapter;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.ibm.icu.math.BigDecimal;


@Service("dlgn0230Service")
public class Dlgn0230ServiceImpl extends AbstractCustomServiceImpl implements Dlgn0230Service, DiligenceDaoConstants  {
//	extends RemoteServiceDispatcher
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(Dlgn0230ServiceImpl.class);
	private static final String calledClass = Dlgn0230ServiceImpl.class.getName();
	
	private String detailYmKubn = DiligenceCommonConstants.GIMHAE_DLGN_DT_BUNGI;
	
	@Autowired
	@Resource(name="dlgn0100DAO")
	private Dlgn0100DAO dlgn0100DAO;
	
	@Autowired
	@Resource(name="dlgn0110DAO")
	private Dlgn0110DAO dlgn0110DAO;
	@Autowired
	@Resource(name="dlgn0200DAO")
	private Dlgn0200DAO dlgn0200DAO;
	
	@Autowired
	@Resource(name="dlgn0210DAO")
	private Dlgn0210DAO dlgn0210DAO;
	

	
	/** 복무통합관리 근로자정보 조회 **/
	public PagingLoadResult<BaseModel> getDlgn0100MemberList(ServiceParameters serviceParameters) throws MSFException {
		
        PagingLoadResult<BaseModel> retval = null;
//        String method = calledClass + ".getDlgn0100MemberList";
        String windowNm = "복무통합관리";
		String windowId = "DLGN0230";
		
        String method =  CLASS_DLGN0230_MEMBER_LIST;
        Dlgn0100SrhVO   dlgn0100SrhVO = new Dlgn0100SrhVO(); 
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
	      
	      if(MSFSharedUtils.paramNull(dlgn0100DAO)) {
	    	  WebApplicationContext wac = WebApplicationContextUtils.
	                  getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	
	    	  dlgn0100DAO = (Dlgn0100DAO) wac.getBean("dlgn0100DAO"); 
	      }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0470BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
         	List<String> listDeptCd = new ArrayList<String>();   
         	
      		dlgn0100SrhVO.setDpobCd(sessionUser.getDpobCd());																			// 사업장	
    		dlgn0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))); // 단위기관
    		dlgn0100SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));					// 급여구분
    		dlgn0100SrhVO.setDilnlazYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dilnlazYrMnth")));	// 지급년월
    		dlgn0100SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));					// 성명
    		
    		
    		// 2. 파라미터 보낼 때(암호화)
    		dlgn0100SrhVO.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult
    										, MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "resnRegnNum")).replaceAll("-","")
    										, AnyCryptUtils.SEC_RRNUMC));																// 주민번호
    		
    		
    		//아래 권한부분에서 처리
//    		List<String> listDeptCd = SmrmfUtils.getStrToArrayList(dtoParam.getCurrAffnDeptCd());  
//    		dlgn0100SrhVO.setDeptCdArr(listDeptCd);     
//    		dlgn0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));	//부서코드
    			
//    			dlgn0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));	//부서
    		dlgn0100SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));			// 고용구분
    		dlgn0100SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));				// 사업
    			
//    		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(dtoParam.getHdofcCodtnCd());  
//    		dlgn0100SrhVO.setHdofcCodtnCdArr(listHdofcCodtnCd);    
//    		dlgn0100SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(dtoParam.getHdofcCodtnCd()));//재직코드
    			
    		List<String> lstTypOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd"))); 
    		dlgn0100SrhVO.setTypOccuCdArr(lstTypOccuCd);  
    		dlgn0100SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))));				//직종
    			
    		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
    		dlgn0100SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
    		dlgn0100SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")))); 	//직종세
    			
    			
    		dlgn0100SrhVO.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));	//단위기간 담당자 여부
    		dlgn0100SrhVO.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));						//유저 아이디
    		dlgn0100SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", "")); 	 				//	권한처리를위해 추가  
    		dlgn0100SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));
    			         
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	dlgn0100SrhVO.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               dlgn0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
               dlgn0100SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	dlgn0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
                     if (dlgn0100SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	dlgn0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	dlgn0100SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	 dlgn0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          dlgn0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
            }
            
//            } else {
//            	
//            }
            
            dlgn0100SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            dlgn0100SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
    		 /**
             * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
             */
            if (dlgn0100SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0100SrhVO.getDeptCdAuth())) 
        			|| MSFSharedUtils.allowNulls(dlgn0100SrhVO.getDeptCdAuth()).contains(dlgn0100SrhVO.getPayrMangDeptCd())
        			) {
            	
            	dlgn0100SrhVO.setRepbtyBusinDivCd(DlgnServerUtils.getRepbtyBusinData(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()));
              	 
        	}  
            
            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = dlgn0100DAO.selectDlgn0100Cnt(dlgn0100SrhVO);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginDlgn0100DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	dlgn0100SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		dlgn0100SrhVO.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		dlgn0100SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}


            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = dlgn0100DAO.selectDlgn0230List(dlgn0100SrhVO);
            
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginDlgn0100DataList, "getDlgn0100MemberList");
       
        }catch (Exception ex) {
        	
        	ex.printStackTrace();
            //Return operation exception
        	/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
            throw MSFServerUtils.getOperationException(method, ex, logger);
            
        }
        
        MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
        return retval;
    }
	
	

	
	
    /** 복무통합관리 기본근무 조회 **/
	public PagingLoadResult<BaseModel> getDlgn0230ToDlgn0100List(ServiceParameters serviceParameters) throws MSFException {
		
        PagingLoadResult<BaseModel> retval = null;
        String windowNm = "복무통합관리";
		String windowId = "DLGN0230";
		
		String method =  CLASS_DLGN0230_TO_DLGN0100_LIST;
        Dlgn0100SrhVO   dlgn0100SrhVO = new Dlgn0100SrhVO(); 
        Dlgn0110SrhVO   dlgn0110SrhVO = new Dlgn0110SrhVO();
        Dlgn0100VO dlgn0200VO = new Dlgn0100VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
	      if  (MSFSharedUtils.paramNull(dlgn0110DAO)) {
	      
	          WebApplicationContext wac = WebApplicationContextUtils.
	                  getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	
	          dlgn0110DAO = (Dlgn0110DAO) wac.getBean("dlgn0110DAO" ); 
	      }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0470BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
            dlgn0110SrhVO.setDpobCd(sessionUser.getDpobCd());
            dlgn0110SrhVO.setEmymtDivCd(MSFSharedUtils.defaultNulls( MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd"),"")); //고용구분코드
            dlgn0110SrhVO.setDilnlazYrMnth(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailYm"), "")); //근태년월
            dlgn0110SrhVO.setHanNm(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailName"), "")); //성명
            dlgn0110SrhVO.setDilnlazDutyBgnnDt(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailEmymtBgnnDt"), "")); //시작일자
            dlgn0110SrhVO.setDilnlazDutyEndDt(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailEmymtEndDt"), "")); //종료일자
            dlgn0110SrhVO.setSystemkey(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"), "")); //시스템키
            dlgn0110SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  //급여구분코드
//            //Get total record count //전체 데이터 갯수를 가지고 온다.
	         if ( pagingValues.executeRecordCount ) {
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
//                int iResultCnt = 0 ;
                int iResultCnt = dlgn0110DAO.selectDlgn0100ListTotCnt(dlgn0110SrhVO);
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginDlgn0100DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            dlgn0110SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	dlgn0110SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	dlgn0110SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = dlgn0110DAO.selectDlgn0100List(dlgn0110SrhVO);
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
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
            
            SmrmfUtils.endTiming(logger, millisBeginDlgn0100DataList, "getDlgn0100List_01");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
        	/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"s",ex, windowNm , windowId);
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }
        
        MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
        return retval;
    }
	
	
		
	
    /** 복무통합관리 초과근무 조회 **/
	public PagingLoadResult<BaseModel> getDlgn0230ToDlgn0200List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_DLGN0230_TO_DLGN0200_LIST;
        Dlgn0200SrhVO   dlgn0200SrhVO = new Dlgn0200SrhVO(); 
        Dlgn0210SrhVO   dlgn0210SrhVO = new Dlgn0210SrhVO();
        Dlgn0200VO 		dlgn0200VO = new Dlgn0200VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
	      if  (MSFSharedUtils.paramNull(dlgn0210DAO)) {
	      
	          WebApplicationContext wac = WebApplicationContextUtils.
	                  getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
	
	          dlgn0210DAO = (Dlgn0210DAO) wac.getBean("dlgn0210DAO" ); 
	      }
        
        try {
        	
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0470BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
            dlgn0210SrhVO.setDpobCd(sessionUser.getDpobCd());
            dlgn0210SrhVO.setEmymtDivCd(MSFSharedUtils.defaultNulls( MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd"),"")); //고용구분코드
            dlgn0210SrhVO.setDilnlazExceDutyYrMnth(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailYm"), "")); //근태년월
            dlgn0210SrhVO.setHanNm(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailName"), "")); //성명
            dlgn0210SrhVO.setDetailEmymtBgnnDt(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailEmymtBgnnDt"), "")); //시작일자
            dlgn0210SrhVO.setDetailEmymtEndDt(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "detailEmymtEndDt"), "")); //시작일자
            dlgn0210SrhVO.setSystemkey(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"), "")); //시스템키
            dlgn0210SrhVO.setPayCd(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd"), ""));  //급여구분코드
            
//            //Get total record count //전체 데이터 갯수를 가지고 온다.
	         if ( pagingValues.executeRecordCount ) { 
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
//                int iResultCnt = 0 ;
                int iResultCnt = dlgn0210DAO.selectDlgn0200ListTotCnt(dlgn0210SrhVO); 
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginDlgn0200DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            dlgn0210SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	dlgn0210SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	dlgn0210SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            
            List list = dlgn0210DAO.selectDlgn0200List(dlgn0210SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
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
            
            SmrmfUtils.endTiming(logger, millisBeginDlgn0200DataList, "getDlgn0200List_01");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
		
	
	
	
	
	
	
	
	
	
	/** 복무통합관리 근태 일괄생성 **/
	@Override
	public PagingLoadResult<ShowMessageBM>  generateAllWorkTime(Dlgn0100DTO dlgn0100Dto, Dlgn0200DTO dlgn0200Dto) throws MSFException {
		
			String method = calledClass + ".generateAllWorkTime";
		
			Long result = new Long(0);
	        Long iCnt = new Long(0);
	        PagingLoadResult<ShowMessageBM> retval = null;
	        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
	        
			String windowNm = "복무통합관리";
			String windowId = "DLGN0230";
		
			MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		   	List<String> listDeptCd = new ArrayList<String>();
		   	
			// 1. 암호화 객체 생성
		   	String rrnDecCrypt = "";
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			// 2. 파라미터 보낼 때(암호화)
			dlgn0100Dto.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0100Dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		   	
		   	try{ 
		   		
	            
	            // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	            // +++++++++++++++++++++++++++++++++기본근무 근태 생성 시작+++++++++++++++++++++++++++++++++++++
	            // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				/** 조건절 */
		   		dlgn0100Dto.setDpobCd(sessionUser.getDpobCd()); 
		   		dlgn0100Dto.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부   
		   		dlgn0100Dto.setUsrId(sessionUser.getUsrId());  
		   		dlgn0100Dto.setDilnlazYrMnth(dlgn0100Dto.getDilnlazYrMnth());
		   		dlgn0100Dto.setDilnlazDutyBgnnDt(dlgn0100Dto.getDilnlazDutyBgnnDt());				
				dlgn0100Dto.setDilnlazDutyEndDt(dlgn0100Dto.getDilnlazDutyEndDt());	
				dlgn0100Dto.setEmymtDivCd(dlgn0100Dto.getEmymtDivCd());
				dlgn0100Dto.setSystemkey(dlgn0100Dto.getSystemkey());
				dlgn0100Dto.setPayCd(dlgn0100Dto.getPayCd());
				dlgn0100Dto.setBusinCd(dlgn0100Dto.getBusinCd());
				
		   		dlgn0100Dto.setDeptCdAuth(MSFSharedUtils.allowNulls(dlgn0100Dto.getCurrAffnDeptCd()).replace(",", ""));  //권한처리를위해 추가
		   		dlgn0100Dto.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dlgn0100Dto.getDtilOccuInttnCd()).replace(",", ""));
		         
		   		dlgn0100Dto.setSystemkey(MSFSharedUtils.allowNulls(dlgn0100Dto.getSystemkey()));
		        
		        // 시스템 키가 없을 경우 일괄처리(lump), 있으면 개별처리(individ)
		        // 개별처리 할 경우 단위기관, 고용구분, 부서, 시스템키, 권한처리만 처리.
		        if("".equals(dlgn0100Dto.getSystemkey())  || dlgn0100Dto.getSystemkey() == null) {
		        	dlgn0100Dto.setCreateFlag("lump");		//일괄
		        }else {
		        	dlgn0100Dto.setCreateFlag("individ");	//개별
		        }
				/******************************** 권한 ************************************************************************/
		        String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();

	            if ("FALSE".equals(chkDeptCd)) {
	            	
	            	dlgn0100Dto.setDeptCd(sessionUser.getDeptCd()); 
	            	listDeptCd.add(sessionUser.getDeptCd());  
	            	dlgn0100Dto.setDeptCdArr(listDeptCd);     //부서코드  
	            	dlgn0100Dto.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            	
	            } else {
	            	
	            	dlgn0100Dto.setPayrMangDeptCd(dlgn0100Dto.getPayrMangDeptCd()) ;   //단위기관코드
	            	  
	            	
	            	if (dlgn0100Dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0100Dto.getCurrAffnDeptCd()))) {
	            		dlgn0100Dto.setDeptCd("");  //부서코드
	            		dlgn0100Dto.setDeptCdArr(null);     //부서코드 
	            	} else {
	            		
	            		dlgn0100Dto.setDeptCd(MSFSharedUtils.allowNulls(dlgn0100Dto.getCurrAffnDeptCd()));
	            		listDeptCd = SmrmfUtils.getStrToArrayList(dlgn0100Dto.getCurrAffnDeptCd());  
	            		dlgn0100Dto.setDeptCdArr(listDeptCd);     //부서코드 
	            		
	            	}
	            	 
	            }
	            /**
	            * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
		         */
	            if (dlgn0100Dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0100Dto.getDeptCdAuth())) 
	       			|| MSFSharedUtils.allowNulls(dlgn0100Dto.getDeptCdAuth()).contains(dlgn0100Dto.getPayrMangDeptCd())
	       			) {
	            	dlgn0100Dto.setRepbtyBusinDivCd(DlgnServerUtils.getRepbtyBusinData(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()));
	              	
	            }  
		       

	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0100Dto.getTypOccuCd())); 
	            dlgn0100Dto.setTypOccuCdArr(lstTypeOccuCd); 
	            dlgn0100Dto.setTypOccuCd(MSFSharedUtils.allowNulls(dlgn0100Dto.getTypOccuCd()));  //직종
	            
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0100Dto.getDtilOccuInttnCd())); 
	            dlgn0100Dto.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            dlgn0100Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(dlgn0100Dto.getDtilOccuInttnCd())); //직종세 
	            // 2.복호화 리턴받을 값 선언
				rrnDecCrypt = "";
	            /******************************** 권한 ************************************************************************/
	            
	            /**
	             * 대상자 가져오기 
	             */
	            List list =   dlgn0100DAO.selectDlgn0100ToRtnData(dlgn0100Dto); 
	            
	            Iterator<Map<String, Object>> iter = list.iterator();
	        
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	            
	                
	                dlgn0100Dto.setDpobCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dpobCd"))));    //DPOB_CD
	                dlgn0100Dto.setSystemkey(MSFSharedUtils.allowNulls(String.valueOf(map.get("systemkey")))); //SYSTEMKEY
	                dlgn0100Dto.setDilnlazYrMnth(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazYrMnth")))); //   DILNLAZ_YR_MNTH
	                dlgn0100Dto.setPayCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("payCd"))));            // PAY_CD
	                dlgn0100Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtDivCd"))));  // EMYMT_DIV_CD
	                dlgn0100Dto.setDeptCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("deptCd"))));          // DEPT_CD
	                dlgn0100Dto.setBusinCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("businCd"))));        // BUSIN_CD
	                dlgn0100Dto.setTypOccuCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("typOccuCd"))));    //  TYP_OCCU_CD
	                dlgn0100Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuClsDivCd"))));  //   DTIL_OCCU_CLS_DIV_CD
	                dlgn0100Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuInttnCd"))));   //DTIL_OCCU_INTTN_CD
	                dlgn0100Dto.setDilnlazDutyBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDutyBgnnDt"))));   // DILNLAZ_DUTY_BGNN_DT
	                dlgn0100Dto.setDilnlazDutyEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDutyEndDt"))));     // DILNLAZ_DUTY_END_DT
	                dlgn0100Dto.setDilnlazDutyNumDys(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDutyNumDys"))));   // DILNLAZ_DUTY_NUM_DYS
	                dlgn0100Dto.setDilnlazDdlnePrcsYn(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDdlnePrcsYn")))); //DILNLAZ_DDLNE_PRCS_YN
	                dlgn0100Dto.setDilnlazWklyHldyNumDys(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazWklyHldyNumDys")))); // DILNLAZ_WKLY_HLDY_NUM_DYS
	                dlgn0100Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtBgnnDt")))); // EMYMT_BGNN_DT
			        dlgn0100Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtEndDt"))));  // EMYMT_END_DT
			        dlgn0100Dto.setHdofcCodtnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("hdofcCodtnCd")))); // HDOFC_CODTN_CD
			        dlgn0100Dto.setHanNm(MSFSharedUtils.allowNulls(String.valueOf(map.get("hanNm"))));  //HAN_NM
			        
			        dlgn0100Dto.setIsmt(sessionUser.getUsrId());
			        dlgn0100Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			        dlgn0100Dto.setKybdr(sessionUser.getUsrId());
			        dlgn0100Dto.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			        
	                
		            /**
			         * TODO 김해 시청 기간제 근로자만 교통비, 급식비 Y 처리
			         */
			        if("A0020020".equals(dlgn0100Dto.getEmymtDivCd())) {
			        	dlgn0100Dto.setDilnlazTfcAssCstYn("Y");			// 근태_교통보조비여부
			        	dlgn0100Dto.setDilnlazLnchYn("Y");				// 근태_급식비여부
			        	
			        }else {
			        	dlgn0100Dto.setDilnlazTfcAssCstYn("N");			// 근태_교통보조비여부
			        	dlgn0100Dto.setDilnlazLnchYn("N");				// 근태_급식비여부
			        }
			        
			        
			        // 무기계약직 이면서 직종, 직종세 없을 경우 복무 로직 skip 처리
			        if( "A0020010".equals(dlgn0100Dto.getEmymtDivCd()) && ( "".equals(dlgn0100Dto.getTypOccuCd()) || "".equals(dlgn0100Dto.getDtilOccuInttnCd()))) {
			        	
			        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"DLGN","기본근무" ,"생성오류","대상자 : " + dlgn0100Dto.getHanNm() + " 인사관리 -> 직종, 직종세 누락 확인")); 
			        	
			        }else {
	                
		            	//삭제처리 후 
			        	dlgn0100DAO.deleteDlgn0110(dlgn0100Dto);
			        	dlgn0100DAO.deleteDlgn0100(dlgn0100Dto);  
		                
		                //인서트 처리 
			        	dlgn0100DAO.insertDlgn0100(dlgn0100Dto);
			        	dlgn0100DAO.insertDlgn0110(dlgn0100Dto);
	            
					
						InfcPkgDlgn0100VO infcDlgn0100Vo = new InfcPkgDlgn0100VO();
						
						// 3.복호화
	//					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	//					infcDlgn0100Vo.setResnRegnNum(rrnDecCrypt);
						
						infcDlgn0100Vo.setIsmt(sessionUser.getUsrId());
						infcDlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				 
				        infcDlgn0100Vo.setDpobCd(dlgn0100Dto.getDpobCd());						/** column 사업장코드 : dpobCd */
						infcDlgn0100Vo.setSystemkey(dlgn0100Dto.getSystemkey());				/** column SYSTEMKEY : systemkey */
						infcDlgn0100Vo.setDilnlazYrMnth(dlgn0100Dto.getDilnlazYrMnth());		/** column 근태년월 : dilnlazYrMnth */
						infcDlgn0100Vo.setPayCd(dlgn0100Dto.getPayCd());    					/** column 급여구분코드 : payCd */
						infcDlgn0100Vo.setEmymtDivCd(dlgn0100Dto.getEmymtDivCd());    			/** column 고용구분코드 : emymtDivCd */
						infcDlgn0100Vo.setDeptCd(dlgn0100Dto.getDeptCd());						/** column 부서코드 : deptCd */
						infcDlgn0100Vo.setBusinCd(dlgn0100Dto.getBusinCd());					/** column 사업코드 : businCd */
						infcDlgn0100Vo.setTypOccuCd(dlgn0100Dto.getTypOccuCd());    			/** column 직종코드 : typOccuCd */
						infcDlgn0100Vo.setPyspGrdeCd(dlgn0100Dto.getPyspGrdeCd());    			/** TODO 추가후 수정  column 호봉등급코드 : pyspGrdeCd */
						infcDlgn0100Vo.setDtilOccuInttnCd(dlgn0100Dto.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
						infcDlgn0100Vo.setDilnlazWklyHldyNumDys(dlgn0100Dto.getDilnlazWklyHldyNumDys()); //주휴일수
						
						/****************************************************************************************************
						 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
						 ****************************************************************************************************/
							DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
							Long iResult = dlgnAdapter.setUpdateManageDlgn0100HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
						/****************************************************************************************************
						 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
						 ****************************************************************************************************/
				        iCnt = iCnt + 1;
				        bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","기본근무" ,"생성완료","대상자 : " + dlgn0100Dto.getHanNm())); 
			        }
	            }   
				
	            bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","기본근무 생성" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(iCnt) + "명처리완료 ")); 
	            
	            
	            // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	            // ++++++++++++++++++++++++++++++++시간외근무 근태 생성 시작++++++++++++++++++++++++++++++++++++
	            // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	            
				
				/** 조건절 */
	            dlgn0200Dto.setDpobCd(sessionUser.getDpobCd()); 
	            dlgn0200Dto.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부   
	            dlgn0200Dto.setUsrId(sessionUser.getUsrId());  
	            dlgn0200Dto.setSystemkey(dlgn0200Dto.getSystemkey());
	        	dlgn0200Dto.setDilnlazExceDutyYrMnth(dlgn0200Dto.getDilnlazExceDutyYrMnth());
				dlgn0200Dto.setDilnlazExceDutyBgnnDt(dlgn0200Dto.getDilnlazExceDutyBgnnDt());
				dlgn0200Dto.setDilnlazExceDutyEndDt(dlgn0200Dto.getDilnlazExceDutyEndDt());
				dlgn0200Dto.setEmymtDivCd(dlgn0100Dto.getEmymtDivCd());
				dlgn0200Dto.setPayCd(dlgn0100Dto.getPayCd());
				dlgn0200Dto.setBusinCd(dlgn0100Dto.getBusinCd());
				
				// 시스템 키가 없을 경우 일괄처리(lump), 있으면 일괄처리(individ)
		        // 개별처리 할 경우 단위기관, 고용구분, 부서, 시스템키, 권한처리만 처리.
				dlgn0200Dto.setCreateFlag(dlgn0100Dto.getCreateFlag());		//일괄
		        
				dlgn0200Dto.setDeptCdAuth(MSFSharedUtils.allowNulls(dlgn0100Dto.getCurrAffnDeptCd()).replace(",", ""));  //권한처리를위해 추가
				dlgn0200Dto.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dlgn0100Dto.getDtilOccuInttnCd()).replace(",", ""));
				
				listDeptCd = new ArrayList<String>();
				/******************************** 권한 ************************************************************************/
	            chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();

	            if ("FALSE".equals(chkDeptCd)) {
	            	
	            	dlgn0200Dto.setDeptCd(sessionUser.getDeptCd()); 
	            	listDeptCd.add(sessionUser.getDeptCd());
	            	dlgn0200Dto.setDeptCdArr(listDeptCd);     //부서코드  
	            	dlgn0200Dto.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            	
	            } else {
		            	
	            	dlgn0200Dto.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dlgn0100Dto.getPayrMangDeptCd())) ;   //단위기관코드
	            	   
	            	if (dlgn0100Dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0100Dto.getCurrAffnDeptCd()))) {
	            		
	            		listDeptCd = null; 
	            		dlgn0200Dto.setCurrAffnDeptCd("");  //부서코드
	            		dlgn0200Dto.setDeptCdArr(null);     //부서코드 
	            		
	            	} else {
	            		
	            		dlgn0200Dto.setCurrAffnDeptCd(MSFSharedUtils.allowNulls(dlgn0100Dto.getCurrAffnDeptCd()));
	            		listDeptCd = SmrmfUtils.getStrToArrayList(dlgn0100Dto.getCurrAffnDeptCd());  
	            		dlgn0200Dto.setDeptCdArr(listDeptCd);     //부서코드 
	            		
	            	}
	            	 
	            }
	            
	            /**
	             * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
		         */
	            if (dlgn0100Dto.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0100Dto.getDeptCdAuth())) 
	       			|| MSFSharedUtils.allowNulls(dlgn0100Dto.getDeptCdAuth()).contains(dlgn0100Dto.getPayrMangDeptCd())
	       			) {
	            	dlgn0200Dto.setRepbtyBusinDivCd(DlgnServerUtils.getRepbtyBusinData(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()));
	              	
	            }  
		       

	            lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0100Dto.getTypOccuCd())); 
	            dlgn0200Dto.setTypOccuCdArr(lstTypeOccuCd); 
	            dlgn0200Dto.setTypOccuCd(MSFSharedUtils.allowNulls(dlgn0100Dto.getTypOccuCd()));  //직종
	            
	            lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dlgn0100Dto.getDtilOccuInttnCd())); 
	            dlgn0200Dto.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            dlgn0200Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(dlgn0100Dto.getDtilOccuInttnCd())); //직종세 
	            // 2.복호화 리턴받을 값 선언
				rrnDecCrypt = "";
	            /******************************** 권한 ************************************************************************/
	            
	            
				/**
				 * 대상자 가져오기 
				 */
	            list =   dlgn0200DAO.selectDlgn0200ToRtnData(dlgn0200Dto); 
	            iCnt = new Long(0);
	            Iterator<Map<String, Object>> dlgn0200Iter = list.iterator();
	        
	            while ( dlgn0200Iter.hasNext() ) {
	            	
	                Map<String, Object> map = (Map<String, Object>) dlgn0200Iter.next();
	             
	                dlgn0200Dto.setDpobCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dpobCd"))));    //DPOB_CD
	                dlgn0200Dto.setSystemkey(MSFSharedUtils.allowNulls(String.valueOf(map.get("systemkey")))); //SYSTEMKEY
	                dlgn0200Dto.setDilnlazExceDutyYrMnth(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazExceDutyYrMnth")))); //   DILNLAZ_YR_MNTH
	                dlgn0200Dto.setPayCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("payCd"))));            // PAY_CD
	                dlgn0200Dto.setEmymtDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtDivCd"))));  // EMYMT_DIV_CD
	                dlgn0200Dto.setDeptCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("deptCd"))));          // DEPT_CD
	                dlgn0200Dto.setBusinCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("businCd"))));        // BUSIN_CD
	                dlgn0200Dto.setTypOccuCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("typOccuCd"))));    //  TYP_OCCU_CD
	                dlgn0200Dto.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuClsDivCd"))));  //   DTIL_OCCU_CLS_DIV_CD
	                dlgn0200Dto.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("dtilOccuInttnCd"))));   //DTIL_OCCU_INTTN_CD
			       
	                dlgn0200Dto.setDilnlazExceDutyBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazExceDutyBgnnDt"))));   // DILNLAZ_DUTY_BGNN_DT
	                dlgn0200Dto.setDilnlazExceDutyEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazExceDutyEndDt"))));     // DILNLAZ_DUTY_END_DT
			        
	                dlgn0200Dto.setDilnlazDdlnePrcsYn(MSFSharedUtils.allowNulls(String.valueOf(map.get("dilnlazDdlnePrcsYn")))); //DILNLAZ_DDLNE_PRCS_YN 
	                dlgn0200Dto.setEmymtBgnnDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtBgnnDt")))); // EMYMT_BGNN_DT
			        dlgn0200Dto.setEmymtEndDt(MSFSharedUtils.allowNulls(String.valueOf(map.get("emymtEndDt"))));  // EMYMT_END_DT
			        dlgn0200Dto.setHdofcCodtnCd(MSFSharedUtils.allowNulls(String.valueOf(map.get("hdofcCodtnCd")))); // HDOFC_CODTN_CD
			        dlgn0200Dto.setHanNm(MSFSharedUtils.allowNulls(String.valueOf(map.get("hanNm"))));  //HAN_NM
			        
			        
			        // 무기계약직 이면서 직종, 직종세 없을 경우 복무 로직 skip 처리
			        if( "A0020010".equals(dlgn0200Dto.getEmymtDivCd()) && ( "".equals(dlgn0200Dto.getTypOccuCd()) || "".equals(dlgn0200Dto.getDtilOccuInttnCd()))) {
			        	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"DLGN","초과근무" ,"생성오류","대상자 : " + dlgn0200Dto.getHanNm() + " 인사관리 -> 직종, 직종세 누락 확인")); 
			        }else {
			         
		          
			        	dlgn0200DAO.deleteDlgn0210(dlgn0200Dto);
						dlgn0200DAO.deleteDlgn0200(dlgn0200Dto); 
						dlgn0200DAO.insertDlgn0200(dlgn0200Dto);
						dlgn0200DAO.insertDlgn0210(dlgn0200Dto);
						
						InfcPkgDlgn0200VO infcDlgn0200Vo = new InfcPkgDlgn0200VO();
					
						// 3.복호화
						rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0200Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
						dlgn0200Dto.setResnRegnNum(rrnDecCrypt);
						
						infcDlgn0200Vo.setIsmt(sessionUser.getUsrId());
						infcDlgn0200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
				 
						infcDlgn0200Vo.setDpobCd(dlgn0200Dto.getDpobCd());									/** column 사업장코드 : dpobCd */
						infcDlgn0200Vo.setSystemkey(dlgn0200Dto.getSystemkey());    						/** column SYSTEMKEY : systemkey */
						infcDlgn0200Vo.setDilnlazExceDutyYrMnth(dlgn0200Dto.getDilnlazExceDutyYrMnth()); 	/** column 근태년월 : dilnlazYrMnth */
						infcDlgn0200Vo.setPayCd(dlgn0200Dto.getPayCd());									/** column 급여구분코드 : payCd */
						infcDlgn0200Vo.setEmymtDivCd(dlgn0200Dto.getEmymtDivCd());    						/** column 고용구분코드 : emymtDivCd */
						infcDlgn0200Vo.setDeptCd(dlgn0200Dto.getDeptCd());									/** column 부서코드 : deptCd */
						infcDlgn0200Vo.setBusinCd(dlgn0200Dto.getBusinCd());   	 							/** column 사업코드 : businCd */
						infcDlgn0200Vo.setTypOccuCd(dlgn0200Dto.getTypOccuCd());    						/** column 직종코드 : typOccuCd */
						infcDlgn0200Vo.setPyspGrdeCd(dlgn0200Dto.getPyspGrdeCd());   					 	/** column 호봉등급코드 : pyspGrdeCd */
						infcDlgn0200Vo.setDtilOccuInttnCd(dlgn0200Dto.getDtilOccuInttnCd());    			/** column 직종세구분코드 : dtilOccuInttnCd */
						
						/****************************************************************************************************
						 * 시간외 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
						 ****************************************************************************************************/
						DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
						Long iResult = dlgnAdapter.setUpdateManageDlgn0200HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
						/****************************************************************************************************
						 * 시간외 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
						 ****************************************************************************************************/
						
						iCnt = iCnt + 1;
						
				        bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","초과근무" ,"생성완료","대상자 : " + dlgn0200Dto.getHanNm())); 
				        
			        }
	            }
	            
	            bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","초과근무 생성" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(iCnt) + "명처리완료 ")); 
	            
	            retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
				 
		   	}catch(Exception e) {
		   		e.printStackTrace();
		   		
		   		/** 에러 로그 **/			
		   		MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:D",e, windowNm , windowId);
		   		throw MSFServerUtils.getOperationException(this.getClass().getName() + " " + "근태 생성 중 오류 발생 <br> 관리자에게 문의해 주세요.", e, logger);
		   	}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:D");
			
		return retval;
	}
	
	
	
	/** 복무통합관리 복무 삭제 **/
	@Override
	public int deleteWorkTime(List<Dlgn0100DTO> list) throws MSFException {
		
		int deleteCnt = 0;
		if(list != null && list.size() > 0){
			
			for(int i = 0; i < list.size(); i++){
				
				Dlgn0100DTO dto = list.get(i); 
				Dlgn0200DTO dtoDlgn0200  = new Dlgn0200DTO();
				
				dtoDlgn0200.setDpobCd(dto.getDpobCd());    						/** column 사업장코드 : dpobCd */
				dtoDlgn0200.setSystemkey(dto.getSystemkey());    				/** column SYSTEMKEY : systemkey */
				dtoDlgn0200.setDilnlazExceDutyYrMnth(dto.getDilnlazYrMnth());	/** column 근태초과근무년월 : dilnlazExceDutyYrMnth */
				dtoDlgn0200.setPayCd(dto.getPayCd());    						/** column 급여구분코드 : payCd */
				
				try {
					dlgn0200DAO.deleteDlgn0210_S(dtoDlgn0200);
					deleteCnt += dlgn0200DAO.deleteDlgn0200_S(dtoDlgn0200); 
					
					dlgn0100DAO.deleteDlgn0110_S(dto);
					deleteCnt += dlgn0100DAO.deleteDlgn0100_S(dto); 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return deleteCnt;
	}
	
	
	/** 복무통합관리 주휴일수만 수정 **/
	@Override
	public Long updateDlgn0100_DILNLAZ_WKLY_HLDY_NUM_DYS(Dlgn0110DTO dlgn01101dto) throws MSFException {
		
		Long rtnData = 0L;
		Long result = new Long(0);
        Long iCnt = new Long(0);
        PagingLoadResult<ShowMessageBM> retval = null;
        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
        
		String method = calledClass + ".updateDlgn0100_DILNLAZ_WKLY_HLDY_NUM_DYS";
		
		String windowNm = "복무통합관리";
		String windowId = "DLGN0230";
	 
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        try{
        	
           if  (MSFSharedUtils.paramNull(dlgn0110DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                dlgn0110DAO = (Dlgn0110DAO) wac.getBean("dlgn0110DAO" ); 
            }
           
           if  (MSFSharedUtils.paramNull(dlgn0210DAO)) {
               
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

               dlgn0210DAO = (Dlgn0210DAO) wac.getBean("dlgn0210DAO" ); 
           }
            
            	
        	
            InfcPkgDlgn0100VO infcDlgn0100Vo = new InfcPkgDlgn0100VO();
			
			// 3.복호화
//			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0110Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//			infcDlgn0100Vo.setResnRegnNum(rrnDecCrypt);
//			
			infcDlgn0100Vo.setIsmt(sessionUser.getUsrId());
			infcDlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
	 
	        infcDlgn0100Vo.setDpobCd(dlgn01101dto.getDpobCd());						/** column 사업장코드 : dpobCd */
			infcDlgn0100Vo.setSystemkey(dlgn01101dto.getSystemkey());				/** column SYSTEMKEY : systemkey */
			infcDlgn0100Vo.setDilnlazYrMnth(dlgn01101dto.getDilnlazYrMnth());		/** column 근태년월 : dilnlazYrMnth */
			infcDlgn0100Vo.setPayCd(dlgn01101dto.getPayCd());    					/** column 급여구분코드 : payCd */
			infcDlgn0100Vo.setEmymtDivCd(dlgn01101dto.getEmymtDivCd());    			/** column 고용구분코드 : emymtDivCd */
			infcDlgn0100Vo.setDeptCd(dlgn01101dto.getDeptCd());						/** column 부서코드 : deptCd */
			infcDlgn0100Vo.setBusinCd(dlgn01101dto.getBusinCd());					/** column 사업코드 : businCd */
			infcDlgn0100Vo.setTypOccuCd(dlgn01101dto.getTypOccuCd());    			/** column 직종코드 : typOccuCd */
			infcDlgn0100Vo.setDtilOccuInttnCd(dlgn01101dto.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
			infcDlgn0100Vo.setDilnlazWklyHldyNumDys(dlgn01101dto.getDilnlazWklyHldyNumDys()); //주휴일수
			
			/****************************************************************************************************
			 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
			 ****************************************************************************************************/
				DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
				Long iResult = dlgnAdapter.setUpdateManageDlgn0100HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
			/****************************************************************************************************
			 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
			 ****************************************************************************************************/
        	
        	/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
				
			rtnData = 1L;	
        } catch (Exception ex) {
     		   
     		 /** 에러 로그 **/			
     		 MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",ex, windowNm , windowId);
     		 ex.printStackTrace();
     		 rtnData = 0L;
     		 throw MSFServerUtils.getOperationException(this.getClass().getName(), ex, logger);
     		 
     		 
     	}finally {
             
           }
     	
     	return rtnData;
     	
	}
	
	
	
	
	/** 복무통합관리 기본근무 수정 **/
	@Override
	public Long updateDlgn0110Grid(List<Dlgn0110DTO> listDlgn0110Dto ) throws MSFException {
		
		Long rtnData = 0L;
		Long result = new Long(0);
        Long iCnt = new Long(0);
        PagingLoadResult<ShowMessageBM> retval = null;
        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
        
		String method = calledClass + ".updateDlgn0110Grid";
		
		String windowNm = "복무통합관리";
		String windowId = "DLGN0230";
	 
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        try{
        	
           if  (MSFSharedUtils.paramNull(dlgn0110DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                dlgn0110DAO = (Dlgn0110DAO) wac.getBean("dlgn0110DAO" ); 
            }
           
           if  (MSFSharedUtils.paramNull(dlgn0210DAO)) {
               
               WebApplicationContext wac = WebApplicationContextUtils.
                       getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

               dlgn0210DAO = (Dlgn0210DAO) wac.getBean("dlgn0210DAO" ); 
           }
            
            String rrnDecCrypt = "";
            for(int iPayrCnt=0; iPayrCnt < listDlgn0110Dto.size();iPayrCnt++) {
            	
            	Dlgn0110DTO dlgn0110Dto = new Dlgn0110DTO();
            	dlgn0110Dto = listDlgn0110Dto.get(iPayrCnt);
            	
            	dlgn0110Dto.setIsmt(sessionUser.getUsrId());
            	dlgn0110Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
            	
            	dlgn0110Dto.setPayCd(dlgn0110Dto.getPayCd());
            	dlgn0110Dto.setSystemkey(dlgn0110Dto.getSystemkey());
            	dlgn0110Dto.setDpobCd(dlgn0110Dto.getDpobCd());
            	
            	dlgn0110Dto.setDilnlazYrMnth(dlgn0110Dto.getDilnlazYrMnth().replaceAll("\\.", ""));
            	dlgn0110Dto.setDilnlazApptnDt(dlgn0110Dto.getDilnlazApptnDt().replaceAll("\\.", ""));
            	dlgn0110Dto.setDilnlazDutyTm(dlgn0110Dto.getDilnlazDutyTm());
            	dlgn0110Dto.setDilnlazWklyHldyNumDys(dlgn0110Dto.getDilnlazWklyHldyNumDys()); // DILNLAZ_WKLY_HLDY_NUM_DYS
            	dlgn0110Dto.setDilnlazEtcDivCd(dlgn0110Dto.getDilnlazEtcDivCd());
            	dlgn0110Dto.setEmymtDivCd(dlgn0110Dto.getEmymtDivCd());
            	
            	
            	dlgn0110Dto.setDilnlazDutyYn("N");		//근무   
            	
            	dlgn0110Dto.setDilnlazAbnceYn("N");		//결근
            	dlgn0110Dto.setDilnlazAbnceDutyRcgtnYn("");
    			dlgn0110Dto.setDilnlazEtcDivCd("N0010000");	
    			
            	dlgn0110Dto.setDilnlazLvsgYn("N"); 		//연차
            	dlgn0110Dto.setDilnlazSpclHodyYn("N");	//특(휴)
            	dlgn0110Dto.setDilnlazSckleaYn("N");	//병가
            	dlgn0110Dto.setDilnlazOffvaYn("N");		//공가
            	dlgn0110Dto.setDilnlazFmlyEvntYn("N");	//경조사
            	dlgn0110Dto.setDilnlazHlthCreYn("N");	//보건
            	
            	if("true".equals(dlgn0110Dto.getDilnlazTfcAssCstYn())) {
            		dlgn0110Dto.setDilnlazTfcAssCstYn("Y");	//교통비
            	}else {
            		dlgn0110Dto.setDilnlazTfcAssCstYn("N");	//교통비
            	}
            	
            	if("true".equals(dlgn0110Dto.getDilnlazLnchYn())) {
            		dlgn0110Dto.setDilnlazLnchYn("Y");			//급식비         
            	}else {
            		dlgn0110Dto.setDilnlazLnchYn("N");			//급식비         
            	}
            	
            	  		
            		
            		
            	
            	
//     			1	DILNLAZ_DUTY_YN					근태_근무여부		N0020000	N002	0000	근무
//     			2	DILNLAZ_ABNCE_YN				근태_결근여부		N0020001	N002	0001	결근
//     			3	DILNLAZ_LVSG_YN					근태_연가여부		N0020002	N002	0002	연차
//     			4	DILNLAZ_SPCL_HODY_YN			근태_특별휴가여부	N0020003	N002	0003	특(휴)
//     			5	DILNLAZ_SCKLEA_YN				근태_병가여부		N0020004	N002	0004	병가
//     			6	DILNLAZ_OFFVA_YN				근태_공가여부		N0020005	N002	0005	공가
//     			7	DILNLAZ_FMLY_EVNT_YN			근태_경조사여부		N0020006	N002	0006	경조
//     			8	DILNLAZ_HLTH_CRE_YN				근태_보건여부		N0020007	N002	0007	보건
            	
            	if("N0020000".equals(dlgn0110Dto.getDilnlazDutyList())) {
            		
            		dlgn0110Dto.setDilnlazDutyYn("Y");		//근무
            		
            	}else if("N0020001".equals(dlgn0110Dto.getDilnlazDutyList())) {
            		
                	dlgn0110Dto.setDilnlazAbnceYn("Y");
                		
                	// 무기계약직 일 경우 결근인정여부 기본으로 처리해줌.
                	if("A0020010".equals(dlgn0110Dto.getEmymtDivCd()) || "A0020010" == dlgn0110Dto.getEmymtDivCd()) {
                		
                		dlgn0110Dto.setDilnlazAbnceDutyRcgtnYn("Y");
                		dlgn0110Dto.setDilnlazEtcDivCd("N0010010");	
                		
                	}
                		
            		
            	}else if("N0020002".equals(dlgn0110Dto.getDilnlazDutyList())) {
            		
            		dlgn0110Dto.setDilnlazLvsgYn("N"); 		//연차
            		
            	}else if("N0020003".equals(dlgn0110Dto.getDilnlazDutyList())) {
            		
            		dlgn0110Dto.setDilnlazSpclHodyYn("Y");	//특(휴)
            		
            	}else if("N0020004".equals(dlgn0110Dto.getDilnlazDutyList())) {
            		
            		dlgn0110Dto.setDilnlazSckleaYn("Y");	//병가
            		
            	}else if("N0020005".equals(dlgn0110Dto.getDilnlazDutyList())) {
            		
            		dlgn0110Dto.setDilnlazOffvaYn("Y");		//공가
            		
            	}else if("N0020006".equals(dlgn0110Dto.getDilnlazDutyList())) {
            		
            		dlgn0110Dto.setDilnlazFmlyEvntYn("Y");	//경조사
            		
            	}else if("N0020007".equals(dlgn0110Dto.getDilnlazDutyList())) {
            		
            		dlgn0110Dto.setDilnlazHlthCreYn("Y");	//보건
            	}
                           	
            	
            	
//            	
//            	if("true".equals(dlgn0110Dto.getDilnlazDutyYn())){
//            		dlgn0110Dto.setDilnlazDutyYn("Y");
//            	}else{
//            		dlgn0110Dto.setDilnlazDutyYn("N");
//            	}
////            	dlgn0110Dto.setDilnlazDutyYn(dlgn0110Dto.getDilnlazDutyYn()); //근무
//            	if("true".equals(dlgn0110Dto.getDilnlazAbnceYn())){
//            		dlgn0110Dto.setDilnlazAbnceYn("Y");
//            		
//            		// 무기계약직 일 경우 결근인정여부 기본으로 처리해줌.
//            		if("A0020010".equals(dlgn0110Dto.getEmymtDivCd()) || "A0020010" == dlgn0110Dto.getEmymtDivCd()) {
//            			dlgn0110Dto.setDilnlazAbnceDutyRcgtnYn("Y");
//            			dlgn0110Dto.setDilnlazEtcDivCd("N0010010");	
//            		}
//            		
//            	}else{
//            		dlgn0110Dto.setDilnlazAbnceYn("N");
//            		
//            		// 무기계약직 일 경우 결근인정여부 기본으로 처리해줌.
//            		if("A0020010".equals(dlgn0110Dto.getEmymtDivCd()) || "A0020010" == dlgn0110Dto.getEmymtDivCd()) {
//            			dlgn0110Dto.setDilnlazAbnceDutyRcgtnYn("");
//            			dlgn0110Dto.setDilnlazEtcDivCd("N0010000");	
//            		}
//            		
//            	}
////            	dlgn0110Dto.setDilnlazAbnceYn(dlgn0110Dto.getDilnlazAbnceYn()); //결근
//            	if("true".equals(dlgn0110Dto.getDilnlazLvsgYn())){
//            		dlgn0110Dto.setDilnlazLvsgYn("Y");
//            		
//            	}else{
//            		dlgn0110Dto.setDilnlazLvsgYn("N");
//            	}
////            	dlgn0110Dto.setDilnlazLvsgYn(dlgn0110Dto.getDilnlazLvsgYn()); //연차
//            	if("true".equals(dlgn0110Dto.getDilnlazSpclHodyYn())){
//            		dlgn0110Dto.setDilnlazSpclHodyYn("Y");
//            	}else{
//            		dlgn0110Dto.setDilnlazSpclHodyYn("N");
//            	}
////            	dlgn0110Dto.setDilnlazSpclHodyYn(dlgn0110Dto.getDilnlazSpclHodyYn()); //특(휴)
//            	if("true".equals(dlgn0110Dto.getDilnlazSckleaYn())){
//            		dlgn0110Dto.setDilnlazSckleaYn("Y");
//            	}else{
//            		dlgn0110Dto.setDilnlazSckleaYn("N");
//            	}            	
////            	dlgn0110Dto.setDilnlazSckleaYn(dlgn0110Dto.getDilnlazSckleaYn()); //병가
//            	if("true".equals(dlgn0110Dto.getDilnlazOffvaYn())){
//            		dlgn0110Dto.setDilnlazOffvaYn("Y");
//            	}else{
//            		dlgn0110Dto.setDilnlazOffvaYn("N");
//            	} 
////            	dlgn0110Dto.setDilnlazOffvaYn(dlgn0110Dto.getDilnlazOffvaYn()); //공가
//            	if("true".equals(dlgn0110Dto.getDilnlazFmlyEvntYn())){
//            		dlgn0110Dto.setDilnlazFmlyEvntYn("Y");
//            	}else{
//            		dlgn0110Dto.setDilnlazFmlyEvntYn("N");
//            	} 
////            	dlgn0110Dto.setDilnlazFmlyEvntYn(dlgn0110Dto.getDilnlazFmlyEvntYn()); //경조사
//            	if("true".equals(dlgn0110Dto.getDilnlazHlthCreYn())){
//            		dlgn0110Dto.setDilnlazHlthCreYn("Y");
//            	}else{
//            		dlgn0110Dto.setDilnlazHlthCreYn("N");
//            	} 
////            	dlgn0110Dto.setDilnlazHlthCreYn(dlgn0110Dto.getDilnlazHlthCreYn()); //보건
//            	
//            	if("true".equals(dlgn0110Dto.getDilnlazTfcAssCstYn())){ //교통비
//            		dlgn0110Dto.setDilnlazTfcAssCstYn("Y");
//            	}else{
//            		dlgn0110Dto.setDilnlazTfcAssCstYn("N");
//            	} 
//            	
//            	if("true".equals(dlgn0110Dto.getDilnlazLnchYn())){ //급식비
//            		dlgn0110Dto.setDilnlazLnchYn("Y");
//            	}else{
//            		dlgn0110Dto.setDilnlazLnchYn("N");
//            	}
            	
	        dlgn0110DAO.updateDlgn0100ToDlgn0110(dlgn0110Dto);
	        dlgn0210DAO.updateDlgn0100Todlgn0210Tm(dlgn0110Dto); 
        	
            InfcPkgDlgn0100VO infcDlgn0100Vo = new InfcPkgDlgn0100VO();
			
			// 3.복호화
//			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0110Dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//			infcDlgn0100Vo.setResnRegnNum(rrnDecCrypt);
//			
			infcDlgn0100Vo.setIsmt(sessionUser.getUsrId());
			infcDlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
	 
	        infcDlgn0100Vo.setDpobCd(dlgn0110Dto.getDpobCd());								/** column 사업장코드 : dpobCd */
			infcDlgn0100Vo.setSystemkey(dlgn0110Dto.getSystemkey());						/** column SYSTEMKEY : systemkey */
			infcDlgn0100Vo.setDilnlazYrMnth(dlgn0110Dto.getDilnlazYrMnth());				/** column 근태년월 : dilnlazYrMnth */
			infcDlgn0100Vo.setPayCd(dlgn0110Dto.getPayCd());    							/** column 급여구분코드 : payCd */
			infcDlgn0100Vo.setEmymtDivCd(dlgn0110Dto.getEmymtDivCd());    					/** column 고용구분코드 : emymtDivCd */
			infcDlgn0100Vo.setDeptCd(dlgn0110Dto.getDeptCd());								/** column 부서코드 : deptCd */
			infcDlgn0100Vo.setBusinCd(dlgn0110Dto.getBusinCd());							/** column 사업코드 : businCd */
			infcDlgn0100Vo.setTypOccuCd(dlgn0110Dto.getTypOccuCd());    					/** column 직종코드 : typOccuCd */
			infcDlgn0100Vo.setDtilOccuInttnCd(dlgn0110Dto.getDtilOccuInttnCd());    		/** column 직종세구분코드 : dtilOccuInttnCd */
			infcDlgn0100Vo.setDilnlazWklyHldyNumDys(dlgn0110Dto.getDilnlazWklyHldyNumDys());/** column 주휴일수 : dilnlazWklyHldyNumDys */
			
			/****************************************************************************************************
			 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
			 ****************************************************************************************************/
				DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
				Long iResult = dlgnAdapter.setUpdateManageDlgn0100HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0100Vo);
			/****************************************************************************************************
			 * 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
			****************************************************************************************************/
            }
        	
        	/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
//           MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
           
           iCnt = iCnt + 1; 
            
           bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","기본근무관리 업데이트" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(iCnt) + "명처리완료 "));   
           rtnData = 1L;	
        } catch (Exception ex) {
        	ex.printStackTrace();   
     		ShowMessageBM smBm = new ShowMessageBM();
     		smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
     		smBm.setMenu("dlgn");
     		smBm.setPhase("[근무실적]에러");
     		smBm.setMessage(ex.getLocalizedMessage());
     		smBm.setContent(ex.getMessage());
     		bmResult.add(smBm);  
     		   
     		/** 에러 로그 **/			
     		MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",ex, windowNm , windowId);
     		ex.printStackTrace();
     		rtnData = 0L;
     		throw MSFServerUtils.getOperationException(this.getClass().getName(), ex, logger);
     		
     	}finally {
             
     	}
     	
     	return rtnData;
     	
	}
	
	
	
	/** 복무통합관리 대상자 정보를 가져옴 **/
	@Override
	public Dlgn0100DTO getMemberInfo(Dlgn0100DTO dtoParam) throws MSFException {
		
		String method = calledClass + ".getMemberInfo";
		
		String windowNm = "복무통합관리";
		String windowId = "DLGN0230";
		
		List egovResultDataList = new ArrayList();
		Dlgn0100SrhVO dlgn0100SrhVO = new Dlgn0100SrhVO();
		Dlgn0100DTO dto = new Dlgn0100DTO();
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		 	    
		dlgn0100SrhVO.setPayCd(MSFSharedUtils.allowNulls(dtoParam.getPayCd()));	//급여구분
		dlgn0100SrhVO.setDilnlazYrMnth(MSFSharedUtils.allowNulls(dtoParam.getDilnlazYrMnth()));	//지급년월
		dlgn0100SrhVO.setHanNm(MSFSharedUtils.allowNulls(dtoParam.getHanNm()));					//성명
		dlgn0100SrhVO.setSystemkey(MSFSharedUtils.allowNulls(dtoParam.getSystemkey()));
		
		
		// 2. 파라미터 보낼 때(암호화)
		dlgn0100SrhVO.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(dtoParam.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		
		
		//아래 권한부분에서 처리
//		List<String> listDeptCd = SmrmfUtils.getStrToArrayList(dtoParam.getCurrAffnDeptCd());  
//		dlgn0100SrhVO.setDeptCdArr(listDeptCd);     
//		dlgn0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));	//부서코드
			
//			dlgn0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));	//부서
		dlgn0100SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(dtoParam.getEmymtDivCd()));	//고용구분
		dlgn0100SrhVO.setBusinCd(MSFSharedUtils.allowNulls(dtoParam.getBusinCd()));			//사업
			
//		List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(dtoParam.getHdofcCodtnCd());  
//		dlgn0100SrhVO.setHdofcCodtnCdArr(listHdofcCodtnCd);    
//		dlgn0100SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(dtoParam.getHdofcCodtnCd()));//재직코드
			
		List<String> lstTypOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dtoParam.getTypOccuCd())); 
		dlgn0100SrhVO.setTypOccuCdArr(lstTypOccuCd);  
		dlgn0100SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(dtoParam.getTypOccuCd())));				//직종
			
		List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dtoParam.getDtilOccuInttnCd())); 
		dlgn0100SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		dlgn0100SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(dtoParam.getDtilOccuInttnCd()))); 	//직종세
			
			
		dlgn0100SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장											
		dlgn0100SrhVO.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));	//단위기간 담당자 여부
//		dlgn0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptCd()));	//단위기관
		dlgn0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dtoParam.getDeptCd())) ;   //단위기관
		dlgn0100SrhVO.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));						//유저 아이디
		
		dlgn0100SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()).replace(",", ""));  //권한처리를위해 추가  
		dlgn0100SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(dtoParam.getDtilOccuInttnCd()).replace(",", ""));
			         
		/******************************** 권한 ************************************************************************/
		  String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03(); 
		if ("FALSE".equals(chkDeptCd)) {
			dlgn0100SrhVO.setDeptCd(sessionUser.getDeptCd()); 
			List<String> listDeptCd = SmrmfUtils.getStrToArrayList(sessionUser.getDeptCd());  
          	dlgn0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
          	dlgn0100SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
          } else {
				if (sessionUser.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd())) || 
						dtoParam.getCurrAffnDeptCd().indexOf(dtoParam.getDeptCd()) != -1
						) { 
		//			List<String> listDeptCd = SmrmfUtils.getStrToArrayList(dtoParam.getCurrAffnDeptCd());  
		//			dlgn0100SrhVO.setDeptCdArr(listDeptCd);     
		//			dlgn0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));	//부서코드
							
					dlgn0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(dtoParam.getDeptCd())); // 단위기관
					dtoParam.setDeptCd("");
					dlgn0100SrhVO.setDeptCd("");
					List<String> listDeptCd = SmrmfUtils.getStrToArrayList(dtoParam.getCurrAffnDeptCd());  //부서
					dlgn0100SrhVO.setDeptCdArr(listDeptCd);  
						        
				}  else { 
					dlgn0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd()));
					List<String> lsdeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(dtoParam.getCurrAffnDeptCd())); 
					dlgn0100SrhVO.setDeptCdArr(lsdeptCd);  
				}  
          }
		
		try{
			
			egovResultDataList = dlgn0100DAO.selectDlgn0100(dlgn0100SrhVO);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				dto = new Dlgn0100DTO();
				
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					
					// 2.복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		dto.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		dto.set(key, tempMap.get(key));
		            	}
		            }
					
					// 3.복호화
					rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dto.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
					dto.setResnRegnNum(rrnDecCrypt);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return dto;
	}	
	
	
	
	/** 복무통합관리 초과근무 수정**/ 
	@Override
	public Long updateDlgn0210Grid(List<Dlgn0210DTO> listDlgn0210Dto ) throws MSFException {
		
		Long rtnData = 0L;
		Long result = new Long(0);
        Long iCnt = new Long(0);
        PagingLoadResult<ShowMessageBM> retval = null;
        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
        
		String method = calledClass + ".updateDlgn0210Grid";
		
		String windowNm = "복무통합관리";
		String windowId = "DLGN0230";
		 
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        try {  
            
            if  (MSFSharedUtils.paramNull(dlgn0100DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                dlgn0100DAO = (Dlgn0100DAO) wac.getBean("dlgn0100DAO" ); 
            }
            
            if  (MSFSharedUtils.paramNull(dlgn0200DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                dlgn0200DAO = (Dlgn0200DAO) wac.getBean("dlgn0200DAO" ); 
            }
            
            
            if  (MSFSharedUtils.paramNull(dlgn0210DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                dlgn0210DAO = (Dlgn0210DAO) wac.getBean("dlgn0210DAO" ); 
            }
            
            if  (MSFSharedUtils.paramNull(dlgn0110DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                dlgn0110DAO = (Dlgn0110DAO) wac.getBean("dlgn0110DAO" ); 
            }
            
            String rrnDecCrypt = "";
            
            for(int iPayrCnt=0;iPayrCnt < listDlgn0210Dto.size();iPayrCnt++) {
            	Dlgn0210DTO dlgn0210Dto = new Dlgn0210DTO();  
            	dlgn0210Dto = listDlgn0210Dto.get(iPayrCnt);
             
            	Dlgn0210VO dlgn0210Vo = new Dlgn0210VO(); 
            	
     
    			
            	dlgn0210Vo.setDpobCd(dlgn0210Dto.getDpobCd());    													/** column 사업장코드 : dpobCd */
            	dlgn0210Vo.setSystemkey(dlgn0210Dto.getSystemkey());    											/** column SYSTEMKEY : systemkey */
            	dlgn0210Vo.setPayCd(dlgn0210Dto.getPayCd());														/** column 급여구분 : payCd */
            	dlgn0210Vo.setDilnlazExceDutyYrMnth(dlgn0210Dto.getDilnlazExceDutyYrMnth().replaceAll("\\.",""));	/** column 근무년월 : detailYm */
            	dlgn0210Vo.setDilnlazApptnDt(dlgn0210Dto.getDilnlazApptnDt().replaceAll("\\.",""));					/** column 근태일자 : dilnlazApptnDt */
            	dlgn0210Vo.setDilnlazDutyStTm(dlgn0210Dto.getDilnlazDutyStTm());									/** column 시작시간 : dilnlazDutyStTm */
            	dlgn0210Vo.setDilnlazDutyEdTm(dlgn0210Dto.getDilnlazDutyEdTm());									/** column 종료시간 : dilnlazDutyEdTm */
            	dlgn0210Vo.setDilnlazTmRstDutyTm(dlgn0210Dto.getDilnlazTmRstDutyTm());								/** column 연장근무시간 : dilnlazTmRstDutyTm */
            	dlgn0210Vo.setDilnlazNtotTm(dlgn0210Dto.getDilnlazNtotTm());										/** column 야간근무시간 : dilnlazNtotTm */
            	dlgn0210Vo.setDilnlazHodyDutyTm(dlgn0210Dto.getDilnlazHodyDutyTm());								/** column 휴일근무시간 : dilnlazHodyDutyTm */
            	dlgn0210Vo.setDilnlazHodyNtotTm(dlgn0210Dto.getDilnlazHodyNtotTm());								/** column 휴일연장근무시간 : dilnlazHodyNtotTm */
            	
            	dlgn0210Vo.setEmymtDivCd(dlgn0210Dto.getEmymtDivCd());    											/** column 고용구분코드 : emymtDivCd */
            	dlgn0210Vo.setDeptCd(dlgn0210Dto.getDeptCd());    													/** column 부서코드 : deptCd */
            	dlgn0210Vo.setBusinCd(dlgn0210Dto.getBusinCd());    												/** column 사업코드 : businCd */
            	dlgn0210Vo.setTypOccuCd(dlgn0210Dto.getTypOccuCd());    											/** column 직종코드 : typOccuCd */
            	dlgn0210Vo.setDtilOccuInttnCd(dlgn0210Dto.getDtilOccuInttnCd());   					 				/** column 직종세구분코드 : dtilOccuInttnCd */
                
               	dlgn0210Vo.setIsmt(sessionUser.getUsrId());
            	dlgn0210Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
            	
            	
            	
            	//TODO 임시로 입력한 근무시간에 대해서만 UPDATE 처리
            	/************************ 이전 신규 로직 ************************/
            	dlgn0210DAO.updateDlgn0210GridTm_02(dlgn0210Vo);
	           	dlgn0210DAO.updateDlgn0210Grid_Yn(dlgn0210Vo);   
	            	
//	         	dlgn0110DAO.updateDlgn0210GridDlgn0110(dlgn0210Vo);   /* 복무기준 재정의전 주석처리 */
	         	/************************ 이전 신규 로직 ************************/
            	
            	
            	InfcPkgDlgn0200VO infcDlgn0200Vo = new InfcPkgDlgn0200VO();
				
				// 3.복호화
//				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(dlgn0210Vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
//				dlgn0210Vo.setResnRegnNum(rrnDecCrypt);
//				
				infcDlgn0200Vo.setIsmt(sessionUser.getUsrId());
				infcDlgn0200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		 
				infcDlgn0200Vo.setDpobCd(dlgn0210Vo.getDpobCd());									/** column 사업장코드 : dpobCd */
				infcDlgn0200Vo.setSystemkey(dlgn0210Vo.getSystemkey());    							/** column SYSTEMKEY : systemkey */
				infcDlgn0200Vo.setDilnlazExceDutyYrMnth(dlgn0210Vo.getDilnlazExceDutyYrMnth());    	/** column 근태년월 : dilnlazYrMnth */
				infcDlgn0200Vo.setPayCd(dlgn0210Vo.getPayCd());										/** column 급여구분코드 : payCd */
				infcDlgn0200Vo.setEmymtDivCd(dlgn0210Vo.getEmymtDivCd());    						/** column 고용구분코드 : emymtDivCd */
				infcDlgn0200Vo.setDeptCd(dlgn0210Vo.getDeptCd());									/** column 부서코드 : deptCd */
				infcDlgn0200Vo.setBusinCd(dlgn0210Vo.getBusinCd());    								/** column 사업코드 : businCd */
				infcDlgn0200Vo.setTypOccuCd(dlgn0210Vo.getTypOccuCd());   							/** column 직종코드 : typOccuCd */
				infcDlgn0200Vo.setDtilOccuInttnCd(dlgn0210Vo.getDtilOccuInttnCd());    				/** column 직종세구분코드 : dtilOccuInttnCd */
				
				
				/****************************************************************************************************
				 * 시간외 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
				 ****************************************************************************************************/
					DlgnListenerAdapter dlgnAdapter = new DlgnListenerAdapter();  
					Long iResult = dlgnAdapter.setUpdateManageDlgn0200HHMiCommuteService(RemoteServiceUtil.getThreadLocalRequest(), infcDlgn0200Vo);
				/****************************************************************************************************
				 * 시간외 분단위 집계 인터페이스 모듈 호출 부분 추가 2017.04.14 ATRES  
		        ****************************************************************************************************/
            }
            
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
            MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
           
            iCnt = iCnt + 1; 
            
            bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","근무실적 업데이트" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(iCnt) + "명처리완료 "));
            rtnData = 1L;
	    
        } catch (Exception ex) {
            	ex.printStackTrace();   
			   ShowMessageBM smBm = new ShowMessageBM();
			   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
			   smBm.setMenu("dlgn");
			   smBm.setPhase("[근무실적]에러");
			   smBm.setMessage(ex.getLocalizedMessage());
			   smBm.setContent(ex.getMessage());
			   bmResult.add(smBm);  
		   
			   /** 에러 로그 **/			
			   MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, "U",ex, windowNm , windowId);
			   ex.printStackTrace();
			   rtnData = 0L;
			   throw MSFServerUtils.getOperationException(this.getClass().getName(), ex, logger);
			   
        }finally {
        
        }
	
        return rtnData;
	
	}
	

	
	
	
		
}