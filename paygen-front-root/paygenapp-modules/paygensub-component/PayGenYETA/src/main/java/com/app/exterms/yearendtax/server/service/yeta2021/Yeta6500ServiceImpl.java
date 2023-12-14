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
package com.app.exterms.yearendtax.server.service.yeta2021;

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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.any.smrmf.utils.BeanFinder;
import com.app.exterms.yearendtax.client.dto.yeta2021.Ye161010DTO;
import com.app.exterms.yearendtax.client.service.yeta2021.Yeta6500Service;
import com.app.exterms.yearendtax.server.service.yeta2021.dao.Ye161005_2021_DAO;
import com.app.exterms.yearendtax.server.service.yeta2021.dao.Ye161010_2021_DAO;
import com.app.exterms.yearendtax.server.vo.Ye161010Srh_2021_VO;
import com.app.exterms.yearendtax.server.vo.Ye161010_2021_VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.def.ColumnDef;
import com.app.smrmf.core.msfmainapp.client.def.TableDef;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnAttribute;
import com.app.smrmf.core.msfmainapp.client.dto.ColumnOrder;
import com.app.smrmf.core.msfmainapp.client.dto.IColumnFilter;
import com.app.smrmf.core.msfmainapp.client.dto.ServiceParameters;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.server.utils.SysifPkgServiceUtils;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

