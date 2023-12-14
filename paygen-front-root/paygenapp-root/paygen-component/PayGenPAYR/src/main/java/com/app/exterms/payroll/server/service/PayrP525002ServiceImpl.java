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

import com.any.smrmf.utils.BeanFinder;
import com.app.exterms.payroll.client.dto.Payr0417DTO;
import com.app.exterms.payroll.client.service.PayrP525002Service;
import com.app.exterms.payroll.server.service.dao.Payr0416DAO;
import com.app.exterms.payroll.server.service.dao.Payr0417DAO;
import com.app.exterms.payroll.server.vo.Payr0416SrhVO;
import com.app.exterms.payroll.server.vo.Payr0417VO;
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

@Service("PayrP525002Service")
public class PayrP525002ServiceImpl extends AbstractCustomServiceImpl implements PayrP525002Service , PayrDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(PayrP525002ServiceImpl.class);
	private static final String calledClass = PayrP525002ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="Payr0416DAO")
    private Payr0416DAO payr0416DAO;
    
	
	@Autowired
    @Resource(name="Payr0417DAO")
    private Payr0417DAO payr0417DAO;
	
	public PagingLoadResult<BaseModel> getPayr150002Payr0416DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR150002TOPAYR0410_DATA_LIST;
        Payr0416SrhVO   payr0416SrhVO = new Payr0416SrhVO();
        
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
       
        try {
        	
        	payr0416DAO = (Payr0416DAO)BeanFinder.getBean("Payr0416DAO");
        	
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
            payr0416SrhVO.setDpobCd(sessionUser.getDpobCd());
            payr0416SrhVO.setPayYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payYr")));
            payr0416SrhVO.setPayrImcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrImcd")));
            payr0416SrhVO.setItemNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "itemNm")));
            payr0416SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));
       
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0416DAO.selectPayr525002ToPayr0416ListTotCnt(payr0416SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 

                
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0415DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0416SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0416SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	payr0416SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            	
            }
            
            

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0416DAO.selectPayr525002ToPayr0416List(payr0416SrhVO);
            
	        Iterator<Map<String, Object>> iter = list.iterator();
	            
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
        
            while ( iter.hasNext() ) {
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
            	
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("payrImcd").toString();
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
                  	
                    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
                    
                    if("createYn".equals(tableAttributes[i].getName())){
                    	if(null == baseModelValue || "".equals(baseModelValue)){
                    		baseModelValue = false;
                    	}
                    }
                    	bm.set(tableAttributes[i].getName(), baseModelValue); 
                }

                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
                bmResult.add(bm);
            } 

            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0415DataList, "getPayr0415DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
		}

		return retval;
	}

	
		
	/** 직종세지급항목일괄생성 **/
	@Override
	public Long activityOnPayr525002ToPayr0417Insert(List<BaseModel> list, Payr0417DTO payr0417Dto)   throws MSFException {
	    	
		if  (MSFSharedUtils.paramNull(payr0417DAO)) {
	             
			WebApplicationContext wac = WebApplicationContextUtils.
					getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

			payr0417DAO = (Payr0417DAO) wac.getBean("Payr0417DAO" ); 
		}
	    	 
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    	
		Long result = new Long(1);
		Long iCnt = new Long(0);
			
		try { 
	            
			Iterator<BaseModel> iterRecords = (Iterator<BaseModel>) list.iterator();
			
			while (iterRecords.hasNext()) {
				
				
				BaseModel bmMapModel = (BaseModel) iterRecords.next();
					 
				Payr0417VO payr0417Vo = new Payr0417VO();

		        payr0417Vo.setDpobCd(sessionUser.getDpobCd());									/** column 사업장코드 : dpobCd */
		        payr0417Vo.setPayYr(payr0417Dto.getPayYr());    								/** column 급여년도 : payYr */
//		        payr0417Vo.setTypOccuGrdeMppgSeilNum(new BigDecimal(bmMapModel.get("typOccuGrdeMppgSeilNum").toString()));    /** column 직종등급맵핑일련번호 : typOccuGrdeMppgSeilNum */
		        payr0417Vo.setDtilOccuDlySeilNum(new BigDecimal(bmMapModel.get("dtilOccuDlySeilNum").toString()));	/** column  직종세단가항목일련번호 : dtilOccuDlySeilNum  */
		        
		        
		        payr0417Vo.setPayrMangDeptCd(payr0417Dto.getPayrMangDeptCd());					/** column 급여관리부서코드 : payrMangDeptCd */
		        payr0417Vo.setPayrImcd(payr0417Dto.getPayrImcd());								/** column 급여항목코드 : payrImcd */
		        payr0417Vo.setItemNm(payr0417Dto.getItemNm());    								/** column 항목명 : itemNm */
		        payr0417Vo.setPayCd(payr0417Dto.getPayCd());    								/** column 급여구분코드 : payCd */
		        payr0417Vo.setPymtDducDivCd(payr0417Dto.getPymtDducDivCd());    				/** column 지급공제구분코드 : pymtDducDivCd */
		        payr0417Vo.setPymtDducFrmCd(payr0417Dto.getPymtDducFrmCd());    				/** column 지급공제유형코드 : pymtDducFrmCd */
		        payr0417Vo.setPymtDducRate(new BigDecimal(MSFSharedUtils.defaultNulls(payr0417Dto.getPymtDducRate(),"0")));	/** column 지급공제율 : pymtDducRate */
		        payr0417Vo.setPymtDducSum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0417Dto.getPymtDducSum(),"0")));	/** column 지급공제액 : pymtDducSum */
		        payr0417Vo.setTxtnDivCd(payr0417Dto.getTxtnDivCd());							/** column 과세구분코드 : txtnDivCd */
		            
		        if(null == payr0417Dto.getFreeDtyRate()){
		        	payr0417Vo.setFreeDtyRate(BigDecimal.ZERO);    								/** column 비과세율 : freeDtyRate */
		        }else{
		        	payr0417Vo.setFreeDtyRate(new BigDecimal(payr0417Dto.getFreeDtyRate())); 	/** column 비과세율 : freeDtyRate */
		        }
		        
		        if(null == payr0417Dto.getFreeDtySum()){
		        	payr0417Vo.setFreeDtySum(BigDecimal.ZERO);    								/** column 비과세금액 : freeDtySum */
		    	}else{
		    		payr0417Vo.setFreeDtySum(new BigDecimal(payr0417Dto.getFreeDtySum()));		/** column 비과세금액 : freeDtySum */
		    	}
		            
		            
		            
		        /** JAN */
		        payr0417Vo.setJan(payr0417Dto.getJan());
		            
		        /** FEB */
		        payr0417Vo.setFeb(payr0417Dto.getFeb());
		            
		        /** MAR */
		        payr0417Vo.setMar(payr0417Dto.getMar());
		            
		        /** APR */
		        payr0417Vo.setApr(payr0417Dto.getApr());
		            
		        /** MAY */
		        payr0417Vo.setMay(payr0417Dto.getMay());
		            
		        /** JUN */
		        payr0417Vo.setJun(payr0417Dto.getJun());
		            
		        /** JUL */
		        payr0417Vo.setJul(payr0417Dto.getJul());
		            
		        /** AUG */
		        payr0417Vo.setAug(payr0417Dto.getAug());
		            
		        /** SEP */
		        payr0417Vo.setSep(payr0417Dto.getSep());
		            
		        /** OCT */
		        payr0417Vo.setOct(payr0417Dto.getOct());
		            
		        /** NOV */
		        payr0417Vo.setNov(payr0417Dto.getNov());
		            
		        /** DEC */
		        payr0417Vo.setDec(payr0417Dto.getDec());
		            
		        if(null == payr0417Dto.getRngeOrd()){
		        	payr0417Vo.setRngeOrd(BigDecimal.ZERO);    										/** column 정렬순서 : rngeOrd */
		        }else{		
		        	payr0417Vo.setRngeOrd(new BigDecimal(payr0417Dto.getRngeOrd()));    			/** column 정렬순서 : rngeOrd */
		        }
		        
		        
		        payr0417Vo.setPayItemUseYn(payr0417Dto.getPayItemUseYn());  						/** column 급여항목사용여부 : payItemUseYn */
		            
		        payr0417Vo.setItemApptnBgnnDt(payr0417Dto.getItemApptnBgnnDt());    				/** column 항목적용시작일자 : itemApptnBgnnDt */
		        payr0417Vo.setItemApptnEndDt(payr0417Dto.getItemApptnEndDt());    					/** column 항목적용종료일자 : itemApptnEndDt */
		        payr0417Vo.setDayMnthAmntDivCd(payr0417Dto.getDayMnthAmntDivCd());					/** column 일월액구분코드 : dayMnthAmntDivCd */
		        payr0417Vo.setCalcStdDivCd(payr0417Dto.getCalcStdDivCd());    						/** column 계산기준구분코드 : calcStdDivCd */
		        payr0417Vo.setEmymtDivCd(payr0417Dto.getEmymtDivCd());								/** column 고용구분코드 : emymtDivCd */

		        /** USALY_AMNT_YN */
		        payr0417Vo.setUsalyAmntYn(payr0417Dto.getUsalyAmntYn());  							/** column 통상임금여부 : usalyAmntYn */
		          
		     	payr0417Vo.setPayItemNoteCtnt(payr0417Dto.getPayItemNoteCtnt());    				/** column 급여항목비고내용 : payItemNoteCtnt */
		     	payr0417Vo.setCalcStdFunc(payr0417Dto.getCalcStdFunc());    						/** column 계산수식내용 : calcStdFunc */
					
		     	payr0417Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */
		     	payr0417Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
		     	payr0417Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  /** column 입력주소 : inptAddr */
		     	payr0417Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  /** column 수정주소 : revnAddr */
		            
		            
		     	payr0417DAO.pP525002ToDeletePayr0417_D(payr0417Vo);
		     	payr0417DAO.insertPayr0417(payr0417Vo);
		            

			}

		} catch (Exception ex) {
	            
	            logger.error("EXCEPTION calling activityOnPayr525002ToPayr0417Insert(): "+ex); 
	            result = new Long(0);
	            throw MSFServerUtils.getOperationException("activityOnPayr525002ToPayr0417Insert", ex, logger);
	            
		}finally {
	          
		}
		
		return result; 
	}
	
 
}
