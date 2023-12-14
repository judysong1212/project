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
package com.app.exterms.basis.server.service;

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

import com.app.exterms.basis.client.dto.Bass0300DTOMng;
import com.app.exterms.basis.client.service.Bass0300Service;
import com.app.exterms.basis.server.service.dao.Bass0300DAO;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.BaseModel;

@Service("Bass0300Service")
public class Bass0300ServiceImpl  extends AbstractCustomServiceImpl implements  BasisDaoConstants ,Bass0300Service  {
	
	 private static final Logger logger = LoggerFactory.getLogger(Bass0300ServiceImpl.class);
	 private static final String calledClass = Bass0300ServiceImpl.class.getName();
	 
	@Autowired    
    @Resource(name="Bass0300DAO")
    private Bass0300DAO bass0300DAO;

//	@Override
//	public String insertBass0300(Bass0300DTO vo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void updateBass0300(Bass0300DTO vo) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteBass0300(Bass0300DTO vo) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Bass0300BM selectBass0300(Bass0300DTO vo) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Bass0300BM> selectBass0300List(Bass0300DTO searchVO) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int selectBass0300ListTotCnt(Bass0300DTO searchVO) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	/*############################## 코드관리 서비스 시작 ######################################*/

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BaseListLoadResult<Bass0300DTOMng> selectBass0300WorkList(
			BaseListLoadConfig config, Bass0300DTOMng dtoParam) throws MSFException {
		
		String windowNm = "코드관리";
		String windowId = "BASS0300";
		
		String method = calledClass + ".selectBass0300WorkList";
		MSFSysm0100BM sessionUser;

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		List<Bass0300DTOMng> returnValue = new ArrayList<Bass0300DTOMng>();
		List egovResultDataList = new ArrayList();
		
		try{
			egovResultDataList = bass0300DAO.selectBass0300WorkList(dtoParam);
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Bass0300DTOMng dto = new Bass0300DTOMng();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		dto.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		dto.set(key, tempMap.get(key));
		            	}
		            }
					returnValue.add(dto);
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
			
		
		return new BaseListLoadResult<Bass0300DTOMng>(returnValue);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Bass0300DTOMng> selectBass0300CodeList(
			BaseListLoadConfig config, Bass0300DTOMng dtoParam) throws MSFException {
		
		String method = calledClass + ".selectBass0300CodeList";
		MSFSysm0100BM sessionUser;
		
		String windowNm = "코드관리";
		String windowId = "BASS0300";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		List<Bass0300DTOMng> returnValue = new ArrayList<Bass0300DTOMng>();
		List egovResultDataList = new ArrayList();
		
		try{
			egovResultDataList = bass0300DAO.selectBass0300CodeList(dtoParam);
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Bass0300DTOMng dto = new Bass0300DTOMng();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		dto.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		dto.set(key, tempMap.get(key));
		            	}
		            }
					returnValue.add(dto);
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
			
		
		return new BaseListLoadResult<Bass0300DTOMng>(returnValue);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public BaseListLoadResult<Bass0300DTOMng> selectBass0300DtlCodeList(
			BaseListLoadConfig config, Bass0300DTOMng dtoParam) throws MSFException {
		
		String method = calledClass + ".selectBass0300DtlCodeList";
		MSFSysm0100BM sessionUser;
		
		String windowNm = "코드관리";
		String windowId = "BASS0300";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		List<Bass0300DTOMng> returnValue = new ArrayList<Bass0300DTOMng>();
		List egovResultDataList = new ArrayList();
		
		try{
			egovResultDataList = bass0300DAO.selectBass0300DtlCodeList(dtoParam);
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
	    	 */
			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Bass0300DTOMng dto = new Bass0300DTOMng();
					Map tempMap = (Map)egovResultDataList.get(i);
					Iterator<String> keys = tempMap.keySet().iterator();
					while( keys.hasNext() ){
			            String key = keys.next();
			            //형 타입이 숫자형일경우 형변환 해준다.
		            	if(tempMap.get(key) instanceof java.math.BigDecimal){
		            		dto.set(key, String.valueOf(tempMap.get(key)));
		            	}else{
		            		dto.set(key, tempMap.get(key));
		            	}
		            }
					returnValue.add(dto);
				}
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
			
		
		return new BaseListLoadResult<Bass0300DTOMng>(returnValue);
	}

