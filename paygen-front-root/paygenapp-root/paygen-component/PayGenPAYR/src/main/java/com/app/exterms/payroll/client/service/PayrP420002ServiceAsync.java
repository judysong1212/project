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
package com.app.exterms.payroll.client.service;

import java.util.HashMap;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0307DTO_XLS;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PayrP420002ServiceAsync {
	
	/** 급여 일괄 조정 내역 리스트를 읽어들인다. **/
	public void getPayrP420002ExcelData(String fileFullPath, AsyncCallback<List<HashMap<String, String>>> callback);
	
	/** 급여 일괄 조정 내역 리스트를 등록한다. **/
	public void updateXlsPayr0307ToP420002(List<Payr0307DTO_XLS> insertPayr0307List, AsyncCallback<List<Payr0307DTO_XLS>> Callback);
	
	
}
