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
package com.app.smrmf.sysauth.system.client.service;

import java.util.List;

import com.app.smrmf.infc.sysif.msfpackage.client.form.dto.SysIfHist0200DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Sysm3200ServiceAsync {
	public void deleteHist0200(List<SysIfHist0200DTO> listHist0200dto, AsyncCallback<Integer> callback ) ;
    
	public void getHourList(AsyncCallback<List<BaseModel>> callback);
	public void getMinuteList(AsyncCallback<List<BaseModel>> callback);
	
	// 점검내역 엑셀 추가_hieju 06.28
	public void getrequestdataList(AsyncCallback<List<BaseModel>> callback);
	
}
