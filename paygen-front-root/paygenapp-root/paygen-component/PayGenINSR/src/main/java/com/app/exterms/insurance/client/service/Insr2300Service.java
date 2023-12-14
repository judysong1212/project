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

import com.app.exterms.insurance.client.dto.Insr2200DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Insr2300Service.gwt")
public interface Insr2300Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Insr2300ServiceAsync instance;
		public static Insr2300ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Insr2300Service.class);
			}
			return instance;
		}
	}
	
    public Insr2200DTO activityOnReadInsr2200(Insr2200DTO insr2200Dto) throws MSFException ;
	
	public Long activityOnDeleteInsr2300(List<BaseModel> list) throws Exception;
	
	public Long activityOnUpdateInsr2300(Insr2200DTO insr2200Dto) throws MSFException ;
	
	public Long activityOnInsertInsr2300(List<BaseModel> mapModels) throws MSFException ;
	
	public Long activityOnUpdateInsr2300(List<Insr2200DTO> insr2200Dto)throws MSFException ;
	
	//public BaseModel activityOnReadInsr230004(BaseModel bm) throws MSFException ;
	
	public Long activityOnUpdateInsr2100(BaseModel bm) throws MSFException ;
	
}
