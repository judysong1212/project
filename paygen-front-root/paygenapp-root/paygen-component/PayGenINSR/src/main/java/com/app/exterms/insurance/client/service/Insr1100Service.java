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
package com.app.exterms.insurance.client.service;

import java.util.List;

import com.app.exterms.insurance.client.dto.Insr0200DTO;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Insr1100Service.gwt")
public interface Insr1100Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Insr1100ServiceAsync instance;
		public static Insr1100ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Insr1100Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Insr0200DTO> selectInsr0240(BaseListLoadConfig config, Insr0200DTO dto) throws Exception;
	public BaseListLoadResult<Insr0200DTO> selectInsr0250(BaseListLoadConfig config, Insr0200DTO dto) throws Exception;
	public BaseListLoadResult<Insr0200DTO> selectInsr0260(BaseListLoadConfig config, Insr0200DTO dto) throws Exception;
	public BaseListLoadResult<Insr0200DTO> selectInsr0270(BaseListLoadConfig config, Insr0200DTO dto) throws Exception;
	
	public String saveInsr0240(List<Insr0200DTO> list) throws Exception;
	public String saveInsr0250(List<Insr0200DTO> list) throws Exception;
	public String saveInsr0260(List<Insr0200DTO> list) throws Exception;
	public String saveInsr0270(List<Insr0200DTO> list) throws Exception;
	
	public int deleteInsr0240(List<Insr0200DTO> list) throws Exception;
	public int deleteInsr0250(List<Insr0200DTO> list) throws Exception;
	public int deleteInsr0260(List<Insr0200DTO> list) throws Exception;
	public int deleteInsr0270(List<Insr0200DTO> list) throws Exception;
	
}
