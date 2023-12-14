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
package com.app.exterms.diligence.server.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
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

import com.app.exterms.diligence.client.dto.Dlgn0250DTO;
import com.app.exterms.diligence.client.service.Dlgn0250Service;
import com.app.exterms.diligence.server.service.dao.Dlgn0100DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0110DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0200DAO;
import com.app.exterms.diligence.server.service.dao.Dlgn0210DAO;
import com.app.exterms.diligence.server.vo.Dlgn0100VO;
import com.app.exterms.diligence.server.vo.Dlgn0110VO;
import com.app.exterms.diligence.server.vo.Dlgn0200VO;
import com.app.exterms.diligence.server.vo.Dlgn0210VO;
import com.app.exterms.diligence.server.vo.Dlgn0250SrhVO;
import com.app.exterms.diligence.server.vo.Dlgn0250VO;
import com.app.exterms.diligence.shared.DiligenceDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFErrorMessage;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.AnyDateTime;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.props.ExtermsProps;
import com.ext.constants.PropPayGenConfs;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
 
@Service("Dlgn0250Service")
public class Dlgn0250ServiceImpl  extends AbstractCustomServiceImpl  implements Dlgn0250Service,DiligenceDaoConstants {

    private static final Logger logger = LoggerFactory.getLogger(Dlgn0250ServiceImpl.class);
    private static final String calledClass = Dlgn0250ServiceImpl.class.getName();

    
    @Autowired 
    @Resource(name="dlgn0100DAO")
    private Dlgn0100DAO dlgn0100DAO;
    
    @Autowired 
    @Resource(name="dlgn0200DAO")
    private Dlgn0200DAO dlgn0200DAO;
    
    @Autowired 
    @Resource(name="dlgn0110DAO")
    private Dlgn0110DAO dlgn0110DAO;
    
    @Autowired 
    @Resource(name="dlgn0210DAO")
    private Dlgn0210DAO dlgn0210DAO;

