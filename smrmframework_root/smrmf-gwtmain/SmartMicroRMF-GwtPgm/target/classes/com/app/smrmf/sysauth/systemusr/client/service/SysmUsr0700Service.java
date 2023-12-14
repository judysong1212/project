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

import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0700DTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("SysmUsr0700Service.gwt")
public interface SysmUsr0700Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static SysmUsr0700ServiceAsync instance;
		public static SysmUsr0700ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(SysmUsr0700Service.class);
			}
			return instance;
		}
	}
	
	

	public Long sysm0700Insert(SysIfSysm0700DTO sysm0700Dto) throws MSFException;
	
	public Long sysm0700Delete(SysIfSysm0700DTO sysm0700Dto) throws MSFException;
}
