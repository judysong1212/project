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

import com.app.exterms.personal.client.service.Psnl0250Service;
import com.app.exterms.personal.server.service.dao.Psnl0100DAO;
import com.app.exterms.personal.server.vo.Psnl0100SrhVO;
import com.app.exterms.personal.server.vo.Psnl0100VO;
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
@Service("psnl0250Service")
public class Psnl0250ServiceImpl extends AbstractCustomServiceImpl implements Psnl0250Service, PsnlDaoConstants {
	
	 private static final Logger logger = LoggerFactory.getLogger(Psnl0250ServiceImpl.class);
	 private static final String calledClass = Psnl0250ServiceImpl.class.getName();
	  
	
	@Autowired
    @Resource(name="psnl0100DAO")
    private Psnl0100DAO psnl0100DAO;
	
	//조회
	public PagingLoadResult<BaseModel> getPsnl0100ToPsnl0250DataList(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_PSNL0100_DATA_LIST;
		Psnl0100SrhVO   psnl0100SrhVO = new Psnl0100SrhVO();
		Psnl0100VO      psnl0100VO = new Psnl0100VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(psnl0100DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			psnl0100DAO = (Psnl0100DAO) wac.getBean("psnl0100DAO"); 
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
//	      	String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
	    	 List<String> listDeptCd = new ArrayList<String>(); 
	      	/** 조건절 */
	     	psnl0100SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	     	psnl0100SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
	     	
	     	psnl0100SrhVO.setUsrId(sessionUser.getUsrId());
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	psnl0100SrhVO.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
               psnl0100SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
            	
                     if (psnl0100SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	psnl0100SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	 psnl0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
            
//            } else {
//            	
//            }
            
            psnl0100SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd"))) ;   //관리부서코드   
            psnl0100SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            psnl0100SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
	     	
	     	
	    	List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
	       	psnl0100SrhVO.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
	      	psnl0100SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));			//재직코드
	     	
	     	
	     	psnl0100SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));      		//고용구분코드
	     	psnl0100SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")));       //호봉제 구분    
//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	       	psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//	      	psnl0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));			//부서코드
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	      	psnl0100SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	     	psnl0100SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  	//직종
	           
