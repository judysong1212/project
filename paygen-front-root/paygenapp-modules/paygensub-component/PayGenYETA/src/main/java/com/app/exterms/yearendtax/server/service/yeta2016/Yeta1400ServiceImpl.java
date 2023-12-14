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

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1000BM;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1005BM;
import com.app.exterms.yearendtax.client.service.yeta2016.Yeta1400Service;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta1000DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta161005DAO;
import com.app.exterms.yearendtax.server.service.yeta2016.dao.Ye16Ta2000DAO;
import com.app.exterms.yearendtax.server.vo.Ye161005VO;
import com.app.exterms.yearendtax.server.vo.Yeta1000SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta1000VO;
import com.app.exterms.yearendtax.server.vo.Yeta2000SrhVO;
import com.app.exterms.yearendtax.server.vo.Yeta2000VO;
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

import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * 
* <pre>
* 1. 패키지명 : com.app.exterms.yearendtax.server.service
* 2. 타입명 : Yeta0400ServiceImpl.java
* 3. 작성일 : Jan 13, 2016 5:13:53 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Service("Yeta1400Service")
public class Yeta1400ServiceImpl  extends AbstractCustomServiceImpl implements Yeta1400Service  ,YetaDaoConstants {

 
	  private static final Logger logger = LoggerFactory.getLogger(Yeta1400ServiceImpl.class);
	  private static final String calledClass = Yeta1400ServiceImpl.class.getName();
	  
	@Autowired
	@Resource(name = "Ye16Ta1000DAO")
	private Ye16Ta1000DAO yeta1000DAO;
	
	
	@Autowired
	@Resource(name = "Ye16Ta2000DAO")
	private Ye16Ta2000DAO yeta2000DAO;
	
	// 원천세신고기준
	@Autowired
	@Resource(name = "Ye16Ta161005DAO")
	private Ye16Ta161005DAO ye16Ta161005DAO;
	  
	//연말정산신고파일생성 조회
	public Ye16Ta1005BM getYeta1400List(Ye16Ta1000BM yeta1000Bm) throws MSFException {
		
	
		Yeta1000SrhVO yeta1000SrhVo = new Yeta1000SrhVO();
		MSFSysm0100BM sessionUser;
		String method = calledClass + ".getYeta0400List";
		
		String windowNm = "연말정산신고파일생성";
		String windowId = "YETA1400";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}

		if (MSFSharedUtils.paramNull(yeta1000DAO)) {
			WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
					.getSession().getServletContext());
			yeta1000DAO = (Ye16Ta1000DAO) wac.getBean("Ye16Ta1000DAO");
		}
				

		/** 조건절 */
//			yeta1000SrhVo.setDpobCd(sessionUser.getDeptCd());/** column 사업장코드 : dpobCd */
		yeta1000SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta1000Bm.getEdacRvyy()));/** column 연말정산귀속년도 : edacRvyy */
		yeta1000SrhVo.setSettGbcd(MSFSharedUtils.allowNulls(yeta1000Bm.getSettGbcd()));/** column 정산구분코드 : settGbcd */
			
	   	 List<String> listDeptCd = new ArrayList<String>(); 
	   	 yeta1000SrhVo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
	   	 yeta1000SrhVo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
	  	
		 yeta1000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(yeta1000Bm.getDeptCd()));  //권한처리를위해 추가  
	   	 yeta1000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yeta1000Bm.getDtilOccuInttnCd()).replace(",", ""));   
	     
	   	 yeta1000SrhVo.setUsrId(sessionUser.getUsrId());
	   	 /******************************** 권한 ************************************************************************/
	   	 String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
	   	 	
	   	 if ("FALSE".equals(chkDeptCd)) {
	   		 
		   	 yeta1000SrhVo.setDeptCd(sessionUser.getDeptCd()); 
		   	 listDeptCd.add(sessionUser.getDeptCd());
		     yeta1000SrhVo.setDeptCdArr(listDeptCd);     //부서코드    
		     yeta1000SrhVo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
		        
	   	 } else {
	     	    
	   	 	yeta1000SrhVo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(yeta1000Bm.getPayrMangDeptCd())) ;   //단위기관코드   
	   	 		
	   	 	if (yeta1000SrhVo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yeta1000Bm.getDeptCd()))) { 
	   	 		listDeptCd = null; 
	   	 		yeta1000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
	            yeta1000SrhVo.setDeptCd("");  //부서코드
	   	 	} else {
	   	 		yeta1000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(yeta1000Bm.getDeptCd()));
	            listDeptCd = SmrmfUtils.getStrToArrayList(yeta1000Bm.getDeptCd());  
	            yeta1000SrhVo.setDeptCdArr(listDeptCd);     //부서코드   
	        } 
	   	 }
	     
	     
	   
	   	 /******************************** 권한 ************************************************************************/
	  	
	  	
	   	 yeta1000SrhVo.setEmymtDivCd(MSFSharedUtils.allowNulls(yeta1000Bm.getEmymtDivCd()));      		//고용구분코드
	         
