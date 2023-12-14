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
package com.app.exterms.payroll.server.service;

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

import com.any.smrmf.utils.BeanFinder;
import com.app.exterms.payroll.client.dto.Payr0301DTO;
import com.app.exterms.payroll.client.service.Payr4250Service;
import com.app.exterms.payroll.server.service.dao.Payr0250DAO;
import com.app.exterms.payroll.server.service.dao.Payr0301DAO;
import com.app.exterms.payroll.server.service.dao.Payr0304DAO;
import com.app.exterms.payroll.server.vo.Payr0250SrhVO;
import com.app.exterms.payroll.server.vo.Payr0250VO;
import com.app.exterms.payroll.server.vo.Payr0301SrhVO;
import com.app.exterms.payroll.server.vo.Payr0301VO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
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
import com.app.smrmf.infc.diligence.server.service.dao.InfcPkgDlgn0100DAO;
import com.app.smrmf.infc.diligence.server.service.dao.InfcPkgDlgn0200DAO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0100VO;
import com.app.smrmf.infc.diligence.server.vo.InfcPkgDlgn0200VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
@Service("Payr4250Service")
public class Payr4250ServiceImpl extends AbstractCustomServiceImpl implements Payr4250Service  ,PayrDaoConstants {

		private static final Logger logger = LoggerFactory.getLogger(Payr4250ServiceImpl.class);
		private static final String calledClass = Payr4250ServiceImpl.class.getName();
		
		@Autowired
	   @Resource(name="Payr0250DAO")
	    private Payr0250DAO payr0250DAO;
		
		//월급여내역 
		@Autowired
	    @Resource(name="Payr0301DAO")
	    private Payr0301DAO payr0301DAO;
	    
		
	   //월급여내역_개
		@Autowired
	    @Resource(name="Payr0304DAO")
	    private Payr0304DAO payr0304DAO;
		
		@Autowired
	    @Resource(name="InfcPkgDlgn0100DAO")
	    private InfcPkgDlgn0100DAO dlgn0100Dao;
		
		@Autowired
	    @Resource(name="InfcPkgDlgn0200DAO")
		private InfcPkgDlgn0200DAO dlgn0200Dao;
		    
		
		//급여스케줄정보를 가지고 온다. 
		public PagingLoadResult<BaseModel> getPayr0250ToPayr4250DataList(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_PAYR0250TOPAYR4250_DATA_LIST;
	        Payr0250SrhVO   payr0250SrhVO = new Payr0250SrhVO();
	        Payr0250VO      payr0250VO = new Payr0250VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	    	// 1. 암호화 객체 생성
//	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	         
	        try {
	        	
	        	payr0250DAO = (Payr0250DAO)BeanFinder.getBean("Payr0250DAO");
	        	
	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	           // Sysm0250BM          user             = serviceParameters.getUser();
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
	            payr0250SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	            payr0250SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	            
	            payr0250SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            payr0250SrhVO.setUsrId(sessionUser.getUsrId()); 
	            /******************************** 권한 ************************************************************************/
	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	            if ("FALSE".equals(chkDeptCd)) {
	            	
	            	if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
	               	 

		            	payr0250SrhVO.setDeptCd(sessionUser.getDeptCd()); 
		               listDeptCd.add(sessionUser.getDeptCd());
		               payr0250SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	            	 } else {
	            		 
	            		 payr0250SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                         listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                         payr0250SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	            	 }  
	            	 
	               payr0250SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
	            } else {
	            	    
	            	     payr0250SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드    
	                     if (payr0250SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
	                     	 listDeptCd = null; 
	                     	payr0250SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
	                     	payr0250SrhVO.setDeptCd("");  //부서코드
	                     } else {
	                    	 payr0250SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
	                          payr0250SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
	                     } 
	                  
	            }
	            
	            payr0250SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
	            payr0250SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
	           /******************************** 권한 ************************************************************************/
	            
//	            if (payr0250SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
//	            	payr0250SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//	            	List<String> listDeptCd = null; 
//	            	payr0250SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//	            	payr0250SrhVO.setDeptCd("");     //부서코드
//	            } else {
//	            	  
//	                List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	                payr0250SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//	                payr0250SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//	               
//	            } 
	            
	           
	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	            payr0250SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
	            payr0250SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));     //부서코드
	           
