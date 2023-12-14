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
package com.app.exterms.yearendtax.client.service.yeta2022;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161010DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Yeta7100Service.gwt")
public interface Yeta7100Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Yeta7100ServiceAsync instance;
		public static Yeta7100ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Yeta7100Service.class);
			}
			return instance;
		}
	}
	
    /** 연말정산 대상자 삭제 **/
    public Long Yeta7100ToYe160401_Delete(List<Ye161010DTO> listYe161010Dto ) throws MSFException ;
    
    /** 급여자료 이관 **/
    public Long PayrExec_Yeta_2022_Insert(List<Ye161010DTO> listYe161010Dto) throws MSFException ;
    
    /** 단위사업장맵핑 **/
    public Long UpDpobExec_Yeta_2022_Insert(List<Ye161010DTO> listYe161010Dto) throws MSFException ; 
    
	
}