//	    	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	    	psnl0100SrhVO.setDeptCdArr(listDeptCd);     //부서코드 
//	   	psnl0100SrhVO.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));			//부서코드
	         
		List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta1000Bm.getTypOccuCd())); 
	    yeta1000SrhVo.setTypOccuCdArr(lstTypeOccuCd); 
	    yeta1000SrhVo.setTypOccuCd(MSFSharedUtils.allowNulls(yeta1000Bm.getTypOccuCd()));  	//직종
	        
//	  	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	  	psnl0100SrhVO.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	  	psnl0100SrhVO.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	          
	   	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta1000Bm.getDtilOccuInttnCd())); 
	   	yeta1000SrhVo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	   	yeta1000SrhVo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(yeta1000Bm.getDtilOccuInttnCd())); //직종세
	        
		List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta1000Bm.getBusinCd())); 
	   	yeta1000SrhVo.setBusinCdArr(lstBusinCd);   
	   	yeta1000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(yeta1000Bm.getBusinCd()));   //사업코드
	        
//	   	yeta1000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	   	
	   	yeta1000SrhVo.setUsrId(MSFSharedUtils.allowNulls(sessionUser.getUsrId()));		//User Id
	   	
	   	yeta1000SrhVo.setYetaDpcd(MSFSharedUtils.allowNulls(yeta1000Bm.getYetaDpcd()));				//원천신고부서
	   	yeta1000SrhVo.setBusoprRgstnum(MSFSharedUtils.allowNulls(yeta1000Bm.getBusoprRgstnum()));	//사업자등록번호
	   	
	        
    	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/
//      	SysIfBass0320VO  sysIfBass0320Vo = new SysIfBass0320VO();
//     	 List<String> listTypCd = new ArrayList<String>(); 
//     	 
//     	sysIfBass0320Vo.setYmdGb("Y");
//     	sysIfBass0320Vo.setStrDate(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "clutYr")));
//     	sysIfBass0320Vo.setTypOccuCd(psnl0100SrhVO.getTypOccuCd());
//     	sysIfBass0320Vo.setTypOccuCdArr(lstTypeOccuCd); 
//     	
//     	listTypCd = SysifPkgServiceUtils.funcArrBeforTypOccuCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0320Vo);
     	
     	SysIfBass0350VO  sysIfBass0350Vo = new SysIfBass0350VO();
     //	 List<String> listTyInttnCd = new ArrayList<String>(); 
     	sysIfBass0350Vo.setDpobCd(sessionUser.getDpobCd());
     	sysIfBass0350Vo.setYmdGb("Y");
     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(yeta1000Bm.getEdacRvyy()));
     	sysIfBass0350Vo.setTypOccuCd(yeta1000SrhVo.getTypOccuCd());
     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
    	sysIfBass0350Vo.setDtilOccuInttnCd(yeta1000SrhVo.getDtilOccuInttnCd());
     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
     	
     	try {
			sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
     
     	yeta1000SrhVo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
     	yeta1000SrhVo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
     	
     	/************************과거 직종세에 해당하는 사람들 데이타 가져오기 **********************************************************/	
			

		int iResultCnt = yeta1000DAO.selectYeta0400ListTotCnt(yeta1000SrhVo);
				
//		Ye16Ta1000BM returnYeta1000Bm = new Ye16Ta1000BM();
		Ye16Ta1005BM returnYeta161005Bm = new Ye16Ta1005BM();
		List egovResultDataList = new ArrayList();

		try {
					
			egovResultDataList = yeta1000DAO.selectYeta0400List(yeta1000SrhVo);

			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
							
					// 1. 암호화 객체 생성
					String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

					
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					

					// 2.복호화 리턴받을 값 선언
					String rrnDecCrypt = "";
					
					while( keys.hasNext() ){
						String key = keys.next();
						//형 타입이 숫자형일경우 형변환 해준다.
						if(tempMap.get(key) instanceof java.math.BigDecimal){
							returnYeta161005Bm.set(key, String.valueOf(tempMap.get(key)));
						}else{
							
		            		if("resnRegnNum".equals(key)) {
		            			// 복호화
		            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get(key))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		            			returnYeta161005Bm.set(key, rrnDecCrypt);
		            			
		            		}else if("resuNumb".equals(key)) {
		            			// 복호화
		            			rrnDecCrypt = AnyCryptUtils.getDecSyncCrypt(nResult,MSFSharedUtils.allowNulls(String.valueOf(tempMap.get(key))).replace("-", ""),AnyCryptUtils.SEC_RRNUMC);
		            			returnYeta161005Bm.set(key, rrnDecCrypt);
		            			
		            		}else {
		            			
		            			returnYeta161005Bm.set(key, tempMap.get(key));
		            		}
				    	}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S", ex, windowNm , windowId);
		}
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return returnYeta161005Bm;
	}
	
	
	//연말정산신고내역 조회
	public PagingLoadResult<BaseModel> getYeta14000List(ServiceParameters serviceParameters) throws MSFException {
		
		PagingLoadResult<BaseModel> retval = null;
		String method =  CLASS_YETA1400LIST;
		Yeta2000SrhVO yeta2000SrhVo = new Yeta2000SrhVO();
		List<BaseModel>  bmResult = new ArrayList<BaseModel>();
		MSFSysm0100BM sessionUser;
		
	        
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
	     	

            yeta2000SrhVo.setDeptCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")).replace(",", ""));  //권한처리를위해 추가  
            yeta2000SrhVo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "dtilOccuInttnCd")).replace(",", ""));   
            
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
	             
	      	List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd"))); 
	      	yeta2000SrhVo.setBusinCdArr(lstBusinCd);  
	      	yeta2000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd"))); //사업코드
	      	
