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
import com.app.exterms.payroll.client.dto.Payr0520DTO;
import com.app.exterms.payroll.client.service.Payr3200Service;
import com.app.exterms.payroll.server.service.dao.Payr0520DAO;
import com.app.exterms.payroll.server.vo.Payr0520SrhVO;
import com.app.exterms.payroll.server.vo.Payr0520VO;
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
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
@Service("Payr3200Service")
public class Payr3200ServiceImpl extends AbstractCustomServiceImpl implements Payr3200Service, PayrDaoConstants { 

	private static final Logger logger = LoggerFactory.getLogger(Payr3200ServiceImpl.class);
	private static final String calledClass = Payr3200ServiceImpl.class.getName();
	
//	@Autowired
//	@Resource(name="Payr0200DAO")
//    private Payr0200DAO payr0200DAO;
	
	@Autowired
    @Resource(name="Payr0520DAO")
    private Payr0520DAO payr0520DAO;
    
    
    /** ID Generation */
    //@Resource(name="{egovPayr0200IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;


    
    /** 공제 리스트 **/
   public PagingLoadResult<BaseModel> getPayr0520ToPayr3200DducdivcdDataList(ServiceParameters serviceParameters) throws MSFException {

     PagingLoadResult<BaseModel> retval = null;
     String method =  CLASS_PAYR0520_PAYR03200_DDUCDIVCD_LIST;
     Payr0520SrhVO   payr0520SrhVO = new Payr0520SrhVO();
     Payr0520VO      payr0520VO = new Payr0520VO();
     List<BaseModel>  bmResult = new ArrayList<BaseModel>();
     
     MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
     
 		// 1. 암호화 객체 생성
// 		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
     
     payr0520DAO = (Payr0520DAO)BeanFinder.getBean("Payr0520DAO");
     
     try {
         //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
        // Sysm0520BM          user             = serviceParameters.getUser();
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
         payr0520SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드 
         payr0520SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
         payr0520SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr"))) ;   //기준년도 
         payr0520SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd"))) ;   //단위기관코드
        
         payr0520SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
         
         payr0520SrhVO.setUsrId(sessionUser.getUsrId());  
         
         payr0520SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"mangeDeptCd")));    //관리부서 
         /******************************** 권한 ************************************************************************/
         payr0520SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
         payr0520SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
         
         String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
         if ("FALSE".equals(chkDeptCd)) {
        	 if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
            	 

            	 payr0520SrhVO.setDeptCd(sessionUser.getDeptCd()); 
                listDeptCd.add(sessionUser.getDeptCd());
                payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
                
        	 } else {
        		 
        		 payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                 listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                 payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
        	 } 
        	 
            payr0520SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
         } else {
         	    
        	 payr0520SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
                  if (payr0520SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                  	 listDeptCd = null; 
                  	payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                  	payr0520SrhVO.setDeptCd("");  //부서코드
                  } else {
                	  payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                       listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                       payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                  } 
               
         }
         
//         String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//         if ("FALSE".equals(chkTypOccuCd)) {
//         	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//         	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//         } else {
//         	
//         }
        
         
        /******************************** 권한 ************************************************************************/
