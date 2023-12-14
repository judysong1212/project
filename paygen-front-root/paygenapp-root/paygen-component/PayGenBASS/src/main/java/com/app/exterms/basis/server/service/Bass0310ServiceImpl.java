package com.app.exterms.basis.server.service;

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

import com.app.exterms.basis.client.dto.Psnl2100DTO;
import com.app.exterms.basis.client.service.Bass0310Service;
import com.app.exterms.basis.server.service.dao.Psnl2100DAO;
import com.app.exterms.basis.server.vo.Psnl2100SrhVO;
import com.app.exterms.basis.server.vo.Psnl2100VO;
import com.app.exterms.basis.shared.BasisDaoConstantsGenerated;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

/**
 * @Class Name : Psnl2100ServiceImpl.java
 * @Description : Psnl2100 Business Implement class
 * @Modification Information
 *
 * @author 다은
 * @since 2015.10.13
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

@Service("Bass0310Service")
public class Bass0310ServiceImpl extends AbstractCustomServiceImpl implements  BasisDaoConstantsGenerated , Bass0310Service  {

		private static final Logger logger = LoggerFactory.getLogger(Bass0310ServiceImpl.class);
		private static final String calledClass = Bass0310ServiceImpl.class.getName();
		
	@Autowired
    @Resource(name="Psnl2100DAO")
    private Psnl2100DAO psnl2100DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPsnl2100IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	
	
	 public PagingLoadResult<BaseModel> getSelectBass0310ToPsnl2100List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_BASS0310_PSNL2100_LIST;
        Psnl2100SrhVO   psnl2100SrhVo = new Psnl2100SrhVO();
        Psnl2100VO      psnl2100Vo = new Psnl2100VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(psnl2100DAO)) {
        
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            psnl2100DAO = (Psnl2100DAO) wac.getBean("Psnl2100DAO"); 
        }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Psnl2100BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
            /** 조건절 */
            psnl2100SrhVo.setDpobCd(sessionUser.getDpobCd()); 
            psnl2100SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));    //검색조건처리 
          //  psnl2100SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
            psnl2100SrhVo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            psnl2100SrhVo.setHodyNumDysUseYn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "srhHodyNumDysUseYn")));
                      
                        
            //sysComSrhVo.setRpsttvCd(strCriteriaValue); 
         
            //페이징 
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
                if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = psnl2100DAO.selectPsnl2100ListTotCnt(psnl2100SrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPsnl2100List = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            psnl2100SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                psnl2100SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                psnl2100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = psnl2100DAO.selectPsnl2100List(psnl2100SrhVo);
            
                Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("typOccuCd").toString();
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
                        
//                        //길이가 긴데이타가 있어 어쩔수 없이 루틴 추가 schlExpnAdmclExtpyDivCdcommCdNm
//                        if (strMapCon.equals("dtiloccuclsdivcddtiloccuclsnm")) {
//                            strMapCon = "dtiloccuclsdivcdcommcdnm";
//                            
//                        } else if (strMapCon.equals("dtiloccuclsdivcddtiloccuclsdivcd")) {
//                            strMapCon = "dtiloccuclsdivcdcommcd";
//                        }
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPsnl2100List, "selectPsnl2100List");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }
        return retval;
    } 
	 
	 
	 /*public List<BaseModel> activityOnBass0310ToPsnl2100Save(ServiceParameters serviceParameters) {
	        
	        List<BaseModel> lsBmResult = new ArrayList<BaseModel>();
	        String result = "1";  
	        Psnl2100SrhVO   psnl2100SrhVo = new Psnl2100SrhVO();
	        
			String windowNm = "휴가일수관리";
			String windowId = "BASS0310";
	        
	        String method = calledClass + ".activityOnBass0310ToPsnl2100Save";
	        
	        List<BaseModel> listObjects       		= serviceParameters.getDataObjects();
	        ActionDatabase actionDatabase     		= serviceParameters.getActionDatabase(); 
	        String customMethodName           	= serviceParameters.getCustomMethodName();
	        ColumnAttribute[] tableAttributes 		= serviceParameters.getTableAttributes();
	        Boolean reloadData                		= serviceParameters.isReloadData();
	        Boolean noHistory                 			= serviceParameters.isNoHistory(); 
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	         
	        if  (MSFSharedUtils.paramNull(psnl2100DAO)) {
	            //getHttpServletRequest().getSession().getServletContext()
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( RemoteServiceUtil.getThreadLocalRequest().getSession().getServletContext() );

	            psnl2100DAO = (Psnl2100DAO) wac.getBean("Psnl2100DAO"); 
	        }
	         
	        try {
	        	for (BaseModel objectBm : listObjects) { 
	                 
	        		Psnl2100VO psnl2100Vo = new Psnl2100VO();
	                
	        		//defaultNulls allowNulls 확인
	        		psnl2100Vo.setDpobCd(MSFSharedUtils.defaultNulls(objectBm.get("dpobCd"),sessionUser.getDpobCd()));    
	        		psnl2100Vo.setHodyNumDysSeilNum(0L);  
	        		//psnl2100Vo.setHodyNumDysSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(objectBm.get("hodyNumDysSeilNum"), "0")));    /** column 휴가일수일련번호 : hodyNumDysSeilNum */
