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

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.any.smrmf.utils.BeanFinder;
import com.app.exterms.payroll.client.dto.Payr0350DTO;
import com.app.exterms.payroll.client.dto.Payr0360DTO;
import com.app.exterms.payroll.client.service.Payr4210Service;
import com.app.exterms.payroll.server.service.dao.Payr0303DAO;
import com.app.exterms.payroll.server.service.dao.Payr0350DAO;
import com.app.exterms.payroll.server.service.dao.Payr0360DAO;
import com.app.exterms.payroll.server.vo.Payr0303VO;
import com.app.exterms.payroll.server.vo.Payr0350SrhVO;
import com.app.exterms.payroll.server.vo.Payr0350VO;
import com.app.exterms.payroll.server.vo.Payr0360SrhVO;
import com.app.exterms.payroll.server.vo.Payr0360VO;
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
import com.app.smrmf.infc.payroll.server.vo.InfcPkgPayr0360VO;
import com.app.smrmf.infc.personal.server.vo.InfcPkgPsnl0100VO;
import com.app.smrmf.pkg.listener.PayrListenerAdapter;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Payr4210Service")
public class Payr4210ServiceImpl extends AbstractCustomServiceImpl implements Payr4210Service  ,PayrDaoConstants {


	private static final Logger logger = LoggerFactory.getLogger(Payr4210ServiceImpl.class);
	private static final String calledClass = Payr4210ServiceImpl.class.getName();
	
	@Autowired
    @Resource(name="Payr0350DAO")
    private Payr0350DAO payr0350DAO;
     
	@Autowired
    @Resource(name="Payr0360DAO")
    private Payr0360DAO payr0360DAO;
     
	@Autowired
    @Resource(name="Payr0303DAO")
    private Payr0303DAO payr0303DAO;
  
	
    /**
     * 
     * @param serviceParameters
     * @return
     * @throws MSFException
     */
    public PagingLoadResult<BaseModel> getPayr4210ToPayr0350DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR4210TOPAYR0350_DATA_LIST;
        Payr0350SrhVO   payr0350SrhVO = new Payr0350SrhVO();
        Payr0350VO      payr0350VO = new Payr0350VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
     
        
        try {
        	
        	payr0350DAO = (Payr0350DAO)BeanFinder.getBean("Payr0350DAO");
        	
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
            payr0350SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드 
            payr0350SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  //급여구분코드 
            payr0350SrhVO.setReattyYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "reattyYr"))); //소급년 
           // payr0350SrhVO.setReattyApptnYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "reattyApptnYrMnth"))); //소급년월
            payr0350SrhVO.setReattyStpDsptyNum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "reattyStpDsptyNum")));  //회차호
            payr0350SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
//            payr0350SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//            payr0350SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
//            payr0350SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
//            
//              if (payr0350SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
//            	  payr0350SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//            	List<String> listDeptCd = null; 
//            	payr0350SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//            	payr0350SrhVO.setDeptCd("");     //부서코드
//            } else {
//
//                List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//                payr0350SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//                payr0350SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드 
//            } 
            
          //  List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
          //  payr0350SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
          //  payr0350SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
           
           // List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
           // payr0350SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
           // payr0350SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
             
           // List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
           // payr0350SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
           // payr0350SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
            
          //  payr0350SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
           
          //  payr0350SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0350DAO.selectPayr4210ToPayr0350ListTotCnt(payr0350SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr4210ToPayr0350DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0350SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                payr0350SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                payr0350SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0350DAO.selectPayr4210ToPayr0350List(payr0350SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr4210ToPayr0350DataList, "getPayr4210ToPayr0350DataList");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
    
    /**
     * 소급계산을 위한 설정 정보를 가지고온다. 
     * @param serviceParameters
     * @return
     * @throws MSFException
     */
    public PagingLoadResult<BaseModel> getPayr4210ToPayr0360DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_PAYR4210TOPAYR0360_DATA_LIST;
        Payr0360SrhVO   payr0360SrhVO = new Payr0360SrhVO();
        Payr0360VO      payr0360VO = new Payr0360VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
       
        try {
        	
        	payr0360DAO = (Payr0360DAO)BeanFinder.getBean("Payr0360DAO");
        	
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
            payr0360SrhVO.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            payr0360SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
            
            payr0360SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
            
            payr0360SrhVO.setUsrId(sessionUser.getUsrId());  
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	
            	if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {

                   payr0360SrhVO.setDeptCd(sessionUser.getDeptCd()); 
                   listDeptCd.add(sessionUser.getDeptCd());
                   payr0360SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
                    
           	 } else {
           		 
           		 payr0360SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                 listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                 payr0360SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
                    
           	 }  
            	
               payr0360SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	payr0360SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드 
                     if (payr0360SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	payr0360SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
                     	payr0360SrhVO.setDeptCd("");  //부서코드
                     } else {
                    	 payr0360SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          payr0360SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
           
            payr0360SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            payr0360SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
           /******************************** 권한 ************************************************************************/
          
//            if (payr0360SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
//            	payr0360SrhVO.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//            	List<String> listDeptCd = null; 
//            	payr0360SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//            	payr0360SrhVO.setDeptCd("");     //부서코드
//            } else {
//
//                List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//                payr0360SrhVO.setDeptCdArr(listDeptCd);     //부서코드  
//                payr0360SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드 
//            }
            
            
            
            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
            payr0360SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
            payr0360SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
           
//            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//            payr0360SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//            payr0360SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
             
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            payr0360SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            payr0360SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
            
            payr0360SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
            
            payr0360SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  //급여구분코드 
            payr0360SrhVO.setReattyApptnYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "reattyApptnYrMnth"))); //소급년월
            payr0360SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            payr0360SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
         
            payr0360SrhVO.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd")));    //관리부서 
            payr0360SrhVO.setRepbtyBusinDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "repbtyBusinDivCd")) ); //호봉제구분

            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = payr0360DAO.selectPayr4210ToPayr0360ListTotCnt(payr0360SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPayr4210ToPayr0360DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0360SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                payr0360SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                payr0360SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = payr0360DAO.selectPayr4210ToPayr0360List(payr0360SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginPayr4210ToPayr0360DataList, "getPayr4210ToPayr0360DataList");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }

    /**
     * 회차번호 정보를 가지고 온다.
     * @param serviceParameters
     * @return
     * @throws MSFException
     */
	public PagingLoadResult<BaseModel> getCboReattyStpDsptyNumList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method = CLASS_PAYR0360_REATTY_STP_DSPTY_NUM;
        Payr0360SrhVO   payr0360SrhVO = new Payr0360SrhVO();
        Payr0360VO      payr0360VO = new Payr0360VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
