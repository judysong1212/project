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

import com.app.exterms.payroll.client.dto.Payr0440DTO;
import com.app.exterms.payroll.client.dto.Payr0445DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Payr5200Service.gwt")
public interface Payr5200Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Payr5200ServiceAsync instance;
		public static Payr5200ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Payr5200Service.class);
			}
			return instance;
		}
	}
	
	 public Long activityOnPayr5200(Payr0440DTO payr0440Dto, ActionDatabase actionDatabase);
	 
	 public Long activityOnPayr0440DetailFormSave(List<Payr0440DTO> listPayr0440dto, ActionDatabase actionDatabase);
 
	 public Long activityOnPayr0445DetailFormSave(List<Payr0445DTO> listPayr0445dto, ActionDatabase actionDatabase);
	 
}
