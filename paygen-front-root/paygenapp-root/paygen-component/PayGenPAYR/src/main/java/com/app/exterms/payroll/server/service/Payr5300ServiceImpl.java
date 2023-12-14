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
import com.app.exterms.payroll.client.dto.Payr0490DTO;
import com.app.exterms.payroll.client.service.Payr5300Service;
import com.app.exterms.payroll.server.service.dao.Payr0490DAO;
import com.app.exterms.payroll.server.vo.Payr0490SrhVO;
import com.app.exterms.payroll.server.vo.Payr0490VO;
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
import com.app.smrmf.infc.basis.server.service.dao.InfcPkgBass0500DAO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0500SrhVO;
import com.app.smrmf.infc.basis.server.vo.InfcPkgBass0500VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Payr5300Service")
public class Payr5300ServiceImpl extends AbstractCustomServiceImpl implements Payr5300Service, PayrDaoConstants{


	private static final Logger logger = LoggerFactory.getLogger(Payr5300ServiceImpl.class);
	private static final String calledClass = Payr5300ServiceImpl.class.getName();
	
	
	@Autowired
    @Resource(name="Payr0490DAO")
    private Payr0490DAO payr0490DAO;
	
	
	@Autowired
    @Resource(name="InfcPkgBass0500DAO")
    private InfcPkgBass0500DAO infcPkgBass0500DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPayr0490IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;

	
	
	public PagingLoadResult<BaseModel> getPayr0490DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0490_DATA_LIST;
        Payr0490SrhVO   payr0490SrhVO = new Payr0490SrhVO();
        Payr0490VO      payr0490VO = new Payr0490VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
      
