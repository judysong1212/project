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
package com.app.exterms.yearendtax.server.service.yeta2016;

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

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta2000BM;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta2000DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3150DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta3220DTO;
import com.app.exterms.yearendtax.client.service.yeta2016.Yeta1300Service;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta2000DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3000DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3150DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3170DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta3220DAO;
import com.app.exterms.yearendtax.server.vo.Yeta2000SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta2000VO;
import com.app.exterms.yearendtax.server.vo.Yeta3000SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3000VO;
import com.app.exterms.yearendtax.server.vo.Yeta3150SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3150VO;
import com.app.exterms.yearendtax.server.vo.Yeta3220SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta3220VO;
import com.app.exterms.yearendtax.shared.YetaDaoConstants;
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
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.server.utils.PagingValues;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.server.utils.SysifPkgServiceUtils;
import com.app.smrmf.infc.yearendtax.server.vo.InfcPkgYeta2000VO;
import com.app.smrmf.pkg.listener.yeta.yeta2016.Yeta1300ListenerAdapter;
import com.app.smrmf.sysm.server.service.vo.SysIfBass0350VO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.BasePagingLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;

/**
 * 
* <pre>
* 1. 패키지명 : com.app.exterms.yearendtax.server.service
* 2. 타입명 : Yeta0300ServiceImpl.java
* 3. 작성일 : Jan 13, 2016 5:13:23 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Service("Yeta1300Service")
public class Yeta1300ServiceImpl  extends AbstractCustomServiceImpl implements Yeta1300Service  ,YetaDaoConstants {

	 
	private static final Logger logger = LoggerFactory.getLogger(Yeta1300ServiceImpl.class);
	private static final String calledClass = Yeta1300ServiceImpl.class.getName();
	  
	@Autowired
	@Resource(name = "Ye16Ta2000DAO")
	private Ye16Ta2000DAO yeta2000DAO;

	@Autowired
	@Resource(name = "Ye16Ta3000DAO")
	private Ye16Ta3000DAO yeta3000DAO;
	
	@Autowired
	@Resource(name = "Ye16Ta3150DAO")
	private Ye16Ta3150DAO yeta3150DAO;
	
	@Autowired
	@Resource(name = "Ye16Ta3170DAO")
	private Ye16Ta3170DAO yeta3170DAO;
	
	@Autowired
	@Resource(name = "Ye16Ta3220DAO")
	private Ye16Ta3220DAO yeta3220DAO;
	
	//대상자 정보 조회
	public PagingLoadResult<BaseModel> getYeta1300ToYeta2000List(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA1300ToYETA2000_LIST;
		Yeta2000SrhVO   yeta2000SrhVo = new Yeta2000SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(yeta2000DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			yeta2000DAO = (Ye16Ta2000DAO) wac.getBean("Ye16Ta2000DAO" ); 
		}
	        
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
	    	yeta2000SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	yeta2000SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd")));//정산구분
	    	yeta2000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
	     	
	    	yeta2000SrhVo.setUsrId(sessionUser.getUsrId());
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	yeta2000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
               yeta2000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	yeta2000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
                     if (yeta2000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
                     	 listDeptCd = null; 
                     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                     	yeta2000SrhVo.setDeptCd("");  //부서코드
                     } else {
                    	 yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
                          yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
            }
            
//            } else {
//            	
//            }
            
            yeta2000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            yeta2000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
	     	
	     	
	        yeta2000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
	            
//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
	      	yeta2000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	     	yeta2000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
	           
//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
	      	yeta2000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	yeta2000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
	             
	    	yeta2000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	           
	           
	    	yeta2000SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //년도
	       	yeta2000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	      	yeta2000SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	      	
	      	yeta2000SrhVo.setPrintType(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "printType")));    //출력대상
	      	
	      	yeta2000SrhVo.setYetaDpcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yetaDpcd")));				//원천신고부서
	      	yeta2000SrhVo.setBusoprRgstnum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "busoprRgstnum;")));	//사업자등록번호
	            
	    	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
//	      	SysIfBass0320VO  sysIfBass0320Vo = new SysIfBass0320VO();
//	     	 List<String> listTypCd = new ArrayList<String>(); 
//	     	 
//	     	sysIfBass0320Vo.setYmdGb("Y");
//	     	sysIfBass0320Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYr")));
//	     	sysIfBass0320Vo.setTypOccuCd(psnl0100SrhVO.getTypOccuCd());
//	     	sysIfBass0320Vo.setTypOccuCdArr(lstTypeOccuCd); 
//	     	
//	     	listTypCd = SysifPkgServiceUtils.funcArrBeforTypOccuCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0320Vo);
	     	
	     	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
	     //	 List<String> listTyInttnCd = new ArrayList<String>(); 
	     	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
	     	sysIfBass0350Vo.setYmdGb("Y");
	     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy")));
	     	sysIfBass0350Vo.setTypOccuCd(yeta2000SrhVo.getTypOccuCd());
	     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
	    	sysIfBass0350Vo.setDtilOccuInttnCd(yeta2000SrhVo.getDtilOccuInttnCd());
	     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	
	     	sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo); 
	     
	     	yeta2000SrhVo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
	     	yeta2000SrhVo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
	     	
	     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = yeta2000DAO.selectYeta0300ToYeta2000ListTotCnt(yeta2000SrhVo);  
	              
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
	     	yeta2000SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		yeta2000SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		yeta2000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = yeta2000DAO.selectYeta0300ToYeta2000List(yeta2000SrhVo);
	            
			Iterator<Map<String, Object>> iter = list.iterator();
		            
			SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
	           
	        
			while (iter.hasNext()) {
				

				// 1. 암호화 객체 생성
			 nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			        
				
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

	          	        }else if("degtrResnRegnNum".equals(tableAttributes[i].getName())) {

	          				// 주민번호(복호화)
	          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
	          		          		
	          				strValue = rrnDecCrypt;
	          	    
	          	        } else if("rsnoNumb".equals(tableAttributes[i].getName())) { 
            			// 복호화
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta1300To2000List");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	//인적공제명세 정보 조회
	public PagingLoadResult<BaseModel> getYeta1300To3220List(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA1300To3220_LIST;
		Yeta3220SrhVO   yeta3220SrhVo = new Yeta3220SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(yeta3220DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			yeta3220DAO = (Ye16Ta3220DAO) wac.getBean("Ye16Ta3220DAO"); 
		}
	        
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
	    	
//	    	List<String> listDeptCd = new ArrayList<String>();    
	      	/** 조건절 */
	    	yeta3220SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	    	yeta3220SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"))) ;   //systemkey
	    	yeta3220SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy")));	/** column 연말정산귀속년도 : edacRvyy */
	    	yeta3220SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd")));	/** column 정산구분코드 : settGbcd */
	    	
//	    	yeta3220SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
//	    	yeta3220SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
////	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
//	     	
//	    	yeta3220SrhVo.setUsrId(sessionUser.getUsrId());
//            /******************************** 권한 ************************************************************************/
//            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//            if ("FALSE".equals(chkDeptCd)) {
//            	yeta3220SrhVo.setDeptCd(sessionUser.getDeptCd()); 
//               listDeptCd.add(sessionUser.getDeptCd());
//               yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
//               yeta3220SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//            } else {
//            	yeta3220SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
//                     if (yeta3220SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
//                     	 listDeptCd = null; 
//                     	yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//                     	yeta3220SrhVo.setDeptCd("");  //부서코드
//                     } else {
//                    	 yeta3220SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
//                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//                          yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
//                     } 
//            }
//            
////            } else {
////            	
////            }
//            
//            yeta3220SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
//            yeta3220SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
//            
//           /******************************** 권한 ************************************************************************/
//	     	
//	     	
//            yeta3220SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
//	            
////	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
////	     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
////	      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//	            
//	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
//	       	yeta3220SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
//	       	yeta3220SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//	           
////	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
////	     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
////	     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//	             
//	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
//	      	yeta3220SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//	      	yeta3220SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
//	             
//	      	yeta3220SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
//	           
//	           
//	      	yeta3220SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //년도
//	      	yeta3220SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
//	      	yeta3220SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = yeta3220DAO.selectYeta0300To3220ListTotCnt(yeta3220SrhVo);  
	              
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
	     	yeta3220SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		yeta3220SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		yeta3220SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = yeta3220DAO.selectYeta0300To3220List(yeta3220SrhVo);
	            
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

	          	        }else if("rsnoNumb".equals(tableAttributes[i].getName())) {

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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta1300To2000List");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	
	//교육비내역 조회
	public PagingLoadResult<BaseModel> getYeta1300To3150List(ServiceParameters serviceParameters) throws MSFException {
			

			PagingLoadResult<BaseModel> retval = null;
			String method =  CLASS_YETA1300To3150_LIST;
			Yeta3150SrhVO   yeta3150SrhVo = new Yeta3150SrhVO();
			List<BaseModel>  bmResult = new ArrayList<BaseModel>();
			MSFSysm0100BM sessionUser;
			
		        
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
		      
			if  (MSFSharedUtils.paramNull(yeta3150DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				yeta3150DAO = (Ye16Ta3150DAO) wac.getBean("Ye16Ta3150DAO"); 
			}
		        
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
		    	
//		    	List<String> listDeptCd = new ArrayList<String>();    
		      	/** 조건절 */
		    	yeta3150SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
		    	yeta3150SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"))) ;   //systemkey
		    	yeta3150SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy")));	/** column 연말정산귀속년도 : edacRvyy */
		    	yeta3150SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd")));	/** column 정산구분코드 : settGbcd */
		    	
//		    	yeta3220SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
//		    	yeta3220SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
////		     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
//		     	
//		    	yeta3220SrhVo.setUsrId(sessionUser.getUsrId());
//	            /******************************** 권한 ************************************************************************/
//	            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//	            if ("FALSE".equals(chkDeptCd)) {
//	            	yeta3220SrhVo.setDeptCd(sessionUser.getDeptCd()); 
//	               listDeptCd.add(sessionUser.getDeptCd());
//	               yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
//	               yeta3220SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//	            } else {
//	            	yeta3220SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
//	                     if (yeta3220SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
//	                     	 listDeptCd = null; 
//	                     	yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	                     	yeta3220SrhVo.setDeptCd("");  //부서코드
//	                     } else {
//	                    	 yeta3220SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
//	                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	                          yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
//	                     } 
//	            }
//	            
////	            } else {
////	            	
////	            }
//	            
//	            yeta3220SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
//	            yeta3220SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
//	            
//	           /******************************** 권한 ************************************************************************/
//		     	
//		     	
//	            yeta3220SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
//		            
////		       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
////		     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
////		      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//		            
//		       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
//		       	yeta3220SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
//		       	yeta3220SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//		           
////		     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
////		     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
////		     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//		             
//		      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
//		      	yeta3220SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//		      	yeta3220SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
//		             
//		      	yeta3220SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
//		           
//		           
//		      	yeta3220SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //년도
//		      	yeta3220SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
//		      	yeta3220SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
		            
		      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
//				if ( pagingValues.executeRecordCount ) { 
//			            	
//					//Execute query that returns a single value
//		        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
//		                 
//		          	int iResultCnt = yeta3220DAO.selectYeta0300To3220ListTotCnt(yeta3220SrhVo);  
//		              
//		          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
//		          	
//		          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
//	                if (!pagingValues.pageExecute) { 
//	                    pagingValues.offsetLimit = iResultCnt;       
//	                }
//	                
//		         	pagingValues.totalRecordCount = iResultCnt;	       
//		                
//		        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
//				}
//		        
//		     	TimingInfo millisBeginPsnl0126DataList = SmrmfUtils.startTiming(logger);
//		        
//		     	/**페이지 카운트 처리를 위한 부분 */ 
//		     	yeta3220SrhVo.setPageSize(pagingValues.totalRecordCount);  
//		            
//		     	//Apply paging
//		     	if (pagingValues.start > 0) {
//		     		yeta3220SrhVo.setFirstIndex(pagingValues.start);
//		     	}
//		     	if (pagingValues.offsetLimit > 0) {
//		     		yeta3220SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
//		     	}
//
//		     	//Execute query and convert to BaseModel list
//		     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
//		            
//		     	@SuppressWarnings("unchecked")
////		            Collection<Map<String, Object>> list ??????
		     	List list = yeta3150DAO.selectYeta0300To3150List(yeta3150SrhVo);
		            
				Iterator<Map<String, Object>> iter = list.iterator();
			            
//				SmrmfUtils.endTiming(logger, millisBeginQueryMain, "QueryMain"); 
		           
		        
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

		          	        }else if("degtrResnRegnNum".equals(tableAttributes[i].getName())) {

		          				// 주민번호(복호화)
		          				rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(strValue).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		          		          		
		          				strValue = rrnDecCrypt;
		          	     
		          	        }else if("rsnoNumb".equals(tableAttributes[i].getName())) {

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
		            
//				SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
		       
			} catch (Exception ex) {
				ex.printStackTrace();
				//Return operation exception
				throw MSFServerUtils.getOperationException(method, ex, logger);
			}
			return retval;
		}
	
	
	/**
	 * 	
	 * <pre>
	 * 1. 개요 : 연말정산 세액 계산 결과 내역을 출력 한다.  
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getYeta0300ToSubTaxList
	 * @date : Jan 30, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Jan 30, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param serviceParameters
	 * @return
	 * @throws MSFException
	 */
	public PagingLoadResult<BaseModel> getYeta1300ToSubTaxList(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA1300TOSUBTAX_LIST;
		Yeta3000SrhVO   yeta3000SrhVo = new Yeta3000SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
	        

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(yeta3000DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			yeta3000DAO = (Ye16Ta3000DAO) wac.getBean("Ye16Ta3000DAO"); 
		}
	        
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
	    	
//	    	List<String> listDeptCd = new ArrayList<String>();    
	      	/** 조건절 */
	    	yeta3000SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	    	yeta3000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"))) ;   //systemkey
	    	yeta3000SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy")));	/** column 연말정산귀속년도 : edacRvyy */
	    	yeta3000SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd")));	/** column 정산구분코드 : settGbcd */
	    	 
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = yeta3000DAO.selectYeta0300ToSubTaxListTotCnt(yeta3000SrhVo);  
	              
	          	SmrmfUtils.endTiming(logger, millisBeginQueryCount, "QueryCount");
	          	
	          	//페이지처리를 하지 않을 경우 전체 카운트 값을 받은 부분 추가 할것.
                if (!pagingValues.pageExecute) { 
                    pagingValues.offsetLimit = iResultCnt;       
                }
                
	         	pagingValues.totalRecordCount = iResultCnt;	       
	                
	        	logger.debug("totalRecordCount : " + pagingValues.totalRecordCount);
			}
	        
	     	TimingInfo millisBeginYeta0300ToSubTaxDataList = SmrmfUtils.startTiming(logger);
	        
	     	/**페이지 카운트 처리를 위한 부분 */ 
	     	yeta3000SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		yeta3000SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		yeta3000SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = yeta3000DAO.selectYeta0300ToSubTaxList(yeta3000SrhVo);
	            
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
	            
			SmrmfUtils.endTiming(logger, millisBeginYeta0300ToSubTaxDataList, "getYeta1300To2000List");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	
	
	//소득공제명세 합계내역 조회
	public PagingLoadResult<BaseModel> getYeta1300To3220SumList(ServiceParameters serviceParameters) throws MSFException {
		

		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA1300To3220_SUM_LIST;
		Yeta3220SrhVO   yeta3220SrhVo = new Yeta3220SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
	        
	        
		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
	      
		if  (MSFSharedUtils.paramNull(yeta3220DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
			yeta3220DAO = (Ye16Ta3220DAO) wac.getBean("Ye16Ta3220DAO"); 
		}
	        
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
	    	
//	    	List<String> listDeptCd = new ArrayList<String>();    
	      	/** 조건절 */
	    	yeta3220SrhVo.setDpobCd(sessionUser.getDpobCd());  //사업장코드
	    	yeta3220SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey"))) ;   //systemkey
	    	yeta3220SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy")));	/** column 연말정산귀속년도 : edacRvyy */
	    	yeta3220SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "settGbcd")));	/** column 정산구분코드 : settGbcd */
	    	
//	    	yeta3220SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
//	    	yeta3220SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
////	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
//	     	
//	    	yeta3220SrhVo.setUsrId(sessionUser.getUsrId());
//            /******************************** 권한 ************************************************************************/
//            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
//            if ("FALSE".equals(chkDeptCd)) {
//            	yeta3220SrhVo.setDeptCd(sessionUser.getDeptCd()); 
//               listDeptCd.add(sessionUser.getDeptCd());
//               yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
//               yeta3220SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
//            } else {
//            	yeta3220SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd"))) ;   //단위기관코드   
//                     if (yeta3220SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")))) { 
//                     	 listDeptCd = null; 
//                     	yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//                     	yeta3220SrhVo.setDeptCd("");  //부서코드
//                     } else {
//                    	 yeta3220SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));
//                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//                          yeta3220SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
//                     } 
//            }
//            
////            } else {
////            	
////            }
//            
//            yeta3220SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
//            yeta3220SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
//            
//           /******************************** 권한 ************************************************************************/
//	     	
//	     	
//            yeta3220SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "emymtDivCd")));       //고용구분코드
//	            
////	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
////	     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
////	      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
//	            
//	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd"))); 
//	       	yeta3220SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
//	       	yeta3220SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "typOccuCd")));  //직종
//	           
////	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
////	     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
////	     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
//	             
//	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); 
//	      	yeta3220SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
//	      	yeta3220SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd"))); //직종세
//	             
//	      	yeta3220SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
//	           
//	           
//	      	yeta3220SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //년도
//	      	yeta3220SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
//	      	yeta3220SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	            
	      	//Get total record count //전체 데이터 갯수를 가지고 온다. 
			if ( pagingValues.executeRecordCount ) { 
		            	
				//Execute query that returns a single value
	        	TimingInfo millisBeginQueryCount = SmrmfUtils.startTiming(logger);
	                 
	          	int iResultCnt = yeta3220DAO.selectYeta0300To3220SumListTotCnt(yeta3220SrhVo);  
//	          	int iResultCnt = 2;  
	              
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
	     	yeta3220SrhVo.setPageSize(pagingValues.totalRecordCount);  
	            
	     	//Apply paging
	     	if (pagingValues.start > 0) {
	     		yeta3220SrhVo.setFirstIndex(pagingValues.start);
	     	}
	     	if (pagingValues.offsetLimit > 0) {
	     		yeta3220SrhVo.setLastIndex(Math.min(pagingValues.start + pagingValues.offsetLimit, pagingValues.totalRecordCount));
	     	}

	     	//Execute query and convert to BaseModel list
	     	TimingInfo millisBeginQueryMain = SmrmfUtils.startTiming(logger);
	            
	     	@SuppressWarnings("unchecked")
//	            Collection<Map<String, Object>> list ??????
	     	List list = yeta3220DAO.selectYeta0300To3220SumList(yeta3220SrhVo);
	            
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
	            
			SmrmfUtils.endTiming(logger, millisBeginPsnl0126DataList, "getYeta0300To2000List");
	       
		} catch (Exception ex) {
			ex.printStackTrace();
			//Return operation exception
			throw MSFServerUtils.getOperationException(method, ex, logger);
		}
		return retval;
	}
	
	
	
	/**기본사항 tab 수정 **/ 
	@Override
	public int saveYeta1300To2000tabItem01(Ye16Ta2000DTO Yeta2000Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		
		Yeta2000VO yeta2000Vo = new Yeta2000VO();
		Yeta3000VO yeta3000Vo = new Yeta3000VO();
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA1300";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		String method = calledClass + ".saveYeta1300To2000tabItem01";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		
		// ---------- 기본사항 수정 시작 -------------------
		yeta2000Vo.setDpobCd(Yeta2000Dto.getDpobCd());    								/** column 사업장코드 : dpobCd */
		yeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(Yeta2000Dto.getEdacRvyy()));	/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(Yeta2000Dto.getSettGbcd()));	/** column 정산구분코드 : settGbcd */
		yeta2000Vo.setSystemkey(Yeta2000Dto.getSystemkey()); 							/** column SYSTEMKEY : systemkey */
		
		yeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(Yeta2000Dto.getEdacRvyy()));	/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(Yeta2000Dto.getSettGbcd()));  	/** column 정산구분코드 : settGbcd */
	
		yeta2000Vo.setGnanSgtf(MSFSharedUtils.allowNulls(Yeta2000Dto.getGnanSgtf()));   /** column 세대주여부 : gnanSgtf */
		
		yeta2000Vo.setReymStdt(MSFSharedUtils.allowNulls(Yeta2000Dto.getReymStdt())); 	/** column 귀속년월_FROM :  */
		yeta2000Vo.setReymEddt(MSFSharedUtils.allowNulls(Yeta2000Dto.getReymEddt())); 	/** column 귀속년월_TO :   */
		
		yeta2000Vo.setResdFlag(MSFSharedUtils.allowNulls(Yeta2000Dto.getResdFlag()));    /** column 거주구분여부 : resdFlag */
		
		yeta2000Vo.setNatnGbcd(MSFSharedUtils.allowNulls(Yeta2000Dto.getNatnGbcd()));    /** column 국적코드 : natnGbcd */
		yeta2000Vo.setNatnName(MSFSharedUtils.allowNulls(Yeta2000Dto.getNatnName()));    /** column 국적명 : natnName */
		
		yeta2000Vo.setRutrStdt(MSFSharedUtils.allowNulls(Yeta2000Dto.getRutrStdt()));    /** column 감면기간_FROM : rutrStdt */
		yeta2000Vo.setRutrEddt(MSFSharedUtils.allowNulls(Yeta2000Dto.getRutrEddt()));    /** column 감면기간_TO : rutrEddt */
		
		yeta2000Vo.setRedtGbcd(MSFSharedUtils.allowNulls(Yeta2000Dto.getRedtGbcd()));    /** column 거주지국코드 : redtGbcd */
		yeta2000Vo.setRedtName(MSFSharedUtils.allowNulls(Yeta2000Dto.getRedtName()));    /** column 거주지국명 : redtName */
		
		
		/*****************2016귀속추가 ***************************/
		yeta2000Vo.setYrenSgyn((Boolean.TRUE.equals(Yeta2000Dto.getYrenSgyn()) ? "Y" : "N"));      	/** column 연말정산분할납부신청여부 : yrenSgyn */
		yeta2000Vo.setAddIncmTxApptnRtoCd(Yeta2000Dto.getAddIncmTxApptnRtoCd());    				/** column 추가소득세적용비율코드 : addIncmTxApptnRtoCd */
		yeta2000Vo.setFrnrRnyn((Boolean.TRUE.equals(Yeta2000Dto.getFrnrRnyn()) ? "Y" : "N"));    	/** column 외국인법인소속파견근로자여부 : frnrRnyn */
		/*****************2016귀속추가 ***************************/	
		
		
