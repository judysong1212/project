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

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1005DTO;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta2000DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP110002Service.gwt")
public interface YetaP110002Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP110002ServiceAsync instance;
		public static YetaP110002ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP110002Service.class);
			}
			return instance;
		}
	}
	
	/** 원천신고부서 리스트를 가져옴 **/
	public List<BaseModel> getYeta2000YetaDpcdList(Ye16Ta1005DTO yeta161005Dto) throws MSFException;
	
	/** 원천신고부서 리스트를 가져옴(권한x) **/
	public List<BaseModel> getYeta2000YetaDpcdListNoAuth() throws MSFException;
	
	/** 원천징수부서에 따른 사업자번호 리스트를 가져옴 **/
	public List<BaseModel> getYeta2000busoprRgstnumList(Ye16Ta1005DTO yeta161005Dto) throws MSFException;
	
	/** 선택한 사업자등록번호의 정보를 가져옴 **/
	public Ye16Ta1005DTO getYe161005List(Ye16Ta1005DTO yeta161005Dto) throws MSFException;
	
	
	/** 원천신고부서 등록/수정/삭제 **/
	public int saveYeta161005(Ye16Ta1005DTO ye16Ta1005Dto, ActionDatabase actionDatabase) throws MSFException ;
	
	/** 원천신고부서대상자 원천신고부서 수정 **/
	public int saveYeta2000_YetaDpcd(List<Ye16Ta2000DTO> ye16Ta2000Dto) throws MSFException ;
	
	
	
//	/** 연말정산 대상자 생성  **/
//    public PagingLoadResult<ShowMessageBM> saveYetaP110001ToYeta1000(List<Ye16Ta1000DTO> listYeta1000Dto) throws MSFException ;
//    
//    public int deleteYeta1900List(List<Pyyt0302DTO> listPyyt0302Dto) throws MSFException ;
//    
//    public Pyyt0304BM Yeta1900InfoList(Pyyt0304DTO Pyyt0304Dto) throws MSFException ;
//    
    
	
}
