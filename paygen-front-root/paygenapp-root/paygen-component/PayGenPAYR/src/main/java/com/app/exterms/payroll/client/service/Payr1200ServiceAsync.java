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
package com.app.exterms.payroll.client.service;

import java.util.List;

import com.app.exterms.payroll.client.dto.Payr0400DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Payr1200ServiceAsync {
	public void activityOnPayr0400Insert(List<BaseModel> listModels, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
    public void activityOnPayr0400Save(Payr0400DTO payr0400Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
     
    public void createPyspLogSvcYrNumCd(Payr0400DTO payr0400Dto, AsyncCallback<Long> callback);
	  
    public void deletePayr0430(List<BaseModel> listModels, AsyncCallback<Long> callback);
    
   // public void activityOnPayr0400InsertCheck(List<BaseModel> listModels, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
//	/**
//	 * PAYR0400을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0400VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0400(Payr0400VO vo);
//    
//    /**
//	 * PAYR0400을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0400VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0400(Payr0400VO vo);
//    
//    /**
//	 * PAYR0400을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0400VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0400(Payr0400VO vo);
//    
//    /**
//	 * PAYR0400을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0400VO
//	 * @return 조회한 PAYR0400
//	 * @exception Exception
//	 */
//	public Payr0400VO selectPayr0400(Payr0400VO vo);
//    
//    /**
//	 * PAYR0400 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0400 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0400List(Payr0400SrhVO searchVO);
//    
//    /**
//	 * PAYR0400 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0400 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0400ListTotCnt(Payr0400SrhVO searchVO);
//	
//
//	/**
//	 * PAYR0430을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0430VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0430(Payr0430VO vo);
//    
//    /**
//	 * PAYR0430을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0430VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0430(Payr0430VO vo);
//    
//    /**
//	 * PAYR0430을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0430VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0430(Payr0430VO vo);
//    
//    /**
//	 * PAYR0430을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0430VO
//	 * @return 조회한 PAYR0430
//	 * @exception Exception
//	 */
//	public Payr0430VO selectPayr0430(Payr0430VO vo);
//    
//    /**
//	 * PAYR0430 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0430 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0430List(Payr0430SrhVO searchVO);
//    
//    /**
//	 * PAYR0430 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0430 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0430ListTotCnt(Payr0430SrhVO searchVO);
}
