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
package com.app.smrmf.ssocom.service;

import java.util.List;

import com.app.smrmf.sysm.server.vo.system.SsoxUserSrhVO;
import com.app.smrmf.sysm.server.vo.system.SsoxUserVO;
 
public interface SsoxSmrmfService  {

	/**
	 * SSOX_USER을 등록한다.
	 * @param vo - 등록할 정보가 담긴 SsoxUserVO
	 * @return 등록 결과
	 * @exception Exception
	 */
    String insertSsoxUser(SsoxUserVO vo) throws Exception;
    
    /**
	 * SSOX_USER을 수정한다.
	 * @param vo - 수정할 정보가 담긴 SsoxUserVO
	 * @return void형
	 * @exception Exception
	 */
    void updateSsoxUser(SsoxUserVO vo) throws Exception;
    
    /**
	 * SSOX_USER을 삭제한다.
	 * @param vo - 삭제할 정보가 담긴 SsoxUserVO
	 * @return void형 
	 * @exception Exception
	 */
    void deleteSsoxUser(SsoxUserVO vo) throws Exception;
    
    /**
	 * SSOX_USER을 조회한다.
	 * @param vo - 조회할 정보가 담긴 SsoxUserVO
	 * @return 조회한 SSOX_USER
	 * @exception Exception
	 */
    SsoxUserVO selectSsoxUser(SsoxUserVO vo) throws Exception;
    
    /**
	 * SSOX_USER 목록을 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SSOX_USER 목록
	 * @exception Exception
	 */
    List selectSsoxUserList(SsoxUserSrhVO searchVO) throws Exception;
    
    /**
	 * SSOX_USER 총 갯수를 조회한다.
	 * @param searchVO - 조회할 정보가 담긴 VO
	 * @return SSOX_USER 총 갯수
	 * @exception
	 */
    int selectSsoxUserListTotCnt(SsoxUserSrhVO searchVO);
    
    
    /**
 	 * SSOX_USER 목록을 조회한다.
 	 * @param searchVO - 조회할 정보가 담긴 VO
 	 * @return SSOX_USER 목록
 	 * @exception Exception
 	 */
     List selectMagicSsoUserList(SsoxUserSrhVO searchVO) throws Exception;
     
     /**
 	 * SSOX_USER 총 갯수를 조회한다.
 	 * @param searchVO - 조회할 정보가 담긴 VO
 	 * @return SSOX_USER 총 갯수
 	 * @exception
 	 */
     int selectMagicSsoUserListTotCnt(SsoxUserSrhVO searchVO);
     
    
    
}
