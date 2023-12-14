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
package com.app.exterms.yearendtax.server.service.yeta2020;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.yearendtax.client.dto.yeta2020.Ye161090DTO;
import com.app.exterms.yearendtax.client.service.yeta2020.YetaP530011Service;
import com.app.exterms.yearendtax.server.service.yeta2020.dao.Ye161090_2020_DAO;
import com.app.exterms.yearendtax.server.vo.Ye161090Srh_2020_VO;
import com.app.exterms.yearendtax.server.vo.Ye161090_2020_VO;
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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2020.InfcPkgYe161010_2020_VO;
import com.app.smrmf.pkg.listener.yeta.yeta2020.Yeta5300ListenerAdapter;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("YetaP530011Service")
public class YetaP530011ServiceImpl  extends AbstractCustomServiceImpl implements YetaP530011Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(YetaP530011ServiceImpl.class);
	private static final String calledClass = YetaP530011ServiceImpl.class.getName();
	  
	@Autowired
	@Resource(name = "Ye161090_2020_DAO")
	private Ye161090_2020_DAO ye161090DAO; 
	  
	  
	/** 세액감면및세액공제1 - 교육비(grid) 금액 수정 **/
	@Override
	public Long saveYeta5300ToYe161090tabItem08_3(List<Ye161090DTO> listYe161090Dto, ActionDatabase actionDatabase) throws Exception {
		
		String method = calledClass + ".saveYeta5300ToYe161090tabItem08_3";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "Yeta530011";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

		Long result = new Long(1);
		Long iCnt = new Long(0);

		BigDecimal seqn = new BigDecimal(0);
		Ye161090DTO ye161090Dto = new Ye161090DTO();
		Ye161090_2020_VO ye161090Vo = new Ye161090_2020_VO();
		
		InfcPkgYe161010_2020_VO infcPkgYe161010Vo = new InfcPkgYe161010_2020_VO(); 
		Yeta5300ListenerAdapter  Yeta5300ListenerAdt = new Yeta5300ListenerAdapter();

		try {

			for (int iYetaCnt = 0; iYetaCnt < listYe161090Dto.size(); iYetaCnt++) {

				// 1. 암호화 객체 생성
        		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        		
        		
        		ye161090Dto = new Ye161090DTO(); 
        		ye161090Dto = listYe161090Dto.get(iYetaCnt);  
        		
        		ye161090Vo = new Ye161090_2020_VO();
        		
        		ye161090Vo.setDpobCd(ye161090Dto.getDpobCd());    																					/** column 사업장코드 : dpobCd */
        		ye161090Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161090Dto.getYrtxBlggYr()));    												/** column 귀속연도 : yrtxBlggYr */
        		ye161090Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161090Dto.getClutSeptCd()));    												/** column 연말정산구분코드 : clutSeptCd */
        		ye161090Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161090Dto.getSystemkey()));    													/** column SYSTEMKEY : systemkey */
        		
        		ye161090Vo.setCdVvalKrnCd(MSFSharedUtils.allowNulls(ye161090Dto.getCdVvalKrnCd()));    												/** column 소득공제명세자료구분코드 : cdVvalKrnCd */
        		
        		ye161090Vo.setFamResnoEncCntn(AnyCryptUtils.getEncSyncCrypt(nResult
        				, MSFSharedUtils.allowNulls(ye161090Dto.getFamResnoEncCntn()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));				/** column 가족주민등록번호 : famResnoEncCntn */
        	
        		
	        	ye161090Vo.setScxpsUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161090Dto.getScxpsUseAmt(), "0")));    						/** column 교육비지출금액 : scxpsUseAmt */
	        	ye161090Vo.setScxpsStdDdcTrgtIndvAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye161090Dto.getScxpsStdDdcTrgtIndvAmt(), "0")));	/** column 개별공제대상금액 : scxpsStdDdcTrgtIndvAmt */   
	        
	        	ye161090Vo.setScxpsStd(MSFSharedUtils.allowNulls(ye161090Dto.getScxpsStdTmp()));    												/** column 교육비공제대상구분코드 : scxpsStd */
	        	ye161090Vo.setScxpsStdClDivCd(MSFSharedUtils.allowNulls(ye161090Dto.getScxpsStdClDivCdTmp())); 										/** column 교육비구분코드 : scxpsStdClDivCd */
	        	
        		ye161090Vo.setIsmt(sessionUser.getUsrId());    																						/** column 수정자 : ismt */
        		ye161090Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    												/** column 수정주소 : revnAddr */
        		
            	
            	
            	switch (actionDatabase) {
				case INSERT:
					
					ye161090Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
					ye161090Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    	/** column 입력주소 : inptAddr */
					
					ye161090DAO.insertYeta5300ToYe161090(ye161090Vo);
					
					break;
				case UPDATE:
					
					// 기존 데이터 삭제 처리 후 인서트 처리.
					ye161090DAO.deleteYeta5300ToYe161090(ye161090Vo);
					
					ye161090Vo.setScxpsStd(MSFSharedUtils.allowNulls(ye161090Dto.getScxpsStd()));    				/** column 교육비공제대상구분코드 : scxpsStd */
	        		ye161090Vo.setScxpsStdClDivCd(MSFSharedUtils.allowNulls(ye161090Dto.getScxpsStdClDivCd()));   	/** column 교육비구분코드 : scxpsStdClDivCd */
					
	     
					ye161090Vo.setKybdr(sessionUser.getUsrId());    												/** column 입력자 : kybdr */
					ye161090Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
					
					ye161090DAO.insertYeta5300ToYe161090(ye161090Vo);

					break;
				case DELETE:
					
					ye161090DAO.deleteYeta5300ToYe161090(ye161090Vo);
					
					break;
				}
				iCnt = iCnt + 1;
				
				BeanUtils.copyProperties(infcPkgYe161010Vo , ye161090Vo);  
				Yeta5300ListenerAdt.fnYeta5300_Ye161010_2020_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE161090");
				
			}

			result = iCnt;

		} catch (Exception e) {
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
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
	
	
	
	
	/** 교육비내역 조회 **/
	public PagingLoadResult<BaseModel> getYeta5300ToYe161090List(ServiceParameters serviceParameters) throws MSFException {
			

		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETA5300_TO_YE161090_DATA_LIST;
		Ye161090Srh_2020_VO ye161090SrhVo = new Ye161090Srh_2020_VO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(ye161090DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				ye161090DAO = (Ye161090_2020_DAO) wac.getBean("Ye161090_2020_DAO"); 
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
		    	
//		    	List<String> listDeptCd = new ArrayList<String>();    
		      	/** 조건절 */
		    	ye161090SrhVo.setDpobCd(sessionUser.getDpobCd());    /** column 사업장코드 : dpobCd */
		    	ye161090SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));		/** column 귀속연도 : yrtxBlggYr */
		    	ye161090SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd"))); 	/** column 연말정산구분코드 : clutSeptCd */
		    	ye161090SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));		/** column SYSTEMKEY : systemkey */
		    	ye161090SrhVo.setCdVvalKrnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "cdVvalKrnCd")));	/** column 소득공제명세자료구분코드 : cdVvalKrnCd */
