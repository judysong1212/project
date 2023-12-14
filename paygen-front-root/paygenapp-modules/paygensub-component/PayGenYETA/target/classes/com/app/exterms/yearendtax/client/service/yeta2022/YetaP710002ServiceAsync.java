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
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;





public interface YetaP710002ServiceAsync {
	
	
//	/** 원천신고부서 리스트를 가져옴 **/
//	public void getYeta2000YetaDpcdList(Ye16Ta1005DTO yeta161005Dto, AsyncCallback<List<BaseModel>> callback);
//	
//	/** 원천신고부서 리스트를 가져옴(권한x) **/
//	public void getYeta2000YetaDpcdListNoAuth(AsyncCallback<List<BaseModel>> callback);
//	
//	
//	/** 원천징수부서에 따른 사업자번호 리스트를 가져옴 **/
//	public void getYeta2000busoprRgstnumList(Ye16Ta1005DTO yeta161005Dto, AsyncCallback<List<BaseModel>> callback);
//	

	
	
	/** 원천신고부서 수정 **/
	public void saveYetaP710002ToYeta161005(Ye161005DTO ye161005DTO, ActionDatabase actionDatabase, AsyncCallback<Integer> callback);
	
	
	/** 원천신고부서대상자 원천신고부서 수정 **/
	public void saveYetaP710002ToYe161010(List<Ye161010DTO> ye161010Dto, AsyncCallback<Integer> callback);
	
	
	/** 원천신고부서 정보를 가져옴 **/
	public void getYe161005Data(Ye161005DTO ye161005DTO, AsyncCallback<Ye161005DTO> callback);
	
	
}