//	        		if (MSFSharedUtils.paramNotNull(objectBm.get("typOccuCd$typOccuCd")) && (!MSFSharedUtils.allowNulls(objectBm.get("typOccuCd$typOccuCd")).equals("!")) ) {
//	        			String[] tptypOccuCd = MSFSharedUtils.allowNulls(objectBm.get("typOccuCd$typOccuCd")).split("!"); 
//	        			psnl2100Vo.setTypOccuCd(tptypOccuCd[0]);		/** column 직종코드 : typOccuCd */
//	        			psnl2100Vo.setPyspGrdeCd(tptypOccuCd[1]);    	/** column 호봉등급코드 : pyspGrdeCd */
//	        		} else {
//	        			psnl2100Vo.setTypOccuCd("");    				/** column 직종코드 : typOccuCd */
//	        			psnl2100Vo.setPyspGrdeCd("");    				/** column 호봉등급코드 : pyspGrdeCd */  
//	        		}
	                /*  psnl2100Vo.setTypOccuCd(MSFSharedUtils.allowNulls(objectBm.get("typOccuCd$typOccuCd")));    						
	                 psnl2100Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(objectBm.get("pyspGrdeCd")));   
	        		psnl2100Vo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(objectBm.get("dtilOccuInttnCd$dtilOccuInttnCd")));			
	        		psnl2100Vo.setHodyNumDysOvr(0L);    			
	        		psnl2100Vo.setHodyNumDysUdr(0L);    			
	        		psnl2100Vo.setHodyNumDysFrmCd("00000000");																			
	        		psnl2100Vo.setHodyNumDys(0L);					
	        		psnl2100Vo.setHodyNumDysRate(0L);																
	        		psnl2100Vo.setHodyNumDysBgnnDt(new SimpleDateFormat("yyyyMMdd").format((Date)objectBm.get("hodyNumDysBgnnDt")));	
	        		psnl2100Vo.setHodyNumDysEndDt(new SimpleDateFormat("yyyyMMdd").format((Date)objectBm.get("hodyNumDysEndDt")));		
	                psnl2100Vo.setHodyNumDysUseYn(Boolean.TRUE.equals( (Boolean)objectBm.get("hodyNumDysUseYn")) ? "Y" : "N");    		
	                psnl2100Vo.setHodyNumDysNoteCtnt(MSFSharedUtils.allowNulls(objectBm.get("hodyNumDysNoteCtnt")));    				
	                psnl2100Vo.setKybdr(sessionUser.getUsrId());    																	
	                psnl2100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    								
	                psnl2100Vo.setIsmt(sessionUser.getUsrId());																			
	                psnl2100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  */  								
	                
