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
import com.app.exterms.prgm.client.dto.PrgmComBass0500DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0500Service;
import com.app.exterms.prgm.server.service.dao.PrgmComBass0400DAO;
import com.app.exterms.prgm.server.service.dao.PrgmComBass0500DAO;
import com.app.exterms.prgm.server.utils.PrgmComServerUtils;
import com.app.exterms.prgm.server.vo.PrgmComBass0500VO;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
//import com.googlecode.ehcache.annotations.Cacheable;

/**
 * @Class Name : Bass0500ServiceImpl.java
 * @Description : Bass0500 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@Service("PrgmComBass0500Service")
public class PrgmComBass0500ServiceImpl extends AbstractCustomServiceImpl implements PrgmComBass0500Service ,PrgmComDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(PrgmComBass0500ServiceImpl.class);

	public PrgmComBass0500ServiceImpl() {
	
	}
	    
	@Autowired
    @Resource(name="PrgmComBass0500DAO")
    private PrgmComBass0500DAO bass0500DAO;
    
    /** ID Generation */
    //@Resource(name="{egovBass0500IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	
	 
    public PagingLoadResult<BaseModel> getBass0500ToPayr5300DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_BASS0500_PAYR5300_DATA_LIST;
        PrgmComSearchVO   bass0500SrhVO = new PrgmComSearchVO();
        PrgmComBass0500VO      bass0500VO = new PrgmComBass0500VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(bass0500DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            bass0500DAO = (PrgmComBass0500DAO) wac.getBean("PrgmComBass0500DAO" ); 
//        }
        bass0500DAO = (PrgmComBass0500DAO)BeanFinder.getBean("PrgmComBass0500DAO");
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0400BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
            
            /** 조건절 */
            bass0500SrhVO.setDpobCd(sessionUser.getDpobCd());
            bass0500SrhVO.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));  
            bass0500SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
            bass0500SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
            bass0500SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));
            bass0500SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));
          
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = bass0500DAO.selectBass0500ToPayr5300ListTotCnt(bass0500SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginBass0500ToPayr5300DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            bass0500SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                bass0500SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                bass0500SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = bass0500DAO.selectBass0500ToPayr5300List(bass0500SrhVO);
            
            Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("businCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginBass0500ToPayr5300DataList, "getBass0500ToPayr5300DataList");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
    
//	/**
//	 * BASS0500을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Bass0500VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertBass0500(PrgmComBass0500VO vo) throws Exception {
//    	logger.debug(vo.toString());
//    	
//    	/** ID Generation Service */
//    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//    	//String id = egovIdGnrService.getNextStringId();
//    	//vo.setId(id);
//    	logger.debug(vo.toString());
//    	
//    	bass0500DAO.insertBass0500(vo);
//    	//TODO 해당 테이블 정보에 맞게 수정    	
//        return null;
//    }
//
//    /**
//	 * BASS0500을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Bass0500VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    public void updateBass0500(PrgmComBass0500VO vo) throws Exception {
//        bass0500DAO.updateBass0500(vo);
//    }
//
//    /**
//	 * BASS0500을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Bass0500VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    public void deleteBass0500(PrgmComBass0500VO vo) throws Exception {
//        bass0500DAO.deleteBass0500(vo);
//    }
//
//    /**
//	 * BASS0500을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Bass0500VO
//	 * @return 조회한 BASS0500
//	 * @exception Exception
//	 */
//    public PrgmComBass0500VO selectBass0500(PrgmComBass0500VO vo) throws Exception {
//        PrgmComBass0500VO resultVO = bass0500DAO.selectBass0500(vo);
////        if (resultVO == null)
////            throw processException("info.nodata.msg");
//        return resultVO;
//    }
//
//    /**
//	 * BASS0500 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BASS0500 목록
//	 * @exception Exception
//	 */
//    public List selectBass0500List(PrgmComSearchVO searchVO) throws Exception {
//        return bass0500DAO.selectBass0500List(searchVO);
//    }

	
	/**
	 * 일반 콤보형태 처리 
	 * @param sysComBass0300Dto
	 * @return
	 * @throws MSFException
	 */
	 
	public List<BaseModel> getPrgmComWithBusinApptnYr(PrgmComBass0500DTO sysComBass0500Dto) throws MSFException {

      //  PagingLoadResult<BaseModel> retval = null;
        String method = "getPrgmComWithBusinApptnYr";
        PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
        PrgmComBass0500VO sysComBass0500Vo = new PrgmComBass0500VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        	 bass0500DAO = (PrgmComBass0500DAO)BeanFinder.getBean("PrgmComBass0500DAO");
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
  
            
        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                     ,new ColumnAttribute("businApptnYr", "businApptnYr", ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("businApptnYrDisp", "businApptnYrDisp", ColumnDef.TYPE_STRING) 
        	};
        	
            //Get paging configuration
            // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
        	sysComSrhVo.setDpobCd(sessionUser.getDpobCd());
	        
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        //    if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
              //  TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
              //  int iResultCnt = selectBass0500ListTotCnt(sysComSrhVo); 
              
             //   SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
         //       pagingValues.totalRecordCount = iResultCnt;	       
                
         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         //  }
        
            TimingInfo millisBeginPrgmComWithBusinApptnYr = SmrmfUtils.startTiming(logger);
        
        	 

            /**페이지 카운트 처리를 위한 부분 */ 
          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
           // 	sysComSrhVo.setFirstIndex(pagingValues.start);
           // }
           // if (pagingValues.offsetLimit > 0) {
           // 	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            sysComSrhVo.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = bass0500DAO.selectPrgmComWithBusinApptnYr(sysComSrhVo);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("businApptnYr").toString();
                BaseModel bm = new BaseModel();

                //bm.setProperties(map);
                for ( int i=0 ; i<columnAttributes.length ; i++ ) {
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(columnAttributes[i].getName()), columnAttributes[i].getType());
                    bm.set(columnAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            //retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPrgmComWithBusinApptnYr, "PrgmComWithBusinApptnYr");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException("getPrgmComWithBusinApptnYr", ex, logger);
        }

        return bmResult;
    }
	
	 
	 /**
	  * 
	  * <pre>
	  * 1. 개요 :  일반콤보 형태 처리 사업명 
	  * 2. 처리내용 : 
	  * </pre>
	  * @Method Name : getPrgmComWithBass0500List
	  * @date : Feb 17, 2016
	  * @author : leeheuisung
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	Feb 17, 2016		leeheuisung				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @see com.app.exterms.prgm.client.service.PrgmComBass0500Service#getPrgmComWithBass0500List(com.app.exterms.prgm.client.dto.PrgmComBass0500DTO)
	  * @param sysComBass0500Dto
	  * @return
	  * @throws MSFException
	  */
	public List<BaseModel> getPrgmComWithBass0500List(PrgmComBass0500DTO sysComBass0500Dto) throws MSFException {

      //  PagingLoadResult<BaseModel> retval = null;
       // String method = PRGMCOM_METHOD_BASS0500_List;
        PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
        PrgmComBass0500VO sysComBass0500Vo = new PrgmComBass0500VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        bass0500DAO = (PrgmComBass0500DAO)BeanFinder.getBean("PrgmComBass0500DAO");
//        if  (MSFSharedUtils.paramNull(bass0500DAO)) {
//            
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            bass0500DAO = (PrgmComBass0500DAO) wac.getBean("PrgmComBass0500DAO" ); 
//        }
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
           
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
  
            
        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                     ,new ColumnAttribute("businApptnYr", "businApptnYr", ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("deptCd", "deptCd", ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("businCd", "businCd", ColumnDef.TYPE_STRING) 
                     ,new ColumnAttribute("businNm", "businNm", ColumnDef.TYPE_STRING) 
        	};
        	
            //Get paging configuration
            // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
        	sysComSrhVo.setDpobCd(sessionUser.getDpobCd());
	        sysComSrhVo.setBusinApptnYr(sysComBass0500Dto.getBusinApptnYr());
	        sysComSrhVo.setDeptCd(sysComBass0500Dto.getDeptCd());
	        sysComSrhVo.setBusinCd("");
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        //    if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = selectBass0500ListTotCnt(sysComSrhVo); 
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
         //       pagingValues.totalRecordCount = iResultCnt;	       
                
         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         //  }
        
            TimingInfo millisBeginSelectBass0300List = SmrmfUtils.startTiming(logger);
        
        	 

            /**페이지 카운트 처리를 위한 부분 */ 
          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
           // 	sysComSrhVo.setFirstIndex(pagingValues.start);
           // }
           // if (pagingValues.offsetLimit > 0) {
           // 	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            sysComSrhVo.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = bass0500DAO.selectBass0500List(sysComSrhVo);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("businCd").toString();
                BaseModel bm = new BaseModel();

                //bm.setProperties(map);
                for ( int i=0 ; i<columnAttributes.length ; i++ ) {
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(columnAttributes[i].getName()), columnAttributes[i].getType());
                    bm.set(columnAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            //retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0300List, "selectBass0300List");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException("getPrgmComWithBass0500List", ex, logger);
        }

        return bmResult;
    }
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 멀티 사업명 콤보 
	 * 2. 처리내용 :  여러부서가 선택된 경우 처리하는 여러사업명을 가지고 온다. 
	 * </pre>
	 * @Method Name : getPrgmComWithMultiBass0500List
	 * @date : Feb 17, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Feb 17, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.app.exterms.prgm.client.service.PrgmComBass0500Service#getPrgmComWithMultiBass0500List(com.app.exterms.prgm.client.dto.PrgmComBass0500DTO)
	 * @param sysComBass0500Dto
	 * @return
	 * @throws MSFException
	 */
	public List<BaseModel> getPrgmComWithMultiBass0500List(PrgmComBass0500DTO sysComBass0500Dto) throws MSFException {

	      //  PagingLoadResult<BaseModel> retval = null;
	       // String method = PRGMCOM_METHOD_BASS0500_List;
	        PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
	        PrgmComBass0500VO sysComBass0500Vo = new PrgmComBass0500VO();
	        List<BaseModel> bmResult = new ArrayList<BaseModel>();
	        bass0500DAO = (PrgmComBass0500DAO)BeanFinder.getBean("PrgmComBass0500DAO");
//	        if  (MSFSharedUtils.paramNull(bass0500DAO)) {
//	            
//	            WebApplicationContext wac = WebApplicationContextUtils.
//	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//	            bass0500DAO = (PrgmComBass0500DAO) wac.getBean("PrgmComBass0500DAO" ); 
//	        }
	        
	        try {
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	           
	           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
	  
	            
	        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
	                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
	                     ,new ColumnAttribute("businApptnYr", "businApptnYr", ColumnDef.TYPE_STRING)
	                     ,new ColumnAttribute("deptCd", "deptCd", ColumnDef.TYPE_STRING)
	                     ,new ColumnAttribute("businCd", "businCd", ColumnDef.TYPE_STRING) 
	                     ,new ColumnAttribute("businNm", "businNm", ColumnDef.TYPE_STRING) 
	        	};
	        	
	            //Get paging configuration
	            // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	            //Get query parameters
	           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	        	 List<String> listDeptCd = new ArrayList<String>(); 
	            /** 조건절 */
	        	sysComSrhVo.setDpobCd(sessionUser.getDpobCd());
		        sysComSrhVo.setBusinApptnYr(sysComBass0500Dto.getBusinApptnYr());
		        sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(sysComBass0500Dto.getDeptCd()));
   	            listDeptCd = PrgmComServerUtils.getStrToArrayList(sysComBass0500Dto.getDeptCd());  
   	            sysComSrhVo.setDeptCdArr(listDeptCd);     //부서코드   
		        //sysComSrhVo.setDeptCd(sysComBass0500Dto.getDeptCd());
		        sysComSrhVo.setBusinCd("");
	         
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		        //    if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = selectMultiBass0500ListTotCnt(sysComSrhVo); 
	              
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	         //       pagingValues.totalRecordCount = iResultCnt;	       
	                
	         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	         //  }
	        
	            TimingInfo millisBeginSelectBass0300List = SmrmfUtils.startTiming(logger);
	        
	        	 

	            /**페이지 카운트 처리를 위한 부분 */ 
	          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	           // if (pagingValues.start > 0) {
	           // 	sysComSrhVo.setFirstIndex(pagingValues.start);
	           // }
	           // if (pagingValues.offsetLimit > 0) {
	           // 	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	           // }
	            sysComSrhVo.setLastIndex(-1); 

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = bass0500DAO.selectMultiBass0500List(sysComSrhVo);
	            
		        Iterator<Map<String, Object>> iter = list.iterator();
		            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("businCd").toString();
	                BaseModel bm = new BaseModel();

	                //bm.setProperties(map);
	                for ( int i=0 ; i<columnAttributes.length ; i++ ) {
	                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
	                            map.get(columnAttributes[i].getName()), columnAttributes[i].getType());
	                    bm.set(columnAttributes[i].getName(), baseModelValue);
	                }

	                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
	                bmResult.add(bm);
	            } 

	            //retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
	            
	            SmrmfUtils.endTiming(logger, millisBeginSelectBass0300List, "selectBass0300List");
	            
	       

	        }
	        catch (Exception ex) {
	            //Return operation exception
	            throw MSFServerUtils.getOperationException("getPrgmComWithBass0500List", ex, logger);
	        }

	        return bmResult;
	    }
    /**
	 * BASS0500 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BASS0500 총 갯수
	 * @exception
	 */
	  
    public int selectBass0500ListTotCnt(PrgmComSearchVO searchVO) {
		return bass0500DAO.selectBass0500ListTotCnt(searchVO);
	}
    
    public int selectMultiBass0500ListTotCnt(PrgmComSearchVO searchVO) {
 		return bass0500DAO.selectBass0500ListTotCnt(searchVO);
 	}
    
    /**
	 * 팝업형태 나 콤보 형태를 공통 rpc 로직을 호출 하여 처리 할 경우 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */ 
 
	public PagingLoadResult<BaseModel> getPrgmComPopupBass0500List(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  PRGMCOM_METHOD_POPUP_BASS0500_List;
	        PrgmComSearchVO   sysComSrhVo = new PrgmComSearchVO();
	        PrgmComBass0500VO sysComBass0500Vo = new PrgmComBass0500VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
//	        if  (MSFSharedUtils.paramNull(bass0500DAO)) {
//	        
//	        	WebApplicationContext wac = WebApplicationContextUtils.
//	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//	        	bass0500DAO = (PrgmComBass0500DAO) wac.getBean("PrgmComBass0500DAO" ); 
//	        }
	        bass0500DAO = (PrgmComBass0500DAO)BeanFinder.getBean("PrgmComBass0500DAO");
	        
	        try {
                //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	           // Sysm0100BM          user             = serviceParameters.getUser();
	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
	            //Get paging configuration
	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

	            /** 조건절 */
	            sysComSrhVo.setDpobCd(sessionUser.getDpobCd()); 
	            sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	            sysComSrhVo.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr")));
	            sysComSrhVo.setBusinNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businNm")));
	            
	            if ("combo".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "chkCombo")))) {
	            	sysComSrhVo.setLastIndex(-1);
	            } else {  
		            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	 	            if ( pagingValues.executeRecordCount ) { 
	 	            	
		                //Execute query that returns a single value
		                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		                int iResultCnt = bass0500DAO.selectBass0500ListTotCnt(sysComSrhVo);  
		              
		                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
		                pagingValues.totalRecordCount = iResultCnt;	       
		                
		                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	                }
		        
		            /**페이지 카운트 처리를 위한 부분 */ 
		            sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		            //Apply paging
		            if (pagingValues.start > 0) {
		            	sysComSrhVo.setFirstIndex(pagingValues.start);
		            }
		            if (pagingValues.offsetLimit > 0) {
		            	 sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
		            }
	            }
	            

	            TimingInfo millisBeginSelectBass0500List = SmrmfUtils.startTiming(logger);
            
	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = bass0500DAO.selectBass0500List(sysComSrhVo);
                
 	            Iterator<Map<String, Object>> iter = list.iterator();
 	            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next(); 
	                String idValue = map.get("businCd").toString();
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
	            
                SmrmfUtils.endTiming(logger, millisBeginSelectBass0500List, "selectBass0300List");
	       
 
	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }
	 
}
