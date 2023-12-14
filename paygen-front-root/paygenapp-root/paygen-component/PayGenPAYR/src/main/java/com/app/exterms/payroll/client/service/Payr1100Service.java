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

import com.app.exterms.payroll.client.dto.Payr0100DTO;
import com.app.smrmf.core.msfmainapp.client.utils.MSFFormPanel.ActionDatabase;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("Payr1100Service.gwt")
public interface Payr1100Service extends RemoteService {
	/**
	 * Utility class for simplifying access to the instance of async service.
	 */
	public static class Util {
		private static Payr1100ServiceAsync instance;
		public static Payr1100ServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(Payr1100Service.class);
			}
			return instance;
		}
	}
	
	/** 간이소득세액이관 **/
	public Long payr0100Transfer(Payr0100DTO payr0100Dto);
	
	/** 간이소득세액 삭제 **/
	public Long activityOnPayr1100(Payr0100DTO payr0100Dto, ActionDatabase actionDatabase);
	
//	/**
//	 * PAYR0100을 등록한다.
//	 * @param vo - 등록할 정보가 담긴 Payr0100VO
//	 * @return 등록 결과
//	 * @exception Exception
//	 */
//	public String insertPayr0100(Payr0100VO vo);
//    
//    /**
//	 * PAYR0100을 수정한다.
//	 * @param vo - 수정할 정보가 담긴 Payr0100VO
//	 * @return void형
//	 * @exception Exception
//	 */
//	public void updatePayr0100(Payr0100VO vo);
//    
//    /**
//	 * PAYR0100을 삭제한다.
//	 * @param vo - 삭제할 정보가 담긴 Payr0100VO
//	 * @return void형 
//	 * @exception Exception
//	 */
//	public void deletePayr0100(Payr0100VO vo);
//    
//    /**
//	 * PAYR0100을 조회한다.
//	 * @param vo - 조회할 정보가 담긴 Payr0100VO
//	 * @return 조회한 PAYR0100
//	 * @exception Exception
//	 */
//	public Payr0100VO selectPayr0100(Payr0100VO vo);
//    
//    /**
//	 * PAYR0100 목록을 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0100 목록
//	 * @exception Exception
//	 */
//	public List selectPayr0100List(Payr0100SrhVO searchVO);
//    
//    /**
//	 * PAYR0100 총 갯수를 조회한다.
//	 * @param searchVO - 조회할 정보가 담긴 VO
//	 * @return PAYR0100 총 갯수
//	 * @exception
//	 */
//	public int selectPayr0100ListTotCnt(Payr0100SrhVO searchVO);
	
 
}
