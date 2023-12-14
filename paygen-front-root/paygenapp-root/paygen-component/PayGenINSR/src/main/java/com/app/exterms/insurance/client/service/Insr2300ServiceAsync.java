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

import com.app.exterms.insurance.client.dto.Insr2200DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Insr2300ServiceAsync {
	
	public void activityOnReadInsr2200(Insr2200DTO insr2200Dto, AsyncCallback<Insr2200DTO> callback);

	public void activityOnDeleteInsr2300(List<BaseModel> list, AsyncCallback<Long> asyncCallback);
	
	public void activityOnUpdateInsr2300(Insr2200DTO insr2200Dto, AsyncCallback<Long> callback);
	
	public void activityOnInsertInsr2300(List<BaseModel> mapModels, AsyncCallback<Long> callback);
	
	public void activityOnUpdateInsr2300(List<Insr2200DTO> insr2200Dto, AsyncCallback<Long> callback);
	
	//public void activityOnReadInsr230004(BaseModel bm, AsyncCallback<BaseModel> asyncCallback);
	
	public void activityOnUpdateInsr2100(BaseModel bm, AsyncCallback<Long> asyncCallback);
	
}
