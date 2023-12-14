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

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3140DTO;
import com.app.exterms.yearendtax.client.service.yeta2016.YetaP13002Service;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3140DAO;
import com.app.exterms.yearendtax.server.vo.Yeta3140SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3140VO;
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

@Service("YetaP13002Service")
public class YetaP13002ServiceImpl  extends AbstractCustomServiceImpl implements YetaP13002Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(YetaP13002ServiceImpl.class);
	private static final String calledClass = YetaP13002ServiceImpl.class.getName();
	  
	@Autowired
	@Resource(name = "Ye16Ta3140DAO")
	private Ye16Ta3140DAO yeta3140DAO; 
	  
	  
	//의료비내역 신규 수정 삭제부
	@Override
	public Long activityOnYetaP13002ToYeta3140(List<Ye16Ta3140DTO> listYeta3140dto, ActionDatabase actionDatabase) throws MSFException {
				// TODO Auto-generated method stub
				Long result = new Long(0);
				Long iCnt = new Long(0);
				
				String windowNm = "소득공제신고자료관리";
				String windowId = "YETAP130002";
				
				MSFSysm0100BM sessionUser;
				String method = calledClass + ".activityOnYetaP13002ToYeta3140";
				
				BigDecimal seqn = new BigDecimal(0);
				
				if (RemoteServiceUtil.getThreadLocalRequest() != null) {
					sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
				} else {
					sessionUser = getUser();
				}
				
				try {  
					if (MSFSharedUtils.paramNull(yeta3140DAO)) {
						WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

						yeta3140DAO = (Ye16Ta3140DAO) wac.getBean("Ye16Ta3140DAO" ); 
					}
			            
					for(int iPsnlCnt=0;iPsnlCnt < listYeta3140dto.size();iPsnlCnt++) {
			                

						// 1. 암호화 객체 생성
						String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
						
						Ye16Ta3140DTO yeta3140Dto = new Ye16Ta3140DTO();  
						yeta3140Dto = listYeta3140dto.get(iPsnlCnt);
			                 
			            Yeta3140VO yeta3140Vo = new Yeta3140VO();  
			            
			            yeta3140Vo.setDpobCd(MSFSharedUtils.allowNulls(yeta3140Dto.getDpobCd()));    /** column 사업장코드 : dpobCd */
			            yeta3140Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta3140Dto.getEdacRvyy()));    /** column 연말정산귀속년도 : edacRvyy */
			            yeta3140Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta3140Dto.getSettGbcd()));    /** column 정산구분코드 : settGbcd */
			            yeta3140Vo.setSystemkey(MSFSharedUtils.allowNulls(yeta3140Dto.getSystemkey()));    /** column SYSTEMKEY : systemkey */
			            
			            yeta3140Vo.setMediSeqn(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3140Dto.getMediSeqn(), "0")));    /** column 의료비지급일련번호 : mediSeqn */
			         
//			            yeta3140Vo.setRsnoNumb(MSFSharedUtils.allowNulls(yeta3140Dto.getRsnoNumb()));    /** column 주민등록번호 : rsnoNumb */
			            // 암호화
			            yeta3140Vo.setRsnoNumb(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta3140Dto.getRsnoNumb()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC)); 
			            
			            
			            
			            
