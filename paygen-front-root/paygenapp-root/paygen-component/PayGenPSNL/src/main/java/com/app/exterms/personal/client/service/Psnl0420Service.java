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

import com.app.exterms.personal.client.dto.Psnl0420DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Psnl0420Service.gwt")
public interface Psnl0420Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Psnl0420ServiceAsync instance;
		public static Psnl0420ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0420Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Psnl0420DTO> selectPsnl0420(BaseListLoadConfig config, Psnl0420DTO psnl0420DTO) throws Exception;
	
	public int updateIssueOk(List<Psnl0420DTO> list) throws Exception;
	
	

}
