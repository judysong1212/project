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
package com.app.exterms.yearendtax.client.service.yeta2021;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2021.Ye165030DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP63001Service.gwt")
public interface YetaP63001Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP63001ServiceAsync instance;
		public static YetaP63001ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP63001Service.class);
			}
			return instance;
		}
	}
	
	
	
	/** 이월기부금등록 팝업 수정 삭제**/
	public Long activityOnYetaP63001ToYe165030(List<Ye165030DTO> listYe165030Dto, ActionDatabase actionDatabase) throws MSFException;
}
