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
package com.app.exterms.personal.client.service;

import com.app.exterms.personal.client.dto.Psnl0131DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Psnl0131Service.gwt")
public interface PsnlP010001Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PsnlP010001ServiceAsync instance;
		public static PsnlP010001ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PsnlP010001Service.class);
			}
			return instance;
		}
	}
	
	/** 조회 **/
	public BaseListLoadResult<Psnl0131DTO> selectPsnl0131(BaseListLoadConfig config, Psnl0131DTO psnl0131Dto) throws MSFException;	
	public Psnl0131DTO selectPsnl0131Data(Psnl0131DTO psnl0131Dto) throws MSFException;	
	
	/** 데이터 등록 수정 삭제 **/
	public Long savePsnl0131(Psnl0131DTO psnl0131Dto, ActionDatabase actionDatabase) throws MSFException;
	
//	
//	/** 직종, 직종세 맵핑 **/
//    public Long createPyspLogSvcYrNumCd(InfcPkgPayr0400DTO payr0400Dto);
//	
//	public BaseListLoadResult<Psnl0131DTO> selectPsnl0131(BaseListLoadConfig config, HashMap<String, String> param) throws Exception;
//	
//	public PagingLoadResult<Psnl0131DTO> selectPsnl0131Paging(PagingLoadConfig config, HashMap<String, String> param) throws Exception;
//	
//	public String insertPsnl0131(Psnl0131DTO psnl0131Dto) throws MSFException;
//	public int updatePsnl0131(Psnl0131DTO psnl0131Dto) throws Exception;
//	public int deletePsnl0131(HashMap<String, String> hMap) throws Exception;
//	
//	/** 고용구분, 재직상태 변경 **/
//	public int updatePsnl0131Status(Psnl0131DTO psnl0131Dto) throws Exception;
//	
//	public List<HashMap<String, String>> getExcelData(String fileFullPath) throws Exception; 
//	
//	public String updateProcPsnl0131(Psnl0131DTO dto) throws Exception;
//	
//	public Psnl0131DTO updateProcPsnl0131Return(Psnl0131DTO dto) throws Exception;
//	
//	// 2014.10.06 주민번호로 인원 체크 하여 등록되어있는지 확인
//	public List<Psnl0131DTO> selectPsnl0131Check(Psnl0131DTO dto) throws Exception;
//	 
	
}