//		yeta2000Vo.setKybdr(sessionUser.getUsrId());
//		yeta2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yeta2000Vo.setIsmt(sessionUser.getUsrId());
		yeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		try{
			
			yeta2000DAO.saveYeta0300To2000tabItem01(yeta2000Vo);
			
			result = 1;
			
		}catch(Exception e){
			e.printStackTrace();
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		// ---------- 기본사항 수정 종료 -------------------
		
		
		//TODO 다시 막음. 
		// ---------- 주현근무지기납부세엑 소득세, 지방소득세 수정 시작 -------------------
		yeta3000Vo.setDpobCd(Yeta2000Dto.getDpobCd());    														/** column 사업장코드 : dpobCd */
		yeta3000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(Yeta2000Dto.getEdacRvyy()));							/** column 연말정산귀속년도 : edacRvyy */
		yeta3000Vo.setSettGbcd(MSFSharedUtils.allowNulls(Yeta2000Dto.getSettGbcd()));							/** column 정산구분코드 : settGbcd */
		yeta3000Vo.setSystemkey(Yeta2000Dto.getSystemkey()); 													/** column SYSTEMKEY : systemkey */
		
		yeta3000Vo.setAlryPinx(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getAlryPinx(), "0")));	/** column 기납부세액_소득세 : alryPinx */
		yeta3000Vo.setAlryPhbx(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getAlryPhbx(), "0")));	/** column 기납부세액_주민세_지방소득세 : alryPhbx */
		yeta3000Vo.setCurrTots(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getCurrTots(), "0")));
		
		
		try{

			yeta3000DAO.saveYeta0300To3000tabItem01(yeta3000Vo);
			
			result = 1;
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		// ---------- 주현근무지기납부세엑 소득세, 지방소득세 수정 종료 -------------------
		
		return result;
	}
	
	
	  
	/**연금보험료공제 tab의 국민연금보험료외의 연금보험료의 주근무지 금액을 저장한다. **/   
	@Override
	public int saveYeta1300To2000tabItem04(Ye16Ta2000DTO Yeta2000Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta1300To2000tabItem04";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA1300";
		
		Yeta2000VO yeta2000Vo = new Yeta2000VO();
		Yeta3000VO yeta3000Vo = new Yeta3000VO();
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		yeta2000Vo.setDpobCd(Yeta2000Dto.getDpobCd());    	/** column 사업장코드 : dpobCd */
		yeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(Yeta2000Dto.getEdacRvyy()));	/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(Yeta2000Dto.getSettGbcd()));	/** column 정산구분코드 : settGbcd */
		yeta2000Vo.setSystemkey(Yeta2000Dto.getSystemkey()); /** column SYSTEMKEY : systemkey */
	
		
//		yeta2000Vo.setBnatPsnf(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getBnatPsnf(), "0")));//종근무지_국민연금보험료
		yeta2000Vo.setJnatPsnf(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getJnatPsnf(), "0")));//주근무지_국민연금보험료
		
		yeta2000Vo.setJpssPulc(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getJpssPulc(), "0")));//주근무지_국민연금외공무원연금
		yeta2000Vo.setJpssSold(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getJpssSold(), "0")));//주근무지_국민연금외군인연금
		yeta2000Vo.setJpssTech(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getJpssTech(), "0")));//주근무지_국인연금외교직원연금
		yeta2000Vo.setJpssFect(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getJpssFect(), "0")));//주근무지_국민연금외별정우체국
		
//		yeta2000Vo.setKybdr(sessionUser.getUsrId());
//		yeta2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yeta2000Vo.setIsmt(sessionUser.getUsrId());
		yeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		
		try{
			
			yeta2000DAO.saveYeta0300To2000tabItem04(yeta2000Vo);
			
			result = 1;
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
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
	
	/**특별소득공제tab 보험료 tab 저장 **/ 
	@Override
	public int saveYeta1300To2000tabItem05_1(Ye16Ta2000DTO Yeta2000Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta1300To2000tabItem05_1";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA1300";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Yeta2000VO yeta2000Vo = new Yeta2000VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		yeta2000Vo.setDpobCd(Yeta2000Dto.getDpobCd());    	/** column 사업장코드 : dpobCd */
		yeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(Yeta2000Dto.getEdacRvyy()));	/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(Yeta2000Dto.getSettGbcd()));	/** column 정산구분코드 : settGbcd */
		yeta2000Vo.setSystemkey(Yeta2000Dto.getSystemkey()); /** column SYSTEMKEY : systemkey */
	
		
		yeta2000Vo.setSpciHhlh(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpciHhlh(), "0")));	//특별공제_주건강보험료 
		yeta2000Vo.setSpciJepf(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpciJepf(), "0")));	//특별공제_주고용보험료
		
		
		yeta2000Vo.setIsmt(sessionUser.getUsrId());
		yeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		try{
			
			yeta2000DAO.saveYeta0300To2000tabItem05_1(yeta2000Vo);
			
			result = 1;
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
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
	
	/**특별소득공제tab 주택자금 tab 저장 **/ 
	@Override
	public int saveYeta1300To2000tabItem05_2(Ye16Ta2000DTO Yeta2000Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta1300To2000tabItem05_2";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA1300";
		
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Yeta2000VO yeta2000Vo = new Yeta2000VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		yeta2000Vo.setDpobCd(Yeta2000Dto.getDpobCd());    	/** column 사업장코드 : dpobCd */
		yeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(Yeta2000Dto.getEdacRvyy()));	/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(Yeta2000Dto.getSettGbcd()));	/** column 정산구분코드 : settGbcd */
		yeta2000Vo.setSystemkey(Yeta2000Dto.getSystemkey()); /** column SYSTEMKEY : systemkey */
	
		
		yeta2000Vo.setSpciRefn(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpciRefn(), "0")));	//특별공제_차입금원리금상환액_대출기관 
		yeta2000Vo.setSpciResf(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpciResf(), "0")));	//특별공제_차입금원리금상환액_거주자
		yeta2000Vo.setSpciHtam(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpciHtam(), "0")));	//특별공제_주택자금_월세금액
		
		
		yeta2000Vo.setSpchRe06(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpchRe06(), "0")));	//특별공제_11장기주택저당차입금15
		yeta2000Vo.setSpchRe10(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpchRe10(), "0")));	//특별공제_11장기주택저당차입금29
		yeta2000Vo.setSpchRe20(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpchRe20(), "0")));	//특별공제_11장기주택저당차입금30
		
		
		yeta2000Vo.setSpchRefx(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpchRefx(), "0")));	//특별공제_12장기주택저당차입금_고정
		yeta2000Vo.setSpchReec(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpchReec(), "0")));	//특별공제_12장기주택저당차입금_기타
		
		
		yeta2000Vo.setSpch15fx(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpch15fx(), "0"))); 	//특별공제_15장기주택저당_15고정AND비거치상환
		yeta2000Vo.setSpch15fb(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpch15fb(), "0"))); 	//특별공제_15장기주택저당_15고정OR비거치상환
		yeta2000Vo.setSpch15ec(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpch15ec(), "0"))); 	//특별공제_15장기주택저당_15기타대출
		yeta2000Vo.setSpch10fb(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpch10fb(), "0"))); 	//특별공제_15장기주택저당_10고정OR비거치상환
		
	 
		
//		yeta2000Vo.setKybdr(sessionUser.getUsrId());
//		yeta2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yeta2000Vo.setIsmt(sessionUser.getUsrId());
		yeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		try{
			
			yeta2000DAO.saveYeta0300To2000tabItem05_2(yeta2000Vo);
			
			result = 1;
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
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
	
	/**그밖의소득공제1tab 금액 수정 **/
	@Override
	public int saveYeta1300To2000tabItem06(Ye16Ta2000DTO Yeta2000Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta1300To2000tabItem06";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA1300";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Yeta2000VO yeta2000Vo = new Yeta2000VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		yeta2000Vo.setDpobCd(Yeta2000Dto.getDpobCd());    													/** column 사업장코드 : dpobCd */
		yeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(Yeta2000Dto.getEdacRvyy()));						/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(Yeta2000Dto.getSettGbcd()));						/** column 정산구분코드 : settGbcd */
		yeta2000Vo.setSystemkey(Yeta2000Dto.getSystemkey()); 												/** column SYSTEMKEY : systemkey */
	
		//yeta2000Vo.setPrvm20be(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getPrvm20be(), "0"))); // 개인연금저축불입액_2000년이전
		yeta2000Vo.setEtchPrep(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtchPrep(), "0"))); 	// 기타공제_소기업공제불입금액
		yeta2000Vo.setEtcsComp(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtcsComp(), "0"))); 	// 기타공제_주택마련저축_청약저축
		yeta2000Vo.setEtwkHsbm(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtwkHsbm(), "0"))); 	// 기타공제_주택마련저축_주택청약종합저축
		yeta2000Vo.setEtwkHsvm(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtwkHsvm(), "0"))); 	// 기타공제_주택마련저축_근로자주택마련저축
		yeta2000Vo.setEtwkHbdm(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtwkHbdm(), "0"))); 	// 기타공제_주택마련저축소득금액
	//	yeta2000Vo.setEtgdH09f(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtgdH09f(), "0"))); // 기타공제_투자조합출자금액_2012년도
   //	yeta2000Vo.setEtgdH13f(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtgdH13f(), "0"))); // 기타공제_투자조합출자금액_2013년도
	
		//--------------------------------2016년도 변경 ---------------------------------------------------------------------
		yeta2000Vo.setEtgdH14f(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtgdH14f(), "0")));	// 기타공제_투자조합출자금액_2014년조합
		yeta2000Vo.setEtgdH14b(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtgdH14b(), "0")));	// 기타공제_투자조합출자금액_2014년벤처
		yeta2000Vo.setEtclH15f(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtclH15f(), "0")));	//기타공제_투자조합출자금액_2015년조합
		yeta2000Vo.setEtclH15b(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtclH15b(), "0")));   //기타공제_투자조합출자금액_2015년벤처
		yeta2000Vo.setEtclH16f(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtclH16f(), "0")));   //기타공제_투자조합출자금액_2016년조합
		yeta2000Vo.setEtclH16b(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtclH16b(), "0")));   //기타공제_투자조합출자금액_2016년벤처 
		
	//	yeta2000Vo.setCardEt13(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getCardEt13(), "0"))); 	//기타공제_본인신용카드등사용액_2013
		yeta2000Vo.setCardEt14(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getCardEt14(), "0"))); 	//기타공제_본인신용카드등사용액_2014
		yeta2000Vo.setCardEt15(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getCardEt15(), "0"))); 	//기타공제_본인신용카등사용액_2015
	    
	//	yeta2000Vo.setEtadDd13(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtadDd13(), "0"))); //기타공제_본인추가공재율사용액_2013
		yeta2000Vo.setEtadD14l(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtadD14l(), "0"))); 	//기타공제_본인추가공제율사용액_2014
	//	yeta2000Vo.setEtadD15h(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtadD15h(), "0"))); //기타공제_본인추가공제율사용액2015상반기
	//	yeta2000Vo.setEtadD15l(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtadD15l(), "0"))); //기타공제_본인추가공제율사용액2015하반기
		yeta2000Vo.setEtadD16l(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getEtadD16l(), "0")));  	/** column 기타공제_본인추가공제율사용액_2016상 : etadD16l */
		
		//--------------------------------2016년도 변경 ---------------------------------------------------------------------
		
		
		
//		yeta2000Vo.setKybdr(sessionUser.getUsrId());
//		yeta2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yeta2000Vo.setIsmt(sessionUser.getUsrId());
		yeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		try{
			
			yeta2000DAO.saveYeta0300To2000tabItem06(yeta2000Vo);
			
			result = 1;
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
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
	
	
	/**그밖의소득공제2tab 금액 수정 **/
	@Override
	public int saveYeta1300To2000tabItem07(Ye16Ta2000DTO Yeta2000Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta1300To2000tabItem07";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA1300";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Yeta2000VO yeta2000Vo = new Yeta2000VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		yeta2000Vo.setDpobCd(Yeta2000Dto.getDpobCd());    	/** column 사업장코드 : dpobCd */
		yeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(Yeta2000Dto.getEdacRvyy()));	/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(Yeta2000Dto.getSettGbcd()));	/** column 정산구분코드 : settGbcd */
		yeta2000Vo.setSystemkey(Yeta2000Dto.getSystemkey()); /** column SYSTEMKEY : systemkey */
	
		yeta2000Vo.setEtckUnon(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getEtckUnon(), "0")));		//기타공제_우리사주출연금액
	//	yeta2000Vo.setEtckUncb(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getEtckUncb(), "0")));		//기타공제_우리사주조합기부금2014이전
		yeta2000Vo.setEtepHsam(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getEtepHsam(), "0")));		//기타공제_고용유지중소기업근로자임금삭감액
	//	yeta2000Vo.setEtgdCtra(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getEtgdCtra(), "0")));		//기타공제_목돈안드는전세이자상환금액
	//	yeta2000Vo.setEtepSest(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getEtepSest(), "0")));		//기타공제_장기집합투자증권저축금액
	//	yeta2000Vo.setEtclEttl(MSFSharedUtils.allowNulls(Yeta2000Dto.getEtclEttl()));	//기타공제_기타제목
	//	yeta2000Vo.setEtclEtam(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getEtclEtam(), "0")));		//기타공제_기타금액

//		yeta2000Vo.setKybdr(sessionUser.getUsrId());
//		yeta2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yeta2000Vo.setIsmt(sessionUser.getUsrId());
		yeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		try{
			
			yeta2000DAO.saveYeta0300To2000tabItem07(yeta2000Vo);
			
			result = 1;
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
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
	
	
	/**세액감면및세액공제1 - 연금계좌및보험료 금액 수정 **/
	@Override
	public int saveYeta1300To2000tabItem08_1(Ye16Ta2000DTO Yeta2000Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta1300To2000tabItem08_1";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA1300";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Yeta2000VO yeta2000Vo = new Yeta2000VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		yeta2000Vo.setDpobCd(Yeta2000Dto.getDpobCd());    	/** column 사업장코드 : dpobCd */
		yeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(Yeta2000Dto.getEdacRvyy()));	/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(Yeta2000Dto.getSettGbcd()));	/** column 정산구분코드 : settGbcd */
		yeta2000Vo.setSystemkey(Yeta2000Dto.getSystemkey()); /** column SYSTEMKEY : systemkey */
	
		//yeta2000Vo.setJrtrCtar(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getJrtrCtar(), "0")));	//주근무지_퇴직연금과학기술인공제대상금액
	//	yeta2000Vo.setJrtrPtar(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getJrtrPtar(), "0")));	//주근무지_퇴직연금근로자퇴직급여보장대상금액
		//yeta2000Vo.setJrtrAtar(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getJrtrAtar(), "0")));	//주근무지_연금계좌저축공제대상금액
		yeta2000Vo.setSpciGurt(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpciGurt(), "0")));	//특별공제_일반보장성보험료
		yeta2000Vo.setSpciHdrc(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpciHdrc(), "0")));	//특별공제_장애인전용보험료

//		yeta2000Vo.setKybdr(sessionUser.getUsrId());
//		yeta2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yeta2000Vo.setIsmt(sessionUser.getUsrId());
		yeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		try{
			
			yeta2000DAO.saveYeta0300To2000tabItem08_1(yeta2000Vo);
			
			result = 1;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
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
	
	
	/**세액감면및세액공제1 - 교육비 금액 수정 **/
	@Override
	public int saveYeta1300To2000tabItem08_3(Ye16Ta2000DTO Yeta2000Dto) throws Exception {
		// TODO Auto-generated method stub

		int result = 0;
		String method = calledClass + ".saveYeta1300To2000tabItem08_3";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA1300";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Yeta2000VO yeta2000Vo = new Yeta2000VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		yeta2000Vo.setDpobCd(Yeta2000Dto.getDpobCd());    								/** column 사업장코드 : dpobCd */
		yeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(Yeta2000Dto.getEdacRvyy()));	/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(Yeta2000Dto.getSettGbcd()));	/** column 정산구분코드 : settGbcd */
		yeta2000Vo.setSystemkey(Yeta2000Dto.getSystemkey()); 							/** column SYSTEMKEY : systemkey */
		
		yeta2000Vo.setSpedSelf(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpedSelf(), "0")));	//특별공제_교육비_본인
		yeta2000Vo.setSpciScam(new BigDecimal(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpciScam(), "0")));	//특별공제_장애인수
		
