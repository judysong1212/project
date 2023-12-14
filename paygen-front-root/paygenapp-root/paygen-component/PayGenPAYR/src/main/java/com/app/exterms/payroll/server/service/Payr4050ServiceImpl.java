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
import com.app.exterms.payroll.client.dto.Payr0250DTO;
import com.app.exterms.payroll.client.service.Payr4050Service;
import com.app.exterms.payroll.server.service.dao.Payr0250DAO;
import com.app.exterms.payroll.server.service.dao.Payr0300DAO;
import com.app.exterms.payroll.server.vo.Payr0250SrhVO;
import com.app.exterms.payroll.server.vo.Payr0250VO;
import com.app.exterms.payroll.server.vo.Payr0300VO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.MSFConfiguration;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("Payr4050Service")
public class Payr4050ServiceImpl extends AbstractCustomServiceImpl implements Payr4050Service  ,PayrDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Payr4050ServiceImpl.class);
	private static final String calledClass = Payr4050ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="Payr0250DAO")
    private Payr0250DAO payr0250DAO;
	

	@Autowired
    @Resource(name="Payr0300DAO")
    private Payr0300DAO payr0300DAO;
	
    
    /** ID Generation */
    //@Resource(name="{egovPayr0250IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
	public PagingLoadResult<BaseModel> getPayr0250DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0250_DATA_LIST;
        Payr0250SrhVO   payr0250SrhVO = new Payr0250SrhVO();
        Payr0250VO      payr0250VO = new Payr0250VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        List<String> listDeptCd = new ArrayList<String>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
    
        payr0250DAO = (Payr0250DAO)BeanFinder.getBean("Payr0250DAO");
        
        try {
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
           
            /** 조건절 */
            payr0250SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            payr0250SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
            payr0250SrhVO.setUsrId(sessionUser.getUsrId());  

            payr0250SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            payr0250SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
            payr0250SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드  
            payr0250SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")));       //  
            payr0250SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")));    //관리부서 
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	payr0250SrhVO.setDeptCd(sessionUser.getDeptCd());  
                payr0250SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); //단위기관코드
            } else {
            	    
                	payr0250SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));    //단위기관코드
                     if (payr0250SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {  
                        payr0250SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	 payr0250SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                         
                     } 
                  
            }   
            
            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
            payr0250SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
            payr0250SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
           
