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

import com.app.exterms.payroll.client.dto.Payr0410DTO;
import com.app.exterms.payroll.client.dto.Payr0415DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Payr1500ServiceAsync {
	public void activityOnPayr0415Insert(Payr0415DTO payr0415Dto,List<BaseModel> listModels, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	public void activityOnPayr0410Insert(Payr0410DTO payr0410Dto,List<BaseModel> listModels, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
    
	
	public void activityOnPayr1500BfToNew(Payr0415DTO payr0415Dto,List<BaseModel> listModels, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
    
	public void activityOnPayr0415Save(Payr0415DTO payr0415Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
	//payr410 data update 
	public void activityOnPayr0410DetailFormSave(Payr0410DTO payr0410Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	 
	public void activityOnPayr0415Copy(List<BaseModel> list, BaseModel bm, AsyncCallback<Long> asyncCallback);
	 
	public void activityOnPayr150002ToPayr0410Insert(List<BaseModel> list, Payr0410DTO payr0410Dto, AsyncCallback<Long> asyncCallback);
	/**
	 * PAYR0415을 등록한다.
	 * @param vo - 등록할 정보가 담긴 Payr0415VO
	 * @return 등록 결과
	 * @exception Exception
	 */
//    String insertPayr0415(Payr0415VO vo) throws Exception;
//    
//    /**
//	 * PAYR0415을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0415VO
//	 * @return void형
//	 * @exception Exception
//	 */
//    void updatePayr0415(Payr0415VO vo) throws Exception;
//    
//    /**
//	 * PAYR0415을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0415VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//    void deletePayr0415(Payr0415VO vo) throws Exception;
//    
//    /**
//	 * PAYR0415을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0415VO
//	 * @return 조회한 PAYR0415
//	 * @exception Exception
//	 */
//    Payr0415VO selectPayr0415(Payr0415VO vo) throws Exception;
//    
//    /**
//	 * PAYR0415 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0415 목록
//	 * @exception Exception
//	 */
//    List selectPayr0415List(Payr0415SrhVO searchVO) throws Exception;
//    
//    /**
//	 * PAYR0415 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0415 총 갯수
//	 * @exception
//	 */
//    int selectPayr0415ListTotCnt(Payr0415SrhVO searchVO);
//    
//
//	/**
//	 * PAYR0410을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0410VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0410(Payr0410VO vo);
//    
//    /**
//	 * PAYR0410을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0410VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0410(Payr0410VO vo);
//    
//    /**
//	 * PAYR0410을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0410VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0410(Payr0410VO vo);
//    
//    /**
//	 * PAYR0410을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0410VO
//	 * @return 조회한 PAYR0410
//	 * @exception Exception
//	 */
//	public Payr0410VO selectPayr0410(Payr0410VO vo);
//    
//    /**
//	 * PAYR0410 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0410 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0410List(Payr0410SrhVO searchVO);
//    
//    /**
//	 * PAYR0410 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0410 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0410ListTotCnt(Payr0410SrhVO searchVO);
}
