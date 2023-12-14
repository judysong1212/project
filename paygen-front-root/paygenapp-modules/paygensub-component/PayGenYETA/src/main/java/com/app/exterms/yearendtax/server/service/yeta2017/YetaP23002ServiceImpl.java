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
package com.app.exterms.yearendtax.server.service.yeta2017;

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

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye164010DTO;
import com.app.exterms.yearendtax.client.service.yeta2017.YetaP23002Service;
import com.app.exterms.yearendtax.server.service.yeta2017.dao.Ye164010DAO;
import com.app.exterms.yearendtax.server.vo.Ye164010SrhVO;
import com.app.exterms.yearendtax.server.vo.Ye164010VO;
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
import com.app.smrmf.infc.yearendtax.server.vo.yeta2017.InfcPkgYe161010VO;
import com.app.smrmf.pkg.listener.yeta.yeta2017.Yeta2300ListenerAdapter;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("YetaP23002Service")
public class YetaP23002ServiceImpl  extends AbstractCustomServiceImpl implements YetaP23002Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(YetaP23002ServiceImpl.class);
	private static final String calledClass = YetaP23002ServiceImpl.class.getName();
	  
	@Autowired
	@Resource(name = "Ye164010DAO")
	private Ye164010DAO ye164010DAO; 
	  
	  
	/** 의료비내역 신규 수정 삭제부 **/
	@Override
	public Long activityOnYetaP23002ToYe164010(List<Ye164010DTO> listYe164010Dto, ActionDatabase actionDatabase) throws MSFException {
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETAP230002";

		MSFSysm0100BM sessionUser;
		String method = calledClass + ".activityOnYetaP23002ToYe164010";

		BigDecimal seqn = new BigDecimal(0);
		
		Ye164010DTO ye164010Dto = new Ye164010DTO();
		Ye164010VO ye164010Vo = new Ye164010VO();
		
		InfcPkgYe161010VO infcPkgYe161010Vo = new InfcPkgYe161010VO(); 
		Yeta2300ListenerAdapter  yeta2300ListenerAdt = new Yeta2300ListenerAdapter();
		
		
		
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		try { 
			
			if (MSFSharedUtils.paramNull(ye164010DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());

				ye164010DAO = (Ye164010DAO) wac.getBean("Ye164010DAO");
			}
			 
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
			for (int iPsnlCnt = 0; iPsnlCnt < listYe164010Dto.size(); iPsnlCnt++) {

				ye164010Dto = new Ye164010DTO();
				ye164010Dto = listYe164010Dto.get(iPsnlCnt);

				ye164010Vo = new Ye164010VO();
				
				ye164010Vo.setDpobCd(ye164010Dto.getDpobCd());    																	/** column 사업장코드 : dpobCd */
				ye164010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye164010Dto.getYrtxBlggYr()));    								/** column 귀속연도 : yrtxBlggYr */
				ye164010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye164010Dto.getClutSeptCd()));    								/** column 연말정산구분코드 : clutSeptCd */
				ye164010Vo.setSystemkey(MSFSharedUtils.allowNulls(ye164010Dto.getSystemkey()));    									/** column SYSTEMKEY : systemkey */
				ye164010Vo.setMdxpsSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls( ye164010Dto.getMdxpsSeilNum(), "0")));    	/** column 의료비지급일련번호 : mdxpsSeilNum */
				ye164010Vo.setMdxpsVvalKrnCd(MSFSharedUtils.allowNulls(ye164010Dto.getMdxpsVvalKrnCd()));    						/** column 의료비국세자료구분코드 : mdxpsVvalKrnCd */
				
				
				ye164010Vo.setResnoEncCntn(AnyCryptUtils.getEncSyncCrypt(nResult
						,MSFSharedUtils.allowNulls(ye164010Dto.getResnoEncCntn()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));	/** column 의료비공제대상자주민등록번호 : resnoEncCntn */ 
				
				
				ye164010Vo.setYn(MSFSharedUtils.allowNulls(ye164010Dto.getYn()));    												/** column 본인등해당여부 : yn */
				ye164010Vo.setBsnoEncCntn(MSFSharedUtils.allowNulls(ye164010Dto.getBsnoEncCntn()));    								/** column 지급처사업자등록번호 : bsnoEncCntn */
				ye164010Vo.setPlymNm(MSFSharedUtils.allowNulls(ye164010Dto.getPlymNm()));    										/** column 의료비_상호명 : plymNm */
				ye164010Vo.setMdxpsPrfClCd(MSFSharedUtils.allowNulls(ye164010Dto.getMdxpsPrfClCd()));    							/** column 의료비_의료증빙코드 : mdxpsPrfClCd */
				ye164010Vo.setScnt(MSFSharedUtils.allowNulls(ye164010Dto.getScnt()));    											/** column 의료비_건수 : scnt */
				ye164010Vo.setUseAmt(MSFSharedUtils.allowNulls(ye164010Dto.getUseAmt()));    										/** column 의료비_금액 : useAmt */
				ye164010Vo.setYn2(MSFSharedUtils.allowNulls(ye164010Dto.getYn2()));    												/** column 의료비_난임시술비해당여부 : yn2 */
			            
				ye164010Vo.setIsmt(sessionUser.getUsrId());																			/** column 수정자 : ismt */
				ye164010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 									/** column 수정주소 : revnAddr */      
			            
			            
				switch (actionDatabase) {
				case INSERT:

					ye164010Vo.setKybdr(sessionUser.getUsrId());										/** column 입력자 : kybdr */
					ye164010Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소 : inptAddr */

					ye164010DAO.insertYetaP23002ToYe164010(ye164010Vo);
					break;
					
				case UPDATE:
					ye164010DAO.updateYetaP23002ToYe164010(ye164010Vo);
					break;
					
				case DELETE:
					ye164010DAO.deleteYetaP23002ToYe164010(ye164010Vo);
					break;
				}
				iCnt = iCnt + 1;
				
				
				BeanUtils.copyProperties(infcPkgYe161010Vo , ye164010Vo);  
				yeta2300ListenerAdt.fnYeta2300_Ye161010_2017_CalcUpdate(RemoteServiceUtil.getThreadLocalRequest(), infcPkgYe161010Vo, "YE164010");

			}
			result = iCnt;

		} catch (Exception ex) {
			
			logger.error("EXCEPTION calling activityOnYetaP23002ToYe164010(): "+ ex);

			/** 에러 로그 **/
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method,calledClass, actionDatabase.toString(), ex, windowNm,windowId);

			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnYetaP23002ToYe164010", ex, logger);
			
		} finally {

		}
				
				/** 로그반영
				 * CRUDSBLO
				 * C:create		R:read		U:update
		    	 * D:delete		S:select	B:배치 
		    	 * L:로그인		O:로그아웃
		    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass,actionDatabase.toString());

		return result;
	}
	
	
	/** 의료비내역 조회 **/
	public PagingLoadResult<BaseModel> getYetaP23002ToYe164010DataList(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETAP23002_TO_YE164010_DATA_LIST;
		Ye164010SrhVO   ye164010SrhVo = new Ye164010SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
	
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(ye164010DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			ye164010DAO = (Ye164010DAO) wac.getBean("Ye164010DAO"); 
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
	    	
	    	ye164010SrhVo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
	    	ye164010SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr"))); /** column 귀속연도 : yrtxBlggYr */
	    	ye164010SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	/** column 연말정산구분코드 : clutSeptCd */
	    	ye164010SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));	/** column SYSTEMKEY : systemkey */
//	    	ye164010SrhVo.setResnoEncCntn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "resnoEncCntn")));    /** column 의료비공제대상자주민등록번호 : resnoEncCntn */
	    	
	    	
	    	
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
	                 
	          	int iResultCnt = ye164010DAO.selectYetaP23002ToYe164010ListTotCnt(ye164010SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginYe164010DataList = SmrmfUtils.startTiming(logger);
	     	
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	ye164010SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		ye164010SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		ye164010SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = ye164010DAO.selectYetaP23002ToYe164010List(ye164010SrhVo);
	            
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
	          	   			
	          			if(	"resnoEncCntn".equals(tableAttributes[i].getName())) {
	          		          			
	          		          			
	          				// 주민번호(복호화)
	          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	          		          		
	          				strValue = rrnDecCrypt;
	          							
	          			}else if("bsnoEncCntn".equals(tableAttributes[i].getName())) {

	          				// 지급처사업자등록번호(복호화)
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
	            
			SmrmfUtils.endTiming(logger, millisBeginYe164010DataList, "getYetaP23002ToYe164010DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		
		return retval;
	}
	
}

 