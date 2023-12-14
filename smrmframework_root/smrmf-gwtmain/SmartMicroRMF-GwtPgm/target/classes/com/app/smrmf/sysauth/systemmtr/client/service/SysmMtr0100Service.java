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
package com.app.smrmf.sysauth.systemmtr.client.service;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.sysauth.systemmtr.client.dto.SysMtrSysm0050DTO;
import com.app.smrmf.sysauth.systemmtr.client.dto.SysMtrSysm0051DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("SysmMtr0100Service.gwt")
public interface SysmMtr0100Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static SysmMtr0100ServiceAsync instance;

		public static SysmMtr0100ServiceAsync getInstance() {
			if (instance == null) {
				instance = GWT.create(SysmMtr0100Service.class);
			}
			return instance;
		}
	}
	
	
	/** 시스템정보 저장/삭제 처리 **/
	public int saveSysMtr0050(SysMtrSysm0050DTO dto,ActionDatabase actionDatabase) throws MSFException;
 
	/** 과세유형 삭제 확인 **/
	public int delChkSysMtr0050(List<SysMtrSysm0051DTO> dtoList, ActionDatabase actionDatabase) throws MSFException;	 
	 
}
