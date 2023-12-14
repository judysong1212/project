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
package com.app.exterms.statistics.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.app.exterms.statistics.client.service.Stts0200Service;
import com.app.exterms.statistics.shared.SttsDaoConstants;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;


/**
 * 
* <pre>
* 1. 패키지명 : com.app.exterms.yearendtax.server.service
* 2. 타입명 : Yeta0200ServiceImpl.java
* 3. 작성일 : Jan 13, 2016 5:12:39 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Service("Stts0200Service")
public class Stts0200ServiceImpl  extends AbstractCustomServiceImpl implements Stts0200Service  ,SttsDaoConstants {

	// private  static final Logger LOGGER = LoggerFactory.getLogger(Yeta0100ServiceImpl.class);
	// private static final String calledClass = Yeta0100ServiceImpl.class.getName();
	  private static final Logger logger = LoggerFactory.getLogger(Stts0200ServiceImpl.class);
	  private static final String calledClass = Stts0200ServiceImpl.class.getName();
	  

//	    @Autowired
//	    @Resource(name="Yeta1000DAO")
//	    private Yeta1000DAO yeta1000DAO;  
//	  
//	    @Autowired
//	    @Resource(name="Yeta2000DAO")
//	    private Yeta2000DAO yeta2000DAO;  
//	  
//	   @Autowired
//	    @Resource(name="Yeta3000DAO")
//	    private Yeta3000DAO yeta3000DAO;  
//	  
//	   @Autowired
//	    @Resource(name="Yeta3100DAO")
//	    private Yeta3100DAO yeta3100DAO;  
//	  
//	   @Autowired
//	    @Resource(name="Yeta3110DAO")
//	    private Yeta3110DAO yeta3110DAO;  
//	  
//	   @Autowired
//	    @Resource(name="Yeta3120DAO")
//	    private Yeta3120DAO yeta3120DAO;  
//	  
//	   @Autowired
//	    @Resource(name="Yeta3130DAO")
//	    private Yeta3130DAO yeta3130DAO;  
//	  
//	   @Autowired
//	    @Resource(name="Yeta3140DAO")
//	    private Yeta3140DAO yeta3140DAO;  
//	  
//	   @Autowired
//	    @Resource(name="Yeta3150DAO")
//	    private Yeta3150DAO yeta3150DAO;   
//	  
//	    @Autowired
//	    @Resource(name="Yeta3160DAO")
//	    private Yeta3160DAO yeta3160DAO;  
//	    
//	    @Autowired
//	    @Resource(name="Yeta3170DAO")
//	    private Yeta3170DAO yeta3170DAO;  
//	    
//	    @Autowired
//	    @Resource(name="Yeta3180DAO")
//	    private Yeta3180DAO yeta3180DAO;  
//	    
//	    @Autowired
//	    @Resource(name="Yeta3190DAO")
//	    private Yeta3190DAO yeta3190DAO;  
//	    
//	    @Autowired
//	    @Resource(name="Yeta3200DAO")
//	    private Yeta3200DAO yeta3200DAO;  
//	    
//	    @Autowired
//	    @Resource(name="Yeta3210DAO")
//	    private Yeta3210DAO yeta3210DAO;  
//	    
//	    @Autowired
//	    @Resource(name="Yeta3220DAO")
//	    private Yeta3220DAO yeta3220DAO;  
//	    
//	    @Autowired
//	    @Resource(name="Yeta3300DAO")
//	    private Yeta3300DAO yeta3300DAO;  
//	    
//	 
//	    /**
//	     * 
//	     * <pre>
//	     * 1. 개요 : 연말정산 업로드 대상자 리스트  
//	     * 2. 처리내용 : 
//	     * </pre>
//	     * @Method Name : getYeta0200ToYeta2000List
//	     * @date : Jan 26, 2016
//	     * @author : leeheuisung
//	     * @history : 
//	     *	-----------------------------------------------------------------------
//	     *	변경일				작성자						변경내용  
//	     *	----------- ------------------- ---------------------------------------
//	     *	Jan 26, 2016		leeheuisung				최초 작성 
//	     *	-----------------------------------------------------------------------
//	     * 
//	     * @param serviceParameters
//	     * @return
//	     * @throws MSFException
//	     */
//	    public PagingLoadResult<BaseModel> getYeta0200ToYeta2000List(ServiceParameters serviceParameters) throws MSFException {
//
//	        PagingLoadResult<BaseModel> retval = null;
//	        String method =  CLASS_YETA0200ToYETA2000_LIST;
//	        Yeta2000SrhVO   yeta2000SrhVo = new Yeta2000SrhVO();
//	        Yeta2000VO      yeta2000Vo = new Yeta2000VO();
//	        List<BaseModel>  bmResult = new ArrayList<BaseModel>();
//	        
//	        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//	        
//	        if  (MSFSharedUtils.paramNull(yeta2000DAO)) {
//	        
//	            WebApplicationContext wac = WebApplicationContextUtils.
//	                    getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
//
//	            yeta2000DAO = (Yeta2000DAO) wac.getBean("Yeta2000DAO"); 
//	        }
//	        
//	        try {
//	            //TODO 유우저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
//	           // Sysm0400BM          user             = serviceParameters.getUser();
//	            ColumnAttribute[] tableAttributes  = serviceParameters.getTableAttributes();
//	            IColumnFilter     columnFilters    = serviceParameters.getColumnFilters();
//	            List<ColumnOrder> columnOrders     = serviceParameters.getColumnOrders();
//	            PagingLoadConfig  pagingLoadConfig = serviceParameters.getPagingLoadConfig();
//
//	            //Get paging configuration
//	            PagingValues pagingValues = MSFServerUtils.getPagingValues(pagingLoadConfig, columnOrders);
//
//	            //Get query parameters
//	            //String strCriteriaValue = String.valueOf(MSFServerUtils.getFilterValue(columnFilters, "rpsttvCd"));
//	              
//	            List<String> listDeptCd = new ArrayList<String>();
//	            /** 조건절 */
//	            yeta2000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//	            yeta2000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	            yeta2000SrhVo.setUsrId(sessionUser.getUsrId());  
//	              
//	            
//	            /******************************** 권한 ************************************************************************/
//	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//	            if ("FALSE".equals(chkDeptCd)) {
//	            	yeta2000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
//	               listDeptCd.add(sessionUser.getDeptCd());
//	               yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
//	               yeta2000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//	            } else {
//	            	    
//	            	 yeta2000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드
//	                     if (yeta2000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
//	                     	 listDeptCd = null; 
//	                     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	                     	yeta2000SrhVo.setDeptCd("");  //부서코드
//	                     } else {
//	                    	 yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
//	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	                          yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
//	                     } 
//	                  
//	            }
//	            
//	            yeta2000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
//	            yeta2000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));      
////	            String chkTypOccuCd = sessionUser.getAuthCheck().getAuthCheck04();
////	            if ("FALSE".equals(chkTypOccuCd)) {
////	            	//sysComSrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd());
////	            	//sysComSrhVo.setUsrId(sessionUser.getUsrId());
////	            } else {
////	            	
////	            }
//	            
//	           /******************************** 권한 ************************************************************************/
//	            
//	      
//	            
//	            yeta2000SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //연말정산년
//	            yeta2000SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd")));  //연말정산구분코드  
//	            
//	           
//	            yeta2000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
//	            
//	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
//	            yeta2000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
//	            yeta2000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//	           
////	            List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
////	            yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
////	            yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//	             
//	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
//	            yeta2000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//	            yeta2000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세 
//	            
//	            yeta2000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드 
//	          
//	            yeta2000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
//	            yeta2000SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명
//	            
////	            String strHdofcCodtnCd = MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd"));
////	            
////	            List<String> listHdofcCodtnCd = new ArrayList<String>(); 
////	           
////	            String[] ray = strHdofcCodtnCd.substring(0, strHdofcCodtnCd.length()).split(",");
////	            
////	            for (int i=0; i<ray.length; i++){ 
////	                listHdofcCodtnCd.add(ray[i]);
////	            } 
////	            yeta2000SrhVo.setHdofcCodtnCdArr(listHdofcCodtnCd);    //재직상
////	            yeta2000SrhVo.setHdofcCodtnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hdofcCodtnCd")));    //재직상
//	            
//	            
//	            //Get total record count //전체 데이터 갯수를 가지고 온다. 
//	             if ( pagingValues.executeRecordCount ) { 
//	                    
//	                //Execute query that returns a single value
//	                TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//	                 
//	                int iResultCnt = yeta2000DAO.selectYeta0200ToYeta2000ListTotCnt(yeta2000SrhVo);  
//	                if (!pagingValues.pageExecute) { 
//	                    pagingValues.offsetLimit = iResultCnt;       
//	                }
//	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
//	                pagingValues.totalRecordCount = iResultCnt;        
//	                
//	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//	            }
//	        
//	            TimingInfo millisBeginYeta0200ToYeta2000DataList = SmrmfUtils.startTiming(logger);
//	        
//	            /**페이지 카운트 처리를 위한 부분 */ 
//	            yeta2000SrhVo.setPageSize(pagingValues.totalRecordCount);  
//	            
//	            //Apply paging
//	            if (pagingValues.start > 0) {
//	                yeta2000SrhVo.setFirstIndex(pagingValues.start);
//	            }
//	            if (pagingValues.offsetLimit > 0) {
//	                yeta2000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount)); 
//	            }
//
//	            //Execute query and convert to BaseModel list
//	            TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//	            
//	            @SuppressWarnings("unchecked")
////	            Collection<Map<String, Object>> list  
//	            List list = yeta2000DAO.selectYeta0200ToYeta2000List(yeta2000SrhVo);
//	            
//	            Iterator<Map<String, Object>> iter = list.iterator();
//	                
//	            SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
//	           
//	        
//	            while ( iter.hasNext() ) {
//	                Map<String, Object> map = (Map<String, Object>) iter.next();
//	                String idValue = map.get("systemkey").toString();
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
//	            SmrmfUtils.endTiming(logger, millisBeginYeta0200ToYeta2000DataList, "getYeta0200ToYeta2000DataList");
//	       
//
//	        }
//	        catch (Exception ex) {
//	            ex.printStackTrace();
//	            //Return operation exception
//	            throw MSFServerUtils.getOperationException(method, ex, logger);
//	        }
//
//	        return retval;
//	    } 
	  
	  
	  
 
}  
