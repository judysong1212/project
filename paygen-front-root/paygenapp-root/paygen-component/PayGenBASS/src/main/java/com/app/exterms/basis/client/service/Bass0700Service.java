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

import com.app.exterms.basis.client.dto.Bass1000DTO;
import com.app.exterms.basis.client.dto.Bass2000DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Bass0700Service.gwt")
public interface Bass0700Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Bass0700ServiceAsync instance;
		public static Bass0700ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Bass0700Service.class);
			}
			return instance;
		}
	}
	
    public Long Payr06420_Payr400_Delete(List<Bass2000DTO> listBass2000Dto ) throws MSFException ;
    
    public Long PayrExec_Yeta_Insert(List<Bass2000DTO> listBass2000Dto ) throws MSFException ;
    
    
  //  public PagingLoadResult<ShowMessageBM> savePayr06420_SelfAll_Create(Yeta2000DTO yeta2000Dto) throws MSFException ;
    
	public PagingLoadResult<ShowMessageBM> Payr06420_All_Create(Bass1000DTO bass1000Dto) throws MSFException ;   
    
    public PagingLoadResult<ShowMessageBM> Payr06420_All_Add_Create(Bass1000DTO bass1000Dto) throws MSFException ;
	
}
