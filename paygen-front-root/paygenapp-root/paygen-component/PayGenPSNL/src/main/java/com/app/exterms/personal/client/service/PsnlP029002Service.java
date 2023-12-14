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

import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.dto.PsnlP029002DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PsnlP029002Service.gwt")
public interface PsnlP029002Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PsnlP029002ServiceAsync instance;
		public static PsnlP029002ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PsnlP029002Service.class);
			}
			return instance;
		}
	}
	
	public List<HashMap<String, String>> getPsnlP029002ExcelData(String fileFullPath) throws MSFException; 
	
	public Long updateXlsPsnl0126ToP029002(List<PsnlP029002DTO> insertPsnl0290026List)throws MSFException;
}
