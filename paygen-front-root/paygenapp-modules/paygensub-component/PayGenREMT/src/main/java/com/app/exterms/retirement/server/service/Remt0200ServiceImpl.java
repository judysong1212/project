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
package com.app.exterms.retirement.server.service;

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

import com.app.exterms.retirement.client.dto.Remt3000DTO;
import com.app.exterms.retirement.client.dto.Remt3100DTO;
import com.app.exterms.retirement.client.dto.Remt3200DTO;
import com.app.exterms.retirement.client.service.Remt0200Service;
import com.app.exterms.retirement.server.service.dao.Remt3000DAO;
import com.app.exterms.retirement.server.service.dao.Remt3100DAO;
import com.app.exterms.retirement.server.service.dao.Remt3200DAO;
import com.app.exterms.retirement.server.vo.Remt3000SrhVO;
import com.app.exterms.retirement.server.vo.Remt3000VO;
import com.app.exterms.retirement.server.vo.Remt3100SrhVO;
import com.app.exterms.retirement.server.vo.Remt3100VO;
import com.app.exterms.retirement.server.vo.Remt3200SrhVO;
import com.app.exterms.retirement.server.vo.Remt3200VO;
import com.app.exterms.retirement.shared.RemtDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt3000VO;
import com.app.smrmf.pkg.listener.remt.remt2018.RemtListenerAdapter;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Remt0200Service")
public class Remt0200ServiceImpl extends AbstractCustomServiceImpl implements Remt0200Service  ,RemtDaoConstants {

    private static final Logger logger = LoggerFactory.getLogger(Remt0200ServiceImpl.class);
    private static final String calledClass = Remt0200ServiceImpl.class.getName();
    
    @Autowired 
    @Resource(name="Remt3000DAO")
    private Remt3000DAO remt3000DAO;
    
    @Autowired 
    @Resource(name="Remt3100DAO")
    private Remt3100DAO remt3100DAO;
    
    @Autowired 
    @Resource(name="Remt3200DAO")
    private Remt3200DAO remt3200DAO;
    
   
    
    /** ID Generation */
    //@Resource(name="{egovRemt3000IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

    /**
     * 퇴직정산 -대상자리스트 가지고 오기 
     * @param serviceParameters
     * @return
     * @throws MSFException
     */
    public PagingLoadResult<BaseModel> getSelectRemt0200ToRemt3000List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_REMT0200_REMT3000_DATA_LIST;
        Remt3000SrhVO   remt3000SrhVo = new Remt3000SrhVO();
        Remt3000VO      remt3000Vo = new Remt3000VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(remt3000DAO)) {
        
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            remt3000DAO = (Remt3000DAO) wac.getBean("Remt3000DAO" ); 
        }
        
        try {
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
            remt3000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            remt3000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
            remt3000SrhVo.setUsrId(sessionUser.getUsrId());  
            
            
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	remt3000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               remt3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
               remt3000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	 remt3000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
                     if (remt3000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	remt3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                     	remt3000SrhVo.setDeptCd("");  //부서코드
                     } else {
                    	 remt3000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          remt3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
            
            remt3000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            remt3000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
//            String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//            if ("FALSE".equals(chkTypOccuCd)) {
//            	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//            	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//            } else {
//            	
//            }
            
           /******************************** 권한 ************************************************************************/
            
            remt3000SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYrMnth"))); //퇴직정산년월
            remt3000SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnDivCd")));  //퇴직정산구분코드  
            
           
            remt3000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
            
//            if (remt3000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
//            	remt3000SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//            	List<String> listDeptCd = null; 
//            	remt3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//            	remt3000SrhVo.setDeptCd("");     //부서코드
//            } else {
//            	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//            	remt3000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//            	remt3000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//            }   
            
            
            
            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
            remt3000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
            remt3000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
           
//            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//            remt3000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//            remt3000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
             
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            remt3000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            remt3000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세 
            
            remt3000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
            remt3000SrhVo.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
          
            remt3000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            remt3000SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
            
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = remt3000DAO.selectRemt0200ToRemt3000ListTotCnt(remt3000SrhVo);  
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginRemt0200ToRemt3000DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            remt3000SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	remt3000SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	remt3000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list  
            List list = remt3000DAO.selectRemt0200ToRemt3000List(remt3000SrhVo);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginRemt0200ToRemt3000DataList, "getSelectRemt0200ToRemt3000List");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }   

       /**
        * 퇴직정산 결과 조회 
        * @param serviceParameters
        * @return
        * @throws MSFException
        */
  	   public PagingLoadResult<BaseModel> getSelectRemt0200ToRemt3100List(ServiceParameters serviceParameters) throws MSFException {

  	        PagingLoadResult<BaseModel> retval = null;
  	        String method =  CLASS_REMT0200_REMT3100_DATALIST;
  	        Remt3100SrhVO   Remt3100SrhVo = new Remt3100SrhVO();
  	        Remt3100VO      Remt3100Vo = new Remt3100VO();
  	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
  	        
  	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
  	        

  	        // 1. 암호화 객체 생성
  	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
  	        
  	        if  (MSFSharedUtils.paramNull(remt3100DAO)) {
  	        
  	            WebApplicationContext wac = WebApplicationContextUtils.
  	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

  	            remt3100DAO = (Remt3100DAO) wac.getBean("Remt3100DAO" ); 
  	        }
  	        
  	        try {
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
  	           
  	            /** 조건절 */
  	            Remt3100SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드 
  	            Remt3100SrhVo.setSevePayClutMangeNum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "sevePayClutMangeNum")));   /** set 퇴직금정산관리번호 : sevePayClutMangeNum */
  	            Remt3100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키 
  	            Remt3100SrhVo.setCalcSevePayPsnBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnBlggYr")));  /** set 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
  	            Remt3100SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYrMnth")));
  	          
  	            Remt3100SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnDivCd")));  /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
  	             
  	          
  	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
  	             if ( pagingValues.executeRecordCount ) { 
  	                    
  	                //Execute query that returns a single value
  	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
  	               
  	                int iResultCnt = remt3100DAO.selectRemt0200ToRemt3100ListTotCnt(Remt3100SrhVo);  
  	              
  	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
  	                pagingValues.totalRecordCount = iResultCnt;        
  	                
  	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
  	            }
  	        
  	            TimingInfo millisBeginRemt0200ToRemt3100DataList = SmrmfUtils.startTiming(logger);
  	        
  	            /**페이지 카운트 처리를 위한 부분 */ 
  	            Remt3100SrhVo.setPageSize(pagingValues.totalRecordCount);  
  	            
  	            //Apply paging
  	            if (pagingValues.start > 0) {
  	            	Remt3100SrhVo.setFirstIndex(pagingValues.start);
  	            }
  	            if (pagingValues.offsetLimit > 0) {
  	            	Remt3100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
  	            }

  	            //Execute query and convert to BaseModel list
  	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
  	            
  	            @SuppressWarnings("unchecked")
