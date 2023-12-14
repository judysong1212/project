package com.app.exterms.personal.server.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import com.app.exterms.personal.client.dto.Psnl0126DTO;
import com.app.exterms.personal.client.dto.Psnl0290DTO;
import com.app.exterms.personal.client.service.Psnl0290Service;
import com.app.exterms.personal.server.service.dao.Psnl0126DAO;
import com.app.exterms.personal.server.service.dao.Psnl0290DAO;
import com.app.exterms.personal.server.vo.Psnl0126SrhVO;
import com.app.exterms.personal.server.vo.Psnl0126VO;
import com.app.exterms.personal.shared.PsnlDaoConstants;
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
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

/**
 * @Class Name : Psnl0290ServiceImpl.java
 * @Description : Psnl0290S Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@SuppressWarnings("serial")
@Service("psnl0290Service")
public class Psnl0290ServiceImpl extends AbstractCustomServiceImpl implements Psnl0290Service, PsnlDaoConstants {
	
	 private static final Logger logger = LoggerFactory.getLogger(Psnl0290ServiceImpl.class);
	 private static final String calledClass = Psnl0290ServiceImpl.class.getName();
	  
	@Autowired
    @Resource(name="psnl0290DAO")
    private Psnl0290DAO psnl0290DAO;
	
	@Autowired
    @Resource(name="psnl0126DAO")
    private Psnl0126DAO psnl0126DAO;
	
	//조회
	public PagingLoadResult<BaseModel> getPsnl0126DataList(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0126_DATA_LIST;
		Psnl0126SrhVO   psnl0126SrhVO = new Psnl0126SrhVO();
		Psnl0126VO      psnl0126VO = new Psnl0126VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
//		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(psnl0126DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			psnl0126DAO = (Psnl0126DAO) wac.getBean("psnl0126DAO" ); 
		}
	        
		try {
			//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
			ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();		
			PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			//Get paging configuration
	    	PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	    	//Get query parameters
	      	//String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	    	
	    	List<String> listDeptCd = new ArrayList<String>();    
	      	/** 조건절 */
	    	
			//암호화 객체 생성
	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
//	    	psnl0126SrhVO.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "resnRegnNum")).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	//주민번호
		
	    	psnl0126SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	psnl0126SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")));
	    	psnl0126SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	    	psnl0126SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")));       //호봉제 구분
//	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
	     	
	    	psnl0126SrhVO.setUsrId(sessionUser.getUsrId());
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	psnl0126SrhVO.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
               psnl0126SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	psnl0126SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
                     if (psnl0126SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	psnl0126SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	 psnl0126SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
            }
            
//            } else {
//            	
//            }
            
            psnl0126SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            psnl0126SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
	     	
	     	
	        psnl0126SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	        
	        
	        
	      	List<String> lsHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
	      	psnl0126SrhVO.setHdofcCodtnCdArr(lsHdofcCodtnCd);  
	     	psnl0126SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); //재직
	        
	            
