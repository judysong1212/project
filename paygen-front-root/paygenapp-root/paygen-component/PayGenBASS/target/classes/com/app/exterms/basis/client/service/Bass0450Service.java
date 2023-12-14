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
package com.app.exterms.basis.client.service;

import com.app.exterms.basis.client.dto.Bass0360DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Bass0450Service.gwt")
public interface Bass0450Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Bass0450ServiceAsync instance;
		public static Bass0450ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Bass0450Service.class);
			}
			return instance;
		}
	}
	public Long bass0360Insert(Bass0360DTO bass0360Dto) throws MSFException;
	
	public Long bass0360Delete(Bass0360DTO bass0360Dto) throws MSFException;
	
	//public List<BaseModel> getBass0150List() throws MSFException;	
	 

}