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

import com.app.exterms.insurance.client.dto.Insr3100DTO;
import com.app.exterms.insurance.client.service.Insr4500Service;
import com.app.exterms.insurance.server.service.dao.Insr3100DAO;
import com.app.exterms.insurance.server.vo.Insr3100SrhVO;
import com.app.exterms.insurance.server.vo.Insr3100VO;
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
import com.app.smrmf.infc.personal.server.service.dao.InfcPkgPsnl0127DAO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Insr4500Service")
public class Insr4500ServiceImpl extends AbstractCustomServiceImpl implements Insr4500Service, InsrDaoConstants {
	
	private static final Logger logger = LoggerFactory.getLogger(Insr4500ServiceImpl.class);
	private static final String calledClass	= Insr4500ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name = "Insr3100DAO")
    private Insr3100DAO insr3100DAO;
	
	@Autowired 
    @Resource(name="InfcPkgPsnl0127DAO")
    private InfcPkgPsnl0127DAO infcPsnl0127DAO;
	
	/* 조회 */
	public PagingLoadResult<BaseModel> getInsr4500ToInsr3100DataList(ServiceParameters serviceParameters) throws MSFException {
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_INSR4500TOINSR3100_DAO_LIST;
		
		Insr3100SrhVO	insr3100SrhVO = new Insr3100SrhVO();
		Insr3100VO		insr3100VO	  = new Insr3100VO();
		List<BaseModel>	bmResult	  = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		if(RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		if(MSFSharedUtils.paramNull(insr3100DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().getSession().getServletContext());
			insr3100DAO = (Insr3100DAO)wac.getBean("Insr3100DAO");
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
			insr3100SrhVO.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			insr3100SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부
//			psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
			insr3100SrhVO.setUsrId(sessionUser.getUsrId());
			insr3100SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")));  //관리부서 
			insr3100SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")));       //호봉제 구분
			/******************************** 권한 ************************************************************************/
			
			String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
			if("FALSE".equals(chkDeptCd)) {
				insr3100SrhVO.setDeptCd(sessionUser.getDeptCd());
				listDeptCd.add(sessionUser.getDeptCd());
				insr3100SrhVO.setDeptCdArr(listDeptCd);     //부서코드
				insr3100SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
			} else {
				insr3100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
				if(insr3100SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
					listDeptCd = null;
					insr3100SrhVO.setDeptCdArr(listDeptCd);     //부서코드
					insr3100SrhVO.setDeptCd("");  //부서코드
				} else {
					insr3100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
					listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
					insr3100SrhVO.setDeptCdArr(listDeptCd);     //부서코드
				}
			}
			insr3100SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가
			insr3100SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));
			
			/******************************** 권한 ************************************************************************/
			
			insr3100SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
//			System.out.println("고용구분코드 = " + insr3100SrhVO.getEmymtDivCd());
			List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));
			insr3100SrhVO.setTypOccuCdArr(lstTypeOccuCd);
			insr3100SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
			
			List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));
			insr3100SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);
			insr3100SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
			
			insr3100SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
			
			insr3100SrhVO.setNofctYrMnthNum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nofctYrMnthNum"))); //년도
			insr3100SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
			insr3100SrhVO.setNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "nm")));    //한글성명
			
	   	 	List<String> listHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));  
	   	 	insr3100SrhVO.setHdofcCodtnCdArr(listHdofcCodtnCd);     //재직코드 
	   	 	
			//Get total record count //전체 데이터 갯수를 가지고 온다.
			if(pagingValues.executeRecordCount) {
				
				//Execute query that returns a single value
				TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
				
				int iResultCnt = insr3100DAO.selectInsr3100ListTotCnt(insr3100SrhVO);
				
				SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
				
				//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
				if(!pagingValues.pageExecute) {
					pagingValues.offsetLimit = iResultCnt;
				}
				
				pagingValues.totalRecordCount = iResultCnt;
				logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
			
			TimingInfo millisBeginInsr3100DataList = SmrmfUtils.startTiming(logger);
			
			/**페이지 카운트 처리를 위한 부분 */
			insr3100SrhVO.setPageSize(pagingValues.totalRecordCount);
			
			//Apply paging
			if(pagingValues.start > 0) {
				insr3100SrhVO.setFirstIndex(pagingValues.start);
			}
			if(pagingValues.offsetLimit > 0) {
				insr3100SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
			}
			
			//Execute query and convert to BaseModel list
			TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			
			@SuppressWarnings("unchecked")
//			Collection<Map<String, Object>> list ??????
			List list = insr3100DAO.selectInsr3100List(insr3100SrhVO);
			
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
	            
			SmrmfUtils.endTiming(logger, millisBeginInsr3100DataList, "getInsr3100DataList");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	/* 당월 급여 반영 */
	@Override
	public Long activityOnInsr3100(List<Insr3100DTO> listInsr3100dto, ActionDatabase actionDatabase) throws MSFException {
		Long result = new Long(0);
		Long iCnt	= new Long(0);
		
		try {
			if(MSFSharedUtils.paramNull(insr3100DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().
																										getSession().
																										getServletContext()
																									   );
				insr3100DAO = (Insr3100DAO)wac.getBean("insr3100DAO");
			}
			if(MSFSharedUtils.paramNull(infcPsnl0127DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest().
																										getSession().
																										getServletContext()
																									   );
				infcPsnl0127DAO = (InfcPkgPsnl0127DAO)wac.getBean("InfcPkgPsnl0127DAO");
			}
			
			for(int iPsnlCnt = 0; iPsnlCnt < listInsr3100dto.size(); iPsnlCnt++) {
				Insr3100DTO insr3100dto = new Insr3100DTO();
				insr3100dto = listInsr3100dto.get(iPsnlCnt);
				Insr3100VO insr3100Vo = new Insr3100VO();
				
				insr3100Vo.setDpobCd(			   insr3100dto.getDpobCd());				/** column 사업장코드				: dpobCd				*/
				insr3100Vo.setSystemkey(		   insr3100dto.getSystemkey());				/** column SYSTEMKEY			: systemkey				*/
				insr3100Vo.setNofctYrMnthNum(	   insr3100dto.getNofctYrMnthNum());		/** column 정산년월				: nofctYrMnthNum		*/
				insr3100Vo.setDspty(			   insr3100dto.getDspty());					/** column 차수					: dspty					*/
				insr3100Vo.setCertNumHuhd(		   insr3100dto.getCertNumHuhd());			/** column 증번호				: certNumHuhd			*/
				insr3100Vo.setYrlyPayTotAmnt((Long)insr3100dto.getYrlyPayTotAmnt());		/** column 연간보수총액			: yrlyPayTotAmnt		*/
				insr3100Vo.setPayMnthAmnt(	 (Long)insr3100dto.getPayMnthAmnt());			/** column 보수월액				: payMnthAmnt			*/
				insr3100Vo.setYrtxCalcBkdnGrde(	   insr3100dto.getYrtxCalcBkdnGrde());		/** column 연말정산등급			: yrtxCalcBkdnGrde		*/
				insr3100Vo.setHlthInsrYrtxPrcsYn(  insr3100dto.getHlthInsrYrtxPrcsYn());	/** column 건강보험연말정산처리여부: hlthInsrYrtxPrcsYn	*/
				insr3100Vo.setHlthYrtxApptnYrMnth( insr3100dto.getHlthYrtxApptnYrMnth());	/** column 건강연말정산적용년월	: hlthYrtxApptnYrMnth	*/
				insr3100Vo.setHlthYrtxPrcsDt(	   insr3100dto.getHlthYrtxPrcsDt());		/** column 건강연말정산처리일자	: hlthYrtxPrcsDt		*/
				
				switch(actionDatabase) {
					case INSERT:
						insr3100DAO.insertInsr3100(insr3100Vo);
						break;
					case UPDATE:
						insr3100DAO.updateInsr3100(insr3100Vo);
						insr3100DAO.updateInsr4500ToPsnl0127(insr3100Vo);
						insr3100DAO.updateInsr4500ToPayr0500(insr3100Vo);
						break;
					case DELETE:
						insr3100DAO.deleteInsr3100(insr3100Vo);
						break;
				}
				iCnt = iCnt + 1;
			}
			result = iCnt;
		} catch(Exception ex) {
			logger.error("EXCEPTION calling activityOnInsr3100(): " + ex);
			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnPsnl0126", ex, logger);
		} finally {
			
		}
		return result;
	}
}