//		    	ye161090SrhVo.setFamResnoEncCntn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "famResnoEncCntn")));    /** column 가족주민등록번호 : famResnoEncCntn */
		    	
//		    	Yeta4220SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
//		    	Yeta4220SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
////		     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
//		     	
//		    	Yeta4220SrhVo.setUsrId(sessionUser.getUsrId());
//	            /******************************** 권한 ************************************************************************/
//	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//	            if ("FALSE".equals(chkDeptCd)) {
//	            	Yeta4220SrhVo.setDeptCd(sessionUser.getDeptCd()); 
//	               listDeptCd.add(sessionUser.getDeptCd());
//	               Yeta4220SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
//	               Yeta4220SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//	            } else {
//	            	Yeta4220SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
//	                     if (Yeta4220SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
//	                     	 listDeptCd = null; 
//	                     	Yeta4220SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	                     	Yeta4220SrhVo.setDeptCd("");  //부서코드
//	                     } else {
//	                    	 Yeta4220SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
//	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	                          Yeta4220SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
//	                     } 
//	            }
//	            
////	            } else {
////	            	
////	            }
//	            
//	            Yeta4220SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
//	            Yeta4220SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
//	            
//	           /******************************** 권한 ************************************************************************/
//		     	
//		     	
//	            Yeta4220SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
//		            
////		       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
////		     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
////		      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//		            
//		       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
//		       	Yeta4220SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
//		       	Yeta4220SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//		           
////		     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
////		     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
////		     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//		             
//		      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
//		      	Yeta4220SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//		      	Yeta4220SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
//		             
//		      	Yeta4220SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
//		           
//		           
//		      	Yeta4220SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //년도
//		      	Yeta4220SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
//		      	Yeta4220SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
		            
		      	// Get total record count //전체 데이터 갯수를 가지고 온다. 
				if ( pagingValues.executeRecordCount ) { 
			            	
					//Execute query that returns a single value
		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
		                 
		          	int iResultCnt = ye161090DAO.selectYeta5300ToYe161090ListTotCnt(ye161090SrhVo);  
		              
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
		     	ye161090SrhVo.setPageSize(pagingValues.totalRecordCount);  
		            
		     	//Apply paging
		     	if (pagingValues.start > 0) {
		     		ye161090SrhVo.setFirstIndex(pagingValues.start);
		     	}
		     	if (pagingValues.offsetLimit > 0) {
		     		ye161090SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
		     	}

		     	//Execute query and convert to BaseModel list
		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = ye161090DAO.selectYeta5300ToYe161090List(ye161090SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
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
		          	   			
		          			if(	"famResnoEncCntn".equals(tableAttributes[i].getName())) {
		          		          			
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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
		} catch (Exception ex) {
			ex.printStackTrace();
			// Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
}

 