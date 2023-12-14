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

import com.app.exterms.retirement.client.dto.Remt1000DTO;
import com.app.exterms.retirement.client.service.Remt0050Service;
import com.app.exterms.retirement.server.service.dao.Remt1000DAO;
import com.app.exterms.retirement.server.vo.Remt1000SrhVO;
import com.app.exterms.retirement.server.vo.Remt1000VO;
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

@Service("Remt0050Service")
public class Remt0050ServiceImpl extends AbstractCustomServiceImpl implements Remt0050Service  ,RemtDaoConstants {

    private static final Logger logger = LoggerFactory.getLogger(Remt0050ServiceImpl.class);
    private static final String calledClass = Remt0050ServiceImpl.class.getName();
    
    @Autowired
    @Resource(name="Remt1000DAO")
    private Remt1000DAO remt1000DAO;
    
    
    public List<BaseModel> activityOnRemt1000Save(ServiceParameters serviceParameters) {

        List<BaseModel> lsBmResult = new ArrayList<BaseModel>();
        String result = "1";  
        Remt1000SrhVO   remt1000SrhVo = new Remt1000SrhVO();
    	String method = calledClass + ".activityOnRemt1000Save";
    	
    	String windowNm = "퇴직금가산율관리";
		String windowId = "REMT1000";
    	

    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        
        List<BaseModel> listObjects       = serviceParameters.getDataObjects();
        ActionDatabase actionDatabase     = serviceParameters.getActionDatabase(); 
        String customMethodName           = serviceParameters.getCustomMethodName();
        ColumnAttribute[] tableAttributes = serviceParameters.getTableAttributes();
        Boolean reloadData                = serviceParameters.isReloadData();
        Boolean noHistory                 = serviceParameters.isNoHistory(); 
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
         
        if  (MSFSharedUtils.paramNull(remt1000DAO)) {
            //getHttpServletRequest().getSession().getServletContext()
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( RemoteServiceUtil.getThreadLocalRequest().getSession().getServletContext() );

            remt1000DAO = (Remt1000DAO) wac.getBean("Remt1000DAO"); 
        }
         
        try {
              
             for (BaseModel objectBm : listObjects) { 
                 
                 Remt1000VO      remt1000Vo = new Remt1000VO();
                 
                 remt1000Vo.setDpobCd(MSFSharedUtils.defaultNulls(objectBm.get("dpobCd"),sessionUser.getDpobCd()));    /** column 사업장코드 : dpobCd */
                 remt1000Vo.setSevePayAddRateSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(objectBm.get("sevePayAddRateSeilNum"),"0")));    /** column 퇴직금가산율일련번호 : sevePayAddRateSeilNum */
                 
                 remt1000Vo.setTypOccuCd(MSFSharedUtils.allowNulls(objectBm.get("typOccuCd$typOccuCd")));    /** column 직종코드 : typOccuCd */
//               if (MSFSharedUtils.paramNotNull(objectBm.get("typOccuCd$typOccuCd")) && (!MSFSharedUtils.allowNulls(objectBm.get("typOccuCd$typOccuCd")).equals("!")) ) {
//                   String[] tptypOccuCd = MSFSharedUtils.allowNulls(objectBm.get("typOccuCd$typOccuCd")).split("!"); 
//                   remt1000Vo.setTypOccuCd(tptypOccuCd[0]);    /** column 직종코드 : typOccuCd */
//                   remt1000Vo.setPyspGrdeCd(tptypOccuCd[1]);    /** column 호봉등급코드 : pyspGrdeCd */
//               } else {
//                   remt1000Vo.setTypOccuCd("");    /** column 직종코드 : typOccuCd */
//                   remt1000Vo.setPyspGrdeCd("");    /** column 호봉등급코드 : pyspGrdeCd */  
//               } 
                 remt1000Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(objectBm.get("dtilOccuInttnCd$dtilOccuInttnCd")));   //직종세통합코드
                 remt1000Vo.setSevePayAddRateFrmCd(MSFSharedUtils.allowNulls(objectBm.get("sevePayAddRateFrmCd$commCd")));    /** column 퇴직금가산율유형코드 : sevePayAddRateFrmCd */
                 remt1000Vo.setSevePayAddOvr(MSFSharedUtils.allowNulls(objectBm.get("sevePayAddOvr")));    /** column 퇴직금가산이상 : sevePayAddOvr */
                 remt1000Vo.setSevePayAddUdr(MSFSharedUtils.allowNulls(objectBm.get("sevePayAddUdr")));    /** column 퇴직금가산미만 : sevePayAddUdr */
                 remt1000Vo.setSevePayAddSum(new BigDecimal(MSFSharedUtils.defaultNulls(objectBm.get("sevePayAddSum"),"0")));    /** column 퇴직금가산금액 : sevePayAddSum */
                 remt1000Vo.setSevePayAddRate(MSFSharedUtils.allowNulls(objectBm.get("sevePayAddRate")));    /** column 퇴직금가산율 : sevePayAddRate */
                 remt1000Vo.setSevePayAddBgnnDt(new SimpleDateFormat("yyyyMMdd").format((Date)objectBm.get("sevePayAddBgnnDt")) );    /** column 퇴직금가산시작일자 : sevePayAddBgnnDt */
                 remt1000Vo.setSevePayAddEndDt(new SimpleDateFormat("yyyyMMdd").format((Date)objectBm.get("sevePayAddEndDt")));    /** column 퇴직금가산종료일자 : sevePayAddEndDt */
                 remt1000Vo.setSevePayAddUseYn(Boolean.TRUE.equals( (Boolean)objectBm.get("sevePayAddUseYn")) ? "Y" : "N" );    /** column 퇴직금가산사용여부 : sevePayAddUseYn */
                 
                 
                 remt1000Vo.setSevePayNoteCtnt(MSFSharedUtils.allowNulls(objectBm.get("sevePayNoteCtnt")));    /** column 퇴직금비고내용 : sevePayNoteCtnt */
//                 remt1000Vo.setKybdr(dlgn0200Vo.getKybdr());    /** column 입력자 : kybdr */
//                 remt1000Vo.setInptDt(dlgn0200Vo.getInptDt());    /** column 입력일자 : inptDt */
//                 remt1000Vo.setInptAddr(dlgn0200Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//                 remt1000Vo.setIsmt(dlgn0200Vo.getIsmt());    /** column 수정자 : ismt */
//                 remt1000Vo.setRevnDt(dlgn0200Vo.getRevnDt());    /** column 수정일자 : revnDt */
//                 remt1000Vo.setRevnAddr(dlgn0200Vo.getRevnAddr());    /** column 수정주소 : revnAddr */

                   
                 switch (actionDatabase) {
                 case INSERT: 
                     remt1000DAO.insertRemt1000(remt1000Vo); 
                     break;
                 case UPDATE:  
                     remt1000DAO.updateRemt1000(remt1000Vo); 
                     break;
                 case DELETE: 
                     remt1000DAO.deleteRemt1000(remt1000Vo);
                     break;
                 } 
                
        
            } 
         }catch (Exception ex) {
             logger.error("EXCEPTION calling activityOnSysm0100Cud(): "+ex); 
             ex.printStackTrace();
             
             /** 에러 로그 **/			
             MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), ex, windowNm , windowId);
             
             result = "0";
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
    
    
    public PagingLoadResult<BaseModel> getSelectRemt0050ToRemt1000List(ServiceParameters serviceParameters) throws MSFException {

        PagingLoadResult<BaseModel> retval = null;
        String method =  CLASS_REMT1000_DATA_LIST;
        Remt1000SrhVO   remt1000SrhVo = new Remt1000SrhVO();
        List<BaseModel> bmResult = new ArrayList<BaseModel>();
        
        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
        

    	// 1. 암호화 객체 생성
    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        
        if  (MSFSharedUtils.paramNull(remt1000DAO)) {
        
            WebApplicationContext wac = WebApplicationContextUtils.
                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

            remt1000DAO = (Remt1000DAO) wac.getBean("Remt1000DAO" ); 
        }
        
        try {
            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
           // Remt1000BM          user             = serviceParameters.getUser();
            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();

            //Get paging configuration
            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
 
            /** 조건절 */
            remt1000SrhVo.setDpobCd(sessionUser.getDpobCd());
            remt1000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));    //검색조건처리
            String dtilOccuInttnCd = "".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))) ? null : MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"));
            List<String> dtilOccuInttnCdArr = SmrmfUtils.getStrToArrayList(dtilOccuInttnCd);
            remt1000SrhVo.setDtilOccuInttnCd(dtilOccuInttnCd);
            remt1000SrhVo.setDtilOccuInttnCdArr(dtilOccuInttnCdArr);
            remt1000SrhVo.setSevePayAddRateFrmCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "sevePayAddRateFrmCd")));
            
            //sysComSrhVo.setRpsttvCd(strCriteriaValue); 
         
            //Get total record count //전체 데이터 갯수를 가지고 온다. 
                if ( pagingValues.executeRecordCount ) { 
                    
                //Execute query that returns a single value
                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
                 
                int iResultCnt = remt1000DAO.selectRemt1000ListTotCnt(remt1000SrhVo);  
              
                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
                pagingValues.totalRecordCount = iResultCnt;        
                
                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
            }
        
            TimingInfo millisBeginSelectRemt1000List = SmrmfUtils.startTiming(logger);
        
            /**페이지 카운트 처리를 위한 부분 */ 
            remt1000SrhVo.setPageSize(pagingValues.totalRecordCount);  
            
            //Apply paging
            if (pagingValues.start > 0) {
                remt1000SrhVo.setFirstIndex(pagingValues.start);
            }
            if (pagingValues.offsetLimit > 0) {
                remt1000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
            }

            //Execute query and convert to BaseModel list
            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
            
            @SuppressWarnings("unchecked")