    public PagingLoadResult<BaseModel> getDlgn0250DataList(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_DLGN0250_DATA_LIST;
        Dlgn0250SrhVO   dlgn0250SrhVO = new Dlgn0250SrhVO();
        Dlgn0250VO      dlgn0250VO = new Dlgn0250VO();
        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
        MSFSysm0100BM sessionUser;
        
    	// 1. 암호화 객체 생성
    	String nResult;
		try {
			nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
					
			        
			        
			        if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			              sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			        } else {
			            sessionUser = getUser();
			        }
			        
			        if  (MSFSharedUtils.paramNull(dlgn0100DAO)) {
			        
			            WebApplicationContext wac = WebApplicationContextUtils.
			                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			
			            dlgn0100DAO = (Dlgn0100DAO) wac.getBean("dlgn0100DAO" ); 
			        }
			        
			        try {
			            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
			           // Sysm0100BM          user             = serviceParameters.getUser();
			            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
			            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
			            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
			            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
			            Boolean blnExecuteCount            = serviceParameters.isNoPageData();
			            //Get paging configuration
			            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
			
			            //Get query parameters
			           // String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
			            List<String> listDeptCd = new ArrayList<String>();
			            /** 조건절 */
			            dlgn0250SrhVO.setDpobCd(sessionUser.getDpobCd()); 
			            dlgn0250SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부  
			            dlgn0250SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드  
			            
			            
			            dlgn0250SrhVO.setUsrId(sessionUser.getUsrId());  
			            dlgn0250SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가
			            dlgn0250SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));
			            /******************************** 권한 ************************************************************************/
			            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
			            if ("FALSE".equals(chkDeptCd)) {
			            	dlgn0250SrhVO.setDeptCd(sessionUser.getDeptCd()); 
			               listDeptCd.add(sessionUser.getDeptCd());
			               dlgn0250SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
			               dlgn0250SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
			            } else {
			            	    
			            	     dlgn0250SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));    
			                     if (dlgn0250SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
			                     	 listDeptCd = null; 
			                     	dlgn0250SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
			                     	dlgn0250SrhVO.setDeptCd("");  //부서코드
			                     } else {
			                    	 dlgn0250SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
			                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
			                          dlgn0250SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
			                     } 
			                  
			            }
			            
			//            String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
			//            if ("FALSE".equals(chkTypOccuCd)) {
			//            	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
			//            	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
			//            } else {
			//            	
			//            }             
			           
			            
			           /******************************** 권한 ************************************************************************/
			           
			            
			            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
			            dlgn0250SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
			            dlgn0250SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
			           
			            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
			            dlgn0250SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
			            dlgn0250SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
			             
			            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
			            dlgn0250SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
			            dlgn0250SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
			             
			            dlgn0250SrhVO.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
			           
			           
			            dlgn0250SrhVO.setPayCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payCd")));  //급여구분코드 
			            dlgn0250SrhVO.setPymtYrMnth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pymtYrMnth"))); //지급년
			            dlgn0250SrhVO.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
			            dlgn0250SrhVO.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
			             
			
			//            /**
			//          	         * TODO 김해 시청 호봉제만 불러 오는 로직 추가  함. 임시로 김해시만 적용 
			//          	         */
			//                      if (dlgn0250SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(dlgn0250SrhVO.getDeptCdAuth())) 
			//                  			|| MSFSharedUtils.allowNulls(dlgn0250SrhVO.getDeptCdAuth()).contains(dlgn0250SrhVO.getPayrMangDeptCd())
			//                  			) {
			//
			//                    	  dlgn0250SrhVO.setRepbtyBusinDivCd(DlgnServerUtils.getRepbtyBusinData(RemoteServiceUtil.getThreadLocalConfig() , RemoteServiceUtil.getThreadLocalRequest()));
			//                   	 
			//                  	}  
			                //Get total record count //전체 데이터 갯수를 가지고 온다. 
			                 if ( pagingValues.executeRecordCount ) { 
			                        
			                    //Execute query that returns a single value
			                    TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
			                     
			                    int iResultCnt = dlgn0100DAO.selectDlgn0250ListTotCnt(dlgn0250SrhVO);  
			                  
			                    SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
			                    //페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
			                    if (!pagingValues.pageExecute) { 
			                        pagingValues.offsetLimit = iResultCnt;       
			                    }
			                    
			                    pagingValues.totalRecordCount = iResultCnt;        
			                    
			                    logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			                }
			            
			                TimingInfo millisBeginDlgn0250DataList = SmrmfUtils.startTiming(logger);
			            
			                /**페이지 카운트 처리를 위한 부분 */ 
			                dlgn0250SrhVO.setPageSize(pagingValues.totalRecordCount);  
			                
			          
			                //Apply paging
			                if (pagingValues.start > 0) {
			                    dlgn0250SrhVO.setFirstIndex(pagingValues.start);
			                }
			                if (pagingValues.offsetLimit > 0) {
			                    dlgn0250SrhVO.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));  
			                }
			//            if (!blnExecuteCount) {    
			//                dlgn0250SrhVO.setLastIndex(-1); 
			//            }
			            //Execute query and convert to BaseModel list
			            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
			            
			            @SuppressWarnings("unchecked")
			//            Collection<Map<String, Object>> list ??????
			            List list = dlgn0100DAO.selectDlgn0250List(dlgn0250SrhVO);
			            
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
			                    
			                  //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
			                            map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
			                 
			                    bm.set(tableAttributes[i].getName(), baseModelValue);
			                }
			
			                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
			                bmResult.add(bm);
			            } 
			
			            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
			            
			            SmrmfUtils.endTiming(logger, millisBeginDlgn0250DataList, "getDlgn0250DataList");
			       
			
			        }
			        catch (Exception ex) {
			            ex.printStackTrace();
			            //Return operation exception
			            throw MSFServerUtils.getOperationException(method, ex, logger);
			        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return retval;
    }
    
    @Override
    public String xlsExportData(ServiceParameters params)  throws MSFException {
         
//        String method =  "xlsExportData";
//        Dlgn0250SrhVO   dlgn0250SrhVo = new Dlgn0250SrhVO();
//        Dlgn0250VO      dlgn0250Vo = new Dlgn0250VO();
//       
//        
//        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//        
//        if  (MSFSharedUtils.paramNull(dlgn0100Dao)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            dlgn0100Dao = (Dlgn0100DAO) wac.getBean("Dlgn0100DAO" ); 
//        }
//        
//        try {
//            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
//           // Sysm0400BM          user             = serviceParameters.getUser();
//            ColumnAttribute[] tableAttributes  = params.getTableAttributes();
//            IColumnFilter     columnFilters    = params.getColumnFilters();
//            List<ColumnOrder> columnOrders     = params.getColumnOrders();
//           
//            /** 조건절 */
////            sysComSearchVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
////            sysComSearchVo.setMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "mangeDeptCd"))) ;   //단위기관코드
////            sysComSearchVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
////            sysComSearchVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
////            sysComSearchVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
////            sysComSearchVo.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
////            sysComSearchVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
////            sysComSearchVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
////            sysComSearchVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
////            sysComSearchVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
//            
//            
//            @SuppressWarnings("unchecked")
////            Collection<Map<String, Object>> list ??????
//            List list = dlgn0100Dao.selectDlgn0250ToDlgn0250List(dlgn0250SrhVo);
//            
//            Iterator<Map<String, Object>> iter = list.iterator();
//            
//        
//            while ( iter.hasNext() ) {
//                Map<String, Object> map = (Map<String, Object>) iter.next();
//              
////                //bm.setProperties(map);
////                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
////                    
////                 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
////                    Object baseModelValue = null;
////                    //콤보박스처리를 위해 추가함
////                    if (tableAttributes[i].getName().contains("$")) {
////                         String mapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
////                              
////                         map.put(tableAttributes[i].getName(),map.get(mapCon));
////                         
////                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
////                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
////                    } else {
////                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
////                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
////                    }
////                 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/  
//// 
////                    
////                    bm.set(tableAttributes[i].getName(), baseModelValue);
////                } 
//                //넘겨 받은 값을 처리 하기 위해  서비스 호출 
//                
//            
//            } 
// 
//
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//            //Return operation exception
//            throw MSFServerUtils.getOperationException(method, ex, logger);
//        }
        
        return null;
    
    }


    @Override
    public PagingLoadResult<ShowMessageBM>  activityOnDlgn0250(List<Dlgn0250DTO> listDlgn0250dto, ActionDatabase actionDatabase)  throws MSFException {
    	
    	Long result = new Long(0);
        Long iCnt = new Long(0);
        PagingLoadResult<ShowMessageBM> retval = null;
        List<ShowMessageBM>  bmResult = new ArrayList<ShowMessageBM>();
        
		String method = calledClass + ".activityOnDlgn0250";
		
		String windowNm = "근무실적관리";
		String windowId = "DLGN0250";
		
		// 1. 암호화 객체 생성
		try {
						String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
					
			        
			        MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			        
			        try {  
			            
			            if  (MSFSharedUtils.paramNull(dlgn0100DAO)) {
			                
			                WebApplicationContext wac = WebApplicationContextUtils.
			                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			
			                dlgn0100DAO = (Dlgn0100DAO) wac.getBean("dlgn0100DAO" ); 
			            }
			            
			            if  (MSFSharedUtils.paramNull(dlgn0200DAO)) {
			                
			                WebApplicationContext wac = WebApplicationContextUtils.
			                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			
			                dlgn0200DAO = (Dlgn0200DAO) wac.getBean("dlgn0200DAO" ); 
			            }
			            
			           if  (MSFSharedUtils.paramNull(dlgn0110DAO)) {
			                
			                WebApplicationContext wac = WebApplicationContextUtils.
			                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			
			                dlgn0110DAO = (Dlgn0110DAO) wac.getBean("dlgn0110DAO" ); 
			            }
			            
			            if  (MSFSharedUtils.paramNull(dlgn0210DAO)) {
			                
			                WebApplicationContext wac = WebApplicationContextUtils.
			                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			
			                dlgn0210DAO = (Dlgn0210DAO) wac.getBean("dlgn0210DAO" ); 
			            }
			          
			            for(int iPayrCnt=0;iPayrCnt < listDlgn0250dto.size();iPayrCnt++) {
			                
			                    Dlgn0250DTO dlgn0250Dto = new Dlgn0250DTO();  
			                    dlgn0250Dto = listDlgn0250dto.get(iPayrCnt);
			                 
			                    Dlgn0100VO dlgn0100Vo = new Dlgn0100VO();  
			                    Dlgn0200VO dlgn0200Vo = new Dlgn0200VO(); 
			                   
			                    Dlgn0110VO dlgn0110Vo = new Dlgn0110VO();  
			                    Dlgn0210VO dlgn0210Vo = new Dlgn0210VO(); 
			                    
			
			                    dlgn0100Vo.setDpobCd(dlgn0250Dto.getDpobCd());    																	/** column 사업장코드 : dpobCd */
			                    dlgn0100Vo.setSystemkey(dlgn0250Dto.getSystemkey());    															/** column SYSTEMKEY : systemkey */
			                    dlgn0100Vo.setDilnlazYrMnth(dlgn0250Dto.getDilnlazYrMnth().replace(".", ""));    									/** column 근태년월 : dilnlazYrMnth */
			                    dlgn0100Vo.setPayCd(dlgn0250Dto.getPayCd());    																	/** column 급여구분코드 : payCd */
			                    dlgn0100Vo.setEmymtDivCd(dlgn0250Dto.getEmymtDivCd());    															/** column 고용구분코드 : emymtDivCd */
			                    dlgn0100Vo.setDeptCd(dlgn0250Dto.getDeptCd());    																	/** column 부서코드 : deptCd */
			                    dlgn0100Vo.setBusinCd(dlgn0250Dto.getBusinCd());    																/** column 사업코드 : businCd */
			                    dlgn0100Vo.setTypOccuCd(dlgn0250Dto.getTypOccuCd());    															/** column 직종코드 : typOccuCd */
			                    dlgn0100Vo.setDtilOccuInttnCd(dlgn0250Dto.getDtilOccuInttnCd());    												/** column 직종세구분코드 : dtilOccuInttnCd */
			                    dlgn0100Vo.setDilnlazDutyBgnnDt(dlgn0250Dto.getDilnlazDutyBgnnDt());    											/** column 근태_근무시작일자 : dilnlazDutyBgnnDt */
			                    dlgn0100Vo.setDilnlazDutyEndDt(dlgn0250Dto.getDilnlazDutyEndDt());    												/** column 근태_근무종료일자 : dilnlazDutyEndDt */
			                    dlgn0100Vo.setDilnlazDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazDutyNumDys(),"0"));    			/** column 근태_근무일수 : dilnlazDutyNumDys */
			                    dlgn0100Vo.setDilnlazLvsgNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazLvsgNumDys(),"0"));    			/** column 근태_연가일수 : dilnlazLvsgNumDys */
			                    dlgn0100Vo.setDilnlazAbnceNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazAbnceNumDys(),"0"));    			/** column 근태_결근일수 : dilnlazAbnceNumDys */
			                    dlgn0100Vo.setDilnlazSckleaNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazSckleaNumDys(),"0"));    		/** column 근태_병가일수 : dilnlazSckleaNumDys */
			                    dlgn0100Vo.setDilnlazOffvaNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazOffvaNumDys(),"0"));    			/** column 근태_공가일수 : dilnlazOffvaNumDys */
			                    dlgn0100Vo.setDilnlazFmlyEvntNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazFmlyEvntNumDys(),"0"));    	/** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
			                    dlgn0100Vo.setDilnlazHlthCreNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazHlthCreNumDys(),"0"));    		/** column 근태_보건일수 : dilnlazHlthCreNumDys */
			                    dlgn0100Vo.setDilnlazTotDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazTotDutyNumDys(),"0"));    		/** column 근태_총근무일수 : dilnlazTotDutyNumDys */
			                    dlgn0100Vo.setDilnlazWklyHldyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazWklyHldyNumDys(),"0"));    	/** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
			                    dlgn0100Vo.setDilnlazPaidPubcHodyNum(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazPaidPubcHodyNum(),"0"));    	/** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
			                    dlgn0100Vo.setDilnlazDdlnePrcsYn((Boolean.TRUE.equals(dlgn0250Dto.getDilnlazDdlnePrcsYn()) ? "Y" : "N") );    		/** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
			                    dlgn0100Vo.setDilnlazNoteCtnt(dlgn0250Dto.getDilnlazNoteCtnt());    												/** column 근태_비고내용 : dilnlazNoteCtnt */ 
			                    dlgn0100Vo.setDilnlazSpclHodyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazSpclHodyNumDys(),"0"));    	/** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
			                    dlgn0100Vo.setDilnlazSatDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazSatDutyNumDys(),"0"));    		/** column 총토요근무일수 : dilnlazSatDutyNumDys */
			//                    dlgn0100Vo.setDilnlazPubcHodyDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazPubcHodyDutyNumDys(),"0"));    /** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
			                    dlgn0100Vo.setDilnlazHodyDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazHodyDutyNumDys(),"0"));    	/** column 휴일일수 : dilnlazHodyDutyNumDys */
			                    dlgn0100Vo.setDilnlazAbnceDutyRcgtnDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazAbnceDutyRcgtnDys(),"0"));	/** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
			                    dlgn0100Vo.setPyspGrdeCd(dlgn0250Dto.getPyspGrdeCd());    															/** column 호봉등급코드 : pyspGrdeCd */
			                    dlgn0100Vo.setDilnlazTotDutyTm(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazTotDutyTm(),"0"));    				/** column 근태_총근무시간 : dilnlazTotDutyTm */
			                    dlgn0100Vo.setDilnlazPaidHodyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazPaidHodyNumDys(),"0"));    	/** column 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
			                    dlgn0100Vo.setDilnlazTfcAssCstNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazTfcAssCstNumDys(),"0"));    	/** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */ 
			                    dlgn0100Vo.setDilnlazLnchDys(MSFSharedUtils.allowNulls(dlgn0250Dto.getDilnlazLnchDys()));    						/** column 근태_급식비일수 : dilnlazLnchDys */
			                    dlgn0100Vo.setDilnlazButpDys(MSFSharedUtils.allowNulls(dlgn0250Dto.getDilnlazButpDys()));    						/** column 근태_출장일수 : dilnlazButpDys */
			                    dlgn0100Vo.setDilnlazWkdDutyNumDys(MSFSharedUtils.allowNulls(dlgn0250Dto.getDilnlazWkdDutyNumDys()));    			/** column 평일근무일수 : dilnlazWkdDutyNumDys */
			                    
			                    dlgn0100Vo.setKybdr(sessionUser.getUsrId());    																	/** column 입력자 : kybdr */ 
			                    dlgn0100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    								/** column 입력주소 : inptAddr */
			                    dlgn0100Vo.setIsmt(sessionUser.getUsrId());    																		/** column 수정자 : ismt */ 
			                    dlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    								/** column 수정주소 : revnAddr */
			  
			                    dlgn0100Vo.setTypOccuBusinVal(MSFSharedUtils.allowNulls(dlgn0250Dto.getTypOccuBusinVal()));							/** column 복무통합구분값 : typOccuBusinVal */	
			                    
			//                    
			//                    BigDecimal dilnlazTotDutyTm =  BigDecimal.ZERO;
			//                    BigDecimal dilnlazTotDutyNumDys =  BigDecimal.ZERO;
			//                    // 고용 구분에 따라 총근무일수 다르게 산정
			//                    if(dlgn0100Vo.getEmymtDivCd() == "A0020010" || "A0020010".equals(dlgn0100Vo.getEmymtDivCd())) {
			//                    	// 무기계약직 : 총근무일수 = (평일일수 OR 근무시간) + 휴일일수 
			//                    	
			//                    	// 근무일수 수정시 총근무일수에 (시간 * 8) + 휴일일수 한 값을 넣어준다.  dlgn0100Vo.setDilnlazWkdDutyNumDys(dlgn0250VO.getDilnlazWkdDutyNumDys());    									/** column 평일근무일수 : dilnlazWkdDutyNumDys */
			//                    	if(dlgn0250Dto.getDilnlazTotDutyNumDys() == "" || "".equals(dlgn0250Dto.getDilnlazTotDutyNumDys())
			//                    			&& dlgn0250Dto.getDilnlazTotDutyTm () != "" || !"".equals(dlgn0250Dto.getDilnlazTotDutyTm()) ) {
			//                    		dilnlazTotDutyTm = (new BigDecimal(dlgn0100Vo.getDilnlazTotDutyTm()).divide(new BigDecimal(8), 4, BigDecimal.ROUND_HALF_UP)).add(new BigDecimal(dlgn0100Vo.getDilnlazHodyDutyNumDys()));
			//                    		dlgn0100Vo.setDilnlazTotDutyNumDys(String.valueOf(dilnlazTotDutyTm));				
			//                    	}else if() {
			//                    		
			//                    	}
			//                    	
			//                    	
			//                    }else {
			//                    	// 기간제근로자  : 총근무일수 = 평일일수
			//                    }
			//                    
			                    
			                    dlgn0110Vo.setDpobCd(dlgn0250Dto.getDpobCd());    																	/** column 사업장코드 : dpobCd */
			                    dlgn0110Vo.setSystemkey(dlgn0250Dto.getSystemkey());    															/** column SYSTEMKEY : systemkey */
			                    dlgn0110Vo.setDilnlazYrMnth(dlgn0250Dto.getDilnlazYrMnth().replace(".", ""));    									/** column 근태년월 : dilnlazYrMnth */
			                    dlgn0110Vo.setPayCd(dlgn0250Dto.getPayCd());    																	/** column 급여구분코드 : payCd */
			                    dlgn0110Vo.setDilnlazApptnDt("");
			                    dlgn0110Vo.setTypOccuBusinVal(MSFSharedUtils.allowNulls(dlgn0250Dto.getTypOccuBusinVal()));							/** column 복무통합구분값 : typOccuBusinVal */	
			                    
			                    dlgn0200Vo.setDpobCd(dlgn0250Dto.getDpobCd());    																	/** column 사업장코드 : dpobCd */
			                    dlgn0200Vo.setSystemkey(dlgn0250Dto.getSystemkey());    															/** column SYSTEMKEY : systemkey */
			                    dlgn0200Vo.setDilnlazExceDutyYrMnth(dlgn0250Dto.getDilnlazExceDutyYrMnth().replace(".", ""));						/** column 근태초과근무년월 : dilnlazExceDut8yYrMnth */
			                    dlgn0200Vo.setPayCd(dlgn0250Dto.getPayCd());    																	/** column 급여구분코드 : payCd */
			                    dlgn0200Vo.setEmymtDivCd(dlgn0250Dto.getEmymtDivCd());    															/** column 고용구분코드 : emymtDivCd */
			                    dlgn0200Vo.setDeptCd(dlgn0250Dto.getDeptCd());    																	/** column 부서코드 : deptCd */
			                    dlgn0200Vo.setBusinCd(dlgn0250Dto.getBusinCd());    																/** column 사업코드 : businCd */
			                    dlgn0200Vo.setTypOccuCd(dlgn0250Dto.getTypOccuCd());    															/** column 직종코드 : typOccuCd */
			                    dlgn0200Vo.setDtilOccuInttnCd(dlgn0250Dto.getDtilOccuInttnCd());    												/** column 직종세구분코드 : dtilOccuInttnCd */
			                    dlgn0200Vo.setDilnlazExceDutyBgnnDt(dlgn0250Dto.getDilnlazExceDutyBgnnDt());    									/** column 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
			                    dlgn0200Vo.setDilnlazExceDutyEndDt(dlgn0250Dto.getDilnlazExceDutyEndDt());    										/** column 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
			                    dlgn0200Vo.setDilnlazPubcHodyDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazPubcHodyDutyNumDys(),"0"));/** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
			                    dlgn0200Vo.setDilnlazPubcHodyDutyTm(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazPubcHodyDutyTm(),"0"));			/** column 근태_휴일총근무시간 : dilnlazPubcHodyDutyTm */
			                    //                    dlgn0200Vo.setDilnlazHodyDutyNumDys(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazHodyDutyNumDys(),"0"));    	/** column 휴일일수 : dilnlazHodyDutyNumDys */
			                    dlgn0200Vo.setDilnlazSatDutyNumDys(dlgn0250Dto.getDilnlazSatDutyNumDys());    /** column 근태_토요근무일수 : dilnlazSatDutyNumDys */
			                  //  dlgn0200Vo.setDilnlazTotNtotNumDys(dlgn0250Dto.getDilnlazTotNtotNumDys());    /** column 근태_총야근일수 : dilnlazTotNtotNumDys */
			                    dlgn0200Vo.setDilnlazTotNtotTm(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazTotNtotTm(),"0"));    				/** column 근태_총야근시간 : dilnlazTotNtotTm */
			                    
			                    dlgn0200Vo.setDilnlazFndtnTmRstDutyTm(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazFndtnTmRstDutyTm(),"0"));	/** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
			                    dlgn0200Vo.setDilnlazTmRstDutyTm(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazTmRstDutyTm(),"0"));				/** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
			                    
			//                    if (new BigDecimal(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazTmRstDutyTm(),"0")).compareTo(BigDecimal.ZERO) != 0) { 
			                    	dlgn0200Vo.setDilnlazTotTmRstDutyTm((new BigDecimal(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazFndtnTmRstDutyTm(),"0")).add(new BigDecimal(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazTmRstDutyTm(),"0")))).toString());    /** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
			//                    }	else {
			//                    	dlgn0200Vo.setDilnlazTotTmRstDutyTm(MSFSharedUtils.defaultNulls(dlgn0250Dto.getDilnlazTotTmRstDutyTm(),"0"));	/** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
			//                    } 
			                    
			                    dlgn0200Vo.setDilnlazDdlnePrcsYn((Boolean.TRUE.equals(dlgn0250Dto.getDilnlazDdlnePrcsYn()) ? "Y" : "N") );			/** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
			                    dlgn0200Vo.setDilnlazNoteCtnt(dlgn0250Dto.getDilnlazNoteCtnt());    												/** column 근태_비고내용 : dilnlazNoteCtnt */
			                    dlgn0200Vo.setPyspGrdeCd(dlgn0250Dto.getPyspGrdeCd());    															/** column 호봉등급코드 : pyspGrdeCd */
			                    dlgn0200Vo.setKybdr(sessionUser.getUsrId());    																	/** column 입력자 : kybdr */ 
			                    dlgn0200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    								/** column 입력주소 : inptAddr */
			                    dlgn0200Vo.setIsmt(sessionUser.getUsrId());    																		/** column 수정자 : ismt */ 
			                    dlgn0200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    								/** column 수정주소 : revnAddr */
			                    dlgn0200Vo.setTypOccuBusinVal(MSFSharedUtils.allowNulls(dlgn0250Dto.getTypOccuBusinVal()));							/** column 복무통합구분값 : typOccuBusinVal */	
			                    
			                    
			                    dlgn0210Vo.setDpobCd(dlgn0250Dto.getDpobCd());    																	/** column 사업장코드 : dpobCd */
			                    dlgn0210Vo.setSystemkey(dlgn0250Dto.getSystemkey());    															/** column SYSTEMKEY : systemkey */
			                    dlgn0210Vo.setDilnlazExceDutyYrMnth(dlgn0250Dto.getDilnlazExceDutyYrMnth().replace(".", ""));    					/** column 근태초과근무년월 : dilnlazExceDut8yYrMnth */
			                    dlgn0210Vo.setPayCd(dlgn0250Dto.getPayCd());    																	/** column 급여구분코드 : payCd */
			                    dlgn0210Vo.setDilnlazApptnDt("");
			//                        
			//                        payr0520Vo.setDpobCd(payr0520Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
			//                        payr0520Vo.setSystemkey(payr0520Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
			//                        payr0520Vo.setPayItemCd(payr0520Dto.getPayItemCd());    /** column 급여항목코드 : payItemCd */
			//                        payr0520Vo.setPymtDducItemSilNum(new BigDecimal(payr0520Dto.getPymtDducItemSilNum()));    /** column 개별지급공제항목일련번호 : pymtDducItemSilNum */
			//                        payr0520Vo.setPymtDducDivCd(payr0520Dto.getPymtDducDivCd());    /** column 지급공제구분코드 : pymtDducDivCd */
			//                        payr0520Vo.setPymtDducSum(new BigDecimal(payr0520Dto.getPymtDducSum()));    /** column 지급공제금액 : pymtDducSum */
			//                        payr0520Vo.setPymtDducRate(new BigDecimal(payr0520Dto.getPymtDducRate()));    /** column 지급공제율 : pymtDducRate */
			//                        payr0520Vo.setPymtDducFreeDtySum(new BigDecimal(payr0520Dto.getPymtDducFreeDtySum()));    /** column 지급공제비과세금액 : pymtDducFreeDtySum */
			//                        payr0520Vo.setPymtDducItemCretnDivCd(payr0520Dto.getPymtDducItemCretnDivCd());    /** column 지급공제항목생성구분코드 : pymtDducItemCretnDivCd */
			//                        payr0520Vo.setPymtDducItemBgnnDt(payr0520Dto.getPymtDducItemBgnnDt());    /** column 지급공제항목시작일자 : pymtDducItemBgnnDt */
			//                        payr0520Vo.setPymtDducItemEndDt(payr0520Dto.getPymtDducItemEndDt());    /** column 지급공제항목종료일자 : pymtDducItemEndDt */
			//                        payr0520Vo.setPymtDducItemDelYn((Boolean.TRUE.equals(payr0520Dto.getPymtDducItemDelYn()) ? "Y" : "N") );    /** column 지급공제항목삭제여부 : pymtDducItemDelYn */
			//                        payr0520Vo.setPymtDducItemNoteCtnt(payr0520Dto.getPymtDducItemNoteCtnt());    /** column 지급공제항목비고내용 : pymtDducItemNoteCtnt */
			//                        payr0520Vo.setKybdr(payr0520Dto.getKybdr());    /** column 입력자 : kybdr */
			//                        payr0520Vo.setInptDt(payr0520Dto.getInptDt());    /** column 입력일자 : inptDt */
			//                        payr0520Vo.setInptAddr(payr0520Dto.getInptAddr());    /** column 입력주소 : inptAddr */
			//                        payr0520Vo.setIsmt(payr0520Dto.getIsmt());    /** column 수정자 : ismt */
			//                        payr0520Vo.setRevnDt(payr0520Dto.getRevnDt());    /** column 수정일자 : revnDt */
			//                        payr0520Vo.setRevnAddr(payr0520Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
			                    dlgn0210Vo.setTypOccuBusinVal(MSFSharedUtils.allowNulls(dlgn0250Dto.getTypOccuBusinVal()));							/** column 복무통합구분값 : typOccuBusinVal */	
			                    Dlgn0200VO tpDlgn0200Vo = new Dlgn0200VO(); 
			                    
			                    tpDlgn0200Vo = dlgn0200DAO.selectDlgn0200(dlgn0200Vo); 
			                    
			                    if (MSFSharedUtils.paramNull(tpDlgn0200Vo) || MSFSharedUtils.paramNull(tpDlgn0200Vo.getSystemkey())) {
			                    	bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_ERROR,"DLGN","[근무실적]에러","근무실적","시간외근무 생성이 안되어 있는데이터가 존재!!! 확인요망." )); 
			                    }
			                      
			                   switch (actionDatabase) {
			                   case INSERT:
			                	   
			                	   dlgn0210DAO.deleteDlgn0210(dlgn0210Vo);  
			                	   dlgn0200DAO.deleteDlgn0200(dlgn0200Vo); 
			                	   dlgn0110DAO.deleteDlgn0110(dlgn0110Vo);  
			                       dlgn0100DAO.deleteDlgn0100(dlgn0100Vo);  
			                       
			                       dlgn0100DAO.insertDlgn0100(dlgn0100Vo); 
			                       dlgn0200DAO.insertDlgn0200(dlgn0200Vo); 
			                       break;
			                   case UPDATE: 
			                       dlgn0100DAO.updateDlgn0100(dlgn0100Vo); 
			                       dlgn0200DAO.updateDlgn0200(dlgn0200Vo); 
			                       break;
			                   case DELETE: 
			                	   dlgn0210DAO.deleteDlgn0210(dlgn0210Vo);  
			                	   dlgn0200DAO.deleteDlgn0200(dlgn0200Vo); 
			                	   dlgn0110DAO.deleteDlgn0110(dlgn0110Vo);  
			                       dlgn0100DAO.deleteDlgn0100(dlgn0100Vo);  
			                       break;
			                   } 
			                   
				    			/** 로그반영
				    			 * CRUDSBLO
				    			 * C:create		R:read		U:update
				    	    	 * D:delete		S:select	B:배치 
				    	    	 * L:로그인		O:로그아웃
				    	    	 */
			                   MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
			                   
			                   iCnt = iCnt + 1; 
			                    
			               } 
