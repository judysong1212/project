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

import com.app.smrmf.core.msfmainapp.client.admin.dto.Bord0300DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Bord0300ServiceAsync {
	public void activityOnBoard0300(Bord0300DTO bord0300Dto, ActionDatabase actionDatabase, AsyncCallback<Bord0300DTO> callback);
   
    
//	/**
//	 * BORD0300을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Bord0300VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertBord0300(Bord0300VO vo);
//    
//    /**
//	 * BORD0300을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Bord0300VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    public void updateBord0300(Bord0300VO vo);
//    
//    /**
//	 * BORD0300을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Bord0300VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    public void deleteBord0300(Bord0300VO vo);
//    
//    /**
//	 * BORD0300을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Bord0300VO
//	 * @return 조회한 BORD0300
//	 * @exception Exception
//	 */
//    public Bord0300VO selectBord0300(Bord0300VO vo);
//    
//    /**
//	 * BORD0300 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BORD0300 목록
//	 * @exception Exception
//	 */
//    public List selectBord0300List(Bord0300SrhVO searchVO);
//    
//    /**
//	 * BORD0300 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BORD0300 총 갯수
//	 * @exception
//	 */
//    public int selectBord0300ListTotCnt(Bord0300SrhVO searchVO);
}