//	                System.out.println("직종세구분코드 : " + psnl2100Vo.getDtilOccuClsDivCd());
//	                System.out.println("휴가일수이상 : " + psnl2100Vo.getHodyNumDysOvr());
//	                System.out.println("휴가일수미만 : " + psnl2100Vo.getHodyNumDysUdr());
//	                System.out.println("휴가일수유형코드 : " + psnl2100Vo.getHodyNumDysFrmCd());
//	                System.out.println("휴가일수 : " + psnl2100Vo.getHodyNumDys());
//	                System.out.println("휴가일수율 : " + psnl2100Vo.getHodyNumDysRate());
//	               
//	                System.out.println("휴가일수종료일자 : " + psnl2100Vo.getHodyNumDysEndDt());
//	                System.out.println("휴가일수사용여부 : " + psnl2100Vo.getHodyNumDysUseYn());
//	                System.out.println("휴가일수비고내용 : " + psnl2100Vo.getHodyNumDysNoteCtnt());
//	                System.out.println("입력자 : " + psnl2100Vo.getKybdr());
//	                System.out.println("입력주소" + psnl2100Vo.getInptAddr());
//	                System.out.println("수정주소 : " + psnl2100Vo.getRevnAddr());
	                
	                 
//	                 psnl2100Vo.setDpobCd(MSFSharedUtils.defaultNulls(objectBm.get("dpobCd"),sessionUser.getDpobCd()));    /** column 사업장코드 : dpobCd */
//	                 psnl2100Vo.setSevePayAddRateSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(objectBm.get("sevePayAddRateSeilNum"),"0")));    /** column 퇴직금가산율일련번호 : sevePayAddRateSeilNum */
	                 
	               
//	               if (MSFSharedUtils.paramNotNull(objectBm.get("typOccuCd$typOccuCd")) && (!MSFSharedUtils.allowNulls(objectBm.get("typOccuCd$typOccuCd")).equals("!")) ) {
//	                   String[] tptypOccuCd = MSFSharedUtils.allowNulls(objectBm.get("typOccuCd$typOccuCd")).split("!"); 
//	                   psnl2100Vo.setTypOccuCd(tptypOccuCd[0]);    /** column 직종코드 : typOccuCd */
//	                   psnl2100Vo.setPyspGrdeCd(tptypOccuCd[1]);    /** column 호봉등급코드 : pyspGrdeCd */
//	               } else {
//	                   psnl2100Vo.setTypOccuCd("");    /** column 직종코드 : typOccuCd */
//	                   psnl2100Vo.setPyspGrdeCd("");    /** column 호봉등급코드 : pyspGrdeCd */  
//	               }
	                 
