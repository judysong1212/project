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

import org.apache.commons.beanutils.BeanUtils;
import org.gwtrpcspring.RemoteServiceUtil;
import org.msf.utils.SmrmfUtils;
import org.msf.utils.TimingInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.exterms.retirement.client.dto.Remt2000DTO;
import com.app.exterms.retirement.client.dto.Remt2100DTO;
import com.app.exterms.retirement.client.dto.Remt2200DTO;
import com.app.exterms.retirement.client.dto.Remt2300DTO;
import com.app.exterms.retirement.client.dto.Remt3100DTO;
import com.app.exterms.retirement.client.dto.RemtDays0100DTO;
import com.app.exterms.retirement.client.service.Remt0100Service;
import com.app.exterms.retirement.server.service.dao.Remt2000DAO;
import com.app.exterms.retirement.server.service.dao.Remt2100DAO;
import com.app.exterms.retirement.server.service.dao.Remt2200DAO;
import com.app.exterms.retirement.server.service.dao.Remt2300DAO;
import com.app.exterms.retirement.server.service.dao.Remt3000DAO;
import com.app.exterms.retirement.server.service.dao.Remt3100DAO;
import com.app.exterms.retirement.server.service.dao.Remt3200DAO;
import com.app.exterms.retirement.server.vo.Remt2000SrhVO;
import com.app.exterms.retirement.server.vo.Remt2000VO;
import com.app.exterms.retirement.server.vo.Remt2100SrhVO;
import com.app.exterms.retirement.server.vo.Remt2100VO;
import com.app.exterms.retirement.server.vo.Remt2200SrhVO;
import com.app.exterms.retirement.server.vo.Remt2200VO;
import com.app.exterms.retirement.server.vo.Remt2300SrhVO;
import com.app.exterms.retirement.server.vo.Remt2300VO;
import com.app.exterms.retirement.server.vo.Remt3000VO;
import com.app.exterms.retirement.server.vo.Remt3100SrhVO;
import com.app.exterms.retirement.server.vo.Remt3100VO;
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
import com.app.smrmf.infc.retirement.server.service.dao.InfcPkgRemt2300DAO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2000VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2200VO;
import com.app.smrmf.infc.retirement.server.vo.InfcPkgRemt2300VO;
import com.app.smrmf.pkg.listener.remt.remt2018.RemtListenerAdapter;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("Remt0100Service")
public class Remt0100ServiceImpl extends AbstractCustomServiceImpl implements Remt0100Service  ,RemtDaoConstants {

    private static final Logger logger = LoggerFactory.getLogger(Remt0100ServiceImpl.class);
    private static final String calledClass = Remt0100ServiceImpl.class.getName();
    
    @Autowired
    @Resource(name="Remt2000DAO")
    private Remt2000DAO remt2000DAO;
    
    @Autowired
    @Resource(name="Remt2100DAO")
    private Remt2100DAO remt2100DAO;
    
    @Autowired
    @Resource(name="Remt2200DAO")
    private Remt2200DAO remt2200DAO;
    
    @Autowired
    @Resource(name="Remt2300DAO")
    private Remt2300DAO remt2300DAO;
    
    @Autowired
    @Resource(name="InfcPkgRemt2300DAO")
    private InfcPkgRemt2300DAO infcRemt2300DAO;
    
    @Autowired
    @Resource(name="Remt3000DAO")
    private Remt3000DAO remt3000DAO;
    
    
    @Autowired
    @Resource(name="Remt3200DAO")
    private Remt3200DAO remt3200DAO;
    
    
    @Autowired
    @Resource(name="Remt3100DAO")
    private Remt3100DAO remt3100DAO;
    
    /** ID Generation */
    //@Resource(name="{egovRemt2000IdGnrService}")    
    //private EgovIdGnrService egovIdGnrService;


