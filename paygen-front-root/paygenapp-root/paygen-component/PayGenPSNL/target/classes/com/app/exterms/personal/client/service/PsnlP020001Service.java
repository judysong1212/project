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

import com.app.exterms.personal.client.dto.Psnl0110DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PsnlP020001Service.gwt")
public interface PsnlP020001Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PsnlP020001ServiceAsync instance;
		public static PsnlP020001ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PsnlP020001Service.class);
			}
			return instance;
		}
	}
	
	
	/** 기간제 인사 고용 내역 리스트를 읽어들인다. **/
	public List<HashMap<String, String>> getPsnlP020002ExcelData(String fileFullPath) throws MSFException; 
	
	/** 기간제 신규 고용 내역을 등록한다. **/
	public List<Psnl0110DTO> updateXlsPsnl0110ToP020002(List<Psnl0110DTO> insertPsnl0110List)throws MSFException;
	
	
//	public HashMap<String, Object> exportDataList (List<Psnl0110DTO> insertPsnl0110List)throws MSFException;
	
	/** 기간제 신규 고용 내역을 등록한다. **/
//	public String selectDataList(Psnl0110DTO psnl0110DTO)throws MSFException;
	
}
