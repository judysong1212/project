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
package com.app.smrmf.sysauth.systemusr.client.service;

import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.sysauth.systemusr.client.dto.SysmUsr0100DTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("SysmUsr0050Service.gwt")
public interface SysmUsr0050Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static SysmUsr0100ServiceAsync instance;
		public static SysmUsr0100ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(SysmUsr0050Service.class);
			}
			return instance;
		}
	}
	
	   public void batchServiceUser();
	   
		/**  사용자정보 저장 **/
		public int saveSysmUsr0100(SysmUsr0100DTO sysmUsr0100DTO, ActionDatabase actionDatabase)throws MSFException;
		
		/** 패스워드를 초기화할 근로자의 정보를 가져온다. **/
		public SysmUsr0100DTO getPwdInitUsrInfo(SysmUsr0100DTO sysmUsr0100Dto)throws MSFException;
		
}
