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
import java.text.SimpleDateFormat;
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

import com.app.exterms.retirement.client.service.Remt0400Service;
import com.app.exterms.retirement.server.service.dao.Remt9000DAO;
import com.app.exterms.retirement.server.vo.Remt9000SrhVO;
import com.app.exterms.retirement.server.vo.Remt9000VO;
import com.app.exterms.retirement.shared.RemtDaoConstants;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Remt0400Service")
public class Remt0400ServiceImpl extends AbstractCustomServiceImpl implements Remt0400Service  ,RemtDaoConstants {

    private static final Logger logger = LoggerFactory.getLogger(Remt0400ServiceImpl.class);
    private static final String calledClass = Remt0400ServiceImpl.class.getName();
    
    @Autowired 
    @Resource(name="Remt9000DAO")
    private Remt9000DAO remt9000DAO;
    
    /** ID Generation */
    //@Resource(name="{egovRemt9000IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

    
    public List<BaseModel> activityOnRemt9000Save(ServiceParameters serviceParameters) {
        
        List<BaseModel> lsBmResult = new ArrayList<BaseModel>();
        String result = "1";  
        Remt9000SrhVO   remt9000SrhVo = new Remt9000SrhVO();
    	String method = calledClass + ".activityOnRemt9000Save";
    	
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        
        List<BaseModel> listObjects       = serviceParameters.getDataObjects();
        ActionDatabase actionDatabase     = serviceParameters.getActionDatabase(); 
        String customMethodName           = serviceParameters.getCustomMethodName();
        ColumnAttribute[] tableAttributes = serviceParameters.getTableAttributes();
        Boolean reloadData                = serviceParameters.isReloadData();
        Boolean noHistory                 = serviceParameters.isNoHistory(); 
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
         
        if  (MSFSharedUtils.paramNull(remt9000DAO)) {
            
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( RemoteServiceUtil.getThreadLocalRequest().getSession().getServletContext());

            remt9000DAO = (Remt9000DAO) wac.getBean("Remt9000DAO" ); 
        }
         
        try {
              
             for (BaseModel objectBm : listObjects) { 
                 
                 Remt9000VO  remt9000Vo = new Remt9000VO();
                  
                 remt9000Vo.setDpobCd(MSFSharedUtils.defaultNulls(objectBm.get("dpobCd"),sessionUser.getDpobCd()));    /** column 사업장코드 : dpobCd */
                 remt9000Vo.setSystemkey(MSFSharedUtils.allowNulls(objectBm.get("systemkey")));    /** column SYSTEMKEY : systemkey */
                 remt9000Vo.setSevePayClutMangeNum(MSFSharedUtils.defaultNulls(objectBm.get("sevePayClutMangeNum"),"0"));    /** column 퇴직금정산관리번호 : sevePayClutMangeNum */
                 remt9000Vo.setCalcSevePayPsnBlggYr(MSFSharedUtils.allowNulls(objectBm.get("calcSevePayPsnBlggYr")));    /** column 퇴직정산귀속년도 : calcSevePayPsnBlggYr */
                 remt9000Vo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(objectBm.get("calcSevePayPsnDivCd$commCd")));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
                 
                 remt9000Vo.setIcncDt(MSFSharedUtils.paramNull(objectBm.get("icncDt")) ? "" : new SimpleDateFormat("yyyyMMdd").format(objectBm.get("icncDt")));    /** column 입사일자 : icncDt */
                 remt9000Vo.setRkfcdDt(MSFSharedUtils.paramNull(objectBm.get("rkfcdDt")) ? "" : new SimpleDateFormat("yyyyMMdd").format(objectBm.get("rkfcdDt")));    /** column 기산일자 : rkfcdDt */
                 remt9000Vo.setRsgtnDt(MSFSharedUtils.paramNull(objectBm.get("rsgtnDt")) ? "" : new SimpleDateFormat("yyyyMMdd").format(objectBm.get("rsgtnDt")));    /** column 퇴사일자 : rsgtnDt */
                 remt9000Vo.setPymtDt(MSFSharedUtils.paramNull(objectBm.get("pymtDt")) ? "" : new SimpleDateFormat("yyyyMMdd").format(objectBm.get("pymtDt")));    /** column 지급일자 : pymtDt */
                 
                 remt9000Vo.setEepnMnthIcm2012Bfr(new BigDecimal(MSFSharedUtils.defaultNulls(objectBm.get("eepnMnthIcm2012Bfr"),"0")));    /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
                 remt9000Vo.setEepnMnthIcm2013Aft(new BigDecimal(MSFSharedUtils.defaultNulls(objectBm.get("eepnMnthIcm2013Aft"),"0")));    /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
                 remt9000Vo.setAddMnthIcm2012Bfr(new BigDecimal(MSFSharedUtils.defaultNulls(objectBm.get("addMnthIcm2012Bfr"),"0")));    /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
                remt9000Vo.setAddMnthIcm2013Aft(new BigDecimal(MSFSharedUtils.defaultNulls(objectBm.get("addMnthIcm2013Aft"),"0")));    /** column 가산월수_2013이후 : addMnthIcm2013Aft */
                remt9000Vo.setRetryPayQnty(new BigDecimal(MSFSharedUtils.defaultNulls(objectBm.get("retryPayQnty"),"0")));    /** column 퇴직급여액 : retryPayQnty */
                remt9000Vo.setFreeDtyRetryPayQnty(new BigDecimal(MSFSharedUtils.defaultNulls(objectBm.get("freeDtyRetryPayQnty"),"0")));    /** column 비과세퇴직급여액 : freeDtyRetryPayQnty */
                remt9000Vo.setAlpayTxAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(objectBm.get("alpayTxAmnt"),"0")));    /** column 기납부세액 : alpayTxAmnt */
                
