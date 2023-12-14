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
package com.app.exterms.personal.client.service;

import java.util.List;

import com.app.exterms.basis.client.dto.InfcComBass0500DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("InfcPkgPsnl0100Service.gwt")
public interface InfcPkgPsnl0100Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static InfcPkgPsnl0100ServiceAsync instance;
		public static InfcPkgPsnl0100ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(InfcPkgPsnl0100Service.class);
			}
			return instance;
		}
	}
	  
	public List<BaseModel> getBusinList(InfcComBass0500DTO sysComBass0500Dto) throws Exception;
	  
}