//         List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//         payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//         payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
//         
         //payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
         
         
         List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
         payr0520SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
         payr0520SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
        
         List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
         payr0520SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
         payr0520SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
          
         List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
         payr0520SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
         payr0520SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
          
         
         payr0520SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
         payr0520SrhVO.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도 
      
         payr0520SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
         payr0520SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
         payr0520SrhVO.setDataStatus(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dataStatus")));    //제외여부 
         payr0520SrhVO.setPayItemCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payItemCd")));    //공제
         payr0520SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd"))) ;   //지급공제구분코드  
         payr0520SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")) ); //고용구분
         payr0520SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")) ); //호봉제구분
         
         
         
         //Get total record count //전체 데이터 갯수를 가지고 온다. 
          if ( pagingValues.executeRecordCount ) { 
                 
             //Execute query that returns a single value
             TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
              
             int iResultCnt = payr0520DAO.selectPayr0520ToPayr3200DducdivcdListTotCnt(payr0520SrhVO);  
           
             SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
             pagingValues.totalRecordCount = iResultCnt;        
             
             logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         }
     
         TimingInfo millisBeginPayr0520DataList = SmrmfUtils.startTiming(logger);
     
         /**페이지 카운트 처리를 위한 부분 */ 
         payr0520SrhVO.setPageSize(pagingValues.totalRecordCount);  
         
         //Apply paging
         if (pagingValues.start > 0) {
             payr0520SrhVO.setFirstIndex(pagingValues.start);
         }
         if (pagingValues.offsetLimit > 0) {
             payr0520SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
         }

         //Execute query and convert to BaseModel list
         TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
         
         @SuppressWarnings("unchecked")
//       Collection<Map<String, Object>> list ??????
         List list = payr0520DAO.selectPayr0520ToPayr3200DducdivcdList(payr0520SrhVO);
         
         Iterator<Map<String, Object>> iter = list.iterator();
             
         SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
        
     
         while ( iter.hasNext() ) {
        	 
        	// 1. 암호화 객체 생성
         	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
         	
             Map<String, Object> map = (Map<String, Object>) iter.next();
             String idValue = map.get("payItemCd").toString();
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
                 			
              		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
              	          			
              			String rrnDecCrypt = "";
              	          			
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
         
         SmrmfUtils.endTiming(logger, millisBeginPayr0520DataList, CLASS_PAYR0520_PAYR03200_DDUCDIVCD_LIST);
    

     }
     catch (Exception ex) {
         ex.printStackTrace();
         //Return operation exception
         throw MSFServerUtils.getOperationException(method, ex, logger);
     }

     return retval;
 }
   
 /** 개별 공제 대상자 리스트 **/
 public PagingLoadResult<BaseModel> getPayr0520ToPayr3200DataList(ServiceParameters serviceParameters) throws MSFException {

     PagingLoadResult<BaseModel> retval = null;
     String method =  CLASS_PAYR0520_PAYR03200_DATA_LIST;
     Payr0520SrhVO   payr0520SrhVO = new Payr0520SrhVO();
     Payr0520VO      payr0520VO = new Payr0520VO();
     List<BaseModel>  bmResult = new ArrayList<BaseModel>();
     

 	// 1. 암호화 객체 생성
// 	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
     
     MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
     
     payr0520DAO = (Payr0520DAO)BeanFinder.getBean("Payr0520DAO");
      
      try {
          //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
         // Sysm0200BM          user             = serviceParameters.getUser();
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
        
          payr0520SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
          payr0520SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
          payr0520SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr"))) ;   //기준년도 
        
          payr0520SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd"))) ;   //단위기관코드
          payr0520SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
          
          payr0520SrhVO.setUsrId(sessionUser.getUsrId());  
          /******************************** 권한 ************************************************************************/
          String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
          if ("FALSE".equals(chkDeptCd)) {
        	  
        	  if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
             	 

            	  payr0520SrhVO.setDeptCd(sessionUser.getDeptCd()); 
                 listDeptCd.add(sessionUser.getDeptCd());
                 payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
         	 } else {
         		payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                  
         	 }  
        	   
             payr0520SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
          } else {
          	    
        	  payr0520SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
                   if (payr0520SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                   	 listDeptCd = null; 
                   	payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                   	payr0520SrhVO.setDeptCd("");  //부서코드
                   } else {
                	   payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                        listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                        payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                   } 
                
          }
       
          payr0520SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
          payr0520SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
          
         /******************************** 권한 ************************************************************************/
         
//          List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//          payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//          payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
          
          //payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
          
          
          List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
          payr0520SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
          payr0520SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
         
          List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
          payr0520SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
          payr0520SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
           
          List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
          payr0520SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
          payr0520SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
          
         // payr0520SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
        //  payr0520SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
        //  payr0520SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));  //직종세
          
          //payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
          payr0520SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
          payr0520SrhVO.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도 
        
          payr0520SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
          payr0520SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
          payr0520SrhVO.setDataStatus(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dataStatus")));    //제외여부 
          payr0520SrhVO.setPayItemCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payItemCd")));    //공제
          payr0520SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd"))) ;   //지급공제구분코드  
          payr0520SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")) ); //고용구분
         
          
//          System.out.println("dataStatus>>> "+payr0520SrhVO.getDataStatus());
          
          
          //Get total record count //전체 데이터 갯수를 가지고 온다. 
         if ( pagingValues.executeRecordCount ) { 
                
              //Execute query that returns a single value
              TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
               
              int iResultCnt = payr0520DAO.selectPayr0520ToPayr3200ListTotCnt(payr0520SrhVO);  
            
              SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
              
              if (!pagingValues.pageExecute) { 
                  pagingValues.offsetLimit = iResultCnt;       
              }
              
              pagingValues.totalRecordCount = iResultCnt;          
              
              logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
          }
      
          TimingInfo millisBeginPayr0200DataList = SmrmfUtils.startTiming(logger);
      
          /**페이지 카운트 처리를 위한 부분 */ 
          payr0520SrhVO.setPageSize(pagingValues.totalRecordCount);  
          
          //Apply paging
          if (pagingValues.start > 0) {
              payr0520SrhVO.setFirstIndex(pagingValues.start);
          }
          if (pagingValues.offsetLimit > 0) {
              payr0520SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
          }

          //Execute query and convert to BaseModel list
          TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
          
          @SuppressWarnings("unchecked")
//          Collection<Map<String, Object>> list ??????
          List list = payr0520DAO.selectPayr0520ToPayr3200List(payr0520SrhVO);
          
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
                   			
                		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
                	          			
                			String rrnDecCrypt = "";
                	          			
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
              
//                  switch ( tableAttributes[i].getType() ) {  
//                  case ColumnDef.TYPE_BIGDECIMAL: 
//                      if (baseModelValue == null) {
//                          baseModelValue = BigDecimal.ZERO;
//                      }
//                      break; 
//                  }
                  
                  bm.set(tableAttributes[i].getName(), baseModelValue);
              }

              bm.set(TableDef.ID_PROPERTY_NAME, idValue);
              bmResult.add(bm);
          } 

          retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
          
          SmrmfUtils.endTiming(logger, millisBeginPayr0200DataList, "getPayr0520ToPayr3200DataList");
     

      }
      catch (Exception ex) {
        ex.printStackTrace();
          //Return operation exception
          throw MSFServerUtils.getOperationException(method, ex, logger);
      }

      return retval;
  }

