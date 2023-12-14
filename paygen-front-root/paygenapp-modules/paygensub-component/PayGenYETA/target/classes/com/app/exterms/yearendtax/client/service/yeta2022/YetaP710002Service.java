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

import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161005DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Ye161010DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP710002Service.gwt")
public interface YetaP710002Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP710002ServiceAsync instance;
		public static YetaP710002ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP710002Service.class);
			}
			return instance;
		}
	}
	
//	/** 원천신고부서 리스트를 가져옴 **/
//	public List<BaseModel> getYeta2000YetaDpcdList(Ye16Ta1005DTO yeta161005Dto) throws MSFException;
//	
//	/** 원천신고부서 리스트를 가져옴(권한x) **/
//	public List<BaseModel> getYeta2000YetaDpcdListNoAuth() throws MSFException;
//	
//	/** 원천징수부서에 따른 사업자번호 리스트를 가져옴 **/
//	public List<BaseModel> getYeta2000busoprRgstnumList(Ye16Ta1005DTO yeta161005Dto) throws MSFException;
//	

	
	
	/** 원천신고부서 수정 **/
	public int saveYetaP710002ToYeta161005(Ye161005DTO ye161005DTO, ActionDatabase actionDatabase) throws MSFException ;
	
	/** 원천신고부서대상자 원천신고부서 반영  **/
	public int saveYetaP710002ToYe161010(List<Ye161010DTO> ye161010Dto) throws MSFException ;
	
	/** 원천신고부서 정보를 가져옴 **/
	public Ye161005DTO getYe161005Data(Ye161005DTO ye161005DTO) throws MSFException;
    
	
}
