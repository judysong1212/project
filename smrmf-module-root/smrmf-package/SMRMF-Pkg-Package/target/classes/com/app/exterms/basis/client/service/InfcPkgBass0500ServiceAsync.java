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

import com.app.exterms.basis.client.dto.InfcPkgBass0500DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface InfcPkgBass0500ServiceAsync {
	
	public void getYearList(AsyncCallback<List<BaseModel>> callback);
	
	/** 생성된 사업의 년도를 가져옴 **/
	public void getBass0500BusinYrList(AsyncCallback<List<BaseModel>> callback);
	
	public void yeta2070ToBass0500OnUpdate(List<InfcPkgBass0500DTO> listPkgBass0500Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	public void yeta3070ToBass0500OnUpdate(List<InfcPkgBass0500DTO> listPkgBass0500Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	public void yeta2070ToBass0500OffUpdate(List<InfcPkgBass0500DTO> listPkgBass0500Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	public void yeta3070ToBass0500OffUpdate(List<InfcPkgBass0500DTO> listPkgBass0500Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
 
}
