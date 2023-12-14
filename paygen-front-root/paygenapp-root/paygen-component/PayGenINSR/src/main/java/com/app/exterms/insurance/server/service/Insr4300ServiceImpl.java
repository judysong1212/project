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

import com.app.exterms.insurance.client.dto.Insr3400DTO;
import com.app.exterms.insurance.client.service.Insr4300Service;
import com.app.exterms.insurance.server.service.dao.Insr3400DAO;
import com.app.exterms.insurance.server.vo.Insr3400SrhVO;
import com.app.exterms.insurance.server.vo.Insr3400VO;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.exterms.personal.client.dto.InfcPsnl0100DTO;
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
import com.app.smrmf.infc.personal.server.service.dao.InfcPkgPsnl0100DAO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

import egovframework.rte.psl.dataaccess.util.EgovMap;
@Service("Insr4300Service")
public class Insr4300ServiceImpl extends AbstractCustomServiceImpl implements Insr4300Service, InsrDaoConstants {
	
	private static final Logger logger = LoggerFactory.getLogger(Insr4300ServiceImpl.class);
	private static final String calledClass = Insr4300ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name = "Insr3400DAO")
    private Insr3400DAO insr3400DAO;
	
	@Resource(name = "InfcPkgPsnl0100DAO")
    private InfcPkgPsnl0100DAO infcPsnl0100DAO;
	
	/* 조회 */
	public PagingLoadResult<BaseModel> getInsr4300ToInsr3400DataList(ServiceParameters serviceParameters) throws MSFException {
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_INSR4300TOINSR3400_DAO_LIST;
		
		Insr3400SrhVO	insr3400SrhVO = new Insr3400SrhVO();
		Insr3400VO		insr3400VO	  = new Insr3400VO();
		List<BaseModel>	bmResult	  = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		if(RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		if(MSFSharedUtils.paramNull(insr3400DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().
																									getSession().
																									getServletContext()
																								   );
			insr3400DAO = (Insr3400DAO)wac.getBean("Insr3400DAO");
		}
		
		try {
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
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
			insr3400SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			insr3400SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부
			insr3400SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd"))); //관리부서
			insr3400SrhVO.setUsrId(sessionUser.getUsrId());
			insr3400SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")));       //호봉제 구분
			insr3400SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
			List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
			insr3400SrhVO.setTypOccuCdArr(lstTypeOccuCd);
			insr3400SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));
			insr3400SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);
			insr3400SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
			
			insr3400SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
			
			insr3400SrhVO.setNofctYrMnthNum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nofctYrMnthNum"))); //년도
			insr3400SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
			insr3400SrhVO.setNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nm")));    //한글성명
			
            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
            insr3400SrhVO.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
            
            insr3400SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
            insr3400SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가
            insr3400SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));
            insr3400SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
            insr3400SrhVO.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드

			
			/******************************** 권한 ************************************************************************/
			
			String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
			if("FALSE".equals(chkDeptCd)) {
				insr3400SrhVO.setDeptCd(sessionUser.getDeptCd());
				listDeptCd.add(sessionUser.getDeptCd());
				insr3400SrhVO.setDeptCdArr(listDeptCd);     //부서코드
				insr3400SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
			} else {
				
				if(insr3400SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
					listDeptCd = null;
					insr3400SrhVO.setDeptCdArr(listDeptCd);     //부서코드
					insr3400SrhVO.setDeptCd("");  //부서코드
				} else {
					insr3400SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
					listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
					insr3400SrhVO.setDeptCdArr(listDeptCd);     //부서코드
				}
			}
			
			
			
			/******************************** 권한 ************************************************************************/
			
					
			
			//Get total record count //전체 데이터 갯수를 가지고 온다.
			if(pagingValues.executeRecordCount) {
				
				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				
				int iResultCnt = insr3400DAO.selectInsr3400ListTotCnt(insr3400SrhVO);
				
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
				
				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if(!pagingValues.pageExecute) {
					pagingValues.offsetLimit = iResultCnt;
				}
				
				pagingValues.totalRecordCount = iResultCnt;
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
			
			TimingInfo millisBeginInsr3400DataList = SmrmfUtils.startTiming(logger);
			
			/**페이지 카운트 처리를 위한 부분 */
			insr3400SrhVO.setPageSize(pagingValues.totalRecordCount);
			
			//Apply paging
			if(pagingValues.start > 0) {
				insr3400SrhVO.setFirstIndex(pagingValues.start);
			}
			if(pagingValues.offsetLimit > 0) {
				insr3400SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			
			@SuppressWarnings("unchecked")
//			Collection<Map<String, Object>> list ??????
			List list = insr3400DAO.selectInsr3400List(insr3400SrhVO);
			
			Iterator<Map<String, Object>> iter = list.iterator();
			
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain");
			
			while(iter.hasNext()) {
				Map<String, Object> map = (Map<String, Object>) iter.next();
				String idValue = map.get("systemkey").toString();
				BaseModel bm = new BaseModel();
				
				//bm.setProperties(map);
				for(int i = 0; i < tableAttributes.length; i++) {
					//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
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
	            
			SmrmfUtils.endTiming(logger, millisBeginInsr3400DataList, "getInsr3400DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	/* (재)정산 */
	@Override
	public Long activityOnInsr4300(Insr3400DTO insr3400dto, ActionDatabase actionDatabase) throws MSFException {
		Long result = new Long(0);
		Long iCnt	= new Long(0);
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
				
		if(MSFSharedUtils.paramNull(insr3400DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().
																									getSession().
																									getServletContext()
																								   );
			insr3400DAO = (Insr3400DAO)wac.getBean("insr3400DAO");
			
		}
		if(MSFSharedUtils.paramNull(infcPsnl0100DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().
																									getSession().
																									getServletContext()
																								   );
			infcPsnl0100DAO = (InfcPkgPsnl0100DAO)wac.getBean("InfcPkgPsnl0100DAO");
		}
		try {
			Insr3400SrhVO insr3400SrhVo = new Insr3400SrhVO();
			
			insr3400SrhVo.setDpobCd(sessionUser.getDpobCd());					/** column 사업장코드	: dpobCd			*/
			insr3400SrhVo.setNofctYrMnthNum(insr3400dto.getNofctYrMnthNum());	/** column 정산년월	: nofctYrMnthNum	*/
			insr3400DAO.deleteInsr3400(insr3400SrhVo);
			List<?> listInsr3400 = insr3400DAO.selectPsnl0100List(insr3400SrhVo);
			
			ArrayList insr3400DtoArr = new ArrayList();
			
			for(int i = 0; i < listInsr3400.size(); i++) {
				Insr3400VO insr3400Vo = new Insr3400VO();
				InfcPsnl0100DTO infcPsnl0100Dto = new InfcPsnl0100DTO();
				EgovMap eMap = new EgovMap();
				eMap = (EgovMap) listInsr3400.get(i);
				
				infcPsnl0100Dto.setSystemkey(MSFSharedUtils.allowNulls(eMap.get("systemkey")));
				infcPsnl0100Dto.setRetryDt(MSFSharedUtils.allowNulls(  eMap.get("retryDt")));
				
				insr3400DtoArr.add(infcPsnl0100Dto);
				
				insr3400Vo.setDpobCd(sessionUser.getDpobCd());						/** column 사업장코드		: dpobCd			*/
				insr3400Vo.setNofctYrMnthNum(insr3400dto.getNofctYrMnthNum());				/** column 정산년월		: nofctYrMnthNum	*/
				insr3400Vo.setSystemkey((String) eMap.get("systemkey"));					/** column SYSTEMKEY	: systemkey			*/
				insr3400Vo.setRetryDt((String) eMap.get("retryDt"));					/** column 퇴직일자		: retryDt			*/
				
				insr3400Vo.setHdofcCodtnCd((String) eMap.get("hdofcCodtnCd"));
				insr3400Vo.setEmymtEndDt((String) eMap.get("emymtEndDt"));
				
				insr3400Vo.setKybdr(sessionUser.getUsrId());							/** column 입력자		: kybdr				*/
				insr3400Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 입력주소		: inptAddr			*/
				insr3400Vo.setIsmt(sessionUser.getUsrId());							/** column 수정자		: ismt				*/
				insr3400Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 수정주소		: revnAddr			*/
				
				EgovMap resultMap = insr3400DAO.selectPsnl0110List(insr3400Vo);
				
				insr3400Vo.setEmymtSeilNum((BigDecimal) resultMap.get("emymtSeilNum"));
				insr3400Vo.setClutBgnnDt((String) resultMap.get("clutBgnnDt"));
				insr3400Vo.setDutyMnthIcm((BigDecimal) resultMap.get("dutyMnthIcm"));
				insr3400Vo.setHlthNumCpisTotAmnt((BigDecimal) resultMap.get("hlthNumCpisTotAmnt"));
				insr3400Vo.setHlthPayMnthAmnt((BigDecimal) resultMap.get("hlthPayMnthAmnt"));
				insr3400Vo.setAlpayHlthPrmm((BigDecimal) resultMap.get("alpayHlthPrmm"));
				insr3400Vo.setAlpayLgtmRcptnPrmm((BigDecimal) resultMap.get("alpayLgtmRcptnPrmm"));
				insr3400Vo.setAlpayAggrSum((BigDecimal) resultMap.get("alpayAggrSum"));
				insr3400Vo.setHlthFixPrmm((BigDecimal) resultMap.get("hlthFixPrmm"));
				
				
				insr3400Vo.setTurtyDutyMnthIcm((BigDecimal) resultMap.get("dutyMnthIcm"));
				
				
				//TODO 추후 변경해야함
				insr3400Vo.setHlthCmpttnPrmm(null);
				insr3400Vo.setHlthClutPrmm(null);
				
				
				
			//	System.out.println(map.get("dpobCd"));
				
				insr3400DAO.insertInsr3400(insr3400Vo);
				
				iCnt = iCnt + 1;
			}
			result = iCnt;
		} catch(Exception ex) {
			logger.error("EXCEPTION calling activityOnInsr4300(): " + ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnInsr4300", ex, logger);
		} finally {
			
		}
		return result;
	}
	
	
	 /**
     * 삭제처리 로직  TODO  차후 멀티건에 대한 삭제 기능 추가 
     */
	@Override
	 public Long activityOnDeleteInsr4300(List<BaseModel> list) throws MSFException { 
		
		    Long result = new Long(0); 
		  
	       // MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        try {  
	            
	        	if(MSFSharedUtils.paramNull(insr3400DAO)) {
	    			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().
	    																									getSession().
	    																									getServletContext()
	    																								   );
	    			insr3400DAO = (Insr3400DAO)wac.getBean("insr3400DAO");
	    			
	    		}
			
			 Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)list.iterator();
			 
                while (iterRecords.hasNext()) {
                          BaseModel bmMapModel = (BaseModel) iterRecords.next();
                          
                          Insr3400VO  insr3400Vo = new Insr3400VO();

                          insr3400Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));
                          insr3400Vo.setNofctYrMnthNum(MSFSharedUtils.allowNulls(bmMapModel.get("nofctYrMnthNum")));
                          insr3400Vo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));
                          
                     //     String aa = bmMapModel.get("levfAbncRetryClutNum");
                          
                          BigDecimal  levfAbncRetryClutNum = new BigDecimal((String) bmMapModel.get("levfAbncRetryClutNum"));
                          insr3400Vo.setLevfAbncRetryClutNum(levfAbncRetryClutNum);
                          
                          insr3400DAO.deleteInsr3400_S(insr3400Vo);
                          
                }
	            
	          result = 1L;
	          
	        }
	        catch (Exception ex) {
	            logger.error("EXCEPTION calling activityOnDeleteInsr2100(): "+ex); 
	            
	            result = new Long(0);
	            throw MSFServerUtils.getOperationException("activityOnDeleteInsr2200", ex, logger);
	        }
	        finally {
	          
	        }
	        
	        return result;
	} 
}