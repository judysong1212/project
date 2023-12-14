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
package com.app.exterms.retirement.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Remt0400Service.gwt")
public interface Remt0400Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Remt0400ServiceAsync instance;
		public static Remt0400ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Remt0400Service.class);
			}
			return instance;
		}
	}
	
//	/**
//     * REMT9000을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Remt9000VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertRemt9000(Remt9000VO vo) throws Exception;
//    
//    /**
//     * REMT9000을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Remt9000VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateRemt9000(Remt9000VO vo) throws Exception;
//    
//    /**
//     * REMT9000을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Remt9000VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteRemt9000(Remt9000VO vo) throws Exception;
//    
//    /**
//     * REMT9000을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Remt9000VO
//     * @return 조회한 REMT9000
//     * @exception Exception
//     */
//    Remt9000VO selectRemt9000(Remt9000VO vo) throws Exception;
//    
//    /**
//     * REMT9000 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT9000 목록
//     * @exception Exception
//     */
//    List selectRemt9000List(Remt9000SrhVO searchVO) throws Exception;
//    
//    /**
//     * REMT9000 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT9000 총 갯수
//     * @exception
//     */
//    int selectRemt9000ListTotCnt(Remt9000SrhVO searchVO);
}
