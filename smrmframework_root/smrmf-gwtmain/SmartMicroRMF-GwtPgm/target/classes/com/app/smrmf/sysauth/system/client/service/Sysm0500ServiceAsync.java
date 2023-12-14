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
package com.app.smrmf.sysauth.system.client.service;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.admin.dto.system.MSFSysm0100BM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0500DTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Sysm0500ServiceAsync {
	public void activitySysm0300User(SysIfSysm0300DTO profiloUser, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	 
	 public void activityOnSysm0500User(SysIfSysm0500DTO profiloUser, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	 
	 
	 public void getListaSysm0500User(MSFSysm0100BM utente, AsyncCallback<List<SysIfSysm0500DTO>> callback);
	 
	 public void getListaSysm0300User(MSFSysm0100BM utente, AsyncCallback<List<SysIfSysm0300DTO>> callback);
	 
	 
}