@Override
public Long activityOnPayr3200(List<Payr0520DTO> listPayr0520dto, ActionDatabase actionDatabase)  throws MSFException  { 
    Long result = new Long(0);
    Long iCnt = new Long(0);
    try { 
         
    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    	
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
    	payr0520DAO = (Payr0520DAO)BeanFinder.getBean("Payr0520DAO");
      
        int iSelectCnt = 0; 
        
        for(int iPayrCnt=0;iPayrCnt < listPayr0520dto.size();iPayrCnt++) {
        	
        	// 1. 암호화 객체 생성
        	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        	
            
               Payr0520DTO payr0520Dto = new Payr0520DTO();  
               payr0520Dto = listPayr0520dto.get(iPayrCnt);
             
               Payr0520VO payr0520Vo = new Payr0520VO();  
               
               		payr0520Vo.setDpobCd(sessionUser.getDpobCd());    																			/** column 사업장코드 : dpobCd */
//                    payr0520Vo.setDpobCd(payr0520Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
                    payr0520Vo.setSystemkey(payr0520Dto.getSystemkey());    																	/** column SYSTEMKEY : systemkey */
                    payr0520Vo.setPayItemCd(payr0520Dto.getPayItemCd());    																	/** column 급여항목코드 : payItemCd */
                    payr0520Vo.setPymtDducItemSilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0520Dto.getPymtDducItemSilNum(), "0") )); 	/** column 개별지급공제항목일련번호 : pymtDducItemSilNum */
                    payr0520Vo.setPymtDducDivCd(payr0520Dto.getPymtDducDivCd());    															/** column 지급공제구분코드 : pymtDducDivCd */
                    payr0520Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0520Dto.getPymtDducSum(), "0")));    				/** column 지급공제금액 : pymtDducSum */
                    payr0520Vo.setPymtDducRate(new BigDecimal(MSFSharedUtils.defaultNulls(payr0520Dto.getPymtDducRate(), "0")));   				/** column 지급공제율 : pymtDducRate */
                    payr0520Vo.setPymtDducFreeDtySum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0520Dto.getPymtDducFreeDtySum(), "0")));	/** column 지급공제비과세금액 : pymtDducFreeDtySum */
                    payr0520Vo.setPymtDducItemCretnDivCd(payr0520Dto.getPymtDducItemCretnDivCd());    											/** column 지급공제항목생성구분코드 : pymtDducItemCretnDivCd */
                    payr0520Vo.setPymtDducItemBgnnDt(payr0520Dto.getPymtDducItemBgnnDt());   													/** column 지급공제항목시작일자 : pymtDducItemBgnnDt */
                    payr0520Vo.setPymtDducItemEndDt(payr0520Dto.getPymtDducItemEndDt());    													/** column 지급공제항목종료일자 : pymtDducItemEndDt */
                    payr0520Vo.setPymtDducItemDelYn((Boolean.TRUE.equals(payr0520Dto.getPymtDducItemDelYn()) ? "Y" : "N") );					/** column 지급공제항목삭제여부 : pymtDducItemDelYn */
                    payr0520Vo.setPymtDducItemNoteCtnt(payr0520Dto.getPymtDducItemNoteCtnt());   	 											/** column 지급공제항목비고내용 : pymtDducItemNoteCtnt */
                    payr0520Vo.setKybdr(sessionUser.getUsrId());    																			/** column 입력자 : kybdr */
