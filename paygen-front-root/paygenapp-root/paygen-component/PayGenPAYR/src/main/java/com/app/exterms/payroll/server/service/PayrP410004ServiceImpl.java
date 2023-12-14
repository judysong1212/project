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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.payroll.client.dto.Payr0500DTO;
import com.app.exterms.payroll.client.service.PayrP410004Service;
import com.app.exterms.payroll.server.service.dao.Payr0500DAO;
import com.app.exterms.payroll.server.vo.Payr0500SrhVO;
import com.app.exterms.payroll.server.vo.Payr0500VO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("PayrP410004Service")
public class PayrP410004ServiceImpl extends AbstractCustomServiceImpl implements PayrP410004Service , PayrDaoConstants { 

	private static final Logger logger = LoggerFactory.getLogger(PayrP410004ServiceImpl.class);
	private static final String calledClass = PayrP410004ServiceImpl.class.getName();
	
  
	@Autowired
	@Resource(name = "Payr0500DAO")
	private Payr0500DAO payr0500DAO;
	
	 
    
    /** ID Generation */
    //@Resource(name="{egovPayr0500IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	
	//기본상세정보 
	public PagingLoadResult<BaseModel> getPayrP410004ToPayr0500DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYRP410004TOPAYR0500_DATA_LIST;
        Payr0500SrhVO   payr0500SrhVO = new Payr0500SrhVO();
        Payr0500VO      payr0500VO = new Payr0500VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(payr0500DAO)) {
        
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            payr0500DAO = (Payr0500DAO) wac.getBean("Payr0500DAO" ); 
        }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0530BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            List<String> listDeptCd = new ArrayList<String>();
            /** 조건절 */
            payr0500SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            payr0500SrhVO.setPayrMangDeptYn(MSFSharedUtils.allowNulls(sessionUser.getPayrMangDeptYn()));  //단위기관담당자여부 
            
            payr0500SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
             

            payr0500SrhVO.setUsrId(sessionUser.getUsrId());  
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	
            	if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
               	 

                	payr0500SrhVO.setDeptCd(sessionUser.getDeptCd()); 
                   listDeptCd.add(sessionUser.getDeptCd());
                   payr0500SrhVO.setDeptCdArr(listDeptCd);     //부서코드       
           	 } else {
           		 
           		 payr0500SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                 listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                 payr0500SrhVO.setDeptCdArr(listDeptCd);     //부서코드     
           	 }  
            	
               payr0500SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	payr0500SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드 
            	
                     if (payr0500SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	payr0500SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	payr0500SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	 payr0500SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          payr0500SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
            
            payr0500SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            payr0500SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
             
           /******************************** 권한 ************************************************************************/
            
//            if (payr0500SrhVO.getPayrMangeDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
//          	  payr0500SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//            	List<String> listDeptCd = null; 
//            	payr0500SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//            	payr0500SrhVO.setDeptCd("");     //부서코드
//            } else { 
//
//                List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//                payr0500SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//                payr0500SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
//            }
            
            
            
            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
            payr0500SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
            payr0500SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
           
//            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//            payr0500SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//            payr0500SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
             
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0500SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0500SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세 
            
            payr0500SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
            payr0500SrhVO.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
          
            payr0500SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            payr0500SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
            
            String strHdofcCodtnCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"));
            
            List<String> listHdofcCodtnCd = new ArrayList<String>(); 
           
            String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
            
            for (int i=0; i<ray.length; i++){ 
                listHdofcCodtnCd.add(ray[i]);
            } 
            payr0500SrhVO.setHdofcCodtnCdArr(listHdofcCodtnCd);    //재직상
            payr0500SrhVO.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));    //재직상
            
            
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0500DAO.selectPayrP410004ToPayr0500ListTotCnt(payr0500SrhVO);  
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBegingetPayrP410004ToPayr0500DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0500SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                payr0500SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                payr0500SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0500DAO.selectPayrP410004ToPayr0500List(payr0500SrhVO);
            
            Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("systemkey").toString();
                BaseModel bm = new BaseModel();
 
                //bm.setProperties(map);
                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
                	
                	// 1. 암호화 객체 생성
            		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
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
            
            SmrmfUtils.endTiming(logger, millisBegingetPayrP410004ToPayr0500DataList, "getPayrP410004ToPayr0500DataList");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }



	@Override
	public Long activityOnUpdatePayrP410004Save(
			List<Payr0500DTO> listPayr0500Dto) throws MSFException {
		// TODO Auto-generated method stub
      Long result = new Long(1);
      MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());  
      
  	// 1. 암호화 객체 생성
