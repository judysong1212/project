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

import com.app.exterms.insurance.client.dto.Insr1100DTO;
import com.app.exterms.insurance.client.dto.Insr1200DTO;
import com.app.exterms.insurance.client.dto.Insr1550DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Insr2100ServiceAsync {
	
	public void activityOnReadInsr1200(Insr1200DTO insr1200Dto, AsyncCallback<Insr1200DTO> callback);
	
	public void activityOnReadInsr1500(Insr1550DTO insr1550Dto, AsyncCallback<Insr1550DTO> callback);
	
	public void activityOnDeleteInsr2100(Insr1100DTO insr1100Dto, AsyncCallback<Long> callback);
	
	public void activityOnUpdateInsr2100(Insr1200DTO insr1200Dto, AsyncCallback<Long> callback);
	
	public void activityOnInsertInsr2100(List<BaseModel> mapModels, AsyncCallback<Long> callback);
	
	public void updateInsr2100AllGridBatch(List<Insr1200DTO> insr1200Dto, AsyncCallback<Long> callback);
	
	public void deleteInsr2100(List<Insr1200DTO> insr1200Dto, AsyncCallback<Long> asyncCallback);
	
	public void countInsr1550(List<Insr1200DTO> insr1200Dto, AsyncCallback<Long> asyncCallback);
	
	public void activityOnInsr1500(List<Insr1550DTO> listPayr1500dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	public void activityOnUpdateInsr1200(BaseModel bm, AsyncCallback<Long> asyncCallback);
	
	public void activityOnUpdateInsr1550AndInsr1600(BaseModel bm, AsyncCallback<Long> asyncCallback);
	
}
