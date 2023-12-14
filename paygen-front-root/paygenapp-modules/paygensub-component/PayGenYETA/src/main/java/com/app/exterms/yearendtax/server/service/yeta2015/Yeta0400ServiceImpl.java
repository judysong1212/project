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

import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta1000BM;
import com.app.exterms.yearendtax.client.service.yeta2015.Yeta0400Service;
import com.app.exterms.yearendtax.server.service.yeta2015.dao.Yeta1000DAO;
import com.app.exterms.yearendtax.server.service.yeta2015.dao.Yeta2000DAO;
import com.app.exterms.yearendtax.server.vo.Yeta1000SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta1000VO;
import com.app.exterms.yearendtax.server.vo.Yeta2000SrhVO;
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
* 2. 타입명 : Yeta0400ServiceImpl.java
* 3. 작성일 : Jan 13, 2016 5:13:53 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Service("Yeta0400Service")
public class Yeta0400ServiceImpl  extends AbstractCustomServiceImpl implements Yeta0400Service  ,YetaDaoConstants {

	// private  static final Logger LOGGER = LoggerFactory.getLogger(Yeta0100ServiceImpl.class);
	// private static final String calledClass = Yeta0100ServiceImpl.class.getName();
	  private static final Logger logger = LoggerFactory.getLogger(Yeta0400ServiceImpl.class);
	  private static final String calledClass = Yeta0400ServiceImpl.class.getName();
	  
	@Autowired
	@Resource(name = "Yeta1000DAO")
	private Yeta1000DAO yeta1000DAO;
	
	
	@Autowired
	@Resource(name = "Yeta2000DAO")
	private Yeta2000DAO yeta2000DAO;
	  
	//연말정산신고파일생성 조회
	public Yeta1000BM getYeta0400List(Yeta1000BM yeta1000Bm) throws MSFException {
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

		Yeta1000SrhVO yeta1000SrhVo = new Yeta1000SrhVO();
		MSFSysm0100BM sessionUser;
		String method = calledClass + ".getYeta0400List";
		
		String windowNm = "연말정산신고파일생성";
		String windowId = "YETA0400";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(yeta1000DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
					.getSession().getServletContext());
			yeta1000DAO = (Yeta1000DAO) wac.getBean("Yeta1000DAO");
		}
				

		/** 조건절 */
//			yeta1000SrhVo.setDpobCd(sessionUser.getDeptCd());/** column 사업장코드 : dpobCd */
		yeta1000SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta1000Bm.getEdacRvyy()));/** column 연말정산귀속년도 : edacRvyy */
		yeta1000SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(yeta1000Bm.getSettGbcd()));/** column 정산구분코드 : settGbcd */
			
	   	 List<String> listDeptCd = new ArrayList<String>(); 
	   	 yeta1000SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	   	 yeta1000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	  	
		 yeta1000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(yeta1000Bm.getDeptCd()));  //권한처리를위해 추가  
	   	 yeta1000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yeta1000Bm.getDtilOccuInttnCd()).replace(",", ""));   
	     
	   	 yeta1000SrhVo.setUsrId(sessionUser.getUsrId());
	   	 /******************************** 권한 ************************************************************************/
	   	 String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	   	 	
	   	 if ("FALSE".equals(chkDeptCd)) {
	   		 
		   	 yeta1000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
		   	 listDeptCd.add(sessionUser.getDeptCd());
		     yeta1000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
		     yeta1000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
		        
	   	 } else {
	     	    
	   	 	yeta1000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(yeta1000Bm.getPayrMangDeptCd())) ;   //단위기관코드   
	   	 		
	   	 	if (yeta1000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yeta1000Bm.getDeptCd()))) { 
	   	 		listDeptCd = null; 
	   	 		yeta1000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	            yeta1000SrhVo.setDeptCd("");  //부서코드
	   	 	} else {
	   	 		yeta1000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(yeta1000Bm.getDeptCd()));
	            listDeptCd = SmrmfUtils.getStrToArrayList(yeta1000Bm.getDeptCd());  
	            yeta1000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	        } 
	   	 }
	     
	     
	   
	   	 /******************************** 권한 ************************************************************************/
	  	
	  	
	   	 yeta1000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(yeta1000Bm.getEmymtDivCd()));      		//고용구분코드
	         
