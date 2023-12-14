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
package com.app.exterms.yearendtax.server.service.yeta2021;

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

import com.app.exterms.yearendtax.client.dto.yeta2021.Ye165030DTO;
import com.app.exterms.yearendtax.client.service.yeta2021.YetaP63001Service;
import com.app.exterms.yearendtax.server.service.yeta2021.dao.Ye165030_2021_DAO;
import com.app.exterms.yearendtax.server.vo.Ye165030Srh_2021_VO;
import com.app.exterms.yearendtax.server.vo.Ye165030_2021_VO;
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

@Service("YetaP63001Service")
public class YetaP63001ServiceImpl  extends AbstractCustomServiceImpl implements YetaP63001Service, YetaDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(YetaP63001ServiceImpl.class);
	private static final String calledClass = YetaP63001ServiceImpl.class.getName();
	  
	
	@Autowired
	@Resource(name = "Ye165030_2021_DAO")
	private Ye165030_2021_DAO ye165030DAO;
	  
	  
	//이월기부금 신규 수정 삭제부
	@Override
	public Long activityOnYetaP63001ToYe165030(List<Ye165030DTO> listYe165030Dto, ActionDatabase actionDatabase) throws MSFException {
		
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);

		BigDecimal Seqn = new BigDecimal(0);

		String windowNm = "소득공제신고자료관리";
		String windowId = "YETAP630001";

		MSFSysm0100BM sessionUser;
		String method = calledClass + ".activityOnYetaP63001ToYe165030";

		Ye165030DTO ye165030Dto = new Ye165030DTO();
		Ye165030_2021_VO ye165030Vo = new Ye165030_2021_VO();
			
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
			
		try {  
			
			if (MSFSharedUtils.paramNull(ye165030DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				ye165030DAO = (Ye165030_2021_DAO) wac.getBean("Ye165030_2021_DAO");
			}
		           
				
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
			for (int iPsnlCnt = 0; iPsnlCnt < listYe165030Dto.size(); iPsnlCnt++) {

				ye165030Dto = new Ye165030DTO();
				ye165030Dto = listYe165030Dto.get(iPsnlCnt);

				ye165030Vo = new Ye165030_2021_VO();
					
				ye165030Vo.setDpobCd(sessionUser.getDpobCd());    																	/** column 사업장코드 : dpobCd */
				ye165030Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye165030Dto.getYrtxBlggYr()));    								/** column 귀속연도 : yrtxBlggYr */
				ye165030Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye165030Dto.getClutSeptCd()));    								/** column 연말정산구분코드 : clutSeptCd */
				ye165030Vo.setSystemkey(MSFSharedUtils.allowNulls(ye165030Dto.getSystemkey()));    									/** column SYSTEMKEY : systemkey */
				ye165030Vo.setConbSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(ye165030Dto.getConbSeilNum(), "0")));  		/** column 기부금조정일련번호 : conbSeilNum */
				ye165030Vo.setConbCddl(MSFSharedUtils.allowNulls(ye165030Dto.getConbCddl()));    									/** column 기부금유형구분코드 : conbCddl */
				ye165030Vo.setAttrYr(MSFSharedUtils.allowNulls(ye165030Dto.getAttrYr()));    										/** column 기부년도 : attrYr */
				ye165030Vo.setUseAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye165030Dto.getUseAmt(), "0")));    				/** column 기부금액 : useAmt */
				ye165030Vo.setPyrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye165030Dto.getPyrDdcAmt(), "0")));    			/** column 전년도공제된금액 : pyrDdcAmt */
				ye165030Vo.setDdcTrgtAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye165030Dto.getDdcTrgtAmt(), "0")));    		/** column 기부금공제대상금액 : ddcTrgtAmt */
				ye165030Vo.setThcYrDdcAmtNdXps(new BigDecimal(MSFSharedUtils.defaultNulls(ye165030Dto.getThcYrDdcAmtNdXps(), "0")));/** column 해당연도공제금액필요경비 : thcYrDdcAmtNdXps */
				ye165030Vo.setThcYrDdcAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye165030Dto.getThcYrDdcAmt(), "0")));    		/** column 해당연도공제금액세액공제금액 : thcYrDdcAmt */
				ye165030Vo.setThcYrNducExtnAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye165030Dto.getThcYrNducExtnAmt(), "0")));/** column 해당연도미공제금액_소멸금액 : thcYrNducExtnAmt */
				ye165030Vo.setThcYrNducCrfwAmt(new BigDecimal(MSFSharedUtils.defaultNulls(ye165030Dto.getThcYrNducCrfwAmt(), "0")));/** column 해당연도미공제금액_이월금액 : thcYrNducCrfwAmt */					
				ye165030Vo.setCtrbTycd(MSFSharedUtils.allowNulls(ye165030Dto.getCtrbTycd()));    									/** column 기부금유형신고코드 : ctrbTycd */
		            
		            
				ye165030Vo.setIsmt(sessionUser.getUsrId());		/** column 수정자 : ismt */
				ye165030Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());/** column 수정주소 : revnAddr */
		            
		                      
		        	switch (actionDatabase) {
		        		case INSERT:
		            
		        			ye165030Vo.setKybdr(sessionUser.getUsrId()); 	/** column 입력자 : kybdr */ 
		        			ye165030Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());/** column 입력주소 : inptAddr */ 
            		
		        			ye165030DAO.insertYetaP63001ToYe165030(ye165030Vo); 
		        			break;
		            	case UPDATE: 
		            		ye165030DAO.updateYetaP63001ToYe165030(ye165030Vo); 
		            		break;
		            	case DELETE: 
		            		ye165030DAO.deleteYetaP63001ToYe165030(ye165030Vo); 
		            		break;
				}

				iCnt = iCnt + 1;
			}
			result = iCnt;

		} catch (Exception ex) {
			logger.error("EXCEPTION calling activityOnYetaP03001ToYeta4170(): "+ ex);

			/** 에러 로그 **/
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser, method,calledClass, "C:D", ex, windowNm, windowId);

			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnYetaP63001ToYe165030", ex, logger);
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
	
	
	
	/** 이월기부금 조회 **/
	public PagingLoadResult<BaseModel> getYetaP63001ToYe165030DataList(ServiceParameters serviceParameters) throws MSFException {
		
		PagingLoadResult<BaseModel> retval = null;
		String method = CLASS_YETAP63001_TO_YE165030_DATA_LIST;
		Ye165030Srh_2021_VO ye165030SrhVo = new Ye165030Srh_2021_VO();
		List<BaseModel> bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(ye165030DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			ye165030DAO = (Ye165030_2021_DAO) wac.getBean("Ye165030_2021_DAO"); 
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
	    	
	    	ye165030SrhVo.setDpobCd(sessionUser.getDpobCd());    																/** column 사업장코드 : dpobCd */
	    	ye165030SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));	/** column 귀속연도 : yrtxBlggYr */
	    	ye165030SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));	/** column 연말정산구분코드 : clutSeptCd */
	    	ye165030SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));	/** column SYSTEMKEY : systemkey */
//	    	ye165030SrhVo.setConbSeilNum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "conbSeilNum")));    /** column 기부금조정일련번호 : conbSeilNum */	    	
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = ye165030DAO.selectYetaP63001ToYe165030ListTotCnt(ye165030SrhVo);  
	          	

	              
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
	     	ye165030SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		ye165030SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		ye165030SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = ye165030DAO.selectYetaP63001ToYe165030List(ye165030SrhVo);
	            
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