//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	     	psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//	      	psnl0126SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	      	psnl0126SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	     	psnl0126SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	     	psnl0126SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	     	psnl0126SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	      	psnl0126SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	psnl0126SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	     	
	    	psnl0126SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	           
	    	psnl0126SrhVO.setHodyApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hodyApptnYr"))); 	//년도
	       	psnl0126SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  		//시스템키
	      	psnl0126SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    			//한글성명 
	      	psnl0126SrhVO.setHodyFixYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hodyFixYn")));		//확정여부  
	      	
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	          	int iResultCnt = psnl0126DAO.selectPsnl0126ListTotCnt(psnl0126SrhVO);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0126DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	psnl0126SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		psnl0126SrhVO.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		psnl0126SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = psnl0126DAO.selectPsnl0126List(psnl0126SrhVO);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {
				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = map.get("systemkey").toString();
	        	BaseModel bm = new BaseModel();
	        	
	        	// 주민번호
	 
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
	            	
	          		case ColumnDef.TYPE_STRING: 
	          			
	          			
	          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
   			
	          		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	          			
	          			String rrnDecCrypt = "";
	          			
	          			// TODO 주민번호
//						System.out.print("aaaaaa : " + psnl0126SrhVO.getResnRegnNum() );
//						nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getPsnl0126DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}



	//수정삭제
	@Override
	public Long activityOnPsnl0126(List<Psnl0126DTO> listPsnl0126dto, ActionDatabase actionDatabase) throws MSFException {
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		
		String method = calledClass + ".activityOnPsnl0126";
		
		String windowNm = "휴가일수산정";
		String windowId = "PSNL0290";
		
		MSFSysm0100BM sessionUser;
		
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		try {  
			if (MSFSharedUtils.paramNull(psnl0126DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                psnl0126DAO = (Psnl0126DAO) wac.getBean("psnl0126DAO" ); 
			}
	            
			for(int iPsnlCnt=0;iPsnlCnt < listPsnl0126dto.size();iPsnlCnt++) {
	                
				Psnl0126DTO psnl0126Dto = new Psnl0126DTO();  
				psnl0126Dto = listPsnl0126dto.get(iPsnlCnt);
	                 
	            Psnl0126VO psnl0126Vo = new Psnl0126VO();  

	           	psnl0126Vo.setDpobCd(psnl0126Dto.getDpobCd());    															/** column 사업장코드 : dpobCd */
	           	psnl0126Vo.setResnRegnNum(psnl0126Dto.getResnRegnNum());													/** column 주민등록번호 : ResnRegnNum */
	           	psnl0126Vo.setSystemkey(psnl0126Dto.getSystemkey());    													/** column SYSTEMKEY : systemkey */
	           	psnl0126Vo.setHodyApptnYr(psnl0126Dto.getHodyApptnYr());													/** 휴가적용년도 HODY_APPTN_YR */
	            psnl0126Vo.setLvsgCoptnCstApptnYn((Boolean.TRUE.equals(psnl0126Dto.getLvsgCoptnCstApptnYn()) ? "Y" : "N"));	/** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */
	            psnl0126Vo.setLvsgCoptnCstApptnDt(psnl0126Dto.getLvsgCoptnCstApptnDt());									/** 연가보상비적용일자 LVSG_COPTN_CST_APPTN_DT */
	          	psnl0126Vo.setHodyNumDysSysCalc(MSFSharedUtils.defaultNulls(psnl0126Dto.getHodyNumDysSysCalc(), "0"));		/** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
	         	
	          	
	          	psnl0126Vo.setHodyApptnNumDys(MSFSharedUtils.defaultNulls(psnl0126Dto.getHodyApptnNumDys(), "0"));			/** 휴가적용일수 HODY_APPTN_NUM_DYS */
	         	psnl0126Vo.setSpclHodyNumDys(MSFSharedUtils.defaultNulls(psnl0126Dto.getSpclHodyNumDys(), "0"));			/** 특별휴가일수  spclHodyNumDys */
	         	psnl0126Vo.setHodyUseNumDys(MSFSharedUtils.defaultNulls(psnl0126Dto.getHodyUseNumDys(), "0"));				/** 휴가사용일수 HODY_USE_NUM_DYS */
	         	psnl0126Vo.setSpclHodyUseDys(MSFSharedUtils.defaultNulls(psnl0126Dto.getSpclHodyUseDys(), "0"));			/** 특별휴가사용일수 SPCL_HODY_USE_DYS */
//	         	psnl0126Vo.setHodyRstNumDys(MSFSharedUtils.defaultNulls((psnl0126Dto.getHodyApptnNumDys() + psnl0126Dto.getSpclHodyNumDys()) - psnl0126Dto.getHodyUseNumDys(), "0"));
	         	psnl0126Vo.setHodyRstNumDys(MSFSharedUtils.defaultNulls(psnl0126Dto.getHodyRstNumDys(), "0"));				/** 휴가잔여일수 HODY_RST_NUM_DYS */
	         	
	          	psnl0126Vo.setHodyNoteCtnt(psnl0126Dto.getHodyNoteCtnt()); 													/** 휴가비고내용 HODY_NOTE_CTNT */
	          	psnl0126Vo.setHodyBgnnDt(psnl0126Dto.getHodyBgnnDt()); 														/** 휴가시작일자 HODY_BGNN_DT */
	          	psnl0126Vo.setHodyEndDt(psnl0126Dto.getHodyEndDt()); 														/** 휴가종료일자 HODY_END_DT */
	          	psnl0126Vo.setHodyFixYn((Boolean.TRUE.equals(psnl0126Dto.getHodyFixYn()) ? "Y" : "N"));						/** 휴가확정여부 HODY_FIX_YN */ 
	          	psnl0126Vo.setHodyFixDt(psnl0126Dto.getHodyFixDt());
	          	
	          	psnl0126Vo.setIsmt(sessionUser.getUsrId());    											/** column 수정자 : ismt */
	          	psnl0126Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 수정주소 : revnAddr */
	          	
	          	
	          	
	                      
	        	switch (actionDatabase) {
	        		case INSERT:
	        			
	        			psnl0126Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
	    	          	psnl0126Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
	    	          	
	        			psnl0126DAO.insertPsnl0126(psnl0126Vo); 
	        			break;
	            	case UPDATE: 
	            		psnl0126DAO.updatePsnl0126(psnl0126Vo); 
	            		break;
	            	case DELETE: 
	            		psnl0126DAO.deletePsnl0126(psnl0126Vo); 
	            		break;
	        	} 
	        	
	        	iCnt = iCnt + 1; 
	                    
			} 
			result = iCnt;
	          
	        } catch (Exception ex) {
	        	
	        	
	        	ex.printStackTrace();
	        	/** 에러 로그 **/			
	        	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),ex, windowNm , windowId);
	        	
	            logger.error("EXCEPTION calling activityOnPsnl0126(): "+ex); 
	            
	            result = new Long(0);
	            throw MSFServerUtils.getOperationException("activityOnPsnl0126", ex, logger);
	        } finally {
	          
	        }
		
		/** 로그반영
		 * CRUDSBLO
		 * C   //create  
    	 * R   //read
    	 * U   //update
    	 * D   //delete
    	 * S   //select
    	 * B   //배치 
    	 * L   //로그인 
    	 * O   //로그아웃
    	 */
    	MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
    	
		return result;
	}
	
	//휴가일수생성 리스트
	@Override
    public Long createPsnl0126HolidayCount(HashMap<String, String> param, ActionDatabase actionDatabase) throws MSFException {
        Long result = new Long(1);
        Long iCnt = new Long(0);
        
        Psnl0126SrhVO   psnl0126SrhVO = new Psnl0126SrhVO();
        MSFSysm0100BM sessionUser;
     
        if (RemoteServiceUtil.getThreadLocalRequest() != null) {
              sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        } else {
            sessionUser = getUser();
        }
        
        try {  
            
            if  (MSFSharedUtils.paramNull(psnl0126DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                psnl0126DAO = (Psnl0126DAO) wac.getBean("psnl0126DAO" ); 
            }
            
             
            /** 조건절 */
            
            psnl0126SrhVO.setDpobCd(sessionUser.getDpobCd()); 
            psnl0126SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
            
	    	List<String> listDeptCd = new ArrayList<String>();    
//	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
	     	
	    	psnl0126SrhVO.setUsrId(sessionUser.getUsrId());
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	psnl0126SrhVO.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
               psnl0126SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	psnl0126SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd")))) ;   //단위기관코드   
                     if (psnl0126SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) { 
                     	 listDeptCd = null; 
                     	psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	psnl0126SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	 psnl0126SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFSharedUtils.allowNulls(param.get("deptCd"))));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
                          psnl0126SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
            }
            
//            } else {
//            	
//            }
            
            psnl0126SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가  
            psnl0126SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
            
            
            
            psnl0126SrhVO.setHodyApptnYr(MSFSharedUtils.allowNulls(param.get("hodyApptnYr"))); 	//지급년
            
            psnl0126SrhVO.setHodyBgnnDt(MSFSharedUtils.allowNulls(param.get("hodyBgnnDt")));	//시작일자 
            psnl0126SrhVO.setHodyEndDt(MSFSharedUtils.allowNulls(param.get("hodyEndDt")));   	//종료일자 
            
//            psnl0126SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd")));	//단위기관코드
            
            psnl0126SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("emymtDivCd")));       		//고용구분코드
            