//            Collection<Map<String, Object>> list ??????
            List list = remt1000DAO.selectRemt1000List(remt1000SrhVo);
            
                Iterator<Map<String, Object>> iter = list.iterator();
                
            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
           
            while ( iter.hasNext() ) {
                Map<String, Object> map = (Map<String, Object>) iter.next();
                String idValue = map.get("sevePayAddRateSeilNum").toString();
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
            
            SmrmfUtils.endTiming(logger, millisBeginSelectRemt1000List, "selectRemt1000List");
       

        }
        catch (Exception ex) {
            ex.printStackTrace();
            //Return operation exception
            throw MSFServerUtils.getOperationException(method, ex, logger);
        }

        return retval;
    }


    @Override
    public Long saveRemt1000Save(Remt1000DTO dto, ActionDatabase actionDatabase) throws MSFException {
        Long returnCnt = 0L;

        String method = CLASS_REMT1000_SAVE;

        String windowNm = "퇴직금가산율관리";
        String windowId = "REMT1000";


        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());

        if("".equals(dto.getDpobCd()) || dto.getDpobCd() == null){
            dto.setDpobCd(sessionUser.getDpobCd());
        }

        Remt1000VO remt1000VO = new Remt1000VO();

        remt1000VO.setDpobCd(MSFSharedUtils.allowNulls(dto.getDpobCd()));                        								// 사업장코드
        remt1000VO.setSevePayAddRateSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(dto.getSevePayAddRateSeilNum(), "0")));	// 퇴직금가산율일련번호
        remt1000VO.setTypOccuCd(MSFSharedUtils.allowNulls(dto.getTypOccuCd()));							                        // 직종코드
        remt1000VO.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(dto.getDtilOccuInttnCd()));							            // 직종세통합코드
        remt1000VO.setSevePayAddRateFrmCd(MSFSharedUtils.allowNulls(dto.getSevePayAddRateFrmCd()));                             // 퇴직금가산율유형코드
        remt1000VO.setSevePayAddOvr(MSFSharedUtils.allowNulls(dto.getSevePayAddOvr()));											// 퇴직금가산이상
        remt1000VO.setSevePayAddUdr(MSFSharedUtils.allowNulls(dto.getSevePayAddUdr()));											// 퇴직금가산미만
        remt1000VO.setSevePayAddSum(new BigDecimal(MSFSharedUtils.defaultNulls(dto.getSevePayAddSum(),"0")) );				// 퇴직금가산금액
        remt1000VO.setSevePayAddRate(MSFSharedUtils.defaultNulls(dto.getSevePayAddRate(),"0") );			                    // 퇴직금가산율
        remt1000VO.setSevePayAddBgnnDt(MSFSharedUtils.allowNulls(dto.getSevePayAddBgnnDt()));	                                // 퇴직금가산시작일자
        remt1000VO.setSevePayAddEndDt(MSFSharedUtils.allowNulls(dto.getSevePayAddEndDt()));		                                // 퇴직금가산종료일자
        remt1000VO.setSevePayAddUseYn(MSFSharedUtils.allowNulls((Boolean.TRUE.equals(dto.getSevePayAddUseYn()) ? "Y" : "N") ));	// 퇴직금가산사용여부
        remt1000VO.setSevePayNoteCtnt(MSFSharedUtils.allowNulls(dto.getSevePayNoteCtnt()));										// 퇴직금비고내용
        remt1000VO.setKybdr(sessionUser.getUsrId());    /** column 입력자 : kybdr */
        remt1000VO.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 입력주소 : inptAddr */
        remt1000VO.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
        remt1000VO.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정주소 : revnAddr */




        try {

            switch(actionDatabase){
                case INSERT :
                    remt1000DAO.insertRemt1000(remt1000VO);
                    break;
                case UPDATE :
                    remt1000DAO.updateRemt1000(remt1000VO);
                    break;
                case DELETE :
                    remt1000DAO.deleteRemt1000(remt1000VO);
                    break;
            }


            /** 로그반영
             * CRUDSBLO
             * C:create		R:read		U:update
             * D:delete		S:select	B:배치
             * L:로그인		O:로그아웃
             */
            MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, CLASS_REMT1000_SAVE, actionDatabase.toString());

            returnCnt = 1L;

        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            /** 에러 로그 **/
            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,CLASS_REMT1000_SAVE,actionDatabase.toString(),e, windowNm , windowId);

            returnCnt = 0L;
        }
        return returnCnt;
    }
}
