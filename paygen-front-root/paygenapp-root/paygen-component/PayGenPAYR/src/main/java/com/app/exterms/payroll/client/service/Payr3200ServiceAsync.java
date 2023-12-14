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

import com.app.exterms.payroll.client.dto.Payr0520DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Payr3200ServiceAsync {
	public void activityOnPayr3200(List<Payr0520DTO> listPayr0520dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
	
//	/**
//	 * PAYR0200을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0200VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0200(Payr0200VO vo);
//    
//    /**
//	 * PAYR0200을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0200VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0200(Payr0200VO vo);
//    
//    /**
//	 * PAYR0200을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0200VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0200(Payr0200VO vo);
//    
//    /**
//	 * PAYR0200을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0200VO
//	 * @return 조회한 PAYR0200
//	 * @exception Exception
//	 */
//	public Payr0200VO selectPayr0200(Payr0200VO vo);
//    
//    /**
//	 * PAYR0200 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0200 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0200List(Payr0200SrhVO searchVO);
//    
//    /**
//	 * PAYR0200 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0200 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0200ListTotCnt(Payr0200SrhVO searchVO);
}
