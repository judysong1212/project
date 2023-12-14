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

import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PrgmComBass0350ServiceAsync {
	//직종가져오기 
	public void getPrgmComComboTypOccuCdList(PrgmComBass0320DTO sysComBass0320Dto, AsyncCallback<List<BaseModel>> callback);
	//직종가져오기 
	public void getPrgmNonTypOccuCdList(PrgmComBass0320DTO sysComBass0320Dto, AsyncCallback<List<BaseModel>> callback);
	//직종세구분을 가지고 온다.
	public void getPrgmComComboBass0350List(PrgmComBass0350DTO sysComBass0350Dto, AsyncCallback<List<BaseModel>> callback);
	//직종세구분을 가지고 온다.- 권한없이 불러오기 
	public void getPrgmComboNonBass0350List(PrgmComBass0350DTO sysComBass0350Dto, AsyncCallback<List<BaseModel>> callback);
	//급여직종세 콤보처리  
	public void getPrgmComComboPayrBass0350List(PrgmComBass0350DTO sysComBass0350Dto, AsyncCallback<List<BaseModel>> callback);
	
}