//			            yeta3140Vo.setPsclHpyn((Boolean.TRUE.equals(yeta3140Dto.getPsclHpyn()) ? "Y" : "N"));    /** column 본인등해당여부 : psclHpyn */
			            yeta3140Vo.setPsclHpyn(("true".equals(yeta3140Dto.getPsclHpyn()) ? "1" : "2"));    /** column 본인등해당여부 : psclHpyn */
			            yeta3140Vo.setVendNumb(MSFSharedUtils.allowNulls(yeta3140Dto.getVendNumb()));    /** column 거래처번호 : vendNumb */
			            yeta3140Vo.setVendName(MSFSharedUtils.allowNulls(yeta3140Dto.getVendName()));    /** column 거래처명 : vendName */
			            yeta3140Vo.setMediCfcd(MSFSharedUtils.allowNulls(yeta3140Dto.getMediCfcd()));    /** column 의료증빙코드 : mediCfcd */
			            yeta3140Vo.setCashUect(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3140Dto.getCashUect(), "0")));    /** column 지급건수 : cashUect */
			            yeta3140Vo.setCashUeam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3140Dto.getCashUeam(), "0")));    /** column 지급금액 : cashUeam */
			            yeta3140Vo.setCtifTrea(MSFSharedUtils.defaultNulls(yeta3140Dto.getCtifTrea(), "0"));    /** column 난임시술비해당여부 : ctifTrea */
			            
			            
			            if((ActionDatabase.INSERT).equals(actionDatabase) || (ActionDatabase.UPDATE).equals(actionDatabase)) {
			            	//신규인지 수정인지 일련번호로 구분
			            	
			            	if("0".equals((String) MSFSharedUtils.defaultNulls(yeta3140Dto.getMediSeqn(), "0"))) {	
			            		
			            		yeta3140Vo.setKybdr(sessionUser.getUsrId());/** column 입력자 : kybdr */ 
			            		yeta3140Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());/** column 입력주소 : inptAddr */ 
						    		
			            		yeta3140Vo.setIsmt(sessionUser.getUsrId());	/** column 수정자 : ismt */
			            		yeta3140Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); /** column 수정주소 : revnAddr */
			            		
			            		yeta3140DAO.insertYetaP03002To3140(yeta3140Vo);  
			            		
			            	}else {
			            		
			            		yeta3140Vo.setIsmt(sessionUser.getUsrId());/** column 수정자 : ismt */
			            		yeta3140Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); /** column 수정주소 : revnAddr */
			            		
			            		yeta3140DAO.updateYetaP03002To3140(yeta3140Vo); 
			            		
			            	}
			            }else if((ActionDatabase.DELETE).equals(actionDatabase)) {
			            	yeta3140DAO.deleteYetaP03002To3140(yeta3140Vo); 
			            }
			            
			            
//			        	switch (actionDatabase) {
//			        		case INSERT:
//			        			yeta3140DAO.insertYetaP03002To3140(yeta3140Vo); 
//			        			break;
//			            	case UPDATE: 
//			            		yeta3140DAO.updateYetaP03002To3140(yeta3140Vo); 
//			            		break;
//			            	case DELETE: 
//			            		yeta3140DAO.deleteYetaP03002To3140(yeta3140Vo); 
//			            		break;
//			        	} 
			        		iCnt = iCnt + 1; 
			                    
					} 
					result = iCnt;
			          
			        } catch (Exception ex) {
			            logger.error("EXCEPTION calling activityOnYetaP13002ToYeta3140(): "+ex); 
			            
			            /** 에러 로그 **/			
			            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),ex, windowNm , windowId);
			            
			            result = new Long(0);
			            throw MSFServerUtils.getOperationException("activityOnYetaP13002ToYeta3140", ex, logger);
			        }
			        finally {
			          
			        }
				
				/** 로그반영
				 * CRUDSBLO
				 * C:create		R:read		U:update
		    	 * D:delete		S:select	B:배치 
		    	 * L:로그인		O:로그아웃
		    	 */
				MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
				
				return result;
			}
	
	
	//의료비내역 조회
	public PagingLoadResult<BaseModel> getYetaP13002To3140List(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETAP13002TOYETA3140_DATA_LIST;
		Yeta3140SrhVO   yeta3140SrhVo = new Yeta3140SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
	
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(yeta3140DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			yeta3140DAO = (Ye16Ta3140DAO) wac.getBean("Ye16Ta3140DAO"); 
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
	    	yeta3140SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	    	yeta3140SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"))) ;   //systemkey
	    	yeta3140SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy")));   
	    	yeta3140SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd")));   
	    	
	    	
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
	                 
	          	int iResultCnt = yeta3140DAO.selectYetaP03002To3140ListTotCnt(yeta3140SrhVo);  
	              
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
	     	yeta3140SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		yeta3140SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		yeta3140SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = yeta3140DAO.selectYetaP03002To3140List(yeta3140SrhVo);
	            
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
 
	                     
//	          		case ColumnDef.TYPE_BOOLEAN:   
//	                     
//	          			if (mapCon != null) { 
//	          				
//	          				String ckValue = null;
//	          				
//	          				if("1".equals(mapCon.toString()) || "Y".equals(mapCon.toString())) {
//	          					ckValue = "Y";
//	          				}else {
//	          					ckValue = "N";
//	          				}
//	                        map.put(tableAttributes[i].getName(), ckValue); 
//	                    }s  
//	                       
//	                     break;     
	                     
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYetaP13001To3140List");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		
		return retval;
	}
	
}

 