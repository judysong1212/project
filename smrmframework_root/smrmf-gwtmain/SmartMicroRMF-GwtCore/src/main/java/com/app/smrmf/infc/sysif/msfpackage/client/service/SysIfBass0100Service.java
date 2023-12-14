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
package com.app.smrmf.infc.sysif.msfpackage.client.service;

import java.util.List;

import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfBass0100DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("SysIfBass0100Service.gwt")
public interface SysIfBass0100Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static SysIfBass0100ServiceAsync instance;
		public static SysIfBass0100ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(SysIfBass0100Service.class);
			}
			return instance;
		}
	}
	
	
	public String saveBass0100(SysIfBass0100DTO dto,ActionDatabase actionDatabase) throws MSFException;
	
	public int chkBass0100(SysIfBass0100DTO dto,ActionDatabase actionDatabase) throws MSFException;
	//public String saveBass0100(InfcSysIfBass0100VO dto,ActionDatabase actionDatabase) throws Exception;
	
	public List<BaseModel> getParentDpobCd() throws MSFException;
	
	//public List<BaseModel> selectBass0100RetryCllnDebrDivCdList() throws Exception;
	
	public List<BaseModel> getBass0100sysDivCdList() throws MSFException;
	
	/** 시스템 사업장 코드 **/
	public List<BaseModel> getSysDpobCd() throws MSFException;
}
