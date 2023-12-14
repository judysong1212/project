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

import com.app.exterms.insurance.client.dto.Insr3000DTO;
import com.app.exterms.insurance.client.service.Insr4100Service;
import com.app.exterms.insurance.server.service.dao.Insr3000DAO;
import com.app.exterms.insurance.server.vo.Insr3000SrhVO;
import com.app.exterms.insurance.server.vo.Insr3000VO;
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
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0540DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0500VO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0540VO;
import com.app.smrmf.infc.personal.server.service.dao.InfcPkgPsnl0127DAO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0127VO;
import com.app.smrmf.props.ExtermsProps;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
@Service("Insr4100Service")
public class Insr4100ServiceImpl extends AbstractCustomServiceImpl implements Insr4100Service ,InsrDaoConstants{
	
		private static final Logger logger = LoggerFactory.getLogger(Insr4100ServiceImpl.class);
		private static final String calledClass = Insr4100ServiceImpl.class.getName(); 
		
		@Autowired
	    @Resource(name="Insr3000DAO")
	    private Insr3000DAO insr3000DAO;
		

	    @Autowired 
	    @Resource(name="InfcPkgPsnl0127DAO")
	    private InfcPkgPsnl0127DAO infcPsnl0127DAO;
		   
	    @Autowired 
	    @Resource(name="InfcPkgPayr0540DAO")
	    private InfcPkgPayr0540DAO infcPayr0540DAO;
	    
	    @Autowired 
	    @Resource(name="InfcPkgPayr0500DAO")
	    private InfcPkgPayr0500DAO infcPayr0500DAO;
		  

		/** ID Generation */
	    //@Resource(name="{egovInsr4100ToInsr3000IdGnrService}")    
	    //private EgovIdGnrService egovIdGnrService;
		 /**
		  * 
		  * @param serviceParameters
		  * @return
		  * @throws MSFException
		  */
		public PagingLoadResult<BaseModel> getInsr4100ToInsr3000DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_INSR4100TOINSR3000_DAO_LIST;
	        Insr3000SrhVO   insr3000SrhVo = new Insr3000SrhVO();
	        Insr3000VO      insr3000Vo = new Insr3000VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(insr3000DAO)) {
	        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	insr3000DAO = (Insr3000DAO) wac.getBean("Insr3000DAO" ); 
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
	            insr3000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            insr3000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            insr3000SrhVo.setMangeDeptCd((MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")))); //관리부서
	            insr3000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            insr3000SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")));       //호봉제 구분
	            insr3000SrhVo.setUsrId(sessionUser.getUsrId());  
	            insr3000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            insr3000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));  
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	insr3000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	               listDeptCd.add(sessionUser.getDeptCd());
	               insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	               insr3000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	    
	            	insr3000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
	                     if (insr3000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                     	 listDeptCd = null; 
	                     	insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                     	insr3000SrhVo.setDeptCd("");  //부서코드
	                     } else {
	                    	 insr3000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                          insr3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                     } 
	                  
	            }
	            
	               
	           
	            /******************************** 권한 ************************************************************************/
	           // insr3000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            insr3000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	            insr3000SrhVo.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            insr3000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	            insr3000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
