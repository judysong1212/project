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

import com.app.exterms.statistics.client.service.Stts0100Service;
import com.app.exterms.statistics.shared.SttsDaoConstants;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;

/**
 * 
* <pre>
* 1. 패키지명 : com.app.exterms.yearendtax.server.service
* 2. 타입명 : Stts0100ServiceImpl.java
* 3. 작성일 : Jan 13, 2016 5:12:49 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Service("Stts0100Service")
public class Stts0100ServiceImpl  extends AbstractCustomServiceImpl implements Stts0100Service  ,SttsDaoConstants {

	// private  static final Logger LOGGER = LoggerFactory.getLogger(Stts0100ServiceImpl.class);
	// private static final String calledClass = Stts0100ServiceImpl.class.getName();
	  private static final Logger logger = LoggerFactory.getLogger(Stts0100ServiceImpl.class);
	  private static final String calledClass = Stts0100ServiceImpl.class.getName();
     
	  
//	    @Autowired
//	    @Resource(name="Stts1000DAO")
//	    private Stts1000DAO yeta1000DAO;  
//	  
//	    @Autowired
//	    @Resource(name="Stts2000DAO")
//	    private Stts2000DAO yeta2000DAO;  
//	  
//	   @Autowired
//	    @Resource(name="Stts3000DAO")
//	    private Stts3000DAO yeta3000DAO;  
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
//	  /** 
//	     * 정산계산 대상자 조회
//	     * @param serviceParameters
//	     * @return
//	     * @throws MSFException
//	     */
//	    public PagingLoadResult<BaseModel> getYeta0100ToYeta2000List(ServiceParameters serviceParameters) throws MSFException {
//
// 	        PagingLoadResult<BaseModel> retval = null;
//	        String method =  "getPsnl0100ToRemt0100DataList";
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
//	            yeta2000DAO = (Yeta2000DAO) wac.getBean("Yeta2000DAO" ); 
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
//	                int iResultCnt = yeta2000DAO.selectYeta0100ToYeta2000ListTotCnt(yeta2000SrhVo);  
//	                if (!pagingValues.pageExecute) { 
//	                    pagingValues.offsetLimit = iResultCnt;       
//	                }
//	                SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount"); 
//	                pagingValues.totalRecordCount = iResultCnt;        
//	                
//	                logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//	            }
//	        
//	            TimingInfo millisBeginPsnl0100ToRemt0100DataList = SmrmfUtils.startTiming(logger);
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
//	            List list = yeta2000DAO.selectYeta0100ToYeta2000List(yeta2000SrhVo);
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
//	            SmrmfUtils.endTiming(logger, millisBeginPsnl0100ToRemt0100DataList, "getPsnl0100ToRemt0100DataList");
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
//	    
//	    /**
//	     * 
//	     * <pre>
//	     * 1. 개요 : 연말정산 대상자 삭제  
//	     * 2. 처리내용 : 선택된 연말정산 대상자를 삭제한다.
//	     * </pre>
//	     * @Method Name : Payr06420_Payr400_Delete
//	     * @date : Jan 18, 2016
//	     * @author : leeheuisung
//	     * @history : 
//	     *	-----------------------------------------------------------------------
//	     *	변경일				작성자						변경내용  
//	     *	----------- ------------------- ---------------------------------------
//	     *	Jan 18, 2016		leeheuisung				최초 작성 
//	     *	-----------------------------------------------------------------------
//	     * 
//	     * @return
//	     */
//	    @Override
//	    public  Long Payr06420_Payr400_Delete(List<Yeta2000DTO> listYeta2000Dto) throws MSFException {
//   	    	 
//	    	 
//	    	    Long retval = 0L;
//	    	    BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  
//	    	      Yeta3120VO yeta3120Vo = new Yeta3120VO();  //거주자주택자금_금전소비대차  
//		          Yeta3160VO yeta3160Vo = new Yeta3160VO();  //거주자주택자금_임대차  
//		          Yeta3100VO yeta3100Vo = new Yeta3100VO();  //연금_저축공제
//		          Yeta3130VO yeta3130Vo = new Yeta3130VO();  //주택자금_월세
//		          Yeta3140VO yeta3140Vo = new Yeta3140VO();  //의료비
//	        	  Yeta3180VO yeta3180Vo = new Yeta3180VO();  //기부금 명세 
//	        	  Yeta3170VO yeta3170Vo = new Yeta3170VO();  //이월기부금명세
//	        	  Yeta3190VO yeta3190Vo = new Yeta3190VO();  //이월기부금temp
//	        	  Yeta3110VO yeta3110Vo = new Yeta3110VO();  //종전근무지명세 
//	        	  Yeta3200VO yeta3200Vo = new Yeta3200VO();  //비과세감면소득  
//	        	  Yeta3220VO yeta3220Vo = new Yeta3220VO();  //가족사항  
//	        	  Yeta3150VO yeta3150Vo = new Yeta3150VO();  //교육비
//	        	  Yeta3210VO yeta3210Vo = new Yeta3210VO();  //급여내역
//	        	  Yeta3300VO yeta3300Vo = new Yeta3300VO();  //비과세감면소득정산  
//	        	  Yeta3000VO yeta3000Vo = new Yeta3000VO();  //연말정산결과  
//	        	
//			   
//		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//		        System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
//		        try {   
//              
//		        	 
//		        	  for(int iCnt=0;iCnt < listYeta2000Dto.size();iCnt++) {
//			            	 
//			                
//		        		  Yeta2000DTO yeta2000Dto = new Yeta2000DTO();  //연말정산기본  ;  
//		                  Yeta2000VO yeta2000Vo = new Yeta2000VO();  //연말정산기본  
//		                  yeta2000Dto = listYeta2000Dto.get(iCnt); 
//		                	 
//		        	    //  BeanUtils.copyProperties(yeta2000Vo, yeta2000Dto);   
//					  
//		                   yeta2000Vo.setDpobCd(yeta2000Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
//							yeta2000Vo.setEdacRvyy(yeta2000Dto.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//							yeta2000Vo.setSettGbcd(yeta2000Dto.getSettGbcd());    /** column 정산구분코드 : settGbcd */
//							yeta2000Vo.setSystemkey(yeta2000Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
//							yeta2000Vo.setEdacSeilNum(new BigDecimal(yeta2000Dto.getEdacSeilNum()));    /** column 연말정산마감일련번호 : edacSeilNum */
//							yeta2000Vo.setPayrMangDeptCd(yeta2000Dto.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
//							yeta2000Vo.setEmymtDivCd(yeta2000Dto.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
//							yeta2000Vo.setHanNm(yeta2000Dto.getHanNm());    /** column 한글성명 : hanNm */
//							yeta2000Vo.setResnRegnNum(yeta2000Dto.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
//							yeta2000Vo.setDeptCd(yeta2000Dto.getDeptCd());    /** column 부서코드 : deptCd */
//							yeta2000Vo.setBusinCd(yeta2000Dto.getBusinCd());    /** column 사업코드 : businCd */
//							yeta2000Vo.setTypOccuCd(yeta2000Dto.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//							yeta2000Vo.setDtilOccuInttnCd(yeta2000Dto.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
//							yeta2000Vo.setDtilOccuClsDivCd(yeta2000Dto.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
//							yeta2000Vo.setOdtyCd(yeta2000Dto.getOdtyCd());    /** column 직책코드 : odtyCd */
//							yeta2000Vo.setPyspCd(yeta2000Dto.getPyspCd());    /** column 호봉코드 : pyspCd */
//							yeta2000Vo.setPyspGrdeCd(yeta2000Dto.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//							yeta2000Vo.setLogSvcYrNumCd(yeta2000Dto.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
//							yeta2000Vo.setLogSvcMnthIcmCd(yeta2000Dto.getLogSvcMnthIcmCd());    /** column 근속월수코드 : logSvcMnthIcmCd */
//							yeta2000Vo.setFrstEmymtDt(yeta2000Dto.getFrstEmymtDt());    /** column 최초고용일자 : frstEmymtDt */
//							yeta2000Vo.setEmymtBgnnDt(yeta2000Dto.getEmymtBgnnDt());    /** column 고용시작일자 : emymtBgnnDt */
//							yeta2000Vo.setEmymtEndDt(yeta2000Dto.getEmymtEndDt());    /** column 고용종료일자 : emymtEndDt */
//							yeta2000Vo.setHdofcDivCd(yeta2000Dto.getHdofcDivCd());    /** column 재직구분코드 : hdofcDivCd */
//							yeta2000Vo.setRetryDt(yeta2000Dto.getRetryDt());    /** column 퇴직일자 : retryDt */
//							yeta2000Vo.setYrtxApptnYrMnth(yeta2000Dto.getYrtxApptnYrMnth());    /** column 연말정산적용년월 : yrtxApptnYrMnth */
//							yeta2000Vo.setYrtxPrcsDt(yeta2000Dto.getYrtxPrcsDt());    /** column 연말정산처리일자 : yrtxPrcsDt */
////							yeta2000Vo.setYrtxPrcsYn(yeta2000Dto.getYrtxPrcsYn());    /** column 연말정산처리여부 : yrtxPrcsYn */
//							yeta2000Vo.setYrtxPrcsYn((Boolean.TRUE.equals(yeta2000Dto.getYrtxPrcsYn()) ? "Y" : "N"));    /** column 연말정산처리여부 : yrtxPrcsYn */
//							
//							
//							yeta2000Vo.setDivdPymtDivCd(yeta2000Dto.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
//							
//						  BeanUtils.copyProperties(yeta3120Vo, yeta2000Vo);  
//						  BeanUtils.copyProperties(yeta3160Vo, yeta2000Vo);  
//						  BeanUtils.copyProperties(yeta3100Vo, yeta2000Vo);  
//						  BeanUtils.copyProperties(yeta3130Vo, yeta2000Vo); 
//						  BeanUtils.copyProperties(yeta3170Vo, yeta2000Vo);  
//						  BeanUtils.copyProperties(yeta3190Vo, yeta2000Vo);  
//						  
//						  
//						  BeanUtils.copyProperties(yeta3140Vo, yeta2000Vo);  
//						  BeanUtils.copyProperties(yeta3180Vo, yeta2000Vo);   
//						  BeanUtils.copyProperties(yeta3110Vo, yeta2000Vo);  
//						  BeanUtils.copyProperties(yeta3200Vo, yeta2000Vo);  
//						  BeanUtils.copyProperties(yeta3220Vo, yeta2000Vo);  
//						  BeanUtils.copyProperties(yeta3150Vo, yeta2000Vo);  
//						  BeanUtils.copyProperties(yeta3210Vo, yeta2000Vo);  
//						  BeanUtils.copyProperties(yeta3300Vo, yeta2000Vo);  
//						  BeanUtils.copyProperties(yeta3000Vo, yeta2000Vo);  
//						  
//					  //  {-- 삭제처리 --} 
//						    
//	
//	                    //{의료비삭제} 
//	                    yeta3140DAO.fnPayr06430_PAYR430_CREATE_Delete(yeta3140Vo);//yeta3140 
//	                   
//	                    //{종전근무지삭제}
//	                    yeta3110DAO.fnPayr06430_PAYR435_CREATE_Delete(yeta3110Vo);//yeta3110  종전근무지명세   
//	                  
//	                    // {거주자주택자금_금전소비대차 삭제} 
//			            yeta3120DAO.fnPayr06430_PAYR450_CREATE_Delete(yeta3120Vo);//yeta3120  거주자주택자금_금전소비대차  
//			             
//			          //  {거주자주택자금_임대차 삭제}
//			            yeta3160DAO.fnPayr06430_PAYR451_CREATE_Delete(yeta3160Vo);//yeta3160  거주자주택자금_임대차 
//			           
//			           // {연금_저축공제 삭제}
//			            yeta3100DAO.fnPayr06430_PAYR418_CREATE_Delete(yeta3100Vo);//yeta3100  연금_저축공제
//			            
//			           // {주택자금_월세 삭제}
//			            yeta3130DAO.fnPayr06430_PAYR452_CREATE_Delete(yeta3130Vo);//yeta3130  주택자금_월세
//			             
//
//			           // {이월기부금삭제}
//			            yeta3190DAO.fnPayr06430_PAYR443_CREATE_Delete(yeta3190Vo);//yeta3190 이월기부금삭제  
//
//			            //{이월기부금삭제}  
//			            yeta3170DAO.fnPayr06430_PAYR442_CREATE_Delete(yeta3170Vo);//yeta3170 이월기부금삭제  
//			      		
//	                    //{기부금삭제}
//	                    yeta3180DAO.fnPayr06430_PAYR440_CREATE_Delete(yeta3180Vo);//yeta3180 기부금명세  
//	                      
//			            
//	                    //{가족사항삭제}
//			  			yeta3220DAO.fnPayr06430_PAYR410_CREATE_Delete(yeta3220Vo);//yeta3220 가족사항   
//	
//			          //{교육비가족사항삭제}
//			            yeta3150DAO.fnPayr06430_PAYR445_CREATE_Delete(yeta3150Vo);//yeta3150 교육사항    
//			  
//			            //[비과세감면내역 삭제 ]
//	  		            yeta3200DAO.fnPayr06430_Yeta3200_CREATE_Delete(yeta3200Vo);//yeta3200  비과세감면소득   	
//	  		            
//	                    //{급여내역삭제}
//		  				yeta3210DAO.fnPayr06420_PAYR417_CREATE_Delete(yeta3210Vo);//yeta3210 급여내역 삭제   
//		  
//		  
//		    		  //{비과세감면 정산 삭제 }
//		               yeta3300DAO.fnPayr06430_Yeta3300_CREATE_Delete(yeta3300Vo);//yeta3300  비과세감면소득정산   	 
//	                  // {연말정산상세삭제}
//		               yeta3000DAO.fnPayr06430_PAYR425_CREATE_Delete(yeta3000Vo);//yeta3000    
//		  
//		  
//			    	 
//		  
//	                  //{연말정산기본삭제}
//		  			   yeta2000DAO.fnPayr06420_PAYR415_CREATE_Delete(yeta2000Vo);//yeta2000  연말정산기본  
//		  			   
//		  			   
//		        	  }	  			    
//					   retval = 1L;
//		        }
//		        catch (Exception ex) {
//		        	 
//		            logger.error("EXCEPTION calling Payr06420_Payr400_Delete(): "+ex); 
//		            retval = 0L;
//		            throw MSFServerUtils.getOperationException("Payr06420_Payr400_Delete", ex, logger);
//		        } 
//		        
//		        return retval;
//		        
//	        	
//			        
//	    }
//	    
//	   /**
//	    * 
//	    * <pre>
//	    * 1. 개요 : 연말정산 생성시 삭제처리 하는 로직  
//	    * 2. 처리내용 : 
//	    * </pre>
//	    * @Method Name : Payr06420_All_Delete
//	    * @date : Jan 18, 2016
//	    * @author : leeheuisung
//	    * @history : 
//	    *	-----------------------------------------------------------------------
//	    *	변경일				작성자						변경내용  
//	    *	----------- ------------------- ---------------------------------------
//	    *	Jan 18, 2016		leeheuisung				최초 작성 
//	    *	-----------------------------------------------------------------------
//	    * 
//	    * @return
//	    * @throws MSFException
//	    */
//	    private  Long Payr06420_All_Delete(Yeta1000DTO yeta1000Dto) throws MSFException {
//	    	  
//        	  Long retval = 1L;
//	    	  
//        	  Yeta1000VO yeta1000Vo = new Yeta1000VO();  //마감테이블    
//	          Yeta2000VO yeta2000Vo = new Yeta2000VO();  //연말정산기본  
//	          BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);   	
//				   
//			  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//			       
//			  System.out.println("삭제자 : " + sessionUser.getDeptNm() + "[" + sessionUser.getUsrNm() + "]");
//			  try {    
//				  
//			 // BeanUtils.copyProperties(yeta1000Vo, yeta1000Dto);  
//
//				yeta1000Vo.setDpobCd(yeta1000Dto.getDpobCd());    /** column null : dpobCd */
//				yeta1000Vo.setEdacRvyy(yeta1000Dto.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//				yeta1000Vo.setSettGbcd(yeta1000Dto.getSettGbcd());    /** column 정산구분코드 : settGbcd */
//				yeta1000Vo.setEdacSeilNum(new BigDecimal(yeta1000Dto.getEdacSeilNum()));    /** column 연말정산마감일련번호 : edacSeilNum */
//				yeta1000Vo.setPayrMangDeptCd(yeta1000Dto.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
//				yeta1000Vo.setDeptCd(yeta1000Dto.getDeptCd());    /** column 부서코드 : deptCd */
//				yeta1000Vo.setTypOccuCd(yeta1000Dto.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//				yeta1000Vo.setDtilOccuClsDivCd(yeta1000Dto.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
//				yeta1000Vo.setPyspGrdeCd(yeta1000Dto.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//				yeta1000Vo.setDtilOccuInttnCd(yeta1000Dto.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
//				yeta1000Vo.setBusinCd(yeta1000Dto.getBusinCd());    /** column 사업코드 : businCd */
//				yeta1000Vo.setEmymtDivCd(yeta1000Dto.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
//				yeta1000Vo.setPernChrgEmpIdenNum(yeta1000Dto.getPernChrgEmpIdenNum());    /** column 생성직원번호 : pernChrgEmpIdenNum */
//				yeta1000Vo.setClosFlag(yeta1000Dto.getClosFlag());    /** column 마감여부 : closFlag */
//				yeta1000Vo.setClosCont(new BigDecimal(MSFSharedUtils.defaultNulls(yeta1000Dto.getClosCont(),"0")));    /** column 마감건수 : closCont */
//				yeta1000Vo.setClosDate(yeta1000Dto.getClosDate());    /** column 마감일자 : closDate */
//				yeta1000Vo.setEdacPrdt(yeta1000Dto.getEdacPrdt());    /** column 연말정산제출일자 : edacPrdt */
//				yeta1000Vo.setReprName(yeta1000Dto.getReprName());    /** column 대표자성명 : reprName */
//				yeta1000Vo.setJuriName(yeta1000Dto.getJuriName());    /** column 법인명_상호 : juriName */
//				yeta1000Vo.setBusiNumb(yeta1000Dto.getBusiNumb());    /** column 사업자등록번호 : busiNumb */
//				yeta1000Vo.setResuNumb(yeta1000Dto.getResuNumb());    /** column 주민등록번호 : resuNumb */
//				yeta1000Vo.setJuriNumb(yeta1000Dto.getJuriNumb());    /** column 법인번호 : juriNumb */
//				yeta1000Vo.setIncmPost(yeta1000Dto.getIncmPost());    /** column 소득신고의무자우편번호 : incmPost */
//				yeta1000Vo.setIncmAddr(yeta1000Dto.getIncmAddr());    /** column 소득신고의무자기본주소 : incmAddr */
//				yeta1000Vo.setIncmAdtl(yeta1000Dto.getIncmAdtl());    /** column 소득신고의무자상세주소 : incmAdtl */
//				yeta1000Vo.setTaxaCode(yeta1000Dto.getTaxaCode());    /** column 관할세무서코드 : taxaCode */
//				yeta1000Vo.setIncmGbcd(yeta1000Dto.getIncmGbcd());    /** column 제출자구분코드 : incmGbcd */
//				yeta1000Vo.setTaxaDnum(yeta1000Dto.getTaxaDnum());    /** column 세무대리인번호 : taxaDnum */
//				yeta1000Vo.setHomeTxid(yeta1000Dto.getHomeTxid());    /** column 홈텍스ID : homeTxid */
//				yeta1000Vo.setTaxaPrcd(yeta1000Dto.getTaxaPrcd());    /** column 세무프로그램코드 : taxaPrcd */
//				yeta1000Vo.setCharDept(yeta1000Dto.getCharDept());    /** column 담당자부서명 : charDept */
//				yeta1000Vo.setCharName(yeta1000Dto.getCharName());    /** column 담당자성명 : charName */
//				yeta1000Vo.setCharTele(yeta1000Dto.getCharTele());    /** column 담당자전화번호 : charTele */
//				yeta1000Vo.setFilePass(yeta1000Dto.getFilePass());    /** column FILE_PASS : filePass */
// 	
//				  
//			  // 1000번삭제전 일련번호 가지고와서 대상 데이타를 전부 삭제한다.  
//				yeta2000Vo.setDpobCd(yeta1000Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
//				yeta2000Vo.setEdacRvyy(yeta1000Dto.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//				yeta2000Vo.setSettGbcd(yeta1000Dto.getSettGbcd());    /** column 정산구분코드 : settGbcd */
//				yeta2000Vo.setSystemkey(yeta1000Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
//				yeta2000Vo.setEdacSeilNum(new BigDecimal(yeta1000Dto.getEdacSeilNum()));    /** column 연말정산마감일련번호 : edacSeilNum */
//				yeta2000Vo.setPayrMangDeptCd(yeta1000Dto.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
//				yeta2000Vo.setEmymtDivCd(yeta1000Dto.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
//				 
//				yeta2000Vo.setDeptCd(yeta1000Dto.getDeptCd());    /** column 부서코드 : deptCd */
//				yeta2000Vo.setBusinCd(yeta1000Dto.getBusinCd());    /** column 사업코드 : businCd */
//				yeta2000Vo.setTypOccuCd(yeta1000Dto.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//				yeta2000Vo.setDtilOccuInttnCd(yeta1000Dto.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
//				yeta2000Vo.setDtilOccuClsDivCd(yeta1000Dto.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
//			 
//				yeta2000Vo.setPyspGrdeCd(yeta1000Dto.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//				  
//			 
//			  Yeta2000SrhVO  yeta2000SrhVo = new Yeta2000SrhVO();
//			  
//			  
//			  yeta2000SrhVo.setDpobCd(yeta2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
//			  yeta2000SrhVo.setEdacRvyy(yeta2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//			  yeta2000SrhVo.setSettGbcd(yeta2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */  
//			 
//			  
//			  List<String> listDeptCd = new ArrayList<String>();
//	            /** 조건절 */
//	            yeta2000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//	            yeta2000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	            yeta2000SrhVo.setUsrId(sessionUser.getUsrId());   
//	            
// 	            yeta2000SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta2000Vo.getEdacRvyy())); //연말정산년
//	            yeta2000SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(yeta2000Vo.getSettGbcd()));  //연말정산구분코드  
//	            
//                yeta2000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(yeta2000Vo.getEmymtDivCd()));       //고용구분코드
//	            
//	            
//	            /******************************** 권한 ************************************************************************/
//	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//	            if ("FALSE".equals(chkDeptCd)) {
//	               yeta2000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
//	               listDeptCd.add(sessionUser.getDeptCd());
//	               yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
//	               yeta2000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//	            } else {
//	            	    
//	            	     yeta2000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(yeta2000Vo.getPayrMangDeptCd())) ;   //단위기관코드
//	                     if (yeta2000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yeta2000Vo.getDeptCd()))) { 
//	                     	 listDeptCd = null; 
//	                     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	                     	yeta2000SrhVo.setDeptCd("");  //부서코드
//	                     } else {
//	                    	 yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(yeta2000Vo.getDeptCd()));
//	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta2000Vo.getDeptCd()));  
//	                          yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
//	                     } 
//	                  
//	            }
//	            
//	            yeta2000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(yeta2000Vo.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
//	            yeta2000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yeta2000Vo.getDtilOccuInttnCd()).replace(",", ""));      
// 
//	            
//	           /******************************** 권한 ************************************************************************/ 
//	      
//	            List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta2000Vo.getTypOccuCd())); 
//	            yeta2000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
//	            yeta2000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(yeta2000Vo.getTypOccuCd()));  //직종
// 
//	            List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta2000Vo.getDtilOccuInttnCd())); 
//	            yeta2000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//	            yeta2000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(yeta2000Vo.getDtilOccuInttnCd())); //직종세 
//	            
//	            yeta2000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(yeta2000Vo.getBusinCd()));   //사업코드 
//	          
//	            yeta2000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(yeta2000Vo.getSystemkey()));  //시스템키 
//			  
//			  List lstYeta2000Vo = yeta2000DAO.fnPayr06430_PAYR450_DelSelect(yeta2000SrhVo);
//			  
//			  if  (lstYeta2000Vo.size() > 0) {
//
//               Iterator<Map<String, Object>> iter = lstYeta2000Vo.iterator(); 
//  	        	   
//  		          while ( iter.hasNext() ) { 
//  		            	
//	  		           Map<String, Object> mapYeta2000Vo = (Map<String, Object>) iter.next(); 
//	  		           Yeta2000VO tpYeta2000Vo = new Yeta2000VO();  //연말정산기본
//	  		           
//	  		           tpYeta2000Vo.setDpobCd(MSFSharedUtils.allowNulls(mapYeta2000Vo.get("dpobCd")));    /** column 사업장코드 : dpobCd */
//	  		           tpYeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(mapYeta2000Vo.get("edacRvyy")));    /** column 연말정산귀속년도 : edacRvyy */
//	  		           tpYeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(mapYeta2000Vo.get("settGbcd")));    /** column 정산구분코드 : settGbcd */  
//	  		           tpYeta2000Vo.setSystemkey(MSFSharedUtils.allowNulls(mapYeta2000Vo.get("systemkey")));    /** column SYSTEMKEY : systemkey */ 
//	  		           tpYeta2000Vo.setEdacSeilNum(new BigDecimal(MSFSharedUtils.defaultNulls(mapYeta2000Vo.get("edacSeilNum"),"0")));    /** column edacSeilNum : edacSeilNum */ 
//	  				   
//				  
//					  Yeta3120VO yeta3120Vo = new Yeta3120VO();  //거주자주택자금_금전소비대차  
//			          Yeta3160VO yeta3160Vo = new Yeta3160VO();  //거주자주택자금_임대차  
//			          Yeta3100VO yeta3100Vo = new Yeta3100VO();  //연금_저축공제
//			          Yeta3130VO yeta3130Vo = new Yeta3130VO();  //주택자금_월세
//			          Yeta3140VO yeta3140Vo = new Yeta3140VO();  //의료비
//		        	  Yeta3180VO yeta3180Vo = new Yeta3180VO();  //기부금 명세 
//		        	  Yeta3170VO yeta3170Vo = new Yeta3170VO();  //이월기부금명세
//		        	  Yeta3190VO yeta3190Vo = new Yeta3190VO();  //이월기부금temp
//		        	  Yeta3110VO yeta3110Vo = new Yeta3110VO();  //종전근무지명세 
//		        	  Yeta3200VO yeta3200Vo = new Yeta3200VO();  //비과세감면소득  
//		        	  Yeta3220VO yeta3220Vo = new Yeta3220VO();  //가족사항  
//		        	  Yeta3150VO yeta3150Vo = new Yeta3150VO();  //교육비
//		        	  Yeta3210VO yeta3210Vo = new Yeta3210VO();  //급여내역
//		        	  Yeta3300VO yeta3300Vo = new Yeta3300VO();  //비과세감면소득정산  
//		        	  Yeta3000VO yeta3000Vo = new Yeta3000VO();  //연말정산결과  
//				  
//				
//				  
//					  BeanUtils.copyProperties(yeta3120Vo, tpYeta2000Vo);  
//					  BeanUtils.copyProperties(yeta3160Vo, tpYeta2000Vo);  
//					  BeanUtils.copyProperties(yeta3100Vo, tpYeta2000Vo);  
//					  BeanUtils.copyProperties(yeta3130Vo, tpYeta2000Vo);  
//					  BeanUtils.copyProperties(yeta3140Vo, tpYeta2000Vo);  
//					  BeanUtils.copyProperties(yeta3180Vo, tpYeta2000Vo);  
//					  BeanUtils.copyProperties(yeta3170Vo, tpYeta2000Vo);  
//					  BeanUtils.copyProperties(yeta3190Vo, tpYeta2000Vo);  
//					  BeanUtils.copyProperties(yeta3110Vo, tpYeta2000Vo);  
//					  BeanUtils.copyProperties(yeta3200Vo, tpYeta2000Vo);  
//					  BeanUtils.copyProperties(yeta3220Vo, tpYeta2000Vo);  
//					  BeanUtils.copyProperties(yeta3150Vo, tpYeta2000Vo);  
//					  BeanUtils.copyProperties(yeta3210Vo, tpYeta2000Vo);  
//					  BeanUtils.copyProperties(yeta3300Vo, tpYeta2000Vo);  
//					  BeanUtils.copyProperties(yeta3000Vo, tpYeta2000Vo);   
//				  
//				        	
//	             
//		           // {거주자주택자금_금전소비대차 삭제} 
//		            yeta3120DAO.fnPayr06430_PAYR450_CREATE_Delete(yeta3120Vo);//yeta3120  거주자주택자금_금전소비대차  
//		             
//		          //  {거주자주택자금_임대차 삭제}
//		            yeta3160DAO.fnPayr06430_PAYR451_CREATE_Delete(yeta3160Vo);//yeta3160  거주자주택자금_임대차 
//		           
//		           // {연금_저축공제 삭제}
//		            yeta3100DAO.fnPayr06430_PAYR418_CREATE_Delete(yeta3100Vo);//yeta3100  연금_저축공제
//		            
//		           // {주택자금_월세 삭제}
//		            yeta3130DAO.fnPayr06430_PAYR452_CREATE_Delete(yeta3130Vo);//yeta3130  주택자금_월세
//		            
//	
//		           // {의료비삭제}
//		            yeta3140DAO.fnPayr06430_PAYR430_CREATE_Delete(yeta3140Vo);//yeta3140 
//	
//		           // {종전근무지삭제}
//		            yeta3110DAO.fnPayr06430_PAYR435_CREATE_Delete(yeta3110Vo);//yeta3110  종전근무지명세   
//	
//		          
//		            //{기부금삭제}
//	                yeta3180DAO.fnPayr06430_PAYR440_CREATE_Delete(yeta3180Vo);//yeta3180 기부금명세  
//	
//		           // {이월기부금삭제}
//		            yeta3190DAO.fnPayr06430_PAYR443_CREATE_Delete(yeta3190Vo);//yeta3190 이월기부금삭제  
//	
//		            //{이월기부금삭제}
//		            yeta3170DAO.fnPayr06430_PAYR442_CREATE_Delete(yeta3170Vo);//yeta3170 이월기부금삭제  
//	
//		          //  {가족사항삭제}
//		            yeta3220DAO.fnPayr06430_PAYR410_CREATE_Delete(yeta3220Vo);//yeta3220 가족사항  
//	
//		            //{교육비가족사항삭제}
//		            yeta3150DAO.fnPayr06430_PAYR445_CREATE_Delete(yeta3150Vo);//yeta3150 교육사항 
//	
//		           // {급여내역삭제}
//		            yeta3210DAO.fnPayr06420_PAYR417_CREATE_Delete(yeta3210Vo);//yeta3210 급여내역 삭제 
//		            
//		            //{비과세감면 정산 삭제 }
//		            yeta3300DAO.fnPayr06430_Yeta3300_CREATE_Delete(yeta3300Vo);//yeta3300  비과세감면소득정산   
//		             //[비과세감면내역 삭제 ]
//	 		        yeta3200DAO.fnPayr06430_Yeta3200_CREATE_Delete(yeta3200Vo);//yeta3200  비과세감면소득   	
//	 		      
//		           // {연말정산상세삭제}
//		            yeta3000DAO.fnPayr06430_PAYR425_CREATE_Delete(yeta3000Vo);//yeta3000   
//		            
//		            
//			        // {연말정산기본삭제}
//			        yeta2000DAO.fnPayr06420_PAYR415_CREATE_Delete(tpYeta2000Vo);//yeta2000  연말정산기본 
//	
//			            
//		            //TODO 단건선택이 아닌경우 마감테이블로 같이 삭제 한다 .
//			        if (MSFSharedUtils.paramNull(yeta1000Dto.getSystemkey())) {  
//			           //   {마감테이블 삭제}
//			        	yeta1000Vo.setDpobCd(tpYeta2000Vo.getDpobCd());    /** column null : dpobCd */
//						yeta1000Vo.setEdacRvyy(tpYeta2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//						yeta1000Vo.setSettGbcd(tpYeta2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
//			        	yeta1000Vo.setEdacSeilNum(tpYeta2000Vo.getEdacSeilNum());
//			            yeta1000DAO.fnPayr06430_PAYR420_CREATE_Delete(yeta1000Vo);//yeta1000  마감테이블   
//			        }
//  		          }     
//			     retval = 1L;
//			  }
//		  }   catch (Exception ex) {
//		        	 
//		            logger.error("EXCEPTION calling Payr06420_Payr400_Delete(): "+ex); 
//		            retval = 0L;
//		            throw MSFServerUtils.getOperationException("Payr06420_Payr400_Delete", ex, logger);
//		        } 
//		        
//		        return retval;
//		        
//	    	
//	    }
//	   
//	    /**
//	     * 
//	     * <pre>
//	     * 1. 개요 : yeta화면 대상자 처리 화면 
//	     * 2. 처리내용 : 
//	     * </pre>
//	     * @Method Name : Payr06420_All_Create
//	     * @date : Jan 25, 2016
//	     * @author : leeheuisung
//	     * @history : 
//	     *	-----------------------------------------------------------------------
//	     *	변경일				작성자						변경내용  
//	     *	----------- ------------------- ---------------------------------------
//	     *	Jan 25, 2016		leeheuisung				최초 작성 
//	     *	-----------------------------------------------------------------------
//	     * 
//	     * @see com.app.exterms.yearendtax.client.service.Yeta0100Service#Payr06420_All_Create(com.app.exterms.yearendtax.client.dto.Yeta1000DTO)
//	     * @param yeta1000Dto
//	     * @return
//	     * @throws MSFException
//	     */
//	    @Override
//	    public  PagingLoadResult<ShowMessageBM> Payr06420_All_Create(Yeta1000DTO yeta1000Dto) throws MSFException {
//	    	  
//	    	   PagingLoadResult<ShowMessageBM> retval = null;
//      	     
//      	    
//      	      YetaPrc1000VO yetaPrc1000Vo = new YetaPrc1000VO();  //마감테이블   
//	       
//				   
//			  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//			        
//			  try {    
//			    
//				    
//				        Long delResult = Payr06420_All_Delete(yeta1000Dto);
//				    
//			    if (delResult > 0L) { 
//				        
//				     //   List<String> listDeptCd = new ArrayList<String>();
//			            /** 조건절 */
//				        yetaPrc1000Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//				        yetaPrc1000Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//				        yetaPrc1000Vo.setUsrId(sessionUser.getUsrId());   
//				     
//				    	yetaPrc1000Vo.setEdacRvyy(yeta1000Dto.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//				    	yetaPrc1000Vo.setSettGbcd(yeta1000Dto.getSettGbcd());    /** column 정산구분코드 : settGbcd */
//				    	yetaPrc1000Vo.setEdacSeilNum(new BigDecimal(yeta1000Dto.getEdacSeilNum()));    /** column 연말정산마감일련번호 : edacSeilNum */
//				    	yetaPrc1000Vo.setSystemkey(yeta1000Dto.getSystemkey());    //systemkey
//				    	yetaPrc1000Vo.setPayrMangDeptCd(yeta1000Dto.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
//				    	yetaPrc1000Vo.setDeptCd(yeta1000Dto.getDeptCd());    /** column 부서코드 : deptCd */
//				    	yetaPrc1000Vo.setTypOccuCd(MSFSharedUtils.allowNulls(yeta1000Dto.getTypOccuCd()));    /** column 직종코드 : typOccuCd */
//				    	yetaPrc1000Vo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(yeta1000Dto.getDtilOccuClsDivCd()));    /** column 직종세구분코드 : dtilOccuClsDivCd */
//				    	yetaPrc1000Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(yeta1000Dto.getPyspGrdeCd()));    /** column 호봉등급코드 : pyspGrdeCd */
//				    	yetaPrc1000Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(yeta1000Dto.getDtilOccuInttnCd()));    /** column 직종세통합코드 : dtilOccuInttnCd */
//				    	yetaPrc1000Vo.setBusinCd(MSFSharedUtils.allowNulls(yeta1000Dto.getBusinCd()));    /** column 사업코드 : businCd */
//				    	yetaPrc1000Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(yeta1000Dto.getEmymtDivCd()));    /** column 고용구분코드 : emymtDivCd */
//				    	yetaPrc1000Vo.setPernChrgEmpIdenNum(sessionUser.getUsrId());    /** column 생성직원번호 : pernChrgEmpIdenNum */
//			            
//			            /******************************** 권한 ************************************************************************/
//
//			            if (yetaPrc1000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yeta1000Dto.getDeptCd()))) { 
//	                       yetaPrc1000Vo.setDeptCd("");  //부서코드
//	                     } 
//			            
//			            yetaPrc1000Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(yeta1000Dto.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
//			            yetaPrc1000Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yeta1000Dto.getDtilOccuInttnCd()).replace(",", ""));      
//
//			            
//			           /******************************** 권한 ************************************************************************/
//  
//				    	YetaListenerAdapter yetaLsAdtr = new YetaListenerAdapter();
//				    	//컴포넌트 호출하기 
//				    	retval = yetaLsAdtr.setYetaPayr06420_All_Create(RemoteServiceUtil.getThreadLocalRequest(),yetaPrc1000Vo);
//				    	
//				   }  
//			 
//			     
//		        }
//		        catch (Exception ex) {
//		        	 
//		            logger.error("EXCEPTION calling Payr06420_All_Create(): "+ex); 
//		          
//		            throw MSFServerUtils.getOperationException("Payr06420_All_Create", ex, logger);
//		        } 
//		        
//		        return retval;
//		        
//	    	
//	    } 
//	    
//	    @Override
//	    public  PagingLoadResult<ShowMessageBM> Payr06420_All_Add_Create(Yeta1000DTO yeta1000Dto) throws MSFException {
//	    	  
//	    	   PagingLoadResult<ShowMessageBM> retval = null;
//      	     
//      	    
//      	      YetaPrc1000VO yetaPrc1000Vo = new YetaPrc1000VO();  //마감테이블   
//	       
//				   
//			  MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//			        
//			  try {     
//				        
//				     //   List<String> listDeptCd = new ArrayList<String>();
//			            /** 조건절 */
//				        yetaPrc1000Vo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
//				        yetaPrc1000Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//				        yetaPrc1000Vo.setUsrId(sessionUser.getUsrId());   
//				     
//				    	yetaPrc1000Vo.setEdacRvyy(yeta1000Dto.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//				    	yetaPrc1000Vo.setSettGbcd(yeta1000Dto.getSettGbcd());    /** column 정산구분코드 : settGbcd */
//				    	yetaPrc1000Vo.setEdacSeilNum(new BigDecimal(yeta1000Dto.getEdacSeilNum()));    /** column 연말정산마감일련번호 : edacSeilNum */
//				    	yetaPrc1000Vo.setSystemkey(yeta1000Dto.getSystemkey());    //systemkey
//				    	yetaPrc1000Vo.setPayrMangDeptCd(yeta1000Dto.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
//				    	yetaPrc1000Vo.setDeptCd(yeta1000Dto.getDeptCd());    /** column 부서코드 : deptCd */
//				    	yetaPrc1000Vo.setTypOccuCd(MSFSharedUtils.allowNulls(yeta1000Dto.getTypOccuCd()));    /** column 직종코드 : typOccuCd */
//				    	yetaPrc1000Vo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(yeta1000Dto.getDtilOccuClsDivCd()));    /** column 직종세구분코드 : dtilOccuClsDivCd */
//				    	yetaPrc1000Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(yeta1000Dto.getPyspGrdeCd()));    /** column 호봉등급코드 : pyspGrdeCd */
//				    	yetaPrc1000Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(yeta1000Dto.getDtilOccuInttnCd()));    /** column 직종세통합코드 : dtilOccuInttnCd */
//				    	yetaPrc1000Vo.setBusinCd(MSFSharedUtils.allowNulls(yeta1000Dto.getBusinCd()));    /** column 사업코드 : businCd */
//				    	yetaPrc1000Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(yeta1000Dto.getEmymtDivCd()));    /** column 고용구분코드 : emymtDivCd */
//				    	yetaPrc1000Vo.setPernChrgEmpIdenNum(sessionUser.getUsrId());    /** column 생성직원번호 : pernChrgEmpIdenNum */
//			            
//			            /******************************** 권한 ************************************************************************/
//
//			            if (yetaPrc1000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yeta1000Dto.getDeptCd()))) { 
//	                       yetaPrc1000Vo.setDeptCd("");  //부서코드
//	                     } 
//			            
//			            yetaPrc1000Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(yeta1000Dto.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
//			            yetaPrc1000Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yeta1000Dto.getDtilOccuInttnCd()).replace(",", ""));      
//
//			            
//			           /******************************** 권한 ************************************************************************/
// 
//				    	
//				    	YetaListenerAdapter yetaLsAdtr = new YetaListenerAdapter();
//				    	//컴포넌트 호출하기 
//				    	retval = yetaLsAdtr.setYetaPayr06420_All_Add_Create(RemoteServiceUtil.getThreadLocalRequest(),yetaPrc1000Vo);
//				   
//			     
//		        }
//		        catch (Exception ex) {
//		        	 
//		            logger.error("EXCEPTION calling Payr06420_All_Create(): "+ex); 
//		          
//		            throw MSFServerUtils.getOperationException("Payr06420_All_Create", ex, logger);
//		        } 
//		        
//		        return retval;
//		        
//	    	
//	    } 
//	    
//	    
//	    /**
//	     * 
//	     * <pre>
//	     * 1. 개요 : 선택된 대상자에 대해 급여자료을 이관한다. 
//	     * 2. 처리내용 : 
//	     * </pre>
//	     * @Method Name : PayrExec_Yeta_Insert
//	     * @date : Jan 30, 2016
//	     * @author : leeheuisung
//	     * @history : 
//	     *	-----------------------------------------------------------------------
//	     *	변경일				작성자						변경내용  
//	     *	----------- ------------------- ---------------------------------------
//	     *	Jan 30, 2016		leeheuisung				최초 작성 
//	     *	-----------------------------------------------------------------------
//	     * 
//	     * @param listYeta2000Dto
//	     * @return
//	     * @throws MSFException
//	     */
//	    @Override
//	    public  Long PayrExec_Yeta_Insert(List<Yeta2000DTO> listYeta2000Dto) throws MSFException {
//   	    	 
//	    	 
//	    	    Long retval = 0L;
//	    	    int delCnt = 0;  
//	    	    BeanUtilsBean.getInstance().getConvertUtils().register(false, false, 0);  
//		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
//		        List<YetaPrc2000VO> lstYetaPrc2000Vo = new ArrayList<YetaPrc2000VO>();  //연말정산기본  
//		        try {   
//              
//		        	 
//		        	  for(int iCnt=0;iCnt < listYeta2000Dto.size();iCnt++) {
//			            	 
//			                
//		        		  Yeta2000DTO yeta2000Dto = new Yeta2000DTO();  //연말정산기본  ;  
//		                  Yeta2000VO yeta2000Vo = new Yeta2000VO();  //연말정산기본  
//		                  yeta2000Dto = listYeta2000Dto.get(iCnt); 
//		                	 
//		        	     // BeanUtils.copyProperties(yeta2000Vo, yeta2000Dto);   
//
//							yeta2000Vo.setDpobCd(yeta2000Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
//							yeta2000Vo.setEdacRvyy(yeta2000Dto.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
//							yeta2000Vo.setSettGbcd(yeta2000Dto.getSettGbcd());    /** column 정산구분코드 : settGbcd */
//							yeta2000Vo.setSystemkey(yeta2000Dto.getSystemkey());    /** column SYSTEMKEY : systemkey */
//							yeta2000Vo.setEdacSeilNum(new BigDecimal(yeta2000Dto.getEdacSeilNum()));    /** column 연말정산마감일련번호 : edacSeilNum */
//							yeta2000Vo.setPayrMangDeptCd(yeta2000Dto.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
//							yeta2000Vo.setEmymtDivCd(yeta2000Dto.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
//							yeta2000Vo.setHanNm(yeta2000Dto.getHanNm());    /** column 한글성명 : hanNm */
//							yeta2000Vo.setResnRegnNum(yeta2000Dto.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
//							yeta2000Vo.setDeptCd(yeta2000Dto.getDeptCd());    /** column 부서코드 : deptCd */
//							yeta2000Vo.setBusinCd(yeta2000Dto.getBusinCd());    /** column 사업코드 : businCd */
//							yeta2000Vo.setTypOccuCd(yeta2000Dto.getTypOccuCd());    /** column 직종코드 : typOccuCd */
//							yeta2000Vo.setDtilOccuInttnCd(yeta2000Dto.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
//							yeta2000Vo.setDtilOccuClsDivCd(yeta2000Dto.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
//							yeta2000Vo.setOdtyCd(yeta2000Dto.getOdtyCd());    /** column 직책코드 : odtyCd */
//							yeta2000Vo.setPyspCd(yeta2000Dto.getPyspCd());    /** column 호봉코드 : pyspCd */
//							yeta2000Vo.setPyspGrdeCd(yeta2000Dto.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
//							yeta2000Vo.setLogSvcYrNumCd(yeta2000Dto.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
//							yeta2000Vo.setLogSvcMnthIcmCd(yeta2000Dto.getLogSvcMnthIcmCd());    /** column 근속월수코드 : logSvcMnthIcmCd */
//							yeta2000Vo.setFrstEmymtDt(yeta2000Dto.getFrstEmymtDt());    /** column 최초고용일자 : frstEmymtDt */
//							yeta2000Vo.setEmymtBgnnDt(yeta2000Dto.getEmymtBgnnDt());    /** column 고용시작일자 : emymtBgnnDt */
//							yeta2000Vo.setEmymtEndDt(yeta2000Dto.getEmymtEndDt());    /** column 고용종료일자 : emymtEndDt */
//							yeta2000Vo.setHdofcDivCd(yeta2000Dto.getHdofcDivCd());    /** column 재직구분코드 : hdofcDivCd */
//							yeta2000Vo.setRetryDt(yeta2000Dto.getRetryDt());    /** column 퇴직일자 : retryDt */
//							yeta2000Vo.setYrtxApptnYrMnth(yeta2000Dto.getYrtxApptnYrMnth());    /** column 연말정산적용년월 : yrtxApptnYrMnth */
//							yeta2000Vo.setYrtxPrcsDt(yeta2000Dto.getYrtxPrcsDt());    /** column 연말정산처리일자 : yrtxPrcsDt */
////							yeta2000Vo.setYrtxPrcsYn(yeta2000Dto.getYrtxPrcsYn());    /** column 연말정산처리여부 : yrtxPrcsYn */
//							yeta2000Vo.setYrtxPrcsYn((Boolean.TRUE.equals(yeta2000Dto.getYrtxPrcsYn()) ? "Y" : "N"));
//							yeta2000Vo.setDivdPymtDivCd(yeta2000Dto.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
////							yeta2000Vo.setDivdPymt(yeta2000Dto.getDivdPymt());    /** column 분할납부횟수 : divdPymt */
////							yeta2000Vo.setGnanSgtf(yeta2000Dto.getGnanSgtf());    /** column 세대주여부 : gnanSgtf */
////							yeta2000Vo.setFrnrYeno(yeta2000Dto.getFrnrYeno());    /** column 외국인구분코드 : frnrYeno */
////							yeta2000Vo.setReymStdt(yeta2000Dto.getReymStdt());    /** column 귀속년월_FROM : reymStdt */
////							yeta2000Vo.setReymEddt(yeta2000Dto.getReymEddt());    /** column 귀속년월_TO : reymEddt */
////							yeta2000Vo.setRutrEddt(yeta2000Dto.getRutrEddt());    /** column 감면기간_TO : rutrEddt */
////							yeta2000Vo.setRutrStdt(yeta2000Dto.getRutrStdt());    /** column 감면기간_FROM : rutrStdt */
////							yeta2000Vo.setResdFlag(yeta2000Dto.getResdFlag());    /** column 거주구분여부 : resdFlag */
////							yeta2000Vo.setNatnGbcd(yeta2000Dto.getNatnGbcd());    /** column 국적코드 : natnGbcd */
////							yeta2000Vo.setNatnName(yeta2000Dto.getNatnName());    /** column 국적명 : natnName */
////							yeta2000Vo.setRedtGbcd(yeta2000Dto.getRedtGbcd());    /** column 거주지국코드 : redtGbcd */
////							yeta2000Vo.setRedtName(yeta2000Dto.getRedtName());    /** column 거주지국명 : redtName */
////							yeta2000Vo.setHumnCgue(yeta2000Dto.getHumnCgue());    /** column 인적공제항목변동여부 : humnCgue */
////							yeta2000Vo.setFrnrSgyn(yeta2000Dto.getFrnrSgyn());    /** column 외국인단일세율적용여부 : frnrSgyn */
////							yeta2000Vo.setBaseWiyn(yeta2000Dto.getBaseWiyn());    /** column 기본공제_배우자유무 : baseWiyn */
////							yeta2000Vo.setBaseFmly(yeta2000Dto.getBaseFmly());    /** column 기본공제_부양가족수 : baseFmly */
////							yeta2000Vo.setAddrCt70(yeta2000Dto.getAddrCt70());    /** column 추가공제_경로우대_70세이상수 : addrCt70 */
////							yeta2000Vo.setAddrHdrc(yeta2000Dto.getAddrHdrc());    /** column 추가공제_장애인수 : addrHdrc */
////							yeta2000Vo.setAddrFdsu(yeta2000Dto.getAddrFdsu());    /** column 추가공제_부녀자수 : addrFdsu */
////							yeta2000Vo.setAddrClct(yeta2000Dto.getAddrClct());    /** column 추가공제_자녀양육비양육수 : addrClct */
////							yeta2000Vo.setAddrBhct(yeta2000Dto.getAddrBhct());    /** column 추가공제_출산자녀양육수 : addrBhct */
////							yeta2000Vo.setPantOnsu(yeta2000Dto.getPantOnsu());    /** column 추가공제_한부모수 : pantOnsu */
////							yeta2000Vo.setAddrMrct(yeta2000Dto.getAddrMrct());    /** column 추가공제_다자녀인원수 : addrMrct */
////							yeta2000Vo.setBnatPsnf(yeta2000Dto.getBnatPsnf());    /** column 종근무지_국민연금보험료 : bnatPsnf */
////							yeta2000Vo.setJnatPsnf(yeta2000Dto.getJnatPsnf());    /** column 주근무지_국민연금보험료 : jnatPsnf */
////							yeta2000Vo.setBpssTech(yeta2000Dto.getBpssTech());    /** column 종근무지_국민연금외교직원연금 : bpssTech */
////							yeta2000Vo.setBpssPulc(yeta2000Dto.getBpssPulc());    /** column 종근무지_국민연금외공무원연금 : bpssPulc */
////							yeta2000Vo.setBpssFect(yeta2000Dto.getBpssFect());    /** column 종근무지_국민연금외별정우체국 : bpssFect */
////							yeta2000Vo.setBpssSold(yeta2000Dto.getBpssSold());    /** column 종근무지_국민연금외군인연금 : bpssSold */
////							yeta2000Vo.setJpssPulc(yeta2000Dto.getJpssPulc());    /** column 주근무지_국민연금외공무원연금 : jpssPulc */
////							yeta2000Vo.setJpssSold(yeta2000Dto.getJpssSold());    /** column 주근무지_국민연금외군인연금 : jpssSold */
////							yeta2000Vo.setJpssTech(yeta2000Dto.getJpssTech());    /** column 주근무지_국인연금외교직원연금 : jpssTech */
////							yeta2000Vo.setJpssFect(yeta2000Dto.getJpssFect());    /** column 주근무지_국민연금외별정우체국 : jpssFect */
////							yeta2000Vo.setBrtrPsct(yeta2000Dto.getBrtrPsct());    /** column 종근무지_종_근로자퇴직보장법 : brtrPsct */
////							yeta2000Vo.setBrtrCict(yeta2000Dto.getBrtrCict());    /** column 종근무지_종_과학기술인공제 : brtrCict */
////							yeta2000Vo.setBrtrAnsv(yeta2000Dto.getBrtrAnsv());    /** column 종근무지_연금계좌_연금저축 : brtrAnsv */
////							yeta2000Vo.setJrtrCict(yeta2000Dto.getJrtrCict());    /** column 주근무지_퇴직연금과학기술인공제 : jrtrCict */
////							yeta2000Vo.setJrtrCtar(yeta2000Dto.getJrtrCtar());    /** column 주근무지_퇴직연금과학기술인공제대상금액 : jrtrCtar */
////							yeta2000Vo.setJrtrPsct(yeta2000Dto.getJrtrPsct());    /** column 주근무지_퇴직연금근로자퇴직급여보장법 : jrtrPsct */
////							yeta2000Vo.setJrtrPtar(yeta2000Dto.getJrtrPtar());    /** column 주근무지_퇴직연금근로자퇴직급여보장대상금액 : jrtrPtar */
////							yeta2000Vo.setJrtrAnsv(yeta2000Dto.getJrtrAnsv());    /** column 주근무지_연금계좌_연금저축 : jrtrAnsv */
////							yeta2000Vo.setJrtrAtar(yeta2000Dto.getJrtrAtar());    /** column 주근무지_연금계좌저축공제대상금액 : jrtrAtar */
////							yeta2000Vo.setRrptAmnt(yeta2000Dto.getRrptAmnt());    /** column 연금보험료계 : rrptAmnt */
////							yeta2000Vo.setSpciBhlh(yeta2000Dto.getSpciBhlh());    /** column 특별공제_종건강보험료 : spciBhlh */
////							yeta2000Vo.setSpciHhlh(yeta2000Dto.getSpciHhlh());    /** column 특별공제_주건강보험료 : spciHhlh */
////							yeta2000Vo.setSpciBepf(yeta2000Dto.getSpciBepf());    /** column 특별공제_종고용보험료 : spciBepf */
////							yeta2000Vo.setSpciJepf(yeta2000Dto.getSpciJepf());    /** column 특별공제_주고용보험료 : spciJepf */
////							yeta2000Vo.setSpciGurt(yeta2000Dto.getSpciGurt());    /** column 특별공제_일반보장성보험료 : spciGurt */
////							yeta2000Vo.setSpciHdrc(yeta2000Dto.getSpciHdrc());    /** column 특별공제_장애인전용보험료 : spciHdrc */
////							yeta2000Vo.setSpciRttg(yeta2000Dto.getSpciRttg());    /** column 특별공제_보장성보험료공제대상금액 : spciRttg */
////							yeta2000Vo.setSpciIuam(yeta2000Dto.getSpciIuam());    /** column 특별공제_보험료계 : spciIuam */
////							yeta2000Vo.setSpciSelf(yeta2000Dto.getSpciSelf());    /** column 특별공제_의료비_본인 : spciSelf */
////							yeta2000Vo.setSpciAe65(yeta2000Dto.getSpciAe65());    /** column 특별공제_의료비_경로65세이상 : spciAe65 */
////							yeta2000Vo.setSpciDbps(yeta2000Dto.getSpciDbps());    /** column 특별공제_의료비_장애인 : spciDbps */
////							yeta2000Vo.setSpciDetc(yeta2000Dto.getSpciDetc());    /** column 특별공제_의료비_기타공제대상자 : spciDetc */
////							yeta2000Vo.setSpciDtar(yeta2000Dto.getSpciDtar());    /** column 특별공제_의료비세액공제대상금액 : spciDtar */
////							yeta2000Vo.setSpciEtam(yeta2000Dto.getSpciEtam());    /** column 특별공제_의료비계 : spciEtam */
////							yeta2000Vo.setSpedSelf(yeta2000Dto.getSpedSelf());    /** column 특별공제_교육비_본인 : spedSelf */
////							yeta2000Vo.setSpedEdsu(yeta2000Dto.getSpedEdsu());    /** column 특별공제_교육비_취학전아동수 : spedEdsu */
////							yeta2000Vo.setSpedEdam(yeta2000Dto.getSpedEdam());    /** column 특별공제_교육비_취학전아동 : spedEdam */
////							yeta2000Vo.setSpedGdsu(yeta2000Dto.getSpedGdsu());    /** column 특별공제_교육비_초중고자녀수 : spedGdsu */
////							yeta2000Vo.setSpedGdam(yeta2000Dto.getSpedGdam());    /** column 특별공제_교육비_초중고 : spedGdam */
////							yeta2000Vo.setSpedCvsu(yeta2000Dto.getSpedCvsu());    /** column 특별공제_교육비_대학생수 : spedCvsu */
////							yeta2000Vo.setSpedCvam(yeta2000Dto.getSpedCvam());    /** column 특별공제_교육비_대학교 : spedCvam */
////							yeta2000Vo.setSpciScsu(yeta2000Dto.getSpciScsu());    /** column 특별공제_장애인수 : spciScsu */
////							yeta2000Vo.setSpciScam(yeta2000Dto.getSpciScam());    /** column 특별공제_장애인특수교육비 : spciScam */
////							yeta2000Vo.setSpedEtar(yeta2000Dto.getSpedEtar());    /** column 특별공제_교육비공제대상금액 : spedEtar */
////							yeta2000Vo.setSiedToam(yeta2000Dto.getSiedToam());    /** column 특별공제_교육비계 : siedToam */
////							yeta2000Vo.setSpciRefn(yeta2000Dto.getSpciRefn());    /** column 특별공제_차입금원리금상환액_대출기관 : spciRefn */
////							yeta2000Vo.setSpciResf(yeta2000Dto.getSpciResf());    /** column 특별공제_차입금원리금상환액_거주자 : spciResf */
////							yeta2000Vo.setSpciHtam(yeta2000Dto.getSpciHtam());    /** column 특별공제_주택자금_월세금액 : spciHtam */
////							yeta2000Vo.setSpchRefn(yeta2000Dto.getSpchRefn());    /** column 특별공제_장기주택이자상환액 : spchRefn */
////							yeta2000Vo.setSpchRe06(yeta2000Dto.getSpchRe06());    /** column 특별공제_11장기주택저당차입금15 : spchRe06 */
////							yeta2000Vo.setSpchRe10(yeta2000Dto.getSpchRe10());    /** column 특별공제_11장기주택저당차입금29 : spchRe10 */
////							yeta2000Vo.setSpchRe20(yeta2000Dto.getSpchRe20());    /** column 특별공제_11장기주택저당차입금30 : spchRe20 */
////							yeta2000Vo.setSpchRefx(yeta2000Dto.getSpchRefx());    /** column 특별공제_12장기주택저당차입금_고정 : spchRefx */
////							yeta2000Vo.setSpchReec(yeta2000Dto.getSpchReec());    /** column 특별공제_12장기주택저당차입금_기타 : spchReec */
////							yeta2000Vo.setSpch15fx(yeta2000Dto.getSpch15fx());    /** column 특별공제_15장기주택저당_15고정AND비거치상환 : spch15fx */
////							yeta2000Vo.setSpch15fb(yeta2000Dto.getSpch15fb());    /** column 특별공제_15장기주택저당_15고정OR비거치상환 : spch15fb */
////							yeta2000Vo.setSpch15ec(yeta2000Dto.getSpch15ec());    /** column 특별공제_15장기주택저당_15기타대출 : spch15ec */
////							yeta2000Vo.setSpch10fb(yeta2000Dto.getSpch10fb());    /** column 특별공제_15장기주택저당_10고정OR비거치상환 : spch10fb */
////							yeta2000Vo.setSpch10ec(yeta2000Dto.getSpch10ec());    /** column 특별공제_15장기주택저당_10기타대출 : spch10ec */
////							yeta2000Vo.setTaxdPltc(yeta2000Dto.getTaxdPltc());    /** column 세액공제_기부정치자금금액 : taxdPltc */
////							yeta2000Vo.setTaxd10tg(yeta2000Dto.getTaxd10tg());    /** column 특별공제_기부정치자금_10이하대상금액 : taxd10tg */
////							yeta2000Vo.setSpciPltc(yeta2000Dto.getSpciPltc());    /** column 특별공제_기부금_정치 : spciPltc */
////							yeta2000Vo.setSpciPltg(yeta2000Dto.getSpciPltg());    /** column 특별공제_기부금_정치10초과대상금액 : spciPltg */
////							yeta2000Vo.setSpciFbam(yeta2000Dto.getSpciFbam());    /** column 특별공제_기부금_법정 : spciFbam */
////							yeta2000Vo.setSpciFbtg(yeta2000Dto.getSpciFbtg());    /** column 특별공제_기부금_법정대상금액 : spciFbtg */
////							yeta2000Vo.setSpciExam(yeta2000Dto.getSpciExam());    /** column 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
////							yeta2000Vo.setSpciUnon(yeta2000Dto.getSpciUnon());    /** column 특별공제_기부금_공익법인신탁특례 : spciUnon */
////							yeta2000Vo.setSpciHfam(yeta2000Dto.getSpciHfam());    /** column 특별공제_기부금_우리사주조합2015이후 : spciHfam */
////							yeta2000Vo.setSpciYamt(yeta2000Dto.getSpciYamt());    /** column 특별공제_기부금_종교단체 : spciYamt */
////							yeta2000Vo.setSpciNamt(yeta2000Dto.getSpciNamt());    /** column 특별공제_기부금_종교단체외 : spciNamt */
////							yeta2000Vo.setSpciDgtg(yeta2000Dto.getSpciDgtg());    /** column 특별공제_지정기부금대상금액 : spciDgtg */
////							yeta2000Vo.setSpciFnrl(yeta2000Dto.getSpciFnrl());    /** column 특별공제_혼인_이사_장례비_삭제 : spciFnrl */
////							yeta2000Vo.setPrvm20be(yeta2000Dto.getPrvm20be());    /** column 개인연금저축불입액_2000년이전 : prvm20be */
////							yeta2000Vo.setPrvm21af(yeta2000Dto.getPrvm21af());    /** column 개인연금저축불입액_2001년이후_삭제 : prvm21af */
////							yeta2000Vo.setEtchPrep(yeta2000Dto.getEtchPrep());    /** column 기타공제_소기업공제불입금액 : etchPrep */
////							yeta2000Vo.setEtcsComp(yeta2000Dto.getEtcsComp());    /** column 기타공제_주택마련저축_청약저축 : etcsComp */
////							yeta2000Vo.setEtwkHsvm(yeta2000Dto.getEtwkHsvm());    /** column 기타공제_주택마련저축_근로자주택마련저축 : etwkHsvm */
////							yeta2000Vo.setEtwkHsbm(yeta2000Dto.getEtwkHsbm());    /** column 기타공제_주택마련저축_주택청약종합저축 : etwkHsbm */
////							yeta2000Vo.setEtwkHlgm(yeta2000Dto.getEtwkHlgm());    /** column 기타공제_주택마련저축_장기주택마련저축_del : etwkHlgm */
////							yeta2000Vo.setEtwkHbdm(yeta2000Dto.getEtwkHbdm());    /** column 기타공제_주택마련저축소득금액 : etwkHbdm */
////							yeta2000Vo.setEtctConc(yeta2000Dto.getEtctConc());    /** column 기타공제_투자조합출자금액_2011이전 : etctConc */
////							yeta2000Vo.setEtgdH09f(yeta2000Dto.getEtgdH09f());    /** column 기타공제_투자조합출자금액_2012년도 : etgdH09f */
////							yeta2000Vo.setEtgdH13f(yeta2000Dto.getEtgdH13f());    /** column 기타공제_투자조합출자금액_2013년도 : etgdH13f */
////							yeta2000Vo.setEtgdH14f(yeta2000Dto.getEtgdH14f());    /** column 기타공제_투자조합출자금액_2014년도 : etgdH14f */
////							yeta2000Vo.setEtclH15f(yeta2000Dto.getEtclH15f());    /** column 기타공제_투자조합출자금액_2015년이후 : etclH15f */
////							yeta2000Vo.setEtgdHdam(yeta2000Dto.getEtgdHdam());    /** column 기타공제투자조합출자금액계 : etgdHdam */
////							yeta2000Vo.setEtctCard(yeta2000Dto.getEtctCard());    /** column 기타공제_신용카드등사용금액 : etctCard */
////							yeta2000Vo.setEtchBcbs(yeta2000Dto.getEtchBcbs());    /** column 기타공제_직불카드등사용금액 : etchBcbs */
////							yeta2000Vo.setEtchUeam(yeta2000Dto.getEtchUeam());    /** column 기타공제_현금영수증사용금액 : etchUeam */
////							yeta2000Vo.setEtchMgvd(yeta2000Dto.getEtchMgvd());    /** column 기타공제_전통시장사용분 : etchMgvd */
////							yeta2000Vo.setEtchBced(yeta2000Dto.getEtchBced());    /** column 기타공제_지로납부_대중교통금액 : etchBced */
////							yeta2000Vo.setCardEt13(yeta2000Dto.getCardEt13());    /** column 기타공제_본인신용카드등사용액_2013 : cardEt13 */
////							yeta2000Vo.setCardEt14(yeta2000Dto.getCardEt14());    /** column 기타공제_본인신용카드등사용액_2014 : cardEt14 */
////							yeta2000Vo.setEtadDd13(yeta2000Dto.getEtadDd13());    /** column 기타공제_본인추가공재율사용액_2013 : etadDd13 */
////							yeta2000Vo.setEtadD14l(yeta2000Dto.getEtadD14l());    /** column 기타공제_본인추가공제율사용액_2014하 : etadD14l */
////							yeta2000Vo.setEtchBcue(yeta2000Dto.getEtchBcue());    /** column 기타공제_신용카드등사용공제계 : etchBcue */
////							yeta2000Vo.setEtckUnon(yeta2000Dto.getEtckUnon());    /** column 기타공제_우리사주출연금액 : etckUnon */
////							yeta2000Vo.setEtckUncb(yeta2000Dto.getEtckUncb());    /** column 기타공제_우리사주조합기부금2014이전 : etckUncb */
////							yeta2000Vo.setEtepHsam(yeta2000Dto.getEtepHsam());    /** column 기타공제_고용유지중소기업근로자임금삭감액 : etepHsam */
////							yeta2000Vo.setEtgdCtra(yeta2000Dto.getEtgdCtra());    /** column 기타공제_목돈안드는전세이자상환금액 : etgdCtra */
////							yeta2000Vo.setEtepSest(yeta2000Dto.getEtepSest());    /** column 기타공제_장기집합투자증권저축금액 : etepSest */
////							yeta2000Vo.setEtclHm01(yeta2000Dto.getEtclHm01());    /** column 기타공제_장기주식형저축_1년차_삭제 : etclHm01 */
////							yeta2000Vo.setEtclHm02(yeta2000Dto.getEtclHm02());    /** column 기타공제_장기주식형저축_2년차_삭제 : etclHm02 */
////							yeta2000Vo.setEtclHm03(yeta2000Dto.getEtclHm03());    /** column 기타공제_장기주식형저축_3년차_삭제 : etclHm03 */
////							yeta2000Vo.setEtclHmta(yeta2000Dto.getEtclHmta());    /** column 기타공제_장기주식형저축_납입합계금액_삭제 : etclHmta */
////							yeta2000Vo.setEtclEttl(yeta2000Dto.getEtclEttl());    /** column 기타공제_기타제목 : etclEttl */
////							yeta2000Vo.setEtclEtam(yeta2000Dto.getEtclEtam());    /** column 기타공제_기타금액 : etclEtam */
////							yeta2000Vo.setTaxdIncd(yeta2000Dto.getTaxdIncd());    /** column 세액공제_외국인_입국목적코드 : taxdIncd */
////							yeta2000Vo.setTaxdWkdt(yeta2000Dto.getTaxdWkdt());    /** column 세액공제_외국인_근로제공일자 : taxdWkdt */
////							yeta2000Vo.setTamaEddt(yeta2000Dto.getTamaEddt());    /** column 세액공제_외국인_감면기간만료일자 : tamaEddt */
////							yeta2000Vo.setTamaIndt(yeta2000Dto.getTamaIndt());    /** column 세액공제_외국인_감면신청접수일자 : tamaIndt */
////							yeta2000Vo.setTamaOudt(yeta2000Dto.getTamaOudt());    /** column 세액공제_외국인_감면신청제출일자 : tamaOudt */
////							yeta2000Vo.setTxlgFrrd(yeta2000Dto.getTxlgFrrd());    /** column 세액공제_외국인해저광물개발감면확인일자 : txlgFrrd */
////							yeta2000Vo.setTxlgFrid(yeta2000Dto.getTxlgFrid());    /** column 세액공제_외국인해저광물개발감면신청일자 : txlgFrid */
////							yeta2000Vo.setTxlgWkid(yeta2000Dto.getTxlgWkid());    /** column 세액공제_근로소득조세조약상면제접수일자 : txlgWkid */
////							yeta2000Vo.setTxlgTxtd(yeta2000Dto.getTxlgTxtd());    /** column 세액공제_근로소득조세조약상면제제출일자 : txlgTxtd */
////							yeta2000Vo.setTxlgBscd(yeta2000Dto.getTxlgBscd());    /** column 세액공제_중소기업청년감면취업일자 : txlgBscd */
////							yeta2000Vo.setTxlgBcde(yeta2000Dto.getTxlgBcde());    /** column 세액공제_중소기업청년감면종료일자 : txlgBcde */
////							yeta2000Vo.setTxlgItct(yeta2000Dto.getTxlgItct());    /** column 세액감면_소득세법감면세액 : txlgItct */
////							yeta2000Vo.setTxlgBsta(yeta2000Dto.getTxlgBsta());    /** column 세액감면_취업청년감면대상총급여액 : txlgBsta */
////							yeta2000Vo.setTxlgWkta(yeta2000Dto.getTxlgWkta());    /** column 세액감면_취업청년감면근로자총급여액 : txlgWkta */
////							yeta2000Vo.setTxlgClta(yeta2000Dto.getTxlgClta());    /** column 세액감면_계산감면세액금액 : txlgClta */
////							yeta2000Vo.setTxlgFrta(yeta2000Dto.getTxlgFrta());    /** column 세액감면_외국인기술자감면세액 : txlgFrta */
////							yeta2000Vo.setTxlgTxty(yeta2000Dto.getTxlgTxty());    /** column 세액감면_조세조약감면세액 : txlgTxty */
////							yeta2000Vo.setTxlgInam(yeta2000Dto.getTxlgInam());    /** column 세액공제_외국납부_국외원천소득금액 : txlgInam */
////							yeta2000Vo.setTxlgDlam(yeta2000Dto.getTxlgDlam());    /** column 세액공제_외국납부_외화납세액 : txlgDlam */
////							yeta2000Vo.setTxlgWnam(yeta2000Dto.getTxlgWnam());    /** column 세액공제_외국납부_원화납세액 : txlgWnam */
////							yeta2000Vo.setTxlgOtcy(yeta2000Dto.getTxlgOtcy());    /** column 세액공제_외국납부_납세국명 : txlgOtcy */
////							yeta2000Vo.setTxlgOtdt(yeta2000Dto.getTxlgOtdt());    /** column 세액공제_외국납부_납부일자 : txlgOtdt */
////							yeta2000Vo.setTxlgApdt(yeta2000Dto.getTxlgApdt());    /** column 세액공제_외국납부_신청서제출일자 : txlgApdt */
////							yeta2000Vo.setTxlgOuwk(yeta2000Dto.getTxlgOuwk());    /** column 세액공제_외국납부_국외근무처명 : txlgOuwk */
////							yeta2000Vo.setTxapStdt(yeta2000Dto.getTxapStdt());    /** column 세액공제_외국납부_근무시작일자 : txapStdt */
////							yeta2000Vo.setTxapEddt(yeta2000Dto.getTxapEddt());    /** column 세액공제_외국납부_근무종료일자 : txapEddt */
////							yeta2000Vo.setTxapWkdy(yeta2000Dto.getTxapWkdy());    /** column 세액공제_외국납부_직책 : txapWkdy */
////							yeta2000Vo.setTaxdUnin(yeta2000Dto.getTaxdUnin());    /** column 세액공제_납세조합공제 : taxdUnin */
////							yeta2000Vo.setTaxdLoaa(yeta2000Dto.getTaxdLoaa());    /** column 세액공제_주택차입금이자상황금액 : taxdLoaa */
////							yeta2000Vo.setAddcNtyn(yeta2000Dto.getAddcNtyn());    /** column 추가서류_연금저축등소득공제제출여부 : addcNtyn */
////							yeta2000Vo.setAddcMdyn(yeta2000Dto.getAddcMdyn());    /** column 추가서류_의료비지급명세서제출여부 : addcMdyn */
////							yeta2000Vo.setAddcCtyn(yeta2000Dto.getAddcCtyn());    /** column 추가서류_기부금명세서제출여부 : addcCtyn */
////							yeta2000Vo.setAddcPfyn(yeta2000Dto.getAddcPfyn());    /** column 추가서류_소득공제증빙서류제출여부 : addcPfyn */
////							yeta2000Vo.setAddfPvyn(yeta2000Dto.getAddfPvyn());    /** column 추가서류_종전근무지근로소득원천징수제출여부 : addfPvyn */
////							yeta2000Vo.setSpciReyn(yeta2000Dto.getSpciReyn());    /** column 추가서류_월세액_거주자_주택차입금세액공제제출여부 : spciReyn */
////							yeta2000Vo.setTxlgMxtm(yeta2000Dto.getTxlgMxtm());    /** column 추가서류_월세_비거주간상환액제출여부 : txlgMxtm */
////							yeta2000Vo.setIncoOudt(yeta2000Dto.getIncoOudt());    /** column 소득신고제출일자 : incoOudt */
////							yeta2000Vo.setIncoOufg(yeta2000Dto.getIncoOufg());    /** column 소득신고제출여부 : incoOufg */
////							yeta2000Vo.setJdocFile(yeta2000Dto.getJdocFile());    /** column 파일생성여부 : jdocFile */
////							yeta2000Vo.setJrtrAtom(yeta2000Dto.getJrtrAtom());    /** column 연금계좌계 : jrtrAtom */
////							yeta2000Vo.setJrtrTotr(yeta2000Dto.getJrtrTotr());    /** column 연금계좌공제대상금액 : jrtrTotr */
////							yeta2000Vo.setSpciHdtg(yeta2000Dto.getSpciHdtg());    /** column 특별공제_장애인보장성대상금액 : spciHdtg */
////							yeta2000Vo.setSpciDetg(yeta2000Dto.getSpciDetg());    /** column 특별공제_보장성보험료대상금액 : spciDetg */
////							yeta2000Vo.setSpciRtto(yeta2000Dto.getSpciRtto());    /** column 특별공제_보장성보험료계 : spciRtto */
////							yeta2000Vo.setSpciSftg(yeta2000Dto.getSpciSftg());    /** column 본인의료비공제대상금액 : spciSftg */
////							yeta2000Vo.setSpci65tg(yeta2000Dto.getSpci65tg());    /** column 65세이상자의료비공제대상금액 : spci65tg */
////							yeta2000Vo.setSpciPstg(yeta2000Dto.getSpciPstg());    /** column 장애인의료비공제대상금액 : spciPstg */
////							yeta2000Vo.setSpciEtcg(yeta2000Dto.getSpciEtcg());    /** column 그밖의의료비공제대상금액 : spciEtcg */
////							yeta2000Vo.setSpedSftr(yeta2000Dto.getSpedSftr());    /** column 소득자본인교육비대상금액 : spedSftr */
////							yeta2000Vo.setSpedEdtr(yeta2000Dto.getSpedEdtr());    /** column 취학전아동교육비대상금액 : spedEdtr */
////							yeta2000Vo.setSpedGdtr(yeta2000Dto.getSpedGdtr());    /** column 초중고교육비대상금액 : spedGdtr */
////							yeta2000Vo.setSpedCvtr(yeta2000Dto.getSpedCvtr());    /** column 대학생교육비대상금액 : spedCvtr */
////							yeta2000Vo.setSpciSctr(yeta2000Dto.getSpciSctr());    /** column 특수교육비공제대상금액 : spciSctr */
////							yeta2000Vo.setSpciExtg(yeta2000Dto.getSpciExtg());    /** column 특례기부금_공익법인제외대상금액 : spciExtg */
////							yeta2000Vo.setSpciUntg(yeta2000Dto.getSpciUntg());    /** column 공익법인신탁대상금액 : spciUntg */
////							yeta2000Vo.setSpciHftg(yeta2000Dto.getSpciHftg());    /** column 우리사주종합기부대상금액 : spciHftg */
////							yeta2000Vo.setSpciNatg(yeta2000Dto.getSpciNatg());    /** column 종교단체외지정대상금액 : spciNatg */
////							yeta2000Vo.setSpciYatg(yeta2000Dto.getSpciYatg());    /** column 종교단체지정대상금액 : spciYatg */
////							yeta2000Vo.setSpciDgam(yeta2000Dto.getSpciDgam());    /** column 기부금합계금액 : spciDgam */
////							yeta2000Vo.setSpciOnon(yeta2000Dto.getSpciOnon());    /** column 이월특례기부금_공익신탁금액 : spciOnon */
////							yeta2000Vo.setSpciObam(yeta2000Dto.getSpciObam());    /** column 이월법정기부금액 : spciObam */
////							yeta2000Vo.setSpciOyam(yeta2000Dto.getSpciOyam());    /** column 이월종교단체기부금 : spciOyam */
////							yeta2000Vo.setSpciOnam(yeta2000Dto.getSpciOnam());    /** column 이월종교단체외기부금 : spciOnam */
////							 
////							yeta2000Vo.setRevnAddr(yeta2000Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
////							yeta2000Vo.setCardEt15(yeta2000Dto.getCardEt15());    /** column 기타공제_본인신용카등사용액_2015 : cardEt15 */
////							yeta2000Vo.setEtadD15h(yeta2000Dto.getEtadD15h());    /** column 기타공제_본인추가공제율사용액2015상반기 : etadD15h */
////							yeta2000Vo.setEtadD15l(yeta2000Dto.getEtadD15l());    /** column 기타공제_본인추가공제율사용액2015하반기 : etadD15l */ 
//		        	      
//		        	     // {급여내역삭제}
//		        	     //    {******************************급여자료 이관 - 급여내역 삭제 [1]*******************************************}
//		        	     Yeta3210VO yeta3210Vo = new Yeta3210VO();  //급여내역
//		        	     Yeta3200VO yeta3200Vo = new Yeta3200VO();  //비과세감면소득  
//		        	    
//		        	     BeanUtils.copyProperties(yeta3210Vo, yeta2000Vo); 
//		        	     BeanUtils.copyProperties(yeta3200Vo, yeta2000Vo); 
//		        	     
//		        	     yeta3200Vo.setSiteNumb("0000000000");
//		        	     //[비과세감면내역 삭제 ]
//		  		         yeta3200DAO.fnPayr06430_Yeta3200_CREATE_Delete(yeta3200Vo);//yeta3200  비과세감면소득   	
//		  		            
//		                    //{급여내역삭제}
//			  			 yeta3210DAO.fnPayr06420_PAYR417_CREATE_Delete(yeta3210Vo);//yeta3210 급여내역 삭제   
//			  			  
//			  			 delCnt = delCnt + 1;	  
//			  			 
//		        	   }	  
//		        	  
//		        	  if (delCnt > 0) {
//		        		  
//		        		     YetaListenerAdapter yetaLsAdtr = new YetaListenerAdapter();
//					    	//컴포넌트 호출하기 
//					     	yetaLsAdtr.setPayrToYeta_Insert(RemoteServiceUtil.getThreadLocalRequest(),lstYetaPrc2000Vo );  
//		        		  
//		        	  } 
//					  retval = 1L;
//		        }
//		        catch (Exception ex) {
//		        	 
//		            logger.error("EXCEPTION calling Payr06420_Payr400_Delete(): "+ex); 
//		            retval = 0L;
//		            throw MSFServerUtils.getOperationException("Payr06420_Payr400_Delete", ex, logger);
//		        } 
//		        
//		        return retval;
//		        
//	        	
//			        
//	    }  
//	    
	    
	  
}
