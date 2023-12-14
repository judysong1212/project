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

import com.app.exterms.insurance.client.dto.Insr4200DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Insr3150Service.gwt")
public interface Insr3150Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Insr3150ServiceAsync instance;
		public static Insr3150ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Insr3150Service.class);
			}
			return instance;
		}
	}
	
	 public Long insr3150MnthUpdate(List<Insr4200DTO> listInsr4200dto, ActionDatabase actionDatabase) throws MSFException ;
}