//                    payr0520Vo.setInptDt(payr0520Dto.getInptDt());    /** column 입력일자 : inptDt */
                    payr0520Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    										/** column 입력주소 : inptAddr */
                    payr0520Vo.setIsmt(sessionUser.getUsrId());    																				/** column 수정자 : ismt */
//                    payr0520Vo.setRevnDt(payr0520Dto.getRevnDt());    /** column 수정일자 : revnDt */
                    payr0520Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    										/** column 수정주소 : revnAddr */
                    
               switch (actionDatabase) {
               case INSERT:
            	   iSelectCnt = payr0520DAO.selectPayr0520CehckCnt(payr0520Vo);
            	   
            	   if(iSelectCnt < 1) {
            		   payr0520DAO.insertPayr0520(payr0520Vo); 
            	   }
            	   break;
            	   
               case UPDATE:
            	   payr0520Vo.setCheckIU("update");
            	   iSelectCnt = payr0520DAO.selectPayr0520CehckCnt(payr0520Vo);
            	   
            	   if(iSelectCnt < 1) {
            		   payr0520DAO.updatePayr0520(payr0520Vo); 
            	   }
            	   break;
            	   
               case DELETE: 
                   payr0520DAO.deletePayr0520(payr0520Vo); 
                   break;
               } 
               
               if (iSelectCnt < 1) { // 중복 건수 없이 실행 
            	   iCnt = iCnt + 1;
               }
           } 
            result = iCnt;
      
    }
    catch (Exception ex) {
        logger.error("EXCEPTION calling activityOnPayr3200(): "+ex); 
        
        result = new Long(0);
        throw MSFServerUtils.getOperationException("activityOnPayr3200", ex, logger);
    }
    finally {
      
    }
    
    return result;
}

   
		
