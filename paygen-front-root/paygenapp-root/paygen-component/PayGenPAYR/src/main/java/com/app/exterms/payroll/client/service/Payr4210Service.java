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

import java.util.ArrayList;
import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0350DTO;
import com.app.exterms.payroll.client.dto.Payr0360DTO;
import com.app.exterms.prgm.client.dto.PrgmComPsnl0100DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Payr4210Service.gwt")
public interface Payr4210Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Payr4210ServiceAsync instance;
		public static Payr4210ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Payr4210Service.class);
			}
			return instance;
		}
	}
	
	   
	   
   public PagingLoadResult<ShowMessageBM>    setPayr4210ToPayCalculation(Payr0360DTO payr0360Dto, ActionDatabase actionDatabase);
	    
   public PagingLoadResult<ShowMessageBM>  setPayr4210ToPayCalcSeft(Payr0360DTO dtoPayr0360, ArrayList<PrgmComPsnl0100DTO> dtoListPsnl0100, ActionDatabase actionDatabase);
   
   public Long activityOnDeletePayr4210(Payr0360DTO payr0360Dto) throws MSFException ;
 
   public Payr0360DTO activityOnReadDtlPayr4210ToPayr0360(Payr0360DTO payr0360Dto) throws MSFException ;
   
   public Long  setPayr4210TPayr0360Update(Payr0360DTO payr0360Dto , ActionDatabase actionDatabase) throws MSFException ;
    
   public Long setPayr4210ToPayr0350Delete(List<Payr0350DTO> listPayr0350dto) throws MSFException ;	   
   
    
}