/**
 * 
* <pre>
* 1. 패키지명 : com.app.exterms.yearendtax.server.service
* 2. 타입명 : Yeta0500ServiceImpl.java
* 3. 작성일 : Jan 13, 2016 5:13:53 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Service("Yeta6500Service")
public class Yeta6500ServiceImpl  extends AbstractCustomServiceImpl implements Yeta6500Service  ,YetaDaoConstants {

 
	  private static final Logger logger = LoggerFactory.getLogger(Yeta6500ServiceImpl.class);
	  private static final String calledClass = Yeta6500ServiceImpl.class.getName();
	   
    
	@Autowired
	@Resource(name = "Ye161005_2021_DAO")
	private Ye161005_2021_DAO  ye161005DAO;//A_원천세신고기본
 
	@Autowired
	@Resource(name = "Ye161010_2021_DAO")
	private Ye161010_2021_DAO  ye161010DAO;// 연말정산대상자기본
	  

	//연말정산신고내역 조회
	public PagingLoadResult<BaseModel> getYeta65000List(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA6500LIST;
		Ye161010Srh_2021_VO ye161010SrhVo = new Ye161010Srh_2021_VO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	       
		ye161010DAO = (Ye161010_2021_DAO)BeanFinder.getBean("Ye161010_2021_DAO");
		 
	        
		try {
			//TODO 유저 세션정보에서 사업장 코드을 가지고 오는 부분 추가  
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
	    	ye161010SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	ye161010SrhVo.setClutSeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutSeptCd")));//정산구분
	    	ye161010SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
	     	
	    	ye161010SrhVo.setUsrId(sessionUser.getUsrId());
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	
            	if (sessionUser.getDeptCd().equals(MSFSharedUtils.defaultNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd"),sessionUser.getDeptCd()))) {
               	 

                	ye161010SrhVo.setDeptCd(sessionUser.getDeptCd()); 
                   listDeptCd.add(sessionUser.getDeptCd());
                   ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
           	 } else {
           		 
           		 ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                 listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                 ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드     
           	 }  
            	
               ye161010SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	ye161010SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
                     if (ye161010SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                     	ye161010SrhVo.setDeptCd("");  //부서코드
                     } else {
                    	 ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
            }
            
//            } else {
//            	
//            }
            
            ye161010SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            ye161010SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
	     	
	     	
            ye161010SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            
//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	     	ye161010SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	      	ye161010SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	       	ye161010SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	       	ye161010SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	     	ye161010SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	     	ye161010SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	      	ye161010SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	      	ye161010SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	             
	      	List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd"))); 
	      	ye161010SrhVo.setBusinCdArr(lstBusinCd);  
	      	ye161010SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd"))); //사업코드
	      	
//	      	ye161010SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	           
	           
	      	ye161010SrhVo.setYrtxBlggYr(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr"))); //년도
	      	ye161010SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	      	ye161010SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	            
	      	ye161010SrhVo.setItem14(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "iTem14")));	//금액

	     	
	     	SysIfBass0350VO  SysIfBass0350VO = new SysIfBass0350VO();
	     //	 List<String> listTyInttnCd = new ArrayList<String>(); 
	     	SysIfBass0350VO.setDpobCd(sessionUser.getDpobCd());
	     	SysIfBass0350VO.setYmdGb("Y");
	     	SysIfBass0350VO.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yrtxBlggYr")));
	     	SysIfBass0350VO.setTypOccuCd(ye161010SrhVo.getTypOccuCd());
	     	SysIfBass0350VO.setTypOccuCdArr(lstTypeOccuCd);
	    	SysIfBass0350VO.setDtilOccuInttnCd(ye161010SrhVo.getDtilOccuInttnCd());
	     	SysIfBass0350VO.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	
	     	SysIfBass0350VO = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),SysIfBass0350VO); 
	     
	     	ye161010SrhVo.setTypOccuCdArr(SysIfBass0350VO.getRtnTypOccuCdArr());  
	     	ye161010SrhVo.setDtilOccuInttnCdArr(SysIfBass0350VO.getRtnDtilOccuInttnCdArr());   
	     	
	     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
	      	
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = ye161010DAO.selectYeta0500GirdListTotCnt(ye161010SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginPsnl0126DataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	ye161010SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		ye161010SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		ye161010SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = ye161010DAO.selectYeta0500GirdList(ye161010SrhVo);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {
				

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

	                    }else if("degtrResnRegnNum".equals(tableAttributes[i].getName())) {

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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0400List");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	
	
	//당월급여반영
	public Long activityOnYeta6500List(List<Ye161010DTO> listYe161010dto) throws MSFException {
		// TODO Auto-generated method stub
		Long result = new Long(0);
		Long iCnt = new Long(0);
		BigDecimal seqn = new BigDecimal(0);
		MSFSysm0100BM sessionUser;
		


		String method = calledClass + ".activityOnYeta0500List";
		
		String windowNm = "연말정산급여반영";
		String windowId = "YETA1500";
		        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
				
		try {  
			if (MSFSharedUtils.paramNull(ye161010DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

				ye161010DAO = (Ye161010_2021_DAO) wac.getBean("Ye161010_2021_DAO" ); 
			}
			            
			for(int iPsnlCnt=0;iPsnlCnt < listYe161010dto.size();iPsnlCnt++) {
			                

				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				
				
				Ye161010DTO ye161010Dto = new Ye161010DTO();  
				ye161010Dto = listYe161010dto.get(iPsnlCnt);
			                 
				Ye161010_2021_VO ye161010Vo = new Ye161010_2021_VO();  
			            
				ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161010Dto.getDpobCd()));    				/** column 사업장코드 : dpobCd */
				ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161010Dto.getYrtxBlggYr()));    			/** column 연말정산귀속년도 : yrtxBlggYr */
				ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161010Dto.getClutSeptCd()));    			/** column 정산구분코드 : clutSeptCd */
				ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161010Dto.getSystemkey()));    			/** column SYSTEMKEY : systemkey */
			            
				ye161010Vo.setYrtxApptnYrMnth(ye161010Dto.getYrtxApptnYrMnth());							/** column 연말정산적용년월 : yrtxApptnYrMnth */
				ye161010Vo.setYrtxPrcsDt(ye161010Dto.getYrtxPrcsDt());										/** column 연말정산처리일자 : yrtxPrcsDt */
			 	ye161010Vo.setYrtxPrcsYn((Boolean.TRUE.equals(ye161010Dto.getYrtxPrcsYn()) ? "Y" : "N"));	/** column 연말정산처리여부 : yrtxPrcsYn */
			 	ye161010Vo.setDivdPymtDivCd(ye161010Dto.getDivdPymtDivCd());								/** column 분할납부구분코드 : divdPymtDivCd */
			 	ye161010Vo.setDivdPymt(ye161010Dto.getDivdPymt());    										/** column 분할납부횟수 : divdPymt */
			            
				ye161010Vo.setIsmt(sessionUser.getUsrId());													/** column 수정자 : ismt */
				ye161010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 			/** column 수정주소 : revnAddr */	
			            		
				ye161010DAO.activityOnYeta0500Update(ye161010Vo); 
			            		
				iCnt = iCnt + 1; 
			                    
			} 
			
			result = iCnt;
				
		} catch (Exception ex) {
			logger.error("EXCEPTION calling activityOnYeta6500List(): "+ex); 
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",ex, windowNm , windowId);
			            
			result = new Long(0);
			throw MSFServerUtils.getOperationException("activityOnYeta6500List", ex, logger);
		}
		finally {
			          
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		return result;
	}
	
	
	//연말정산대상자 및 내역 수정
	public Long saveYeta6500Grid(List<Ye161010DTO> listYe161010dto) throws MSFException {
		// TODO Auto-generated method stub
		
		String method = calledClass + ".saveYeta6500Grid";
		
		String windowNm = "연말정산급여반영";
		String windowId = "YETA1500";
		
		Long result = new Long(0);
		Long iCnt = new Long(0);
		MSFSysm0100BM sessionUser;
		
      
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
				
		try {  
			if (MSFSharedUtils.paramNull(ye161010DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());

				ye161010DAO = (Ye161010_2021_DAO) wac.getBean("Ye161010_2021_DAO" ); 
			}
			            
			for(int iPsnlCnt=0;iPsnlCnt < listYe161010dto.size();iPsnlCnt++) {
			               

				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				  
				
				Ye161010DTO ye161010Dto = new Ye161010DTO();  
				ye161010Dto = listYe161010dto.get(iPsnlCnt);
			                 
				Ye161010_2021_VO ye161010Vo = new Ye161010_2021_VO();  
			            
				ye161010Vo.setDpobCd(MSFSharedUtils.allowNulls(ye161010Dto.getDpobCd()));    			/** column 사업장코드 : dpobCd */
				ye161010Vo.setYrtxBlggYr(MSFSharedUtils.allowNulls(ye161010Dto.getYrtxBlggYr()));    		/** column 연말정산귀속년도 : yrtxBlggYr */
				ye161010Vo.setClutSeptCd(MSFSharedUtils.allowNulls(ye161010Dto.getClutSeptCd()));    		/** column 정산구분코드 : clutSeptCd */
				ye161010Vo.setSystemkey(MSFSharedUtils.allowNulls(ye161010Dto.getSystemkey()));    		/** column SYSTEMKEY : systemkey */
			            
				ye161010Vo.setYrtxPrcsYn(Boolean.TRUE.equals(ye161010Dto.getYrtxPrcsYn()) ? "Y" : "N");	/** column 연말정산처리여부 : yrtxPrcsYn */
				ye161010Vo.setDivdPymtDivCd(ye161010Dto.getDivdPymtDivCd());							/** column 분할납부구분코드 : divdPymtDivCd */
				ye161010Vo.setDivdPymt(ye161010Dto.getDivdPymt());    									/** column 분할납부횟수 : divdPymt */
			            
				ye161010Vo.setIsmt(sessionUser.getUsrId());												/** column 수정자 : ismt */
				ye161010Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost()); 		/** column 수정주소 : revnAddr */	
			            		
				
				//연말정산 처리 여부가 Y일 경우 분할납부구분코드 수정 O, 분할납부횟수 X
				if("Y".equals(ye161010Vo.getYrtxPrcsYn())) {
					ye161010DAO.saveYeta0500Ye161010_Y(ye161010Vo); 
				//연말정산 처리 여부가 N일 경우 분할납부구분코드 수정 O, 분할납부횟수 O
				}else if("N".equals(ye161010Vo.getYrtxPrcsYn())) {
					
					ye161010DAO.saveYeta0500Ye161010_N(ye161010Vo); 
				}
			            		
				iCnt = iCnt + 1;
			                    
			} 
			
			result = iCnt;
				
		} catch (Exception ex) {
			logger.error("EXCEPTION calling saveYeta6500Ye161010(): "+ex); 
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",ex, windowNm , windowId);
			            
			result = new Long(0);
			throw MSFServerUtils.getOperationException("saveYeta6500Ye161010", ex, logger);
		}
		finally {
			          
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		
		return result;
	}
	  
	
}