//  	            Collection<Map<String, Object>> list  
  	            List list = remt3100DAO.selectRemt0200ToRemt3100List(Remt3100SrhVo);
  	            
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
  	            
  	            SmrmfUtils.endTiming(logger, millisBeginRemt0200ToRemt3100DataList, "getSelectRemt0200ToRemt3100List");
  	       

  	        }
  	        catch (Exception ex) {
  	            ex.printStackTrace();
  	            //Return operation exception
  	            throw MSFServerUtils.getOperationException(method, ex, logger);
  	        }

  	        return retval;
  	    } 
  	   
  	  
  	 /**
        * 퇴직정산 납부명세 조회 
        * @param serviceParameters
        * @return
        * @throws MSFException
        */
  	   public PagingLoadResult<BaseModel> getSelectRemtPymtSubtn0200ToRemt3100List(ServiceParameters serviceParameters) throws MSFException {

  	        PagingLoadResult<BaseModel> retval = null;
  	        String method =  CLASS_REMTPYMTSUBTN0200_REMT3100_DATALIST;
  	        Remt3100SrhVO   Remt3100SrhVo = new Remt3100SrhVO();
  	        Remt3100VO      Remt3100Vo = new Remt3100VO();
  	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
  	        
  	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
  	        
  	        // 1. 암호화 객체 생성
  	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
  	        
  	        if  (MSFSharedUtils.paramNull(remt3100DAO)) {
  	        
  	            WebApplicationContext wac = WebApplicationContextUtils.
  	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

  	            remt3100DAO = (Remt3100DAO) wac.getBean("Remt3100DAO" ); 
  	        }
  	        
  	        try {
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
  	           
  	            /** 조건절 */
  	            Remt3100SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드 
  	            Remt3100SrhVo.setSevePayClutMangeNum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "sevePayClutMangeNum")));   /** set 퇴직금정산관리번호 : sevePayClutMangeNum */
  	            Remt3100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키 
  	            Remt3100SrhVo.setCalcSevePayPsnBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnBlggYr")));  /** set 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
  	            Remt3100SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYrMnth")));
  	            Remt3100SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnDivCd")));  /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
  	             
  	          
  	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
  	             if ( pagingValues.executeRecordCount ) { 
  	                    
  	                //Execute query that returns a single value
  	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
  	               
  	                int iResultCnt = remt3100DAO.selectRemtPymtSubtn0200ToRemt3100ListTotCnt(Remt3100SrhVo);  
  	              
  	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
  	                pagingValues.totalRecordCount = iResultCnt;        
  	                
  	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
  	            }
  	        
  	            TimingInfo millisBeginRemtPymtSubtn0200ToRemt3100DataList = SmrmfUtils.startTiming(logger);
  	        
  	            /**페이지 카운트 처리를 위한 부분 */ 
  	            Remt3100SrhVo.setPageSize(pagingValues.totalRecordCount);  
  	            
  	            //Apply paging
  	            if (pagingValues.start > 0) {
  	            	Remt3100SrhVo.setFirstIndex(pagingValues.start);
  	            }
  	            if (pagingValues.offsetLimit > 0) {
  	            	Remt3100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
  	            }

  	            //Execute query and convert to BaseModel list
  	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
  	            
  	            @SuppressWarnings("unchecked")
