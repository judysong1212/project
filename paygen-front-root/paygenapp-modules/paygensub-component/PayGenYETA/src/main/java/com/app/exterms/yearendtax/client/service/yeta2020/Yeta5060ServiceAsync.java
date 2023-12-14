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
package com.app.exterms.yearendtax.client.service.yeta2020;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2020.Yeta5060DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Yeta5060ServiceAsync {
	//public void saveBass0120(InfcBass0120DTO dto, ActionDatabase actionDatabase, AsyncCallback<String> callback );
	public void saveYeta5060(Yeta5060DTO dto, ActionDatabase actionDatabase, AsyncCallback<String> callback );
	
	public void chkYeta5060(Yeta5060DTO dto, ActionDatabase actionDatabase, AsyncCallback<Integer> callback );
	
	public void getParentDpobCd(AsyncCallback<List<BaseModel>> callback);							//최상위사업장
	//public void selectBass0120RetryCllnDebrDivCdList(AsyncCallback<List<BaseModel>> callback);		//징수의무자
	public void getYeta5060sysDivCdList(AsyncCallback<List<BaseModel>> callback);					//적용시스템
	
	
	/** 시스템 사업장 코드 **/
	public void getSysDpobCd(AsyncCallback<List<BaseModel>> callback);					//적용시스템

	public void Yeta506001_Delete(List<Yeta5060DTO> listYeta5060Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);

	public void insertYetaS506001(Yeta5060DTO dto, ActionDatabase actionDatabase,	AsyncCallback<Integer> callback);
	
	public void Yeta506001NumUpdate(List<Yeta5060DTO> listYeta5060Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	/** 삭제 방어 로직 **/
	public void delChkYeta5060(Yeta5060DTO dto, ActionDatabase actionDatabase, AsyncCallback<Integer> callback );
	
}
