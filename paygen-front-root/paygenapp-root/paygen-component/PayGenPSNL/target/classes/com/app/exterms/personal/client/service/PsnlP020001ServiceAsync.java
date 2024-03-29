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
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PsnlP020001ServiceAsync {
	
	/** 기간제 인사 고용 내역 리스트를 읽어들인다 **/
	public void getPsnlP020002ExcelData(String fileFullPath, AsyncCallback<List<HashMap<String, String>>> callback);
	
	/** 기간제 신규 고용 내역을 등록한다. **/
	public void updateXlsPsnl0110ToP020002(List<Psnl0110DTO> insertPsnl0110List, AsyncCallback<List<Psnl0110DTO>> Callback);
	
//	public void exportDataList(List<Psnl0110DTO> insertPsnl0110List, AsyncCallback<HashMap<String, Object>> Callback);
	
//	public void selectDataList(Psnl0110DTO psnl0110DTO, AsyncCallback<String> Callback);
	
	
}