        try {
        	
        	payr0490DAO = (Payr0490DAO)BeanFinder.getBean("Payr0490DAO");
        	
        	
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
            payr0490SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0490SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
            payr0490SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));
            payr0490SrhVO.setPymtDducDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtDducDivCd")));
            payr0490SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
            payr0490SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));
          
               //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0490DAO.selectPayr0490ListTotCnt(payr0490SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                } 
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0490DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0490SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0490SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.totalRecordCount < 100) {
                payr0490SrhVO.setLastIndex(pagingValues.totalRecordCount); 
            } else if (pagingValues.offsetLimit > 0) {
            	payr0490SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0490DAO.selectPayr0490List(payr0490SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payItemCd").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0490DataList, "getPayr0490DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	

    @Override
    public Long activityOnPayr5300(Payr0490DTO payr0490Dto, ActionDatabase actionDatabase) {
        Long result = new Long(1);
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        try { 
          
            Payr0490VO payr0490Vo = new Payr0490VO(); 
            
            
            payr0490Vo.setDpobCd(payr0490Dto.getDpobCd());    												/** column 사업장코드 : dpobCd */
            payr0490Vo.setPayYr(payr0490Dto.getPayYr());    												/** column 급여년도 : payYr */
            payr0490Vo.setBusinCd(payr0490Dto.getBusinCd());    											/** column 사업코드 : businCd */
            payr0490Vo.setDeptCd(payr0490Dto.getDeptCd());    												/** column 부서코드 : deptCd */
            payr0490Vo.setPayrUcstDgmSeilNum(new BigDecimal(payr0490Dto.getPayrUcstDgmSeilNum())); 		 	/** column 급여단가표일련번호 : payrUcstDgmSeilNum */
            payr0490Vo.setPayrMangDeptCd(payr0490Dto.getPayrMangDeptCd());    								/** column 급여관리부서코드 : payrMangDeptCd */
            payr0490Vo.setPayCd(payr0490Dto.getPayCd());    												/** column 급여구분코드 : payCd */
            payr0490Vo.setPayItemCd(payr0490Dto.getPayItemCd());    										/** column 급여항목코드 : payItemCd */
            payr0490Vo.setItemNm(payr0490Dto.getItemNm());    												/** column 항목명 : itemNm */
            payr0490Vo.setPymtDducDivCd(payr0490Dto.getPymtDducDivCd());    								/** column 지급공제구분코드 : pymtDducDivCd */
            payr0490Vo.setPymtDducFrmCd(payr0490Dto.getPymtDducFrmCd());    								/** column 지급공제유형코드 : pymtDducFrmCd */
            payr0490Vo.setPymtDducRate(new BigDecimal(payr0490Dto.getPymtDducRate()));    					/** column 지급공제율 : pymtDducRate */
            payr0490Vo.setPymtDducSum(new BigDecimal(payr0490Dto.getPymtDducSum()));    					/** column 지급공제액 : pymtDducSum */
            payr0490Vo.setTxtnDivCd(payr0490Dto.getTxtnDivCd());    										/** column 과세구분코드 : txtnDivCd */
            payr0490Vo.setFreeDtyRate(new BigDecimal(payr0490Dto.getFreeDtyRate()));    					/** column 비과세율 : freeDtyRate */
            payr0490Vo.setFreeDtySum(new BigDecimal(payr0490Dto.getFreeDtySum()));    						/** column 비과세금액 : freeDtySum */
            payr0490Vo.setJan((Boolean.TRUE.equals(payr0490Dto.getJan()) ? "Y" : "N"));    					/** column 1월 : jan */
            payr0490Vo.setFeb((Boolean.TRUE.equals(payr0490Dto.getFeb()) ? "Y" : "N"));    					/** column 2월 : feb */
            payr0490Vo.setMar((Boolean.TRUE.equals(payr0490Dto.getMar()) ? "Y" : "N"));    					/** column 3월 : mar */
            payr0490Vo.setApr((Boolean.TRUE.equals(payr0490Dto.getApr()) ? "Y" : "N"));    					/** column 4월 : apr */
            payr0490Vo.setMay((Boolean.TRUE.equals(payr0490Dto.getMay()) ? "Y" : "N"));    					/** column 5월 : may */
            payr0490Vo.setJun((Boolean.TRUE.equals(payr0490Dto.getJun()) ? "Y" : "N"));    					/** column 6월 : jun */
            payr0490Vo.setJul((Boolean.TRUE.equals(payr0490Dto.getJul()) ? "Y" : "N"));    					/** column 7월 : jul */
            payr0490Vo.setAug((Boolean.TRUE.equals(payr0490Dto.getAug()) ? "Y" : "N"));    					/** column 8월 : aug */
            payr0490Vo.setSep((Boolean.TRUE.equals(payr0490Dto.getSep()) ? "Y" : "N"));    					/** column 9월 : sep */
            payr0490Vo.setOct((Boolean.TRUE.equals(payr0490Dto.getOct()) ? "Y" : "N"));    					/** column 10월 : oct */
            payr0490Vo.setNov((Boolean.TRUE.equals(payr0490Dto.getNov()) ? "Y" : "N"));    					/** column 11월 : nov */
            payr0490Vo.setDec((Boolean.TRUE.equals(payr0490Dto.getDec()) ? "Y" : "N"));    					/** column 12월 : dec */
            payr0490Vo.setRngeOrd(new BigDecimal(payr0490Dto.getRngeOrd()));    							/** column 정렬순서 : rngeOrd */
            payr0490Vo.setPayItemUseYn((Boolean.TRUE.equals(payr0490Dto.getPayItemUseYn()) ? "Y" : "N"));	/** column 급여항목사용여부 : payItemUseYn */
            payr0490Vo.setItemApptnBgnnDt(payr0490Dto.getItemApptnBgnnDt());    							/** column 항목적용시작일자 : itemApptnBgnnDt */
            payr0490Vo.setItemApptnEndDt(payr0490Dto.getItemApptnEndDt());    								/** column 항목적용종료일자 : itemApptnEndDt */
            payr0490Vo.setDayMnthAmntDivCd(payr0490Dto.getDayMnthAmntDivCd());   		 					/** column 일월액구분코드 : dayMnthAmntDivCd */
            payr0490Vo.setCalcStdDivCd(payr0490Dto.getCalcStdDivCd());    									/** column 계산기준구분코드 : calcStdDivCd */
            payr0490Vo.setEmymtDivCd(payr0490Dto.getEmymtDivCd());    										/** column 고용구분코드 : emymtDivCd */
            payr0490Vo.setUsalyAmntYn((Boolean.TRUE.equals(payr0490Dto.getUsalyAmntYn()) ? "Y" : "N"));    	/** column 통상임금여부 : usalyAmntYn */
            payr0490Vo.setPayItemNoteCtnt(payr0490Dto.getPayItemNoteCtnt());    							/** column 급여항목비고내용 : payItemNoteCtnt */
            payr0490Vo.setCalcStdFunc(payr0490Dto.getCalcStdFunc());    									/** column 계산수식내용 : calcStdFunc */
            payr0490Vo.setKybdr(sessionUser.getUsrId());    												/** column 입력자 : kybdr */
            payr0490Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
            payr0490Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
            payr0490Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */

     
            switch (actionDatabase) {
            case INSERT:
                payr0490DAO.insertPayr0490(payr0490Vo); 
                break;
            case UPDATE: 
                payr0490DAO.updatePayr0490(payr0490Vo); 
                 
                break;
            case DELETE: 
                payr0490DAO.deletePayr0490(payr0490Vo);
               
                break;
            }
            
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnProfilesUser(): "+ex); 
            result = new Long(0);
        }
        finally {
          
        }
        return result;
    }


    @Override
    public Long activityOnPayr0490Insert(Payr0490DTO payr0490Dto,List<BaseModel> listModels, ActionDatabase actionDatabase) {
        // TODO Auto-generated method stub
        Long result = new Long(0);
        Long iCnt = new Long(0);
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        try { 
        	
        	payr0490DAO = (Payr0490DAO)BeanFinder.getBean("Payr0490DAO");
                         
          Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)listModels.iterator();
          while (iterRecords.hasNext()) {
            
              BaseModel bmMapModel = (BaseModel) iterRecords.next();
               
              Payr0490VO payr0490Vo = new Payr0490VO();
              
              payr0490Vo.setDpobCd(payr0490Dto.getDpobCd());    										/** column 사업장코드 : dpobCd */
              payr0490Vo.setPayYr(payr0490Dto.getPayYr());    											/** column 급여년도 : payYr */
              payr0490Vo.setBusinCd(payr0490Dto.getBusinCd());    										/** column 사업코드 : businCd */
              payr0490Vo.setDeptCd(payr0490Dto.getDeptCd()) ;   										/** column 부서코드 : deptCd */
              payr0490Vo.setPayrMangDeptCd(payr0490Dto.getPayrMangDeptCd());    						/** column 급여관리부서코드 : payrMangDeptCd */
              payr0490Vo.setPayCd(payr0490Dto.getPayCd());    											/** column 급여구분코드 : payCd */
             
              payr0490Vo.setPayItemCd(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyCd")));    		/** column 급여항목코드 : payItemCd */
              payr0490Vo.setItemNm(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyNm")));    		/** column 항목명 : itemNm */
              payr0490Vo.setPymtDducDivCd(MSFSharedUtils.allowNulls(bmMapModel.get("pymtDducDivCd")));	/** column 지급공제구분코드 : pymtDducDivCd */
              
              
              payr0490Vo.setPymtDducFrmCd(payr0490Dto.getPymtDducFrmCd());    										/** column 지급공제유형코드 : pymtDducFrmCd */
              payr0490Vo.setPymtDducRate(new BigDecimal(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpyRto"))));	/** column 지급공제율 : pymtDducRate */
              payr0490Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.allowNulls(bmMapModel.get("payExtpySum"))));	/** column 지급공제액 : pymtDducSum */
              payr0490Vo.setTxtnDivCd(payr0490Dto.getTxtnDivCd());    												/** column 과세구분코드 : txtnDivCd */
              payr0490Vo.setFreeDtyRate(BigDecimal.ZERO);   	 													/** column 비과세율 : freeDtyRate */
              payr0490Vo.setFreeDtySum(BigDecimal.ZERO);    														/** column 비과세금액 : freeDtySum */
              
              payr0490Vo.setJan("Y");    /** column 1월 : jan */
              payr0490Vo.setFeb("Y");    /** column 2월 : feb */
              payr0490Vo.setMar("Y");    /** column 3월 : mar */
              payr0490Vo.setApr("Y");    /** column 4월 : apr */
              payr0490Vo.setMay("Y");    /** column 5월 : may */
              payr0490Vo.setJun("Y");    /** column 6월 : jun */
              payr0490Vo.setJul("Y");    /** column 7월 : jul */
              payr0490Vo.setAug("Y");    /** column 8월 : aug */
              payr0490Vo.setSep("Y");    /** column 9월 : sep */
              payr0490Vo.setOct("Y");    /** column 10월 : oct */
              payr0490Vo.setNov("Y");    /** column 11월 : nov */
              payr0490Vo.setDec("Y");    /** column 12월 : dec */
            
              payr0490Vo.setRngeOrd(BigDecimal.ZERO);   											/** column 정렬순서 : rngeOrd */
              payr0490Vo.setPayItemUseYn("Y");    													/** column 급여항목사용여부 : payItemUseYn */
              payr0490Vo.setItemApptnBgnnDt(payr0490Dto.getItemApptnBgnnDt());    					/** column 항목적용시작일자 : itemApptnBgnnDt */
              payr0490Vo.setItemApptnEndDt(payr0490Dto.getItemApptnEndDt());    					/** column 항목적용종료일자 : itemApptnEndDt */
              payr0490Vo.setDayMnthAmntDivCd(payr0490Dto.getDayMnthAmntDivCd());    				/** column 일월액구분코드 : dayMnthAmntDivCd */
              payr0490Vo.setCalcStdDivCd(payr0490Dto.getCalcStdDivCd());    						/** column 계산기준구분코드 : calcStdDivCd */
              payr0490Vo.setEmymtDivCd(payr0490Dto.getEmymtDivCd());    							/** column 고용구분코드 : emymtDivCd */
              payr0490Vo.setUsalyAmntYn("N");    													/** column 통상임금여부 : usalyAmntYn */
              payr0490Vo.setPayItemNoteCtnt(payr0490Dto.getPayItemNoteCtnt());    					/** column 급여항목비고내용 : payItemNoteCtnt */
              payr0490Vo.setKybdr(sessionUser.getUsrId());    										/** column 입력자 : kybdr */
              payr0490Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
              payr0490Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
              payr0490Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */

               
            switch (actionDatabase) {
            case INSERT:
                payr0490DAO.insertPayr0490(payr0490Vo); 
                break; 
            }
            
            iCnt = iCnt + 1;
              
          } 
          
          result = iCnt;
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr0400Insert(): "+ex); 
            result = new Long(0);
        }
        finally {
          
        }
        
        return result;
    }

    
	public PagingLoadResult<BaseModel> getCboBass0500PayYrList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "CLASS_BASS0500_PAY_YR";
        InfcPkgBass0500SrhVO   infcPkgBass0500SrhVO = new InfcPkgBass0500SrhVO();
        InfcPkgBass0500VO      infcPkgBass0500VO = new InfcPkgBass0500VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        infcPkgBass0500DAO = (InfcPkgBass0500DAO)BeanFinder.getBean("InfcPkgBass0500DAO");
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        
        try {
          
             ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
             IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
             List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
             PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
 	         
        	
            //Get paging configuration
             PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
             infcPkgBass0500SrhVO.setDpobCd(sessionUser.getDpobCd());
           // sysComSrhVo.setRpsttvCd(sysComBass0300Dto.getRpsttvCd());
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  infcPkgBass0500DAO.selectBass0500PayYrListTotCnt(infcPkgBass0500SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;
                      
                
               logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectBass0500PayYrList = SmrmfUtils.startTiming(logger);
         
          
            /**페이지 카운트 처리를 위한 부분 */ 
            infcPkgBass0500SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	infcPkgBass0500SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.totalRecordCount < 100) {
            	infcPkgBass0500SrhVO.setLastIndex(pagingValues.totalRecordCount); 
            } else  if (pagingValues.offsetLimit > 0) {
            	infcPkgBass0500SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            } 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ?????? 
            List list = infcPkgBass0500DAO.selectBass0500PayYrList(infcPkgBass0500SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payYr").toString();
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
                    
                    bm.set(tableAttributes[i].getName(), baseModelValue);
                }
                

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginSelectBass0500PayYrList, "getCboBass0500PayYrList");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }	
  
	
}