//	            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	            insr3000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	            insr3000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            insr3000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            insr3000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	            
	            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
	            insr3000SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
	            insr3000SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
	            
	            
	            insr3000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            insr3000SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = insr3000DAO.selectInsr4100ToInsr3000ListTotCnt(insr3000SrhVo);  
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginInsr4100ToInsr3000DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            insr3000SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	insr3000SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	insr3000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//			            Collection<Map<String, Object>> list ??????
	            List list = insr3000DAO.selectInsr4100ToInsr3000List(insr3000SrhVo);
	            
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginInsr4100ToInsr3000DataList, "getInsr4100ToInsr3000DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exceptio
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }

		@Override
		public Long activityOnInsr3000(List<Insr3000DTO> listInsr3000dto,
				ActionDatabase actionDatabase) throws MSFException {
			    Long result = new Long(0);
		        Long iCnt = new Long(0);
		        
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		        try {  
		            
		        	   if  (MSFSharedUtils.paramNull(insr3000DAO)) {
		       	        
		   	        	WebApplicationContext wac = WebApplicationContextUtils.
		   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

		   	        	insr3000DAO = (Insr3000DAO) wac.getBean("Insr3000DAO" ); 
		   	        }
		            
		            if  (MSFSharedUtils.paramNull(infcPsnl0127DAO)) {
		                
		                WebApplicationContext wac = WebApplicationContextUtils.
		                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

		                infcPsnl0127DAO = (InfcPkgPsnl0127DAO) wac.getBean("InfcPkgPsnl0127DAO" ); 
		            }
		            
		            if  (MSFSharedUtils.paramNull(infcPayr0540DAO)) {
		                
		                WebApplicationContext wac = WebApplicationContextUtils.
		                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

		                infcPayr0540DAO = (InfcPkgPayr0540DAO) wac.getBean("InfcPkgPayr0540DAO" ); 
		            }
		            
		            if  (MSFSharedUtils.paramNull(infcPayr0500DAO)) {
		                
		                WebApplicationContext wac = WebApplicationContextUtils.
		                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

		                infcPayr0500DAO = (InfcPkgPayr0500DAO) wac.getBean("InfcPkgPayr0500DAO" ); 
		            }
		            
		            
		            //psnl0127,Insr3000, Payr0540 업데이트 
		            for(int iPayrCnt=0;iPayrCnt < listInsr3000dto.size();iPayrCnt++) {
		                
		            	  Insr3000DTO insr3000Dto = new Insr3000DTO();  
		            	  insr3000Dto = listInsr3000dto.get(iPayrCnt);
		                 
		            	  Insr3000VO insr3000Vo = new Insr3000VO();  
		            	  InfcPkgPayr0540VO payr0540Vo = new InfcPkgPayr0540VO(); 
		                  InfcPkgPsnl0127VO psnl0127Vo = new InfcPkgPsnl0127VO();  
		                  InfcPkgPayr0500VO payr0500Vo = new InfcPkgPayr0500VO();

		                  insr3000Vo.setDpobCd(insr3000Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
		                  insr3000Vo.setSystemkey(insr3000Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
		                  insr3000Vo.setEmymtSeilNum(new BigDecimal(insr3000Dto.getEmymtSeilNum()));    /** column 고용일련번호 : emymtSeilNum */
		                  insr3000Vo.setSocInsrDducEthdCd(insr3000Dto.getSocInsrDducEthdCd());    /** column 사대보험공제방식코드 : socInsrDducEthdCd */
		                  insr3000Vo.setHlthInsrAqtnDt(insr3000Dto.getHlthInsrAqtnDt());    /** column 건강보험취득일자 : hlthInsrAqtnDt */
		                  insr3000Vo.setHlthInsrLssDt(insr3000Dto.getHlthInsrLssDt());    /** column 건강보험상실일자 : hlthInsrLssDt */
		                 // insr3000Vo.setKybdr(remtInpt3100Vo.getKybdr());    /** column 입력자 : kybdr */
		                 // insr3000Vo.setInptDt(remtInpt3100Vo.getInptDt());    /** column 입력일자 : inptDt */
		                 // insr3000Vo.setInptAddr(remtInpt3100Vo.getInptAddr());    /** column 입력주소 : inptAddr */
		                  insr3000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
		                  insr3000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
		                   
							
		                  psnl0127Vo.setDpobCd(insr3000Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
		                  psnl0127Vo.setSystemkey(insr3000Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
		                 // psnl0127Vo.setSoctyInsurYr(EgovExcelUtil.getValue(cell));    /** column 사회보험년도 : soctyInsurYr */ 
							 
					//		psnl0127Vo.setHlthInsurFlucDt(remtInpt3100Vo.getHlthInsurFlucDt());    /** column 건강보험변동일자 : hlthInsurFlucDt */
		                 // psnl0127Vo.setHlthInsrPayTotAmnt(insr3000Dto.getHlthInsrPayTotAmnt());    /** column 건강보험보수총액 : hlthInsrPayTotAmnt */
		                  
		                  if (ExtermsProps.getProps("INSR_SOC_INSR_DDUC_0200").equals(insr3000Dto.getSocInsrDducEthdCd())) {
		                	  psnl0127Vo.setHlthInsrMnthRuntnAmnt(BigDecimal.ZERO);    /** column 고용보험보수월액 : umytInsrPayMnthAmnt */
				                  
							} else {
								psnl0127Vo.setHlthInsrMnthRuntnAmnt(new BigDecimal(insr3000Dto.getHlthInsrMnthRuntnAmnt()));    /** column 건강보험보수월액 : hlthInsrMnthRuntnAmnt */
				                  
							}
		                  
		                  
		                //  psnl0127Vo.setHlthInsrGrde(insr3000Dto.getHlthInsrGrde());    /** column 건강보험등급 : hlthInsrGrde */
		                  psnl0127Vo.setHlthInsrCertNum(insr3000Dto.getHlthInsrCertNum());    /** column 건강보험증번호 : hlthInsrCertNum */ 
		                  psnl0127Vo.setHlthInsrApptnYn("Y");  //건강보험적용여부 Y 업데이트 처리함
		                  
		                  psnl0127Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
		                  psnl0127Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
		                  
		                  
		                  //건강보험관리 저장시 PAYR0500 건강보험적용여부 업데이트
		                  payr0500Vo.setDpobCd(insr3000Dto.getDpobCd());
		                  payr0500Vo.setSystemkey(insr3000Dto.getSystemkey());
		                  payr0500Vo.setHlthInsrApptnYn("Y");
		                  payr0500Vo.setIsmt(sessionUser.getUsrId());
		                  payr0500Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		                  
		                  
		                  
						  //건강보험 	TODO 차후처리 확인
//		                  payr0540Vo.setDpobCd(insr3000Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
//		                  payr0540Vo.setSystemkey(insr3000Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
//		                 // payr0540Vo.setExptnPrcsSeilNum(insr3000Dto.getExptnPrcsSeilNum());    /** column 예외처리일련번호 : exptnPrcsSeilNum */
//		                  payr0540Vo.setExptnDivCd(insr3000Dto.getExptnDivCd());    /** column 예외구분코드 : exptnDivCd */
//		                  payr0540Vo.setPymtDducDivCd(insr3000Dto.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
//		                  payr0540Vo.setExmtnYn(insr3000Dto.getExmtnYn());    /** column 면제여부 : exmtnYn */
//		                  payr0540Vo.setExptnPrcsPymtSum(BigDecimal.ZERO);    /** column 예외처리공제금액 : exptnPrcsPymtSum */
//		                  payr0540Vo.setExptnPrcsPymtRto(insr3000Dto.getExptnPrcsPymtRto01());    /** column 예외처리공제비율 : exptnPrcsPymtRto */
//		               //   payr0540Vo.setExptnPrcsBgnnDt(insr3000Dto.getExptnPrcsBgnnDt());    /** column 예외처리시작일자 : exptnPrcsBgnnDt */
//		              //    payr0540Vo.setExptnPrcsEndDt(insr3000Dto.getExptnPrcsEndDt());    /** column 예외처리종료일자 : exptnPrcsEndDt */
//		                  payr0540Vo.setPayItemCd(insr3000Dto.getPayItemCd());    /** column 급여항목코드 : payItemCd */
//		                  payr0540Vo.setExptnPrcsNoteCtnt(insr3000Dto.getExptnPrcsNoteCtnt());    /** column 예외처리내용 : exptnPrcsNoteCtnt */
//		                  payr0540Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
//		                  payr0540Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
//		                  payr0540Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
//		                  payr0540Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
							 
		                   switch (actionDatabase) {
		                   case INSERT:
		                       
		                       break;
		                   case UPDATE: 
		                	   insr3000DAO.updateInsr3000(insr3000Vo); 
		                       infcPsnl0127DAO.updateInsr4100ToPsnl0127(psnl0127Vo); 
		                       infcPayr0500DAO.updateInsr4100ToPayr0500(payr0500Vo);
		                       //검색조건에 따라 인서트 업데이트 처리해야함. 
		                       //infcPayr0540DAO
		                       break;
		                   case DELETE: 
		                       
		                       break;
		                   } 
		                   iCnt = iCnt + 1; 
		                    
		               } 
		                result = iCnt;
		          
		        }
		        catch (Exception ex) {
		            logger.error("EXCEPTION calling activityOnDlgn0250(): "+ex); 
		            
		            result = new Long(0);
		            throw MSFServerUtils.getOperationException("activityOnDlgn0250", ex, logger);
		        }
		        finally {
		          
		        }
		        
		        return result;
		}
		
}
