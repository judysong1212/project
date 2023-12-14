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

import com.app.exterms.payroll.client.dto.Payr0460DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Payr5500Service.gwt")
public interface Payr5500Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Payr5500ServiceAsync instance;
		public static Payr5500ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Payr5500Service.class);
			}
			return instance;
		}
	}

	public Long activityOnPayr5500(List<Payr0460DTO> listPayr0460dto, ActionDatabase actionDatabase);

//	/**
//	 * PAYR0450을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0450VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0450(Payr0450VO vo);
//    
//    /**
//	 * PAYR0450을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0450VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0450(Payr0450VO vo);
//    
//    /**
//	 * PAYR0450을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0450VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0450(Payr0450VO vo);
//    
//    /**
//	 * PAYR0450을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0450VO
//	 * @return 조회한 PAYR0450
//	 * @exception Exception
//	 */
//	public Payr0450VO selectPayr0450(Payr0450VO vo);
//    
//    /**
//	 * PAYR0450 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0450 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0450List(Payr0450SrhVO searchVO);
//    
//    /**
//	 * PAYR0450 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0450 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0450ListTotCnt(Payr0450SrhVO searchVO);
}
