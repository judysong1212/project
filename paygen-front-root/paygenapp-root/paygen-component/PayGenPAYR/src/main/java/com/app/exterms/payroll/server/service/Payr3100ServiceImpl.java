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
import com.app.exterms.payroll.client.dto.Payr0220DTO;
import com.app.exterms.payroll.client.service.Payr3100Service;
import com.app.exterms.payroll.server.service.dao.Payr0220DAO;
import com.app.exterms.payroll.server.vo.Payr0220SrhVO;
import com.app.exterms.payroll.server.vo.Payr0220VO;
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

@Service("Payr3100Service")
public class Payr3100ServiceImpl extends AbstractCustomServiceImpl implements Payr3100Service  ,PayrDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Payr3100ServiceImpl.class);
	private static final String calledClass = Payr3100ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="Payr0220DAO")
    private Payr0220DAO payr0220DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPayr0220IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	public PagingLoadResult<BaseModel> getPayr0220DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0220_DATA_LIST;
        Payr0220SrhVO   payr0220SrhVO = new Payr0220SrhVO();
        Payr0220VO      payr0220VO = new Payr0220VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest()); 
        payr0220DAO = (Payr0220DAO)BeanFinder.getBean("Payr0220DAO");
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Sysm0220BM          user             = serviceParameters.getUser();
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
          
            payr0220SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            payr0220SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
            
            payr0220SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
             
            payr0220SrhVO.setUsrId(sessionUser.getUsrId());  
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	
        	    if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {

                	payr0220SrhVO.setDeptCd(sessionUser.getDeptCd()); 
                   listDeptCd.add(sessionUser.getDeptCd());
                   payr0220SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
                    
            	   } else {
            		   payr0220SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                       listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                       payr0220SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
            		 
            	  }  
        	    
               payr0220SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	payr0220SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
                     if (payr0220SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	payr0220SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	payr0220SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	 payr0220SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          payr0220SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
            
//            String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//            if ("FALSE".equals(chkTypOccuCd)) {
//            	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//            	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//            } else {
//            	
//            }
            
            payr0220SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            payr0220SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
           
            payr0220SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
            payr0220SrhVO.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도 
            
            
            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
            payr0220SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
            payr0220SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
            
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0220SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0220SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
             
           
//            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//            payr0220SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//            payr0220SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
              
            
            payr0220SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            payr0220SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
            
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0220DAO.selectPayr0220ListTotCnt(payr0220SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0220DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0220SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0220SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0220SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0220DAO.selectPayr0220List(payr0220SrhVO);
            
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
                    
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0220DataList, "getPayr0220DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	

    @Override
    public Long activityOnPayr0220Save(Payr0220DTO payr0220Dto, ActionDatabase actionDatabase) {
        // TODO Auto-generated method stub
        // TODO Auto-generated method stub
        Long result = new Long(1);
        
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        try { 
          
        	payr0220DAO = (Payr0220DAO)BeanFinder.getBean("Payr0220DAO");
            
            Payr0220VO payr0220Vo = new Payr0220VO(); 
            
            payr0220Vo.setDpobCd(payr0220Dto.getDpobCd());    													/** column 사업장코드 : dpobCd */
            payr0220Vo.setSystemkey(payr0220Dto.getSystemkey());    											/** column SYSTEMKEY : systemkey */
            payr0220Vo.setProvAthmSeilNum(new BigDecimal(payr0220Dto.getProvAthmSeilNum()));					/** column 가압류일련번호 : provAthmSeilNum */
            payr0220Vo.setIcntNum(payr0220Dto.getIcntNum());    												/** column 사건번호 : icntNum */
            payr0220Vo.setIcntNm(payr0220Dto.getIcntNm());    													/** column 사건명 : icntNm */
            payr0220Vo.setCdtrNm(payr0220Dto.getCdtrNm());    													/** column 채권자명 : cdtrNm */
            payr0220Vo.setBondIstut(payr0220Dto.getBondIstut());    											/** column 채권기관 : bondIstut */
            payr0220Vo.setBnkCd(payr0220Dto.getBnkCd());    													/** column 은행코드 : bnkCd */
            payr0220Vo.setBnkAccuNum(payr0220Dto.getBnkAccuNum());    											/** column 은행계좌번호 : bnkAccuNum */
            payr0220Vo.setAcntHodrNm(payr0220Dto.getAcntHodrNm());    											/** column 예금주명 : acntHodrNm */
            payr0220Vo.setRcptDt(payr0220Dto.getRcptDt());    													/** column 접수일자 : rcptDt */
            payr0220Vo.setDlvyDt(payr0220Dto.getDlvyDt());    													/** column 송달일자 : dlvyDt */
            payr0220Vo.setDducPridBgnnDt(payr0220Dto.getDducPridBgnnDt());    									/** column 공제기간시작일자 : dducPridBgnnDt */
            payr0220Vo.setDducPridEndDt(payr0220Dto.getDducPridEndDt());    									/** column 공제기간종료일자 : dducPridEndDt */
            payr0220Vo.setBondFrclrEndYn((Boolean.TRUE.equals(payr0220Dto.getBondFrclrEndYn()) ? "Y" : "N"));	/** column 채권압류종료여부 : bondFrclrEndYn */
            payr0220Vo.setPayDducYn((Boolean.TRUE.equals(payr0220Dto.getPayDducYn()) ? "Y" : "N"));    			/** column 급여공제여부 : payDducYn */
            payr0220Vo.setClmSum(new BigDecimal(payr0220Dto.getClmSum()));    									/** column 청구금액 : clmSum */
            
            /**!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! 
             * 청구금액 대비 현재 급여에서 공제할수 있는 금액을 구하여 공제금액을 구한다. 제한금액도 구함.화면에 표시...
             * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
             */
            
            
            payr0220Vo.setClmBaln(new BigDecimal(payr0220Dto.getClmBaln()));    								/** column 청구잔액 : clmBaln */
            payr0220Vo.setBondFrclrLmtSum(new BigDecimal(payr0220Dto.getBondFrclrLmtSum()));    				/** column 채권압류제한금액 : bondFrclrLmtSum */
            payr0220Vo.setAcmlteDducSum(new BigDecimal(payr0220Dto.getAcmlteDducSum()));    					/** column 누적공제금액 : acmlteDducSum */
            payr0220Vo.setDducSum(new BigDecimal(payr0220Dto.getDducSum()));    								/** column 공제금액 : dducSum */
            payr0220Vo.setDducRto(new BigDecimal(payr0220Dto.getDducRto()));    								/** column 공제비율 : dducRto */
            payr0220Vo.setProvAthmNoteCtnt(payr0220Dto.getProvAthmNoteCtnt());    								/** column 가압류비고내용 : provAthmNoteCtnt */
//            payr0220Vo.setKybdr(payr0220Dto.getKybdr());    /** column 입력자 : kybdr */
//            payr0220Vo.setInptDt(payr0220Dto.getInptDt());    /** column 입력일자 : inptDt */
//            payr0220Vo.setInptAddr(payr0220Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//            payr0220Vo.setIsmt(payr0220Dto.getIsmt());    /** column 수정자 : ismt */
//            payr0220Vo.setRevnDt(payr0220Dto.getRevnDt());    /** column 수정일자 : revnDt */
//            payr0220Vo.setRevnAddr(payr0220Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
  
            
            switch (actionDatabase) {
            case INSERT:
                payr0220DAO.insertPayr0220(payr0220Vo); 
               break;
            case UPDATE: 
                payr0220DAO.updatePayr0220(payr0220Vo); 
                break;
            case DELETE: 
                payr0220DAO.deletePayr0220(payr0220Vo); 
                break;
            }
            
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr0400Save(): "+ex); 
            result = new Long(0);
        }
        finally {
          
        }
        return result; 
    }


 
    
}
