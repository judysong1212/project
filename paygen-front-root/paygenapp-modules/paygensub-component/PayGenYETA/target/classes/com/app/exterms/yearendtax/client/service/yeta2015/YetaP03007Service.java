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

import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3100DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("YetaP03007Service.gwt")
public interface YetaP03007Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static YetaP03007ServiceAsync instance;
		public static YetaP03007ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(YetaP03007Service.class);
			}
			return instance;
		}
	}
	
	/** 연금저축소득공제 팝업 수정 삭제**/
	public Long activityOnYetaP03007ToYeta3100(List<Yeta3100DTO> listYeta3100dto, ActionDatabase actionDatabase) throws MSFException;
}
