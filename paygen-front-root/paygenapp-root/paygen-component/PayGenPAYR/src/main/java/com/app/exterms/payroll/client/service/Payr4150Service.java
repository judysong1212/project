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
import com.app.exterms.payroll.client.dto.Payr0301DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0100DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Payr4150Service.gwt")
public interface Payr4150Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Payr4150ServiceAsync instance;
		public static Payr4150ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Payr4150Service.class);
			}
			return instance;
		}
	}
	
	public Long activityOnPayr4150(Payr0301DTO payr0301Dto, ActionDatabase actionDatabase);
	
	public PagingLoadResult<ShowMessageBM>  setPayr4100ToPayCalculation(Payr0250DTO payr0250Dto);
	
	public PagingLoadResult<ShowMessageBM>   setPayr4100ToPayCalcSeft(Payr0250DTO dtoPayr0250, PrgmComPsnl0100DTO dtoPsnl0100);
	
	public PagingLoadResult<ShowMessageBM>   setPayr4100ToPayCalcMulti(Payr0250DTO dtoPayr0250,   List<PrgmComPsnl0100DTO> listDtoPsnl0100);
 
}
