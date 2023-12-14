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
package com.app.exterms.basis.client.service;

import java.util.List;

import com.app.exterms.basis.client.dto.Bass0120DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Bass0120ServiceAsync {
	//public void saveBass0120(InfcBass0120DTO dto, ActionDatabase actionDatabase, AsyncCallback<String> callback );
	public void saveBass0120(Bass0120DTO dto, ActionDatabase actionDatabase, AsyncCallback<String> callback );
	
	public void chkBass0120(Bass0120DTO dto, ActionDatabase actionDatabase, AsyncCallback<Integer> callback );
	
	public void getParentDpobCd(AsyncCallback<List<BaseModel>> callback);							//최상위사업장
	//public void selectBass0120RetryCllnDebrDivCdList(AsyncCallback<List<BaseModel>> callback);		//징수의무자
	public void getBass0120sysDivCdList(AsyncCallback<List<BaseModel>> callback);					//적용시스템
	
	
	/** 시스템 사업장 코드 **/
	public void getSysDpobCd(AsyncCallback<List<BaseModel>> callback);					//적용시스템
}
