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

import com.app.exterms.basis.client.dto.Bass5100DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Bass5100ServiceAsync {
	public void selectBass0240(BaseListLoadConfig config, Bass5100DTO dto, AsyncCallback<BaseListLoadResult<Bass5100DTO>> callback);
	public void selectBass0250(BaseListLoadConfig config, Bass5100DTO dto, AsyncCallback<BaseListLoadResult<Bass5100DTO>> callback);
	public void selectBass0260(BaseListLoadConfig config, Bass5100DTO dto, AsyncCallback<BaseListLoadResult<Bass5100DTO>> callback);
	public void selectBass0270(BaseListLoadConfig config, Bass5100DTO dto, AsyncCallback<BaseListLoadResult<Bass5100DTO>> callback);
	
	public void saveBass0240(List<Bass5100DTO> list, AsyncCallback<String> callback);
	public void saveBass0250(List<Bass5100DTO> list, AsyncCallback<String> callback);
	public void saveBass0260(List<Bass5100DTO> list, AsyncCallback<String> callback);
	public void saveBass0270(List<Bass5100DTO> list, AsyncCallback<String> callback);
	
	public void deleteBass0240(List<Bass5100DTO> list, AsyncCallback<Integer> callback);
	public void deleteBass0250(List<Bass5100DTO> list, AsyncCallback<Integer> callback);
	public void deleteBass0260(List<Bass5100DTO> list, AsyncCallback<Integer> callback);
	public void deleteBass0270(List<Bass5100DTO> list, AsyncCallback<Integer> callback);
	
}
