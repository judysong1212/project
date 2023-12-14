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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.any.smrmf.utils.BeanFinder;
import com.app.exterms.payroll.client.dto.Payr0250DTO;
import com.app.exterms.payroll.client.dto.Payr0301DTO;
import com.app.exterms.payroll.client.service.Payr4150Service;
import com.app.exterms.payroll.server.service.dao.Payr0250DAO;
import com.app.exterms.payroll.server.service.dao.Payr0300DAO;
import com.app.exterms.payroll.server.service.dao.Payr0301DAO;
import com.app.exterms.payroll.server.service.dao.Payr0302DAO;
import com.app.exterms.payroll.server.service.dao.Payr0304DAO;
import com.app.exterms.payroll.server.service.dao.Payr0305DAO;
import com.app.exterms.payroll.server.service.dao.Payr0306DAO;
import com.app.exterms.payroll.server.service.dao.Payr0307DAO;
import com.app.exterms.payroll.server.service.dao.Payr0309DAO;
import com.app.exterms.payroll.server.vo.Payr0250SrhVO;
import com.app.exterms.payroll.server.vo.Payr0250VO;
import com.app.exterms.payroll.server.vo.Payr0300SrhVO;
import com.app.exterms.payroll.server.vo.Payr0300VO;
import com.app.exterms.payroll.server.vo.Payr0301SrhVO;
import com.app.exterms.payroll.server.vo.Payr0301VO;
import com.app.exterms.payroll.server.vo.Payr0302VO;
import com.app.exterms.payroll.server.vo.Payr0304VO;
import com.app.exterms.payroll.server.vo.Payr0305VO;
import com.app.exterms.payroll.server.vo.Payr0306VO;
import com.app.exterms.payroll.server.vo.Payr0307VO;
import com.app.exterms.payroll.server.vo.Payr0309VO;
import com.app.exterms.payroll.shared.PayrDaoConstants;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0100DTO;
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
import com.app.smrmf.infc.payroll.server.service.dao.InfcPkgPayr0485DAO;
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0250VO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0100VO;
import com.app.smrmf.pkg.listener.PayrListenerAdapter;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Payr4150Service")
public class Payr4150ServiceImpl extends AbstractCustomServiceImpl implements Payr4150Service  ,PayrDaoConstants {

	private static final Logger logger = LoggerFactory.getLogger(Payr4150ServiceImpl.class);
	private static final String calledClass = Payr4150ServiceImpl.class.getName();
	 
	//급여스케줄정보 
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
	
	//근로소득간이세액표산출
	@Autowired
    @Resource(name="Payr0305DAO")
    private Payr0305DAO payr0305DAO;
	
	
	@Autowired
    @Resource(name="Payr0300DAO")
    private Payr0300DAO payr0300DAO;
	
	
	@Autowired
    @Resource(name="Payr0302DAO")
    private Payr0302DAO payr0302DAO;
	
	@Autowired
    @Resource(name="Payr0306DAO")
    private Payr0306DAO payr0306DAO;
	

	@Autowired
    @Resource(name="Payr0307DAO")
    private Payr0307DAO payr0307DAO;
    

	@Autowired
    @Resource(name="Payr0309DAO")
    private Payr0309DAO payr0309DAO;
	
    
	@Autowired
	@Resource(name = "InfcPkgPayr0485DAO")
	private InfcPkgPayr0485DAO payr0485DAO; 
  
	
    /** ID Generation */
    //@Resource(name="{egovPayr0250IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;
	
	//급여스케줄정보를 가지고 온다. 
	public PagingLoadResult<BaseModel> getPayr0250ToPayr4150DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0250TOPAYR4150_DATA_LIST;
        Payr0250SrhVO   payr0250SrhVO = new Payr0250SrhVO();
        Payr0250VO      payr0250VO = new Payr0250VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
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
            List<String> listDeptCd = new ArrayList<String>();
            /** 조건절 */
            payr0250SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            payr0250SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
            
            payr0250SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
            payr0250SrhVO.setUsrId(sessionUser.getUsrId()); 
            
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	payr0250SrhVO.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               payr0250SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
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
            
//            String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//            if ("FALSE".equals(chkTypOccuCd)) {
//            	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//            	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//            } else {
//            	
//            }
            
            payr0250SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            payr0250SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
            
//            if (payr0250SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
//            	payr0250SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//            	List<String> listDeptCd = null; 
//            	payr0250SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//            	payr0250SrhVO.setDeptCd("");     //부서코드
//            } else {
//            	  
//                List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//                payr0250SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//                payr0250SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//               
//            } 
          
            
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
            payr0250SrhVO.setJobYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth")).replace(".", "")); //지급년 
            payr0250SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            payr0250SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
          
