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

import com.app.exterms.payroll.client.dto.Payr0490DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.extjs.gxt.ui.client.data.BaseModel;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface Payr5300ServiceAsync {
	public void activityOnPayr0490Insert(Payr0490DTO payr0490Dto,List<BaseModel> listModels, ActionDatabase actionDatabase, AsyncCallback<Long> callback);
    
	 public void activityOnPayr5300(Payr0490DTO payr0490Dto, ActionDatabase actionDatabase, AsyncCallback<Long> callback);

//	/**
//	 * PAYR0490을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0490VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0490(Payr0490VO vo);
//    
//    /**
//	 * PAYR0490을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0490VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0490(Payr0490VO vo);
//    
//    /**
//	 * PAYR0490을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0490VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0490(Payr0490VO vo);
//    
//    /**
//	 * PAYR0490을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0490VO
//	 * @return 조회한 PAYR0490
//	 * @exception Exception
//	 */
//	public Payr0490VO selectPayr0490(Payr0490VO vo);
//    
//    /**
//	 * PAYR0490 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0490 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0490List(Payr0490SrhVO searchVO);
//    
//    /**
//	 * PAYR0490 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0490 총 갯수
//	 * @exception
//	 */
}