//		yeta2000Vo.setKybdr(sessionUser.getUsrId());
		yeta2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yeta2000Vo.setIsmt(sessionUser.getUsrId());
		yeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		

		try{
			
			yeta2000DAO.saveYeta0300To2000tabItem08_3(yeta2000Vo);
			
			result = 1;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
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
	
	
	/**세액감면및세액공제1 - 교육비(grid) 금액 수정 **/
	@Override
	public Long saveYeta1300To2000tabItem08_3(List<Ye16Ta3150DTO> listYeta3150dto, ActionDatabase actionDatabase) throws Exception {
		
		String method = calledClass + ".saveYeta1300To2000tabItem08_3";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA1300";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		Long result = new Long(1);
		Long iCnt = new Long(0);
		
		BigDecimal seqn = new BigDecimal(0);
		
		Yeta3150VO  yeta3150Vo = new Yeta3150VO();
		
		try{
			
            for(int iYetaCnt=0; iYetaCnt < listYeta3150dto.size(); iYetaCnt++) {
                

        		// 1. 암호화 객체 생성
        		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
        		
        		
            	Ye16Ta3150DTO yeta3150Dto = new Ye16Ta3150DTO();  
            	yeta3150Dto = listYeta3150dto.get(iYetaCnt);   
            	
            	yeta3150Vo.setDpobCd(yeta3150Dto.getDpobCd());    	/** column 사업장코드 : dpobCd */
            	yeta3150Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta3150Dto.getEdacRvyy()));	/** column 연말정산귀속년도 : edacRvyy */
            	yeta3150Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta3150Dto.getSettGbcd()));	/** column 정산구분코드 : settGbcd */
            	yeta3150Vo.setSystemkey(yeta3150Dto.getSystemkey()); /** column SYSTEMKEY : systemkey */
            	
            	yeta3150Vo.setEdacDtnu(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3150Dto.getEdacDtnu(), "0")));	/** column 교육비가족상세일련번호 : edacDtnu */
//            	yeta3150Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta3150Dto.getEdacRvyy()));	/** column 연말정산귀속년도 : edacRvyy */
//            	yeta3150Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta3150Dto.getSettGbcd()));   /** column 정산구분코드 : settGbcd */
//            	yeta3150Vo.setDpobCd(MSFSharedUtils.allowNulls(yeta3150Dto.getDpobCd()));    	/** column 사업장코드 : dpobCd */
//            	yeta3150Vo.setSystemkey(MSFSharedUtils.allowNulls(yeta3150Dto.getSystemkey())); /** column SYSTEMKEY : systemkey */
            	yeta3150Vo.setFmacGbcd(MSFSharedUtils.allowNulls(yeta3150Dto.getFmacGbcd()));   /** column 가족학력구분코드 : fmacGbcd */
            	yeta3150Vo.setEdacOtam(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3150Dto.getEdacOtam(), "0")));    /** column 교육비지급금액 : edacOtam */ 
            	yeta3150Vo.setRsnoNumb(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta3150Dto.getRsnoNumb()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
            	yeta3150Vo.setGuksYeno((Boolean.TRUE.equals(yeta3150Dto.getGuksYeno()) ? "Y" : "N"));
            	
            	
//            	MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
            	
		        	
            	// 교육비가족상세일련번호 : edacDtnu 으로 insert/update 구분. Delete는 actionDatabase 이용
//            	if((ActionDatabase.DELETE).equals(actionDatabase)) {
//            		yeta3150DAO.deleteYeta0300ToYeta3150(yeta3150Vo);
//            	}else {
////            		if("0".equals(yeta3150Vo.getEdacDtnu())) {
//            		if(yeta3150Vo.getEdacDtnu() == seqn ) {	
//            			
//            			yeta3150DAO.insertYeta0300ToYeta3150(yeta3150Vo);
//            			
//            		}else {
//            			yeta3150DAO.updateYeta0300ToYeta3150(yeta3150Vo);
//            		}
//            	}
            	switch (actionDatabase) {
				case INSERT:
					
					yeta3150DAO.insertYeta0300ToYeta3150(yeta3150Vo);
					
					break;
				case UPDATE:
					
					yeta3150DAO.updateYeta0300ToYeta3150(yeta3150Vo);

					break;
				case DELETE:
					
					yeta3150DAO.deleteYeta0300ToYeta3150(yeta3150Vo);
					
					break;
            	}
            	iCnt = iCnt + 1;
            }
            
            result = iCnt;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
		
		return result;
		
	}
	
	
	/**세액감면및세액공제2 금액 수정 **/
	@Override
	public int saveYeta1300To2000tabItem09(Ye16Ta2000DTO Yeta2000Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta1300To2000tabItem09";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA1300";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		Yeta2000VO yeta2000Vo = new Yeta2000VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		yeta2000Vo.setDpobCd(yeta2000Vo.getDpobCd());    								/** column 사업장코드 : dpobCd */
		yeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(Yeta2000Dto.getEdacRvyy()));	/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(Yeta2000Dto.getSettGbcd()));	/** column 정산구분코드 : settGbcd */
		yeta2000Vo.setSystemkey(yeta2000Vo.getSystemkey()); 							/** column SYSTEMKEY : systemkey */
	
		
		yeta2000Vo.setTaxdIncd((Boolean.TRUE.equals(Yeta2000Dto.getTaxdIncd1()) ? "Y" : "N").concat((Boolean.TRUE.equals(Yeta2000Dto.getTaxdIncd2()) ? "Y" : "N"))
				.concat((Boolean.TRUE.equals(Yeta2000Dto.getTaxdIncd3()) ? "Y" : "N")).concat((Boolean.TRUE.equals(Yeta2000Dto.getTaxdIncd4()) ? "Y" : "N")));		//세액공제_외국인_입국목적코드
		
		yeta2000Vo.setTaxdWkdt((MSFSharedUtils.paramNull(Yeta2000Dto.getTaxdWkdt()) ? Yeta2000Dto.getTaxdWkdt() : Yeta2000Dto.getTaxdWkdt()));//세액공제_외국인_근로제공일자
		yeta2000Vo.setTamaEddt((MSFSharedUtils.paramNull(Yeta2000Dto.getTaxdWkdt()) ? Yeta2000Dto.getTamaEddt() : Yeta2000Dto.getTaxdWkdt()));//세액공제_외국인_감면기간만료일자
		yeta2000Vo.setTamaIndt((MSFSharedUtils.paramNull(Yeta2000Dto.getTaxdWkdt()) ? Yeta2000Dto.getTamaIndt() : Yeta2000Dto.getTaxdWkdt()));//세액공제_외국인_감면신청접수일자
		yeta2000Vo.setTamaOudt((MSFSharedUtils.paramNull(Yeta2000Dto.getTaxdWkdt()) ? Yeta2000Dto.getTamaOudt() : Yeta2000Dto.getTaxdWkdt()));//세액공제_외국인_감면신청제출일자
		yeta2000Vo.setTxlgFrrd((MSFSharedUtils.paramNull(Yeta2000Dto.getTaxdWkdt()) ? Yeta2000Dto.getTxlgFrrd() : Yeta2000Dto.getTaxdWkdt()));//세액공제_외국인해저광물개발감면확인일자
		yeta2000Vo.setTxlgFrid((MSFSharedUtils.paramNull(Yeta2000Dto.getTaxdWkdt()) ? Yeta2000Dto.getTxlgFrid() : Yeta2000Dto.getTaxdWkdt()));//세액공제_외국인해저광물개발감면신청일자
		yeta2000Vo.setTxlgWkid((MSFSharedUtils.paramNull(Yeta2000Dto.getTaxdWkdt()) ? Yeta2000Dto.getTxlgWkid() : Yeta2000Dto.getTaxdWkdt()));//세액공제_근로소득조세조약상면제접수일자
		yeta2000Vo.setTxlgTxtd((MSFSharedUtils.paramNull(Yeta2000Dto.getTaxdWkdt()) ? Yeta2000Dto.getTxlgTxtd() : Yeta2000Dto.getTaxdWkdt()));//세액공제_근로소득조세조약상면제제출일자
		yeta2000Vo.setTxlgBscd((MSFSharedUtils.paramNull(Yeta2000Dto.getTaxdWkdt()) ? Yeta2000Dto.getTxlgBscd() : Yeta2000Dto.getTaxdWkdt()));//세액공제_중소기업청년감면취업일자
		yeta2000Vo.setTxlgBcde((MSFSharedUtils.paramNull(Yeta2000Dto.getTaxdWkdt()) ? Yeta2000Dto.getTxlgBcde() : Yeta2000Dto.getTaxdWkdt()));//세액공제_중소기업청년감면종료일자
		yeta2000Vo.setTxlgItct(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getTxlgItct(), "0")));	//세액감면_소득세법감면세액
		yeta2000Vo.setTxlgBsta(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getTxlgBsta(), "0")));	//세액감면_취업청년감면대상총급여액
		yeta2000Vo.setTxlgWkta(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getTxlgWkta(), "0")));	//세액감면_취업청년감면근로자총급여액
		yeta2000Vo.setTxlgFrta(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getTxlgFrta(), "0")));	//세액감면_외국인기술자감면세액
		yeta2000Vo.setTxlgTxty(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getTxlgTxty(), "0")));	//세액감면_조세조약감면세액
		
		
		yeta2000Vo.setTxlgInam(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getTxlgInam(), "0")) );   //세액공제_외국납부_국외원천소득금액';
		yeta2000Vo.setTxlgDlam(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getTxlgDlam(), "0")) );   //세액공제_외국납부_외화납세액';
		yeta2000Vo.setTxlgWnam(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getTxlgWnam(), "0")) );   //세액공제_외국납부_원화납세액';
		yeta2000Vo.setTxlgOtcy(MSFSharedUtils.allowNulls(Yeta2000Dto.getTxlgOtcy()) ); 		//세액공제_외국납부_납세국명';
		yeta2000Vo.setTxlgOtdt(MSFSharedUtils.allowNulls(Yeta2000Dto.getTxlgOtdt()) );     	//세액공제_외국납부_납부일자';
		yeta2000Vo.setTxlgApdt(MSFSharedUtils.allowNulls(Yeta2000Dto.getTxlgApdt()) );     	//세액공제_외국납부_신청서제출일자';
		yeta2000Vo.setTxlgOuwk(MSFSharedUtils.allowNulls(Yeta2000Dto.getTxlgOuwk()) );      //세액공제_외국납부_국외근무처명';
		yeta2000Vo.setTxapStdt(MSFSharedUtils.allowNulls(Yeta2000Dto.getTxapStdt()) );  	//세액공제_외국납부_근무시작일자';
		yeta2000Vo.setTxapEddt(MSFSharedUtils.allowNulls(Yeta2000Dto.getTxapEddt()) );     	//세액공제_외국납부_근무종료일자';
		yeta2000Vo.setTxapWkdy(MSFSharedUtils.allowNulls(Yeta2000Dto.getTxapWkdy()) );                    		//세액공제_외국납부_직책';
		yeta2000Vo.setTaxdUnin(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getTaxdUnin(), "0")) );  //세액공제_납세조합세액공제';
		yeta2000Vo.setTaxdLoaa(new BigDecimal(MSFSharedUtils.defaultNulls( Yeta2000Dto.getTaxdLoaa(), "0")) );  //세액공제_주택차입금이자상황금액';
		
		
		
//		yeta2000Vo.setKybdr(sessionUser.getUsrId());
//		yeta2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yeta2000Vo.setIsmt(sessionUser.getUsrId());
    	yeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		try{
			
			yeta2000DAO.saveYeta0300To2000tabItem09(yeta2000Vo);
			
			result = 1;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
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
	
	
	/**추가제출서류 수정 **/
	@Override
	public int saveYeta1300To2000tabItem10(Ye16Ta2000DTO Yeta2000Dto)throws Exception {
		// TODO Auto-generated method stub
		
		int result = 0;
		String method = calledClass + ".saveYeta1300To2000tabItem10";
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA1300";
		
		
		Yeta2000VO yeta2000Vo = new Yeta2000VO();
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
		
		
		yeta2000Vo.setDpobCd(sessionUser.getDpobCd());    										/** column 사업장코드 : dpobCd */
		yeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(Yeta2000Dto.getEdacRvyy()));			/** column 연말정산귀속년도 : edacRvyy */
		yeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(Yeta2000Dto.getSettGbcd()));			/** column 정산구분코드 : settGbcd */
		yeta2000Vo.setSystemkey(Yeta2000Dto.getSystemkey()); 									/** column SYSTEMKEY : systemkey */
		
	
		yeta2000Vo.setFrnrSgyn(MSFSharedUtils.defaultNulls(Yeta2000Dto.getFrnrSgyn(), "0"));	/** column 외국인단일세율적용여부 : frnrSgyn */
		yeta2000Vo.setAddcNtyn(MSFSharedUtils.defaultNulls(Yeta2000Dto.getAddcNtyn(), "0"));   	/** column 추가서류_연금저축등소득공제제출여부 : addcNtyn */
		yeta2000Vo.setSpciReyn(MSFSharedUtils.defaultNulls(Yeta2000Dto.getSpciReyn(), "0"));   	/** column 추가서류_월세액_거주자_주택차입금세액공제제출여부 : spciReyn */
		
		yeta2000Vo.setAddcMdyn(MSFSharedUtils.defaultNulls(Yeta2000Dto.getAddcMdyn(), "0"));   	/** column 추가서류_의료비지급명세서제출여부 : addcMdyn */
		yeta2000Vo.setAddcCtyn(MSFSharedUtils.defaultNulls(Yeta2000Dto.getAddcCtyn(), "0"));   	/** column 추가서류_기부금명세서제출여부 : addcCtyn */
		yeta2000Vo.setAddcPfyn(MSFSharedUtils.defaultNulls(Yeta2000Dto.getAddcPfyn(), "0"));   	/** column 추가서류_소득공제증빙서류제출여부 : addcPfyn */
		
		yeta2000Vo.setIncoOufg(MSFSharedUtils.defaultNulls(Yeta2000Dto.getIncoOufg(), "0"));   	/** column 소득신고제출여부 : incoOufg */
		yeta2000Vo.setIncoOudt(MSFSharedUtils.allowNulls(Yeta2000Dto.getIncoOudt()));   		/** column 소득신고제출일자 : incoOudt */
		
//		yeta2000Vo.setKybdr(sessionUser.getUsrId());
//		yeta2000Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
		yeta2000Vo.setIsmt(sessionUser.getUsrId());
    	yeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		
     
		try{
			
			yeta2000DAO.saveYeta0300To2000tabItem10(yeta2000Vo);
			
			result = 1;
			
		}catch(Exception e){
			
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			
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
	
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 인적공제      
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : activityOnYeta0300ToYeta3220
	 * @date : Feb 4, 2016
	 * @author : leeheuisung
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	Feb 4, 2016		leeheuisung				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @see com.app.exterms.yearendtax.client.service.yeta2015.Yeta0300Service#activityOnYeta0300ToYeta3220(java.util.List, smrmframework.core.com.msfmainapp.client.utils.MSFFormPanel.ActionDatabase)
	 * @param listYeta3220dto
	 * @param actionDatabase
	 * @return
	 * @throws MSFException
	 */
	@Override
	public Long activityOnYeta1300ToYeta3220(List<Ye16Ta3220DTO> listYeta3220dto, ActionDatabase actionDatabase)  throws MSFException {
		
		Long result = new Long(1);
		Long iCnt = new Long(0);
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA1300";
		
		String method = calledClass + ".activityOnYeta1300ToYeta3220";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		  
		try { 
	        
			Yeta3220VO  yeta3220Vo = new Yeta3220VO();
	                
			for(int iYetaCnt=0; iYetaCnt < listYeta3220dto.size(); iYetaCnt++) {

				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				    
				Ye16Ta3220DTO yeta3220Dto = new Ye16Ta3220DTO();  
	            yeta3220Dto = listYeta3220dto.get(iYetaCnt);   
       		        	
	         	yeta3220Vo.setDpobCd(MSFSharedUtils.allowNulls(yeta3220Dto.getDpobCd()));    					/** column 사업장코드 : dpobCd */
	          	yeta3220Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta3220Dto.getEdacRvyy()));   				/** column 연말정산귀속년도 : edacRvyy */
	            yeta3220Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta3220Dto.getSettGbcd()));    				/** column 정산구분코드 : settGbcd */
	            yeta3220Vo.setSystemkey(MSFSharedUtils.allowNulls(yeta3220Dto.getSystemkey()));					/** column SYSTEMKEY : systemkey */