//	    	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	    	psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//	   	psnl0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));			//부서코드
	         
		List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta1000Bm.getTypOccuCd())); 
	    yeta1000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	    yeta1000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(yeta1000Bm.getTypOccuCd()));  	//직종
	        
//	  	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	  	psnl0100SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	  	psnl0100SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	          
	   	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta1000Bm.getDtilOccuInttnCd())); 
	   	yeta1000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	   	yeta1000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(yeta1000Bm.getDtilOccuInttnCd())); //직종세
	        
		List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta1000Bm.getBusinCd())); 
	   	yeta1000SrhVo.setBusinCdArr(lstBusinCd);   
	   	yeta1000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(yeta1000Bm.getBusinCd()));   //사업코드
	        
//	   	yeta1000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	   	
	   	yeta1000SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));		//User Id
			

		int iResultCnt = yeta1000DAO.selectYeta0400ListTotCnt(yeta1000SrhVo);
				
		Yeta1000BM returnYeta1000Bm = new Yeta1000BM();
		List egovResultDataList = new ArrayList();

		try {
					
			egovResultDataList = yeta1000DAO.selectYeta0400List(yeta1000SrhVo);

			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
							
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					

					// 2.복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					while( keys.hasNext() ){
						String key = keys.next();
						//형 타입이 숫자형일경우 형변환 해준다.
						if(tempMap.get(key) instanceof java.math.BigDecimal){
							returnYeta1000Bm.set(key, String.valueOf(tempMap.get(key)));
						}else{
							
		            		if("resnRegnNum".equals(key)) {
		            			// 복호화
		            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get(key))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		            			returnYeta1000Bm.set(key, rrnDecCrypt);
		            			
		            		}else {
		            			
		            			returnYeta1000Bm.set(key, tempMap.get(key));
		            		}
				    	}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S", ex, windowNm , windowId);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return returnYeta1000Bm;
	}
	
	
	//연말정산신고내역 조회
	public PagingLoadResult<BaseModel> getYeta04000List(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA0400LIST;
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
	     	

            yeta2000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            yeta2000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
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
	      	        
	      	
	      	
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = yeta2000DAO.selectYeta0400GirdListTotCnt(yeta2000SrhVo);  
	              
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
	     	List list = yeta2000DAO.selectYeta0400GirdList(yeta2000SrhVo);
	            
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
	
	//전자신고기본정보 수정
	public Long updateYeta1000(Yeta1000BM yeta1000Bm) throws MSFException {
		
		Long result = new Long(0);

			Yeta1000VO yeta1000Vo = new Yeta1000VO();
			MSFSysm0100BM sessionUser;
			String method = calledClass + ".updateYeta1000";
			
			String windowNm = "연말정산신고파일생성";
			String windowId = "YETA0400";

			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}

			if (MSFSharedUtils.paramNull(yeta1000DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
						.getSession().getServletContext());
				yeta1000DAO = (Yeta1000DAO) wac.getBean("Yeta1000DAO");
			}
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			
//			yeta1000Vo.setDpobCd(sessionUser.getDpobCd());    /** column null : dpobCd */
//			yeta1000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta1000Dto.getEdacRvyy()));    /** column 연말정산귀속년도 : edacRvyy */
//			yeta1000Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta1000Dto.getSettGbcd()));    /** column 정산구분코드 : settGbcd */
//			yeta1000Vo.setEdacSeilNum(new BigDecimal(yeta1000Dto.getEdacSeilNum()));    /** column 연말정산마감일련번호 : edacSeilNum */
//			yeta1000Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(yeta1000Dto.getPayrMangDeptCd()));    /** column 급여관리부서코드 : payrMangDeptCd */
			
			yeta1000Vo.setDpobCd(sessionUser.getDpobCd());    /** column null : dpobCd */
			yeta1000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta1000Bm.getEdacRvyy()));    /** column 연말정산귀속년도 : edacRvyy */
			yeta1000Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta1000Bm.getSettGbcd()));    /** column 정산구분코드 : settGbcd */
			yeta1000Vo.setEdacSeilNum(new BigDecimal(yeta1000Bm.getEdacSeilNum()));    /** column 연말정산마감일련번호 : edacSeilNum */
			yeta1000Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(yeta1000Bm.getPayrMangDeptCd()));    /** column 급여관리부서코드 : payrMangDeptCd */
			