//  	            Collection<Map<String, Object>> list  
  	            List list = remt3100DAO.selectRemtPymtSubtn0200ToRemt3100List(Remt3100SrhVo);
  	            
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
  	            
  	            SmrmfUtils.endTiming(logger, millisBeginRemtPymtSubtn0200ToRemt3100DataList, "getSelectRemtPymtSubtn0200ToRemt3100List");
  	       

  	        }
  	        catch (Exception ex) {
  	            ex.printStackTrace();
  	            //Return operation exception
  	            throw MSFServerUtils.getOperationException(method, ex, logger);
  	        }

  	        return retval;
  	    } 
  	   
  	   
  	 
    
  	 /**
  	     * 퇴직정산 -퇴직연금 등록 / 정보 
  	     * @param serviceParameters
  	     * @return
  	     * @throws MSFException
  	     */
  	    public PagingLoadResult<BaseModel> getSelectRemt0200ToRemt3200List(ServiceParameters serviceParameters) throws MSFException {

  	        PagingLoadResult<BaseModel> retval = null;
  	        String method =  CLASS_REMT0200TOREMT3200_DATA_LIST;
  	        Remt3200SrhVO   remt3200SrhVo = new Remt3200SrhVO();
  	        Remt3200VO      remt3200Vo = new Remt3200VO();
  	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
  	        
  	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
  	        
  	        // 1. 암호화 객체 생성
  	        String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
  	        
  	        if  (MSFSharedUtils.paramNull(remt3200DAO)) {
  	        
  	            WebApplicationContext wac = WebApplicationContextUtils.
  	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

  	            remt3200DAO = (Remt3200DAO) wac.getBean("Remt3200DAO" ); 
  	        }
  	        
  	        try {
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
  	           
  	            /** 조건절 */
  	            remt3200SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드 
  	            remt3200SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키 
  	          
  	            remt3200SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYrMnth")));
  	            remt3200SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnDivCd")));  /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
	             
  	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
  	             if ( pagingValues.executeRecordCount ) { 
  	                    
  	                //Execute query that returns a single value
  	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
  	                 
  	                int iResultCnt = remt3200DAO.selectRemt0200ToRemt3200ListTotCnt(remt3200SrhVo);  
  	              
  	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
  	                pagingValues.totalRecordCount = iResultCnt;        
  	                
  	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
  	            }
  	        
  	            TimingInfo millisBeginRemt0200ToRemt3200DataList = SmrmfUtils.startTiming(logger);
  	        
  	            /**페이지 카운트 처리를 위한 부분 */ 
  	            remt3200SrhVo.setPageSize(pagingValues.totalRecordCount);  
  	            
  	            //Apply paging
  	            if (pagingValues.start > 0) {
  	            	remt3200SrhVo.setFirstIndex(pagingValues.start);
  	            }
  	            if (pagingValues.offsetLimit > 0) {
  	            	remt3200SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
  	            }

  	            //Execute query and convert to BaseModel list
  	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
  	            
  	            @SuppressWarnings("unchecked")
//  		            Collection<Map<String, Object>> list  
  	            List list = remt3200DAO.selectRemt0200ToRemt3200List(remt3200SrhVo);
  	            
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
  	            
  	            SmrmfUtils.endTiming(logger, millisBeginRemt0200ToRemt3200DataList, "getSelectRemt0200ToRemt3200List");
  	       

  	        }
  	        catch (Exception ex) {
  	            ex.printStackTrace();
  	            //Return operation exception
  	            throw MSFServerUtils.getOperationException(method, ex, logger);
  	        }

  	        return retval;
  	    } 
  	    
  	 
	    @Override
	    public Long saveRemt0200ToRemt3200(List<Remt3200DTO> listRemt3200dto , ActionDatabase actionDatabase) throws MSFException  {
	        Long result = new Long(0);
	        Long iCnt = new Long(0);
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	    	// 1. 암호화 객체 생성
//	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        try { 
	             
	           
	            if  (MSFSharedUtils.paramNull(remt3200DAO)) {
	                
	                WebApplicationContext wac = WebApplicationContextUtils.
	                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                remt3200DAO = (Remt3200DAO) wac.getBean("Remt3200DAO" ); 
	            }
	            
	            for(int iPayrCnt=0;iPayrCnt < listRemt3200dto.size();iPayrCnt++) {
	            	 
	                
	                	Remt3200DTO remt3200Dto = new Remt3200DTO();  
	                	Remt3200VO  remt3200Vo = new Remt3200VO();  
	                	remt3200Dto = listRemt3200dto.get(iPayrCnt); 
	   

						remt3200Vo.setAntyAccuSeilNum(new BigDecimal(remt3200Dto.getAntyAccuSeilNum()));    /** column 연금계좌일련번호 : antyAccuSeilNum */
						remt3200Vo.setDpobCd(remt3200Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
						remt3200Vo.setClutYrMnth(remt3200Dto.getClutYrMnth());    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
						remt3200Vo.setCalcSevePayPsnDivCd(remt3200Dto.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						remt3200Vo.setSystemkey(remt3200Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
						remt3200Vo.setAntyAccuBusoprNum(remt3200Dto.getAntyAccuBusoprNum());    /** column 연금계좌_사업자등록번호 : antyAccuBusoprNum */
						remt3200Vo.setAntyAccuBusoprNm(remt3200Dto.getAntyAccuBusoprNm());    /** column 연금계좌_사업자명 : antyAccuBusoprNm */
						remt3200Vo.setAntyAccuAccuNum(remt3200Dto.getAntyAccuAccuNum());    /** column 연금계좌_계좌번호 : antyAccuAccuNum */
						remt3200Vo.setAntyAccuDepitSum(new BigDecimal(remt3200Dto.getAntyAccuDepitSum()));    /** column 연금계좌_입금금액 : antyAccuDepitSum */
						remt3200Vo.setAntyAccuDepitDt(remt3200Dto.getAntyAccuDepitDt());    /** column 연금계좌_입금일자 : antyAccuDepitDt */
						remt3200Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
					//	remt3200Vo.setInptDt(remt3200Dto.getInptDt());    /** column 입력일자 : inptDt */
						remt3200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
						remt3200Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
					//	remt3200Vo.setRevnDt(remt3200Dto.getRevnDt());    /** column 수정일자 : revnDt */
						remt3200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
					 
	                   switch (actionDatabase) { 
	                   case INSERT:
	                	   remt3200DAO.insertRemt3200(remt3200Vo); 
	                       
	                      break;
	                   case UPDATE: 
	                	   remt3200DAO.updateRemt3200(remt3200Vo); 
	                       
	                       break;
	                   case DELETE: 
	                	   remt3200DAO.deleteRemt3200(remt3200Vo); 
	                        
	                       break;
	                   }
	                     
	                   iCnt = iCnt + 1;  
	                   
	                   // 과세이연계좌등록에 따른 메서드 추가  재합계 내서 등록  
	                   Remt3100VO  remt3100Vo = new Remt3100VO();  
	                   remt3100Vo.setDpobCd(remt3200Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
	                   remt3100Vo.setClutYrMnth(remt3200Dto.getClutYrMnth());    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
	                   remt3100Vo.setCalcSevePayPsnDivCd(remt3200Dto.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
	                   remt3100Vo.setSystemkey(remt3200Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
	                   
	                   remt3100DAO.updateRemt0200ToRemt3100Anty(remt3100Vo);
	 
	               } 
	            
	                result = iCnt;
	                 
	        }
	        catch (Exception ex) {
	            
	            result = new Long(0);
	            throw MSFServerUtils.getOperationException("saveRemt0200ToRemt3200", ex, logger);
	        }
	        finally {
	          
	        }
	        
	        return result;
	    }  
	    

	    @Override
	    public Long saveRemt0200ToDDlne(List<Remt3000DTO> listRemt3000dto , ActionDatabase actionDatabase) throws MSFException  {
	        Long result = new Long(0);
	        Long iCnt = new Long(0);
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	    	// 1. 암호화 객체 생성
//	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        try { 
	             
	           
	            if  (MSFSharedUtils.paramNull(remt3000DAO)) {
	                
	                WebApplicationContext wac = WebApplicationContextUtils.
	                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                remt3000DAO = (Remt3000DAO) wac.getBean("Remt3000DAO" ); 
	            }
	            
	            for(int iPayrCnt=0;iPayrCnt < listRemt3000dto.size();iPayrCnt++) {
	            	 
	                
	                	Remt3000DTO remt3000Dto = new Remt3000DTO();  
	                	Remt3000VO  remt3000Vo = new Remt3000VO();  
	                	remt3000Dto = listRemt3000dto.get(iPayrCnt); 
	   

						remt3000Vo.setDpobCd(remt3000Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
						remt3000Vo.setClutYrMnth(remt3000Dto.getClutYrMnth());   /** column 퇴직정산정산년월 : clutYrMnth */
						remt3000Vo.setCalcSevePayPsnDivCd(remt3000Dto.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						remt3000Vo.setSystemkey(remt3000Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
//						remt3000Vo.setSevePayClutMangeNum(remt3000Dto.getSevePayClutMangeNum());    /** column 퇴직정산관리번호 : sevePayClutMangeNum */
//						remt3000Vo.setReipDt(remt3000Dto.getReipDt());    /** column 영수일자 : reipDt */
					//	remt3000Vo.setDdlneYn(Boolean.TRUE.equals(remt3000Dto.getDdlneYn()) ? "Y" : "N");    /** column 마감여부 : ddlneYn */
						remt3000Vo.setDdlneDt(remt3000Dto.getDdlneDt());    /** column 마감일자 : ddlneDt */
//						remt3000Vo.setCalcSevePayPsnSumtDt(remt3000Dto.getCalcSevePayPsnSumtDt());    /** column 퇴직정산제출일자 : calcSevePayPsnSumtDt */
//						remt3000Vo.setDegtrNm(remt3000Dto.getDegtrNm());    /** column 대표자성명 : degtrNm */
//						remt3000Vo.setCorpNmFmnm(remt3000Dto.getCorpNmFmnm());    /** column 법인명_상호 : corpNmFmnm */
//						remt3000Vo.setBusoprRgstnNum(remt3000Dto.getBusoprRgstnNum());    /** column 사업자등록번호 : busoprRgstnNum */
//						remt3000Vo.setResnRegnNum(remt3000Dto.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
//						remt3000Vo.setCorpNum(remt3000Dto.getCorpNum());    /** column 법인번호 : corpNum */
//						remt3000Vo.setIncmRegrstDebrZpcd(remt3000Dto.getIncmRegrstDebrZpcd());    /** column 소득신고의무자우편번호 : incmRegrstDebrZpcd */
//						remt3000Vo.setIncmRegrstDebrFndtnAddr(remt3000Dto.getIncmRegrstDebrFndtnAddr());    /** column 소득신고의무자기본주소 : incmRegrstDebrFndtnAddr */
//						remt3000Vo.setIncmRegrstDebrDtlPatrAddr(remt3000Dto.getIncmRegrstDebrDtlPatrAddr());    /** column 소득신고의무자상세주소 : incmRegrstDebrDtlPatrAddr */
//						remt3000Vo.setJuriTxOffcCd(remt3000Dto.getJuriTxOffcCd());    /** column 관할세무서코드 : juriTxOffcCd */
//						remt3000Vo.setPentrCd(remt3000Dto.getPentrCd());    /** column 제출자구분코드 : pentrCd */
//						remt3000Vo.setTxDeptyNum(remt3000Dto.getTxDeptyNum());    /** column 세무대리인번호 : txDeptyNum */
//						remt3000Vo.setHmtxId(remt3000Dto.getHmtxId());    /** column 홈텍스ID : hmtxId */
//						remt3000Vo.setTxPgmCd(remt3000Dto.getTxPgmCd());    /** column 세무프로그램코드 : txPgmCd */
//						remt3000Vo.setPernChrgDeptNm(remt3000Dto.getPernChrgDeptNm());    /** column 담당자부서명 : pernChrgDeptNm */
//						remt3000Vo.setPernChrgNm(remt3000Dto.getPernChrgNm());    /** column 담당자성명 : pernChrgNm */
//						remt3000Vo.setPernChrgPhnNum(remt3000Dto.getPernChrgPhnNum());    /** column 담당자전화번호 : pernChrgPhnNum */
//						remt3000Vo.setCllnDebrDivCd(remt3000Dto.getCllnDebrDivCd());    /** column 징수의무자구분코드 : cllnDebrDivCd */
						remt3000Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
						remt3000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
						remt3000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
						remt3000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */ 
						 
	                    
	                   switch (actionDatabase) { 
	                   case INSERT:
	                	   remt3000Vo.setDdlneYn("Y");    /** column 마감여부 : ddlneYn */
	                	   remt3000DAO.updateRemt0200ToDDlne(remt3000Vo); 
	                       
	                      break;
	                   case UPDATE: 
	                	 //remt3000DAO.updateRemt3000(remt3000Vo); 
	                       
	                       break;
	                   case DELETE: 
	                	   remt3000Vo.setDdlneYn("N");    /** column 마감여부 : ddlneYn */
	                	   remt3000DAO.deleteRemt0200ToDDlne(remt3000Vo); 
	                        
	                       break;
	                   }
	                     
	                   iCnt = iCnt + 1;  
	 
	               } 
	            
	                result = iCnt;
	                
	        }
	        catch (Exception ex) {
	            
	            result = new Long(0);
	            throw MSFServerUtils.getOperationException("saveRemt0200ToDDlne", ex, logger);
	        }
	        finally {
	          
	        }
	        
	        return result;
	    }  
	    
	    @Override
		   public Remt3100DTO activityOnReadRemt0200(Remt3100DTO remt3100Dto)  throws MSFException {

			   		Remt3100DTO rtnRemt3100Dto = new Remt3100DTO(); 
			   
			        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			        
			    	// 1. 암호화 객체 생성
			    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			        
			        if  (MSFSharedUtils.paramNull(remt3100DAO)) {
				        
			            WebApplicationContext wac = WebApplicationContextUtils.
			                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

			            remt3100DAO = (Remt3100DAO) wac.getBean("Remt3100DAO" ); 
			        }
			        
			        try {   
	 
							  Remt3100VO  remt3100Vo = new Remt3100VO();
							  Remt3100VO  rtnRemt3100Vo = new Remt3100VO();
							  
							  remt3100Vo.setDpobCd(MSFSharedUtils.allowNulls(remt3100Dto.getDpobCd()));    							/** column 사업장코드 : dpobCd */
							  remt3100Vo.setSystemkey(MSFSharedUtils.allowNulls(remt3100Dto.getSystemkey()));    					/** column SYSTEMKEY : systemkey */
							  remt3100Vo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(remt3100Dto.getCalcSevePayPsnDivCd()));   /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
							  remt3100Vo.setClutYrMnth(MSFSharedUtils.allowNulls(remt3100Dto.getClutYrMnth()));      				/** column 퇴직정산정산년월 : clutYrMnth */
							    
							  
							  rtnRemt3100Vo  = remt3100DAO.selectRemt3100(remt3100Vo);
							  
							  if (MSFSharedUtils.paramNotNull(rtnRemt3100Vo)) { 

								rtnRemt3100Dto.setDpobCd(rtnRemt3100Vo.getDpobCd());    								/** column 사업장코드 : dpobCd */
								rtnRemt3100Dto.setClutYrMnth(MSFSharedUtils.allowNulls(rtnRemt3100Vo.getClutYrMnth()));	/** column 퇴직정산정산년월 : clutYrMnth */
								rtnRemt3100Dto.setCalcSevePayPsnDivCd(rtnRemt3100Vo.getCalcSevePayPsnDivCd());    		/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
								rtnRemt3100Dto.setSystemkey(rtnRemt3100Vo.getSystemkey());    							/** column SYSTEMKEY : systemkey */
								rtnRemt3100Dto.setCalcSevePsnBlggYrMnth(rtnRemt3100Vo.getCalcSevePsnBlggYrMnth());    	/** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
								rtnRemt3100Dto.setDeptCd(rtnRemt3100Vo.getDeptCd());    								/** column 부서코드 : deptCd */
								rtnRemt3100Dto.setHanNm(rtnRemt3100Vo.getHanNm());    									/** column 한글성명 : hanNm */
//								rtnRemt3100Dto.setResnRegnNum(rtnRemt3100Vo.getResnRegnNum());    						/** column 주민등록번호 : resnRegnNum */
								
								// 복호화
								rtnRemt3100Dto.setResnRegnNum(AnyCryptUtils.getDecSyncCrypt(nResult,rtnRemt3100Vo.getResnRegnNum().replace("-", ""),AnyCryptUtils.SEC_RRNUMC)); 
								
								rtnRemt3100Dto.setAimenrEcteYn(MSFSharedUtils.convertStringToBoolean(rtnRemt3100Vo.getAimenrEcteYn()));    /** column 소득자임원여부 : aimenrEcteYn */
								rtnRemt3100Dto.setFixPayJnDt(rtnRemt3100Vo.getFixPayJnDt());    /** column 확정급여형가입일자 : fixPayJnDt */
								rtnRemt3100Dto.setSevePay20111231Sum(rtnRemt3100Vo.getSevePay20111231Sum().longValue());    /** column 퇴직금_20111231금액 : sevePay20111231Sum */
								rtnRemt3100Dto.setFrgnrDivCd(rtnRemt3100Vo.getFrgnrDivCd());    /** column 외국인구분코드 : frgnrDivCd */
								rtnRemt3100Dto.setRidnSeptYn(MSFSharedUtils.convertStringToBoolean(rtnRemt3100Vo.getRidnSeptYn()));    /** column 거주구분여부 : ridnSeptYn */
								rtnRemt3100Dto.setRidnCd(rtnRemt3100Vo.getRidnCd());    /** column 거주지국코드 : ridnCd */
								rtnRemt3100Dto.setRidnNm(rtnRemt3100Vo.getRidnNm());    /** column 거주지국명 : ridnNm */
								rtnRemt3100Dto.setBlggYrBgnnDt(rtnRemt3100Vo.getBlggYrBgnnDt());    /** column 귀속년도시작일자 : blggYrBgnnDt */
								rtnRemt3100Dto.setBlggYrEndDt(rtnRemt3100Vo.getBlggYrEndDt());    /** column 귀속년도종료일자 : blggYrEndDt */
								rtnRemt3100Dto.setRetryReasCd(rtnRemt3100Vo.getRetryReasCd());    /** column 퇴직사유코드 : retryReasCd */
								rtnRemt3100Dto.setCtrBusoprRgstnNum(rtnRemt3100Vo.getCtrBusoprRgstnNum());    /** column 중_사업자등록번호 : ctrBusoprRgstnNum */
								rtnRemt3100Dto.setCtrPaeWorkNm(rtnRemt3100Vo.getCtrPaeWorkNm());    /** column 중_근무처명 : ctrPaeWorkNm */
								rtnRemt3100Dto.setCtrRetryPayQnty(rtnRemt3100Vo.getCtrRetryPayQnty().longValue());    /** column 중_퇴직급여액 : ctrRetryPayQnty */
								rtnRemt3100Dto.setCtrFreeDtyRetryPayQnty(rtnRemt3100Vo.getCtrFreeDtyRetryPayQnty().longValue());    /** column 중_비과세퇴직급여액 : ctrFreeDtyRetryPayQnty */
								rtnRemt3100Dto.setCtrTxtnTgtRetryPayQnty(rtnRemt3100Vo.getCtrTxtnTgtRetryPayQnty().longValue());    /** column 중_과세대상퇴직급여액 : ctrTxtnTgtRetryPayQnty */
								rtnRemt3100Dto.setEndBusoprRgstnNum(rtnRemt3100Vo.getEndBusoprRgstnNum());    /** column 종_사업자등록번호 : endBusoprRgstnNum */
								rtnRemt3100Dto.setEndPaeWorkNm(rtnRemt3100Vo.getEndPaeWorkNm());    /** column 종_근무처명 : endPaeWorkNm */
								rtnRemt3100Dto.setEndRetryPayQnty(rtnRemt3100Vo.getEndRetryPayQnty().longValue());    /** column 종_퇴직급여액 : endRetryPayQnty */
								rtnRemt3100Dto.setEndFreeDtyRetryPayQnty(rtnRemt3100Vo.getEndFreeDtyRetryPayQnty().longValue());    /** column 종_비과세퇴직급여액 : endFreeDtyRetryPayQnty */
								rtnRemt3100Dto.setEndTxtnTgtRetryPayQnty(rtnRemt3100Vo.getEndTxtnTgtRetryPayQnty().longValue());    /** column 종_과세대상퇴직급여액 : endTxtnTgtRetryPayQnty */
								rtnRemt3100Dto.setClutRetryPayQnty(rtnRemt3100Vo.getClutRetryPayQnty().longValue());    /** column 정산_퇴직급여액 : clutRetryPayQnty */
								rtnRemt3100Dto.setClutFreeDtyRetryPayQnty(rtnRemt3100Vo.getClutFreeDtyRetryPayQnty().longValue());    /** column 정산_비과세퇴직급여액 : clutFreeDtyRetryPayQnty */
								rtnRemt3100Dto.setClutTxtnTgtRetryPayQnty(rtnRemt3100Vo.getClutTxtnTgtRetryPayQnty().longValue());    /** column 정산_과세대상퇴직급여액 : clutTxtnTgtRetryPayQnty */
								rtnRemt3100Dto.setCtrIcncDt(rtnRemt3100Vo.getCtrIcncDt());    /** column 중_입사일자 : ctrIcncDt */
								rtnRemt3100Dto.setCtrRkfcdDt(rtnRemt3100Vo.getCtrRkfcdDt());    /** column 중_기산일자 : ctrRkfcdDt */
								rtnRemt3100Dto.setCtrRsgtnDt(rtnRemt3100Vo.getCtrRsgtnDt());    /** column 중_퇴사일자 : ctrRsgtnDt */
								rtnRemt3100Dto.setCtrPymtDt(rtnRemt3100Vo.getCtrPymtDt());    /** column 중_지급일자 : ctrPymtDt */
								rtnRemt3100Dto.setCtrLogSvcMnthIcm(rtnRemt3100Vo.getCtrLogSvcMnthIcm().longValue());    /** column 중_근속월수 : ctrLogSvcMnthIcm */
								rtnRemt3100Dto.setCtrEepnMnth12Bfr(rtnRemt3100Vo.getCtrEepnMnth12Bfr().longValue());    /** column 중_제외월수_2012이전 : ctrEepnMnth12Bfr */
								rtnRemt3100Dto.setCtrEepnMnth13Aft(rtnRemt3100Vo.getCtrEepnMnth13Aft().longValue());    /** column 중_제외월수_2013이후 : ctrEepnMnth13Aft */
								rtnRemt3100Dto.setCtrAddMnth12Bfr(rtnRemt3100Vo.getCtrAddMnth12Bfr().longValue());    /** column 중_가산월수_2012이전 : ctrAddMnth12Bfr */
								rtnRemt3100Dto.setCtrAddMnth13Aft(rtnRemt3100Vo.getCtrAddMnth13Aft().longValue());    /** column 중_가산월수_2013이후 : ctrAddMnth13Aft */
								rtnRemt3100Dto.setCtrEepnMnthIcm(rtnRemt3100Vo.getCtrEepnMnthIcm().longValue());    /** column 중_제외월수 : ctrEepnMnthIcm */
								rtnRemt3100Dto.setCtrAddMnthIcm(rtnRemt3100Vo.getCtrAddMnthIcm().longValue());    /** column 중_가산월수 : ctrAddMnthIcm */
								rtnRemt3100Dto.setCtrDupMnthIcm(rtnRemt3100Vo.getCtrDupMnthIcm().longValue());    /** column 중_중복월수 : ctrDupMnthIcm */
								rtnRemt3100Dto.setCtrLogSvc(rtnRemt3100Vo.getCtrLogSvc().longValue());    /** column 중_근속연수 : ctrLogSvc */
								rtnRemt3100Dto.setEndIcncDt(rtnRemt3100Vo.getEndIcncDt());    /** column 종_입사일자 : endIcncDt */
								rtnRemt3100Dto.setEndRkfcdDt(rtnRemt3100Vo.getEndRkfcdDt());    /** column 종_기산일자 : endRkfcdDt */
								rtnRemt3100Dto.setEndRsgtnDt(rtnRemt3100Vo.getEndRsgtnDt());    /** column 종_퇴사일자 : endRsgtnDt */
								rtnRemt3100Dto.setEndPymtDt(rtnRemt3100Vo.getEndPymtDt());    /** column 종_지급일자 : endPymtDt */
								rtnRemt3100Dto.setEndLogSvcMnthIcm(rtnRemt3100Vo.getEndLogSvcMnthIcm().longValue());    /** column 종_근속월수 : endLogSvcMnthIcm */
								rtnRemt3100Dto.setEndEepnMnth12Bfr(rtnRemt3100Vo.getEndEepnMnth12Bfr().longValue());    /** column 종_제외월수_2012이전 : endEepnMnth12Bfr */
								rtnRemt3100Dto.setEndEepnMnth13Aft(rtnRemt3100Vo.getEndEepnMnth13Aft().longValue());    /** column 종_제외월수_2013이후 : endEepnMnth13Aft */
								rtnRemt3100Dto.setEndAddMnth12Bfr(rtnRemt3100Vo.getEndAddMnth12Bfr().longValue());    /** column 종_가산월수_2012이전 : endAddMnth12Bfr */
								rtnRemt3100Dto.setEndAddMnth13Aft(rtnRemt3100Vo.getEndAddMnth13Aft().longValue());    /** column 종_가산월수_2013이후 : endAddMnth13Aft */
								rtnRemt3100Dto.setEndEepnMnthIcm(rtnRemt3100Vo.getEndEepnMnthIcm().longValue());    /** column 종_제외월수 : endEepnMnthIcm */
								rtnRemt3100Dto.setEndAddMnthIcm(rtnRemt3100Vo.getEndAddMnthIcm().longValue());    /** column 종_가산월수 : endAddMnthIcm */
								rtnRemt3100Dto.setEndDupMnthIcm(rtnRemt3100Vo.getEndDupMnthIcm().longValue());    /** column 종_중복월수 : endDupMnthIcm */
								rtnRemt3100Dto.setEndLogSvcYrNum(rtnRemt3100Vo.getEndLogSvcYrNum().longValue());    /** column 종_근속연수 : endLogSvcYrNum */
								rtnRemt3100Dto.setClutIcncDt(rtnRemt3100Vo.getClutIcncDt());    /** column 정산_입사일자 : clutIcncDt */
								rtnRemt3100Dto.setClutRkfcdDt(rtnRemt3100Vo.getClutRkfcdDt());    /** column 정산-기산일자 : clutRkfcdDt */
								rtnRemt3100Dto.setClutRsgtnDt(rtnRemt3100Vo.getClutRsgtnDt());    /** column 정산_퇴사일자 : clutRsgtnDt */
								rtnRemt3100Dto.setClutPymtDt(rtnRemt3100Vo.getClutPymtDt());    /** column 정산_지급일자 : clutPymtDt */
								rtnRemt3100Dto.setClutLogSvcMnthIcm(rtnRemt3100Vo.getClutLogSvcMnthIcm().longValue());    /** column 정산_근속월수 : clutLogSvcMnthIcm */
								rtnRemt3100Dto.setClutEepnMnthIcm(rtnRemt3100Vo.getClutEepnMnthIcm().longValue());    /** column 정산_제외월수 : clutEepnMnthIcm */
								rtnRemt3100Dto.setClutAddMnthIcm(rtnRemt3100Vo.getClutAddMnthIcm().longValue());    /** column 정산_가산월수 : clutAddMnthIcm */
								rtnRemt3100Dto.setClutDupMnthIcm(rtnRemt3100Vo.getClutDupMnthIcm().longValue());    /** column 정산_중복월수 : clutDupMnthIcm */
								rtnRemt3100Dto.setClutLogSvcYrNum(rtnRemt3100Vo.getClutLogSvcYrNum().longValue());    /** column 정산_근속연수 : clutLogSvcYrNum */
								rtnRemt3100Dto.setLogPpnl12befIcncDt(rtnRemt3100Vo.getLogPpnl12befIcncDt());    /** column 근속안분_2012전_입사일자 : logPpnl12befIcncDt */
								rtnRemt3100Dto.setLogPpnl12befRkfcdDt(rtnRemt3100Vo.getLogPpnl12befRkfcdDt());    /** column 근속안분_2012전_기산일자 : logPpnl12befRkfcdDt */
								rtnRemt3100Dto.setLogPpnl12befRsgtnDt(rtnRemt3100Vo.getLogPpnl12befRsgtnDt());    /** column 근속안분_2012전_퇴사일자 : logPpnl12befRsgtnDt */
								rtnRemt3100Dto.setLogPpnl12befPymtDt(rtnRemt3100Vo.getLogPpnl12befPymtDt());    /** column 근속안분_2012전_지급일자 : logPpnl12befPymtDt */
								rtnRemt3100Dto.setLogPpnl12befLogMnthIcm(rtnRemt3100Vo.getLogPpnl12befLogMnthIcm().longValue());    /** column 근속안분_2012전_근속월수 : logPpnl12befLogMnthIcm */
								rtnRemt3100Dto.setLogPpnl12befEepnMnthIcm(rtnRemt3100Vo.getLogPpnl12befEepnMnthIcm().longValue());    /** column 근속안분_2012전_제외월수 : logPpnl12befEepnMnthIcm */
								rtnRemt3100Dto.setLogPpnl12befAddMnthIcm(rtnRemt3100Vo.getLogPpnl12befAddMnthIcm().longValue());    /** column 근속안분_2012전_가산월수 : logPpnl12befAddMnthIcm */
								rtnRemt3100Dto.setLogPpnl12befDupMnthIcm(rtnRemt3100Vo.getLogPpnl12befDupMnthIcm().longValue());    /** column 근속안분_2012전_중복월수 : logPpnl12befDupMnthIcm */
								rtnRemt3100Dto.setLogPpnl12befLogYrNum(rtnRemt3100Vo.getLogPpnl12befLogYrNum().longValue());    /** column 근속안분_2012전_근속년수 : logPpnl12befLogYrNum */
								rtnRemt3100Dto.setLogPpnl13afrIcncDt(rtnRemt3100Vo.getLogPpnl13afrIcncDt());    /** column 근속안분_2013후_입사일자 : logPpnl13afrIcncDt */
								rtnRemt3100Dto.setLogPpnl13afrRkfcdDt(rtnRemt3100Vo.getLogPpnl13afrRkfcdDt());    /** column 근속안분_2013후_기산일자 : logPpnl13afrRkfcdDt */
								rtnRemt3100Dto.setLogPpnl13afrRsgtnDt(rtnRemt3100Vo.getLogPpnl13afrRsgtnDt());    /** column 근속안분_2013후_퇴사일자 : logPpnl13afrRsgtnDt */
								rtnRemt3100Dto.setLogPpnl13afrPymtDt(rtnRemt3100Vo.getLogPpnl13afrPymtDt());    /** column 근속안분_2013후_지급일자 : logPpnl13afrPymtDt */
								rtnRemt3100Dto.setLogPpnl13afrLogMnthIcm(rtnRemt3100Vo.getLogPpnl13afrLogMnthIcm().longValue());    /** column 근속안분_2013후_근속월수 : logPpnl13afrLogMnthIcm */
								rtnRemt3100Dto.setLogPpnl13afrEepnMnthIcm(rtnRemt3100Vo.getLogPpnl13afrEepnMnthIcm().longValue());    /** column 근속안분_2013후_제외월수 : logPpnl13afrEepnMnthIcm */
								rtnRemt3100Dto.setLogPpnl13afrAddMnthIcm(rtnRemt3100Vo.getLogPpnl13afrAddMnthIcm().longValue());    /** column 근속안분_2013후_가산월수 : logPpnl13afrAddMnthIcm */
								rtnRemt3100Dto.setLogPpnl13afrDupMnthIcm(rtnRemt3100Vo.getLogPpnl13afrDupMnthIcm().longValue());    /** column 근속안분_2013후_중복월수 : logPpnl13afrDupMnthIcm */
								rtnRemt3100Dto.setLogPpnl13afrLogSvc(rtnRemt3100Vo.getLogPpnl13afrLogSvc().longValue());            /** column 근속안분_2013후_근속연수 : logPpnl13afrLogSvc */
								rtnRemt3100Dto.setRetryIncmCtrPymtSum(rtnRemt3100Vo.getRetryIncmCtrPymtSum().longValue());          /** column 퇴직소득_중간지급금액 : retryIncmCtrPymtSum */
								rtnRemt3100Dto.setRetryIncmEndPymtSum(rtnRemt3100Vo.getRetryIncmEndPymtSum().longValue());          /** column 퇴직소득_종료지급금액 : retryIncmEndPymtSum */
								rtnRemt3100Dto.setRetryIncmClutSum(rtnRemt3100Vo.getRetryIncmClutSum().longValue());                /** column 퇴직소득_정산금액 : retryIncmClutSum */
								rtnRemt3100Dto.setRetryFxrtDducClutSum(rtnRemt3100Vo.getRetryFxrtDducClutSum().longValue());        /** column 퇴직소득정률공제_정산금액 : retryFxrtDducClutSum */
								rtnRemt3100Dto.setLogYrDducSum(rtnRemt3100Vo.getLogYrDducSum().longValue());                        /** column 근속년수공제_정산금액 : logYrDducSum */
								rtnRemt3100Dto.setRetryTxtnStdClutSum(rtnRemt3100Vo.getRetryTxtnStdClutSum().longValue());          /** column 퇴직소득과세표준_정산금액 : retryTxtnStdClutSum */
								rtnRemt3100Dto.setTat12befTxtnStdPpnlSum(rtnRemt3100Vo.getTat12befTxtnStdPpnlSum().longValue());    /** column 세액_2012전_과세표준안분금액 : tat12befTxtnStdPpnlSum */
								rtnRemt3100Dto.setTat12befYravgTxstdSum(rtnRemt3100Vo.getTat12befYravgTxstdSum().longValue());    /** column 세액_2012전_연평균과세표준금액 : tat12befYravgTxstdSum */
								rtnRemt3100Dto.setTat12befCvsnTxtnStdSum(rtnRemt3100Vo.getTat12befCvsnTxtnStdSum().longValue());    /** column 세액_2012전_환산과세표준금액 : tat12befCvsnTxtnStdSum */
								rtnRemt3100Dto.setTat12befCvsnCalcAmnt(rtnRemt3100Vo.getTat12befCvsnCalcAmnt().longValue());    /** column 세액_2012전_환산산출세액금액 : tat12befCvsnCalcAmnt */
								rtnRemt3100Dto.setTat12befYrAvgCalcAmnt(rtnRemt3100Vo.getTat12befYrAvgCalcAmnt().longValue());    /** column 세액_2012전_연평균산출세액 : tat12befYrAvgCalcAmnt */
								rtnRemt3100Dto.setTat12befCalcTxAmnt(rtnRemt3100Vo.getTat12befCalcTxAmnt().longValue());    /** column 세액_2012전_산출세액 : tat12befCalcTxAmnt */
								rtnRemt3100Dto.setTat12befAlpayTxAmnt(rtnRemt3100Vo.getTat12befAlpayTxAmnt().longValue());    /** column 세액_2012전_기납부세액 : tat12befAlpayTxAmnt */
								rtnRemt3100Dto.setTat12befRegTgtTxAmnt(rtnRemt3100Vo.getTat12befRegTgtTxAmnt().longValue());    /** column 세액_2012전_신고대상세액 : tat12befRegTgtTxAmnt */
								rtnRemt3100Dto.setTat13afrTxstdPpnlSum(rtnRemt3100Vo.getTat13afrTxstdPpnlSum().longValue());    /** column 세액_2013후_과세표준안분금액 : tat13afrTxstdPpnlSum */
								rtnRemt3100Dto.setTat13afrYrAvgStdSum(rtnRemt3100Vo.getTat13afrYrAvgStdSum().longValue());    /** column 세액_2013후_연평균과세표준금액 : tat13afrYrAvgStdSum */
								rtnRemt3100Dto.setTat13afrCvsnTxtnStdSum(rtnRemt3100Vo.getTat13afrCvsnTxtnStdSum().longValue());    /** column 세액_2013후_환산과세표준금액 : tat13afrCvsnTxtnStdSum */
								rtnRemt3100Dto.setTat13afrCvsnCalcTxAmnt(rtnRemt3100Vo.getTat13afrCvsnCalcTxAmnt().longValue());    /** column 세액_2013후_환산산출세액 : tat13afrCvsnCalcTxAmnt */
								rtnRemt3100Dto.setTat13afrYrAvgCalcAmnt(rtnRemt3100Vo.getTat13afrYrAvgCalcAmnt().longValue());    /** column 세액_2013후_연평균산출세액 : tat13afrYrAvgCalcAmnt */
								rtnRemt3100Dto.setTat13afrCalcTxAmnt(rtnRemt3100Vo.getTat13afrCalcTxAmnt().longValue());    /** column 세액_2013후_산출세액 : tat13afrCalcTxAmnt */
								rtnRemt3100Dto.setTat13afrAlpayTxAmnt(rtnRemt3100Vo.getTat13afrAlpayTxAmnt().longValue());    /** column 세액_2013후_기납부세액 : tat13afrAlpayTxAmnt */
								rtnRemt3100Dto.setTat13afrRegrstTgtSum(rtnRemt3100Vo.getTat13afrRegrstTgtSum().longValue());    /** column 세액_2013후_신고대상세액 : tat13afrRegrstTgtSum */
								rtnRemt3100Dto.setTatAggrTxtnStdPpnlSum(rtnRemt3100Vo.getTatAggrTxtnStdPpnlSum().longValue());    /** column 세액_합계_과세표준안분금액 : tatAggrTxtnStdPpnlSum */
								rtnRemt3100Dto.setTatAggrYrAvgTxtnStdSum(rtnRemt3100Vo.getTatAggrYrAvgTxtnStdSum().longValue());    /** column 세액_합계_연평균과세표준금액 : tatAggrYrAvgTxtnStdSum */
								rtnRemt3100Dto.setTatAggrCvsnTxtnStdSum(rtnRemt3100Vo.getTatAggrCvsnTxtnStdSum().longValue());    /** column 세액_합계_환산과세표준금액 : tatAggrCvsnTxtnStdSum */
								rtnRemt3100Dto.setTatAggrCvsnCalcTxAmnt(rtnRemt3100Vo.getTatAggrCvsnCalcTxAmnt().longValue());    /** column 세액_합계_환산산출세액 : tatAggrCvsnCalcTxAmnt */
								rtnRemt3100Dto.setTatAggrYrAvgCalcTxAmnt(rtnRemt3100Vo.getTatAggrYrAvgCalcTxAmnt().longValue());    /** column 세액_합계_연평균산출세액 : tatAggrYrAvgCalcTxAmnt */
								rtnRemt3100Dto.setTatAggrCalcTxAmnt(rtnRemt3100Vo.getTatAggrCalcTxAmnt().longValue());    /** column 세액_합계_산출세액 : tatAggrCalcTxAmnt */
								rtnRemt3100Dto.setTatAggrAlpayTxAmnt(rtnRemt3100Vo.getTatAggrAlpayTxAmnt().longValue());    /** column 세액_합계_기납부세액 : tatAggrAlpayTxAmnt */
								rtnRemt3100Dto.setTatAggrRegrstTgtTxAmnt(rtnRemt3100Vo.getTatAggrRegrstTgtTxAmnt().longValue());    /** column 세액_합계_신고대상세액 : tatAggrRegrstTgtTxAmnt */
								rtnRemt3100Dto.setTalRegrstTgtTxAmnt(rtnRemt3100Vo.getTalRegrstTgtTxAmnt().longValue());    /** column 이연세액_신고대상세액 : talRegrstTgtTxAmnt */
								rtnRemt3100Dto.setTalAccuDepitAggrSum(rtnRemt3100Vo.getTalAccuDepitAggrSum().longValue());    /** column 이연세액_계좌입금합계금액 : talAccuDepitAggrSum */
								rtnRemt3100Dto.setTalRetryPayQnty(rtnRemt3100Vo.getTalRetryPayQnty().longValue());    /** column 이연세액_퇴직급여액 : talRetryPayQnty */
								rtnRemt3100Dto.setTalRetryIncmTxAmnt(rtnRemt3100Vo.getTalRetryIncmTxAmnt().longValue());    /** column 이연세액_이연퇴직소득세액 : talRetryIncmTxAmnt */
								rtnRemt3100Dto.setPymtRegTgtIncmTxQnty(rtnRemt3100Vo.getPymtRegTgtIncmTxQnty().longValue());    /** column 납부신고대상_소득세액 : pymtRegTgtIncmTxQnty */
								rtnRemt3100Dto.setPymtRegTgtRgonIncmQnty(rtnRemt3100Vo.getPymtRegTgtRgonIncmQnty().longValue());    /** column 납부신고대상_지방소득세액 : pymtRegTgtRgonIncmQnty */
								rtnRemt3100Dto.setPymtRegTgtFarvilSpclQnty(rtnRemt3100Vo.getPymtRegTgtFarvilSpclQnty().longValue());    /** column 납부신고대상_농어촌특별세액 : pymtRegTgtFarvilSpclQnty */
								rtnRemt3100Dto.setPymtRegrstTgtAggrSum(rtnRemt3100Vo.getPymtRegrstTgtAggrSum().longValue());    /** column 납부신고대상_합계금액 : pymtRegrstTgtAggrSum */
								rtnRemt3100Dto.setPymtTalcIncmTxQnty(rtnRemt3100Vo.getPymtTalcIncmTxQnty().longValue());    /** column 납부이연_소득세액 : pymtTalcIncmTxQnty */
								rtnRemt3100Dto.setPymtTalcRgonIncmTxQnty(rtnRemt3100Vo.getPymtTalcRgonIncmTxQnty().longValue());    /** column 납부이연_지방소득세액 : pymtTalcRgonIncmTxQnty */
								rtnRemt3100Dto.setPymtTalcFarvilSpclQnty(rtnRemt3100Vo.getPymtTalcFarvilSpclQnty().longValue());    /** column 납부이연-농어촌특별세액 : pymtTalcFarvilSpclQnty */
								rtnRemt3100Dto.setPymtTxAllcAggrSum(rtnRemt3100Vo.getPymtTxAllcAggrSum().longValue());    /** column 납부이연_합계금액 : pymtTxAllcAggrSum */
								rtnRemt3100Dto.setPymtSubtnIncmTxQnty(rtnRemt3100Vo.getPymtSubtnIncmTxQnty().longValue());    /** column 납부차감_소득세액 : pymtSubtnIncmTxQnty */
								rtnRemt3100Dto.setPymtSubtnRgonIncmTxQnty(rtnRemt3100Vo.getPymtSubtnRgonIncmTxQnty().longValue());    /** column 납부차감_지방소득세액 : pymtSubtnRgonIncmTxQnty */
								rtnRemt3100Dto.setPymtSubtnFarvilSpclQnty(rtnRemt3100Vo.getPymtSubtnFarvilSpclQnty().longValue());    /** column 납부차감_농어촌특별세액 : pymtSubtnFarvilSpclQnty */
								rtnRemt3100Dto.setPymtSubtnAggrSum(rtnRemt3100Vo.getPymtSubtnAggrSum().longValue());    /** column 납부차감_합계금액 : pymtSubtnAggrSum */
	 

							  }	else {
								  
							  }	  
			        }
			        catch (Exception ex) {
			        	 
			            logger.error("EXCEPTION calling activityOnReadRemt0200ToRemt3100(): "+ex);  
			            throw MSFServerUtils.getOperationException("activityOnReadRemt0200ToRemt3100", ex, logger);
			            
			        }
			        
			        finally {
			          
			        }
			        
			        return rtnRemt3100Dto;
			}
	    
	     
	    @Override
		 public Long activityOnupdateRemt0200Save( Remt3100DTO remt3100Dto )  throws MSFException {

		        Long retval = 0L;
		   
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		        try {    
						    Remt3100VO  remt3100Vo = new Remt3100VO();  
						    Remt3000VO  remt3000Vo = new Remt3000VO();  
						    
							 
						    remt3100Vo.setDpobCd(remt3100Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
						    remt3100Vo.setClutYrMnth(MSFSharedUtils.allowNulls(remt3100Dto.getClutYrMnth()));      /** column 퇴직정산정산년월 : clutYrMnth */
						    remt3100Vo.setCalcSevePayPsnDivCd(remt3100Dto.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						    remt3100Vo.setSystemkey(remt3100Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
			         	   
						    remt3100Vo.setCalcSevePsnBlggYrMnth(remt3100Dto.getCalcSevePsnBlggYrMnth());    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
						    remt3100Vo.setFixPayJnDt(remt3100Dto.getFixPayJnDt());/** set 확정급여형가입일자 : fixPayJnDt */ 
						    remt3100Vo.setSevePay20111231Sum(new BigDecimal(remt3100Dto.getSevePay20111231Sum()));/** set 퇴직금_20111231금액 : sevePay20111231Sum */
						    remt3100Vo.setAimenrEcteYn(Boolean.TRUE.equals(remt3100Dto.getAimenrEcteYn()) ? "Y" : "N"); /** set 소득자임원여부 : aimenrEcteYn */
						    remt3100Vo.setRetryReasCd(remt3100Dto.getRetryReasCd());/** set 퇴직사유코드 : retryReasCd */
						    remt3100Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
						    remt3100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
						    remt3100Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
						    remt3100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
						    remt3100Vo.setEndPymtDt(remt3100Dto.getReipDt());   /** column 종_지급일자 : endPymtDt */
						    //TODO 귀속시작일자 종료일자 변경 처리 변경시  
						    //SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy"); 
						    Date date = new Date();
				            String strCalcSevePsnBlggYr = SmrmfUtils.getStringFromDate(date,"yyyy"); //dateFormatGmt.format(date);
				            String strCalcSevePsnDt = strCalcSevePsnBlggYr.concat("0101");
				            
		                    if (strCalcSevePsnDt.substring(0, 6).compareTo(remt3100Dto.getCalcSevePsnBlggYrMnth()) > 0) {
		                    	remt3100Vo.setBlggYrBgnnDt(remt3100Dto.getCalcSevePsnBlggYrMnth().substring(0, 4).concat("0101"));    /** column 귀속년도시작일자 : blggYrBgnnDt */
		                    	remt3100Vo.setBlggYrEndDt(remt3100Dto.getEndRsgtnDt());    /** column 귀속년도종료일자 : blggYrEndDt */
		                     
		                    } else {
		                    	remt3100Vo.setBlggYrBgnnDt(strCalcSevePsnDt);    /** column 귀속년도시작일자 : blggYrBgnnDt */
		                    	remt3100Vo.setBlggYrEndDt(remt3100Dto.getReipDt());    /** column 귀속년도종료일자 : blggYrEndDt */
		                    }
		                     
		                    
						    
						    remt3000Vo.setDpobCd(remt3100Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
						    remt3000Vo.setClutYrMnth(remt3100Dto.getClutYrMnth());    /** column 퇴직정산년월 : setClutYrMnth */
						    remt3000Vo.setCalcSevePayPsnDivCd(remt3100Dto.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						    remt3000Vo.setSystemkey(remt3100Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
						    remt3000Vo.setReipDt(remt3100Dto.getReipDt());  /** set 영수일자 : reipDt */
						 
						  	  
						    
						    remt3000Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
						    remt3000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
						    remt3000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
						    remt3000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
							
		   					remt3100DAO.updateRemt0200ToRemt3100(remt3100Vo);  
		   					remt3000DAO.updateRemt0200ToRemt3000(remt3000Vo);
		   				 
							 
						    retval = 1L;
		        }
		        catch (Exception ex) {
		        	 
		            logger.error("EXCEPTION calling activityOnDeleteRemt0100Save(): "+ex); 
		            retval = 0L;
		            throw MSFServerUtils.getOperationException("activityOnDeleteRemt0100Save", ex, logger);
		        } 
		        
		        return retval;
		} 
	    
	    
	    @Override
		 public PagingLoadResult<ShowMessageBM> activityOnPayrRemtCalc( List<Remt3000DTO> listRemt3000Dto ) throws MSFException {

		        PagingLoadResult<ShowMessageBM> retval = null;
		   
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		        try {  
		            
		        	 
					  List<InfcPkgRemt3000VO>  lstInfcRemt3000Vo = new ArrayList<InfcPkgRemt3000VO>();
					 
	                  for (int iCnt = 0;iCnt < listRemt3000Dto.size();iCnt++) { 
	                  
							  InfcPkgRemt3000VO  infcRemt3000Vo = new InfcPkgRemt3000VO();
							  Remt3000DTO  remt3000Dto = new Remt3000DTO(); 
							  
							  remt3000Dto = (Remt3000DTO) listRemt3000Dto.get(iCnt); 
							  
							  infcRemt3000Vo.setDpobCd(remt3000Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
							  infcRemt3000Vo.setSystemkey(remt3000Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
							  infcRemt3000Vo.setCalcSevePayPsnDivCd(remt3000Dto.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
							  infcRemt3000Vo.setClutYrMnth(remt3000Dto.getClutYrMnth());   /** column 퇴직정산정산년월 : clutYrMnth */
							  
							  lstInfcRemt3000Vo.add(infcRemt3000Vo); 
						 
		               } 
	                   
		         
                       RemtListenerAdapter remtAdapter = new RemtListenerAdapter(); 
                       retval = remtAdapter.setActivityOnPayrRemtCalc(RemoteServiceUtil.getThreadLocalRequest(),lstInfcRemt3000Vo);
              
		        }
		        catch (Exception ex) {
		        	 
		            logger.error("EXCEPTION calling activityOnUpdateRemt0100Save(): "+ex); 
		             
		            throw MSFServerUtils.getOperationException("activityOnUpdateRemt0100Save", ex, logger);
		        }
		        finally {
		          
		        }
		      
		        return retval;
		} 
	    
 
}
