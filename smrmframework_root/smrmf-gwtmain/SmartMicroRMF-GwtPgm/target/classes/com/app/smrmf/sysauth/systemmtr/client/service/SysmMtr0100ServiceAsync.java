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
package com.app.smrmf.sysauth.systemmtr.client.service;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.sysauth.systemmtr.client.dto.SysMtrSysm0050DTO;
import com.app.smrmf.sysauth.systemmtr.client.dto.SysMtrSysm0051DTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SysmMtr0100ServiceAsync {

	/** 시스템정보 저장/삭제 처리 **/
	public void saveSysMtr0050(SysMtrSysm0050DTO dto,ActionDatabase actionDatabase, AsyncCallback<Integer> callback);
	  
	/** 과세유형 삭제 확인 **/
	public void delChkSysMtr0050(List<SysMtrSysm0051DTO> dtoList, ActionDatabase actionDatabase, AsyncCallback<Integer> callback);	
	 
}
