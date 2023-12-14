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

import com.app.exterms.insurance.client.dto.Insr1100DTO;
import com.app.exterms.insurance.client.dto.Insr1200DTO;
import com.app.exterms.insurance.client.dto.Insr1550DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Insr2100Service.gwt")
public interface Insr2100Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Insr2100ServiceAsync instance;
		public static Insr2100ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Insr2100Service.class);
			}
			return instance;
		}
	}
	
	public Insr1200DTO activityOnReadInsr1200(Insr1200DTO insr1200Dto) throws MSFException ;
	
	public Insr1550DTO activityOnReadInsr1500(Insr1550DTO insr1550Dto) throws MSFException ;
	
	public Long activityOnDeleteInsr2100(Insr1100DTO insr1100Dto) throws MSFException ;
	
	public Long activityOnUpdateInsr2100(Insr1200DTO insr1200Dto) throws MSFException ;
	
	public Long countInsr1550(List<Insr1200DTO> insr1200Dto) throws MSFException ;
	
	
	public Long activityOnInsertInsr2100(List<BaseModel> mapModels) throws MSFException ;
	
	public Long updateInsr2100AllGridBatch(List<Insr1200DTO> insr1200Dto) throws MSFException ;
	
	public Long deleteInsr2100(List<Insr1200DTO> insr1200Dto) throws Exception;
	
	public Long activityOnInsr1500(List<Insr1550DTO> listPayr1500dto, ActionDatabase actionDatabase);
	
	public Long activityOnUpdateInsr1200(BaseModel bm) throws MSFException ;
	
	public Long activityOnUpdateInsr1550AndInsr1600(BaseModel bm) throws MSFException ;
	
}