	@Override
	public String saveBass0300(List<Bass0300DTOMng> changeList) throws MSFException {
		
		String windowNm = "코드관리";
		String windowId = "BASS0300";
		
		
		String method = calledClass + ".saveBass0300";
		
		MSFSysm0100BM sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		int saveCnt = 0;
		
		try{
			if(changeList!=null && changeList.size() > 0){
				for ( int i = 0; i < changeList.size(); i++){
					
					changeList.get(i).setIsmt(sessionUser.getUsrId());
					changeList.get(i).setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
					if(changeList.get(i).getDpobCd() != null && changeList.get(i).getCommCd() != null){
						bass0300DAO.updateBass0300(changeList.get(i));
						
		    			/** 로그반영
		    			 * CRUDSBLO
		    			 * C:create		R:read		U:update
		    	    	 * D:delete		S:select	B:배치 
		    	    	 * L:로그인		O:로그아웃
		    	    	 */
		    			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "U");
		    			
					}else{
						changeList.get(i).setDpobCd(sessionUser.getDpobCd());
						changeList.get(i).setCommCd(changeList.get(i).getRpsttvCd()+changeList.get(i).getDtlCd());
						bass0300DAO.insertBass0300(changeList.get(i));
						
		    			/** 로그반영
		    			 * CRUDSBLO
		    			 * C:create		R:read		U:update
		    	    	 * D:delete		S:select	B:배치 
		    	    	 * L:로그인		O:로그아웃
		    	    	 */
		    			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "C");
					}
						saveCnt++;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"C",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		return "저장:"+saveCnt;
	}

	@Override
	public int deleteBass0300(List<Bass0300DTOMng> delList) throws MSFException {
		int delCnt = 0;
		
		String method = calledClass + ".deleteBass0300";
		MSFSysm0100BM sessionUser;
		
		String windowNm = "코드관리";
		String windowId = "BASS0300";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		for ( int i = 0; i < delList.size(); i++){
			try {
				delCnt += bass0300DAO.deleteBass0300(delList.get(i));
				
    			/** 로그반영
    			 * CRUDSBLO
    			 * C:create		R:read		U:update
    	    	 * D:delete		S:select	B:배치 
    	    	 * L:로그인		O:로그아웃
    	    	 */
    			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D");
    			
				bass0300DAO.deleteBass0300DtlCode(delList.get(i));
				
    			/** 로그반영
    			 * CRUDSBLO
    			 * C:create		R:read		U:update
    	    	 * D:delete		S:select	B:배치 
    	    	 * L:로그인		O:로그아웃
    	    	 */
    			MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "D");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				/** 에러 로그 **/			
				MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"D",e, windowNm , windowId);
			}
		}
		return delCnt;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<BaseModel> getWorkList(Bass0300DTOMng dtoParam) throws MSFException {
		
		String method = calledClass + ".getWorkList";
		MSFSysm0100BM sessionUser;

		String windowNm = "코드관리";
		String windowId = "BASS0300";

		if (RemoteServiceUtil.getThreadLocalRequest() != null) {
			sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		} else {
			sessionUser = getUser();
		}
		
		List<BaseModel> returnValue = new ArrayList<BaseModel>();
		List egovResultDataList = new ArrayList();
		
		try{
			egovResultDataList = bass0300DAO.selectBass0300WorkList(dtoParam);
			
			/** 로그반영
			 * CRUDSBLO
			 * C:create		R:read		U:update
	    	 * D:delete		S:select	B:배치 
	    	 * L:로그인		O:로그아웃
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
			
			/** 에러 로그 **/			
			MSFLogHistoryUtils.tracerUserExceptionActivity(sessionUser,method,calledClass,"S",e, windowNm , windowId);
			
			throw MSFServerUtils.getOperationException(this.getClass().getName(), e, logger);
		}
		return returnValue;
	}

	/*############################## 코드관리 서비스 끝 ######################################*/
	
	
   
}
