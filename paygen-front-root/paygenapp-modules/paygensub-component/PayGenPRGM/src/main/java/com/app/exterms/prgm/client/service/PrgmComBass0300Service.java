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
package com.app.exterms.prgm.client.service;

import java.util.HashMap;
import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0300DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PrgmComBass0300Service.gwt")
public interface PrgmComBass0300Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PrgmComBass0300ServiceAsync instance;
		public static PrgmComBass0300ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PrgmComBass0300Service.class);
			}
			return instance;
		}
	}
	 //단건에 대한 공통코드를 가져오는 함수
	 public List<BaseModel> getPrgmComComboBass0300List(PrgmComBass0300DTO sysComBass0300Dto);
	 //멀티건에 대한 공통코드를 가져오는 함수
	 public HashMap<String, List<BaseModel>> getPrgmComMultiComboBass0300List(PrgmComBass0300DTO sysComBass0300Dto);
	 
	 //멀티건에 대해 item 항목에 조건을 주어 조건에 해당하는 값을 가져오는 함수 
	 public HashMap<String, List<BaseModel>> getPrgmComMultiWithItemComboBass0300List(List<PrgmComBass0300DTO> lstBass0300Dto);
}
