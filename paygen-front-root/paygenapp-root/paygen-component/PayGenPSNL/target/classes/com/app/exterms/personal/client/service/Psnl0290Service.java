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
package com.app.exterms.personal.client.service;

import java.util.HashMap;
import java.util.List;

import com.app.exterms.personal.client.dto.Psnl0126DTO;
import com.app.exterms.personal.client.dto.Psnl0290DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseListLoadConfig;
import com.extjs.gxt.ui.client.data.BaseListLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Psnl0290Service.gwt")
public interface Psnl0290Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Psnl0290ServiceAsync instance;
		public static Psnl0290ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0290Service.class);
			}
			return instance;
		}
	}
	
	public BaseListLoadResult<Psnl0290DTO> selectPsnl0290(BaseListLoadConfig config, Psnl0290DTO dto) throws MSFException;
	
	//수정삭제
	public Long activityOnPsnl0126(List<Psnl0126DTO> listPsnl0126dto, ActionDatabase actionDatabase) throws MSFException;
	
	//휴가 마감 마감풀기
	public Long finishOnPsnl0126(List<Psnl0126DTO> listPsnl0126dto, ActionDatabase actionDatabase) throws MSFException;
	
	//휴가일수산정
    public Long createPsnl0126HolidayCount(HashMap<String, String> param, ActionDatabase actionDatabase) throws MSFException ;
	
	
	public String insertPsnl0290(List<Psnl0290DTO> list) throws Exception;
	public int updatePsnl0290(List<Psnl0290DTO> list) throws Exception;
	public int updatePsnl0290FixY(List<Psnl0290DTO> list) throws Exception;
	public int updatePsnl0290FixN(List<Psnl0290DTO> list) throws Exception;
	public int deletePsnl0290(List<Psnl0290DTO> list) throws Exception;
	
	

}
