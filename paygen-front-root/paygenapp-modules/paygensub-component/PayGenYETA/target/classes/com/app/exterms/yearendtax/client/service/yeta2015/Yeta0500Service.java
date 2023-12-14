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

import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta2000DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Yeta0500Service.gwt")
public interface Yeta0500Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Yeta0500ServiceAsync instance;
		public static Yeta0500ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Yeta0500Service.class);
			}
			return instance;
		}
	}
	
	/** 당월급여반영 **/
	public Long activityOnYeta0500List(List<Yeta2000DTO> listYeta2000dto) throws MSFException;
	
	/** 그리드 수정 **/
	public Long saveYeta0500Grid(List<Yeta2000DTO> listYeta2000dto) throws MSFException;
	
	
//	/** 전자신고기본정보 조회 **/
//	public Yeta1000BM getYeta0400List(Yeta1000BM yeta1000Bm) throws MSFException;
//	
//	/** 정산마감 **/
//	public Long finishOnYeta1000(Yeta1000BM yeta1000Bm) throws MSFException;
//	
//	/** 전자신고기본정보 수정 **/
//	public Long updateYeta1000(Yeta1000BM yeta1000Bm) throws MSFException;
}
