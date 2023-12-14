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
package com.app.smrmf.syscom.server.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.syscom.client.service.SysComCmmn0600Service;
import com.app.smrmf.syscom.shared.SysComDaoConstants;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

@Service("SysComCmmn0600Service")
public class SysComCmmn0600ServiceImpl extends AbstractCustomServiceImpl implements  SysComDaoConstants , SysComCmmn0600Service {
	
	private static final Logger logger = LoggerFactory.getLogger(SysComCmmn0600ServiceImpl.class);
	private static final String calledClass = SysComCmmn0600ServiceImpl.class.getName();
	 
//	@Autowired
//	@Resource(name="Cmmn0600DAO")
//    private Cmmn0600DAO cmmn0320DAO;
	
	/**
	 * 팝업형태 나 콤보 형태를 공통 rpc 로직을 호출 하여 처리 할 경우 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */ 
	public PagingLoadResult<BaseModel> getSysComPopupCmmn0600List(ServiceParameters serviceParameters) throws MSFException {

 	        PagingLoadResult<BaseModel> retval = null;
 	        String method =  CLASS_SYSCOM_ADDRLINK_DORO;
//	        Cmmn0600SrhVO   sysComCmmn0600SrhVo = new Cmmn0600SrhVO();
//	        Cmmn0600VO sysComCmmn0600Vo = new Cmmn0600VO();
//	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
//	        
//	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//	        
//	        
//	        String currentPage = req.getParameter("currentPage");
//			String countPerPage = req.getParameter("countPerPage");
//			String confmKey = req.getParameter("confmKey");
//			String keyword = req.getParameter("keyword");
//			String apiUrl = "http://www.juso.go.kr/addrlink/addrLinkApi.do?currentPage="+currentPage+"&countPerPage="+countPerPage+"&keyword="+URLEncoder.encode(keyword,"UTF-8")+"&confmKey="+confmKey;
//			URL url = new URL(apiUrl);
//	    	BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
//	    	StringBuffer sb = new StringBuffer();
//	    	String tempStr = null;
//	    	while(true){
//	    		tempStr = br.readLine();
//	    		if(tempStr == null) break;
//	    		sb.append(tempStr);	
//	    	}
//	    	br.close();
//	    	response.setCharacterEncoding("UTF-8");
//			response.setContentType("text/xml");
//			response.getWriter().write(sb.toString());
//			
//			
//			
//	        
//	        
//	        
//	        
//	        if  (MSFSharedUtils.paramNull(cmmn0320DAO)) {
//	        
//	        	WebApplicationContext wac = WebApplicationContextUtils.
//	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//	        	cmmn0320DAO = (Cmmn0600DAO) wac.getBean("Cmmn0600DAO" ); 
//	        }
//	        
//	        try {
//                //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
//	           // Sysm0100BM          user             = serviceParameters.getUser();
//	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
//	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
//	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
//	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
// 
//	            //Get paging configuration
//	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
// 
//	            /** 조건절 */ 
//	            
//	            
//	            sysComCmmn0600SrhVo.setSearchWord(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "searchWord"))); //통합검색
//	            
//	           
//	            sysComCmmn0600SrhVo.setRoadNmCtapv(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "roadNmCtapv"))); 
//	            sysComCmmn0600SrhVo.setRoadNmCtatgu(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "roadNmCtatgu"))); 
//             
//	            if ("".equals(sysComCmmn0600SrhVo.getRoadNmCtapv())) {
//	            	sysComCmmn0600SrhVo.setSearchWord("");
//	            	sysComCmmn0600SrhVo.setRoadNmCtapv("TTTT");
//	            	sysComCmmn0600SrhVo.setRoadNmCtatgu("TTTT");
//	            } 
//	            
//	            if ("01".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "valueAttribute")))) {
//	                
//	                sysComCmmn0600SrhVo.setRoadNmTat(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "roadNmTat")));
//	                sysComCmmn0600SrhVo.setRoadNmLi(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "roadNmLi")));
//	                
//	                sysComCmmn0600SrhVo.setRoadNmLtnumBobn(new BigDecimal(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "roadNmLtnumBobn"),"0"))); 
//	                 
//	            } else if ("02".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "valueAttribute")))) {
//	                 
//	                sysComCmmn0600SrhVo.setRoadNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "roadNm"))); 
//                    sysComCmmn0600SrhVo.setBuildNumBobn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "buildNumBobn"))); 
//	                
//	            } else if ("03".equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "valueAttribute")))) {
//	                sysComCmmn0600SrhVo.setBuildNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "buildNm"))); 
//	            }   else  {
//                    
//                   sysComCmmn0600SrhVo.setRoadNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "roadNm"))); 
//                   sysComCmmn0600SrhVo.setBuildNumBobn(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "buildNumBobn"))); 
//                   
//               }
//	            
//	            
//	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
// 	            if ( pagingValues.executeRecordCount ) { 
// 	            	
//	                //Execute query that returns a single value
//	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//	                 
//	                int iResultCnt = cmmn0320DAO.selectCmmn0600ListTotCnt(sysComCmmn0600SrhVo);  
//	              
//	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
//	                pagingValues.totalRecordCount = iResultCnt;	       
//	                
//	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//                }
//	        
//	            TimingInfo millisBeginSelectCmmn0600List = SmrmfUtils.startTiming(logger);
//            
//	            /**페이지 카운트 처리를 위한 부분 */ 
//	            sysComCmmn0600SrhVo.setPageSize(pagingValues.totalRecordCount);  
//	            
//	            //Apply paging
//	            if (pagingValues.start > 0) {
//	            	sysComCmmn0600SrhVo.setFirstIndex(pagingValues.start);
//	            }
//	            if (pagingValues.offsetLimit > 0) {
//	            	sysComCmmn0600SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
//	            }
//	
//	            //Execute query and convert to BaseModel list
//	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//	            
//	            @SuppressWarnings("unchecked")
////	            Collection<Map<String, Object>> list ??????
//	            List list = cmmn0320DAO.selectCmmn0600List(sysComCmmn0600SrhVo);
//                
// 	            Iterator<Map<String, Object>> iter = list.iterator();
// 	            
//	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
//	           
//	            while ( iter.hasNext() ) {
//	                Map<String, Object> map = (Map<String, Object>) iter.next();
//	                String idValue = map.get("zpcd").toString();
//	                BaseModel bm = new BaseModel();
//	
//	                //bm.setProperties(map);
//	                for ( int i=0 ; i<tableAttributes.length ; i++ ) {
//	                    
//	                    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  
//	                    Object mapCon = map.get(tableAttributes[i].getName());  
//	                     
//	                    switch ( tableAttributes[i].getType() ) {  
//	                    case ColumnDef.TYPE_DATE: 
//	                    case ColumnDef.TYPE_DATETIME: 
//	                       
//	                     Date value =  SmrmfUtils.getDateFromString(String.valueOf(mapCon),"yyyyMMdd");
//	                     map.put(tableAttributes[i].getName(), value);
//	                     
//	                       break; 
//	                       
//	                     case ColumnDef.TYPE_LONG:   
//	                     
//	                    if (mapCon != null) {  
//	                        Long  lValue =  (new BigDecimal(mapCon.toString())).longValue() ; 
//	                        map.put(tableAttributes[i].getName(), lValue); 
//	                    }  
//	                       
//	                     break;
//	                     
//	                     case ColumnDef.TYPE_DOUBLE:  
//	                     
//	                      if (mapCon != null) {      
//	                         Double dbValue = (new BigDecimal(mapCon.toString())).doubleValue(); 
//	                         map.put(tableAttributes[i].getName(), dbValue); 
//	                      }  
//	                       
//	                         break;
//	                    }
//	                     /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/    
//	                    Object baseModelValue = null;
//	                    //콤보박스처리를 위해 추가함
//	                    if (tableAttributes[i].getName().contains("$")) {
//	                         String strMapCon = tableAttributes[i].getName().replace("$", "").toLowerCase();
//	                              
//	                         map.put(tableAttributes[i].getName(),map.get(strMapCon));
//	                         
//	                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//	                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//	                    } else {
//	                         baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//	                                 map.get(tableAttributes[i].getName()), tableAttributes[i].getType());
//	                    }
//	                 /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/  
//	                     
//	                    
//	                    bm.set(tableAttributes[i].getName(), baseModelValue);
//	                }
//	
//	                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
//	                bmResult.add(bm);
//	            } 
//
//	            retval =  new BasePagingLoadResult<BaseModel>(bmResult, pagingValues.start, pagingValues.totalRecordCount);  
//	            
//                SmrmfUtils.endTiming(logger, millisBeginSelectCmmn0600List, "selectCmmn0600List");
//	       
// 
//	        }
//	        catch (Exception ex) { 
//	            //Return operation exception
//	            throw MSFServerUtils.getOperationException(method, ex, logger);
//	        }

	        return retval;
	    }

//    @Override
//    public List<BaseModel> getSysComComboRoadNmCtapv(Cmmn0600DTO sysComCmmn0600Dto) {
//        // TODO Auto-generated method stub 
//        String method =  "getSysComComboRoadNmCtapv";
//        Cmmn0600SrhVO   sysComCmmn0600SrhVo = new Cmmn0600SrhVO();
//        Cmmn0600VO sysComCmmn0600Vo = new Cmmn0600VO();
//        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
//        
//        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//        
//        if  (MSFSharedUtils.paramNull(cmmn0320DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            cmmn0320DAO = (Cmmn0600DAO) wac.getBean("Cmmn0600DAO" ); 
//        }
//        
//        try {
//          
//            /** 조건절 */
//            sysComCmmn0600SrhVo.setDpobCd(sessionUser.getDpobCd()); 
//         
//            ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
//                    new ColumnAttribute("roadNmCtapv", "roadNmCtapv", ColumnDef.TYPE_STRING )
//                   ,new ColumnAttribute("roadNmCtapvDisp", "roadNmCtapvDisp", ColumnDef.TYPE_STRING) 
//                    };
//           
//            TimingInfo millisBeginSelectCmmn0600List = SmrmfUtils.startTiming(logger);
//         
//            //Execute query and convert to BaseModel list
//            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//            
//            @SuppressWarnings("unchecked")
////          Collection<Map<String, Object>> list ??????
//            List list = cmmn0320DAO.selectCmmn0600RoadNmCtapvList(sysComCmmn0600SrhVo);
//            
//            Iterator<Map<String, Object>> iter = list.iterator();
//            
//            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
//           
//            while ( iter.hasNext() ) {
//                Map<String, Object> map = (Map<String, Object>) iter.next();
//                String idValue = map.get("roadNmCtapv").toString();
//                BaseModel bm = new BaseModel();
//
//                //bm.setProperties(map);
//                for ( int i=0 ; i<columnAttributes.length ; i++ ) {
//                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//                            map.get(columnAttributes[i].getName()), columnAttributes[i].getType());
//                    bm.set(columnAttributes[i].getName(), baseModelValue);
//                }
//
//                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
//                bmResult.add(bm);
//            }  
//            
//            SmrmfUtils.endTiming(logger, millisBeginSelectCmmn0600List, "getSysComComboRoadNmCtapv");
//       
//
//        }
//        catch (Exception ex) { 
//            //Return operation exception
//            throw MSFServerUtils.getOperationException(method, ex, logger);
//        }
//
//        return bmResult;
//    }
//
//    @Override
//    public List<BaseModel> getSysComComboRoadNmCtatgu(Cmmn0600DTO sysComCmmn0600Dto) {
//        // TODO Auto-generated method stub
//        // TODO Auto-generated method stub 
//        String method =  "getSysComComboRoadNmCtatgu";
//        Cmmn0600SrhVO   sysComCmmn0600SrhVo = new Cmmn0600SrhVO();
//        Cmmn0600VO sysComCmmn0600Vo = new Cmmn0600VO();
//        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
//        
//        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//        
//        if  (MSFSharedUtils.paramNull(cmmn0320DAO)) {
//        
//            WebApplicationContext wac = WebApplicationContextUtils.
//                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//            cmmn0320DAO = (Cmmn0600DAO) wac.getBean("Cmmn0600DAO" ); 
//        }
//        
//        try {
//          
//            /** 조건절 */ 
//            sysComCmmn0600SrhVo.setRoadNmCtapv(sysComCmmn0600Dto.getRoadNmCtapv()); 
//         
//            ColumnAttribute[] columnAttributes = new ColumnAttribute[] {
//                    new ColumnAttribute("roadNmCtatgu", "roadNmCtatgu", ColumnDef.TYPE_STRING )
//                   ,new ColumnAttribute("roadNmCtatguDisp", "roadNmCtatguDisp", ColumnDef.TYPE_STRING) 
//                    };
//           
//            TimingInfo millisBeginSelectCmmn0600List = SmrmfUtils.startTiming(logger);
//         
//            //Execute query and convert to BaseModel list
//            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//            
//            @SuppressWarnings("unchecked")
////          Collection<Map<String, Object>> list ??????
//            List list = cmmn0320DAO.selectCmmn0600RoadNmCtatguList(sysComCmmn0600SrhVo);
//            
//            Iterator<Map<String, Object>> iter = list.iterator();
//            
//            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
//           
//            while ( iter.hasNext() ) {
//                Map<String, Object> map = (Map<String, Object>) iter.next();
//                String idValue = map.get("roadNmCtatguDisp").toString();
//                BaseModel bm = new BaseModel();
//
//                //bm.setProperties(map);
//                for ( int i=0 ; i<columnAttributes.length ; i++ ) {
//                    Object baseModelValue = MSFSharedUtils.convertObjectValueToBaseModelValue(
//                            map.get(columnAttributes[i].getName()), columnAttributes[i].getType());
//                    bm.set(columnAttributes[i].getName(), baseModelValue);
//                }
//
//                bm.set(TableDef.ID_PROPERTY_NAME, idValue);
//                bmResult.add(bm);
//            }  
//            
//            SmrmfUtils.endTiming(logger, millisBeginSelectCmmn0600List, "getSysComComboRoadNmCtatgu");
//       
//
//        }
//        catch (Exception ex) { 
//            //Return operation exception
//            throw MSFServerUtils.getOperationException(method, ex, logger);
//        }
//
//        return bmResult;
//    }
}
