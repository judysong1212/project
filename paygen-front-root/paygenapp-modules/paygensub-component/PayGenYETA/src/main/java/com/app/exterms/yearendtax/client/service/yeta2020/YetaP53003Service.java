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
package com.app.exterms.yearendtax.client.service.yeta2020;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2020.Ye165010DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP53003Service.gwt")
public interface YetaP53003Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP53003ServiceAsync instance;
		public static YetaP53003ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP53003Service.class);
			}
			return instance;
		}
	}
	
	
	/** 기부금내역등록 팝업 수정 삭제**/
	public Long activityOnYetaP53003ToYe165010(List<Ye165010DTO> listYe165010Dto, ActionDatabase actionDatabase) throws MSFException;
}
