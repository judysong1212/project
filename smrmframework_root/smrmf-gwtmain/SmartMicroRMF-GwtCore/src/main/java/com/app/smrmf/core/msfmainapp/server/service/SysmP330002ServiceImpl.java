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
package com.app.smrmf.core.msfmainapp.server.service;
 
 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.gwtrpcspring.RemoteServiceUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.service.SysmP330002Service;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.AnyCryptUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.app.smrmf.core.msfmainapp.shared.MSFDaoConstants;
import com.app.smrmf.core.msfmainapp.shared.utils.MSFSharedUtils;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfHist0300DTO;
import com.app.smrmf.sysm.server.service.dao.MSFSysHist0300DAO;
import com.app.smrmf.sysm.server.vo.SysIfHist0300SrhVO;
import com.extjs.gxt.ui.client.data.BaseModel;

import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * 
* <pre>
* 1. 패키지명 : com.app.exterms.yearendtax.server.service
* 2. 타입명 : Stts0300ServiceImpl.java
* 3. 작성일 : Jan 13, 2016 5:12:49 PM
* 4. 작성자 : leeheuisung
* 5. 설명 :
* </pre>
 */
@Service("SysmP330002Service")
public class SysmP330002ServiceImpl  extends AbstractCustomServiceImpl implements SysmP330002Service, MSFDaoConstants {

	 
	  private static final Logger logger = LoggerFactory.getLogger(SysmP330002ServiceImpl.class);
	  private static final String calledClass = SysmP330002ServiceImpl.class.getName();
	  
	  
	    @Autowired
	    @Resource(name="MSFSysHist0300DAO")
	    private MSFSysHist0300DAO hist0300DAO;  
	    
