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

import com.app.exterms.insurance.client.dto.Insr5100DTO;
import com.app.exterms.insurance.client.service.Insr5100Service;
import com.app.exterms.insurance.server.service.dao.Insr5100DAO;
import com.app.exterms.insurance.server.vo.Insr5100SrhVO;
import com.app.exterms.insurance.server.vo.Insr5100VO;
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
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0500DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0500VO;
import com.app.smrmf.infc.personal.server.service.dao.InfcPkgPsnl0127DAO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0127VO;
import com.app.smrmf.props.ExtermsProps;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Insr5100Service")
public class Insr5100ServiceImpl extends AbstractCustomServiceImpl implements Insr5100Service ,InsrDaoConstants{
	
		private static final Logger logger = LoggerFactory.getLogger(Insr5100ServiceImpl.class);
		private static final String calledClass = Insr5100ServiceImpl.class.getName();
		

		@Autowired
	    @Resource(name="Insr5100DAO")
	    private Insr5100DAO insr5100DAO;
		
		   @Autowired 
		    @Resource(name="InfcPkgPsnl0127DAO")
		    private InfcPkgPsnl0127DAO infcPsnl0127DAO;
			   
		    @Autowired 
		    @Resource(name="InfcPkgPayr0500DAO")
		    private InfcPkgPayr0500DAO infcPayr0500DAO;
		
		  /** ID Generation */
	    //@Resource(name="{egovInsr5100ToInsr5100IdGnrService}")    
	    //private EgovIdGnrService egovIdGnrService;
		
