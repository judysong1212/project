/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.app.exterms.yearendtax.server.service.yeta2023;
 
 
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

import com.app.exterms.yearendtax.client.dto.yeta2023.Ye161010DTO;
import com.app.exterms.yearendtax.client.service.yeta2023.Yeta8200Service;
import com.app.exterms.yearendtax.server.service.yeta2023.dao.Ye160401_2023_DAO;
import com.app.exterms.yearendtax.server.service.yeta2023.dao.Ye160402_2023_DAO;
import com.app.exterms.yearendtax.server.service.yeta2023.dao.Ye160403_2023_DAO;
import com.app.exterms.yearendtax.server.service.yeta2023.dao.Ye160404_2023_DAO;
import com.app.exterms.yearendtax.server.service.yeta2023.dao.Ye160406_2023_DAO;
import com.app.exterms.yearendtax.server.service.yeta2023.dao.Ye161010_2023_DAO;
import com.app.exterms.yearendtax.server.service.yeta2023.dao.Ye161020_2023_DAO;
import com.app.exterms.yearendtax.server.service.yeta2023.dao.Yeta1100_2023_DAO;
import com.app.exterms.yearendtax.server.vo.Ye160404_2023_VO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2023_VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFOperationException;
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
 * 
* <pre>
* 1. 패키지명 : com.app.exterms.yearendtax.server.service
* 2. 타입명 : Yeta0100ServiceImpl.java
* 3. 작성일 : Jan 13, 2016 5:12:49 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Service("Yeta8200Service")
public class Yeta8200ServiceImpl  extends AbstractCustomServiceImpl implements Yeta8200Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(Yeta8200ServiceImpl.class);
	private static final String calledClass = Yeta8200ServiceImpl.class.getName();

	@Autowired
	@Resource(name = "Yeta1100_2023_DAO")
	private Yeta1100_2023_DAO yeta1100DAO;
	
	// 연말정산대상자기본
	@Autowired
	@Resource(name = "Ye161010_2023_DAO")
	private Ye161010_2023_DAO ye161010DAO;
	
	// 인적소득공제기본
	@Autowired
	@Resource(name = "Ye161020_2023_DAO")
	private Ye161020_2023_DAO ye161020DAO;
	
	// 현근무지급여지급명세
	@Autowired
	@Resource(name = "Ye160401_2023_DAO")
	private Ye160401_2023_DAO ye160401DAO;
	
	// 감면소득_과세
	@Autowired
	@Resource(name = "Ye160402_2023_DAO")
	private Ye160402_2023_DAO ye160402DAO;
	
	// 감면소득_비과세
	@Autowired
	@Resource(name = "Ye160403_2023_DAO")
	private Ye160403_2023_DAO ye160403DAO;
	
	// 종전근무지
	@Autowired
	@Resource(name = "Ye160404_2023_DAO")
	private Ye160404_2023_DAO ye160404DAO;
	
	 // 종전근무지연금보험료_공적연금
	@Autowired
	@Resource(name = "Ye160406_2023_DAO")
	private Ye160406_2023_DAO ye160406DAO;
	
	    
	/**
	 * 연말정산대상자내역조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYeta8200ToYe161010DataList(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA8200_DATA_LIST;
		Ye161010Srh_2023_VO   ye161010SrhVO = new Ye161010Srh_2023_VO();
//		Psnl0100VO      psnl0100VO = new Psnl0100VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(ye161010DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			ye161010DAO = (Ye161010_2023_DAO) wac.getBean("Ye161010_2023_DAO"); 
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
	    	 ye161010SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	 ye161010SrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));			// 정산년도
	    	 ye161010SrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));		// 정산구분 
	      	 ye161010SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 

	     	
	    	 ye161010SrhVO.setUsrId(sessionUser.getUsrId());
            /******************************** 권한 ************************************************************************/
	    	 System.out.println("체크전  " + sessionUser.getAuthCheck() +"2"+  sessionUser.getAuthCheck().getAuthCheck03() );
	    	 String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	
            	if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
               	 
            		ye161010SrhVO.setDeptCd(sessionUser.getDeptCd()); 
                    listDeptCd.add(sessionUser.getDeptCd());
                    ye161010SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
                    
                    System.out.println("체크후 성공 o 1 " + ye161010SrhVO.getDeptCd() +"2  :"+  listDeptCd +"3  :"+MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
           	 } else {
           		 ye161010SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                 listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                 ye161010SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                 System.out.println("체크후 성공 x 1 " + ye161010SrhVO.getDeptCd() +"2  :"+  listDeptCd +"3"+MSFServerUtils.getFilterValue(columnFilters, "deptCd") );
                 
           	 }  
            	
               ye161010SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	System.out.println("체크후 성공 o 2 " + ye161010SrhVO.getPayrMangDeptCd() +"2  :"+  MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")) );
            	ye161010SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
                     if (ye161010SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	ye161010SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	ye161010SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	 ye161010SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          ye161010SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                          System.out.println("체크체크 +" + ye161010SrhVO.getDeptCdArr());
                     } 
                  
            }
            
