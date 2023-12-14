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
import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.app.exterms.prgm.client.service.PrgmComBass0400Service;
import com.app.exterms.prgm.server.service.dao.PrgmComBass0320DAO;
import com.app.exterms.prgm.server.service.dao.PrgmComBass0400DAO;
import com.app.exterms.prgm.server.vo.PrgmComBass0400VO;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerExtAuth;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
//import com.googlecode.ehcache.annotations.Cacheable;


/**
 * @Class Name : Bass0400ServiceImpl.java
 * @Description : Bass0400 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.06.03
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
@Service("PrgmComBass0400Service")
public class PrgmComBass0400ServiceImpl extends AbstractCustomServiceImpl implements PrgmComBass0400Service, PrgmComDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(PrgmComBass0400ServiceImpl.class);

	    
	@Autowired
    @Resource(name="PrgmComBass0400DAO")
    private PrgmComBass0400DAO bass0400DAO;
	
	
	
	 /**
     * <pre>
     * 1. 개요 : 관리부서 콤보박스 처리시 사용
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getMangDeptLookupWithBass040001List
     * @date : Nov 13, 2015
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Nov 13, 2015		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param serviceParameters
     * @return
     */ 	
    public PagingLoadResult<BaseModel> getMangDeptLookupWithBass040001List(ServiceParameters serviceParameters) {
        PagingLoadResult<BaseModel> retval = null;
        String method =  PRGMCOM_METHOD_LOOKUP_BASS040001_List;
        PrgmComSearchVO   sysComSrhVo = new PrgmComSearchVO();
        PrgmComBass0400VO sysComBass0400Vo = new PrgmComBass0400VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        MSFServerExtAuth msfServerExtAuth = MSFServerExtAuth.getInstance();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(bass0400DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            bass0400DAO = (PrgmComBass0400DAO) wac.getBean("PrgmComBass0400DAO" ); 
//        }
        bass0400DAO = (PrgmComBass0400DAO)BeanFinder.getBean("PrgmComBass0400DAO");
        try {
          
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
   
          ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
        		  	new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
              		, new ColumnAttribute("mangeDeptCd"	, "mangeDeptCd"	, ColumnDef.TYPE_STRING)
                  	, new ColumnAttribute("deptNmHan"	, "deptNmHan"	, ColumnDef.TYPE_STRING)
                  	, new ColumnAttribute("deptNmRtchnt", "deptNmRtchnt", ColumnDef.TYPE_STRING)
                  };
          
            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
            /** 조건절 */ 
            sysComSrhVo.setDpobCd(sessionUser.getDpobCd());
            sysComSrhVo.setTplvlDeptCd(sessionUser.getTplvlDeptCd());    
            sysComSrhVo.setDeptCd(""); 
            sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
            sysComSrhVo.setMangeDeptCd("");
            sysComSrhVo.setDeptDspyYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptDspyYn")));
          
//         sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
//         /******************************** 권한 ************************************************************************/
//          String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//          if ("FALSE".equals(chkDeptCd)) {
//         	  sysComSrhVo.setDeptCd(sessionUser.getDeptCd());
//          } 
//         /******************************** 권한 ************************************************************************/
//          sysComSrhVo.setEmymtDivCd("");
//          sysComSrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))); 
//	       
//	      if (MSFSharedUtils.isEmpty(sysComSrhVo.getPayrMangDeptCd())) {
//	    	  sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//	      }  
//          
//          sysComSrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd"))); 
//          sysComSrhVo.setDeptNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptNm")));       //부서명
//          sysComSrhVo.setDeptDspyYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptDspyYn"))); //display
//          
//          sysComSrhVo.setDeptUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptUseYn")));  
          
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
//            if ( pagingValues.executeRecordCount ) { 
//                      
//                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//                 
//                int iResultCnt =  bass0400DAO.selectPayrWithBass0400ListTotCnt(sysComSrhVo);  
//              
//                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
//                pagingValues.totalRecordCount = iResultCnt;        
//                
//            //    logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//            }
        
            TimingInfo millisBeginSelectPayrWithBass0400List = SmrmfUtils.startTiming(logger);
         
            /**페이지 카운트 처리를 위한 부분 */ 
            sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
                sysComSrhVo.setFirstIndex(pagingValues.start);
           // }
           // if (pagingValues.offsetLimit > 0) {
           //      sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            sysComSrhVo.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked") 
            List list = bass0400DAO.selectPrgmComMangDeptBass0400List(sysComSrhVo);
            
            Iterator<Map<String, Object>> iter = list.iterator();
                  
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("mangeDeptCd").toString();
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

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayrWithBass0400List, "getMangDeptLookupWithBass040001List");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	
	
 
	/**
	 * 관리 부서를 일반 콤보형태 처리 
	 * @param  
	 * @return
	 * @throws MSFException
	 */
	 
	public List<BaseModel> getPrgmComMangDeptBass0400List(PrgmComBass0400DTO sysComBass0400Dto) throws MSFException {

     //   PagingLoadResult<BaseModel> retval = null; 
		String method = PRGMCOM_METHOD_LOOKUP_BASS040001_List;
        PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
        PrgmComBass0400VO sysComBass0400Vo = new PrgmComBass0400VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        	 bass0400DAO = (PrgmComBass0400DAO)BeanFinder.getBean("PrgmComBass0400DAO");
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
  
 	        
        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                      new ColumnAttribute("dpobCd"		, "dpobCd"		, ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("deptCd"		, "deptCd"		, ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("mangeDeptCd"	, "mangeDeptCd"	, ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("deptNmHan"	, "deptNmHan"	, ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("deptNmRtchnt", "deptNmRtchnt", ColumnDef.TYPE_STRING)
           	};
        	
            //Get paging configuration
           // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
             sysComSrhVo.setDpobCd(sessionUser.getDpobCd());
             sysComSrhVo.setTplvlDeptCd(sessionUser.getTplvlDeptCd());    
             sysComSrhVo.setDeptCd(""); 
             sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
             sysComSrhVo.setMangeDeptCd("");
             sysComSrhVo.setDeptDspyYn(MSFSharedUtils.allowNulls(sysComBass0400Dto.getDeptDspyYn()));
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        //    if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
           //     TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
          //      int iResultCnt = bass0400DAO.selectPrgmComMangDeptBass0400ListTotCnt(sysComSrhVo); 
              
            //    SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
         //       pagingValues.totalRecordCount = iResultCnt;	       
                
         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         //  }
        
            TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
        
        	 

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
            List list = bass0400DAO.selectPrgmComMangDeptBass0400List(sysComSrhVo);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("mangeDeptCd").toString();
                BaseModel bm = new BaseModel();

               // bm.setProperties(map);
                for ( int i=0 ; i<columnAttributes.length ; i++ ) {
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(columnAttributes[i].getName()), columnAttributes[i].getType());
                    bm.set(columnAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            //retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0400List, "selectPrgmComMangDeptBass0400List");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException("getPrgmComMangDeptBass0400List", ex, logger);
        }
        
        return bmResult;
    }
 
	
	/**
	 * <pre>
	 * 1. 개요 :  부서를 일반 콤보형태 처리
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getPrgmComWithBass0400List
	 * @date : Nov 13, 2015
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Nov 13, 2015		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.app.exterms.prgm.client.service.PrgmComBass0400Service#getPrgmComWithBass0400List()
	 * @return
	 * @throws MSFException
	 */ 	
	public List<BaseModel> getPrgmComWithBass0400List() throws MSFException {

     //   PagingLoadResult<BaseModel> retval = null; 
        PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
        PrgmComBass0400VO sysComBass0400Vo = new PrgmComBass0400VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
        	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        	 bass0400DAO = (PrgmComBass0400DAO)BeanFinder.getBean("PrgmComBass0400DAO");
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
  
 	        
        	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                     ,new ColumnAttribute("deptCd", "deptCd", ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("deptNmHan", "deptNmHan", ColumnDef.TYPE_STRING)
                     ,new ColumnAttribute("deptNmRtchnt", "deptNmRtchnt", ColumnDef.TYPE_STRING)
                      };
        	
            //Get paging configuration
           // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
        	sysComSrhVo.setDpobCd(sessionUser.getDpobCd());
            sysComSrhVo.setDeptCd(""); 
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	
           	  sysComSrhVo.setDeptCd(sessionUser.getDeptCd());
           
            } 
           /******************************** 권한 ************************************************************************/
            sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
            sysComSrhVo.setMangeDeptCd(""); 
            sysComSrhVo.setDeptDspyYn("");
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        //    if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
              //  int iResultCnt = selectBass0400ListTotCnt(sysComSrhVo); 
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
         //       pagingValues.totalRecordCount = iResultCnt;	       
                
         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         //  }
        
            TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
        
        	 

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
            List list = bass0400DAO.selectBass0400ComboList(sysComSrhVo);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("deptCd").toString();
                BaseModel bm = new BaseModel();

               // bm.setProperties(map);
                for ( int i=0 ; i<columnAttributes.length ; i++ ) {
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
                            map.get(columnAttributes[i].getName()), columnAttributes[i].getType());
                    bm.set(columnAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            //retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0400List, "selectBass0400List"); 
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException("getPrgmComWithBass0400List", ex, logger);
        }

        return bmResult;
    }
 

  /**
	 * BASS0400 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BASS0400 총 갯수
	 * @exception
	 */
	 
  public int selectBass0400ListTotCnt(PrgmComSearchVO searchVO) {
		return bass0400DAO.selectBass0400ListTotCnt(searchVO);
	}  
	
	/**
	 * 관리부서에 따른 부서를 가지고 온다. 일반 콤보형태 처리 
	 * @param sysComBass0400Dto
	 * @return
	 * @throws MSFException
	 */
	//@Cacheable(cacheName = "deptCache")  
	public List<BaseModel> getPrgmComDeptBass0400List(PrgmComBass0400DTO sysComBass0400Dto) throws MSFException {

      PagingLoadResult<BaseModel> retval = null;
      String method = "getPrgmComDeptBass0400List";
      PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
      PrgmComBass0400VO sysComBass0400Vo = new PrgmComBass0400VO();
      List<BaseModel> bmResult = new ArrayList<BaseModel>();
      
      try {
          //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
      	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
      	 bass0400DAO = (PrgmComBass0400DAO)BeanFinder.getBean("PrgmComBass0400DAO");
         // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
         // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
         // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
         // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
      	ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
               ,new ColumnAttribute("deptCd", "deptCd", ColumnDef.TYPE_STRING)
               ,new ColumnAttribute("deptNmHan", "deptNmHan", ColumnDef.TYPE_STRING)
               ,new ColumnAttribute("deptNmRtchnt", "deptNmRtchnt", ColumnDef.TYPE_STRING)
                };
      	
          //Get paging configuration
         // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

          //Get query parameters
         // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
         
          /** 조건절 */
          sysComSrhVo.setDpobCd(sessionUser.getDpobCd());
          sysComSrhVo.setDeptCd(""); 
	      sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
          sysComSrhVo.setMangeDeptCd(sysComBass0400Dto.getMangeDeptCd() == null ? "" : sysComBass0400Dto.getMangeDeptCd());
          sysComSrhVo.setDeptDspyYn(sysComBass0400Dto.getDeptDspyYn() == null ? "" : sysComBass0400Dto.getDeptDspyYn());
          
          //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        //    if ( pagingValues.executeRecordCount ) { 
	            	
              //Execute query that returns a single value
              TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
               
              int iResultCnt =  bass0400DAO.selectBass0400ListTotCnt(sysComSrhVo);  
            
              SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
       //       pagingValues.totalRecordCount = iResultCnt;	       
              
       //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
       //  }
      
          TimingInfo millisBeginSelectBass0400List = SmrmfUtils.startTiming(logger);
      
      	 

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
//          Collection<Map<String, Object>> list ??????
          List list = bass0400DAO.selectBass0400List(sysComSrhVo);
          
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
          SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
         
          while ( iter.hasNext() ) {
              Map<String, Object> map = (Map<String, Object>) iter.next();
              String idValue = map.get("deptCd").toString();
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
          
          SmrmfUtils.endTiming(logger, millisBeginSelectBass0400List, "selectBass0400List");
          
     

      }
      catch (Exception ex) {
          //Return operation exception
          throw MSFServerUtils.getOperationException(method, ex, logger);
      }

      return bmResult;
  }
	
	/**
	 * 팝업형태 나 콤보 형태를 공통 rpc 로직을 호출 하여 처리 할 경우 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */ 
	
	public PagingLoadResult<BaseModel> getPrgmComPopupBass0400List(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  PRGMCOM_METHOD_POPUP_BASS0400_List;
	        PrgmComSearchVO   sysComSrhVo = new PrgmComSearchVO();
	        PrgmComBass0400VO sysComBass0400Vo = new PrgmComBass0400VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
//	        if  (MSFSharedUtils.paramNull(bass0400DAO)) {
//	        
//	        	WebApplicationContext wac = WebApplicationContextUtils.
//	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//	        	bass0400DAO = (PrgmComBass0400DAO) wac.getBean("PrgmComBass0400DAO" ); 
//	        }
	        bass0400DAO = (PrgmComBass0400DAO)BeanFinder.getBean("PrgmComBass0400DAO");
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
	            sysComSrhVo.setDeptCd(""); //MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	           	  sysComSrhVo.setDeptCd(sessionUser.getDeptCd());
	            } 
	           /******************************** 권한 ************************************************************************/
                sysComSrhVo.setEmymtDivCd("");
                sysComSrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))); 
                if (MSFSharedUtils.isEmpty(sysComSrhVo.getPayrMangDeptCd())) {
      	    	  sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
      	        }  
                sysComSrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")));
	         //   sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd"))); 
	            sysComSrhVo.setDeptNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptNm")));       //부서명
	            sysComSrhVo.setDeptDspyYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptDspyYn"))); //display
	            if ("combo".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "chkCombo")))) {
	            	sysComSrhVo.setLastIndex(-1);
	            } else {
		            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	 	            if ( pagingValues.executeRecordCount ) { 
	 	            	
		                //Execute query that returns a single value
		                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		                int iResultCnt = bass0400DAO.selectBass0400ListTotCnt(sysComSrhVo);  
		              
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
	            

	            TimingInfo millisBeginSelectBass0300List = SmrmfUtils.startTiming(logger);
            
	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = bass0400DAO.selectBass0400List(sysComSrhVo);
                
 	            Iterator<Map<String, Object>> iter = list.iterator();
 	            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("deptCd").toString();
	                BaseModel bm = new BaseModel();
	
	                //bm.setProperties(map);
	                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
	                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++   
	                    Object mapCon = MSFSharedUtils.allowNulls(map.get(tableAttributes[i].getName())); 
	                     
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
	            
                SmrmfUtils.endTiming(logger, millisBeginSelectBass0300List, "selectBass0400List");
	       
 
	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }
	
	 /**
	  * 
	  * <pre>
	  * 1. 개요 : 관리부서 사용시 만 사용할것 아니면 권한 풀린 전체 데이타 가져올시  만 
	  * 2. 처리내용 : 
	  * </pre>
	  * @Method Name : getPrgmComP0145Bass0400List
	  * @date : Jun 16, 2016
	  * @author : leeheuisung
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	Jun 16, 2016		leeheuisung				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @param serviceParameters
	  * @return
	  * @throws MSFException
	  */
	public PagingLoadResult<BaseModel> getPrgmComP0145Bass0400List(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  PRGMCOM_METHOD_P0145_BASS0400_List;
	        PrgmComSearchVO   sysComSrhVo = new PrgmComSearchVO();
	        PrgmComBass0400VO sysComBass0400Vo = new PrgmComBass0400VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
//	        if  (MSFSharedUtils.paramNull(bass0400DAO)) {
//	        
//	        	WebApplicationContext wac = WebApplicationContextUtils.
//	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//	        	bass0400DAO = (PrgmComBass0400DAO) wac.getBean("PrgmComBass0400DAO" ); 
//	        }
	        bass0400DAO = (PrgmComBass0400DAO)BeanFinder.getBean("PrgmComBass0400DAO");
	        
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
	            sysComSrhVo.setDeptCd(""); //MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))
	            /******************************** 권한 ************************************************************************/
	            //String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            //if ("FALSE".equals(chkDeptCd)) {
	           	 // sysComSrhVo.setDeptCd(sessionUser.getDeptCd());
	            //} 
	           /******************************** 권한 ************************************************************************/
                sysComSrhVo.setEmymtDivCd("");
                sysComSrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))); 
             
                if (MSFSharedUtils.isEmpty(sysComSrhVo.getPayrMangDeptCd())) {
                	//전체나오는 로직 으로 변경  
      	    	  sysComSrhVo.setPayrMangDeptCd(sessionUser.getTplvlDeptCd());  //.getPayrMangDeptCd()
      	        }  
                sysComSrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")));
	         //   sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd"))); 
	            sysComSrhVo.setDeptNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptNm")));       //부서명
	            sysComSrhVo.setDeptDspyYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptDspyYn"))); //display
	            if ("combo".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "chkCombo")))) {
	            	sysComSrhVo.setLastIndex(-1);
	            } else {
		            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	 	            if ( pagingValues.executeRecordCount ) { 
	 	            	
		                //Execute query that returns a single value
		                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		                int iResultCnt = bass0400DAO.selectBass0400ListTotCnt(sysComSrhVo);  
		              
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
	            

	            TimingInfo millisBeginSelectBass0300List = SmrmfUtils.startTiming(logger);
            
	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = bass0400DAO.selectBass0400List(sysComSrhVo);
                
 	            Iterator<Map<String, Object>> iter = list.iterator();
 	            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("deptCd").toString();
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
	            
                SmrmfUtils.endTiming(logger, millisBeginSelectBass0300List, "selectBass0400List");
	       
 
	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }

	/**
	 * 급여부서콤보코드 가져오기 
	 */
    @Override
    public List<BaseModel> getPayrWithBass0400List(PrgmComBass0400DTO sysComBass0400Dto) {
        PagingLoadResult<BaseModel> retval = null;
        String method = "getPayrWithBass0400List";
        PrgmComSearchVO  sysComSrhVo = new PrgmComSearchVO();
        PrgmComBass0400VO sysComBass0400Vo = new PrgmComBass0400VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
          MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
          bass0400DAO = (PrgmComBass0400DAO)BeanFinder.getBean("PrgmComBass0400DAO");
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
           // IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
           // List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
           // PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
   
          ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                  new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                 ,new ColumnAttribute("deptCd", "deptCd", ColumnDef.TYPE_STRING)
                 ,new ColumnAttribute("deptNmHan", "deptNmHan", ColumnDef.TYPE_STRING)
                 ,new ColumnAttribute("deptNmRtchnt", "deptNmRtchnt", ColumnDef.TYPE_STRING)
                  };
          
            //Get paging configuration
           // PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
            sysComSrhVo.setDpobCd(sessionUser.getDpobCd());
            sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(sysComBass0400Dto.getDeptCd()));   
            /******************************** 권한 ************************************************************************/
             String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
             if ("FALSE".equals(chkDeptCd)) { 
            	  sysComSrhVo.setDeptCd(sessionUser.getDeptCd());
             } 
            /******************************** 권한 ************************************************************************/
            sysComSrhVo.setEmymtDivCd("");
            sysComSrhVo.setPayrMangDeptCd(sysComBass0400Dto.getPayrMangDeptCd() == null ? "" : sysComBass0400Dto.getPayrMangDeptCd());
            if (MSFSharedUtils.isEmpty(sysComSrhVo.getPayrMangDeptCd())) {
  	    	  sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
  	        }  
            sysComSrhVo.setMangeDeptCd(sysComBass0400Dto.getMangeDeptCd() == null ? "" : sysComBass0400Dto.getMangeDeptCd());
            sysComSrhVo.setDeptDspyYn(sysComBass0400Dto.getDeptDspyYn() == null ? "" : sysComBass0400Dto.getDeptDspyYn());
            
            // 사용여부 표시 구분자 
            sysComSrhVo.setTypOccuUseYn(MSFSharedUtils.allowNulls( sysComBass0400Dto.getTypOccuUseYn()));
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
              //    if ( pagingValues.executeRecordCount ) { 
                      
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  bass0400DAO.selectPayrWithBass0400ListTotCnt(sysComSrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
         //       pagingValues.totalRecordCount = iResultCnt;        
                
         //       logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         //  }
        
            TimingInfo millisBeginSelectPayrWithBass0400List = SmrmfUtils.startTiming(logger);
         
            /**페이지 카운트 처리를 위한 부분 */ 
          //  sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
           //     sysComSrhVo.setFirstIndex(pagingValues.start);
           // }
           // if (pagingValues.offsetLimit > 0) {
           //      sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            sysComSrhVo.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
 
            List list = bass0400DAO.selectPayrWithBass0400List(sysComSrhVo);
            
              Iterator<Map<String, Object>> iter = list.iterator();
                  
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("deptCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayrWithBass0400List, "getPayrWithBass0400List");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return bmResult;
    }
    
    
    
    /**
     * <pre>
     * 1. 개요 : 부서 콤보박스 처리시 사용
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : getPayrLookupWithBass0400List
     * @date : Nov 13, 2015
     * @author : leeheuisung
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	Nov 13, 2015		leeheuisung				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @param serviceParameters
     * @return
     */ 	
    public PagingLoadResult<BaseModel> getPayrLookupWithBass0400List(ServiceParameters serviceParameters) {
        PagingLoadResult<BaseModel> retval = null;
        String method =  PRGMCOM_METHOD_POPUP_BASS0400_List;
        PrgmComSearchVO   sysComSrhVo = new PrgmComSearchVO();
        PrgmComBass0400VO sysComBass0400Vo = new PrgmComBass0400VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        MSFServerExtAuth msfServerExtAuth = MSFServerExtAuth.getInstance();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
//        if  (MSFSharedUtils.paramNull(bass0400DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            bass0400DAO = (PrgmComBass0400DAO) wac.getBean("PrgmComBass0400DAO" ); 
//        }
        bass0400DAO = (PrgmComBass0400DAO)BeanFinder.getBean("PrgmComBass0400DAO");
        
        try {
          
           // ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
   
          ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
                  new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
                 ,new ColumnAttribute("deptCd", "deptCd", ColumnDef.TYPE_STRING)
                 ,new ColumnAttribute("deptNmHan", "deptNmHan", ColumnDef.TYPE_STRING)
                 ,new ColumnAttribute("deptNmRtchnt", "deptNmRtchnt", ColumnDef.TYPE_STRING)
                  };
          
            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
          /** 조건절 */ 
          sysComSrhVo.setDpobCd(sessionUser.getDpobCd());
          
         sysComSrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
         /******************************** 권한 ************************************************************************/
          String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
          if ("FALSE".equals(chkDeptCd)) {
         	  sysComSrhVo.setDeptCd(sessionUser.getDeptCd());
          } 
         /******************************** 권한 ************************************************************************/
          sysComSrhVo.setEmymtDivCd("");
          sysComSrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))); 
	       
	      if (MSFSharedUtils.isEmpty(sysComSrhVo.getPayrMangDeptCd())) {
	    	  sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
	      }  
          
          sysComSrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd"))); 
          sysComSrhVo.setDeptNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptNm")));       //부서명
          sysComSrhVo.setDeptDspyYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptDspyYn"))); //display
          
          sysComSrhVo.setDeptUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptUseYn")));  
          
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
            if ( pagingValues.executeRecordCount ) { 
                      
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  bass0400DAO.selectPayrWithBass0400ListTotCnt(sysComSrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
            //    logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPayrWithBass0400List = SmrmfUtils.startTiming(logger);
         
            /**페이지 카운트 처리를 위한 부분 */ 
            sysComSrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
           // if (pagingValues.start > 0) {
                sysComSrhVo.setFirstIndex(pagingValues.start);
           // }
           // if (pagingValues.offsetLimit > 0) {
           //      sysComSrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
           // }
            sysComSrhVo.setLastIndex(-1); 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked") 
            List list = bass0400DAO.selectPayrWithBass0400List(sysComSrhVo);
            
            Iterator<Map<String, Object>> iter = list.iterator();
                  
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("deptCd").toString();
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

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayrWithBass0400List, "getPayrWithBass0400List");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
    	
}
