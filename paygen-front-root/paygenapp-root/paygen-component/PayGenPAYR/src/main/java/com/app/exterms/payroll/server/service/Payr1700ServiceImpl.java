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

import com.app.exterms.payroll.client.dto.Psnl0130DTO;
import com.app.exterms.payroll.client.service.Payr1700Service;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.exterms.prgm.server.service.dao.PrgmComPsnl0100DAO;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.personal.server.service.dao.InfcPkgPsnl0130DAO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0130SrhVO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0130VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
@Service("Payr1700Service")
public class Payr1700ServiceImpl extends AbstractCustomServiceImpl implements Payr1700Service , PayrDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Payr1700ServiceImpl.class);
	private static final String calledClass = Payr1700ServiceImpl.class.getName();
  
	@Autowired
    @Resource(name="PrgmComPsnl0100DAO")
    private PrgmComPsnl0100DAO psnl0100DAO;
	
	@Autowired 
    @Resource(name="InfcPkgPsnl0130DAO")
    private InfcPkgPsnl0130DAO psnl0130DAO;
    
    /** ID Generation */
    //@Resource(name="{egovPsnl0130IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
 
	
	
	public PagingLoadResult<BaseModel> getSelectPayr1700List(ServiceParameters serviceParameters) throws MSFException {
		  PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_PAYR1700_DAO_LIST;
	        InfcPkgPsnl0130SrhVO   psnl0130SrhVo = new InfcPkgPsnl0130SrhVO();
	        InfcPkgPsnl0130VO      psnl0130Vo = new InfcPkgPsnl0130VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	    	// 1. 암호화 객체 생성
//	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(psnl0130DAO)) {
	        
	        	WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	        	psnl0130DAO = (InfcPkgPsnl0130DAO) wac.getBean("InfcPkgPsnl0130DAO" ); 
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
	            psnl0130SrhVo.setDpobCd(sessionUser.getDpobCd());
	            psnl0130SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));
	          
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
		         if ( pagingValues.executeRecordCount ) { 
		            	
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = psnl0130DAO.selectPsnl0130ListTotCnt(psnl0130SrhVo);  
	              
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                pagingValues.totalRecordCount = iResultCnt;	       
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginPsnl0130DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            psnl0130SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	psnl0130SrhVo.setFirstIndex(pagingValues.start);
	            }
	            
	            if (pagingValues.offsetLimit > 0) {
	            	psnl0130SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	            List list = psnl0130DAO.selectPsnl0130List(psnl0130SrhVo);
	            
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
	                    
	                    bm.set(tableAttributes[i].getName(), baseModelValue);
	                }


	                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
	                bmResult.add(bm);
	            } 

	            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
	            
	            SmrmfUtils.endTiming(logger, millisBeginPsnl0130DataList, "getPsnl0130DataList");
	       

	        }
	        catch (Exception ex) {
	        	ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
    }
 

    @Override
    public Long activityOnPayr1700Save(List<Psnl0130DTO> listPsnl0130dto)   throws MSFException {
        // TODO Auto-generated method stub
        Long result = new Long(0);
        Long iCnt = new Long(0);
        try { 
            
            InfcPkgPsnl0130SrhVO psnl0130SrhVo = new InfcPkgPsnl0130SrhVO(); 
            
            if  (MSFSharedUtils.paramNull(psnl0130DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                psnl0130DAO = (InfcPkgPsnl0130DAO) wac.getBean("InfcPkgPsnl0130DAO" ); 
            }
          
            for(int iPayrCnt=0;iPayrCnt < listPsnl0130dto.size();iPayrCnt++) {
                
                    Psnl0130DTO psnl0130Dto = new Psnl0130DTO();  
                    psnl0130Dto = listPsnl0130dto.get(iPayrCnt);
                      
                    InfcPkgPsnl0130VO psnl0130Vo = new InfcPkgPsnl0130VO(); 
                    InfcPkgPsnl0130VO tpPsnl0130Vo = new InfcPkgPsnl0130VO(); 
                       
                    psnl0130Vo.setDpobCd(MSFSharedUtils.allowNulls(psnl0130Dto.getDpobCd()));    					/** column 사업장코드 : dpobCd */
                    psnl0130Vo.setSystemkey(MSFSharedUtils.allowNulls(psnl0130Dto.getSystemkey()));    				/** column SYSTEMKEY : systemkey */ 
                    psnl0130Vo.setPayCd(MSFSharedUtils.allowNulls(psnl0130Dto.getPayCd()));    							/** column 급여구분코드 : payCd */
//                    psnl0130Vo.setBnkCd(MSFSharedUtils.allowNulls(psnl0130Dto.getBnkCd()));    						/** column 은행코드 : bnkCd */
//                    psnl0130Vo.setBnkAccuNum(MSFSharedUtils.allowNulls(psnl0130Dto.getBnkAccuNum()));    		/** column 은행계좌번호 : bnkAccuNum */
//                    psnl0130Vo.setAcntHodrNm(MSFSharedUtils.allowNulls(psnl0130Dto.getAcntHodrNm()));   		/** column 예금주명 : acntHodrNm */
//                    psnl0130Vo.setRpsttvAccuYn(Boolean.TRUE.equals(psnl0130Dto.getRpsttvAccuYn()) ? "Y" : "N");   /** column 대표계좌여부 : rpsttvAccuYn */
//                    psnl0130Vo.setAccuNoteCtnt(MSFSharedUtils.allowNulls(psnl0130Dto.getAccuNoteCtnt()));   		 /** column 계좌비고내용 : accuNoteCtnt */
//                    psnl0130Vo.setKybdr(kybdr);    /** column 입력자 : kybdr */
//                    psnl0130Vo.setInptDt(inptDt);    /** column 입력일자 : inptDt */
//                    psnl0130Vo.setInptAddr(inptAddr);    /** column 입력주소 : inptAddr */
//                    psnl0130Vo.setIsmt(ismt);    /** column 수정자 : ismt */
//                    psnl0130Vo.setRevnDt(revnDt);    /** column 수정일자 : revnDt */
//                    psnl0130Vo.setRevnAddr(revnAddr);    /** column 수정주소 : revnAddr */
                     
                    
//                    tpPsnl0130Vo = psnl0130DAO.selectPsnl0130(psnl0130Vo);
                    int  intPsnl0130List = psnl0130DAO.selectPayr1700ToPsnl0130_S(psnl0130Vo);
                    
                    if (intPsnl0130List <= 0) { 
                    	
                        psnl0130Vo.setBnkCd(MSFSharedUtils.allowNulls(psnl0130Dto.getBnkCd()));    						/** column 은행코드 : bnkCd */
                        psnl0130Vo.setBnkAccuNum(MSFSharedUtils.allowNulls(psnl0130Dto.getBnkAccuNum()));    			/** column 은행계좌번호 : bnkAccuNum */
                        psnl0130Vo.setAcntHodrNm(MSFSharedUtils.allowNulls(psnl0130Dto.getAcntHodrNm()).trim());   		/** column 예금주명 : acntHodrNm */
                        psnl0130Vo.setRpsttvAccuYn(Boolean.TRUE.equals(psnl0130Dto.getRpsttvAccuYn()) ? "Y" : "N"); 	/** column 대표계좌여부 : rpsttvAccuYn */
                        psnl0130Vo.setAccuNoteCtnt(MSFSharedUtils.allowNulls(psnl0130Dto.getAccuNoteCtnt()));			/** column 계좌비고내용 : accuNoteCtnt */
                    	
                        psnl0130DAO.insertPsnl0130(psnl0130Vo); 
                        
                        iCnt = iCnt + 1;
                        
                    } else if (intPsnl0130List >= 2){
                	  
          				MSFErrorMessage errMsg = new MSFErrorMessage("", "", 2, "이미 등록된 계좌정보가 존재합니다. 데이터를 확인해주세요."); 
          				throw MSFServerUtils.getValidationException("activityOnPayr1700Save", errMsg, logger) ; 
                  
                    }else if(intPsnl0130List == 1) {
                    	
                      psnl0130Vo.setBnkCd(MSFSharedUtils.allowNulls(psnl0130Dto.getBnkCd()));    					/** column 은행코드 : bnkCd */
                      psnl0130Vo.setBnkAccuNum(MSFSharedUtils.allowNulls(psnl0130Dto.getBnkAccuNum()));    			/** column 은행계좌번호 : bnkAccuNum */
                      psnl0130Vo.setAcntHodrNm(MSFSharedUtils.allowNulls(psnl0130Dto.getAcntHodrNm().trim()));   	/** column 예금주명 : acntHodrNm */
                      psnl0130Vo.setRpsttvAccuYn(Boolean.TRUE.equals(psnl0130Dto.getRpsttvAccuYn()) ? "Y" : "N");   /** column 대표계좌여부 : rpsttvAccuYn */
                      psnl0130Vo.setAccuNoteCtnt(MSFSharedUtils.allowNulls(psnl0130Dto.getAccuNoteCtnt()));   		/** column 계좌비고내용 : accuNoteCtnt */
                    	
                      psnl0130DAO.updatePsnl0130(psnl0130Vo); 
                      iCnt = iCnt + 1;
                      
                    }
                   
//                    if (tpPsnl0130Vo == null) { 
//                      
//                          psnl0130DAO.insertPsnl0130(psnl0130Vo); 
//                          iCnt = iCnt + 1;
//                    } else {
//                          psnl0130DAO.updatePsnl0130(psnl0130Vo); 
//                          iCnt = iCnt + 1;
//                    }       
                          
                    
               } 
                result = iCnt;
          
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr1500BfToNew(): "+ex); 
            result = new Long(0);
        }
        finally {
          
        }
        
        return result;
    }


    @Override
    public Long activityOnPayr1700Delete(List<BaseModel> listModels)  throws MSFException {
        // TODO Auto-generated method stub
        Long result = new Long(0);
        Long iCnt = new Long(0);
        try { 
            
            InfcPkgPsnl0130VO psnl0130Vo = new InfcPkgPsnl0130VO(); 
            
            if  (MSFSharedUtils.paramNull(psnl0130DAO)) {
                
                WebApplicationContext wac = WebApplicationContextUtils.
                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

                psnl0130DAO = (InfcPkgPsnl0130DAO) wac.getBean("InfcPkgPsnl0130DAO" ); 
            }
      
         
                Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)listModels.iterator();
                while (iterRecords.hasNext()) {
                  
                    BaseModel bmMapModel = (BaseModel) iterRecords.next();
                       
                    psnl0130Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd"))); 
                    psnl0130Vo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey"))) ; 
                    psnl0130Vo.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd$commCd"))) ; 
                     
                    psnl0130DAO.deletePsnl0130(psnl0130Vo);  
                  
                    iCnt = iCnt + 1;
                     
               } 
                result = iCnt;
          
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr1300Delete(): "+ex); 
            result = new Long(0);
        }
        finally {
          
        }
        
        return result;
    }
}