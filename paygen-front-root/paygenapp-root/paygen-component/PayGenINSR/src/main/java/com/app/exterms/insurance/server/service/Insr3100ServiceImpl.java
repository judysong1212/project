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

import com.app.exterms.insurance.client.dto.Insr4100DTO;
import com.app.exterms.insurance.client.service.Insr3100Service;
import com.app.exterms.insurance.server.service.dao.Insr4100DAO;
import com.app.exterms.insurance.server.vo.Insr4100SrhVO;
import com.app.exterms.insurance.server.vo.Insr4100VO;
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
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0127VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
@Service("Insr3100Service")
public class Insr3100ServiceImpl extends AbstractCustomServiceImpl implements Insr3100Service ,InsrDaoConstants{
	
		private static final Logger logger = LoggerFactory.getLogger(Insr3100ServiceImpl.class);
		private static final String calledClass = Insr3100ServiceImpl.class.getName();
		
		
		@Autowired
	    @Resource(name="Insr4100DAO")
	    private Insr4100DAO insr4100DAO;
		 
		
	    @Autowired 
	    @Resource(name="InfcPkgPsnl0127DAO")
	    private InfcPkgPsnl0127DAO infcPsnl0127DAO;
		  
		  /** ID Generation */
	    //@Resource(name="{egovPayr0400IdGnrService}")    
	    //private EgovIdGnrService egovIdGnrService;
	    
		//조회
	    
	    
	    
	    
		
		public PagingLoadResult<BaseModel> getInsr3100ToInsr4100DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_INSR3100TOINSR4100_DAO_LIST;
	        Insr4100SrhVO   insr4100SrhVo = new Insr4100SrhVO();
	        Insr4100VO      insr4100Vo = new Insr4100VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(insr4100DAO)) {
	        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	insr4100DAO = (Insr4100DAO) wac.getBean("Insr4100DAO" ); 
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
	            List<String> listDeptCd = new ArrayList<String>();
	            /** 조건절 */
	            insr4100SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            insr4100SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
		        
	            insr4100SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            
	            insr4100SrhVo.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")));       //고용구분코드
	            insr4100SrhVo.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")));       //호봉제 구분 
	            insr4100SrhVo.setUsrId(sessionUser.getUsrId());  
	            insr4100SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            insr4100SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));    
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	insr4100SrhVo.setDeptCd(sessionUser.getDeptCd()); 
	               listDeptCd.add(sessionUser.getDeptCd());
	               insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
	               insr4100SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	    
	            	insr4100SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
	                     if (insr4100SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                     	 listDeptCd = null; 
	                     	insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	                     	insr4100SrhVo.setDeptCd("");  //부서코드
	                     } else {
	                    	 insr4100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                          insr4100SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	                     } 
	                  
	            }
	            
	             
	          
	            /******************************** 권한 ************************************************************************/
	          
	            
	           // insr4100SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            insr4100SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	            insr4100SrhVo.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
	            
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            insr4100SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	            insr4100SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
//	            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	            insr4100SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	            insr4100SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            insr4100SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            insr4100SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	            
	            List<String> lstHdofcCodtnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"))); 
	            insr4100SrhVo.setHdofcCodtnCdArr(lstHdofcCodtnCd); 
	            insr4100SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
	            
	            
	            insr4100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            insr4100SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = insr4100DAO.selectInsr3100ToInsr4100ListTotCnt(insr4100SrhVo);  
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginInsr3100ToInsr4100DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            insr4100SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	insr4100SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	insr4100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//			            Collection<Map<String, Object>> list ??????
	            List list = insr4100DAO.selectInsr3100ToInsr4100List(insr4100SrhVo);
	            
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginInsr3100ToInsr4100DataList, "getInsr3100ToInsr4100DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }


		@Override
		public Long activityOnInsr4100(List<Insr4100DTO> listInsr4100dto,
				ActionDatabase actionDatabase) throws MSFException {
			    Long result = new Long(0);
		        Long iCnt = new Long(0);
		        
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		        try {  
		            
		        	   if  (MSFSharedUtils.paramNull(insr4100DAO)) {
		       	        
		   	        	WebApplicationContext wac = WebApplicationContextUtils.
		   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

		   	        	insr4100DAO = (Insr4100DAO) wac.getBean("Insr4100DAO" ); 
		   	        }
		            
		            if  (MSFSharedUtils.paramNull(infcPsnl0127DAO)) {
		                
		                WebApplicationContext wac = WebApplicationContextUtils.
		                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

		                infcPsnl0127DAO = (InfcPkgPsnl0127DAO) wac.getBean("InfcPkgPsnl0127DAO" ); 
		            }
		          
		            for(int iPayrCnt=0;iPayrCnt < listInsr4100dto.size();iPayrCnt++) {
		                
		            	  Insr4100DTO insr4100DTO = new Insr4100DTO();  
		            	  insr4100DTO = listInsr4100dto.get(iPayrCnt);
		                 
		            	  Insr4100VO insr4100Vo = new Insr4100VO();  
		                  InfcPkgPsnl0127VO psnl0127Vo = new InfcPkgPsnl0127VO();   

		                  insr4100Vo.setDpobCd(insr4100DTO.getDpobCd());    /** column 사업장코드 : dpobCd */
		                  insr4100Vo.setSystemkey(insr4100DTO.getSystemkey());    /** column SYSTEMKEY : systemkey */
		                  insr4100Vo.setEmymtSeilNum(insr4100DTO.getEmymtSeilNum());    /** column 고용일련번호 : emymtSeilNum */
		                  //
		                  insr4100Vo.setNatPennAqtnDt(insr4100DTO.getNatPennAqtnDt());    /** column 국민연금취득일자 : natPennAqtnDt */
		                  //
		                  insr4100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
		                  insr4100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
							
		                  psnl0127Vo.setDpobCd(insr4100DTO.getDpobCd());    /** column 사업장코드 : dpobCd */
		                  psnl0127Vo.setSystemkey(insr4100DTO.getSystemkey());    /** column SYSTEMKEY : systemkey */
		                  //
		                  psnl0127Vo.setNatPennGrde(insr4100DTO.getNatPennGrde());    /** column 국민연금등급 : natPennGrde */
 
		                  psnl0127Vo.setNatPennStdIncmMnthAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(insr4100DTO.getNatPennStdIncmMnthAmnt(), "0")));    /** column 국민연금기준소득월액 : natPennStdIncmMnthAmnt */
 
		                  //
		                  psnl0127Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */ 
		                  psnl0127Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
						  
		                   switch (actionDatabase) {
		                   case INSERT:
		                       break;
		                   case UPDATE: 
		                	   insr4100DAO.updateInsr3100ToInsr4100(insr4100Vo); 
		                       infcPsnl0127DAO.updateInsr3100ToPsnl0127(psnl0127Vo); 
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
