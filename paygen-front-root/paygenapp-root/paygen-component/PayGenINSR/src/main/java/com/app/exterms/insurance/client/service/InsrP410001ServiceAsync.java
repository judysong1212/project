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

import com.app.exterms.payroll.client.dto.InfcPkgPayr0540DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface InsrP410001ServiceAsync {
	
	public void activityOnInsrP400001Payr0540( List<InfcPkgPayr0540DTO> listPayr0540dto , ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	public void activityOnInsertInsrP410001(List<BaseModel> mapModels, AsyncCallback<Long> callback) ;
	
	public void deleteInsrP410001(List<BaseModel> listModels,ActionDatabase actionDatabase, AsyncCallback<Long> callback);
    
}