//            } else {
//            	
//            }
            System.out.println("권한체크체크 +" + ye161010SrhVO.getDeptCdAuth());
            System.out.println("권한체크체크 +" + ye161010SrhVO.getDtilOccuInttnCdAuth());
            ye161010SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            ye161010SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
	     	
	     	
	    	List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
	    	ye161010SrhVO.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
	    	ye161010SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));			//재직코드
	     	
	     	
	    	ye161010SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));      		//고용구분코드
	            
//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	       	psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//	      	psnl0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));			//부서코드
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	       	ye161010SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	       	ye161010SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  	//직종
	           
//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	     	psnl0100SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	     	psnl0100SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	      	ye161010SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	      	ye161010SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 	//직종세
	             
	      	ye161010SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   				//사업코드
	           
	      	ye161010SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  				//시스템키
	      	ye161010SrhVO.setFnm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "fnm")));    						//한글성명 
	      	ye161010SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"mangeDeptCd")));    //관리부서
	      	
	      	ye161010SrhVO.setUtDpobCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobCd")));	//단위사업장
	      	ye161010SrhVO.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));		//User Id
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = ye161010DAO.selectYe161010ListTotCnt(ye161010SrhVO);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginYeta8100ToYe161010DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	ye161010SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		ye161010SrhVO.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		ye161010SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}
//
	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = ye161010DAO.selectYe161010List(ye161010SrhVO);
	            
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
	          							
	          			}else if("resnoEncCntn".equals(tableAttributes[i].getName())) {
	          				String rrnDecCrypt = "";
  		          			
	          				// TODO 주민번호 
	          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	          		          		
	          				strValue = rrnDecCrypt;
	          				System.out.println("주민등록번호 :" + strValue.toString());
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
	            
			SmrmfUtils.endTiming(logger, millisBeginYeta8100ToYe161010DataList, "getYeta4100ToYe161010DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}		
	
	/**
	 * 연말정산대상자내역조회
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	//조회
	public PagingLoadResult<BaseModel> getYeta8200ToYe161010ResultDataList(ServiceParameters serviceParameters) throws MSFException {
		
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA8200_DATA_LIST;
		Ye161010Srh_2023_VO   ye161010SrhVO = new Ye161010Srh_2023_VO();
//		Psnl0100VO      psnl0100VO = new Psnl0100VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		if  (MSFSharedUtils.paramNull(ye161010DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			ye161010DAO = (Ye161010_2023_DAO) wac.getBean("Ye161010_2023_DAO"); 
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
			ye161010SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			ye161010SrhVO.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));			// 정산년도
			ye161010SrhVO.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));		// 정산구분 
			ye161010SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  				//시스템키
			ye161010SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"mangeDeptCd")));    //관리부서 추
//			ye161010SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
			
			
			ye161010SrhVO.setUsrId(sessionUser.getUsrId());
			//Get total record count //전체 데이터 갯수를 가지고 온다. 
			 System.out.println("체크전  " + sessionUser.getAuthCheck() +"2"+  sessionUser.getAuthCheck().getAuthCheck03() );
	    	 String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	
            	if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
               	 
            		ye161010SrhVO.setDeptCd(sessionUser.getDeptCd()); 
                    listDeptCd.add(sessionUser.getDeptCd());
                    ye161010SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
                    
                    System.out.println("체크후 성공 o 1 " + ye161010SrhVO.getDeptCd() +"2  :"+  listDeptCd +"3  :"+MSFServerUtils.getFilterValue(columnFilters, "deptCd"));
           	 } else {
           		 ye161010SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                 listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                 ye161010SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                 System.out.println("체크후 성공 x 1 " + ye161010SrhVO.getDeptCd() +"2  :"+  listDeptCd +"3"+MSFServerUtils.getFilterValue(columnFilters, "deptCd") );
                 
           	 }  
            	
               ye161010SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	System.out.println("체크후 성공 o 2 " + ye161010SrhVO.getPayrMangDeptCd() +"2  :"+  MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")) );
            	ye161010SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
                     if (ye161010SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	ye161010SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	ye161010SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	 ye161010SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          ye161010SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                          System.out.println("체크체크 +" + ye161010SrhVO.getDeptCdArr());
                     } 
                  
            }
		
		
		
            
//            } else {
//            	
//            }
            System.out.println("권한체크체크 +" + ye161010SrhVO.getDeptCdAuth());
            System.out.println("권한체크체크 +" + ye161010SrhVO.getDtilOccuInttnCdAuth());
            ye161010SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            ye161010SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
	     	
	     	
	    	List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
	    	ye161010SrhVO.setHdofcCodtnCdArr(listHdofcCodtnCd);     //부서코드 
	    	ye161010SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));			//재직코드
	     	
	     	
	    	ye161010SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));      		//고용구분코드
	            
//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	       	psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//	      	psnl0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));			//부서코드
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	       	ye161010SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	       	ye161010SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  	//직종
	           
//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	     	psnl0100SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	     	psnl0100SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	      	ye161010SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	      	ye161010SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 	//직종세
	             
	      	ye161010SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   				//사업코드
	           
	      	ye161010SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  				//시스템키
	      	ye161010SrhVO.setFnm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "fnm")));    						//한글성명 
	      	ye161010SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"mangeDeptCd")));    //관리부서
	      	
	      	ye161010SrhVO.setUtDpobCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "utDpobCd")));	//단위사업장
	      	ye161010SrhVO.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));		//User Id
			if ( pagingValues.executeRecordCount ) { 
				
				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				
				int iResultCnt = ye161010DAO.selectYe161010ResultListTotCnt(ye161010SrhVO);  
				
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
				
				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if (!pagingValues.pageExecute) { 
					pagingValues.offsetLimit = iResultCnt;       
				}
				
				pagingValues.totalRecordCount = iResultCnt;	       
				
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
			
			TimingInfo millisBeginYeta2100ToYe161010DataList = SmrmfUtils.startTiming(logger);
			
			/**페이지 카운트 처리를 위한 부분 */ 
			ye161010SrhVO.setPageSize(pagingValues.totalRecordCount);  
			
			//Apply paging
			if (pagingValues.start > 0) {
				ye161010SrhVO.setFirstIndex(pagingValues.start);
			}
			if (pagingValues.offsetLimit > 0) {
				ye161010SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
//
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			
			@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
			List list = ye161010DAO.selectYe161010ResultList(ye161010SrhVO);
			
			Iterator<Map<String, Object>> iter = list.iterator();
			
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
			
			
			while (iter.hasNext()) {
				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = ye161010SrhVO.getSystemkey();
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
							
						}else if("resnoEncCntn".equals(tableAttributes[i].getName())) {
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
			
			SmrmfUtils.endTiming(logger, millisBeginYeta2100ToYe161010DataList, "getYeta41100ToYe161010DataList");
			
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}

	@Override
	public String yetaChangeConvert(Ye161010DTO ye161010Dto) throws Exception {
		// TODO Auto-generated method stub
		
		
		String rtnVal =  "";
		String rrnDecCrypt = "";
		 
    try {
 
	 	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	 
      
	 	if  (MSFSharedUtils.paramNull(ye160404DAO)) {
	        
        	WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

        	ye160404DAO = (Ye160404_2023_DAO) wac.getBean("Ye160404_2023_DAO" ); 
        	 
        }
	    
	    List  list = ye160404DAO.selectYetaAllList();
	     
        Iterator<Map<String, Object>> iter = list.iterator();
     
        while ( iter.hasNext() ) {
        	
        	Map<String, Object> map = (Map<String, Object>) iter.next();
        	
        	Ye160404_2023_VO  ye160404Vo = new Ye160404_2023_VO();
           
           
        	ye160404Vo.setSystemkey(MSFSharedUtils.allowNulls(map.get("resid")));

          
        	ye160404Vo.setOldresid(MSFSharedUtils.allowNulls(map.get("resid")).replaceAll("-",""));
           
        	ye160404Vo.setResid(MSFSharedUtils.allowNulls(map.get("resid")).replaceAll("-",""));
            
            String pwdCryptSHA512 = "";
            
            pwdCryptSHA512 = AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(ye160404Vo.getResid()).replaceAll("-",""), AnyCryptUtils.SEC_RRNUMC);
        // pwdCryptSHA512 =   xnCrypt.sync_EncRrnumc(MSFSharedUtils.allowNulls(bass0600Vo.getResnRegnNum()).replaceAll("-",""));   
            ye160404Vo.setResid(pwdCryptSHA512);    
      
           // if (!MSFSharedUtils.allowNulls(bass0600Vo.getSecResnNum()).equals(MSFSharedUtils.allowNulls(map.get("secResnNum")))) { 
            ye160404DAO.updateYetaAll(ye160404Vo);
          //  }
           
        }
          
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new MSFOperationException();  
		}	 
		return null;
	}		

}