//	      	yeta2000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	           
	           
	      	yeta2000SrhVo.setEdacRvyy(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "edacRvyy"))); //년도
	      	yeta2000SrhVo.setSystemkey(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "systemkey")));  //시스템키
	      	yeta2000SrhVo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	      	yeta2000SrhVo.setYetaDpcd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "yetaDpcd")));				//원천신고부서
	      	yeta2000SrhVo.setBusoprRgstnum(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "busoprRgstnum")));	//사업자등록번호
	      	        
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
	                 
	          	int iResultCnt = yeta2000DAO.selectYeta0400GirdListTotCnt(yeta2000SrhVo);  
	              
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
	     	List list = yeta2000DAO.selectYeta0400GirdList(yeta2000SrhVo);
	            
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
	
	//전자신고기본정보 수정
	public Long updateYeta1000(Ye16Ta1005BM yeta161005Bm) throws MSFException {
		
		Long result = new Long(0);

			Yeta1000VO yeta1000Vo = new Yeta1000VO();
			MSFSysm0100BM sessionUser;
			String method = calledClass + ".updateYeta1000";
			
			String windowNm = "연말정산신고파일생성";
			String windowId = "YETA0400";
			
			Ye161005VO ye16Ta161005Vo = new Ye161005VO();

			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}

			if (MSFSharedUtils.paramNull(ye16Ta161005DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
						.getSession().getServletContext());
				ye16Ta161005DAO = (Ye16Ta161005DAO) wac.getBean("Ye16Ta161005DAO");
			}
			
			// 1. 암호화 객체 생성
			String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			
		
			ye16Ta161005Vo.setDpobCd(MSFSharedUtils.allowNulls(sessionUser.getDpobCd()));    								/** column 사업장코드 : dpobCd */
			ye16Ta161005Vo.setWhdgTxRegrstDeptCd(MSFSharedUtils.allowNulls(yeta161005Bm.getWhdgTxRegrstDeptCd()));    		/** column 원천세신고부서코드 : whdgTxRegrstDeptCd */
			ye16Ta161005Vo.setHhrkWhdgRegrstDeptCd(MSFSharedUtils.allowNulls(yeta161005Bm.getHhrkWhdgRegrstDeptCd())); 		/** column 상위원천세신고부서코드 : hhrkWhdgRegrstDeptCd */
			ye16Ta161005Vo.setTxOffcCd(MSFSharedUtils.allowNulls(yeta161005Bm.getTxOffcCd()));    							/** column A3_세무서코드 : txOffcCd */
			ye16Ta161005Vo.setPentrSeptCd(MSFSharedUtils.allowNulls(yeta161005Bm.getPentrSeptCd()));    					/** column A5_제출자구분 : pentrSeptCd */
			ye16Ta161005Vo.setTxDeptyMangeNum(MSFSharedUtils.allowNulls(yeta161005Bm.getTxDeptyMangeNum()));    			/** column A6_세무대리인관리번호 : txDeptyMangeNum */
			ye16Ta161005Vo.setHmtxId(MSFSharedUtils.allowNulls(yeta161005Bm.getHmtxId()));    								/** column A7_홈텍스ID : hmtxId */
			ye16Ta161005Vo.setTxPgmCd(MSFSharedUtils.allowNulls(yeta161005Bm.getTxPgmCd()));    							/** column A8_세무프로그램코드 : txPgmCd */
			ye16Ta161005Vo.setBusoprRgstnum(MSFSharedUtils.allowNulls(yeta161005Bm.getBusoprRgstnum().replace("-", "")));    /** column A9_사업자등록번호 : busoprRgstnum */
			ye16Ta161005Vo.setCorpFmnmNm(MSFSharedUtils.allowNulls(yeta161005Bm.getCorpFmnmNm()));    						/** column A10_법인_상호명 : corpFmnmNm */
			ye16Ta161005Vo.setPernChrgDeptNm(MSFSharedUtils.allowNulls(yeta161005Bm.getPernChrgDeptNm()));    				/** column A11_담당자부서 : pernChrgDeptNm */
			ye16Ta161005Vo.setPernChrgNm(MSFSharedUtils.allowNulls(yeta161005Bm.getPernChrgNm()));    						/** column A12_담당자성명 : pernChrgNm */
			ye16Ta161005Vo.setPernChrgPhnNum(MSFSharedUtils.allowNulls(yeta161005Bm.getPernChrgPhnNum()));    				/** column A13_담당자전화번호 : pernChrgPhnNum */
			ye16Ta161005Vo.setUseHanCd(MSFSharedUtils.allowNulls(yeta161005Bm.getUseHanCd()));    							/** column A15_사용한글코드 : useHanCd */
			ye16Ta161005Vo.setSumtTgtPridCd(MSFSharedUtils.allowNulls(yeta161005Bm.getSumtTgtPridCd()));   	 				/** column B16_제출대상기간코드 : sumtTgtPridCd */
			ye16Ta161005Vo.setCorpNum(MSFSharedUtils.allowNulls(yeta161005Bm.getCorpNum()).replace("-", ""));    			/** column 법인번호 : corpNum */
			ye16Ta161005Vo.setIncmPost(MSFSharedUtils.allowNulls(yeta161005Bm.getIncmPost()));    							/** column 소득신고의무자우편번호 : incmPost */
			ye16Ta161005Vo.setIncmAddr(MSFSharedUtils.allowNulls(yeta161005Bm.getIncmAddr()));   	 						/** column 소득신고의무자기본주소 : incmAddr */
			ye16Ta161005Vo.setIncmAdtl(MSFSharedUtils.allowNulls(yeta161005Bm.getIncmAdtl()));    							/** column 소득신고의무자상세주소 : incmAdtl */
			ye16Ta161005Vo.setKybdr(sessionUser.getUsrId());    															/** column 입력자 : kybdr */
