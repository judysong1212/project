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
package com.app.exterms.yearendtax.server.service.yeta2016;

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

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3170DTO;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP13001Service;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3170DAO;
import com.app.exterms.yearendtax.server.vo.Yeta3170SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3170VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
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
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("YetaP13001Service")
public class YetaP13001ServiceImpl  extends AbstractCustomServiceImpl implements YetaP13001Service, YetaDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(YetaP13001ServiceImpl.class);
	private static final String calledClass = YetaP13001ServiceImpl.class.getName();
	  
	  
	@Autowired
	@Resource(name = "Ye16Ta3170DAO")
	private Ye16Ta3170DAO yeta3170DAO;
	  
	  
	//이월기부금 신규 수정 삭제부
	@Override
	public Long activityOnYetaP13001ToYeta3170(List<Ye16Ta3170DTO> listYeta3170dto, ActionDatabase actionDatabase) throws MSFException {
			// TODO Auto-generated method stub
			Long result = new Long(0);
			Long iCnt = new Long(0);
			
			BigDecimal Seqn = new BigDecimal(0);
			
			String windowNm = "소득공제신고자료관리";
			String windowId = "YETAP130001";
			
			MSFSysm0100BM sessionUser;
			String method = calledClass + ".activityOnYetaP13001ToYeta3170";
			
	        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
			
			try {  
				if (MSFSharedUtils.paramNull(yeta3170DAO)) {
					WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

					yeta3170DAO = (Ye16Ta3170DAO) wac.getBean("Ye16Ta3170DAO" ); 
				}
		            
				for(int iPsnlCnt=0;iPsnlCnt < listYeta3170dto.size();iPsnlCnt++) {

					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			        
					Ye16Ta3170DTO yeta3170Dto = new Ye16Ta3170DTO();  
					yeta3170Dto = listYeta3170dto.get(iPsnlCnt);
		                 
		            Yeta3170VO yeta3170Vo = new Yeta3170VO();  

		            yeta3170Vo.setDpobCd(MSFSharedUtils.allowNulls(yeta3170Dto.getDpobCd()));			/** column 사업장코드 : dpobCd */
		            yeta3170Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta3170Dto.getEdacRvyy()));   	/** column 연말정산귀속년도 : edacRvyy */
		            yeta3170Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta3170Dto.getSettGbcd()));   	/** column 정산구분코드 : settGbcd */
		            yeta3170Vo.setSystemkey(MSFSharedUtils.allowNulls(yeta3170Dto.getSystemkey())); 	/** column SYSTEMKEY : systemkey */
		            yeta3170Vo.setCtrbSeqn(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3170Dto.getCtrbSeqn(), "0")));   	/** column 기부조정명세일련번호 : ctrbSeqn */
		            yeta3170Vo.setCtrbDdcd(MSFSharedUtils.allowNulls(yeta3170Dto.getCtrbDdcd()));   	/** column 기부조정명세유형구분코드 : ctrbDdcd */
		            yeta3170Vo.setCtrbTycd(MSFSharedUtils.allowNulls(yeta3170Dto.getCtrbTycd()));   	/** column 기부조정명세유형코드 : ctrbTycd */
		            yeta3170Vo.setCtrbYrmn(MSFSharedUtils.allowNulls(yeta3170Dto.getCtrbYrmn()));  	 	/** column 기부조정명세기부연도 : ctrbYrmn */
		            yeta3170Vo.setCtrbAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3170Dto.getCtrbAmnt(), "0")));  	 	/** column 기부조정명세기부금액 : ctrbAmnt */
		            yeta3170Vo.setBfyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3170Dto.getBfyrDeam(), "0")));   	/** column 전년도_공제금액 : bfyrDeam */
		            yeta3170Vo.setDetrAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3170Dto.getDetrAmnt(), "0")));   	/** column 공제대상금액 : detrAmnt */
		            yeta3170Vo.setDyyrDeam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3170Dto.getDyyrDeam(), "0")));   	/** column 해당연도공제금액 : dyyrDeam */
		            yeta3170Vo.setDyyrOtam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3170Dto.getDyyrOtam(), "0")));   	/** column 해당년도_미공제소멸금액 : dyyrOtam */
		            yeta3170Vo.setAyyrNtam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3170Dto.getAyyrNtam(), "0")));   	/** column 해당년도_미공제이월금액 : ayyrNtam */
		            
		            if((ActionDatabase.INSERT).equals(actionDatabase) || (ActionDatabase.UPDATE).equals(actionDatabase)) {
		            	//신규인지 수정인지 일련번호로 구분
//		            	if(yeta3170Vo.getCtrbSeqn() == Seqn) {
		            	if("0".equals((String) MSFSharedUtils.defaultNulls(yeta3170Dto.getCtrbSeqn(), "0"))) {
		            		
		            		yeta3170Vo.setKybdr(sessionUser.getUsrId()); 	/** column 입력자 : kybdr */ 
		            		yeta3170Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());/** column 입력주소 : inptAddr */ 
				    		
		            		yeta3170Vo.setIsmt(sessionUser.getUsrId());		/** column 수정자 : ismt */
		            		yeta3170Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());/** column 수정주소 : revnAddr */
		            	
		            		yeta3170DAO.insertYetaP03001To3170(yeta3170Vo); 
		            		
		            		
		            	}else {
		            		
		            		yeta3170Vo.setIsmt(sessionUser.getUsrId());		/** column 수정자 : ismt */
		            		yeta3170Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());/** column 수정주소 : revnAddr */
		            		
		            		yeta3170DAO.updateYetaP03001To3170(yeta3170Vo); 
		            	}
		            	
		            }else if((ActionDatabase.DELETE).equals(actionDatabase)) {
		            	
		            		yeta3170DAO.deleteYetaP03001To3170(yeta3170Vo); 
		            		
		            }
		                      