//			            bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"dogn","근무실적 업데이트" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(iCnt) + "명처리완료 "));   
			            bmResult.add(new ShowMessageBM(PropPayGenConfs.PAYGEN_INFO,"DLGN","근무실적 업데이트" ,"처리완료[리스트에서 이상여부확인]","대상자 : " + String.valueOf(iCnt) + "명처리완료 "));  
			          
			            retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size());  
			        } catch (Exception ex) {
			           // logger.error("EXCEPTION calling activityOnDlgn0250(): "+ex); 
			            
			           // result = new Long(0);
			           // throw MSFServerUtils.getOperationException("activityOnDlgn0250", ex, logger);
			        	 ex.printStackTrace();   
			      	   ShowMessageBM smBm = new ShowMessageBM();
			      	   smBm.setDivision(PropPayGenConfs.PAYGEN_ERROR);
			      	   smBm.setMenu("dlgn");
			      	   smBm.setPhase("[근무실적]에러");
			      	   smBm.setMessage(ex.getLocalizedMessage());
			      	   smBm.setContent(ex.getMessage());
			      	   bmResult.add(smBm);  
			      	   
			      	 /** 에러 로그 **/			
			      	 MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,actionDatabase.toString(),ex, windowNm , windowId);
			      	 
			      	   retval =  new BasePagingLoadResult<ShowMessageBM>(bmResult, 0, bmResult.size()); 
			        }
			        finally {
			          
			        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return retval;
    }

    @Override
    public Long createDlgn0250WorkPerfm(HashMap<String, String> param, ActionDatabase actionDatabase) throws MSFException {
    	
    	
        Long result = new Long(1);
        Long iCnt = new Long(0);
        String method = calledClass + ".createDlgn0250WorkPerfm";
        
		String windowNm = "근무실적관리";
		String windowId = "DLGN0250";
       
        
        Dlgn0250SrhVO   dlgn0250SrhVO = new Dlgn0250SrhVO(); 
        MSFSysm0100BM sessionUser;
        List<String> listDeptCd = new ArrayList<String>();
        
    	// 1. 암호화 객체 생성
    	try {
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
		     
		    	
		    	
		        if (RemoteServiceUtil.getThreadLocalRequest() != null) {
		              sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        } else {
		            sessionUser = getUser();
		        }
		        
		        try {  
		            
		            if  (MSFSharedUtils.paramNull(dlgn0100DAO)) {
		                
		                WebApplicationContext wac = WebApplicationContextUtils.
		                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
		
		                dlgn0100DAO = (Dlgn0100DAO) wac.getBean("dlgn0100DAO" ); 
		            }
		            
		            if  (MSFSharedUtils.paramNull(dlgn0200DAO)) {
		                
		                WebApplicationContext wac = WebApplicationContextUtils.
		                        getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
		
		                dlgn0200DAO = (Dlgn0200DAO) wac.getBean("dlgn0200DAO" ); 
		            }
		          
		             
		            /** 조건절 */
		            dlgn0250SrhVO.setDpobCd(sessionUser.getDpobCd()); 
		            dlgn0250SrhVO.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부   
		            dlgn0250SrhVO.setEmymtDivCd(MSFSharedUtils.allowNulls(param.get("emymtDivCd")));       //고용구분코드 
		            dlgn0250SrhVO.setUsrId(sessionUser.getUsrId());  
		              
		
		            dlgn0250SrhVO.setDeptCdAuth(MSFSharedUtils.allowNulls(param.get("deptCd")).replace(",", ""));  //권한처리를위해 추가  
		            dlgn0250SrhVO.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd")).replace(",", ""));   
		            /******************************** 권한 ************************************************************************/
		            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
		            
		            if ("FALSE".equals(chkDeptCd)) {
		            	dlgn0250SrhVO.setDeptCd(sessionUser.getDeptCd()); 
		               listDeptCd.add(sessionUser.getDeptCd());
		               dlgn0250SrhVO.setDeptCdArr(listDeptCd);     //부서코드    
		               dlgn0250SrhVO.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
		            } else {
		            	    
		            	     dlgn0250SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(param.get("payrMangDeptCd"))) ;   //단위기관코드
		            	     
		                     if (dlgn0250SrhVO.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(param.get("deptCd")))) { 
		                     	 listDeptCd = null; 
		                     	dlgn0250SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
		                     	dlgn0250SrhVO.setDeptCd("");  //부서코드
		                     } else {
		                    	  dlgn0250SrhVO.setDeptCd(MSFSharedUtils.allowNulls(param.get("deptCd")));     //부서코드
		                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("deptCd")));   
		                          dlgn0250SrhVO.setDeptCdArr(listDeptCd);     //부서코드   
		                     } 
		                  
		            }
		                
		                    
		            /******************************** 권한 ************************************************************************/ 
		            
		            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("typOccuCd"))); 
		            dlgn0250SrhVO.setTypOccuCdArr(lstTypeOccuCd); 
		            dlgn0250SrhVO.setTypOccuCd(MSFSharedUtils.allowNulls(param.get("typOccuCd")));  //직종
		           
		//            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); 
		//            dlgn0250SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
		//            dlgn0250SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(param.get("pyspGrdeCd"))); //호봉등급코드
		             
		            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); 
		            dlgn0250SrhVO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
		            dlgn0250SrhVO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(param.get("dtilOccuInttnCd"))); //직종세
		             
		            dlgn0250SrhVO.setBusinCd(MSFSharedUtils.allowNulls(param.get("businCd")));   //사업코드 
		           
		            dlgn0250SrhVO.setPayCd(MSFSharedUtils.allowNulls(param.get("payCd")));  //급여구분코드 
		            dlgn0250SrhVO.setDilnlazExceDutyYrMnth(MSFSharedUtils.allowNulls(param.get("jobYrMnth"))); //지급년
		            dlgn0250SrhVO.setJobYrMnth(MSFSharedUtils.allowNulls(param.get("jobYrMnth"))); //지급년
		            dlgn0250SrhVO.setSystemkey(MSFSharedUtils.allowNulls(param.get("systemkey")));  //시스템키
		
		
		         //   dlgn0250SrhVO.setDilnlazDutyBgnnDt(MSFSharedUtils.allowNulls(param.get("workDayS")));   //시작일자 
		         //  dlgn0250SrhVO.setDilnlazDutyEndDt(MSFSharedUtils.allowNulls(param.get("workDayE")));   //종료일자 
		            dlgn0250SrhVO.setRflctnBgnnDt(MSFSharedUtils.allowNulls(param.get("workDayS")));   //시작일자 
		            dlgn0250SrhVO.setRflctnEndDt(MSFSharedUtils.allowNulls(param.get("workDayE")));   //종료일자 
		             
		
		            Calendar  intiCal =   Calendar.getInstance(); 
		            intiCal.set ( Integer.parseInt(MSFSharedUtils.allowNulls(param.get("jobYrMnth")).substring(0,4)), Integer.parseInt(MSFSharedUtils.allowNulls(param.get("jobYrMnth")).substring(4,6)) - 1, 1 );
		            int maxDays = intiCal.getActualMaximum ( Calendar.DAY_OF_MONTH  ); //전체일수 
		            
		          //  System.out.println("dlgn0250SrhVO.getRflctnBgnnDt()" + dlgn0250SrhVO.getRflctnBgnnDt());
		         //   System.out.println("dlgn0250SrhVO.getRflctnBgnnDt()" + dlgn0250SrhVO.getRflctnEndDt());
		             
		            int wkDays = AnyDateTime.daysBetween(dlgn0250SrhVO.getRflctnBgnnDt(), dlgn0250SrhVO.getRflctnEndDt(),1);
		          //  long wkDays = diffOfDate(dlgn0250SrhVO.getRflctnBgnnDt(), dlgn0250SrhVO.getRflctnEndDt());
		          
		            
		            @SuppressWarnings("unchecked")
		//          Collection<Map<String, Object>> list ??????
		            List<Dlgn0250VO> listDlgn0250 =  dlgn0100DAO.selectXlsDlgn0250List(dlgn0250SrhVO);
		            
		            if (listDlgn0250.size() <= 0) {
		            	//값이 없는 경우 처리 
		            	result = new Long(0);
		            	List<MSFErrorMessage> emList = new ArrayList<MSFErrorMessage>();
		            	MSFErrorMessage msfEm = new MSFErrorMessage("","",MSFErrorMessage.ERRCODE_NOT_FOUND,"생성할 데이타가 존재하지 않습니다."); 
		            	emList.add(msfEm);
		            	throw MSFServerUtils.getValidationException("createDlgn0250WorkPerfm",emList , logger);
		            }
		        
		            for(int iPayrCnt=0;iPayrCnt < listDlgn0250.size();iPayrCnt++) {
		                
		                Dlgn0250VO      dlgn0250VO = new Dlgn0250VO(); 
		                dlgn0250VO = listDlgn0250.get(iPayrCnt);
		             
		                Dlgn0100VO dlgn0100Vo = new Dlgn0100VO();  
		                Dlgn0200VO dlgn0200Vo = new Dlgn0200VO();   
		
		
		             dlgn0100Vo.setDpobCd(dlgn0250VO.getDpobCd());    										/** column 사업장코드 : dpobCd */
		             dlgn0100Vo.setSystemkey(dlgn0250VO.getSystemkey());    								/** column SYSTEMKEY : systemkey */
		             dlgn0100Vo.setDilnlazYrMnth(dlgn0250SrhVO.getJobYrMnth().replace(".", ""));    		/** column 근태년월 : dilnlazYrMnth */
		             dlgn0100Vo.setPayCd(dlgn0250SrhVO.getPayCd());    										/** column 급여구분코드 : payCd */
		             dlgn0100Vo.setEmymtDivCd(dlgn0250VO.getEmymtDivCd());   						 		/** column 고용구분코드 : emymtDivCd */
		             dlgn0100Vo.setDeptCd(dlgn0250VO.getDeptCd());    										/** column 부서코드 : deptCd */
		             dlgn0100Vo.setBusinCd(dlgn0250VO.getBusinCd());   									 	/** column 사업코드 : businCd */
		             dlgn0100Vo.setTypOccuCd(dlgn0250VO.getTypOccuCd());    								/** column 직종코드 : typOccuCd */
		             dlgn0100Vo.setDtilOccuInttnCd(dlgn0250VO.getDtilOccuInttnCd());    					/** column 직종세통합코드 : dtilOccuInttnCd */
		             dlgn0100Vo.setDilnlazDutyBgnnDt(dlgn0250SrhVO.getRflctnBgnnDt());    					/** column 근태_근무시작일자 : dilnlazDutyBgnnDt */
		             dlgn0100Vo.setDilnlazDutyEndDt(dlgn0250SrhVO.getRflctnEndDt());    					/** column 근태_근무종료일자 : dilnlazDutyEndDt */
		             dlgn0100Vo.setDilnlazDutyNumDys(String.valueOf(maxDays));    							/** column 근태_근무일수 : dilnlazDutyNumDys */
		             dlgn0100Vo.setDilnlazLvsgNumDys(dlgn0250VO.getDilnlazLvsgNumDys());    				/** column 근태_연가일수 : dilnlazLvsgNumDys */
		             dlgn0100Vo.setDilnlazAbnceNumDys(dlgn0250VO.getDilnlazAbnceNumDys());    				/** column 근태_결근일수 : dilnlazAbnceNumDys */
		             dlgn0100Vo.setDilnlazSckleaNumDys(dlgn0250VO.getDilnlazSckleaNumDys());    			/** column 근태_병가일수 : dilnlazSckleaNumDys */
		             dlgn0100Vo.setDilnlazOffvaNumDys(dlgn0250VO.getDilnlazOffvaNumDys());    				/** column 근태_공가일수 : dilnlazOffvaNumDys */
		             dlgn0100Vo.setDilnlazFmlyEvntNumDys(dlgn0250VO.getDilnlazFmlyEvntNumDys());  			/** column 근태_경조사일수 : dilnlazFmlyEvntNumDys */
		             dlgn0100Vo.setDilnlazHlthCreNumDys(dlgn0250VO.getDilnlazHlthCreNumDys());    			/** column 근태_보건일수 : dilnlazHlthCreNumDys */
		             
		             //근무일수 계산하기 위한 루틴.
		             /*
		              * 5월사이에 시작일자가 큰경우
		              * 5월사이에 종료일자가 포함된경우
		              * 5월사이에 시작/종료일자가 다포함된경우
		              * 퇴사자인경우 퇴사일자가 포함된경우 처리.
		              */
		             dlgn0100Vo.setDilnlazTotDutyNumDys(String.valueOf(wkDays));    							/** column 근태_총근무일수 : dilnlazTotDutyNumDys */
		             //퇴직 TODO 실근무일수 
		             if (ExtermsProps.getProps("HDOFC_CODTN_CD_20").equals(dlgn0250VO.getHdofcCodtnCd())) {
		            	 
		            	 if ((dlgn0250SrhVO.getRflctnBgnnDt().compareTo(dlgn0250VO.getRetryDt()) <= 0) 
		        			     && (dlgn0250SrhVO.getRflctnEndDt().compareTo(dlgn0250VO.getRetryDt()) >= 0)) {
		            		
		            		 int wkDays1 = AnyDateTime.daysBetween(dlgn0250SrhVO.getRflctnBgnnDt(), dlgn0250VO.getRetryDt(),0);
		            		 
		            		 dlgn0100Vo.setDilnlazTotDutyNumDys(String.valueOf(wkDays1));    					/** column 근태_총근무일수 : dilnlazTotDutyNumDys */ 
		            	 }
		            		 
		             //휴직 		 
		             } else if (ExtermsProps.getProps("HDOFC_CODTN_CD_30").equals(dlgn0250VO.getHdofcCodtnCd())) {
		            	 
		            	 if (MSFSharedUtils.paramNotNull(dlgn0250VO.getLevfAbncBgnnDt())) {
		                	 if ((dlgn0250SrhVO.getRflctnBgnnDt().compareTo(dlgn0250VO.getLevfAbncBgnnDt()) <= 0) 
		                			     && (dlgn0250SrhVO.getRflctnEndDt().compareTo(dlgn0250VO.getLevfAbncEndDt()) <= 0)) {
		                		//시작일자만 포함된경우 
		                		 int wkDays1 = AnyDateTime.daysBetween(dlgn0250SrhVO.getRflctnBgnnDt(), dlgn0250VO.getLevfAbncBgnnDt(),0);
		                		 
		                		 dlgn0100Vo.setDilnlazTotDutyNumDys(String.valueOf(wkDays1));					/** column 근태_총근무일수 : dilnlazTotDutyNumDys */ 
		                		 
		                	 } else if ((dlgn0250SrhVO.getRflctnBgnnDt().compareTo(dlgn0250VO.getLevfAbncBgnnDt()) > 0) 
		            			     && (dlgn0250SrhVO.getRflctnEndDt().compareTo(dlgn0250VO.getLevfAbncEndDt()) >= 0)) {
		            		     //종료일자가 포함된경우  
		                		 int wkDays1 = AnyDateTime.daysBetween(dlgn0250VO.getLevfAbncEndDt(), dlgn0250SrhVO.getRflctnEndDt(),0);
		                		 dlgn0100Vo.setDilnlazTotDutyNumDys(String.valueOf(wkDays1));					/** column 근태_총근무일수 : dilnlazTotDutyNumDys */
		                		 
		            	    } else if ((dlgn0250SrhVO.getRflctnBgnnDt().compareTo(dlgn0250VO.getLevfAbncBgnnDt()) <= 0) 
		           			     && (dlgn0250SrhVO.getRflctnEndDt().compareTo(dlgn0250VO.getLevfAbncEndDt()) >= 0)) {
		           		        //시작일자만 종료일자가 모두 포함 
		            	    	 int wkDays1 = AnyDateTime.daysBetween(dlgn0250VO.getLevfAbncBgnnDt(), dlgn0250VO.getLevfAbncEndDt(),0); 
		            	    	 dlgn0100Vo.setDilnlazTotDutyNumDys(String.valueOf((maxDays - wkDays1)));		/** column 근태_총근무일수 : dilnlazTotDutyNumDys */
		           	        }
		            	 }
		             } else if (ExtermsProps.getProps("HDOFC_CODTN_CD_10").equals(dlgn0250VO.getHdofcCodtnCd())) {
		            	 
		            	 if (MSFSharedUtils.paramNotNull(dlgn0250VO.getLevfAbncBgnnDt())) {
		                	 if ((dlgn0250SrhVO.getRflctnBgnnDt().compareTo(dlgn0250VO.getLevfAbncBgnnDt()) <= 0) 
		                			     && (dlgn0250SrhVO.getRflctnEndDt().compareTo(dlgn0250VO.getLevfAbncEndDt()) <= 0)) {
		                		//시작일자만 포함된경우 
		                		 int wkDays1 = AnyDateTime.daysBetween(dlgn0250SrhVO.getRflctnBgnnDt(), dlgn0250VO.getLevfAbncBgnnDt(),0);
		                		 
		                		 dlgn0100Vo.setDilnlazTotDutyNumDys(String.valueOf(wkDays1));    				/** column 근태_총근무일수 : dilnlazTotDutyNumDys */ 
		                		 
		                	 } else if ((dlgn0250SrhVO.getRflctnBgnnDt().compareTo(dlgn0250VO.getLevfAbncBgnnDt()) > 0) 
		            			     && (dlgn0250SrhVO.getRflctnEndDt().compareTo(dlgn0250VO.getLevfAbncEndDt()) >= 0)) {
		            		     //종료일자가 포함된경우  
		                		 int wkDays1 = AnyDateTime.daysBetween(dlgn0250VO.getLevfAbncEndDt(), dlgn0250SrhVO.getRflctnEndDt(),0);
		                		 dlgn0100Vo.setDilnlazTotDutyNumDys(String.valueOf(wkDays1));    				/** column 근태_총근무일수 : dilnlazTotDutyNumDys */
		                		 
		            	    } else if ((dlgn0250SrhVO.getRflctnBgnnDt().compareTo(dlgn0250VO.getLevfAbncBgnnDt()) <= 0) 
		           			     && (dlgn0250SrhVO.getRflctnEndDt().compareTo(dlgn0250VO.getLevfAbncEndDt()) >= 0)) {
		           		        //시작일자만 종료일자가 모두 포함 
		            	    	 int wkDays1 = AnyDateTime.daysBetween(dlgn0250VO.getLevfAbncBgnnDt(), dlgn0250VO.getLevfAbncEndDt(),0); 
		            	    	 dlgn0100Vo.setDilnlazTotDutyNumDys(String.valueOf((maxDays - wkDays1)));    	/** column 근태_총근무일수 : dilnlazTotDutyNumDys */
		           	        }
		            	 }
		             }     
		              
		             
		             dlgn0100Vo.setDilnlazWklyHldyNumDys(dlgn0250VO.getDilnlazWklyHldyNumDys());    								/** column 근태_주휴일수 : dilnlazWklyHldyNumDys */
		             dlgn0100Vo.setDilnlazPaidPubcHodyNum(dlgn0250VO.getDilnlazPaidPubcHodyNum());    								/** column 근태_유급휴일수 : dilnlazPaidPubcHodyNum */
		             dlgn0100Vo.setDilnlazDdlnePrcsYn((Boolean.TRUE.equals(dlgn0250VO.getDilnlazDdlnePrcsYn()) ? "Y" : "N") );    	/** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
		             dlgn0100Vo.setDilnlazNoteCtnt(dlgn0250VO.getDilnlazNoteCtnt());    											/** column 근태_비고내용 : dilnlazNoteCtnt */ 
		             dlgn0100Vo.setDilnlazSpclHodyNumDys(dlgn0250VO.getDilnlazSpclHodyNumDys());    								/** column 근태_특별휴가일수 : dilnlazSpclHodyNumDys */
		             dlgn0100Vo.setDilnlazSatDutyNumDys(dlgn0250VO.getDilnlazSatDutyNumDys());    									/** column 총토요근무일수 : dilnlazSatDutyNumDys */
		//             dlgn0100Vo.setDilnlazPubcHodyDutyNumDys(dlgn0250VO.getDilnlazPubcHodyDutyNumDys());    						/** column 총휴일근무일수 : dilnlazPubcHodyDutyNumDys */
		             dlgn0100Vo.setDilnlazHodyDutyNumDys(dlgn0250VO.getDilnlazHodyDutyNumDys());    								/** column 휴일일수 : dilnlazHodyDutyNumDys */
		             dlgn0100Vo.setDilnlazAbnceDutyRcgtnDys(dlgn0250VO.getDilnlazAbnceDutyRcgtnDys());    							/** column 근태_결근인정일수 : dilnlazAbnceDutyRcgtnDys */
		             dlgn0100Vo.setPyspGrdeCd(dlgn0250VO.getPyspGrdeCd());    														/** column 호봉등급코드 : pyspGrdeCd */
		             dlgn0100Vo.setDilnlazTotDutyTm(dlgn0250VO.getDilnlazTotDutyTm());    											/** column 근태_총근무시간 : dilnlazTotDutyTm */
		             dlgn0100Vo.setDilnlazPaidHodyNumDys(dlgn0250VO.getDilnlazPaidHodyNumDys());    								/** column 근태_유급휴가일수 : dilnlazPaidHodyNumDys */
		             dlgn0100Vo.setDilnlazTfcAssCstNumDys(dlgn0250VO.getDilnlazTfcAssCstNumDys());    								/** column 근태_교통보조비일수 : dilnlazTfcAssCstNumDys */ 
		             dlgn0100Vo.setDilnlazWkdDutyNumDys(dlgn0250VO.getDilnlazWkdDutyNumDys());    									/** column 평일근무일수 : dilnlazWkdDutyNumDys */
		
		             dlgn0100Vo.setKybdr(sessionUser.getUsrId());    																/** column 입력자 : kybdr */
		             dlgn0100Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 입력주소 : inptAddr */
		             dlgn0100Vo.setIsmt(sessionUser.getUsrId());    																/** column 수정자 : ismt */
		             dlgn0100Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정주소 : revnAddr */
		
		   
		                     
		             dlgn0200Vo.setDpobCd(dlgn0250VO.getDpobCd());    															/** column 사업장코드 : dpobCd */
		             dlgn0200Vo.setSystemkey(dlgn0250VO.getSystemkey());    													/** column SYSTEMKEY : systemkey */
		             dlgn0200Vo.setDilnlazExceDutyYrMnth(dlgn0250SrhVO.getJobYrMnth().replace(".", ""));    					/** column 근태초과근무년월 : dilnlazExceDut8yYrMnth */
		             dlgn0200Vo.setPayCd(dlgn0250SrhVO.getPayCd());    															/** column 급여구분코드 : payCd */
		             dlgn0200Vo.setEmymtDivCd(dlgn0250VO.getEmymtDivCd());    													/** column 고용구분코드 : emymtDivCd */
		             dlgn0200Vo.setDeptCd(dlgn0250VO.getDeptCd());    															/** column 부서코드 : deptCd */
		             dlgn0200Vo.setBusinCd(dlgn0250VO.getBusinCd());    														/** column 사업코드 : businCd */
		             dlgn0200Vo.setTypOccuCd(dlgn0250VO.getTypOccuCd());    													/** column 직종코드 : typOccuCd */
		             dlgn0200Vo.setDtilOccuInttnCd(dlgn0250VO.getDtilOccuInttnCd());    										/** column 직종세구분코드 : dtilOccuInttnCd */
		             dlgn0200Vo.setDilnlazExceDutyBgnnDt(dlgn0250SrhVO.getRflctnBgnnDt());    									/** column 근태_초과근무시작일자 : dilnlazExceDutyBgnnDt */
		             dlgn0200Vo.setDilnlazExceDutyEndDt(dlgn0250SrhVO.getRflctnEndDt());    									/** column 근태_초과근무종료일자 : dilnlazExceDutyEndDt */
		//             dlgn0200Vo.setDilnlazPubcHodyDutyNumDys(dlgn0250VO.getDilnlazPubcHodyDutyNumDys());    					/** column 근태_휴일근무일수 : dilnlazPubcHodyDutyNumDys */
		             dlgn0200Vo.setDilnlazPubcHodyDutyNumDys(dlgn0250VO.getDilnlazHodyDutyNumDys());    						/** column 휴일일수 : dilnlazHodyDutyNumDys */
		             dlgn0200Vo.setDilnlazSatDutyNumDys(dlgn0250VO.getDilnlazSatDutyNumDys());    								/** column 근태_토요근무일수 : dilnlazSatDutyNumDys */
		            // dlgn0200Vo.setDilnlazTotNtotNumDys(dlgn0250Dto.getDilnlazTotNtotNumDys());    /** column 근태_총야근일수 : dilnlazTotNtotNumDys */
		             dlgn0200Vo.setDilnlazTotNtotTm(dlgn0250VO.getDilnlazTotNtotTm());    										/** column 근태_총야근시간 : dilnlazTotNtotTm */
		             dlgn0200Vo.setDilnlazFndtnTmRstDutyTm(dlgn0250VO.getDilnlazFndtnTmRstDutyTm());    						/** column 근태_기본시간외근무시간 : dilnlazFndtnTmRstDutyTm */
		             dlgn0200Vo.setDilnlazTmRstDutyTm(dlgn0250VO.getDilnlazTmRstDutyTm());    									/** column 근태_시간외근무시간 : dilnlazTmRstDutyTm */
		             dlgn0200Vo.setDilnlazTotTmRstDutyTm(dlgn0250VO.getDilnlazTotTmRstDutyTm());    							/** column 근태_총시간외근무시간 : dilnlazTotTmRstDutyTm */
		             dlgn0200Vo.setDilnlazDdlnePrcsYn((Boolean.TRUE.equals(dlgn0250VO.getDilnlazDdlnePrcsYn()) ? "Y" : "N") );	/** column 근태_마감처리여부 : dilnlazDdlnePrcsYn */
		             dlgn0200Vo.setDilnlazNoteCtnt(dlgn0250VO.getDilnlazNoteCtnt());    										/** column 근태_비고내용 : dilnlazNoteCtnt */
		             dlgn0200Vo.setPyspGrdeCd(dlgn0250VO.getPyspGrdeCd());    													/** column 호봉등급코드 : pyspGrdeCd */
		             dlgn0200Vo.setKybdr(sessionUser.getUsrId());    															/** column 입력자 : kybdr */
		             dlgn0200Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    						/** column 입력주소 : inptAddr */
		             dlgn0200Vo.setIsmt(sessionUser.getUsrId());    															/** column 수정자 : ismt */
		             dlgn0200Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    						/** column 수정주소 : revnAddr */
		
		                 
		             dlgn0200DAO.deleteDlgn0200(dlgn0200Vo);
		             dlgn0100DAO.deleteDlgn0100(dlgn0100Vo);
		
		             dlgn0100DAO.insertDlgn0100(dlgn0100Vo);
		             dlgn0200DAO.insertDlgn0200(dlgn0200Vo);
		             
		 			/** 로그반영
		 			 * CRUDSBLO
		 			 * C:create		R:read		U:update
		 	    	 * D:delete		S:select	B:배치 
		 	    	 * L:로그인		O:로그아웃
		 	    	 */
		 			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D:C:B");
		                
		             iCnt = iCnt + 1; 
		                     
		            } 
		            
		            result = iCnt; 
		          
		        } catch (Exception ex) {
		        	
		            logger.error("EXCEPTION calling createDlgn0250WorkPerfm(): "+ex); 
		            ex.printStackTrace();
		            
		            /** 에러 로그 **/			
		            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D:C:B",ex, windowNm , windowId);
		            
		            result = new Long(0);
		            throw MSFServerUtils.getOperationException("createDlgn0250WorkPerfm", ex, logger);
		        }
		        finally {
		          
		        }
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result;
    }
    
    
    private static long diffOfDate(String begin, String end) throws Exception
    {
       SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
 
//      Calendar beginDate = Calendar.getInstance(); 
//      Calendar endDate = Calendar.getInstance(); 
     
      Date beginDate = formatter.parse(begin);
      Date endDate = formatter.parse(end); 

      //System.out.println("dlgn0250SrhVO.getRflctnBgnnDt()2" + beginDate);
      //System.out.println("dlgn0250SrhVO.getRflctnBgnnDt()2" + endDate);
      
      long diff = endDate.getTime() - beginDate.getTime();
      long diffDays = diff / (24 * 60 * 60 * 1000); 
     // System.out.println("dlgn0250SrhVO.getRflctnBgnnDt()3" + diffDays);
      return diffDays + 1;
    }
 


}