//            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//            payr0250SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//            payr0250SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
             
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0250SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0250SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세 
            
            payr0250SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
            payr0250SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  //급여구분코드 
            payr0250SrhVO.setJobYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "jobYrMnth"))); //지급년 
            payr0250SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")) ); //호봉제구분
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0250DAO.selectPayr0250ListTotCnt(payr0250SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0250DataList = SmrmfUtils.startTiming(logger);
        
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
//            Collection<Map<String, Object>> list ??????
            List list = payr0250DAO.selectPayr0250List(payr0250SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0250DataList, "getPayr0250DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
  /**
	 * PAYR0250을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Payr0250VO
	 * @return void형 
	 * @exception Exception
	 */ 
	@Override
	public Long deletePayr0250(List<BaseModel> listModels, ActionDatabase actionDatabase)  throws MSFException  {
		
	    Long result = new Long(0);
        Long iCnt = new Long(0);
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
    	
        try { 
             
            payr0250DAO = (Payr0250DAO)BeanFinder.getBean("Payr0250DAO"); 
            payr0300DAO = (Payr0300DAO)BeanFinder.getBean("Payr0300DAO");
            
            Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)listModels.iterator();
            while (iterRecords.hasNext()) {
            	
            	// 1. 암호화 객체 생성
            	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
              

                Payr0250VO payr0250Vo = new Payr0250VO();
                Payr0300VO payr0300Vo = new Payr0300VO();
                Payr0300VO tpPayr0300Vo = new Payr0300VO();
                
                BaseModel bmMapModel = (BaseModel) iterRecords.next();
                 
                payr0250Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    								/** column 사업장코드 : dpobCd */
                payr0250Vo.setJobYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("jobYrMnth")));    						/** column 작업년월 : jobYrMnth */
                payr0250Vo.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd$commCd")));    							/** column 급여구분코드 : payCd */
                payr0250Vo.setPayScduSeilNum(new BigDecimal(MSFSharedUtils.allowNulls(bmMapModel.get("payScduSeilNum"))));	/** column 급여스케줄일련번호 : payScduSeilNum */
               
               
                tpPayr0300Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    							/** column 사업장코드 : dpobCd */
                tpPayr0300Vo.setPymtYrMnth(MSFSharedUtils.allowNulls(bmMapModel.get("jobYrMnth")));    						/** column 작업년월 : jobYrMnth */
                tpPayr0300Vo.setPayCd(MSFSharedUtils.allowNulls(bmMapModel.get("payCd$commCd")));    						/** column 급여구분코드 : payCd */
                tpPayr0300Vo.setPayrSeilNum(new BigDecimal(MSFSharedUtils.allowNulls(bmMapModel.get("payScduSeilNum"))));	/** column 급여스케줄일련번호 : payScduSeilNum */
                
                payr0300Vo = payr0300DAO.selectPayr0300(tpPayr0300Vo);
                
                if (MSFSharedUtils.paramNotNull(payr0300Vo)) {
                	 result = new Long(0);
                	 String errMsg = payr0300Vo.getPymtYrMnth() + ":" + MSFSharedUtils.allowNulls(bmMapModel.get("jobNm")) + "!! => 급여 계산 처리된 스케줄은 삭제할 수 없습니다."; 
                	 throw MSFServerUtils.getSimpleMessageException("activityOnPayr1300Delete", errMsg, logger); 
                }
                
                payr0250DAO.deletePayr0250(payr0250Vo);  
              
                iCnt = iCnt + 1;
                 
           } 
            result = iCnt;
			 
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling activityOnPayr1300Delete(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("activityOnPayr1300Delete", ex, logger);
        }
        finally {
          
        }
        
        return result;
		
	}

	@Override
	public Long activityOnPayr4050Save(List<Payr0250DTO> listPayr0250dto, ActionDatabase actionDatabase) throws MSFException  {
	    Long result = new Long(0);
	    Long iCnt = new Long(0);
	    
	    try { 
	    	
	    	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	    	
	    	// 1. 암호화 객체 생성
//	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	 
	        payr0250DAO = (Payr0250DAO)BeanFinder.getBean("Payr0250DAO");
	        
	        Payr0250SrhVO payr0250SrhVo = new Payr0250SrhVO(); 
	        
	       
	       
	        for(int iPayrCnt=0;iPayrCnt < listPayr0250dto.size();iPayrCnt++) {
	        	
	        	// 1. 암호화 객체 생성
	        	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	            
	                Payr0250DTO payr0250Dto = new Payr0250DTO();  
	                payr0250Dto = listPayr0250dto.get(iPayrCnt);
	          
	                Payr0250VO payr0250Vo = new Payr0250VO(); 
	                Payr0250VO tpPayr0250Vo = new Payr0250VO(); 
	                                 
	                
	                payr0250Vo.setDpobCd(sessionUser.getDpobCd());    																	/** column 사업장코드 : dpobCd */
	                payr0250Vo.setJobYrMnth(MSFSharedUtils.allowNulls(payr0250Dto.getJobYrMnth()) );    								/** column 작업년월 : jobYrMnth */
	                payr0250Vo.setPayCd(MSFSharedUtils.allowNulls(payr0250Dto.getPayCd()) );    										/** column 급여구분코드 : payCd */
	                payr0250Vo.setPayScduSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(payr0250Dto.getPayScduSeilNum(), "0")));	/** column 급여스케줄일련번호 : payScduSeilNum */
	                
	                payr0250Vo.setTypOccuCd(MSFSharedUtils.allowNulls( payr0250Dto.getTypOccuCd()) );    								/** column 직종코드 : typOccuCd */
	               //payr0250Vo.setPyspGrdeCd(tptypOccuCd[1]);    /** column 호봉등급코드 : pyspGrdeCd */
	                payr0250Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(payr0250Dto.getDtilOccuInttnCd()) );    					/** column 직종세종통합코드 : dtilOccuInttnCd */
	               // payr0250Vo.setDtilOccuClsDivCd(bass0320Dto.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
	                  
	                payr0250Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(payr0250Dto.getPayrMangDeptCd()) );    				/** column 급여관리부서코드 : payrMangDeptCd */
	                
	                payr0250Vo.setMangeDeptCd(MSFSharedUtils.allowNulls(payr0250Dto.getMangeDeptCd()) );    					/** column 관리부서코드 : payrMangDeptCd */
	                payr0250Vo.setDeptCd(MSFSharedUtils.allowNulls(payr0250Dto.getDeptCd()) );    								/** column 부서코드 : deptCd */
	                payr0250Vo.setBusinCd(MSFSharedUtils.allowNulls(payr0250Dto.getBusinCd() ));    							/** column 사업코드 : businCd */
	                payr0250Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(payr0250Dto.getEmymtDivCd()) );    						/** column 고용구분코드 : emymtDivCd */
	                payr0250Vo.setPernChrgEmpIdenNum(MSFSharedUtils.allowNulls(sessionUser.getUsrId()) );   					/** column 담당직원번호 : pernChrgEmpIdenNum */
	                payr0250Vo.setJobNm(MSFSharedUtils.allowNulls(payr0250Dto.getJobNm()) );    								/** column 작업명 : jobNm */
	                payr0250Vo.setPymtDt(MSFSharedUtils.allowNulls(payr0250Dto.getPymtDt()) );    								/** column 지급일자 : pymtDt */
	                payr0250Vo.setRflctnBgnnDt(MSFSharedUtils.allowNulls(payr0250Dto.getRflctnBgnnDt()) );    					/** column 반영시작일자 : rflctnBgnnDt */
	                payr0250Vo.setRflctnEndDt(MSFSharedUtils.allowNulls(payr0250Dto.getRflctnEndDt()) );    					/** column 반영종료일자 : rflctnEndDt */
	                payr0250Vo.setPayDdlneDt(MSFSharedUtils.allowNulls(payr0250Dto.getPayDdlneDt()) );    						/** column 급여마감일자 : payDdlneDt */
	                payr0250Vo.setGroFlCretnDt(MSFSharedUtils.allowNulls(payr0250Dto.getGroFlCretnDt()) );    					/** column 지로파일생성일자 : groFlCretnDt */
	                payr0250Dto.setDeptGpCd(MSFSharedUtils.allowNulls(payr0250Dto.getDeptGpCd()) );    							/** column 부서직종세그룹코드 : deptGpCd */
	        		payr0250Dto.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(payr0250Dto.getRepbtyBusinDivCd()) );    			/** column 호봉제구분코드 : repbtyBusinDivCd */
	        		
	//                payr0250Vo.setKybdr(payr0250Dto.getKybdr());    /** column 입력자 : kybdr */
	//                payr0250Vo.setInptDt(payr0250Dto.getInptDt());    /** column 입력일자 : inptDt */
	//                payr0250Vo.setInptAddr(payr0250Dto.getInptAddr());    /** column 입력주소 : inptAddr */
	//                payr0250Vo.setIsmt(payr0250Dto.getIsmt());    /** column 수정자 : ismt */
	//                payr0250Vo.setRevnDt(payr0250Dto.getRevnDt());    /** column 수정일자 : revnDt */
	//                payr0250Vo.setRevnAddr(payr0250Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
	                
	 
	                
	                tpPayr0250Vo = payr0250DAO.selectPayr0250(payr0250Vo);
	                
	                List chkPayr0250List = payr0250DAO.selectPayr0250CheckList(payr0250Vo);
              	  
              	  	boolean flag = false;
              	  	String errMsg = "";
              	  	
          			if(MSFConfiguration.EMYMT_DIVCD01.endsWith(payr0250Dto.getEmymtDivCd()) ) {
                        /** 
                         * 인서트 시 기존에 생성된 데이터가 존재하는지 여부 확인하여 존재하면 저장안하고 메시지 띄움.
                         */
                  	  if(chkPayr0250List.size() > 0){
            				for (int j = 0; j < chkPayr0250List.size(); j++) {
          					
            					EgovMap eMap = (EgovMap) chkPayr0250List.get(j);
            					
            					String deptCdStr = MSFSharedUtils.allowNulls( (String) eMap.get("deptCd") );
            					String typOccuCdStr = MSFSharedUtils.allowNulls( (String) eMap.get("typOccuCd") );
            					String dtilOccuInttnCdStr = MSFSharedUtils.allowNulls( (String) eMap.get("dtilOccuInttnCd") );
            					String businCd = MSFSharedUtils.allowNulls( (String) eMap.get("businCd") );
            					
            					if(businCd == null || "".equals(businCd)) {
            						
                					// 1. 부서 + 직종 + 직종세
                					if(MSFSharedUtils.paramNotNull(payr0250Dto.getDeptCd()) 
                							&&	MSFSharedUtils.paramNotNull(payr0250Dto.getTypOccuCd()) 
                							&& MSFSharedUtils.paramNotNull(payr0250Dto.getDtilOccuInttnCd()) ) {

                						// a. 부서코드가 등록된 경우
                						if(typOccuCdStr.equals("") || typOccuCdStr == null){
                							flag = true;
                							errMsg = "등록된 직종세 스케줄이 존재합니다. 부서 데이터를 등록하시려면 기등록된 직종세 스케줄을 삭제 후 등록하십시요.";
                							break;
                						}else{
                							if(payr0250Dto.getTypOccuCd().equals(typOccuCdStr)){
                								// b. 직종코드가 등록된 경우
                								if( dtilOccuInttnCdStr== null || dtilOccuInttnCdStr.equals("")){
                									flag = true;
                        							errMsg = "등록된 직종세 스케줄이 존재합니다. 직종 데이터를 등록하시려면 기등록된 직종세 스케줄을 삭제 후 등록하십시요.";
                        							break;
                        						
                								}else{
                									// c.직종세코드가 등록된 경우 	
                									if(payr0250Dto.getDtilOccuInttnCd().equals(dtilOccuInttnCdStr)){
                										flag = true;
                            							errMsg = "등록된 직종세 스케줄이 존재합니다. 직종세 데이터를 등록하시려면 기등록된 직종세 스케줄을 삭제 후 등록하십시요.";
                            							break;
                									}
                								}
                							}  
                						}
                					}
                				    // 2. 부서 + 직종
                					else if(MSFSharedUtils.paramNotNull(payr0250Dto.getDeptCd()) 
                							&&	MSFSharedUtils.paramNotNull(payr0250Dto.getTypOccuCd()) ) {
                						
                						// a.부서코드가 등록된 경우
                						if(typOccuCdStr.equals("") || typOccuCdStr == null){
                							flag = true;
                							errMsg = "등록된 직종 스케줄이 존재합니다. 부서 데이터를 등록하시려면 기등록된 직종 스케줄을 삭제 후 등록하십시요.";
                							break;
                						}else{
                							if(payr0250Dto.getTypOccuCd().equals(typOccuCdStr)){
                								// b. 직종이 등록된 경우 
                    							if( dtilOccuInttnCdStr== null || dtilOccuInttnCdStr.equals("")){
                									flag = true;
                        							errMsg = "등록된 직종 스케줄이 존재합니다. 직종 데이터를 등록하시려면 기등록된 직종 스케줄을 삭제 후 등록하십시요.";
                        							break;
                        						// c. 직종세 등록된 경우 
                								}else {
                									flag = true;
                        							errMsg = "등록된 직종 스케줄이 존재합니다. 직종 하위 데이터를 등록하시려면 기등록된 직종 스케줄을 삭제 후 등록하십시요.";
                        							break;
                								}
                							}
                						}
                						
                					}
                					
                					// 3. 부서
                					else if(MSFSharedUtils.paramNotNull(payr0250Dto.getDeptCd()) ) {
                						
//                						if(payr0250Dto.getDeptCd().equals(deptCdStr) || payr0250Dto.getDeptCd() == deptCdStr){
                						
                						// a.부서코드가 등록된 경우
                						if(typOccuCdStr.equals("") || typOccuCdStr == null){
                							flag = true;
                							errMsg = "등록된 부서 스케줄이 존재합니다. 부서 데이터를 등록하시려면 기등록된 부서 스케줄을 삭제 후 등록하십시요.";
                							break;
                						}else {
                						// b.직종/직종세 등록된 경우
                							flag = true;
                							errMsg = "입력하려는 부서에는 하위 직종/직종세 데이터가 존재합니다. 직종/직종세까지 선택하신 후 등록  하십시요.";
                							break;
                						}
                					}
            					}
            				}
                  	  }else{
                  	  //insert
                  	  }
                  	  
          			}else if(MSFConfiguration.EMYMT_DIVCD02.endsWith(payr0250Dto.getEmymtDivCd())){
          				
//          				List chkPayr0250List = payr0250DAO.selectPayr0250CheckList(payr0250Vo);
          				if(chkPayr0250List.size() > 0){
          					flag = true;
          					errMsg = "등록된 사업 스케줄이 존재합니다. 사업 데이터를 등록하시려면 기 등록된 사업 스케줄을 삭제 후 등록하십시요.";
          					break;
          				}
          			}
	                
	                if (tpPayr0250Vo == null) { 
	                	
	                	  if(flag){
	                		  MSFErrorMessage msg = new MSFErrorMessage("급여스케줄관리", "", 4, errMsg); 
	                		  throw MSFServerUtils.getValidationException("activityOnPayr4050Save", msg, logger);
	                	  }else{
	                		  // 스케줄 수정일 경우 수정. 신규일 경우 insert
	                		  switch (actionDatabase) {
	          					case INSERT:
	          						payr0250DAO.insertPayr0250FromPayrP405001(payr0250Vo);
	          					break;
	          					case UPDATE:
	          						
	          						payr0250DAO.updatePayr0250(payr0250Vo); 
	          						
	          						/***
	        	              	  	 *  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	        	              	  	 *  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	        	              	  	 */
	          						// TODO 확인필요
	          						// 지급일자 수정 시 급여마감관리 화면에서 보이지 않음.
	          						// 스케줄 수정 시 Payr0300 의 지급일자로 같이 udpate 처리
//	          						Payr0300VO payr0300Vo = new Payr0300VO();
//	          						payr0300Vo.setDpobCd(payr0250Vo.getDpobCd());
//	          						payr0300Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth().replace(",", ""));
//	          						payr0300Vo.setPayCd(payr0250Vo.getPayCd());
//	          						payr0300Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
//	          						payr0300Vo.setPayPymtDt(payr0250Vo.getPymtDt());
//	          						payr0300DAO.updatePayr0300(payr0300Vo);
	          						/***
	        	              	  	 *  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	        	              	  	 *  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	        	              	  	 */
	          						
	          					break;
	                      	}
	                		  
//		              		  payr0250DAO.insertPayr0250FromPayrP405001(payr0250Vo);
		              		  iCnt = iCnt + 1;
	                	  }
	                // update
	                } else {
	                	
              			
              			
                	  if(flag){
                		  MSFErrorMessage msg = new MSFErrorMessage("급여스케줄관리", "", 4, errMsg); 
                			////                		  throw MSFServerUtils.getValidationException("activityOnPayr4050Save", errMsg, logger);
                		  throw MSFServerUtils.getValidationException("activityOnPayr4050Save", msg, logger);
                			////                		  throw MSFServerUtils.getValidationException("activityOnPayr4050Save", errMsg, logger);
//              		  bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"Payr","[" + strEmymtDivNm+ "]" ,"생성오류","생성년월 : " + payr0250Vo.getJobYrMnth() + "월  " + errMsg));
                	  }
	                	
	              	  	payr0250DAO.updatePayr0250(payr0250Vo); 
	              	  	
	              	  	/***
	              	  	 *  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	              	  	 *  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	              	  	 */
	              	  	// TODO 확인필요
  						// 지급일자 수정 시 급여마감관리 화면에서 보이지 않음.
  						// 스케줄 수정 시 Payr0300 의 지급일자로 같이 udpate 처리
//  						Payr0300VO payr0300Vo = new Payr0300VO();
//  						payr0300Vo.setDpobCd(payr0250Vo.getDpobCd());
//  						payr0300Vo.setPymtYrMnth(payr0250Vo.getJobYrMnth().replace(",", ""));
//  						payr0300Vo.setPayCd(payr0250Vo.getPayCd());
//  						payr0300Vo.setPayrSeilNum(payr0250Vo.getPayScduSeilNum());
//  						payr0300Vo.setPayPymtDt(payr0250Vo.getPymtDt());
//  						payr0300DAO.updatePayr0300(payr0300Vo);
  						/***
	              	  	 *  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	              	  	 *  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	              	  	 */
  						
	              	  	iCnt = iCnt + 1;
	                }       
	           } 
	            result = iCnt;
	      
	    }catch (Exception ex) {
	        logger.error("EXCEPTION calling activityOnPayr4050Save(): "+ex); 
	        result = new Long(0);
	        throw MSFServerUtils.getOperationException("activityOnPayr4050Save", ex, logger);
	    }finally {
	      
	    }
	    
	    return result;
	}
	
	@Override
	public Long checkSysm0700Auth(Payr0250DTO payr0250dto, ActionDatabase actionDatabase) throws MSFException  {
		Long result = new Long(0);
		int	check = 0;
		try { 

			MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

			payr0250DAO = (Payr0250DAO)BeanFinder.getBean("Payr0250DAO");

			Payr0250SrhVO payr0250SrhVo = new Payr0250SrhVO(); 

			payr0250SrhVo.setUsrId(sessionUser.getUsrId());
			
			check = payr0250DAO.checkSysm0700(payr0250SrhVo);
			
			if (check > 0) {
				result = 1L;
			}
			else {
				result =  new Long(0);
			}
					
		}catch (Exception ex) {
			logger.error("EXCEPTION calling activityOnPayr4050Save(): "+ex); 
			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnPayr4050Save", ex, logger);
		}finally {

		}

	    return result;
	}
 
	 
	
}
