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
package com.app.exterms.yearendtax.client.service.yeta2015;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3120DTO;
import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3160DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP03004Service.gwt")
public interface YetaP03004Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP03004ServiceAsync instance;
		public static YetaP03004ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP03004Service.class);
			}
			return instance;
		}
	}
	
	
	/** 거주자간 주택임차차입금 원리금 상환액 - 금전소비대차계약  팝업 수정 삭제**/
	public Long activityOnYetaP03004ToYeta3120(List<Yeta3120DTO> listYeta3120dto, ActionDatabase actionDatabase) throws MSFException;

	/** 거주자간 주택임차차입금 원리금 상환액 - 임대차계약  팝업 수정 삭제**/
	public Long activityOnYetaP03004ToYeta3160(List<Yeta3160DTO> listYeta3160dto, ActionDatabase actionDatabase) throws MSFException;


}