//			ye16Ta161005Vo.setInptDt(ye161005Dto.getInptDt());    /** column 입력일자 : inptDt */
			ye16Ta161005Vo.setInptAddr(yeta161005Bm.getInptAddr());    														/** column 입력주소 : inptAddr */
			ye16Ta161005Vo.setIsmt(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    							/** column 수정자 : ismt */
//			ye16Ta161005Vo.setRevnDt(ye161005Dto.getRevnDt());    /** column 수정일자 : revnDt */
			ye16Ta161005Vo.setRevnAddr(yeta161005Bm.getRevnAddr());    														/** column 수정주소 : revnAddr */
			ye16Ta161005Vo.setReprName(MSFSharedUtils.allowNulls(yeta161005Bm.getReprName()));    							/** column 대표자성명 : reprName */
			ye16Ta161005Vo.setResuNumb(AnyCryptUtils.getEncSyncCrypt(nResult, MSFSharedUtils.allowNulls(
					yeta161005Bm.getResuNumb()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));    							/** column 주민등록번호 : resuNumb */
			
////			yeta1000Vo.setDpobCd(sessionUser.getDpobCd());    /** column null : dpobCd */
////			yeta1000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta1000Dto.getEdacRvyy()));    /** column 연말정산귀속년도 : edacRvyy */
////			yeta1000Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta1000Dto.getSettGbcd()));    /** column 정산구분코드 : settGbcd */
////			yeta1000Vo.setEdacSeilNum(new BigDecimal(yeta1000Dto.getEdacSeilNum()));    /** column 연말정산마감일련번호 : edacSeilNum */
////			yeta1000Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(yeta1000Dto.getPayrMangDeptCd()));    /** column 급여관리부서코드 : payrMangDeptCd */
//			
//			yeta1000Vo.setDpobCd(sessionUser.getDpobCd());    /** column null : dpobCd */
//			yeta1000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta1000Bm.getEdacRvyy()));    /** column 연말정산귀속년도 : edacRvyy */
//			yeta1000Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta1000Bm.getSettGbcd()));    /** column 정산구분코드 : settGbcd */
//			yeta1000Vo.setEdacSeilNum(new BigDecimal(yeta1000Bm.getEdacSeilNum()));    /** column 연말정산마감일련번호 : edacSeilNum */
//			yeta1000Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(yeta1000Bm.getPayrMangDeptCd()));    /** column 급여관리부서코드 : payrMangDeptCd */
//			
////			yeta1000Vo.setDeptCd(MSFSharedUtils.allowNulls(objectBm.get("deptCd")));    /** column 부서코드 : deptCd */
////			yeta1000Vo.setTypOccuCd(MSFSharedUtils.allowNulls(objectBm.get("typOccuCd")));    /** column 직종코드 : typOccuCd */
////			yeta1000Vo.setDtilOccuClsDivCd(MSFSharedUtils.allowNulls(objectBm.get("dtilOccuClsDivCd")));    /** column 직종세구분코드 : dtilOccuClsDivCd */
////			yeta1000Vo.setPyspGrdeCd(MSFSharedUtils.allowNulls(objectBm.get("pyspGrdeCd")));    /** column 호봉등급코드 : pyspGrdeCd */
////			yeta1000Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(objectBm.get("dtilOccuInttnCd")));    /** column 직종세통합코드 : dtilOccuInttnCd */
////			yeta1000Vo.setBusinCd(MSFSharedUtils.allowNulls(objectBm.get("businCd")));    /** column 사업코드 : businCd */
////			yeta1000Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(objectBm.get("emymtDivCd")));    /** column 고용구분코드 : emymtDivCd */
////			yeta1000Vo.setPernChrgEmpIdenNum(MSFSharedUtils.allowNulls(objectBm.get("pernChrgEmpIdenNum")));    /** column 생성직원번호 : pernChrgEmpIdenNum */
////			yeta1000Vo.setClosFlag(MSFSharedUtils.allowNulls(objectBm.get("closFlag")));    /** column 마감여부 : closFlag */
////			yeta1000Vo.setClosCont(MSFSharedUtils.allowNulls(objectBm.get("closCont")));    /** column 마감건수 : closCont */
////			yeta1000Vo.setClosDate(MSFSharedUtils.allowNulls(objectBm.get("closDate")));    /** column 마감일자 : closDate */
//			
//			
////			yeta1000Vo.setEdacPrdt(MSFSharedUtils.allowNulls(yeta1000Dto.getEdacPrdt()));    /** column 연말정산제출일자 : edacPrdt */
////			yeta1000Vo.setReprName(MSFSharedUtils.allowNulls(yeta1000Dto.getReprName()));    /** column 대표자성명 : reprName */
////			yeta1000Vo.setJuriName(MSFSharedUtils.allowNulls(yeta1000Dto.getJuriName()));    /** column 법인명_상호 : juriName */
////			yeta1000Vo.setBusiNumb(MSFSharedUtils.allowNulls(yeta1000Dto.getBusiNumb()));    /** column 사업자등록번호 : busiNumb */
////			yeta1000Vo.setResuNumb(MSFSharedUtils.allowNulls(yeta1000Dto.getResuNumb()));    /** column 주민등록번호 : resuNumb */
////			yeta1000Vo.setJuriNumb(MSFSharedUtils.allowNulls(yeta1000Dto.getJuriNumb()));    /** column 법인번호 : juriNumb */
////			yeta1000Vo.setIncmPost(MSFSharedUtils.allowNulls(yeta1000Dto.getIncmPost()));    /** column 소득신고의무자우편번호 : incmPost */
////			yeta1000Vo.setIncmAddr(MSFSharedUtils.allowNulls(yeta1000Dto.getIncmAddr()));    /** column 소득신고의무자기본주소 : incmAddr */
////			yeta1000Vo.setIncmAdtl(MSFSharedUtils.allowNulls(yeta1000Dto.getIncmAdtl()));    /** column 소득신고의무자상세주소 : incmAdtl */
////			yeta1000Vo.setTaxaCode(MSFSharedUtils.allowNulls(yeta1000Dto.getTaxaCode()));    /** column 관할세무서코드 : taxaCode */
////			yeta1000Vo.setIncmGbcd(MSFSharedUtils.allowNulls(yeta1000Dto.getIncmGbcd()));    /** column 제출자구분코드 : incmGbcd */
////			yeta1000Vo.setTaxaDnum(MSFSharedUtils.allowNulls(yeta1000Dto.getTaxaDnum()));    /** column 세무대리인번호 : taxaDnum */
////			yeta1000Vo.setHomeTxid(MSFSharedUtils.allowNulls(yeta1000Dto.getHomeTxid()));    /** column 홈텍스ID : homeTxid */
////			yeta1000Vo.setTaxaPrcd(MSFSharedUtils.allowNulls(yeta1000Dto.getTaxaPrcd()));    /** column 세무프로그램코드 : taxaPrcd */
////			yeta1000Vo.setCharDept(MSFSharedUtils.allowNulls(yeta1000Dto.getCharDept()));    /** column 담당자부서명 : charDept */
////			yeta1000Vo.setCharName(MSFSharedUtils.allowNulls(yeta1000Dto.getCharName()));    /** column 담당자성명 : charName */
////			yeta1000Vo.setCharTele(MSFSharedUtils.allowNulls(yeta1000Dto.getCharTele()));    /** column 담당자전화번호 : charTele */
////			yeta1000Vo.setFilePass(MSFSharedUtils.allowNulls(yeta1000Dto.getFilePass()));    /** column FILE_PASS : filePass */
//			
//			
//			
//			yeta1000Vo.setEdacPrdt(MSFSharedUtils.allowNulls(yeta1000Bm.getEdacPrdt()));    /** column 연말정산제출일자 : edacPrdt */
//			yeta1000Vo.setReprName(MSFSharedUtils.allowNulls(yeta1000Bm.getReprName()));    /** column 대표자성명 : reprName */
//			yeta1000Vo.setJuriName(MSFSharedUtils.allowNulls(yeta1000Bm.getJuriName()));    /** column 법인명_상호 : juriName */
//			yeta1000Vo.setBusiNumb(MSFSharedUtils.allowNulls(yeta1000Bm.getBusiNumb()));    /** column 사업자등록번호 : busiNumb */
////			yeta1000Vo.setResuNumb(MSFSharedUtils.allowNulls(yeta1000Bm.getResuNumb()));    /** column 주민등록번호 : resuNumb */
//			
//			//암호화
//			yeta1000Vo.setResuNumb(AnyCryptUtils.getEncSyncCrypt(nResult,MSFSharedUtils.allowNulls(yeta1000Bm.getResuNumb()).replaceAll("-",""),AnyCryptUtils.SEC_RRNUMC));
//			
//			yeta1000Vo.setJuriNumb(MSFSharedUtils.allowNulls(yeta1000Bm.getJuriNumb()));    /** column 법인번호 : juriNumb */
//			yeta1000Vo.setIncmPost(MSFSharedUtils.allowNulls(yeta1000Bm.getIncmPost()));    /** column 소득신고의무자우편번호 : incmPost */
//			yeta1000Vo.setIncmAddr(MSFSharedUtils.allowNulls(yeta1000Bm.getIncmAddr()));    /** column 소득신고의무자기본주소 : incmAddr */
//			yeta1000Vo.setIncmAdtl(MSFSharedUtils.allowNulls(yeta1000Bm.getIncmAdtl()));    /** column 소득신고의무자상세주소 : incmAdtl */
//			yeta1000Vo.setTaxaCode(MSFSharedUtils.allowNulls(yeta1000Bm.getTaxaCode()));    /** column 관할세무서코드 : taxaCode */
//			yeta1000Vo.setIncmGbcd(MSFSharedUtils.allowNulls(yeta1000Bm.getIncmGbcd()));    /** column 제출자구분코드 : incmGbcd */
//			yeta1000Vo.setTaxaDnum(MSFSharedUtils.allowNulls(yeta1000Bm.getTaxaDnum()));    /** column 세무대리인번호 : taxaDnum */
//			yeta1000Vo.setHomeTxid(MSFSharedUtils.allowNulls(yeta1000Bm.getHomeTxid()));    /** column 홈텍스ID : homeTxid */
//			yeta1000Vo.setTaxaPrcd(MSFSharedUtils.allowNulls(yeta1000Bm.getTaxaPrcd()));    /** column 세무프로그램코드 : taxaPrcd */
//			yeta1000Vo.setCharDept(MSFSharedUtils.allowNulls(yeta1000Bm.getCharDept()));    /** column 담당자부서명 : charDept */
//			yeta1000Vo.setCharName(MSFSharedUtils.allowNulls(yeta1000Bm.getCharName()));    /** column 담당자성명 : charName */
//			yeta1000Vo.setCharTele(MSFSharedUtils.allowNulls(yeta1000Bm.getCharTele()));    /** column 담당자전화번호 : charTele */
//			yeta1000Vo.setFilePass(MSFSharedUtils.allowNulls(yeta1000Bm.getFilePass()));    /** column FILE_
//			
//			yeta1000Vo.setIsmt(sessionUser.getUsrId());    /** column 수정자 : ismt */
//			yeta1000Vo.setRevnDt(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());    /** column 수정일자 : revnDt */
////			yeta1000Vo.setRevnAddr(MSFSharedUtils.allowNulls(objectBm.get("revnAddr")));    /** column 수정주소 : revnAddr */
			
		  	try{
		  		ye16Ta161005DAO.updateYe161005(ye16Ta161005Vo);
//		  		yeta1000DAO.saveYeta0400List(yeta1000Vo);
		  		result = new Long(1);

			} catch (Exception ex) {
				ex.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"U",ex, windowNm , windowId);
				
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
	
	
	
	//연말정산신고파일 마감/풀기
	public Long finishOnYeta1000(Ye16Ta1000BM yeta1000Bm) throws MSFException {
		
		Long result = new Long(0);
		String method = calledClass + ".finishOnYeta1000";
		
		String windowNm = "연말정산신고파일생성";
		String windowId = "YETA1400";
		
		// 1. 암호화 객체 생성
		String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());

			Yeta2000VO yeta2000Vo = new Yeta2000VO();
			MSFSysm0100BM sessionUser;

			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}

			if (MSFSharedUtils.paramNull(yeta2000DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getHttpServletRequest()
						.getSession().getServletContext());
				yeta2000DAO = (Ye16Ta2000DAO) wac.getBean("Ye16Ta2000DAO");
			}
					

//			yeta1000Vo.setDpobCd(yeta1000Dto.getDpobCd());
//			yeta1000Vo.setEdacRvyy(yeta1000Dto.getEdacRvyy());
//			yeta1000Vo.setSettGbcd(yeta1000Dto.getSettGbcd());
//			yeta1000Vo.setEdacSeilNum(new BigDecimal(yeta1000Dto.getEdacSeilNum()));
//			
//			yeta1000Vo.setClosFlag(yeta1000Dto.getClosFlag());
//			yeta1000Vo.setClosDate(yeta1000Dto.getEdacPrdt());
			
			
//			yeta1000Vo.setDpobCd(yeta1000Bm.getDpobCd());
//			yeta1000Vo.setEdacRvyy(yeta1000Bm.getEdacRvyy());
//			yeta1000Vo.setSettGbcd(yeta1000Bm.getSettGbcd());
//			yeta1000Vo.setEdacSeilNum(new BigDecimal(yeta1000Bm.getEdacSeilNum()));
//			
//			yeta1000Vo.setClosFlag(yeta1000Bm.getClosFlag());
//			yeta1000Vo.setClosDate(yeta1000Bm.getEdacPrdt());
//			
//			yeta1000Vo.setIsmt(sessionUser.getUsrId());
//			yeta1000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
			
			List<String> listDeptCd = new ArrayList<String>(); 
			
	      	/** 조건절 */
			yeta2000Vo.setDpobCd(sessionUser.getDpobCd());	//사업장코드
			yeta2000Vo.setSettGbcd(MSFSharedUtils.allowNulls(yeta1000Bm.getSettGbcd()));//정산구분
			yeta2000Vo.setPayrMangDeptYn(sessionUser.getPayrMangDeptYn());  //단위기관담당자여부 
//	     	psnl0100SrhVO.setPayrMangDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "payrMangDeptCd")));		//단위기관코드
	     	

			yeta2000Vo.setDeptCdAuth(MSFSharedUtils.allowNulls(yeta1000Bm.getDeptCd()).replace(",", ""));  //권한처리를위해 추가  
			yeta2000Vo.setDtilOccuInttnCdAuth(MSFSharedUtils.allowNulls(yeta1000Bm.getDtilOccuInttnCd()).replace(",", ""));   
            
			yeta2000Vo.setUsrId(sessionUser.getUsrId());
            /******************************** 권한 ************************************************************************/
            String chkDeptCd = sessionUser.getAuthCheck().getAuthCheck03();
            if ("FALSE".equals(chkDeptCd)) {
            	yeta2000Vo.setDeptCd(sessionUser.getDeptCd()); 
               listDeptCd.add(sessionUser.getDeptCd());
               yeta2000Vo.setDeptCdArr(listDeptCd);     //부서코드    
               yeta2000Vo.setPayrMangDeptCd(sessionUser.getPayrMangDeptCd()); 
            } else {
            	yeta2000Vo.setPayrMangDeptCd(MSFSharedUtils.allowNulls(yeta1000Bm.getPayrMangDeptCd())) ;   //단위기관코드   
                     if (yeta2000Vo.getPayrMangDeptCd().equals(MSFSharedUtils.allowNulls(yeta1000Bm.getDeptCd()))) { 
                     	 listDeptCd = null; 
                     	yeta2000Vo.setDeptCdArr(listDeptCd);     //부서코드 
                     	yeta2000Vo.setDeptCd("");  //부서코드
                     } else {
                    	 yeta2000Vo.setDeptCd(MSFSharedUtils.allowNulls(yeta1000Bm.getDeptCd()));
                          listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta1000Bm.getDeptCd()));  
                          yeta2000Vo.setDeptCdArr(listDeptCd);     //부서코드   
                     } 
            }
            
