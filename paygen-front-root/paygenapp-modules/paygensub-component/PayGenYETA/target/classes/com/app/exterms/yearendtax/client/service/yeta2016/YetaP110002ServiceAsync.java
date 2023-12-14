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
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;





public interface YetaP110002ServiceAsync {
	
	
	/** 원천신고부서 리스트를 가져옴 **/
	public void getYeta2000YetaDpcdList(Ye16Ta1005DTO yeta161005Dto, AsyncCallback<List<BaseModel>> callback);
	
	/** 원천신고부서 리스트를 가져옴(권한x) **/
	public void getYeta2000YetaDpcdListNoAuth(AsyncCallback<List<BaseModel>> callback);
	
	
	/** 원천징수부서에 따른 사업자번호 리스트를 가져옴 **/
	public void getYeta2000busoprRgstnumList(Ye16Ta1005DTO yeta161005Dto, AsyncCallback<List<BaseModel>> callback);
	
	/** 선택한 사업자등록번호의 정보를 가져옴 **/
	public void getYe161005List(Ye16Ta1005DTO yeta161005Dto, AsyncCallback<Ye16Ta1005DTO> callback);
	
	
	/** 원천신고부서 등록/수정/삭제 **/
	public void saveYeta161005(Ye16Ta1005DTO ye16Ta1005Dto, ActionDatabase actionDatabase, AsyncCallback<Integer> callback);
	
	
	/** 원천신고부서대상자 원천신고부서 수정 **/
	public void saveYeta2000_YetaDpcd(List<Ye16Ta2000DTO> ye16Ta2000Dto, AsyncCallback<Integer> callback);
	
	
//	/** 연말정산 대상자 생성  **/
//	public void saveYetaP110001ToYeta1000(List<Ye16Ta1000DTO> listYeta1000Dto, AsyncCallback<PagingLoadResult<ShowMessageBM>> callback);
//	
//	public void deleteYeta1900List(List<Pyyt0302DTO> listPyyt0302Dto, AsyncCallback<Integer> callback);
//	
//	public void Yeta1900InfoList(Pyyt0304DTO pyyt0304Dto, AsyncCallback<Pyyt0304BM> callback);
	
	
}