//	                 psnl2100Vo.setSevePayAddRateFrmCd(MSFSharedUtils.allowNulls(objectBm.get("sevePayAddRateFrmCd$commCd")));    /** column 퇴직금가산율유형코드 : sevePayAddRateFrmCd */
//	                 psnl2100Vo.setSevePayAddOvr(MSFSharedUtils.allowNulls(objectBm.get("sevePayAddOvr")));    /** column 퇴직금가산이상 : sevePayAddOvr */
//	                 psnl2100Vo.setSevePayAddUdr(MSFSharedUtils.allowNulls(objectBm.get("sevePayAddUdr")));    /** column 퇴직금가산미만 : sevePayAddUdr */
//	                 psnl2100Vo.setSevePayAddSum(new BigDecimal(MSFSharedUtils.defaultNulls(objectBm.get("sevePayAddSum"),"0")));    /** column 퇴직금가산금액 : sevePayAddSum */
//	                 psnl2100Vo.setSevePayAddRate(MSFSharedUtils.allowNulls(objectBm.get("sevePayAddRate")));    /** column 퇴직금가산율 : sevePayAddRate */
//	                 psnl2100Vo.setSevePayAddBgnnDt(new SimpleDateFormat("yyyyMMdd").format((Date)objectBm.get("sevePayAddBgnnDt")) );    /** column 퇴직금가산시작일자 : sevePayAddBgnnDt */
//	                 psnl2100Vo.setSevePayAddEndDt(new SimpleDateFormat("yyyyMMdd").format((Date)objectBm.get("sevePayAddEndDt")));    /** column 퇴직금가산종료일자 : sevePayAddEndDt */
//	                 psnl2100Vo.setSevePayAddUseYn(Boolean.TRUE.equals( (Boolean)objectBm.get("sevePayAddUseYn")) ? "Y" : "N" );    /** column 퇴직금가산사용여부 : sevePayAddUseYn */
	                 
	                 
//	                 psnl2100Vo.setSevePayNoteCtnt(MSFSharedUtils.allowNulls(objectBm.get("sevePayNoteCtnt")));    /** column 퇴직금비고내용 : sevePayNoteCtnt */
//	                 psnl2100Vo.setKybdr(dlgn0200Vo.getKybdr());    /** column 입력자 : kybdr */
//	                 psnl2100Vo.setInptDt(dlgn0200Vo.getInptDt());    /** column 입력일자 : inptDt */
//	                 psnl2100Vo.setInptAddr(dlgn0200Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//	                 psnl2100Vo.setIsmt(dlgn0200Vo.getIsmt());    /** column 수정자 : ismt */
//	                 psnl2100Vo.setRevnDt(dlgn0200Vo.getRevnDt());    /** column 수정일자 : revnDt */
//	                 psnl2100Vo.setRevnAddr(dlgn0200Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
	                   
	               /* switch (actionDatabase) {
	                case INSERT: 
	                	psnl2100DAO.insertPsnl2100(psnl2100Vo); 
	                	break;
	                case UPDATE:  
	                	psnl2100DAO.updatePsnl2100(psnl2100Vo); 
	                	break;
	                case DELETE: 
	                	psnl2100DAO.deletePsnl2100(psnl2100Vo);
	                	break;
	                } 
	                */
	    			/** 로그반영
	    			 * CRUDSBLO
	    			 * C:create		R:read		U:update
	    	    	 * D:delete		S:select	B:배치 
	    	    	 * L:로그인		O:로그아웃
	    	    	 */
	 /*MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
	        	} 
	        }
	        catch (Exception ex) {
	        	logger.error("EXCEPTION calling activityOnBass0310ToPsnl2100Save(): "+ex); 
	        	
	        				
	        	MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),ex, windowNm , windowId);
	        	
	        	ex.printStackTrace();
	        	result = "0";
	        }finally {
	           
	        }
	        return lsBmResult;
	        
		}*/
	 
	 
 @Override
 public Long saveBass0310(Psnl2100DTO dto, ActionDatabase actionDatabase) throws MSFException {
 	Long returnCnt = 0L;
 	
 	String method = CLASS_BASS0310_PSNL2100_SAVE;
 	
 	String windowNm = "휴가일수관리";
 	String windowId = "BASS0310";


 	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
 	
 	/*if("".equals(psnl2100Dto.getDpobCd()) || psnl2100Dto.getDpobCd() == null){
 		psnl2100Dto.setDpobCd(sessionUser.getDpobCd());
 	}*/
 	
 	if("".equals(dto.getDpobCd()) || dto.getDpobCd() == null){
 		dto.setDpobCd(sessionUser.getDpobCd());
	}
 	
 	Psnl2100VO psnl2100Vo = new Psnl2100VO();
 	

 	psnl2100Vo.setDpobCd(MSFSharedUtils.allowNulls(dto.getDpobCd()));    /** column 사업장코드 : dpobCd */
 	psnl2100Vo.setHodyNumDysSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(dto.getHodyNumDysSeilNum(), "0"))); /** column 휴가일수일련번호 : hodyNumDysSeilNum */
 	psnl2100Vo.setTypOccuCd(MSFSharedUtils.allowNulls(dto.getTypOccuCd()));    /** column 직종코드 : typOccuCd */
 	psnl2100Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(dto.getPyspGrdeCd()));	/** column 호봉등급코드 : pyspGrdeCd */
 	psnl2100Vo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(dto.getDtilOccuClsDivCd()));	/** column 직종세구분코드 : dtilOccuClsDivCd */
 	psnl2100Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(dto.getDtilOccuClsDivCd()));			/** column 직종세통합코드 : dtilOccuInttnCd */
 	psnl2100Vo.setHodyNumDysOvr(new BigDecimal(MSFSharedUtils.defaultNulls(dto.getHodyNumDysOvr(), "0")));	/** column 휴가일수이상 : hodyNumDysOvr */
 	psnl2100Vo.setHodyNumDysUdr(new BigDecimal(MSFSharedUtils.defaultNulls(dto.getHodyNumDysUdr(), "0")));	/** column 휴가일수미만 : hodyNumDysUdr */
 	psnl2100Vo.setHodyNumDysFrmCd(MSFSharedUtils.allowNulls(dto.getHodyNumDysFrmCd()));		/** column 휴가일수유형코드 : hodyNumDysFrmCd */
 	psnl2100Vo.setHodyNumDys(new BigDecimal(MSFSharedUtils.defaultNulls(dto.getHodyNumDys(), "0")));	/** column 휴가일수 : hodyNumDys */
 	psnl2100Vo.setHodyNumDysRate(new BigDecimal(MSFSharedUtils.defaultNulls(dto.getHodyNumDysRate(), "0")));		/** column 휴가일수율 : hodyNumDysRate */
 	psnl2100Vo.setHodyNumDysBgnnDt(MSFSharedUtils.allowNulls(dto.getHodyNumDysBgnnDt()));		/** column 휴가일수시작일자 : hodyNumDysBgnnDt */
 	psnl2100Vo.setHodyNumDysEndDt(MSFSharedUtils.allowNulls(dto.getHodyNumDysEndDt()));			/** column 휴가일수종료일자 : hodyNumDysEndDt */
 	psnl2100Vo.setHodyNumDysNoteCtnt(MSFSharedUtils.allowNulls(dto.getHodyNumDysNoteCtnt()));	/** column 휴가일수비고내용 : hodyNumDysNoteCtnt */
 	psnl2100Vo.setHodyNumDysUseYn(MSFSharedUtils.allowNulls((Boolean.TRUE.equals(dto.getHodyNumDysUseYn()) ? "Y" : "N") ));    /** column 휴가일수사용여부 : hodyNumDysUseYn */
 	psnl2100Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
	//psnl2100Vo.setInptDt(bass0320Dto.getInptDt());    /** column 입력일자 : inptDt */
 	psnl2100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
 	psnl2100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
	//psnl2100Vo.setRevnDt(bass0320Dto.getRevnDt());    /** column 수정일자 : revnDt */
 	psnl2100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
 	
   
 	
 	
 	try { 
 		  	
 		switch(actionDatabase){
 			case INSERT : 
 				psnl2100DAO.insertPsnl2100(psnl2100Vo);
 				break;
 			case UPDATE : 
 				psnl2100DAO.updatePsnl2100(psnl2100Vo);
 				break;
 			case DELETE : 
 				psnl2100DAO.deletePsnl2100(psnl2100Vo);
 				break;
 			}
 	
 		
 		/** 로그반영
 		 * CRUDSBLO
 		 * C:create		R:read		U:update
     	 * D:delete		S:select	B:배치 
     	 * L:로그인		O:로그아웃
     	 */
 		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, CLASS_BASS0310_PSNL2100_SAVE, actionDatabase.toString());
 		
 		 returnCnt = 1L;
 		 
 	}catch (Exception e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 		
 		/** 에러 로그 **/			
 		MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,CLASS_BASS0310_PSNL2100_SAVE,actionDatabase.toString(),e, windowNm , windowId);
 		
 		returnCnt = 0L;
 		}
 	return returnCnt;
 }
 
 @Override
 public Long copyBass0310(Psnl2100DTO dto, ActionDatabase actionDatabase) throws MSFException {
 	Long returnCnt = 0L;
 	
 	String method = CLASS_BASS0310_PSNL2100_COPY;
 	
 	String windowNm = "휴가일수관리";
 	String windowId = "BASS0310";


 	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
 	
 	if("".equals(dto.getDpobCd()) || dto.getDpobCd() == null){
 		dto.setDpobCd(sessionUser.getDpobCd());
	}
 	
 	Psnl2100VO psnl2100Vo = new Psnl2100VO();
 	psnl2100Vo.setDpobCd(dto.getDpobCd());
 	psnl2100Vo.setTypOccuCd(dto.getBasicTypOccuCd());
 	psnl2100Vo.setDtilOccuInttnCd(dto.getBasicDtilOccuClsDivCd()); 	
 	List<Psnl2100VO> psnl2100List;
 	psnl2100List =  psnl2100DAO.selectCopyPsnl2100_D(psnl2100Vo);
 	
   
 	try { 
 		
 		for(int iPsnlCnt=0;iPsnlCnt < psnl2100List.size();iPsnlCnt++) {
			
			System.out.println("listsize======================"+psnl2100List.size());	
			
			psnl2100Vo = new Psnl2100VO();			
			
			psnl2100Vo = psnl2100List.get(iPsnlCnt);
					
			psnl2100Vo.setBasicDtilOccuClsDivCd(dto.getBasicDtilOccuClsDivCd());
			psnl2100Vo.setTypOccuCd(dto.getTargetTypOccuCd());
			psnl2100Vo.setDtilOccuInttnCd(dto.getTargetDtilOccuClsDivCd());			
			psnl2100Vo.setHodyNumDysBgnnDt(dto.getApplicationDate());
			psnl2100Vo.setHodyNumDysEndDt("99991231");
			psnl2100Vo.setHodyNumDysUseYn("Y");
			psnl2100Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
		 	psnl2100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
		 	psnl2100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
		 	psnl2100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
		 	
		 	
			switch(actionDatabase){
 			case INSERT : 
 				psnl2100DAO.insertCopyPsnl2100(psnl2100Vo);
 				psnl2100DAO.updateCopyPsnl2100(psnl2100Vo);
 				break;
 			}			
				                    
		} 
 		
 		/** 로그반영
 		 * CRUDSBLO
 		 * C:create		R:read		U:update
     	 * D:delete		S:select	B:배치 
     	 * L:로그인		O:로그아웃
     	 */
 		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, CLASS_BASS0310_PSNL2100_COPY, actionDatabase.toString());
 		
 		 returnCnt = 1L;
 		 
 	}catch (Exception e) {
 		// TODO Auto-generated catch block
 		e.printStackTrace();
 		
 		/** 에러 로그 **/			
 		MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,CLASS_BASS0310_PSNL2100_COPY,actionDatabase.toString(),e, windowNm , windowId);
 		
 		returnCnt = 0L;
 		}
 	return returnCnt;
 }
   
	
