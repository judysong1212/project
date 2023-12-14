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
package com.app.exterms.resm.client.service;

import java.util.List;

import com.app.exterms.resm.client.dto.Bass0350DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ResmP120001.gwt")
public interface ResmP120001Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static ResmP120001ServiceAsync instance;
		public static ResmP120001ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(ResmP120001Service.class);
			}
			return instance;
		}
	}

	public int trnrBeDtilOccuClsDivBass0350(List<Bass0350DTO> listBass0350Dto)throws MSFException;
	
	public int trnrAfDtilOccuClsDivBass0350(List<Bass0350DTO> listBass0350Dto)throws MSFException;
	
}
