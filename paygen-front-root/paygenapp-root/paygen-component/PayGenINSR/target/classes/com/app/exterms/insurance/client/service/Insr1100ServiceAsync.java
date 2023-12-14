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
package com.app.exterms.insurance.client.service;

import java.util.List;

import com.app.exterms.insurance.client.dto.Insr0200DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Insr1100ServiceAsync {
	public void selectInsr0240(BaseListLoadConfig config, Insr0200DTO dto, AsyncCallback<BaseListLoadResult<Insr0200DTO>> callback);
	public void selectInsr0250(BaseListLoadConfig config, Insr0200DTO dto, AsyncCallback<BaseListLoadResult<Insr0200DTO>> callback);
	public void selectInsr0260(BaseListLoadConfig config, Insr0200DTO dto, AsyncCallback<BaseListLoadResult<Insr0200DTO>> callback);
	public void selectInsr0270(BaseListLoadConfig config, Insr0200DTO dto, AsyncCallback<BaseListLoadResult<Insr0200DTO>> callback);
	
	public void saveInsr0240(List<Insr0200DTO> list, AsyncCallback<String> callback);
	public void saveInsr0250(List<Insr0200DTO> list, AsyncCallback<String> callback);
	public void saveInsr0260(List<Insr0200DTO> list, AsyncCallback<String> callback);
	public void saveInsr0270(List<Insr0200DTO> list, AsyncCallback<String> callback);
	
	public void deleteInsr0240(List<Insr0200DTO> list, AsyncCallback<Integer> callback);
	public void deleteInsr0250(List<Insr0200DTO> list, AsyncCallback<Integer> callback);
	public void deleteInsr0260(List<Insr0200DTO> list, AsyncCallback<Integer> callback);
	public void deleteInsr0270(List<Insr0200DTO> list, AsyncCallback<Integer> callback);
	
}
