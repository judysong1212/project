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
package com.app.smrmf.core.msfmainapp.client.service;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfHist0300DTO;

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("SysmP330002Service.gwt")
public interface SysmP330002Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static SysmP330002ServiceAsync instance;
		public static SysmP330002ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(SysmP330002Service.class);
			}
			return instance;
		}
	}
	
	public List<BaseModel> getHourList() throws MSFException;
	public List<BaseModel> getMinuteList() throws MSFException;
	
	public List<SysIfHist0300DTO> resultListHist0300(SysIfHist0300DTO sysIfHist0300Dto)throws MSFException;
	
	
}