		public PagingLoadResult<BaseModel> getInsr5100ToInsr5100DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_INSR5100TOINSR5100_DAO_LIST;
	        Insr5100SrhVO   insr5100SrhVo = new Insr5100SrhVO();
	        Insr5100VO      insr5100VO = new Insr5100VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(insr5100DAO)) {
	        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	insr5100DAO = (Insr5100DAO) wac.getBean("Insr5100DAO" ); 
	        }
	        
	        try {
	        	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	           // Sysm0400BM          user             = serviceParameters.getUser();
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
	            insr5100SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            insr5100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            insr5100SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")));  //관리부서 
	            insr5100SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")));       //호봉제 구분
	            insr5100SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	             
	            insr5100SrhVo.setUsrId(sessionUser.getUsrId());  
	            
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	insr5100SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	               listDeptCd.add(sessionUser.getDeptCd());
	               insr5100SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	               insr5100SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	    
	            	 insr5100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
	                     if (insr5100SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                     	 listDeptCd = null; 
	                     	insr5100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                     	insr5100SrhVo.setDeptCd("");  //부서코드
	                     } else {
	                    	 insr5100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                          insr5100SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                     } 
	                  
	            }
	            
	            insr5100SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            insr5100SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
	             
	            /******************************** 권한 ************************************************************************/
	           // insr5100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            insr5100SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	            insr5100SrhVo.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            insr5100SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	            insr5100SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
	            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
	            insr5100SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
	            insr5100SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            insr5100SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            insr5100SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	            
	            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
	            insr5100SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
	            insr5100SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
	            
	            
	            insr5100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            insr5100SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = insr5100DAO.selectInsr5100ToInsr5100ListTotCnt(insr5100SrhVo);  
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginInsr5100ToInsr5100DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            insr5100SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	insr5100SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	insr5100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//			            Collection<Map<String, Object>> list ??????
	            List list = insr5100DAO.selectInsr5100ToInsr5100List(insr5100SrhVo);
	            
		        Iterator<Map<String, Object>> iter = list.iterator();
		            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
	            while ( iter.hasNext() ) {
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("systemkey").toString();
	                BaseModel bm = new BaseModel();
	 
	                //bm.setProperties(map);
	                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
	                	
	                  //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
	                    Object mapCon = map.get(tableAttributes[i].getName());  
	                     
	                    switch ( tableAttributes[i].getType() ) {  
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
	                       
	                     Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"yyyyMMdd");
	                     map.put(tableAttributes[i].getName(), value);
	                     
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginInsr5100ToInsr5100DataList, "getInsr5100ToInsr5100DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }

		@Override
		public Long activityOnInsr5100(List<Insr5100DTO> listInsr5100dto,
				ActionDatabase actionDatabase) throws MSFException {
			// TODO Auto-generated method stub
			  Long result = new Long(0);
		        Long iCnt = new Long(0);
		        
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		        try {  
		            
		        	   if  (MSFSharedUtils.paramNull(insr5100DAO)) {
		       	        
		   	        	WebApplicationContext wac = WebApplicationContextUtils.
		   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

		   	        	insr5100DAO = (Insr5100DAO) wac.getBean("Insr5100DAO" ); 
		   	        }
		            
		            if  (MSFSharedUtils.paramNull(infcPsnl0127DAO)) {
		                
		                WebApplicationContext wac = WebApplicationContextUtils.
		                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

		                infcPsnl0127DAO = (InfcPkgPsnl0127DAO) wac.getBean("InfcPkgPsnl0127DAO" ); 
		            }
		            
		            if  (MSFSharedUtils.paramNull(infcPayr0500DAO)) {
		                
		                WebApplicationContext wac = WebApplicationContextUtils.
		                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

		                infcPayr0500DAO = (InfcPkgPayr0500DAO) wac.getBean("InfcPkgPayr0500DAO" ); 
		            }
		            
		            //psnl0127,Insr3000, Payr0540 업데이트 
		            for(int iPayrCnt=0;iPayrCnt < listInsr5100dto.size();iPayrCnt++) {
		                
		            	  Insr5100DTO insr5100Dto = new Insr5100DTO();  
		            	  insr5100Dto = listInsr5100dto.get(iPayrCnt);
		                 
		            	  Insr5100VO insr5100Vo = new Insr5100VO();  
		            	  InfcPkgPayr0500VO infcPayr0500Vo = new InfcPkgPayr0500VO(); 
		                  InfcPkgPsnl0127VO infcPsnl0127Vo = new InfcPkgPsnl0127VO();   
 
		                  

							insr5100Vo.setDpobCd(insr5100Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
							insr5100Vo.setSystemkey(insr5100Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
						//	insr5100Vo.setUmytInsrSeilNum(new BigDecimal(insr5100Dto.getUmytInsrSeilNum()));    /** column 고용보험일련번호 : umytInsrSeilNum */
							insr5100Vo.setEmymtSeilNum(new BigDecimal(insr5100Dto.getEmymtSeilNum()));    /** column 고용일련번호 : emymtSeilNum */
							insr5100Vo.setSocInsrDducEthdCd(insr5100Dto.getSocInsrDducEthdCd());    /** column 사대보험공제방식코드 : socInsrDducEthdCd */
							insr5100Vo.setUmytInsrAqtnDt(insr5100Dto.getUmytInsrAqtnDt());    /** column 고용보험취득일자 : umytInsrAqtnDt */
							insr5100Vo.setUmytInsrLssDt(insr5100Dto.getUmytInsrLssDt());    /** column 고용보험상실일자 : umytInsrLssDt */
							insr5100Vo.setUmytInsrEepnYn(Boolean.TRUE.equals(insr5100Dto.getUmytInsrEepnYn()) ? "Y" : "N");    /** column 고용보험제외여부 : umytInsrEepnYn */
							insr5100Vo.setUmytInsrEepnReasCtnt(insr5100Dto.getUmytInsrEepnReasCtnt());    /** column 고용보험제외사유내용 : umytInsrEepnReasCtnt */
							 
							insr5100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
							insr5100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
			                    

							infcPsnl0127Vo.setDpobCd(insr5100Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
							infcPsnl0127Vo.setSystemkey(insr5100Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
							//infcPsnl0127Vo.setSoctyInsurYr(insr5100Dto.getSoctyInsurYr());    /** column 사회보험년도 : soctyInsurYr *//
							infcPsnl0127Vo.setUmytInsrApptnYn(Boolean.TRUE.equals(insr5100Dto.getUmytInsrApptnYn()) ? "N" : "Y");    /** column 고용보험적용여부 : umytInsrApptnYn */
							//infcPsnl0127Vo.setUmytInsrFlucDt(insr5100Dto.getUmytInsrFlucDt());    /** column 고용보험변동일자 : umytInsrFlucDt */
						//	infcPsnl0127Vo.setUmytInsrPayTotAmnt(insr5100Dto.getUmytInsrPayTotAmnt());    /** column 고용보험보수총액 : umytInsrPayTotAmnt */
							if (ExtermsProps.getProps("INSR_SOC_INSR_DDUC_0200").equals(insr5100Dto.getSocInsrDducEthdCd())) {
								infcPsnl0127Vo.setUmytInsrPayMnthAmnt(BigDecimal.ZERO);    /** column 고용보험보수월액 : umytInsrPayMnthAmnt */
				                  
							} else {
								infcPsnl0127Vo.setUmytInsrPayMnthAmnt(new BigDecimal(insr5100Dto.getUmytInsrPayMnthAmnt()));    /** column 고용보험보수월액 : umytInsrPayMnthAmnt */
				                  
							}
							
		                    infcPsnl0127Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
		                    infcPsnl0127Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
		                  
		                  
						    //고용보험사용여부 
							infcPayr0500Vo.setDpobCd(insr5100Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
							infcPayr0500Vo.setSystemkey(insr5100Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
							 
							infcPayr0500Vo.setUmytInsrApptnYn(Boolean.TRUE.equals(insr5100Dto.getUmytInsrApptnYn()) ? "N" : "Y");    /** column 고용보험적용여부 : umytInsrApptnYn */
							 
							
							infcPayr0500Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
							infcPayr0500Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */

							 
		                   switch (actionDatabase) {
		                   case INSERT:
		                       
		                       break;
		                   case UPDATE: 
		                	   insr5100DAO.updateInsr5100(insr5100Vo); 
		                       infcPsnl0127DAO.updateInsr5100ToPsnl0127(infcPsnl0127Vo); 
		                       //검색조건에 따라 인서트 업데이트 처리해야함. 
		                       infcPayr0500DAO.updateInsr5100ToPayr0500(infcPayr0500Vo); 
		                       break;
		                   case DELETE: 
		                       
		                       break;
		                   } 
		                   iCnt = iCnt + 1; 
		                    
		               } 
		                result = iCnt;
		          
		        }
		        catch (Exception ex) {
		            logger.error("EXCEPTION calling activityOnInsr5100(): "+ex); 
		            
		            result = new Long(0);
		            throw MSFServerUtils.getOperationException("activityOnInsr5100", ex, logger);
		        }
		        finally {
		          
		        }
		        
		        return result;
		}
}
