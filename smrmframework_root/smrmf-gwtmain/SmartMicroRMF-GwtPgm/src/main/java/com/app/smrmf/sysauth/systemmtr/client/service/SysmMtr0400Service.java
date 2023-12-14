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
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0300DTO;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0400BM;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("SysmMtr0400Service.gwt")
public interface SysmMtr0400Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static SysmMtr0400ServiceAsync instance;
		public static SysmMtr0400ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(SysmMtr0400Service.class);
			}
			return instance;
		}
	}
	
	
	  public String activityOnVoceMenuProfile(SysIfSysm0400BM voceMenuProfile, ActionDatabase actionDatabase);
	  
	  public List<SysIfSysm0400BM> getListaVociMenuProfile(SysIfSysm0300DTO profilo);
}
