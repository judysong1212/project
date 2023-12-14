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
package com.app.exterms.yearendtax.client.service.yeta2019;

import com.app.exterms.yearendtax.client.dto.yeta2019.Ye161005BM;
import com.app.exterms.yearendtax.client.dto.yeta2019.Ye161005DTO;
import com.app.exterms.yearendtax.client.dto.yeta2019.Ye161010DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Yeta4400Service.gwt")
public interface Yeta4400Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Yeta4400ServiceAsync instance;
		public static Yeta4400ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Yeta4400Service.class);
			}
			return instance;
		}
	}
	
	
	/** 전자신고기본정보 조회 **/
//	public Ye161005BM getYeta2400List(Ye161005BM yeta1000Bm) throws MSFException;
	public Ye161005BM getYeta4400List(Ye161005DTO ye161005Dto) throws MSFException;
	
	/** 정산마감 **/
	public Long finishOnYe161005(Ye161010DTO ye17Ta1010Dto) throws MSFException;
	
	/** 전자신고기본정보 수정 **/
//	public Long updateYe161005(Ye161005BM yeta1000Bm) throws MSFException;
	public Long updateYe161005(Ye161005DTO ye161005Dto) throws MSFException;
}
