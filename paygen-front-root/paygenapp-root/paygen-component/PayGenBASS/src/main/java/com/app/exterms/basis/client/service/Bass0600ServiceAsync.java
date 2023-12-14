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

import java.util.List;

import com.app.exterms.basis.client.dto.Bass0600BM;
import com.app.exterms.basis.client.dto.Bass0600DTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Bass0600ServiceAsync {
	/**
	 * BASS0600을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0600VO
	 * @param callback the callback to return 등록 결과
	 * @exception Exception
	 */
    void insertBass0600(Bass0600DTO vo, AsyncCallback<String> callback);
    
    /**
	 * BASS0600을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0600VO
	 * @param callback the callback to return void형
	 * @exception Exception
	 */
    void updateBass0600(Bass0600DTO vo, AsyncCallback<Void> callback);
    
    /**
	 * BASS0600을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0600VO
	 * @param callback the callback to return void형 
	 * @exception Exception
	 */
    void deleteBass0600(Bass0600DTO vo, AsyncCallback<Void> callback);
    
    /**
	 * BASS0600을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0600VO
	 * @param callback the callback to return 조회한 BASS0600
	 * @exception Exception
	 */
    void selectBass0600(Bass0600DTO vo, AsyncCallback<Bass0600BM> callback);
    
    /**
	 * BASS0600 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @param callback the callback to return BASS0600 목록
	 * @exception Exception
	 */
    void selectBass0600List(Bass0600DTO searchVO, AsyncCallback<List<Bass0600BM>> callback);
    
    void selectBass0600ListTotCnt(Bass0600DTO searchVO, AsyncCallback<Integer> callback);
}
