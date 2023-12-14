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
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface Psnl0320ServiceAsync {

	//고용 업데이트
	public void updatePsnl0110(List<Psnl0320DTO> psnl0320DTO, AsyncCallback<Long> asyncCallback);

	//경력 업데이트
	public void updatePsnl0119(List<Psnl0119DTO> psnl0119DTO, AsyncCallback<Long> asyncCallback);

	//징계 업데이트
	public void updatePsnl0122(List<Psnl0122DTO> psnl0122DTO, AsyncCallback<Long> asyncCallback);

	//호봉재획정이력 적재
	public void savePsnl0320(Psnl0320DTO psnl0320DTO, AsyncCallback<Psnl0320DTO> asyncCallback);

	//호봉재획정이력 결과조회
	public void selectPsnl0320(HashMap<String, String> param, AsyncCallback<List<HashMap<String, String>>> callback);
	
	//인사 마스터 업데이트
	public void updatePsnl0100(Psnl0320DTO psnl0320DTO, AsyncCallback<Psnl0320DTO> asyncCallback);
}