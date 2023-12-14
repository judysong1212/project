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
package com.app.exterms.insurance.server.service;

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

import com.app.exterms.insurance.client.dto.Insr5200DTO;
import com.app.exterms.insurance.client.service.Insr5200Service;
import com.app.exterms.insurance.server.service.dao.Insr5200DAO;
import com.app.exterms.insurance.server.vo.Insr5200SrhVO;
import com.app.exterms.insurance.server.vo.Insr5200VO;
import com.app.exterms.insurance.shared.InsrDaoConstants;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Insr5200Service")
public class Insr5200ServiceImpl extends AbstractCustomServiceImpl implements Insr5200Service ,InsrDaoConstants{
	
		private static final Logger logger = LoggerFactory.getLogger(Insr5200ServiceImpl.class);
		private static final String calledClass = Insr5200ServiceImpl.class.getName();
		
		@Autowired
	    @Resource(name="Insr5200DAO")
	    private Insr5200DAO insr5200DAO;

		public PagingLoadResult<BaseModel> getInsr5200ToInsr5200DataList(ServiceParameters serviceParameters) throws MSFException {
			PagingLoadResult<BaseModel> retval = null;
			String method =  CLASS_INSR5200TOINSR5200_DAO_LIST;
			Insr5200SrhVO insr5200SrhVO = new Insr5200SrhVO();
			Insr5200VO insr5200VO = new Insr5200VO();
			List<BaseModel> bmResult = new ArrayList<BaseModel>();
			MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			
			if(MSFSharedUtils.paramNull(insr5200DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
				insr5200DAO = (Insr5200DAO)wac.getBean("Insr5200DAO" );
			}
			
			try {
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
				IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
				List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
				PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
				
				/* Get paging configuration */
				PagingValues pagingValues		   = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

				/* Get query parameters */
				List<String> listDeptCd = new ArrayList<String>();
				
				/** 조건절 */
				insr5200SrhVO.setDpobCd(sessionUser.getDpobCd());																		/* 사업장코드			*/
				insr5200SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());	
				insr5200SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")));  //관리부서 
				insr5200SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")));       //호봉제 구분/* 단위기관담당자여부	*/
				//insr5200SrhVO.setNofctYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nofctYrMnth")));	/* 지급년월			*/
				insr5200SrhVO.setDducYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dducYrMnth")));   	/* 지급년월			*/
				insr5200SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));		/* 고용구분코드		*/
				insr5200SrhVO.setUsrId(sessionUser.getUsrId());  
				insr5200SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));	/* 권한처리	*/
				insr5200SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));
				/******************************** 권한 ************************************************************************/
				
				
				System.out.println("getDducYrMnth=============="+insr5200SrhVO.getDducYrMnth().toString());
				
				String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
				if("FALSE".equals(chkDeptCd)) {
					insr5200SrhVO.setDeptCd(sessionUser.getDeptCd());
					listDeptCd.add(sessionUser.getDeptCd());
					insr5200SrhVO.setDeptCdArr(listDeptCd);		/* 부서코드	*/
					insr5200SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
				} else {
					insr5200SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));	/* 단위기관코드	*/
					if(insr5200SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
						listDeptCd = null;
						insr5200SrhVO.setDeptCdArr(listDeptCd);	/* 부서코드	*/
						insr5200SrhVO.setDeptCd("");			/* 부서코드	*/
					} else {
						insr5200SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
						listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
						insr5200SrhVO.setDeptCdArr(listDeptCd);	/* 부서코드	*/
					} 
				}
				/******************************** 권한 ************************************************************************/
				List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
				insr5200SrhVO.setTypOccuCdArr(lstTypeOccuCd);
				insr5200SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));	/* 직종	*/
				
				List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));
				insr5200SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);
				insr5200SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd")));	/* 호봉등급코드	*/
				
				List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));
				insr5200SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);
				insr5200SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));	/* 직종세	*/
				
				insr5200SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));	/* 사업코드	*/
				
				insr5200SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));	/* 시스템키	*/
				insr5200SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));			/* 한글성명	*/
				
				List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));
				insr5200SrhVO.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
				insr5200SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));	/* 재직상태	*/
				
				/* Get total record count 전체 데이터 수 */
				if(pagingValues.executeRecordCount) {
					/* Execute query that returns a single value */
					TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
					
					//////////////////////////////////////
					// 월별 건강보험대사 건수 조회 하기 //
					/////////////////////////////////////
					int iResultCnt = insr5200DAO.selectInsr5200ListTotCnt(insr5200SrhVO);
					
					SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
					
					//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
					if(!pagingValues.pageExecute) {
						pagingValues.offsetLimit = iResultCnt;
					}
					
					pagingValues.totalRecordCount = iResultCnt;
					
					logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
				}
		        
				TimingInfo millisBeginInsr5200ToInsr5200DataList = SmrmfUtils.startTiming(logger);
				
				/**페이지 카운트 처리 */
				insr5200SrhVO.setPageSize(pagingValues.totalRecordCount);
				
				/* Apply paging */
				if(pagingValues.start > 0) {
					insr5200SrhVO.setFirstIndex(pagingValues.start);
				}
				if(pagingValues.offsetLimit > 0) {
					insr5200SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
				}
				
				/* Execute query and convert to BaseModel list */
				TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
				
				
				
				System.out.println("insr5200SrhVO===================================="+insr5200SrhVO.toString() );
				/////////////////////////////////
				// 월별 건강보험대사 조회 하기 //
				////////////////////////////////
				@SuppressWarnings("unchecked")
