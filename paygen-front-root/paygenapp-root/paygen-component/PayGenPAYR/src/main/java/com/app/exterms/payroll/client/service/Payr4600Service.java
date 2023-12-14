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
package com.app.exterms.payroll.client.service;

import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0600DTO;
import com.app.exterms.payroll.client.dto.Payr0650DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Payr4600Service.gwt")
public interface Payr4600Service extends RemoteService {

	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Payr4600ServiceAsync instance;
		public static Payr4600ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Payr4600Service.class);
			}
			return instance;
		}
	}

	long savePayr4600(Payr0600DTO payr0600DTO, ActionDatabase actionDatabase);

	long deletePayr4600(List<Payr0650DTO> payr0650DTO, ActionDatabase actionDatabase);

	long savePayr0600PentrInfo(Payr0600DTO payr0600DTO, ActionDatabase actionDatabase);

}