/** 개별 수당 리스트  **/
public PagingLoadResult<BaseModel> getPayr0520ToPayr5400DataList(ServiceParameters serviceParameters) throws MSFException {

    PagingLoadResult<BaseModel> retval = null;
    String method =  CLASS_PAYR0520_PAYR05400_DATA_LIST;
    Payr0520SrhVO   payr0520SrhVO = new Payr0520SrhVO();
    Payr0520VO      payr0520VO = new Payr0520VO();
    List<BaseModel>  bmResult = new ArrayList<BaseModel>();
    
    MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    
	// 1. 암호화 객체 생성
//	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    
    payr0520DAO = (Payr0520DAO)BeanFinder.getBean("Payr0520DAO");
    
     try {
         //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
        // Sysm0200BM          user             = serviceParameters.getUser();
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
       
         payr0520SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
         payr0520SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
         payr0520SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr"))) ;   //기준년도 
       
         payr0520SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd"))) ;   //단위기관코드
         payr0520SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
         
         
         payr0520SrhVO.setUsrId(sessionUser.getUsrId());  
         /******************************** 권한 ************************************************************************/
         String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
         if ("FALSE".equals(chkDeptCd)) {
        	 
        	 if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
            	 

              	  payr0520SrhVO.setDeptCd(sessionUser.getDeptCd()); 
                   listDeptCd.add(sessionUser.getDeptCd());
                   payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                   
        	 } else {
        		 payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                 listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                 payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                 
        	 }  
        	  
            payr0520SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
         } else {
         	    
       	  payr0520SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
                  if (payr0520SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                  	 listDeptCd = null; 
                  	payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                  	payr0520SrhVO.setDeptCd("");  //부서코드
                  } else {
               	   payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                       listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                       payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                  } 
               
         }
      
         payr0520SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
         payr0520SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
         
        /******************************** 권한 ************************************************************************/
        
//         List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//         payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//         payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
         
         //payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
         
         
         List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
         payr0520SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
         payr0520SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
        
         List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
         payr0520SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
         payr0520SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
          
         List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
         payr0520SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
         payr0520SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
         
        // payr0520SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
       //  payr0520SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
       //  payr0520SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")));  //직종세
         
         //payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
         payr0520SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
         payr0520SrhVO.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도 
       
         payr0520SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
         payr0520SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
         payr0520SrhVO.setDataStatus(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dataStatus")));    //제외여부 
         payr0520SrhVO.setPayItemCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payItemCd")));    //공제
         payr0520SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd"))) ;   //지급공제구분코드  
         payr0520SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")) ); //고용구분
        
         //Get total record count //전체 데이터 갯수를 가지고 온다. 
        if ( pagingValues.executeRecordCount ) { 
               
             //Execute query that returns a single value
             TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
              
             int iResultCnt = payr0520DAO.selectPayr0520ToPayr5400ListTotCnt(payr0520SrhVO);  
           
             SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
             
             if (!pagingValues.pageExecute) { 
                 pagingValues.offsetLimit = iResultCnt;       
             }
             
             pagingValues.totalRecordCount = iResultCnt;          
             
             logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
         }
     
         TimingInfo millisBeginPayr0200DataList = SmrmfUtils.startTiming(logger);
     
         /**페이지 카운트 처리를 위한 부분 */ 
         payr0520SrhVO.setPageSize(pagingValues.totalRecordCount);  
         
         //Apply paging
         if (pagingValues.start > 0) {
             payr0520SrhVO.setFirstIndex(pagingValues.start);
         }
         if (pagingValues.offsetLimit > 0) {
             payr0520SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
         }

         //Execute query and convert to BaseModel list
         TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
         
         @SuppressWarnings("unchecked")
//         Collection<Map<String, Object>> list ??????
         List list = payr0520DAO.selectPayr0520ToPayr5400List(payr0520SrhVO);
         
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
                      
                    case ColumnDef.TYPE_LONG:   
                    
                   if (mapCon != null) {  
                       Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
                       map.put(tableAttributes[i].getName(), lValue); 
                   }  
                      
                    break;
                    
                	//3. 복호화
                	case ColumnDef.TYPE_STRING: 
                	          			          			
                		String strValue = MSFSharedUtils.allowNulls(String.valueOf(mapCon));
                   			
                		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
                	          			
                			String rrnDecCrypt = "";
                	          			
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
             
//                 switch ( tableAttributes[i].getType() ) {  
//                 case ColumnDef.TYPE_BIGDECIMAL: 
//                     if (baseModelValue == null) {
//                         baseModelValue = BigDecimal.ZERO;
//                     }
//                     break; 
//                 }
                 
                 bm.set(tableAttributes[i].getName(), baseModelValue);
             }

             bm.set(TableDef.ID_PROPERTY_NAME, idValue);
             bmResult.add(bm);
         } 

         retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
         
         SmrmfUtils.endTiming(logger, millisBeginPayr0200DataList, "getPayr0520ToPayr3200DataList");
    

     }
     catch (Exception ex) {
       ex.printStackTrace();
         //Return operation exception
         throw MSFServerUtils.getOperationException(method, ex, logger);
     }

     return retval;
 }