//				Collection<Map<String, Object>> list ??????
				List list = insr5200DAO.selectInsr5200List(insr5200SrhVO);
				
				System.out.println("list===================================="+list.toString());
				
				Iterator<Map<String, Object>> iter = list.iterator();
				
				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
				
				while(iter.hasNext()) {
					Map<String, Object> map = (Map<String, Object>)iter.next();
					String idValue = map.get("systemkey").toString();
					BaseModel bm = new BaseModel();
					
//					bm.setProperties(map);
					for(int i = 0; i < tableAttributes.length; i++) {
						Object mapCon = map.get(tableAttributes[i].getName());
						switch(tableAttributes[i].getType()) {
						case ColumnDef.TYPE_STRING: 
							String strValue = String.valueOf(mapCon);
							if("resnRegnNum".equals(tableAttributes[i].getName())) {
								// TODO 주민번호		
								strValue = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(map.get("resnRegnNum")).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
							}
							map.put(tableAttributes[i].getName(), strValue);
							break;
							case ColumnDef.TYPE_DATE:
							case ColumnDef.TYPE_DATETIME:
								Date value = SmrmfUtils.getDateFromString(String.valueOf(mapCon), "yyyyMMdd");
								map.put(tableAttributes[i].getName(), value);
								break;
							case ColumnDef.TYPE_LONG:
								if(mapCon != null) {
									Long lValue = (new BigDecimal(mapCon.toString())).longValue();
									map.put(tableAttributes[i].getName(), lValue);
								}
								break;
							case ColumnDef.TYPE_DOUBLE:
								if(mapCon != null) {
									Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue();
									map.put(tableAttributes[i].getName(), dbValue);
								}
								break;
						}
						Object baseModelValue = null;
						/* 콤보박스처리를 위해 추가 */
						if(tableAttributes[i].getName().contains("$")) {
							String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
							map.put(tableAttributes[i].getName(),map.get(strMapCon));
							
							baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(  map.get(tableAttributes[i].getName())
																							   , tableAttributes[i].getType()
																							  );
						} else {
							baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(  map.get(tableAttributes[i].getName())
																							   , tableAttributes[i].getType()
																							  );
						}
						bm.set(tableAttributes[i].getName(), baseModelValue);
					}
					bm.set(TableDef.ID_PROPERTY_NAME, idValue);
					bmResult.add(bm);
				}
				retval = new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);
				
				SmrmfUtils.endTiming(logger, millisBeginInsr5200ToInsr5200DataList, "getInsr5200ToInsr5200DataList");
			} catch (Exception ex) {
				ex.printStackTrace();
				/* Return operation exception */
				throw MSFServerUtils.getOperationException(method, ex, logger);
			}
			return retval;
		}
		
		
		@Override
		public Long insr5200MnthUpdate(List<Insr5200DTO> listInsr5200dto,
				ActionDatabase actionDatabase) throws MSFException {
			    Long result = new Long(0);
		        Long iCnt = new Long(0);
		        
		        int colseCnt = 0;
		        int breakCnt = 0;
		        
		        String payGubn = "";
		        
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		        try {  
		            
		        	   if  (MSFSharedUtils.paramNull(insr5200DAO)) {
		       	        
		   	        	WebApplicationContext wac = WebApplicationContextUtils.
		   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

		   	        	insr5200DAO = (Insr5200DAO) wac.getBean("Insr5200DAO" ); 
		   	        }
		            
		            for(int iPayrCnt=0;iPayrCnt < listInsr5200dto.size();iPayrCnt++) {
		                
		            	  Insr5200DTO insr5200Dto = new Insr5200DTO();  
		            	  insr5200Dto = listInsr5200dto.get(iPayrCnt);
		                 
		            	  Insr5200VO insr5200Vo = new Insr5200VO();  

		            	  insr5200Vo.setDpobCd(insr5200Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
		            	  insr5200Vo.setSystemkey(insr5200Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
		            	  insr5200Vo.setEmymtSeilNum(insr5200Dto.getEmymtSeilNum());    /** column 고용일련번호 : emymtSeilNum */
		                  
		            	  insr5200Vo.setDducYrMnth(insr5200Dto.getDducYrMnth());

		            	  insr5200Vo.setUmytPayrDducYrMnth(insr5200Dto.getUmytPayrDducYrMnth());
		            	  
		            	  insr5200Vo.setUmytPayrDducYrMnth(insr5200Dto.getUmytPayrDducYrMnth());
		            	  
		            	  insr5200Vo.setUmytInsrPrmmSrd(insr5200Dto.getUmytInsrPrmmSrd());     /** column 개인실업급여고용보험차액 : umytInsrPrmmSrd */
		            	  
		            	  insr5200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
		            	  insr5200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
							
		            	  colseCnt = insr5200DAO.selectPayCloseChkCnt(insr5200Vo); 
		            	  
			          	  
			          	  if( (colseCnt <=0 &&  "Pay".equals(insr5200Dto.getUmytPayrDducYrMnth())) || (colseCnt >0 && "This".equals(insr5200Dto.getUmytPayrDducYrMnth()))){	
			          		
			          		  payGubn = insr5200Dto.getUmytPayrDducYrMnth();
			        		  breakCnt = breakCnt+1;
			        		  break;
			        	  }
		            	  
		            	  insr5200DAO.insr5200MnthUpdate(insr5200Vo); 
		                  iCnt = iCnt + 1; 
		                    
		               } 
		            
		        	if(breakCnt>0 && "Pay".equals(payGubn) ){
		        		result = -99L ;
		        	}else if(breakCnt>0 && "This".equals(payGubn) ){
		        	
		        		result = -88L ;
		    		}else{
		        		result = iCnt;
		        	}
		                
		          
		        }
		        catch (Exception ex) {
		            logger.error("EXCEPTION calling insr5200MnthUpdate(): "+ex); 
		            
		            result = new Long(0);
		            throw MSFServerUtils.getOperationException("insr5200MnthUpdate", ex, logger);
		        }
		        finally {
		          
		        }
		        
		        return result;
		}

}
