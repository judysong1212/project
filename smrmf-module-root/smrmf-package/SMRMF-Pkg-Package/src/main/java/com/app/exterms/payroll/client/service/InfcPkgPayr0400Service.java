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
package com.app.exterms.payroll.client.service;

import com.app.exterms.payroll.client.dto.InfcPkgPayr0400DTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("InfcPayr0400Service.gwt")
public interface InfcPkgPayr0400Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static InfcPkgPayr0400ServiceAsync instance;
		public static InfcPkgPayr0400ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(InfcPkgPayr0400Service.class);
			}
			return instance;
		}
	}
	
//	public List<BaseModel> getYearList() throws Exception;
	
	/** 직종, 직종세 맵핑 후 근속년수 생성 **/
	public InfcPkgPayr0400DTO createPyspLogSvcYrNumCd(InfcPkgPayr0400DTO infcPayr0400Dto);
 
}
