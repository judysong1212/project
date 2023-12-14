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

import com.app.exterms.insurance.client.dto.Insr2500DTO;
import com.app.exterms.insurance.client.dto.Insr2510DTO;
import com.app.exterms.insurance.client.dto.Insr2530DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("InsrP230006Service.gwt")
public interface InsrP230006Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static InsrP230006ServiceAsync instance;
		public static InsrP230006ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(InsrP230006Service.class);
			}
			return instance;
		}
	}
	
	//public Long activityOnInsertInsr2520(List<BaseModel> list, HashMap hMap) throws MSFException;
	
	public Long activityOnInsertInsr2520(List<BaseModel> list, Insr2500DTO insr2500Dto, List<Insr2510DTO> insr2510DtoArr, List<Insr2530DTO> insr2530DtoArr) throws MSFException;
	
	public Insr2500DTO activityOnSelectInsr2500Data(BaseModel Object) throws MSFException;
	public List<Insr2510DTO> activityOnSelectInsr2510DataList(BaseModel Object) throws MSFException;
	public List<Insr2530DTO> activityOnSelectInsr2530DataList(BaseModel Object) throws MSFException;
}