/** 수당 리스트 **/
public PagingLoadResult<BaseModel> getPayr0520ToPayr5400ExtpyCdDataList(ServiceParameters serviceParameters) throws MSFException {

  PagingLoadResult<BaseModel> retval = null;
  String method =  CLASS_PAYR0520_PAYR05400_EXTPYCD_LIST;
  Payr0520SrhVO   payr0520SrhVO = new Payr0520SrhVO();
  Payr0520VO      payr0520VO = new Payr0520VO();
  List<BaseModel>  bmResult = new ArrayList<BaseModel>();
  
	// 1. 암호화 객체 생성
//	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
  
  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
  payr0520DAO = (Payr0520DAO)BeanFinder.getBean("Payr0520DAO");
  
  try {
      //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
     // Sysm0520BM          user             = serviceParameters.getUser();
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
      payr0520SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드 
      payr0520SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
      payr0520SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr"))) ;   //기준년도 
      payr0520SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd"))) ;   //단위기관코드
     
      payr0520SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
      
      payr0520SrhVO.setUsrId(sessionUser.getUsrId());  
      
      payr0520SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"mangeDeptCd")));    //관리부서 
      /******************************** 권한 ************************************************************************/
      payr0520SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
      payr0520SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
      
      String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
      if ("FALSE".equals(chkDeptCd)) {
    	  
    	  if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {

    	     	 payr0520SrhVO.setDeptCd(sessionUser.getDeptCd()); 
    	         listDeptCd.add(sessionUser.getDeptCd());
    	         payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
              
     	 } else {
     		 
     		payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
            listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
            payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
              
     	 }  
    	  
         payr0520SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
      } else {
      	    
     	 payr0520SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
               if (payr0520SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
               	 listDeptCd = null; 
               	payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
               	payr0520SrhVO.setDeptCd("");  //부서코드
               } else {
             	  payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                    listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                    payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
               } 
            
      }
      
//      String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//      if ("FALSE".equals(chkTypOccuCd)) {
//      	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//      	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//      } else {
//      	
//      }
     
      
     /******************************** 권한 ************************************************************************/
//      List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//      payr0520SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//      payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
//      
      //payr0520SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
      
      
      List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
      payr0520SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
      payr0520SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
     
      List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
      payr0520SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
      payr0520SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
       
      List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
      payr0520SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
      payr0520SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
       
      
      payr0520SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
      payr0520SrhVO.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도 
   
      payr0520SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
      payr0520SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
      payr0520SrhVO.setDataStatus(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dataStatus")));    //제외여부 
      payr0520SrhVO.setPayItemCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payItemCd")));    //공제
      payr0520SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd"))) ;   //지급공제구분코드  
      payr0520SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")) ); //고용구분
      
      payr0520SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")) ); //호봉제구분
      
      
      //Get total record count //전체 데이터 갯수를 가지고 온다. 
       if ( pagingValues.executeRecordCount ) { 
              
          //Execute query that returns a single value
          TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
           
          int iResultCnt = payr0520DAO.selectPayr0520ToPayr5400ExtpyCdListTotCnt(payr0520SrhVO);  
        
          SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
          pagingValues.totalRecordCount = iResultCnt;        
          
          logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
      }
  
      TimingInfo millisBeginPayr0520DataList = SmrmfUtils.startTiming(logger);
  
      /**페이지 카운트 처리를 위한 부분 */ 
      payr0520SrhVO.setPageSize(pagingValues.totalRecordCount);  
      
      //Apply paging
      if (pagingValues.start > 0) {
          payr0520SrhVO.setFirstIndex(pagingValues.start);
      }
      if (pagingValues.offsetLimit > 0) {
          payr0520SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
      }

      //Execute query and convert to BaseModel list
      TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
      
      @SuppressWarnings("unchecked")
//    Collection<Map<String, Object>> list ??????
      List list = payr0520DAO.selectPayr0520ToPayr5400ExtpyCdList(payr0520SrhVO);
      
      Iterator<Map<String, Object>> iter = list.iterator();
          
      SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
     
  
      while ( iter.hasNext() ) {
    	  
    	// 1. 암호화 객체 생성
      	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
      	
          Map<String, Object> map = (Map<String, Object>) iter.next();
          String idValue = map.get("payItemCd").toString();
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
              			
           		if(	"resnRegnNum".equals(tableAttributes[i].getName())) {
           	          			
           			String rrnDecCrypt = "";
           	          			
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
      
      SmrmfUtils.endTiming(logger, millisBeginPayr0520DataList, CLASS_PAYR0520_PAYR03200_DDUCDIVCD_LIST);
 

  }
  catch (Exception ex) {
      ex.printStackTrace();
      //Return operation exception
      throw MSFServerUtils.getOperationException(method, ex, logger);
  }

  return retval;
}
	 
}