//  	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
      
      if  (MSFSharedUtils.paramNull(payr0500DAO)) {
          
          WebApplicationContext wac = WebApplicationContextUtils.
                  getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

          payr0500DAO = (Payr0500DAO) wac.getBean("Payr0500DAO" ); 
      }
      
        try {
          
        	
        	 for(int iPayrCnt=0;iPayrCnt < listPayr0500Dto.size();iPayrCnt++) {
        		 
        		// 1. 암호화 객체 생성
        			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
                 
                 Payr0500DTO payr0500Dto = new Payr0500DTO();  
                 payr0500Dto = listPayr0500Dto.get(iPayrCnt);
                 
			     Payr0500VO  payr0500Vo = new Payr0500VO(); 
			     Payr0500VO  tpPayr0500Vo = new Payr0500VO(); 
			           
			          
			         //*******************************************************************************************************/
			          // 급여인사마스터 업데이트  
			
			          payr0500Vo.setDpobCd(payr0500Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
			          payr0500Vo.setSystemkey(payr0500Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
			//          payr0500Vo.setPayrMangDeptCd(payr0500Dto.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
			//          payr0500Vo.setEmymtDivCd(payr0500Dto.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
			//          payr0500Vo.setLogSvcStdDt(payr0500Dto.getLogSvcStdDt());    /** column 근속기준일자 : logSvcStdDt */
			//          payr0500Vo.setWmnYn((Boolean.TRUE.equals(payr0500Dto.getWmnYn()) ? "Y" : "N"));    /** column 부녀자여부 : wmnYn */
			//          payr0500Vo.setRetryClutYn((Boolean.TRUE.equals(payr0500Dto.getRetryClutYn()) ? "Y" : "N"));    /** column 퇴직정산여부 : retryClutYn */
			//          payr0500Vo.setPayRcptYn((Boolean.TRUE.equals(payr0500Dto.getPayRcptYn()) ? "Y" : "N"));    /** column 급여대상자여부 : payRcptYn */
			//        //  payr0500Vo.setSpueYn(payr0500Dto.getSpueYn());    /** column 배우자유무 : spueYn */
			//          payr0500Vo.setHlthInsrApptnYn((Boolean.TRUE.equals(payr0500Dto.getHlthInsrApptnYn()) ? "Y" : "N"));    /** column 건강보험적용여부 : hlthInsrApptnYn */
			//          payr0500Vo.setNatPennApptnYn((Boolean.TRUE.equals(payr0500Dto.getNatPennApptnYn()) ? "Y" : "N"));    /** column 국민연금적용여부 : natPennApptnYn */
			//          payr0500Vo.setUmytInsrApptnYn((Boolean.TRUE.equals(payr0500Dto.getUmytInsrApptnYn()) ? "Y" : "N"));    /** column 고용보험적용여부 : umytInsrApptnYn */
			//          payr0500Vo.setIdtlAccdtInsurApptnYn((Boolean.TRUE.equals(payr0500Dto.getIdtlAccdtInsurApptnYn()) ? "Y" : "N"));    /** column 산재보험적용여부 : idtlAccdtInsurApptnYn */
			//         // payr0500Vo.setSuprtFamyNumTwenChDn(payr0500Dto.getSuprtFamyNumTwenChDn());    /** column 부양가족수20_자녀 : suprtFamyNumTwenChDn */
			//         // payr0500Vo.setSuprtFamyNumTreOvrChdnYn(payr0500Dto.getSuprtFamyNumTreOvrChdnYn());    /** column 부양가족수_3_이상자녀여부 : suprtFamyNumTreOvrChdnYn */
			//         // payr0500Vo.setSuprtFamyNumEtc(payr0500Dto.getSuprtFamyNumEtc());    /** column 부양가족수_기타 : suprtFamyNumEtc */
			//         // payr0500Vo.setChdnSchlExpnAdmclYn(payr0500Dto.getChdnSchlExpnAdmclYn());    /** column 자녀학비보조여부 : chdnSchlExpnAdmclYn */
			//          payr0500Vo.setLogSvcExtpyApptnYn((Boolean.TRUE.equals(payr0500Dto.getLogSvcExtpyApptnYn()) ? "Y" : "N"));    /** column 근속수당적용여부 : logSvcExtpyApptnYn */
			//          payr0500Vo.setDayWorkYn((Boolean.TRUE.equals(payr0500Dto.getDayWorkYn()) ? "Y" : "N"));    /** column 일용직구분 : dayWorkYn */
//			          payr0500Vo.setPayrIncmExceYn((Boolean.TRUE.equals(payr0500Dto.getPayrIncmExceYn()) ? "Y" : "N"));    /** column 급여소득세제외여부 : payrIncmExceYn  */
			//          payr0500Vo.setMnthPayDlywagSum(new BigDecimal(payr0500Dto.getMnthPayDlywagSum()));    /** column 월급여일당금액 : mnthPayDlywagSum */
			//           
			          
			          tpPayr0500Vo = payr0500DAO.selectPayr0500(payr0500Vo);
			          
			          if (MSFSharedUtils.paramNotNull(tpPayr0500Vo) && MSFSharedUtils.paramNotNull(tpPayr0500Vo.getSystemkey())) { 
			          	
			          	  if (MSFSharedUtils.allowNulls(tpPayr0500Vo.getAddIncmTxApptnRtoCd()).equals(payr0500Dto.getAddIncmTxApptnRtoCd())
			                		&& MSFSharedUtils.allowNulls(tpPayr0500Vo.getAddIncmTxApptnYrMnth()).equals(payr0500Dto.getAddIncmTxApptnYrMnth()) 
			                		&& "E".equals(MSFSharedUtils.allowNulls(tpPayr0500Vo.getAddIncmTxApptnYn())))  {
			          		  
			          		  payr0500Vo.setAddIncmTxApptnRtoCd(payr0500Dto.getAddIncmTxApptnRtoCd());    	/** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
			                    payr0500Vo.setAddIncmTxApptnYrMnth(payr0500Dto.getAddIncmTxApptnYrMnth());	/** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
			                    payr0500Vo.setAddIncmTxApptnYn(payr0500Dto.getAddIncmTxApptnYn());    		/** column 추가소득세적용여부 : addIncmTxApptnYn */
			          		  
			          	  } else {
			          		  payr0500Vo.setAddIncmTxApptnRtoCd(payr0500Dto.getAddIncmTxApptnRtoCd());    	/** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
			                    payr0500Vo.setAddIncmTxApptnYrMnth(payr0500Dto.getAddIncmTxApptnYrMnth());	/** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
			                    payr0500Vo.setAddIncmTxApptnYn("Y");    									/** column 추가소득세적용여부 : addIncmTxApptnYn */
			          	  }
			          } else {
			          	//에러메시지
			          	 payr0500Vo.setAddIncmTxApptnRtoCd(payr0500Dto.getAddIncmTxApptnRtoCd());    		/** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
			               payr0500Vo.setAddIncmTxApptnYrMnth(payr0500Dto.getAddIncmTxApptnYrMnth());    	/** column 추가소득세적용년월 : addIncmTxApptnYrMnth */
			               payr0500Vo.setAddIncmTxApptnYn(payr0500Dto.getAddIncmTxApptnYn());    			/** column 추가소득세적용여부 : addIncmTxApptnYn */
			          }
			          
			          payr0500Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
			          payr0500Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
			          payr0500Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
			          payr0500Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */

			        
			            payr0500DAO.updatePayr0500ToPayrP410004(payr0500Vo); 
        	 }
            
        }
        catch (Exception ex) {
            //logger.error("EXCEPTION calling activityOnVoceMenu(): "+ex); 
            result = new Long(0);
            ex.printStackTrace();
            throw MSFServerUtils.getOperationException("activityOnPayr0520", ex, logger);
        }
        finally {
          
        }
        return result;
	}
	
 
  
        
}
