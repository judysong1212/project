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

import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("PayrP525001Service.gwt")
public interface PayrP525001Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static PayrP525001ServiceAsync instance;
		public static PayrP525001ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(PayrP525001Service.class);
			}
			return instance;
		}
	}
	
	/** 직종세 이관 **/
	public Long activityOnPayr0416Copy(List<BaseModel> list, BaseModel bm) throws Exception;
	
	
//	public Long activityOnPayr0415Insert(Payr0415DTO payr0415Dto,List<BaseModel> listModels, ActionDatabase actionDatabase);
//	
//	public Long activityOnPayr0410Insert(Payr0410DTO payr0410Dto,List<BaseModel> listModels, ActionDatabase actionDatabase);
//    
//	
//	public Long activityOnPayr1500BfToNew(Payr0415DTO payr0415Dto,List<BaseModel> listModels, ActionDatabase actionDatabase);
//    
//	public Long activityOnPayr0415Save(Payr0415DTO payr0415Dto, ActionDatabase actionDatabase);
//	
//	//payr410 data update 
//	public Long activityOnPayr0410DetailFormSave(Payr0410DTO payr0410Dto, ActionDatabase actionDatabase);
//	 
//	 
//	public Long activityOnPayr0415Copy(List<BaseModel> list, BaseModel bm) throws Exception;
//	
//	public Long activityOnPayr150002ToPayr0410Insert(List<BaseModel> list, Payr0410DTO payr0410Dto) throws Exception;
	
	
}
