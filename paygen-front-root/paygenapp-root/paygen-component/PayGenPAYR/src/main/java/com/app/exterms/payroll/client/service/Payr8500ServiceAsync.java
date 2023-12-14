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

import com.app.exterms.retirement.client.dto.InfcPkgRemt2000DTO;
import com.app.exterms.retirement.client.dto.InfcPkgRemt2100DTO;
import com.app.exterms.retirement.client.dto.InfcPkgRemt2200DTO;
import com.app.exterms.retirement.client.dto.InfcPkgRemtDays0100DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;




public interface Payr8500ServiceAsync {
	
	/** 산정결과 **/
	public void activityOnReadPayr8500ToRemt0100(InfcPkgRemt2000DTO remt2000Dto, AsyncCallback<InfcPkgRemt2000DTO> callback);
	
	/** 급여내역 퇴직금 재산정 **/
	public void activityOnUpdatePayr8500ToRemt0100ToPayrCalc(List<InfcPkgRemt2200DTO> listRemt2200dto, AsyncCallback<Long> callback);
	
	/** 후생복지비 퇴직금 재산정 **/
	public void activityOnUpdatePayr8500ToRemt0100ToPayrWfepCalc( List<InfcPkgRemt2200DTO> listRemt2200dto, AsyncCallback<Long> callback);
	
	/** 급여지급기간 셋팅 **/
	public void activityOnPayr8500ToRemt0100Header(InfcPkgRemt2100DTO remt2100Dto, AsyncCallback<List<InfcPkgRemtDays0100DTO>> callback);
	
	public void activityOnInsertPayr8500ToRemt0100(List<BaseModel> mapModels,InfcPkgRemt2000DTO remt2000Dto, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
	
	
	
//	public void deletePayr4200(List<InfcPayr0304DTO> listInfcPayr0304Dto , ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	 
}
