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
package com.app.smrmf.syscom.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("SysMstr050100Service.gwt")
public interface SysMstr050100Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static SysMstr050100ServiceAsync instance;
		public static SysMstr050100ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(SysMstr050100Service.class);
			}
			return instance;
		}
	}

//	/**
//	 * MSTR_05_0100을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 SysMstr050100VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertSysMstr050100(SysMstr050100VO vo);
//    
//    /**
//	 * MSTR_05_0100을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 SysMstr050100VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    public void updateSysMstr050100(SysMstr050100VO vo);
//    
//    /**
//	 * MSTR_05_0100을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 SysMstr050100VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    public void deleteSysMstr050100(SysMstr050100VO vo);
//    
//    /**
//	 * MSTR_05_0100을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 SysMstr050100VO
//	 * @return 조회한 MSTR_05_0100
//	 * @exception Exception
//	 */
//    public SysMstr050100VO selectSysMstr050100(SysMstr050100VO vo);
//    
//    /**
//	 * MSTR_05_0100 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return MSTR_05_0100 목록
//	 * @exception Exception
//	 */
//    public List selectSysMstr050100List(SysMstr050100SrhVO searchVO);
//    
//    /**
//	 * MSTR_05_0100 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return MSTR_05_0100 총 갯수
//	 * @exception
//	 */
//    public int selectSysMstr050100ListTotCnt(SysMstr050100SrhVO searchVO);
    
}