//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	     	psnl0100SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	     	psnl0100SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	      	psnl0100SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	psnl0100SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	             
	    	psnl0100SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	           
	       	psnl0100SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	      	psnl0100SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	      	
	      	psnl0100SrhVO.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));		//User Id
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = psnl0100DAO.selectPsnl0100To0250ListTotCnt(psnl0100SrhVO);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0100ToPsnl0250DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	psnl0100SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		psnl0100SrhVO.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		psnl0100SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}
//
	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = psnl0100DAO.selectPsnl0100To0250List(psnl0100SrhVO);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {
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
	            	
	          		case ColumnDef.TYPE_STRING: 
		          			
	          			String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
	          	   			
	          			if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	          		          			
	          				String rrnDecCrypt = "";
	          		          			
	          				// TODO 주민번호 
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToPsnl0250DataList, "getPsnl0100ToPsnl0250DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}





//	@SuppressWarnings("rawtypes")
//	@Override
//	public BaseListLoadResult<Psnl0100DAO> selectPsnl0100(
//			BaseListLoadConfig config, Psnl0100DAO psnl0100DAO) throws MSFException {
//		// TODO Auto-generated method stub
//		List<Psnl0290DTO> returnValue = new ArrayList<Psnl0290DTO>();
//		List egovResultDataList = new ArrayList();
//		
//		try{
//			egovResultDataList = psnl0100DAO.selectPsnl0290(psnl0100DAO);
//			if(egovResultDataList != null && egovResultDataList.size() > 0){
//				for(int i = 0 ; i < egovResultDataList.size(); i++){
//					Psnl0290DTO dto = new Psnl0290DTO();
//					Map tempMap = (Map)egovResultDataList.get(i);
//					@SuppressWarnings("unchecked")
//					Iterator<String> keys = tempMap.keySet().iterator();
//					while( keys.hasNext() ){
//			            String key = keys.next();
//			            //형 타입이 숫자형일경우 형변환 해준다.
//		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
//		            		dto.set(key, String.valueOf(tempMap.get(key)));
//		            	}else{
//		            		dto.set(key, tempMap.get(key));
//		            	}
//		            }
//					returnValue.add(dto);
//				}
//			}
//			
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
//		}
//		return new BaseListLoadResult<Psnl0290DTO>(returnValue);	
//	}

	
/*
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
	*/
	
	
	
/*
	@Override
	public int deletePsnl0100(HashMap<String, String> hMap) throws Exception {
		// TODO Auto-generated method stub
		//삭제시 PSNL0125 사진 정보도 삭제
		psnl0125DAO.deletePsnl0125(hMap);
		return psnl0100DAO.deletePsnl0100(hMap);
	}

	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String insertPsnl0100(Psnl0100DTO psnl0100Dto) throws Exception {
		// TODO Auto-generated method stub
		
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		//필수 키값 세팅
		psnl0100Dto.setKybdr(sessionUser.getUsrId());
		psnl0100Dto.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		psnl0100Dto.setIsmt(sessionUser.getUsrId());
		psnl0100Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		
		String dpobCd = sessionUser.getUsrDivCd() == null ? " " : sessionUser.getUsrDivCd();
		String systemkey = psnl0100DAO.getNewSystemkey(dpobCd);
		psnl0100Dto.setDpobCd(dpobCd);
		psnl0100Dto.setSystemkey(systemkey);
		if(psnl0100Dto.getPicFlnm() != null){
			//사진 등록 처리 시작 ======================================================
			String UPLOAD_DIRECTORY = "C:\\eGovFrameDev-2.7.0\\workspace\\PayGenApp\\war\\ExTermsFile\\ExTermPhoto";
			//서버용
			//String UPLOAD_DIRECTORY = MSFConfiguration.EXTERM_PHOTO;
			
			String subDirectory = "PSNL0125\\" + dpobCd+"_"+ systemkey;
			
			HashMap map = new HashMap();
			map.put("dpobCd", dpobCd);
			map.put("systemkey", systemkey);
			map.put("picRfta", UPLOAD_DIRECTORY+subDirectory);
			map.put("picFlnm", psnl0100Dto.getPicFlnm());
			map.put("kybdr", sessionUser.getUsrId());
			map.put("inptAddr", psnl0100Dto.getInptAddr());
			map.put("ismt", sessionUser.getUsrId());
			map.put("revnAddr", psnl0100Dto.getRevnAddr());
			
			psnl0125DAO.insertPsnl0125(map);
			//사진 등록 처리 끝 ======================================================
		}
		
		psnl0100DAO.insertPsnl0100(psnl0100Dto);
		
		return dpobCd+"_"+ systemkey;
	}



	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int updatePsnl0100(Psnl0100DTO psnl0100Dto) throws Exception {
		// TODO Auto-generated method stub
		
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		psnl0100Dto.setIsmt(sessionUser.getUsrId());
		psnl0100Dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		if(psnl0100Dto.getPicFlnm() != null){
			//사진 등록 처리 시작 ======================================================
			String UPLOAD_DIRECTORY = "C:\\eGovFrameDev-2.7.0\\workspace\\PayGenApp\\war\\ExTermsFile\\ExTermPhoto";
			//서버용
			//String UPLOAD_DIRECTORY = MSFConfiguration.EXTERM_PHOTO;
			
			String subDirectory = "PSNL0125\\" + psnl0100Dto.getDpobCd()+"_"+ psnl0100Dto.getSystemkey();
			
			HashMap map = new HashMap();
			map.put("dpobCd", psnl0100Dto.getDpobCd());
			map.put("systemkey", psnl0100Dto.getSystemkey());
			map.put("picRfta", UPLOAD_DIRECTORY+subDirectory);
			map.put("picFlnm", psnl0100Dto.getPicFlnm());
			map.put("ismt", sessionUser.getUsrId());
			map.put("revnAddr", psnl0100Dto.getRevnAddr());
			
			psnl0125DAO.updatePsnl0125(map);
			//사진 등록 처리 끝 ======================================================
		}
		
		return psnl0100DAO.updatePsnl0100(psnl0100Dto);
	}



	@Override
	public List<HashMap<String, String>> getExcelData(String fileFullPath)
			throws Exception {
		// TODO Auto-generated method stub
		//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		//InputStream input = classLoader.getResourceAsStream(fileFullPath);
		
		List<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
		if(fileFullPath != null && !"".equals(fileFullPath)){
			File file = new File(fileFullPath);
			FileInputStream fis = null;
			XSSFWorkbook w = null;
			
			try{
				fis = new FileInputStream(file);
				w = new XSSFWorkbook(fis);
				// 첫번째 엑셀 시트를 가져옴.
				XSSFSheet sheet = w.getSheetAt(0);
				
				Iterator<Row> rowIterator = sheet.iterator();
				int rowCnt = 0;
				
				while(rowIterator.hasNext()){
					Row row = rowIterator.next();
					Iterator<Cell> cellIterator = row.cellIterator();
					rowCnt++;
					HashMap<String, String> map = new HashMap<String, String>();
					while(cellIterator.hasNext()){
						
						Cell cell = cellIterator.next();
						map.put("rnum", rowCnt+"");
						
						switch(cell.getColumnIndex()){
						case 0: //주민번호
							map.put("rrn", String.valueOf(cell.getStringCellValue()));
							break;
						case 1: //교육시작일자
							map.put("bgnnDt", new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue()));
							break;
						case 2: //교육종료일자
							map.put("endDt", new SimpleDateFormat("yyyy-MM-dd").format(cell.getDateCellValue()));
							break;
						case 3: //교옥이수시간
							map.put("cmpteTm", String.valueOf(cell.getNumericCellValue()));
							break;
						case 4: //교육종류명
							map.put("kndNm", cell.getStringCellValue());
							break;
						case 5: //교육기관명
							map.put("istutNm", cell.getStringCellValue());
							break;
						case 6: //비고내용
							map.put("noteCtnt", cell.getStringCellValue());
							break;
						}
						
						switch(cell.getCellType()){
						case Cell.CELL_TYPE_NUMERIC :
							map.put("A", String.valueOf(cell.getNumericCellValue()));
							break;
						case Cell.CELL_TYPE_STRING :
							map.put("B", cell.getStringCellValue());
							break;
						}
						
					}
					list.add(map);
					
				}
				fis.close();
				
			}catch (Exception e) {
				return new ArrayList<HashMap<String, String>>();
			}
			
		}
		return list;
	}



	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Psnl0100DTO> selectPsnl0290(
			BaseListLoadConfig config, HashMap<String, String> param)
			throws Exception {
		// TODO Auto-generated method stub
		List<Psnl0100DTO> returnValue = new ArrayList<Psnl0100DTO>();
		List egovResultDataList = new ArrayList();
		
		try{
			egovResultDataList = psnl0100DAO.selectPsnl0100(param);
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Psnl0100DTO dto = new Psnl0100DTO();
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
					returnValue.add(dto);
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
			
		
		
		return new BaseListLoadResult<Psnl0100DTO>(returnValue);
	}*/


}