//	            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	            payr0250SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	            payr0250SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	            payr0250SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	            payr0250SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	            
	            payr0250SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	            payr0250SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  //급여구분코드 
	            payr0250SrhVO.setJobYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth")).replace(".", "") ); //지급년월  
	            payr0250SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	            payr0250SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
	         
	            payr0250SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"mangeDeptCd")));    //관리부서
	            payr0250SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")) ); //호봉제구분
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = payr0250DAO.selectPayr0250ToPayr4250ListTotCnt(payr0250SrhVO);  
	              
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginPayr0250ToPayr4250DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            payr0250SrhVO.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	payr0250SrhVO.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	payr0250SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = payr0250DAO.selectPayr0250ToPayr4250List(payr0250SrhVO);
	            
		        Iterator<Map<String, Object>> iter = list.iterator();
		            
	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
	            while ( iter.hasNext() ) {
	            	
	            	// 1. 암호화 객체 생성
	    	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	    	    	
	                Map<String, Object> map = (Map<String, Object>) iter.next();
	                String idValue = map.get("payScduSeilNum").toString();
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginPayr0250ToPayr4250DataList, "getPayr0250ToPayr4250DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    }		
	 
	//선택된 정보에 급여 내역이 존재하는지를 판단하여 값을 가지고 온다.
	
	public PagingLoadResult<BaseModel> getPayr0301ToPayr4250DataList(ServiceParameters serviceParameters) throws MSFException {
	
	    PagingLoadResult<BaseModel> retval = null;
	    String method =  CLASS_PAYR0301TOPAYR4250_DATA_LIST;
	    Payr0301SrhVO   payr0301SrhVO = new Payr0301SrhVO();
	    Payr0301VO      payr0301VO = new Payr0301VO();
	    List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	    
	    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    

		// 1. 암호화 객체 생성
//		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	   
	    try {
	    	
	    	payr0301DAO = (Payr0301DAO)BeanFinder.getBean("Payr0301DAO");
	    	
	    	
	        //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
	       // Sysm0250BM          user             = serviceParameters.getUser();
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
	        payr0301SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	        payr0301SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	        
	        payr0301SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	        
	        payr0301SrhVO.setUsrId(sessionUser.getUsrId());  
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {

                	payr0301SrhVO.setDeptCd(sessionUser.getDeptCd()); 
                   listDeptCd.add(sessionUser.getDeptCd());
                   payr0301SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                    
           	 } else {
           		payr0301SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                payr0301SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                    
           	 }  
            	 
               payr0301SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	payr0301SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드 
                     if (payr0301SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	payr0301SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	payr0301SrhVO.setDeptCd("");  //부서코드
                     } else if ("ALL".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
                    	 listDeptCd = null; 
                    	 payr0301SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                    	 payr0301SrhVO.setDeptCd("");  //부서코드 
                     } else {
                    	 payr0301SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          payr0301SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
           
            payr0301SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            payr0301SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));    
           /******************************** 권한 ************************************************************************/
	        
//	        if (MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")).equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
//                payr0301SrhVO.setDeptCd("");     //부서코드
//            } else if ("ALL".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
//                payr0301SrhVO.setDeptCd("");     //부서코드
//            } else {
//                payr0301SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//            }     
	        
	        payr0301SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	        payr0301SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  //급여구분코드 
	        payr0301SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth")).replace(".", "")); //지급년 
	        payr0301SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	        payr0301SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
	        payr0301SrhVO.setPayPymtDt(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payPymtDt")));  //지급일자 
	        payr0301SrhVO.setPayrSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "payrSeilNum"),"0"))); //급여일련번호 
	        //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
	            //Execute query that returns a single value
	            TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	             
	            int iResultCnt = payr0301DAO.selectPayr0301ToPayr4250ListTotCnt(payr0301SrhVO);  
	          
	            SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	            if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
	            pagingValues.totalRecordCount = iResultCnt;	       
	            
	            logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	        }
	    
	        TimingInfo millisBeginPayr0301ToPayr4250DataList = SmrmfUtils.startTiming(logger);
	    
	        /**페이지 카운트 처리를 위한 부분 */ 
	        payr0301SrhVO.setPageSize(pagingValues.totalRecordCount);  
	        
	        //Apply paging
	        if (pagingValues.start > 0) {
	        	payr0301SrhVO.setFirstIndex(pagingValues.start);
	        }
	        if (pagingValues.offsetLimit > 0) {
	        	payr0301SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	        }
	
	        //Execute query and convert to BaseModel list
	        TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	        
	        @SuppressWarnings("unchecked")
	//        Collection<Map<String, Object>> list ??????
	        List list = payr0301DAO.selectPayr0301ToPayr4250List(payr0301SrhVO);
	        
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
	        SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	       
	    
	        while ( iter.hasNext() ) {
	        	
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

                          }
                  			
                  	map.put(tableAttributes[i].getName(), strValue);
                  		                    
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
	        
	        SmrmfUtils.endTiming(logger, millisBeginPayr0301ToPayr4250DataList, "getPayr0301ToPayr4250DataList");
	   
	
	    }
	    catch (Exception ex) {
	    	ex.printStackTrace();
	        //Return operation exception
	        throw MSFServerUtils.getOperationException(method, ex, logger);
	    }
	
	    return retval;
	}
 

    @Override
    public Long activityOnPayr4250(List<Payr0301DTO> listPayr0301dto, ActionDatabase actionDatabase)  throws MSFException {
        // TODO Auto-generated method stub
        Long result = new Long(0);
        Long iCnt = new Long(0);
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        try { 
        	
        	payr0301DAO = (Payr0301DAO)BeanFinder.getBean("Payr0301DAO");
        	payr0250DAO = (Payr0250DAO)BeanFinder.getBean("Payr0250DAO");
        	dlgn0100Dao = (InfcPkgDlgn0100DAO)BeanFinder.getBean("InfcPkgDlgn0100DAO");
        	dlgn0200Dao = (InfcPkgDlgn0200DAO)BeanFinder.getBean("InfcPkgDlgn0200DAO");
            
            
            
              for(int iPayrCnt=0;iPayrCnt < listPayr0301dto.size();iPayrCnt++) {
              
                 
                   Payr0301VO  payr0301Vo = new Payr0301VO();
                   Payr0250VO  payr0250Vo = new Payr0250VO();
                   
                   InfcPkgDlgn0100VO  dlgn0100Vo = new InfcPkgDlgn0100VO();
                   InfcPkgDlgn0200VO  dlgn0200Vo = new InfcPkgDlgn0200VO();
                   
                   Payr0301DTO payr0301Dto = new Payr0301DTO();  
                   payr0301Dto = listPayr0301dto.get(iPayrCnt); 

                    
                   payr0301Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0301Dto.getDpobCd()));    				/** column 사업장코드 : dpobCd */
                   payr0301Vo.setPymtYrMnth(MSFSharedUtils.allowNulls(payr0301Dto.getPymtYrMnth()));    		/** column 지급년월 : pymtYrMnth */
                   payr0301Vo.setSystemkey(MSFSharedUtils.allowNulls(payr0301Dto.getSystemkey()));    			/** column SYSTEMKEY : systemkey */
                   payr0301Vo.setPayCd(MSFSharedUtils.allowNulls(payr0301Dto.getPayCd()));    					/** column 급여구분코드 : payCd */
                   payr0301Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(payr0301Dto.getPayrMangDeptCd()));    /** column 급여관리부서코드 : payrMangDeptCd */
                   payr0301Vo.setPayrSeilNum(new BigDecimal(payr0301Dto.getPayrSeilNum()));    					/** column 급여일련번호 : payrSeilNum */
                   payr0301Vo.setKybdr(sessionUser.getUsrId());    												/** column 입력자 : kybdr */
                   payr0301Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 입력주소 : inptAddr */
                   payr0301Vo.setIsmt(sessionUser.getUsrId());    												/** column 수정자 : ismt */
                   payr0301Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */

                    payr0250Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0301Dto.getDpobCd()));    				/** column 사업장코드 : dpobCd */
                    payr0250Vo.setJobYrMnth(MSFSharedUtils.allowNulls(payr0301Dto.getPymtYrMnth()));    		/** column 작업년월 : jobYrMnth */
                    payr0250Vo.setPayCd(MSFSharedUtils.allowNulls(payr0301Dto.getPayCd()));    					/** column 급여구분코드 : payCd */
                    payr0250Vo.setPayScduSeilNum(new BigDecimal(payr0301Dto.getPayrSeilNum()));    				/** column 급여스케줄일련번호 : payScduSeilNum */
                    payr0250Vo.setKybdr(sessionUser.getUsrId());    											/** column 입력자 : kybdr */
                    payr0250Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 입력주소 : inptAddr */
                    payr0250Vo.setIsmt(sessionUser.getUsrId());    												/** column 수정자 : ismt */
                    payr0250Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */

                     
                    dlgn0100Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0301Dto.getDpobCd()));    				/** column 사업장코드 : dpobCd */
                    dlgn0100Vo.setSystemkey(MSFSharedUtils.allowNulls(payr0301Dto.getSystemkey()));    			/** column SYSTEMKEY : systemkey */
                    dlgn0100Vo.setDilnlazYrMnth(MSFSharedUtils.allowNulls(payr0301Dto.getPymtYrMnth()));    	/** column 근태년월 : dilnlazYrMnth */
                    dlgn0100Vo.setPayCd(MSFSharedUtils.allowNulls(payr0301Dto.getPayCd()));    					/** column 급여구분코드 : payCd */
                    dlgn0100Vo.setKybdr(sessionUser.getUsrId());    											/** column 입력자 : kybdr */
                    dlgn0100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 입력주소 : inptAddr */
                    dlgn0100Vo.setIsmt(sessionUser.getUsrId());    												/** column 수정자 : ismt */
                    dlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */

                    dlgn0200Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0301Dto.getDpobCd()));    				/** column 사업장코드 : dpobCd */
                    dlgn0200Vo.setSystemkey(MSFSharedUtils.allowNulls(payr0301Dto.getSystemkey()));    			/** column SYSTEMKEY : systemkey */
                    dlgn0200Vo.setDilnlazExceDutyYrMnth(MSFSharedUtils.allowNulls(payr0301Dto.getPymtYrMnth()));/** column 근태초과근무년월 : dilnlazExceDutyYrMnth */
                    dlgn0200Vo.setPayCd(MSFSharedUtils.allowNulls(payr0301Dto.getPayCd()));    					/** column 급여구분코드 : payCd */
                    dlgn0200Vo.setKybdr(sessionUser.getUsrId());    											/** column 입력자 : kybdr */
                    dlgn0200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 입력주소 : inptAddr */
                    dlgn0200Vo.setIsmt(sessionUser.getUsrId());    												/** column 수정자 : ismt */
                    dlgn0200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    		/** column 수정주소 : revnAddr */

                      
                   switch (actionDatabase) { 
                   case INSERT:
                       //  new SimpleDateFormat("yyyyMMdd").format(new Date())
                       payr0301Vo.setPayDdlneDt(payr0301Dto.getPayDdlneDt());	/** column 급여마감일자 : payDdlneDt */
                       payr0301Vo.setPayDdlneYn("Y");    						/** column 급여마감여부 : payDdlneYn */ 
                       payr0301DAO.updatePayr0301PayDdlene(payr0301Vo);
                       
                       payr0250Vo.setPayDdlneDt(payr0301Dto.getPayDdlneDt());	/** column 급여마감일자 : payDdlneDt */
                       payr0250DAO.updatePayr0250PayDdlene(payr0250Vo);
                       
                       dlgn0100Vo.setDilnlazDdlnePrcsYn("Y");    				/** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */ 
                       dlgn0100Dao.updateDlgn0100PayDdlene(dlgn0100Vo);
                       
                       dlgn0200Vo.setDilnlazDdlnePrcsYn("Y");    				/** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */ 
                       dlgn0200Dao.updateDlgn0200PayDdlene(dlgn0200Vo);
                      break;
                   case UPDATE: 
                      // payr0301DAO.updatePayr0301(payr0301Vo);
                       break;
                   case DELETE:
                       payr0301Vo.setPayDdlneDt("");    						/** column 급여마감일자 : payDdlneDt */
                       payr0301Vo.setPayDdlneYn("N");    						/** column 급여마감여부 : payDdlneYn */
                       payr0301DAO.updatePayr0301PayDdlene(payr0301Vo);
                       payr0250Vo.setPayDdlneDt("");    						/** column 급여마감일자 : payDdlneDt */
                       payr0250DAO.updatePayr0250PayDdlene(payr0250Vo);
                       dlgn0100Vo.setDilnlazDdlnePrcsYn("N");    				/** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */ 
                       dlgn0100Dao.updateDlgn0100PayDdlene(dlgn0100Vo);
                       dlgn0200Vo.setDilnlazDdlnePrcsYn("N");    				/** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */ 
                       dlgn0200Dao.updateDlgn0200PayDdlene(dlgn0200Vo);
                       break;
                   }
                   iCnt = iCnt + 1; 
                    
               } 
                result = iCnt;
          
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr4250(): "+ex); 
            
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnPayr4250", ex, logger);
        }
        finally {
          
        }
        
        return result;
    }
 
}