		/** 시간을 가져옴 **/
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public List<BaseModel> getHourList() throws MSFException {
			List<BaseModel> returnValue = new ArrayList<BaseModel>();
			List egovResultDataList = new ArrayList();
			
			String method = calledClass + ".getHourList";
			MSFSysm0100BM sessionUser;

			if ( RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser( RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
			
			try{
				
				egovResultDataList = hist0300DAO.getHourList();
				
				/** 로그반영
				 * CRUDSBLO
				 * C   //create  
		    	 * R   //read
		    	 * U   //update
		    	 * D   //delete
		    	 * S   //select
		    	 * B   //배치 
		    	 * L   //로그인 
		    	 * O   //로그아웃
		    	 */
				MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
				
				if(egovResultDataList != null && egovResultDataList.size() > 0){
					for(int i = 0 ; i < egovResultDataList.size(); i++){
						BaseModel bm = new BaseModel();
						Map tempMap = (Map)egovResultDataList.get(i);
						Iterator<String> keys = tempMap.keySet().iterator();
						while( keys.hasNext() ){
				            String key = keys.next();
				            //형 타입이 숫자형일경우 형변환 해준다.
			            	if(tempMap.get(key) instanceof java.math.BigDecimal){
			            		bm.set(key, String.valueOf(tempMap.get(key)));
			            	}else{
			            		bm.set(key, tempMap.get(key));
			            	}
			            }
						returnValue.add(bm);
					}
				}
				
				
			}catch(Exception e){
				e.printStackTrace();
				throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			}
			return returnValue;
		}
		
		
		/** 분을 가져옴 **/
		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public List<BaseModel> getMinuteList() throws MSFException {
			
			List<BaseModel> returnValue = new ArrayList<BaseModel>();
			List egovResultDataList = new ArrayList();
			
			String method = calledClass + ".activityOnVoceMenuProfile";
			MSFSysm0100BM sessionUser;

			if ( RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser( RemoteServiceUtil.getThreadLocalRequest());
			} else {
				sessionUser = getUser();
			}
			
			try{
				
				egovResultDataList = hist0300DAO.getMinuteList();
				
				/** 로그반영
				 * CRUDSBLO
				 * C   //create  
		    	 * R   //read
		    	 * U   //update
		    	 * D   //delete
		    	 * S   //select
		    	 * B   //배치 
		    	 * L   //로그인 
		    	 * O   //로그아웃
		    	 */
				MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
				
				if(egovResultDataList != null && egovResultDataList.size() > 0){
					for(int i = 0 ; i < egovResultDataList.size(); i++){
						BaseModel bm = new BaseModel();
						Map tempMap = (Map)egovResultDataList.get(i);
						Iterator<String> keys = tempMap.keySet().iterator();
						while( keys.hasNext() ){
				            String key = keys.next();
				            //형 타입이 숫자형일경우 형변환 해준다.
			            	if(tempMap.get(key) instanceof java.math.BigDecimal){
			            		bm.set(key, String.valueOf(tempMap.get(key)));
			            	}else{
			            		bm.set(key, tempMap.get(key));
			            	}
			            }
						returnValue.add(bm);
					}
				}
				
			}catch(Exception e){
				e.printStackTrace();
				throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
			}
			return returnValue;
		}
		
		/** 에러 로그 리스트를 가져온다. **/
		public List<SysIfHist0300DTO> resultListHist0300(SysIfHist0300DTO sysmIfHist0300Dto) throws MSFException {
			
			
			List<SysIfHist0300DTO> returnHist0300List = new ArrayList<SysIfHist0300DTO>();
			SysIfHist0300SrhVO hist0300SrhVo = new SysIfHist0300SrhVO();
			
			String windowNm = MSFSharedUtils.allowNulls(sysmIfHist0300Dto.getWindowId());
			String windowId = MSFSharedUtils.allowNulls(sysmIfHist0300Dto.getWindowId());
			
			MSFSysm0100BM sessionUser;
				
			String method = calledClass + ".resultListHist0300";
			

			if (RemoteServiceUtil.getThreadLocalRequest() != null) {
				sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
			} else {
					sessionUser = getUser();
			}


			if  (MSFSharedUtils.paramNull(hist0300DAO)) {
				WebApplicationContext wac = WebApplicationContextUtils
						.getRequiredWebApplicationContext( getHttpServletRequest().getSession().getServletContext());
				hist0300DAO = (MSFSysHist0300DAO) wac.getBean("MSFCoreHist0300DAO" ); 
			}
				

			// 1. 암호화 객체 생성
			try {
				
		 
				String nResult = AnyCryptUtils.XecureCryptInitialize(RemoteServiceUtil.getThreadLocalConfig(),RemoteServiceUtil.getThreadLocalRequest());
			

				List<String> listDeptCd = new ArrayList<String>();  
				 

				/** 조건절 */
	            hist0300SrhVo.setUsrConnectDivCd(sysmIfHist0300Dto.getUsrConnectDivCd());    								/** column 사용자접속구분코드 : usrConnectDivCd */
	            
	            hist0300SrhVo.setErrOccrrncDtntmS(MSFSharedUtils.allowNulls(sysmIfHist0300Dto.getErrOccrrncDtntmS()));    	/** column 에러발생일시 : errOccrrncDtntm */
	            hist0300SrhVo.setErrOccrrncDtntmE(MSFSharedUtils.allowNulls(sysmIfHist0300Dto.getErrOccrrncDtntmE()));    	/** column 에러발생일시 : errOccrrncDtntm */   
	            hist0300SrhVo.setDeptCd(MSFSharedUtils.allowNulls(sysmIfHist0300Dto.getDeptCd()));
	            listDeptCd = MSFSharedUtils.getStrToArrayList(MSFSharedUtils.allowNulls(sysmIfHist0300Dto.getDeptCd()));  	/** column 부서코드 : deptCd */
	            hist0300SrhVo.setDeptCdArr(listDeptCd);    		
	            
	            hist0300SrhVo.setUsrId(MSFSharedUtils.allowNulls(sysmIfHist0300Dto.getUsrId()));		//사용자 아이디
	            hist0300SrhVo.setWindowNm(MSFSharedUtils.allowNulls(sysmIfHist0300Dto.getWindowId()));	//화면아이디
	            
	            
	            int iResultCnt = hist0300DAO.selectHistP030002ToHist0300ListTotCnt(hist0300SrhVo);  
	            hist0300SrhVo.setLastIndex(iResultCnt);
	           
	            
				//List<SysIfHist0300DTO> egovResultDataList = new ArrayList<SysIfHist0300DTO>();
				List egovResultDataList = new ArrayList<SysIfHist0300DTO>();

				try {
					
					egovResultDataList =  hist0300DAO.selectHistP030002ToHist0300List(hist0300SrhVo);
					

					if(egovResultDataList != null && egovResultDataList.size() > 0){
						for(int i = 0 ; i < egovResultDataList.size(); i++){
							
							EgovMap eMap = (EgovMap) egovResultDataList.get(i);
							
							SysIfHist0300DTO hist0300Dto = new SysIfHist0300DTO();
							
							hist0300Dto.setRnum(MSFSharedUtils.allowNulls((String) eMap.get("Rnum")));
							hist0300Dto.setDpobCd(MSFSharedUtils.allowNulls((String) eMap.get("dpobCd")));    					/** column 사업장코드 : dpobCd */
							hist0300Dto.setUsrId(MSFSharedUtils.allowNulls((String) eMap.get("usrId")));    					/** column 사용자아이디 : usrId */
							hist0300Dto.setErrOccrrncDtntm(MSFSharedUtils.allowNulls((String) eMap.get("errOccrrncDtntm"))); 	/** column 에러발생일시 : errOccrrncDtntm */
							hist0300Dto.setErrSeilNum(Long.parseLong( MSFSharedUtils.defaultNulls(eMap.get("errSeilNum"), "0")));/** column 에러일련번호 : errSeilNum */
							hist0300Dto.setErrOccrrncYr(MSFSharedUtils.allowNulls((String) eMap.get("errOccrrncYr")));    		/** column 에러발생년도 : errOccrrncYr */
							hist0300Dto.setUsrConnectDivCd(MSFSharedUtils.allowNulls((String)  eMap.get("usrConnectDivCd")));	/** column 사용자접속구분코드 : usrConnectDivCd */
							hist0300Dto.setDeptCd(MSFSharedUtils.allowNulls((String) eMap.get("deptCd")));    					/** column 부서코드 : deptCd */
							hist0300Dto.setUsrDivCd(MSFSharedUtils.allowNulls((String) eMap.get("usrDivCd")));    				/** column 사용자구분코드 : usrDivCd */
							hist0300Dto.setUsrNm(MSFSharedUtils.allowNulls((String) eMap.get("usrNm")));    					/** column 사용자성명 : usrNm */
							hist0300Dto.setErrEthdNm(MSFSharedUtils.allowNulls((String) eMap.get("errEthdNm")));    			/** column 에러메소드명 : errEthdNm */
							hist0300Dto.setErrNm(MSFSharedUtils.allowNulls((String) eMap.get("errNm")));    					/** column 에러명 : errNm */
							hist0300Dto.setErrCtnt(MSFSharedUtils.allowNulls((String) eMap.get("errCtnt")));    				/** column 에러내용 : errCtnt */
							hist0300Dto.setKybdr(MSFSharedUtils.allowNulls((String) eMap.get("kybdr")));    					/** column 입력자 : kybdr */
							hist0300Dto.setInptDt(MSFSharedUtils.allowNulls((String) eMap.get("inptDt")));    				/** column 입력일자 : inptDt */
							hist0300Dto.setInptAddr(MSFSharedUtils.allowNulls((String) eMap.get("inptAddr")));    			/** column 입력주소 : inptAddr */
							hist0300Dto.setIsmt(MSFSharedUtils.allowNulls((String) eMap.get("ismt")));    					/** column 수정자 : ismt */
							hist0300Dto.setRevnDt(MSFSharedUtils.allowNulls((String) eMap.get("revnDt")));    				/** column 수정일자 : revnDt */
							hist0300Dto.setRevnAddr(MSFSharedUtils.allowNulls((String) eMap.get("revnAddr")));    			/** column 수정주소 : revnAddr */
							hist0300Dto.setWindowNm(MSFSharedUtils.allowNulls((String) eMap.get("windowNm")));    			/** column 화면명 : windowNm */
							hist0300Dto.setWindowId(MSFSharedUtils.allowNulls((String) eMap.get("windowId")));    			/** column 화면아이디 : windowId */
							
//							hist0300Dto.setRnum(egovResultDataList.get(i).getRnum());
//							hist0300Dto.setDpobCd(egovResultDataList.get(i).getDpobCd());    				/** column 사업장코드 : dpobCd */
//							hist0300Dto.setUsrId(egovResultDataList.get(i).getUsrId());    					/** column 사용자아이디 : usrId */
//							hist0300Dto.setErrOccrrncDtntm(egovResultDataList.get(i).getErrOccrrncDtntm()); /** column 에러발생일시 : errOccrrncDtntm */
//							hist0300Dto.setErrSeilNum(egovResultDataList.get(i).getErrSeilNum());    		/** column 에러일련번호 : errSeilNum */
//							hist0300Dto.setErrOccrrncYr(egovResultDataList.get(i).getErrOccrrncYr());    	/** column 에러발생년도 : errOccrrncYr */
//							hist0300Dto.setUsrConnectDivCd(egovResultDataList.get(i).getUsrConnectDivCd());	/** column 사용자접속구분코드 : usrConnectDivCd */
//							hist0300Dto.setDeptCd(egovResultDataList.get(i).getDeptCd());    				/** column 부서코드 : deptCd */
//							hist0300Dto.setUsrDivCd(egovResultDataList.get(i).getUsrDivCd());    			/** column 사용자구분코드 : usrDivCd */
//							hist0300Dto.setUsrNm(egovResultDataList.get(i).getUsrNm());    					/** column 사용자성명 : usrNm */
//							hist0300Dto.setErrEthdNm(egovResultDataList.get(i).getErrEthdNm());    			/** column 에러메소드명 : errEthdNm */
//							hist0300Dto.setErrNm(egovResultDataList.get(i).getErrNm());    					/** column 에러명 : errNm */
//							hist0300Dto.setErrCtnt(egovResultDataList.get(i).getErrCtnt());    				/** column 에러내용 : errCtnt */
//							hist0300Dto.setKybdr(egovResultDataList.get(i).getKybdr());    					/** column 입력자 : kybdr */
//							hist0300Dto.setInptDt(egovResultDataList.get(i).getInptDt());    				/** column 입력일자 : inptDt */
//							hist0300Dto.setInptAddr(egovResultDataList.get(i).getInptAddr());    			/** column 입력주소 : inptAddr */
//							hist0300Dto.setIsmt(egovResultDataList.get(i).getIsmt());    					/** column 수정자 : ismt */
//							hist0300Dto.setRevnDt(egovResultDataList.get(i).getRevnDt());    				/** column 수정일자 : revnDt */
//							hist0300Dto.setRevnAddr(egovResultDataList.get(i).getRevnAddr());    			/** column 수정주소 : revnAddr */
//							hist0300Dto.setWindowNm(egovResultDataList.get(i).getWindowNm());    			/** column 화면명 : windowNm */
//							hist0300Dto.setWindowId(egovResultDataList.get(i).getWindowId());    			/** column 화면아이디 : windowId */
							
							returnHist0300List.add(hist0300Dto);
//							returnHist0300List.add(egovResultDataList.get(i));
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					
					/** 에러 로그 **/			
					MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",ex, windowNm, windowId);
					
					// Return operation exception
				}
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm, windowId);
			}	
				
				/** 로그반영
				 * CRUDSBLO
				 * C:create		R:read		U:update
		    	 * D:delete		S:select	B:배치 
		    	 * L:로그인		O:로그아웃
		    	 */
				MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
				
				return returnHist0300List;
			}
	  
}
