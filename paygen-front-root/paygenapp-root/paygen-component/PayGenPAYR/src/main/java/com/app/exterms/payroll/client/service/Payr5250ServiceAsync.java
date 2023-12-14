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

import com.app.exterms.payroll.client.dto.Payr0416DTO;
import com.app.exterms.payroll.client.dto.Payr0417DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Payr5250ServiceAsync {
	
	/** 지급공제직종세 생성 **/
	public void activityOnPayr5250Insert(Payr0416DTO payr0416Dto, List<BaseModel> listModels, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	/** 지급공제직종세 삭제 **/
	public void activityOnPayr5250Delete(List<Payr0416DTO> listPayr0416Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	/** 지급공제항목 생성 **/
	public void activityOnPayr0417Insert(Payr0417DTO payr0417Dto,List<BaseModel> listModels, ActionDatabase actionDatabase, AsyncCallback<Long> callback);

	/** 지급공제항목 수정 **/
	public void activityOnPayr0417DetailFormSave(Payr0417DTO payr0417Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	
	//   public void activityOnPayr0417Insert(Payr0417DTO payr0415Dto,List<BaseModel> listModels, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
//	
//	public void activityOnPayr0410Insert(Payr0410DTO payr0410Dto,List<BaseModel> listModels, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
//    
//	
//	public void activityOnPayr5250BfToNew(Payr0417DTO payr0415Dto,List<BaseModel> listModels, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
//    
//	public void activityOnPayr0417Save(Payr0417DTO payr0415Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	 
}
