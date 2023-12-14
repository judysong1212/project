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
package com.app.exterms.insurance.server.service;

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

import com.app.exterms.insurance.client.dto.Insr0200DTO;
import com.app.exterms.insurance.client.service.Insr1100Service;
import com.app.exterms.insurance.server.service.dao.Insr0200DAO;
import com.app.exterms.insurance.shared.InsrDaoConstants;
import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.server.service.impl.AbstractCustomServiceImpl;
import com.app.smrmf.core.msfmainapp.server.utils.MSFLogHistoryUtils;
import com.app.smrmf.core.msfmainapp.server.utils.MSFServerUtils;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
 
@Service("insr1100Service")
public class Insr1100ServiceImpl extends AbstractCustomServiceImpl implements Insr1100Service ,InsrDaoConstants{ 
		 
	 private static final Logger logger = LoggerFactory.getLogger(Insr1100ServiceImpl.class);
	 private static final String calledClass = Insr1100ServiceImpl.class.getName();
	    
	@Autowired
    @Resource(name="insr0200DAO")
    private Insr0200DAO insr0200DAO;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BaseListLoadResult<Insr0200DTO> selectInsr0240(
			BaseListLoadConfig config, Insr0200DTO dtoParam) throws Exception {
		
		String method = calledClass + ".selectInsr0240";
		
		String windowNm = "사대보험요율관리";
		String windowId = "INSR1100";
		
		List<Insr0200DTO> returnValue = new ArrayList<Insr0200DTO>();
		List egovResultDataList = new ArrayList();
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		
		dtoParam.setDpobCd(sessionUser.getDpobCd());
		
		try{
			egovResultDataList = insr0200DAO.selectInsr0240(dtoParam);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Insr0200DTO dto = new Insr0200DTO();
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
		
		return new BaseListLoadResult<Insr0200DTO>(returnValue);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BaseListLoadResult<Insr0200DTO> selectInsr0250(
			BaseListLoadConfig config, Insr0200DTO dtoParam) throws Exception {
		
		String method = calledClass + ".selectInsr0250";
		List<Insr0200DTO> returnValue = new ArrayList<Insr0200DTO>();
		List egovResultDataList = new ArrayList();
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		dtoParam.setDpobCd(sessionUser.getDpobCd());
		
		String windowNm = "사대보험요율관리";
		String windowId = "INSR1100";
		
		try{
			
			egovResultDataList = insr0200DAO.selectInsr0250(dtoParam);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Insr0200DTO dto = new Insr0200DTO();
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
		
		return new BaseListLoadResult<Insr0200DTO>(returnValue);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BaseListLoadResult<Insr0200DTO> selectInsr0260(
			BaseListLoadConfig config, Insr0200DTO dtoParam) throws Exception {
		

		String method = calledClass + ".selectInsr0260";
		
		String windowNm = "사대보험요율관리";
		String windowId = "INSR1100";
		
		List<Insr0200DTO> returnValue = new ArrayList<Insr0200DTO>();
		List egovResultDataList = new ArrayList();
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		dtoParam.setDpobCd(sessionUser.getDpobCd());
		
		try{
			egovResultDataList = insr0200DAO.selectInsr0260(dtoParam);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Insr0200DTO dto = new Insr0200DTO();
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
		
		return new BaseListLoadResult<Insr0200DTO>(returnValue);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public BaseListLoadResult<Insr0200DTO> selectInsr0270(
			BaseListLoadConfig config, Insr0200DTO dtoParam) throws Exception {
		
		String method = calledClass + ".selectInsr0270";
		
		String windowNm = "사대보험요율관리";
		String windowId = "INSR1100";
		
		List<Insr0200DTO> returnValue = new ArrayList<Insr0200DTO>();
		List egovResultDataList = new ArrayList();
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		dtoParam.setDpobCd(sessionUser.getDpobCd());
		
		
		try{
			
			egovResultDataList = insr0200DAO.selectInsr0270(dtoParam);
			
			if(egovResultDataList != null && egovResultDataList.size() > 0){
				for(int i = 0 ; i < egovResultDataList.size(); i++){
					Insr0200DTO dto = new Insr0200DTO();
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
		
		return new BaseListLoadResult<Insr0200DTO>(returnValue);
	}

	@Override
	public String saveInsr0240(List<Insr0200DTO> list) throws Exception {
		int returnVal = 0; 
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		for(Insr0200DTO dto : list){
			dto.setIsmt(sessionUser.getUsrId());
			dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			if( dto.getDpobCd() == null || "".equals(dto.getDpobCd())){
				dto.setDpobCd(sessionUser.getDpobCd());
				insr0200DAO.insertInsr0240(dto);
				insr0200DAO.updateInsr0240EndDt(dto);
			}else{
				insr0200DAO.updateInsr0240(dto);
			}
			returnVal++;
		}
		return returnVal+"";
	}

	@Override
	public String saveInsr0250(List<Insr0200DTO> list) throws Exception {
		int returnVal = 0; 
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		for(Insr0200DTO dto : list){
			dto.setIsmt(sessionUser.getUsrId());
			dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			if( dto.getDpobCd() == null || "".equals(dto.getDpobCd())){
				dto.setDpobCd(sessionUser.getDpobCd());
				insr0200DAO.insertInsr0250(dto);
				insr0200DAO.updateInsr0250EndDt(dto);
			}else{
				insr0200DAO.updateInsr0250(dto);
			}
			returnVal++;
		}
		return returnVal+"";
	}

	@Override
	public String saveInsr0260(List<Insr0200DTO> list) throws Exception {
		int returnVal = 0; 
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		for(Insr0200DTO dto : list){
			dto.setIsmt(sessionUser.getUsrId());
			dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			if( dto.getDpobCd() == null || "".equals(dto.getDpobCd())){
				dto.setDpobCd(sessionUser.getDpobCd());
				insr0200DAO.insertInsr0260(dto);
				insr0200DAO.updateInsr0260EndDt(dto);
			}else{
				insr0200DAO.updateInsr0260(dto);
			}
			returnVal++;
		}
		return returnVal+"";
	}

	@Override
	public String saveInsr0270(List<Insr0200DTO> list) throws Exception {
		int returnVal = 0; 
		MSFSysm0100BM  sessionUser = MSFServerUtils.getLoggedUser(RemoteServiceUtil.getThreadLocalRequest());
		for(Insr0200DTO dto : list){
			dto.setIsmt(sessionUser.getUsrId());
			dto.setRevnAddr(RemoteServiceUtil.getThreadLocalRequest().getRemoteHost());
			if( dto.getDpobCd() == null || "".equals(dto.getDpobCd())){
				dto.setDpobCd(sessionUser.getDpobCd());
				insr0200DAO.insertInsr0270(dto);
				insr0200DAO.updateInsr0270EndDt(dto);
			}else{
				insr0200DAO.updateInsr0270(dto);
			}
			returnVal++;
		}
		return returnVal+"";
	}

	@Override
	public int deleteInsr0240(List<Insr0200DTO> list) throws Exception {
		int returnVal = 0; 
		for(Insr0200DTO dto : list){
			returnVal += insr0200DAO.deleteInsr0240(dto);
		}
		return returnVal;
	}

	@Override
	public int deleteInsr0250(List<Insr0200DTO> list) throws Exception {
		int returnVal = 0; 
		for(Insr0200DTO dto : list){
			returnVal += insr0200DAO.deleteInsr0250(dto);
		}
		return returnVal;
	}

	@Override
	public int deleteInsr0260(List<Insr0200DTO> list) throws Exception {
		int returnVal = 0; 
		for(Insr0200DTO dto : list){
			returnVal += insr0200DAO.deleteInsr0260(dto);
		}
		return returnVal;
	}

	@Override
	public int deleteInsr0270(List<Insr0200DTO> list) throws Exception {
		int returnVal = 0; 
		for(Insr0200DTO dto : list){
			returnVal += insr0200DAO.deleteInsr0270(dto);
		}
		return returnVal;
	}
//	@Override
//	public BaseListLoadResult<Insr0200DTO> selectInsr0240(
//			BaseListLoadConfig config, Insr0200DTO dto) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public BaseListLoadResult<Insr0200DTO> selectInsr0250(
//			BaseListLoadConfig config, Insr0200DTO dto) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public BaseListLoadResult<Insr0200DTO> selectInsr0260(
//			BaseListLoadConfig config, Insr0200DTO dto) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public BaseListLoadResult<Insr0200DTO> selectInsr0270(
//			BaseListLoadConfig config, Insr0200DTO dto) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String saveInsr0240(List<Insr0200DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String saveInsr0250(List<Insr0200DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String saveInsr0260(List<Insr0200DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String saveInsr0270(List<Insr0200DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int deleteInsr0240(List<Insr0200DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int deleteInsr0250(List<Insr0200DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int deleteInsr0260(List<Insr0200DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int deleteInsr0270(List<Insr0200DTO> list) throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}
}
