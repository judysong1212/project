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

import com.app.exterms.payroll.client.dto.Payr0485DTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Payr1450ServiceAsync {
//	public void activityOnPayr1450Save(List<Payr0470DTO>  listPayr0470dto, AsyncCallback<Long> callback);
	     
	    
//	   public void activityOnPayr1450Delete(List<BaseModel> listModels, AsyncCallback<Long> callback);
		     
	public void payr1450Insert(Payr0485DTO payr0485Dto, AsyncCallback<Long> callback);
	
	public void updatePayr0485(Payr0485DTO payr0485Dto, AsyncCallback<Long> callback);  
	
	public void payrUpdate0485Yn(Payr0485DTO payr0485Dto, AsyncCallback<Long> callback);
	
	public void payrDelte0485(Payr0485DTO payr0485Dto, AsyncCallback<Long> callback);
	

//	/**
//	 * PAYR0470을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0470VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0470(Payr0470VO vo);
//    
//    /**
//	 * PAYR0470을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0470VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0470(Payr0470VO vo);
//    
//    /**
//	 * PAYR0470을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0470VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0470(Payr0470VO vo);
//    
//    /**
//	 * PAYR0470을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0470VO
//	 * @return 조회한 PAYR0470
//	 * @exception Exception
//	 */
//	public Payr0470VO selectPayr0470(Payr0470VO vo);
//    
//    /**
//	 * PAYR0470 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0470 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0470List(Payr0470SrhVO searchVO);
//    
//    /**
//	 * PAYR0470 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0470 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0470ListTotCnt(Payr0470SrhVO searchVO);
	   
}