//	            yeta3220Vo.setRsnoNumb(MSFSharedUtils.allowNulls(yeta3220Dto.getRsnoNumb().replace("-", "")));    		/** column 주민등록번호 : rsnoNumb */
	            
	            // 암호화
	            yeta3220Vo.setRsnoNumb(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta3220Dto.getRsnoNumb()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
	            
	            
	            
//	            yeta3220Vo.setRelhCode(MSFSharedUtils.allowNulls(yeta3220Dto.getRelhCode()));    		/** column 관계 : relhCode */
//	            yeta3220Vo.setKornName(MSFSharedUtils.allowNulls(yeta3220Dto.getKornName()));    		/** column 성명 : kornName */
//	            yeta3220Vo.setFrnrCode(MSFSharedUtils.allowNulls(yeta3220Dto.getFrnrCode()));    		/** column 내외국인구분코드 : frnrCode */
//	            yeta3220Vo.setBaseDdyn(("true".equals(yeta3220Dto.getBaseDdyn()) ? "1" : "0"));	/** column 기본공제여부 : baseDdyn */
//	            yeta3220Vo.setPsclDdyn(yeta3220Dto.getPsclDdyn());	/** column 장애인공제여부 : psclDdyn */
//	            yeta3220Vo.setBrddCtyn(("true".equals(yeta3220Dto.getBrddCtyn()) ? "1" : "0"));	/** column 자녀양육비공제여부 : brddCtyn */
//	            yeta3220Vo.setFaddCtyn(("true".equals(yeta3220Dto.getFaddCtyn()) ? "1" : "0"));	/** column 부녀자공제여부 : faddCtyn */
//	            yeta3220Vo.setRpctDdyn(("true".equals(yeta3220Dto.getRpctDdyn()) ? "1" : "0"));	/** column 경로우대공제여부 : rpctDdyn */
//	            yeta3220Vo.setBithDdyn(("true".equals(yeta3220Dto.getBithDdyn()) ? "1" : "0"));	/** column 출산입양자공제여부 : bithDdyn */
//	            yeta3220Vo.setPantOnyn(("true".equals(yeta3220Dto.getPantOnyn()) ? "1" : "0"));	/** column 한부모공제여부 : pantOnyn */
	                	
	            
	            yeta3220Vo.setRelhCode(MSFSharedUtils.allowNulls(yeta3220Dto.getRelhCode()));    					/** column 관계 : relhCode */
	            yeta3220Vo.setKornName(MSFSharedUtils.allowNulls(yeta3220Dto.getKornName()));    					/** column 성명 : kornName */
	            yeta3220Vo.setFrnrCode(MSFSharedUtils.allowNulls(yeta3220Dto.getFrnrCode()));    					/** column 내외국인구분코드 : frnrCode */
	            yeta3220Vo.setBaseDdyn((Boolean.TRUE.equals(yeta3220Dto.getBaseDdyn()) ? "1" : "0"));				/** column 기본공제여부 : baseDdyn */
	            yeta3220Vo.setPsclDdyn(yeta3220Dto.getPsclDdyn());													/** column 장애인공제여부 : psclDdyn */
	            yeta3220Vo.setBrddCtyn((Boolean.TRUE.equals(yeta3220Dto.getBrddCtyn()) ? "1" : "0"));				/** column 자녀양육비공제여부 : brddCtyn */
	            yeta3220Vo.setFaddCtyn((Boolean.TRUE.equals(yeta3220Dto.getFaddCtyn()) ? "1" : "0"));				/** column 부녀자공제여부 : faddCtyn */
	            yeta3220Vo.setRpctDdyn((Boolean.TRUE.equals(yeta3220Dto.getRpctDdyn()) ? "1" : "0"));				/** column 경로우대공제여부 : rpctDdyn */
	            yeta3220Vo.setBithDdyn((Boolean.TRUE.equals(yeta3220Dto.getBithDdyn()) ? "1" : "0"));				/** column 출산입양자공제여부 : bithDdyn */
	            yeta3220Vo.setPantOnyn((Boolean.TRUE.equals(yeta3220Dto.getPantOnyn()) ? "1" : "0"));				/** column 한부모공제여부 : pantOnyn */
	            /*****************2016귀속추가 ***************************/
	            yeta3220Vo.setFamySupptRelaDivCd(MSFSharedUtils.allowNulls(yeta3220Dto.getFamySupptRelaDivCd()));	/** column 연말정산부양관계코드 : famySupptRelaDivCd */
	            /*****************2016귀속추가 ***************************/	
	            
	            
				switch (actionDatabase) {

				case INSERT:
					
		            yeta3220Vo.setKybdr(sessionUser.getUsrId());
		            yeta3220Vo.setInptAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
		    		
		            yeta3220Vo.setIsmt(sessionUser.getUsrId());
		            yeta3220Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

					yeta3220DAO.insertYeta0300ToYeta3220(yeta3220Vo);

					break;
				case UPDATE:
					
					yeta3220Vo.setBeforeJumin(MSFSharedUtils.allowNulls(yeta3220Dto.getBeforeJumin().replace("-", "")));	//수정전 주민번호
					
					yeta3220Vo.setIsmt(sessionUser.getUsrId());
		            yeta3220Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());


					yeta3220DAO.updateYeta0300ToYeta3220(yeta3220Vo);

					break;
				case DELETE:
					
					yeta3220Vo.setBeforeJumin(MSFSharedUtils.allowNulls(yeta3220Dto.getBeforeJumin().replace("-", "")));	//수정전 주민번호
					yeta3220DAO.deleteYeta0300ToYeta3220(yeta3220Vo);
					break;
				}

				iCnt = iCnt + 1;
			}

			result = iCnt;

		} catch (Exception ex) {
	            //logger.error("EXCEPTION calling activityOnVoceMenu(): "+ex); 
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass, actionDatabase.toString(), ex, windowNm , windowId);
			
			result = new Long(0);
			ex.printStackTrace();
			throw MSFServerUtils.getOperationException("activityOnYeta0300ToYeta3220", ex, logger);
		
		} finally {
	          
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, actionDatabase.toString());
		
		return result;
	
	}
	
	 /**
	  * 소득공제 tab을 수정한다
	  * <pre>
	  * 1. 개요 : 
	  * 2. 처리내용 : 
	  * </pre>
	  * @Method Name : saveYeta0300To2000tabItem03
	  * @date : Feb 4, 2016
	  * @author : leeheuisung
	  * @history : 
	  *	-----------------------------------------------------------------------
	  *	변경일				작성자						변경내용  
	  *	----------- ------------------- ---------------------------------------
	  *	Feb 4, 2016		leeheuisung				최초 작성 
	  *	-----------------------------------------------------------------------
	  * 
	  * @see com.app.exterms.yearendtax.client.service.yeta2015.Yeta0300Service#saveYeta0300To2000tabItem03(java.util.List, java.util.List)
	  * @param listYeta3220_1dto
	  * @param listYeta3220_2dto
	  * @return
	  * @throws MSFException
	  */
	@Override
	public int saveYeta1300To2000tabItem03(List<Ye16Ta3220DTO> listYeta3220_1dto, List<Ye16Ta3220DTO> listYeta3220_2dto)  throws MSFException {
		
		int result = 1;
		Yeta3220VO  yeta3220Vo = new Yeta3220VO();
		Yeta2000VO  yeta2000Vo = new Yeta2000VO();
		
		String windowNm = "소득공제신고자료관리";
		String windowId = "YETA1300";
		
		
		String method = calledClass + ".saveYeta1300To2000tabItem03";
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
	 
		
		try { 
			
			yeta3220Vo = new Yeta3220VO();
	                
			for(int iYetaCnt=0; iYetaCnt < listYeta3220_1dto.size(); iYetaCnt++) {
				
				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				        
				Ye16Ta3220DTO yeta3220Dto = new Ye16Ta3220DTO();  
	            yeta3220Dto = listYeta3220_1dto.get(iYetaCnt);   
      		        	
	            
	            yeta2000Vo.setDpobCd(MSFSharedUtils.allowNulls(yeta3220Dto.getDpobCd()));    					/** column 사업장코드 : dpobCd */
	            yeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta3220Dto.getEdacRvyy()));   				/** column 연말정산귀속년도 : edacRvyy */
	            yeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta3220Dto.getSettGbcd()));    				/** column 정산구분코드 : settGbcd */
	            yeta2000Vo.setSystemkey(MSFSharedUtils.allowNulls(yeta3220Dto.getSystemkey()));					/** column SYSTEMKEY : systemkey */
	            
	            
	         	yeta3220Vo.setDpobCd(MSFSharedUtils.allowNulls(yeta3220Dto.getDpobCd()));    					/** column 사업장코드 : dpobCd */
	          	yeta3220Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta3220Dto.getEdacRvyy()));   				/** column 연말정산귀속년도 : edacRvyy */
	            yeta3220Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta3220Dto.getSettGbcd()));    				/** column 정산구분코드 : settGbcd */
	            yeta3220Vo.setSystemkey(MSFSharedUtils.allowNulls(yeta3220Dto.getSystemkey()));					/** column SYSTEMKEY : systemkey */
//	            yeta3220Vo.setRsnoNumb(MSFSharedUtils.allowNulls(yeta3220Dto.getRsnoNumb().replace("-", "")));    		/** column 주민등록번호 : rsnoNumb */
	            // 암호화
	            yeta3220Vo.setRsnoNumb(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta3220Dto.getRsnoNumb()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC)); 
	            
	            
	            yeta3220Vo.setRelhCode(MSFSharedUtils.allowNulls(yeta3220Dto.getRelhCode()));    				/** column 관계 : relhCode */
	            yeta3220Vo.setKornName(MSFSharedUtils.allowNulls(yeta3220Dto.getKornName()));    				/** column 성명 : kornName */
	            
	            
	            yeta3220Vo.setInsuPayr(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getInsuPayr(), "0")));    							/** column 보험료_건강고용등국세청 : insuPayr */
	            yeta3220Vo.setInsuGopy(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getInsuGopy(), "0")));
	            yeta3220Vo.setInsuRtyr(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getInsuRtyr(), "0")));	/** column 보험료보장성_국세청 : insuRtyr */
	            yeta3220Vo.setPsclIurr(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getPsclIurr(), "0")));   /** column 보험료장애인보장성_국세청 : psclIurr */
	            yeta3220Vo.setMediCost(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getMediCost(), "0")));   /** column 의료비_국세청 : mediCost */
	            yeta3220Vo.setEducCost(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getEducCost(), "0")));   /** column 교육비_국세청 : educCost */
	            yeta3220Vo.setCdteCard(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getCdteCard(), "0")));   /** column 신용카드등_국세청 : cdteCard */
	            yeta3220Vo.setCashRece(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getCashRece(), "0")));   /** column 현금영수증_국세청 : cashRece */
	            yeta3220Vo.setJiblCard(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getJiblCard(), "0")));   /** column 직불카드등_국세청 : jiblCard */
	            yeta3220Vo.setGrpyAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getGrpyAmnt(), "0")));   /** column 지로납부액_대중교통_국세청 : grpyAmnt */
	            yeta3220Vo.setMgntStvd(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getMgntStvd(), "0")));   /** column 전통시장사용분_국세청 : mgntStvd */
	            yeta3220Vo.setCtrbAmnt(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getCtrbAmnt(), "0")));   /** column 기부금액_국세청 : ctrbAmnt */
	                	
							
				yeta3220Vo.setIsmt(sessionUser.getUsrId());
		        yeta3220Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

		      
		        yeta3220DAO.updateYeta0300ToYeta3220_01(yeta3220Vo);

			}
			
			// 저장완료 후 합계 추가하는 부분으로  
			 yeta2000DAO.updateYeta0300ToYeta2000_Item03(yeta2000Vo);  
			
			
		} catch (Exception ex) {
	            //logger.error("EXCEPTION calling activityOnVoceMenu(): "+ex); 
			result = 0;
			ex.printStackTrace();
			throw MSFServerUtils.getOperationException("saveYeta1300To2000tabItem03_1", ex, logger);
		
		} finally {
	          
		}
		
		
		try { 
			
			yeta3220Vo = new Yeta3220VO();
	                
			for(int iYetaCnt=0; iYetaCnt < listYeta3220_2dto.size(); iYetaCnt++) {
				
				// 1. 암호화 객체 생성
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
				   
				Ye16Ta3220DTO yeta3220Dto = new Ye16Ta3220DTO();  
	            yeta3220Dto = listYeta3220_2dto.get(iYetaCnt);   
      		        	
	         	yeta3220Vo.setDpobCd(MSFSharedUtils.allowNulls(yeta3220Dto.getDpobCd()));    					/** column 사업장코드 : dpobCd */
	          	yeta3220Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta3220Dto.getEdacRvyy()));   				/** column 연말정산귀속년도 : edacRvyy */
	            yeta3220Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta3220Dto.getSettGbcd()));    				/** column 정산구분코드 : settGbcd */
	            yeta3220Vo.setSystemkey(MSFSharedUtils.allowNulls(yeta3220Dto.getSystemkey()));					/** column SYSTEMKEY : systemkey */