//			yeta1000Vo.setDeptCd(MSFSharedUtils.allowNulls(objectBm.get("deptCd")));    /** column 부서코드 : deptCd */
//			yeta1000Vo.setTypOccuCd(MSFSharedUtils.allowNulls(objectBm.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
//			yeta1000Vo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(objectBm.get("dtilOccuClsDivCd")));    /** column 직종세구분코드 : dtilOccuClsDivCd */
//			yeta1000Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(objectBm.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
//			yeta1000Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(objectBm.get("dtilOccuInttnCd")));    /** column 직종세통합코드 : dtilOccuInttnCd */
//			yeta1000Vo.setBusinCd(MSFSharedUtils.allowNulls(objectBm.get("businCd")));    /** column 사업코드 : businCd */
//			yeta1000Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(objectBm.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
//			yeta1000Vo.setPernChrgEmpIdenNum(MSFSharedUtils.allowNulls(objectBm.get("pernChrgEmpIdenNum")));    /** column 생성직원번호 : pernChrgEmpIdenNum */
//			yeta1000Vo.setClosFlag(MSFSharedUtils.allowNulls(objectBm.get("closFlag")));    /** column 마감여부 : closFlag */
//			yeta1000Vo.setClosCont(MSFSharedUtils.allowNulls(objectBm.get("closCont")));    /** column 마감건수 : closCont */
//			yeta1000Vo.setClosDate(MSFSharedUtils.allowNulls(objectBm.get("closDate")));    /** column 마감일자 : closDate */
			
			
//			yeta1000Vo.setEdacPrdt(MSFSharedUtils.allowNulls(yeta1000Dto.getEdacPrdt()));    /** column 연말정산제출일자 : edacPrdt */
//			yeta1000Vo.setReprName(MSFSharedUtils.allowNulls(yeta1000Dto.getReprName()));    /** column 대표자성명 : reprName */
//			yeta1000Vo.setJuriName(MSFSharedUtils.allowNulls(yeta1000Dto.getJuriName()));    /** column 법인명_상호 : juriName */
//			yeta1000Vo.setBusiNumb(MSFSharedUtils.allowNulls(yeta1000Dto.getBusiNumb()));    /** column 사업자등록번호 : busiNumb */
//			yeta1000Vo.setResuNumb(MSFSharedUtils.allowNulls(yeta1000Dto.getResuNumb()));    /** column 주민등록번호 : resuNumb */
//			yeta1000Vo.setJuriNumb(MSFSharedUtils.allowNulls(yeta1000Dto.getJuriNumb()));    /** column 법인번호 : juriNumb */
//			yeta1000Vo.setIncmPost(MSFSharedUtils.allowNulls(yeta1000Dto.getIncmPost()));    /** column 소득신고의무자우편번호 : incmPost */
//			yeta1000Vo.setIncmAddr(MSFSharedUtils.allowNulls(yeta1000Dto.getIncmAddr()));    /** column 소득신고의무자기본주소 : incmAddr */
//			yeta1000Vo.setIncmAdtl(MSFSharedUtils.allowNulls(yeta1000Dto.getIncmAdtl()));    /** column 소득신고의무자상세주소 : incmAdtl */
//			yeta1000Vo.setTaxaCode(MSFSharedUtils.allowNulls(yeta1000Dto.getTaxaCode()));    /** column 관할세무서코드 : taxaCode */
//			yeta1000Vo.setIncmGbcd(MSFSharedUtils.allowNulls(yeta1000Dto.getIncmGbcd()));    /** column 제출자구분코드 : incmGbcd */
//			yeta1000Vo.setTaxaDnum(MSFSharedUtils.allowNulls(yeta1000Dto.getTaxaDnum()));    /** column 세무대리인번호 : taxaDnum */
//			yeta1000Vo.setHomeTxid(MSFSharedUtils.allowNulls(yeta1000Dto.getHomeTxid()));    /** column 홈텍스ID : homeTxid */
//			yeta1000Vo.setTaxaPrcd(MSFSharedUtils.allowNulls(yeta1000Dto.getTaxaPrcd()));    /** column 세무프로그램코드 : taxaPrcd */
//			yeta1000Vo.setCharDept(MSFSharedUtils.allowNulls(yeta1000Dto.getCharDept()));    /** column 담당자부서명 : charDept */
//			yeta1000Vo.setCharName(MSFSharedUtils.allowNulls(yeta1000Dto.getCharName()));    /** column 담당자성명 : charName */
//			yeta1000Vo.setCharTele(MSFSharedUtils.allowNulls(yeta1000Dto.getCharTele()));    /** column 담당자전화번호 : charTele */
//			yeta1000Vo.setFilePass(MSFSharedUtils.allowNulls(yeta1000Dto.getFilePass()));    /** column FILE_PASS : filePass */
			
			
			
			yeta1000Vo.setEdacPrdt(MSFSharedUtils.allowNulls(yeta1000Bm.getEdacPrdt()));    /** column 연말정산제출일자 : edacPrdt */
			yeta1000Vo.setReprName(MSFSharedUtils.allowNulls(yeta1000Bm.getReprName()));    /** column 대표자성명 : reprName */
			yeta1000Vo.setJuriName(MSFSharedUtils.allowNulls(yeta1000Bm.getJuriName()));    /** column 법인명_상호 : juriName */
			yeta1000Vo.setBusiNumb(MSFSharedUtils.allowNulls(yeta1000Bm.getBusiNumb()));    /** column 사업자등록번호 : busiNumb */
