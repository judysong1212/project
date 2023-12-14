package com.app.exterms.personal.server.service;

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

import com.app.exterms.personal.client.dto.Psnl0126DTO;
import com.app.exterms.personal.client.service.PsnlP029001Service;
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
@Service("psnlP029001Service")
public class PsnlP029001ServiceImpl extends AbstractCustomServiceImpl implements PsnlP029001Service, PsnlDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(PsnlP029001ServiceImpl.class);
	private static final String calledClass = PsnlP029001ServiceImpl.class.getName();


	@Autowired
	@Resource(name="psnl0290DAO")
	private Psnl0290DAO psnl0290DAO;

	@Autowired
	@Resource(name="psnl0126DAO")
	private Psnl0126DAO psnl0126DAO;


	public PagingLoadResult<BaseModel> getPsnlP029001DataList(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNLP029001_DATA_LIST;
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
	    	
	    	List<String> listDeptCd = new ArrayList<String>();    
	      	/** 조건절 */
	    	
			//암호화 객체 생성
	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
	    	psnl0126SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	psnl0126SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
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
            
            psnl0126SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            psnl0126SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
	     	
	     	
	        psnl0126SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	      	List<String> lsHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
	      	psnl0126SrhVO.setHdofcCodtnCdArr(lsHdofcCodtnCd);  
	     	psnl0126SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); //재직
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	      	psnl0126SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	     	psnl0126SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	      	psnl0126SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	psnl0126SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));
	     	psnl0126SrhVO.setHodyBgnnDt(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hodyBgnnDt"))); 
	     	psnl0126SrhVO.setHodyEndDt(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hodyEndDt"))); //직종세
	     	
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
	     	List list = psnl0126DAO.selectPsnl0126HolidayCountPsnlP029001(psnl0126SrhVO);
	            
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
	

	//휴가일수산정 업데이트
	@Override
	public Long createPsnlP029001HolidayCount(List<Psnl0126DTO> listPsnl0126Dto) throws MSFException {
		Long result = new Long(1);
        Long iCnt = new Long(0);
        
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

            // 휴가일수관리에서 맞는 시스템일 수 가져와서 시스템일수 UPDATE 처리
            // 없으면 0으로 UPDATE
            for(int iPsnlCnt=0;iPsnlCnt < listPsnl0126Dto.size();iPsnlCnt++) {
                
            	Psnl0126DTO Psnl0126Dto = new Psnl0126DTO(); 
            	Psnl0126DTO returnPsnl0126Dto = new Psnl0126DTO(); 
            	
            	returnPsnl0126Dto = listPsnl0126Dto.get(iPsnlCnt);
            	Psnl0126Dto.setDpobCd(returnPsnl0126Dto.getDpobCd());    		/** column 사업장코드 : dpobCd */
            	Psnl0126Dto.setSystemkey(returnPsnl0126Dto.getSystemkey());    	/** column SYSTEMKEY : systemkey */
            	Psnl0126Dto.setHodyApptnYr(returnPsnl0126Dto.getHodyApptnYr());
            	Psnl0126Dto.setHodyNumDysSysCalc(MSFSharedUtils.defaultNulls(returnPsnl0126Dto.getHodyNumDysSysCalc(), "0"));	/** 휴가일수_시스템 계산 HODY_NUM_DYS_SYS_CALC */
            	Psnl0126Dto.setIsmt(sessionUser.getUsrId());    												/** column 수정자 : ismt */
            	Psnl0126Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */
        
                psnl0126DAO.updatePsnlP029001ToPsnl0126_hodyNumDysSysCalc(returnPsnl0126Dto); 
                
                iCnt = iCnt + 1; 
                     
            } 
            result = iCnt; 
          
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling createPsnlP029001HolidayCount(): "+ex); 
            
            result = new Long(0);
            throw MSFServerUtils.getOperationException("createPsnlP029001HolidayCount", ex, logger);
        }
        finally {
          
        }
        
        return result;

	}
	

}
