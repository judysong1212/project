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

import com.app.exterms.basis.client.dto.Bass0200DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Bass0200ServiceAsync {
	public void activityOnBass0200(Bass0200DTO bass0200Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
//	/**
//	 * BASS0200을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Bass0200VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//    public String insertBass0200(Bass0200DTO bass0200Dto);
//    
//    /**
//	 * BASS0200을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Bass0200VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    public void updateBass0200(Bass0200DTO bass0200Dto);
//    
//    /**
//	 * BASS0200을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Bass0200VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    public void deleteBass0200(Bass0200DTO bass0200Dto) ;
//    
//    /**
//	 * BASS0200을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Bass0200VO
//	 * @return 조회한 BASS0200
//	 * @exception Exception
//	 */
//    public Bass0200BM selectBass0200(Bass0200DTO bass0200Dto) ;
//    
//    /**
//	 * BASS0200 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BASS0200 목록
//	 * @exception Exception
//	 */
//    public List<Bass0200BM> selectBass0200List(Bass0200DTO bass0200Dto) ;
//     
//    /**
//	 * BASS0200 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BASS0200 총 갯수
//	 * @exception
//	 */
//    public int selectBass0200ListTotCnt(Bass0200DTO bass0200Dto);
    
}
