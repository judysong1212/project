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
package com.app.smrmf.sysauth.systemusr.client.service;

import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.sysauth.systemusr.client.dto.SysmUsr0100DTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SysmUsr0100ServiceAsync {
	    
	    public void batchServiceUser(AsyncCallback<Void> callback);
	   
		/**  사용자정보 저장 **/
		public void saveSysmUsr0100(SysmUsr0100DTO sysmUsr0100DTO, ActionDatabase actionDatabase, AsyncCallback<Integer> callback);
		
		/** 패스워드를 초기화할 근로자의 정보를 가져온다. **/
		public void getPwdInitUsrInfo(SysmUsr0100DTO sysmUsr0100Dto, AsyncCallback<SysmUsr0100DTO> callback);
		
}