    /** 
     * 퇴직금계산 대상자 조회
     * @param serviceParameters
     * @return
     * @throws MSFException
     */
    public PagingLoadResult<BaseModel> getPsnl0100ToRemt0100DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
//        String method =  "getPsnl0100ToRemt0100DataList";
        String method =  CLASS_SYSCOM_PSNL0100_REMT0100_DATALIST;
        Remt2000SrhVO   remt2000SrhVo = new Remt2000SrhVO();
        Remt2000VO      remt2000Vo = new Remt2000VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(remt2000DAO)) {
        
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            remt2000DAO = (Remt2000DAO) wac.getBean("Remt2000DAO" ); 
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
            remt2000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
            remt2000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
            remt2000SrhVo.setUsrId(sessionUser.getUsrId());  
              
            
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	remt2000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
               remt2000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	    
            	 remt2000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
                     if (remt2000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                     	remt2000SrhVo.setDeptCd("");  //부서코드
                     } else {
                    	 remt2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
                  
            }
            
            remt2000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            remt2000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
//            String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
//            if ("FALSE".equals(chkTypOccuCd)) {
//            	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
//            	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
//            } else {
//            	
//            }
            
           /******************************** 권한 ************************************************************************/
            
            
//            if (remt2000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) {
//            	remt2000SrhVo.setPayrMangDeptYn("Y");  //단위기관담당자여부 
//            	List<String> listDeptCd = null; 
//                remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//                remt2000SrhVo.setDeptCd("");     //부서코드
//            } else {
//            	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//                remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//                remt2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//            }   
            
//            List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//            remt2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드  
//            remt2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"))); 
            
            
            
            remt2000SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYrMnth"))); //퇴직정산년월
            remt2000SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnDivCd")));  //퇴직정산구분코드  
            
           
            remt2000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
            
            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
            remt2000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
            remt2000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
           
//            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//            remt2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//            remt2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
             
            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
            remt2000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
            remt2000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세 
            
            remt2000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
            remt2000SrhVo.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
          
            remt2000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
            remt2000SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
            
            String strHdofcCodtnCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"));
            
            List<String> listHdofcCodtnCd = new ArrayList<String>(); 
           
            String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
            
            for (int i=0; i<ray.length; i++){ 
                listHdofcCodtnCd.add(ray[i]);
            } 
            remt2000SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);    //재직상
            remt2000SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));    //재직상
            
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = remt2000DAO.selectPsnl0100ToRemt0100ListTotCnt(remt2000SrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginPsnl0100ToRemt0100DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            remt2000SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                remt2000SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                remt2000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list  
            List list = remt2000DAO.selectPsnl0100ToRemt0100List(remt2000SrhVo);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToRemt0100DataList, "getPsnl0100ToRemt0100DataList");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    } 
    
    /**
     * 퇴직금지급내역 조회 
     * @param serviceParameters
     * @return
     * @throws MSFException
     */
    public PagingLoadResult<BaseModel> getSelectRemtPymt0100ToRemt2000List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_REMTPYMT0100_REMT2000_DATALIST;
        Remt2000SrhVO   remt2000SrhVo = new Remt2000SrhVO();
        Remt2000VO      remt2000Vo = new Remt2000VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(remt2000DAO)) {
        
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            remt2000DAO = (Remt2000DAO) wac.getBean("Remt2000DAO" ); 
        }
        
    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
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
            remt2000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드 D
            remt2000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키 
            remt2000SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYrMnth"))); //퇴직정산년월
            remt2000SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnDivCd")));  //퇴직정산구분코드  
            
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
             if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = remt2000DAO.selectRemtPymt0100ToRemt2000ListTotCnt(remt2000SrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginRemtPymt0100ToRemt2000DataList = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            remt2000SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
            	remt2000SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
            	remt2000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list  
            List list = remt2000DAO.selectRemtPymt0100ToRemt2000List(remt2000SrhVo);
            
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
            
            SmrmfUtils.endTiming(logger, millisBeginRemtPymt0100ToRemt2000DataList, "getSelectRemtPymt0100ToRemt2000List");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }  
    
    
       /**
        * 퇴직금 계산에 따른 정산 내역조회
        * @param serviceParameters
        * @return
        * @throws MSFException
        */
	   public PagingLoadResult<BaseModel> getSelectRemt0100ToRemt3100List(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_REMT3100_REMT0100_DATALIST;
	        Remt3100SrhVO   remt3100SrhVo = new Remt3100SrhVO();
	        Remt3100VO      remt3100Vo = new Remt3100VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	    	// 1. 암호화 객체 생성
	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
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
	            remt3100SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드 
	            remt3100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키 
	          //  remt3100SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYrMnth"))); //퇴직정산년월
	           // remt3100SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnDivCd")));  //퇴직정산구분코드  
	            
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	             if ( pagingValues.executeRecordCount ) { 
	                    
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = remt3100DAO.selectRemt0100ToRemt3100ListTotCnt(remt3100SrhVo);  
	              
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;        
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginRemt0100ToRemt3100DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            remt3100SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	remt3100SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	remt3100SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list  
	            List list = remt3100DAO.selectRemt0100ToRemt3100List(remt3100SrhVo);
	            
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginRemt0100ToRemt3100DataList, "getSelectRemt0100ToRemt3100List");
	       

	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    } 
	   
	  /**
	   * 최근 3개월간 기본급여 및 제수당 
	   * @param serviceParameters
	   * @return
	   * @throws MSFException
	   */
	   public PagingLoadResult<BaseModel> getSelectRemt0100ToRemtRemt2200List(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_REMT0100_REMT2200_DATALIST;
	        Remt2200SrhVO   Remt2200SrhVo = new Remt2200SrhVO();
	        Remt2200VO      Remt2200Vo = new Remt2200VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	    	// 1. 암호화 객체 생성
	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

	        
	        if  (MSFSharedUtils.paramNull(remt2200DAO)) {
	        
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            remt2200DAO = (Remt2200DAO) wac.getBean("Remt2200DAO" ); 
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
	            Remt2200SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드 
	            Remt2200SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키 
	            Remt2200SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYrMnth"))); //퇴직정산년월
	            Remt2200SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnDivCd")));  //퇴직정산구분코드  
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	             if ( pagingValues.executeRecordCount ) { 
	                    
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = remt2200DAO.selectRemt0100ToRemt2200ListTotCnt(Remt2200SrhVo);  
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;        
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginRemt0100ToRemt2200DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            Remt2200SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	Remt2200SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	Remt2200SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list  
	            List list = remt2200DAO.selectRemt0100ToRemt2200List(Remt2200SrhVo);
	            
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginRemt0100ToRemt2200DataList, "getSelectRemt0100ToRemt2200List");
	       

	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    } 
	   
	   /**
	    * 퇴직금급여 - 후생복지비 내역을 조회한다.
	    * @param serviceParameters
	    * @return
	    * @throws MSFException
	    */
	   public PagingLoadResult<BaseModel> getSelectRemtWfep0100ToRemtRemt2200List(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_REMTWFEP0100_REMT2200_DATALIST;
	        Remt2200SrhVO   Remt2200SrhVo = new Remt2200SrhVO();
	        Remt2200VO      Remt2200Vo = new Remt2200VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	    	// 1. 암호화 객체 생성
	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(remt2200DAO)) {
	        
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            remt2200DAO = (Remt2200DAO) wac.getBean("Remt2200DAO" ); 
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
	            Remt2200SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드 
	            Remt2200SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키 
	            Remt2200SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYrMnth"))); //퇴직정산년월
	            Remt2200SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnDivCd")));  //퇴직정산구분코드  
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	             if ( pagingValues.executeRecordCount ) { 
	                    
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = remt2200DAO.selectRemtWfep0100ToRemt2200ListTotCnt(Remt2200SrhVo);  
	              
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;        
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginRemtWfep0100ToRemt2200DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            Remt2200SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	Remt2200SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	Remt2200SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list  
	            List list = remt2200DAO.selectRemtWfep0100ToRemt2200List(Remt2200SrhVo);
	            
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginRemtWfep0100ToRemt2200DataList, "getSelectRemtWfep0100ToRemt2200List");
	       

	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    } 
	   
	   
	   /**
	    * 퇴직금 공제항목 리스트 출력 
	    * @param serviceParameters
	    * @return
	    * @throws MSFException
	    */
	   public PagingLoadResult<BaseModel> getSelectRemt0100ToRemt2300List(ServiceParameters serviceParameters) throws MSFException {

	        PagingLoadResult<BaseModel> retval = null;
	        String method =  CLASS_REMT0100_REMT2300_DATA_LIST;
	        Remt2300SrhVO   Remt2300SrhVo = new Remt2300SrhVO();
	        Remt2300VO      Remt2300Vo = new Remt2300VO();
	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	    	// 1. 암호화 객체 생성
	    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        if  (MSFSharedUtils.paramNull(remt2300DAO)) {
	        
	            WebApplicationContext wac = WebApplicationContextUtils.
	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	            remt2300DAO = (Remt2300DAO) wac.getBean("Remt2300DAO" ); 
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
	            Remt2300SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드 
	            Remt2300SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키 
	            Remt2300SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "calcSevePayPsnDivCd")));    /** set 퇴직정산구분코드 : calcSevePayPsnDivCd */
	            Remt2300SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYrMnth")));   /** set 정산년월 : clutYrMnth */
	            
	           
	            
	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
	             if ( pagingValues.executeRecordCount ) { 
	                    
	                //Execute query that returns a single value
	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	                int iResultCnt = remt2300DAO.selectRemt0100ToRemt2300ListTotCnt(Remt2300SrhVo);  
	                if (!pagingValues.pageExecute) { 
	                    pagingValues.offsetLimit = iResultCnt;       
	                }
	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
	                pagingValues.totalRecordCount = iResultCnt;        
	                
	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
	            }
	        
	            TimingInfo millisBeginRemt0100ToRemt2300DataList = SmrmfUtils.startTiming(logger);
	        
	            /**페이지 카운트 처리를 위한 부분 */ 
	            Remt2300SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	            //Apply paging
	            if (pagingValues.start > 0) {
	            	Remt2300SrhVo.setFirstIndex(pagingValues.start);
	            }
	            if (pagingValues.offsetLimit > 0) {
	            	Remt2300SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
	            }

	            //Execute query and convert to BaseModel list
	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	            @SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list  
	            List list = remt2300DAO.selectRemt0100ToRemt2300List(Remt2300SrhVo);
	            
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
	            
	            SmrmfUtils.endTiming(logger, millisBeginRemt0100ToRemt2300DataList, "getSelectRemt0100ToRemt2300List");
	       

	        }
	        catch (Exception ex) {
	            ex.printStackTrace();
	            //Return operation exception
	            throw MSFServerUtils.getOperationException(method, ex, logger);
	        }

	        return retval;
	    } 
	   
	   @Override
		 public PagingLoadResult<ShowMessageBM> activityOnInsertRemt0100(List<BaseModel> mapModels,Remt2000DTO remt2000Dto) throws MSFException {

		        PagingLoadResult<ShowMessageBM> retval = null;
		   
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		    	// 1. 암호화 객체 생성
//		    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		        
		        try {  
		            
		        
//                if  (MSFSharedUtils.paramNull(remt2000DAO)) {
//		       	        
//		   	        	WebApplicationContext wac = WebApplicationContextUtils.
//		   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//		   	        	remt2000DAO = (Remt2000DAO) wac.getBean("Remt2000DAO" ); 
//		   	    }
		        	
                //대상자선택에 따른 기본산정내역을 산출하는 메서드를 호출한다. 
				 
				 Iterator<BaseModel> iterRecords = (Iterator<BaseModel>)mapModels.iterator();
				  ArrayList<InfcPkgRemt2000VO>  lstInfcRemt2000Vo = new ArrayList<InfcPkgRemt2000VO>();
				 
                  while (iterRecords.hasNext()) {
                          BaseModel bmMapModel = (BaseModel) iterRecords.next(); 
                  
						  InfcPkgRemt2000VO  infcRemt2000Vo = new InfcPkgRemt2000VO();
						  
						  infcRemt2000Vo.setDpobCd(MSFSharedUtils.allowNulls(bmMapModel.get("dpobCd")));    /** column 사업장코드 : dpobCd */
						  infcRemt2000Vo.setSystemkey(MSFSharedUtils.allowNulls(bmMapModel.get("systemkey")));    /** column SYSTEMKEY : systemkey */
						  infcRemt2000Vo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(remt2000Dto.getCalcSevePayPsnDivCd()));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						  infcRemt2000Vo.setClutYrMnth(MSFSharedUtils.allowNulls(remt2000Dto.getClutYrMnth()));    /** column 정산년월 : clutYrMnth */
						   
						  lstInfcRemt2000Vo.add(infcRemt2000Vo);
						 // remt2000DAO.insertRemt2000(remt2000Vo); 
					 
	               } 
                  
             	 
                  RemtListenerAdapter remtAdapter = new RemtListenerAdapter(); 
                  retval = remtAdapter.setRemt0100ToRetirementCalc(RemoteServiceUtil.getThreadLocalRequest(),lstInfcRemt2000Vo);
                   
		        }
		        catch (Exception ex) {
		        	 
		            logger.error("EXCEPTION calling activityOnInsertRemt0100(): "+ex); 
		             
		            throw MSFServerUtils.getOperationException("activityOnInsertRemt0100", ex, logger);
		        }
		        finally {
		          
		        }
		        
		        return retval;
		} 
	    
	   @Override
	   public Remt2000DTO activityOnReadRemt0100(Remt2000DTO remt2000Dto) throws MSFException {

		   		Remt2000DTO rtnRemt2000Dto = new Remt2000DTO(); 
		   
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		    	// 1. 암호화 객체 생성
		    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		        
		        if  (MSFSharedUtils.paramNull(remt2000DAO)) {
			        
		            WebApplicationContext wac = WebApplicationContextUtils.
		                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

		            remt2000DAO = (Remt2000DAO) wac.getBean("Remt2000DAO" ); 
		        }
		        
		        try {   
 
						  Remt2000VO  remt2000Vo = new Remt2000VO();
						  Remt2000VO  rtnRemt2000Vo = new Remt2000VO();
						  
						  remt2000Vo.setDpobCd(MSFSharedUtils.allowNulls(remt2000Dto.getDpobCd()));    /** column 사업장코드 : dpobCd */
						  remt2000Vo.setSystemkey(MSFSharedUtils.allowNulls(remt2000Dto.getSystemkey()));    /** column SYSTEMKEY : systemkey */
						  remt2000Vo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(remt2000Dto.getCalcSevePayPsnDivCd()));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						  remt2000Vo.setClutYrMnth(MSFSharedUtils.allowNulls(remt2000Dto.getClutYrMnth()));    /** column 정산년월 : clutYrMnth */
						   
					  
						  
						  rtnRemt2000Vo  = remt2000DAO.selectRemt2000(remt2000Vo);
						  
						  if (MSFSharedUtils.paramNotNull(rtnRemt2000Vo)) {
							  

							rtnRemt2000Dto.setDpobCd(rtnRemt2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
							rtnRemt2000Dto.setSystemkey(rtnRemt2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
							rtnRemt2000Dto.setCalcSevePayPsnDivCd(rtnRemt2000Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
							rtnRemt2000Dto.setClutYrMnth(rtnRemt2000Vo.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
							rtnRemt2000Dto.setClutYr(rtnRemt2000Vo.getClutYrMnth().substring(0,4));    /** column 정산년월 : clutYrMnth */
							rtnRemt2000Dto.setClutMnth(rtnRemt2000Vo.getClutYrMnth().substring(4,6));    /** column 정산년월 : clutYrMnth */
							rtnRemt2000Dto.setEmymtDivCd(rtnRemt2000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
							rtnRemt2000Dto.setEmymtDivNm(rtnRemt2000Vo.getEmymtDivNm());    /** column 고용구분 : emymtDivNm */
							rtnRemt2000Dto.setDeptCd(rtnRemt2000Vo.getDeptCd());    /** column 부서코드 : deptCd */
							rtnRemt2000Dto.setDeptNm(rtnRemt2000Vo.getDeptNm());    /** column 부서 : deptNm */
							rtnRemt2000Dto.setTypOccuCd(rtnRemt2000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
							rtnRemt2000Dto.setTypOccuNm(rtnRemt2000Vo.getTypOccuNm());    /** column 직종 : typOccuNm */
							//rtnRemt2000Dto.setPyspGrdeCd(rtnRemt2000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
							//rtnRemt2000Dto.setPyspGrdeNm(rtnRemt2000Vo.getPyspGrdeNm());    /** column 호봉등급 : pyspGrdeNm */
							rtnRemt2000Dto.setDtilOccuInttnCd(rtnRemt2000Vo.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
							rtnRemt2000Dto.setDtilOccuClsDivNm(rtnRemt2000Vo.getDtilOccuClsDivNm());    /** column 직종세구분 : dtilOccuClsDivNm */
							rtnRemt2000Dto.setBusinCd(rtnRemt2000Vo.getBusinCd());    /** column 사업코드 : businCd */
							rtnRemt2000Dto.setBusinNm(rtnRemt2000Vo.getBusinNm());    /** column 사업 : businNm */
							
							rtnRemt2000Dto.setInbyCd(rtnRemt2000Vo.getInbyCd());    /** column 직위코드 : inbyCd */
							rtnRemt2000Dto.setPyspCd(rtnRemt2000Vo.getPyspCd());    /** column 호봉코드 : pyspCd */
							rtnRemt2000Dto.setLogSvcYrNumCd(rtnRemt2000Vo.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
							rtnRemt2000Dto.setLogSvcMnthIcmCd(rtnRemt2000Vo.getLogSvcMnthIcmCd());    /** column 근속월수코드 : logSvcMnthIcmCd */
							rtnRemt2000Dto.setNm(rtnRemt2000Vo.getNm());    /** column 성명 : nm */
//							rtnRemt2000Dto.setResnRegnNum(rtnRemt2000Vo.getResnRegnNum());    /** column 주민등록번호 : ResnRegnNum */
							// 복호화
							rtnRemt2000Dto.setResnRegnNum( AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(rtnRemt2000Vo.getResnRegnNum().toString()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC));
							
							
							
							
							rtnRemt2000Dto.setIcncDt(rtnRemt2000Vo.getIcncDt());    /** column 입사일자 : icncDt */
							rtnRemt2000Dto.setRkfcdDt(rtnRemt2000Vo.getRkfcdDt());    /** column 기산일자 : rkfcdDt */
							rtnRemt2000Dto.setRetryDt(rtnRemt2000Vo.getRetryDt());    /** column 퇴직일자 : retryDt */
							rtnRemt2000Dto.setLogSvcYrNum(rtnRemt2000Vo.getLogSvcYrNum().longValue());    /** column 근속년수 : logSvcYrNum */
							rtnRemt2000Dto.setLogSvcMnthIcm(rtnRemt2000Vo.getLogSvcMnthIcm().longValue());    /** column 근속월수 : logSvcMnthIcm */
							rtnRemt2000Dto.setAmcrrLogSvcYrNum(rtnRemt2000Vo.getAmcrrLogSvcYrNum().longValue());    /** column 군경력근속년수 : amcrrLogSvcYrNum */
							rtnRemt2000Dto.setAmcrrLogSvcMnthIcm(rtnRemt2000Vo.getAmcrrLogSvcMnthIcm().longValue());    /** column 군경력근속월수 : amcrrLogSvcMnthIcm */
							rtnRemt2000Dto.setEepnMnthIcm2012Bfr(rtnRemt2000Vo.getEepnMnthIcm2012Bfr().longValue());    /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
							rtnRemt2000Dto.setEepnMnthIcm2013Aft(rtnRemt2000Vo.getEepnMnthIcm2013Aft().longValue());    /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
							rtnRemt2000Dto.setAddMnthIcm2012Bfr(rtnRemt2000Vo.getAddMnthIcm2012Bfr().longValue());    /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
							rtnRemt2000Dto.setAddMnthIcm2013Aft(rtnRemt2000Vo.getAddMnthIcm2013Aft().longValue());    /** column 가산월수_2013이후 : addMnthIcm2013Aft */
							rtnRemt2000Dto.setEepnDayIcmDys(rtnRemt2000Vo.getEepnDayIcmDys().longValue());    /** column 제외일수 : eepnDayIcmDys */
							rtnRemt2000Dto.setLogSvcNumDys(rtnRemt2000Vo.getLogSvcNumDys().longValue());    /** column 근속일수 : logSvcNumDys */
							rtnRemt2000Dto.setTurtyDutyYrNum(rtnRemt2000Vo.getTurtyDutyYrNum().longValue());    /** column 실근무년수 : turtyDutyYrNum */
							rtnRemt2000Dto.setTurtyDutyMnthNum(rtnRemt2000Vo.getTurtyDutyMnthNum().longValue());    /** column 실근무개월수 : turtyDutyMnthNum */
							rtnRemt2000Dto.setTurtyDutyNumDys(rtnRemt2000Vo.getTurtyDutyNumDys().longValue());    /** column 실근무일수 : turtyDutyNumDys */
							rtnRemt2000Dto.setAmcrrLogSvcNumDys(rtnRemt2000Vo.getAmcrrLogSvcNumDys().longValue());    /** column 군경력근무일수 : amcrrLogSvcNumDys */
							rtnRemt2000Dto.setPayCmpttnBgnnDt(rtnRemt2000Vo.getPayCmpttnBgnnDt());    /** column 급여산정시작일자 : payCmpttnBgnnDt */
							rtnRemt2000Dto.setPayCmpttnEndDt(rtnRemt2000Vo.getPayCmpttnEndDt());    /** column 급여산정종료일자 : payCmpttnEndDt */
							rtnRemt2000Dto.setFndtnPayAggrSumSum(rtnRemt2000Vo.getFndtnPayAggrSumSum().longValue());    /** column 기본급여합계금액 : fndtnPayAggrSumSum */
							rtnRemt2000Dto.setSnryAllwAggrSum(rtnRemt2000Vo.getSnryAllwAggrSum().longValue());    /** column 제수당합계금액 : snryAllwAggrSum */
							rtnRemt2000Dto.setWelfWelfSpdgAggrSum(rtnRemt2000Vo.getWelfWelfSpdgAggrSum().longValue());    /** column 후생복지비합계금액 : welfWelfSpdgAggrSum */
							rtnRemt2000Dto.setMarPubcWelfAmnt(rtnRemt2000Vo.getMarPubcWelfAmnt().longValue());    /** column 3월간후생복지비 : marPubcWelfAmnt */
							rtnRemt2000Dto.setMarTotAmntWag(rtnRemt2000Vo.getMarTotAmntWag().longValue());    /** column 3월간총임금액 : marTotAmntWag */
							rtnRemt2000Dto.setDayAvgAmntWag(rtnRemt2000Vo.getDayAvgAmntWag().longValue());    /** column 1일평균임금액 : dayAvgAmntWag */
							rtnRemt2000Dto.setSevePayCmpttnSum(rtnRemt2000Vo.getSevePayCmpttnSum().longValue());    /** column 퇴직금산정금액 : sevePayCmpttnSum */
							rtnRemt2000Dto.setSevePayAddSum(rtnRemt2000Vo.getSevePayAddSum().longValue());    /** column 퇴직금가산금액 : sevePayAddSum */
							rtnRemt2000Dto.setSevePayAddRate(rtnRemt2000Vo.getSevePayAddRate().doubleValue());    /** column 퇴직금가산율 : sevePayAddRate */
							rtnRemt2000Dto.setSevePayAddApptnSum(rtnRemt2000Vo.getSevePayAddApptnSum().longValue());    /** column 퇴직금가산적용금액 : sevePayAddApptnSum */
							rtnRemt2000Dto.setAmcrrClutInsnYn(MSFSharedUtils.convertStringToBoolean(rtnRemt2000Vo.getAmcrrClutInsnYn()));    /** column 군경력정산포함여부 : amcrrClutInsnYn */
							rtnRemt2000Dto.setAmcrrAddApptnSum(rtnRemt2000Vo.getAmcrrAddApptnSum().longValue());    /** column 군경력가산적용금액 : amcrrAddApptnSum */
							rtnRemt2000Dto.setTotLogSvcNumDys(rtnRemt2000Vo.getTotLogSvcNumDys().longValue());    /** column 총근무일수 : totLogSvcNumDys */
							rtnRemt2000Dto.setSevePayPymtSum(rtnRemt2000Vo.getSevePayPymtSum().longValue());    /** column 퇴직금지급액 : sevePayPymtSum */
							rtnRemt2000Dto.setSevePayCmpttnFreeDtySum(rtnRemt2000Vo.getSevePayCmpttnFreeDtySum().longValue());    /** column 퇴직금산정비과세금액 : sevePayCmpttnFreeDtySum */
							rtnRemt2000Dto.setSevePayCmpttnTxtnSum(rtnRemt2000Vo.getSevePayCmpttnTxtnSum().longValue());    /** column 퇴직금산정과세금액 : sevePayCmpttnTxtnSum */
							rtnRemt2000Dto.setSevePayPymtDducSum(rtnRemt2000Vo.getSevePayPymtDducSum().longValue());    /** column 퇴직금지급공제금액 : sevePayPymtDducSum */
							rtnRemt2000Dto.setSevePayTurtyPymtSum(rtnRemt2000Vo.getSevePayTurtyPymtSum().longValue());    /** column 퇴직금실지급금액 : sevePayTurtyPymtSum */
							rtnRemt2000Dto.setSevePayNoteCtnt(rtnRemt2000Vo.getSevePayNoteCtnt());    /** column 퇴직금비고내용 : sevePayNoteCtnt */
							rtnRemt2000Dto.setSevePayPymtDt(rtnRemt2000Vo.getSevePayPymtDt());    /** column 퇴직금지급일자 : sevePayPymtDt */
							rtnRemt2000Dto.setSevePayPymtYn(MSFSharedUtils.convertStringToBoolean(rtnRemt2000Vo.getSevePayPymtYn()));    /** column 퇴직금지급여부 : sevePayPymtYn */
							rtnRemt2000Dto.setDdlneYn(MSFSharedUtils.convertStringToBoolean(rtnRemt2000Vo.getDdlneYn()));    /** column 마감여부 : ddlneYn */
							rtnRemt2000Dto.setDdlneDt(rtnRemt2000Vo.getDdlneDt());    /** column 마감일시 : ddlneDt */
						 

						  }	else {
							  
						  }	  
		        }
		        catch (Exception ex) {
		        	 
		            logger.error("EXCEPTION calling activityOnReadRemt0100(): "+ex);  
		            throw MSFServerUtils.getOperationException("activityOnReadRemt0100", ex, logger);
		            
		        }
		        
		        finally {
		          
		        }
		        
		        return rtnRemt2000Dto;
		}
	 
	   
	   @Override
	   public List<RemtDays0100DTO> activityOnPayrRemt0100Header(Remt2100DTO remt2100Dto) throws MSFException {

		        //List<BaseModel> rtnBm = new ArrayList<BaseModel>(); 
		   
		         List<RemtDays0100DTO> rtnBm = new ArrayList<RemtDays0100DTO>(); 
		         
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		        if  (MSFSharedUtils.paramNull(remt2100DAO)) {
			        
		            WebApplicationContext wac = WebApplicationContextUtils.
		                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

		            remt2100DAO = (Remt2100DAO) wac.getBean("Remt2100DAO" ); 
		        }
		        
		        try {    
		        	
//		        	ColumnAttribute[] tableAttributes = new ColumnAttribute[] {
//		                      new ColumnAttribute("dpobCd", "dpobCd", ColumnDef.TYPE_STRING )
//		                     ,new ColumnAttribute("calcSevePayPsnDivCd", "calcSevePayPsnDivCd", ColumnDef.TYPE_STRING)
//		                     ,new ColumnAttribute("clutYrMnth", "clutYrMnth", ColumnDef.TYPE_STRING)
//		                      ,new ColumnAttribute("systemkey", "systemkey", ColumnDef.TYPE_STRING)
//		                      ,new ColumnAttribute("itemTm01Stdt", "itemTm01Stdt", ColumnDef.TYPE_STRING)
//		                      ,new ColumnAttribute("itemTm01Eddt", "itemTm01Eddt", ColumnDef.TYPE_STRING)
//		                      ,new ColumnAttribute("itemAmnt01", "itemAmnt01", ColumnDef.TYPE_STRING) 
//		                      ,new ColumnAttribute("itemTm02Stdt", "itemTm02Stdt", ColumnDef.TYPE_STRING)
//		                      ,new ColumnAttribute("itemTm02Eddt", "itemTm02Eddt", ColumnDef.TYPE_STRING)
//		                      ,new ColumnAttribute("itemAmnt02", "itemAmnt02", ColumnDef.TYPE_STRING) 
//		                      ,new ColumnAttribute("itemTm03Stdt", "itemTm03Stdt", ColumnDef.TYPE_STRING)
//		                      ,new ColumnAttribute("itemTm03Eddt", "itemTm03Eddt", ColumnDef.TYPE_STRING)
//		                      ,new ColumnAttribute("itemAmnt03", "itemAmnt03", ColumnDef.TYPE_STRING) 
//		                      ,new ColumnAttribute("itemTm04Stdt", "itemTm04Stdt", ColumnDef.TYPE_STRING)
//		                      ,new ColumnAttribute("itemTm04Eddt", "itemTm04Eddt", ColumnDef.TYPE_STRING)
//		                      ,new ColumnAttribute("itemAmnt04", "itemAmnt04", ColumnDef.TYPE_STRING) 
//		                      ,new ColumnAttribute("totPymtNumDys", "totPymtNumDys", ColumnDef.TYPE_STRING)};
		        	
 
						  Remt2100SrhVO  remt2100SrhVo = new Remt2100SrhVO();
						 
						  
						  remt2100SrhVo.setDpobCd(MSFSharedUtils.allowNulls(remt2100Dto.getDpobCd()));    /** column 사업장코드 : dpobCd */
						  remt2100SrhVo.setSystemkey(MSFSharedUtils.allowNulls(remt2100Dto.getSystemkey()));    /** column SYSTEMKEY : systemkey */
						  remt2100SrhVo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(remt2100Dto.getCalcSevePayPsnDivCd()));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						  remt2100SrhVo.setClutYrMnth(MSFSharedUtils.allowNulls(remt2100Dto.getClutYrMnth()));    /** column 정산년월 : clutYrMnth */
						    
						  List lstRemtPayr0100Vo  = remt2100DAO.selectRemt0100ToRemt2100List(remt2100SrhVo);
						  
						  if (lstRemtPayr0100Vo.size() > 0) {
							  
							    Iterator<Map<String, Object>> iter = lstRemtPayr0100Vo.iterator(); 
					        
					            while ( iter.hasNext() ) {
					            	
					            	RemtDays0100DTO remtDays0100Dto = new RemtDays0100DTO();
					                Map<String, Object> map = (Map<String, Object>) iter.next();
					                 
					               
					                remtDays0100Dto.setItemStDt01(MSFSharedUtils.allowNulls(map.get("itemStDt01")));  /** set 급여기간시작일자01 : itemStDt01 */  
					                remtDays0100Dto.setItemEdDt01(MSFSharedUtils.allowNulls(map.get("itemEdDt01")));/** set 급여기간종료일자01 : itemEdDt01 */ 
					                remtDays0100Dto.setItemStDt02(MSFSharedUtils.allowNulls(map.get("itemStDt02"))); /** set 급여기간시작일자02 : itemStDt02 */  
					                remtDays0100Dto.setItemStDt02(MSFSharedUtils.allowNulls(map.get("itemStDt02")));/** set 급여기간종료일자02 : itemEdDt02 */  
					                remtDays0100Dto.setItemStDt03(MSFSharedUtils.allowNulls(map.get("itemStDt03"))); /** set 급여기간시작일자03 : itemStDt03 */   
					                remtDays0100Dto.setItemStDt03(MSFSharedUtils.allowNulls(map.get("itemStDt03")));/** set 급여기간종료일자03 : itemEdDt03 */   
					                remtDays0100Dto.setItemStDt04(MSFSharedUtils.allowNulls(map.get("itemStDt04")));/** set 급여기간시작일자04 : itemStDt04 */  
					                remtDays0100Dto.setItemStDt04(MSFSharedUtils.allowNulls(map.get("itemStDt04")));/** set 급여기간종료일자04 : itemEdDt04 */  
					                remtDays0100Dto.setItemDays01(Long.parseLong(MSFSharedUtils.defaultNulls(map.get("itemDays01"),"0")));/** set 급여기간일수 : itemDays01 */  
					                remtDays0100Dto.setItemDays02(Long.parseLong(MSFSharedUtils.defaultNulls(map.get("itemDays02"),"0")));/** set 급여기간일수 : itemDays02 */  
					                remtDays0100Dto.setItemDays03(Long.parseLong(MSFSharedUtils.defaultNulls(map.get("itemDays03"),"0")));/** set 급여기간일수 : itemDays03 */  
					                remtDays0100Dto.setItemDays04(Long.parseLong(MSFSharedUtils.defaultNulls(map.get("itemDays04"),"0")));/** set 급여기간일수 : itemDays04 */  
					                remtDays0100Dto.setItemTotDays(Long.parseLong(MSFSharedUtils.defaultNulls(map.get("itemTotDays"),"0")));/** set 급여기간총일수 :  itemTotDays */  
					                
					                rtnBm.add(remtDays0100Dto);   
					                
					              //  String idValue = map.get("systemkey").toString();
					               // BaseModel bm = new BaseModel();
					                
//					                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
//					                    
//					                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
//					                    Object mapCon = map.get(tableAttributes[i].getName());  
//					                     
//					                    switch ( tableAttributes[i].getType() ) {  
//					                    case ColumnDef.TYPE_DATE: 
//					                    case ColumnDef.TYPE_DATETIME: 
//					                       
//					                     Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"yyyyMMdd");
//					                     map.put(tableAttributes[i].getName(), value);
//					                     
//					                       break; 
//					                       
//					                     case ColumnDef.TYPE_LONG:   
//					                     
//					                    if (mapCon != null) {  
//					                        Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
//					                        map.put(tableAttributes[i].getName(), lValue); 
//					                    }  
//					                       
//					                     break;
//					                     
//					                     case ColumnDef.TYPE_DOUBLE:  
//					                     
//					                      if (mapCon != null) {      
//					                         Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue(); 
//					                         map.put(tableAttributes[i].getName(), dbValue); 
//					                      }  
//					                       
//					                         break;
//					                    }
//					                     /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
//					                    Object baseModelValue = null;
//					                    //콤보박스처리를 위해 추가함
//					                    if (tableAttributes[i].getName().contains("$")) {
//					                         String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
//					                              
//					                         map.put(tableAttributes[i].getName(),map.get(strMapCon));
//					                         
//					                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//					                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//					                    } else {
//					                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//					                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//					                    }
//					                 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/ 
//					                    
//					                    
//					                    bm.set(tableAttributes[i].getName(), baseModelValue);
//					                }
					                //bm.setProperties(map);
//					                for ( int i=0 ; i<columnAttributes.length ; i++ ) {
//					                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//					                            map.get(columnAttributes[i].getName()), columnAttributes[i].getType());
//					                    bm.set(columnAttributes[i].getName(), baseModelValue);
//					                }

					                //bm.set(TableDef.ID_PROPERTY_NAME, idValue);
					               // rtnBm.add(bm);
					                
					            }

						  }	 
		        }
		        catch (Exception ex) {
		        	 
		            logger.error("EXCEPTION calling activityOnReadRemt0100(): "+ex);  
		            throw MSFServerUtils.getOperationException("activityOnReadRemt0100", ex, logger);
		            
		        }
		        
		        finally {
		          
		        }
		        
		        return rtnBm;
		}
	   
	   @Override
	   public Remt3100DTO activityOnReadRemt0100ToRemt3100(Remt3100DTO remt3100Dto)  throws MSFException {

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
						  
						  remt3100Vo.setDpobCd(MSFSharedUtils.allowNulls(remt3100Dto.getDpobCd()));    /** column 사업장코드 : dpobCd */
						  remt3100Vo.setSystemkey(MSFSharedUtils.allowNulls(remt3100Dto.getSystemkey()));    /** column SYSTEMKEY : systemkey */
						  remt3100Vo.setCalcSevePayPsnDivCd(MSFSharedUtils.allowNulls(remt3100Dto.getCalcSevePayPsnDivCd()));    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						  remt3100Vo.setClutYrMnth(MSFSharedUtils.allowNulls(remt3100Dto.getClutYrMnth()));    /** column 정산년월 : clutYrMnth */
						   
					  
						  
						  rtnRemt3100Vo  = remt3100DAO.selectRemt3100(remt3100Vo);
						  
						  if (MSFSharedUtils.paramNotNull(rtnRemt3100Vo)) { 

							rtnRemt3100Dto.setDpobCd(rtnRemt3100Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
							
							rtnRemt3100Dto.setCalcSevePayPsnDivCd(rtnRemt3100Vo.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
							rtnRemt3100Dto.setSystemkey(rtnRemt3100Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
							rtnRemt3100Dto.setClutYrMnth(MSFSharedUtils.allowNulls(rtnRemt3100Vo.getClutYrMnth()));    /** column 정산년월 : clutYrMnth */
							rtnRemt3100Dto.setCalcSevePsnBlggYrMnth(rtnRemt3100Vo.getCalcSevePsnBlggYrMnth());    /** column 퇴직정산귀속년월 : calcSevePsnBlggYrMnth */
							rtnRemt3100Dto.setDeptCd(rtnRemt3100Vo.getDeptCd());    /** column 부서코드 : deptCd */
							rtnRemt3100Dto.setHanNm(rtnRemt3100Vo.getHanNm());    /** column 한글성명 : hanNm */
//							rtnRemt3100Dto.setResnRegnNum(rtnRemt3100Vo.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
							// 복호화
							rtnRemt3100Dto.setResnRegnNum(AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(rtnRemt3100Vo.getResnRegnNum()).replace("-", ""),AnyCryptUtils.SEC_RRNUMC));
							
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
		        	 
		            logger.error("EXCEPTION calling activityOnReadRemt0100ToRemt3100(): "+ex);  
		            throw MSFServerUtils.getOperationException("activityOnReadRemt0100ToRemt3100", ex, logger);
		            
		        }
		        
		        finally {
		          
		        }
		        
		        return rtnRemt3100Dto;
		}
	   
	   
	   
	   
	   @Override
		 public PagingLoadResult<ShowMessageBM> activityOnUpdateRemt0100Save( Remt2000DTO remt2000Dto )  throws MSFException {

		   PagingLoadResult<ShowMessageBM> retval = null;
		   
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		        try {  
		            
		        
//              if  (MSFSharedUtils.paramNull(remt2000DAO)) {
//		       	        
//		   	        	WebApplicationContext wac = WebApplicationContextUtils.
//		   	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//		   	        	remt2000DAO = (Remt2000DAO) wac.getBean("Remt2000DAO" ); 
//		   	    }
		        	
             
		        	InfcPkgRemt2000VO  infcRemt2000Vo = new InfcPkgRemt2000VO();
						  
						  infcRemt2000Vo.setDpobCd(remt2000Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
						  infcRemt2000Vo.setSystemkey(remt2000Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
						  infcRemt2000Vo.setCalcSevePayPsnDivCd(remt2000Dto.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						  infcRemt2000Vo.setClutYrMnth(remt2000Dto.getClutYrMnth());    /** column 정산년월 : clutYrMnth */
//							infcRemt2000Vo.setEmymtDivCd(remt2000Dto.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
//							infcRemt2000Vo.setDeptCd(remt2000Dto.getDeptCd());    /** column 부서코드 : deptCd */
//							infcRemt2000Vo.setTypOccuCd(remt2000Dto.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//							infcRemt2000Vo.setPyspGrdeCd(remt2000Dto.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//							infcRemt2000Vo.setDtilOccuInttnCd(remt2000Dto.getDtilOccuInttnCd());    /** column 직종세구분코드 : dtilOccuInttnCd */
//							infcRemt2000Vo.setBusinCd(remt2000Dto.getBusinCd());    /** column 사업코드 : businCd */
//							infcRemt2000Vo.setInbyCd(remt2000Dto.getInbyCd());    /** column 직위코드 : inbyCd */
//							infcRemt2000Vo.setPyspCd(remt2000Dto.getPyspCd());    /** column 호봉코드 : pyspCd */
//							infcRemt2000Vo.setLogSvcYrNumCd(remt2000Dto.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
//							infcRemt2000Vo.setLogSvcMnthIcmCd(remt2000Dto.getLogSvcMnthIcmCd());    /** column 근속월수코드 : logSvcMnthIcmCd */
//							infcRemt2000Vo.setNm(remt2000Dto.getNm());    /** column 성명 : nm */
//							infcRemt2000Vo.setIcncDt(remt2000Dto.getIcncDt());    /** column 입사일자 : icncDt */
						  infcRemt2000Vo.setRkfcdDt(remt2000Dto.getRkfcdDt());    /** column 기산일자 : rkfcdDt */
						  infcRemt2000Vo.setRetryDt(remt2000Dto.getRetryDt());    /** column 퇴직일자 : retryDt */
							//infcRemt2000Vo.setLogSvcYrNum(remt2000Dto.getLogSvcYrNum());    /** column 근속년수 : logSvcYrNum */
							//infcRemt2000Vo.setLogSvcMnthIcm(remt2000Dto.getLogSvcMnthIcm());    /** column 근속월수 : logSvcMnthIcm */
							//infcRemt2000Vo.setAmcrrLogSvcYrNum(remt2000Dto.getAmcrrLogSvcYrNum());    /** column 군경력근속년수 : amcrrLogSvcYrNum */
							//infcRemt2000Vo.setAmcrrLogSvcMnthIcm(remt2000Dto.getAmcrrLogSvcMnthIcm());    /** column 군경력근속월수 : amcrrLogSvcMnthIcm */
						  infcRemt2000Vo.setEepnMnthIcm2012Bfr(new BigDecimal(remt2000Dto.getEepnMnthIcm2012Bfr()));    /** column 제외월수_2012이전 : eepnMnthIcm2012Bfr */
						  infcRemt2000Vo.setEepnMnthIcm2013Aft(new BigDecimal(remt2000Dto.getEepnMnthIcm2013Aft()));    /** column 제외월수_2013이후 : eepnMnthIcm2013Aft */
						  infcRemt2000Vo.setAddMnthIcm2012Bfr(new BigDecimal(remt2000Dto.getAddMnthIcm2012Bfr()));    /** column 가산월수_2012이전 : addMnthIcm2012Bfr */
						  infcRemt2000Vo.setAddMnthIcm2013Aft(new BigDecimal(remt2000Dto.getAddMnthIcm2013Aft()));    /** column 가산월수_2013이후 : addMnthIcm2013Aft */
						  infcRemt2000Vo.setEepnDayIcmDys(new BigDecimal(remt2000Dto.getEepnDayIcmDys()));    /** column 제외일수 : eepnDayIcmDys */
							
						  infcRemt2000Vo.setSevePayAddRate(new BigDecimal(remt2000Dto.getSevePayAddRate()));    /** column 퇴직금가산율 : sevePayAddRate */
						  infcRemt2000Vo.setAmcrrClutInsnYn(Boolean.TRUE.equals(remt2000Dto.getAmcrrClutInsnYn()) ? "Y" : "N");    /** column 군경력정산포함여부 : amcrrClutInsnYn */
							 
						  infcRemt2000Vo.setSevePayNoteCtnt(remt2000Dto.getSevePayNoteCtnt());    /** column 퇴직금비고내용 : sevePayNoteCtnt */
						  infcRemt2000Vo.setSevePayPymtDt(remt2000Dto.getSevePayPymtDt());    /** column 퇴직금지급일자 : sevePayPymtDt */
						  
                          RemtListenerAdapter remtAdapter = new RemtListenerAdapter(); 
                          retval = remtAdapter.setRemt0100ToRemtCalc2000(RemoteServiceUtil.getThreadLocalRequest(),infcRemt2000Vo);
                 
		        }
		        catch (Exception ex) {
		        	 
		            logger.error("EXCEPTION calling activityOnUpdateRemt0100Save(): "+ex); 
		             
		            throw MSFServerUtils.getOperationException("activityOnUpdateRemt0100Save", ex, logger);
		        }
		        finally {
		          
		        }
		      
		        return retval;
		} 
	   
	   @Override
		 public Long activityOnDeleteRemt0100Save( Remt2000DTO remt2000Dto )  throws MSFException {

		        Long retval = 0L;
		   
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		        try {   
               
						    Remt2000VO  remt2000Vo = new Remt2000VO();  
						    Remt2100VO  remt2100Vo = new Remt2100VO(); 
						    Remt2200VO  remt2200Vo = new Remt2200VO(); 
						    Remt2300VO  remt2300Vo = new Remt2300VO(); 
						    Remt3000VO  remt3000Vo = new Remt3000VO();
						    Remt3100VO  remt3100Vo = new Remt3100VO(); 
						    Remt3200VO  remt3200Vo = new Remt3200VO(); 
						    
							remt2000Vo.setDpobCd(remt2000Dto.getDpobCd());    							/** column 사업장코드 : dpobCd */
							remt2000Vo.setSystemkey(remt2000Dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */
							remt2000Vo.setCalcSevePayPsnDivCd(remt2000Dto.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
							remt2000Vo.setClutYrMnth(remt2000Dto.getClutYrMnth());    					/** column 정산년월 : clutYrMnth */
   
							remt3000Vo.setDpobCd(remt2000Dto.getDpobCd());    							/** column 사업장코드 : dpobCd */
							remt3000Vo.setSystemkey(remt2000Dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */
							remt3000Vo.setCalcSevePayPsnDivCd(remt2000Dto.getCalcSevePayPsnDivCd());    /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
							remt3000Vo.setClutYrMnth(remt2000Dto.getClutYrMnth());    					/** column 정산년월 : clutYrMnth */
   
							BeanUtils.copyProperties(remt2100Vo, remt2000Vo);
							BeanUtils.copyProperties(remt2200Vo, remt2000Vo);
							BeanUtils.copyProperties(remt2300Vo, remt2000Vo);
							BeanUtils.copyProperties(remt3100Vo, remt3000Vo);
							BeanUtils.copyProperties(remt3200Vo, remt3000Vo);
							
							remt3200DAO.deleteRemt0100ToRemt3200(remt3200Vo);
		   					remt3100DAO.deleteRemt3100(remt3100Vo); 
		   					remt3000DAO.deleteRemt3000(remt3000Vo);
		   					 
   					        remt2300DAO.deleteRemt2300(remt2300Vo);
   					        remt2200DAO.deleteRemt2200(remt2200Vo);
   					        remt2100DAO.deleteRemt2100(remt2100Vo);
   					        remt2000DAO.deleteRemt2000(remt2000Vo); 
							 
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
		 public PagingLoadResult<ShowMessageBM> activityOnPayrCalc( List<Remt2000DTO> listRemt2000Dto ) throws MSFException {

		        PagingLoadResult<ShowMessageBM> retval = null;
		   
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		        try {  
		            
		        	 
					  List<InfcPkgRemt2000VO>  lstInfcRemt2000Vo = new ArrayList<InfcPkgRemt2000VO>();
					 
	                  for (int iCnt = 0;iCnt < listRemt2000Dto.size();iCnt++) { 
	                  
							  InfcPkgRemt2000VO  infcRemt2000Vo = new InfcPkgRemt2000VO();
							  Remt2000DTO  remt2000Dto = new Remt2000DTO(); 
							  
							  remt2000Dto = (Remt2000DTO) listRemt2000Dto.get(iCnt); 
							  
							  infcRemt2000Vo.setDpobCd(remt2000Dto.getDpobCd());    						/** column 사업장코드 : dpobCd */
							  infcRemt2000Vo.setSystemkey(remt2000Dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */
							  infcRemt2000Vo.setCalcSevePayPsnDivCd(remt2000Dto.getCalcSevePayPsnDivCd());	/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
							  infcRemt2000Vo.setClutYrMnth(remt2000Dto.getClutYrMnth());    				/** column 정산년월 : clutYrMnth */
							  
							  lstInfcRemt2000Vo.add(infcRemt2000Vo);
							 // remt2000DAO.insertRemt2000(remt2000Vo); 
						 
		               } 
	                   
		         
                        RemtListenerAdapter remtAdapter = new RemtListenerAdapter(); 
                        retval = remtAdapter.setActivityOnPayrCalc(RemoteServiceUtil.getThreadLocalRequest(),lstInfcRemt2000Vo);
               
		        }
		        catch (Exception ex) {
		        	 
		            logger.error("EXCEPTION calling activityOnUpdateRemt0100Save(): "+ex); 
		             
		            throw MSFServerUtils.getOperationException("activityOnUpdateRemt0100Save", ex, logger);
		        }
		        finally {
		          
		        }
		      
		        return retval;
		} 
	   
	   @Override
	  public Long activityOnUpdateRemt0100ToPayrCalc( List<Remt2200DTO> listInfcRemt2200dto)  throws MSFException {

	        Long retval = 0L;
	   
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        try {  
	            
	        	 
				  List<InfcPkgRemt2200VO>  lstInfcRemt2200Vo = new ArrayList<InfcPkgRemt2200VO>();
				 
                  for (int iCnt = 0;iCnt < listInfcRemt2200dto.size();iCnt++) { 
                  
						  InfcPkgRemt2200VO  infcRemt2200Vo = new InfcPkgRemt2200VO();
						  Remt2200DTO  remt2200Dto = new Remt2200DTO(); 
						  
						  remt2200Dto = (Remt2200DTO) listInfcRemt2200dto.get(iCnt); 
						  

							infcRemt2200Vo.setDpobCd(remt2200Dto.getDpobCd());    									/** column 사업장코드 : dpobCd */
							infcRemt2200Vo.setSystemkey(remt2200Dto.getSystemkey());    							/** column SYSTEMKEY : systemkey */
							infcRemt2200Vo.setClutYrMnth(remt2200Dto.getClutYrMnth());    							/** column 정산년월 : clutYrMnth */
							infcRemt2200Vo.setCalcSevePayPsnDivCd(remt2200Dto.getCalcSevePayPsnDivCd());    		/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
							infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(remt2200Dto.getSevePayDtlPatrNum()));/** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
							infcRemt2200Vo.setPayItemCd(remt2200Dto.getPayItemCd());    							/** column 급여항목코드 : payItemCd */
							infcRemt2200Vo.setExtpyGrpCd(remt2200Dto.getExtpyGrpCd());    							/** column 수당그룹코드 : extpyGrpCd */
							infcRemt2200Vo.setSevePayCmpttnTm(remt2200Dto.getSevePayCmpttnTm());   			 		/** column 퇴직금산정시간 : sevePayCmpttnTm */
							infcRemt2200Vo.setPymtSum(new BigDecimal(remt2200Dto.getPymtSum()));    				/** column 지급금액 : pymtSum */
						 
 
						  lstInfcRemt2200Vo.add(infcRemt2200Vo); 
					 
	               } 
                   
	         
                    RemtListenerAdapter remtAdapter = new RemtListenerAdapter(); 
                    retval = remtAdapter.setActivityOnUpdateRemt0100ToPayrCalc(RemoteServiceUtil.getThreadLocalRequest(),lstInfcRemt2200Vo);
           
	        }
	        catch (Exception ex) {
	        	 
	            logger.error("EXCEPTION calling activityOnUpdateRemt0100ToPayrCalc(): "+ex); 
	            retval = 0L;
	            throw MSFServerUtils.getOperationException("activityOnUpdateRemt0100ToPayrCalc", ex, logger);
	        }
	        finally {
	          
	        }
	        
	        return retval;
	} 
	   
	   
	   @Override
	  public Long activityOnUpdateRemt0100ToPayrWfepCalc( List<Remt2200DTO> listInfcRemt2200dto)  throws MSFException {

	        Long retval = 0L;
	   
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        try {  
	            
	        	 
				  List<InfcPkgRemt2200VO>  lstInfcRemt2200Vo = new ArrayList<InfcPkgRemt2200VO>();
				 
                  for (int iCnt = 0;iCnt < listInfcRemt2200dto.size();iCnt++) { 
                  
						  InfcPkgRemt2200VO  infcRemt2200Vo = new InfcPkgRemt2200VO();
						  Remt2200DTO  remt2200Dto = new Remt2200DTO(); 
						  
						  remt2200Dto = (Remt2200DTO) listInfcRemt2200dto.get(iCnt); 
						  

							infcRemt2200Vo.setDpobCd(remt2200Dto.getDpobCd());    									/** column 사업장코드 : dpobCd */
							infcRemt2200Vo.setSystemkey(remt2200Dto.getSystemkey());    							/** column SYSTEMKEY : systemkey */
							infcRemt2200Vo.setClutYrMnth(remt2200Dto.getClutYrMnth());    							/** column 정산년월 : clutYrMnth */
							infcRemt2200Vo.setCalcSevePayPsnDivCd(remt2200Dto.getCalcSevePayPsnDivCd());    		/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
							infcRemt2200Vo.setSevePayDtlPatrNum(new BigDecimal(remt2200Dto.getSevePayDtlPatrNum()));/** column 퇴직금산정상세일련번호 : sevePayDtlPatrNum */
							infcRemt2200Vo.setPayItemCd(remt2200Dto.getPayItemCd());    							/** column 급여항목코드 : payItemCd */
							infcRemt2200Vo.setExtpyGrpCd(remt2200Dto.getExtpyGrpCd());    							/** column 수당그룹코드 : extpyGrpCd */
							infcRemt2200Vo.setSevePayCmpttnTm(remt2200Dto.getSevePayCmpttnTm());    				/** column 퇴직금산정시간 : sevePayCmpttnTm */
							infcRemt2200Vo.setPymtSum(new BigDecimal(remt2200Dto.getPymtSum()));    				/** column 지급금액 : pymtSum */
						 
						  
						  lstInfcRemt2200Vo.add(infcRemt2200Vo); 
					 
	               } 
                   
	         
                    RemtListenerAdapter remtAdapter = new RemtListenerAdapter(); 
                    retval = remtAdapter.setActivityOnUpdateRemt0100ToPayrWfepCalc(RemoteServiceUtil.getThreadLocalRequest(),lstInfcRemt2200Vo);
           
	        }
	        catch (Exception ex) {
	        	 
	            logger.error("EXCEPTION calling activityOnUpdateRemt0100ToPayrWfepCalc(): "+ex); 
	            retval = 0L;
	            throw MSFServerUtils.getOperationException("activityOnUpdateRemt0100ToPayrWfepCalc", ex, logger);
	        }
	        finally {
	          
	        }
	        
	        return retval;
	} 
	
	   

	    @Override
	    public Long activityOnSaveRemt2300DDucData(List<Remt2300DTO> listRemt2300dto, ActionDatabase actionDatabase) throws MSFException  {
	        Long result = new Long(0);
	        Long iCnt = new Long(0);
	        
	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	        
	        try { 
	             
	           
	            if  (MSFSharedUtils.paramNull(remt2300DAO)) {
	                
	                WebApplicationContext wac = WebApplicationContextUtils.
	                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

	                remt2300DAO = (Remt2300DAO) wac.getBean("Remt2300DAO" ); 
	            }
	            
	            for(int iPayrCnt=0;iPayrCnt < listRemt2300dto.size();iPayrCnt++) {
	            	 
	                
	                	Remt2300DTO remt2300Dto = new Remt2300DTO();  
	                	Remt2300VO  remt2300Vo = new Remt2300VO();  
	                	remt2300Dto = listRemt2300dto.get(iPayrCnt); 
	  
						
						remt2300Vo.setDpobCd(remt2300Dto.getDpobCd());    									/** column 사업장코드 : dpobCd */
						remt2300Vo.setCalcSevePayPsnDivCd(remt2300Dto.getCalcSevePayPsnDivCd());    		/** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
						remt2300Vo.setClutYrMnth(remt2300Dto.getClutYrMnth());    							/** column 정산년월 : clutYrMnth */
						remt2300Vo.setSystemkey(remt2300Dto.getSystemkey());    							/** column SYSTEMKEY : systemkey */
						remt2300Vo.setPayItemCd(remt2300Dto.getPayItemCd());    							/** column 급여항목코드 : payItemCd */
						remt2300Vo.setPymtDducDivCd(remt2300Dto.getPymtDducDivCd());    					/** column 지급공제구분코드 : pymtDducDivCd */
						remt2300Vo.setPymtSum(new BigDecimal(remt2300Dto.getPymtSum()));    				/** column 지급금액 : pymtSum */
						remt2300Vo.setKybdr(sessionUser.getUsrId());    									/** column 입력자 : kybdr */
						remt2300Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  /** column 입력주소 : inptAddr */
						remt2300Vo.setIsmt(sessionUser.getUsrId());    										/** column 수정자 : ismt */
						remt2300Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());  /** column 수정주소 : revnAddr */
						 
	                    
	                   switch (actionDatabase) { 
	                   case INSERT:
	                	   remt2300DAO.insertRemt2300(remt2300Vo); 
	                       
	                      break;
	                   case UPDATE: 
	                	   remt2300DAO.updateRemt2300(remt2300Vo); 
	                       
	                       break;
	                   case DELETE: 
	                	   remt2300DAO.deleteItemToRemt2300(remt2300Vo); 
	                        
	                       break;
	                   }
	                     
	                   iCnt = iCnt + 1;  
	 
	               } 
	            
	                result = iCnt;
	                
	                if (iCnt > 0) {
	                	
	                	InfcPkgRemt2300VO infcRemt2300Vo = new InfcPkgRemt2300VO(); 
	                	
	                	Remt2300DTO tpRemt2300Dto = new Remt2300DTO();   
	                	tpRemt2300Dto = listRemt2300dto.get(0); 
	                	
	                	infcRemt2300Vo.setDpobCd(tpRemt2300Dto.getDpobCd());    						/** column 사업장코드 : dpobCd */
	                	infcRemt2300Vo.setCalcSevePayPsnDivCd(tpRemt2300Dto.getCalcSevePayPsnDivCd());  /** column 퇴직정산구분코드 : calcSevePayPsnDivCd */
	                	infcRemt2300Vo.setClutYrMnth(tpRemt2300Dto.getClutYrMnth());   		 			/** column 정산년월 : clutYrMnth */
	                	infcRemt2300Vo.setSystemkey(tpRemt2300Dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */
	                	infcRemt2300Vo.setPayItemCd(tpRemt2300Dto.getPayItemCd());    					/** column 급여항목코드 : payItemCd */
	                	infcRemt2300Vo.setPymtDducDivCd(tpRemt2300Dto.getPymtDducDivCd());    			/** column 지급공제구분코드 : pymtDducDivCd */
	                	infcRemt2300Vo.setPymtSum(new BigDecimal(tpRemt2300Dto.getPymtSum()));    		/** column 지급금액 : pymtSum */
				 
	   				 
		            	//퇴직금 산정 테이블 업데이트를 위한 함수 호출 시작  소득세 및 주민세 업데이트 기존 공제가 있으면 같이 업데이트 
		                infcRemt2300DAO.updateRemt3100ToRemt2300Data(infcRemt2300Vo);
	                }
	        }
	        catch (Exception ex) {
	            
	            result = new Long(0);
	            throw MSFServerUtils.getOperationException("activityOnPayr4200", ex, logger);
	        }
	        finally {
	          
	        }
	        
	        return result;
	    }  
	   
	  
	    
}
