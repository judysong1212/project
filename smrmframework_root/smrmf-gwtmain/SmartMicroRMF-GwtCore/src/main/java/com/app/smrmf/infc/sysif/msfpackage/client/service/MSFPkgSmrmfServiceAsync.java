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
package com.app.smrmf.infc.sysif.msfpackage.client.service;

import java.util.List;

import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0320DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0350DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0400DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;
 
public interface MSFPkgSmrmfServiceAsync {
	//단건에 대한 공통코드를 가져오는 함수
	 public void getSysIfComboBass0300List(SysIfBass0300DTO coreBass0300Dto, AsyncCallback<List<BaseModel>> callback);
	 
		//소속부서리스트을 가지고 온다
	 public void getSysIfWithBass0400List(AsyncCallback<List<BaseModel>> callback);
	 
	 public void getSysIfWithNoLoginBass0400List(AsyncCallback<List<BaseModel>> callback);
	 
	 
	//단건에 대한 공통코드를 가져오는 함수
		 public void getFuncBeforComboBass0400List(SysIfBass0400DTO sysIfBass0400Dto, AsyncCallback<SysIfBass0400DTO> callback); 
		 public void getFuncBeforComboBass0320List(SysIfBass0320DTO sysComBass0320Dto, AsyncCallback<SysIfBass0320DTO> callback); 
		 public void getFuncBeforComboBass0350List(SysIfBass0350DTO sysIfBass0350Dto, AsyncCallback<SysIfBass0350DTO> callback); 
		
			//직종가져오기 
			public void getSysIfComboTypOccuCdList(SysIfBass0320DTO sysComBass0320Dto, AsyncCallback<List<BaseModel>> callback);
			 
			//직종세구분을 가지고 온다.
			public void getSysIfComboBass0350List(SysIfBass0350DTO sysComBass0350Dto, AsyncCallback<List<BaseModel>> callback);
			
} 