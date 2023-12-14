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

import com.app.exterms.prgm.client.dto.PrgmComPayr0480DTO;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PrgmComPayr0480ServiceAsync {
	
	 public void getPrgmComComboPayr0480List(PrgmComPayr0480DTO sysComPayr0480Dto, AsyncCallback<List<BaseModel>> callback);	
//	/**
//     * PAYR0480을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Payr0480VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertPayr0480(PrgmComPayr0480VO vo) throws Exception;
//    
//    /**
//     * PAYR0480을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Payr0480VO
//     * @return void형
//     * @exception Exception
//     */
//    void updatePayr0480(PrgmComPayr0480VO vo) throws Exception;
//    
//    /**
//     * PAYR0480을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Payr0480VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deletePayr0480(PrgmComPayr0480VO vo) throws Exception;
//    
//    /**
//     * PAYR0480을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Payr0480VO
//     * @return 조회한 PAYR0480
//     * @exception Exception
//     */
//    PrgmComPayr0480VO selectPayr0480(PrgmComPayr0480VO vo) throws Exception;
//    
//    /**
//     * PAYR0480 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return PAYR0480 목록
//     * @exception Exception
//     */
//    List selectPayr0480List(PrgmComPayr0480SrhVO searchVO) throws Exception;
//    
//    /**
//     * PAYR0480 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return PAYR0480 총 갯수
//     * @exception
//     */
//    int selectPayr0480ListTotCnt(PrgmComPayr0480SrhVO searchVO);
}
