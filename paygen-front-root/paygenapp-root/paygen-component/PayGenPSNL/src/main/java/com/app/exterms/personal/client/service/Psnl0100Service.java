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

import java.util.HashMap;
import java.util.List;

import com.app.exterms.payroll.client.dto.InfcPkgPayr0400DTO;
import com.app.exterms.personal.client.dto.Psnl0100DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.extjs.gxt.ui.client.data.PagingLoadConfig;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Psnl0100Service.gwt")
public interface Psnl0100Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Psnl0100ServiceAsync instance;
		public static Psnl0100ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0100Service.class);
			}
			return instance;
		}
	}
	
	/** 직종, 직종세 맵핑 **/
    public Long createPyspLogSvcYrNumCd(InfcPkgPayr0400DTO payr0400Dto);
	
	public BaseListLoadResult<Psnl0100DTO> selectPsnl0100(BaseListLoadConfig config, HashMap<String, String> param) throws Exception;
	
	public PagingLoadResult<Psnl0100DTO> selectPsnl0100Paging(PagingLoadConfig config, HashMap<String, String> param) throws Exception;
	
	public String insertPsnl0100(Psnl0100DTO psnl0100Dto) throws MSFException;
	public int updatePsnl0100(Psnl0100DTO psnl0100Dto) throws Exception;
	public int deletePsnl0100(HashMap<String, String> hMap) throws Exception;
	
	/** 고용구분, 재직상태 변경 **/
	public int updatePsnl0100Status(Psnl0100DTO psnl0100Dto) throws Exception;
	
	public List<HashMap<String, String>> getExcelData(String fileFullPath) throws Exception; 
	
	public String updateProcPsnl0100(Psnl0100DTO dto) throws Exception;
	
	public Psnl0100DTO updateProcPsnl0100Return(Psnl0100DTO dto) throws Exception;
	
	// 2014.10.06 주민번호로 인원 체크 하여 등록되어있는지 확인
	public List<Psnl0100DTO> selectPsnl0100Check(Psnl0100DTO dto) throws Exception;
	 
	
}
