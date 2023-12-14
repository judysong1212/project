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
package com.app.smrmf.core.msfmainapp.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Bord0200Service.gwt")
public interface Bord0200Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Bord0200ServiceAsync instance;
		public static Bord0200ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Bord0200Service.class);
			}
			return instance;
		}
	}
	
//
//	/**
//	 * BORD0200을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Bord0200VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertBord0200(Bord0200VO vo);
//    
//    /**
//	 * BORD0200을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Bord0200VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    public void updateBord0200(Bord0200VO vo);
//    
//    /**
//	 * BORD0200을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Bord0200VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    public void deleteBord0200(Bord0200VO vo);
//    
//    /**
//	 * BORD0200을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Bord0200VO
//	 * @return 조회한 BORD0200
//	 * @exception Exception
//	 */
//    public Bord0200VO selectBord0200(Bord0200VO vo);
//    
//    /**
//	 * BORD0200 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BORD0200 목록
//	 * @exception Exception
//	 */
//    public List selectBord0200List(Bord0200SrhVO searchVO);
//    
//    /**
//	 * BORD0200 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BORD0200 총 갯수
//	 * @exception
//	 */
//    public int selectBord0200ListTotCnt(Bord0200SrhVO searchVO);
    
}