                remt9000Vo.setSevePayCtrClutNoteCtnt(MSFSharedUtils.allowNulls(objectBm.get("sevePayCtrClutNoteCtnt")));    /** column 퇴직금중간정산비고내용 : sevePayCtrClutNoteCtnt */
                //remt9000Vo.setKybdr(record.get("kybdr"));    /** column 입력자 : kybdr */
                //remt9000Vo.setInptDt(record.get("inptDt"));    /** column 입력일자 : inptDt */
                //remt9000Vo.setInptAddr(record.get("inptAddr"));    /** column 입력주소 : inptAddr */
                //remt9000Vo.setIsmt(record.get("ismt"));    /** column 수정자 : ismt */
                //remt9000Vo.setRevnDt(record.get("revnDt"));    /** column 수정일자 : revnDt */
                //remt9000Vo.setRevnAddr(record.get("revnAddr"));    /** column 수정주소 : revnAddr */
 
                   
                 switch (actionDatabase) {
                 case INSERT: 
                     remt9000DAO.insertRemt9000(remt9000Vo); 
                     break;
                 case UPDATE:  
                     remt9000DAO.updateRemt9000(remt9000Vo); 
                     break;
                 case DELETE: 
                     remt9000DAO.deleteRemt9000(remt9000Vo);
                     break;
                 } 
                
        
            } 
         } catch (Exception ex) {
        	 
             logger.error("EXCEPTION calling activityOnSysm0100Cud(): "+ex); 
             ex.printStackTrace();
             
             /** 에러 로그 **/			
             MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), ex, "퇴직정산", "REMT");
             
             result = "0";
             throw MSFServerUtils.getOperationException("activityOnSysm0100Save()", ex, logger);
             
         }finally {
           
         }
        
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
	     * D:delete		S:select	B:배치 
	     * L:로그인		O:로그아웃
	     */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
		
        return lsBmResult;
     }   
    
    
    public PagingLoadResult<BaseModel> getSelectRemt0400ToRemt9000List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_REMT9000_DATA_LIST;
        Remt9000SrhVO   remt9000SrhVo = new Remt9000SrhVO();
        Remt9000VO      remt9000Vo = new Remt9000VO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(remt9000DAO)) {
        
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext(RemoteServiceUtil.getThreadLocalRequest().getSession().getServletContext());

            remt9000DAO = (Remt9000DAO) wac.getBean("Remt9000DAO" ); 
        }
        
        try {
           
           // Remt9000BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
            List<String> listDeptCd = new ArrayList<String>();
            /** 조건절 */ 
            
            remt9000SrhVo.setDpobCd(sessionUser.getDpobCd());    /** column 사업장코드 : dpobCd */
            
            
            remt9000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드 
              
            remt9000SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnDivCd")));  //정산구분 
            remt9000SrhVo.setCalcSevePayPsnBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnBlggYr")) ); //귀속년도
             
            
            
            remt9000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
            remt9000SrhVo.setUsrId(sessionUser.getUsrId());  
            
            
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	remt9000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               remt9000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
               remt9000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	remt9000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
                     if (remt9000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	remt9000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                     	remt9000SrhVo.setDeptCd("");  //부서코드
                     } else {
                    	 remt9000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          remt9000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
            
            remt9000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            remt9000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
            
//            String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//            if ("FALSE".equals(chkTypOccuCd)) {
//            	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//            	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//            } else {
//            	
//            }
            
           /******************************** 권한 ************************************************************************/
              
            
            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
            remt9000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
            remt9000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
           
//            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//            remt3100SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//            remt3100SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
             
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            remt9000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            remt9000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
            
            
           
            remt9000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
            remt9000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            remt9000SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
             
            
            remt9000SrhVo.setSevePayClutMangeNum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "sevePayClutMangeNum")));    /** column 퇴직금정산관리번호 : sevePayClutMangeNum */
             
            //sysComSrhVo.setRpsttvCd(strCriteriaValue); 
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
                if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = remt9000DAO.selectRemt9000ListTotCnt(remt9000SrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectRemt9000List = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            remt9000SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                remt9000SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                remt9000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = remt9000DAO.selectRemt9000List(remt9000SrhVo);
            
                Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("sevePayClutMangeNum").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectRemt9000List, "selectRemt9000List");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    } 
}
