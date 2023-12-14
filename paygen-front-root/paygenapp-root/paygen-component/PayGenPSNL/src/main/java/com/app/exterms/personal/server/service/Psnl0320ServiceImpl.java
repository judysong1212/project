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

import com.app.exterms.personal.client.dto.Psnl0119DTO;
import com.app.exterms.personal.client.dto.Psnl0122DTO;
import com.app.exterms.personal.client.dto.Psnl0320DTO;
import com.app.exterms.personal.client.service.Psnl0320Service;
import com.app.exterms.personal.server.service.dao.Psnl0100DAO;
import com.app.exterms.personal.server.service.dao.Psnl0112DAO;
import com.app.exterms.personal.server.service.dao.Psnl0320DAO;
import com.app.exterms.personal.server.vo.Psnl0100VO;
import com.app.exterms.personal.server.vo.Psnl0112VO;
import com.app.exterms.personal.server.vo.Psnl0119VO;
import com.app.exterms.personal.server.vo.Psnl0122VO;
import com.app.exterms.personal.server.vo.Psnl0320SrhVO;
import com.app.exterms.personal.server.vo.Psnl0320VO;
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

import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : Psnl0320ServiceImpl.java
 * @Description : Psnl0320 Business Implement class
 * @Modification Information
 *
 * @author atres
 * @since 2014.05.27
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */

 
@Service("Psnl0320Service")
public class Psnl0320ServiceImpl extends AbstractCustomServiceImpl  implements Psnl0320Service, PsnlDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Psnl0320ServiceImpl.class);
	    
	@Autowired
    @Resource(name="psnl0320DAO")
    private Psnl0320DAO psnl0320DAO;
	
	@Autowired
    @Resource(name="psnl0100DAO")
    private Psnl0100DAO psnl0100DAO;
	
	@Autowired
    @Resource(name="psnl0112DAO")
    private Psnl0112DAO psnl0112DAO;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PagingLoadResult<BaseModel> getPsnl0100ToPsnl0320DataList(ServiceParameters serviceParameters)throws MSFException {

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0320_DATA_LIST_LEFT;
		Psnl0320SrhVO psnl0320SrhVo = new Psnl0320SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		if  (MSFSharedUtils.paramNull(psnl0320DAO))
		{
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			psnl0320DAO = (Psnl0320DAO) wac.getBean("psnl0320DAO");
		}

		try
		{
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			 
			
			//TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
			//Sysm0400BM user             = serviceParameters.getUser();
			ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
			PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();


			//Get paging configuration
			PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
			List<String> listDeptCd = new ArrayList<String>();
			/** 조건절 */ 
			
			
			psnl0320SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
			psnl0320SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 

			psnl0320SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));//고용구분코드
			psnl0320SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")));
			psnl0320SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")));       //호봉제 구분
			psnl0320SrhVo.setUsrId(sessionUser.getUsrId());  
			psnl0320SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
			psnl0320SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));

            /******************************** 권한 ************************************************************************/
			String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
			if ("FALSE".equals(chkDeptCd))
			{
				psnl0320SrhVo.setDeptCd(sessionUser.getDeptCd()); 
				listDeptCd.add(sessionUser.getDeptCd());
				psnl0320SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
				psnl0320SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
			} else
			{
				psnl0320SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
				if (psnl0320SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))))
				{
					listDeptCd = null; 
					psnl0320SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
					psnl0320SrhVo.setDeptCd("");  //부서코드
				} else
				{
					psnl0320SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
					listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
					psnl0320SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
				}
			}


            /******************************** 권한 ************************************************************************/
			
			psnl0320SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
			
			List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
			psnl0320SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
			psnl0320SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
			psnl0320SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			psnl0320SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
			
			List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
			psnl0320SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
			psnl0320SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태

			psnl0320SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
			psnl0320SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
			


			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ){
				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);

				int iResultCnt = psnl0320DAO.selectPsnl0100PagingTotCnt(psnl0320SrhVo);
				if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }

				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
				pagingValues.totalRecordCount = iResultCnt;	 
				
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginPsnl0100ToPsnl0320DataList = SmrmfUtils.startTiming(logger);

			/**페이지 카운트 처리를 위한 부분 */ 
			psnl0320SrhVo.setPageSize(pagingValues.totalRecordCount);  

			//Apply paging
			if (pagingValues.start > 0){
				psnl0320SrhVo.setFirstIndex(pagingValues.start);
			}

			if (pagingValues.offsetLimit > 0){
				psnl0320SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
			}

			List list = psnl0320DAO.getPsnl0100ToPsnl0320DataList(psnl0320SrhVo);



			Iterator<Map<String, Object>> iter = list.iterator();


            while ( iter.hasNext() )
            {
				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = map.get("systemkey").toString();



				BaseModel bm = new BaseModel();


                //bm.setProperties(map);
				for ( int i=0 ; i<tableAttributes.length ; i++ )
				{
					//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
					Object mapCon = map.get(tableAttributes[i].getName());  

					switch ( tableAttributes[i].getType() ) {
					   case ColumnDef.TYPE_STRING: 
	                    	String strValue = String.valueOf(mapCon);
	                    	if("resnRegnNum".equals(tableAttributes[i].getName())) {
	                    		// TODO 주민번호
	                    		//nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	                    		strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	                    	}
	                    	
	                    	map.put(tableAttributes[i].getName(), MSFSharedUtils.allowNulls(strValue));
	                    	break;

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
					if (tableAttributes[i].getName().contains("$"))
					{
						String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
						map.put(tableAttributes[i].getName(),map.get(strMapCon));

						baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
						map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
					} else
					{
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

			SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToPsnl0320DataList, "getPsnl0100ToPsnl0320DataList");
		}catch (Exception ex) 
		{
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 공무직 데이타 가져오기 고용테이블  
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getPsnl0110ToPsnl0320DataList
	 * @date : 2017. 5. 19.
	 * @author : atres
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 5. 19.		atres				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PagingLoadResult<BaseModel> getPsnl0110ToPsnl0320DataList(ServiceParameters serviceParameters)throws MSFException {
		// TODO Auto-generated method stub
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0320_DATA_LIST_RIGHT10;
		Psnl0320SrhVO psnl0320SrhVo = new Psnl0320SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();


		try {

    		if  (MSFSharedUtils.paramNull(psnl0320DAO)) {

    			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
    			psnl0320DAO = (Psnl0320DAO) wac.getBean("psnl0320DAO");
            }


            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);


logger.debug("getPsnl0110ToPsnl0320DataList");
logger.debug("systemkey[" + MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")) + "]");
logger.debug("dpobCd[" + MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dpobCd")) + "]");
logger.debug("단위기관[" + MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")) + "]");
logger.debug("재직[" + MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")) + "]");
logger.debug("고용구분[" + MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")) + "]");
logger.debug("성명[" + MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")) + "]");
logger.debug("부서[" + MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")) + "]");


logger.debug("columnFilters[" + columnFilters + "]");


			psnl0320SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));
			psnl0320SrhVo.setDpobCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dpobCd")));
			
			/*************************************************************************************
			 *  공무직 데이타만 가져오기 위해 수정 
			 *************************************************************************************/
			psnl0320SrhVo.setEmymtDivCd("A0020010"); 
			
			

			//@SuppressWarnings("unchecked")
			List list = psnl0320DAO.getPsnl0110ToPsnl0320DataList(psnl0320SrhVo);


			Iterator<Map<String, Object>> iter = list.iterator();


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
            
            //SmrmfUtils.endTiming(logger, millisBeginInsr3150ToInsr4200DataList, "getInsr3150ToInsr4200DataList");

 
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PagingLoadResult<BaseModel> getPsnl0110ToPsnl032001DataList(ServiceParameters serviceParameters)throws MSFException {
		// TODO Auto-generated method stub
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0320_DATA_LIST_RIGHT20;
		Psnl0320SrhVO psnl0320SrhVo = new Psnl0320SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();


		try {

    		if  (MSFSharedUtils.paramNull(psnl0320DAO)) {

    			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
    			psnl0320DAO = (Psnl0320DAO) wac.getBean("psnl0320DAO");
            }


            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 

			psnl0320SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));
			psnl0320SrhVo.setDpobCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dpobCd")));
			
			/*************************************************************************************
			 *  기간제 데이타만 가져오기 위해 수정 빈데이타도 기간제로취급함 
			 *************************************************************************************/
			psnl0320SrhVo.setEmymtDivCd("A0020020"); 
 
			//@SuppressWarnings("unchecked")
			List list = psnl0320DAO.getPsnl0110ToPsnl0320DataList(psnl0320SrhVo);


			Iterator<Map<String, Object>> iter = list.iterator();


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
            
            //SmrmfUtils.endTiming(logger, millisBeginInsr3150ToInsr4200DataList, "getInsr3150ToInsr4200DataList");

 
        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PagingLoadResult<BaseModel> getPsnl0119ToPsnl0320DataList(ServiceParameters serviceParameters)throws MSFException {
		// TODO Auto-generated method stub
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0320_DATA_LIST_RIGHT30;
		Psnl0320SrhVO psnl0320SrhVo = new Psnl0320SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();


		try {

    		if  (MSFSharedUtils.paramNull(psnl0320DAO)) {

    			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
    			psnl0320DAO = (Psnl0320DAO) wac.getBean("psnl0320DAO");
            }

            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);



			psnl0320SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));
			psnl0320SrhVo.setDpobCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dpobCd")));


			//@SuppressWarnings("unchecked")
			List list = psnl0320DAO.getPsnl0119ToPsnl0320DataList(psnl0320SrhVo);


			Iterator<Map<String, Object>> iter = list.iterator();


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
            
            //SmrmfUtils.endTiming(logger, millisBeginInsr3150ToInsr4200DataList, "getInsr3150ToInsr4200DataList");


        }catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PagingLoadResult<BaseModel> getPsnl0122ToPsnl0320DataList(ServiceParameters serviceParameters)throws MSFException {
		// TODO Auto-generated method stub
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0320_DATA_LIST_RIGHT40;
		Psnl0320SrhVO psnl0320SrhVo = new Psnl0320SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
 
		try {

    		if  (MSFSharedUtils.paramNull(psnl0320DAO)) {

    			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
    			psnl0320DAO = (Psnl0320DAO) wac.getBean("psnl0320DAO");
            }

 
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

logger.debug("systemkey[" + MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")) + "]");
logger.debug("dpobCd[" + MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dpobCd")) + "]");


			psnl0320SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));
			psnl0320SrhVo.setDpobCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dpobCd")));

 
			//@SuppressWarnings("unchecked")
			List list = psnl0320DAO.getPsnl0122ToPsnl0320DataList(psnl0320SrhVo);


			Iterator<Map<String, Object>> iter = list.iterator();


            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next(); 
                String idValue = map.get("systemkey").toString();  

                BaseModel bm = new BaseModel();
 
                //bm.setProperties(map);
                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
                	Object mapCon = map.get(tableAttributes[i].getName());  

                	switch ( tableAttributes[i].getType() )
                	{
						case ColumnDef.TYPE_DATE: 
						case ColumnDef.TYPE_DATETIME: 
							Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"yyyyMMdd");
							map.put(tableAttributes[i].getName(), value);
							break; 

						case ColumnDef.TYPE_LONG:

							if (mapCon != null)
							{  
								Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
								map.put(tableAttributes[i].getName(), lValue); 
							}
							break;
						case ColumnDef.TYPE_DOUBLE:  
							if (mapCon != null)
							{
								Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue(); 
								map.put(tableAttributes[i].getName(), dbValue); 
							}
							break;
					}

					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
					Object baseModelValue = null;
                    //콤보박스처리를 위해 추가함
					if (tableAttributes[i].getName().contains("$"))
					{
						String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();

						map.put(tableAttributes[i].getName(),map.get(strMapCon));

						baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    } else
					{
						baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
					}
					/**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
					bm.set(tableAttributes[i].getName(), baseModelValue);
				}

				bm.set(TableDef.ID_PROPERTY_NAME, idValue);
				bmResult.add(bm);
			}

			retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  

            //SmrmfUtils.endTiming(logger, millisBeginInsr3150ToInsr4200DataList, "getInsr3150ToInsr4200DataList");


		}catch (Exception ex)
		{
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}

	@Override
	public Long updatePsnl0110(List<Psnl0320DTO> listPsnl0320dto) throws MSFException
	{
		// TODO Auto-generated method stub
		Long result = new Long(0);


		logger.debug("====updatePsnl0110====");
		try
		{
			if  (MSFSharedUtils.paramNull(psnl0320DAO))
			{
				WebApplicationContext wac = WebApplicationContextUtils.
				getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

				psnl0320DAO = (Psnl0320DAO) wac.getBean("psnl0320DAO" );
			}


			for(int i=0; i<listPsnl0320dto.size(); i++)
			{
				Psnl0320DTO psnl0320dto = (Psnl0320DTO)listPsnl0320dto.get(i);
				Psnl0320VO psnl0320vo = new Psnl0320VO();


				psnl0320vo.setCalMode("");
				psnl0320vo.setYearDay(365.25);  
				psnl0320vo.setMonthDay(30.4375); 
				
				logger.debug("getDpobCd[" + psnl0320dto.getDpobCd() + "]");
				logger.debug("getSystemkey[" + psnl0320dto.getSystemkey() + "]");
				logger.debug("getEmymtSeilNum[" + psnl0320dto.getEmymtSeilNum() + "]");
				logger.debug("getEmymtDivCd[" + psnl0320dto.getEmymtDivCd() + "]");
				logger.debug("getEmymtTypCd[" + psnl0320dto.getEmymtTypCd() + "]");
				logger.debug("getEmymtBgnnDt[" + psnl0320dto.getEmymtBgnnDt() + "]");
				logger.debug("getEmymtEndDt[" + psnl0320dto.getEmymtEndDt() + "]");
				logger.debug("getTypOccuCd[" + psnl0320dto.getTypOccuCd() + "]");
				logger.debug("getDtilOccuClsDivCd[" + psnl0320dto.getDtilOccuClsDivCd() + "]");
				logger.debug("getCvsnRtoDivCd[" + psnl0320dto.getCvsnRtoDivCd() + "]");


				psnl0320vo.setDpobCd(psnl0320dto.getDpobCd());
				psnl0320vo.setSystemkey(psnl0320dto.getSystemkey());
				psnl0320vo.setEmymtSeilNum(psnl0320dto.getEmymtSeilNum());
				psnl0320vo.setEmymtDivCd(psnl0320dto.getEmymtDivCd());
				psnl0320vo.setEmymtTypCd(psnl0320dto.getEmymtTypCd());
				psnl0320vo.setEmymtBgnnDt(psnl0320dto.getEmymtBgnnDt());
				psnl0320vo.setEmymtEndDt(psnl0320dto.getEmymtEndDt());
				psnl0320vo.setDeptCd(psnl0320dto.getDeptCd());
				psnl0320vo.setTypOccuCd(psnl0320dto.getTypOccuCd());
				psnl0320vo.setDtilOccuClsDivCd(psnl0320dto.getDtilOccuClsDivCd());
				psnl0320vo.setCvsnRtoDivCd(psnl0320dto.getCvsnRtoDivCd());


				psnl0320DAO.updatePsnl0110(psnl0320vo);
				result = 1L;
			}
		}catch (Exception ex)
		{
		    logger.error("EXCEPTION calling updatePsnl0110(): "+ex); 

			result = new Long(-1);
			throw MSFServerUtils.getOperationException("updatePsnl0110", ex, logger);
		}finally
		{
			  
		}

		return result;
	}

	@Override
	public Long updatePsnl0119(List<Psnl0119DTO> listPsnl0119dto) throws MSFException {

		Long result = new Long(0);

		try
		{
			if  (MSFSharedUtils.paramNull(psnl0320DAO))
			{
				WebApplicationContext wac = WebApplicationContextUtils.
				getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

				psnl0320DAO = (Psnl0320DAO) wac.getBean("psnl0320DAO" ); 
			}

			//Iterator<Psnl0320DTO> iterRecords = (Iterator<Psnl0320DTO>)psnl0320dto.iterator();
			//Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();

			for(int i=0; i<listPsnl0119dto.size(); i++)
			{
				Psnl0119DTO psnl0119dto = (Psnl0119DTO)listPsnl0119dto.get(i);
				Psnl0119VO psnl0119vo = new Psnl0119VO();
				//TODO   calMode = TRUNC, ROUND, CEIL  미설정시 = TRUNC
				psnl0119vo.setCalMode("");
				psnl0119vo.setYearDay(365.25);  
				psnl0119vo.setMonthDay(30.4375); 


				logger.debug("getDpobCd[" + psnl0119dto.getDpobCd() + "]");
				logger.debug("getSystemkey[" + psnl0119dto.getSystemkey() + "]");
				logger.debug("getCarrRsptSeilNum[" + psnl0119dto.getCarrRsptSeilNum() + "]");
				logger.debug("getCarrBgnnDt[" + SmrmfUtils.getStringFromDate(psnl0119dto.getCarrBgnnDt(),"yyyyMMdd") + "]");
				logger.debug("getCarrEndDt[" + SmrmfUtils.getStringFromDate(psnl0119dto.getCarrEndDt(),"yyyyMMdd") + "]");
				logger.debug("getDutyDeptNm[" + psnl0119dto.getDutyDeptNm() + "]");
				logger.debug("getCarrDivCd[" + psnl0119dto.getCarrDivCd() + "]");
				logger.debug("getRepbtyBusinNm[" + psnl0119dto.getRepbtyBusinNm() + "]");
				logger.debug("getDutyYrNum[" + psnl0119dto.getDutyYrNum() + "]");
				logger.debug("getDutyMnthIcm[" + psnl0119dto.getDutyMnthIcm() + "]");
				logger.debug("getRcgtnMnthNum[" + psnl0119dto.getRcgtnMnthNum() + "]");
				logger.debug("getCvsnRtoDivCd[" + psnl0119dto.getCvsnRtoDivCd() + "]");


				psnl0119vo.setDpobCd(psnl0119dto.getDpobCd());
				psnl0119vo.setSystemkey(psnl0119dto.getSystemkey());
				psnl0119vo.setCarrRsptSeilNum(new BigDecimal(psnl0119dto.getCarrRsptSeilNum()));//경력사항일련번호
				psnl0119vo.setCarrBgnnDt(SmrmfUtils.getStringFromDate(psnl0119dto.getCarrBgnnDt(),"yyyyMMdd"));//근무시작일자(경력시작일자)
				psnl0119vo.setCarrEndDt(SmrmfUtils.getStringFromDate(psnl0119dto.getCarrEndDt(),"yyyyMMdd"));//근무종료일자(경력종료일자)
				psnl0119vo.setDutyDeptNm(psnl0119dto.getDutyDeptNm());//근무부서명(부서명)
				psnl0119vo.setCarrDivCd(psnl0119dto.getCarrDivCd());//경력구분코드
				psnl0119vo.setRepbtyBusinNm(psnl0119dto.getRepbtyBusinNm());//담당업무명
				psnl0119vo.setDutyYrNum(new BigDecimal(psnl0119dto.getDutyYrNum()));//근무년수
				psnl0119vo.setDutyMnthIcm(new BigDecimal(psnl0119dto.getDutyMnthIcm()));//근무월수
				psnl0119vo.setRcgtnMnthNum(new BigDecimal(psnl0119dto.getRcgtnMnthNum()));//인정월수
				psnl0119vo.setCvsnRtoDivCd(psnl0119dto.getCvsnRtoDivCd());//환산비율(경력인정???)
				psnl0119vo.setAjmtMnthNum(new BigDecimal(psnl0119dto.getAjmtMnthNum()));//가감월수
				
				psnl0320DAO.updatePsnl0119(psnl0119vo);
				result = 1L;
			}
		}catch (Exception ex)
		{
		    logger.error("EXCEPTION calling updatePsnl0110(): "+ex); 

			result = new Long(-1);
			throw MSFServerUtils.getOperationException("updatePsnl0110", ex, logger);
		}finally
		{
			  
		}

		return result;
	}

	@Override
	public Long updatePsnl0122(List<Psnl0122DTO> listPsnl0122dto) throws MSFException {
		Long result = new Long(0);

		try
		{
			if  (MSFSharedUtils.paramNull(psnl0320DAO))
			{
				WebApplicationContext wac = WebApplicationContextUtils.
				getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

				psnl0320DAO = (Psnl0320DAO) wac.getBean("psnl0320DAO" ); 
			}

			//Iterator<Psnl0320DTO> iterRecords = (Iterator<Psnl0320DTO>)psnl0320dto.iterator();
			//Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();

			for(int i=0; i<listPsnl0122dto.size(); i++)
			{
				Psnl0122DTO psnl0122dto = (Psnl0122DTO)listPsnl0122dto.get(i);
				Psnl0122VO psnl0122vo = new Psnl0122VO();
				//TODO   calMode = TRUNC, ROUND, CEIL  미설정시 = TRUNC
				psnl0122vo.setCalMode("");
				psnl0122vo.setYearDay(365.25);  
				psnl0122vo.setMonthDay(30.4375); 

				logger.debug("getDpobCd[" + psnl0122dto.getDpobCd() + "]");
				logger.debug("getSystemkey[" + psnl0122dto.getSystemkey() + "]");
				logger.debug("getDsnyActSeilNum[" + psnl0122dto.getDsnyActSeilNum() + "]");
				logger.debug("getDsnyActDsplDt[" + SmrmfUtils.getStringFromDate(psnl0122dto.getDsnyActDsplDt(),"yyyyMMdd") + "]");
				logger.debug("getDsnyActDivCd[" + psnl0122dto.getDsnyActDivCd() + "]");
				logger.debug("getDsnyActNm[" + psnl0122dto.getDsnyActNm() + "]");
				logger.debug("getDsnyActReasCtnt[" + psnl0122dto.getDsnyActReasCtnt() + "]");
				logger.debug("getDsnyActEctgOrgn[" + psnl0122dto.getDsnyActEctgOrgn() + "]");
				logger.debug("getDsnyActBgnnDt[" + SmrmfUtils.getStringFromDate(psnl0122dto.getDsnyActBgnnDt(),"yyyyMMdd") + "]");
				logger.debug("getDsnyActEndDt[" + SmrmfUtils.getStringFromDate(psnl0122dto.getDsnyActEndDt(),"yyyyMMdd") + "]");
				logger.debug("getDsnyActAnstyDt[" + SmrmfUtils.getStringFromDate(psnl0122dto.getDsnyActAnstyDt(),"yyyyMMdd") + "]");


				psnl0122vo.setDpobCd(psnl0122dto.getDpobCd());
				psnl0122vo.setSystemkey(psnl0122dto.getSystemkey());
				if (!"".equals(psnl0122dto.getDsnyActSeilNum()))
				{
					psnl0122vo.setDsnyActSeilNum(new BigDecimal(psnl0122dto.getDsnyActSeilNum()));
				}
				psnl0122vo.setDsnyActDsplDt(SmrmfUtils.getStringFromDate(psnl0122dto.getDsnyActDsplDt(),"yyyyMMdd"));
				psnl0122vo.setDsnyActDivCd(psnl0122dto.getDsnyActDivCd());
				psnl0122vo.setDsnyActNm(psnl0122dto.getDsnyActNm());
				psnl0122vo.setDsnyActReasCtnt(psnl0122dto.getDsnyActReasCtnt());
				psnl0122vo.setDsnyActEctgOrgn(psnl0122dto.getDsnyActEctgOrgn());
				psnl0122vo.setDsnyActBgnnDt(SmrmfUtils.getStringFromDate(psnl0122dto.getDsnyActBgnnDt(),"yyyyMMdd"));
				psnl0122vo.setDsnyActEndDt(SmrmfUtils.getStringFromDate(psnl0122dto.getDsnyActEndDt(),"yyyyMMdd"));
				psnl0122vo.setDsnyActAnstyDt(SmrmfUtils.getStringFromDate(psnl0122dto.getDsnyActAnstyDt(),"yyyyMMdd"));
				psnl0122vo.setDsnyActCtwpMnthIcm(new BigDecimal(psnl0122dto.getDsnyActCtwpMnthIcm()));

				psnl0320DAO.updatePsnl0122(psnl0122vo);
				result = 1L;
			}
		}catch (Exception ex)
		{
		    logger.error("EXCEPTION calling updatePsnl0110(): "+ex); 

			result = new Long(-1);
			throw MSFServerUtils.getOperationException("updatePsnl0110", ex, logger);
		}finally
		{
			  
		}

		return result;
	}

	@Override
	public Psnl0320DTO savePsnl0320(Psnl0320DTO psnl0320dto) throws MSFException {
		Psnl0320DTO resultDto = new Psnl0320DTO();
		try
		{
			if  (MSFSharedUtils.paramNull(psnl0320DAO))
			{
				WebApplicationContext wac = WebApplicationContextUtils.
				getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

				psnl0320DAO = (Psnl0320DAO) wac.getBean("Psnl0320DAO" ); 
			}

			Psnl0320VO psnl0320vo = new Psnl0320VO();
			
			//TODO   calMode = TRUNC, ROUND, CEIL  미설정시 = TRUNC
			psnl0320vo.setCalMode("");
			psnl0320vo.setYearDay(365.25);  
			psnl0320vo.setMonthDay(30.4375); 
			
			
			psnl0320vo.setDpobCd(psnl0320dto.getDpobCd());
			psnl0320vo.setSystemkey(psnl0320dto.getSystemkey());
			psnl0320vo.setPyspReMrkCalcDt(psnl0320dto.getPyspReMrkCalcDt());  //계산일자
			psnl0320vo.setServcRcgtnPridCd(psnl0320dto.getServcRcgtnPridCd());//군복무인정기간코드
	
			EgovMap eMap = psnl0320DAO.getLogSvcDysList(psnl0320vo);//근속일수/근속월수코드/근속년수코드 가져오기

			
			psnl0320vo.setLogStdBgnDt((String) eMap.get("logStdBgnDt")); //근속일자
			psnl0320vo.setPyspReMrkCalcDt((String) eMap.get("pyspReMrkCalcDt")); //호봉재획정계산일자
			psnl0320vo.setPyspCd((String) eMap.get("pyspCd"));//호봉코드
			psnl0320vo.setLogSvcYrNumCd((String) eMap.get("logSvcYrNumCd"));//근속년수코드
			psnl0320vo.setLogSvcMnthIcmCd((String) eMap.get("logSvcMnthIcmCd"));//근속월수코드
			psnl0320vo.setLogSvcDys((BigDecimal) eMap.get("logSvcDys"));//근속일수
			psnl0320vo.setTotLogSvcDys((BigDecimal) eMap.get("totLogSvcDys"));//총근속일수
			psnl0320vo.setOrgLogSvcYrCd((String) eMap.get("orgLogSvcYrCd"));//원근속년수코드
			psnl0320vo.setOrgLogSvcMnthCd((String) eMap.get("orgLogSvcMnthCd"));
			psnl0320vo.setOrgLogSvcDys((BigDecimal) eMap.get("orgLogSvcDys"));
			psnl0320vo.setOrgTotLogSvcDys((BigDecimal) eMap.get("orgTotLogSvcDys"));
			psnl0320vo.setReMrkDt((String) eMap.get("reMrkDt"));
			psnl0320vo.setPmtnScduDt((String) eMap.get("pmtnScduDt"));
			psnl0320vo.setPyspPrmtnScduDt((String) eMap.get("pyspPrmtnScduDt"));
			psnl0320vo.setEmymtRcgtnLogSvcYrNum((BigDecimal) eMap.get("emymtRcgtnLogSvcYrNum"));
			psnl0320vo.setEmymtRcgtnLogSvcMnthNum((BigDecimal) eMap.get("emymtRcgtnLogSvcMnthNum"));
			psnl0320vo.setEmymtRcgtnLogSvcDys((BigDecimal) eMap.get("emymtRcgtnLogSvcDys"));
			psnl0320vo.setMityCarrRcgtnLogSvcYrNum((BigDecimal) eMap.get("mityCarrRcgtnLogSvcYrNum"));
			psnl0320vo.setMityCarrRcgtnLogSvcMnth((BigDecimal) eMap.get("mityCarrRcgtnLogSvcMnth"));
			psnl0320vo.setMityCarrRcgtnLogSvcDys((BigDecimal) eMap.get("mityCarrRcgtnLogSvcDys"));
			psnl0320vo.setCarrRcgtnLogSvcYrNum((BigDecimal) eMap.get("carrRcgtnLogSvcYrNum"));
			psnl0320vo.setCarrRcgtnLogSvcMnthNum((BigDecimal) eMap.get("carrRcgtnLogSvcMnthNum"));
			psnl0320vo.setCarrRcgtnLogSvcDys((BigDecimal) eMap.get("carrRcgtnLogSvcDys"));
			psnl0320vo.setDsnyActCtwpMnthIcm((BigDecimal) eMap.get("dsnyActCtwpMnthIcm"));

			int pyspReMrkSeilNum = psnl0320DAO.getPyspReMrkSeilNum(psnl0320vo);

			psnl0320vo.setPyspReMrkSeilNum(new BigDecimal(pyspReMrkSeilNum));

			psnl0320DAO.savePsnl0320(psnl0320vo);

			EgovMap resultMap =  psnl0320DAO.getPsnl0320ListButtomResult(psnl0320vo);
			
			
			
			resultDto.setPyspCd((String) resultMap.get("pyspNm"));
			resultDto.setLogSvcYrNumCd((String) resultMap.get("logSvcYrNumNm"));
			resultDto.setLogSvcMnthIcmCd((String) resultMap.get("logSvcMnthIcmNm"));
			resultDto.setLogSvcDys(psnl0320vo.getLogSvcDys().toString());
			resultDto.setPyspReMrkSeilNum(Integer.toString(pyspReMrkSeilNum));
			resultDto.setMityCarrTotLogSvcDys(psnl0320vo.getMityCarrRcgtnLogSvcDys().toString());
			
			resultDto.setMityCarrTotLogSvcDys(eMap.get("mityCarrTotLogSvcDys").toString());

			
			
			
		}catch (Exception ex)
		{
		    logger.error("EXCEPTION calling savePsnl0320(): "+ex); 

		    resultDto = null;
			throw MSFServerUtils.getOperationException("savePsnl0320()", ex, logger);
		}finally
		{
			  
		}
		return resultDto;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public PagingLoadResult<BaseModel> getPsnl0320ListButtom(ServiceParameters serviceParameters)throws MSFException {
		// TODO Auto-generated method stub


		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0320_DATA_LIST_BUTTOM;
		Psnl0320SrhVO psnl0320SrhVo = new Psnl0320SrhVO();
		Psnl0320VO psnl0320vo = new Psnl0320VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());


		if  (MSFSharedUtils.paramNull(psnl0320DAO))
		{
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			psnl0320DAO = (Psnl0320DAO) wac.getBean("psnl0320DAO");
		}

		try
		{
			//TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
			//Sysm0400BM user             = serviceParameters.getUser();
			ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
			PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

			//Get paging configuration
			PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
			/** 조건절 */
			psnl0320vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
			psnl0320vo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키


			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount )
			{
				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);


				int iResultCnt =  0;
				iResultCnt = psnl0320DAO.getPsnl0320ListButtomCnt(psnl0320vo);


				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");

				
				/**  ----------------------------이 부분 추가해 주세요----------------------- **/
				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute)
				{ 
					pagingValues.offsetLimit = iResultCnt;       
				}

				/**  ----------------------------이 부분 추가해 주세요----------------------- **/
				pagingValues.totalRecordCount = iResultCnt;	       
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}

			TimingInfo millisBeginPsnl0100ToPsnl0320DataList = SmrmfUtils.startTiming(logger);

			/**페이지 카운트 처리를 위한 부분 */ 
			psnl0320SrhVo.setPageSize(pagingValues.totalRecordCount);  


			//Apply paging
			if (pagingValues.start > 0)
			{
				psnl0320SrhVo.setFirstIndex(pagingValues.start);
			}


			if (pagingValues.offsetLimit > 0)
			{
				psnl0320SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
			}

	        //Execute query and convert to BaseModel list
	        //TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);


	logger.debug("444444");
			List list = psnl0320DAO.getPsnl0320ListButtom(psnl0320vo);
	logger.debug("444444.1");


			Iterator<Map<String, Object>> iter = list.iterator();


	        while ( iter.hasNext() )
	        {
				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = map.get("systemkey").toString();
	//log.debug("map[" + map + "]");


				BaseModel bm = new BaseModel();


	            //bm.setProperties(map);
				for ( int i=0 ; i<tableAttributes.length ; i++ )
				{
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
					if (tableAttributes[i].getName().contains("$"))
					{
						String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
						map.put(tableAttributes[i].getName(),map.get(strMapCon));

						baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
						map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
					} else
					{
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

			SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToPsnl0320DataList, "getPsnl0100ToPsnl0320DataList");
		}catch (Exception ex) 
		{
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HashMap<String, String>> selectPsnl0320(HashMap<String, String> param) throws Exception {
		// TODO Auto-generated method stub
		List<HashMap<String, String>> resultData = new ArrayList<HashMap<String, String>>();
		try {

			resultData = psnl0320DAO.selectPsnl0320(param);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger); 
		}

		return resultData;
		//return null;
	}
	
	//인사 마스터 업데이트
	@Override
	public Psnl0320DTO updatePsnl0100(Psnl0320DTO psnl0320dto) throws MSFException
	{
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		Long result = new Long(0);
		
		Psnl0320DTO resultDto = new Psnl0320DTO();
		
		try
		{
			if  (MSFSharedUtils.paramNull(psnl0100DAO))
			{
				WebApplicationContext wac = WebApplicationContextUtils.
				getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				psnl0100DAO = (Psnl0100DAO) wac.getBean("psnl0100DAO" );
			}
			if  (MSFSharedUtils.paramNull(psnl0112DAO))
			{
				WebApplicationContext wac = WebApplicationContextUtils.
				getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				psnl0112DAO = (Psnl0112DAO) wac.getBean("psnl0112DAO" );
			}
			
				Psnl0320VO psnl0320vo = new Psnl0320VO();
				Psnl0100VO psnl0100Vo = new Psnl0100VO();
				psnl0320vo.setDpobCd(psnl0320dto.getDpobCd());
				psnl0320vo.setSystemkey(psnl0320dto.getSystemkey());
				psnl0320vo.setPyspReMrkSeilNum(new BigDecimal(psnl0320dto.getPyspReMrkSeilNum()));
				
				EgovMap resultMap =  psnl0320DAO.getPsnl0320ListButtomResult(psnl0320vo);
				psnl0100Vo.setDpobCd(psnl0320vo.getDpobCd());
				psnl0100Vo.setSystemkey(psnl0320vo.getSystemkey());
				psnl0100Vo.setPyspCd((String) resultMap.get("pyspCd"));
				psnl0100Vo.setLogSvcYrNumCd((String) resultMap.get("logSvcYrNumCd"));      //근속년수
				psnl0100Vo.setLogSvcMnthIcmCd((String) resultMap.get("logSvcMnthIcmCd"));  //근속월수
				psnl0100Vo.setLogSvcDys((BigDecimal) resultMap.get("logSvcDys"));              //근속일수
				psnl0100Vo.setTotLogSvcDys((BigDecimal) resultMap.get("totLogSvcDys"));        //총근속일수
				psnl0100Vo.setOrgLogSvcYrCd((String) resultMap.get("orgLogSvcYrCd"));    
				psnl0100Vo.setOrgLogSvcMnthCd((String) resultMap.get("orgLogSvcMnthCd"));
				psnl0100Vo.setOrgLogSvcDys((BigDecimal) resultMap.get("orgLogSvcDys"));
				psnl0100Vo.setOrgTotLogSvcDys((BigDecimal) resultMap.get("orgTotLogSvcDys"));
				psnl0100Vo.setLogStdDt((String) resultMap.get("logStdBgnDt")); //근속기준일자
				psnl0100Vo.setReMrkDt((String) resultMap.get("reMrkDt"));   //재획정일자
				psnl0100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : inptAddr */ 
				psnl0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
				
				
				psnl0100DAO.updatePsnl0320ToPsnl0100(psnl0100Vo);
				
				Psnl0112VO psnl0112VO = new Psnl0112VO();
				
				psnl0112VO.setDpobCd(psnl0320vo.getDpobCd());
				psnl0112VO.setSystemkey(psnl0320vo.getSystemkey());
				psnl0112VO.setMityCarrLogSvcYrNumCd((String) resultMap.get("mityCarrLogSvcYrNumCd"));
				psnl0112VO.setMityCarrLogSvcMnthNumCd((String) resultMap.get("mityCarrLogSvcMnthNumCd"));
				psnl0112VO.setMityCarrLogSvcDys((BigDecimal) resultMap.get("mityCarrRcgtnLogSvcDys"));
				                                                            
				
				
				psnl0112VO.setMityCarrTotLogSvcDys(new BigDecimal(psnl0320dto.getMityCarrTotLogSvcDys()));
				psnl0112VO.setIsmt(sessionUser.getUsrId());    /** column 수정자 : inptAddr */ 
				psnl0112VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
				
				psnl0112DAO.updatePsnl0320ToPsnl0112(psnl0112VO);

				resultDto.setLogStdBgnDt((String) resultMap.get("logStdBgnDt"));
				resultDto.setReMrkDt((String) resultMap.get("reMrkDt"));
				resultDto.setPyspCd((String) resultMap.get("pyspNm"));
				resultDto.setLogSvcYrNumCd((String) resultMap.get("logSvcYrNumNm"));
				resultDto.setLogSvcMnthIcmCd((String) resultMap.get("logSvcMnthIcmNm"));
	            
				
				
		}catch (Exception ex)
		{
		    logger.error("EXCEPTION calling updatePsnl0100(): "+ex); 

		    resultDto = null;
			throw MSFServerUtils.getOperationException("updatePsnl0100", ex, logger);
		}finally
		{
			  
		}

		return resultDto;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}