//            } else {
//            	
//            }
            
           /******************************** 권한 ************************************************************************/
	     	
	     	
            yeta2000Vo.setEmymtDivCd(MSFSharedUtils.allowNulls(yeta1000Bm.getEmymtDivCd()));       //고용구분코드
	            
//	       	List<String> listDeptCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));  
//	     	yeta2000SrhVo.setDeptCdArr(listDeptCd);     //부서코드 
//	      	yeta2000SrhVo.setDeptCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "deptCd")));     //부서코드
	            
	       	List<String> lstTypeOccuCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta1000Bm.getTypOccuCd())); 
	       	yeta2000Vo.setTypOccuCdArr(lstTypeOccuCd); 
	       	yeta2000Vo.setTypOccuCd(MSFSharedUtils.allowNulls(yeta1000Bm.getTypOccuCd()));  //직종
	           
//	     	List<String> lstPyspGrdeCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); 
//	     	yeta2000SrhVo.setPyspGrdeCdArr(lstPyspGrdeCd);  
//	     	yeta2000SrhVo.setPyspGrdeCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "pyspGrdeCd"))); //호봉등급코드
	             
	      	List<String> lstDtilOccuInttnCd = SmrmfUtils.getStrToArrayList(MSFSharedUtils.allowNulls(yeta1000Bm.getDtilOccuInttnCd())); 
	      	yeta2000Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	      	yeta2000Vo.setDtilOccuInttnCd(MSFSharedUtils.allowNulls(yeta1000Bm.getDtilOccuInttnCd())); //직종세
	             
	      	List<String> lstBusinCd = SmrmfUtils.getStrToArrayList(yeta1000Bm.getBusinCd()); 
	      	yeta2000Vo.setBusinCdArr(lstBusinCd);  
	      	yeta2000Vo.setBusinCd(MSFSharedUtils.allowNulls(yeta1000Bm.getBusinCd())); //사업코드
	      	
