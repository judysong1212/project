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
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Bass0600Service.gwt")
public interface Bass0600Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Bass0600ServiceAsync instance;
		public static Bass0600ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Bass0600Service.class);
			}
			return instance;
		}
	}
	
	/**
	 * BASS0600을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0600VO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertBass0600(Bass0600DTO vo) throws Exception;
    
    /**
	 * BASS0600을 수정한다.
	 * @param vo - 수정할 정보가 담긴 Bass0600VO
	 * @return void형
	 * @exception Exception
	 */
    void updateBass0600(Bass0600DTO vo) throws Exception;
    
    /**
	 * BASS0600을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 Bass0600VO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteBass0600(Bass0600DTO vo) throws Exception;
    
    /**
	 * BASS0600을 조회한다.
	 * @param vo - 조회할 정보가 담긴 Bass0600VO
	 * @return 조회한 BASS0600
	 * @exception Exception
	 */
    Bass0600BM selectBass0600(Bass0600DTO vo) throws Exception;
    
    /**
	 * BASS0600 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BASS0600 목록
	 * @exception Exception
	 */
    List<Bass0600BM> selectBass0600List(Bass0600DTO searchVO) throws Exception;
    
    /**
	 * BASS0600 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return BASS0600 총 갯수
	 * @exception
	 */
    int selectBass0600ListTotCnt(Bass0600DTO searchVO) throws Exception;
}