//	            yeta3220Vo.setRsnoNumb(MSFSharedUtils.allowNulls(yeta3220Dto.getRsnoNumb().replace("-", "")));	/** column 주민등록번호 : rsnoNumb */
	            // 암호화
	            yeta3220Vo.setRsnoNumb(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta3220Dto.getRsnoNumb()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
	            
	            
	            
	            yeta3220Vo.setRelhCode(MSFSharedUtils.allowNulls(yeta3220Dto.getRelhCode()));    				/** column 관계 : relhCode */
	            yeta3220Vo.setKornName(MSFSharedUtils.allowNulls(yeta3220Dto.getKornName()));    				/** column 성명 : kornName */
	            
	            yeta3220Vo.setInsuFetc(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getInsuFetc(), "0")));    /** column 보험료_건강고용등외FinsuRtet : insuFetc */
	            yeta3220Vo.setInsuGoec(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getInsuGoec(), "0")));    /** column 보험료_건강고용등외FinsuRtet : insuFetc */
	            yeta3220Vo.setInsuRtet(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getInsuRtet(), "0")));    /** column 보험료보장성외 : insuRtet */
	            yeta3220Vo.setPsclIurt(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getPsclIurt(), "0")));    /** column 보험료장애인보장성외 : psclIurt */
	            yeta3220Vo.setMediExps(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getMediExps(), "0")));    /** column 의료비외 : mediExps */
	            yeta3220Vo.setEducOtec(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getEducOtec(), "0")));    /** column 교육비외 : educOtec */
	            yeta3220Vo.setCdteCdec(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getCdteCdec(), "0")));    /** column 신용카드외 : cdteCdec */
	            yeta3220Vo.setJiblCdec(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getJiblCdec(), "0")));    /** column 직불카드외 : jiblCdec */
	            yeta3220Vo.setGrpyAtec(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getGrpyAtec(), "0")));    /** column 지로납부액_대중교통외 : grpyAtec */
	            yeta3220Vo.setMgntSdec(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getMgntSdec(), "0")));    /** column 전통시장사용분외 : mgntSdec */
	            yeta3220Vo.setCtrbAmec(new BigDecimal(MSFSharedUtils.defaultNulls(yeta3220Dto.getCtrbAmec(), "0")));    /** column 기부금액외 : ctrbAmec */
	                	
							
				yeta3220Vo.setIsmt(sessionUser.getUsrId());
		        yeta3220Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());

		        yeta3220DAO.updateYeta0300ToYeta3220_02(yeta3220Vo);

				}
			
			
			// 저장완료 후 합계 추가하는 부분으로  
						yeta2000DAO.updateYeta0300ToYeta2000_Item03(yeta2000Vo);  
		} catch (Exception ex) {
	            //logger.error("EXCEPTION calling activityOnVoceMenu(): "+ex); 
			result = 0;
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",ex, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException("saveYeta1300To2000tabItem03_2", ex, logger);
		
		} finally {
	          
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
	  
	   @Override
		 public PagingLoadResult<ShowMessageBM> fnYeta1300Payr06430CalcTax( List<Ye16Ta2000DTO> listYeta2000Dto ) throws MSFException {

		        PagingLoadResult<ShowMessageBM> retval = null;

		    	String windowNm = "소득공제신고자료관리";
				String windowId = "YETA1300";
				
		    	String method = calledClass + ".fnYeta1300Payr06430CalcTax";
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		       
		        try {  
		            
		        	 
					  List<InfcPkgYeta2000VO>  lstInfcPkgYeta2000Vo = new ArrayList<InfcPkgYeta2000VO>();
					 
	                  for (int iCnt = 0;iCnt < listYeta2000Dto.size();iCnt++) { 
	                	  
	      		    	// 1. 암호화 객체 생성
	      		    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	      		        
	                	      InfcPkgYeta2000VO  yetaPrc2000Vo = new InfcPkgYeta2000VO();
							  Ye16Ta2000DTO  yeta2000Dto = new Ye16Ta2000DTO(); 
							  
							  yeta2000Dto = (Ye16Ta2000DTO) listYeta2000Dto.get(iCnt); 
							  
							 
							  yetaPrc2000Vo.setDpobCd(yeta2000Dto.getDpobCd());    							/** column 사업장코드 : dpobCd */
							  yetaPrc2000Vo.setEdacRvyy(yeta2000Dto.getEdacRvyy());    						/** column 연말정산귀속년도 : edacRvyy */
							  yetaPrc2000Vo.setSettGbcd(yeta2000Dto.getSettGbcd());    						/** column 정산구분코드 : settGbcd */
							  yetaPrc2000Vo.setSystemkey(yeta2000Dto.getSystemkey());    					/** column SYSTEMKEY : systemkey */
							  yetaPrc2000Vo.setEdacSeilNum(new BigDecimal(yeta2000Dto.getEdacSeilNum()));	/** column 연말정산마감일련번호 : edacSeilNum */
							  yetaPrc2000Vo.setPayrMangDeptCd(yeta2000Dto.getPayrMangDeptCd());    			/** column 급여관리부서코드 : payrMangDeptCd */
							  yetaPrc2000Vo.setEmymtDivCd(yeta2000Dto.getEmymtDivCd());    					/** column 고용구분코드 : emymtDivCd */
							  yetaPrc2000Vo.setHanNm(yeta2000Dto.getHanNm());    							/** column 한글성명 : hanNm */
//							  yetaPrc2000Vo.setResnRegnNum(yeta2000Dto.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
							  // 암호화
							  yetaPrc2000Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta2000Dto.getResnRegnNum()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));  
							  
							  yetaPrc2000Vo.setDeptCd(yeta2000Dto.getDeptCd());    						/** column 부서코드 : deptCd */
							  yetaPrc2000Vo.setBusinCd(yeta2000Dto.getBusinCd());    					/** column 사업코드 : businCd */
							  yetaPrc2000Vo.setTypOccuCd(yeta2000Dto.getTypOccuCd());    				/** column 직종코드 : typOccuCd */
							  yetaPrc2000Vo.setDtilOccuInttnCd(yeta2000Dto.getDtilOccuInttnCd());    	/** column 직종세통합코드 : dtilOccuInttnCd */
							  yetaPrc2000Vo.setDtilOccuClsDivCd(yeta2000Dto.getDtilOccuClsDivCd());    	/** column 직종세구분코드 : dtilOccuClsDivCd */
							  yetaPrc2000Vo.setOdtyCd(yeta2000Dto.getOdtyCd());    						/** column 직책코드 : odtyCd */
							  yetaPrc2000Vo.setPyspCd(yeta2000Dto.getPyspCd());    						/** column 호봉코드 : pyspCd */
							  yetaPrc2000Vo.setPyspGrdeCd(yeta2000Dto.getPyspGrdeCd());    				/** column 호봉등급코드 : pyspGrdeCd */
							  yetaPrc2000Vo.setLogSvcYrNumCd(yeta2000Dto.getLogSvcYrNumCd());    		/** column 근속년수코드 : logSvcYrNumCd */
							  yetaPrc2000Vo.setLogSvcMnthIcmCd(yeta2000Dto.getLogSvcMnthIcmCd());    	/** column 근속월수코드 : logSvcMnthIcmCd */
							  yetaPrc2000Vo.setFrstEmymtDt(yeta2000Dto.getFrstEmymtDt());    			/** column 최초고용일자 : frstEmymtDt */
							  yetaPrc2000Vo.setEmymtBgnnDt(yeta2000Dto.getEmymtBgnnDt());    			/** column 고용시작일자 : emymtBgnnDt */
							  yetaPrc2000Vo.setEmymtEndDt(yeta2000Dto.getEmymtEndDt());    				/** column 고용종료일자 : emymtEndDt */
							  yetaPrc2000Vo.setHdofcDivCd(yeta2000Dto.getHdofcDivCd());    				/** column 재직구분코드 : hdofcDivCd */
							  yetaPrc2000Vo.setRetryDt(yeta2000Dto.getRetryDt());    					/** column 퇴직일자 : retryDt */
//							  yetaPrc2000Vo.setYrtxApptnYrMnth(yeta2000Dto.getYrtxApptnYrMnth());    /** column 연말정산적용년월 : yrtxApptnYrMnth */
//							  yetaPrc2000Vo.setYrtxPrcsDt(yeta2000Dto.getYrtxPrcsDt());    /** column 연말정산처리일자 : yrtxPrcsDt */
//							  yetaPrc2000Vo.setYrtxPrcsYn(yeta2000Dto.getYrtxPrcsYn());    /** column 연말정산처리여부 : yrtxPrcsYn */
//							  yetaPrc2000Vo.setDivdPymtDivCd(yeta2000Dto.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
//							  yetaPrc2000Vo.setDivdPymt(yeta2000Dto.getDivdPymt());    /** column 분할납부횟수 : divdPymt */
//							  yetaPrc2000Vo.setGnanSgtf(yeta2000Dto.getGnanSgtf());    /** column 세대주여부 : gnanSgtf */
//							  yetaPrc2000Vo.setFrnrYeno(yeta2000Dto.getFrnrYeno());    /** column 외국인구분코드 : frnrYeno */
//							  yetaPrc2000Vo.setReymStdt(yeta2000Dto.getReymStdt());    /** column 귀속년월_FROM : reymStdt */
//							  yetaPrc2000Vo.setReymEddt(yeta2000Dto.getReymEddt());    /** column 귀속년월_TO : reymEddt */
//							  yetaPrc2000Vo.setRutrEddt(yeta2000Dto.getRutrEddt());    /** column 감면기간_TO : rutrEddt */
//							  yetaPrc2000Vo.setRutrStdt(yeta2000Dto.getRutrStdt());    /** column 감면기간_FROM : rutrStdt */
//							  yetaPrc2000Vo.setResdFlag(yeta2000Dto.getResdFlag());    /** column 거주구분여부 : resdFlag */
//							  yetaPrc2000Vo.setNatnGbcd(yeta2000Dto.getNatnGbcd());    /** column 국적코드 : natnGbcd */
//							  yetaPrc2000Vo.setNatnName(yeta2000Dto.getNatnName());    /** column 국적명 : natnName */
//							  yetaPrc2000Vo.setRedtGbcd(yeta2000Dto.getRedtGbcd());    /** column 거주지국코드 : redtGbcd */
//							  yetaPrc2000Vo.setRedtName(yeta2000Dto.getRedtName());    /** column 거주지국명 : redtName */
//							  yetaPrc2000Vo.setHumnCgue(yeta2000Dto.getHumnCgue());    /** column 인적공제항목변동여부 : humnCgue */
//							  yetaPrc2000Vo.setFrnrSgyn(yeta2000Dto.getFrnrSgyn());    /** column 외국인단일세율적용여부 : frnrSgyn */
//							  yetaPrc2000Vo.setBaseWiyn(yeta2000Dto.getBaseWiyn());    /** column 기본공제_배우자유무 : baseWiyn */
//							  yetaPrc2000Vo.setBaseFmly(yeta2000Dto.getBaseFmly());    /** column 기본공제_부양가족수 : baseFmly */
//							  yetaPrc2000Vo.setAddrCt70(yeta2000Dto.getAddrCt70());    /** column 추가공제_경로우대_70세이상수 : addrCt70 */
//							  yetaPrc2000Vo.setAddrHdrc(yeta2000Dto.getAddrHdrc());    /** column 추가공제_장애인수 : addrHdrc */
//							  yetaPrc2000Vo.setAddrFdsu(yeta2000Dto.getAddrFdsu());    /** column 추가공제_부녀자수 : addrFdsu */
//							  yetaPrc2000Vo.setAddrClct(yeta2000Dto.getAddrClct());    /** column 추가공제_자녀양육비양육수 : addrClct */
//							  yetaPrc2000Vo.setAddrBhct(yeta2000Dto.getAddrBhct());    /** column 추가공제_출산자녀양육수 : addrBhct */
//							  yetaPrc2000Vo.setPantOnsu(yeta2000Dto.getPantOnsu());    /** column 추가공제_한부모수 : pantOnsu */
//							  yetaPrc2000Vo.setAddrMrct(yeta2000Dto.getAddrMrct());    /** column 추가공제_다자녀인원수 : addrMrct */
//							  yetaPrc2000Vo.setBnatPsnf(yeta2000Dto.getBnatPsnf());    /** column 종근무지_국민연금보험료 : bnatPsnf */
//							  yetaPrc2000Vo.setJnatPsnf(yeta2000Dto.getJnatPsnf());    /** column 주근무지_국민연금보험료 : jnatPsnf */
//							  yetaPrc2000Vo.setBpssTech(yeta2000Dto.getBpssTech());    /** column 종근무지_국민연금외교직원연금 : bpssTech */
//							  yetaPrc2000Vo.setBpssPulc(yeta2000Dto.getBpssPulc());    /** column 종근무지_국민연금외공무원연금 : bpssPulc */
//							  yetaPrc2000Vo.setBpssFect(yeta2000Dto.getBpssFect());    /** column 종근무지_국민연금외별정우체국 : bpssFect */
//							  yetaPrc2000Vo.setBpssSold(yeta2000Dto.getBpssSold());    /** column 종근무지_국민연금외군인연금 : bpssSold */
//							  yetaPrc2000Vo.setJpssPulc(yeta2000Dto.getJpssPulc());    /** column 주근무지_국민연금외공무원연금 : jpssPulc */
//							  yetaPrc2000Vo.setJpssSold(yeta2000Dto.getJpssSold());    /** column 주근무지_국민연금외군인연금 : jpssSold */
//							  yetaPrc2000Vo.setJpssTech(yeta2000Dto.getJpssTech());    /** column 주근무지_국인연금외교직원연금 : jpssTech */
//							  yetaPrc2000Vo.setJpssFect(yeta2000Dto.getJpssFect());    /** column 주근무지_국민연금외별정우체국 : jpssFect */
//							  yetaPrc2000Vo.setBrtrPsct(yeta2000Dto.getBrtrPsct());    /** column 종근무지_종_근로자퇴직보장법 : brtrPsct */
//							  yetaPrc2000Vo.setBrtrCict(yeta2000Dto.getBrtrCict());    /** column 종근무지_종_과학기술인공제 : brtrCict */
//							  yetaPrc2000Vo.setBrtrAnsv(yeta2000Dto.getBrtrAnsv());    /** column 종근무지_연금계좌_연금저축 : brtrAnsv */
//							  yetaPrc2000Vo.setJrtrCict(yeta2000Dto.getJrtrCict());    /** column 주근무지_퇴직연금과학기술인공제 : jrtrCict */
//							  yetaPrc2000Vo.setJrtrCtar(yeta2000Dto.getJrtrCtar());    /** column 주근무지_퇴직연금과학기술인공제대상금액 : jrtrCtar */
//							  yetaPrc2000Vo.setJrtrPsct(yeta2000Dto.getJrtrPsct());    /** column 주근무지_퇴직연금근로자퇴직급여보장법 : jrtrPsct */
//							  yetaPrc2000Vo.setJrtrPtar(yeta2000Dto.getJrtrPtar());    /** column 주근무지_퇴직연금근로자퇴직급여보장대상금액 : jrtrPtar */
//							  yetaPrc2000Vo.setJrtrAnsv(yeta2000Dto.getJrtrAnsv());    /** column 주근무지_연금계좌_연금저축 : jrtrAnsv */
//							  yetaPrc2000Vo.setJrtrAtar(yeta2000Dto.getJrtrAtar());    /** column 주근무지_연금계좌저축공제대상금액 : jrtrAtar */
//							  yetaPrc2000Vo.setRrptAmnt(yeta2000Dto.getRrptAmnt());    /** column 연금보험료계 : rrptAmnt */
//							  yetaPrc2000Vo.setSpciBhlh(yeta2000Dto.getSpciBhlh());    /** column 특별공제_종건강보험료 : spciBhlh */
//							  yetaPrc2000Vo.setSpciHhlh(yeta2000Dto.getSpciHhlh());    /** column 특별공제_주건강보험료 : spciHhlh */
//							  yetaPrc2000Vo.setSpciBepf(yeta2000Dto.getSpciBepf());    /** column 특별공제_종고용보험료 : spciBepf */
//							  yetaPrc2000Vo.setSpciJepf(yeta2000Dto.getSpciJepf());    /** column 특별공제_주고용보험료 : spciJepf */
//							  yetaPrc2000Vo.setSpciGurt(yeta2000Dto.getSpciGurt());    /** column 특별공제_일반보장성보험료 : spciGurt */
//							  yetaPrc2000Vo.setSpciHdrc(yeta2000Dto.getSpciHdrc());    /** column 특별공제_장애인전용보험료 : spciHdrc */
//							  yetaPrc2000Vo.setSpciRttg(yeta2000Dto.getSpciRttg());    /** column 특별공제_보장성보험료공제대상금액 : spciRttg */
//							  yetaPrc2000Vo.setSpciIuam(yeta2000Dto.getSpciIuam());    /** column 특별공제_보험료계 : spciIuam */
//							  yetaPrc2000Vo.setSpciSelf(yeta2000Dto.getSpciSelf());    /** column 특별공제_의료비_본인 : spciSelf */
//							  yetaPrc2000Vo.setSpciAe65(yeta2000Dto.getSpciAe65());    /** column 특별공제_의료비_경로65세이상 : spciAe65 */
//							  yetaPrc2000Vo.setSpciDbps(yeta2000Dto.getSpciDbps());    /** column 특별공제_의료비_장애인 : spciDbps */
//							  yetaPrc2000Vo.setSpciDetc(yeta2000Dto.getSpciDetc());    /** column 특별공제_의료비_기타공제대상자 : spciDetc */
//							  yetaPrc2000Vo.setSpciDtar(yeta2000Dto.getSpciDtar());    /** column 특별공제_의료비세액공제대상금액 : spciDtar */
//							  yetaPrc2000Vo.setSpciEtam(yeta2000Dto.getSpciEtam());    /** column 특별공제_의료비계 : spciEtam */
//							  yetaPrc2000Vo.setSpedSelf(yeta2000Dto.getSpedSelf());    /** column 특별공제_교육비_본인 : spedSelf */
//							  yetaPrc2000Vo.setSpedEdsu(yeta2000Dto.getSpedEdsu());    /** column 특별공제_교육비_취학전아동수 : spedEdsu */
//							  yetaPrc2000Vo.setSpedEdam(yeta2000Dto.getSpedEdam());    /** column 특별공제_교육비_취학전아동 : spedEdam */
//							  yetaPrc2000Vo.setSpedGdsu(yeta2000Dto.getSpedGdsu());    /** column 특별공제_교육비_초중고자녀수 : spedGdsu */
//							  yetaPrc2000Vo.setSpedGdam(yeta2000Dto.getSpedGdam());    /** column 특별공제_교육비_초중고 : spedGdam */
//							  yetaPrc2000Vo.setSpedCvsu(yeta2000Dto.getSpedCvsu());    /** column 특별공제_교육비_대학생수 : spedCvsu */
//							  yetaPrc2000Vo.setSpedCvam(yeta2000Dto.getSpedCvam());    /** column 특별공제_교육비_대학교 : spedCvam */
//							  yetaPrc2000Vo.setSpciScsu(yeta2000Dto.getSpciScsu());    /** column 특별공제_장애인수 : spciScsu */
//							  yetaPrc2000Vo.setSpciScam(yeta2000Dto.getSpciScam());    /** column 특별공제_장애인특수교육비 : spciScam */
//							  yetaPrc2000Vo.setSpedEtar(yeta2000Dto.getSpedEtar());    /** column 특별공제_교육비공제대상금액 : spedEtar */
//							  yetaPrc2000Vo.setSiedToam(yeta2000Dto.getSiedToam());    /** column 특별공제_교육비계 : siedToam */
//							  yetaPrc2000Vo.setSpciRefn(yeta2000Dto.getSpciRefn());    /** column 특별공제_차입금원리금상환액_대출기관 : spciRefn */
//							  yetaPrc2000Vo.setSpciResf(yeta2000Dto.getSpciResf());    /** column 특별공제_차입금원리금상환액_거주자 : spciResf */
//							  yetaPrc2000Vo.setSpciHtam(yeta2000Dto.getSpciHtam());    /** column 특별공제_주택자금_월세금액 : spciHtam */
//							  yetaPrc2000Vo.setSpchRefn(yeta2000Dto.getSpchRefn());    /** column 특별공제_장기주택이자상환액 : spchRefn */
//							  yetaPrc2000Vo.setSpchRe06(yeta2000Dto.getSpchRe06());    /** column 특별공제_11장기주택저당차입금15 : spchRe06 */
//							  yetaPrc2000Vo.setSpchRe10(yeta2000Dto.getSpchRe10());    /** column 특별공제_11장기주택저당차입금29 : spchRe10 */
//							  yetaPrc2000Vo.setSpchRe20(yeta2000Dto.getSpchRe20());    /** column 특별공제_11장기주택저당차입금30 : spchRe20 */
//							  yetaPrc2000Vo.setSpchRefx(yeta2000Dto.getSpchRefx());    /** column 특별공제_12장기주택저당차입금_고정 : spchRefx */
//							  yetaPrc2000Vo.setSpchReec(yeta2000Dto.getSpchReec());    /** column 특별공제_12장기주택저당차입금_기타 : spchReec */
//							  yetaPrc2000Vo.setSpch15fx(yeta2000Dto.getSpch15fx());    /** column 특별공제_15장기주택저당_15고정AND비거치상환 : spch15fx */
//							  yetaPrc2000Vo.setSpch15fb(yeta2000Dto.getSpch15fb());    /** column 특별공제_15장기주택저당_15고정OR비거치상환 : spch15fb */
//							  yetaPrc2000Vo.setSpch15ec(yeta2000Dto.getSpch15ec());    /** column 특별공제_15장기주택저당_15기타대출 : spch15ec */
//							  yetaPrc2000Vo.setSpch10fb(yeta2000Dto.getSpch10fb());    /** column 특별공제_15장기주택저당_10고정OR비거치상환 : spch10fb */
//							  yetaPrc2000Vo.setSpch10ec(yeta2000Dto.getSpch10ec());    /** column 특별공제_15장기주택저당_10기타대출 : spch10ec */
//							  yetaPrc2000Vo.setTaxdPltc(yeta2000Dto.getTaxdPltc());    /** column 세액공제_기부정치자금금액 : taxdPltc */
//							  yetaPrc2000Vo.setTaxd10tg(yeta2000Dto.getTaxd10tg());    /** column 특별공제_기부정치자금_10이하대상금액 : taxd10tg */
//							  yetaPrc2000Vo.setSpciPltc(yeta2000Dto.getSpciPltc());    /** column 특별공제_기부금_정치 : spciPltc */
//							  yetaPrc2000Vo.setSpciPltg(yeta2000Dto.getSpciPltg());    /** column 특별공제_기부금_정치10초과대상금액 : spciPltg */
//							  yetaPrc2000Vo.setSpciFbam(yeta2000Dto.getSpciFbam());    /** column 특별공제_기부금_법정 : spciFbam */
//							  yetaPrc2000Vo.setSpciFbtg(yeta2000Dto.getSpciFbtg());    /** column 특별공제_기부금_법정대상금액 : spciFbtg */
//							  yetaPrc2000Vo.setSpciExam(yeta2000Dto.getSpciExam());    /** column 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
//							  yetaPrc2000Vo.setSpciUnon(yeta2000Dto.getSpciUnon());    /** column 특별공제_기부금_공익법인신탁특례 : spciUnon */
//							  yetaPrc2000Vo.setSpciHfam(yeta2000Dto.getSpciHfam());    /** column 특별공제_기부금_우리사주조합2015이후 : spciHfam */
//							  yetaPrc2000Vo.setSpciYamt(yeta2000Dto.getSpciYamt());    /** column 특별공제_기부금_종교단체 : spciYamt */
//							  yetaPrc2000Vo.setSpciNamt(yeta2000Dto.getSpciNamt());    /** column 특별공제_기부금_종교단체외 : spciNamt */
//							  yetaPrc2000Vo.setSpciDgtg(yeta2000Dto.getSpciDgtg());    /** column 특별공제_지정기부금대상금액 : spciDgtg */
//							  yetaPrc2000Vo.setSpciFnrl(yeta2000Dto.getSpciFnrl());    /** column 특별공제_혼인_이사_장례비_삭제 : spciFnrl */
//							  yetaPrc2000Vo.setPrvm20be(yeta2000Dto.getPrvm20be());    /** column 개인연금저축불입액_2000년이전 : prvm20be */
//							  yetaPrc2000Vo.setPrvm21af(yeta2000Dto.getPrvm21af());    /** column 개인연금저축불입액_2001년이후_삭제 : prvm21af */
//							  yetaPrc2000Vo.setEtchPrep(yeta2000Dto.getEtchPrep());    /** column 기타공제_소기업공제불입금액 : etchPrep */
//							  yetaPrc2000Vo.setEtcsComp(yeta2000Dto.getEtcsComp());    /** column 기타공제_주택마련저축_청약저축 : etcsComp */
//							  yetaPrc2000Vo.setEtwkHsvm(yeta2000Dto.getEtwkHsvm());    /** column 기타공제_주택마련저축_근로자주택마련저축 : etwkHsvm */
//							  yetaPrc2000Vo.setEtwkHsbm(yeta2000Dto.getEtwkHsbm());    /** column 기타공제_주택마련저축_주택청약종합저축 : etwkHsbm */
//							  yetaPrc2000Vo.setEtwkHlgm(yeta2000Dto.getEtwkHlgm());    /** column 기타공제_주택마련저축_장기주택마련저축_del : etwkHlgm */
//							  yetaPrc2000Vo.setEtwkHbdm(yeta2000Dto.getEtwkHbdm());    /** column 기타공제_주택마련저축소득금액 : etwkHbdm */
//							  yetaPrc2000Vo.setEtctConc(yeta2000Dto.getEtctConc());    /** column 기타공제_투자조합출자금액_2011이전 : etctConc */
//							  yetaPrc2000Vo.setEtgdH09f(yeta2000Dto.getEtgdH09f());    /** column 기타공제_투자조합출자금액_2012년도 : etgdH09f */
//							  yetaPrc2000Vo.setEtgdH13f(yeta2000Dto.getEtgdH13f());    /** column 기타공제_투자조합출자금액_2013년도 : etgdH13f */
//							  yetaPrc2000Vo.setEtgdH14f(yeta2000Dto.getEtgdH14f());    /** column 기타공제_투자조합출자금액_2014년도 : etgdH14f */
//							  yetaPrc2000Vo.setEtclH15f(yeta2000Dto.getEtclH15f());    /** column 기타공제_투자조합출자금액_2015년이후 : etclH15f */
//							  yetaPrc2000Vo.setEtgdHdam(yeta2000Dto.getEtgdHdam());    /** column 기타공제투자조합출자금액계 : etgdHdam */
//							  yetaPrc2000Vo.setEtctCard(yeta2000Dto.getEtctCard());    /** column 기타공제_신용카드등사용금액 : etctCard */
//							  yetaPrc2000Vo.setEtchBcbs(yeta2000Dto.getEtchBcbs());    /** column 기타공제_직불카드등사용금액 : etchBcbs */
//							  yetaPrc2000Vo.setEtchUeam(yeta2000Dto.getEtchUeam());    /** column 기타공제_현금영수증사용금액 : etchUeam */
//							  yetaPrc2000Vo.setEtchMgvd(yeta2000Dto.getEtchMgvd());    /** column 기타공제_전통시장사용분 : etchMgvd */
//							  yetaPrc2000Vo.setEtchBced(yeta2000Dto.getEtchBced());    /** column 기타공제_지로납부_대중교통금액 : etchBced */
//							  yetaPrc2000Vo.setCardEt13(yeta2000Dto.getCardEt13());    /** column 기타공제_본인신용카드등사용액_2013 : cardEt13 */
//							  yetaPrc2000Vo.setCardEt14(yeta2000Dto.getCardEt14());    /** column 기타공제_본인신용카드등사용액_2014 : cardEt14 */
//							  yetaPrc2000Vo.setEtadDd13(yeta2000Dto.getEtadDd13());    /** column 기타공제_본인추가공재율사용액_2013 : etadDd13 */
//							  yetaPrc2000Vo.setEtadD14l(yeta2000Dto.getEtadD14l());    /** column 기타공제_본인추가공제율사용액_2014하 : etadD14l */
//							  yetaPrc2000Vo.setEtchBcue(yeta2000Dto.getEtchBcue());    /** column 기타공제_신용카드등사용공제계 : etchBcue */
//							  yetaPrc2000Vo.setEtckUnon(yeta2000Dto.getEtckUnon());    /** column 기타공제_우리사주출연금액 : etckUnon */
//							  yetaPrc2000Vo.setEtckUncb(yeta2000Dto.getEtckUncb());    /** column 기타공제_우리사주조합기부금2014이전 : etckUncb */
//							  yetaPrc2000Vo.setEtepHsam(yeta2000Dto.getEtepHsam());    /** column 기타공제_고용유지중소기업근로자임금삭감액 : etepHsam */
//							  yetaPrc2000Vo.setEtgdCtra(yeta2000Dto.getEtgdCtra());    /** column 기타공제_목돈안드는전세이자상환금액 : etgdCtra */
//							  yetaPrc2000Vo.setEtepSest(yeta2000Dto.getEtepSest());    /** column 기타공제_장기집합투자증권저축금액 : etepSest */
//							  yetaPrc2000Vo.setEtclHm01(yeta2000Dto.getEtclHm01());    /** column 기타공제_장기주식형저축_1년차_삭제 : etclHm01 */
//							  yetaPrc2000Vo.setEtclHm02(yeta2000Dto.getEtclHm02());    /** column 기타공제_장기주식형저축_2년차_삭제 : etclHm02 */
//							  yetaPrc2000Vo.setEtclHm03(yeta2000Dto.getEtclHm03());    /** column 기타공제_장기주식형저축_3년차_삭제 : etclHm03 */
//							  yetaPrc2000Vo.setEtclHmta(yeta2000Dto.getEtclHmta());    /** column 기타공제_장기주식형저축_납입합계금액_삭제 : etclHmta */
//							  yetaPrc2000Vo.setEtclEttl(yeta2000Dto.getEtclEttl());    /** column 기타공제_기타제목 : etclEttl */
//							  yetaPrc2000Vo.setEtclEtam(yeta2000Dto.getEtclEtam());    /** column 기타공제_기타금액 : etclEtam */
//							  yetaPrc2000Vo.setTaxdIncd(yeta2000Dto.getTaxdIncd());    /** column 세액공제_외국인_입국목적코드 : taxdIncd */
//							  yetaPrc2000Vo.setTaxdWkdt(yeta2000Dto.getTaxdWkdt());    /** column 세액공제_외국인_근로제공일자 : taxdWkdt */
//							  yetaPrc2000Vo.setTamaEddt(yeta2000Dto.getTamaEddt());    /** column 세액공제_외국인_감면기간만료일자 : tamaEddt */
//							  yetaPrc2000Vo.setTamaIndt(yeta2000Dto.getTamaIndt());    /** column 세액공제_외국인_감면신청접수일자 : tamaIndt */
//							  yetaPrc2000Vo.setTamaOudt(yeta2000Dto.getTamaOudt());    /** column 세액공제_외국인_감면신청제출일자 : tamaOudt */
//							  yetaPrc2000Vo.setTxlgFrrd(yeta2000Dto.getTxlgFrrd());    /** column 세액공제_외국인해저광물개발감면확인일자 : txlgFrrd */
//							  yetaPrc2000Vo.setTxlgFrid(yeta2000Dto.getTxlgFrid());    /** column 세액공제_외국인해저광물개발감면신청일자 : txlgFrid */
//							  yetaPrc2000Vo.setTxlgWkid(yeta2000Dto.getTxlgWkid());    /** column 세액공제_근로소득조세조약상면제접수일자 : txlgWkid */
//							  yetaPrc2000Vo.setTxlgTxtd(yeta2000Dto.getTxlgTxtd());    /** column 세액공제_근로소득조세조약상면제제출일자 : txlgTxtd */
//							  yetaPrc2000Vo.setTxlgBscd(yeta2000Dto.getTxlgBscd());    /** column 세액공제_중소기업청년감면취업일자 : txlgBscd */
//							  yetaPrc2000Vo.setTxlgBcde(yeta2000Dto.getTxlgBcde());    /** column 세액공제_중소기업청년감면종료일자 : txlgBcde */
//							  yetaPrc2000Vo.setTxlgItct(yeta2000Dto.getTxlgItct());    /** column 세액감면_소득세법감면세액 : txlgItct */
//							  yetaPrc2000Vo.setTxlgBsta(yeta2000Dto.getTxlgBsta());    /** column 세액감면_취업청년감면대상총급여액 : txlgBsta */
//							  yetaPrc2000Vo.setTxlgWkta(yeta2000Dto.getTxlgWkta());    /** column 세액감면_취업청년감면근로자총급여액 : txlgWkta */
//							  yetaPrc2000Vo.setTxlgClta(yeta2000Dto.getTxlgClta());    /** column 세액감면_계산감면세액금액 : txlgClta */
//							  yetaPrc2000Vo.setTxlgFrta(yeta2000Dto.getTxlgFrta());    /** column 세액감면_외국인기술자감면세액 : txlgFrta */
//							  yetaPrc2000Vo.setTxlgTxty(yeta2000Dto.getTxlgTxty());    /** column 세액감면_조세조약감면세액 : txlgTxty */
//							  yetaPrc2000Vo.setTxlgInam(yeta2000Dto.getTxlgInam());    /** column 세액공제_외국납부_국외원천소득금액 : txlgInam */
//							  yetaPrc2000Vo.setTxlgDlam(yeta2000Dto.getTxlgDlam());    /** column 세액공제_외국납부_외화납세액 : txlgDlam */
//							  yetaPrc2000Vo.setTxlgWnam(yeta2000Dto.getTxlgWnam());    /** column 세액공제_외국납부_원화납세액 : txlgWnam */
//							  yetaPrc2000Vo.setTxlgOtcy(yeta2000Dto.getTxlgOtcy());    /** column 세액공제_외국납부_납세국명 : txlgOtcy */
//							  yetaPrc2000Vo.setTxlgOtdt(yeta2000Dto.getTxlgOtdt());    /** column 세액공제_외국납부_납부일자 : txlgOtdt */
//							  yetaPrc2000Vo.setTxlgApdt(yeta2000Dto.getTxlgApdt());    /** column 세액공제_외국납부_신청서제출일자 : txlgApdt */
//							  yetaPrc2000Vo.setTxlgOuwk(yeta2000Dto.getTxlgOuwk());    /** column 세액공제_외국납부_국외근무처명 : txlgOuwk */
//							  yetaPrc2000Vo.setTxapStdt(yeta2000Dto.getTxapStdt());    /** column 세액공제_외국납부_근무시작일자 : txapStdt */
//							  yetaPrc2000Vo.setTxapEddt(yeta2000Dto.getTxapEddt());    /** column 세액공제_외국납부_근무종료일자 : txapEddt */
//							  yetaPrc2000Vo.setTxapWkdy(yeta2000Dto.getTxapWkdy());    /** column 세액공제_외국납부_직책 : txapWkdy */
//							  yetaPrc2000Vo.setTaxdUnin(yeta2000Dto.getTaxdUnin());    /** column 세액공제_납세조합공제 : taxdUnin */
//							  yetaPrc2000Vo.setTaxdLoaa(yeta2000Dto.getTaxdLoaa());    /** column 세액공제_주택차입금이자상황금액 : taxdLoaa */
//							  yetaPrc2000Vo.setAddcNtyn(yeta2000Dto.getAddcNtyn());    /** column 추가서류_연금저축등소득공제제출여부 : addcNtyn */
//							  yetaPrc2000Vo.setAddcMdyn(yeta2000Dto.getAddcMdyn());    /** column 추가서류_의료비지급명세서제출여부 : addcMdyn */
//							  yetaPrc2000Vo.setAddcCtyn(yeta2000Dto.getAddcCtyn());    /** column 추가서류_기부금명세서제출여부 : addcCtyn */
//							  yetaPrc2000Vo.setAddcPfyn(yeta2000Dto.getAddcPfyn());    /** column 추가서류_소득공제증빙서류제출여부 : addcPfyn */
//							  yetaPrc2000Vo.setAddfPvyn(yeta2000Dto.getAddfPvyn());    /** column 추가서류_종전근무지근로소득원천징수제출여부 : addfPvyn */
//							  yetaPrc2000Vo.setSpciReyn(yeta2000Dto.getSpciReyn());    /** column 추가서류_월세액_거주자_주택차입금세액공제제출여부 : spciReyn */
//							  yetaPrc2000Vo.setTxlgMxtm(yeta2000Dto.getTxlgMxtm());    /** column 추가서류_월세_비거주간상환액제출여부 : txlgMxtm */
//							  yetaPrc2000Vo.setIncoOudt(yeta2000Dto.getIncoOudt());    /** column 소득신고제출일자 : incoOudt */
//							  yetaPrc2000Vo.setIncoOufg(yeta2000Dto.getIncoOufg());    /** column 소득신고제출여부 : incoOufg */
//							  yetaPrc2000Vo.setJdocFile(yeta2000Dto.getJdocFile());    /** column 파일생성여부 : jdocFile */
//							  yetaPrc2000Vo.setJrtrAtom(yeta2000Dto.getJrtrAtom());    /** column 연금계좌계 : jrtrAtom */
//							  yetaPrc2000Vo.setJrtrTotr(yeta2000Dto.getJrtrTotr());    /** column 연금계좌공제대상금액 : jrtrTotr */
//							  yetaPrc2000Vo.setSpciHdtg(yeta2000Dto.getSpciHdtg());    /** column 특별공제_장애인보장성대상금액 : spciHdtg */
//							  yetaPrc2000Vo.setSpciDetg(yeta2000Dto.getSpciDetg());    /** column 특별공제_보장성보험료대상금액 : spciDetg */
//							  yetaPrc2000Vo.setSpciRtto(yeta2000Dto.getSpciRtto());    /** column 특별공제_보장성보험료계 : spciRtto */
//							  yetaPrc2000Vo.setSpciSftg(yeta2000Dto.getSpciSftg());    /** column 본인의료비공제대상금액 : spciSftg */
//							  yetaPrc2000Vo.setSpci65tg(yeta2000Dto.getSpci65tg());    /** column 65세이상자의료비공제대상금액 : spci65tg */
//							  yetaPrc2000Vo.setSpciPstg(yeta2000Dto.getSpciPstg());    /** column 장애인의료비공제대상금액 : spciPstg */
//							  yetaPrc2000Vo.setSpciEtcg(yeta2000Dto.getSpciEtcg());    /** column 그밖의의료비공제대상금액 : spciEtcg */
//							  yetaPrc2000Vo.setSpedSftr(yeta2000Dto.getSpedSftr());    /** column 소득자본인교육비대상금액 : spedSftr */
//							  yetaPrc2000Vo.setSpedEdtr(yeta2000Dto.getSpedEdtr());    /** column 취학전아동교육비대상금액 : spedEdtr */
//							  yetaPrc2000Vo.setSpedGdtr(yeta2000Dto.getSpedGdtr());    /** column 초중고교육비대상금액 : spedGdtr */
//							  yetaPrc2000Vo.setSpedCvtr(yeta2000Dto.getSpedCvtr());    /** column 대학생교육비대상금액 : spedCvtr */
//							  yetaPrc2000Vo.setSpciSctr(yeta2000Dto.getSpciSctr());    /** column 특수교육비공제대상금액 : spciSctr */
//							  yetaPrc2000Vo.setSpciExtg(yeta2000Dto.getSpciExtg());    /** column 특례기부금_공익법인제외대상금액 : spciExtg */
//							  yetaPrc2000Vo.setSpciUntg(yeta2000Dto.getSpciUntg());    /** column 공익법인신탁대상금액 : spciUntg */
//							  yetaPrc2000Vo.setSpciHftg(yeta2000Dto.getSpciHftg());    /** column 우리사주종합기부대상금액 : spciHftg */
//							  yetaPrc2000Vo.setSpciNatg(yeta2000Dto.getSpciNatg());    /** column 종교단체외지정대상금액 : spciNatg */
//							  yetaPrc2000Vo.setSpciYatg(yeta2000Dto.getSpciYatg());    /** column 종교단체지정대상금액 : spciYatg */
//							  yetaPrc2000Vo.setSpciDgam(yeta2000Dto.getSpciDgam());    /** column 기부금합계금액 : spciDgam */
//							  yetaPrc2000Vo.setSpciOnon(yeta2000Dto.getSpciOnon());    /** column 이월특례기부금_공익신탁금액 : spciOnon */
//							  yetaPrc2000Vo.setSpciObam(yeta2000Dto.getSpciObam());    /** column 이월법정기부금액 : spciObam */
//							  yetaPrc2000Vo.setSpciOyam(yeta2000Dto.getSpciOyam());    /** column 이월종교단체기부금 : spciOyam */
//							  yetaPrc2000Vo.setSpciOnam(yeta2000Dto.getSpciOnam());    /** column 이월종교단체외기부금 : spciOnam */
//							  yetaPrc2000Vo.setKybdr(yeta2000Dto.getKybdr());    /** column 입력자 : kybdr */
//							  yetaPrc2000Vo.setInptDt(yeta2000Dto.getInptDt());    /** column 입력일자 : inptDt */
//							  yetaPrc2000Vo.setInptAddr(yeta2000Dto.getInptAddr());    /** column 입력주소 : inptAddr */
//							  yetaPrc2000Vo.setIsmt(yeta2000Dto.getIsmt());    /** column 수정자 : ismt */
//							  yetaPrc2000Vo.setRevnDt(yeta2000Dto.getRevnDt());    /** column 수정일자 : revnDt */
//							  yetaPrc2000Vo.setRevnAddr(yeta2000Dto.getRevnAddr());    /** column 수정주소 : revnAddr */
							  
							  lstInfcPkgYeta2000Vo.add(yetaPrc2000Vo);
							 // remt2000DAO.insertRemt2000(remt2000Vo); 
						 
		               } 
	                   
		         
	                  Yeta1300ListenerAdapter yetaLsAdtr = new Yeta1300ListenerAdapter();
                      retval = yetaLsAdtr.fnYeta0300Payr06430CalcTax(RemoteServiceUtil.getThreadLocalRequest(),lstInfcPkgYeta2000Vo);
            
		        }
		        catch (Exception ex) {
		        	 
		            logger.error("EXCEPTION calling fnYeta1300Payr06430CalcTax(): "+ex); 
		            
		            /** 에러 로그 **/			
		            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C",ex, windowNm , windowId);
		             
		            throw MSFServerUtils.getOperationException("fnYeta1300Payr06430CalcTax", ex, logger);
		        }
		        finally {
		          
		        }
		        
				/** 로그반영
				 * CRUDSBLO
				 * C:create		R:read		U:update
		    	 * D:delete		S:select	B:배치 
		    	 * L:로그인		O:로그아웃
		    	 */
				MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C");
		      
		        return retval;
		} 
	   
	   
	   /** 소득공제신고자료관리 새로고침 **/
	   public Ye16Ta2000BM resultListYeta2000(Ye16Ta2000BM yeta2000Bm) throws MSFException {
			

			Yeta2000SrhVO yeta2000SrhVo = new Yeta2000SrhVO();
			MSFSysm0100BM sessionUser;
			
			String method = calledClass + ".resultListYeta2000";
			
			String windowNm = "소득공제신고자료관리";
			String windowId = "YETA1300";
			
			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}


			if  (MSFSharedUtils.paramNull(yeta2000DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				yeta2000DAO = (Ye16Ta2000DAO) wac.getBean("Ye16Ta2000DAO" ); 
			}
			
			List<String> listDeptCd = new ArrayList<String>();  

			/** 조건절 */
	    	yeta2000SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	    	yeta2000SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(yeta2000Bm.getSettGbcd()));//정산구분
	    	yeta2000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
	     	
	    	yeta2000SrhVo.setUsrId(sessionUser.getUsrId());
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	yeta2000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
               yeta2000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	yeta2000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(yeta2000Bm.getPayrMangDeptCd())) ;   //단위기관코드   
                     if (yeta2000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yeta2000Bm.getDeptCd()))) { 
                     	 listDeptCd = null; 
                     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
                     	yeta2000SrhVo.setDeptCd("");  //부서코드
                     } else {
                    	 yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(yeta2000Bm.getDeptCd()));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta2000Bm.getDeptCd()));  
                          yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
            }
            
