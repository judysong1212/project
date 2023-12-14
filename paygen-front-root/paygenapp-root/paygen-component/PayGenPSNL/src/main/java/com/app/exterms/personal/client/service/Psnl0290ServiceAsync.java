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

import com.app.exterms.personal.client.dto.Psnl0126DTO;
import com.app.exterms.personal.client.dto.Psnl0290DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Psnl0290ServiceAsync {
	
	//수정삭제
	public void activityOnPsnl0126(List<Psnl0126DTO> listDlgn0250dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback) ;
	
	//휴가 마감 마감풀기
	public void finishOnPsnl0126(List<Psnl0126DTO> listDlgn0250dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback) ;	
	
	//휴가일수산정
    public void createPsnl0126HolidayCount( HashMap<String, String> param, ActionDatabase actionDatabase, AsyncCallback<Long> callback) ;
    
    
    
	public void selectPsnl0290(BaseListLoadConfig config, Psnl0290DTO dto, AsyncCallback<BaseListLoadResult<Psnl0290DTO>> callback);
	public void insertPsnl0290(List<Psnl0290DTO> list, AsyncCallback<String> callback);
	public void updatePsnl0290(List<Psnl0290DTO> list, AsyncCallback<Integer> callback);
	public void updatePsnl0290FixY(List<Psnl0290DTO> list, AsyncCallback<Integer> callback);
	public void updatePsnl0290FixN(List<Psnl0290DTO> list, AsyncCallback<Integer> callback);
	public void deletePsnl0290(List<Psnl0290DTO> list, AsyncCallback<Integer> callback);
	

}