//		        	switch (actionDatabase) {
//		        		case INSERT:
//		        			yeta3170DAO.insertYetaP03001To3170(yeta3170Vo); 
//		        			break;
//		            	case UPDATE: 
//		            		yeta3170DAO.updateYetaP03001To3170(yeta3170Vo); 
//		            		break;
//		            	case DELETE: 
//		            		yeta3170DAO.deleteYetaP03001To3170(yeta3170Vo); 
//		            		break;
//		        	} 
		        		
		            iCnt = iCnt + 1;   
				} 
				result = iCnt;
		          
		        } catch (Exception ex) {
		            logger.error("EXCEPTION calling activityOnYetaP03001ToYeta3170(): "+ex); 
		            
		            /** 에러 로그 **/			
		            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C:D",ex, windowNm , windowId);
		            
		            result = new Long(0);
		            throw MSFServerUtils.getOperationException("activityOnYetaP03001ToYeta3170", ex, logger);
		        } finally {
		          
		        }
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C:D");
			
			return result;
		}
	
	
	
	//이월기부금 조회
	public PagingLoadResult<BaseModel> getYetaP13001To3170List(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETAP13001TOYETA3170_DATA_LIST;
		Yeta3170SrhVO   yeta3170SrhVo = new Yeta3170SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(yeta3170DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			yeta3170DAO = (Ye16Ta3170DAO) wac.getBean("Ye16Ta3170DAO"); 
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
	    	
//	    	List<String> listDeptCd = new ArrayList<String>();    
	      	/** 조건절 */
	    	yeta3170SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	    	yeta3170SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy")));		//연말정산귀속년도
	    	yeta3170SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd"))); 	//정산구분코드
	    	yeta3170SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));	//systemkey
	    	
	    	
//	    	yeta3220SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
//	    	yeta3220SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
////	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
//	     	
//	    	yeta3220SrhVo.setUsrId(sessionUser.getUsrId());
//            /******************************** 권한 ************************************************************************/
//            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//            if ("FALSE".equals(chkDeptCd)) {
//            	yeta3220SrhVo.setDeptCd(sessionUser.getDeptCd()); 
//               listDeptCd.add(sessionUser.getDeptCd());
//               yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
//               yeta3220SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//            } else {
//            	yeta3220SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
//                     if (yeta3220SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
//                     	 listDeptCd = null; 
//                     	yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//                     	yeta3220SrhVo.setDeptCd("");  //부서코드
//                     } else {
//                    	 yeta3220SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
//                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//                          yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
//                     } 
//            }
//            
////            } else {
////            	
////            }
//            
//            yeta3220SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
//            yeta3220SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
//            
//           /******************************** 권한 ************************************************************************/
//	     	
//	     	
//            yeta3220SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
//	            
////	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
////	     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
////	      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//	            
//	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
//	       	yeta3220SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
//	       	yeta3220SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//	           
////	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
////	     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
////	     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//	             
//	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
//	      	yeta3220SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//	      	yeta3220SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
//	             
//	      	yeta3220SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
//	           
//	           
//	      	yeta3220SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //년도
//	      	yeta3220SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
//	      	yeta3220SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = yeta3170DAO.selectYetaP03001To3170ListTotCnt(yeta3170SrhVo);  
	          	

	              
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
	     	yeta3170SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		yeta3170SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		yeta3170SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = yeta3170DAO.selectYetaP03001To3170List(yeta3170SrhVo);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {

				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			        
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

	          	        }else if("rsnoNumb".equals(tableAttributes[i].getName())) {

	          				// 주민번호(복호화)
	          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	          		          		
	          				strValue = rrnDecCrypt;

	          	        }
	          				
	          		map.put(tableAttributes[i].getName(), strValue);
	          			                    
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
}
