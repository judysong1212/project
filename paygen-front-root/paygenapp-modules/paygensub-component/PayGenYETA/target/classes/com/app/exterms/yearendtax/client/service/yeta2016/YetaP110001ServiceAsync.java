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
package com.app.exterms.yearendtax.client.service.yeta2016;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1000DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.user.client.rpc.AsyncCallback;




public interface YetaP110001ServiceAsync {
	
	/** 연말정산 대상자 생성  **/
	public void saveYetaP110001ToYeta1000(List<Ye16Ta1000DTO> listYeta1000Dto, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
//	
//	public void deleteYeta1900List(List<Pyyt0302DTO> listPyyt0302Dto, AsyncCallback<Integer> callback);
//	
//	public void Yeta1900InfoList(Pyyt0304DTO pyyt0304Dto, AsyncCallback<Pyyt0304BM> callback);
	
	
}
