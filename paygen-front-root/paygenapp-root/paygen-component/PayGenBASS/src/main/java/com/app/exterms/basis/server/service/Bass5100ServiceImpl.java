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

import com.app.exterms.basis.client.dto.Bass5100DTO;
import com.app.exterms.basis.client.service.Bass5100Service;
import com.app.exterms.basis.server.service.dao.Bass5100DAO;
import com.app.exterms.basis.shared.BasisDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
 
@Service("bass5100Service")
public class Bass5100ServiceImpl extends AbstractCustomServiceImpl implements Bass5100Service ,BasisDaoConstants{ 
		 
	 private static final Logger logger = LoggerFactory.getLogger(Bass5100ServiceImpl.class);
	 private static final String calledClass = Bass5100ServiceImpl.class.getName();
	    
	@Autowired
    @Resource(name="bass5100DAO")
    private Bass5100DAO bass5100DAO;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BaseListLoadResult<Bass5100DTO> selectBass0240(
			BaseListLoadConfig config, Bass5100DTO dtoParam) throws Exception {
		
		String method = calledClass + ".selectBass0240";
		
		String windowNm = "사대보험요율관리";
		String windowId = "INSR1100";
		
		List<Bass5100DTO> returnValue = new ArrayList<Bass5100DTO>();
		List egovResultDataList = new ArrayList();
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		dtoParam.setDpobCd(sessionUser.getDpobCd());
		
		try{
			egovResultDataList = bass5100DAO.selectBass0240(dtoParam);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Bass5100DTO dto = new Bass5100DTO();
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
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return new BaseListLoadResult<Bass5100DTO>(returnValue);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BaseListLoadResult<Bass5100DTO> selectBass0250(
			BaseListLoadConfig config, Bass5100DTO dtoParam) throws Exception {
		
		String method = calledClass + ".selectBass0250";
		List<Bass5100DTO> returnValue = new ArrayList<Bass5100DTO>();
		List egovResultDataList = new ArrayList();
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		dtoParam.setDpobCd(sessionUser.getDpobCd());
		
		String windowNm = "사대보험요율관리";
		String windowId = "INSR1100";
		
		try{
			
			egovResultDataList = bass5100DAO.selectBass0250(dtoParam);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Bass5100DTO dto = new Bass5100DTO();
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
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return new BaseListLoadResult<Bass5100DTO>(returnValue);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BaseListLoadResult<Bass5100DTO> selectBass0260(
			BaseListLoadConfig config, Bass5100DTO dtoParam) throws Exception {
		

		String method = calledClass + ".selectBass0260";
		
		String windowNm = "사대보험요율관리";
		String windowId = "INSR1100";
		
		List<Bass5100DTO> returnValue = new ArrayList<Bass5100DTO>();
		List egovResultDataList = new ArrayList();
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		dtoParam.setDpobCd(sessionUser.getDpobCd());
		
		try{
			egovResultDataList = bass5100DAO.selectBass0260(dtoParam);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Bass5100DTO dto = new Bass5100DTO();
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
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return new BaseListLoadResult<Bass5100DTO>(returnValue);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BaseListLoadResult<Bass5100DTO> selectBass0270(
			BaseListLoadConfig config, Bass5100DTO dtoParam) throws Exception {
		
		String method = calledClass + ".selectBass0270";
		
		String windowNm = "사대보험요율관리";
		String windowId = "INSR1100";
		
		List<Bass5100DTO> returnValue = new ArrayList<Bass5100DTO>();
		List egovResultDataList = new ArrayList();
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		dtoParam.setDpobCd(sessionUser.getDpobCd());
		
		
		try{
			
			egovResultDataList = bass5100DAO.selectBass0270(dtoParam);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Bass5100DTO dto = new Bass5100DTO();
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
		
		/** 로그반영
		 * CRUDSBLO
		 * C:create		R:read		U:update
    	 * D:delete		S:select	B:배치 
    	 * L:로그인		O:로그아웃
    	 */
		MSFLogHistoryUtils.tracerUserActivity(sessionUser, method, calledClass, "S");
		
		return new BaseListLoadResult<Bass5100DTO>(returnValue);
	}

	@Override
	public String saveBass0240(List<Bass5100DTO> list) throws Exception {
		int returnVal = 0; 
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		for(Bass5100DTO dto : list){
			dto.setIsmt(sessionUser.getUsrId());
			dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			if( dto.getDpobCd() == null || "".equals(dto.getDpobCd())){
				dto.setDpobCd(sessionUser.getDpobCd());
				bass5100DAO.insertBass0240(dto);
				bass5100DAO.updateBass0240EndDt(dto);
			}else{
				bass5100DAO.updateBass0240(dto);
			}
			returnVal++;
		}
		return returnVal+"";
	}

	@Override
	public String saveBass0250(List<Bass5100DTO> list) throws Exception {
		int returnVal = 0; 
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		for(Bass5100DTO dto : list){
			dto.setIsmt(sessionUser.getUsrId());
			dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			if( dto.getDpobCd() == null || "".equals(dto.getDpobCd())){
				dto.setDpobCd(sessionUser.getDpobCd());
				bass5100DAO.insertBass0250(dto);
				bass5100DAO.updateBass0250EndDt(dto);
			}else{
				bass5100DAO.updateBass0250(dto);
			}
			returnVal++;
		}
		return returnVal+"";
	}

	@Override
	public String saveBass0260(List<Bass5100DTO> list) throws Exception {
		int returnVal = 0; 
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		for(Bass5100DTO dto : list){
			dto.setIsmt(sessionUser.getUsrId());
			dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			if( dto.getDpobCd() == null || "".equals(dto.getDpobCd())){
				dto.setDpobCd(sessionUser.getDpobCd());
				bass5100DAO.insertBass0260(dto);
				bass5100DAO.updateBass0260EndDt(dto);
			}else{
				bass5100DAO.updateBass0260(dto);
			}
			returnVal++;
		}
		return returnVal+"";
	}

	@Override
	public String saveBass0270(List<Bass5100DTO> list) throws Exception {
		int returnVal = 0; 
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		for(Bass5100DTO dto : list){
			dto.setIsmt(sessionUser.getUsrId());
			dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			if( dto.getDpobCd() == null || "".equals(dto.getDpobCd())){
				dto.setDpobCd(sessionUser.getDpobCd());
				bass5100DAO.insertBass0270(dto);
				bass5100DAO.updateBass0270EndDt(dto);
			}else{
				bass5100DAO.updateBass0270(dto);
			}
			returnVal++;
		}
		return returnVal+"";
	}

	@Override
	public int deleteBass0240(List<Bass5100DTO> list) throws Exception {
		int returnVal = 0; 
		for(Bass5100DTO dto : list){
			returnVal += bass5100DAO.deleteBass0240(dto);
		}
		return returnVal;
	}

	@Override
	public int deleteBass0250(List<Bass5100DTO> list) throws Exception {
		int returnVal = 0; 
		for(Bass5100DTO dto : list){
			returnVal += bass5100DAO.deleteBass0250(dto);
		}
		return returnVal;
	}

	@Override
	public int deleteBass0260(List<Bass5100DTO> list) throws Exception {
		int returnVal = 0; 
		for(Bass5100DTO dto : list){
			returnVal += bass5100DAO.deleteBass0260(dto);
		}
		return returnVal;
	}

	@Override
	public int deleteBass0270(List<Bass5100DTO> list) throws Exception {
		int returnVal = 0; 
		for(Bass5100DTO dto : list){
			returnVal += bass5100DAO.deleteBass0270(dto);
		}
		return returnVal;
	}
//	@Override
//	public BaseListLoadResult<Bass5100DTO> selectBass0240(
//			BaseListLoadConfig config, Bass5100DTO dto) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public BaseListLoadResult<Bass5100DTO> selectBass0250(
//			BaseListLoadConfig config, Bass5100DTO dto) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public BaseListLoadResult<Bass5100DTO> selectBass0260(
//			BaseListLoadConfig config, Bass5100DTO dto) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public BaseListLoadResult<Bass5100DTO> selectBass0270(
//			BaseListLoadConfig config, Bass5100DTO dto) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String saveBass0240(List<Bass5100DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String saveBass0250(List<Bass5100DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String saveBass0260(List<Bass5100DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String saveBass0270(List<Bass5100DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int deleteBass0240(List<Bass5100DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int deleteBass0250(List<Bass5100DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int deleteBass0260(List<Bass5100DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int deleteBass0270(List<Bass5100DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}
}
