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

import java.util.List;

import com.app.exterms.basis.client.dto.Bass5100DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Bass5100Service.gwt")
public interface Bass5100Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Bass5100ServiceAsync instance;
		public static Bass5100ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Bass5100Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Bass5100DTO> selectBass0240(BaseListLoadConfig config, Bass5100DTO dto) throws Exception;
	public BaseListLoadResult<Bass5100DTO> selectBass0250(BaseListLoadConfig config, Bass5100DTO dto) throws Exception;
	public BaseListLoadResult<Bass5100DTO> selectBass0260(BaseListLoadConfig config, Bass5100DTO dto) throws Exception;
	public BaseListLoadResult<Bass5100DTO> selectBass0270(BaseListLoadConfig config, Bass5100DTO dto) throws Exception;
	
	public String saveBass0240(List<Bass5100DTO> list) throws Exception;
	public String saveBass0250(List<Bass5100DTO> list) throws Exception;
	public String saveBass0260(List<Bass5100DTO> list) throws Exception;
	public String saveBass0270(List<Bass5100DTO> list) throws Exception;
	
	public int deleteBass0240(List<Bass5100DTO> list) throws Exception;
	public int deleteBass0250(List<Bass5100DTO> list) throws Exception;
	public int deleteBass0260(List<Bass5100DTO> list) throws Exception;
	public int deleteBass0270(List<Bass5100DTO> list) throws Exception;
	
}
