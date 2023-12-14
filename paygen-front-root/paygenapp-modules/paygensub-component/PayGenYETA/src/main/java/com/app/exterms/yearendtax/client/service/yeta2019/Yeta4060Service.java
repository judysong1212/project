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
package com.app.exterms.yearendtax.client.service.yeta2019;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2019.Ye160401DTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.Yeta4060DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Yeta4060Service.gwt")
public interface Yeta4060Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Yeta4060ServiceAsync instance;
		public static Yeta4060ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Yeta4060Service.class);
			}
			return instance;
		}
	}
	
	
	public String saveYeta4060(Yeta4060DTO dto,ActionDatabase actionDatabase) throws MSFException;
	
	public Long Yeta406001_Delete(List<Yeta4060DTO> listYeta4060Dto, ActionDatabase actionDatabase);
	
	public int chkYeta4060(Yeta4060DTO dto,ActionDatabase actionDatabase) throws MSFException;
	//public String saveBass0120(InfcBass0120DTO dto,ActionDatabase actionDatabase) throws Exception;
	
	public List<BaseModel> getParentDpobCd() throws MSFException;
	
	//public List<BaseModel> selectBass0120RetryCllnDebrDivCdList() throws Exception;
	
	public List<BaseModel> getYeta4060sysDivCdList() throws MSFException;
	
	/** 시스템 사업장 코드 **/
	public List<BaseModel> getSysDpobCd() throws MSFException;

	public int insertYetaS406001(Yeta4060DTO dto, ActionDatabase actionDatabase)throws MSFException;

	public Long Yeta406001NumUpdate(List<Yeta4060DTO> listYeta4060Dto,	ActionDatabase actionDatabase)throws MSFException;
	
	
	/** 삭제 방어 로직 **/
	public int delChkYeta4060(Yeta4060DTO dto,ActionDatabase actionDatabase) throws MSFException;
	
}