//    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
       
        try {
        	 
        	payr0360DAO = (Payr0360DAO)BeanFinder.getBean("Payr0360DAO");
        	
        	
             ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
             IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
             List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
             PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
 
 	         
        	
            //Get paging configuration
             PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);

            //Get query parameters
           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
           
             
             
             
            /** 조건절 */
             payr0360SrhVO.setDpobCd(sessionUser.getDpobCd()); 
             payr0360SrhVO.setPayCd("");  //급여구분코드 
             payr0360SrhVO.setReattyYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "reattyYr"))); //소급년월 
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	        if ( pagingValues.executeRecordCount ) { 
	            	
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt =  payr0360DAO.selectPayr0360ReattyStpDsptyNumListTotCnt(payr0360SrhVO);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;	       
                
               logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectPayr0360ReattyStpDsptyNumList = SmrmfUtils.startTiming(logger);
         
          
            /**페이지 카운트 처리를 위한 부분 */ 
            payr0360SrhVO.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	payr0360SrhVO.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.totalRecordCount < 100) {
            	payr0360SrhVO.setLastIndex(pagingValues.totalRecordCount); 
            } else  if (pagingValues.offsetLimit > 0) {
            	payr0360SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            } 

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ?????? 
            List list = payr0360DAO.selectPayr0360ReattyStpDsptyNumList(payr0360SrhVO);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectPayr0360ReattyStpDsptyNumList, "getCboPayr0360ReattyStpDsptyNumList");
            
       

        }
        catch (Exception ex) {
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }
	
	

    @Override
    public PagingLoadResult<ShowMessageBM>  setPayr4210ToPayCalculation(Payr0360DTO payr0360Dto, ActionDatabase actionDatabase)  throws MSFException  {
        // TODO Auto-generated method stub
    	 PagingLoadResult<ShowMessageBM> retval = null;
         MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
         try { 
             
             //삭제로직 호출  
        	 Long result = activityOnDeletePayr4210(payr0360Dto) ; 
             
             if (result > 0) {
            	 
                InfcPkgPayr0360VO infcPayr0360Vo = new InfcPkgPayr0360VO();  

				infcPayr0360Vo.setDpobCd(payr0360Dto.getDpobCd());    						/** column 사업장코드 : dpobCd */
				infcPayr0360Vo.setPayCd(payr0360Dto.getPayCd());    						/** column 급여구분코드 : payCd */
				infcPayr0360Vo.setReattyYr(payr0360Dto.getReattyYr());   	 				/** column 소급년도 : reattyYr */
				infcPayr0360Vo.setReattyStpDsptyNum(payr0360Dto.getReattyStpDsptyNum());    /** column 소급설정회차번호 : reattyStpDsptyNum */
				infcPayr0360Vo.setReattyApptnYrMnth(payr0360Dto.getReattyApptnYrMnth());    /** column 소급계산년월 : reattyApptnYrMnth */
				infcPayr0360Vo.setReattyPymtDt(payr0360Dto.getReattyPymtDt());    			/** column 소급지급일자 : reattyPymtDt */
				infcPayr0360Vo.setEmymtDivCd(payr0360Dto.getEmymtDivCd());    				/** column 고용구분코드 : emymtDivCd */
				infcPayr0360Vo.setPayrMangDeptCd(payr0360Dto.getPayrMangDeptCd());    		/** column 급여관리부서코드 : payrMangDeptCd */
				infcPayr0360Vo.setDeptCd(payr0360Dto.getDeptCd());    						/** column 부서코드 : deptCd */
				infcPayr0360Vo.setBusinCd(payr0360Dto.getBusinCd());    					/** column 사업코드 : businCd */
				infcPayr0360Vo.setTypOccuCd(payr0360Dto.getTypOccuCd());    				/** column 직종코드 : typOccuCd */
				infcPayr0360Vo.setDtilOccuInttnCd(payr0360Dto.getDtilOccuInttnCd());    	/** column 직종세구분코드 : dtilOccuInttnCd */
				infcPayr0360Vo.setPymtMnthStp01((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp01()) ? "Y" : "N"));    /** column 지급월설정_01 : pymtMnthStp01 */
				infcPayr0360Vo.setPymtMnthStp02((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp02()) ? "Y" : "N"));    /** column 지급월설정_02 : pymtMnthStp02 */
				infcPayr0360Vo.setPymtMnthStp03((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp03()) ? "Y" : "N"));    /** column 지급월설정_03 : pymtMnthStp03 */
				infcPayr0360Vo.setPymtMnthStp04((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp04()) ? "Y" : "N"));    /** column 지급월설정_04 : pymtMnthStp04 */
				infcPayr0360Vo.setPymtMnthStp05((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp05()) ? "Y" : "N"));    /** column 지급월설정_05 : pymtMnthStp05 */
				infcPayr0360Vo.setPymtMnthStp06((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp06()) ? "Y" : "N"));    /** column 지급월설정_06 : pymtMnthStp06 */
				infcPayr0360Vo.setPymtMnthStp07((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp07()) ? "Y" : "N"));    /** column 지급월설정_07 : pymtMnthStp07 */
				infcPayr0360Vo.setPymtMnthStp08((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp08()) ? "Y" : "N"));    /** column 지급월설정_08 : pymtMnthStp08 */
				infcPayr0360Vo.setPymtMnthStp09((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp09()) ? "Y" : "N"));    /** column 지급월설정_09 : pymtMnthStp09 */
				infcPayr0360Vo.setPymtMnthStp10((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp10()) ? "Y" : "N"));    /** column 지급월설정_10 : pymtMnthStp10 */
				infcPayr0360Vo.setPymtMnthStp11((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp11()) ? "Y" : "N"));    /** column 지급월설정_11 : pymtMnthStp11 */
				infcPayr0360Vo.setPymtMnthStp12((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp12()) ? "Y" : "N"));    /** column 지급월설정_12 : pymtMnthStp12 */
				infcPayr0360Vo.setReattyStpNoteCtnt(payr0360Dto.getReattyStpNoteCtnt());    			/** column 소급설정내용 : reattyStpNoteCtnt */
				infcPayr0360Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */
				infcPayr0360Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  /** column 입력주소 : inptAddr */
				infcPayr0360Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
				infcPayr0360Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());	/** column 수정주소 : revnAddr */

                 PayrListenerAdapter payrAdapter = new PayrListenerAdapter(); 
                 retval =  payrAdapter.setPayr4210ToRetoCalculation(RemoteServiceUtil.getThreadLocalRequest(),infcPayr0360Vo);
             }
        
         } catch (Exception ex) {
             logger.error("EXCEPTION calling setPayr4210ToPayCalculation(): "+ex); 
             //result = new Long(0); 
             throw MSFServerUtils.getOperationException("setPayr4210ToPayCalculation", ex, logger);
         }
         finally {
           
         }
         
        return retval;
    }


	  
    @Override
    public PagingLoadResult<ShowMessageBM> setPayr4210ToPayCalcSeft(Payr0360DTO payr0360Dto, ArrayList<PrgmComPsnl0100DTO> dtoListPsnl0100, ActionDatabase actionDatabase) {
    	 PagingLoadResult<ShowMessageBM> retval = null;
         MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
         Long iCnt = new Long(0);
       try { 
             
    	   ArrayList<InfcPkgPsnl0100VO>   listInfcPkgPsnl0100Vo = new  ArrayList<InfcPkgPsnl0100VO>();
    	   
    	   for(int iPayrCnt=0;iPayrCnt < dtoListPsnl0100.size();iPayrCnt++) { 
               
			    Payr0350VO  payr0350Vo = new Payr0350VO(); 
			    PrgmComPsnl0100DTO sysComPsnl0100Dto = new PrgmComPsnl0100DTO();
			    sysComPsnl0100Dto = dtoListPsnl0100.get(iPayrCnt); 
			   
			    //20161201 패키지 변경에 따른 수정 atres
			    InfcPkgPsnl0100VO   infcPkgPsnl0100Vo = new  InfcPkgPsnl0100VO(); 
		        BeanUtils.copyProperties(infcPkgPsnl0100Vo, sysComPsnl0100Dto);  
		           
			    
			    payr0350Vo.setDpobCd(payr0360Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
			    payr0350Vo.setPayCd(payr0360Dto.getPayCd());    /** column 급여구분코드 : payCd */
			    payr0350Vo.setReattyYr(payr0360Dto.getReattyYr());    /** column 소급년도 : reattyYr */
			    payr0350Vo.setReattyStpDsptyNum(payr0360Dto.getReattyStpDsptyNum());    /** column 소급설정회차번호 : reattyStpDsptyNum */ 
				payr0350Vo.setSystemkey(MSFSharedUtils.allowNulls(sysComPsnl0100Dto.getSystemkey()));
			
				Long rtnCnt = deleteCommPayr4210(payr0350Vo);
				
				if (rtnCnt > 0L) {
					iCnt = iCnt + 1; 
				}
               
            } 
    	   
            
             
             if (iCnt > 0) {
            	 
            	 
                Long iuCnt =  setPayr4210TPayr0360Update(payr0360Dto, actionDatabase);
             
                if (iuCnt > 0L) { 
                	
	                InfcPkgPayr0360VO infcPayr0360Vo = new InfcPkgPayr0360VO();  
	
					infcPayr0360Vo.setDpobCd(payr0360Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
					infcPayr0360Vo.setPayCd(payr0360Dto.getPayCd());    /** column 급여구분코드 : payCd */
					infcPayr0360Vo.setReattyYr(payr0360Dto.getReattyYr());    /** column 소급년도 : reattyYr */
					infcPayr0360Vo.setReattyStpDsptyNum(payr0360Dto.getReattyStpDsptyNum());    /** column 소급설정회차번호 : reattyStpDsptyNum */
					infcPayr0360Vo.setReattyApptnYrMnth(payr0360Dto.getReattyApptnYrMnth());    /** column 소급계산년월 : reattyApptnYrMnth */
					infcPayr0360Vo.setReattyPymtDt(payr0360Dto.getReattyPymtDt());    /** column 소급지급일자 : reattyPymtDt */
					infcPayr0360Vo.setEmymtDivCd(payr0360Dto.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
					infcPayr0360Vo.setPayrMangDeptCd(payr0360Dto.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
					infcPayr0360Vo.setDeptCd(payr0360Dto.getDeptCd());    /** column 부서코드 : deptCd */
					infcPayr0360Vo.setBusinCd(payr0360Dto.getBusinCd());    /** column 사업코드 : businCd */
					infcPayr0360Vo.setTypOccuCd(payr0360Dto.getTypOccuCd());    /** column 직종코드 : typOccuCd */
					infcPayr0360Vo.setDtilOccuInttnCd(payr0360Dto.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
					infcPayr0360Vo.setPymtMnthStp01((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp01()) ? "Y" : "N"));    /** column 지급월설정_01 : pymtMnthStp01 */
					infcPayr0360Vo.setPymtMnthStp02((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp02()) ? "Y" : "N"));    /** column 지급월설정_02 : pymtMnthStp02 */
					infcPayr0360Vo.setPymtMnthStp03((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp03()) ? "Y" : "N"));    /** column 지급월설정_03 : pymtMnthStp03 */
					infcPayr0360Vo.setPymtMnthStp04((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp04()) ? "Y" : "N"));    /** column 지급월설정_04 : pymtMnthStp04 */
					infcPayr0360Vo.setPymtMnthStp05((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp05()) ? "Y" : "N"));    /** column 지급월설정_05 : pymtMnthStp05 */
					infcPayr0360Vo.setPymtMnthStp06((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp06()) ? "Y" : "N"));    /** column 지급월설정_06 : pymtMnthStp06 */
					infcPayr0360Vo.setPymtMnthStp07((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp07()) ? "Y" : "N"));    /** column 지급월설정_07 : pymtMnthStp07 */
					infcPayr0360Vo.setPymtMnthStp08((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp08()) ? "Y" : "N"));    /** column 지급월설정_08 : pymtMnthStp08 */
					infcPayr0360Vo.setPymtMnthStp09((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp09()) ? "Y" : "N"));    /** column 지급월설정_09 : pymtMnthStp09 */
					infcPayr0360Vo.setPymtMnthStp10((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp10()) ? "Y" : "N"));    /** column 지급월설정_10 : pymtMnthStp10 */
					infcPayr0360Vo.setPymtMnthStp11((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp11()) ? "Y" : "N"));    /** column 지급월설정_11 : pymtMnthStp11 */
					infcPayr0360Vo.setPymtMnthStp12((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp12()) ? "Y" : "N"));    /** column 지급월설정_12 : pymtMnthStp12 */
					infcPayr0360Vo.setReattyStpNoteCtnt(payr0360Dto.getReattyStpNoteCtnt());    /** column 소급설정내용 : reattyStpNoteCtnt */
					infcPayr0360Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
					infcPayr0360Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
					infcPayr0360Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
					infcPayr0360Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
	
	                 PayrListenerAdapter payrAdapter = new PayrListenerAdapter(); 
	                 retval =  payrAdapter.setPayr4210ToPayCalcSeft(RemoteServiceUtil.getThreadLocalRequest(),infcPayr0360Vo,listInfcPkgPsnl0100Vo);
                }    
             }
                
      
        } catch (Exception ex) {
            //logger.error("EXCEPTION calling setPayr4210ToPayCalcSeft(): "+ex); 
           // result = new Long(0);
           // ex.printStackTrace();
            throw MSFServerUtils.getOperationException("setPayr4210ToPayCalcSeft", ex, logger);
        }
        finally {
          
        }
        
       return retval;
    }
    
	  
	 /**
	  * 신규 업데이트 및 저장 
	  */
	 @Override 
	 public Long setPayr4210TPayr0360Update(Payr0360DTO payr0360Dto, ActionDatabase actionDatabase)  throws MSFException {

	        Long retval = 0L;
	   
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        try {   
        
					    Payr0360VO  payr0360Vo = new Payr0360VO();   
					    
					    payr0360Vo.setDpobCd(payr0360Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
					    payr0360Vo.setPayCd(payr0360Dto.getPayCd());    /** column 급여구분코드 : payCd */
					    payr0360Vo.setReattyYr(payr0360Dto.getReattyYr());    /** column 소급년도 : reattyYr */
					    payr0360Vo.setReattyStpDsptyNum(payr0360Dto.getReattyStpDsptyNum());    /** column 소급설정회차번호 : reattyStpDsptyNum */
   
						payr0360Vo.setReattyApptnYrMnth(payr0360Dto.getReattyApptnYrMnth());    /** column 소급계산년월 : reattyApptnYrMnth */
						payr0360Vo.setReattyPymtDt(payr0360Dto.getReattyPymtDt());    /** column 소급지급일자 : reattyPymtDt */
						payr0360Vo.setEmymtDivCd(payr0360Dto.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
						payr0360Vo.setPayrMangDeptCd(payr0360Dto.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
						payr0360Vo.setDeptCd(payr0360Dto.getDeptCd());    /** column 부서코드 : deptCd */
						payr0360Vo.setBusinCd(payr0360Dto.getBusinCd());    /** column 사업코드 : businCd */
						payr0360Vo.setTypOccuCd(payr0360Dto.getTypOccuCd());    /** column 직종코드 : typOccuCd */
						payr0360Vo.setDtilOccuInttnCd(payr0360Dto.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
						payr0360Vo.setPymtMnthStp01((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp01()) ? "Y" : "N"));    /** column 지급월설정_01 : pymtMnthStp01 */
						payr0360Vo.setPymtMnthStp02((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp02()) ? "Y" : "N"));    /** column 지급월설정_02 : pymtMnthStp02 */
						payr0360Vo.setPymtMnthStp03((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp03()) ? "Y" : "N"));    /** column 지급월설정_03 : pymtMnthStp03 */
						payr0360Vo.setPymtMnthStp04((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp04()) ? "Y" : "N"));    /** column 지급월설정_04 : pymtMnthStp04 */
						payr0360Vo.setPymtMnthStp05((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp05()) ? "Y" : "N"));    /** column 지급월설정_05 : pymtMnthStp05 */
						payr0360Vo.setPymtMnthStp06((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp06()) ? "Y" : "N"));    /** column 지급월설정_06 : pymtMnthStp06 */
						payr0360Vo.setPymtMnthStp07((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp07()) ? "Y" : "N"));    /** column 지급월설정_07 : pymtMnthStp07 */
						payr0360Vo.setPymtMnthStp08((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp08()) ? "Y" : "N"));    /** column 지급월설정_08 : pymtMnthStp08 */
						payr0360Vo.setPymtMnthStp09((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp09()) ? "Y" : "N"));    /** column 지급월설정_09 : pymtMnthStp09 */
						payr0360Vo.setPymtMnthStp10((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp10()) ? "Y" : "N"));    /** column 지급월설정_10 : pymtMnthStp10 */
						payr0360Vo.setPymtMnthStp11((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp11()) ? "Y" : "N"));    /** column 지급월설정_11 : pymtMnthStp11 */
						payr0360Vo.setPymtMnthStp12((Boolean.TRUE.equals(payr0360Dto.getPymtMnthStp12()) ? "Y" : "N"));    /** column 지급월설정_12 : pymtMnthStp12 */
						payr0360Vo.setTgtSystemkey(payr0360Dto.getTgtSystemkey());    /** column TGT_SYSTEMKEY : tgtSystemkey */
						payr0360Vo.setReattyStpNoteCtnt(payr0360Dto.getReattyStpNoteCtnt());    /** column 소급설정내용 : reattyStpNoteCtnt */
						payr0360Vo.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
						payr0360Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
						payr0360Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
						payr0360Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */
					      
				        
					    switch (actionDatabase) { 
			            case INSERT:
			            	payr0360DAO.insertPayr0360(payr0360Vo);
			               break;
			            case UPDATE: 
			            	payr0360DAO.updatePayr0360(payr0360Vo);
			                break;
			            case DELETE:
			            	//payr0360DAO.deletePayr0360(payr0360Vo);
			                break;
						default:
							break;
			            }
				            
					     
					    retval = 1L;
	        }
	        catch (Exception ex) {
	        	 
	            logger.error("EXCEPTION calling setPayr4210TPayr0360Update(): "+ex); 
	            retval = 0L;
	            throw MSFServerUtils.getOperationException("setPayr4210TPayr0360Update", ex, logger);
	        } 
	        
	        return retval;
	} 
	 
	
	  @Override
		 public Long activityOnDeletePayr4210(Payr0360DTO payr0360Dto)  throws MSFException {

		        Long retval = 0L;
		   
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		        try {   
            
						    Payr0360VO  payr0360Vo = new Payr0360VO();  
						    Payr0350VO  payr0350Vo = new Payr0350VO(); 
						    Payr0303VO  payr0303Vo = new Payr0303VO(); 
						   
						    
						    payr0360Vo.setDpobCd(payr0360Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
						    payr0360Vo.setPayCd(payr0360Dto.getPayCd());    /** column 급여구분코드 : payCd */
						    payr0360Vo.setReattyYr(payr0360Dto.getReattyYr());    /** column 소급년도 : reattyYr */
						    payr0360Vo.setReattyStpDsptyNum(payr0360Dto.getReattyStpDsptyNum());    /** column 소급설정회차번호 : reattyStpDsptyNum */

							BeanUtils.copyProperties(payr0350Vo, payr0360Vo);
							BeanUtils.copyProperties(payr0303Vo, payr0360Vo); 
							
							payr0350Vo.setSystemkey(MSFSharedUtils.allowNulls(payr0360Dto.getTgtSystemkey()));
							payr0303Vo.setSystemkey(MSFSharedUtils.allowNulls(payr0360Dto.getTgtSystemkey()));
							
							payr0303DAO.deletePayr4210ToPayr0303(payr0303Vo); 
							payr0350DAO.deletePayr4210ToPayr0350(payr0350Vo);
							payr0360DAO.deletePayr0360(payr0360Vo); 
					        
						    retval = 1L;
		        }
		        catch (Exception ex) {
		        	 
		            logger.error("EXCEPTION calling activityOnDeletePayr4210(): "+ex); 
		            retval = 0L;
		            throw MSFServerUtils.getOperationException("activityOnDeletePayr4210", ex, logger);
		        } 
		        
		        return retval;
		} 

	  @Override
	 public Long setPayr4210ToPayr0350Delete(List<Payr0350DTO> listPayr0350dto)  throws MSFException {

		    Long result = new Long(0);
	        Long iCnt = new Long(0);
	        try {  
	             
	        	  payr0350DAO = (Payr0350DAO)BeanFinder.getBean("Payr0350DAO");
	        	  payr0303DAO = (Payr0303DAO)BeanFinder.getBean("Payr0303DAO");
	          
	               for(int iPayrCnt=0;iPayrCnt < listPayr0350dto.size();iPayrCnt++) {
	                

					    Payr0350VO  payr0350Vo = new Payr0350VO(); 
					  
					    Payr0350DTO payr0350Dto = new Payr0350DTO();  
					    payr0350Dto = listPayr0350dto.get(iPayrCnt); 
					   
					    
					    payr0350Vo.setDpobCd(payr0350Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
					    payr0350Vo.setPayCd(payr0350Dto.getPayCd());    /** column 급여구분코드 : payCd */
					    payr0350Vo.setReattyYr(payr0350Dto.getReattyYr());    /** column 소급년도 : reattyYr */
					    payr0350Vo.setReattyStpDsptyNum(payr0350Dto.getReattyStpDsptyNum());    /** column 소급설정회차번호 : reattyStpDsptyNum */ 
						payr0350Vo.setSystemkey(MSFSharedUtils.allowNulls(payr0350Dto.getSystemkey()));
					
						Long rtnCnt = deleteCommPayr4210(payr0350Vo);
						
						if (rtnCnt > 0L) {
							iCnt = iCnt + 1; 
						}
	                    
	               } 
	                result = iCnt;
		    
		        }
		        catch (Exception ex) {
		        	 
		            logger.error("EXCEPTION calling setPayr4210ToPayr0350Delete(): "+ex); 
		            result = 0L;
		            throw MSFServerUtils.getOperationException("setPayr4210ToPayr0350Delete", ex, logger);
		        } 
		        
		        return result;
		} 
	   
	    
		 private Long  deleteCommPayr4210(Payr0350VO  payr0350Vo)  throws MSFException {

			    Long result = new Long(0); 
			    
		        try {  
		           
						    Payr0303VO  payr0303Vo = new Payr0303VO(); 
						  
						 
							payr0303Vo.setDpobCd(payr0350Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
							payr0303Vo.setPayCd(payr0350Vo.getPayCd());    /** column 급여구분코드 : payCd */
							payr0303Vo.setReattyYr(payr0350Vo.getReattyYr());    /** column 소급년도 : reattyYr */
							payr0303Vo.setReattyStpDsptyNum(payr0350Vo.getReattyStpDsptyNum());    /** column 소급설정회차번호 : reattyStpDsptyNum */
							payr0303Vo.setSystemkey(MSFSharedUtils.allowNulls(payr0350Vo.getSystemkey()));  /**column 소급설정회차번호 : systemkey */
							
							payr0303DAO.deletePayr0303(payr0303Vo); 
							payr0350DAO.deletePayr0350(payr0350Vo);
							 
			    
			        }
			        catch (Exception ex) {
			        	 
			            logger.error("EXCEPTION calling deleteCommPayr4210(): "+ex); 
			            result = 0L;
			            throw MSFServerUtils.getOperationException("deleteCommPayr4210", ex, logger);
			        } 
			        
			        return result;
			} 
	     
     
    
    @Override
	   public Payr0360DTO activityOnReadDtlPayr4210ToPayr0360(Payr0360DTO payr0360Dto) throws MSFException {

    		    Payr0360DTO rtnPayr0360Dto= new Payr0360DTO(); 
		   
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		      
		        try {   

		        	payr0360DAO = (Payr0360DAO)BeanFinder.getBean("Payr0360DAO");
		        	 
						  Payr0360VO  payr0360Vo = new Payr0360VO();
						  Payr0360VO  rtnPayr0360Vo = new Payr0360VO();
						  
						  payr0360Vo.setDpobCd(MSFSharedUtils.allowNulls(payr0360Dto.getDpobCd()));    /** column 사업장코드 : dpobCd */
						  payr0360Vo.setPayCd(MSFSharedUtils.allowNulls(payr0360Dto.getPayCd()));    /** column 급여구분코드 : payCd */
						  payr0360Vo.setReattyYr(MSFSharedUtils.allowNulls(payr0360Dto.getReattyYr()));    /** column 소급년도 : reattyYr */
						  payr0360Vo.setReattyStpDsptyNum(MSFSharedUtils.allowNulls(payr0360Dto.getReattyStpDsptyNum()));    /** column 소급설정회차번호 : reattyStpDsptyNum */
						   
						  
						  rtnPayr0360Vo  = payr0360DAO.selectPayr0360(payr0360Vo);
						  
						  if (MSFSharedUtils.paramNotNull(rtnPayr0360Vo)) {
							  

								rtnPayr0360Dto.setDpobCd(rtnPayr0360Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
								rtnPayr0360Dto.setPayCd(rtnPayr0360Vo.getPayCd());    /** column 급여구분코드 : payCd */
								rtnPayr0360Dto.setReattyYr(rtnPayr0360Vo.getReattyYr());    /** column 소급년도 : reattyYr */
								rtnPayr0360Dto.setReattyStpDsptyNum(rtnPayr0360Vo.getReattyStpDsptyNum());    /** column 소급설정회차번호 : reattyStpDsptyNum */
								rtnPayr0360Dto.setReattyApptnYr(rtnPayr0360Vo.getReattyApptnYrMnth().substring(0,4));    /** column 정산년월 : clutYrMnth */
								rtnPayr0360Dto.setReattyApptnMnth(rtnPayr0360Vo.getReattyApptnYrMnth().substring(4,6));    /** column 정산년월 : clutYrMnth */
								rtnPayr0360Dto.setReattyApptnYrMnth(rtnPayr0360Vo.getReattyApptnYrMnth());    /** column 소급계산년월 : reattyApptnYrMnth */
								rtnPayr0360Dto.setReattyPymtDt(rtnPayr0360Vo.getReattyPymtDt());    /** column 소급지급일자 : reattyPymtDt */
								rtnPayr0360Dto.setEmymtDivCd(rtnPayr0360Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
								rtnPayr0360Dto.setPayrMangDeptCd(rtnPayr0360Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
								rtnPayr0360Dto.setDeptCd(rtnPayr0360Vo.getDeptCd());    /** column 부서코드 : deptCd */
								rtnPayr0360Dto.setBusinCd(rtnPayr0360Vo.getBusinCd());    /** column 사업코드 : businCd */
								rtnPayr0360Dto.setTypOccuCd(rtnPayr0360Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
								rtnPayr0360Dto.setDtilOccuInttnCd(rtnPayr0360Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
								rtnPayr0360Dto.setPymtMnthStp01(MSFSharedUtils.convertStringToBoolean(rtnPayr0360Vo.getPymtMnthStp01()));    /** column 지급월설정_01 : pymtMnthStp01 */
								rtnPayr0360Dto.setPymtMnthStp02(MSFSharedUtils.convertStringToBoolean(rtnPayr0360Vo.getPymtMnthStp02()));    /** column 지급월설정_02 : pymtMnthStp02 */
								rtnPayr0360Dto.setPymtMnthStp03(MSFSharedUtils.convertStringToBoolean(rtnPayr0360Vo.getPymtMnthStp03()));    /** column 지급월설정_03 : pymtMnthStp03 */
								rtnPayr0360Dto.setPymtMnthStp04(MSFSharedUtils.convertStringToBoolean(rtnPayr0360Vo.getPymtMnthStp04()));    /** column 지급월설정_04 : pymtMnthStp04 */
								rtnPayr0360Dto.setPymtMnthStp05(MSFSharedUtils.convertStringToBoolean(rtnPayr0360Vo.getPymtMnthStp05()));    /** column 지급월설정_05 : pymtMnthStp05 */
								rtnPayr0360Dto.setPymtMnthStp06(MSFSharedUtils.convertStringToBoolean(rtnPayr0360Vo.getPymtMnthStp06()));    /** column 지급월설정_06 : pymtMnthStp06 */
								rtnPayr0360Dto.setPymtMnthStp07(MSFSharedUtils.convertStringToBoolean(rtnPayr0360Vo.getPymtMnthStp07()));    /** column 지급월설정_07 : pymtMnthStp07 */
								rtnPayr0360Dto.setPymtMnthStp08(MSFSharedUtils.convertStringToBoolean(rtnPayr0360Vo.getPymtMnthStp08()));    /** column 지급월설정_08 : pymtMnthStp08 */
								rtnPayr0360Dto.setPymtMnthStp09(MSFSharedUtils.convertStringToBoolean(rtnPayr0360Vo.getPymtMnthStp09()));    /** column 지급월설정_09 : pymtMnthStp09 */
								rtnPayr0360Dto.setPymtMnthStp10(MSFSharedUtils.convertStringToBoolean(rtnPayr0360Vo.getPymtMnthStp10()));    /** column 지급월설정_10 : pymtMnthStp10 */
								rtnPayr0360Dto.setPymtMnthStp11(MSFSharedUtils.convertStringToBoolean(rtnPayr0360Vo.getPymtMnthStp11()));    /** column 지급월설정_11 : pymtMnthStp11 */
								rtnPayr0360Dto.setPymtMnthStp12(MSFSharedUtils.convertStringToBoolean(rtnPayr0360Vo.getPymtMnthStp12()));    /** column 지급월설정_12 : pymtMnthStp12 */
								rtnPayr0360Dto.setTgtSystemkey(rtnPayr0360Vo.getTgtSystemkey());    /** column TGT_SYSTEMKEY : tgtSystemkey */
								rtnPayr0360Dto.setReattyStpNoteCtnt(rtnPayr0360Vo.getReattyStpNoteCtnt());    /** column null : reattyStpNoteCtnt */
//								rtnPayr0360Dto.setKybdr(rtnPayr0360Vo.getKybdr());    /** column 입력자 : kybdr */
//								rtnPayr0360Dto.setInptDt(rtnPayr0360Vo.getInptDt());    /** column 입력일자 : inptDt */
//								rtnPayr0360Dto.setInptAddr(rtnPayr0360Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//								rtnPayr0360Dto.setIsmt(rtnPayr0360Vo.getIsmt());    /** column 수정자 : ismt */
//								rtnPayr0360Dto.setRevnDt(rtnPayr0360Vo.getRevnDt());    /** column 수정일자 : revnDt */
//								rtnPayr0360Dto.setRevnAddr(rtnPayr0360Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
 

						  }	else {
							  
						  }	  
		        }
		        catch (Exception ex) {
		        	 
		            logger.error("EXCEPTION calling activityOnReadRemt0100(): "+ex);  
		            throw MSFServerUtils.getOperationException("activityOnReadRemt0100", ex, logger);
		            
		        }
		        
		        finally {
		          
		        }
		        
		        return rtnPayr0360Dto;
		}
   
	 
}
