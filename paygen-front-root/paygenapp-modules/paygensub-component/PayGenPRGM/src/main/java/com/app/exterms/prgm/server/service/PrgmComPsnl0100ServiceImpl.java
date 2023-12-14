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
import com.app.exterms.prgm.client.service.PrgmComPsnl0100Service;
import com.app.exterms.prgm.server.service.dao.PrgmComPayr0304DAO;
import com.app.exterms.prgm.server.service.dao.PrgmComPsnl0100DAO;
import com.app.exterms.prgm.server.utils.PrgmComServerUtils;
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
@Service("PrgmComPsnl0100Service")  
public class PrgmComPsnl0100ServiceImpl extends AbstractCustomServiceImpl implements PrgmComDaoConstants,PrgmComPsnl0100Service {

	private static final Logger logger = LoggerFactory.getLogger(PrgmComBass0500ServiceImpl.class);

	public PrgmComPsnl0100ServiceImpl() {
	
	}
	    
	@Autowired
    @Resource(name="PrgmComPsnl0100DAO")
    private PrgmComPsnl0100DAO psnl0100DAO;
    

	public PagingLoadResult<BaseModel> getPrgmComPopupPsnl0100List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  PRGMCOM_METHOD_POPUP_PSNL0100_List;
        PrgmComSearchVO   sysComSrhVo = new PrgmComSearchVO();
        PrgmComPsnl0100VO sysComPsnl0100Vo = new PrgmComPsnl0100VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        //암호화 추가 처리 함. 
        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(psnl0100DAO)) {
//        
//        	WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//        	psnl0100DAO = (PrgmComPsnl0100DAO) wac.getBean("PrgmComPsnl0100DAO" ); 
//        }
        
        psnl0100DAO = (PrgmComPsnl0100DAO)BeanFinder.getBean("PrgmComPsnl0100DAO");
        
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
            sysComSrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
            sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
            sysComSrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
            sysComSrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
          //  sysComSrhVo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsDivCd"))); 
            sysComSrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드  
            sysComSrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            sysComSrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
            sysComSrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));    //재직상
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	            if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = psnl0100DAO.selectPsnl0100ListTotCnt(sysComSrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPsnl0100List = SmrmfUtils.startTiming(logger);
        
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
//            Collection<Map<String, Object>> list  
            List list = psnl0100DAO.selectPsnl0100List(sysComSrhVo);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPsnl0100List, "selectPsnl0100List");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	/**
	 * PSNL0100을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Psnl0100VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    public String insertPsnl0100(PrgmComPsnl0100VO vo) throws Exception {
    	logger.debug(vo.toString());
    	
    	/** ID Generation Service */
    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
    	//String id = egovIdGnrService.getNextStringId();
    	//vo.setId(id);
    	logger.debug(vo.toString());
    	
    	psnl0100DAO.insertPsnl0100(vo);
    	//TODO 해당 테이블 정보에 맞게 수정    	
        return null;
    }

    /**
	 * PSNL0100을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Psnl0100VO
	 * @return void형
	 * @exception Exception
	 */
    public void updatePsnl0100(PrgmComPsnl0100VO vo) throws Exception {
        psnl0100DAO.updatePsnl0100(vo);
    }

    /**
	 * PSNL0100을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Psnl0100VO
	 * @return void형 
	 * @exception Exception
	 */
    public void deletePsnl0100(PrgmComPsnl0100VO vo) throws Exception {
        psnl0100DAO.deletePsnl0100(vo);
    }

    /**
	 * PSNL0100을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Psnl0100VO
	 * @return 조회한 PSNL0100
	 * @exception Exception
	 */
    public PrgmComPsnl0100VO selectPsnl0100(PrgmComPsnl0100VO vo) throws Exception {
        PrgmComPsnl0100VO resultVO = psnl0100DAO.selectPsnl0100(vo);
//        if (resultVO == null)
//            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * PSNL0100 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PSNL0100 목록
	 * @exception Exception
	 */
    public List selectPsnl0100List(PrgmComSearchVO searchVO) throws Exception {
        return psnl0100DAO.selectPsnl0100List(searchVO);
    }

    /**
	 * PSNL0100 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return PSNL0100 총 갯수
	 * @exception
	 */
    public int selectPsnl0100ListTotCnt(PrgmComSearchVO searchVO) {
		return psnl0100DAO.selectPsnl0100ListTotCnt(searchVO);
	}
    
    
   /**
    * 퇴직정산 대상자 선택 멀티건 처리 
    * 
    * @param serviceParameters
    * @return
    * @throws MSFException
    */
	public PagingLoadResult<BaseModel> getPrgmComPopupRemtPsnl0100List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  PRGMCOM_METHOD_POPUP_REMT_PSNL0100_List;
        PrgmComSearchVO   sysComSrhVo = new PrgmComSearchVO();
        PrgmComPsnl0100VO sysComPsnl0100Vo = new PrgmComPsnl0100VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        //암호화 추가 처리 함. 
        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(psnl0100DAO)) {
//        
//        	WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//        	psnl0100DAO = (PrgmComPsnl0100DAO) wac.getBean("PrgmComPsnl0100DAO" ); 
//        }
        
        psnl0100DAO = (PrgmComPsnl0100DAO)BeanFinder.getBean("PrgmComPsnl0100DAO");
        
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
            sysComSrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
            

            sysComSrhVo.setRetryDt01(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "retryDt01")));     //시작일자
            sysComSrhVo.setRetryDt02(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "retryDt02")));     //종료일자
            
            sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
            sysComSrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
            sysComSrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
          //  sysComSrhVo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsDivCd"))); 
            sysComSrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드  
            sysComSrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            sysComSrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
            sysComSrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));    //재직상
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	            if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = psnl0100DAO.selectRemtPsnl0100ListTotCnt(sysComSrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectRemtPsnl0100List = SmrmfUtils.startTiming(logger);
        
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
//            Collection<Map<String, Object>> list  
            List list = psnl0100DAO.selectRemtPsnl0100List(sysComSrhVo);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectRemtPsnl0100List, "selectRemtPsnl0100List");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	 /**
	    * 4대보험 대상자 선택 멀티건 처리 
	    * 
	    * @param serviceParameters
	    * @return
	    * @throws MSFException
	    */
		public PagingLoadResult<BaseModel> getPrgmComPopupInsrPsnl0100List(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  PRGMCOM_METHOD_POPUP_REMT_PSNL0100_List;
	        PrgmComSearchVO   sysComSrhVo = new PrgmComSearchVO();
	        PrgmComPsnl0100VO sysComPsnl0100Vo = new PrgmComPsnl0100VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        //암호화 추가 처리 함. 
	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
//	        if  (MSFSharedUtils.paramNull(psnl0100DAO)) {
//	        
//	        	WebApplicationContext wac = WebApplicationContextUtils.
//	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//	        	psnl0100DAO = (PrgmComPsnl0100DAO) wac.getBean("PrgmComPsnl0100DAO" ); 
//	        }
	        
	        psnl0100DAO = (PrgmComPsnl0100DAO)BeanFinder.getBean("PrgmComPsnl0100DAO");
	        
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
	            sysComSrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            
	            sysComSrhVo.setEmymtBgnnDt01(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtBgnnDt01")));     //시작일자
	            sysComSrhVo.setEmymtBgnnDt02(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtBgnnDt02")));     //종료일자
	            
	            sysComSrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
	            sysComSrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
	          //  sysComSrhVo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsDivCd"))); 
	            sysComSrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드  
	            sysComSrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            sysComSrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	            sysComSrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));    //재직상
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		        if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = psnl0100DAO.selectInsrPsnl0100ListTotCnt(sysComSrhVo);  
	              
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginSelectRemtPsnl0100List = SmrmfUtils.startTiming(logger);
	        
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
//	            Collection<Map<String, Object>> list  
	            List list = psnl0100DAO.selectInsrPsnl0100List(sysComSrhVo);
	            
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginSelectRemtPsnl0100List, "selectRemtPsnl0100List");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }
		
	     // 휴가일수산정 대상자 조회 
	      public PagingLoadResult<BaseModel> getPsnl0100ToPsnl0126DataList(ServiceParameters serviceParameters) throws MSFException {

	          PagingLoadResult<BaseModel> retval = null;
	          String method =  "getPsnl0100ToPsnl0126DataList";
	          PrgmComSearchVO   sysComSearchVo = new PrgmComSearchVO();
	          PrgmComPsnl0100VO      sysComPsnl0100Vo = new PrgmComPsnl0100VO();
	          List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	          //암호화 추가 처리 함. 
	          String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	          
	          MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	          
//	          if  (MSFSharedUtils.paramNull(psnl0100DAO)) {
//	          
//	              WebApplicationContext wac = WebApplicationContextUtils.
//	                      getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//	              psnl0100DAO = (PrgmComPsnl0100DAO) wac.getBean("PrgmComPsnl0100DAO" ); 
//	          }
	          
	          psnl0100DAO = (PrgmComPsnl0100DAO)BeanFinder.getBean("PrgmComPsnl0100DAO");
	          
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
	              List<String> listDeptCd = new ArrayList<String>();
	              /** 조건절 */
	              sysComSearchVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	              sysComSearchVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	              sysComSearchVo.setUsrId(sessionUser.getUsrId()); 
	              /******************************** 권한 ************************************************************************/
	              String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	              sysComSearchVo.setPayrMangeDeptCd(sessionUser.getPayrMangDeptCd()) ;   //단위기관코드
	        	  sysComSearchVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()) ;   //단위기관코드
	              if ("FALSE".equals(chkDeptCd)) {
	            	  
	          	      if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
	       			 
	          	    	 sysComSearchVo.setDeptCd(sessionUser.getDeptCd()); 
		                 listDeptCd.add( sessionUser.getDeptCd() );
		                 sysComSearchVo.setDeptCdArr(listDeptCd);     //부서코드  
		                 
	            	  } else {
	            		  sysComSearchVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
	                        listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                        sysComSearchVo.setDeptCdArr(listDeptCd);     //부서코드   
	            		 
	            	  }  
	          	     
	                 sysComSearchVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
	              } else {  
	            	  
	                   if (sysComSearchVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                       listDeptCd = null; 
	                       sysComSearchVo.setDeptCdArr(listDeptCd);     //부서코드 
	                       sysComSearchVo.setDeptCd("");  //부서코드
	                   } else {
	                	   sysComSearchVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
	                        listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                        sysComSearchVo.setDeptCdArr(listDeptCd);     //부서코드   
	                   } 
	                    
	              } 
	              sysComSearchVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	              sysComSearchVo.setDtilOccuInttnCdAuth("");
	              /******************************** 권한 ************************************************************************/ 
	              
	              sysComSearchVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	              
	              List<String> lstTypeOccuCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	              sysComSearchVo.setTypOccuCdArr(lstTypeOccuCd); 
	              sysComSearchVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	             
	              List<String> lstPyspGrdeCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
	              sysComSearchVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
	              sysComSearchVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	               
	              List<String> lstDtilOccuClsDivCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsDivCd"))); 
	              sysComSearchVo.setDtilOccuClsDivCdArr(lstDtilOccuClsDivCd);  
	              sysComSearchVo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsDivCd"))); //직종세 
	              
	              sysComSearchVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	              sysComSearchVo.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
	            
	              sysComSearchVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	              sysComSearchVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
	              
	              sysComSearchVo.setHodyApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hodyApptnYr")));    // 휴가적용년월
	              
	              System.out.println("sysComSearchVo getHodyApptnYr============================="+sysComSearchVo.getHodyApptnYr().toString());
	              String strHdofcCodtnCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"));
	              
	              List<String> listHdofcCodtnCd = new ArrayList<String>(); 
	             
	              String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
	              
	              for (int i=0; i<ray.length; i++){ 
	                  listHdofcCodtnCd.add(ray[i]);
	              } 
	              sysComSearchVo.setHdofcCodtnCdArr(listHdofcCodtnCd);    //재직상
	              sysComSearchVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));    //재직상
	              
	              
	              //Get total record count //전체 데이터 갯수를 가지고 온다. 
	               if ( pagingValues.executeRecordCount ) { 
	                      
	                  //Execute query that returns a single value
	                  TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                   
	                  int iResultCnt = psnl0100DAO.selectPsnl0100ToPsnl0126ListTotCnt(sysComSearchVo);  
	                
	                  SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                  pagingValues.totalRecordCount = iResultCnt;        
	                  
	                  logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	              }
	          
	              TimingInfo millisBeginPsnl0100ToPayr4100DataList = SmrmfUtils.startTiming(logger);
	          
	              /**페이지 카운트 처리를 위한 부분 */ 
	              sysComSearchVo.setPageSize(pagingValues.totalRecordCount);  
	              
	              //Apply paging
	              if (pagingValues.start > 0) {
	                  sysComSearchVo.setFirstIndex(pagingValues.start);
	              }
	              if (pagingValues.offsetLimit > 0) {
	                  sysComSearchVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	              }

	              //Execute query and convert to BaseModel list
	              TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	              
	              @SuppressWarnings("unchecked")
//	              Collection<Map<String, Object>> list  
	              List list = psnl0100DAO.selectPsnl0100ToPsnl0126List(sysComSearchVo);
	              
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
	              
	              SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToPayr4100DataList, "getPsnl0100ToPayr4100DataList");
	         

	          }
	          catch (Exception ex) {
	              ex.printStackTrace();
	              //Return operation exception
	              throw MSFServerUtils.getOperationException(method, ex, logger);
	          }

	          return retval;
	      } 
	        
		
}
