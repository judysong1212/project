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
package com.app.exterms.prgm.server.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exterms.prgm.client.service.PrgmRemtComService;
import com.app.exterms.prgm.server.service.dao.PrgmComPayr0400DAO;
import com.app.exterms.prgm.shared.PrgmComDaoConstants;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;

@Service("PrgmRemtComService")
public class PrgmRemtComServiceImpl extends AbstractCustomServiceImpl  implements  PrgmRemtComService ,PrgmComDaoConstants {
    
    private static final Logger logger = LoggerFactory.getLogger(PrgmRemtComServiceImpl.class);
    private static final String calledClass =  PrgmRemtComServiceImpl.class.getName();
    
    
    @Autowired
    @Resource(name="PrgmComPayr0400DAO")
    private PrgmComPayr0400DAO sysPayr0400DAO;
     
//    public PagingLoadResult<BaseModel> getPrgmComPopupRemt3100List(ServiceParameters serviceParameters) throws MSFException {
//
//        PagingLoadResult<BaseModel> retval = null;
//        String method =  PRGMCOM_METHOD_POPUP_REMTCOMP2100_List;
//        PrgmComSearchVO   sysComSearchVo = new PrgmComSearchVO();
//        PrgmComPsnl0100VO      sysComPsnl0100Vo = new PrgmComPsnl0100VO();
//        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
//        
//        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//        
//        if  (MSFSharedUtils.paramNull(psnl0100DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            psnl0100DAO = (PrgmComPsnl0100DAO) wac.getBean("PrgmComPsnl0100DAO" ); 
//        }
//        
//        try {
//            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
//           // Sysm0400BM          user             = serviceParameters.getUser();
//            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
//            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
//            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
//            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
//
//            //Get paging configuration
//            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
//
//            //Get query parameters
//            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
//           
//            /** 조건절 */
//            sysComSearchVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//            sysComSearchVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//            sysComSearchVo.setPayrMangeDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
//            sysComSearchVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
//             
//            List<String> listDeptCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//            sysComSearchVo.setDeptCdArr(listDeptCd);     //부서코드
//            sysComSearchVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//            
//           // sysComSearchVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//            sysComSearchVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
//            sysComSearchVo.setBusinApptnYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businApptnYr"))); //사업년도
//            
//            List<String> lstTypeOccuCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
//            sysComSearchVo.setTypOccuCdArr(lstTypeOccuCd); 
//            sysComSearchVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//           
//            List<String> lstPyspGrdeCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//            sysComSearchVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//            sysComSearchVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//             
//            List<String> lstDtilOccuClsDivCd = PrgmComServerUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsDivCd"))); 
//            sysComSearchVo.setDtilOccuClsDivCdArr(lstDtilOccuClsDivCd);  
//            sysComSearchVo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuClsDivCd"))); //직종세
//            
//            sysComSearchVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));       //재직상태  
//            
//            sysComSearchVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
//            sysComSearchVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
//            
//            //Get total record count //전체 데이터 갯수를 가지고 온다. 
//             if ( pagingValues.executeRecordCount ) { 
//                    
//                //Execute query that returns a single value
//                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//                 
//                int iResultCnt = psnl0100DAO.selectPsnl0100ToPayr1700ListTotCnt(sysComSearchVo);  
//              
//                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
//                pagingValues.totalRecordCount = iResultCnt;        
//                
//                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//            }
//        
//            TimingInfo millisBeginPsnl0100ToPayr1700DataList = SmrmfUtils.startTiming(logger);
//        
//            /**페이지 카운트 처리를 위한 부분 */ 
//            sysComSearchVo.setPageSize(pagingValues.totalRecordCount);  
//            
//            //Apply paging
//            if (pagingValues.start > 0) {
//                sysComSearchVo.setFirstIndex(pagingValues.start);
//            }
//            if (pagingValues.offsetLimit > 0) {
//                sysComSearchVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
//            }
//
//            //Execute query and convert to BaseModel list
//            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//            
//            @SuppressWarnings("unchecked")
////            Collection<Map<String, Object>> list ??????
//            List list = psnl0100DAO.selectPsnl0100ToPayr1700List(sysComSearchVo);
//            
//            Iterator<Map<String, Object>> iter = list.iterator();
//                
//            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
//           
//        
//            while ( iter.hasNext() ) {
//                Map<String, Object> map = (Map<String, Object>) iter.next();
//                String idValue = map.get("systemkey").toString();
//                BaseModel bm = new BaseModel();
// 
//                //bm.setProperties(map);
//                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
//                    
//                 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
//                    Object baseModelValue = null;
//                    //콤보박스처리를 위해 추가함
//                    if (tableAttributes[i].getName().contains("$")) {
//                         String mapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
//                              
//                         map.put(tableAttributes[i].getName(),map.get(mapCon));
//                         
//                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//                    } else {
//                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//                    }
//                 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/  
// 
//                    
//                    bm.set(tableAttributes[i].getName(), baseModelValue);
//                }
//
//                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
//                bmResult.add(bm);
//            } 
//
//            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
//            
//            SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToPayr1700DataList, "getPsnl0100ToPayr1700DataList");
//       
//
//        }
//        catch (Exception ex) {
//            ex.printStackTrace();
//            //Return operation exception
//            throw MSFServerUtils.getOperationException(method, ex, logger);
//        }
//
//        return retval;
//    }
       
 
        
}
