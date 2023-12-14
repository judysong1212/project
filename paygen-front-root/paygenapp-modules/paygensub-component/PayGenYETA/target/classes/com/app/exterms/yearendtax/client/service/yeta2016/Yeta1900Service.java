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
package com.app.exterms.yearendtax.client.service.yeta2016;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2017.Pyyt0302DTO;
import com.app.exterms.yearendtax.client.dto.yeta2017.Pyyt0304BM;
import com.app.exterms.yearendtax.client.dto.yeta2017.Pyyt0304DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Yeta1900Service.gwt")
public interface Yeta1900Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Yeta1900ServiceAsync instance;
		public static Yeta1900ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Yeta1900Service.class);
			}
			return instance;
		}
	}
	
    public int saveYeta1900ToPyyt0302(List<Pyyt0302DTO> listPyyt0302Dto, String flag) throws MSFException ;
    
    public int deleteYeta1900List(List<Pyyt0302DTO> listPyyt0302Dto) throws MSFException ;
    
    public Pyyt0304BM Yeta1900InfoList(Pyyt0304DTO Pyyt0304Dto) throws MSFException ;
    
    
//    
//    public Long PayrExec_Yeta_Insert(List<Yeta2000DTO> listYeta2000Dto ) throws MSFException ;
//    
//    
//  //  public PagingLoadResult<ShowMessageBM> savePayr06420_SelfAll_Create(Yeta2000DTO yeta2000Dto) throws MSFException ;
//    
//	public PagingLoadResult<ShowMessageBM> Payr06420_All_Create(Yeta1000DTO yeta1000Dto) throws MSFException ;   
//    
//    public PagingLoadResult<ShowMessageBM> Payr06420_All_Add_Create(Yeta1000DTO yeta1000Dto) throws MSFException ;
	
}
