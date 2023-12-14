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
package com.app.exterms.yearendtax.client.service.yeta2017;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2017.Ye160404DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;



/**
 * @Class Name : YetaP23006Service.java
 * @since : 2017. 12. 13. 
 * @version : 2.2.0
 * @author : DaEun
 *
 * Copyright (C)  All right reserved.
 */
@RemoteServiceRelativePath("YetaP23006Service.gwt")
public interface YetaP23006Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP23006ServiceAsync instance;
		public static YetaP23006ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP23006Service.class);
			}
			return instance;
		}
	}
	
	/** 종전근무지등록 팝업 신규, 삭제, 저장 **/
	public Long activityOnYetaP23006ToYe160404(List<Ye160404DTO> listYe160404Dto, ActionDatabase actionDatabase) throws MSFException;
}