//	/**
//	 * PSNL2100을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Psnl2100VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertPsnl2100(Psnl2100VO vo) throws Exception {
//    	log.debug(vo.toString());
//    	
//    	/** ID Generation Service */
//    	//TODO 해당 테이블 속성에 따라 ID 제너레이션 서비스 사용
//    	//String id = egovIdGnrService.getNextStringId();
//    	//vo.setId(id);
//    	log.debug(vo.toString());
//    	
//    	psnl2100DAO.insertPsnl2100(vo);
//    	//TODO 해당 테이블 정보에 맞게 수정    	
//        return null;
//    }
//
//    /**
//	 * PSNL2100을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Psnl2100VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    public void updatePsnl2100(Psnl2100VO vo) throws Exception {
//        psnl2100DAO.updatePsnl2100(vo);
//    }
//
//    /**
//	 * PSNL2100을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Psnl2100VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    public void deletePsnl2100(Psnl2100VO vo) throws Exception {
//        psnl2100DAO.deletePsnl2100(vo);
//    }
//
//    /**
//	 * PSNL2100을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Psnl2100VO
//	 * @return 조회한 PSNL2100
//	 * @exception Exception
//	 */
//    public Psnl2100VO selectPsnl2100(Psnl2100VO vo) throws Exception {
//        Psnl2100VO resultVO = psnl2100DAO.selectPsnl2100(vo);
//        if (resultVO == null)
//            throw processException("info.nodata.msg");
//        return resultVO;
//    }
//
//    /**
//	 * PSNL2100 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PSNL2100 목록
//	 * @exception Exception
//	 */
//    public List selectPsnl2100List(Psnl2100SrhVO searchVO) throws Exception {
//        return psnl2100DAO.selectPsnl2100List(searchVO);
//    }
//
//    /**
//	 * PSNL2100 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PSNL2100 총 갯수
//	 * @exception
//	 */
//    public int selectPsnl2100ListTotCnt(Psnl2100SrhVO searchVO) {
//		return psnl2100DAO.selectPsnl2100ListTotCnt(searchVO);
//	}
    
}