//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));  
//            psnl0126SrhVO.setDeptCdArr(listDeptCd);	//부서코드 
            psnl0126SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));	//부서코드
            
            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
            psnl0126SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
            psnl0126SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("typOccuCd")));  //직종
            
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
            psnl0126SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            psnl0126SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); //직종세
           
//            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
//            psnl0126SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//            psnl0126SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
             
            psnl0126SrhVO.setBusinCd(MSFSharedUtils.allowNulls(param.get("businCd")));   //사업코드 
            psnl0126SrhVO.setSystemkey(MSFSharedUtils.allowNulls(param.get("systemkey")));  //시스템키
            psnl0126SrhVO.setHanNm(MSFSharedUtils.allowNulls(param.get("hanNm")));    //한글성명 
           
            psnl0126SrhVO.setHodyFixYn(MSFSharedUtils.allowNulls(param.get("hodyFixYn")) );//확정여부
            
            @SuppressWarnings("unchecked")
//          Collection<Map<String, Object>> list ??????
            List<Psnl0126VO> listPsnl0126 =  psnl0126DAO.selectPsnl0126HolidayCount(psnl0126SrhVO);
            
            // 휴가일수관리에서 맞는 시스템일 수 가져와서 시스템일수 UPDATE 처리
            // 없으면 0으로 UPDATE
            for(int iPsnlCnt=0;iPsnlCnt < listPsnl0126.size();iPsnlCnt++) {
                
            	Psnl0126VO psnl0126VO = new Psnl0126VO(); 
            	Psnl0126VO returnPsnl0126VO = new Psnl0126VO(); 
            	
            	returnPsnl0126VO = listPsnl0126.get(iPsnlCnt);
                psnl0126VO.setDpobCd(returnPsnl0126VO.getDpobCd());    		/** column 사업장코드 : dpobCd */
                psnl0126VO.setSystemkey(returnPsnl0126VO.getSystemkey());    	/** column SYSTEMKEY : systemkey */
                psnl0126VO.setHodyApptnYr(returnPsnl0126VO.getHodyApptnYr());
//                psnl0126VO.setHodyApptnYr(psnl0126VO.getHodyApptnYr());	/** 휴가적용년도 HODY_APPTN_YR */
//                psnl0126VO.setLvsgCoptnCstApptnYn((Boolean.TRUE.equals(psnl0126VO.getLvsgCoptnCstApptnYn()) ? "Y" : "N"));	/** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */
                
                
                psnl0126VO.setHodyNumDysSysCalc(MSFSharedUtils.defaultNulls(returnPsnl0126VO.getHodyNumDys(), "0"));	/** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
//                psnl0126VO.setHodyApptnNumDys(MSFSharedUtils.defaultNulls(psnl0126VO.getHodyApptnNumDys(), "0"));			/** 휴가적용일수 HODY_APPTN_NUM_DYS */
//                psnl0126VO.setHodyUseNumDys(MSFSharedUtils.defaultNulls(psnl0126VO.getHodyUseNumDys(), "0"));				/** 휴가사용일수 HODY_USE_NUM_DYS */
//                psnl0126VO.setHodyRstNumDys(MSFSharedUtils.defaultNulls(psnl0126VO.getHodyRstNumDys(), "0"));				/** 휴가잔여일수 HODY_RST_NUM_DYS */
//                psnl0126VO.setHodyNoteCtnt(psnl0126VO.getHodyNoteCtnt()); 	/** 휴가비고내용 HODY_NOTE_CTNT */
//                psnl0126VO.setHodyBgnnDt(psnl0126VO.getHodyBgnnDt()); 		/** 휴가시작일자 HODY_BGNN_DT */
//                psnl0126VO.setHodyEndDt(psnl0126VO.getHodyEndDt()); 		/** 휴가종료일자 HODY_END_DT */
//                psnl0126VO.setHodyFixYn((Boolean.TRUE.equals(psnl0126VO.getHodyFixYn()) ? "Y" : "N"));	/** 휴가확정여부 HODY_FIX_YN */
//                psnl0126VO.setHodyFixDt(psnl0126VO.getHodyFixDt());			/** 휴가확정일자 HODY_FIX_DT */
                
                psnl0126VO.setIsmt(sessionUser.getUsrId());    												/** column 수정자 : ismt */
	          	psnl0126VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */
        
                psnl0126DAO.updatePsnl0126_hodyNumDysSysCalc(psnl0126VO); 
                
                iCnt = iCnt + 1; 
                     
            } 
            result = iCnt; 
          
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling createPsnl0126HolidayCount(): "+ex); 
            
            result = new Long(0);
            throw MSFServerUtils.getOperationException("createPsnl0126HolidayCount", ex, logger);
        }
        finally {
          
        }
        
        return result;
    }
	
	
	//마감 마감풀기
	@Override
	public Long finishOnPsnl0126(List<Psnl0126DTO> listPsnl0126dto, ActionDatabase actionDatabase) throws MSFException {
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		
		try {  
			
			MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			
			if (MSFSharedUtils.paramNull(psnl0126DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                psnl0126DAO = (Psnl0126DAO) wac.getBean("psnl0126DAO" ); 
			}
	            
			for(int iPsnlCnt=0;iPsnlCnt < listPsnl0126dto.size();iPsnlCnt++) {
	                
				Psnl0126DTO psnl0126Dto = new Psnl0126DTO();  
				psnl0126Dto = listPsnl0126dto.get(iPsnlCnt);
	                 
	            Psnl0126VO psnl0126Vo = new Psnl0126VO();  

	           	psnl0126Vo.setDpobCd(psnl0126Dto.getDpobCd());    			/** column 사업장코드 : dpobCd */
	           	psnl0126Vo.setSystemkey(psnl0126Dto.getSystemkey());    	/** column SYSTEMKEY : systemkey */
	           	psnl0126Vo.setHodyApptnYr(psnl0126Dto.getHodyApptnYr());	/** 휴가적용년도 HODY_APPTN_YR */
//	            psnl0126Vo.setLvsgCoptnCstApptnYn((Boolean.TRUE.equals(psnl0126Dto.getLvsgCoptnCstApptnYn()) ? "Y" : "N"));		/** 연가보상비적용여부 LVSG_COPTN_CST_APPTN_YN */
//	          	psnl0126Vo.setHodyNumDysSysCalc(MSFSharedUtils.defaultNulls(psnl0126Dto.getHodyNumDysSysCalc(), "0"));	/** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
//	         	psnl0126Vo.setHodyApptnNumDys(MSFSharedUtils.defaultNulls(psnl0126Dto.getHodyApptnNumDys(), "0"));		/** 휴가적용일수 HODY_APPTN_NUM_DYS */
//	         	psnl0126Vo.setHodyUseNumDys(MSFSharedUtils.defaultNulls(psnl0126Dto.getHodyUseNumDys(), "0"));			/** 휴가사용일수 HODY_USE_NUM_DYS */
//	          	psnl0126Vo.setHodyRstNumDys(MSFSharedUtils.defaultNulls(psnl0126Dto.getHodyRstNumDys(), "0"));			/** 휴가잔여일수 HODY_RST_NUM_DYS */
//	          	psnl0126Vo.setHodyNoteCtnt(psnl0126Dto.getHodyNoteCtnt()); 	/** 휴가비고내용 HODY_NOTE_CTNT */
//	          	psnl0126Vo.setHodyBgnnDt(psnl0126Dto.getHodyBgnnDt()); 		/** 휴가시작일자 HODY_BGNN_DT */
//	          	psnl0126Vo.setHodyEndDt(psnl0126Dto.getHodyEndDt()); 		/** 휴가종료일자 HODY_END_DT */
//	          	psnl0126Vo.setHodyFixYn((Boolean.TRUE.equals(psnl0126Dto.getHodyFixYn()) ? "Y" : "N"));	/** 휴가확정여부 HODY_FIX_YN */ 
//	          	psnl0126Vo.setHodyFixDt(psnl0126Dto.getHodyFixDt());
	          	
	          	
	          	psnl0126Vo.setIsmt(sessionUser.getUsrId());    												/** column 수정자 : ismt */
	          	psnl0126Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */
	                      
	        	switch (actionDatabase) {
	        		case INSERT:
	        			
	        			psnl0126Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */
	    	          	psnl0126Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  /** column 입력주소 : inptAddr */
	    	          	
	        			psnl0126Vo.setHodyFixYn("Y");														/** 휴가확정여부 HODY_FIX_YN */ 
	    	          	psnl0126Vo.setHodyFixDt(psnl0126Dto.getHodyFixDt());								/** 휴가마감일자 HODY_FIX_DT */ 
	    	          	psnl0126DAO.updatePsnl0126(psnl0126Vo); 
//	        			psnl0126DAO.insertPsnl0126(psnl0126Vo); 
	        			break;
	            	case UPDATE: 
//	            		psnl0126Vo.setHodyFixYn("Y");	/** 휴가확정여부 HODY_FIX_YN */ 
//	    	          	psnl0126Vo.setHodyFixDt(psnl0126Dto.getHodyFixDt());/** 휴가마감일자 HODY_FIX_DT */ 
//	            		psnl0126DAO.updatePsnl0126(psnl0126Vo); 
	            		break;
	            	case DELETE: 
	            		psnl0126Vo.setHodyFixYn("N");						/** 휴가확정여부 HODY_FIX_YN */ 
	            		psnl0126Vo.setHodyFixDt("");						/** 휴가확정여부 HODY_FIX_YN */ 
	    	          	psnl0126DAO.updatePsnl0126(psnl0126Vo); 
//	            		psnl0126DAO.deletePsnl0126(psnl0126Vo); 
	            		break;
	        	} 
	        		iCnt = iCnt + 1; 
	                    
			} 
			result = iCnt;
	          
	        } catch (Exception ex) {
	            logger.error("EXCEPTION calling finishOnPsnl0126(): "+ex); 
	            
	            result = new Long(0);
	            throw MSFServerUtils.getOperationException("finishOnPsnl0126", ex, logger);
	        }
	        finally {
	          
	        }
		return result;
	}
	
	
//	//수정삭제
//	@Override
//	public Psnl0126DTO activityChangePsnl0126(Psnl0126DTO psnl0126dto) throws MSFException {
//		// TODO Auto-generated method stub
//			
//		try {  
//        
//				Psnl0126DTO psnl0126Dto = new Psnl0126DTO();  
//		                 
//				Psnl0126VO psnl0126Vo = new Psnl0126VO();  
//
////		        psnl0126Vo.setDpobCd(psnl0126Dto.getDpobCd());    			/** column 사업장코드 : dpobCd */
////		        psnl0126Vo.setSystemkey(psnl0126Dto.getSystemkey());    	/** column SYSTEMKEY : systemkey */
////		        psnl0126Vo.setHodyApptnYr(psnl0126Dto.getHodyApptnYr());	/** 휴가적용년도 HODY_APPTN_YR */
//		        Double douHodyApptnNumDys = psnl0126Dto.getHodyApptnNumDys();
//		        Double doHodyUseNumDys = psnl0126Dto.getHodyUseNumDys();
//		        
//		        psnl0126Vo.setHodyApptnNumDys(MSFSharedUtils.defaultNulls(psnl0126Dto.getHodyApptnNumDys(), "0"));		/** 휴가적용일수 HODY_APPTN_NUM_DYS */
//		    	psnl0126Vo.setHodyUseNumDys(MSFSharedUtils.defaultNulls(psnl0126Dto.getHodyUseNumDys(), "0"));			/** 휴가사용일수 HODY_USE_NUM_DYS */
//		    	psnl0126Vo.setHodyRstNumDys(MSFSharedUtils.defaultNulls(douHodyApptnNumDys - doHodyUseNumDys, "0"));			/** 휴가잔여일수 HODY_RST_NUM_DYS */
//		                      
//		        } catch (Exception ex) {
//		            logger.error("EXCEPTION calling activityChangePsnl0126(): "+ex); 
//		            
//		            throw MSFServerUtils.getOperationException("activityChangePsnl0126", ex, logger);
//		        }
//		        finally {
//		          
//		        }
//			return psnl0126dto;
//		}
	

	@SuppressWarnings("rawtypes")
	@Override
	public BaseListLoadResult<Psnl0290DTO> selectPsnl0290(
			BaseListLoadConfig config, Psnl0290DTO psnl0290DTO) throws MSFException {
		// TODO Auto-generated method stub
		List<Psnl0290DTO> returnValue = new ArrayList<Psnl0290DTO>();
		List egovResultDataList = new ArrayList();
		
		String method = calledClass + ".selectPsnl0290";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		String windowNm = "휴가일수산정";
		String windowId = "PSNL0290";
		
		try{
			
			egovResultDataList = psnl0290DAO.selectPsnl0290(psnl0290DTO);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0290DTO dto = new Psnl0290DTO();
					Map tempMap = (Map)egovResultDataList.get(i);
					@SuppressWarnings("unchecked")
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
					returnValue.add(dto);
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
		
		return new BaseListLoadResult<Psnl0290DTO>(returnValue);	
	}

	

	@Override
	public String insertPsnl0290(List<Psnl0290DTO> list) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePsnl0290(List<Psnl0290DTO> list) throws Exception {
		// TODO Auto-generated method stub
		int returnVal = 0;
		for(Psnl0290DTO dto : list){
			System.out.println(dto.getHodyFixYn());
			if("N".equals(dto.getHodyFixYn())){
				psnl0290DAO.updatePsnl0290(dto);
				returnVal++;
			}
		}
		
		return returnVal;
	}


	@Override
	public int deletePsnl0290(List<Psnl0290DTO> list) throws Exception {
		// TODO Auto-generated method stub
		int returnVal = 0;
		for(Psnl0290DTO dto : list){
			if("N".equals(dto.getHodyFixYn())){
				psnl0290DAO.deletePsnl0290(dto);
				returnVal++;
			}
		}
		return returnVal;
	}



	@Override
	public int updatePsnl0290FixY(List<Psnl0290DTO> list) throws Exception {
		int returnVal = 0;
		for(Psnl0290DTO dto : list){
			dto.setHodyFixYn("Y");
			psnl0290DAO.updatePsnl0290Fix(dto);
			returnVal++;
		}
		
		return returnVal;
	}



	@Override
	public int updatePsnl0290FixN(List<Psnl0290DTO> list) throws Exception {
		int returnVal = 0;
		for(Psnl0290DTO dto : list){
			dto.setHodyFixYn("N");
			psnl0290DAO.updatePsnl0290Fix(dto);
			returnVal++;
		}
		
		return returnVal;
	}
	
	
}
