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
package com.app.exterms.prgm.client.service;

import java.util.List;

import com.app.exterms.prgm.client.dto.PrgmComBass0150DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PrgmComBass0150ServiceAsync {
	public void getPrgmComComboBass0150List(PrgmComBass0150DTO sysComBass0150Dto, AsyncCallback<List<BaseModel>> callback);
	/**
	 * BASS0150을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Bass0150VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//	public String insertBass0150(PrgmComBass0150VO vo) ;
//    
//    /**
//	 * BASS0150을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Bass0150VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updateBass0150(PrgmComBass0150VO vo) ;
//    
//    /**
//	 * BASS0150을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Bass0150VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deleteBass0150(PrgmComBass0150VO vo) ;
//    
//    /**
//	 * BASS0150을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Bass0150VO
//	 * @return 조회한 BASS0150
//	 * @exception Exception
//	 */
//	public PrgmComBass0150VO selectBass0150(PrgmComBass0150VO vo) ;
//    
//    /**
//	 * BASS0150 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BASS0150 목록
//	 * @exception Exception
//	 */
//	public List selectBass0150List(PrgmComBass0150SrhVO searchVO) ;
//    
//    /**
//	 * BASS0150 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return BASS0150 총 갯수
//	 * @exception
//	 */
//	public int selectBass0150ListTotCnt(PrgmComBass0150SrhVO searchVO);
}
