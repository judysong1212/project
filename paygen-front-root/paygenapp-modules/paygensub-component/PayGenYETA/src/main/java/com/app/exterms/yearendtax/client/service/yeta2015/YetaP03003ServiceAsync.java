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
package com.app.exterms.yearendtax.client.service.yeta2015;

import java.util.List;

import com.app.exterms.yearendtax.client.dto.yeta2015.Yeta3180DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface YetaP03003ServiceAsync {
	
	/** 기부금내역 등록 팝업 수정 및 삭제 **/
	public void activityOnYetaP03003ToYeta3180(List<Yeta3180DTO> listYeta3180dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback) ;
	
	
	
//	   /**
//     * REMT1000을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Remt1000VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertRemt1000(Remt1000VO vo) throws Exception;
//    
//    /**
//     * REMT1000을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Remt1000VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateRemt1000(Remt1000VO vo) throws Exception;
//    
//    /**
//     * REMT1000을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Remt1000VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteRemt1000(Remt1000VO vo) throws Exception;
//    
//    /**
//     * REMT1000을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Remt1000VO
//     * @return 조회한 REMT1000
//     * @exception Exception
//     */
//    Remt1000VO selectRemt1000(Remt1000VO vo) throws Exception;
//    
//    /**
//     * REMT1000 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT1000 목록
//     * @exception Exception
//     */
//    List selectRemt1000List(Remt1000SrhVO searchVO) throws Exception;
//    
//    /**
//     * REMT1000 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT1000 총 갯수
//     * @exception
//     */
//    int selectRemt1000ListTotCnt(Remt1000SrhVO searchVO);
}