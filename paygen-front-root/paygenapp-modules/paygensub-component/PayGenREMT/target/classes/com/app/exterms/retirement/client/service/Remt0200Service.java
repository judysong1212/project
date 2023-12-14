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
package com.app.exterms.retirement.client.service;

import java.util.List;

import com.app.exterms.retirement.client.dto.Remt3000DTO;
import com.app.exterms.retirement.client.dto.Remt3100DTO;
import com.app.exterms.retirement.client.dto.Remt3200DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Remt0200Service.gwt")
public interface Remt0200Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Remt0200ServiceAsync instance;
		public static Remt0200ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Remt0200Service.class);
			}
			return instance;
		}
	}
	
	
	public Long saveRemt0200ToRemt3200(List<Remt3200DTO> listRemt3200dto , ActionDatabase actionDatabase) throws MSFException ;
	
	public Long saveRemt0200ToDDlne(List<Remt3000DTO> listRemt3000dto , ActionDatabase actionDatabase) throws MSFException ;
	
	public Remt3100DTO activityOnReadRemt0200(Remt3100DTO remt3100Dto) throws MSFException ;
	 
	public Long activityOnupdateRemt0200Save(Remt3100DTO remt3100Dto) throws MSFException ;
	
	public PagingLoadResult<ShowMessageBM> activityOnPayrRemtCalc(List<Remt3000DTO> listRemt3000Dto) throws MSFException ; 
	
