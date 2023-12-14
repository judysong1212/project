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

import com.app.exterms.payroll.client.dto.Payr0250DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PayrP405001Service.gwt")
public interface PayrP405001Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PayrP405001ServiceAsync instance;
		public static PayrP405001ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PayrP405001Service.class);
			}
			return instance;
		}
	}
	
	
	/**  급여스케줄 일괄생성 **/
//	public int createSchedulePayrP405001(Payr0250DTO payr0250Dto)throws MSFException;
	public PagingLoadResult<ShowMessageBM> createSchedulePayrP405001(Payr0250DTO payr0250Dto)throws MSFException;
	
	/**  캘린더에서 해당일자들을 가져옴 **/
	public List<BaseModel> selectCoCalendar(Payr0250DTO payr0250Dto)throws MSFException;
	
}
