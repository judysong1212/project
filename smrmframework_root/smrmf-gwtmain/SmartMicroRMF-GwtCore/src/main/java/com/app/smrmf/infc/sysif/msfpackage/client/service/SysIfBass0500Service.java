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

import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0500DTO;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("SysIfBass0500Service.gwt")
public interface SysIfBass0500Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static SysIfBass0500ServiceAsync instance;
		public static SysIfBass0500ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(SysIfBass0500Service.class);
			}
			return instance;
		}
	}
	
	 public List<BaseModel> getSysComWithBass0500List(SysIfBass0500DTO sysComBass0500Dto);
//	 public List<BaseModel> getSysComWithBusinApptnYr(SysIfBass0500DTO sysComBass0500Dto);
//	 public List<BaseModel> getSysComWithMultiBass0500List(SysIfBass0500DTO sysComBass0500Dto);
	 
}
