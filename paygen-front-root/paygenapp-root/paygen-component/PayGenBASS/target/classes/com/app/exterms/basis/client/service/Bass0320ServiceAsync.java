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
package com.app.exterms.basis.client.service;

import com.app.exterms.basis.client.dto.Bass0320DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Bass0320ServiceAsync {
	
	public void saveBass0320(Bass0320DTO dto,ActionDatabase actionDatabase, AsyncCallback<Long> callback );
	
	
//	/**
//	 * BASS0350을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Bass0350VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    String insertBass0350(Bass0350VO vo) throws Exception;
//    
//    /**
//	 * BASS0350을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Bass0350VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    void updateBass0350(Bass0350VO vo) throws Exception;
//    
//    /**
//	 * BASS0350을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Bass0350VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    void deleteBass0350(Bass0350VO vo) throws Exception;
//    
//    /**
//	 * BASS0350을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Bass0350VO
//	 * @return 조회한 BASS0350
//	 * @exception Exception
//	 */
//    Bass0350VO selectBass0350(Bass0350VO vo) throws Exception;
//    
//    /**
//	 * BASS0350 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BASS0350 목록
//	 * @exception Exception
//	 */
//    List selectBass0350List(Bass0350SrhVO searchVO) throws Exception;
//    
//    /**
//	 * BASS0350 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BASS0350 총 갯수
//	 * @exception
//	 */
//    int selectBass0350ListTotCnt(Bass0350SrhVO searchVO);
}
