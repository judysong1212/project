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
package com.app.exterms.diligence.client.service;

import com.app.exterms.diligence.client.dto.Dlgn0100DTO;
import com.app.exterms.diligence.client.dto.Dlgn0200DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("DlgnP010001Service.gwt")
public interface DlgnP010001Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static DlgnP010001ServiceAsync instance;
		public static DlgnP010001ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(DlgnP010001Service.class);
			}
			return instance;
		}
	}
	
	
	/**  기본 및 시간외근무 근태 생성 **/
//	public int generateAllWorkTime(Dlgn0100DTO dlgn0100Dto, Dlgn0200DTO dlgn0200Dto)throws MSFException;
	
	public PagingLoadResult<ShowMessageBM> generateAllWorkTime(Dlgn0100DTO dlgn0100Dto, Dlgn0200DTO dlgn0200Dto)throws MSFException;
	
}
