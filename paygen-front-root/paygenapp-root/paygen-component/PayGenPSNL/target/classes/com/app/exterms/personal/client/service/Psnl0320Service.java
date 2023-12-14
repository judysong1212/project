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

import com.app.exterms.personal.client.dto.Psnl0119DTO;
import com.app.exterms.personal.client.dto.Psnl0122DTO;
import com.app.exterms.personal.client.dto.Psnl0320DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Psnl0320Service.gwt")
public interface Psnl0320Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Psnl0320ServiceAsync instance;
		public static Psnl0320ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Psnl0320Service.class);
			}
			return instance;
		}
	}

	//고용 업데이트
	public Long updatePsnl0110(List<Psnl0320DTO> psnl0320DTO) throws MSFException ;

	//경력 업데이트
	public Long updatePsnl0119(List<Psnl0119DTO> psnl0119DTO) throws MSFException ;

	//징계 업데이트
	public Long updatePsnl0122(List<Psnl0122DTO> psnl0122DTO) throws MSFException ;

	//호봉재획정이력 적재
	public Psnl0320DTO savePsnl0320(Psnl0320DTO psnl0320DTO) throws MSFException ;

	//호봉재획정이력 결과조회
	public List<HashMap<String, String>> selectPsnl0320(HashMap<String, String> param) throws Exception;
	
	public Psnl0320DTO updatePsnl0100(Psnl0320DTO psnl0320DTO) throws MSFException ;
}