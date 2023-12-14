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

import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0800DTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SysmMtr0500ServiceAsync {

	public void sysm0800Delete(SysIfSysm0800DTO sysm0800Dto,  AsyncCallback<Long> callback);
	 
	 public void sysm0800Insert(SysIfSysm0800DTO sysm0800Dto,  AsyncCallback<Long> callback);
	 
 	  
}
