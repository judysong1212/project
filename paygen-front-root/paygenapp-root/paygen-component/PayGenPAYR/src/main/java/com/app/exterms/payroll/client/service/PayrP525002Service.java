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

import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0417DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PayrP525002Service.gwt")
public interface PayrP525002Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PayrP525002ServiceAsync instance;
		public static PayrP525002ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PayrP525002Service.class);
			}
			return instance;
		}
	}
	
	/** 직종세지급항목일괄생성 **/
	public Long activityOnPayr525002ToPayr0417Insert(List<BaseModel> list, Payr0417DTO payr0417Dto) throws Exception;
	
	
}
