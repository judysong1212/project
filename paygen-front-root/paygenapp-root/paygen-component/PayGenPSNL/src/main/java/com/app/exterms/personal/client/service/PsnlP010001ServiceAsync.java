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
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;



public interface PsnlP010001ServiceAsync {
	
	
	
	/** 조회 **/
	public void selectPsnl0131(BaseListLoadConfig config, Psnl0131DTO psnl0131Dto, AsyncCallback<BaseListLoadResult<Psnl0131DTO>> callback);
	public void selectPsnl0131Data( Psnl0131DTO psnl0131Dto, AsyncCallback<Psnl0131DTO> callback);
	
	/** 데이터 등록 수정 삭제 **/
	public void savePsnl0131(Psnl0131DTO psnl0131Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
//	
//	public void selectPsnl0100Paging(PagingLoadConfig config, HashMap<String, String> param, AsyncCallback<PagingLoadResult<Psnl0100DTO>> callback);
//	
//	public void insertPsnl0100(Psnl0100DTO psnl0100Dto, AsyncCallback<String> callback);
//	public void updatePsnl0100(Psnl0100DTO psnl0100Dto, AsyncCallback<Integer> callback);
//	
//	/** 직종, 직종세 맵핑 **/
//	public void createPyspLogSvcYrNumCd(InfcPkgPayr0400DTO payr0400Dto, AsyncCallback<Long> callback);
//	
//	/** 고용구분, 재직상태 변경 **/
//	public void updatePsnl0100Status(Psnl0100DTO psnl0100Dto, AsyncCallback<Integer> callback);
//	
//	public void deletePsnl0100(HashMap<String, String> hMap, AsyncCallback<Integer> callback);
//	
//	public void getExcelData(String fileFullPath, AsyncCallback<List<HashMap<String, String>>> callback);
//	 
//	
//	public void updateProcPsnl0100(Psnl0100DTO dto, AsyncCallback<String> callback);
//	
//	public void updateProcPsnl0100Return(Psnl0100DTO dto, AsyncCallback<Psnl0100DTO> callback);
//	
//	// 2014.10.06 주민번호로 인원 체크 하여 등록되어있는지 확인
//	public void selectPsnl0100Check(Psnl0100DTO dto, AsyncCallback<List<Psnl0100DTO>> callback);
//	
	 
	
}
