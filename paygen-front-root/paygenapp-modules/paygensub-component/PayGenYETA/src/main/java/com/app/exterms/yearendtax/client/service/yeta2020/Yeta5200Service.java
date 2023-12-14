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

import com.app.exterms.yearendtax.client.dto.yeta2020.Ye161010DTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Yeta5200Service.gwt")
public interface Yeta5200Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Yeta5200ServiceAsync instance;
		public static Yeta5200ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Yeta5200Service.class);
			}
			return instance;
		}
	}
	
	  String yetaChangeConvert(Ye161010DTO ye161010Dto) throws Exception;
}
