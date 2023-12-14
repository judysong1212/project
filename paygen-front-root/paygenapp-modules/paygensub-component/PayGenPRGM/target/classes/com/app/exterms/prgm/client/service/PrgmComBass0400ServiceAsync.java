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
package com.app.exterms.prgm.client.service;

import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PrgmComBass0400ServiceAsync {
	//관리부서리스트을 가지고 온다
	 public void getPrgmComMangDeptBass0400List(PrgmComBass0400DTO sysComBass0400Dto,AsyncCallback<List<BaseModel>> callback);
	//소속부서리스트을 가지고 온다
	 public void getPrgmComWithBass0400List(AsyncCallback<List<BaseModel>> callback);
	//급여부서리스트을 가지고 온다
    public void getPayrWithBass0400List(PrgmComBass0400DTO sysComBass0400Dto, AsyncCallback<List<BaseModel>> callback);
	//관리부서선택에 따른 소속부서 가져오기  
	public void getPrgmComDeptBass0400List(PrgmComBass0400DTO sysComBass0400Dto, AsyncCallback<List<BaseModel>> callback);
}
