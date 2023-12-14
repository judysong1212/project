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
package com.app.exterms.yearendtax.client.service.yeta2016;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1000BM;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1005BM;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Yeta1400Service.gwt")
public interface Yeta1400Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Yeta1400ServiceAsync instance;
		public static Yeta1400ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Yeta1400Service.class);
			}
			return instance;
		}
	}
	
	
	/** 전자신고기본정보 조회 **/
//	public Ye16Ta1000BM getYeta1400List(Ye16Ta1000BM yeta1000Bm) throws MSFException;
	public Ye16Ta1005BM getYeta1400List(Ye16Ta1000BM yeta1000Bm) throws MSFException;
	
	/** 정산마감 **/
	public Long finishOnYeta1000(Ye16Ta1000BM yeta1000Bm) throws MSFException;
	
	/** 전자신고기본정보 수정 **/
//	public Long updateYeta1000(Ye16Ta1000BM yeta1000Bm) throws MSFException;
	public Long updateYeta1000(Ye16Ta1005BM yeta1000Bm) throws MSFException;
}
