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
package com.app.exterms.yearendtax.client.service.yeta2016;

import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1000BM;
import com.app.exterms.yearendtax.client.dto.yeta2016.Ye16Ta1005BM;
import com.google.gwt.user.client.rpc.AsyncCallback;


public interface Yeta1400ServiceAsync {
	
	/** 전자신고기본정보 조회 **/
	public void getYeta1400List(Ye16Ta1000BM yeta1000Bm, AsyncCallback<Ye16Ta1005BM> callback);
	
	/** 정산마감 **/
	public void finishOnYeta1000(Ye16Ta1000BM yeta1000Bm, AsyncCallback<Long> callback);
	
	/** 전자신고기본정보 수정 **/
	public void updateYeta1000(Ye16Ta1005BM yeta1000Bm, AsyncCallback<Long> callback);
	
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
