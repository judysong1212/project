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

import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0320DTO;
import com.app.exterms.prgm.client.dto.PrgmComBass0350DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PrgmComBass0350Service.gwt")
public interface PrgmComBass0350Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PrgmComBass0350ServiceAsync instance;
		public static PrgmComBass0350ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PrgmComBass0350Service.class);
			}
			return instance;
		}
	}
	
	//직종가져오기 
	public List<BaseModel> getPrgmComComboTypOccuCdList(PrgmComBass0320DTO sysComBass0320Dto);
	//직종가져오기 
	public List<BaseModel> getPrgmNonTypOccuCdList(PrgmComBass0320DTO sysComBass0320Dto);
	//직종세구분을 가지고 온다.
	public List<BaseModel> getPrgmComComboBass0350List(PrgmComBass0350DTO sysComBass0350Dto);
	//직종세구분을 가지고 온다.권한없이 불러오기 
	public List<BaseModel> getPrgmComboNonBass0350List(PrgmComBass0350DTO sysComBass0350Dto);
	//급여직종세 콤보처리  
	public List<BaseModel> getPrgmComComboPayrBass0350List(PrgmComBass0350DTO sysComBass0350Dto);
	
}
