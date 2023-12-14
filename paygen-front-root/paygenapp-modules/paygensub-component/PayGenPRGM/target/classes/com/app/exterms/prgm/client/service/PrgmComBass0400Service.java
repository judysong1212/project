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

import com.app.exterms.prgm.client.dto.PrgmComBass0400DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PrgmComBass0400Service.gwt")
public interface PrgmComBass0400Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PrgmComBass0400ServiceAsync instance;
		public static PrgmComBass0400ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PrgmComBass0400Service.class);
			}
			return instance;
		}
	}
	
	//관리부서리스트을 가지고 온다
	 public List<BaseModel> getPrgmComMangDeptBass0400List(PrgmComBass0400DTO sysComBass0400Dto);
	//소속부서리스트을 가지고 온다
	 public List<BaseModel> getPrgmComWithBass0400List();
	//급여부서리스트을 가지고 온다
    public List<BaseModel> getPayrWithBass0400List(PrgmComBass0400DTO sysComBass0400Dto);
	//관리부서선택에 따른 소속부서 가져오기  
	public List<BaseModel> getPrgmComDeptBass0400List(PrgmComBass0400DTO sysComBass0400Dto);
}
