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

import com.app.exterms.retirement.client.dto.Remt2000DTO;
import com.app.exterms.retirement.client.dto.Remt2100DTO;
import com.app.exterms.retirement.client.dto.Remt2200DTO;
import com.app.exterms.retirement.client.dto.Remt2300DTO;
import com.app.exterms.retirement.client.dto.Remt3100DTO;
import com.app.exterms.retirement.client.dto.RemtDays0100DTO;
import com.app.smrmf.core.msfmainapp.client.exceptions.MSFException;
import com.app.smrmf.core.msfmainapp.client.exceptions.ShowMessageBM;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.extjs.gxt.ui.client.data.PagingLoadResult;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Remt0100Service.gwt")
public interface Remt0100Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Remt0100ServiceAsync instance;
		public static Remt0100ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Remt0100Service.class);
			}
			return instance;
		}
	}
	
	public PagingLoadResult<ShowMessageBM> activityOnInsertRemt0100(List<BaseModel> mapModels,Remt2000DTO remt2000Dto) throws MSFException ;

	public Remt2000DTO activityOnReadRemt0100(Remt2000DTO remt2000Dto) throws MSFException ;
	
	public List<RemtDays0100DTO> activityOnPayrRemt0100Header(Remt2100DTO remt2100Dto) throws MSFException ;
	 
	public Remt3100DTO activityOnReadRemt0100ToRemt3100(Remt3100DTO remt3100Dto) throws MSFException ;
    
	public PagingLoadResult<ShowMessageBM> activityOnUpdateRemt0100Save(Remt2000DTO remt2000Dto) throws MSFException ;
	
	public Long activityOnDeleteRemt0100Save(Remt2000DTO remt2000Dto) throws MSFException ;
	
	public PagingLoadResult<ShowMessageBM> activityOnPayrCalc(List<Remt2000DTO> listRemt2000Dto) throws MSFException ; 
	
	
	public Long activityOnUpdateRemt0100ToPayrCalc(List<Remt2200DTO> listRemt2200dto) throws MSFException ;
	 
	public Long activityOnUpdateRemt0100ToPayrWfepCalc(List<Remt2200DTO> listRemt2200dto) throws MSFException ;
	
	public Long activityOnSaveRemt2300DDucData(List<Remt2300DTO> listRemt2300dto, ActionDatabase actionDatabase) throws MSFException ;
	  
 
//    /**
//     * REMT2000을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Remt2000VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertRemt2000(Remt2000VO vo) throws Exception;
//    
//    /**
//     * REMT2000을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Remt2000VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateRemt2000(Remt2000VO vo) throws Exception;
//    
//    /**
//     * REMT2000을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Remt2000VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteRemt2000(Remt2000VO vo) throws Exception;
//    
//    /**
//     * REMT2000을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Remt2000VO
//     * @return 조회한 REMT2000
//     * @exception Exception
//     */
//    Remt2000VO selectRemt2000(Remt2000VO vo) throws Exception;
//    
//    /**
//     * REMT2000 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT2000 목록
//     * @exception Exception
//     */
//    List selectRemt2000List(Remt2000SrhVO searchVO) throws Exception;
//    
//    /**
//     * REMT2000 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT2000 총 갯수
//     * @exception
//     */
//    int selectRemt2000ListTotCnt(Remt2000SrhVO searchVO);
//    
//    /**
//     * REMT2100을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Remt2100VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertRemt2100(Remt2100VO vo) throws Exception;
//    
//    /**
//     * REMT2100을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Remt2100VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateRemt2100(Remt2100VO vo) throws Exception;
//    
//    /**
//     * REMT2100을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Remt2100VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteRemt2100(Remt2100VO vo) throws Exception;
//    
//    /**
//     * REMT2100을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Remt2100VO
//     * @return 조회한 REMT2100
//     * @exception Exception
//     */
//    Remt2100VO selectRemt2100(Remt2100VO vo) throws Exception;
//    
//    /**
//     * REMT2100 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT2100 목록
//     * @exception Exception
//     */
//    List selectRemt2100List(Remt2100SrhVO searchVO) throws Exception;
//    
//    /**
//     * REMT2100 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT2100 총 갯수
//     * @exception
//     */
//    int selectRemt2100ListTotCnt(Remt2100SrhVO searchVO);
//    
//    /**
//     * REMT2200을 등록한다.
//     * @param vo - 등록할 정보가 담긴 Remt2200VO
//     * @return 등록 결과
//     * @exception Exception
//     */
//    String insertRemt2200(Remt2200VO vo) throws Exception;
//    
//    /**
//     * REMT2200을 수정한다.
//     * @param vo - 수정할 정보가 담긴 Remt2200VO
//     * @return void형
//     * @exception Exception
//     */
//    void updateRemt2200(Remt2200VO vo) throws Exception;
//    
//    /**
//     * REMT2200을 삭제한다.
//     * @param vo - 삭제할 정보가 담긴 Remt2200VO
//     * @return void형 
//     * @exception Exception
//     */
//    void deleteRemt2200(Remt2200VO vo) throws Exception;
//    
//    /**
//     * REMT2200을 조회한다.
//     * @param vo - 조회할 정보가 담긴 Remt2200VO
//     * @return 조회한 REMT2200
//     * @exception Exception
//     */
//    Remt2200VO selectRemt2200(Remt2200VO vo) throws Exception;
//    
//    /**
//     * REMT2200 목록을 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT2200 목록
//     * @exception Exception
//     */
//    List selectRemt2200List(Remt2200SrhVO searchVO) throws Exception;
//    
//    /**
//     * REMT2200 총 갯수를 조회한다.
//     * @param searchVO - 조회할 정보가 담긴 VO
//     * @return REMT2200 총 갯수
//     * @exception
//     */
//    int selectRemt2200ListTotCnt(Remt2200SrhVO searchVO);
}