//	/**
//     * REMT0100을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Remt0100VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertRemt0100(Remt0100VO vo) throws Exception;
//    
//    /**
//     * REMT0100을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Remt0100VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateRemt0100(Remt0100VO vo) throws Exception;
//    
//    /**
//     * REMT0100을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Remt0100VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteRemt0100(Remt0100VO vo) throws Exception;
//    
//    /**
//     * REMT0100을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Remt0100VO
//     * @return 조회한 REMT0100
//     * @exception Exception
//     */
//    Remt0100VO selectRemt0100(Remt0100VO vo) throws Exception;
//    
//    /**
//     * REMT0100 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT0100 목록
//     * @exception Exception
//     */
//    List selectRemt0100List(Remt0100SrhVO searchVO) throws Exception;
//    
//    /**
//     * REMT0100 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT0100 총 갯수
//     * @exception
//     */
//    int selectRemt0100ListTotCnt(Remt0100SrhVO searchVO);
//    
//    /**
//     * REMT0110을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Remt0110VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertRemt0110(Remt0110VO vo) throws Exception;
//    
//    /**
//     * REMT0110을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Remt0110VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateRemt0110(Remt0110VO vo) throws Exception;
//    
//    /**
//     * REMT0110을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Remt0110VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteRemt0110(Remt0110VO vo) throws Exception;
//    
//    /**
//     * REMT0110을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Remt0110VO
//     * @return 조회한 REMT0110
//     * @exception Exception
//     */
//    Remt0110VO selectRemt0110(Remt0110VO vo) throws Exception;
//    
//    /**
//     * REMT0110 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT0110 목록
//     * @exception Exception
//     */
//    List selectRemt0110List(Remt0110SrhVO searchVO) throws Exception;
//    
//    /**
//     * REMT0110 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT0110 총 갯수
//     * @exception
//     */
//    int selectRemt0110ListTotCnt(Remt0110SrhVO searchVO);
//    
//    /**
//     * REMT3000을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Remt3000VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertRemt3000(Remt3000VO vo) throws Exception;
//    
//    /**
//     * REMT3000을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Remt3000VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateRemt3000(Remt3000VO vo) throws Exception;
//    
//    /**
//     * REMT3000을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Remt3000VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteRemt3000(Remt3000VO vo) throws Exception;
//    
//    /**
//     * REMT3000을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Remt3000VO
//     * @return 조회한 REMT3000
//     * @exception Exception
//     */
//    Remt3000VO selectRemt3000(Remt3000VO vo) throws Exception;
//    
//    /**
//     * REMT3000 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT3000 목록
//     * @exception Exception
//     */
//    List selectRemt3000List(Remt3000SrhVO searchVO) throws Exception;
//    
//    /**
//     * REMT3000 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT3000 총 갯수
//     * @exception
//     */
//    int selectRemt3000ListTotCnt(Remt3000SrhVO searchVO);
//    
//    /**
//     * REMT3100을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Remt3100VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertRemt3100(Remt3100VO vo) throws Exception;
//    
//    /**
//     * REMT3100을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Remt3100VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateRemt3100(Remt3100VO vo) throws Exception;
//    
//    /**
//     * REMT3100을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Remt3100VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteRemt3100(Remt3100VO vo) throws Exception;
//    
//    /**
//     * REMT3100을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Remt3100VO
//     * @return 조회한 REMT3100
//     * @exception Exception
//     */
//    Remt3100VO selectRemt3100(Remt3100VO vo) throws Exception;
//    
//    /**
//     * REMT3100 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT3100 목록
//     * @exception Exception
//     */
//    List selectRemt3100List(Remt3100SrhVO searchVO) throws Exception;
//    
//    /**
//     * REMT3100 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT3100 총 갯수
//     * @exception
//     */
//    int selectRemt3100ListTotCnt(Remt3100SrhVO searchVO);
//    
//    /**
//     * REMT3200을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Remt3200VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertRemt3200(Remt3200VO vo) throws Exception;
//    
//    /**
//     * REMT3200을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Remt3200VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateRemt3200(Remt3200VO vo) throws Exception;
//    
//    /**
//     * REMT3200을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Remt3200VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteRemt3200(Remt3200VO vo) throws Exception;
//    
//    /**
//     * REMT3200을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Remt3200VO
//     * @return 조회한 REMT3200
//     * @exception Exception
//     */
//    Remt3200VO selectRemt3200(Remt3200VO vo) throws Exception;
//    
//    /**
//     * REMT3200 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT3200 목록
//     * @exception Exception
//     */
//    List selectRemt3200List(Remt3200SrhVO searchVO) throws Exception;
//    
//    /**
//     * REMT3200 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT3200 총 갯수
//     * @exception
//     */
//    int selectRemt3200ListTotCnt(Remt3200SrhVO searchVO);
//    
//    /**
//     * REMT3500을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Remt3500VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertRemt3500(Remt3500VO vo) throws Exception;
//    
//    /**
//     * REMT3500을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Remt3500VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateRemt3500(Remt3500VO vo) throws Exception;
//    
//    /**
//     * REMT3500을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Remt3500VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteRemt3500(Remt3500VO vo) throws Exception;
//    
//    /**
//     * REMT3500을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Remt3500VO
//     * @return 조회한 REMT3500
//     * @exception Exception
//     */
//    Remt3500VO selectRemt3500(Remt3500VO vo) throws Exception;
//    
//    /**
//     * REMT3500 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT3500 목록
//     * @exception Exception
//     */
//    List selectRemt3500List(Remt3500SrhVO searchVO) throws Exception;
//    
//    /**
//     * REMT3500 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT3500 총 갯수
//     * @exception
//     */
//    int selectRemt3500ListTotCnt(Remt3500SrhVO searchVO);
//    
//    /**
//     * REMT3520을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Remt3520VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertRemt3520(Remt3520VO vo) throws Exception;
//    
//    /**
//     * REMT3520을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Remt3520VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateRemt3520(Remt3520VO vo) throws Exception;
//    
//    /**
//     * REMT3520을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Remt3520VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteRemt3520(Remt3520VO vo) throws Exception;
//    
//    /**
//     * REMT3520을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Remt3520VO
//     * @return 조회한 REMT3520
//     * @exception Exception
//     */
//    Remt3520VO selectRemt3520(Remt3520VO vo) throws Exception;
//    
//    /**
//     * REMT3520 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT3520 목록
//     * @exception Exception
//     */
//    List selectRemt3520List(Remt3520SrhVO searchVO) throws Exception;
//    
//    /**
//     * REMT3520 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT3520 총 갯수
//     * @exception
//     */
//    int selectRemt3520ListTotCnt(Remt3520SrhVO searchVO);
//    /**
//     * REMT3550을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Remt3550VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertRemt3550(Remt3550VO vo) throws Exception;
//    
//    /**
//     * REMT3550을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Remt3550VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateRemt3550(Remt3550VO vo) throws Exception;
//    
//    /**
//     * REMT3550을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Remt3550VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteRemt3550(Remt3550VO vo) throws Exception;
//    
//    /**
//     * REMT3550을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Remt3550VO
//     * @return 조회한 REMT3550
//     * @exception Exception
//     */
//    Remt3550VO selectRemt3550(Remt3550VO vo) throws Exception;
//    
//    /**
//     * REMT3550 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT3550 목록
//     * @exception Exception
//     */
//    List selectRemt3550List(Remt3550SrhVO searchVO) throws Exception;
//    
//    /**
//     * REMT3550 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT3550 총 갯수
//     * @exception
//     */
//    int selectRemt3550ListTotCnt(Remt3550SrhVO searchVO);
}
