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
package com.app.exterms.payroll.client.service;

import java.util.List;

import com.app.exterms.diligence.client.dto.InfcPkgDlgn0250DTO;
import com.app.exterms.payroll.client.dto.InfcPkgPayr0304DTO;
import com.app.exterms.payroll.client.dto.Payr0302DTO;
import com.app.exterms.payroll.client.dto.Payr0307DTO;
import com.app.exterms.payroll.client.dto.Payr0470DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Payr4200ServiceAsync {
	public void activityOnPayr4200(List<Payr0307DTO> listPayr0307dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	public void deletePayr4200(List<InfcPkgPayr0304DTO> listInfcPayr0304Dto , ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	 
    public void activityOnCalcPayr4200(Payr0307DTO payr0307dto, AsyncCallback<Long> callback);
    
    /** 지급공제구분에 따른 지급공제항목 가져옴 **/
	public void getPayDducExtpyCd(Payr0470DTO payr0470dDto, AsyncCallback<List<BaseModel>> callback);
    
	public void activityOnExtpyPayr4200(List<Payr0302DTO> listPayr0302dto, ActionDatabase actionDatabase, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
	
	public void activityOnDDucPayr4200(List<Payr0302DTO> listPayr0302dto, ActionDatabase actionDatabase, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
	
	 public void getDlgn250Data(InfcPkgDlgn0250DTO infcPkgDlgn0250Dto, AsyncCallback<InfcPkgDlgn0250DTO> callback);
	 
	   
}