//            } else {
//            	
//            }
            
            yeta2000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(yeta2000Bm.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
            yeta2000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yeta2000Bm.getDtilOccuInttnCd()).replace(",", ""));   
            
           /******************************** 권한 ************************************************************************/
	     	
	     	
	        yeta2000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(yeta2000Bm.getEmymtDivCd()));       //고용구분코드
	            
//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta2000Bm.getTypOccuCd())); 
	      	yeta2000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	     	yeta2000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(yeta2000Bm.getTypOccuCd()));  //직종
	           
//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta2000Bm.getDtilOccuInttnCd())); 
	      	yeta2000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	yeta2000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(yeta2000Bm.getDtilOccuInttnCd())); //직종세
	             
	    	yeta2000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(yeta2000Bm.getBusinCd()));   //사업코드
	           
	           
	    	yeta2000SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta2000Bm.getEdacRvyy())); //년도
	       	yeta2000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(yeta2000Bm.getSystemkey()));  //시스템키
	      	yeta2000SrhVo.setHanNm(MSFSharedUtils.allowNulls(yeta2000Bm.getHanNm()));    //한글성명 
	      	
	    	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
//	      	SysIfBass0320VO  sysIfBass0320Vo = new SysIfBass0320VO();
//	     	 List<String> listTypCd = new ArrayList<String>(); 
//	     	 
//	     	sysIfBass0320Vo.setYmdGb("Y");
//	     	sysIfBass0320Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYr")));
//	     	sysIfBass0320Vo.setTypOccuCd(psnl0100SrhVO.getTypOccuCd());
//	     	sysIfBass0320Vo.setTypOccuCdArr(lstTypeOccuCd); 
//	     	
//	     	listTypCd = SysifPkgServiceUtils.funcArrBeforTypOccuCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0320Vo);
	     	
	     	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
	     //	 List<String> listTyInttnCd = new ArrayList<String>(); 
	     	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
	     	sysIfBass0350Vo.setYmdGb("Y");
	     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(yeta2000Bm.getEdacRvyy()));
	     	sysIfBass0350Vo.setTypOccuCd(yeta2000SrhVo.getTypOccuCd());
	     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
	    	sysIfBass0350Vo.setDtilOccuInttnCd(yeta2000SrhVo.getDtilOccuInttnCd());
	     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	
	     	try {
				sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	     
	     	yeta2000SrhVo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
	     	yeta2000SrhVo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
	     	
	     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/ 	

			int iResultCnt = yeta2000DAO.selectYeta0300To2000ListTotCnt(yeta2000SrhVo);  
			
			Ye16Ta2000BM returnYeta2000 = new Ye16Ta2000BM();
			List egovResultDataList = new ArrayList();

			try {
				
				egovResultDataList =  yeta2000DAO.selectYeta0300To2000List(yeta2000SrhVo);
				
				// 2.복호화 리턴받을 값 선언
				String rrnDecCrypt = "";

				if(egovResultDataList != null && egovResultDataList.size() > 0){
					for(int i = 0 ; i < egovResultDataList.size(); i++){

						// 1. 암호화 객체 생성
						String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

						Map tempMap = (Map)egovResultDataList.get(i);
						Iterator<String> keys = tempMap.keySet().iterator();
						while( keys.hasNext() ){
				            String key = keys.next();
				            //형 타입이 숫자형일경우 형변환 해준다.
			            	if(tempMap.get(key) instanceof java.math.BigDecimal){
			            		returnYeta2000.set(key, String.valueOf(tempMap.get(key)));
			            	}else{
			            		
			            		if("resnRegnNum".equals(key)) {
			            			// 복호화
			            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get(key))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
			            			returnYeta2000.set(key, rrnDecCrypt);
			            			
			            		}else {
			            			
			            			returnYeta2000.set(key, tempMap.get(key));
			            		}
			            	}
			            }
					}
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
				
				// Return operation exception
			}
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
			return returnYeta2000;
		}

	   /**
	    * 
	    * <pre>
	    * 1. 개요 : 세액 계산을 전체 돌린다. 시간 걸림.  
	    * 2. 처리내용 : 
	    * </pre>
	    * @Method Name : fnYeta0300Payr06430CalcTax
	    * @date : Feb 25, 2016
	    * @author : leeheuisung
	    * @history : 
	    *	-----------------------------------------------------------------------
	    *	변경일				작성자						변경내용  
	    *	----------- ------------------- ---------------------------------------
	    *	Feb 25, 2016		leeheuisung				최초 작성 
	    *	-----------------------------------------------------------------------
	    * 
	    * @see com.app.exterms.yearendtax.client.service.yeta2015.Yeta1300Service#fnYeta0300Payr06430CalcTax(java.util.List)
	    * @param listYeta2000Dto
	    * @return
	    * @throws MSFException
	    */
	   @Override
		 public PagingLoadResult<ShowMessageBM> fnYeta1300Payr06430AllCalcTax(Ye16Ta2000DTO yeta2000Dto) throws MSFException {

		        PagingLoadResult<ShowMessageBM> retval = null;
		        
		    	String windowNm = "소득공제신고자료관리";
				String windowId = "YETA1300";
		   
		    	String method = calledClass + ".fnYeta1300Payr06430AllCalcTax";
		        MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		        
		    
		    	if  (MSFSharedUtils.paramNull(yeta2000DAO)) {
					WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
					yeta2000DAO = (Ye16Ta2000DAO) wac.getBean("Ye16Ta2000DAO" ); 
				}
		    	
		        try {  
		        	  List<InfcPkgYeta2000VO>  lstInfcPkgYeta2000Vo = new ArrayList<InfcPkgYeta2000VO>();
		        	 
		        	  Yeta2000SrhVO   yeta2000SrhVo = new  Yeta2000SrhVO();
					  List<Yeta2000VO> lstYeta2000VO = new ArrayList<Yeta2000VO>();
					  yeta2000SrhVo.setDpobCd(yeta2000Dto.getDpobCd());    /** column 사업장코드 : dpobCd */
					  yeta2000SrhVo.setEdacRvyy(yeta2000Dto.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
					  yeta2000SrhVo.setSettGbcd(yeta2000Dto.getSettGbcd());    /** column 정산구분코드 : settGbcd */
					   
		        	  
					  lstYeta2000VO =  (List<Yeta2000VO>)yeta2000DAO.selectYeta0300AllToYeta2000List(yeta2000SrhVo);
					  
	                  for (int iCnt = 0;iCnt < lstYeta2000VO.size();iCnt++) { 
	                		
	                	  // 1. 암호화 객체 생성
	      		    	String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
	      		        
	                	      InfcPkgYeta2000VO  yetaPrc2000Vo = new InfcPkgYeta2000VO();
	                	      Yeta2000VO  yeta2000Vo = new Yeta2000VO(); 
							  
							  yeta2000Vo = (Yeta2000VO) lstYeta2000VO.get(iCnt); 
							  
							 
							  yetaPrc2000Vo.setDpobCd(yeta2000Vo.getDpobCd());    /** column 사업장코드 : dpobCd */
							  yetaPrc2000Vo.setEdacRvyy(yeta2000Vo.getEdacRvyy());    /** column 연말정산귀속년도 : edacRvyy */
							  yetaPrc2000Vo.setSettGbcd(yeta2000Vo.getSettGbcd());    /** column 정산구분코드 : settGbcd */
							  yetaPrc2000Vo.setSystemkey(yeta2000Vo.getSystemkey());    /** column SYSTEMKEY : systemkey */
							  yetaPrc2000Vo.setEdacSeilNum(yeta2000Vo.getEdacSeilNum());    /** column 연말정산마감일련번호 : edacSeilNum */
							  yetaPrc2000Vo.setPayrMangDeptCd(yeta2000Vo.getPayrMangDeptCd());    /** column 급여관리부서코드 : payrMangDeptCd */
							  yetaPrc2000Vo.setEmymtDivCd(yeta2000Vo.getEmymtDivCd());    /** column 고용구분코드 : emymtDivCd */
							  yetaPrc2000Vo.setHanNm(yeta2000Vo.getHanNm());    /** column 한글성명 : hanNm */
//							  yetaPrc2000Vo.setResnRegnNum(yeta2000Vo.getResnRegnNum());    /** column 주민등록번호 : resnRegnNum */
							  
							  // 암호화
							  yetaPrc2000Vo.setResnRegnNum(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta2000Vo.getHanNm()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
							  
							  yetaPrc2000Vo.setDeptCd(yeta2000Vo.getDeptCd());    /** column 부서코드 : deptCd */
							  yetaPrc2000Vo.setBusinCd(yeta2000Vo.getBusinCd());    /** column 사업코드 : businCd */
							  yetaPrc2000Vo.setTypOccuCd(yeta2000Vo.getTypOccuCd());    /** column 직종코드 : typOccuCd */
							  yetaPrc2000Vo.setDtilOccuInttnCd(yeta2000Vo.getDtilOccuInttnCd());    /** column 직종세통합코드 : dtilOccuInttnCd */
							  yetaPrc2000Vo.setDtilOccuClsDivCd(yeta2000Vo.getDtilOccuClsDivCd());    /** column 직종세구분코드 : dtilOccuClsDivCd */
							  yetaPrc2000Vo.setOdtyCd(yeta2000Vo.getOdtyCd());    /** column 직책코드 : odtyCd */
							  yetaPrc2000Vo.setPyspCd(yeta2000Vo.getPyspCd());    /** column 호봉코드 : pyspCd */
							  yetaPrc2000Vo.setPyspGrdeCd(yeta2000Vo.getPyspGrdeCd());    /** column 호봉등급코드 : pyspGrdeCd */
							  yetaPrc2000Vo.setLogSvcYrNumCd(yeta2000Vo.getLogSvcYrNumCd());    /** column 근속년수코드 : logSvcYrNumCd */
							  yetaPrc2000Vo.setLogSvcMnthIcmCd(yeta2000Vo.getLogSvcMnthIcmCd());    /** column 근속월수코드 : logSvcMnthIcmCd */
							  yetaPrc2000Vo.setFrstEmymtDt(yeta2000Vo.getFrstEmymtDt());    /** column 최초고용일자 : frstEmymtDt */
							  yetaPrc2000Vo.setEmymtBgnnDt(yeta2000Vo.getEmymtBgnnDt());    /** column 고용시작일자 : emymtBgnnDt */
							  yetaPrc2000Vo.setEmymtEndDt(yeta2000Vo.getEmymtEndDt());    /** column 고용종료일자 : emymtEndDt */
							  yetaPrc2000Vo.setHdofcDivCd(yeta2000Vo.getHdofcDivCd());    /** column 재직구분코드 : hdofcDivCd */
							  yetaPrc2000Vo.setRetryDt(yeta2000Vo.getRetryDt());    /** column 퇴직일자 : retryDt */
//							  yetaPrc2000Vo.setYrtxApptnYrMnth(yeta2000Vo.getYrtxApptnYrMnth());    /** column 연말정산적용년월 : yrtxApptnYrMnth */
//							  yetaPrc2000Vo.setYrtxPrcsDt(yeta2000Vo.getYrtxPrcsDt());    /** column 연말정산처리일자 : yrtxPrcsDt */
//							  yetaPrc2000Vo.setYrtxPrcsYn(yeta2000Vo.getYrtxPrcsYn());    /** column 연말정산처리여부 : yrtxPrcsYn */
//							  yetaPrc2000Vo.setDivdPymtDivCd(yeta2000Vo.getDivdPymtDivCd());    /** column 분할납부구분코드 : divdPymtDivCd */
//							  yetaPrc2000Vo.setDivdPymt(yeta2000Vo.getDivdPymt());    /** column 분할납부횟수 : divdPymt */
//							  yetaPrc2000Vo.setGnanSgtf(yeta2000Vo.getGnanSgtf());    /** column 세대주여부 : gnanSgtf */
//							  yetaPrc2000Vo.setFrnrYeno(yeta2000Vo.getFrnrYeno());    /** column 외국인구분코드 : frnrYeno */
//							  yetaPrc2000Vo.setReymStdt(yeta2000Vo.getReymStdt());    /** column 귀속년월_FROM : reymStdt */
//							  yetaPrc2000Vo.setReymEddt(yeta2000Vo.getReymEddt());    /** column 귀속년월_TO : reymEddt */
//							  yetaPrc2000Vo.setRutrEddt(yeta2000Vo.getRutrEddt());    /** column 감면기간_TO : rutrEddt */
//							  yetaPrc2000Vo.setRutrStdt(yeta2000Vo.getRutrStdt());    /** column 감면기간_FROM : rutrStdt */
//							  yetaPrc2000Vo.setResdFlag(yeta2000Vo.getResdFlag());    /** column 거주구분여부 : resdFlag */
//							  yetaPrc2000Vo.setNatnGbcd(yeta2000Vo.getNatnGbcd());    /** column 국적코드 : natnGbcd */
//							  yetaPrc2000Vo.setNatnName(yeta2000Vo.getNatnName());    /** column 국적명 : natnName */
//							  yetaPrc2000Vo.setRedtGbcd(yeta2000Vo.getRedtGbcd());    /** column 거주지국코드 : redtGbcd */
//							  yetaPrc2000Vo.setRedtName(yeta2000Vo.getRedtName());    /** column 거주지국명 : redtName */
//							  yetaPrc2000Vo.setHumnCgue(yeta2000Vo.getHumnCgue());    /** column 인적공제항목변동여부 : humnCgue */
//							  yetaPrc2000Vo.setFrnrSgyn(yeta2000Vo.getFrnrSgyn());    /** column 외국인단일세율적용여부 : frnrSgyn */
//							  yetaPrc2000Vo.setBaseWiyn(yeta2000Vo.getBaseWiyn());    /** column 기본공제_배우자유무 : baseWiyn */
//							  yetaPrc2000Vo.setBaseFmly(yeta2000Vo.getBaseFmly());    /** column 기본공제_부양가족수 : baseFmly */
//							  yetaPrc2000Vo.setAddrCt70(yeta2000Vo.getAddrCt70());    /** column 추가공제_경로우대_70세이상수 : addrCt70 */
//							  yetaPrc2000Vo.setAddrHdrc(yeta2000Vo.getAddrHdrc());    /** column 추가공제_장애인수 : addrHdrc */
//							  yetaPrc2000Vo.setAddrFdsu(yeta2000Vo.getAddrFdsu());    /** column 추가공제_부녀자수 : addrFdsu */
//							  yetaPrc2000Vo.setAddrClct(yeta2000Vo.getAddrClct());    /** column 추가공제_자녀양육비양육수 : addrClct */
//							  yetaPrc2000Vo.setAddrBhct(yeta2000Vo.getAddrBhct());    /** column 추가공제_출산자녀양육수 : addrBhct */
//							  yetaPrc2000Vo.setPantOnsu(yeta2000Vo.getPantOnsu());    /** column 추가공제_한부모수 : pantOnsu */
//							  yetaPrc2000Vo.setAddrMrct(yeta2000Vo.getAddrMrct());    /** column 추가공제_다자녀인원수 : addrMrct */
//							  yetaPrc2000Vo.setBnatPsnf(yeta2000Vo.getBnatPsnf());    /** column 종근무지_국민연금보험료 : bnatPsnf */
//							  yetaPrc2000Vo.setJnatPsnf(yeta2000Vo.getJnatPsnf());    /** column 주근무지_국민연금보험료 : jnatPsnf */
//							  yetaPrc2000Vo.setBpssTech(yeta2000Vo.getBpssTech());    /** column 종근무지_국민연금외교직원연금 : bpssTech */
//							  yetaPrc2000Vo.setBpssPulc(yeta2000Vo.getBpssPulc());    /** column 종근무지_국민연금외공무원연금 : bpssPulc */
//							  yetaPrc2000Vo.setBpssFect(yeta2000Vo.getBpssFect());    /** column 종근무지_국민연금외별정우체국 : bpssFect */
//							  yetaPrc2000Vo.setBpssSold(yeta2000Vo.getBpssSold());    /** column 종근무지_국민연금외군인연금 : bpssSold */
//							  yetaPrc2000Vo.setJpssPulc(yeta2000Vo.getJpssPulc());    /** column 주근무지_국민연금외공무원연금 : jpssPulc */
//							  yetaPrc2000Vo.setJpssSold(yeta2000Vo.getJpssSold());    /** column 주근무지_국민연금외군인연금 : jpssSold */
//							  yetaPrc2000Vo.setJpssTech(yeta2000Vo.getJpssTech());    /** column 주근무지_국인연금외교직원연금 : jpssTech */
//							  yetaPrc2000Vo.setJpssFect(yeta2000Vo.getJpssFect());    /** column 주근무지_국민연금외별정우체국 : jpssFect */
//							  yetaPrc2000Vo.setBrtrPsct(yeta2000Vo.getBrtrPsct());    /** column 종근무지_종_근로자퇴직보장법 : brtrPsct */
//							  yetaPrc2000Vo.setBrtrCict(yeta2000Vo.getBrtrCict());    /** column 종근무지_종_과학기술인공제 : brtrCict */
//							  yetaPrc2000Vo.setBrtrAnsv(yeta2000Vo.getBrtrAnsv());    /** column 종근무지_연금계좌_연금저축 : brtrAnsv */
//							  yetaPrc2000Vo.setJrtrCict(yeta2000Vo.getJrtrCict());    /** column 주근무지_퇴직연금과학기술인공제 : jrtrCict */
//							  yetaPrc2000Vo.setJrtrCtar(yeta2000Vo.getJrtrCtar());    /** column 주근무지_퇴직연금과학기술인공제대상금액 : jrtrCtar */
//							  yetaPrc2000Vo.setJrtrPsct(yeta2000Vo.getJrtrPsct());    /** column 주근무지_퇴직연금근로자퇴직급여보장법 : jrtrPsct */
//							  yetaPrc2000Vo.setJrtrPtar(yeta2000Vo.getJrtrPtar());    /** column 주근무지_퇴직연금근로자퇴직급여보장대상금액 : jrtrPtar */
//							  yetaPrc2000Vo.setJrtrAnsv(yeta2000Vo.getJrtrAnsv());    /** column 주근무지_연금계좌_연금저축 : jrtrAnsv */
//							  yetaPrc2000Vo.setJrtrAtar(yeta2000Vo.getJrtrAtar());    /** column 주근무지_연금계좌저축공제대상금액 : jrtrAtar */
//							  yetaPrc2000Vo.setRrptAmnt(yeta2000Vo.getRrptAmnt());    /** column 연금보험료계 : rrptAmnt */
//							  yetaPrc2000Vo.setSpciBhlh(yeta2000Vo.getSpciBhlh());    /** column 특별공제_종건강보험료 : spciBhlh */
//							  yetaPrc2000Vo.setSpciHhlh(yeta2000Vo.getSpciHhlh());    /** column 특별공제_주건강보험료 : spciHhlh */
//							  yetaPrc2000Vo.setSpciBepf(yeta2000Vo.getSpciBepf());    /** column 특별공제_종고용보험료 : spciBepf */
//							  yetaPrc2000Vo.setSpciJepf(yeta2000Vo.getSpciJepf());    /** column 특별공제_주고용보험료 : spciJepf */
//							  yetaPrc2000Vo.setSpciGurt(yeta2000Vo.getSpciGurt());    /** column 특별공제_일반보장성보험료 : spciGurt */
//							  yetaPrc2000Vo.setSpciHdrc(yeta2000Vo.getSpciHdrc());    /** column 특별공제_장애인전용보험료 : spciHdrc */
//							  yetaPrc2000Vo.setSpciRttg(yeta2000Vo.getSpciRttg());    /** column 특별공제_보장성보험료공제대상금액 : spciRttg */
//							  yetaPrc2000Vo.setSpciIuam(yeta2000Vo.getSpciIuam());    /** column 특별공제_보험료계 : spciIuam */
//							  yetaPrc2000Vo.setSpciSelf(yeta2000Vo.getSpciSelf());    /** column 특별공제_의료비_본인 : spciSelf */
//							  yetaPrc2000Vo.setSpciAe65(yeta2000Vo.getSpciAe65());    /** column 특별공제_의료비_경로65세이상 : spciAe65 */
//							  yetaPrc2000Vo.setSpciDbps(yeta2000Vo.getSpciDbps());    /** column 특별공제_의료비_장애인 : spciDbps */
//							  yetaPrc2000Vo.setSpciDetc(yeta2000Vo.getSpciDetc());    /** column 특별공제_의료비_기타공제대상자 : spciDetc */
//							  yetaPrc2000Vo.setSpciDtar(yeta2000Vo.getSpciDtar());    /** column 특별공제_의료비세액공제대상금액 : spciDtar */
//							  yetaPrc2000Vo.setSpciEtam(yeta2000Vo.getSpciEtam());    /** column 특별공제_의료비계 : spciEtam */
//							  yetaPrc2000Vo.setSpedSelf(yeta2000Vo.getSpedSelf());    /** column 특별공제_교육비_본인 : spedSelf */
//							  yetaPrc2000Vo.setSpedEdsu(yeta2000Vo.getSpedEdsu());    /** column 특별공제_교육비_취학전아동수 : spedEdsu */
//							  yetaPrc2000Vo.setSpedEdam(yeta2000Vo.getSpedEdam());    /** column 특별공제_교육비_취학전아동 : spedEdam */
//							  yetaPrc2000Vo.setSpedGdsu(yeta2000Vo.getSpedGdsu());    /** column 특별공제_교육비_초중고자녀수 : spedGdsu */
//							  yetaPrc2000Vo.setSpedGdam(yeta2000Vo.getSpedGdam());    /** column 특별공제_교육비_초중고 : spedGdam */
//							  yetaPrc2000Vo.setSpedCvsu(yeta2000Vo.getSpedCvsu());    /** column 특별공제_교육비_대학생수 : spedCvsu */
//							  yetaPrc2000Vo.setSpedCvam(yeta2000Vo.getSpedCvam());    /** column 특별공제_교육비_대학교 : spedCvam */
//							  yetaPrc2000Vo.setSpciScsu(yeta2000Vo.getSpciScsu());    /** column 특별공제_장애인수 : spciScsu */
//							  yetaPrc2000Vo.setSpciScam(yeta2000Vo.getSpciScam());    /** column 특별공제_장애인특수교육비 : spciScam */
//							  yetaPrc2000Vo.setSpedEtar(yeta2000Vo.getSpedEtar());    /** column 특별공제_교육비공제대상금액 : spedEtar */
//							  yetaPrc2000Vo.setSiedToam(yeta2000Vo.getSiedToam());    /** column 특별공제_교육비계 : siedToam */
//							  yetaPrc2000Vo.setSpciRefn(yeta2000Vo.getSpciRefn());    /** column 특별공제_차입금원리금상환액_대출기관 : spciRefn */
//							  yetaPrc2000Vo.setSpciResf(yeta2000Vo.getSpciResf());    /** column 특별공제_차입금원리금상환액_거주자 : spciResf */
//							  yetaPrc2000Vo.setSpciHtam(yeta2000Vo.getSpciHtam());    /** column 특별공제_주택자금_월세금액 : spciHtam */
//							  yetaPrc2000Vo.setSpchRefn(yeta2000Vo.getSpchRefn());    /** column 특별공제_장기주택이자상환액 : spchRefn */
//							  yetaPrc2000Vo.setSpchRe06(yeta2000Vo.getSpchRe06());    /** column 특별공제_11장기주택저당차입금15 : spchRe06 */
//							  yetaPrc2000Vo.setSpchRe10(yeta2000Vo.getSpchRe10());    /** column 특별공제_11장기주택저당차입금29 : spchRe10 */
//							  yetaPrc2000Vo.setSpchRe20(yeta2000Vo.getSpchRe20());    /** column 특별공제_11장기주택저당차입금30 : spchRe20 */
//							  yetaPrc2000Vo.setSpchRefx(yeta2000Vo.getSpchRefx());    /** column 특별공제_12장기주택저당차입금_고정 : spchRefx */
//							  yetaPrc2000Vo.setSpchReec(yeta2000Vo.getSpchReec());    /** column 특별공제_12장기주택저당차입금_기타 : spchReec */
//							  yetaPrc2000Vo.setSpch15fx(yeta2000Vo.getSpch15fx());    /** column 특별공제_15장기주택저당_15고정AND비거치상환 : spch15fx */
//							  yetaPrc2000Vo.setSpch15fb(yeta2000Vo.getSpch15fb());    /** column 특별공제_15장기주택저당_15고정OR비거치상환 : spch15fb */
//							  yetaPrc2000Vo.setSpch15ec(yeta2000Vo.getSpch15ec());    /** column 특별공제_15장기주택저당_15기타대출 : spch15ec */
//							  yetaPrc2000Vo.setSpch10fb(yeta2000Vo.getSpch10fb());    /** column 특별공제_15장기주택저당_10고정OR비거치상환 : spch10fb */
//							  yetaPrc2000Vo.setSpch10ec(yeta2000Vo.getSpch10ec());    /** column 특별공제_15장기주택저당_10기타대출 : spch10ec */
//							  yetaPrc2000Vo.setTaxdPltc(yeta2000Vo.getTaxdPltc());    /** column 세액공제_기부정치자금금액 : taxdPltc */
//							  yetaPrc2000Vo.setTaxd10tg(yeta2000Vo.getTaxd10tg());    /** column 특별공제_기부정치자금_10이하대상금액 : taxd10tg */
//							  yetaPrc2000Vo.setSpciPltc(yeta2000Vo.getSpciPltc());    /** column 특별공제_기부금_정치 : spciPltc */
//							  yetaPrc2000Vo.setSpciPltg(yeta2000Vo.getSpciPltg());    /** column 특별공제_기부금_정치10초과대상금액 : spciPltg */
//							  yetaPrc2000Vo.setSpciFbam(yeta2000Vo.getSpciFbam());    /** column 특별공제_기부금_법정 : spciFbam */
//							  yetaPrc2000Vo.setSpciFbtg(yeta2000Vo.getSpciFbtg());    /** column 특별공제_기부금_법정대상금액 : spciFbtg */
//							  yetaPrc2000Vo.setSpciExam(yeta2000Vo.getSpciExam());    /** column 특별공제_기부금_특례_공익법인신탁제외 : spciExam */
//							  yetaPrc2000Vo.setSpciUnon(yeta2000Vo.getSpciUnon());    /** column 특별공제_기부금_공익법인신탁특례 : spciUnon */
//							  yetaPrc2000Vo.setSpciHfam(yeta2000Vo.getSpciHfam());    /** column 특별공제_기부금_우리사주조합2015이후 : spciHfam */
//							  yetaPrc2000Vo.setSpciYamt(yeta2000Vo.getSpciYamt());    /** column 특별공제_기부금_종교단체 : spciYamt */
//							  yetaPrc2000Vo.setSpciNamt(yeta2000Vo.getSpciNamt());    /** column 특별공제_기부금_종교단체외 : spciNamt */
//							  yetaPrc2000Vo.setSpciDgtg(yeta2000Vo.getSpciDgtg());    /** column 특별공제_지정기부금대상금액 : spciDgtg */
//							  yetaPrc2000Vo.setSpciFnrl(yeta2000Vo.getSpciFnrl());    /** column 특별공제_혼인_이사_장례비_삭제 : spciFnrl */
//							  yetaPrc2000Vo.setPrvm20be(yeta2000Vo.getPrvm20be());    /** column 개인연금저축불입액_2000년이전 : prvm20be */
//							  yetaPrc2000Vo.setPrvm21af(yeta2000Vo.getPrvm21af());    /** column 개인연금저축불입액_2001년이후_삭제 : prvm21af */
//							  yetaPrc2000Vo.setEtchPrep(yeta2000Vo.getEtchPrep());    /** column 기타공제_소기업공제불입금액 : etchPrep */
//							  yetaPrc2000Vo.setEtcsComp(yeta2000Vo.getEtcsComp());    /** column 기타공제_주택마련저축_청약저축 : etcsComp */
//							  yetaPrc2000Vo.setEtwkHsvm(yeta2000Vo.getEtwkHsvm());    /** column 기타공제_주택마련저축_근로자주택마련저축 : etwkHsvm */
//							  yetaPrc2000Vo.setEtwkHsbm(yeta2000Vo.getEtwkHsbm());    /** column 기타공제_주택마련저축_주택청약종합저축 : etwkHsbm */
//							  yetaPrc2000Vo.setEtwkHlgm(yeta2000Vo.getEtwkHlgm());    /** column 기타공제_주택마련저축_장기주택마련저축_del : etwkHlgm */
//							  yetaPrc2000Vo.setEtwkHbdm(yeta2000Vo.getEtwkHbdm());    /** column 기타공제_주택마련저축소득금액 : etwkHbdm */
//							  yetaPrc2000Vo.setEtctConc(yeta2000Vo.getEtctConc());    /** column 기타공제_투자조합출자금액_2011이전 : etctConc */
//							  yetaPrc2000Vo.setEtgdH09f(yeta2000Vo.getEtgdH09f());    /** column 기타공제_투자조합출자금액_2012년도 : etgdH09f */
//							  yetaPrc2000Vo.setEtgdH13f(yeta2000Vo.getEtgdH13f());    /** column 기타공제_투자조합출자금액_2013년도 : etgdH13f */
//							  yetaPrc2000Vo.setEtgdH14f(yeta2000Vo.getEtgdH14f());    /** column 기타공제_투자조합출자금액_2014년도 : etgdH14f */
//							  yetaPrc2000Vo.setEtclH15f(yeta2000Vo.getEtclH15f());    /** column 기타공제_투자조합출자금액_2015년이후 : etclH15f */
//							  yetaPrc2000Vo.setEtgdHdam(yeta2000Vo.getEtgdHdam());    /** column 기타공제투자조합출자금액계 : etgdHdam */
//							  yetaPrc2000Vo.setEtctCard(yeta2000Vo.getEtctCard());    /** column 기타공제_신용카드등사용금액 : etctCard */
//							  yetaPrc2000Vo.setEtchBcbs(yeta2000Vo.getEtchBcbs());    /** column 기타공제_직불카드등사용금액 : etchBcbs */
//							  yetaPrc2000Vo.setEtchUeam(yeta2000Vo.getEtchUeam());    /** column 기타공제_현금영수증사용금액 : etchUeam */
//							  yetaPrc2000Vo.setEtchMgvd(yeta2000Vo.getEtchMgvd());    /** column 기타공제_전통시장사용분 : etchMgvd */
//							  yetaPrc2000Vo.setEtchBced(yeta2000Vo.getEtchBced());    /** column 기타공제_지로납부_대중교통금액 : etchBced */
//							  yetaPrc2000Vo.setCardEt13(yeta2000Vo.getCardEt13());    /** column 기타공제_본인신용카드등사용액_2013 : cardEt13 */
//							  yetaPrc2000Vo.setCardEt14(yeta2000Vo.getCardEt14());    /** column 기타공제_본인신용카드등사용액_2014 : cardEt14 */
//							  yetaPrc2000Vo.setEtadDd13(yeta2000Vo.getEtadDd13());    /** column 기타공제_본인추가공재율사용액_2013 : etadDd13 */
//							  yetaPrc2000Vo.setEtadD14l(yeta2000Vo.getEtadD14l());    /** column 기타공제_본인추가공제율사용액_2014하 : etadD14l */
//							  yetaPrc2000Vo.setEtchBcue(yeta2000Vo.getEtchBcue());    /** column 기타공제_신용카드등사용공제계 : etchBcue */
//							  yetaPrc2000Vo.setEtckUnon(yeta2000Vo.getEtckUnon());    /** column 기타공제_우리사주출연금액 : etckUnon */
//							  yetaPrc2000Vo.setEtckUncb(yeta2000Vo.getEtckUncb());    /** column 기타공제_우리사주조합기부금2014이전 : etckUncb */
//							  yetaPrc2000Vo.setEtepHsam(yeta2000Vo.getEtepHsam());    /** column 기타공제_고용유지중소기업근로자임금삭감액 : etepHsam */
//							  yetaPrc2000Vo.setEtgdCtra(yeta2000Vo.getEtgdCtra());    /** column 기타공제_목돈안드는전세이자상환금액 : etgdCtra */
//							  yetaPrc2000Vo.setEtepSest(yeta2000Vo.getEtepSest());    /** column 기타공제_장기집합투자증권저축금액 : etepSest */
//							  yetaPrc2000Vo.setEtclHm01(yeta2000Vo.getEtclHm01());    /** column 기타공제_장기주식형저축_1년차_삭제 : etclHm01 */
//							  yetaPrc2000Vo.setEtclHm02(yeta2000Vo.getEtclHm02());    /** column 기타공제_장기주식형저축_2년차_삭제 : etclHm02 */
//							  yetaPrc2000Vo.setEtclHm03(yeta2000Vo.getEtclHm03());    /** column 기타공제_장기주식형저축_3년차_삭제 : etclHm03 */
//							  yetaPrc2000Vo.setEtclHmta(yeta2000Vo.getEtclHmta());    /** column 기타공제_장기주식형저축_납입합계금액_삭제 : etclHmta */
//							  yetaPrc2000Vo.setEtclEttl(yeta2000Vo.getEtclEttl());    /** column 기타공제_기타제목 : etclEttl */
//							  yetaPrc2000Vo.setEtclEtam(yeta2000Vo.getEtclEtam());    /** column 기타공제_기타금액 : etclEtam */
//							  yetaPrc2000Vo.setTaxdIncd(yeta2000Vo.getTaxdIncd());    /** column 세액공제_외국인_입국목적코드 : taxdIncd */
//							  yetaPrc2000Vo.setTaxdWkdt(yeta2000Vo.getTaxdWkdt());    /** column 세액공제_외국인_근로제공일자 : taxdWkdt */
//							  yetaPrc2000Vo.setTamaEddt(yeta2000Vo.getTamaEddt());    /** column 세액공제_외국인_감면기간만료일자 : tamaEddt */
//							  yetaPrc2000Vo.setTamaIndt(yeta2000Vo.getTamaIndt());    /** column 세액공제_외국인_감면신청접수일자 : tamaIndt */
//							  yetaPrc2000Vo.setTamaOudt(yeta2000Vo.getTamaOudt());    /** column 세액공제_외국인_감면신청제출일자 : tamaOudt */
//							  yetaPrc2000Vo.setTxlgFrrd(yeta2000Vo.getTxlgFrrd());    /** column 세액공제_외국인해저광물개발감면확인일자 : txlgFrrd */
//							  yetaPrc2000Vo.setTxlgFrid(yeta2000Vo.getTxlgFrid());    /** column 세액공제_외국인해저광물개발감면신청일자 : txlgFrid */
//							  yetaPrc2000Vo.setTxlgWkid(yeta2000Vo.getTxlgWkid());    /** column 세액공제_근로소득조세조약상면제접수일자 : txlgWkid */
//							  yetaPrc2000Vo.setTxlgTxtd(yeta2000Vo.getTxlgTxtd());    /** column 세액공제_근로소득조세조약상면제제출일자 : txlgTxtd */
//							  yetaPrc2000Vo.setTxlgBscd(yeta2000Vo.getTxlgBscd());    /** column 세액공제_중소기업청년감면취업일자 : txlgBscd */
//							  yetaPrc2000Vo.setTxlgBcde(yeta2000Vo.getTxlgBcde());    /** column 세액공제_중소기업청년감면종료일자 : txlgBcde */
//							  yetaPrc2000Vo.setTxlgItct(yeta2000Vo.getTxlgItct());    /** column 세액감면_소득세법감면세액 : txlgItct */
//							  yetaPrc2000Vo.setTxlgBsta(yeta2000Vo.getTxlgBsta());    /** column 세액감면_취업청년감면대상총급여액 : txlgBsta */
//							  yetaPrc2000Vo.setTxlgWkta(yeta2000Vo.getTxlgWkta());    /** column 세액감면_취업청년감면근로자총급여액 : txlgWkta */
//							  yetaPrc2000Vo.setTxlgClta(yeta2000Vo.getTxlgClta());    /** column 세액감면_계산감면세액금액 : txlgClta */
//							  yetaPrc2000Vo.setTxlgFrta(yeta2000Vo.getTxlgFrta());    /** column 세액감면_외국인기술자감면세액 : txlgFrta */
//							  yetaPrc2000Vo.setTxlgTxty(yeta2000Vo.getTxlgTxty());    /** column 세액감면_조세조약감면세액 : txlgTxty */
//							  yetaPrc2000Vo.setTxlgInam(yeta2000Vo.getTxlgInam());    /** column 세액공제_외국납부_국외원천소득금액 : txlgInam */
//							  yetaPrc2000Vo.setTxlgDlam(yeta2000Vo.getTxlgDlam());    /** column 세액공제_외국납부_외화납세액 : txlgDlam */
//							  yetaPrc2000Vo.setTxlgWnam(yeta2000Vo.getTxlgWnam());    /** column 세액공제_외국납부_원화납세액 : txlgWnam */
//							  yetaPrc2000Vo.setTxlgOtcy(yeta2000Vo.getTxlgOtcy());    /** column 세액공제_외국납부_납세국명 : txlgOtcy */
//							  yetaPrc2000Vo.setTxlgOtdt(yeta2000Vo.getTxlgOtdt());    /** column 세액공제_외국납부_납부일자 : txlgOtdt */
//							  yetaPrc2000Vo.setTxlgApdt(yeta2000Vo.getTxlgApdt());    /** column 세액공제_외국납부_신청서제출일자 : txlgApdt */
//							  yetaPrc2000Vo.setTxlgOuwk(yeta2000Vo.getTxlgOuwk());    /** column 세액공제_외국납부_국외근무처명 : txlgOuwk */
//							  yetaPrc2000Vo.setTxapStdt(yeta2000Vo.getTxapStdt());    /** column 세액공제_외국납부_근무시작일자 : txapStdt */
//							  yetaPrc2000Vo.setTxapEddt(yeta2000Vo.getTxapEddt());    /** column 세액공제_외국납부_근무종료일자 : txapEddt */
//							  yetaPrc2000Vo.setTxapWkdy(yeta2000Vo.getTxapWkdy());    /** column 세액공제_외국납부_직책 : txapWkdy */
//							  yetaPrc2000Vo.setTaxdUnin(yeta2000Vo.getTaxdUnin());    /** column 세액공제_납세조합공제 : taxdUnin */
//							  yetaPrc2000Vo.setTaxdLoaa(yeta2000Vo.getTaxdLoaa());    /** column 세액공제_주택차입금이자상황금액 : taxdLoaa */
//							  yetaPrc2000Vo.setAddcNtyn(yeta2000Vo.getAddcNtyn());    /** column 추가서류_연금저축등소득공제제출여부 : addcNtyn */
//							  yetaPrc2000Vo.setAddcMdyn(yeta2000Vo.getAddcMdyn());    /** column 추가서류_의료비지급명세서제출여부 : addcMdyn */
//							  yetaPrc2000Vo.setAddcCtyn(yeta2000Vo.getAddcCtyn());    /** column 추가서류_기부금명세서제출여부 : addcCtyn */
//							  yetaPrc2000Vo.setAddcPfyn(yeta2000Vo.getAddcPfyn());    /** column 추가서류_소득공제증빙서류제출여부 : addcPfyn */
//							  yetaPrc2000Vo.setAddfPvyn(yeta2000Vo.getAddfPvyn());    /** column 추가서류_종전근무지근로소득원천징수제출여부 : addfPvyn */
//							  yetaPrc2000Vo.setSpciReyn(yeta2000Vo.getSpciReyn());    /** column 추가서류_월세액_거주자_주택차입금세액공제제출여부 : spciReyn */
//							  yetaPrc2000Vo.setTxlgMxtm(yeta2000Vo.getTxlgMxtm());    /** column 추가서류_월세_비거주간상환액제출여부 : txlgMxtm */
//							  yetaPrc2000Vo.setIncoOudt(yeta2000Vo.getIncoOudt());    /** column 소득신고제출일자 : incoOudt */
//							  yetaPrc2000Vo.setIncoOufg(yeta2000Vo.getIncoOufg());    /** column 소득신고제출여부 : incoOufg */
//							  yetaPrc2000Vo.setJdocFile(yeta2000Vo.getJdocFile());    /** column 파일생성여부 : jdocFile */
//							  yetaPrc2000Vo.setJrtrAtom(yeta2000Vo.getJrtrAtom());    /** column 연금계좌계 : jrtrAtom */
//							  yetaPrc2000Vo.setJrtrTotr(yeta2000Vo.getJrtrTotr());    /** column 연금계좌공제대상금액 : jrtrTotr */
//							  yetaPrc2000Vo.setSpciHdtg(yeta2000Vo.getSpciHdtg());    /** column 특별공제_장애인보장성대상금액 : spciHdtg */
//							  yetaPrc2000Vo.setSpciDetg(yeta2000Vo.getSpciDetg());    /** column 특별공제_보장성보험료대상금액 : spciDetg */
//							  yetaPrc2000Vo.setSpciRtto(yeta2000Vo.getSpciRtto());    /** column 특별공제_보장성보험료계 : spciRtto */
//							  yetaPrc2000Vo.setSpciSftg(yeta2000Vo.getSpciSftg());    /** column 본인의료비공제대상금액 : spciSftg */
//							  yetaPrc2000Vo.setSpci65tg(yeta2000Vo.getSpci65tg());    /** column 65세이상자의료비공제대상금액 : spci65tg */
//							  yetaPrc2000Vo.setSpciPstg(yeta2000Vo.getSpciPstg());    /** column 장애인의료비공제대상금액 : spciPstg */
//							  yetaPrc2000Vo.setSpciEtcg(yeta2000Vo.getSpciEtcg());    /** column 그밖의의료비공제대상금액 : spciEtcg */
//							  yetaPrc2000Vo.setSpedSftr(yeta2000Vo.getSpedSftr());    /** column 소득자본인교육비대상금액 : spedSftr */
//							  yetaPrc2000Vo.setSpedEdtr(yeta2000Vo.getSpedEdtr());    /** column 취학전아동교육비대상금액 : spedEdtr */
//							  yetaPrc2000Vo.setSpedGdtr(yeta2000Vo.getSpedGdtr());    /** column 초중고교육비대상금액 : spedGdtr */
//							  yetaPrc2000Vo.setSpedCvtr(yeta2000Vo.getSpedCvtr());    /** column 대학생교육비대상금액 : spedCvtr */
//							  yetaPrc2000Vo.setSpciSctr(yeta2000Vo.getSpciSctr());    /** column 특수교육비공제대상금액 : spciSctr */
//							  yetaPrc2000Vo.setSpciExtg(yeta2000Vo.getSpciExtg());    /** column 특례기부금_공익법인제외대상금액 : spciExtg */
//							  yetaPrc2000Vo.setSpciUntg(yeta2000Vo.getSpciUntg());    /** column 공익법인신탁대상금액 : spciUntg */
//							  yetaPrc2000Vo.setSpciHftg(yeta2000Vo.getSpciHftg());    /** column 우리사주종합기부대상금액 : spciHftg */
//							  yetaPrc2000Vo.setSpciNatg(yeta2000Vo.getSpciNatg());    /** column 종교단체외지정대상금액 : spciNatg */
//							  yetaPrc2000Vo.setSpciYatg(yeta2000Vo.getSpciYatg());    /** column 종교단체지정대상금액 : spciYatg */
//							  yetaPrc2000Vo.setSpciDgam(yeta2000Vo.getSpciDgam());    /** column 기부금합계금액 : spciDgam */
//							  yetaPrc2000Vo.setSpciOnon(yeta2000Vo.getSpciOnon());    /** column 이월특례기부금_공익신탁금액 : spciOnon */
//							  yetaPrc2000Vo.setSpciObam(yeta2000Vo.getSpciObam());    /** column 이월법정기부금액 : spciObam */
//							  yetaPrc2000Vo.setSpciOyam(yeta2000Vo.getSpciOyam());    /** column 이월종교단체기부금 : spciOyam */
//							  yetaPrc2000Vo.setSpciOnam(yeta2000Vo.getSpciOnam());    /** column 이월종교단체외기부금 : spciOnam */
//							  yetaPrc2000Vo.setKybdr(yeta2000Vo.getKybdr());    /** column 입력자 : kybdr */
//							  yetaPrc2000Vo.setInptDt(yeta2000Vo.getInptDt());    /** column 입력일자 : inptDt */
//							  yetaPrc2000Vo.setInptAddr(yeta2000Vo.getInptAddr());    /** column 입력주소 : inptAddr */
//							  yetaPrc2000Vo.setIsmt(yeta2000Vo.getIsmt());    /** column 수정자 : ismt */
//							  yetaPrc2000Vo.setRevnDt(yeta2000Vo.getRevnDt());    /** column 수정일자 : revnDt */
//							  yetaPrc2000Vo.setRevnAddr(yeta2000Vo.getRevnAddr());    /** column 수정주소 : revnAddr */
							  
							  lstInfcPkgYeta2000Vo.add(yetaPrc2000Vo); 
						 
		               } 
	                   
		         
	                  Yeta1300ListenerAdapter yetaLsAdtr = new Yeta1300ListenerAdapter();
                      retval = yetaLsAdtr.fnYeta0300Payr06430CalcTax(RemoteServiceUtil.getThreadLocalRequest(),lstInfcPkgYeta2000Vo);
          
		        }
		        catch (Exception ex) {
		        	 
		            logger.error("EXCEPTION calling fnYeta1300Payr06430CalcTax(): "+ex); 
		            
		            /** 에러 로그 **/			
		            MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C",ex, windowNm , windowId);
		             
		            throw MSFServerUtils.getOperationException("fnYeta1300Payr06430CalcTax", ex, logger);
		        }
		        finally {
		          
		        }
		        
				/** 로그반영
				 * CRUDSBLO
				 * C:create		R:read		U:update
		    	 * D:delete		S:select	B:배치 
		    	 * L:로그인		O:로그아웃
		    	 */
				MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C");
		      
		        return retval;
		} 

}
