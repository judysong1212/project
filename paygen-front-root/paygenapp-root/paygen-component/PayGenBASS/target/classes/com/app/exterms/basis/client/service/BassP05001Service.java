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
package com.app.exterms.basis.client.service;

import java.util.List;

import com.app.exterms.basis.client.dto.Bass0500DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("BassP05001Service.gwt")
public interface BassP05001Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static BassP05001ServiceAsync instance;
		public static BassP05001ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(BassP05001Service.class);
			}
			return instance;
		}
	}
	
	
	/**  사업이관 **/
	public int trnrBusinBass0500(List<Bass0500DTO> listBass0500Dto)throws MSFException;
	
}