            payr0250SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters,"mangeDeptCd")));    //관리부서
            payr0250SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")) ); //호봉제구분
             
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0250DAO.selectPayr0250ToPayr4150ListTotCnt(payr0250SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0250ToPayr4150DataList = SmrmfUtils.startTiming(logger);
        
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
//          Collection<Map<String, Object>> list  
            List list = payr0250DAO.selectPayr0250ToPayr4150List(payr0250SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0250ToPayr4150DataList, "getPayr0250ToPayr4150DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	//선택된 정보에 급여 내역이 존재하는지를 판단하여 값을 가지고 온다.

	public PagingLoadResult<BaseModel> getPayr0301ToPayr4150DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR0301TOPAYR4150_DATA_LIST;
        Payr0301SrhVO   payr0301SrhVO = new Payr0301SrhVO();
        Payr0301VO      payr0301VO = new Payr0301VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
       
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
            	payr0301SrhVO.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               payr0301SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
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
            
//            if (MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")).equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
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
            
            if (MSFSharedUtils.paramNotNull(MSFServerUtils.getFilterValue(columnFilters, "payPymtDt"))) {
                payr0301SrhVO.setPayPymtDt(new SimpleDateFormat("yyyyMMdd").format((Date)MSFServerUtils.getFilterValue(columnFilters, "payPymtDt")));
                
              } else {
                  payr0301SrhVO.setPayPymtDt(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payPymtDt")));  //지급일자 
              } 
            
            payr0301SrhVO.setPayrSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "payrSeilNum"),"0"))); //급여일련번호 
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	         if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0301DAO.selectPayr0301ToPayr4150ListTotCnt(payr0301SrhVO);  
                //페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
                pagingValues.totalRecordCount = iResultCnt;    
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
               
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr0301ToPayr4150DataList = SmrmfUtils.startTiming(logger);
        
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
//            Collection<Map<String, Object>> list ??????
            List list = payr0301DAO.selectPayr0301ToPayr4150List(payr0301SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr0301ToPayr4150DataList, "getPayr0301ToPayr4150DataList");
       

        }
        catch (Exception ex) {
        	ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	public PagingLoadResult<BaseModel> getCboPayr0300PayYrList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = "getCboPayr0300PayYrList";
        Payr0300SrhVO   payr0300SrhVO = new Payr0300SrhVO();
        Payr0300VO      payr0300VO = new Payr0300VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        try {
          
        	payr0300DAO = (Payr0300DAO)BeanFinder.getBean("Payr0300DAO");
        	
             ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
             IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
             List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
             PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
 	         
        	
            //Get paging configuration
             PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
            /** 조건절 */
             payr0300SrhVO.setDpobCd(sessionUser.getDpobCd());
           // sysComSrhVo.setRpsttvCd(sysComBass0300Dto.getRpsttvCd());
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  payr0300DAO.selectPayr0300PayYrListTotCnt(payr0300SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
               logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPayr0300PayYrList = SmrmfUtils.startTiming(logger);
         
          
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0300SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0300SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.totalRecordCount < 100) {
            	payr0300SrhVO.setLastIndex(pagingValues.totalRecordCount); 
            } else  if (pagingValues.offsetLimit > 0) {
            	payr0300SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            } 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ?????? 
            List list = payr0300DAO.selectPayr0300PayYrList(payr0300SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayr0300PayYrList, "getCboPayr0300PayYrList");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }

	@Override
	public Long activityOnPayr4150(Payr0301DTO payr0301Dto,
			ActionDatabase actionDatabase)  throws MSFException  {
		// TODO Auto-generated method stub
		   Long result = new Long(1);
		   MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		   
	        try {
	           
	        	Payr0300VO  payr0300Vo = new Payr0300VO();
	        	Payr0301VO  payr0301Vo = new Payr0301VO();
	        	Payr0302VO  payr0302Vo = new Payr0302VO();
	        	Payr0304VO  payr0304Vo = new Payr0304VO(); 
	        	Payr0306VO  payr0306Vo = new Payr0306VO();
	        	Payr0307VO  payr0307Vo = new Payr0307VO();
	        	Payr0309VO  payr0309Vo = new Payr0309VO();
	        	 
                payr0301Vo.setDpobCd(payr0301Dto.getDpobCd());    												/** column 사업장코드 : dpobCd */
                payr0301Vo.setPymtYrMnth(payr0301Dto.getPymtYrMnth());    										/** column 지급년월 : pymtYrMnth */
                payr0301Vo.setPayCd(payr0301Dto.getPayCd());    												/** column 급여구분코드 : payCd */
                payr0301Vo.setPayrSeilNum(new BigDecimal(payr0301Dto.getPayrSeilNum()));    					/** column 급여일련번호 : payrSeilNum */
                payr0301Vo.setSystemkey(payr0301Dto.getSystemkey());    										/** column SYSTEMKEY : systemkey */
                payr0301Vo.setPymtTotAmnt(new BigDecimal(payr0301Dto.getPymtTotAmnt()));    					/** column 지급총액 : pymtTotAmnt */
                payr0301Vo.setExtpyTotAmnt(new BigDecimal(payr0301Dto.getExtpyTotAmnt()));   	 				/** column 수당총액 : extpyTotAmnt */
                payr0301Vo.setTxtnTotAmnt(new BigDecimal(payr0301Dto.getTxtnTotAmnt()));    					/** column 과세총액 : txtnTotAmnt */
                payr0301Vo.setFreeDtyTotAmnt(new BigDecimal(payr0301Dto.getFreeDtyTotAmnt()));    				/** column 비과세총액 : freeDtyTotAmnt */
                payr0301Vo.setDducTotAmnt(new BigDecimal(payr0301Dto.getDducTotAmnt()));    					/** column 공제총액 : dducTotAmnt */
                payr0301Vo.setTxTotAmnt(new BigDecimal(payr0301Dto.getTxTotAmnt()));    						/** column 세금총액 : txTotAmnt */
                payr0301Vo.setSevePayPymtYn((Boolean.TRUE.equals(payr0301Dto.getSevePayPymtYn()) ? "Y" : "N"));	/** column 퇴직금지급여부 : sevePayPymtYn */
                payr0301Vo.setPernPymtSum(new BigDecimal(payr0301Dto.getPernPymtSum()));    					/** column 차인지급액 : pernPymtSum */
                payr0301Vo.setIncmTxCllnRto(new BigDecimal(payr0301Dto.getIncmTxCllnRto()));    				/** column 소득세징수비율 : incmTxCllnRto */
                payr0301Vo.setBnkCd(payr0301Dto.getBnkCd());    												/** column 은행코드 : bnkCd */
                payr0301Vo.setBnkAccuNum(payr0301Dto.getBnkAccuNum());    										/** column 은행계좌번호 : bnkAccuNum */
                payr0301Vo.setAcntHodrNm(payr0301Dto.getAcntHodrNm());    										/** column 예금주명 : acntHodrNm */
                payr0301Vo.setPayDdlneDt(payr0301Dto.getPayDdlneDt());    										/** column 급여마감일자 : payDdlneDt */
                payr0301Vo.setPayDdlneYn((Boolean.TRUE.equals(payr0301Dto.getPayDdlneYn()) ? "Y" : "N"));    	/** column 급여마감여부 : payDdlneYn */
                payr0301Vo.setKybdr(sessionUser.getUsrId());    												/** column 입력자 : kybdr */
                payr0301Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 입력주소 : inptAddr */
                payr0301Vo.setIsmt(sessionUser.getUsrId());    													/** column 수정자 : ismt */
                payr0301Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    			/** column 수정주소 : revnAddr */
	        	
	        	
	            BeanUtils.copyProperties(payr0300Vo, payr0301Vo);   
	            BeanUtils.copyProperties(payr0302Vo, payr0301Vo); 
	            BeanUtils.copyProperties(payr0304Vo, payr0301Vo); 
	            BeanUtils.copyProperties(payr0306Vo, payr0301Vo); 
	            BeanUtils.copyProperties(payr0307Vo, payr0301Vo); 
	            BeanUtils.copyProperties(payr0309Vo, payr0301Vo); 
                
	            switch (actionDatabase) { 
	            case INSERT:
	            	payr0301DAO.insertPayr0301(payr0301Vo);
	               break;
	            case UPDATE: 
	            	payr0301DAO.updatePayr0301(payr0301Vo);
	                break;
	            case DELETE:
	            	payr0300DAO.deletePayr0300(payr0300Vo);
	            	payr0301DAO.deletePayr0301(payr0301Vo);
	            	payr0302DAO.deletePayr0302(payr0302Vo);
	            	payr0304DAO.deletePayr0304(payr0304Vo);
	            	payr0306DAO.deletePayr0306(payr0306Vo);
	            	payr0307DAO.deletePayr0307(payr0307Vo);
	            	payr0309DAO.deletePayr0309(payr0309Vo);
	                break; 
	            }
	            
	        }
	        catch (Exception ex) {
	            logger.error("EXCEPTION calling activityOnPayr4150(): "+ex); 
	            result = new Long(0);
	           // ex.printStackTrace();
	            throw MSFServerUtils.getOperationException("activityOnPayr4150", ex, logger);
	        }
	        finally {
	          
	        }
	        return result;
	}

	 
    private Long deleteAllOnPayr4150(Payr0301DTO payr0301Dto,
            ActionDatabase actionDatabase)  throws MSFException  {
        // TODO Auto-generated method stub
           Long result = new Long(1);
          
            try {
                
                Payr0301SrhVO  payr0301SrhVo = new Payr0301SrhVO();
                Payr0300VO  payr0300Vo = new Payr0300VO();
                Payr0301VO  payr0301Vo = new Payr0301VO();
                Payr0302VO  payr0302Vo = new Payr0302VO(); 
                Payr0304VO  payr0304Vo = new Payr0304VO();
                Payr0305VO  payr0305Vo = new Payr0305VO();
                Payr0306VO  payr0306Vo = new Payr0306VO();
                Payr0309VO  payr0309Vo = new Payr0309VO();
                Payr0307VO  payr0307Vo = new Payr0307VO();
                 
                
                payr0300Vo.setPymtYrMnth(payr0301Dto.getPymtYrMnth()); 					/** set 지급년월 : pymtYrMnth */
                payr0300Vo.setPayCd(payr0301Dto.getPayCd()); 							/** set 급여구분코드 : payCd */
                payr0300Vo.setDpobCd(payr0301Dto.getDpobCd()); 							/** set 사업장코드 : dpobCd */
                payr0300Vo.setPayrSeilNum(new BigDecimal(payr0301Dto.getPayrSeilNum()));/** set 급여일련번호 : payrSeilNum */
                  
                BeanUtils.copyProperties(payr0301Vo, payr0300Vo); 
	            BeanUtils.copyProperties(payr0302Vo, payr0300Vo);  
	            BeanUtils.copyProperties(payr0305Vo, payr0300Vo);  
	            BeanUtils.copyProperties(payr0307Vo, payr0300Vo); 
	            BeanUtils.copyProperties(payr0304Vo, payr0300Vo);  
                BeanUtils.copyProperties(payr0306Vo, payr0300Vo); 
                BeanUtils.copyProperties(payr0309Vo, payr0300Vo);
                
                if (MSFSharedUtils.paramNull(payr0301Dto.getSystemkey())) {
                    payr0300Vo.setSystemkey("");
                } else {
                    payr0300Vo.setSystemkey(payr0301Dto.getSystemkey());
                    payr0301Vo.setSystemkey(payr0301Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                payr0302Vo.setSystemkey(payr0301Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
	               // payr0302Vo.setPayItemCd("");
	               // payr0302Vo.setPayItemSeilNum(BigDecimal.ZERO);
	                payr0305Vo.setSystemkey(payr0301Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                payr0304Vo.setSystemkey(payr0301Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                payr0306Vo.setSystemkey(payr0301Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
	                payr0307Vo.setSystemkey(payr0301Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
	                payr0309Vo.setSystemkey(payr0301Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */ 
                }
                
                
                payr0301SrhVo.setDpobCd(payr0301Dto.getDpobCd());    						/** column 사업장코드 : dpobCd */
                payr0301SrhVo.setPymtYrMnth(payr0301Dto.getPymtYrMnth());    				/** column 지급년월 : pymtYrMnth */    
                payr0301SrhVo.setPayCd(payr0301Dto.getPayCd());  							/** set 급여구분코드 : payCd */ 
                payr0301SrhVo.setPayrSeilNum(new BigDecimal(payr0301Dto.getPayrSeilNum())); /** set 급여일련번호 : payrSeilNum */
                payr0301SrhVo.setSystemkey(""); 											/** set 시스템키  : Systemkey MSFSharedUtils.allowNulls(payr0301Dto.getSystemkey())*/
                
//                int payr0301Cnt = payr0301DAO.selectPayr4150DelToPayr0301ListTotCnt(payr0301SrhVo);
//                
//                if (payr0301Cnt == 0) {
//                    
//                    BeanUtils.copyProperties(payr0304Vo, payr0300Vo); 
//                    BeanUtils.copyProperties(payr0306Vo, payr0300Vo);  
//                    BeanUtils.copyProperties(payr0309Vo, payr0300Vo);
//                    
//                }
                
 
                
                switch (actionDatabase) {  
                case DELETE: 
                    
                	payr0309DAO.deletePayCalculationPayr0309(payr0309Vo);
                    payr0306DAO.deletePayCalculationPayr0306(payr0306Vo);  
//	            	payr0307DAO.deletePayCalculationPayr0307(payr0307Vo);
	            	payr0305DAO.deletePayCalculationPayr0305(payr0305Vo);
	                payr0304DAO.deletePayCalculationPayr0304(payr0304Vo);
	                payr0302DAO.deletePayCalculationPayr0302(payr0302Vo);
	            	payr0301DAO.deletePayCalculationPayr0301(payr0301Vo);  
	            	 
	                int payr0301Cnt = payr0301DAO.selectPayr4150DelToPayr0301ListTotCnt(payr0301SrhVo); 
 
	            	if (payr0301Cnt == 0) { 
	            		payr0300DAO.deletePayCalculationPayr0300(payr0300Vo); 
	            	 }
	            	
	            	
//                  //  payr0307DAO.deletePayCalculationPayr0307(payr0307Vo);
//                    payr0305DAO.deletePayCalculationPayr0305(payr0305Vo);
//                    payr0302DAO.deletePayCalculationPayr0302(payr0302Vo); 
//                    payr0301DAO.deletePayCalculationPayr0301(payr0301Vo);
//                    payr0300DAO.deletePayCalculationPayr0300(payr0300Vo);
//                    if (payr0301Cnt == 0) {
//                        
//                        //급여구분코드가 급여인경우에만 삭제처리를 하고 나머지는 급여구분넘김.
//                    	payr0309DAO.deletePayCalculationPayr0309(payr0309Vo);
//                        payr0306DAO.deletePayCalculationPayr0306(payr0306Vo);
//                        payr0304DAO.deletePayCalculationPayr0304(payr0304Vo);
//                         
//                   } 
                    
                   
                    break; 
                }
                
            }
            catch (Exception ex) {
                 logger.error("EXCEPTION calling deleteAllOnPayr4150(): "+ex); 
                result = new Long(0);
                throw MSFServerUtils.getOperationException("deleteAllOnPayr4150", ex, logger);
            }
            finally {
              
            }
            return result;
    }
 
	    
	       
	//스케줄링에 따른 급여계산 
   // @Override
   // public Long setPayr4100ToPayCalculation(Payr0250DTO payr0250Dto)  throws MSFException  {
	@Override
	public PagingLoadResult<ShowMessageBM> setPayr4100ToPayCalculation(Payr0250DTO payr0250Dto)  throws MSFException  {
        // TODO Auto-generated method stub
       // Long result =  new Long(1); 
         PagingLoadResult<ShowMessageBM> retval = null;
		
         try { 
             
             //삭제로직 호출 
             Payr0301DTO payr0301Dto = new Payr0301DTO(); 
              
             
             payr0301Dto.setPymtYrMnth(payr0250Dto.getJobYrMnth()); 		/** set 지급년월 : pymtYrMnth */
             payr0301Dto.setPayCd(payr0250Dto.getPayCd());  				/** set 급여구분코드 : payCd */
             payr0301Dto.setDpobCd(payr0250Dto.getDpobCd()); 				/** set 사업장코드 : dpobCd */
             payr0301Dto.setPayrSeilNum(payr0250Dto.getPayScduSeilNum()); 	/** set 급여일련번호 : payrSeilNum */
             
             Long result = deleteAllOnPayr4150(payr0301Dto,ActionDatabase.DELETE);
          
             if (result > 0) {
            	 
            	InfcPkgPayr0250VO payr0250Vo =  new InfcPkgPayr0250VO();
            	 
				payr0250Vo.setDpobCd(payr0250Dto.getDpobCd());    								/** column ????? : dpobCd */
				payr0250Vo.setJobYrMnth(payr0250Dto.getJobYrMnth());    						/** column ???? : jobYrMnth */
				payr0250Vo.setPayCd(payr0250Dto.getPayCd());    								/** column ?????? : payCd */
				payr0250Vo.setPayScduSeilNum(new BigDecimal(payr0250Dto.getPayScduSeilNum()));	/** column ????????? : payScduSeilNum */
				payr0250Vo.setPayrMangDeptCd(payr0250Dto.getPayrMangDeptCd());    				/** column ???????? : payrMangDeptCd */
				payr0250Vo.setMangeDeptCd(payr0250Dto.getMangeDeptCd());    					/** column ???? : mangeDeptCd */
				payr0250Vo.setDeptCd(payr0250Dto.getDeptCd());    								/** column ???? : deptCd */
				payr0250Vo.setBusinCd(payr0250Dto.getBusinCd());    							/** column ???? : businCd */
				payr0250Vo.setEmymtDivCd(payr0250Dto.getEmymtDivCd());    						/** column ?????? : emymtDivCd */
				payr0250Vo.setPernChrgEmpIdenNum(payr0250Dto.getPernChrgEmpIdenNum());    		/** column ?????? : pernChrgEmpIdenNum */
				payr0250Vo.setJobNm(payr0250Dto.getJobNm());    								/** column ??? : jobNm */
				payr0250Vo.setPymtDt(payr0250Dto.getPymtDt());    								/** column ???? : pymtDt */
				payr0250Vo.setRflctnBgnnDt(payr0250Dto.getRflctnBgnnDt());   	 				/** column ?????? : rflctnBgnnDt */
				payr0250Vo.setRflctnEndDt(payr0250Dto.getRflctnEndDt());    					/** column ?????? : rflctnEndDt */
				payr0250Vo.setPayDdlneDt(payr0250Dto.getPayDdlneDt());    						/** column ?????? : payDdlneDt */
				payr0250Vo.setGroFlCretnDt(payr0250Dto.getGroFlCretnDt());    					/** column ???????? : groFlCretnDt */ 
				payr0250Vo.setTypOccuCd(payr0250Dto.getTypOccuCd());    						/** column ???? : typOccuCd */
				payr0250Vo.setDtilOccuInttnCd(payr0250Dto.getDtilOccuInttnCd());    			/** column ?????? : dtilOccuInttnCd */
            	 
            	 
                 PayrListenerAdapter payrAdapter = new PayrListenerAdapter(); 
                 retval = payrAdapter.setPayr4100ToPayCalculation(RemoteServiceUtil.getThreadLocalRequest(),payr0250Vo);
                 
                 //급여 계산시 신규 항목 추가 처리를 위한 메서드 
                 mutilInsertPayr0485();
             }
        
         } catch (Exception ex) {
             logger.error("EXCEPTION calling setPayr4100ToPayCalculation(): "+ex); 
             //result = new Long(0); 
             throw MSFServerUtils.getOperationException("setPayr4100ToPayCalculation", ex, logger);
         }
         finally {
           
         }
         
        return retval;
    }

    @Override
    public  PagingLoadResult<ShowMessageBM> setPayr4100ToPayCalcSeft(Payr0250DTO dtoPayr0250, PrgmComPsnl0100DTO dtoPsnl0100) throws MSFException  {
        
    	  PagingLoadResult<ShowMessageBM> retval = null;
       // Long result =  new Long(1); 
        
        try { 
            
            //삭제로직 호출 
            Payr0301DTO payr0301Dto = new Payr0301DTO();
            InfcPkgPsnl0100VO   infcPkgPsnl0100Vo = new  InfcPkgPsnl0100VO();
            
            BeanUtils.copyProperties(infcPkgPsnl0100Vo, dtoPsnl0100);  
                              
            
            payr0301Dto.setPymtYrMnth(dtoPayr0250.getJobYrMnth()); 		/** set 지급년월 : pymtYrMnth */
            payr0301Dto.setPayCd(dtoPayr0250.getPayCd()); 				/** set 급여구분코드 : payCd */
            payr0301Dto.setDpobCd(dtoPayr0250.getDpobCd());  			/** set 사업장코드 : dpobCd */
            payr0301Dto.setPayrSeilNum(dtoPayr0250.getPayScduSeilNum());/** set 급여일련번호 : payrSeilNum */
            
            payr0301Dto.setSystemkey(dtoPsnl0100.getSystemkey());
            
            Long result = deleteAllOnPayr4150(payr0301Dto,ActionDatabase.DELETE);
         
            if (result > 0) {
            	
            	InfcPkgPayr0250VO payr0250Vo =  new InfcPkgPayr0250VO();
            	
				payr0250Vo.setDpobCd(dtoPayr0250.getDpobCd());    								/** column ????? : dpobCd */
				payr0250Vo.setJobYrMnth(dtoPayr0250.getJobYrMnth());    						/** column ???? : jobYrMnth */
				payr0250Vo.setPayCd(dtoPayr0250.getPayCd());    								/** column ?????? : payCd */
				payr0250Vo.setPayScduSeilNum(new BigDecimal(dtoPayr0250.getPayScduSeilNum()));	/** column ????????? : payScduSeilNum */
				payr0250Vo.setPayrMangDeptCd(dtoPayr0250.getPayrMangDeptCd());    				/** column ???????? : payrMangDeptCd */
				payr0250Vo.setDeptCd(dtoPayr0250.getDeptCd());    								/** column ???? : deptCd */
				payr0250Vo.setMangeDeptCd(dtoPayr0250.getMangeDeptCd());    					/** column ???? : mangeDeptCd */
				
				payr0250Vo.setBusinCd(dtoPayr0250.getBusinCd());    							/** column ???? : businCd */
				payr0250Vo.setEmymtDivCd(dtoPayr0250.getEmymtDivCd());    						/** column ?????? : emymtDivCd */
				payr0250Vo.setPernChrgEmpIdenNum(dtoPayr0250.getPernChrgEmpIdenNum());    		/** column ?????? : pernChrgEmpIdenNum */
				payr0250Vo.setJobNm(dtoPayr0250.getJobNm());    								/** column ??? : jobNm */
				payr0250Vo.setPymtDt(dtoPayr0250.getPymtDt());    								/** column ???? : pymtDt */
				payr0250Vo.setRflctnBgnnDt(dtoPayr0250.getRflctnBgnnDt());    					/** column ?????? : rflctnBgnnDt */
				payr0250Vo.setRflctnEndDt(dtoPayr0250.getRflctnEndDt());    					/** column ?????? : rflctnEndDt */
				payr0250Vo.setPayDdlneDt(dtoPayr0250.getPayDdlneDt());    						/** column ?????? : payDdlneDt */
				payr0250Vo.setGroFlCretnDt(dtoPayr0250.getGroFlCretnDt());    					/** column ???????? : groFlCretnDt */ 
				payr0250Vo.setTypOccuCd(dtoPayr0250.getTypOccuCd());    						/** column ???? : typOccuCd */
				payr0250Vo.setDtilOccuInttnCd(dtoPayr0250.getDtilOccuInttnCd());    			/** column ?????? : dtilOccuInttnCd */
				
            	  
				
                PayrListenerAdapter payrAdapter = new PayrListenerAdapter(); 
                retval =  payrAdapter.setPayr4100ToPayCalcSeft(RemoteServiceUtil.getThreadLocalRequest(), payr0250Vo, infcPkgPsnl0100Vo);
                
                //급여 계산시 신규 항목 추가 처리를 위한 메서드 
                mutilInsertPayr0485();
            }
       
        } catch (Exception ex) {
            //logger.error("EXCEPTION calling activityOnVoceMenu(): "+ex); 
           // result = new Long(0);
           // ex.printStackTrace();
            throw MSFServerUtils.getOperationException("setPayr4100ToPayCalcSeft", ex, logger);
        }
        finally {
          
        }
        
       return retval;
    }
 
    @Override
    public  PagingLoadResult<ShowMessageBM> setPayr4100ToPayCalcMulti(Payr0250DTO dtoPayr0250,   List<PrgmComPsnl0100DTO> listDtoPsnl0100)  throws MSFException  {
        
    	  PagingLoadResult<ShowMessageBM> retval = null;
      
        
        try { 
            
        	   List<InfcPkgPsnl0100VO>   listInfcPkgPsnl0100Vo = new  ArrayList<InfcPkgPsnl0100VO>(); 
        	 
        	   for(int iPayrCnt=0;iPayrCnt < listDtoPsnl0100.size();iPayrCnt++) {
                   
        		   //삭제로직 호출 
                   Payr0301DTO payr0301Dto = new Payr0301DTO();
        		   PrgmComPsnl0100DTO   prgmComPsnl0100Dto = new PrgmComPsnl0100DTO(); 
                   InfcPkgPsnl0100VO   infcPkgPsnl0100Vo = new  InfcPkgPsnl0100VO(); 
                  
                   prgmComPsnl0100Dto = listDtoPsnl0100.get(iPayrCnt); 
                   
                   BeanUtils.copyProperties(infcPkgPsnl0100Vo, prgmComPsnl0100Dto);  
                                     
                   
                   payr0301Dto.setPymtYrMnth(dtoPayr0250.getJobYrMnth()); 		/** set 지급년월 : pymtYrMnth */
                   payr0301Dto.setPayCd(dtoPayr0250.getPayCd()); 				/** set 급여구분코드 : payCd */
                   payr0301Dto.setDpobCd(dtoPayr0250.getDpobCd());  			/** set 사업장코드 : dpobCd */
                   payr0301Dto.setPayrSeilNum(dtoPayr0250.getPayScduSeilNum());/** set 급여일련번호 : payrSeilNum */
                   
                   payr0301Dto.setSystemkey(prgmComPsnl0100Dto.getSystemkey());
                   
                   Long result = deleteAllOnPayr4150(payr0301Dto,ActionDatabase.DELETE);
                
                   if (result > 0) {
                	   listInfcPkgPsnl0100Vo.add(infcPkgPsnl0100Vo);
                   }
                   
        	   }   
                   
                if (listInfcPkgPsnl0100Vo.size() > 0) {  
                   	
                   	InfcPkgPayr0250VO payr0250Vo =  new InfcPkgPayr0250VO();
                   	
       				payr0250Vo.setDpobCd(dtoPayr0250.getDpobCd());    								/** column ????? : dpobCd */
       				payr0250Vo.setJobYrMnth(dtoPayr0250.getJobYrMnth());    						/** column ???? : jobYrMnth */
       				payr0250Vo.setPayCd(dtoPayr0250.getPayCd());    								/** column ?????? : payCd */
       				payr0250Vo.setPayScduSeilNum(new BigDecimal(dtoPayr0250.getPayScduSeilNum()));	/** column ????????? : payScduSeilNum */
       				payr0250Vo.setPayrMangDeptCd(dtoPayr0250.getPayrMangDeptCd());    				/** column ???????? : payrMangDeptCd */
       				payr0250Vo.setMangeDeptCd(dtoPayr0250.getMangeDeptCd());    					/** column ???? : mangeDeptCd */
       				payr0250Vo.setDeptCd(dtoPayr0250.getDeptCd());    								/** column ???? : deptCd */
       				payr0250Vo.setBusinCd(dtoPayr0250.getBusinCd());    							/** column ???? : businCd */
       				payr0250Vo.setEmymtDivCd(dtoPayr0250.getEmymtDivCd());    						/** column ?????? : emymtDivCd */
       				payr0250Vo.setPernChrgEmpIdenNum(dtoPayr0250.getPernChrgEmpIdenNum());    		/** column ?????? : pernChrgEmpIdenNum */
       				payr0250Vo.setJobNm(dtoPayr0250.getJobNm());    								/** column ??? : jobNm */
       				payr0250Vo.setPymtDt(dtoPayr0250.getPymtDt());    								/** column ???? : pymtDt */
       				payr0250Vo.setRflctnBgnnDt(dtoPayr0250.getRflctnBgnnDt());    					/** column ?????? : rflctnBgnnDt */
       				payr0250Vo.setRflctnEndDt(dtoPayr0250.getRflctnEndDt());    					/** column ?????? : rflctnEndDt */
       				payr0250Vo.setPayDdlneDt(dtoPayr0250.getPayDdlneDt());    						/** column ?????? : payDdlneDt */
       				payr0250Vo.setGroFlCretnDt(dtoPayr0250.getGroFlCretnDt());    					/** column ???????? : groFlCretnDt */ 
       				payr0250Vo.setTypOccuCd(dtoPayr0250.getTypOccuCd());    						/** column ???? : typOccuCd */
       				payr0250Vo.setDtilOccuInttnCd(dtoPayr0250.getDtilOccuInttnCd());    			/** column ?????? : dtilOccuInttnCd */
                   	  
       				
                       PayrListenerAdapter payrAdapter = new PayrListenerAdapter(); 
                       retval =  payrAdapter.setPayr4100ToPayCalcMulti(RemoteServiceUtil.getThreadLocalRequest(), payr0250Vo, listInfcPkgPsnl0100Vo);
                }
          
       
        } catch (Exception ex) {
            //logger.error("EXCEPTION calling activityOnVoceMenu(): "+ex); 
           // result = new Long(0);
           // ex.printStackTrace();
            throw MSFServerUtils.getOperationException("setPayr4100ToPayCalcMulti", ex, logger);
        }
        finally {
          
        }
        
       return retval;
    }
    

    
    /**
     * 
     * <pre>
     * 1. 개요 : 급여출력물 정보 지급항목 추가 쿼리 
     * 2. 처리내용 : 
     * </pre>
     * @Method Name : mutilInsertPayr0485
     * @date : 2018. 1. 11.
     * @author : atres
     * @history : 
     *	-----------------------------------------------------------------------
     *	변경일				작성자						변경내용  
     *	----------- ------------------- ---------------------------------------
     *	2018. 1. 11.		atres				최초 작성 
     *	-----------------------------------------------------------------------
     * 
     * @return
     * @throws MSFException
     */
    private Long mutilInsertPayr0485() throws MSFException  {
        // TODO Auto-generated method stub
        Long result = new Long(1);
        try { 
            
        	payr0485DAO.mutilInsertPayr4150ToPayr0485_01(); 
        	payr0485DAO.mutilInsertPayr4150ToPayr0485_02(); 
        	payr0485DAO.mutilInsertPayr4150ToPayr0485_03(); 
        	payr0485DAO.mutilInsertPayr4150ToPayr0485_04(); 
        }
        catch (Exception ex) {
            logger.error("EXCEPTION calling mutilInsertPayr0485(): "+ex); 
            result = new Long(0);
            throw MSFServerUtils.getOperationException("mutilInsertPayr0485()", ex, logger);
        }
        finally {
          
        }
        return result;
    }
	

	 
 
	 
}