//			yeta1000Vo.setResuNumb(MSFSharedUtils.allowNulls(yeta1000Bm.getResuNumb()));    /** column 주민등록번호 : resuNumb */
			
			//암호화
			yeta1000Vo.setResuNumb(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta1000Bm.getResuNumb()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
			
			yeta1000Vo.setJuriNumb(MSFSharedUtils.allowNulls(yeta1000Bm.getJuriNumb()));    /** column 법인번호 : juriNumb */
			yeta1000Vo.setIncmPost(MSFSharedUtils.allowNulls(yeta1000Bm.getIncmPost()));    /** column 소득신고의무자우편번호 : incmPost */
			yeta1000Vo.setIncmAddr(MSFSharedUtils.allowNulls(yeta1000Bm.getIncmAddr()));    /** column 소득신고의무자기본주소 : incmAddr */
			yeta1000Vo.setIncmAdtl(MSFSharedUtils.allowNulls(yeta1000Bm.getIncmAdtl()));    /** column 소득신고의무자상세주소 : incmAdtl */
			yeta1000Vo.setTaxaCode(MSFSharedUtils.allowNulls(yeta1000Bm.getTaxaCode()));    /** column 관할세무서코드 : taxaCode */
			yeta1000Vo.setIncmGbcd(MSFSharedUtils.allowNulls(yeta1000Bm.getIncmGbcd()));    /** column 제출자구분코드 : incmGbcd */
			yeta1000Vo.setTaxaDnum(MSFSharedUtils.allowNulls(yeta1000Bm.getTaxaDnum()));    /** column 세무대리인번호 : taxaDnum */
			yeta1000Vo.setHomeTxid(MSFSharedUtils.allowNulls(yeta1000Bm.getHomeTxid()));    /** column 홈텍스ID : homeTxid */
			yeta1000Vo.setTaxaPrcd(MSFSharedUtils.allowNulls(yeta1000Bm.getTaxaPrcd()));    /** column 세무프로그램코드 : taxaPrcd */
			yeta1000Vo.setCharDept(MSFSharedUtils.allowNulls(yeta1000Bm.getCharDept()));    /** column 담당자부서명 : charDept */
			yeta1000Vo.setCharName(MSFSharedUtils.allowNulls(yeta1000Bm.getCharName()));    /** column 담당자성명 : charName */
			yeta1000Vo.setCharTele(MSFSharedUtils.allowNulls(yeta1000Bm.getCharTele()));    /** column 담당자전화번호 : charTele */
			yeta1000Vo.setFilePass(MSFSharedUtils.allowNulls(yeta1000Bm.getFilePass()));    /** column FILE_
			
			yeta1000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
			yeta1000Vo.setRevnDt(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정일자 : revnDt */
//			yeta1000Vo.setRevnAddr(MSFSharedUtils.allowNulls(objectBm.get("revnAddr")));    /** column 수정주소 : revnAddr */
			
		  	try{
			
		  		yeta1000DAO.saveYeta0400List(yeta1000Vo);
		  		result = new Long(1);

			} catch (Exception ex) {
				ex.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",ex, windowNm , windowId);
				
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
	
	
	
	//연말정산신고파일 마감/풀기
	public Long finishOnYeta1000(Yeta1000BM yeta1000Bm) throws MSFException {
		
		Long result = new Long(0);
		String method = calledClass + ".finishOnYeta1000";
		
		String windowNm = "연말정산신고파일생성";
		String windowId = "YETA0400";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

			Yeta1000VO yeta1000Vo = new Yeta1000VO();
			MSFSysm0100BM sessionUser;

			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}

			if (MSFSharedUtils.paramNull(yeta1000DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
						.getSession().getServletContext());
				yeta1000DAO = (Yeta1000DAO) wac.getBean("Yeta1000DAO");
			}
					

//			yeta1000Vo.setDpobCd(yeta1000Dto.getDpobCd());
//			yeta1000Vo.setEdacRvyy(yeta1000Dto.getEdacRvyy());
//			yeta1000Vo.setSettGbcd(yeta1000Dto.getSettGbcd());
//			yeta1000Vo.setEdacSeilNum(new BigDecimal(yeta1000Dto.getEdacSeilNum()));
//			
//			yeta1000Vo.setClosFlag(yeta1000Dto.getClosFlag());
//			yeta1000Vo.setClosDate(yeta1000Dto.getEdacPrdt());
			
			
			yeta1000Vo.setDpobCd(yeta1000Bm.getDpobCd());
			yeta1000Vo.setEdacRvyy(yeta1000Bm.getEdacRvyy());
			yeta1000Vo.setSettGbcd(yeta1000Bm.getSettGbcd());
			yeta1000Vo.setEdacSeilNum(new BigDecimal(yeta1000Bm.getEdacSeilNum()));
			
			yeta1000Vo.setClosFlag(yeta1000Bm.getClosFlag());
			yeta1000Vo.setClosDate(yeta1000Bm.getEdacPrdt());
			
			yeta1000Vo.setIsmt(sessionUser.getUsrId());
			yeta1000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
		  	try{
			
		  		yeta1000DAO.finishYeta0400List(yeta1000Vo);
		  		result = new Long(1);

			} catch (Exception ex) {
				ex.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
			}
		  	
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");

			return result;
		}

	  
}
