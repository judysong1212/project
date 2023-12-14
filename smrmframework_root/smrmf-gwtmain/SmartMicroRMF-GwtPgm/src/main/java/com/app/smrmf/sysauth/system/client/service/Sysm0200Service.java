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

import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfSysm0200BM;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Sysm0200Service.gwt")
public interface Sysm0200Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Sysm0200ServiceAsync instance;
		public static Sysm0200ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Sysm0200Service.class);
			}
			return instance;
		}
	}
	
	public List<SysIfSysm0200BM> getListSysm0200Menu();
}