//	      	yeta2000SrhVo.setBusinCd(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "businCd")));   //사업코드
	           
	           
	      	yeta2000Vo.setEdacRvyy(MSFSharedUtils.allowNulls(yeta1000Bm.getEdacRvyy())); //년도
//	      	yeta1000Vo.setSystemkey(MSFSharedUtils.allowNulls(yeta1000Bm.getSystemkey()));  //시스템키
//	      	yeta1000Vo.setHanNm(MSFSharedUtils.allowNulls(MSFServerUtils.getFilterValue(columnFilters, "hanNm")));    //한글성명 
	      	yeta2000Vo.setYetaDpcd(MSFSharedUtils.allowNulls(yeta1000Bm.getYetaDpcd()));				//원천신고부서
	      	yeta2000Vo.setBusoprRgstnum(MSFSharedUtils.allowNulls(yeta1000Bm.getBusoprRgstnum()));	//사업자등록번호
	      	        
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
	     	sysIfBass0350Vo.setStrDate(MSFSharedUtils.allowNulls(yeta1000Bm.getEdacRvyy()));
	     	sysIfBass0350Vo.setTypOccuCd(yeta2000Vo.getTypOccuCd());
	     	sysIfBass0350Vo.setTypOccuCdArr(lstTypeOccuCd);
	    	sysIfBass0350Vo.setDtilOccuInttnCd(yeta2000Vo.getDtilOccuInttnCd());
	     	sysIfBass0350Vo.setDtilOccuInttnCdArr(lstDtilOccuInttnCd);  
	     	
	     	try {
				sysIfBass0350Vo = SysifPkgServiceUtils.getFuncBeforDtilOccuInttnCd(RemoteServiceUtil.getThreadLocalRequest(),sysIfBass0350Vo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	     
	     	yeta2000Vo.setTypOccuCdArr(sysIfBass0350Vo.getRtnTypOccuCdArr());  
	     	yeta2000Vo.setDtilOccuInttnCdArr(sysIfBass0350Vo.getRtnDtilOccuInttnCdArr());   
			
	     	yeta2000Vo.setClosFlag(yeta1000Bm.getClosFlag());
	     	yeta2000Vo.setClosDate(yeta1000Bm.getClosDate());
			
	     	yeta2000Vo.setIsmt(sessionUser.getUsrId());
	     	yeta2000Vo.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			
		  	try{
		  		
		  		List<EgovMap> egovResultDataList = yeta2000DAO.selectFinYeta2000List(yeta2000Vo);
		  		
				if(egovResultDataList != null && egovResultDataList.size() > 0){
					
					for(int i = 0 ; i < egovResultDataList.size(); i++){
						
						EgovMap tempMap = (EgovMap)egovResultDataList.get(i);
						
						yeta2000Vo.setSystemkey(MSFSharedUtils.allowNulls(tempMap.get("systemkey")));
						yeta2000DAO.finishYeta0400List(yeta2000Vo);
        		  		result = new Long(1);
						
					}
				}

			} catch (Exception ex) {
				ex.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm , windowId);
			}
		  	
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");

			return result;
		}

	  
}
