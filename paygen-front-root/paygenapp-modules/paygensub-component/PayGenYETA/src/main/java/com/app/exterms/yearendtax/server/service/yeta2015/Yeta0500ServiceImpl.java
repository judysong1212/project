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
package com.app.exterms.yearendtax.server.service.yeta2015;

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

import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta2000DTO;
import com.app.exterms.yearendtax.client.service.yeta2015.Yeta0500Service;
import com.app.exterms.yearendtax.server.service.yeta2015.dao.Yeta1000DAO;
import com.app.exterms.yearendtax.server.service.yeta2015.dao.Yeta2000DAO;
import com.app.exterms.yearendtax.server.vo.Yeta2000SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta2000VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
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
* 2. 타입명 : Yeta0500ServiceImpl.java
* 3. 작성일 : Jan 13, 2016 5:13:53 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Service("Yeta0500Service")
public class Yeta0500ServiceImpl  extends AbstractCustomServiceImpl implements Yeta0500Service  ,YetaDaoConstants {

	// private  static final Logger LOGGER = LoggerFactory.getLogger(Yeta0100ServiceImpl.class);
	// private static final String calledClass = Yeta0100ServiceImpl.class.getName();
	  private static final Logger logger = LoggerFactory.getLogger(Yeta0500ServiceImpl.class);
	  private static final String calledClass = Yeta0500ServiceImpl.class.getName();
	  
	@Autowired
	@Resource(name = "Yeta1000DAO")
	private Yeta1000DAO yeta1000DAO;
	
	
	@Autowired
	@Resource(name = "Yeta2000DAO")
	private Yeta2000DAO yeta2000DAO;
	  

	//연말정산신고내역 조회
	public PagingLoadResult<BaseModel> getYeta05000List(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA0500LIST;
		Yeta2000SrhVO yeta2000SrhVo = new Yeta2000SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(yeta2000DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			yeta2000DAO = (Yeta2000DAO) wac.getBean("Yeta2000DAO" ); 
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
	    	yeta2000SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	yeta2000SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd")));//정산구분
	    	yeta2000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
	     	
	    	yeta2000SrhVo.setUsrId(sessionUser.getUsrId());
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	yeta2000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
               yeta2000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	yeta2000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
                     if (yeta2000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                     	yeta2000SrhVo.setDeptCd("");  //부서코드
                     } else {
                    	 yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
            }
            
//            } else {
//            	
//            }
            
            yeta2000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            yeta2000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
	     	
	     	
            yeta2000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            
//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	       	yeta2000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	       	yeta2000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	      	yeta2000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	      	yeta2000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	             
	      	List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd"))); 
	      	yeta2000SrhVo.setBusinCdArr(lstBusinCd);  
	      	yeta2000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd"))); //사업코드
	      	
//	      	yeta2000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	           
	           
	      	yeta2000SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //년도
	      	yeta2000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	      	yeta2000SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	            
	      	yeta2000SrhVo.setiTem14(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "iTem14")));	//금액
	      	
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = yeta2000DAO.selectYeta0500GirdListTotCnt(yeta2000SrhVo);  
	              
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
	     	yeta2000SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		yeta2000SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		yeta2000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = yeta2000DAO.selectYeta0500GirdList(yeta2000SrhVo);
	            
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
	            	

	            	//3. 복호화
	            	case ColumnDef.TYPE_STRING: 
	            	          			          			
