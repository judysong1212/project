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

import com.app.exterms.yearendtax.client.dto.yeta2022.Ye160401DTO;
import com.app.exterms.yearendtax.client.dto.yeta2022.Yeta7060DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Yeta7060Service.gwt")
public interface Yeta7060Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Yeta7060ServiceAsync instance;
		public static Yeta7060ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Yeta7060Service.class);
			}
			return instance;
		}
	}
	
	
	public String saveYeta7060(Yeta7060DTO dto,ActionDatabase actionDatabase) throws MSFException;
	
	public Long Yeta706001_Delete(List<Yeta7060DTO> listYeta7060Dto, ActionDatabase actionDatabase);
	
	public int chkYeta7060(Yeta7060DTO dto,ActionDatabase actionDatabase) throws MSFException;
	//public String saveBass0120(InfcBass0120DTO dto,ActionDatabase actionDatabase) throws Exception;
	
	public List<BaseModel> getParentDpobCd() throws MSFException;
	
	//public List<BaseModel> selectBass0120RetryCllnDebrDivCdList() throws Exception;
	
	public List<BaseModel> getYeta7060sysDivCdList() throws MSFException;
	
	/** 시스템 사업장 코드 **/
	public List<BaseModel> getSysDpobCd() throws MSFException;

	public int insertYetaS706001(Yeta7060DTO dto, ActionDatabase actionDatabase)throws MSFException;

	public Long Yeta706001NumUpdate(List<Yeta7060DTO> listYeta7060Dto,	ActionDatabase actionDatabase)throws MSFException;
	
	
	/** 삭제 방어 로직 **/
	public int delChkYeta7060(Yeta7060DTO dto,ActionDatabase actionDatabase) throws MSFException;
	
}
