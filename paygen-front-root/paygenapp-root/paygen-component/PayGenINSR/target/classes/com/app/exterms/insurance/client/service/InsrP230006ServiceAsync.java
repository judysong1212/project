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

import com.app.exterms.insurance.client.dto.Insr2500DTO;
import com.app.exterms.insurance.client.dto.Insr2510DTO;
import com.app.exterms.insurance.client.dto.Insr2530DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface InsrP230006ServiceAsync {
	
	//public void activityOnInsertInsr2520(List<BaseModel> list, HashMap hMap, AsyncCallback<Long> asyncCallback);
	
	public void activityOnInsertInsr2520(List<BaseModel> list, Insr2500DTO insr2500Dto, List<Insr2510DTO> insr2510DtoArr, List<Insr2530DTO> insr2530DtoArr, AsyncCallback<Long> asyncCallback);
	
	public void activityOnSelectInsr2500Data(BaseModel baseModel, AsyncCallback<Insr2500DTO> asyncCallback);
	public void activityOnSelectInsr2510DataList(BaseModel baseModel, AsyncCallback<List<Insr2510DTO>> asyncCallback);
	public void activityOnSelectInsr2530DataList(BaseModel baseModel, AsyncCallback<List<Insr2530DTO>> asyncCallback);
	
}
