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
package com.app.exterms.retirement.client.service;

import java.util.List;

import com.app.exterms.retirement.client.dto.Remt2000DTO;
import com.app.exterms.retirement.client.dto.Remt2100DTO;
import com.app.exterms.retirement.client.dto.Remt2200DTO;
import com.app.exterms.retirement.client.dto.Remt2300DTO;
import com.app.exterms.retirement.client.dto.Remt3100DTO;
import com.app.exterms.retirement.client.dto.RemtDays0100DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface Remt0100ServiceAsync {
	 

	public void activityOnInsertRemt0100(List<BaseModel> mapModels,Remt2000DTO remt2000Dto, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);

	public void activityOnReadRemt0100( Remt2000DTO remt2000Dto, AsyncCallback<Remt2000DTO> callback);
	
	public void activityOnPayrRemt0100Header( Remt2100DTO remt2100Dto, AsyncCallback<List<RemtDays0100DTO>> callback);
	
	public void activityOnReadRemt0100ToRemt3100( Remt3100DTO remt3100Dto, AsyncCallback<Remt3100DTO> callback);
	

	public void activityOnUpdateRemt0100Save( Remt2000DTO remt2000Dto, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
	
	public void activityOnDeleteRemt0100Save( Remt2000DTO remt2000Dto, AsyncCallback<Long> callback);
	  
	public void activityOnPayrCalc( List<Remt2000DTO> listRemt2000Dto, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
	 
	public void activityOnUpdateRemt0100ToPayrCalc( List<Remt2200DTO> listRemt2200dto, AsyncCallback<Long> callback);
	
	public void activityOnUpdateRemt0100ToPayrWfepCalc( List<Remt2200DTO> listRemt2200dto, AsyncCallback<Long> callback);
	
	public void activityOnSaveRemt2300DDucData(List<Remt2300DTO> listRemt2300dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	 
}