	            		String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));

	            		String rrnDecCrypt = "";
	               			
	            		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
	            	          			
	            	          			
	            			// 주민번호(복호화)
	            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	            	          		
	            			strValue = rrnDecCrypt;
	            						
	            		}else if("payFamyResnRegnNum".equals(tableAttributes[i].getName())) {

	            			// 주민번호(복호화)
	            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	            	          		
	            			strValue = rrnDecCrypt;

	                    }else if("degtrResnRegnNum".equals(tableAttributes[i].getName())) {

	            			// 주민번호(복호화)
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0400List");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	
	
	//당월급여반영
	public Long activityOnYeta0500List(List<Yeta2000DTO> listYeta2000dto) throws MSFException {
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		BigDecimal seqn = new BigDecimal(0);
		MSFSysm0100BM sessionUser;
		

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		

		String method = calledClass + ".activityOnYeta0500List";
		
		String windowNm = "연말정산급여반영";
		String windowId = "YETA0500";
		        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
				
		try {  
			if (MSFSharedUtils.paramNull(yeta2000DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

				yeta2000DAO = (Yeta2000DAO) wac.getBean("yeta2000DAO" ); 
			}
			            
			for(int iPsnlCnt=0;iPsnlCnt < listYeta2000dto.size();iPsnlCnt++) {
			                
				Yeta2000DTO yeta2000Dto = new Yeta2000DTO();  
				yeta2000Dto = listYeta2000dto.get(iPsnlCnt);
			                 
				Yeta2000VO yeta2000Vo = new Yeta2000VO();  
			            
				yeta2000Vo.setDpobCd(MSFSharedUtils.allowNulls(yeta2000Dto.getDpobCd()));    				/** column 사업장코드 : dpobCd */
				yeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta2000Dto.getEdacRvyy()));    			/** column 연말정산귀속년도 : edacRvyy */
				yeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta2000Dto.getSettGbcd()));    			/** column 정산구분코드 : settGbcd */
				yeta2000Vo.setSystemkey(MSFSharedUtils.allowNulls(yeta2000Dto.getSystemkey()));    			/** column SYSTEMKEY : systemkey */
			            
				yeta2000Vo.setYrtxApptnYrMnth(yeta2000Dto.getYrtxApptnYrMnth());							/** column 연말정산적용년월 : yrtxApptnYrMnth */
				yeta2000Vo.setYrtxPrcsDt(yeta2000Dto.getYrtxPrcsDt());										/** column 연말정산처리일자 : yrtxPrcsDt */
			 	yeta2000Vo.setYrtxPrcsYn((Boolean.TRUE.equals(yeta2000Dto.getYrtxPrcsYn()) ? "Y" : "N"));	/** column 연말정산처리여부 : yrtxPrcsYn */
				yeta2000Vo.setDivdPymtDivCd(yeta2000Dto.getDivdPymtDivCd());								/** column 분할납부구분코드 : divdPymtDivCd */
				yeta2000Vo.setDivdPymt(yeta2000Dto.getDivdPymt());    										/** column 분할납부횟수 : divdPymt */
			            
				yeta2000Vo.setIsmt(sessionUser.getUsrId());													/** column 수정자 : ismt */
				yeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 			/** column 수정주소 : revnAddr */	
			            		
				yeta2000DAO.activityOnYeta0500List(yeta2000Vo); 
			            		
				iCnt = iCnt + 1; 
			                    
			} 
			
			result = iCnt;
				
		} catch (Exception ex) {
			logger.error("EXCEPTION calling activityOnYeta0500List(): "+ex); 
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",ex, windowNm , windowId);
			            
			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnYeta0500List", ex, logger);
		}
		finally {
			          
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		return result;
	}
	
	
	//연말정산대상자 및 내역 수정
	public Long saveYeta0500Grid(List<Yeta2000DTO> listYeta2000dto) throws MSFException {
		// TODO Auto-generated method stub
		
		String method = calledClass + ".saveYeta0500Grid";
		
		String windowNm = "연말정산급여반영";
		String windowId = "YETA0500";
		
		Long result = new Long(0);
		Long iCnt = new Long(0);
		MSFSysm0100BM sessionUser;
		

		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
				
		try {  
			if (MSFSharedUtils.paramNull(yeta2000DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

				yeta2000DAO = (Yeta2000DAO) wac.getBean("yeta2000DAO" ); 
			}
			            
			for(int iPsnlCnt=0;iPsnlCnt < listYeta2000dto.size();iPsnlCnt++) {
			                
				Yeta2000DTO yeta2000Dto = new Yeta2000DTO();  
				yeta2000Dto = listYeta2000dto.get(iPsnlCnt);
			                 
				Yeta2000VO yeta2000Vo = new Yeta2000VO();  
			            
				yeta2000Vo.setDpobCd(MSFSharedUtils.allowNulls(yeta2000Dto.getDpobCd()));    			/** column 사업장코드 : dpobCd */
				yeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta2000Dto.getEdacRvyy()));    		/** column 연말정산귀속년도 : edacRvyy */
				yeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta2000Dto.getSettGbcd()));    		/** column 정산구분코드 : settGbcd */
				yeta2000Vo.setSystemkey(MSFSharedUtils.allowNulls(yeta2000Dto.getSystemkey()));    		/** column SYSTEMKEY : systemkey */
			            
				yeta2000Vo.setYrtxPrcsYn(Boolean.TRUE.equals(yeta2000Dto.getYrtxPrcsYn()) ? "Y" : "N");	/** column 연말정산처리여부 : yrtxPrcsYn */
				yeta2000Vo.setDivdPymtDivCd(yeta2000Dto.getDivdPymtDivCd());							/** column 분할납부구분코드 : divdPymtDivCd */
				yeta2000Vo.setDivdPymt(yeta2000Dto.getDivdPymt());    									/** column 분할납부횟수 : divdPymt */
			            
				yeta2000Vo.setIsmt(sessionUser.getUsrId());												/** column 수정자 : ismt */
				yeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 		/** column 수정주소 : revnAddr */	
			            		
				
				//연말정산 처리 여부가 Y일 경우 분할납부구분코드 수정 O, 분할납부횟수 X
				if("Y".equals(yeta2000Vo.getYrtxPrcsYn())) {
					yeta2000DAO.saveYeta0500Yeta2000_Y(yeta2000Vo); 
				//연말정산 처리 여부가 N일 경우 분할납부구분코드 수정 O, 분할납부횟수 O
				}else if("N".equals(yeta2000Vo.getYrtxPrcsYn())) {
					
					yeta2000DAO.saveYeta0500Yeta2000_N(yeta2000Vo); 
				}
			            		
				iCnt = iCnt + 1;
			                    
			} 
			
			result = iCnt;
				
		} catch (Exception ex) {
			logger.error("EXCEPTION calling saveYeta0500Yeta2000(): "+ex); 
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",ex, windowNm , windowId);
			            
			result = new Long(0);
			throw MSFServerUtils.getOperationException("saveYeta0500Yeta2000", ex, logger);
		}
		finally {
			          
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		return result;
	}
	  
}
